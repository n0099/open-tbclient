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
    private static final float[] ebh = {AlaChallengeWaveView.ebC, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebA, AlaChallengeWaveView.ebC, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebA};
    private static final float[] ebi = {AlaChallengeWaveView.ebA, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebC, AlaChallengeWaveView.ebA, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebC};
    private static final float[] ebj = {AlaChallengeWaveView.ebA, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebC, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebA};
    private AlaChallengeWaveView eas;
    private AlaChallengeWaveView eat;
    private TextView ebb;
    private TextView ebc;
    private HeadImageView ebd;
    private HeadImageView ebe;
    private FrameLayout ebf;
    private FrameLayout ebg;
    private boolean ebk;
    private boolean ebl;
    private int ebm;
    private Runnable ebn;
    private final Handler mHandler;
    private TextView mTipView;

    static /* synthetic */ int a(f fVar) {
        int i = fVar.ebm;
        fVar.ebm = i + 1;
        return i;
    }

    public f(Context context, k kVar) {
        super(context, kVar);
        this.ebk = false;
        this.ebl = false;
        this.mHandler = new Handler();
        this.ebm = 0;
        this.ebn = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.a(f.this);
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.h.stringForLastTime(f.this.ebm)));
                f.this.mHandler.removeCallbacks(f.this.ebn);
                f.this.mHandler.postDelayed(f.this.ebn, 1000L);
            }
        };
        this.ebb = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.ebc = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.ebc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eaZ != null) {
                    if (f.this.ebl) {
                        f.this.eaZ.aQI();
                    } else {
                        f.this.eaZ.aQG();
                    }
                }
            }
        });
        this.ebd = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.ebd.setIsRound(true);
        this.ebf = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.ebe = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.ebe.setIsRound(true);
        this.ebg = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.eas = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.eat = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.ebk = false;
            if (aVar.nC()) {
                g(aVar);
                return;
            }
            this.ebl = true;
            aQM();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int aQB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void aax() {
        super.aax();
        this.ebm = 0;
        aQL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.eas != null) {
            this.eas.endAnimation();
        }
        if (this.eat != null) {
            this.eat.endAnimation();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eaZ == null) {
            return false;
        }
        if (this.ebk) {
            this.eaZ.aQG();
        } else {
            this.eaZ.removeView();
        }
        return true;
    }

    private void aQL() {
        this.ebk = true;
        this.ebb.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.ebc.setVisibility(0);
        this.ebc.setText(a.i.ala_challenge_panel_random_cancel);
        this.ebc.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.ebc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.mHandler.post(this.ebn);
        this.ebd.setDrawBorder(false);
        this.ebd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ebd.setAutoChangeStyle(false);
        this.ebd.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.ebd.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.ebg.setVisibility(8);
        this.eas.setWaveArray(ebh);
        this.eat.setWaveArray(ebi);
        this.eas.startAnimation();
        this.eat.startAnimation();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.ebb.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.ebc.setVisibility(4);
        this.mHandler.removeCallbacks(this.ebn);
        this.ebg.setVisibility(0);
        this.ebe.setDrawBorder(false);
        this.ebe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ebe.setAutoChangeStyle(false);
        this.ebe.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.ebe.startLoad(aVar.OA, 25, false);
        this.eas.setEndWaveArray(ebj);
        this.eat.setEndWaveArray(ebj);
        this.eas.endAnimation();
        this.eat.endAnimation();
    }

    private void aQM() {
        this.ebb.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.ebc.setVisibility(0);
        this.ebc.setText(a.i.ala_challenge_panel_random_retry);
        this.ebc.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.ebc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eas.setEndWaveArray(ebh);
        this.eat.setEndWaveArray(ebi);
        this.eas.endAnimation();
        this.eat.endAnimation();
        this.mHandler.removeCallbacks(this.ebn);
    }
}
