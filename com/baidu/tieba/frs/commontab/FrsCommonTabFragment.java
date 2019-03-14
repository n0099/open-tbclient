package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.card.t;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class FrsCommonTabFragment extends BaseFragment implements h.c, VoiceManager.c, ag {
    private VoiceManager eYR;
    private com.baidu.tbadk.m.c fdN;
    private b fgh;
    private c fgi;
    public FrsViewData fgj;
    public boolean fgk;
    public boolean fgl;
    public String forumId;
    public boolean isBrandForum;
    private View mRootView;
    public int tabId;
    private int fgm = 3;
    private boolean fgn = true;
    private CustomMessageListener fbP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsCommonTabFragment.this.fdN != null && FrsCommonTabFragment.this.fdN.isViewAttached()) {
                FrsCommonTabFragment.this.fdN.jO(num.intValue());
            }
        }
    };
    private CustomMessageListener eZU = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.fgh != null) {
                        FrsCommonTabFragment.this.fgh.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.fdN == null || !FrsCommonTabFragment.this.fdN.isViewAttached()) {
                        FrsCommonTabFragment.this.fgh.fB(true);
                        FrsCommonTabFragment.this.dR(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        return;
                    }
                    FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                }
            }
        }
    };
    private final CustomMessageListener fgo = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.fgh.vh(str);
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
            this.fgl = bundle.getBoolean("can_auto_play_video");
            this.fgk = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.fgj = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.fgl = arguments.getBoolean("can_auto_play_video");
                this.fgk = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.fgj = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.eYR = getVoiceManager();
        this.eYR.onCreate(getPageContext());
        this.fgi = new c(this, Integer.parseInt(this.forumId), this.tabId);
        registerListener(this.eZU);
        registerListener(this.fgo);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(d.h.frs_common_tab_fragment, (ViewGroup) null);
        this.fgh = new b(this, this.mRootView, this.fgj);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.tabId == 89) {
            TiebaStatic.log(new am("c13008").bJ(ImageViewerConfig.FORUM_ID, this.forumId).T("obj_type", 1));
        }
        if (j.kY()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(d.e.ds250));
            bfe();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.fgh.jB(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.fbP);
            if (this.fdN == null) {
                this.fdN = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.fdN.setTitle(null);
            this.fdN.po(str);
            this.fdN.setButtonText(null);
            this.fdN.attachView(view, z);
            this.fdN.anB();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.fgh.jB(true);
        if (this.fdN != null) {
            this.fdN.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.fbP);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.fgh != null) {
                this.fgh.fB(false);
                this.fgh.a(dVar);
            }
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(d.j.im_error_default);
            }
        }
        if (!this.fgi.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.fgh != null) {
            this.fgh.fB(false);
        }
    }

    public void ad(bg bgVar) {
        if (bgVar != null) {
            this.fgi.ad(bgVar);
            this.fgh.bcd();
        }
    }

    public void bfd() {
        if (l.lo()) {
            if (this.eYR != null) {
                this.eYR.stopPlay();
            }
            if (this.fgi != null) {
                this.fgi.aBc();
            }
        }
    }

    private void bfe() {
        if (l.lo()) {
            if (this.eYR != null) {
                this.eYR.stopPlay();
            }
            if (this.fgi != null) {
                this.fgi.bfe();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (j.kY()) {
            hideNetRefreshView(this.mRootView);
            if (this.fgi.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(d.e.ds250));
            }
            bfe();
            return;
        }
        this.fgh.fB(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(d.e.ds250));
            bfe();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.aQF().hQ(false);
        MessageManager.getInstance().unRegisterListener(this.fbP);
        super.onDestroy();
        if (this.fgh != null) {
            this.fgh.onDestroy();
        }
        if (this.eYR != null) {
            this.eYR.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fgh != null) {
                this.fgh.resume();
            }
            if (this.fgn) {
                this.fgn = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("first_into_tab_profession", false);
                        bff();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).vB(this.forumId);
                    onLazyLoad();
                }
            }
            bfh();
        } else if (this.fgh != null) {
            this.fgh.pause();
        }
        beB();
    }

    private void bff() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.gF(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        professionDialogLayout.setCloseViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.az(professionDialogLayout);
        aVar.dq(false);
        aVar.dr(false);
        aVar.b(getPageContext()).aaZ();
    }

    private void beB() {
        if (isPrimary()) {
            if (this.fdN != null && this.fdN.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbP);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbP);
    }

    public void bfg() {
        if (this.fgh != null) {
            this.fgh.refreshView();
        }
    }

    private void bfh() {
        if (this.tabId == 502) {
            am amVar = new am("c13376");
            amVar.bJ(ImageViewerConfig.FORUM_ID, this.forumId);
            amVar.k("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(amVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.eYR != null) {
            this.eYR.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fgh != null) {
            this.fgh.pause();
        }
        if (this.eYR != null) {
            this.eYR.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fgm != 3 || this.fgh != null) {
            this.fgm = i;
            super.onChangeSkinType(i);
            this.fgh.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.fgl);
        bundle.putBoolean("need_log", this.fgk);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.eYR != null) {
            this.eYR.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYR == null) {
            this.eYR = VoiceManager.instance();
        }
        return this.eYR;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYR != null) {
            this.eYR.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.eYR != null) {
            this.eYR.onStop(getPageContext());
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
                        this.fgh.vh(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcd() {
        this.fgh.bcd();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCt() {
        this.fgh.aCt();
        this.fgh.fB(true);
    }
}
