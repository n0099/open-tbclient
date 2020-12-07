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
    private boolean hgH;
    private IGuideTab hsf;
    private b hsg;
    private boolean hsh;
    private boolean hsi;
    private String hsj;
    private String hsk;
    private Map<String, Object> hsl;
    private BdAlertDialog hsm;
    private BdAlertDialog hsn;
    private InterfaceC0689a hso;
    private int hsp;
    private boolean hsq;
    private b.a hsr;
    private CustomMessageListener hss;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0689a {
        void cct();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hsh = true;
        this.hsi = true;
        this.hsj = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hsk = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hsj;
        this.hsl = new HashMap();
        this.createTime = 0L;
        this.hsq = false;
        this.hsr = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hsh = z;
                    a.this.hsi = z2;
                    return;
                }
                a.this.hsh = true;
                a.this.hsi = true;
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
                    a.this.cfD();
                    a.this.cfF();
                    if (a.this.hsl != null) {
                        a.this.addTab(a.this.hsl);
                        a.this.moveToTab(a.this.hsk, a.this.hsl);
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
                    if (a.this.hsl != null) {
                        a.this.addTab(a.this.hsl);
                        a.this.moveToTab(a.this.hsk, a.this.hsl);
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
        this.hss = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hsq) {
                    a.this.hsq = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aWM);
        MessageManager.getInstance().registerListener(this.hss);
    }

    private void init() {
        if (this.hsl != null) {
            this.hsl.put("id", "112");
            this.hsl.put("name", "颜值");
            this.hsl.put("canDelete", true);
            this.hsl.put("bundleId", "box.rnplugin.feedhn");
            this.hsl.put("moduleName", "FeedTabLive");
        }
        this.hsf = com.baidu.live.g.a.EN().EO();
        this.hsg = new b(this.hsr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (nI(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
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
                if (this.hgH) {
                    this.hgH = false;
                    this.hsp = 103;
                    return true;
                } else if (cfz() && !this.hsh && !this.hsi && !cfA()) {
                    this.hsp = 102;
                    return true;
                }
            } else {
                if (!this.hgH) {
                }
                if (!cfA()) {
                    this.hsp = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cfy() {
        return com.baidu.live.ae.a.RB().brA.aMo;
    }

    private boolean cfz() {
        return com.baidu.live.ae.a.RB().brA.aMp;
    }

    private boolean cfA() {
        String cfB = cfB();
        return !StringUtils.isNull(cfB) && cfB.equals(com.baidu.live.d.BM().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String cfB() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void cfC() {
        if (this.hsm == null || !this.hsm.isShowing()) {
            if (this.hsm == null) {
                this.hsm = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hsm.setContentViewSize(1);
            this.hsm.setContentView(inflate);
            this.hsm.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hsm.show();
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
        if (this.hsm != null && this.hsm.isShowing()) {
            this.hsm.dismiss();
        }
        if (this.hsn != null && this.hsn.isShowing()) {
            this.hsn.dismiss();
        }
    }

    private void cfE() {
        if (this.hsn == null || !this.hsn.isShowing()) {
            if (this.hsn == null) {
                this.hsn = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hsn.setContentViewSize(1);
            this.hsn.setContentView(inflate);
            this.hsn.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hsn.show();
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
        if (this.hsf != null) {
            this.hsf.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hsf == null) {
            return true;
        }
        return this.hsf.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hsf != null) {
            this.hsf.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hsg != null) {
            this.hsg.cfI();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void En() {
        super.En();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cfD();
        this.hsq = false;
        if (this.hsg != null) {
            this.hsg.onDestroy();
        }
        if (this.aWM != null) {
            MessageManager.getInstance().unRegisterListener(this.aWM);
        }
        if (this.hss != null) {
            MessageManager.getInstance().unRegisterListener(this.hss);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfF() {
        if (this.hso != null) {
            this.hso.cct();
        }
    }

    public void a(InterfaceC0689a interfaceC0689a) {
        this.hso = interfaceC0689a;
    }

    public void cfG() {
        if (this.hsp == 101) {
            cfC();
            com.baidu.live.d.BM().putString("ala_jump_bd_yanzhi_channel_time", cfB());
        } else if (this.hsp == 102) {
            cfE();
            com.baidu.live.d.BM().putString("ala_jump_bd_yanzhi_channel_time", cfB());
        } else if (this.hsp == 103) {
            cfF();
            if (this.hsl != null) {
                addTab(this.hsl);
                moveToTab(this.hsk, this.hsl);
            }
        }
    }

    public void nh(boolean z) {
        this.hgH = z;
    }

    private boolean nI(boolean z) {
        return z || this.hsq;
    }
}
