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
import com.baidu.live.data.o;
import com.baidu.live.data.r;
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
/* loaded from: classes7.dex */
public class b implements View.OnClickListener, a.InterfaceC0629a, f {
    private com.baidu.live.p.f ben;
    private boolean biF;
    private View bqJ;
    private FrameLayout gpn;
    private AlaLiveView gxj;
    private HeadImageView gyA;
    private ViewGroup gyB;
    private d gyC;
    private boolean gyD;
    private String gyE;
    private AlaLiveInfoData gyF;
    private View gyn;
    private AlphaGradientHListView gyo;
    private a gyp;
    private View gyq;
    private TextView gyr;
    private TextView gys;
    private o gyt;
    private View gyu;
    private e gyv;
    private h gyx;
    private View gyy;
    private TextView gyz;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private x gyw = new x();

    public b(TbPageContext tbPageContext, com.baidu.live.p.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.ben = fVar;
        this.bqJ = fVar.getLivePlayer();
        this.gxj = alaLiveView;
        this.gpn = frameLayout;
        this.gyu = view;
        this.gyv = eVar;
        this.gyw.aEz = "全景视角";
        this.gyw.url = fVar.getVideoPath();
        this.gyE = this.gyw.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        bRj();
        me(false);
        bRk();
    }

    private void bRj() {
        if (this.gyn == null) {
            this.gyn = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.gyo = (AlphaGradientHListView) this.gyn.findViewById(a.g.lv_scene_list);
            this.gyq = this.gyn.findViewById(a.g.ll_tip_container);
            this.gys = (TextView) this.gyq.findViewById(a.g.tv_scene_tip);
            this.gyp = new a(this.mTbPageContext.getPageActivity(), true);
            this.gyp.a(this);
            this.gyo.setAdapter((ListAdapter) this.gyp);
            this.gyo.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gyo.setDirection(2);
            this.gyo.setColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha100));
            this.gyo.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.gyD) {
                            b.this.gyD = true;
                            b.this.gyo.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                            b.this.gyo.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.gyD) {
                                b.this.gyD = true;
                                b.this.gyo.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                                b.this.gyo.setNeedAlphaShade(true);
                            }
                        } else if (b.this.gyD) {
                            b.this.gyD = false;
                            b.this.gyo.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.gyr = (TextView) this.gyn.findViewById(a.g.tv_all_scene);
            this.gyr.setOnClickListener(this);
        }
    }

    private void bRk() {
        if (this.gyy == null) {
            this.gyy = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.gyA = (HeadImageView) this.gyy.findViewById(a.g.iv_land_scene_avatar);
            this.gyA.setScaleType(ImageView.ScaleType.FIT_XY);
            this.gyA.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gyA.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gyz = (TextView) this.gyy.findViewById(a.g.tv_land_scene_name);
            this.gyB = (ViewGroup) this.gyy.findViewById(a.g.ll_land_content_container);
            this.gyB.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (bRl() && this.biF && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.gyt.Cz(), this.gyt.Cy(), true);
        }
    }

    private boolean bRl() {
        return this.gyt != null && this.gyt.Cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(List<x> list) {
        if (this.gyp != null) {
            this.gyp.setDatas(list);
        }
    }

    public void u(r rVar) {
        if (rVar != null) {
            this.gyF = rVar.mLiveInfo;
            if (rVar.aEt != null) {
                if (this.gyt == null) {
                    this.gyt = rVar.aEt;
                } else if (!b(rVar.aEt) || !a(rVar.aEt) || !this.biF) {
                    if (!b(rVar.aEt) && a(rVar.aEt) && this.biF) {
                        XC();
                        this.gyt = rVar.aEt;
                    } else {
                        this.gyt = rVar.aEt;
                    }
                } else {
                    return;
                }
                bRn();
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
                    dw(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void bRm() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.ben != null) {
            String videoPath = this.ben.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.gyE) && this.gyw != null && this.gyw.url != null) {
                this.currentIndex = -1;
                bRt();
                a(this.gyw, true);
                FZ(videoPath);
            }
        }
    }

    public void eD(int i) {
        if (bRl() && this.biF) {
            if (i == 1) {
                bRw();
                tZ(i);
                bRt();
            } else if (i == 2) {
                bRu();
            }
            if (this.gyx != null) {
                this.gyx.dz(i);
            }
        }
    }

    public void Iq() {
        this.gyw.url = null;
        if (this.gyF != null) {
            this.gyF.playUrl = null;
        }
        XC();
    }

    private void dw(JSONObject jSONObject) {
        o w = o.w(jSONObject.optJSONObject("multi_session"));
        if (w != null) {
            if (this.gyt == null) {
                this.gyt = w;
            } else if (!b(w) || !a(w) || !this.biF) {
                if (!b(w) && a(w) && this.biF) {
                    XC();
                    this.gyt = w;
                } else {
                    this.gyt = w;
                }
            } else {
                return;
            }
            if (this.gyt != null) {
                bRn();
            }
        }
    }

    private void bRn() {
        String action = this.gyt.getAction();
        if (TextUtils.equals("1", action)) {
            if (bRl()) {
                XB();
            }
        } else if (TextUtils.equals("2", action)) {
            XC();
        }
    }

    private void XB() {
        if (!this.biF) {
            bRs();
            this.biF = true;
            bRo();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.bRq();
                    if (!TextUtils.isEmpty(b.this.gyt.CA())) {
                        b.this.gys.setText(b.this.gyt.CA());
                    }
                    b.this.bZ(b.this.gyt.Cx());
                    b.this.eD(realScreenOrientation);
                    b.this.bRB();
                    b.this.a(b.this.gyw, true);
                    if (b.this.gyv != null) {
                        b.this.gyv.tR(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bRx();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bRy();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void bRo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void bRp() {
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

    private void XC() {
        if (this.biF) {
            this.biF = false;
            this.currentIndex = -1;
            bRr();
            bRw();
            if (a(this.gyw)) {
                FZ(this.gyw.url);
            }
            if (this.gyv != null) {
                this.gyv.tR(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRq() {
        if (this.gyn.getParent() != null) {
            ((ViewGroup) this.gyn.getParent()).removeView(this.gyn);
        }
        if (this.gxj != null) {
            this.gxj.addView(this.gyn, (this.gyu != null ? this.gxj.getView().indexOfChild(this.gyu) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void bRr() {
        if (this.gyn.getParent() != null) {
            ((ViewGroup) this.gyn.getParent()).removeView(this.gyn);
        }
    }

    private void me(boolean z) {
        if (this.gyn != null) {
            this.gyn.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(o oVar) {
        return this.gyt.fP(oVar.getAction());
    }

    private boolean b(o oVar) {
        return this.gyt.fQ(oVar.getId());
    }

    private void bRs() {
        if (this.ben != null) {
            this.gyw.url = this.ben.getVideoPath();
            this.gyE = this.gyw.url;
        }
    }

    private void tZ(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bqJ != null && (layoutParams = (RelativeLayout.LayoutParams) this.gyn.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bqJ.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bqJ.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bqJ.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds80);
            }
            this.gyn.setLayoutParams(layoutParams);
            me(true);
        }
    }

    private void bRt() {
        if (this.currentIndex == -1) {
            a(true, (View) this.gyr);
        }
        if (this.gyp != null) {
            this.gyp.tX(this.currentIndex);
        }
        if (this.gyo != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gyo != null) {
                        b.this.gyo.setSelection(b.this.currentIndex);
                        b.this.gyo.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void bRu() {
        bRv();
    }

    private void bRv() {
        me(false);
        if (this.gyy != null && this.gpn != null) {
            if (this.gyy.getParent() != null) {
                ((ViewGroup) this.gyy.getParent()).removeView(this.gyy);
            }
            int i = -1;
            if (this.gpn != null) {
                i = this.gpn.indexOfChild(this.gpn.findViewById(a.g.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds26);
            this.gpn.addView(this.gyy, i + 1, layoutParams);
        }
    }

    private void bRw() {
        if (this.gyy != null && this.gyy.getParent() != null) {
            ((ViewGroup) this.gyy.getParent()).removeView(this.gyy);
        }
        if (this.gyC != null && this.gyC.isShowing()) {
            this.gyC.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        if (this.gyq != null && this.gyq.getVisibility() != 0) {
            this.gyq.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRy() {
        if (this.gyq != null && this.gyq.getVisibility() == 0) {
            this.gyq.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.biF) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gyr == view) {
            if (this.gyw != null) {
                c(true, 1, this.gyw.aEz);
                this.currentIndex = -1;
                a(true, (View) this.gyr);
                if (this.gyp != null) {
                    this.gyp.tX(this.currentIndex);
                }
                a(this.gyw, true);
                if (a(this.gyw)) {
                    FZ(this.gyw.url);
                }
            }
        } else if (this.gyB == view) {
            bRp();
            bRz();
        }
    }

    private void bRz() {
        bRA();
        if (!this.gyC.isShowing()) {
            this.gyC.a(this.gyt, this.currentIndex);
        }
    }

    private void bRA() {
        if (this.gyC == null) {
            this.gyC = new d(this.mTbPageContext.getPageActivity());
            this.gyC.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0629a
    public void a(View view, int i, x xVar) {
        this.currentIndex = i;
        c(false, i + 2, xVar.aEz);
        a(false, (View) this.gyr);
        a(xVar, false);
        if (a(xVar)) {
            FZ(xVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, x xVar) {
        a(z, this.gyr);
        if (z) {
            if (this.gyw != null) {
                this.currentIndex = -1;
                c(false, 1, this.gyw.aEz);
                a(this.gyw, true);
                if (a(this.gyw)) {
                    FZ(this.gyw.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, xVar.aEz);
        a(xVar, false);
        if (a(xVar)) {
            FZ(xVar.url);
        }
    }

    private boolean a(x xVar) {
        return (xVar == null || TextUtils.isEmpty(xVar.url) || TextUtils.equals(xVar.url, this.gyE)) ? false : true;
    }

    private void FZ(String str) {
        if (!TextUtils.isEmpty(str) && this.ben != null && this.gyF != null) {
            bRC();
            this.gyE = str;
            this.ben.ch(true);
            this.gyF.playUrl = str;
            this.ben.c(this.gyF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, boolean z) {
        if (xVar != null) {
            bRk();
            if (z) {
                this.gyA.setVisibility(8);
            } else {
                this.gyA.setVisibility(0);
                this.gyA.startLoad(xVar.imageUrl, 10, false);
            }
            this.gyz.setText(xVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        if (this.gyt != null) {
            bRk();
            c.a(this.mTbPageContext.getPageActivity(), this.gyB, true, this.gyt.Cz(), this.gyt.Cy(), true);
        }
    }

    private void bRC() {
        bRD();
        this.gyx.show();
    }

    private void hideLoadingView() {
        bRD();
        this.gyx.dismiss();
    }

    private void bRD() {
        if (this.gyx == null) {
            this.gyx = new h(this.mTbPageContext.getPageActivity(), this.ben.getLivePlayer());
        }
    }
}
