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
    private boolean eSF;
    private IGuideTab fcd;
    private b fce;
    private boolean fcf;
    private boolean fcg;
    private String fch;
    private String fci;
    private Map<String, Object> fcj;
    private BdAlertDialog fck;
    private BdAlertDialog fcl;
    private InterfaceC0459a fcm;
    private int fcn;
    private boolean fco;
    private b.a fcp;
    private CustomMessageListener fcq;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0459a {
        void bjY();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fcf = true;
        this.fcg = true;
        this.fch = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fci = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fch;
        this.fcj = new HashMap();
        this.createTime = 0L;
        this.fco = false;
        this.fcp = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fcf = z;
                    a.this.fcg = z2;
                    return;
                }
                a.this.fcf = true;
                a.this.fcg = true;
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
                    a.this.bmo();
                    a.this.bmq();
                    if (a.this.fcj != null) {
                        a.this.addTab(a.this.fcj);
                        a.this.moveToTab(a.this.fci, a.this.fcj);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bmo();
                    a.this.bmq();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bmo();
                    a.this.bmq();
                    if (a.this.fcj != null) {
                        a.this.addTab(a.this.fcj);
                        a.this.moveToTab(a.this.fci, a.this.fcj);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bmo();
                    a.this.bmq();
                }
            }
        };
        this.fcq = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fco) {
                    a.this.fco = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.agU);
        MessageManager.getInstance().registerListener(this.fcq);
    }

    private void init() {
        if (this.fcj != null) {
            this.fcj.put("id", "112");
            this.fcj.put("name", "颜值");
            this.fcj.put("canDelete", true);
            this.fcj.put("bundleId", "box.rnplugin.feedhn");
            this.fcj.put("moduleName", "FeedTabLive");
        }
        this.fcd = com.baidu.live.e.a.qk().ql();
        this.fce = new b(this.fcp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (jq(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bmi() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bmj()) {
            if (isAddedTab("112")) {
                if (this.eSF) {
                    this.eSF = false;
                    this.fcn = 103;
                    return true;
                } else if (bmk() && !this.fcf && !this.fcg && !bml()) {
                    this.fcn = 102;
                    return true;
                }
            } else {
                if (!this.eSF) {
                }
                if (!bml()) {
                    this.fcn = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bmj() {
        return com.baidu.live.v.a.zl().awC.Za;
    }

    private boolean bmk() {
        return com.baidu.live.v.a.zl().awC.Zb;
    }

    private boolean bml() {
        String bmm = bmm();
        return !StringUtils.isNull(bmm) && bmm.equals(com.baidu.live.c.pr().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bmm() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void bmn() {
        if (this.fck == null || !this.fck.isShowing()) {
            if (this.fck == null) {
                this.fck = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fck.setContentViewSize(1);
            this.fck.setContentView(inflate);
            this.fck.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fck.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmo() {
        if (this.fck != null && this.fck.isShowing()) {
            this.fck.dismiss();
        }
        if (this.fcl != null && this.fcl.isShowing()) {
            this.fcl.dismiss();
        }
    }

    private void bmp() {
        if (this.fcl == null || !this.fcl.isShowing()) {
            if (this.fcl == null) {
                this.fcl = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fcl.setContentViewSize(1);
            this.fcl.setContentView(inflate);
            this.fcl.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fcl.show();
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
        if (this.fcd != null) {
            this.fcd.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fcd == null) {
            return true;
        }
        return this.fcd.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fcd != null) {
            this.fcd.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void af(ViewGroup viewGroup) {
        super.af(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fce != null) {
            this.fce.bmt();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void pK() {
        super.pK();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bmo();
        this.fco = false;
        if (this.fce != null) {
            this.fce.onDestroy();
        }
        if (this.agU != null) {
            MessageManager.getInstance().unRegisterListener(this.agU);
        }
        if (this.fcq != null) {
            MessageManager.getInstance().unRegisterListener(this.fcq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmq() {
        if (this.fcm != null) {
            this.fcm.bjY();
        }
    }

    public void a(InterfaceC0459a interfaceC0459a) {
        this.fcm = interfaceC0459a;
    }

    public void bmr() {
        if (this.fcn == 101) {
            bmn();
            com.baidu.live.c.pr().putString("ala_jump_bd_yanzhi_channel_time", bmm());
        } else if (this.fcn == 102) {
            bmp();
            com.baidu.live.c.pr().putString("ala_jump_bd_yanzhi_channel_time", bmm());
        } else if (this.fcn == 103) {
            bmq();
            if (this.fcj != null) {
                addTab(this.fcj);
                moveToTab(this.fci, this.fcj);
            }
        }
    }

    public void iU(boolean z) {
        this.eSF = z;
    }

    private boolean jq(boolean z) {
        return z || this.fco;
    }
}
