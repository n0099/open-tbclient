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
import com.baidu.card.af;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes9.dex */
public class FrsCommonTabFragment extends BaseFragment implements g.c, VoiceManager.c, ai {
    public String forumId;
    private VoiceManager gpi;
    private af gpy;
    private com.baidu.tbadk.k.c gtT;
    protected b gwv;
    protected c gww;
    public FrsViewData gwx;
    public boolean gwy;
    public boolean gwz;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    private int gwA = 3;
    private boolean gwB = true;
    private int cdH = 0;
    private int gqe = 0;
    private int sortType = 0;
    private CustomMessageListener gsd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.tj(num.intValue());
            }
        }
    };
    private CustomMessageListener gqh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.gwv != null) {
                        FrsCommonTabFragment.this.gwv.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.gtT != null && FrsCommonTabFragment.this.gtT.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.gwv != null) {
                        FrsCommonTabFragment.this.gwv.hv(true);
                    }
                    FrsCommonTabFragment.this.onListPullRefresh(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener gwC = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.gwv.Bm(str);
                }
            }
        }
    };
    private CustomMessageListener gqF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bEV = FrsCommonTabFragment.this.gwv.bEV();
                    if (bEV != null && bEV.czc() != null && (bEV.czc().getTag() instanceof af)) {
                        FrsCommonTabFragment.this.gpy = (af) bEV.czc().getTag();
                    }
                    if (FrsCommonTabFragment.this.gpy != null && FrsCommonTabFragment.this.gpy.nk() != null) {
                        FrsCommonTabFragment.this.gpy.nk().b(new a.C0052a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.gqe += i2;
            if (FrsCommonTabFragment.this.gqe >= FrsCommonTabFragment.this.cdH * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.cKv().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.gwz = bundle.getBoolean("can_auto_play_video");
            this.gwy = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.gwx = (FrsViewData) bundle.getSerializable("view_data");
            if (this.isGeneralTab != 1) {
                this.sortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
            }
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.gwz = arguments.getBoolean("can_auto_play_video");
                this.gwy = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.gwx = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.gpi = getVoiceManager();
        this.gpi.onCreate(getPageContext());
        com.baidu.tieba.s.c.cKv().w(getUniqueId());
        this.gww = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        registerListener(this.gqh);
        registerListener(this.gwC);
        registerListener(this.gqF);
        this.cdH = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.gwv = new b(this, this.mRootView, this.gwx);
        this.gwv.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bGM();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bH(this.tabId, 2);
    }

    private void bH(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cx("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cx("fid", this.forumId);
        if (i == 89) {
            anVar.X("obj_type", 1);
        } else if (i == 302) {
            anVar.X("obj_type", 3);
        } else if (i == 502) {
            anVar.X("obj_type", 8);
        } else if (i == 504) {
            anVar.X("obj_type", 11);
        } else if (this.isGeneralTab == 1) {
            anVar.X("obj_type", 12);
        }
        anVar.X("obj_locate", i2);
        anVar.aGD();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.gwv.lR(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.gsd);
            if (this.gtT == null) {
                this.gtT = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.gtT.setTitle(null);
            this.gtT.setSubText(str);
            this.gtT.setButtonText(null);
            this.gtT.attachView(view, z);
            this.gtT.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.gwv.lR(true);
        if (this.gtT != null) {
            this.gtT.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.gsd);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.gwv != null) {
                this.gwv.hv(false);
                this.gwv.bGr();
                this.gwv.a(dVar);
            }
            if (this.gww.bGW() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
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
        if (!this.gww.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.gwv != null) {
            this.gwv.hv(false);
        }
    }

    public void am(bj bjVar) {
        if (bjVar != null) {
            this.gww.am(bjVar);
            this.gwv.scrollToTop();
        }
    }

    public void btO() {
        if (l.isNetOk()) {
            if (this.gpi != null) {
                this.gpi.stopPlay();
            }
            if (this.gww != null) {
                this.gww.tm(this.sortType);
            }
        }
    }

    private void bGM() {
        if (l.isNetOk()) {
            if (this.gpi != null) {
                this.gpi.stopPlay();
            }
            if (this.gww != null) {
                this.gww.tl(this.sortType);
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.gww.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bGM();
            return;
        }
        this.gwv.hv(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bGM();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKv().x(getUniqueId());
        r.bvm().ku(false);
        MessageManager.getInstance().unRegisterListener(this.gsd);
        super.onDestroy();
        if (this.gwv != null) {
            this.gwv.onDestroy();
        }
        if (this.gpi != null) {
            this.gpi.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gwv != null) {
                this.gwv.resume();
            }
            if (this.gwB) {
                this.gwB = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("first_into_tab_profession", true) && !bGN()) {
                        com.baidu.tbadk.core.sharedPref.b.aFH().putBoolean("first_into_tab_profession", false);
                        bGO();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).BH(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                }
            }
            com.baidu.tieba.frs.a.bDd().lh(this.isGeneralTab == 1);
            bGQ();
        } else if (this.gwv != null) {
            this.gwv.pause();
        }
        bGh();
    }

    private boolean bGN() {
        return (this.gwx == null || this.gwx.getForum() == null || StringUtils.isNull(this.gwx.getForum().getFirst_class()) || !this.gwx.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void bGO() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.jZ(1);
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
        aVar.aO(professionDialogLayout);
        aVar.fH(false);
        aVar.fI(false);
        aVar.b(getPageContext()).aEG();
    }

    private void bGh() {
        if (isPrimary()) {
            if (this.gtT != null && this.gtT.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gsd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gsd);
    }

    public void bGP() {
        if (this.gwv != null) {
            this.gwv.refreshView();
        }
    }

    private void bGQ() {
        if (this.tabId == 502) {
            an anVar = new an("c13376");
            anVar.cx("fid", this.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gpi != null) {
            this.gpi.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gwv != null) {
            this.gwv.pause();
        }
        if (this.gpi != null) {
            this.gpi.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gwA != 3 || this.gwv != null) {
            this.gwA = i;
            super.onChangeSkinType(i);
            this.gwv.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.gwz);
        bundle.putBoolean("need_log", this.gwy);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.gpi != null) {
            this.gpi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gpi == null) {
            this.gpi = VoiceManager.instance();
        }
        return this.gpi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gpi != null) {
            this.gpi.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cKv().b(getUniqueId(), false);
        if (this.gpi != null) {
            this.gpi.onStop(getPageContext());
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
                        this.gwv.Bm(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void scrollToTop() {
        this.gwv.scrollToTop();
    }

    @Override // com.baidu.tieba.frs.ai
    public void bdw() {
        this.gwv.bdw();
        this.gwv.hv(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), bGR(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String bGR() {
        if (this.tabId != 89 && this.tabId != 302 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gwx != null) {
            i = this.gwx.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.un(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void tj(int i) {
        if (this.gtT != null && this.gtT.isViewAttached()) {
            this.gtT.mF(i);
        }
    }

    public c bGS() {
        return this.gww;
    }

    public b bGT() {
        return this.gwv;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }
}
