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
    private com.baidu.live.challenge.a gqH;
    private AlaChallengeWaveView grr;
    private AlaChallengeWaveView grs;
    private HeadImageView grt;
    private HeadImageView gru;

    public a(Context context, m mVar) {
        super(context, mVar);
        this.grr = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.grs = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.grr.setWaveArray(new float[]{AlaChallengeWaveView.gsK, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsI});
        this.grs.setWaveArray(new float[]{AlaChallengeWaveView.gsI, AlaChallengeWaveView.gsJ, AlaChallengeWaveView.gsK});
        this.grt = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.grt.setIsRound(true);
        this.grt.setAutoChangeStyle(false);
        this.grt.setDrawBorder(false);
        this.grt.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.grt.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.grt.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.gru = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.gru.setIsRound(true);
        this.gru.setAutoChangeStyle(false);
        this.gru.setDrawBorder(false);
        this.gru.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gru.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.gqH = aVar;
            this.gru.startLoad(aVar.aCr, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int bPQ() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.grr != null) {
            this.grr.endAnimation();
        }
        if (this.grs != null) {
            this.grs.endAnimation();
        }
    }
}
