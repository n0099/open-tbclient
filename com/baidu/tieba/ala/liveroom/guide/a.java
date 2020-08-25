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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aNU;
    private long createTime;
    private boolean gnU;
    private IGuideTab gzG;
    private b gzH;
    private boolean gzI;
    private boolean gzJ;
    private String gzK;
    private String gzL;
    private Map<String, Object> gzM;
    private BdAlertDialog gzN;
    private BdAlertDialog gzO;
    private InterfaceC0631a gzP;
    private int gzQ;
    private boolean gzR;
    private b.a gzS;
    private CustomMessageListener gzT;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0631a {
        void bPa();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.gzI = true;
        this.gzJ = true;
        this.gzK = URLEncoder.encode("{\"channel\":\"112\"}");
        this.gzL = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.gzK;
        this.gzM = new HashMap();
        this.createTime = 0L;
        this.gzR = false;
        this.gzS = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.gzI = z;
                    a.this.gzJ = z2;
                    return;
                }
                a.this.gzI = true;
                a.this.gzJ = true;
            }
        };
        this.aNU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.BB();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bSa();
                    a.this.bSc();
                    if (a.this.gzM != null) {
                        a.this.addTab(a.this.gzM);
                        a.this.moveToTab(a.this.gzL, a.this.gzM);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bSa();
                    a.this.bSc();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bSa();
                    a.this.bSc();
                    if (a.this.gzM != null) {
                        a.this.addTab(a.this.gzM);
                        a.this.moveToTab(a.this.gzL, a.this.gzM);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bSa();
                    a.this.bSc();
                }
            }
        };
        this.gzT = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.gzR) {
                    a.this.gzR = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aNU);
        MessageManager.getInstance().registerListener(this.gzT);
    }

    private void init() {
        if (this.gzM != null) {
            this.gzM.put("id", "112");
            this.gzM.put("name", "颜值");
            this.gzM.put("canDelete", true);
            this.gzM.put("bundleId", "box.rnplugin.feedhn");
            this.gzM.put("moduleName", "FeedTabLive");
        }
        this.gzG = com.baidu.live.e.a.Ca().Cb();
        this.gzH = new b(this.gzS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (mg(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bRU() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bRV()) {
            if (isAddedTab("112")) {
                if (this.gnU) {
                    this.gnU = false;
                    this.gzQ = 103;
                    return true;
                } else if (bRW() && !this.gzI && !this.gzJ && !bRX()) {
                    this.gzQ = 102;
                    return true;
                }
            } else {
                if (!this.gnU) {
                }
                if (!bRX()) {
                    this.gzQ = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bRV() {
        return com.baidu.live.w.a.Nk().beH.aFj;
    }

    private boolean bRW() {
        return com.baidu.live.w.a.Nk().beH.aFk;
    }

    private boolean bRX() {
        String bRY = bRY();
        return !StringUtils.isNull(bRY) && bRY.equals(com.baidu.live.c.AD().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bRY() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bRZ() {
        if (this.gzN == null || !this.gzN.isShowing()) {
            if (this.gzN == null) {
                this.gzN = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.gzN.setContentViewSize(1);
            this.gzN.setContentView(inflate);
            this.gzN.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gzN.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSa() {
        if (this.gzN != null && this.gzN.isShowing()) {
            this.gzN.dismiss();
        }
        if (this.gzO != null && this.gzO.isShowing()) {
            this.gzO.dismiss();
        }
    }

    private void bSb() {
        if (this.gzO == null || !this.gzO.isShowing()) {
            if (this.gzO == null) {
                this.gzO = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.gzO.setContentViewSize(1);
            this.gzO.setContentView(inflate);
            this.gzO.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gzO.show();
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
        if (this.gzG != null) {
            this.gzG.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.gzG == null) {
            return true;
        }
        return this.gzG.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.gzG != null) {
            this.gzG.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        super.as(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.gzH != null) {
            this.gzH.bSf();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bSa();
        this.gzR = false;
        if (this.gzH != null) {
            this.gzH.onDestroy();
        }
        if (this.aNU != null) {
            MessageManager.getInstance().unRegisterListener(this.aNU);
        }
        if (this.gzT != null) {
            MessageManager.getInstance().unRegisterListener(this.gzT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSc() {
        if (this.gzP != null) {
            this.gzP.bPa();
        }
    }

    public void a(InterfaceC0631a interfaceC0631a) {
        this.gzP = interfaceC0631a;
    }

    public void bSd() {
        if (this.gzQ == 101) {
            bRZ();
            com.baidu.live.c.AD().putString("ala_jump_bd_yanzhi_channel_time", bRY());
        } else if (this.gzQ == 102) {
            bSb();
            com.baidu.live.c.AD().putString("ala_jump_bd_yanzhi_channel_time", bRY());
        } else if (this.gzQ == 103) {
            bSc();
            if (this.gzM != null) {
                addTab(this.gzM);
                moveToTab(this.gzL, this.gzM);
            }
        }
    }

    public void lH(boolean z) {
        this.gnU = z;
    }

    private boolean mg(boolean z) {
        return z || this.gzR;
    }
}
