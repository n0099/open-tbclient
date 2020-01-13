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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class f extends e {
    private static final float[] eRL = {AlaChallengeWaveView.eSj, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSh, AlaChallengeWaveView.eSj, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSh};
    private static final float[] eRM = {AlaChallengeWaveView.eSh, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSj, AlaChallengeWaveView.eSh, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSj};
    private static final float[] eRN = {AlaChallengeWaveView.eSh, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSj, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSh};
    private AlaChallengeWaveView eQX;
    private AlaChallengeWaveView eQY;
    private TextView eRF;
    private TextView eRG;
    private HeadImageView eRH;
    private HeadImageView eRI;
    private FrameLayout eRJ;
    private FrameLayout eRK;
    private boolean eRO;
    private boolean eRP;
    private CountDownTimer erY;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.eRO = false;
        this.eRP = false;
        this.eRF = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.eRG = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.eRG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eRD != null) {
                    if (f.this.eRP) {
                        f.this.eRD.biX();
                    } else {
                        f.this.eRD.biV();
                    }
                }
            }
        });
        this.eRH = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.eRH.setIsRound(true);
        this.eRJ = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.eRI = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.eRI.setIsRound(true);
        this.eRK = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.eQX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.eQY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eRO = false;
            if (aVar.pb()) {
                g(aVar);
                return;
            }
            this.eRP = true;
            bjc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int biN() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void biO() {
        super.biO();
        bjb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eQX != null) {
            this.eQX.endAnimation();
        }
        if (this.eQY != null) {
            this.eQY.endAnimation();
        }
        bbD();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eRD == null) {
            return false;
        }
        if (this.eRO) {
            this.eRD.biV();
        } else {
            this.eRD.removeView();
        }
        return true;
    }

    private void bjb() {
        this.eRO = true;
        this.eRF.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.eRG.setVisibility(0);
        this.eRG.setText(a.i.ala_challenge_panel_random_cancel);
        this.eRG.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eRG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eRH.setDrawBorder(false);
        this.eRH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eRH.setAutoChangeStyle(false);
        this.eRH.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eRH.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eRK.setVisibility(8);
        this.eQX.setWaveArray(eRL);
        this.eQY.setWaveArray(eRM);
        this.eQX.startAnimation();
        this.eQY.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.I(120000L)));
        this.erY = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.I(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.eRD != null) {
                    f.this.eRD.biV();
                }
            }
        };
        this.erY.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.eRF.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.eRG.setVisibility(4);
        this.eRK.setVisibility(0);
        this.eRI.setDrawBorder(false);
        this.eRI.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eRI.setAutoChangeStyle(false);
        this.eRI.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eRI.startLoad(aVar.Vo, 25, false);
        this.eQX.setEndWaveArray(eRN);
        this.eQY.setEndWaveArray(eRN);
        this.eQX.endAnimation();
        this.eQY.endAnimation();
        bbD();
    }

    private void bjc() {
        this.eRF.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.eRG.setVisibility(0);
        this.eRG.setText(a.i.ala_challenge_panel_random_retry);
        this.eRG.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.eRG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eQX.setEndWaveArray(eRL);
        this.eQY.setEndWaveArray(eRM);
        this.eQX.endAnimation();
        this.eQY.endAnimation();
        bbD();
    }

    private void bbD() {
        if (this.erY != null) {
            this.erY.cancel();
        }
    }
}
