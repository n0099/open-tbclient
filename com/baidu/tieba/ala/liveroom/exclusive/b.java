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
    private com.baidu.live.p.f bel;
    private boolean biC;
    private View bqG;
    private FrameLayout gpj;
    private AlaLiveView gxf;
    private String gyA;
    private AlaLiveInfoData gyB;
    private View gyj;
    private AlphaGradientHListView gyk;
    private a gyl;
    private View gym;
    private TextView gyn;
    private TextView gyo;
    private o gyp;
    private View gyq;
    private e gyr;
    private h gyt;
    private View gyu;
    private TextView gyv;
    private HeadImageView gyw;
    private ViewGroup gyx;
    private d gyy;
    private boolean gyz;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private x gys = new x();

    public b(TbPageContext tbPageContext, com.baidu.live.p.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.bel = fVar;
        this.bqG = fVar.getLivePlayer();
        this.gxf = alaLiveView;
        this.gpj = frameLayout;
        this.gyq = view;
        this.gyr = eVar;
        this.gys.aEx = "全景视角";
        this.gys.url = fVar.getVideoPath();
        this.gyA = this.gys.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        bRi();
        mc(false);
        bRj();
    }

    private void bRi() {
        if (this.gyj == null) {
            this.gyj = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.gyk = (AlphaGradientHListView) this.gyj.findViewById(a.g.lv_scene_list);
            this.gym = this.gyj.findViewById(a.g.ll_tip_container);
            this.gyo = (TextView) this.gym.findViewById(a.g.tv_scene_tip);
            this.gyl = new a(this.mTbPageContext.getPageActivity(), true);
            this.gyl.a(this);
            this.gyk.setAdapter((ListAdapter) this.gyl);
            this.gyk.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gyk.setDirection(2);
            this.gyk.setColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha100));
            this.gyk.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.gyz) {
                            b.this.gyz = true;
                            b.this.gyk.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                            b.this.gyk.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.gyz) {
                                b.this.gyz = true;
                                b.this.gyk.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                                b.this.gyk.setNeedAlphaShade(true);
                            }
                        } else if (b.this.gyz) {
                            b.this.gyz = false;
                            b.this.gyk.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.gyn = (TextView) this.gyj.findViewById(a.g.tv_all_scene);
            this.gyn.setOnClickListener(this);
        }
    }

    private void bRj() {
        if (this.gyu == null) {
            this.gyu = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.gyw = (HeadImageView) this.gyu.findViewById(a.g.iv_land_scene_avatar);
            this.gyw.setScaleType(ImageView.ScaleType.FIT_XY);
            this.gyw.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gyw.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gyv = (TextView) this.gyu.findViewById(a.g.tv_land_scene_name);
            this.gyx = (ViewGroup) this.gyu.findViewById(a.g.ll_land_content_container);
            this.gyx.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (bRk() && this.biC && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.gyp.Cz(), this.gyp.Cy(), true);
        }
    }

    private boolean bRk() {
        return this.gyp != null && this.gyp.Cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZ(List<x> list) {
        if (this.gyl != null) {
            this.gyl.setDatas(list);
        }
    }

    public void u(r rVar) {
        if (rVar != null) {
            this.gyB = rVar.mLiveInfo;
            if (rVar.aEr != null) {
                if (this.gyp == null) {
                    this.gyp = rVar.aEr;
                } else if (!b(rVar.aEr) || !a(rVar.aEr) || !this.biC) {
                    if (!b(rVar.aEr) && a(rVar.aEr) && this.biC) {
                        XC();
                        this.gyp = rVar.aEr;
                    } else {
                        this.gyp = rVar.aEr;
                    }
                } else {
                    return;
                }
                bRm();
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

    public void bRl() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.bel != null) {
            String videoPath = this.bel.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.gyA) && this.gys != null && this.gys.url != null) {
                this.currentIndex = -1;
                bRs();
                a(this.gys, true);
                FY(videoPath);
            }
        }
    }

    public void eD(int i) {
        if (bRk() && this.biC) {
            if (i == 1) {
                bRv();
                tZ(i);
                bRs();
            } else if (i == 2) {
                bRt();
            }
            if (this.gyt != null) {
                this.gyt.dz(i);
            }
        }
    }

    public void Iq() {
        this.gys.url = null;
        if (this.gyB != null) {
            this.gyB.playUrl = null;
        }
        XC();
    }

    private void dw(JSONObject jSONObject) {
        o w = o.w(jSONObject.optJSONObject("multi_session"));
        if (w != null) {
            if (this.gyp == null) {
                this.gyp = w;
            } else if (!b(w) || !a(w) || !this.biC) {
                if (!b(w) && a(w) && this.biC) {
                    XC();
                    this.gyp = w;
                } else {
                    this.gyp = w;
                }
            } else {
                return;
            }
            if (this.gyp != null) {
                bRm();
            }
        }
    }

    private void bRm() {
        String action = this.gyp.getAction();
        if (TextUtils.equals("1", action)) {
            if (bRk()) {
                XB();
            }
        } else if (TextUtils.equals("2", action)) {
            XC();
        }
    }

    private void XB() {
        if (!this.biC) {
            bRr();
            this.biC = true;
            bRn();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.bRp();
                    if (!TextUtils.isEmpty(b.this.gyp.CA())) {
                        b.this.gyo.setText(b.this.gyp.CA());
                    }
                    b.this.bZ(b.this.gyp.Cx());
                    b.this.eD(realScreenOrientation);
                    b.this.bRA();
                    b.this.a(b.this.gys, true);
                    if (b.this.gyr != null) {
                        b.this.gyr.tR(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bRw();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bRx();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void bRn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void bRo() {
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
        if (this.biC) {
            this.biC = false;
            this.currentIndex = -1;
            bRq();
            bRv();
            if (a(this.gys)) {
                FY(this.gys.url);
            }
            if (this.gyr != null) {
                this.gyr.tR(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRp() {
        if (this.gyj.getParent() != null) {
            ((ViewGroup) this.gyj.getParent()).removeView(this.gyj);
        }
        if (this.gxf != null) {
            this.gxf.addView(this.gyj, (this.gyq != null ? this.gxf.getView().indexOfChild(this.gyq) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void bRq() {
        if (this.gyj.getParent() != null) {
            ((ViewGroup) this.gyj.getParent()).removeView(this.gyj);
        }
    }

    private void mc(boolean z) {
        if (this.gyj != null) {
            this.gyj.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(o oVar) {
        return this.gyp.fO(oVar.getAction());
    }

    private boolean b(o oVar) {
        return this.gyp.fP(oVar.getId());
    }

    private void bRr() {
        if (this.bel != null) {
            this.gys.url = this.bel.getVideoPath();
            this.gyA = this.gys.url;
        }
    }

    private void tZ(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bqG != null && (layoutParams = (RelativeLayout.LayoutParams) this.gyj.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bqG.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bqG.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bqG.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds80);
            }
            this.gyj.setLayoutParams(layoutParams);
            mc(true);
        }
    }

    private void bRs() {
        if (this.currentIndex == -1) {
            a(true, (View) this.gyn);
        }
        if (this.gyl != null) {
            this.gyl.tX(this.currentIndex);
        }
        if (this.gyk != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gyk != null) {
                        b.this.gyk.setSelection(b.this.currentIndex);
                        b.this.gyk.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void bRt() {
        bRu();
    }

    private void bRu() {
        mc(false);
        if (this.gyu != null && this.gpj != null) {
            if (this.gyu.getParent() != null) {
                ((ViewGroup) this.gyu.getParent()).removeView(this.gyu);
            }
            int i = -1;
            if (this.gpj != null) {
                i = this.gpj.indexOfChild(this.gpj.findViewById(a.g.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds26);
            this.gpj.addView(this.gyu, i + 1, layoutParams);
        }
    }

    private void bRv() {
        if (this.gyu != null && this.gyu.getParent() != null) {
            ((ViewGroup) this.gyu.getParent()).removeView(this.gyu);
        }
        if (this.gyy != null && this.gyy.isShowing()) {
            this.gyy.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRw() {
        if (this.gym != null && this.gym.getVisibility() != 0) {
            this.gym.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRx() {
        if (this.gym != null && this.gym.getVisibility() == 0) {
            this.gym.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.biC) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gyn == view) {
            if (this.gys != null) {
                c(true, 1, this.gys.aEx);
                this.currentIndex = -1;
                a(true, (View) this.gyn);
                if (this.gyl != null) {
                    this.gyl.tX(this.currentIndex);
                }
                a(this.gys, true);
                if (a(this.gys)) {
                    FY(this.gys.url);
                }
            }
        } else if (this.gyx == view) {
            bRo();
            bRy();
        }
    }

    private void bRy() {
        bRz();
        if (!this.gyy.isShowing()) {
            this.gyy.a(this.gyp, this.currentIndex);
        }
    }

    private void bRz() {
        if (this.gyy == null) {
            this.gyy = new d(this.mTbPageContext.getPageActivity());
            this.gyy.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0629a
    public void a(View view, int i, x xVar) {
        this.currentIndex = i;
        c(false, i + 2, xVar.aEx);
        a(false, (View) this.gyn);
        a(xVar, false);
        if (a(xVar)) {
            FY(xVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, x xVar) {
        a(z, this.gyn);
        if (z) {
            if (this.gys != null) {
                this.currentIndex = -1;
                c(false, 1, this.gys.aEx);
                a(this.gys, true);
                if (a(this.gys)) {
                    FY(this.gys.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, xVar.aEx);
        a(xVar, false);
        if (a(xVar)) {
            FY(xVar.url);
        }
    }

    private boolean a(x xVar) {
        return (xVar == null || TextUtils.isEmpty(xVar.url) || TextUtils.equals(xVar.url, this.gyA)) ? false : true;
    }

    private void FY(String str) {
        if (!TextUtils.isEmpty(str) && this.bel != null && this.gyB != null) {
            bRB();
            this.gyA = str;
            this.bel.ch(true);
            this.gyB.playUrl = str;
            this.bel.c(this.gyB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, boolean z) {
        if (xVar != null) {
            bRj();
            if (z) {
                this.gyw.setVisibility(8);
            } else {
                this.gyw.setVisibility(0);
                this.gyw.startLoad(xVar.imageUrl, 10, false);
            }
            this.gyv.setText(xVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRA() {
        if (this.gyp != null) {
            bRj();
            c.a(this.mTbPageContext.getPageActivity(), this.gyx, true, this.gyp.Cz(), this.gyp.Cy(), true);
        }
    }

    private void bRB() {
        bRC();
        this.gyt.show();
    }

    private void hideLoadingView() {
        bRC();
        this.gyt.dismiss();
    }

    private void bRC() {
        if (this.gyt == null) {
            this.gyt = new h(this.mTbPageContext.getPageActivity(), this.bel.getLivePlayer());
        }
    }
}
