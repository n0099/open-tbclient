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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aYs;
    private long createTime;
    private IGuideTab hEc;
    private b hEd;
    private boolean hEe;
    private boolean hEf;
    private String hEg;
    private String hEh;
    private Map<String, Object> hEi;
    private BdAlertDialog hEj;
    private BdAlertDialog hEk;
    private InterfaceC0681a hEl;
    private int hEm;
    private boolean hEn;
    private b.a hEo;
    private CustomMessageListener hEp;
    private boolean hsz;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0681a {
        void cfl();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.hEe = true;
        this.hEf = true;
        this.hEg = URLEncoder.encode("{\"channel\":\"112\"}");
        this.hEh = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.hEg;
        this.hEi = new HashMap();
        this.createTime = 0L;
        this.hEn = false;
        this.hEo = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void e(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.hEe = z;
                    a.this.hEf = z2;
                    return;
                }
                a.this.hEe = true;
                a.this.hEf = true;
            }
        };
        this.aYs = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.DC();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_yanzhi_guide_add_btn) {
                    a.this.civ();
                    a.this.cix();
                    if (a.this.hEi != null) {
                        a.this.addTab(a.this.hEi);
                        a.this.moveToTab(a.this.hEh, a.this.hEi);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.f.id_ala_yanzhi_guide_pending_btn) {
                    a.this.civ();
                    a.this.cix();
                } else if (view.getId() == a.f.id_ala_signin_guide_jump_btn) {
                    a.this.civ();
                    a.this.cix();
                    if (a.this.hEi != null) {
                        a.this.addTab(a.this.hEi);
                        a.this.moveToTab(a.this.hEh, a.this.hEi);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.f.id_ala_signin_guide_pending_btn) {
                    a.this.civ();
                    a.this.cix();
                }
            }
        };
        this.hEp = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.hEn) {
                    a.this.hEn = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aYs);
        MessageManager.getInstance().registerListener(this.hEp);
    }

    private void init() {
        if (this.hEi != null) {
            this.hEi.put("id", "112");
            this.hEi.put("name", "颜值");
            this.hEi.put("canDelete", true);
            this.hEi.put("bundleId", "box.rnplugin.feedhn");
            this.hEi.put("moduleName", "FeedTabLive");
        }
        this.hEc = com.baidu.live.g.a.Ec().Ed();
        this.hEd = new b(this.hEo);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (oi(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cip() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (ciq()) {
            if (isAddedTab("112")) {
                if (this.hsz) {
                    this.hsz = false;
                    this.hEm = 103;
                    return true;
                } else if (cir() && !this.hEe && !this.hEf && !cis()) {
                    this.hEm = 102;
                    return true;
                }
            } else {
                if (!this.hsz) {
                }
                if (!cis()) {
                    this.hEm = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ciq() {
        return com.baidu.live.af.a.SE().bwi.aMS;
    }

    private boolean cir() {
        return com.baidu.live.af.a.SE().bwi.aMT;
    }

    private boolean cis() {
        String cit = cit();
        return !StringUtils.isNull(cit) && cit.equals(com.baidu.live.d.Ba().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String cit() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    private void ciu() {
        if (this.hEj == null || !this.hEj.isShowing()) {
            if (this.hEj == null) {
                this.hEj = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.hEj.setContentViewSize(1);
            this.hEj.setContentView(inflate);
            this.hEj.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hEj.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void civ() {
        if (this.hEj != null && this.hEj.isShowing()) {
            this.hEj.dismiss();
        }
        if (this.hEk != null && this.hEk.isShowing()) {
            this.hEk.dismiss();
        }
    }

    private void ciw() {
        if (this.hEk == null || !this.hEk.isShowing()) {
            if (this.hEk == null) {
                this.hEk = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.hEk.setContentViewSize(1);
            this.hEk.setContentView(inflate);
            this.hEk.create(this.mTbPageContext);
            inflate.findViewById(a.f.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.f.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.hEk.show();
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
        if (this.hEc != null) {
            this.hEc.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.hEc == null) {
            return true;
        }
        return this.hEc.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.hEc != null) {
            this.hEc.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aF(ViewGroup viewGroup) {
        super.aF(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.hEd != null) {
            this.hEd.ciA();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void DC() {
        super.DC();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        civ();
        this.hEn = false;
        if (this.hEd != null) {
            this.hEd.onDestroy();
        }
        if (this.aYs != null) {
            MessageManager.getInstance().unRegisterListener(this.aYs);
        }
        if (this.hEp != null) {
            MessageManager.getInstance().unRegisterListener(this.hEp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cix() {
        if (this.hEl != null) {
            this.hEl.cfl();
        }
    }

    public void a(InterfaceC0681a interfaceC0681a) {
        this.hEl = interfaceC0681a;
    }

    public void ciy() {
        if (this.hEm == 101) {
            ciu();
            com.baidu.live.d.Ba().putString("ala_jump_bd_yanzhi_channel_time", cit());
        } else if (this.hEm == 102) {
            ciw();
            com.baidu.live.d.Ba().putString("ala_jump_bd_yanzhi_channel_time", cit());
        } else if (this.hEm == 103) {
            cix();
            if (this.hEi != null) {
                addTab(this.hEi);
                moveToTab(this.hEh, this.hEi);
            }
        }
    }

    public void nH(boolean z) {
        this.hsz = z;
    }

    private boolean oi(boolean z) {
        return z || this.hEn;
    }
}
