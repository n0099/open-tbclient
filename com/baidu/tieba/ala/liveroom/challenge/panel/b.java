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
    private Runnable eJQ;
    private AlaChallengeWaveView eUP;
    private AlaChallengeWaveView eUQ;
    private HeadImageView eUR;
    private HeadImageView eUS;
    private com.baidu.live.challenge.d eUT;
    private TextView eUU;
    private TextView eUV;
    private TextView eUW;
    private View eUX;
    private int eUY;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.eUY;
        bVar.eUY = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.eUY = 1;
        this.eJQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.eUV.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.eUY)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.eUU) {
                    b.this.bkG();
                }
            }
        };
        this.eUP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eUQ = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.eWb, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ};
        this.eUP.setWaveArray(fArr);
        this.eUP.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eWb};
        this.eUQ.setWaveArray(fArr2);
        this.eUQ.setEndWaveArray(fArr2);
        this.eUR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eUR.setIsRound(true);
        this.eUR.setAutoChangeStyle(false);
        this.eUR.setDrawBorder(false);
        this.eUR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUR.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eUR.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eUS = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eUS.setIsRound(true);
        this.eUS.setAutoChangeStyle(false);
        this.eUR.setDrawBorder(false);
        this.eUR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUR.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eUU = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.eUU.setOnClickListener(this.mClickListener);
        this.eUV = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.eUW = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.eUX = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.eUT = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void xm() {
        super.xm();
        this.eUS.startLoad(this.eUT.avatar, 25, false);
        this.eUP.startAnimation();
        this.eUQ.startAnimation();
        this.eUW.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.eUX.setVisibility(0);
        this.eUU.setVisibility(0);
        this.eUU.setText(a.i.ala_challenge_panel_random_cancel);
        this.eUU.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.eUU.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.eUY = 1;
        this.mHandler.post(this.eJQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        bkG();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bkG() {
        if (this.eVv != null && this.eUT != null) {
            this.eVv.cU(this.eUT.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.pM()) {
                this.eUW.setText(a.i.ala_challenge_panel_random_succ_title);
                this.eUV.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.eUX.setVisibility(8);
                this.eUU.setVisibility(8);
            } else {
                bkH();
            }
            this.mHandler.removeCallbacks(this.eJQ);
        }
    }

    private void bkH() {
        this.eUW.setText(a.i.ala_challenge_panel_invite_fail);
        this.eUV.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.eUU.setText(a.i.ala_challenge_panel_again_select);
        this.eUU.setBackgroundResource(a.f.sdk_red_border_bg);
        this.eUU.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.eUP.endAnimation();
        this.eUQ.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eUP != null) {
            this.eUP.endAnimation();
        }
        if (this.eUQ != null) {
            this.eUQ.endAnimation();
        }
        this.mHandler.removeCallbacks(this.eJQ);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkF() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
