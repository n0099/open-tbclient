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
import com.baidu.live.data.ab;
import com.baidu.live.data.an;
import com.baidu.live.data.z;
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
public class b implements View.OnClickListener, a.InterfaceC0663a, f {
    private View bOo;
    private com.baidu.live.u.f brO;
    private boolean bzt;
    private AlaLiveView hBI;
    private View hCA;
    private AlphaGradientHListView hCB;
    private a hCC;
    private View hCD;
    private TextView hCE;
    private TextView hCF;
    private z hCG;
    private View hCH;
    private e hCI;
    private h hCK;
    private View hCL;
    private TextView hCM;
    private HeadImageView hCN;
    private ViewGroup hCO;
    private d hCP;
    private boolean hCQ;
    private String hCR;
    private AlaLiveInfoData hCS;
    private FrameLayout htX;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private an hCJ = new an();

    public b(TbPageContext tbPageContext, com.baidu.live.u.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.brO = fVar;
        this.bOo = fVar.getLivePlayer();
        this.hBI = alaLiveView;
        this.htX = frameLayout;
        this.hCH = view;
        this.hCI = eVar;
        this.hCJ.aJU = "全景视角";
        this.hCJ.url = fVar.getVideoPath();
        this.hCR = this.hCJ.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        ceN();
        ol(false);
        ceO();
    }

    private void ceN() {
        if (this.hCA == null) {
            this.hCA = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hCB = (AlphaGradientHListView) this.hCA.findViewById(a.f.lv_scene_list);
            this.hCD = this.hCA.findViewById(a.f.ll_tip_container);
            this.hCF = (TextView) this.hCD.findViewById(a.f.tv_scene_tip);
            this.hCC = new a(this.mTbPageContext.getPageActivity(), true);
            this.hCC.a(this);
            this.hCB.setAdapter((ListAdapter) this.hCC);
            this.hCB.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hCB.setDirection(2);
            this.hCB.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hCB.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hCQ) {
                            b.this.hCQ = true;
                            b.this.hCB.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hCB.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hCQ) {
                                b.this.hCQ = true;
                                b.this.hCB.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hCB.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hCQ) {
                            b.this.hCQ = false;
                            b.this.hCB.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hCE = (TextView) this.hCA.findViewById(a.f.tv_all_scene);
            this.hCE.setOnClickListener(this);
        }
    }

    private void ceO() {
        if (this.hCL == null) {
            this.hCL = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hCN = (HeadImageView) this.hCL.findViewById(a.f.iv_land_scene_avatar);
            this.hCN.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hCN.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
            this.hCN.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
            this.hCM = (TextView) this.hCL.findViewById(a.f.tv_land_scene_name);
            this.hCO = (ViewGroup) this.hCL.findViewById(a.f.ll_land_content_container);
            this.hCO.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (ceP() && this.bzt && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hCG.BX(), this.hCG.BW(), true);
        }
    }

