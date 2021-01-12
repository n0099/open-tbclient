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
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aTF;
    private long createTime;
    private boolean hnS;
    private String hzA;
    private String hzB;
    private Map<String, Object> hzC;
    private BdAlertDialog hzD;
    private BdAlertDialog hzE;
    private InterfaceC0664a hzF;
    private int hzG;
    private boolean hzH;
    private b.a hzI;
    private CustomMessageListener hzJ;
    private IGuideTab hzw;
    private b hzx;
    private boolean hzy;
    private boolean hzz;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0664a {
        void cbt();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hzy = true;
        this.hzz = true;
        this.hzA = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hzB = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hzA;
        this.hzC = new HashMap();
        this.createTime = 0L;
        this.hzH = false;
        this.hzI = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hzy = z;
                    a.this.hzz = z2;
                    return;
                }
                a.this.hzy = true;
                a.this.hzz = true;
            }
        };
        this.aTF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.zH();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_yanzhi_guide_add_btn) {
                    a.this.ceD();
                    a.this.ceF();
                    if (a.this.hzC != null) {
                        a.this.addTab(a.this.hzC);
                        a.this.moveToTab(a.this.hzB, a.this.hzC);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.f.id_ala_yanzhi_guide_pending_btn) {
                    a.this.ceD();
                    a.this.ceF();
                } else if (view.getId() == a.f.id_ala_signin_guide_jump_btn) {
                    a.this.ceD();
                    a.this.ceF();
                    if (a.this.hzC != null) {
                        a.this.addTab(a.this.hzC);
                        a.this.moveToTab(a.this.hzB, a.this.hzC);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.f.id_ala_signin_guide_pending_btn) {
                    a.this.ceD();
                    a.this.ceF();
                }
            }
        };
        this.hzJ = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hzH) {
                    a.this.hzH = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aTF);
        MessageManager.getInstance().registerListener(this.hzJ);
    }

    private void init() {
        if (this.hzC != null) {
            this.hzC.put("id", "112");
            this.hzC.put("name", "颜值");
            this.hzC.put("canDelete", true);
            this.hzC.put("bundleId", "box.rnplugin.feedhn");
            this.hzC.put("moduleName", "FeedTabLive");
        }
        this.hzw = com.baidu.live.g.a.Ah().Ai();
        this.hzx = new b(this.hzI);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (oe(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cex() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (cey()) {
            if (isAddedTab("112")) {
                if (this.hnS) {
                    this.hnS = false;
                    this.hzG = 103;
                    return true;
                } else if (cez() && !this.hzy && !this.hzz && !ceA()) {
                    this.hzG = 102;
                    return true;
                }
            } else {
                if (!this.hnS) {
                }
                if (!ceA()) {
                    this.hzG = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cey() {
        return com.baidu.live.af.a.OJ().bru.aIf;
    }

    private boolean cez() {
        return com.baidu.live.af.a.OJ().bru.aIg;
    }

    private boolean ceA() {
        String ceB = ceB();
        return !StringUtils.isNull(ceB) && ceB.equals(com.baidu.live.d.xf().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String ceB() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void ceC() {
        if (this.hzD == null || !this.hzD.isShowing()) {
            if (this.hzD == null) {
                this.hzD = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hzD.setContentViewSize(1);
            this.hzD.setContentView(inflate);
            this.hzD.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hzD.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceD() {
        if (this.hzD != null && this.hzD.isShowing()) {
            this.hzD.dismiss();
        }
        if (this.hzE != null && this.hzE.isShowing()) {
            this.hzE.dismiss();
        }
    }

    private void ceE() {
        if (this.hzE == null || !this.hzE.isShowing()) {
            if (this.hzE == null) {
                this.hzE = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hzE.setContentViewSize(1);
            this.hzE.setContentView(inflate);
            this.hzE.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hzE.show();
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
        if (this.hzw != null) {
            this.hzw.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hzw == null) {
            return true;
        }
        return this.hzw.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hzw != null) {
            this.hzw.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hzx != null) {
            this.hzx.ceI();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void zH() {
        super.zH();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        ceD();
        this.hzH = false;
        if (this.hzx != null) {
            this.hzx.onDestroy();
        }
        if (this.aTF != null) {
            MessageManager.getInstance().unRegisterListener(this.aTF);
        }
        if (this.hzJ != null) {
            MessageManager.getInstance().unRegisterListener(this.hzJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceF() {
        if (this.hzF != null) {
            this.hzF.cbt();
        }
    }

    public void a(InterfaceC0664a interfaceC0664a) {
        this.hzF = interfaceC0664a;
    }

    public void ceG() {
        if (this.hzG == 101) {
            ceC();
            com.baidu.live.d.xf().putString("ala_jump_bd_yanzhi_channel_time", ceB());
        } else if (this.hzG == 102) {
            ceE();
            com.baidu.live.d.xf().putString("ala_jump_bd_yanzhi_channel_time", ceB());
        } else if (this.hzG == 103) {
            ceF();
            if (this.hzC != null) {
                addTab(this.hzC);
                moveToTab(this.hzB, this.hzC);
            }
        }
    }

    public void nD(boolean z) {
        this.hnS = z;
    }

    private boolean oe(boolean z) {
        return z || this.hzH;
    }
}
