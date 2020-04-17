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
import com.baidu.live.data.aq;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
/* loaded from: classes3.dex */
public class b {
    public AlaLiveRecorder aYD;
    private f fEL;
    private ILiveMultiBeautyView fEM;
    private h fEN = new h() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.h
        public void tX() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.h
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.aYD != null && AlaFilterAndBeautyData.anN != null && AlaFilterAndBeautyData.anN.get(beautyAdjustKey) != null) {
                b.this.aYD.onBeautyParamsChanged(f, AlaFilterAndBeautyData.anN.get(beautyAdjustKey).tP());
            }
        }

        @Override // com.baidu.live.ar.h
        public void tY() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.anN != null && AlaFilterAndBeautyData.anN.get(beautyAdjustKey) != null) {
                    a((AlaFilterAndBeautyData.anN.get(beautyAdjustKey).tO() * 1.0f) / 100.0f, beautyAdjustKey);
                }
            }
        }

        @Override // com.baidu.live.ar.h
        public void tZ() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.anN != null && AlaFilterAndBeautyData.anN.get(beautyAdjustKey) != null) {
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
            if (b.this.aYD != null) {
                b.this.aYD.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.h
        public void onFilterSelected(String str, float f) {
            if (b.this.aYD != null) {
                b.this.aYD.onFilterSelected(str, f);
            }
        }

        @Override // com.baidu.live.ar.h
        public void n(int i, int i2) {
            if (b.this.aYD != null) {
                b.this.aYD.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void o(int i, int i2) {
            if (b.this.aYD != null) {
                b.this.aYD.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void p(int i, int i2) {
            if (b.this.aYD != null) {
                b.this.aYD.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void q(int i, int i2) {
            if (b.this.aYD != null) {
                b.this.aYD.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.fEL = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.aYD = alaLiveRecorder;
        if (aq.b(com.baidu.live.v.a.Eo().aRw)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.anG = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fEM = (ILiveMultiBeautyView) runTask.getData();
                this.fEM.setArModel(fVar.fFF);
            }
        } else if (aq.a(com.baidu.live.v.a.Eo().aRw)) {
            this.fEM = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.fEM.setBdPageContext(this.fEL.pageContext);
        this.fEM.setOnEffectSelectedListener(this.fEN);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.fEM != null) {
            if (z) {
                this.fEM.tV();
            } else if (aq.b(com.baidu.live.v.a.Eo().aRw)) {
                this.fEM.setViewData();
            } else if (aq.a(com.baidu.live.v.a.Eo().aRw)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.fFn = 40;
                dVar.fFp = 5;
                dVar.fFq = 50;
                dVar.fFr = 50;
                dVar.AE(com.baidu.live.c.tH().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.fEM).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void buX() {
        if (this.fEM != null) {
            this.fEM.tW();
        }
    }

    public void setVisible(int i) {
        if (this.fEM != null) {
            this.fEM.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.fEM != null) {
            if (this.fEM.getParent() != null) {
                ((ViewGroup) this.fEM.getParent()).removeView(this.fEM);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.fEM, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.fEM, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.fEM, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.fEM, layoutParams4);
            }
            this.fEM.setVisibility(0);
        }
    }

    public void ko(boolean z) {
        if (this.fEM != null) {
            if (z) {
                this.fEM.tW();
            }
            if (this.fEM.getParent() != null) {
                ((ViewGroup) this.fEM.getParent()).removeView(this.fEM);
            }
            com.baidu.live.ar.c.aoc.anW = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
