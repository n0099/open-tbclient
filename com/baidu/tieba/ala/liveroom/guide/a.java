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
import com.baidu.tieba.ala.liveroom.guide.b;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener ahe;
    private long createTime;
    private boolean eTd;
    private IGuideTab fcB;
    private b fcC;
    private boolean fcD;
    private boolean fcE;
    private String fcF;
    private String fcG;
    private Map<String, Object> fcH;
    private BdAlertDialog fcI;
    private BdAlertDialog fcJ;
    private InterfaceC0459a fcK;
    private int fcL;
    private boolean fcM;
    private b.a fcN;
    private CustomMessageListener fcO;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0459a {
        void bkd();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fcD = true;
        this.fcE = true;
        this.fcF = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fcG = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fcF;
        this.fcH = new HashMap();
        this.createTime = 0L;
        this.fcM = false;
        this.fcN = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fcD = z;
                    a.this.fcE = z2;
                    return;
                }
                a.this.fcD = true;
                a.this.fcE = true;
            }
        };
        this.ahe = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.pP();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bmt();
                    a.this.bmv();
                    if (a.this.fcH != null) {
                        a.this.addTab(a.this.fcH);
                        a.this.moveToTab(a.this.fcG, a.this.fcH);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bmt();
                    a.this.bmv();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bmt();
                    a.this.bmv();
                    if (a.this.fcH != null) {
                        a.this.addTab(a.this.fcH);
                        a.this.moveToTab(a.this.fcG, a.this.fcH);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bmt();
                    a.this.bmv();
                }
            }
        };
        this.fcO = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fcM) {
                    a.this.fcM = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.ahe);
        MessageManager.getInstance().registerListener(this.fcO);
    }

    private void init() {
        if (this.fcH != null) {
            this.fcH.put("id", "112");
            this.fcH.put("name", "颜值");
            this.fcH.put("canDelete", true);
            this.fcH.put("bundleId", "box.rnplugin.feedhn");
            this.fcH.put("moduleName", "FeedTabLive");
        }
        this.fcB = com.baidu.live.e.a.qp().qq();
        this.fcC = new b(this.fcN);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (js(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bmn() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bmo()) {
            if (isAddedTab("112")) {
                if (this.eTd) {
                    this.eTd = false;
                    this.fcL = 103;
                    return true;
                } else if (bmp() && !this.fcD && !this.fcE && !bmq()) {
                    this.fcL = 102;
                    return true;
                }
            } else {
                if (!this.eTd) {
                }
                if (!bmq()) {
                    this.fcL = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bmo() {
        return com.baidu.live.v.a.zs().awM.Zk;
    }

    private boolean bmp() {
        return com.baidu.live.v.a.zs().awM.Zl;
    }

    private boolean bmq() {
        String bmr = bmr();
        return !StringUtils.isNull(bmr) && bmr.equals(com.baidu.live.c.pw().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bmr() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void bms() {
        if (this.fcI == null || !this.fcI.isShowing()) {
            if (this.fcI == null) {
                this.fcI = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fcI.setContentViewSize(1);
            this.fcI.setContentView(inflate);
            this.fcI.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fcI.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmt() {
        if (this.fcI != null && this.fcI.isShowing()) {
            this.fcI.dismiss();
        }
        if (this.fcJ != null && this.fcJ.isShowing()) {
            this.fcJ.dismiss();
        }
    }

    private void bmu() {
        if (this.fcJ == null || !this.fcJ.isShowing()) {
            if (this.fcJ == null) {
                this.fcJ = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fcJ.setContentViewSize(1);
            this.fcJ.setContentView(inflate);
            this.fcJ.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fcJ.show();
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
        if (this.fcB != null) {
            this.fcB.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fcB == null) {
            return true;
        }
        return this.fcB.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fcB != null) {
            this.fcB.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ag(ViewGroup viewGroup) {
        super.ag(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fcC != null) {
            this.fcC.bmy();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pP() {
        super.pP();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bmt();
        this.fcM = false;
        if (this.fcC != null) {
            this.fcC.onDestroy();
        }
        if (this.ahe != null) {
            MessageManager.getInstance().unRegisterListener(this.ahe);
        }
        if (this.fcO != null) {
            MessageManager.getInstance().unRegisterListener(this.fcO);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmv() {
        if (this.fcK != null) {
            this.fcK.bkd();
        }
    }

    public void a(InterfaceC0459a interfaceC0459a) {
        this.fcK = interfaceC0459a;
    }

    public void bmw() {
        if (this.fcL == 101) {
            bms();
            com.baidu.live.c.pw().putString("ala_jump_bd_yanzhi_channel_time", bmr());
        } else if (this.fcL == 102) {
            bmu();
            com.baidu.live.c.pw().putString("ala_jump_bd_yanzhi_channel_time", bmr());
        } else if (this.fcL == 103) {
            bmv();
            if (this.fcH != null) {
                addTab(this.fcH);
                moveToTab(this.fcG, this.fcH);
            }
        }
    }

    public void iW(boolean z) {
        this.eTd = z;
    }

    private boolean js(boolean z) {
        return z || this.fcM;
    }
}
