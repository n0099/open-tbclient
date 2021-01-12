package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class a extends g {
    private com.baidu.live.challenge.a hqT;
    private AlaChallengeWaveView hrI;
    private AlaChallengeWaveView hrJ;
    private HeadImageView hrK;
    private HeadImageView hrL;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hrI = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hrJ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hrI.setWaveArray(new float[]{AlaChallengeWaveView.hsZ, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsX});
        this.hrJ.setWaveArray(new float[]{AlaChallengeWaveView.hsX, AlaChallengeWaveView.hsY, AlaChallengeWaveView.hsZ});
        this.hrK = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hrK.setIsRound(true);
        this.hrK.setAutoChangeStyle(false);
        this.hrK.setDrawBorder(false);
        this.hrK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hrK.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hrK.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hrL = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hrL.setIsRound(true);
        this.hrL.setAutoChangeStyle(false);
        this.hrL.setDrawBorder(false);
        this.hrL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hrL.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hqT = aVar;
            this.hrL.startLoad(aVar.aDJ, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int ccr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hrI != null) {
            this.hrI.endAnimation();
        }
        if (this.hrJ != null) {
            this.hrJ.endAnimation();
        }
    }
}
