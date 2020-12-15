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
    private com.baidu.live.challenge.a hjE;
    private AlaChallengeWaveView hkt;
    private AlaChallengeWaveView hku;
    private HeadImageView hkv;
    private HeadImageView hkw;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hkt = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hku = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hkt.setWaveArray(new float[]{AlaChallengeWaveView.hlK, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlI});
        this.hku.setWaveArray(new float[]{AlaChallengeWaveView.hlI, AlaChallengeWaveView.hlJ, AlaChallengeWaveView.hlK});
        this.hkv = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hkv.setIsRound(true);
        this.hkv.setAutoChangeStyle(false);
        this.hkv.setDrawBorder(false);
        this.hkv.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkv.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hkv.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hkw = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hkw.setIsRound(true);
        this.hkw.setAutoChangeStyle(false);
        this.hkw.setDrawBorder(false);
        this.hkw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkw.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hjE = aVar;
            this.hkw.startLoad(aVar.aIa, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cds() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hkt != null) {
            this.hkt.endAnimation();
        }
        if (this.hku != null) {
            this.hku.endAnimation();
        }
    }
}
