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
/* loaded from: classes11.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a, com.baidu.live.w.a {
    public static boolean hsC;
    protected com.baidu.live.an.a bgE;
    protected AlaLastLiveroomInfo grF;
    protected com.baidu.live.ad.a hqG;
    protected com.baidu.tieba.ala.liveroom.v.a hrA;
    protected com.baidu.live.ag.a hrB;
    protected com.baidu.live.ag.d hrC;
    private com.baidu.tieba.ala.liveroom.g.a hrD;
    private m hrE;
    k hrF;
    com.baidu.live.im.b.a hrG;
    protected ad hrH;
    protected ab hrI;
    protected com.baidu.tieba.ala.liveroom.tippop.a hrJ;
    private com.baidu.tieba.ala.liveroom.guideim.b hrK;
    protected com.baidu.live.view.input.d hrL;
    com.baidu.tieba.ala.liveroom.l.b hrM;
    protected com.baidu.tieba.ala.liveroom.guide.a hrN;
    protected com.baidu.live.w.b hrO;
    private com.baidu.live.guardclub.k hrP;
    protected com.baidu.live.m.b hrQ;
    protected h hrR;
    protected j hrS;
    protected ag hrT;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b hrU;
    private af hrV;
    protected e hrW;
    protected com.baidu.live.l.a hrX;
    protected com.baidu.live.v.a hrY;
    protected com.baidu.live.t.a hrZ;
    private com.baidu.tieba.ala.liveroom.data.a hro;
    protected com.baidu.tieba.ala.liveroom.operation.a hrp;
    protected com.baidu.live.j.b hrq;
    protected com.baidu.live.j.a hrr;
    protected com.baidu.tieba.ala.liveroom.share.c hrs;
    protected com.baidu.tieba.ala.liveroom.q.b hrt;
    protected com.baidu.tieba.ala.liveroom.guide.c hru;
    protected com.baidu.tieba.ala.liveroom.watermark.a hrv;
    protected com.baidu.tieba.ala.liveroom.a.b hrw;
    protected com.baidu.tieba.ala.liveroom.praise.a hrx;
    protected com.baidu.tieba.ala.liveroom.sticker.a hry;
    protected com.baidu.tieba.ala.liveroom.guide.d hrz;
    public boolean hsA;
    public boolean hsB;
    protected com.baidu.tieba.ala.liveroom.s.b hsD;
    protected com.baidu.tieba.ala.liveroom.i.e hsE;
    protected List<com.baidu.live.liveroom.g.d> hsF;
    protected List<com.baidu.live.liveroom.g.b> hsG;
    CustomMessageTask hsH;
    CustomMessageTask hsI;
    protected com.baidu.live.a.a hsa;
    protected com.baidu.live.k.a hsb;
    protected com.baidu.live.t.c hsc;
    protected com.baidu.live.g.a hsd;
    protected com.baidu.live.y.a hse;
    protected com.baidu.tieba.ala.liveroom.exclusive.b hsf;
    protected bw hsg;
    protected com.baidu.live.aa.a hsh;
    protected com.baidu.tieba.ala.liveroom.e.a hsi;
    protected com.baidu.tieba.ala.player.d hsj;
    protected com.baidu.live.guess.a hsk;
    protected com.baidu.live.s.a hsl;
    protected com.baidu.live.am.c hsm;
    protected com.baidu.live.c.a hsn;
    protected RelativeLayout hso;
    protected RelativeLayout hsp;
    protected boolean hsr;
    protected ax hsu;
    protected GuardClubInfoHttpResponseMessage hsv;
    boolean hsw;
    boolean hsx;
    boolean hsy;
    protected String otherParams;
    private int hsq = -1;
    protected boolean aMG = true;
    protected int aMI = 0;
    protected int mOrientation = 0;
    protected boolean hss = false;
    protected boolean hst = false;
    private int hsz = a.C0195a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> hsJ = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.c.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: cbS */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> hsK = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.c.b.12
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
    private CustomMessageListener hsL = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ao aoVar;
            if ((customResponsedMessage.getData() instanceof ao) && (aoVar = (ao) customResponsedMessage.getData()) != null) {
                b.this.a(aoVar.aJZ, aoVar.aJV, aoVar.aJW, aoVar.aJX, aoVar.aJY);
            }
        }
    };
    private CustomMessageListener hsM = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.vo(7);
        }
    };
    private CustomMessageListener hsN = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cbk();
        }
    };
    private CustomMessageListener hsO = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.cbP().hBH.Fm().aId.userId);
            com.baidu.live.view.a.Xo().a(valueOf, new f(b.this.cbP().hBH.Fm().aId.portrait, valueOf, true, b.this.cbP().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hsP = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.ab) && b.this.hrs != null) {
                b.this.hrs.d((com.baidu.live.data.ab) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bxM = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hrF != null) {
                b.this.hrF.g(z.Fe().Fg());
            }
        }
    };
    private CustomMessageListener hsQ = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.hro.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.Hz(str);
            }
        }
    };
    private CustomMessageListener gNt = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.cbP().pageContext.getPageActivity());
            } else if (b.this.hrs != null) {
                b.this.hrs.d(b.this.cbP().hBH.Fm(), false);
            }
        }
    };
    private CustomMessageListener hsR = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    b.this.hst = true;
                    b.this.hsu = (ax) data;
                    b.this.b(b.this.hsu);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                } else if (data instanceof String) {
                    b.this.Hy((String) data);
                }
            }
        }
    };
    private CustomMessageListener hsS = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.cbP().hBH.Fm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.cbP().hBH.Fm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.cbP().hBH.Fm().aId.userId);
                    if (b.this.hrt == null) {
                        b.this.hrt = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    b.this.hrt.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.hrt.a(b.this.hsT);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b hsT = new e.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void Ph() {
            if (b.this.cbP().hBH.Fm() != null && b.this.cbP().hBH.Fm().aIz != null) {
                b.this.cbP().hBH.Fm().aIz.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener hsU = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (b.this.hrQ != null) {
                    b.this.hrQ.I(bVar);
                }
                if (b.this.hsf != null) {
                    b.this.hsf.N(bVar);
                }
                if (b.this.hrr != null) {
                    b.this.hrr.l(bVar);
                }
                if (b.this.hsb != null) {
                    b.this.hsb.l(bVar);
                }
                b.this.t(bVar);
            }
        }
    };
    CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
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
    CustomMessageListener hsV = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.hsw = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hrM != null) {
                b.this.hrM.FA();
            }
        }
    };
    HttpMessageListener gXN = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).biY) != null && b.this.hrP != null && b.this.cbP() != null && b.this.cbP().hBH != null) {
                int[] iArr = new int[2];
                b.this.hso.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.hrP.a(b.this.hso, layoutParams, aVar, b.this.cbP().hBH.Fm());
                com.baidu.live.q.a.aD(aVar.liveId + "", "guard_club_join");
                com.baidu.live.p.a.c(b.this.cbP().hBH.Fm().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gXK = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.cbP() != null && b.this.cbP().hBH != null && b.this.cbP().hBH.Fm() != null && guardClubInfoHttpResponseMessage.biY != null) {
                    if (guardClubInfoHttpResponseMessage.biY.anchorId == b.this.cbP().hBH.Fm().aId.userId) {
                        b.this.hsv = guardClubInfoHttpResponseMessage;
                        if (b.this.hsv.bjd && com.baidu.live.guardclub.e.IS() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.IS().aU(b.this.cbP().hBH.Fm().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hsW = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof ci) {
                b.this.a((ci) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hsX = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.H(b.this.cbP().hBH.Fm());
        }
    };
    private CustomMessageListener hsY = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hrX != null) {
                b.this.hrX.Jo();
            }
        }
    };
    private CustomMessageListener hsZ = new CustomMessageListener(2913261) { // from class: com.baidu.tieba.ala.liveroom.c.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.hrY != null) {
                    b.this.hrY.hs(str);
                }
            }
        }
    };
    public CustomMessageListener bqY = new CustomMessageListener(2913272) { // from class: com.baidu.tieba.ala.liveroom.c.b.17
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
    public CustomMessageListener hta = new CustomMessageListener(2913281) { // from class: com.baidu.tieba.ala.liveroom.c.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hrF != null && b.this.hrL != null) {
                if (b.this.hrF.getTextView() != null) {
                    BdUtilHelper.showSoftKeyPad(b.this.getActivity(), b.this.hrF.getTextView());
                }
                b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hrF.Ke().setFromDailyTask(true, b.this.cbP().hBH.Fm().aIO.aNS);
                        b.this.hrF.Ke().a(null, z.Fe().Fg(), b.this.cbP().hBH.Fm().mLiveInfo);
                    }
                }, 300L);
            }
        }
    };
    public CustomMessageListener htb = new CustomMessageListener(2913289) { // from class: com.baidu.tieba.ala.liveroom.c.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hrp != null) {
                b.this.hrp.cjR();
            }
        }
    };
    private CustomMessageListener htc = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.hrT != null) {
                    ((com.baidu.tieba.ala.liveroom.p.a) b.this.hrT).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener htd = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.c.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.cbP().hBH.Fm(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hdY = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.c.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.bgE == null) {
                b.this.bgE = new com.baidu.live.an.a(b.this.cbP().pageContext.getPageActivity());
            }
            b.this.bgE.a((com.baidu.live.an.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener hte = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.cbP().pageContext.getPageActivity() != null) {
                com.baidu.live.p.a.r(b.this.cbP().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener htf = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.34
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.cbA();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.y.b htg = new com.baidu.live.y.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.38
        @Override // com.baidu.live.y.b
        public boolean PE() {
            if (b.this.cbP().hBI != null) {
                if (!b.this.cbP().hBI.clt()) {
                    b.this.hse.close();
                    return false;
                } else if (b.this.cbP().hBI.getScrollX() != 0) {
                    b.this.hse.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void Hy(String str);

    protected abstract void a(ax axVar);

    protected abstract void b(ax axVar);

    protected abstract void caA();

    protected abstract View caK();

    public abstract boolean caL();

    protected abstract boolean caM();

    protected abstract ViewGroup caN();

    protected abstract void g(com.baidu.live.data.a aVar);

    public abstract boolean isVertical();

    protected abstract void nL(boolean z);

    public void a(bw bwVar) {
        this.hsg = bwVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hso = (RelativeLayout) cbP().hBI.findViewById(a.f.ala_live_header_view);
        this.hsp = (RelativeLayout) cbP().hBI.findViewById(a.f.ala_live_footer_view);
        Gd();
        registerListener();
    }

    public void caS() {
    }

    private void Gd() {
        if (this.hrs == null) {
            this.hrs = new com.baidu.tieba.ala.liveroom.share.c(cbP().pageContext);
        }
        this.hrA = new com.baidu.tieba.ala.liveroom.v.a(cbP().pageContext, this);
        this.hrw = new com.baidu.tieba.ala.liveroom.a.b(cbP().pageContext, false);
        this.hrx = new com.baidu.tieba.ala.liveroom.praise.a(cbP().pageContext);
        this.hry = new com.baidu.tieba.ala.liveroom.sticker.a(cbP().pageContext);
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
                this.hrz = new com.baidu.tieba.ala.liveroom.guide.d(cbP().pageContext);
            }
        }
        this.hrJ = new com.baidu.tieba.ala.liveroom.tippop.a(cbP().pageContext, this);
        caV();
        caY();
        caZ();
        cbe();
        caU();
        caT();
        cbf();
    }

    private void caT() {
        CustomResponsedMessage runTask;
        if (this.hrC == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ag.d.class, cbP().pageContext)) != null && runTask.getData() != null) {
            this.hrC = (com.baidu.live.ag.d) runTask.getData();
        }
    }

    private void caU() {
        CustomResponsedMessage runTask;
        if (this.hrQ == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.m.b.class, cbP().pageContext)) != null && runTask.getData() != null) {
            this.hrQ = (com.baidu.live.m.b) runTask.getData();
            this.hrQ.c(cbP().pageContext);
            this.hrQ.Mq().setTargetView(this.hsp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.hsi == null) {
            this.hsi = new com.baidu.tieba.ala.liveroom.e.a(cbP().pageContext);
            this.hsi.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.hsi.a(cbP().hBH.Fm(), alaLastLiveroomInfo);
        this.hsi.aF(this.hsp);
    }

    private void caV() {
        this.hrE = new m();
    }

    public void nO(boolean z) {
        this.hsr = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caW() {
        CustomResponsedMessage runTask;
        if (this.hrr == null && (runTask = MessageManager.getInstance().runTask(2913273, com.baidu.live.j.a.class, cbP().pageContext)) != null) {
            this.hrr = (com.baidu.live.j.a) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caX() {
        com.baidu.live.data.ab Fm = cbP().hBH.Fm();
        boolean z = com.baidu.live.ae.a.Qj().buX.aMZ;
        if (Fm.mLiveInfo != null && Fm.mLiveInfo.mAlaLiveSwitchData != null && Fm.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Fm.aIP ? z : false;
        if (z2) {
            if (this.hrq == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, cbP().pageContext);
                if (runTask != null) {
                    this.hrq = (com.baidu.live.j.b) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.hrq != null) {
                this.hrq.du(1);
                View view = this.hrq.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(cbP().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(cbP().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    cp(view);
                    this.hso.addView(view, layoutParams);
                    if (z2) {
                        this.hrq.a(Fm);
                    }
                }
            }
        }
    }

    private void caY() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.d.class, cbP().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hrL = (com.baidu.live.view.input.d) runTask.getData();
            this.hrL.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
                @Override // com.baidu.live.view.input.d.a
                public void XS() {
                    b.this.vo(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public void XT() {
                    b.this.dG(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Kh() {
                    return b.this.HZ();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean KW() {
                    return b.this.cbc();
                }

                @Override // com.baidu.live.view.input.d.a
                public int Kn() {
                    return b.this.cbd();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Ko() {
                    com.baidu.live.data.ab Fm = b.this.cbP().hBH.Fm();
                    if (Fm == null || Fm.aIz == null) {
                        return false;
                    }
                    return Fm.aIz.isMysteriousMan;
                }
            });
        }
    }

    private void caZ() {
        this.hrM = new com.baidu.tieba.ala.liveroom.l.b(this.hro.pageContext);
        this.hrM.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.26
            @Override // com.baidu.tieba.ala.liveroom.l.b.a
            public boolean cbT() {
                return b.this.caM();
            }

            @Override // com.baidu.tieba.ala.liveroom.l.b.a
            public void onClose() {
                if (b.this.brL != null) {
                    b.this.brL.cC(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cba() {
        if (this.hsk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.hsk = (com.baidu.live.guess.a) runTask.getData();
                this.hsk.p(getActivity());
            } else {
                return;
            }
        }
        if (this.hsk != null) {
            this.hsk.dv(0);
            this.hsk.a(cbP().hBH.Fm(), caN());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nP(boolean z) {
        if (this.hrK != null) {
            this.hrK.or(z);
        }
        if (this.hrM != null) {
            this.hrM.or(z);
        }
        hsC = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbb() {
        return hsC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbc() {
        com.baidu.live.data.ab Fm;
        if (cbP() == null || cbP().hBH == null || (Fm = cbP().hBH.Fm()) == null || Fm.aIz == null) {
            return false;
        }
        String str = Fm.aIz.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbd() {
        com.baidu.live.data.ab Fm;
        if (cbP() != null && cbP().hBH != null && (Fm = cbP().hBH.Fm()) != null && !ListUtils.isEmpty(Fm.aIK)) {
            for (AlaLiveMarkData alaLiveMarkData : Fm.aIK) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cbe() {
        if (this.hrP == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, cbP().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrP = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.hrP.setOtherParams(Lo());
    }

    private void cbf() {
        if (this.bgE == null) {
            this.bgE = new com.baidu.live.an.a(cbP().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.hsH == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.hsH = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.hsJ);
            this.hsH.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hsH);
        }
        if (this.hsI == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.hsI = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.hsK);
            this.hsI.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hsI);
        }
        MessageManager.getInstance().registerListener(this.hsR);
        MessageManager.getInstance().registerListener(this.hsS);
        MessageManager.getInstance().registerListener(this.hsU);
        MessageManager.getInstance().registerListener(this.hsO);
        MessageManager.getInstance().registerListener(this.hsP);
        MessageManager.getInstance().registerListener(this.gNt);
        MessageManager.getInstance().registerListener(this.hsQ);
        MessageManager.getInstance().registerListener(this.gNG);
        MessageManager.getInstance().registerListener(this.hsV);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gXN);
        MessageManager.getInstance().registerListener(this.gXK);
        MessageManager.getInstance().registerListener(this.bxM);
        MessageManager.getInstance().registerListener(this.hsW);
        MessageManager.getInstance().registerListener(this.hsX);
        MessageManager.getInstance().registerListener(this.hsY);
        MessageManager.getInstance().registerListener(this.htc);
        MessageManager.getInstance().registerListener(this.htd);
        MessageManager.getInstance().registerListener(this.hsL);
        MessageManager.getInstance().registerListener(this.hsM);
        MessageManager.getInstance().registerListener(this.hsN);
        MessageManager.getInstance().registerListener(this.hdY);
        MessageManager.getInstance().registerListener(this.hte);
        MessageManager.getInstance().registerListener(this.hsZ);
        MessageManager.getInstance().registerListener(this.bqY);
        MessageManager.getInstance().registerListener(this.hta);
        MessageManager.getInstance().registerListener(this.htb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(cbP().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hz(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cbP().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(cbP().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.27
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qj().buX.aMs;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = cbP().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = cbP().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.cbP().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(cbP().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbg() {
        if (this.hrF != null && this.hrL != null) {
            this.hrF.Ke().a(this.hrL.Pl(), z.Fe().Fg(), cbP().hBH.Fm().mLiveInfo);
            nP(true);
            if (this.hrV == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, af.class, cbP().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrV = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrV.gw("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbh() {
        if (this.hrF != null && this.hrL != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913304, this.hrL.Pl()));
            this.hrF.Kf().cw(false);
            if (com.baidu.live.ae.a.Qj().buX != null) {
                this.aMI = com.baidu.live.ae.a.Qj().buX.aMI;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.29
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cbi();
                }
            }, this.aMI * 1000);
        }
    }

    protected void cbi() {
        this.hrF.Kf().g(cbP().hBH.Fm());
        if (com.baidu.live.ae.a.Qj().buX != null) {
            this.aMG = com.baidu.live.ae.a.Qj().buX.aMG && !this.hrF.Kf().Mm();
        }
        if (this.aMG) {
            if (this.mOrientation != 2) {
                this.hrF.Kf().cw(true);
            } else {
                this.hrF.Kf().cw(false);
            }
            this.hrF.Kf().setClicked(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds108);
            layoutParams.leftMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.rightMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            if (this.hrT != null) {
                layoutParams.addRule(3, this.hrT.Fz().getId());
            }
            this.hrF.a(this.hsp, cbP().hBH.Fm(), this.hrL.Pl(), layoutParams);
            return;
        }
        this.hrF.Kf().cx(false);
        this.hrF.Kf().cw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbj() {
        if (this.hrF != null) {
            this.hrF.Ke().hide();
            nP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(int i, int i2, int i3) {
        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aId != null && cbP().hBH.Fm().mLiveInfo != null) {
            a(cbP().hBH.Fm(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.d.k.class) != null && HZ()) {
            if (abVar == null) {
                abVar = cbP().hBH.Fm();
            }
            String valueOf = String.valueOf(abVar.aId.userId);
            String str2 = abVar.aId.userName;
            String valueOf2 = String.valueOf(abVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(abVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(abVar.mLiveInfo.feed_id);
            int i6 = abVar.aIz.isBlock;
            String Fv = ac.Fv();
            String str3 = abVar.mLiveInfo.appId;
            boolean z2 = abVar.aIz.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (abVar.mLiveInfo.live_type == 1 && abVar.mLiveInfo.screen_direction == 1 && com.baidu.live.ae.a.Qj().buX.aLt) {
                z3 = true;
            }
            int i7 = -1;
            if (abVar.aIz == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(abVar.aIz.userId);
                boolean z4 = abVar.aIz.isNewUser;
                i7 = abVar.aIz.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.hsv != null && this.hsv.biY != null && this.hsv.biY.anchorId == abVar.aId.userId) {
                z5 = this.hsv.bjd;
            }
            com.baidu.live.d.k kVar = new com.baidu.live.d.k(cbP().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Fv, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bi(abVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.fi(str);
            kVar.bg(z);
            if (com.baidu.tieba.ala.liveroom.u.b.ckE().bvg != null) {
                kVar.bh(com.baidu.tieba.ala.liveroom.u.b.ckE().bvg.aKc != 1);
            }
            bn IV = g.IT().IV();
            if (IV == null || IV.aPj <= 0) {
                i5 = 1000;
            } else {
                i5 = IV.aPj;
            }
            kVar.cp(i5);
            boolean z6 = false;
            if (abVar != null && abVar.aIz != null) {
                String str4 = abVar.aIz.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.bj(z6);
            boolean z7 = true;
            bv bvVar = com.baidu.live.ae.a.Qj().bAS;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bvVar != null && bvVar.aPP != null && (!bvVar.aPP.aSA || !bvVar.aPP.aSB)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.bk(z7);
            if (abVar != null && abVar.aIC != null) {
                kVar.fh(abVar.aIC.toJsonString());
            }
            if (cbP() != null && cbP().hBH != null) {
                kVar.fj(cbP().hBH.cjK());
            }
            if (!this.hsA) {
                this.hsB = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbk() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        dG(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ci ciVar) {
        if (ciVar != null && HZ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(cbP().pageContext.getPageActivity(), ciVar.aQQ, ciVar.liveId, ciVar.aJM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qj().buX != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(cbP().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qj().buX.aNa, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, NobleDetailInfo nobleDetailInfo) {
        if (HZ() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (abVar != null) {
                if (abVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(abVar.mLiveInfo.live_id));
                }
                if (abVar.aId != null) {
                    hashMap.put("anchor_id", Long.valueOf(abVar.aId.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", q.Fv());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(cbP().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbl() {
        if (this.hrL != null) {
            this.hrL.d(this.hro.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbm() {
        com.baidu.live.data.ab Fm = cbP().hBH.Fm();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fm == null || Fm.mLiveInfo == null) ? "" : Fm.mLiveInfo.feed_id, Lo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void HA(String str) {
        if (this.hrL != null) {
            this.hrL.gz(str);
        }
    }

    private void cbn() {
        if ("home_rec_play".equals(cbP().fromType) || "frs_play".equals(cbP().fromType) || "frs_live_play".equals(cbP().fromType) || "person_play".equals(cbP().fromType) || "search".equals(cbP().fromType) || "person_attention".equals(cbP().fromType)) {
            com.baidu.live.c.xb().aV(true);
        } else {
            com.baidu.live.c.xb().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nQ(boolean z) {
        View EI;
        if (this.hrH == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVn = false;
            fVar.context = cbP().pageContext.getPageActivity();
            fVar.aVx = z;
            fVar.fromType = cbP().fromType;
            fVar.aVy = isVertical() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrH = (ad) runTask.getData();
            }
        }
        if (this.hrH != null && (EI = this.hrH.EI()) != null && this.hro.hBI.indexOfChild(EI) < 0) {
            this.hro.hBI.addView(EI, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbo() {
        View Fz;
        if (this.hrT == null) {
            ak akVar = new ak();
            akVar.aVn = false;
            akVar.pageContext = cbP().pageContext;
            akVar.fromType = cbP().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrT = (ag) runTask.getData();
            }
        }
        if (this.hrT != null && (Fz = this.hrT.Fz()) != null && cbP().hBI.indexOfChild(Fz) < 0) {
            if (Fz.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fz.getParent()).removeView(Fz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hrF != null && this.hrF.Kf().Ml()) {
                layoutParams.bottomMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hrF.Kf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            cbP().hBI.addView(Fz, layoutParams);
        }
    }

    protected void nR(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.hrT != null) {
            View Fz = this.hrT.Fz();
            if (Fz.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) Fz.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if (this.hrF != null && z) {
                layoutParams.bottomMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds190);
                layoutParams.addRule(2, this.hrF.Kf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            Fz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbp() {
        View Fl;
        if (this.hrI == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVn = false;
            aVar.context = cbP().pageContext.getPageActivity();
            aVar.fromType = cbP().fromType;
            aVar.aVo = cbP().hBN;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrI = (ab) runTask.getData();
            }
        }
        if (this.hrI != null && (Fl = this.hrI.Fl()) != null && this.hso != null && this.hso.indexOfChild(Fl) < 0) {
            if (Fl.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fl.getParent()).removeView(Fl);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.hso.addView(Fl, this.hso.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbq() {
        CustomResponsedMessage runTask;
        if (this.hrG == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, cbP().pageContext)) != null) {
            this.hrG = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrG != null) {
            this.hrG.setOtherParams(this.otherParams);
            this.hrG.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.b.30
                @Override // com.baidu.live.im.b.a.InterfaceC0179a
                public void KM() {
                    b.this.cbA();
                }
            });
            this.hrG.a(cbP().hBH.Fm(), false);
            View zP = this.hrG.zP();
            if (zP != null && this.hsp.indexOfChild(zP) < 0) {
                Resources resources = cbP().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbP().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hsp.addView(zP, layoutParams);
            }
        }
    }

    private void cbr() {
        if (this.hrD == null) {
            this.hrD = new com.baidu.tieba.ala.liveroom.g.a(cbP().pageContext);
        }
        if (this.hsu != null) {
            this.hrD.HG(this.hsu.user_id);
        }
        this.hrD.aF(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nS(boolean z) {
        if (cbP() != null && !z) {
            if (this.hrX == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, cbP().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrX = (com.baidu.live.l.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrX.d(this.hso, cbI());
            if (cbP().hBH != null) {
                this.hrX.a(cbP().hBH.Fm());
            }
            this.hrX.setCanVisible(true);
            this.hrX.ch(true);
            this.hrX.a(cbP().hBH.bTR());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbs() {
        if (cbP() != null) {
            if (this.hrY == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, cbP().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrY = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (cbP().hBH != null) {
                this.hrY.b(cbP().hBH.Fm(), this.otherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caj() {
        if (cbP() != null) {
            if (this.hqG == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbP().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqG = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqG.setIsHost(false);
            this.hqG.a(caN(), cbP().hBH.Fm().aJc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbt() {
        if (cbP() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.hrZ == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, cbP().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrZ = (com.baidu.live.t.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrZ.setIsHost(false);
            this.hrZ.a(this.hro.hBI, cbP().hBH.Fm());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbu() {
        if (this.hrw != null && cbP() != null && cbP().hBH != null) {
            this.hrw.d(this.hso, cbP().hBH.Fm());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbv() {
        if (cbP() != null) {
            if (this.hsb == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, cbP().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hsb = (com.baidu.live.k.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.hro.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.hsb.a(this.hso, cbP().hBH.Fm(), layoutParams, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbw() {
        if (cbP() != null) {
            if (this.hrO == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913264, com.baidu.live.w.b.class, cbP().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hrO = (com.baidu.live.w.b) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrO.a(cbP().hBH.Fm(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbx() {
        if (cbP() != null) {
            if (this.hsd == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913278, com.baidu.live.g.a.class, cbP().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsd = (com.baidu.live.g.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsd.a(caN(), cbP().hBH.Fm());
        }
    }

    protected void cby() {
        if (this.hsc == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.c.class, cbP().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hsc = (com.baidu.live.t.c) runTask.getData();
            } else {
                return;
            }
        }
        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aId != null && cbP().hBH.Fm().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(cbP().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(cbP().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.hsc.b(this.hso, layoutParams, cbP().hBH.Fm());
        }
    }

    private void cbz() {
        if (this.hrR == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, cbP().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrR = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aId != null && cbP().hBH.Fm().mLiveInfo != null) {
            this.hrR.setHost(false);
            this.hrR.setOtherParams(Lo());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.hrR.a(this.hso, layoutParams, cbP().hBH.Fm());
            this.hrR.a(new l() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
                @Override // com.baidu.live.guardclub.l
                public void IY() {
                    b.this.cbQ();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x03f7, code lost:
        cbP().hBH.cju();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x06fb, code lost:
        Hv(r3.giftId);
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
        if (this.hqG != null) {
            this.hqG.Z(jSONObject2);
        }
        if (this.hrp == null || !this.hrp.Z(jSONObject2)) {
            if (bVar.getMsgType() == 12 || bVar.getMsgType() == 13) {
                if (jSONObject2 != null) {
                    String optString2 = jSONObject2.optString("content_type");
                    if ("live_on_private".equals(optString2)) {
                        boolean z = jSONObject2.optInt("on_private", 0) == 1;
                        if (this.brL != null) {
                            this.brL.cE(z);
                        }
                        int optInt = jSONObject2.optInt("on_audio_private", -1);
                        if (optInt >= 0) {
                            vq(optInt);
                        }
                    } else if ("live_admin".equals(optString2)) {
                        long optLong = jSONObject2.optLong("user_id");
                        int optInt2 = jSONObject2.optInt("opt_type");
                        if (optInt2 == 1) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                cbP().hBH.Fm().aIz.isAdmin = 1;
                                cbP().hBH.cju();
                            }
                        } else if (optInt2 == 2) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                cbP().hBH.Fm().aIz.isAdmin = 0;
                                cbP().hBH.cju();
                            }
                        } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbP().hBH.Fm().aIz.isAdmin = 0;
                            cbP().hBH.cju();
                        }
                    } else if ("task".equals(optString2)) {
                        dU(jSONObject2);
                    } else if ("live_net_status".equals(optString2)) {
                        int optInt3 = jSONObject2.optInt(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK);
                        if (this.hrJ != null && !cbP().hBM) {
                            String str = null;
                            if (optInt3 == 0) {
                                str = cbP().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                            } else if (optInt3 == 1) {
                                str = cbP().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                            } else if (optInt3 == 2) {
                                str = cbP().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                            }
                            if (str != null) {
                                if (bVK()) {
                                    BdUtilHelper.getCustomToast().showToast(str, 1);
                                } else {
                                    this.hrJ.c(cbP().hBG.getLiveContainerView(), str, 1);
                                }
                            }
                        }
                    } else if ("close_live".equals(optString2)) {
                        final int optInt4 = jSONObject2.optInt("close_type");
                        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.32
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.brL != null) {
                                    b.this.brL.cD(optInt4 == 2);
                                }
                            }
                        });
                    } else if ("first_recharge_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                    } else if ("privilege_award_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.s.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                    } else if ("live_talk_ban".equals(optString2)) {
                        long optLong2 = jSONObject2.optLong("user_id");
                        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aIz != null && cbP().hBH.Fm().aIz.userId == optLong2) {
                            cbP().hBH.Fm().aIz.isBlock = 1;
                            caA();
                        }
                    } else if ("live_talk_remove_ban".equals(optString2)) {
                        long optLong3 = jSONObject2.optLong("user_id");
                        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aIz != null && cbP().hBH.Fm().aIz.userId == optLong3) {
                            cbP().hBH.Fm().aIz.isBlock = 0;
                            caA();
                        }
                    } else if ("live_talk_admin_ban".equals(optString2)) {
                        long optLong4 = jSONObject2.optLong("user_id");
                        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aIz != null && cbP().hBH.Fm().aIz.userId == optLong4) {
                            cbP().hBH.Fm().aIz.isUegBlock = 1;
                            caA();
                        }
                    } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                        long optLong5 = jSONObject2.optLong("user_id");
                        if (cbP().hBH.Fm() != null && cbP().hBH.Fm().aIz != null && cbP().hBH.Fm().aIz.userId == optLong5) {
                            cbP().hBH.Fm().aIz.isUegBlock = 0;
                            caA();
                        }
                    } else if ("need_update_live_mark_info".equals(optString2)) {
                        if (cbP() != null && cbP().hBH != null && cbP().hBH.Fm() != null && cbP().hBH.Fm().aIz != null) {
                            long j3 = cbP().hBH.Fm().aIz.userId;
                            if (j3 == jSONObject2.optLong("user_id")) {
                                cbP().hBH.cju();
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
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, cbP().hBH.Fm().aIz));
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
                        com.baidu.live.data.a KZ = bVar.KZ();
                        if (KZ != null && ac.gq(str3)) {
                            ac.d(str3, 1L, "", "", KZ.userId, KZ.portrait, KZ.userName, "", "", false, "", "", "", false, false, true, -1L);
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
                        if (this.hsj != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("source", "im_mix_room_close");
                                jSONObject4.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                                this.hsj.x("mix_room_close", jSONObject4);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else if ("mysterious_man_activate".equals(optString2)) {
                        HB(jSONObject2.optString("url"));
                    } else if ("mysterious_man_expired_remind".equals(optString2)) {
                        HC(jSONObject2.optString("text"));
                    }
                }
            } else if (bVar.getMsgType() == 125) {
                if (this.hrA != null) {
                    this.hrA.R(bVar);
                }
            } else if (bVar.getMsgType() == 24 && jSONObject2 != null) {
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject2);
                if (cbP().hBH != null && cbP().hBH.Fm() != null && cbP().hBH.Fm().aJp && TextUtils.equals(cVar.bof, "luckybag")) {
                    cVar.bde = "";
                }
                com.baidu.live.data.a KZ2 = bVar.KZ();
                boolean z2 = false;
                long j5 = 0;
                String str4 = null;
                if (cbP().hBH == null || cbP().hBH.Fm() == null || cbP().hBH.Fm().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                } else {
                    j5 = cbP().hBH.Fm().mLiveInfo.live_id;
                    long j6 = cbP().hBH.Fm().mLiveInfo.group_id;
                    long j7 = cbP().hBH.Fm().aId.userId;
                    str4 = cbP().hBH.Fm().mLiveInfo.appId;
                    z2 = cbP().hBH.Fm().mLiveInfo.isPubShow;
                    j = j7;
                    j2 = j6;
                }
                if (!cVar.bpr || cVar.isDynamic) {
                    if (!TextUtils.isEmpty(cVar.bpm) && !TextUtils.isEmpty(cVar.bpo)) {
                        if (jSONObject2.optInt("flag_show") == 1) {
                            ac.b(cVar, KZ2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, "", "", bVar.getMsgId());
                            try {
                                JSONArray jSONArray = new JSONArray(cVar.bpo);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.ae.f.QB().hv(jSONArray.getJSONObject(i2).optString(LogConfig.LOG_GIFT_ID))) {
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
                        bVar.setHost(z2 && cVar.bpp);
                        ac.b(cVar, KZ2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, (cVar.bpp || cVar.bpr || cVar.bpq) ? false : true, true, "", "", bVar.getMsgId());
                        Hv(cVar.giftId);
                    }
                    if (!UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT.equals(cVar.contentType)) {
                        com.baidu.tieba.ala.liveroom.f.c cVar2 = new com.baidu.tieba.ala.liveroom.f.c();
                        cVar2.bpn = cVar.bpn;
                        cVar2.liveId = j5;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hsj = dVar;
    }

    protected void Hv(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbA() {
        if (cbB()) {
            BdUtilHelper.hideSoftKeyPad(cbP().pageContext.getPageActivity(), cbP().hBG.getLiveContainerView());
            caL();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbB() {
        if (caK() == null || caK().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        cbP().hBI.setOnTouchListener(this.htf);
        cbJ();
        cbK();
        cbL();
        cbr();
        cbz();
        cby();
        if (this.hry != null && cbP().hBH.Fm() != null && cbP().hBH.Fm().mLiveInfo != null) {
            this.hry.cI(cbP().hBH.Fm().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.hrE != null) {
            this.hrE.g(cbP().hBH.Fm());
        }
        if (this.hrC != null) {
            this.hrC.h(cbP().hBH.Fm());
        }
        if (this.hrK != null) {
            this.hrK.c(cbP().hBH.Fm(), Lo());
        }
        if (this.hrL != null) {
            this.hrL.b(cbP().hBH.Fm(), Lo());
        }
        if (this.hrM != null) {
            this.hrM.c(cbP().hBH.Fm(), Lo());
        }
        if (this.hsl != null) {
            this.hsl.h(cbP().hBH.Fm());
        }
        if (cbP().hBI != null) {
            cbP().hBI.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.35
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.cbB() && b.this.hrx != null) {
                        b.this.hrx.oJ(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.hrx != null) {
                        b.this.hrx.oJ(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nc() {
                    if (b.this.hsG == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.hsG) {
                        if (bVar.Nc()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            cbP().hBI.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.c.b.36
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.hrV == null && (runTask = MessageManager.getInstance().runTask(2913165, af.class, cbP().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hrV = (af) runTask.getData();
        }
        if (this.mHandler != null && cbR()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.37
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cbR()) {
                        b.this.vq(b.this.cbP().hBH.Fm().mLiveInfo.isAudioOnPrivate);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbC() {
        if (this.hsl == null && cbP() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, cbP().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hsl = (com.baidu.live.s.a) runTask.getData();
                this.hsl.p(cbP().hBI);
                this.hsl.b(cbP().hBH.Fm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbD() {
        com.baidu.live.data.ab Fm;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (cbP() != null && cbP().hBH != null && (Fm = cbP().hBH.Fm()) != null && Fm.mLiveInfo != null && !Fm.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) cbP().hBG) != null) {
            if (this.hse == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.y.a.class, cbP().pageContext)) != null && runTask.getData() != null) {
                this.hse = (com.baidu.live.y.a) runTask.getData();
            }
            if (this.hse != null) {
                this.hse.o(Fm);
                this.hse.a(this.htg);
                this.hse.a(viewGroup, this.hso);
                a(this.hse.PC());
                a(this.hse.PD());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.hsF == null) {
            this.hsF = new ArrayList();
        }
        if (!this.hsF.contains(dVar)) {
            this.hsF.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.hsF != null && this.hsF.contains(dVar)) {
            this.hsF.remove(dVar);
        }
    }

    protected void cbE() {
        if (this.hsF != null) {
            this.hsF.clear();
            this.hsF = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsF == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.hsF.iterator();
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
        if (this.hsG == null) {
            this.hsG = new ArrayList();
        }
        if (!this.hsG.contains(bVar)) {
            this.hsG.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hsG != null && this.hsG.contains(bVar)) {
            this.hsG.remove(bVar);
        }
    }

    protected void cbF() {
        if (this.hsG != null) {
            this.hsG.clear();
            this.hsG = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsG == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hsG.iterator();
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
    public void cbG() {
        if (this.hrW == null && this.hsg != null && this.hsg.aQc && cbP() != null && cbP().hBH != null && cbP().hBH.Fm() != null) {
            this.hrW = new com.baidu.tieba.ala.liveroom.g.e(cbP().pageContext, this.hsg);
            this.hrW.K(cbP().hBH.Fm());
            if (this.hsg.aQf == 1) {
                if (this.hrF != null) {
                    this.hsx = true;
                }
            } else if (this.hsg.aQf == 2) {
                a(cbP().hBH.Fm(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbH() {
        CustomResponsedMessage runTask;
        if (cbP() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, cbP().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hsh = (com.baidu.live.aa.a) runTask.getData();
            this.hsh.q(caN());
            if (cbP().hBH != null) {
                this.hsy = this.hsh.p(cbP().hBH.Fm());
            }
            this.hsh.setCanVisible(!this.hss);
        }
    }

    private ViewGroup.LayoutParams cbI() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = cbP().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        cbP().hBG.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(cbP().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(cbP().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? cbP().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + cbP().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void cbJ() {
        if (this.hrx != null) {
            this.hrx.aM(cbP().hBI);
        }
    }

    private void cbK() {
        if (this.hry != null) {
            this.hry.aP(cbP().hBI);
        }
    }

    private void cbL() {
        if (this.hrB == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hrB = (com.baidu.live.ag.a) runTask.getData();
            }
            cbM();
        }
    }

    private void dU(JSONObject jSONObject) {
        if (this.hrB != null) {
            if (this.hru != null) {
                this.hrB.dc(this.hru.cfJ() ? false : true);
            } else {
                this.hrB.dc(true);
            }
            this.hrB.ab(jSONObject);
        }
    }

    private void cbM() {
        if (this.hrB != null && cbP().hBH.Fm() != null && cbP().hBH.Fm().aIO != null) {
            if (this.hru != null) {
                this.hrB.dc(this.hru.cfJ() ? false : true);
            } else {
                this.hrB.dc(true);
            }
            this.hrB.j(cbP().hBH.Fm());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(com.baidu.live.data.ab abVar) {
        if (abVar != null) {
            if (this.hry != null && abVar.mLiveInfo != null) {
                this.hry.cI(abVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.hrQ != null) {
                this.hrQ.i(abVar);
            }
            cbM();
            if (this.hrD != null && abVar.aId != null) {
                this.hrD.HG(String.valueOf(abVar.aId.userId));
            }
            if (this.hrq != null) {
                this.hrq.a(abVar);
            }
            if (this.hrI != null && abVar.mLiveInfo != null) {
                this.hrI.a(abVar.mLiveInfo, abVar.aId);
            }
            if (this.hrG != null) {
                this.hrG.a(abVar);
            }
            if (this.hsh != null) {
                this.hsy = this.hsh.p(abVar);
            }
            if (this.hrX != null) {
                this.hrX.a(abVar);
            }
            if (this.hrZ != null) {
                this.hrZ.a(abVar);
            }
            if (this.hsd != null) {
                this.hsd.a(abVar);
            }
            if (this.hrY != null) {
                this.hrY.a(abVar);
            }
            if (this.hqG != null) {
                this.hqG.a(abVar);
            }
            if (this.hsb != null) {
                this.hsb.a(abVar);
            }
            if (this.hsa != null) {
                this.hsa.a(abVar);
            }
            if (this.hsc != null) {
                this.hsc.a(abVar);
            }
            if (this.hsk != null) {
                this.hsk.b(abVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(int i) {
        if (!cbP().hBM) {
            if (this.hsq < 0 && i == 0) {
                this.hsq = i;
            } else if (this.hsq != i) {
                if (i == 1) {
                    if (!this.hrJ.wf(2)) {
                        String string = cbP().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(cbP().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.hrJ.a(cbP().hBG.getLiveContainerView(), string, 2, 5000);
                        }
                    }
                } else {
                    String string2 = cbP().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.hrJ.wg(2);
                    this.hrJ.wg(3);
                    if (bVK()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.hrJ.c(cbP().hBG.getLiveContainerView(), string2, 3);
                    }
                }
                this.hsq = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (z) {
            cbN();
        }
        if (this.hrQ != null) {
            this.hrQ.IZ();
        }
        if (this.hrC != null) {
            this.hrC.IZ();
        }
        if (this.hrA != null) {
            this.hrA.clR();
        }
        if (this.hrs != null) {
            this.hrs.Ar();
        }
        if (this.hru != null) {
            this.hru.onDestroy();
        }
        if (this.hrB != null) {
            this.hrB.onDestroy();
            this.hrB = null;
        }
        if (this.hrH != null) {
            View EI = this.hrH.EI();
            if (EI != null && EI.getParent() != null) {
                ((ViewGroup) EI.getParent()).removeView(EI);
            }
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hrG != null) {
            this.hrG.a((a.InterfaceC0179a) null);
            this.hrG.zR();
        }
        if (this.hrJ != null) {
            this.hrJ.Ar();
        }
        this.hsq = -1;
        if (this.hrD != null) {
            this.hrD.Ar();
            this.hrD.onDestroy();
        }
        if (this.hrv != null) {
            this.hrv.clP();
        }
        if (this.hrw != null) {
            this.hrw.bZW();
            this.hrw.Fy();
        }
        if (this.hrx != null) {
            this.hrx.Fy();
        }
        if (this.hrE != null) {
            this.hrE.Fy();
        }
        if (this.hrK != null) {
            this.hrK.IZ();
        }
        if (this.hrL != null) {
            this.hrL.Fy();
        }
        if (this.hrM != null) {
            this.hrM.onDestroy();
        }
        if (this.hrP != null) {
            this.hrP.onDestory();
        }
        if (this.hrS != null) {
            this.hrS.xh();
        }
        if (this.hrR != null) {
            this.hrR.xh();
        }
        if (this.hsc != null) {
            this.hsc.xh();
        }
        if (this.hrW != null) {
            this.hrW.onDestroy();
        }
        if (this.bgE != null) {
            this.bgE.Fy();
        }
        if (this.hrU != null) {
            this.hrU.Fy();
        }
        if (this.hrV != null) {
            this.hrV.Fy();
        }
        if (this.hrt != null) {
            this.hrt.onDestory();
        }
        if (this.hsh != null) {
            this.hsh.Fy();
        }
        if (this.hrX != null) {
            this.hrX.xh();
            this.hrX.setCanVisible(false);
        }
        if (this.hrZ != null) {
            this.hrZ.xh();
        }
        if (this.hsd != null) {
            this.hsd.xh();
        }
        if (this.hrY != null) {
            this.hrY.xh();
        }
        if (this.hqG != null) {
            this.hqG.xh();
        }
        if (this.hsa != null) {
            this.hsa.xh();
        }
        if (this.hrT != null) {
            this.hrT.onDestroy();
        }
        if (this.hse != null) {
            this.hse.Ar();
            b(this.hse.PC());
            b(this.hse.PD());
        }
        if (this.hsf != null) {
            this.hsf.xh();
        }
        if (this.hsb != null) {
            this.hsb.xh();
        }
        if (this.hrF != null) {
            this.hrF.Kf().xh();
        }
        if (this.hsk != null) {
            this.hsk.IZ();
        }
        if (this.hsl != null) {
            this.hsl.IZ();
            this.hsl = null;
        }
        ShowUtil.windowCount = 0;
        cbE();
        cbF();
    }

    private void cbN() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = cbP().hBI.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = cbP().hBI.getChildAt(i);
            if (childAt != this.hso && childAt != this.hsp) {
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
        if (this.hso != null) {
            this.hso.removeAllViews();
        }
        if (this.hsp != null) {
            this.hsp.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, com.baidu.live.data.ab abVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(com.baidu.live.data.ab abVar) {
        View zP;
        View EI;
        if (this.hrH != null && (EI = this.hrH.EI()) != null && EI.getParent() != null) {
            ((ViewGroup) EI.getParent()).removeView(EI);
        }
        if (this.hrG != null && (zP = this.hrG.zP()) != null && zP.getParent() != null) {
            ((ViewGroup) zP.getParent()).removeView(zP);
        }
        if (this.hru != null) {
            this.hru.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean MY() {
        if (this.hrz == null || !this.hrz.cfO()) {
            if (this.hru == null || !this.hru.aI(cbP().hBG.getLiveContainerView())) {
                if (this.hrx != null) {
                    this.hrx.bWp();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.hrN != null && this.hrN.cfx()) {
                    this.hrN.cfG();
                    return false;
                } else if (this.hrM == null || !this.hrM.RF()) {
                    if (this.hsm == null || !this.hsm.RF()) {
                        if (this.hrO == null || !this.hrO.Pw()) {
                            cbn();
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
    public void Pv() {
        MX();
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cF(boolean z) {
        super.cF(z);
        if (this.hrQ != null) {
            this.hrQ.release();
        }
        if (this.hrC != null) {
            this.hrC.onDestroy();
        }
        if (this.hrB != null) {
            this.hrB.onDestroy();
            this.hrB = null;
        }
        if (this.hrA != null) {
            this.hrA.clR();
        }
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hrI != null) {
            this.hrI.onDestroy();
            this.hrI = null;
        }
        if (this.hrJ != null) {
            this.hrJ.onDestroy();
        }
        if (this.hrs != null) {
            this.hrs.onDestroy();
        }
        if (this.hrT != null) {
            this.hrT.onDestroy();
            this.hrT = null;
        }
        if (this.hrG != null) {
            this.hrG.a((a.InterfaceC0179a) null);
            this.hrG.release();
            this.hrG = null;
        }
        if (this.hrK != null) {
            this.hrK.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.hrK.release();
        }
        if (this.hrL != null) {
            this.hrL.a(null);
            this.hrL.release();
        }
        if (this.hrM != null) {
            this.hrM.a((b.a) null);
            this.hrM.onDestroy();
        }
        if (this.hrR != null) {
            this.hrR.onDestroy();
        }
        if (this.hrS != null) {
            this.hrS.onDestroy();
        }
        if (this.hrP != null) {
            this.hrP.onDestory();
        }
        if (this.hsc != null) {
            this.hsc.onDestroy();
        }
        if (this.hrW != null) {
            this.hrW.onDestroy();
        }
        if (this.bgE != null) {
            this.bgE.release();
        }
        if (this.hrU != null) {
            this.hrU.release();
        }
        if (this.hrV != null) {
            this.hrV.release();
        }
        if (this.hrt != null) {
            this.hrt.onDestory();
        }
        if (this.hsh != null) {
            this.hsh.release();
        }
        if (this.hrX != null) {
            this.hrX.onDestroy();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
        }
        if (this.hsd != null) {
            this.hsd.onDestroy();
        }
        if (this.hrY != null) {
            this.hrY.onDestroy();
        }
        if (this.hqG != null) {
            this.hqG.onDestroy();
        }
        if (this.hsa != null) {
            this.hsa.onDestroy();
        }
        if (this.hrx != null) {
            this.hrx.Fy();
        }
        if (this.hsb != null) {
            this.hsb.onDestroy();
        }
        if (this.hsk != null) {
            this.hsk.onDestroy();
        }
        if (this.hsl != null) {
            this.hsl.onDestory();
        }
        if (this.hrO != null) {
            this.hrO.onDestroy();
        }
        if (this.hse != null) {
            this.hse.onDestroy();
            b(this.hse.PC());
            b(this.hse.PD());
        }
        cbE();
        cbF();
        MessageManager.getInstance().unRegisterListener(this.hsL);
        MessageManager.getInstance().unRegisterListener(this.hsM);
        MessageManager.getInstance().unRegisterListener(this.hsN);
        MessageManager.getInstance().unRegisterListener(this.hsR);
        MessageManager.getInstance().unRegisterListener(this.hsS);
        MessageManager.getInstance().unRegisterListener(this.hsU);
        MessageManager.getInstance().unRegisterListener(this.hsO);
        MessageManager.getInstance().unRegisterListener(this.hsP);
        MessageManager.getInstance().unRegisterListener(this.gNt);
        MessageManager.getInstance().unRegisterListener(this.hsQ);
        MessageManager.getInstance().unRegisterListener(this.gNG);
        MessageManager.getInstance().unRegisterListener(this.hsV);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gXN);
        MessageManager.getInstance().unRegisterListener(this.gXK);
        MessageManager.getInstance().unRegisterListener(this.bxM);
        MessageManager.getInstance().unRegisterListener(this.hsW);
        MessageManager.getInstance().unRegisterListener(this.hsX);
        MessageManager.getInstance().unRegisterListener(this.hsY);
        MessageManager.getInstance().unRegisterListener(this.htc);
        MessageManager.getInstance().unRegisterListener(this.htd);
        MessageManager.getInstance().unRegisterListener(this.hdY);
        MessageManager.getInstance().unRegisterListener(this.hte);
        MessageManager.getInstance().unRegisterListener(this.hsZ);
        MessageManager.getInstance().unRegisterListener(this.bqY);
        MessageManager.getInstance().unRegisterListener(this.hta);
        MessageManager.getInstance().unRegisterListener(this.htb);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.hrK != null) {
            this.hrK.oq(false);
        }
        if (this.hrM != null) {
            this.hrM.oq(false);
        }
        caL();
        if (this.hrQ != null) {
            this.hrQ.onPause();
        }
        if (this.bgE != null) {
            this.bgE.pause();
        }
        if (this.hrT != null) {
            this.hrT.onPause();
        }
        if (this.hsb != null) {
            this.hsb.onPause();
        }
        if (this.hsd != null) {
            this.hsd.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hsB = false;
        if (this.hst && this.hsu != null) {
            a(this.hsu);
            this.hst = false;
        }
        if (this.hrK != null) {
            this.hrK.oq(true);
        }
        if (this.hrM != null) {
            this.hrM.oq(true);
        }
        if (this.hrQ != null) {
            this.hrQ.onResume();
        }
        if (this.bgE != null) {
            this.bgE.resume();
        }
        if (this.hrT != null) {
            this.hrT.onResume();
        }
        if (this.hsb != null) {
            this.hsb.onResume();
        }
        if (this.hsd != null) {
            this.hsd.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        if (this.hsd != null) {
            this.hsd.onStop();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awo() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hse != null && this.hse.isOpen()) {
            this.hse.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            awo();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    P(-1, -1, -1);
                    return;
                }
                return;
            }
            awo();
        } else if (i == 25034) {
            cbk();
        } else if (i == 25043) {
            if (i2 == -1) {
                cbQ();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.p.a.K(cbP().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.p.a.K(cbP().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hss = z;
        if (this.hsl != null) {
            this.hsl.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cbO() {
        return (cbP().hBH.Fm() == null || cbP().hBH.Fm().mLiveInfo == null || cbP().hBH.Fm().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.hru != null) {
                this.hru.C(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.hrM != null) {
            this.hrM.cK(i3);
        }
        if (this.hrt != null) {
            this.hrt.bkp();
        }
        if (this.hse != null) {
            this.hse.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.hro = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a cbP() {
        return this.hro;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbQ() {
        String IU = g.IT().IU();
        if (!TextUtils.isEmpty(IU)) {
            try {
                P(-1, Integer.parseInt(IU), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                P(-1, -1, -1);
            }
        }
    }

    public boolean dF(int i) {
        if (1 == i) {
            if (caK() != null) {
                caK().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.hss) {
                return false;
            }
            return this.hru == null || !this.hru.cfJ();
        } else if (3 == i) {
            if (cbP().hBI != null) {
                cbP().hBI.setEnabled(false);
                if (this.brL != null) {
                    this.brL.e(!cbP().hBK, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void vo(int i) {
        if (i == 7 || i == 11) {
            Log.d("bugbye", "bugbye");
        }
    }

    public void dG(int i) {
        if (3 == i) {
            cbP().hBI.setEnabled(true);
            if (this.brL != null) {
                this.brL.e(!cbP().hBK, true);
            }
            if (this.hrB != null) {
                this.hrB.dc(true);
            }
        } else if (2 == i && this.hrA != null) {
            this.hrA.oS(true);
        }
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hrG != null) {
            this.hrG.setOtherParams(str);
        }
        if (this.hrQ != null) {
            this.hrQ.hj(str);
        }
    }

    private boolean bVK() {
        return cbP().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grF = alaLastLiveroomInfo;
    }

    public void cp(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(cbP().pageContext.getPageActivity(), this.hsz);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }

    private void HB(String str) {
        if (this.bgE == null) {
            this.bgE = new com.baidu.live.an.a(cbP().pageContext.getPageActivity());
        }
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        cVar.url = str;
        cVar.isFullScreen = true;
        this.bgE.a(cVar);
    }

    private void HC(String str) {
        Activity pageActivity = cbP().pageContext.getPageActivity();
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(pageActivity);
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(true);
        cVar.setTitleVisible(false);
        cVar.Xu();
        cVar.o("", str, pageActivity.getString(a.h.sdk_know), "");
        cVar.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.39
            @Override // com.baidu.live.view.c.a
            public void Qa() {
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void Qb() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbR() {
        return (cbP().hBH.Fm() == null || cbP().hBH.Fm().mLiveInfo == null || cbP().hBH.Fm().mLiveInfo.isAudioOnPrivate != 1) ? false : true;
    }
}
