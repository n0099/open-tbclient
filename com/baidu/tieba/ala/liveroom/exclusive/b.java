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
import com.baidu.live.data.ac;
import com.baidu.live.data.r;
import com.baidu.live.data.u;
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
/* loaded from: classes4.dex */
public class b implements View.OnClickListener, a.InterfaceC0625a, f {
    private com.baidu.live.q.f bhe;
    private boolean blz;
    private View btX;
    private AlaLiveView gAv;
    private a gBA;
    private View gBB;
    private TextView gBC;
    private TextView gBD;
    private r gBE;
    private View gBF;
    private e gBG;
    private h gBI;
    private View gBJ;
    private TextView gBK;
    private HeadImageView gBL;
    private ViewGroup gBM;
    private d gBN;
    private boolean gBO;
    private String gBP;
    private AlaLiveInfoData gBQ;
    private View gBy;
    private AlphaGradientHListView gBz;
    private FrameLayout gsB;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private ac gBH = new ac();

    public b(TbPageContext tbPageContext, com.baidu.live.q.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.bhe = fVar;
        this.btX = fVar.getLivePlayer();
        this.gAv = alaLiveView;
        this.gsB = frameLayout;
        this.gBF = view;
        this.gBG = eVar;
        this.gBH.aFK = "全景视角";
        this.gBH.url = fVar.getVideoPath();
        this.gBP = this.gBH.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        bSF();
        mh(false);
        bSG();
    }

