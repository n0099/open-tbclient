package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class a extends g {
    private com.baidu.live.challenge.a hvz;
    private AlaChallengeWaveView hwo;
    private AlaChallengeWaveView hwp;
    private HeadImageView hwq;
    private HeadImageView hwr;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hwo = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hwp = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hwo.setWaveArray(new float[]{AlaChallengeWaveView.hxF, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxD});
        this.hwp.setWaveArray(new float[]{AlaChallengeWaveView.hxD, AlaChallengeWaveView.hxE, AlaChallengeWaveView.hxF});
        this.hwq = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hwq.setIsRound(true);
        this.hwq.setAutoChangeStyle(false);
        this.hwq.setDrawBorder(false);
        this.hwq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwq.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwq.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hwr = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hwr.setIsRound(true);
        this.hwr.setAutoChangeStyle(false);
        this.hwr.setDrawBorder(false);
        this.hwr.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwr.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hvz = aVar;
            this.hwr.startLoad(aVar.aIw, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cgi() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hwo != null) {
            this.hwo.endAnimation();
        }
        if (this.hwp != null) {
            this.hwp.endAnimation();
        }
    }
}
