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
import com.baidu.live.data.ae;
import com.baidu.live.data.u;
import com.baidu.live.data.w;
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
public class b implements View.OnClickListener, a.InterfaceC0659a, f {
    private View bAX;
    private com.baidu.live.r.f bmp;
    private boolean bqZ;
    private FrameLayout gSL;
    private AlaLiveView haC;
    private View hbF;
    private AlphaGradientHListView hbG;
    private a hbH;
    private View hbI;
    private TextView hbJ;
    private TextView hbK;
    private u hbL;
    private View hbM;
    private e hbN;
    private h hbP;
    private View hbQ;
    private TextView hbR;
    private HeadImageView hbS;
    private ViewGroup hbT;
    private d hbU;
    private boolean hbV;
    private String hbW;
    private AlaLiveInfoData hbX;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private ae hbO = new ae();

    public b(TbPageContext tbPageContext, com.baidu.live.r.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.bmp = fVar;
        this.bAX = fVar.getLivePlayer();
        this.haC = alaLiveView;
        this.gSL = frameLayout;
        this.hbM = view;
        this.hbN = eVar;
        this.hbO.aJp = "全景视角";
        this.hbO.url = fVar.getVideoPath();
        this.hbW = this.hbO.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        bYX();
        mZ(false);
        bYY();
    }

