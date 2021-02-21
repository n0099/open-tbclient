package com.baidu.tieba.ala.liveroom.challenge.panel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.view.HeadImageView;
/* loaded from: classes11.dex */
public class a extends g {
    private com.baidu.live.challenge.a hvr;
    private AlaChallengeWaveView hwg;
    private AlaChallengeWaveView hwh;
    private HeadImageView hwi;
    private HeadImageView hwj;

    public a(Context context, n nVar) {
        super(context, nVar);
        this.hwg = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_left);
        this.hwh = (AlaChallengeWaveView) this.mRootView.findViewById(a.f.ala_challenge_wave_right);
        this.hwg.setWaveArray(new float[]{AlaChallengeWaveView.hxx, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxv});
        this.hwh.setWaveArray(new float[]{AlaChallengeWaveView.hxv, AlaChallengeWaveView.hxw, AlaChallengeWaveView.hxx});
        this.hwi = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_left_header);
        this.hwi.setIsRound(true);
        this.hwi.setAutoChangeStyle(false);
        this.hwi.setDrawBorder(false);
        this.hwi.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwi.setDefaultBgResource(a.e.icon_challenge_default_avatar);
        this.hwi.startLoad(TbadkCoreApplication.getCurrentPortrait(), 25, false);
        this.hwj = (HeadImageView) this.mRootView.findViewById(a.f.ala_challenge_direct_right_header);
        this.hwj.setIsRound(true);
        this.hwj.setAutoChangeStyle(false);
        this.hwj.setDrawBorder(false);
        this.hwj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwj.setDefaultBgResource(a.e.icon_challenge_default_avatar);
    }

    public void d(com.baidu.live.challenge.a aVar) {
        if (aVar != null) {
            this.hvr = aVar;
            this.hwj.startLoad(aVar.aFw, 25, false);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected View createView() {
        return LayoutInflater.from(this.mContext).inflate(a.g.ala_challenge_accept_result_view, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected int cdt() {
        return this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds510);
    }

    @Override // com.baidu.tieba.ala.liveroom.challenge.panel.g
    protected void hide() {
        super.hide();
        if (this.hwg != null) {
            this.hwg.endAnimation();
        }
        if (this.hwh != null) {
            this.hwh.endAnimation();
        }
    }
}
