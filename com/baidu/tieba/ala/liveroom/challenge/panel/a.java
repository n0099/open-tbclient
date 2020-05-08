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
    private AlaChallengeWaveView fzT;
    private AlaChallengeWaveView fzU;
    private HeadImageView fzV;
    private HeadImageView fzW;
    private com.baidu.live.challenge.a fzw;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.fzT = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fzU = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.fzT.setWaveArray(new float[]{AlaChallengeWaveView.fBf, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBd});
        this.fzU.setWaveArray(new float[]{AlaChallengeWaveView.fBd, AlaChallengeWaveView.fBe, AlaChallengeWaveView.fBf});
        this.fzV = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fzV.setIsRound(true);
        this.fzV.setAutoChangeStyle(false);
        this.fzV.setDrawBorder(false);
        this.fzV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzV.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fzV.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fzW = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fzW.setIsRound(true);
        this.fzW.setAutoChangeStyle(false);
        this.fzW.setDrawBorder(false);
        this.fzW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzW.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fzw = aVar;
            this.fzW.startLoad(aVar.apm, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int buc() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fzT != null) {
            this.fzT.endAnimation();
        }
        if (this.fzU != null) {
            this.fzU.endAnimation();
        }
    }
}
