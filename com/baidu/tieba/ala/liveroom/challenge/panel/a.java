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
    private AlaChallengeWaveView eUP;
    private AlaChallengeWaveView eUQ;
    private HeadImageView eUR;
    private HeadImageView eUS;
    private com.baidu.live.challenge.a eUn;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.eUP = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eUQ = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.eUP.setWaveArray(new float[]{AlaChallengeWaveView.eWb, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eVZ});
        this.eUQ.setWaveArray(new float[]{AlaChallengeWaveView.eVZ, AlaChallengeWaveView.eWa, AlaChallengeWaveView.eWb});
        this.eUR = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eUR.setIsRound(true);
        this.eUR.setAutoChangeStyle(false);
        this.eUR.setDrawBorder(false);
        this.eUR.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUR.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eUR.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eUS = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eUS.setIsRound(true);
        this.eUS.setAutoChangeStyle(false);
        this.eUS.setDrawBorder(false);
        this.eUS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eUS.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eUn = aVar;
            this.eUS.startLoad(aVar.WU, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkF() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eUP != null) {
            this.eUP.endAnimation();
        }
        if (this.eUQ != null) {
            this.eUQ.endAnimation();
        }
    }
}
