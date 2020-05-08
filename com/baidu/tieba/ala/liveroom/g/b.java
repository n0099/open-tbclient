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
    public AlaLiveRecorder aYI;
    private f fEQ;
    private ILiveMultiBeautyView fER;
    private h fES = new h() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.h
        public void tW() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.h
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.aYI != null && AlaFilterAndBeautyData.anT != null && AlaFilterAndBeautyData.anT.get(beautyAdjustKey) != null) {
                b.this.aYI.onBeautyParamsChanged(f, AlaFilterAndBeautyData.anT.get(beautyAdjustKey).tO());
            }
        }

        @Override // com.baidu.live.ar.h
        public void tX() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.anT != null && AlaFilterAndBeautyData.anT.get(beautyAdjustKey) != null) {
                    a((AlaFilterAndBeautyData.anT.get(beautyAdjustKey).tN() * 1.0f) / 100.0f, beautyAdjustKey);
                }
            }
        }

        @Override // com.baidu.live.ar.h
        public void tY() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.anT != null && AlaFilterAndBeautyData.anT.get(beautyAdjustKey) != null) {
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
            if (b.this.aYI != null) {
                b.this.aYI.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.h
        public void onFilterSelected(String str, float f) {
            if (b.this.aYI != null) {
                b.this.aYI.onFilterSelected(str, f);
            }
        }

        @Override // com.baidu.live.ar.h
        public void n(int i, int i2) {
            if (b.this.aYI != null) {
                b.this.aYI.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void o(int i, int i2) {
            if (b.this.aYI != null) {
                b.this.aYI.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void p(int i, int i2) {
            if (b.this.aYI != null) {
                b.this.aYI.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.h
        public void q(int i, int i2) {
            if (b.this.aYI != null) {
                b.this.aYI.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.fEQ = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.aYI = alaLiveRecorder;
        if (aq.b(com.baidu.live.v.a.En().aRB)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.anM = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fER = (ILiveMultiBeautyView) runTask.getData();
                this.fER.setArModel(fVar.fFK);
            }
        } else if (aq.a(com.baidu.live.v.a.En().aRB)) {
            this.fER = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.fER.setBdPageContext(this.fEQ.pageContext);
        this.fER.setOnEffectSelectedListener(this.fES);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.fER != null) {
            if (z) {
                this.fER.tU();
            } else if (aq.b(com.baidu.live.v.a.En().aRB)) {
                this.fER.setViewData();
            } else if (aq.a(com.baidu.live.v.a.En().aRB)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.fFs = 40;
                dVar.fFu = 5;
                dVar.fFv = 50;
                dVar.fFw = 50;
                dVar.AH(com.baidu.live.c.tG().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.fER).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void buV() {
        if (this.fER != null) {
            this.fER.tV();
        }
    }

    public void setVisible(int i) {
        if (this.fER != null) {
            this.fER.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.fER != null) {
            if (this.fER.getParent() != null) {
                ((ViewGroup) this.fER.getParent()).removeView(this.fER);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.fER, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.fER, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.fER, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.fER, layoutParams4);
            }
            this.fER.setVisibility(0);
        }
    }

    public void ko(boolean z) {
        if (this.fER != null) {
            if (z) {
                this.fER.tV();
            }
            if (this.fER.getParent() != null) {
                ((ViewGroup) this.fER.getParent()).removeView(this.fER);
            }
            com.baidu.live.ar.c.aoi.aoc = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
