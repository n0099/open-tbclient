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
/* loaded from: classes11.dex */
public class h extends g {
    private static final float[] hwN = {AlaChallengeWaveView.hxj, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxh, AlaChallengeWaveView.hxj, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxh};
    private static final float[] hwO = {AlaChallengeWaveView.hxh, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxj, AlaChallengeWaveView.hxh, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxj};
    private static final float[] hwP = {AlaChallengeWaveView.hxh, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxj, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxh};
    private CountDownTimer gNY;
    private AlaChallengeWaveView hvS;
    private AlaChallengeWaveView hvT;
    private TextView hwH;
    private TextView hwI;
    private HeadImageView hwJ;
    private HeadImageView hwK;
    private FrameLayout hwL;
    private FrameLayout hwM;
    private boolean hwQ;
    private boolean hwR;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hwQ = false;
        this.hwR = false;
        this.hwH = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hwI = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hwI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hwF != null) {
                    if (h.this.hwR) {
                        h.this.hwF.cdA();
                    } else {
                        h.this.hwF.cdx();
                    }
                }
            }
        });
        this.hwJ = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hwJ.setIsRound(true);
        this.hwL = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hwK = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hwK.setIsRound(true);
        this.hwM = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hvS = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hvT = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hwQ = false;
            if (aVar.At()) {
                g(aVar);
                return;
            }
            this.hwR = true;
            cdG();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdm() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
        cdF();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hvS != null) {
            this.hvS.endAnimation();
        }
        if (this.hvT != null) {
            this.hvT.endAnimation();
        }
        bTC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hwF == null) {
            return false;
        }
        if (this.hwQ) {
            this.hwF.cdx();
        } else {
            this.hwF.removeView();
        }
        return true;
    }

    private void cdF() {
        this.hwQ = true;
        this.hwH.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hwI.setVisibility(0);
        this.hwI.setText(a.h.ala_challenge_panel_random_cancel);
        this.hwI.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hwI.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hwJ.setDrawBorder(false);
        this.hwJ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwJ.setAutoChangeStyle(false);
        this.hwJ.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwJ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hwM.setVisibility(8);
        this.hvS.setWaveArray(hwN);
        this.hvT.setWaveArray(hwO);
        this.hvS.startAnimation();
        this.hvT.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bw(120000L)));
        this.gNY = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bw(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hwF != null) {
                    h.this.hwF.cdx();
                }
            }
        };
        this.gNY.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hwH.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hwI.setVisibility(4);
        this.hwM.setVisibility(0);
        this.hwK.setDrawBorder(false);
        this.hwK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwK.setAutoChangeStyle(false);
        this.hwK.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwK.startLoad(aVar.aFw, 25, false);
        this.hvS.setEndWaveArray(hwP);
        this.hvT.setEndWaveArray(hwP);
        this.hvS.endAnimation();
        this.hvT.endAnimation();
        bTC();
    }

    private void cdG() {
        this.hwH.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hwI.setVisibility(0);
        this.hwI.setText(a.h.ala_challenge_panel_random_retry);
        this.hwI.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hwI.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hvS.setEndWaveArray(hwN);
        this.hvT.setEndWaveArray(hwO);
        this.hvS.endAnimation();
        this.hvT.endAnimation();
        bTC();
    }

    private void bTC() {
        if (this.gNY != null) {
            this.gNY.cancel();
        }
    }
}
