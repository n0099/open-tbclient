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
    public static boolean goe;
    protected AlaLastLiveroomInfo fxt;
    protected com.baidu.live.j.b gnA;
    protected h gnB;
    protected j gnC;
    protected y gnD;
    protected e gnF;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gnG;
    protected com.baidu.tieba.ala.liveroom.q.c gnH;
    private x gnI;
    protected com.baidu.tieba.ala.liveroom.v.a gnJ;
    protected com.baidu.tieba.ala.liveroom.h.e gnK;
    protected com.baidu.live.i.a gnL;
    protected com.baidu.live.r.a gnM;
    protected com.baidu.tieba.ala.liveroom.exclusive.b gnN;
    protected bf gnO;
    protected com.baidu.live.s.a gnP;
    protected com.baidu.tieba.ala.liveroom.f.a gnQ;
    protected RelativeLayout gnR;
    protected RelativeLayout gnS;
    protected boolean gnU;
    protected ah gnX;
    protected GuardClubInfoHttpResponseMessage gnY;
    boolean gnZ;
    private com.baidu.tieba.ala.liveroom.data.a gna;
    protected com.baidu.tieba.ala.liveroom.operation.a gnb;
    protected com.baidu.live.h.a gnc;
    protected com.baidu.tieba.ala.liveroom.share.c gnd;
    protected com.baidu.tieba.ala.liveroom.r.b gne;
    protected com.baidu.tieba.ala.liveroom.guide.c gnf;
    protected com.baidu.tieba.ala.liveroom.watermark.a gng;
    protected com.baidu.tieba.ala.liveroom.b.b gnh;
    protected com.baidu.tieba.ala.liveroom.praise.a gni;
    protected com.baidu.tieba.ala.liveroom.sticker.a gnj;
    protected com.baidu.tieba.ala.liveroom.guide.d gnk;
    protected com.baidu.tieba.ala.liveroom.x.a gnl;
    protected com.baidu.live.y.a gnm;
    protected com.baidu.live.y.d gnn;
    private com.baidu.tieba.ala.liveroom.h.a gno;
    private m gnp;
    k gnq;
    com.baidu.live.im.b.a gnr;
    protected w gns;
    protected u gnt;
    protected com.baidu.tieba.ala.liveroom.tippop.a gnu;
    private com.baidu.tieba.ala.liveroom.guideim.b gnv;
    protected com.baidu.live.view.input.c gnw;
    com.baidu.tieba.ala.liveroom.n.a gnx;
    protected com.baidu.tieba.ala.liveroom.guide.a gny;
    private com.baidu.live.guardclub.k gnz;
    boolean goa;
    boolean gob;
    public boolean goc;
    public boolean god;
    protected com.baidu.tieba.ala.liveroom.t.b gof;
    protected com.baidu.tieba.ala.liveroom.j.e gog;
    protected List<com.baidu.live.liveroom.g.d> goh;
    protected List<com.baidu.live.liveroom.g.b> goi;
    protected String otherParams;
    private int gnE = 0;
    private int gnT = -1;
    protected int mOrientation = 0;
    protected boolean gnV = false;
    protected boolean gnW = false;
    CustomMessageTask.CustomRunnable<Object> goj = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: bOH */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> gok = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener gol = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.live.data.y yVar;
            if ((customResponsedMessage.getData() instanceof com.baidu.live.data.y) && (yVar = (com.baidu.live.data.y) customResponsedMessage.getData()) != null) {
                b.this.a(yVar.aEC, yVar.aEy, yVar.aEz, yVar.aEA, yVar.aEB);
            }
        }
    };
    private CustomMessageListener gom = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.tQ(7);
        }
    };
    private CustomMessageListener gon = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bOi();
        }
    };
    private CustomMessageListener goo = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bOF().gxe.LC().aDE.userId);
            com.baidu.live.view.a.Qx().a(valueOf, new com.baidu.live.data.d(b.this.bOF().gxe.LC().aDE.portrait, valueOf, true, b.this.bOF().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gop = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof r) && b.this.gnd != null) {
                b.this.gnd.c((r) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bgW = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gnq != null) {
                b.this.gnq.g(t.EQ().ES());
            }
        }
    };
    private CustomMessageListener goq = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gna.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.FQ(str);
            }
        }
    };
    private CustomMessageListener gor = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bOF().pageContext.getPageActivity());
            } else if (b.this.gnd != null) {
                b.this.gnd.c(b.this.bOF().gxe.LC(), false);
            }
        }
    };
    private CustomMessageListener gos = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ah) {
                    b.this.gnW = true;
                    b.this.gnX = (ah) data;
                    b.this.b(b.this.gnX);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener got = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bOF().gxe.LC().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bOF().gxe.LC().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bOF().gxe.LC().aDE.userId);
                    if (b.this.gne == null) {
                        b.this.gne = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    b.this.gne.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gne.a(b.this.gou);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.InterfaceC0183b gou = new b.InterfaceC0183b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.o.b.InterfaceC0183b
        public void Mg() {
            if (b.this.bOF().gxe.LC() != null && b.this.bOF().gxe.LC().aEd != null) {
                b.this.bOF().gxe.LC().aEd.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener gov = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gnA != null) {
                    b.this.gnA.x(aVar);
                }
                if (b.this.gnN != null) {
                    b.this.gnN.y(aVar);
                }
                b.this.r(aVar);
            }
        }
    };
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener gow = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.gnZ = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gnx != null) {
                b.this.gnx.Fd();
            }
        }
    };
    HttpMessageListener fZA = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).aXT) != null && b.this.gnz != null && b.this.bOF() != null && b.this.bOF().gxe != null) {
                int[] iArr = new int[2];
                b.this.gnR.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gnz.a(b.this.gnR, layoutParams, aVar, b.this.bOF().gxe.LC());
                com.baidu.live.m.a.ay(aVar.liveId + "", "guard_club_join");
            }
        }
    };
    private HttpMessageListener fZx = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bOF() != null && b.this.bOF().gxe != null && b.this.bOF().gxe.LC() != null && guardClubInfoHttpResponseMessage.aXT != null) {
                    if (guardClubInfoHttpResponseMessage.aXT.aCu == b.this.bOF().gxe.LC().aDE.userId) {
                        b.this.gnY = guardClubInfoHttpResponseMessage;
                        if (b.this.gnY.aXW && com.baidu.live.guardclub.e.Il() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.Il().ah(b.this.bOF().gxe.LC().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gox = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bk) {
                b.this.a((bk) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener goy = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.r(b.this.bOF().gxe.LC());
        }
    };
    private CustomMessageListener goz = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gnL != null) {
                b.this.gnL.It();
            }
        }
    };
    private CustomMessageListener goA = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gnD != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) b.this.gnD).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener goB = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bOF().gxe.LC(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private View.OnTouchListener goC = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bOr();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.r.b goD = new com.baidu.live.r.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // com.baidu.live.r.b
        public boolean MB() {
            if (b.this.bOF().gxf != null) {
                if (b.this.bOF().gxf.getKeyboardVisibility()) {
                    return false;
                }
                if (!b.this.bOF().gxf.bXm()) {
                    b.this.gnM.close();
                    return false;
                } else if (b.this.bOF().gxf.getScrollX() != 0) {
                    b.this.gnM.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void a(ah ahVar);

    protected abstract void b(ah ahVar);

    protected abstract View bNJ();

    public abstract boolean bNK();

    protected abstract boolean bNL();

    protected abstract ViewGroup bNM();

    protected abstract ViewGroup bNN();

    public abstract boolean bNe();

    protected abstract void bNz();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bf bfVar) {
        this.gnO = bfVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gnR = (RelativeLayout) bOF().gxf.findViewById(a.g.ala_live_header_view);
        this.gnS = (RelativeLayout) bOF().gxf.findViewById(a.g.ala_live_footer_view);
        FF();
        registerListener();
    }

    public void bNS() {
    }

    private void FF() {
        if (this.gnd == null) {
            this.gnd = new com.baidu.tieba.ala.liveroom.share.c(bOF().pageContext);
        }
        this.gnl = new com.baidu.tieba.ala.liveroom.x.a(bOF().pageContext, this);
        this.gnh = new com.baidu.tieba.ala.liveroom.b.b(bOF().pageContext, false);
        this.gni = new com.baidu.tieba.ala.liveroom.praise.a(bOF().pageContext);
        this.gnj = new com.baidu.tieba.ala.liveroom.sticker.a(bOF().pageContext);
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
                this.gnk = new com.baidu.tieba.ala.liveroom.guide.d(bOF().pageContext);
            }
        }
        this.gnu = new com.baidu.tieba.ala.liveroom.tippop.a(bOF().pageContext, this);
        bNV();
        bNX();
        bNY();
        bNZ();
        bOd();
        bOe();
        bOf();
        bNU();
        bNT();
    }

    private void bNT() {
        CustomResponsedMessage runTask;
        if (this.gnn == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.y.d.class, bOF().pageContext)) != null && runTask.getData() != null) {
            this.gnn = (com.baidu.live.y.d) runTask.getData();
        }
    }

    private void bNU() {
        CustomResponsedMessage runTask;
        if (this.gnA == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.j.b.class, bOF().pageContext)) != null && runTask.getData() != null) {
            this.gnA = (com.baidu.live.j.b) runTask.getData();
            this.gnA.c(bOF().pageContext);
            this.gnA.KO().setTargetView(this.gnS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.gnQ == null) {
            this.gnQ = new com.baidu.tieba.ala.liveroom.f.a(bOF().pageContext);
            this.gnQ.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.gnQ.a(bOF().gxe.LC(), alaLastLiveroomInfo);
        this.gnQ.as(this.gnS);
    }

    private void bNV() {
        this.gnp = new m();
    }

    public void lH(boolean z) {
        this.gnU = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bNW() {
        r LC = bOF().gxe.LC();
        boolean z = com.baidu.live.w.a.Nk().beH.aHh;
        if (LC.mLiveInfo != null && LC.mLiveInfo.mAlaLiveSwitchData != null && LC.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = LC.aEo ? z : false;
        if (z2) {
            if (this.gnc == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bOF().pageContext);
                if (runTask != null) {
                    this.gnc = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gnc != null) {
                this.gnc.ev(1);
                View view = this.gnc.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bOF().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bOF().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.gnR.addView(view, layoutParams);
                    if (z2) {
                        this.gnc.a(LC);
                    }
                }
            }
        }
    }

    private void bNX() {
        this.gnv = new com.baidu.tieba.ala.liveroom.guideim.b(bOF().pageContext);
        this.gnv.c(this.gnS, bNe());
        this.gnv.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.18
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean Ji() {
                return b.this.Hu();
            }
        });
    }

    private void bNY() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bOF().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gnw = (com.baidu.live.view.input.c) runTask.getData();
            this.gnw.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.19
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
                    return b.this.bOb();
                }

                @Override // com.baidu.live.view.input.c.a
                public int Jn() {
                    return b.this.bOc();
                }
            });
        }
    }

    private void bNZ() {
        this.gnx = new com.baidu.tieba.ala.liveroom.n.a(this.gna.pageContext);
        this.gnx.a(new a.InterfaceC0636a() { // from class: com.baidu.tieba.ala.liveroom.d.b.20
            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0636a
            public boolean bOI() {
                return b.this.bNL();
            }

            @Override // com.baidu.tieba.ala.liveroom.n.a.InterfaceC0636a
            public void onClose() {
                if (b.this.bei != null) {
                    b.this.bei.bY(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lI(boolean z) {
        if (this.gnv != null) {
            this.gnv.mj(z);
        }
        if (this.gnx != null) {
            this.gnx.mj(z);
        }
        goe = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bOa() {
        return goe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bOb() {
        r LC;
        if (bOF() == null || bOF().gxe == null || (LC = bOF().gxe.LC()) == null || LC.aEd == null) {
            return false;
        }
        String str = LC.aEd.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bOc() {
        r LC;
        if (bOF() != null && bOF().gxe != null && (LC = bOF().gxe.LC()) != null && !ListUtils.isEmpty(LC.aEi)) {
            for (AlaLiveMarkData alaLiveMarkData : LC.aEi) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bOd() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bOF().pageContext.getPageActivity());
        if (runTask != null && runTask.getData() != null) {
            this.gnz = (com.baidu.live.guardclub.k) runTask.getData();
            this.gnz.setOtherParams(JY());
        }
    }

    private void bOe() {
        this.gnF = new e(bOF().pageContext.getPageActivity());
    }

    private void bOf() {
        this.gnH = new com.baidu.tieba.ala.liveroom.q.c(bOF().pageContext.getPageActivity());
    }

    private void registerListener() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.goj);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.gok);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerListener(this.gos);
        MessageManager.getInstance().registerListener(this.got);
        MessageManager.getInstance().registerListener(this.gov);
        MessageManager.getInstance().registerListener(this.goo);
        MessageManager.getInstance().registerListener(this.gop);
        MessageManager.getInstance().registerListener(this.gor);
        MessageManager.getInstance().registerListener(this.goq);
        MessageManager.getInstance().registerListener(this.fPP);
        MessageManager.getInstance().registerListener(this.gow);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.fZA);
        MessageManager.getInstance().registerListener(this.fZx);
        MessageManager.getInstance().registerListener(this.bgW);
        MessageManager.getInstance().registerListener(this.gox);
        MessageManager.getInstance().registerListener(this.goy);
        MessageManager.getInstance().registerListener(this.goz);
        MessageManager.getInstance().registerListener(this.goA);
        MessageManager.getInstance().registerListener(this.goB);
        MessageManager.getInstance().registerListener(this.gol);
        MessageManager.getInstance().registerListener(this.gom);
        MessageManager.getInstance().registerListener(this.gon);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Hu() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bOF().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bOF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bOF().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.w.a.Nk().beH.aGI;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bOF().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bOF().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bOF().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bOF().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOg() {
        if (this.gnq != null) {
            this.gnq.Jg().a(this.gnw.Mi(), t.EQ().ES(), bOF().gxe.LC().mLiveInfo);
            lI(true);
            if (this.gnI == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, x.class, bOF().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gnI = (x) runTask.getData();
                } else {
                    return;
                }
            }
            this.gnI.gt("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOh() {
        if (this.gnq != null) {
            this.gnq.Jg().hide();
            lI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(int i, int i2, int i3) {
        if (bOF().gxe.LC() != null && bOF().gxe.LC().aDE != null && bOF().gxe.LC().mLiveInfo != null) {
            a(bOF().gxe.LC(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(i.class) != null && Hu()) {
            if (rVar == null) {
                rVar = bOF().gxe.LC();
            }
            String valueOf = String.valueOf(rVar.aDE.userId);
            String str = rVar.aDE.userName;
            String valueOf2 = String.valueOf(rVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(rVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(rVar.mLiveInfo.feed_id);
            int i6 = rVar.aEd.isBlock;
            String EZ = v.EZ();
            String str2 = rVar.mLiveInfo.appId;
            boolean z2 = rVar.aEd.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (rVar.mLiveInfo.live_type == 1 && rVar.mLiveInfo.screen_direction == 1 && com.baidu.live.w.a.Nk().beH.aFL) {
                z3 = true;
            }
            int i7 = -1;
            if (rVar.aEd == null) {
                z = false;
            } else {
                boolean z4 = rVar.aEd.isNewUser;
                i7 = rVar.aEd.levelId;
                z = z4;
            }
            boolean z5 = true;
            if (this.gnY != null && this.gnY.aXT != null && this.gnY.aXT.aCu == rVar.aDE.userId) {
                z5 = this.gnY.aXW;
            }
            i iVar = new i(bOF().pageContext.getPageActivity(), valueOf, str, valueOf2, valueOf3, i6, EZ, str2, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (rVar != null && rVar.mLiveInfo != null && rVar.mLiveInfo.mAlaLiveSwitchData != null) {
                iVar.aX(rVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            iVar.aV(z);
            if (com.baidu.tieba.ala.liveroom.w.b.bWx().beS != null) {
                iVar.aW(com.baidu.tieba.ala.liveroom.w.b.bWx().beS.aEG != 1);
            }
            av Io = g.Im().Io();
            if (Io == null || Io.aIQ <= 0) {
                i5 = 1000;
            } else {
                i5 = Io.aIQ;
            }
            iVar.dx(i5);
            boolean z6 = false;
            if (rVar != null && rVar.aEd != null) {
                String str3 = rVar.aEd.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str3) || TextUtils.isEmpty(currentAccount) || !str3.equals(currentAccount)) ? false : true;
            }
            iVar.aY(z6);
            boolean z7 = true;
            be beVar = com.baidu.live.w.a.Nk().bka;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (beVar != null && beVar.aJB != null && (!beVar.aJB.aLv || !beVar.aJB.aLw)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            iVar.aZ(z7);
            if (rVar != null && rVar.aEf != null) {
                iVar.fF(rVar.aEf.toJsonString());
            }
            if (!this.goc) {
                this.god = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, iVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOi() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        ez(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bk bkVar) {
        if (bkVar != null && Hu()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(bOF().pageContext.getPageActivity(), bkVar.aKg, bkVar.liveId, bkVar.aKh)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && com.baidu.live.w.a.Nk().beH != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bOF().pageContext.getPageActivity(), String.valueOf(rVar.mLiveInfo.live_id), String.valueOf(rVar.mLiveInfo.user_id), com.baidu.live.w.a.Nk().beH.aHi, 1, false)));
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
                if (rVar.aDE != null) {
                    hashMap.put("anchor_id", Long.valueOf(rVar.aDE.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.EZ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bOF().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOj() {
        if (this.gnw != null) {
            this.gnw.d(this.gna.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOk() {
        r LC = bOF().gxe.LC();
        LogManager.getCommonLogger().doClickQuickImHiLog((LC == null || LC.mLiveInfo == null) ? "" : LC.mLiveInfo.feed_id, JY());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void FR(String str) {
        if (this.gnw != null) {
            this.gnw.gw(str);
        }
    }

    private void bOl() {
        if ("home_rec_play".equals(bOF().fromType) || "frs_play".equals(bOF().fromType) || "frs_live_play".equals(bOF().fromType) || "person_play".equals(bOF().fromType) || "search".equals(bOF().fromType) || "person_attention".equals(bOF().fromType)) {
            com.baidu.live.b.AC().aU(true);
        } else {
            com.baidu.live.b.AC().aU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lJ(boolean z) {
        View ED;
        if (this.gns == null) {
            f fVar = new f();
            fVar.aMH = false;
            fVar.context = bOF().pageContext.getPageActivity();
            fVar.aMQ = z;
            fVar.fromType = bOF().fromType;
            fVar.aMR = bNe() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gns = (w) runTask.getData();
            }
        }
        if (this.gns != null && (ED = this.gns.ED()) != null && this.gna.gxf.indexOfChild(ED) < 0) {
            this.gna.gxf.addView(ED, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOm() {
        View Fc;
        if (this.gnD == null) {
            ab abVar = new ab();
            abVar.aMH = false;
            abVar.pageContext = bOF().pageContext;
            abVar.fromType = bOF().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnD = (y) runTask.getData();
            }
        }
        if (this.gnD != null && (Fc = this.gnD.Fc()) != null && bOF().gxf.indexOfChild(Fc) < 0) {
            if (Fc.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fc.getParent()).removeView(Fc);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bOF().gxf.addView(Fc, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOn() {
        View EV;
        if (this.gnt == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aMH = false;
            aVar.context = bOF().pageContext.getPageActivity();
            aVar.fromType = bOF().fromType;
            aVar.aMI = bOF().gxj;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnt = (u) runTask.getData();
            }
        }
        if (this.gnt != null && (EV = this.gnt.EV()) != null && bOF().gxf.indexOfChild(EV) < 0) {
            if (EV.getParent() instanceof ViewGroup) {
                ((ViewGroup) EV.getParent()).removeView(EV);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bOF().gxf.addView(EV, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOo() {
        CustomResponsedMessage runTask;
        if (this.gnr == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bOF().pageContext)) != null) {
            this.gnr = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gnr != null) {
            this.gnr.setOtherParams(this.otherParams);
            this.gnr.a(new a.InterfaceC0175a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
                @Override // com.baidu.live.im.b.a.InterfaceC0175a
                public void JC() {
                    b.this.bOr();
                }
            });
            this.gnr.a(bOF().gxe.LC(), false);
            View AZ = this.gnr.AZ();
            if (AZ != null && this.gnS.indexOfChild(AZ) < 0) {
                Resources resources = bOF().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bOF().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.gnS.addView(AZ, layoutParams);
            }
        }
    }

    private void bOp() {
        if (this.gno == null) {
            this.gno = new com.baidu.tieba.ala.liveroom.h.a(bOF().pageContext);
        }
        if (this.gnX != null) {
            this.gno.FU(this.gnX.user_id);
        }
        this.gno.as(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lK(boolean z) {
        if (bOF() != null && !z) {
            if (this.gnL == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bOF().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gnL = (com.baidu.live.i.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gnL.a(bNN(), bOy());
            if (bOF().gxe != null) {
                this.gnL.a(bOF().gxe.LC());
            }
            this.gnL.setCanVisible(true);
            this.gnL.bK(true);
            this.gnL.a(bOF().gxe.bIv());
        }
    }

    private void bOq() {
        if (this.gnB == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bOF().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gnB = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bOF().gxe.LC() != null && bOF().gxe.LC().aDE != null && bOF().gxe.LC().mLiveInfo != null) {
            this.gnB.setHost(false);
            this.gnB.setOtherParams(JY());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bOF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            this.gnB.a(this.gnR, layoutParams, bOF().gxe.LC());
            this.gnB.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
                @Override // com.baidu.live.guardclub.l
                public void Is() {
                    b.this.bOG();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:211:0x0683, code lost:
        FN(r32);
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
                    if (this.bei != null) {
                        this.bei.ca(z);
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
                            bOF().gxe.LC().aEd.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bOF().gxe.LC().aEd.isAdmin = 0;
                            bOF().gxe.bVA();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bOF().gxe.LC().aEd.isAdmin = 0;
                        bOF().gxe.bVA();
                    }
                } else if ("task".equals(optString2)) {
                    ds(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gnu != null && !bOF().gxi) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bOF().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bOF().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bOF().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bKg()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gnu.a(bOF().gxd.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bei != null) {
                                b.this.bei.bZ(optInt4 == 2);
                            }
                        }
                    });
                } else if ("ui_event".equals(optString2)) {
                    if (jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bOF().gxe.LC() != null && bOF().gxe.LC().mLiveInfo != null) {
                        long j4 = bOF().gxe.LC().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!com.baidu.live.utils.m.i(j4, optLong2)) {
                            if (this.gnA != null) {
                                this.gnA.bW(false);
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
                    if (bOF().gxe.LC() != null && bOF().gxe.LC().aEd != null && bOF().gxe.LC().aEd.userId == optLong3) {
                        bOF().gxe.LC().aEd.isBlock = 1;
                        bNz();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bOF().gxe.LC() != null && bOF().gxe.LC().aEd != null && bOF().gxe.LC().aEd.userId == optLong4) {
                        bOF().gxe.LC().aEd.isBlock = 0;
                        bNz();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bOF().gxe.LC() != null && bOF().gxe.LC().aEd != null && bOF().gxe.LC().aEd.userId == optLong5) {
                        bOF().gxe.LC().aEd.isUegBlock = 1;
                        bNz();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (bOF().gxe.LC() != null && bOF().gxe.LC().aEd != null && bOF().gxe.LC().aEd.userId == optLong6) {
                        bOF().gxe.LC().aEd.isUegBlock = 0;
                        bNz();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bOF() != null && bOF().gxe != null && bOF().gxe.LC() != null && bOF().gxe.LC().aEd != null) {
                        if (bOF().gxe.LC().aEd.userId == jSONObject2.optLong("user_id")) {
                            bOF().gxe.bVA();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bOF().gxe.LC().aEd));
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
                    if (JK != null && v.gq(str3)) {
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
            if (this.gnl != null) {
                this.gnl.C(aVar);
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
            if (bOF().gxe == null || bOF().gxe.LC() == null || bOF().gxe.LC().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j5 = bOF().gxe.LC().mLiveInfo.live_id;
                long j6 = bOF().gxe.LC().mLiveInfo.group_id;
                long j7 = bOF().gxe.LC().aDE.userId;
                str4 = bOF().gxe.LC().mLiveInfo.appId;
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
                                } else if (com.baidu.live.w.d.Nr().hc(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                FN(optString3);
            }
            com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
            cVar.gwJ = optLong8;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void FN(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bOr() {
        if (bOs()) {
            BdUtilHelper.hideSoftKeyPad(bOF().pageContext.getPageActivity(), bOF().gxd.getLiveContainerView());
            bNK();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bOs() {
        if (bNJ() == null || bNJ().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(r rVar) {
        CustomResponsedMessage runTask;
        bOF().gxf.setOnTouchListener(this.goC);
        bOz();
        bOA();
        bOB();
        bOp();
        bOq();
        if (this.gnj != null && bOF().gxe.LC() != null && bOF().gxe.LC().mLiveInfo != null) {
            this.gnj.cc(bOF().gxe.LC().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gnp != null) {
            this.gnp.g(bOF().gxe.LC());
        }
        if (this.gnn != null) {
            this.gnn.h(bOF().gxe.LC());
        }
        if (this.gnv != null) {
            this.gnv.c(bOF().gxe.LC(), JY());
        }
        if (this.gnw != null) {
            this.gnw.b(bOF().gxe.LC(), JY());
        }
        if (this.gnx != null) {
            this.gnx.c(bOF().gxe.LC(), JY());
        }
        if (bOF().gxf != null) {
            bOF().gxf.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean P = b.this.P(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bOs() && b.this.gni != null) {
                        b.this.gni.mA(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gni != null) {
                        b.this.gni.mA(true);
                    }
                    return P;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Lz() {
                    if (b.this.goi == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.goi) {
                        if (bVar.Lz()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bOF().gxf.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.O(motionEvent);
                }
            });
        }
        if (this.gnI == null && (runTask = MessageManager.getInstance().runTask(2913165, x.class, bOF().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gnI = (x) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOt() {
        r LC;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (bOF() != null && bOF().gxe != null && (LC = bOF().gxe.LC()) != null && LC.mLiveInfo != null && !LC.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bOF().gxd) != null) {
            if (this.gnM == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.r.a.class, bOF().pageContext)) != null && runTask.getData() != null) {
                this.gnM = (com.baidu.live.r.a) runTask.getData();
            }
            if (this.gnM != null) {
                this.gnM.o(LC);
                this.gnM.a(this.goD);
                this.gnM.a(viewGroup, (ViewGroup) viewGroup.findViewById(a.g.ala_live_header_view));
                a(this.gnM.Mz());
                a(this.gnM.MA());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.goh == null) {
            this.goh = new ArrayList();
        }
        if (!this.goh.contains(dVar)) {
            this.goh.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.goh != null && this.goh.contains(dVar)) {
            this.goh.remove(dVar);
        }
    }

    protected void bOu() {
        if (this.goh != null) {
            this.goh.clear();
            this.goh = null;
        }
    }

    protected boolean O(MotionEvent motionEvent) {
        boolean z = false;
        if (this.goh == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.goh.iterator();
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
        if (this.goi == null) {
            this.goi = new ArrayList();
        }
        if (!this.goi.contains(bVar)) {
            this.goi.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.goi != null && this.goi.contains(bVar)) {
            this.goi.remove(bVar);
        }
    }

    protected void bOv() {
        if (this.goi != null) {
            this.goi.clear();
            this.goi = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.goi == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.goi.iterator();
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
    public void bOw() {
        if (this.gnK == null && this.gnO != null && this.gnO.aJL && bOF() != null && bOF().gxe != null && bOF().gxe.LC() != null) {
            this.gnK = new com.baidu.tieba.ala.liveroom.h.e(bOF().pageContext, this.gnO);
            this.gnK.t(bOF().gxe.LC());
            if (this.gnO.aJO == 1) {
                if (this.gnq != null) {
                    this.goa = true;
                }
            } else if (this.gnO.aJO == 2) {
                a(bOF().gxe.LC(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bOx() {
        CustomResponsedMessage runTask;
        if (bOF() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bOF().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.s.a)) {
            this.gnP = (com.baidu.live.s.a) runTask.getData();
            this.gnP.p(bNM());
            if (bOF().gxe != null) {
                this.gob = this.gnP.p(bOF().gxe.LC());
            }
            this.gnP.setCanVisible(!this.gnV);
        }
    }

    private ViewGroup.LayoutParams bOy() {
        int dimensionPixelOffset;
        if (bNe()) {
            return new LinearLayout.LayoutParams(-2, -2);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 5;
        if (UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) == 2) {
            dimensionPixelOffset = bOF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds10);
        } else {
            dimensionPixelOffset = bOF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
        }
        layoutParams.topMargin = dimensionPixelOffset;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int J(boolean z, boolean z2) {
        Rect rect = new Rect();
        bOF().gxd.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bOF().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bOF().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bOF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bOF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bOz() {
        if (this.gni != null) {
            this.gni.az(bOF().gxf);
        }
    }

    private void bOA() {
        if (this.gnj != null) {
            this.gnj.aB(bOF().gxf);
        }
    }

    private void bOB() {
        if (this.gnm == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.y.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gnm = (com.baidu.live.y.a) runTask.getData();
            }
            bOC();
        }
    }

    private void ds(JSONObject jSONObject) {
        if (this.gnm != null) {
            if (this.gnf != null) {
                this.gnm.co(this.gnf.bSg() ? false : true);
            } else {
                this.gnm.co(true);
            }
            this.gnm.N(jSONObject);
        }
    }

    private void bOC() {
        if (this.gnm != null && bOF().gxe.LC() != null && bOF().gxe.LC().aEn != null) {
            if (this.gnf != null) {
                this.gnm.co(this.gnf.bSg() ? false : true);
            } else {
                this.gnm.co(true);
            }
            this.gnm.j(bOF().gxe.LC());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(r rVar) {
        if (rVar != null) {
            if (this.gnj != null && rVar.mLiveInfo != null) {
                this.gnj.cc(rVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gnA != null) {
                this.gnA.i(rVar);
            }
            bOC();
            if (this.gno != null && rVar.aDE != null) {
                this.gno.FU(String.valueOf(rVar.aDE.userId));
            }
            if (this.gnc != null) {
                this.gnc.a(rVar);
            }
            if (this.gnt != null && rVar.mLiveInfo != null) {
                this.gnt.a(rVar.mLiveInfo, rVar.aDE);
            }
            if (this.gnr != null) {
                this.gnr.a(rVar);
            }
            if (this.gnP != null) {
                this.gob = this.gnP.p(rVar);
            }
            if (this.gnL != null) {
                this.gnL.a(rVar);
            }
            tS(rVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void tS(int i) {
        if (!bOF().gxi) {
            if (this.gnT < 0 && i == 0) {
                this.gnT = i;
            } else if (this.gnT != i) {
                if (i == 1) {
                    if (!this.gnu.uF(2)) {
                        String string = bOF().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bOF().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gnu.a(bOF().gxd.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bOF().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.gnu.uG(2);
                    this.gnu.uG(3);
                    if (bKg()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gnu.a(bOF().gxd.getLiveContainerView(), string2, 3);
                    }
                }
                this.gnT = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cd(boolean z) {
        Log.i("i", "@@@ localText basesch qtcl");
        super.cd(z);
        if (z) {
            bOD();
        }
        if (this.gnA != null) {
            this.gnA.KP();
        }
        if (this.gnn != null) {
            this.gnn.KP();
        }
        if (this.gnl != null) {
            this.gnl.bXJ();
        }
        if (this.gnd != null) {
            this.gnd.BB();
        }
        if (this.gnf != null) {
            this.gnf.onDestroy();
        }
        if (this.gnm != null) {
            this.gnm.onDestroy();
            this.gnm = null;
        }
        if (this.gns != null) {
            View ED = this.gns.ED();
            if (ED != null && ED.getParent() != null) {
                ((ViewGroup) ED.getParent()).removeView(ED);
            }
            this.gns.onDestroy();
            this.gns = null;
        }
        if (this.gnr != null) {
            this.gnr.a((a.InterfaceC0175a) null);
            this.gnr.Bb();
        }
        if (this.gnu != null) {
            this.gnu.BB();
        }
        this.gnT = -1;
        if (this.gno != null) {
            this.gno.BB();
            this.gno.onDestroy();
        }
        if (this.gng != null) {
            this.gng.bXH();
        }
        if (this.gnh != null) {
            this.gnh.bNb();
            this.gnh.Fb();
        }
        if (this.gni != null) {
            this.gni.Fb();
        }
        if (this.gnp != null) {
            this.gnp.Fb();
        }
        if (this.gnv != null) {
            this.gnv.KP();
        }
        if (this.gnw != null) {
            this.gnw.Fb();
        }
        if (this.gnx != null) {
            this.gnx.onDestroy();
        }
        if (this.gnz != null) {
            this.gnz.onDestory();
        }
        if (this.gnC != null) {
            this.gnC.Iq();
        }
        if (this.gnB != null) {
            this.gnB.Iq();
        }
        if (this.gnK != null) {
            this.gnK.onDestroy();
        }
        if (this.gnF != null) {
            this.gnF.Fb();
        }
        if (this.gnG != null) {
            this.gnG.Fb();
        }
        if (this.gnI != null) {
            this.gnI.Fb();
        }
        if (this.gne != null) {
            this.gne.onDestory();
        }
        if (this.gnP != null) {
            this.gnP.Fb();
        }
        if (this.gnL != null) {
            this.gnL.Iq();
        }
        if (this.gnH != null) {
            this.gnH.Fb();
        }
        if (this.gnD != null) {
            this.gnD.onDestroy();
        }
        if (this.gnM != null) {
            this.gnM.BB();
            b(this.gnM.Mz());
            b(this.gnM.MA());
        }
        if (this.gnN != null) {
            this.gnN.Iq();
        }
        ShowUtil.windowCount = 0;
        bOu();
        bOv();
    }

    private void bOD() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bOF().gxf.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bOF().gxf.getChildAt(i);
            if (childAt != this.gnR && childAt != this.gnS) {
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
        if (this.gnR != null) {
            this.gnR.removeAllViews();
        }
        if (this.gnS != null) {
            this.gnS.removeAllViews();
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
        if (this.gns != null && (ED = this.gns.ED()) != null && ED.getParent() != null) {
            ((ViewGroup) ED.getParent()).removeView(ED);
        }
        if (this.gnr != null && (AZ = this.gnr.AZ()) != null && AZ.getParent() != null) {
            ((ViewGroup) AZ.getParent()).removeView(AZ);
        }
        if (this.gnf != null) {
            this.gnf.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Lv() {
        if (this.gnk == null || !this.gnk.bSl()) {
            if (this.gnf == null || !this.gnf.av(bOF().gxd.getLiveContainerView())) {
                if (this.gni != null) {
                    this.gni.bKN();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gny != null && this.gny.bRU()) {
                    this.gny.bSd();
                    return false;
                } else if (this.gnx == null || !this.gnx.bSo()) {
                    bOl();
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
        if (this.gnA != null) {
            this.gnA.release();
        }
        if (this.gnn != null) {
            this.gnn.onDestroy();
        }
        if (this.gnJ != null) {
            this.gnJ.destroy();
        }
        if (this.gnm != null) {
            this.gnm.onDestroy();
            this.gnm = null;
        }
        if (this.gnl != null) {
            this.gnl.bXJ();
        }
        if (this.gns != null) {
            this.gns.onDestroy();
            this.gns = null;
        }
        if (this.gnt != null) {
            this.gnt.onDestroy();
            this.gnt = null;
        }
        if (this.gnu != null) {
            this.gnu.onDestroy();
        }
        if (this.gnd != null) {
            this.gnd.onDestroy();
        }
        if (this.gnD != null) {
            this.gnD.onDestroy();
            this.gnD = null;
        }
        if (this.gnr != null) {
            this.gnr.a((a.InterfaceC0175a) null);
            this.gnr.release();
            this.gnr = null;
        }
        if (this.gnv != null) {
            this.gnv.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gnv.release();
        }
        if (this.gnw != null) {
            this.gnw.a(null);
            this.gnw.release();
        }
        if (this.gnx != null) {
            this.gnx.a((a.InterfaceC0636a) null);
            this.gnx.onDestroy();
        }
        if (this.gnB != null) {
            this.gnB.onDestroy();
        }
        if (this.gnC != null) {
            this.gnC.onDestroy();
        }
        if (this.gnz != null) {
            this.gnz.onDestory();
        }
        if (this.gnK != null) {
            this.gnK.onDestroy();
        }
        if (this.gnF != null) {
            this.gnF.release();
        }
        if (this.gnH != null) {
            this.gnH.release();
        }
        if (this.gnG != null) {
            this.gnG.release();
        }
        if (this.gnI != null) {
            this.gnI.release();
        }
        if (this.gne != null) {
            this.gne.onDestory();
        }
        if (this.gnP != null) {
            this.gnP.release();
        }
        if (this.gnL != null) {
            this.gnL.onDestroy();
        }
        if (this.gni != null) {
            this.gni.Fb();
        }
        if (this.gnM != null) {
            this.gnM.onDestroy();
            b(this.gnM.Mz());
            b(this.gnM.MA());
        }
        bOu();
        bOv();
        MessageManager.getInstance().unRegisterListener(this.gol);
        MessageManager.getInstance().unRegisterListener(this.gom);
        MessageManager.getInstance().unRegisterListener(this.gon);
        MessageManager.getInstance().unRegisterListener(this.gos);
        MessageManager.getInstance().unRegisterListener(this.got);
        MessageManager.getInstance().unRegisterListener(this.gov);
        MessageManager.getInstance().unRegisterListener(this.goo);
        MessageManager.getInstance().unRegisterListener(this.gop);
        MessageManager.getInstance().unRegisterListener(this.gor);
        MessageManager.getInstance().unRegisterListener(this.goq);
        MessageManager.getInstance().unRegisterListener(this.fPP);
        MessageManager.getInstance().unRegisterListener(this.gow);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.fZA);
        MessageManager.getInstance().unRegisterListener(this.fZx);
        MessageManager.getInstance().unRegisterListener(this.bgW);
        MessageManager.getInstance().unRegisterListener(this.gox);
        MessageManager.getInstance().unRegisterListener(this.goy);
        MessageManager.getInstance().unRegisterListener(this.goz);
        MessageManager.getInstance().unRegisterListener(this.goA);
        MessageManager.getInstance().unRegisterListener(this.goB);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gnv != null) {
            this.gnv.mi(false);
        }
        if (this.gnx != null) {
            this.gnx.mi(false);
        }
        bNK();
        if (this.gnA != null) {
            this.gnA.onPause();
        }
        if (this.gnF != null) {
            this.gnF.pause();
        }
        if (this.gnH != null) {
            this.gnH.pause();
        }
        if (this.gnD != null) {
            this.gnD.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.god = false;
        if (this.gnW && this.gnX != null) {
            a(this.gnX);
            this.gnW = false;
        }
        if (this.gnv != null) {
            this.gnv.mi(true);
        }
        if (this.gnx != null) {
            this.gnx.mi(true);
        }
        if (this.gnA != null) {
            this.gnA.onResume();
        }
        if (this.gnF != null) {
            this.gnF.resume();
        }
        if (this.gnH != null) {
            this.gnH.resume();
        }
        if (this.gnD != null) {
            this.gnD.onResume();
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
        if (i == 4 && this.gnM != null && this.gnM.isOpen()) {
            this.gnM.onClose();
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
            bOi();
        } else if (i == 25043) {
            if (i2 == -1) {
                bOG();
            }
        } else if (i == 25050 && this.gnJ != null) {
            if (i2 == -1) {
                this.gnJ.Q(intent);
            } else {
                this.gnJ.Q(null);
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gnV = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bOE() {
        return (bOF().gxe.LC() == null || bOF().gxe.LC().mLiveInfo == null || bOF().gxe.LC().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gnf != null) {
                this.gnf.D(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gnx != null) {
            this.gnx.baR();
        }
        if (this.gne != null) {
            this.gne.baR();
        }
        if (this.gnM != null) {
            this.gnM.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gna = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bOF() {
        return this.gna;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOG() {
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
            if (bNJ() != null) {
                bNJ().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gnV) {
                return false;
            }
            return this.gnf == null || !this.gnf.bSg();
        } else if (3 == i) {
            if (bOF().gxf != null) {
                bOF().gxf.setEnabled(false);
                if (this.bei != null) {
                    this.bei.e(!bOF().gxg, false);
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
            bOF().gxf.setEnabled(true);
            if (this.bei != null) {
                this.bei.e(!bOF().gxg, true);
            }
            if (this.gnm != null) {
                this.gnm.co(true);
            }
        } else if (2 == i && this.gnl != null) {
            this.gnl.mI(true);
        }
    }

    public String JY() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gnr != null) {
            this.gnr.setOtherParams(str);
        }
        if (this.gnA != null) {
            this.gnA.gU(str);
        }
    }

    private boolean bKg() {
        return bOF().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fxt = alaLastLiveroomInfo;
    }

    public void a(au auVar) {
        if (auVar != null && auVar.eventType == 1001 && this.gnA != null) {
            this.gnA.bW(false);
        }
    }
}
