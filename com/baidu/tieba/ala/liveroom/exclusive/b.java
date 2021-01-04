package com.baidu.tieba.ala.liveroom.exclusive;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.aj;
import com.baidu.live.data.v;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.view.AlphaGradientHListView;
import com.baidu.tieba.ala.liveroom.exclusive.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements View.OnClickListener, a.InterfaceC0679a, f {
    private boolean bAD;
    private View bPq;
    private com.baidu.live.v.f bsZ;
    private AlaLiveView hBQ;
    private View hCI;
    private AlphaGradientHListView hCJ;
    private a hCK;
    private View hCL;
    private TextView hCM;
    private TextView hCN;
    private v hCO;
    private View hCP;
    private e hCQ;
    private h hCS;
    private View hCT;
    private TextView hCU;
    private HeadImageView hCV;
    private ViewGroup hCW;
    private d hCX;
    private boolean hCY;
    private String hCZ;
    private AlaLiveInfoData hDa;
    private FrameLayout hue;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private aj hCR = new aj();

    public b(TbPageContext tbPageContext, com.baidu.live.v.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.bsZ = fVar;
        this.bPq = fVar.getLivePlayer();
        this.hBQ = alaLiveView;
        this.hue = frameLayout;
        this.hCP = view;
        this.hCQ = eVar;
        this.hCR.aMc = "全景视角";
        this.hCR.url = fVar.getVideoPath();
        this.hCZ = this.hCR.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        chC();
        oe(false);
        chD();
    }

    private void chC() {
        if (this.hCI == null) {
            this.hCI = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hCJ = (AlphaGradientHListView) this.hCI.findViewById(a.f.lv_scene_list);
            this.hCL = this.hCI.findViewById(a.f.ll_tip_container);
            this.hCN = (TextView) this.hCL.findViewById(a.f.tv_scene_tip);
            this.hCK = new a(this.mTbPageContext.getPageActivity(), true);
            this.hCK.a(this);
            this.hCJ.setAdapter((ListAdapter) this.hCK);
            this.hCJ.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hCJ.setDirection(2);
            this.hCJ.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hCJ.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hCY) {
                            b.this.hCY = true;
                            b.this.hCJ.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hCJ.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hCY) {
                                b.this.hCY = true;
                                b.this.hCJ.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hCJ.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hCY) {
                            b.this.hCY = false;
                            b.this.hCJ.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hCM = (TextView) this.hCI.findViewById(a.f.tv_all_scene);
            this.hCM.setOnClickListener(this);
        }
    }

    private void chD() {
        if (this.hCT == null) {
            this.hCT = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hCV = (HeadImageView) this.hCT.findViewById(a.f.iv_land_scene_avatar);
            this.hCV.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hCV.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hCV.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hCU = (TextView) this.hCT.findViewById(a.f.tv_land_scene_name);
            this.hCW = (ViewGroup) this.hCT.findViewById(a.f.ll_land_content_container);
            this.hCW.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (chE() && this.bAD && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hCO.EF(), this.hCO.EE(), true);
        }
    }

    private boolean chE() {
        return this.hCO != null && this.hCO.EC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(List<aj> list) {
        if (this.hCK != null) {
            this.hCK.setDatas(list);
        }
    }

    public void K(x xVar) {
        if (xVar != null) {
            this.hDa = xVar.mLiveInfo;
            if (xVar.aLn != null) {
                if (this.hCO == null) {
                    this.hCO = xVar.aLn;
                } else if (!b(xVar.aLn) || !a(xVar.aLn) || !this.bAD) {
                    if (!b(xVar.aLn) && a(xVar.aLn) && this.bAD) {
                        aja();
                        this.hCO = xVar.aLn;
                    } else {
                        this.hCO = xVar.aLn;
                    }
                } else {
                    return;
                }
                chG();
            }
        }
    }

    public void I(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "multi_session".equals(jSONObject.optString("content_type"))) {
                    dX(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void chF() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.bsZ != null) {
            String videoPath = this.bsZ.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hCZ) && this.hCR != null && this.hCR.url != null) {
                this.currentIndex = -1;
                chM();
                a(this.hCR, true);
                Iq(videoPath);
            }
        }
    }

    public void el(int i) {
        if (chE() && this.bAD) {
            if (i == 1) {
                chP();
                wS(i);
                chM();
            } else if (i == 2) {
                chN();
            }
            if (this.hCS != null) {
                this.hCS.dU(i);
            }
        }
    }

    public void Bf() {
        this.hCR.url = null;
        if (this.hDa != null) {
            this.hDa.playUrl = null;
        }
        aja();
    }

    private void dX(JSONObject jSONObject) {
        v z = v.z(jSONObject.optJSONObject("multi_session"));
        if (z != null) {
            if (this.hCO == null) {
                this.hCO = z;
            } else if (!b(z) || !a(z) || !this.bAD) {
                if (!b(z) && a(z) && this.bAD) {
                    aja();
                    this.hCO = z;
                } else {
                    this.hCO = z;
                }
            } else {
                return;
            }
            if (this.hCO != null) {
                chG();
            }
        }
    }

    private void chG() {
        String action = this.hCO.getAction();
        if (TextUtils.equals("1", action)) {
            if (chE()) {
                aiZ();
            }
        } else if (TextUtils.equals("2", action)) {
            aja();
        }
    }

    private void aiZ() {
        if (!this.bAD) {
            chL();
            this.bAD = true;
            chH();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.chJ();
                    if (!TextUtils.isEmpty(b.this.hCO.EG())) {
                        b.this.hCN.setText(b.this.hCO.EG());
                    }
                    b.this.cK(b.this.hCO.ED());
                    b.this.el(realScreenOrientation);
                    b.this.chU();
                    b.this.a(b.this.hCR, true);
                    if (b.this.hCQ != null) {
                        b.this.hCQ.wK(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.chQ();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.chR();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void chH() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void chI() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "visionbtn_clk").setContentExt(jSONObject));
    }

    private void d(boolean z, int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
            jSONObject.put("icon_pos", i);
            jSONObject.put("icon_name", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticItem ubcStatisticItem = new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "visionicon_clk");
        ubcStatisticItem.setContentExt(z ? "portrait" : "landscape", null, jSONObject);
        UbcStatisticManager.getInstance().logSendRequest(ubcStatisticItem);
    }

    private void aja() {
        if (this.bAD) {
            this.bAD = false;
            this.currentIndex = -1;
            chK();
            chP();
            if (a(this.hCR)) {
                Iq(this.hCR.url);
            }
            if (this.hCQ != null) {
                this.hCQ.wK(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chJ() {
        if (this.hCI.getParent() != null) {
            ((ViewGroup) this.hCI.getParent()).removeView(this.hCI);
        }
        if (this.hBQ != null) {
            this.hBQ.addView(this.hCI, (this.hCP != null ? this.hBQ.getView().indexOfChild(this.hCP) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void chK() {
        if (this.hCI.getParent() != null) {
            ((ViewGroup) this.hCI.getParent()).removeView(this.hCI);
        }
    }

    private void oe(boolean z) {
        if (this.hCI != null) {
            this.hCI.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(v vVar) {
        return this.hCO.gm(vVar.getAction());
    }

    private boolean b(v vVar) {
        return this.hCO.gn(vVar.getId());
    }

    private void chL() {
        if (this.bsZ != null) {
            this.hCR.url = this.bsZ.getVideoPath();
            this.hCZ = this.hCR.url;
        }
    }

    private void wS(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bPq != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hCI.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bPq.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bPq.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bPq.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            this.hCI.setLayoutParams(layoutParams);
            oe(true);
        }
    }

    private void chM() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hCM);
        }
        if (this.hCK != null) {
            this.hCK.wQ(this.currentIndex);
        }
        if (this.hCJ != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hCJ != null) {
                        b.this.hCJ.setSelection(b.this.currentIndex);
                        b.this.hCJ.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void chN() {
        chO();
    }

    private void chO() {
        oe(false);
        if (this.hCT != null && this.hue != null && this.mTbPageContext != null) {
            if (this.hCT.getParent() != null) {
                ((ViewGroup) this.hCT.getParent()).removeView(this.hCT);
            }
            int i = -1;
            if (this.hue != null) {
                i = this.hue.indexOfChild(this.hue.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.hue.addView(this.hCT, i + 1, layoutParams);
        }
    }

    private void chP() {
        if (this.hCT != null && this.hCT.getParent() != null) {
            ((ViewGroup) this.hCT.getParent()).removeView(this.hCT);
        }
        if (this.hCX != null && this.hCX.isShowing()) {
            this.hCX.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chQ() {
        if (this.hCL != null && this.hCL.getVisibility() != 0) {
            this.hCL.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chR() {
        if (this.hCL != null && this.hCL.getVisibility() == 0) {
            this.hCL.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bAD) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hCM == view) {
            if (this.hCR != null) {
                d(true, 1, this.hCR.aMc);
                this.currentIndex = -1;
                a(true, (View) this.hCM);
                if (this.hCK != null) {
                    this.hCK.wQ(this.currentIndex);
                }
                a(this.hCR, true);
                if (a(this.hCR)) {
                    Iq(this.hCR.url);
                }
            }
        } else if (this.hCW == view) {
            chI();
            chS();
        }
    }

    private void chS() {
        chT();
        if (!this.hCX.isShowing()) {
            this.hCX.a(this.hCO, this.currentIndex);
        }
    }

    private void chT() {
        if (this.hCX == null) {
            this.hCX = new d(this.mTbPageContext.getPageActivity());
            this.hCX.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0679a
    public void a(View view, int i, aj ajVar) {
        this.currentIndex = i;
        d(false, i + 2, ajVar.aMc);
        a(false, (View) this.hCM);
        a(ajVar, false);
        if (a(ajVar)) {
            Iq(ajVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, aj ajVar) {
        a(z, this.hCM);
        if (z) {
            if (this.hCR != null) {
                this.currentIndex = -1;
                d(false, 1, this.hCR.aMc);
                a(this.hCR, true);
                if (a(this.hCR)) {
                    Iq(this.hCR.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        d(false, i + 2, ajVar.aMc);
        a(ajVar, false);
        if (a(ajVar)) {
            Iq(ajVar.url);
        }
    }

    private boolean a(aj ajVar) {
        return (ajVar == null || TextUtils.isEmpty(ajVar.url) || TextUtils.equals(ajVar.url, this.hCZ)) ? false : true;
    }

    private void Iq(String str) {
        if (!TextUtils.isEmpty(str) && this.bsZ != null && this.hDa != null) {
            chV();
            this.hCZ = str;
            this.bsZ.cH(true);
            this.hDa.playUrl = str;
            this.bsZ.c(this.hDa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aj ajVar, boolean z) {
        if (ajVar != null) {
            chD();
            if (z) {
                this.hCV.setVisibility(8);
            } else {
                this.hCV.setVisibility(0);
                this.hCV.startLoad(ajVar.imageUrl, 10, false);
            }
            this.hCU.setText(ajVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chU() {
        if (this.hCO != null) {
            chD();
            c.a(this.mTbPageContext.getPageActivity(), this.hCW, true, this.hCO.EF(), this.hCO.EE(), true);
        }
    }

    private void chV() {
        chW();
        this.hCS.show();
    }

    private void hideLoadingView() {
        chW();
        this.hCS.dismiss();
    }

    private void chW() {
        if (this.hCS == null) {
            this.hCS = new h(this.mTbPageContext.getPageActivity(), this.bsZ.getLivePlayer());
        }
    }
}
