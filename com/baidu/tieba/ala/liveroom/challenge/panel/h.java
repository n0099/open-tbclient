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
    private static final float[] hsD = {AlaChallengeWaveView.hsZ, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsX, AlaChallengeWaveView.hsZ, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsX};
    private static final float[] hsE = {AlaChallengeWaveView.hsX, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsZ, AlaChallengeWaveView.hsX, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsZ};
    private static final float[] hsF = {AlaChallengeWaveView.hsX, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsZ, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsX};
    private CountDownTimer gLs;
    private AlaChallengeWaveView hrI;
    private AlaChallengeWaveView hrJ;
    private HeadImageView hsA;
    private FrameLayout hsB;
    private FrameLayout hsC;
    private boolean hsG;
    private boolean hsH;
    private TextView hsx;
    private TextView hsy;
    private HeadImageView hsz;
    private TextView mTipView;

    public h(Context context, n nVar) {
        super(context, nVar);
        this.hsG = false;
        this.hsH = false;
        this.hsx = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_tip);
        this.hsy = (TextView) this.mRootView.findViewById(a.f.ala_challenge_panel_random_ops);
        this.hsy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.hsv != null) {
                    if (h.this.hsH) {
                        h.this.hsv.ccF();
                    } else {
                        h.this.hsv.ccC();
                    }
                }
            }
        });
        this.hsz = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_my_header);
        this.hsz.setIsRound(true);
        this.hsB = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_my_header_layout);
        this.hsA = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header);
        this.hsA.setIsRound(true);
        this.hsC = (FrameLayout) this.mRootView.findViewById(a.f.ala_challenge_random_opponent_header_layout);
        this.hrI = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_left);
        this.hrJ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hsG = false;
            if (aVar.zJ()) {
                g(aVar);
                return;
            }
            this.hsH = true;
            ccL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int ccr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void onShow() {
        super.onShow();
        ccK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.hrI != null) {
            this.hrI.endAnimation();
        }
        if (this.hrJ != null) {
            this.hrJ.endAnimation();
        }
        bSZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.hsv == null) {
            return false;
        }
        if (this.hsG) {
            this.hsv.ccC();
        } else {
            this.hsv.removeView();
        }
        return true;
    }

    private void ccK() {
        this.hsG = true;
        this.hsx.setText(a.h.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.hsy.setVisibility(0);
        this.hsy.setText(a.h.ala_challenge_panel_random_cancel);
        this.hsy.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hsy.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hsz.setDrawBorder(false);
        this.hsz.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hsz.setAutoChangeStyle(false);
        this.hsz.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hsz.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hsC.setVisibility(8);
        this.hrI.setWaveArray(hsD);
        this.hrJ.setWaveArray(hsE);
        this.hrI.startAnimation();
        this.hrJ.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(120000L)));
        this.gLs = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.k.bs(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.hsv != null) {
                    h.this.hsv.ccC();
                }
            }
        };
        this.gLs.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.hsx.setText(a.h.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_succ_tip);
        this.hsy.setVisibility(4);
        this.hsC.setVisibility(0);
        this.hsA.setDrawBorder(false);
        this.hsA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hsA.setAutoChangeStyle(false);
        this.hsA.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hsA.startLoad(aVar.aDJ, 25, false);
        this.hrI.setEndWaveArray(hsF);
        this.hrJ.setEndWaveArray(hsF);
        this.hrI.endAnimation();
        this.hrJ.endAnimation();
        bSZ();
    }

    private void ccL() {
        this.hsx.setText(a.h.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.h.ala_challenge_panel_random_fail_tip);
        this.hsy.setVisibility(0);
        this.hsy.setText(a.h.ala_challenge_panel_random_retry);
        this.hsy.setBackgroundResource(a.e.ala_challenge_panel_random_ops_retry_bg_shape);
        this.hsy.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hrI.setEndWaveArray(hsD);
        this.hrJ.setEndWaveArray(hsE);
        this.hrI.endAnimation();
        this.hrJ.endAnimation();
        bSZ();
    }

    private void bSZ() {
        if (this.gLs != null) {
            this.gLs.cancel();
        }
    }
}
