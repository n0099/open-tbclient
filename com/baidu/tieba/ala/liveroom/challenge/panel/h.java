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
    private static final float[] hlo = {AlaChallengeWaveView.hlK, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlK, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlI};
    private static final float[] hlp = {AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlK, AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlK};
    private static final float[] hlq = {AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlK, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlI};
    private CountDownTimer gEo;
    private AlaChallengeWaveView hkt;
    private AlaChallengeWaveView hku;
    private TextView hli;
    private TextView hlj;
    private HeadImageView hlk;
    private HeadImageView hll;
    private FrameLayout hlm;
    private FrameLayout hln;
    private boolean hlr;
    private boolean hls;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hlr = false;
        this.hls = false;
        this.hli = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hlj = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hlj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hlg != null) {
                    if (h.this.hls) {
                        h.this.hlg.cdG();
                    } else {
                        h.this.hlg.cdD();
                    }
                }
            }
        });
        this.hlk = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hlk.setIsRound(true);
        this.hlm = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hll = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hll.setIsRound(true);
        this.hln = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hkt = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hku = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hlr = false;
            if (aVar.Ep()) {
                g(aVar);
                return;
            }
            this.hls = true;
            cdM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cds() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void QM() {
        super.QM();
        cdL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hkt != null) {
            this.hkt.endAnimation();
        }
        if (this.hku != null) {
            this.hku.endAnimation();
        }
        bUm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hlg == null) {
            return false;
        }
        if (this.hlr) {
            this.hlg.cdD();
        } else {
            this.hlg.removeView();
        }
        return true;
    }

    private void cdL() {
        this.hlr = true;
        this.hli.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hlj.setVisibility(0);
        this.hlj.setText(a.h.ala_challenge_panel_random_cancel);
        this.hlj.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hlj.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hlk.setDrawBorder(false);
        this.hlk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hlk.setAutoChangeStyle(false);
        this.hlk.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hlk.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hln.setVisibility(8);
        this.hkt.setWaveArray(hlo);
        this.hku.setWaveArray(hlp);
        this.hkt.startAnimation();
        this.hku.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(120000L)));
        this.gEo = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hlg != null) {
                    h.this.hlg.cdD();
                }
            }
        };
        this.gEo.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hli.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hlj.setVisibility(4);
        this.hln.setVisibility(0);
        this.hll.setDrawBorder(false);
        this.hll.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hll.setAutoChangeStyle(false);
        this.hll.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hll.startLoad(aVar.aIa, 25, false);
        this.hkt.setEndWaveArray(hlq);
        this.hku.setEndWaveArray(hlq);
        this.hkt.endAnimation();
        this.hku.endAnimation();
        bUm();
    }

    private void cdM() {
        this.hli.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hlj.setVisibility(0);
        this.hlj.setText(a.h.ala_challenge_panel_random_retry);
        this.hlj.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hlj.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hkt.setEndWaveArray(hlo);
        this.hku.setEndWaveArray(hlp);
        this.hkt.endAnimation();
        this.hku.endAnimation();
        bUm();
    }

    private void bUm() {
        if (this.gEo != null) {
            this.gEo.cancel();
        }
    }
}
