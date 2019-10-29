package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class b extends e {
    private View eaA;
    private int eaB;
    private Runnable eaC;
    private AlaChallengeWaveView eas;
    private AlaChallengeWaveView eat;
    private HeadImageView eau;
    private HeadImageView eav;
    private com.baidu.live.challenge.d eaw;
    private TextView eax;
    private TextView eay;
    private TextView eaz;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.eaB;
        bVar.eaB = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.eaB = 1;
        this.eaC = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eay.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.h.stringForLastTime(b.this.eaB)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.eax && b.this.eaw != null) {
                    b.this.eaZ.ci(b.this.eaw.userId);
                }
            }
        };
        this.eas = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eat = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.ebC, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebA};
        this.eas.setWaveArray(fArr);
        this.eas.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.ebA, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebC};
        this.eat.setWaveArray(fArr2);
        this.eat.setEndWaveArray(fArr2);
        this.eau = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eau.setIsRound(true);
        this.eau.setAutoChangeStyle(false);
        this.eau.setDrawBorder(false);
        this.eau.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eau.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eau.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eav = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eav.setIsRound(true);
        this.eav.setAutoChangeStyle(false);
        this.eau.setDrawBorder(false);
        this.eau.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eau.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eax = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.eax.setOnClickListener(this.mClickListener);
        this.eay = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.eaz = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.eaA = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eaw = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void aax() {
        super.aax();
        this.eav.startLoad(this.eaw.avatar, 25, false);
        this.eas.startAnimation();
        this.eat.startAnimation();
        this.eaz.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.eaA.setVisibility(0);
        this.eax.setVisibility(0);
        this.eax.setText(a.i.ala_challenge_panel_random_cancel);
        this.eax.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eax.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eaB = 1;
        this.mHandler.post(this.eaC);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        if (this.eaw != null) {
            this.eaZ.ci(this.eaw.userId);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.nC()) {
                this.eaz.setText(a.i.ala_challenge_panel_random_succ_title);
                this.eay.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.eaA.setVisibility(8);
                this.eax.setVisibility(8);
            } else {
                aQC();
            }
            this.mHandler.removeCallbacks(this.eaC);
        }
    }

    private void aQC() {
        this.eaz.setText(a.i.ala_challenge_panel_invite_fail);
        this.eay.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.eax.setText(a.i.ala_challenge_panel_again_select);
        this.eax.setBackgroundResource(a.f.sdk_red_border_bg);
        this.eax.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eas.endAnimation();
        this.eat.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eas != null) {
            this.eas.endAnimation();
        }
        if (this.eat != null) {
            this.eat.endAnimation();
        }
        this.mHandler.removeCallbacks(this.eaC);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int aQB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
