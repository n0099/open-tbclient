package com.baidu.tieba.ala.liveroom.c;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ar.pose.PoseAR;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c.r;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.ae;
import com.baidu.live.data.an;
import com.baidu.live.data.ar;
import com.baidu.live.data.as;
import com.baidu.live.data.bb;
import com.baidu.live.data.bc;
import com.baidu.live.data.bh;
import com.baidu.live.data.q;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.f;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.gift.x;
import com.baidu.live.gift.y;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.guardclub.g;
import com.baidu.live.guardclub.h;
import com.baidu.live.guardclub.j;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
import com.baidu.live.im.o;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.o.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.atomdata.CommonWebViewActivityConfig;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.timer.LiveTimerManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.m;
import com.baidu.live.utils.p;
import com.baidu.live.view.input.c;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.liveroom.g.e;
import com.baidu.tieba.ala.liveroom.l.a;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    public static boolean fWW;
    private com.baidu.tieba.ala.liveroom.data.a fVT;
    protected com.baidu.tieba.ala.liveroom.operation.a fVU;
    private com.baidu.tieba.ala.liveroom.attentionpop.a fVV;
    protected com.baidu.live.h.a fVW;
    protected com.baidu.tieba.ala.liveroom.share.c fVX;
    protected com.baidu.tieba.ala.liveroom.p.b fVY;
    protected com.baidu.tieba.ala.liveroom.guide.c fVZ;
    protected com.baidu.tieba.ala.liveroom.o.c fWA;
    private x fWB;
    protected com.baidu.tieba.ala.liveroom.t.a fWC;
    protected e fWD;
    protected com.baidu.live.i.a fWE;
    protected com.baidu.tieba.ala.liveroom.recommend.a fWF;
    protected bc fWG;
    protected com.baidu.live.r.a fWH;
    protected com.baidu.tieba.ala.liveroom.e.a fWI;
    protected RelativeLayout fWJ;
    protected RelativeLayout fWK;
    protected boolean fWM;
    protected ae fWP;
    protected GuardClubInfoHttpResponseMessage fWQ;
    boolean fWR;
    boolean fWS;
    boolean fWT;
    public boolean fWU;
    public boolean fWV;
    protected com.baidu.tieba.ala.liveroom.r.b fWX;
    protected com.baidu.tieba.ala.liveroom.i.e fWY;
    protected List<com.baidu.live.liveroom.g.d> fWZ;
    protected com.baidu.tieba.ala.liveroom.watermark.a fWa;
    protected com.baidu.tieba.ala.liveroom.b.b fWb;
    protected com.baidu.tieba.ala.liveroom.praise.a fWc;
    protected com.baidu.tieba.ala.liveroom.sticker.a fWd;
    protected com.baidu.tieba.ala.liveroom.guide.d fWe;
    protected com.baidu.tieba.ala.liveroom.w.a fWf;
    protected com.baidu.live.x.a fWg;
    private com.baidu.tieba.ala.liveroom.g.a fWh;
    private o fWi;
    k fWj;
    l fWk;
    protected w fWl;
    protected u fWm;
    protected com.baidu.tieba.ala.liveroom.tippop.a fWn;
    private com.baidu.tieba.ala.liveroom.guideim.b fWo;
    protected com.baidu.live.view.input.c fWp;
    com.baidu.tieba.ala.liveroom.l.a fWq;
    protected com.baidu.tieba.ala.liveroom.guide.a fWr;
    private com.baidu.live.guardclub.k fWs;
    protected com.baidu.live.j.b fWt;
    protected h fWu;
    protected j fWv;
    protected y fWw;
    protected com.baidu.tieba.ala.liveroom.turntable.e fWy;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b fWz;
    protected List<com.baidu.live.liveroom.g.b> fXa;
    protected AlaLastLiveroomInfo fgP;
    protected String otherParams;
    private int fWx = 0;
    private int fWL = -1;
    protected int mOrientation = 0;
    protected boolean fWN = false;
    protected boolean fWO = false;
    private CustomMessageListener fXb = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.w wVar;
            if ((customResponsedMessage.getData() instanceof com.baidu.live.data.w) && (wVar = (com.baidu.live.data.w) customResponsedMessage.getData()) != null) {
                b.this.a(wVar.aye, wVar.aya, wVar.ayb, wVar.ayc, wVar.ayd);
            }
        }
    };
    private CustomMessageListener fXc = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bBT().gfS.FU().axp.userId);
            com.baidu.live.view.a.Ky().a(valueOf, new com.baidu.live.data.d(b.this.bBT().gfS.FU().axp.portrait, valueOf, true, b.this.bBT().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener fXd = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof q) && b.this.fVX != null) {
                b.this.fVX.c((q) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener aVW = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fWj != null) {
                b.this.fWj.f(t.yL().yN());
            }
        }
    };
    private CustomMessageListener fXe = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.fVT.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.CH(str);
            }
        }
    };
    private CustomMessageListener fXf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bBT().pageContext.getPageActivity());
            } else if (b.this.fVX != null) {
                b.this.fVX.c(b.this.bBT().gfS.FU(), false);
            }
        }
    };
    private CustomMessageListener fXg = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ae) {
                    b.this.fWO = true;
                    b.this.fWP = (ae) data;
                    b.this.b(b.this.fWP);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener fXh = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bBT().gfS.FU().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bBT().gfS.FU().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bBT().gfS.FU().axp.userId);
                    if (b.this.fVY == null) {
                        b.this.fVY = new com.baidu.tieba.ala.liveroom.p.b();
                    }
                    b.this.fVY.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.fVY.a(b.this.fXi);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.a fXi = new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.33
        @Override // com.baidu.live.o.b.a
        public void Gx() {
            if (b.this.bBT().gfS.FU() != null && b.this.bBT().gfS.FU().axI != null) {
                b.this.bBT().gfS.FU().axI.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener fXj = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.fWt != null) {
                    b.this.fWt.x(aVar);
                }
                b.this.k(aVar);
            }
        }
    };
    CustomMessageListener fXk = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ro(7);
        }
    };
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
            }
        }
    };
    CustomMessageListener fXl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.fWR = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fWq != null) {
                b.this.fWq.yY();
            }
        }
    };
    HttpMessageListener fIh = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aRm) != null && b.this.fWs != null && b.this.bBT() != null && b.this.bBT().gfS != null) {
                int[] iArr = new int[2];
                b.this.fWJ.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.fWs.a(b.this.fWJ, layoutParams, aVar, b.this.bBT().gfS.FU());
                com.baidu.live.m.a.av(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fIe = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bBT() != null && b.this.bBT().gfS != null && b.this.bBT().gfS.FU() != null && guardClubInfoHttpResponseMessage.aRm != null) {
                    if (guardClubInfoHttpResponseMessage.aRm.awn == b.this.bBT().gfS.FU().axp.userId) {
                        b.this.fWQ = guardClubInfoHttpResponseMessage;
                        if (b.this.fWQ.aRp && com.baidu.live.guardclub.e.Cg() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.Cg().ag(b.this.bBT().gfS.FU().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener fXm = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bh) {
                b.this.a((bh) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fXn = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.q(b.this.bBT().gfS.FU());
        }
    };
    private CustomMessageListener fXo = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.fWE != null) {
                b.this.fWE.Co();
            }
        }
    };
    private CustomMessageListener fXp = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.fWw != null) {
                    ((com.baidu.tieba.ala.liveroom.o.b) b.this.fWw).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fXq = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bBu();
        }
    };
    private CustomMessageListener fXr = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.c.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bBT().gfS.FU(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener fXs = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bBE();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(ae aeVar);

    protected abstract void b(ae aeVar);

    protected abstract void bAM();

    protected abstract View bAW();

    public abstract boolean bAX();

    protected abstract boolean bAY();

    protected abstract ViewGroup bAZ();

    public abstract boolean bAs();

    protected abstract ViewGroup bBa();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bc bcVar) {
        this.fWG = bcVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.fWJ = (RelativeLayout) bBT().gfT.findViewById(a.g.ala_live_header_view);
        this.fWK = (RelativeLayout) bBT().gfT.findViewById(a.g.ala_live_footer_view);
        zA();
        registerListener();
    }

    public void bBf() {
    }

    private void zA() {
        if (this.fVX == null) {
            this.fVX = new com.baidu.tieba.ala.liveroom.share.c(bBT().pageContext);
        }
        this.fWf = new com.baidu.tieba.ala.liveroom.w.a(bBT().pageContext, this);
        this.fWb = new com.baidu.tieba.ala.liveroom.b.b(bBT().pageContext, false);
        this.fWc = new com.baidu.tieba.ala.liveroom.praise.a(bBT().pageContext);
        this.fWd = new com.baidu.tieba.ala.liveroom.sticker.a(bBT().pageContext);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            boolean z = TbadkCoreApplication.getInst().isHaokan() && subappVersionName.startsWith("4.14.");
            if (TbadkCoreApplication.getInst().isQuanmin() && subappVersionName.startsWith("1.14.")) {
                z = true;
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            }
            if (z) {
                this.fWe = new com.baidu.tieba.ala.liveroom.guide.d(bBT().pageContext);
            }
        }
        this.fWn = new com.baidu.tieba.ala.liveroom.tippop.a(bBT().pageContext, this);
        bBh();
        bBj();
        bBk();
        bBl();
        bBp();
        bBq();
        bBr();
        bBg();
    }

    private void bBg() {
        CustomResponsedMessage runTask;
        if (this.fWt == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.j.b.class, bBT().pageContext)) != null && runTask.getData() != null) {
            this.fWt = (com.baidu.live.j.b) runTask.getData();
            this.fWt.d(bBT().pageContext);
            this.fWt.Fn().setTargetView(this.fWK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.fWI == null) {
            this.fWI = new com.baidu.tieba.ala.liveroom.e.a(bBT().pageContext);
            this.fWI.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.fWI.a(bBT().gfS.FU(), alaLastLiveroomInfo);
        this.fWI.aq(this.fWK);
    }

    private void bBh() {
        this.fWi = new o();
    }

    public void kE(boolean z) {
        this.fWM = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBi() {
        q FU = bBT().gfS.FU();
        boolean z = com.baidu.live.v.a.Hm().aZp.aAK;
        if (FU.mLiveInfo != null && FU.mLiveInfo.mAlaLiveSwitchData != null && FU.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = FU.axT ? z : false;
        if (z2) {
            if (this.fVW == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bBT().pageContext);
                if (runTask != null) {
                    this.fVW = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.fVW != null) {
                this.fVW.cz(1);
                View view = this.fVW.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bBT().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bBT().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.fWJ.addView(view, layoutParams);
                    if (z2) {
                        this.fVW.a(FU);
                    }
                }
            }
        }
    }

    private void bBj() {
        this.fWo = new com.baidu.tieba.ala.liveroom.guideim.b(bBT().pageContext);
        this.fWo.c(this.fWK, bAs());
        this.fWo.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.16
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean Dd() {
                return b.this.Bp();
            }
        });
    }

    private void bBk() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bBT().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fWp = (com.baidu.live.view.input.c) runTask.getData();
            this.fWp.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.17
                @Override // com.baidu.live.view.input.c.a
                public void KK() {
                    b.this.ro(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void KL() {
                    b.this.cI(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Dd() {
                    return b.this.Bp();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Ec() {
                    return b.this.bBn();
                }

                @Override // com.baidu.live.view.input.c.a
                public int Di() {
                    return b.this.bBo();
                }
            });
        }
    }

    private void bBl() {
        this.fWq = new com.baidu.tieba.ala.liveroom.l.a(this.fVT.pageContext);
        this.fWq.a(new a.InterfaceC0573a() { // from class: com.baidu.tieba.ala.liveroom.c.b.18
            @Override // com.baidu.tieba.ala.liveroom.l.a.InterfaceC0573a
            public boolean bBV() {
                return b.this.bAY();
            }

            @Override // com.baidu.tieba.ala.liveroom.l.a.InterfaceC0573a
            public void onClose() {
                if (b.this.aYR != null) {
                    b.this.aYR.bQ(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kF(boolean z) {
        if (this.fWo != null) {
            this.fWo.lc(z);
        }
        if (this.fWq != null) {
            this.fWq.lc(z);
        }
        fWW = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bBm() {
        return fWW;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bBn() {
        q FU;
        if (bBT() == null || bBT().gfS == null || (FU = bBT().gfS.FU()) == null || FU.axI == null) {
            return false;
        }
        String str = FU.axI.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bBo() {
        q FU;
        if (bBT() != null && bBT().gfS != null && (FU = bBT().gfS.FU()) != null && !ListUtils.isEmpty(FU.axN)) {
            for (AlaLiveMarkData alaLiveMarkData : FU.axN) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bBp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bBT().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.fWs = (com.baidu.live.guardclub.k) runTask.getData();
            this.fWs.setOtherParams(Ep());
        }
    }

    private void bBq() {
        this.fWy = new com.baidu.tieba.ala.liveroom.turntable.e(bBT().pageContext.getPageActivity());
    }

    private void bBr() {
        this.fWA = new com.baidu.tieba.ala.liveroom.o.c(bBT().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.fXg);
        MessageManager.getInstance().registerListener(this.fXh);
        MessageManager.getInstance().registerListener(this.fXj);
        MessageManager.getInstance().registerListener(this.fXc);
        MessageManager.getInstance().registerListener(this.fXd);
        MessageManager.getInstance().registerListener(this.fXb);
        MessageManager.getInstance().registerListener(this.fXf);
        MessageManager.getInstance().registerListener(this.fXe);
        MessageManager.getInstance().registerListener(this.fXk);
        MessageManager.getInstance().registerListener(this.fzr);
        MessageManager.getInstance().registerListener(this.fXl);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fIh);
        MessageManager.getInstance().registerListener(this.fIe);
        MessageManager.getInstance().registerListener(this.aVW);
        MessageManager.getInstance().registerListener(this.fXm);
        MessageManager.getInstance().registerListener(this.fXn);
        MessageManager.getInstance().registerListener(this.fXo);
        MessageManager.getInstance().registerListener(this.fXp);
        MessageManager.getInstance().registerListener(this.fXq);
        MessageManager.getInstance().registerListener(this.fXr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Bp() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bBT().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CH(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bBT().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bBT().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Hm().aZp.aAl;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bBT().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bBT().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bBT().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bBT().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBs() {
        if (this.fWj != null) {
            this.fWj.Db().a(this.fWp.DS(), t.yL().yN(), bBT().gfS.FU().mLiveInfo);
            kF(true);
            if (this.fWB == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, x.class, bBT().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.fWB = (x) runTask.getData();
                } else {
                    return;
                }
            }
            this.fWB.eZ("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBt() {
        if (this.fWj != null) {
            this.fWj.Db().hide();
            kF(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void L(int i, int i2, int i3) {
        if (bBT().gfS.FU() != null && bBT().gfS.FU().axp != null && bBT().gfS.FU().mLiveInfo != null) {
            a(bBT().gfS.FU(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.c.h.class) != null && Bp()) {
            if (qVar == null) {
                qVar = bBT().gfS.FU();
            }
            String valueOf = String.valueOf(qVar.axp.userId);
            String str = qVar.axp.userName;
            String valueOf2 = String.valueOf(qVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(qVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(qVar.mLiveInfo.feed_id);
            int i6 = qVar.axI.isBlock;
            String yU = v.yU();
            String str2 = qVar.mLiveInfo.appId;
            boolean z2 = qVar.axI.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (qVar.mLiveInfo.live_type == 1 && qVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.Hm().aZp.azo) {
                z3 = true;
            }
            int i7 = -1;
            if (qVar.axI == null) {
                z = false;
            } else {
                boolean z4 = qVar.axI.isNewUser;
                i7 = qVar.axI.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.fWQ != null && this.fWQ.aRm != null && this.fWQ.aRm.awn == qVar.axp.userId) {
                z5 = this.fWQ.aRp;
            }
            com.baidu.live.c.h hVar = new com.baidu.live.c.h(bBT().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, yU, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.mAlaLiveSwitchData != null) {
                hVar.aQ(qVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            hVar.aO(z);
            if (com.baidu.tieba.ala.liveroom.u.a.bJu().aZA != null) {
                hVar.aP(com.baidu.tieba.ala.liveroom.u.a.bJu().aZA.ayi != 1);
            }
            as Cj = g.Ch().Cj();
            if (Cj == null || Cj.aCl <= 0) {
                i5 = 1000;
            } else {
                i5 = Cj.aCl;
            }
            hVar.bJ(i5);
            boolean z6 = false;
            if (qVar != null && qVar.axI != null) {
                String str3 = qVar.axI.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            hVar.aR(z6);
            bb bbVar = com.baidu.live.v.a.Hm().bdV;
            if (TbadkCoreApplication.getInst().isMobileBaidu() || ((bbVar != null && bbVar.aCW != null && !bbVar.aCW.aER) || (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()))) {
                hVar.aS(false);
            } else {
                hVar.aS(true);
            }
            if (qVar != null && qVar.axK != null) {
                hVar.eo(qVar.axK.toJsonString());
            }
            if (!this.fWU) {
                this.fWV = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBu() {
        cI(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bh bhVar) {
        if (bhVar != null && Bp()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(bBT().pageContext.getPageActivity(), bhVar.aDC, bhVar.liveId, bhVar.aDD)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Hm().aZp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bBT().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Hm().aZp.aAL, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, NobleDetailInfo nobleDetailInfo) {
        if (Bp() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (qVar != null) {
                if (qVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(qVar.mLiveInfo.live_id));
                }
                if (qVar.axp != null) {
                    hashMap.put("anchor_id", Long.valueOf(qVar.axp.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.yU());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bBT().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bBv() {
        if (this.fWp != null) {
            this.fWp.c(this.fVT.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bBw() {
        q FU = bBT().gfS.FU();
        LogManager.getCommonLogger().doClickQuickImHiLog((FU == null || FU.mLiveInfo == null) ? "" : FU.mLiveInfo.feed_id, Ep());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void CI(String str) {
        if (this.fWp != null) {
            this.fWp.fc(str);
        }
    }

    private void bBx() {
        if ("home_rec_play".equals(bBT().fromType) || "frs_play".equals(bBT().fromType) || "frs_live_play".equals(bBT().fromType) || "person_play".equals(bBT().fromType) || "search".equals(bBT().fromType) || "person_attention".equals(bBT().fromType)) {
            com.baidu.live.b.ve().aM(true);
        } else {
            com.baidu.live.b.ve().aM(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kA(boolean z) {
        View yy;
        if (this.fWl == null) {
            f fVar = new f();
            fVar.aGc = false;
            fVar.context = bBT().pageContext.getPageActivity();
            fVar.aGl = z;
            fVar.fromType = bBT().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fWl = (w) runTask.getData();
            }
        }
        if (this.fWl != null && (yy = this.fWl.yy()) != null && this.fVT.gfT.indexOfChild(yy) < 0) {
            this.fVT.gfT.addView(yy, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBy() {
        View yX;
        if (this.fWw == null) {
            ab abVar = new ab();
            abVar.aGc = false;
            abVar.pageContext = bBT().pageContext;
            abVar.fromType = bBT().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.fWw = (y) runTask.getData();
            }
        }
        if (this.fWw != null && (yX = this.fWw.yX()) != null && bBT().gfT.indexOfChild(yX) < 0) {
            if (yX.getParent() instanceof ViewGroup) {
                ((ViewGroup) yX.getParent()).removeView(yX);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bBT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bBT().gfT.addView(yX, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBz() {
        View yQ;
        if (this.fWm == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aGc = false;
            aVar.context = bBT().pageContext.getPageActivity();
            aVar.fromType = bBT().fromType;
            aVar.aGd = bBT().gfX;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fWm = (u) runTask.getData();
            }
        }
        if (this.fWm != null && (yQ = this.fWm.yQ()) != null && bBT().gfT.indexOfChild(yQ) < 0) {
            if (yQ.getParent() instanceof ViewGroup) {
                ((ViewGroup) yQ.getParent()).removeView(yQ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bBT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bBT().gfT.addView(yQ, layoutParams);
        }
    }

    private void bBA() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bBB() {
        CustomResponsedMessage runTask;
        if (this.fWk == null && (runTask = MessageManager.getInstance().runTask(2913099, l.class, bBT().pageContext)) != null) {
            this.fWk = (l) runTask.getData();
        }
        if (this.fWk != null) {
            this.fWk.setOtherParams(this.otherParams);
            this.fWk.a(new l.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.21
                @Override // com.baidu.live.im.l.a
                public void Dl() {
                    b.this.bBE();
                }
            });
            this.fWk.a(bBT().gfS.FU(), false);
            View Dj = this.fWk.Dj();
            if (Dj != null && this.fWK.indexOfChild(Dj) < 0) {
                Resources resources = bBT().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bBT().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.fWK.addView(Dj, layoutParams);
            }
        }
    }

    private void bBC() {
        if (this.fWh == null) {
            this.fWh = new com.baidu.tieba.ala.liveroom.g.a(bBT().pageContext);
        }
        if (this.fWP != null) {
            this.fWh.CL(this.fWP.user_id);
        }
        this.fWh.aq(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void kG(boolean z) {
        CustomResponsedMessage runTask;
        if (bBT() != null && !z && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bBT().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fWE = (com.baidu.live.i.a) runTask.getData();
            this.fWE.a(bBa(), bBL());
            if (bBT().gfS != null) {
                this.fWE.a(bBT().gfS.FU());
            }
            this.fWE.setCanVisible(true);
            this.fWE.bC(true);
            this.fWE.a(bBT().gfS.bwe());
        }
    }

    private void bBD() {
        if (this.fWu == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bBT().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fWu = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bBT().gfS.FU() != null && bBT().gfS.FU().axp != null && bBT().gfS.FU().mLiveInfo != null) {
            this.fWu.setHost(false);
            this.fWu.setOtherParams(Ep());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bBT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.fWu.a(this.fWJ, layoutParams, bBT().gfS.FU());
            this.fWu.a(new com.baidu.live.guardclub.l() { // from class: com.baidu.tieba.ala.liveroom.c.b.22
                @Override // com.baidu.live.guardclub.l
                public void Cn() {
                    b.this.bBU();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:206:0x0674, code lost:
        CE(r32);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long j;
        long j2;
        JSONObject jSONObject4;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject4 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(aVar.getContent());
            }
        } catch (JSONException e) {
            jSONObject = null;
        }
        try {
            String optString = jSONObject4.optString("ext");
            if (!TextUtils.isEmpty(optString)) {
                new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
            }
            jSONObject3 = jSONObject4.optJSONObject("ext_data");
            jSONObject2 = jSONObject4;
        } catch (JSONException e2) {
            jSONObject = jSONObject4;
            jSONObject2 = jSONObject;
            jSONObject3 = null;
            if (aVar.getMsgType() != 12) {
            }
            if (jSONObject2 == null) {
            }
        }
        if (aVar.getMsgType() != 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.aYR != null) {
                        this.aYR.bS(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        rq(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bBT().gfS.FU().axI.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bBT().gfS.FU().axI.isAdmin = 0;
                            bBT().gfS.bIr();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bBT().gfS.FU().axI.isAdmin = 0;
                        bBT().gfS.bIr();
                    }
                } else if ("task".equals(optString2)) {
                    dd(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.fWn != null && !bBT().gfW) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bBT().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bBT().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bBT().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bxv()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.fWn.a(bBT().gfR.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.24
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.aYR != null) {
                                b.this.aYR.bR(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bBT().gfS.FU() != null && bBT().gfS.FU().mLiveInfo != null) {
                        String str2 = bBT().gfS.FU().mLiveInfo.feed_id;
                        long j3 = bBT().gfS.FU().mLiveInfo.live_id;
                        long j4 = bBT().gfS.FU().axp.userId;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!m.i(j3, optLong2)) {
                            if (this.fWt != null) {
                                this.fWt.a(str2, j3, false, false, j4);
                            }
                            m.j(j3, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.r.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bBT().gfS.FU() != null && bBT().gfS.FU().axI != null && bBT().gfS.FU().axI.userId == optLong3) {
                        bBT().gfS.FU().axI.isBlock = 1;
                        bAM();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bBT().gfS.FU() != null && bBT().gfS.FU().axI != null && bBT().gfS.FU().axI.userId == optLong4) {
                        bBT().gfS.FU().axI.isBlock = 0;
                        bAM();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bBT().gfS.FU() != null && bBT().gfS.FU().axI != null && bBT().gfS.FU().axI.userId == optLong5) {
                        bBT().gfS.FU().axI.isUegBlock = 1;
                        bAM();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (bBT().gfS.FU() != null && bBT().gfS.FU().axI != null && bBT().gfS.FU().axI.userId == optLong6) {
                        bBT().gfS.FU().axI.isUegBlock = 0;
                        bAM();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bBT() != null && bBT().gfS != null && bBT().gfS.FU() != null && bBT().gfS.FU().axI != null) {
                        if (bBT().gfS.FU().axI.userId == jSONObject2.optLong("user_id")) {
                            bBT().gfS.bIr();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bBT().gfS.FU().axI));
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong7 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str3 = optLong7 + "";
                        TbadkCoreApplication.getInst();
                        if (str3.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                } else if ("privilege_award_royal_success".equals(optString2)) {
                    String str4 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a Ed = aVar.Ed();
                    if (Ed != null && v.eX(str4)) {
                        v.d(str4, 1L, "", "", Ed.userId, Ed.portrait, Ed.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        an anVar = new an();
                        anVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, anVar));
                    }
                } else if (TextUtils.equals(optString2, "challenge_mvp_punish") && jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.fWf != null) {
                this.fWf.A(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a Ed2 = aVar.Ed();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong8 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            long j5 = 0;
            String str5 = null;
            if (bBT().gfS == null || bBT().gfS.FU() == null || bBT().gfS.FU().mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                long j6 = bBT().gfS.FU().mLiveInfo.live_id;
                j5 = bBT().gfS.FU().mLiveInfo.group_id;
                long j7 = bBT().gfS.FU().axp.userId;
                str5 = bBT().gfS.FU().mLiveInfo.appId;
                j = j7;
                j2 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    v.b(optString9, Ed2.userId, Ed2.portrait, Ed2.getNameShow(), String.valueOf(j2), String.valueOf(j5), false, String.valueOf(j), str5, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.v.d.Ht().fK(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                    break;
                                }
                                i++;
                            }
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                v.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, Ed2.userId, Ed2.portrait, Ed2.getNameShow(), String.valueOf(j2), String.valueOf(j5), false, String.valueOf(j), str5, optString7, "", "", aVar.getMsgId());
                CE(optString3);
            }
            com.baidu.tieba.ala.liveroom.f.d dVar = new com.baidu.tieba.ala.liveroom.f.d();
            dVar.gfx = optLong8;
            dVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
        }
    }

    protected void CE(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bBE() {
        if (bBF()) {
            BdUtilHelper.hideSoftKeyPad(bBT().pageContext.getPageActivity(), bBT().gfR.getLiveContainerView());
            bAX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bBF() {
        if (bAW() == null || bAW().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(q qVar) {
        CustomResponsedMessage runTask;
        bBT().gfT.setOnTouchListener(this.fXs);
        bBM();
        bBN();
        bBO();
        bBA();
        bBC();
        bBD();
        if (this.fWd != null && bBT().gfS.FU() != null && bBT().gfS.FU().mLiveInfo != null) {
            this.fWd.bW(bBT().gfS.FU().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.fWi != null) {
            this.fWi.g(bBT().gfS.FU());
        }
        if (this.fWo != null) {
            this.fWo.c(bBT().gfS.FU(), Ep());
        }
        if (this.fWp != null) {
            this.fWp.a(bBT().gfS.FU(), Ep());
        }
        if (this.fWq != null) {
            this.fWq.c(bBT().gfS.FU(), Ep());
        }
        if (bBT().gfT != null) {
            bBT().gfT.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.26
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean A = b.this.A(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bBF() && b.this.fWc != null) {
                        b.this.fWc.lt(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.fWc != null) {
                        b.this.fWc.lt(true);
                    }
                    return A;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean FR() {
                    if (b.this.fXa == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.fXa) {
                        if (bVar.FR()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bBT().gfT.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.c.b.27
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.z(motionEvent);
                }
            });
        }
        if (this.fWB == null && (runTask = MessageManager.getInstance().runTask(2913165, x.class, bBT().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fWB = (x) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBG() {
        q FU;
        ViewGroup viewGroup;
        if (bBT() != null && bBT().gfS != null && (FU = bBT().gfS.FU()) != null && FU.mLiveInfo != null && !FU.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bBT().gfR) != null) {
            if (this.fWF == null) {
                this.fWF = new com.baidu.tieba.ala.liveroom.recommend.a(bBT().pageContext);
            }
            this.fWF.t(FU);
            this.fWF.a(bBT().gfT);
            this.fWF.aq(viewGroup);
            a((com.baidu.live.liveroom.g.d) this.fWF);
            a((com.baidu.live.liveroom.g.b) this.fWF);
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.fWZ == null) {
            this.fWZ = new ArrayList();
        }
        if (!this.fWZ.contains(dVar)) {
            this.fWZ.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.fWZ != null && this.fWZ.contains(dVar)) {
            this.fWZ.remove(dVar);
        }
    }

    protected void bBH() {
        if (this.fWZ != null) {
            this.fWZ.clear();
            this.fWZ = null;
        }
    }

    protected boolean z(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fWZ == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.fWZ.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().onTouchEvent(motionEvent);
            if (z2 || !z) {
                z = z2;
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.b bVar) {
        if (this.fXa == null) {
            this.fXa = new ArrayList();
        }
        if (!this.fXa.contains(bVar)) {
            this.fXa.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.fXa != null && this.fXa.contains(bVar)) {
            this.fXa.remove(bVar);
        }
    }

    protected void bBI() {
        if (this.fXa != null) {
            this.fXa.clear();
            this.fXa = null;
        }
    }

    protected boolean A(MotionEvent motionEvent) {
        boolean z = false;
        if (this.fXa == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.fXa.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return z2;
            }
            z = it.next().dispatchTouchEvent(motionEvent);
            if (z2 || !z) {
                z = z2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBJ() {
        if (this.fWD == null && this.fWG != null && this.fWG.aDg && bBT() != null && bBT().gfS != null && bBT().gfS.FU() != null) {
            this.fWD = new e(bBT().pageContext, this.fWG);
            this.fWD.s(bBT().gfS.FU());
            if (this.fWG.aDj == 1) {
                if (this.fWj != null) {
                    this.fWS = true;
                }
            } else if (this.fWG.aDj == 2) {
                a(bBT().gfS.FU(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBK() {
        CustomResponsedMessage runTask;
        if (bBT() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bBT().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.r.a)) {
            this.fWH = (com.baidu.live.r.a) runTask.getData();
            this.fWH.n(bAZ());
            if (bBT().gfS != null) {
                this.fWT = this.fWH.o(bBT().gfS.FU());
            }
            this.fWH.setCanVisible(!this.fWN);
        }
    }

    private ViewGroup.LayoutParams bBL() {
        int dimensionPixelOffset;
        if (bAs()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bBT().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bBT().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bBT().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int F(boolean z, boolean z2) {
        Rect rect = new Rect();
        bBT().gfR.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bBT().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bBT().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bBT().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bBT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bBT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bBT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bBM() {
        if (this.fWc != null) {
            this.fWc.ax(bBT().gfT);
        }
    }

    private void bBN() {
        if (this.fWd != null) {
            this.fWd.aB(bBT().gfT);
        }
    }

    private void bBO() {
        if (this.fWg == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.fWg = (com.baidu.live.x.a) runTask.getData();
            }
            bBP();
        }
    }

    private void dd(JSONObject jSONObject) {
        if (this.fWg != null) {
            if (this.fVZ != null) {
                this.fWg.cd(this.fVZ.bEX() ? false : true);
            } else {
                this.fWg.cd(true);
            }
            this.fWg.L(jSONObject);
        }
    }

    private void bBP() {
        if (this.fWg != null && bBT().gfS.FU() != null && bBT().gfS.FU().axS != null) {
            if (this.fVZ != null) {
                this.fWg.cd(this.fVZ.bEX() ? false : true);
            } else {
                this.fWg.cd(true);
            }
            this.fWg.a(bBT().gfS.FU().axS);
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(q qVar) {
        if (qVar != null) {
            if (this.fWd != null && qVar.mLiveInfo != null) {
                this.fWd.bW(qVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.fWt != null) {
                this.fWt.i(qVar);
            }
            bBP();
            if (this.fWh != null && qVar.axp != null) {
                this.fWh.CL(String.valueOf(qVar.axp.userId));
            }
            if (this.fVW != null) {
                this.fVW.a(qVar);
            }
            if (this.fWm != null && qVar.mLiveInfo != null) {
                this.fWm.a(qVar.mLiveInfo, qVar.axp);
            }
            if (this.fWk != null) {
                this.fWk.a(qVar);
            }
            if (this.fWH != null) {
                this.fWT = this.fWH.o(qVar);
            }
            if (this.fWE != null) {
                this.fWE.a(qVar);
            }
            rq(qVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void rq(int i) {
        if (!bBT().gfW) {
            if (this.fWL < 0 && i == 0) {
                this.fWL = i;
            } else if (this.fWL != i) {
                if (i == 1) {
                    if (!this.fWn.rZ(2)) {
                        String string = bBT().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bBT().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.fWn.a(bBT().gfR.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bBT().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.fWn.sa(2);
                    this.fWn.sa(3);
                    if (bxv()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.fWn.a(bBT().gfR.getLiveContainerView(), string2, 3);
                    }
                }
                this.fWL = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bU(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.bU(z);
        if (z) {
            bBQ();
        }
        if (this.fWt != null) {
            this.fWt.Fo();
        }
        if (this.fWf != null) {
            this.fWf.bKE();
        }
        if (this.fVX != null) {
            this.fVX.vH();
        }
        if (this.fVZ != null) {
            this.fVZ.onDestroy();
        }
        if (this.fWg != null) {
            this.fWg.onDestroy();
            this.fWg = null;
        }
        if (this.fWl != null) {
            View yy = this.fWl.yy();
            if (yy != null && yy.getParent() != null) {
                ((ViewGroup) yy.getParent()).removeView(yy);
            }
            this.fWl.onDestroy();
            this.fWl = null;
        }
        if (this.fWk != null) {
            this.fWk.a((l.a) null);
            this.fWk.Cz();
        }
        if (this.fVV != null) {
            this.fVV.vH();
        }
        if (this.fWn != null) {
            this.fWn.vH();
        }
        this.fWL = -1;
        if (this.fWh != null) {
            this.fWh.vH();
            this.fWh.onDestroy();
        }
        if (this.fWa != null) {
            this.fWa.bKB();
        }
        if (this.fWb != null) {
            this.fWb.bAm();
            this.fWb.yW();
        }
        if (this.fWc != null) {
            this.fWc.yW();
        }
        if (this.fWi != null) {
            this.fWi.yW();
        }
        if (this.fWo != null) {
            this.fWo.Fo();
        }
        if (this.fWp != null) {
            this.fWp.yW();
        }
        if (this.fWq != null) {
            this.fWq.onDestroy();
        }
        if (this.fWs != null) {
            this.fWs.onDestory();
        }
        if (this.fWv != null) {
            this.fWv.Cl();
        }
        if (this.fWu != null) {
            this.fWu.Cl();
        }
        if (this.fWD != null) {
            this.fWD.onDestroy();
        }
        if (this.fWy != null) {
            this.fWy.yW();
        }
        if (this.fWz != null) {
            this.fWz.yW();
        }
        if (this.fWB != null) {
            this.fWB.yW();
        }
        if (this.fVY != null) {
            this.fVY.onDestory();
        }
        if (this.fWH != null) {
            this.fWH.yW();
        }
        if (this.fWE != null) {
            this.fWE.Cl();
        }
        if (this.fWA != null) {
            this.fWA.yW();
        }
        if (this.fWw != null) {
            this.fWw.onDestroy();
        }
        if (this.fWF != null) {
            this.fWF.vH();
            b((com.baidu.live.liveroom.g.d) this.fWF);
            b((com.baidu.live.liveroom.g.b) this.fWF);
        }
        ShowUtil.windowCount = 0;
        bBH();
        bBI();
    }

    private void bBQ() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bBT().gfT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bBT().gfT.getChildAt(i);
            if (childAt != this.fWJ && childAt != this.fWK) {
                linkedList.add(childAt);
            }
        }
        for (View view : linkedList) {
            if (view != null) {
                try {
                    if (view.getParent() instanceof ViewGroup) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                } catch (NullPointerException e) {
                }
            }
        }
        if (this.fWJ != null) {
            this.fWJ.removeAllViews();
        }
        if (this.fWK != null) {
            this.fWK.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, q qVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(q qVar) {
        View Dj;
        View yy;
        if (this.fWl != null && (yy = this.fWl.yy()) != null && yy.getParent() != null) {
            ((ViewGroup) yy.getParent()).removeView(yy);
        }
        if (this.fWk != null && (Dj = this.fWk.Dj()) != null && Dj.getParent() != null) {
            ((ViewGroup) Dj.getParent()).removeView(Dj);
        }
        if (this.fVZ != null) {
            this.fVZ.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean FO() {
        if (this.fWe == null || !this.fWe.bFc()) {
            if (this.fVZ == null || !this.fVZ.at(bBT().gfR.getLiveContainerView())) {
                if (this.fWc != null) {
                    this.fWc.bye();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.fWr != null && this.fWr.bEL()) {
                    this.fWr.bEU();
                    return false;
                } else if (this.fWq == null || !this.fWq.bFf()) {
                    bBx();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void bT(boolean z) {
        super.bT(z);
        if (this.fWt != null) {
            this.fWt.release();
        }
        if (this.fWC != null) {
            this.fWC.destroy();
        }
        if (this.fWg != null) {
            this.fWg.onDestroy();
            this.fWg = null;
        }
        if (this.fWf != null) {
            this.fWf.bKE();
        }
        if (this.fWl != null) {
            this.fWl.onDestroy();
            this.fWl = null;
        }
        if (this.fWm != null) {
            this.fWm.onDestroy();
            this.fWm = null;
        }
        if (this.fWn != null) {
            this.fWn.onDestroy();
        }
        if (this.fVV != null) {
            this.fVV.onDestroy();
        }
        if (this.fVX != null) {
            this.fVX.onDestroy();
        }
        if (this.fWw != null) {
            this.fWw.onDestroy();
            this.fWw = null;
        }
        if (this.fWk != null) {
            this.fWk.a((l.a) null);
            this.fWk.release();
            this.fWk = null;
        }
        if (this.fWo != null) {
            this.fWo.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.fWo.release();
        }
        if (this.fWp != null) {
            this.fWp.a(null);
            this.fWp.release();
        }
        if (this.fWq != null) {
            this.fWq.a((a.InterfaceC0573a) null);
            this.fWq.onDestroy();
        }
        if (this.fWu != null) {
            this.fWu.onDestroy();
        }
        if (this.fWv != null) {
            this.fWv.onDestroy();
        }
        if (this.fWs != null) {
            this.fWs.onDestory();
        }
        if (this.fWD != null) {
            this.fWD.onDestroy();
        }
        if (this.fWy != null) {
            this.fWy.release();
        }
        if (this.fWA != null) {
            this.fWA.release();
        }
        if (this.fWz != null) {
            this.fWz.release();
        }
        if (this.fWB != null) {
            this.fWB.release();
        }
        if (this.fVY != null) {
            this.fVY.onDestory();
        }
        if (this.fWH != null) {
            this.fWH.release();
        }
        if (this.fWE != null) {
            this.fWE.onDestroy();
        }
        if (this.fWc != null) {
            this.fWc.yW();
        }
        if (this.fWF != null) {
            this.fWF.onDestroy();
            b((com.baidu.live.liveroom.g.d) this.fWF);
            b((com.baidu.live.liveroom.g.b) this.fWF);
        }
        bBH();
        bBI();
        MessageManager.getInstance().unRegisterListener(this.fXq);
        MessageManager.getInstance().unRegisterListener(this.fXg);
        MessageManager.getInstance().unRegisterListener(this.fXh);
        MessageManager.getInstance().unRegisterListener(this.fXj);
        MessageManager.getInstance().unRegisterListener(this.fXc);
        MessageManager.getInstance().unRegisterListener(this.fXd);
        MessageManager.getInstance().unRegisterListener(this.fXb);
        MessageManager.getInstance().unRegisterListener(this.fXf);
        MessageManager.getInstance().unRegisterListener(this.fXe);
        MessageManager.getInstance().unRegisterListener(this.fXk);
        MessageManager.getInstance().unRegisterListener(this.fzr);
        MessageManager.getInstance().unRegisterListener(this.fXl);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fIh);
        MessageManager.getInstance().unRegisterListener(this.fIe);
        MessageManager.getInstance().unRegisterListener(this.aVW);
        MessageManager.getInstance().unRegisterListener(this.fXm);
        MessageManager.getInstance().unRegisterListener(this.fXn);
        MessageManager.getInstance().unRegisterListener(this.fXo);
        MessageManager.getInstance().unRegisterListener(this.fXp);
        MessageManager.getInstance().unRegisterListener(this.fXr);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.fWo != null) {
            this.fWo.lb(false);
        }
        if (this.fWq != null) {
            this.fWq.lb(false);
        }
        bAX();
        if (this.fWt != null) {
            this.fWt.onPause();
        }
        if (this.fWy != null) {
            this.fWy.pause();
        }
        if (this.fWA != null) {
            this.fWA.pause();
        }
        if (this.fWw != null) {
            this.fWw.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.fWV = false;
        if (this.fWO && this.fWP != null) {
            a(this.fWP);
            this.fWO = false;
        }
        if (this.fWo != null) {
            this.fWo.lb(true);
        }
        if (this.fWq != null) {
            this.fWq.lb(true);
        }
        if (this.fWt != null) {
            this.fWt.onResume();
        }
        if (this.fWy != null) {
            this.fWy.resume();
        }
        if (this.fWA != null) {
            this.fWA.resume();
        }
        if (this.fWw != null) {
            this.fWw.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bBR() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.fWF != null && this.fWF.isOpen()) {
            this.fWF.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bBR();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    L(-1, -1, -1);
                    return;
                }
                return;
            }
            bBR();
        } else if (i == 25027) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    L(-1, intent.getIntExtra("custom_category_id", -1), -1);
                    return;
                }
                return;
            }
            bBR();
        } else if (i == 25034) {
            bBu();
        } else if (i == 25043) {
            if (i2 == -1) {
                bBU();
            }
        } else if (i == 25050 && this.fWC != null) {
            if (i2 == -1) {
                this.fWC.N(intent);
            } else {
                this.fWC.N(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.fWN = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bBS() {
        return (bBT().gfS.FU() == null || bBT().gfS.FU().mLiveInfo == null || bBT().gfS.FU().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.fVZ != null) {
                this.fVZ.bt(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.fWq != null) {
            this.fWq.aOF();
        }
        if (this.fVY != null) {
            this.fVY.aOF();
        }
        if (this.fWF != null) {
            this.fWF.bt(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.fVT = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bBT() {
        return this.fVT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBU() {
        String Ci = g.Ch().Ci();
        if (!TextUtils.isEmpty(Ci)) {
            try {
                L(-1, Integer.parseInt(Ci), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                L(-1, -1, -1);
            }
        }
    }

    public boolean cG(int i) {
        if (7 == i) {
            if (this.fWl != null) {
                this.fWl.bb(true);
            }
            if (this.fVV != null) {
                this.fVV.bAn();
            }
        } else if (1 == i) {
            if (bAW() != null) {
                bAW().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.fWN) {
                return false;
            }
            if (this.fVZ == null || !this.fVZ.bEX()) {
                return this.fVV == null || this.fVV.bAp();
            }
            return false;
        } else if (3 == i) {
            if (bBT().gfT != null) {
                bBT().gfT.setEnabled(false);
                if (this.aYR != null) {
                    this.aYR.e(!bBT().gfU, false);
                }
                return true;
            }
            return false;
        } else if (9 == i) {
            return this.fVV == null || !this.fVV.isShowing();
        }
        return true;
    }

    public void ro(int i) {
        if ((i == 7 || i == 11) && this.fVV != null) {
            this.fVV.bAn();
            this.fVV.ky(false);
        }
    }

    public void cH(int i) {
    }

    public void cI(int i) {
        if (7 == i) {
            if (this.fWl != null) {
                this.fWl.bb(false);
            }
            if (this.fVV != null) {
                this.fVV.ky(true);
            }
        } else if (11 == i) {
            if (this.fVV != null) {
                this.fVV.ky(true);
            }
        } else if (3 == i) {
            bBT().gfT.setEnabled(true);
            if (this.aYR != null) {
                this.aYR.e(bBT().gfU ? false : true, true);
            }
            if (this.fWg != null) {
                this.fWg.cd(true);
            }
        } else if (2 == i && this.fWf != null) {
            this.fWf.lC(true);
        }
    }

    public String Ep() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.fWk != null) {
            this.fWk.setOtherParams(str);
        }
        if (this.fWt != null) {
            this.fWt.fB(str);
        }
    }

    private boolean bxv() {
        return bBT().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fgP = alaLastLiveroomInfo;
    }

    public void a(ar arVar, AlaLiveInfoData alaLiveInfoData) {
        if (arVar != null && arVar.eventType == 1001 && this.fWt != null) {
            this.fWt.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, false, false, alaLiveInfoData.user_id);
        }
    }
}
