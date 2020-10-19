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
    CustomMessageListener aTf;
    private long createTime;
    private boolean gFC;
    private BdAlertDialog gRA;
    private InterfaceC0645a gRB;
    private int gRC;
    private boolean gRD;
    private b.a gRE;
    private CustomMessageListener gRF;
    private IGuideTab gRs;
    private b gRt;
    private boolean gRu;
    private boolean gRv;
    private String gRw;
    private String gRx;
    private Map<String, Object> gRy;
    private BdAlertDialog gRz;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0645a {
        void bTG();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.gRu = true;
        this.gRv = true;
        this.gRw = URLEncoder.encode("{\"channel\":\"112\"}");
        this.gRx = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.gRw;
        this.gRy = new HashMap();
        this.createTime = 0L;
        this.gRD = false;
        this.gRE = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.gRu = z;
                    a.this.gRv = z2;
                    return;
                }
                a.this.gRu = true;
                a.this.gRv = true;
            }
        };
        this.aTf = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.CN();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bWR();
                    a.this.bWT();
                    if (a.this.gRy != null) {
                        a.this.addTab(a.this.gRy);
                        a.this.moveToTab(a.this.gRx, a.this.gRy);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bWR();
                    a.this.bWT();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bWR();
                    a.this.bWT();
                    if (a.this.gRy != null) {
                        a.this.addTab(a.this.gRy);
                        a.this.moveToTab(a.this.gRx, a.this.gRy);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bWR();
                    a.this.bWT();
                }
            }
        };
        this.gRF = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.gRD) {
                    a.this.gRD = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aTf);
        MessageManager.getInstance().registerListener(this.gRF);
    }

    private void init() {
        if (this.gRy != null) {
            this.gRy.put("id", "112");
            this.gRy.put("name", "颜值");
            this.gRy.put("canDelete", true);
            this.gRy.put("bundleId", "box.rnplugin.feedhn");
            this.gRy.put("moduleName", "FeedTabLive");
        }
        this.gRs = com.baidu.live.e.a.Dm().Dn();
        this.gRt = new b(this.gRE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (mN(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bWL() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bWM()) {
            if (isAddedTab("112")) {
                if (this.gFC) {
                    this.gFC = false;
                    this.gRC = 103;
                    return true;
                } else if (bWN() && !this.gRu && !this.gRv && !bWO()) {
                    this.gRC = 102;
                    return true;
                }
            } else {
                if (!this.gFC) {
                }
                if (!bWO()) {
                    this.gRC = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bWM() {
        return com.baidu.live.x.a.OS().blo.aJE;
    }

    private boolean bWN() {
        return com.baidu.live.x.a.OS().blo.aJF;
    }

    private boolean bWO() {
        String bWP = bWP();
        return !StringUtils.isNull(bWP) && bWP.equals(com.baidu.live.c.AZ().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bWP() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bWQ() {
        if (this.gRz == null || !this.gRz.isShowing()) {
            if (this.gRz == null) {
                this.gRz = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.gRz.setContentViewSize(1);
            this.gRz.setContentView(inflate);
            this.gRz.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gRz.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWR() {
        if (this.gRz != null && this.gRz.isShowing()) {
            this.gRz.dismiss();
        }
        if (this.gRA != null && this.gRA.isShowing()) {
            this.gRA.dismiss();
        }
    }

    private void bWS() {
        if (this.gRA == null || !this.gRA.isShowing()) {
            if (this.gRA == null) {
                this.gRA = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.gRA.setContentViewSize(1);
            this.gRA.setContentView(inflate);
            this.gRA.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gRA.show();
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
        if (this.gRs != null) {
            this.gRs.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.gRs == null) {
            return true;
        }
        return this.gRs.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.gRs != null) {
            this.gRs.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void av(ViewGroup viewGroup) {
        super.av(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.gRt != null) {
            this.gRt.bWW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void CN() {
        super.CN();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bWR();
        this.gRD = false;
        if (this.gRt != null) {
            this.gRt.onDestroy();
        }
        if (this.aTf != null) {
            MessageManager.getInstance().unRegisterListener(this.aTf);
        }
        if (this.gRF != null) {
            MessageManager.getInstance().unRegisterListener(this.gRF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWT() {
        if (this.gRB != null) {
            this.gRB.bTG();
        }
    }

    public void a(InterfaceC0645a interfaceC0645a) {
        this.gRB = interfaceC0645a;
    }

    public void bWU() {
        if (this.gRC == 101) {
            bWQ();
            com.baidu.live.c.AZ().putString("ala_jump_bd_yanzhi_channel_time", bWP());
        } else if (this.gRC == 102) {
            bWS();
            com.baidu.live.c.AZ().putString("ala_jump_bd_yanzhi_channel_time", bWP());
        } else if (this.gRC == 103) {
            bWT();
            if (this.gRy != null) {
                addTab(this.gRy);
                moveToTab(this.gRx, this.gRy);
            }
        }
    }

    public void mn(boolean z) {
        this.gFC = z;
    }

    private boolean mN(boolean z) {
        return z || this.gRD;
    }
}
