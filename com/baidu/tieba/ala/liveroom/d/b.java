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
import com.baidu.live.d.v;
import com.baidu.live.data.AlaLiveMarkData;
import com.baidu.live.data.RedPacketCharmInfo;
import com.baidu.live.data.ai;
import com.baidu.live.data.ar;
import com.baidu.live.data.bb;
import com.baidu.live.data.bg;
import com.baidu.live.data.bo;
import com.baidu.live.data.bp;
import com.baidu.live.data.bz;
import com.baidu.live.data.f;
import com.baidu.live.data.w;
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
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.utils.p;
import com.baidu.live.view.input.d;
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
/* loaded from: classes4.dex */
public abstract class b extends com.baidu.live.liveroom.f.a implements com.baidu.live.liveroom.a.a, com.baidu.live.x.a {
    public static boolean hgS;
    protected com.baidu.live.ao.a gTR;
    protected AlaLastLiveroomInfo giQ;
    protected com.baidu.live.ad.a heW;
    private com.baidu.tieba.ala.liveroom.data.a hfD;
    protected com.baidu.tieba.ala.liveroom.operation.a hfE;
    protected com.baidu.live.j.b hfF;
    protected com.baidu.live.j.a hfG;
    protected com.baidu.tieba.ala.liveroom.share.c hfH;
    protected com.baidu.tieba.ala.liveroom.r.b hfI;
    protected com.baidu.tieba.ala.liveroom.guide.c hfJ;
    protected com.baidu.tieba.ala.liveroom.watermark.a hfK;
    protected com.baidu.tieba.ala.liveroom.b.b hfL;
    protected com.baidu.tieba.ala.liveroom.praise.a hfM;
    protected com.baidu.tieba.ala.liveroom.sticker.a hfN;
    protected com.baidu.tieba.ala.liveroom.guide.d hfO;
    protected com.baidu.tieba.ala.liveroom.w.a hfP;
    protected com.baidu.live.ah.a hfQ;
    protected com.baidu.live.ah.d hfR;
    private com.baidu.tieba.ala.liveroom.h.a hfS;
    private m hfT;
    k hfU;
    com.baidu.live.im.b.a hfV;
    protected ad hfW;
    protected ab hfX;
    protected com.baidu.tieba.ala.liveroom.tippop.a hfY;
    private com.baidu.tieba.ala.liveroom.guideim.b hfZ;
    protected com.baidu.live.guess.a hgA;
    protected com.baidu.live.s.a hgB;
    protected com.baidu.live.an.c hgC;
    protected com.baidu.live.c.a hgD;
    protected RelativeLayout hgE;
    protected RelativeLayout hgF;
    protected boolean hgH;
    protected ar hgK;
    protected GuardClubInfoHttpResponseMessage hgL;
    boolean hgM;
    boolean hgN;
    boolean hgO;
    public boolean hgQ;
    public boolean hgR;
    protected com.baidu.tieba.ala.liveroom.t.b hgT;
    protected e hgU;
    protected List<com.baidu.live.liveroom.g.d> hgV;
    protected List<com.baidu.live.liveroom.g.b> hgW;
    CustomMessageTask hgX;
    CustomMessageTask hgY;
    protected com.baidu.live.view.input.d hga;
    com.baidu.tieba.ala.liveroom.n.b hgb;
    protected com.baidu.tieba.ala.liveroom.guide.a hgc;
    protected com.baidu.live.x.b hgd;
    private com.baidu.live.guardclub.k hge;
    protected com.baidu.live.m.b hgf;
    protected h hgg;
    protected j hgh;
    protected ag hgi;
    protected com.baidu.tieba.ala.liveroom.turntable.e hgj;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b hgk;
    protected com.baidu.tieba.ala.liveroom.q.c hgl;
    private af hgm;
    protected com.baidu.tieba.ala.liveroom.h.e hgn;
    protected com.baidu.live.l.a hgo;
    protected com.baidu.live.v.a hgp;
    protected com.baidu.live.t.a hgq;
    protected com.baidu.live.a.a hgr;
    protected com.baidu.live.k.a hgs;
    protected com.baidu.live.t.b hgt;
    protected com.baidu.live.z.a hgu;
    protected com.baidu.tieba.ala.liveroom.exclusive.b hgv;
    protected bp hgw;
    protected com.baidu.live.aa.a hgx;
    protected com.baidu.tieba.ala.liveroom.f.a hgy;
    protected com.baidu.tieba.ala.player.d hgz;
    protected String otherParams;
    private int hgG = -1;
    protected int mOrientation = 0;
    protected boolean hgI = false;
    protected boolean hgJ = false;
    private int hgP = a.C0205a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> hgZ = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: cbY */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> hha = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener hhb = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ai aiVar;
            if ((customResponsedMessage.getData() instanceof ai) && (aiVar = (ai) customResponsedMessage.getData()) != null) {
                b.this.a(aiVar.aLD, aiVar.aLz, aiVar.aLA, aiVar.aLB, aiVar.aLC);
            }
        }
    };
    private CustomMessageListener hhc = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.wy(7);
        }
    };
    private CustomMessageListener hhd = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cbs();
        }
    };
    private CustomMessageListener hhe = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.cbW().hpR.Iq().aJV.userId);
            com.baidu.live.view.a.Yo().a(valueOf, new f(b.this.cbW().hpR.Iq().aJV.portrait, valueOf, true, b.this.cbW().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hhf = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && b.this.hfH != null) {
                b.this.hfH.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener buq = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hfU != null) {
                b.this.hfU.g(z.Ii().Ik());
            }
        }
    };
    private CustomMessageListener hhg = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.hfD.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.Ig(str);
            }
        }
    };
    private CustomMessageListener gDr = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.cbW().pageContext.getPageActivity());
            } else if (b.this.hfH != null) {
                b.this.hfH.c(b.this.cbW().hpR.Iq(), false);
            }
        }
    };
    private CustomMessageListener hhh = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ar) {
                    b.this.hgJ = true;
                    b.this.hgK = (ar) data;
                    b.this.b(b.this.hgK);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                } else if (data instanceof String) {
                    b.this.If((String) data);
                }
            }
        }
    };
    private CustomMessageListener hhi = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.cbW().hpR.Iq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.cbW().hpR.Iq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.cbW().hpR.Iq().aJV.userId);
                    if (b.this.hfI == null) {
                        b.this.hfI = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    b.this.hfI.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.hfI.a(b.this.hhj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b hhj = new e.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void Qw() {
            if (b.this.cbW().hpR.Iq() != null && b.this.cbW().hpR.Iq().aKr != null) {
                b.this.cbW().hpR.Iq().aKr.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener hhk = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (b.this.hgf != null) {
                    b.this.hgf.A(bVar);
                }
                if (b.this.hgv != null) {
                    b.this.hgv.G(bVar);
                }
                if (b.this.hfG != null) {
                    b.this.hfG.l(bVar);
                }
                if (b.this.hgs != null) {
                    b.this.hgs.l(bVar);
                }
                b.this.t(bVar);
            }
        }
    };
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener hhl = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.hgM = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hgb != null) {
                b.this.hgb.ID();
            }
        }
    };
    HttpMessageListener gNG = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bja) != null && b.this.hge != null && b.this.cbW() != null && b.this.cbW().hpR != null) {
                int[] iArr = new int[2];
                b.this.hgE.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.hge.a(b.this.hgE, layoutParams, aVar, b.this.cbW().hpR.Iq());
                com.baidu.live.q.a.aG(aVar.liveId + "", "guard_club_join");
                com.baidu.live.p.a.b(b.this.cbW().hpR.Iq().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gND = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.cbW() != null && b.this.cbW().hpR != null && b.this.cbW().hpR.Iq() != null && guardClubInfoHttpResponseMessage.bja != null) {
                    if (guardClubInfoHttpResponseMessage.bja.anchorId == b.this.cbW().hpR.Iq().aJV.userId) {
                        b.this.hgL = guardClubInfoHttpResponseMessage;
                        if (b.this.hgL.bjf && com.baidu.live.guardclub.e.LY() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.LY().aS(b.this.cbW().hpR.Iq().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hhm = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bz) {
                b.this.a((bz) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hhn = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.H(b.this.cbW().hpR.Iq());
        }
    };
    private CustomMessageListener hho = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hgo != null) {
                b.this.hgo.Mq();
            }
        }
    };
    private CustomMessageListener hhp = new CustomMessageListener(2913261) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.hgp != null) {
                    b.this.hgp.iq(str);
                }
            }
        }
    };
    public CustomMessageListener hhq = new CustomMessageListener(2913272) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                b.this.nk(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener hhr = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.hgi != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) b.this.hgi).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hhs = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.cbW().hpR.Iq(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gTS = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ao.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.gTR == null) {
                b.this.gTR = new com.baidu.live.ao.a(b.this.cbW().pageContext.getPageActivity());
            }
            b.this.gTR.a((com.baidu.live.ao.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener hht = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.cbW().pageContext.getPageActivity() != null) {
                com.baidu.live.p.a.s(b.this.cbW().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener hhu = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.cbH();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.z.b hhv = new com.baidu.live.z.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        @Override // com.baidu.live.z.b
        public boolean QX() {
            if (b.this.cbW().hpS != null) {
                if (!b.this.cbW().hpS.cln()) {
                    b.this.hgu.close();
                    return false;
                } else if (b.this.cbW().hpS.getScrollX() != 0) {
                    b.this.hgu.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void If(String str);

    protected abstract void a(ar arVar);

    protected abstract void b(ar arVar);

    protected abstract void caH();

    protected abstract View caR();

    public abstract boolean caS();

    protected abstract boolean caT();

    protected abstract ViewGroup caU();

    public abstract boolean caj();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bp bpVar) {
        this.hgw = bpVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hgE = (RelativeLayout) cbW().hpS.findViewById(a.f.ala_live_header_view);
        this.hgF = (RelativeLayout) cbW().hpS.findViewById(a.f.ala_live_footer_view);
        Jg();
        registerListener();
    }

    public void caZ() {
    }

    private void Jg() {
        if (this.hfH == null) {
            this.hfH = new com.baidu.tieba.ala.liveroom.share.c(cbW().pageContext);
        }
        this.hfP = new com.baidu.tieba.ala.liveroom.w.a(cbW().pageContext, this);
        this.hfL = new com.baidu.tieba.ala.liveroom.b.b(cbW().pageContext, false);
        this.hfM = new com.baidu.tieba.ala.liveroom.praise.a(cbW().pageContext);
        this.hfN = new com.baidu.tieba.ala.liveroom.sticker.a(cbW().pageContext);
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
                this.hfO = new com.baidu.tieba.ala.liveroom.guide.d(cbW().pageContext);
            }
        }
        this.hfY = new com.baidu.tieba.ala.liveroom.tippop.a(cbW().pageContext, this);
        cbc();
        cbf();
        cbg();
        cbl();
        cbm();
        cbn();
        cbb();
        cba();
        cbo();
    }

    private void cba() {
        CustomResponsedMessage runTask;
        if (this.hfR == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ah.d.class, cbW().pageContext)) != null && runTask.getData() != null) {
            this.hfR = (com.baidu.live.ah.d) runTask.getData();
        }
    }

    private void cbb() {
        CustomResponsedMessage runTask;
        if (this.hgf == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.m.b.class, cbW().pageContext)) != null && runTask.getData() != null) {
            this.hgf = (com.baidu.live.m.b) runTask.getData();
            this.hgf.c(cbW().pageContext);
            this.hgf.Pc().setTargetView(this.hgF);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.hgy == null) {
            this.hgy = new com.baidu.tieba.ala.liveroom.f.a(cbW().pageContext);
            this.hgy.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.hgy.a(cbW().hpR.Iq(), alaLastLiveroomInfo);
        this.hgy.at(this.hgF);
    }

    private void cbc() {
        this.hfT = new m();
    }

    public void nh(boolean z) {
        this.hgH = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbd() {
        CustomResponsedMessage runTask;
        if (this.hfG == null && (runTask = MessageManager.getInstance().runTask(2913273, com.baidu.live.j.a.class, cbW().pageContext)) != null) {
            this.hfG = (com.baidu.live.j.a) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbe() {
        w Iq = cbW().hpR.Iq();
        boolean z = com.baidu.live.ae.a.RB().brA.aOs;
        if (Iq.mLiveInfo != null && Iq.mLiveInfo.mAlaLiveSwitchData != null && Iq.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Iq.aKG ? z : false;
        if (z2) {
            if (this.hfF == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, cbW().pageContext);
                if (runTask != null) {
                    this.hfF = (com.baidu.live.j.b) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.hfF != null) {
                this.hfF.eX(1);
                View view = this.hfF.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(cbW().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(cbW().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    ck(view);
                    this.hgE.addView(view, layoutParams);
                    if (z2) {
                        this.hfF.a(Iq);
                    }
                }
            }
        }
    }

    private void cbf() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.d.class, cbW().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hga = (com.baidu.live.view.input.d) runTask.getData();
            this.hga.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.23
                @Override // com.baidu.live.view.input.d.a
                public void YJ() {
                    b.this.wy(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public void YK() {
                    b.this.fi(11);
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean Nh() {
                    return b.this.Le();
                }

                @Override // com.baidu.live.view.input.d.a
                public boolean NR() {
                    return b.this.cbj();
                }

                @Override // com.baidu.live.view.input.d.a
                public int Nm() {
                    return b.this.cbk();
                }
            });
        }
    }

    private void cbg() {
        this.hgb = new com.baidu.tieba.ala.liveroom.n.b(this.hfD.pageContext);
        this.hgb.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
            @Override // com.baidu.tieba.ala.liveroom.n.b.a
            public boolean cbZ() {
                return b.this.caT();
            }

            @Override // com.baidu.tieba.ala.liveroom.n.b.a
            public void onClose() {
                if (b.this.brc != null) {
                    b.this.brc.cu(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbh() {
        if (this.hgA == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.hgA = (com.baidu.live.guess.a) runTask.getData();
                this.hgA.q(getActivity());
            } else {
                return;
            }
        }
        if (this.hgA != null) {
            this.hgA.eY(0);
            this.hgA.e(cbW().hpR.Iq());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ni(boolean z) {
        if (this.hfZ != null) {
            this.hfZ.nL(z);
        }
        if (this.hgb != null) {
            this.hgb.nL(z);
        }
        hgS = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbi() {
        return hgS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbj() {
        w Iq;
        if (cbW() == null || cbW().hpR == null || (Iq = cbW().hpR.Iq()) == null || Iq.aKr == null) {
            return false;
        }
        String str = Iq.aKr.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbk() {
        w Iq;
        if (cbW() != null && cbW().hpR != null && (Iq = cbW().hpR.Iq()) != null && !ListUtils.isEmpty(Iq.aKB)) {
            for (AlaLiveMarkData alaLiveMarkData : Iq.aKB) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cbl() {
        if (this.hge == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, cbW().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hge = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.hge.setOtherParams(Oj());
    }

    private void cbm() {
        if (this.hgj == null) {
            this.hgj = new com.baidu.tieba.ala.liveroom.turntable.e(cbW().pageContext.getPageActivity());
        }
    }

    private void cbn() {
        if (this.hgl == null) {
            this.hgl = new com.baidu.tieba.ala.liveroom.q.c(cbW().pageContext.getPageActivity());
        }
    }

    private void cbo() {
        if (this.gTR == null) {
            this.gTR = new com.baidu.live.ao.a(cbW().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.hgX == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.hgX = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.hgZ);
            this.hgX.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hgX);
        }
        if (this.hgY == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.hgY = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.hha);
            this.hgY.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hgY);
        }
        MessageManager.getInstance().registerListener(this.hhh);
        MessageManager.getInstance().registerListener(this.hhi);
        MessageManager.getInstance().registerListener(this.hhk);
        MessageManager.getInstance().registerListener(this.hhe);
        MessageManager.getInstance().registerListener(this.hhf);
        MessageManager.getInstance().registerListener(this.gDr);
        MessageManager.getInstance().registerListener(this.hhg);
        MessageManager.getInstance().registerListener(this.gDE);
        MessageManager.getInstance().registerListener(this.hhl);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gNG);
        MessageManager.getInstance().registerListener(this.gND);
        MessageManager.getInstance().registerListener(this.buq);
        MessageManager.getInstance().registerListener(this.hhm);
        MessageManager.getInstance().registerListener(this.hhn);
        MessageManager.getInstance().registerListener(this.hho);
        MessageManager.getInstance().registerListener(this.hhr);
        MessageManager.getInstance().registerListener(this.hhs);
        MessageManager.getInstance().registerListener(this.hhb);
        MessageManager.getInstance().registerListener(this.hhc);
        MessageManager.getInstance().registerListener(this.hhd);
        MessageManager.getInstance().registerListener(this.gTS);
        MessageManager.getInstance().registerListener(this.hht);
        MessageManager.getInstance().registerListener(this.hhp);
        MessageManager.getInstance().registerListener(this.hhq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Le() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(cbW().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cbW().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(cbW().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.RB().brA.aNR;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = cbW().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = cbW().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.cbW().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(cbW().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbp() {
        if (this.hfU != null && this.hga != null) {
            this.hfU.Ne().a(this.hga.QD(), z.Ii().Ik(), cbW().hpR.Iq().mLiveInfo);
            ni(true);
            if (this.hgm == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, af.class, cbW().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgm = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgm.hz("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbq() {
        if (this.hfU != null && this.hga != null) {
            this.hfU.Nf().cp(true);
            this.hfU.Nf().setClicked(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.leftMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.rightMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            if (this.hgi != null) {
                layoutParams.addRule(3, this.hgi.IC().getId());
            }
            this.hfU.a(this.hgF, cbW().hpR.Iq(), this.hga.QD(), layoutParams);
            ni(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbr() {
        if (this.hfU != null) {
            this.hfU.Ne().hide();
            ni(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(int i, int i2, int i3) {
        if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aJV != null && cbW().hpR.Iq().mLiveInfo != null) {
            a(cbW().hpR.Iq(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.d.k.class) != null && Le()) {
            if (wVar == null) {
                wVar = cbW().hpR.Iq();
            }
            String valueOf = String.valueOf(wVar.aJV.userId);
            String str2 = wVar.aJV.userName;
            String valueOf2 = String.valueOf(wVar.mLiveInfo.live_id);
            String valueOf3 = String.valueOf(wVar.mLiveInfo.room_id);
            String valueOf4 = String.valueOf(wVar.mLiveInfo.feed_id);
            int i6 = wVar.aKr.isBlock;
            String Iz = ac.Iz();
            String str3 = wVar.mLiveInfo.appId;
            boolean z2 = wVar.aKr.isNewGiftPriceStrategy;
            boolean z3 = false;
            if (wVar.mLiveInfo.live_type == 1 && wVar.mLiveInfo.screen_direction == 1 && com.baidu.live.ae.a.RB().brA.aMS) {
                z3 = true;
            }
            int i7 = -1;
            if (wVar.aKr == null) {
                z = false;
                str = "";
            } else {
                String valueOf5 = String.valueOf(wVar.aKr.userId);
                boolean z4 = wVar.aKr.isNewUser;
                i7 = wVar.aKr.levelId;
                z = z4;
                str = valueOf5;
            }
            boolean z5 = true;
            if (this.hgL != null && this.hgL.bja != null && this.hgL.bja.anchorId == wVar.aJV.userId) {
                z5 = this.hgL.bjf;
            }
            com.baidu.live.d.k kVar = new com.baidu.live.d.k(cbW().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Iz, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bn(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.gr(str);
            kVar.bl(z);
            if (com.baidu.tieba.ala.liveroom.v.b.ckA().brJ != null) {
                kVar.bm(com.baidu.tieba.ala.liveroom.v.b.ckA().brJ.aLH != 1);
            }
            bg Mb = g.LZ().Mb();
            if (Mb == null || Mb.aQj <= 0) {
                i5 = 1000;
            } else {
                i5 = Mb.aQj;
            }
            kVar.dV(i5);
            boolean z6 = false;
            if (wVar != null && wVar.aKr != null) {
                String str4 = wVar.aKr.throneUid;
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z6 = (TextUtils.isEmpty(str4) || TextUtils.isEmpty(currentAccount) || !str4.equals(currentAccount)) ? false : true;
            }
            kVar.bo(z6);
            boolean z7 = true;
            bo boVar = com.baidu.live.ae.a.RB().bxq;
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                z7 = false;
            } else if (boVar != null && boVar.aQP != null && (!boVar.aQP.aTn || !boVar.aQP.aTo)) {
                z7 = false;
            } else if (TbadkCoreApplication.sAlaLiveSwitchData != null && TbadkCoreApplication.sAlaLiveSwitchData.isNobleInfoSwitchUnabled()) {
                z7 = false;
            }
            kVar.bp(z7);
            if (wVar != null && wVar.aKu != null) {
                kVar.gq(wVar.aKu.toJsonString());
            }
            if (cbW() != null && cbW().hpR != null) {
                kVar.gt(cbW().hpR.cjO());
            }
            if (!this.hgQ) {
                this.hgR = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbs() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        fi(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bz bzVar) {
        if (bzVar != null && Le()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(cbW().pageContext.getPageActivity(), bzVar.aRN, bzVar.liveId, bzVar.aRO)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.ae.a.RB().brA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(cbW().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.ae.a.RB().brA.aOt, 1, false)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, NobleDetailInfo nobleDetailInfo) {
        if (Le() && nobleDetailInfo != null && !TextUtils.isEmpty(nobleDetailInfo.url)) {
            HashMap hashMap = new HashMap();
            hashMap.put("client_type", "2");
            hashMap.put("subapp_type", TbConfig.getSubappType());
            if (wVar != null) {
                if (wVar.mLiveInfo != null) {
                    hashMap.put("live_id", Long.valueOf(wVar.mLiveInfo.live_id));
                }
                if (wVar.aJV != null) {
                    hashMap.put("anchor_id", Long.valueOf(wVar.aJV.userId));
                }
            }
            hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
            hashMap.put("role_id", nobleDetailInfo.roleId);
            hashMap.put("scene_from", p.Iz());
            if (!TextUtils.isEmpty(nobleDetailInfo.cardId)) {
                hashMap.put("noble_card_id", nobleDetailInfo.cardId);
            }
            if (nobleDetailInfo.expDuration > 0) {
                hashMap.put("day", Long.valueOf(nobleDetailInfo.expDuration));
            }
            if (nobleDetailInfo.expireTimestamp > 0) {
                hashMap.put("time", Long.valueOf(nobleDetailInfo.expireTimestamp));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(cbW().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbt() {
        if (this.hga != null) {
            this.hga.d(this.hfD.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbu() {
        w Iq = cbW().hpR.Iq();
        LogManager.getCommonLogger().doClickQuickImHiLog((Iq == null || Iq.mLiveInfo == null) ? "" : Iq.mLiveInfo.feed_id, Oj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ih(String str) {
        if (this.hga != null) {
            this.hga.hC(str);
        }
    }

    private void cbv() {
        if ("home_rec_play".equals(cbW().fromType) || "frs_play".equals(cbW().fromType) || "frs_live_play".equals(cbW().fromType) || "person_play".equals(cbW().fromType) || "search".equals(cbW().fromType) || "person_attention".equals(cbW().fromType)) {
            com.baidu.live.c.BL().bc(true);
        } else {
            com.baidu.live.c.BL().bc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nj(boolean z) {
        View HM;
        if (this.hfW == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVr = false;
            fVar.context = cbW().pageContext.getPageActivity();
            fVar.aVA = z;
            fVar.fromType = cbW().fromType;
            fVar.aVB = caj() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfW = (ad) runTask.getData();
            }
        }
        if (this.hfW != null && (HM = this.hfW.HM()) != null && this.hfD.hpS.indexOfChild(HM) < 0) {
            this.hfD.hpS.addView(HM, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbw() {
        View IC;
        if (this.hgi == null) {
            ak akVar = new ak();
            akVar.aVr = false;
            akVar.pageContext = cbW().pageContext;
            akVar.fromType = cbW().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hgi = (ag) runTask.getData();
            }
        }
        if (this.hgi != null && (IC = this.hgi.IC()) != null && cbW().hpS.indexOfChild(IC) < 0) {
            if (IC.getParent() instanceof ViewGroup) {
                ((ViewGroup) IC.getParent()).removeView(IC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hfU != null && this.hfU.Nf().OY()) {
                layoutParams.bottomMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hfU.Nf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            cbW().hpS.addView(IC, layoutParams);
        }
    }

    protected void nk(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.hgi != null) {
            View IC = this.hgi.IC();
            if (IC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) IC.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if (this.hfU != null && z) {
                layoutParams.bottomMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hfU.Nf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            IC.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbx() {
        View Ip;
        if (this.hfX == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVr = false;
            aVar.context = cbW().pageContext.getPageActivity();
            aVar.fromType = cbW().fromType;
            aVar.aVs = cbW().hpX;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfX = (ab) runTask.getData();
            }
        }
        if (this.hfX != null && (Ip = this.hfX.Ip()) != null && this.hgE != null && this.hgE.indexOfChild(Ip) < 0) {
            if (Ip.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ip.getParent()).removeView(Ip);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.hgE.addView(Ip, this.hgE.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cby() {
        CustomResponsedMessage runTask;
        if (this.hfV == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, cbW().pageContext)) != null) {
            this.hfV = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hfV != null) {
            this.hfV.setOtherParams(this.otherParams);
            this.hfV.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.im.b.a.InterfaceC0193a
                public void NJ() {
                    b.this.cbH();
                }
            });
            this.hfV.a(cbW().hpR.Iq(), false);
            View DL = this.hfV.DL();
            if (DL != null && this.hgF.indexOfChild(DL) < 0) {
                Resources resources = cbW().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbW().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hgF.addView(DL, layoutParams);
            }
        }
    }

    private void cbz() {
        if (this.hfS == null) {
            this.hfS = new com.baidu.tieba.ala.liveroom.h.a(cbW().pageContext);
        }
        if (this.hgK != null) {
            this.hfS.Il(this.hgK.user_id);
        }
        this.hfS.at(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nl(boolean z) {
        if (cbW() != null && !z) {
            if (this.hgo == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, cbW().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgo = (com.baidu.live.l.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgo.c(this.hgE, cbP());
            if (cbW().hpR != null) {
                this.hgo.a(cbW().hpR.Iq());
            }
            this.hgo.setCanVisible(true);
            this.hgo.cd(true);
            this.hgo.a(cbW().hpR.bUt());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbA() {
        if (cbW() != null) {
            if (this.hgp == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, cbW().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgp = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (cbW().hpR != null) {
                this.hgp.b(cbW().hpR.Iq(), this.otherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void caq() {
        if (cbW() != null) {
            if (this.heW == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbW().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.heW = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.heW.setIsHost(false);
            this.heW.a(caU(), cbW().hpR.Iq().aKU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbB() {
        if (cbW() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.hgq == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, cbW().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgq = (com.baidu.live.t.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgq.setIsHost(false);
            this.hgq.a(caU(), cbW().hpR.Iq());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbC() {
        if (this.hfL != null && cbW() != null && cbW().hpR != null) {
            this.hfL.d(this.hgE, cbW().hpR.Iq());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbD() {
        if (cbW() != null) {
            if (this.hgs == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, cbW().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgs = (com.baidu.live.k.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.hfD.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.hgs.a(this.hgE, cbW().hpR.Iq(), layoutParams, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbE() {
        if (cbW() != null) {
            if (this.hgd == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913264, com.baidu.live.x.b.class, cbW().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgd = (com.baidu.live.x.b) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgd.a(cbW().hpR.Iq(), this);
        }
    }

    protected void cbF() {
        if (this.hgt == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.b.class, cbW().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgt = (com.baidu.live.t.b) runTask.getData();
            } else {
                return;
            }
        }
        if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aJV != null && cbW().hpR.Iq().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(cbW().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(cbW().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.hgt.b(this.hgE, layoutParams, cbW().hpR.Iq());
        }
    }

    private void cbG() {
        if (this.hgg == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, cbW().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgg = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aJV != null && cbW().hpR.Iq().mLiveInfo != null) {
            this.hgg.setHost(false);
            this.hgg.setOtherParams(Oj());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.hgg.a(this.hgE, layoutParams, cbW().hpR.Iq());
            this.hgg.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.guardclub.l
                public void Me() {
                    b.this.cbX();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x03df, code lost:
        cbW().hpR.cjy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x06b5, code lost:
        Ic(r3.giftId);
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        long j;
        long j2;
        long j3;
        JSONObject jSONObject4;
        try {
            if (bVar.getObjContent() instanceof JSONObject) {
                jSONObject4 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(bVar.getContent());
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
            if (this.heW != null) {
            }
            if (bVar.getMsgType() != 12) {
            }
            if (jSONObject2 == null) {
            }
        }
        if (this.heW != null) {
            this.heW.N(jSONObject2);
        }
        if (bVar.getMsgType() != 12 || bVar.getMsgType() == 13) {
            if (jSONObject2 == null) {
                String optString2 = jSONObject2.optString("content_type");
                if ("live_on_private".equals(optString2)) {
                    boolean z = jSONObject2.optInt("on_private", 0) == 1;
                    if (this.brc != null) {
                        this.brc.cw(z);
                    }
                    int optInt = jSONObject2.optInt("on_audio_private", -1);
                    if (optInt >= 0) {
                        wA(optInt);
                    }
                } else if ("live_admin".equals(optString2)) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt2 = jSONObject2.optInt("opt_type");
                    if (optInt2 == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbW().hpR.Iq().aKr.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbW().hpR.Iq().aKr.isAdmin = 0;
                            cbW().hpR.cjy();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        cbW().hpR.Iq().aKr.isAdmin = 0;
                        cbW().hpR.cjy();
                    }
                } else if ("task".equals(optString2)) {
                    dK(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.hfY != null && !cbW().hpW) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = cbW().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = cbW().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = cbW().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bWj()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.hfY.a(cbW().hpQ.getLiveContainerView(), str, 1);
                            }
                        }
                    }
                } else if ("close_live".equals(optString2)) {
                    final int optInt4 = jSONObject2.optInt("close_type");
                    this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.b.29
                        @Override // java.lang.Runnable
                        public void run() {
                            if (b.this.brc != null) {
                                b.this.brc.cv(optInt4 == 2);
                            }
                        }
                    });
                } else if ("first_recharge_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913117, Long.valueOf(jSONObject2.optLong("user_id"))));
                } else if ("privilege_award_success".equals(optString2)) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913127, new com.baidu.tieba.ala.liveroom.t.a(jSONObject2.optLong("user_id"), jSONObject2.optString(BigdayActivityConfig.JUMP_URL))));
                } else if ("live_talk_ban".equals(optString2)) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aKr != null && cbW().hpR.Iq().aKr.userId == optLong2) {
                        cbW().hpR.Iq().aKr.isBlock = 1;
                        caH();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aKr != null && cbW().hpR.Iq().aKr.userId == optLong3) {
                        cbW().hpR.Iq().aKr.isBlock = 0;
                        caH();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aKr != null && cbW().hpR.Iq().aKr.userId == optLong4) {
                        cbW().hpR.Iq().aKr.isUegBlock = 1;
                        caH();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (cbW().hpR.Iq() != null && cbW().hpR.Iq().aKr != null && cbW().hpR.Iq().aKr.userId == optLong5) {
                        cbW().hpR.Iq().aKr.isUegBlock = 0;
                        caH();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (cbW() != null && cbW().hpR != null && cbW().hpR.Iq() != null && cbW().hpR.Iq().aKr != null) {
                        long j4 = cbW().hpR.Iq().aKr.userId;
                        if (j4 == jSONObject2.optLong("user_id")) {
                            cbW().hpR.cjy();
                        }
                        try {
                            JSONArray optJSONArray = jSONObject2.optJSONArray("user_id_list");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                int i = 0;
                                while (true) {
                                    if (i >= optJSONArray.length()) {
                                        break;
                                    }
                                    long j5 = optJSONArray.getLong(i);
                                    if (j5 > 0 && j4 == j5) {
                                        break;
                                    }
                                    i++;
                                }
                            }
                        } catch (JSONException e3) {
                            e3.printStackTrace();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, cbW().hpR.Iq().aKr));
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
                    com.baidu.live.data.a NU = bVar.NU();
                    if (NU != null && ac.hv(str3)) {
                        ac.d(str3, 1L, "", "", NU.userId, NU.portrait, NU.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                } else if ("challenge_mvp".equals(optString2)) {
                    if (jSONObject2 != null) {
                        bb bbVar = new bb();
                        bbVar.parseJson(jSONObject2);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bbVar));
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
                } else if (TextUtils.equals(optString2, "mix_room_close") && this.hgz != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("source", "im_mix_room_close");
                        jSONObject5.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                        this.hgz.z("mix_room_close", jSONObject5);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        } else if (bVar.getMsgType() == 125) {
            if (this.hfP != null) {
                this.hfP.K(bVar);
            }
        } else if (bVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject2);
            if (cbW().hpR != null && cbW().hpR.Iq() != null && cbW().hpR.Iq().aLe && TextUtils.equals(cVar.bnR, "luckybag")) {
                cVar.bdf = "";
            }
            com.baidu.live.data.a NU2 = bVar.NU();
            boolean z2 = false;
            String str4 = null;
            if (cbW().hpR == null || cbW().hpR.Iq() == null || cbW().hpR.Iq().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j6 = cbW().hpR.Iq().mLiveInfo.live_id;
                long j7 = cbW().hpR.Iq().mLiveInfo.group_id;
                long j8 = cbW().hpR.Iq().aJV.userId;
                str4 = cbW().hpR.Iq().mLiveInfo.appId;
                z2 = cbW().hpR.Iq().mLiveInfo.isPubShow;
                j = j6;
                j2 = j8;
                j3 = j7;
            }
            if (!cVar.bpb || cVar.isDynamic) {
                if (!TextUtils.isEmpty(cVar.boW) && !TextUtils.isEmpty(cVar.boY)) {
                    if (jSONObject2.optInt("flag_show") == 1) {
                        ac.b(cVar, NU2, String.valueOf(j), String.valueOf(j3), false, String.valueOf(j2), str4, "", "", bVar.getMsgId());
                        try {
                            JSONArray jSONArray = new JSONArray(cVar.boY);
                            if (jSONArray != null && jSONArray.length() > 0) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= jSONArray.length()) {
                                        break;
                                    }
                                    if (com.baidu.live.ae.f.RR().ix(jSONArray.getJSONObject(i2).optString(LogConfig.LOG_GIFT_ID))) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                        } catch (JSONException e5) {
                            e5.printStackTrace();
                        }
                    }
                } else {
                    bVar.setHost(z2 && cVar.boZ);
                    ac.b(cVar, NU2, String.valueOf(j), String.valueOf(j3), false, String.valueOf(j2), str4, (cVar.boZ || cVar.bpb || cVar.bpa) ? false : true, true, "", "", bVar.getMsgId());
                    Ic(cVar.giftId);
                }
                if (!"tying_gift".equals(cVar.contentType)) {
                    com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                    cVar2.boX = cVar.boX;
                    cVar2.liveId = j;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                }
            }
        }
    }

    public void a(com.baidu.tieba.ala.player.d dVar) {
        this.hgz = dVar;
    }

    protected void Ic(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbH() {
        if (cbI()) {
            BdUtilHelper.hideSoftKeyPad(cbW().pageContext.getPageActivity(), cbW().hpQ.getLiveContainerView());
            caS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbI() {
        if (caR() == null || caR().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        cbW().hpS.setOnTouchListener(this.hhu);
        cbQ();
        cbR();
        cbS();
        cbz();
        cbG();
        cbF();
        if (this.hfN != null && cbW().hpR.Iq() != null && cbW().hpR.Iq().mLiveInfo != null) {
            this.hfN.cG(cbW().hpR.Iq().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.hfT != null) {
            this.hfT.g(cbW().hpR.Iq());
        }
        if (this.hfR != null) {
            this.hfR.e(cbW().hpR.Iq());
        }
        if (this.hfZ != null) {
            this.hfZ.c(cbW().hpR.Iq(), Oj());
        }
        if (this.hga != null) {
            this.hga.b(cbW().hpR.Iq(), Oj());
        }
        if (this.hgb != null) {
            this.hgb.c(cbW().hpR.Iq(), Oj());
        }
        if (this.hgB != null) {
            this.hgB.e(cbW().hpR.Iq());
        }
        if (cbW().hpS != null) {
            cbW().hpS.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.cbI() && b.this.hfM != null) {
                        b.this.hfM.oe(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.hfM != null) {
                        b.this.hfM.oe(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean PK() {
                    if (b.this.hgW == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.hgW) {
                        if (bVar.PK()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            cbW().hpS.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.hgm == null && (runTask = MessageManager.getInstance().runTask(2913165, af.class, cbW().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hgm = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbJ() {
        if (this.hgB == null && cbW() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, cbW().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hgB = (com.baidu.live.s.a) runTask.getData();
                this.hgB.m(cbW().hpS);
                this.hgB.b(cbW().hpR.Iq());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbK() {
        w Iq;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (cbW() != null && cbW().hpR != null && (Iq = cbW().hpR.Iq()) != null && Iq.mLiveInfo != null && !Iq.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) cbW().hpQ) != null) {
            if (this.hgu == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.z.a.class, cbW().pageContext)) != null && runTask.getData() != null) {
                this.hgu = (com.baidu.live.z.a) runTask.getData();
            }
            if (this.hgu != null) {
                this.hgu.n(Iq);
                this.hgu.a(this.hhv);
                this.hgu.a(viewGroup, this.hgE);
                a(this.hgu.QV());
                a(this.hgu.QW());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.hgV == null) {
            this.hgV = new ArrayList();
        }
        if (!this.hgV.contains(dVar)) {
            this.hgV.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.hgV != null && this.hgV.contains(dVar)) {
            this.hgV.remove(dVar);
        }
    }

    protected void cbL() {
        if (this.hgV != null) {
            this.hgV.clear();
            this.hgV = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgV == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.hgV.iterator();
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
        if (this.hgW == null) {
            this.hgW = new ArrayList();
        }
        if (!this.hgW.contains(bVar)) {
            this.hgW.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hgW != null && this.hgW.contains(bVar)) {
            this.hgW.remove(bVar);
        }
    }

    protected void cbM() {
        if (this.hgW != null) {
            this.hgW.clear();
            this.hgW = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgW == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hgW.iterator();
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
    public void cbN() {
        if (this.hgn == null && this.hgw != null && this.hgw.aQZ && cbW() != null && cbW().hpR != null && cbW().hpR.Iq() != null) {
            this.hgn = new com.baidu.tieba.ala.liveroom.h.e(cbW().pageContext, this.hgw);
            this.hgn.J(cbW().hpR.Iq());
            if (this.hgw.aRc == 1) {
                if (this.hfU != null) {
                    this.hgN = true;
                }
            } else if (this.hgw.aRc == 2) {
                a(cbW().hpR.Iq(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbO() {
        CustomResponsedMessage runTask;
        if (cbW() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, cbW().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hgx = (com.baidu.live.aa.a) runTask.getData();
            this.hgx.p(caU());
            if (cbW().hpR != null) {
                this.hgO = this.hgx.o(cbW().hpR.Iq());
            }
            this.hgx.setCanVisible(!this.hgI);
        }
    }

    private ViewGroup.LayoutParams cbP() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = cbW().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        cbW().hpQ.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(cbW().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(cbW().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? cbW().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + cbW().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void cbQ() {
        if (this.hfM != null) {
            this.hfM.aA(cbW().hpS);
        }
    }

    private void cbR() {
        if (this.hfN != null) {
            this.hfN.aD(cbW().hpS);
        }
    }

    private void cbS() {
        if (this.hfQ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ah.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hfQ = (com.baidu.live.ah.a) runTask.getData();
            }
            cbT();
        }
    }

    private void dK(JSONObject jSONObject) {
        if (this.hfQ != null) {
            if (this.hfJ != null) {
                this.hfQ.cV(this.hfJ.cfJ() ? false : true);
            } else {
                this.hfQ.cV(true);
            }
            this.hfQ.R(jSONObject);
        }
    }

    private void cbT() {
        if (this.hfQ != null && cbW().hpR.Iq() != null && cbW().hpR.Iq().aKF != null) {
            if (this.hfJ != null) {
                this.hfQ.cV(this.hfJ.cfJ() ? false : true);
            } else {
                this.hfQ.cV(true);
            }
            this.hfQ.i(cbW().hpR.Iq());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            if (this.hfN != null && wVar.mLiveInfo != null) {
                this.hfN.cG(wVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.hgf != null) {
                this.hgf.h(wVar);
            }
            cbT();
            if (this.hfS != null && wVar.aJV != null) {
                this.hfS.Il(String.valueOf(wVar.aJV.userId));
            }
            if (this.hfF != null) {
                this.hfF.a(wVar);
            }
            if (this.hfX != null && wVar.mLiveInfo != null) {
                this.hfX.a(wVar.mLiveInfo, wVar.aJV);
            }
            if (this.hfV != null) {
                this.hfV.a(wVar);
            }
            if (this.hgx != null) {
                this.hgO = this.hgx.o(wVar);
            }
            if (this.hgo != null) {
                this.hgo.a(wVar);
            }
            if (this.hgq != null) {
                this.hgq.a(wVar);
            }
            if (this.hgp != null) {
                this.hgp.a(wVar);
            }
            if (this.heW != null) {
                this.heW.a(wVar);
            }
            if (this.hgs != null) {
                this.hgs.a(wVar);
            }
            if (this.hgr != null) {
                this.hgr.a(wVar);
            }
            if (this.hgt != null) {
                this.hgt.a(wVar);
            }
            if (this.hgA != null) {
                this.hgA.b(wVar);
            }
            wA(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void wA(int i) {
        if (!cbW().hpW) {
            if (this.hgG < 0 && i == 0) {
                this.hgG = i;
            } else if (this.hgG != i) {
                if (i == 1) {
                    if (!this.hfY.xo(2)) {
                        String string = cbW().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(cbW().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.hfY.a(cbW().hpQ.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = cbW().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.hfY.xp(2);
                    this.hfY.xp(3);
                    if (bWj()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.hfY.a(cbW().hpQ.getLiveContainerView(), string2, 3);
                    }
                }
                this.hgG = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (z) {
            cbU();
        }
        if (this.hgf != null) {
            this.hgf.Mg();
        }
        if (this.hfR != null) {
            this.hfR.Mg();
        }
        if (this.hfP != null) {
            this.hfP.clL();
        }
        if (this.hfH != null) {
            this.hfH.En();
        }
        if (this.hfJ != null) {
            this.hfJ.onDestroy();
        }
        if (this.hfQ != null) {
            this.hfQ.onDestroy();
            this.hfQ = null;
        }
        if (this.hfW != null) {
            View HM = this.hfW.HM();
            if (HM != null && HM.getParent() != null) {
                ((ViewGroup) HM.getParent()).removeView(HM);
            }
            this.hfW.onDestroy();
            this.hfW = null;
        }
        if (this.hfV != null) {
            this.hfV.a((a.InterfaceC0193a) null);
            this.hfV.DN();
        }
        if (this.hfY != null) {
            this.hfY.En();
        }
        this.hgG = -1;
        if (this.hfS != null) {
            this.hfS.En();
            this.hfS.onDestroy();
        }
        if (this.hfK != null) {
            this.hfK.clJ();
        }
        if (this.hfL != null) {
            this.hfL.cac();
            this.hfL.IB();
        }
        if (this.hfM != null) {
            this.hfM.IB();
        }
        if (this.hfT != null) {
            this.hfT.IB();
        }
        if (this.hfZ != null) {
            this.hfZ.Mg();
        }
        if (this.hga != null) {
            this.hga.IB();
        }
        if (this.hgb != null) {
            this.hgb.onDestroy();
        }
        if (this.hge != null) {
            this.hge.onDestory();
        }
        if (this.hgh != null) {
            this.hgh.Do();
        }
        if (this.hgg != null) {
            this.hgg.Do();
        }
        if (this.hgt != null) {
            this.hgt.Do();
        }
        if (this.hgn != null) {
            this.hgn.onDestroy();
        }
        if (this.hgj != null) {
            this.hgj.IB();
        }
        if (this.gTR != null) {
            this.gTR.IB();
        }
        if (this.hgk != null) {
            this.hgk.IB();
        }
        if (this.hgm != null) {
            this.hgm.IB();
        }
        if (this.hfI != null) {
            this.hfI.onDestory();
        }
        if (this.hgx != null) {
            this.hgx.IB();
        }
        if (this.hgo != null) {
            this.hgo.Do();
        }
        if (this.hgq != null) {
            this.hgq.Do();
        }
        if (this.hgp != null) {
            this.hgp.Do();
        }
        if (this.heW != null) {
            this.heW.Do();
        }
        if (this.hgl != null) {
            this.hgl.IB();
        }
        if (this.hgi != null) {
            this.hgi.onDestroy();
        }
        if (this.hgu != null) {
            this.hgu.En();
            b(this.hgu.QV());
            b(this.hgu.QW());
        }
        if (this.hgv != null) {
            this.hgv.Do();
        }
        if (this.hgs != null) {
            this.hgs.Do();
        }
        if (this.hfU != null) {
            this.hfU.Nf().Do();
        }
        if (this.hgA != null) {
            this.hgA.Mg();
        }
        if (this.hgB != null) {
            this.hgB.Mg();
            this.hgB = null;
        }
        ShowUtil.windowCount = 0;
        cbL();
        cbM();
    }

    private void cbU() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = cbW().hpS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = cbW().hpS.getChildAt(i);
            if (childAt != this.hgE && childAt != this.hgF) {
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
        if (this.hgE != null) {
            this.hgE.removeAllViews();
        }
        if (this.hgF != null) {
            this.hgF.removeAllViews();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public View a(Context context, w wVar, boolean z) {
        return null;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void m(w wVar) {
        View DL;
        View HM;
        if (this.hfW != null && (HM = this.hfW.HM()) != null && HM.getParent() != null) {
            ((ViewGroup) HM.getParent()).removeView(HM);
        }
        if (this.hfV != null && (DL = this.hfV.DL()) != null && DL.getParent() != null) {
            ((ViewGroup) DL.getParent()).removeView(DL);
        }
        if (this.hfJ != null) {
            this.hfJ.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean PG() {
        if (this.hfO == null || !this.hfO.cfO()) {
            if (this.hfJ == null || !this.hfJ.aw(cbW().hpQ.getLiveContainerView())) {
                if (this.hfM != null) {
                    this.hfM.bWP();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.hgc != null && this.hgc.cfx()) {
                    this.hgc.cfG();
                    return false;
                } else if (this.hgb == null || !this.hgb.SL()) {
                    if (this.hgC == null || !this.hgC.SL()) {
                        if (this.hgd == null || !this.hgd.QP()) {
                            cbv();
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

    @Override // com.baidu.live.x.a
    public void QO() {
        PF();
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void cx(boolean z) {
        super.cx(z);
        if (this.hgf != null) {
            this.hgf.release();
        }
        if (this.hfR != null) {
            this.hfR.onDestroy();
        }
        if (this.hfQ != null) {
            this.hfQ.onDestroy();
            this.hfQ = null;
        }
        if (this.hfP != null) {
            this.hfP.clL();
        }
        if (this.hfW != null) {
            this.hfW.onDestroy();
            this.hfW = null;
        }
        if (this.hfX != null) {
            this.hfX.onDestroy();
            this.hfX = null;
        }
        if (this.hfY != null) {
            this.hfY.onDestroy();
        }
        if (this.hfH != null) {
            this.hfH.onDestroy();
        }
        if (this.hgi != null) {
            this.hgi.onDestroy();
            this.hgi = null;
        }
        if (this.hfV != null) {
            this.hfV.a((a.InterfaceC0193a) null);
            this.hfV.release();
            this.hfV = null;
        }
        if (this.hfZ != null) {
            this.hfZ.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.hfZ.release();
        }
        if (this.hga != null) {
            this.hga.a(null);
            this.hga.release();
        }
        if (this.hgb != null) {
            this.hgb.a((b.a) null);
            this.hgb.onDestroy();
        }
        if (this.hgg != null) {
            this.hgg.onDestroy();
        }
        if (this.hgh != null) {
            this.hgh.onDestroy();
        }
        if (this.hge != null) {
            this.hge.onDestory();
        }
        if (this.hgt != null) {
            this.hgt.onDestroy();
        }
        if (this.hgn != null) {
            this.hgn.onDestroy();
        }
        if (this.hgj != null) {
            this.hgj.release();
        }
        if (this.gTR != null) {
            this.gTR.release();
        }
        if (this.hgl != null) {
            this.hgl.release();
        }
        if (this.hgk != null) {
            this.hgk.release();
        }
        if (this.hgm != null) {
            this.hgm.release();
        }
        if (this.hfI != null) {
            this.hfI.onDestory();
        }
        if (this.hgx != null) {
            this.hgx.release();
        }
        if (this.hgo != null) {
            this.hgo.onDestroy();
        }
        if (this.hgq != null) {
            this.hgq.onDestroy();
        }
        if (this.hgp != null) {
            this.hgp.onDestroy();
        }
        if (this.heW != null) {
            this.heW.onDestroy();
        }
        if (this.hfM != null) {
            this.hfM.IB();
        }
        if (this.hgs != null) {
            this.hgs.onDestroy();
        }
        if (this.hgA != null) {
            this.hgA.onDestroy();
        }
        if (this.hgd != null) {
            this.hgd.onDestroy();
        }
        if (this.hgu != null) {
            this.hgu.onDestroy();
            b(this.hgu.QV());
            b(this.hgu.QW());
        }
        cbL();
        cbM();
        MessageManager.getInstance().unRegisterListener(this.hhb);
        MessageManager.getInstance().unRegisterListener(this.hhc);
        MessageManager.getInstance().unRegisterListener(this.hhd);
        MessageManager.getInstance().unRegisterListener(this.hhh);
        MessageManager.getInstance().unRegisterListener(this.hhi);
        MessageManager.getInstance().unRegisterListener(this.hhk);
        MessageManager.getInstance().unRegisterListener(this.hhe);
        MessageManager.getInstance().unRegisterListener(this.hhf);
        MessageManager.getInstance().unRegisterListener(this.gDr);
        MessageManager.getInstance().unRegisterListener(this.hhg);
        MessageManager.getInstance().unRegisterListener(this.gDE);
        MessageManager.getInstance().unRegisterListener(this.hhl);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gNG);
        MessageManager.getInstance().unRegisterListener(this.gND);
        MessageManager.getInstance().unRegisterListener(this.buq);
        MessageManager.getInstance().unRegisterListener(this.hhm);
        MessageManager.getInstance().unRegisterListener(this.hhn);
        MessageManager.getInstance().unRegisterListener(this.hho);
        MessageManager.getInstance().unRegisterListener(this.hhr);
        MessageManager.getInstance().unRegisterListener(this.hhs);
        MessageManager.getInstance().unRegisterListener(this.gTS);
        MessageManager.getInstance().unRegisterListener(this.hht);
        MessageManager.getInstance().unRegisterListener(this.hhp);
        MessageManager.getInstance().unRegisterListener(this.hhq);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.hfZ != null) {
            this.hfZ.nK(false);
        }
        if (this.hgb != null) {
            this.hgb.nK(false);
        }
        caS();
        if (this.hgf != null) {
            this.hgf.onPause();
        }
        if (this.hgj != null) {
            this.hgj.pause();
        }
        if (this.gTR != null) {
            this.gTR.pause();
        }
        if (this.hgl != null) {
            this.hgl.pause();
        }
        if (this.hgi != null) {
            this.hgi.onPause();
        }
        if (this.hgs != null) {
            this.hgs.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hgR = false;
        if (this.hgJ && this.hgK != null) {
            a(this.hgK);
            this.hgJ = false;
        }
        if (this.hfZ != null) {
            this.hfZ.nK(true);
        }
        if (this.hgb != null) {
            this.hgb.nK(true);
        }
        if (this.hgf != null) {
            this.hgf.onResume();
        }
        if (this.hgj != null) {
            this.hgj.resume();
        }
        if (this.gTR != null) {
            this.gTR.resume();
        }
        if (this.hgl != null) {
            this.hgl.resume();
        }
        if (this.hgi != null) {
            this.hgi.onResume();
        }
        if (this.hgs != null) {
            this.hgs.onResume();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onStop() {
    }

    @Override // com.baidu.live.liveroom.f.a
    public void onStart() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ays() {
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.hgu != null && this.hgu.isOpen()) {
            this.hgu.onClose();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25014) {
            ays();
        } else if (i == 25015) {
            if (i2 == -1) {
                if (intent != null && intent.getBooleanExtra("need_show_gift_panel", false)) {
                    N(-1, -1, -1);
                    return;
                }
                return;
            }
            ays();
        } else if (i == 25034) {
            cbs();
        } else if (i == 25043) {
            if (i2 == -1) {
                cbX();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.p.a.G(cbW().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.p.a.G(cbW().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.hgI = z;
        if (this.hgB != null) {
            this.hgB.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cbV() {
        return (cbW().hpR.Iq() == null || cbW().hpR.Iq().mLiveInfo == null || cbW().hpR.Iq().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.hfJ != null) {
                this.hfJ.C(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.hgb != null) {
            this.hgb.blq();
        }
        if (this.hfI != null) {
            this.hfI.blq();
        }
        if (this.hgu != null) {
            this.hgu.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.hfD = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a cbW() {
        return this.hfD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbX() {
        String Ma = g.LZ().Ma();
        if (!TextUtils.isEmpty(Ma)) {
            try {
                N(-1, Integer.parseInt(Ma), 0);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                N(-1, -1, -1);
            }
        }
    }

    public boolean fh(int i) {
        if (1 == i) {
            if (caR() != null) {
                caR().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.hgI) {
                return false;
            }
            return this.hfJ == null || !this.hfJ.cfJ();
        } else if (3 == i) {
            if (cbW().hpS != null) {
                cbW().hpS.setEnabled(false);
                if (this.brc != null) {
                    this.brc.e(!cbW().hpU, false);
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public void wy(int i) {
        if (i == 7 || i == 11) {
        }
    }

    public void fi(int i) {
        if (3 == i) {
            cbW().hpS.setEnabled(true);
            if (this.brc != null) {
                this.brc.e(!cbW().hpU, true);
            }
            if (this.hfQ != null) {
                this.hfQ.cV(true);
            }
        } else if (2 == i && this.hfP != null) {
            this.hfP.on(true);
        }
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hfV != null) {
            this.hfV.setOtherParams(str);
        }
        if (this.hgf != null) {
            this.hgf.ik(str);
        }
    }

    private boolean bWj() {
        return cbW().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giQ = alaLastLiveroomInfo;
    }

    public void ck(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(cbW().pageContext.getPageActivity(), this.hgP);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }
}
