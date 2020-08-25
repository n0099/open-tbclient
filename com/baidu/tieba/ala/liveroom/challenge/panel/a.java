package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes7.dex */
public class a extends g {
    private com.baidu.live.challenge.a gqD;
    private AlaChallengeWaveView grn;
    private AlaChallengeWaveView gro;
    private HeadImageView grp;
    private HeadImageView grq;

    public a(Context context, m mVar) {
        super(context, mVar);
        this.grn = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gro = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.grn.setWaveArray(new float[]{AlaChallengeWaveView.gsG, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsE});
        this.gro.setWaveArray(new float[]{AlaChallengeWaveView.gsE, AlaChallengeWaveView.gsF, AlaChallengeWaveView.gsG});
        this.grp = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.grp.setIsRound(true);
        this.grp.setAutoChangeStyle(false);
        this.grp.setDrawBorder(false);
        this.grp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grp.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.grp.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.grq = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.grq.setIsRound(true);
        this.grq.setAutoChangeStyle(false);
        this.grq.setDrawBorder(false);
        this.grq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grq.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gqD = aVar;
            this.grq.startLoad(aVar.aCp, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bPP() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.grn != null) {
            this.grn.endAnimation();
        }
        if (this.gro != null) {
            this.gro.endAnimation();
        }
    }
}
