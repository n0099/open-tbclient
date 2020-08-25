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
/* loaded from: classes7.dex */
public class h extends g {
    private static final float[] gsi = {AlaChallengeWaveView.gsG, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsE, AlaChallengeWaveView.gsG, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsE};
    private static final float[] gsj = {AlaChallengeWaveView.gsE, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsG, AlaChallengeWaveView.gsE, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsG};
    private static final float[] gsk = {AlaChallengeWaveView.gsE, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsG, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsE};
    private CountDownTimer fQx;
    private AlaChallengeWaveView grn;
    private AlaChallengeWaveView gro;
    private TextView gsc;
    private TextView gsd;
    private HeadImageView gse;
    private HeadImageView gsf;
    private FrameLayout gsg;
    private FrameLayout gsh;
    private boolean gsl;
    private boolean gsm;
    private TextView mTipView;

    public h(Context context, m mVar) {
        super(context, mVar);
        this.gsl = false;
        this.gsm = false;
        this.gsc = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.gsd = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.gsd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gsa != null) {
                    if (h.this.gsm) {
                        h.this.gsa.bQd();
                    } else {
                        h.this.gsa.bQa();
                    }
                }
            }
        });
        this.gse = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.gse.setIsRound(true);
        this.gsg = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.gsf = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.gsf.setIsRound(true);
        this.gsh = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.grn = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.gro = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gsl = false;
            if (aVar.BD()) {
                g(aVar);
                return;
            }
            this.gsm = true;
            bQi();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bPP() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Mr() {
        super.Mr();
        bQh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.grn != null) {
            this.grn.endAnimation();
        }
        if (this.gro != null) {
            this.gro.endAnimation();
        }
        bIn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.gsa == null) {
            return false;
        }
        if (this.gsl) {
            this.gsa.bQa();
        } else {
            this.gsa.removeView();
        }
        return true;
    }

    private void bQh() {
        this.gsl = true;
        this.gsc.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.gsd.setVisibility(0);
        this.gsd.setText(a.i.ala_challenge_panel_random_cancel);
        this.gsd.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gsd.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gse.setDrawBorder(false);
        this.gse.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gse.setAutoChangeStyle(false);
        this.gse.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gse.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gsh.setVisibility(8);
        this.grn.setWaveArray(gsi);
        this.gro.setWaveArray(gsj);
        this.grn.startAnimation();
        this.gro.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.au(120000L)));
        this.fQx = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.au(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.gsa != null) {
                    h.this.gsa.bQa();
                }
            }
        };
        this.fQx.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.gsc.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.gsd.setVisibility(4);
        this.gsh.setVisibility(0);
        this.gsf.setDrawBorder(false);
        this.gsf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gsf.setAutoChangeStyle(false);
        this.gsf.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gsf.startLoad(aVar.aCp, 25, false);
        this.grn.setEndWaveArray(gsk);
        this.gro.setEndWaveArray(gsk);
        this.grn.endAnimation();
        this.gro.endAnimation();
        bIn();
    }

    private void bQi() {
        this.gsc.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.gsd.setVisibility(0);
        this.gsd.setText(a.i.ala_challenge_panel_random_retry);
        this.gsd.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.gsd.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.grn.setEndWaveArray(gsi);
        this.gro.setEndWaveArray(gsj);
        this.grn.endAnimation();
        this.gro.endAnimation();
        bIn();
    }

    private void bIn() {
        if (this.fQx != null) {
            this.fQx.cancel();
        }
    }
}
