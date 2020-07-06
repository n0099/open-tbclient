package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes3.dex */
public class a extends g {
    private AlaChallengeWaveView fZX;
    private AlaChallengeWaveView fZY;
    private HeadImageView fZZ;
    private com.baidu.live.challenge.a fZn;
    private HeadImageView gaa;

    public a(Context context, m mVar) {
        super(context, mVar);
        this.fZX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fZY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.fZX.setWaveArray(new float[]{AlaChallengeWaveView.gbp, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbn});
        this.fZY.setWaveArray(new float[]{AlaChallengeWaveView.gbn, AlaChallengeWaveView.gbo, AlaChallengeWaveView.gbp});
        this.fZZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fZZ.setIsRound(true);
        this.fZZ.setAutoChangeStyle(false);
        this.fZZ.setDrawBorder(false);
        this.fZZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fZZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fZZ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gaa = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gaa.setIsRound(true);
        this.gaa.setAutoChangeStyle(false);
        this.gaa.setDrawBorder(false);
        this.gaa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gaa.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fZn = aVar;
            this.gaa.startLoad(aVar.awi, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bCZ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.fZX != null) {
            this.fZX.endAnimation();
        }
        if (this.fZY != null) {
            this.fZY.endAnimation();
        }
    }
}
