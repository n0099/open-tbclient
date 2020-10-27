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
import com.baidu.live.data.ag;
import com.baidu.live.data.ap;
import com.baidu.live.data.ay;
import com.baidu.live.data.bd;
import com.baidu.live.data.bm;
import com.baidu.live.data.bn;
import com.baidu.live.data.bw;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.af;
import com.baidu.live.gift.aj;
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
    public static boolean gRC;
    protected AlaLastLiveroomInfo fVh;
    protected com.baidu.live.ai.a gFm;
    protected com.baidu.live.y.a gPR;
    protected com.baidu.tieba.ala.liveroom.b.b gQA;
    protected com.baidu.tieba.ala.liveroom.praise.a gQB;
    protected com.baidu.tieba.ala.liveroom.sticker.a gQC;
    protected com.baidu.tieba.ala.liveroom.guide.d gQD;
    protected com.baidu.tieba.ala.liveroom.x.a gQE;
    protected com.baidu.live.ac.a gQF;
    protected com.baidu.live.ac.d gQG;
    private com.baidu.tieba.ala.liveroom.h.a gQH;
    private m gQI;
    k gQJ;
    com.baidu.live.im.b.a gQK;
    protected ac gQL;
    protected aa gQM;
    protected com.baidu.tieba.ala.liveroom.tippop.a gQN;
    private com.baidu.tieba.ala.liveroom.guideim.b gQO;
    protected com.baidu.live.view.input.c gQP;
    com.baidu.tieba.ala.liveroom.o.b gQQ;
    protected com.baidu.tieba.ala.liveroom.guide.a gQR;
    private com.baidu.live.guardclub.k gQS;
    protected com.baidu.live.k.b gQT;
    protected h gQU;
    protected j gQV;
    protected af gQW;
    protected e gQX;
    protected com.baidu.tieba.ala.liveroom.m.b gQY;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b gQZ;
    private com.baidu.tieba.ala.liveroom.data.a gQt;
    protected com.baidu.tieba.ala.liveroom.operation.a gQu;
    protected com.baidu.live.h.a gQv;
    protected com.baidu.tieba.ala.liveroom.share.c gQw;
    protected com.baidu.tieba.ala.liveroom.s.b gQx;
    protected com.baidu.tieba.ala.liveroom.guide.c gQy;
    protected com.baidu.tieba.ala.liveroom.watermark.a gQz;
    public boolean gRA;
    public boolean gRB;
    protected com.baidu.tieba.ala.liveroom.u.b gRD;
    protected com.baidu.tieba.ala.liveroom.j.e gRE;
    protected List<com.baidu.live.liveroom.g.d> gRF;
    protected List<com.baidu.live.liveroom.g.b> gRG;
    CustomMessageTask gRH;
    CustomMessageTask gRI;
    protected com.baidu.tieba.ala.liveroom.r.c gRa;
    private ae gRb;
    protected com.baidu.tieba.ala.liveroom.h.e gRc;
    protected com.baidu.live.j.a gRd;
    protected com.baidu.live.q.a gRe;
    protected com.baidu.live.i.a gRf;
    protected com.baidu.live.q.b gRg;
    protected com.baidu.live.u.a gRh;
    protected com.baidu.tieba.ala.liveroom.exclusive.b gRi;
    protected bn gRj;
    protected com.baidu.live.v.a gRk;
    protected com.baidu.tieba.ala.liveroom.f.a gRl;
    protected com.baidu.tieba.ala.player.d gRm;
    private com.baidu.live.guess.a gRn;
    protected RelativeLayout gRo;
    protected RelativeLayout gRp;
    protected boolean gRr;
    protected ap gRu;
    protected GuardClubInfoHttpResponseMessage gRv;
    boolean gRw;
    boolean gRx;
    boolean gRy;
    protected String otherParams;
    private int gRq = -1;
    protected int mOrientation = 0;
    protected boolean gRs = false;
    protected boolean gRt = false;
    private int gRz = a.C0195a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> gRJ = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: bWl */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> gRK = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener gRL = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ag agVar;
            if ((customResponsedMessage.getData() instanceof ag) && (agVar = (ag) customResponsedMessage.getData()) != null) {
                b.this.a(agVar.aJv, agVar.aJr, agVar.aJs, agVar.aJt, agVar.aJu);
            }
        }
    };
    private CustomMessageListener gRM = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.vi(7);
        }
    };
    private CustomMessageListener gRN = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.bVI();
        }
    };
    private CustomMessageListener gRO = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.bWj().haB.GH().aIe.userId);
            com.baidu.live.view.a.TX().a(valueOf, new f(b.this.bWj().haB.GH().aIe.portrait, valueOf, true, b.this.bWj().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener gRP = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && b.this.gQw != null) {
                b.this.gQw.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener bpy = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gQJ != null) {
                b.this.gQJ.g(z.GB().GD());
            }
        }
    };
    private CustomMessageListener gRQ = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.gQt.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                b.this.Hy(str);
            }
        }
    };
    private CustomMessageListener gRR = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.bWj().pageContext.getPageActivity());
            } else if (b.this.gQw != null) {
                b.this.gQw.c(b.this.bWj().haB.GH(), false);
            }
        }
    };
    private CustomMessageListener gRS = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ap) {
                    b.this.gRt = true;
                    b.this.gRu = (ap) data;
                    b.this.b(b.this.gRu);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                }
            }
        }
    };
    private CustomMessageListener gRT = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.bWj().haB.GH().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.bWj().haB.GH().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.bWj().haB.GH().aIe.userId);
                    if (b.this.gQx == null) {
                        b.this.gQx = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    b.this.gQx.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.gQx.a(b.this.gRU);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b gRU = new e.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void Om() {
            if (b.this.bWj().haB.GH() != null && b.this.bWj().haB.GH().aIA != null) {
                b.this.bWj().haB.GH().aIA.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener gRV = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) customResponsedMessage.getData();
                if (b.this.gQT != null) {
                    b.this.gQT.y(aVar);
                }
                if (b.this.gRi != null) {
                    b.this.gRi.C(aVar);
                }
                if (b.this.gRf != null) {
                    b.this.gRf.l(aVar);
                }
                b.this.s(aVar);
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener gRW = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.gRw = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gQQ != null) {
                b.this.gQQ.GU();
            }
        }
    };
    HttpMessageListener gzn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bfe) != null && b.this.gQS != null && b.this.bWj() != null && b.this.bWj().haB != null) {
                int[] iArr = new int[2];
                b.this.gRo.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.gQS.a(b.this.gRo, layoutParams, aVar, b.this.bWj().haB.GH());
                com.baidu.live.o.a.aC(aVar.liveId + "", "guard_club_join");
                com.baidu.live.n.a.b(b.this.bWj().haB.GH().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gzk = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.bWj() != null && b.this.bWj().haB != null && b.this.bWj().haB.GH() != null && guardClubInfoHttpResponseMessage.bfe != null) {
                    if (guardClubInfoHttpResponseMessage.bfe.anchorId == b.this.bWj().haB.GH().aIe.userId) {
                        b.this.gRv = guardClubInfoHttpResponseMessage;
                        if (b.this.gRv.bfh && com.baidu.live.guardclub.e.Ke() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.Ke().ai(b.this.bWj().haB.GH().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener gRX = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bw) {
                b.this.a((bw) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gRY = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (b.this.gQY != null) {
                    b.this.gQY.ev(bVar.url, bVar.aGR);
                }
            }
        }
    };
    private CustomMessageListener gRZ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.x(b.this.bWj().haB.GH());
        }
    };
    private CustomMessageListener gSa = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.gRd != null) {
                b.this.gRd.Kx();
            }
        }
    };
    private CustomMessageListener gSb = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.gQW != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) b.this.gQW).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gSc = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.bWj().haB.GH(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gFn = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ai.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.gFm == null) {
                b.this.gFm = new com.baidu.live.ai.a(b.this.bWj().pageContext.getPageActivity());
            }
            b.this.gFm.a((com.baidu.live.ai.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener gSd = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.bWj().pageContext.getPageActivity() != null) {
                com.baidu.live.n.a.t(b.this.bWj().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener gSe = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.bVV();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.u.b gSf = new com.baidu.live.u.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        @Override // com.baidu.live.u.b
        public boolean OM() {
            if (b.this.bWj().haC != null) {
                if (b.this.bWj().haC.getKeyboardVisibility()) {
                    return false;
                }
                if (!b.this.bWj().haC.cfw()) {
                    b.this.gRh.close();
                    return false;
                } else if (b.this.bWj().haC.getScrollX() != 0) {
                    b.this.gRh.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void a(ap apVar);

    protected abstract void b(ap apVar);

    public abstract boolean bUC();

    protected abstract void bUY();

    protected abstract View bVh();

    public abstract boolean bVi();

    protected abstract boolean bVj();

    protected abstract ViewGroup bVk();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bn bnVar) {
        this.gRj = bnVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.gRo = (RelativeLayout) bWj().haC.findViewById(a.g.ala_live_header_view);
        this.gRp = (RelativeLayout) bWj().haC.findViewById(a.g.ala_live_footer_view);
        Hx();
        registerListener();
    }

    public void bVp() {
    }

    private void Hx() {
        if (this.gQw == null) {
            this.gQw = new com.baidu.tieba.ala.liveroom.share.c(bWj().pageContext);
        }
        this.gQE = new com.baidu.tieba.ala.liveroom.x.a(bWj().pageContext, this);
        this.gQA = new com.baidu.tieba.ala.liveroom.b.b(bWj().pageContext, false);
        this.gQB = new com.baidu.tieba.ala.liveroom.praise.a(bWj().pageContext);
        this.gQC = new com.baidu.tieba.ala.liveroom.sticker.a(bWj().pageContext);
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
                this.gQD = new com.baidu.tieba.ala.liveroom.guide.d(bWj().pageContext);
            }
        }
        this.gQN = new com.baidu.tieba.ala.liveroom.tippop.a(bWj().pageContext, this);
        bVt();
        bVv();
        bVw();
        bVx();
        bVC();
        bVD();
        bVE();
        bVq();
        bVs();
        bVr();
        bVF();
    }

    private void bVq() {
        this.gQY = new com.baidu.tieba.ala.liveroom.m.b(bWj().pageContext.getPageActivity());
    }

    private void bVr() {
        CustomResponsedMessage runTask;
        if (this.gQG == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ac.d.class, bWj().pageContext)) != null && runTask.getData() != null) {
            this.gQG = (com.baidu.live.ac.d) runTask.getData();
        }
    }

    private void bVs() {
        CustomResponsedMessage runTask;
        if (this.gQT == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.k.b.class, bWj().pageContext)) != null && runTask.getData() != null) {
            this.gQT = (com.baidu.live.k.b) runTask.getData();
            this.gQT.c(bWj().pageContext);
            this.gQT.MT().setTargetView(this.gRp);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.gRl == null) {
            this.gRl = new com.baidu.tieba.ala.liveroom.f.a(bWj().pageContext);
            this.gRl.setId(a.g.ala_live_room_back_to_last_live);
        }
        this.gRl.a(bWj().haB.GH(), alaLastLiveroomInfo);
        this.gRl.av(this.gRp);
    }

    private void bVt() {
        this.gQI = new m();
    }

    public void mD(boolean z) {
        this.gRr = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVu() {
        w GH = bWj().haB.GH();
        boolean z = com.baidu.live.z.a.Pq().bmJ.aMi;
        if (GH.mLiveInfo != null && GH.mLiveInfo.mAlaLiveSwitchData != null && GH.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = GH.aIO ? z : false;
        if (z2) {
            if (this.gQv == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bWj().pageContext);
                if (runTask != null) {
                    this.gQv = (com.baidu.live.h.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.gQv != null) {
                this.gQv.eF(1);
                View view = this.gQv.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bWj().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bWj().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.g.ala_liveroom_hostheader);
                    bW(view);
                    this.gRo.addView(view, layoutParams);
                    if (z2) {
                        this.gQv.a(GH);
                    }
                }
            }
        }
    }

    private void bVv() {
        this.gQO = new com.baidu.tieba.ala.liveroom.guideim.b(bWj().pageContext);
        this.gQO.c(this.gRp, bUC());
        this.gQO.a(new com.baidu.tieba.ala.liveroom.guideim.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.21
            @Override // com.baidu.tieba.ala.liveroom.guideim.a
            public boolean Lm() {
                return b.this.Jl();
            }
        });
    }

    private void bVw() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.c.class, bWj().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gQP = (com.baidu.live.view.input.c) runTask.getData();
            this.gQP.a(new c.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.22
                @Override // com.baidu.live.view.input.c.a
                public void Us() {
                    b.this.vi(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public void Ut() {
                    b.this.eP(11);
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean Lm() {
                    return b.this.Jl();
                }

                @Override // com.baidu.live.view.input.c.a
                public boolean LN() {
                    return b.this.bVA();
                }

                @Override // com.baidu.live.view.input.c.a
                public int Lr() {
                    return b.this.bVB();
                }
            });
        }
    }

    private void bVx() {
        this.gQQ = new com.baidu.tieba.ala.liveroom.o.b(this.gQt.pageContext);
        this.gQQ.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public boolean bWm() {
                return b.this.bVj();
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void onClose() {
                if (b.this.bmm != null) {
                    b.this.bmm.cd(false);
                }
            }
        });
    }

    private void bVy() {
        if (this.gRn == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.gRn = (com.baidu.live.guess.a) runTask.getData();
                this.gRn.r(getActivity());
            } else {
                return;
            }
        }
        this.gRn.eG(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void mE(boolean z) {
        if (this.gQO != null) {
            this.gQO.ng(z);
        }
        if (this.gQQ != null) {
            this.gQQ.ng(z);
        }
        gRC = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bVz() {
        return gRC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean bVA() {
        w GH;
        if (bWj() == null || bWj().haB == null || (GH = bWj().haB.GH()) == null || GH.aIA == null) {
            return false;
        }
        String str = GH.aIA.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bVB() {
        w GH;
        if (bWj() != null && bWj().haB != null && (GH = bWj().haB.GH()) != null && !ListUtils.isEmpty(GH.aIJ)) {
            for (AlaLiveMarkData alaLiveMarkData : GH.aIJ) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void bVC() {
        if (this.gQS == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, bWj().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gQS = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.gQS.setOtherParams(Md());
    }

    private void bVD() {
        if (this.gQX == null) {
            this.gQX = new com.baidu.tieba.ala.liveroom.turntable.e(bWj().pageContext.getPageActivity());
        }
    }

    private void bVE() {
        if (this.gRa == null) {
            this.gRa = new com.baidu.tieba.ala.liveroom.r.c(bWj().pageContext.getPageActivity());
        }
    }

    private void bVF() {
        if (this.gFm == null) {
            this.gFm = new com.baidu.live.ai.a(bWj().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.gRH == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.gRH = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.gRJ);
            this.gRH.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gRH);
        }
        if (this.gRI == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.gRI = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.gRK);
            this.gRI.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.gRI);
        }
        MessageManager.getInstance().registerListener(this.gRS);
        MessageManager.getInstance().registerListener(this.gRT);
        MessageManager.getInstance().registerListener(this.gRV);
        MessageManager.getInstance().registerListener(this.gRO);
        MessageManager.getInstance().registerListener(this.gRP);
        MessageManager.getInstance().registerListener(this.gRR);
        MessageManager.getInstance().registerListener(this.gRQ);
        MessageManager.getInstance().registerListener(this.gpA);
        MessageManager.getInstance().registerListener(this.gRW);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gzn);
        MessageManager.getInstance().registerListener(this.gzk);
        MessageManager.getInstance().registerListener(this.bpy);
        MessageManager.getInstance().registerListener(this.gRX);
        MessageManager.getInstance().registerListener(this.gRZ);
        MessageManager.getInstance().registerListener(this.gSa);
        MessageManager.getInstance().registerListener(this.gSb);
        MessageManager.getInstance().registerListener(this.gSc);
        MessageManager.getInstance().registerListener(this.gRL);
        MessageManager.getInstance().registerListener(this.gRM);
        MessageManager.getInstance().registerListener(this.gRN);
        MessageManager.getInstance().registerListener(this.gRY);
        MessageManager.getInstance().registerListener(this.gFn);
        MessageManager.getInstance().registerListener(this.gSd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jl() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(bWj().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bWj().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bWj().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.z.a.Pq().bmJ.aLH;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = bWj().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt);
        } else {
            string = bWj().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.bWj().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bWj().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVG() {
        if (this.gQJ != null && this.gQP != null) {
            this.gQJ.Lk().a(this.gQP.Ot(), z.GB().GD(), bWj().haB.GH().mLiveInfo);
            mE(true);
            if (this.gRb == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, ae.class, bWj().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gRb = (ae) runTask.getData();
                } else {
                    return;
                }
            }
            this.gRb.hd("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVH() {
        if (this.gQJ != null) {
            this.gQJ.Lk().hide();
            mE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i, int i2, int i3) {
        if (bWj().haB.GH() != null && bWj().haB.GH().aIe != null && bWj().haB.GH().mLiveInfo != null) {
            a(bWj().haB.GH(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.b.k.class) != null && Jl()) {
            if (wVar == null) {
                wVar = bWj().haB.GH();
            }
            String valueOf = String.valueOf(wVar.aIe.userId);
            String str2 = wVar.aIe.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aIA.isBlock;
            String GQ = ab.GQ();
            String str3 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aIA.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.z.a.Pq().bmJ.aKI) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aIA == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(wVar.aIA.userId);
                boolean z4 = wVar.aIA.isNewUser;
                i7 = wVar.aIA.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.gRv != null && this.gRv.bfe != null && this.gRv.bfe.anchorId == wVar.aIe.userId) {
                z5 = this.gRv.bfh;
            }
            com.baidu.live.b.k kVar = new com.baidu.live.b.k(bWj().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, GQ, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bc(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.fX(str);
            kVar.ba(z);
            if (com.baidu.tieba.ala.liveroom.w.b.ceK().bmT != null) {
                kVar.bb(com.baidu.tieba.ala.liveroom.w.b.ceK().bmT.aJz != 1);
            }
            bd Kh = g.Kf().Kh();
            if (Kh == null || Kh.aNS <= 0) {
                i5 = 1000;
            } else {
                i5 = Kh.aNS;
            }
            kVar.dG(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aIA != null) {
                String str4 = wVar.aIA.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.bd(z6);
            boolean z7 = true;
            bm bmVar = com.baidu.live.z.a.Pq().bsy;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (bmVar != null && bmVar.aOD != null && (!bmVar.aOD.aQU || !bmVar.aOD.aQV)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.be(z7);
            if (wVar != null && wVar.aIE != null) {
                kVar.fW(wVar.aIE.toJsonString());
            }
            if (bWj() != null && bWj().haB != null) {
                kVar.fY(bWj().haB.cea());
            }
            if (!this.gRA) {
                this.gRB = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVI() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        eP(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bw bwVar) {
        if (bwVar != null && Jl()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(bWj().pageContext.getPageActivity(), bwVar.aPz, bwVar.liveId, bwVar.aPA)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.z.a.Pq().bmJ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bWj().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.z.a.Pq().bmJ.aMj, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (Jl() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aIe != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aIe.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.GQ());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(bWj().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVJ() {
        if (this.gQP != null) {
            this.gQP.d(this.gQt.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVK() {
        w GH = bWj().haB.GH();
        LogManager.getCommonLogger().doClickQuickImHiLog((GH == null || GH.mLiveInfo == null) ? "" : GH.mLiveInfo.feed_id, Md());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Hz(String str) {
        if (this.gQP != null) {
            this.gQP.hg(str);
        }
    }

    private void bVL() {
        if ("home_rec_play".equals(bWj().fromType) || "frs_play".equals(bWj().fromType) || "frs_live_play".equals(bWj().fromType) || "person_play".equals(bWj().fromType) || "search".equals(bWj().fromType) || "person_attention".equals(bWj().fromType)) {
            com.baidu.live.c.AY().aX(true);
        } else {
            com.baidu.live.c.AY().aX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mF(boolean z) {
        View Gf;
        if (this.gQL == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSH = false;
            fVar.context = bWj().pageContext.getPageActivity();
            fVar.aSQ = z;
            fVar.fromType = bWj().fromType;
            fVar.aSR = bUC() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ac.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQL = (ac) runTask.getData();
            }
        }
        if (this.gQL != null && (Gf = this.gQL.Gf()) != null && this.gQt.haC.indexOfChild(Gf) < 0) {
            this.gQt.haC.addView(Gf, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVM() {
        View GT;
        if (this.gQW == null) {
            aj ajVar = new aj();
            ajVar.aSH = false;
            ajVar.pageContext = bWj().pageContext;
            ajVar.fromType = bWj().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, af.class, ajVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQW = (af) runTask.getData();
            }
        }
        if (this.gQW != null && (GT = this.gQW.GT()) != null && bWj().haC.indexOfChild(GT) < 0) {
            if (GT.getParent() instanceof ViewGroup) {
                ((ViewGroup) GT.getParent()).removeView(GT);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds100);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bWj().haC.addView(GT, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVN() {
        View GG;
        if (this.gQM == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSH = false;
            aVar.context = bWj().pageContext.getPageActivity();
            aVar.fromType = bWj().fromType;
            aVar.aSI = bWj().haG;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, aa.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQM = (aa) runTask.getData();
            }
        }
        if (this.gQM != null && (GG = this.gQM.GG()) != null && this.gRo != null && this.gRo.indexOfChild(GG) < 0) {
            if (GG.getParent() instanceof ViewGroup) {
                ((ViewGroup) GG.getParent()).removeView(GG);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            layoutParams.addRule(3, a.g.ala_head_line_entry_id);
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            this.gRo.addView(GG, this.gRo.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVO() {
        CustomResponsedMessage runTask;
        if (this.gQK == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bWj().pageContext)) != null) {
            this.gQK = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gQK != null) {
            this.gQK.setOtherParams(this.otherParams);
            this.gQK.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.im.b.a.InterfaceC0186a
                public void LF() {
                    b.this.bVV();
                }
            });
            this.gQK.a(bWj().haB.GH(), false);
            View Cr = this.gQK.Cr();
            if (Cr != null && this.gRp.indexOfChild(Cr) < 0) {
                Resources resources = bWj().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(bWj().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.e.sdk_ds98));
                layoutParams.addRule(2, a.g.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.e.sdk_ds20);
                this.gRp.addView(Cr, layoutParams);
            }
        }
    }

    private void bVP() {
        if (this.gQH == null) {
            this.gQH = new com.baidu.tieba.ala.liveroom.h.a(bWj().pageContext);
        }
        if (this.gRu != null) {
            this.gQH.HD(this.gRu.user_id);
        }
        this.gQH.av(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void mG(boolean z) {
        if (bWj() != null && !z) {
            if (this.gRd == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.j.a.class, bWj().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gRd = (com.baidu.live.j.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gRd.b(this.gRo, bWc());
            if (bWj().haB != null) {
                this.gRd.a(bWj().haB.GH());
            }
            this.gRd.setCanVisible(true);
            this.gRd.bR(true);
            this.gRd.a(bWj().haB.bOQ());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bUJ() {
        if (bWj() != null) {
            if (this.gPR == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.y.a.class, bWj().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gPR = (com.baidu.live.y.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gPR.setIsHost(false);
            this.gPR.a(bVk(), bWj().haB.GH().aJa);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVQ() {
        if (bWj() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.gRe == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.q.a.class, bWj().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gRe = (com.baidu.live.q.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gRe.setIsHost(false);
            this.gRe.b(bVk(), bWj().haB.GH());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVR() {
        if (this.gQA != null && bWj() != null && bWj().haB != null) {
            this.gQA.c(this.gRo, bWj().haB.GH());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVS() {
        if (bWj() != null) {
            if (this.gRf == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.i.a.class, bWj().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.gRf = (com.baidu.live.i.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = this.gQt.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            this.gRf.a(this.gRo, bWj().haB.GH(), layoutParams, this.otherParams);
        }
    }

    protected void bVT() {
        if (this.gRg == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.q.b.class, bWj().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gRg = (com.baidu.live.q.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bWj().haB.GH() != null && bWj().haB.GH().aIe != null && bWj().haB.GH().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(bWj().pageContext.getPageActivity(), a.e.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(bWj().pageContext.getPageActivity(), a.e.sdk_ds16);
            this.gRg.b(this.gRo, layoutParams, bWj().haB.GH());
        }
    }

    private void bVU() {
        if (this.gQU == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bWj().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gQU = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (bWj().haB.GH() != null && bWj().haB.GH().aIe != null && bWj().haB.GH().mLiveInfo != null) {
            this.gQU.setHost(false);
            this.gQU.setOtherParams(Md());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.g.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.g.ala_liveroom_hostheader);
            layoutParams.topMargin = bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            this.gQU.a(this.gRo, layoutParams, bWj().haB.GH());
            this.gQU.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.guardclub.l
                public void Kl() {
                    b.this.bWk();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:212:0x0707, code lost:
        Hv(r36);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        long j;
        long j2;
        long j3;
        boolean z;
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
        if (this.gPR != null) {
            this.gPR.O(jSONObject2);
        }
        if (aVar.getMsgType() == 12 || aVar.getMsgType() == 13) {
            if (jSONObject2 != null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z2 = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.bmm != null) {
                        this.bmm.cf(z2);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        vk(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bWj().haB.GH().aIA.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bWj().haB.GH().aIA.isAdmin = 0;
                            bWj().haB.cdK();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bWj().haB.GH().aIA.isAdmin = 0;
                        bWj().haB.cdK();
                    }
                } else if ("task".equals(optString2)) {
                    dI(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.gQN != null && !bWj().haF) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = bWj().pageContext.getString(a.i.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = bWj().pageContext.getString(a.i.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = bWj().pageContext.getString(a.i.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bQG()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.gQN.a(bWj().haA.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.bmm != null) {
                                b.this.bmm.ce(optInt4 == 2);
                            }
                        }
                    });
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.u.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bWj().haB.GH() != null && bWj().haB.GH().aIA != null && bWj().haB.GH().aIA.userId == optLong2) {
                        bWj().haB.GH().aIA.isBlock = 1;
                        bUY();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bWj().haB.GH() != null && bWj().haB.GH().aIA != null && bWj().haB.GH().aIA.userId == optLong3) {
                        bWj().haB.GH().aIA.isBlock = 0;
                        bUY();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (bWj().haB.GH() != null && bWj().haB.GH().aIA != null && bWj().haB.GH().aIA.userId == optLong4) {
                        bWj().haB.GH().aIA.isUegBlock = 1;
                        bUY();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (bWj().haB.GH() != null && bWj().haB.GH().aIA != null && bWj().haB.GH().aIA.userId == optLong5) {
                        bWj().haB.GH().aIA.isUegBlock = 0;
                        bUY();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (bWj() != null && bWj().haB != null && bWj().haB.GH() != null && bWj().haB.GH().aIA != null) {
                        if (bWj().haB.GH().aIA.userId == jSONObject2.optLong("user_id")) {
                            bWj().haB.cdK();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, bWj().haB.GH().aIA));
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
                    com.baidu.live.data.a LO = aVar.LO();
                    if (LO != null && ab.ha(str3)) {
                        ab.d(str3, 1L, "", "", LO.userId, LO.portrait, LO.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        ay ayVar = new ay();
                        ayVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, ayVar));
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
                } else if (TextUtils.equals(optString2, "mix_room_close") && this.gRm != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put("source", "im_mix_room_close");
                        jSONObject3.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                        this.gRm.A("mix_room_close", jSONObject3);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } else if (aVar.getMsgType() == 125) {
            if (this.gQE != null) {
                this.gQE.G(aVar);
            }
        } else if (aVar.getMsgType() == 24 && jSONObject2 != null) {
            String optString3 = jSONObject2.optString("content_type");
            com.baidu.live.data.a LO2 = aVar.LO();
            String optString4 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
            String optString5 = jSONObject2.optString("gift_count");
            String optString6 = jSONObject2.optString("gift_name");
            String optString7 = jSONObject2.optString("gift_url");
            String optString8 = jSONObject2.optString("attach");
            String optString9 = jSONObject2.optString("is_pk_gift", "0");
            long optLong7 = jSONObject2.optLong("charm_total");
            String optString10 = jSONObject2.optString("attach_new");
            String optString11 = jSONObject2.optString("gift_mul");
            boolean z3 = jSONObject2.optInt("is_dynamic_gift") == 1;
            boolean z4 = jSONObject2.optInt("from_gongyanfang_page") == 1;
            String str4 = null;
            if (bWj().haB == null || bWj().haB.GH() == null || bWj().haB.GH().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
                z = false;
            } else {
                long j4 = bWj().haB.GH().mLiveInfo.live_id;
                long j5 = bWj().haB.GH().mLiveInfo.group_id;
                long j6 = bWj().haB.GH().aIe.userId;
                str4 = bWj().haB.GH().mLiveInfo.appId;
                j = j6;
                j2 = j4;
                j3 = j5;
                z = bWj().haB.GH().mLiveInfo.isPubShow;
            }
            if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                if (jSONObject2.optInt("flag_show") == 1) {
                    ab.b(optString11, LO2.userId, LO2.portrait, LO2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString10, "", "", aVar.getMsgId());
                    try {
                        JSONArray jSONArray = new JSONArray(optString11);
                        if (jSONArray != null && jSONArray.length() > 0) {
                            int i = 0;
                            while (true) {
                                if (i >= jSONArray.length()) {
                                    break;
                                }
                                if (com.baidu.live.z.f.PF().hS(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                aVar.setHost(z && z4);
                ab.a(optString4, JavaTypesHelper.toInt(optString5, 1), optString6, optString7, LO2.userId, LO2.portrait, LO2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString8, "", "", !z4, aVar.getMsgId(), z3, jSONObject2, optString9);
                Hv(optString4);
            }
            if (!optString3.equals("tying_gift")) {
                com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                cVar.hag = optLong7;
                cVar.liveId = j2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.gRm = dVar;
    }

    protected void Hv(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void bVV() {
        if (bVW()) {
            BdUtilHelper.hideSoftKeyPad(bWj().pageContext.getPageActivity(), bWj().haA.getLiveContainerView());
            bVi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bVW() {
        if (bVh() == null || bVh().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        CustomResponsedMessage runTask;
        bWj().haC.setOnTouchListener(this.gSe);
        bWd();
        bWe();
        bWf();
        bVP();
        bVU();
        bVT();
        bVy();
        if (this.gQC != null && bWj().haB.GH() != null && bWj().haB.GH().mLiveInfo != null) {
            this.gQC.cu(bWj().haB.GH().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.gQI != null) {
            this.gQI.h(bWj().haB.GH());
        }
        if (this.gQG != null) {
            this.gQG.f(bWj().haB.GH());
        }
        if (this.gQO != null) {
            this.gQO.c(bWj().haB.GH(), Md());
        }
        if (this.gQP != null) {
            this.gQP.b(bWj().haB.GH(), Md());
        }
        if (this.gQQ != null) {
            this.gQQ.c(bWj().haB.GH(), Md());
        }
        if (this.gRn != null) {
            this.gRn.f(bWj().haB.GH());
        }
        if (bWj().haC != null) {
            bWj().haC.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean P = b.this.P(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.bVW() && b.this.gQB != null) {
                        b.this.gQB.nz(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.gQB != null) {
                        b.this.gQB.nz(true);
                    }
                    return P;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean NA() {
                    if (b.this.gRG == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.gRG) {
                        if (bVar.NA()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            bWj().haC.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.O(motionEvent);
                }
            });
        }
        if (this.gRb == null && (runTask = MessageManager.getInstance().runTask(2913165, ae.class, bWj().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gRb = (ae) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bVX() {
        w GH;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (bWj() != null && bWj().haB != null && (GH = bWj().haB.GH()) != null && GH.mLiveInfo != null && !GH.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) bWj().haA) != null) {
            if (this.gRh == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.u.a.class, bWj().pageContext)) != null && runTask.getData() != null) {
                this.gRh = (com.baidu.live.u.a) runTask.getData();
            }
            if (this.gRh != null) {
                this.gRh.o(GH);
                this.gRh.a(this.gSf);
                this.gRh.a(viewGroup, this.gRo);
                a(this.gRh.OK());
                a(this.gRh.OL());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.gRF == null) {
            this.gRF = new ArrayList();
        }
        if (!this.gRF.contains(dVar)) {
            this.gRF.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.gRF != null && this.gRF.contains(dVar)) {
            this.gRF.remove(dVar);
        }
    }

    protected void bVY() {
        if (this.gRF != null) {
            this.gRF.clear();
            this.gRF = null;
        }
    }

    protected boolean O(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gRF == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.gRF.iterator();
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
        if (this.gRG == null) {
            this.gRG = new ArrayList();
        }
        if (!this.gRG.contains(bVar)) {
            this.gRG.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.gRG != null && this.gRG.contains(bVar)) {
            this.gRG.remove(bVar);
        }
    }

    protected void bVZ() {
        if (this.gRG != null) {
            this.gRG.clear();
            this.gRG = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.gRG == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.gRG.iterator();
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
    public void bWa() {
        if (this.gRc == null && this.gRj != null && this.gRj.aON && bWj() != null && bWj().haB != null && bWj().haB.GH() != null) {
            this.gRc = new com.baidu.tieba.ala.liveroom.h.e(bWj().pageContext, this.gRj);
            this.gRc.z(bWj().haB.GH());
            if (this.gRj.aOQ == 1) {
                if (this.gQJ != null) {
                    this.gRx = true;
                }
            } else if (this.gRj.aOQ == 2) {
                a(bWj().haB.GH(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bWb() {
        CustomResponsedMessage runTask;
        if (bWj() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bWj().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.v.a)) {
            this.gRk = (com.baidu.live.v.a) runTask.getData();
            this.gRk.s(bVk());
            if (bWj().haB != null) {
                this.gRy = this.gRk.p(bWj().haB.GH());
            }
            this.gRk.setCanVisible(!this.gRs);
        }
    }

    private ViewGroup.LayoutParams bWc() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.topMargin = bWj().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        layoutParams.addRule(3, a.g.ala_rank_level_entry);
        layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        bWj().haA.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(bWj().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(bWj().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? bWj().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96) + (z ? bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds128) : 0) + bWj().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
    }

    private void bWd() {
        if (this.gQB != null) {
            this.gQB.aC(bWj().haC);
        }
    }

    private void bWe() {
        if (this.gQC != null) {
            this.gQC.aF(bWj().haC);
        }
    }

    private void bWf() {
        if (this.gQF == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ac.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.gQF = (com.baidu.live.ac.a) runTask.getData();
            }
            bWg();
        }
    }

    private void dI(JSONObject jSONObject) {
        if (this.gQF != null) {
            if (this.gQy != null) {
                this.gQF.cy(this.gQy.bZW() ? false : true);
            } else {
                this.gQF.cy(true);
            }
            this.gQF.R(jSONObject);
        }
    }

    private void bWg() {
        if (this.gQF != null && bWj().haB.GH() != null && bWj().haB.GH().aIN != null) {
            if (this.gQy != null) {
                this.gQF.cy(this.gQy.bZW() ? false : true);
            } else {
                this.gQF.cy(true);
            }
            this.gQF.j(bWj().haB.GH());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void k(w wVar) {
        if (wVar != null) {
            if (this.gQC != null && wVar.mLiveInfo != null) {
                this.gQC.cu(wVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.gQT != null) {
                this.gQT.i(wVar);
            }
            bWg();
            if (this.gQH != null && wVar.aIe != null) {
                this.gQH.HD(String.valueOf(wVar.aIe.userId));
            }
            if (this.gQv != null) {
                this.gQv.a(wVar);
            }
            if (this.gQM != null && wVar.mLiveInfo != null) {
                this.gQM.a(wVar.mLiveInfo, wVar.aIe);
            }
            if (this.gQK != null) {
                this.gQK.a(wVar);
            }
            if (this.gRk != null) {
                this.gRy = this.gRk.p(wVar);
            }
            if (this.gRd != null) {
                this.gRd.a(wVar);
            }
            if (this.gRe != null) {
                this.gRe.a(wVar);
            }
            if (this.gPR != null) {
                this.gPR.a(wVar);
            }
            if (this.gRf != null) {
                this.gRf.a(wVar);
            }
            if (this.gRg != null) {
                this.gRg.a(wVar);
            }
            if (this.gRn != null) {
                this.gRn.b(wVar);
            }
            vk(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void vk(int i) {
        if (!bWj().haF) {
            if (this.gRq < 0 && i == 0) {
                this.gRq = i;
            } else if (this.gRq != i) {
                if (i == 1) {
                    if (!this.gQN.vY(2)) {
                        String string = bWj().pageContext.getString(a.i.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(bWj().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.gQN.a(bWj().haA.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = bWj().pageContext.getString(a.i.ala_audience_live_mute_close_tip);
                    this.gQN.vZ(2);
                    this.gQN.vZ(3);
                    if (bQG()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.gQN.a(bWj().haA.getLiveContainerView(), string2, 3);
                    }
                }
                this.gRq = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void ci(boolean z) {
        super.ci(z);
        if (z) {
            bWh();
        }
        if (this.gQT != null) {
            this.gQT.Kn();
        }
        if (this.gQG != null) {
            this.gQG.Kn();
        }
        if (this.gQE != null) {
            this.gQE.cfV();
        }
        if (this.gQw != null) {
            this.gQw.CT();
        }
        if (this.gQy != null) {
            this.gQy.onDestroy();
        }
        if (this.gQF != null) {
            this.gQF.onDestroy();
            this.gQF = null;
        }
        if (this.gQL != null) {
            View Gf = this.gQL.Gf();
            if (Gf != null && Gf.getParent() != null) {
                ((ViewGroup) Gf.getParent()).removeView(Gf);
            }
            this.gQL.onDestroy();
            this.gQL = null;
        }
        if (this.gQK != null) {
            this.gQK.a((a.InterfaceC0186a) null);
            this.gQK.Ct();
        }
        if (this.gQN != null) {
            this.gQN.CT();
        }
        this.gRq = -1;
        if (this.gQH != null) {
            this.gQH.CT();
            this.gQH.onDestroy();
        }
        if (this.gQz != null) {
            this.gQz.cfT();
        }
        if (this.gQA != null) {
            this.gQA.bUz();
            this.gQA.GS();
        }
        if (this.gQB != null) {
            this.gQB.GS();
        }
        if (this.gQI != null) {
            this.gQI.GS();
        }
        if (this.gQO != null) {
            this.gQO.Kn();
        }
        if (this.gQP != null) {
            this.gQP.GS();
        }
        if (this.gQQ != null) {
            this.gQQ.onDestroy();
        }
        if (this.gQS != null) {
            this.gQS.onDestory();
        }
        if (this.gQV != null) {
            this.gQV.Kj();
        }
        if (this.gQU != null) {
            this.gQU.Kj();
        }
        if (this.gRg != null) {
            this.gRg.Kj();
        }
        if (this.gRc != null) {
            this.gRc.onDestroy();
        }
        if (this.gQX != null) {
            this.gQX.GS();
        }
        if (this.gFm != null) {
            this.gFm.GS();
        }
        if (this.gQY != null) {
            this.gQY.GS();
        }
        if (this.gQZ != null) {
            this.gQZ.GS();
        }
        if (this.gRb != null) {
            this.gRb.GS();
        }
        if (this.gQx != null) {
            this.gQx.onDestory();
        }
        if (this.gRk != null) {
            this.gRk.GS();
        }
        if (this.gRd != null) {
            this.gRd.Kj();
        }
        if (this.gRe != null) {
            this.gRe.Kj();
        }
        if (this.gPR != null) {
            this.gPR.Kj();
        }
        if (this.gRa != null) {
            this.gRa.GS();
        }
        if (this.gQW != null) {
            this.gQW.onDestroy();
        }
        if (this.gRh != null) {
            this.gRh.CT();
            b(this.gRh.OK());
            b(this.gRh.OL());
        }
        if (this.gRi != null) {
            this.gRi.Kj();
        }
        if (this.gRf != null) {
            this.gRf.Kj();
        }
        if (this.gRn != null) {
            this.gRn.Kn();
        }
        ShowUtil.windowCount = 0;
        bVY();
        bVZ();
    }

    private void bWh() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = bWj().haC.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = bWj().haC.getChildAt(i);
            if (childAt != this.gRo && childAt != this.gRp) {
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
        if (this.gRo != null) {
            this.gRo.removeAllViews();
        }
        if (this.gRp != null) {
            this.gRp.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void n(w wVar) {
        View Cr;
        View Gf;
        if (this.gQL != null && (Gf = this.gQL.Gf()) != null && Gf.getParent() != null) {
            ((ViewGroup) Gf.getParent()).removeView(Gf);
        }
        if (this.gQK != null && (Cr = this.gQK.Cr()) != null && Cr.getParent() != null) {
            ((ViewGroup) Cr.getParent()).removeView(Cr);
        }
        if (this.gQy != null) {
            this.gQy.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean Nw() {
        if (this.gQD == null || !this.gQD.cab()) {
            if (this.gQy == null || !this.gQy.ay(bWj().haA.getLiveContainerView())) {
                if (this.gQB != null) {
                    this.gQB.bRn();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.gQR != null && this.gQR.bZK()) {
                    this.gQR.bZT();
                    return false;
                } else if (this.gQQ == null || !this.gQQ.cag()) {
                    bVL();
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
    public void cg(boolean z) {
        super.cg(z);
        if (this.gQT != null) {
            this.gQT.release();
        }
        if (this.gQG != null) {
            this.gQG.onDestroy();
        }
        if (this.gQF != null) {
            this.gQF.onDestroy();
            this.gQF = null;
        }
        if (this.gQE != null) {
            this.gQE.cfV();
        }
        if (this.gQL != null) {
            this.gQL.onDestroy();
            this.gQL = null;
        }
        if (this.gQM != null) {
            this.gQM.onDestroy();
            this.gQM = null;
        }
        if (this.gQN != null) {
            this.gQN.onDestroy();
        }
        if (this.gQw != null) {
            this.gQw.onDestroy();
        }
        if (this.gQW != null) {
            this.gQW.onDestroy();
            this.gQW = null;
        }
        if (this.gQK != null) {
            this.gQK.a((a.InterfaceC0186a) null);
            this.gQK.release();
            this.gQK = null;
        }
        if (this.gQO != null) {
            this.gQO.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.gQO.release();
        }
        if (this.gQP != null) {
            this.gQP.a(null);
            this.gQP.release();
        }
        if (this.gQQ != null) {
            this.gQQ.a((b.a) null);
            this.gQQ.onDestroy();
        }
        if (this.gQU != null) {
            this.gQU.onDestroy();
        }
        if (this.gQV != null) {
            this.gQV.onDestroy();
        }
        if (this.gQS != null) {
            this.gQS.onDestory();
        }
        if (this.gRg != null) {
            this.gRg.onDestroy();
        }
        if (this.gRc != null) {
            this.gRc.onDestroy();
        }
        if (this.gQX != null) {
            this.gQX.release();
        }
        if (this.gFm != null) {
            this.gFm.release();
        }
        if (this.gRa != null) {
            this.gRa.release();
        }
        if (this.gQY != null) {
            this.gQY.release();
        }
        if (this.gQZ != null) {
            this.gQZ.release();
        }
        if (this.gRb != null) {
            this.gRb.release();
        }
        if (this.gQx != null) {
            this.gQx.onDestory();
        }
        if (this.gRk != null) {
            this.gRk.release();
        }
        if (this.gRd != null) {
            this.gRd.onDestroy();
        }
        if (this.gRe != null) {
            this.gRe.onDestroy();
        }
        if (this.gPR != null) {
            this.gPR.onDestroy();
        }
        if (this.gQB != null) {
            this.gQB.GS();
        }
        if (this.gRf != null) {
            this.gRf.onDestroy();
        }
        if (this.gRn != null) {
            this.gRn.onDestroy();
        }
        if (this.gRh != null) {
            this.gRh.onDestroy();
            b(this.gRh.OK());
            b(this.gRh.OL());
        }
        bVY();
        bVZ();
        MessageManager.getInstance().unRegisterListener(this.gRL);
        MessageManager.getInstance().unRegisterListener(this.gRM);
        MessageManager.getInstance().unRegisterListener(this.gRN);
        MessageManager.getInstance().unRegisterListener(this.gRS);
        MessageManager.getInstance().unRegisterListener(this.gRT);
        MessageManager.getInstance().unRegisterListener(this.gRV);
        MessageManager.getInstance().unRegisterListener(this.gRO);
        MessageManager.getInstance().unRegisterListener(this.gRP);
        MessageManager.getInstance().unRegisterListener(this.gRR);
        MessageManager.getInstance().unRegisterListener(this.gRQ);
        MessageManager.getInstance().unRegisterListener(this.gpA);
        MessageManager.getInstance().unRegisterListener(this.gRW);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gzn);
        MessageManager.getInstance().unRegisterListener(this.gzk);
        MessageManager.getInstance().unRegisterListener(this.bpy);
        MessageManager.getInstance().unRegisterListener(this.gRX);
        MessageManager.getInstance().unRegisterListener(this.gRZ);
        MessageManager.getInstance().unRegisterListener(this.gSa);
        MessageManager.getInstance().unRegisterListener(this.gSb);
        MessageManager.getInstance().unRegisterListener(this.gRY);
        MessageManager.getInstance().unRegisterListener(this.gSc);
        MessageManager.getInstance().unRegisterListener(this.gFn);
        MessageManager.getInstance().unRegisterListener(this.gSd);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.gQO != null) {
            this.gQO.nf(false);
        }
        if (this.gQQ != null) {
            this.gQQ.nf(false);
        }
        bVi();
        if (this.gQT != null) {
            this.gQT.onPause();
        }
        if (this.gQX != null) {
            this.gQX.pause();
        }
        if (this.gFm != null) {
            this.gFm.pause();
        }
        if (this.gRa != null) {
            this.gRa.pause();
        }
        if (this.gQY != null) {
            this.gQY.pause();
        }
        if (this.gQW != null) {
            this.gQW.onPause();
        }
        if (this.gRf != null) {
            this.gRf.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.gRB = false;
        if (this.gRt && this.gRu != null) {
            a(this.gRu);
            this.gRt = false;
        }
        if (this.gQO != null) {
            this.gQO.nf(true);
        }
        if (this.gQQ != null) {
            this.gQQ.nf(true);
        }
        if (this.gQT != null) {
            this.gQT.onResume();
        }
        if (this.gQX != null) {
            this.gQX.resume();
        }
        if (this.gFm != null) {
            this.gFm.resume();
        }
        if (this.gRa != null) {
            this.gRa.resume();
        }
        if (this.gQW != null) {
            this.gQW.onResume();
        }
        if (this.gQY != null) {
            this.gQY.resume();
        }
        if (this.gRf != null) {
            this.gRf.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ats() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.gRh != null && this.gRh.isOpen()) {
            this.gRh.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            ats();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    M(-1, -1, -1);
                    return;
                }
                return;
            }
            ats();
        } else if (i == 25034) {
            bVI();
        } else if (i == 25043) {
            if (i2 == -1) {
                bWk();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.n.a.F(bWj().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.n.a.F(bWj().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.gRs = z;
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean bWi() {
        return (bWj().haB.GH() == null || bWj().haB.GH().mLiveInfo == null || bWj().haB.GH().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.gQy != null) {
                this.gQy.D(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.gQQ != null) {
            this.gQQ.bgm();
        }
        if (this.gQx != null) {
            this.gQx.bgm();
        }
        if (this.gRh != null) {
            this.gRh.D(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.gQt = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a bWj() {
        return this.gQt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWk() {
        String Kg = g.Kf().Kg();
        if (!TextUtils.isEmpty(Kg)) {
            try {
                M(-1, Integer.parseInt(Kg), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                M(-1, -1, -1);
            }
        }
    }

    public boolean eO(int i) {
        if (1 == i) {
            if (bVh() != null) {
                bVh().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.gRs) {
                return false;
            }
            return this.gQy == null || !this.gQy.bZW();
        } else if (3 == i) {
            if (bWj().haC != null) {
                bWj().haC.setEnabled(false);
                if (this.bmm != null) {
                    this.bmm.e(!bWj().haD, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void vi(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void eP(int i) {
        if (3 == i) {
            bWj().haC.setEnabled(true);
            if (this.bmm != null) {
                this.bmm.e(!bWj().haD, true);
            }
            if (this.gQF != null) {
                this.gQF.cy(true);
            }
        } else if (2 == i && this.gQE != null) {
            this.gQE.nI(true);
        }
    }

    public String Md() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.gQK != null) {
            this.gQK.setOtherParams(str);
        }
        if (this.gQT != null) {
            this.gQT.hG(str);
        }
    }

    private boolean bQG() {
        return bWj().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.a> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.fVh = alaLastLiveroomInfo;
    }

    public void bW(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(bWj().pageContext.getPageActivity(), this.gRz);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }
}
