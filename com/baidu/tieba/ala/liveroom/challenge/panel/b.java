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
    private Runnable giK;
    private AlaChallengeWaveView guN;
    private AlaChallengeWaveView guO;
    private HeadImageView guP;
    private HeadImageView guQ;
    private com.baidu.live.challenge.d guR;
    private TextView guS;
    private TextView guT;
    private TextView guU;
    private View guV;
    private int guj;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.guj;
        bVar.guj = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.guj = 1;
        this.giK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.guT.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.guj)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.guS) {
                    b.this.bRj();
                }
            }
        };
        this.guN = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.guO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.gwg, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwe};
        this.guN.setWaveArray(fArr);
        this.guN.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.gwe, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwg};
        this.guO.setWaveArray(fArr2);
        this.guO.setEndWaveArray(fArr2);
        this.guP = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.guP.setIsRound(true);
        this.guP.setAutoChangeStyle(false);
        this.guP.setDrawBorder(false);
        this.guP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guP.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.guP.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.guQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.guQ.setIsRound(true);
        this.guQ.setAutoChangeStyle(false);
        this.guP.setDrawBorder(false);
        this.guP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guP.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.guS = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.guS.setOnClickListener(this.mClickListener);
        this.guT = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.guU = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.guV = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.guR = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void MZ() {
        super.MZ();
        this.guQ.startLoad(this.guR.avatar, 25, false);
        this.guN.startAnimation();
        this.guO.startAnimation();
        this.guU.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.guV.setVisibility(0);
        this.guS.setVisibility(0);
        this.guS.setText(a.i.ala_challenge_panel_random_cancel);
        this.guS.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.guS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.guj = 1;
        this.mHandler.post(this.giK);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bRj();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bRj() {
        if (this.gvA != null && this.guR != null) {
            this.gvA.eh(this.guR.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.BS()) {
                this.guU.setText(a.i.ala_challenge_panel_random_succ_title);
                this.guT.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.guV.setVisibility(8);
                this.guS.setVisibility(8);
            } else {
                bRk();
            }
            this.mHandler.removeCallbacks(this.giK);
        }
    }

    private void bRk() {
        this.guU.setText(a.i.ala_challenge_panel_invite_fail);
        this.guT.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.guS.setText(a.i.ala_challenge_panel_again_select);
        this.guS.setBackgroundResource(a.f.sdk_red_border_bg);
        this.guS.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.guN.endAnimation();
        this.guO.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.guN != null) {
            this.guN.endAnimation();
        }
        if (this.guO != null) {
            this.guO.endAnimation();
        }
        this.mHandler.removeCallbacks(this.giK);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bRi() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
