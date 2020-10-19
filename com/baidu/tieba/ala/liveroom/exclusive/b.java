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
public class b implements View.OnClickListener, a.InterfaceC0643a, f {
    private com.baidu.live.q.f bkU;
    private boolean bpm;
    private View byb;
    private FrameLayout gGW;
    private AlaLiveView gOO;
    private View gPR;
    private AlphaGradientHListView gPS;
    private a gPT;
    private View gPU;
    private TextView gPV;
    private TextView gPW;
    private r gPX;
    private View gPY;
    private e gPZ;
    private h gQb;
    private View gQc;
    private TextView gQd;
    private HeadImageView gQe;
    private ViewGroup gQf;
    private d gQg;
    private boolean gQh;
    private String gQi;
    private AlaLiveInfoData gQj;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private ac gQa = new ac();

    public b(TbPageContext tbPageContext, com.baidu.live.q.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.bkU = fVar;
        this.byb = fVar.getLivePlayer();
        this.gOO = alaLiveView;
        this.gGW = frameLayout;
        this.gPY = view;
        this.gPZ = eVar;
        this.gQa.aIO = "全景视角";
        this.gQa.url = fVar.getVideoPath();
        this.gQi = this.gQa.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        bVY();
        mJ(false);
        bVZ();
    }

    private void bVY() {
        if (this.gPR == null) {
            this.gPR = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.gPS = (AlphaGradientHListView) this.gPR.findViewById(a.g.lv_scene_list);
            this.gPU = this.gPR.findViewById(a.g.ll_tip_container);
            this.gPW = (TextView) this.gPU.findViewById(a.g.tv_scene_tip);
            this.gPT = new a(this.mTbPageContext.getPageActivity(), true);
            this.gPT.a(this);
            this.gPS.setAdapter((ListAdapter) this.gPT);
            this.gPS.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.f.sdk_transparent_bg));
            this.gPS.setDirection(2);
            this.gPS.setColor(this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.d.sdk_white_alpha100));
            this.gPS.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.gQh) {
                            b.this.gQh = true;
                            b.this.gPS.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                            b.this.gPS.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.gQh) {
                                b.this.gQh = true;
                                b.this.gPS.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.e.sdk_ds30));
                                b.this.gPS.setNeedAlphaShade(true);
                            }
                        } else if (b.this.gQh) {
                            b.this.gQh = false;
                            b.this.gPS.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.gPV = (TextView) this.gPR.findViewById(a.g.tv_all_scene);
            this.gPV.setOnClickListener(this);
        }
    }

    private void bVZ() {
        if (this.gQc == null) {
            this.gQc = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.gQe = (HeadImageView) this.gQc.findViewById(a.g.iv_land_scene_avatar);
            this.gQe.setScaleType(ImageView.ScaleType.FIT_XY);
            this.gQe.setDefaultBgResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gQe.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gQd = (TextView) this.gQc.findViewById(a.g.tv_land_scene_name);
            this.gQf = (ViewGroup) this.gQc.findViewById(a.g.ll_land_content_container);
            this.gQf.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (bWa() && this.bpm && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.gPX.DL(), this.gPX.DK(), true);
        }
    }

    private boolean bWa() {
        return this.gPX != null && this.gPX.DI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(List<ac> list) {
        if (this.gPT != null) {
            this.gPT.setDatas(list);
        }
    }

    public void x(u uVar) {
        if (uVar != null) {
            this.gQj = uVar.mLiveInfo;
            if (uVar.aIw != null) {
                if (this.gPX == null) {
                    this.gPX = uVar.aIw;
                } else if (!b(uVar.aIw) || !a(uVar.aIw) || !this.bpm) {
                    if (!b(uVar.aIw) && a(uVar.aIw) && this.bpm) {
                        aaX();
                        this.gPX = uVar.aIw;
                    } else {
                        this.gPX = uVar.aIw;
                    }
                } else {
                    return;
                }
                bWc();
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
                    dH(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void bWb() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.bkU != null) {
            String videoPath = this.bkU.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.gQi) && this.gQa != null && this.gQa.url != null) {
                this.currentIndex = -1;
                bWi();
                a(this.gQa, true);
                Hj(videoPath);
            }
        }
    }

    public void eZ(int i) {
        if (bWa() && this.bpm) {
            if (i == 1) {
                bWl();
                uX(i);
                bWi();
            } else if (i == 2) {
                bWj();
            }
            if (this.gQb != null) {
                this.gQb.dI(i);
            }
        }
    }

    public void JQ() {
        this.gQa.url = null;
        if (this.gQj != null) {
            this.gQj.playUrl = null;
        }
        aaX();
    }

    private void dH(JSONObject jSONObject) {
        r w = r.w(jSONObject.optJSONObject("multi_session"));
        if (w != null) {
            if (this.gPX == null) {
                this.gPX = w;
            } else if (!b(w) || !a(w) || !this.bpm) {
                if (!b(w) && a(w) && this.bpm) {
                    aaX();
                    this.gPX = w;
                } else {
                    this.gPX = w;
                }
            } else {
                return;
            }
            if (this.gPX != null) {
                bWc();
            }
        }
    }

    private void bWc() {
        String action = this.gPX.getAction();
        if (TextUtils.equals("1", action)) {
            if (bWa()) {
                aaW();
            }
        } else if (TextUtils.equals("2", action)) {
            aaX();
        }
    }

    private void aaW() {
        if (!this.bpm) {
            bWh();
            this.bpm = true;
            bWd();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.bWf();
                    if (!TextUtils.isEmpty(b.this.gPX.DM())) {
                        b.this.gPW.setText(b.this.gPX.DM());
                    }
                    b.this.ch(b.this.gPX.DJ());
                    b.this.eZ(realScreenOrientation);
                    b.this.bWq();
                    b.this.a(b.this.gQa, true);
                    if (b.this.gPZ != null) {
                        b.this.gPZ.uP(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bWm();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.bWn();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void bWd() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void bWe() {
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

    private void aaX() {
        if (this.bpm) {
            this.bpm = false;
            this.currentIndex = -1;
            bWg();
            bWl();
            if (a(this.gQa)) {
                Hj(this.gQa.url);
            }
            if (this.gPZ != null) {
                this.gPZ.uP(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWf() {
        if (this.gPR.getParent() != null) {
            ((ViewGroup) this.gPR.getParent()).removeView(this.gPR);
        }
        if (this.gOO != null) {
            this.gOO.addView(this.gPR, (this.gPY != null ? this.gOO.getView().indexOfChild(this.gPY) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void bWg() {
        if (this.gPR.getParent() != null) {
            ((ViewGroup) this.gPR.getParent()).removeView(this.gPR);
        }
    }

    private void mJ(boolean z) {
        if (this.gPR != null) {
            this.gPR.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(r rVar) {
        return this.gPX.gi(rVar.getAction());
    }

    private boolean b(r rVar) {
        return this.gPX.gj(rVar.getId());
    }

    private void bWh() {
        if (this.bkU != null) {
            this.gQa.url = this.bkU.getVideoPath();
            this.gQi = this.gQa.url;
        }
    }

    private void uX(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.byb != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.gPR.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.byb.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.byb.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.byb.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds80);
            }
            this.gPR.setLayoutParams(layoutParams);
            mJ(true);
        }
    }

    private void bWi() {
        if (this.currentIndex == -1) {
            a(true, (View) this.gPV);
        }
        if (this.gPT != null) {
            this.gPT.uV(this.currentIndex);
        }
        if (this.gPS != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.gPS != null) {
                        b.this.gPS.setSelection(b.this.currentIndex);
                        b.this.gPS.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void bWj() {
        bWk();
    }

    private void bWk() {
        mJ(false);
        if (this.gQc != null && this.gGW != null && this.mTbPageContext != null) {
            if (this.gQc.getParent() != null) {
                ((ViewGroup) this.gQc.getParent()).removeView(this.gQc);
            }
            int i = -1;
            if (this.gGW != null) {
                i = this.gGW.indexOfChild(this.gGW.findViewById(a.g.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.e.sdk_ds26);
            this.gGW.addView(this.gQc, i + 1, layoutParams);
        }
    }

    private void bWl() {
        if (this.gQc != null && this.gQc.getParent() != null) {
            ((ViewGroup) this.gQc.getParent()).removeView(this.gQc);
        }
        if (this.gQg != null && this.gQg.isShowing()) {
            this.gQg.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWm() {
        if (this.gPU != null && this.gPU.getVisibility() != 0) {
            this.gPU.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWn() {
        if (this.gPU != null && this.gPU.getVisibility() == 0) {
            this.gPU.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bpm) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gPV == view) {
            if (this.gQa != null) {
                c(true, 1, this.gQa.aIO);
                this.currentIndex = -1;
                a(true, (View) this.gPV);
                if (this.gPT != null) {
                    this.gPT.uV(this.currentIndex);
                }
                a(this.gQa, true);
                if (a(this.gQa)) {
                    Hj(this.gQa.url);
                }
            }
        } else if (this.gQf == view) {
            bWe();
            bWo();
        }
    }

    private void bWo() {
        bWp();
        if (!this.gQg.isShowing()) {
            this.gQg.a(this.gPX, this.currentIndex);
        }
    }

    private void bWp() {
        if (this.gQg == null) {
            this.gQg = new d(this.mTbPageContext.getPageActivity());
            this.gQg.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0643a
    public void a(View view, int i, ac acVar) {
        this.currentIndex = i;
        c(false, i + 2, acVar.aIO);
        a(false, (View) this.gPV);
        a(acVar, false);
        if (a(acVar)) {
            Hj(acVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, ac acVar) {
        a(z, this.gPV);
        if (z) {
            if (this.gQa != null) {
                this.currentIndex = -1;
                c(false, 1, this.gQa.aIO);
                a(this.gQa, true);
                if (a(this.gQa)) {
                    Hj(this.gQa.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, acVar.aIO);
        a(acVar, false);
        if (a(acVar)) {
            Hj(acVar.url);
        }
    }

    private boolean a(ac acVar) {
        return (acVar == null || TextUtils.isEmpty(acVar.url) || TextUtils.equals(acVar.url, this.gQi)) ? false : true;
    }

    private void Hj(String str) {
        if (!TextUtils.isEmpty(str) && this.bkU != null && this.gQj != null) {
            bWr();
            this.gQi = str;
            this.bkU.cl(true);
            this.gQj.playUrl = str;
            this.bkU.c(this.gQj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ac acVar, boolean z) {
        if (acVar != null) {
            bVZ();
            if (z) {
                this.gQe.setVisibility(8);
            } else {
                this.gQe.setVisibility(0);
                this.gQe.startLoad(acVar.imageUrl, 10, false);
            }
            this.gQd.setText(acVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWq() {
        if (this.gPX != null) {
            bVZ();
            c.a(this.mTbPageContext.getPageActivity(), this.gQf, true, this.gPX.DL(), this.gPX.DK(), true);
        }
    }

    private void bWr() {
        bWs();
        this.gQb.show();
    }

    private void hideLoadingView() {
        bWs();
        this.gQb.dismiss();
    }

    private void bWs() {
        if (this.gQb == null) {
            this.gQb = new h(this.mTbPageContext.getPageActivity(), this.bkU.getLivePlayer());
        }
    }
}
