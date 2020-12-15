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
    private FrameLayout hii;
    private AlaLiveView hpU;
    private View hqM;
    private AlphaGradientHListView hqN;
    private a hqO;
    private View hqP;
    private TextView hqQ;
    private TextView hqR;
    private u hqS;
    private View hqT;
    private e hqU;
    private h hqW;
    private View hqX;
    private TextView hqY;
    private HeadImageView hqZ;
    private ViewGroup hra;
    private d hrb;
    private boolean hrc;
    private String hrd;
    private AlaLiveInfoData hre;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private ah hqV = new ah();

    public b(TbPageContext tbPageContext, com.baidu.live.u.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.brf = fVar;
        this.bKD = fVar.getLivePlayer();
        this.hpU = alaLiveView;
        this.hii = frameLayout;
        this.hqT = view;
        this.hqU = eVar;
        this.hqV.aLy = "全景视角";
        this.hqV.url = fVar.getVideoPath();
        this.hrd = this.hqV.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        ceM();
        nE(false);
        ceN();
    }

    private void ceM() {
        if (this.hqM == null) {
            this.hqM = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hqN = (AlphaGradientHListView) this.hqM.findViewById(a.f.lv_scene_list);
            this.hqP = this.hqM.findViewById(a.f.ll_tip_container);
            this.hqR = (TextView) this.hqP.findViewById(a.f.tv_scene_tip);
            this.hqO = new a(this.mTbPageContext.getPageActivity(), true);
            this.hqO.a(this);
            this.hqN.setAdapter((ListAdapter) this.hqO);
            this.hqN.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hqN.setDirection(2);
            this.hqN.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hqN.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hrc) {
                            b.this.hrc = true;
                            b.this.hqN.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hqN.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hrc) {
                                b.this.hrc = true;
                                b.this.hqN.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hqN.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hrc) {
                            b.this.hrc = false;
                            b.this.hqN.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hqQ = (TextView) this.hqM.findViewById(a.f.tv_all_scene);
            this.hqQ.setOnClickListener(this);
        }
    }

    private void ceN() {
        if (this.hqX == null) {
            this.hqX = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hqZ = (HeadImageView) this.hqX.findViewById(a.f.iv_land_scene_avatar);
            this.hqZ.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hqZ.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hqZ.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hqY = (TextView) this.hqX.findViewById(a.f.tv_land_scene_name);
            this.hra = (ViewGroup) this.hqX.findViewById(a.f.ll_land_content_container);
            this.hra.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (ceO() && this.bvS && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hqS.Fp(), this.hqS.Fo(), true);
        }
    }

    private boolean ceO() {
        return this.hqS != null && this.hqS.Fm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cD(List<ah> list) {
        if (this.hqO != null) {
            this.hqO.setDatas(list);
        }
    }

    public void K(w wVar) {
        if (wVar != null) {
            this.hre = wVar.mLiveInfo;
            if (wVar.aKN != null) {
                if (this.hqS == null) {
                    this.hqS = wVar.aKN;
                } else if (!b(wVar.aKN) || !a(wVar.aKN) || !this.bvS) {
                    if (!b(wVar.aKN) && a(wVar.aKN) && this.bvS) {
                        ahR();
                        this.hqS = wVar.aKN;
                    } else {
                        this.hqS = wVar.aKN;
                    }
                } else {
                    return;
                }
                ceQ();
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

    public void ceP() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.brf != null) {
            String videoPath = this.brf.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hrd) && this.hqV != null && this.hqV.url != null) {
                this.currentIndex = -1;
                ceW();
                a(this.hqV, true);
                Io(videoPath);
            }
        }
    }

    public void en(int i) {
        if (ceO() && this.bvS) {
            if (i == 1) {
                ceZ();
                wH(i);
                ceW();
            } else if (i == 2) {
                ceX();
            }
            if (this.hqW != null) {
                this.hqW.dX(i);
            }
        }
    }

    public void Do() {
        this.hqV.url = null;
        if (this.hre != null) {
            this.hre.playUrl = null;
        }
        ahR();
    }

    private void dO(JSONObject jSONObject) {
        u t = u.t(jSONObject.optJSONObject("multi_session"));
        if (t != null) {
            if (this.hqS == null) {
                this.hqS = t;
            } else if (!b(t) || !a(t) || !this.bvS) {
                if (!b(t) && a(t) && this.bvS) {
                    ahR();
                    this.hqS = t;
                } else {
                    this.hqS = t;
                }
            } else {
                return;
            }
            if (this.hqS != null) {
                ceQ();
            }
        }
    }

    private void ceQ() {
        String action = this.hqS.getAction();
        if (TextUtils.equals("1", action)) {
            if (ceO()) {
                ahQ();
            }
        } else if (TextUtils.equals("2", action)) {
            ahR();
        }
    }

    private void ahQ() {
        if (!this.bvS) {
            ceV();
            this.bvS = true;
            ceR();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.ceT();
                    if (!TextUtils.isEmpty(b.this.hqS.Fq())) {
                        b.this.hqR.setText(b.this.hqS.Fq());
                    }
                    b.this.cD(b.this.hqS.Fn());
                    b.this.en(realScreenOrientation);
                    b.this.cfe();
                    b.this.a(b.this.hqV, true);
                    if (b.this.hqU != null) {
                        b.this.hqU.wz(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cfa();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cfb();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void ceR() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void ceS() {
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
            ceU();
            ceZ();
            if (a(this.hqV)) {
                Io(this.hqV.url);
            }
            if (this.hqU != null) {
                this.hqU.wz(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceT() {
        if (this.hqM.getParent() != null) {
            ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
        }
        if (this.hpU != null) {
            this.hpU.addView(this.hqM, (this.hqT != null ? this.hpU.getView().indexOfChild(this.hqT) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void ceU() {
        if (this.hqM.getParent() != null) {
            ((ViewGroup) this.hqM.getParent()).removeView(this.hqM);
        }
    }

    private void nE(boolean z) {
        if (this.hqM != null) {
            this.hqM.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(u uVar) {
        return this.hqS.gD(uVar.getAction());
    }

    private boolean b(u uVar) {
        return this.hqS.gE(uVar.getId());
    }

    private void ceV() {
        if (this.brf != null) {
            this.hqV.url = this.brf.getVideoPath();
            this.hrd = this.hqV.url;
        }
    }

    private void wH(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bKD != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hqM.getLayoutParams()) != null) {
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
            this.hqM.setLayoutParams(layoutParams);
            nE(true);
        }
    }

    private void ceW() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hqQ);
        }
        if (this.hqO != null) {
            this.hqO.wF(this.currentIndex);
        }
        if (this.hqN != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hqN != null) {
                        b.this.hqN.setSelection(b.this.currentIndex);
                        b.this.hqN.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void ceX() {
        ceY();
    }

    private void ceY() {
        nE(false);
        if (this.hqX != null && this.hii != null && this.mTbPageContext != null) {
            if (this.hqX.getParent() != null) {
                ((ViewGroup) this.hqX.getParent()).removeView(this.hqX);
            }
            int i = -1;
            if (this.hii != null) {
                i = this.hii.indexOfChild(this.hii.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.hii.addView(this.hqX, i + 1, layoutParams);
        }
    }

    private void ceZ() {
        if (this.hqX != null && this.hqX.getParent() != null) {
            ((ViewGroup) this.hqX.getParent()).removeView(this.hqX);
        }
        if (this.hrb != null && this.hrb.isShowing()) {
            this.hrb.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (this.hqP != null && this.hqP.getVisibility() != 0) {
            this.hqP.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfb() {
        if (this.hqP != null && this.hqP.getVisibility() == 0) {
            this.hqP.setVisibility(4);
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
        if (this.hqQ == view) {
            if (this.hqV != null) {
                c(true, 1, this.hqV.aLy);
                this.currentIndex = -1;
                a(true, (View) this.hqQ);
                if (this.hqO != null) {
                    this.hqO.wF(this.currentIndex);
                }
                a(this.hqV, true);
                if (a(this.hqV)) {
                    Io(this.hqV.url);
                }
            }
        } else if (this.hra == view) {
            ceS();
            cfc();
        }
    }

    private void cfc() {
        cfd();
        if (!this.hrb.isShowing()) {
            this.hrb.a(this.hqS, this.currentIndex);
        }
    }

    private void cfd() {
        if (this.hrb == null) {
            this.hrb = new d(this.mTbPageContext.getPageActivity());
            this.hrb.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0687a
    public void a(View view, int i, ah ahVar) {
        this.currentIndex = i;
        c(false, i + 2, ahVar.aLy);
        a(false, (View) this.hqQ);
        a(ahVar, false);
        if (a(ahVar)) {
            Io(ahVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, ah ahVar) {
        a(z, this.hqQ);
        if (z) {
            if (this.hqV != null) {
                this.currentIndex = -1;
                c(false, 1, this.hqV.aLy);
                a(this.hqV, true);
                if (a(this.hqV)) {
                    Io(this.hqV.url);
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
        return (ahVar == null || TextUtils.isEmpty(ahVar.url) || TextUtils.equals(ahVar.url, this.hrd)) ? false : true;
    }

    private void Io(String str) {
        if (!TextUtils.isEmpty(str) && this.brf != null && this.hre != null) {
            cff();
            this.hrd = str;
            this.brf.cE(true);
            this.hre.playUrl = str;
            this.brf.c(this.hre);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ah ahVar, boolean z) {
        if (ahVar != null) {
            ceN();
            if (z) {
                this.hqZ.setVisibility(8);
            } else {
                this.hqZ.setVisibility(0);
                this.hqZ.startLoad(ahVar.imageUrl, 10, false);
            }
            this.hqY.setText(ahVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfe() {
        if (this.hqS != null) {
            ceN();
            c.a(this.mTbPageContext.getPageActivity(), this.hra, true, this.hqS.Fp(), this.hqS.Fo(), true);
        }
    }

    private void cff() {
        cfg();
        this.hqW.show();
    }

    private void hideLoadingView() {
        cfg();
        this.hqW.dismiss();
    }

    private void cfg() {
        if (this.hqW == null) {
            this.hqW = new h(this.mTbPageContext.getPageActivity(), this.brf.getLivePlayer());
        }
    }
}
