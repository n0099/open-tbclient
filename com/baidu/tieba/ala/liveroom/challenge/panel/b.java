package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class b extends e {
    private AlaChallengeWaveView dZB;
    private AlaChallengeWaveView dZC;
    private HeadImageView dZD;
    private HeadImageView dZE;
    private com.baidu.live.challenge.d dZF;
    private TextView dZG;
    private TextView dZH;
    private TextView dZI;
    private View dZJ;
    private int dZK;
    private Runnable dZL;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.dZK;
        bVar.dZK = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.dZK = 1;
        this.dZL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.dZH.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.h.stringForLastTime(b.this.dZK)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.dZG && b.this.dZF != null) {
                    b.this.eai.ch(b.this.dZF.userId);
                }
            }
        };
        this.dZB = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.dZC = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.eaL, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaJ};
        this.dZB.setWaveArray(fArr);
        this.dZB.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.eaJ, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaL};
        this.dZC.setWaveArray(fArr2);
        this.dZC.setEndWaveArray(fArr2);
        this.dZD = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.dZD.setIsRound(true);
        this.dZD.setAutoChangeStyle(false);
        this.dZD.setDrawBorder(false);
        this.dZD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dZD.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.dZD.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.dZE = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.dZE.setIsRound(true);
        this.dZE.setAutoChangeStyle(false);
        this.dZD.setDrawBorder(false);
        this.dZD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dZD.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.dZG = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.dZG.setOnClickListener(this.mClickListener);
        this.dZH = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.dZI = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.dZJ = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.dZF = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void aav() {
        super.aav();
        this.dZE.startLoad(this.dZF.avatar, 25, false);
        this.dZB.startAnimation();
        this.dZC.startAnimation();
        this.dZI.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.dZJ.setVisibility(0);
        this.dZG.setVisibility(0);
        this.dZG.setText(a.i.ala_challenge_panel_random_cancel);
        this.dZG.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.dZG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.dZK = 1;
        this.mHandler.post(this.dZL);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        if (this.dZF != null) {
            this.eai.ch(this.dZF.userId);
            return true;
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.nC()) {
                this.dZI.setText(a.i.ala_challenge_panel_random_succ_title);
                this.dZH.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.dZJ.setVisibility(8);
                this.dZG.setVisibility(8);
            } else {
                aQA();
            }
            this.mHandler.removeCallbacks(this.dZL);
        }
    }

    private void aQA() {
        this.dZI.setText(a.i.ala_challenge_panel_invite_fail);
        this.dZH.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.dZG.setText(a.i.ala_challenge_panel_again_select);
        this.dZG.setBackgroundResource(a.f.sdk_red_border_bg);
        this.dZG.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.dZB.endAnimation();
        this.dZC.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.dZB != null) {
            this.dZB.endAnimation();
        }
        if (this.dZC != null) {
            this.dZC.endAnimation();
        }
        this.mHandler.removeCallbacks(this.dZL);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int aQz() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
