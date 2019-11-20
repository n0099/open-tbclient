package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class f extends e {
    private static final float[] eaq = {AlaChallengeWaveView.eaL, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaJ, AlaChallengeWaveView.eaL, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaJ};
    private static final float[] ear = {AlaChallengeWaveView.eaJ, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaL, AlaChallengeWaveView.eaJ, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaL};
    private static final float[] eas = {AlaChallengeWaveView.eaJ, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaL, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaJ};
    private AlaChallengeWaveView dZB;
    private AlaChallengeWaveView dZC;
    private TextView eak;
    private TextView eal;
    private HeadImageView eam;
    private HeadImageView ean;
    private FrameLayout eao;
    private FrameLayout eap;
    private boolean eat;
    private boolean eau;
    private int eav;
    private Runnable eaw;
    private final Handler mHandler;
    private TextView mTipView;

    static /* synthetic */ int a(f fVar) {
        int i = fVar.eav;
        fVar.eav = i + 1;
        return i;
    }

    public f(Context context, k kVar) {
        super(context, kVar);
        this.eat = false;
        this.eau = false;
        this.mHandler = new Handler();
        this.eav = 0;
        this.eaw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.a(f.this);
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.h.stringForLastTime(f.this.eav)));
                f.this.mHandler.removeCallbacks(f.this.eaw);
                f.this.mHandler.postDelayed(f.this.eaw, 1000L);
            }
        };
        this.eak = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.eal = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.eal.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eai != null) {
                    if (f.this.eau) {
                        f.this.eai.aQG();
                    } else {
                        f.this.eai.aQE();
                    }
                }
            }
        });
        this.eam = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.eam.setIsRound(true);
        this.eao = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.ean = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.ean.setIsRound(true);
        this.eap = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.dZB = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.dZC = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eat = false;
            if (aVar.nC()) {
                g(aVar);
                return;
            }
            this.eau = true;
            aQK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int aQz() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void aav() {
        super.aav();
        this.eav = 0;
        aQJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.dZB != null) {
            this.dZB.endAnimation();
        }
        if (this.dZC != null) {
            this.dZC.endAnimation();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eai == null) {
            return false;
        }
        if (this.eat) {
            this.eai.aQE();
        } else {
            this.eai.removeView();
        }
        return true;
    }

    private void aQJ() {
        this.eat = true;
        this.eak.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.eal.setVisibility(0);
        this.eal.setText(a.i.ala_challenge_panel_random_cancel);
        this.eal.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eal.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.mHandler.post(this.eaw);
        this.eam.setDrawBorder(false);
        this.eam.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eam.setAutoChangeStyle(false);
        this.eam.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eam.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eap.setVisibility(8);
        this.dZB.setWaveArray(eaq);
        this.dZC.setWaveArray(ear);
        this.dZB.startAnimation();
        this.dZC.startAnimation();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.eak.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.eal.setVisibility(4);
        this.mHandler.removeCallbacks(this.eaw);
        this.eap.setVisibility(0);
        this.ean.setDrawBorder(false);
        this.ean.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ean.setAutoChangeStyle(false);
        this.ean.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.ean.startLoad(aVar.Oa, 25, false);
        this.dZB.setEndWaveArray(eas);
        this.dZC.setEndWaveArray(eas);
        this.dZB.endAnimation();
        this.dZC.endAnimation();
    }

    private void aQK() {
        this.eak.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.eal.setVisibility(0);
        this.eal.setText(a.i.ala_challenge_panel_random_retry);
        this.eal.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.eal.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.dZB.setEndWaveArray(eaq);
        this.dZC.setEndWaveArray(ear);
        this.dZB.endAnimation();
        this.dZC.endAnimation();
        this.mHandler.removeCallbacks(this.eaw);
    }
}
