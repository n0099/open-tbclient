package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class a extends e {
    private com.baidu.live.challenge.a eOW;
    private HeadImageView ePA;
    private HeadImageView ePB;
    private AlaChallengeWaveView ePy;
    private AlaChallengeWaveView ePz;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.ePy = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.ePz = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.ePy.setWaveArray(new float[]{AlaChallengeWaveView.eQG, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQE});
        this.ePz.setWaveArray(new float[]{AlaChallengeWaveView.eQE, AlaChallengeWaveView.eQF, AlaChallengeWaveView.eQG});
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
        this.ePB.setDrawBorder(false);
        this.ePB.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ePB.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eOW = aVar;
            this.ePB.startLoad(aVar.UX, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bic() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
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
    }
}
