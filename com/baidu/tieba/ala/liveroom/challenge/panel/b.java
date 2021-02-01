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
    private Runnable hdA;
    private AlaChallengeWaveView hvS;
    private AlaChallengeWaveView hvT;
    private HeadImageView hvU;
    private HeadImageView hvV;
    private com.baidu.live.challenge.d hvW;
    private TextView hvX;
    private TextView hvY;
    private TextView hvZ;
    private int hvo;
    private View hwa;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hvo;
        bVar.hvo = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hvo = 1;
        this.hdA = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hvY.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hvo)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hvX) {
                    b.this.cdn();
                }
            }
        };
        this.hvS = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hvT = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hxj, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxh};
        this.hvS.setWaveArray(fArr);
        this.hvS.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hxh, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxj};
        this.hvT.setWaveArray(fArr2);
        this.hvT.setEndWaveArray(fArr2);
        this.hvU = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hvU.setIsRound(true);
        this.hvU.setAutoChangeStyle(false);
        this.hvU.setDrawBorder(false);
        this.hvU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hvU.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hvU.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hvV = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hvV.setIsRound(true);
        this.hvV.setAutoChangeStyle(false);
        this.hvU.setDrawBorder(false);
        this.hvU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hvU.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hvX = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hvX.setOnClickListener(this.mClickListener);
        this.hvY = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hvZ = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hwa = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hvW = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void onShow() {
        super.onShow();
        this.hvV.startLoad(this.hvW.avatar, 25, false);
        this.hvS.startAnimation();
        this.hvT.startAnimation();
        this.hvZ.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hwa.setVisibility(0);
        this.hvX.setVisibility(0);
        this.hvX.setText(a.h.ala_challenge_panel_random_cancel);
        this.hvX.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hvX.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hvo = 1;
        this.mHandler.post(this.hdA);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        cdn();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void cdn() {
        if (this.hwF != null && this.hvW != null) {
            this.hwF.fE(this.hvW.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.At()) {
                this.hvZ.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hvY.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hwa.setVisibility(8);
                this.hvX.setVisibility(8);
            } else {
                cdo();
            }
            this.mHandler.removeCallbacks(this.hdA);
        }
    }

    private void cdo() {
        this.hvZ.setText(a.h.ala_challenge_panel_invite_fail);
        this.hvY.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hvX.setText(a.h.ala_challenge_panel_again_select);
        this.hvX.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hvX.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hvS.endAnimation();
        this.hvT.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hvS != null) {
            this.hvS.endAnimation();
        }
        if (this.hvT != null) {
            this.hvT.endAnimation();
        }
        this.mHandler.removeCallbacks(this.hdA);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdm() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
