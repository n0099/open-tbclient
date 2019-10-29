package com.baidu.tieba.ala.charm;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.Message;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.g;
import com.baidu.live.utils.q;
import com.baidu.megapp.ma.Util;
/* loaded from: classes6.dex */
public class ALaCharmCardActivity extends BaseActivity<ALaCharmCardActivity> implements View.OnTouchListener {
    private com.baidu.tieba.ala.charm.view.c dFd;
    private int mScreenWidth;
    private Handler mHandler = new Handler();
    private ViewTreeObserver.OnGlobalLayoutListener YV = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(ALaCharmCardActivity.this.getPageContext().getPageActivity());
            if (screenDimensions[0] > screenDimensions[1] && screenDimensions[0] != ALaCharmCardActivity.this.mScreenWidth) {
                ALaCharmCardActivity.this.mScreenWidth = screenDimensions[0];
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    ALaCharmCardActivity.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            g.P(ALaCharmCardActivity.this.dFd.getView());
                        }
                    }, 300L);
                }
            }
        }
    };
    CustomMessageListener agm = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ALaCharmCardActivity.this.closeActivity();
        }
    };
    private CustomMessageListener dFe = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UpdateAttentionMessage updateAttentionMessage;
            if ((customResponsedMessage instanceof UpdateAttentionMessage) && (updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage) != null && updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                if (updateAttentionMessage.getData().isSucc) {
                    if (ALaCharmCardActivity.this.dFd != null) {
                        ALaCharmCardActivity.this.dFd.T(updateAttentionMessage.getData().toUid, updateAttentionMessage.getData().isAttention);
                    }
                    Message<?> message = updateAttentionMessage.getmOrginalMessage();
                    if (message != null && message.getTag() != null && message.getTag().equals(ALaCharmCardActivity.this.getUniqueId())) {
                        if (updateAttentionMessage.getData().isAttention) {
                            ALaCharmCardActivity.this.getPageContext().showToast(ALaCharmCardActivity.this.getResources().getString(a.i.sdk_attention_success_toast));
                            return;
                        } else {
                            ALaCharmCardActivity.this.getPageContext().showToast(ALaCharmCardActivity.this.getResources().getString(a.i.sdk_unfollow_success_toast));
                            return;
                        }
                    }
                    return;
                }
                if (ALaCharmCardActivity.this.dFd != null) {
                    ALaCharmCardActivity.this.dFd.T(updateAttentionMessage.getData().toUid, !updateAttentionMessage.getData().isAttention);
                }
                Message<?> message2 = updateAttentionMessage.getmOrginalMessage();
                if (message2 != null && message2.getTag() != null && message2.getTag().equals(ALaCharmCardActivity.this.getUniqueId())) {
                    ALaCharmCardActivity.this.getPageContext().showToast(updateAttentionMessage.getData().errorString);
                }
            }
        }
    };
    CustomMessageListener dFf = new CustomMessageListener(2913096) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Long)) {
                Long l = (Long) customResponsedMessage.getData();
                if (ALaCharmCardActivity.this.dFd != null) {
                    ALaCharmCardActivity.this.dFd.bV(l.longValue());
                }
            }
        }
    };
    private CustomMessageListener duL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.charm.ALaCharmCardActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ALaCharmCardActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        this.dFd = new com.baidu.tieba.ala.charm.view.c(this);
        setContentView(this.dFd.getView());
        registerListener(this.duL);
        registerListener(this.agm);
        registerListener(this.dFe);
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            g.P(this.dFd.getView());
            q.d(getActivity(), false);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dFd != null) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                g.P(this.dFd.getView());
                q.d(getActivity(), false);
            } else {
                g.Q(this.dFd.getView());
                q.d(getActivity(), true);
            }
            aIH();
            this.dFd.pC();
            aIG();
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        aIG();
    }

    private void aIG() {
        Window window = getWindow();
        if (window != null) {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
            View decorView = window.getDecorView();
            decorView.setOnTouchListener(this);
            if (!UtilHelper.canUseStyleImmersiveSticky() && screenDimensions[1] > screenDimensions[0]) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.height = screenDimensions[1] - BdUtilHelper.getStatusBarHeight(getPageContext().getPageActivity());
                attributes.gravity = 80;
                getWindowManager().updateViewLayout(decorView, attributes);
            }
            this.mScreenWidth = screenDimensions[0];
            window.setBackgroundDrawableResource(17170445);
            window.getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.YV);
            if (this.dFd.getView().getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.dFd.getView().getLayoutParams();
                if (screenDimensions[1] > screenDimensions[0]) {
                    layoutParams.width = screenDimensions[0];
                    layoutParams.height = (int) (screenDimensions[1] * 0.618d);
                    layoutParams.gravity = 80;
                } else {
                    layoutParams.width = screenDimensions[1];
                    layoutParams.height = screenDimensions[1];
                    layoutParams.gravity = 53;
                }
                this.dFd.getView().setLayoutParams(layoutParams);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0) {
            z = true;
            if (view.getId() != a.g.ala_charm_detail_id) {
                finish();
            }
        }
        return z;
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        aIH();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        aIH();
    }

    public void aIH() {
        int hostResourcesId;
        int hostResourcesId2;
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            if (this instanceof Activity) {
                hostResourcesId = a.C0068a.sdk_activity_open_translate_from_right;
                hostResourcesId2 = a.C0068a.sdk_activity_close_translate_to_right;
            } else {
                hostResourcesId = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", "anim");
                hostResourcesId2 = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", "anim");
            }
        } else if (this instanceof Activity) {
            hostResourcesId = a.C0068a.sdk_activity_open_translate_from_bottom;
            hostResourcesId2 = a.C0068a.sdk_activity_close_translate_from_top;
        } else {
            hostResourcesId = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", "anim");
            hostResourcesId2 = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", "anim");
        }
        overridePendingTransition(hostResourcesId, hostResourcesId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.dFd.onDestory();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.YV);
        this.YV = null;
    }

    public void aKu() {
        Intent intent = new Intent();
        intent.putExtra("need_show_gift_panel", true);
        setResult(-1, intent);
        finish();
    }
}
