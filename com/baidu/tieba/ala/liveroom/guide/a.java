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
    private IGuideTab hDG;
    private b hDH;
    private boolean hDI;
    private boolean hDJ;
    private String hDK;
    private String hDL;
    private Map<String, Object> hDM;
    private BdAlertDialog hDN;
    private BdAlertDialog hDO;
    private InterfaceC0665a hDP;
    private int hDQ;
    private boolean hDR;
    private b.a hDS;
    private CustomMessageListener hDT;
    private boolean hsd;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0665a {
        void cco();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hDI = true;
        this.hDJ = true;
        this.hDK = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hDL = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hDK;
        this.hDM = new HashMap();
        this.createTime = 0L;
        this.hDR = false;
        this.hDS = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hDI = z;
                    a.this.hDJ = z2;
                    return;
                }
                a.this.hDI = true;
                a.this.hDJ = true;
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
                    a.this.cfw();
                    a.this.cfy();
                    if (a.this.hDM != null) {
                        a.this.addTab(a.this.hDM);
                        a.this.moveToTab(a.this.hDL, a.this.hDM);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.f.id_ala_yanzhi_guide_pending_btn) {
                    a.this.cfw();
                    a.this.cfy();
                } else if (view.getId() == a.f.id_ala_signin_guide_jump_btn) {
                    a.this.cfw();
                    a.this.cfy();
                    if (a.this.hDM != null) {
                        a.this.addTab(a.this.hDM);
                        a.this.moveToTab(a.this.hDL, a.this.hDM);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.f.id_ala_signin_guide_pending_btn) {
                    a.this.cfw();
                    a.this.cfy();
                }
            }
        };
        this.hDT = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hDR) {
                    a.this.hDR = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aWK);
        MessageManager.getInstance().registerListener(this.hDT);
    }

    private void init() {
        if (this.hDM != null) {
            this.hDM.put("id", "112");
            this.hDM.put("name", "颜值");
            this.hDM.put("canDelete", true);
            this.hDM.put("bundleId", "box.rnplugin.feedhn");
            this.hDM.put("moduleName", "FeedTabLive");
        }
        this.hDG = com.baidu.live.f.a.AR().AS();
        this.hDH = new b(this.hDS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (oo(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cfq() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (cfr()) {
            if (isAddedTab("112")) {
                if (this.hsd) {
                    this.hsd = false;
                    this.hDQ = 103;
                    return true;
                } else if (cfs() && !this.hDI && !this.hDJ && !cft()) {
                    this.hDQ = 102;
                    return true;
                }
            } else {
                if (!this.hsd) {
                }
                if (!cft()) {
                    this.hDQ = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cfr() {
        return com.baidu.live.ae.a.Qj().buX.aKK;
    }

    private boolean cfs() {
        return com.baidu.live.ae.a.Qj().buX.aKL;
    }

    private boolean cft() {
        String cfu = cfu();
        return !StringUtils.isNull(cfu) && cfu.equals(com.baidu.live.d.xc().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String cfu() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void cfv() {
        if (this.hDN == null || !this.hDN.isShowing()) {
            if (this.hDN == null) {
                this.hDN = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hDN.setContentViewSize(1);
            this.hDN.setContentView(inflate);
            this.hDN.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hDN.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfw() {
        if (this.hDN != null && this.hDN.isShowing()) {
            this.hDN.dismiss();
        }
        if (this.hDO != null && this.hDO.isShowing()) {
            this.hDO.dismiss();
        }
    }

    private void cfx() {
        if (this.hDO == null || !this.hDO.isShowing()) {
            if (this.hDO == null) {
                this.hDO = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hDO.setContentViewSize(1);
            this.hDO.setContentView(inflate);
            this.hDO.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hDO.show();
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
        if (this.hDG != null) {
            this.hDG.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hDG == null) {
            return true;
        }
        return this.hDG.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hDG != null) {
            this.hDG.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hDH != null) {
            this.hDH.cfB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Ar() {
        super.Ar();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cfw();
        this.hDR = false;
        if (this.hDH != null) {
            this.hDH.onDestroy();
        }
        if (this.aWK != null) {
            MessageManager.getInstance().unRegisterListener(this.aWK);
        }
        if (this.hDT != null) {
            MessageManager.getInstance().unRegisterListener(this.hDT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfy() {
        if (this.hDP != null) {
            this.hDP.cco();
        }
    }

    public void a(InterfaceC0665a interfaceC0665a) {
        this.hDP = interfaceC0665a;
    }

    public void cfz() {
        if (this.hDQ == 101) {
            cfv();
            com.baidu.live.d.xc().putString("ala_jump_bd_yanzhi_channel_time", cfu());
        } else if (this.hDQ == 102) {
            cfx();
            com.baidu.live.d.xc().putString("ala_jump_bd_yanzhi_channel_time", cfu());
        } else if (this.hDQ == 103) {
            cfy();
            if (this.hDM != null) {
                addTab(this.hDM);
                moveToTab(this.hDL, this.hDM);
            }
        }
    }

    public void nO(boolean z) {
        this.hsd = z;
    }

    private boolean oo(boolean z) {
        return z || this.hDR;
    }
}
