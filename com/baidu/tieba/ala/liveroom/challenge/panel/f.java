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
    private static final float[] eVC = {AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eVY, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eVY};
    private static final float[] eVD = {AlaChallengeWaveView.eVY, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVY, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa};
    private static final float[] eVE = {AlaChallengeWaveView.eVY, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eVY};
    private AlaChallengeWaveView eUO;
    private AlaChallengeWaveView eUP;
    private FrameLayout eVA;
    private FrameLayout eVB;
    private boolean eVF;
    private boolean eVG;
    private TextView eVw;
    private TextView eVx;
    private HeadImageView eVy;
    private HeadImageView eVz;
    private CountDownTimer ewi;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.eVF = false;
        this.eVG = false;
        this.eVw = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.eVx = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.eVx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eVu != null) {
                    if (f.this.eVG) {
                        f.this.eVu.bkM();
                    } else {
                        f.this.eVu.bkK();
                    }
                }
            }
        });
        this.eVy = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.eVy.setIsRound(true);
        this.eVA = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.eVz = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.eVz.setIsRound(true);
        this.eVB = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.eUO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.eUP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eVF = false;
            if (aVar.pM()) {
                g(aVar);
                return;
            }
            this.eVG = true;
            bkR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkD() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void xm() {
        super.xm();
        bkQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eUO != null) {
            this.eUO.endAnimation();
        }
        if (this.eUP != null) {
            this.eUP.endAnimation();
        }
        bdS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eVu == null) {
            return false;
        }
        if (this.eVF) {
            this.eVu.bkK();
        } else {
            this.eVu.removeView();
        }
        return true;
    }

    private void bkQ() {
        this.eVF = true;
        this.eVw.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.eVx.setVisibility(0);
        this.eVx.setText(a.i.ala_challenge_panel_random_cancel);
        this.eVx.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eVx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eVy.setDrawBorder(false);
        this.eVy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVy.setAutoChangeStyle(false);
        this.eVy.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVy.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eVB.setVisibility(8);
        this.eUO.setWaveArray(eVC);
        this.eUP.setWaveArray(eVD);
        this.eUO.startAnimation();
        this.eUP.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(120000L)));
        this.ewi = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.eVu != null) {
                    f.this.eVu.bkK();
                }
            }
        };
        this.ewi.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.eVw.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.eVx.setVisibility(4);
        this.eVB.setVisibility(0);
        this.eVz.setDrawBorder(false);
        this.eVz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVz.setAutoChangeStyle(false);
        this.eVz.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVz.startLoad(aVar.WU, 25, false);
        this.eUO.setEndWaveArray(eVE);
        this.eUP.setEndWaveArray(eVE);
        this.eUO.endAnimation();
        this.eUP.endAnimation();
        bdS();
    }

    private void bkR() {
        this.eVw.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.eVx.setVisibility(0);
        this.eVx.setText(a.i.ala_challenge_panel_random_retry);
        this.eVx.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.eVx.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eUO.setEndWaveArray(eVC);
        this.eUP.setEndWaveArray(eVD);
        this.eUO.endAnimation();
        this.eUP.endAnimation();
        bdS();
    }

    private void bdS() {
        if (this.ewi != null) {
            this.ewi.cancel();
        }
    }
}
