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
    private com.baidu.live.challenge.a gIt;
    private AlaChallengeWaveView gJi;
    private AlaChallengeWaveView gJj;
    private HeadImageView gJk;
    private HeadImageView gJl;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.gJi = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gJj = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.gJi.setWaveArray(new float[]{AlaChallengeWaveView.gKz, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKx});
        this.gJj.setWaveArray(new float[]{AlaChallengeWaveView.gKx, AlaChallengeWaveView.gKy, AlaChallengeWaveView.gKz});
        this.gJk = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.gJk.setIsRound(true);
        this.gJk.setAutoChangeStyle(false);
        this.gJk.setDrawBorder(false);
        this.gJk.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJk.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gJk.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gJl = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gJl.setIsRound(true);
        this.gJl.setAutoChangeStyle(false);
        this.gJl.setDrawBorder(false);
        this.gJl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gJl.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gIt = aVar;
            this.gJl.startLoad(aVar.aGf, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bUC() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.gJi != null) {
            this.gJi.endAnimation();
        }
        if (this.gJj != null) {
            this.gJj.endAnimation();
        }
    }
}
