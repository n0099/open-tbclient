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
    private AlaChallengeWaveView hvS;
    private AlaChallengeWaveView hvT;
    private HeadImageView hvU;
    private HeadImageView hvV;
    private com.baidu.live.challenge.a hvd;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hvS = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hvT = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hvS.setWaveArray(new float[]{AlaChallengeWaveView.hxj, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxh});
        this.hvT.setWaveArray(new float[]{AlaChallengeWaveView.hxh, AlaChallengeWaveView.hxi, AlaChallengeWaveView.hxj});
        this.hvU = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hvU.setIsRound(true);
        this.hvU.setAutoChangeStyle(false);
        this.hvU.setDrawBorder(false);
        this.hvU.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hvU.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hvU.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hvV = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hvV.setIsRound(true);
        this.hvV.setAutoChangeStyle(false);
        this.hvV.setDrawBorder(false);
        this.hvV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hvV.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hvd = aVar;
            this.hvV.startLoad(aVar.aFw, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdm() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hvS != null) {
            this.hvS.endAnimation();
        }
        if (this.hvT != null) {
            this.hvT.endAnimation();
        }
    }
}
