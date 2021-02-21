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
/* loaded from: classes11.dex */
public class h extends g {
    private static final float[] hxb = {AlaChallengeWaveView.hxx, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxv, AlaChallengeWaveView.hxx, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxv};
    private static final float[] hxc = {AlaChallengeWaveView.hxv, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxx, AlaChallengeWaveView.hxv, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxx};
    private static final float[] hxd = {AlaChallengeWaveView.hxv, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxx, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxv};
    private CountDownTimer gOm;
    private TextView hwV;
    private TextView hwW;
    private HeadImageView hwX;
    private HeadImageView hwY;
    private FrameLayout hwZ;
    private AlaChallengeWaveView hwg;
    private AlaChallengeWaveView hwh;
    private FrameLayout hxa;
    private boolean hxe;
    private boolean hxf;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hxe = false;
        this.hxf = false;
        this.hwV = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hwW = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hwW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hwT != null) {
                    if (h.this.hxf) {
                        h.this.hwT.cdH();
                    } else {
                        h.this.hwT.cdE();
                    }
                }
            }
        });
        this.hwX = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hwX.setIsRound(true);
        this.hwZ = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hwY = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hwY.setIsRound(true);
        this.hxa = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hwg = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hwh = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hxe = false;
            if (aVar.At()) {
                g(aVar);
                return;
            }
            this.hxf = true;
            cdN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cdt() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
        cdM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hwg != null) {
            this.hwg.endAnimation();
        }
        if (this.hwh != null) {
            this.hwh.endAnimation();
        }
        bTJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hwT == null) {
            return false;
        }
        if (this.hxe) {
            this.hwT.cdE();
        } else {
            this.hwT.removeView();
        }
        return true;
    }

    private void cdM() {
        this.hxe = true;
        this.hwV.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hwW.setVisibility(0);
        this.hwW.setText(a.h.ala_challenge_panel_random_cancel);
        this.hwW.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hwW.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hwX.setDrawBorder(false);
        this.hwX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwX.setAutoChangeStyle(false);
        this.hwX.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwX.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hxa.setVisibility(8);
        this.hwg.setWaveArray(hxb);
        this.hwh.setWaveArray(hxc);
        this.hwg.startAnimation();
        this.hwh.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bw(120000L)));
        this.gOm = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bw(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hwT != null) {
                    h.this.hwT.cdE();
                }
            }
        };
        this.gOm.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hwV.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hwW.setVisibility(4);
        this.hxa.setVisibility(0);
        this.hwY.setDrawBorder(false);
        this.hwY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwY.setAutoChangeStyle(false);
        this.hwY.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwY.startLoad(aVar.aFw, 25, false);
        this.hwg.setEndWaveArray(hxd);
        this.hwh.setEndWaveArray(hxd);
        this.hwg.endAnimation();
        this.hwh.endAnimation();
        bTJ();
    }

    private void cdN() {
        this.hwV.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hwW.setVisibility(0);
        this.hwW.setText(a.h.ala_challenge_panel_random_retry);
        this.hwW.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hwW.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hwg.setEndWaveArray(hxb);
        this.hwh.setEndWaveArray(hxc);
        this.hwg.endAnimation();
        this.hwh.endAnimation();
        bTJ();
    }

    private void bTJ() {
        if (this.gOm != null) {
            this.gOm.cancel();
        }
    }
}
