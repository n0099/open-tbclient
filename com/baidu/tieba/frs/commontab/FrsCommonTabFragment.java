package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
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
import com.baidu.card.z;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class FrsCommonTabFragment extends BaseFragment implements h.c, VoiceManager.c, ag {
    protected b fCf;
    protected c fCg;
    public FrsViewData fCh;
    public boolean fCi;
    public boolean fCj;
    public String forumId;
    private z fuN;
    private VoiceManager fuw;
    private com.baidu.tbadk.m.c fzu;
    public boolean isBrandForum;
    protected View mRootView;
    public int tabId;
    private int fCk = 3;
    private boolean fCl = true;
    private CustomMessageListener fxx = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.qQ(num.intValue());
            }
        }
    };
    private CustomMessageListener fvB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.fCf != null) {
                        FrsCommonTabFragment.this.fCf.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.fzu != null && FrsCommonTabFragment.this.fzu.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    FrsCommonTabFragment.this.fCf.fU(true);
                    FrsCommonTabFragment.this.onListPullRefresh(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener fCm = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.fCf.vW(str);
                }
            }
        }
    };
    private CustomMessageListener fwa = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bkH = FrsCommonTabFragment.this.fCf.bkH();
                    if (bkH != null && bkH.cck() != null && (bkH.cck().getTag() instanceof z)) {
                        FrsCommonTabFragment.this.fuN = (z) bkH.cck().getTag();
                    }
                    if (FrsCommonTabFragment.this.fuN != null && FrsCommonTabFragment.this.fuN.lV() != null) {
                        FrsCommonTabFragment.this.fuN.lV().b(new a.C0044a(3));
                    }
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tabId = bundle.getInt("tab_id");
            this.forumId = bundle.getString("forum_id");
            this.fCj = bundle.getBoolean("can_auto_play_video");
            this.fCi = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.fCh = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.forumId = arguments.getString("forum_id");
                this.fCj = arguments.getBoolean("can_auto_play_video");
                this.fCi = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.fCh = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.fuw = getVoiceManager();
        this.fuw.onCreate(getPageContext());
        this.fCg = new c(this, com.baidu.adp.lib.g.b.toInt(this.forumId, 0), this.tabId);
        registerListener(this.fvB);
        registerListener(this.fCm);
        registerListener(this.fwa);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.fCf = new b(this, this.mRootView, this.fCh);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmy();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bo(this.tabId, 2);
    }

    private void bo(int i, int i2) {
        an anVar = new an("c13008");
        anVar.bS("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bS("fid", this.forumId);
        if (i == 89) {
            anVar.O("obj_type", 1);
        } else if (i == 501) {
            anVar.O("obj_type", 3);
        } else if (i == 502) {
            anVar.O("obj_type", 8);
        }
        anVar.O("obj_locate", i2);
        anVar.amI();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.fCf.km(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.fxx);
            if (this.fzu == null) {
                this.fzu = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.fzu.setTitle(null);
            this.fzu.setSubText(str);
            this.fzu.setButtonText(null);
            this.fzu.attachView(view, z);
            this.fzu.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.fCf.km(true);
        if (this.fzu != null) {
            this.fzu.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.fxx);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.fCf != null) {
                this.fCf.fU(false);
                this.fCf.a(dVar);
            }
            if (this.fCg.bmD() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_TAB_SHOW_RED_POINT, false));
            }
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
        if (!this.fCg.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.fCf != null) {
            this.fCf.fU(false);
        }
    }

    public void ac(bh bhVar) {
        if (bhVar != null) {
            this.fCg.ac(bhVar);
            this.fCf.bjw();
        }
    }

    public void aYW() {
        if (l.isNetOk()) {
            if (this.fuw != null) {
                this.fuw.stopPlay();
            }
            if (this.fCg != null) {
                this.fCg.aIU();
            }
        }
    }

    private void bmy() {
        if (l.isNetOk()) {
            if (this.fuw != null) {
                this.fuw.stopPlay();
            }
            if (this.fCg != null) {
                this.fCg.bmy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.fCg.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bmy();
            return;
        }
        this.fCf.fU(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.bau().iK(false);
        MessageManager.getInstance().unRegisterListener(this.fxx);
        super.onDestroy();
        if (this.fCf != null) {
            this.fCf.onDestroy();
        }
        if (this.fuw != null) {
            this.fuw.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fCf != null) {
                this.fCf.resume();
            }
            if (this.fCl) {
                this.fCl = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.alP().putBoolean("first_into_tab_profession", false);
                        bmz();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).ws(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503) {
                    onLazyLoad();
                }
            }
            bmB();
        } else if (this.fCf != null) {
            this.fCf.pause();
        }
        blS();
    }

    private void bmz() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hW(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        professionDialogLayout.setCloseViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.aM(professionDialogLayout);
        aVar.eg(false);
        aVar.eh(false);
        aVar.b(getPageContext()).akM();
    }

    private void blS() {
        if (isPrimary()) {
            if (this.fzu != null && this.fzu.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fxx);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fxx);
    }

    public void bmA() {
        if (this.fCf != null) {
            this.fCf.refreshView();
        }
    }

    private void bmB() {
        if (this.tabId == 502) {
            an anVar = new an("c13376");
            anVar.bS("fid", this.forumId);
            anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fuw != null) {
            this.fuw.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fCf != null) {
            this.fCf.pause();
        }
        if (this.fuw != null) {
            this.fuw.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fCk != 3 || this.fCf != null) {
            this.fCk = i;
            super.onChangeSkinType(i);
            this.fCf.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.fCj);
        bundle.putBoolean("need_log", this.fCi);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.fuw != null) {
            this.fuw.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fuw == null) {
            this.fuw = VoiceManager.instance();
        }
        return this.fuw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fuw != null) {
            this.fuw.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fuw != null) {
            this.fuw.onStop(getPageContext());
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
                        this.fCf.vW(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjw() {
        this.fCf.bjw();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKf() {
        this.fCf.aKf();
        this.fCf.fU(true);
    }

    public void qQ(int i) {
        if (this.fzu != null && this.fzu.isViewAttached()) {
            this.fzu.jY(i);
        }
    }
}
