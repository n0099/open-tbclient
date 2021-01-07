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
import com.baidu.tieba.ala.liveroom.j.e;
import com.baidu.tieba.ala.liveroom.n.b;
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
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a, com.baidu.live.y.a {
    public static boolean hsK;
    protected AlaLastLiveroomInfo gtp;
    protected com.baidu.live.ap.a hfG;
    protected com.baidu.live.ae.a hqL;
    protected com.baidu.tieba.ala.liveroom.guide.c hrA;
    protected com.baidu.tieba.ala.liveroom.watermark.a hrB;
    protected com.baidu.tieba.ala.liveroom.b.b hrC;
    protected com.baidu.tieba.ala.liveroom.praise.a hrD;
    protected com.baidu.tieba.ala.liveroom.sticker.a hrE;
    protected com.baidu.tieba.ala.liveroom.guide.d hrF;
    protected com.baidu.tieba.ala.liveroom.w.a hrG;
    protected com.baidu.live.ai.a hrH;
    protected com.baidu.live.ai.d hrI;
    private com.baidu.tieba.ala.liveroom.h.a hrJ;
    private m hrK;
    k hrL;
    com.baidu.live.im.b.a hrM;
    protected ad hrN;
    protected ab hrO;
    protected com.baidu.tieba.ala.liveroom.tippop.a hrP;
    private com.baidu.tieba.ala.liveroom.guideim.b hrQ;
    protected com.baidu.live.view.input.d hrR;
    com.baidu.tieba.ala.liveroom.n.b hrS;
    protected com.baidu.tieba.ala.liveroom.guide.a hrT;
    protected com.baidu.live.y.b hrU;
    private com.baidu.live.guardclub.k hrV;
    protected com.baidu.live.n.b hrW;
    protected h hrX;
    protected j hrY;
    protected ag hrZ;
    private com.baidu.tieba.ala.liveroom.data.a hru;
    protected com.baidu.tieba.ala.liveroom.operation.a hrv;
    protected com.baidu.live.k.b hrw;
    protected com.baidu.live.k.a hrx;
    protected com.baidu.tieba.ala.liveroom.share.c hry;
    protected com.baidu.tieba.ala.liveroom.r.b hrz;
    protected at hsC;
    protected GuardClubInfoHttpResponseMessage hsD;
    boolean hsE;
    boolean hsF;
    boolean hsG;
    public boolean hsI;
    public boolean hsJ;
    protected com.baidu.tieba.ala.liveroom.t.b hsL;
    protected e hsM;
    protected List<com.baidu.live.liveroom.g.d> hsN;
    protected List<com.baidu.live.liveroom.g.b> hsO;
    CustomMessageTask hsP;
    CustomMessageTask hsQ;
    protected com.baidu.tieba.ala.liveroom.turntable.e hsa;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b hsb;
    protected com.baidu.tieba.ala.liveroom.q.c hsc;
    private af hsd;
    protected com.baidu.tieba.ala.liveroom.h.e hse;
    protected com.baidu.live.m.a hsf;
    protected com.baidu.live.w.a hsg;
    protected com.baidu.live.u.a hsh;
    protected com.baidu.live.a.a hsi;
    protected com.baidu.live.l.a hsj;
    protected com.baidu.live.u.b hsk;
    protected com.baidu.live.h.a hsl;
    protected com.baidu.live.aa.a hsm;
    protected com.baidu.tieba.ala.liveroom.exclusive.b hsn;
    protected br hso;
    protected com.baidu.live.ab.a hsp;
    protected com.baidu.tieba.ala.liveroom.f.a hsq;
    protected com.baidu.tieba.ala.player.d hsr;
    protected com.baidu.live.guess.a hss;
    protected com.baidu.live.t.a hst;
    protected com.baidu.live.ao.c hsu;
    protected com.baidu.live.c.a hsv;
    protected RelativeLayout hsw;
    protected RelativeLayout hsx;
    protected boolean hsz;
    protected String otherParams;
    private int hsy = -1;
    protected boolean aOI = true;
    protected int aOK = 0;
    protected int mOrientation = 0;
    protected boolean hsA = false;
    protected boolean hsB = false;
    private int hsH = a.C0203a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> hsR = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: ceJ */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> hsS = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener hsT = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ak akVar;
            if ((customResponsedMessage.getData() instanceof ak) && (akVar = (ak) customResponsedMessage.getData()) != null) {
                b.this.a(akVar.aMh, akVar.aMd, akVar.aMe, akVar.aMf, akVar.aMg);
            }
        }
    };
    private CustomMessageListener hsU = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.wJ(7);
        }
    };
    private CustomMessageListener hsV = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.ceb();
        }
    };
    private CustomMessageListener hsW = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.ceG().hBP.HR().aKu.userId);
            com.baidu.live.view.a.Zy().a(valueOf, new f(b.this.ceG().hBP.HR().aKu.portrait, valueOf, true, b.this.ceG().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hsX = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof x) && b.this.hry != null) {
                b.this.hry.d((x) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bzb = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hrL != null) {
                b.this.hrL.g(z.HJ().HL());
            }
        }
    };
    private CustomMessageListener hsY = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.hru.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.If(str);
            }
        }
    };
    private CustomMessageListener gPf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.ceG().pageContext.getPageActivity());
            } else if (b.this.hry != null) {
                b.this.hry.d(b.this.ceG().hBP.HR(), false);
            }
        }
    };
    private CustomMessageListener hsZ = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof at) {
                    b.this.hsB = true;
                    b.this.hsC = (at) data;
                    b.this.b(b.this.hsC);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                } else if (data instanceof String) {
                    b.this.Ie((String) data);
                }
            }
        }
    };
    private CustomMessageListener hta = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.ceG().hBP.HR().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.ceG().hBP.HR().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.ceG().hBP.HR().aKu.userId);
                    if (b.this.hrz == null) {
                        b.this.hrz = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    b.this.hrz.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.hrz.a(b.this.htb);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b htb = new e.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void RA() {
            if (b.this.ceG().hBP.HR() != null && b.this.ceG().hBP.HR().aKQ != null) {
                b.this.ceG().hBP.HR().aKQ.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener htc = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (b.this.hrW != null) {
                    b.this.hrW.C(bVar);
                }
                if (b.this.hsn != null) {
                    b.this.hsn.I(bVar);
                }
                if (b.this.hrx != null) {
                    b.this.hrx.l(bVar);
                }
                if (b.this.hsj != null) {
                    b.this.hsj.l(bVar);
                }
                b.this.t(bVar);
            }
        }
    };
    CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener htd = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.hsE = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hrS != null) {
                b.this.hrS.If();
            }
        }
    };
    HttpMessageListener gZv = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bkF) != null && b.this.hrV != null && b.this.ceG() != null && b.this.ceG().hBP != null) {
                int[] iArr = new int[2];
                b.this.hsw.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.hrV.a(b.this.hsw, layoutParams, aVar, b.this.ceG().hBP.HR());
                com.baidu.live.r.a.aE(aVar.liveId + "", "guard_club_join");
                com.baidu.live.q.a.c(b.this.ceG().hBP.HR().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gZs = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.ceG() != null && b.this.ceG().hBP != null && b.this.ceG().hBP.HR() != null && guardClubInfoHttpResponseMessage.bkF != null) {
                    if (guardClubInfoHttpResponseMessage.bkF.anchorId == b.this.ceG().hBP.HR().aKu.userId) {
                        b.this.hsD = guardClubInfoHttpResponseMessage;
                        if (b.this.hsD.bkK && com.baidu.live.guardclub.e.Lx() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.Lx().aR(b.this.ceG().hBP.HR().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hte = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof cb) {
                b.this.a((cb) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener htf = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.H(b.this.ceG().hBP.HR());
        }
    };
    private CustomMessageListener htg = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hsf != null) {
                b.this.hsf.LN();
            }
        }
    };
    private CustomMessageListener hth = new CustomMessageListener(2913261) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.hsg != null) {
                    b.this.hsg.id(str);
                }
            }
        }
    };
    public CustomMessageListener bsj = new CustomMessageListener(2913272) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                boolean booleanValue = ((Boolean) customResponsedMessage.getData()).booleanValue();
                b.this.nK(booleanValue);
                b.this.nE(booleanValue);
            }
        }
    };
    public CustomMessageListener hti = new CustomMessageListener(2913281) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hrL != null && b.this.hrR != null) {
                if (b.this.hrL.getTextView() != null) {
                    BdUtilHelper.showSoftKeyPad(b.this.getActivity(), b.this.hrL.getTextView());
                }
                b.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.18.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.hrL.MB().setFromDailyTask(true, b.this.ceG().hBP.HR().aLf.aPJ);
                        b.this.hrL.MB().a(null, z.HJ().HL(), b.this.ceG().hBP.HR().mLiveInfo);
                    }
                }, 300L);
            }
        }
    };
    public CustomMessageListener htj = new CustomMessageListener(2913289) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && b.this.hrv != null) {
                b.this.hrv.cmD();
            }
        }
    };
    private CustomMessageListener htk = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.hrZ != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) b.this.hrZ).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener htl = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.ceG().hBP.HR(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hfH = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ap.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.hfG == null) {
                b.this.hfG = new com.baidu.live.ap.a(b.this.ceG().pageContext.getPageActivity());
            }
            b.this.hfG.a((com.baidu.live.ap.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener htm = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.ceG().pageContext.getPageActivity() != null) {
                com.baidu.live.q.a.r(b.this.ceG().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener htn = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.cer();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.aa.b hto = new com.baidu.live.aa.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        @Override // com.baidu.live.aa.b
        public boolean Sa() {
            if (b.this.ceG().hBQ != null) {
                if (!b.this.ceG().hBQ.cog()) {
                    b.this.hsm.close();
                    return false;
                } else if (b.this.ceG().hBQ.getScrollX() != 0) {
                    b.this.hsm.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void Ie(String str);

    protected abstract void a(at atVar);

    protected abstract void b(at atVar);

    public abstract boolean cdA();

    protected abstract boolean cdB();

    protected abstract ViewGroup cdC();

    protected abstract void cdp();

    protected abstract View cdz();

    protected abstract void g(com.baidu.live.data.a aVar);

    public abstract boolean isVertical();

    protected abstract void nE(boolean z);

    public void a(br brVar) {
        this.hso = brVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hsw = (RelativeLayout) ceG().hBQ.findViewById(a.f.ala_live_header_view);
        this.hsx = (RelativeLayout) ceG().hBQ.findViewById(a.f.ala_live_footer_view);
        II();
        registerListener();
    }

    public void cdH() {
    }

    private void II() {
        if (this.hry == null) {
            this.hry = new com.baidu.tieba.ala.liveroom.share.c(ceG().pageContext);
        }
        this.hrG = new com.baidu.tieba.ala.liveroom.w.a(ceG().pageContext, this);
        this.hrC = new com.baidu.tieba.ala.liveroom.b.b(ceG().pageContext, false);
        this.hrD = new com.baidu.tieba.ala.liveroom.praise.a(ceG().pageContext);
        this.hrE = new com.baidu.tieba.ala.liveroom.sticker.a(ceG().pageContext);
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
                this.hrF = new com.baidu.tieba.ala.liveroom.guide.d(ceG().pageContext);
            }
        }
        this.hrP = new com.baidu.tieba.ala.liveroom.tippop.a(ceG().pageContext, this);
        cdK();
        cdN();
        cdO();
        cdT();
        cdU();
        cdV();
        cdJ();
        cdI();
        cdW();
    }

    private void cdI() {
        CustomResponsedMessage runTask;
        if (this.hrI == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ai.d.class, ceG().pageContext)) != null && runTask.getData() != null) {
            this.hrI = (com.baidu.live.ai.d) runTask.getData();
        }
    }

    private void cdJ() {
        CustomResponsedMessage runTask;
        if (this.hrW == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.n.b.class, ceG().pageContext)) != null && runTask.getData() != null) {
            this.hrW = (com.baidu.live.n.b) runTask.getData();
            this.hrW.c(ceG().pageContext);
            this.hrW.ON().setTargetView(this.hsx);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.hsq == null) {
            this.hsq = new com.baidu.tieba.ala.liveroom.f.a(ceG().pageContext);
            this.hsq.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.hsq.a(ceG().hBP.HR(), alaLastLiveroomInfo);
        this.hsq.aF(this.hsx);
    }

    private void cdK() {
        this.hrK = new m();
    }

    public void nH(boolean z) {
        this.hsz = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdL() {
        CustomResponsedMessage runTask;
        if (this.hrx == null && (runTask = MessageManager.getInstance().runTask(2913273, com.baidu.live.k.a.class, ceG().pageContext)) != null) {
            this.hrx = (com.baidu.live.k.a) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdM() {
        x HR = ceG().hBP.HR();
        boolean z = com.baidu.live.af.a.SE().bwi.aOZ;
        if (HR.mLiveInfo != null && HR.mLiveInfo.mAlaLiveSwitchData != null && HR.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = HR.aLg ? z : false;
        if (z2) {
            if (this.hrw == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.k.b.class, ceG().pageContext);
                if (runTask != null) {
                    this.hrw = (com.baidu.live.k.b) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.hrw != null) {
                this.hrw.eV(1);
                View view = this.hrw.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(ceG().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(ceG().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    ct(view);
                    this.hsw.addView(view, layoutParams);
                    if (z2) {
                        this.hrw.a(HR);
                    }
                }
            }
        }
    }

    private void cdN() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.d.class, ceG().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hrR = (com.baidu.live.view.input.d) runTask.getData();
            this.hrR.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
                @Override // com.baidu.live.view.input.d.a
                public void aaa() {
                    b.this.wJ(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public void aab() {
                    b.this.fg(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean ME() {
                    return b.this.KE();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Nt() {
                    return b.this.cdR();
                }

                @Override // com.baidu.live.view.input.d.a
                public int MK() {
                    return b.this.cdS();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean ML() {
                    x HR = b.this.ceG().hBP.HR();
                    if (HR == null || HR.aKQ == null) {
                        return false;
                    }
                    return HR.aKQ.isMysteriousMan;
                }
            });
        }
    }

    private void cdO() {
        this.hrS = new com.baidu.tieba.ala.liveroom.n.b(this.hru.pageContext);
        this.hrS.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.tieba.ala.liveroom.n.b.a
            public boolean ceK() {
                return b.this.cdB();
            }

            @Override // com.baidu.tieba.ala.liveroom.n.b.a
            public void onClose() {
                if (b.this.bsW != null) {
                    b.this.bsW.cx(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdP() {
        if (this.hss == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.hss = (com.baidu.live.guess.a) runTask.getData();
                this.hss.p(getActivity());
            } else {
                return;
            }
        }
        if (this.hss != null) {
            this.hss.eW(0);
            this.hss.f(ceG().hBP.HR());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nI(boolean z) {
        if (this.hrQ != null) {
            this.hrQ.ol(z);
        }
        if (this.hrS != null) {
            this.hrS.ol(z);
        }
        hsK = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cdQ() {
        return hsK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cdR() {
        x HR;
        if (ceG() == null || ceG().hBP == null || (HR = ceG().hBP.HR()) == null || HR.aKQ == null) {
            return false;
        }
        String str = HR.aKQ.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cdS() {
        x HR;
        if (ceG() != null && ceG().hBP != null && (HR = ceG().hBP.HR()) != null && !ListUtils.isEmpty(HR.aLb)) {
            for (AlaLiveMarkData alaLiveMarkData : HR.aLb) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cdT() {
        if (this.hrV == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, ceG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrV = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.hrV.setOtherParams(NL());
    }

    private void cdU() {
        if (this.hsa == null) {
            this.hsa = new com.baidu.tieba.ala.liveroom.turntable.e(ceG().pageContext.getPageActivity());
        }
    }

    private void cdV() {
        if (this.hsc == null) {
            this.hsc = new com.baidu.tieba.ala.liveroom.q.c(ceG().pageContext.getPageActivity());
        }
    }

    private void cdW() {
        if (this.hfG == null) {
            this.hfG = new com.baidu.live.ap.a(ceG().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.hsP == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.hsP = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.hsR);
            this.hsP.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hsP);
        }
        if (this.hsQ == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.hsQ = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.hsS);
            this.hsQ.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hsQ);
        }
        MessageManager.getInstance().registerListener(this.hsZ);
        MessageManager.getInstance().registerListener(this.hta);
        MessageManager.getInstance().registerListener(this.htc);
        MessageManager.getInstance().registerListener(this.hsW);
        MessageManager.getInstance().registerListener(this.hsX);
        MessageManager.getInstance().registerListener(this.gPf);
        MessageManager.getInstance().registerListener(this.hsY);
        MessageManager.getInstance().registerListener(this.gPs);
        MessageManager.getInstance().registerListener(this.htd);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gZv);
        MessageManager.getInstance().registerListener(this.gZs);
        MessageManager.getInstance().registerListener(this.bzb);
        MessageManager.getInstance().registerListener(this.hte);
        MessageManager.getInstance().registerListener(this.htf);
        MessageManager.getInstance().registerListener(this.htg);
        MessageManager.getInstance().registerListener(this.htk);
        MessageManager.getInstance().registerListener(this.htl);
        MessageManager.getInstance().registerListener(this.hsT);
        MessageManager.getInstance().registerListener(this.hsU);
        MessageManager.getInstance().registerListener(this.hsV);
        MessageManager.getInstance().registerListener(this.hfH);
        MessageManager.getInstance().registerListener(this.htm);
        MessageManager.getInstance().registerListener(this.hth);
        MessageManager.getInstance().registerListener(this.bsj);
        MessageManager.getInstance().registerListener(this.hti);
        MessageManager.getInstance().registerListener(this.htj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean KE() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(ceG().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ceG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(ceG().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.af.a.SE().bwi.aOv;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = ceG().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = ceG().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.ceG().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(ceG().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdX() {
        if (this.hrL != null && this.hrR != null) {
            this.hrL.MB().a(this.hrR.RH(), z.HJ().HL(), ceG().hBP.HR().mLiveInfo);
            nI(true);
            if (this.hsd == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, af.class, ceG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsd = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsd.hk("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cdY() {
        if (this.hrL != null && this.hrR != null) {
            this.hrL.MC().cr(false);
            if (com.baidu.live.af.a.SE().bwi != null) {
                this.aOK = com.baidu.live.af.a.SE().bwi.aOK;
            }
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cdZ();
                }
            }, this.aOK * 1000);
        }
    }

    protected void cdZ() {
        this.hrL.MC().h(ceG().hBP.HR());
        if (com.baidu.live.af.a.SE().bwi != null) {
            this.aOI = com.baidu.live.af.a.SE().bwi.aOI && !this.hrL.MC().OJ();
        }
        if (this.aOI) {
            if (this.mOrientation != 2) {
                this.hrL.MC().cr(true);
            } else {
                this.hrL.MC().cr(false);
            }
            this.hrL.MC().setClicked(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.leftMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.rightMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            if (this.hrZ != null) {
                layoutParams.addRule(3, this.hrZ.Ie().getId());
            }
            this.hrL.a(this.hsx, ceG().hBP.HR(), this.hrR.RH(), layoutParams);
            return;
        }
        this.hrL.MC().cs(false);
        this.hrL.MC().cr(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cea() {
        if (this.hrL != null) {
            this.hrL.MB().hide();
            nI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P(int i, int i2, int i3) {
        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKu != null && ceG().hBP.HR().mLiveInfo != null) {
            a(ceG().hBP.HR(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.d.k.class) != null && KE()) {
            if (xVar == null) {
                xVar = ceG().hBP.HR();
            }
            String valueOf = String.valueOf(xVar.aKu.userId);
            String str2 = xVar.aKu.userName;
            String valueOf2 = String.valueOf(xVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(xVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(xVar.mLiveInfo.feed_id);
            int i6 = xVar.aKQ.isBlock;
            String Ia = ac.Ia();
            String str3 = xVar.mLiveInfo.appId;
            boolean z2 = xVar.aKQ.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (xVar.mLiveInfo.live_type == 1 && xVar.mLiveInfo.screen_direction == 1 && com.baidu.live.af.a.SE().bwi.aNw) {
                z3 = true;
            }
            int i7 = -1;
            if (xVar.aKQ == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(xVar.aKQ.userId);
                boolean z4 = xVar.aKQ.isNewUser;
                i7 = xVar.aKQ.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.hsD != null && this.hsD.bkF != null && this.hsD.bkF.anchorId == xVar.aKu.userId) {
                z5 = this.hsD.bkK;
            }
            com.baidu.live.d.k kVar = new com.baidu.live.d.k(ceG().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Ia, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (xVar != null && xVar.mLiveInfo != null && xVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bk(xVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.gb(str);
            kVar.bi(z);
            if (com.baidu.tieba.ala.liveroom.v.b.cnq().bwr != null) {
                kVar.bj(com.baidu.tieba.ala.liveroom.v.b.cnq().bwr.aMl != 1);
            }
            bi LA = g.Ly().LA();
            if (LA == null || LA.aQY <= 0) {
                i5 = 1000;
            } else {
                i5 = LA.aQY;
            }
            kVar.dS(i5);
            boolean z6 = false;
            if (xVar != null && xVar.aKQ != null) {
                String str4 = xVar.aKQ.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.bl(z6);
            boolean z7 = true;
            bq bqVar = com.baidu.live.af.a.SE().bCb;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bqVar != null && bqVar.aRE != null && (!bqVar.aRE.aUl || !bqVar.aRE.aUm)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.bm(z7);
            if (xVar != null && xVar.aKT != null) {
                kVar.ga(xVar.aKT.toJsonString());
            }
            if (ceG() != null && ceG().hBP != null) {
                kVar.gc(ceG().hBP.cmC());
            }
            if (!this.hsI) {
                this.hsJ = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceb() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        fg(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(cb cbVar) {
        if (cbVar != null && KE()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(ceG().pageContext.getPageActivity(), cbVar.aSC, cbVar.liveId, cbVar.aLV)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && com.baidu.live.af.a.SE().bwi != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(ceG().pageContext.getPageActivity(), String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.mLiveInfo.user_id), com.baidu.live.af.a.SE().bwi.aPa, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, NobleDetailInfo nobleDetailInfo) {
        if (KE() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (xVar != null) {
                if (xVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(xVar.mLiveInfo.live_id));
                }
                if (xVar.aKu != null) {
                    hashMap.put("anchor_id", Long.valueOf(xVar.aKu.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", q.Ia());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put(Config.TRACE_VISIT_RECENT_DAY, Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(ceG().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cec() {
        if (this.hrR != null) {
            this.hrR.d(this.hru.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ced() {
        x HR = ceG().hBP.HR();
        LogManager.getCommonLogger().doClickQuickImHiLog((HR == null || HR.mLiveInfo == null) ? "" : HR.mLiveInfo.feed_id, NL());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ig(String str) {
        if (this.hrR != null) {
            this.hrR.hn(str);
        }
    }

    private void cee() {
        if ("home_rec_play".equals(ceG().fromType) || "frs_play".equals(ceG().fromType) || "frs_live_play".equals(ceG().fromType) || "person_play".equals(ceG().fromType) || "search".equals(ceG().fromType) || "person_attention".equals(ceG().fromType)) {
            com.baidu.live.c.AZ().aZ(true);
        } else {
            com.baidu.live.c.AZ().aZ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nJ(boolean z) {
        View Hn;
        if (this.hrN == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aWW = false;
            fVar.context = ceG().pageContext.getPageActivity();
            fVar.aXg = z;
            fVar.fromType = ceG().fromType;
            fVar.aXh = isVertical() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrN = (ad) runTask.getData();
            }
        }
        if (this.hrN != null && (Hn = this.hrN.Hn()) != null && this.hru.hBQ.indexOfChild(Hn) < 0) {
            this.hru.hBQ.addView(Hn, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cef() {
        View Ie;
        if (this.hrZ == null) {
            com.baidu.live.gift.ak akVar = new com.baidu.live.gift.ak();
            akVar.aWW = false;
            akVar.pageContext = ceG().pageContext;
            akVar.fromType = ceG().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrZ = (ag) runTask.getData();
            }
        }
        if (this.hrZ != null && (Ie = this.hrZ.Ie()) != null && ceG().hBQ.indexOfChild(Ie) < 0) {
            if (Ie.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ie.getParent()).removeView(Ie);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hrL != null && this.hrL.MC().OI()) {
                layoutParams.bottomMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hrL.MC().getView().getId());
            } else {
                layoutParams.bottomMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            ceG().hBQ.addView(Ie, layoutParams);
        }
    }

    protected void nK(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.hrZ != null) {
            View Ie = this.hrZ.Ie();
            if (Ie.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) Ie.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if (this.hrL != null && z) {
                layoutParams.bottomMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds190);
                layoutParams.addRule(2, this.hrL.MC().getView().getId());
            } else {
                layoutParams.bottomMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            Ie.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceg() {
        View HQ;
        if (this.hrO == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aWW = false;
            aVar.context = ceG().pageContext.getPageActivity();
            aVar.fromType = ceG().fromType;
            aVar.aWX = ceG().hBV;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrO = (ab) runTask.getData();
            }
        }
        if (this.hrO != null && (HQ = this.hrO.HQ()) != null && this.hsw != null && this.hsw.indexOfChild(HQ) < 0) {
            if (HQ.getParent() instanceof ViewGroup) {
                ((ViewGroup) HQ.getParent()).removeView(HQ);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.hsw.addView(HQ, this.hsw.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ceh() {
        CustomResponsedMessage runTask;
        if (this.hrM == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, ceG().pageContext)) != null) {
            this.hrM = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrM != null) {
            this.hrM.setOtherParams(this.otherParams);
            this.hrM.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void Nj() {
                    b.this.cer();
                }
            });
            this.hrM.a(ceG().hBP.HR(), false);
            View Da = this.hrM.Da();
            if (Da != null && this.hsx.indexOfChild(Da) < 0) {
                Resources resources = ceG().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(ceG().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hsx.addView(Da, layoutParams);
            }
        }
    }

    private void cei() {
        if (this.hrJ == null) {
            this.hrJ = new com.baidu.tieba.ala.liveroom.h.a(ceG().pageContext);
        }
        if (this.hsC != null) {
            this.hrJ.Im(this.hsC.user_id);
        }
        this.hrJ.aF(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nL(boolean z) {
        if (ceG() != null && !z) {
            if (this.hsf == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.m.a.class, ceG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsf = (com.baidu.live.m.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsf.d(this.hsw, cez());
            if (ceG().hBP != null) {
                this.hsf.a(ceG().hBP.HR());
            }
            this.hsf.setCanVisible(true);
            this.hsf.cd(true);
            this.hsf.a(ceG().hBP.bWZ());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cej() {
        if (ceG() != null) {
            if (this.hsg == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.w.a.class, ceG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsg = (com.baidu.live.w.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (ceG().hBP != null) {
                this.hsg.b(ceG().hBP.HR(), this.otherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ccY() {
        if (ceG() != null) {
            if (this.hqL == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ae.a.class, ceG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqL = (com.baidu.live.ae.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqL.setIsHost(false);
            this.hqL.a(cdC(), ceG().hBP.HR().aLu);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cek() {
        if (ceG() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.hsh == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.u.a.class, ceG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsh = (com.baidu.live.u.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsh.setIsHost(false);
            this.hsh.a(cdC(), ceG().hBP.HR());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cel() {
        if (this.hrC != null && ceG() != null && ceG().hBP != null) {
            this.hrC.d(this.hsw, ceG().hBP.HR());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cem() {
        if (ceG() != null) {
            if (this.hsj == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.l.a.class, ceG().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hsj = (com.baidu.live.l.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.hru.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.hsj.a(this.hsw, ceG().hBP.HR(), layoutParams, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cen() {
        if (ceG() != null) {
            if (this.hrU == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913264, com.baidu.live.y.b.class, ceG().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hrU = (com.baidu.live.y.b) runTask.getData();
                } else {
                    return;
                }
            }
            this.hrU.a(ceG().hBP.HR(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceo() {
        if (ceG() != null) {
            if (this.hsl == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913278, com.baidu.live.h.a.class, ceG().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsl = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsl.a(cdC(), ceG().hBP.HR());
        }
    }

    protected void cep() {
        if (this.hsk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.u.b.class, ceG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hsk = (com.baidu.live.u.b) runTask.getData();
            } else {
                return;
            }
        }
        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKu != null && ceG().hBP.HR().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(ceG().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(ceG().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.hsk.b(this.hsw, layoutParams, ceG().hBP.HR());
        }
    }

    private void ceq() {
        if (this.hrX == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, ceG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hrX = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKu != null && ceG().hBP.HR().mLiveInfo != null) {
            this.hrX.setHost(false);
            this.hrX.setOtherParams(NL());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.hrX.a(this.hsw, layoutParams, ceG().hBP.HR());
            this.hrX.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.guardclub.l
                public void LD() {
                    b.this.ceH();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x03ee, code lost:
        ceG().hBP.cmm();
     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x06f2, code lost:
        Ib(r3.giftId);
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
        if (this.hqL != null) {
            this.hqL.V(jSONObject2);
        }
        if (this.hrv == null || !this.hrv.V(jSONObject2)) {
            if (bVar.getMsgType() == 12 || bVar.getMsgType() == 13) {
                if (jSONObject2 != null) {
                    String optString2 = jSONObject2.optString("content_type");
                    if ("live_on_private".equals(optString2)) {
                        boolean z = jSONObject2.optInt("on_private", 0) == 1;
                        if (this.bsW != null) {
                            this.bsW.cz(z);
                        }
                        int optInt = jSONObject2.optInt("on_audio_private", -1);
                        if (optInt >= 0) {
                            wL(optInt);
                        }
                    } else if ("live_admin".equals(optString2)) {
                        long optLong = jSONObject2.optLong("user_id");
                        int optInt2 = jSONObject2.optInt("opt_type");
                        if (optInt2 == 1) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                ceG().hBP.HR().aKQ.isAdmin = 1;
                            }
                        } else if (optInt2 == 2) {
                            if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                                ceG().hBP.HR().aKQ.isAdmin = 0;
                                ceG().hBP.cmm();
                            }
                        } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ceG().hBP.HR().aKQ.isAdmin = 0;
                            ceG().hBP.cmm();
                        }
                    } else if ("task".equals(optString2)) {
                        dT(jSONObject2);
                    } else if ("live_net_status".equals(optString2)) {
                        int optInt3 = jSONObject2.optInt("net_status");
                        if (this.hrP != null && !ceG().hBU) {
                            String str = null;
                            if (optInt3 == 0) {
                                str = ceG().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                            } else if (optInt3 == 1) {
                                str = ceG().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                            } else if (optInt3 == 2) {
                                str = ceG().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                            }
                            if (str != null) {
                                if (bYQ()) {
                                    BdUtilHelper.getCustomToast().showToast(str, 1);
                                } else {
                                    this.hrP.c(ceG().hBO.getLiveContainerView(), str, 1);
                                }
                            }
                        }
                    } else if ("close_live".equals(optString2)) {
                        final int optInt4 = jSONObject2.optInt("close_type");
                        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                            @Override // java.lang.Runnable
                            public void run() {
                                if (b.this.bsW != null) {
                                    b.this.bsW.cy(optInt4 == 2);
                                }
                            }
                        });
                    } else if ("first_recharge_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                    } else if ("privilege_award_success".equals(optString2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.t.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                    } else if ("live_talk_ban".equals(optString2)) {
                        long optLong2 = jSONObject2.optLong("user_id");
                        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKQ != null && ceG().hBP.HR().aKQ.userId == optLong2) {
                            ceG().hBP.HR().aKQ.isBlock = 1;
                            cdp();
                        }
                    } else if ("live_talk_remove_ban".equals(optString2)) {
                        long optLong3 = jSONObject2.optLong("user_id");
                        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKQ != null && ceG().hBP.HR().aKQ.userId == optLong3) {
                            ceG().hBP.HR().aKQ.isBlock = 0;
                            cdp();
                        }
                    } else if ("live_talk_admin_ban".equals(optString2)) {
                        long optLong4 = jSONObject2.optLong("user_id");
                        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKQ != null && ceG().hBP.HR().aKQ.userId == optLong4) {
                            ceG().hBP.HR().aKQ.isUegBlock = 1;
                            cdp();
                        }
                    } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                        long optLong5 = jSONObject2.optLong("user_id");
                        if (ceG().hBP.HR() != null && ceG().hBP.HR().aKQ != null && ceG().hBP.HR().aKQ.userId == optLong5) {
                            ceG().hBP.HR().aKQ.isUegBlock = 0;
                            cdp();
                        }
                    } else if ("need_update_live_mark_info".equals(optString2)) {
                        if (ceG() != null && ceG().hBP != null && ceG().hBP.HR() != null && ceG().hBP.HR().aKQ != null) {
                            long j3 = ceG().hBP.HR().aKQ.userId;
                            if (j3 == jSONObject2.optLong("user_id")) {
                                ceG().hBP.cmm();
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
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, ceG().hBP.HR().aKQ));
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
                        com.baidu.live.data.a Nw = bVar.Nw();
                        if (Nw != null && ac.hg(str3)) {
                            ac.d(str3, 1L, "", "", Nw.userId, Nw.portrait, Nw.userName, "", "", false, "", "", "", false, false, true, -1L);
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
                        if (this.hsr != null) {
                            JSONObject jSONObject4 = new JSONObject();
                            try {
                                jSONObject4.put("source", "im_mix_room_close");
                                jSONObject4.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                                this.hsr.z("mix_room_close", jSONObject4);
                            } catch (JSONException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else if ("mysterious_man_activate".equals(optString2)) {
                        Ih(jSONObject2.optString("url"));
                    } else if ("mysterious_man_expired_remind".equals(optString2)) {
                        Ii(jSONObject2.optString("text"));
                    }
                }
            } else if (bVar.getMsgType() == 125) {
                if (this.hrG != null) {
                    this.hrG.M(bVar);
                }
            } else if (bVar.getMsgType() == 24 && jSONObject2 != null) {
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject2);
                if (ceG().hBP != null && ceG().hBP.HR() != null && ceG().hBP.HR().aLE && TextUtils.equals(cVar.bpz, "luckybag")) {
                    cVar.beN = "";
                }
                com.baidu.live.data.a Nw2 = bVar.Nw();
                boolean z2 = false;
                long j5 = 0;
                String str4 = null;
                if (ceG().hBP == null || ceG().hBP.HR() == null || ceG().hBP.HR().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                } else {
                    j5 = ceG().hBP.HR().mLiveInfo.live_id;
                    long j6 = ceG().hBP.HR().mLiveInfo.group_id;
                    long j7 = ceG().hBP.HR().aKu.userId;
                    str4 = ceG().hBP.HR().mLiveInfo.appId;
                    z2 = ceG().hBP.HR().mLiveInfo.isPubShow;
                    j = j7;
                    j2 = j6;
                }
                if (!cVar.bqJ || cVar.isDynamic) {
                    if (!TextUtils.isEmpty(cVar.bqE) && !TextUtils.isEmpty(cVar.bqG)) {
                        if (jSONObject2.optInt("flag_show") == 1) {
                            ac.b(cVar, Nw2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, "", "", bVar.getMsgId());
                            try {
                                JSONArray jSONArray = new JSONArray(cVar.bqG);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i2 = 0;
                                    while (true) {
                                        if (i2 >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.af.f.SV().ik(jSONArray.getJSONObject(i2).optString(LogConfig.LOG_GIFT_ID))) {
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
                        bVar.setHost(z2 && cVar.bqH);
                        ac.b(cVar, Nw2, String.valueOf(j5), String.valueOf(j2), false, String.valueOf(j), str4, (cVar.bqH || cVar.bqJ || cVar.bqI) ? false : true, true, "", "", bVar.getMsgId());
                        Ib(cVar.giftId);
                    }
                    if (!UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT.equals(cVar.contentType)) {
                        com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar2.bqF = cVar.bqF;
                        cVar2.liveId = j5;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hsr = dVar;
    }

    protected void Ib(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cer() {
        if (ces()) {
            BdUtilHelper.hideSoftKeyPad(ceG().pageContext.getPageActivity(), ceG().hBO.getLiveContainerView());
            cdA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ces() {
        if (cdz() == null || cdz().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(x xVar) {
        CustomResponsedMessage runTask;
        ceG().hBQ.setOnTouchListener(this.htn);
        ceA();
        ceB();
        ceC();
        cei();
        ceq();
        cep();
        if (this.hrE != null && ceG().hBP.HR() != null && ceG().hBP.HR().mLiveInfo != null) {
            this.hrE.cN(ceG().hBP.HR().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.hrK != null) {
            this.hrK.h(ceG().hBP.HR());
        }
        if (this.hrI != null) {
            this.hrI.f(ceG().hBP.HR());
        }
        if (this.hrQ != null) {
            this.hrQ.c(ceG().hBP.HR(), NL());
        }
        if (this.hrR != null) {
            this.hrR.b(ceG().hBP.HR(), NL());
        }
        if (this.hrS != null) {
            this.hrS.c(ceG().hBP.HR(), NL());
        }
        if (this.hst != null) {
            this.hst.f(ceG().hBP.HR());
        }
        if (ceG().hBQ != null) {
            ceG().hBQ.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.35
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.ces() && b.this.hrD != null) {
                        b.this.hrD.oD(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.hrD != null) {
                        b.this.hrD.oD(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Pz() {
                    if (b.this.hsO == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.hsO) {
                        if (bVar.Pz()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            ceG().hBQ.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.36
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.hsd == null && (runTask = MessageManager.getInstance().runTask(2913165, af.class, ceG().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hsd = (af) runTask.getData();
        }
        if (this.mHandler != null && ceI()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.37
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.ceI()) {
                        b.this.wL(b.this.ceG().hBP.HR().mLiveInfo.isAudioOnPrivate);
                    }
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cet() {
        if (this.hst == null && ceG() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.t.a.class, ceG().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hst = (com.baidu.live.t.a) runTask.getData();
                this.hst.p(ceG().hBQ);
                this.hst.b(ceG().hBP.HR());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ceu() {
        x HR;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (ceG() != null && ceG().hBP != null && (HR = ceG().hBP.HR()) != null && HR.mLiveInfo != null && !HR.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) ceG().hBO) != null) {
            if (this.hsm == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.aa.a.class, ceG().pageContext)) != null && runTask.getData() != null) {
                this.hsm = (com.baidu.live.aa.a) runTask.getData();
            }
            if (this.hsm != null) {
                this.hsm.o(HR);
                this.hsm.a(this.hto);
                this.hsm.a(viewGroup, this.hsw);
                a(this.hsm.RY());
                a(this.hsm.RZ());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.hsN == null) {
            this.hsN = new ArrayList();
        }
        if (!this.hsN.contains(dVar)) {
            this.hsN.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.hsN != null && this.hsN.contains(dVar)) {
            this.hsN.remove(dVar);
        }
    }

    protected void cev() {
        if (this.hsN != null) {
            this.hsN.clear();
            this.hsN = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsN == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.hsN.iterator();
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
        if (this.hsO == null) {
            this.hsO = new ArrayList();
        }
        if (!this.hsO.contains(bVar)) {
            this.hsO.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hsO != null && this.hsO.contains(bVar)) {
            this.hsO.remove(bVar);
        }
    }

    protected void cew() {
        if (this.hsO != null) {
            this.hsO.clear();
            this.hsO = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hsO == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hsO.iterator();
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
    public void cex() {
        if (this.hse == null && this.hso != null && this.hso.aRO && ceG() != null && ceG().hBP != null && ceG().hBP.HR() != null) {
            this.hse = new com.baidu.tieba.ala.liveroom.h.e(ceG().pageContext, this.hso);
            this.hse.J(ceG().hBP.HR());
            if (this.hso.aRR == 1) {
                if (this.hrL != null) {
                    this.hsF = true;
                }
            } else if (this.hso.aRR == 2) {
                a(ceG().hBP.HR(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cey() {
        CustomResponsedMessage runTask;
        if (ceG() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, ceG().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.ab.a)) {
            this.hsp = (com.baidu.live.ab.a) runTask.getData();
            this.hsp.s(cdC());
            if (ceG().hBP != null) {
                this.hsG = this.hsp.p(ceG().hBP.HR());
            }
            this.hsp.setCanVisible(!this.hsA);
        }
    }

    private ViewGroup.LayoutParams cez() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = ceG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int O(boolean z, boolean z2) {
        Rect rect = new Rect();
        ceG().hBO.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(ceG().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(ceG().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? ceG().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + ceG().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void ceA() {
        if (this.hrD != null) {
            this.hrD.aM(ceG().hBQ);
        }
    }

    private void ceB() {
        if (this.hrE != null) {
            this.hrE.aP(ceG().hBQ);
        }
    }

    private void ceC() {
        if (this.hrH == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ai.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hrH = (com.baidu.live.ai.a) runTask.getData();
            }
            ceD();
        }
    }

    private void dT(JSONObject jSONObject) {
        if (this.hrH != null) {
            if (this.hrA != null) {
                this.hrH.cY(this.hrA.ciB() ? false : true);
            } else {
                this.hrH.cY(true);
            }
            this.hrH.Z(jSONObject);
        }
    }

    private void ceD() {
        if (this.hrH != null && ceG().hBP.HR() != null && ceG().hBP.HR().aLf != null) {
            if (this.hrA != null) {
                this.hrH.cY(this.hrA.ciB() ? false : true);
            } else {
                this.hrH.cY(true);
            }
            this.hrH.j(ceG().hBP.HR());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(x xVar) {
        if (xVar != null) {
            if (this.hrE != null && xVar.mLiveInfo != null) {
                this.hrE.cN(xVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.hrW != null) {
                this.hrW.i(xVar);
            }
            ceD();
            if (this.hrJ != null && xVar.aKu != null) {
                this.hrJ.Im(String.valueOf(xVar.aKu.userId));
            }
            if (this.hrw != null) {
                this.hrw.a(xVar);
            }
            if (this.hrO != null && xVar.mLiveInfo != null) {
                this.hrO.a(xVar.mLiveInfo, xVar.aKu);
            }
            if (this.hrM != null) {
                this.hrM.a(xVar);
            }
            if (this.hsp != null) {
                this.hsG = this.hsp.p(xVar);
            }
            if (this.hsf != null) {
                this.hsf.a(xVar);
            }
            if (this.hsh != null) {
                this.hsh.a(xVar);
            }
            if (this.hsl != null) {
                this.hsl.a(xVar);
            }
            if (this.hsg != null) {
                this.hsg.a(xVar);
            }
            if (this.hqL != null) {
                this.hqL.a(xVar);
            }
            if (this.hsj != null) {
                this.hsj.a(xVar);
            }
            if (this.hsi != null) {
                this.hsi.a(xVar);
            }
            if (this.hsk != null) {
                this.hsk.a(xVar);
            }
            if (this.hss != null) {
                this.hss.b(xVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wL(int i) {
        if (!ceG().hBU) {
            if (this.hsy < 0 && i == 0) {
                this.hsy = i;
            } else if (this.hsy != i) {
                if (i == 1) {
                    if (!this.hrP.xA(2)) {
                        String string = ceG().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(ceG().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.hrP.a(ceG().hBO.getLiveContainerView(), string, 2, 5000);
                        }
                    }
                } else {
                    String string2 = ceG().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.hrP.xB(2);
                    this.hrP.xB(3);
                    if (bYQ()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.hrP.c(ceG().hBO.getLiveContainerView(), string2, 3);
                    }
                }
                this.hsy = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cC(boolean z) {
        super.cC(z);
        if (z) {
            ceE();
        }
        if (this.hrW != null) {
            this.hrW.LE();
        }
        if (this.hrI != null) {
            this.hrI.LE();
        }
        if (this.hrG != null) {
            this.hrG.coE();
        }
        if (this.hry != null) {
            this.hry.DC();
        }
        if (this.hrA != null) {
            this.hrA.onDestroy();
        }
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hrN != null) {
            View Hn = this.hrN.Hn();
            if (Hn != null && Hn.getParent() != null) {
                ((ViewGroup) Hn.getParent()).removeView(Hn);
            }
            this.hrN.onDestroy();
            this.hrN = null;
        }
        if (this.hrM != null) {
            this.hrM.a((a.InterfaceC0186a) null);
            this.hrM.Dc();
        }
        if (this.hrP != null) {
            this.hrP.DC();
        }
        this.hsy = -1;
        if (this.hrJ != null) {
            this.hrJ.DC();
            this.hrJ.onDestroy();
        }
        if (this.hrB != null) {
            this.hrB.coC();
        }
        if (this.hrC != null) {
            this.hrC.ccL();
            this.hrC.Id();
        }
        if (this.hrD != null) {
            this.hrD.Id();
        }
        if (this.hrK != null) {
            this.hrK.Id();
        }
        if (this.hrQ != null) {
            this.hrQ.LE();
        }
        if (this.hrR != null) {
            this.hrR.Id();
        }
        if (this.hrS != null) {
            this.hrS.onDestroy();
        }
        if (this.hrV != null) {
            this.hrV.onDestory();
        }
        if (this.hrY != null) {
            this.hrY.Bf();
        }
        if (this.hrX != null) {
            this.hrX.Bf();
        }
        if (this.hsk != null) {
            this.hsk.Bf();
        }
        if (this.hse != null) {
            this.hse.onDestroy();
        }
        if (this.hsa != null) {
            this.hsa.Id();
        }
        if (this.hfG != null) {
            this.hfG.Id();
        }
        if (this.hsb != null) {
            this.hsb.Id();
        }
        if (this.hsd != null) {
            this.hsd.Id();
        }
        if (this.hrz != null) {
            this.hrz.onDestory();
        }
        if (this.hsp != null) {
            this.hsp.Id();
        }
        if (this.hsf != null) {
            this.hsf.Bf();
            this.hsf.setCanVisible(false);
        }
        if (this.hsh != null) {
            this.hsh.Bf();
        }
        if (this.hsl != null) {
            this.hsl.Bf();
        }
        if (this.hsg != null) {
            this.hsg.Bf();
        }
        if (this.hqL != null) {
            this.hqL.Bf();
        }
        if (this.hsi != null) {
            this.hsi.Bf();
        }
        if (this.hsc != null) {
            this.hsc.Id();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
        }
        if (this.hsm != null) {
            this.hsm.DC();
            b(this.hsm.RY());
            b(this.hsm.RZ());
        }
        if (this.hsn != null) {
            this.hsn.Bf();
        }
        if (this.hsj != null) {
            this.hsj.Bf();
        }
        if (this.hrL != null) {
            this.hrL.MC().Bf();
        }
        if (this.hss != null) {
            this.hss.LE();
        }
        if (this.hst != null) {
            this.hst.LE();
            this.hst = null;
        }
        ShowUtil.windowCount = 0;
        cev();
        cew();
    }

    private void ceE() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = ceG().hBQ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = ceG().hBQ.getChildAt(i);
            if (childAt != this.hsw && childAt != this.hsx) {
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
        if (this.hsw != null) {
            this.hsw.removeAllViews();
        }
        if (this.hsx != null) {
            this.hsx.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, x xVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(x xVar) {
        View Da;
        View Hn;
        if (this.hrN != null && (Hn = this.hrN.Hn()) != null && Hn.getParent() != null) {
            ((ViewGroup) Hn.getParent()).removeView(Hn);
        }
        if (this.hrM != null && (Da = this.hrM.Da()) != null && Da.getParent() != null) {
            ((ViewGroup) Da.getParent()).removeView(Da);
        }
        if (this.hrA != null) {
            this.hrA.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Pv() {
        if (this.hrF == null || !this.hrF.ciG()) {
            if (this.hrA == null || !this.hrA.aI(ceG().hBO.getLiveContainerView())) {
                if (this.hrD != null) {
                    this.hrD.bZw();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.hrT != null && this.hrT.cip()) {
                    this.hrT.ciy();
                    return false;
                } else if (this.hrS == null || !this.hrS.TQ()) {
                    if (this.hsu == null || !this.hsu.TQ()) {
                        if (this.hrU == null || !this.hrU.RS()) {
                            cee();
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
    public void RR() {
        Pu();
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cA(boolean z) {
        super.cA(z);
        if (this.hrW != null) {
            this.hrW.release();
        }
        if (this.hrI != null) {
            this.hrI.onDestroy();
        }
        if (this.hrH != null) {
            this.hrH.onDestroy();
            this.hrH = null;
        }
        if (this.hrG != null) {
            this.hrG.coE();
        }
        if (this.hrN != null) {
            this.hrN.onDestroy();
            this.hrN = null;
        }
        if (this.hrO != null) {
            this.hrO.onDestroy();
            this.hrO = null;
        }
        if (this.hrP != null) {
            this.hrP.onDestroy();
        }
        if (this.hry != null) {
            this.hry.onDestroy();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
            this.hrZ = null;
        }
        if (this.hrM != null) {
            this.hrM.a((a.InterfaceC0186a) null);
            this.hrM.release();
            this.hrM = null;
        }
        if (this.hrQ != null) {
            this.hrQ.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.hrQ.release();
        }
        if (this.hrR != null) {
            this.hrR.a(null);
            this.hrR.release();
        }
        if (this.hrS != null) {
            this.hrS.a((b.a) null);
            this.hrS.onDestroy();
        }
        if (this.hrX != null) {
            this.hrX.onDestroy();
        }
        if (this.hrY != null) {
            this.hrY.onDestroy();
        }
        if (this.hrV != null) {
            this.hrV.onDestory();
        }
        if (this.hsk != null) {
            this.hsk.onDestroy();
        }
        if (this.hse != null) {
            this.hse.onDestroy();
        }
        if (this.hsa != null) {
            this.hsa.release();
        }
        if (this.hfG != null) {
            this.hfG.release();
        }
        if (this.hsc != null) {
            this.hsc.release();
        }
        if (this.hsb != null) {
            this.hsb.release();
        }
        if (this.hsd != null) {
            this.hsd.release();
        }
        if (this.hrz != null) {
            this.hrz.onDestory();
        }
        if (this.hsp != null) {
            this.hsp.release();
        }
        if (this.hsf != null) {
            this.hsf.onDestroy();
        }
        if (this.hsh != null) {
            this.hsh.onDestroy();
        }
        if (this.hsl != null) {
            this.hsl.onDestroy();
        }
        if (this.hsg != null) {
            this.hsg.onDestroy();
        }
        if (this.hqL != null) {
            this.hqL.onDestroy();
        }
        if (this.hsi != null) {
            this.hsi.onDestroy();
        }
        if (this.hrD != null) {
            this.hrD.Id();
        }
        if (this.hsj != null) {
            this.hsj.onDestroy();
        }
        if (this.hss != null) {
            this.hss.onDestroy();
        }
        if (this.hst != null) {
            this.hst.onDestory();
        }
        if (this.hrU != null) {
            this.hrU.onDestroy();
        }
        if (this.hsm != null) {
            this.hsm.onDestroy();
            b(this.hsm.RY());
            b(this.hsm.RZ());
        }
        cev();
        cew();
        MessageManager.getInstance().unRegisterListener(this.hsT);
        MessageManager.getInstance().unRegisterListener(this.hsU);
        MessageManager.getInstance().unRegisterListener(this.hsV);
        MessageManager.getInstance().unRegisterListener(this.hsZ);
        MessageManager.getInstance().unRegisterListener(this.hta);
        MessageManager.getInstance().unRegisterListener(this.htc);
        MessageManager.getInstance().unRegisterListener(this.hsW);
        MessageManager.getInstance().unRegisterListener(this.hsX);
        MessageManager.getInstance().unRegisterListener(this.gPf);
        MessageManager.getInstance().unRegisterListener(this.hsY);
        MessageManager.getInstance().unRegisterListener(this.gPs);
        MessageManager.getInstance().unRegisterListener(this.htd);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gZv);
        MessageManager.getInstance().unRegisterListener(this.gZs);
        MessageManager.getInstance().unRegisterListener(this.bzb);
        MessageManager.getInstance().unRegisterListener(this.hte);
        MessageManager.getInstance().unRegisterListener(this.htf);
        MessageManager.getInstance().unRegisterListener(this.htg);
        MessageManager.getInstance().unRegisterListener(this.htk);
        MessageManager.getInstance().unRegisterListener(this.htl);
        MessageManager.getInstance().unRegisterListener(this.hfH);
        MessageManager.getInstance().unRegisterListener(this.htm);
        MessageManager.getInstance().unRegisterListener(this.hth);
        MessageManager.getInstance().unRegisterListener(this.bsj);
        MessageManager.getInstance().unRegisterListener(this.hti);
        MessageManager.getInstance().unRegisterListener(this.htj);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.hrQ != null) {
            this.hrQ.ok(false);
        }
        if (this.hrS != null) {
            this.hrS.ok(false);
        }
        cdA();
        if (this.hrW != null) {
            this.hrW.onPause();
        }
        if (this.hsa != null) {
            this.hsa.pause();
        }
        if (this.hfG != null) {
            this.hfG.pause();
        }
        if (this.hsc != null) {
            this.hsc.pause();
        }
        if (this.hrZ != null) {
            this.hrZ.onPause();
        }
        if (this.hsj != null) {
            this.hsj.onPause();
        }
        if (this.hsl != null) {
            this.hsl.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hsJ = false;
        if (this.hsB && this.hsC != null) {
            a(this.hsC);
            this.hsB = false;
        }
        if (this.hrQ != null) {
            this.hrQ.ok(true);
        }
        if (this.hrS != null) {
            this.hrS.ok(true);
        }
        if (this.hrW != null) {
            this.hrW.onResume();
        }
        if (this.hsa != null) {
            this.hsa.resume();
        }
        if (this.hfG != null) {
            this.hfG.resume();
        }
        if (this.hsc != null) {
            this.hsc.resume();
        }
        if (this.hrZ != null) {
            this.hrZ.onResume();
        }
        if (this.hsj != null) {
            this.hsj.onResume();
        }
        if (this.hsl != null) {
            this.hsl.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azK() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hsm != null && this.hsm.isOpen()) {
            this.hsm.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            azK();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    P(-1, -1, -1);
                    return;
                }
                return;
            }
            azK();
        } else if (i == 25034) {
            ceb();
        } else if (i == 25043) {
            if (i2 == -1) {
                ceH();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.q.a.K(ceG().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.q.a.K(ceG().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void e(boolean z, int i) {
        this.hsA = z;
        if (this.hst != null) {
            this.hst.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ceF() {
        return (ceG().hBP.HR() == null || ceG().hBP.HR().mLiveInfo == null || ceG().hBP.HR().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.hrA != null) {
                this.hrA.C(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.hrS != null) {
            this.hrS.bnP();
        }
        if (this.hrz != null) {
            this.hrz.bnP();
        }
        if (this.hsm != null) {
            this.hsm.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.hru = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a ceG() {
        return this.hru;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceH() {
        String Lz = g.Ly().Lz();
        if (!TextUtils.isEmpty(Lz)) {
            try {
                P(-1, Integer.parseInt(Lz), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                P(-1, -1, -1);
            }
        }
    }

    public boolean ff(int i) {
        if (1 == i) {
            if (cdz() != null) {
                cdz().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.hsA) {
                return false;
            }
            return this.hrA == null || !this.hrA.ciB();
        } else if (3 == i) {
            if (ceG().hBQ != null) {
                ceG().hBQ.setEnabled(false);
                if (this.bsW != null) {
                    this.bsW.e(!ceG().hBS, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void wJ(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void fg(int i) {
        if (3 == i) {
            ceG().hBQ.setEnabled(true);
            if (this.bsW != null) {
                this.bsW.e(!ceG().hBS, true);
            }
            if (this.hrH != null) {
                this.hrH.cY(true);
            }
        } else if (2 == i && this.hrG != null) {
            this.hrG.oM(true);
        }
    }

    public String NL() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hrM != null) {
            this.hrM.setOtherParams(str);
        }
        if (this.hrW != null) {
            this.hrW.hV(str);
        }
    }

    private boolean bYQ() {
        return ceG().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.gtp = alaLastLiveroomInfo;
    }

    public void ct(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(ceG().pageContext.getPageActivity(), this.hsH);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }

    private void Ih(String str) {
        if (this.hfG == null) {
            this.hfG = new com.baidu.live.ap.a(ceG().pageContext.getPageActivity());
        }
        com.baidu.live.ap.c cVar = new com.baidu.live.ap.c();
        cVar.url = str;
        cVar.isFullScreen = true;
        this.hfG.a(cVar);
    }

    private void Ii(String str) {
        Activity pageActivity = ceG().pageContext.getPageActivity();
        final com.baidu.live.view.c cVar = new com.baidu.live.view.c(pageActivity);
        cVar.setCancelable(true);
        cVar.setCanceledOnTouchOutside(true);
        cVar.setTitleVisible(false);
        cVar.ZE();
        cVar.o("", str, pageActivity.getString(a.h.sdk_know), "");
        cVar.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.39
            @Override // com.baidu.live.view.c.a
            public void Sw() {
                cVar.dismiss();
            }

            @Override // com.baidu.live.view.c.a
            public void Sx() {
                cVar.dismiss();
            }
        });
        cVar.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceI() {
        return (ceG().hBP.HR() == null || ceG().hBP.HR().mLiveInfo == null || ceG().hBP.HR().mLiveInfo.isAudioOnPrivate != 1) ? false : true;
    }
}
