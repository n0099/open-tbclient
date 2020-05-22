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
    private f fSK;
    private ILiveMultiBeautyView fSL;
    private h fSM = new h() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
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
        this.fSK = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bge = alaLiveRecorder;
        if (av.b(com.baidu.live.v.a.Ge().aYP)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.asG = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fSL = (ILiveMultiBeautyView) runTask.getData();
                this.fSL.setArModel(fVar.fTE);
            }
        } else if (av.a(com.baidu.live.v.a.Ge().aYP)) {
            this.fSL = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.fSL.setBdPageContext(this.fSK.pageContext);
        this.fSL.setOnEffectSelectedListener(this.fSM);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.fSL != null) {
            if (z) {
                this.fSL.vb();
            } else if (av.b(com.baidu.live.v.a.Ge().aYP)) {
                this.fSL.setViewData();
            } else if (av.a(com.baidu.live.v.a.Ge().aYP)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.fTm = 40;
                dVar.fTo = 5;
                dVar.fTp = 50;
                dVar.fTq = 50;
                dVar.Cp(com.baidu.live.c.uN().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.fSL).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bAU() {
        if (this.fSL != null) {
            this.fSL.vc();
        }
    }

    public void setVisible(int i) {
        if (this.fSL != null) {
            this.fSL.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.fSL != null) {
            if (this.fSL.getParent() != null) {
                ((ViewGroup) this.fSL.getParent()).removeView(this.fSL);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.fSL, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.fSL, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.fSL, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.fSL, layoutParams4);
            }
            this.fSL.setVisibility(0);
        }
    }

    public void kI(boolean z) {
        if (this.fSL != null) {
            if (z) {
                this.fSL.vc();
            }
            if (this.fSL.getParent() != null) {
                ((ViewGroup) this.fSL.getParent()).removeView(this.fSL);
            }
            com.baidu.live.ar.c.atc.asW = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
