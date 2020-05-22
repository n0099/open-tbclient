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
    private static final float[] fOK = {AlaChallengeWaveView.fPi, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPg, AlaChallengeWaveView.fPi, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPg};
    private static final float[] fOL = {AlaChallengeWaveView.fPg, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPi, AlaChallengeWaveView.fPg, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPi};
    private static final float[] fOM = {AlaChallengeWaveView.fPg, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPi, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPg};
    private AlaChallengeWaveView fNW;
    private AlaChallengeWaveView fNX;
    private TextView fOE;
    private TextView fOF;
    private HeadImageView fOG;
    private HeadImageView fOH;
    private FrameLayout fOI;
    private FrameLayout fOJ;
    private boolean fON;
    private boolean fOO;
    private CountDownTimer foC;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.fON = false;
        this.fOO = false;
        this.fOE = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.fOF = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.fOF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fOC != null) {
                    if (f.this.fOO) {
                        f.this.fOC.bAk();
                    } else {
                        f.this.fOC.bAi();
                    }
                }
            }
        });
        this.fOG = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.fOG.setIsRound(true);
        this.fOI = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.fOH = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.fOH.setIsRound(true);
        this.fOJ = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.fNW = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.fNX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fON = false;
            if (aVar.vo()) {
                g(aVar);
                return;
            }
            this.fOO = true;
            bAp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bAb() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void Dz() {
        super.Dz();
        bAo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fNW != null) {
            this.fNW.endAnimation();
        }
        if (this.fNX != null) {
            this.fNX.endAnimation();
        }
        btc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.fOC == null) {
            return false;
        }
        if (this.fON) {
            this.fOC.bAi();
        } else {
            this.fOC.removeView();
        }
        return true;
    }

    private void bAo() {
        this.fON = true;
        this.fOE.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.fOF.setVisibility(0);
        this.fOF.setText(a.i.ala_challenge_panel_random_cancel);
        this.fOF.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fOF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fOG.setDrawBorder(false);
        this.fOG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOG.setAutoChangeStyle(false);
        this.fOG.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOG.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fOJ.setVisibility(8);
        this.fNW.setWaveArray(fOK);
        this.fNX.setWaveArray(fOL);
        this.fNW.startAnimation();
        this.fNX.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(120000L)));
        this.foC = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.fOC != null) {
                    f.this.fOC.bAi();
                }
            }
        };
        this.foC.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.fOE.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.fOF.setVisibility(4);
        this.fOJ.setVisibility(0);
        this.fOH.setDrawBorder(false);
        this.fOH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOH.setAutoChangeStyle(false);
        this.fOH.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOH.startLoad(aVar.aug, 25, false);
        this.fNW.setEndWaveArray(fOM);
        this.fNX.setEndWaveArray(fOM);
        this.fNW.endAnimation();
        this.fNX.endAnimation();
        btc();
    }

    private void bAp() {
        this.fOE.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.fOF.setVisibility(0);
        this.fOF.setText(a.i.ala_challenge_panel_random_retry);
        this.fOF.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.fOF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fNW.setEndWaveArray(fOK);
        this.fNX.setEndWaveArray(fOL);
        this.fNW.endAnimation();
        this.fNX.endAnimation();
        btc();
    }

    private void btc() {
        if (this.foC != null) {
            this.foC.cancel();
        }
    }
}
