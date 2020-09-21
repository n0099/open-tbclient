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
    private com.baidu.live.challenge.a gtY;
    private AlaChallengeWaveView guN;
    private AlaChallengeWaveView guO;
    private HeadImageView guP;
    private HeadImageView guQ;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.guN = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.guO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.guN.setWaveArray(new float[]{AlaChallengeWaveView.gwg, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwe});
        this.guO.setWaveArray(new float[]{AlaChallengeWaveView.gwe, AlaChallengeWaveView.gwf, AlaChallengeWaveView.gwg});
        this.guP = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.guP.setIsRound(true);
        this.guP.setAutoChangeStyle(false);
        this.guP.setDrawBorder(false);
        this.guP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guP.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.guP.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.guQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.guQ.setIsRound(true);
        this.guQ.setAutoChangeStyle(false);
        this.guQ.setDrawBorder(false);
        this.guQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.guQ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gtY = aVar;
            this.guQ.startLoad(aVar.aDa, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bRi() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.guN != null) {
            this.guN.endAnimation();
        }
        if (this.guO != null) {
            this.guO.endAnimation();
        }
    }
}
