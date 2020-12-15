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
    CustomMessageListener aWM;
    private long createTime;
    private boolean hgJ;
    private IGuideTab hsh;
    private b hsi;
    private boolean hsj;
    private boolean hsk;
    private String hsl;
    private String hsm;
    private Map<String, Object> hsn;
    private BdAlertDialog hso;
    private BdAlertDialog hsp;
    private InterfaceC0689a hsq;
    private int hsr;
    private boolean hss;
    private b.a hst;
    private CustomMessageListener hsu;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0689a {
        void ccu();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hsj = true;
        this.hsk = true;
        this.hsl = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hsm = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hsl;
        this.hsn = new HashMap();
        this.createTime = 0L;
        this.hss = false;
        this.hst = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hsj = z;
                    a.this.hsk = z2;
                    return;
                }
                a.this.hsj = true;
                a.this.hsk = true;
            }
        };
        this.aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.En();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_yanzhi_guide_add_btn) {
                    a.this.cfE();
                    a.this.cfG();
                    if (a.this.hsn != null) {
                        a.this.addTab(a.this.hsn);
                        a.this.moveToTab(a.this.hsm, a.this.hsn);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.f.id_ala_yanzhi_guide_pending_btn) {
                    a.this.cfE();
                    a.this.cfG();
                } else if (view.getId() == a.f.id_ala_signin_guide_jump_btn) {
                    a.this.cfE();
                    a.this.cfG();
                    if (a.this.hsn != null) {
                        a.this.addTab(a.this.hsn);
                        a.this.moveToTab(a.this.hsm, a.this.hsn);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.f.id_ala_signin_guide_pending_btn) {
                    a.this.cfE();
                    a.this.cfG();
                }
            }
        };
        this.hsu = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hss) {
                    a.this.hss = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aWM);
        MessageManager.getInstance().registerListener(this.hsu);
    }

    private void init() {
        if (this.hsn != null) {
            this.hsn.put("id", "112");
            this.hsn.put("name", "颜值");
            this.hsn.put("canDelete", true);
            this.hsn.put("bundleId", "box.rnplugin.feedhn");
            this.hsn.put("moduleName", "FeedTabLive");
        }
        this.hsh = com.baidu.live.g.a.EN().EO();
        this.hsi = new b(this.hst);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (nI(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cfy() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (cfz()) {
            if (isAddedTab("112")) {
                if (this.hgJ) {
                    this.hgJ = false;
                    this.hsr = 103;
                    return true;
                } else if (cfA() && !this.hsj && !this.hsk && !cfB()) {
                    this.hsr = 102;
                    return true;
                }
            } else {
                if (!this.hgJ) {
                }
                if (!cfB()) {
                    this.hsr = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cfz() {
        return com.baidu.live.ae.a.RB().brA.aMo;
    }

    private boolean cfA() {
        return com.baidu.live.ae.a.RB().brA.aMp;
    }

    private boolean cfB() {
        String cfC = cfC();
        return !StringUtils.isNull(cfC) && cfC.equals(com.baidu.live.d.BM().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String cfC() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void cfD() {
        if (this.hso == null || !this.hso.isShowing()) {
            if (this.hso == null) {
                this.hso = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hso.setContentViewSize(1);
            this.hso.setContentView(inflate);
            this.hso.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hso.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfE() {
        if (this.hso != null && this.hso.isShowing()) {
            this.hso.dismiss();
        }
        if (this.hsp != null && this.hsp.isShowing()) {
            this.hsp.dismiss();
        }
    }

    private void cfF() {
        if (this.hsp == null || !this.hsp.isShowing()) {
            if (this.hsp == null) {
                this.hsp = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hsp.setContentViewSize(1);
            this.hsp.setContentView(inflate);
            this.hsp.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hsp.show();
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
        if (this.hsh != null) {
            this.hsh.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hsh == null) {
            return true;
        }
        return this.hsh.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hsh != null) {
            this.hsh.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hsi != null) {
            this.hsi.cfJ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cfE();
        this.hss = false;
        if (this.hsi != null) {
            this.hsi.onDestroy();
        }
        if (this.aWM != null) {
            MessageManager.getInstance().unRegisterListener(this.aWM);
        }
        if (this.hsu != null) {
            MessageManager.getInstance().unRegisterListener(this.hsu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfG() {
        if (this.hsq != null) {
            this.hsq.ccu();
        }
    }

    public void a(InterfaceC0689a interfaceC0689a) {
        this.hsq = interfaceC0689a;
    }

    public void cfH() {
        if (this.hsr == 101) {
            cfD();
            com.baidu.live.d.BM().putString("ala_jump_bd_yanzhi_channel_time", cfC());
        } else if (this.hsr == 102) {
            cfF();
            com.baidu.live.d.BM().putString("ala_jump_bd_yanzhi_channel_time", cfC());
        } else if (this.hsr == 103) {
            cfG();
            if (this.hsn != null) {
                addTab(this.hsn);
                moveToTab(this.hsm, this.hsn);
            }
        }
    }

    public void nh(boolean z) {
        this.hgJ = z;
    }

    private boolean nI(boolean z) {
        return z || this.hss;
    }
}
