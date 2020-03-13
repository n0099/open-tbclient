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
    private static final float[] eVQ = {AlaChallengeWaveView.eWo, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWm, AlaChallengeWaveView.eWo, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWm};
    private static final float[] eVR = {AlaChallengeWaveView.eWm, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWo, AlaChallengeWaveView.eWm, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWo};
    private static final float[] eVS = {AlaChallengeWaveView.eWm, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWo, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWm};
    private TextView eVK;
    private TextView eVL;
    private HeadImageView eVM;
    private HeadImageView eVN;
    private FrameLayout eVO;
    private FrameLayout eVP;
    private boolean eVT;
    private boolean eVU;
    private AlaChallengeWaveView eVc;
    private AlaChallengeWaveView eVd;
    private CountDownTimer eww;
    private TextView mTipView;

    public f(Context context, k kVar) {
        super(context, kVar);
        this.eVT = false;
        this.eVU = false;
        this.eVK = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.eVL = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.eVL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eVI != null) {
                    if (f.this.eVU) {
                        f.this.eVI.bkP();
                    } else {
                        f.this.eVI.bkN();
                    }
                }
            }
        });
        this.eVM = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.eVM.setIsRound(true);
        this.eVO = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.eVN = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.eVN.setIsRound(true);
        this.eVP = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.eVc = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.eVd = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eVT = false;
            if (aVar.pM()) {
                g(aVar);
                return;
            }
            this.eVU = true;
            bkU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bkG() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void xm() {
        super.xm();
        bkT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eVc != null) {
            this.eVc.endAnimation();
        }
        if (this.eVd != null) {
            this.eVd.endAnimation();
        }
        bdV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eVI == null) {
            return false;
        }
        if (this.eVT) {
            this.eVI.bkN();
        } else {
            this.eVI.removeView();
        }
        return true;
    }

    private void bkT() {
        this.eVT = true;
        this.eVK.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.eVL.setVisibility(0);
        this.eVL.setText(a.i.ala_challenge_panel_random_cancel);
        this.eVL.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eVL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eVM.setDrawBorder(false);
        this.eVM.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVM.setAutoChangeStyle(false);
        this.eVM.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVM.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eVP.setVisibility(8);
        this.eVc.setWaveArray(eVQ);
        this.eVd.setWaveArray(eVR);
        this.eVc.startAnimation();
        this.eVd.startAnimation();
        this.mTipView.setText(String.format(this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(120000L)));
        this.eww = new CountDownTimer(120000L, 1000L) { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.j.M(Math.round(j / 1000.0d) * 1000)));
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                BdUtilHelper.showToast(f.this.mContext, "没有匹配上哦，请稍后再试");
                if (f.this.eVI != null) {
                    f.this.eVI.bkN();
                }
            }
        };
        this.eww.start();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.eVK.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.eVL.setVisibility(4);
        this.eVP.setVisibility(0);
        this.eVN.setDrawBorder(false);
        this.eVN.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVN.setAutoChangeStyle(false);
        this.eVN.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVN.startLoad(aVar.WU, 25, false);
        this.eVc.setEndWaveArray(eVS);
        this.eVd.setEndWaveArray(eVS);
        this.eVc.endAnimation();
        this.eVd.endAnimation();
        bdV();
    }

    private void bkU() {
        this.eVK.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.eVL.setVisibility(0);
        this.eVL.setText(a.i.ala_challenge_panel_random_retry);
        this.eVL.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.eVL.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eVc.setEndWaveArray(eVQ);
        this.eVd.setEndWaveArray(eVR);
        this.eVc.endAnimation();
        this.eVd.endAnimation();
        bdV();
    }

    private void bdV() {
        if (this.eww != null) {
            this.eww.cancel();
        }
    }
}
