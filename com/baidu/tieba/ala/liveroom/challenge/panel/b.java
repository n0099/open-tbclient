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
    private Runnable foQ;
    private AlaChallengeWaveView fzO;
    private AlaChallengeWaveView fzP;
    private HeadImageView fzQ;
    private HeadImageView fzR;
    private com.baidu.live.challenge.d fzS;
    private TextView fzT;
    private TextView fzU;
    private TextView fzV;
    private View fzW;
    private int fzX;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.fzX;
        bVar.fzX = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.fzX = 1;
        this.foQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.fzU.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.fzX)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.fzT) {
                    b.this.buf();
                }
            }
        };
        this.fzO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fzP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.fBa, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fAY};
        this.fzO.setWaveArray(fArr);
        this.fzO.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.fAY, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fBa};
        this.fzP.setWaveArray(fArr2);
        this.fzP.setEndWaveArray(fArr2);
        this.fzQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fzQ.setIsRound(true);
        this.fzQ.setAutoChangeStyle(false);
        this.fzQ.setDrawBorder(false);
        this.fzQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzQ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fzQ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fzR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fzR.setIsRound(true);
        this.fzR.setAutoChangeStyle(false);
        this.fzQ.setDrawBorder(false);
        this.fzQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzQ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fzT = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.fzT.setOnClickListener(this.mClickListener);
        this.fzU = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.fzV = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.fzW = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.fzS = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void Cd() {
        super.Cd();
        this.fzR.startLoad(this.fzS.avatar, 25, false);
        this.fzO.startAnimation();
        this.fzP.startAnimation();
        this.fzV.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.fzW.setVisibility(0);
        this.fzT.setVisibility(0);
        this.fzT.setText(a.i.ala_challenge_panel_random_cancel);
        this.fzT.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.fzT.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.fzX = 1;
        this.mHandler.post(this.foQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        buf();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void buf() {
        if (this.fAu != null && this.fzS != null) {
            this.fAu.dC(this.fzS.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.ui()) {
                this.fzV.setText(a.i.ala_challenge_panel_random_succ_title);
                this.fzU.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.fzW.setVisibility(8);
                this.fzT.setVisibility(8);
            } else {
                bug();
            }
            this.mHandler.removeCallbacks(this.foQ);
        }
    }

    private void bug() {
        this.fzV.setText(a.i.ala_challenge_panel_invite_fail);
        this.fzU.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.fzT.setText(a.i.ala_challenge_panel_again_select);
        this.fzT.setBackgroundResource(a.f.sdk_red_border_bg);
        this.fzT.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.fzO.endAnimation();
        this.fzP.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fzO != null) {
            this.fzO.endAnimation();
        }
        if (this.fzP != null) {
            this.fzP.endAnimation();
        }
        this.mHandler.removeCallbacks(this.foQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bue() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
