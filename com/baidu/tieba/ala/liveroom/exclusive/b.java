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
public class b implements View.OnClickListener, a.InterfaceC0662a, f {
    private View bOo;
    private com.baidu.live.u.f brO;
    private boolean bzt;
    private AlaLiveView hBu;
    private ViewGroup hCA;
    private d hCB;
    private boolean hCC;
    private String hCD;
    private AlaLiveInfoData hCE;
    private View hCm;
    private AlphaGradientHListView hCn;
    private a hCo;
    private View hCp;
    private TextView hCq;
    private TextView hCr;
    private z hCs;
    private View hCt;
    private e hCu;
    private h hCw;
    private View hCx;
    private TextView hCy;
    private HeadImageView hCz;
    private FrameLayout htJ;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private an hCv = new an();

    public b(TbPageContext tbPageContext, com.baidu.live.u.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.brO = fVar;
        this.bOo = fVar.getLivePlayer();
        this.hBu = alaLiveView;
        this.htJ = frameLayout;
        this.hCt = view;
        this.hCu = eVar;
        this.hCv.aJU = "全景视角";
        this.hCv.url = fVar.getVideoPath();
        this.hCD = this.hCv.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        ceG();
        ol(false);
        ceH();
    }

    private void ceG() {
        if (this.hCm == null) {
            this.hCm = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hCn = (AlphaGradientHListView) this.hCm.findViewById(a.f.lv_scene_list);
            this.hCp = this.hCm.findViewById(a.f.ll_tip_container);
            this.hCr = (TextView) this.hCp.findViewById(a.f.tv_scene_tip);
            this.hCo = new a(this.mTbPageContext.getPageActivity(), true);
            this.hCo.a(this);
            this.hCn.setAdapter((ListAdapter) this.hCo);
            this.hCn.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hCn.setDirection(2);
            this.hCn.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hCn.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hCC) {
                            b.this.hCC = true;
                            b.this.hCn.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hCn.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hCC) {
                                b.this.hCC = true;
                                b.this.hCn.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hCn.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hCC) {
                            b.this.hCC = false;
                            b.this.hCn.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hCq = (TextView) this.hCm.findViewById(a.f.tv_all_scene);
            this.hCq.setOnClickListener(this);
        }
    }

    private void ceH() {
        if (this.hCx == null) {
            this.hCx = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hCz = (HeadImageView) this.hCx.findViewById(a.f.iv_land_scene_avatar);
            this.hCz.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hCz.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
            this.hCz.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
            this.hCy = (TextView) this.hCx.findViewById(a.f.tv_land_scene_name);
            this.hCA = (ViewGroup) this.hCx.findViewById(a.f.ll_land_content_container);
            this.hCA.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (ceI() && this.bzt && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hCs.BX(), this.hCs.BW(), true);
        }
    }

    private boolean ceI() {
        return this.hCs != null && this.hCs.BU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(List<an> list) {
        if (this.hCo != null) {
            this.hCo.setDatas(list);
        }
    }

    public void L(ab abVar) {
        if (abVar != null) {
            this.hCE = abVar.mLiveInfo;
            if (abVar.aIW != null) {
                if (this.hCs == null) {
                    this.hCs = abVar.aIW;
                } else if (!b(abVar.aIW) || !a(abVar.aIW) || !this.bzt) {
                    if (!b(abVar.aIW) && a(abVar.aIW) && this.bzt) {
                        afG();
                        this.hCs = abVar.aIW;
                    } else {
                        this.hCs = abVar.aIW;
                    }
                } else {
                    return;
                }
                ceK();
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

    public void ceJ() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.brO != null) {
            String videoPath = this.brO.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hCD) && this.hCv != null && this.hCv.url != null) {
                this.currentIndex = -1;
                ceQ();
                a(this.hCv, true);
                HI(videoPath);
            }
        }
    }

    public void cK(int i) {
        if (ceI() && this.bzt) {
            if (i == 1) {
                ceT();
                vx(i);
                ceQ();
            } else if (i == 2) {
                ceR();
            }
            if (this.hCw != null) {
                this.hCw.cr(i);
            }
        }
    }

    public void xh() {
        this.hCv.url = null;
        if (this.hCE != null) {
            this.hCE.playUrl = null;
        }
        afG();
    }

    private void dY(JSONObject jSONObject) {
        z z = z.z(jSONObject.optJSONObject("multi_session"));
        if (z != null) {
            if (this.hCs == null) {
                this.hCs = z;
            } else if (!b(z) || !a(z) || !this.bzt) {
                if (!b(z) && a(z) && this.bzt) {
                    afG();
                    this.hCs = z;
                } else {
                    this.hCs = z;
                }
            } else {
                return;
            }
            if (this.hCs != null) {
                ceK();
            }
        }
    }

    private void ceK() {
        String action = this.hCs.getAction();
        if (TextUtils.equals("1", action)) {
            if (ceI()) {
                afF();
            }
        } else if (TextUtils.equals("2", action)) {
            afG();
        }
    }

