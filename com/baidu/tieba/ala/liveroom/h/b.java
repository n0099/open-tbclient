package com.baidu.tieba.ala.liveroom.h;

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
import com.baidu.live.data.am;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
/* loaded from: classes2.dex */
public class b {
    private f eVV;
    private ILiveMultiBeautyView eVW;
    public AlaLiveRecorder eVX;
    private com.baidu.live.ar.e eVY = new com.baidu.live.ar.e() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.e
        public void oS() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913162));
        }

        @Override // com.baidu.live.ar.e
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.eVX != null && AlaFilterAndBeautyData.Ub != null && AlaFilterAndBeautyData.Ub.get(beautyAdjustKey) != null) {
                b.this.eVX.onBeautyChanged(f, AlaFilterAndBeautyData.Ub.get(beautyAdjustKey).oN());
            }
        }

        @Override // com.baidu.live.ar.e
        public void onBlurLevelSelected(int i) {
            if (b.this.eVX != null) {
                b.this.eVX.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.e
        public void onFilterSelected(String str) {
            if (b.this.eVX != null) {
                b.this.eVX.onFilterSelected(str);
            }
        }

        @Override // com.baidu.live.ar.e
        public void n(int i, int i2) {
            if (b.this.eVX != null) {
                b.this.eVX.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void o(int i, int i2) {
            if (b.this.eVX != null) {
                b.this.eVX.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void p(int i, int i2) {
            if (b.this.eVX != null) {
                b.this.eVX.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void q(int i, int i2) {
            if (b.this.eVX != null) {
                b.this.eVX.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.eVV = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.eVX = alaLiveRecorder;
        if (am.b(com.baidu.live.s.a.wR().atk)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.TX = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913160, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eVW = (ILiveMultiBeautyView) runTask.getData();
                this.eVW.setArModel(fVar.eWU);
            }
        } else if (am.a(com.baidu.live.s.a.wR().atk)) {
            this.eVW = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.eVW.setBdPageContext(this.eVV.pageContext);
        this.eVW.setOnEffectSelectedListener(this.eVY);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.eVW != null) {
            if (z) {
                this.eVW.oQ();
            } else if (am.b(com.baidu.live.s.a.wR().atk)) {
                this.eVW.setViewData();
            } else if (am.a(com.baidu.live.s.a.wR().atk)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.eWD = 40;
                dVar.eWF = 5;
                dVar.eWG = 50;
                dVar.eWH = 50;
                dVar.yB(com.baidu.live.c.oJ().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.eVW).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bjI() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (this.eVX != null) {
            if (am.b(com.baidu.live.s.a.wR().atk)) {
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    this.eVY.a((com.baidu.live.ar.b.Uk.cJ(beautyAdjustKey.getJsonKey()) * 1.0f) / 100.0f, beautyAdjustKey);
                }
                if (!TextUtils.isEmpty(com.baidu.live.ar.b.Uk.Ug)) {
                    this.eVY.onFilterSelected(com.baidu.live.ar.b.Uk.Ug);
                }
            } else if (am.a(com.baidu.live.s.a.wR().atk)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.yB(com.baidu.live.c.oJ().getString("ala_beauty_5.4_config_str", ""));
                this.eVX.onBlurLevelSelected(dVar.eWF);
                this.eVX.onFilterSelected(dVar.mFilterName);
                this.eVX.onColorLevelSelected((dVar.eWD * 1.0f) / 100.0f);
                this.eVX.onCheekThinSelected((dVar.eWH * 1.0f) / 100.0f);
                this.eVX.onEnlargeEyeSelected((dVar.eWG * 1.0f) / 100.0f);
                this.eVX.onRedLevelSelected((dVar.eWE * 1.0f) / 100.0f);
                this.eVX.onChinSelected((dVar.eWI * 1.0f) / 100.0f);
                this.eVX.onNoseSelected((dVar.eWJ * 1.0f) / 100.0f);
            }
        }
    }

    public void bjJ() {
        if (this.eVW != null) {
            this.eVW.oR();
        }
    }

    public void setVisible(int i) {
        if (this.eVW != null) {
            this.eVW.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.eVW != null) {
            if (this.eVW.getParent() != null) {
                ((ViewGroup) this.eVW.getParent()).removeView(this.eVW);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.eVW, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.eVW, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.eVW, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.eVW, layoutParams4);
            }
            this.eVW.setVisibility(0);
        }
    }

    public void ji(boolean z) {
        if (this.eVW != null) {
            if (z) {
                this.eVW.oR();
            }
            if (this.eVW.getParent() != null) {
                ((ViewGroup) this.eVW.getParent()).removeView(this.eVW);
            }
            com.baidu.live.ar.b.Uk.Uh = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
