package com.baidu.tieba.ala.liveroom.g;

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
import com.baidu.live.data.ab;
import com.baidu.live.data.bt;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b {
    private m bEC = new m() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            AlaFilterAndBeautyData.b bVar;
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bEw != null && AlaFilterAndBeautyData.aCi != null && (bVar = AlaFilterAndBeautyData.aCi.get(beautyAdjustKey)) != null) {
                b.this.bEw.onBeautyParamsChanged(f, bVar.zt());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (b.this.bEw != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bEw.onBeautyParamsChanged(aVar.getType(), aVar.zG());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bEw != null) {
                b.this.bEw.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void zE() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCi != null && AlaFilterAndBeautyData.aCi.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aCi.get(beautyAdjustKey).zs() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.e.aCE.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aCi.get(beautyAdjustKey).zs() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aCi.get(beautyAdjustKey).zs() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void zF() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aCi != null && AlaFilterAndBeautyData.aCi.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.bEw != null) {
                b.this.bEw.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bEw != null) {
                b.this.bEw.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (b.this.bEw != null) {
                b.this.bEw.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (b.this.bEw != null) {
                b.this.bEw.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (b.this.bEw != null) {
                b.this.bEw.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (b.this.bEw != null) {
                b.this.bEw.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private ILiveMultiBeautyView bEv;
    public AlaLiveRecorder bEw;
    private com.baidu.tieba.ala.liveroom.data.e hBs;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.data.e eVar, AlaLiveRecorder alaLiveRecorder) {
        this.hBs = eVar;
        this.mContext = eVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bEw = alaLiveRecorder;
        if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aBy = eVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bEv = (ILiveMultiBeautyView) runTask.getData();
                this.bEv.setArModel(eVar.hCd);
            }
        } else if (bt.a(com.baidu.live.ae.a.Qj().bAS)) {
            this.bEv = new AlaLiveMultiBeautyView(eVar.pageContext.getPageActivity());
        }
        this.bEv.setBdPageContext(this.hBs.pageContext);
        this.bEv.setOnEffectSelectedListener(this.bEC);
        ab abVar = null;
        if (eVar != null && eVar.hBH != null) {
            abVar = eVar.hBH.Fm();
        }
        this.bEv.setAlaLiveShowData(abVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.bEv != null) {
            ab abVar = null;
            if (this.hBs != null && this.hBs.hBH != null) {
                abVar = this.hBs.hBH.Fm();
            }
            this.bEv.setAlaLiveShowData(abVar);
            if (z) {
                this.bEv.zC();
            } else if (bt.b(com.baidu.live.ae.a.Qj().bAS)) {
                this.bEv.setViewData();
            } else if (bt.a(com.baidu.live.ae.a.Qj().bAS)) {
                com.baidu.live.ar.f fVar = new com.baidu.live.ar.f();
                fVar.aCG = 40;
                fVar.aCI = 5;
                fVar.aCJ = 50;
                fVar.aCK = 50;
                fVar.ff(com.baidu.live.d.xc().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.bEv).setViewData(fVar, alaLiveVideoConfig);
            }
        }
    }

    public void cev() {
        if (this.bEv != null) {
            this.bEv.zD();
        }
    }

    public void setVisible(int i) {
        if (this.bEv != null) {
            if (i == 0) {
                ab abVar = null;
                if (this.hBs != null && this.hBs.hBH != null) {
                    abVar = this.hBs.hBH.Fm();
                }
                this.bEv.setAlaLiveShowData(abVar);
            }
            this.bEv.setVisibility(i);
        }
    }

    public void c(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.bEv != null) {
            ab abVar = null;
            if (this.hBs != null && this.hBs.hBH != null) {
                abVar = this.hBs.hBH.Fm();
            }
            this.bEv.setAlaLiveShowData(abVar);
            if (this.bEv.getParent() != null) {
                ((ViewGroup) this.bEv.getParent()).removeView(this.bEv);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bEv, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bEv, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bEv, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bEv, layoutParams4);
            }
            this.bEv.setVisibility(0);
        }
    }

    public void og(boolean z) {
        if (this.bEv != null) {
            if (z) {
                this.bEv.zD();
            }
            if (this.bEv.getParent() != null) {
                ((ViewGroup) this.bEv.getParent()).removeView(this.bEv);
            }
            com.baidu.live.ar.e.aCF.aCt = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.bEv != null) {
            this.bEv.b(s);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bEv != null && this.bEv.onKeyDown(i, keyEvent);
    }
}
