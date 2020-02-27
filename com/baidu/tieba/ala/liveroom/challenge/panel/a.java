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
    private AlaChallengeWaveView eUO;
    private AlaChallengeWaveView eUP;
    private HeadImageView eUQ;
    private HeadImageView eUR;
    private com.baidu.live.challenge.a eUm;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.eUO = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eUP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.eUO.setWaveArray(new float[]{AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eVY});
        this.eUP.setWaveArray(new float[]{AlaChallengeWaveView.eVY, AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa});
        this.eUQ = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eUQ.setIsRound(true);
        this.eUQ.setAutoChangeStyle(false);
        this.eUQ.setDrawBorder(false);
        this.eUQ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUQ.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eUQ.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eUR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eUR.setIsRound(true);
        this.eUR.setAutoChangeStyle(false);
        this.eUR.setDrawBorder(false);
        this.eUR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUR.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eUm = aVar;
            this.eUR.startLoad(aVar.WU, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkD() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eUO != null) {
            this.eUO.endAnimation();
        }
        if (this.eUP != null) {
            this.eUP.endAnimation();
        }
    }
}
