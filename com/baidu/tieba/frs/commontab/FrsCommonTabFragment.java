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
/* loaded from: classes9.dex */
public class FrsCommonTabFragment extends BaseFragment implements g.c, VoiceManager.c, ah {
    public String forumId;
    private af goO;
    private VoiceManager goy;
    private com.baidu.tbadk.k.c gtp;
    protected b gvO;
    protected c gvP;
    public FrsViewData gvQ;
    public boolean gvR;
    public boolean gvS;
    public boolean isBrandForum;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    private int gvT = 3;
    private boolean gvU = true;
    private int cdw = 0;
    private int gpu = 0;
    private CustomMessageListener grt = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.th(num.intValue());
            }
        }
    };
    private CustomMessageListener gpx = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.gvO != null) {
                        FrsCommonTabFragment.this.gvO.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.gtp != null && FrsCommonTabFragment.this.gtp.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.gvO != null) {
                        FrsCommonTabFragment.this.gvO.hu(true);
                    }
                    FrsCommonTabFragment.this.onListPullRefresh(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener gvV = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.gvO.Bm(str);
                }
            }
        }
    };
    private CustomMessageListener gpV = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bEL = FrsCommonTabFragment.this.gvO.bEL();
                    if (bEL != null && bEL.cyJ() != null && (bEL.cyJ().getTag() instanceof af)) {
                        FrsCommonTabFragment.this.goO = (af) bEL.cyJ().getTag();
                    }
                    if (FrsCommonTabFragment.this.goO != null && FrsCommonTabFragment.this.goO.nk() != null) {
                        FrsCommonTabFragment.this.goO.nk().b(new a.C0052a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.gpu += i2;
            if (FrsCommonTabFragment.this.gpu >= FrsCommonTabFragment.this.cdw * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.s.c.cKb().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.gvS = bundle.getBoolean("can_auto_play_video");
            this.gvR = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.gvQ = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.gvS = arguments.getBoolean("can_auto_play_video");
                this.gvR = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.gvQ = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.goy = getVoiceManager();
        this.goy.onCreate(getPageContext());
        com.baidu.tieba.s.c.cKb().w(getUniqueId());
        this.gvP = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId);
        registerListener(this.gpx);
        registerListener(this.gvV);
        registerListener(this.gpV);
        this.cdw = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.gvO = new b(this, this.mRootView, this.gvQ);
        this.gvO.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bGA();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bG(this.tabId, 2);
    }

    private void bG(int i, int i2) {
        an anVar = new an("c13008");
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.cy("fid", this.forumId);
        if (i == 89) {
            anVar.X("obj_type", 1);
        } else if (i == 302) {
            anVar.X("obj_type", 3);
        } else if (i == 502) {
            anVar.X("obj_type", 8);
        } else if (i == 504) {
            anVar.X("obj_type", 11);
        }
        anVar.X("obj_locate", i2);
        anVar.aGz();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.gvO.lM(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.grt);
            if (this.gtp == null) {
                this.gtp = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.gtp.setTitle(null);
            this.gtp.setSubText(str);
            this.gtp.setButtonText(null);
            this.gtp.attachView(view, z);
            this.gtp.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.gvO.lM(true);
        if (this.gtp != null) {
            this.gtp.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.grt);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.gvO != null) {
                this.gvO.hu(false);
                this.gvO.a(dVar);
            }
            if (this.gvP.bGH() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
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
        if (!this.gvP.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.gvO != null) {
            this.gvO.hu(false);
        }
    }

    public void al(bj bjVar) {
        if (bjVar != null) {
            this.gvP.al(bjVar);
            this.gvO.scrollToTop();
        }
    }

    public void btJ() {
        if (l.isNetOk()) {
            if (this.goy != null) {
                this.goy.stopPlay();
            }
            if (this.gvP != null) {
                this.gvP.bcg();
            }
        }
    }

    private void bGA() {
        if (l.isNetOk()) {
            if (this.goy != null) {
                this.goy.stopPlay();
            }
            if (this.gvP != null) {
                this.gvP.bGA();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.gvP.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bGA();
            return;
        }
        this.gvO.hu(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bGA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.s.c.cKb().x(getUniqueId());
        r.bvh().kp(false);
        MessageManager.getInstance().unRegisterListener(this.grt);
        super.onDestroy();
        if (this.gvO != null) {
            this.gvO.onDestroy();
        }
        if (this.goy != null) {
            this.goy.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gvO != null) {
                this.gvO.resume();
            }
            if (this.gvU) {
                this.gvU = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("first_into_tab_profession", true) || bGB()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aFD().putBoolean("first_into_tab_profession", false);
                        bGC();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).BI(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                }
            }
            bGE();
        } else if (this.gvO != null) {
            this.gvO.pause();
        }
        bFW();
    }

    private boolean bGB() {
        return (this.gvQ == null || this.gvQ.getForum() == null || StringUtils.isNull(this.gvQ.getForum().getFirst_class()) || !this.gvQ.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void bGC() {
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
        aVar.fG(false);
        aVar.fH(false);
        aVar.b(getPageContext()).aEC();
    }

    private void bFW() {
        if (isPrimary()) {
            if (this.gtp != null && this.gtp.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.grt);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.grt);
    }

    public void bGD() {
        if (this.gvO != null) {
            this.gvO.refreshView();
        }
    }

    private void bGE() {
        if (this.tabId == 502) {
            an anVar = new an("c13376");
            anVar.cy("fid", this.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.goy != null) {
            this.goy.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gvO != null) {
            this.gvO.pause();
        }
        if (this.goy != null) {
            this.goy.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gvT != 3 || this.gvO != null) {
            this.gvT = i;
            super.onChangeSkinType(i);
            this.gvO.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.gvS);
        bundle.putBoolean("need_log", this.gvR);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.goy != null) {
            this.goy.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.goy == null) {
            this.goy = VoiceManager.instance();
        }
        return this.goy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.goy != null) {
            this.goy.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.s.c.cKb().b(getUniqueId(), false);
        if (this.goy != null) {
            this.goy.onStop(getPageContext());
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
                        this.gvO.Bm(stringExtra);
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
        this.gvO.scrollToTop();
    }

    @Override // com.baidu.tieba.frs.ah
    public void bdr() {
        this.gvO.bdr();
        this.gvO.hu(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), bGF(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String bGF() {
        if (this.tabId != 89 && this.tabId != 302 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gvQ != null) {
            i = this.gvQ.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.uh(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void th(int i) {
        if (this.gtp != null && this.gtp.isViewAttached()) {
            this.gtp.mD(i);
        }
    }
}
