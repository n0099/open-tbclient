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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.card.v;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class FrsCommonTabFragment extends BaseFragment implements j.b, VoiceManager.c {
    private VoiceManager dBD;
    private b dIm;
    private c dIn;
    public boolean dIo;
    public boolean dIp;
    public String forumId;
    public boolean isBrandForum;
    private View mRootView;
    public int tabId;
    private int dIq = 3;
    private CustomMessageListener dCy = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.dIm != null) {
                        FrsCommonTabFragment.this.dIm.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.mRefreshView == null || !FrsCommonTabFragment.this.mRefreshView.isViewAttached()) {
                        FrsCommonTabFragment.this.dIm.dh(true);
                        FrsCommonTabFragment.this.bG(true);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                        return;
                    }
                    FrsCommonTabFragment.this.onNetRefreshButtonClicked();
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
            this.dIp = bundle.getBoolean("can_auto_play_video");
            this.dIo = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.dIp = arguments.getBoolean("can_auto_play_video");
                this.dIo = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
            }
        }
        this.dBD = getVoiceManager();
        this.dBD.onCreate(getPageContext());
        this.dIn = new c(this, Integer.parseInt(this.forumId), this.tabId);
        setNetRefreshViewTextAndPicDistance(getResources().getDimensionPixelSize(e.C0200e.ds_102));
        registerListener(this.dCy);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(e.h.frs_common_tab_fragment, (ViewGroup) null);
        this.dIm = new b(this, this.mRootView);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.tabId == 89) {
            TiebaStatic.log(new am("c13008").ax(ImageViewerConfig.FORUM_ID, this.forumId).x("obj_type", 1));
        }
        if (com.baidu.adp.lib.util.j.kV()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0200e.ds250));
            aBz();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.dIm.gX(false);
        super.showNetRefreshView(view, str, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.dIm.gX(true);
        super.hideNetRefreshView(view);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.dIm != null) {
                this.dIm.dh(false);
                this.dIm.a(dVar);
            }
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(e.j.im_error_default);
            }
        }
        if (!this.dIn.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.dIm != null) {
            this.dIm.dh(false);
        }
    }

    public void aBy() {
        if (l.lm()) {
            if (this.dBD != null) {
                this.dBD.stopPlay();
            }
            if (this.dIn != null) {
                this.dIn.YV();
            }
        }
    }

    private void aBz() {
        if (l.lm()) {
            if (this.dBD != null) {
                this.dBD.stopPlay();
            }
            if (this.dIn != null) {
                this.dIn.aBz();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        if (com.baidu.adp.lib.util.j.kV()) {
            hideNetRefreshView(this.mRootView);
            if (this.dIn.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0200e.ds250));
            }
            aBz();
            return;
        }
        this.dIm.dh(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0200e.ds250));
            aBz();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        v.anQ().fs(false);
        super.onDestroy();
        if (this.dIm != null) {
            this.dIm.onDestroy();
        }
        if (this.dBD != null) {
            this.dBD.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.dIm != null) {
                this.dIm.resume();
            }
        } else if (this.dIm != null) {
            this.dIm.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dIm != null) {
            this.dIm.resume();
        }
        if (this.dBD != null) {
            this.dBD.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dIm != null) {
            this.dIm.pause();
        }
        if (this.dBD != null) {
            this.dBD.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dIq != 3 || this.dIm != null) {
            this.dIq = i;
            super.onChangeSkinType(i);
            this.dIm.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.dIp);
        bundle.putBoolean("need_log", this.dIo);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.dBD != null) {
            this.dBD.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dBD == null) {
            this.dBD = VoiceManager.instance();
        }
        return this.dBD;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dBD != null) {
            this.dBD.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dBD != null) {
            this.dBD.onStop(getPageContext());
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
                        this.dIm.nK(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
