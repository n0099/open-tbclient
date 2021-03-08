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
/* loaded from: classes10.dex */
public class b implements View.OnClickListener, a.InterfaceC0669a, f {
    private boolean bAT;
    private View bPO;
    private com.baidu.live.u.f btp;
    private AlaLiveView hDr;
    private String hEA;
    private AlaLiveInfoData hEB;
    private View hEj;
    private AlphaGradientHListView hEk;
    private a hEl;
    private View hEm;
    private TextView hEn;
    private TextView hEo;
    private z hEp;
    private View hEq;
    private e hEr;
    private h hEt;
    private View hEu;
    private TextView hEv;
    private HeadImageView hEw;
    private ViewGroup hEx;
    private d hEy;
    private boolean hEz;
    private FrameLayout hvG;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private an hEs = new an();

    public b(TbPageContext tbPageContext, com.baidu.live.u.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.btp = fVar;
        this.bPO = fVar.getLivePlayer();
        this.hDr = alaLiveView;
        this.hvG = frameLayout;
        this.hEq = view;
        this.hEr = eVar;
        this.hEs.aLu = "全景视角";
        this.hEs.url = fVar.getVideoPath();
        this.hEA = this.hEs.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        ceT();
        ol(false);
        ceU();
    }

    private void ceT() {
        if (this.hEj == null) {
            this.hEj = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hEk = (AlphaGradientHListView) this.hEj.findViewById(a.f.lv_scene_list);
            this.hEm = this.hEj.findViewById(a.f.ll_tip_container);
            this.hEo = (TextView) this.hEm.findViewById(a.f.tv_scene_tip);
            this.hEl = new a(this.mTbPageContext.getPageActivity(), true);
            this.hEl.a(this);
            this.hEk.setAdapter((ListAdapter) this.hEl);
            this.hEk.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hEk.setDirection(2);
            this.hEk.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hEk.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hEz) {
                            b.this.hEz = true;
                            b.this.hEk.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hEk.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hEz) {
                                b.this.hEz = true;
                                b.this.hEk.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hEk.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hEz) {
                            b.this.hEz = false;
                            b.this.hEk.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hEn = (TextView) this.hEj.findViewById(a.f.tv_all_scene);
            this.hEn.setOnClickListener(this);
        }
    }

    private void ceU() {
        if (this.hEu == null) {
            this.hEu = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hEw = (HeadImageView) this.hEu.findViewById(a.f.iv_land_scene_avatar);
            this.hEw.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hEw.setDefaultBgResource(a.e.sdk_icon_default_avatar100);
            this.hEw.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
            this.hEv = (TextView) this.hEu.findViewById(a.f.tv_land_scene_name);
            this.hEx = (ViewGroup) this.hEu.findViewById(a.f.ll_land_content_container);
            this.hEx.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (ceV() && this.bAT && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hEp.Ca(), this.hEp.BZ(), true);
        }
    }

