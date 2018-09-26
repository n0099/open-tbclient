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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a.d;
import com.baidu.tieba.e;
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
    private String dsd;
    private VoiceManager dsk;
    private FrsDynamicModelController dzm;
    protected c dzn;
    private String dzp;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int dyV = 3;
    private b dzo = new b();
    private int mPn = 1;
    private final CustomMessageListener aeT = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.dzn != null) {
                FrsDynamicFragment.this.dzn.startPullRefresh();
            }
        }
    };
    private CustomMessageListener dtg = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.Cb() != null) {
                        FrsDynamicFragment.this.Cb().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Ks()) {
                        FrsDynamicFragment.this.gw(false);
                    } else if (FrsDynamicFragment.this.dzn != null) {
                        FrsDynamicFragment.this.dzn.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dwF = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.dzm.BO()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.Cb() != null) {
                        FrsDynamicFragment.this.Cb().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Ks()) {
                        FrsDynamicFragment.this.gw(false);
                    } else if (FrsDynamicFragment.this.dzn != null) {
                        FrsDynamicFragment.this.dzn.startPullRefresh();
                    }
                }
            }
        }
    };
    private final j.b bEk = new j.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.j.b
        public void bf(boolean z) {
            if (com.baidu.adp.lib.util.j.kK()) {
                d.SB().jc("page_frs_dynamic");
                FrsDynamicFragment.this.gw(true);
                return;
            }
            FrsDynamicFragment.this.dzn.cH(false);
        }
    };
    private n dtz = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.wY() == null || bbVar.wY().getGroup_id() == 0 || ba.bA(FrsDynamicFragment.this.getActivity())) {
                    if (bbVar.wQ() != 1 || ba.bA(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.uJ(bbVar.getId())) {
                            readThreadHistory.uI(bbVar.getId());
                            if (FrsDynamicFragment.this.dzn != null) {
                                FrsDynamicFragment.this.dzn.axc();
                            }
                        }
                        boolean z = false;
                        final String wu = bbVar.wu();
                        if (wu != null && !wu.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(wu);
                                    xVar.zR().AP().mIsNeedAddCommenParam = false;
                                    xVar.zR().AP().mIsUseCurrentBDUSS = false;
                                    xVar.zu();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.wh() == 2 && !tid.startsWith("pb:")) {
                            ay.AN().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsDynamicFragment.this.dsd, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dtt = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void kS(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.dzn.axc();
                    return;
                case 3:
                    FrsDynamicFragment.this.dzn.cH(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.dzn.cH(false);
            if (FrsDynamicFragment.this.dzm.ayK() != null) {
                FrsDynamicFragment.this.dzo = FrsDynamicFragment.this.dzm.ayK();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.dzo.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (v.z(FrsDynamicFragment.this.dzo.threadList)) {
                    FrsDynamicFragment.this.dzn.Wd();
                } else {
                    FrsDynamicFragment.this.dzn.Wc();
                }
            } else {
                FrsDynamicFragment.this.dzn.Wb();
            }
            if (i == 4) {
                FrsDynamicFragment.this.dzn.P(FrsDynamicFragment.this.dzo.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.dzn.axc();
                    break;
                case 2:
                    FrsDynamicFragment.this.dzn.axc();
                    break;
            }
            FrsDynamicFragment.this.hideLoadingView();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.awq();
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private CustomMessageListener dzq = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsDynamicFragment.this.dzp = bbVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.dzp) && bbVar.vZ() != null) {
                    FrsDynamicFragment.this.lq(bbVar.vZ().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.dzm = new FrsDynamicModelController(this);
        this.dzm.setForumId(Long.parseLong(this.forumId));
        this.dsk = getVoiceManager();
        this.dsk.onCreate(getPageContext());
        registerListener(this.aeT);
        registerListener(this.dzq);
        registerListener(this.dtg);
        registerListener(this.dwF);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_dynamic_activity, (ViewGroup) null);
        this.dzn = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dsd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dsd = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.dzn.setOnAdapterItemClickListener(this.dtz);
        this.dzn.a(this.bEk);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dzn != null) {
            this.dzn.axc();
        }
        this.dsk = getVoiceManager();
        this.dsk.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dsk = getVoiceManager();
        this.dsk.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dyV == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new am("c13008").al(ImageViewerConfig.FORUM_ID, this.forumId).w("obj_type", 1));
        if (com.baidu.adp.lib.util.j.kK()) {
            gw(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gw(boolean z) {
        awt();
        Wa();
        if (!z) {
            Wa();
            showLoadingView();
        }
        this.dzm.ayJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awq() {
        awt();
        try {
            if (this.dzo != null) {
                this.dzn.aiB();
                if (this.dzo.threadList != null) {
                    this.dzn.P(this.dzo.threadList);
                    this.dzn.axc();
                    this.dzn.ayL().setFromCDN(true);
                    this.dzn.setListViewSelection(aI(this.dzm.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aI(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void awt() {
        this.dsk = getVoiceManager();
        this.dsk.stopPlay();
    }

    @Override // com.baidu.tieba.frs.aj
    public void VY() {
        if (this.dzn != null) {
            avO();
            this.dzn.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void avO() {
        if (this.dzn != null && this.dzn.getListView() != null) {
            this.dzn.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dzn != null && this.dzn.getListView() != null) {
            this.dzn.getListView().stopScroll();
        }
        Vr();
        if (l.lb() && this.mHasMore && !this.dzm.BO()) {
            this.mPn++;
            h hVar = (h) v.d(this.dzo.threadList, v.y(this.dzo.threadList) - 1);
            if (hVar instanceof bb) {
                this.dzm.bM(com.baidu.adp.lib.g.b.d(((bb) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb nh;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dzn.ayL().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (nh = this.dzo.nh(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.dzo.threadList.remove(nh);
                        if (v.z(this.dzo.threadList)) {
                            this.dzo.threadList.add(new m());
                        }
                        this.dzn.axc();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> avC() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).avC();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dsk == null) {
            this.dsk = VoiceManager.instance();
        }
        return this.dsk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Cb() {
        if (this.dzn == null) {
            return null;
        }
        return this.dzn.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Cc() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Cc();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Cb() == null) {
            return null;
        }
        return Cb().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dyV != 3 || this.dzn != null) {
            this.dyV = i;
            super.onChangeSkinType(i);
            if (this.dzn != null) {
                this.dzn.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.dzn.go(false);
        showLoadingView(this.dzn.axn(), true, getResources().getDimensionPixelSize(e.C0141e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dzn.go(true);
        hideLoadingView(this.dzn.axn());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dzn.go(false);
        this.dzn.aym().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dzn.Wd();
        this.dzn.getListView().getData().clear();
        this.dzn.axc();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.KA();
            this.mRefreshView.fr(getResources().getDimensionPixelSize(e.C0141e.ds_102));
            this.mRefreshView.Ky().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hG(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hG(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dzn.axn(), true);
    }

    private void Wa() {
        this.dzn.go(true);
        this.dzn.aym().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Ks()) {
            this.mRefreshView.ad(this.dzn.axn());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            gw(false);
        }
    }

    private void Vr() {
        if (!this.mHasMore) {
            if (v.z(this.dzo.threadList)) {
                this.dzn.Wd();
                return;
            } else {
                this.dzn.Wc();
                return;
            }
        }
        this.dzn.Wb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(int i) {
        if (this.dzo.threadList != null) {
            Iterator<h> it = this.dzo.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dzp)) {
                        a(bbVar, i);
                        this.dzp = null;
                        break;
                    }
                }
            }
            this.dzn.ayL().setData(this.dzo.threadList);
            this.dzn.ayL().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData vZ = bbVar.vZ();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (vZ == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.vZ().getUser().add(0, metaData);
                bbVar.vZ().setNum(bbVar.vZ().getNum() + 1);
                bbVar.vZ().setIsLike(i);
            }
        } else if (bbVar.vZ() != null) {
            bbVar.vZ().setIsLike(i);
            bbVar.vZ().setNum(bbVar.vZ().getNum() - 1);
            ArrayList<MetaData> user = bbVar.vZ().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.vZ().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.bt(getActivity().getApplicationContext())) {
                ak.b(getPageContext());
            } else {
                showToast(e.j.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ab.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(e.j.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.dsd);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dsk = getVoiceManager();
        this.dsk.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dsk = getVoiceManager();
        if (this.dsk != null) {
            this.dsk.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dzn != null) {
            this.dzn.onDestroy();
        }
        super.onDestroy();
        this.dzm.onActivityDestroy();
        this.dsk = getVoiceManager();
        this.dsk.onDestory(getPageContext());
    }
}
