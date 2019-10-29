package com.baidu.tieba.ala.liveroom.g;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.liveRecorder.video.AlaLiveVideoConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
/* loaded from: classes6.dex */
public class b {
    private AlaLiveMultiBeautyView efi;
    private Context mContext;
    private ViewGroup mParent;

    /* loaded from: classes6.dex */
    public interface a {
        void aRy();

        void aY(int i, int i2);

        void aZ(int i, int i2);

        void ba(int i, int i2);

        void bb(int i, int i2);

        void onBlurLevelSelected(int i);

        void onFilterSelected(String str);
    }

    public b(ViewGroup viewGroup, Context context) {
        this.efi = new AlaLiveMultiBeautyView(context);
        this.mContext = context;
        this.mParent = viewGroup;
    }

    public void setOnEffectSelectedListener(a aVar) {
        this.efi.setOnEffectSelectedListener(aVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        com.baidu.tieba.ala.liveroom.data.c cVar = new com.baidu.tieba.ala.liveroom.data.c();
        cVar.tI(com.baidu.live.c.np().getString("ala_beauty_5.4_config_str", ""));
        this.efi.setViewData(cVar, alaLiveVideoConfig);
    }

    public void aRx() {
        this.efi.aWx();
    }

    public void b(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.efi != null && this.efi.getParent() != null) {
            ((ViewGroup) this.efi.getParent()).removeView(this.efi);
        }
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) && (this.mContext instanceof Activity)) {
            if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                this.mParent.addView(this.efi, layoutParams);
            } else {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams2.gravity = 5;
                this.mParent.addView(this.efi, layoutParams2);
            }
        } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.gravity = 80;
            this.mParent.addView(this.efi, layoutParams3);
        } else {
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
            layoutParams4.gravity = 5;
            this.mParent.addView(this.efi, layoutParams4);
        }
        a(alaLiveVideoConfig);
    }

    public void hK(boolean z) {
        if (this.efi != null) {
            if (z) {
                this.efi.aWx();
            }
            if (this.efi.getParent() != null) {
                ((ViewGroup) this.efi.getParent()).removeView(this.efi);
            }
        }
    }
}
