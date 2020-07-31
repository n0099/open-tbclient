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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tieba.ala.liveroom.guide.b;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aIJ;
    private long createTime;
    private boolean gbR;
    private IGuideTab gmQ;
    private b gmR;
    private boolean gmS;
    private boolean gmT;
    private String gmU;
    private String gmV;
    private Map<String, Object> gmW;
    private BdAlertDialog gmX;
    private BdAlertDialog gmY;
    private InterfaceC0580a gmZ;
    private int gna;
    private boolean gnb;
    private b.a gnc;
    private CustomMessageListener gnd;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0580a {
        void bFv();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.gmS = true;
        this.gmT = true;
        this.gmU = URLEncoder.encode("{\"channel\":\"112\"}");
        this.gmV = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.gmU;
        this.gmW = new HashMap();
        this.createTime = 0L;
        this.gnb = false;
        this.gnc = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.gmS = z;
                    a.this.gmT = z2;
                    return;
                }
                a.this.gmS = true;
                a.this.gmT = true;
            }
        };
        this.aIJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.wd();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bHZ();
                    a.this.bIb();
                    if (a.this.gmW != null) {
                        a.this.addTab(a.this.gmW);
                        a.this.moveToTab(a.this.gmV, a.this.gmW);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bHZ();
                    a.this.bIb();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bHZ();
                    a.this.bIb();
                    if (a.this.gmW != null) {
                        a.this.addTab(a.this.gmW);
                        a.this.moveToTab(a.this.gmV, a.this.gmW);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bHZ();
                    a.this.bIb();
                }
            }
        };
        this.gnd = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.gnb) {
                    a.this.gnb = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aIJ);
        MessageManager.getInstance().registerListener(this.gnd);
    }

    private void init() {
        if (this.gmW != null) {
            this.gmW.put("id", "112");
            this.gmW.put("name", "颜值");
            this.gmW.put("canDelete", true);
            this.gmW.put("bundleId", "box.rnplugin.feedhn");
            this.gmW.put("moduleName", "FeedTabLive");
        }
        this.gmQ = com.baidu.live.e.a.wC().wD();
        this.gmR = new b(this.gnc);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (lC(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bHT() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bHU()) {
            if (isAddedTab("112")) {
                if (this.gbR) {
                    this.gbR = false;
                    this.gna = 103;
                    return true;
                } else if (bHV() && !this.gmS && !this.gmT && !bHW()) {
                    this.gna = 102;
                    return true;
                }
            } else {
                if (!this.gbR) {
                }
                if (!bHW()) {
                    this.gna = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bHU() {
        return com.baidu.live.v.a.Hs().aZn.azZ;
    }

    private boolean bHV() {
        return com.baidu.live.v.a.Hs().aZn.aAa;
    }

    private boolean bHW() {
        String bHX = bHX();
        return !StringUtils.isNull(bHX) && bHX.equals(com.baidu.live.c.vf().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bHX() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bHY() {
        if (this.gmX == null || !this.gmX.isShowing()) {
            if (this.gmX == null) {
                this.gmX = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.gmX.setContentViewSize(1);
            this.gmX.setContentView(inflate);
            this.gmX.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gmX.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHZ() {
        if (this.gmX != null && this.gmX.isShowing()) {
            this.gmX.dismiss();
        }
        if (this.gmY != null && this.gmY.isShowing()) {
            this.gmY.dismiss();
        }
    }

    private void bIa() {
        if (this.gmY == null || !this.gmY.isShowing()) {
            if (this.gmY == null) {
                this.gmY = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.gmY.setContentViewSize(1);
            this.gmY.setContentView(inflate);
            this.gmY.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gmY.show();
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
        if (this.gmQ != null) {
            this.gmQ.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.gmQ == null) {
            return true;
        }
        return this.gmQ.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.gmQ != null) {
            this.gmQ.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ar(ViewGroup viewGroup) {
        super.ar(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.gmR != null) {
            this.gmR.bIe();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void wd() {
        super.wd();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bHZ();
        this.gnb = false;
        if (this.gmR != null) {
            this.gmR.onDestroy();
        }
        if (this.aIJ != null) {
            MessageManager.getInstance().unRegisterListener(this.aIJ);
        }
        if (this.gnd != null) {
            MessageManager.getInstance().unRegisterListener(this.gnd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIb() {
        if (this.gmZ != null) {
            this.gmZ.bFv();
        }
    }

    public void a(InterfaceC0580a interfaceC0580a) {
        this.gmZ = interfaceC0580a;
    }

    public void bIc() {
        if (this.gna == 101) {
            bHY();
            com.baidu.live.c.vf().putString("ala_jump_bd_yanzhi_channel_time", bHX());
        } else if (this.gna == 102) {
            bIa();
            com.baidu.live.c.vf().putString("ala_jump_bd_yanzhi_channel_time", bHX());
        } else if (this.gna == 103) {
            bIb();
            if (this.gmW != null) {
                addTab(this.gmW);
                moveToTab(this.gmV, this.gmW);
            }
        }
    }

    public void lh(boolean z) {
        this.gbR = z;
    }

    private boolean lC(boolean z) {
        return z || this.gnb;
    }
}
