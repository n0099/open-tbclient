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
    private static final float[] eWo = {AlaChallengeWaveView.eWM, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWK, AlaChallengeWaveView.eWM, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWK};
    private static final float[] eWp = {AlaChallengeWaveView.eWK, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWM, AlaChallengeWaveView.eWK, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWM};
    private static final float[] eWq = {AlaChallengeWaveView.eWK, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWM, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWK};
    private AlaChallengeWaveView eVA;
    private AlaChallengeWaveView eVB;
    private TextView eWi;
    private TextView eWj;
    private HeadImageView eWk;
    private HeadImageView eWl;
    private FrameLayout eWm;
    private FrameLayout eWn;
    private boolean eWr;
    private boolean eWs;
    private CountDownTimer ewS;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.eWr = false;
        this.eWs = false;
        this.eWi = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.eWj = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.eWj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eWg != null) {
                    if (f.this.eWs) {
                        f.this.eWg.bkU();
                    } else {
                        f.this.eWg.bkS();
                    }
                }
            }
        });
        this.eWk = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.eWk.setIsRound(true);
        this.eWm = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.eWl = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.eWl.setIsRound(true);
        this.eWn = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.eVA = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.eVB = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eWr = false;
            if (aVar.pR()) {
                g(aVar);
                return;
            }
            this.eWs = true;
            bkZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkL() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void xr() {
        super.xr();
        bkY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eVA != null) {
            this.eVA.endAnimation();
        }
        if (this.eVB != null) {
            this.eVB.endAnimation();
        }
        bea();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eWg == null) {
            return false;
        }
        if (this.eWr) {
            this.eWg.bkS();
        } else {
            this.eWg.removeView();
        }
        return true;
    }

    private void bkY() {
        this.eWr = true;
        this.eWi.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.eWj.setVisibility(0);
        this.eWj.setText(a.i.ala_challenge_panel_random_cancel);
        this.eWj.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eWj.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eWk.setDrawBorder(false);
        this.eWk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eWk.setAutoChangeStyle(false);
        this.eWk.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eWk.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eWn.setVisibility(8);
        this.eVA.setWaveArray(eWo);
        this.eVB.setWaveArray(eWp);
        this.eVA.startAnimation();
        this.eVB.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(120000L)));
        this.ewS = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.eWg != null) {
                    f.this.eWg.bkS();
                }
            }
        };
        this.ewS.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.eWi.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.eWj.setVisibility(4);
        this.eWn.setVisibility(0);
        this.eWl.setDrawBorder(false);
        this.eWl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eWl.setAutoChangeStyle(false);
        this.eWl.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eWl.startLoad(aVar.Xe, 25, false);
        this.eVA.setEndWaveArray(eWq);
        this.eVB.setEndWaveArray(eWq);
        this.eVA.endAnimation();
        this.eVB.endAnimation();
        bea();
    }

    private void bkZ() {
        this.eWi.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.eWj.setVisibility(0);
        this.eWj.setText(a.i.ala_challenge_panel_random_retry);
        this.eWj.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.eWj.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eVA.setEndWaveArray(eWo);
        this.eVB.setEndWaveArray(eWp);
        this.eVA.endAnimation();
        this.eVB.endAnimation();
        bea();
    }

    private void bea() {
        if (this.ewS != null) {
            this.ewS.cancel();
        }
    }
}