    private void bSF() {
        if (this.gBy == null) {
            this.gBy = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.gBz = (AlphaGradientHListView) this.gBy.findViewById(a.g.lv_scene_list);
            this.gBB = this.gBy.findViewById(a.g.ll_tip_container);
            this.gBD = (TextView) this.gBB.findViewById(a.g.tv_scene_tip);
            this.gBA = new a(this.mTbPageContext.getPageActivity(), true);
            this.gBA.a(this);
            this.gBz.setAdapter((ListAdapter) this.gBA);
            this.gBz.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gBz.setDirection(2);
            this.gBz.setColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha100));
            this.gBz.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.gBO) {
                            b.this.gBO = true;
                            b.this.gBz.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                            b.this.gBz.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.gBO) {
                                b.this.gBO = true;
                                b.this.gBz.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                                b.this.gBz.setNeedAlphaShade(true);
                            }
                        } else if (b.this.gBO) {
                            b.this.gBO = false;
                            b.this.gBz.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.gBC = (TextView) this.gBy.findViewById(a.g.tv_all_scene);
            this.gBC.setOnClickListener(this);
        }
    }

    private void bSG() {
        if (this.gBJ == null) {
            this.gBJ = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.gBL = (HeadImageView) this.gBJ.findViewById(a.g.iv_land_scene_avatar);
            this.gBL.setScaleType(ImageView.ScaleType.FIT_XY);
            this.gBL.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gBL.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gBK = (TextView) this.gBJ.findViewById(a.g.tv_land_scene_name);
            this.gBM = (ViewGroup) this.gBJ.findViewById(a.g.ll_land_content_container);
            this.gBM.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (bSH() && this.blz && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.gBE.CO(), this.gBE.CN(), true);
        }
    }

    private boolean bSH() {
        return this.gBE != null && this.gBE.CL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ce(List<ac> list) {
        if (this.gBA != null) {
            this.gBA.setDatas(list);
        }
    }

    public void w(u uVar) {
        if (uVar != null) {
            this.gBQ = uVar.mLiveInfo;
            if (uVar.aFs != null) {
                if (this.gBE == null) {
                    this.gBE = uVar.aFs;
                } else if (!b(uVar.aFs) || !a(uVar.aFs) || !this.blz) {
                    if (!b(uVar.aFs) && a(uVar.aFs) && this.blz) {
                        Yl();
                        this.gBE = uVar.aFs;
                    } else {
                        this.gBE = uVar.aFs;
                    }
                } else {
                    return;
                }
                bSJ();
            }
        }
    }

    public void y(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "multi_session".equals(jSONObject.optString("content_type"))) {
                    dC(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void bSI() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.bhe != null) {
            String videoPath = this.bhe.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.gBP) && this.gBH != null && this.gBH.url != null) {
                this.currentIndex = -1;
                bSP();
                a(this.gBH, true);
                Gx(videoPath);
            }
        }
    }

    public void eQ(int i) {
        if (bSH() && this.blz) {
            if (i == 1) {
                bSS();
                us(i);
                bSP();
            } else if (i == 2) {
                bSQ();
            }
            if (this.gBI != null) {
                this.gBI.dD(i);
            }
        }
    }

    public void IT() {
        this.gBH.url = null;
        if (this.gBQ != null) {
            this.gBQ.playUrl = null;
        }
        Yl();
    }

    private void dC(JSONObject jSONObject) {
        r w = r.w(jSONObject.optJSONObject("multi_session"));
        if (w != null) {
            if (this.gBE == null) {
                this.gBE = w;
            } else if (!b(w) || !a(w) || !this.blz) {
                if (!b(w) && a(w) && this.blz) {
                    Yl();
                    this.gBE = w;
                } else {
                    this.gBE = w;
                }
            } else {
                return;
            }
            if (this.gBE != null) {
                bSJ();
            }
        }
    }

    private void bSJ() {
        String action = this.gBE.getAction();
        if (TextUtils.equals("1", action)) {
            if (bSH()) {
                Yk();
            }
        } else if (TextUtils.equals("2", action)) {
            Yl();
        }
    }

    private void Yk() {
        if (!this.blz) {
            bSO();
            this.blz = true;
            bSK();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.bSM();
                    if (!TextUtils.isEmpty(b.this.gBE.CP())) {
                        b.this.gBD.setText(b.this.gBE.CP());
                    }
                    b.this.ce(b.this.gBE.CM());
                    b.this.eQ(realScreenOrientation);
                    b.this.bSX();
                    b.this.a(b.this.gBH, true);
                    if (b.this.gBG != null) {
                        b.this.gBG.uk(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bST();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bSU();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void bSK() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void bSL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "visionbtn_clk").setContentExt(jSONObject));
    }

    private void c(boolean z, int i, String str) {
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

    private void Yl() {
        if (this.blz) {
            this.blz = false;
            this.currentIndex = -1;
            bSN();
            bSS();
            if (a(this.gBH)) {
                Gx(this.gBH.url);
            }
            if (this.gBG != null) {
                this.gBG.uk(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSM() {
        if (this.gBy.getParent() != null) {
            ((ViewGroup) this.gBy.getParent()).removeView(this.gBy);
        }
        if (this.gAv != null) {
            this.gAv.addView(this.gBy, (this.gBF != null ? this.gAv.getView().indexOfChild(this.gBF) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void bSN() {
        if (this.gBy.getParent() != null) {
            ((ViewGroup) this.gBy.getParent()).removeView(this.gBy);
        }
    }

    private void mh(boolean z) {
        if (this.gBy != null) {
            this.gBy.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(r rVar) {
        return this.gBE.fU(rVar.getAction());
    }

    private boolean b(r rVar) {
        return this.gBE.fV(rVar.getId());
    }

    private void bSO() {
        if (this.bhe != null) {
            this.gBH.url = this.bhe.getVideoPath();
            this.gBP = this.gBH.url;
        }
    }

    private void us(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.btX != null && (layoutParams = (RelativeLayout.LayoutParams) this.gBy.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.btX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.btX.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.btX.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds80);
            }
            this.gBy.setLayoutParams(layoutParams);
            mh(true);
        }
    }

    private void bSP() {
        if (this.currentIndex == -1) {
            a(true, (View) this.gBC);
        }
        if (this.gBA != null) {
            this.gBA.uq(this.currentIndex);
        }
        if (this.gBz != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gBz != null) {
                        b.this.gBz.setSelection(b.this.currentIndex);
                        b.this.gBz.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void bSQ() {
        bSR();
    }

    private void bSR() {
        mh(false);
        if (this.gBJ != null && this.gsB != null) {
            if (this.gBJ.getParent() != null) {
                ((ViewGroup) this.gBJ.getParent()).removeView(this.gBJ);
            }
            int i = -1;
            if (this.gsB != null) {
                i = this.gsB.indexOfChild(this.gsB.findViewById(a.g.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds26);
            this.gsB.addView(this.gBJ, i + 1, layoutParams);
        }
    }

    private void bSS() {
        if (this.gBJ != null && this.gBJ.getParent() != null) {
            ((ViewGroup) this.gBJ.getParent()).removeView(this.gBJ);
        }
        if (this.gBN != null && this.gBN.isShowing()) {
            this.gBN.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bST() {
        if (this.gBB != null && this.gBB.getVisibility() != 0) {
            this.gBB.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSU() {
        if (this.gBB != null && this.gBB.getVisibility() == 0) {
            this.gBB.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.blz) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gBC == view) {
            if (this.gBH != null) {
                c(true, 1, this.gBH.aFK);
                this.currentIndex = -1;
                a(true, (View) this.gBC);
                if (this.gBA != null) {
                    this.gBA.uq(this.currentIndex);
                }
                a(this.gBH, true);
                if (a(this.gBH)) {
                    Gx(this.gBH.url);
                }
            }
        } else if (this.gBM == view) {
            bSL();
            bSV();
        }
    }

    private void bSV() {
        bSW();
        if (!this.gBN.isShowing()) {
            this.gBN.a(this.gBE, this.currentIndex);
        }
    }

    private void bSW() {
        if (this.gBN == null) {
            this.gBN = new d(this.mTbPageContext.getPageActivity());
            this.gBN.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0625a
    public void a(View view, int i, ac acVar) {
        this.currentIndex = i;
        c(false, i + 2, acVar.aFK);
        a(false, (View) this.gBC);
        a(acVar, false);
        if (a(acVar)) {
            Gx(acVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, ac acVar) {
        a(z, this.gBC);
        if (z) {
            if (this.gBH != null) {
                this.currentIndex = -1;
                c(false, 1, this.gBH.aFK);
                a(this.gBH, true);
                if (a(this.gBH)) {
                    Gx(this.gBH.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, acVar.aFK);
        a(acVar, false);
        if (a(acVar)) {
            Gx(acVar.url);
        }
    }

    private boolean a(ac acVar) {
        return (acVar == null || TextUtils.isEmpty(acVar.url) || TextUtils.equals(acVar.url, this.gBP)) ? false : true;
    }

    private void Gx(String str) {
        if (!TextUtils.isEmpty(str) && this.bhe != null && this.gBQ != null) {
            bSY();
            this.gBP = str;
            this.bhe.ci(true);
            this.gBQ.playUrl = str;
            this.bhe.c(this.gBQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ac acVar, boolean z) {
        if (acVar != null) {
            bSG();
            if (z) {
                this.gBL.setVisibility(8);
            } else {
                this.gBL.setVisibility(0);
                this.gBL.startLoad(acVar.imageUrl, 10, false);
            }
            this.gBK.setText(acVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSX() {
        if (this.gBE != null) {
            bSG();
            c.a(this.mTbPageContext.getPageActivity(), this.gBM, true, this.gBE.CO(), this.gBE.CN(), true);
        }
    }

    private void bSY() {
        bSZ();
        this.gBI.show();
    }

    private void hideLoadingView() {
        bSZ();
        this.gBI.dismiss();
    }

    private void bSZ() {
        if (this.gBI == null) {
            this.gBI = new h(this.mTbPageContext.getPageActivity(), this.bhe.getLivePlayer());
        }
    }
}
