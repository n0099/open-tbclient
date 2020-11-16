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
    private ILiveMultiBeautyView bvE;
    public AlaLiveRecorder bvF;
    private l bvL = new l() { // from class: com.baidu.tieba.ala.liveroom.h.b.1
        @Override // com.baidu.live.ar.l
        public void BS() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bvF != null && AlaFilterAndBeautyData.aCs != null && AlaFilterAndBeautyData.aCs.get(beautyAdjustKey) != null) {
                b.this.bvF.onBeautyParamsChanged(f, AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BH());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(l.a aVar) {
            if (b.this.bvF != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bvF.onBeautyParamsChanged(aVar.getType(), aVar.BV());
            }
        }

        @Override // com.baidu.live.ar.l
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bvF != null) {
                b.this.bvF.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.l
        public void BT() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCs != null && AlaFilterAndBeautyData.aCs.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BG() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.aCO.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BG() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aCs.get(beautyAdjustKey).BG() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.l
        public void BU() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCs != null && AlaFilterAndBeautyData.aCs.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.bvF != null) {
                b.this.bvF.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.l
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bvF != null) {
                b.this.bvF.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.l
        public void s(int i, int i2) {
            if (b.this.bvF != null) {
                b.this.bvF.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void t(int i, int i2) {
            if (b.this.bvF != null) {
                b.this.bvF.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void u(int i, int i2) {
            if (b.this.bvF != null) {
                b.this.bvF.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.l
        public void v(int i, int i2) {
            if (b.this.bvF != null) {
                b.this.bvF.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.data.e hfV;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.data.e eVar, AlaLiveRecorder alaLiveRecorder) {
        this.hfV = eVar;
        this.mContext = eVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bvF = alaLiveRecorder;
        if (bl.b(com.baidu.live.aa.a.Ph().bsh)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aBJ = eVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bvE = (ILiveMultiBeautyView) runTask.getData();
                this.bvE.setArModel(eVar.hgG);
            }
        } else if (bl.a(com.baidu.live.aa.a.Ph().bsh)) {
            this.bvE = new AlaLiveMultiBeautyView(eVar.pageContext.getPageActivity());
        }
        this.bvE.setBdPageContext(this.hfV.pageContext);
        this.bvE.setOnEffectSelectedListener(this.bvL);
        w wVar = null;
        if (eVar != null && eVar.hgk != null) {
            wVar = eVar.hgk.Gz();
        }
        this.bvE.setAlaLiveShowData(wVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.bvE != null) {
            w wVar = null;
            if (this.hfV != null && this.hfV.hgk != null) {
                wVar = this.hfV.hgk.Gz();
            }
            this.bvE.setAlaLiveShowData(wVar);
            if (z) {
                this.bvE.BQ();
            } else if (bl.b(com.baidu.live.aa.a.Ph().bsh)) {
                this.bvE.setViewData();
            } else if (bl.a(com.baidu.live.aa.a.Ph().bsh)) {
                com.baidu.live.ar.e eVar = new com.baidu.live.ar.e();
                eVar.aCQ = 40;
                eVar.aCS = 5;
                eVar.aCT = 50;
                eVar.aCU = 50;
                eVar.fT(com.baidu.live.d.Aq().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.bvE).setViewData(eVar, alaLiveVideoConfig);
            }
        }
    }

    public void cay() {
        if (this.bvE != null) {
            this.bvE.BR();
        }
    }

    public void setVisible(int i) {
        if (this.bvE != null) {
            if (i == 0) {
                w wVar = null;
                if (this.hfV != null && this.hfV.hgk != null) {
                    wVar = this.hfV.hgk.Gz();
                }
                this.bvE.setAlaLiveShowData(wVar);
            }
            this.bvE.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.bvE != null) {
            w wVar = null;
            if (this.hfV != null && this.hfV.hgk != null) {
                wVar = this.hfV.hgk.Gz();
            }
            this.bvE.setAlaLiveShowData(wVar);
            if (this.bvE.getParent() != null) {
                ((ViewGroup) this.bvE.getParent()).removeView(this.bvE);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bvE, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bvE, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bvE, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bvE, layoutParams4);
            }
            this.bvE.setVisibility(0);
        }
    }

    public void ne(boolean z) {
        if (this.bvE != null) {
            if (z) {
                this.bvE.BR();
            }
            if (this.bvE.getParent() != null) {
                ((ViewGroup) this.bvE.getParent()).removeView(this.bvE);
            }
            com.baidu.live.ar.d.aCP.aCD = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.bvE != null) {
            this.bvE.b(s);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bvE != null && this.bvE.onKeyDown(i, keyEvent);
    }
}
