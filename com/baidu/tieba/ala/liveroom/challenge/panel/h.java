package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class h extends g {
    private static final float[] gVS = {AlaChallengeWaveView.gWo, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWm, AlaChallengeWaveView.gWo, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWm};
    private static final float[] gVT = {AlaChallengeWaveView.gWm, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWo, AlaChallengeWaveView.gWm, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWo};
    private static final float[] gVU = {AlaChallengeWaveView.gWm, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWo, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWm};
    private AlaChallengeWaveView gUX;
    private AlaChallengeWaveView gUY;
    private TextView gVM;
    private TextView gVN;
    private HeadImageView gVO;
    private HeadImageView gVP;
    private FrameLayout gVQ;
    private FrameLayout gVR;
    private boolean gVV;
    private boolean gVW;
    private CountDownTimer gqh;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.gVV = false;
        this.gVW = false;
        this.gVM = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.gVN = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.gVN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gVK != null) {
                    if (h.this.gVW) {
                        h.this.gVK.bXP();
                    } else {
                        h.this.gVK.bXM();
                    }
                }
            }
        });
        this.gVO = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.gVO.setIsRound(true);
        this.gVQ = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.gVP = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.gVP.setIsRound(true);
        this.gVR = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.gUX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.gUY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gVV = false;
            if (aVar.CV()) {
                g(aVar);
                return;
            }
            this.gVW = true;
            bXV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void OC() {
        super.OC();
        bXU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gUX != null) {
            this.gUX.endAnimation();
        }
        if (this.gUY != null) {
            this.gUY.endAnimation();
        }
        bOI();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.gVK == null) {
            return false;
        }
        if (this.gVV) {
            this.gVK.bXM();
        } else {
            this.gVK.removeView();
        }
        return true;
    }

    private void bXU() {
        this.gVV = true;
        this.gVM.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.gVN.setVisibility(0);
        this.gVN.setText(a.i.ala_challenge_panel_random_cancel);
        this.gVN.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gVN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gVO.setDrawBorder(false);
        this.gVO.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVO.setAutoChangeStyle(false);
        this.gVO.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gVO.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gVR.setVisibility(8);
        this.gUX.setWaveArray(gVS);
        this.gUY.setWaveArray(gVT);
        this.gUX.startAnimation();
        this.gUY.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.ay(120000L)));
        this.gqh = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.ay(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.gVK != null) {
                    h.this.gVK.bXM();
                }
            }
        };
        this.gqh.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.gVM.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.gVN.setVisibility(4);
        this.gVR.setVisibility(0);
        this.gVP.setDrawBorder(false);
        this.gVP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVP.setAutoChangeStyle(false);
        this.gVP.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gVP.startLoad(aVar.aGn, 25, false);
        this.gUX.setEndWaveArray(gVU);
        this.gUY.setEndWaveArray(gVU);
        this.gUX.endAnimation();
        this.gUY.endAnimation();
        bOI();
    }

    private void bXV() {
        this.gVM.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.gVN.setVisibility(0);
        this.gVN.setText(a.i.ala_challenge_panel_random_retry);
        this.gVN.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.gVN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.gUX.setEndWaveArray(gVS);
        this.gUY.setEndWaveArray(gVT);
        this.gUX.endAnimation();
        this.gUY.endAnimation();
        bOI();
    }

    private void bOI() {
        if (this.gqh != null) {
            this.gqh.cancel();
        }
    }
}
