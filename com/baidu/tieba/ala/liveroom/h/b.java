package com.baidu.tieba.ala.liveroom.h;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.m;
import com.baidu.live.data.bo;
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class b {
    private ILiveMultiBeautyView bAP;
    public AlaLiveRecorder bAQ;
    private m bAW = new m() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            AlaFilterAndBeautyData.b bVar;
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bAQ != null && AlaFilterAndBeautyData.aAD != null && (bVar = AlaFilterAndBeautyData.aAD.get(beautyAdjustKey)) != null) {
                b.this.bAQ.onBeautyParamsChanged(f, bVar.yM());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (b.this.bAQ != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bAQ.onBeautyParamsChanged(aVar.getType(), aVar.yZ());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bAQ != null) {
                b.this.bAQ.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void yX() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aAD != null && AlaFilterAndBeautyData.aAD.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aAD.get(beautyAdjustKey).yL() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.e.aAZ.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aAD.get(beautyAdjustKey).yL() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aAD.get(beautyAdjustKey).yL() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void yY() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aAD != null && AlaFilterAndBeautyData.aAD.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                        a(0.5f, beautyAdjustKey);
                    } else {
                        a(0.0f, beautyAdjustKey);
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void onBlurLevelSelected(int i) {
            if (b.this.bAQ != null) {
                b.this.bAQ.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bAQ != null) {
                b.this.bAQ.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (b.this.bAQ != null) {
                b.this.bAQ.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (b.this.bAQ != null) {
                b.this.bAQ.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (b.this.bAQ != null) {
                b.this.bAQ.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (b.this.bAQ != null) {
                b.this.bAQ.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.data.e hwU;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.data.e eVar, AlaLiveRecorder alaLiveRecorder) {
        this.hwU = eVar;
        this.mContext = eVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bAQ = alaLiveRecorder;
        if (bo.b(com.baidu.live.af.a.OJ().bxp)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.azT = eVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bAP = (ILiveMultiBeautyView) runTask.getData();
                this.bAP.setArModel(eVar.hxF);
            }
        } else if (bo.a(com.baidu.live.af.a.OJ().bxp)) {
            this.bAP = new AlaLiveMultiBeautyView(eVar.pageContext.getPageActivity());
        }
        this.bAP.setBdPageContext(this.hwU.pageContext);
        this.bAP.setOnEffectSelectedListener(this.bAW);
        x xVar = null;
        if (eVar != null && eVar.hxj != null) {
            xVar = eVar.hxj.DW();
        }
        this.bAP.setAlaLiveShowData(xVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.bAP != null) {
            x xVar = null;
            if (this.hwU != null && this.hwU.hxj != null) {
                xVar = this.hwU.hxj.DW();
            }
            this.bAP.setAlaLiveShowData(xVar);
            if (z) {
                this.bAP.yV();
            } else if (bo.b(com.baidu.live.af.a.OJ().bxp)) {
                this.bAP.setViewData();
            } else if (bo.a(com.baidu.live.af.a.OJ().bxp)) {
                com.baidu.live.ar.f fVar = new com.baidu.live.ar.f();
                fVar.aBb = 40;
                fVar.aBd = 5;
                fVar.aBe = 50;
                fVar.aBf = 50;
                fVar.eN(com.baidu.live.d.xf().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.bAP).setViewData(fVar, alaLiveVideoConfig);
            }
        }
    }

    public void cdt() {
        if (this.bAP != null) {
            this.bAP.yW();
        }
    }

    public void setVisible(int i) {
        if (this.bAP != null) {
            if (i == 0) {
                x xVar = null;
                if (this.hwU != null && this.hwU.hxj != null) {
                    xVar = this.hwU.hxj.DW();
                }
                this.bAP.setAlaLiveShowData(xVar);
            }
            this.bAP.setVisibility(i);
        }
    }

    public void c(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.bAP != null) {
            x xVar = null;
            if (this.hwU != null && this.hwU.hxj != null) {
                xVar = this.hwU.hxj.DW();
            }
            this.bAP.setAlaLiveShowData(xVar);
            if (this.bAP.getParent() != null) {
                ((ViewGroup) this.bAP.getParent()).removeView(this.bAP);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bAP, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bAP, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bAP, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bAP, layoutParams4);
            }
            this.bAP.setVisibility(0);
        }
    }

    public void nV(boolean z) {
        if (this.bAP != null) {
            if (z) {
                this.bAP.yW();
            }
            if (this.bAP.getParent() != null) {
                ((ViewGroup) this.bAP.getParent()).removeView(this.bAP);
            }
            com.baidu.live.ar.e.aBa.aAO = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.bAP != null) {
            this.bAP.b(s);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bAP != null && this.bAP.onKeyDown(i, keyEvent);
    }
}
