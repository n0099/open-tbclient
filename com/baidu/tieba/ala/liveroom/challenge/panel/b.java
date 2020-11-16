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
    private Runnable gKv;
    private AlaChallengeWaveView haI;
    private AlaChallengeWaveView haJ;
    private HeadImageView haK;
    private HeadImageView haL;
    private com.baidu.live.challenge.d haM;
    private TextView haN;
    private TextView haO;
    private TextView haP;
    private View haQ;
    private int hae;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hae;
        bVar.hae = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hae = 1;
        this.gKv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.haO.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hae)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.haN) {
                    b.this.bZx();
                }
            }
        };
        this.haI = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.haJ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hbZ, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbX};
        this.haI.setWaveArray(fArr);
        this.haI.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hbX, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbZ};
        this.haJ.setWaveArray(fArr2);
        this.haJ.setEndWaveArray(fArr2);
        this.haK = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.haK.setIsRound(true);
        this.haK.setAutoChangeStyle(false);
        this.haK.setDrawBorder(false);
        this.haK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.haK.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.haK.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.haL = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.haL.setIsRound(true);
        this.haL.setAutoChangeStyle(false);
        this.haK.setDrawBorder(false);
        this.haK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.haK.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.haN = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.haN.setOnClickListener(this.mClickListener);
        this.haO = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.haP = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.haQ = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.haM = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Ot() {
        super.Ot();
        this.haL.startLoad(this.haM.avatar, 25, false);
        this.haI.startAnimation();
        this.haJ.startAnimation();
        this.haP.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.haQ.setVisibility(0);
        this.haN.setVisibility(0);
        this.haN.setText(a.h.ala_challenge_panel_random_cancel);
        this.haN.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.haN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hae = 1;
        this.mHandler.post(this.gKv);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bZx();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bZx() {
        if (this.hbv != null && this.haM != null) {
            this.hbv.eV(this.haM.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.CF()) {
                this.haP.setText(a.h.ala_challenge_panel_random_succ_title);
                this.haO.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.haQ.setVisibility(8);
                this.haN.setVisibility(8);
            } else {
                bZy();
            }
            this.mHandler.removeCallbacks(this.gKv);
        }
    }

    private void bZy() {
        this.haP.setText(a.h.ala_challenge_panel_invite_fail);
        this.haO.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.haN.setText(a.h.ala_challenge_panel_again_select);
        this.haN.setBackgroundResource(a.e.sdk_red_border_bg);
        this.haN.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.haI.endAnimation();
        this.haJ.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.haI != null) {
            this.haI.endAnimation();
        }
        if (this.haJ != null) {
            this.haJ.endAnimation();
        }
        this.mHandler.removeCallbacks(this.gKv);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bZw() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
