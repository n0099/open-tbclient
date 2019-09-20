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
    private com.baidu.tbadk.m.c fAX;
    protected b fDF;
    protected c fDG;
    public FrsViewData fDH;
    public boolean fDI;
    public boolean fDJ;
    public String forumId;
    private VoiceManager fwa;
    private z fwr;
    public boolean isBrandForum;
    protected View mRootView;
    public int tabId;
    private int fDK = 3;
    private boolean fDL = true;
    private CustomMessageListener fzb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.rY(num.intValue());
            }
        }
    };
    private CustomMessageListener fxf = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.fDF != null) {
                        FrsCommonTabFragment.this.fDF.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.fAX != null && FrsCommonTabFragment.this.fAX.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    FrsCommonTabFragment.this.fDF.gf(true);
                    FrsCommonTabFragment.this.eu(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final CustomMessageListener fDM = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.fDF.xE(str);
                }
            }
        }
    };
    private CustomMessageListener fxD = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bnE = FrsCommonTabFragment.this.fDF.bnE();
                    if (bnE != null && bnE.cfk() != null && (bnE.cfk().getTag() instanceof z)) {
                        FrsCommonTabFragment.this.fwr = (z) bnE.cfk().getTag();
                    }
                    if (FrsCommonTabFragment.this.fwr != null && FrsCommonTabFragment.this.fwr.qQ() != null) {
                        FrsCommonTabFragment.this.fwr.qQ().b(new a.C0038a(3));
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
            this.fDJ = bundle.getBoolean("can_auto_play_video");
            this.fDI = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.fDH = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.fDJ = arguments.getBoolean("can_auto_play_video");
                this.fDI = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.fDH = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.fwa = getVoiceManager();
        this.fwa.onCreate(getPageContext());
        this.fDG = new c(this, com.baidu.adp.lib.g.b.f(this.forumId, 0), this.tabId);
        registerListener(this.fxf);
        registerListener(this.fDM);
        registerListener(this.fxD);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.fDF = new b(this, this.mRootView, this.fDH);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.kc()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bpv();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bu(this.tabId, 2);
    }

    private void bu(int i, int i2) {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.forumId);
        if (i == 89) {
            anVar.P("obj_type", 1);
        } else if (i == 501) {
            anVar.P("obj_type", 3);
        } else if (i == 502) {
            anVar.P("obj_type", 8);
        }
        anVar.P("obj_locate", i2);
        anVar.ajq();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.fDF.kz(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.fzb);
            if (this.fAX == null) {
                this.fAX = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.fAX.setTitle(null);
            this.fAX.qY(str);
            this.fAX.setButtonText(null);
            this.fAX.attachView(view, z);
            this.fAX.atW();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.fDF.kz(true);
        if (this.fAX != null) {
            this.fAX.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.fzb);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.fDF != null) {
                this.fDF.gf(false);
                this.fDF.a(dVar);
            }
            if (this.fDG.bpA() && this.tabId == 89) {
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
        if (!this.fDG.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.fDF != null) {
            this.fDF.gf(false);
        }
    }

    public void ae(bh bhVar) {
        if (bhVar != null) {
            this.fDG.ae(bhVar);
            this.fDF.bms();
        }
    }

    public void aYU() {
        if (l.kt()) {
            if (this.fwa != null) {
                this.fwa.stopPlay();
            }
            if (this.fDG != null) {
                this.fDG.aJw();
            }
        }
    }

    private void bpv() {
        if (l.kt()) {
            if (this.fwa != null) {
                this.fwa.stopPlay();
            }
            if (this.fDG != null) {
                this.fDG.bpv();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void eu(boolean z) {
        if (j.kc()) {
            hideNetRefreshView(this.mRootView);
            if (this.fDG.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            bpv();
            return;
        }
        this.fDF.gf(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            bpv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.bat().iH(false);
        MessageManager.getInstance().unRegisterListener(this.fzb);
        super.onDestroy();
        if (this.fDF != null) {
            this.fDF.onDestroy();
        }
        if (this.fwa != null) {
            this.fwa.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fDF != null) {
                this.fDF.resume();
            }
            if (this.fDL) {
                this.fDL = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.ahU().putBoolean("first_into_tab_profession", false);
                        bpw();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).ya(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503) {
                    onLazyLoad();
                }
            }
            bpy();
        } else if (this.fDF != null) {
            this.fDF.pause();
        }
        boQ();
    }

    private void bpw() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hy(1);
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
        aVar.aH(professionDialogLayout);
        aVar.dQ(false);
        aVar.dR(false);
        aVar.b(getPageContext()).agO();
    }

    private void boQ() {
        if (isPrimary()) {
            if (this.fAX != null && this.fAX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fzb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fzb);
    }

    public void bpx() {
        if (this.fDF != null) {
            this.fDF.refreshView();
        }
    }

    private void bpy() {
        if (this.tabId == 502) {
            an anVar = new an("c13376");
            anVar.bT("fid", this.forumId);
            anVar.n("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.fwa != null) {
            this.fwa.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fDF != null) {
            this.fDF.pause();
        }
        if (this.fwa != null) {
            this.fwa.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fDK != 3 || this.fDF != null) {
            this.fDK = i;
            super.onChangeSkinType(i);
            this.fDF.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.fDJ);
        bundle.putBoolean("need_log", this.fDI);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.fwa != null) {
            this.fwa.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fwa == null) {
            this.fwa = VoiceManager.instance();
        }
        return this.fwa;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.fwa != null) {
            this.fwa.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.fwa != null) {
            this.fwa.onStop(getPageContext());
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
                        this.fDF.xE(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bms() {
        this.fDF.bms();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKN() {
        this.fDF.aKN();
        this.fDF.gf(true);
    }

    public void rY(int i) {
        if (this.fAX != null && this.fAX.isViewAttached()) {
            this.fAX.kL(i);
        }
    }
}
