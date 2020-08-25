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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    private TextView cjk;
    private int gpA;
    private int gpB;
    private HeadImageView gpy;
    private AlaLastLiveroomInfo gpz;
    private TbPageContext mContext;
    private ValueAnimator mValueAnimator;
    private View mView;
    private boolean gpE = false;
    private final Handler mHandler = new Handler() { // from class: com.baidu.tieba.ala.liveroom.f.b.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    b.this.startAnim();
                    return;
                case 2:
                    b.this.gpE = true;
                    b.this.hide();
                    return;
                default:
                    return;
            }
        }
    };
    private int gpC = com.baidu.live.w.a.Nk().beH.aHr;
    private int gpD = com.baidu.live.w.a.Nk().beH.aHs;

    public b(@NonNull TbPageContext tbPageContext) {
        this.mContext = tbPageContext;
        this.gpA = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
        this.gpB = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds94);
        init();
    }

    private void init() {
        this.mView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(a.h.ala_back_to_last_live_button, (ViewGroup) null);
        this.gpy = (HeadImageView) this.mView.findViewById(a.g.back_to_last_live_portrait);
        this.gpy.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gpy.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        this.gpy.setIsRound(true);
        this.gpy.setAutoChangeStyle(false);
        this.gpy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cjk = (TextView) this.mView.findViewById(a.g.back_to_last_live_content);
    }

    public void show() {
        if (this.mView != null && this.mView.getParent() != null && !this.gpE) {
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
            bPe();
            this.gpy.startLoad(alaLastLiveroomInfo.getLastAnchorPortrait(), 10, false);
            this.gpz = alaLastLiveroomInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnim() {
        int i;
        int width = this.cjk.getWidth();
        int width2 = this.mView.getWidth();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpy.getLayoutParams();
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.addRule(11);
            layoutParams.removeRule(1);
            i = 500;
        } else {
            layoutParams.addRule(1, a.g.back_to_last_live_icon);
            i = 0;
        }
        this.gpy.setLayoutParams(layoutParams);
        if (this.mValueAnimator != null && this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
        this.mValueAnimator = ValueAnimator.ofInt(width2, (width2 - width) - this.gpA).setDuration(i);
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
                b.this.mView.getLayoutParams().width = b.this.gpB;
                b.this.mView.requestLayout();
                Message message = new Message();
                message.what = 2;
                b.this.mHandler.sendMessageDelayed(message, b.this.gpD);
            }
        });
        this.mValueAnimator.start();
    }

    private void bPe() {
        if (this.gpy != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpy.getLayoutParams();
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(11);
            }
            layoutParams.addRule(1, a.g.back_to_last_live_content);
            this.gpy.setLayoutParams(layoutParams);
        }
    }

    public void bPf() {
        if (this.gpz != null && this.gpz.getLastLiveId() > 0 && this.mContext != null) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.mContext.getPageActivity());
            alaLiveRoomActivityConfig.addExtraByLiveId(this.gpz.getLastLiveId(), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(this.gpz.getLastCover())) {
                    jSONObject.put("cover", this.gpz.getLastCover());
                }
                if (!TextUtils.isEmpty(this.gpz.getLastVideoUrl())) {
                    jSONObject.put("live_url", this.gpz.getLastVideoUrl());
                }
                jSONObject.put("enterLiveId", this.gpz.getLastLiveId());
                alaLiveRoomActivityConfig.addExtraByParams(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
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

    private RelativeLayout.LayoutParams bPg() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds204);
        return layoutParams;
    }

    public void au(ViewGroup viewGroup) {
        if (this.mView != null && viewGroup != null && this.mView.getParent() == null) {
            viewGroup.addView(this.mView, bPg());
            if (UtilHelper.getRealScreenOrientation(this.mContext.getPageActivity()) == 2) {
                hide();
            } else {
                show();
            }
            this.mHandler.removeCallbacksAndMessages(null);
            Message message = new Message();
            message.what = 1;
            this.mHandler.sendMessageDelayed(message, this.gpC);
        }
    }

    public void bPh() {
        release();
    }

    private void release() {
        this.gpE = false;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mValueAnimator != null) {
            this.mValueAnimator.cancel();
            this.mValueAnimator = null;
        }
        if (this.mView != null && this.mView.getParent() != null) {
            ((ViewGroup) this.mView.getParent()).removeView(this.mView);
        }
    }

    public void bPi() {
        if (this.mValueAnimator != null && this.mValueAnimator.isRunning()) {
            this.mValueAnimator.cancel();
        }
    }
}
