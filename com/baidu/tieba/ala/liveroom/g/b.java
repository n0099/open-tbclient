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
    private f eZL;
    private ILiveMultiBeautyView eZM;
    public AlaLiveRecorder eZN;
    private com.baidu.live.ar.e eZO = new com.baidu.live.ar.e() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.e
        public void pD() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.e
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.eZN != null && AlaFilterAndBeautyData.VL != null && AlaFilterAndBeautyData.VL.get(beautyAdjustKey) != null) {
                b.this.eZN.onBeautyParamsChanged(f, AlaFilterAndBeautyData.VL.get(beautyAdjustKey).py());
            }
        }

        @Override // com.baidu.live.ar.e
        public void onBlurLevelSelected(int i) {
            if (b.this.eZN != null) {
                b.this.eZN.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.e
        public void onFilterSelected(String str) {
            if (b.this.eZN != null) {
                b.this.eZN.onFilterSelected(str);
            }
        }

        @Override // com.baidu.live.ar.e
        public void o(int i, int i2) {
            if (b.this.eZN != null) {
                b.this.eZN.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void p(int i, int i2) {
            if (b.this.eZN != null) {
                b.this.eZN.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void q(int i, int i2) {
            if (b.this.eZN != null) {
                b.this.eZN.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void r(int i, int i2) {
            if (b.this.eZN != null) {
                b.this.eZN.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.eZL = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.eZN = alaLiveRecorder;
        if (an.b(com.baidu.live.v.a.zj().axB)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.VH = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eZM = (ILiveMultiBeautyView) runTask.getData();
                this.eZM.setArModel(fVar.faK);
            }
        } else if (an.a(com.baidu.live.v.a.zj().axB)) {
            this.eZM = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.eZM.setBdPageContext(this.eZL.pageContext);
        this.eZM.setOnEffectSelectedListener(this.eZO);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.eZM != null) {
            if (z) {
                this.eZM.pB();
            } else if (an.b(com.baidu.live.v.a.zj().axB)) {
                this.eZM.setViewData();
            } else if (an.a(com.baidu.live.v.a.zj().axB)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.fas = 40;
                dVar.fau = 5;
                dVar.fav = 50;
                dVar.faw = 50;
                dVar.yV(com.baidu.live.c.pr().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.eZM).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void blw() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (this.eZN != null) {
            if (an.b(com.baidu.live.v.a.zj().axB)) {
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    this.eZO.a((com.baidu.live.ar.b.VT.cS(beautyAdjustKey.getJsonKey()) * 1.0f) / 100.0f, beautyAdjustKey);
                }
                if (!TextUtils.isEmpty(com.baidu.live.ar.b.VT.VP)) {
                    this.eZO.onFilterSelected(com.baidu.live.ar.b.VT.VP);
                }
            } else if (an.a(com.baidu.live.v.a.zj().axB)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.yV(com.baidu.live.c.pr().getString("ala_beauty_5.4_config_str", ""));
                this.eZN.onBlurLevelSelected(dVar.fau);
                this.eZN.onFilterSelected(dVar.mFilterName);
                this.eZN.onColorLevelSelected((dVar.fas * 1.0f) / 100.0f);
                this.eZN.onCheekThinSelected((dVar.faw * 1.0f) / 100.0f);
                this.eZN.onEnlargeEyeSelected((dVar.fav * 1.0f) / 100.0f);
                this.eZN.onRedLevelSelected((dVar.fat * 1.0f) / 100.0f);
                this.eZN.onChinSelected((dVar.fax * 1.0f) / 100.0f);
                this.eZN.onNoseSelected((dVar.fay * 1.0f) / 100.0f);
            }
        }
    }

    public void blx() {
        if (this.eZM != null) {
            this.eZM.pC();
        }
    }

    public void setVisible(int i) {
        if (this.eZM != null) {
            this.eZM.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.eZM != null) {
            if (this.eZM.getParent() != null) {
                ((ViewGroup) this.eZM.getParent()).removeView(this.eZM);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.eZM, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.eZM, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.eZM, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.eZM, layoutParams4);
            }
            this.eZM.setVisibility(0);
        }
    }

    public void jl(boolean z) {
        if (this.eZM != null) {
            if (z) {
                this.eZM.pC();
            }
            if (this.eZM.getParent() != null) {
                ((ViewGroup) this.eZM.getParent()).removeView(this.eZM);
            }
            com.baidu.live.ar.b.VT.VQ = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
