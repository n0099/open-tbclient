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
    private Runnable fCU;
    private AlaChallengeWaveView fOh;
    private AlaChallengeWaveView fOi;
    private HeadImageView fOj;
    private HeadImageView fOk;
    private com.baidu.live.challenge.d fOl;
    private TextView fOm;
    private TextView fOn;
    private TextView fOo;
    private View fOp;
    private int fOq;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.fOq;
        bVar.fOq = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.fOq = 1;
        this.fCU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.fOn.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.fOq)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.fOm) {
                    b.this.bAe();
                }
            }
        };
        this.fOh = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fOi = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.fPt, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPr};
        this.fOh.setWaveArray(fArr);
        this.fOh.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.fPr, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPt};
        this.fOi.setWaveArray(fArr2);
        this.fOi.setEndWaveArray(fArr2);
        this.fOj = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fOj.setIsRound(true);
        this.fOj.setAutoChangeStyle(false);
        this.fOj.setDrawBorder(false);
        this.fOj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOj.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOj.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fOk = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fOk.setIsRound(true);
        this.fOk.setAutoChangeStyle(false);
        this.fOj.setDrawBorder(false);
        this.fOj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOj.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOm = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.fOm.setOnClickListener(this.mClickListener);
        this.fOn = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.fOo = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.fOp = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.fOl = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void Dz() {
        super.Dz();
        this.fOk.startLoad(this.fOl.avatar, 25, false);
        this.fOh.startAnimation();
        this.fOi.startAnimation();
        this.fOo.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.fOp.setVisibility(0);
        this.fOm.setVisibility(0);
        this.fOm.setText(a.i.ala_challenge_panel_random_cancel);
        this.fOm.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fOm.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fOq = 1;
        this.mHandler.post(this.fCU);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        bAe();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bAe() {
        if (this.fON != null && this.fOl != null) {
            this.fON.dD(this.fOl.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.vo()) {
                this.fOo.setText(a.i.ala_challenge_panel_random_succ_title);
                this.fOn.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.fOp.setVisibility(8);
                this.fOm.setVisibility(8);
            } else {
                bAf();
            }
            this.mHandler.removeCallbacks(this.fCU);
        }
    }

    private void bAf() {
        this.fOo.setText(a.i.ala_challenge_panel_invite_fail);
        this.fOn.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.fOm.setText(a.i.ala_challenge_panel_again_select);
        this.fOm.setBackgroundResource(a.f.sdk_red_border_bg);
        this.fOm.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fOh.endAnimation();
        this.fOi.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fOh != null) {
            this.fOh.endAnimation();
        }
        if (this.fOi != null) {
            this.fOi.endAnimation();
        }
        this.mHandler.removeCallbacks(this.fCU);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bAd() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
