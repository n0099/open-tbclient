package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends e {
    private TextView fAa;
    private View fAb;
    private int fAc;
    private Runnable foV;
    private AlaChallengeWaveView fzT;
    private AlaChallengeWaveView fzU;
    private HeadImageView fzV;
    private HeadImageView fzW;
    private com.baidu.live.challenge.d fzX;
    private TextView fzY;
    private TextView fzZ;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.fAc;
        bVar.fAc = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.fAc = 1;
        this.foV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.fzZ.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.fAc)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.fzY) {
                    b.this.bud();
                }
            }
        };
        this.fzT = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fzU = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.fBf, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBd};
        this.fzT.setWaveArray(fArr);
        this.fzT.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.fBd, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBf};
        this.fzU.setWaveArray(fArr2);
        this.fzU.setEndWaveArray(fArr2);
        this.fzV = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fzV.setIsRound(true);
        this.fzV.setAutoChangeStyle(false);
        this.fzV.setDrawBorder(false);
        this.fzV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzV.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fzV.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fzW = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fzW.setIsRound(true);
        this.fzW.setAutoChangeStyle(false);
        this.fzV.setDrawBorder(false);
        this.fzV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzV.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fzY = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.fzY.setOnClickListener(this.mClickListener);
        this.fzZ = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.fAa = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.fAb = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.fzX = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void Cc() {
        super.Cc();
        this.fzW.startLoad(this.fzX.avatar, 25, false);
        this.fzT.startAnimation();
        this.fzU.startAnimation();
        this.fAa.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.fAb.setVisibility(0);
        this.fzY.setVisibility(0);
        this.fzY.setText(a.i.ala_challenge_panel_random_cancel);
        this.fzY.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fzY.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fAc = 1;
        this.mHandler.post(this.foV);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        bud();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bud() {
        if (this.fAz != null && this.fzX != null) {
            this.fAz.dC(this.fzX.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.uh()) {
                this.fAa.setText(a.i.ala_challenge_panel_random_succ_title);
                this.fzZ.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.fAb.setVisibility(8);
                this.fzY.setVisibility(8);
            } else {
                bue();
            }
            this.mHandler.removeCallbacks(this.foV);
        }
    }

    private void bue() {
        this.fAa.setText(a.i.ala_challenge_panel_invite_fail);
        this.fzZ.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.fzY.setText(a.i.ala_challenge_panel_again_select);
        this.fzY.setBackgroundResource(a.f.sdk_red_border_bg);
        this.fzY.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fzT.endAnimation();
        this.fzU.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fzT != null) {
            this.fzT.endAnimation();
        }
        if (this.fzU != null) {
            this.fzU.endAnimation();
        }
        this.mHandler.removeCallbacks(this.foV);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int buc() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
