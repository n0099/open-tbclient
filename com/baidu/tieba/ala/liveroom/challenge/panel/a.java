package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends e {
    private AlaChallengeWaveView fzO;
    private AlaChallengeWaveView fzP;
    private HeadImageView fzQ;
    private HeadImageView fzR;
    private com.baidu.live.challenge.a fzr;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.fzO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.fzP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.fzO.setWaveArray(new float[]{AlaChallengeWaveView.fBa, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fAY});
        this.fzP.setWaveArray(new float[]{AlaChallengeWaveView.fAY, AlaChallengeWaveView.fAZ, AlaChallengeWaveView.fBa});
        this.fzQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.fzQ.setIsRound(true);
        this.fzQ.setAutoChangeStyle(false);
        this.fzQ.setDrawBorder(false);
        this.fzQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzQ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.fzQ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.fzR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.fzR.setIsRound(true);
        this.fzR.setAutoChangeStyle(false);
        this.fzR.setDrawBorder(false);
        this.fzR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fzR.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.fzr = aVar;
            this.fzR.startLoad(aVar.apg, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bue() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.fzO != null) {
            this.fzO.endAnimation();
        }
        if (this.fzP != null) {
            this.fzP.endAnimation();
        }
    }
}
