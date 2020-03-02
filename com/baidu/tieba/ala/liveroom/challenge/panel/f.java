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
    private static final float[] eVD = {AlaChallengeWaveView.eWb, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWb, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ};
    private static final float[] eVE = {AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eWb, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eWb};
    private static final float[] eVF = {AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eWb, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ};
    private AlaChallengeWaveView eUP;
    private AlaChallengeWaveView eUQ;
    private HeadImageView eVA;
    private FrameLayout eVB;
    private FrameLayout eVC;
    private boolean eVG;
    private boolean eVH;
    private TextView eVx;
    private TextView eVy;
    private HeadImageView eVz;
    private CountDownTimer ewj;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.eVG = false;
        this.eVH = false;
        this.eVx = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.eVy = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.eVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eVv != null) {
                    if (f.this.eVH) {
                        f.this.eVv.bkO();
                    } else {
                        f.this.eVv.bkM();
                    }
                }
            }
        });
        this.eVz = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.eVz.setIsRound(true);
        this.eVB = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.eVA = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.eVA.setIsRound(true);
        this.eVC = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.eUP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.eUQ = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eVG = false;
            if (aVar.pM()) {
                g(aVar);
                return;
            }
            this.eVH = true;
            bkT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkF() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void xm() {
        super.xm();
        bkS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eUP != null) {
            this.eUP.endAnimation();
        }
        if (this.eUQ != null) {
            this.eUQ.endAnimation();
        }
        bdU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eVv == null) {
            return false;
        }
        if (this.eVG) {
            this.eVv.bkM();
        } else {
            this.eVv.removeView();
        }
        return true;
    }

    private void bkS() {
        this.eVG = true;
        this.eVx.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.eVy.setVisibility(0);
        this.eVy.setText(a.i.ala_challenge_panel_random_cancel);
        this.eVy.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eVy.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eVz.setDrawBorder(false);
        this.eVz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVz.setAutoChangeStyle(false);
        this.eVz.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVz.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eVC.setVisibility(8);
        this.eUP.setWaveArray(eVD);
        this.eUQ.setWaveArray(eVE);
        this.eUP.startAnimation();
        this.eUQ.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(120000L)));
        this.ewj = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.eVv != null) {
                    f.this.eVv.bkM();
                }
            }
        };
        this.ewj.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.eVx.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.eVy.setVisibility(4);
        this.eVC.setVisibility(0);
        this.eVA.setDrawBorder(false);
        this.eVA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVA.setAutoChangeStyle(false);
        this.eVA.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVA.startLoad(aVar.WU, 25, false);
        this.eUP.setEndWaveArray(eVF);
        this.eUQ.setEndWaveArray(eVF);
        this.eUP.endAnimation();
        this.eUQ.endAnimation();
        bdU();
    }

    private void bkT() {
        this.eVx.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.eVy.setVisibility(0);
        this.eVy.setText(a.i.ala_challenge_panel_random_retry);
        this.eVy.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.eVy.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eUP.setEndWaveArray(eVD);
        this.eUQ.setEndWaveArray(eVE);
        this.eUP.endAnimation();
        this.eUQ.endAnimation();
        bdU();
    }

    private void bdU() {
        if (this.ewj != null) {
            this.ewj.cancel();
        }
    }
}
