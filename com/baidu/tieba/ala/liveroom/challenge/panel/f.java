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
    private static final float[] fAH = {AlaChallengeWaveView.fBf, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBd, AlaChallengeWaveView.fBf, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBd};
    private static final float[] fAI = {AlaChallengeWaveView.fBd, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBf, AlaChallengeWaveView.fBd, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBf};
    private static final float[] fAJ = {AlaChallengeWaveView.fBd, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBf, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBd};
    private TextView fAB;
    private TextView fAC;
    private HeadImageView fAD;
    private HeadImageView fAE;
    private FrameLayout fAF;
    private FrameLayout fAG;
    private boolean fAK;
    private boolean fAL;
    private CountDownTimer fba;
    private AlaChallengeWaveView fzT;
    private AlaChallengeWaveView fzU;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.fAK = false;
        this.fAL = false;
        this.fAB = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.fAC = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.fAC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fAz != null) {
                    if (f.this.fAL) {
                        f.this.fAz.bul();
                    } else {
                        f.this.fAz.buj();
                    }
                }
            }
        });
        this.fAD = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.fAD.setIsRound(true);
        this.fAF = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.fAE = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.fAE.setIsRound(true);
        this.fAG = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.fzT = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.fzU = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fAK = false;
            if (aVar.uh()) {
                g(aVar);
                return;
            }
            this.fAL = true;
            buq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int buc() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void Cc() {
        super.Cc();
        bup();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fzT != null) {
            this.fzT.endAnimation();
        }
        if (this.fzU != null) {
            this.fzU.endAnimation();
        }
        bnk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.fAz == null) {
            return false;
        }
        if (this.fAK) {
            this.fAz.buj();
        } else {
            this.fAz.removeView();
        }
        return true;
    }

    private void bup() {
        this.fAK = true;
        this.fAB.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.fAC.setVisibility(0);
        this.fAC.setText(a.i.ala_challenge_panel_random_cancel);
        this.fAC.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fAC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fAD.setDrawBorder(false);
        this.fAD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAD.setAutoChangeStyle(false);
        this.fAD.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fAD.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fAG.setVisibility(8);
        this.fzT.setWaveArray(fAH);
        this.fzU.setWaveArray(fAI);
        this.fzT.startAnimation();
        this.fzU.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.ao(120000L)));
        this.fba = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.ao(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.fAz != null) {
                    f.this.fAz.buj();
                }
            }
        };
        this.fba.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.fAB.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.fAC.setVisibility(4);
        this.fAG.setVisibility(0);
        this.fAE.setDrawBorder(false);
        this.fAE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fAE.setAutoChangeStyle(false);
        this.fAE.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fAE.startLoad(aVar.apm, 25, false);
        this.fzT.setEndWaveArray(fAJ);
        this.fzU.setEndWaveArray(fAJ);
        this.fzT.endAnimation();
        this.fzU.endAnimation();
        bnk();
    }

    private void buq() {
        this.fAB.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.fAC.setVisibility(0);
        this.fAC.setText(a.i.ala_challenge_panel_random_retry);
        this.fAC.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.fAC.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fzT.setEndWaveArray(fAH);
        this.fzU.setEndWaveArray(fAI);
        this.fzT.endAnimation();
        this.fzU.endAnimation();
        bnk();
    }

    private void bnk() {
        if (this.fba != null) {
            this.fba.cancel();
        }
    }
}
