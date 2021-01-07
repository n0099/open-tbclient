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
/* loaded from: classes11.dex */
public class b extends g {
    private Runnable hfw;
    private int hvK;
    private AlaChallengeWaveView hwo;
    private AlaChallengeWaveView hwp;
    private HeadImageView hwq;
    private HeadImageView hwr;
    private com.baidu.live.challenge.d hws;
    private TextView hwt;
    private TextView hwu;
    private TextView hwv;
    private View hww;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hvK;
        bVar.hvK = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hvK = 1;
        this.hfw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hwu.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hvK)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hwt) {
                    b.this.cgk();
                }
            }
        };
        this.hwo = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hwp = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hxF, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxD};
        this.hwo.setWaveArray(fArr);
        this.hwo.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hxD, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxF};
        this.hwp.setWaveArray(fArr2);
        this.hwp.setEndWaveArray(fArr2);
        this.hwq = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hwq.setIsRound(true);
        this.hwq.setAutoChangeStyle(false);
        this.hwq.setDrawBorder(false);
        this.hwq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwq.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwq.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hwr = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hwr.setIsRound(true);
        this.hwr.setAutoChangeStyle(false);
        this.hwq.setDrawBorder(false);
        this.hwq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwq.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwt = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hwt.setOnClickListener(this.mClickListener);
        this.hwu = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hwv = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hww = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hws = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void onShow() {
        super.onShow();
        this.hwr.startLoad(this.hws.avatar, 25, false);
        this.hwo.startAnimation();
        this.hwp.startAnimation();
        this.hwv.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hww.setVisibility(0);
        this.hwt.setVisibility(0);
        this.hwt.setText(a.h.ala_challenge_panel_random_cancel);
        this.hwt.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hwt.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hvK = 1;
        this.mHandler.post(this.hfw);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        cgk();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void cgk() {
        if (this.hxb != null && this.hws != null) {
            this.hxb.fz(this.hws.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.DE()) {
                this.hwv.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hwu.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hww.setVisibility(8);
                this.hwt.setVisibility(8);
            } else {
                cgl();
            }
            this.mHandler.removeCallbacks(this.hfw);
        }
    }

    private void cgl() {
        this.hwv.setText(a.h.ala_challenge_panel_invite_fail);
        this.hwu.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hwt.setText(a.h.ala_challenge_panel_again_select);
        this.hwt.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hwt.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hwo.endAnimation();
        this.hwp.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hwo != null) {
            this.hwo.endAnimation();
        }
        if (this.hwp != null) {
            this.hwp.endAnimation();
        }
        this.mHandler.removeCallbacks(this.hfw);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cgj() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