    private boolean ceV() {
        return this.hEp != null && this.hEp.BX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cF(List<an> list) {
        if (this.hEl != null) {
            this.hEl.setDatas(list);
        }
    }

    public void L(ab abVar) {
        if (abVar != null) {
            this.hEB = abVar.mLiveInfo;
            if (abVar.aKw != null) {
                if (this.hEp == null) {
                    this.hEp = abVar.aKw;
                } else if (!b(abVar.aKw) || !a(abVar.aKw) || !this.bAT) {
                    if (!b(abVar.aKw) && a(abVar.aKw) && this.bAT) {
                        afJ();
                        this.hEp = abVar.aKw;
                    } else {
                        this.hEp = abVar.aKw;
                    }
                } else {
                    return;
                }
                ceX();
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
                    ea(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void ceW() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.btp != null) {
            String videoPath = this.btp.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hEA) && this.hEs != null && this.hEs.url != null) {
                this.currentIndex = -1;
                cfd();
                a(this.hEs, true);
                HS(videoPath);
            }
        }
    }

    public void cL(int i) {
        if (ceV() && this.bAT) {
            if (i == 1) {
                cfg();
                vz(i);
                cfd();
            } else if (i == 2) {
                cfe();
            }
            if (this.hEt != null) {
                this.hEt.cs(i);
            }
        }
    }

    public void xk() {
        this.hEs.url = null;
        if (this.hEB != null) {
            this.hEB.playUrl = null;
        }
        afJ();
    }

    private void ea(JSONObject jSONObject) {
        z B = z.B(jSONObject.optJSONObject("multi_session"));
        if (B != null) {
            if (this.hEp == null) {
                this.hEp = B;
            } else if (!b(B) || !a(B) || !this.bAT) {
                if (!b(B) && a(B) && this.bAT) {
                    afJ();
                    this.hEp = B;
                } else {
                    this.hEp = B;
                }
            } else {
                return;
            }
            if (this.hEp != null) {
                ceX();
            }
        }
    }

    private void ceX() {
        String action = this.hEp.getAction();
        if (TextUtils.equals("1", action)) {
            if (ceV()) {
                afI();
            }
        } else if (TextUtils.equals("2", action)) {
            afJ();
        }
    }

    private void afI() {
        if (!this.bAT) {
            cfc();
            this.bAT = true;
            ceY();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.cfa();
                    if (!TextUtils.isEmpty(b.this.hEp.Cb())) {
                        b.this.hEo.setText(b.this.hEp.Cb());
                    }
                    b.this.cF(b.this.hEp.BY());
                    b.this.cL(realScreenOrientation);
                    b.this.cfl();
                    b.this.a(b.this.hEs, true);
                    if (b.this.hEr != null) {
                        b.this.hEr.vr(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cfh();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cfi();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void ceY() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void ceZ() {
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

    private void afJ() {
        if (this.bAT) {
            this.bAT = false;
            this.currentIndex = -1;
            cfb();
            cfg();
            if (a(this.hEs)) {
                HS(this.hEs.url);
            }
            if (this.hEr != null) {
                this.hEr.vr(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfa() {
        if (this.hEj.getParent() != null) {
            ((ViewGroup) this.hEj.getParent()).removeView(this.hEj);
        }
        if (this.hDr != null) {
            this.hDr.addView(this.hEj, (this.hEq != null ? this.hDr.getView().indexOfChild(this.hEq) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void cfb() {
        if (this.hEj.getParent() != null) {
            ((ViewGroup) this.hEj.getParent()).removeView(this.hEj);
        }
    }

    private void ol(boolean z) {
        if (this.hEj != null) {
            this.hEj.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(z zVar) {
        return this.hEp.fC(zVar.getAction());
    }

    private boolean b(z zVar) {
        return this.hEp.fD(zVar.getId());
    }

    private void cfc() {
        if (this.btp != null) {
            this.hEs.url = this.btp.getVideoPath();
            this.hEA = this.hEs.url;
        }
    }

    private void vz(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bPO != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hEj.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bPO.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bPO.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bPO.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            this.hEj.setLayoutParams(layoutParams);
            ol(true);
        }
    }

    private void cfd() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hEn);
        }
        if (this.hEl != null) {
            this.hEl.vx(this.currentIndex);
        }
        if (this.hEk != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hEk != null) {
                        b.this.hEk.setSelection(b.this.currentIndex);
                        b.this.hEk.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void cfe() {
        cff();
    }

    private void cff() {
        ol(false);
        if (this.hEu != null && this.hvG != null && this.mTbPageContext != null) {
            if (this.hEu.getParent() != null) {
                ((ViewGroup) this.hEu.getParent()).removeView(this.hEu);
            }
            int i = -1;
            if (this.hvG != null) {
                i = this.hvG.indexOfChild(this.hvG.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.hvG.addView(this.hEu, i + 1, layoutParams);
        }
    }

    private void cfg() {
        if (this.hEu != null && this.hEu.getParent() != null) {
            ((ViewGroup) this.hEu.getParent()).removeView(this.hEu);
        }
        if (this.hEy != null && this.hEy.isShowing()) {
            this.hEy.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfh() {
        if (this.hEm != null && this.hEm.getVisibility() != 0) {
            this.hEm.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfi() {
        if (this.hEm != null && this.hEm.getVisibility() == 0) {
            this.hEm.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bAT) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hEn == view) {
            if (this.hEs != null) {
                d(true, 1, this.hEs.aLu);
                this.currentIndex = -1;
                a(true, (View) this.hEn);
                if (this.hEl != null) {
                    this.hEl.vx(this.currentIndex);
                }
                a(this.hEs, true);
                if (a(this.hEs)) {
                    HS(this.hEs.url);
                }
            }
        } else if (this.hEx == view) {
            ceZ();
            cfj();
        }
    }

    private void cfj() {
        cfk();
        if (!this.hEy.isShowing()) {
            this.hEy.a(this.hEp, this.currentIndex);
        }
    }

    private void cfk() {
        if (this.hEy == null) {
            this.hEy = new d(this.mTbPageContext.getPageActivity());
            this.hEy.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0669a
    public void a(View view, int i, an anVar) {
        this.currentIndex = i;
        d(false, i + 2, anVar.aLu);
        a(false, (View) this.hEn);
        a(anVar, false);
        if (a(anVar)) {
            HS(anVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, an anVar) {
        a(z, this.hEn);
        if (z) {
            if (this.hEs != null) {
                this.currentIndex = -1;
                d(false, 1, this.hEs.aLu);
                a(this.hEs, true);
                if (a(this.hEs)) {
                    HS(this.hEs.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        d(false, i + 2, anVar.aLu);
        a(anVar, false);
        if (a(anVar)) {
            HS(anVar.url);
        }
    }

    private boolean a(an anVar) {
        return (anVar == null || TextUtils.isEmpty(anVar.url) || TextUtils.equals(anVar.url, this.hEA)) ? false : true;
    }

    private void HS(String str) {
        if (!TextUtils.isEmpty(str) && this.btp != null && this.hEB != null) {
            cfm();
            this.hEA = str;
            this.btp.cM(true);
            this.hEB.playUrl = str;
            this.btp.c(this.hEB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(an anVar, boolean z) {
        if (anVar != null) {
            ceU();
            if (z) {
                this.hEw.setVisibility(8);
            } else {
                this.hEw.setVisibility(0);
                this.hEw.startLoad(anVar.imageUrl, 10, false);
            }
            this.hEv.setText(anVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfl() {
        if (this.hEp != null) {
            ceU();
            c.a(this.mTbPageContext.getPageActivity(), this.hEx, true, this.hEp.Ca(), this.hEp.BZ(), true);
        }
    }

    private void cfm() {
        cfn();
        this.hEt.show();
    }

    private void hideLoadingView() {
        cfn();
        this.hEt.dismiss();
    }

    private void cfn() {
        if (this.hEt == null) {
            this.hEt = new h(this.mTbPageContext.getPageActivity(), this.btp.getLivePlayer());
        }
    }
}
