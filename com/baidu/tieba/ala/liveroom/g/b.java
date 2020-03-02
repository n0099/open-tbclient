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
    private f eZM;
    private ILiveMultiBeautyView eZN;
    public AlaLiveRecorder eZO;
    private com.baidu.live.ar.e eZP = new com.baidu.live.ar.e() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.e
        public void pD() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.e
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.eZO != null && AlaFilterAndBeautyData.VL != null && AlaFilterAndBeautyData.VL.get(beautyAdjustKey) != null) {
                b.this.eZO.onBeautyParamsChanged(f, AlaFilterAndBeautyData.VL.get(beautyAdjustKey).py());
            }
        }

        @Override // com.baidu.live.ar.e
        public void onBlurLevelSelected(int i) {
            if (b.this.eZO != null) {
                b.this.eZO.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.e
        public void onFilterSelected(String str) {
            if (b.this.eZO != null) {
                b.this.eZO.onFilterSelected(str);
            }
        }

        @Override // com.baidu.live.ar.e
        public void o(int i, int i2) {
            if (b.this.eZO != null) {
                b.this.eZO.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void p(int i, int i2) {
            if (b.this.eZO != null) {
                b.this.eZO.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void q(int i, int i2) {
            if (b.this.eZO != null) {
                b.this.eZO.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void r(int i, int i2) {
            if (b.this.eZO != null) {
                b.this.eZO.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.eZM = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.eZO = alaLiveRecorder;
        if (an.b(com.baidu.live.v.a.zl().axC)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.VH = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eZN = (ILiveMultiBeautyView) runTask.getData();
                this.eZN.setArModel(fVar.faL);
            }
        } else if (an.a(com.baidu.live.v.a.zl().axC)) {
            this.eZN = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.eZN.setBdPageContext(this.eZM.pageContext);
        this.eZN.setOnEffectSelectedListener(this.eZP);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.eZN != null) {
            if (z) {
                this.eZN.pB();
            } else if (an.b(com.baidu.live.v.a.zl().axC)) {
                this.eZN.setViewData();
            } else if (an.a(com.baidu.live.v.a.zl().axC)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.fat = 40;
                dVar.fav = 5;
                dVar.faw = 50;
                dVar.fax = 50;
                dVar.yV(com.baidu.live.c.pr().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.eZN).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bly() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (this.eZO != null) {
            if (an.b(com.baidu.live.v.a.zl().axC)) {
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    this.eZP.a((com.baidu.live.ar.b.VT.cS(beautyAdjustKey.getJsonKey()) * 1.0f) / 100.0f, beautyAdjustKey);
                }
                if (!TextUtils.isEmpty(com.baidu.live.ar.b.VT.VP)) {
                    this.eZP.onFilterSelected(com.baidu.live.ar.b.VT.VP);
                }
            } else if (an.a(com.baidu.live.v.a.zl().axC)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.yV(com.baidu.live.c.pr().getString("ala_beauty_5.4_config_str", ""));
                this.eZO.onBlurLevelSelected(dVar.fav);
                this.eZO.onFilterSelected(dVar.mFilterName);
                this.eZO.onColorLevelSelected((dVar.fat * 1.0f) / 100.0f);
                this.eZO.onCheekThinSelected((dVar.fax * 1.0f) / 100.0f);
                this.eZO.onEnlargeEyeSelected((dVar.faw * 1.0f) / 100.0f);
                this.eZO.onRedLevelSelected((dVar.fau * 1.0f) / 100.0f);
                this.eZO.onChinSelected((dVar.fay * 1.0f) / 100.0f);
                this.eZO.onNoseSelected((dVar.faz * 1.0f) / 100.0f);
            }
        }
    }

    public void blz() {
        if (this.eZN != null) {
            this.eZN.pC();
        }
    }

    public void setVisible(int i) {
        if (this.eZN != null) {
            this.eZN.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.eZN != null) {
            if (this.eZN.getParent() != null) {
                ((ViewGroup) this.eZN.getParent()).removeView(this.eZN);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.eZN, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.eZN, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.eZN, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.eZN, layoutParams4);
            }
            this.eZN.setVisibility(0);
        }
    }

    public void jl(boolean z) {
        if (this.eZN != null) {
            if (z) {
                this.eZN.pC();
            }
            if (this.eZN.getParent() != null) {
                ((ViewGroup) this.eZN.getParent()).removeView(this.eZN);
            }
            com.baidu.live.ar.b.VT.VQ = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
