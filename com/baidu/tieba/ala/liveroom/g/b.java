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
    private com.baidu.live.ar.e faA = new com.baidu.live.ar.e() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.e
        public void pI() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.e
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (b.this.faz != null && AlaFilterAndBeautyData.VV != null && AlaFilterAndBeautyData.VV.get(beautyAdjustKey) != null) {
                b.this.faz.onBeautyParamsChanged(f, AlaFilterAndBeautyData.VV.get(beautyAdjustKey).pD());
            }
        }

        @Override // com.baidu.live.ar.e
        public void onBlurLevelSelected(int i) {
            if (b.this.faz != null) {
                b.this.faz.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.e
        public void onFilterSelected(String str) {
            if (b.this.faz != null) {
                b.this.faz.onFilterSelected(str);
            }
        }

        @Override // com.baidu.live.ar.e
        public void o(int i, int i2) {
            if (b.this.faz != null) {
                b.this.faz.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void p(int i, int i2) {
            if (b.this.faz != null) {
                b.this.faz.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void q(int i, int i2) {
            if (b.this.faz != null) {
                b.this.faz.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.e
        public void r(int i, int i2) {
            if (b.this.faz != null) {
                b.this.faz.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private f fax;
    private ILiveMultiBeautyView fay;
    public AlaLiveRecorder faz;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.fax = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.faz = alaLiveRecorder;
        if (an.b(com.baidu.live.v.a.zs().axR)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.VR = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fay = (ILiveMultiBeautyView) runTask.getData();
                this.fay.setArModel(fVar.fbw);
            }
        } else if (an.a(com.baidu.live.v.a.zs().axR)) {
            this.fay = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.fay.setBdPageContext(this.fax.pageContext);
        this.fay.setOnEffectSelectedListener(this.faA);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.fay != null) {
            if (z) {
                this.fay.pG();
            } else if (an.b(com.baidu.live.v.a.zs().axR)) {
                this.fay.setViewData();
            } else if (an.a(com.baidu.live.v.a.zs().axR)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.fbe = 40;
                dVar.fbg = 5;
                dVar.fbh = 50;
                dVar.fbi = 50;
                dVar.yW(com.baidu.live.c.pw().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.fay).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void blE() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        if (this.faz != null) {
            if (an.b(com.baidu.live.v.a.zs().axR)) {
                for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                    this.faA.a((com.baidu.live.ar.b.We.cR(beautyAdjustKey.getJsonKey()) * 1.0f) / 100.0f, beautyAdjustKey);
                }
                if (!TextUtils.isEmpty(com.baidu.live.ar.b.We.VZ)) {
                    this.faA.onFilterSelected(com.baidu.live.ar.b.We.VZ);
                }
            } else if (an.a(com.baidu.live.v.a.zs().axR)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.yW(com.baidu.live.c.pw().getString("ala_beauty_5.4_config_str", ""));
                this.faz.onBlurLevelSelected(dVar.fbg);
                this.faz.onFilterSelected(dVar.mFilterName);
                this.faz.onColorLevelSelected((dVar.fbe * 1.0f) / 100.0f);
                this.faz.onCheekThinSelected((dVar.fbi * 1.0f) / 100.0f);
                this.faz.onEnlargeEyeSelected((dVar.fbh * 1.0f) / 100.0f);
                this.faz.onRedLevelSelected((dVar.fbf * 1.0f) / 100.0f);
                this.faz.onChinSelected((dVar.fbj * 1.0f) / 100.0f);
                this.faz.onNoseSelected((dVar.fbk * 1.0f) / 100.0f);
            }
        }
    }

    public void blF() {
        if (this.fay != null) {
            this.fay.pH();
        }
    }

    public void setVisible(int i) {
        if (this.fay != null) {
            this.fay.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.fay != null) {
            if (this.fay.getParent() != null) {
                ((ViewGroup) this.fay.getParent()).removeView(this.fay);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.fay, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.fay, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.fay, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.fay, layoutParams4);
            }
            this.fay.setVisibility(0);
        }
    }

    public void jn(boolean z) {
        if (this.fay != null) {
            if (z) {
                this.fay.pH();
            }
            if (this.fay.getParent() != null) {
                ((ViewGroup) this.fay.getParent()).removeView(this.fay);
            }
            com.baidu.live.ar.b.We.Wa = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
