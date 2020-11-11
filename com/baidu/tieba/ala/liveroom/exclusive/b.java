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
import com.baidu.live.data.af;
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
public class b implements View.OnClickListener, a.InterfaceC0673a, f {
    private View bHf;
    private com.baidu.live.s.f bnJ;
    private boolean bss;
    private FrameLayout gYQ;
    private AlaLiveView hgE;
    private View hhA;
    private AlphaGradientHListView hhB;
    private a hhC;
    private View hhD;
    private TextView hhE;
    private TextView hhF;
    private u hhG;
    private View hhH;
    private e hhI;
    private h hhK;
    private View hhL;
    private TextView hhM;
    private HeadImageView hhN;
    private ViewGroup hhO;
    private d hhP;
    private boolean hhQ;
    private String hhR;
    private AlaLiveInfoData hhS;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private af hhJ = new af();

    public b(TbPageContext tbPageContext, com.baidu.live.s.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.bnJ = fVar;
        this.bHf = fVar.getLivePlayer();
        this.hgE = alaLiveView;
        this.gYQ = frameLayout;
        this.hhH = view;
        this.hhI = eVar;
        this.hhJ.aKp = "全景视角";
        this.hhJ.url = fVar.getVideoPath();
        this.hhR = this.hhJ.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        cbz();
        ni(false);
        cbA();
    }

    private void cbz() {
        if (this.hhA == null) {
            this.hhA = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hhB = (AlphaGradientHListView) this.hhA.findViewById(a.f.lv_scene_list);
            this.hhD = this.hhA.findViewById(a.f.ll_tip_container);
            this.hhF = (TextView) this.hhD.findViewById(a.f.tv_scene_tip);
            this.hhC = new a(this.mTbPageContext.getPageActivity(), true);
            this.hhC.a(this);
            this.hhB.setAdapter((ListAdapter) this.hhC);
            this.hhB.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hhB.setDirection(2);
            this.hhB.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hhB.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hhQ) {
                            b.this.hhQ = true;
                            b.this.hhB.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hhB.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hhQ) {
                                b.this.hhQ = true;
                                b.this.hhB.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hhB.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hhQ) {
                            b.this.hhQ = false;
                            b.this.hhB.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hhE = (TextView) this.hhA.findViewById(a.f.tv_all_scene);
            this.hhE.setOnClickListener(this);
        }
    }

    private void cbA() {
        if (this.hhL == null) {
            this.hhL = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hhN = (HeadImageView) this.hhL.findViewById(a.f.iv_land_scene_avatar);
            this.hhN.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hhN.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hhN.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hhM = (TextView) this.hhL.findViewById(a.f.tv_land_scene_name);
            this.hhO = (ViewGroup) this.hhL.findViewById(a.f.ll_land_content_container);
            this.hhO.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (cbB() && this.bss && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hhG.En(), this.hhG.Em(), true);
        }
    }

