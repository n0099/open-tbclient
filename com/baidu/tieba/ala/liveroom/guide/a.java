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
    CustomMessageListener aPU;
    private long createTime;
    private IGuideTab gCZ;
    private b gDa;
    private boolean gDb;
    private boolean gDc;
    private String gDd;
    private String gDe;
    private Map<String, Object> gDf;
    private BdAlertDialog gDg;
    private BdAlertDialog gDh;
    private InterfaceC0627a gDi;
    private int gDj;
    private boolean gDk;
    private b.a gDl;
    private CustomMessageListener gDm;
    private boolean grh;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0627a {
        void bQn();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.gDb = true;
        this.gDc = true;
        this.gDd = URLEncoder.encode("{\"channel\":\"112\"}");
        this.gDe = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.gDd;
        this.gDf = new HashMap();
        this.createTime = 0L;
        this.gDk = false;
        this.gDl = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.gDb = z;
                    a.this.gDc = z2;
                    return;
                }
                a.this.gDb = true;
                a.this.gDc = true;
            }
        };
        this.aPU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.BQ();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bTy();
                    a.this.bTA();
                    if (a.this.gDf != null) {
                        a.this.addTab(a.this.gDf);
                        a.this.moveToTab(a.this.gDe, a.this.gDf);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bTy();
                    a.this.bTA();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bTy();
                    a.this.bTA();
                    if (a.this.gDf != null) {
                        a.this.addTab(a.this.gDf);
                        a.this.moveToTab(a.this.gDe, a.this.gDf);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bTy();
                    a.this.bTA();
                }
            }
        };
        this.gDm = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.gDk) {
                    a.this.gDk = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aPU);
        MessageManager.getInstance().registerListener(this.gDm);
    }

    private void init() {
        if (this.gDf != null) {
            this.gDf.put("id", "112");
            this.gDf.put("name", "颜值");
            this.gDf.put("canDelete", true);
            this.gDf.put("bundleId", "box.rnplugin.feedhn");
            this.gDf.put("moduleName", "FeedTabLive");
        }
        this.gCZ = com.baidu.live.e.a.Cp().Cq();
        this.gDa = new b(this.gDl);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (ml(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bTs() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bTt()) {
            if (isAddedTab("112")) {
                if (this.grh) {
                    this.grh = false;
                    this.gDj = 103;
                    return true;
                } else if (bTu() && !this.gDb && !this.gDc && !bTv()) {
                    this.gDj = 102;
                    return true;
                }
            } else {
                if (!this.grh) {
                }
                if (!bTv()) {
                    this.gDj = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bTt() {
        return com.baidu.live.x.a.NN().bhy.aGA;
    }

    private boolean bTu() {
        return com.baidu.live.x.a.NN().bhy.aGB;
    }

    private boolean bTv() {
        String bTw = bTw();
        return !StringUtils.isNull(bTw) && bTw.equals(com.baidu.live.c.AR().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bTw() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bTx() {
        if (this.gDg == null || !this.gDg.isShowing()) {
            if (this.gDg == null) {
                this.gDg = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.gDg.setContentViewSize(1);
            this.gDg.setContentView(inflate);
            this.gDg.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gDg.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTy() {
        if (this.gDg != null && this.gDg.isShowing()) {
            this.gDg.dismiss();
        }
        if (this.gDh != null && this.gDh.isShowing()) {
            this.gDh.dismiss();
        }
    }

    private void bTz() {
        if (this.gDh == null || !this.gDh.isShowing()) {
            if (this.gDh == null) {
                this.gDh = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.gDh.setContentViewSize(1);
            this.gDh.setContentView(inflate);
            this.gDh.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gDh.show();
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
        if (this.gCZ != null) {
            this.gCZ.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.gCZ == null) {
            return true;
        }
        return this.gCZ.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.gCZ != null) {
            this.gCZ.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void at(ViewGroup viewGroup) {
        super.at(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.gDa != null) {
            this.gDa.bTD();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BQ() {
        super.BQ();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bTy();
        this.gDk = false;
        if (this.gDa != null) {
            this.gDa.onDestroy();
        }
        if (this.aPU != null) {
            MessageManager.getInstance().unRegisterListener(this.aPU);
        }
        if (this.gDm != null) {
            MessageManager.getInstance().unRegisterListener(this.gDm);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTA() {
        if (this.gDi != null) {
            this.gDi.bQn();
        }
    }

    public void a(InterfaceC0627a interfaceC0627a) {
        this.gDi = interfaceC0627a;
    }

    public void bTB() {
        if (this.gDj == 101) {
            bTx();
            com.baidu.live.c.AR().putString("ala_jump_bd_yanzhi_channel_time", bTw());
        } else if (this.gDj == 102) {
            bTz();
            com.baidu.live.c.AR().putString("ala_jump_bd_yanzhi_channel_time", bTw());
        } else if (this.gDj == 103) {
            bTA();
            if (this.gDf != null) {
                addTab(this.gDf);
                moveToTab(this.gDe, this.gDf);
            }
        }
    }

    public void lL(boolean z) {
        this.grh = z;
    }

    private boolean ml(boolean z) {
        return z || this.gDk;
    }
}
