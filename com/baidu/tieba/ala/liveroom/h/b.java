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
import com.baidu.live.ar.j;
import com.baidu.live.data.bc;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b {
    public AlaLiveRecorder brl;
    private f gwN;
    private ILiveMultiBeautyView gwO;
    private j gwP = new j() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.j
        public void AW() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.brl != null && AlaFilterAndBeautyData.azF != null && AlaFilterAndBeautyData.azF.get(beautyAdjustKey) != null) {
                b.this.brl.onBeautyParamsChanged(f, AlaFilterAndBeautyData.azF.get(beautyAdjustKey).AM());
            }
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.brl != null) {
                b.this.brl.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.j
        public void AX() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.azF != null && AlaFilterAndBeautyData.azF.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.azF.get(beautyAdjustKey).AL() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.azZ.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.azF.get(beautyAdjustKey).AL() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.azF.get(beautyAdjustKey).AL() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.j
        public void AY() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.azF != null && AlaFilterAndBeautyData.azF.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                        a(0.5f, beautyAdjustKey);
                    } else {
                        a(0.0f, beautyAdjustKey);
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.j
        public void onBlurLevelSelected(int i) {
            if (b.this.brl != null) {
                b.this.brl.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.j
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.brl != null) {
                b.this.brl.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.j
        public void s(int i, int i2) {
            if (b.this.brl != null) {
                b.this.brl.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void t(int i, int i2) {
            if (b.this.brl != null) {
                b.this.brl.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void u(int i, int i2) {
            if (b.this.brl != null) {
                b.this.brl.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void v(int i, int i2) {
            if (b.this.brl != null) {
                b.this.brl.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.gwN = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.brl = alaLiveRecorder;
        if (bc.b(com.baidu.live.w.a.Nk().bka)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.ayW = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gwO = (ILiveMultiBeautyView) runTask.getData();
                this.gwO.setArModel(fVar.gxI);
            }
        } else if (bc.a(com.baidu.live.w.a.Nk().bka)) {
            this.gwO = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.gwO.setBdPageContext(this.gwN.pageContext);
        this.gwO.setOnEffectSelectedListener(this.gwP);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.gwO != null) {
            if (z) {
                this.gwO.AU();
            } else if (bc.b(com.baidu.live.w.a.Nk().bka)) {
                this.gwO.setViewData();
            } else if (bc.a(com.baidu.live.w.a.Nk().bka)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.gxp = 40;
                dVar.gxr = 5;
                dVar.gxs = 50;
                dVar.gxt = 50;
                dVar.FW(com.baidu.live.c.AD().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.gwO).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bQO() {
        if (this.gwO != null) {
            this.gwO.AV();
        }
    }

    public void setVisible(int i) {
        if (this.gwO != null) {
            this.gwO.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.gwO != null) {
            if (this.gwO.getParent() != null) {
                ((ViewGroup) this.gwO.getParent()).removeView(this.gwO);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.gwO, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.gwO, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.gwO, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.gwO, layoutParams4);
            }
            this.gwO.setVisibility(0);
        }
    }

    public void lX(boolean z) {
        if (this.gwO != null) {
            if (z) {
                this.gwO.AV();
            }
            if (this.gwO.getParent() != null) {
                ((ViewGroup) this.gwO.getParent()).removeView(this.gwO);
            }
            com.baidu.live.ar.d.aAa.azQ = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
