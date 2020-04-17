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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class f extends e {
    private static final float[] fAC = {AlaChallengeWaveView.fBa, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fAY, AlaChallengeWaveView.fBa, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fAY};
    private static final float[] fAD = {AlaChallengeWaveView.fAY, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fBa, AlaChallengeWaveView.fAY, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fBa};
    private static final float[] fAE = {AlaChallengeWaveView.fAY, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fBa, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fAY};
    private FrameLayout fAA;
    private FrameLayout fAB;
    private boolean fAF;
    private boolean fAG;
    private TextView fAw;
    private TextView fAx;
    private HeadImageView fAy;
    private HeadImageView fAz;
    private CountDownTimer faV;
    private AlaChallengeWaveView fzO;
    private AlaChallengeWaveView fzP;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.fAF = false;
        this.fAG = false;
        this.fAw = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.fAx = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.fAx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fAu != null) {
                    if (f.this.fAG) {
                        f.this.fAu.bun();
                    } else {
                        f.this.fAu.bul();
                    }
                }
            }
        });
        this.fAy = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.fAy.setIsRound(true);
        this.fAA = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.fAz = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.fAz.setIsRound(true);
        this.fAB = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.fzO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.fzP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fAF = false;
            if (aVar.ui()) {
                g(aVar);
                return;
            }
            this.fAG = true;
            bus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bue() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void Cd() {
        super.Cd();
        bur();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fzO != null) {
            this.fzO.endAnimation();
        }
        if (this.fzP != null) {
            this.fzP.endAnimation();
        }
        bnm();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.fAu == null) {
            return false;
        }
        if (this.fAF) {
            this.fAu.bul();
        } else {
            this.fAu.removeView();
        }
        return true;
    }

    private void bur() {
        this.fAF = true;
        this.fAw.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.fAx.setVisibility(0);
        this.fAx.setText(a.i.ala_challenge_panel_random_cancel);
        this.fAx.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fAx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fAy.setDrawBorder(false);
        this.fAy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAy.setAutoChangeStyle(false);
        this.fAy.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fAy.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fAB.setVisibility(8);
        this.fzO.setWaveArray(fAC);
        this.fzP.setWaveArray(fAD);
        this.fzO.startAnimation();
        this.fzP.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.ao(120000L)));
        this.faV = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.ao(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.fAu != null) {
                    f.this.fAu.bul();
                }
            }
        };
        this.faV.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.fAw.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.fAx.setVisibility(4);
        this.fAB.setVisibility(0);
        this.fAz.setDrawBorder(false);
        this.fAz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAz.setAutoChangeStyle(false);
        this.fAz.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fAz.startLoad(aVar.apg, 25, false);
        this.fzO.setEndWaveArray(fAE);
        this.fzP.setEndWaveArray(fAE);
        this.fzO.endAnimation();
        this.fzP.endAnimation();
        bnm();
    }

    private void bus() {
        this.fAw.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.fAx.setVisibility(0);
        this.fAx.setText(a.i.ala_challenge_panel_random_retry);
        this.fAx.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.fAx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fzO.setEndWaveArray(fAC);
        this.fzP.setEndWaveArray(fAD);
        this.fzO.endAnimation();
        this.fzP.endAnimation();
        bnm();
    }

    private void bnm() {
        if (this.faV != null) {
            this.faV.cancel();
        }
    }
}
