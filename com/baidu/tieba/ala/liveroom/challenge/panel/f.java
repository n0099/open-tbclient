package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class f extends e {
    private static final float[] eQm = {AlaChallengeWaveView.eQG, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQE, AlaChallengeWaveView.eQG, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQE};
    private static final float[] eQn = {AlaChallengeWaveView.eQE, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQG, AlaChallengeWaveView.eQE, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQG};
    private static final float[] eQo = {AlaChallengeWaveView.eQE, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQG, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQE};
    private AlaChallengeWaveView ePy;
    private AlaChallengeWaveView ePz;
    private TextView eQg;
    private TextView eQh;
    private HeadImageView eQi;
    private HeadImageView eQj;
    private FrameLayout eQk;
    private FrameLayout eQl;
    private boolean eQp;
    private boolean eQq;
    private int eQr;
    private Runnable eQs;
    private final Handler mHandler;
    private TextView mTipView;

    static /* synthetic */ int a(f fVar) {
        int i = fVar.eQr;
        fVar.eQr = i + 1;
        return i;
    }

    public f(Context context, k kVar) {
        super(context, kVar);
        this.eQp = false;
        this.eQq = false;
        this.mHandler = new Handler();
        this.eQr = 0;
        this.eQs = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.1
            @Override // java.lang.Runnable
            public void run() {
                f.a(f.this);
                f.this.mTipView.setText(String.format(f.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip), com.baidu.live.utils.i.stringForLastTime(f.this.eQr)));
                f.this.mHandler.removeCallbacks(f.this.eQs);
                f.this.mHandler.postDelayed(f.this.eQs, 1000L);
            }
        };
        this.eQg = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_status);
        this.mTipView = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_tip);
        this.eQh = (TextView) this.mRootView.findViewById(a.g.ala_challenge_panel_random_ops);
        this.eQh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.eQe != null) {
                    if (f.this.eQq) {
                        f.this.eQe.bik();
                    } else {
                        f.this.eQe.bii();
                    }
                }
            }
        });
        this.eQi = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_my_header);
        this.eQi.setIsRound(true);
        this.eQk = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_my_header_layout);
        this.eQj = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header);
        this.eQj.setIsRound(true);
        this.eQl = (FrameLayout) this.mRootView.findViewById(a.g.ala_challenge_random_opponent_header_layout);
        this.ePy = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_left);
        this.ePz = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_random_wave_right);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_random_match_layout, (ViewGroup) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eQp = false;
            if (aVar.oU()) {
                g(aVar);
                return;
            }
            this.eQq = true;
            bio();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public int bic() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void bid() {
        super.bid();
        this.eQr = 0;
        bin();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public void hide() {
        super.hide();
        if (this.ePy != null) {
            this.ePy.endAnimation();
        }
        if (this.ePz != null) {
            this.ePz.endAnimation();
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    public boolean onBackKeyDown() {
        if (this.eQe == null) {
            return false;
        }
        if (this.eQp) {
            this.eQe.bii();
        } else {
            this.eQe.removeView();
        }
        return true;
    }

    private void bin() {
        this.eQp = true;
        this.eQg.setText(a.i.ala_challenge_panel_random_wait_title);
        this.mTipView.setText("");
        this.eQh.setVisibility(0);
        this.eQh.setText(a.i.ala_challenge_panel_random_cancel);
        this.eQh.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eQh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.mHandler.post(this.eQs);
        this.eQi.setDrawBorder(false);
        this.eQi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eQi.setAutoChangeStyle(false);
        this.eQi.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eQi.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eQl.setVisibility(8);
        this.ePy.setWaveArray(eQm);
        this.ePz.setWaveArray(eQn);
        this.ePy.startAnimation();
        this.ePz.startAnimation();
    }

    private void g(com.baidu.live.challenge.a aVar) {
        this.eQg.setText(a.i.ala_challenge_panel_random_succ_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_succ_tip);
        this.eQh.setVisibility(4);
        this.mHandler.removeCallbacks(this.eQs);
        this.eQl.setVisibility(0);
        this.eQj.setDrawBorder(false);
        this.eQj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eQj.setAutoChangeStyle(false);
        this.eQj.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eQj.startLoad(aVar.UX, 25, false);
        this.ePy.setEndWaveArray(eQo);
        this.ePz.setEndWaveArray(eQo);
        this.ePy.endAnimation();
        this.ePz.endAnimation();
    }

    private void bio() {
        this.eQg.setText(a.i.ala_challenge_panel_random_fail_title);
        this.mTipView.setText(a.i.ala_challenge_panel_random_fail_tip);
        this.eQh.setVisibility(0);
        this.eQh.setText(a.i.ala_challenge_panel_random_retry);
        this.eQh.setBackgroundResource(a.f.ala_challenge_panel_random_ops_retry_bg_shape);
        this.eQh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.ePy.setEndWaveArray(eQm);
        this.ePz.setEndWaveArray(eQn);
        this.ePy.endAnimation();
        this.ePz.endAnimation();
        this.mHandler.removeCallbacks(this.eQs);
    }
}
