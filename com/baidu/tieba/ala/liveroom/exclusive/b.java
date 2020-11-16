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
    private View bFu;
    private com.baidu.live.s.f blY;
    private boolean bqH;
    private FrameLayout gYx;
    private AlaLiveView hgl;
    private View hhh;
    private AlphaGradientHListView hhi;
    private a hhj;
    private View hhk;
    private TextView hhl;
    private TextView hhm;
    private u hhn;
    private View hho;
    private e hhp;
    private h hhr;
    private View hhs;
    private TextView hht;
    private HeadImageView hhu;
    private ViewGroup hhv;
    private d hhw;
    private boolean hhx;
    private String hhy;
    private AlaLiveInfoData hhz;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private af hhq = new af();

    public b(TbPageContext tbPageContext, com.baidu.live.s.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.blY = fVar;
        this.bFu = fVar.getLivePlayer();
        this.hgl = alaLiveView;
        this.gYx = frameLayout;
        this.hho = view;
        this.hhp = eVar;
        this.hhq.aIE = "全景视角";
        this.hhq.url = fVar.getVideoPath();
        this.hhy = this.hhq.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        caS();
        nj(false);
        caT();
    }

    private void caS() {
        if (this.hhh == null) {
            this.hhh = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hhi = (AlphaGradientHListView) this.hhh.findViewById(a.f.lv_scene_list);
            this.hhk = this.hhh.findViewById(a.f.ll_tip_container);
            this.hhm = (TextView) this.hhk.findViewById(a.f.tv_scene_tip);
            this.hhj = new a(this.mTbPageContext.getPageActivity(), true);
            this.hhj.a(this);
            this.hhi.setAdapter((ListAdapter) this.hhj);
            this.hhi.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hhi.setDirection(2);
            this.hhi.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hhi.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hhx) {
                            b.this.hhx = true;
                            b.this.hhi.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hhi.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hhx) {
                                b.this.hhx = true;
                                b.this.hhi.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hhi.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hhx) {
                            b.this.hhx = false;
                            b.this.hhi.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hhl = (TextView) this.hhh.findViewById(a.f.tv_all_scene);
            this.hhl.setOnClickListener(this);
        }
    }

    private void caT() {
        if (this.hhs == null) {
            this.hhs = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hhu = (HeadImageView) this.hhs.findViewById(a.f.iv_land_scene_avatar);
            this.hhu.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hhu.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hhu.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hht = (TextView) this.hhs.findViewById(a.f.tv_land_scene_name);
            this.hhv = (ViewGroup) this.hhs.findViewById(a.f.ll_land_content_container);
            this.hhv.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (caU() && this.bqH && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hhn.DE(), this.hhn.DD(), true);
        }
    }

    private boolean caU() {
        return this.hhn != null && this.hhn.DB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(List<af> list) {
        if (this.hhj != null) {
            this.hhj.setDatas(list);
        }
    }

    public void F(w wVar) {
        if (wVar != null) {
            this.hhz = wVar.mLiveInfo;
            if (wVar.aIb != null) {
                if (this.hhn == null) {
                    this.hhn = wVar.aIb;
                } else if (!b(wVar.aIb) || !a(wVar.aIb) || !this.bqH) {
                    if (!b(wVar.aIb) && a(wVar.aIb) && this.bqH) {
                        aeJ();
                        this.hhn = wVar.aIb;
                    } else {
                        this.hhn = wVar.aIb;
                    }
                } else {
                    return;
                }
                caW();
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
                    dM(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void caV() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.blY != null) {
            String videoPath = this.blY.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hhy) && this.hhq != null && this.hhq.url != null) {
                this.currentIndex = -1;
                cbc();
                a(this.hhq, true);
                HA(videoPath);
            }
        }
    }

    public void dT(int i) {
        if (caU() && this.bqH) {
            if (i == 1) {
                cbf();
                wc(i);
                cbc();
            } else if (i == 2) {
                cbd();
            }
            if (this.hhr != null) {
                this.hhr.dE(i);
            }
        }
    }

    public void Ka() {
        this.hhq.url = null;
        if (this.hhz != null) {
            this.hhz.playUrl = null;
        }
        aeJ();
    }

    private void dM(JSONObject jSONObject) {
        u t = u.t(jSONObject.optJSONObject("multi_session"));
        if (t != null) {
            if (this.hhn == null) {
                this.hhn = t;
            } else if (!b(t) || !a(t) || !this.bqH) {
                if (!b(t) && a(t) && this.bqH) {
                    aeJ();
                    this.hhn = t;
                } else {
                    this.hhn = t;
                }
            } else {
                return;
            }
            if (this.hhn != null) {
                caW();
            }
        }
    }

    private void caW() {
        String action = this.hhn.getAction();
        if (TextUtils.equals("1", action)) {
            if (caU()) {
                aeI();
            }
        } else if (TextUtils.equals("2", action)) {
            aeJ();
        }
    }

    private void aeI() {
        if (!this.bqH) {
            cbb();
            this.bqH = true;
            caX();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.caZ();
                    if (!TextUtils.isEmpty(b.this.hhn.DF())) {
                        b.this.hhm.setText(b.this.hhn.DF());
                    }
                    b.this.cz(b.this.hhn.DC());
                    b.this.dT(realScreenOrientation);
                    b.this.cbk();
                    b.this.a(b.this.hhq, true);
                    if (b.this.hhp != null) {
                        b.this.hhp.vU(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cbg();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cbh();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void caX() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void caY() {
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

    private void aeJ() {
        if (this.bqH) {
            this.bqH = false;
            this.currentIndex = -1;
            cba();
            cbf();
            if (a(this.hhq)) {
                HA(this.hhq.url);
            }
            if (this.hhp != null) {
                this.hhp.vU(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caZ() {
        if (this.hhh.getParent() != null) {
            ((ViewGroup) this.hhh.getParent()).removeView(this.hhh);
        }
        if (this.hgl != null) {
            this.hgl.addView(this.hhh, (this.hho != null ? this.hgl.getView().indexOfChild(this.hho) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void cba() {
        if (this.hhh.getParent() != null) {
            ((ViewGroup) this.hhh.getParent()).removeView(this.hhh);
        }
    }

    private void nj(boolean z) {
        if (this.hhh != null) {
            this.hhh.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(u uVar) {
        return this.hhn.gh(uVar.getAction());
    }

    private boolean b(u uVar) {
        return this.hhn.gi(uVar.getId());
    }

    private void cbb() {
        if (this.blY != null) {
            this.hhq.url = this.blY.getVideoPath();
            this.hhy = this.hhq.url;
        }
    }

    private void wc(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bFu != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hhh.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bFu.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bFu.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bFu.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            this.hhh.setLayoutParams(layoutParams);
            nj(true);
        }
    }

    private void cbc() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hhl);
        }
        if (this.hhj != null) {
            this.hhj.wa(this.currentIndex);
        }
        if (this.hhi != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hhi != null) {
                        b.this.hhi.setSelection(b.this.currentIndex);
                        b.this.hhi.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void cbd() {
        cbe();
    }

    private void cbe() {
        nj(false);
        if (this.hhs != null && this.gYx != null && this.mTbPageContext != null) {
            if (this.hhs.getParent() != null) {
                ((ViewGroup) this.hhs.getParent()).removeView(this.hhs);
            }
            int i = -1;
            if (this.gYx != null) {
                i = this.gYx.indexOfChild(this.gYx.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.gYx.addView(this.hhs, i + 1, layoutParams);
        }
    }

    private void cbf() {
        if (this.hhs != null && this.hhs.getParent() != null) {
            ((ViewGroup) this.hhs.getParent()).removeView(this.hhs);
        }
        if (this.hhw != null && this.hhw.isShowing()) {
            this.hhw.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbg() {
        if (this.hhk != null && this.hhk.getVisibility() != 0) {
            this.hhk.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbh() {
        if (this.hhk != null && this.hhk.getVisibility() == 0) {
            this.hhk.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bqH) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhl == view) {
            if (this.hhq != null) {
                c(true, 1, this.hhq.aIE);
                this.currentIndex = -1;
                a(true, (View) this.hhl);
                if (this.hhj != null) {
                    this.hhj.wa(this.currentIndex);
                }
                a(this.hhq, true);
                if (a(this.hhq)) {
                    HA(this.hhq.url);
                }
            }
        } else if (this.hhv == view) {
            caY();
            cbi();
        }
    }

    private void cbi() {
        cbj();
        if (!this.hhw.isShowing()) {
            this.hhw.a(this.hhn, this.currentIndex);
        }
    }

    private void cbj() {
        if (this.hhw == null) {
            this.hhw = new d(this.mTbPageContext.getPageActivity());
            this.hhw.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0673a
    public void a(View view, int i, af afVar) {
        this.currentIndex = i;
        c(false, i + 2, afVar.aIE);
        a(false, (View) this.hhl);
        a(afVar, false);
        if (a(afVar)) {
            HA(afVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, af afVar) {
        a(z, this.hhl);
        if (z) {
            if (this.hhq != null) {
                this.currentIndex = -1;
                c(false, 1, this.hhq.aIE);
                a(this.hhq, true);
                if (a(this.hhq)) {
                    HA(this.hhq.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        c(false, i + 2, afVar.aIE);
        a(afVar, false);
        if (a(afVar)) {
            HA(afVar.url);
        }
    }

    private boolean a(af afVar) {
        return (afVar == null || TextUtils.isEmpty(afVar.url) || TextUtils.equals(afVar.url, this.hhy)) ? false : true;
    }

    private void HA(String str) {
        if (!TextUtils.isEmpty(str) && this.blY != null && this.hhz != null) {
            cbl();
            this.hhy = str;
            this.blY.cq(true);
            this.hhz.playUrl = str;
            this.blY.c(this.hhz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(af afVar, boolean z) {
        if (afVar != null) {
            caT();
            if (z) {
                this.hhu.setVisibility(8);
            } else {
                this.hhu.setVisibility(0);
                this.hhu.startLoad(afVar.imageUrl, 10, false);
            }
            this.hht.setText(afVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        if (this.hhn != null) {
            caT();
            c.a(this.mTbPageContext.getPageActivity(), this.hhv, true, this.hhn.DE(), this.hhn.DD(), true);
        }
    }

    private void cbl() {
        cbm();
        this.hhr.show();
    }

    private void hideLoadingView() {
        cbm();
        this.hhr.dismiss();
    }

    private void cbm() {
        if (this.hhr == null) {
            this.hhr = new h(this.mTbPageContext.getPageActivity(), this.blY.getLivePlayer());
        }
    }
}
