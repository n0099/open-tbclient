package com.baidu.tieba.ala.liveroom.g;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.data.an;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
/* loaded from: classes3.dex */
public class b {
    private f eZZ;
    private ILiveMultiBeautyView faa;
    public AlaLiveRecorder fab;
    private com.baidu.live.ar.e fac = new com.baidu.live.ar.e() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.e
        public void pD() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.e
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.fab != null && AlaFilterAndBeautyData.VL != null && AlaFilterAndBeautyData.VL.get(beautyAdjustKey) != null) {
                b.this.fab.onBeautyParamsChanged(f, AlaFilterAndBeautyData.VL.get(beautyAdjustKey).py());
            }
        }

        @Override // com.baidu.live.ar.e
        public void onBlurLevelSelected(int i) {
            if (b.this.fab != null) {
                b.this.fab.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.e
        public void onFilterSelected(String str) {
            if (b.this.fab != null) {
                b.this.fab.onFilterSelected(str);
            }
        }

        @Override // com.baidu.live.ar.e
        public void o(int i, int i2) {
            if (b.this.fab != null) {
                b.this.fab.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void p(int i, int i2) {
            if (b.this.fab != null) {
                b.this.fab.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void q(int i, int i2) {
            if (b.this.fab != null) {
                b.this.fab.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void r(int i, int i2) {
            if (b.this.fab != null) {
                b.this.fab.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.eZZ = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.fab = alaLiveRecorder;
        if (an.b(com.baidu.live.v.a.zl().axD)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.VH = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.faa = (ILiveMultiBeautyView) runTask.getData();
                this.faa.setArModel(fVar.faY);
            }
        } else if (an.a(com.baidu.live.v.a.zl().axD)) {
            this.faa = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.faa.setBdPageContext(this.eZZ.pageContext);
        this.faa.setOnEffectSelectedListener(this.fac);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.faa != null) {
            if (z) {
                this.faa.pB();
            } else if (an.b(com.baidu.live.v.a.zl().axD)) {
                this.faa.setViewData();
            } else if (an.a(com.baidu.live.v.a.zl().axD)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.faG = 40;
                dVar.faI = 5;
                dVar.faJ = 50;
                dVar.faK = 50;
                dVar.yW(com.baidu.live.c.pr().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.faa).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void blz() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (this.fab != null) {
            if (an.b(com.baidu.live.v.a.zl().axD)) {
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    this.fac.a((com.baidu.live.ar.b.VT.cS(beautyAdjustKey.getJsonKey()) * 1.0f) / 100.0f, beautyAdjustKey);
                }
                if (!TextUtils.isEmpty(com.baidu.live.ar.b.VT.VP)) {
                    this.fac.onFilterSelected(com.baidu.live.ar.b.VT.VP);
                }
            } else if (an.a(com.baidu.live.v.a.zl().axD)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.yW(com.baidu.live.c.pr().getString("ala_beauty_5.4_config_str", ""));
                this.fab.onBlurLevelSelected(dVar.faI);
                this.fab.onFilterSelected(dVar.mFilterName);
                this.fab.onColorLevelSelected((dVar.faG * 1.0f) / 100.0f);
                this.fab.onCheekThinSelected((dVar.faK * 1.0f) / 100.0f);
                this.fab.onEnlargeEyeSelected((dVar.faJ * 1.0f) / 100.0f);
                this.fab.onRedLevelSelected((dVar.faH * 1.0f) / 100.0f);
                this.fab.onChinSelected((dVar.faL * 1.0f) / 100.0f);
                this.fab.onNoseSelected((dVar.faM * 1.0f) / 100.0f);
            }
        }
    }

    public void blA() {
        if (this.faa != null) {
            this.faa.pC();
        }
    }

    public void setVisible(int i) {
        if (this.faa != null) {
            this.faa.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.faa != null) {
            if (this.faa.getParent() != null) {
                ((ViewGroup) this.faa.getParent()).removeView(this.faa);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.faa, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.faa, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.faa, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.faa, layoutParams4);
            }
            this.faa.setVisibility(0);
        }
    }

    public void jl(boolean z) {
        if (this.faa != null) {
            if (z) {
                this.faa.pC();
            }
            if (this.faa.getParent() != null) {
                ((ViewGroup) this.faa.getParent()).removeView(this.faa);
            }
            com.baidu.live.ar.b.VT.VQ = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
