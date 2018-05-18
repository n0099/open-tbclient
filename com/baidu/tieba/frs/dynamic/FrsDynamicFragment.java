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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.e;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.j.g;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a.d;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.d;
import com.baidu.tieba.tbadkCore.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class FrsDynamicFragment extends BaseFragment implements BdListView.e, a.InterfaceC0045a, UserIconBox.b, VoiceManager.c, ah, FrsCommonImageLayout.c {
    private String cYh;
    private VoiceManager cYn;
    private String ddB;
    private FrsDynamicModelController ddx;
    protected c ddy;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int ddw = 3;
    private b ddz = new b();
    private int mPn = 1;
    private final CustomMessageListener UJ = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.ddy != null) {
                FrsDynamicFragment.this.ddy.startPullRefresh();
            }
        }
    };
    private CustomMessageListener cZd = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.xi() != null) {
                        FrsDynamicFragment.this.xi().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Fk()) {
                        FrsDynamicFragment.this.fI(false);
                    } else if (FrsDynamicFragment.this.ddy != null) {
                        FrsDynamicFragment.this.ddy.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener ddA = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.ddx.wW()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.xi() != null) {
                        FrsDynamicFragment.this.xi().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Fk()) {
                        FrsDynamicFragment.this.fI(false);
                    } else if (FrsDynamicFragment.this.ddy != null) {
                        FrsDynamicFragment.this.ddy.startPullRefresh();
                    }
                }
            }
        }
    };
    private final e.b bom = new e.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            if (j.gP()) {
                d.MF().hY("page_frs_dynamic");
                FrsDynamicFragment.this.fI(true);
                return;
            }
            FrsDynamicFragment.this.ddy.ch(false);
        }
    };
    private n cZv = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view2, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bd)) {
                bd bdVar = (bd) hVar;
                if (bdVar.sy() == null || bdVar.sy().getGroup_id() == 0 || az.aK(FrsDynamicFragment.this.getActivity())) {
                    if (bdVar.sr() != 1 || az.aK(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.tg(bdVar.getId())) {
                            readThreadHistory.tf(bdVar.getId());
                            if (FrsDynamicFragment.this.ddy != null) {
                                FrsDynamicFragment.this.ddy.aqj();
                            }
                        }
                        boolean z = false;
                        final String rW = bdVar.rW();
                        if (rW != null && !rW.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(rW);
                                    xVar.vi().wh().mIsNeedAddCommenParam = false;
                                    xVar.vi().wh().mIsUseCurrentBDUSS = false;
                                    xVar.uL();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.rK() == 2 && !tid.startsWith("pb:")) {
                            ax.wf().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bdVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, FrsDynamicFragment.this.cYh, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cZo = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void kc(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.ddy.aqj();
                    return;
                case 3:
                    FrsDynamicFragment.this.ddy.ch(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.ddy.ch(false);
            if (FrsDynamicFragment.this.ddx.arj() != null) {
                FrsDynamicFragment.this.ddz = FrsDynamicFragment.this.ddx.arj();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.ddz.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (v.w(FrsDynamicFragment.this.ddz.threadList)) {
                    FrsDynamicFragment.this.ddy.Qn();
                } else {
                    FrsDynamicFragment.this.ddy.Qm();
                }
            } else {
                FrsDynamicFragment.this.ddy.Ql();
            }
            if (i == 4) {
                FrsDynamicFragment.this.ddy.K(FrsDynamicFragment.this.ddz.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.ddy.aqj();
                    break;
                case 2:
                    FrsDynamicFragment.this.ddy.aqj();
                    break;
            }
            FrsDynamicFragment.this.Os();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.apy();
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private CustomMessageListener apd = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                FrsDynamicFragment.this.ddB = bdVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.ddB) && bdVar.rE() != null) {
                    FrsDynamicFragment.this.kr(bdVar.rE().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.ddx = new FrsDynamicModelController(this);
        this.ddx.setForumId(Long.parseLong(this.forumId));
        this.cYn = getVoiceManager();
        this.cYn.onCreate(getPageContext());
        registerListener(this.UJ);
        registerListener(this.apd);
        registerListener(this.cZd);
        registerListener(this.ddA);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_dynamic_activity, (ViewGroup) null);
        this.ddy = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cYh = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.cYh = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.ddy.setOnAdapterItemClickListener(this.cZv);
        this.ddy.a(this.bom);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ddy != null) {
            this.ddy.aqj();
        }
        this.cYn = getVoiceManager();
        this.cYn.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cYn = getVoiceManager();
        this.cYn.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.ddw == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new al("c13008").ac(ImageViewerConfig.FORUM_ID, this.forumId).r("obj_type", 1));
        if (j.gP()) {
            fI(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fI(boolean z) {
        apB();
        Qk();
        if (!z) {
            Qk();
            showLoadingView();
        }
        this.ddx.ari();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        apB();
        try {
            if (this.ddz != null) {
                this.ddy.showListView();
                if (this.ddz.threadList != null) {
                    this.ddy.K(this.ddz.threadList);
                    this.ddy.aqj();
                    this.ddy.ark().setFromCDN(true);
                    this.ddy.setListViewSelection(aA(this.ddx.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aA(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void apB() {
        this.cYn = getVoiceManager();
        this.cYn.stopPlay();
    }

    @Override // com.baidu.tieba.frs.ah
    public void Qi() {
        if (this.ddy != null) {
            aoX();
            this.ddy.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aoX() {
        if (this.ddy != null && this.ddy.getListView() != null) {
            this.ddy.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        Pz();
        if (l.hg() && this.mHasMore && !this.ddx.wW()) {
            this.mPn++;
            h hVar = (h) v.c(this.ddz.threadList, v.v(this.ddz.threadList) - 1);
            if (hVar instanceof bd) {
                this.ddx.bD(com.baidu.adp.lib.g.b.c(((bd) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd lW;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.ddy.ark().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lW = this.ddz.lW(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.ddz.threadList.remove(lW);
                        if (v.w(this.ddz.threadList)) {
                            this.ddz.threadList.add(new k());
                        }
                        this.ddy.aqj();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aoL() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aoL();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cYn == null) {
            this.cYn = VoiceManager.instance();
        }
        return this.cYn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView xi() {
        if (this.ddy == null) {
            return null;
        }
        return this.ddy.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xj() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).xj();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (xi() == null) {
            return null;
        }
        return xi().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ddw != 3 || this.ddy != null) {
            this.ddw = i;
            super.onChangeSkinType(i);
            if (this.ddy != null) {
                this.ddy.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.ddy.fJ(false);
        showLoadingView(this.ddy.arl(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        this.ddy.fJ(true);
        hideLoadingView(this.ddy.arl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.ddy.fJ(false);
        this.ddy.arm().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.ddy.Qn();
        this.ddy.getListView().getData().clear();
        this.ddy.aqj();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Fs();
            this.mRefreshView.fa(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Fq().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.ddy.arl(), true);
    }

    private void Qk() {
        this.ddy.fJ(true);
        this.ddy.arm().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Fk()) {
            this.mRefreshView.P(this.ddy.arl());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.gP()) {
            fI(false);
        }
    }

    private void Pz() {
        if (!this.mHasMore) {
            if (v.w(this.ddz.threadList)) {
                this.ddy.Qn();
                return;
            } else {
                this.ddy.Qm();
                return;
            }
        }
        this.ddy.Ql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kr(int i) {
        if (this.ddz.threadList != null) {
            Iterator<h> it = this.ddz.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.ddB)) {
                        a(bdVar, i);
                        this.ddB = null;
                        break;
                    }
                }
            }
            this.ddy.ark().setData(this.ddz.threadList);
            this.ddy.ark().notifyDataSetChanged();
        }
    }

    private void a(bd bdVar, int i) {
        if (i == 1) {
            PraiseData rE = bdVar.rE();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (rE == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.rE().getUser().add(0, metaData);
                bdVar.rE().setNum(bdVar.rE().getNum() + 1);
                bdVar.rE().setIsLike(i);
            }
        } else if (bdVar.rE() != null) {
            bdVar.rE().setIsLike(i);
            bdVar.rE().setNum(bdVar.rE().getNum() - 1);
            ArrayList<MetaData> user = bdVar.rE().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.rE().getUser().remove(next);
                        return;
                    }
                }
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 1) {
            if (ab.aD(getActivity().getApplicationContext())) {
                aj.b(getPageContext());
            } else {
                showToast(d.k.system_permission_prompt_camera);
            }
            ArrayMap<String, Boolean> a = ab.a(strArr, iArr);
            if (a.containsKey("android.permission.WRITE_EXTERNAL_STORAGE") && !a.get("android.permission.WRITE_EXTERNAL_STORAGE").booleanValue()) {
                showToast(d.k.sdcard_permission_denied_advert_for_camera);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("name", this.cYh);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.cYn = getVoiceManager();
        if (this.cYn != null) {
            this.cYn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cYn = getVoiceManager();
        this.cYn.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.cYn = getVoiceManager();
        if (this.cYn != null) {
            this.cYn.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.ddy != null) {
            this.ddy.onDestroy();
        }
        super.onDestroy();
        this.ddx.onActivityDestroy();
        this.cYn = getVoiceManager();
        this.cYn.onDestory(getPageContext());
    }
}
