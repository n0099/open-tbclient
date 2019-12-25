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
import com.baidu.live.q.a;
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
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener anV;
    private long createTime;
    private boolean eMW;
    private IGuideTab eWc;
    private b eWd;
    private boolean eWe;
    private boolean eWf;
    private String eWg;
    private String eWh;
    private Map<String, Object> eWi;
    private BdAlertDialog eWj;
    private BdAlertDialog eWk;
    private InterfaceC0445a eWl;
    private int eWm;
    private boolean eWn;
    private b.a eWo;
    private CustomMessageListener eWp;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0445a {
        void bhl();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.eWe = true;
        this.eWf = true;
        this.eWg = URLEncoder.encode("{\"channel\":\"112\"}");
        this.eWh = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.eWg;
        this.eWi = new HashMap();
        this.createTime = 0L;
        this.eWn = false;
        this.eWo = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.eWe = z;
                    a.this.eWf = z2;
                    return;
                }
                a.this.eWe = true;
                a.this.eWf = true;
            }
        };
        this.anV = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.oS();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bjF();
                    a.this.bjH();
                    if (a.this.eWi != null) {
                        a.this.addTab(a.this.eWi);
                        a.this.moveToTab(a.this.eWh, a.this.eWi);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bjF();
                    a.this.bjH();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bjF();
                    a.this.bjH();
                    if (a.this.eWi != null) {
                        a.this.addTab(a.this.eWi);
                        a.this.moveToTab(a.this.eWh, a.this.eWi);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bjF();
                    a.this.bjH();
                }
            }
        };
        this.eWp = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.eWn) {
                    a.this.eWn = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.anV);
        MessageManager.getInstance().registerListener(this.eWp);
    }

    private void init() {
        if (this.eWi != null) {
            this.eWi.put("id", "112");
            this.eWi.put("name", "颜值");
            this.eWi.put("canDelete", true);
            this.eWi.put("bundleId", "box.rnplugin.feedhn");
            this.eWi.put("moduleName", "FeedTabLive");
        }
        this.eWc = com.baidu.live.e.a.pv().pw();
        this.eWd = new b(this.eWo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (jd(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bjz() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bjA()) {
            if (isAddedTab("112")) {
                if (this.eMW) {
                    this.eMW = false;
                    this.eWm = 103;
                    return true;
                } else if (bjB() && !this.eWe && !this.eWf && !bjC()) {
                    this.eWm = 102;
                    return true;
                }
            } else {
                if (!this.eMW) {
                }
                if (!bjC()) {
                    this.eWm = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bjA() {
        return com.baidu.live.r.a.wA().arE.WV;
    }

    private boolean bjB() {
        return com.baidu.live.r.a.wA().arE.WW;
    }

    private boolean bjC() {
        String bjD = bjD();
        return !StringUtils.isNull(bjD) && bjD.equals(com.baidu.live.c.oI().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bjD() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void bjE() {
        if (this.eWj == null || !this.eWj.isShowing()) {
            if (this.eWj == null) {
                this.eWj = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.eWj.setContentViewSize(1);
            this.eWj.setContentView(inflate);
            this.eWj.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.eWj.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjF() {
        if (this.eWj != null && this.eWj.isShowing()) {
            this.eWj.dismiss();
        }
        if (this.eWk != null && this.eWk.isShowing()) {
            this.eWk.dismiss();
        }
    }

    private void bjG() {
        if (this.eWk == null || !this.eWk.isShowing()) {
            if (this.eWk == null) {
                this.eWk = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.eWk.setContentViewSize(1);
            this.eWk.setContentView(inflate);
            this.eWk.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.eWk.show();
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
        if (this.eWc != null) {
            this.eWc.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.eWc == null) {
            return true;
        }
        return this.eWc.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.eWc != null) {
            this.eWc.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Z(ViewGroup viewGroup) {
        super.Z(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.eWd != null) {
            this.eWd.bjK();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oS() {
        super.oS();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bjF();
        this.eWn = false;
        if (this.eWd != null) {
            this.eWd.onDestroy();
        }
        if (this.anV != null) {
            MessageManager.getInstance().unRegisterListener(this.anV);
        }
        if (this.eWp != null) {
            MessageManager.getInstance().unRegisterListener(this.eWp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjH() {
        if (this.eWl != null) {
            this.eWl.bhl();
        }
    }

    public void a(InterfaceC0445a interfaceC0445a) {
        this.eWl = interfaceC0445a;
    }

    public void bjI() {
        if (this.eWm == 101) {
            bjE();
            com.baidu.live.c.oI().putString("ala_jump_bd_yanzhi_channel_time", bjD());
        } else if (this.eWm == 102) {
            bjG();
            com.baidu.live.c.oI().putString("ala_jump_bd_yanzhi_channel_time", bjD());
        } else if (this.eWm == 103) {
            bjH();
            if (this.eWi != null) {
                addTab(this.eWi);
                moveToTab(this.eWh, this.eWi);
            }
        }
    }

    public void iE(boolean z) {
        this.eMW = z;
    }

    private boolean jd(boolean z) {
        return z || this.eWn;
    }
}
