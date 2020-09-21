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
    private static final float[] gvI = {AlaChallengeWaveView.gwg, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwe, AlaChallengeWaveView.gwg, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwe};
    private static final float[] gvJ = {AlaChallengeWaveView.gwe, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwg, AlaChallengeWaveView.gwe, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwg};
    private static final float[] gvK = {AlaChallengeWaveView.gwe, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwg, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwe};
    private CountDownTimer fTL;
    private AlaChallengeWaveView guN;
    private AlaChallengeWaveView guO;
    private TextView gvC;
    private TextView gvD;
    private HeadImageView gvE;
    private HeadImageView gvF;
    private FrameLayout gvG;
    private FrameLayout gvH;
    private boolean gvL;
    private boolean gvM;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.gvL = false;
        this.gvM = false;
        this.gvC = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.gvD = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.gvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gvA != null) {
                    if (h.this.gvM) {
                        h.this.gvA.bRw();
                    } else {
                        h.this.gvA.bRt();
                    }
                }
            }
        });
        this.gvE = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.gvE.setIsRound(true);
        this.gvG = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.gvF = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.gvF.setIsRound(true);
        this.gvH = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.guN = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.guO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gvL = false;
            if (aVar.BS()) {
                g(aVar);
                return;
            }
            this.gvM = true;
            bRC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bRi() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void MZ() {
        super.MZ();
        bRB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.guN != null) {
            this.guN.endAnimation();
        }
        if (this.guO != null) {
            this.guO.endAnimation();
        }
        bJw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.gvA == null) {
            return false;
        }
        if (this.gvL) {
            this.gvA.bRt();
        } else {
            this.gvA.removeView();
        }
        return true;
    }

    private void bRB() {
        this.gvL = true;
        this.gvC.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.gvD.setVisibility(0);
        this.gvD.setText(a.i.ala_challenge_panel_random_cancel);
        this.gvD.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gvD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gvE.setDrawBorder(false);
        this.gvE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvE.setAutoChangeStyle(false);
        this.gvE.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gvE.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gvH.setVisibility(8);
        this.guN.setWaveArray(gvI);
        this.guO.setWaveArray(gvJ);
        this.guN.startAnimation();
        this.guO.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.av(120000L)));
        this.fTL = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.av(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.gvA != null) {
                    h.this.gvA.bRt();
                }
            }
        };
        this.fTL.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.gvC.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.gvD.setVisibility(4);
        this.gvH.setVisibility(0);
        this.gvF.setDrawBorder(false);
        this.gvF.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gvF.setAutoChangeStyle(false);
        this.gvF.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gvF.startLoad(aVar.aDa, 25, false);
        this.guN.setEndWaveArray(gvK);
        this.guO.setEndWaveArray(gvK);
        this.guN.endAnimation();
        this.guO.endAnimation();
        bJw();
    }

    private void bRC() {
        this.gvC.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.gvD.setVisibility(0);
        this.gvD.setText(a.i.ala_challenge_panel_random_retry);
        this.gvD.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.gvD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.guN.setEndWaveArray(gvI);
        this.guO.setEndWaveArray(gvJ);
        this.guN.endAnimation();
        this.guO.endAnimation();
        bJw();
    }

    private void bJw() {
        if (this.fTL != null) {
            this.fTL.cancel();
        }
    }
}
