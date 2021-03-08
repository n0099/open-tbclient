package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes10.dex */
public class a extends g {
    private AlaChallengeWaveView hxP;
    private AlaChallengeWaveView hxQ;
    private HeadImageView hxR;
    private HeadImageView hxS;
    private com.baidu.live.challenge.a hxa;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hxP = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hxQ = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hxP.setWaveArray(new float[]{AlaChallengeWaveView.hzg, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hze});
        this.hxQ.setWaveArray(new float[]{AlaChallengeWaveView.hze, AlaChallengeWaveView.hzf, AlaChallengeWaveView.hzg});
        this.hxR = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hxR.setIsRound(true);
        this.hxR.setAutoChangeStyle(false);
        this.hxR.setDrawBorder(false);
        this.hxR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hxR.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hxR.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hxS = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hxS.setIsRound(true);
        this.hxS.setAutoChangeStyle(false);
        this.hxS.setDrawBorder(false);
        this.hxS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hxS.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hxa = aVar;
            this.hxS.startLoad(aVar.aGW, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdz() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hxP != null) {
            this.hxP.endAnimation();
        }
        if (this.hxQ != null) {
            this.hxQ.endAnimation();
        }
    }
}
