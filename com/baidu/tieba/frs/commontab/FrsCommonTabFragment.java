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
    private VoiceManager eYE;
    private com.baidu.tbadk.m.c fdA;
    private b ffU;
    private c ffV;
    public FrsViewData ffW;
    public boolean ffX;
    public boolean ffY;
    public String forumId;
    public boolean isBrandForum;
    private View mRootView;
    public int tabId;
    private int ffZ = 3;
    private boolean fga = true;
    private CustomMessageListener fbC = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsCommonTabFragment.this.fdA != null && FrsCommonTabFragment.this.fdA.isViewAttached()) {
                FrsCommonTabFragment.this.fdA.jN(num.intValue());
            }
        }
    };
    private CustomMessageListener eZH = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.ffU != null) {
                        FrsCommonTabFragment.this.ffU.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.fdA == null || !FrsCommonTabFragment.this.fdA.isViewAttached()) {
                        FrsCommonTabFragment.this.ffU.fB(true);
                        FrsCommonTabFragment.this.dR(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        return;
                    }
                    FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                }
            }
        }
    };
    private final CustomMessageListener fgb = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.ffU.vg(str);
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
            this.ffY = bundle.getBoolean("can_auto_play_video");
            this.ffX = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.ffW = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.ffY = arguments.getBoolean("can_auto_play_video");
                this.ffX = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.ffW = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.eYE = getVoiceManager();
        this.eYE.onCreate(getPageContext());
        this.ffV = new c(this, Integer.parseInt(this.forumId), this.tabId);
        registerListener(this.eZH);
        registerListener(this.fgb);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(d.h.frs_common_tab_fragment, (ViewGroup) null);
        this.ffU = new b(this, this.mRootView, this.ffW);
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
            bfc();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.ffU.jB(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.fbC);
            if (this.fdA == null) {
                this.fdA = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.fdA.setTitle(null);
            this.fdA.pp(str);
            this.fdA.setButtonText(null);
            this.fdA.attachView(view, z);
            this.fdA.any();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.ffU.jB(true);
        if (this.fdA != null) {
            this.fdA.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.ffU != null) {
                this.ffU.fB(false);
                this.ffU.a(dVar);
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
        if (!this.ffV.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(d.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.ffU != null) {
            this.ffU.fB(false);
        }
    }

    public void ac(bg bgVar) {
        if (bgVar != null) {
            this.ffV.ac(bgVar);
            this.ffU.bcb();
        }
    }

    public void bfb() {
        if (l.lo()) {
            if (this.eYE != null) {
                this.eYE.stopPlay();
            }
            if (this.ffV != null) {
                this.ffV.aAZ();
            }
        }
    }

    private void bfc() {
        if (l.lo()) {
            if (this.eYE != null) {
                this.eYE.stopPlay();
            }
            if (this.ffV != null) {
                this.ffV.bfc();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        if (j.kY()) {
            hideNetRefreshView(this.mRootView);
            if (this.ffV.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(d.e.ds250));
            }
            bfc();
            return;
        }
        this.ffU.fB(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kY()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(d.e.ds250));
            bfc();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.aQD().hQ(false);
        MessageManager.getInstance().unRegisterListener(this.fbC);
        super.onDestroy();
        if (this.ffU != null) {
            this.ffU.onDestroy();
        }
        if (this.eYE != null) {
            this.eYE.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.ffU != null) {
                this.ffU.resume();
            }
            if (this.fga) {
                this.fga = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("first_into_tab_profession", false);
                        bfd();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).vA(this.forumId);
                    onLazyLoad();
                }
            }
            bff();
        } else if (this.ffU != null) {
            this.ffU.pause();
        }
        bez();
    }

    private void bfd() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.gE(1);
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
        aVar.b(getPageContext()).aaW();
    }

    private void bez() {
        if (isPrimary()) {
            if (this.fdA != null && this.fdA.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fbC);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fbC);
    }

    public void bfe() {
        if (this.ffU != null) {
            this.ffU.refreshView();
        }
    }

    private void bff() {
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
        if (this.eYE != null) {
            this.eYE.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.ffU != null) {
            this.ffU.pause();
        }
        if (this.eYE != null) {
            this.eYE.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.ffZ != 3 || this.ffU != null) {
            this.ffZ = i;
            super.onChangeSkinType(i);
            this.ffU.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.ffY);
        bundle.putBoolean("need_log", this.ffX);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.eYE != null) {
            this.eYE.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.eYE == null) {
            this.eYE = VoiceManager.instance();
        }
        return this.eYE;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.eYE != null) {
            this.eYE.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.eYE != null) {
            this.eYE.onStop(getPageContext());
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
                        this.ffU.vg(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bcb() {
        this.ffU.bcb();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aCq() {
        this.ffU.aCq();
        this.ffU.fB(true);
    }
}
