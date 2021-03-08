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
/* loaded from: classes10.dex */
public class h extends g {
    private static final float[] hyK = {AlaChallengeWaveView.hzg, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hze, AlaChallengeWaveView.hzg, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hze};
    private static final float[] hyL = {AlaChallengeWaveView.hze, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hzg, AlaChallengeWaveView.hze, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hzg};
    private static final float[] hyM = {AlaChallengeWaveView.hze, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hzg, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hze};
    private CountDownTimer gPV;
    private AlaChallengeWaveView hxP;
    private AlaChallengeWaveView hxQ;
    private TextView hyE;
    private TextView hyF;
    private HeadImageView hyG;
    private HeadImageView hyH;
    private FrameLayout hyI;
    private FrameLayout hyJ;
    private boolean hyN;
    private boolean hyO;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hyN = false;
        this.hyO = false;
        this.hyE = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hyF = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hyC != null) {
                    if (h.this.hyO) {
                        h.this.hyC.cdN();
                    } else {
                        h.this.hyC.cdK();
                    }
                }
            }
        });
        this.hyG = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hyG.setIsRound(true);
        this.hyI = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hyH = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hyH.setIsRound(true);
        this.hyJ = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hxP = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hxQ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hyN = false;
            if (aVar.Aw()) {
                g(aVar);
                return;
            }
            this.hyO = true;
            cdT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdz() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
        cdS();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hxP != null) {
            this.hxP.endAnimation();
        }
        if (this.hxQ != null) {
            this.hxQ.endAnimation();
        }
        bTP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hyC == null) {
            return false;
        }
        if (this.hyN) {
            this.hyC.cdK();
        } else {
            this.hyC.removeView();
        }
        return true;
    }

    private void cdS() {
        this.hyN = true;
        this.hyE.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hyF.setVisibility(0);
        this.hyF.setText(a.h.ala_challenge_panel_random_cancel);
        this.hyF.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hyF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hyG.setDrawBorder(false);
        this.hyG.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hyG.setAutoChangeStyle(false);
        this.hyG.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hyG.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hyJ.setVisibility(8);
        this.hxP.setWaveArray(hyK);
        this.hxQ.setWaveArray(hyL);
        this.hxP.startAnimation();
        this.hxQ.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bw(120000L)));
        this.gPV = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bw(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hyC != null) {
                    h.this.hyC.cdK();
                }
            }
        };
        this.gPV.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hyE.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hyF.setVisibility(4);
        this.hyJ.setVisibility(0);
        this.hyH.setDrawBorder(false);
        this.hyH.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hyH.setAutoChangeStyle(false);
        this.hyH.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hyH.startLoad(aVar.aGW, 25, false);
        this.hxP.setEndWaveArray(hyM);
        this.hxQ.setEndWaveArray(hyM);
        this.hxP.endAnimation();
        this.hxQ.endAnimation();
        bTP();
    }

    private void cdT() {
        this.hyE.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hyF.setVisibility(0);
        this.hyF.setText(a.h.ala_challenge_panel_random_retry);
        this.hyF.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hyF.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hxP.setEndWaveArray(hyK);
        this.hxQ.setEndWaveArray(hyL);
        this.hxP.endAnimation();
        this.hxQ.endAnimation();
        bTP();
    }

    private void bTP() {
        if (this.gPV != null) {
            this.gPV.cancel();
        }
    }
}
