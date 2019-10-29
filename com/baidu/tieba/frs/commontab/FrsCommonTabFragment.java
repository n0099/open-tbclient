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
    private com.baidu.tbadk.m.c fAl;
    protected b fCW;
    protected c fCX;
    public FrsViewData fCY;
    public boolean fCZ;
    public boolean fDa;
    public String forumId;
    private z fvE;
    private VoiceManager fvn;
    public boolean isBrandForum;
    protected View mRootView;
    public int tabId;
    private int fDb = 3;
    private boolean fDc = true;
    private CustomMessageListener fyo = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.qR(num.intValue());
            }
        }
    };
    private CustomMessageListener fws = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.fCW != null) {
                        FrsCommonTabFragment.this.fCW.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.fAl != null && FrsCommonTabFragment.this.fAl.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    FrsCommonTabFragment.this.fCW.fU(true);
                    FrsCommonTabFragment.this.onListPullRefresh(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };
    private final CustomMessageListener fDd = new CustomMessageListener(CmdConfigCustom.PB_DELETE_THREAD) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.fCW.vW(str);
                }
            }
        }
    };
    private CustomMessageListener fwR = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bkJ = FrsCommonTabFragment.this.fCW.bkJ();
                    if (bkJ != null && bkJ.ccm() != null && (bkJ.ccm().getTag() instanceof z)) {
                        FrsCommonTabFragment.this.fvE = (z) bkJ.ccm().getTag();
                    }
                    if (FrsCommonTabFragment.this.fvE != null && FrsCommonTabFragment.this.fvE.lV() != null) {
                        FrsCommonTabFragment.this.fvE.lV().b(new a.C0044a(3));
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
            this.fDa = bundle.getBoolean("can_auto_play_video");
            this.fCZ = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.fCY = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt("tab_id");
                this.forumId = arguments.getString("forum_id");
                this.fDa = arguments.getBoolean("can_auto_play_video");
                this.fCZ = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.fCY = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.fvn = getVoiceManager();
        this.fvn.onCreate(getPageContext());
        this.fCX = new c(this, com.baidu.adp.lib.g.b.toInt(this.forumId, 0), this.tabId);
        registerListener(this.fws);
        registerListener(this.fDd);
        registerListener(this.fwR);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.fCW = new b(this, this.mRootView, this.fCY);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.isNetWorkAvailable()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmA();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bq(this.tabId, 2);
    }

    private void bq(int i, int i2) {
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
        anVar.amK();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.fCW.km(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.fyo);
            if (this.fAl == null) {
                this.fAl = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.fAl.setTitle(null);
            this.fAl.setSubText(str);
            this.fAl.setButtonText(null);
            this.fAl.attachView(view, z);
            this.fAl.showRefreshButton();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.fCW.km(true);
        if (this.fAl != null) {
            this.fAl.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.fyo);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.fCW != null) {
                this.fCW.fU(false);
                this.fCW.a(dVar);
            }
            if (this.fCX.bmF() && this.tabId == 89) {
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
        if (!this.fCX.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.fCW != null) {
            this.fCW.fU(false);
        }
    }

    public void ac(bh bhVar) {
        if (bhVar != null) {
            this.fCX.ac(bhVar);
            this.fCW.bjy();
        }
    }

    public void aYY() {
        if (l.isNetOk()) {
            if (this.fvn != null) {
                this.fvn.stopPlay();
            }
            if (this.fCX != null) {
                this.fCX.aIW();
            }
        }
    }

    private void bmA() {
        if (l.isNetOk()) {
            if (this.fvn != null) {
                this.fvn.stopPlay();
            }
            if (this.fCX != null) {
                this.fCX.bmA();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            if (this.fCX.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bmA();
            return;
        }
        this.fCW.fU(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmA();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.baw().iK(false);
        MessageManager.getInstance().unRegisterListener(this.fyo);
        super.onDestroy();
        if (this.fCW != null) {
            this.fCW.onDestroy();
        }
        if (this.fvn != null) {
            this.fvn.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fCW != null) {
                this.fCW.resume();
            }
            if (this.fDc) {
                this.fDc = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.alR().putBoolean("first_into_tab_profession", false);
                        bmB();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).ws(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503) {
                    onLazyLoad();
                }
            }
            bmD();
        } else if (this.fCW != null) {
            this.fCW.pause();
        }
        blU();
    }

    private void bmB() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hX(1);
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
        aVar.b(getPageContext()).akO();
    }

    private void blU() {
        if (isPrimary()) {
            if (this.fAl != null && this.fAl.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fyo);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fyo);
    }

    public void bmC() {
        if (this.fCW != null) {
            this.fCW.refreshView();
        }
    }

    private void bmD() {
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
        if (this.fvn != null) {
            this.fvn.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fCW != null) {
            this.fCW.pause();
        }
        if (this.fvn != null) {
            this.fvn.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fDb != 3 || this.fCW != null) {
            this.fDb = i;
            super.onChangeSkinType(i);
            this.fCW.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("tab_id", this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.fDa);
        bundle.putBoolean("need_log", this.fCZ);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.fvn != null) {
            this.fvn.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fvn == null) {
            this.fvn = VoiceManager.instance();
        }
        return this.fvn;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fvn != null) {
            this.fvn.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fvn != null) {
            this.fvn.onStop(getPageContext());
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
                        this.fCW.vW(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjy() {
        this.fCW.bjy();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        this.fCW.aKh();
        this.fCW.fU(true);
    }

    public void qR(int i) {
        if (this.fAl != null && this.fAl.isViewAttached()) {
            this.fAl.jZ(i);
        }
    }
}