    private boolean ceP() {
        return this.hCG != null && this.hCG.BU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(List<an> list) {
        if (this.hCC != null) {
            this.hCC.setDatas(list);
        }
    }

    public void L(ab abVar) {
        if (abVar != null) {
            this.hCS = abVar.mLiveInfo;
            if (abVar.aIW != null) {
                if (this.hCG == null) {
                    this.hCG = abVar.aIW;
                } else if (!b(abVar.aIW) || !a(abVar.aIW) || !this.bzt) {
                    if (!b(abVar.aIW) && a(abVar.aIW) && this.bzt) {
                        afG();
                        this.hCG = abVar.aIW;
                    } else {
                        this.hCG = abVar.aIW;
                    }
                } else {
                    return;
                }
                ceR();
            }
        }
    }

    public void N(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "multi_session".equals(jSONObject.optString("content_type"))) {
                    dY(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void ceQ() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.brO != null) {
            String videoPath = this.brO.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hCR) && this.hCJ != null && this.hCJ.url != null) {
                this.currentIndex = -1;
                ceX();
                a(this.hCJ, true);
                HJ(videoPath);
            }
        }
    }

    public void cK(int i) {
        if (ceP() && this.bzt) {
            if (i == 1) {
                cfa();
                vx(i);
                ceX();
            } else if (i == 2) {
                ceY();
            }
            if (this.hCK != null) {
                this.hCK.cr(i);
            }
        }
    }

    public void xh() {
        this.hCJ.url = null;
        if (this.hCS != null) {
            this.hCS.playUrl = null;
        }
        afG();
    }

    private void dY(JSONObject jSONObject) {
        z z = z.z(jSONObject.optJSONObject("multi_session"));
        if (z != null) {
            if (this.hCG == null) {
                this.hCG = z;
            } else if (!b(z) || !a(z) || !this.bzt) {
                if (!b(z) && a(z) && this.bzt) {
                    afG();
                    this.hCG = z;
                } else {
                    this.hCG = z;
                }
            } else {
                return;
            }
            if (this.hCG != null) {
                ceR();
            }
        }
    }

    private void ceR() {
        String action = this.hCG.getAction();
        if (TextUtils.equals("1", action)) {
            if (ceP()) {
                afF();
            }
        } else if (TextUtils.equals("2", action)) {
            afG();
        }
    }

    private void afF() {
        if (!this.bzt) {
            ceW();
            this.bzt = true;
            ceS();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.ceU();
                    if (!TextUtils.isEmpty(b.this.hCG.BY())) {
                        b.this.hCF.setText(b.this.hCG.BY());
                    }
                    b.this.cF(b.this.hCG.BV());
                    b.this.cK(realScreenOrientation);
                    b.this.cff();
                    b.this.a(b.this.hCJ, true);
                    if (b.this.hCI != null) {
                        b.this.hCI.vp(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cfb();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cfc();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void ceS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void ceT() {
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

    private void afG() {
        if (this.bzt) {
            this.bzt = false;
            this.currentIndex = -1;
            ceV();
            cfa();
            if (a(this.hCJ)) {
                HJ(this.hCJ.url);
            }
            if (this.hCI != null) {
                this.hCI.vp(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        if (this.hCA.getParent() != null) {
            ((ViewGroup) this.hCA.getParent()).removeView(this.hCA);
        }
        if (this.hBI != null) {
            this.hBI.addView(this.hCA, (this.hCH != null ? this.hBI.getView().indexOfChild(this.hCH) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void ceV() {
        if (this.hCA.getParent() != null) {
            ((ViewGroup) this.hCA.getParent()).removeView(this.hCA);
        }
    }

    private void ol(boolean z) {
        if (this.hCA != null) {
            this.hCA.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(z zVar) {
        return this.hCG.fw(zVar.getAction());
    }

    private boolean b(z zVar) {
        return this.hCG.fx(zVar.getId());
    }

    private void ceW() {
        if (this.brO != null) {
            this.hCJ.url = this.brO.getVideoPath();
            this.hCR = this.hCJ.url;
        }
    }

    private void vx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bOo != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hCA.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bOo.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bOo.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bOo.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            this.hCA.setLayoutParams(layoutParams);
            ol(true);
        }
    }

    private void ceX() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hCE);
        }
        if (this.hCC != null) {
            this.hCC.vv(this.currentIndex);
        }
        if (this.hCB != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hCB != null) {
                        b.this.hCB.setSelection(b.this.currentIndex);
                        b.this.hCB.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void ceY() {
        ceZ();
    }

    private void ceZ() {
        ol(false);
        if (this.hCL != null && this.htX != null && this.mTbPageContext != null) {
            if (this.hCL.getParent() != null) {
                ((ViewGroup) this.hCL.getParent()).removeView(this.hCL);
            }
            int i = -1;
            if (this.htX != null) {
                i = this.htX.indexOfChild(this.htX.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.htX.addView(this.hCL, i + 1, layoutParams);
        }
    }

    private void cfa() {
        if (this.hCL != null && this.hCL.getParent() != null) {
            ((ViewGroup) this.hCL.getParent()).removeView(this.hCL);
        }
        if (this.hCP != null && this.hCP.isShowing()) {
            this.hCP.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfb() {
        if (this.hCD != null && this.hCD.getVisibility() != 0) {
            this.hCD.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfc() {
        if (this.hCD != null && this.hCD.getVisibility() == 0) {
            this.hCD.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bzt) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hCE == view) {
            if (this.hCJ != null) {
                d(true, 1, this.hCJ.aJU);
                this.currentIndex = -1;
                a(true, (View) this.hCE);
                if (this.hCC != null) {
                    this.hCC.vv(this.currentIndex);
                }
                a(this.hCJ, true);
                if (a(this.hCJ)) {
                    HJ(this.hCJ.url);
                }
            }
        } else if (this.hCO == view) {
            ceT();
            cfd();
        }
    }

    private void cfd() {
        cfe();
        if (!this.hCP.isShowing()) {
            this.hCP.a(this.hCG, this.currentIndex);
        }
    }

    private void cfe() {
        if (this.hCP == null) {
            this.hCP = new d(this.mTbPageContext.getPageActivity());
            this.hCP.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0663a
    public void a(View view, int i, an anVar) {
        this.currentIndex = i;
        d(false, i + 2, anVar.aJU);
        a(false, (View) this.hCE);
        a(anVar, false);
        if (a(anVar)) {
            HJ(anVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, an anVar) {
        a(z, this.hCE);
        if (z) {
            if (this.hCJ != null) {
                this.currentIndex = -1;
                d(false, 1, this.hCJ.aJU);
                a(this.hCJ, true);
                if (a(this.hCJ)) {
                    HJ(this.hCJ.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        d(false, i + 2, anVar.aJU);
        a(anVar, false);
        if (a(anVar)) {
            HJ(anVar.url);
        }
    }

    private boolean a(an anVar) {
        return (anVar == null || TextUtils.isEmpty(anVar.url) || TextUtils.equals(anVar.url, this.hCR)) ? false : true;
    }

    private void HJ(String str) {
        if (!TextUtils.isEmpty(str) && this.brO != null && this.hCS != null) {
            cfg();
            this.hCR = str;
            this.brO.cM(true);
            this.hCS.playUrl = str;
            this.brO.c(this.hCS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar, boolean z) {
        if (anVar != null) {
            ceO();
            if (z) {
                this.hCN.setVisibility(8);
            } else {
                this.hCN.setVisibility(0);
                this.hCN.startLoad(anVar.imageUrl, 10, false);
            }
            this.hCM.setText(anVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cff() {
        if (this.hCG != null) {
            ceO();
            c.a(this.mTbPageContext.getPageActivity(), this.hCO, true, this.hCG.BX(), this.hCG.BW(), true);
        }
    }

    private void cfg() {
        cfh();
        this.hCK.show();
    }

    private void hideLoadingView() {
        cfh();
        this.hCK.dismiss();
    }

    private void cfh() {
        if (this.hCK == null) {
            this.hCK = new h(this.mTbPageContext.getPageActivity(), this.brO.getLivePlayer());
        }
    }
}
