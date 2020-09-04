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
/* loaded from: classes7.dex */
public class b extends g {
    private Runnable gfz;
    private int grA;
    private AlaChallengeWaveView grr;
    private AlaChallengeWaveView grs;
    private HeadImageView grt;
    private HeadImageView gru;
    private com.baidu.live.challenge.d grv;
    private TextView grw;
    private TextView grx;
    private TextView gry;
    private View grz;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.grA;
        bVar.grA = i + 1;
        return i;
    }

    public b(Context context, m mVar) {
        super(context, mVar);
        this.mHandler = new Handler();
        this.grA = 1;
        this.gfz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.grx.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.grA)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.grw) {
                    b.this.bPR();
                }
            }
        };
        this.grr = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.grs = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.gsK, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsI};
        this.grr.setWaveArray(fArr);
        this.grr.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.gsI, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsK};
        this.grs.setWaveArray(fArr2);
        this.grs.setEndWaveArray(fArr2);
        this.grt = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.grt.setIsRound(true);
        this.grt.setAutoChangeStyle(false);
        this.grt.setDrawBorder(false);
        this.grt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grt.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.grt.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gru = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gru.setIsRound(true);
        this.gru.setAutoChangeStyle(false);
        this.grt.setDrawBorder(false);
        this.grt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grt.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.grw = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.grw.setOnClickListener(this.mClickListener);
        this.grx = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.gry = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.grz = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.grv = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Mr() {
        super.Mr();
        this.gru.startLoad(this.grv.avatar, 25, false);
        this.grr.startAnimation();
        this.grs.startAnimation();
        this.gry.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.grz.setVisibility(0);
        this.grw.setVisibility(0);
        this.grw.setText(a.i.ala_challenge_panel_random_cancel);
        this.grw.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.grw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.grA = 1;
        this.mHandler.post(this.gfz);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bPR();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bPR() {
        if (this.gse != null && this.grv != null) {
            this.gse.ef(this.grv.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.BD()) {
                this.gry.setText(a.i.ala_challenge_panel_random_succ_title);
                this.grx.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.grz.setVisibility(8);
                this.grw.setVisibility(8);
            } else {
                bPS();
            }
            this.mHandler.removeCallbacks(this.gfz);
        }
    }

    private void bPS() {
        this.gry.setText(a.i.ala_challenge_panel_invite_fail);
        this.grx.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.grw.setText(a.i.ala_challenge_panel_again_select);
        this.grw.setBackgroundResource(a.f.sdk_red_border_bg);
        this.grw.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.grr.endAnimation();
        this.grs.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.grr != null) {
            this.grr.endAnimation();
        }
        if (this.grs != null) {
            this.grs.endAnimation();
        }
        this.mHandler.removeCallbacks(this.gfz);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bPQ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
