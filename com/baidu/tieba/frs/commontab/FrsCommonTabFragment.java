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
/* loaded from: classes6.dex */
public class FrsCommonTabFragment extends BaseFragment implements g.c, VoiceManager.c, ah {
    public String forumId;
    private VoiceManager giZ;
    private af gjo;
    private com.baidu.tbadk.k.c gnQ;
    protected b gqq;
    protected c gqr;
    public FrsViewData gqs;
    public boolean gqt;
    public boolean gqu;
    public boolean isBrandForum;
    public String mFrom;
    protected View mRootView;
    public int tabId;
    private int gqv = 3;
    private boolean gqw = true;
    private int bZc = 0;
    private int gjV = 0;
    private CustomMessageListener glU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.sW(num.intValue());
            }
        }
    };
    private CustomMessageListener gjY = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.gqq != null) {
                        FrsCommonTabFragment.this.gqq.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.gnQ != null && FrsCommonTabFragment.this.gnQ.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    if (FrsCommonTabFragment.this.gqq != null) {
                        FrsCommonTabFragment.this.gqq.hi(true);
                    }
                    FrsCommonTabFragment.this.onListPullRefresh(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener gqx = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.gqq.AL(str);
                }
            }
        }
    };
    private CustomMessageListener gkw = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bCd = FrsCommonTabFragment.this.gqq.bCd();
                    if (bCd != null && bCd.cwe() != null && (bCd.cwe().getTag() instanceof af)) {
                        FrsCommonTabFragment.this.gjo = (af) bCd.cwe().getTag();
                    }
                    if (FrsCommonTabFragment.this.gjo != null && FrsCommonTabFragment.this.gjo.mT() != null) {
                        FrsCommonTabFragment.this.gjo.mT().b(new a.C0050a(3));
                    }
                }
            }
        }
    };
    private final RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FrsCommonTabFragment.this.gjV += i2;
            if (FrsCommonTabFragment.this.gjV >= FrsCommonTabFragment.this.bZc * 2 && i2 < 0) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921437, true));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0) {
                com.baidu.tieba.r.c.cHo().b(FrsCommonTabFragment.this.getUniqueId(), true);
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
            this.gqu = bundle.getBoolean("can_auto_play_video");
            this.gqt = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.gqs = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.mFrom = arguments.getString("from");
                this.forumId = arguments.getString("forum_id");
                this.gqu = arguments.getBoolean("can_auto_play_video");
                this.gqt = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.gqs = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.giZ = getVoiceManager();
        this.giZ.onCreate(getPageContext());
        com.baidu.tieba.r.c.cHo().w(getUniqueId());
        this.gqr = new c(this, com.baidu.adp.lib.f.b.toInt(this.forumId, 0), this.tabId);
        registerListener(this.gjY);
        registerListener(this.gqx);
        registerListener(this.gkw);
        this.bZc = UtilHelper.getScreenHeight(getActivity());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.gqq = new b(this, this.mRootView, this.gqs);
        this.gqq.setOnScrollListener(this.mScrollListener);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bDT();
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
        anVar.aDT();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.gqq.ly(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.glU);
            if (this.gnQ == null) {
                this.gnQ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.gnQ.setTitle(null);
            this.gnQ.setSubText(str);
            this.gnQ.setButtonText(null);
            this.gnQ.attachView(view, z);
            this.gnQ.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.gqq.ly(true);
        if (this.gnQ != null) {
            this.gnQ.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.glU);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.gqq != null) {
                this.gqq.hi(false);
                this.gqq.a(dVar);
            }
            if (this.gqr.bEa() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
            com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
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
        if (!this.gqr.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.gqq != null) {
            this.gqq.hi(false);
        }
    }

    public void aj(bj bjVar) {
        if (bjVar != null) {
            this.gqr.aj(bjVar);
            this.gqq.scrollToTop();
        }
    }

    public void bra() {
        if (l.isNetOk()) {
            if (this.giZ != null) {
                this.giZ.stopPlay();
            }
            if (this.gqr != null) {
                this.gqr.aZs();
            }
        }
    }

    private void bDT() {
        if (l.isNetOk()) {
            if (this.giZ != null) {
                this.giZ.stopPlay();
            }
            if (this.gqr != null) {
                this.gqr.bDT();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.gqr.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bDT();
            return;
        }
        this.gqq.hi(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bDT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        com.baidu.tieba.r.c.cHo().x(getUniqueId());
        r.bsy().kc(false);
        MessageManager.getInstance().unRegisterListener(this.glU);
        super.onDestroy();
        if (this.gqq != null) {
            this.gqq.onDestroy();
        }
        if (this.giZ != null) {
            this.giZ.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        boolean z = true;
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.gqq != null) {
                this.gqq.resume();
            }
            if (this.gqw) {
                this.gqw = false;
                if (this.tabId == 502) {
                    if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("first_into_tab_profession", true) || bDU()) {
                        z = false;
                    }
                    if (z) {
                        com.baidu.tbadk.core.sharedPref.b.aCY().putBoolean("first_into_tab_profession", false);
                        bDV();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).Bh(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503 || this.tabId == 504) {
                    onLazyLoad();
                }
            }
            bDX();
        } else if (this.gqq != null) {
            this.gqq.pause();
        }
        bDp();
    }

    private boolean bDU() {
        return (this.gqs == null || this.gqs.getForum() == null || StringUtils.isNull(this.gqs.getForum().getFirst_class()) || !this.gqs.getForum().getFirst_class().equals(getPageContext().getResources().getString(R.string.is_district_forum))) ? false : true;
    }

    private void bDV() {
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
        aVar.aK(professionDialogLayout);
        aVar.fu(false);
        aVar.fv(false);
        aVar.b(getPageContext()).aBW();
    }

    private void bDp() {
        if (isPrimary()) {
            if (this.gnQ != null && this.gnQ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.glU);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.glU);
    }

    public void bDW() {
        if (this.gqq != null) {
            this.gqq.refreshView();
        }
    }

    private void bDX() {
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
        if (this.giZ != null) {
            this.giZ.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.gqq != null) {
            this.gqq.pause();
        }
        if (this.giZ != null) {
            this.giZ.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.gqv != 3 || this.gqq != null) {
            this.gqv = i;
            super.onChangeSkinType(i);
            this.gqq.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.gqu);
        bundle.putBoolean("need_log", this.gqt);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.giZ != null) {
            this.giZ.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.giZ == null) {
            this.giZ = VoiceManager.instance();
        }
        return this.giZ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.giZ != null) {
            this.giZ.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        com.baidu.tieba.r.c.cHo().b(getUniqueId(), false);
        if (this.giZ != null) {
            this.giZ.onStop(getPageContext());
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
                        this.gqq.AL(stringExtra);
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
        this.gqq.scrollToTop();
    }

    @Override // com.baidu.tieba.frs.ah
    public void baE() {
        this.gqq.baE();
        this.gqq.hi(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.l.b getTbPageExtra() {
        BaseFragmentActivity baseFragmentActivity = getBaseFragmentActivity();
        return new com.baidu.tbadk.l.b(getUniqueId(), bDY(), baseFragmentActivity == null ? null : baseFragmentActivity.getIntent());
    }

    public String bDY() {
        if (this.tabId != 89 && this.tabId != 302 && this.tabId != 502 && this.tabId == 504) {
        }
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        int i = -1;
        if (this.gqs != null) {
            i = this.gqs.getSortType();
        }
        tbPageTag.sortType = com.baidu.tieba.frs.f.g.tW(i);
        tbPageTag.locatePage = PageStayDurationConstants.PageName.FRS;
        return tbPageTag;
    }

    public void sW(int i) {
        if (this.gnQ != null && this.gnQ.isViewAttached()) {
            this.gnQ.ml(i);
        }
    }
}
