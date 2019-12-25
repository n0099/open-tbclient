package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class b extends e {
    private Runnable eEL;
    private HeadImageView ePA;
    private HeadImageView ePB;
    private com.baidu.live.challenge.d ePC;
    private TextView ePD;
    private TextView ePE;
    private TextView ePF;
    private View ePG;
    private int ePH;
    private AlaChallengeWaveView ePy;
    private AlaChallengeWaveView ePz;
    private View.OnClickListener mClickListener;
    private Handler mHandler;

    static /* synthetic */ int c(b bVar) {
        int i = bVar.ePH;
        bVar.ePH = i + 1;
        return i;
    }

    public b(Context context, k kVar) {
        super(context, kVar);
        this.mHandler = new Handler();
        this.ePH = 1;
        this.eEL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.ePE.setText(b.this.mContext.getString(a.i.ala_challenge_panel_random_wait_tip, com.baidu.live.utils.i.stringForLastTime(b.this.ePH)));
                b.c(b.this);
                b.this.mHandler.postDelayed(this, 1000L);
            }
        };
        this.mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.challenge.panel.b.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == b.this.ePD && b.this.ePC != null) {
                    b.this.eQe.cN(b.this.ePC.userId);
                }
            }
        };
        this.ePy = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.ePz = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        float[] fArr = {AlaChallengeWaveView.eQG, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQE};
        this.ePy.setWaveArray(fArr);
        this.ePy.setEndWaveArray(fArr);
        float[] fArr2 = {AlaChallengeWaveView.eQE, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQG};
        this.ePz.setWaveArray(fArr2);
        this.ePz.setEndWaveArray(fArr2);
        this.ePA = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.ePA.setIsRound(true);
        this.ePA.setAutoChangeStyle(false);
        this.ePA.setDrawBorder(false);
        this.ePA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ePA.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.ePA.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.ePB = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.ePB.setIsRound(true);
        this.ePB.setAutoChangeStyle(false);
        this.ePA.setDrawBorder(false);
        this.ePA.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ePA.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.ePD = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_cancle);
        this.ePD.setOnClickListener(this.mClickListener);
        this.ePE = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_countdown);
        this.ePF = (TextView) this.mRootView.findViewById(a.g.ala_challenge_direct_status);
        this.ePG = this.mRootView.findViewById(a.g.ala_challenge_direct_header_cover);
    }

    public void b(com.baidu.live.challenge.d dVar) {
        if (dVar != null) {
            this.ePC = dVar;
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void bid() {
        super.bid();
        this.ePB.startLoad(this.ePC.avatar, 25, false);
        this.ePy.startAnimation();
        this.ePz.startAnimation();
        this.ePF.setText(this.mContext.getString(a.i.ala_challenge_panel_matching));
        this.ePG.setVisibility(0);
        this.ePD.setVisibility(0);
        this.ePD.setText(a.i.ala_challenge_panel_random_cancel);
        this.ePD.setBackgroundResource(a.f.ala_challenge_panel_random_ops_cancel_bg_shape);
        this.ePD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_c));
        this.ePH = 1;
        this.mHandler.post(this.eEL);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected boolean onBackKeyDown() {
        if (this.ePC != null) {
            this.eQe.cN(this.ePC.userId);
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
            if (aVar.oU()) {
                this.ePF.setText(a.i.ala_challenge_panel_random_succ_title);
                this.ePE.setText(a.i.ala_challenge_panel_random_succ_tip);
                this.ePG.setVisibility(8);
                this.ePD.setVisibility(8);
            } else {
                bie();
            }
            this.mHandler.removeCallbacks(this.eEL);
        }
    }

    private void bie() {
        this.ePF.setText(a.i.ala_challenge_panel_invite_fail);
        this.ePE.setText(a.i.ala_challenge_panel_direct_fail_tip);
        this.ePD.setText(a.i.ala_challenge_panel_again_select);
        this.ePD.setBackgroundResource(a.f.sdk_red_border_bg);
        this.ePD.setTextColor(this.mContext.getResources().getColor(a.d.sdk_cp_cont_g));
        this.ePy.endAnimation();
        this.ePz.endAnimation();
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.ePy != null) {
            this.ePy.endAnimation();
        }
        if (this.ePz != null) {
            this.ePz.endAnimation();
        }
        this.mHandler.removeCallbacks(this.eEL);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bic() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }
}
