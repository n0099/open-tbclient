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
import com.baidu.live.data.ah;
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
public class b implements View.OnClickListener, a.InterfaceC0687a, f {
    private View bKD;
    private com.baidu.live.u.f brf;
    private boolean bvS;
    private FrameLayout hig;
    private AlaLiveView hpS;
    private View hqK;
    private AlphaGradientHListView hqL;
    private a hqM;
    private View hqN;
    private TextView hqO;
    private TextView hqP;
    private u hqQ;
    private View hqR;
    private e hqS;
    private h hqU;
    private View hqV;
    private TextView hqW;
    private HeadImageView hqX;
    private ViewGroup hqY;
    private d hqZ;
    private boolean hra;
    private String hrb;
    private AlaLiveInfoData hrc;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private ah hqT = new ah();

    public b(TbPageContext tbPageContext, com.baidu.live.u.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.brf = fVar;
        this.bKD = fVar.getLivePlayer();
        this.hpS = alaLiveView;
        this.hig = frameLayout;
        this.hqR = view;
        this.hqS = eVar;
        this.hqT.aLy = "全景视角";
        this.hqT.url = fVar.getVideoPath();
        this.hrb = this.hqT.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        ceL();
        nE(false);
        ceM();
    }

    private void ceL() {
        if (this.hqK == null) {
            this.hqK = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hqL = (AlphaGradientHListView) this.hqK.findViewById(a.f.lv_scene_list);
            this.hqN = this.hqK.findViewById(a.f.ll_tip_container);
            this.hqP = (TextView) this.hqN.findViewById(a.f.tv_scene_tip);
            this.hqM = new a(this.mTbPageContext.getPageActivity(), true);
            this.hqM.a(this);
            this.hqL.setAdapter((ListAdapter) this.hqM);
            this.hqL.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hqL.setDirection(2);
            this.hqL.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hqL.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hra) {
                            b.this.hra = true;
                            b.this.hqL.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hqL.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hra) {
                                b.this.hra = true;
                                b.this.hqL.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hqL.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hra) {
                            b.this.hra = false;
                            b.this.hqL.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hqO = (TextView) this.hqK.findViewById(a.f.tv_all_scene);
            this.hqO.setOnClickListener(this);
        }
    }

    private void ceM() {
        if (this.hqV == null) {
            this.hqV = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hqX = (HeadImageView) this.hqV.findViewById(a.f.iv_land_scene_avatar);
            this.hqX.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hqX.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hqX.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hqW = (TextView) this.hqV.findViewById(a.f.tv_land_scene_name);
            this.hqY = (ViewGroup) this.hqV.findViewById(a.f.ll_land_content_container);
            this.hqY.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (ceN() && this.bvS && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hqQ.Fp(), this.hqQ.Fo(), true);
        }
    }