    private boolean cbB() {
        return this.hhG != null && this.hhG.Ek();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(List<af> list) {
        if (this.hhC != null) {
            this.hhC.setDatas(list);
        }
    }

    public void F(w wVar) {
        if (wVar != null) {
            this.hhS = wVar.mLiveInfo;
            if (wVar.aJM != null) {
                if (this.hhG == null) {
                    this.hhG = wVar.aJM;
                } else if (!b(wVar.aJM) || !a(wVar.aJM) || !this.bss) {
                    if (!b(wVar.aJM) && a(wVar.aJM) && this.bss) {
                        afr();
                        this.hhG = wVar.aJM;
                    } else {
                        this.hhG = wVar.aJM;
                    }
                } else {
                    return;
                }
                cbD();
            }
        }
    }

    public void F(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "multi_session".equals(jSONObject.optString("content_type"))) {
                    dS(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void cbC() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.bnJ != null) {
            String videoPath = this.bnJ.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hhR) && this.hhJ != null && this.hhJ.url != null) {
                this.currentIndex = -1;
                cbJ();
                a(this.hhJ, true);
                HZ(videoPath);
            }
        }
    }

    public void dX(int i) {
        if (cbB() && this.bss) {
            if (i == 1) {
                cbM();
                vE(i);
                cbJ();
            } else if (i == 2) {
                cbK();
            }
            if (this.hhK != null) {
                this.hhK.dI(i);
            }
        }
    }

    public void KJ() {
        this.hhJ.url = null;
        if (this.hhS != null) {
            this.hhS.playUrl = null;
        }
        afr();
    }

    private void dS(JSONObject jSONObject) {
        u z = u.z(jSONObject.optJSONObject("multi_session"));
        if (z != null) {
            if (this.hhG == null) {
                this.hhG = z;
            } else if (!b(z) || !a(z) || !this.bss) {
                if (!b(z) && a(z) && this.bss) {
                    afr();
                    this.hhG = z;
                } else {
                    this.hhG = z;
                }
            } else {
                return;
            }
            if (this.hhG != null) {
                cbD();
            }
        }
    }

    private void cbD() {
        String action = this.hhG.getAction();
        if (TextUtils.equals("1", action)) {
            if (cbB()) {
                afq();
            }
        } else if (TextUtils.equals("2", action)) {
            afr();
        }
    }

    private void afq() {
        if (!this.bss) {
            cbI();
            this.bss = true;
            cbE();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.cbG();
                    if (!TextUtils.isEmpty(b.this.hhG.Eo())) {
                        b.this.hhF.setText(b.this.hhG.Eo());
                    }
                    b.this.cz(b.this.hhG.El());
                    b.this.dX(realScreenOrientation);
                    b.this.cbR();
                    b.this.a(b.this.hhJ, true);
                    if (b.this.hhI != null) {
                        b.this.hhI.vw(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cbN();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cbO();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void cbE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void cbF() {
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

    private void afr() {
        if (this.bss) {
            this.bss = false;
            this.currentIndex = -1;
            cbH();
            cbM();
            if (a(this.hhJ)) {
                HZ(this.hhJ.url);
            }
            if (this.hhI != null) {
                this.hhI.vw(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbG() {
        if (this.hhA.getParent() != null) {
            ((ViewGroup) this.hhA.getParent()).removeView(this.hhA);
        }
        if (this.hgE != null) {
            this.hgE.addView(this.hhA, (this.hhH != null ? this.hgE.getView().indexOfChild(this.hhH) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void cbH() {
        if (this.hhA.getParent() != null) {
            ((ViewGroup) this.hhA.getParent()).removeView(this.hhA);
        }
    }

    private void ni(boolean z) {
        if (this.hhA != null) {
            this.hhA.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(u uVar) {
        return this.hhG.gn(uVar.getAction());
    }

    private boolean b(u uVar) {
        return this.hhG.go(uVar.getId());
    }

    private void cbI() {
        if (this.bnJ != null) {
            this.hhJ.url = this.bnJ.getVideoPath();
            this.hhR = this.hhJ.url;
        }
    }

    private void vE(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bHf != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hhA.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bHf.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bHf.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bHf.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            this.hhA.setLayoutParams(layoutParams);
            ni(true);
        }
    }

    private void cbJ() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hhE);
        }
        if (this.hhC != null) {
            this.hhC.vC(this.currentIndex);
        }
        if (this.hhB != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hhB != null) {
                        b.this.hhB.setSelection(b.this.currentIndex);
                        b.this.hhB.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void cbK() {
        cbL();
    }

    private void cbL() {
        ni(false);
        if (this.hhL != null && this.gYQ != null && this.mTbPageContext != null) {
            if (this.hhL.getParent() != null) {
                ((ViewGroup) this.hhL.getParent()).removeView(this.hhL);
            }
            int i = -1;
            if (this.gYQ != null) {
                i = this.gYQ.indexOfChild(this.gYQ.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.gYQ.addView(this.hhL, i + 1, layoutParams);
        }
    }

    private void cbM() {
        if (this.hhL != null && this.hhL.getParent() != null) {
            ((ViewGroup) this.hhL.getParent()).removeView(this.hhL);
        }
        if (this.hhP != null && this.hhP.isShowing()) {
            this.hhP.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbN() {
        if (this.hhD != null && this.hhD.getVisibility() != 0) {
            this.hhD.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbO() {
        if (this.hhD != null && this.hhD.getVisibility() == 0) {
            this.hhD.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bss) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhE == view) {
            if (this.hhJ != null) {
                c(true, 1, this.hhJ.aKp);
                this.currentIndex = -1;
                a(true, (View) this.hhE);
                if (this.hhC != null) {
                    this.hhC.vC(this.currentIndex);
                }
                a(this.hhJ, true);
                if (a(this.hhJ)) {
                    HZ(this.hhJ.url);
                }
            }
        } else if (this.hhO == view) {
            cbF();
            cbP();
        }
    }

    private void cbP() {
        cbQ();
        if (!this.hhP.isShowing()) {
            this.hhP.a(this.hhG, this.currentIndex);
        }
    }

    private void cbQ() {
        if (this.hhP == null) {
            this.hhP = new d(this.mTbPageContext.getPageActivity());
            this.hhP.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0673a
    public void a(View view, int i, af afVar) {
        this.currentIndex = i;
        c(false, i + 2, afVar.aKp);
        a(false, (View) this.hhE);
        a(afVar, false);
        if (a(afVar)) {
            HZ(afVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, af afVar) {
        a(z, this.hhE);
        if (z) {
            if (this.hhJ != null) {
                this.currentIndex = -1;
                c(false, 1, this.hhJ.aKp);
                a(this.hhJ, true);
                if (a(this.hhJ)) {
                    HZ(this.hhJ.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, afVar.aKp);
        a(afVar, false);
        if (a(afVar)) {
            HZ(afVar.url);
        }
    }

    private boolean a(af afVar) {
        return (afVar == null || TextUtils.isEmpty(afVar.url) || TextUtils.equals(afVar.url, this.hhR)) ? false : true;
    }

    private void HZ(String str) {
        if (!TextUtils.isEmpty(str) && this.bnJ != null && this.hhS != null) {
            cbS();
            this.hhR = str;
            this.bnJ.co(true);
            this.hhS.playUrl = str;
            this.bnJ.c(this.hhS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(af afVar, boolean z) {
        if (afVar != null) {
            cbA();
            if (z) {
                this.hhN.setVisibility(8);
            } else {
                this.hhN.setVisibility(0);
                this.hhN.startLoad(afVar.imageUrl, 10, false);
            }
            this.hhM.setText(afVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbR() {
        if (this.hhG != null) {
            cbA();
            c.a(this.mTbPageContext.getPageActivity(), this.hhO, true, this.hhG.En(), this.hhG.Em(), true);
        }
    }

    private void cbS() {
        cbT();
        this.hhK.show();
    }

    private void hideLoadingView() {
        cbT();
        this.hhK.dismiss();
    }

    private void cbT() {
        if (this.hhK == null) {
            this.hhK = new h(this.mTbPageContext.getPageActivity(), this.bnJ.getLivePlayer());
        }
    }
}
