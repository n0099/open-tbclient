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
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    private VoiceManager foP;
    public String forumId;
    private z fpg;
    private com.baidu.tbadk.m.c ftP;
    protected b fwi;
    protected c fwj;
    public FrsViewData fwk;
    public boolean fwl;
    public boolean fwm;
    public boolean isBrandForum;
    protected View mRootView;
    public int tabId;
    private int fwn = 3;
    private boolean fwo = true;
    private CustomMessageListener frS = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.rB(num.intValue());
            }
        }
    };
    private CustomMessageListener fpV = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.fwi != null) {
                        FrsCommonTabFragment.this.fwi.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.ftP != null && FrsCommonTabFragment.this.ftP.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    FrsCommonTabFragment.this.fwi.fY(true);
                    FrsCommonTabFragment.this.en(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final CustomMessageListener fwp = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.fwi.wz(str);
                }
            }
        }
    };
    private CustomMessageListener fqt = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bkH = FrsCommonTabFragment.this.fwi.bkH();
                    if (bkH != null && bkH.cbo() != null && (bkH.cbo().getTag() instanceof z)) {
                        FrsCommonTabFragment.this.fpg = (z) bkH.cbo().getTag();
                    }
                    if (FrsCommonTabFragment.this.fpg != null && FrsCommonTabFragment.this.fpg.qs() != null) {
                        FrsCommonTabFragment.this.fpg.qs().b(new a.C0038a(3));
                    }
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tabId = bundle.getInt(MyBookrackActivityConfig.TAB_ID);
            this.forumId = bundle.getString("forum_id");
            this.fwm = bundle.getBoolean("can_auto_play_video");
            this.fwl = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.fwk = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.fwm = arguments.getBoolean("can_auto_play_video");
                this.fwl = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.fwk = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.foP = getVoiceManager();
        this.foP.onCreate(getPageContext());
        this.fwj = new c(this, com.baidu.adp.lib.g.b.f(this.forumId, 0), this.tabId);
        registerListener(this.fpV);
        registerListener(this.fwp);
        registerListener(this.fqt);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.fwi = new b(this, this.mRootView, this.fwk);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jS()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmw();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bp(this.tabId, 2);
    }

    private void bp(int i, int i2) {
        am amVar = new am("c13008");
        amVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.bT("fid", this.forumId);
        if (i == 89) {
            amVar.P("obj_type", 1);
        } else if (i == 501) {
            amVar.P("obj_type", 3);
        } else if (i == 502) {
            amVar.P("obj_type", 8);
        }
        amVar.P("obj_locate", i2);
        amVar.aif();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.fwi.km(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.frS);
            if (this.ftP == null) {
                this.ftP = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.ftP.setTitle(null);
            this.ftP.qw(str);
            this.ftP.setButtonText(null);
            this.ftP.attachView(view, z);
            this.ftP.asB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.fwi.km(true);
        if (this.ftP != null) {
            this.ftP.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.frS);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.fwi != null) {
                this.fwi.fY(false);
                this.fwi.a(dVar);
            }
            if (this.fwj.bmB() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, false));
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
        if (!this.fwj.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.fwi != null) {
            this.fwi.fY(false);
        }
    }

    public void ac(bg bgVar) {
        if (bgVar != null) {
            this.fwj.ac(bgVar);
            this.fwi.bjy();
        }
    }

    public void aWs() {
        if (l.ki()) {
            if (this.foP != null) {
                this.foP.stopPlay();
            }
            if (this.fwj != null) {
                this.fwj.aHt();
            }
        }
    }

    private void bmw() {
        if (l.ki()) {
            if (this.foP != null) {
                this.foP.stopPlay();
            }
            if (this.fwj != null) {
                this.fwj.bmw();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (j.jS()) {
            hideNetRefreshView(this.mRootView);
            if (this.fwj.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bmw();
            return;
        }
        this.fwi.fY(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jS()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmw();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.aXP().iv(false);
        MessageManager.getInstance().unRegisterListener(this.frS);
        super.onDestroy();
        if (this.fwi != null) {
            this.fwi.onDestroy();
        }
        if (this.foP != null) {
            this.foP.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fwi != null) {
                this.fwi.resume();
            }
            if (this.fwo) {
                this.fwo = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("first_into_tab_profession", false);
                        bmx();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).wV(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503) {
                    onLazyLoad();
                }
            }
            bmz();
        } else if (this.fwi != null) {
            this.fwi.pause();
        }
        blU();
    }

    private void bmx() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hr(1);
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
        aVar.aF(professionDialogLayout);
        aVar.dM(false);
        aVar.dN(false);
        aVar.b(getPageContext()).afG();
    }

    private void blU() {
        if (isPrimary()) {
            if (this.ftP != null && this.ftP.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.frS);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.frS);
    }

    public void bmy() {
        if (this.fwi != null) {
            this.fwi.refreshView();
        }
    }

    private void bmz() {
        if (this.tabId == 502) {
            am amVar = new am("c13376");
            amVar.bT("fid", this.forumId);
            amVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.foP != null) {
            this.foP.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fwi != null) {
            this.fwi.pause();
        }
        if (this.foP != null) {
            this.foP.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fwn != 3 || this.fwi != null) {
            this.fwn = i;
            super.onChangeSkinType(i);
            this.fwi.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.fwm);
        bundle.putBoolean("need_log", this.fwl);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.foP != null) {
            this.foP.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foP == null) {
            this.foP = VoiceManager.instance();
        }
        return this.foP;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.foP != null) {
            this.foP.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.foP != null) {
            this.foP.onStop(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    String stringExtra = intent.getStringExtra("tid");
                    int intExtra = intent.getIntExtra("type", -1);
                    if (!StringUtils.isNull(stringExtra) && intExtra == 0) {
                        this.fwi.wz(stringExtra);
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
        this.fwi.bjy();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aIG() {
        this.fwi.aIG();
        this.fwi.fY(true);
    }

    public void rB(int i) {
        if (this.ftP != null && this.ftP.isViewAttached()) {
            this.ftP.kB(i);
        }
    }
}
