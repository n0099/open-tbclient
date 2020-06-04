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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class f extends e {
    private static final float[] fOV = {AlaChallengeWaveView.fPt, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPr, AlaChallengeWaveView.fPt, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPr};
    private static final float[] fOW = {AlaChallengeWaveView.fPr, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPt, AlaChallengeWaveView.fPr, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPt};
    private static final float[] fOX = {AlaChallengeWaveView.fPr, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPt, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPr};
    private TextView fOP;
    private TextView fOQ;
    private HeadImageView fOR;
    private HeadImageView fOS;
    private FrameLayout fOT;
    private FrameLayout fOU;
    private boolean fOY;
    private boolean fOZ;
    private AlaChallengeWaveView fOh;
    private AlaChallengeWaveView fOi;
    private CountDownTimer foN;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.fOY = false;
        this.fOZ = false;
        this.fOP = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.fOQ = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.fOQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.fON != null) {
                    if (f.this.fOZ) {
                        f.this.fON.bAm();
                    } else {
                        f.this.fON.bAk();
                    }
                }
            }
        });
        this.fOR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.fOR.setIsRound(true);
        this.fOT = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.fOS = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.fOS.setIsRound(true);
        this.fOU = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.fOh = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.fOi = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fOY = false;
            if (aVar.vo()) {
                g(aVar);
                return;
            }
            this.fOZ = true;
            bAr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bAd() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void Dz() {
        super.Dz();
        bAq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.fOh != null) {
            this.fOh.endAnimation();
        }
        if (this.fOi != null) {
            this.fOi.endAnimation();
        }
        bte();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.fON == null) {
            return false;
        }
        if (this.fOY) {
            this.fON.bAk();
        } else {
            this.fON.removeView();
        }
        return true;
    }

    private void bAq() {
        this.fOY = true;
        this.fOP.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.fOQ.setVisibility(0);
        this.fOQ.setText(a.i.ala_challenge_panel_random_cancel);
        this.fOQ.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fOQ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fOR.setDrawBorder(false);
        this.fOR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOR.setAutoChangeStyle(false);
        this.fOR.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOR.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fOU.setVisibility(8);
        this.fOh.setWaveArray(fOV);
        this.fOi.setWaveArray(fOW);
        this.fOh.startAnimation();
        this.fOi.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(120000L)));
        this.foN = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.at(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.fON != null) {
                    f.this.fON.bAk();
                }
            }
        };
        this.foN.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.fOP.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.fOQ.setVisibility(4);
        this.fOU.setVisibility(0);
        this.fOS.setDrawBorder(false);
        this.fOS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOS.setAutoChangeStyle(false);
        this.fOS.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOS.startLoad(aVar.aug, 25, false);
        this.fOh.setEndWaveArray(fOX);
        this.fOi.setEndWaveArray(fOX);
        this.fOh.endAnimation();
        this.fOi.endAnimation();
        bte();
    }

    private void bAr() {
        this.fOP.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.fOQ.setVisibility(0);
        this.fOQ.setText(a.i.ala_challenge_panel_random_retry);
        this.fOQ.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.fOQ.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fOh.setEndWaveArray(fOV);
        this.fOi.setEndWaveArray(fOW);
        this.fOh.endAnimation();
        this.fOi.endAnimation();
        bte();
    }

    private void bte() {
        if (this.foN != null) {
            this.foN.cancel();
        }
    }
}