    private void afF() {
        if (!this.bzt) {
            ceP();
            this.bzt = true;
            ceL();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.ceN();
                    if (!TextUtils.isEmpty(b.this.hCs.BY())) {
                        b.this.hCr.setText(b.this.hCs.BY());
                    }
                    b.this.cF(b.this.hCs.BV());
                    b.this.cK(realScreenOrientation);
                    b.this.ceY();
                    b.this.a(b.this.hCv, true);
                    if (b.this.hCu != null) {
                        b.this.hCu.vp(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ceU();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ceV();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void ceL() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void ceM() {
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
            ceO();
            ceT();
            if (a(this.hCv)) {
                HI(this.hCv.url);
            }
            if (this.hCu != null) {
                this.hCu.vp(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceN() {
        if (this.hCm.getParent() != null) {
            ((ViewGroup) this.hCm.getParent()).removeView(this.hCm);
        }
        if (this.hBu != null) {
            this.hBu.addView(this.hCm, (this.hCt != null ? this.hBu.getView().indexOfChild(this.hCt) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void ceO() {
        if (this.hCm.getParent() != null) {
            ((ViewGroup) this.hCm.getParent()).removeView(this.hCm);
        }
    }

    private void ol(boolean z) {
        if (this.hCm != null) {
            this.hCm.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(z zVar) {
        return this.hCs.fw(zVar.getAction());
    }

    private boolean b(z zVar) {
        return this.hCs.fx(zVar.getId());
    }

    private void ceP() {
        if (this.brO != null) {
            this.hCv.url = this.brO.getVideoPath();
            this.hCD = this.hCv.url;
        }
    }

    private void vx(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bOo != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hCm.getLayoutParams()) != null) {
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
            this.hCm.setLayoutParams(layoutParams);
            ol(true);
        }
    }

    private void ceQ() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hCq);
        }
        if (this.hCo != null) {
            this.hCo.vv(this.currentIndex);
        }
        if (this.hCn != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hCn != null) {
                        b.this.hCn.setSelection(b.this.currentIndex);
                        b.this.hCn.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void ceR() {
        ceS();
    }

    private void ceS() {
        ol(false);
        if (this.hCx != null && this.htJ != null && this.mTbPageContext != null) {
            if (this.hCx.getParent() != null) {
                ((ViewGroup) this.hCx.getParent()).removeView(this.hCx);
            }
            int i = -1;
            if (this.htJ != null) {
                i = this.htJ.indexOfChild(this.htJ.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.htJ.addView(this.hCx, i + 1, layoutParams);
        }
    }

    private void ceT() {
        if (this.hCx != null && this.hCx.getParent() != null) {
            ((ViewGroup) this.hCx.getParent()).removeView(this.hCx);
        }
        if (this.hCB != null && this.hCB.isShowing()) {
            this.hCB.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceU() {
        if (this.hCp != null && this.hCp.getVisibility() != 0) {
            this.hCp.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceV() {
        if (this.hCp != null && this.hCp.getVisibility() == 0) {
            this.hCp.setVisibility(4);
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
        if (this.hCq == view) {
            if (this.hCv != null) {
                d(true, 1, this.hCv.aJU);
                this.currentIndex = -1;
                a(true, (View) this.hCq);
                if (this.hCo != null) {
                    this.hCo.vv(this.currentIndex);
                }
                a(this.hCv, true);
                if (a(this.hCv)) {
                    HI(this.hCv.url);
                }
            }
        } else if (this.hCA == view) {
            ceM();
            ceW();
        }
    }

    private void ceW() {
        ceX();
        if (!this.hCB.isShowing()) {
            this.hCB.a(this.hCs, this.currentIndex);
        }
    }

    private void ceX() {
        if (this.hCB == null) {
            this.hCB = new d(this.mTbPageContext.getPageActivity());
            this.hCB.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0662a
    public void a(View view, int i, an anVar) {
        this.currentIndex = i;
        d(false, i + 2, anVar.aJU);
        a(false, (View) this.hCq);
        a(anVar, false);
        if (a(anVar)) {
            HI(anVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, an anVar) {
        a(z, this.hCq);
        if (z) {
            if (this.hCv != null) {
                this.currentIndex = -1;
                d(false, 1, this.hCv.aJU);
                a(this.hCv, true);
                if (a(this.hCv)) {
                    HI(this.hCv.url);
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
            HI(anVar.url);
        }
    }

    private boolean a(an anVar) {
        return (anVar == null || TextUtils.isEmpty(anVar.url) || TextUtils.equals(anVar.url, this.hCD)) ? false : true;
    }

    private void HI(String str) {
        if (!TextUtils.isEmpty(str) && this.brO != null && this.hCE != null) {
            ceZ();
            this.hCD = str;
            this.brO.cM(true);
            this.hCE.playUrl = str;
            this.brO.c(this.hCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar, boolean z) {
        if (anVar != null) {
            ceH();
            if (z) {
                this.hCz.setVisibility(8);
            } else {
                this.hCz.setVisibility(0);
                this.hCz.startLoad(anVar.imageUrl, 10, false);
            }
            this.hCy.setText(anVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceY() {
        if (this.hCs != null) {
            ceH();
            c.a(this.mTbPageContext.getPageActivity(), this.hCA, true, this.hCs.BX(), this.hCs.BW(), true);
        }
    }

    private void ceZ() {
        cfa();
        this.hCw.show();
    }

    private void hideLoadingView() {
        cfa();
        this.hCw.dismiss();
    }

    private void cfa() {
        if (this.hCw == null) {
            this.hCw = new h(this.mTbPageContext.getPageActivity(), this.brO.getLivePlayer());
        }
    }
}
