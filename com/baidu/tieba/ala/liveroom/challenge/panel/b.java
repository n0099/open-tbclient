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
    private Runnable fTw;
    private AlaChallengeWaveView gff;
    private AlaChallengeWaveView gfg;
    private HeadImageView gfh;
    private HeadImageView gfi;
    private com.baidu.live.challenge.d gfj;
    private TextView gfk;
    private TextView gfl;
    private TextView gfm;
    private View gfn;
    private int gfo;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.gfo;
        bVar.gfo = i + 1;
        return i;
    }

    public b(Context context, m mVar) {
        super(context, mVar);
        this.mHandler = new Handler();
        this.gfo = 1;
        this.fTw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.gfl.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.gfo)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.gfk) {
                    b.this.bGl();
                }
            }
        };
        this.gff = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gfg = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.ggx, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggv};
        this.gff.setWaveArray(fArr);
        this.gff.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.ggv, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggx};
        this.gfg.setWaveArray(fArr2);
        this.gfg.setEndWaveArray(fArr2);
        this.gfh = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.gfh.setIsRound(true);
        this.gfh.setAutoChangeStyle(false);
        this.gfh.setDrawBorder(false);
        this.gfh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfh.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gfh.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gfi = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gfi.setIsRound(true);
        this.gfi.setAutoChangeStyle(false);
        this.gfh.setDrawBorder(false);
        this.gfh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfh.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gfk = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.gfk.setOnClickListener(this.mClickListener);
        this.gfl = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.gfm = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.gfn = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gfj = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void GF() {
        super.GF();
        this.gfi.startLoad(this.gfj.avatar, 25, false);
        this.gff.startAnimation();
        this.gfg.startAnimation();
        this.gfm.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.gfn.setVisibility(0);
        this.gfk.setVisibility(0);
        this.gfk.setText(a.i.ala_challenge_panel_random_cancel);
        this.gfk.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gfk.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gfo = 1;
        this.mHandler.post(this.fTw);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bGl();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bGl() {
        if (this.gfS != null && this.gfj != null) {
            this.gfS.dU(this.gfj.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.wf()) {
                this.gfm.setText(a.i.ala_challenge_panel_random_succ_title);
                this.gfl.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.gfn.setVisibility(8);
                this.gfk.setVisibility(8);
            } else {
                bGm();
            }
            this.mHandler.removeCallbacks(this.fTw);
        }
    }

    private void bGm() {
        this.gfm.setText(a.i.ala_challenge_panel_invite_fail);
        this.gfl.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.gfk.setText(a.i.ala_challenge_panel_again_select);
        this.gfk.setBackgroundResource(a.f.sdk_red_border_bg);
        this.gfk.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.gff.endAnimation();
        this.gfg.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.gff != null) {
            this.gff.endAnimation();
        }
        if (this.gfg != null) {
            this.gfg.endAnimation();
        }
        this.mHandler.removeCallbacks(this.fTw);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bGk() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
