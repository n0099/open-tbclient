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
    private com.baidu.live.challenge.a fNJ;
    private AlaChallengeWaveView fOh;
    private AlaChallengeWaveView fOi;
    private HeadImageView fOj;
    private HeadImageView fOk;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.fOh = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fOi = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.fOh.setWaveArray(new float[]{AlaChallengeWaveView.fPt, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPr});
        this.fOi.setWaveArray(new float[]{AlaChallengeWaveView.fPr, AlaChallengeWaveView.fPs, AlaChallengeWaveView.fPt});
        this.fOj = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fOj.setIsRound(true);
        this.fOj.setAutoChangeStyle(false);
        this.fOj.setDrawBorder(false);
        this.fOj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOj.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fOj.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fOk = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fOk.setIsRound(true);
        this.fOk.setAutoChangeStyle(false);
        this.fOk.setDrawBorder(false);
        this.fOk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fOk.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fNJ = aVar;
            this.fOk.startLoad(aVar.aug, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bAd() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fOh != null) {
            this.fOh.endAnimation();
        }
        if (this.fOi != null) {
            this.fOi.endAnimation();
        }
    }
}
