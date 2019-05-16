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
    private VoiceManager foO;
    public String forumId;
    private z fpf;
    private com.baidu.tbadk.m.c ftO;
    protected b fwh;
    protected c fwi;
    public FrsViewData fwj;
    public boolean fwk;
    public boolean fwl;
    public boolean isBrandForum;
    protected View mRootView;
    public int tabId;
    private int fwm = 3;
    private boolean fwn = true;
    private CustomMessageListener frR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.rB(num.intValue());
            }
        }
    };
    private CustomMessageListener fpU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.fwh != null) {
                        FrsCommonTabFragment.this.fwh.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.ftO != null && FrsCommonTabFragment.this.ftO.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    FrsCommonTabFragment.this.fwh.fY(true);
                    FrsCommonTabFragment.this.en(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final CustomMessageListener fwo = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.fwh.wA(str);
                }
            }
        }
    };
    private CustomMessageListener fqs = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bkE = FrsCommonTabFragment.this.fwh.bkE();
                    if (bkE != null && bkE.cbk() != null && (bkE.cbk().getTag() instanceof z)) {
                        FrsCommonTabFragment.this.fpf = (z) bkE.cbk().getTag();
                    }
                    if (FrsCommonTabFragment.this.fpf != null && FrsCommonTabFragment.this.fpf.qs() != null) {
                        FrsCommonTabFragment.this.fpf.qs().b(new a.C0038a(3));
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
            this.fwl = bundle.getBoolean("can_auto_play_video");
            this.fwk = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.fwj = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.fwl = arguments.getBoolean("can_auto_play_video");
                this.fwk = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.fwj = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.foO = getVoiceManager();
        this.foO.onCreate(getPageContext());
        this.fwi = new c(this, com.baidu.adp.lib.g.b.f(this.forumId, 0), this.tabId);
        registerListener(this.fpU);
        registerListener(this.fwo);
        registerListener(this.fqs);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.fwh = new b(this, this.mRootView, this.fwj);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.jS()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmt();
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
        this.fwh.km(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.frR);
            if (this.ftO == null) {
                this.ftO = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.ftO.setTitle(null);
            this.ftO.qx(str);
            this.ftO.setButtonText(null);
            this.ftO.attachView(view, z);
            this.ftO.asB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.fwh.km(true);
        if (this.ftO != null) {
            this.ftO.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.frR);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.fwh != null) {
                this.fwh.fY(false);
                this.fwh.a(dVar);
            }
            if (this.fwi.bmy() && this.tabId == 89) {
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
        if (!this.fwi.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.fwh != null) {
            this.fwh.fY(false);
        }
    }

    public void ac(bg bgVar) {
        if (bgVar != null) {
            this.fwi.ac(bgVar);
            this.fwh.bjv();
        }
    }

    public void aWp() {
        if (l.ki()) {
            if (this.foO != null) {
                this.foO.stopPlay();
            }
            if (this.fwi != null) {
                this.fwi.aHq();
            }
        }
    }

    private void bmt() {
        if (l.ki()) {
            if (this.foO != null) {
                this.foO.stopPlay();
            }
            if (this.fwi != null) {
                this.fwi.bmt();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        if (j.jS()) {
            hideNetRefreshView(this.mRootView);
            if (this.fwi.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bmt();
            return;
        }
        this.fwh.fY(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.jS()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bmt();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.aXM().iv(false);
        MessageManager.getInstance().unRegisterListener(this.frR);
        super.onDestroy();
        if (this.fwh != null) {
            this.fwh.onDestroy();
        }
        if (this.foO != null) {
            this.foO.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fwh != null) {
                this.fwh.resume();
            }
            if (this.fwn) {
                this.fwn = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.agM().putBoolean("first_into_tab_profession", false);
                        bmu();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).wT(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503) {
                    onLazyLoad();
                }
            }
            bmw();
        } else if (this.fwh != null) {
            this.fwh.pause();
        }
        blR();
    }

    private void bmu() {
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

    private void blR() {
        if (isPrimary()) {
            if (this.ftO != null && this.ftO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.frR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.frR);
    }

    public void bmv() {
        if (this.fwh != null) {
            this.fwh.refreshView();
        }
    }

    private void bmw() {
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
        if (this.foO != null) {
            this.foO.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fwh != null) {
            this.fwh.pause();
        }
        if (this.foO != null) {
            this.foO.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fwm != 3 || this.fwh != null) {
            this.fwm = i;
            super.onChangeSkinType(i);
            this.fwh.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.fwl);
        bundle.putBoolean("need_log", this.fwk);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.foO != null) {
            this.foO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.foO == null) {
            this.foO = VoiceManager.instance();
        }
        return this.foO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.foO != null) {
            this.foO.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.foO != null) {
            this.foO.onStop(getPageContext());
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
                        this.fwh.wA(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bjv() {
        this.fwh.bjv();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aID() {
        this.fwh.aID();
        this.fwh.fY(true);
    }

    public void rB(int i) {
        if (this.ftO != null && this.ftO.isViewAttached()) {
            this.ftO.kB(i);
        }
    }
}
