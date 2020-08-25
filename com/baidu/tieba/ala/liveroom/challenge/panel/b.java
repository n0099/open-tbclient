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
    private Runnable gfv;
    private AlaChallengeWaveView grn;
    private AlaChallengeWaveView gro;
    private HeadImageView grp;
    private HeadImageView grq;
    private com.baidu.live.challenge.d grr;
    private TextView grs;
    private TextView grt;
    private TextView gru;
    private View grv;
    private int grw;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.grw;
        bVar.grw = i + 1;
        return i;
    }

    public b(Context context, m mVar) {
        super(context, mVar);
        this.mHandler = new Handler();
        this.grw = 1;
        this.gfv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.grt.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.grw)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.grs) {
                    b.this.bPQ();
                }
            }
        };
        this.grn = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gro = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.gsG, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsE};
        this.grn.setWaveArray(fArr);
        this.grn.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.gsE, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsG};
        this.gro.setWaveArray(fArr2);
        this.gro.setEndWaveArray(fArr2);
        this.grp = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.grp.setIsRound(true);
        this.grp.setAutoChangeStyle(false);
        this.grp.setDrawBorder(false);
        this.grp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grp.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.grp.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.grq = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.grq.setIsRound(true);
        this.grq.setAutoChangeStyle(false);
        this.grp.setDrawBorder(false);
        this.grp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grp.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.grs = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.grs.setOnClickListener(this.mClickListener);
        this.grt = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.gru = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.grv = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.grr = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Mr() {
        super.Mr();
        this.grq.startLoad(this.grr.avatar, 25, false);
        this.grn.startAnimation();
        this.gro.startAnimation();
        this.gru.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.grv.setVisibility(0);
        this.grs.setVisibility(0);
        this.grs.setText(a.i.ala_challenge_panel_random_cancel);
        this.grs.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.grs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.grw = 1;
        this.mHandler.post(this.gfv);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bPQ();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bPQ() {
        if (this.gsa != null && this.grr != null) {
            this.gsa.ef(this.grr.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.BD()) {
                this.gru.setText(a.i.ala_challenge_panel_random_succ_title);
                this.grt.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.grv.setVisibility(8);
                this.grs.setVisibility(8);
            } else {
                bPR();
            }
            this.mHandler.removeCallbacks(this.gfv);
        }
    }

    private void bPR() {
        this.gru.setText(a.i.ala_challenge_panel_invite_fail);
        this.grt.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.grs.setText(a.i.ala_challenge_panel_again_select);
        this.grs.setBackgroundResource(a.f.sdk_red_border_bg);
        this.grs.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.grn.endAnimation();
        this.gro.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.grn != null) {
            this.grn.endAnimation();
        }
        if (this.gro != null) {
            this.gro.endAnimation();
        }
        this.mHandler.removeCallbacks(this.gfv);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bPP() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
