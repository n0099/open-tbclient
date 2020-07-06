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
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    CustomMessageListener aHo;
    private long createTime;
    private boolean fWM;
    private IGuideTab ghR;
    private b ghS;
    private boolean ghT;
    private boolean ghU;
    private String ghV;
    private String ghW;
    private Map<String, Object> ghX;
    private BdAlertDialog ghY;
    private BdAlertDialog ghZ;
    private InterfaceC0571a gia;
    private int gib;
    private boolean gic;
    private b.a gie;
    private CustomMessageListener gif;
    private View.OnClickListener mOnClickListener;
    private long mRoomId;
    private TbPageContext mTbPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.guide.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0571a {
        void bCk();
    }

    public a(TbPageContext tbPageContext, long j) {
        super(tbPageContext);
        this.ghT = true;
        this.ghU = true;
        this.ghV = URLEncoder.encode("{\"channel\":\"112\"}");
        this.ghW = "baiduboxapp://v11/appTab/select?item=home&upgrade=0&params=" + this.ghV;
        this.ghX = new HashMap();
        this.createTime = 0L;
        this.gic = false;
        this.gie = new b.a() { // from class: com.baidu.tieba.ala.liveroom.guide.a.1
            @Override // com.baidu.tieba.ala.liveroom.guide.b.a
            public void d(int i, boolean z, boolean z2) {
                if (i == 0) {
                    a.this.ghT = z;
                    a.this.ghU = z2;
                    return;
                }
                a.this.ghT = true;
                a.this.ghU = true;
            }
        };
        this.aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.guide.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.vH();
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.guide.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_yanzhi_guide_add_btn) {
                    a.this.bER();
                    a.this.bET();
                    if (a.this.ghX != null) {
                        a.this.addTab(a.this.ghX);
                        a.this.moveToTab(a.this.ghW, a.this.ghX);
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_ADD);
                    alaStaticItem.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                } else if (view.getId() == a.g.id_ala_yanzhi_guide_pending_btn) {
                    a.this.bER();
                    a.this.bET();
                } else if (view.getId() == a.g.id_ala_signin_guide_jump_btn) {
                    a.this.bER();
                    a.this.bET();
                    if (a.this.ghX != null) {
                        a.this.addTab(a.this.ghX);
                        a.this.moveToTab(a.this.ghW, a.this.ghX);
                    }
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem2.addParams("from", "liveshow");
                    alaStaticItem2.addParams("type", "click");
                    alaStaticItem2.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_OLD);
                    alaStaticItem2.addParams("value", AlaStaticKeys.ALA_STATIC_YANZHI_VALUE_JUMP);
                    alaStaticItem2.addParams("ext", a.this.mRoomId);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                } else if (view.getId() == a.g.id_ala_signin_guide_pending_btn) {
                    a.this.bER();
                    a.this.bET();
                }
            }
        };
        this.gif = new CustomMessageListener(2913135) { // from class: com.baidu.tieba.ala.liveroom.guide.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!a.this.gic) {
                    a.this.gic = true;
                }
            }
        };
        this.mTbPageContext = tbPageContext;
        this.mRoomId = j;
        this.createTime = System.currentTimeMillis();
        init();
        MessageManager.getInstance().registerListener(this.aHo);
        MessageManager.getInstance().registerListener(this.gif);
    }

    private void init() {
        if (this.ghX != null) {
            this.ghX.put("id", "112");
            this.ghX.put("name", "颜值");
            this.ghX.put("canDelete", true);
            this.ghX.put("bundleId", "box.rnplugin.feedhn");
            this.ghX.put("moduleName", "FeedTabLive");
        }
        this.ghR = com.baidu.live.e.a.wg().wh();
        this.ghS = new b(this.gie);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0057, code lost:
        if (kZ(java.lang.System.currentTimeMillis() - r8.createTime >= 15000) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean bEL() {
        if (StringUtils.isNull(TbadkCoreApplication.getCurrentAccount())) {
            return false;
        }
        if (bEM()) {
            if (isAddedTab("112")) {
                if (this.fWM) {
                    this.fWM = false;
                    this.gib = 103;
                    return true;
                } else if (bEN() && !this.ghT && !this.ghU && !bEO()) {
                    this.gib = 102;
                    return true;
                }
            } else {
                if (!this.fWM) {
                }
                if (!bEO()) {
                    this.gib = 101;
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bEM() {
        return com.baidu.live.v.a.Hm().aZp.ayM;
    }

    private boolean bEN() {
        return com.baidu.live.v.a.Hm().aZp.ayN;
    }

    private boolean bEO() {
        String bEP = bEP();
        return !StringUtils.isNull(bEP) && bEP.equals(com.baidu.live.c.vf().getString("ala_jump_bd_yanzhi_channel_time", ""));
    }

    private String bEP() {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(new Date());
    }

    private void bEQ() {
        if (this.ghY == null || !this.ghY.isShowing()) {
            if (this.ghY == null) {
                this.ghY = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_yanzhi_guide_layout, (ViewGroup) null);
            this.ghY.setContentViewSize(1);
            this.ghY.setContentView(inflate);
            this.ghY.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_add_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_yanzhi_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.ghY.show();
            AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
            alaStaticItem.addParams("from", "liveshow");
            alaStaticItem.addParams("type", "show");
            alaStaticItem.addParams("page", AlaStaticKeys.ALA_STATIC_PAGE_YANZHI_NEW);
            alaStaticItem.addParams("ext", this.mRoomId);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bER() {
        if (this.ghY != null && this.ghY.isShowing()) {
            this.ghY.dismiss();
        }
        if (this.ghZ != null && this.ghZ.isShowing()) {
            this.ghZ.dismiss();
        }
    }

    private void bES() {
        if (this.ghZ == null || !this.ghZ.isShowing()) {
            if (this.ghZ == null) {
                this.ghZ = new BdAlertDialog(this.mTbPageContext.getPageActivity());
            }
            View inflate = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_signin_guide_layout, (ViewGroup) null);
            this.ghZ.setContentViewSize(1);
            this.ghZ.setContentView(inflate);
            this.ghZ.create(this.mTbPageContext);
            inflate.findViewById(a.g.id_ala_signin_guide_jump_btn).setOnClickListener(this.mOnClickListener);
            inflate.findViewById(a.g.id_ala_signin_guide_pending_btn).setOnClickListener(this.mOnClickListener);
            this.ghZ.show();
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
        if (this.ghR != null) {
            this.ghR.addTab(map);
        }
    }

    private boolean isAddedTab(String str) {
        if (this.ghR == null) {
            return true;
        }
        return this.ghR.isAddedTab(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveToTab(String str, Map map) {
        if (this.ghR != null) {
            this.ghR.moveToTab(str, map);
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void aq(ViewGroup viewGroup) {
        super.aq(viewGroup);
        if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && this.ghS != null) {
            this.ghS.bEW();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void vH() {
        super.vH();
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bER();
        this.gic = false;
        if (this.ghS != null) {
            this.ghS.onDestroy();
        }
        if (this.aHo != null) {
            MessageManager.getInstance().unRegisterListener(this.aHo);
        }
        if (this.gif != null) {
            MessageManager.getInstance().unRegisterListener(this.gif);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bET() {
        if (this.gia != null) {
            this.gia.bCk();
        }
    }

    public void a(InterfaceC0571a interfaceC0571a) {
        this.gia = interfaceC0571a;
    }

    public void bEU() {
        if (this.gib == 101) {
            bEQ();
            com.baidu.live.c.vf().putString("ala_jump_bd_yanzhi_channel_time", bEP());
        } else if (this.gib == 102) {
            bES();
            com.baidu.live.c.vf().putString("ala_jump_bd_yanzhi_channel_time", bEP());
        } else if (this.gib == 103) {
            bET();
            if (this.ghX != null) {
                addTab(this.ghX);
                moveToTab(this.ghW, this.ghX);
            }
        }
    }

    public void kE(boolean z) {
        this.fWM = z;
    }

    private boolean kZ(boolean z) {
        return z || this.gic;
    }
}
