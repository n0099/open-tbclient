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
/* loaded from: classes10.dex */
public class b extends g {
    private Runnable hfx;
    private AlaChallengeWaveView hxP;
    private AlaChallengeWaveView hxQ;
    private HeadImageView hxR;
    private HeadImageView hxS;
    private com.baidu.live.challenge.d hxT;
    private TextView hxU;
    private TextView hxV;
    private TextView hxW;
    private View hxX;
    private int hxl;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hxl;
        bVar.hxl = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hxl = 1;
        this.hfx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hxV.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hxl)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hxU) {
                    b.this.cdA();
                }
            }
        };
        this.hxP = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hxQ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hzg, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hze};
        this.hxP.setWaveArray(fArr);
        this.hxP.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hze, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hzg};
        this.hxQ.setWaveArray(fArr2);
        this.hxQ.setEndWaveArray(fArr2);
        this.hxR = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hxR.setIsRound(true);
        this.hxR.setAutoChangeStyle(false);
        this.hxR.setDrawBorder(false);
        this.hxR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hxR.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hxR.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hxS = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hxS.setIsRound(true);
        this.hxS.setAutoChangeStyle(false);
        this.hxR.setDrawBorder(false);
        this.hxR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hxR.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hxU = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hxU.setOnClickListener(this.mClickListener);
        this.hxV = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hxW = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hxX = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hxT = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void onShow() {
        super.onShow();
        this.hxS.startLoad(this.hxT.avatar, 25, false);
        this.hxP.startAnimation();
        this.hxQ.startAnimation();
        this.hxW.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hxX.setVisibility(0);
        this.hxU.setVisibility(0);
        this.hxU.setText(a.h.ala_challenge_panel_random_cancel);
        this.hxU.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hxU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hxl = 1;
        this.mHandler.post(this.hfx);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        cdA();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void cdA() {
        if (this.hyC != null && this.hxT != null) {
            this.hyC.fE(this.hxT.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.Aw()) {
                this.hxW.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hxV.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hxX.setVisibility(8);
                this.hxU.setVisibility(8);
            } else {
                cdB();
            }
            this.mHandler.removeCallbacks(this.hfx);
        }
    }

    private void cdB() {
        this.hxW.setText(a.h.ala_challenge_panel_invite_fail);
        this.hxV.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hxU.setText(a.h.ala_challenge_panel_again_select);
        this.hxU.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hxU.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hxP.endAnimation();
        this.hxQ.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hxP != null) {
            this.hxP.endAnimation();
        }
        if (this.hxQ != null) {
            this.hxQ.endAnimation();
        }
        this.mHandler.removeCallbacks(this.hfx);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdz() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
