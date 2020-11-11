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
import com.baidu.live.guardclub.l;
import com.baidu.live.im.b.a;
import com.baidu.live.im.k;
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
import com.baidu.tieba.ala.liveroom.j.e;
import com.baidu.tieba.ala.liveroom.o.b;
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
    public static boolean gXI;
    protected com.baidu.live.ak.a gKY;
    protected com.baidu.live.z.a gVV;
    protected com.baidu.tieba.ala.liveroom.share.c gWA;
    protected com.baidu.tieba.ala.liveroom.s.b gWB;
    protected com.baidu.tieba.ala.liveroom.guide.c gWC;
    protected com.baidu.tieba.ala.liveroom.watermark.a gWD;
    protected com.baidu.tieba.ala.liveroom.b.b gWE;
    protected com.baidu.tieba.ala.liveroom.praise.a gWF;
    protected com.baidu.tieba.ala.liveroom.sticker.a gWG;
    protected com.baidu.tieba.ala.liveroom.guide.d gWH;
    protected com.baidu.tieba.ala.liveroom.x.a gWI;
    protected com.baidu.live.ad.a gWJ;
    protected com.baidu.live.ad.d gWK;
    private com.baidu.tieba.ala.liveroom.h.a gWL;
    private m gWM;
    k gWN;
    com.baidu.live.im.b.a gWO;
    protected ab gWP;
    protected z gWQ;
    protected com.baidu.tieba.ala.liveroom.tippop.a gWR;
    private com.baidu.tieba.ala.liveroom.guideim.b gWS;
    protected com.baidu.live.view.input.c gWT;
    com.baidu.tieba.ala.liveroom.o.b gWU;
    protected com.baidu.tieba.ala.liveroom.guide.a gWV;
    private com.baidu.live.guardclub.k gWW;
    protected com.baidu.live.k.b gWX;
    protected h gWY;
    protected j gWZ;
    private com.baidu.tieba.ala.liveroom.data.a gWx;
    protected com.baidu.tieba.ala.liveroom.operation.a gWy;
    protected com.baidu.live.h.a gWz;
    protected aq gXA;
    protected GuardClubInfoHttpResponseMessage gXB;
    boolean gXC;
    boolean gXD;
    boolean gXE;
    public boolean gXG;
    public boolean gXH;
    protected com.baidu.tieba.ala.liveroom.u.b gXJ;
    protected e gXK;
    protected List<com.baidu.live.liveroom.g.d> gXL;
    protected List<com.baidu.live.liveroom.g.b> gXM;
    CustomMessageTask gXN;
    CustomMessageTask gXO;
    protected ae gXa;
    protected com.baidu.tieba.ala.liveroom.turntable.e gXb;
    protected com.baidu.tieba.ala.liveroom.m.b gXc;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gXd;
    protected com.baidu.tieba.ala.liveroom.r.c gXe;
    private ad gXf;
    protected com.baidu.tieba.ala.liveroom.h.e gXg;
    protected com.baidu.live.j.a gXh;
    protected com.baidu.live.r.a gXi;
    protected com.baidu.live.i.a gXj;
    protected com.baidu.live.r.b gXk;
    protected com.baidu.live.v.a gXl;
    protected com.baidu.tieba.ala.liveroom.exclusive.b gXm;
    protected bo gXn;
    protected com.baidu.live.w.a gXo;
    protected com.baidu.tieba.ala.liveroom.f.a gXp;
    protected com.baidu.tieba.ala.player.d gXq;
    private com.baidu.live.guess.a gXr;
    protected com.baidu.live.q.a gXs;
    protected com.baidu.live.aj.c gXt;
    protected RelativeLayout gXu;
    protected RelativeLayout gXv;
    protected boolean gXx;
    protected AlaLastLiveroomInfo gaY;
    protected String otherParams;
    private int gXw = -1;
    protected int mOrientation = 0;
    protected boolean gXy = false;
    protected boolean gXz = false;
    private int gXF = a.C0197a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> gXP = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: bYM */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> gXQ = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener gXR = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ah ahVar;
            if ((customResponsedMessage.getData() instanceof ah) && (ahVar = (ah) customResponsedMessage.getData()) != null) {
                b.this.a(ahVar.aKv, ahVar.aKr, ahVar.aKs, ahVar.aKt, ahVar.aKu);
            }
        }
    };
    private CustomMessageListener gXS = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.vv(7);
        }
    };
    private CustomMessageListener gXT = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bYi();
        }
    };
    private CustomMessageListener gXU = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bYK().hgD.Hi().aIV.userId);
            com.baidu.live.view.a.Wx().a(valueOf, new f(b.this.bYK().hgD.Hi().aIV.portrait, valueOf, true, b.this.bYK().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gXV = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && b.this.gWA != null) {
                b.this.gWA.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bqR = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gWN != null) {
                b.this.gWN.g(y.Hc().He());
            }
        }
    };
    private CustomMessageListener gXW = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gWx.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.HQ(str);
            }
        }
    };
    private CustomMessageListener gvb = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bYK().pageContext.getPageActivity());
            } else if (b.this.gWA != null) {
                b.this.gWA.c(b.this.bYK().hgD.Hi(), false);
            }
        }
    };
    private CustomMessageListener gXX = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof aq) {
                    b.this.gXz = true;
                    b.this.gXA = (aq) data;
                    b.this.b(b.this.gXA);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gXY = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bYK().hgD.Hi().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bYK().hgD.Hi().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bYK().hgD.Hi().aIV.userId);
                    if (b.this.gWB == null) {
                        b.this.gWB = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    b.this.gWB.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gWB.a(b.this.gXZ);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b gXZ = new e.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void OM() {
            if (b.this.bYK().hgD.Hi() != null && b.this.bYK().hgD.Hi().aJr != null) {
                b.this.bYK().hgD.Hi().aJr.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener gYa = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gWX != null) {
                    b.this.gWX.z(aVar);
                }
                if (b.this.gXm != null) {
                    b.this.gXm.F(aVar);
                }
                if (b.this.gXj != null) {
                    b.this.gXj.l(aVar);
                }
                b.this.t(aVar);
            }
        }
    };
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener gYb = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.gXC = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gWU != null) {
                b.this.gWU.Hv();
            }
        }
    };
    HttpMessageListener gFb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bgz) != null && b.this.gWW != null && b.this.bYK() != null && b.this.bYK().hgD != null) {
                int[] iArr = new int[2];
                b.this.gXu.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gWW.a(b.this.gXu, layoutParams, aVar, b.this.bYK().hgD.Hi());
                com.baidu.live.o.a.aD(aVar.liveId + "", "guard_club_join");
                com.baidu.live.n.a.b(b.this.bYK().hgD.Hi().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gEY = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bYK() != null && b.this.bYK().hgD != null && b.this.bYK().hgD.Hi() != null && guardClubInfoHttpResponseMessage.bgz != null) {
                    if (guardClubInfoHttpResponseMessage.bgz.anchorId == b.this.bYK().hgD.Hi().aIV.userId) {
                        b.this.gXB = guardClubInfoHttpResponseMessage;
                        if (b.this.gXB.bgC && com.baidu.live.guardclub.e.KE() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.KE().au(b.this.bYK().hgD.Hi().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gYc = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bx) {
                b.this.a((bx) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gYd = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (b.this.gXc != null) {
                    b.this.gXc.ev(bVar.url, bVar.aHH);
                }
            }
        }
    };
    private CustomMessageListener gYe = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.C(b.this.bYK().hgD.Hi());
        }
    };
    private CustomMessageListener gYf = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gXh != null) {
                b.this.gXh.KX();
            }
        }
    };
    private CustomMessageListener gYg = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gXa != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) b.this.gXa).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gYh = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bYK().hgD.Hi(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gKZ = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ak.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.gKY == null) {
                b.this.gKY = new com.baidu.live.ak.a(b.this.bYK().pageContext.getPageActivity());
            }
            b.this.gKY.a((com.baidu.live.ak.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener gYi = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.bYK().pageContext.getPageActivity() != null) {
                com.baidu.live.n.a.t(b.this.bYK().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener gYj = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bYv();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.v.b gYk = new com.baidu.live.v.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        @Override // com.baidu.live.v.b
        public boolean Pm() {
            if (b.this.bYK().hgE != null) {
                if (b.this.bYK().hgE.getKeyboardVisibility()) {
                    return false;
                }
                if (!b.this.bYK().hgE.chZ()) {
                    b.this.gXl.close();
                    return false;
                } else if (b.this.bYK().hgE.getScrollX() != 0) {
                    b.this.gXl.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void a(aq aqVar);

    protected abstract void b(aq aqVar);

    protected abstract View bXH();

    public abstract boolean bXI();

    protected abstract boolean bXJ();

    protected abstract ViewGroup bXK();

    public abstract boolean bXc();

    protected abstract void bXy();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bo boVar) {
        this.gXn = boVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gXu = (RelativeLayout) bYK().hgE.findViewById(a.f.ala_live_header_view);
        this.gXv = (RelativeLayout) bYK().hgE.findViewById(a.f.ala_live_footer_view);
        HY();
        registerListener();
    }

    public void bXP() {
    }

    private void HY() {
        if (this.gWA == null) {
            this.gWA = new com.baidu.tieba.ala.liveroom.share.c(bYK().pageContext);
        }
        this.gWI = new com.baidu.tieba.ala.liveroom.x.a(bYK().pageContext, this);
        this.gWE = new com.baidu.tieba.ala.liveroom.b.b(bYK().pageContext, false);
        this.gWF = new com.baidu.tieba.ala.liveroom.praise.a(bYK().pageContext);
        this.gWG = new com.baidu.tieba.ala.liveroom.sticker.a(bYK().pageContext);
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
                this.gWH = new com.baidu.tieba.ala.liveroom.guide.d(bYK().pageContext);
            }
        }
        this.gWR = new com.baidu.tieba.ala.liveroom.tippop.a(bYK().pageContext, this);
        bXT();
        bXV();
        bXW();
        bXX();
        bYc();
        bYd();
        bYe();
        bXQ();
        bXS();
        bXR();
        bYf();
    }

    private void bXQ() {
        this.gXc = new com.baidu.tieba.ala.liveroom.m.b(bYK().pageContext.getPageActivity());
    }

    private void bXR() {
        CustomResponsedMessage runTask;
        if (this.gWK == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ad.d.class, bYK().pageContext)) != null && runTask.getData() != null) {
            this.gWK = (com.baidu.live.ad.d) runTask.getData();
        }
    }

    private void bXS() {
        CustomResponsedMessage runTask;
        if (this.gWX == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.k.b.class, bYK().pageContext)) != null && runTask.getData() != null) {
            this.gWX = (com.baidu.live.k.b) runTask.getData();
            this.gWX.c(bYK().pageContext);
            this.gWX.Nt().setTargetView(this.gXv);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.gXp == null) {
            this.gXp = new com.baidu.tieba.ala.liveroom.f.a(bYK().pageContext);
            this.gXp.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.gXp.a(bYK().hgD.Hi(), alaLastLiveroomInfo);
        this.gXp.ax(this.gXv);
    }

    private void bXT() {
        this.gWM = new m();
    }

    public void mM(boolean z) {
        this.gXx = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXU() {
        w Hi = bYK().hgD.Hi();
        boolean z = com.baidu.live.aa.a.PQ().bod.aNi;
        if (Hi.mLiveInfo != null && Hi.mLiveInfo.mAlaLiveSwitchData != null && Hi.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Hi.aJF ? z : false;
        if (z2) {
            if (this.gWz == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bYK().pageContext);
                if (runTask != null) {
                    this.gWz = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gWz != null) {
                this.gWz.eF(1);
                View view = this.gWz.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bYK().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bYK().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    ca(view);
                    this.gXu.addView(view, layoutParams);
                    if (z2) {
                        this.gWz.a(Hi);
                    }
                }
            }
        }
    }

    private void bXV() {
        this.gWS = new com.baidu.tieba.ala.liveroom.guideim.b(bYK().pageContext);
        this.gWS.c(this.gXv, bXc());
        this.gWS.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean LM() {
                return b.this.JM();
            }
        });
    }

    private void bXW() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bYK().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gWT = (com.baidu.live.view.input.c) runTask.getData();
            this.gWT.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
                @Override // com.baidu.live.view.input.c.a
                public void WS() {
                    b.this.vv(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void WT() {
                    b.this.eP(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean LM() {
                    return b.this.JM();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Mn() {
                    return b.this.bYa();
                }

                @Override // com.baidu.live.view.input.c.a
                public int LR() {
                    return b.this.bYb();
                }
            });
        }
    }

    private void bXX() {
        this.gWU = new com.baidu.tieba.ala.liveroom.o.b(this.gWx.pageContext);
        this.gWU.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public boolean bYN() {
                return b.this.bXJ();
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void onClose() {
                if (b.this.bnG != null) {
                    b.this.bnG.ce(false);
                }
            }
        });
    }

    private void bXY() {
        if (this.gXr == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.gXr = (com.baidu.live.guess.a) runTask.getData();
                this.gXr.r(getActivity());
            } else {
                return;
            }
        }
        this.gXr.eG(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mN(boolean z) {
        if (this.gWS != null) {
            this.gWS.np(z);
        }
        if (this.gWU != null) {
            this.gWU.np(z);
        }
        gXI = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bXZ() {
        return gXI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bYa() {
        w Hi;
        if (bYK() == null || bYK().hgD == null || (Hi = bYK().hgD.Hi()) == null || Hi.aJr == null) {
            return false;
        }
        String str = Hi.aJr.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bYb() {
        w Hi;
        if (bYK() != null && bYK().hgD != null && (Hi = bYK().hgD.Hi()) != null && !ListUtils.isEmpty(Hi.aJA)) {
            for (AlaLiveMarkData alaLiveMarkData : Hi.aJA) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bYc() {
        if (this.gWW == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bYK().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWW = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.gWW.setOtherParams(MD());
    }

    private void bYd() {
        if (this.gXb == null) {
            this.gXb = new com.baidu.tieba.ala.liveroom.turntable.e(bYK().pageContext.getPageActivity());
        }
    }

    private void bYe() {
        if (this.gXe == null) {
            this.gXe = new com.baidu.tieba.ala.liveroom.r.c(bYK().pageContext.getPageActivity());
        }
    }

    private void bYf() {
        if (this.gKY == null) {
            this.gKY = new com.baidu.live.ak.a(bYK().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.gXN == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.gXN = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.gXP);
            this.gXN.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gXN);
        }
        if (this.gXO == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.gXO = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.gXQ);
            this.gXO.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gXO);
        }
        MessageManager.getInstance().registerListener(this.gXX);
        MessageManager.getInstance().registerListener(this.gXY);
        MessageManager.getInstance().registerListener(this.gYa);
        MessageManager.getInstance().registerListener(this.gXU);
        MessageManager.getInstance().registerListener(this.gXV);
        MessageManager.getInstance().registerListener(this.gvb);
        MessageManager.getInstance().registerListener(this.gXW);
        MessageManager.getInstance().registerListener(this.gvo);
        MessageManager.getInstance().registerListener(this.gYb);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gFb);
        MessageManager.getInstance().registerListener(this.gEY);
        MessageManager.getInstance().registerListener(this.bqR);
        MessageManager.getInstance().registerListener(this.gYc);
        MessageManager.getInstance().registerListener(this.gYe);
        MessageManager.getInstance().registerListener(this.gYf);
        MessageManager.getInstance().registerListener(this.gYg);
        MessageManager.getInstance().registerListener(this.gYh);
        MessageManager.getInstance().registerListener(this.gXR);
        MessageManager.getInstance().registerListener(this.gXS);
        MessageManager.getInstance().registerListener(this.gXT);
        MessageManager.getInstance().registerListener(this.gYd);
        MessageManager.getInstance().registerListener(this.gKZ);
        MessageManager.getInstance().registerListener(this.gYi);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean JM() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bYK().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HQ(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bYK().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bYK().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.aa.a.PQ().bod.aMH;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bYK().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = bYK().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bYK().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bYK().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYg() {
        if (this.gWN != null && this.gWT != null) {
            this.gWN.LK().a(this.gWT.OT(), y.Hc().He(), bYK().hgD.Hi().mLiveInfo);
            mN(true);
            if (this.gXf == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, ad.class, bYK().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gXf = (ad) runTask.getData();
                } else {
                    return;
                }
            }
            this.gXf.hk("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYh() {
        if (this.gWN != null) {
            this.gWN.LK().hide();
            mN(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i, int i2, int i3) {
        if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aIV != null && bYK().hgD.Hi().mLiveInfo != null) {
            a(bYK().hgD.Hi(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.b.k.class) != null && JM()) {
            if (wVar == null) {
                wVar = bYK().hgD.Hi();
            }
            String valueOf = String.valueOf(wVar.aIV.userId);
            String str2 = wVar.aIV.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aJr.isBlock;
            String Hr = aa.Hr();
            String str3 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aJr.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.aa.a.PQ().bod.aLI) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aJr == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(wVar.aJr.userId);
                boolean z4 = wVar.aJr.isNewUser;
                i7 = wVar.aJr.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.gXB != null && this.gXB.bgz != null && this.gXB.bgz.anchorId == wVar.aIV.userId) {
                z5 = this.gXB.bgC;
            }
            com.baidu.live.b.k kVar = new com.baidu.live.b.k(bYK().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Hr, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bd(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.gc(str);
            kVar.bb(z);
            if (com.baidu.tieba.ala.liveroom.w.b.chn().bom != null) {
                kVar.bc(com.baidu.tieba.ala.liveroom.w.b.chn().bom.aKz != 1);
            }
            bf KH = g.KF().KH();
            if (KH == null || KH.aOV <= 0) {
                i5 = 1000;
            } else {
                i5 = KH.aOV;
            }
            kVar.dG(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aJr != null) {
                String str4 = wVar.aJr.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.be(z6);
            boolean z7 = true;
            bn bnVar = com.baidu.live.aa.a.PQ().btT;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bnVar != null && bnVar.aPA != null && (!bnVar.aPA.aRW || !bnVar.aPA.aRX)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.bf(z7);
            if (wVar != null && wVar.aJv != null) {
                kVar.gb(wVar.aJv.toJsonString());
            }
            if (bYK() != null && bYK().hgD != null) {
                kVar.gd(bYK().hgD.cgB());
            }
            if (!this.gXG) {
                this.gXH = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYi() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        eP(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bx bxVar) {
        if (bxVar != null && JM()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(bYK().pageContext.getPageActivity(), bxVar.aQw, bxVar.liveId, bxVar.aQx)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.aa.a.PQ().bod != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bYK().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.aa.a.PQ().bod.aNj, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (JM() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aIV != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aIV.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.Hr());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put("day", Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bYK().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYj() {
        if (this.gWT != null) {
            this.gWT.d(this.gWx.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYk() {
        w Hi = bYK().hgD.Hi();
        LogManager.getCommonLogger().doClickQuickImHiLog((Hi == null || Hi.mLiveInfo == null) ? "" : Hi.mLiveInfo.feed_id, MD());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HR(String str) {
        if (this.gWT != null) {
            this.gWT.hn(str);
        }
    }

    private void bYl() {
        if ("home_rec_play".equals(bYK().fromType) || "frs_play".equals(bYK().fromType) || "frs_live_play".equals(bYK().fromType) || "person_play".equals(bYK().fromType) || "search".equals(bYK().fromType) || "person_attention".equals(bYK().fromType)) {
            com.baidu.live.c.AY().aX(true);
        } else {
            com.baidu.live.c.AY().aX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mO(boolean z) {
        View GG;
        if (this.gWP == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aUa = false;
            fVar.context = bYK().pageContext.getPageActivity();
            fVar.aUj = z;
            fVar.fromType = bYK().fromType;
            fVar.aUk = bXc() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ab.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWP = (ab) runTask.getData();
            }
        }
        if (this.gWP != null && (GG = this.gWP.GG()) != null && this.gWx.hgE.indexOfChild(GG) < 0) {
            this.gWx.hgE.addView(GG, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYm() {
        View Hu;
        if (this.gXa == null) {
            ai aiVar = new ai();
            aiVar.aUa = false;
            aiVar.pageContext = bYK().pageContext;
            aiVar.fromType = bYK().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ae.class, aiVar);
            if (runTask != null && runTask.getData() != null) {
                this.gXa = (ae) runTask.getData();
            }
        }
        if (this.gXa != null && (Hu = this.gXa.Hu()) != null && bYK().hgE.indexOfChild(Hu) < 0) {
            if (Hu.getParent() instanceof ViewGroup) {
                ((ViewGroup) Hu.getParent()).removeView(Hu);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            bYK().hgE.addView(Hu, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYn() {
        View Hh;
        if (this.gWQ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aUa = false;
            aVar.context = bYK().pageContext.getPageActivity();
            aVar.fromType = bYK().fromType;
            aVar.aUb = bYK().hgJ;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, z.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWQ = (z) runTask.getData();
            }
        }
        if (this.gWQ != null && (Hh = this.gWQ.Hh()) != null && this.gXu != null && this.gXu.indexOfChild(Hh) < 0) {
            if (Hh.getParent() instanceof ViewGroup) {
                ((ViewGroup) Hh.getParent()).removeView(Hh);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.gXu.addView(Hh, this.gXu.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYo() {
        CustomResponsedMessage runTask;
        if (this.gWO == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bYK().pageContext)) != null) {
            this.gWO = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gWO != null) {
            this.gWO.setOtherParams(this.otherParams);
            this.gWO.a(new a.InterfaceC0188a() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.im.b.a.InterfaceC0188a
                public void Mf() {
                    b.this.bYv();
                }
            });
            this.gWO.a(bYK().hgD.Hi(), false);
            View CK = this.gWO.CK();
            if (CK != null && this.gXv.indexOfChild(CK) < 0) {
                Resources resources = bYK().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bYK().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.gXv.addView(CK, layoutParams);
            }
        }
    }

    private void bYp() {
        if (this.gWL == null) {
            this.gWL = new com.baidu.tieba.ala.liveroom.h.a(bYK().pageContext);
        }
        if (this.gXA != null) {
            this.gWL.HV(this.gXA.user_id);
        }
        this.gWL.ax(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mP(boolean z) {
        if (bYK() != null && !z) {
            if (this.gXh == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.j.a.class, bYK().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gXh = (com.baidu.live.j.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gXh.b(this.gXu, bYD());
            if (bYK().hgD != null) {
                this.gXh.a(bYK().hgD.Hi());
            }
            this.gXh.setCanVisible(true);
            this.gXh.bS(true);
            this.gXh.a(bYK().hgD.bRq());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bXj() {
        if (bYK() != null) {
            if (this.gVV == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.z.a.class, bYK().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gVV = (com.baidu.live.z.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gVV.setIsHost(false);
            this.gVV.a(bXK(), bYK().hgD.Hi().aJT);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYq() {
        if (bYK() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.gXi == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.r.a.class, bYK().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gXi = (com.baidu.live.r.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gXi.setIsHost(false);
            this.gXi.b(bXK(), bYK().hgD.Hi());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYr() {
        if (this.gWE != null && bYK() != null && bYK().hgD != null) {
            this.gWE.c(this.gXu, bYK().hgD.Hi());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYs() {
        if (bYK() != null) {
            if (this.gXj == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.i.a.class, bYK().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.gXj = (com.baidu.live.i.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.gWx.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.gXj.a(this.gXu, bYK().hgD.Hi(), layoutParams, this.otherParams);
        }
    }

    protected void bYt() {
        if (this.gXk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.r.b.class, bYK().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gXk = (com.baidu.live.r.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aIV != null && bYK().hgD.Hi().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(bYK().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(bYK().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.gXk.b(this.gXu, layoutParams, bYK().hgD.Hi());
        }
    }

    private void bYu() {
        if (this.gWY == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bYK().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWY = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aIV != null && bYK().hgD.Hi().mLiveInfo != null) {
            this.gWY.setHost(false);
            this.gWY.setOtherParams(MD());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.gWY.a(this.gXu, layoutParams, bYK().hgD.Hi());
            this.gWY.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.guardclub.l
                public void KL() {
                    b.this.bYL();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:217:0x0716, code lost:
        HN(r36);
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
        if (this.gVV != null) {
            this.gVV.R(jSONObject2);
        }
        if (aVar.getMsgType() == 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 != null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.bnG != null) {
                        this.bnG.cg(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vx(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bYK().hgD.Hi().aJr.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bYK().hgD.Hi().aJr.isAdmin = 0;
                            bYK().hgD.cgl();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bYK().hgD.Hi().aJr.isAdmin = 0;
                        bYK().hgD.cgl();
                    }
                } else if ("task".equals(optString2)) {
                    dO(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gWR != null && !bYK().hgI) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bYK().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bYK().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bYK().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bTg()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gWR.a(bYK().hgC.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bnG != null) {
                                b.this.bnG.cf(optInt4 == 2);
                            }
                        }
                    });
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.u.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aJr != null && bYK().hgD.Hi().aJr.userId == optLong2) {
                        bYK().hgD.Hi().aJr.isBlock = 1;
                        bXy();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aJr != null && bYK().hgD.Hi().aJr.userId == optLong3) {
                        bYK().hgD.Hi().aJr.isBlock = 0;
                        bXy();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aJr != null && bYK().hgD.Hi().aJr.userId == optLong4) {
                        bYK().hgD.Hi().aJr.isUegBlock = 1;
                        bXy();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bYK().hgD.Hi() != null && bYK().hgD.Hi().aJr != null && bYK().hgD.Hi().aJr.userId == optLong5) {
                        bYK().hgD.Hi().aJr.isUegBlock = 0;
                        bXy();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bYK() != null && bYK().hgD != null && bYK().hgD.Hi() != null && bYK().hgD.Hi().aJr != null) {
                        if (bYK().hgD.Hi().aJr.userId == jSONObject2.optLong("user_id")) {
                            bYK().hgD.cgl();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bYK().hgD.Hi().aJr));
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
                    com.baidu.live.data.a Mo = aVar.Mo();
                    if (Mo != null && aa.hg(str3)) {
                        aa.d(str3, 1L, "", "", Mo.userId, Mo.portrait, Mo.userName, "", "", false, "", "", "", false, false, true, -1L);
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
                } else if (TextUtils.equals(optString2, "mix_room_close") && this.gXq != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("source", "im_mix_room_close");
                        jSONObject3.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                        this.gXq.A("mix_room_close", jSONObject3);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.gWI != null) {
                this.gWI.J(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            String optString3 = jSONObject2.optString("content_type");
            com.baidu.live.data.a Mo2 = aVar.Mo();
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
            if (bYK().hgD == null || bYK().hgD.Hi() == null || bYK().hgD.Hi().mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                long j4 = bYK().hgD.Hi().mLiveInfo.live_id;
                j3 = bYK().hgD.Hi().mLiveInfo.group_id;
                long j5 = bYK().hgD.Hi().aIV.userId;
                str4 = bYK().hgD.Hi().mLiveInfo.appId;
                z5 = bYK().hgD.Hi().mLiveInfo.isPubShow;
                j = j5;
                j2 = j4;
            }
            if (!z4 || z2) {
                if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                    if (jSONObject2.optInt("flag_show") == 1) {
                        aa.b(optString11, Mo2.userId, Mo2.portrait, Mo2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString10, "", "", aVar.getMsgId());
                        try {
                            JSONArray jSONArray = new JSONArray(optString11);
                            if (jSONArray != null && jSONArray.length() > 0) {
                                int i = 0;
                                while (true) {
                                    if (i >= jSONArray.length()) {
                                        break;
                                    }
                                    if (com.baidu.live.aa.f.Qg().hZ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                    aa.a(optString4, JavaTypesHelper.toInt(optString5, 1), optString6, optString7, Mo2.userId, Mo2.portrait, Mo2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", (z3 || z4) ? false : true, aVar.getMsgId(), z2, jSONObject2, optString9);
                    HN(optString4);
                }
                if (!optString3.equals("tying_gift")) {
                    com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                    cVar.hgk = optLong7;
                    cVar.liveId = j2;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                }
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gXq = dVar;
    }

    protected void HN(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bYv() {
        if (bYw()) {
            BdUtilHelper.hideSoftKeyPad(bYK().pageContext.getPageActivity(), bYK().hgC.getLiveContainerView());
            bXI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYw() {
        if (bXH() == null || bXH().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        bYK().hgE.setOnTouchListener(this.gYj);
        bYE();
        bYF();
        bYG();
        bYp();
        bYu();
        bYt();
        bXY();
        if (this.gWG != null && bYK().hgD.Hi() != null && bYK().hgD.Hi().mLiveInfo != null) {
            this.gWG.cC(bYK().hgD.Hi().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gWM != null) {
            this.gWM.g(bYK().hgD.Hi());
        }
        if (this.gWK != null) {
            this.gWK.e(bYK().hgD.Hi());
        }
        if (this.gWS != null) {
            this.gWS.c(bYK().hgD.Hi(), MD());
        }
        if (this.gWT != null) {
            this.gWT.b(bYK().hgD.Hi(), MD());
        }
        if (this.gWU != null) {
            this.gWU.c(bYK().hgD.Hi(), MD());
        }
        if (this.gXr != null) {
            this.gXr.e(bYK().hgD.Hi());
        }
        if (this.gXs != null) {
            this.gXs.e(bYK().hgD.Hi());
        }
        if (bYK().hgE != null) {
            bYK().hgE.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bYw() && b.this.gWF != null) {
                        b.this.gWF.nI(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gWF != null) {
                        b.this.gWF.nI(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Oa() {
                    if (b.this.gXM == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.gXM) {
                        if (bVar.Oa()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bYK().hgE.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.gXf == null && (runTask = MessageManager.getInstance().runTask(2913165, ad.class, bYK().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gXf = (ad) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYx() {
        if (this.gXs == null && bYK() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.q.a.class, bYK().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.gXs = (com.baidu.live.q.a) runTask.getData();
                this.gXs.q(bYK().hgE);
                this.gXs.b(bYK().hgD.Hi());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYy() {
        w Hi;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (bYK() != null && bYK().hgD != null && (Hi = bYK().hgD.Hi()) != null && Hi.mLiveInfo != null && !Hi.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bYK().hgC) != null) {
            if (this.gXl == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.v.a.class, bYK().pageContext)) != null && runTask.getData() != null) {
                this.gXl = (com.baidu.live.v.a) runTask.getData();
            }
            if (this.gXl != null) {
                this.gXl.n(Hi);
                this.gXl.a(this.gYk);
                this.gXl.a(viewGroup, this.gXu);
                a(this.gXl.Pk());
                a(this.gXl.Pl());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXL == null) {
            this.gXL = new ArrayList();
        }
        if (!this.gXL.contains(dVar)) {
            this.gXL.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gXL != null && this.gXL.contains(dVar)) {
            this.gXL.remove(dVar);
        }
    }

    protected void bYz() {
        if (this.gXL != null) {
            this.gXL.clear();
            this.gXL = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXL == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gXL.iterator();
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
        if (this.gXM == null) {
            this.gXM = new ArrayList();
        }
        if (!this.gXM.contains(bVar)) {
            this.gXM.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gXM != null && this.gXM.contains(bVar)) {
            this.gXM.remove(bVar);
        }
    }

    protected void bYA() {
        if (this.gXM != null) {
            this.gXM.clear();
            this.gXM = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gXM == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gXM.iterator();
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
    public void bYB() {
        if (this.gXg == null && this.gXn != null && this.gXn.aPK && bYK() != null && bYK().hgD != null && bYK().hgD.Hi() != null) {
            this.gXg = new com.baidu.tieba.ala.liveroom.h.e(bYK().pageContext, this.gXn);
            this.gXg.E(bYK().hgD.Hi());
            if (this.gXn.aPN == 1) {
                if (this.gWN != null) {
                    this.gXD = true;
                }
            } else if (this.gXn.aPN == 2) {
                a(bYK().hgD.Hi(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bYC() {
        CustomResponsedMessage runTask;
        if (bYK() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bYK().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.w.a)) {
            this.gXo = (com.baidu.live.w.a) runTask.getData();
            this.gXo.t(bXK());
            if (bYK().hgD != null) {
                this.gXE = this.gXo.o(bYK().hgD.Hi());
            }
            this.gXo.setCanVisible(!this.gXy);
        }
    }

    private ViewGroup.LayoutParams bYD() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = bYK().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        bYK().hgC.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bYK().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bYK().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bYK().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + bYK().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void bYE() {
        if (this.gWF != null) {
            this.gWF.aE(bYK().hgE);
        }
    }

    private void bYF() {
        if (this.gWG != null) {
            this.gWG.aH(bYK().hgE);
        }
    }

    private void bYG() {
        if (this.gWJ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ad.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gWJ = (com.baidu.live.ad.a) runTask.getData();
            }
            bYH();
        }
    }

    private void dO(JSONObject jSONObject) {
        if (this.gWJ != null) {
            if (this.gWC != null) {
                this.gWJ.cF(this.gWC.ccy() ? false : true);
            } else {
                this.gWJ.cF(true);
            }
            this.gWJ.V(jSONObject);
        }
    }

    private void bYH() {
        if (this.gWJ != null && bYK().hgD.Hi() != null && bYK().hgD.Hi().aJE != null) {
            if (this.gWC != null) {
                this.gWJ.cF(this.gWC.ccy() ? false : true);
            } else {
                this.gWJ.cF(true);
            }
            this.gWJ.i(bYK().hgD.Hi());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            if (this.gWG != null && wVar.mLiveInfo != null) {
                this.gWG.cC(wVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gWX != null) {
                this.gWX.h(wVar);
            }
            bYH();
            if (this.gWL != null && wVar.aIV != null) {
                this.gWL.HV(String.valueOf(wVar.aIV.userId));
            }
            if (this.gWz != null) {
                this.gWz.a(wVar);
            }
            if (this.gWQ != null && wVar.mLiveInfo != null) {
                this.gWQ.a(wVar.mLiveInfo, wVar.aIV);
            }
            if (this.gWO != null) {
                this.gWO.a(wVar);
            }
            if (this.gXo != null) {
                this.gXE = this.gXo.o(wVar);
            }
            if (this.gXh != null) {
                this.gXh.a(wVar);
            }
            if (this.gXi != null) {
                this.gXi.a(wVar);
            }
            if (this.gVV != null) {
                this.gVV.a(wVar);
            }
            if (this.gXj != null) {
                this.gXj.a(wVar);
            }
            if (this.gXk != null) {
                this.gXk.a(wVar);
            }
            if (this.gXr != null) {
                this.gXr.b(wVar);
            }
            vx(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vx(int i) {
        if (!bYK().hgI) {
            if (this.gXw < 0 && i == 0) {
                this.gXw = i;
            } else if (this.gXw != i) {
                if (i == 1) {
                    if (!this.gWR.wl(2)) {
                        String string = bYK().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bYK().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gWR.a(bYK().hgC.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bYK().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.gWR.wm(2);
                    this.gWR.wm(3);
                    if (bTg()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gWR.a(bYK().hgC.getLiveContainerView(), string2, 3);
                    }
                }
                this.gXw = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cj(boolean z) {
        super.cj(z);
        if (z) {
            bYI();
        }
        if (this.gWX != null) {
            this.gWX.KN();
        }
        if (this.gWK != null) {
            this.gWK.KN();
        }
        if (this.gWI != null) {
            this.gWI.cix();
        }
        if (this.gWA != null) {
            this.gWA.Dm();
        }
        if (this.gWC != null) {
            this.gWC.onDestroy();
        }
        if (this.gWJ != null) {
            this.gWJ.onDestroy();
            this.gWJ = null;
        }
        if (this.gWP != null) {
            View GG = this.gWP.GG();
            if (GG != null && GG.getParent() != null) {
                ((ViewGroup) GG.getParent()).removeView(GG);
            }
            this.gWP.onDestroy();
            this.gWP = null;
        }
        if (this.gWO != null) {
            this.gWO.a((a.InterfaceC0188a) null);
            this.gWO.CM();
        }
        if (this.gWR != null) {
            this.gWR.Dm();
        }
        this.gXw = -1;
        if (this.gWL != null) {
            this.gWL.Dm();
            this.gWL.onDestroy();
        }
        if (this.gWD != null) {
            this.gWD.civ();
        }
        if (this.gWE != null) {
            this.gWE.bWZ();
            this.gWE.Ht();
        }
        if (this.gWF != null) {
            this.gWF.Ht();
        }
        if (this.gWM != null) {
            this.gWM.Ht();
        }
        if (this.gWS != null) {
            this.gWS.KN();
        }
        if (this.gWT != null) {
            this.gWT.Ht();
        }
        if (this.gWU != null) {
            this.gWU.onDestroy();
        }
        if (this.gWW != null) {
            this.gWW.onDestory();
        }
        if (this.gWZ != null) {
            this.gWZ.KJ();
        }
        if (this.gWY != null) {
            this.gWY.KJ();
        }
        if (this.gXk != null) {
            this.gXk.KJ();
        }
        if (this.gXg != null) {
            this.gXg.onDestroy();
        }
        if (this.gXb != null) {
            this.gXb.Ht();
        }
        if (this.gKY != null) {
            this.gKY.Ht();
        }
        if (this.gXc != null) {
            this.gXc.Ht();
        }
        if (this.gXd != null) {
            this.gXd.Ht();
        }
        if (this.gXf != null) {
            this.gXf.Ht();
        }
        if (this.gWB != null) {
            this.gWB.onDestory();
        }
        if (this.gXo != null) {
            this.gXo.Ht();
        }
        if (this.gXh != null) {
            this.gXh.KJ();
        }
        if (this.gXi != null) {
            this.gXi.KJ();
        }
        if (this.gVV != null) {
            this.gVV.KJ();
        }
        if (this.gXe != null) {
            this.gXe.Ht();
        }
        if (this.gXa != null) {
            this.gXa.onDestroy();
        }
        if (this.gXl != null) {
            this.gXl.Dm();
            b(this.gXl.Pk());
            b(this.gXl.Pl());
        }
        if (this.gXm != null) {
            this.gXm.KJ();
        }
        if (this.gXj != null) {
            this.gXj.KJ();
        }
        if (this.gXr != null) {
            this.gXr.KN();
        }
        if (this.gXs != null) {
            this.gXs.KN();
            this.gXs = null;
        }
        ShowUtil.windowCount = 0;
        bYz();
        bYA();
    }

    private void bYI() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bYK().hgE.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bYK().hgE.getChildAt(i);
            if (childAt != this.gXu && childAt != this.gXv) {
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
        if (this.gXu != null) {
            this.gXu.removeAllViews();
        }
        if (this.gXv != null) {
            this.gXv.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View CK;
        View GG;
        if (this.gWP != null && (GG = this.gWP.GG()) != null && GG.getParent() != null) {
            ((ViewGroup) GG.getParent()).removeView(GG);
        }
        if (this.gWO != null && (CK = this.gWO.CK()) != null && CK.getParent() != null) {
            ((ViewGroup) CK.getParent()).removeView(CK);
        }
        if (this.gWC != null) {
            this.gWC.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean NW() {
        if (this.gWH == null || !this.gWH.ccD()) {
            if (this.gWC == null || !this.gWC.aA(bYK().hgC.getLiveContainerView())) {
                if (this.gWF != null) {
                    this.gWF.bTM();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gWV != null && this.gWV.ccm()) {
                    this.gWV.ccv();
                    return false;
                } else if (this.gWU == null || !this.gWU.QW()) {
                    if (this.gXt == null || !this.gXt.QW()) {
                        bYl();
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
    public void ch(boolean z) {
        super.ch(z);
        if (this.gWX != null) {
            this.gWX.release();
        }
        if (this.gWK != null) {
            this.gWK.onDestroy();
        }
        if (this.gWJ != null) {
            this.gWJ.onDestroy();
            this.gWJ = null;
        }
        if (this.gWI != null) {
            this.gWI.cix();
        }
        if (this.gWP != null) {
            this.gWP.onDestroy();
            this.gWP = null;
        }
        if (this.gWQ != null) {
            this.gWQ.onDestroy();
            this.gWQ = null;
        }
        if (this.gWR != null) {
            this.gWR.onDestroy();
        }
        if (this.gWA != null) {
            this.gWA.onDestroy();
        }
        if (this.gXa != null) {
            this.gXa.onDestroy();
            this.gXa = null;
        }
        if (this.gWO != null) {
            this.gWO.a((a.InterfaceC0188a) null);
            this.gWO.release();
            this.gWO = null;
        }
        if (this.gWS != null) {
            this.gWS.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gWS.release();
        }
        if (this.gWT != null) {
            this.gWT.a(null);
            this.gWT.release();
        }
        if (this.gWU != null) {
            this.gWU.a((b.a) null);
            this.gWU.onDestroy();
        }
        if (this.gWY != null) {
            this.gWY.onDestroy();
        }
        if (this.gWZ != null) {
            this.gWZ.onDestroy();
        }
        if (this.gWW != null) {
            this.gWW.onDestory();
        }
        if (this.gXk != null) {
            this.gXk.onDestroy();
        }
        if (this.gXg != null) {
            this.gXg.onDestroy();
        }
        if (this.gXb != null) {
            this.gXb.release();
        }
        if (this.gKY != null) {
            this.gKY.release();
        }
        if (this.gXe != null) {
            this.gXe.release();
        }
        if (this.gXc != null) {
            this.gXc.release();
        }
        if (this.gXd != null) {
            this.gXd.release();
        }
        if (this.gXf != null) {
            this.gXf.release();
        }
        if (this.gWB != null) {
            this.gWB.onDestory();
        }
        if (this.gXo != null) {
            this.gXo.release();
        }
        if (this.gXh != null) {
            this.gXh.onDestroy();
        }
        if (this.gXi != null) {
            this.gXi.onDestroy();
        }
        if (this.gVV != null) {
            this.gVV.onDestroy();
        }
        if (this.gWF != null) {
            this.gWF.Ht();
        }
        if (this.gXj != null) {
            this.gXj.onDestroy();
        }
        if (this.gXr != null) {
            this.gXr.onDestroy();
        }
        if (this.gXl != null) {
            this.gXl.onDestroy();
            b(this.gXl.Pk());
            b(this.gXl.Pl());
        }
        bYz();
        bYA();
        MessageManager.getInstance().unRegisterListener(this.gXR);
        MessageManager.getInstance().unRegisterListener(this.gXS);
        MessageManager.getInstance().unRegisterListener(this.gXT);
        MessageManager.getInstance().unRegisterListener(this.gXX);
        MessageManager.getInstance().unRegisterListener(this.gXY);
        MessageManager.getInstance().unRegisterListener(this.gYa);
        MessageManager.getInstance().unRegisterListener(this.gXU);
        MessageManager.getInstance().unRegisterListener(this.gXV);
        MessageManager.getInstance().unRegisterListener(this.gvb);
        MessageManager.getInstance().unRegisterListener(this.gXW);
        MessageManager.getInstance().unRegisterListener(this.gvo);
        MessageManager.getInstance().unRegisterListener(this.gYb);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gFb);
        MessageManager.getInstance().unRegisterListener(this.gEY);
        MessageManager.getInstance().unRegisterListener(this.bqR);
        MessageManager.getInstance().unRegisterListener(this.gYc);
        MessageManager.getInstance().unRegisterListener(this.gYe);
        MessageManager.getInstance().unRegisterListener(this.gYf);
        MessageManager.getInstance().unRegisterListener(this.gYg);
        MessageManager.getInstance().unRegisterListener(this.gYd);
        MessageManager.getInstance().unRegisterListener(this.gYh);
        MessageManager.getInstance().unRegisterListener(this.gKZ);
        MessageManager.getInstance().unRegisterListener(this.gYi);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gWS != null) {
            this.gWS.no(false);
        }
        if (this.gWU != null) {
            this.gWU.no(false);
        }
        bXI();
        if (this.gWX != null) {
            this.gWX.onPause();
        }
        if (this.gXb != null) {
            this.gXb.pause();
        }
        if (this.gKY != null) {
            this.gKY.pause();
        }
        if (this.gXe != null) {
            this.gXe.pause();
        }
        if (this.gXc != null) {
            this.gXc.pause();
        }
        if (this.gXa != null) {
            this.gXa.onPause();
        }
        if (this.gXj != null) {
            this.gXj.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gXH = false;
        if (this.gXz && this.gXA != null) {
            a(this.gXA);
            this.gXz = false;
        }
        if (this.gWS != null) {
            this.gWS.no(true);
        }
        if (this.gWU != null) {
            this.gWU.no(true);
        }
        if (this.gWX != null) {
            this.gWX.onResume();
        }
        if (this.gXb != null) {
            this.gXb.resume();
        }
        if (this.gKY != null) {
            this.gKY.resume();
        }
        if (this.gXe != null) {
            this.gXe.resume();
        }
        if (this.gXa != null) {
            this.gXa.onResume();
        }
        if (this.gXc != null) {
            this.gXc.resume();
        }
        if (this.gXj != null) {
            this.gXj.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avS() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gXl != null && this.gXl.isOpen()) {
            this.gXl.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            avS();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    M(-1, -1, -1);
                    return;
                }
                return;
            }
            avS();
        } else if (i == 25034) {
            bYi();
        } else if (i == 25043) {
            if (i2 == -1) {
                bYL();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.n.a.F(bYK().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.n.a.F(bYK().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gXy = z;
        if (this.gXs != null) {
            this.gXs.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bYJ() {
        return (bYK().hgD.Hi() == null || bYK().hgD.Hi().mLiveInfo == null || bYK().hgD.Hi().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gWC != null) {
                this.gWC.D(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gWU != null) {
            this.gWU.biM();
        }
        if (this.gWB != null) {
            this.gWB.biM();
        }
        if (this.gXl != null) {
            this.gXl.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gWx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bYK() {
        return this.gWx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYL() {
        String KG = g.KF().KG();
        if (!TextUtils.isEmpty(KG)) {
            try {
                M(-1, Integer.parseInt(KG), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                M(-1, -1, -1);
            }
        }
    }

    public boolean eO(int i) {
        if (1 == i) {
            if (bXH() != null) {
                bXH().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gXy) {
                return false;
            }
            return this.gWC == null || !this.gWC.ccy();
        } else if (3 == i) {
            if (bYK().hgE != null) {
                bYK().hgE.setEnabled(false);
                if (this.bnG != null) {
                    this.bnG.e(!bYK().hgG, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void vv(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void eP(int i) {
        if (3 == i) {
            bYK().hgE.setEnabled(true);
            if (this.bnG != null) {
                this.bnG.e(!bYK().hgG, true);
            }
            if (this.gWJ != null) {
                this.gWJ.cF(true);
            }
        } else if (2 == i && this.gWI != null) {
            this.gWI.nR(true);
        }
    }

    public String MD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gWO != null) {
            this.gWO.setOtherParams(str);
        }
        if (this.gWX != null) {
            this.gWX.hN(str);
        }
    }

    private boolean bTg() {
        return bYK().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gaY = alaLastLiveroomInfo;
    }

    public void ca(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(bYK().pageContext.getPageActivity(), this.gXF);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }
}
