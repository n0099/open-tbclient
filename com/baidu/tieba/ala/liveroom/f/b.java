package com.baidu.tieba.ala.liveroom.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.YuyinAlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private TextView clp;
    private HeadImageView gsQ;
    private AlaLastLiveroomInfo gsR;
    private int gsS;
    private int gsT;
    private TbPageContext mContext;
    private ValueAnimator mValueAnimator;
    private View mView;
    private boolean gsW = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.startAnim();
                    return;
                case 2:
                    b.this.gsW = true;
                    b.this.hide();
                    return;
                default:
                    return;
            }
        }
    };
    private int gsU = com.baidu.live.x.a.NN().bhy.aIK;
    private int gsV = com.baidu.live.x.a.NN().bhy.aIL;

    public b(@NonNull TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.gsS = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gsT = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds94);
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_back_to_last_live_button, (ViewGroup) null);
        this.gsQ = (HeadImageView) this.mView.findViewById(a.g.back_to_last_live_portrait);
        this.gsQ.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gsQ.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gsQ.setIsRound(true);
        this.gsQ.setAutoChangeStyle(false);
        this.gsQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.clp = (TextView) this.mView.findViewById(a.g.back_to_last_live_content);
    }

    public void show() {
        if (this.mView != null && this.mView.getParent() != null && !this.gsW) {
            this.mView.setVisibility(0);
        }
    }

    public void hide() {
        if (this.mView != null && this.mView.getParent() != null) {
            this.mView.setVisibility(8);
        }
    }

    public void d(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (alaLastLiveroomInfo != null) {
            bQr();
            this.gsQ.startLoad(alaLastLiveroomInfo.getLastAnchorPortrait(), 10, false);
            this.gsR = alaLastLiveroomInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim() {
        int i;
        int width = this.clp.getWidth();
        int width2 = this.mView.getWidth();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsQ.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.addRule(11);
            layoutParams.removeRule(1);
            i = 500;
        } else {
            layoutParams.addRule(1, a.g.back_to_last_live_icon);
            i = 0;
        }
        this.gsQ.setLayoutParams(layoutParams);
        if (this.mValueAnimator != null && this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        this.mValueAnimator = ValueAnimator.ofInt(width2, (width2 - width) - this.gsS).setDuration(i);
        this.mValueAnimator.setInterpolator(new AccelerateInterpolator());
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.liveroom.f.b.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.this.mView.getLayoutParams().width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                b.this.mView.requestLayout();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.liveroom.f.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                b.this.mView.getLayoutParams().width = b.this.gsT;
                b.this.mView.requestLayout();
                Message message = new Message();
                message.what = 2;
                b.this.mHandler.sendMessageDelayed(message, b.this.gsV);
            }
        });
        this.mValueAnimator.start();
    }

    private void bQr() {
        if (this.gsQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gsQ.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
            }
            layoutParams.addRule(1, a.g.back_to_last_live_content);
            this.gsQ.setLayoutParams(layoutParams);
        }
    }

    public void bQs() {
        if (this.gsR != null && this.gsR.getLastLiveId() > 0 && this.mContext != null) {
            if (this.gsR.getIsAudio() == 1) {
                YuyinAlaLiveRoomActivityConfig yuyinAlaLiveRoomActivityConfig = new YuyinAlaLiveRoomActivityConfig(this.mContext.getPageActivity());
                yuyinAlaLiveRoomActivityConfig.addExtraByLiveId(this.gsR.getLastLiveId(), "", "live_sdk");
                JSONObject jSONObject = new JSONObject();
                try {
                    if (!TextUtils.isEmpty(this.gsR.getLastCover())) {
                        jSONObject.put("cover", this.gsR.getLastCover());
                    }
                    if (!TextUtils.isEmpty(this.gsR.getLastVideoUrl())) {
                        jSONObject.put("live_url", this.gsR.getLastVideoUrl());
                    }
                    jSONObject.put("enterLiveId", this.gsR.getLastLiveId());
                    yuyinAlaLiveRoomActivityConfig.addExtraByParams(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2501018, yuyinAlaLiveRoomActivityConfig));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501059, "close_video_activity"));
                return;
            }
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(this.gsR.getLastLiveId(), "", "live_sdk");
            JSONObject jSONObject2 = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gsR.getLastCover())) {
                    jSONObject2.put("cover", this.gsR.getLastCover());
                }
                if (!TextUtils.isEmpty(this.gsR.getLastVideoUrl())) {
                    jSONObject2.put("live_url", this.gsR.getLastVideoUrl());
                }
                jSONObject2.put("enterLiveId", this.gsR.getLastLiveId());
                alaLiveRoomActivityConfig.addExtraByParams(jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
        }
    }

    public View getView() {
        return this.mView;
    }

    public void onDestroy() {
        release();
    }

    private RelativeLayout.LayoutParams bQt() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds204);
        return layoutParams;
    }

    public void av(ViewGroup viewGroup) {
        if (this.mView != null && viewGroup != null && this.mView.getParent() == null) {
            viewGroup.addView(this.mView, bQt());
            if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
                hide();
            } else {
                show();
            }
            this.mHandler.removeCallbacksAndMessages(null);
            Message message = new Message();
            message.what = 1;
            this.mHandler.sendMessageDelayed(message, this.gsU);
        }
    }

    public void bQu() {
        release();
    }

    private void release() {
        this.gsW = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
            this.mValueAnimator = null;
        }
        if (this.mView != null && this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
    }

    public void bQv() {
        if (this.mValueAnimator != null && this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
    }
}
