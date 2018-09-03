package com.baidu.tieba.frs.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.k;
import com.baidu.adp.widget.ListView.n;
import com.baidu.e.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a.d;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsDynamicFragment extends BaseFragment implements BdListView.e, a.InterfaceC0062a, UserIconBox.b, VoiceManager.c, aj, FrsCommonImageLayout.c {
    private String dmg;
    private VoiceManager dmn;
    private FrsDynamicModelController dsH;
    protected c dsI;
    private String dsK;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int dsG = 3;
    private b dsJ = new b();
    private int mPn = 1;
    private final CustomMessageListener acr = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.dsI != null) {
                FrsDynamicFragment.this.dsI.startPullRefresh();
            }
        }
    };
    private CustomMessageListener dni = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.AP() != null) {
                        FrsDynamicFragment.this.AP().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Jc()) {
                        FrsDynamicFragment.this.fY(false);
                    } else if (FrsDynamicFragment.this.dsI != null) {
                        FrsDynamicFragment.this.dsI.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dqr = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.dsH.AB()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.AP() != null) {
                        FrsDynamicFragment.this.AP().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Jc()) {
                        FrsDynamicFragment.this.fY(false);
                    } else if (FrsDynamicFragment.this.dsI != null) {
                        FrsDynamicFragment.this.dsI.startPullRefresh();
                    }
                }
            }
        }
    };
    private final g.b byv = new g.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void aT(boolean z) {
            if (j.jE()) {
                d.QN().iA("page_frs_dynamic");
                FrsDynamicFragment.this.fY(true);
                return;
            }
            FrsDynamicFragment.this.dsI.cq(false);
        }
    };
    private n dnB = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.vT() == null || bbVar.vT().getGroup_id() == 0 || com.baidu.tbadk.core.util.bb.aU(FrsDynamicFragment.this.getActivity())) {
                    if (bbVar.vM() != 1 || com.baidu.tbadk.core.util.bb.aU(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.uc(bbVar.getId())) {
                            readThreadHistory.ub(bbVar.getId());
                            if (FrsDynamicFragment.this.dsI != null) {
                                FrsDynamicFragment.this.dsI.avj();
                            }
                        }
                        boolean z = false;
                        final String vr = bbVar.vr();
                        if (vr != null && !vr.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vr);
                                    yVar.yM().zK().mIsNeedAddCommenParam = false;
                                    yVar.yM().zK().mIsUseCurrentBDUSS = false;
                                    yVar.yp();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.ve() == 2 && !tid.startsWith("pb:")) {
                            az.zI().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsDynamicFragment.this.dmg, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dnv = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void kt(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.dsI.avj();
                    return;
                case 3:
                    FrsDynamicFragment.this.dsI.cq(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.dsI.cq(false);
            if (FrsDynamicFragment.this.dsH.aww() != null) {
                FrsDynamicFragment.this.dsJ = FrsDynamicFragment.this.dsH.aww();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.dsJ.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (w.z(FrsDynamicFragment.this.dsJ.threadList)) {
                    FrsDynamicFragment.this.dsI.Uq();
                } else {
                    FrsDynamicFragment.this.dsI.Up();
                }
            } else {
                FrsDynamicFragment.this.dsI.Uo();
            }
            if (i == 4) {
                FrsDynamicFragment.this.dsI.P(FrsDynamicFragment.this.dsJ.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.dsI.avj();
                    break;
                case 2:
                    FrsDynamicFragment.this.dsI.avj();
                    break;
            }
            FrsDynamicFragment.this.hideLoadingView();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.aux();
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private CustomMessageListener axF = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsDynamicFragment.this.dsK = bbVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.dsK) && bbVar.uW() != null) {
                    FrsDynamicFragment.this.kN(bbVar.uW().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.dsH = new FrsDynamicModelController(this);
        this.dsH.setForumId(Long.parseLong(this.forumId));
        this.dmn = getVoiceManager();
        this.dmn.onCreate(getPageContext());
        registerListener(this.acr);
        registerListener(this.axF);
        registerListener(this.dni);
        registerListener(this.dqr);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(f.h.frs_dynamic_activity, (ViewGroup) null);
        this.dsI = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dmg = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dmg = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.dsI.setOnAdapterItemClickListener(this.dnB);
        this.dsI.a(this.byv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dsI != null) {
            this.dsI.avj();
        }
        this.dmn = getVoiceManager();
        this.dmn.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dmn = getVoiceManager();
        this.dmn.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dsG == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new an("c13008").ae(ImageViewerConfig.FORUM_ID, this.forumId).r("obj_type", 1));
        if (j.jE()) {
            fY(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY(boolean z) {
        auA();
        Un();
        if (!z) {
            Un();
            showLoadingView();
        }
        this.dsH.awv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aux() {
        auA();
        try {
            if (this.dsJ != null) {
                this.dsI.agP();
                if (this.dsJ.threadList != null) {
                    this.dsI.P(this.dsJ.threadList);
                    this.dsI.avj();
                    this.dsI.awx().setFromCDN(true);
                    this.dsI.setListViewSelection(aE(this.dsH.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aE(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void auA() {
        this.dmn = getVoiceManager();
        this.dmn.stopPlay();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ul() {
        if (this.dsI != null) {
            atX();
            this.dsI.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atX() {
        if (this.dsI != null && this.dsI.getListView() != null) {
            this.dsI.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dsI != null && this.dsI.getListView() != null) {
            this.dsI.getListView().stopScroll();
        }
        TE();
        if (l.jV() && this.mHasMore && !this.dsH.AB()) {
            this.mPn++;
            h hVar = (h) w.d(this.dsJ.threadList, w.y(this.dsJ.threadList) - 1);
            if (hVar instanceof bb) {
                this.dsH.bI(com.baidu.adp.lib.g.b.c(((bb) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb mE;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dsI.awx().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mE = this.dsJ.mE(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.dsJ.threadList.remove(mE);
                        if (w.z(this.dsJ.threadList)) {
                            this.dsJ.threadList.add(new m());
                        }
                        this.dsI.avj();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> atL() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).atL();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmn == null) {
            this.dmn = VoiceManager.instance();
        }
        return this.dmn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView AP() {
        if (this.dsI == null) {
            return null;
        }
        return this.dsI.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AQ() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).AQ();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (AP() == null) {
            return null;
        }
        return AP().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dsG != 3 || this.dsI != null) {
            this.dsG = i;
            super.onChangeSkinType(i);
            if (this.dsI != null) {
                this.dsI.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.dsI.fR(false);
        showLoadingView(this.dsI.awb(), true, getResources().getDimensionPixelSize(f.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dsI.fR(true);
        hideLoadingView(this.dsI.awb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dsI.fR(false);
        this.dsI.awc().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dsI.Uq();
        this.dsI.getListView().getData().clear();
        this.dsI.avj();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jk();
            this.mRefreshView.ff(getResources().getDimensionPixelSize(f.e.ds_102));
            this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hk(getPageContext().getResources().getString(f.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hk(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dsI.awb(), true);
    }

    private void Un() {
        this.dsI.fR(true);
        this.dsI.awc().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jc()) {
            this.mRefreshView.Q(this.dsI.awb());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            fY(false);
        }
    }

    private void TE() {
        if (!this.mHasMore) {
            if (w.z(this.dsJ.threadList)) {
                this.dsI.Uq();
                return;
            } else {
                this.dsI.Up();
                return;
            }
        }
        this.dsI.Uo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN(int i) {
        if (this.dsJ.threadList != null) {
            Iterator<h> it = this.dsJ.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dsK)) {
                        a(bbVar, i);
                        this.dsK = null;
                        break;
                    }
                }
            }
            this.dsI.awx().setData(this.dsJ.threadList);
            this.dsI.awx().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData uW = bbVar.uW();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (uW == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.uW().getUser().add(0, metaData);
                bbVar.uW().setNum(bbVar.uW().getNum() + 1);
                bbVar.uW().setIsLike(i);
            }
        } else if (bbVar.uW() != null) {
            bbVar.uW().setIsLike(i);
            bbVar.uW().setNum(bbVar.uW().getNum() - 1);
            ArrayList<MetaData> user = bbVar.uW().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.uW().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aN(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(f.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(f.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dmg);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmn = getVoiceManager();
        this.dmn.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dmn = getVoiceManager();
        if (this.dmn != null) {
            this.dmn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dsI != null) {
            this.dsI.onDestroy();
        }
        super.onDestroy();
        this.dsH.onActivityDestroy();
        this.dmn = getVoiceManager();
        this.dmn.onDestory(getPageContext());
    }
}
