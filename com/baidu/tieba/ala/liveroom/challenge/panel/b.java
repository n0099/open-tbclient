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
    private Runnable eKz;
    private AlaChallengeWaveView eVA;
    private AlaChallengeWaveView eVB;
    private HeadImageView eVC;
    private HeadImageView eVD;
    private com.baidu.live.challenge.d eVE;
    private TextView eVF;
    private TextView eVG;
    private TextView eVH;
    private View eVI;
    private int eVJ;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.eVJ;
        bVar.eVJ = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.eVJ = 1;
        this.eKz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eVG.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.eVJ)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.eVF) {
                    b.this.bkM();
                }
            }
        };
        this.eVA = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eVB = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.eWM, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWK};
        this.eVA.setWaveArray(fArr);
        this.eVA.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.eWK, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWM};
        this.eVB.setWaveArray(fArr2);
        this.eVB.setEndWaveArray(fArr2);
        this.eVC = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eVC.setIsRound(true);
        this.eVC.setAutoChangeStyle(false);
        this.eVC.setDrawBorder(false);
        this.eVC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVC.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVC.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eVD = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eVD.setIsRound(true);
        this.eVD.setAutoChangeStyle(false);
        this.eVC.setDrawBorder(false);
        this.eVC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVC.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVF = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.eVF.setOnClickListener(this.mClickListener);
        this.eVG = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.eVH = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.eVI = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eVE = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void xr() {
        super.xr();
        this.eVD.startLoad(this.eVE.avatar, 25, false);
        this.eVA.startAnimation();
        this.eVB.startAnimation();
        this.eVH.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.eVI.setVisibility(0);
        this.eVF.setVisibility(0);
        this.eVF.setText(a.i.ala_challenge_panel_random_cancel);
        this.eVF.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eVF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eVJ = 1;
        this.mHandler.post(this.eKz);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        bkM();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bkM() {
        if (this.eWg != null && this.eVE != null) {
            this.eWg.cU(this.eVE.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.pR()) {
                this.eVH.setText(a.i.ala_challenge_panel_random_succ_title);
                this.eVG.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.eVI.setVisibility(8);
                this.eVF.setVisibility(8);
            } else {
                bkN();
            }
            this.mHandler.removeCallbacks(this.eKz);
        }
    }

    private void bkN() {
        this.eVH.setText(a.i.ala_challenge_panel_invite_fail);
        this.eVG.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.eVF.setText(a.i.ala_challenge_panel_again_select);
        this.eVF.setBackgroundResource(a.f.sdk_red_border_bg);
        this.eVF.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eVA.endAnimation();
        this.eVB.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eVA != null) {
            this.eVA.endAnimation();
        }
        if (this.eVB != null) {
            this.eVB.endAnimation();
        }
        this.mHandler.removeCallbacks(this.eKz);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkL() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
