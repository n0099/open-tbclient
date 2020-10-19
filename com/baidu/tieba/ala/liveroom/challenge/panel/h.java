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
    private static final float[] gKd = {AlaChallengeWaveView.gKz, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKx, AlaChallengeWaveView.gKz, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKx};
    private static final float[] gKe = {AlaChallengeWaveView.gKx, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKz, AlaChallengeWaveView.gKx, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKz};
    private static final float[] gKf = {AlaChallengeWaveView.gKx, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKz, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKx};
    private TextView gJX;
    private TextView gJY;
    private HeadImageView gJZ;
    private AlaChallengeWaveView gJi;
    private AlaChallengeWaveView gJj;
    private HeadImageView gKa;
    private FrameLayout gKb;
    private FrameLayout gKc;
    private boolean gKg;
    private boolean gKh;
    private CountDownTimer gge;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.gKg = false;
        this.gKh = false;
        this.gJX = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.gJY = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.gJY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gJV != null) {
                    if (h.this.gKh) {
                        h.this.gJV.bUQ();
                    } else {
                        h.this.gJV.bUN();
                    }
                }
            }
        });
        this.gJZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.gJZ.setIsRound(true);
        this.gKb = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.gKa = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.gKa.setIsRound(true);
        this.gKc = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.gJi = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.gJj = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gKg = false;
            if (aVar.CP()) {
                g(aVar);
                return;
            }
            this.gKh = true;
            bUW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bUC() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Oe() {
        super.Oe();
        bUV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gJi != null) {
            this.gJi.endAnimation();
        }
        if (this.gJj != null) {
            this.gJj.endAnimation();
        }
        bMg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.gJV == null) {
            return false;
        }
        if (this.gKg) {
            this.gJV.bUN();
        } else {
            this.gJV.removeView();
        }
        return true;
    }

    private void bUV() {
        this.gKg = true;
        this.gJX.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.gJY.setVisibility(0);
        this.gJY.setText(a.i.ala_challenge_panel_random_cancel);
        this.gJY.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gJY.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gJZ.setDrawBorder(false);
        this.gJZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJZ.setAutoChangeStyle(false);
        this.gJZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gJZ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gKc.setVisibility(8);
        this.gJi.setWaveArray(gKd);
        this.gJj.setWaveArray(gKe);
        this.gJi.startAnimation();
        this.gJj.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.aw(120000L)));
        this.gge = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.aw(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.gJV != null) {
                    h.this.gJV.bUN();
                }
            }
        };
        this.gge.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.gJX.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.gJY.setVisibility(4);
        this.gKc.setVisibility(0);
        this.gKa.setDrawBorder(false);
        this.gKa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gKa.setAutoChangeStyle(false);
        this.gKa.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gKa.startLoad(aVar.aGf, 25, false);
        this.gJi.setEndWaveArray(gKf);
        this.gJj.setEndWaveArray(gKf);
        this.gJi.endAnimation();
        this.gJj.endAnimation();
        bMg();
    }

    private void bUW() {
        this.gJX.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.gJY.setVisibility(0);
        this.gJY.setText(a.i.ala_challenge_panel_random_retry);
        this.gJY.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.gJY.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.gJi.setEndWaveArray(gKd);
        this.gJj.setEndWaveArray(gKe);
        this.gJi.endAnimation();
        this.gJj.endAnimation();
        bMg();
    }

    private void bMg() {
        if (this.gge != null) {
            this.gge.cancel();
        }
    }
}
