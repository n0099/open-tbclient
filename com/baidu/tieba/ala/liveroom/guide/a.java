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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aNW;
    private long createTime;
    private boolean gnY;
    private IGuideTab gzK;
    private b gzL;
    private boolean gzM;
    private boolean gzN;
    private String gzO;
    private String gzP;
    private Map<String, Object> gzQ;
    private BdAlertDialog gzR;
    private BdAlertDialog gzS;
    private InterfaceC0631a gzT;
    private int gzU;
    private boolean gzV;
    private b.a gzW;
    private CustomMessageListener gzX;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0631a {
        void bPb();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.gzM = true;
        this.gzN = true;
        this.gzO = URLEncoder.encode("{\"channel\":\"112\"}");
        this.gzP = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.gzO;
        this.gzQ = new HashMap();
        this.createTime = 0L;
        this.gzV = false;
        this.gzW = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.gzM = z;
                    a.this.gzN = z2;
                    return;
                }
                a.this.gzM = true;
                a.this.gzN = true;
            }
        };
        this.aNW = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.BB();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bSb();
                    a.this.bSd();
                    if (a.this.gzQ != null) {
                        a.this.addTab(a.this.gzQ);
                        a.this.moveToTab(a.this.gzP, a.this.gzQ);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bSb();
                    a.this.bSd();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bSb();
                    a.this.bSd();
                    if (a.this.gzQ != null) {
                        a.this.addTab(a.this.gzQ);
                        a.this.moveToTab(a.this.gzP, a.this.gzQ);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bSb();
                    a.this.bSd();
                }
            }
        };
        this.gzX = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.gzV) {
                    a.this.gzV = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aNW);
        MessageManager.getInstance().registerListener(this.gzX);
    }

    private void init() {
        if (this.gzQ != null) {
            this.gzQ.put("id", "112");
            this.gzQ.put("name", "颜值");
            this.gzQ.put("canDelete", true);
            this.gzQ.put("bundleId", "box.rnplugin.feedhn");
            this.gzQ.put("moduleName", "FeedTabLive");
        }
        this.gzK = com.baidu.live.e.a.Ca().Cb();
        this.gzL = new b(this.gzW);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (mi(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bRV() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bRW()) {
            if (isAddedTab("112")) {
                if (this.gnY) {
                    this.gnY = false;
                    this.gzU = 103;
                    return true;
                } else if (bRX() && !this.gzM && !this.gzN && !bRY()) {
                    this.gzU = 102;
                    return true;
                }
            } else {
                if (!this.gnY) {
                }
                if (!bRY()) {
                    this.gzU = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bRW() {
        return com.baidu.live.w.a.Nk().beJ.aFl;
    }

    private boolean bRX() {
        return com.baidu.live.w.a.Nk().beJ.aFm;
    }

    private boolean bRY() {
        String bRZ = bRZ();
        return !StringUtils.isNull(bRZ) && bRZ.equals(com.baidu.live.c.AD().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bRZ() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bSa() {
        if (this.gzR == null || !this.gzR.isShowing()) {
            if (this.gzR == null) {
                this.gzR = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.gzR.setContentViewSize(1);
            this.gzR.setContentView(inflate);
            this.gzR.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gzR.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSb() {
        if (this.gzR != null && this.gzR.isShowing()) {
            this.gzR.dismiss();
        }
        if (this.gzS != null && this.gzS.isShowing()) {
            this.gzS.dismiss();
        }
    }

    private void bSc() {
        if (this.gzS == null || !this.gzS.isShowing()) {
            if (this.gzS == null) {
                this.gzS = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.gzS.setContentViewSize(1);
            this.gzS.setContentView(inflate);
            this.gzS.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.gzS.show();
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
        if (this.gzK != null) {
            this.gzK.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.gzK == null) {
            return true;
        }
        return this.gzK.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.gzK != null) {
            this.gzK.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void as(ViewGroup viewGroup) {
        super.as(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.gzL != null) {
            this.gzL.bSg();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void BB() {
        super.BB();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bSb();
        this.gzV = false;
        if (this.gzL != null) {
            this.gzL.onDestroy();
        }
        if (this.aNW != null) {
            MessageManager.getInstance().unRegisterListener(this.aNW);
        }
        if (this.gzX != null) {
            MessageManager.getInstance().unRegisterListener(this.gzX);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSd() {
        if (this.gzT != null) {
            this.gzT.bPb();
        }
    }

    public void a(InterfaceC0631a interfaceC0631a) {
        this.gzT = interfaceC0631a;
    }

    public void bSe() {
        if (this.gzU == 101) {
            bSa();
            com.baidu.live.c.AD().putString("ala_jump_bd_yanzhi_channel_time", bRZ());
        } else if (this.gzU == 102) {
            bSc();
            com.baidu.live.c.AD().putString("ala_jump_bd_yanzhi_channel_time", bRZ());
        } else if (this.gzU == 103) {
            bSd();
            if (this.gzQ != null) {
                addTab(this.gzQ);
                moveToTab(this.gzP, this.gzQ);
            }
        }
    }

    public void lJ(boolean z) {
        this.gnY = z;
    }

    private boolean mi(boolean z) {
        return z || this.gzV;
    }
}
