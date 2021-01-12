package com.baidu.tieba.ala.liveroom.d;

import android.app.Activity;
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
import com.baidu.live.d.v;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ak;
import com.baidu.live.data.at;
import com.baidu.live.data.bd;
import com.baidu.live.data.bi;
import com.baidu.live.data.bq;
import com.baidu.live.data.br;
import com.baidu.live.data.cb;
import com.baidu.live.data.f;
import com.baidu.live.data.x;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.af;
import com.baidu.live.gift.ag;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.q;
import com.baidu.live.view.c;
import com.baidu.live.view.input.d;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tieba.ala.liveroom.n.b;
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
/* loaded from: classes10.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a, com.baidu.live.y.a {
    public static boolean hod;
    protected AlaLastLiveroomInfo goI;
    protected com.baidu.live.ap.a hba;
    private com.baidu.tieba.ala.liveroom.data.a hmN;
    protected com.baidu.tieba.ala.liveroom.operation.a hmO;
    protected com.baidu.live.k.b hmP;
    protected com.baidu.live.k.a hmQ;
    protected com.baidu.tieba.ala.liveroom.share.c hmR;
    protected com.baidu.tieba.ala.liveroom.r.b hmS;
    protected com.baidu.tieba.ala.liveroom.guide.c hmT;
    protected com.baidu.tieba.ala.liveroom.watermark.a hmU;
    protected com.baidu.tieba.ala.liveroom.b.b hmV;
    protected com.baidu.tieba.ala.liveroom.praise.a hmW;
    protected com.baidu.tieba.ala.liveroom.sticker.a hmX;
    protected com.baidu.tieba.ala.liveroom.guide.d hmY;
    protected com.baidu.tieba.ala.liveroom.w.a hmZ;
    protected com.baidu.live.ae.a hme;
    protected com.baidu.live.u.a hnA;
    protected com.baidu.live.a.a hnB;
    protected com.baidu.live.l.a hnC;
    protected com.baidu.live.u.b hnD;
    protected com.baidu.live.h.a hnE;
    protected com.baidu.live.aa.a hnF;
    protected com.baidu.tieba.ala.liveroom.exclusive.b hnG;
    protected br hnH;
    protected com.baidu.live.ab.a hnI;
    protected com.baidu.tieba.ala.liveroom.f.a hnJ;
    protected com.baidu.tieba.ala.player.d hnK;
    protected com.baidu.live.guess.a hnL;
    protected com.baidu.live.t.a hnM;
    protected com.baidu.live.ao.c hnN;
    protected com.baidu.live.c.a hnO;
    protected RelativeLayout hnP;
    protected RelativeLayout hnQ;
    protected boolean hnS;
    protected at hnV;
    protected GuardClubInfoHttpResponseMessage hnW;
    boolean hnX;
    boolean hnY;
    boolean hnZ;
    protected com.baidu.live.ai.a hna;
    protected com.baidu.live.ai.d hnb;
    private com.baidu.tieba.ala.liveroom.h.a hnc;
    private m hnd;
    k hne;
    com.baidu.live.im.b.a hnf;
    protected ad hng;
    protected ab hnh;
    protected com.baidu.tieba.ala.liveroom.tippop.a hni;
    private com.baidu.tieba.ala.liveroom.guideim.b hnj;
    protected com.baidu.live.view.input.d hnk;
    com.baidu.tieba.ala.liveroom.n.b hnl;
    protected com.baidu.tieba.ala.liveroom.guide.a hnm;
    protected com.baidu.live.y.b hnn;
    private com.baidu.live.guardclub.k hno;
    protected com.baidu.live.n.b hnp;
    protected h hnq;
    protected j hnr;
    protected ag hns;
    protected e hnt;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b hnu;
    protected com.baidu.tieba.ala.liveroom.q.c hnv;
    private af hnw;
    protected com.baidu.tieba.ala.liveroom.h.e hnx;
    protected com.baidu.live.m.a hny;
    protected com.baidu.live.w.a hnz;
    public boolean hob;
    public boolean hoc;
    protected com.baidu.tieba.ala.liveroom.t.b hoe;
    protected com.baidu.tieba.ala.liveroom.j.e hof;
    protected List<com.baidu.live.liveroom.g.d> hog;
    protected List<com.baidu.live.liveroom.g.b> hoh;
    CustomMessageTask hoi;
    CustomMessageTask hoj;
    protected String otherParams;
    private int hnR = -1;
    protected boolean aJV = true;
    protected int aJX = 0;
    protected int mOrientation = 0;
    protected boolean hnT = false;
    protected boolean hnU = false;
    private int hoa = a.C0194a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> hok = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: caR */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> hol = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener hom = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak akVar;
            if ((customResponsedMessage.getData() instanceof ak) && (akVar = (ak) customResponsedMessage.getData()) != null) {
                b.this.a(akVar.aHu, akVar.aHq, akVar.aHr, akVar.aHs, akVar.aHt);
            }
        }
    };
    private CustomMessageListener hon = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.vd(7);
        }
    };
    private CustomMessageListener hoo = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.caj();
        }
    };
    private CustomMessageListener hop = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.caO().hxj.DW().aFH.userId);
            com.baidu.live.view.a.VF().a(valueOf, new f(b.this.caO().hxj.DW().aFH.portrait, valueOf, true, b.this.caO().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hoq = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof x) && b.this.hmR != null) {
                b.this.hmR.d((x) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bup = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hne != null) {
                b.this.hne.g(z.DO().DQ());
            }
        }
    };
    private CustomMessageListener hor = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.hmN.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.GU(str);
            }
        }
    };
    private CustomMessageListener gKz = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.caO().pageContext.getPageActivity());
            } else if (b.this.hmR != null) {
                b.this.hmR.d(b.this.caO().hxj.DW(), false);
            }
        }
    };
    private CustomMessageListener hos = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof at) {
                    b.this.hnU = true;
                    b.this.hnV = (at) data;
                    b.this.b(b.this.hnV);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                } else if (data instanceof String) {
                    b.this.GT((String) data);
                }
            }
        }
    };
    private CustomMessageListener hou = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.caO().hxj.DW().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.caO().hxj.DW().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.caO().hxj.DW().aFH.userId);
                    if (b.this.hmS == null) {
                        b.this.hmS = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    b.this.hmS.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.hmS.a(b.this.hov);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b hov = new e.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void NF() {
            if (b.this.caO().hxj.DW() != null && b.this.caO().hxj.DW().aGd != null) {
                b.this.caO().hxj.DW().aGd.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener how = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (b.this.hnp != null) {
                    b.this.hnp.C(bVar);
                }
                if (b.this.hnG != null) {
                    b.this.hnG.I(bVar);
                }
                if (b.this.hmQ != null) {
                    b.this.hmQ.l(bVar);
                }
                if (b.this.hnC != null) {
                    b.this.hnC.l(bVar);
                }
                b.this.t(bVar);
            }
        }
    };
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener hox = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.hnX = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hnl != null) {
                b.this.hnl.Ek();
            }
        }
    };
    HttpMessageListener gUP = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bfP) != null && b.this.hno != null && b.this.caO() != null && b.this.caO().hxj != null) {
                int[] iArr = new int[2];
                b.this.hnP.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.hno.a(b.this.hnP, layoutParams, aVar, b.this.caO().hxj.DW());
                com.baidu.live.r.a.aD(aVar.liveId + "", "guard_club_join");
                com.baidu.live.q.a.c(b.this.caO().hxj.DW().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gUM = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.caO() != null && b.this.caO().hxj != null && b.this.caO().hxj.DW() != null && guardClubInfoHttpResponseMessage.bfP != null) {
                    if (guardClubInfoHttpResponseMessage.bfP.anchorId == b.this.caO().hxj.DW().aFH.userId) {
                        b.this.hnW = guardClubInfoHttpResponseMessage;
                        if (b.this.hnW.bfU && com.baidu.live.guardclub.e.HC() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.HC().aR(b.this.caO().hxj.DW().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hoy = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof cb) {
                b.this.a((cb) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hoz = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.H(b.this.caO().hxj.DW());
        }
    };
    private CustomMessageListener hoA = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hny != null) {
                b.this.hny.HS();
            }
        }
    };
    private CustomMessageListener hoB = new CustomMessageListener(2913261) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.hnz != null) {
                    b.this.hnz.gS(str);
                }
            }
        }
    };
    public CustomMessageListener bnx = new CustomMessageListener(2913272) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.nG(booleanValue);
                b.this.nA(booleanValue);
            }
        }
    };
    public CustomMessageListener hoC = new CustomMessageListener(2913281) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hne != null && b.this.hnk != null) {
                if (b.this.hne.getTextView() != null) {
                    BdUtilHelper.showSoftKeyPad(b.this.getActivity(), b.this.hne.getTextView());
                }
                b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hne.IG().setFromDailyTask(true, b.this.caO().hxj.DW().aGs.aKW);
                        b.this.hne.IG().a(null, z.DO().DQ(), b.this.caO().hxj.DW().mLiveInfo);
                    }
                }, 300L);
            }
        }
    };
    public CustomMessageListener hoD = new CustomMessageListener(2913289) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hmO != null) {
                b.this.hmO.ciL();
            }
        }
    };
    private CustomMessageListener hoE = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.hns != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) b.this.hns).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hoF = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.caO().hxj.DW(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hbb = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ap.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.hba == null) {
                b.this.hba = new com.baidu.live.ap.a(b.this.caO().pageContext.getPageActivity());
            }
            b.this.hba.a((com.baidu.live.ap.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener hoG = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.caO().pageContext.getPageActivity() != null) {
                com.baidu.live.q.a.r(b.this.caO().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener hoH = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.caz();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.aa.b hoI = new com.baidu.live.aa.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        @Override // com.baidu.live.aa.b
        public boolean Of() {
            if (b.this.caO().hxk != null) {
                if (!b.this.caO().hxk.cko()) {
                    b.this.hnF.close();
                    return false;
                } else if (b.this.caO().hxk.getScrollX() != 0) {
                    b.this.hnF.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void GT(String str);

    protected abstract void a(at atVar);

    protected abstract void b(at atVar);

    protected abstract View bZH();

    public abstract boolean bZI();

    protected abstract boolean bZJ();

    protected abstract ViewGroup bZK();

    protected abstract void bZx();

    protected abstract void g(com.baidu.live.data.a aVar);

    public abstract boolean isVertical();

    protected abstract void nA(boolean z);

    public void a(br brVar) {
        this.hnH = brVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hnP = (RelativeLayout) caO().hxk.findViewById(a.f.ala_live_header_view);
        this.hnQ = (RelativeLayout) caO().hxk.findViewById(a.f.ala_live_footer_view);
        EN();
        registerListener();
    }

    public void bZP() {
    }

    private void EN() {
        if (this.hmR == null) {
            this.hmR = new com.baidu.tieba.ala.liveroom.share.c(caO().pageContext);
        }
        this.hmZ = new com.baidu.tieba.ala.liveroom.w.a(caO().pageContext, this);
        this.hmV = new com.baidu.tieba.ala.liveroom.b.b(caO().pageContext, false);
        this.hmW = new com.baidu.tieba.ala.liveroom.praise.a(caO().pageContext);
        this.hmX = new com.baidu.tieba.ala.liveroom.sticker.a(caO().pageContext);
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
                this.hmY = new com.baidu.tieba.ala.liveroom.guide.d(caO().pageContext);
            }
        }
        this.hni = new com.baidu.tieba.ala.liveroom.tippop.a(caO().pageContext, this);
        bZS();
        bZV();
        bZW();
        cab();
        cac();
        cad();
        bZR();
        bZQ();
        cae();
    }

    private void bZQ() {
        CustomResponsedMessage runTask;
        if (this.hnb == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ai.d.class, caO().pageContext)) != null && runTask.getData() != null) {
            this.hnb = (com.baidu.live.ai.d) runTask.getData();
        }
    }

    private void bZR() {
        CustomResponsedMessage runTask;
        if (this.hnp == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.n.b.class, caO().pageContext)) != null && runTask.getData() != null) {
            this.hnp = (com.baidu.live.n.b) runTask.getData();
            this.hnp.c(caO().pageContext);
            this.hnp.KS().setTargetView(this.hnQ);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.hnJ == null) {
            this.hnJ = new com.baidu.tieba.ala.liveroom.f.a(caO().pageContext);
            this.hnJ.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.hnJ.a(caO().hxj.DW(), alaLastLiveroomInfo);
        this.hnJ.aF(this.hnQ);
    }

    private void bZS() {
        this.hnd = new m();
    }

    public void nD(boolean z) {
        this.hnS = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bZT() {
        CustomResponsedMessage runTask;
        if (this.hmQ == null && (runTask = MessageManager.getInstance().runTask(2913273, com.baidu.live.k.a.class, caO().pageContext)) != null) {
            this.hmQ = (com.baidu.live.k.a) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bZU() {
        x DW = caO().hxj.DW();
        boolean z = com.baidu.live.af.a.OJ().bru.aKm;
        if (DW.mLiveInfo != null && DW.mLiveInfo.mAlaLiveSwitchData != null && DW.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = DW.aGt ? z : false;
        if (z2) {
            if (this.hmP == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.k.b.class, caO().pageContext);
                if (runTask != null) {
                    this.hmP = (com.baidu.live.k.b) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.hmP != null) {
                this.hmP.dp(1);
                View view = this.hmP.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(caO().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(caO().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    ct(view);
                    this.hnP.addView(view, layoutParams);
                    if (z2) {
                        this.hmP.a(DW);
                    }
                }
            }
        }
    }

    private void bZV() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.d.class, caO().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hnk = (com.baidu.live.view.input.d) runTask.getData();
            this.hnk.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
                @Override // com.baidu.live.view.input.d.a
                public void Wh() {
                    b.this.vd(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public void Wi() {
                    b.this.dA(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean IJ() {
                    return b.this.GJ();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Jy() {
                    return b.this.bZZ();
                }

                @Override // com.baidu.live.view.input.d.a
                public int IP() {
                    return b.this.caa();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean IQ() {
                    x DW = b.this.caO().hxj.DW();
                    if (DW == null || DW.aGd == null) {
                        return false;
                    }
                    return DW.aGd.isMysteriousMan;
                }
            });
        }
    }

    private void bZW() {
        this.hnl = new com.baidu.tieba.ala.liveroom.n.b(this.hmN.pageContext);
        this.hnl.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.tieba.ala.liveroom.n.b.a
            public boolean caS() {
                return b.this.bZJ();
            }

            @Override // com.baidu.tieba.ala.liveroom.n.b.a
            public void onClose() {
                if (b.this.bok != null) {
                    b.this.bok.ct(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bZX() {
        if (this.hnL == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.hnL = (com.baidu.live.guess.a) runTask.getData();
                this.hnL.p(getActivity());
            } else {
                return;
            }
        }
        if (this.hnL != null) {
            this.hnL.dq(0);
            this.hnL.f(caO().hxj.DW());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nE(boolean z) {
        if (this.hnj != null) {
            this.hnj.oh(z);
        }
        if (this.hnl != null) {
            this.hnl.oh(z);
        }
        hod = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bZY() {
        return hod;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bZZ() {
        x DW;
        if (caO() == null || caO().hxj == null || (DW = caO().hxj.DW()) == null || DW.aGd == null) {
            return false;
        }
        String str = DW.aGd.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int caa() {
        x DW;
        if (caO() != null && caO().hxj != null && (DW = caO().hxj.DW()) != null && !ListUtils.isEmpty(DW.aGo)) {
            for (AlaLiveMarkData alaLiveMarkData : DW.aGo) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cab() {
        if (this.hno == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, caO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hno = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.hno.setOtherParams(JQ());
    }

    private void cac() {
        if (this.hnt == null) {
            this.hnt = new com.baidu.tieba.ala.liveroom.turntable.e(caO().pageContext.getPageActivity());
        }
    }

    private void cad() {
        if (this.hnv == null) {
            this.hnv = new com.baidu.tieba.ala.liveroom.q.c(caO().pageContext.getPageActivity());
        }
    }

    private void cae() {
        if (this.hba == null) {
            this.hba = new com.baidu.live.ap.a(caO().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.hoi == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.hoi = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.hok);
            this.hoi.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hoi);
        }
        if (this.hoj == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.hoj = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.hol);
            this.hoj.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hoj);
        }
        MessageManager.getInstance().registerListener(this.hos);
        MessageManager.getInstance().registerListener(this.hou);
        MessageManager.getInstance().registerListener(this.how);
        MessageManager.getInstance().registerListener(this.hop);
        MessageManager.getInstance().registerListener(this.hoq);
        MessageManager.getInstance().registerListener(this.gKz);
        MessageManager.getInstance().registerListener(this.hor);
        MessageManager.getInstance().registerListener(this.gKM);
        MessageManager.getInstance().registerListener(this.hox);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gUP);
        MessageManager.getInstance().registerListener(this.gUM);
        MessageManager.getInstance().registerListener(this.bup);
        MessageManager.getInstance().registerListener(this.hoy);
        MessageManager.getInstance().registerListener(this.hoz);
        MessageManager.getInstance().registerListener(this.hoA);
        MessageManager.getInstance().registerListener(this.hoE);
        MessageManager.getInstance().registerListener(this.hoF);
        MessageManager.getInstance().registerListener(this.hom);
        MessageManager.getInstance().registerListener(this.hon);
        MessageManager.getInstance().registerListener(this.hoo);
        MessageManager.getInstance().registerListener(this.hbb);
        MessageManager.getInstance().registerListener(this.hoG);
        MessageManager.getInstance().registerListener(this.hoB);
        MessageManager.getInstance().registerListener(this.bnx);
        MessageManager.getInstance().registerListener(this.hoC);
        MessageManager.getInstance().registerListener(this.hoD);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean GJ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(caO().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GU(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(caO().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(caO().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.af.a.OJ().bru.aJI;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = caO().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = caO().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.caO().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(caO().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caf() {
        if (this.hne != null && this.hnk != null) {
            this.hne.IG().a(this.hnk.NM(), z.DO().DQ(), caO().hxj.DW().mLiveInfo);
            nE(true);
            if (this.hnw == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, af.class, caO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hnw = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hnw.fY("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cag() {
        if (this.hne != null && this.hnk != null) {
            this.hne.IH().cn(false);
            if (com.baidu.live.af.a.OJ().bru != null) {
                this.aJX = com.baidu.live.af.a.OJ().bru.aJX;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cah();
                }
            }, this.aJX * 1000);
        }
    }

    protected void cah() {
        this.hne.IH().h(caO().hxj.DW());
        if (com.baidu.live.af.a.OJ().bru != null) {
            this.aJV = com.baidu.live.af.a.OJ().bru.aJV && !this.hne.IH().KO();
        }
        if (this.aJV) {
            if (this.mOrientation != 2) {
                this.hne.IH().cn(true);
            } else {
                this.hne.IH().cn(false);
            }
            this.hne.IH().setClicked(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.leftMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.rightMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            if (this.hns != null) {
                layoutParams.addRule(3, this.hns.Ej().getId());
            }
            this.hne.a(this.hnQ, caO().hxj.DW(), this.hnk.NM(), layoutParams);
            return;
        }
        this.hne.IH().co(false);
        this.hne.IH().cn(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cai() {
        if (this.hne != null) {
            this.hne.IG().hide();
            nE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(int i, int i2, int i3) {
        if (caO().hxj.DW() != null && caO().hxj.DW().aFH != null && caO().hxj.DW().mLiveInfo != null) {
            a(caO().hxj.DW(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.d.k.class) != null && GJ()) {
            if (xVar == null) {
                xVar = caO().hxj.DW();
            }
            String valueOf = String.valueOf(xVar.aFH.userId);
            String str2 = xVar.aFH.userName;
            String valueOf2 = String.valueOf(xVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(xVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(xVar.mLiveInfo.feed_id);
            int i6 = xVar.aGd.isBlock;
            String Ef = ac.Ef();
            String str3 = xVar.mLiveInfo.appId;
            boolean z2 = xVar.aGd.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (xVar.mLiveInfo.live_type == 1 && xVar.mLiveInfo.screen_direction == 1 && com.baidu.live.af.a.OJ().bru.aIJ) {
                z3 = true;
            }
            int i7 = -1;
            if (xVar.aGd == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(xVar.aGd.userId);
                boolean z4 = xVar.aGd.isNewUser;
                i7 = xVar.aGd.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.hnW != null && this.hnW.bfP != null && this.hnW.bfP.anchorId == xVar.aFH.userId) {
                z5 = this.hnW.bfU;
            }
            com.baidu.live.d.k kVar = new com.baidu.live.d.k(caO().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Ef, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bg(xVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.eQ(str);
            kVar.be(z);
            if (com.baidu.tieba.ala.liveroom.v.b.cjy().brD != null) {
                kVar.bf(com.baidu.tieba.ala.liveroom.v.b.cjy().brD.aHy != 1);
            }
            bi HF = g.HD().HF();
            if (HF == null || HF.aMl <= 0) {
                i5 = 1000;
            } else {
                i5 = HF.aMl;
            }
            kVar.cm(i5);
            boolean z6 = false;
            if (xVar != null && xVar.aGd != null) {
                String str4 = xVar.aGd.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.bh(z6);
            boolean z7 = true;
            bq bqVar = com.baidu.live.af.a.OJ().bxp;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bqVar != null && bqVar.aMR != null && (!bqVar.aMR.aPy || !bqVar.aMR.aPz)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.bi(z7);
            if (xVar != null && xVar.aGg != null) {
                kVar.eP(xVar.aGg.toJsonString());
            }
            if (caO() != null && caO().hxj != null) {
                kVar.eR(caO().hxj.ciK());
            }
            if (!this.hob) {
                this.hoc = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caj() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        dA(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cb cbVar) {
        if (cbVar != null && GJ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(caO().pageContext.getPageActivity(), cbVar.aNP, cbVar.liveId, cbVar.aHi)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && com.baidu.live.af.a.OJ().bru != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(caO().pageContext.getPageActivity(), String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.mLiveInfo.user_id), com.baidu.live.af.a.OJ().bru.aKn, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, NobleDetailInfo nobleDetailInfo) {
        if (GJ() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (xVar != null) {
                if (xVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
                if (xVar.aFH != null) {
                    hashMap.put("anchor_id", Long.valueOf(xVar.aFH.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", q.Ef());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(caO().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cak() {
        if (this.hnk != null) {
            this.hnk.d(this.hmN.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cal() {
        x DW = caO().hxj.DW();
        LogManager.getCommonLogger().doClickQuickImHiLog((DW == null || DW.mLiveInfo == null) ? "" : DW.mLiveInfo.feed_id, JQ());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void GV(String str) {
        if (this.hnk != null) {
            this.hnk.gb(str);
        }
    }

    private void cam() {
        if ("home_rec_play".equals(caO().fromType) || "frs_play".equals(caO().fromType) || "frs_live_play".equals(caO().fromType) || "person_play".equals(caO().fromType) || "search".equals(caO().fromType) || "person_attention".equals(caO().fromType)) {
            com.baidu.live.c.xe().aV(true);
        } else {
            com.baidu.live.c.xe().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nF(boolean z) {
        View Ds;
        if (this.hng == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSj = false;
            fVar.context = caO().pageContext.getPageActivity();
            fVar.aSt = z;
            fVar.fromType = caO().fromType;
            fVar.aSu = isVertical() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hng = (ad) runTask.getData();
            }
        }
        if (this.hng != null && (Ds = this.hng.Ds()) != null && this.hmN.hxk.indexOfChild(Ds) < 0) {
            this.hmN.hxk.addView(Ds, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void can() {
        View Ej;
        if (this.hns == null) {
            com.baidu.live.gift.ak akVar = new com.baidu.live.gift.ak();
            akVar.aSj = false;
            akVar.pageContext = caO().pageContext;
            akVar.fromType = caO().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hns = (ag) runTask.getData();
            }
        }
        if (this.hns != null && (Ej = this.hns.Ej()) != null && caO().hxk.indexOfChild(Ej) < 0) {
            if (Ej.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ej.getParent()).removeView(Ej);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hne != null && this.hne.IH().KN()) {
                layoutParams.bottomMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hne.IH().getView().getId());
            } else {
                layoutParams.bottomMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            caO().hxk.addView(Ej, layoutParams);
        }
    }

    protected void nG(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.hns != null) {
            View Ej = this.hns.Ej();
            if (Ej.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) Ej.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if (this.hne != null && z) {
                layoutParams.bottomMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds190);
                layoutParams.addRule(2, this.hne.IH().getView().getId());
            } else {
                layoutParams.bottomMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            Ej.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cao() {
        View DV;
        if (this.hnh == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSj = false;
            aVar.context = caO().pageContext.getPageActivity();
            aVar.fromType = caO().fromType;
            aVar.aSk = caO().hxp;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hnh = (ab) runTask.getData();
            }
        }
        if (this.hnh != null && (DV = this.hnh.DV()) != null && this.hnP != null && this.hnP.indexOfChild(DV) < 0) {
            if (DV.getParent() instanceof ViewGroup) {
                ((ViewGroup) DV.getParent()).removeView(DV);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.hnP.addView(DV, this.hnP.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cap() {
        CustomResponsedMessage runTask;
        if (this.hnf == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, caO().pageContext)) != null) {
            this.hnf = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hnf != null) {
            this.hnf.setOtherParams(this.otherParams);
            this.hnf.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
                @Override // com.baidu.live.im.b.a.InterfaceC0177a
                public void Jo() {
                    b.this.caz();
                }
            });
            this.hnf.a(caO().hxj.DW(), false);
            View zf = this.hnf.zf();
            if (zf != null && this.hnQ.indexOfChild(zf) < 0) {
                Resources resources = caO().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(caO().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hnQ.addView(zf, layoutParams);
            }
        }
    }

    private void caq() {
        if (this.hnc == null) {
            this.hnc = new com.baidu.tieba.ala.liveroom.h.a(caO().pageContext);
        }
        if (this.hnV != null) {
            this.hnc.Hb(this.hnV.user_id);
        }
        this.hnc.aF(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nH(boolean z) {
        if (caO() != null && !z) {
            if (this.hny == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.m.a.class, caO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hny = (com.baidu.live.m.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hny.d(this.hnP, caH());
            if (caO().hxj != null) {
                this.hny.a(caO().hxj.DW());
            }
            this.hny.setCanVisible(true);
            this.hny.bZ(true);
            this.hny.a(caO().hxj.bTh());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void car() {
        if (caO() != null) {
            if (this.hnz == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.w.a.class, caO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hnz = (com.baidu.live.w.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (caO().hxj != null) {
                this.hnz.b(caO().hxj.DW(), this.otherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bZg() {
        if (caO() != null) {
            if (this.hme == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ae.a.class, caO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hme = (com.baidu.live.ae.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hme.setIsHost(false);
            this.hme.a(bZK(), caO().hxj.DW().aGH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cas() {
        if (caO() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.hnA == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.u.a.class, caO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hnA = (com.baidu.live.u.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hnA.setIsHost(false);
            this.hnA.a(bZK(), caO().hxj.DW());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cat() {
        if (this.hmV != null && caO() != null && caO().hxj != null) {
            this.hmV.d(this.hnP, caO().hxj.DW());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cau() {
        if (caO() != null) {
            if (this.hnC == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.l.a.class, caO().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hnC = (com.baidu.live.l.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.hmN.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.hnC.a(this.hnP, caO().hxj.DW(), layoutParams, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cav() {
        if (caO() != null) {
            if (this.hnn == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913264, com.baidu.live.y.b.class, caO().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hnn = (com.baidu.live.y.b) runTask.getData();
                } else {
                    return;
                }
            }
            this.hnn.a(caO().hxj.DW(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caw() {
        if (caO() != null) {
            if (this.hnE == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913278, com.baidu.live.h.a.class, caO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hnE = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hnE.a(bZK(), caO().hxj.DW());
        }
    }

    protected void cax() {
        if (this.hnD == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.u.b.class, caO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hnD = (com.baidu.live.u.b) runTask.getData();
            } else {
                return;
            }
        }
        if (caO().hxj.DW() != null && caO().hxj.DW().aFH != null && caO().hxj.DW().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(caO().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(caO().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.hnD.b(this.hnP, layoutParams, caO().hxj.DW());
        }
    }

    private void cay() {
        if (this.hnq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, caO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hnq = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (caO().hxj.DW() != null && caO().hxj.DW().aFH != null && caO().hxj.DW().mLiveInfo != null) {
            this.hnq.setHost(false);
            this.hnq.setOtherParams(JQ());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.hnq.a(this.hnP, layoutParams, caO().hxj.DW());
            this.hnq.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.guardclub.l
                public void HI() {
                    b.this.caP();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x03ee, code lost:
        caO().hxj.ciu();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x06f2, code lost:
        GQ(r3.giftId);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        long j;
        long j2;
        JSONObject jSONObject3 = null;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject3 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject3 = new JSONObject(bVar.getContent());
            }
            String optString = jSONObject3.optString("ext");
            if (!TextUtils.isEmpty(optString)) {
                new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
            }
            jSONObject = jSONObject3.optJSONObject("ext_data");
            jSONObject2 = jSONObject3;
        } catch (JSONException e) {
            jSONObject = null;
            jSONObject2 = jSONObject3;
        }
        if (this.hme != null) {
            this.hme.V(jSONObject2);
        }
        if (this.hmO == null || !this.hmO.V(jSONObject2)) {
            if (bVar.getMsgType() == 12 || bVar.getMsgType() == 13) {
                if (jSONObject2 != null) {
                    String optString2 = jSONObject2.optString("content_type");
                    if ("live_on_private".equals(optString2)) {
                        boolean z = jSONObject2.optInt("on_private", 0) == 1;
                        if (this.bok != null) {
                            this.bok.cv(z);
                        }
                        int optInt = jSONObject2.optInt("on_audio_private", -1);
                        if (optInt >= 0) {
                            vf(optInt);
                        }
                    } else if ("live_admin".equals(optString2)) {
                        long optLong = jSONObject2.optLong("user_id");
                        int optInt2 = jSONObject2.optInt("opt_type");
                        if (optInt2 == 1) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                caO().hxj.DW().aGd.isAdmin = 1;
                            }
                        } else if (optInt2 == 2) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                caO().hxj.DW().aGd.isAdmin = 0;
                                caO().hxj.ciu();
                            }
                        } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            caO().hxj.DW().aGd.isAdmin = 0;
                            caO().hxj.ciu();
                        }
                    } else if ("task".equals(optString2)) {
                        dT(jSONObject2);
                    } else if ("live_net_status".equals(optString2)) {
                        int optInt3 = jSONObject2.optInt("net_status");
                        if (this.hni != null && !caO().hxo) {
                            String str = null;
                            if (optInt3 == 0) {
                                str = caO().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                            } else if (optInt3 == 1) {
                                str = caO().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                            } else if (optInt3 == 2) {
                                str = caO().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                            }
                            if (str != null) {
                                if (bUY()) {
                                    BdUtilHelper.getCustomToast().showToast(str, 1);
                                } else {
                                    this.hni.c(caO().hxi.getLiveContainerView(), str, 1);
                                }
                            }
                        }
                    } else if ("close_live".equals(optString2)) {
                        final int optInt4 = jSONObject2.optInt("close_type");
                        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.bok != null) {
                                    b.this.bok.cu(optInt4 == 2);
                                }
                            }
                        });
                    } else if ("first_recharge_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                    } else if ("privilege_award_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.t.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                    } else if ("live_talk_ban".equals(optString2)) {
                        long optLong2 = jSONObject2.optLong("user_id");
                        if (caO().hxj.DW() != null && caO().hxj.DW().aGd != null && caO().hxj.DW().aGd.userId == optLong2) {
                            caO().hxj.DW().aGd.isBlock = 1;
                            bZx();
                        }
                    } else if ("live_talk_remove_ban".equals(optString2)) {
                        long optLong3 = jSONObject2.optLong("user_id");
                        if (caO().hxj.DW() != null && caO().hxj.DW().aGd != null && caO().hxj.DW().aGd.userId == optLong3) {
                            caO().hxj.DW().aGd.isBlock = 0;
                            bZx();
                        }
                    } else if ("live_talk_admin_ban".equals(optString2)) {
                        long optLong4 = jSONObject2.optLong("user_id");
                        if (caO().hxj.DW() != null && caO().hxj.DW().aGd != null && caO().hxj.DW().aGd.userId == optLong4) {
                            caO().hxj.DW().aGd.isUegBlock = 1;
                            bZx();
                        }
                    } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                        long optLong5 = jSONObject2.optLong("user_id");
                        if (caO().hxj.DW() != null && caO().hxj.DW().aGd != null && caO().hxj.DW().aGd.userId == optLong5) {
                            caO().hxj.DW().aGd.isUegBlock = 0;
                            bZx();
                        }
                    } else if ("need_update_live_mark_info".equals(optString2)) {
                        if (caO() != null && caO().hxj != null && caO().hxj.DW() != null && caO().hxj.DW().aGd != null) {
                            long j3 = caO().hxj.DW().aGd.userId;
                            if (j3 == jSONObject2.optLong("user_id")) {
                                caO().hxj.ciu();
                            }
                            try {
                                JSONArray optJSONArray = jSONObject2.optJSONArray("user_id_list");
                                if (optJSONArray != null && optJSONArray.length() > 0) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= optJSONArray.length()) {
                                            break;
                                        }
                                        long j4 = optJSONArray.getLong(i);
                                        if (j4 > 0 && j3 == j4) {
                                            break;
                                        }
                                        i++;
                                    }
                                }
                            } catch (JSONException e2) {
                                e2.printStackTrace();
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, caO().hxj.DW().aGd));
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
                        com.baidu.live.data.a JB = bVar.JB();
                        if (JB != null && ac.fU(str3)) {
                            ac.d(str3, 1L, "", "", JB.userId, JB.portrait, JB.userName, "", "", false, "", "", "", false, false, true, -1L);
                        }
                    } else if ("challenge_mvp".equals(optString2)) {
                        if (jSONObject2 != null) {
                            bd bdVar = new bd();
                            bdVar.parseJson(jSONObject2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bdVar));
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
                    } else if (TextUtils.equals(optString2, "mix_room_close")) {
                        if (this.hnK != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("source", "im_mix_room_close");
                                jSONObject4.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                                this.hnK.z("mix_room_close", jSONObject4);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else if ("mysterious_man_activate".equals(optString2)) {
                        GW(jSONObject2.optString("url"));
                    } else if ("mysterious_man_expired_remind".equals(optString2)) {
                        GX(jSONObject2.optString("text"));
                    }
                }
            } else if (bVar.getMsgType() == 125) {
                if (this.hmZ != null) {
                    this.hmZ.M(bVar);
                }
            } else if (bVar.getMsgType() == 24 && jSONObject2 != null) {
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject2);
                if (caO().hxj != null && caO().hxj.DW() != null && caO().hxj.DW().aGR && TextUtils.equals(cVar.bkM, "luckybag")) {
                    cVar.aZX = "";
                }
                com.baidu.live.data.a JB2 = bVar.JB();
                boolean z2 = false;
                long j5 = 0;
                String str4 = null;
                if (caO().hxj == null || caO().hxj.DW() == null || caO().hxj.DW().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                } else {
                    j5 = caO().hxj.DW().mLiveInfo.live_id;
                    long j6 = caO().hxj.DW().mLiveInfo.group_id;
                    long j7 = caO().hxj.DW().aFH.userId;
                    str4 = caO().hxj.DW().mLiveInfo.appId;
                    z2 = caO().hxj.DW().mLiveInfo.isPubShow;
                    j = j7;
                    j2 = j6;
                }
                if (!cVar.blW || cVar.isDynamic) {
                    if (!TextUtils.isEmpty(cVar.blR) && !TextUtils.isEmpty(cVar.blT)) {
                        if (jSONObject2.optInt("flag_show") == 1) {
                            ac.b(cVar, JB2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, "", "", bVar.getMsgId());
                            try {
                                JSONArray jSONArray = new JSONArray(cVar.blT);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.af.f.Pa().gZ(jSONArray.getJSONObject(i2).optString(LogConfig.LOG_GIFT_ID))) {
                                            break;
                                        }
                                        i2++;
                                    }
                                }
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } else {
                        bVar.setHost(z2 && cVar.blU);
                        ac.b(cVar, JB2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, (cVar.blU || cVar.blW || cVar.blV) ? false : true, true, "", "", bVar.getMsgId());
                        GQ(cVar.giftId);
                    }
                    if (!UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT.equals(cVar.contentType)) {
                        com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar2.blS = cVar.blS;
                        cVar2.liveId = j5;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hnK = dVar;
    }

    protected void GQ(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void caz() {
        if (caA()) {
            BdUtilHelper.hideSoftKeyPad(caO().pageContext.getPageActivity(), caO().hxi.getLiveContainerView());
            bZI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caA() {
        if (bZH() == null || bZH().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        CustomResponsedMessage runTask;
        caO().hxk.setOnTouchListener(this.hoH);
        caI();
        caJ();
        caK();
        caq();
        cay();
        cax();
        if (this.hmX != null && caO().hxj.DW() != null && caO().hxj.DW().mLiveInfo != null) {
            this.hmX.cN(caO().hxj.DW().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.hnd != null) {
            this.hnd.h(caO().hxj.DW());
        }
        if (this.hnb != null) {
            this.hnb.f(caO().hxj.DW());
        }
        if (this.hnj != null) {
            this.hnj.c(caO().hxj.DW(), JQ());
        }
        if (this.hnk != null) {
            this.hnk.b(caO().hxj.DW(), JQ());
        }
        if (this.hnl != null) {
            this.hnl.c(caO().hxj.DW(), JQ());
        }
        if (this.hnM != null) {
            this.hnM.f(caO().hxj.DW());
        }
        if (caO().hxk != null) {
            caO().hxk.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.35
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.caA() && b.this.hmW != null) {
                        b.this.hmW.oz(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.hmW != null) {
                        b.this.hmW.oz(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean LE() {
                    if (b.this.hoh == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.hoh) {
                        if (bVar.LE()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            caO().hxk.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.36
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.hnw == null && (runTask = MessageManager.getInstance().runTask(2913165, af.class, caO().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hnw = (af) runTask.getData();
        }
        if (this.mHandler != null && caQ()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.37
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.caQ()) {
                        b.this.vf(b.this.caO().hxj.DW().mLiveInfo.isAudioOnPrivate);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caB() {
        if (this.hnM == null && caO() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.t.a.class, caO().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hnM = (com.baidu.live.t.a) runTask.getData();
                this.hnM.p(caO().hxk);
                this.hnM.b(caO().hxj.DW());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caC() {
        x DW;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (caO() != null && caO().hxj != null && (DW = caO().hxj.DW()) != null && DW.mLiveInfo != null && !DW.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) caO().hxi) != null) {
            if (this.hnF == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.aa.a.class, caO().pageContext)) != null && runTask.getData() != null) {
                this.hnF = (com.baidu.live.aa.a) runTask.getData();
            }
            if (this.hnF != null) {
                this.hnF.o(DW);
                this.hnF.a(this.hoI);
                this.hnF.a(viewGroup, this.hnP);
                a(this.hnF.Od());
                a(this.hnF.Oe());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.hog == null) {
            this.hog = new ArrayList();
        }
        if (!this.hog.contains(dVar)) {
            this.hog.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.hog != null && this.hog.contains(dVar)) {
            this.hog.remove(dVar);
        }
    }

    protected void caD() {
        if (this.hog != null) {
            this.hog.clear();
            this.hog = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hog == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.hog.iterator();
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
        if (this.hoh == null) {
            this.hoh = new ArrayList();
        }
        if (!this.hoh.contains(bVar)) {
            this.hoh.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hoh != null && this.hoh.contains(bVar)) {
            this.hoh.remove(bVar);
        }
    }

    protected void caE() {
        if (this.hoh != null) {
            this.hoh.clear();
            this.hoh = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hoh == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hoh.iterator();
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
    public void caF() {
        if (this.hnx == null && this.hnH != null && this.hnH.aNb && caO() != null && caO().hxj != null && caO().hxj.DW() != null) {
            this.hnx = new com.baidu.tieba.ala.liveroom.h.e(caO().pageContext, this.hnH);
            this.hnx.J(caO().hxj.DW());
            if (this.hnH.aNe == 1) {
                if (this.hne != null) {
                    this.hnY = true;
                }
            } else if (this.hnH.aNe == 2) {
                a(caO().hxj.DW(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caG() {
        CustomResponsedMessage runTask;
        if (caO() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, caO().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.ab.a)) {
            this.hnI = (com.baidu.live.ab.a) runTask.getData();
            this.hnI.s(bZK());
            if (caO().hxj != null) {
                this.hnZ = this.hnI.p(caO().hxj.DW());
            }
            this.hnI.setCanVisible(!this.hnT);
        }
    }

    private ViewGroup.LayoutParams caH() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = caO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        caO().hxi.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(caO().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(caO().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? caO().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + caO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void caI() {
        if (this.hmW != null) {
            this.hmW.aM(caO().hxk);
        }
    }

    private void caJ() {
        if (this.hmX != null) {
            this.hmX.aP(caO().hxk);
        }
    }

    private void caK() {
        if (this.hna == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ai.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hna = (com.baidu.live.ai.a) runTask.getData();
            }
            caL();
        }
    }

    private void dT(JSONObject jSONObject) {
        if (this.hna != null) {
            if (this.hmT != null) {
                this.hna.cU(this.hmT.ceJ() ? false : true);
            } else {
                this.hna.cU(true);
            }
            this.hna.Z(jSONObject);
        }
    }

    private void caL() {
        if (this.hna != null && caO().hxj.DW() != null && caO().hxj.DW().aGs != null) {
            if (this.hmT != null) {
                this.hna.cU(this.hmT.ceJ() ? false : true);
            } else {
                this.hna.cU(true);
            }
            this.hna.j(caO().hxj.DW());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        if (xVar != null) {
            if (this.hmX != null && xVar.mLiveInfo != null) {
                this.hmX.cN(xVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.hnp != null) {
                this.hnp.i(xVar);
            }
            caL();
            if (this.hnc != null && xVar.aFH != null) {
                this.hnc.Hb(String.valueOf(xVar.aFH.userId));
            }
            if (this.hmP != null) {
                this.hmP.a(xVar);
            }
            if (this.hnh != null && xVar.mLiveInfo != null) {
                this.hnh.a(xVar.mLiveInfo, xVar.aFH);
            }
            if (this.hnf != null) {
                this.hnf.a(xVar);
            }
            if (this.hnI != null) {
                this.hnZ = this.hnI.p(xVar);
            }
            if (this.hny != null) {
                this.hny.a(xVar);
            }
            if (this.hnA != null) {
                this.hnA.a(xVar);
            }
            if (this.hnE != null) {
                this.hnE.a(xVar);
            }
            if (this.hnz != null) {
                this.hnz.a(xVar);
            }
            if (this.hme != null) {
                this.hme.a(xVar);
            }
            if (this.hnC != null) {
                this.hnC.a(xVar);
            }
            if (this.hnB != null) {
                this.hnB.a(xVar);
            }
            if (this.hnD != null) {
                this.hnD.a(xVar);
            }
            if (this.hnL != null) {
                this.hnL.b(xVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vf(int i) {
        if (!caO().hxo) {
            if (this.hnR < 0 && i == 0) {
                this.hnR = i;
            } else if (this.hnR != i) {
                if (i == 1) {
                    if (!this.hni.vU(2)) {
                        String string = caO().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(caO().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.hni.a(caO().hxi.getLiveContainerView(), string, 2, 5000);
                        }
                    }
                } else {
                    String string2 = caO().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.hni.vV(2);
                    this.hni.vV(3);
                    if (bUY()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.hni.c(caO().hxi.getLiveContainerView(), string2, 3);
                    }
                }
                this.hnR = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cy(boolean z) {
        super.cy(z);
        if (z) {
            caM();
        }
        if (this.hnp != null) {
            this.hnp.HJ();
        }
        if (this.hnb != null) {
            this.hnb.HJ();
        }
        if (this.hmZ != null) {
            this.hmZ.ckM();
        }
        if (this.hmR != null) {
            this.hmR.zH();
        }
        if (this.hmT != null) {
            this.hmT.onDestroy();
        }
        if (this.hna != null) {
            this.hna.onDestroy();
            this.hna = null;
        }
        if (this.hng != null) {
            View Ds = this.hng.Ds();
            if (Ds != null && Ds.getParent() != null) {
                ((ViewGroup) Ds.getParent()).removeView(Ds);
            }
            this.hng.onDestroy();
            this.hng = null;
        }
        if (this.hnf != null) {
            this.hnf.a((a.InterfaceC0177a) null);
            this.hnf.zh();
        }
        if (this.hni != null) {
            this.hni.zH();
        }
        this.hnR = -1;
        if (this.hnc != null) {
            this.hnc.zH();
            this.hnc.onDestroy();
        }
        if (this.hmU != null) {
            this.hmU.ckK();
        }
        if (this.hmV != null) {
            this.hmV.bYT();
            this.hmV.Ei();
        }
        if (this.hmW != null) {
            this.hmW.Ei();
        }
        if (this.hnd != null) {
            this.hnd.Ei();
        }
        if (this.hnj != null) {
            this.hnj.HJ();
        }
        if (this.hnk != null) {
            this.hnk.Ei();
        }
        if (this.hnl != null) {
            this.hnl.onDestroy();
        }
        if (this.hno != null) {
            this.hno.onDestory();
        }
        if (this.hnr != null) {
            this.hnr.xk();
        }
        if (this.hnq != null) {
            this.hnq.xk();
        }
        if (this.hnD != null) {
            this.hnD.xk();
        }
        if (this.hnx != null) {
            this.hnx.onDestroy();
        }
        if (this.hnt != null) {
            this.hnt.Ei();
        }
        if (this.hba != null) {
            this.hba.Ei();
        }
        if (this.hnu != null) {
            this.hnu.Ei();
        }
        if (this.hnw != null) {
            this.hnw.Ei();
        }
        if (this.hmS != null) {
            this.hmS.onDestory();
        }
        if (this.hnI != null) {
            this.hnI.Ei();
        }
        if (this.hny != null) {
            this.hny.xk();
            this.hny.setCanVisible(false);
        }
        if (this.hnA != null) {
            this.hnA.xk();
        }
        if (this.hnE != null) {
            this.hnE.xk();
        }
        if (this.hnz != null) {
            this.hnz.xk();
        }
        if (this.hme != null) {
            this.hme.xk();
        }
        if (this.hnB != null) {
            this.hnB.xk();
        }
        if (this.hnv != null) {
            this.hnv.Ei();
        }
        if (this.hns != null) {
            this.hns.onDestroy();
        }
        if (this.hnF != null) {
            this.hnF.zH();
            b(this.hnF.Od());
            b(this.hnF.Oe());
        }
        if (this.hnG != null) {
            this.hnG.xk();
        }
        if (this.hnC != null) {
            this.hnC.xk();
        }
        if (this.hne != null) {
            this.hne.IH().xk();
        }
        if (this.hnL != null) {
            this.hnL.HJ();
        }
        if (this.hnM != null) {
            this.hnM.HJ();
            this.hnM = null;
        }
        ShowUtil.windowCount = 0;
        caD();
        caE();
    }

    private void caM() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = caO().hxk.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = caO().hxk.getChildAt(i);
            if (childAt != this.hnP && childAt != this.hnQ) {
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
        if (this.hnP != null) {
            this.hnP.removeAllViews();
        }
        if (this.hnQ != null) {
            this.hnQ.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, x xVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(x xVar) {
        View zf;
        View Ds;
        if (this.hng != null && (Ds = this.hng.Ds()) != null && Ds.getParent() != null) {
            ((ViewGroup) Ds.getParent()).removeView(Ds);
        }
        if (this.hnf != null && (zf = this.hnf.zf()) != null && zf.getParent() != null) {
            ((ViewGroup) zf.getParent()).removeView(zf);
        }
        if (this.hmT != null) {
            this.hmT.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean LA() {
        if (this.hmY == null || !this.hmY.ceO()) {
            if (this.hmT == null || !this.hmT.aI(caO().hxi.getLiveContainerView())) {
                if (this.hmW != null) {
                    this.hmW.bVE();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.hnm != null && this.hnm.cex()) {
                    this.hnm.ceG();
                    return false;
                } else if (this.hnl == null || !this.hnl.PV()) {
                    if (this.hnN == null || !this.hnN.PV()) {
                        if (this.hnn == null || !this.hnn.NX()) {
                            cam();
                            return true;
                        }
                        return false;
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

    @Override // com.baidu.live.y.a
    public void NW() {
        Lz();
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cw(boolean z) {
        super.cw(z);
        if (this.hnp != null) {
            this.hnp.release();
        }
        if (this.hnb != null) {
            this.hnb.onDestroy();
        }
        if (this.hna != null) {
            this.hna.onDestroy();
            this.hna = null;
        }
        if (this.hmZ != null) {
            this.hmZ.ckM();
        }
        if (this.hng != null) {
            this.hng.onDestroy();
            this.hng = null;
        }
        if (this.hnh != null) {
            this.hnh.onDestroy();
            this.hnh = null;
        }
        if (this.hni != null) {
            this.hni.onDestroy();
        }
        if (this.hmR != null) {
            this.hmR.onDestroy();
        }
        if (this.hns != null) {
            this.hns.onDestroy();
            this.hns = null;
        }
        if (this.hnf != null) {
            this.hnf.a((a.InterfaceC0177a) null);
            this.hnf.release();
            this.hnf = null;
        }
        if (this.hnj != null) {
            this.hnj.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.hnj.release();
        }
        if (this.hnk != null) {
            this.hnk.a(null);
            this.hnk.release();
        }
        if (this.hnl != null) {
            this.hnl.a((b.a) null);
            this.hnl.onDestroy();
        }
        if (this.hnq != null) {
            this.hnq.onDestroy();
        }
        if (this.hnr != null) {
            this.hnr.onDestroy();
        }
        if (this.hno != null) {
            this.hno.onDestory();
        }
        if (this.hnD != null) {
            this.hnD.onDestroy();
        }
        if (this.hnx != null) {
            this.hnx.onDestroy();
        }
        if (this.hnt != null) {
            this.hnt.release();
        }
        if (this.hba != null) {
            this.hba.release();
        }
        if (this.hnv != null) {
            this.hnv.release();
        }
        if (this.hnu != null) {
            this.hnu.release();
        }
        if (this.hnw != null) {
            this.hnw.release();
        }
        if (this.hmS != null) {
            this.hmS.onDestory();
        }
        if (this.hnI != null) {
            this.hnI.release();
        }
        if (this.hny != null) {
            this.hny.onDestroy();
        }
        if (this.hnA != null) {
            this.hnA.onDestroy();
        }
        if (this.hnE != null) {
            this.hnE.onDestroy();
        }
        if (this.hnz != null) {
            this.hnz.onDestroy();
        }
        if (this.hme != null) {
            this.hme.onDestroy();
        }
        if (this.hnB != null) {
            this.hnB.onDestroy();
        }
        if (this.hmW != null) {
            this.hmW.Ei();
        }
        if (this.hnC != null) {
            this.hnC.onDestroy();
        }
        if (this.hnL != null) {
            this.hnL.onDestroy();
        }
        if (this.hnM != null) {
            this.hnM.onDestory();
        }
        if (this.hnn != null) {
            this.hnn.onDestroy();
        }
        if (this.hnF != null) {
            this.hnF.onDestroy();
            b(this.hnF.Od());
            b(this.hnF.Oe());
        }
        caD();
        caE();
        MessageManager.getInstance().unRegisterListener(this.hom);
        MessageManager.getInstance().unRegisterListener(this.hon);
        MessageManager.getInstance().unRegisterListener(this.hoo);
        MessageManager.getInstance().unRegisterListener(this.hos);
        MessageManager.getInstance().unRegisterListener(this.hou);
        MessageManager.getInstance().unRegisterListener(this.how);
        MessageManager.getInstance().unRegisterListener(this.hop);
        MessageManager.getInstance().unRegisterListener(this.hoq);
        MessageManager.getInstance().unRegisterListener(this.gKz);
        MessageManager.getInstance().unRegisterListener(this.hor);
        MessageManager.getInstance().unRegisterListener(this.gKM);
        MessageManager.getInstance().unRegisterListener(this.hox);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gUP);
        MessageManager.getInstance().unRegisterListener(this.gUM);
        MessageManager.getInstance().unRegisterListener(this.bup);
        MessageManager.getInstance().unRegisterListener(this.hoy);
        MessageManager.getInstance().unRegisterListener(this.hoz);
        MessageManager.getInstance().unRegisterListener(this.hoA);
        MessageManager.getInstance().unRegisterListener(this.hoE);
        MessageManager.getInstance().unRegisterListener(this.hoF);
        MessageManager.getInstance().unRegisterListener(this.hbb);
        MessageManager.getInstance().unRegisterListener(this.hoG);
        MessageManager.getInstance().unRegisterListener(this.hoB);
        MessageManager.getInstance().unRegisterListener(this.bnx);
        MessageManager.getInstance().unRegisterListener(this.hoC);
        MessageManager.getInstance().unRegisterListener(this.hoD);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.hnj != null) {
            this.hnj.og(false);
        }
        if (this.hnl != null) {
            this.hnl.og(false);
        }
        bZI();
        if (this.hnp != null) {
            this.hnp.onPause();
        }
        if (this.hnt != null) {
            this.hnt.pause();
        }
        if (this.hba != null) {
            this.hba.pause();
        }
        if (this.hnv != null) {
            this.hnv.pause();
        }
        if (this.hns != null) {
            this.hns.onPause();
        }
        if (this.hnC != null) {
            this.hnC.onPause();
        }
        if (this.hnE != null) {
            this.hnE.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hoc = false;
        if (this.hnU && this.hnV != null) {
            a(this.hnV);
            this.hnU = false;
        }
        if (this.hnj != null) {
            this.hnj.og(true);
        }
        if (this.hnl != null) {
            this.hnl.og(true);
        }
        if (this.hnp != null) {
            this.hnp.onResume();
        }
        if (this.hnt != null) {
            this.hnt.resume();
        }
        if (this.hba != null) {
            this.hba.resume();
        }
        if (this.hnv != null) {
            this.hnv.resume();
        }
        if (this.hns != null) {
            this.hns.onResume();
        }
        if (this.hnC != null) {
            this.hnC.onResume();
        }
        if (this.hnE != null) {
            this.hnE.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avQ() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hnF != null && this.hnF.isOpen()) {
            this.hnF.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            avQ();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    P(-1, -1, -1);
                    return;
                }
                return;
            }
            avQ();
        } else if (i == 25034) {
            caj();
        } else if (i == 25043) {
            if (i2 == -1) {
                caP();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.q.a.K(caO().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.q.a.K(caO().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hnT = z;
        if (this.hnM != null) {
            this.hnM.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean caN() {
        return (caO().hxj.DW() == null || caO().hxj.DW().mLiveInfo == null || caO().hxj.DW().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.hmT != null) {
                this.hmT.C(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.hnl != null) {
            this.hnl.bjV();
        }
        if (this.hmS != null) {
            this.hmS.bjV();
        }
        if (this.hnF != null) {
            this.hnF.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.hmN = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a caO() {
        return this.hmN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caP() {
        String HE = g.HD().HE();
        if (!TextUtils.isEmpty(HE)) {
            try {
                P(-1, Integer.parseInt(HE), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                P(-1, -1, -1);
            }
        }
    }

    public boolean dz(int i) {
        if (1 == i) {
            if (bZH() != null) {
                bZH().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.hnT) {
                return false;
            }
            return this.hmT == null || !this.hmT.ceJ();
        } else if (3 == i) {
            if (caO().hxk != null) {
                caO().hxk.setEnabled(false);
                if (this.bok != null) {
                    this.bok.e(!caO().hxm, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void vd(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void dA(int i) {
        if (3 == i) {
            caO().hxk.setEnabled(true);
            if (this.bok != null) {
                this.bok.e(!caO().hxm, true);
            }
            if (this.hna != null) {
                this.hna.cU(true);
            }
        } else if (2 == i && this.hmZ != null) {
            this.hmZ.oI(true);
        }
    }

    public String JQ() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hnf != null) {
            this.hnf.setOtherParams(str);
        }
        if (this.hnp != null) {
            this.hnp.gK(str);
        }
    }

    private boolean bUY() {
        return caO().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.goI = alaLastLiveroomInfo;
    }

    public void ct(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(caO().pageContext.getPageActivity(), this.hoa);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }

    private void GW(String str) {
        if (this.hba == null) {
            this.hba = new com.baidu.live.ap.a(caO().pageContext.getPageActivity());
        }
        com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
        cVar.url = str;
        cVar.isFullScreen = true;
        this.hba.a(cVar);
    }

    private void GX(String str) {
        Activity pageActivity = caO().pageContext.getPageActivity();
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(pageActivity);
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(true);
        cVar.setTitleVisible(false);
        cVar.VL();
        cVar.o("", str, pageActivity.getString(a.h.sdk_know), "");
        cVar.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.39
            @Override // com.baidu.live.view.c.a
            public void OB() {
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void OC() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean caQ() {
        return (caO().hxj.DW() == null || caO().hxj.DW().mLiveInfo == null || caO().hxj.DW().mLiveInfo.isAudioOnPrivate != 1) ? false : true;
    }
}
