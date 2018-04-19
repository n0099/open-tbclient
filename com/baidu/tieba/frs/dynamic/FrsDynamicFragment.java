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
    private String cXd;
    private VoiceManager cXj;
    private FrsDynamicModelController dcr;
    protected c dcs;
    private String dcw;
    private String forumId;
    private String mFrom;
    private boolean mHasMore;
    private int dcq = 3;
    private b dct = new b();
    private int mPn = 1;
    private final CustomMessageListener UN = new CustomMessageListener(2003003) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && FrsDynamicFragment.this.dcs != null) {
                FrsDynamicFragment.this.dcs.startPullRefresh();
            }
        }
    };
    private CustomMessageListener cXZ = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.xj() != null) {
                        FrsDynamicFragment.this.xj().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Fm()) {
                        FrsDynamicFragment.this.fH(false);
                    } else if (FrsDynamicFragment.this.dcs != null) {
                        FrsDynamicFragment.this.dcs.startPullRefresh();
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                    }
                }
            }
        }
    };
    private CustomMessageListener dcv = new CustomMessageListener(2001625) { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !FrsDynamicFragment.this.dcr.wX()) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 89) {
                    if (FrsDynamicFragment.this.xj() != null) {
                        FrsDynamicFragment.this.xj().setSelection(0);
                    }
                    if (FrsDynamicFragment.this.mRefreshView != null && FrsDynamicFragment.this.mRefreshView.Fm()) {
                        FrsDynamicFragment.this.fH(false);
                    } else if (FrsDynamicFragment.this.dcs != null) {
                        FrsDynamicFragment.this.dcs.startPullRefresh();
                    }
                }
            }
        }
    };
    private final e.b bnX = new e.b() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.4
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            if (j.gP()) {
                d.MH().hX("page_frs_dynamic");
                FrsDynamicFragment.this.fH(true);
                return;
            }
            FrsDynamicFragment.this.dcs.ch(false);
        }
    };
    private n cYr = new n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view2, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (bdUniqueId != null && hVar != null && (hVar instanceof bd)) {
                bd bdVar = (bd) hVar;
                if (bdVar.sz() == null || bdVar.sz().getGroup_id() == 0 || az.aK(FrsDynamicFragment.this.getActivity())) {
                    if (bdVar.ss() != 1 || az.aK(FrsDynamicFragment.this.getActivity())) {
                        com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                        if (readThreadHistory != null && !readThreadHistory.td(bdVar.getId())) {
                            readThreadHistory.tc(bdVar.getId());
                            if (FrsDynamicFragment.this.dcs != null) {
                                FrsDynamicFragment.this.dcs.aqk();
                            }
                        }
                        boolean z = false;
                        final String rX = bdVar.rX();
                        if (rX != null && !rX.equals("")) {
                            z = true;
                            new Thread(new Runnable() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    x xVar = new x(rX);
                                    xVar.vj().wi().mIsNeedAddCommenParam = false;
                                    xVar.vj().wi().mIsUseCurrentBDUSS = false;
                                    xVar.uM();
                                }
                            }).start();
                        }
                        String tid = bdVar.getTid();
                        if (tid == null) {
                            tid = "";
                        }
                        if (bdVar.rL() == 2 && !tid.startsWith("pb:")) {
                            ax.wg().c(FrsDynamicFragment.this.getPageContext(), new String[]{tid, "", null});
                            return;
                        }
                        if (tid.startsWith("pb:")) {
                            bdVar.setId(tid.substring(3));
                        }
                        PbActivityConfig createFromThreadCfg = new PbActivityConfig(FrsDynamicFragment.this.getPageContext().getPageActivity()).createFromThreadCfg(bdVar, FrsDynamicFragment.this.cXd, "frs_page", 18003, true, false, z);
                        createFromThreadCfg.setForumId(String.valueOf(bdVar.getFid()));
                        createFromThreadCfg.setStartFrom(3);
                        FrsDynamicFragment.this.sendMessage(new CustomMessage(2004001, createFromThreadCfg));
                    }
                }
            }
        }
    };
    public final com.baidu.tieba.tbadkCore.n cYk = new com.baidu.tieba.tbadkCore.n() { // from class: com.baidu.tieba.frs.dynamic.FrsDynamicFragment.6
        @Override // com.baidu.tieba.tbadkCore.n
        public void kd(int i) {
            switch (i) {
                case 1:
                case 2:
                    FrsDynamicFragment.this.dcs.aqk();
                    return;
                case 3:
                    FrsDynamicFragment.this.dcs.ch(true);
                    return;
                default:
                    return;
            }
        }

        @Override // com.baidu.tieba.tbadkCore.n
        public void a(int i, boolean z, d.a aVar) {
            FrsDynamicFragment.this.dcs.ch(false);
            if (FrsDynamicFragment.this.dcr.ark() != null) {
                FrsDynamicFragment.this.dct = FrsDynamicFragment.this.dcr.ark();
            }
            FrsDynamicFragment.this.mHasMore = FrsDynamicFragment.this.dct.hasMore;
            if (!FrsDynamicFragment.this.mHasMore) {
                if (v.w(FrsDynamicFragment.this.dct.threadList)) {
                    FrsDynamicFragment.this.dcs.Qq();
                } else {
                    FrsDynamicFragment.this.dcs.Qp();
                }
            } else {
                FrsDynamicFragment.this.dcs.Qo();
            }
            if (i == 4) {
                FrsDynamicFragment.this.dcs.K(FrsDynamicFragment.this.dct.threadList);
                return;
            }
            switch (i) {
                case 1:
                    FrsDynamicFragment.this.dcs.aqk();
                    break;
                case 2:
                    FrsDynamicFragment.this.dcs.aqk();
                    break;
            }
            FrsDynamicFragment.this.Ou();
            if (aVar == null || !aVar.isSuccess) {
                FrsDynamicFragment.this.c(aVar);
            } else {
                FrsDynamicFragment.this.apz();
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
                FrsDynamicFragment.this.dcw = bdVar.getId();
                if (!TextUtils.isEmpty(FrsDynamicFragment.this.dcw) && bdVar.rF() != null) {
                    FrsDynamicFragment.this.ks(bdVar.rF().getIsLike());
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData(bundle);
        this.dcr = new FrsDynamicModelController(this);
        this.dcr.setForumId(Long.parseLong(this.forumId));
        this.cXj = getVoiceManager();
        this.cXj.onCreate(getPageContext());
        registerListener(this.UN);
        registerListener(this.apd);
        registerListener(this.cXZ);
        registerListener(this.dcv);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(d.i.frs_dynamic_activity, (ViewGroup) null);
        this.dcs = new c(this, inflate);
        initUI();
        return inflate;
    }

    private void initData(Bundle bundle) {
        if (bundle != null) {
            this.cXd = bundle.getString("name");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.cXd = arguments.getString("name");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
            }
        }
        if (!TextUtils.isEmpty(this.mFrom) && FrsActivityConfig.FRS_FROM_WRITESHARE.equals(this.mFrom)) {
            getBaseFragmentActivity().setSwipeBackEnabled(false);
        }
    }

    private void initUI() {
        this.dcs.setOnAdapterItemClickListener(this.cYr);
        this.dcs.a(this.bnX);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dcs != null) {
            this.dcs.aqk();
        }
        this.cXj = getVoiceManager();
        this.cXj.onResume(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.cXj = getVoiceManager();
        this.cXj.onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dcq == 3) {
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        TiebaStatic.log(new al("c13008").ac(ImageViewerConfig.FORUM_ID, this.forumId).r("obj_type", 1));
        if (j.gP()) {
            fH(false);
        } else {
            c((d.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fH(boolean z) {
        apC();
        Qn();
        if (!z) {
            Qn();
            showLoadingView();
        }
        this.dcr.arj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apz() {
        apC();
        try {
            if (this.dct != null) {
                this.dcs.showListView();
                if (this.dct.threadList != null) {
                    this.dcs.K(this.dct.threadList);
                    this.dcs.aqk();
                    this.dcs.arl().setFromCDN(true);
                    this.dcs.setListViewSelection(aB(this.dcr.getType(), this.mPn));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    private int aB(int i, int i2) {
        return (i == 1 || (i == 2 && i2 != 1)) ? 3 : 0;
    }

    public void apC() {
        this.cXj = getVoiceManager();
        this.cXj.stopPlay();
    }

    @Override // com.baidu.tieba.frs.ah
    public void Ql() {
        if (this.dcs != null) {
            aoY();
            this.dcs.startPullRefresh();
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void aoY() {
        if (this.dcs != null && this.dcs.getListView() != null) {
            this.dcs.getListView().scrollToPosition(0);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        PC();
        if (l.hg() && this.mHasMore && !this.dcr.wX()) {
            this.mPn++;
            h hVar = (h) v.c(this.dct.threadList, v.v(this.dct.threadList) - 1);
            if (hVar instanceof bd) {
                this.dcr.bD(com.baidu.adp.lib.g.b.c(((bd) hVar).getTid(), 0L));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        bd lT;
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    this.dcs.arl().notifyDataSetChanged();
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null && (lT = this.dct.lT(stringExtra)) != null && intent.getIntExtra("type", -1) == 0) {
                        this.dct.threadList.remove(lT);
                        if (v.w(this.dct.threadList)) {
                            this.dct.threadList.add(new k());
                        }
                        this.dcs.aqk();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> aoM() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).aoM();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.cXj == null) {
            this.cXj = VoiceManager.instance();
        }
        return this.cXj;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    /* renamed from: getListView */
    public BdTypeRecyclerView xj() {
        if (this.dcs == null) {
            return null;
        }
        return this.dcs.getListView();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> xk() {
        if (getBaseFragmentActivity() instanceof FrsActivity) {
            return ((FrsActivity) getBaseFragmentActivity()).xk();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.adp.widget.ListView.k onGetPreLoadListView() {
        if (xj() == null) {
            return null;
        }
        return xj().getPreLoadHandle();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dcq != 3 || this.dcs != null) {
            this.dcq = i;
            super.onChangeSkinType(i);
            if (this.dcs != null) {
                this.dcs.onChangeSkinType(i);
            }
        }
    }

    private void showLoadingView() {
        this.dcs.fI(false);
        showLoadingView(this.dcs.arm(), true, getResources().getDimensionPixelSize(d.e.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ou() {
        this.dcs.fI(true);
        hideLoadingView(this.dcs.arm());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d.a aVar) {
        this.dcs.fI(false);
        this.dcs.arn().setEnabled(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
        this.dcs.Qq();
        this.dcs.getListView().getData().clear();
        this.dcs.aqk();
        if (this.mRefreshView == null) {
            this.mRefreshView = new g(getPageContext().getContext(), getNetRefreshListener());
            this.mRefreshView.setTitle(null);
            this.mRefreshView.setButtonText(null);
            this.mRefreshView.Fu();
            this.mRefreshView.eZ(getResources().getDimensionPixelSize(d.e.ds_102));
            this.mRefreshView.Fs().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (aVar != null) {
            this.mRefreshView.setSubText(getPageContext().getResources().getString(d.k.net_error_text, aVar.errorMsg, Integer.valueOf(aVar.errorCode)));
        } else {
            this.mRefreshView.setSubText(null);
        }
        this.mRefreshView.onChangeSkinType();
        this.mRefreshView.d(this.dcs.arm(), true);
    }

    private void Qn() {
        this.dcs.fI(true);
        this.dcs.arn().setEnabled(true);
        if (this.mRefreshView != null && this.mRefreshView.Fm()) {
            this.mRefreshView.P(this.dcs.arm());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.gP()) {
            fH(false);
        }
    }

    private void PC() {
        if (!this.mHasMore) {
            if (v.w(this.dct.threadList)) {
                this.dcs.Qq();
                return;
            } else {
                this.dcs.Qp();
                return;
            }
        }
        this.dcs.Qo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ks(int i) {
        if (this.dct.threadList != null) {
            Iterator<h> it = this.dct.threadList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h next = it.next();
                if (next instanceof bd) {
                    bd bdVar = (bd) next;
                    if (bdVar.getId() != null && bdVar.getId().equals(this.dcw)) {
                        a(bdVar, i);
                        this.dcw = null;
                        break;
                    }
                }
            }
            this.dcs.arl().setData(this.dct.threadList);
            this.dcs.arl().notifyDataSetChanged();
        }
    }

    private void a(bd bdVar, int i) {
        if (i == 1) {
            PraiseData rF = bdVar.rF();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                MetaData metaData = new MetaData();
                metaData.setName_show(currentAccountObj.getAccount());
                metaData.setPortrait(currentAccountObj.getPortrait());
                metaData.setUserId(currentAccountObj.getID());
                if (rF == null) {
                    PraiseData praiseData = new PraiseData();
                    praiseData.setIsLike(i);
                    praiseData.setNum(1L);
                    praiseData.getUser().add(0, metaData);
                    bdVar.a(praiseData);
                    return;
                }
                bdVar.rF().getUser().add(0, metaData);
                bdVar.rF().setNum(bdVar.rF().getNum() + 1);
                bdVar.rF().setIsLike(i);
            }
        } else if (bdVar.rF() != null) {
            bdVar.rF().setIsLike(i);
            bdVar.rF().setNum(bdVar.rF().getNum() - 1);
            ArrayList<MetaData> user = bdVar.rF().getUser();
            if (user != null) {
                Iterator<MetaData> it = user.iterator();
                while (it.hasNext()) {
                    MetaData next = it.next();
                    if (next.getUserId().equals(TbadkCoreApplication.getCurrentAccountObj().getID())) {
                        bdVar.rF().getUser().remove(next);
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
        bundle.putString("name", this.cXd);
        bundle.putString("from", this.mFrom);
        bundle.putString("forum_id", this.forumId);
        this.cXj = getVoiceManager();
        if (this.cXj != null) {
            this.cXj.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.cXj = getVoiceManager();
        this.cXj.onPause(getPageContext());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        this.cXj = getVoiceManager();
        if (this.cXj != null) {
            this.cXj.onStop(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.dcs != null) {
            this.dcs.onDestroy();
        }
        super.onDestroy();
        this.dcr.onActivityDestroy();
        this.cXj = getVoiceManager();
        this.cXj.onDestory(getPageContext());
    }
}
