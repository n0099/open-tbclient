package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes4.dex */
public class a extends g {
    private com.baidu.live.challenge.a ham;
    private AlaChallengeWaveView hbb;
    private AlaChallengeWaveView hbc;
    private HeadImageView hbd;
    private HeadImageView hbe;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hbb = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hbc = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hbb.setWaveArray(new float[]{AlaChallengeWaveView.hcs, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcq});
        this.hbc.setWaveArray(new float[]{AlaChallengeWaveView.hcq, AlaChallengeWaveView.hcr, AlaChallengeWaveView.hcs});
        this.hbd = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hbd.setIsRound(true);
        this.hbd.setAutoChangeStyle(false);
        this.hbd.setDrawBorder(false);
        this.hbd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbd.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hbd.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hbe = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hbe.setIsRound(true);
        this.hbe.setAutoChangeStyle(false);
        this.hbe.setDrawBorder(false);
        this.hbe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hbe.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.ham = aVar;
            this.hbe.startLoad(aVar.aHd, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cad() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hbb != null) {
            this.hbb.endAnimation();
        }
        if (this.hbc != null) {
            this.hbc.endAnimation();
        }
    }
}
