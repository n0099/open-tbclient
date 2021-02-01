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
    public static boolean hso;
    protected com.baidu.live.an.a bgE;
    protected AlaLastLiveroomInfo grr;
    protected com.baidu.live.ad.a hqs;
    protected com.baidu.live.w.b hrA;
    private k hrB;
    protected com.baidu.live.m.b hrC;
    protected h hrD;
    protected j hrE;
    protected ag hrF;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b hrG;
    private af hrH;
    protected e hrI;
    protected com.baidu.live.l.a hrJ;
    protected com.baidu.live.v.a hrK;
    protected com.baidu.live.t.a hrL;
    protected com.baidu.live.a.a hrM;
    protected com.baidu.live.k.a hrN;
    protected com.baidu.live.t.c hrO;
    protected com.baidu.live.g.a hrP;
    protected com.baidu.live.y.a hrQ;
    protected com.baidu.tieba.ala.liveroom.exclusive.b hrR;
    protected bw hrS;
    protected com.baidu.live.aa.a hrT;
    protected com.baidu.tieba.ala.liveroom.e.a hrU;
    protected com.baidu.tieba.ala.player.d hrV;
    protected com.baidu.live.guess.a hrW;
    protected com.baidu.live.s.a hrX;
    protected com.baidu.live.am.c hrY;
    protected com.baidu.live.c.a hrZ;
    private com.baidu.tieba.ala.liveroom.data.a hra;
    protected com.baidu.tieba.ala.liveroom.operation.a hrb;
    protected com.baidu.live.j.b hrc;
    protected com.baidu.live.j.a hrd;
    protected com.baidu.tieba.ala.liveroom.share.c hre;
    protected com.baidu.tieba.ala.liveroom.q.b hrf;
    protected com.baidu.tieba.ala.liveroom.guide.c hrg;
    protected com.baidu.tieba.ala.liveroom.watermark.a hrh;
    protected com.baidu.tieba.ala.liveroom.a.b hri;
    protected com.baidu.tieba.ala.liveroom.praise.a hrj;
    protected com.baidu.tieba.ala.liveroom.sticker.a hrk;
    protected com.baidu.tieba.ala.liveroom.guide.d hrl;
    protected com.baidu.tieba.ala.liveroom.v.a hrm;
    protected com.baidu.live.ag.a hrn;
    protected com.baidu.live.ag.d hro;
    private com.baidu.tieba.ala.liveroom.g.a hrp;
    private m hrq;
    com.baidu.live.im.k hrr;
    com.baidu.live.im.b.a hrs;
    protected ad hrt;
    protected ab hru;
    protected com.baidu.tieba.ala.liveroom.tippop.a hrv;
    private com.baidu.tieba.ala.liveroom.guideim.b hrw;
    protected com.baidu.live.view.input.d hrx;
    com.baidu.tieba.ala.liveroom.l.b hry;
    protected com.baidu.tieba.ala.liveroom.guide.a hrz;
    protected RelativeLayout hsa;
    protected RelativeLayout hsb;
    protected boolean hsd;
    protected ax hsg;
    protected GuardClubInfoHttpResponseMessage hsh;
    boolean hsi;
    boolean hsj;
    boolean hsk;
    public boolean hsm;
    public boolean hsn;
    protected com.baidu.tieba.ala.liveroom.s.b hsp;
    protected com.baidu.tieba.ala.liveroom.i.e hsq;
    protected List<com.baidu.live.liveroom.g.d> hsr;
    protected List<com.baidu.live.liveroom.g.b> hss;
    CustomMessageTask hst;
    CustomMessageTask hsu;
    protected String otherParams;
    private int hsc = -1;
    protected boolean aMG = true;
    protected int aMI = 0;
    protected int mOrientation = 0;
    protected boolean hse = false;
    protected boolean hsf = false;
    private int hsl = a.C0195a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> hsv = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.c.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.c.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: cbL */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> hsw = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.c.b.12
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
    private CustomMessageListener hsx = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.c.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ao aoVar;
            if ((customResponsedMessage.getData() instanceof ao) && (aoVar = (ao) customResponsedMessage.getData()) != null) {
                b.this.a(aoVar.aJZ, aoVar.aJV, aoVar.aJW, aoVar.aJX, aoVar.aJY);
            }
        }
    };
    private CustomMessageListener hsy = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.c.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.vo(7);
        }
    };
    private CustomMessageListener hsz = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.c.b.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cbd();
        }
    };
    private CustomMessageListener hsA = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.c.b.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.cbI().hBt.Fm().aId.userId);
            com.baidu.live.view.a.Xo().a(valueOf, new f(b.this.cbI().hBt.Fm().aId.portrait, valueOf, true, b.this.cbI().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hsB = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.c.b.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.data.ab) && b.this.hre != null) {
                b.this.hre.d((com.baidu.live.data.ab) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bxM = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.c.b.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hrr != null) {
                b.this.hrr.g(z.Fe().Fg());
            }
        }
    };
    private CustomMessageListener hsC = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.c.b.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.hra.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.Hy(str);
            }
        }
    };
    private CustomMessageListener gNf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.c.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.cbI().pageContext.getPageActivity());
            } else if (b.this.hre != null) {
                b.this.hre.d(b.this.cbI().hBt.Fm(), false);
            }
        }
    };
    private CustomMessageListener hsD = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.c.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    b.this.hsf = true;
                    b.this.hsg = (ax) data;
                    b.this.b(b.this.hsg);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                } else if (data instanceof String) {
                    b.this.Hx((String) data);
                }
            }
        }
    };
    private CustomMessageListener hsE = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.c.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.cbI().hBt.Fm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.cbI().hBt.Fm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.cbI().hBt.Fm().aId.userId);
                    if (b.this.hrf == null) {
                        b.this.hrf = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    b.this.hrf.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.hrf.a(b.this.hsF);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b hsF = new e.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void Ph() {
            if (b.this.cbI().hBt.Fm() != null && b.this.cbI().hBt.Fm().aIz != null) {
                b.this.cbI().hBt.Fm().aIz.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener hsG = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.c.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (b.this.hrC != null) {
                    b.this.hrC.I(bVar);
                }
                if (b.this.hrR != null) {
                    b.this.hrR.N(bVar);
                }
                if (b.this.hrd != null) {
                    b.this.hrd.l(bVar);
                }
                if (b.this.hrN != null) {
                    b.this.hrN.l(bVar);
                }
                b.this.t(bVar);
            }
        }
    };
    CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.c.b.7
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
    CustomMessageListener hsH = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.c.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.hsi = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.c.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hry != null) {
                b.this.hry.FA();
            }
        }
    };
    HttpMessageListener gXz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.c.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).biY) != null && b.this.hrB != null && b.this.cbI() != null && b.this.cbI().hBt != null) {
                int[] iArr = new int[2];
                b.this.hsa.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.hrB.a(b.this.hsa, layoutParams, aVar, b.this.cbI().hBt.Fm());
                com.baidu.live.q.a.aD(aVar.liveId + "", "guard_club_join");
                com.baidu.live.p.a.c(b.this.cbI().hBt.Fm().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gXw = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.c.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.cbI() != null && b.this.cbI().hBt != null && b.this.cbI().hBt.Fm() != null && guardClubInfoHttpResponseMessage.biY != null) {
                    if (guardClubInfoHttpResponseMessage.biY.anchorId == b.this.cbI().hBt.Fm().aId.userId) {
                        b.this.hsh = guardClubInfoHttpResponseMessage;
                        if (b.this.hsh.bjd && com.baidu.live.guardclub.e.IS() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.IS().aU(b.this.cbI().hBt.Fm().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hsI = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.c.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof ci) {
                b.this.a((ci) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hsJ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.c.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.H(b.this.cbI().hBt.Fm());
        }
    };
    private CustomMessageListener hsK = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.c.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hrJ != null) {
                b.this.hrJ.Jo();
            }
        }
    };
    private CustomMessageListener hsL = new CustomMessageListener(2913261) { // from class: com.baidu.tieba.ala.liveroom.c.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.hrK != null) {
                    b.this.hrK.hs(str);
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
    public CustomMessageListener hsM = new CustomMessageListener(2913281) { // from class: com.baidu.tieba.ala.liveroom.c.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hrr != null && b.this.hrx != null) {
                if (b.this.hrr.getTextView() != null) {
                    BdUtilHelper.showSoftKeyPad(b.this.getActivity(), b.this.hrr.getTextView());
                }
                b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hrr.Ke().setFromDailyTask(true, b.this.cbI().hBt.Fm().aIO.aNS);
                        b.this.hrr.Ke().a(null, z.Fe().Fg(), b.this.cbI().hBt.Fm().mLiveInfo);
                    }
                }, 300L);
            }
        }
    };
    public CustomMessageListener hsN = new CustomMessageListener(2913289) { // from class: com.baidu.tieba.ala.liveroom.c.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hrb != null) {
                b.this.hrb.cjK();
            }
        }
    };
    private CustomMessageListener hsO = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.c.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.hrF != null) {
                    ((com.baidu.tieba.ala.liveroom.p.a) b.this.hrF).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hsP = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.c.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.cbI().hBt.Fm(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hdK = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.c.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.bgE == null) {
                b.this.bgE = new com.baidu.live.an.a(b.this.cbI().pageContext.getPageActivity());
            }
            b.this.bgE.a((com.baidu.live.an.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener hsQ = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.c.b.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.cbI().pageContext.getPageActivity() != null) {
                com.baidu.live.p.a.r(b.this.cbI().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener hsR = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.34
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.cbt();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.y.b hsS = new com.baidu.live.y.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.38
        @Override // com.baidu.live.y.b
        public boolean PE() {
            if (b.this.cbI().hBu != null) {
                if (!b.this.cbI().hBu.clm()) {
                    b.this.hrQ.close();
                    return false;
                } else if (b.this.cbI().hBu.getScrollX() != 0) {
                    b.this.hrQ.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void Hx(String str);

    protected abstract void a(ax axVar);

    protected abstract void b(ax axVar);

    protected abstract View caD();

    public abstract boolean caE();

    protected abstract boolean caF();

    protected abstract ViewGroup caG();

    protected abstract void cat();

    protected abstract void g(com.baidu.live.data.a aVar);

    public abstract boolean isVertical();

    protected abstract void nL(boolean z);

    public void a(bw bwVar) {
        this.hrS = bwVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hsa = (RelativeLayout) cbI().hBu.findViewById(a.f.ala_live_header_view);
        this.hsb = (RelativeLayout) cbI().hBu.findViewById(a.f.ala_live_footer_view);
        Gd();
        registerListener();
    }

    public void caL() {
    }

    private void Gd() {
        if (this.hre == null) {
            this.hre = new com.baidu.tieba.ala.liveroom.share.c(cbI().pageContext);
        }
        this.hrm = new com.baidu.tieba.ala.liveroom.v.a(cbI().pageContext, this);
        this.hri = new com.baidu.tieba.ala.liveroom.a.b(cbI().pageContext, false);
        this.hrj = new com.baidu.tieba.ala.liveroom.praise.a(cbI().pageContext);
        this.hrk = new com.baidu.tieba.ala.liveroom.sticker.a(cbI().pageContext);
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
                this.hrl = new com.baidu.tieba.ala.liveroom.guide.d(cbI().pageContext);
            }
        }
        this.hrv = new com.baidu.tieba.ala.liveroom.tippop.a(cbI().pageContext, this);
        caO();
        caR();
        caS();
        caX();
        caN();
        caM();
        caY();
    }

    private void caM() {
        CustomResponsedMessage runTask;
        if (this.hro == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ag.d.class, cbI().pageContext)) != null && runTask.getData() != null) {
            this.hro = (com.baidu.live.ag.d) runTask.getData();
        }
    }

    private void caN() {
        CustomResponsedMessage runTask;
        if (this.hrC == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.m.b.class, cbI().pageContext)) != null && runTask.getData() != null) {
            this.hrC = (com.baidu.live.m.b) runTask.getData();
            this.hrC.c(cbI().pageContext);
            this.hrC.Mq().setTargetView(this.hsb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.hrU == null) {
            this.hrU = new com.baidu.tieba.ala.liveroom.e.a(cbI().pageContext);
            this.hrU.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.hrU.a(cbI().hBt.Fm(), alaLastLiveroomInfo);
        this.hrU.aF(this.hsb);
    }

    private void caO() {
        this.hrq = new m();
    }

    public void nO(boolean z) {
        this.hsd = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caP() {
        CustomResponsedMessage runTask;
        if (this.hrd == null && (runTask = MessageManager.getInstance().runTask(2913273, com.baidu.live.j.a.class, cbI().pageContext)) != null) {
            this.hrd = (com.baidu.live.j.a) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caQ() {
        com.baidu.live.data.ab Fm = cbI().hBt.Fm();
        boolean z = com.baidu.live.ae.a.Qj().buX.aMZ;
        if (Fm.mLiveInfo != null && Fm.mLiveInfo.mAlaLiveSwitchData != null && Fm.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Fm.aIP ? z : false;
        if (z2) {
            if (this.hrc == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, cbI().pageContext);
                if (runTask != null) {
                    this.hrc = (com.baidu.live.j.b) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.hrc != null) {
                this.hrc.du(1);
                View view = this.hrc.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(cbI().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(cbI().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    cp(view);
                    this.hsa.addView(view, layoutParams);
                    if (z2) {
                        this.hrc.a(Fm);
                    }
                }
            }
        }
    }

    private void caR() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.d.class, cbI().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hrx = (com.baidu.live.view.input.d) runTask.getData();
            this.hrx.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.25
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
                    return b.this.caV();
                }

                @Override // com.baidu.live.view.input.d.a
                public int Kn() {
                    return b.this.caW();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Ko() {
                    com.baidu.live.data.ab Fm = b.this.cbI().hBt.Fm();
                    if (Fm == null || Fm.aIz == null) {
                        return false;
                    }
                    return Fm.aIz.isMysteriousMan;
                }
            });
        }
    }

    private void caS() {
        this.hry = new com.baidu.tieba.ala.liveroom.l.b(this.hra.pageContext);
        this.hry.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.c.b.26
            @Override // com.baidu.tieba.ala.liveroom.l.b.a
            public boolean cbM() {
                return b.this.caF();
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
    public void caT() {
        if (this.hrW == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.hrW = (com.baidu.live.guess.a) runTask.getData();
                this.hrW.p(getActivity());
            } else {
                return;
            }
        }
        if (this.hrW != null) {
            this.hrW.dv(0);
            this.hrW.a(cbI().hBt.Fm(), caG());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nP(boolean z) {
        if (this.hrw != null) {
            this.hrw.or(z);
        }
        if (this.hry != null) {
            this.hry.or(z);
        }
        hso = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean caU() {
        return hso;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean caV() {
        com.baidu.live.data.ab Fm;
        if (cbI() == null || cbI().hBt == null || (Fm = cbI().hBt.Fm()) == null || Fm.aIz == null) {
            return false;
        }
        String str = Fm.aIz.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int caW() {
        com.baidu.live.data.ab Fm;
        if (cbI() != null && cbI().hBt != null && (Fm = cbI().hBt.Fm()) != null && !ListUtils.isEmpty(Fm.aIK)) {
            for (AlaLiveMarkData alaLiveMarkData : Fm.aIK) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void caX() {
        if (this.hrB == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, k.class, cbI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrB = (k) runTask.getData();
            } else {
                return;
            }
        }
        this.hrB.setOtherParams(Lo());
    }

    private void caY() {
        if (this.bgE == null) {
            this.bgE = new com.baidu.live.an.a(cbI().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.hst == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.hst = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.hsv);
            this.hst.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hst);
        }
        if (this.hsu == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.hsu = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.hsw);
            this.hsu.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hsu);
        }
        MessageManager.getInstance().registerListener(this.hsD);
        MessageManager.getInstance().registerListener(this.hsE);
        MessageManager.getInstance().registerListener(this.hsG);
        MessageManager.getInstance().registerListener(this.hsA);
        MessageManager.getInstance().registerListener(this.hsB);
        MessageManager.getInstance().registerListener(this.gNf);
        MessageManager.getInstance().registerListener(this.hsC);
        MessageManager.getInstance().registerListener(this.gNs);
        MessageManager.getInstance().registerListener(this.hsH);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gXz);
        MessageManager.getInstance().registerListener(this.gXw);
        MessageManager.getInstance().registerListener(this.bxM);
        MessageManager.getInstance().registerListener(this.hsI);
        MessageManager.getInstance().registerListener(this.hsJ);
        MessageManager.getInstance().registerListener(this.hsK);
        MessageManager.getInstance().registerListener(this.hsO);
        MessageManager.getInstance().registerListener(this.hsP);
        MessageManager.getInstance().registerListener(this.hsx);
        MessageManager.getInstance().registerListener(this.hsy);
        MessageManager.getInstance().registerListener(this.hsz);
        MessageManager.getInstance().registerListener(this.hdK);
        MessageManager.getInstance().registerListener(this.hsQ);
        MessageManager.getInstance().registerListener(this.hsL);
        MessageManager.getInstance().registerListener(this.bqY);
        MessageManager.getInstance().registerListener(this.hsM);
        MessageManager.getInstance().registerListener(this.hsN);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HZ() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(cbI().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cbI().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(cbI().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.27
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qj().buX.aMs;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = cbI().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = cbI().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.b.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.cbI().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(cbI().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caZ() {
        if (this.hrr != null && this.hrx != null) {
            this.hrr.Ke().a(this.hrx.Pl(), z.Fe().Fg(), cbI().hBt.Fm().mLiveInfo);
            nP(true);
            if (this.hrH == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, af.class, cbI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrH = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrH.gw("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cba() {
        if (this.hrr != null && this.hrx != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913304, this.hrx.Pl()));
            this.hrr.Kf().cw(false);
            if (com.baidu.live.ae.a.Qj().buX != null) {
                this.aMI = com.baidu.live.ae.a.Qj().buX.aMI;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.29
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cbb();
                }
            }, this.aMI * 1000);
        }
    }

    protected void cbb() {
        this.hrr.Kf().g(cbI().hBt.Fm());
        if (com.baidu.live.ae.a.Qj().buX != null) {
            this.aMG = com.baidu.live.ae.a.Qj().buX.aMG && !this.hrr.Kf().Mm();
        }
        if (this.aMG) {
            if (this.mOrientation != 2) {
                this.hrr.Kf().cw(true);
            } else {
                this.hrr.Kf().cw(false);
            }
            this.hrr.Kf().setClicked(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds108);
            layoutParams.leftMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.rightMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            if (this.hrF != null) {
                layoutParams.addRule(3, this.hrF.Fz().getId());
            }
            this.hrr.a(this.hsb, cbI().hBt.Fm(), this.hrx.Pl(), layoutParams);
            return;
        }
        this.hrr.Kf().cx(false);
        this.hrr.Kf().cw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbc() {
        if (this.hrr != null) {
            this.hrr.Ke().hide();
            nP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(int i, int i2, int i3) {
        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aId != null && cbI().hBt.Fm().mLiveInfo != null) {
            a(cbI().hBt.Fm(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.d.k.class) != null && HZ()) {
            if (abVar == null) {
                abVar = cbI().hBt.Fm();
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
            if (this.hsh != null && this.hsh.biY != null && this.hsh.biY.anchorId == abVar.aId.userId) {
                z5 = this.hsh.bjd;
            }
            com.baidu.live.d.k kVar = new com.baidu.live.d.k(cbI().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Fv, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (abVar != null && abVar.mLiveInfo != null && abVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bi(abVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.fi(str);
            kVar.bg(z);
            if (com.baidu.tieba.ala.liveroom.u.b.ckx().bvg != null) {
                kVar.bh(com.baidu.tieba.ala.liveroom.u.b.ckx().bvg.aKc != 1);
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
            if (cbI() != null && cbI().hBt != null) {
                kVar.fj(cbI().hBt.cjD());
            }
            if (!this.hsm) {
                this.hsn = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbd() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        dG(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ci ciVar) {
        if (ciVar != null && HZ()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(cbI().pageContext.getPageActivity(), ciVar.aQQ, ciVar.liveId, ciVar.aJM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qj().buX != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(cbI().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qj().buX.aNa, 1, false)));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(cbI().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbe() {
        if (this.hrx != null) {
            this.hrx.d(this.hra.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbf() {
        com.baidu.live.data.ab Fm = cbI().hBt.Fm();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fm == null || Fm.mLiveInfo == null) ? "" : Fm.mLiveInfo.feed_id, Lo());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hz(String str) {
        if (this.hrx != null) {
            this.hrx.gz(str);
        }
    }

    private void cbg() {
        if ("home_rec_play".equals(cbI().fromType) || "frs_play".equals(cbI().fromType) || "frs_live_play".equals(cbI().fromType) || "person_play".equals(cbI().fromType) || "search".equals(cbI().fromType) || "person_attention".equals(cbI().fromType)) {
            com.baidu.live.c.xb().aV(true);
        } else {
            com.baidu.live.c.xb().aV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nQ(boolean z) {
        View EI;
        if (this.hrt == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVn = false;
            fVar.context = cbI().pageContext.getPageActivity();
            fVar.aVx = z;
            fVar.fromType = cbI().fromType;
            fVar.aVy = isVertical() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrt = (ad) runTask.getData();
            }
        }
        if (this.hrt != null && (EI = this.hrt.EI()) != null && this.hra.hBu.indexOfChild(EI) < 0) {
            this.hra.hBu.addView(EI, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbh() {
        View Fz;
        if (this.hrF == null) {
            ak akVar = new ak();
            akVar.aVn = false;
            akVar.pageContext = cbI().pageContext;
            akVar.fromType = cbI().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrF = (ag) runTask.getData();
            }
        }
        if (this.hrF != null && (Fz = this.hrF.Fz()) != null && cbI().hBu.indexOfChild(Fz) < 0) {
            if (Fz.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fz.getParent()).removeView(Fz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hrr != null && this.hrr.Kf().Ml()) {
                layoutParams.bottomMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hrr.Kf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            cbI().hBu.addView(Fz, layoutParams);
        }
    }

    protected void nR(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.hrF != null) {
            View Fz = this.hrF.Fz();
            if (Fz.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) Fz.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if (this.hrr != null && z) {
                layoutParams.bottomMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds190);
                layoutParams.addRule(2, this.hrr.Kf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            Fz.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbi() {
        View Fl;
        if (this.hru == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVn = false;
            aVar.context = cbI().pageContext.getPageActivity();
            aVar.fromType = cbI().fromType;
            aVar.aVo = cbI().hBz;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hru = (ab) runTask.getData();
            }
        }
        if (this.hru != null && (Fl = this.hru.Fl()) != null && this.hsa != null && this.hsa.indexOfChild(Fl) < 0) {
            if (Fl.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fl.getParent()).removeView(Fl);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.hsa.addView(Fl, this.hsa.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbj() {
        CustomResponsedMessage runTask;
        if (this.hrs == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, cbI().pageContext)) != null) {
            this.hrs = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrs != null) {
            this.hrs.setOtherParams(this.otherParams);
            this.hrs.a(new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.b.30
                @Override // com.baidu.live.im.b.a.InterfaceC0179a
                public void KM() {
                    b.this.cbt();
                }
            });
            this.hrs.a(cbI().hBt.Fm(), false);
            View zP = this.hrs.zP();
            if (zP != null && this.hsb.indexOfChild(zP) < 0) {
                Resources resources = cbI().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbI().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hsb.addView(zP, layoutParams);
            }
        }
    }

    private void cbk() {
        if (this.hrp == null) {
            this.hrp = new com.baidu.tieba.ala.liveroom.g.a(cbI().pageContext);
        }
        if (this.hsg != null) {
            this.hrp.HF(this.hsg.user_id);
        }
        this.hrp.aF(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nS(boolean z) {
        if (cbI() != null && !z) {
            if (this.hrJ == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, cbI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrJ = (com.baidu.live.l.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrJ.d(this.hsa, cbB());
            if (cbI().hBt != null) {
                this.hrJ.a(cbI().hBt.Fm());
            }
            this.hrJ.setCanVisible(true);
            this.hrJ.ch(true);
            this.hrJ.a(cbI().hBt.bTK());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbl() {
        if (cbI() != null) {
            if (this.hrK == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, cbI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrK = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (cbI().hBt != null) {
                this.hrK.b(cbI().hBt.Fm(), this.otherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cac() {
        if (cbI() != null) {
            if (this.hqs == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqs = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqs.setIsHost(false);
            this.hqs.a(caG(), cbI().hBt.Fm().aJc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbm() {
        if (cbI() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.hrL == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, cbI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrL = (com.baidu.live.t.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrL.setIsHost(false);
            this.hrL.a(this.hra.hBu, cbI().hBt.Fm());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbn() {
        if (this.hri != null && cbI() != null && cbI().hBt != null) {
            this.hri.d(this.hsa, cbI().hBt.Fm());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbo() {
        if (cbI() != null) {
            if (this.hrN == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, cbI().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hrN = (com.baidu.live.k.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.hra.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.hrN.a(this.hsa, cbI().hBt.Fm(), layoutParams, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbp() {
        if (cbI() != null) {
            if (this.hrA == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913264, com.baidu.live.w.b.class, cbI().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hrA = (com.baidu.live.w.b) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrA.a(cbI().hBt.Fm(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbq() {
        if (cbI() != null) {
            if (this.hrP == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913278, com.baidu.live.g.a.class, cbI().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hrP = (com.baidu.live.g.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrP.a(caG(), cbI().hBt.Fm());
        }
    }

    protected void cbr() {
        if (this.hrO == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.c.class, cbI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrO = (com.baidu.live.t.c) runTask.getData();
            } else {
                return;
            }
        }
        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aId != null && cbI().hBt.Fm().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(cbI().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(cbI().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.hrO.b(this.hsa, layoutParams, cbI().hBt.Fm());
        }
    }

    private void cbs() {
        if (this.hrD == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, cbI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrD = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aId != null && cbI().hBt.Fm().mLiveInfo != null) {
            this.hrD.setHost(false);
            this.hrD.setOtherParams(Lo());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.hrD.a(this.hsa, layoutParams, cbI().hBt.Fm());
            this.hrD.a(new l() { // from class: com.baidu.tieba.ala.liveroom.c.b.31
                @Override // com.baidu.live.guardclub.l
                public void IY() {
                    b.this.cbJ();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x03f7, code lost:
        cbI().hBt.cjn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x06fb, code lost:
        Hu(r3.giftId);
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
        if (this.hqs != null) {
            this.hqs.Z(jSONObject2);
        }
        if (this.hrb == null || !this.hrb.Z(jSONObject2)) {
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
                                cbI().hBt.Fm().aIz.isAdmin = 1;
                                cbI().hBt.cjn();
                            }
                        } else if (optInt2 == 2) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                cbI().hBt.Fm().aIz.isAdmin = 0;
                                cbI().hBt.cjn();
                            }
                        } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbI().hBt.Fm().aIz.isAdmin = 0;
                            cbI().hBt.cjn();
                        }
                    } else if ("task".equals(optString2)) {
                        dU(jSONObject2);
                    } else if ("live_net_status".equals(optString2)) {
                        int optInt3 = jSONObject2.optInt(UbcStatConstant.KEY_CONTENT_EXT_LM_NETWORK);
                        if (this.hrv != null && !cbI().hBy) {
                            String str = null;
                            if (optInt3 == 0) {
                                str = cbI().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                            } else if (optInt3 == 1) {
                                str = cbI().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                            } else if (optInt3 == 2) {
                                str = cbI().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                            }
                            if (str != null) {
                                if (bVD()) {
                                    BdUtilHelper.getCustomToast().showToast(str, 1);
                                } else {
                                    this.hrv.c(cbI().hBs.getLiveContainerView(), str, 1);
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
                        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aIz != null && cbI().hBt.Fm().aIz.userId == optLong2) {
                            cbI().hBt.Fm().aIz.isBlock = 1;
                            cat();
                        }
                    } else if ("live_talk_remove_ban".equals(optString2)) {
                        long optLong3 = jSONObject2.optLong("user_id");
                        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aIz != null && cbI().hBt.Fm().aIz.userId == optLong3) {
                            cbI().hBt.Fm().aIz.isBlock = 0;
                            cat();
                        }
                    } else if ("live_talk_admin_ban".equals(optString2)) {
                        long optLong4 = jSONObject2.optLong("user_id");
                        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aIz != null && cbI().hBt.Fm().aIz.userId == optLong4) {
                            cbI().hBt.Fm().aIz.isUegBlock = 1;
                            cat();
                        }
                    } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                        long optLong5 = jSONObject2.optLong("user_id");
                        if (cbI().hBt.Fm() != null && cbI().hBt.Fm().aIz != null && cbI().hBt.Fm().aIz.userId == optLong5) {
                            cbI().hBt.Fm().aIz.isUegBlock = 0;
                            cat();
                        }
                    } else if ("need_update_live_mark_info".equals(optString2)) {
                        if (cbI() != null && cbI().hBt != null && cbI().hBt.Fm() != null && cbI().hBt.Fm().aIz != null) {
                            long j3 = cbI().hBt.Fm().aIz.userId;
                            if (j3 == jSONObject2.optLong("user_id")) {
                                cbI().hBt.cjn();
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
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, cbI().hBt.Fm().aIz));
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
                        if (this.hrV != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("source", "im_mix_room_close");
                                jSONObject4.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                                this.hrV.x("mix_room_close", jSONObject4);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else if ("mysterious_man_activate".equals(optString2)) {
                        HA(jSONObject2.optString("url"));
                    } else if ("mysterious_man_expired_remind".equals(optString2)) {
                        HB(jSONObject2.optString("text"));
                    }
                }
            } else if (bVar.getMsgType() == 125) {
                if (this.hrm != null) {
                    this.hrm.R(bVar);
                }
            } else if (bVar.getMsgType() == 24 && jSONObject2 != null) {
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject2);
                if (cbI().hBt != null && cbI().hBt.Fm() != null && cbI().hBt.Fm().aJp && TextUtils.equals(cVar.bof, "luckybag")) {
                    cVar.bde = "";
                }
                com.baidu.live.data.a KZ2 = bVar.KZ();
                boolean z2 = false;
                long j5 = 0;
                String str4 = null;
                if (cbI().hBt == null || cbI().hBt.Fm() == null || cbI().hBt.Fm().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                } else {
                    j5 = cbI().hBt.Fm().mLiveInfo.live_id;
                    long j6 = cbI().hBt.Fm().mLiveInfo.group_id;
                    long j7 = cbI().hBt.Fm().aId.userId;
                    str4 = cbI().hBt.Fm().mLiveInfo.appId;
                    z2 = cbI().hBt.Fm().mLiveInfo.isPubShow;
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
                        Hu(cVar.giftId);
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
        this.hrV = dVar;
    }

    protected void Hu(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbt() {
        if (cbu()) {
            BdUtilHelper.hideSoftKeyPad(cbI().pageContext.getPageActivity(), cbI().hBs.getLiveContainerView());
            caE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbu() {
        if (caD() == null || caD().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        cbI().hBu.setOnTouchListener(this.hsR);
        cbC();
        cbD();
        cbE();
        cbk();
        cbs();
        cbr();
        if (this.hrk != null && cbI().hBt.Fm() != null && cbI().hBt.Fm().mLiveInfo != null) {
            this.hrk.cI(cbI().hBt.Fm().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.hrq != null) {
            this.hrq.g(cbI().hBt.Fm());
        }
        if (this.hro != null) {
            this.hro.h(cbI().hBt.Fm());
        }
        if (this.hrw != null) {
            this.hrw.c(cbI().hBt.Fm(), Lo());
        }
        if (this.hrx != null) {
            this.hrx.b(cbI().hBt.Fm(), Lo());
        }
        if (this.hry != null) {
            this.hry.c(cbI().hBt.Fm(), Lo());
        }
        if (this.hrX != null) {
            this.hrX.h(cbI().hBt.Fm());
        }
        if (cbI().hBu != null) {
            cbI().hBu.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.c.b.35
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.cbu() && b.this.hrj != null) {
                        b.this.hrj.oJ(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.hrj != null) {
                        b.this.hrj.oJ(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Nc() {
                    if (b.this.hss == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.hss) {
                        if (bVar.Nc()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            cbI().hBu.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.c.b.36
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.hrH == null && (runTask = MessageManager.getInstance().runTask(2913165, af.class, cbI().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hrH = (af) runTask.getData();
        }
        if (this.mHandler != null && cbK()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.c.b.37
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cbK()) {
                        b.this.vq(b.this.cbI().hBt.Fm().mLiveInfo.isAudioOnPrivate);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbv() {
        if (this.hrX == null && cbI() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, cbI().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hrX = (com.baidu.live.s.a) runTask.getData();
                this.hrX.p(cbI().hBu);
                this.hrX.b(cbI().hBt.Fm());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbw() {
        com.baidu.live.data.ab Fm;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (cbI() != null && cbI().hBt != null && (Fm = cbI().hBt.Fm()) != null && Fm.mLiveInfo != null && !Fm.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) cbI().hBs) != null) {
            if (this.hrQ == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.y.a.class, cbI().pageContext)) != null && runTask.getData() != null) {
                this.hrQ = (com.baidu.live.y.a) runTask.getData();
            }
            if (this.hrQ != null) {
                this.hrQ.o(Fm);
                this.hrQ.a(this.hsS);
                this.hrQ.a(viewGroup, this.hsa);
                a(this.hrQ.PC());
                a(this.hrQ.PD());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.hsr == null) {
            this.hsr = new ArrayList();
        }
        if (!this.hsr.contains(dVar)) {
            this.hsr.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.hsr != null && this.hsr.contains(dVar)) {
            this.hsr.remove(dVar);
        }
    }

    protected void cbx() {
        if (this.hsr != null) {
            this.hsr.clear();
            this.hsr = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsr == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.hsr.iterator();
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
        if (this.hss == null) {
            this.hss = new ArrayList();
        }
        if (!this.hss.contains(bVar)) {
            this.hss.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hss != null && this.hss.contains(bVar)) {
            this.hss.remove(bVar);
        }
    }

    protected void cby() {
        if (this.hss != null) {
            this.hss.clear();
            this.hss = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hss == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hss.iterator();
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
    public void cbz() {
        if (this.hrI == null && this.hrS != null && this.hrS.aQc && cbI() != null && cbI().hBt != null && cbI().hBt.Fm() != null) {
            this.hrI = new com.baidu.tieba.ala.liveroom.g.e(cbI().pageContext, this.hrS);
            this.hrI.K(cbI().hBt.Fm());
            if (this.hrS.aQf == 1) {
                if (this.hrr != null) {
                    this.hsj = true;
                }
            } else if (this.hrS.aQf == 2) {
                a(cbI().hBt.Fm(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbA() {
        CustomResponsedMessage runTask;
        if (cbI() != null && (runTask = MessageManager.getInstance().runTask(2913130, com.baidu.live.im.k.class, cbI().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hrT = (com.baidu.live.aa.a) runTask.getData();
            this.hrT.q(caG());
            if (cbI().hBt != null) {
                this.hsk = this.hrT.p(cbI().hBt.Fm());
            }
            this.hrT.setCanVisible(!this.hse);
        }
    }

    private ViewGroup.LayoutParams cbB() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = cbI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        cbI().hBs.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(cbI().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(cbI().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? cbI().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + cbI().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void cbC() {
        if (this.hrj != null) {
            this.hrj.aM(cbI().hBu);
        }
    }

    private void cbD() {
        if (this.hrk != null) {
            this.hrk.aP(cbI().hBu);
        }
    }

    private void cbE() {
        if (this.hrn == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hrn = (com.baidu.live.ag.a) runTask.getData();
            }
            cbF();
        }
    }

    private void dU(JSONObject jSONObject) {
        if (this.hrn != null) {
            if (this.hrg != null) {
                this.hrn.dc(this.hrg.cfC() ? false : true);
            } else {
                this.hrn.dc(true);
            }
            this.hrn.ab(jSONObject);
        }
    }

    private void cbF() {
        if (this.hrn != null && cbI().hBt.Fm() != null && cbI().hBt.Fm().aIO != null) {
            if (this.hrg != null) {
                this.hrn.dc(this.hrg.cfC() ? false : true);
            } else {
                this.hrn.dc(true);
            }
            this.hrn.j(cbI().hBt.Fm());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(com.baidu.live.data.ab abVar) {
        if (abVar != null) {
            if (this.hrk != null && abVar.mLiveInfo != null) {
                this.hrk.cI(abVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.hrC != null) {
                this.hrC.i(abVar);
            }
            cbF();
            if (this.hrp != null && abVar.aId != null) {
                this.hrp.HF(String.valueOf(abVar.aId.userId));
            }
            if (this.hrc != null) {
                this.hrc.a(abVar);
            }
            if (this.hru != null && abVar.mLiveInfo != null) {
                this.hru.a(abVar.mLiveInfo, abVar.aId);
            }
            if (this.hrs != null) {
                this.hrs.a(abVar);
            }
            if (this.hrT != null) {
                this.hsk = this.hrT.p(abVar);
            }
            if (this.hrJ != null) {
                this.hrJ.a(abVar);
            }
            if (this.hrL != null) {
                this.hrL.a(abVar);
            }
            if (this.hrP != null) {
                this.hrP.a(abVar);
            }
            if (this.hrK != null) {
                this.hrK.a(abVar);
            }
            if (this.hqs != null) {
                this.hqs.a(abVar);
            }
            if (this.hrN != null) {
                this.hrN.a(abVar);
            }
            if (this.hrM != null) {
                this.hrM.a(abVar);
            }
            if (this.hrO != null) {
                this.hrO.a(abVar);
            }
            if (this.hrW != null) {
                this.hrW.b(abVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(int i) {
        if (!cbI().hBy) {
            if (this.hsc < 0 && i == 0) {
                this.hsc = i;
            } else if (this.hsc != i) {
                if (i == 1) {
                    if (!this.hrv.wf(2)) {
                        String string = cbI().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(cbI().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.hrv.a(cbI().hBs.getLiveContainerView(), string, 2, 5000);
                        }
                    }
                } else {
                    String string2 = cbI().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.hrv.wg(2);
                    this.hrv.wg(3);
                    if (bVD()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.hrv.c(cbI().hBs.getLiveContainerView(), string2, 3);
                    }
                }
                this.hsc = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cH(boolean z) {
        super.cH(z);
        if (z) {
            cbG();
        }
        if (this.hrC != null) {
            this.hrC.IZ();
        }
        if (this.hro != null) {
            this.hro.IZ();
        }
        if (this.hrm != null) {
            this.hrm.clK();
        }
        if (this.hre != null) {
            this.hre.Ar();
        }
        if (this.hrg != null) {
            this.hrg.onDestroy();
        }
        if (this.hrn != null) {
            this.hrn.onDestroy();
            this.hrn = null;
        }
        if (this.hrt != null) {
            View EI = this.hrt.EI();
            if (EI != null && EI.getParent() != null) {
                ((ViewGroup) EI.getParent()).removeView(EI);
            }
            this.hrt.onDestroy();
            this.hrt = null;
        }
        if (this.hrs != null) {
            this.hrs.a((a.InterfaceC0179a) null);
            this.hrs.zR();
        }
        if (this.hrv != null) {
            this.hrv.Ar();
        }
        this.hsc = -1;
        if (this.hrp != null) {
            this.hrp.Ar();
            this.hrp.onDestroy();
        }
        if (this.hrh != null) {
            this.hrh.clI();
        }
        if (this.hri != null) {
            this.hri.bZP();
            this.hri.Fy();
        }
        if (this.hrj != null) {
            this.hrj.Fy();
        }
        if (this.hrq != null) {
            this.hrq.Fy();
        }
        if (this.hrw != null) {
            this.hrw.IZ();
        }
        if (this.hrx != null) {
            this.hrx.Fy();
        }
        if (this.hry != null) {
            this.hry.onDestroy();
        }
        if (this.hrB != null) {
            this.hrB.onDestory();
        }
        if (this.hrE != null) {
            this.hrE.xh();
        }
        if (this.hrD != null) {
            this.hrD.xh();
        }
        if (this.hrO != null) {
            this.hrO.xh();
        }
        if (this.hrI != null) {
            this.hrI.onDestroy();
        }
        if (this.bgE != null) {
            this.bgE.Fy();
        }
        if (this.hrG != null) {
            this.hrG.Fy();
        }
        if (this.hrH != null) {
            this.hrH.Fy();
        }
        if (this.hrf != null) {
            this.hrf.onDestory();
        }
        if (this.hrT != null) {
            this.hrT.Fy();
        }
        if (this.hrJ != null) {
            this.hrJ.xh();
            this.hrJ.setCanVisible(false);
        }
        if (this.hrL != null) {
            this.hrL.xh();
        }
        if (this.hrP != null) {
            this.hrP.xh();
        }
        if (this.hrK != null) {
            this.hrK.xh();
        }
        if (this.hqs != null) {
            this.hqs.xh();
        }
        if (this.hrM != null) {
            this.hrM.xh();
        }
        if (this.hrF != null) {
            this.hrF.onDestroy();
        }
        if (this.hrQ != null) {
            this.hrQ.Ar();
            b(this.hrQ.PC());
            b(this.hrQ.PD());
        }
        if (this.hrR != null) {
            this.hrR.xh();
        }
        if (this.hrN != null) {
            this.hrN.xh();
        }
        if (this.hrr != null) {
            this.hrr.Kf().xh();
        }
        if (this.hrW != null) {
            this.hrW.IZ();
        }
        if (this.hrX != null) {
            this.hrX.IZ();
            this.hrX = null;
        }
        ShowUtil.windowCount = 0;
        cbx();
        cby();
    }

    private void cbG() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = cbI().hBu.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = cbI().hBu.getChildAt(i);
            if (childAt != this.hsa && childAt != this.hsb) {
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
        if (this.hsa != null) {
            this.hsa.removeAllViews();
        }
        if (this.hsb != null) {
            this.hsb.removeAllViews();
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
        if (this.hrt != null && (EI = this.hrt.EI()) != null && EI.getParent() != null) {
            ((ViewGroup) EI.getParent()).removeView(EI);
        }
        if (this.hrs != null && (zP = this.hrs.zP()) != null && zP.getParent() != null) {
            ((ViewGroup) zP.getParent()).removeView(zP);
        }
        if (this.hrg != null) {
            this.hrg.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean MY() {
        if (this.hrl == null || !this.hrl.cfH()) {
            if (this.hrg == null || !this.hrg.aI(cbI().hBs.getLiveContainerView())) {
                if (this.hrj != null) {
                    this.hrj.bWi();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.hrz != null && this.hrz.cfq()) {
                    this.hrz.cfz();
                    return false;
                } else if (this.hry == null || !this.hry.RF()) {
                    if (this.hrY == null || !this.hrY.RF()) {
                        if (this.hrA == null || !this.hrA.Pw()) {
                            cbg();
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
        if (this.hrC != null) {
            this.hrC.release();
        }
        if (this.hro != null) {
            this.hro.onDestroy();
        }
        if (this.hrn != null) {
            this.hrn.onDestroy();
            this.hrn = null;
        }
        if (this.hrm != null) {
            this.hrm.clK();
        }
        if (this.hrt != null) {
            this.hrt.onDestroy();
            this.hrt = null;
        }
        if (this.hru != null) {
            this.hru.onDestroy();
            this.hru = null;
        }
        if (this.hrv != null) {
            this.hrv.onDestroy();
        }
        if (this.hre != null) {
            this.hre.onDestroy();
        }
        if (this.hrF != null) {
            this.hrF.onDestroy();
            this.hrF = null;
        }
        if (this.hrs != null) {
            this.hrs.a((a.InterfaceC0179a) null);
            this.hrs.release();
            this.hrs = null;
        }
        if (this.hrw != null) {
            this.hrw.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.hrw.release();
        }
        if (this.hrx != null) {
            this.hrx.a(null);
            this.hrx.release();
        }
        if (this.hry != null) {
            this.hry.a((b.a) null);
            this.hry.onDestroy();
        }
        if (this.hrD != null) {
            this.hrD.onDestroy();
        }
        if (this.hrE != null) {
            this.hrE.onDestroy();
        }
        if (this.hrB != null) {
            this.hrB.onDestory();
        }
        if (this.hrO != null) {
            this.hrO.onDestroy();
        }
        if (this.hrI != null) {
            this.hrI.onDestroy();
        }
        if (this.bgE != null) {
            this.bgE.release();
        }
        if (this.hrG != null) {
            this.hrG.release();
        }
        if (this.hrH != null) {
            this.hrH.release();
        }
        if (this.hrf != null) {
            this.hrf.onDestory();
        }
        if (this.hrT != null) {
            this.hrT.release();
        }
        if (this.hrJ != null) {
            this.hrJ.onDestroy();
        }
        if (this.hrL != null) {
            this.hrL.onDestroy();
        }
        if (this.hrP != null) {
            this.hrP.onDestroy();
        }
        if (this.hrK != null) {
            this.hrK.onDestroy();
        }
        if (this.hqs != null) {
            this.hqs.onDestroy();
        }
        if (this.hrM != null) {
            this.hrM.onDestroy();
        }
        if (this.hrj != null) {
            this.hrj.Fy();
        }
        if (this.hrN != null) {
            this.hrN.onDestroy();
        }
        if (this.hrW != null) {
            this.hrW.onDestroy();
        }
        if (this.hrX != null) {
            this.hrX.onDestory();
        }
        if (this.hrA != null) {
            this.hrA.onDestroy();
        }
        if (this.hrQ != null) {
            this.hrQ.onDestroy();
            b(this.hrQ.PC());
            b(this.hrQ.PD());
        }
        cbx();
        cby();
        MessageManager.getInstance().unRegisterListener(this.hsx);
        MessageManager.getInstance().unRegisterListener(this.hsy);
        MessageManager.getInstance().unRegisterListener(this.hsz);
        MessageManager.getInstance().unRegisterListener(this.hsD);
        MessageManager.getInstance().unRegisterListener(this.hsE);
        MessageManager.getInstance().unRegisterListener(this.hsG);
        MessageManager.getInstance().unRegisterListener(this.hsA);
        MessageManager.getInstance().unRegisterListener(this.hsB);
        MessageManager.getInstance().unRegisterListener(this.gNf);
        MessageManager.getInstance().unRegisterListener(this.hsC);
        MessageManager.getInstance().unRegisterListener(this.gNs);
        MessageManager.getInstance().unRegisterListener(this.hsH);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gXz);
        MessageManager.getInstance().unRegisterListener(this.gXw);
        MessageManager.getInstance().unRegisterListener(this.bxM);
        MessageManager.getInstance().unRegisterListener(this.hsI);
        MessageManager.getInstance().unRegisterListener(this.hsJ);
        MessageManager.getInstance().unRegisterListener(this.hsK);
        MessageManager.getInstance().unRegisterListener(this.hsO);
        MessageManager.getInstance().unRegisterListener(this.hsP);
        MessageManager.getInstance().unRegisterListener(this.hdK);
        MessageManager.getInstance().unRegisterListener(this.hsQ);
        MessageManager.getInstance().unRegisterListener(this.hsL);
        MessageManager.getInstance().unRegisterListener(this.bqY);
        MessageManager.getInstance().unRegisterListener(this.hsM);
        MessageManager.getInstance().unRegisterListener(this.hsN);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.hrw != null) {
            this.hrw.oq(false);
        }
        if (this.hry != null) {
            this.hry.oq(false);
        }
        caE();
        if (this.hrC != null) {
            this.hrC.onPause();
        }
        if (this.bgE != null) {
            this.bgE.pause();
        }
        if (this.hrF != null) {
            this.hrF.onPause();
        }
        if (this.hrN != null) {
            this.hrN.onPause();
        }
        if (this.hrP != null) {
            this.hrP.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hsn = false;
        if (this.hsf && this.hsg != null) {
            a(this.hsg);
            this.hsf = false;
        }
        if (this.hrw != null) {
            this.hrw.oq(true);
        }
        if (this.hry != null) {
            this.hry.oq(true);
        }
        if (this.hrC != null) {
            this.hrC.onResume();
        }
        if (this.bgE != null) {
            this.bgE.resume();
        }
        if (this.hrF != null) {
            this.hrF.onResume();
        }
        if (this.hrN != null) {
            this.hrN.onResume();
        }
        if (this.hrP != null) {
            this.hrP.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
        if (this.hrP != null) {
            this.hrP.onStop();
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
        if (i == 4 && this.hrQ != null && this.hrQ.isOpen()) {
            this.hrQ.onClose();
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
            cbd();
        } else if (i == 25043) {
            if (i2 == -1) {
                cbJ();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.p.a.K(cbI().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.p.a.K(cbI().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hse = z;
        if (this.hrX != null) {
            this.hrX.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cbH() {
        return (cbI().hBt.Fm() == null || cbI().hBt.Fm().mLiveInfo == null || cbI().hBt.Fm().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.hrg != null) {
                this.hrg.C(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.hry != null) {
            this.hry.cK(i3);
        }
        if (this.hrf != null) {
            this.hrf.bkp();
        }
        if (this.hrQ != null) {
            this.hrQ.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.hra = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a cbI() {
        return this.hra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbJ() {
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
            if (caD() != null) {
                caD().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.hse) {
                return false;
            }
            return this.hrg == null || !this.hrg.cfC();
        } else if (3 == i) {
            if (cbI().hBu != null) {
                cbI().hBu.setEnabled(false);
                if (this.brL != null) {
                    this.brL.e(!cbI().hBw, false);
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
            cbI().hBu.setEnabled(true);
            if (this.brL != null) {
                this.brL.e(!cbI().hBw, true);
            }
            if (this.hrn != null) {
                this.hrn.dc(true);
            }
        } else if (2 == i && this.hrm != null) {
            this.hrm.oS(true);
        }
    }

    public String Lo() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hrs != null) {
            this.hrs.setOtherParams(str);
        }
        if (this.hrC != null) {
            this.hrC.hj(str);
        }
    }

    private boolean bVD() {
        return cbI().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.grr = alaLastLiveroomInfo;
    }

    public void cp(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(cbI().pageContext.getPageActivity(), this.hsl);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }

    private void HA(String str) {
        if (this.bgE == null) {
            this.bgE = new com.baidu.live.an.a(cbI().pageContext.getPageActivity());
        }
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        cVar.url = str;
        cVar.isFullScreen = true;
        this.bgE.a(cVar);
    }

    private void HB(String str) {
        Activity pageActivity = cbI().pageContext.getPageActivity();
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
    public boolean cbK() {
        return (cbI().hBt.Fm() == null || cbI().hBt.Fm().mLiveInfo == null || cbI().hBt.Fm().mLiveInfo.isAudioOnPrivate != 1) ? false : true;
    }
}
