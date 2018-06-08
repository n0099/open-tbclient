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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.f;
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
public class FrsDynamicFragment extends BaseFragment implements BdListView.e, a.InterfaceC0061a, UserIconBox.b, VoiceManager.c, ah, FrsCommonImageLayout.c {
    private VoiceManager dhB;
    private String dhv;
    private FrsDynamicModelController dmL;
    protected c dmM;
    private String dmP;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int dmK = 3;
    private b dmN = new b();
    private int mPn = 1;
    private final CustomMessageListener acJ = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.dmM != null) {
                FrsDynamicFragment.this.dmM.startPullRefresh();
            }
        }
    };
    private CustomMessageListener diu = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.AJ() != null) {
                        FrsDynamicFragment.this.AJ().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.IP()) {
                        FrsDynamicFragment.this.fN(false);
                    } else if (FrsDynamicFragment.this.dmM != null) {
                        FrsDynamicFragment.this.dmM.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dmO = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.dmL.Ax()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.AJ() != null) {
                        FrsDynamicFragment.this.AJ().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.IP()) {
                        FrsDynamicFragment.this.fN(false);
                    } else if (FrsDynamicFragment.this.dmM != null) {
                        FrsDynamicFragment.this.dmM.startPullRefresh();
                    }
                }
            }
        }
    };
    private final f.b bws = new f.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.f.b
        public void aS(boolean z) {
            if (j.jD()) {
                d.Qe().ix("page_frs_dynamic");
                FrsDynamicFragment.this.fN(true);
                return;
            }
            FrsDynamicFragment.this.dmM.cm(false);
        }
    };
    private n diM = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bd)) {
                bd bdVar = (bd) hVar;
                if (bdVar.vV() == null || bdVar.vV().getGroup_id() == 0 || ba.aU(FrsDynamicFragment.this.getActivity())) {
                    if (bdVar.vO() != 1 || ba.aU(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.ua(bdVar.getId())) {
                            readThreadHistory.tZ(bdVar.getId());
                            if (FrsDynamicFragment.this.dmM != null) {
                                FrsDynamicFragment.this.dmM.auo();
                            }
                        }
                        boolean z = false;
                        final String vt = bdVar.vt();
                        if (vt != null && !vt.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    y yVar = new y(vt);
                                    yVar.yJ().zI().mIsNeedAddCommenParam = false;
                                    yVar.yJ().zI().mIsUseCurrentBDUSS = false;
                                    yVar.ym();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.vh() == 2 && !tid.startsWith("pb:")) {
                            ay.zG().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bdVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, FrsDynamicFragment.this.dhv, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n diG = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void kf(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.dmM.auo();
                    return;
                case 3:
                    FrsDynamicFragment.this.dmM.cm(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.dmM.cm(false);
            if (FrsDynamicFragment.this.dmL.avo() != null) {
                FrsDynamicFragment.this.dmN = FrsDynamicFragment.this.dmL.avo();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.dmN.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (w.z(FrsDynamicFragment.this.dmN.threadList)) {
                    FrsDynamicFragment.this.dmM.TL();
                } else {
                    FrsDynamicFragment.this.dmM.TK();
                }
            } else {
                FrsDynamicFragment.this.dmM.TJ();
            }
            if (i == 4) {
                FrsDynamicFragment.this.dmM.J(FrsDynamicFragment.this.dmN.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.dmM.auo();
                    break;
                case 2:
                    FrsDynamicFragment.this.dmM.auo();
                    break;
            }
            FrsDynamicFragment.this.hideLoadingView();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.atD();
            }
            System.gc();
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void b(i iVar) {
        }
    };
    private CustomMessageListener axl = new CustomMessageListener(2004004) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof bd)) {
                bd bdVar = (bd) customResponsedMessage.getData();
                FrsDynamicFragment.this.dmP = bdVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.dmP) && bdVar.va() != null) {
                    FrsDynamicFragment.this.kw(bdVar.va().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.dmL = new FrsDynamicModelController(this);
        this.dmL.setForumId(Long.parseLong(this.forumId));
        this.dhB = getVoiceManager();
        this.dhB.onCreate(getPageContext());
        registerListener(this.acJ);
        registerListener(this.axl);
        registerListener(this.diu);
        registerListener(this.dmO);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_dynamic_activity, (ViewGroup) null);
        this.dmM = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.dhv = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.dhv = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.dmM.setOnAdapterItemClickListener(this.diM);
        this.dmM.a(this.bws);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dmM != null) {
            this.dmM.auo();
        }
        this.dhB = getVoiceManager();
        this.dhB.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.dhB = getVoiceManager();
        this.dhB.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dmK == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new am("c13008").ah(ImageViewerConfig.FORUM_ID, this.forumId).r("obj_type", 1));
        if (j.jD()) {
            fN(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(boolean z) {
        atG();
        TI();
        if (!z) {
            TI();
            showLoadingView();
        }
        this.dmL.avn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atD() {
        atG();
        try {
            if (this.dmN != null) {
                this.dmM.showListView();
                if (this.dmN.threadList != null) {
                    this.dmM.J(this.dmN.threadList);
                    this.dmM.auo();
                    this.dmM.avp().setFromCDN(true);
                    this.dmM.setListViewSelection(aC(this.dmL.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aC(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void atG() {
        this.dhB = getVoiceManager();
        this.dhB.stopPlay();
    }

    @Override // com.baidu.tieba.frs.ah
    public void TG() {
        if (this.dmM != null) {
            atd();
            this.dmM.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void atd() {
        if (this.dmM != null && this.dmM.getListView() != null) {
            this.dmM.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.dmM != null && this.dmM.getListView() != null) {
            this.dmM.getListView().stopScroll();
        }
        SX();
        if (l.jU() && this.mHasMore && !this.dmL.Ax()) {
            this.mPn++;
            h hVar = (h) w.c(this.dmN.threadList, w.y(this.dmN.threadList) - 1);
            if (hVar instanceof bd) {
                this.dmL.bH(com.baidu.adp.lib.g.b.c(((bd) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd mD;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dmM.avp().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (mD = this.dmN.mD(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.dmN.threadList.remove(mD);
                        if (w.z(this.dmN.threadList)) {
                            this.dmN.threadList.add(new k());
                        }
                        this.dmM.auo();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> asR() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).asR();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dhB == null) {
            this.dhB = VoiceManager.instance();
        }
        return this.dhB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView AJ() {
        if (this.dmM == null) {
            return null;
        }
        return this.dmM.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> AK() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).AK();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (AJ() == null) {
            return null;
        }
        return AJ().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dmK != 3 || this.dmM != null) {
            this.dmK = i;
            super.onChangeSkinType(i);
            if (this.dmM != null) {
                this.dmM.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.dmM.fO(false);
        showLoadingView(this.dmM.avq(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.dmM.fO(true);
        hideLoadingView(this.dmM.avq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dmM.fO(false);
        this.dmM.avr().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dmM.TL();
        this.dmM.getListView().getData().clear();
        this.dmM.auo();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.IX();
            this.mRefreshView.fe(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.IV().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dmM.avq(), true);
    }

    private void TI() {
        this.dmM.fO(true);
        this.dmM.avr().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.IP()) {
            this.mRefreshView.P(this.dmM.avq());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jD()) {
            fN(false);
        }
    }

    private void SX() {
        if (!this.mHasMore) {
            if (w.z(this.dmN.threadList)) {
                this.dmM.TL();
                return;
            } else {
                this.dmM.TK();
                return;
            }
        }
        this.dmM.TJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(int i) {
        if (this.dmN.threadList != null) {
            Iterator<h> it = this.dmN.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dmP)) {
                        a(bdVar, i);
                        this.dmP = null;
                        break;
                    }
                }
            }
            this.dmM.avp().setData(this.dmN.threadList);
            this.dmM.avp().notifyDataSetChanged();
        }
    }

    private void a(bd bdVar, int i) {
        if (i == 1) {
            PraiseData va = bdVar.va();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (va == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.va().getUser().add(0, metaData);
                bdVar.va().setNum(bdVar.va().getNum() + 1);
                bdVar.va().setIsLike(i);
            }
        } else if (bdVar.va() != null) {
            bdVar.va().setIsLike(i);
            bdVar.va().setNum(bdVar.va().getNum() - 1);
            ArrayList<MetaData> user = bdVar.va().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.va().getUser().remove(next);
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
                ak.b(getPageContext());
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
        bundle.putString("name", this.dhv);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.dhB = getVoiceManager();
        this.dhB.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.dhB = getVoiceManager();
        if (this.dhB != null) {
            this.dhB.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dmM != null) {
            this.dmM.onDestroy();
        }
        super.onDestroy();
        this.dmL.onActivityDestroy();
        this.dhB = getVoiceManager();
        this.dhB.onDestory(getPageContext());
    }
}
