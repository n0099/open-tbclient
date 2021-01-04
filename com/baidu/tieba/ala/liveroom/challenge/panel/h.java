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
    private static final float[] hxj = {AlaChallengeWaveView.hxF, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxD, AlaChallengeWaveView.hxF, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxD};
    private static final float[] hxk = {AlaChallengeWaveView.hxD, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxF, AlaChallengeWaveView.hxD, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxF};
    private static final float[] hxl = {AlaChallengeWaveView.hxD, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxF, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxD};
    private CountDownTimer gPY;
    private AlaChallengeWaveView hwo;
    private AlaChallengeWaveView hwp;
    private TextView hxd;
    private TextView hxe;
    private HeadImageView hxf;
    private HeadImageView hxg;
    private FrameLayout hxh;
    private FrameLayout hxi;
    private boolean hxm;
    private boolean hxn;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hxm = false;
        this.hxn = false;
        this.hxd = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hxe = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hxe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hxb != null) {
                    if (h.this.hxn) {
                        h.this.hxb.cgw();
                    } else {
                        h.this.hxb.cgt();
                    }
                }
            }
        });
        this.hxf = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hxf.setIsRound(true);
        this.hxh = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hxg = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hxg.setIsRound(true);
        this.hxi = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hwo = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hwp = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hxm = false;
            if (aVar.DE()) {
                g(aVar);
                return;
            }
            this.hxn = true;
            cgC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int cgi() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
        cgB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hwo != null) {
            this.hwo.endAnimation();
        }
        if (this.hwp != null) {
            this.hwp.endAnimation();
        }
        bWQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hxb == null) {
            return false;
        }
        if (this.hxm) {
            this.hxb.cgt();
        } else {
            this.hxb.removeView();
        }
        return true;
    }

    private void cgB() {
        this.hxm = true;
        this.hxd.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hxe.setVisibility(0);
        this.hxe.setText(a.h.ala_challenge_panel_random_cancel);
        this.hxe.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hxe.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hxf.setDrawBorder(false);
        this.hxf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hxf.setAutoChangeStyle(false);
        this.hxf.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hxf.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hxi.setVisibility(8);
        this.hwo.setWaveArray(hxj);
        this.hwp.setWaveArray(hxk);
        this.hwo.startAnimation();
        this.hwp.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(120000L)));
        this.gPY = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hxb != null) {
                    h.this.hxb.cgt();
                }
            }
        };
        this.gPY.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hxd.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hxe.setVisibility(4);
        this.hxi.setVisibility(0);
        this.hxg.setDrawBorder(false);
        this.hxg.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hxg.setAutoChangeStyle(false);
        this.hxg.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hxg.startLoad(aVar.aIw, 25, false);
        this.hwo.setEndWaveArray(hxl);
        this.hwp.setEndWaveArray(hxl);
        this.hwo.endAnimation();
        this.hwp.endAnimation();
        bWQ();
    }

    private void cgC() {
        this.hxd.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hxe.setVisibility(0);
        this.hxe.setText(a.h.ala_challenge_panel_random_retry);
        this.hxe.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hxe.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hwo.setEndWaveArray(hxj);
        this.hwp.setEndWaveArray(hxk);
        this.hwo.endAnimation();
        this.hwp.endAnimation();
        bWQ();
    }

    private void bWQ() {
        if (this.gPY != null) {
            this.gPY.cancel();
        }
    }
}
