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
    public AlaLiveRecorder buD;
    private f gAd;
    private ILiveMultiBeautyView gAe;
    private j gAf = new j() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.j
        public void Bl() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.buD != null && AlaFilterAndBeautyData.aAn != null && AlaFilterAndBeautyData.aAn.get(beautyAdjustKey) != null) {
                b.this.buD.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aAn.get(beautyAdjustKey).Bb());
            }
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.buD != null) {
                b.this.buD.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.j
        public void Bm() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aAn != null && AlaFilterAndBeautyData.aAn.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aAn.get(beautyAdjustKey).Ba() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aAH.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aAn.get(beautyAdjustKey).Ba() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aAn.get(beautyAdjustKey).Ba() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.j
        public void Bn() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aAn != null && AlaFilterAndBeautyData.aAn.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.buD != null) {
                b.this.buD.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.j
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.buD != null) {
                b.this.buD.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.j
        public void s(int i, int i2) {
            if (b.this.buD != null) {
                b.this.buD.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void t(int i, int i2) {
            if (b.this.buD != null) {
                b.this.buD.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void u(int i, int i2) {
            if (b.this.buD != null) {
                b.this.buD.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void v(int i, int i2) {
            if (b.this.buD != null) {
                b.this.buD.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.gAd = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.buD = alaLiveRecorder;
        if (bh.b(com.baidu.live.x.a.NN().bmW)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.azE = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gAe = (ILiveMultiBeautyView) runTask.getData();
                this.gAe.setArModel(fVar.gAX);
            }
        } else if (bh.a(com.baidu.live.x.a.NN().bmW)) {
            this.gAe = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.gAe.setBdPageContext(this.gAd.pageContext);
        this.gAe.setOnEffectSelectedListener(this.gAf);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.gAe != null) {
            if (z) {
                this.gAe.Bj();
            } else if (bh.b(com.baidu.live.x.a.NN().bmW)) {
                this.gAe.setViewData();
            } else if (bh.a(com.baidu.live.x.a.NN().bmW)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.gAE = 40;
                dVar.gAG = 5;
                dVar.gAH = 50;
                dVar.gAI = 50;
                dVar.Gv(com.baidu.live.c.AR().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.gAe).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bSl() {
        if (this.gAe != null) {
            this.gAe.Bk();
        }
    }

    public void setVisible(int i) {
        if (this.gAe != null) {
            this.gAe.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.gAe != null) {
            if (this.gAe.getParent() != null) {
                ((ViewGroup) this.gAe.getParent()).removeView(this.gAe);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.gAe, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.gAe, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.gAe, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.gAe, layoutParams4);
            }
            this.gAe.setVisibility(0);
        }
    }

    public void mc(boolean z) {
        if (this.gAe != null) {
            if (z) {
                this.gAe.Bk();
            }
            if (this.gAe.getParent() != null) {
                ((ViewGroup) this.gAe.getParent()).removeView(this.gAe);
            }
            com.baidu.live.ar.d.aAI.aAy = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
