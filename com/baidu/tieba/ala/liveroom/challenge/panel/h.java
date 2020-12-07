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
    private static final float[] hlm = {AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlG, AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlG};
    private static final float[] hln = {AlaChallengeWaveView.hlG, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlG, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlI};
    private static final float[] hlo = {AlaChallengeWaveView.hlG, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlG};
    private CountDownTimer gEm;
    private AlaChallengeWaveView hkr;
    private AlaChallengeWaveView hks;
    private TextView hlg;
    private TextView hlh;
    private HeadImageView hli;
    private HeadImageView hlj;
    private FrameLayout hlk;
    private FrameLayout hll;
    private boolean hlp;
    private boolean hlq;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hlp = false;
        this.hlq = false;
        this.hlg = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hlh = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hlh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hle != null) {
                    if (h.this.hlq) {
                        h.this.hle.cdF();
                    } else {
                        h.this.hle.cdC();
                    }
                }
            }
        });
        this.hli = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hli.setIsRound(true);
        this.hlk = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hlj = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hlj.setIsRound(true);
        this.hll = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hkr = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hks = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hlp = false;
            if (aVar.Ep()) {
                g(aVar);
                return;
            }
            this.hlq = true;
            cdL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void QM() {
        super.QM();
        cdK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hkr != null) {
            this.hkr.endAnimation();
        }
        if (this.hks != null) {
            this.hks.endAnimation();
        }
        bUl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hle == null) {
            return false;
        }
        if (this.hlp) {
            this.hle.cdC();
        } else {
            this.hle.removeView();
        }
        return true;
    }

    private void cdK() {
        this.hlp = true;
        this.hlg.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hlh.setVisibility(0);
        this.hlh.setText(a.h.ala_challenge_panel_random_cancel);
        this.hlh.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hlh.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hli.setDrawBorder(false);
        this.hli.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hli.setAutoChangeStyle(false);
        this.hli.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hli.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hll.setVisibility(8);
        this.hkr.setWaveArray(hlm);
        this.hks.setWaveArray(hln);
        this.hkr.startAnimation();
        this.hks.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(120000L)));
        this.gEm = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hle != null) {
                    h.this.hle.cdC();
                }
            }
        };
        this.gEm.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hlg.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hlh.setVisibility(4);
        this.hll.setVisibility(0);
        this.hlj.setDrawBorder(false);
        this.hlj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hlj.setAutoChangeStyle(false);
        this.hlj.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hlj.startLoad(aVar.aIa, 25, false);
        this.hkr.setEndWaveArray(hlo);
        this.hks.setEndWaveArray(hlo);
        this.hkr.endAnimation();
        this.hks.endAnimation();
        bUl();
    }

    private void cdL() {
        this.hlg.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hlh.setVisibility(0);
        this.hlh.setText(a.h.ala_challenge_panel_random_retry);
        this.hlh.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hlh.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hkr.setEndWaveArray(hlm);
        this.hks.setEndWaveArray(hln);
        this.hkr.endAnimation();
        this.hks.endAnimation();
        bUl();
    }

    private void bUl() {
        if (this.gEm != null) {
            this.gEm.cancel();
        }
    }
}
