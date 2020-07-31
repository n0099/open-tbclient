package com.baidu.tieba.ala.liveroom.d;

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
import com.baidu.live.c.i;
import com.baidu.live.c.s;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.af;
import com.baidu.live.data.ao;
import com.baidu.live.data.as;
import com.baidu.live.data.at;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
import com.baidu.live.data.bi;
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
import com.baidu.live.guardclub.l;
import com.baidu.live.im.b.a;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.noble.data.NobleDetailInfo;
import com.baidu.live.o.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
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
import com.baidu.live.utils.p;
import com.baidu.live.view.input.c;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.liveroom.m.a;
import com.baidu.tieba.ala.liveroom.turntable.e;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    public static boolean gcb;
    protected AlaLastLiveroomInfo flX;
    private com.baidu.tieba.ala.liveroom.data.a gaY;
    protected com.baidu.tieba.ala.liveroom.operation.a gaZ;
    protected j gbA;
    protected y gbB;
    protected e gbD;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gbE;
    protected com.baidu.tieba.ala.liveroom.p.c gbF;
    private x gbG;
    protected com.baidu.tieba.ala.liveroom.u.a gbH;
    protected com.baidu.tieba.ala.liveroom.h.e gbI;
    protected com.baidu.live.i.a gbJ;
    protected com.baidu.tieba.ala.liveroom.recommend.a gbK;
    protected bd gbL;
    protected com.baidu.live.r.a gbM;
    protected com.baidu.tieba.ala.liveroom.f.a gbN;
    protected RelativeLayout gbO;
    protected RelativeLayout gbP;
    protected boolean gbR;
    protected af gbU;
    protected GuardClubInfoHttpResponseMessage gbV;
    boolean gbW;
    boolean gbX;
    boolean gbY;
    public boolean gbZ;
    protected com.baidu.live.h.a gba;
    protected com.baidu.tieba.ala.liveroom.share.c gbb;
    protected com.baidu.tieba.ala.liveroom.q.b gbc;
    protected com.baidu.tieba.ala.liveroom.guide.c gbd;
    protected com.baidu.tieba.ala.liveroom.watermark.a gbe;
    protected com.baidu.tieba.ala.liveroom.b.b gbf;
    protected com.baidu.tieba.ala.liveroom.praise.a gbg;
    protected com.baidu.tieba.ala.liveroom.sticker.a gbh;
    protected com.baidu.tieba.ala.liveroom.guide.d gbi;
    protected com.baidu.tieba.ala.liveroom.w.a gbj;
    protected com.baidu.live.x.a gbk;
    protected com.baidu.live.x.d gbl;
    private com.baidu.tieba.ala.liveroom.h.a gbm;
    private m gbn;
    k gbo;
    com.baidu.live.im.b.a gbp;
    protected w gbq;
    protected u gbr;
    protected com.baidu.tieba.ala.liveroom.tippop.a gbs;
    private com.baidu.tieba.ala.liveroom.guideim.b gbt;
    protected com.baidu.live.view.input.c gbu;
    com.baidu.tieba.ala.liveroom.m.a gbv;
    protected com.baidu.tieba.ala.liveroom.guide.a gbw;
    private com.baidu.live.guardclub.k gbx;
    protected com.baidu.live.j.b gby;
    protected h gbz;
    public boolean gca;
    protected com.baidu.tieba.ala.liveroom.s.b gcc;
    protected com.baidu.tieba.ala.liveroom.j.e gcd;
    protected List<com.baidu.live.liveroom.g.d> gce;
    protected List<com.baidu.live.liveroom.g.b> gcf;
    protected String otherParams;
    private int gbC = 0;
    private int gbQ = -1;
    protected int mOrientation = 0;
    protected boolean gbS = false;
    protected boolean gbT = false;
    private CustomMessageListener gcg = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.w wVar;
            if ((customResponsedMessage.getData() instanceof com.baidu.live.data.w) && (wVar = (com.baidu.live.data.w) customResponsedMessage.getData()) != null) {
                b.this.a(wVar.azr, wVar.azn, wVar.azo, wVar.azp, wVar.azq);
            }
        }
    };
    private CustomMessageListener gch = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.rE(7);
        }
    };
    private CustomMessageListener gci = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bEG();
        }
    };
    private CustomMessageListener gcj = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.28
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bFe().gla.FO().ayC.userId);
            com.baidu.live.view.a.KF().a(valueOf, new com.baidu.live.data.d(b.this.bFe().gla.FO().ayC.portrait, valueOf, true, b.this.bFe().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gck = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.29
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof q) && b.this.gbb != null) {
                b.this.gbb.c((q) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bbz = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gbo != null) {
                b.this.gbo.g(t.zn().zp());
            }
        }
    };
    private CustomMessageListener gcl = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gaY.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.Dt(str);
            }
        }
    };
    private CustomMessageListener gcm = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bFe().pageContext.getPageActivity());
            } else if (b.this.gbb != null) {
                b.this.gbb.c(b.this.bFe().gla.FO(), false);
            }
        }
    };
    private CustomMessageListener gcn = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof af) {
                    b.this.gbT = true;
                    b.this.gbU = (af) data;
                    b.this.b(b.this.gbU);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gco = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bFe().gla.FO().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bFe().gla.FO().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bFe().gla.FO().ayC.userId);
                    if (b.this.gbc == null) {
                        b.this.gbc = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    b.this.gbc.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gbc.a(b.this.gcp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.InterfaceC0175b gcp = new b.InterfaceC0175b() { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        @Override // com.baidu.live.o.b.InterfaceC0175b
        public void Gs() {
            if (b.this.bFe().gla.FO() != null && b.this.bFe().gla.FO().ayV != null) {
                b.this.bFe().gla.FO().ayV.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener gcq = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gby != null) {
                    b.this.gby.x(aVar);
                }
                b.this.r(aVar);
            }
        }
    };
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.5
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
    CustomMessageListener gcr = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.gbW = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gbv != null) {
                b.this.gbv.zA();
            }
        }
    };
    HttpMessageListener fNC = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aSF) != null && b.this.gbx != null && b.this.bFe() != null && b.this.bFe().gla != null) {
                int[] iArr = new int[2];
                b.this.gbO.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gbx.a(b.this.gbO, layoutParams, aVar, b.this.bFe().gla.FO());
                com.baidu.live.m.a.au(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fNz = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bFe() != null && b.this.bFe().gla != null && b.this.bFe().gla.FO() != null && guardClubInfoHttpResponseMessage.aSF != null) {
                    if (guardClubInfoHttpResponseMessage.aSF.axs == b.this.bFe().gla.FO().ayC.userId) {
                        b.this.gbV = guardClubInfoHttpResponseMessage;
                        if (b.this.gbV.aSI && com.baidu.live.guardclub.e.CI() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.CI().ag(b.this.bFe().gla.FO().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gcs = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bi) {
                b.this.a((bi) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gct = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.q(b.this.bFe().gla.FO());
        }
    };
    private CustomMessageListener gcu = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gbJ != null) {
                b.this.gbJ.CQ();
            }
        }
    };
    private CustomMessageListener gcv = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gbB != null) {
                    ((com.baidu.tieba.ala.liveroom.p.b) b.this.gbB).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gcw = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bFe().gla.FO(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener gcx = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bEP();
                return false;
            }
            return false;
        }
    };

    protected abstract void a(af afVar);

    protected abstract void b(af afVar);

    public abstract boolean bDD();

    protected abstract void bDX();

    protected abstract View bEh();

    public abstract boolean bEi();

    protected abstract boolean bEj();

    protected abstract ViewGroup bEk();

    protected abstract ViewGroup bEl();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bd bdVar) {
        this.gbL = bdVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gbO = (RelativeLayout) bFe().glb.findViewById(a.g.ala_live_header_view);
        this.gbP = (RelativeLayout) bFe().glb.findViewById(a.g.ala_live_footer_view);
        Ac();
        registerListener();
    }

    public void bEq() {
    }

    private void Ac() {
        if (this.gbb == null) {
            this.gbb = new com.baidu.tieba.ala.liveroom.share.c(bFe().pageContext);
        }
        this.gbj = new com.baidu.tieba.ala.liveroom.w.a(bFe().pageContext, this);
        this.gbf = new com.baidu.tieba.ala.liveroom.b.b(bFe().pageContext, false);
        this.gbg = new com.baidu.tieba.ala.liveroom.praise.a(bFe().pageContext);
        this.gbh = new com.baidu.tieba.ala.liveroom.sticker.a(bFe().pageContext);
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
                this.gbi = new com.baidu.tieba.ala.liveroom.guide.d(bFe().pageContext);
            }
        }
        this.gbs = new com.baidu.tieba.ala.liveroom.tippop.a(bFe().pageContext, this);
        bEt();
        bEv();
        bEw();
        bEx();
        bEB();
        bEC();
        bED();
        bEs();
        bEr();
    }

    private void bEr() {
        CustomResponsedMessage runTask;
        if (this.gbl == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.x.d.class, bFe().pageContext)) != null && runTask.getData() != null) {
            this.gbl = (com.baidu.live.x.d) runTask.getData();
        }
    }

    private void bEs() {
        CustomResponsedMessage runTask;
        if (this.gby == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.j.b.class, bFe().pageContext)) != null && runTask.getData() != null) {
            this.gby = (com.baidu.live.j.b) runTask.getData();
            this.gby.c(bFe().pageContext);
            this.gby.Fh().setTargetView(this.gbP);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.gbN == null) {
            this.gbN = new com.baidu.tieba.ala.liveroom.f.a(bFe().pageContext);
            this.gbN.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.gbN.a(bFe().gla.FO(), alaLastLiveroomInfo);
        this.gbN.ar(this.gbP);
    }

    private void bEt() {
        this.gbn = new m();
    }

    public void lh(boolean z) {
        this.gbR = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEu() {
        q FO = bFe().gla.FO();
        boolean z = com.baidu.live.v.a.Hs().aZn.aBX;
        if (FO.mLiveInfo != null && FO.mLiveInfo.mAlaLiveSwitchData != null && FO.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = FO.azg ? z : false;
        if (z2) {
            if (this.gba == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bFe().pageContext);
                if (runTask != null) {
                    this.gba = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gba != null) {
                this.gba.cF(1);
                View view = this.gba.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bFe().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bFe().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.gbO.addView(view, layoutParams);
                    if (z2) {
                        this.gba.a(FO);
                    }
                }
            }
        }
    }

    private void bEv() {
        this.gbt = new com.baidu.tieba.ala.liveroom.guideim.b(bFe().pageContext);
        this.gbt.c(this.gbP, bDD());
        this.gbt.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.16
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean DF() {
                return b.this.BR();
            }
        });
    }

    private void bEw() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bFe().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gbu = (com.baidu.live.view.input.c) runTask.getData();
            this.gbu.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.17
                @Override // com.baidu.live.view.input.c.a
                public void KR() {
                    b.this.rE(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void KS() {
                    b.this.cJ(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean DF() {
                    return b.this.BR();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Eg() {
                    return b.this.bEz();
                }

                @Override // com.baidu.live.view.input.c.a
                public int DK() {
                    return b.this.bEA();
                }
            });
        }
    }

    private void bEx() {
        this.gbv = new com.baidu.tieba.ala.liveroom.m.a(this.gaY.pageContext);
        this.gbv.a(new a.InterfaceC0584a() { // from class: com.baidu.tieba.ala.liveroom.d.b.18
            @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0584a
            public boolean bFg() {
                return b.this.bEj();
            }

            @Override // com.baidu.tieba.ala.liveroom.m.a.InterfaceC0584a
            public void onClose() {
                if (b.this.aYP != null) {
                    b.this.aYP.bR(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void li(boolean z) {
        if (this.gbt != null) {
            this.gbt.lF(z);
        }
        if (this.gbv != null) {
            this.gbv.lF(z);
        }
        gcb = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bEy() {
        return gcb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bEz() {
        q FO;
        if (bFe() == null || bFe().gla == null || (FO = bFe().gla.FO()) == null || FO.ayV == null) {
            return false;
        }
        String str = FO.ayV.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bEA() {
        q FO;
        if (bFe() != null && bFe().gla != null && (FO = bFe().gla.FO()) != null && !ListUtils.isEmpty(FO.aza)) {
            for (AlaLiveMarkData alaLiveMarkData : FO.aza) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bEB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bFe().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.gbx = (com.baidu.live.guardclub.k) runTask.getData();
            this.gbx.setOtherParams(Et());
        }
    }

    private void bEC() {
        this.gbD = new e(bFe().pageContext.getPageActivity());
    }

    private void bED() {
        this.gbF = new com.baidu.tieba.ala.liveroom.p.c(bFe().pageContext.getPageActivity());
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(this.gcn);
        MessageManager.getInstance().registerListener(this.gco);
        MessageManager.getInstance().registerListener(this.gcq);
        MessageManager.getInstance().registerListener(this.gcj);
        MessageManager.getInstance().registerListener(this.gck);
        MessageManager.getInstance().registerListener(this.gcm);
        MessageManager.getInstance().registerListener(this.gcl);
        MessageManager.getInstance().registerListener(this.fEy);
        MessageManager.getInstance().registerListener(this.gcr);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fNC);
        MessageManager.getInstance().registerListener(this.fNz);
        MessageManager.getInstance().registerListener(this.bbz);
        MessageManager.getInstance().registerListener(this.gcs);
        MessageManager.getInstance().registerListener(this.gct);
        MessageManager.getInstance().registerListener(this.gcu);
        MessageManager.getInstance().registerListener(this.gcv);
        MessageManager.getInstance().registerListener(this.gcw);
        MessageManager.getInstance().registerListener(this.gcg);
        MessageManager.getInstance().registerListener(this.gch);
        MessageManager.getInstance().registerListener(this.gci);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean BR() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bFe().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dt(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bFe().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bFe().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.19
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Hs().aZn.aBy;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bFe().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bFe().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.20
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bFe().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bFe().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEE() {
        if (this.gbo != null) {
            this.gbo.DD().a(this.gbu.Gw(), t.zn().zp(), bFe().gla.FO().mLiveInfo);
            li(true);
            if (this.gbG == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, x.class, bFe().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gbG = (x) runTask.getData();
                } else {
                    return;
                }
            }
            this.gbG.eY("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEF() {
        if (this.gbo != null) {
            this.gbo.DD().hide();
            li(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(int i, int i2, int i3) {
        if (bFe().gla.FO() != null && bFe().gla.FO().ayC != null && bFe().gla.FO().mLiveInfo != null) {
            a(bFe().gla.FO(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(i.class) != null && BR()) {
            if (qVar == null) {
                qVar = bFe().gla.FO();
            }
            String valueOf = String.valueOf(qVar.ayC.userId);
            String str = qVar.ayC.userName;
            String valueOf2 = String.valueOf(qVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(qVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(qVar.mLiveInfo.feed_id);
            int i6 = qVar.ayV.isBlock;
            String zw = v.zw();
            String str2 = qVar.mLiveInfo.appId;
            boolean z2 = qVar.ayV.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (qVar.mLiveInfo.live_type == 1 && qVar.mLiveInfo.screen_direction == 1 && com.baidu.live.v.a.Hs().aZn.aAB) {
                z3 = true;
            }
            int i7 = -1;
            if (qVar.ayV == null) {
                z = false;
            } else {
                boolean z4 = qVar.ayV.isNewUser;
                i7 = qVar.ayV.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.gbV != null && this.gbV.aSF != null && this.gbV.aSF.axs == qVar.ayC.userId) {
                z5 = this.gbV.aSI;
            }
            i iVar = new i(bFe().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, zw, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (qVar != null && qVar.mLiveInfo != null && qVar.mLiveInfo.mAlaLiveSwitchData != null) {
                iVar.aS(qVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            iVar.aQ(z);
            if (com.baidu.tieba.ala.liveroom.v.b.bMA().aZy != null) {
                iVar.aR(com.baidu.tieba.ala.liveroom.v.b.bMA().aZy.azv != 1);
            }
            at CL = g.CJ().CL();
            if (CL == null || CL.aDG <= 0) {
                i5 = 1000;
            } else {
                i5 = CL.aDG;
            }
            iVar.bL(i5);
            boolean z6 = false;
            if (qVar != null && qVar.ayV != null) {
                String str3 = qVar.ayV.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            iVar.aT(z6);
            boolean z7 = true;
            bc bcVar = com.baidu.live.v.a.Hs().beo;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bcVar != null && bcVar.aEr != null && (!bcVar.aEr.aGl || !bcVar.aEr.aGm)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            iVar.aU(z7);
            if (qVar != null && qVar.ayX != null) {
                iVar.en(qVar.ayX.toJsonString());
            }
            if (!this.gbZ) {
                this.gca = true;
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, iVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEG() {
        cJ(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bi biVar) {
        if (biVar != null && BR()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(bFe().pageContext.getPageActivity(), biVar.aEW, biVar.liveId, biVar.aEX)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Hs().aZn != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bFe().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Hs().aZn.aBY, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, NobleDetailInfo nobleDetailInfo) {
        if (BR() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (qVar != null) {
                if (qVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(qVar.mLiveInfo.live_id));
                }
                if (qVar.ayC != null) {
                    hashMap.put("anchor_id", Long.valueOf(qVar.ayC.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.zw());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bFe().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bEH() {
        if (this.gbu != null) {
            this.gbu.d(this.gaY.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bEI() {
        q FO = bFe().gla.FO();
        LogManager.getCommonLogger().doClickQuickImHiLog((FO == null || FO.mLiveInfo == null) ? "" : FO.mLiveInfo.feed_id, Et());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Du(String str) {
        if (this.gbu != null) {
            this.gbu.fb(str);
        }
    }

    private void bEJ() {
        if ("home_rec_play".equals(bFe().fromType) || "frs_play".equals(bFe().fromType) || "frs_live_play".equals(bFe().fromType) || "person_play".equals(bFe().fromType) || "search".equals(bFe().fromType) || "person_attention".equals(bFe().fromType)) {
            com.baidu.live.b.ve().aP(true);
        } else {
            com.baidu.live.b.ve().aP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ld(boolean z) {
        View za;
        if (this.gbq == null) {
            f fVar = new f();
            fVar.aHx = false;
            fVar.context = bFe().pageContext.getPageActivity();
            fVar.aHG = z;
            fVar.fromType = bFe().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gbq = (w) runTask.getData();
            }
        }
        if (this.gbq != null && (za = this.gbq.za()) != null && this.gaY.glb.indexOfChild(za) < 0) {
            this.gaY.glb.addView(za, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEK() {
        View zz;
        if (this.gbB == null) {
            ab abVar = new ab();
            abVar.aHx = false;
            abVar.pageContext = bFe().pageContext;
            abVar.fromType = bFe().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.gbB = (y) runTask.getData();
            }
        }
        if (this.gbB != null && (zz = this.gbB.zz()) != null && bFe().glb.indexOfChild(zz) < 0) {
            if (zz.getParent() instanceof ViewGroup) {
                ((ViewGroup) zz.getParent()).removeView(zz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bFe().glb.addView(zz, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEL() {
        View zs;
        if (this.gbr == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aHx = false;
            aVar.context = bFe().pageContext.getPageActivity();
            aVar.fromType = bFe().fromType;
            aVar.aHy = bFe().glf;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gbr = (u) runTask.getData();
            }
        }
        if (this.gbr != null && (zs = this.gbr.zs()) != null && bFe().glb.indexOfChild(zs) < 0) {
            if (zs.getParent() instanceof ViewGroup) {
                ((ViewGroup) zs.getParent()).removeView(zs);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds18) * (-1);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bFe().glb.addView(zs, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bEM() {
        CustomResponsedMessage runTask;
        if (this.gbp == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bFe().pageContext)) != null) {
            this.gbp = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gbp != null) {
            this.gbp.setOtherParams(this.otherParams);
            this.gbp.a(new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
                @Override // com.baidu.live.im.b.a.InterfaceC0167a
                public void DZ() {
                    b.this.bEP();
                }
            });
            this.gbp.a(bFe().gla.FO(), false);
            View vB = this.gbp.vB();
            if (vB != null && this.gbP.indexOfChild(vB) < 0) {
                Resources resources = bFe().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bFe().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.gbP.addView(vB, layoutParams);
            }
        }
    }

    private void bEN() {
        if (this.gbm == null) {
            this.gbm = new com.baidu.tieba.ala.liveroom.h.a(bFe().pageContext);
        }
        if (this.gbU != null) {
            this.gbm.Dx(this.gbU.user_id);
        }
        this.gbm.ar(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lj(boolean z) {
        CustomResponsedMessage runTask;
        if (bFe() != null && !z && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bFe().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gbJ = (com.baidu.live.i.a) runTask.getData();
            this.gbJ.a(bEl(), bEW());
            if (bFe().gla != null) {
                this.gbJ.a(bFe().gla.FO());
            }
            this.gbJ.setCanVisible(true);
            this.gbJ.bF(true);
            this.gbJ.a(bFe().gla.bzs());
        }
    }

    private void bEO() {
        if (this.gbz == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bFe().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gbz = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bFe().gla.FO() != null && bFe().gla.FO().ayC != null && bFe().gla.FO().mLiveInfo != null) {
            this.gbz.setHost(false);
            this.gbz.setOtherParams(Et());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bFe().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            this.gbz.a(this.gbO, layoutParams, bFe().gla.FO());
            this.gbz.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
                @Override // com.baidu.live.guardclub.l
                public void CP() {
                    b.this.bFf();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x069c, code lost:
        Dq(r32);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject optJSONObject;
        long j;
        long j2;
        JSONObject jSONObject4;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject4 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(aVar.getContent());
            }
            try {
                String optString = jSONObject4.optString("ext");
                if (!TextUtils.isEmpty(optString)) {
                    new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
                }
                jSONObject3 = jSONObject4.optJSONObject("ext_data");
                jSONObject2 = jSONObject4;
            } catch (JSONException e) {
                jSONObject = jSONObject4;
                jSONObject2 = jSONObject;
                jSONObject3 = null;
                if (aVar.getMsgType() != 12) {
                }
                if (jSONObject2 == null) {
                }
            }
        } catch (JSONException e2) {
            jSONObject = null;
        }
        if (aVar.getMsgType() != 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.aYP != null) {
                        this.aYP.bT(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        rG(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bFe().gla.FO().ayV.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bFe().gla.FO().ayV.isAdmin = 0;
                            bFe().gla.bLw();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bFe().gla.FO().ayV.isAdmin = 0;
                        bFe().gla.bLw();
                    }
                } else if ("task".equals(optString2)) {
                    dj(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gbs != null && !bFe().gle) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bFe().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bFe().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bFe().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bAL()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gbs.a(bFe().gkZ.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.aYP != null) {
                                b.this.aYP.bS(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bFe().gla.FO() != null && bFe().gla.FO().mLiveInfo != null) {
                        String str2 = bFe().gla.FO().mLiveInfo.feed_id;
                        long j3 = bFe().gla.FO().mLiveInfo.live_id;
                        long j4 = bFe().gla.FO().ayC.userId;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!com.baidu.live.utils.m.i(j3, optLong2)) {
                            if (this.gby != null) {
                                this.gby.a(str2, j3, false, false, j4);
                            }
                            com.baidu.live.utils.m.j(j3, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.s.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bFe().gla.FO() != null && bFe().gla.FO().ayV != null && bFe().gla.FO().ayV.userId == optLong3) {
                        bFe().gla.FO().ayV.isBlock = 1;
                        bDX();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bFe().gla.FO() != null && bFe().gla.FO().ayV != null && bFe().gla.FO().ayV.userId == optLong4) {
                        bFe().gla.FO().ayV.isBlock = 0;
                        bDX();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bFe().gla.FO() != null && bFe().gla.FO().ayV != null && bFe().gla.FO().ayV.userId == optLong5) {
                        bFe().gla.FO().ayV.isUegBlock = 1;
                        bDX();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (bFe().gla.FO() != null && bFe().gla.FO().ayV != null && bFe().gla.FO().ayV.userId == optLong6) {
                        bFe().gla.FO().ayV.isUegBlock = 0;
                        bDX();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bFe() != null && bFe().gla != null && bFe().gla.FO() != null && bFe().gla.FO().ayV != null) {
                        if (bFe().gla.FO().ayV.userId == jSONObject2.optLong("user_id")) {
                            bFe().gla.bLw();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bFe().gla.FO().ayV));
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
                    com.baidu.live.data.a Eh = aVar.Eh();
                    if (Eh != null && v.eW(str4)) {
                        v.d(str4, 1L, "", "", Eh.userId, Eh.portrait, Eh.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        ao aoVar = new ao();
                        aoVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, aoVar));
                    }
                } else if (TextUtils.equals(optString2, "challenge_mvp_punish")) {
                    if (jSONObject2 != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                    }
                } else if (TextUtils.equals(optString2, "send_redpacket") && (optJSONObject = jSONObject2.optJSONObject("live_redpacket")) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913221, new RedPacketCharmInfo(optJSONObject)));
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.gbj != null) {
                this.gbj.A(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a Eh2 = aVar.Eh();
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
            if (bFe().gla == null || bFe().gla.FO() == null || bFe().gla.FO().mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                long j6 = bFe().gla.FO().mLiveInfo.live_id;
                j5 = bFe().gla.FO().mLiveInfo.group_id;
                long j7 = bFe().gla.FO().ayC.userId;
                str5 = bFe().gla.FO().mLiveInfo.appId;
                j = j7;
                j2 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    v.b(optString9, Eh2.userId, Eh2.portrait, Eh2.getNameShow(), String.valueOf(j2), String.valueOf(j5), false, String.valueOf(j), str5, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                } else if (com.baidu.live.v.d.Hz().fI(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                        }
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            } else {
                v.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, Eh2.userId, Eh2.portrait, Eh2.getNameShow(), String.valueOf(j2), String.valueOf(j5), false, String.valueOf(j), str5, optString7, "", "", aVar.getMsgId());
                Dq(optString3);
            }
            com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
            cVar.gkF = optLong8;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void Dq(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bEP() {
        if (bEQ()) {
            BdUtilHelper.hideSoftKeyPad(bFe().pageContext.getPageActivity(), bFe().gkZ.getLiveContainerView());
            bEi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bEQ() {
        if (bEh() == null || bEh().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(q qVar) {
        CustomResponsedMessage runTask;
        bFe().glb.setOnTouchListener(this.gcx);
        bEX();
        bEY();
        bEZ();
        bEN();
        bEO();
        if (this.gbh != null && bFe().gla.FO() != null && bFe().gla.FO().mLiveInfo != null) {
            this.gbh.ca(bFe().gla.FO().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gbn != null) {
            this.gbn.g(bFe().gla.FO());
        }
        if (this.gbl != null) {
            this.gbl.h(bFe().gla.FO());
        }
        if (this.gbt != null) {
            this.gbt.c(bFe().gla.FO(), Et());
        }
        if (this.gbu != null) {
            this.gbu.b(bFe().gla.FO(), Et());
        }
        if (this.gbv != null) {
            this.gbv.c(bFe().gla.FO(), Et());
        }
        if (bFe().glb != null) {
            bFe().glb.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean A = b.this.A(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bEQ() && b.this.gbg != null) {
                        b.this.gbg.lW(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gbg != null) {
                        b.this.gbg.lW(true);
                    }
                    return A;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean FL() {
                    if (b.this.gcf == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.gcf) {
                        if (bVar.FL()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bFe().glb.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.z(motionEvent);
                }
            });
        }
        if (this.gbG == null && (runTask = MessageManager.getInstance().runTask(2913165, x.class, bFe().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gbG = (x) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bER() {
        q FO;
        ViewGroup viewGroup;
        if (bFe() != null && bFe().gla != null && (FO = bFe().gla.FO()) != null && FO.mLiveInfo != null && !FO.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bFe().gkZ) != null) {
            if (this.gbK == null) {
                this.gbK = new com.baidu.tieba.ala.liveroom.recommend.a(bFe().pageContext);
            }
            this.gbK.t(FO);
            this.gbK.a(bFe().glb);
            this.gbK.ar(viewGroup);
            a((com.baidu.live.liveroom.g.d) this.gbK);
            a((com.baidu.live.liveroom.g.b) this.gbK);
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gce == null) {
            this.gce = new ArrayList();
        }
        if (!this.gce.contains(dVar)) {
            this.gce.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gce != null && this.gce.contains(dVar)) {
            this.gce.remove(dVar);
        }
    }

    protected void bES() {
        if (this.gce != null) {
            this.gce.clear();
            this.gce = null;
        }
    }

    protected boolean z(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gce == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gce.iterator();
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
        if (this.gcf == null) {
            this.gcf = new ArrayList();
        }
        if (!this.gcf.contains(bVar)) {
            this.gcf.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gcf != null && this.gcf.contains(bVar)) {
            this.gcf.remove(bVar);
        }
    }

    protected void bET() {
        if (this.gcf != null) {
            this.gcf.clear();
            this.gcf = null;
        }
    }

    protected boolean A(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gcf == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gcf.iterator();
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
    public void bEU() {
        if (this.gbI == null && this.gbL != null && this.gbL.aEB && bFe() != null && bFe().gla != null && bFe().gla.FO() != null) {
            this.gbI = new com.baidu.tieba.ala.liveroom.h.e(bFe().pageContext, this.gbL);
            this.gbI.s(bFe().gla.FO());
            if (this.gbL.aEE == 1) {
                if (this.gbo != null) {
                    this.gbX = true;
                }
            } else if (this.gbL.aEE == 2) {
                a(bFe().gla.FO(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bEV() {
        CustomResponsedMessage runTask;
        if (bFe() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bFe().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.r.a)) {
            this.gbM = (com.baidu.live.r.a) runTask.getData();
            this.gbM.o(bEk());
            if (bFe().gla != null) {
                this.gbY = this.gbM.o(bFe().gla.FO());
            }
            this.gbM.setCanVisible(!this.gbS);
        }
    }

    private ViewGroup.LayoutParams bEW() {
        int dimensionPixelOffset;
        if (bDD()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bFe().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bFe().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int G(boolean z, boolean z2) {
        Rect rect = new Rect();
        bFe().gkZ.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bFe().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bFe().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bFe().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bFe().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bEX() {
        if (this.gbg != null) {
            this.gbg.ay(bFe().glb);
        }
    }

    private void bEY() {
        if (this.gbh != null) {
            this.gbh.aC(bFe().glb);
        }
    }

    private void bEZ() {
        if (this.gbk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gbk = (com.baidu.live.x.a) runTask.getData();
            }
            bFa();
        }
    }

    private void dj(JSONObject jSONObject) {
        if (this.gbk != null) {
            if (this.gbd != null) {
                this.gbk.cf(this.gbd.bIf() ? false : true);
            } else {
                this.gbk.cf(true);
            }
            this.gbk.L(jSONObject);
        }
    }

    private void bFa() {
        if (this.gbk != null && bFe().gla.FO() != null && bFe().gla.FO().azf != null) {
            if (this.gbd != null) {
                this.gbk.cf(this.gbd.bIf() ? false : true);
            } else {
                this.gbk.cf(true);
            }
            this.gbk.j(bFe().gla.FO());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(q qVar) {
        if (qVar != null) {
            if (this.gbh != null && qVar.mLiveInfo != null) {
                this.gbh.ca(qVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gby != null) {
                this.gby.i(qVar);
            }
            bFa();
            if (this.gbm != null && qVar.ayC != null) {
                this.gbm.Dx(String.valueOf(qVar.ayC.userId));
            }
            if (this.gba != null) {
                this.gba.a(qVar);
            }
            if (this.gbr != null && qVar.mLiveInfo != null) {
                this.gbr.a(qVar.mLiveInfo, qVar.ayC);
            }
            if (this.gbp != null) {
                this.gbp.a(qVar);
            }
            if (this.gbM != null) {
                this.gbY = this.gbM.o(qVar);
            }
            if (this.gbJ != null) {
                this.gbJ.a(qVar);
            }
            rG(qVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void rG(int i) {
        if (!bFe().gle) {
            if (this.gbQ < 0 && i == 0) {
                this.gbQ = i;
            } else if (this.gbQ != i) {
                if (i == 1) {
                    if (!this.gbs.sr(2)) {
                        String string = bFe().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bFe().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gbs.a(bFe().gkZ.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bFe().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.gbs.ss(2);
                    this.gbs.ss(3);
                    if (bAL()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gbs.a(bFe().gkZ.getLiveContainerView(), string2, 3);
                    }
                }
                this.gbQ = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void bV(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.bV(z);
        if (z) {
            bFb();
        }
        if (this.gby != null) {
            this.gby.Fi();
        }
        if (this.gbl != null) {
            this.gbl.Fi();
        }
        if (this.gbj != null) {
            this.gbj.bNJ();
        }
        if (this.gbb != null) {
            this.gbb.wd();
        }
        if (this.gbd != null) {
            this.gbd.onDestroy();
        }
        if (this.gbk != null) {
            this.gbk.onDestroy();
            this.gbk = null;
        }
        if (this.gbq != null) {
            View za = this.gbq.za();
            if (za != null && za.getParent() != null) {
                ((ViewGroup) za.getParent()).removeView(za);
            }
            this.gbq.onDestroy();
            this.gbq = null;
        }
        if (this.gbp != null) {
            this.gbp.a((a.InterfaceC0167a) null);
            this.gbp.vD();
        }
        if (this.gbs != null) {
            this.gbs.wd();
        }
        this.gbQ = -1;
        if (this.gbm != null) {
            this.gbm.wd();
            this.gbm.onDestroy();
        }
        if (this.gbe != null) {
            this.gbe.bNH();
        }
        if (this.gbf != null) {
            this.gbf.bDA();
            this.gbf.zy();
        }
        if (this.gbg != null) {
            this.gbg.zy();
        }
        if (this.gbn != null) {
            this.gbn.zy();
        }
        if (this.gbt != null) {
            this.gbt.Fi();
        }
        if (this.gbu != null) {
            this.gbu.zy();
        }
        if (this.gbv != null) {
            this.gbv.onDestroy();
        }
        if (this.gbx != null) {
            this.gbx.onDestory();
        }
        if (this.gbA != null) {
            this.gbA.CN();
        }
        if (this.gbz != null) {
            this.gbz.CN();
        }
        if (this.gbI != null) {
            this.gbI.onDestroy();
        }
        if (this.gbD != null) {
            this.gbD.zy();
        }
        if (this.gbE != null) {
            this.gbE.zy();
        }
        if (this.gbG != null) {
            this.gbG.zy();
        }
        if (this.gbc != null) {
            this.gbc.onDestory();
        }
        if (this.gbM != null) {
            this.gbM.zy();
        }
        if (this.gbJ != null) {
            this.gbJ.CN();
        }
        if (this.gbF != null) {
            this.gbF.zy();
        }
        if (this.gbB != null) {
            this.gbB.onDestroy();
        }
        if (this.gbK != null) {
            this.gbK.wd();
            b((com.baidu.live.liveroom.g.d) this.gbK);
            b((com.baidu.live.liveroom.g.b) this.gbK);
        }
        ShowUtil.windowCount = 0;
        bES();
        bET();
    }

    private void bFb() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bFe().glb.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bFe().glb.getChildAt(i);
            if (childAt != this.gbO && childAt != this.gbP) {
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
        if (this.gbO != null) {
            this.gbO.removeAllViews();
        }
        if (this.gbP != null) {
            this.gbP.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, q qVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(q qVar) {
        View vB;
        View za;
        if (this.gbq != null && (za = this.gbq.za()) != null && za.getParent() != null) {
            ((ViewGroup) za.getParent()).removeView(za);
        }
        if (this.gbp != null && (vB = this.gbp.vB()) != null && vB.getParent() != null) {
            ((ViewGroup) vB.getParent()).removeView(vB);
        }
        if (this.gbd != null) {
            this.gbd.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean FI() {
        if (this.gbi == null || !this.gbi.bIk()) {
            if (this.gbd == null || !this.gbd.au(bFe().gkZ.getLiveContainerView())) {
                if (this.gbg != null) {
                    this.gbg.bBt();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gbw != null && this.gbw.bHT()) {
                    this.gbw.bIc();
                    return false;
                } else if (this.gbv == null || !this.gbv.bIn()) {
                    bEJ();
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
    public void bU(boolean z) {
        super.bU(z);
        if (this.gby != null) {
            this.gby.release();
        }
        if (this.gbl != null) {
            this.gbl.onDestroy();
        }
        if (this.gbH != null) {
            this.gbH.destroy();
        }
        if (this.gbk != null) {
            this.gbk.onDestroy();
            this.gbk = null;
        }
        if (this.gbj != null) {
            this.gbj.bNJ();
        }
        if (this.gbq != null) {
            this.gbq.onDestroy();
            this.gbq = null;
        }
        if (this.gbr != null) {
            this.gbr.onDestroy();
            this.gbr = null;
        }
        if (this.gbs != null) {
            this.gbs.onDestroy();
        }
        if (this.gbb != null) {
            this.gbb.onDestroy();
        }
        if (this.gbB != null) {
            this.gbB.onDestroy();
            this.gbB = null;
        }
        if (this.gbp != null) {
            this.gbp.a((a.InterfaceC0167a) null);
            this.gbp.release();
            this.gbp = null;
        }
        if (this.gbt != null) {
            this.gbt.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gbt.release();
        }
        if (this.gbu != null) {
            this.gbu.a(null);
            this.gbu.release();
        }
        if (this.gbv != null) {
            this.gbv.a((a.InterfaceC0584a) null);
            this.gbv.onDestroy();
        }
        if (this.gbz != null) {
            this.gbz.onDestroy();
        }
        if (this.gbA != null) {
            this.gbA.onDestroy();
        }
        if (this.gbx != null) {
            this.gbx.onDestory();
        }
        if (this.gbI != null) {
            this.gbI.onDestroy();
        }
        if (this.gbD != null) {
            this.gbD.release();
        }
        if (this.gbF != null) {
            this.gbF.release();
        }
        if (this.gbE != null) {
            this.gbE.release();
        }
        if (this.gbG != null) {
            this.gbG.release();
        }
        if (this.gbc != null) {
            this.gbc.onDestory();
        }
        if (this.gbM != null) {
            this.gbM.release();
        }
        if (this.gbJ != null) {
            this.gbJ.onDestroy();
        }
        if (this.gbg != null) {
            this.gbg.zy();
        }
        if (this.gbK != null) {
            this.gbK.onDestroy();
            b((com.baidu.live.liveroom.g.d) this.gbK);
            b((com.baidu.live.liveroom.g.b) this.gbK);
        }
        bES();
        bET();
        MessageManager.getInstance().unRegisterListener(this.gcg);
        MessageManager.getInstance().unRegisterListener(this.gch);
        MessageManager.getInstance().unRegisterListener(this.gci);
        MessageManager.getInstance().unRegisterListener(this.gcn);
        MessageManager.getInstance().unRegisterListener(this.gco);
        MessageManager.getInstance().unRegisterListener(this.gcq);
        MessageManager.getInstance().unRegisterListener(this.gcj);
        MessageManager.getInstance().unRegisterListener(this.gck);
        MessageManager.getInstance().unRegisterListener(this.gcm);
        MessageManager.getInstance().unRegisterListener(this.gcl);
        MessageManager.getInstance().unRegisterListener(this.fEy);
        MessageManager.getInstance().unRegisterListener(this.gcr);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fNC);
        MessageManager.getInstance().unRegisterListener(this.fNz);
        MessageManager.getInstance().unRegisterListener(this.bbz);
        MessageManager.getInstance().unRegisterListener(this.gcs);
        MessageManager.getInstance().unRegisterListener(this.gct);
        MessageManager.getInstance().unRegisterListener(this.gcu);
        MessageManager.getInstance().unRegisterListener(this.gcv);
        MessageManager.getInstance().unRegisterListener(this.gcw);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gbt != null) {
            this.gbt.lE(false);
        }
        if (this.gbv != null) {
            this.gbv.lE(false);
        }
        bEi();
        if (this.gby != null) {
            this.gby.onPause();
        }
        if (this.gbD != null) {
            this.gbD.pause();
        }
        if (this.gbF != null) {
            this.gbF.pause();
        }
        if (this.gbB != null) {
            this.gbB.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gca = false;
        if (this.gbT && this.gbU != null) {
            a(this.gbU);
            this.gbT = false;
        }
        if (this.gbt != null) {
            this.gbt.lE(true);
        }
        if (this.gbv != null) {
            this.gbv.lE(true);
        }
        if (this.gby != null) {
            this.gby.onResume();
        }
        if (this.gbD != null) {
            this.gbD.resume();
        }
        if (this.gbF != null) {
            this.gbF.resume();
        }
        if (this.gbB != null) {
            this.gbB.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bFc() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gbK != null && this.gbK.isOpen()) {
            this.gbK.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            bFc();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra(AlaCharmCardActivityConfig.NEED_SHOW_GIFT_PANEL, false)) {
                    K(-1, -1, -1);
                    return;
                }
                return;
            }
            bFc();
        } else if (i == 25034) {
            bEG();
        } else if (i == 25043) {
            if (i2 == -1) {
                bFf();
            }
        } else if (i == 25050 && this.gbH != null) {
            if (i2 == -1) {
                this.gbH.O(intent);
            } else {
                this.gbH.O(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gbS = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bFd() {
        return (bFe().gla.FO() == null || bFe().gla.FO().mLiveInfo == null || bFe().gla.FO().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gbd != null) {
                this.gbd.bw(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gbv != null) {
            this.gbv.aSA();
        }
        if (this.gbc != null) {
            this.gbc.aSA();
        }
        if (this.gbK != null) {
            this.gbK.bw(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gaY = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bFe() {
        return this.gaY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFf() {
        String CK = g.CJ().CK();
        if (!TextUtils.isEmpty(CK)) {
            try {
                K(-1, Integer.parseInt(CK), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                K(-1, -1, -1);
            }
        }
    }

    public boolean cI(int i) {
        if (7 == i) {
            if (this.gbq != null) {
                this.gbq.be(true);
            }
        } else if (1 == i) {
            if (bEh() != null) {
                bEh().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gbS) {
                return false;
            }
            return this.gbd == null || !this.gbd.bIf();
        } else if (3 == i) {
            if (bFe().glb != null) {
                bFe().glb.setEnabled(false);
                if (this.aYP != null) {
                    this.aYP.e(!bFe().glc, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void rE(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void cJ(int i) {
        if (7 == i) {
            if (this.gbq != null) {
                this.gbq.be(false);
            }
        } else if (3 == i) {
            bFe().glb.setEnabled(true);
            if (this.aYP != null) {
                this.aYP.e(bFe().glc ? false : true, true);
            }
            if (this.gbk != null) {
                this.gbk.cf(true);
            }
        } else if (2 == i && this.gbj != null) {
            this.gbj.mg(true);
        }
    }

    public String Et() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gbp != null) {
            this.gbp.setOtherParams(str);
        }
        if (this.gby != null) {
            this.gby.fz(str);
        }
    }

    private boolean bAL() {
        return bFe().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.flX = alaLastLiveroomInfo;
    }

    public void a(as asVar, AlaLiveInfoData alaLiveInfoData) {
        if (asVar != null && asVar.eventType == 1001 && this.gby != null) {
            this.gby.a(alaLiveInfoData.feed_id, alaLiveInfoData.live_id, false, false, alaLiveInfoData.user_id);
        }
    }
}
