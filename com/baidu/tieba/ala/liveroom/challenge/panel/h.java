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
/* loaded from: classes3.dex */
public class h extends g {
    private static final float[] gaS = {AlaChallengeWaveView.gbp, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbn, AlaChallengeWaveView.gbp, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbn};
    private static final float[] gaT = {AlaChallengeWaveView.gbn, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbp, AlaChallengeWaveView.gbn, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbp};
    private static final float[] gaU = {AlaChallengeWaveView.gbn, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbp, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbn};
    private AlaChallengeWaveView fZX;
    private AlaChallengeWaveView fZY;
    private CountDownTimer fzZ;
    private TextView gaM;
    private TextView gaN;
    private HeadImageView gaO;
    private HeadImageView gaP;
    private FrameLayout gaQ;
    private FrameLayout gaR;
    private boolean gaV;
    private boolean gaW;
    private TextView mTipView;

    public h(Context context, m mVar) {
        super(context, mVar);
        this.gaV = false;
        this.gaW = false;
        this.gaM = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.gaN = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.gaN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gaK != null) {
                    if (h.this.gaW) {
                        h.this.gaK.bDm();
                    } else {
                        h.this.gaK.bDj();
                    }
                }
            }
        });
        this.gaO = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.gaO.setIsRound(true);
        this.gaQ = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.gaP = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.gaP.setIsRound(true);
        this.gaR = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.fZX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.fZY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gaV = false;
            if (aVar.vJ()) {
                g(aVar);
                return;
            }
            this.gaW = true;
            bDr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bCY() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Eb() {
        super.Eb();
        bDq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.fZX != null) {
            this.fZX.endAnimation();
        }
        if (this.fZY != null) {
            this.fZY.endAnimation();
        }
        bvY();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.gaK == null) {
            return false;
        }
        if (this.gaV) {
            this.gaK.bDj();
        } else {
            this.gaK.removeView();
        }
        return true;
    }

    private void bDq() {
        this.gaV = true;
        this.gaM.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.gaN.setVisibility(0);
        this.gaN.setText(a.i.ala_challenge_panel_random_cancel);
        this.gaN.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gaN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gaO.setDrawBorder(false);
        this.gaO.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gaO.setAutoChangeStyle(false);
        this.gaO.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gaO.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gaR.setVisibility(8);
        this.fZX.setWaveArray(gaS);
        this.fZY.setWaveArray(gaT);
        this.fZX.startAnimation();
        this.fZY.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(120000L)));
        this.fzZ = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.gaK != null) {
                    h.this.gaK.bDj();
                }
            }
        };
        this.fzZ.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.gaM.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.gaN.setVisibility(4);
        this.gaR.setVisibility(0);
        this.gaP.setDrawBorder(false);
        this.gaP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gaP.setAutoChangeStyle(false);
        this.gaP.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gaP.startLoad(aVar.awi, 25, false);
        this.fZX.setEndWaveArray(gaU);
        this.fZY.setEndWaveArray(gaU);
        this.fZX.endAnimation();
        this.fZY.endAnimation();
        bvY();
    }

    private void bDr() {
        this.gaM.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.gaN.setVisibility(0);
        this.gaN.setText(a.i.ala_challenge_panel_random_retry);
        this.gaN.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.gaN.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fZX.setEndWaveArray(gaS);
        this.fZY.setEndWaveArray(gaT);
        this.fZX.endAnimation();
        this.fZY.endAnimation();
        bvY();
    }

    private void bvY() {
        if (this.fzZ != null) {
            this.fzZ.cancel();
        }
    }
}
