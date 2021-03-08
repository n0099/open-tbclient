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
/* loaded from: classes10.dex */
public class b {
    private ILiveMultiBeautyView bFV;
    public AlaLiveRecorder bFW;
    private m bGc = new m() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.m
        public void onClosed() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            AlaFilterAndBeautyData.b bVar;
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bFW != null && AlaFilterAndBeautyData.aDI != null && (bVar = AlaFilterAndBeautyData.aDI.get(beautyAdjustKey)) != null) {
                b.this.bFW.onBeautyParamsChanged(f, bVar.zw());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(m.a aVar) {
            if (b.this.bFW != null && aVar != null && !TextUtils.isEmpty(aVar.getType())) {
                b.this.bFW.onBeautyParamsChanged(aVar.getType(), aVar.zJ());
            }
        }

        @Override // com.baidu.live.ar.m
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bFW != null) {
                b.this.bFW.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.m
        public void zH() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDI != null && AlaFilterAndBeautyData.aDI.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.aDI.get(beautyAdjustKey).zv() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.e.aEe.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.aDI.get(beautyAdjustKey).zv() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.aDI.get(beautyAdjustKey).zv() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.m
        public void zI() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.aDI != null && AlaFilterAndBeautyData.aDI.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.bFW != null) {
                b.this.bFW.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.m
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bFW != null) {
                b.this.bFW.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.m
        public void t(int i, int i2) {
            if (b.this.bFW != null) {
                b.this.bFW.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void u(int i, int i2) {
            if (b.this.bFW != null) {
                b.this.bFW.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void v(int i, int i2) {
            if (b.this.bFW != null) {
                b.this.bFW.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.m
        public void w(int i, int i2) {
            if (b.this.bFW != null) {
                b.this.bFW.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.data.e hDb;
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, com.baidu.tieba.ala.liveroom.data.e eVar, AlaLiveRecorder alaLiveRecorder) {
        this.hDb = eVar;
        this.mContext = eVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bFW = alaLiveRecorder;
        if (bt.b(com.baidu.live.ae.a.Qm().bCs)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.aCY = eVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.bFV = (ILiveMultiBeautyView) runTask.getData();
                this.bFV.setArModel(eVar.hDM);
            }
        } else if (bt.a(com.baidu.live.ae.a.Qm().bCs)) {
            this.bFV = new AlaLiveMultiBeautyView(eVar.pageContext.getPageActivity());
        }
        this.bFV.setBdPageContext(this.hDb.pageContext);
        this.bFV.setOnEffectSelectedListener(this.bGc);
        ab abVar = null;
        if (eVar != null && eVar.hDq != null) {
            abVar = eVar.hDq.Fp();
        }
        this.bFV.setAlaLiveShowData(abVar);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.bFV != null) {
            ab abVar = null;
            if (this.hDb != null && this.hDb.hDq != null) {
                abVar = this.hDb.hDq.Fp();
            }
            this.bFV.setAlaLiveShowData(abVar);
            if (z) {
                this.bFV.zF();
            } else if (bt.b(com.baidu.live.ae.a.Qm().bCs)) {
                this.bFV.setViewData();
            } else if (bt.a(com.baidu.live.ae.a.Qm().bCs)) {
                com.baidu.live.ar.f fVar = new com.baidu.live.ar.f();
                fVar.aEg = 40;
                fVar.aEi = 5;
                fVar.aEj = 50;
                fVar.aEk = 50;
                fVar.fl(com.baidu.live.d.xf().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.bFV).setViewData(fVar, alaLiveVideoConfig);
            }
        }
    }

    public void ceB() {
        if (this.bFV != null) {
            this.bFV.zG();
        }
    }

    public void setVisible(int i) {
        if (this.bFV != null) {
            if (i == 0) {
                ab abVar = null;
                if (this.hDb != null && this.hDb.hDq != null) {
                    abVar = this.hDb.hDq.Fp();
                }
                this.bFV.setAlaLiveShowData(abVar);
            }
            this.bFV.setVisibility(i);
        }
    }

    public void c(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.bFV != null) {
            ab abVar = null;
            if (this.hDb != null && this.hDb.hDq != null) {
                abVar = this.hDb.hDq.Fp();
            }
            this.bFV.setAlaLiveShowData(abVar);
            if (this.bFV.getParent() != null) {
                ((ViewGroup) this.bFV.getParent()).removeView(this.bFV);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.bFV, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.bFV, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.bFV, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.bFV, layoutParams4);
            }
            this.bFV.setVisibility(0);
        }
    }

    public void og(boolean z) {
        if (this.bFV != null) {
            if (z) {
                this.bFV.zG();
            }
            if (this.bFV.getParent() != null) {
                ((ViewGroup) this.bFV.getParent()).removeView(this.bFV);
            }
            com.baidu.live.ar.e.aEf.aDT = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }

    public void b(short s) {
        if (this.bFV != null) {
            this.bFV.b(s);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bFV != null && this.bFV.onKeyDown(i, keyEvent);
    }
}
