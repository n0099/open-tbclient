package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends e {
    private AlaChallengeWaveView fNW;
    private AlaChallengeWaveView fNX;
    private HeadImageView fNY;
    private HeadImageView fNZ;
    private com.baidu.live.challenge.a fNy;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.fNW = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fNX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.fNW.setWaveArray(new float[]{AlaChallengeWaveView.fPi, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPg});
        this.fNX.setWaveArray(new float[]{AlaChallengeWaveView.fPg, AlaChallengeWaveView.fPh, AlaChallengeWaveView.fPi});
        this.fNY = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fNY.setIsRound(true);
        this.fNY.setAutoChangeStyle(false);
        this.fNY.setDrawBorder(false);
        this.fNY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fNY.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fNY.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fNZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fNZ.setIsRound(true);
        this.fNZ.setAutoChangeStyle(false);
        this.fNZ.setDrawBorder(false);
        this.fNZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fNZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fNy = aVar;
            this.fNZ.startLoad(aVar.aug, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bAb() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fNW != null) {
            this.fNW.endAnimation();
        }
        if (this.fNX != null) {
            this.fNX.endAnimation();
        }
    }
}
