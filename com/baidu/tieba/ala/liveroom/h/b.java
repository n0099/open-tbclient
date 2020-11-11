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
import com.baidu.live.data.bl;
import com.baidu.live.data.w;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    private ILiveMultiBeautyView bxp;
    public AlaLiveRecorder bxq;
    private l bxw = new l() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.l
        public void CB() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bxq != null && AlaFilterAndBeautyData.aEd != null && AlaFilterAndBeautyData.aEd.get(beautyAdjustKey) != null) {
                b.this.bxq.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cq());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(l.a aVar) {
            if (b.this.bxq != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bxq.onBeautyParamsChanged(aVar.getType(), aVar.CE());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bxq != null) {
                b.this.bxq.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.l
        public void CC() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEd != null && AlaFilterAndBeautyData.aEd.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cp() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aEz.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cp() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aEd.get(beautyAdjustKey).Cp() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void CD() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aEd != null && AlaFilterAndBeautyData.aEd.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.bxq != null) {
                b.this.bxq.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.l
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bxq != null) {
                b.this.bxq.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.l
        public void s(int i, int i2) {
            if (b.this.bxq != null) {
                b.this.bxq.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void t(int i, int i2) {
            if (b.this.bxq != null) {
                b.this.bxq.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void u(int i, int i2) {
            if (b.this.bxq != null) {
                b.this.bxq.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void v(int i, int i2) {
            if (b.this.bxq != null) {
                b.this.bxq.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.data.e hgo;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.data.e eVar, AlaLiveRecorder alaLiveRecorder) {
        this.hgo = eVar;
        this.mContext = eVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bxq = alaLiveRecorder;
        if (bl.b(com.baidu.live.aa.a.PQ().btT)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aDu = eVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bxp = (ILiveMultiBeautyView) runTask.getData();
                this.bxp.setArModel(eVar.hgZ);
            }
        } else if (bl.a(com.baidu.live.aa.a.PQ().btT)) {
            this.bxp = new AlaLiveMultiBeautyView(eVar.pageContext.getPageActivity());
        }
        this.bxp.setBdPageContext(this.hgo.pageContext);
        this.bxp.setOnEffectSelectedListener(this.bxw);
        w wVar = null;
        if (eVar != null && eVar.hgD != null) {
            wVar = eVar.hgD.Hi();
        }
        this.bxp.setAlaLiveShowData(wVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.bxp != null) {
            w wVar = null;
            if (this.hgo != null && this.hgo.hgD != null) {
                wVar = this.hgo.hgD.Hi();
            }
            this.bxp.setAlaLiveShowData(wVar);
            if (z) {
                this.bxp.Cz();
            } else if (bl.b(com.baidu.live.aa.a.PQ().btT)) {
                this.bxp.setViewData();
            } else if (bl.a(com.baidu.live.aa.a.PQ().btT)) {
                com.baidu.live.ar.e eVar = new com.baidu.live.ar.e();
                eVar.aEB = 40;
                eVar.aED = 5;
                eVar.aEE = 50;
                eVar.aEF = 50;
                eVar.fZ(com.baidu.live.d.AZ().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.bxp).setViewData(eVar, alaLiveVideoConfig);
            }
        }
    }

    public void cbf() {
        if (this.bxp != null) {
            this.bxp.CA();
        }
    }

    public void setVisible(int i) {
        if (this.bxp != null) {
            if (i == 0) {
                w wVar = null;
                if (this.hgo != null && this.hgo.hgD != null) {
                    wVar = this.hgo.hgD.Hi();
                }
                this.bxp.setAlaLiveShowData(wVar);
            }
            this.bxp.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.bxp != null) {
            w wVar = null;
            if (this.hgo != null && this.hgo.hgD != null) {
                wVar = this.hgo.hgD.Hi();
            }
            this.bxp.setAlaLiveShowData(wVar);
            if (this.bxp.getParent() != null) {
                ((ViewGroup) this.bxp.getParent()).removeView(this.bxp);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bxp, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bxp, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bxp, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bxp, layoutParams4);
            }
            this.bxp.setVisibility(0);
        }
    }

    public void nd(boolean z) {
        if (this.bxp != null) {
            if (z) {
                this.bxp.CA();
            }
            if (this.bxp.getParent() != null) {
                ((ViewGroup) this.bxp.getParent()).removeView(this.bxp);
            }
            com.baidu.live.ar.d.aEA.aEo = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.bxp != null) {
            this.bxp.b(s);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bxp != null && this.bxp.onKeyDown(i, keyEvent);
    }
}
