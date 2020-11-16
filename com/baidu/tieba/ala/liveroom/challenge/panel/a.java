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
    private com.baidu.live.challenge.a gZT;
    private AlaChallengeWaveView haI;
    private AlaChallengeWaveView haJ;
    private HeadImageView haK;
    private HeadImageView haL;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.haI = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.haJ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.haI.setWaveArray(new float[]{AlaChallengeWaveView.hbZ, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbX});
        this.haJ.setWaveArray(new float[]{AlaChallengeWaveView.hbX, AlaChallengeWaveView.hbY, AlaChallengeWaveView.hbZ});
        this.haK = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.haK.setIsRound(true);
        this.haK.setAutoChangeStyle(false);
        this.haK.setDrawBorder(false);
        this.haK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.haK.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.haK.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.haL = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.haL.setIsRound(true);
        this.haL.setAutoChangeStyle(false);
        this.haL.setDrawBorder(false);
        this.haL.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.haL.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gZT = aVar;
            this.haL.startLoad(aVar.aFs, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bZw() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.haI != null) {
            this.haI.endAnimation();
        }
        if (this.haJ != null) {
            this.haJ.endAnimation();
        }
    }
}
