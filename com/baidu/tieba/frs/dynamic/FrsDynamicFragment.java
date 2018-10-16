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
import com.baidu.f.a.a;
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
/* loaded from: classes6.dex */
public class FrsDynamicFragment extends BaseFragment implements BdListView.e, a.InterfaceC0073a, UserIconBox.b, VoiceManager.c, aj, FrsCommonImageLayout.c {
    private String dAf;
    private VoiceManager dAm;
    private FrsDynamicModelController dHm;
    protected c dHn;
    private String dHp;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int dGV = 3;
    private b dHo = new b();
    private int mPn = 1;
    private final CustomMessageListener ajQ = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.dHn != null) {
                FrsDynamicFragment.this.dHn.startPullRefresh();
            }
        }
    };
    private CustomMessageListener dBh = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.Eg() != null) {
                        FrsDynamicFragment.this.Eg().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Mq()) {
                        FrsDynamicFragment.this.gO(false);
                    } else if (FrsDynamicFragment.this.dHn != null) {
                        FrsDynamicFragment.this.dHn.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dEG = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.dHm.DU()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.Eg() != null) {
                        FrsDynamicFragment.this.Eg().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Mq()) {
                        FrsDynamicFragment.this.gO(false);
                    } else if (FrsDynamicFragment.this.dHn != null) {
                        FrsDynamicFragment.this.dHn.startPullRefresh();
                    }
                }
            }
        }
    };
    private final j.b bMO = new j.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.j.b
        public void bp(boolean z) {
            if (com.baidu.adp.lib.util.j.kX()) {
                d.Ux().jp("page_frs_dynamic");
                FrsDynamicFragment.this.gO(true);
                return;
            }
            FrsDynamicFragment.this.dHn.cQ(false);
        }
    };
    private n dBA = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bb)) {
                bb bbVar = (bb) hVar;
                if (bbVar.zh() == null || bbVar.zh().getGroup_id() == 0 || ba.bI(FrsDynamicFragment.this.getActivity())) {
                    if (bbVar.yZ() != 1 || ba.bI(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.vl(bbVar.getId())) {
                            readThreadHistory.vk(bbVar.getId());
                            if (FrsDynamicFragment.this.dHn != null) {
                                FrsDynamicFragment.this.dHn.aAx();
                            }
                        }
                        boolean z = false;
                        final String yD = bbVar.yD();
                        if (yD != null && !yD.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(yD);
                                    xVar.BY().CW().mIsNeedAddCommenParam = false;
                                    xVar.BY().CW().mIsUseCurrentBDUSS = false;
                                    xVar.BB();
                                }
                            }).start();
                        }
                        String tid = bbVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bbVar.yq() == 2 && !tid.startsWith("pb:")) {
                            ay.CU().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bbVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bbVar, FrsDynamicFragment.this.dAf, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bbVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n dBu = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void lq(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.dHn.aAx();
                    return;
                case 3:
                    FrsDynamicFragment.this.dHn.cQ(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.dHn.cQ(false);
            if (FrsDynamicFragment.this.dHm.aCd() != null) {
                FrsDynamicFragment.this.dHo = FrsDynamicFragment.this.dHm.aCd();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.dHo.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (v.J(FrsDynamicFragment.this.dHo.threadList)) {
                    FrsDynamicFragment.this.dHn.ZK();
                } else {
                    FrsDynamicFragment.this.dHn.ZJ();
                }
            } else {
                FrsDynamicFragment.this.dHn.ZI();
            }
            if (i == 4) {
                FrsDynamicFragment.this.dHn.P(FrsDynamicFragment.this.dHo.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.dHn.aAx();
                    break;
                case 2:
                    FrsDynamicFragment.this.dHn.aAx();
                    break;
            }
            FrsDynamicFragment.this.hideLoadingView();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.azM();
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private CustomMessageListener dHq = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bb)) {
                bb bbVar = (bb) customResponsedMessage.getData();
                FrsDynamicFragment.this.dHp = bbVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.dHp) && bbVar.yi() != null) {
                    FrsDynamicFragment.this.lO(bbVar.yi().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.dHm = new FrsDynamicModelController(this);
        this.dHm.setForumId(Long.parseLong(this.forumId));
        this.dAm = getVoiceManager();
        this.dAm.onCreate(getPageContext());
        registerListener(this.ajQ);
        registerListener(this.dHq);
        registerListener(this.dBh);
        registerListener(this.dEG);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(e.h.frs_dynamic_activity, (ViewGroup) null);
        this.dHn = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dAf = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dAf = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.dHn.setOnAdapterItemClickListener(this.dBA);
        this.dHn.a(this.bMO);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dHn != null) {
            this.dHn.aAx();
        }
        this.dAm = getVoiceManager();
        this.dAm.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dAm = getVoiceManager();
        this.dAm.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dGV == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new am("c13008").ax(ImageViewerConfig.FORUM_ID, this.forumId).x("obj_type", 1));
        if (com.baidu.adp.lib.util.j.kX()) {
            gO(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(boolean z) {
        azP();
        ZH();
        if (!z) {
            ZH();
            showLoadingView();
        }
        this.dHm.aCc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void azM() {
        azP();
        try {
            if (this.dHo != null) {
                this.dHn.amg();
                if (this.dHo.threadList != null) {
                    this.dHn.P(this.dHo.threadList);
                    this.dHn.aAx();
                    this.dHn.aCe().setFromCDN(true);
                    this.dHn.setListViewSelection(aL(this.dHm.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aL(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void azP() {
        this.dAm = getVoiceManager();
        this.dAm.stopPlay();
    }

    @Override // com.baidu.tieba.frs.aj
    public void ZF() {
        if (this.dHn != null) {
            azk();
            this.dHn.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.aj
    public void azk() {
        if (this.dHn != null && this.dHn.getListView() != null) {
            this.dHn.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dHn != null && this.dHn.getListView() != null) {
            this.dHn.getListView().stopScroll();
        }
        YY();
        if (l.lo() && this.mHasMore && !this.dHm.DU()) {
            this.mPn++;
            h hVar = (h) v.d(this.dHo.threadList, v.I(this.dHo.threadList) - 1);
            if (hVar instanceof bb) {
                this.dHm.bT(com.baidu.adp.lib.g.b.d(((bb) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bb nJ;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dHn.aCe().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (nJ = this.dHo.nJ(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.dHo.threadList.remove(nJ);
                        if (v.J(this.dHo.threadList)) {
                            this.dHo.threadList.add(new m());
                        }
                        this.dHn.aAx();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> ayY() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).ayY();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dAm == null) {
            this.dAm = VoiceManager.instance();
        }
        return this.dAm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView Eg() {
        if (this.dHn == null) {
            return null;
        }
        return this.dHn.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> Eh() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).Eh();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public k onGetPreLoadListView() {
        if (Eg() == null) {
            return null;
        }
        return Eg().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dGV != 3 || this.dHn != null) {
            this.dGV = i;
            super.onChangeSkinType(i);
            if (this.dHn != null) {
                this.dHn.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.dHn.gG(false);
        showLoadingView(this.dHn.aAI(), true, getResources().getDimensionPixelSize(e.C0175e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dHn.gG(true);
        hideLoadingView(this.dHn.aAI());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dHn.gG(false);
        this.dHn.aBH().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dHn.ZK();
        this.dHn.getListView().getData().clear();
        this.dHn.aAx();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.My();
            this.mRefreshView.fA(getResources().getDimensionPixelSize(e.C0175e.ds_102));
            this.mRefreshView.Mw().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.hU(getPageContext().getResources().getString(e.j.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.hU(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.c(this.dHn.aAI(), true);
    }

    private void ZH() {
        this.dHn.gG(true);
        this.dHn.aBH().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Mq()) {
            this.mRefreshView.ad(this.dHn.aAI());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kX()) {
            gO(false);
        }
    }

    private void YY() {
        if (!this.mHasMore) {
            if (v.J(this.dHo.threadList)) {
                this.dHn.ZK();
                return;
            } else {
                this.dHn.ZJ();
                return;
            }
        }
        this.dHn.ZI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(int i) {
        if (this.dHo.threadList != null) {
            Iterator<h> it = this.dHo.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bb) {
                    bb bbVar = (bb) next;
                    if (bbVar.getId() != null && bbVar.getId().equals(this.dHp)) {
                        a(bbVar, i);
                        this.dHp = null;
                        break;
                    }
                }
            }
            this.dHn.aCe().setData(this.dHo.threadList);
            this.dHn.aCe().notifyDataSetChanged();
        }
    }

    private void a(bb bbVar, int i) {
        if (i == 1) {
            PraiseData yi = bbVar.yi();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (yi == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bbVar.a(praiseData);
                    return;
                }
                bbVar.yi().getUser().add(0, metaData);
                bbVar.yi().setNum(bbVar.yi().getNum() + 1);
                bbVar.yi().setIsLike(i);
            }
        } else if (bbVar.yi() != null) {
            bbVar.yi().setIsLike(i);
            bbVar.yi().setNum(bbVar.yi().getNum() - 1);
            ArrayList<MetaData> user = bbVar.yi().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bbVar.yi().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aX(getActivity().getApplicationContext())) {
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
        bundle.putString("name", this.dAf);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dAm = getVoiceManager();
        this.dAm.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dAm = getVoiceManager();
        if (this.dAm != null) {
            this.dAm.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dHn != null) {
            this.dHn.onDestroy();
        }
        super.onDestroy();
        this.dHm.onActivityDestroy();
        this.dAm = getVoiceManager();
        this.dAm.onDestory(getPageContext());
    }
}
