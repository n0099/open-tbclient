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
import com.baidu.d.a.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
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
    private String djs;
    private VoiceManager djz;
    private FrsDynamicModelController dpX;
    protected c dpY;
    private String dqa;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int dpW = 3;
    private b dpZ = new b();
    private int mPn = 1;
    private final CustomMessageListener acM = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.dpY != null) {
                FrsDynamicFragment.this.dpY.startPullRefresh();
            }
        }
    };
    private CustomMessageListener dku = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.Bb() != null) {
                        FrsDynamicFragment.this.Bb().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Jh()) {
                        FrsDynamicFragment.this.fW(false);
                    } else if (FrsDynamicFragment.this.dpY != null) {
                        FrsDynamicFragment.this.dpY.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dnA = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.dpX.AO()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.Bb() != null) {
                        FrsDynamicFragment.this.Bb().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Jh()) {
                        FrsDynamicFragment.this.fW(false);
                    } else if (FrsDynamicFragment.this.dpY != null) {
                        FrsDynamicFragment.this.dpY.startPullRefresh();
                    }
                }
            }
        }
    };
    private final g.b bxO = new g.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.g.b
        public void aU(boolean z) {
            if (j.jD()) {
                d.QB().iC("page_frs_dynamic");
                FrsDynamicFragment.this.fW(true);
                return;
            }
            FrsDynamicFragment.this.dpY.cp(false);
        }
    };
    private n dkN = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bc)) {
                bc bcVar = (bc) hVar;
                if (bcVar.wf() == null || bcVar.wf().getGroup_id() == 0 || bb.aU(FrsDynamicFragment.this.getActivity())) {
                    if (bcVar.vY() != 1 || bb.aU(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.ua(bcVar.getId())) {
                            readThreadHistory.tZ(bcVar.getId());
                            if (FrsDynamicFragment.this.dpY != null) {
                                FrsDynamicFragment.this.dpY.auG();
                            }
                        }
                        boolean z = false;
                        final String vD = bcVar.vD();
                        if (vD != null && !vD.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vD);
                                    yVar.yX().zX().mIsNeedAddCommenParam = false;
                                    yVar.yX().zX().mIsUseCurrentBDUSS = false;
                                    yVar.yA();
                                }
                            }).start();
                        }
                        String tid = bcVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bcVar.vr() == 2 && !tid.startsWith("pb:")) {
                            az.zV().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bcVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bcVar, FrsDynamicFragment.this.djs, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bcVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dkH = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void kj(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.dpY.auG();
                    return;
                case 3:
                    FrsDynamicFragment.this.dpY.cp(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.dpY.cp(false);
            if (FrsDynamicFragment.this.dpX.avS() != null) {
                FrsDynamicFragment.this.dpZ = FrsDynamicFragment.this.dpX.avS();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.dpZ.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (w.A(FrsDynamicFragment.this.dpZ.threadList)) {
                    FrsDynamicFragment.this.dpY.Uf();
                } else {
                    FrsDynamicFragment.this.dpY.Ue();
                }
            } else {
                FrsDynamicFragment.this.dpY.Ud();
            }
            if (i == 4) {
                FrsDynamicFragment.this.dpY.P(FrsDynamicFragment.this.dpZ.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.dpY.auG();
                    break;
                case 2:
                    FrsDynamicFragment.this.dpY.auG();
                    break;
            }
            FrsDynamicFragment.this.hideLoadingView();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.atU();
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private CustomMessageListener ayc = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bc)) {
                bc bcVar = (bc) customResponsedMessage.getData();
                FrsDynamicFragment.this.dqa = bcVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.dqa) && bcVar.vj() != null) {
                    FrsDynamicFragment.this.kD(bcVar.vj().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.dpX = new FrsDynamicModelController(this);
        this.dpX.setForumId(Long.parseLong(this.forumId));
        this.djz = getVoiceManager();
        this.djz.onCreate(getPageContext());
        registerListener(this.acM);
        registerListener(this.ayc);
        registerListener(this.dku);
        registerListener(this.dnA);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_dynamic_activity, (ViewGroup) null);
        this.dpY = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.djs = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.djs = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.dpY.setOnAdapterItemClickListener(this.dkN);
        this.dpY.a(this.bxO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dpY != null) {
            this.dpY.auG();
        }
        this.djz = getVoiceManager();
        this.djz.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.djz = getVoiceManager();
        this.djz.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dpW == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new an("c13008").ah(ImageViewerConfig.FORUM_ID, this.forumId).r("obj_type", 1));
        if (j.jD()) {
            fW(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(boolean z) {
        atX();
        Uc();
        if (!z) {
            Uc();
            showLoadingView();
        }
        this.dpX.avR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atU() {
        atX();
        try {
            if (this.dpZ != null) {
                this.dpY.showListView();
                if (this.dpZ.threadList != null) {
                    this.dpY.P(this.dpZ.threadList);
                    this.dpY.auG();
                    this.dpY.avT().setFromCDN(true);
                    this.dpY.setListViewSelection(aB(this.dpX.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aB(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void atX() {
        this.djz = getVoiceManager();
        this.djz.stopPlay();
    }

    @Override // com.baidu.tieba.frs.aj
    public void Ua() {
        if (this.dpY != null) {
            atu();
            this.dpY.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void atu() {
        if (this.dpY != null && this.dpY.getListView() != null) {
            this.dpY.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dpY != null && this.dpY.getListView() != null) {
            this.dpY.getListView().stopScroll();
        }
        Tt();
        if (l.jU() && this.mHasMore && !this.dpX.AO()) {
            this.mPn++;
            h hVar = (h) w.d(this.dpZ.threadList, w.z(this.dpZ.threadList) - 1);
            if (hVar instanceof bc) {
                this.dpX.bD(com.baidu.adp.lib.g.b.c(((bc) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bc mD;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dpY.avT().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mD = this.dpZ.mD(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.dpZ.threadList.remove(mD);
                        if (w.A(this.dpZ.threadList)) {
                            this.dpZ.threadList.add(new m());
                        }
                        this.dpY.auG();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ati() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).ati();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.djz == null) {
            this.djz = VoiceManager.instance();
        }
        return this.djz;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Bb() {
        if (this.dpY == null) {
            return null;
        }
        return this.dpY.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Bc() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Bc();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Bb() == null) {
            return null;
        }
        return Bb().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dpW != 3 || this.dpY != null) {
            this.dpW = i;
            super.onChangeSkinType(i);
            if (this.dpY != null) {
                this.dpY.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.dpY.fP(false);
        showLoadingView(this.dpY.avx(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dpY.fP(true);
        hideLoadingView(this.dpY.avx());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dpY.fP(false);
        this.dpY.avy().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dpY.Uf();
        this.dpY.getListView().getData().clear();
        this.dpY.auG();
        if (this.mRefreshView == null) {
            this.mRefreshView = new com.baidu.tbadk.j.g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Jp();
            this.mRefreshView.ff(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Jn().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dpY.avx(), true);
    }

    private void Uc() {
        this.dpY.fP(true);
        this.dpY.avy().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Jh()) {
            this.mRefreshView.Q(this.dpY.avx());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jD()) {
            fW(false);
        }
    }

    private void Tt() {
        if (!this.mHasMore) {
            if (w.A(this.dpZ.threadList)) {
                this.dpY.Uf();
                return;
            } else {
                this.dpY.Ue();
                return;
            }
        }
        this.dpY.Ud();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kD(int i) {
        if (this.dpZ.threadList != null) {
            Iterator<h> it = this.dpZ.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bc) {
                    bc bcVar = (bc) next;
                    if (bcVar.getId() != null && bcVar.getId().equals(this.dqa)) {
                        a(bcVar, i);
                        this.dqa = null;
                        break;
                    }
                }
            }
            this.dpY.avT().setData(this.dpZ.threadList);
            this.dpY.avT().notifyDataSetChanged();
        }
    }

    private void a(bc bcVar, int i) {
        if (i == 1) {
            PraiseData vj = bcVar.vj();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (vj == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bcVar.a(praiseData);
                    return;
                }
                bcVar.vj().getUser().add(0, metaData);
                bcVar.vj().setNum(bcVar.vj().getNum() + 1);
                bcVar.vj().setIsLike(i);
            }
        } else if (bcVar.vj() != null) {
            bcVar.vj().setIsLike(i);
            bcVar.vj().setNum(bcVar.vj().getNum() - 1);
            ArrayList<MetaData> user = bcVar.vj().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bcVar.vj().getUser().remove(next);
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
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> b = ac.b(strArr, iArr);
            if (b.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !b.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.djs);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.djz = getVoiceManager();
        this.djz.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.djz = getVoiceManager();
        if (this.djz != null) {
            this.djz.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dpY != null) {
            this.dpY.onDestroy();
        }
        super.onDestroy();
        this.dpX.onActivityDestroy();
        this.djz = getVoiceManager();
        this.djz.onDestory(getPageContext());
    }
}
