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
    private af gYF;
    private VoiceManager gYp;
    private com.baidu.tbadk.k.c hde;
    protected b hfG;
    protected c hfH;
    public FrsViewData hfI;
    public boolean hfJ;
    public boolean hfK;
    public boolean isBrandForum;
    public int isGeneralTab;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    public String tabName;
    private int hfL = 3;
    private boolean hfM = true;
    private int cCF = 0;
    private int gZl = 0;
    private int sortType = 0;
    private CustomMessageListener hbp = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.tH(num.intValue());
            }
        }
    };
    private CustomMessageListener gZo = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.hfG != null) {
                        FrsCommonTabFragment.this.hfG.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.hde != null && FrsCommonTabFragment.this.hde.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.hfG != null) {
                        FrsCommonTabFragment.this.hfG.it(true);
                    }
                    FrsCommonTabFragment.this.aQn();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener hfN = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.hfG.CX(str);
                }
            }
        }
    };
    private CustomMessageListener gZN = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bPv = FrsCommonTabFragment.this.hfG.bPv();
                    if (bPv != null && bPv.cJH() != null && (bPv.cJH().getTag() instanceof af)) {
                        FrsCommonTabFragment.this.gYF = (af) bPv.cJH().getTag();
                    }
                    if (FrsCommonTabFragment.this.gYF != null && FrsCommonTabFragment.this.gYF.rD() != null) {
                        FrsCommonTabFragment.this.gYF.rD().b(new a.C0074a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.gZl += i2;
            if (FrsCommonTabFragment.this.gZl >= FrsCommonTabFragment.this.cCF * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.cVr().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.hfK = bundle.getBoolean("can_auto_play_video");
            this.hfJ = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.tabName = bundle.getString("tab_name");
            this.isGeneralTab = bundle.getInt("is_general_tab");
            this.hfI = (FrsViewData) bundle.getSerializable("view_data");
            if (this.isGeneralTab != 1) {
                this.sortType = bundle.getInt(PbActivityConfig.KEY_SORTTYPE, 0);
            }
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.hfK = arguments.getBoolean("can_auto_play_video");
                this.hfJ = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.tabName = arguments.getString("tab_name");
                this.isGeneralTab = arguments.getInt("is_general_tab");
                this.hfI = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.gYp = getVoiceManager();
        this.gYp.onCreate(getPageContext());
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
        this.hfH = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId, this.tabName, this.isGeneralTab);
        registerListener(this.gZo);
        registerListener(this.hfN);
        registerListener(this.gZN);
        this.cCF = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.hfG = new b(this, this.mRootView, this.hfI);
        this.hfG.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bRn();
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
        anVar.aOR();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.hfG.mV(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.hbp);
            if (this.hde == null) {
                this.hde = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.hde.setTitle(null);
            this.hde.setSubText(str);
            this.hde.setButtonText(null);
            this.hde.attachView(view, z);
            this.hde.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.hfG.mV(true);
        if (this.hde != null) {
            this.hde.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            this.sortType = dVar.sortType;
            if (this.hfG != null) {
                this.hfG.it(false);
                this.hfG.bQT();
                this.hfG.a(dVar);
            }
            if (this.hfH.bRx() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
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
        if (!this.hfH.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.hfG != null) {
            this.hfG.it(false);
        }
    }

    public void ao(bj bjVar) {
        if (bjVar != null) {
            this.hfH.ao(bjVar);
            this.hfG.bOe();
        }
    }

    public void bDz() {
        if (l.isNetOk()) {
            if (this.gYp != null) {
                this.gYp.stopPlay();
            }
            if (this.hfH != null) {
                this.hfH.tK(this.sortType);
            }
        }
    }

    private void bRn() {
        if (l.isNetOk()) {
            if (this.gYp != null) {
                this.gYp.stopPlay();
            }
            if (this.hfH != null) {
                this.hfH.tJ(this.sortType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bRn();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        r.bEY().lx(false);
        MessageManager.getInstance().unRegisterListener(this.hbp);
        super.onDestroy();
        if (this.hfG != null) {
            this.hfG.onDestroy();
        }
        if (this.gYp != null) {
            this.gYp.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.hfG != null) {
                this.hfG.resume();
            }
            if (this.hfM) {
                this.hfM = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("first_into_tab_profession", true) || bRo()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aNV().putBoolean("first_into_tab_profession", false);
                        bRp();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Ds(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                }
            }
            bRr();
        } else if (this.hfG != null) {
            this.hfG.pause();
        }
        bQJ();
    }

    private boolean bRo() {
        return (this.hfI == null || this.hfI.getForum() == null || StringUtils.isNull(this.hfI.getForum().getFirst_class()) || !this.hfI.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void bRp() {
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
        aVar.b(getPageContext()).aMU();
    }

    private void bQJ() {
        if (isPrimary()) {
            if (this.hde != null && this.hde.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hbp);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hbp);
    }

    public void bRq() {
        if (this.hfG != null) {
            this.hfG.refreshView();
        }
    }

    private void bRr() {
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
        if (this.gYp != null) {
            this.gYp.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.hfG != null) {
            this.hfG.pause();
        }
        if (this.gYp != null) {
            this.gYp.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.hfL != 3 || this.hfG != null) {
            this.hfL = i;
            super.onChangeSkinType(i);
            this.hfG.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.hfK);
        bundle.putBoolean("need_log", this.hfJ);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        bundle.putString("tab_name", this.tabName);
        bundle.putInt("is_general_tab", this.isGeneralTab);
        if (this.isGeneralTab != 1) {
            bundle.putInt(PbActivityConfig.KEY_SORTTYPE, this.sortType);
        }
        if (this.gYp != null) {
            this.gYp.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYp == null) {
            this.gYp = VoiceManager.instance();
        }
        return this.gYp;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gYp != null) {
            this.gYp.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
        if (this.gYp != null) {
            this.gYp.onStop(getPageContext());
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
                        this.hfG.CX(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.al
    public void bOe() {
        this.hfG.bOe();
    }

    @Override // com.baidu.tieba.frs.al
    public void bmn() {
        this.hfG.it(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), bRs(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String bRs() {
        if (this.tabId != 89 && this.tabId != 302 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.hfI != null) {
            i = this.hfI.getSortType();
        }
        tbPageTag.sortType = g.uK(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void tH(int i) {
        if (this.hde != null && this.hde.isViewAttached()) {
            this.hde.mQ(i);
        }
    }

    public c bRt() {
        return this.hfH;
    }

    public b bRu() {
        return this.hfG;
    }

    public void setSortType(int i) {
        this.sortType = i;
    }

    public int getSortType() {
        return this.sortType;
    }

    @Override // com.baidu.tieba.frs.an
    public void aQn() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.hfH.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bRn();
            return;
        }
        this.hfG.it(false);
    }

    @Override // com.baidu.tieba.frs.an
    public void aQo() {
    }
}
