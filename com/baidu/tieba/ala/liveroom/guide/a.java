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
    CustomMessageListener azu;
    private long createTime;
    private IGuideTab fGK;
    private b fGL;
    private boolean fGM;
    private boolean fGN;
    private String fGO;
    private String fGP;
    private Map<String, Object> fGQ;
    private BdAlertDialog fGR;
    private BdAlertDialog fGS;
    private InterfaceC0494a fGT;
    private int fGU;
    private boolean fGV;
    private b.a fGW;
    private CustomMessageListener fGX;
    private boolean fxx;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0494a {
        void btx();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fGM = true;
        this.fGN = true;
        this.fGO = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fGP = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fGO;
        this.fGQ = new HashMap();
        this.createTime = 0L;
        this.fGV = false;
        this.fGW = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fGM = z;
                    a.this.fGN = z2;
                    return;
                }
                a.this.fGM = true;
                a.this.fGN = true;
            }
        };
        this.azu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ug();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bvK();
                    a.this.bvM();
                    if (a.this.fGQ != null) {
                        a.this.addTab(a.this.fGQ);
                        a.this.moveToTab(a.this.fGP, a.this.fGQ);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bvK();
                    a.this.bvM();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bvK();
                    a.this.bvM();
                    if (a.this.fGQ != null) {
                        a.this.addTab(a.this.fGQ);
                        a.this.moveToTab(a.this.fGP, a.this.fGQ);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bvK();
                    a.this.bvM();
                }
            }
        };
        this.fGX = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fGV) {
                    a.this.fGV = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.azu);
        MessageManager.getInstance().registerListener(this.fGX);
    }

    private void init() {
        if (this.fGQ != null) {
            this.fGQ.put("id", "112");
            this.fGQ.put("name", "颜值");
            this.fGQ.put("canDelete", true);
            this.fGQ.put("bundleId", "box.rnplugin.feedhn");
            this.fGQ.put("moduleName", "FeedTabLive");
        }
        this.fGK = com.baidu.live.e.a.uG().uH();
        this.fGL = new b(this.fGW);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (kt(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bvE() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bvF()) {
            if (isAddedTab("112")) {
                if (this.fxx) {
                    this.fxx = false;
                    this.fGU = 103;
                    return true;
                } else if (bvG() && !this.fGM && !this.fGN && !bvH()) {
                    this.fGU = 102;
                    return true;
                }
            } else {
                if (!this.fxx) {
                }
                if (!bvH()) {
                    this.fGU = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bvF() {
        return com.baidu.live.v.a.Eo().aQp.arz;
    }

    private boolean bvG() {
        return com.baidu.live.v.a.Eo().aQp.arA;
    }

    private boolean bvH() {
        String bvI = bvI();
        return !StringUtils.isNull(bvI) && bvI.equals(com.baidu.live.c.tH().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bvI() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bvJ() {
        if (this.fGR == null || !this.fGR.isShowing()) {
            if (this.fGR == null) {
                this.fGR = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fGR.setContentViewSize(1);
            this.fGR.setContentView(inflate);
            this.fGR.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fGR.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvK() {
        if (this.fGR != null && this.fGR.isShowing()) {
            this.fGR.dismiss();
        }
        if (this.fGS != null && this.fGS.isShowing()) {
            this.fGS.dismiss();
        }
    }

    private void bvL() {
        if (this.fGS == null || !this.fGS.isShowing()) {
            if (this.fGS == null) {
                this.fGS = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fGS.setContentViewSize(1);
            this.fGS.setContentView(inflate);
            this.fGS.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fGS.show();
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
        if (this.fGK != null) {
            this.fGK.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fGK == null) {
            return true;
        }
        return this.fGK.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fGK != null) {
            this.fGK.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ah(ViewGroup viewGroup) {
        super.ah(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fGL != null) {
            this.fGL.bvP();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ug() {
        super.ug();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bvK();
        this.fGV = false;
        if (this.fGL != null) {
            this.fGL.onDestroy();
        }
        if (this.azu != null) {
            MessageManager.getInstance().unRegisterListener(this.azu);
        }
        if (this.fGX != null) {
            MessageManager.getInstance().unRegisterListener(this.fGX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvM() {
        if (this.fGT != null) {
            this.fGT.btx();
        }
    }

    public void a(InterfaceC0494a interfaceC0494a) {
        this.fGT = interfaceC0494a;
    }

    public void bvN() {
        if (this.fGU == 101) {
            bvJ();
            com.baidu.live.c.tH().putString("ala_jump_bd_yanzhi_channel_time", bvI());
        } else if (this.fGU == 102) {
            bvL();
            com.baidu.live.c.tH().putString("ala_jump_bd_yanzhi_channel_time", bvI());
        } else if (this.fGU == 103) {
            bvM();
            if (this.fGQ != null) {
                addTab(this.fGQ);
                moveToTab(this.fGP, this.fGQ);
            }
        }
    }

    public void jX(boolean z) {
        this.fxx = z;
    }

    private boolean kt(boolean z) {
        return z || this.fGV;
    }
}
