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
    private static final float[] hbW = {AlaChallengeWaveView.hcs, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcq, AlaChallengeWaveView.hcs, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcq};
    private static final float[] hbX = {AlaChallengeWaveView.hcq, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcs, AlaChallengeWaveView.hcq, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcs};
    private static final float[] hbY = {AlaChallengeWaveView.hcq, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcs, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcq};
    private CountDownTimer gvV;
    private TextView hbQ;
    private TextView hbR;
    private HeadImageView hbS;
    private HeadImageView hbT;
    private FrameLayout hbU;
    private FrameLayout hbV;
    private boolean hbZ;
    private AlaChallengeWaveView hbb;
    private AlaChallengeWaveView hbc;
    private boolean hca;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hbZ = false;
        this.hca = false;
        this.hbQ = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hbR = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hbR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hbO != null) {
                    if (h.this.hca) {
                        h.this.hbO.car();
                    } else {
                        h.this.hbO.cao();
                    }
                }
            }
        });
        this.hbS = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hbS.setIsRound(true);
        this.hbU = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hbT = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hbT.setIsRound(true);
        this.hbV = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hbb = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hbc = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hbZ = false;
            if (aVar.Do()) {
                g(aVar);
                return;
            }
            this.hca = true;
            cax();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cad() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Pc() {
        super.Pc();
        caw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hbb != null) {
            this.hbb.endAnimation();
        }
        if (this.hbc != null) {
            this.hbc.endAnimation();
        }
        bRi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hbO == null) {
            return false;
        }
        if (this.hbZ) {
            this.hbO.cao();
        } else {
            this.hbO.removeView();
        }
        return true;
    }

    private void caw() {
        this.hbZ = true;
        this.hbQ.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hbR.setVisibility(0);
        this.hbR.setText(a.h.ala_challenge_panel_random_cancel);
        this.hbR.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hbR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hbS.setDrawBorder(false);
        this.hbS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbS.setAutoChangeStyle(false);
        this.hbS.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hbS.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hbV.setVisibility(8);
        this.hbb.setWaveArray(hbW);
        this.hbc.setWaveArray(hbX);
        this.hbb.startAnimation();
        this.hbc.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.aU(120000L)));
        this.gvV = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.aU(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hbO != null) {
                    h.this.hbO.cao();
                }
            }
        };
        this.gvV.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hbQ.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hbR.setVisibility(4);
        this.hbV.setVisibility(0);
        this.hbT.setDrawBorder(false);
        this.hbT.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbT.setAutoChangeStyle(false);
        this.hbT.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hbT.startLoad(aVar.aHd, 25, false);
        this.hbb.setEndWaveArray(hbY);
        this.hbc.setEndWaveArray(hbY);
        this.hbb.endAnimation();
        this.hbc.endAnimation();
        bRi();
    }

    private void cax() {
        this.hbQ.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hbR.setVisibility(0);
        this.hbR.setText(a.h.ala_challenge_panel_random_retry);
        this.hbR.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hbR.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hbb.setEndWaveArray(hbW);
        this.hbc.setEndWaveArray(hbX);
        this.hbb.endAnimation();
        this.hbc.endAnimation();
        bRi();
    }

    private void bRi() {
        if (this.gvV != null) {
            this.gvV.cancel();
        }
    }
}
