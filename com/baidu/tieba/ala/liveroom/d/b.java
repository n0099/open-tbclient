package com.baidu.tieba.ala.liveroom.d;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
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
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c.i;
import com.baidu.live.c.s;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ah;
import com.baidu.live.data.aq;
import com.baidu.live.data.au;
import com.baidu.live.data.av;
import com.baidu.live.data.be;
import com.baidu.live.data.bf;
import com.baidu.live.data.bk;
import com.baidu.live.data.r;
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
import com.baidu.live.guardclub.k;
import com.baidu.live.guardclub.l;
import com.baidu.live.im.b.a;
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
import com.baidu.tieba.ala.liveroom.n.a;
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
/* loaded from: classes7.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a {
    public static boolean goi;
    protected AlaLastLiveroomInfo fxx;
    protected com.baidu.live.view.input.c gnA;
    com.baidu.tieba.ala.liveroom.n.a gnB;
    protected com.baidu.tieba.ala.liveroom.guide.a gnC;
    private k gnD;
    protected com.baidu.live.j.b gnE;
    protected h gnF;
    protected j gnG;
    protected y gnH;
    protected e gnJ;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gnK;
    protected com.baidu.tieba.ala.liveroom.q.c gnL;
    private x gnM;
    protected com.baidu.tieba.ala.liveroom.v.a gnN;
    protected com.baidu.tieba.ala.liveroom.h.e gnO;
    protected com.baidu.live.i.a gnP;
    protected com.baidu.live.r.a gnQ;
    protected com.baidu.tieba.ala.liveroom.exclusive.b gnR;
    protected bf gnS;
    protected com.baidu.live.s.a gnT;
    protected com.baidu.tieba.ala.liveroom.f.a gnU;
    protected RelativeLayout gnV;
    protected RelativeLayout gnW;
    protected boolean gnY;
    private com.baidu.tieba.ala.liveroom.data.a gne;
    protected com.baidu.tieba.ala.liveroom.operation.a gnf;
    protected com.baidu.live.h.a gng;
    protected com.baidu.tieba.ala.liveroom.share.c gnh;
    protected com.baidu.tieba.ala.liveroom.r.b gni;
    protected com.baidu.tieba.ala.liveroom.guide.c gnj;
    protected com.baidu.tieba.ala.liveroom.watermark.a gnk;
    protected com.baidu.tieba.ala.liveroom.b.b gnl;
    protected com.baidu.tieba.ala.liveroom.praise.a gnm;
    protected com.baidu.tieba.ala.liveroom.sticker.a gnn;
    protected com.baidu.tieba.ala.liveroom.guide.d gno;
    protected com.baidu.tieba.ala.liveroom.x.a gnp;
    protected com.baidu.live.y.a gnq;
    protected com.baidu.live.y.d gnr;
    private com.baidu.tieba.ala.liveroom.h.a gns;
    private m gnt;
    com.baidu.live.im.k gnu;
    com.baidu.live.im.b.a gnv;
    protected w gnw;
    protected u gnx;
    protected com.baidu.tieba.ala.liveroom.tippop.a gny;
    private com.baidu.tieba.ala.liveroom.guideim.b gnz;
    protected ah gob;
    protected GuardClubInfoHttpResponseMessage goc;
    boolean god;
    boolean goe;
    boolean gof;
    public boolean gog;
    public boolean goh;
    protected com.baidu.tieba.ala.liveroom.t.b goj;
    protected com.baidu.tieba.ala.liveroom.j.e gok;
    protected List<com.baidu.live.liveroom.g.d> gol;
    protected List<com.baidu.live.liveroom.g.b> gom;
    protected String otherParams;
    private int gnI = 0;
    private int gnX = -1;
    protected int mOrientation = 0;
    protected boolean gnZ = false;
    protected boolean goa = false;
    CustomMessageTask.CustomRunnable<Object> gon = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: bOI */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> goo = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.liveroom.d.b.12.1
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                public Object getData() {
                    return false;
                }
            };
        }
    };
    private CustomMessageListener gop = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.y yVar;
            if ((customResponsedMessage.getData() instanceof com.baidu.live.data.y) && (yVar = (com.baidu.live.data.y) customResponsedMessage.getData()) != null) {
                b.this.a(yVar.aEE, yVar.aEA, yVar.aEB, yVar.aEC, yVar.aED);
            }
        }
    };
    private CustomMessageListener goq = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.tQ(7);
        }
    };
    private CustomMessageListener gor = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bOj();
        }
    };
    private CustomMessageListener gos = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bOG().gxi.LC().aDG.userId);
            com.baidu.live.view.a.Qx().a(valueOf, new com.baidu.live.data.d(b.this.bOG().gxi.LC().aDG.portrait, valueOf, true, b.this.bOG().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener got = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof r) && b.this.gnh != null) {
                b.this.gnh.c((r) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bgZ = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gnu != null) {
                b.this.gnu.g(t.EQ().ES());
            }
        }
    };
    private CustomMessageListener gou = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gne.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.FR(str);
            }
        }
    };
    private CustomMessageListener gov = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bOG().pageContext.getPageActivity());
            } else if (b.this.gnh != null) {
                b.this.gnh.c(b.this.bOG().gxi.LC(), false);
            }
        }
    };
    private CustomMessageListener gow = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ah) {
                    b.this.goa = true;
                    b.this.gob = (ah) data;
                    b.this.b(b.this.gob);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gox = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bOG().gxi.LC().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bOG().gxi.LC().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bOG().gxi.LC().aDG.userId);
                    if (b.this.gni == null) {
                        b.this.gni = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    b.this.gni.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gni.a(b.this.goy);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.InterfaceC0183b goy = new b.InterfaceC0183b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.o.b.InterfaceC0183b
        public void Mg() {
            if (b.this.bOG().gxi.LC() != null && b.this.bOG().gxi.LC().aEf != null) {
                b.this.bOG().gxi.LC().aEf.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener goz = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gnE != null) {
                    b.this.gnE.x(aVar);
                }
                if (b.this.gnR != null) {
                    b.this.gnR.y(aVar);
                }
                b.this.r(aVar);
            }
        }
    };
    CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener goA = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.god = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gnB != null) {
                b.this.gnB.Fd();
            }
        }
    };
    HttpMessageListener fZE = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aXV) != null && b.this.gnD != null && b.this.bOG() != null && b.this.bOG().gxi != null) {
                int[] iArr = new int[2];
                b.this.gnV.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gnD.a(b.this.gnV, layoutParams, aVar, b.this.bOG().gxi.LC());
                com.baidu.live.m.a.ay(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fZB = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bOG() != null && b.this.bOG().gxi != null && b.this.bOG().gxi.LC() != null && guardClubInfoHttpResponseMessage.aXV != null) {
                    if (guardClubInfoHttpResponseMessage.aXV.aCw == b.this.bOG().gxi.LC().aDG.userId) {
                        b.this.goc = guardClubInfoHttpResponseMessage;
                        if (b.this.goc.aXY && com.baidu.live.guardclub.e.Il() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.Il().ah(b.this.bOG().gxi.LC().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener goB = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bk) {
                b.this.a((bk) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener goC = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.r(b.this.bOG().gxi.LC());
        }
    };
    private CustomMessageListener goD = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gnP != null) {
                b.this.gnP.It();
            }
        }
    };
    private CustomMessageListener goE = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gnH != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) b.this.gnH).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener goF = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bOG().gxi.LC(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener goG = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bOs();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.r.b goH = new com.baidu.live.r.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // com.baidu.live.r.b
        public boolean MB() {
            if (b.this.bOG().gxj != null) {
                if (b.this.bOG().gxj.getKeyboardVisibility()) {
                    return false;
                }
                if (!b.this.bOG().gxj.bXn()) {
                    b.this.gnQ.close();
                    return false;
                } else if (b.this.bOG().gxj.getScrollX() != 0) {
                    b.this.gnQ.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void a(ah ahVar);

    protected abstract void b(ah ahVar);

    protected abstract void bNA();

    protected abstract View bNK();

    public abstract boolean bNL();

    protected abstract boolean bNM();

    protected abstract ViewGroup bNN();

    protected abstract ViewGroup bNO();

    public abstract boolean bNf();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bf bfVar) {
        this.gnS = bfVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gnV = (RelativeLayout) bOG().gxj.findViewById(a.g.ala_live_header_view);
        this.gnW = (RelativeLayout) bOG().gxj.findViewById(a.g.ala_live_footer_view);
        FF();
        registerListener();
    }

    public void bNT() {
    }

    private void FF() {
        if (this.gnh == null) {
            this.gnh = new com.baidu.tieba.ala.liveroom.share.c(bOG().pageContext);
        }
        this.gnp = new com.baidu.tieba.ala.liveroom.x.a(bOG().pageContext, this);
        this.gnl = new com.baidu.tieba.ala.liveroom.b.b(bOG().pageContext, false);
        this.gnm = new com.baidu.tieba.ala.liveroom.praise.a(bOG().pageContext);
        this.gnn = new com.baidu.tieba.ala.liveroom.sticker.a(bOG().pageContext);
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
                this.gno = new com.baidu.tieba.ala.liveroom.guide.d(bOG().pageContext);
            }
        }
        this.gny = new com.baidu.tieba.ala.liveroom.tippop.a(bOG().pageContext, this);
        bNW();
        bNY();
        bNZ();
        bOa();
        bOe();
        bOf();
        bOg();
        bNV();
        bNU();
    }

    private void bNU() {
        CustomResponsedMessage runTask;
        if (this.gnr == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.y.d.class, bOG().pageContext)) != null && runTask.getData() != null) {
            this.gnr = (com.baidu.live.y.d) runTask.getData();
        }
    }

    private void bNV() {
        CustomResponsedMessage runTask;
        if (this.gnE == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.j.b.class, bOG().pageContext)) != null && runTask.getData() != null) {
            this.gnE = (com.baidu.live.j.b) runTask.getData();
            this.gnE.c(bOG().pageContext);
            this.gnE.KO().setTargetView(this.gnW);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.gnU == null) {
            this.gnU = new com.baidu.tieba.ala.liveroom.f.a(bOG().pageContext);
            this.gnU.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.gnU.a(bOG().gxi.LC(), alaLastLiveroomInfo);
        this.gnU.as(this.gnW);
    }

    private void bNW() {
        this.gnt = new m();
    }

    public void lJ(boolean z) {
        this.gnY = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bNX() {
        r LC = bOG().gxi.LC();
        boolean z = com.baidu.live.w.a.Nk().beJ.aHj;
        if (LC.mLiveInfo != null && LC.mLiveInfo.mAlaLiveSwitchData != null && LC.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = LC.aEq ? z : false;
        if (z2) {
            if (this.gng == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bOG().pageContext);
                if (runTask != null) {
                    this.gng = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gng != null) {
                this.gng.ev(1);
                View view = this.gng.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bOG().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bOG().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.gnV.addView(view, layoutParams);
                    if (z2) {
                        this.gng.a(LC);
                    }
                }
            }
        }
    }

    private void bNY() {
        this.gnz = new com.baidu.tieba.ala.liveroom.guideim.b(bOG().pageContext);
        this.gnz.c(this.gnW, bNf());
        this.gnz.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.18
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean Ji() {
                return b.this.Hu();
            }
        });
    }

    private void bNZ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bOG().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gnA = (com.baidu.live.view.input.c) runTask.getData();
            this.gnA.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.19
                @Override // com.baidu.live.view.input.c.a
                public void QQ() {
                    b.this.tQ(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void QR() {
                    b.this.ez(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Ji() {
                    return b.this.Hu();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean JJ() {
                    return b.this.bOc();
                }

                @Override // com.baidu.live.view.input.c.a
                public int Jn() {
                    return b.this.bOd();
                }
            });
        }
    }

    private void bOa() {
        this.gnB = new com.baidu.tieba.ala.liveroom.n.a(this.gne.pageContext);
        this.gnB.a(new a.InterfaceC0636a() { // from class: com.baidu.tieba.ala.liveroom.d.b.20
            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0636a
            public boolean bOJ() {
                return b.this.bNM();
            }

            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0636a
            public void onClose() {
                if (b.this.bek != null) {
                    b.this.bek.bY(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lK(boolean z) {
        if (this.gnz != null) {
            this.gnz.ml(z);
        }
        if (this.gnB != null) {
            this.gnB.ml(z);
        }
        goi = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bOb() {
        return goi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bOc() {
        r LC;
        if (bOG() == null || bOG().gxi == null || (LC = bOG().gxi.LC()) == null || LC.aEf == null) {
            return false;
        }
        String str = LC.aEf.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bOd() {
        r LC;
        if (bOG() != null && bOG().gxi != null && (LC = bOG().gxi.LC()) != null && !ListUtils.isEmpty(LC.aEk)) {
            for (AlaLiveMarkData alaLiveMarkData : LC.aEk) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bOe() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, k.class, bOG().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.gnD = (k) runTask.getData();
            this.gnD.setOtherParams(JY());
        }
    }

    private void bOf() {
        this.gnJ = new e(bOG().pageContext.getPageActivity());
    }

    private void bOg() {
        this.gnL = new com.baidu.tieba.ala.liveroom.q.c(bOG().pageContext.getPageActivity());
    }

    private void registerListener() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.gon);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.goo);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerListener(this.gow);
        MessageManager.getInstance().registerListener(this.gox);
        MessageManager.getInstance().registerListener(this.goz);
        MessageManager.getInstance().registerListener(this.gos);
        MessageManager.getInstance().registerListener(this.got);
        MessageManager.getInstance().registerListener(this.gov);
        MessageManager.getInstance().registerListener(this.gou);
        MessageManager.getInstance().registerListener(this.fPT);
        MessageManager.getInstance().registerListener(this.goA);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fZE);
        MessageManager.getInstance().registerListener(this.fZB);
        MessageManager.getInstance().registerListener(this.bgZ);
        MessageManager.getInstance().registerListener(this.goB);
        MessageManager.getInstance().registerListener(this.goC);
        MessageManager.getInstance().registerListener(this.goD);
        MessageManager.getInstance().registerListener(this.goE);
        MessageManager.getInstance().registerListener(this.goF);
        MessageManager.getInstance().registerListener(this.gop);
        MessageManager.getInstance().registerListener(this.goq);
        MessageManager.getInstance().registerListener(this.gor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hu() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bOG().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bOG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bOG().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.w.a.Nk().beJ.aGK;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bOG().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bOG().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bOG().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bOG().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOh() {
        if (this.gnu != null) {
            this.gnu.Jg().a(this.gnA.Mi(), t.EQ().ES(), bOG().gxi.LC().mLiveInfo);
            lK(true);
            if (this.gnM == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, x.class, bOG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gnM = (x) runTask.getData();
                } else {
                    return;
                }
            }
            this.gnM.gu("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOi() {
        if (this.gnu != null) {
            this.gnu.Jg().hide();
            lK(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(int i, int i2, int i3) {
        if (bOG().gxi.LC() != null && bOG().gxi.LC().aDG != null && bOG().gxi.LC().mLiveInfo != null) {
            a(bOG().gxi.LC(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(i.class) != null && Hu()) {
            if (rVar == null) {
                rVar = bOG().gxi.LC();
            }
            String valueOf = String.valueOf(rVar.aDG.userId);
            String str = rVar.aDG.userName;
            String valueOf2 = String.valueOf(rVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(rVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(rVar.mLiveInfo.feed_id);
            int i6 = rVar.aEf.isBlock;
            String EZ = v.EZ();
            String str2 = rVar.mLiveInfo.appId;
            boolean z2 = rVar.aEf.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (rVar.mLiveInfo.live_type == 1 && rVar.mLiveInfo.screen_direction == 1 && com.baidu.live.w.a.Nk().beJ.aFN) {
                z3 = true;
            }
            int i7 = -1;
            if (rVar.aEf == null) {
                z = false;
            } else {
                boolean z4 = rVar.aEf.isNewUser;
                i7 = rVar.aEf.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.goc != null && this.goc.aXV != null && this.goc.aXV.aCw == rVar.aDG.userId) {
                z5 = this.goc.aXY;
            }
            i iVar = new i(bOG().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, EZ, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.mAlaLiveSwitchData != null) {
                iVar.aX(rVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            iVar.aV(z);
            if (com.baidu.tieba.ala.liveroom.w.b.bWy().beU != null) {
                iVar.aW(com.baidu.tieba.ala.liveroom.w.b.bWy().beU.aEI != 1);
            }
            av Io = g.Im().Io();
            if (Io == null || Io.aIS <= 0) {
                i5 = 1000;
            } else {
                i5 = Io.aIS;
            }
            iVar.dx(i5);
            boolean z6 = false;
            if (rVar != null && rVar.aEf != null) {
                String str3 = rVar.aEf.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            iVar.aY(z6);
            boolean z7 = true;
            be beVar = com.baidu.live.w.a.Nk().bkd;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (beVar != null && beVar.aJD != null && (!beVar.aJD.aLx || !beVar.aJD.aLy)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            iVar.aZ(z7);
            if (rVar != null && rVar.aEh != null) {
                iVar.fG(rVar.aEh.toJsonString());
            }
            if (!this.gog) {
                this.goh = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, iVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOj() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        ez(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bk bkVar) {
        if (bkVar != null && Hu()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(bOG().pageContext.getPageActivity(), bkVar.aKi, bkVar.liveId, bkVar.aKj)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && com.baidu.live.w.a.Nk().beJ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bOG().pageContext.getPageActivity(), String.valueOf(rVar.mLiveInfo.live_id), String.valueOf(rVar.mLiveInfo.user_id), com.baidu.live.w.a.Nk().beJ.aHk, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, NobleDetailInfo nobleDetailInfo) {
        if (Hu() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (rVar != null) {
                if (rVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(rVar.mLiveInfo.live_id));
                }
                if (rVar.aDG != null) {
                    hashMap.put("anchor_id", Long.valueOf(rVar.aDG.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.EZ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bOG().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOk() {
        if (this.gnA != null) {
            this.gnA.d(this.gne.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOl() {
        r LC = bOG().gxi.LC();
        LogManager.getCommonLogger().doClickQuickImHiLog((LC == null || LC.mLiveInfo == null) ? "" : LC.mLiveInfo.feed_id, JY());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FS(String str) {
        if (this.gnA != null) {
            this.gnA.gx(str);
        }
    }

    private void bOm() {
        if ("home_rec_play".equals(bOG().fromType) || "frs_play".equals(bOG().fromType) || "frs_live_play".equals(bOG().fromType) || "person_play".equals(bOG().fromType) || "search".equals(bOG().fromType) || "person_attention".equals(bOG().fromType)) {
            com.baidu.live.b.AC().aU(true);
        } else {
            com.baidu.live.b.AC().aU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lL(boolean z) {
        View ED;
        if (this.gnw == null) {
            f fVar = new f();
            fVar.aMJ = false;
            fVar.context = bOG().pageContext.getPageActivity();
            fVar.aMS = z;
            fVar.fromType = bOG().fromType;
            fVar.aMT = bNf() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnw = (w) runTask.getData();
            }
        }
        if (this.gnw != null && (ED = this.gnw.ED()) != null && this.gne.gxj.indexOfChild(ED) < 0) {
            this.gne.gxj.addView(ED, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOn() {
        View Fc;
        if (this.gnH == null) {
            ab abVar = new ab();
            abVar.aMJ = false;
            abVar.pageContext = bOG().pageContext;
            abVar.fromType = bOG().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnH = (y) runTask.getData();
            }
        }
        if (this.gnH != null && (Fc = this.gnH.Fc()) != null && bOG().gxj.indexOfChild(Fc) < 0) {
            if (Fc.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fc.getParent()).removeView(Fc);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bOG().gxj.addView(Fc, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOo() {
        View EV;
        if (this.gnx == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aMJ = false;
            aVar.context = bOG().pageContext.getPageActivity();
            aVar.fromType = bOG().fromType;
            aVar.aMK = bOG().gxn;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnx = (u) runTask.getData();
            }
        }
        if (this.gnx != null && (EV = this.gnx.EV()) != null && bOG().gxj.indexOfChild(EV) < 0) {
            if (EV.getParent() instanceof ViewGroup) {
                ((ViewGroup) EV.getParent()).removeView(EV);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bOG().gxj.addView(EV, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOp() {
        CustomResponsedMessage runTask;
        if (this.gnv == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bOG().pageContext)) != null) {
            this.gnv = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gnv != null) {
            this.gnv.setOtherParams(this.otherParams);
            this.gnv.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
                @Override // com.baidu.live.im.b.a.InterfaceC0175a
                public void JC() {
                    b.this.bOs();
                }
            });
            this.gnv.a(bOG().gxi.LC(), false);
            View AZ = this.gnv.AZ();
            if (AZ != null && this.gnW.indexOfChild(AZ) < 0) {
                Resources resources = bOG().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bOG().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.gnW.addView(AZ, layoutParams);
            }
        }
    }

    private void bOq() {
        if (this.gns == null) {
            this.gns = new com.baidu.tieba.ala.liveroom.h.a(bOG().pageContext);
        }
        if (this.gob != null) {
            this.gns.FV(this.gob.user_id);
        }
        this.gns.as(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lM(boolean z) {
        if (bOG() != null && !z) {
            if (this.gnP == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bOG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gnP = (com.baidu.live.i.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gnP.a(bNO(), bOz());
            if (bOG().gxi != null) {
                this.gnP.a(bOG().gxi.LC());
            }
            this.gnP.setCanVisible(true);
            this.gnP.bK(true);
            this.gnP.a(bOG().gxi.bIw());
        }
    }

    private void bOr() {
        if (this.gnF == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bOG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gnF = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bOG().gxi.LC() != null && bOG().gxi.LC().aDG != null && bOG().gxi.LC().mLiveInfo != null) {
            this.gnF.setHost(false);
            this.gnF.setOtherParams(JY());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bOG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            this.gnF.a(this.gnV, layoutParams, bOG().gxi.LC());
            this.gnF.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
                @Override // com.baidu.live.guardclub.l
                public void Is() {
                    b.this.bOH();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x0683, code lost:
        FO(r32);
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
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
        long j3;
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
                    if (this.bek != null) {
                        this.bek.ca(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        tS(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bOG().gxi.LC().aEf.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bOG().gxi.LC().aEf.isAdmin = 0;
                            bOG().gxi.bVB();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bOG().gxi.LC().aEf.isAdmin = 0;
                        bOG().gxi.bVB();
                    }
                } else if ("task".equals(optString2)) {
                    ds(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gny != null && !bOG().gxm) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bOG().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bOG().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bOG().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bKh()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gny.a(bOG().gxh.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bek != null) {
                                b.this.bek.bZ(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null) {
                        long j4 = bOG().gxi.LC().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!com.baidu.live.utils.m.i(j4, optLong2)) {
                            if (this.gnE != null) {
                                this.gnE.bW(false);
                            }
                            com.baidu.live.utils.m.j(j4, optLong2);
                        }
                    }
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.t.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bOG().gxi.LC() != null && bOG().gxi.LC().aEf != null && bOG().gxi.LC().aEf.userId == optLong3) {
                        bOG().gxi.LC().aEf.isBlock = 1;
                        bNA();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bOG().gxi.LC() != null && bOG().gxi.LC().aEf != null && bOG().gxi.LC().aEf.userId == optLong4) {
                        bOG().gxi.LC().aEf.isBlock = 0;
                        bNA();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bOG().gxi.LC() != null && bOG().gxi.LC().aEf != null && bOG().gxi.LC().aEf.userId == optLong5) {
                        bOG().gxi.LC().aEf.isUegBlock = 1;
                        bNA();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (bOG().gxi.LC() != null && bOG().gxi.LC().aEf != null && bOG().gxi.LC().aEf.userId == optLong6) {
                        bOG().gxi.LC().aEf.isUegBlock = 0;
                        bNA();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bOG() != null && bOG().gxi != null && bOG().gxi.LC() != null && bOG().gxi.LC().aEf != null) {
                        if (bOG().gxi.LC().aEf.userId == jSONObject2.optLong("user_id")) {
                            bOG().gxi.bVB();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bOG().gxi.LC().aEf));
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong7 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str2 = optLong7 + "";
                        TbadkCoreApplication.getInst();
                        if (str2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                } else if ("privilege_award_royal_success".equals(optString2)) {
                    String str3 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a JK = aVar.JK();
                    if (JK != null && v.gr(str3)) {
                        v.d(str3, 1L, "", "", JK.userId, JK.portrait, JK.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        aq aqVar = new aq();
                        aqVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, aqVar));
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
            if (this.gnp != null) {
                this.gnp.C(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a JK2 = aVar.JK();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong8 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str4 = null;
            if (bOG().gxi == null || bOG().gxi.LC() == null || bOG().gxi.LC().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bOG().gxi.LC().mLiveInfo.live_id;
                long j6 = bOG().gxi.LC().mLiveInfo.group_id;
                long j7 = bOG().gxi.LC().aDG.userId;
                str4 = bOG().gxi.LC().mLiveInfo.appId;
                j = j7;
                j2 = j5;
                j3 = j6;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    v.b(optString9, JK2.userId, JK2.portrait, JK2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                } else if (com.baidu.live.w.d.Nr().hd(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                v.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, JK2.userId, JK2.portrait, JK2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", aVar.getMsgId());
                FO(optString3);
            }
            com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
            cVar.gwN = optLong8;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void FO(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOs() {
        if (bOt()) {
            BdUtilHelper.hideSoftKeyPad(bOG().pageContext.getPageActivity(), bOG().gxh.getLiveContainerView());
            bNL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOt() {
        if (bNK() == null || bNK().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(r rVar) {
        CustomResponsedMessage runTask;
        bOG().gxj.setOnTouchListener(this.goG);
        bOA();
        bOB();
        bOC();
        bOq();
        bOr();
        if (this.gnn != null && bOG().gxi.LC() != null && bOG().gxi.LC().mLiveInfo != null) {
            this.gnn.cc(bOG().gxi.LC().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gnt != null) {
            this.gnt.g(bOG().gxi.LC());
        }
        if (this.gnr != null) {
            this.gnr.h(bOG().gxi.LC());
        }
        if (this.gnz != null) {
            this.gnz.c(bOG().gxi.LC(), JY());
        }
        if (this.gnA != null) {
            this.gnA.b(bOG().gxi.LC(), JY());
        }
        if (this.gnB != null) {
            this.gnB.c(bOG().gxi.LC(), JY());
        }
        if (bOG().gxj != null) {
            bOG().gxj.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean P = b.this.P(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bOt() && b.this.gnm != null) {
                        b.this.gnm.mC(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gnm != null) {
                        b.this.gnm.mC(true);
                    }
                    return P;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Lz() {
                    if (b.this.gom == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.gom) {
                        if (bVar.Lz()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bOG().gxj.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.O(motionEvent);
                }
            });
        }
        if (this.gnM == null && (runTask = MessageManager.getInstance().runTask(2913165, x.class, bOG().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gnM = (x) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOu() {
        r LC;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (bOG() != null && bOG().gxi != null && (LC = bOG().gxi.LC()) != null && LC.mLiveInfo != null && !LC.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bOG().gxh) != null) {
            if (this.gnQ == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.r.a.class, bOG().pageContext)) != null && runTask.getData() != null) {
                this.gnQ = (com.baidu.live.r.a) runTask.getData();
            }
            if (this.gnQ != null) {
                this.gnQ.o(LC);
                this.gnQ.a(this.goH);
                this.gnQ.a(viewGroup, (ViewGroup) viewGroup.findViewById(a.g.ala_live_header_view));
                a(this.gnQ.Mz());
                a(this.gnQ.MA());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gol == null) {
            this.gol = new ArrayList();
        }
        if (!this.gol.contains(dVar)) {
            this.gol.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gol != null && this.gol.contains(dVar)) {
            this.gol.remove(dVar);
        }
    }

    protected void bOv() {
        if (this.gol != null) {
            this.gol.clear();
            this.gol = null;
        }
    }

    protected boolean O(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gol == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gol.iterator();
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
        if (this.gom == null) {
            this.gom = new ArrayList();
        }
        if (!this.gom.contains(bVar)) {
            this.gom.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gom != null && this.gom.contains(bVar)) {
            this.gom.remove(bVar);
        }
    }

    protected void bOw() {
        if (this.gom != null) {
            this.gom.clear();
            this.gom = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gom == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gom.iterator();
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
    public void bOx() {
        if (this.gnO == null && this.gnS != null && this.gnS.aJN && bOG() != null && bOG().gxi != null && bOG().gxi.LC() != null) {
            this.gnO = new com.baidu.tieba.ala.liveroom.h.e(bOG().pageContext, this.gnS);
            this.gnO.t(bOG().gxi.LC());
            if (this.gnS.aJQ == 1) {
                if (this.gnu != null) {
                    this.goe = true;
                }
            } else if (this.gnS.aJQ == 2) {
                a(bOG().gxi.LC(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOy() {
        CustomResponsedMessage runTask;
        if (bOG() != null && (runTask = MessageManager.getInstance().runTask(2913130, com.baidu.live.im.k.class, bOG().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.s.a)) {
            this.gnT = (com.baidu.live.s.a) runTask.getData();
            this.gnT.p(bNN());
            if (bOG().gxi != null) {
                this.gof = this.gnT.p(bOG().gxi.LC());
            }
            this.gnT.setCanVisible(!this.gnZ);
        }
    }

    private ViewGroup.LayoutParams bOz() {
        int dimensionPixelOffset;
        if (bNf()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bOG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bOG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int J(boolean z, boolean z2) {
        Rect rect = new Rect();
        bOG().gxh.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bOG().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bOG().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bOG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bOG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bOA() {
        if (this.gnm != null) {
            this.gnm.az(bOG().gxj);
        }
    }

    private void bOB() {
        if (this.gnn != null) {
            this.gnn.aB(bOG().gxj);
        }
    }

    private void bOC() {
        if (this.gnq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.y.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gnq = (com.baidu.live.y.a) runTask.getData();
            }
            bOD();
        }
    }

    private void ds(JSONObject jSONObject) {
        if (this.gnq != null) {
            if (this.gnj != null) {
                this.gnq.cp(this.gnj.bSh() ? false : true);
            } else {
                this.gnq.cp(true);
            }
            this.gnq.N(jSONObject);
        }
    }

    private void bOD() {
        if (this.gnq != null && bOG().gxi.LC() != null && bOG().gxi.LC().aEp != null) {
            if (this.gnj != null) {
                this.gnq.cp(this.gnj.bSh() ? false : true);
            } else {
                this.gnq.cp(true);
            }
            this.gnq.j(bOG().gxi.LC());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(r rVar) {
        if (rVar != null) {
            if (this.gnn != null && rVar.mLiveInfo != null) {
                this.gnn.cc(rVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gnE != null) {
                this.gnE.i(rVar);
            }
            bOD();
            if (this.gns != null && rVar.aDG != null) {
                this.gns.FV(String.valueOf(rVar.aDG.userId));
            }
            if (this.gng != null) {
                this.gng.a(rVar);
            }
            if (this.gnx != null && rVar.mLiveInfo != null) {
                this.gnx.a(rVar.mLiveInfo, rVar.aDG);
            }
            if (this.gnv != null) {
                this.gnv.a(rVar);
            }
            if (this.gnT != null) {
                this.gof = this.gnT.p(rVar);
            }
            if (this.gnP != null) {
                this.gnP.a(rVar);
            }
            tS(rVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void tS(int i) {
        if (!bOG().gxm) {
            if (this.gnX < 0 && i == 0) {
                this.gnX = i;
            } else if (this.gnX != i) {
                if (i == 1) {
                    if (!this.gny.uF(2)) {
                        String string = bOG().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bOG().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gny.a(bOG().gxh.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bOG().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.gny.uG(2);
                    this.gny.uG(3);
                    if (bKh()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gny.a(bOG().gxh.getLiveContainerView(), string2, 3);
                    }
                }
                this.gnX = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cd(boolean z) {
        super.cd(z);
        if (z) {
            bOE();
        }
        if (this.gnE != null) {
            this.gnE.KP();
        }
        if (this.gnr != null) {
            this.gnr.KP();
        }
        if (this.gnp != null) {
            this.gnp.bXK();
        }
        if (this.gnh != null) {
            this.gnh.BB();
        }
        if (this.gnj != null) {
            this.gnj.onDestroy();
        }
        if (this.gnq != null) {
            this.gnq.onDestroy();
            this.gnq = null;
        }
        if (this.gnw != null) {
            View ED = this.gnw.ED();
            if (ED != null && ED.getParent() != null) {
                ((ViewGroup) ED.getParent()).removeView(ED);
            }
            this.gnw.onDestroy();
            this.gnw = null;
        }
        if (this.gnv != null) {
            this.gnv.a((a.InterfaceC0175a) null);
            this.gnv.Bb();
        }
        if (this.gny != null) {
            this.gny.BB();
        }
        this.gnX = -1;
        if (this.gns != null) {
            this.gns.BB();
            this.gns.onDestroy();
        }
        if (this.gnk != null) {
            this.gnk.bXI();
        }
        if (this.gnl != null) {
            this.gnl.bNc();
            this.gnl.Fb();
        }
        if (this.gnm != null) {
            this.gnm.Fb();
        }
        if (this.gnt != null) {
            this.gnt.Fb();
        }
        if (this.gnz != null) {
            this.gnz.KP();
        }
        if (this.gnA != null) {
            this.gnA.Fb();
        }
        if (this.gnB != null) {
            this.gnB.onDestroy();
        }
        if (this.gnD != null) {
            this.gnD.onDestory();
        }
        if (this.gnG != null) {
            this.gnG.Iq();
        }
        if (this.gnF != null) {
            this.gnF.Iq();
        }
        if (this.gnO != null) {
            this.gnO.onDestroy();
        }
        if (this.gnJ != null) {
            this.gnJ.Fb();
        }
        if (this.gnK != null) {
            this.gnK.Fb();
        }
        if (this.gnM != null) {
            this.gnM.Fb();
        }
        if (this.gni != null) {
            this.gni.onDestory();
        }
        if (this.gnT != null) {
            this.gnT.Fb();
        }
        if (this.gnP != null) {
            this.gnP.Iq();
        }
        if (this.gnL != null) {
            this.gnL.Fb();
        }
        if (this.gnH != null) {
            this.gnH.onDestroy();
        }
        if (this.gnQ != null) {
            this.gnQ.BB();
            b(this.gnQ.Mz());
            b(this.gnQ.MA());
        }
        if (this.gnR != null) {
            this.gnR.Iq();
        }
        ShowUtil.windowCount = 0;
        bOv();
        bOw();
    }

    private void bOE() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bOG().gxj.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bOG().gxj.getChildAt(i);
            if (childAt != this.gnV && childAt != this.gnW) {
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
        if (this.gnV != null) {
            this.gnV.removeAllViews();
        }
        if (this.gnW != null) {
            this.gnW.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, r rVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(r rVar) {
        View AZ;
        View ED;
        if (this.gnw != null && (ED = this.gnw.ED()) != null && ED.getParent() != null) {
            ((ViewGroup) ED.getParent()).removeView(ED);
        }
        if (this.gnv != null && (AZ = this.gnv.AZ()) != null && AZ.getParent() != null) {
            ((ViewGroup) AZ.getParent()).removeView(AZ);
        }
        if (this.gnj != null) {
            this.gnj.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Lv() {
        if (this.gno == null || !this.gno.bSm()) {
            if (this.gnj == null || !this.gnj.av(bOG().gxh.getLiveContainerView())) {
                if (this.gnm != null) {
                    this.gnm.bKO();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gnC != null && this.gnC.bRV()) {
                    this.gnC.bSe();
                    return false;
                } else if (this.gnB == null || !this.gnB.bSp()) {
                    bOm();
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
    public void cb(boolean z) {
        super.cb(z);
        if (this.gnE != null) {
            this.gnE.release();
        }
        if (this.gnr != null) {
            this.gnr.onDestroy();
        }
        if (this.gnN != null) {
            this.gnN.destroy();
        }
        if (this.gnq != null) {
            this.gnq.onDestroy();
            this.gnq = null;
        }
        if (this.gnp != null) {
            this.gnp.bXK();
        }
        if (this.gnw != null) {
            this.gnw.onDestroy();
            this.gnw = null;
        }
        if (this.gnx != null) {
            this.gnx.onDestroy();
            this.gnx = null;
        }
        if (this.gny != null) {
            this.gny.onDestroy();
        }
        if (this.gnh != null) {
            this.gnh.onDestroy();
        }
        if (this.gnH != null) {
            this.gnH.onDestroy();
            this.gnH = null;
        }
        if (this.gnv != null) {
            this.gnv.a((a.InterfaceC0175a) null);
            this.gnv.release();
            this.gnv = null;
        }
        if (this.gnz != null) {
            this.gnz.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gnz.release();
        }
        if (this.gnA != null) {
            this.gnA.a(null);
            this.gnA.release();
        }
        if (this.gnB != null) {
            this.gnB.a((a.InterfaceC0636a) null);
            this.gnB.onDestroy();
        }
        if (this.gnF != null) {
            this.gnF.onDestroy();
        }
        if (this.gnG != null) {
            this.gnG.onDestroy();
        }
        if (this.gnD != null) {
            this.gnD.onDestory();
        }
        if (this.gnO != null) {
            this.gnO.onDestroy();
        }
        if (this.gnJ != null) {
            this.gnJ.release();
        }
        if (this.gnL != null) {
            this.gnL.release();
        }
        if (this.gnK != null) {
            this.gnK.release();
        }
        if (this.gnM != null) {
            this.gnM.release();
        }
        if (this.gni != null) {
            this.gni.onDestory();
        }
        if (this.gnT != null) {
            this.gnT.release();
        }
        if (this.gnP != null) {
            this.gnP.onDestroy();
        }
        if (this.gnm != null) {
            this.gnm.Fb();
        }
        if (this.gnQ != null) {
            this.gnQ.onDestroy();
            b(this.gnQ.Mz());
            b(this.gnQ.MA());
        }
        bOv();
        bOw();
        MessageManager.getInstance().unRegisterListener(this.gop);
        MessageManager.getInstance().unRegisterListener(this.goq);
        MessageManager.getInstance().unRegisterListener(this.gor);
        MessageManager.getInstance().unRegisterListener(this.gow);
        MessageManager.getInstance().unRegisterListener(this.gox);
        MessageManager.getInstance().unRegisterListener(this.goz);
        MessageManager.getInstance().unRegisterListener(this.gos);
        MessageManager.getInstance().unRegisterListener(this.got);
        MessageManager.getInstance().unRegisterListener(this.gov);
        MessageManager.getInstance().unRegisterListener(this.gou);
        MessageManager.getInstance().unRegisterListener(this.fPT);
        MessageManager.getInstance().unRegisterListener(this.goA);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fZE);
        MessageManager.getInstance().unRegisterListener(this.fZB);
        MessageManager.getInstance().unRegisterListener(this.bgZ);
        MessageManager.getInstance().unRegisterListener(this.goB);
        MessageManager.getInstance().unRegisterListener(this.goC);
        MessageManager.getInstance().unRegisterListener(this.goD);
        MessageManager.getInstance().unRegisterListener(this.goE);
        MessageManager.getInstance().unRegisterListener(this.goF);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gnz != null) {
            this.gnz.mk(false);
        }
        if (this.gnB != null) {
            this.gnB.mk(false);
        }
        bNL();
        if (this.gnE != null) {
            this.gnE.onPause();
        }
        if (this.gnJ != null) {
            this.gnJ.pause();
        }
        if (this.gnL != null) {
            this.gnL.pause();
        }
        if (this.gnH != null) {
            this.gnH.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.goh = false;
        if (this.goa && this.gob != null) {
            a(this.gob);
            this.goa = false;
        }
        if (this.gnz != null) {
            this.gnz.mk(true);
        }
        if (this.gnB != null) {
            this.gnB.mk(true);
        }
        if (this.gnE != null) {
            this.gnE.onResume();
        }
        if (this.gnJ != null) {
            this.gnJ.resume();
        }
        if (this.gnL != null) {
            this.gnL.resume();
        }
        if (this.gnH != null) {
            this.gnH.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aob() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gnQ != null && this.gnQ.isOpen()) {
            this.gnQ.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            aob();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra(AlaCharmCardActivityConfig.NEED_SHOW_GIFT_PANEL, false)) {
                    K(-1, -1, -1);
                    return;
                }
                return;
            }
            aob();
        } else if (i == 25034) {
            bOj();
        } else if (i == 25043) {
            if (i2 == -1) {
                bOH();
            }
        } else if (i == 25050 && this.gnN != null) {
            if (i2 == -1) {
                this.gnN.Q(intent);
            } else {
                this.gnN.Q(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gnZ = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bOF() {
        return (bOG().gxi.LC() == null || bOG().gxi.LC().mLiveInfo == null || bOG().gxi.LC().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gnj != null) {
                this.gnj.D(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gnB != null) {
            this.gnB.baR();
        }
        if (this.gni != null) {
            this.gni.baR();
        }
        if (this.gnQ != null) {
            this.gnQ.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gne = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bOG() {
        return this.gne;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        String In = g.Im().In();
        if (!TextUtils.isEmpty(In)) {
            try {
                K(-1, Integer.parseInt(In), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                K(-1, -1, -1);
            }
        }
    }

    public boolean ey(int i) {
        if (1 == i) {
            if (bNK() != null) {
                bNK().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gnZ) {
                return false;
            }
            return this.gnj == null || !this.gnj.bSh();
        } else if (3 == i) {
            if (bOG().gxj != null) {
                bOG().gxj.setEnabled(false);
                if (this.bek != null) {
                    this.bek.e(!bOG().gxk, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void tQ(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void ez(int i) {
        if (3 == i) {
            bOG().gxj.setEnabled(true);
            if (this.bek != null) {
                this.bek.e(!bOG().gxk, true);
            }
            if (this.gnq != null) {
                this.gnq.cp(true);
            }
        } else if (2 == i && this.gnp != null) {
            this.gnp.mK(true);
        }
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gnv != null) {
            this.gnv.setOtherParams(str);
        }
        if (this.gnE != null) {
            this.gnE.gV(str);
        }
    }

    private boolean bKh() {
        return bOG().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fxx = alaLastLiveroomInfo;
    }

    public void a(au auVar) {
        if (auVar != null && auVar.eventType == 1001 && this.gnE != null) {
            this.gnE.bW(false);
        }
    }
}
