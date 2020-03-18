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
    private com.baidu.live.challenge.a eUY;
    private AlaChallengeWaveView eVA;
    private AlaChallengeWaveView eVB;
    private HeadImageView eVC;
    private HeadImageView eVD;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.eVA = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eVB = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.eVA.setWaveArray(new float[]{AlaChallengeWaveView.eWM, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWK});
        this.eVB.setWaveArray(new float[]{AlaChallengeWaveView.eWK, AlaChallengeWaveView.eWL, AlaChallengeWaveView.eWM});
        this.eVC = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eVC.setIsRound(true);
        this.eVC.setAutoChangeStyle(false);
        this.eVC.setDrawBorder(false);
        this.eVC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVC.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVC.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eVD = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eVD.setIsRound(true);
        this.eVD.setAutoChangeStyle(false);
        this.eVD.setDrawBorder(false);
        this.eVD.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVD.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eUY = aVar;
            this.eVD.startLoad(aVar.Xe, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkL() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eVA != null) {
            this.eVA.endAnimation();
        }
        if (this.eVB != null) {
            this.eVB.endAnimation();
        }
    }
}
