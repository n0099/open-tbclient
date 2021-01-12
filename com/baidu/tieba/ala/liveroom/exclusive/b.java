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
import com.baidu.live.data.aj;
import com.baidu.live.data.v;
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
/* loaded from: classes10.dex */
public class b implements View.OnClickListener, a.InterfaceC0662a, f {
    private View bKE;
    private com.baidu.live.v.f bon;
    private boolean bvR;
    private FrameLayout hpy;
    private AlaLiveView hxk;
    private View hyc;
    private AlphaGradientHListView hyd;
    private a hye;
    private View hyf;
    private TextView hyg;
    private TextView hyh;
    private v hyi;
    private View hyj;
    private e hyk;
    private h hym;
    private View hyn;
    private TextView hyo;
    private HeadImageView hyp;
    private ViewGroup hyq;
    private d hyr;
    private boolean hys;
    private String hyt;
    private AlaLiveInfoData hyu;
    private Handler mHandler;
    private TbPageContext mTbPageContext;
    private int currentIndex = -1;
    private aj hyl = new aj();

    public b(TbPageContext tbPageContext, com.baidu.live.v.f fVar, AlaLiveView alaLiveView, View view, FrameLayout frameLayout, e eVar) {
        this.mTbPageContext = tbPageContext;
        this.bon = fVar;
        this.bKE = fVar.getLivePlayer();
        this.hxk = alaLiveView;
        this.hpy = frameLayout;
        this.hyj = view;
        this.hyk = eVar;
        this.hyl.aHp = "全景视角";
        this.hyl.url = fVar.getVideoPath();
        this.hyt = this.hyl.url;
        this.mHandler = new Handler();
        initView();
    }

    private void initView() {
        cdL();
        oa(false);
        cdM();
    }

