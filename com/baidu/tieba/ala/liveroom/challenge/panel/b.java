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
    private Runnable haQ;
    private AlaChallengeWaveView hrI;
    private AlaChallengeWaveView hrJ;
    private HeadImageView hrK;
    private HeadImageView hrL;
    private com.baidu.live.challenge.d hrM;
    private TextView hrN;
    private TextView hrO;
    private TextView hrP;
    private View hrQ;
    private int hre;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hre;
        bVar.hre = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hre = 1;
        this.haQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hrO.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hre)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hrN) {
                    b.this.ccs();
                }
            }
        };
        this.hrI = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hrJ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hsZ, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsX};
        this.hrI.setWaveArray(fArr);
        this.hrI.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hsX, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsZ};
        this.hrJ.setWaveArray(fArr2);
        this.hrJ.setEndWaveArray(fArr2);
        this.hrK = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hrK.setIsRound(true);
        this.hrK.setAutoChangeStyle(false);
        this.hrK.setDrawBorder(false);
        this.hrK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hrK.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hrK.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hrL = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hrL.setIsRound(true);
        this.hrL.setAutoChangeStyle(false);
        this.hrK.setDrawBorder(false);
        this.hrK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hrK.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hrN = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hrN.setOnClickListener(this.mClickListener);
        this.hrO = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hrP = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hrQ = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hrM = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void onShow() {
        super.onShow();
        this.hrL.startLoad(this.hrM.avatar, 25, false);
        this.hrI.startAnimation();
        this.hrJ.startAnimation();
        this.hrP.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hrQ.setVisibility(0);
        this.hrN.setVisibility(0);
        this.hrN.setText(a.h.ala_challenge_panel_random_cancel);
        this.hrN.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hrN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hre = 1;
        this.mHandler.post(this.haQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        ccs();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void ccs() {
        if (this.hsv != null && this.hrM != null) {
            this.hsv.fz(this.hrM.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.zJ()) {
                this.hrP.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hrO.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hrQ.setVisibility(8);
                this.hrN.setVisibility(8);
            } else {
                cct();
            }
            this.mHandler.removeCallbacks(this.haQ);
        }
    }

    private void cct() {
        this.hrP.setText(a.h.ala_challenge_panel_invite_fail);
        this.hrO.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hrN.setText(a.h.ala_challenge_panel_again_select);
        this.hrN.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hrN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hrI.endAnimation();
        this.hrJ.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hrI != null) {
            this.hrI.endAnimation();
        }
        if (this.hrJ != null) {
            this.hrJ.endAnimation();
        }
        this.mHandler.removeCallbacks(this.haQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int ccr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
