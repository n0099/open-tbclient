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
    private Runnable hdO;
    private int hvC;
    private AlaChallengeWaveView hwg;
    private AlaChallengeWaveView hwh;
    private HeadImageView hwi;
    private HeadImageView hwj;
    private com.baidu.live.challenge.d hwk;
    private TextView hwl;
    private TextView hwm;
    private TextView hwn;
    private View hwo;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.hvC;
        bVar.hvC = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.hvC = 1;
        this.hdO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.hwm.setText(b.this.mContext.getString(a.h.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.hvC)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.hwl) {
                    b.this.cdu();
                }
            }
        };
        this.hwg = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hwh = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.hxx, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxv};
        this.hwg.setWaveArray(fArr);
        this.hwg.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.hxv, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxx};
        this.hwh.setWaveArray(fArr2);
        this.hwh.setEndWaveArray(fArr2);
        this.hwi = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hwi.setIsRound(true);
        this.hwi.setAutoChangeStyle(false);
        this.hwi.setDrawBorder(false);
        this.hwi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwi.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwi.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hwj = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hwj.setIsRound(true);
        this.hwj.setAutoChangeStyle(false);
        this.hwi.setDrawBorder(false);
        this.hwi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwi.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwl = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_cancle);
        this.hwl.setOnClickListener(this.mClickListener);
        this.hwm = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_countdown);
        this.hwn = (TextView) this.mRootView.findViewById(a.f.ala_challenge_direct_status);
        this.hwo = this.mRootView.findViewById(a.f.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.hwk = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void onShow() {
        super.onShow();
        this.hwj.startLoad(this.hwk.avatar, 25, false);
        this.hwg.startAnimation();
        this.hwh.startAnimation();
        this.hwn.setText(this.mContext.getString(a.h.ala_challenge_panel_matching));
        this.hwo.setVisibility(0);
        this.hwl.setVisibility(0);
        this.hwl.setText(a.h.ala_challenge_panel_random_cancel);
        this.hwl.setBackgroundResource(a.e.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.hwl.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_c));
        this.hvC = 1;
        this.mHandler.post(this.hdO);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        cdu();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void cdu() {
        if (this.hwT != null && this.hwk != null) {
            this.hwT.fE(this.hwk.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.At()) {
                this.hwn.setText(a.h.ala_challenge_panel_random_succ_title);
                this.hwm.setText(a.h.ala_challenge_panel_random_succ_tip);
                this.hwo.setVisibility(8);
                this.hwl.setVisibility(8);
            } else {
                cdv();
            }
            this.mHandler.removeCallbacks(this.hdO);
        }
    }

    private void cdv() {
        this.hwn.setText(a.h.ala_challenge_panel_invite_fail);
        this.hwm.setText(a.h.ala_challenge_panel_direct_fail_tip);
        this.hwl.setText(a.h.ala_challenge_panel_again_select);
        this.hwl.setBackgroundResource(a.e.sdk_red_border_bg);
        this.hwl.setTextColor(this.mContext.getResources().getColor(a.c.sdk_cp_cont_g));
        this.hwg.endAnimation();
        this.hwh.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hwg != null) {
            this.hwg.endAnimation();
        }
        if (this.hwh != null) {
            this.hwh.endAnimation();
        }
        this.mHandler.removeCallbacks(this.hdO);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdt() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }
}
