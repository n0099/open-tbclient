package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes6.dex */
public class a extends e {
    private com.baidu.live.challenge.a dYZ;
    private AlaChallengeWaveView dZB;
    private AlaChallengeWaveView dZC;
    private HeadImageView dZD;
    private HeadImageView dZE;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.dZB = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.dZC = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.dZB.setWaveArray(new float[]{AlaChallengeWaveView.eaL, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaJ});
        this.dZC.setWaveArray(new float[]{AlaChallengeWaveView.eaJ, AlaChallengeWaveView.eaK, AlaChallengeWaveView.eaL});
        this.dZD = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.dZD.setIsRound(true);
        this.dZD.setAutoChangeStyle(false);
        this.dZD.setDrawBorder(false);
        this.dZD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dZD.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.dZD.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.dZE = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.dZE.setIsRound(true);
        this.dZE.setAutoChangeStyle(false);
        this.dZE.setDrawBorder(false);
        this.dZE.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dZE.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.dYZ = aVar;
            this.dZE.startLoad(aVar.Oa, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int aQz() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.dZB != null) {
            this.dZB.endAnimation();
        }
        if (this.dZC != null) {
            this.dZC.endAnimation();
        }
    }
}
