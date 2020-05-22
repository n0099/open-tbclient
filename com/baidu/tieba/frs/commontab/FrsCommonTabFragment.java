package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.card.a.a;
import com.baidu.card.ag;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.s;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes9.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, al, an {
    public String forumId;
    private VoiceManager hnh;
    private ag hnx;
    private com.baidu.tbadk.k.c hrY;
    protected b huA;
    protected c huB;
    public FrsViewData huC;
    public boolean huD;
    public boolean huE;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    private int huF = 3;
    private boolean huG = true;
    private int cOy = 0;
    private int hod = 0;
    private int sortType = 0;
    private CustomMessageListener hqj = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.um(num.intValue());
            }
        }
    };
    private CustomMessageListener hoi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.huA != null) {
                        FrsCommonTabFragment.this.huA.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.hrY != null && FrsCommonTabFragment.this.hrY.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.huA != null) {
                        FrsCommonTabFragment.this.huA.iQ(true);
                    }
                    FrsCommonTabFragment.this.aWo();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener huH = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.huA.EJ(str);
                }
            }
        }
    };
    private CustomMessageListener hoH = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bVQ = FrsCommonTabFragment.this.huA.bVQ();
                    if (bVQ != null && bVQ.cQE() != null && (bVQ.cQE().getTag() instanceof ag)) {
                        FrsCommonTabFragment.this.hnx = (ag) bVQ.cQE().getTag();
                    }
                    if (FrsCommonTabFragment.this.hnx != null && FrsCommonTabFragment.this.hnx.rM() != null) {
                        FrsCommonTabFragment.this.hnx.rM().b(new a.C0097a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.hod += i2;
            if (FrsCommonTabFragment.this.hod >= FrsCommonTabFragment.this.cOy * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.dct().b(FrsCommonTabFragment.this.getUniqueId(), true);
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tabId = bundle.getInt("tab_id");
            this.mFrom = bundle.getString("from");
            this.forumId = bundle.getString("forum_id");
            this.huE = bundle.getBoolean("can_auto_play_video");
            this.huD = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.huC = (FrsViewData) bundle.getSerializable("view_data");
            if (this.isGeneralTab != 1) {
                this.sortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
            }
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.huE = arguments.getBoolean("can_auto_play_video");
                this.huD = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.huC = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.hnh = getVoiceManager();
        this.hnh.onCreate(getPageContext());
        com.baidu.tieba.s.c.dct().z(getUniqueId());
        this.huB = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        registerListener(this.hoi);
        registerListener(this.huH);
        registerListener(this.hoH);
        this.cOy = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.huA = new b(this, this.mRootView, this.huC);
        this.huA.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bXI();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bS(this.tabId, 2);
    }

    private void bS(int i, int i2) {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.dh("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.dh("fid", this.forumId);
        if (i == 89) {
            anVar.ag("obj_type", 1);
        } else if (i == 302) {
            anVar.ag("obj_type", 3);
        } else if (i == 502) {
            anVar.ag("obj_type", 8);
        } else if (i == 504) {
            anVar.ag("obj_type", 11);
        } else if (this.isGeneralTab == 1) {
            anVar.ag("obj_type", 12);
        }
        anVar.ag("obj_locate", i2);
        anVar.aUS();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.huA.nq(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.hqj);
            if (this.hrY == null) {
                this.hrY = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.hrY.setTitle(null);
            this.hrY.setSubText(str);
            this.hrY.setButtonText(null);
            this.hrY.attachView(view, z);
            this.hrY.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.huA.nq(true);
        if (this.hrY != null) {
            this.hrY.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.huA != null) {
                this.huA.iQ(false);
                this.huA.bXo();
                this.huA.a(dVar);
            }
            if (this.huB.bXS() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.huB.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.huA != null) {
            this.huA.iQ(false);
        }
    }

    public void ap(bk bkVar) {
        if (bkVar != null) {
            this.huB.ap(bkVar);
            this.huA.bUy();
        }
    }

    public void bJP() {
        if (l.isNetOk()) {
            if (this.hnh != null) {
                this.hnh.stopPlay();
            }
            if (this.huB != null) {
                this.huB.up(this.sortType);
            }
        }
    }

    private void bXI() {
        if (l.isNetOk()) {
            if (this.hnh != null) {
                this.hnh.stopPlay();
            }
            if (this.huB != null) {
                this.huB.uo(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bXI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.dct().A(getUniqueId());
        s.bLq().lT(false);
        MessageManager.getInstance().unRegisterListener(this.hqj);
        super.onDestroy();
        if (this.huA != null) {
            this.huA.onDestroy();
        }
        if (this.hnh != null) {
            this.hnh.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.huA != null) {
                this.huA.resume();
            }
            if (this.huG) {
                this.huG = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("first_into_tab_profession", true) || bXJ()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aTX().putBoolean("first_into_tab_profession", false);
                        bXK();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Fe(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                }
            }
            bXM();
        } else if (this.huA != null) {
            this.huA.pause();
        }
        bXe();
    }

    private boolean bXJ() {
        return (this.huC == null || this.huC.getForum() == null || StringUtils.isNull(this.huC.getForum().getFirst_class()) || !this.huC.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void bXK() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kG(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        professionDialogLayout.setCloseViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.aP(professionDialogLayout);
        aVar.gW(false);
        aVar.gX(false);
        aVar.b(getPageContext()).aST();
    }

    private void bXe() {
        if (isPrimary()) {
            if (this.hrY != null && this.hrY.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hqj);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hqj);
    }

    public void bXL() {
        if (this.huA != null) {
            this.huA.refreshView();
        }
    }

    private void bXM() {
        if (this.tabId == 502) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13376");
            anVar.dh("fid", this.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.hnh != null) {
            this.hnh.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.huA != null) {
            this.huA.pause();
        }
        if (this.hnh != null) {
            this.hnh.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.huF != 3 || this.huA != null) {
            this.huF = i;
            super.onChangeSkinType(i);
            this.huA.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.huE);
        bundle.putBoolean("need_log", this.huD);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.hnh != null) {
            this.hnh.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hnh == null) {
            this.hnh = VoiceManager.instance();
        }
        return this.hnh;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.hnh != null) {
            this.hnh.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.dct().b(getUniqueId(), false);
        if (this.hnh != null) {
            this.hnh.onStop(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_FRS_TO_PB /* 18003 */:
                    String stringExtra = intent.getStringExtra("tid");
                    int intExtra = intent.getIntExtra("type", -1);
                    if (!StringUtils.isNull(stringExtra) && intExtra == 0) {
                        this.huA.EJ(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bUy() {
        this.huA.bUy();
    }

    @Override // com.baidu.tieba.frs.al
    public void brJ() {
        this.huA.iQ(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), bXN(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String bXN() {
        if (this.tabId != 89 && this.tabId != 302 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.huC != null) {
            i = this.huC.getSortType();
        }
        tbPageTag.sortType = g.vq(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void um(int i) {
        if (this.hrY != null && this.hrY.isViewAttached()) {
            this.hrY.ns(i);
        }
    }

    public c bXO() {
        return this.huB;
    }

    public b bXP() {
        return this.huA;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.an
    public void aWo() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.huB.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bXI();
            return;
        }
        this.huA.iQ(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aWp() {
    }
}
