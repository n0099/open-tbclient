package com.baidu.tieba.ala.liveroom.g;

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
import com.baidu.live.data.az;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public AlaLiveRecorder bll;
    private f gfB;
    private ILiveMultiBeautyView gfC;
    private j gfD = new j() { // from class: com.baidu.tieba.ala.liveroom.g.b.1
        @Override // com.baidu.live.ar.j
        public void vy() {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913147));
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey) {
            if (!TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey()) && b.this.bll != null && AlaFilterAndBeautyData.auH != null && AlaFilterAndBeautyData.auH.get(beautyAdjustKey) != null) {
                b.this.bll.onBeautyParamsChanged(f, AlaFilterAndBeautyData.auH.get(beautyAdjustKey).vo());
            }
        }

        @Override // com.baidu.live.ar.j
        public void a(float f, HashMap<String, Object> hashMap) {
            if (b.this.bll != null) {
                b.this.bll.onBeautyParamsChanged(f, hashMap);
            }
        }

        @Override // com.baidu.live.ar.j
        public void vz() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.auH != null && AlaFilterAndBeautyData.auH.get(beautyAdjustKey) != null) {
                    String jsonKey = beautyAdjustKey.getJsonKey();
                    if (!TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
                        if (beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.chin) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.threeCounts) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.mouthWidth) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.noseLength) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.eyeDistance) || beautyAdjustKey.equals(AlaFilterAndBeautyData.BeautyAdjustKey.upCount)) {
                            a(((AlaFilterAndBeautyData.auH.get(beautyAdjustKey).vn() + 50) * 1.0f) / 100.0f, beautyAdjustKey);
                        } else if (TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey()) || TextUtils.equals(jsonKey, AlaFilterAndBeautyData.BeautyAdjustKey.smooth.getJsonKey())) {
                            try {
                                a((new JSONObject(com.baidu.live.ar.d.avb.toJsonString()).getInt(jsonKey) * 1.0f) / 100.0f, beautyAdjustKey);
                            } catch (Exception e) {
                                e.printStackTrace();
                                a((AlaFilterAndBeautyData.auH.get(beautyAdjustKey).vn() * 1.0f) / 100.0f, beautyAdjustKey);
                            }
                        } else {
                            a((AlaFilterAndBeautyData.auH.get(beautyAdjustKey).vn() * 1.0f) / 100.0f, beautyAdjustKey);
                        }
                    }
                }
            }
        }

        @Override // com.baidu.live.ar.j
        public void vA() {
            AlaFilterAndBeautyData.BeautyAdjustKey[] values;
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (AlaFilterAndBeautyData.auH != null && AlaFilterAndBeautyData.auH.get(beautyAdjustKey) != null && !TextUtils.equals(beautyAdjustKey.getJsonKey(), AlaFilterAndBeautyData.BeautyAdjustKey.thinFace.getJsonKey())) {
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
            if (b.this.bll != null) {
                b.this.bll.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.live.ar.j
        public void onFilterSelected(String str, String str2, float f) {
            if (b.this.bll != null) {
                b.this.bll.onFilterSelected(str, str2, f);
            }
        }

        @Override // com.baidu.live.ar.j
        public void p(int i, int i2) {
            if (b.this.bll != null) {
                b.this.bll.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void q(int i, int i2) {
            if (b.this.bll != null) {
                b.this.bll.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void r(int i, int i2) {
            if (b.this.bll != null) {
                b.this.bll.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.live.ar.j
        public void s(int i, int i2) {
            if (b.this.bll != null) {
                b.this.bll.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private Context mContext;
    private ViewGroup mParent;

    public b(ViewGroup viewGroup, f fVar, AlaLiveRecorder alaLiveRecorder) {
        this.gfB = fVar;
        this.mContext = fVar.pageContext.getPageActivity();
        this.mParent = viewGroup;
        this.bll = alaLiveRecorder;
        if (az.b(com.baidu.live.v.a.Hm().bdV)) {
            com.baidu.live.ar.a aVar = new com.baidu.live.ar.a();
            aVar.atY = fVar.pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913176, ILiveMultiBeautyView.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gfC = (ILiveMultiBeautyView) runTask.getData();
                this.gfC.setArModel(fVar.ggw);
            }
        } else if (az.a(com.baidu.live.v.a.Hm().bdV)) {
            this.gfC = new AlaLiveMultiBeautyView(fVar.pageContext.getPageActivity());
        }
        this.gfC.setBdPageContext(this.gfB.pageContext);
        this.gfC.setOnEffectSelectedListener(this.gfD);
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig, boolean z) {
        if (this.gfC != null) {
            if (z) {
                this.gfC.vw();
            } else if (az.b(com.baidu.live.v.a.Hm().bdV)) {
                this.gfC.setViewData();
            } else if (az.a(com.baidu.live.v.a.Hm().bdV)) {
                com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
                dVar.ggd = 40;
                dVar.ggf = 5;
                dVar.ggg = 50;
                dVar.ggh = 50;
                dVar.CN(com.baidu.live.c.vf().getString("ala_beauty_5.4_config_str", ""));
                ((AlaLiveMultiBeautyView) this.gfC).setViewData(dVar, alaLiveVideoConfig);
            }
        }
    }

    public void bDY() {
        if (this.gfC != null) {
            this.gfC.vx();
        }
    }

    public void setVisible(int i) {
        if (this.gfC != null) {
            this.gfC.setVisibility(i);
        }
    }

    public void a(AlaLiveVideoConfig alaLiveVideoConfig) {
        if (this.gfC != null) {
            if (this.gfC.getParent() != null) {
                ((ViewGroup) this.gfC.getParent()).removeView(this.gfC);
            }
            if (TbadkCoreApplication.getInst().isNotMobileBaidu() && (this.mContext instanceof Activity)) {
                if (((Activity) this.mContext).getApplication().getResources().getConfiguration().orientation == 1) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    this.mParent.addView(this.gfC, layoutParams);
                } else {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
                    layoutParams2.gravity = 5;
                    this.mParent.addView(this.gfC, layoutParams2);
                }
            } else if (this.mContext.getResources().getConfiguration().orientation == 1) {
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.gravity = 80;
                this.mParent.addView(this.gfC, layoutParams3);
            } else {
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -1);
                layoutParams4.gravity = 5;
                this.mParent.addView(this.gfC, layoutParams4);
            }
            this.gfC.setVisibility(0);
        }
    }

    public void kT(boolean z) {
        if (this.gfC != null) {
            if (z) {
                this.gfC.vx();
            }
            if (this.gfC.getParent() != null) {
                ((ViewGroup) this.gfC.getParent()).removeView(this.gfC);
            }
            com.baidu.live.ar.d.avc.auS = AlaFilterAndBeautyData.BeautyAdjustKey.whiten.getJsonKey();
        }
    }
}
