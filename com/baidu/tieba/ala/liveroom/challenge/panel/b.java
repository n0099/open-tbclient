package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class b extends g {
    private Runnable gTH;
    private int hjN;
    private AlaChallengeWaveView hkr;
    private AlaChallengeWaveView hks;
    private HeadImageView hkt;
    private HeadImageView hku;
    private com.baidu.live.challenge.d hkv;
    private TextView hkw;
    private TextView hkx;
    private TextView hky;
    private View hkz;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hjN;
        bVar.hjN = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hjN = 1;
        this.gTH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hkx.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hjN)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hkw) {
                    b.this.cds();
                }
            }
        };
        this.hkr = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hks = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlG};
        this.hkr.setWaveArray(fArr);
        this.hkr.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hlG, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlI};
        this.hks.setWaveArray(fArr2);
        this.hks.setEndWaveArray(fArr2);
        this.hkt = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hkt.setIsRound(true);
        this.hkt.setAutoChangeStyle(false);
        this.hkt.setDrawBorder(false);
        this.hkt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkt.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hkt.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hku = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hku.setIsRound(true);
        this.hku.setAutoChangeStyle(false);
        this.hkt.setDrawBorder(false);
        this.hkt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkt.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hkw = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hkw.setOnClickListener(this.mClickListener);
        this.hkx = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hky = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hkz = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hkv = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void QM() {
        super.QM();
        this.hku.startLoad(this.hkv.avatar, 25, false);
        this.hkr.startAnimation();
        this.hks.startAnimation();
        this.hky.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hkz.setVisibility(0);
        this.hkw.setVisibility(0);
        this.hkw.setText(a.h.ala_challenge_panel_random_cancel);
        this.hkw.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hkw.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hjN = 1;
        this.mHandler.post(this.gTH);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        cds();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void cds() {
        if (this.hle != null && this.hkv != null) {
            this.hle.fz(this.hkv.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.Ep()) {
                this.hky.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hkx.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hkz.setVisibility(8);
                this.hkw.setVisibility(8);
            } else {
                cdt();
            }
            this.mHandler.removeCallbacks(this.gTH);
        }
    }

    private void cdt() {
        this.hky.setText(a.h.ala_challenge_panel_invite_fail);
        this.hkx.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hkw.setText(a.h.ala_challenge_panel_again_select);
        this.hkw.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hkw.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hkr.endAnimation();
        this.hks.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hkr != null) {
            this.hkr.endAnimation();
        }
        if (this.hks != null) {
            this.hks.endAnimation();
        }
        this.mHandler.removeCallbacks(this.gTH);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
