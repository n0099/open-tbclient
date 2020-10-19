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
import com.baidu.live.data.bh;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public AlaLiveRecorder bxQ;
    private f gOw;
    private ILiveMultiBeautyView gOx;
    private j gOy = new j() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.j
        public void Ci() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bxQ != null && AlaFilterAndBeautyData.aDs != null && AlaFilterAndBeautyData.aDs.get(beautyAdjustKey) != null) {
                b.this.bxQ.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aDs.get(beautyAdjustKey).BY());
            }
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bxQ != null) {
                b.this.bxQ.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.j
        public void Cj() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDs != null && AlaFilterAndBeautyData.aDs.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aDs.get(beautyAdjustKey).BX() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aDM.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aDs.get(beautyAdjustKey).BX() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aDs.get(beautyAdjustKey).BX() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.j
        public void Ck() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDs != null && AlaFilterAndBeautyData.aDs.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.bxQ != null) {
                b.this.bxQ.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.j
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bxQ != null) {
                b.this.bxQ.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.j
        public void s(int i, int i2) {
            if (b.this.bxQ != null) {
                b.this.bxQ.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void t(int i, int i2) {
            if (b.this.bxQ != null) {
                b.this.bxQ.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void u(int i, int i2) {
            if (b.this.bxQ != null) {
                b.this.bxQ.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void v(int i, int i2) {
            if (b.this.bxQ != null) {
                b.this.bxQ.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.gOw = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bxQ = alaLiveRecorder;
        if (bh.b(com.baidu.live.x.a.OS().bqJ)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aCJ = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gOx = (ILiveMultiBeautyView) runTask.getData();
                this.gOx.setArModel(fVar.gPq);
            }
        } else if (bh.a(com.baidu.live.x.a.OS().bqJ)) {
            this.gOx = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.gOx.setBdPageContext(this.gOw.pageContext);
        this.gOx.setOnEffectSelectedListener(this.gOy);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.gOx != null) {
            if (z) {
                this.gOx.Cg();
            } else if (bh.b(com.baidu.live.x.a.OS().bqJ)) {
                this.gOx.setViewData();
            } else if (bh.a(com.baidu.live.x.a.OS().bqJ)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.gOX = 40;
                dVar.gOZ = 5;
                dVar.gPa = 50;
                dVar.gPb = 50;
                dVar.Hh(com.baidu.live.c.AZ().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.gOx).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bVE() {
        if (this.gOx != null) {
            this.gOx.Ch();
        }
    }

    public void setVisible(int i) {
        if (this.gOx != null) {
            this.gOx.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.gOx != null) {
            if (this.gOx.getParent() != null) {
                ((ViewGroup) this.gOx.getParent()).removeView(this.gOx);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.gOx, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.gOx, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.gOx, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.gOx, layoutParams4);
            }
            this.gOx.setVisibility(0);
        }
    }

    public void mE(boolean z) {
        if (this.gOx != null) {
            if (z) {
                this.gOx.Ch();
            }
            if (this.gOx.getParent() != null) {
                ((ViewGroup) this.gOx.getParent()).removeView(this.gOx);
            }
            com.baidu.live.ar.d.aDN.aDD = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
