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
    private Runnable eJP;
    private AlaChallengeWaveView eUO;
    private AlaChallengeWaveView eUP;
    private HeadImageView eUQ;
    private HeadImageView eUR;
    private com.baidu.live.challenge.d eUS;
    private TextView eUT;
    private TextView eUU;
    private TextView eUV;
    private View eUW;
    private int eUX;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.eUX;
        bVar.eUX = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.eUX = 1;
        this.eJP = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eUU.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.eUX)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.eUT) {
                    b.this.bkE();
                }
            }
        };
        this.eUO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eUP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eVY};
        this.eUO.setWaveArray(fArr);
        this.eUO.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.eVY, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa};
        this.eUP.setWaveArray(fArr2);
        this.eUP.setEndWaveArray(fArr2);
        this.eUQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eUQ.setIsRound(true);
        this.eUQ.setAutoChangeStyle(false);
        this.eUQ.setDrawBorder(false);
        this.eUQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUQ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eUQ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eUR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eUR.setIsRound(true);
        this.eUR.setAutoChangeStyle(false);
        this.eUQ.setDrawBorder(false);
        this.eUQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUQ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eUT = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.eUT.setOnClickListener(this.mClickListener);
        this.eUU = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.eUV = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.eUW = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eUS = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void xm() {
        super.xm();
        this.eUR.startLoad(this.eUS.avatar, 25, false);
        this.eUO.startAnimation();
        this.eUP.startAnimation();
        this.eUV.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.eUW.setVisibility(0);
        this.eUT.setVisibility(0);
        this.eUT.setText(a.i.ala_challenge_panel_random_cancel);
        this.eUT.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eUT.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eUX = 1;
        this.mHandler.post(this.eJP);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        bkE();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bkE() {
        if (this.eVu != null && this.eUS != null) {
            this.eVu.cU(this.eUS.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.pM()) {
                this.eUV.setText(a.i.ala_challenge_panel_random_succ_title);
                this.eUU.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.eUW.setVisibility(8);
                this.eUT.setVisibility(8);
            } else {
                bkF();
            }
            this.mHandler.removeCallbacks(this.eJP);
        }
    }

    private void bkF() {
        this.eUV.setText(a.i.ala_challenge_panel_invite_fail);
        this.eUU.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.eUT.setText(a.i.ala_challenge_panel_again_select);
        this.eUT.setBackgroundResource(a.f.sdk_red_border_bg);
        this.eUT.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eUO.endAnimation();
        this.eUP.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eUO != null) {
            this.eUO.endAnimation();
        }
        if (this.eUP != null) {
            this.eUP.endAnimation();
        }
        this.mHandler.removeCallbacks(this.eJP);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkD() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
