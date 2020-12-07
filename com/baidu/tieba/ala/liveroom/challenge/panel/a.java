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
    private com.baidu.live.challenge.a hjC;
    private AlaChallengeWaveView hkr;
    private AlaChallengeWaveView hks;
    private HeadImageView hkt;
    private HeadImageView hku;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hkr = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hks = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hkr.setWaveArray(new float[]{AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlG});
        this.hks.setWaveArray(new float[]{AlaChallengeWaveView.hlG, AlaChallengeWaveView.hlH, AlaChallengeWaveView.hlI});
        this.hkt = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hkt.setIsRound(true);
        this.hkt.setAutoChangeStyle(false);
        this.hkt.setDrawBorder(false);
        this.hkt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkt.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hkt.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hku = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hku.setIsRound(true);
        this.hku.setAutoChangeStyle(false);
        this.hku.setDrawBorder(false);
        this.hku.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hku.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hjC = aVar;
            this.hku.startLoad(aVar.aIa, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdr() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hkr != null) {
            this.hkr.endAnimation();
        }
        if (this.hks != null) {
            this.hks.endAnimation();
        }
    }
}
