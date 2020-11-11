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
    private Runnable gKO;
    private int hax;
    private AlaChallengeWaveView hbb;
    private AlaChallengeWaveView hbc;
    private HeadImageView hbd;
    private HeadImageView hbe;
    private com.baidu.live.challenge.d hbf;
    private TextView hbg;
    private TextView hbh;
    private TextView hbi;
    private View hbj;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hax;
        bVar.hax = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hax = 1;
        this.gKO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hbh.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hax)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hbg) {
                    b.this.cae();
                }
            }
        };
        this.hbb = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hbc = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hcs, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcq};
        this.hbb.setWaveArray(fArr);
        this.hbb.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hcq, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcs};
        this.hbc.setWaveArray(fArr2);
        this.hbc.setEndWaveArray(fArr2);
        this.hbd = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hbd.setIsRound(true);
        this.hbd.setAutoChangeStyle(false);
        this.hbd.setDrawBorder(false);
        this.hbd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbd.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hbd.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hbe = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hbe.setIsRound(true);
        this.hbe.setAutoChangeStyle(false);
        this.hbd.setDrawBorder(false);
        this.hbd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbd.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hbg = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hbg.setOnClickListener(this.mClickListener);
        this.hbh = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hbi = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hbj = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hbf = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Pc() {
        super.Pc();
        this.hbe.startLoad(this.hbf.avatar, 25, false);
        this.hbb.startAnimation();
        this.hbc.startAnimation();
        this.hbi.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hbj.setVisibility(0);
        this.hbg.setVisibility(0);
        this.hbg.setText(a.h.ala_challenge_panel_random_cancel);
        this.hbg.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hbg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hax = 1;
        this.mHandler.post(this.gKO);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        cae();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void cae() {
        if (this.hbO != null && this.hbf != null) {
            this.hbO.eV(this.hbf.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.Do()) {
                this.hbi.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hbh.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hbj.setVisibility(8);
                this.hbg.setVisibility(8);
            } else {
                caf();
            }
            this.mHandler.removeCallbacks(this.gKO);
        }
    }

    private void caf() {
        this.hbi.setText(a.h.ala_challenge_panel_invite_fail);
        this.hbh.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hbg.setText(a.h.ala_challenge_panel_again_select);
        this.hbg.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hbg.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hbb.endAnimation();
        this.hbc.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hbb != null) {
            this.hbb.endAnimation();
        }
        if (this.hbc != null) {
            this.hbc.endAnimation();
        }
        this.mHandler.removeCallbacks(this.gKO);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cad() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
