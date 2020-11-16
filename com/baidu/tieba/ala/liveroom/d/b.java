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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.baidu.ala.AlaCmdConfigHttp;
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
import com.baidu.live.b.u;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ah;
import com.baidu.live.data.aq;
import com.baidu.live.data.ba;
import com.baidu.live.data.bf;
import com.baidu.live.data.bn;
import com.baidu.live.data.bo;
import com.baidu.live.data.bx;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.y;
import com.baidu.live.gift.z;
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
import com.baidu.live.personmanager.e;
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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
import com.baidu.tieba.ala.liveroom.o.b;
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
    public static boolean gXp;
    protected com.baidu.live.ak.a gKF;
    protected com.baidu.live.z.a gVC;
    protected com.baidu.live.view.input.c gWA;
    com.baidu.tieba.ala.liveroom.o.b gWB;
    protected com.baidu.tieba.ala.liveroom.guide.a gWC;
    private k gWD;
    protected com.baidu.live.k.b gWE;
    protected h gWF;
    protected j gWG;
    protected ae gWH;
    protected e gWI;
    protected com.baidu.tieba.ala.liveroom.m.b gWJ;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gWK;
    protected com.baidu.tieba.ala.liveroom.r.c gWL;
    private ad gWM;
    protected com.baidu.tieba.ala.liveroom.h.e gWN;
    protected com.baidu.live.j.a gWO;
    protected com.baidu.live.r.a gWP;
    protected com.baidu.live.i.a gWQ;
    protected com.baidu.live.r.b gWR;
    protected com.baidu.live.v.a gWS;
    protected com.baidu.tieba.ala.liveroom.exclusive.b gWT;
    protected bo gWU;
    protected com.baidu.live.w.a gWV;
    protected com.baidu.tieba.ala.liveroom.f.a gWW;
    protected com.baidu.tieba.ala.player.d gWX;
    private com.baidu.live.guess.a gWY;
    protected com.baidu.live.q.a gWZ;
    private com.baidu.tieba.ala.liveroom.data.a gWe;
    protected com.baidu.tieba.ala.liveroom.operation.a gWf;
    protected com.baidu.live.h.a gWg;
    protected com.baidu.tieba.ala.liveroom.share.c gWh;
    protected com.baidu.tieba.ala.liveroom.s.b gWi;
    protected com.baidu.tieba.ala.liveroom.guide.c gWj;
    protected com.baidu.tieba.ala.liveroom.watermark.a gWk;
    protected com.baidu.tieba.ala.liveroom.b.b gWl;
    protected com.baidu.tieba.ala.liveroom.praise.a gWm;
    protected com.baidu.tieba.ala.liveroom.sticker.a gWn;
    protected com.baidu.tieba.ala.liveroom.guide.d gWo;
    protected com.baidu.tieba.ala.liveroom.x.a gWp;
    protected com.baidu.live.ad.a gWq;
    protected com.baidu.live.ad.d gWr;
    private com.baidu.tieba.ala.liveroom.h.a gWs;
    private m gWt;
    com.baidu.live.im.k gWu;
    com.baidu.live.im.b.a gWv;
    protected ab gWw;
    protected z gWx;
    protected com.baidu.tieba.ala.liveroom.tippop.a gWy;
    private com.baidu.tieba.ala.liveroom.guideim.b gWz;
    protected com.baidu.live.aj.c gXa;
    protected RelativeLayout gXb;
    protected RelativeLayout gXc;
    protected boolean gXe;
    protected aq gXh;
    protected GuardClubInfoHttpResponseMessage gXi;
    boolean gXj;
    boolean gXk;
    boolean gXl;
    public boolean gXn;
    public boolean gXo;
    protected com.baidu.tieba.ala.liveroom.u.b gXq;
    protected com.baidu.tieba.ala.liveroom.j.e gXr;
    protected List<com.baidu.live.liveroom.g.d> gXs;
    protected List<com.baidu.live.liveroom.g.b> gXt;
    CustomMessageTask gXu;
    CustomMessageTask gXv;
    protected AlaLastLiveroomInfo gaF;
    protected String otherParams;
    private int gXd = -1;
    protected int mOrientation = 0;
    protected boolean gXf = false;
    protected boolean gXg = false;
    private int gXm = a.C0195a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> gXw = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: bYf */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> gXx = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener gXy = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ah ahVar;
            if ((customResponsedMessage.getData() instanceof ah) && (ahVar = (ah) customResponsedMessage.getData()) != null) {
                b.this.a(ahVar.aIK, ahVar.aIG, ahVar.aIH, ahVar.aII, ahVar.aIJ);
            }
        }
    };
    private CustomMessageListener gXz = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.vT(7);
        }
    };
    private CustomMessageListener gXA = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bXB();
        }
    };
    private CustomMessageListener gXB = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bYd().hgk.Gz().aHk.userId);
            com.baidu.live.view.a.VO().a(valueOf, new f(b.this.bYd().hgk.Gz().aHk.portrait, valueOf, true, b.this.bYd().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gXC = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && b.this.gWh != null) {
                b.this.gWh.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bpg = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gWu != null) {
                b.this.gWu.g(y.Gt().Gv());
            }
        }
    };
    private CustomMessageListener gXD = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gWe.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.Hr(str);
            }
        }
    };
    private CustomMessageListener guI = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bYd().pageContext.getPageActivity());
            } else if (b.this.gWh != null) {
                b.this.gWh.c(b.this.bYd().hgk.Gz(), false);
            }
        }
    };
    private CustomMessageListener gXE = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof aq) {
                    b.this.gXg = true;
                    b.this.gXh = (aq) data;
                    b.this.b(b.this.gXh);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gXF = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bYd().hgk.Gz().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bYd().hgk.Gz().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bYd().hgk.Gz().aHk.userId);
                    if (b.this.gWi == null) {
                        b.this.gWi = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    b.this.gWi.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gWi.a(b.this.gXG);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b gXG = new e.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void Od() {
            if (b.this.bYd().hgk.Gz() != null && b.this.bYd().hgk.Gz().aHG != null) {
                b.this.bYd().hgk.Gz().aHG.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener gXH = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gWE != null) {
                    b.this.gWE.z(aVar);
                }
                if (b.this.gWT != null) {
                    b.this.gWT.F(aVar);
                }
                if (b.this.gWQ != null) {
                    b.this.gWQ.l(aVar);
                }
                b.this.t(aVar);
            }
        }
    };
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener gXI = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.gXj = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gWB != null) {
                b.this.gWB.GM();
            }
        }
    };
    HttpMessageListener gEI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).beL) != null && b.this.gWD != null && b.this.bYd() != null && b.this.bYd().hgk != null) {
                int[] iArr = new int[2];
                b.this.gXb.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gWD.a(b.this.gXb, layoutParams, aVar, b.this.bYd().hgk.Gz());
                com.baidu.live.o.a.aC(aVar.liveId + "", "guard_club_join");
                com.baidu.live.n.a.b(b.this.bYd().hgk.Gz().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gEF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bYd() != null && b.this.bYd().hgk != null && b.this.bYd().hgk.Gz() != null && guardClubInfoHttpResponseMessage.beL != null) {
                    if (guardClubInfoHttpResponseMessage.beL.anchorId == b.this.bYd().hgk.Gz().aHk.userId) {
                        b.this.gXi = guardClubInfoHttpResponseMessage;
                        if (b.this.gXi.beO && com.baidu.live.guardclub.e.JV() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.JV().au(b.this.bYd().hgk.Gz().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gXJ = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bx) {
                b.this.a((bx) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gXK = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (b.this.gWJ != null) {
                    b.this.gWJ.ev(bVar.url, bVar.aFW);
                }
            }
        }
    };
    private CustomMessageListener gXL = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.C(b.this.bYd().hgk.Gz());
        }
    };
    private CustomMessageListener gXM = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gWO != null) {
                b.this.gWO.Ko();
            }
        }
    };
    private CustomMessageListener gXN = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gWH != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) b.this.gWH).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gXO = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bYd().hgk.Gz(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gKG = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ak.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.gKF == null) {
                b.this.gKF = new com.baidu.live.ak.a(b.this.bYd().pageContext.getPageActivity());
            }
            b.this.gKF.a((com.baidu.live.ak.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener gXP = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.bYd().pageContext.getPageActivity() != null) {
                com.baidu.live.n.a.s(b.this.bYd().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener gXQ = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bXO();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.v.b gXR = new com.baidu.live.v.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        @Override // com.baidu.live.v.b
        public boolean OD() {
            if (b.this.bYd().hgl != null) {
                if (b.this.bYd().hgl.getKeyboardVisibility()) {
                    return false;
                }
                if (!b.this.bYd().hgl.chs()) {
                    b.this.gWS.close();
                    return false;
                } else if (b.this.bYd().hgl.getScrollX() != 0) {
                    b.this.gWS.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void a(aq aqVar);

    protected abstract void b(aq aqVar);

    protected abstract void bWR();

    public abstract boolean bWv();

    protected abstract View bXa();

    public abstract boolean bXb();

    protected abstract boolean bXc();

    protected abstract ViewGroup bXd();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bo boVar) {
        this.gWU = boVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gXb = (RelativeLayout) bYd().hgl.findViewById(a.f.ala_live_header_view);
        this.gXc = (RelativeLayout) bYd().hgl.findViewById(a.f.ala_live_footer_view);
        Hp();
        registerListener();
    }

    public void bXi() {
    }

    private void Hp() {
        if (this.gWh == null) {
            this.gWh = new com.baidu.tieba.ala.liveroom.share.c(bYd().pageContext);
        }
        this.gWp = new com.baidu.tieba.ala.liveroom.x.a(bYd().pageContext, this);
        this.gWl = new com.baidu.tieba.ala.liveroom.b.b(bYd().pageContext, false);
        this.gWm = new com.baidu.tieba.ala.liveroom.praise.a(bYd().pageContext);
        this.gWn = new com.baidu.tieba.ala.liveroom.sticker.a(bYd().pageContext);
        String subappVersionName = TbConfig.getSubappVersionName();
        if (!TextUtils.isEmpty(subappVersionName)) {
            boolean z = TbadkCoreApplication.getInst().isHaokan() && subappVersionName.startsWith("4.14.");
            if ((TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) && subappVersionName.startsWith("1.14.")) {
                z = true;
            }
            if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            }
            if (z) {
                this.gWo = new com.baidu.tieba.ala.liveroom.guide.d(bYd().pageContext);
            }
        }
        this.gWy = new com.baidu.tieba.ala.liveroom.tippop.a(bYd().pageContext, this);
        bXm();
        bXo();
        bXp();
        bXq();
        bXv();
        bXw();
        bXx();
        bXj();
        bXl();
        bXk();
        bXy();
    }

    private void bXj() {
        this.gWJ = new com.baidu.tieba.ala.liveroom.m.b(bYd().pageContext.getPageActivity());
    }

    private void bXk() {
        CustomResponsedMessage runTask;
        if (this.gWr == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ad.d.class, bYd().pageContext)) != null && runTask.getData() != null) {
            this.gWr = (com.baidu.live.ad.d) runTask.getData();
        }
    }

    private void bXl() {
        CustomResponsedMessage runTask;
        if (this.gWE == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.k.b.class, bYd().pageContext)) != null && runTask.getData() != null) {
            this.gWE = (com.baidu.live.k.b) runTask.getData();
            this.gWE.c(bYd().pageContext);
            this.gWE.MK().setTargetView(this.gXc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.gWW == null) {
            this.gWW = new com.baidu.tieba.ala.liveroom.f.a(bYd().pageContext);
            this.gWW.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.gWW.a(bYd().hgk.Gz(), alaLastLiveroomInfo);
        this.gWW.at(this.gXc);
    }

    private void bXm() {
        this.gWt = new m();
    }

    public void mN(boolean z) {
        this.gXe = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXn() {
        w Gz = bYd().hgk.Gz();
        boolean z = com.baidu.live.aa.a.Ph().bms.aLx;
        if (Gz.mLiveInfo != null && Gz.mLiveInfo.mAlaLiveSwitchData != null && Gz.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Gz.aHU ? z : false;
        if (z2) {
            if (this.gWg == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bYd().pageContext);
                if (runTask != null) {
                    this.gWg = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gWg != null) {
                this.gWg.eB(1);
                View view = this.gWg.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bYd().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bYd().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    cd(view);
                    this.gXb.addView(view, layoutParams);
                    if (z2) {
                        this.gWg.a(Gz);
                    }
                }
            }
        }
    }

    private void bXo() {
        this.gWz = new com.baidu.tieba.ala.liveroom.guideim.b(bYd().pageContext);
        this.gWz.c(this.gXc, bWv());
        this.gWz.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean Ld() {
                return b.this.Jd();
            }
        });
    }

    private void bXp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bYd().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gWA = (com.baidu.live.view.input.c) runTask.getData();
            this.gWA.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
                @Override // com.baidu.live.view.input.c.a
                public void Wj() {
                    b.this.vT(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void Wk() {
                    b.this.eL(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Ld() {
                    return b.this.Jd();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean LE() {
                    return b.this.bXt();
                }

                @Override // com.baidu.live.view.input.c.a
                public int Li() {
                    return b.this.bXu();
                }
            });
        }
    }

    private void bXq() {
        this.gWB = new com.baidu.tieba.ala.liveroom.o.b(this.gWe.pageContext);
        this.gWB.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public boolean bYg() {
                return b.this.bXc();
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void onClose() {
                if (b.this.blV != null) {
                    b.this.blV.cg(false);
                }
            }
        });
    }

    private void bXr() {
        if (this.gWY == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.gWY = (com.baidu.live.guess.a) runTask.getData();
                this.gWY.q(getActivity());
            } else {
                return;
            }
        }
        this.gWY.eC(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mO(boolean z) {
        if (this.gWz != null) {
            this.gWz.nq(z);
        }
        if (this.gWB != null) {
            this.gWB.nq(z);
        }
        gXp = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bXs() {
        return gXp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bXt() {
        w Gz;
        if (bYd() == null || bYd().hgk == null || (Gz = bYd().hgk.Gz()) == null || Gz.aHG == null) {
            return false;
        }
        String str = Gz.aHG.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bXu() {
        w Gz;
        if (bYd() != null && bYd().hgk != null && (Gz = bYd().hgk.Gz()) != null && !ListUtils.isEmpty(Gz.aHP)) {
            for (AlaLiveMarkData alaLiveMarkData : Gz.aHP) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bXv() {
        if (this.gWD == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, k.class, bYd().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWD = (k) runTask.getData();
            } else {
                return;
            }
        }
        this.gWD.setOtherParams(LU());
    }

    private void bXw() {
        if (this.gWI == null) {
            this.gWI = new com.baidu.tieba.ala.liveroom.turntable.e(bYd().pageContext.getPageActivity());
        }
    }

    private void bXx() {
        if (this.gWL == null) {
            this.gWL = new com.baidu.tieba.ala.liveroom.r.c(bYd().pageContext.getPageActivity());
        }
    }

    private void bXy() {
        if (this.gKF == null) {
            this.gKF = new com.baidu.live.ak.a(bYd().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.gXu == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.gXu = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.gXw);
            this.gXu.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gXu);
        }
        if (this.gXv == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.gXv = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.gXx);
            this.gXv.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gXv);
        }
        MessageManager.getInstance().registerListener(this.gXE);
        MessageManager.getInstance().registerListener(this.gXF);
        MessageManager.getInstance().registerListener(this.gXH);
        MessageManager.getInstance().registerListener(this.gXB);
        MessageManager.getInstance().registerListener(this.gXC);
        MessageManager.getInstance().registerListener(this.guI);
        MessageManager.getInstance().registerListener(this.gXD);
        MessageManager.getInstance().registerListener(this.guV);
        MessageManager.getInstance().registerListener(this.gXI);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gEI);
        MessageManager.getInstance().registerListener(this.gEF);
        MessageManager.getInstance().registerListener(this.bpg);
        MessageManager.getInstance().registerListener(this.gXJ);
        MessageManager.getInstance().registerListener(this.gXL);
        MessageManager.getInstance().registerListener(this.gXM);
        MessageManager.getInstance().registerListener(this.gXN);
        MessageManager.getInstance().registerListener(this.gXO);
        MessageManager.getInstance().registerListener(this.gXy);
        MessageManager.getInstance().registerListener(this.gXz);
        MessageManager.getInstance().registerListener(this.gXA);
        MessageManager.getInstance().registerListener(this.gXK);
        MessageManager.getInstance().registerListener(this.gKG);
        MessageManager.getInstance().registerListener(this.gXP);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jd() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bYd().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hr(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bYd().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bYd().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.aa.a.Ph().bms.aKW;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bYd().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = bYd().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bYd().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bYd().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXz() {
        if (this.gWu != null && this.gWA != null) {
            this.gWu.Lb().a(this.gWA.Ok(), y.Gt().Gv(), bYd().hgk.Gz().mLiveInfo);
            mO(true);
            if (this.gWM == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, ad.class, bYd().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gWM = (ad) runTask.getData();
                } else {
                    return;
                }
            }
            this.gWM.he("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXA() {
        if (this.gWu != null) {
            this.gWu.Lb().hide();
            mO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(int i, int i2, int i3) {
        if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHk != null && bYd().hgk.Gz().mLiveInfo != null) {
            a(bYd().hgk.Gz(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.b.k.class) != null && Jd()) {
            if (wVar == null) {
                wVar = bYd().hgk.Gz();
            }
            String valueOf = String.valueOf(wVar.aHk.userId);
            String str2 = wVar.aHk.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aHG.isBlock;
            String GI = aa.GI();
            String str3 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aHG.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.aa.a.Ph().bms.aJX) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aHG == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(wVar.aHG.userId);
                boolean z4 = wVar.aHG.isNewUser;
                i7 = wVar.aHG.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.gXi != null && this.gXi.beL != null && this.gXi.beL.anchorId == wVar.aHk.userId) {
                z5 = this.gXi.beO;
            }
            com.baidu.live.b.k kVar = new com.baidu.live.b.k(bYd().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, GI, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bf(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.fW(str);
            kVar.bd(z);
            if (com.baidu.tieba.ala.liveroom.w.b.cgG().bmB != null) {
                kVar.be(com.baidu.tieba.ala.liveroom.w.b.cgG().bmB.aIO != 1);
            }
            bf JY = g.JW().JY();
            if (JY == null || JY.aNk <= 0) {
                i5 = 1000;
            } else {
                i5 = JY.aNk;
            }
            kVar.dC(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aHG != null) {
                String str4 = wVar.aHG.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.bg(z6);
            boolean z7 = true;
            bn bnVar = com.baidu.live.aa.a.Ph().bsh;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bnVar != null && bnVar.aNP != null && (!bnVar.aNP.aQl || !bnVar.aNP.aQm)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.bh(z7);
            if (wVar != null && wVar.aHK != null) {
                kVar.fV(wVar.aHK.toJsonString());
            }
            if (bYd() != null && bYd().hgk != null) {
                kVar.fX(bYd().hgk.cfU());
            }
            if (!this.gXn) {
                this.gXo = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXB() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        eL(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bx bxVar) {
        if (bxVar != null && Jd()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(bYd().pageContext.getPageActivity(), bxVar.aOL, bxVar.liveId, bxVar.aOM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.aa.a.Ph().bms != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bYd().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.aa.a.Ph().bms.aLy, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (Jd() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aHk != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aHk.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.GI());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put("day", Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bYd().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bXC() {
        if (this.gWA != null) {
            this.gWA.d(this.gWe.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bXD() {
        w Gz = bYd().hgk.Gz();
        LogManager.getCommonLogger().doClickQuickImHiLog((Gz == null || Gz.mLiveInfo == null) ? "" : Gz.mLiveInfo.feed_id, LU());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hs(String str) {
        if (this.gWA != null) {
            this.gWA.hh(str);
        }
    }

    private void bXE() {
        if ("home_rec_play".equals(bYd().fromType) || "frs_play".equals(bYd().fromType) || "frs_live_play".equals(bYd().fromType) || "person_play".equals(bYd().fromType) || "search".equals(bYd().fromType) || "person_attention".equals(bYd().fromType)) {
            com.baidu.live.c.Ap().aZ(true);
        } else {
            com.baidu.live.c.Ap().aZ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mP(boolean z) {
        View FX;
        if (this.gWw == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSp = false;
            fVar.context = bYd().pageContext.getPageActivity();
            fVar.aSy = z;
            fVar.fromType = bYd().fromType;
            fVar.aSz = bWv() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ab.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWw = (ab) runTask.getData();
            }
        }
        if (this.gWw != null && (FX = this.gWw.FX()) != null && this.gWe.hgl.indexOfChild(FX) < 0) {
            this.gWe.hgl.addView(FX, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXF() {
        View GL;
        if (this.gWH == null) {
            ai aiVar = new ai();
            aiVar.aSp = false;
            aiVar.pageContext = bYd().pageContext;
            aiVar.fromType = bYd().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ae.class, aiVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWH = (ae) runTask.getData();
            }
        }
        if (this.gWH != null && (GL = this.gWH.GL()) != null && bYd().hgl.indexOfChild(GL) < 0) {
            if (GL.getParent() instanceof ViewGroup) {
                ((ViewGroup) GL.getParent()).removeView(GL);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            bYd().hgl.addView(GL, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXG() {
        View Gy;
        if (this.gWx == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSp = false;
            aVar.context = bYd().pageContext.getPageActivity();
            aVar.fromType = bYd().fromType;
            aVar.aSq = bYd().hgq;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, z.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWx = (z) runTask.getData();
            }
        }
        if (this.gWx != null && (Gy = this.gWx.Gy()) != null && this.gXb != null && this.gXb.indexOfChild(Gy) < 0) {
            if (Gy.getParent() instanceof ViewGroup) {
                ((ViewGroup) Gy.getParent()).removeView(Gy);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.gXb.addView(Gy, this.gXb.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bXH() {
        CustomResponsedMessage runTask;
        if (this.gWv == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bYd().pageContext)) != null) {
            this.gWv = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gWv != null) {
            this.gWv.setOtherParams(this.otherParams);
            this.gWv.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void Lw() {
                    b.this.bXO();
                }
            });
            this.gWv.a(bYd().hgk.Gz(), false);
            View Cb = this.gWv.Cb();
            if (Cb != null && this.gXc.indexOfChild(Cb) < 0) {
                Resources resources = bYd().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bYd().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.gXc.addView(Cb, layoutParams);
            }
        }
    }

    private void bXI() {
        if (this.gWs == null) {
            this.gWs = new com.baidu.tieba.ala.liveroom.h.a(bYd().pageContext);
        }
        if (this.gXh != null) {
            this.gWs.Hw(this.gXh.user_id);
        }
        this.gWs.at(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mQ(boolean z) {
        if (bYd() != null && !z) {
            if (this.gWO == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.j.a.class, bYd().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gWO = (com.baidu.live.j.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gWO.b(this.gXb, bXW());
            if (bYd().hgk != null) {
                this.gWO.a(bYd().hgk.Gz());
            }
            this.gWO.setCanVisible(true);
            this.gWO.bU(true);
            this.gWO.a(bYd().hgk.bQJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bWC() {
        if (bYd() != null) {
            if (this.gVC == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.z.a.class, bYd().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gVC = (com.baidu.live.z.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gVC.setIsHost(false);
            this.gVC.a(bXd(), bYd().hgk.Gz().aIi);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXJ() {
        if (bYd() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.gWP == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.r.a.class, bYd().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gWP = (com.baidu.live.r.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gWP.setIsHost(false);
            this.gWP.b(bXd(), bYd().hgk.Gz());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXK() {
        if (this.gWl != null && bYd() != null && bYd().hgk != null) {
            this.gWl.c(this.gXb, bYd().hgk.Gz());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXL() {
        if (bYd() != null) {
            if (this.gWQ == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.i.a.class, bYd().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.gWQ = (com.baidu.live.i.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.gWe.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.gWQ.a(this.gXb, bYd().hgk.Gz(), layoutParams, this.otherParams);
        }
    }

    protected void bXM() {
        if (this.gWR == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.r.b.class, bYd().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWR = (com.baidu.live.r.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHk != null && bYd().hgk.Gz().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(bYd().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(bYd().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.gWR.b(this.gXb, layoutParams, bYd().hgk.Gz());
        }
    }

    private void bXN() {
        if (this.gWF == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bYd().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWF = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHk != null && bYd().hgk.Gz().mLiveInfo != null) {
            this.gWF.setHost(false);
            this.gWF.setOtherParams(LU());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.gWF.a(this.gXb, layoutParams, bYd().hgk.Gz());
            this.gWF.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.guardclub.l
                public void Kc() {
                    b.this.bYe();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:217:0x0716, code lost:
        Ho(r36);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        long j;
        long j2;
        JSONObject jSONObject2 = null;
        try {
            if (aVar.getObjContent() instanceof JSONObject) {
                jSONObject2 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject2 = new JSONObject(aVar.getContent());
            }
            String optString = jSONObject2.optString("ext");
            if (!TextUtils.isEmpty(optString)) {
                new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
            }
            jSONObject = jSONObject2.optJSONObject("ext_data");
        } catch (JSONException e) {
            jSONObject = null;
        }
        if (this.gVC != null) {
            this.gVC.L(jSONObject2);
        }
        if (aVar.getMsgType() == 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 != null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.blV != null) {
                        this.blV.ci(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vV(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bYd().hgk.Gz().aHG.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bYd().hgk.Gz().aHG.isAdmin = 0;
                            bYd().hgk.cfE();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bYd().hgk.Gz().aHG.isAdmin = 0;
                        bYd().hgk.cfE();
                    }
                } else if ("task".equals(optString2)) {
                    dI(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gWy != null && !bYd().hgp) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bYd().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bYd().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bYd().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bSz()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gWy.a(bYd().hgj.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.blV != null) {
                                b.this.blV.ch(optInt4 == 2);
                            }
                        }
                    });
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.u.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHG != null && bYd().hgk.Gz().aHG.userId == optLong2) {
                        bYd().hgk.Gz().aHG.isBlock = 1;
                        bWR();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHG != null && bYd().hgk.Gz().aHG.userId == optLong3) {
                        bYd().hgk.Gz().aHG.isBlock = 0;
                        bWR();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHG != null && bYd().hgk.Gz().aHG.userId == optLong4) {
                        bYd().hgk.Gz().aHG.isUegBlock = 1;
                        bWR();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bYd().hgk.Gz() != null && bYd().hgk.Gz().aHG != null && bYd().hgk.Gz().aHG.userId == optLong5) {
                        bYd().hgk.Gz().aHG.isUegBlock = 0;
                        bWR();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bYd() != null && bYd().hgk != null && bYd().hgk.Gz() != null && bYd().hgk.Gz().aHG != null) {
                        if (bYd().hgk.Gz().aHG.userId == jSONObject2.optLong("user_id")) {
                            bYd().hgk.cfE();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bYd().hgk.Gz().aHG));
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (jSONObject != null) {
                        String str2 = optLong6 + "";
                        TbadkCoreApplication.getInst();
                        if (str2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                } else if ("privilege_award_royal_success".equals(optString2)) {
                    String str3 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a LF = aVar.LF();
                    if (LF != null && aa.ha(str3)) {
                        aa.d(str3, 1L, "", "", LF.userId, LF.portrait, LF.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        ba baVar = new ba();
                        baVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, baVar));
                    }
                } else if (TextUtils.equals(optString2, "challenge_mvp_punish")) {
                    if (jSONObject2 != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                    }
                } else if (TextUtils.equals(optString2, "send_redpacket")) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("live_redpacket");
                    if (optJSONObject != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913221, new RedPacketCharmInfo(optJSONObject)));
                    }
                } else if (TextUtils.equals(optString2, "mix_room_close") && this.gWX != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("source", "im_mix_room_close");
                        jSONObject3.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                        this.gWX.A("mix_room_close", jSONObject3);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.gWp != null) {
                this.gWp.J(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            String optString3 = jSONObject2.optString("content_type");
            com.baidu.live.data.a LF2 = aVar.LF();
            String optString4 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString5 = jSONObject2.optString("gift_count");
            String optString6 = jSONObject2.optString("gift_name");
            String optString7 = jSONObject2.optString("gift_url");
            String optString8 = jSONObject2.optString("attach");
            String optString9 = jSONObject2.optString("is_pk_gift", "0");
            long optLong7 = jSONObject2.optLong("charm_total");
            String optString10 = jSONObject2.optString("attach_new");
            String optString11 = jSONObject2.optString("gift_mul");
            boolean z2 = jSONObject2.optInt("is_dynamic_gift") == 1;
            boolean z3 = jSONObject2.optInt("from_gongyanfang_page") == 1;
            boolean z4 = jSONObject2.optInt("from_gongyanfang_2") == 1;
            boolean z5 = false;
            long j3 = 0;
            String str4 = null;
            if (bYd().hgk == null || bYd().hgk.Gz() == null || bYd().hgk.Gz().mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                long j4 = bYd().hgk.Gz().mLiveInfo.live_id;
                j3 = bYd().hgk.Gz().mLiveInfo.group_id;
                long j5 = bYd().hgk.Gz().aHk.userId;
                str4 = bYd().hgk.Gz().mLiveInfo.appId;
                z5 = bYd().hgk.Gz().mLiveInfo.isPubShow;
                j = j5;
                j2 = j4;
            }
            if (!z4 || z2) {
                if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                    if (jSONObject2.optInt("flag_show") == 1) {
                        aa.b(optString11, LF2.userId, LF2.portrait, LF2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString10, "", "", aVar.getMsgId());
                        try {
                            JSONArray jSONArray = new JSONArray(optString11);
                            if (jSONArray != null && jSONArray.length() > 0) {
                                int i = 0;
                                while (true) {
                                    if (i >= jSONArray.length()) {
                                        break;
                                    }
                                    if (com.baidu.live.aa.f.Px().hT(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                    aVar.setHost(z5 && z3);
                    aa.a(optString4, JavaTypesHelper.toInt(optString5, 1), optString6, optString7, LF2.userId, LF2.portrait, LF2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", (z3 || z4) ? false : true, aVar.getMsgId(), z2, jSONObject2, optString9);
                    Ho(optString4);
                }
                if (!optString3.equals("tying_gift")) {
                    com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                    cVar.hfR = optLong7;
                    cVar.liveId = j2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                }
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gWX = dVar;
    }

    protected void Ho(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bXO() {
        if (bXP()) {
            BdUtilHelper.hideSoftKeyPad(bYd().pageContext.getPageActivity(), bYd().hgj.getLiveContainerView());
            bXb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bXP() {
        if (bXa() == null || bXa().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        bYd().hgl.setOnTouchListener(this.gXQ);
        bXX();
        bXY();
        bXZ();
        bXI();
        bXN();
        bXM();
        bXr();
        if (this.gWn != null && bYd().hgk.Gz() != null && bYd().hgk.Gz().mLiveInfo != null) {
            this.gWn.cC(bYd().hgk.Gz().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gWt != null) {
            this.gWt.g(bYd().hgk.Gz());
        }
        if (this.gWr != null) {
            this.gWr.e(bYd().hgk.Gz());
        }
        if (this.gWz != null) {
            this.gWz.c(bYd().hgk.Gz(), LU());
        }
        if (this.gWA != null) {
            this.gWA.b(bYd().hgk.Gz(), LU());
        }
        if (this.gWB != null) {
            this.gWB.c(bYd().hgk.Gz(), LU());
        }
        if (this.gWY != null) {
            this.gWY.e(bYd().hgk.Gz());
        }
        if (this.gWZ != null) {
            this.gWZ.e(bYd().hgk.Gz());
        }
        if (bYd().hgl != null) {
            bYd().hgl.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bXP() && b.this.gWm != null) {
                        b.this.gWm.nJ(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gWm != null) {
                        b.this.gWm.nJ(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nr() {
                    if (b.this.gXt == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.gXt) {
                        if (bVar.Nr()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bYd().hgl.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.gWM == null && (runTask = MessageManager.getInstance().runTask(2913165, ad.class, bYd().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gWM = (ad) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXQ() {
        if (this.gWZ == null && bYd() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.q.a.class, bYd().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.gWZ = (com.baidu.live.q.a) runTask.getData();
                this.gWZ.m(bYd().hgl);
                this.gWZ.b(bYd().hgk.Gz());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXR() {
        w Gz;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (bYd() != null && bYd().hgk != null && (Gz = bYd().hgk.Gz()) != null && Gz.mLiveInfo != null && !Gz.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bYd().hgj) != null) {
            if (this.gWS == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.v.a.class, bYd().pageContext)) != null && runTask.getData() != null) {
                this.gWS = (com.baidu.live.v.a) runTask.getData();
            }
            if (this.gWS != null) {
                this.gWS.n(Gz);
                this.gWS.a(this.gXR);
                this.gWS.a(viewGroup, this.gXb);
                a(this.gWS.OB());
                a(this.gWS.OC());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXs == null) {
            this.gXs = new ArrayList();
        }
        if (!this.gXs.contains(dVar)) {
            this.gXs.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXs != null && this.gXs.contains(dVar)) {
            this.gXs.remove(dVar);
        }
    }

    protected void bXS() {
        if (this.gXs != null) {
            this.gXs.clear();
            this.gXs = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXs == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gXs.iterator();
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
        if (this.gXt == null) {
            this.gXt = new ArrayList();
        }
        if (!this.gXt.contains(bVar)) {
            this.gXt.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gXt != null && this.gXt.contains(bVar)) {
            this.gXt.remove(bVar);
        }
    }

    protected void bXT() {
        if (this.gXt != null) {
            this.gXt.clear();
            this.gXt = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXt == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gXt.iterator();
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
    public void bXU() {
        if (this.gWN == null && this.gWU != null && this.gWU.aNZ && bYd() != null && bYd().hgk != null && bYd().hgk.Gz() != null) {
            this.gWN = new com.baidu.tieba.ala.liveroom.h.e(bYd().pageContext, this.gWU);
            this.gWN.E(bYd().hgk.Gz());
            if (this.gWU.aOc == 1) {
                if (this.gWu != null) {
                    this.gXk = true;
                }
            } else if (this.gWU.aOc == 2) {
                a(bYd().hgk.Gz(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXV() {
        CustomResponsedMessage runTask;
        if (bYd() != null && (runTask = MessageManager.getInstance().runTask(2913130, com.baidu.live.im.k.class, bYd().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.w.a)) {
            this.gWV = (com.baidu.live.w.a) runTask.getData();
            this.gWV.p(bXd());
            if (bYd().hgk != null) {
                this.gXl = this.gWV.o(bYd().hgk.Gz());
            }
            this.gWV.setCanVisible(!this.gXf);
        }
    }

    private ViewGroup.LayoutParams bXW() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = bYd().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        bYd().hgj.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bYd().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bYd().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bYd().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + bYd().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void bXX() {
        if (this.gWm != null) {
            this.gWm.aA(bYd().hgl);
        }
    }

    private void bXY() {
        if (this.gWn != null) {
            this.gWn.aD(bYd().hgl);
        }
    }

    private void bXZ() {
        if (this.gWq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ad.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gWq = (com.baidu.live.ad.a) runTask.getData();
            }
            bYa();
        }
    }

    private void dI(JSONObject jSONObject) {
        if (this.gWq != null) {
            if (this.gWj != null) {
                this.gWq.cH(this.gWj.cbR() ? false : true);
            } else {
                this.gWq.cH(true);
            }
            this.gWq.P(jSONObject);
        }
    }

    private void bYa() {
        if (this.gWq != null && bYd().hgk.Gz() != null && bYd().hgk.Gz().aHT != null) {
            if (this.gWj != null) {
                this.gWq.cH(this.gWj.cbR() ? false : true);
            } else {
                this.gWq.cH(true);
            }
            this.gWq.i(bYd().hgk.Gz());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            if (this.gWn != null && wVar.mLiveInfo != null) {
                this.gWn.cC(wVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gWE != null) {
                this.gWE.h(wVar);
            }
            bYa();
            if (this.gWs != null && wVar.aHk != null) {
                this.gWs.Hw(String.valueOf(wVar.aHk.userId));
            }
            if (this.gWg != null) {
                this.gWg.a(wVar);
            }
            if (this.gWx != null && wVar.mLiveInfo != null) {
                this.gWx.a(wVar.mLiveInfo, wVar.aHk);
            }
            if (this.gWv != null) {
                this.gWv.a(wVar);
            }
            if (this.gWV != null) {
                this.gXl = this.gWV.o(wVar);
            }
            if (this.gWO != null) {
                this.gWO.a(wVar);
            }
            if (this.gWP != null) {
                this.gWP.a(wVar);
            }
            if (this.gVC != null) {
                this.gVC.a(wVar);
            }
            if (this.gWQ != null) {
                this.gWQ.a(wVar);
            }
            if (this.gWR != null) {
                this.gWR.a(wVar);
            }
            if (this.gWY != null) {
                this.gWY.b(wVar);
            }
            vV(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vV(int i) {
        if (!bYd().hgp) {
            if (this.gXd < 0 && i == 0) {
                this.gXd = i;
            } else if (this.gXd != i) {
                if (i == 1) {
                    if (!this.gWy.wJ(2)) {
                        String string = bYd().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bYd().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gWy.a(bYd().hgj.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bYd().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.gWy.wK(2);
                    this.gWy.wK(3);
                    if (bSz()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gWy.a(bYd().hgj.getLiveContainerView(), string2, 3);
                    }
                }
                this.gXd = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cl(boolean z) {
        super.cl(z);
        if (z) {
            bYb();
        }
        if (this.gWE != null) {
            this.gWE.Ke();
        }
        if (this.gWr != null) {
            this.gWr.Ke();
        }
        if (this.gWp != null) {
            this.gWp.chQ();
        }
        if (this.gWh != null) {
            this.gWh.CD();
        }
        if (this.gWj != null) {
            this.gWj.onDestroy();
        }
        if (this.gWq != null) {
            this.gWq.onDestroy();
            this.gWq = null;
        }
        if (this.gWw != null) {
            View FX = this.gWw.FX();
            if (FX != null && FX.getParent() != null) {
                ((ViewGroup) FX.getParent()).removeView(FX);
            }
            this.gWw.onDestroy();
            this.gWw = null;
        }
        if (this.gWv != null) {
            this.gWv.a((a.InterfaceC0186a) null);
            this.gWv.Cd();
        }
        if (this.gWy != null) {
            this.gWy.CD();
        }
        this.gXd = -1;
        if (this.gWs != null) {
            this.gWs.CD();
            this.gWs.onDestroy();
        }
        if (this.gWk != null) {
            this.gWk.chO();
        }
        if (this.gWl != null) {
            this.gWl.bWs();
            this.gWl.GK();
        }
        if (this.gWm != null) {
            this.gWm.GK();
        }
        if (this.gWt != null) {
            this.gWt.GK();
        }
        if (this.gWz != null) {
            this.gWz.Ke();
        }
        if (this.gWA != null) {
            this.gWA.GK();
        }
        if (this.gWB != null) {
            this.gWB.onDestroy();
        }
        if (this.gWD != null) {
            this.gWD.onDestory();
        }
        if (this.gWG != null) {
            this.gWG.Ka();
        }
        if (this.gWF != null) {
            this.gWF.Ka();
        }
        if (this.gWR != null) {
            this.gWR.Ka();
        }
        if (this.gWN != null) {
            this.gWN.onDestroy();
        }
        if (this.gWI != null) {
            this.gWI.GK();
        }
        if (this.gKF != null) {
            this.gKF.GK();
        }
        if (this.gWJ != null) {
            this.gWJ.GK();
        }
        if (this.gWK != null) {
            this.gWK.GK();
        }
        if (this.gWM != null) {
            this.gWM.GK();
        }
        if (this.gWi != null) {
            this.gWi.onDestory();
        }
        if (this.gWV != null) {
            this.gWV.GK();
        }
        if (this.gWO != null) {
            this.gWO.Ka();
        }
        if (this.gWP != null) {
            this.gWP.Ka();
        }
        if (this.gVC != null) {
            this.gVC.Ka();
        }
        if (this.gWL != null) {
            this.gWL.GK();
        }
        if (this.gWH != null) {
            this.gWH.onDestroy();
        }
        if (this.gWS != null) {
            this.gWS.CD();
            b(this.gWS.OB());
            b(this.gWS.OC());
        }
        if (this.gWT != null) {
            this.gWT.Ka();
        }
        if (this.gWQ != null) {
            this.gWQ.Ka();
        }
        if (this.gWY != null) {
            this.gWY.Ke();
        }
        if (this.gWZ != null) {
            this.gWZ.Ke();
            this.gWZ = null;
        }
        ShowUtil.windowCount = 0;
        bXS();
        bXT();
    }

    private void bYb() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bYd().hgl.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bYd().hgl.getChildAt(i);
            if (childAt != this.gXb && childAt != this.gXc) {
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
        if (this.gXb != null) {
            this.gXb.removeAllViews();
        }
        if (this.gXc != null) {
            this.gXc.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View Cb;
        View FX;
        if (this.gWw != null && (FX = this.gWw.FX()) != null && FX.getParent() != null) {
            ((ViewGroup) FX.getParent()).removeView(FX);
        }
        if (this.gWv != null && (Cb = this.gWv.Cb()) != null && Cb.getParent() != null) {
            ((ViewGroup) Cb.getParent()).removeView(Cb);
        }
        if (this.gWj != null) {
            this.gWj.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Nn() {
        if (this.gWo == null || !this.gWo.cbW()) {
            if (this.gWj == null || !this.gWj.aw(bYd().hgj.getLiveContainerView())) {
                if (this.gWm != null) {
                    this.gWm.bTf();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gWC != null && this.gWC.cbF()) {
                    this.gWC.cbO();
                    return false;
                } else if (this.gWB == null || !this.gWB.Qn()) {
                    if (this.gXa == null || !this.gXa.Qn()) {
                        bXE();
                        return true;
                    }
                    return false;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cj(boolean z) {
        super.cj(z);
        if (this.gWE != null) {
            this.gWE.release();
        }
        if (this.gWr != null) {
            this.gWr.onDestroy();
        }
        if (this.gWq != null) {
            this.gWq.onDestroy();
            this.gWq = null;
        }
        if (this.gWp != null) {
            this.gWp.chQ();
        }
        if (this.gWw != null) {
            this.gWw.onDestroy();
            this.gWw = null;
        }
        if (this.gWx != null) {
            this.gWx.onDestroy();
            this.gWx = null;
        }
        if (this.gWy != null) {
            this.gWy.onDestroy();
        }
        if (this.gWh != null) {
            this.gWh.onDestroy();
        }
        if (this.gWH != null) {
            this.gWH.onDestroy();
            this.gWH = null;
        }
        if (this.gWv != null) {
            this.gWv.a((a.InterfaceC0186a) null);
            this.gWv.release();
            this.gWv = null;
        }
        if (this.gWz != null) {
            this.gWz.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gWz.release();
        }
        if (this.gWA != null) {
            this.gWA.a(null);
            this.gWA.release();
        }
        if (this.gWB != null) {
            this.gWB.a((b.a) null);
            this.gWB.onDestroy();
        }
        if (this.gWF != null) {
            this.gWF.onDestroy();
        }
        if (this.gWG != null) {
            this.gWG.onDestroy();
        }
        if (this.gWD != null) {
            this.gWD.onDestory();
        }
        if (this.gWR != null) {
            this.gWR.onDestroy();
        }
        if (this.gWN != null) {
            this.gWN.onDestroy();
        }
        if (this.gWI != null) {
            this.gWI.release();
        }
        if (this.gKF != null) {
            this.gKF.release();
        }
        if (this.gWL != null) {
            this.gWL.release();
        }
        if (this.gWJ != null) {
            this.gWJ.release();
        }
        if (this.gWK != null) {
            this.gWK.release();
        }
        if (this.gWM != null) {
            this.gWM.release();
        }
        if (this.gWi != null) {
            this.gWi.onDestory();
        }
        if (this.gWV != null) {
            this.gWV.release();
        }
        if (this.gWO != null) {
            this.gWO.onDestroy();
        }
        if (this.gWP != null) {
            this.gWP.onDestroy();
        }
        if (this.gVC != null) {
            this.gVC.onDestroy();
        }
        if (this.gWm != null) {
            this.gWm.GK();
        }
        if (this.gWQ != null) {
            this.gWQ.onDestroy();
        }
        if (this.gWY != null) {
            this.gWY.onDestroy();
        }
        if (this.gWS != null) {
            this.gWS.onDestroy();
            b(this.gWS.OB());
            b(this.gWS.OC());
        }
        bXS();
        bXT();
        MessageManager.getInstance().unRegisterListener(this.gXy);
        MessageManager.getInstance().unRegisterListener(this.gXz);
        MessageManager.getInstance().unRegisterListener(this.gXA);
        MessageManager.getInstance().unRegisterListener(this.gXE);
        MessageManager.getInstance().unRegisterListener(this.gXF);
        MessageManager.getInstance().unRegisterListener(this.gXH);
        MessageManager.getInstance().unRegisterListener(this.gXB);
        MessageManager.getInstance().unRegisterListener(this.gXC);
        MessageManager.getInstance().unRegisterListener(this.guI);
        MessageManager.getInstance().unRegisterListener(this.gXD);
        MessageManager.getInstance().unRegisterListener(this.guV);
        MessageManager.getInstance().unRegisterListener(this.gXI);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gEI);
        MessageManager.getInstance().unRegisterListener(this.gEF);
        MessageManager.getInstance().unRegisterListener(this.bpg);
        MessageManager.getInstance().unRegisterListener(this.gXJ);
        MessageManager.getInstance().unRegisterListener(this.gXL);
        MessageManager.getInstance().unRegisterListener(this.gXM);
        MessageManager.getInstance().unRegisterListener(this.gXN);
        MessageManager.getInstance().unRegisterListener(this.gXK);
        MessageManager.getInstance().unRegisterListener(this.gXO);
        MessageManager.getInstance().unRegisterListener(this.gKG);
        MessageManager.getInstance().unRegisterListener(this.gXP);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gWz != null) {
            this.gWz.np(false);
        }
        if (this.gWB != null) {
            this.gWB.np(false);
        }
        bXb();
        if (this.gWE != null) {
            this.gWE.onPause();
        }
        if (this.gWI != null) {
            this.gWI.pause();
        }
        if (this.gKF != null) {
            this.gKF.pause();
        }
        if (this.gWL != null) {
            this.gWL.pause();
        }
        if (this.gWJ != null) {
            this.gWJ.pause();
        }
        if (this.gWH != null) {
            this.gWH.onPause();
        }
        if (this.gWQ != null) {
            this.gWQ.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gXo = false;
        if (this.gXg && this.gXh != null) {
            a(this.gXh);
            this.gXg = false;
        }
        if (this.gWz != null) {
            this.gWz.np(true);
        }
        if (this.gWB != null) {
            this.gWB.np(true);
        }
        if (this.gWE != null) {
            this.gWE.onResume();
        }
        if (this.gWI != null) {
            this.gWI.resume();
        }
        if (this.gKF != null) {
            this.gKF.resume();
        }
        if (this.gWL != null) {
            this.gWL.resume();
        }
        if (this.gWH != null) {
            this.gWH.onResume();
        }
        if (this.gWJ != null) {
            this.gWJ.resume();
        }
        if (this.gWQ != null) {
            this.gWQ.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avk() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gWS != null && this.gWS.isOpen()) {
            this.gWS.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            avk();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    O(-1, -1, -1);
                    return;
                }
                return;
            }
            avk();
        } else if (i == 25034) {
            bXB();
        } else if (i == 25043) {
            if (i2 == -1) {
                bYe();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.n.a.C(bYd().pageContext.getPageActivity(), jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (intent.hasExtra("isModifySuccess")) {
                boolean booleanExtra = intent.getBooleanExtra("isModifySuccess", false);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("action", "modify");
                    jSONObject2.put(TiebaInitialize.LogFields.ERROR_CODE, booleanExtra ? 0 : 1);
                    com.baidu.live.n.a.C(bYd().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gXf = z;
        if (this.gWZ != null) {
            this.gWZ.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bYc() {
        return (bYd().hgk.Gz() == null || bYd().hgk.Gz().mLiveInfo == null || bYd().hgk.Gz().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gWj != null) {
                this.gWj.D(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gWB != null) {
            this.gWB.big();
        }
        if (this.gWi != null) {
            this.gWi.big();
        }
        if (this.gWS != null) {
            this.gWS.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gWe = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bYd() {
        return this.gWe;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYe() {
        String JX = g.JW().JX();
        if (!TextUtils.isEmpty(JX)) {
            try {
                O(-1, Integer.parseInt(JX), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                O(-1, -1, -1);
            }
        }
    }

    public boolean eK(int i) {
        if (1 == i) {
            if (bXa() != null) {
                bXa().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gXf) {
                return false;
            }
            return this.gWj == null || !this.gWj.cbR();
        } else if (3 == i) {
            if (bYd().hgl != null) {
                bYd().hgl.setEnabled(false);
                if (this.blV != null) {
                    this.blV.e(!bYd().hgn, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void vT(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void eL(int i) {
        if (3 == i) {
            bYd().hgl.setEnabled(true);
            if (this.blV != null) {
                this.blV.e(!bYd().hgn, true);
            }
            if (this.gWq != null) {
                this.gWq.cH(true);
            }
        } else if (2 == i && this.gWp != null) {
            this.gWp.nS(true);
        }
    }

    public String LU() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gWv != null) {
            this.gWv.setOtherParams(str);
        }
        if (this.gWE != null) {
            this.gWE.hH(str);
        }
    }

    private boolean bSz() {
        return bYd().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaF = alaLastLiveroomInfo;
    }

    public void cd(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(bYd().pageContext.getPageActivity(), this.gXm);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }
}
