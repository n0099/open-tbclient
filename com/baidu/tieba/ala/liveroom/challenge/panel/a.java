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
    private com.baidu.live.challenge.a dZQ;
    private AlaChallengeWaveView eas;
    private AlaChallengeWaveView eat;
    private HeadImageView eau;
    private HeadImageView eav;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.eas = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eat = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.eas.setWaveArray(new float[]{AlaChallengeWaveView.ebC, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebA});
        this.eat.setWaveArray(new float[]{AlaChallengeWaveView.ebA, AlaChallengeWaveView.ebB, AlaChallengeWaveView.ebC});
        this.eau = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eau.setIsRound(true);
        this.eau.setAutoChangeStyle(false);
        this.eau.setDrawBorder(false);
        this.eau.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eau.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eau.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eav = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eav.setIsRound(true);
        this.eav.setAutoChangeStyle(false);
        this.eav.setDrawBorder(false);
        this.eav.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eav.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.dZQ = aVar;
            this.eav.startLoad(aVar.OA, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int aQB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eas != null) {
            this.eas.endAnimation();
        }
        if (this.eat != null) {
            this.eat.endAnimation();
        }
    }
}
