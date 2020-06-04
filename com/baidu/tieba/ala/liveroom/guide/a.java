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
    private boolean fLM;
    private IGuideTab fUV;
    private b fUW;
    private boolean fUX;
    private boolean fUY;
    private String fUZ;
    private String fVa;
    private Map<String, Object> fVb;
    private BdAlertDialog fVc;
    private BdAlertDialog fVd;
    private InterfaceC0562a fVe;
    private int fVf;
    private boolean fVg;
    private b.a fVh;
    private CustomMessageListener fVi;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0562a {
        void bzw();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.fUX = true;
        this.fUY = true;
        this.fUZ = URLEncoder.encode("{\"channel\":\"112\"}");
        this.fVa = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.fUZ;
        this.fVb = new HashMap();
        this.createTime = 0L;
        this.fVg = false;
        this.fVh = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.fUX = z;
                    a.this.fUY = z2;
                    return;
                }
                a.this.fUX = true;
                a.this.fUY = true;
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
                    a.this.bBJ();
                    a.this.bBL();
                    if (a.this.fVb != null) {
                        a.this.addTab(a.this.fVb);
                        a.this.moveToTab(a.this.fVa, a.this.fVb);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bBJ();
                    a.this.bBL();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bBJ();
                    a.this.bBL();
                    if (a.this.fVb != null) {
                        a.this.addTab(a.this.fVb);
                        a.this.moveToTab(a.this.fVa, a.this.fVb);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bBJ();
                    a.this.bBL();
                }
            }
        };
        this.fVi = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.fVg) {
                    a.this.fVg = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aES);
        MessageManager.getInstance().registerListener(this.fVi);
    }

    private void init() {
        if (this.fVb != null) {
            this.fVb.put("id", "112");
            this.fVb.put("name", "颜值");
            this.fVb.put("canDelete", true);
            this.fVb.put("bundleId", "box.rnplugin.feedhn");
            this.fVb.put("moduleName", "FeedTabLive");
        }
        this.fUV = com.baidu.live.e.a.vM().vN();
        this.fUW = new b(this.fVh);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (kO(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bBD() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bBE()) {
            if (isAddedTab("112")) {
                if (this.fLM) {
                    this.fLM = false;
                    this.fVf = 103;
                    return true;
                } else if (bBF() && !this.fUX && !this.fUY && !bBG()) {
                    this.fVf = 102;
                    return true;
                }
            } else {
                if (!this.fLM) {
                }
                if (!bBG()) {
                    this.fVf = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bBE() {
        return com.baidu.live.v.a.Ge().aWF.awE;
    }

    private boolean bBF() {
        return com.baidu.live.v.a.Ge().aWF.awF;
    }

    private boolean bBG() {
        String bBH = bBH();
        return !StringUtils.isNull(bBH) && bBH.equals(com.baidu.live.c.uN().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bBH() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bBI() {
        if (this.fVc == null || !this.fVc.isShowing()) {
            if (this.fVc == null) {
                this.fVc = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.fVc.setContentViewSize(1);
            this.fVc.setContentView(inflate);
            this.fVc.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fVc.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBJ() {
        if (this.fVc != null && this.fVc.isShowing()) {
            this.fVc.dismiss();
        }
        if (this.fVd != null && this.fVd.isShowing()) {
            this.fVd.dismiss();
        }
    }

    private void bBK() {
        if (this.fVd == null || !this.fVd.isShowing()) {
            if (this.fVd == null) {
                this.fVd = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.fVd.setContentViewSize(1);
            this.fVd.setContentView(inflate);
            this.fVd.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.fVd.show();
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
        if (this.fUV != null) {
            this.fUV.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.fUV == null) {
            return true;
        }
        return this.fUV.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.fUV != null) {
            this.fUV.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ao(ViewGroup viewGroup) {
        super.ao(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.fUW != null) {
            this.fUW.bBO();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vm() {
        super.vm();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bBJ();
        this.fVg = false;
        if (this.fUW != null) {
            this.fUW.onDestroy();
        }
        if (this.aES != null) {
            MessageManager.getInstance().unRegisterListener(this.aES);
        }
        if (this.fVi != null) {
            MessageManager.getInstance().unRegisterListener(this.fVi);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBL() {
        if (this.fVe != null) {
            this.fVe.bzw();
        }
    }

    public void a(InterfaceC0562a interfaceC0562a) {
        this.fVe = interfaceC0562a;
    }

    public void bBM() {
        if (this.fVf == 101) {
            bBI();
            com.baidu.live.c.uN().putString("ala_jump_bd_yanzhi_channel_time", bBH());
        } else if (this.fVf == 102) {
            bBK();
            com.baidu.live.c.uN().putString("ala_jump_bd_yanzhi_channel_time", bBH());
        } else if (this.fVf == 103) {
            bBL();
            if (this.fVb != null) {
                addTab(this.fVb);
                moveToTab(this.fVa, this.fVb);
            }
        }
    }

    public void kr(boolean z) {
        this.fLM = z;
    }

    private boolean kO(boolean z) {
        return z || this.fVg;
    }
}
