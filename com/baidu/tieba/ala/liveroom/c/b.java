package com.baidu.tieba.ala.liveroom.c;

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
import com.baidu.live.data.ao;
import com.baidu.live.data.ax;
import com.baidu.live.data.bh;
import com.baidu.live.data.bn;
import com.baidu.live.data.bv;
import com.baidu.live.data.bw;
import com.baidu.live.data.ci;
import com.baidu.live.data.f;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.af;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.ak;
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
import com.baidu.tieba.ala.liveroom.g.e;
import com.baidu.tieba.ala.liveroom.l.b;
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
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a, com.baidu.live.w.a {
    public static boolean hul;
    protected com.baidu.live.an.a bif;
    protected AlaLastLiveroomInfo gto;
    private com.baidu.tieba.ala.liveroom.data.a hsX;
    protected com.baidu.tieba.ala.liveroom.operation.a hsY;
    protected com.baidu.live.j.b hsZ;
    protected com.baidu.live.ad.a hsp;
    protected h htA;
    protected j htB;
    protected ag htC;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b htD;
    private af htE;
    protected e htF;
    protected com.baidu.live.l.a htG;
    protected com.baidu.live.v.a htH;
    protected com.baidu.live.t.a htI;
    protected com.baidu.live.a.a htJ;
    protected com.baidu.live.k.a htK;
    protected com.baidu.live.t.c htL;
    protected com.baidu.live.g.a htM;
    protected com.baidu.live.y.a htN;
    protected com.baidu.tieba.ala.liveroom.exclusive.b htO;
    protected bw htP;
    protected com.baidu.live.aa.a htQ;
    protected com.baidu.tieba.ala.liveroom.e.a htR;
    protected com.baidu.tieba.ala.player.d htS;
    protected com.baidu.live.guess.a htT;
    protected com.baidu.live.s.a htU;
    protected com.baidu.live.am.c htV;
    protected com.baidu.live.c.a htW;
    protected RelativeLayout htX;
    protected RelativeLayout htY;
    protected com.baidu.live.j.a hta;
    protected com.baidu.tieba.ala.liveroom.share.c htb;
    protected com.baidu.tieba.ala.liveroom.q.b htc;
    protected com.baidu.tieba.ala.liveroom.guide.c htd;
    protected com.baidu.tieba.ala.liveroom.watermark.a hte;
    protected com.baidu.tieba.ala.liveroom.a.b htf;
    protected com.baidu.tieba.ala.liveroom.praise.a htg;
    protected com.baidu.tieba.ala.liveroom.sticker.a hth;
    protected com.baidu.tieba.ala.liveroom.guide.d hti;
    protected com.baidu.tieba.ala.liveroom.v.a htj;
    protected com.baidu.live.ag.a htk;
    protected com.baidu.live.ag.d htl;
    private com.baidu.tieba.ala.liveroom.g.a htm;
    private m htn;
    k hto;
    com.baidu.live.im.b.a htp;
    protected ad htq;
    protected ab htr;
    protected com.baidu.tieba.ala.liveroom.tippop.a hts;
    private com.baidu.tieba.ala.liveroom.guideim.b htt;
    protected com.baidu.live.view.input.d htu;
    com.baidu.tieba.ala.liveroom.l.b htv;
    protected com.baidu.tieba.ala.liveroom.guide.a htw;
    protected com.baidu.live.w.b htx;
    private com.baidu.live.guardclub.k hty;
    protected com.baidu.live.m.b htz;
    protected boolean hua;
    protected ax hud;
    protected GuardClubInfoHttpResponseMessage hue;
    boolean huf;
    boolean hug;
    boolean huh;
    public boolean huj;
    public boolean huk;
    protected com.baidu.tieba.ala.liveroom.s.b hum;
    protected com.baidu.tieba.ala.liveroom.i.e hun;
    protected List<com.baidu.live.liveroom.g.d> huo;
    protected List<com.baidu.live.liveroom.g.b> hup;
    CustomMessageTask huq;
    CustomMessageTask hur;
    protected String otherParams;
    private int htZ = -1;
    protected boolean aOg = true;
    protected int aOi = 0;
    protected int mOrientation = 0;
    protected boolean hub = false;
    protected boolean huc = false;
    private int hui = a.C0201a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> hus = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.c.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: cbY */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> hut = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.c.b.12
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS) { // from class: com.baidu.tieba.ala.liveroom.c.b.12.1
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                public Object getData() {
                    return false;
                }
            };
        }
    };
    private CustomMessageListener huu = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ao aoVar;
            if ((customResponsedMessage.getData() instanceof ao) && (aoVar = (ao) customResponsedMessage.getData()) != null) {
                b.this.a(aoVar.aLz, aoVar.aLv, aoVar.aLw, aoVar.aLx, aoVar.aLy);
            }
        }
    };
    private CustomMessageListener huv = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.vq(7);
        }
    };
    private CustomMessageListener huw = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cbq();
        }
    };
    private CustomMessageListener hux = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.cbV().hDq.Fp().aJD.userId);
            com.baidu.live.view.a.Xr().a(valueOf, new f(b.this.cbV().hDq.Fp().aJD.portrait, valueOf, true, b.this.cbV().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener huy = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.ab) && b.this.htb != null) {
                b.this.htb.d((com.baidu.live.data.ab) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bzm = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hto != null) {
                b.this.hto.g(z.Fh().Fj());
            }
        }
    };
    private CustomMessageListener huz = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.hsX.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.HI(str);
            }
        }
    };
    private CustomMessageListener gPc = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.cbV().pageContext.getPageActivity());
            } else if (b.this.htb != null) {
                b.this.htb.d(b.this.cbV().hDq.Fp(), false);
            }
        }
    };
    private CustomMessageListener huA = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    b.this.huc = true;
                    b.this.hud = (ax) data;
                    b.this.b(b.this.hud);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                } else if (data instanceof String) {
                    b.this.HH((String) data);
                }
            }
        }
    };
    private CustomMessageListener huB = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.cbV().hDq.Fp().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.cbV().hDq.Fp().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.cbV().hDq.Fp().aJD.userId);
                    if (b.this.htc == null) {
                        b.this.htc = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    b.this.htc.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.htc.a(b.this.huC);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b huC = new e.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void Pk() {
            if (b.this.cbV().hDq.Fp() != null && b.this.cbV().hDq.Fp().aJZ != null) {
                b.this.cbV().hDq.Fp().aJZ.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener huD = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (b.this.htz != null) {
                    b.this.htz.I(bVar);
                }
                if (b.this.htO != null) {
                    b.this.htO.N(bVar);
                }
                if (b.this.hta != null) {
                    b.this.hta.l(bVar);
                }
                if (b.this.htK != null) {
                    b.this.htK.l(bVar);
                }
                b.this.t(bVar);
            }
        }
    };
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
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
    CustomMessageListener huE = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.huf = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.htv != null) {
                b.this.htv.FD();
            }
        }
    };
    HttpMessageListener gZw = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bky) != null && b.this.hty != null && b.this.cbV() != null && b.this.cbV().hDq != null) {
                int[] iArr = new int[2];
                b.this.htX.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.hty.a(b.this.htX, layoutParams, aVar, b.this.cbV().hDq.Fp());
                com.baidu.live.q.a.aD(aVar.liveId + "", "guard_club_join");
                com.baidu.live.p.a.c(b.this.cbV().hDq.Fp().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gZt = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.cbV() != null && b.this.cbV().hDq != null && b.this.cbV().hDq.Fp() != null && guardClubInfoHttpResponseMessage.bky != null) {
                    if (guardClubInfoHttpResponseMessage.bky.anchorId == b.this.cbV().hDq.Fp().aJD.userId) {
                        b.this.hue = guardClubInfoHttpResponseMessage;
                        if (b.this.hue.bkD && com.baidu.live.guardclub.e.IV() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.IV().aU(b.this.cbV().hDq.Fp().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener huF = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof ci) {
                b.this.a((ci) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener huG = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.H(b.this.cbV().hDq.Fp());
        }
    };
    private CustomMessageListener huH = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.htG != null) {
                b.this.htG.Jr();
            }
        }
    };
    private CustomMessageListener huI = new CustomMessageListener(2913261) { // from class: com.baidu.tieba.ala.liveroom.c.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.htH != null) {
                    b.this.htH.hy(str);
                }
            }
        }
    };
    public CustomMessageListener bsy = new CustomMessageListener(2913272) { // from class: com.baidu.tieba.ala.liveroom.c.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.nR(booleanValue);
                b.this.nL(booleanValue);
            }
        }
    };
    public CustomMessageListener huJ = new CustomMessageListener(2913281) { // from class: com.baidu.tieba.ala.liveroom.c.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hto != null && b.this.htu != null) {
                if (b.this.hto.getTextView() != null) {
                    BdUtilHelper.showSoftKeyPad(b.this.getActivity(), b.this.hto.getTextView());
                }
                b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hto.Kh().setFromDailyTask(true, b.this.cbV().hDq.Fp().aKo.aPs);
                        b.this.hto.Kh().a(null, z.Fh().Fj(), b.this.cbV().hDq.Fp().mLiveInfo);
                    }
                }, 300L);
            }
        }
    };
    public CustomMessageListener huK = new CustomMessageListener(2913289) { // from class: com.baidu.tieba.ala.liveroom.c.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hsY != null) {
                b.this.hsY.cjX();
            }
        }
    };
    private CustomMessageListener huL = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.htC != null) {
                    ((com.baidu.tieba.ala.liveroom.p.a) b.this.htC).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener huM = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.c.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.cbV().hDq.Fp(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hfH = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.c.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.bif == null) {
                b.this.bif = new com.baidu.live.an.a(b.this.cbV().pageContext.getPageActivity());
            }
            b.this.bif.a((com.baidu.live.an.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener huN = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.cbV().pageContext.getPageActivity() != null) {
                com.baidu.live.p.a.r(b.this.cbV().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener huO = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.34
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.cbG();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.y.b huP = new com.baidu.live.y.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.38
        @Override // com.baidu.live.y.b
        public boolean PH() {
            if (b.this.cbV().hDr != null) {
                if (!b.this.cbV().hDr.clz()) {
                    b.this.htN.close();
                    return false;
                } else if (b.this.cbV().hDr.getScrollX() != 0) {
                    b.this.htN.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void HH(String str);

    protected abstract void a(ax axVar);

    protected abstract void b(ax axVar);

    protected abstract void caG();

    protected abstract View caQ();

    public abstract boolean caR();

    protected abstract boolean caS();

    protected abstract ViewGroup caT();

    protected abstract void g(com.baidu.live.data.a aVar);

    public abstract boolean isVertical();

    protected abstract void nL(boolean z);

    public void a(bw bwVar) {
        this.htP = bwVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.htX = (RelativeLayout) cbV().hDr.findViewById(a.f.ala_live_header_view);
        this.htY = (RelativeLayout) cbV().hDr.findViewById(a.f.ala_live_footer_view);
        Gg();
        registerListener();
    }

    public void caY() {
    }

    private void Gg() {
        if (this.htb == null) {
            this.htb = new com.baidu.tieba.ala.liveroom.share.c(cbV().pageContext);
        }
        this.htj = new com.baidu.tieba.ala.liveroom.v.a(cbV().pageContext, this);
        this.htf = new com.baidu.tieba.ala.liveroom.a.b(cbV().pageContext, false);
        this.htg = new com.baidu.tieba.ala.liveroom.praise.a(cbV().pageContext);
        this.hth = new com.baidu.tieba.ala.liveroom.sticker.a(cbV().pageContext);
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
                this.hti = new com.baidu.tieba.ala.liveroom.guide.d(cbV().pageContext);
            }
        }
        this.hts = new com.baidu.tieba.ala.liveroom.tippop.a(cbV().pageContext, this);
        cbb();
        cbe();
        cbf();
        cbk();
        cba();
        caZ();
        cbl();
    }

    private void caZ() {
        CustomResponsedMessage runTask;
        if (this.htl == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ag.d.class, cbV().pageContext)) != null && runTask.getData() != null) {
            this.htl = (com.baidu.live.ag.d) runTask.getData();
        }
    }

    private void cba() {
        CustomResponsedMessage runTask;
        if (this.htz == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.m.b.class, cbV().pageContext)) != null && runTask.getData() != null) {
            this.htz = (com.baidu.live.m.b) runTask.getData();
            this.htz.c(cbV().pageContext);
            this.htz.Mt().setTargetView(this.htY);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.htR == null) {
            this.htR = new com.baidu.tieba.ala.liveroom.e.a(cbV().pageContext);
            this.htR.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.htR.a(cbV().hDq.Fp(), alaLastLiveroomInfo);
        this.htR.aF(this.htY);
    }

    private void cbb() {
        this.htn = new m();
    }

    public void nO(boolean z) {
        this.hua = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbc() {
        CustomResponsedMessage runTask;
        if (this.hta == null && (runTask = MessageManager.getInstance().runTask(2913273, com.baidu.live.j.a.class, cbV().pageContext)) != null) {
            this.hta = (com.baidu.live.j.a) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbd() {
        com.baidu.live.data.ab Fp = cbV().hDq.Fp();
        boolean z = com.baidu.live.ae.a.Qm().bwx.aOz;
        if (Fp.mLiveInfo != null && Fp.mLiveInfo.mAlaLiveSwitchData != null && Fp.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Fp.aKp ? z : false;
        if (z2) {
            if (this.hsZ == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, cbV().pageContext);
                if (runTask != null) {
                    this.hsZ = (com.baidu.live.j.b) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.hsZ != null) {
                this.hsZ.dv(1);
                View view = this.hsZ.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(cbV().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(cbV().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    cp(view);
                    this.htX.addView(view, layoutParams);
                    if (z2) {
                        this.hsZ.a(Fp);
                    }
                }
            }
        }
    }

    private void cbe() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.d.class, cbV().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.htu = (com.baidu.live.view.input.d) runTask.getData();
            this.htu.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.view.input.d.a
                public void XV() {
                    b.this.vq(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public void XW() {
                    b.this.dH(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Kk() {
                    return b.this.Ic();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean KZ() {
                    return b.this.cbi();
                }

                @Override // com.baidu.live.view.input.d.a
                public int Kq() {
                    return b.this.cbj();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Kr() {
                    com.baidu.live.data.ab Fp = b.this.cbV().hDq.Fp();
                    if (Fp == null || Fp.aJZ == null) {
                        return false;
                    }
                    return Fp.aJZ.isMysteriousMan;
                }
            });
        }
    }

    private void cbf() {
        this.htv = new com.baidu.tieba.ala.liveroom.l.b(this.hsX.pageContext);
        this.htv.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.26
            @Override // com.baidu.tieba.ala.liveroom.l.b.a
            public boolean cbZ() {
                return b.this.caS();
            }

            @Override // com.baidu.tieba.ala.liveroom.l.b.a
            public void onClose() {
                if (b.this.btl != null) {
                    b.this.btl.cC(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbg() {
        if (this.htT == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.htT = (com.baidu.live.guess.a) runTask.getData();
                this.htT.p(getActivity());
            } else {
                return;
            }
        }
        if (this.htT != null) {
            this.htT.dw(0);
            this.htT.a(cbV().hDq.Fp(), caT());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nP(boolean z) {
        if (this.htt != null) {
            this.htt.or(z);
        }
        if (this.htv != null) {
            this.htv.or(z);
        }
        hul = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbh() {
        return hul;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbi() {
        com.baidu.live.data.ab Fp;
        if (cbV() == null || cbV().hDq == null || (Fp = cbV().hDq.Fp()) == null || Fp.aJZ == null) {
            return false;
        }
        String str = Fp.aJZ.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbj() {
        com.baidu.live.data.ab Fp;
        if (cbV() != null && cbV().hDq != null && (Fp = cbV().hDq.Fp()) != null && !ListUtils.isEmpty(Fp.aKk)) {
            for (AlaLiveMarkData alaLiveMarkData : Fp.aKk) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cbk() {
        if (this.hty == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, cbV().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hty = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.hty.setOtherParams(Lr());
    }

    private void cbl() {
        if (this.bif == null) {
            this.bif = new com.baidu.live.an.a(cbV().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.huq == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.huq = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.hus);
            this.huq.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.huq);
        }
        if (this.hur == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.hur = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.hut);
            this.hur.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hur);
        }
        MessageManager.getInstance().registerListener(this.huA);
        MessageManager.getInstance().registerListener(this.huB);
        MessageManager.getInstance().registerListener(this.huD);
        MessageManager.getInstance().registerListener(this.hux);
        MessageManager.getInstance().registerListener(this.huy);
        MessageManager.getInstance().registerListener(this.gPc);
        MessageManager.getInstance().registerListener(this.huz);
        MessageManager.getInstance().registerListener(this.gPp);
        MessageManager.getInstance().registerListener(this.huE);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gZw);
        MessageManager.getInstance().registerListener(this.gZt);
        MessageManager.getInstance().registerListener(this.bzm);
        MessageManager.getInstance().registerListener(this.huF);
        MessageManager.getInstance().registerListener(this.huG);
        MessageManager.getInstance().registerListener(this.huH);
        MessageManager.getInstance().registerListener(this.huL);
        MessageManager.getInstance().registerListener(this.huM);
        MessageManager.getInstance().registerListener(this.huu);
        MessageManager.getInstance().registerListener(this.huv);
        MessageManager.getInstance().registerListener(this.huw);
        MessageManager.getInstance().registerListener(this.hfH);
        MessageManager.getInstance().registerListener(this.huN);
        MessageManager.getInstance().registerListener(this.huI);
        MessageManager.getInstance().registerListener(this.bsy);
        MessageManager.getInstance().registerListener(this.huJ);
        MessageManager.getInstance().registerListener(this.huK);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Ic() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(cbV().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HI(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cbV().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(cbV().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.27
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qm().bwx.aNS;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = cbV().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = cbV().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.cbV().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(cbV().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbm() {
        if (this.hto != null && this.htu != null) {
            this.hto.Kh().a(this.htu.Po(), z.Fh().Fj(), cbV().hDq.Fp().mLiveInfo);
            nP(true);
            if (this.htE == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, af.class, cbV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.htE = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.htE.gC("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbn() {
        if (this.hto != null && this.htu != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913304, this.htu.Po()));
            this.hto.Ki().cw(false);
            if (com.baidu.live.ae.a.Qm().bwx != null) {
                this.aOi = com.baidu.live.ae.a.Qm().bwx.aOi;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.29
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cbo();
                }
            }, this.aOi * 1000);
        }
    }

    protected void cbo() {
        this.hto.Ki().g(cbV().hDq.Fp());
        if (com.baidu.live.ae.a.Qm().bwx != null) {
            this.aOg = com.baidu.live.ae.a.Qm().bwx.aOg && !this.hto.Ki().Mp();
        }
        if (this.aOg) {
            if (this.mOrientation != 2) {
                this.hto.Ki().cw(true);
            } else {
                this.hto.Ki().cw(false);
            }
            this.hto.Ki().setClicked(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds108);
            layoutParams.leftMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.rightMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            if (this.htC != null) {
                layoutParams.addRule(3, this.htC.FC().getId());
            }
            this.hto.a(this.htY, cbV().hDq.Fp(), this.htu.Po(), layoutParams);
            return;
        }
        this.hto.Ki().cx(false);
        this.hto.Ki().cw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbp() {
        if (this.hto != null) {
            this.hto.Kh().hide();
            nP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(int i, int i2, int i3) {
        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJD != null && cbV().hDq.Fp().mLiveInfo != null) {
            a(cbV().hDq.Fp(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.d.k.class) != null && Ic()) {
            if (abVar == null) {
                abVar = cbV().hDq.Fp();
            }
            String valueOf = String.valueOf(abVar.aJD.userId);
            String str2 = abVar.aJD.userName;
            String valueOf2 = String.valueOf(abVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(abVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(abVar.mLiveInfo.feed_id);
            int i6 = abVar.aJZ.isBlock;
            String Fy = ac.Fy();
            String str3 = abVar.mLiveInfo.appId;
            boolean z2 = abVar.aJZ.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (abVar.mLiveInfo.live_type == 1 && abVar.mLiveInfo.screen_direction == 1 && com.baidu.live.ae.a.Qm().bwx.aMT) {
                z3 = true;
            }
            int i7 = -1;
            if (abVar.aJZ == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(abVar.aJZ.userId);
                boolean z4 = abVar.aJZ.isNewUser;
                i7 = abVar.aJZ.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.hue != null && this.hue.bky != null && this.hue.bky.anchorId == abVar.aJD.userId) {
                z5 = this.hue.bkD;
            }
            com.baidu.live.d.k kVar = new com.baidu.live.d.k(cbV().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Fy, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bi(abVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.fo(str);
            kVar.bg(z);
            if (com.baidu.tieba.ala.liveroom.u.b.ckK().bwG != null) {
                kVar.bh(com.baidu.tieba.ala.liveroom.u.b.ckK().bwG.aLC != 1);
            }
            bn IY = g.IW().IY();
            if (IY == null || IY.aQJ <= 0) {
                i5 = 1000;
            } else {
                i5 = IY.aQJ;
            }
            kVar.cq(i5);
            boolean z6 = false;
            if (abVar != null && abVar.aJZ != null) {
                String str4 = abVar.aJZ.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.bj(z6);
            boolean z7 = true;
            bv bvVar = com.baidu.live.ae.a.Qm().bCs;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bvVar != null && bvVar.aRp != null && (!bvVar.aRp.aUa || !bvVar.aRp.aUb)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.bk(z7);
            if (abVar != null && abVar.aKc != null) {
                kVar.fn(abVar.aKc.toJsonString());
            }
            if (cbV() != null && cbV().hDq != null) {
                kVar.fp(cbV().hDq.cjQ());
            }
            if (!this.huj) {
                this.huk = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbq() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        dH(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ci ciVar) {
        if (ciVar != null && Ic()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(cbV().pageContext.getPageActivity(), ciVar.aSq, ciVar.liveId, ciVar.aLm)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qm().bwx != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(cbV().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qm().bwx.aOA, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, NobleDetailInfo nobleDetailInfo) {
        if (Ic() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (abVar != null) {
                if (abVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
                if (abVar.aJD != null) {
                    hashMap.put("anchor_id", Long.valueOf(abVar.aJD.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", q.Fy());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(cbV().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbr() {
        if (this.htu != null) {
            this.htu.d(this.hsX.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbs() {
        com.baidu.live.data.ab Fp = cbV().hDq.Fp();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fp == null || Fp.mLiveInfo == null) ? "" : Fp.mLiveInfo.feed_id, Lr());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HJ(String str) {
        if (this.htu != null) {
            this.htu.gF(str);
        }
    }

    private void cbt() {
        if ("home_rec_play".equals(cbV().fromType) || "frs_play".equals(cbV().fromType) || "frs_live_play".equals(cbV().fromType) || "person_play".equals(cbV().fromType) || "search".equals(cbV().fromType) || "person_attention".equals(cbV().fromType)) {
            com.baidu.live.c.xe().aV(true);
        } else {
            com.baidu.live.c.xe().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nQ(boolean z) {
        View EL;
        if (this.htq == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aWN = false;
            fVar.context = cbV().pageContext.getPageActivity();
            fVar.aWX = z;
            fVar.fromType = cbV().fromType;
            fVar.aWY = isVertical() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.htq = (ad) runTask.getData();
            }
        }
        if (this.htq != null && (EL = this.htq.EL()) != null && this.hsX.hDr.indexOfChild(EL) < 0) {
            this.hsX.hDr.addView(EL, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbu() {
        View FC;
        if (this.htC == null) {
            ak akVar = new ak();
            akVar.aWN = false;
            akVar.pageContext = cbV().pageContext;
            akVar.fromType = cbV().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.htC = (ag) runTask.getData();
            }
        }
        if (this.htC != null && (FC = this.htC.FC()) != null && cbV().hDr.indexOfChild(FC) < 0) {
            if (FC.getParent() instanceof ViewGroup) {
                ((ViewGroup) FC.getParent()).removeView(FC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hto != null && this.hto.Ki().Mo()) {
                layoutParams.bottomMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hto.Ki().getView().getId());
            } else {
                layoutParams.bottomMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            cbV().hDr.addView(FC, layoutParams);
        }
    }

    protected void nR(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.htC != null) {
            View FC = this.htC.FC();
            if (FC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) FC.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if (this.hto != null && z) {
                layoutParams.bottomMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds190);
                layoutParams.addRule(2, this.hto.Ki().getView().getId());
            } else {
                layoutParams.bottomMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            FC.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbv() {
        View Fo;
        if (this.htr == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aWN = false;
            aVar.context = cbV().pageContext.getPageActivity();
            aVar.fromType = cbV().fromType;
            aVar.aWO = cbV().hDw;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.htr = (ab) runTask.getData();
            }
        }
        if (this.htr != null && (Fo = this.htr.Fo()) != null && this.htX != null && this.htX.indexOfChild(Fo) < 0) {
            if (Fo.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fo.getParent()).removeView(Fo);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.htX.addView(Fo, this.htX.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbw() {
        CustomResponsedMessage runTask;
        if (this.htp == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, cbV().pageContext)) != null) {
            this.htp = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.htp != null) {
            this.htp.setOtherParams(this.otherParams);
            this.htp.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.c.b.30
                @Override // com.baidu.live.im.b.a.InterfaceC0185a
                public void KP() {
                    b.this.cbG();
                }
            });
            this.htp.a(cbV().hDq.Fp(), false);
            View zS = this.htp.zS();
            if (zS != null && this.htY.indexOfChild(zS) < 0) {
                Resources resources = cbV().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbV().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.htY.addView(zS, layoutParams);
            }
        }
    }

    private void cbx() {
        if (this.htm == null) {
            this.htm = new com.baidu.tieba.ala.liveroom.g.a(cbV().pageContext);
        }
        if (this.hud != null) {
            this.htm.HP(this.hud.user_id);
        }
        this.htm.aF(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nS(boolean z) {
        if (cbV() != null && !z) {
            if (this.htG == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, cbV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.htG = (com.baidu.live.l.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.htG.d(this.htX, cbO());
            if (cbV().hDq != null) {
                this.htG.a(cbV().hDq.Fp());
            }
            this.htG.setCanVisible(true);
            this.htG.ch(true);
            this.htG.a(cbV().hDq.bTX());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cby() {
        if (cbV() != null) {
            if (this.htH == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, cbV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.htH = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (cbV().hDq != null) {
                this.htH.b(cbV().hDq.Fp(), this.otherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cap() {
        if (cbV() != null) {
            if (this.hsp == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsp = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsp.setIsHost(false);
            this.hsp.a(caT(), cbV().hDq.Fp().aKC);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbz() {
        if (cbV() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.htI == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, cbV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.htI = (com.baidu.live.t.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.htI.setIsHost(false);
            this.htI.a(this.hsX.hDr, cbV().hDq.Fp());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbA() {
        if (this.htf != null && cbV() != null && cbV().hDq != null) {
            this.htf.d(this.htX, cbV().hDq.Fp());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbB() {
        if (cbV() != null) {
            if (this.htK == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, cbV().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.htK = (com.baidu.live.k.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.hsX.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.htK.a(this.htX, cbV().hDq.Fp(), layoutParams, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbC() {
        if (cbV() != null) {
            if (this.htx == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913264, com.baidu.live.w.b.class, cbV().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.htx = (com.baidu.live.w.b) runTask.getData();
                } else {
                    return;
                }
            }
            this.htx.a(cbV().hDq.Fp(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbD() {
        if (cbV() != null) {
            if (this.htM == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913278, com.baidu.live.g.a.class, cbV().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.htM = (com.baidu.live.g.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.htM.a(caT(), cbV().hDq.Fp());
        }
    }

    protected void cbE() {
        if (this.htL == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.c.class, cbV().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.htL = (com.baidu.live.t.c) runTask.getData();
            } else {
                return;
            }
        }
        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJD != null && cbV().hDq.Fp().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(cbV().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(cbV().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.htL.b(this.htX, layoutParams, cbV().hDq.Fp());
        }
    }

    private void cbF() {
        if (this.htA == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, cbV().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.htA = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJD != null && cbV().hDq.Fp().mLiveInfo != null) {
            this.htA.setHost(false);
            this.htA.setOtherParams(Lr());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.htA.a(this.htX, layoutParams, cbV().hDq.Fp());
            this.htA.a(new l() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
                @Override // com.baidu.live.guardclub.l
                public void Jb() {
                    b.this.cbW();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x03f7, code lost:
        cbV().hDq.cjA();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x06fb, code lost:
        HE(r3.giftId);
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
        if (this.hsp != null) {
            this.hsp.ab(jSONObject2);
        }
        if (this.hsY == null || !this.hsY.ab(jSONObject2)) {
            if (bVar.getMsgType() == 12 || bVar.getMsgType() == 13) {
                if (jSONObject2 != null) {
                    String optString2 = jSONObject2.optString("content_type");
                    if ("live_on_private".equals(optString2)) {
                        boolean z = jSONObject2.optInt("on_private", 0) == 1;
                        if (this.btl != null) {
                            this.btl.cE(z);
                        }
                        int optInt = jSONObject2.optInt("on_audio_private", -1);
                        if (optInt >= 0) {
                            vs(optInt);
                        }
                    } else if ("live_admin".equals(optString2)) {
                        long optLong = jSONObject2.optLong("user_id");
                        int optInt2 = jSONObject2.optInt("opt_type");
                        if (optInt2 == 1) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                cbV().hDq.Fp().aJZ.isAdmin = 1;
                                cbV().hDq.cjA();
                            }
                        } else if (optInt2 == 2) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                cbV().hDq.Fp().aJZ.isAdmin = 0;
                                cbV().hDq.cjA();
                            }
                        } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbV().hDq.Fp().aJZ.isAdmin = 0;
                            cbV().hDq.cjA();
                        }
                    } else if ("task".equals(optString2)) {
                        dW(jSONObject2);
                    } else if ("live_net_status".equals(optString2)) {
                        int optInt3 = jSONObject2.optInt(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK);
                        if (this.hts != null && !cbV().hDv) {
                            String str = null;
                            if (optInt3 == 0) {
                                str = cbV().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                            } else if (optInt3 == 1) {
                                str = cbV().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                            } else if (optInt3 == 2) {
                                str = cbV().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                            }
                            if (str != null) {
                                if (bVQ()) {
                                    BdUtilHelper.getCustomToast().showToast(str, 1);
                                } else {
                                    this.hts.a(cbV().hDp.getLiveContainerView(), str, 1);
                                }
                            }
                        }
                    } else if ("close_live".equals(optString2)) {
                        final int optInt4 = jSONObject2.optInt("close_type");
                        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.32
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.btl != null) {
                                    b.this.btl.cD(optInt4 == 2);
                                }
                            }
                        });
                    } else if ("first_recharge_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                    } else if ("privilege_award_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.s.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                    } else if ("live_talk_ban".equals(optString2)) {
                        long optLong2 = jSONObject2.optLong("user_id");
                        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJZ != null && cbV().hDq.Fp().aJZ.userId == optLong2) {
                            cbV().hDq.Fp().aJZ.isBlock = 1;
                            caG();
                        }
                    } else if ("live_talk_remove_ban".equals(optString2)) {
                        long optLong3 = jSONObject2.optLong("user_id");
                        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJZ != null && cbV().hDq.Fp().aJZ.userId == optLong3) {
                            cbV().hDq.Fp().aJZ.isBlock = 0;
                            caG();
                        }
                    } else if ("live_talk_admin_ban".equals(optString2)) {
                        long optLong4 = jSONObject2.optLong("user_id");
                        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJZ != null && cbV().hDq.Fp().aJZ.userId == optLong4) {
                            cbV().hDq.Fp().aJZ.isUegBlock = 1;
                            caG();
                        }
                    } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                        long optLong5 = jSONObject2.optLong("user_id");
                        if (cbV().hDq.Fp() != null && cbV().hDq.Fp().aJZ != null && cbV().hDq.Fp().aJZ.userId == optLong5) {
                            cbV().hDq.Fp().aJZ.isUegBlock = 0;
                            caG();
                        }
                    } else if ("need_update_live_mark_info".equals(optString2)) {
                        if (cbV() != null && cbV().hDq != null && cbV().hDq.Fp() != null && cbV().hDq.Fp().aJZ != null) {
                            long j3 = cbV().hDq.Fp().aJZ.userId;
                            if (j3 == jSONObject2.optLong("user_id")) {
                                cbV().hDq.cjA();
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
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, cbV().hDq.Fp().aJZ));
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
                        com.baidu.live.data.a Lc = bVar.Lc();
                        if (Lc != null && ac.gx(str3)) {
                            ac.d(str3, 1L, "", "", Lc.userId, Lc.portrait, Lc.userName, "", "", false, "", "", "", false, false, true, -1L);
                        }
                    } else if ("challenge_mvp".equals(optString2)) {
                        if (jSONObject2 != null) {
                            bh bhVar = new bh();
                            bhVar.parseJson(jSONObject2);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bhVar));
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
                        if (this.htS != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("source", "im_mix_room_close");
                                jSONObject4.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                                this.htS.y("mix_room_close", jSONObject4);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else if ("mysterious_man_activate".equals(optString2)) {
                        HK(jSONObject2.optString("url"));
                    } else if ("mysterious_man_expired_remind".equals(optString2)) {
                        HL(jSONObject2.optString("text"));
                    }
                }
            } else if (bVar.getMsgType() == 125) {
                if (this.htj != null) {
                    this.htj.R(bVar);
                }
            } else if (bVar.getMsgType() == 24 && jSONObject2 != null) {
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject2);
                if (cbV().hDq != null && cbV().hDq.Fp() != null && cbV().hDq.Fp().aKP && TextUtils.equals(cVar.bpF, "luckybag")) {
                    cVar.beG = "";
                }
                com.baidu.live.data.a Lc2 = bVar.Lc();
                boolean z2 = false;
                long j5 = 0;
                String str4 = null;
                if (cbV().hDq == null || cbV().hDq.Fp() == null || cbV().hDq.Fp().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                } else {
                    j5 = cbV().hDq.Fp().mLiveInfo.live_id;
                    long j6 = cbV().hDq.Fp().mLiveInfo.group_id;
                    long j7 = cbV().hDq.Fp().aJD.userId;
                    str4 = cbV().hDq.Fp().mLiveInfo.appId;
                    z2 = cbV().hDq.Fp().mLiveInfo.isPubShow;
                    j = j7;
                    j2 = j6;
                }
                if (!cVar.bqR || cVar.isDynamic) {
                    if (!TextUtils.isEmpty(cVar.bqM) && !TextUtils.isEmpty(cVar.bqO)) {
                        if (jSONObject2.optInt("flag_show") == 1) {
                            ac.b(cVar, Lc2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, "", "", bVar.getMsgId());
                            try {
                                JSONArray jSONArray = new JSONArray(cVar.bqO);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.ae.f.QE().hB(jSONArray.getJSONObject(i2).optString(LogConfig.LOG_GIFT_ID))) {
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
                        bVar.setHost(z2 && cVar.bqP);
                        ac.b(cVar, Lc2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, (cVar.bqP || cVar.bqR || cVar.bqQ) ? false : true, true, "", "", bVar.getMsgId());
                        HE(cVar.giftId);
                    }
                    if (!UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT.equals(cVar.contentType)) {
                        com.baidu.tieba.ala.liveroom.f.c cVar2 = new com.baidu.tieba.ala.liveroom.f.c();
                        cVar2.bqN = cVar.bqN;
                        cVar2.liveId = j5;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.htS = dVar;
    }

    protected void HE(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbG() {
        if (cbH()) {
            BdUtilHelper.hideSoftKeyPad(cbV().pageContext.getPageActivity(), cbV().hDp.getLiveContainerView());
            caR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbH() {
        if (caQ() == null || caQ().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        cbV().hDr.setOnTouchListener(this.huO);
        cbP();
        cbQ();
        cbR();
        cbx();
        cbF();
        cbE();
        if (this.hth != null && cbV().hDq.Fp() != null && cbV().hDq.Fp().mLiveInfo != null) {
            this.hth.cI(cbV().hDq.Fp().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.htn != null) {
            this.htn.g(cbV().hDq.Fp());
        }
        if (this.htl != null) {
            this.htl.h(cbV().hDq.Fp());
        }
        if (this.htt != null) {
            this.htt.c(cbV().hDq.Fp(), Lr());
        }
        if (this.htu != null) {
            this.htu.b(cbV().hDq.Fp(), Lr());
        }
        if (this.htv != null) {
            this.htv.c(cbV().hDq.Fp(), Lr());
        }
        if (this.htU != null) {
            this.htU.h(cbV().hDq.Fp());
        }
        if (cbV().hDr != null) {
            cbV().hDr.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.35
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.cbH() && b.this.htg != null) {
                        b.this.htg.oJ(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.htg != null) {
                        b.this.htg.oJ(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nf() {
                    if (b.this.hup == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.hup) {
                        if (bVar.Nf()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            cbV().hDr.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.c.b.36
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.htE == null && (runTask = MessageManager.getInstance().runTask(2913165, af.class, cbV().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.htE = (af) runTask.getData();
        }
        if (this.mHandler != null && cbX()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.37
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cbX()) {
                        b.this.vs(b.this.cbV().hDq.Fp().mLiveInfo.isAudioOnPrivate);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbI() {
        if (this.htU == null && cbV() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, cbV().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.htU = (com.baidu.live.s.a) runTask.getData();
                this.htU.p(cbV().hDr);
                this.htU.b(cbV().hDq.Fp());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbJ() {
        com.baidu.live.data.ab Fp;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (cbV() != null && cbV().hDq != null && (Fp = cbV().hDq.Fp()) != null && Fp.mLiveInfo != null && !Fp.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) cbV().hDp) != null) {
            if (this.htN == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.y.a.class, cbV().pageContext)) != null && runTask.getData() != null) {
                this.htN = (com.baidu.live.y.a) runTask.getData();
            }
            if (this.htN != null) {
                this.htN.o(Fp);
                this.htN.a(this.huP);
                this.htN.a(viewGroup, this.htX);
                a(this.htN.PF());
                a(this.htN.PG());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.huo == null) {
            this.huo = new ArrayList();
        }
        if (!this.huo.contains(dVar)) {
            this.huo.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.huo != null && this.huo.contains(dVar)) {
            this.huo.remove(dVar);
        }
    }

    protected void cbK() {
        if (this.huo != null) {
            this.huo.clear();
            this.huo = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.huo == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.huo.iterator();
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
        if (this.hup == null) {
            this.hup = new ArrayList();
        }
        if (!this.hup.contains(bVar)) {
            this.hup.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hup != null && this.hup.contains(bVar)) {
            this.hup.remove(bVar);
        }
    }

    protected void cbL() {
        if (this.hup != null) {
            this.hup.clear();
            this.hup = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hup == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hup.iterator();
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
    public void cbM() {
        if (this.htF == null && this.htP != null && this.htP.aRC && cbV() != null && cbV().hDq != null && cbV().hDq.Fp() != null) {
            this.htF = new com.baidu.tieba.ala.liveroom.g.e(cbV().pageContext, this.htP);
            this.htF.K(cbV().hDq.Fp());
            if (this.htP.aRF == 1) {
                if (this.hto != null) {
                    this.hug = true;
                }
            } else if (this.htP.aRF == 2) {
                a(cbV().hDq.Fp(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbN() {
        CustomResponsedMessage runTask;
        if (cbV() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, cbV().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.htQ = (com.baidu.live.aa.a) runTask.getData();
            this.htQ.q(caT());
            if (cbV().hDq != null) {
                this.huh = this.htQ.p(cbV().hDq.Fp());
            }
            this.htQ.setCanVisible(!this.hub);
        }
    }

    private ViewGroup.LayoutParams cbO() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = cbV().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        cbV().hDp.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(cbV().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(cbV().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? cbV().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + cbV().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void cbP() {
        if (this.htg != null) {
            this.htg.aM(cbV().hDr);
        }
    }

    private void cbQ() {
        if (this.hth != null) {
            this.hth.aP(cbV().hDr);
        }
    }

    private void cbR() {
        if (this.htk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.htk = (com.baidu.live.ag.a) runTask.getData();
            }
            cbS();
        }
    }

    private void dW(JSONObject jSONObject) {
        if (this.htk != null) {
            if (this.htd != null) {
                this.htk.dc(this.htd.cfP() ? false : true);
            } else {
                this.htk.dc(true);
            }
            this.htk.ad(jSONObject);
        }
    }

    private void cbS() {
        if (this.htk != null && cbV().hDq.Fp() != null && cbV().hDq.Fp().aKo != null) {
            if (this.htd != null) {
                this.htk.dc(this.htd.cfP() ? false : true);
            } else {
                this.htk.dc(true);
            }
            this.htk.j(cbV().hDq.Fp());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(com.baidu.live.data.ab abVar) {
        if (abVar != null) {
            if (this.hth != null && abVar.mLiveInfo != null) {
                this.hth.cI(abVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.htz != null) {
                this.htz.i(abVar);
            }
            cbS();
            if (this.htm != null && abVar.aJD != null) {
                this.htm.HP(String.valueOf(abVar.aJD.userId));
            }
            if (this.hsZ != null) {
                this.hsZ.a(abVar);
            }
            if (this.htr != null && abVar.mLiveInfo != null) {
                this.htr.a(abVar.mLiveInfo, abVar.aJD);
            }
            if (this.htp != null) {
                this.htp.a(abVar);
            }
            if (this.htQ != null) {
                this.huh = this.htQ.p(abVar);
            }
            if (this.htG != null) {
                this.htG.a(abVar);
            }
            if (this.htI != null) {
                this.htI.a(abVar);
            }
            if (this.htM != null) {
                this.htM.a(abVar);
            }
            if (this.htH != null) {
                this.htH.a(abVar);
            }
            if (this.hsp != null) {
                this.hsp.a(abVar);
            }
            if (this.htK != null) {
                this.htK.a(abVar);
            }
            if (this.htJ != null) {
                this.htJ.a(abVar);
            }
            if (this.htL != null) {
                this.htL.a(abVar);
            }
            if (this.htT != null) {
                this.htT.b(abVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vs(int i) {
        if (!cbV().hDv) {
            if (this.htZ < 0 && i == 0) {
                this.htZ = i;
            } else if (this.htZ != i) {
                if (i == 1) {
                    if (!this.hts.wh(2)) {
                        String string = cbV().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(cbV().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.hts.a(cbV().hDp.getLiveContainerView(), string, 2, 5000);
                        }
                    }
                } else {
                    String string2 = cbV().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.hts.wi(2);
                    this.hts.wi(3);
                    if (bVQ()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.hts.a(cbV().hDp.getLiveContainerView(), string2, 3);
                    }
                }
                this.htZ = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (z) {
            cbT();
        }
        if (this.htz != null) {
            this.htz.Jc();
        }
        if (this.htl != null) {
            this.htl.Jc();
        }
        if (this.htj != null) {
            this.htj.clX();
        }
        if (this.htb != null) {
            this.htb.Au();
        }
        if (this.htd != null) {
            this.htd.onDestroy();
        }
        if (this.htk != null) {
            this.htk.onDestroy();
            this.htk = null;
        }
        if (this.htq != null) {
            View EL = this.htq.EL();
            if (EL != null && EL.getParent() != null) {
                ((ViewGroup) EL.getParent()).removeView(EL);
            }
            this.htq.onDestroy();
            this.htq = null;
        }
        if (this.htp != null) {
            this.htp.a((a.InterfaceC0185a) null);
            this.htp.zU();
        }
        if (this.hts != null) {
            this.hts.Au();
        }
        this.htZ = -1;
        if (this.htm != null) {
            this.htm.Au();
            this.htm.onDestroy();
        }
        if (this.hte != null) {
            this.hte.clV();
        }
        if (this.htf != null) {
            this.htf.cac();
            this.htf.FB();
        }
        if (this.htg != null) {
            this.htg.FB();
        }
        if (this.htn != null) {
            this.htn.FB();
        }
        if (this.htt != null) {
            this.htt.Jc();
        }
        if (this.htu != null) {
            this.htu.FB();
        }
        if (this.htv != null) {
            this.htv.onDestroy();
        }
        if (this.hty != null) {
            this.hty.onDestory();
        }
        if (this.htB != null) {
            this.htB.xk();
        }
        if (this.htA != null) {
            this.htA.xk();
        }
        if (this.htL != null) {
            this.htL.xk();
        }
        if (this.htF != null) {
            this.htF.onDestroy();
        }
        if (this.bif != null) {
            this.bif.FB();
        }
        if (this.htD != null) {
            this.htD.FB();
        }
        if (this.htE != null) {
            this.htE.FB();
        }
        if (this.htc != null) {
            this.htc.onDestory();
        }
        if (this.htQ != null) {
            this.htQ.FB();
        }
        if (this.htG != null) {
            this.htG.xk();
            this.htG.setCanVisible(false);
        }
        if (this.htI != null) {
            this.htI.xk();
        }
        if (this.htM != null) {
            this.htM.xk();
        }
        if (this.htH != null) {
            this.htH.xk();
        }
        if (this.hsp != null) {
            this.hsp.xk();
        }
        if (this.htJ != null) {
            this.htJ.xk();
        }
        if (this.htC != null) {
            this.htC.onDestroy();
        }
        if (this.htN != null) {
            this.htN.Au();
            b(this.htN.PF());
            b(this.htN.PG());
        }
        if (this.htO != null) {
            this.htO.xk();
        }
        if (this.htK != null) {
            this.htK.xk();
        }
        if (this.hto != null) {
            this.hto.Ki().xk();
        }
        if (this.htT != null) {
            this.htT.Jc();
        }
        if (this.htU != null) {
            this.htU.Jc();
            this.htU = null;
        }
        ShowUtil.windowCount = 0;
        cbK();
        cbL();
    }

    private void cbT() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = cbV().hDr.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = cbV().hDr.getChildAt(i);
            if (childAt != this.htX && childAt != this.htY) {
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
        if (this.htX != null) {
            this.htX.removeAllViews();
        }
        if (this.htY != null) {
            this.htY.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, com.baidu.live.data.ab abVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(com.baidu.live.data.ab abVar) {
        View zS;
        View EL;
        if (this.htq != null && (EL = this.htq.EL()) != null && EL.getParent() != null) {
            ((ViewGroup) EL.getParent()).removeView(EL);
        }
        if (this.htp != null && (zS = this.htp.zS()) != null && zS.getParent() != null) {
            ((ViewGroup) zS.getParent()).removeView(zS);
        }
        if (this.htd != null) {
            this.htd.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Nb() {
        if (this.hti == null || !this.hti.cfU()) {
            if (this.htd == null || !this.htd.aI(cbV().hDp.getLiveContainerView())) {
                if (this.htg != null) {
                    this.htg.bWv();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.htw != null && this.htw.cfD()) {
                    this.htw.cfM();
                    return false;
                } else if (this.htv == null || !this.htv.RI()) {
                    if (this.htV == null || !this.htV.RI()) {
                        if (this.htx == null || !this.htx.Pz()) {
                            cbt();
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

    @Override // com.baidu.live.w.a
    public void Py() {
        Na();
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        if (this.htz != null) {
            this.htz.release();
        }
        if (this.htl != null) {
            this.htl.onDestroy();
        }
        if (this.htk != null) {
            this.htk.onDestroy();
            this.htk = null;
        }
        if (this.htj != null) {
            this.htj.clX();
        }
        if (this.htq != null) {
            this.htq.onDestroy();
            this.htq = null;
        }
        if (this.htr != null) {
            this.htr.onDestroy();
            this.htr = null;
        }
        if (this.hts != null) {
            this.hts.onDestroy();
        }
        if (this.htb != null) {
            this.htb.onDestroy();
        }
        if (this.htC != null) {
            this.htC.onDestroy();
            this.htC = null;
        }
        if (this.htp != null) {
            this.htp.a((a.InterfaceC0185a) null);
            this.htp.release();
            this.htp = null;
        }
        if (this.htt != null) {
            this.htt.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.htt.release();
        }
        if (this.htu != null) {
            this.htu.a(null);
            this.htu.release();
        }
        if (this.htv != null) {
            this.htv.a((b.a) null);
            this.htv.onDestroy();
        }
        if (this.htA != null) {
            this.htA.onDestroy();
        }
        if (this.htB != null) {
            this.htB.onDestroy();
        }
        if (this.hty != null) {
            this.hty.onDestory();
        }
        if (this.htL != null) {
            this.htL.onDestroy();
        }
        if (this.htF != null) {
            this.htF.onDestroy();
        }
        if (this.bif != null) {
            this.bif.release();
        }
        if (this.htD != null) {
            this.htD.release();
        }
        if (this.htE != null) {
            this.htE.release();
        }
        if (this.htc != null) {
            this.htc.onDestory();
        }
        if (this.htQ != null) {
            this.htQ.release();
        }
        if (this.htG != null) {
            this.htG.onDestroy();
        }
        if (this.htI != null) {
            this.htI.onDestroy();
        }
        if (this.htM != null) {
            this.htM.onDestroy();
        }
        if (this.htH != null) {
            this.htH.onDestroy();
        }
        if (this.hsp != null) {
            this.hsp.onDestroy();
        }
        if (this.htJ != null) {
            this.htJ.onDestroy();
        }
        if (this.htg != null) {
            this.htg.FB();
        }
        if (this.htK != null) {
            this.htK.onDestroy();
        }
        if (this.htT != null) {
            this.htT.onDestroy();
        }
        if (this.htU != null) {
            this.htU.onDestory();
        }
        if (this.htx != null) {
            this.htx.onDestroy();
        }
        if (this.htN != null) {
            this.htN.onDestroy();
            b(this.htN.PF());
            b(this.htN.PG());
        }
        cbK();
        cbL();
        MessageManager.getInstance().unRegisterListener(this.huu);
        MessageManager.getInstance().unRegisterListener(this.huv);
        MessageManager.getInstance().unRegisterListener(this.huw);
        MessageManager.getInstance().unRegisterListener(this.huA);
        MessageManager.getInstance().unRegisterListener(this.huB);
        MessageManager.getInstance().unRegisterListener(this.huD);
        MessageManager.getInstance().unRegisterListener(this.hux);
        MessageManager.getInstance().unRegisterListener(this.huy);
        MessageManager.getInstance().unRegisterListener(this.gPc);
        MessageManager.getInstance().unRegisterListener(this.huz);
        MessageManager.getInstance().unRegisterListener(this.gPp);
        MessageManager.getInstance().unRegisterListener(this.huE);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gZw);
        MessageManager.getInstance().unRegisterListener(this.gZt);
        MessageManager.getInstance().unRegisterListener(this.bzm);
        MessageManager.getInstance().unRegisterListener(this.huF);
        MessageManager.getInstance().unRegisterListener(this.huG);
        MessageManager.getInstance().unRegisterListener(this.huH);
        MessageManager.getInstance().unRegisterListener(this.huL);
        MessageManager.getInstance().unRegisterListener(this.huM);
        MessageManager.getInstance().unRegisterListener(this.hfH);
        MessageManager.getInstance().unRegisterListener(this.huN);
        MessageManager.getInstance().unRegisterListener(this.huI);
        MessageManager.getInstance().unRegisterListener(this.bsy);
        MessageManager.getInstance().unRegisterListener(this.huJ);
        MessageManager.getInstance().unRegisterListener(this.huK);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.htt != null) {
            this.htt.oq(false);
        }
        if (this.htv != null) {
            this.htv.oq(false);
        }
        caR();
        if (this.htz != null) {
            this.htz.onPause();
        }
        if (this.bif != null) {
            this.bif.pause();
        }
        if (this.htC != null) {
            this.htC.onPause();
        }
        if (this.htK != null) {
            this.htK.onPause();
        }
        if (this.htM != null) {
            this.htM.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.huk = false;
        if (this.huc && this.hud != null) {
            a(this.hud);
            this.huc = false;
        }
        if (this.htt != null) {
            this.htt.oq(true);
        }
        if (this.htv != null) {
            this.htv.oq(true);
        }
        if (this.htz != null) {
            this.htz.onResume();
        }
        if (this.bif != null) {
            this.bif.resume();
        }
        if (this.htC != null) {
            this.htC.onResume();
        }
        if (this.htK != null) {
            this.htK.onResume();
        }
        if (this.htM != null) {
            this.htM.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        if (this.htM != null) {
            this.htM.onStop();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awr() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.htN != null && this.htN.isOpen()) {
            this.htN.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            awr();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    P(-1, -1, -1);
                    return;
                }
                return;
            }
            awr();
        } else if (i == 25034) {
            cbq();
        } else if (i == 25043) {
            if (i2 == -1) {
                cbW();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.p.a.K(cbV().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.p.a.K(cbV().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hub = z;
        if (this.htU != null) {
            this.htU.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cbU() {
        return (cbV().hDq.Fp() == null || cbV().hDq.Fp().mLiveInfo == null || cbV().hDq.Fp().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.htd != null) {
                this.htd.C(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.htv != null) {
            this.htv.cL(i3);
        }
        if (this.htc != null) {
            this.htc.bkr();
        }
        if (this.htN != null) {
            this.htN.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.hsX = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a cbV() {
        return this.hsX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbW() {
        String IX = g.IW().IX();
        if (!TextUtils.isEmpty(IX)) {
            try {
                P(-1, Integer.parseInt(IX), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                P(-1, -1, -1);
            }
        }
    }

    public boolean dG(int i) {
        if (1 == i) {
            if (caQ() != null) {
                caQ().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.hub) {
                return false;
            }
            return this.htd == null || !this.htd.cfP();
        } else if (3 == i) {
            if (cbV().hDr != null) {
                cbV().hDr.setEnabled(false);
                if (this.btl != null) {
                    this.btl.e(!cbV().hDt, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void vq(int i) {
        if (i == 7 || i == 11) {
            Log.d("bugbye", "bugbye");
        }
    }

    public void dH(int i) {
        if (3 == i) {
            cbV().hDr.setEnabled(true);
            if (this.btl != null) {
                this.btl.e(!cbV().hDt, true);
            }
            if (this.htk != null) {
                this.htk.dc(true);
            }
        } else if (2 == i && this.htj != null) {
            this.htj.oS(true);
        }
    }

    public String Lr() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.htp != null) {
            this.htp.setOtherParams(str);
        }
        if (this.htz != null) {
            this.htz.hp(str);
        }
    }

    private boolean bVQ() {
        return cbV().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gto = alaLastLiveroomInfo;
    }

    public void cp(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(cbV().pageContext.getPageActivity(), this.hui);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }

    private void HK(String str) {
        if (this.bif == null) {
            this.bif = new com.baidu.live.an.a(cbV().pageContext.getPageActivity());
        }
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        cVar.url = str;
        cVar.isFullScreen = true;
        this.bif.a(cVar);
    }

    private void HL(String str) {
        Activity pageActivity = cbV().pageContext.getPageActivity();
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(pageActivity);
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(true);
        cVar.setTitleVisible(false);
        cVar.Xx();
        cVar.o("", str, pageActivity.getString(a.h.sdk_know), "");
        cVar.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.39
            @Override // com.baidu.live.view.c.a
            public void Qd() {
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void Qe() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbX() {
        return (cbV().hDq.Fp() == null || cbV().hDq.Fp().mLiveInfo == null || cbV().hDq.Fp().mLiveInfo.isAudioOnPrivate != 1) ? false : true;
    }
}
