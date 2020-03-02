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
    CustomMessageListener agU;
    private long createTime;
    private boolean eSs;
    private IGuideTab fbQ;
    private b fbR;
    private boolean fbS;
    private boolean fbT;
    private String fbU;
    private String fbV;
    private Map<String, Object> fbW;
    private BdAlertDialog fbX;
    private BdAlertDialog fbY;
    private InterfaceC0459a fbZ;
    private int fca;
    private boolean fcb;
    private b.a fcc;
    private CustomMessageListener fcd;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0459a {
        void bjX();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fbS = true;
        this.fbT = true;
        this.fbU = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fbV = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fbU;
        this.fbW = new HashMap();
        this.createTime = 0L;
        this.fcb = false;
        this.fcc = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fbS = z;
                    a.this.fbT = z2;
                    return;
                }
                a.this.fbS = true;
                a.this.fbT = true;
            }
        };
        this.agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.pK();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bmn();
                    a.this.bmp();
                    if (a.this.fbW != null) {
                        a.this.addTab(a.this.fbW);
                        a.this.moveToTab(a.this.fbV, a.this.fbW);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bmn();
                    a.this.bmp();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bmn();
                    a.this.bmp();
                    if (a.this.fbW != null) {
                        a.this.addTab(a.this.fbW);
                        a.this.moveToTab(a.this.fbV, a.this.fbW);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bmn();
                    a.this.bmp();
                }
            }
        };
        this.fcd = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fcb) {
                    a.this.fcb = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.agU);
        MessageManager.getInstance().registerListener(this.fcd);
    }

    private void init() {
        if (this.fbW != null) {
            this.fbW.put("id", "112");
            this.fbW.put("name", "颜值");
            this.fbW.put("canDelete", true);
            this.fbW.put("bundleId", "box.rnplugin.feedhn");
            this.fbW.put("moduleName", "FeedTabLive");
        }
        this.fbQ = com.baidu.live.e.a.qk().ql();
        this.fbR = new b(this.fcc);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (jq(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bmh() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bmi()) {
            if (isAddedTab("112")) {
                if (this.eSs) {
                    this.eSs = false;
                    this.fca = 103;
                    return true;
                } else if (bmj() && !this.fbS && !this.fbT && !bmk()) {
                    this.fca = 102;
                    return true;
                }
            } else {
                if (!this.eSs) {
                }
                if (!bmk()) {
                    this.fca = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bmi() {
        return com.baidu.live.v.a.zl().awB.Za;
    }

    private boolean bmj() {
        return com.baidu.live.v.a.zl().awB.Zb;
    }

    private boolean bmk() {
        String bml = bml();
        return !StringUtils.isNull(bml) && bml.equals(com.baidu.live.c.pr().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bml() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void bmm() {
        if (this.fbX == null || !this.fbX.isShowing()) {
            if (this.fbX == null) {
                this.fbX = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fbX.setContentViewSize(1);
            this.fbX.setContentView(inflate);
            this.fbX.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fbX.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmn() {
        if (this.fbX != null && this.fbX.isShowing()) {
            this.fbX.dismiss();
        }
        if (this.fbY != null && this.fbY.isShowing()) {
            this.fbY.dismiss();
        }
    }

    private void bmo() {
        if (this.fbY == null || !this.fbY.isShowing()) {
            if (this.fbY == null) {
                this.fbY = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fbY.setContentViewSize(1);
            this.fbY.setContentView(inflate);
            this.fbY.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fbY.show();
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
        if (this.fbQ != null) {
            this.fbQ.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fbQ == null) {
            return true;
        }
        return this.fbQ.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fbQ != null) {
            this.fbQ.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void af(ViewGroup viewGroup) {
        super.af(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fbR != null) {
            this.fbR.bms();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bmn();
        this.fcb = false;
        if (this.fbR != null) {
            this.fbR.onDestroy();
        }
        if (this.agU != null) {
            MessageManager.getInstance().unRegisterListener(this.agU);
        }
        if (this.fcd != null) {
            MessageManager.getInstance().unRegisterListener(this.fcd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmp() {
        if (this.fbZ != null) {
            this.fbZ.bjX();
        }
    }

    public void a(InterfaceC0459a interfaceC0459a) {
        this.fbZ = interfaceC0459a;
    }

    public void bmq() {
        if (this.fca == 101) {
            bmm();
            com.baidu.live.c.pr().putString("ala_jump_bd_yanzhi_channel_time", bml());
        } else if (this.fca == 102) {
            bmo();
            com.baidu.live.c.pr().putString("ala_jump_bd_yanzhi_channel_time", bml());
        } else if (this.fca == 103) {
            bmp();
            if (this.fbW != null) {
                addTab(this.fbW);
                moveToTab(this.fbV, this.fbW);
            }
        }
    }

    public void iU(boolean z) {
        this.eSs = z;
    }

    private boolean jq(boolean z) {
        return z || this.fcb;
    }
}
