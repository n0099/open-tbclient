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
    private VoiceManager dLz;
    private b dSi;
    private c dSj;
    public boolean dSk;
    public boolean dSl;
    public String forumId;
    public boolean isBrandForum;
    private View mRootView;
    public int tabId;
    private int dSm = 3;
    private CustomMessageListener dMu = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.dSi != null) {
                        FrsCommonTabFragment.this.dSi.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.mRefreshView == null || !FrsCommonTabFragment.this.mRefreshView.isViewAttached()) {
                        FrsCommonTabFragment.this.dSi.dl(true);
                        FrsCommonTabFragment.this.bI(true);
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
            this.dSl = bundle.getBoolean("can_auto_play_video");
            this.dSk = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.dSl = arguments.getBoolean("can_auto_play_video");
                this.dSk = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
            }
        }
        this.dLz = getVoiceManager();
        this.dLz.onCreate(getPageContext());
        this.dSj = new c(this, Integer.parseInt(this.forumId), this.tabId);
        setNetRefreshViewTextAndPicDistance(getResources().getDimensionPixelSize(e.C0210e.ds_102));
        registerListener(this.dMu);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(e.h.frs_common_tab_fragment, (ViewGroup) null);
        this.dSi = new b(this, this.mRootView);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (this.tabId == 89) {
            TiebaStatic.log(new am("c13008").aB(ImageViewerConfig.FORUM_ID, this.forumId).y("obj_type", 1));
        }
        if (com.baidu.adp.lib.util.j.kV()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0210e.ds250));
            aEv();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.dSi.he(false);
        super.showNetRefreshView(view, str, z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.dSi.he(true);
        super.hideNetRefreshView(view);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.dSi != null) {
                this.dSi.dl(false);
                this.dSi.a(dVar);
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
        if (!this.dSj.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(e.j.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.dSi != null) {
            this.dSi.dl(false);
        }
    }

    public void aEu() {
        if (l.ll()) {
            if (this.dLz != null) {
                this.dLz.stopPlay();
            }
            if (this.dSj != null) {
                this.dSj.aaA();
            }
        }
    }

    private void aEv() {
        if (l.ll()) {
            if (this.dLz != null) {
                this.dLz.stopPlay();
            }
            if (this.dSj != null) {
                this.dSj.aEv();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        if (com.baidu.adp.lib.util.j.kV()) {
            hideNetRefreshView(this.mRootView);
            if (this.dSj.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0210e.ds250));
            }
            aEv();
            return;
        }
        this.dSi.dl(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kV()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(e.C0210e.ds250));
            aEv();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        v.aqP().fy(false);
        super.onDestroy();
        if (this.dSi != null) {
            this.dSi.onDestroy();
        }
        if (this.dLz != null) {
            this.dLz.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.dSi != null) {
                this.dSi.resume();
            }
        } else if (this.dSi != null) {
            this.dSi.pause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.dSi != null) {
            this.dSi.resume();
        }
        if (this.dLz != null) {
            this.dLz.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.dSi != null) {
            this.dSi.pause();
        }
        if (this.dLz != null) {
            this.dLz.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dSm != 3 || this.dSi != null) {
            this.dSm = i;
            super.onChangeSkinType(i);
            this.dSi.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.dSl);
        bundle.putBoolean("need_log", this.dSk);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.dLz != null) {
            this.dLz.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.dLz == null) {
            this.dLz = VoiceManager.instance();
        }
        return this.dLz;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.dLz != null) {
            this.dLz.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.dLz != null) {
            this.dLz.onStop(getPageContext());
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
                        this.dSi.oE(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
