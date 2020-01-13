package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class b extends e {
    private Runnable eFV;
    private AlaChallengeWaveView eQX;
    private AlaChallengeWaveView eQY;
    private HeadImageView eQZ;
    private HeadImageView eRa;
    private com.baidu.live.challenge.d eRb;
    private TextView eRc;
    private TextView eRd;
    private TextView eRe;
    private View eRf;
    private int eRg;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.eRg;
        bVar.eRg = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.eRg = 1;
        this.eFV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eRd.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.eRg)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.eRc) {
                    b.this.biP();
                }
            }
        };
        this.eQX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eQY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.eSj, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSh};
        this.eQX.setWaveArray(fArr);
        this.eQX.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.eSh, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSj};
        this.eQY.setWaveArray(fArr2);
        this.eQY.setEndWaveArray(fArr2);
        this.eQZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eQZ.setIsRound(true);
        this.eQZ.setAutoChangeStyle(false);
        this.eQZ.setDrawBorder(false);
        this.eQZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eQZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eQZ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eRa = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eRa.setIsRound(true);
        this.eRa.setAutoChangeStyle(false);
        this.eQZ.setDrawBorder(false);
        this.eQZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eQZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eRc = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.eRc.setOnClickListener(this.mClickListener);
        this.eRd = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.eRe = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.eRf = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eRb = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void biO() {
        super.biO();
        this.eRa.startLoad(this.eRb.avatar, 25, false);
        this.eQX.startAnimation();
        this.eQY.startAnimation();
        this.eRe.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.eRf.setVisibility(0);
        this.eRc.setVisibility(0);
        this.eRc.setText(a.i.ala_challenge_panel_random_cancel);
        this.eRc.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eRc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eRg = 1;
        this.mHandler.post(this.eFV);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        biP();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void biP() {
        if (this.eRD != null && this.eRb != null) {
            this.eRD.cS(this.eRb.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.pb()) {
                this.eRe.setText(a.i.ala_challenge_panel_random_succ_title);
                this.eRd.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.eRf.setVisibility(8);
                this.eRc.setVisibility(8);
            } else {
                biQ();
            }
            this.mHandler.removeCallbacks(this.eFV);
        }
    }

    private void biQ() {
        this.eRe.setText(a.i.ala_challenge_panel_invite_fail);
        this.eRd.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.eRc.setText(a.i.ala_challenge_panel_again_select);
        this.eRc.setBackgroundResource(a.f.sdk_red_border_bg);
        this.eRc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eQX.endAnimation();
        this.eQY.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eQX != null) {
            this.eQX.endAnimation();
        }
        if (this.eQY != null) {
            this.eQY.endAnimation();
        }
        this.mHandler.removeCallbacks(this.eFV);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int biN() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
