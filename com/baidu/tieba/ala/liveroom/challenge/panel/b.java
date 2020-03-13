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
    private Runnable eKd;
    private AlaChallengeWaveView eVc;
    private AlaChallengeWaveView eVd;
    private HeadImageView eVe;
    private HeadImageView eVf;
    private com.baidu.live.challenge.d eVg;
    private TextView eVh;
    private TextView eVi;
    private TextView eVj;
    private View eVk;
    private int eVl;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.eVl;
        bVar.eVl = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.eVl = 1;
        this.eKd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eVi.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.eVl)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.eVh) {
                    b.this.bkH();
                }
            }
        };
        this.eVc = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eVd = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.eWo, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWm};
        this.eVc.setWaveArray(fArr);
        this.eVc.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.eWm, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWo};
        this.eVd.setWaveArray(fArr2);
        this.eVd.setEndWaveArray(fArr2);
        this.eVe = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eVe.setIsRound(true);
        this.eVe.setAutoChangeStyle(false);
        this.eVe.setDrawBorder(false);
        this.eVe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVe.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVe.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eVf = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eVf.setIsRound(true);
        this.eVf.setAutoChangeStyle(false);
        this.eVe.setDrawBorder(false);
        this.eVe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVe.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVh = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.eVh.setOnClickListener(this.mClickListener);
        this.eVi = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.eVj = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.eVk = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eVg = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void xm() {
        super.xm();
        this.eVf.startLoad(this.eVg.avatar, 25, false);
        this.eVc.startAnimation();
        this.eVd.startAnimation();
        this.eVj.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.eVk.setVisibility(0);
        this.eVh.setVisibility(0);
        this.eVh.setText(a.i.ala_challenge_panel_random_cancel);
        this.eVh.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eVh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eVl = 1;
        this.mHandler.post(this.eKd);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        bkH();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bkH() {
        if (this.eVI != null && this.eVg != null) {
            this.eVI.cU(this.eVg.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.pM()) {
                this.eVj.setText(a.i.ala_challenge_panel_random_succ_title);
                this.eVi.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.eVk.setVisibility(8);
                this.eVh.setVisibility(8);
            } else {
                bkI();
            }
            this.mHandler.removeCallbacks(this.eKd);
        }
    }

    private void bkI() {
        this.eVj.setText(a.i.ala_challenge_panel_invite_fail);
        this.eVi.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.eVh.setText(a.i.ala_challenge_panel_again_select);
        this.eVh.setBackgroundResource(a.f.sdk_red_border_bg);
        this.eVh.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eVc.endAnimation();
        this.eVd.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eVc != null) {
            this.eVc.endAnimation();
        }
        if (this.eVd != null) {
            this.eVd.endAnimation();
        }
        this.mHandler.removeCallbacks(this.eKd);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkG() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
