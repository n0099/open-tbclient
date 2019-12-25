package com.baidu.tieba.ala.liveroom.g;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
/* loaded from: classes2.dex */
public class b {
    private AlaLiveMultiBeautyView eUm;
    private Context mContext;
    private ViewGroup mParent;

    /* loaded from: classes2.dex */
    public interface a {
        void biX();

        void bm(int i, int i2);

        void bn(int i, int i2);

        void bo(int i, int i2);

        void bp(int i, int i2);

        void onBlurLevelSelected(int i);

        void onFilterSelected(String str);
    }

    public b(ViewGroup viewGroup, Context context) {
        this.eUm = new AlaLiveMultiBeautyView(context);
        this.mContext = context;
        this.mParent = viewGroup;
    }

    public void setOnEffectSelectedListener(a aVar) {
        this.eUm.setOnEffectSelectedListener(aVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        com.baidu.tieba.ala.liveroom.data.c cVar = new com.baidu.tieba.ala.liveroom.data.c();
        cVar.yx(com.baidu.live.c.oI().getString("ala_beauty_5.4_config_str", ""));
        this.eUm.setViewData(cVar, alaLiveVideoConfig);
    }

    public void biW() {
        this.eUm.boj();
    }

    public void b(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.eUm != null && this.eUm.getParent() != null) {
            ((ViewGroup) this.eUm.getParent()).removeView(this.eUm);
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
            if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                this.mParent.addView(this.eUm, layoutParams);
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams2.gravity = 5;
                this.mParent.addView(this.eUm, layoutParams2);
            }
        } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            this.mParent.addView(this.eUm, layoutParams3);
        } else {
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams4.gravity = 5;
            this.mParent.addView(this.eUm, layoutParams4);
        }
        a(alaLiveVideoConfig);
    }

    public void iZ(boolean z) {
        if (this.eUm != null) {
            if (z) {
                this.eUm.boj();
            }
            if (this.eUm.getParent() != null) {
                ((ViewGroup) this.eUm.getParent()).removeView(this.eUm);
            }
        }
    }
}
