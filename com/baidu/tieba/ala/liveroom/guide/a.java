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
    CustomMessageListener aVt;
    private long createTime;
    private boolean gXx;
    private IGuideTab hjb;
    private b hjc;
    private boolean hjd;
    private boolean hje;
    private String hjf;
    private String hjg;
    private Map<String, Object> hjh;
    private BdAlertDialog hji;
    private BdAlertDialog hjj;
    private InterfaceC0675a hjk;
    private int hjl;
    private boolean hjm;
    private b.a hjn;
    private CustomMessageListener hjo;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0675a {
        void bZg();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hjd = true;
        this.hje = true;
        this.hjf = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hjg = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hjf;
        this.hjh = new HashMap();
        this.createTime = 0L;
        this.hjm = false;
        this.hjn = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hjd = z;
                    a.this.hje = z2;
                    return;
                }
                a.this.hjd = true;
                a.this.hje = true;
            }
        };
        this.aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.Dm();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_yanzhi_guide_add_btn) {
                    a.this.ccs();
                    a.this.ccu();
                    if (a.this.hjh != null) {
                        a.this.addTab(a.this.hjh);
                        a.this.moveToTab(a.this.hjg, a.this.hjh);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.f.id_ala_yanzhi_guide_pending_btn) {
                    a.this.ccs();
                    a.this.ccu();
                } else if (view.getId() == a.f.id_ala_signin_guide_jump_btn) {
                    a.this.ccs();
                    a.this.ccu();
                    if (a.this.hjh != null) {
                        a.this.addTab(a.this.hjh);
                        a.this.moveToTab(a.this.hjg, a.this.hjh);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.f.id_ala_signin_guide_pending_btn) {
                    a.this.ccs();
                    a.this.ccu();
                }
            }
        };
        this.hjo = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hjm) {
                    a.this.hjm = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aVt);
        MessageManager.getInstance().registerListener(this.hjo);
    }

    private void init() {
        if (this.hjh != null) {
            this.hjh.put("id", "112");
            this.hjh.put("name", "颜值");
            this.hjh.put("canDelete", true);
            this.hjh.put("bundleId", "box.rnplugin.feedhn");
            this.hjh.put("moduleName", "FeedTabLive");
        }
        this.hjb = com.baidu.live.e.a.DM().DN();
        this.hjc = new b(this.hjn);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (nm(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean ccm() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (ccn()) {
            if (isAddedTab("112")) {
                if (this.gXx) {
                    this.gXx = false;
                    this.hjl = 103;
                    return true;
                } else if (cco() && !this.hjd && !this.hje && !ccp()) {
                    this.hjl = 102;
                    return true;
                }
            } else {
                if (!this.gXx) {
                }
                if (!ccp()) {
                    this.hjl = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ccn() {
        return com.baidu.live.aa.a.PQ().bod.aLg;
    }

    private boolean cco() {
        return com.baidu.live.aa.a.PQ().bod.aLh;
    }

    private boolean ccp() {
        String ccq = ccq();
        return !StringUtils.isNull(ccq) && ccq.equals(com.baidu.live.d.AZ().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String ccq() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void ccr() {
        if (this.hji == null || !this.hji.isShowing()) {
            if (this.hji == null) {
                this.hji = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hji.setContentViewSize(1);
            this.hji.setContentView(inflate);
            this.hji.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hji.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccs() {
        if (this.hji != null && this.hji.isShowing()) {
            this.hji.dismiss();
        }
        if (this.hjj != null && this.hjj.isShowing()) {
            this.hjj.dismiss();
        }
    }

    private void cct() {
        if (this.hjj == null || !this.hjj.isShowing()) {
            if (this.hjj == null) {
                this.hjj = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hjj.setContentViewSize(1);
            this.hjj.setContentView(inflate);
            this.hjj.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hjj.show();
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
        if (this.hjb != null) {
            this.hjb.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hjb == null) {
            return true;
        }
        return this.hjb.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hjb != null) {
            this.hjb.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void ax(ViewGroup viewGroup) {
        super.ax(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hjc != null) {
            this.hjc.ccx();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void Dm() {
        super.Dm();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        ccs();
        this.hjm = false;
        if (this.hjc != null) {
            this.hjc.onDestroy();
        }
        if (this.aVt != null) {
            MessageManager.getInstance().unRegisterListener(this.aVt);
        }
        if (this.hjo != null) {
            MessageManager.getInstance().unRegisterListener(this.hjo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccu() {
        if (this.hjk != null) {
            this.hjk.bZg();
        }
    }

    public void a(InterfaceC0675a interfaceC0675a) {
        this.hjk = interfaceC0675a;
    }

    public void ccv() {
        if (this.hjl == 101) {
            ccr();
            com.baidu.live.d.AZ().putString("ala_jump_bd_yanzhi_channel_time", ccq());
        } else if (this.hjl == 102) {
            cct();
            com.baidu.live.d.AZ().putString("ala_jump_bd_yanzhi_channel_time", ccq());
        } else if (this.hjl == 103) {
            ccu();
            if (this.hjh != null) {
                addTab(this.hjh);
                moveToTab(this.hjg, this.hjh);
            }
        }
    }

    public void mM(boolean z) {
        this.gXx = z;
    }

    private boolean nm(boolean z) {
        return z || this.hjm;
    }
}
