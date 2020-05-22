package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends e {
    private Runnable fCJ;
    private AlaChallengeWaveView fNW;
    private AlaChallengeWaveView fNX;
    private HeadImageView fNY;
    private HeadImageView fNZ;
    private com.baidu.live.challenge.d fOa;
    private TextView fOb;
    private TextView fOc;
    private TextView fOd;
    private View fOe;
    private int fOf;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.fOf;
        bVar.fOf = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.fOf = 1;
        this.fCJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.fOc.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.fOf)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.fOb) {
                    b.this.bAc();
                }
            }
        };
        this.fNW = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fNX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.fPi, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPg};
        this.fNW.setWaveArray(fArr);
        this.fNW.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.fPg, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPi};
        this.fNX.setWaveArray(fArr2);
        this.fNX.setEndWaveArray(fArr2);
        this.fNY = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fNY.setIsRound(true);
        this.fNY.setAutoChangeStyle(false);
        this.fNY.setDrawBorder(false);
        this.fNY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fNY.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fNY.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fNZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fNZ.setIsRound(true);
        this.fNZ.setAutoChangeStyle(false);
        this.fNY.setDrawBorder(false);
        this.fNY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fNY.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOb = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.fOb.setOnClickListener(this.mClickListener);
        this.fOc = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.fOd = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.fOe = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.fOa = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void Dz() {
        super.Dz();
        this.fNZ.startLoad(this.fOa.avatar, 25, false);
        this.fNW.startAnimation();
        this.fNX.startAnimation();
        this.fOd.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.fOe.setVisibility(0);
        this.fOb.setVisibility(0);
        this.fOb.setText(a.i.ala_challenge_panel_random_cancel);
        this.fOb.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fOb.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fOf = 1;
        this.mHandler.post(this.fCJ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        bAc();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bAc() {
        if (this.fOC != null && this.fOa != null) {
            this.fOC.dD(this.fOa.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.vo()) {
                this.fOd.setText(a.i.ala_challenge_panel_random_succ_title);
                this.fOc.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.fOe.setVisibility(8);
                this.fOb.setVisibility(8);
            } else {
                bAd();
            }
            this.mHandler.removeCallbacks(this.fCJ);
        }
    }

    private void bAd() {
        this.fOd.setText(a.i.ala_challenge_panel_invite_fail);
        this.fOc.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.fOb.setText(a.i.ala_challenge_panel_again_select);
        this.fOb.setBackgroundResource(a.f.sdk_red_border_bg);
        this.fOb.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fNW.endAnimation();
        this.fNX.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fNW != null) {
            this.fNW.endAnimation();
        }
        if (this.fNX != null) {
            this.fNX.endAnimation();
        }
        this.mHandler.removeCallbacks(this.fCJ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bAb() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