    private boolean ceN() {
        return this.hqQ != null && this.hqQ.Fm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(List<ah> list) {
        if (this.hqM != null) {
            this.hqM.setDatas(list);
        }
    }

    public void K(w wVar) {
        if (wVar != null) {
            this.hrc = wVar.mLiveInfo;
            if (wVar.aKN != null) {
                if (this.hqQ == null) {
                    this.hqQ = wVar.aKN;
                } else if (!b(wVar.aKN) || !a(wVar.aKN) || !this.bvS) {
                    if (!b(wVar.aKN) && a(wVar.aKN) && this.bvS) {
                        ahR();
                        this.hqQ = wVar.aKN;
                    } else {
                        this.hqQ = wVar.aKN;
                    }
                } else {
                    return;
                }
                ceP();
            }
        }
    }

    public void G(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "multi_session".equals(jSONObject.optString("content_type"))) {
                    dO(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void ceO() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.brf != null) {
            String videoPath = this.brf.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hrb) && this.hqT != null && this.hqT.url != null) {
                this.currentIndex = -1;
                ceV();
                a(this.hqT, true);
                Io(videoPath);
            }
        }
    }

    public void en(int i) {
        if (ceN() && this.bvS) {
            if (i == 1) {
                ceY();
                wH(i);
                ceV();
            } else if (i == 2) {
                ceW();
            }
            if (this.hqU != null) {
                this.hqU.dX(i);
            }
        }
    }

    public void Do() {
        this.hqT.url = null;
        if (this.hrc != null) {
            this.hrc.playUrl = null;
        }
        ahR();
    }

    private void dO(JSONObject jSONObject) {
        u t = u.t(jSONObject.optJSONObject("multi_session"));
        if (t != null) {
            if (this.hqQ == null) {
                this.hqQ = t;
            } else if (!b(t) || !a(t) || !this.bvS) {
                if (!b(t) && a(t) && this.bvS) {
                    ahR();
                    this.hqQ = t;
                } else {
                    this.hqQ = t;
                }
            } else {
                return;
            }
            if (this.hqQ != null) {
                ceP();
            }
        }
    }

    private void ceP() {
        String action = this.hqQ.getAction();
        if (TextUtils.equals("1", action)) {
            if (ceN()) {
                ahQ();
            }
        } else if (TextUtils.equals("2", action)) {
            ahR();
        }
    }

    private void ahQ() {
        if (!this.bvS) {
            ceU();
            this.bvS = true;
            ceQ();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.ceS();
                    if (!TextUtils.isEmpty(b.this.hqQ.Fq())) {
                        b.this.hqP.setText(b.this.hqQ.Fq());
                    }
                    b.this.cD(b.this.hqQ.Fn());
                    b.this.en(realScreenOrientation);
                    b.this.cfd();
                    b.this.a(b.this.hqT, true);
                    if (b.this.hqS != null) {
                        b.this.hqS.wz(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.ceZ();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cfa();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void ceQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void ceR() {
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

    private void ahR() {
        if (this.bvS) {
            this.bvS = false;
            this.currentIndex = -1;
            ceT();
            ceY();
            if (a(this.hqT)) {
                Io(this.hqT.url);
            }
            if (this.hqS != null) {
                this.hqS.wz(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceS() {
        if (this.hqK.getParent() != null) {
            ((ViewGroup) this.hqK.getParent()).removeView(this.hqK);
        }
        if (this.hpS != null) {
            this.hpS.addView(this.hqK, (this.hqR != null ? this.hpS.getView().indexOfChild(this.hqR) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void ceT() {
        if (this.hqK.getParent() != null) {
            ((ViewGroup) this.hqK.getParent()).removeView(this.hqK);
        }
    }

    private void nE(boolean z) {
        if (this.hqK != null) {
            this.hqK.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(u uVar) {
        return this.hqQ.gD(uVar.getAction());
    }

    private boolean b(u uVar) {
        return this.hqQ.gE(uVar.getId());
    }

    private void ceU() {
        if (this.brf != null) {
            this.hqT.url = this.brf.getVideoPath();
            this.hrb = this.hqT.url;
        }
    }

    private void wH(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bKD != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hqK.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bKD.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bKD.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bKD.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            this.hqK.setLayoutParams(layoutParams);
            nE(true);
        }
    }

    private void ceV() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hqO);
        }
        if (this.hqM != null) {
            this.hqM.wF(this.currentIndex);
        }
        if (this.hqL != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hqL != null) {
                        b.this.hqL.setSelection(b.this.currentIndex);
                        b.this.hqL.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void ceW() {
        ceX();
    }

    private void ceX() {
        nE(false);
        if (this.hqV != null && this.hig != null && this.mTbPageContext != null) {
            if (this.hqV.getParent() != null) {
                ((ViewGroup) this.hqV.getParent()).removeView(this.hqV);
            }
            int i = -1;
            if (this.hig != null) {
                i = this.hig.indexOfChild(this.hig.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.hig.addView(this.hqV, i + 1, layoutParams);
        }
    }

    private void ceY() {
        if (this.hqV != null && this.hqV.getParent() != null) {
            ((ViewGroup) this.hqV.getParent()).removeView(this.hqV);
        }
        if (this.hqZ != null && this.hqZ.isShowing()) {
            this.hqZ.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceZ() {
        if (this.hqN != null && this.hqN.getVisibility() != 0) {
            this.hqN.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (this.hqN != null && this.hqN.getVisibility() == 0) {
            this.hqN.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bvS) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hqO == view) {
            if (this.hqT != null) {
                c(true, 1, this.hqT.aLy);
                this.currentIndex = -1;
                a(true, (View) this.hqO);
                if (this.hqM != null) {
                    this.hqM.wF(this.currentIndex);
                }
                a(this.hqT, true);
                if (a(this.hqT)) {
                    Io(this.hqT.url);
                }
            }
        } else if (this.hqY == view) {
            ceR();
            cfb();
        }
    }

    private void cfb() {
        cfc();
        if (!this.hqZ.isShowing()) {
            this.hqZ.a(this.hqQ, this.currentIndex);
        }
    }

    private void cfc() {
        if (this.hqZ == null) {
            this.hqZ = new d(this.mTbPageContext.getPageActivity());
            this.hqZ.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0687a
    public void a(View view, int i, ah ahVar) {
        this.currentIndex = i;
        c(false, i + 2, ahVar.aLy);
        a(false, (View) this.hqO);
        a(ahVar, false);
        if (a(ahVar)) {
            Io(ahVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, ah ahVar) {
        a(z, this.hqO);
        if (z) {
            if (this.hqT != null) {
                this.currentIndex = -1;
                c(false, 1, this.hqT.aLy);
                a(this.hqT, true);
                if (a(this.hqT)) {
                    Io(this.hqT.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, ahVar.aLy);
        a(ahVar, false);
        if (a(ahVar)) {
            Io(ahVar.url);
        }
    }

    private boolean a(ah ahVar) {
        return (ahVar == null || TextUtils.isEmpty(ahVar.url) || TextUtils.equals(ahVar.url, this.hrb)) ? false : true;
    }

    private void Io(String str) {
        if (!TextUtils.isEmpty(str) && this.brf != null && this.hrc != null) {
            cfe();
            this.hrb = str;
            this.brf.cE(true);
            this.hrc.playUrl = str;
            this.brf.c(this.hrc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ah ahVar, boolean z) {
        if (ahVar != null) {
            ceM();
            if (z) {
                this.hqX.setVisibility(8);
            } else {
                this.hqX.setVisibility(0);
                this.hqX.startLoad(ahVar.imageUrl, 10, false);
            }
            this.hqW.setText(ahVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfd() {
        if (this.hqQ != null) {
            ceM();
            c.a(this.mTbPageContext.getPageActivity(), this.hqY, true, this.hqQ.Fp(), this.hqQ.Fo(), true);
        }
    }

    private void cfe() {
        cff();
        this.hqU.show();
    }

    private void hideLoadingView() {
        cff();
        this.hqU.dismiss();
    }

    private void cff() {
        if (this.hqU == null) {
            this.hqU = new h(this.mTbPageContext.getPageActivity(), this.brf.getLivePlayer());
        }
    }
}
