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
/* loaded from: classes3.dex */
public class b extends g {
    private Runnable fOd;
    private AlaChallengeWaveView fZX;
    private AlaChallengeWaveView fZY;
    private HeadImageView fZZ;
    private HeadImageView gaa;
    private com.baidu.live.challenge.d gab;
    private TextView gac;
    private TextView gad;
    private TextView gae;
    private View gaf;
    private int gag;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.gag;
        bVar.gag = i + 1;
        return i;
    }

    public b(Context context, m mVar) {
        super(context, mVar);
        this.mHandler = new Handler();
        this.gag = 1;
        this.fOd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.gad.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.gag)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.gac) {
                    b.this.bDa();
                }
            }
        };
        this.fZX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fZY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.gbp, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbn};
        this.fZX.setWaveArray(fArr);
        this.fZX.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.gbn, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbp};
        this.fZY.setWaveArray(fArr2);
        this.fZY.setEndWaveArray(fArr2);
        this.fZZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fZZ.setIsRound(true);
        this.fZZ.setAutoChangeStyle(false);
        this.fZZ.setDrawBorder(false);
        this.fZZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fZZ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gaa = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gaa.setIsRound(true);
        this.gaa.setAutoChangeStyle(false);
        this.fZZ.setDrawBorder(false);
        this.fZZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gac = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.gac.setOnClickListener(this.mClickListener);
        this.gad = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.gae = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.gaf = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gab = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Eb() {
        super.Eb();
        this.gaa.startLoad(this.gab.avatar, 25, false);
        this.fZX.startAnimation();
        this.fZY.startAnimation();
        this.gae.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.gaf.setVisibility(0);
        this.gac.setVisibility(0);
        this.gac.setText(a.i.ala_challenge_panel_random_cancel);
        this.gac.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gac.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gag = 1;
        this.mHandler.post(this.fOd);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bDa();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bDa() {
        if (this.gaK != null && this.gab != null) {
            this.gaK.dG(this.gab.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.vJ()) {
                this.gae.setText(a.i.ala_challenge_panel_random_succ_title);
                this.gad.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.gaf.setVisibility(8);
                this.gac.setVisibility(8);
            } else {
                bDb();
            }
            this.mHandler.removeCallbacks(this.fOd);
        }
    }

    private void bDb() {
        this.gae.setText(a.i.ala_challenge_panel_invite_fail);
        this.gad.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.gac.setText(a.i.ala_challenge_panel_again_select);
        this.gac.setBackgroundResource(a.f.sdk_red_border_bg);
        this.gac.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fZX.endAnimation();
        this.fZY.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.fZX != null) {
            this.fZX.endAnimation();
        }
        if (this.fZY != null) {
            this.fZY.endAnimation();
        }
        this.mHandler.removeCallbacks(this.fOd);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bCZ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
