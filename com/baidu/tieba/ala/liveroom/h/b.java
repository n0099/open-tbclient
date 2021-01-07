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
/* loaded from: classes11.dex */
public class b {
    private ILiveMultiBeautyView bFB;
    public AlaLiveRecorder bFC;
    private m bFI = new m() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            AlaFilterAndBeautyData.b bVar;
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bFC != null && AlaFilterAndBeautyData.aFq != null && (bVar = AlaFilterAndBeautyData.aFq.get(beautyAdjustKey)) != null) {
                b.this.bFC.onBeautyParamsChanged(f, bVar.CH());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (b.this.bFC != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bFC.onBeautyParamsChanged(aVar.getType(), aVar.CU());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bFC != null) {
                b.this.bFC.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void CS() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aFq != null && AlaFilterAndBeautyData.aFq.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aFq.get(beautyAdjustKey).CG() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.e.aFM.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aFq.get(beautyAdjustKey).CG() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aFq.get(beautyAdjustKey).CG() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void CT() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aFq != null && AlaFilterAndBeautyData.aFq.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.bFC != null) {
                b.this.bFC.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bFC != null) {
                b.this.bFC.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (b.this.bFC != null) {
                b.this.bFC.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (b.this.bFC != null) {
                b.this.bFC.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (b.this.bFC != null) {
                b.this.bFC.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (b.this.bFC != null) {
                b.this.bFC.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.data.e hBA;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.data.e eVar, AlaLiveRecorder alaLiveRecorder) {
        this.hBA = eVar;
        this.mContext = eVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bFC = alaLiveRecorder;
        if (bo.b(com.baidu.live.af.a.SE().bCb)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aEG = eVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bFB = (ILiveMultiBeautyView) runTask.getData();
                this.bFB.setArModel(eVar.hCl);
            }
        } else if (bo.a(com.baidu.live.af.a.SE().bCb)) {
            this.bFB = new AlaLiveMultiBeautyView(eVar.pageContext.getPageActivity());
        }
        this.bFB.setBdPageContext(this.hBA.pageContext);
        this.bFB.setOnEffectSelectedListener(this.bFI);
        x xVar = null;
        if (eVar != null && eVar.hBP != null) {
            xVar = eVar.hBP.HR();
        }
        this.bFB.setAlaLiveShowData(xVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.bFB != null) {
            x xVar = null;
            if (this.hBA != null && this.hBA.hBP != null) {
                xVar = this.hBA.hBP.HR();
            }
            this.bFB.setAlaLiveShowData(xVar);
            if (z) {
                this.bFB.CQ();
            } else if (bo.b(com.baidu.live.af.a.SE().bCb)) {
                this.bFB.setViewData();
            } else if (bo.a(com.baidu.live.af.a.SE().bCb)) {
                com.baidu.live.ar.f fVar = new com.baidu.live.ar.f();
                fVar.aFO = 40;
                fVar.aFQ = 5;
                fVar.aFR = 50;
                fVar.aFS = 50;
                fVar.fY(com.baidu.live.d.Ba().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.bFB).setViewData(fVar, alaLiveVideoConfig);
            }
        }
    }

    public void chl() {
        if (this.bFB != null) {
            this.bFB.CR();
        }
    }

    public void setVisible(int i) {
        if (this.bFB != null) {
            if (i == 0) {
                x xVar = null;
                if (this.hBA != null && this.hBA.hBP != null) {
                    xVar = this.hBA.hBP.HR();
                }
                this.bFB.setAlaLiveShowData(xVar);
            }
            this.bFB.setVisibility(i);
        }
    }

    public void c(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.bFB != null) {
            x xVar = null;
            if (this.hBA != null && this.hBA.hBP != null) {
                xVar = this.hBA.hBP.HR();
            }
            this.bFB.setAlaLiveShowData(xVar);
            if (this.bFB.getParent() != null) {
                ((ViewGroup) this.bFB.getParent()).removeView(this.bFB);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bFB, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bFB, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bFB, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bFB, layoutParams4);
            }
            this.bFB.setVisibility(0);
        }
    }

    public void nZ(boolean z) {
        if (this.bFB != null) {
            if (z) {
                this.bFB.CR();
            }
            if (this.bFB.getParent() != null) {
                ((ViewGroup) this.bFB.getParent()).removeView(this.bFB);
            }
            com.baidu.live.ar.e.aFN.aFB = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.bFB != null) {
            this.bFB.b(s);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bFB != null && this.bFB.onKeyDown(i, keyEvent);
    }
}
