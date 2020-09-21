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
import com.baidu.tieba.ala.liveroom.o.a;
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
    public static boolean grr;
    protected AlaLastLiveroomInfo fAJ;
    private m gqA;
    k gqB;
    com.baidu.live.im.b.a gqC;
    protected x gqD;
    protected v gqE;
    protected com.baidu.tieba.ala.liveroom.tippop.a gqF;
    private com.baidu.tieba.ala.liveroom.guideim.b gqG;
    protected com.baidu.live.view.input.c gqH;
    com.baidu.tieba.ala.liveroom.o.a gqI;
    protected com.baidu.tieba.ala.liveroom.guide.a gqJ;
    private com.baidu.live.guardclub.k gqK;
    protected com.baidu.live.j.b gqL;
    protected h gqM;
    protected j gqN;
    protected z gqO;
    protected e gqP;
    protected com.baidu.tieba.ala.liveroom.m.b gqQ;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gqR;
    protected com.baidu.tieba.ala.liveroom.r.c gqS;
    private y gqT;
    protected com.baidu.tieba.ala.liveroom.h.e gqU;
    protected com.baidu.live.i.a gqV;
    protected com.baidu.live.p.a gqW;
    protected com.baidu.live.p.b gqX;
    protected com.baidu.live.t.a gqY;
    protected com.baidu.tieba.ala.liveroom.exclusive.b gqZ;
    private com.baidu.tieba.ala.liveroom.data.a gql;
    protected com.baidu.tieba.ala.liveroom.operation.a gqm;
    protected com.baidu.live.h.a gqn;
    protected com.baidu.tieba.ala.liveroom.share.c gqo;
    protected com.baidu.tieba.ala.liveroom.s.b gqp;
    protected com.baidu.tieba.ala.liveroom.guide.c gqq;
    protected com.baidu.tieba.ala.liveroom.watermark.a gqr;
    protected com.baidu.tieba.ala.liveroom.b.b gqs;
    protected com.baidu.tieba.ala.liveroom.praise.a gqt;
    protected com.baidu.tieba.ala.liveroom.sticker.a gqu;
    protected com.baidu.tieba.ala.liveroom.guide.d gqv;
    protected com.baidu.tieba.ala.liveroom.x.a gqw;
    protected com.baidu.live.z.a gqx;
    protected com.baidu.live.z.d gqy;
    private com.baidu.tieba.ala.liveroom.h.a gqz;
    protected bk gra;
    protected com.baidu.live.u.a grb;
    protected com.baidu.tieba.ala.liveroom.f.a grc;
    protected com.baidu.live.ae.a grd;
    protected RelativeLayout gre;
    protected RelativeLayout grf;
    protected boolean grh;
    protected am grk;
    protected GuardClubInfoHttpResponseMessage grl;
    boolean grm;
    boolean grn;
    boolean gro;
    public boolean grp;
    public boolean grq;
    protected com.baidu.tieba.ala.liveroom.u.b grs;
    protected com.baidu.tieba.ala.liveroom.j.e grt;
    protected List<com.baidu.live.liveroom.g.d> gru;
    protected List<com.baidu.live.liveroom.g.b> grv;
    CustomMessageTask grw;
    CustomMessageTask grx;
    protected String otherParams;
    private int grg = -1;
    protected int mOrientation = 0;
    protected boolean gri = false;
    protected boolean grj = false;
    CustomMessageTask.CustomRunnable<Object> gry = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: bPU */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> grz = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener grA = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ad adVar;
            if ((customResponsedMessage.getData() instanceof ad) && (adVar = (ad) customResponsedMessage.getData()) != null) {
                b.this.a(adVar.aFP, adVar.aFL, adVar.aFM, adVar.aFN, adVar.aFO);
            }
        }
    };
    private CustomMessageListener grB = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.uj(7);
        }
    };
    private CustomMessageListener grC = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bPu();
        }
    };
    private CustomMessageListener grD = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bPS().gAu.Fq().aEz.userId);
            com.baidu.live.view.a.Rg().a(valueOf, new com.baidu.live.data.e(b.this.bPS().gAu.Fq().aEz.portrait, valueOf, true, b.this.bPS().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener grE = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof u) && b.this.gqo != null) {
                b.this.gqo.c((u) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bjY = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gqB != null) {
                b.this.gqB.g(com.baidu.live.gift.u.Fk().Fm());
            }
        }
    };
    private CustomMessageListener grF = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gql.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.Go(str);
            }
        }
    };
    private CustomMessageListener grG = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bPS().pageContext.getPageActivity());
            } else if (b.this.gqo != null) {
                b.this.gqo.c(b.this.bPS().gAu.Fq(), false);
            }
        }
    };
    private CustomMessageListener grH = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof am) {
                    b.this.grj = true;
                    b.this.grk = (am) data;
                    b.this.b(b.this.grk);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener grI = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bPS().gAu.Fq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bPS().gAu.Fq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bPS().gAu.Fq().aEz.userId);
                    if (b.this.gqp == null) {
                        b.this.gqp = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    b.this.gqp.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gqp.a(b.this.grJ);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private b.InterfaceC0184b grJ = new b.InterfaceC0184b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.b.InterfaceC0184b
        public void MJ() {
            if (b.this.bPS().gAu.Fq() != null && b.this.bPS().gAu.Fq().aFb != null) {
                b.this.bPS().gAu.Fq().aFb.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener grK = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gqL != null) {
                    b.this.gqL.x(aVar);
                }
                if (b.this.gqZ != null) {
                    b.this.gqZ.y(aVar);
                }
                b.this.r(aVar);
            }
        }
    };
    CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener grL = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.grm = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gqI != null) {
                b.this.gqI.FD();
            }
        }
    };
    HttpMessageListener gcS = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bat) != null && b.this.gqK != null && b.this.bPS() != null && b.this.bPS().gAu != null) {
                int[] iArr = new int[2];
                b.this.gre.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gqK.a(b.this.gre, layoutParams, aVar, b.this.bPS().gAu.Fq());
                com.baidu.live.n.a.ay(aVar.liveId + "", "guard_club_join");
                com.baidu.live.m.a.b(b.this.bPS().gAu.Fq().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gcP = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bPS() != null && b.this.bPS().gAu != null && b.this.bPS().gAu.Fq() != null && guardClubInfoHttpResponseMessage.bat != null) {
                    if (guardClubInfoHttpResponseMessage.bat.aDf == b.this.bPS().gAu.Fq().aEz.userId) {
                        b.this.grl = guardClubInfoHttpResponseMessage;
                        if (b.this.grl.baw && com.baidu.live.guardclub.e.IO() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.IO().ag(b.this.bPS().gAu.Fq().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener grM = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof br) {
                b.this.a((br) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener grN = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                Log.d("XXXX", "onMessage: ");
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (b.this.gqQ != null) {
                    b.this.gqQ.eh(bVar.url, bVar.aDF);
                }
            }
        }
    };
    private CustomMessageListener grO = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.t(b.this.bPS().gAu.Fq());
        }
    };
    private CustomMessageListener grP = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gqV != null) {
                b.this.gqV.IW();
            }
        }
    };
    private CustomMessageListener grQ = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gqO != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) b.this.gqO).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener grR = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bPS().gAu.Fq(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener grS = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ae.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.grd == null) {
                b.this.grd = new com.baidu.live.ae.a(b.this.bPS().pageContext.getPageActivity());
            }
            b.this.grd.a((com.baidu.live.ae.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener grT = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.bPS().pageContext.getPageActivity() != null) {
                com.baidu.live.m.a.s(b.this.bPS().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener grU = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bPE();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.t.b grV = new com.baidu.live.t.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
        @Override // com.baidu.live.t.b
        public boolean Nj() {
            if (b.this.bPS().gAv != null) {
                if (b.this.bPS().gAv.getKeyboardVisibility()) {
                    return false;
                }
                if (!b.this.bPS().gAv.bYU()) {
                    b.this.gqY.close();
                    return false;
                } else if (b.this.bPS().gAv.getScrollX() != 0) {
                    b.this.gqY.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void a(am amVar);

    protected abstract void b(am amVar);

    protected abstract void bOK();

    protected abstract View bOT();

    public abstract boolean bOU();

    protected abstract boolean bOV();

    protected abstract ViewGroup bOW();

    protected abstract ViewGroup bOX();

    public abstract boolean bOo();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bk bkVar) {
        this.gra = bkVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gre = (RelativeLayout) bPS().gAv.findViewById(a.g.ala_live_header_view);
        this.grf = (RelativeLayout) bPS().gAv.findViewById(a.g.ala_live_footer_view);
        Gf();
        registerListener();
    }

    public void bPc() {
    }

    private void Gf() {
        if (this.gqo == null) {
            this.gqo = new com.baidu.tieba.ala.liveroom.share.c(bPS().pageContext);
        }
        this.gqw = new com.baidu.tieba.ala.liveroom.x.a(bPS().pageContext, this);
        this.gqs = new com.baidu.tieba.ala.liveroom.b.b(bPS().pageContext, false);
        this.gqt = new com.baidu.tieba.ala.liveroom.praise.a(bPS().pageContext);
        this.gqu = new com.baidu.tieba.ala.liveroom.sticker.a(bPS().pageContext);
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
                this.gqv = new com.baidu.tieba.ala.liveroom.guide.d(bPS().pageContext);
            }
        }
        this.gqF = new com.baidu.tieba.ala.liveroom.tippop.a(bPS().pageContext, this);
        bPg();
        bPi();
        bPj();
        bPk();
        bPo();
        bPp();
        bPq();
        bPd();
        bPf();
        bPe();
        bPr();
    }

    private void bPd() {
        this.gqQ = new com.baidu.tieba.ala.liveroom.m.b(bPS().pageContext.getPageActivity());
    }

    private void bPe() {
        CustomResponsedMessage runTask;
        if (this.gqy == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.z.d.class, bPS().pageContext)) != null && runTask.getData() != null) {
            this.gqy = (com.baidu.live.z.d) runTask.getData();
        }
    }

    private void bPf() {
        CustomResponsedMessage runTask;
        if (this.gqL == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.j.b.class, bPS().pageContext)) != null && runTask.getData() != null) {
            this.gqL = (com.baidu.live.j.b) runTask.getData();
            this.gqL.c(bPS().pageContext);
            this.gqL.Lu().setTargetView(this.grf);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.grc == null) {
            this.grc = new com.baidu.tieba.ala.liveroom.f.a(bPS().pageContext);
            this.grc.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.grc.a(bPS().gAu.Fq(), alaLastLiveroomInfo);
        this.grc.at(this.grf);
    }

    private void bPg() {
        this.gqA = new m();
    }

    public void lL(boolean z) {
        this.grh = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPh() {
        u Fq = bPS().gAu.Fq();
        boolean z = com.baidu.live.x.a.NN().bhy.aIA;
        if (Fq.mLiveInfo != null && Fq.mLiveInfo.mAlaLiveSwitchData != null && Fq.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Fq.aFn ? z : false;
        if (z2) {
            if (this.gqn == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bPS().pageContext);
                if (runTask != null) {
                    this.gqn = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gqn != null) {
                this.gqn.ez(1);
                View view = this.gqn.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bPS().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bPS().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    this.gre.addView(view, layoutParams);
                    if (z2) {
                        this.gqn.a(Fq);
                    }
                }
            }
        }
    }

    private void bPi() {
        this.gqG = new com.baidu.tieba.ala.liveroom.guideim.b(bPS().pageContext);
        this.gqG.c(this.grf, bOo());
        this.gqG.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean JM() {
                return b.this.HV();
            }
        });
    }

    private void bPj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bPS().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gqH = (com.baidu.live.view.input.c) runTask.getData();
            this.gqH.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
                @Override // com.baidu.live.view.input.c.a
                public void Rz() {
                    b.this.uj(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void RA() {
                    b.this.eD(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean JM() {
                    return b.this.HV();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Kn() {
                    return b.this.bPm();
                }

                @Override // com.baidu.live.view.input.c.a
                public int JR() {
                    return b.this.bPn();
                }
            });
        }
    }

    private void bPk() {
        this.gqI = new com.baidu.tieba.ala.liveroom.o.a(this.gql.pageContext);
        this.gqI.a(new a.InterfaceC0633a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0633a
            public boolean bPV() {
                return b.this.bOV();
            }

            @Override // com.baidu.tieba.ala.liveroom.o.a.InterfaceC0633a
            public void onClose() {
                if (b.this.bhb != null) {
                    b.this.bhb.bY(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void lM(boolean z) {
        if (this.gqG != null) {
            this.gqG.mo(z);
        }
        if (this.gqI != null) {
            this.gqI.mo(z);
        }
        grr = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bPl() {
        return grr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bPm() {
        u Fq;
        if (bPS() == null || bPS().gAu == null || (Fq = bPS().gAu.Fq()) == null || Fq.aFb == null) {
            return false;
        }
        String str = Fq.aFb.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bPn() {
        u Fq;
        if (bPS() != null && bPS().gAu != null && (Fq = bPS().gAu.Fq()) != null && !ListUtils.isEmpty(Fq.aFi)) {
            for (AlaLiveMarkData alaLiveMarkData : Fq.aFi) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bPo() {
        if (this.gqK == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bPS().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gqK = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.gqK.setOtherParams(KD());
    }

    private void bPp() {
        if (this.gqP == null) {
            this.gqP = new e(bPS().pageContext.getPageActivity());
        }
    }

    private void bPq() {
        if (this.gqS == null) {
            this.gqS = new com.baidu.tieba.ala.liveroom.r.c(bPS().pageContext.getPageActivity());
        }
    }

    private void bPr() {
        if (this.grd == null) {
            this.grd = new com.baidu.live.ae.a(bPS().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.grw == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.grw = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.gry);
            this.grw.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.grw);
        }
        if (this.grx == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.grx = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.grz);
            this.grx.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.grx);
        }
        MessageManager.getInstance().registerListener(this.grH);
        MessageManager.getInstance().registerListener(this.grI);
        MessageManager.getInstance().registerListener(this.grK);
        MessageManager.getInstance().registerListener(this.grD);
        MessageManager.getInstance().registerListener(this.grE);
        MessageManager.getInstance().registerListener(this.grG);
        MessageManager.getInstance().registerListener(this.grF);
        MessageManager.getInstance().registerListener(this.fTe);
        MessageManager.getInstance().registerListener(this.grL);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gcS);
        MessageManager.getInstance().registerListener(this.gcP);
        MessageManager.getInstance().registerListener(this.bjY);
        MessageManager.getInstance().registerListener(this.grM);
        MessageManager.getInstance().registerListener(this.grO);
        MessageManager.getInstance().registerListener(this.grP);
        MessageManager.getInstance().registerListener(this.grQ);
        MessageManager.getInstance().registerListener(this.grR);
        MessageManager.getInstance().registerListener(this.grA);
        MessageManager.getInstance().registerListener(this.grB);
        MessageManager.getInstance().registerListener(this.grC);
        MessageManager.getInstance().registerListener(this.grN);
        MessageManager.getInstance().registerListener(this.grS);
        MessageManager.getInstance().registerListener(this.grT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean HV() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bPS().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPS().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bPS().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.x.a.NN().bhy.aHZ;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bPS().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bPS().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bPS().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bPS().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPs() {
        if (this.gqB != null && this.gqH != null) {
            this.gqB.JK().a(this.gqH.MQ(), com.baidu.live.gift.u.Fk().Fm(), bPS().gAu.Fq().mLiveInfo);
            lM(true);
            if (this.gqT == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, y.class, bPS().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gqT = (y) runTask.getData();
                } else {
                    return;
                }
            }
            this.gqT.gE("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPt() {
        if (this.gqB != null) {
            this.gqB.JK().hide();
            lM(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(int i, int i2, int i3) {
        if (bPS().gAu.Fq() != null && bPS().gAu.Fq().aEz != null && bPS().gAu.Fq().mLiveInfo != null) {
            a(bPS().gAu.Fq(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(i.class) != null && HV()) {
            if (uVar == null) {
                uVar = bPS().gAu.Fq();
            }
            String valueOf = String.valueOf(uVar.aEz.userId);
            String str2 = uVar.aEz.userName;
            String valueOf2 = String.valueOf(uVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(uVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(uVar.mLiveInfo.feed_id);
            int i6 = uVar.aFb.isBlock;
            String Fz = w.Fz();
            String str3 = uVar.mLiveInfo.appId;
            boolean z2 = uVar.aFb.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (uVar.mLiveInfo.live_type == 1 && uVar.mLiveInfo.screen_direction == 1 && com.baidu.live.x.a.NN().bhy.aHc) {
                z3 = true;
            }
            int i7 = -1;
            if (uVar.aFb == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(uVar.aFb.userId);
                boolean z4 = uVar.aFb.isNewUser;
                i7 = uVar.aFb.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.grl != null && this.grl.bat != null && this.grl.bat.aDf == uVar.aEz.userId) {
                z5 = this.grl.baw;
            }
            i iVar = new i(bPS().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Fz, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (uVar != null && uVar.mLiveInfo != null && uVar.mLiveInfo.mAlaLiveSwitchData != null) {
                iVar.aX(uVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            iVar.fJ(str);
            iVar.aV(z);
            if (com.baidu.tieba.ala.liveroom.w.b.bYg().bhH != null) {
                iVar.aW(com.baidu.tieba.ala.liveroom.w.b.bYg().bhH.aFT != 1);
            }
            ba IR = g.IP().IR();
            if (IR == null || IR.aKi <= 0) {
                i5 = 1000;
            } else {
                i5 = IR.aKi;
            }
            iVar.dB(i5);
            boolean z6 = false;
            if (uVar != null && uVar.aFb != null) {
                String str4 = uVar.aFb.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            iVar.aY(z6);
            boolean z7 = true;
            bj bjVar = com.baidu.live.x.a.NN().bmW;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bjVar != null && bjVar.aKT != null && (!bjVar.aKT.aNf || !bjVar.aKT.aNg)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            iVar.aZ(z7);
            if (uVar != null && uVar.aFd != null) {
                iVar.fI(uVar.aFd.toJsonString());
            }
            if (bPS() != null && bPS().gAu != null) {
                iVar.fK(bPS().gAu.bXB());
            }
            if (!this.grp) {
                this.grq = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, iVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPu() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        eD(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(br brVar) {
        if (brVar != null && HV()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(bPS().pageContext.getPageActivity(), brVar.aLL, brVar.liveId, brVar.aLM)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && com.baidu.live.x.a.NN().bhy != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bPS().pageContext.getPageActivity(), String.valueOf(uVar.mLiveInfo.live_id), String.valueOf(uVar.mLiveInfo.user_id), com.baidu.live.x.a.NN().bhy.aIB, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, NobleDetailInfo nobleDetailInfo) {
        if (HV() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (uVar != null) {
                if (uVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(uVar.mLiveInfo.live_id));
                }
                if (uVar.aEz != null) {
                    hashMap.put("anchor_id", Long.valueOf(uVar.aEz.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.Fz());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bPS().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bPv() {
        if (this.gqH != null) {
            this.gqH.d(this.gql.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bPw() {
        u Fq = bPS().gAu.Fq();
        LogManager.getCommonLogger().doClickQuickImHiLog((Fq == null || Fq.mLiveInfo == null) ? "" : Fq.mLiveInfo.feed_id, KD());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Gp(String str) {
        if (this.gqH != null) {
            this.gqH.gH(str);
        }
    }

    private void bPx() {
        if ("home_rec_play".equals(bPS().fromType) || "frs_play".equals(bPS().fromType) || "frs_live_play".equals(bPS().fromType) || "person_play".equals(bPS().fromType) || "search".equals(bPS().fromType) || "person_attention".equals(bPS().fromType)) {
            com.baidu.live.b.AQ().aU(true);
        } else {
            com.baidu.live.b.AQ().aU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lN(boolean z) {
        View EU;
        if (this.gqD == null) {
            f fVar = new f();
            fVar.aOB = false;
            fVar.context = bPS().pageContext.getPageActivity();
            fVar.aOK = z;
            fVar.fromType = bPS().fromType;
            fVar.aOL = bOo() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, x.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gqD = (x) runTask.getData();
            }
        }
        if (this.gqD != null && (EU = this.gqD.EU()) != null && this.gql.gAv.indexOfChild(EU) < 0) {
            this.gql.gAv.addView(EU, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPy() {
        View FC;
        if (this.gqO == null) {
            ac acVar = new ac();
            acVar.aOB = false;
            acVar.pageContext = bPS().pageContext;
            acVar.fromType = bPS().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, z.class, acVar);
            if (runTask != null && runTask.getData() != null) {
                this.gqO = (z) runTask.getData();
            }
        }
        if (this.gqO != null && (FC = this.gqO.FC()) != null && bPS().gAv.indexOfChild(FC) < 0) {
            if (FC.getParent() instanceof ViewGroup) {
                ((ViewGroup) FC.getParent()).removeView(FC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bPS().gAv.addView(FC, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPz() {
        View Fp;
        if (this.gqE == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aOB = false;
            aVar.context = bPS().pageContext.getPageActivity();
            aVar.fromType = bPS().fromType;
            aVar.aOC = bPS().gAz;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, v.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gqE = (v) runTask.getData();
            }
        }
        if (this.gqE != null && (Fp = this.gqE.Fp()) != null && bPS().gAv.indexOfChild(Fp) < 0) {
            if (Fp.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fp.getParent()).removeView(Fp);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            layoutParams.addRule(3, a.g.ala_live_header_view);
            bPS().gAv.addView(Fp, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bPA() {
        CustomResponsedMessage runTask;
        if (this.gqC == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bPS().pageContext)) != null) {
            this.gqC = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gqC != null) {
            this.gqC.setOtherParams(this.otherParams);
            this.gqC.a(new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.im.b.a.InterfaceC0177a
                public void Kg() {
                    b.this.bPE();
                }
            });
            this.gqC.a(bPS().gAu.Fq(), false);
            View Bo = this.gqC.Bo();
            if (Bo != null && this.grf.indexOfChild(Bo) < 0) {
                Resources resources = bPS().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bPS().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.grf.addView(Bo, layoutParams);
            }
        }
    }

    private void bPB() {
        if (this.gqz == null) {
            this.gqz = new com.baidu.tieba.ala.liveroom.h.a(bPS().pageContext);
        }
        if (this.grk != null) {
            this.gqz.Gt(this.grk.user_id);
        }
        this.gqz.at(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void lO(boolean z) {
        if (bPS() != null && !z) {
            if (this.gqV == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bPS().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gqV = (com.baidu.live.i.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gqV.b(bOX(), bPL());
            if (bPS().gAu != null) {
                this.gqV.a(bPS().gAu.Fq());
            }
            this.gqV.setCanVisible(true);
            this.gqV.bM(true);
            this.gqV.a(bPS().gAu.bJE());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPC() {
        if (bPS() != null) {
            if (this.gqW == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.p.a.class, bPS().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gqW = (com.baidu.live.p.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gqW.setIsHost(false);
            this.gqW.b(bOW(), bPS().gAu.Fq());
        }
    }

    protected void bPD() {
        if (this.gqX == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.p.b.class, bPS().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gqX = (com.baidu.live.p.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bPS().gAu.Fq() != null && bPS().gAu.Fq().aEz != null && bPS().gAu.Fq().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(bPS().pageContext.getPageActivity(), a.e.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(bPS().pageContext.getPageActivity(), a.e.sdk_ds16);
            this.gqX.a(this.gre, layoutParams, bPS().gAu.Fq());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:197:0x0627, code lost:
        Gl(r32);
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
                    if (this.bhb != null) {
                        this.bhb.ca(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        ul(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bPS().gAu.Fq().aFb.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bPS().gAu.Fq().aFb.isAdmin = 0;
                            bPS().gAu.bXl();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bPS().gAu.Fq().aFb.isAdmin = 0;
                        bPS().gAu.bXl();
                    }
                } else if ("task".equals(optString2)) {
                    dy(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gqF != null && !bPS().gAy) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bPS().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bPS().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bPS().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bLr()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gqF.a(bPS().gAt.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bhb != null) {
                                b.this.bhb.bZ(optInt4 == 2);
                            }
                        }
                    });
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.u.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bPS().gAu.Fq() != null && bPS().gAu.Fq().aFb != null && bPS().gAu.Fq().aFb.userId == optLong2) {
                        bPS().gAu.Fq().aFb.isBlock = 1;
                        bOK();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bPS().gAu.Fq() != null && bPS().gAu.Fq().aFb != null && bPS().gAu.Fq().aFb.userId == optLong3) {
                        bPS().gAu.Fq().aFb.isBlock = 0;
                        bOK();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bPS().gAu.Fq() != null && bPS().gAu.Fq().aFb != null && bPS().gAu.Fq().aFb.userId == optLong4) {
                        bPS().gAu.Fq().aFb.isUegBlock = 1;
                        bOK();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bPS().gAu.Fq() != null && bPS().gAu.Fq().aFb != null && bPS().gAu.Fq().aFb.userId == optLong5) {
                        bPS().gAu.Fq().aFb.isUegBlock = 0;
                        bOK();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bPS() != null && bPS().gAu != null && bPS().gAu.Fq() != null && bPS().gAu.Fq().aFb != null) {
                        if (bPS().gAu.Fq().aFb.userId == jSONObject2.optLong("user_id")) {
                            bPS().gAu.bXl();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bPS().gAu.Fq().aFb));
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
                    com.baidu.live.data.a Ko = aVar.Ko();
                    if (Ko != null && w.gC(str3)) {
                        w.d(str3, 1L, "", "", Ko.userId, Ko.portrait, Ko.userName, "", "", false, "", "", "", false, false, true, -1L);
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
                } else if (TextUtils.equals(optString2, "send_redpacket") && (optJSONObject = jSONObject2.optJSONObject("live_redpacket")) != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913221, new RedPacketCharmInfo(optJSONObject)));
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.gqw != null) {
                this.gqw.C(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.data.a Ko2 = aVar.Ko();
            String optString3 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString4 = jSONObject2.optString("gift_count");
            String optString5 = jSONObject2.optString("gift_name");
            String optString6 = jSONObject2.optString("gift_url");
            String optString7 = jSONObject2.optString("attach");
            long optLong7 = jSONObject2.optLong("charm_total");
            String optString8 = jSONObject2.optString("attach_new");
            String optString9 = jSONObject2.optString("gift_mul");
            String str4 = null;
            if (bPS().gAu == null || bPS().gAu.Fq() == null || bPS().gAu.Fq().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j4 = bPS().gAu.Fq().mLiveInfo.live_id;
                long j5 = bPS().gAu.Fq().mLiveInfo.group_id;
                long j6 = bPS().gAu.Fq().aEz.userId;
                str4 = bPS().gAu.Fq().mLiveInfo.appId;
                j = j6;
                j2 = j4;
                j3 = j5;
            }
            if (!TextUtils.isEmpty(optString8) && !TextUtils.isEmpty(optString9)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    w.b(optString9, Ko2.userId, Ko2.portrait, Ko2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString9);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                } else if (com.baidu.live.x.d.NU().ht(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                w.b(optString3, JavaTypesHelper.toInt(optString4, 1), optString5, optString6, Ko2.userId, Ko2.portrait, Ko2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7, "", "", aVar.getMsgId());
                Gl(optString3);
            }
            com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
            cVar.gzZ = optLong7;
            cVar.liveId = j2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
        }
    }

    protected void Gl(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bPE() {
        if (bPF()) {
            BdUtilHelper.hideSoftKeyPad(bPS().pageContext.getPageActivity(), bPS().gAt.getLiveContainerView());
            bOU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bPF() {
        if (bOT() == null || bOT().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(u uVar) {
        CustomResponsedMessage runTask;
        bPS().gAv.setOnTouchListener(this.grU);
        bPM();
        bPN();
        bPO();
        bPB();
        bPD();
        if (this.gqu != null && bPS().gAu.Fq() != null && bPS().gAu.Fq().mLiveInfo != null) {
            this.gqu.ch(bPS().gAu.Fq().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gqA != null) {
            this.gqA.h(bPS().gAu.Fq());
        }
        if (this.gqy != null) {
            this.gqy.i(bPS().gAu.Fq());
        }
        if (this.gqG != null) {
            this.gqG.c(bPS().gAu.Fq(), KD());
        }
        if (this.gqH != null) {
            this.gqH.b(bPS().gAu.Fq(), KD());
        }
        if (this.gqI != null) {
            this.gqI.c(bPS().gAu.Fq(), KD());
        }
        if (bPS().gAv != null) {
            bPS().gAv.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean P = b.this.P(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bPF() && b.this.gqt != null) {
                        b.this.gqt.mG(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gqt != null) {
                        b.this.gqt.mG(true);
                    }
                    return P;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean Mb() {
                    if (b.this.grv == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.grv) {
                        if (bVar.Mb()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bPS().gAv.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.O(motionEvent);
                }
            });
        }
        if (this.gqT == null && (runTask = MessageManager.getInstance().runTask(2913165, y.class, bPS().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gqT = (y) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPG() {
        u Fq;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (bPS() != null && bPS().gAu != null && (Fq = bPS().gAu.Fq()) != null && Fq.mLiveInfo != null && !Fq.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bPS().gAt) != null) {
            if (this.gqY == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.t.a.class, bPS().pageContext)) != null && runTask.getData() != null) {
                this.gqY = (com.baidu.live.t.a) runTask.getData();
            }
            if (this.gqY != null) {
                this.gqY.p(Fq);
                this.gqY.a(this.grV);
                this.gqY.a(viewGroup, (ViewGroup) viewGroup.findViewById(a.g.ala_live_header_view));
                a(this.gqY.Nh());
                a(this.gqY.Ni());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gru == null) {
            this.gru = new ArrayList();
        }
        if (!this.gru.contains(dVar)) {
            this.gru.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gru != null && this.gru.contains(dVar)) {
            this.gru.remove(dVar);
        }
    }

    protected void bPH() {
        if (this.gru != null) {
            this.gru.clear();
            this.gru = null;
        }
    }

    protected boolean O(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gru == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gru.iterator();
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
        if (this.grv == null) {
            this.grv = new ArrayList();
        }
        if (!this.grv.contains(bVar)) {
            this.grv.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.grv != null && this.grv.contains(bVar)) {
            this.grv.remove(bVar);
        }
    }

    protected void bPI() {
        if (this.grv != null) {
            this.grv.clear();
            this.grv = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.grv == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.grv.iterator();
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
    public void bPJ() {
        if (this.gqU == null && this.gra != null && this.gra.aLd && bPS() != null && bPS().gAu != null && bPS().gAu.Fq() != null) {
            this.gqU = new com.baidu.tieba.ala.liveroom.h.e(bPS().pageContext, this.gra);
            this.gqU.v(bPS().gAu.Fq());
            if (this.gra.aLg == 1) {
                if (this.gqB != null) {
                    this.grn = true;
                }
            } else if (this.gra.aLg == 2) {
                a(bPS().gAu.Fq(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bPK() {
        CustomResponsedMessage runTask;
        if (bPS() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bPS().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.u.a)) {
            this.grb = (com.baidu.live.u.a) runTask.getData();
            this.grb.s(bOW());
            if (bPS().gAu != null) {
                this.gro = this.grb.q(bPS().gAu.Fq());
            }
            this.grb.setCanVisible(!this.gri);
        }
    }

    private ViewGroup.LayoutParams bPL() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.gqX != null && this.gqX.isShowing()) {
            layoutParams.addRule(3, a.g.ala_rank_level_entry);
            layoutParams.topMargin = bPS().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int J(boolean z, boolean z2) {
        Rect rect = new Rect();
        bPS().gAt.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bPS().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bPS().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bPS().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bPS().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bPM() {
        if (this.gqt != null) {
            this.gqt.aA(bPS().gAv);
        }
    }

    private void bPN() {
        if (this.gqu != null) {
            this.gqu.aC(bPS().gAv);
        }
    }

    private void bPO() {
        if (this.gqx == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.z.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gqx = (com.baidu.live.z.a) runTask.getData();
            }
            bPP();
        }
    }

    private void dy(JSONObject jSONObject) {
        if (this.gqx != null) {
            if (this.gqq != null) {
                this.gqx.cq(this.gqq.bTE() ? false : true);
            } else {
                this.gqx.cq(true);
            }
            this.gqx.Q(jSONObject);
        }
    }

    private void bPP() {
        if (this.gqx != null && bPS().gAu.Fq() != null && bPS().gAu.Fq().aFm != null) {
            if (this.gqq != null) {
                this.gqx.cq(this.gqq.bTE() ? false : true);
            } else {
                this.gqx.cq(true);
            }
            this.gqx.k(bPS().gAu.Fq());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void l(u uVar) {
        if (uVar != null) {
            if (this.gqu != null && uVar.mLiveInfo != null) {
                this.gqu.ch(uVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gqL != null) {
                this.gqL.j(uVar);
            }
            bPP();
            if (this.gqz != null && uVar.aEz != null) {
                this.gqz.Gt(String.valueOf(uVar.aEz.userId));
            }
            if (this.gqn != null) {
                this.gqn.a(uVar);
            }
            if (this.gqE != null && uVar.mLiveInfo != null) {
                this.gqE.a(uVar.mLiveInfo, uVar.aEz);
            }
            if (this.gqC != null) {
                this.gqC.a(uVar);
            }
            if (this.grb != null) {
                this.gro = this.grb.q(uVar);
            }
            if (this.gqV != null) {
                this.gqV.a(uVar);
            }
            if (this.gqW != null) {
                this.gqW.a(uVar);
            }
            if (this.gqX != null) {
                this.gqX.a(uVar);
            }
            ul(uVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void ul(int i) {
        if (!bPS().gAy) {
            if (this.grg < 0 && i == 0) {
                this.grg = i;
            } else if (this.grg != i) {
                if (i == 1) {
                    if (!this.gqF.uY(2)) {
                        String string = bPS().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bPS().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gqF.a(bPS().gAt.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bPS().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.gqF.uZ(2);
                    this.gqF.uZ(3);
                    if (bLr()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gqF.a(bPS().gAt.getLiveContainerView(), string2, 3);
                    }
                }
                this.grg = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cd(boolean z) {
        super.cd(z);
        if (z) {
            bPQ();
        }
        if (this.gqL != null) {
            this.gqL.Lv();
        }
        if (this.gqy != null) {
            this.gqy.Lv();
        }
        if (this.gqw != null) {
            this.gqw.bZr();
        }
        if (this.gqo != null) {
            this.gqo.BQ();
        }
        if (this.gqq != null) {
            this.gqq.onDestroy();
        }
        if (this.gqx != null) {
            this.gqx.onDestroy();
            this.gqx = null;
        }
        if (this.gqD != null) {
            View EU = this.gqD.EU();
            if (EU != null && EU.getParent() != null) {
                ((ViewGroup) EU.getParent()).removeView(EU);
            }
            this.gqD.onDestroy();
            this.gqD = null;
        }
        if (this.gqC != null) {
            this.gqC.a((a.InterfaceC0177a) null);
            this.gqC.Bq();
        }
        if (this.gqF != null) {
            this.gqF.BQ();
        }
        this.grg = -1;
        if (this.gqz != null) {
            this.gqz.BQ();
            this.gqz.onDestroy();
        }
        if (this.gqr != null) {
            this.gqr.bZp();
        }
        if (this.gqs != null) {
            this.gqs.bOl();
            this.gqs.FB();
        }
        if (this.gqt != null) {
            this.gqt.FB();
        }
        if (this.gqA != null) {
            this.gqA.FB();
        }
        if (this.gqG != null) {
            this.gqG.Lv();
        }
        if (this.gqH != null) {
            this.gqH.FB();
        }
        if (this.gqI != null) {
            this.gqI.onDestroy();
        }
        if (this.gqK != null) {
            this.gqK.onDestory();
        }
        if (this.gqN != null) {
            this.gqN.IT();
        }
        if (this.gqM != null) {
            this.gqM.IT();
        }
        if (this.gqX != null) {
            this.gqX.IT();
        }
        if (this.gqU != null) {
            this.gqU.onDestroy();
        }
        if (this.gqP != null) {
            this.gqP.FB();
        }
        if (this.grd != null) {
            this.grd.FB();
        }
        if (this.gqQ != null) {
            this.gqQ.FB();
        }
        if (this.gqR != null) {
            this.gqR.FB();
        }
        if (this.gqT != null) {
            this.gqT.FB();
        }
        if (this.gqp != null) {
            this.gqp.onDestory();
        }
        if (this.grb != null) {
            this.grb.FB();
        }
        if (this.gqV != null) {
            this.gqV.IT();
        }
        if (this.gqW != null) {
            this.gqW.IT();
        }
        if (this.gqS != null) {
            this.gqS.FB();
        }
        if (this.gqO != null) {
            this.gqO.onDestroy();
        }
        if (this.gqY != null) {
            this.gqY.BQ();
            b(this.gqY.Nh());
            b(this.gqY.Ni());
        }
        if (this.gqZ != null) {
            this.gqZ.IT();
        }
        ShowUtil.windowCount = 0;
        bPH();
        bPI();
    }

    private void bPQ() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bPS().gAv.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bPS().gAv.getChildAt(i);
            if (childAt != this.gre && childAt != this.grf) {
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
        if (this.gre != null) {
            this.gre.removeAllViews();
        }
        if (this.grf != null) {
            this.grf.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, u uVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void o(u uVar) {
        View Bo;
        View EU;
        if (this.gqD != null && (EU = this.gqD.EU()) != null && EU.getParent() != null) {
            ((ViewGroup) EU.getParent()).removeView(EU);
        }
        if (this.gqC != null && (Bo = this.gqC.Bo()) != null && Bo.getParent() != null) {
            ((ViewGroup) Bo.getParent()).removeView(Bo);
        }
        if (this.gqq != null) {
            this.gqq.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean LX() {
        if (this.gqv == null || !this.gqv.bTJ()) {
            if (this.gqq == null || !this.gqq.aw(bPS().gAt.getLiveContainerView())) {
                if (this.gqt != null) {
                    this.gqt.bLY();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gqJ != null && this.gqJ.bTs()) {
                    this.gqJ.bTB();
                    return false;
                } else if (this.gqI == null || !this.gqI.bTM()) {
                    bPx();
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
        if (this.gqL != null) {
            this.gqL.release();
        }
        if (this.gqy != null) {
            this.gqy.onDestroy();
        }
        if (this.gqx != null) {
            this.gqx.onDestroy();
            this.gqx = null;
        }
        if (this.gqw != null) {
            this.gqw.bZr();
        }
        if (this.gqD != null) {
            this.gqD.onDestroy();
            this.gqD = null;
        }
        if (this.gqE != null) {
            this.gqE.onDestroy();
            this.gqE = null;
        }
        if (this.gqF != null) {
            this.gqF.onDestroy();
        }
        if (this.gqo != null) {
            this.gqo.onDestroy();
        }
        if (this.gqO != null) {
            this.gqO.onDestroy();
            this.gqO = null;
        }
        if (this.gqC != null) {
            this.gqC.a((a.InterfaceC0177a) null);
            this.gqC.release();
            this.gqC = null;
        }
        if (this.gqG != null) {
            this.gqG.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gqG.release();
        }
        if (this.gqH != null) {
            this.gqH.a(null);
            this.gqH.release();
        }
        if (this.gqI != null) {
            this.gqI.a((a.InterfaceC0633a) null);
            this.gqI.onDestroy();
        }
        if (this.gqM != null) {
            this.gqM.onDestroy();
        }
        if (this.gqN != null) {
            this.gqN.onDestroy();
        }
        if (this.gqK != null) {
            this.gqK.onDestory();
        }
        if (this.gqX != null) {
            this.gqX.onDestroy();
        }
        if (this.gqU != null) {
            this.gqU.onDestroy();
        }
        if (this.gqP != null) {
            this.gqP.release();
        }
        if (this.grd != null) {
            this.grd.release();
        }
        if (this.gqS != null) {
            this.gqS.release();
        }
        if (this.gqQ != null) {
            this.gqQ.release();
        }
        if (this.gqR != null) {
            this.gqR.release();
        }
        if (this.gqT != null) {
            this.gqT.release();
        }
        if (this.gqp != null) {
            this.gqp.onDestory();
        }
        if (this.grb != null) {
            this.grb.release();
        }
        if (this.gqV != null) {
            this.gqV.onDestroy();
        }
        if (this.gqW != null) {
            this.gqW.onDestroy();
        }
        if (this.gqt != null) {
            this.gqt.FB();
        }
        if (this.gqY != null) {
            this.gqY.onDestroy();
            b(this.gqY.Nh());
            b(this.gqY.Ni());
        }
        bPH();
        bPI();
        MessageManager.getInstance().unRegisterListener(this.grA);
        MessageManager.getInstance().unRegisterListener(this.grB);
        MessageManager.getInstance().unRegisterListener(this.grC);
        MessageManager.getInstance().unRegisterListener(this.grH);
        MessageManager.getInstance().unRegisterListener(this.grI);
        MessageManager.getInstance().unRegisterListener(this.grK);
        MessageManager.getInstance().unRegisterListener(this.grD);
        MessageManager.getInstance().unRegisterListener(this.grE);
        MessageManager.getInstance().unRegisterListener(this.grG);
        MessageManager.getInstance().unRegisterListener(this.grF);
        MessageManager.getInstance().unRegisterListener(this.fTe);
        MessageManager.getInstance().unRegisterListener(this.grL);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gcS);
        MessageManager.getInstance().unRegisterListener(this.gcP);
        MessageManager.getInstance().unRegisterListener(this.bjY);
        MessageManager.getInstance().unRegisterListener(this.grM);
        MessageManager.getInstance().unRegisterListener(this.grO);
        MessageManager.getInstance().unRegisterListener(this.grP);
        MessageManager.getInstance().unRegisterListener(this.grQ);
        MessageManager.getInstance().unRegisterListener(this.grN);
        MessageManager.getInstance().unRegisterListener(this.grR);
        MessageManager.getInstance().unRegisterListener(this.grS);
        MessageManager.getInstance().unRegisterListener(this.grT);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gqG != null) {
            this.gqG.mn(false);
        }
        if (this.gqI != null) {
            this.gqI.mn(false);
        }
        bOU();
        if (this.gqL != null) {
            this.gqL.onPause();
        }
        if (this.gqP != null) {
            this.gqP.pause();
        }
        if (this.grd != null) {
            this.grd.pause();
        }
        if (this.gqS != null) {
            this.gqS.pause();
        }
        if (this.gqQ != null) {
            this.gqQ.pause();
        }
        if (this.gqO != null) {
            this.gqO.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.grq = false;
        if (this.grj && this.grk != null) {
            a(this.grk);
            this.grj = false;
        }
        if (this.gqG != null) {
            this.gqG.mn(true);
        }
        if (this.gqI != null) {
            this.gqI.mn(true);
        }
        if (this.gqL != null) {
            this.gqL.onResume();
        }
        if (this.gqP != null) {
            this.gqP.resume();
        }
        if (this.grd != null) {
            this.grd.resume();
        }
        if (this.gqS != null) {
            this.gqS.resume();
        }
        if (this.gqO != null) {
            this.gqO.onResume();
        }
        if (this.gqQ != null) {
            this.gqQ.resume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aoL() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gqY != null && this.gqY.isOpen()) {
            this.gqY.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            aoL();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    K(-1, -1, -1);
                    return;
                }
                return;
            }
            aoL();
        } else if (i == 25034) {
            bPu();
        } else if (i == 25043) {
            if (i2 == -1) {
                bPT();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.m.a.D(bPS().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.m.a.D(bPS().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gri = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bPR() {
        return (bPS().gAu.Fq() == null || bPS().gAu.Fq().mLiveInfo == null || bPS().gAu.Fq().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gqq != null) {
                this.gqq.D(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gqI != null) {
            this.gqI.bbL();
        }
        if (this.gqp != null) {
            this.gqp.bbL();
        }
        if (this.gqY != null) {
            this.gqY.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gql = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bPS() {
        return this.gql;
    }

    private void bPT() {
        String IQ = g.IP().IQ();
        if (!TextUtils.isEmpty(IQ)) {
            try {
                K(-1, Integer.parseInt(IQ), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                K(-1, -1, -1);
            }
        }
    }

    public boolean eC(int i) {
        if (1 == i) {
            if (bOT() != null) {
                bOT().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gri) {
                return false;
            }
            return this.gqq == null || !this.gqq.bTE();
        } else if (3 == i) {
            if (bPS().gAv != null) {
                bPS().gAv.setEnabled(false);
                if (this.bhb != null) {
                    this.bhb.e(!bPS().gAw, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void uj(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void eD(int i) {
        if (3 == i) {
            bPS().gAv.setEnabled(true);
            if (this.bhb != null) {
                this.bhb.e(!bPS().gAw, true);
            }
            if (this.gqx != null) {
                this.gqx.cq(true);
            }
        } else if (2 == i && this.gqw != null) {
            this.gqw.mO(true);
        }
    }

    public String KD() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gqC != null) {
            this.gqC.setOtherParams(str);
        }
        if (this.gqL != null) {
            this.gqL.hi(str);
        }
    }

    private boolean bLr() {
        return bPS().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fAJ = alaLastLiveroomInfo;
    }
}
