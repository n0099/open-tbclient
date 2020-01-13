package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes2.dex */
public class a extends e {
    private AlaChallengeWaveView eQX;
    private AlaChallengeWaveView eQY;
    private HeadImageView eQZ;
    private com.baidu.live.challenge.a eQv;
    private HeadImageView eRa;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.eQX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eQY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.eQX.setWaveArray(new float[]{AlaChallengeWaveView.eSj, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSh});
        this.eQY.setWaveArray(new float[]{AlaChallengeWaveView.eSh, AlaChallengeWaveView.eSi, AlaChallengeWaveView.eSj});
        this.eQZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eQZ.setIsRound(true);
        this.eQZ.setAutoChangeStyle(false);
        this.eQZ.setDrawBorder(false);
        this.eQZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eQZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eQZ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eRa = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eRa.setIsRound(true);
        this.eRa.setAutoChangeStyle(false);
        this.eRa.setDrawBorder(false);
        this.eRa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eRa.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eQv = aVar;
            this.eRa.startLoad(aVar.Vo, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int biN() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eQX != null) {
            this.eQX.endAnimation();
        }
        if (this.eQY != null) {
            this.eQY.endAnimation();
        }
    }
}
