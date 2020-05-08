package com.baidu.tieba.ala.liveroom.guide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.IGuideTab;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.u.a;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tieba.ala.liveroom.guide.b;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener azA;
    private long createTime;
    private IGuideTab fGP;
    private b fGQ;
    private boolean fGR;
    private boolean fGS;
    private String fGT;
    private String fGU;
    private Map<String, Object> fGV;
    private BdAlertDialog fGW;
    private BdAlertDialog fGX;
    private InterfaceC0515a fGY;
    private int fGZ;
    private boolean fHa;
    private b.a fHb;
    private CustomMessageListener fHc;
    private boolean fxC;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0515a {
        void btv();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fGR = true;
        this.fGS = true;
        this.fGT = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fGU = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fGT;
        this.fGV = new HashMap();
        this.createTime = 0L;
        this.fHa = false;
        this.fHb = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fGR = z;
                    a.this.fGS = z2;
                    return;
                }
                a.this.fGR = true;
                a.this.fGS = true;
            }
        };
        this.azA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.uf();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bvI();
                    a.this.bvK();
                    if (a.this.fGV != null) {
                        a.this.addTab(a.this.fGV);
                        a.this.moveToTab(a.this.fGU, a.this.fGV);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bvI();
                    a.this.bvK();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bvI();
                    a.this.bvK();
                    if (a.this.fGV != null) {
                        a.this.addTab(a.this.fGV);
                        a.this.moveToTab(a.this.fGU, a.this.fGV);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bvI();
                    a.this.bvK();
                }
            }
        };
        this.fHc = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fHa) {
                    a.this.fHa = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.azA);
        MessageManager.getInstance().registerListener(this.fHc);
    }

    private void init() {
        if (this.fGV != null) {
            this.fGV.put("id", "112");
            this.fGV.put("name", "颜值");
            this.fGV.put("canDelete", true);
            this.fGV.put("bundleId", "box.rnplugin.feedhn");
            this.fGV.put("moduleName", "FeedTabLive");
        }
        this.fGP = com.baidu.live.e.a.uF().uG();
        this.fGQ = new b(this.fHb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (kt(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bvC() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bvD()) {
            if (isAddedTab("112")) {
                if (this.fxC) {
                    this.fxC = false;
                    this.fGZ = 103;
                    return true;
                } else if (bvE() && !this.fGR && !this.fGS && !bvF()) {
                    this.fGZ = 102;
                    return true;
                }
            } else {
                if (!this.fxC) {
                }
                if (!bvF()) {
                    this.fGZ = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bvD() {
        return com.baidu.live.v.a.En().aQu.arF;
    }

    private boolean bvE() {
        return com.baidu.live.v.a.En().aQu.arG;
    }

    private boolean bvF() {
        String bvG = bvG();
        return !StringUtils.isNull(bvG) && bvG.equals(com.baidu.live.c.tG().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bvG() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bvH() {
        if (this.fGW == null || !this.fGW.isShowing()) {
            if (this.fGW == null) {
                this.fGW = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fGW.setContentViewSize(1);
            this.fGW.setContentView(inflate);
            this.fGW.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fGW.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvI() {
        if (this.fGW != null && this.fGW.isShowing()) {
            this.fGW.dismiss();
        }
        if (this.fGX != null && this.fGX.isShowing()) {
            this.fGX.dismiss();
        }
    }

    private void bvJ() {
        if (this.fGX == null || !this.fGX.isShowing()) {
            if (this.fGX == null) {
                this.fGX = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fGX.setContentViewSize(1);
            this.fGX.setContentView(inflate);
            this.fGX.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fGX.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addTab(Map map) {
        if (this.fGP != null) {
            this.fGP.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fGP == null) {
            return true;
        }
        return this.fGP.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fGP != null) {
            this.fGP.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ah(ViewGroup viewGroup) {
        super.ah(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fGQ != null) {
            this.fGQ.bvN();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void uf() {
        super.uf();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bvI();
        this.fHa = false;
        if (this.fGQ != null) {
            this.fGQ.onDestroy();
        }
        if (this.azA != null) {
            MessageManager.getInstance().unRegisterListener(this.azA);
        }
        if (this.fHc != null) {
            MessageManager.getInstance().unRegisterListener(this.fHc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvK() {
        if (this.fGY != null) {
            this.fGY.btv();
        }
    }

    public void a(InterfaceC0515a interfaceC0515a) {
        this.fGY = interfaceC0515a;
    }

    public void bvL() {
        if (this.fGZ == 101) {
            bvH();
            com.baidu.live.c.tG().putString("ala_jump_bd_yanzhi_channel_time", bvG());
        } else if (this.fGZ == 102) {
            bvJ();
            com.baidu.live.c.tG().putString("ala_jump_bd_yanzhi_channel_time", bvG());
        } else if (this.fGZ == 103) {
            bvK();
            if (this.fGV != null) {
                addTab(this.fGV);
                moveToTab(this.fGU, this.fGV);
            }
        }
    }

    public void jX(boolean z) {
        this.fxC = z;
    }

    private boolean kt(boolean z) {
        return z || this.fHa;
    }
}
