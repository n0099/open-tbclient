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
    private com.baidu.live.challenge.a eUA;
    private AlaChallengeWaveView eVc;
    private AlaChallengeWaveView eVd;
    private HeadImageView eVe;
    private HeadImageView eVf;

    public a(Context context, k kVar) {
        super(context, kVar);
        this.eVc = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_left);
        this.eVd = (AlaChallengeWaveView) this.mRootView.findViewById(a.g.ala_challenge_wave_right);
        this.eVc.setWaveArray(new float[]{AlaChallengeWaveView.eWo, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWm});
        this.eVd.setWaveArray(new float[]{AlaChallengeWaveView.eWm, AlaChallengeWaveView.eWn, AlaChallengeWaveView.eWo});
        this.eVe = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_left_header);
        this.eVe.setIsRound(true);
        this.eVe.setAutoChangeStyle(false);
        this.eVe.setDrawBorder(false);
        this.eVe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVe.setDefaultBgResource(a.f.icon_challenge_default_avatar);
        this.eVe.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.eVf = (HeadImageView) this.mRootView.findViewById(a.g.ala_challenge_direct_right_header);
        this.eVf.setIsRound(true);
        this.eVf.setAutoChangeStyle(false);
        this.eVf.setDrawBorder(false);
        this.eVf.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eVf.setDefaultBgResource(a.f.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.eUA = aVar;
            this.eVf.startLoad(aVar.WU, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.h.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected int bkG() {
        return this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.e
    protected void hide() {
        super.hide();
        if (this.eVc != null) {
            this.eVc.endAnimation();
        }
        if (this.eVd != null) {
            this.eVd.endAnimation();
        }
    }
}
