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
    private boolean eSr;
    private IGuideTab fbP;
    private b fbQ;
    private boolean fbR;
    private boolean fbS;
    private String fbT;
    private String fbU;
    private Map<String, Object> fbV;
    private BdAlertDialog fbW;
    private BdAlertDialog fbX;
    private InterfaceC0459a fbY;
    private int fbZ;
    private boolean fca;
    private b.a fcb;
    private CustomMessageListener fcc;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0459a {
        void bjV();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fbR = true;
        this.fbS = true;
        this.fbT = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fbU = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fbT;
        this.fbV = new HashMap();
        this.createTime = 0L;
        this.fca = false;
        this.fcb = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fbR = z;
                    a.this.fbS = z2;
                    return;
                }
                a.this.fbR = true;
                a.this.fbS = true;
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
                    a.this.bml();
                    a.this.bmn();
                    if (a.this.fbV != null) {
                        a.this.addTab(a.this.fbV);
                        a.this.moveToTab(a.this.fbU, a.this.fbV);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bml();
                    a.this.bmn();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bml();
                    a.this.bmn();
                    if (a.this.fbV != null) {
                        a.this.addTab(a.this.fbV);
                        a.this.moveToTab(a.this.fbU, a.this.fbV);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bml();
                    a.this.bmn();
                }
            }
        };
        this.fcc = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fca) {
                    a.this.fca = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.agU);
        MessageManager.getInstance().registerListener(this.fcc);
    }

    private void init() {
        if (this.fbV != null) {
            this.fbV.put("id", "112");
            this.fbV.put("name", "颜值");
            this.fbV.put("canDelete", true);
            this.fbV.put("bundleId", "box.rnplugin.feedhn");
            this.fbV.put("moduleName", "FeedTabLive");
        }
        this.fbP = com.baidu.live.e.a.qk().ql();
        this.fbQ = new b(this.fcb);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (jq(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bmf() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bmg()) {
            if (isAddedTab("112")) {
                if (this.eSr) {
                    this.eSr = false;
                    this.fbZ = 103;
                    return true;
                } else if (bmh() && !this.fbR && !this.fbS && !bmi()) {
                    this.fbZ = 102;
                    return true;
                }
            } else {
                if (!this.eSr) {
                }
                if (!bmi()) {
                    this.fbZ = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bmg() {
        return com.baidu.live.v.a.zj().awA.Za;
    }

    private boolean bmh() {
        return com.baidu.live.v.a.zj().awA.Zb;
    }

    private boolean bmi() {
        String bmj = bmj();
        return !StringUtils.isNull(bmj) && bmj.equals(com.baidu.live.c.pr().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bmj() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void bmk() {
        if (this.fbW == null || !this.fbW.isShowing()) {
            if (this.fbW == null) {
                this.fbW = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fbW.setContentViewSize(1);
            this.fbW.setContentView(inflate);
            this.fbW.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fbW.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bml() {
        if (this.fbW != null && this.fbW.isShowing()) {
            this.fbW.dismiss();
        }
        if (this.fbX != null && this.fbX.isShowing()) {
            this.fbX.dismiss();
        }
    }

    private void bmm() {
        if (this.fbX == null || !this.fbX.isShowing()) {
            if (this.fbX == null) {
                this.fbX = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fbX.setContentViewSize(1);
            this.fbX.setContentView(inflate);
            this.fbX.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fbX.show();
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
        if (this.fbP != null) {
            this.fbP.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fbP == null) {
            return true;
        }
        return this.fbP.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fbP != null) {
            this.fbP.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void af(ViewGroup viewGroup) {
        super.af(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fbQ != null) {
            this.fbQ.bmq();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bml();
        this.fca = false;
        if (this.fbQ != null) {
            this.fbQ.onDestroy();
        }
        if (this.agU != null) {
            MessageManager.getInstance().unRegisterListener(this.agU);
        }
        if (this.fcc != null) {
            MessageManager.getInstance().unRegisterListener(this.fcc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmn() {
        if (this.fbY != null) {
            this.fbY.bjV();
        }
    }

    public void a(InterfaceC0459a interfaceC0459a) {
        this.fbY = interfaceC0459a;
    }

    public void bmo() {
        if (this.fbZ == 101) {
            bmk();
            com.baidu.live.c.pr().putString("ala_jump_bd_yanzhi_channel_time", bmj());
        } else if (this.fbZ == 102) {
            bmm();
            com.baidu.live.c.pr().putString("ala_jump_bd_yanzhi_channel_time", bmj());
        } else if (this.fbZ == 103) {
            bmn();
            if (this.fbV != null) {
                addTab(this.fbV);
                moveToTab(this.fbU, this.fbV);
            }
        }
    }

    public void iU(boolean z) {
        this.eSr = z;
    }

    private boolean jq(boolean z) {
        return z || this.fca;
    }
}
