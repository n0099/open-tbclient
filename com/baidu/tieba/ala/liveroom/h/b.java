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
import com.baidu.live.ar.k;
import com.baidu.live.data.bk;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public AlaLiveRecorder bAM;
    private f hak;
    private ILiveMultiBeautyView hal;
    private k ham = new k() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.k
        public void Cj() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.k
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bAM != null && AlaFilterAndBeautyData.aDw != null && AlaFilterAndBeautyData.aDw.get(beautyAdjustKey) != null) {
                b.this.bAM.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aDw.get(beautyAdjustKey).BY());
            }
        }

        @Override // com.baidu.live.ar.k
        public void a(k.a aVar) {
            if (b.this.bAM != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bAM.onBeautyParamsChanged(aVar.getType(), aVar.Cm());
            }
        }

        @Override // com.baidu.live.ar.k
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bAM != null) {
                b.this.bAM.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.k
        public void Ck() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDw != null && AlaFilterAndBeautyData.aDw.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aDw.get(beautyAdjustKey).BX() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aDS.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aDw.get(beautyAdjustKey).BX() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aDw.get(beautyAdjustKey).BX() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.k
        public void Cl() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDw != null && AlaFilterAndBeautyData.aDw.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                        a(0.5f, beautyAdjustKey);
                    } else {
                        a(0.0f, beautyAdjustKey);
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.k
        public void onBlurLevelSelected(int i) {
            if (b.this.bAM != null) {
                b.this.bAM.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.k
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bAM != null) {
                b.this.bAM.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.k
        public void s(int i, int i2) {
            if (b.this.bAM != null) {
                b.this.bAM.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.k
        public void t(int i, int i2) {
            if (b.this.bAM != null) {
                b.this.bAM.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.k
        public void u(int i, int i2) {
            if (b.this.bAM != null) {
                b.this.bAM.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.k
        public void v(int i, int i2) {
            if (b.this.bAM != null) {
                b.this.bAM.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.hak = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bAM = alaLiveRecorder;
        if (bk.b(com.baidu.live.z.a.Pq().bsy)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aCN = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hal = (ILiveMultiBeautyView) runTask.getData();
                this.hal.setArModel(fVar.hbe);
            }
        } else if (bk.a(com.baidu.live.z.a.Pq().bsy)) {
            this.hal = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.hal.setBdPageContext(this.hak.pageContext);
        this.hal.setOnEffectSelectedListener(this.ham);
        w wVar = null;
        if (fVar != null && fVar.haB != null) {
            wVar = fVar.haB.GH();
        }
        this.hal.setAlaLiveShowData(wVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.hal != null) {
            w wVar = null;
            if (this.hak != null && this.hak.haB != null) {
                wVar = this.hak.haB.GH();
            }
            this.hal.setAlaLiveShowData(wVar);
            if (z) {
                this.hal.Ch();
            } else if (bk.b(com.baidu.live.z.a.Pq().bsy)) {
                this.hal.setViewData();
            } else if (bk.a(com.baidu.live.z.a.Pq().bsy)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.haL = 40;
                dVar.haN = 5;
                dVar.haO = 50;
                dVar.haP = 50;
                dVar.HG(com.baidu.live.d.AZ().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.hal).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bYD() {
        if (this.hal != null) {
            this.hal.Ci();
        }
    }

    public void setVisible(int i) {
        if (this.hal != null) {
            if (i == 0) {
                w wVar = null;
                if (this.hak != null && this.hak.haB != null) {
                    wVar = this.hak.haB.GH();
                }
                this.hal.setAlaLiveShowData(wVar);
            }
            this.hal.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.hal != null) {
            w wVar = null;
            if (this.hak != null && this.hak.haB != null) {
                wVar = this.hak.haB.GH();
            }
            this.hal.setAlaLiveShowData(wVar);
            if (this.hal.getParent() != null) {
                ((ViewGroup) this.hal.getParent()).removeView(this.hal);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.hal, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.hal, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.hal, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.hal, layoutParams4);
            }
            this.hal.setVisibility(0);
        }
    }

    public void mU(boolean z) {
        if (this.hal != null) {
            if (z) {
                this.hal.Ci();
            }
            if (this.hal.getParent() != null) {
                ((ViewGroup) this.hal.getParent()).removeView(this.hal);
            }
            com.baidu.live.ar.d.aDT.aDH = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.hal != null) {
            this.hal.b(s);
        }
    }
}
