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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a.d;
import com.baidu.tieba.d;
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
    private String dmi;
    private VoiceManager dmp;
    private FrsDynamicModelController dsK;
    protected c dsL;
    private String dsN;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int dsJ = 3;
    private b dsM = new b();
    private int mPn = 1;
    private final CustomMessageListener acq = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.dsL != null) {
                FrsDynamicFragment.this.dsL.startPullRefresh();
            }
        }
    };
    private CustomMessageListener dnk = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.AS() != null) {
                        FrsDynamicFragment.this.AS().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Jc()) {
                        FrsDynamicFragment.this.fY(false);
                    } else if (FrsDynamicFragment.this.dsL != null) {
                        FrsDynamicFragment.this.dsL.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dqt = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.dsK.AE()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.AS() != null) {
                        FrsDynamicFragment.this.AS().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Jc()) {
                        FrsDynamicFragment.this.fY(false);
                    } else if (FrsDynamicFragment.this.dsL != null) {
                        FrsDynamicFragment.this.dsL.startPullRefresh();
                    }
                }
            }
        }
    };
    private final g.b byt = new g.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            if (j.jE()) {
                d.QI().iz("page_frs_dynamic");
                FrsDynamicFragment.this.fY(true);
                return;
            }
            FrsDynamicFragment.this.dsL.cp(false);
        }
    };
    private n dnD = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.vU() == null || bbVar.vU().getGroup_id() == 0 || ba.aV(FrsDynamicFragment.this.getActivity())) {
                    if (bbVar.vN() != 1 || ba.aV(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.tY(bbVar.getId())) {
                            readThreadHistory.tX(bbVar.getId());
                            if (FrsDynamicFragment.this.dsL != null) {
                                FrsDynamicFragment.this.dsL.avk();
                            }
                        }
                        boolean z = false;
                        final String vs = bbVar.vs();
                        if (vs != null && !vs.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vs);
                                    yVar.yO().zM().mIsNeedAddCommenParam = false;
                                    yVar.yO().zM().mIsUseCurrentBDUSS = false;
                                    yVar.yr();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.vf() == 2 && !tid.startsWith("pb:")) {
                            ay.zK().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsDynamicFragment.this.dmi, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dnx = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void ku(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.dsL.avk();
                    return;
                case 3:
                    FrsDynamicFragment.this.dsL.cp(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.dsL.cp(false);
            if (FrsDynamicFragment.this.dsK.awx() != null) {
                FrsDynamicFragment.this.dsM = FrsDynamicFragment.this.dsK.awx();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.dsM.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (w.z(FrsDynamicFragment.this.dsM.threadList)) {
                    FrsDynamicFragment.this.dsL.Un();
                } else {
                    FrsDynamicFragment.this.dsL.Um();
                }
            } else {
                FrsDynamicFragment.this.dsL.Ul();
            }
            if (i == 4) {
                FrsDynamicFragment.this.dsL.P(FrsDynamicFragment.this.dsM.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.dsL.avk();
                    break;
                case 2:
                    FrsDynamicFragment.this.dsL.avk();
                    break;
            }
            FrsDynamicFragment.this.hideLoadingView();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.auy();
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private CustomMessageListener axI = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsDynamicFragment.this.dsN = bbVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.dsN) && bbVar.uX() != null) {
                    FrsDynamicFragment.this.kO(bbVar.uX().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.dsK = new FrsDynamicModelController(this);
        this.dsK.setForumId(Long.parseLong(this.forumId));
        this.dmp = getVoiceManager();
        this.dmp.onCreate(getPageContext());
        registerListener(this.acq);
        registerListener(this.axI);
        registerListener(this.dnk);
        registerListener(this.dqt);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.h.frs_dynamic_activity, (ViewGroup) null);
        this.dsL = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dmi = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dmi = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.dsL.setOnAdapterItemClickListener(this.dnD);
        this.dsL.a(this.byt);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dsL != null) {
            this.dsL.avk();
        }
        this.dmp = getVoiceManager();
        this.dmp.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dmp = getVoiceManager();
        this.dmp.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dsJ == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new an("c13008").af(ImageViewerConfig.FORUM_ID, this.forumId).r("obj_type", 1));
        if (j.jE()) {
            fY(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY(boolean z) {
        auB();
        Uk();
        if (!z) {
            Uk();
            showLoadingView();
        }
        this.dsK.aww();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        auB();
        try {
            if (this.dsM != null) {
                this.dsL.agN();
                if (this.dsM.threadList != null) {
                    this.dsL.P(this.dsM.threadList);
                    this.dsL.avk();
                    this.dsL.awy().setFromCDN(true);
                    this.dsL.setListViewSelection(aE(this.dsK.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aE(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void auB() {
        this.dmp = getVoiceManager();
        this.dmp.stopPlay();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ui() {
        if (this.dsL != null) {
            atY();
            this.dsL.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atY() {
        if (this.dsL != null && this.dsL.getListView() != null) {
            this.dsL.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dsL != null && this.dsL.getListView() != null) {
            this.dsL.getListView().stopScroll();
        }
        TB();
        if (l.jV() && this.mHasMore && !this.dsK.AE()) {
            this.mPn++;
            h hVar = (h) w.d(this.dsM.threadList, w.y(this.dsM.threadList) - 1);
            if (hVar instanceof bb) {
                this.dsK.bI(com.baidu.adp.lib.g.b.c(((bb) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb mC;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dsL.awy().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mC = this.dsM.mC(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.dsM.threadList.remove(mC);
                        if (w.z(this.dsM.threadList)) {
                            this.dsM.threadList.add(new m());
                        }
                        this.dsL.avk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> atM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).atM();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dmp == null) {
            this.dmp = VoiceManager.instance();
        }
        return this.dmp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView AS() {
        if (this.dsL == null) {
            return null;
        }
        return this.dsL.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AT() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).AT();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (AS() == null) {
            return null;
        }
        return AS().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dsJ != 3 || this.dsL != null) {
            this.dsJ = i;
            super.onChangeSkinType(i);
            if (this.dsL != null) {
                this.dsL.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.dsL.fR(false);
        showLoadingView(this.dsL.awc(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dsL.fR(true);
        hideLoadingView(this.dsL.awc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dsL.fR(false);
        this.dsL.awd().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dsL.Un();
        this.dsL.getListView().getData().clear();
        this.dsL.avk();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.k.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jk();
            this.mRefreshView.fg(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Ji().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hk(getPageContext().getResources().getString(d.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hk(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dsL.awc(), true);
    }

    private void Uk() {
        this.dsL.fR(true);
        this.dsL.awd().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jc()) {
            this.mRefreshView.Q(this.dsL.awc());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jE()) {
            fY(false);
        }
    }

    private void TB() {
        if (!this.mHasMore) {
            if (w.z(this.dsM.threadList)) {
                this.dsL.Un();
                return;
            } else {
                this.dsL.Um();
                return;
            }
        }
        this.dsL.Ul();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kO(int i) {
        if (this.dsM.threadList != null) {
            Iterator<h> it = this.dsM.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dsN)) {
                        a(bbVar, i);
                        this.dsN = null;
                        break;
                    }
                }
            }
            this.dsL.awy().setData(this.dsM.threadList);
            this.dsL.awy().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData uX = bbVar.uX();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (uX == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.uX().getUser().add(0, metaData);
                bbVar.uX().setNum(bbVar.uX().getNum() + 1);
                bbVar.uX().setIsLike(i);
            }
        } else if (bbVar.uX() != null) {
            bbVar.uX().setIsLike(i);
            bbVar.uX().setNum(bbVar.uX().getNum() - 1);
            ArrayList<MetaData> user = bbVar.uX().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.uX().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ac.aO(getActivity().getApplicationContext())) {
                al.b(getPageContext());
            } else {
                showToast(d.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dmi);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dmp = getVoiceManager();
        this.dmp.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dmp = getVoiceManager();
        if (this.dmp != null) {
            this.dmp.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dsL != null) {
            this.dsL.onDestroy();
        }
        super.onDestroy();
        this.dsK.onActivityDestroy();
        this.dmp = getVoiceManager();
        this.dmp.onDestory(getPageContext());
    }
}
