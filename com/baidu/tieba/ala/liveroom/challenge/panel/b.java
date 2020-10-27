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
    private Runnable gFb;
    private AlaChallengeWaveView gUX;
    private AlaChallengeWaveView gUY;
    private HeadImageView gUZ;
    private int gUt;
    private HeadImageView gVa;
    private com.baidu.live.challenge.d gVb;
    private TextView gVc;
    private TextView gVd;
    private TextView gVe;
    private View gVf;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.gUt;
        bVar.gUt = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.gUt = 1;
        this.gFb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.gVd.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.gUt)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.gVc) {
                    b.this.bXC();
                }
            }
        };
        this.gUX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gUY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.gWo, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWm};
        this.gUX.setWaveArray(fArr);
        this.gUX.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.gWm, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWo};
        this.gUY.setWaveArray(fArr2);
        this.gUY.setEndWaveArray(fArr2);
        this.gUZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.gUZ.setIsRound(true);
        this.gUZ.setAutoChangeStyle(false);
        this.gUZ.setDrawBorder(false);
        this.gUZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gUZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gUZ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gVa = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gVa.setIsRound(true);
        this.gVa.setAutoChangeStyle(false);
        this.gUZ.setDrawBorder(false);
        this.gUZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gUZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gVc = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.gVc.setOnClickListener(this.mClickListener);
        this.gVd = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.gVe = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.gVf = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gVb = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void OC() {
        super.OC();
        this.gVa.startLoad(this.gVb.avatar, 25, false);
        this.gUX.startAnimation();
        this.gUY.startAnimation();
        this.gVe.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.gVf.setVisibility(0);
        this.gVc.setVisibility(0);
        this.gVc.setText(a.i.ala_challenge_panel_random_cancel);
        this.gVc.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gVc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gUt = 1;
        this.mHandler.post(this.gFb);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bXC();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bXC() {
        if (this.gVK != null && this.gVb != null) {
            this.gVK.ez(this.gVb.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.CV()) {
                this.gVe.setText(a.i.ala_challenge_panel_random_succ_title);
                this.gVd.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.gVf.setVisibility(8);
                this.gVc.setVisibility(8);
            } else {
                bXD();
            }
            this.mHandler.removeCallbacks(this.gFb);
        }
    }

    private void bXD() {
        this.gVe.setText(a.i.ala_challenge_panel_invite_fail);
        this.gVd.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.gVc.setText(a.i.ala_challenge_panel_again_select);
        this.gVc.setBackgroundResource(a.f.sdk_red_border_bg);
        this.gVc.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.gUX.endAnimation();
        this.gUY.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.gUX != null) {
            this.gUX.endAnimation();
        }
        if (this.gUY != null) {
            this.gUY.endAnimation();
        }
        this.mHandler.removeCallbacks(this.gFb);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
