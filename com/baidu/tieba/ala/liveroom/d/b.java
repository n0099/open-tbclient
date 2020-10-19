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
import com.baidu.live.b.i;
import com.baidu.live.b.s;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ad;
import com.baidu.live.data.am;
import com.baidu.live.data.av;
import com.baidu.live.data.ba;
import com.baidu.live.data.bj;
import com.baidu.live.data.bk;
import com.baidu.live.data.br;
import com.baidu.live.data.u;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.f;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.gift.x;
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
import com.baidu.live.personmanager.b;
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
    public static boolean gFM;
    protected AlaLastLiveroomInfo fMS;
    private com.baidu.tieba.ala.liveroom.data.a gEE;
    protected com.baidu.tieba.ala.liveroom.operation.a gEF;
    protected com.baidu.live.h.a gEG;
    protected com.baidu.tieba.ala.liveroom.share.c gEH;
    protected com.baidu.tieba.ala.liveroom.s.b gEI;
    protected com.baidu.tieba.ala.liveroom.guide.c gEJ;
    protected com.baidu.tieba.ala.liveroom.watermark.a gEK;
    protected com.baidu.tieba.ala.liveroom.b.b gEL;
    protected com.baidu.tieba.ala.liveroom.praise.a gEM;
    protected com.baidu.tieba.ala.liveroom.sticker.a gEN;
    protected com.baidu.tieba.ala.liveroom.guide.d gEO;
    protected com.baidu.tieba.ala.liveroom.x.a gEP;
    protected com.baidu.live.z.a gEQ;
    protected com.baidu.live.z.d gER;
    private com.baidu.tieba.ala.liveroom.h.a gES;
    private m gET;
    k gEU;
    com.baidu.live.im.b.a gEV;
    protected x gEW;
    protected v gEX;
    protected com.baidu.tieba.ala.liveroom.tippop.a gEY;
    private com.baidu.tieba.ala.liveroom.guideim.b gEZ;
    protected RelativeLayout gFA;
    protected boolean gFC;
    protected am gFF;
    protected GuardClubInfoHttpResponseMessage gFG;
    boolean gFH;
    boolean gFI;
    boolean gFJ;
    public boolean gFK;
    public boolean gFL;
    protected com.baidu.tieba.ala.liveroom.u.b gFN;
    protected e gFO;
    protected List<com.baidu.live.liveroom.g.d> gFP;
    protected List<com.baidu.live.liveroom.g.b> gFQ;
    CustomMessageTask gFR;
    CustomMessageTask gFS;
    protected com.baidu.live.view.input.c gFa;
    com.baidu.tieba.ala.liveroom.o.b gFb;
    protected com.baidu.tieba.ala.liveroom.guide.a gFc;
    private com.baidu.live.guardclub.k gFd;
    protected com.baidu.live.j.b gFe;
    protected h gFf;
    protected j gFg;
    protected z gFh;
    protected com.baidu.tieba.ala.liveroom.turntable.e gFi;
    protected com.baidu.tieba.ala.liveroom.m.b gFj;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gFk;
    protected com.baidu.tieba.ala.liveroom.r.c gFl;
    private y gFm;
    protected com.baidu.tieba.ala.liveroom.h.e gFn;
    protected com.baidu.live.i.a gFo;
    protected com.baidu.live.p.a gFp;
    protected com.baidu.live.p.b gFq;
    protected com.baidu.live.t.a gFr;
    protected com.baidu.tieba.ala.liveroom.exclusive.b gFs;
    protected bk gFt;
    protected com.baidu.live.u.a gFu;
    protected com.baidu.tieba.ala.liveroom.f.a gFv;
    protected com.baidu.live.af.a gFw;
    protected com.baidu.tieba.ala.player.d gFx;
    private com.baidu.live.guess.a gFy;
    protected RelativeLayout gFz;
    protected String otherParams;
    private int gFB = -1;
    protected int mOrientation = 0;
    protected boolean gFD = false;
    protected boolean gFE = false;
    CustomMessageTask.CustomRunnable<Object> gFT = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: bTn */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> gFU = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener gFV = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ad adVar;
            if ((customResponsedMessage.getData() instanceof ad) && (adVar = (ad) customResponsedMessage.getData()) != null) {
                b.this.a(adVar.aIT, adVar.aIP, adVar.aIQ, adVar.aIR, adVar.aIS);
            }
        }
    };
    private CustomMessageListener gFW = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.uO(7);
        }
    };
    private CustomMessageListener gFX = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bSM();
        }
    };
    private CustomMessageListener gFY = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bTl().gON.Gm().aHD.userId);
            com.baidu.live.view.a.SY().a(valueOf, new com.baidu.live.data.e(b.this.bTl().gON.Gm().aHD.portrait, valueOf, true, b.this.bTl().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gFZ = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof u) && b.this.gEH != null) {
                b.this.gEH.c((u) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bnL = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gEU != null) {
                b.this.gEU.g(com.baidu.live.gift.u.Gg().Gi());
            }
        }
    };
    private CustomMessageListener gGa = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gEE.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.Ha(str);
            }
        }
    };
    private CustomMessageListener gGb = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bTl().pageContext.getPageActivity());
            } else if (b.this.gEH != null) {
                b.this.gEH.c(b.this.bTl().gON.Gm(), false);
            }
        }
    };
    private CustomMessageListener gGc = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof am) {
                    b.this.gFE = true;
                    b.this.gFF = (am) data;
                    b.this.b(b.this.gFF);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gGd = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bTl().gON.Gm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bTl().gON.Gm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bTl().gON.Gm().aHD.userId);
                    if (b.this.gEI == null) {
                        b.this.gEI = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    b.this.gEI.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gEI.a(b.this.gGe);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.InterfaceC0192b gGe = new b.InterfaceC0192b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.b.InterfaceC0192b
        public void NO() {
            if (b.this.bTl().gON.Gm() != null && b.this.bTl().gON.Gm().aIf != null) {
                b.this.bTl().gON.Gm().aIf.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener gGf = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gFe != null) {
                    b.this.gFe.x(aVar);
                }
                if (b.this.gFs != null) {
                    b.this.gFs.y(aVar);
                }
                b.this.r(aVar);
            }
        }
    };
    CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener gGg = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.gFH = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gFb != null) {
                b.this.gFb.Gz();
            }
        }
    };
    HttpMessageListener gpi = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bdN) != null && b.this.gFd != null && b.this.bTl() != null && b.this.bTl().gON != null) {
                int[] iArr = new int[2];
                b.this.gFz.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gFd.a(b.this.gFz, layoutParams, aVar, b.this.bTl().gON.Gm());
                com.baidu.live.n.a.aB(aVar.liveId + "", "guard_club_join");
                com.baidu.live.m.a.b(b.this.bTl().gON.Gm().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gpf = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bTl() != null && b.this.bTl().gON != null && b.this.bTl().gON.Gm() != null && guardClubInfoHttpResponseMessage.bdN != null) {
                    if (guardClubInfoHttpResponseMessage.bdN.anchorId == b.this.bTl().gON.Gm().aHD.userId) {
                        b.this.gFG = guardClubInfoHttpResponseMessage;
                        if (b.this.gFG.bdQ && com.baidu.live.guardclub.e.JL() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.JL().ah(b.this.bTl().gON.Gm().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gGh = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof br) {
                b.this.a((br) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gGi = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                Log.d("XXXX", "onMessage: ");
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (b.this.gFj != null) {
                    b.this.gFj.eo(bVar.url, bVar.aGJ);
                }
            }
        }
    };
    private CustomMessageListener gGj = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.u(b.this.bTl().gON.Gm());
        }
    };
    private CustomMessageListener gGk = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gFo != null) {
                b.this.gFo.Kd();
            }
        }
    };
    private CustomMessageListener gGl = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gFh != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) b.this.gFh).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gGm = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bTl().gON.Gm(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gGn = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.af.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.gFw == null) {
                b.this.gFw = new com.baidu.live.af.a(b.this.bTl().pageContext.getPageActivity());
            }
            b.this.gFw.a((com.baidu.live.af.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener gGo = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.bTl().pageContext.getPageActivity() != null) {
                com.baidu.live.m.a.t(b.this.bTl().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener gGp = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bSX();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.t.b gGq = new com.baidu.live.t.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        @Override // com.baidu.live.t.b
        public boolean Oo() {
            if (b.this.bTl().gOO != null) {
                if (b.this.bTl().gOO.getKeyboardVisibility()) {
                    return false;
                }
                if (!b.this.bTl().gOO.ccs()) {
                    b.this.gFr.close();
                    return false;
                } else if (b.this.bTl().gOO.getScrollX() != 0) {
                    b.this.gFr.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void a(am amVar);

    protected abstract void b(am amVar);

    public abstract boolean bRF();

    protected abstract void bSb();

    protected abstract View bSk();

    public abstract boolean bSl();

    protected abstract boolean bSm();

    protected abstract ViewGroup bSn();

    protected abstract ViewGroup bSo();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bk bkVar) {
        this.gFt = bkVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gFz = (RelativeLayout) bTl().gOO.findViewById(a.g.ala_live_header_view);
        this.gFA = (RelativeLayout) bTl().gOO.findViewById(a.g.ala_live_footer_view);
        Hb();
        registerListener();
    }

    public void bSt() {
    }

    private void Hb() {
        if (this.gEH == null) {
            this.gEH = new com.baidu.tieba.ala.liveroom.share.c(bTl().pageContext);
        }
        this.gEP = new com.baidu.tieba.ala.liveroom.x.a(bTl().pageContext, this);
        this.gEL = new com.baidu.tieba.ala.liveroom.b.b(bTl().pageContext, false);
        this.gEM = new com.baidu.tieba.ala.liveroom.praise.a(bTl().pageContext);
        this.gEN = new com.baidu.tieba.ala.liveroom.sticker.a(bTl().pageContext);
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
                this.gEO = new com.baidu.tieba.ala.liveroom.guide.d(bTl().pageContext);
            }
        }
        this.gEY = new com.baidu.tieba.ala.liveroom.tippop.a(bTl().pageContext, this);
        bSx();
        bSz();
        bSA();
        bSB();
        bSG();
        bSH();
        bSI();
        bSu();
        bSw();
        bSv();
        bSJ();
    }

    private void bSu() {
        this.gFj = new com.baidu.tieba.ala.liveroom.m.b(bTl().pageContext.getPageActivity());
    }

    private void bSv() {
        CustomResponsedMessage runTask;
        if (this.gER == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.z.d.class, bTl().pageContext)) != null && runTask.getData() != null) {
            this.gER = (com.baidu.live.z.d) runTask.getData();
        }
    }

    private void bSw() {
        CustomResponsedMessage runTask;
        if (this.gFe == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.j.b.class, bTl().pageContext)) != null && runTask.getData() != null) {
            this.gFe = (com.baidu.live.j.b) runTask.getData();
            this.gFe.c(bTl().pageContext);
            this.gFe.Mz().setTargetView(this.gFA);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.gFv == null) {
            this.gFv = new com.baidu.tieba.ala.liveroom.f.a(bTl().pageContext);
            this.gFv.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.gFv.a(bTl().gON.Gm(), alaLastLiveroomInfo);
        this.gFv.av(this.gFA);
    }

    private void bSx() {
        this.gET = new m();
    }

    public void mn(boolean z) {
        this.gFC = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSy() {
        u Gm = bTl().gON.Gm();
        boolean z = com.baidu.live.x.a.OS().blo.aLE;
        if (Gm.mLiveInfo != null && Gm.mLiveInfo.mAlaLiveSwitchData != null && Gm.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Gm.aIr ? z : false;
        if (z2) {
            if (this.gEG == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bTl().pageContext);
                if (runTask != null) {
                    this.gEG = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gEG != null) {
                this.gEG.eE(1);
                View view = this.gEG.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bTl().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bTl().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.gFz.addView(view, layoutParams);
                    if (z2) {
                        this.gEG.a(Gm);
                    }
                }
            }
        }
    }

    private void bSz() {
        this.gEZ = new com.baidu.tieba.ala.liveroom.guideim.b(bTl().pageContext);
        this.gEZ.c(this.gFA, bRF());
        this.gEZ.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean KS() {
                return b.this.IS();
            }
        });
    }

    private void bSA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bTl().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gFa = (com.baidu.live.view.input.c) runTask.getData();
            this.gFa.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
                @Override // com.baidu.live.view.input.c.a
                public void Ts() {
                    b.this.uO(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void Tt() {
                    b.this.eM(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean KS() {
                    return b.this.IS();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Ls() {
                    return b.this.bSE();
                }

                @Override // com.baidu.live.view.input.c.a
                public int KX() {
                    return b.this.bSF();
                }
            });
        }
    }

    private void bSB() {
        this.gFb = new com.baidu.tieba.ala.liveroom.o.b(this.gEE.pageContext);
        this.gFb.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public boolean bTo() {
                return b.this.bSm();
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void onClose() {
                if (b.this.bkR != null) {
                    b.this.bkR.cb(false);
                }
            }
        });
    }

    private void bSC() {
        if (this.gFy == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.gFy = (com.baidu.live.guess.a) runTask.getData();
                this.gFy.r(getActivity());
            } else {
                return;
            }
        }
        this.gFy.eF(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mo(boolean z) {
        if (this.gEZ != null) {
            this.gEZ.mQ(z);
        }
        if (this.gFb != null) {
            this.gFb.mQ(z);
        }
        gFM = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bSD() {
        return gFM;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bSE() {
        u Gm;
        if (bTl() == null || bTl().gON == null || (Gm = bTl().gON.Gm()) == null || Gm.aIf == null) {
            return false;
        }
        String str = Gm.aIf.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bSF() {
        u Gm;
        if (bTl() != null && bTl().gON != null && (Gm = bTl().gON.Gm()) != null && !ListUtils.isEmpty(Gm.aIm)) {
            for (AlaLiveMarkData alaLiveMarkData : Gm.aIm) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bSG() {
        if (this.gFd == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bTl().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gFd = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.gFd.setOtherParams(LI());
    }

    private void bSH() {
        if (this.gFi == null) {
            this.gFi = new com.baidu.tieba.ala.liveroom.turntable.e(bTl().pageContext.getPageActivity());
        }
    }

    private void bSI() {
        if (this.gFl == null) {
            this.gFl = new com.baidu.tieba.ala.liveroom.r.c(bTl().pageContext.getPageActivity());
        }
    }

    private void bSJ() {
        if (this.gFw == null) {
            this.gFw = new com.baidu.live.af.a(bTl().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.gFR == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.gFR = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.gFT);
            this.gFR.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gFR);
        }
        if (this.gFS == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.gFS = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.gFU);
            this.gFS.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gFS);
        }
        MessageManager.getInstance().registerListener(this.gGc);
        MessageManager.getInstance().registerListener(this.gGd);
        MessageManager.getInstance().registerListener(this.gGf);
        MessageManager.getInstance().registerListener(this.gFY);
        MessageManager.getInstance().registerListener(this.gFZ);
        MessageManager.getInstance().registerListener(this.gGb);
        MessageManager.getInstance().registerListener(this.gGa);
        MessageManager.getInstance().registerListener(this.gfx);
        MessageManager.getInstance().registerListener(this.gGg);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gpi);
        MessageManager.getInstance().registerListener(this.gpf);
        MessageManager.getInstance().registerListener(this.bnL);
        MessageManager.getInstance().registerListener(this.gGh);
        MessageManager.getInstance().registerListener(this.gGj);
        MessageManager.getInstance().registerListener(this.gGk);
        MessageManager.getInstance().registerListener(this.gGl);
        MessageManager.getInstance().registerListener(this.gGm);
        MessageManager.getInstance().registerListener(this.gFV);
        MessageManager.getInstance().registerListener(this.gFW);
        MessageManager.getInstance().registerListener(this.gFX);
        MessageManager.getInstance().registerListener(this.gGi);
        MessageManager.getInstance().registerListener(this.gGn);
        MessageManager.getInstance().registerListener(this.gGo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean IS() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bTl().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bTl().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bTl().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.x.a.OS().blo.aLd;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bTl().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bTl().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bTl().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bTl().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSK() {
        if (this.gEU != null && this.gFa != null) {
            this.gEU.KQ().a(this.gFa.NV(), com.baidu.live.gift.u.Gg().Gi(), bTl().gON.Gm().mLiveInfo);
            mo(true);
            if (this.gFm == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, y.class, bTl().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gFm = (y) runTask.getData();
                } else {
                    return;
                }
            }
            this.gFm.gS("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSL() {
        if (this.gEU != null) {
            this.gEU.KQ().hide();
            mo(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(int i, int i2, int i3) {
        if (bTl().gON.Gm() != null && bTl().gON.Gm().aHD != null && bTl().gON.Gm().mLiveInfo != null) {
            a(bTl().gON.Gm(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(i.class) != null && IS()) {
            if (uVar == null) {
                uVar = bTl().gON.Gm();
            }
            String valueOf = String.valueOf(uVar.aHD.userId);
            String str2 = uVar.aHD.userName;
            String valueOf2 = String.valueOf(uVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(uVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(uVar.mLiveInfo.feed_id);
            int i6 = uVar.aIf.isBlock;
            String Gv = w.Gv();
            String str3 = uVar.mLiveInfo.appId;
            boolean z2 = uVar.aIf.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (uVar.mLiveInfo.live_type == 1 && uVar.mLiveInfo.screen_direction == 1 && com.baidu.live.x.a.OS().blo.aKg) {
                z3 = true;
            }
            int i7 = -1;
            if (uVar.aIf == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(uVar.aIf.userId);
                boolean z4 = uVar.aIf.isNewUser;
                i7 = uVar.aIf.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.gFG != null && this.gFG.bdN != null && this.gFG.bdN.anchorId == uVar.aHD.userId) {
                z5 = this.gFG.bdQ;
            }
            i iVar = new i(bTl().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Gv, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.mAlaLiveSwitchData != null) {
                iVar.bb(uVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            iVar.fX(str);
            iVar.aZ(z);
            if (com.baidu.tieba.ala.liveroom.w.b.cbG().blx != null) {
                iVar.ba(com.baidu.tieba.ala.liveroom.w.b.cbG().blx.aIX != 1);
            }
            ba JO = g.JM().JO();
            if (JO == null || JO.aNn <= 0) {
                i5 = 1000;
            } else {
                i5 = JO.aNn;
            }
            iVar.dG(i5);
            boolean z6 = false;
            if (uVar != null && uVar.aIf != null) {
                String str4 = uVar.aIf.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            iVar.bc(z6);
            boolean z7 = true;
            bj bjVar = com.baidu.live.x.a.OS().bqJ;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bjVar != null && bjVar.aNY != null && (!bjVar.aNY.aQk || !bjVar.aNY.aQl)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            iVar.bd(z7);
            if (uVar != null && uVar.aIh != null) {
                iVar.fW(uVar.aIh.toJsonString());
            }
            if (bTl() != null && bTl().gON != null) {
                iVar.fY(bTl().gON.caW());
            }
            if (!this.gFK) {
                this.gFL = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, iVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSM() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        eM(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(br brVar) {
        if (brVar != null && IS()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(bTl().pageContext.getPageActivity(), brVar.aOQ, brVar.liveId, brVar.aOR)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && com.baidu.live.x.a.OS().blo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bTl().pageContext.getPageActivity(), String.valueOf(uVar.mLiveInfo.live_id), String.valueOf(uVar.mLiveInfo.user_id), com.baidu.live.x.a.OS().blo.aLF, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, NobleDetailInfo nobleDetailInfo) {
        if (IS() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (uVar != null) {
                if (uVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(uVar.mLiveInfo.live_id));
                }
                if (uVar.aHD != null) {
                    hashMap.put("anchor_id", Long.valueOf(uVar.aHD.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.Gv());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bTl().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSN() {
        if (this.gFa != null) {
            this.gFa.d(this.gEE.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSO() {
        u Gm = bTl().gON.Gm();
        LogManager.getCommonLogger().doClickQuickImHiLog((Gm == null || Gm.mLiveInfo == null) ? "" : Gm.mLiveInfo.feed_id, LI());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hb(String str) {
        if (this.gFa != null) {
            this.gFa.gV(str);
        }
    }

    private void bSP() {
        if ("home_rec_play".equals(bTl().fromType) || "frs_play".equals(bTl().fromType) || "frs_live_play".equals(bTl().fromType) || "person_play".equals(bTl().fromType) || "search".equals(bTl().fromType) || "person_attention".equals(bTl().fromType)) {
            com.baidu.live.b.AY().aX(true);
        } else {
            com.baidu.live.b.AY().aX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mp(boolean z) {
        View FQ;
        if (this.gEW == null) {
            f fVar = new f();
            fVar.aRM = false;
            fVar.context = bTl().pageContext.getPageActivity();
            fVar.aRV = z;
            fVar.fromType = bTl().fromType;
            fVar.aRW = bRF() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, x.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gEW = (x) runTask.getData();
            }
        }
        if (this.gEW != null && (FQ = this.gEW.FQ()) != null && this.gEE.gOO.indexOfChild(FQ) < 0) {
            this.gEE.gOO.addView(FQ, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSQ() {
        View Gy;
        if (this.gFh == null) {
            ac acVar = new ac();
            acVar.aRM = false;
            acVar.pageContext = bTl().pageContext;
            acVar.fromType = bTl().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, z.class, acVar);
            if (runTask != null && runTask.getData() != null) {
                this.gFh = (z) runTask.getData();
            }
        }
        if (this.gFh != null && (Gy = this.gFh.Gy()) != null && bTl().gOO.indexOfChild(Gy) < 0) {
            if (Gy.getParent() instanceof ViewGroup) {
                ((ViewGroup) Gy.getParent()).removeView(Gy);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bTl().gOO.addView(Gy, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSR() {
        View Gl;
        if (this.gEX == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aRM = false;
            aVar.context = bTl().pageContext.getPageActivity();
            aVar.fromType = bTl().fromType;
            aVar.aRN = bTl().gOS;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, v.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gEX = (v) runTask.getData();
            }
        }
        if (this.gEX != null && (Gl = this.gEX.Gl()) != null && bTl().gOO.indexOfChild(Gl) < 0) {
            if (Gl.getParent() instanceof ViewGroup) {
                ((ViewGroup) Gl.getParent()).removeView(Gl);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bTl().gOO.addView(Gl, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSS() {
        CustomResponsedMessage runTask;
        if (this.gEV == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bTl().pageContext)) != null) {
            this.gEV = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gEV != null) {
            this.gEV.setOtherParams(this.otherParams);
            this.gEV.a(new a.InterfaceC0185a() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.im.b.a.InterfaceC0185a
                public void Ll() {
                    b.this.bSX();
                }
            });
            this.gEV.a(bTl().gON.Gm(), false);
            View Cl = this.gEV.Cl();
            if (Cl != null && this.gFA.indexOfChild(Cl) < 0) {
                Resources resources = bTl().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bTl().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.gFA.addView(Cl, layoutParams);
            }
        }
    }

    private void bST() {
        if (this.gES == null) {
            this.gES = new com.baidu.tieba.ala.liveroom.h.a(bTl().pageContext);
        }
        if (this.gFF != null) {
            this.gES.Hf(this.gFF.user_id);
        }
        this.gES.av(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mq(boolean z) {
        if (bTl() != null && !z) {
            if (this.gFo == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bTl().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gFo = (com.baidu.live.i.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gFo.b(bSo(), bTe());
            if (bTl().gON != null) {
                this.gFo.a(bTl().gON.Gm());
            }
            this.gFo.setCanVisible(true);
            this.gFo.bP(true);
            this.gFo.a(bTl().gON.bMo());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSU() {
        if (bTl() != null) {
            if (this.gFp == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.p.a.class, bTl().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gFp = (com.baidu.live.p.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gFp.setIsHost(false);
            this.gFp.b(bSn(), bTl().gON.Gm());
        }
    }

    protected void bSV() {
        if (this.gFq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.p.b.class, bTl().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gFq = (com.baidu.live.p.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bTl().gON.Gm() != null && bTl().gON.Gm().aHD != null && bTl().gON.Gm().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(bTl().pageContext.getPageActivity(), a.e.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(bTl().pageContext.getPageActivity(), a.e.sdk_ds16);
            this.gFq.b(this.gFz, layoutParams, bTl().gON.Gm());
        }
    }

    private void bSW() {
        if (this.gFf == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bTl().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gFf = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bTl().gON.Gm() != null && bTl().gON.Gm().aHD != null && bTl().gON.Gm().mLiveInfo != null) {
            this.gFf.setHost(false);
            this.gFf.setOtherParams(LI());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            this.gFf.a(this.gFz, layoutParams, bTl().gON.Gm());
            this.gFf.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.guardclub.l
                public void JS() {
                    b.this.bTm();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:209:0x0690, code lost:
        GX(r32);
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
                    if (this.bkR != null) {
                        this.bkR.cd(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        uQ(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bTl().gON.Gm().aIf.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bTl().gON.Gm().aIf.isAdmin = 0;
                            bTl().gON.caG();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bTl().gON.Gm().aIf.isAdmin = 0;
                        bTl().gON.caG();
                    }
                } else if ("task".equals(optString2)) {
                    dD(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gEY != null && !bTl().gOR) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bTl().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bTl().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bTl().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bOb()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gEY.a(bTl().gOM.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bkR != null) {
                                b.this.bkR.cc(optInt4 == 2);
                            }
                        }
                    });
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.u.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bTl().gON.Gm() != null && bTl().gON.Gm().aIf != null && bTl().gON.Gm().aIf.userId == optLong2) {
                        bTl().gON.Gm().aIf.isBlock = 1;
                        bSb();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bTl().gON.Gm() != null && bTl().gON.Gm().aIf != null && bTl().gON.Gm().aIf.userId == optLong3) {
                        bTl().gON.Gm().aIf.isBlock = 0;
                        bSb();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bTl().gON.Gm() != null && bTl().gON.Gm().aIf != null && bTl().gON.Gm().aIf.userId == optLong4) {
                        bTl().gON.Gm().aIf.isUegBlock = 1;
                        bSb();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bTl().gON.Gm() != null && bTl().gON.Gm().aIf != null && bTl().gON.Gm().aIf.userId == optLong5) {
                        bTl().gON.Gm().aIf.isUegBlock = 0;
                        bSb();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bTl() != null && bTl().gON != null && bTl().gON.Gm() != null && bTl().gON.Gm().aIf != null) {
                        if (bTl().gON.Gm().aIf.userId == jSONObject2.optLong("user_id")) {
                            bTl().gON.caG();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bTl().gON.Gm().aIf));
                    }
                } else if ("guard_seat".equals(optString2)) {
                    if (jSONObject2.optInt("seat_status") == 1) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156));
                    }
                } else if ("official_notice".equals(optString2)) {
                    long optLong6 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str2 = optLong6 + "";
                        TbadkCoreApplication.getInst();
                        if (str2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                } else if ("privilege_award_royal_success".equals(optString2)) {
                    String str3 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a Lt = aVar.Lt();
                    if (Lt != null && w.gQ(str3)) {
                        w.d(str3, 1L, "", "", Lt.userId, Lt.portrait, Lt.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        av avVar = new av();
                        avVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, avVar));
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
                } else if (TextUtils.equals(optString2, "mix_room_close") && this.gFx != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("source", "im_mix_room_close");
                        jSONObject5.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                        this.gFx.A("mix_room_close", jSONObject5);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.gEP != null) {
                this.gEP.C(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a Lt2 = aVar.Lt();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong7 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            boolean z2 = jSONObject2.optInt("from_gongyanfang_page") == 1;
            boolean z3 = false;
            long j3 = 0;
            String str4 = null;
            if (bTl().gON == null || bTl().gON.Gm() == null || bTl().gON.Gm().mLiveInfo == null) {
                j = 0;
                j2 = 0;
            } else {
                long j4 = bTl().gON.Gm().mLiveInfo.live_id;
                j3 = bTl().gON.Gm().mLiveInfo.group_id;
                long j5 = bTl().gON.Gm().aHD.userId;
                str4 = bTl().gON.Gm().mLiveInfo.appId;
                z3 = bTl().gON.Gm().mLiveInfo.isPubShow;
                j = j5;
                j2 = j4;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    w.b(optString9, Lt2.userId, Lt2.portrait, Lt2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.x.d.OZ().hK(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                    break;
                                }
                                i++;
                            }
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            } else {
                aVar.setHost(z3 && z2);
                w.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, Lt2.userId, Lt2.portrait, Lt2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", !z2, aVar.getMsgId());
                GX(optString3);
            }
            com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
            cVar.gOs = optLong7;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gFx = dVar;
    }

    protected void GX(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bSX() {
        if (bSY()) {
            BdUtilHelper.hideSoftKeyPad(bTl().pageContext.getPageActivity(), bTl().gOM.getLiveContainerView());
            bSl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bSY() {
        if (bSk() == null || bSk().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(u uVar) {
        CustomResponsedMessage runTask;
        bTl().gOO.setOnTouchListener(this.gGp);
        bTf();
        bTg();
        bTh();
        bST();
        bSW();
        bSV();
        bSC();
        if (this.gEN != null && bTl().gON.Gm() != null && bTl().gON.Gm().mLiveInfo != null) {
            this.gEN.ck(bTl().gON.Gm().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gET != null) {
            this.gET.i(bTl().gON.Gm());
        }
        if (this.gER != null) {
            this.gER.f(bTl().gON.Gm());
        }
        if (this.gEZ != null) {
            this.gEZ.c(bTl().gON.Gm(), LI());
        }
        if (this.gFa != null) {
            this.gFa.b(bTl().gON.Gm(), LI());
        }
        if (this.gFb != null) {
            this.gFb.c(bTl().gON.Gm(), LI());
        }
        if (this.gFy != null) {
            this.gFy.f(bTl().gON.Gm());
        }
        if (bTl().gOO != null) {
            bTl().gOO.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean P = b.this.P(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bSY() && b.this.gEM != null) {
                        b.this.gEM.nj(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gEM != null) {
                        b.this.gEM.nj(true);
                    }
                    return P;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Ng() {
                    if (b.this.gFQ == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.gFQ) {
                        if (bVar.Ng()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bTl().gOO.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.O(motionEvent);
                }
            });
        }
        if (this.gFm == null && (runTask = MessageManager.getInstance().runTask(2913165, y.class, bTl().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gFm = (y) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bSZ() {
        u Gm;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (bTl() != null && bTl().gON != null && (Gm = bTl().gON.Gm()) != null && Gm.mLiveInfo != null && !Gm.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bTl().gOM) != null) {
            if (this.gFr == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.t.a.class, bTl().pageContext)) != null && runTask.getData() != null) {
                this.gFr = (com.baidu.live.t.a) runTask.getData();
            }
            if (this.gFr != null) {
                this.gFr.p(Gm);
                this.gFr.a(this.gGq);
                this.gFr.a(viewGroup, (ViewGroup) viewGroup.findViewById(a.g.ala_live_header_view));
                a(this.gFr.Om());
                a(this.gFr.On());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gFP == null) {
            this.gFP = new ArrayList();
        }
        if (!this.gFP.contains(dVar)) {
            this.gFP.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gFP != null && this.gFP.contains(dVar)) {
            this.gFP.remove(dVar);
        }
    }

    protected void bTa() {
        if (this.gFP != null) {
            this.gFP.clear();
            this.gFP = null;
        }
    }

    protected boolean O(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gFP == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gFP.iterator();
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
        if (this.gFQ == null) {
            this.gFQ = new ArrayList();
        }
        if (!this.gFQ.contains(bVar)) {
            this.gFQ.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gFQ != null && this.gFQ.contains(bVar)) {
            this.gFQ.remove(bVar);
        }
    }

    protected void bTb() {
        if (this.gFQ != null) {
            this.gFQ.clear();
            this.gFQ = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gFQ == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gFQ.iterator();
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
    public void bTc() {
        if (this.gFn == null && this.gFt != null && this.gFt.aOi && bTl() != null && bTl().gON != null && bTl().gON.Gm() != null) {
            this.gFn = new com.baidu.tieba.ala.liveroom.h.e(bTl().pageContext, this.gFt);
            this.gFn.w(bTl().gON.Gm());
            if (this.gFt.aOl == 1) {
                if (this.gEU != null) {
                    this.gFI = true;
                }
            } else if (this.gFt.aOl == 2) {
                a(bTl().gON.Gm(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bTd() {
        CustomResponsedMessage runTask;
        if (bTl() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bTl().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.u.a)) {
            this.gFu = (com.baidu.live.u.a) runTask.getData();
            this.gFu.s(bSn());
            if (bTl().gON != null) {
                this.gFJ = this.gFu.q(bTl().gON.Gm());
            }
            this.gFu.setCanVisible(!this.gFD);
        }
    }

    private ViewGroup.LayoutParams bTe() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.gFq != null && this.gFq.isShowing()) {
            layoutParams.addRule(3, a.g.ala_rank_level_entry);
            layoutParams.topMargin = bTl().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int J(boolean z, boolean z2) {
        Rect rect = new Rect();
        bTl().gOM.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bTl().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bTl().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bTl().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bTl().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bTf() {
        if (this.gEM != null) {
            this.gEM.aC(bTl().gOO);
        }
    }

    private void bTg() {
        if (this.gEN != null) {
            this.gEN.aE(bTl().gOO);
        }
    }

    private void bTh() {
        if (this.gEQ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.z.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gEQ = (com.baidu.live.z.a) runTask.getData();
            }
            bTi();
        }
    }

    private void dD(JSONObject jSONObject) {
        if (this.gEQ != null) {
            if (this.gEJ != null) {
                this.gEQ.ct(this.gEJ.bWX() ? false : true);
            } else {
                this.gEQ.ct(true);
            }
            this.gEQ.P(jSONObject);
        }
    }

    private void bTi() {
        if (this.gEQ != null && bTl().gON.Gm() != null && bTl().gON.Gm().aIq != null) {
            if (this.gEJ != null) {
                this.gEQ.ct(this.gEJ.bWX() ? false : true);
            } else {
                this.gEQ.ct(true);
            }
            this.gEQ.k(bTl().gON.Gm());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void l(u uVar) {
        if (uVar != null) {
            if (this.gEN != null && uVar.mLiveInfo != null) {
                this.gEN.ck(uVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gFe != null) {
                this.gFe.j(uVar);
            }
            bTi();
            if (this.gES != null && uVar.aHD != null) {
                this.gES.Hf(String.valueOf(uVar.aHD.userId));
            }
            if (this.gEG != null) {
                this.gEG.a(uVar);
            }
            if (this.gEX != null && uVar.mLiveInfo != null) {
                this.gEX.a(uVar.mLiveInfo, uVar.aHD);
            }
            if (this.gEV != null) {
                this.gEV.a(uVar);
            }
            if (this.gFu != null) {
                this.gFJ = this.gFu.q(uVar);
            }
            if (this.gFo != null) {
                this.gFo.a(uVar);
            }
            if (this.gFp != null) {
                this.gFp.a(uVar);
            }
            if (this.gFq != null) {
                this.gFq.a(uVar);
            }
            if (this.gFy != null) {
                this.gFy.b(uVar);
            }
            uQ(uVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void uQ(int i) {
        if (!bTl().gOR) {
            if (this.gFB < 0 && i == 0) {
                this.gFB = i;
            } else if (this.gFB != i) {
                if (i == 1) {
                    if (!this.gEY.vE(2)) {
                        String string = bTl().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bTl().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gEY.a(bTl().gOM.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bTl().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.gEY.vF(2);
                    this.gEY.vF(3);
                    if (bOb()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gEY.a(bTl().gOM.getLiveContainerView(), string2, 3);
                    }
                }
                this.gFB = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cg(boolean z) {
        super.cg(z);
        if (z) {
            bTj();
        }
        if (this.gFe != null) {
            this.gFe.JT();
        }
        if (this.gER != null) {
            this.gER.JT();
        }
        if (this.gEP != null) {
            this.gEP.ccP();
        }
        if (this.gEH != null) {
            this.gEH.CN();
        }
        if (this.gEJ != null) {
            this.gEJ.onDestroy();
        }
        if (this.gEQ != null) {
            this.gEQ.onDestroy();
            this.gEQ = null;
        }
        if (this.gEW != null) {
            View FQ = this.gEW.FQ();
            if (FQ != null && FQ.getParent() != null) {
                ((ViewGroup) FQ.getParent()).removeView(FQ);
            }
            this.gEW.onDestroy();
            this.gEW = null;
        }
        if (this.gEV != null) {
            this.gEV.a((a.InterfaceC0185a) null);
            this.gEV.Cn();
        }
        if (this.gEY != null) {
            this.gEY.CN();
        }
        this.gFB = -1;
        if (this.gES != null) {
            this.gES.CN();
            this.gES.onDestroy();
        }
        if (this.gEK != null) {
            this.gEK.ccN();
        }
        if (this.gEL != null) {
            this.gEL.bRC();
            this.gEL.Gx();
        }
        if (this.gEM != null) {
            this.gEM.Gx();
        }
        if (this.gET != null) {
            this.gET.Gx();
        }
        if (this.gEZ != null) {
            this.gEZ.JT();
        }
        if (this.gFa != null) {
            this.gFa.Gx();
        }
        if (this.gFb != null) {
            this.gFb.onDestroy();
        }
        if (this.gFd != null) {
            this.gFd.onDestory();
        }
        if (this.gFg != null) {
            this.gFg.JQ();
        }
        if (this.gFf != null) {
            this.gFf.JQ();
        }
        if (this.gFq != null) {
            this.gFq.JQ();
        }
        if (this.gFn != null) {
            this.gFn.onDestroy();
        }
        if (this.gFi != null) {
            this.gFi.Gx();
        }
        if (this.gFw != null) {
            this.gFw.Gx();
        }
        if (this.gFj != null) {
            this.gFj.Gx();
        }
        if (this.gFk != null) {
            this.gFk.Gx();
        }
        if (this.gFm != null) {
            this.gFm.Gx();
        }
        if (this.gEI != null) {
            this.gEI.onDestory();
        }
        if (this.gFu != null) {
            this.gFu.Gx();
        }
        if (this.gFo != null) {
            this.gFo.JQ();
        }
        if (this.gFp != null) {
            this.gFp.JQ();
        }
        if (this.gFl != null) {
            this.gFl.Gx();
        }
        if (this.gFh != null) {
            this.gFh.onDestroy();
        }
        if (this.gFr != null) {
            this.gFr.CN();
            b(this.gFr.Om());
            b(this.gFr.On());
        }
        if (this.gFs != null) {
            this.gFs.JQ();
        }
        if (this.gFy != null) {
            this.gFy.JT();
        }
        ShowUtil.windowCount = 0;
        bTa();
        bTb();
    }

    private void bTj() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bTl().gOO.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bTl().gOO.getChildAt(i);
            if (childAt != this.gFz && childAt != this.gFA) {
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
        if (this.gFz != null) {
            this.gFz.removeAllViews();
        }
        if (this.gFA != null) {
            this.gFA.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, u uVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void o(u uVar) {
        View Cl;
        View FQ;
        if (this.gEW != null && (FQ = this.gEW.FQ()) != null && FQ.getParent() != null) {
            ((ViewGroup) FQ.getParent()).removeView(FQ);
        }
        if (this.gEV != null && (Cl = this.gEV.Cl()) != null && Cl.getParent() != null) {
            ((ViewGroup) Cl.getParent()).removeView(Cl);
        }
        if (this.gEJ != null) {
            this.gEJ.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Nc() {
        if (this.gEO == null || !this.gEO.bXc()) {
            if (this.gEJ == null || !this.gEJ.ay(bTl().gOM.getLiveContainerView())) {
                if (this.gEM != null) {
                    this.gEM.bOI();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gFc != null && this.gFc.bWL()) {
                    this.gFc.bWU();
                    return false;
                } else if (this.gFb == null || !this.gFb.bXh()) {
                    bSP();
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
    public void ce(boolean z) {
        super.ce(z);
        if (this.gFe != null) {
            this.gFe.release();
        }
        if (this.gER != null) {
            this.gER.onDestroy();
        }
        if (this.gEQ != null) {
            this.gEQ.onDestroy();
            this.gEQ = null;
        }
        if (this.gEP != null) {
            this.gEP.ccP();
        }
        if (this.gEW != null) {
            this.gEW.onDestroy();
            this.gEW = null;
        }
        if (this.gEX != null) {
            this.gEX.onDestroy();
            this.gEX = null;
        }
        if (this.gEY != null) {
            this.gEY.onDestroy();
        }
        if (this.gEH != null) {
            this.gEH.onDestroy();
        }
        if (this.gFh != null) {
            this.gFh.onDestroy();
            this.gFh = null;
        }
        if (this.gEV != null) {
            this.gEV.a((a.InterfaceC0185a) null);
            this.gEV.release();
            this.gEV = null;
        }
        if (this.gEZ != null) {
            this.gEZ.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gEZ.release();
        }
        if (this.gFa != null) {
            this.gFa.a(null);
            this.gFa.release();
        }
        if (this.gFb != null) {
            this.gFb.a((b.a) null);
            this.gFb.onDestroy();
        }
        if (this.gFf != null) {
            this.gFf.onDestroy();
        }
        if (this.gFg != null) {
            this.gFg.onDestroy();
        }
        if (this.gFd != null) {
            this.gFd.onDestory();
        }
        if (this.gFq != null) {
            this.gFq.onDestroy();
        }
        if (this.gFn != null) {
            this.gFn.onDestroy();
        }
        if (this.gFi != null) {
            this.gFi.release();
        }
        if (this.gFw != null) {
            this.gFw.release();
        }
        if (this.gFl != null) {
            this.gFl.release();
        }
        if (this.gFj != null) {
            this.gFj.release();
        }
        if (this.gFk != null) {
            this.gFk.release();
        }
        if (this.gFm != null) {
            this.gFm.release();
        }
        if (this.gEI != null) {
            this.gEI.onDestory();
        }
        if (this.gFu != null) {
            this.gFu.release();
        }
        if (this.gFo != null) {
            this.gFo.onDestroy();
        }
        if (this.gFp != null) {
            this.gFp.onDestroy();
        }
        if (this.gEM != null) {
            this.gEM.Gx();
        }
        if (this.gFy != null) {
            this.gFy.onDestroy();
        }
        if (this.gFr != null) {
            this.gFr.onDestroy();
            b(this.gFr.Om());
            b(this.gFr.On());
        }
        bTa();
        bTb();
        MessageManager.getInstance().unRegisterListener(this.gFV);
        MessageManager.getInstance().unRegisterListener(this.gFW);
        MessageManager.getInstance().unRegisterListener(this.gFX);
        MessageManager.getInstance().unRegisterListener(this.gGc);
        MessageManager.getInstance().unRegisterListener(this.gGd);
        MessageManager.getInstance().unRegisterListener(this.gGf);
        MessageManager.getInstance().unRegisterListener(this.gFY);
        MessageManager.getInstance().unRegisterListener(this.gFZ);
        MessageManager.getInstance().unRegisterListener(this.gGb);
        MessageManager.getInstance().unRegisterListener(this.gGa);
        MessageManager.getInstance().unRegisterListener(this.gfx);
        MessageManager.getInstance().unRegisterListener(this.gGg);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gpi);
        MessageManager.getInstance().unRegisterListener(this.gpf);
        MessageManager.getInstance().unRegisterListener(this.bnL);
        MessageManager.getInstance().unRegisterListener(this.gGh);
        MessageManager.getInstance().unRegisterListener(this.gGj);
        MessageManager.getInstance().unRegisterListener(this.gGk);
        MessageManager.getInstance().unRegisterListener(this.gGl);
        MessageManager.getInstance().unRegisterListener(this.gGi);
        MessageManager.getInstance().unRegisterListener(this.gGm);
        MessageManager.getInstance().unRegisterListener(this.gGn);
        MessageManager.getInstance().unRegisterListener(this.gGo);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gEZ != null) {
            this.gEZ.mP(false);
        }
        if (this.gFb != null) {
            this.gFb.mP(false);
        }
        bSl();
        if (this.gFe != null) {
            this.gFe.onPause();
        }
        if (this.gFi != null) {
            this.gFi.pause();
        }
        if (this.gFw != null) {
            this.gFw.pause();
        }
        if (this.gFl != null) {
            this.gFl.pause();
        }
        if (this.gFj != null) {
            this.gFj.pause();
        }
        if (this.gFh != null) {
            this.gFh.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gFL = false;
        if (this.gFE && this.gFF != null) {
            a(this.gFF);
            this.gFE = false;
        }
        if (this.gEZ != null) {
            this.gEZ.mP(true);
        }
        if (this.gFb != null) {
            this.gFb.mP(true);
        }
        if (this.gFe != null) {
            this.gFe.onResume();
        }
        if (this.gFi != null) {
            this.gFi.resume();
        }
        if (this.gFw != null) {
            this.gFw.resume();
        }
        if (this.gFl != null) {
            this.gFl.resume();
        }
        if (this.gFh != null) {
            this.gFh.onResume();
        }
        if (this.gFj != null) {
            this.gFj.resume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arx() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gFr != null && this.gFr.isOpen()) {
            this.gFr.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            arx();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    K(-1, -1, -1);
                    return;
                }
                return;
            }
            arx();
        } else if (i == 25034) {
            bSM();
        } else if (i == 25043) {
            if (i2 == -1) {
                bTm();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.m.a.F(bTl().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.m.a.F(bTl().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gFD = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bTk() {
        return (bTl().gON.Gm() == null || bTl().gON.Gm().mLiveInfo == null || bTl().gON.Gm().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gEJ != null) {
                this.gEJ.D(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gFb != null) {
            this.gFb.bet();
        }
        if (this.gEI != null) {
            this.gEI.bet();
        }
        if (this.gFr != null) {
            this.gFr.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gEE = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bTl() {
        return this.gEE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTm() {
        String JN = g.JM().JN();
        if (!TextUtils.isEmpty(JN)) {
            try {
                K(-1, Integer.parseInt(JN), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                K(-1, -1, -1);
            }
        }
    }

    public boolean eL(int i) {
        if (1 == i) {
            if (bSk() != null) {
                bSk().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gFD) {
                return false;
            }
            return this.gEJ == null || !this.gEJ.bWX();
        } else if (3 == i) {
            if (bTl().gOO != null) {
                bTl().gOO.setEnabled(false);
                if (this.bkR != null) {
                    this.bkR.e(!bTl().gOP, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void uO(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void eM(int i) {
        if (3 == i) {
            bTl().gOO.setEnabled(true);
            if (this.bkR != null) {
                this.bkR.e(!bTl().gOP, true);
            }
            if (this.gEQ != null) {
                this.gEQ.ct(true);
            }
        } else if (2 == i && this.gEP != null) {
            this.gEP.nr(true);
        }
    }

    public String LI() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gEV != null) {
            this.gEV.setOtherParams(str);
        }
        if (this.gFe != null) {
            this.gFe.hz(str);
        }
    }

    private boolean bOb() {
        return bTl().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fMS = alaLastLiveroomInfo;
    }
}
