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
    public static boolean hgU;
    protected com.baidu.live.ao.a gTT;
    protected AlaLastLiveroomInfo giS;
    protected com.baidu.live.ad.a heY;
    private com.baidu.tieba.ala.liveroom.data.a hfF;
    protected com.baidu.tieba.ala.liveroom.operation.a hfG;
    protected com.baidu.live.j.b hfH;
    protected com.baidu.live.j.a hfI;
    protected com.baidu.tieba.ala.liveroom.share.c hfJ;
    protected com.baidu.tieba.ala.liveroom.r.b hfK;
    protected com.baidu.tieba.ala.liveroom.guide.c hfL;
    protected com.baidu.tieba.ala.liveroom.watermark.a hfM;
    protected com.baidu.tieba.ala.liveroom.b.b hfN;
    protected com.baidu.tieba.ala.liveroom.praise.a hfO;
    protected com.baidu.tieba.ala.liveroom.sticker.a hfP;
    protected com.baidu.tieba.ala.liveroom.guide.d hfQ;
    protected com.baidu.tieba.ala.liveroom.w.a hfR;
    protected com.baidu.live.ah.a hfS;
    protected com.baidu.live.ah.d hfT;
    private com.baidu.tieba.ala.liveroom.h.a hfU;
    private m hfV;
    k hfW;
    com.baidu.live.im.b.a hfX;
    protected ad hfY;
    protected ab hfZ;
    protected com.baidu.tieba.ala.liveroom.f.a hgA;
    protected com.baidu.tieba.ala.player.d hgB;
    protected com.baidu.live.guess.a hgC;
    protected com.baidu.live.s.a hgD;
    protected com.baidu.live.an.c hgE;
    protected com.baidu.live.c.a hgF;
    protected RelativeLayout hgG;
    protected RelativeLayout hgH;
    protected boolean hgJ;
    protected ar hgM;
    protected GuardClubInfoHttpResponseMessage hgN;
    boolean hgO;
    boolean hgP;
    boolean hgQ;
    public boolean hgS;
    public boolean hgT;
    protected com.baidu.tieba.ala.liveroom.t.b hgV;
    protected e hgW;
    protected List<com.baidu.live.liveroom.g.d> hgX;
    protected List<com.baidu.live.liveroom.g.b> hgY;
    CustomMessageTask hgZ;
    protected com.baidu.tieba.ala.liveroom.tippop.a hga;
    private com.baidu.tieba.ala.liveroom.guideim.b hgb;
    protected com.baidu.live.view.input.d hgc;
    com.baidu.tieba.ala.liveroom.n.b hgd;
    protected com.baidu.tieba.ala.liveroom.guide.a hge;
    protected com.baidu.live.x.b hgf;
    private com.baidu.live.guardclub.k hgg;
    protected com.baidu.live.m.b hgh;
    protected h hgi;
    protected j hgj;
    protected ag hgk;
    protected com.baidu.tieba.ala.liveroom.turntable.e hgl;
    protected com.baidu.tieba.ala.liveroom.turntable.lucky.b hgm;
    protected com.baidu.tieba.ala.liveroom.q.c hgn;
    private af hgo;
    protected com.baidu.tieba.ala.liveroom.h.e hgp;
    protected com.baidu.live.l.a hgq;
    protected com.baidu.live.v.a hgr;
    protected com.baidu.live.t.a hgs;
    protected com.baidu.live.a.a hgt;
    protected com.baidu.live.k.a hgu;
    protected com.baidu.live.t.b hgv;
    protected com.baidu.live.z.a hgw;
    protected com.baidu.tieba.ala.liveroom.exclusive.b hgx;
    protected bp hgy;
    protected com.baidu.live.aa.a hgz;
    CustomMessageTask hha;
    protected String otherParams;
    private int hgI = -1;
    protected int mOrientation = 0;
    protected boolean hgK = false;
    protected boolean hgL = false;
    private int hgR = a.C0205a.anim_fade_in_and_out;
    CustomMessageTask.CustomRunnable<Object> hhb = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
        @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<Boolean>(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW) { // from class: com.baidu.tieba.ala.liveroom.d.b.1.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.message.CustomResponsedMessage
                /* renamed from: cbZ */
                public Boolean getData() {
                    return true;
                }
            };
        }
    };
    CustomMessageTask.CustomRunnable<Object> hhc = new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.liveroom.d.b.12
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
    private CustomMessageListener hhd = new CustomMessageListener(2913055) { // from class: com.baidu.tieba.ala.liveroom.d.b.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ai aiVar;
            if ((customResponsedMessage.getData() instanceof ai) && (aiVar = (ai) customResponsedMessage.getData()) != null) {
                b.this.a(aiVar.aLD, aiVar.aLz, aiVar.aLA, aiVar.aLB, aiVar.aLC);
            }
        }
    };
    private CustomMessageListener hhe = new CustomMessageListener(2913087) { // from class: com.baidu.tieba.ala.liveroom.d.b.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.wy(7);
        }
    };
    private CustomMessageListener hhf = new CustomMessageListener(2913175) { // from class: com.baidu.tieba.ala.liveroom.d.b.35
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.cbt();
        }
    };
    private CustomMessageListener hhg = new CustomMessageListener(2913131) { // from class: com.baidu.tieba.ala.liveroom.d.b.36
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String valueOf = String.valueOf(b.this.cbX().hpT.Iq().aJV.userId);
            com.baidu.live.view.a.Yo().a(valueOf, new f(b.this.cbX().hpT.Iq().aJV.portrait, valueOf, true, b.this.cbX().pageContext.getUniqueId()));
        }
    };
    private CustomMessageListener hhh = new CustomMessageListener(2913052) { // from class: com.baidu.tieba.ala.liveroom.d.b.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof w) && b.this.hfJ != null) {
                b.this.hfJ.c((w) customResponsedMessage.getData(), false);
            }
        }
    };
    private CustomMessageListener buq = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.d.b.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hfW != null) {
                b.this.hfW.g(z.Ii().Ik());
            }
        }
    };
    private CustomMessageListener hhi = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.d.b.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = b.this.hfF.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                b.this.Ig(str);
            }
        }
    };
    private CustomMessageListener gDt = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.d.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(b.this.cbX().pageContext.getPageActivity());
            } else if (b.this.hfJ != null) {
                b.this.hfJ.c(b.this.cbX().hpT.Iq(), false);
            }
        }
    };
    private CustomMessageListener hhj = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ar) {
                    b.this.hgL = true;
                    b.this.hgM = (ar) data;
                    b.this.b(b.this.hgM);
                } else if (data instanceof com.baidu.live.data.a) {
                    b.this.g((com.baidu.live.data.a) data);
                } else if (data instanceof String) {
                    b.this.If((String) data);
                }
            }
        }
    };
    private CustomMessageListener hhk = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(b.this.cbX().hpT.Iq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(b.this.cbX().hpT.Iq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(b.this.cbX().hpT.Iq().aJV.userId);
                    if (b.this.hfK == null) {
                        b.this.hfK = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    b.this.hfK.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, false, obj);
                    b.this.hfK.a(b.this.hhl);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private e.b hhl = new e.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.5
        @Override // com.baidu.live.personmanager.e.b
        public void Qw() {
            if (b.this.cbX().hpT.Iq() != null && b.this.cbX().hpT.Iq().aKr != null) {
                b.this.cbX().hpT.Iq().aKr.isAdmin = 0;
            }
        }
    };
    private CustomMessageListener hhm = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b)) {
                com.baidu.live.im.data.b bVar = (com.baidu.live.im.data.b) customResponsedMessage.getData();
                if (b.this.hgh != null) {
                    b.this.hgh.A(bVar);
                }
                if (b.this.hgx != null) {
                    b.this.hgx.G(bVar);
                }
                if (b.this.hfI != null) {
                    b.this.hfI.l(bVar);
                }
                if (b.this.hgu != null) {
                    b.this.hgu.l(bVar);
                }
                b.this.t(bVar);
            }
        }
    };
    CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.d.b.7
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
    CustomMessageListener hhn = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_START_LOGIN) { // from class: com.baidu.tieba.ala.liveroom.d.b.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.hgO = false;
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.liveroom.d.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hgd != null) {
                b.this.hgd.ID();
            }
        }
    };
    HttpMessageListener gNI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS) { // from class: com.baidu.tieba.ala.liveroom.d.b.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.live.guardclub.a aVar;
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021135 && (httpResponsedMessage instanceof GuardClubJoinHttpResponseMessage) && !httpResponsedMessage.hasError() && (aVar = ((GuardClubJoinHttpResponseMessage) httpResponsedMessage).bja) != null && b.this.hgg != null && b.this.cbX() != null && b.this.cbX().hpT != null) {
                int[] iArr = new int[2];
                b.this.hgG.getLocationOnScreen(iArr);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = iArr[1] * (-1);
                b.this.hgg.a(b.this.hgG, layoutParams, aVar, b.this.cbX().hpT.Iq());
                com.baidu.live.q.a.aG(aVar.liveId + "", "guard_club_join");
                com.baidu.live.p.a.b(b.this.cbX().hpT.Iq().mLiveInfo.live_id, 7);
            }
        }
    };
    private HttpMessageListener gNF = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.d.b.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage)) {
                GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage;
                if (b.this.cbX() != null && b.this.cbX().hpT != null && b.this.cbX().hpT.Iq() != null && guardClubInfoHttpResponseMessage.bja != null) {
                    if (guardClubInfoHttpResponseMessage.bja.anchorId == b.this.cbX().hpT.Iq().aJV.userId) {
                        b.this.hgN = guardClubInfoHttpResponseMessage;
                        if (b.this.hgN.bjf && com.baidu.live.guardclub.e.LY() != null) {
                            LiveTimerManager.getInstance().removeLiveTimerTask(com.baidu.live.guardclub.e.LY().aS(b.this.cbX().hpT.Iq().mLiveInfo.live_id), true);
                        }
                    }
                }
            }
        }
    };
    private CustomMessageListener hho = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.d.b.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof bz) {
                b.this.a((bz) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hhp = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.d.b.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            b.this.H(b.this.cbX().hpT.Iq());
        }
    };
    private CustomMessageListener hhq = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.d.b.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (b.this.hgq != null) {
                b.this.hgq.Mq();
            }
        }
    };
    private CustomMessageListener hhr = new CustomMessageListener(2913261) { // from class: com.baidu.tieba.ala.liveroom.d.b.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof String) {
                String str = (String) customResponsedMessage.getData();
                if (b.this.hgr != null) {
                    b.this.hgr.iq(str);
                }
            }
        }
    };
    public CustomMessageListener hhs = new CustomMessageListener(2913272) { // from class: com.baidu.tieba.ala.liveroom.d.b.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null) {
                b.this.nk(((Boolean) customResponsedMessage.getData()).booleanValue());
            }
        }
    };
    private CustomMessageListener hht = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.d.b.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (b.this.hgk != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) b.this.hgk).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hhu = new CustomMessageListener(2913199) { // from class: com.baidu.tieba.ala.liveroom.d.b.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof NobleDetailInfo) {
                b.this.a(b.this.cbX().hpT.Iq(), (NobleDetailInfo) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gTU = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.d.b.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof com.baidu.live.ao.c)) {
                Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
                return;
            }
            if (b.this.gTT == null) {
                b.this.gTT = new com.baidu.live.ao.a(b.this.cbX().pageContext.getPageActivity());
            }
            b.this.gTT.a((com.baidu.live.ao.c) customResponsedMessage.getData());
        }
    };
    private CustomMessageListener hhv = new CustomMessageListener(2913235) { // from class: com.baidu.tieba.ala.liveroom.d.b.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler toShowMobileModifyNickNameDialogListener");
            if (b.this.cbX().pageContext.getPageActivity() != null) {
                com.baidu.live.p.a.s(b.this.cbX().pageContext.getPageActivity());
            }
        }
    };
    private View.OnTouchListener hhw = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.30
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                b.this.cbI();
                return false;
            }
            return false;
        }
    };
    public com.baidu.live.z.b hhx = new com.baidu.live.z.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.34
        @Override // com.baidu.live.z.b
        public boolean QX() {
            if (b.this.cbX().hpU != null) {
                if (!b.this.cbX().hpU.clo()) {
                    b.this.hgw.close();
                    return false;
                } else if (b.this.cbX().hpU.getScrollX() != 0) {
                    b.this.hgw.close();
                    return false;
                }
            }
            return true;
        }
    };

    protected abstract void If(String str);

    protected abstract void a(ar arVar);

    protected abstract void b(ar arVar);

    protected abstract void caI();

    protected abstract View caS();

    public abstract boolean caT();

    protected abstract boolean caU();

    protected abstract ViewGroup caV();

    public abstract boolean cak();

    protected abstract void g(com.baidu.live.data.a aVar);

    public void a(bp bpVar) {
        this.hgy = bpVar;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void init() {
        super.init();
        this.hgG = (RelativeLayout) cbX().hpU.findViewById(a.f.ala_live_header_view);
        this.hgH = (RelativeLayout) cbX().hpU.findViewById(a.f.ala_live_footer_view);
        Jg();
        registerListener();
    }

    public void cba() {
    }

    private void Jg() {
        if (this.hfJ == null) {
            this.hfJ = new com.baidu.tieba.ala.liveroom.share.c(cbX().pageContext);
        }
        this.hfR = new com.baidu.tieba.ala.liveroom.w.a(cbX().pageContext, this);
        this.hfN = new com.baidu.tieba.ala.liveroom.b.b(cbX().pageContext, false);
        this.hfO = new com.baidu.tieba.ala.liveroom.praise.a(cbX().pageContext);
        this.hfP = new com.baidu.tieba.ala.liveroom.sticker.a(cbX().pageContext);
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
                this.hfQ = new com.baidu.tieba.ala.liveroom.guide.d(cbX().pageContext);
            }
        }
        this.hga = new com.baidu.tieba.ala.liveroom.tippop.a(cbX().pageContext, this);
        cbd();
        cbg();
        cbh();
        cbm();
        cbn();
        cbo();
        cbc();
        cbb();
        cbp();
    }

    private void cbb() {
        CustomResponsedMessage runTask;
        if (this.hfT == null && (runTask = MessageManager.getInstance().runTask(2913219, com.baidu.live.ah.d.class, cbX().pageContext)) != null && runTask.getData() != null) {
            this.hfT = (com.baidu.live.ah.d) runTask.getData();
        }
    }

    private void cbc() {
        CustomResponsedMessage runTask;
        if (this.hgh == null && (runTask = MessageManager.getInstance().runTask(2913206, com.baidu.live.m.b.class, cbX().pageContext)) != null && runTask.getData() != null) {
            this.hgh = (com.baidu.live.m.b) runTask.getData();
            this.hgh.c(cbX().pageContext);
            this.hgh.Pc().setTargetView(this.hgH);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        if (this.hgA == null) {
            this.hgA = new com.baidu.tieba.ala.liveroom.f.a(cbX().pageContext);
            this.hgA.setId(a.f.ala_live_room_back_to_last_live);
        }
        this.hgA.a(cbX().hpT.Iq(), alaLastLiveroomInfo);
        this.hgA.at(this.hgH);
    }

    private void cbd() {
        this.hfV = new m();
    }

    public void nh(boolean z) {
        this.hgJ = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbe() {
        CustomResponsedMessage runTask;
        if (this.hfI == null && (runTask = MessageManager.getInstance().runTask(2913273, com.baidu.live.j.a.class, cbX().pageContext)) != null) {
            this.hfI = (com.baidu.live.j.a) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbf() {
        w Iq = cbX().hpT.Iq();
        boolean z = com.baidu.live.ae.a.RB().brA.aOs;
        if (Iq.mLiveInfo != null && Iq.mLiveInfo.mAlaLiveSwitchData != null && Iq.mLiveInfo.mAlaLiveSwitchData.isGuardThroneSwitchUnabled()) {
            z = false;
        }
        boolean z2 = Iq.aKG ? z : false;
        if (z2) {
            if (this.hfH == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, cbX().pageContext);
                if (runTask != null) {
                    this.hfH = (com.baidu.live.j.b) runTask.getData();
                } else {
                    return;
                }
            }
            if (this.hfH != null) {
                this.hfH.eX(1);
                View view = this.hfH.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(cbX().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(cbX().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_liveroom_hostheader);
                    layoutParams.addRule(1, a.f.ala_liveroom_hostheader);
                    ck(view);
                    this.hgG.addView(view, layoutParams);
                    if (z2) {
                        this.hfH.a(Iq);
                    }
                }
            }
        }
    }

    private void cbg() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913163, com.baidu.live.view.input.d.class, cbX().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hgc = (com.baidu.live.view.input.d) runTask.getData();
            this.hgc.a(new d.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.23
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
                    return b.this.cbk();
                }

                @Override // com.baidu.live.view.input.d.a
                public int Nm() {
                    return b.this.cbl();
                }
            });
        }
    }

    private void cbh() {
        this.hgd = new com.baidu.tieba.ala.liveroom.n.b(this.hfF.pageContext);
        this.hgd.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.24
            @Override // com.baidu.tieba.ala.liveroom.n.b.a
            public boolean cca() {
                return b.this.caU();
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
    public void cbi() {
        if (this.hgC == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913247, com.baidu.live.guess.a.class);
            if (runTask.getData() != null) {
                this.hgC = (com.baidu.live.guess.a) runTask.getData();
                this.hgC.q(getActivity());
            } else {
                return;
            }
        }
        if (this.hgC != null) {
            this.hgC.eY(0);
            this.hgC.e(cbX().hpT.Iq());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ni(boolean z) {
        if (this.hgb != null) {
            this.hgb.nL(z);
        }
        if (this.hgd != null) {
            this.hgd.nL(z);
        }
        hgU = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbj() {
        return hgU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean cbk() {
        w Iq;
        if (cbX() == null || cbX().hpT == null || (Iq = cbX().hpT.Iq()) == null || Iq.aKr == null) {
            return false;
        }
        String str = Iq.aKr.throneUid;
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(currentAccount) || !str.equals(currentAccount)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int cbl() {
        w Iq;
        if (cbX() != null && cbX().hpT != null && (Iq = cbX().hpT.Iq()) != null && !ListUtils.isEmpty(Iq.aKB)) {
            for (AlaLiveMarkData alaLiveMarkData : Iq.aKB) {
                if (alaLiveMarkData != null && 1 == alaLiveMarkData.type) {
                    return alaLiveMarkData.royalLevel;
                }
            }
        }
        return 0;
    }

    private void cbm() {
        if (this.hgg == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913161, com.baidu.live.guardclub.k.class, cbX().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgg = (com.baidu.live.guardclub.k) runTask.getData();
            } else {
                return;
            }
        }
        this.hgg.setOtherParams(Oj());
    }

    private void cbn() {
        if (this.hgl == null) {
            this.hgl = new com.baidu.tieba.ala.liveroom.turntable.e(cbX().pageContext.getPageActivity());
        }
    }

    private void cbo() {
        if (this.hgn == null) {
            this.hgn = new com.baidu.tieba.ala.liveroom.q.c(cbX().pageContext.getPageActivity());
        }
    }

    private void cbp() {
        if (this.gTT == null) {
            this.gTT = new com.baidu.live.ao.a(cbX().pageContext.getPageActivity());
        }
    }

    private void registerListener() {
        if (this.hgZ == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW);
            this.hgZ = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW, this.hhb);
            this.hgZ.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hgZ);
        }
        if (this.hha == null) {
            MessageManager.getInstance().unRegisterTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS);
            this.hha = new CustomMessageTask(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS, this.hhc);
            this.hha.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(this.hha);
        }
        MessageManager.getInstance().registerListener(this.hhj);
        MessageManager.getInstance().registerListener(this.hhk);
        MessageManager.getInstance().registerListener(this.hhm);
        MessageManager.getInstance().registerListener(this.hhg);
        MessageManager.getInstance().registerListener(this.hhh);
        MessageManager.getInstance().registerListener(this.gDt);
        MessageManager.getInstance().registerListener(this.hhi);
        MessageManager.getInstance().registerListener(this.gDG);
        MessageManager.getInstance().registerListener(this.hhn);
        MessageManager.getInstance().registerListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().registerListener(this.gNI);
        MessageManager.getInstance().registerListener(this.gNF);
        MessageManager.getInstance().registerListener(this.buq);
        MessageManager.getInstance().registerListener(this.hho);
        MessageManager.getInstance().registerListener(this.hhp);
        MessageManager.getInstance().registerListener(this.hhq);
        MessageManager.getInstance().registerListener(this.hht);
        MessageManager.getInstance().registerListener(this.hhu);
        MessageManager.getInstance().registerListener(this.hhd);
        MessageManager.getInstance().registerListener(this.hhe);
        MessageManager.getInstance().registerListener(this.hhf);
        MessageManager.getInstance().registerListener(this.gTU);
        MessageManager.getInstance().registerListener(this.hhv);
        MessageManager.getInstance().registerListener(this.hhr);
        MessageManager.getInstance().registerListener(this.hhs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Le() {
        if (TbadkCoreApplication.isLogin()) {
            return true;
        }
        ViewHelper.skipToLoginActivity(cbX().pageContext.getPageActivity());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ig(String str) {
        String string;
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cbX().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(cbX().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.RB().brA.aNR;
        final boolean z = !TextUtils.isEmpty(str2);
        if (z) {
            string = cbX().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt);
        } else {
            string = cbX().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok);
        }
        bdAlertDialog.setPositiveButton(string, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.d.b.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink(b.this.cbX().pageContext, new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(cbX().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbq() {
        if (this.hfW != null && this.hgc != null) {
            this.hfW.Ne().a(this.hgc.QD(), z.Ii().Ik(), cbX().hpT.Iq().mLiveInfo);
            ni(true);
            if (this.hgo == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913165, af.class, cbX().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgo = (af) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgo.hz("input_panel");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbr() {
        if (this.hfW != null && this.hgc != null) {
            this.hfW.Nf().cp(true);
            this.hfW.Nf().setClicked(false);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            layoutParams.leftMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.rightMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_tbds26);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            if (this.hgk != null) {
                layoutParams.addRule(3, this.hgk.IC().getId());
            }
            this.hfW.a(this.hgH, cbX().hpT.Iq(), this.hgc.QD(), layoutParams);
            ni(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbs() {
        if (this.hfW != null) {
            this.hfW.Ne().hide();
            ni(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(int i, int i2, int i3) {
        if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aJV != null && cbX().hpT.Iq().mLiveInfo != null) {
            a(cbX().hpT.Iq(), i, i2, i3, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, int i2, int i3, int i4) {
        boolean z;
        String str;
        int i5;
        if (TbadkCoreApplication.getInst().getIntentClass(com.baidu.live.d.k.class) != null && Le()) {
            if (wVar == null) {
                wVar = cbX().hpT.Iq();
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
            if (this.hgN != null && this.hgN.bja != null && this.hgN.bja.anchorId == wVar.aJV.userId) {
                z5 = this.hgN.bjf;
            }
            com.baidu.live.d.k kVar = new com.baidu.live.d.k(cbX().pageContext.getPageActivity(), valueOf, str2, valueOf2, valueOf3, i6, Iz, str3, z3, i, i2, i3, z2, i7, valueOf4, this.otherParams, z5, i4);
            if (wVar != null && wVar.mLiveInfo != null && wVar.mLiveInfo.mAlaLiveSwitchData != null) {
                kVar.bn(wVar.mLiveInfo.mAlaLiveSwitchData.isRedPkgSwitchUnabled());
            }
            kVar.gr(str);
            kVar.bl(z);
            if (com.baidu.tieba.ala.liveroom.v.b.ckB().brJ != null) {
                kVar.bm(com.baidu.tieba.ala.liveroom.v.b.ckB().brJ.aLH != 1);
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
            if (cbX() != null && cbX().hpT != null) {
                kVar.gt(cbX().hpT.cjP());
            }
            if (!this.hgS) {
                this.hgT = true;
                MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_SHOW));
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, kVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbt() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.METHOD_GIFT_PANEL_DISMISS));
        fi(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bz bzVar) {
        if (bzVar != null && Le()) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new v(cbX().pageContext.getPageActivity(), bzVar.aRN, bzVar.liveId, bzVar.aRO)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.ae.a.RB().brA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(cbX().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.ae.a.RB().brA.aOt, 1, false)));
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
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CommonWebViewActivityConfig(cbX().pageContext.getPageActivity(), WebviewHelper.addQueryParams(nobleDetailInfo.url, hashMap))));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbu() {
        if (this.hgc != null) {
            this.hgc.d(this.hfF.pageContext);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbv() {
        w Iq = cbX().hpT.Iq();
        LogManager.getCommonLogger().doClickQuickImHiLog((Iq == null || Iq.mLiveInfo == null) ? "" : Iq.mLiveInfo.feed_id, Oj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Ih(String str) {
        if (this.hgc != null) {
            this.hgc.hC(str);
        }
    }

    private void cbw() {
        if ("home_rec_play".equals(cbX().fromType) || "frs_play".equals(cbX().fromType) || "frs_live_play".equals(cbX().fromType) || "person_play".equals(cbX().fromType) || "search".equals(cbX().fromType) || "person_attention".equals(cbX().fromType)) {
            com.baidu.live.c.BL().bc(true);
        } else {
            com.baidu.live.c.BL().bc(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nj(boolean z) {
        View HM;
        if (this.hfY == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aVr = false;
            fVar.context = cbX().pageContext.getPageActivity();
            fVar.aVA = z;
            fVar.fromType = cbX().fromType;
            fVar.aVB = cak() ? false : true;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfY = (ad) runTask.getData();
            }
        }
        if (this.hfY != null && (HM = this.hfY.HM()) != null && this.hfF.hpU.indexOfChild(HM) < 0) {
            this.hfF.hpU.addView(HM, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbx() {
        View IC;
        if (this.hgk == null) {
            ak akVar = new ak();
            akVar.aVr = false;
            akVar.pageContext = cbX().pageContext;
            akVar.fromType = cbX().fromType;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hgk = (ag) runTask.getData();
            }
        }
        if (this.hgk != null && (IC = this.hgk.IC()) != null && cbX().hpU.indexOfChild(IC) < 0) {
            if (IC.getParent() instanceof ViewGroup) {
                ((ViewGroup) IC.getParent()).removeView(IC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            if (this.hfW != null && this.hfW.Nf().OY()) {
                layoutParams.bottomMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hfW.Nf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            cbX().hpU.addView(IC, layoutParams);
        }
    }

    protected void nk(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (this.hgk != null) {
            View IC = this.hgk.IC();
            if (IC.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) IC.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            if (this.hfW != null && z) {
                layoutParams.bottomMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds170);
                layoutParams.addRule(2, this.hfW.Nf().getView().getId());
            } else {
                layoutParams.bottomMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds100);
            }
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            IC.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cby() {
        View Ip;
        if (this.hfZ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aVr = false;
            aVar.context = cbX().pageContext.getPageActivity();
            aVar.fromType = cbX().fromType;
            aVar.aVs = cbX().hpZ;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hfZ = (ab) runTask.getData();
            }
        }
        if (this.hfZ != null && (Ip = this.hfZ.Ip()) != null && this.hgG != null && this.hgG.indexOfChild(Ip) < 0) {
            if (Ip.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ip.getParent()).removeView(Ip);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            layoutParams.addRule(3, a.f.ala_head_line_entry_id);
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            this.hgG.addView(Ip, this.hgG.getChildCount(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbz() {
        CustomResponsedMessage runTask;
        if (this.hfX == null && (runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, cbX().pageContext)) != null) {
            this.hfX = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hfX != null) {
            this.hfX.setOtherParams(this.otherParams);
            this.hfX.a(new a.InterfaceC0193a() { // from class: com.baidu.tieba.ala.liveroom.d.b.27
                @Override // com.baidu.live.im.b.a.InterfaceC0193a
                public void NJ() {
                    b.this.cbI();
                }
            });
            this.hfX.a(cbX().hpT.Iq(), false);
            View DL = this.hfX.DL();
            if (DL != null && this.hgH.indexOfChild(DL) < 0) {
                Resources resources = cbX().pageContext.getResources();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ScreenHelper.getScreenWidth(cbX().pageContext.getPageActivity()), resources.getDimensionPixelOffset(a.d.sdk_ds98));
                layoutParams.addRule(2, a.f.ala_liveroom_msg_list_root);
                layoutParams.bottomMargin = resources.getDimensionPixelOffset(a.d.sdk_ds20);
                this.hgH.addView(DL, layoutParams);
            }
        }
    }

    private void cbA() {
        if (this.hfU == null) {
            this.hfU = new com.baidu.tieba.ala.liveroom.h.a(cbX().pageContext);
        }
        if (this.hgM != null) {
            this.hfU.Il(this.hgM.user_id);
        }
        this.hfU.at(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void nl(boolean z) {
        if (cbX() != null && !z) {
            if (this.hgq == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, cbX().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgq = (com.baidu.live.l.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgq.c(this.hgG, cbQ());
            if (cbX().hpT != null) {
                this.hgq.a(cbX().hpT.Iq());
            }
            this.hgq.setCanVisible(true);
            this.hgq.cd(true);
            this.hgq.a(cbX().hpT.bUu());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbB() {
        if (cbX() != null) {
            if (this.hgr == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, cbX().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgr = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (cbX().hpT != null) {
                this.hgr.b(cbX().hpT.Iq(), this.otherParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void car() {
        if (cbX() != null) {
            if (this.heY == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, cbX().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.heY = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.heY.setIsHost(false);
            this.heY.a(caV(), cbX().hpT.Iq().aKU);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbC() {
        if (cbX() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913234, -1L));
            if (this.hgs == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, cbX().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hgs = (com.baidu.live.t.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgs.setIsHost(false);
            this.hgs.a(caV(), cbX().hpT.Iq());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbD() {
        if (this.hfN != null && cbX() != null && cbX().hpT != null) {
            this.hfN.d(this.hgG, cbX().hpT.Iq());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbE() {
        if (cbX() != null) {
            if (this.hgu == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, cbX().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgu = (com.baidu.live.k.a) runTask.getData();
                } else {
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = this.hfF.pageContext.getPageActivity().getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            this.hgu.a(this.hgG, cbX().hpT.Iq(), layoutParams, this.otherParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbF() {
        if (cbX() != null) {
            if (this.hgf == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913264, com.baidu.live.x.b.class, cbX().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hgf = (com.baidu.live.x.b) runTask.getData();
                } else {
                    return;
                }
            }
            this.hgf.a(cbX().hpT.Iq(), this);
        }
    }

    protected void cbG() {
        if (this.hgv == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.b.class, cbX().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgv = (com.baidu.live.t.b) runTask.getData();
            } else {
                return;
            }
        }
        if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aJV != null && cbX().hpT.Iq().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.height = BdUtilHelper.getDimens(cbX().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(cbX().pageContext.getPageActivity(), a.d.sdk_ds16);
            this.hgv.b(this.hgG, layoutParams, cbX().hpT.Iq());
        }
    }

    private void cbH() {
        if (this.hgi == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, cbX().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hgi = (h) runTask.getData();
            } else {
                return;
            }
        }
        if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aJV != null && cbX().hpT.Iq().mLiveInfo != null) {
            this.hgi.setHost(false);
            this.hgi.setOtherParams(Oj());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, a.f.ala_liveroom_hostheader);
            layoutParams.addRule(3, a.f.ala_liveroom_hostheader);
            layoutParams.topMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
            this.hgi.a(this.hgG, layoutParams, cbX().hpT.Iq());
            this.hgi.a(new l() { // from class: com.baidu.tieba.ala.liveroom.d.b.28
                @Override // com.baidu.live.guardclub.l
                public void Me() {
                    b.this.cbY();
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:147:0x03df, code lost:
        cbX().hpT.cjz();
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
            if (this.heY != null) {
            }
            if (bVar.getMsgType() != 12) {
            }
            if (jSONObject2 == null) {
            }
        }
        if (this.heY != null) {
            this.heY.N(jSONObject2);
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
                            cbX().hpT.Iq().aKr.isAdmin = 1;
                        }
                    } else if (optInt2 == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cbX().hpT.Iq().aKr.isAdmin = 0;
                            cbX().hpT.cjz();
                        }
                    } else if (optInt2 == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        cbX().hpT.Iq().aKr.isAdmin = 0;
                        cbX().hpT.cjz();
                    }
                } else if ("task".equals(optString2)) {
                    dK(jSONObject2);
                } else if ("live_net_status".equals(optString2)) {
                    int optInt3 = jSONObject2.optInt("net_status");
                    if (this.hga != null && !cbX().hpY) {
                        String str = null;
                        if (optInt3 == 0) {
                            str = cbX().pageContext.getString(a.h.ala_audience_live_net_tip_1);
                        } else if (optInt3 == 1) {
                            str = cbX().pageContext.getString(a.h.ala_audience_live_net_tip_2);
                        } else if (optInt3 == 2) {
                            str = cbX().pageContext.getString(a.h.ala_audience_live_net_tip_3);
                        }
                        if (str != null) {
                            if (bWk()) {
                                BdUtilHelper.getCustomToast().showToast(str, 1);
                            } else {
                                this.hga.a(cbX().hpS.getLiveContainerView(), str, 1);
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
                    if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aKr != null && cbX().hpT.Iq().aKr.userId == optLong2) {
                        cbX().hpT.Iq().aKr.isBlock = 1;
                        caI();
                    }
                } else if ("live_talk_remove_ban".equals(optString2)) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aKr != null && cbX().hpT.Iq().aKr.userId == optLong3) {
                        cbX().hpT.Iq().aKr.isBlock = 0;
                        caI();
                    }
                } else if ("live_talk_admin_ban".equals(optString2)) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aKr != null && cbX().hpT.Iq().aKr.userId == optLong4) {
                        cbX().hpT.Iq().aKr.isUegBlock = 1;
                        caI();
                    }
                } else if ("live_talk_admin_remove_ban".equals(optString2)) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (cbX().hpT.Iq() != null && cbX().hpT.Iq().aKr != null && cbX().hpT.Iq().aKr.userId == optLong5) {
                        cbX().hpT.Iq().aKr.isUegBlock = 0;
                        caI();
                    }
                } else if ("need_update_live_mark_info".equals(optString2)) {
                    if (cbX() != null && cbX().hpT != null && cbX().hpT.Iq() != null && cbX().hpT.Iq().aKr != null) {
                        long j4 = cbX().hpT.Iq().aKr.userId;
                        if (j4 == jSONObject2.optLong("user_id")) {
                            cbX().hpT.cjz();
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
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913194, cbX().hpT.Iq().aKr));
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
                } else if (TextUtils.equals(optString2, "mix_room_close") && this.hgB != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    try {
                        jSONObject5.put("source", "im_mix_room_close");
                        jSONObject5.put("room_ids", jSONObject2.optJSONArray("room_ids"));
                        this.hgB.z("mix_room_close", jSONObject5);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        } else if (bVar.getMsgType() == 125) {
            if (this.hfR != null) {
                this.hfR.K(bVar);
            }
        } else if (bVar.getMsgType() == 24 && jSONObject2 != null) {
            com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject2);
            if (cbX().hpT != null && cbX().hpT.Iq() != null && cbX().hpT.Iq().aLe && TextUtils.equals(cVar.bnR, "luckybag")) {
                cVar.bdf = "";
            }
            com.baidu.live.data.a NU2 = bVar.NU();
            boolean z2 = false;
            String str4 = null;
            if (cbX().hpT == null || cbX().hpT.Iq() == null || cbX().hpT.Iq().mLiveInfo == null) {
                j = 0;
                j2 = 0;
                j3 = 0;
            } else {
                long j6 = cbX().hpT.Iq().mLiveInfo.live_id;
                long j7 = cbX().hpT.Iq().mLiveInfo.group_id;
                long j8 = cbX().hpT.Iq().aJV.userId;
                str4 = cbX().hpT.Iq().mLiveInfo.appId;
                z2 = cbX().hpT.Iq().mLiveInfo.isPubShow;
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
        this.hgB = dVar;
    }

    protected void Ic(String str) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cbI() {
        if (cbJ()) {
            BdUtilHelper.hideSoftKeyPad(cbX().pageContext.getPageActivity(), cbX().hpS.getLiveContainerView());
            caT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbJ() {
        if (caS() == null || caS().getVisibility() != 0) {
            return false;
        }
        return true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(w wVar) {
        CustomResponsedMessage runTask;
        cbX().hpU.setOnTouchListener(this.hhw);
        cbR();
        cbS();
        cbT();
        cbA();
        cbH();
        cbG();
        if (this.hfP != null && cbX().hpT.Iq() != null && cbX().hpT.Iq().mLiveInfo != null) {
            this.hfP.cG(cbX().hpT.Iq().mLiveInfo.mAlaLiveStickerList);
        }
        if (this.hfV != null) {
            this.hfV.g(cbX().hpT.Iq());
        }
        if (this.hfT != null) {
            this.hfT.e(cbX().hpT.Iq());
        }
        if (this.hgb != null) {
            this.hgb.c(cbX().hpT.Iq(), Oj());
        }
        if (this.hgc != null) {
            this.hgc.b(cbX().hpT.Iq(), Oj());
        }
        if (this.hgd != null) {
            this.hgd.c(cbX().hpT.Iq(), Oj());
        }
        if (this.hgD != null) {
            this.hgD.e(cbX().hpT.Iq());
        }
        if (cbX().hpU != null) {
            cbX().hpU.setLiveViewOnDispatchTouchEventListener(new com.baidu.live.liveroom.g.b() { // from class: com.baidu.tieba.ala.liveroom.d.b.31
                @Override // com.baidu.live.liveroom.g.b
                public boolean dispatchTouchEvent(MotionEvent motionEvent) {
                    boolean Q = b.this.Q(motionEvent);
                    if (motionEvent.getAction() == 0 && b.this.cbJ() && b.this.hfO != null) {
                        b.this.hfO.oe(false);
                    }
                    if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && b.this.hfO != null) {
                        b.this.hfO.oe(true);
                    }
                    return Q;
                }

                @Override // com.baidu.live.liveroom.g.b
                public boolean PK() {
                    if (b.this.hgY == null) {
                        return false;
                    }
                    for (com.baidu.live.liveroom.g.b bVar : b.this.hgY) {
                        if (bVar.PK()) {
                            return true;
                        }
                    }
                    return false;
                }
            });
            cbX().hpU.setLiveViewOnTouchEventListener(new com.baidu.live.liveroom.g.d() { // from class: com.baidu.tieba.ala.liveroom.d.b.32
                @Override // com.baidu.live.liveroom.g.d
                public boolean onTouchEvent(MotionEvent motionEvent) {
                    return b.this.P(motionEvent);
                }
            });
        }
        if (this.hgo == null && (runTask = MessageManager.getInstance().runTask(2913165, af.class, cbX().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hgo = (af) runTask.getData();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbK() {
        if (this.hgD == null && cbX() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, cbX().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hgD = (com.baidu.live.s.a) runTask.getData();
                this.hgD.m(cbX().hpU);
                this.hgD.b(cbX().hpT.Iq());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbL() {
        w Iq;
        ViewGroup viewGroup;
        CustomResponsedMessage runTask;
        if (cbX() != null && cbX().hpT != null && (Iq = cbX().hpT.Iq()) != null && Iq.mLiveInfo != null && !Iq.mLiveInfo.isRecommendTabSwitchUnabled() && (viewGroup = (ViewGroup) cbX().hpS) != null) {
            if (this.hgw == null && (runTask = MessageManager.getInstance().runTask(2913223, com.baidu.live.z.a.class, cbX().pageContext)) != null && runTask.getData() != null) {
                this.hgw = (com.baidu.live.z.a) runTask.getData();
            }
            if (this.hgw != null) {
                this.hgw.n(Iq);
                this.hgw.a(this.hhx);
                this.hgw.a(viewGroup, this.hgG);
                a(this.hgw.QV());
                a(this.hgw.QW());
            }
        }
    }

    protected void a(com.baidu.live.liveroom.g.d dVar) {
        if (this.hgX == null) {
            this.hgX = new ArrayList();
        }
        if (!this.hgX.contains(dVar)) {
            this.hgX.add(dVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.d dVar) {
        if (this.hgX != null && this.hgX.contains(dVar)) {
            this.hgX.remove(dVar);
        }
    }

    protected void cbM() {
        if (this.hgX != null) {
            this.hgX.clear();
            this.hgX = null;
        }
    }

    protected boolean P(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgX == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.d> it = this.hgX.iterator();
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
        if (this.hgY == null) {
            this.hgY = new ArrayList();
        }
        if (!this.hgY.contains(bVar)) {
            this.hgY.add(bVar);
        }
    }

    protected void b(com.baidu.live.liveroom.g.b bVar) {
        if (this.hgY != null && this.hgY.contains(bVar)) {
            this.hgY.remove(bVar);
        }
    }

    protected void cbN() {
        if (this.hgY != null) {
            this.hgY.clear();
            this.hgY = null;
        }
    }

    protected boolean Q(MotionEvent motionEvent) {
        boolean z = false;
        if (this.hgY == null) {
            return false;
        }
        Iterator<com.baidu.live.liveroom.g.b> it = this.hgY.iterator();
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
    public void cbO() {
        if (this.hgp == null && this.hgy != null && this.hgy.aQZ && cbX() != null && cbX().hpT != null && cbX().hpT.Iq() != null) {
            this.hgp = new com.baidu.tieba.ala.liveroom.h.e(cbX().pageContext, this.hgy);
            this.hgp.J(cbX().hpT.Iq());
            if (this.hgy.aRc == 1) {
                if (this.hfW != null) {
                    this.hgP = true;
                }
            } else if (this.hgy.aRc == 2) {
                a(cbX().hpT.Iq(), -1, -1, -1, -1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cbP() {
        CustomResponsedMessage runTask;
        if (cbX() != null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, cbX().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.hgz = (com.baidu.live.aa.a) runTask.getData();
            this.hgz.p(caV());
            if (cbX().hpT != null) {
                this.hgQ = this.hgz.o(cbX().hpT.Iq());
            }
            this.hgz.setCanVisible(!this.hgK);
        }
    }

    private ViewGroup.LayoutParams cbQ() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.topMargin = cbX().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        layoutParams.addRule(3, a.f.ala_rank_level_entry);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int M(boolean z, boolean z2) {
        Rect rect = new Rect();
        cbX().hpS.getLiveContainerView().getWindowVisibleDisplayFrame(rect);
        int dip2px = (ViewCommonUtil.getScreenFullSize(cbX().pageContext.getPageActivity())[1] - rect.bottom) - (MenuKeyUtils.hasSmartBar() ? BdUtilHelper.dip2px(cbX().pageContext.getPageActivity(), 48.0f) : 0);
        int dimensionPixelOffset = z2 ? cbX().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds88) : 0;
        return dimensionPixelOffset + dip2px + cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96) + (z ? cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds128) : 0) + cbX().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
    }

    private void cbR() {
        if (this.hfO != null) {
            this.hfO.aA(cbX().hpU);
        }
    }

    private void cbS() {
        if (this.hfP != null) {
            this.hfP.aD(cbX().hpU);
        }
    }

    private void cbT() {
        if (this.hfS == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ah.a.class);
            if (runTask != null && runTask.getData() != null) {
                this.hfS = (com.baidu.live.ah.a) runTask.getData();
            }
            cbU();
        }
    }

    private void dK(JSONObject jSONObject) {
        if (this.hfS != null) {
            if (this.hfL != null) {
                this.hfS.cV(this.hfL.cfK() ? false : true);
            } else {
                this.hfS.cV(true);
            }
            this.hfS.R(jSONObject);
        }
    }

    private void cbU() {
        if (this.hfS != null && cbX().hpT.Iq() != null && cbX().hpT.Iq().aKF != null) {
            if (this.hfL != null) {
                this.hfS.cV(this.hfL.cfK() ? false : true);
            } else {
                this.hfS.cV(true);
            }
            this.hfS.i(cbX().hpT.Iq());
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.c
    public void j(w wVar) {
        if (wVar != null) {
            if (this.hfP != null && wVar.mLiveInfo != null) {
                this.hfP.cG(wVar.mLiveInfo.mAlaLiveStickerList);
            }
            if (this.hgh != null) {
                this.hgh.h(wVar);
            }
            cbU();
            if (this.hfU != null && wVar.aJV != null) {
                this.hfU.Il(String.valueOf(wVar.aJV.userId));
            }
            if (this.hfH != null) {
                this.hfH.a(wVar);
            }
            if (this.hfZ != null && wVar.mLiveInfo != null) {
                this.hfZ.a(wVar.mLiveInfo, wVar.aJV);
            }
            if (this.hfX != null) {
                this.hfX.a(wVar);
            }
            if (this.hgz != null) {
                this.hgQ = this.hgz.o(wVar);
            }
            if (this.hgq != null) {
                this.hgq.a(wVar);
            }
            if (this.hgs != null) {
                this.hgs.a(wVar);
            }
            if (this.hgr != null) {
                this.hgr.a(wVar);
            }
            if (this.heY != null) {
                this.heY.a(wVar);
            }
            if (this.hgu != null) {
                this.hgu.a(wVar);
            }
            if (this.hgt != null) {
                this.hgt.a(wVar);
            }
            if (this.hgv != null) {
                this.hgv.a(wVar);
            }
            if (this.hgC != null) {
                this.hgC.b(wVar);
            }
            wA(wVar.mLiveInfo.isAudioOnPrivate);
        }
    }

    private void wA(int i) {
        if (!cbX().hpY) {
            if (this.hgI < 0 && i == 0) {
                this.hgI = i;
            } else if (this.hgI != i) {
                if (i == 1) {
                    if (!this.hga.xo(2)) {
                        String string = cbX().pageContext.getString(a.h.ala_audience_live_mute_open_tip);
                        if (UtilHelper.getRealScreenOrientation(cbX().pageContext.getPageActivity()) == 2) {
                            BdUtilHelper.getCustomToast().showToast(string, 1);
                        } else {
                            this.hga.a(cbX().hpS.getLiveContainerView(), string, 2, true);
                        }
                    }
                } else {
                    String string2 = cbX().pageContext.getString(a.h.ala_audience_live_mute_close_tip);
                    this.hga.xp(2);
                    this.hga.xp(3);
                    if (bWk()) {
                        BdUtilHelper.getCustomToast().showToast(string2, 1);
                    } else {
                        this.hga.a(cbX().hpS.getLiveContainerView(), string2, 3);
                    }
                }
                this.hgI = i;
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void cz(boolean z) {
        super.cz(z);
        if (z) {
            cbV();
        }
        if (this.hgh != null) {
            this.hgh.Mg();
        }
        if (this.hfT != null) {
            this.hfT.Mg();
        }
        if (this.hfR != null) {
            this.hfR.clM();
        }
        if (this.hfJ != null) {
            this.hfJ.En();
        }
        if (this.hfL != null) {
            this.hfL.onDestroy();
        }
        if (this.hfS != null) {
            this.hfS.onDestroy();
            this.hfS = null;
        }
        if (this.hfY != null) {
            View HM = this.hfY.HM();
            if (HM != null && HM.getParent() != null) {
                ((ViewGroup) HM.getParent()).removeView(HM);
            }
            this.hfY.onDestroy();
            this.hfY = null;
        }
        if (this.hfX != null) {
            this.hfX.a((a.InterfaceC0193a) null);
            this.hfX.DN();
        }
        if (this.hga != null) {
            this.hga.En();
        }
        this.hgI = -1;
        if (this.hfU != null) {
            this.hfU.En();
            this.hfU.onDestroy();
        }
        if (this.hfM != null) {
            this.hfM.clK();
        }
        if (this.hfN != null) {
            this.hfN.cad();
            this.hfN.IB();
        }
        if (this.hfO != null) {
            this.hfO.IB();
        }
        if (this.hfV != null) {
            this.hfV.IB();
        }
        if (this.hgb != null) {
            this.hgb.Mg();
        }
        if (this.hgc != null) {
            this.hgc.IB();
        }
        if (this.hgd != null) {
            this.hgd.onDestroy();
        }
        if (this.hgg != null) {
            this.hgg.onDestory();
        }
        if (this.hgj != null) {
            this.hgj.Do();
        }
        if (this.hgi != null) {
            this.hgi.Do();
        }
        if (this.hgv != null) {
            this.hgv.Do();
        }
        if (this.hgp != null) {
            this.hgp.onDestroy();
        }
        if (this.hgl != null) {
            this.hgl.IB();
        }
        if (this.gTT != null) {
            this.gTT.IB();
        }
        if (this.hgm != null) {
            this.hgm.IB();
        }
        if (this.hgo != null) {
            this.hgo.IB();
        }
        if (this.hfK != null) {
            this.hfK.onDestory();
        }
        if (this.hgz != null) {
            this.hgz.IB();
        }
        if (this.hgq != null) {
            this.hgq.Do();
        }
        if (this.hgs != null) {
            this.hgs.Do();
        }
        if (this.hgr != null) {
            this.hgr.Do();
        }
        if (this.heY != null) {
            this.heY.Do();
        }
        if (this.hgn != null) {
            this.hgn.IB();
        }
        if (this.hgk != null) {
            this.hgk.onDestroy();
        }
        if (this.hgw != null) {
            this.hgw.En();
            b(this.hgw.QV());
            b(this.hgw.QW());
        }
        if (this.hgx != null) {
            this.hgx.Do();
        }
        if (this.hgu != null) {
            this.hgu.Do();
        }
        if (this.hfW != null) {
            this.hfW.Nf().Do();
        }
        if (this.hgC != null) {
            this.hgC.Mg();
        }
        if (this.hgD != null) {
            this.hgD.Mg();
            this.hgD = null;
        }
        ShowUtil.windowCount = 0;
        cbM();
        cbN();
    }

    private void cbV() {
        LinkedList<View> linkedList = new LinkedList();
        int childCount = cbX().hpU.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = cbX().hpU.getChildAt(i);
            if (childAt != this.hgG && childAt != this.hgH) {
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
        if (this.hgG != null) {
            this.hgG.removeAllViews();
        }
        if (this.hgH != null) {
            this.hgH.removeAllViews();
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
        if (this.hfY != null && (HM = this.hfY.HM()) != null && HM.getParent() != null) {
            ((ViewGroup) HM.getParent()).removeView(HM);
        }
        if (this.hfX != null && (DL = this.hfX.DL()) != null && DL.getParent() != null) {
            ((ViewGroup) DL.getParent()).removeView(DL);
        }
        if (this.hfL != null) {
            this.hfL.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public boolean PG() {
        if (this.hfQ == null || !this.hfQ.cfP()) {
            if (this.hfL == null || !this.hfL.aw(cbX().hpS.getLiveContainerView())) {
                if (this.hfO != null) {
                    this.hfO.bWQ();
                }
                if (TbadkCoreApplication.getInst().isMobileBaidu() && this.hge != null && this.hge.cfy()) {
                    this.hge.cfH();
                    return false;
                } else if (this.hgd == null || !this.hgd.SL()) {
                    if (this.hgE == null || !this.hgE.SL()) {
                        if (this.hgf == null || !this.hgf.QP()) {
                            cbw();
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
        if (this.hgh != null) {
            this.hgh.release();
        }
        if (this.hfT != null) {
            this.hfT.onDestroy();
        }
        if (this.hfS != null) {
            this.hfS.onDestroy();
            this.hfS = null;
        }
        if (this.hfR != null) {
            this.hfR.clM();
        }
        if (this.hfY != null) {
            this.hfY.onDestroy();
            this.hfY = null;
        }
        if (this.hfZ != null) {
            this.hfZ.onDestroy();
            this.hfZ = null;
        }
        if (this.hga != null) {
            this.hga.onDestroy();
        }
        if (this.hfJ != null) {
            this.hfJ.onDestroy();
        }
        if (this.hgk != null) {
            this.hgk.onDestroy();
            this.hgk = null;
        }
        if (this.hfX != null) {
            this.hfX.a((a.InterfaceC0193a) null);
            this.hfX.release();
            this.hfX = null;
        }
        if (this.hgb != null) {
            this.hgb.a((com.baidu.tieba.ala.liveroom.guideim.a) null);
            this.hgb.release();
        }
        if (this.hgc != null) {
            this.hgc.a(null);
            this.hgc.release();
        }
        if (this.hgd != null) {
            this.hgd.a((b.a) null);
            this.hgd.onDestroy();
        }
        if (this.hgi != null) {
            this.hgi.onDestroy();
        }
        if (this.hgj != null) {
            this.hgj.onDestroy();
        }
        if (this.hgg != null) {
            this.hgg.onDestory();
        }
        if (this.hgv != null) {
            this.hgv.onDestroy();
        }
        if (this.hgp != null) {
            this.hgp.onDestroy();
        }
        if (this.hgl != null) {
            this.hgl.release();
        }
        if (this.gTT != null) {
            this.gTT.release();
        }
        if (this.hgn != null) {
            this.hgn.release();
        }
        if (this.hgm != null) {
            this.hgm.release();
        }
        if (this.hgo != null) {
            this.hgo.release();
        }
        if (this.hfK != null) {
            this.hfK.onDestory();
        }
        if (this.hgz != null) {
            this.hgz.release();
        }
        if (this.hgq != null) {
            this.hgq.onDestroy();
        }
        if (this.hgs != null) {
            this.hgs.onDestroy();
        }
        if (this.hgr != null) {
            this.hgr.onDestroy();
        }
        if (this.heY != null) {
            this.heY.onDestroy();
        }
        if (this.hfO != null) {
            this.hfO.IB();
        }
        if (this.hgu != null) {
            this.hgu.onDestroy();
        }
        if (this.hgC != null) {
            this.hgC.onDestroy();
        }
        if (this.hgf != null) {
            this.hgf.onDestroy();
        }
        if (this.hgw != null) {
            this.hgw.onDestroy();
            b(this.hgw.QV());
            b(this.hgw.QW());
        }
        cbM();
        cbN();
        MessageManager.getInstance().unRegisterListener(this.hhd);
        MessageManager.getInstance().unRegisterListener(this.hhe);
        MessageManager.getInstance().unRegisterListener(this.hhf);
        MessageManager.getInstance().unRegisterListener(this.hhj);
        MessageManager.getInstance().unRegisterListener(this.hhk);
        MessageManager.getInstance().unRegisterListener(this.hhm);
        MessageManager.getInstance().unRegisterListener(this.hhg);
        MessageManager.getInstance().unRegisterListener(this.hhh);
        MessageManager.getInstance().unRegisterListener(this.gDt);
        MessageManager.getInstance().unRegisterListener(this.hhi);
        MessageManager.getInstance().unRegisterListener(this.gDG);
        MessageManager.getInstance().unRegisterListener(this.hhn);
        MessageManager.getInstance().unRegisterListener(this.notifyDialogDismissListener);
        MessageManager.getInstance().unRegisterListener(this.gNI);
        MessageManager.getInstance().unRegisterListener(this.gNF);
        MessageManager.getInstance().unRegisterListener(this.buq);
        MessageManager.getInstance().unRegisterListener(this.hho);
        MessageManager.getInstance().unRegisterListener(this.hhp);
        MessageManager.getInstance().unRegisterListener(this.hhq);
        MessageManager.getInstance().unRegisterListener(this.hht);
        MessageManager.getInstance().unRegisterListener(this.hhu);
        MessageManager.getInstance().unRegisterListener(this.gTU);
        MessageManager.getInstance().unRegisterListener(this.hhv);
        MessageManager.getInstance().unRegisterListener(this.hhr);
        MessageManager.getInstance().unRegisterListener(this.hhs);
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onPause() {
        if (this.hgb != null) {
            this.hgb.nK(false);
        }
        if (this.hgd != null) {
            this.hgd.nK(false);
        }
        caT();
        if (this.hgh != null) {
            this.hgh.onPause();
        }
        if (this.hgl != null) {
            this.hgl.pause();
        }
        if (this.gTT != null) {
            this.gTT.pause();
        }
        if (this.hgn != null) {
            this.hgn.pause();
        }
        if (this.hgk != null) {
            this.hgk.onPause();
        }
        if (this.hgu != null) {
            this.hgu.onPause();
        }
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.i
    public void onResume() {
        this.hgT = false;
        if (this.hgL && this.hgM != null) {
            a(this.hgM);
            this.hgL = false;
        }
        if (this.hgb != null) {
            this.hgb.nK(true);
        }
        if (this.hgd != null) {
            this.hgd.nK(true);
        }
        if (this.hgh != null) {
            this.hgh.onResume();
        }
        if (this.hgl != null) {
            this.hgl.resume();
        }
        if (this.gTT != null) {
            this.gTT.resume();
        }
        if (this.hgn != null) {
            this.hgn.resume();
        }
        if (this.hgk != null) {
            this.hgk.onResume();
        }
        if (this.hgu != null) {
            this.hgu.onResume();
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
        if (i == 4 && this.hgw != null && this.hgw.isOpen()) {
            this.hgw.onClose();
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
            cbt();
        } else if (i == 25043) {
            if (i2 == -1) {
                cbY();
            }
        } else if (i == 25052 && intent != null) {
            Log.i("ModifyNicknameHelper", "@@ ModifyNickname BaseScheduler onActivityResult isShowSuccess=" + intent.getBooleanExtra("isShowSuccess", false) + ", errorCode=" + intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0) + ", isModifySuccess=" + intent.getBooleanExtra("isModifySuccess", false));
            if (intent.getBooleanExtra("isShowSuccess", false) || (!intent.hasExtra("isShowSuccess") && intent.hasExtra("isModifySuccess"))) {
                try {
                    int intExtra = intent.getIntExtra(TiebaInitialize.LogFields.ERROR_CODE, 0);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("action", "show");
                    jSONObject.put(TiebaInitialize.LogFields.ERROR_CODE, intExtra);
                    com.baidu.live.p.a.G(cbX().pageContext.getPageActivity(), jSONObject.toString());
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
                    com.baidu.live.p.a.G(cbX().pageContext.getPageActivity(), jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.baidu.live.liveroom.f.a
    public void f(boolean z, int i) {
        this.hgK = z;
        if (this.hgD != null) {
            this.hgD.onKeyboardVisibilityChanged(z);
        }
        onKeyboardVisibilityChanged(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onKeyboardVisibilityChanged(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean cbW() {
        return (cbX().hpT.Iq() == null || cbX().hpT.Iq().mLiveInfo == null || cbX().hpT.Iq().mLiveInfo.live_type != 1) ? false : true;
    }

    @Override // com.baidu.live.liveroom.f.a
    public void l(int i, int i2, int i3) {
        if (this.mOrientation == i3) {
            if (this.hfL != null) {
                this.hfL.C(i, i2);
            }
        } else {
            this.mOrientation = i3;
        }
        if (this.hgd != null) {
            this.hgd.blq();
        }
        if (this.hfK != null) {
            this.hfK.blq();
        }
        if (this.hgw != null) {
            this.hgw.C(i, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.ala.liveroom.data.a aVar) {
        this.hfF = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public com.baidu.tieba.ala.liveroom.data.a cbX() {
        return this.hfF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbY() {
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
            if (caS() != null) {
                caS().setVisibility(8);
            }
        } else if (2 == i) {
            if (this.hgK) {
                return false;
            }
            return this.hfL == null || !this.hfL.cfK();
        } else if (3 == i) {
            if (cbX().hpU != null) {
                cbX().hpU.setEnabled(false);
                if (this.brc != null) {
                    this.brc.e(!cbX().hpW, false);
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
            cbX().hpU.setEnabled(true);
            if (this.brc != null) {
                this.brc.e(!cbX().hpW, true);
            }
            if (this.hfS != null) {
                this.hfS.cV(true);
            }
        } else if (2 == i && this.hfR != null) {
            this.hfR.on(true);
        }
    }

    public String Oj() {
        return this.otherParams;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
        if (this.hfX != null) {
            this.hfX.setOtherParams(str);
        }
        if (this.hgh != null) {
            this.hgh.ik(str);
        }
    }

    private boolean bWk() {
        return cbX().pageContext.getPageActivity().getRequestedOrientation() == 0;
    }

    @Override // com.baidu.live.liveroom.f.a, com.baidu.live.liveroom.middleware.d
    public final void f(List<com.baidu.live.im.data.b> list, boolean z) {
    }

    public void b(AlaLastLiveroomInfo alaLastLiveroomInfo) {
        this.giS = alaLastLiveroomInfo;
    }

    public void ck(View view) {
        if (view != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(cbX().pageContext.getPageActivity(), this.hgR);
            loadAnimation.setFillEnabled(true);
            loadAnimation.setFillAfter(true);
            view.setAnimation(loadAnimation);
        }
    }
}
