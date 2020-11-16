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
    CustomMessageListener aTI;
    private long createTime;
    private boolean gXe;
    private IGuideTab hiI;
    private b hiJ;
    private boolean hiK;
    private boolean hiL;
    private String hiM;
    private String hiN;
    private Map<String, Object> hiO;
    private BdAlertDialog hiP;
    private BdAlertDialog hiQ;
    private InterfaceC0675a hiR;
    private int hiS;
    private boolean hiT;
    private b.a hiU;
    private CustomMessageListener hiV;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0675a {
        void bYz();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hiK = true;
        this.hiL = true;
        this.hiM = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hiN = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hiM;
        this.hiO = new HashMap();
        this.createTime = 0L;
        this.hiT = false;
        this.hiU = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hiK = z;
                    a.this.hiL = z2;
                    return;
                }
                a.this.hiK = true;
                a.this.hiL = true;
            }
        };
        this.aTI = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.CD();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_yanzhi_guide_add_btn) {
                    a.this.cbL();
                    a.this.cbN();
                    if (a.this.hiO != null) {
                        a.this.addTab(a.this.hiO);
                        a.this.moveToTab(a.this.hiN, a.this.hiO);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.f.id_ala_yanzhi_guide_pending_btn) {
                    a.this.cbL();
                    a.this.cbN();
                } else if (view.getId() == a.f.id_ala_signin_guide_jump_btn) {
                    a.this.cbL();
                    a.this.cbN();
                    if (a.this.hiO != null) {
                        a.this.addTab(a.this.hiO);
                        a.this.moveToTab(a.this.hiN, a.this.hiO);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.f.id_ala_signin_guide_pending_btn) {
                    a.this.cbL();
                    a.this.cbN();
                }
            }
        };
        this.hiV = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hiT) {
                    a.this.hiT = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aTI);
        MessageManager.getInstance().registerListener(this.hiV);
    }

    private void init() {
        if (this.hiO != null) {
            this.hiO.put("id", "112");
            this.hiO.put("name", "颜值");
            this.hiO.put("canDelete", true);
            this.hiO.put("bundleId", "box.rnplugin.feedhn");
            this.hiO.put("moduleName", "FeedTabLive");
        }
        this.hiI = com.baidu.live.e.a.Dd().De();
        this.hiJ = new b(this.hiU);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (nn(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cbF() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (cbG()) {
            if (isAddedTab("112")) {
                if (this.gXe) {
                    this.gXe = false;
                    this.hiS = 103;
                    return true;
                } else if (cbH() && !this.hiK && !this.hiL && !cbI()) {
                    this.hiS = 102;
                    return true;
                }
            } else {
                if (!this.gXe) {
                }
                if (!cbI()) {
                    this.hiS = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean cbG() {
        return com.baidu.live.aa.a.Ph().bms.aJv;
    }

    private boolean cbH() {
        return com.baidu.live.aa.a.Ph().bms.aJw;
    }

    private boolean cbI() {
        String cbJ = cbJ();
        return !StringUtils.isNull(cbJ) && cbJ.equals(com.baidu.live.d.Aq().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String cbJ() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void cbK() {
        if (this.hiP == null || !this.hiP.isShowing()) {
            if (this.hiP == null) {
                this.hiP = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hiP.setContentViewSize(1);
            this.hiP.setContentView(inflate);
            this.hiP.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hiP.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbL() {
        if (this.hiP != null && this.hiP.isShowing()) {
            this.hiP.dismiss();
        }
        if (this.hiQ != null && this.hiQ.isShowing()) {
            this.hiQ.dismiss();
        }
    }

    private void cbM() {
        if (this.hiQ == null || !this.hiQ.isShowing()) {
            if (this.hiQ == null) {
                this.hiQ = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hiQ.setContentViewSize(1);
            this.hiQ.setContentView(inflate);
            this.hiQ.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hiQ.show();
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
        if (this.hiI != null) {
            this.hiI.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hiI == null) {
            return true;
        }
        return this.hiI.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hiI != null) {
            this.hiI.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hiJ != null) {
            this.hiJ.cbQ();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CD() {
        super.CD();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cbL();
        this.hiT = false;
        if (this.hiJ != null) {
            this.hiJ.onDestroy();
        }
        if (this.aTI != null) {
            MessageManager.getInstance().unRegisterListener(this.aTI);
        }
        if (this.hiV != null) {
            MessageManager.getInstance().unRegisterListener(this.hiV);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbN() {
        if (this.hiR != null) {
            this.hiR.bYz();
        }
    }

    public void a(InterfaceC0675a interfaceC0675a) {
        this.hiR = interfaceC0675a;
    }

    public void cbO() {
        if (this.hiS == 101) {
            cbK();
            com.baidu.live.d.Aq().putString("ala_jump_bd_yanzhi_channel_time", cbJ());
        } else if (this.hiS == 102) {
            cbM();
            com.baidu.live.d.Aq().putString("ala_jump_bd_yanzhi_channel_time", cbJ());
        } else if (this.hiS == 103) {
            cbN();
            if (this.hiO != null) {
                addTab(this.hiO);
                moveToTab(this.hiN, this.hiO);
            }
        }
    }

    public void mN(boolean z) {
        this.gXe = z;
    }

    private boolean nn(boolean z) {
        return z || this.hiT;
    }
}
