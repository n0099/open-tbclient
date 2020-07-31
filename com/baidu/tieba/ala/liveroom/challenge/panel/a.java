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
    private com.baidu.live.challenge.a gev;
    private AlaChallengeWaveView gff;
    private AlaChallengeWaveView gfg;
    private HeadImageView gfh;
    private HeadImageView gfi;

    public a(Context context, m mVar) {
        super(context, mVar);
        this.gff = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.gfg = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.gff.setWaveArray(new float[]{AlaChallengeWaveView.ggx, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggv});
        this.gfg.setWaveArray(new float[]{AlaChallengeWaveView.ggv, AlaChallengeWaveView.ggw, AlaChallengeWaveView.ggx});
        this.gfh = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.gfh.setIsRound(true);
        this.gfh.setAutoChangeStyle(false);
        this.gfh.setDrawBorder(false);
        this.gfh.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfh.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.gfh.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gfi = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gfi.setIsRound(true);
        this.gfi.setAutoChangeStyle(false);
        this.gfi.setDrawBorder(false);
        this.gfi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gfi.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gev = aVar;
            this.gfi.startLoad(aVar.axn, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bGk() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.gff != null) {
            this.gff.endAnimation();
        }
        if (this.gfg != null) {
            this.gfg.endAnimation();
        }
    }
}
