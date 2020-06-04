package com.baidu.tieba.ala.liveroom.g;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.h;
import com.baidu.live.data.av;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
/* loaded from: classes3.dex */
public class b {
    public AlaLiveRecorder bge;
    private f fSV;
    private ILiveMultiBeautyView fSW;
    private h fSX = new h() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.h
        public void vd() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.h
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.bge != null && AlaFilterAndBeautyData.asN != null && AlaFilterAndBeautyData.asN.get(beautyAdjustKey) != null) {
                b.this.bge.onBeautyParamsChanged(f, AlaFilterAndBeautyData.asN.get(beautyAdjustKey).uV());
            }
        }

        @Override // com.baidu.live.ar.h
        public void ve() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.asN != null && AlaFilterAndBeautyData.asN.get(beautyAdjustKey) != null) {
                    a((AlaFilterAndBeautyData.asN.get(beautyAdjustKey).uU() * 1.0f) / 100.0f, beautyAdjustKey);
                }
            }
        }

        @Override // com.baidu.live.ar.h
        public void vf() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.asN != null && AlaFilterAndBeautyData.asN.get(beautyAdjustKey) != null) {
                    if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth)) {
                        a(0.5f, beautyAdjustKey);
                    } else {
                        a(0.0f, beautyAdjustKey);
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.h
        public void onBlurLevelSelected(int i) {
            if (b.this.bge != null) {
                b.this.bge.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.h
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bge != null) {
                b.this.bge.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.h
        public void n(int i, int i2) {
            if (b.this.bge != null) {
                b.this.bge.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void o(int i, int i2) {
            if (b.this.bge != null) {
                b.this.bge.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void p(int i, int i2) {
            if (b.this.bge != null) {
                b.this.bge.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void q(int i, int i2) {
            if (b.this.bge != null) {
                b.this.bge.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.fSV = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bge = alaLiveRecorder;
        if (av.b(com.baidu.live.v.a.Ge().aYP)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.asG = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fSW = (ILiveMultiBeautyView) runTask.getData();
                this.fSW.setArModel(fVar.fTP);
            }
        } else if (av.a(com.baidu.live.v.a.Ge().aYP)) {
            this.fSW = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.fSW.setBdPageContext(this.fSV.pageContext);
        this.fSW.setOnEffectSelectedListener(this.fSX);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.fSW != null) {
            if (z) {
                this.fSW.vb();
            } else if (av.b(com.baidu.live.v.a.Ge().aYP)) {
                this.fSW.setViewData();
            } else if (av.a(com.baidu.live.v.a.Ge().aYP)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.fTx = 40;
                dVar.fTz = 5;
                dVar.fTA = 50;
                dVar.fTB = 50;
                dVar.Cp(com.baidu.live.c.uN().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.fSW).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bAW() {
        if (this.fSW != null) {
            this.fSW.vc();
        }
    }

    public void setVisible(int i) {
        if (this.fSW != null) {
            this.fSW.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.fSW != null) {
            if (this.fSW.getParent() != null) {
                ((ViewGroup) this.fSW.getParent()).removeView(this.fSW);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.fSW, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.fSW, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.fSW, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.fSW, layoutParams4);
            }
            this.fSW.setVisibility(0);
        }
    }

    public void kI(boolean z) {
        if (this.fSW != null) {
            if (z) {
                this.fSW.vc();
            }
            if (this.fSW.getParent() != null) {
                ((ViewGroup) this.fSW.getParent()).removeView(this.fSW);
            }
            com.baidu.live.ar.c.atc.asW = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
