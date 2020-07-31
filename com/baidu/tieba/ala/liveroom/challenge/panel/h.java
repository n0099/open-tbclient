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
    private static final float[] gga = {AlaChallengeWaveView.ggx, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggv, AlaChallengeWaveView.ggx, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggv};
    private static final float[] ggb = {AlaChallengeWaveView.ggv, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggx, AlaChallengeWaveView.ggv, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggx};
    private static final float[] ggc = {AlaChallengeWaveView.ggv, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggx, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggv};
    private CountDownTimer fFg;
    private TextView gfU;
    private TextView gfV;
    private HeadImageView gfW;
    private HeadImageView gfX;
    private FrameLayout gfY;
    private FrameLayout gfZ;
    private AlaChallengeWaveView gff;
    private AlaChallengeWaveView gfg;
    private boolean ggd;
    private boolean gge;
    private TextView mTipView;

    public h(Context context, m mVar) {
        super(context, mVar);
        this.ggd = false;
        this.gge = false;
        this.gfU = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.gfV = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.gfV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gfS != null) {
                    if (h.this.gge) {
                        h.this.gfS.bGy();
                    } else {
                        h.this.gfS.bGv();
                    }
                }
            }
        });
        this.gfW = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.gfW.setIsRound(true);
        this.gfY = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.gfX = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.gfX.setIsRound(true);
        this.gfZ = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.gff = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.gfg = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.ggd = false;
            if (aVar.wf()) {
                g(aVar);
                return;
            }
            this.gge = true;
            bGD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bGk() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void GF() {
        super.GF();
        bGC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.gff != null) {
            this.gff.endAnimation();
        }
        if (this.gfg != null) {
            this.gfg.endAnimation();
        }
        bzk();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.gfS == null) {
            return false;
        }
        if (this.ggd) {
            this.gfS.bGv();
        } else {
            this.gfS.removeView();
        }
        return true;
    }

    private void bGC() {
        this.ggd = true;
        this.gfU.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.gfV.setVisibility(0);
        this.gfV.setText(a.i.ala_challenge_panel_random_cancel);
        this.gfV.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gfV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gfW.setDrawBorder(false);
        this.gfW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfW.setAutoChangeStyle(false);
        this.gfW.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gfW.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gfZ.setVisibility(8);
        this.gff.setWaveArray(gga);
        this.gfg.setWaveArray(ggb);
        this.gff.startAnimation();
        this.gfg.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(120000L)));
        this.fFg = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.gfS != null) {
                    h.this.gfS.bGv();
                }
            }
        };
        this.fFg.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.gfU.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.gfV.setVisibility(4);
        this.gfZ.setVisibility(0);
        this.gfX.setDrawBorder(false);
        this.gfX.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfX.setAutoChangeStyle(false);
        this.gfX.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gfX.startLoad(aVar.axn, 25, false);
        this.gff.setEndWaveArray(ggc);
        this.gfg.setEndWaveArray(ggc);
        this.gff.endAnimation();
        this.gfg.endAnimation();
        bzk();
    }

    private void bGD() {
        this.gfU.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.gfV.setVisibility(0);
        this.gfV.setText(a.i.ala_challenge_panel_random_retry);
        this.gfV.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.gfV.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.gff.setEndWaveArray(gga);
        this.gfg.setEndWaveArray(ggb);
        this.gff.endAnimation();
        this.gfg.endAnimation();
        bzk();
    }

    private void bzk() {
        if (this.fFg != null) {
            this.fFg.cancel();
        }
    }
}
