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
    CustomMessageListener aUb;
    private long createTime;
    private boolean gRr;
    private IGuideTab hdf;
    private b hdg;
    private boolean hdh;
    private boolean hdi;
    private String hdj;
    private String hdk;
    private Map<String, Object> hdl;
    private BdAlertDialog hdm;
    private BdAlertDialog hdn;
    private InterfaceC0661a hdo;
    private int hdp;
    private boolean hdq;
    private b.a hdr;
    private CustomMessageListener hds;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0661a {
        void bWE();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hdh = true;
        this.hdi = true;
        this.hdj = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hdk = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hdj;
        this.hdl = new HashMap();
        this.createTime = 0L;
        this.hdq = false;
        this.hdr = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hdh = z;
                    a.this.hdi = z2;
                    return;
                }
                a.this.hdh = true;
                a.this.hdi = true;
            }
        };
        this.aUb = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.CT();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bZQ();
                    a.this.bZS();
                    if (a.this.hdl != null) {
                        a.this.addTab(a.this.hdl);
                        a.this.moveToTab(a.this.hdk, a.this.hdl);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bZQ();
                    a.this.bZS();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bZQ();
                    a.this.bZS();
                    if (a.this.hdl != null) {
                        a.this.addTab(a.this.hdl);
                        a.this.moveToTab(a.this.hdk, a.this.hdl);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bZQ();
                    a.this.bZS();
                }
            }
        };
        this.hds = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hdq) {
                    a.this.hdq = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aUb);
        MessageManager.getInstance().registerListener(this.hds);
    }

    private void init() {
        if (this.hdl != null) {
            this.hdl.put("id", "112");
            this.hdl.put("name", "颜值");
            this.hdl.put("canDelete", true);
            this.hdl.put("bundleId", "box.rnplugin.feedhn");
            this.hdl.put("moduleName", "FeedTabLive");
        }
        this.hdf = com.baidu.live.e.a.Dt().Du();
        this.hdg = new b(this.hdr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (nd(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bZK() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bZL()) {
            if (isAddedTab("112")) {
                if (this.gRr) {
                    this.gRr = false;
                    this.hdp = 103;
                    return true;
                } else if (bZM() && !this.hdh && !this.hdi && !bZN()) {
                    this.hdp = 102;
                    return true;
                }
            } else {
                if (!this.gRr) {
                }
                if (!bZN()) {
                    this.hdp = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bZL() {
        return com.baidu.live.z.a.Pq().bmJ.aKg;
    }

    private boolean bZM() {
        return com.baidu.live.z.a.Pq().bmJ.aKh;
    }

    private boolean bZN() {
        String bZO = bZO();
        return !StringUtils.isNull(bZO) && bZO.equals(com.baidu.live.d.AZ().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bZO() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bZP() {
        if (this.hdm == null || !this.hdm.isShowing()) {
            if (this.hdm == null) {
                this.hdm = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hdm.setContentViewSize(1);
            this.hdm.setContentView(inflate);
            this.hdm.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hdm.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZQ() {
        if (this.hdm != null && this.hdm.isShowing()) {
            this.hdm.dismiss();
        }
        if (this.hdn != null && this.hdn.isShowing()) {
            this.hdn.dismiss();
        }
    }

    private void bZR() {
        if (this.hdn == null || !this.hdn.isShowing()) {
            if (this.hdn == null) {
                this.hdn = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hdn.setContentViewSize(1);
            this.hdn.setContentView(inflate);
            this.hdn.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hdn.show();
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
        if (this.hdf != null) {
            this.hdf.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hdf == null) {
            return true;
        }
        return this.hdf.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hdf != null) {
            this.hdf.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hdg != null) {
            this.hdg.bZV();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CT() {
        super.CT();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bZQ();
        this.hdq = false;
        if (this.hdg != null) {
            this.hdg.onDestroy();
        }
        if (this.aUb != null) {
            MessageManager.getInstance().unRegisterListener(this.aUb);
        }
        if (this.hds != null) {
            MessageManager.getInstance().unRegisterListener(this.hds);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZS() {
        if (this.hdo != null) {
            this.hdo.bWE();
        }
    }

    public void a(InterfaceC0661a interfaceC0661a) {
        this.hdo = interfaceC0661a;
    }

    public void bZT() {
        if (this.hdp == 101) {
            bZP();
            com.baidu.live.d.AZ().putString("ala_jump_bd_yanzhi_channel_time", bZO());
        } else if (this.hdp == 102) {
            bZR();
            com.baidu.live.d.AZ().putString("ala_jump_bd_yanzhi_channel_time", bZO());
        } else if (this.hdp == 103) {
            bZS();
            if (this.hdl != null) {
                addTab(this.hdl);
                moveToTab(this.hdk, this.hdl);
            }
        }
    }

    public void mD(boolean z) {
        this.gRr = z;
    }

    private boolean nd(boolean z) {
        return z || this.hdq;
    }
}
