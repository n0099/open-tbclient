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
import com.baidu.live.ar.l;
import com.baidu.live.data.bm;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private ILiveMultiBeautyView bAO;
    public AlaLiveRecorder bAP;
    private l bAV = new l() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.l
        public void DC() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bAP != null && AlaFilterAndBeautyData.aEY != null && AlaFilterAndBeautyData.aEY.get(beautyAdjustKey) != null) {
                b.this.bAP.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dr());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(l.a aVar) {
            if (b.this.bAP != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bAP.onBeautyParamsChanged(aVar.getType(), aVar.DF());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bAP != null) {
                b.this.bAP.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.l
        public void DD() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEY != null && AlaFilterAndBeautyData.aEY.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dq() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aFu.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dq() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aEY.get(beautyAdjustKey).Dq() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void DE() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEY != null && AlaFilterAndBeautyData.aEY.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                    if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                        a(0.5f, beautyAdjustKey);
                    } else {
                        a(0.0f, beautyAdjustKey);
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void onBlurLevelSelected(int i) {
            if (b.this.bAP != null) {
                b.this.bAP.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.l
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bAP != null) {
                b.this.bAP.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.l
        public void t(int i, int i2) {
            if (b.this.bAP != null) {
                b.this.bAP.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void u(int i, int i2) {
            if (b.this.bAP != null) {
                b.this.bAP.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void v(int i, int i2) {
            if (b.this.bAP != null) {
                b.this.bAP.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void w(int i, int i2) {
            if (b.this.bAP != null) {
                b.this.bAP.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.data.e hpC;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.data.e eVar, AlaLiveRecorder alaLiveRecorder) {
        this.hpC = eVar;
        this.mContext = eVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bAP = alaLiveRecorder;
        if (bm.b(com.baidu.live.ae.a.RB().bxq)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aEp = eVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bAO = (ILiveMultiBeautyView) runTask.getData();
                this.bAO.setArModel(eVar.hqn);
            }
        } else if (bm.a(com.baidu.live.ae.a.RB().bxq)) {
            this.bAO = new AlaLiveMultiBeautyView(eVar.pageContext.getPageActivity());
        }
        this.bAO.setBdPageContext(this.hpC.pageContext);
        this.bAO.setOnEffectSelectedListener(this.bAV);
        w wVar = null;
        if (eVar != null && eVar.hpR != null) {
            wVar = eVar.hpR.Iq();
        }
        this.bAO.setAlaLiveShowData(wVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.bAO != null) {
            w wVar = null;
            if (this.hpC != null && this.hpC.hpR != null) {
                wVar = this.hpC.hpR.Iq();
            }
            this.bAO.setAlaLiveShowData(wVar);
            if (z) {
                this.bAO.DA();
            } else if (bm.b(com.baidu.live.ae.a.RB().bxq)) {
                this.bAO.setViewData();
            } else if (bm.a(com.baidu.live.ae.a.RB().bxq)) {
                com.baidu.live.ar.e eVar = new com.baidu.live.ar.e();
                eVar.aFw = 40;
                eVar.aFy = 5;
                eVar.aFz = 50;
                eVar.aFA = 50;
                eVar.go(com.baidu.live.d.BM().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.bAO).setViewData(eVar, alaLiveVideoConfig);
            }
        }
    }

    public void cet() {
        if (this.bAO != null) {
            this.bAO.DB();
        }
    }

    public void setVisible(int i) {
        if (this.bAO != null) {
            if (i == 0) {
                w wVar = null;
                if (this.hpC != null && this.hpC.hpR != null) {
                    wVar = this.hpC.hpR.Iq();
                }
                this.bAO.setAlaLiveShowData(wVar);
            }
            this.bAO.setVisibility(i);
        }
    }

    public void c(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.bAO != null) {
            w wVar = null;
            if (this.hpC != null && this.hpC.hpR != null) {
                wVar = this.hpC.hpR.Iq();
            }
            this.bAO.setAlaLiveShowData(wVar);
            if (this.bAO.getParent() != null) {
                ((ViewGroup) this.bAO.getParent()).removeView(this.bAO);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bAO, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bAO, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bAO, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bAO, layoutParams4);
            }
            this.bAO.setVisibility(0);
        }
    }

    public void nz(boolean z) {
        if (this.bAO != null) {
            if (z) {
                this.bAO.DB();
            }
            if (this.bAO.getParent() != null) {
                ((ViewGroup) this.bAO.getParent()).removeView(this.bAO);
            }
            com.baidu.live.ar.d.aFv.aFj = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.bAO != null) {
            this.bAO.b(s);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bAO != null && this.bAO.onKeyDown(i, keyEvent);
    }
}
