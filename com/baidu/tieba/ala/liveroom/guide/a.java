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
import com.baidu.live.r.a;
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
    CustomMessageListener aeN;
    private long createTime;
    private boolean eOp;
    private IGuideTab eYC;
    private b eYD;
    private boolean eYE;
    private boolean eYF;
    private String eYG;
    private String eYH;
    private Map<String, Object> eYI;
    private BdAlertDialog eYJ;
    private BdAlertDialog eYK;
    private InterfaceC0447a eYL;
    private int eYM;
    private boolean eYN;
    private b.a eYO;
    private CustomMessageListener eYP;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0447a {
        void bhV();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.eYE = true;
        this.eYF = true;
        this.eYG = URLEncoder.encode("{\"channel\":\"112\"}");
        this.eYH = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.eYG;
        this.eYI = new HashMap();
        this.createTime = 0L;
        this.eYN = false;
        this.eYO = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.eYE = z;
                    a.this.eYF = z2;
                    return;
                }
                a.this.eYE = true;
                a.this.eYF = true;
            }
        };
        this.aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.oZ();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bkB();
                    a.this.bkD();
                    if (a.this.eYI != null) {
                        a.this.addTab(a.this.eYI);
                        a.this.moveToTab(a.this.eYH, a.this.eYI);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bkB();
                    a.this.bkD();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bkB();
                    a.this.bkD();
                    if (a.this.eYI != null) {
                        a.this.addTab(a.this.eYI);
                        a.this.moveToTab(a.this.eYH, a.this.eYI);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bkB();
                    a.this.bkD();
                }
            }
        };
        this.eYP = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.eYN) {
                    a.this.eYN = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aeN);
        MessageManager.getInstance().registerListener(this.eYP);
    }

    private void init() {
        if (this.eYI != null) {
            this.eYI.put("id", "112");
            this.eYI.put("name", "颜值");
            this.eYI.put("canDelete", true);
            this.eYI.put("bundleId", "box.rnplugin.feedhn");
            this.eYI.put("moduleName", "FeedTabLive");
        }
        this.eYC = com.baidu.live.e.a.pz().pA();
        this.eYD = new b(this.eYO);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (jo(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bkv() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bkw()) {
            if (isAddedTab("112")) {
                if (this.eOp) {
                    this.eOp = false;
                    this.eYM = 103;
                    return true;
                } else if (bkx() && !this.eYE && !this.eYF && !bky()) {
                    this.eYM = 102;
                    return true;
                }
            } else {
                if (!this.eOp) {
                }
                if (!bky()) {
                    this.eYM = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bkw() {
        return com.baidu.live.s.a.wR().asq.Xo;
    }

    private boolean bkx() {
        return com.baidu.live.s.a.wR().asq.Xp;
    }

    private boolean bky() {
        String bkz = bkz();
        return !StringUtils.isNull(bkz) && bkz.equals(com.baidu.live.c.oJ().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bkz() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void bkA() {
        if (this.eYJ == null || !this.eYJ.isShowing()) {
            if (this.eYJ == null) {
                this.eYJ = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.eYJ.setContentViewSize(1);
            this.eYJ.setContentView(inflate);
            this.eYJ.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.eYJ.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkB() {
        if (this.eYJ != null && this.eYJ.isShowing()) {
            this.eYJ.dismiss();
        }
        if (this.eYK != null && this.eYK.isShowing()) {
            this.eYK.dismiss();
        }
    }

    private void bkC() {
        if (this.eYK == null || !this.eYK.isShowing()) {
            if (this.eYK == null) {
                this.eYK = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.eYK.setContentViewSize(1);
            this.eYK.setContentView(inflate);
            this.eYK.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.eYK.show();
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
        if (this.eYC != null) {
            this.eYC.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.eYC == null) {
            return true;
        }
        return this.eYC.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.eYC != null) {
            this.eYC.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ad(ViewGroup viewGroup) {
        super.ad(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.eYD != null) {
            this.eYD.bkG();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void oZ() {
        super.oZ();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bkB();
        this.eYN = false;
        if (this.eYD != null) {
            this.eYD.onDestroy();
        }
        if (this.aeN != null) {
            MessageManager.getInstance().unRegisterListener(this.aeN);
        }
        if (this.eYP != null) {
            MessageManager.getInstance().unRegisterListener(this.eYP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkD() {
        if (this.eYL != null) {
            this.eYL.bhV();
        }
    }

    public void a(InterfaceC0447a interfaceC0447a) {
        this.eYL = interfaceC0447a;
    }

    public void bkE() {
        if (this.eYM == 101) {
            bkA();
            com.baidu.live.c.oJ().putString("ala_jump_bd_yanzhi_channel_time", bkz());
        } else if (this.eYM == 102) {
            bkC();
            com.baidu.live.c.oJ().putString("ala_jump_bd_yanzhi_channel_time", bkz());
        } else if (this.eYM == 103) {
            bkD();
            if (this.eYI != null) {
                addTab(this.eYI);
                moveToTab(this.eYH, this.eYI);
            }
        }
    }

    public void iO(boolean z) {
        this.eOp = z;
    }

    private boolean jo(boolean z) {
        return z || this.eYN;
    }
}
