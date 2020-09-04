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
    private static final float[] gsm = {AlaChallengeWaveView.gsK, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsI, AlaChallengeWaveView.gsK, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsI};
    private static final float[] gsn = {AlaChallengeWaveView.gsI, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsK, AlaChallengeWaveView.gsI, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsK};
    private static final float[] gso = {AlaChallengeWaveView.gsI, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsK, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsI};
    private CountDownTimer fQB;
    private AlaChallengeWaveView grr;
    private AlaChallengeWaveView grs;
    private TextView gsg;
    private TextView gsh;
    private HeadImageView gsi;
    private HeadImageView gsj;
    private FrameLayout gsk;
    private FrameLayout gsl;
    private boolean gsp;
    private boolean gsq;
    private TextView mTipView;

    public h(Context context, m mVar) {
        super(context, mVar);
        this.gsp = false;
        this.gsq = false;
        this.gsg = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.gsh = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.gsh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.gse != null) {
                    if (h.this.gsq) {
                        h.this.gse.bQe();
                    } else {
                        h.this.gse.bQb();
                    }
                }
            }
        });
        this.gsi = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.gsi.setIsRound(true);
        this.gsk = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.gsj = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.gsj.setIsRound(true);
        this.gsl = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.grr = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.grs = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gsp = false;
            if (aVar.BD()) {
                g(aVar);
                return;
            }
            this.gsq = true;
            bQj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public int bPQ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void Mr() {
        super.Mr();
        bQi();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public void hide() {
        super.hide();
        if (this.grr != null) {
            this.grr.endAnimation();
        }
        if (this.grs != null) {
            this.grs.endAnimation();
        }
        bIo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    public boolean onBackKeyDown() {
        if (this.gse == null) {
            return false;
        }
        if (this.gsp) {
            this.gse.bQb();
        } else {
            this.gse.removeView();
        }
        return true;
    }

    private void bQi() {
        this.gsp = true;
        this.gsg.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.gsh.setVisibility(0);
        this.gsh.setText(a.i.ala_challenge_panel_random_cancel);
        this.gsh.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gsh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gsi.setDrawBorder(false);
        this.gsi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gsi.setAutoChangeStyle(false);
        this.gsi.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gsi.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gsl.setVisibility(8);
        this.grr.setWaveArray(gsm);
        this.grs.setWaveArray(gsn);
        this.grr.startAnimation();
        this.grs.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.au(120000L)));
        this.fQB = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.h.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                h.this.mTipView.setText(String.format(h.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.au(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(h.this.mContext, "没有匹配上哦，请稍后再试");
                if (h.this.gse != null) {
                    h.this.gse.bQb();
                }
            }
        };
        this.fQB.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.gsg.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.gsh.setVisibility(4);
        this.gsl.setVisibility(0);
        this.gsj.setDrawBorder(false);
        this.gsj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gsj.setAutoChangeStyle(false);
        this.gsj.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gsj.startLoad(aVar.aCr, 25, false);
        this.grr.setEndWaveArray(gso);
        this.grs.setEndWaveArray(gso);
        this.grr.endAnimation();
        this.grs.endAnimation();
        bIo();
    }

    private void bQj() {
        this.gsg.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.gsh.setVisibility(0);
        this.gsh.setText(a.i.ala_challenge_panel_random_retry);
        this.gsh.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.gsh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.grr.setEndWaveArray(gsm);
        this.grs.setEndWaveArray(gsn);
        this.grr.endAnimation();
        this.grs.endAnimation();
        bIo();
    }

    private void bIo() {
        if (this.fQB != null) {
            this.fQB.cancel();
        }
    }
}
