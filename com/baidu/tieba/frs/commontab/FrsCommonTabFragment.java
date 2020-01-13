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
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes7.dex */
public class FrsCommonTabFragment extends BaseFragment implements g.c, VoiceManager.c, ah {
    public String forumId;
    private VoiceManager gmi;
    private af gmy;
    private com.baidu.tbadk.k.c gqZ;
    protected c gtA;
    public FrsViewData gtB;
    public boolean gtC;
    public boolean gtD;
    protected b gtz;
    public boolean isBrandForum;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    private int gtE = 3;
    private boolean gtF = true;
    private int bZo = 0;
    private int gne = 0;
    private CustomMessageListener gpd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.tb(num.intValue());
            }
        }
    };
    private CustomMessageListener gnh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.gtz != null) {
                        FrsCommonTabFragment.this.gtz.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.gqZ != null && FrsCommonTabFragment.this.gqZ.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.gtz != null) {
                        FrsCommonTabFragment.this.gtz.hn(true);
                    }
                    FrsCommonTabFragment.this.onListPullRefresh(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener gtG = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.gtz.AV(str);
                }
            }
        }
    };
    private CustomMessageListener gnF = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bDf = FrsCommonTabFragment.this.gtz.bDf();
                    if (bDf != null && bDf.cxl() != null && (bDf.cxl().getTag() instanceof af)) {
                        FrsCommonTabFragment.this.gmy = (af) bDf.cxl().getTag();
                    }
                    if (FrsCommonTabFragment.this.gmy != null && FrsCommonTabFragment.this.gmy.mU() != null) {
                        FrsCommonTabFragment.this.gmy.mU().b(new a.C0050a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.gne += i2;
            if (FrsCommonTabFragment.this.gne >= FrsCommonTabFragment.this.bZo * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.r.c.cIs().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.gtD = bundle.getBoolean("can_auto_play_video");
            this.gtC = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.gtB = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.gtD = arguments.getBoolean("can_auto_play_video");
                this.gtC = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.gtB = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.gmi = getVoiceManager();
        this.gmi.onCreate(getPageContext());
        com.baidu.tieba.r.c.cIs().w(getUniqueId());
        this.gtA = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId);
        registerListener(this.gnh);
        registerListener(this.gtG);
        registerListener(this.gnF);
        this.bZo = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.gtz = new b(this, this.mRootView, this.gtB);
        this.gtz.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bEV();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bF(this.tabId, 2);
    }

    private void bF(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cp("fid", this.forumId);
        if (i == 89) {
            anVar.Z("obj_type", 1);
        } else if (i == 302) {
            anVar.Z("obj_type", 3);
        } else if (i == 502) {
            anVar.Z("obj_type", 8);
        } else if (i == 504) {
            anVar.Z("obj_type", 11);
        }
        anVar.Z("obj_locate", i2);
        anVar.aEm();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.gtz.lJ(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.gpd);
            if (this.gqZ == null) {
                this.gqZ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.gqZ.setTitle(null);
            this.gqZ.setSubText(str);
            this.gqZ.setButtonText(null);
            this.gqZ.attachView(view, z);
            this.gqZ.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.gtz.lJ(true);
        if (this.gqZ != null) {
            this.gqZ.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.gpd);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.gtz != null) {
                this.gtz.hn(false);
                this.gtz.a(dVar);
            }
            if (this.gtA.bFc() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.r.c.cIs().b(getUniqueId(), false);
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
        if (!this.gtA.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.gtz != null) {
            this.gtz.hn(false);
        }
    }

    public void ak(bj bjVar) {
        if (bjVar != null) {
            this.gtA.ak(bjVar);
            this.gtz.scrollToTop();
        }
    }

    public void bsc() {
        if (l.isNetOk()) {
            if (this.gmi != null) {
                this.gmi.stopPlay();
            }
            if (this.gtA != null) {
                this.gtA.aZN();
            }
        }
    }

    private void bEV() {
        if (l.isNetOk()) {
            if (this.gmi != null) {
                this.gmi.stopPlay();
            }
            if (this.gtA != null) {
                this.gtA.bEV();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.gtA.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bEV();
            return;
        }
        this.gtz.hn(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bEV();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.r.c.cIs().x(getUniqueId());
        r.btA().kn(false);
        MessageManager.getInstance().unRegisterListener(this.gpd);
        super.onDestroy();
        if (this.gtz != null) {
            this.gtz.onDestroy();
        }
        if (this.gmi != null) {
            this.gmi.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gtz != null) {
                this.gtz.resume();
            }
            if (this.gtF) {
                this.gtF = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("first_into_tab_profession", true) || bEW()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aDr().putBoolean("first_into_tab_profession", false);
                        bEX();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Br(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                }
            }
            bEZ();
        } else if (this.gtz != null) {
            this.gtz.pause();
        }
        bEr();
    }

    private boolean bEW() {
        return (this.gtB == null || this.gtB.getForum() == null || StringUtils.isNull(this.gtB.getForum().getFirst_class()) || !this.gtB.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void bEX() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.jI(1);
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
        aVar.fz(false);
        aVar.fA(false);
        aVar.b(getPageContext()).aCp();
    }

    private void bEr() {
        if (isPrimary()) {
            if (this.gqZ != null && this.gqZ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.gpd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.gpd);
    }

    public void bEY() {
        if (this.gtz != null) {
            this.gtz.refreshView();
        }
    }

    private void bEZ() {
        if (this.tabId == 502) {
            an anVar = new an("c13376");
            anVar.cp("fid", this.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.gmi != null) {
            this.gmi.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gtz != null) {
            this.gtz.pause();
        }
        if (this.gmi != null) {
            this.gmi.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gtE != 3 || this.gtz != null) {
            this.gtE = i;
            super.onChangeSkinType(i);
            this.gtz.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.gtD);
        bundle.putBoolean("need_log", this.gtC);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.gmi != null) {
            this.gmi.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gmi == null) {
            this.gmi = VoiceManager.instance();
        }
        return this.gmi;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.gmi != null) {
            this.gmi.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.r.c.cIs().b(getUniqueId(), false);
        if (this.gmi != null) {
            this.gmi.onStop(getPageContext());
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
                        this.gtz.AV(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void scrollToTop() {
        this.gtz.scrollToTop();
    }

    @Override // com.baidu.tieba.frs.ah
    public void baZ() {
        this.gtz.baZ();
        this.gtz.hn(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), bFa(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String bFa() {
        if (this.tabId != 89 && this.tabId != 302 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gtB != null) {
            i = this.gtB.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.ub(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void tb(int i) {
        if (this.gqZ != null && this.gqZ.isViewAttached()) {
            this.gqZ.ml(i);
        }
    }
}
