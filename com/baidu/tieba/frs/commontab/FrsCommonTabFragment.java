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
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.card.r;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.f.g;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes9.dex */
public class FrsCommonTabFragment extends BaseFragment implements VoiceManager.c, al, an {
    public String forumId;
    private af gYL;
    private VoiceManager gYv;
    private com.baidu.tbadk.k.c hdk;
    protected b hfM;
    protected c hfN;
    public FrsViewData hfO;
    public boolean hfP;
    public boolean hfQ;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    private int hfR = 3;
    private boolean hfS = true;
    private int cCL = 0;
    private int gZr = 0;
    private int sortType = 0;
    private CustomMessageListener hbv = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.tH(num.intValue());
            }
        }
    };
    private CustomMessageListener gZu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.hfM != null) {
                        FrsCommonTabFragment.this.hfM.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.hdk != null && FrsCommonTabFragment.this.hdk.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.hfM != null) {
                        FrsCommonTabFragment.this.hfM.it(true);
                    }
                    FrsCommonTabFragment.this.aQk();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener hfT = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.hfM.Da(str);
                }
            }
        }
    };
    private CustomMessageListener gZT = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bPu = FrsCommonTabFragment.this.hfM.bPu();
                    if (bPu != null && bPu.cJF() != null && (bPu.cJF().getTag() instanceof af)) {
                        FrsCommonTabFragment.this.gYL = (af) bPu.cJF().getTag();
                    }
                    if (FrsCommonTabFragment.this.gYL != null && FrsCommonTabFragment.this.gYL.rD() != null) {
                        FrsCommonTabFragment.this.gYL.rD().b(new a.C0095a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.gZr += i2;
            if (FrsCommonTabFragment.this.gZr >= FrsCommonTabFragment.this.cCL * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.cVp().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.hfQ = bundle.getBoolean("can_auto_play_video");
            this.hfP = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.hfO = (FrsViewData) bundle.getSerializable("view_data");
            if (this.isGeneralTab != 1) {
                this.sortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
            }
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.hfQ = arguments.getBoolean("can_auto_play_video");
                this.hfP = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.hfO = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.gYv = getVoiceManager();
        this.gYv.onCreate(getPageContext());
        com.baidu.tieba.s.c.cVp().w(getUniqueId());
        this.hfN = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        registerListener(this.gZu);
        registerListener(this.hfT);
        registerListener(this.gZT);
        this.cCL = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.hfM = new b(this, this.mRootView, this.hfO);
        this.hfM.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bRm();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bN(this.tabId, 2);
    }

    private void bN(int i, int i2) {
        com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13008");
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cI("fid", this.forumId);
        if (i == 89) {
            anVar.af("obj_type", 1);
        } else if (i == 302) {
            anVar.af("obj_type", 3);
        } else if (i == 502) {
            anVar.af("obj_type", 8);
        } else if (i == 504) {
            anVar.af("obj_type", 11);
        } else if (this.isGeneralTab == 1) {
            anVar.af("obj_type", 12);
        }
        anVar.af("obj_locate", i2);
        anVar.aOO();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.hfM.mV(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.hbv);
            if (this.hdk == null) {
                this.hdk = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.hdk.setTitle(null);
            this.hdk.setSubText(str);
            this.hdk.setButtonText(null);
            this.hdk.attachView(view, z);
            this.hdk.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.hfM.mV(true);
        if (this.hdk != null) {
            this.hdk.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.hbv);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.hfM != null) {
                this.hfM.it(false);
                this.hfM.bQS();
                this.hfM.a(dVar);
            }
            if (this.hfN.bRw() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.cVp().b(getUniqueId(), false);
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
        if (!this.hfN.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.hfM != null) {
            this.hfM.it(false);
        }
    }

    public void ao(bj bjVar) {
        if (bjVar != null) {
            this.hfN.ao(bjVar);
            this.hfM.bOd();
        }
    }

    public void bDy() {
        if (l.isNetOk()) {
            if (this.gYv != null) {
                this.gYv.stopPlay();
            }
            if (this.hfN != null) {
                this.hfN.tK(this.sortType);
            }
        }
    }

    private void bRm() {
        if (l.isNetOk()) {
            if (this.gYv != null) {
                this.gYv.stopPlay();
            }
            if (this.hfN != null) {
                this.hfN.tJ(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bRm();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cVp().x(getUniqueId());
        r.bEX().lx(false);
        MessageManager.getInstance().unRegisterListener(this.hbv);
        super.onDestroy();
        if (this.hfM != null) {
            this.hfM.onDestroy();
        }
        if (this.gYv != null) {
            this.gYv.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.hfM != null) {
                this.hfM.resume();
            }
            if (this.hfS) {
                this.hfS = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("first_into_tab_profession", true) || bRn()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aNT().putBoolean("first_into_tab_profession", false);
                        bRo();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Dv(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                }
            }
            bRq();
        } else if (this.hfM != null) {
            this.hfM.pause();
        }
        bQI();
    }

    private boolean bRn() {
        return (this.hfO == null || this.hfO.getForum() == null || StringUtils.isNull(this.hfO.getForum().getFirst_class()) || !this.hfO.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void bRo() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.kg(1);
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
        aVar.gE(false);
        aVar.gF(false);
        aVar.b(getPageContext()).aMS();
    }

    private void bQI() {
        if (isPrimary()) {
            if (this.hdk != null && this.hdk.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hbv);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hbv);
    }

    public void bRp() {
        if (this.hfM != null) {
            this.hfM.refreshView();
        }
    }

    private void bRq() {
        if (this.tabId == 502) {
            com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13376");
            anVar.cI("fid", this.forumId);
            anVar.t("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gYv != null) {
            this.gYv.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hfM != null) {
            this.hfM.pause();
        }
        if (this.gYv != null) {
            this.gYv.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hfR != 3 || this.hfM != null) {
            this.hfR = i;
            super.onChangeSkinType(i);
            this.hfM.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.hfQ);
        bundle.putBoolean("need_log", this.hfP);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.gYv != null) {
            this.gYv.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYv == null) {
            this.gYv = VoiceManager.instance();
        }
        return this.gYv;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gYv != null) {
            this.gYv.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cVp().b(getUniqueId(), false);
        if (this.gYv != null) {
            this.gYv.onStop(getPageContext());
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
                        this.hfM.Da(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bOd() {
        this.hfM.bOd();
    }

    @Override // com.baidu.tieba.frs.al
    public void bml() {
        this.hfM.it(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), bRr(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String bRr() {
        if (this.tabId != 89 && this.tabId != 302 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hfO != null) {
            i = this.hfO.getSortType();
        }
        tbPageTag.sortType = g.uK(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void tH(int i) {
        if (this.hdk != null && this.hdk.isViewAttached()) {
            this.hdk.mQ(i);
        }
    }

    public c bRs() {
        return this.hfN;
    }

    public b bRt() {
        return this.hfM;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.an
    public void aQk() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.hfN.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bRm();
            return;
        }
        this.hfM.it(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aQl() {
    }
}
