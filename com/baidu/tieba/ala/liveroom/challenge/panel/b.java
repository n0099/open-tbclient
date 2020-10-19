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
    private int gIE;
    private AlaChallengeWaveView gJi;
    private AlaChallengeWaveView gJj;
    private HeadImageView gJk;
    private HeadImageView gJl;
    private com.baidu.live.challenge.d gJm;
    private TextView gJn;
    private TextView gJo;
    private TextView gJp;
    private View gJq;
    private Runnable guX;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.gIE;
        bVar.gIE = i + 1;
        return i;
    }

    public b(Context context, n nVar) {
        super(context, nVar);
        this.mHandler = new Handler();
        this.gIE = 1;
        this.guX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.gJo.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.j.stringForLastTime(b.this.gIE)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.gJn) {
                    b.this.bUD();
                }
            }
        };
        this.gJi = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gJj = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.gKz, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKx};
        this.gJi.setWaveArray(fArr);
        this.gJi.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.gKx, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKz};
        this.gJj.setWaveArray(fArr2);
        this.gJj.setEndWaveArray(fArr2);
        this.gJk = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.gJk.setIsRound(true);
        this.gJk.setAutoChangeStyle(false);
        this.gJk.setDrawBorder(false);
        this.gJk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJk.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gJk.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gJl = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gJl.setIsRound(true);
        this.gJl.setAutoChangeStyle(false);
        this.gJk.setDrawBorder(false);
        this.gJk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJk.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gJn = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.gJn.setOnClickListener(this.mClickListener);
        this.gJo = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.gJp = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.gJq = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.gJm = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void Oe() {
        super.Oe();
        this.gJl.startLoad(this.gJm.avatar, 25, false);
        this.gJi.startAnimation();
        this.gJj.startAnimation();
        this.gJp.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.gJq.setVisibility(0);
        this.gJn.setVisibility(0);
        this.gJn.setText(a.i.ala_challenge_panel_random_cancel);
        this.gJn.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.gJn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.gIE = 1;
        this.mHandler.post(this.guX);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected boolean onBackKeyDown() {
        bUD();
        return true;
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_direct_link_view, (ViewGroup) null);
    }

    public void bUD() {
        if (this.gJV != null && this.gJm != null) {
            this.gJV.ex(this.gJm.userId);
        }
    }

    public void e(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            if (aVar.CP()) {
                this.gJp.setText(a.i.ala_challenge_panel_random_succ_title);
                this.gJo.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.gJq.setVisibility(8);
                this.gJn.setVisibility(8);
            } else {
                bUE();
            }
            this.mHandler.removeCallbacks(this.guX);
        }
    }

    private void bUE() {
        this.gJp.setText(a.i.ala_challenge_panel_invite_fail);
        this.gJo.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.gJn.setText(a.i.ala_challenge_panel_again_select);
        this.gJn.setBackgroundResource(a.f.sdk_red_border_bg);
        this.gJn.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.gJi.endAnimation();
        this.gJj.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.gJi != null) {
            this.gJi.endAnimation();
        }
        if (this.gJj != null) {
            this.gJj.endAnimation();
        }
        this.mHandler.removeCallbacks(this.guX);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bUC() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
