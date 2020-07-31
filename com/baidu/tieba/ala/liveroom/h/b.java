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
import com.baidu.live.data.ba;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public AlaLiveRecorder blF;
    private f gkJ;
    private ILiveMultiBeautyView gkK;
    private j gkL = new j() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.j
        public void vy() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.blF != null && AlaFilterAndBeautyData.auD != null && AlaFilterAndBeautyData.auD.get(beautyAdjustKey) != null) {
                b.this.blF.onBeautyParamsChanged(f, AlaFilterAndBeautyData.auD.get(beautyAdjustKey).vo());
            }
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.blF != null) {
                b.this.blF.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.j
        public void vz() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.auD != null && AlaFilterAndBeautyData.auD.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.auD.get(beautyAdjustKey).vn() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.auX.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.auD.get(beautyAdjustKey).vn() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.auD.get(beautyAdjustKey).vn() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.j
        public void vA() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.auD != null && AlaFilterAndBeautyData.auD.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.blF != null) {
                b.this.blF.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.j
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.blF != null) {
                b.this.blF.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.j
        public void p(int i, int i2) {
            if (b.this.blF != null) {
                b.this.blF.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void q(int i, int i2) {
            if (b.this.blF != null) {
                b.this.blF.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void r(int i, int i2) {
            if (b.this.blF != null) {
                b.this.blF.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void s(int i, int i2) {
            if (b.this.blF != null) {
                b.this.blF.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.gkJ = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.blF = alaLiveRecorder;
        if (ba.b(com.baidu.live.v.a.Hs().beo)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.atU = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gkK = (ILiveMultiBeautyView) runTask.getData();
                this.gkK.setArModel(fVar.glE);
            }
        } else if (ba.a(com.baidu.live.v.a.Hs().beo)) {
            this.gkK = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.gkK.setBdPageContext(this.gkJ.pageContext);
        this.gkK.setOnEffectSelectedListener(this.gkL);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.gkK != null) {
            if (z) {
                this.gkK.vw();
            } else if (ba.b(com.baidu.live.v.a.Hs().beo)) {
                this.gkK.setViewData();
            } else if (ba.a(com.baidu.live.v.a.Hs().beo)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.gll = 40;
                dVar.gln = 5;
                dVar.glo = 50;
                dVar.glp = 50;
                dVar.Dz(com.baidu.live.c.vf().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.gkK).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bHk() {
        if (this.gkK != null) {
            this.gkK.vx();
        }
    }

    public void setVisible(int i) {
        if (this.gkK != null) {
            this.gkK.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.gkK != null) {
            if (this.gkK.getParent() != null) {
                ((ViewGroup) this.gkK.getParent()).removeView(this.gkK);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.gkK, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.gkK, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.gkK, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.gkK, layoutParams4);
            }
            this.gkK.setVisibility(0);
        }
    }

    public void lw(boolean z) {
        if (this.gkK != null) {
            if (z) {
                this.gkK.vx();
            }
            if (this.gkK.getParent() != null) {
                ((ViewGroup) this.gkK.getParent()).removeView(this.gkK);
            }
            com.baidu.live.ar.d.auY.auO = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
