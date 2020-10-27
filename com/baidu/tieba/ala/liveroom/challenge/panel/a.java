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
    private AlaChallengeWaveView gUX;
    private AlaChallengeWaveView gUY;
    private HeadImageView gUZ;
    private com.baidu.live.challenge.a gUi;
    private HeadImageView gVa;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.gUX = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gUY = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.gUX.setWaveArray(new float[]{AlaChallengeWaveView.gWo, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWm});
        this.gUY.setWaveArray(new float[]{AlaChallengeWaveView.gWm, AlaChallengeWaveView.gWn, AlaChallengeWaveView.gWo});
        this.gUZ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.gUZ.setIsRound(true);
        this.gUZ.setAutoChangeStyle(false);
        this.gUZ.setDrawBorder(false);
        this.gUZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gUZ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gUZ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gVa = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gVa.setIsRound(true);
        this.gVa.setAutoChangeStyle(false);
        this.gVa.setDrawBorder(false);
        this.gVa.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVa.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gUi = aVar;
            this.gVa.startLoad(aVar.aGn, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bXB() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.gUX != null) {
            this.gUX.endAnimation();
        }
        if (this.gUY != null) {
            this.gUY.endAnimation();
        }
    }
}