    private void cdL() {
        if (this.hyc == null) {
            this.hyc = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_exclusive_scene_layout, (ViewGroup) null);
            this.hyd = (AlphaGradientHListView) this.hyc.findViewById(a.f.lv_scene_list);
            this.hyf = this.hyc.findViewById(a.f.ll_tip_container);
            this.hyh = (TextView) this.hyf.findViewById(a.f.tv_scene_tip);
            this.hye = new a(this.mTbPageContext.getPageActivity(), true);
            this.hye.a(this);
            this.hyd.setAdapter((ListAdapter) this.hye);
            this.hyd.setSelector(this.mTbPageContext.getPageActivity().getResources().getDrawable(a.e.sdk_transparent_bg));
            this.hyd.setDirection(2);
            this.hyd.setColor(this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha0), this.mTbPageContext.getResources().getColor(a.c.sdk_white_alpha100));
            this.hyd.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.1
                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i) {
                }

                @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
                public void a(AbsHListView absHListView, int i, int i2, int i3) {
                    if (i != 0) {
                        if (!b.this.hys) {
                            b.this.hys = true;
                            b.this.hyd.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                            b.this.hyd.setNeedAlphaShade(true);
                            return;
                        }
                        return;
                    }
                    View childAt = absHListView.getChildAt(i);
                    if (childAt != null) {
                        if (childAt.getLeft() < -6) {
                            if (!b.this.hys) {
                                b.this.hys = true;
                                b.this.hyd.setShadowWidth(BdUtilHelper.getDimens(b.this.mTbPageContext.getPageActivity(), a.d.sdk_ds30));
                                b.this.hyd.setNeedAlphaShade(true);
                            }
                        } else if (b.this.hys) {
                            b.this.hys = false;
                            b.this.hyd.setNeedAlphaShade(false);
                        }
                    }
                }
            });
            this.hyg = (TextView) this.hyc.findViewById(a.f.tv_all_scene);
            this.hyg.setOnClickListener(this);
        }
    }

    private void cdM() {
        if (this.hyn == null) {
            this.hyn = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_exclusive_scene_land_top_view, (ViewGroup) null);
            this.hyp = (HeadImageView) this.hyn.findViewById(a.f.iv_land_scene_avatar);
            this.hyp.setScaleType(ImageView.ScaleType.FIT_XY);
            this.hyp.setDefaultBgResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hyp.setDefaultErrorResource(a.e.sdk_pic_mycenter_avatar_def);
            this.hyo = (TextView) this.hyn.findViewById(a.f.tv_land_scene_name);
            this.hyq = (ViewGroup) this.hyn.findViewById(a.f.ll_land_content_container);
            this.hyq.setOnClickListener(this);
        }
    }

    private void a(boolean z, View view) {
        if (cdN() && this.bvR && view != null && view.getVisibility() == 0) {
            c.a(this.mTbPageContext.getPageActivity(), view, z, this.hyi.AK(), this.hyi.AJ(), true);
        }
    }

    private boolean cdN() {
        return this.hyi != null && this.hyi.AH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(List<aj> list) {
        if (this.hye != null) {
            this.hye.setDatas(list);
        }
    }

    public void K(x xVar) {
        if (xVar != null) {
            this.hyu = xVar.mLiveInfo;
            if (xVar.aGA != null) {
                if (this.hyi == null) {
                    this.hyi = xVar.aGA;
                } else if (!b(xVar.aGA) || !a(xVar.aGA) || !this.bvR) {
                    if (!b(xVar.aGA) && a(xVar.aGA) && this.bvR) {
                        afh();
                        this.hyi = xVar.aGA;
                    } else {
                        this.hyi = xVar.aGA;
                    }
                } else {
                    return;
                }
                cdP();
            }
        }
    }

    public void I(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "multi_session".equals(jSONObject.optString("content_type"))) {
                    dX(jSONObject);
                }
            } catch (JSONException e) {
            }
        }
    }

    public void cdO() {
        hideLoadingView();
    }

    public void onStart() {
        if (this.bon != null) {
            String videoPath = this.bon.getVideoPath();
            if (!TextUtils.isEmpty(videoPath) && !videoPath.equals(this.hyt) && this.hyl != null && this.hyl.url != null) {
                this.currentIndex = -1;
                cdV();
                a(this.hyl, true);
                He(videoPath);
            }
        }
    }

    public void cF(int i) {
        if (cdN() && this.bvR) {
            if (i == 1) {
                cdY();
                vm(i);
                cdV();
            } else if (i == 2) {
                cdW();
            }
            if (this.hym != null) {
                this.hym.co(i);
            }
        }
    }

    public void xk() {
        this.hyl.url = null;
        if (this.hyu != null) {
            this.hyu.playUrl = null;
        }
        afh();
    }

    private void dX(JSONObject jSONObject) {
        v z = v.z(jSONObject.optJSONObject("multi_session"));
        if (z != null) {
            if (this.hyi == null) {
                this.hyi = z;
            } else if (!b(z) || !a(z) || !this.bvR) {
                if (!b(z) && a(z) && this.bvR) {
                    afh();
                    this.hyi = z;
                } else {
                    this.hyi = z;
                }
            } else {
                return;
            }
            if (this.hyi != null) {
                cdP();
            }
        }
    }

    private void cdP() {
        String action = this.hyi.getAction();
        if (TextUtils.equals("1", action)) {
            if (cdN()) {
                afg();
            }
        } else if (TextUtils.equals("2", action)) {
            afh();
        }
    }

    private void afg() {
        if (!this.bvR) {
            cdU();
            this.bvR = true;
            cdQ();
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2
                @Override // java.lang.Runnable
                public void run() {
                    int realScreenOrientation = UtilHelper.getRealScreenOrientation(b.this.mTbPageContext.getPageActivity());
                    b.this.cdS();
                    if (!TextUtils.isEmpty(b.this.hyi.AL())) {
                        b.this.hyh.setText(b.this.hyi.AL());
                    }
                    b.this.cK(b.this.hyi.AI());
                    b.this.cF(realScreenOrientation);
                    b.this.ced();
                    b.this.a(b.this.hyl, true);
                    if (b.this.hyk != null) {
                        b.this.hyk.ve(b.this.getHeight());
                    }
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cdZ();
                        }
                    }, 100L);
                    b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.cea();
                        }
                    }, 5000L);
                }
            }, 300L);
        }
    }

    private void cdQ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.getVersion());
        } catch (Exception e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "vision_show").setContentExt(jSONObject));
    }

    private void cdR() {
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

    private void afh() {
        if (this.bvR) {
            this.bvR = false;
            this.currentIndex = -1;
            cdT();
            cdY();
            if (a(this.hyl)) {
                He(this.hyl.url);
            }
            if (this.hyk != null) {
                this.hyk.ve(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdS() {
        if (this.hyc.getParent() != null) {
            ((ViewGroup) this.hyc.getParent()).removeView(this.hyc);
        }
        if (this.hxk != null) {
            this.hxk.addView(this.hyc, (this.hyj != null ? this.hxk.getView().indexOfChild(this.hyj) : -1) + 1, new RelativeLayout.LayoutParams(-1, -2));
        }
    }

    private void cdT() {
        if (this.hyc.getParent() != null) {
            ((ViewGroup) this.hyc.getParent()).removeView(this.hyc);
        }
    }

    private void oa(boolean z) {
        if (this.hyc != null) {
            this.hyc.setVisibility(z ? 0 : 8);
        }
    }

    private boolean a(v vVar) {
        return this.hyi.fb(vVar.getAction());
    }

    private boolean b(v vVar) {
        return this.hyi.fc(vVar.getId());
    }

    private void cdU() {
        if (this.bon != null) {
            this.hyl.url = this.bon.getVideoPath();
            this.hyt = this.hyl.url;
        }
    }

    private void vm(int i) {
        RelativeLayout.LayoutParams layoutParams;
        int bottom;
        if (this.bKE != null && this.mTbPageContext != null && (layoutParams = (RelativeLayout.LayoutParams) this.hyc.getLayoutParams()) != null) {
            if (i != 2) {
                if (this.bKE.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.bKE.getLayoutParams();
                    bottom = layoutParams2.topMargin + layoutParams2.height;
                } else {
                    bottom = this.bKE.getBottom();
                }
                int i2 = 0;
                if (!UtilHelper.canUseStyleImmersiveSticky()) {
                    i2 = UtilHelper.getStatusBarHeight();
                }
                layoutParams.topMargin = ((bottom + i2) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20)) - this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds80);
            }
            this.hyc.setLayoutParams(layoutParams);
            oa(true);
        }
    }

    private void cdV() {
        if (this.currentIndex == -1) {
            a(true, (View) this.hyg);
        }
        if (this.hye != null) {
            this.hye.vk(this.currentIndex);
        }
        if (this.hyd != null && this.currentIndex > 2) {
            this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.exclusive.b.3
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.hyd != null) {
                        b.this.hyd.setSelection(b.this.currentIndex);
                        b.this.hyd.smoothScrollToPosition(b.this.currentIndex);
                    }
                }
            });
        }
    }

    private void cdW() {
        cdX();
    }

    private void cdX() {
        oa(false);
        if (this.hyn != null && this.hpy != null && this.mTbPageContext != null) {
            if (this.hyn.getParent() != null) {
                ((ViewGroup) this.hyn.getParent()).removeView(this.hyn);
            }
            int i = -1;
            if (this.hpy != null) {
                i = this.hpy.indexOfChild(this.hpy.findViewById(a.f.content_layout));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds82));
            layoutParams.gravity = 21;
            layoutParams.rightMargin = (ScreenHelper.getRealScreenWidth(this.mTbPageContext.getPageActivity()) / 4) + BdUtilHelper.getDimens(this.mTbPageContext.getPageActivity(), a.d.sdk_ds26);
            this.hpy.addView(this.hyn, i + 1, layoutParams);
        }
    }

    private void cdY() {
        if (this.hyn != null && this.hyn.getParent() != null) {
            ((ViewGroup) this.hyn.getParent()).removeView(this.hyn);
        }
        if (this.hyr != null && this.hyr.isShowing()) {
            this.hyr.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdZ() {
        if (this.hyf != null && this.hyf.getVisibility() != 0) {
            this.hyf.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cea() {
        if (this.hyf != null && this.hyf.getVisibility() == 0) {
            this.hyf.setVisibility(4);
        }
    }

    public int getHeight() {
        if (this.bvR) {
            return this.mTbPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds104);
        }
        return 0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hyg == view) {
            if (this.hyl != null) {
                d(true, 1, this.hyl.aHp);
                this.currentIndex = -1;
                a(true, (View) this.hyg);
                if (this.hye != null) {
                    this.hye.vk(this.currentIndex);
                }
                a(this.hyl, true);
                if (a(this.hyl)) {
                    He(this.hyl.url);
                }
            }
        } else if (this.hyq == view) {
            cdR();
            ceb();
        }
    }

    private void ceb() {
        cec();
        if (!this.hyr.isShowing()) {
            this.hyr.a(this.hyi, this.currentIndex);
        }
    }

    private void cec() {
        if (this.hyr == null) {
            this.hyr = new d(this.mTbPageContext.getPageActivity());
            this.hyr.a(this);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.a.InterfaceC0662a
    public void a(View view, int i, aj ajVar) {
        this.currentIndex = i;
        d(false, i + 2, ajVar.aHp);
        a(false, (View) this.hyg);
        a(ajVar, false);
        if (a(ajVar)) {
            He(ajVar.url);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.exclusive.f
    public void a(boolean z, View view, int i, aj ajVar) {
        a(z, this.hyg);
        if (z) {
            if (this.hyl != null) {
                this.currentIndex = -1;
                d(false, 1, this.hyl.aHp);
                a(this.hyl, true);
                if (a(this.hyl)) {
                    He(this.hyl.url);
                    return;
                }
                return;
            }
            return;
        }
        this.currentIndex = i;
        d(false, i + 2, ajVar.aHp);
        a(ajVar, false);
        if (a(ajVar)) {
            He(ajVar.url);
        }
    }

    private boolean a(aj ajVar) {
        return (ajVar == null || TextUtils.isEmpty(ajVar.url) || TextUtils.equals(ajVar.url, this.hyt)) ? false : true;
    }

    private void He(String str) {
        if (!TextUtils.isEmpty(str) && this.bon != null && this.hyu != null) {
            cee();
            this.hyt = str;
            this.bon.cD(true);
            this.hyu.playUrl = str;
            this.bon.c(this.hyu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aj ajVar, boolean z) {
        if (ajVar != null) {
            cdM();
            if (z) {
                this.hyp.setVisibility(8);
            } else {
                this.hyp.setVisibility(0);
                this.hyp.startLoad(ajVar.imageUrl, 10, false);
            }
            this.hyo.setText(ajVar.getLabelName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ced() {
        if (this.hyi != null) {
            cdM();
            c.a(this.mTbPageContext.getPageActivity(), this.hyq, true, this.hyi.AK(), this.hyi.AJ(), true);
        }
    }

    private void cee() {
        cef();
        this.hym.show();
    }

    private void hideLoadingView() {
        cef();
        this.hym.dismiss();
    }

    private void cef() {
        if (this.hym == null) {
            this.hym = new h(this.mTbPageContext.getPageActivity(), this.bon.getLivePlayer());
        }
    }
}
