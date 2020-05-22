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
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import com.baidu.tieba.ala.liveroom.guide.b;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aES;
    private long createTime;
    private boolean fLB;
    private IGuideTab fUK;
    private b fUL;
    private boolean fUM;
    private boolean fUN;
    private String fUO;
    private String fUP;
    private Map<String, Object> fUQ;
    private BdAlertDialog fUR;
    private BdAlertDialog fUS;
    private InterfaceC0562a fUT;
    private int fUU;
    private boolean fUV;
    private b.a fUW;
    private CustomMessageListener fUX;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0562a {
        void bzu();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fUM = true;
        this.fUN = true;
        this.fUO = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fUP = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fUO;
        this.fUQ = new HashMap();
        this.createTime = 0L;
        this.fUV = false;
        this.fUW = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fUM = z;
                    a.this.fUN = z2;
                    return;
                }
                a.this.fUM = true;
                a.this.fUN = true;
            }
        };
        this.aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.vm();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bBH();
                    a.this.bBJ();
                    if (a.this.fUQ != null) {
                        a.this.addTab(a.this.fUQ);
                        a.this.moveToTab(a.this.fUP, a.this.fUQ);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bBH();
                    a.this.bBJ();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bBH();
                    a.this.bBJ();
                    if (a.this.fUQ != null) {
                        a.this.addTab(a.this.fUQ);
                        a.this.moveToTab(a.this.fUP, a.this.fUQ);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bBH();
                    a.this.bBJ();
                }
            }
        };
        this.fUX = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fUV) {
                    a.this.fUV = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aES);
        MessageManager.getInstance().registerListener(this.fUX);
    }

    private void init() {
        if (this.fUQ != null) {
            this.fUQ.put("id", "112");
            this.fUQ.put("name", "颜值");
            this.fUQ.put("canDelete", true);
            this.fUQ.put("bundleId", "box.rnplugin.feedhn");
            this.fUQ.put("moduleName", "FeedTabLive");
        }
        this.fUK = com.baidu.live.e.a.vM().vN();
        this.fUL = new b(this.fUW);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (kO(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bBB() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bBC()) {
            if (isAddedTab("112")) {
                if (this.fLB) {
                    this.fLB = false;
                    this.fUU = 103;
                    return true;
                } else if (bBD() && !this.fUM && !this.fUN && !bBE()) {
                    this.fUU = 102;
                    return true;
                }
            } else {
                if (!this.fLB) {
                }
                if (!bBE()) {
                    this.fUU = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bBC() {
        return com.baidu.live.v.a.Ge().aWF.awE;
    }

    private boolean bBD() {
        return com.baidu.live.v.a.Ge().aWF.awF;
    }

    private boolean bBE() {
        String bBF = bBF();
        return !StringUtils.isNull(bBF) && bBF.equals(com.baidu.live.c.uN().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bBF() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bBG() {
        if (this.fUR == null || !this.fUR.isShowing()) {
            if (this.fUR == null) {
                this.fUR = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fUR.setContentViewSize(1);
            this.fUR.setContentView(inflate);
            this.fUR.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fUR.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBH() {
        if (this.fUR != null && this.fUR.isShowing()) {
            this.fUR.dismiss();
        }
        if (this.fUS != null && this.fUS.isShowing()) {
            this.fUS.dismiss();
        }
    }

    private void bBI() {
        if (this.fUS == null || !this.fUS.isShowing()) {
            if (this.fUS == null) {
                this.fUS = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fUS.setContentViewSize(1);
            this.fUS.setContentView(inflate);
            this.fUS.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fUS.show();
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
        if (this.fUK != null) {
            this.fUK.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fUK == null) {
            return true;
        }
        return this.fUK.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fUK != null) {
            this.fUK.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ao(ViewGroup viewGroup) {
        super.ao(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fUL != null) {
            this.fUL.bBM();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bBH();
        this.fUV = false;
        if (this.fUL != null) {
            this.fUL.onDestroy();
        }
        if (this.aES != null) {
            MessageManager.getInstance().unRegisterListener(this.aES);
        }
        if (this.fUX != null) {
            MessageManager.getInstance().unRegisterListener(this.fUX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBJ() {
        if (this.fUT != null) {
            this.fUT.bzu();
        }
    }

    public void a(InterfaceC0562a interfaceC0562a) {
        this.fUT = interfaceC0562a;
    }

    public void bBK() {
        if (this.fUU == 101) {
            bBG();
            com.baidu.live.c.uN().putString("ala_jump_bd_yanzhi_channel_time", bBF());
        } else if (this.fUU == 102) {
            bBI();
            com.baidu.live.c.uN().putString("ala_jump_bd_yanzhi_channel_time", bBF());
        } else if (this.fUU == 103) {
            bBJ();
            if (this.fUQ != null) {
                addTab(this.fUQ);
                moveToTab(this.fUP, this.fUQ);
            }
        }
    }

    public void kr(boolean z) {
        this.fLB = z;
    }

    private boolean kO(boolean z) {
        return z || this.fUV;
    }
}
