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
import com.baidu.tieba.ala.liveroom.guide.b;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aWK;
    private long createTime;
    private IGuideTab hDU;
    private b hDV;
    private boolean hDW;
    private boolean hDX;
    private String hDY;
    private String hDZ;
    private Map<String, Object> hEa;
    private BdAlertDialog hEb;
    private BdAlertDialog hEc;
    private InterfaceC0666a hEd;
    private int hEe;
    private boolean hEf;
    private b.a hEg;
    private CustomMessageListener hEh;
    private boolean hsr;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0666a {
        void ccv();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hDW = true;
        this.hDX = true;
        this.hDY = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hDZ = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hDY;
        this.hEa = new HashMap();
        this.createTime = 0L;
        this.hEf = false;
        this.hEg = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hDW = z;
                    a.this.hDX = z2;
                    return;
                }
                a.this.hDW = true;
                a.this.hDX = true;
            }
        };
        this.aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.Ar();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_yanzhi_guide_add_btn) {
                    a.this.cfD();
                    a.this.cfF();
                    if (a.this.hEa != null) {
                        a.this.addTab(a.this.hEa);
                        a.this.moveToTab(a.this.hDZ, a.this.hEa);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.f.id_ala_yanzhi_guide_pending_btn) {
                    a.this.cfD();
                    a.this.cfF();
                } else if (view.getId() == a.f.id_ala_signin_guide_jump_btn) {
                    a.this.cfD();
                    a.this.cfF();
                    if (a.this.hEa != null) {
                        a.this.addTab(a.this.hEa);
                        a.this.moveToTab(a.this.hDZ, a.this.hEa);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.f.id_ala_signin_guide_pending_btn) {
                    a.this.cfD();
                    a.this.cfF();
                }
            }
        };
        this.hEh = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hEf) {
                    a.this.hEf = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aWK);
        MessageManager.getInstance().registerListener(this.hEh);
    }

    private void init() {
        if (this.hEa != null) {
            this.hEa.put("id", "112");
            this.hEa.put("name", "颜值");
            this.hEa.put("canDelete", true);
            this.hEa.put("bundleId", "box.rnplugin.feedhn");
            this.hEa.put("moduleName", "FeedTabLive");
        }
        this.hDU = com.baidu.live.f.a.AR().AS();
        this.hDV = new b(this.hEg);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (oo(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cfx() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (cfy()) {
            if (isAddedTab("112")) {
                if (this.hsr) {
                    this.hsr = false;
                    this.hEe = 103;
                    return true;
                } else if (cfz() && !this.hDW && !this.hDX && !cfA()) {
                    this.hEe = 102;
                    return true;
                }
            } else {
                if (!this.hsr) {
                }
                if (!cfA()) {
                    this.hEe = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cfy() {
        return com.baidu.live.ae.a.Qj().buX.aKK;
    }

    private boolean cfz() {
        return com.baidu.live.ae.a.Qj().buX.aKL;
    }

    private boolean cfA() {
        String cfB = cfB();
        return !StringUtils.isNull(cfB) && cfB.equals(com.baidu.live.d.xc().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String cfB() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void cfC() {
        if (this.hEb == null || !this.hEb.isShowing()) {
            if (this.hEb == null) {
                this.hEb = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hEb.setContentViewSize(1);
            this.hEb.setContentView(inflate);
            this.hEb.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hEb.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfD() {
        if (this.hEb != null && this.hEb.isShowing()) {
            this.hEb.dismiss();
        }
        if (this.hEc != null && this.hEc.isShowing()) {
            this.hEc.dismiss();
        }
    }

    private void cfE() {
        if (this.hEc == null || !this.hEc.isShowing()) {
            if (this.hEc == null) {
                this.hEc = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hEc.setContentViewSize(1);
            this.hEc.setContentView(inflate);
            this.hEc.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hEc.show();
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
        if (this.hDU != null) {
            this.hDU.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hDU == null) {
            return true;
        }
        return this.hDU.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hDU != null) {
            this.hDU.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hDV != null) {
            this.hDV.cfI();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        super.Ar();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cfD();
        this.hEf = false;
        if (this.hDV != null) {
            this.hDV.onDestroy();
        }
        if (this.aWK != null) {
            MessageManager.getInstance().unRegisterListener(this.aWK);
        }
        if (this.hEh != null) {
            MessageManager.getInstance().unRegisterListener(this.hEh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfF() {
        if (this.hEd != null) {
            this.hEd.ccv();
        }
    }

    public void a(InterfaceC0666a interfaceC0666a) {
        this.hEd = interfaceC0666a;
    }

    public void cfG() {
        if (this.hEe == 101) {
            cfC();
            com.baidu.live.d.xc().putString("ala_jump_bd_yanzhi_channel_time", cfB());
        } else if (this.hEe == 102) {
            cfE();
            com.baidu.live.d.xc().putString("ala_jump_bd_yanzhi_channel_time", cfB());
        } else if (this.hEe == 103) {
            cfF();
            if (this.hEa != null) {
                addTab(this.hEa);
                moveToTab(this.hDZ, this.hEa);
            }
        }
    }

    public void nO(boolean z) {
        this.hsr = z;
    }

    private boolean oo(boolean z) {
        return z || this.hEf;
    }
}
