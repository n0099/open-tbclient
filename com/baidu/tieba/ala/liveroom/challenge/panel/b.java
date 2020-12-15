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
    private Runnable gTJ;
    private int hjP;
    private TextView hkA;
    private View hkB;
    private AlaChallengeWaveView hkt;
    private AlaChallengeWaveView hku;
    private HeadImageView hkv;
    private HeadImageView hkw;
    private com.baidu.live.challenge.d hkx;
    private TextView hky;
    private TextView hkz;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hjP;
        bVar.hjP = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hjP = 1;
        this.gTJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hkz.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hjP)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hky) {
                    b.this.cdt();
                }
            }
        };
        this.hkt = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hku = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hlK, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlI};
        this.hkt.setWaveArray(fArr);
        this.hkt.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlK};
        this.hku.setWaveArray(fArr2);
        this.hku.setEndWaveArray(fArr2);
        this.hkv = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hkv.setIsRound(true);
        this.hkv.setAutoChangeStyle(false);
        this.hkv.setDrawBorder(false);
        this.hkv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkv.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hkv.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hkw = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hkw.setIsRound(true);
        this.hkw.setAutoChangeStyle(false);
        this.hkv.setDrawBorder(false);
        this.hkv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkv.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hky = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hky.setOnClickListener(this.mClickListener);
        this.hkz = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hkA = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hkB = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hkx = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void QM() {
        super.QM();
        this.hkw.startLoad(this.hkx.avatar, 25, false);
        this.hkt.startAnimation();
        this.hku.startAnimation();
        this.hkA.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hkB.setVisibility(0);
        this.hky.setVisibility(0);
        this.hky.setText(a.h.ala_challenge_panel_random_cancel);
        this.hky.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hky.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hjP = 1;
        this.mHandler.post(this.gTJ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        cdt();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void cdt() {
        if (this.hlg != null && this.hkx != null) {
            this.hlg.fz(this.hkx.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.Ep()) {
                this.hkA.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hkz.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hkB.setVisibility(8);
                this.hky.setVisibility(8);
            } else {
                cdu();
            }
            this.mHandler.removeCallbacks(this.gTJ);
        }
    }

    private void cdu() {
        this.hkA.setText(a.h.ala_challenge_panel_invite_fail);
        this.hkz.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hky.setText(a.h.ala_challenge_panel_again_select);
        this.hky.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hky.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hkt.endAnimation();
        this.hku.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hkt != null) {
            this.hkt.endAnimation();
        }
        if (this.hku != null) {
            this.hku.endAnimation();
        }
        this.mHandler.removeCallbacks(this.gTJ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cds() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