    private void bYX() {
        if (this.hbF == null) {
            this.hbF = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hbG = (AlphaGradientHListView) this.hbF.findViewById(a.g.lv_scene_list);
            this.hbI = this.hbF.findViewById(a.g.ll_tip_container);
            this.hbK = (TextView) this.hbI.findViewById(a.g.tv_scene_tip);
            this.hbH = new a(this.mTbPageContext.getPageActivity(), true);
            this.hbH.a(this);
            this.hbG.setAdapter((ListAdapter) this.hbH);
            this.hbG.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.hbG.setDirection(2);
            this.hbG.setColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha100));
            this.hbG.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hbV) {
                            b.this.hbV = true;
                            b.this.hbG.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                            b.this.hbG.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hbV) {
                                b.this.hbV = true;
                                b.this.hbG.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                                b.this.hbG.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hbV) {
                            b.this.hbV = false;
                            b.this.hbG.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hbJ = (TextView) this.hbF.findViewById(a.g.tv_all_scene);
            this.hbJ.setOnClickListener(this);
        }
    }

    private void bYY() {
        if (this.hbQ == null) {
            this.hbQ = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hbS = (HeadImageView) this.hbQ.findViewById(a.g.iv_land_scene_avatar);
            this.hbS.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hbS.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
            this.hbS.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
            this.hbR = (TextView) this.hbQ.findViewById(a.g.tv_land_scene_name);
            this.hbT = (ViewGroup) this.hbQ.findViewById(a.g.ll_land_content_container);
            this.hbT.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (bYZ() && this.bqZ && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hbL.DU(), this.hbL.DT(), true);
        }
    }

    private boolean bYZ() {
        return this.hbL != null && this.hbL.DR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(List<ae> list) {
        if (this.hbH != null) {
            this.hbH.setDatas(list);
        }
    }

    public void A(w wVar) {
        if (wVar != null) {
            this.hbX = wVar.mLiveInfo;
            if (wVar.aIT != null) {
                if (this.hbL == null) {
                    this.hbL = wVar.aIT;
                } else if (!b(wVar.aIT) || !a(wVar.aIT) || !this.bqZ) {
                    if (!b(wVar.aIT) && a(wVar.aIT) && this.bqZ) {
                        acR();
                        this.hbL = wVar.aIT;
                    } else {
                        this.hbL = wVar.aIT;
                    }
                } else {
                    return;
                }
                bZb();
            }
        }
    }

    public void C(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "multi_session".equals(jSONObject.optString("content_type"))) {
                    dM(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void bZa() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.bmp != null) {
            String videoPath = this.bmp.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hbW) && this.hbO != null && this.hbO.url != null) {
                this.currentIndex = -1;
                bZh();
                a(this.hbO, true);
                HI(videoPath);
            }
        }
    }

    public void dX(int i) {
        if (bYZ() && this.bqZ) {
            if (i == 1) {
                bZk();
                vr(i);
                bZh();
            } else if (i == 2) {
                bZi();
            }
            if (this.hbP != null) {
                this.hbP.dI(i);
            }
        }
    }

    public void Kj() {
        this.hbO.url = null;
        if (this.hbX != null) {
            this.hbX.playUrl = null;
        }
        acR();
    }

    private void dM(JSONObject jSONObject) {
        u w = u.w(jSONObject.optJSONObject("multi_session"));
        if (w != null) {
            if (this.hbL == null) {
                this.hbL = w;
            } else if (!b(w) || !a(w) || !this.bqZ) {
                if (!b(w) && a(w) && this.bqZ) {
                    acR();
                    this.hbL = w;
                } else {
                    this.hbL = w;
                }
            } else {
                return;
            }
            if (this.hbL != null) {
                bZb();
            }
        }
    }

    private void bZb() {
        String action = this.hbL.getAction();
        if (TextUtils.equals("1", action)) {
            if (bYZ()) {
                acQ();
            }
        } else if (TextUtils.equals("2", action)) {
            acR();
        }
    }

    private void acQ() {
        if (!this.bqZ) {
            bZg();
            this.bqZ = true;
            bZc();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.bZe();
                    if (!TextUtils.isEmpty(b.this.hbL.DV())) {
                        b.this.hbK.setText(b.this.hbL.DV());
                    }
                    b.this.cr(b.this.hbL.DS());
                    b.this.dX(realScreenOrientation);
                    b.this.bZp();
                    b.this.a(b.this.hbO, true);
                    if (b.this.hbN != null) {
                        b.this.hbN.vj(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bZl();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bZm();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void bZc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void bZd() {
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

    private void acR() {
        if (this.bqZ) {
            this.bqZ = false;
            this.currentIndex = -1;
            bZf();
            bZk();
            if (a(this.hbO)) {
                HI(this.hbO.url);
            }
            if (this.hbN != null) {
                this.hbN.vj(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZe() {
        if (this.hbF.getParent() != null) {
            ((ViewGroup) this.hbF.getParent()).removeView(this.hbF);
        }
        if (this.haC != null) {
            this.haC.addView(this.hbF, (this.hbM != null ? this.haC.getView().indexOfChild(this.hbM) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void bZf() {
        if (this.hbF.getParent() != null) {
            ((ViewGroup) this.hbF.getParent()).removeView(this.hbF);
        }
    }

    private void mZ(boolean z) {
        if (this.hbF != null) {
            this.hbF.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(u uVar) {
        return this.hbL.gj(uVar.getAction());
    }

    private boolean b(u uVar) {
        return this.hbL.gk(uVar.getId());
    }

    private void bZg() {
        if (this.bmp != null) {
            this.hbO.url = this.bmp.getVideoPath();
            this.hbW = this.hbO.url;
        }
    }

    private void vr(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bAX != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hbF.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bAX.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bAX.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bAX.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds80);
            }
            this.hbF.setLayoutParams(layoutParams);
            mZ(true);
        }
    }

    private void bZh() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hbJ);
        }
        if (this.hbH != null) {
            this.hbH.vp(this.currentIndex);
        }
        if (this.hbG != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hbG != null) {
                        b.this.hbG.setSelection(b.this.currentIndex);
                        b.this.hbG.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void bZi() {
        bZj();
    }

    private void bZj() {
        mZ(false);
        if (this.hbQ != null && this.gSL != null && this.mTbPageContext != null) {
            if (this.hbQ.getParent() != null) {
                ((ViewGroup) this.hbQ.getParent()).removeView(this.hbQ);
            }
            int i = -1;
            if (this.gSL != null) {
                i = this.gSL.indexOfChild(this.gSL.findViewById(a.g.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds26);
            this.gSL.addView(this.hbQ, i + 1, layoutParams);
        }
    }

    private void bZk() {
        if (this.hbQ != null && this.hbQ.getParent() != null) {
            ((ViewGroup) this.hbQ.getParent()).removeView(this.hbQ);
        }
        if (this.hbU != null && this.hbU.isShowing()) {
            this.hbU.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZl() {
        if (this.hbI != null && this.hbI.getVisibility() != 0) {
            this.hbI.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZm() {
        if (this.hbI != null && this.hbI.getVisibility() == 0) {
            this.hbI.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bqZ) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hbJ == view) {
            if (this.hbO != null) {
                c(true, 1, this.hbO.aJp);
                this.currentIndex = -1;
                a(true, (View) this.hbJ);
                if (this.hbH != null) {
                    this.hbH.vp(this.currentIndex);
                }
                a(this.hbO, true);
                if (a(this.hbO)) {
                    HI(this.hbO.url);
                }
            }
        } else if (this.hbT == view) {
            bZd();
            bZn();
        }
    }

    private void bZn() {
        bZo();
        if (!this.hbU.isShowing()) {
            this.hbU.a(this.hbL, this.currentIndex);
        }
    }

    private void bZo() {
        if (this.hbU == null) {
            this.hbU = new d(this.mTbPageContext.getPageActivity());
            this.hbU.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0659a
    public void a(View view, int i, ae aeVar) {
        this.currentIndex = i;
        c(false, i + 2, aeVar.aJp);
        a(false, (View) this.hbJ);
        a(aeVar, false);
        if (a(aeVar)) {
            HI(aeVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, ae aeVar) {
        a(z, this.hbJ);
        if (z) {
            if (this.hbO != null) {
                this.currentIndex = -1;
                c(false, 1, this.hbO.aJp);
                a(this.hbO, true);
                if (a(this.hbO)) {
                    HI(this.hbO.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, aeVar.aJp);
        a(aeVar, false);
        if (a(aeVar)) {
            HI(aeVar.url);
        }
    }

    private boolean a(ae aeVar) {
        return (aeVar == null || TextUtils.isEmpty(aeVar.url) || TextUtils.equals(aeVar.url, this.hbW)) ? false : true;
    }

    private void HI(String str) {
        if (!TextUtils.isEmpty(str) && this.bmp != null && this.hbX != null) {
            bZq();
            this.hbW = str;
            this.bmp.cn(true);
            this.hbX.playUrl = str;
            this.bmp.c(this.hbX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ae aeVar, boolean z) {
        if (aeVar != null) {
            bYY();
            if (z) {
                this.hbS.setVisibility(8);
            } else {
                this.hbS.setVisibility(0);
                this.hbS.startLoad(aeVar.imageUrl, 10, false);
            }
            this.hbR.setText(aeVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZp() {
        if (this.hbL != null) {
            bYY();
            c.a(this.mTbPageContext.getPageActivity(), this.hbT, true, this.hbL.DU(), this.hbL.DT(), true);
        }
    }

    private void bZq() {
        bZr();
        this.hbP.show();
    }

    private void hideLoadingView() {
        bZr();
        this.hbP.dismiss();
    }

    private void bZr() {
        if (this.hbP == null) {
            this.hbP = new h(this.mTbPageContext.getPageActivity(), this.bmp.getLivePlayer());
        }
    }
}
