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
    private static final float[] hbD = {AlaChallengeWaveView.hbZ, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbX, AlaChallengeWaveView.hbZ, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbX};
    private static final float[] hbE = {AlaChallengeWaveView.hbX, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbZ, AlaChallengeWaveView.hbX, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbZ};
    private static final float[] hbF = {AlaChallengeWaveView.hbX, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbZ, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbX};
    private CountDownTimer gvC;
    private AlaChallengeWaveView haI;
    private AlaChallengeWaveView haJ;
    private HeadImageView hbA;
    private FrameLayout hbB;
    private FrameLayout hbC;
    private boolean hbG;
    private boolean hbH;
    private TextView hbx;
    private TextView hby;
    private HeadImageView hbz;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hbG = false;
        this.hbH = false;
        this.hbx = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hby = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hby.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hbv != null) {
                    if (h.this.hbH) {
                        h.this.hbv.bZK();
                    } else {
                        h.this.hbv.bZH();
                    }
                }
            }
        });
        this.hbz = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hbz.setIsRound(true);
        this.hbB = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hbA = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hbA.setIsRound(true);
        this.hbC = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.haI = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.haJ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hbG = false;
            if (aVar.CF()) {
                g(aVar);
                return;
            }
            this.hbH = true;
            bZQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bZw() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Ot() {
        super.Ot();
        bZP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.haI != null) {
            this.haI.endAnimation();
        }
        if (this.haJ != null) {
            this.haJ.endAnimation();
        }
        bQB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hbv == null) {
            return false;
        }
        if (this.hbG) {
            this.hbv.bZH();
        } else {
            this.hbv.removeView();
        }
        return true;
    }

    private void bZP() {
        this.hbG = true;
        this.hbx.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hby.setVisibility(0);
        this.hby.setText(a.h.ala_challenge_panel_random_cancel);
        this.hby.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hby.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hbz.setDrawBorder(false);
        this.hbz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbz.setAutoChangeStyle(false);
        this.hbz.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hbz.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hbC.setVisibility(8);
        this.haI.setWaveArray(hbD);
        this.haJ.setWaveArray(hbE);
        this.haI.startAnimation();
        this.haJ.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.aU(120000L)));
        this.gvC = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.aU(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hbv != null) {
                    h.this.hbv.bZH();
                }
            }
        };
        this.gvC.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hbx.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hby.setVisibility(4);
        this.hbC.setVisibility(0);
        this.hbA.setDrawBorder(false);
        this.hbA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbA.setAutoChangeStyle(false);
        this.hbA.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hbA.startLoad(aVar.aFs, 25, false);
        this.haI.setEndWaveArray(hbF);
        this.haJ.setEndWaveArray(hbF);
        this.haI.endAnimation();
        this.haJ.endAnimation();
        bQB();
    }

    private void bZQ() {
        this.hbx.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hby.setVisibility(0);
        this.hby.setText(a.h.ala_challenge_panel_random_retry);
        this.hby.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hby.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.haI.setEndWaveArray(hbD);
        this.haJ.setEndWaveArray(hbE);
        this.haI.endAnimation();
        this.haJ.endAnimation();
        bQB();
    }

    private void bQB() {
        if (this.gvC != null) {
            this.gvC.cancel();
        }
    }
}
