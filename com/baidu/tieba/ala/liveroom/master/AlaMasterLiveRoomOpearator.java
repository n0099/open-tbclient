package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.c.p;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.af;
import com.baidu.live.data.am;
import com.baidu.live.data.l;
import com.baidu.live.data.w;
import com.baidu.live.gift.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.r.a;
import com.baidu.live.t.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.atomdata.EditHeadActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.coreextra.data.PhotoUrlData;
import com.baidu.live.tbadk.img.ImageFileInfo;
import com.baidu.live.tbadk.img.WriteImagesInfo;
import com.baidu.live.tbadk.live.finish.FinishLiveManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.tbadk.share.single.interfaces.IShareCallback;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.utils.o;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.data.h;
import com.baidu.tieba.ala.liveroom.h.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.baidu.tieba.ala.liveroom.views.b;
import com.baidu.tieba.ala.liveroom.views.f;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String fbi;
    private List<af> asC;
    private String eKA;
    private com.baidu.live.g.a eLU;
    private c eML;
    private com.baidu.tieba.ala.liveroom.n.a eMM;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eMQ;
    private com.baidu.tieba.ala.liveroom.activeview.b eMS;
    private com.baidu.live.h.a eNC;
    private com.baidu.tieba.ala.liveroom.share.c eND;
    private com.baidu.tieba.ala.liveroom.q.b eNE;
    private com.baidu.tieba.ala.liveroom.guide.c eNF;
    private com.baidu.tieba.ala.liveroom.watermark.a eNG;
    private m eNN;
    private i eNO;
    private j eNP;
    private t eNQ;
    private r eNR;
    protected u eNS;
    protected com.baidu.tieba.ala.liveroom.g.a eOa;
    protected com.baidu.tieba.ala.liveroom.l.a eOb;
    protected com.baidu.live.i.a eOj;
    private com.baidu.live.n.a eOl;
    private ImageView ePs;
    private f eQi;
    private ImageView eQq;
    private g eQr;
    private RelativeLayout faN;
    private boolean faS;
    private ImageView fbA;
    private ImageView fbB;
    private ImageView fbC;
    private ImageView fbD;
    private ImageView fbE;
    private ImageView fbF;
    private ImageView fbG;
    private ImageView fbH;
    private View fbI;
    private ImageView fbJ;
    private TextView fbK;
    private FrameLayout fbL;
    private FrameLayout fbM;
    private w fbN;
    private com.baidu.live.u.a fbO;
    private com.baidu.tieba.ala.liveroom.master.panel.b fbP;
    private com.baidu.live.t.a fbQ;
    private e fbR;
    private boolean fbj;
    private d fbl;
    private com.baidu.tieba.ala.liveroom.n.a fbm;
    private com.baidu.tieba.ala.liveroom.f.c fbn;
    private com.baidu.tieba.ala.liveroom.b.a fbo;
    private com.baidu.tieba.ala.liveroom.u.a fbp;
    private com.baidu.tieba.ala.liveroom.x.a fbq;
    private b fbr;
    private com.baidu.tieba.ala.liveroom.tippop.a fbs;
    private AlaLiveCountDownView fbt;
    private AlaLiveStreamStatusView fbu;
    private com.baidu.tieba.ala.liveroom.views.b fbv;
    private RelativeLayout fbw;
    private RelativeLayout fbx;
    private RelativeLayout fby;
    private AlaLiveFaceVerifyView fbz;
    private short fcb;
    private com.baidu.tieba.ala.liveroom.h.b fcf;
    private boolean fcg;
    private boolean fch;
    private com.baidu.tieba.ala.liveroom.challenge.f fci;
    private com.baidu.live.b.a fck;
    private com.baidu.live.b.b fcl;
    private com.baidu.tieba.ala.liveroom.p.a fcm;
    private boolean fcn;
    private BdUniqueId fco;
    private boolean fcp;
    private boolean fbk = false;
    private boolean eOr = false;
    private Handler mHandler = new Handler();
    private boolean fbS = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver fbT = null;
    private boolean fbU = false;
    private int fbV = 0;
    private int fbW = 0;
    private int fbX = 0;
    private long fbY = 0;
    private long fbZ = 0;
    private volatile boolean isBackground = false;
    private Intent fca = null;
    private int mOrientation = 1;
    private boolean eWP = false;
    private boolean fcc = false;
    private boolean fcd = true;
    private boolean eQo = false;
    private boolean fce = true;
    private int bQZ = 0;
    public boolean fcj = false;
    private String otherParams = "";
    private Runnable fcq = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.eLU != null) {
                AlaMasterLiveRoomOpearator.this.eLU.qf();
            }
        }
    };
    private CustomMessageListener eOI = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.eNE == null) {
                AlaMasterLiveRoomOpearator.this.eNE = new com.baidu.tieba.ala.liveroom.q.b(AlaMasterLiveRoomOpearator.this.bio().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.eNE.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener eOP = new CustomMessageListener(2913149) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.eOj != null) {
                AlaMasterLiveRoomOpearator.this.eOj.uj();
            }
        }
    };
    private CustomMessageListener fcr = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                AlaMasterLiveRoomOpearator.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eOF = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.eQi.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.ys(str);
            }
        }
    };
    private CustomMessageListener eOG = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aFL();
        }
    };
    private CustomMessageListener ePf = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eNR instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) AlaMasterLiveRoomOpearator.this.eNR).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    private CustomMessageListener eON = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener fcs = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fcl != null) {
                l ww = AlaMasterLiveRoomOpearator.this.bio().eWr.ww();
                long j = ww.mLiveInfo.live_id;
                long j2 = ww.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.fcl.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener fct = new CustomMessageListener(2913162) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bio().eWs);
            if (AlaMasterLiveRoomOpearator.this.fbl == null || AlaMasterLiveRoomOpearator.this.fbl.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qh(0);
            }
            if (AlaMasterLiveRoomOpearator.this.eNO != null) {
                AlaMasterLiveRoomOpearator.this.eNO.uM().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.eNO.uN().hide();
            }
        }
    };
    private CustomMessageListener eOO = new CustomMessageListener(2913148) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.bio().eWr.ww());
        }
    };
    private CustomMessageListener eOQ = new CustomMessageListener(2913155) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eNS != null) {
                    ((com.baidu.tieba.ala.liveroom.p.b) AlaMasterLiveRoomOpearator.this.eNS).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fcu = new CustomMessageListener(2913156) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fcm != null) {
                    AlaMasterLiveRoomOpearator.this.fcm.yw(str);
                }
            }
        }
    };
    private CustomMessageListener fcv = new CustomMessageListener(2913145) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (AlaMasterLiveRoomOpearator.this.fcn) {
                        AlaMasterLiveRoomOpearator.this.bio().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.bio().eWS != null) {
                        AlaMasterLiveRoomOpearator.this.bio().eWS.setDefBeautyParams(data.Ua);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fcf != null) {
                        if (AlaMasterLiveRoomOpearator.this.fco != null && AlaMasterLiveRoomOpearator.this.fco == data.Uc) {
                            if (!AlaMasterLiveRoomOpearator.this.fcp || AlaMasterLiveRoomOpearator.this.fbl.getVisibility() == 0) {
                                AlaMasterLiveRoomOpearator.this.fcf.a(AlaMasterLiveRoomOpearator.this.bio().eWS.getVideoConfig());
                            }
                            AlaMasterLiveRoomOpearator.this.fco = null;
                            AlaMasterLiveRoomOpearator.this.fcf.a(AlaMasterLiveRoomOpearator.this.bio().eWS.getVideoConfig(), AlaMasterLiveRoomOpearator.this.fcg);
                            if (!AlaMasterLiveRoomOpearator.this.fcg) {
                                AlaMasterLiveRoomOpearator.this.fcg = true;
                            }
                        }
                        AlaMasterLiveRoomOpearator.this.fcf.bjI();
                    }
                }
                AlaMasterLiveRoomOpearator.this.fcn = false;
            }
        }
    };
    private View.OnClickListener fcw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.fbD) {
                    AlaMasterLiveRoomOpearator.this.blV();
                    AlaMasterLiveRoomOpearator.this.fbP.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.fbC) {
                    if (AlaMasterLiveRoomOpearator.this.eNO != null) {
                        AlaMasterLiveRoomOpearator.this.eNO.uN().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.fbE) {
                    AlaMasterLiveRoomOpearator.this.aFL();
                } else if (view != AlaMasterLiveRoomOpearator.this.fbF) {
                    if (view == AlaMasterLiveRoomOpearator.this.fbH) {
                        if (AlaMasterLiveRoomOpearator.this.fbQ != null) {
                            AlaMasterLiveRoomOpearator.this.fbQ.showDialog();
                            AlaMasterLiveRoomOpearator.this.fbQ.ba(AlaMasterLiveRoomOpearator.this.blZ());
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eQq) {
                        if (AlaMasterLiveRoomOpearator.this.fci != null) {
                            AlaMasterLiveRoomOpearator.this.fci.biq();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.fbG) {
                        if (AlaMasterLiveRoomOpearator.this.fbq != null) {
                            h bnQ = AlaMasterLiveRoomOpearator.this.bio().eWr.bnQ();
                            if (bnQ == null || bnQ.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(bnQ.mLiveSdkInfo.mRoomId);
                                if (bnQ.mLiveSdkInfo.mCastIds != null) {
                                    str2 = bnQ.mLiveSdkInfo.mCastIds.Wm;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.fbq.ad("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.fbJ) {
                        l ww = AlaMasterLiveRoomOpearator.this.bio().eWr.ww();
                        if (AlaMasterLiveRoomOpearator.this.eOa != null && ww != null && ww.mLiveInfo != null) {
                            String valueOf = String.valueOf(ww.mLiveInfo.live_id);
                            String valueOf2 = String.valueOf(ww.mLiveInfo.feed_id);
                            long j = ww.mLiveInfo.room_id;
                            String str3 = ww.mLiveInfo.cover;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (ww.mLiveInfo.session_info != null) {
                                str4 = ww.mLiveInfo.session_info.flvUrl;
                            }
                            if (!TextUtils.isEmpty(AlaMasterLiveRoomOpearator.this.otherParams)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(AlaMasterLiveRoomOpearator.this.otherParams);
                                    str5 = jSONObject.optString("tab");
                                    str6 = jSONObject.optString("tag");
                                    str7 = jSONObject.optString("source");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.eOa.yw(o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.fcp = false;
                    AlaMasterLiveRoomOpearator.this.jz(true);
                }
            }
        }
    };
    private CustomMessageListener eOH = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof w) {
                    AlaMasterLiveRoomOpearator.this.eOr = true;
                    AlaMasterLiveRoomOpearator.this.fbN = (w) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.fbv != null && AlaMasterLiveRoomOpearator.this.fbv.getView() != null && AlaMasterLiveRoomOpearator.this.fbv.getView().getParent() != null) {
                        AlaMasterLiveRoomOpearator.this.bio().rootView.removeView(AlaMasterLiveRoomOpearator.this.fbv.getView());
                        if (AlaMasterLiveRoomOpearator.this.eNO != null) {
                            AlaMasterLiveRoomOpearator.this.eNO.uM().getView().setVisibility(0);
                        }
                    }
                    if (AlaMasterLiveRoomOpearator.this.eNO != null) {
                        AlaMasterLiveRoomOpearator.this.eNO.uN().show();
                        AlaMasterLiveRoomOpearator.this.eNO.uN().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.qh(8);
                }
            }
        }
    };
    private CustomMessageListener fcx = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bio() != null && AlaMasterLiveRoomOpearator.this.bio().eWV != null) {
                AlaMasterLiveRoomOpearator.this.bio().eWV.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener faF = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bmJ();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bio().eWr.qp(i);
                if (AlaMasterLiveRoomOpearator.this.eOj != null) {
                    AlaMasterLiveRoomOpearator.this.eOj.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener eKK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bmC();
        }
    };
    public final HttpMessageListener fcy = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.wz()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.fbP != null) {
                            AlaMasterLiveRoomOpearator.this.fbP.jF(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.fbP.bnf();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bio().eWS.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.fbs != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.fbs.a(AlaMasterLiveRoomOpearator.this.bio().rootView, AlaMasterLiveRoomOpearator.this.bio().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bio().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.fbs.qw(2);
                        AlaMasterLiveRoomOpearator.this.fbs.a(AlaMasterLiveRoomOpearator.this.bio().rootView, string, 3);
                    }
                }
            }
        }
    };
    private b.a fcz = new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // com.baidu.tieba.ala.liveroom.views.b.a
        public void qi(int i) {
            com.baidu.live.c.oJ().putInt("live_beauty_level", i);
            AlaMasterLiveRoomOpearator.this.bio().eWS.setBeauty(i);
        }
    };
    private f.a fcA = new f.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void bmO() {
            AlaMasterLiveRoomOpearator.this.bmz();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void bmP() {
            AlaMasterLiveRoomOpearator.this.bmA();
        }
    };
    com.baidu.tieba.ala.liveroom.b fcB = new com.baidu.tieba.ala.liveroom.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        @Override // com.baidu.tieba.ala.liveroom.b
        public boolean pr(int i) {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void ps(int i) {
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void pt(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bio().bjW() == 1) {
                AlaMasterLiveRoomOpearator.this.bio().eWS.stopRecord();
            }
        }
    };
    private IShareCallback fcC = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.fbS && AlaMasterLiveRoomOpearator.this.fbR != null) {
                AlaMasterLiveRoomOpearator.this.fbS = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.fbR);
            }
        }
    };
    private View.OnTouchListener fcD = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bio().eWV.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bio().eWs);
            if (AlaMasterLiveRoomOpearator.this.fbv != null && AlaMasterLiveRoomOpearator.this.fbv.getView() != null && AlaMasterLiveRoomOpearator.this.fbv.getView().getParent() != null) {
                AlaMasterLiveRoomOpearator.this.bio().rootView.removeView(AlaMasterLiveRoomOpearator.this.fbv.getView());
                AlaMasterLiveRoomOpearator.this.qh(0);
                if (AlaMasterLiveRoomOpearator.this.eNO != null) {
                    AlaMasterLiveRoomOpearator.this.eNO.uM().getView().setVisibility(0);
                }
            }
            return false;
        }
    };
    private f.b fcE = new f.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void bmQ() {
            if (AlaMasterLiveRoomOpearator.this.bio() != null && AlaMasterLiveRoomOpearator.this.bio().eWr != null) {
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.bio().eWr.bnI();
                } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) {
                    AlaMasterLiveRoomOpearator.this.bio().eWr.bnJ();
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void bmR() {
            AlaMasterLiveRoomOpearator.this.faS = AlaMasterLiveRoomOpearator.this.fbl.bjO();
            AlaMasterLiveRoomOpearator.this.bio().eWV.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bio().eWV.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bio().eWV.sampleMemAndCPU();
            e eVar = new e();
            eVar.eWM = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bio().bjW();
            eVar.title = AlaMasterLiveRoomOpearator.this.fbl.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.eWN = AlaMasterLiveRoomOpearator.this.fbl.bjP();
            eVar.eWQ = AlaMasterLiveRoomOpearator.this.faS;
            eVar.eWP = AlaMasterLiveRoomOpearator.this.fbl.bjM();
            eVar.eWO = AlaMasterLiveRoomOpearator.this.fbl.bjR();
            eVar.eWR = AlaMasterLiveRoomOpearator.this.fbl.bjN();
            if (eVar.eWR) {
                if (AlaMasterLiveRoomOpearator.this.fbl.bjS()) {
                    AlaMasterLiveRoomOpearator.this.fbS = true;
                    AlaMasterLiveRoomOpearator.this.fbR = eVar;
                    AlaMasterLiveRoomOpearator.this.fbl.bjT();
                } else {
                    AlaMasterLiveRoomOpearator.this.c(eVar);
                }
                if (FinishLiveManager.getInstance().getFinishListener() != null) {
                    FinishLiveManager.getInstance().getFinishListener().onStartLive();
                }
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_END);
                    alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    return;
                }
                return;
            }
            AlaMasterLiveRoomOpearator.this.bio().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bio().d((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void bmS() {
            AlaMasterLiveRoomOpearator.this.fcp = true;
            AlaMasterLiveRoomOpearator.this.jz(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public boolean bmT() {
            if (AlaMasterLiveRoomOpearator.this.fbv == null || AlaMasterLiveRoomOpearator.this.fbv.getView() == null || AlaMasterLiveRoomOpearator.this.fbv.getView().getParent() == null) {
                return false;
            }
            AlaMasterLiveRoomOpearator.this.bio().rootView.removeView(AlaMasterLiveRoomOpearator.this.fbv.getView());
            return true;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void bmU() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void bmV() {
            o.k(AlaMasterLiveRoomOpearator.this.eQi.pageContext.getPageActivity(), "", "");
        }
    };
    private AlaLiveView.c fcF = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        boolean isShow = true;

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void bgQ() {
            if (AlaMasterLiveRoomOpearator.this.fbq != null) {
                AlaMasterLiveRoomOpearator.this.fbq.jP(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void iN(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.fci != null) {
                        AlaMasterLiveRoomOpearator.this.fci.d(AlaMasterLiveRoomOpearator.this.eQq);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fbQ != null) {
                        AlaMasterLiveRoomOpearator.this.fbQ.aZ(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.fci != null) {
                        AlaMasterLiveRoomOpearator.this.fci.bir();
                    }
                    if (AlaMasterLiveRoomOpearator.this.fbQ != null) {
                        AlaMasterLiveRoomOpearator.this.fbQ.aZ(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.fbq != null) {
                    AlaMasterLiveRoomOpearator.this.fbq.jP(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.eNS != null) {
                    AlaMasterLiveRoomOpearator.this.eNS.ay(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a fcG = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.fbz != null && AlaMasterLiveRoomOpearator.this.bio().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.fbz) >= 0) {
                AlaMasterLiveRoomOpearator.this.bio().rootView.removeView(AlaMasterLiveRoomOpearator.this.fbz);
                AlaMasterLiveRoomOpearator.this.fbz.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.fbz = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eNr = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            l ww;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bmI();
            } else if (i == 14 && (ww = AlaMasterLiveRoomOpearator.this.bio().eWr.ww()) != null && ww.Wf != null && ww.mLiveInfo != null && ww.Wt != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity(), ww.Wf.userName, Long.toString(ww.Wf.userId), Long.toString(ww.Wf.charmCount), String.valueOf(ww.mLiveInfo.group_id), String.valueOf(ww.mLiveInfo.live_id), true, String.valueOf(ww.Wf.userId), Long.toString(ww.Wt.userId), ww.Wt.userName, ww.Wt.portrait, AlaMasterLiveRoomOpearator.this.eMQ.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(ww.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.eMQ.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener fcH = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.fcj = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fdG;
            }
        }
    };
    private HttpMessageListener fcI = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.fbK.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.fbK.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.fbK.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.fbK.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.asC = getVideoGoodsListHttpResponseMessage.asC;
            }
        }
    };
    private HttpMessageListener fcJ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.asx != null && !eventPollingHttpResponseMessage.asx.isEmpty() && AlaMasterLiveRoomOpearator.this.bio().eWr != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.currentTime;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.asx.size()) {
                            break;
                        }
                        ae aeVar = eventPollingHttpResponseMessage.asx.get(i2);
                        if (j == aeVar.liveId && j2 - aeVar.createTime <= 60 && !com.baidu.live.utils.m.g(aeVar.liveId, aeVar.id)) {
                            com.baidu.live.utils.m.a(aeVar, AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo);
                            com.baidu.live.utils.m.h(aeVar.liveId, aeVar.id);
                        }
                        i = i2 + 1;
                    }
                    ae aeVar2 = eventPollingHttpResponseMessage.asx.get(eventPollingHttpResponseMessage.asx.size() - 1);
                    if (j == aeVar2.liveId) {
                        com.baidu.live.utils.m.f(aeVar2.liveId, aeVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.asw;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bio().eWr != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null && AlaMasterLiveRoomOpearator.this.bio().eWr != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                com.baidu.live.utils.m.i(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.TB);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        fbi = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(l lVar) {
        if (lVar != null && lVar.mLiveInfo != null && com.baidu.live.s.a.wR().asq != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bio().pageContext.getPageActivity(), String.valueOf(lVar.mLiveInfo.live_id), String.valueOf(lVar.mLiveInfo.user_id), com.baidu.live.s.a.wR().asq.Zb, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ys(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bio().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bio().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.s.a.wR().asq.Yz;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bio().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bio().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bio().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.fci != null) {
            this.fci.onPKPlayerFirstFrame();
        }
    }

    /* loaded from: classes2.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.fbU = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.fbU = false;
                }
                if (AlaMasterLiveRoomOpearator.this.fbV == 0) {
                    AlaMasterLiveRoomOpearator.this.fbV = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.fbW == 0) {
                    AlaMasterLiveRoomOpearator.this.fbW = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.fbX = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(e eVar) {
        if (bio() != null && bio().eWT != null) {
            bio().eWT.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.f fVar, String str) {
        this.eQi = fVar;
        this.eKA = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.f bio() {
        return this.eQi;
    }

    public int a(g gVar) {
        this.eQr = gVar;
        this.fbT = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.fbT, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.fbs == null) {
            this.fbs = new com.baidu.tieba.ala.liveroom.tippop.a(this.eQi.pageContext, null);
        }
        registerListener();
        this.eLU = new com.baidu.live.g.a();
        bmk();
        Long[] lArr = new Long[1];
        this.fbY = lArr[0] == null ? 0L : lArr[0].longValue();
        this.fbZ = lArr[0] != null ? lArr[0].longValue() : 0L;
        bio().eWs.setOnTouchListener(this.fcD);
        this.fbj = SharedPrefHelper.getInstance().getBoolean(fbi, false);
        this.fbt = new AlaLiveCountDownView(bio().pageContext.getPageActivity());
        this.fbt.setCount(3);
        this.fbt.setTextColor(bio().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.fbt.setTextSize(bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.fbt.setTypeface(Typeface.DEFAULT_BOLD);
        this.fbt.setIncludeFontPadding(false);
        this.fbt.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bmW() {
                if (AlaMasterLiveRoomOpearator.this.bio().eWs != null) {
                    AlaMasterLiveRoomOpearator.this.bio().eWs.removeView(AlaMasterLiveRoomOpearator.this.fbt);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blV() {
        if (this.fbP == null) {
            this.fbP = new com.baidu.tieba.ala.liveroom.master.panel.b(bio().pageContext.getPageActivity(), bio().bjW() == 2);
            this.fbP.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bio().eWS.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jB(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bio().eWS.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jC(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bio().eWS.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bmH();
                    if (AlaMasterLiveRoomOpearator.this.fbs != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.fbs.a(AlaMasterLiveRoomOpearator.this.bio().rootView, AlaMasterLiveRoomOpearator.this.bio().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.fbs.a(AlaMasterLiveRoomOpearator.this.bio().rootView, AlaMasterLiveRoomOpearator.this.bio().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jD(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bmX() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bio().eWr != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bmY() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bio().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bmZ() {
                    if (AlaMasterLiveRoomOpearator.this.bio() != null && AlaMasterLiveRoomOpearator.this.bio().eWr != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.bio().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.fbP != null) {
                            AlaMasterLiveRoomOpearator.this.fbP.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bna() {
                    long j = (AlaMasterLiveRoomOpearator.this.bio() == null || AlaMasterLiveRoomOpearator.this.bio().eWr == null || AlaMasterLiveRoomOpearator.this.bio().eWr.ww() == null || AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bio() != null && AlaMasterLiveRoomOpearator.this.bio().eWr != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.eQi.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.fbP != null) {
                                        AlaMasterLiveRoomOpearator.this.fbP.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.eQi.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.fbP != null) {
                        AlaMasterLiveRoomOpearator.this.fbP.dismiss();
                    }
                }
            });
        }
        blW();
    }

    private void blW() {
        if (this.fbP != null) {
            boolean isBackCamera = bio().eWS.isBackCamera();
            this.fbP.jE(bio().eWS.isBackCamera());
            this.fbP.D(bio().eWS.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bio().eWS.isPushMirror();
            if (this.fcd) {
                isPushMirror = bmG() || isPushMirror;
                this.fcd = false;
            }
            this.fbP.E(isPushMirror, isBackCamera ? false : true);
            this.fbP.jF(bio().eWS.isMute());
            this.fbP.bnf();
        }
    }

    public void blX() {
        if (this.eQr != null) {
            if (this.eQr.eWX == null || this.eQr.eWX.mLiveInfo == null) {
                if (this.fbl == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bio().eWr != null && bio().eWr.ww() != null && bio().eWr.ww().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bio().eWr.ww().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bio().eWr.ww().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.fbl = new d(bio().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bio().eWV.prepareTime = System.currentTimeMillis();
                    bio().rootView.addView(this.fbl.getView(), layoutParams);
                    this.fbl.a(this.fcC);
                }
                this.fbl.jk(this.eWP);
                this.fbl.a(this.fcE);
                this.fbl.a(this.fcA);
                this.fbl.a(bio().eWS, bio().bjW());
                return;
            }
            this.faS = this.eQr.eWX.mLiveInfo.screen_direction == 2;
            if (this.eQr.eWX.mLiveInfo.isAudioOnPrivate == 1) {
                bio().eWS.setMute(true);
                if (this.fbs == null) {
                    this.fbs = new com.baidu.tieba.ala.liveroom.tippop.a(this.eQi.pageContext, null);
                }
                if (!this.fbs.qv(2)) {
                    this.fbs.a(bio().rootView, bio().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            e eVar = new e();
            eVar.eWM = true;
            eVar.forumId = String.valueOf(this.eQr.eWX.mLiveInfo.forum_id);
            eVar.forumName = this.eQr.eWX.mLiveInfo.forum_name;
            eVar.liveType = this.eQr.eWX.mLiveInfo.live_type;
            eVar.title = this.eQr.eWX.mLiveInfo.getLiveTitle();
            eVar.clarity = this.eQr.eWX.mLiveInfo.clarity;
            eVar.gameId = this.eQr.eWX.mLiveInfo.game_id;
            eVar.gameName = this.eQr.eWX.mLiveInfo.game_label;
            eVar.eWQ = this.eQr.eWX.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void blY() {
        if (this.fcf != null) {
            this.fcf.a(bio().eWS.getVideoConfig(), false);
            this.fcf.bjI();
        }
        if (this.fbl != null) {
            this.fbl.jj(true);
        }
        if (bio().eWS.hasBeauty() >= 0) {
            bio().eWS.setBeauty(com.baidu.live.c.oJ().getInt("live_beauty_level", 3));
        }
    }

    public void d(e eVar) {
        bmp();
        bmF();
        if (bio().bjW() == 2) {
            this.fbF.setVisibility(8);
            if (this.fbq != null) {
                this.fbq.jP(false);
            }
            if (this.eNO != null && this.eNO.uM() != null) {
                this.eNO.uM().setNeedTopAlphaShade(false);
                return;
            }
            return;
        }
        this.fbq = new com.baidu.tieba.ala.liveroom.x.a(bio().pageContext, this.fcB);
        this.fbq.d(bio().eWs, true);
        this.fbq.jP(true);
        bio().eWS.setPushMirror(bmG());
        if (this.eNO != null && this.eNO.uM() != null) {
            this.eNO.uM().setNeedTopAlphaShade(true);
        }
    }

    public void b(h hVar) {
        boolean z;
        int startPush;
        if (!bio().eWS.isBackground() && bio().eWr.ww() != null && bio().eWr.ww().mLiveInfo != null && (startPush = bio().eWS.startPush(bio().eWr.ww().mLiveInfo.getPushUrl())) != 0 && bio().eWV != null) {
            bio().eWV.errCode = 4;
            bio().eWV.errSubReason = startPush;
        }
        if (hVar != null && !hVar.bkb() && !bmD()) {
            jA(true);
            bmE();
        }
        if (this.fbn != null) {
            this.fbn.l(bio().eWr.ww());
        }
        if (this.eMM != null) {
            this.eMM.p(bio().eWr.ww());
        }
        if (this.eNC != null) {
            this.eNC.a(bio().eWr.ww());
        }
        if (this.fbo != null && bio() != null && bio().eWr != null) {
            if (this.fbo.ae(bio().eWs)) {
                this.fbo.j(bio().eWr.ww());
            } else {
                this.fbo.b(bio().eWs, bio().eWr.ww());
            }
        }
        if (this.fbm != null) {
            this.fbm.p(bio().eWr.ww());
        }
        if (hVar == null || hVar.Wf == null) {
            z = com.baidu.live.c.oJ().getBoolean("ala_master_can_use_challenge", false);
        } else {
            z = hVar.Wf.canUseChallenge;
            com.baidu.live.c.oJ().putBoolean("ala_master_can_use_challenge", z);
        }
        bmq();
        bmc();
        jx(z);
        e(bio().eWr.ww());
        bmr();
        bmw();
        bha();
        bho();
        q(bio().eWr.ww());
        bmx();
        bmy();
        bmu();
        bhc();
        bhj();
        bhk();
        if (this.eNN != null) {
            this.eNN.f(bio().eWr.ww());
        }
        if (this.eNO != null) {
            this.eNO.e(String.valueOf(bio().eWr.ww().mLiveInfo.group_id), String.valueOf(bio().eWr.ww().mLiveInfo.last_msg_id), String.valueOf(bio().eWr.ww().Wf.userId), String.valueOf(bio().eWr.ww().mLiveInfo.live_id), bio().eWr.ww().Wf.appId);
        }
        if (this.eNP != null) {
            this.eNP.a(bio().eWr.ww(), true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
            com.baidu.live.utils.m.i(bio().eWr.ww().mLiveInfo.user_id, bio().eWr.ww().mLiveInfo.live_id);
        }
        this.mHandler.post(this.fcq);
    }

    private void jx(boolean z) {
        if (this.fci == null) {
            this.fci = new com.baidu.tieba.ala.liveroom.challenge.f(bio());
        }
        this.fci.a(this.eQq, this.eQr);
        this.fci.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ac acVar, ad adVar, ad adVar2) {
                if (AlaMasterLiveRoomOpearator.this.eNG != null) {
                    AlaMasterLiveRoomOpearator.this.eNG.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bio().eWs.fkh = false;
                AlaMasterLiveRoomOpearator.this.bma();
                if (AlaMasterLiveRoomOpearator.this.eOl != null) {
                    AlaMasterLiveRoomOpearator.this.eOl.b(AlaMasterLiveRoomOpearator.this.jy(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void pg() {
                if (AlaMasterLiveRoomOpearator.this.eMS != null) {
                    AlaMasterLiveRoomOpearator.this.eMS.iE(true);
                    AlaMasterLiveRoomOpearator.this.eMS.setVisible(8);
                }
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fcq);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bim() {
                if (AlaMasterLiveRoomOpearator.this.eNG != null) {
                    AlaMasterLiveRoomOpearator.this.eNG.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bio().eWs.fkh = true;
                AlaMasterLiveRoomOpearator.this.bmb();
                if (AlaMasterLiveRoomOpearator.this.eOl != null) {
                    AlaMasterLiveRoomOpearator.this.eOl.b(AlaMasterLiveRoomOpearator.this.jy(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bin() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fcq);
            }
        });
        this.fci.A(this.faS, z);
        this.fci.h(this.faS, z, (this.eQr == null || this.eQr.eWX == null || this.eQr.eWX.mChallengeData == null) ? false : true);
    }

    public boolean blZ() {
        return this.fci != null && this.fci.bit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bma() {
        if (this.fbr != null) {
            this.fbr.setVisible(8);
            this.fbr.setCanVisible(false);
        }
        if (this.eMS != null) {
            this.eMS.iE(true);
            this.eMS.setVisible(8);
        }
        if (this.fbu != null) {
            this.fbu.setCanVisible(false);
            this.fbu.setVisibility(4);
        }
        if (this.fbq != null) {
            this.fbq.jO(false);
        }
        if (this.eNO != null) {
            this.eNO.uM().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmb() {
        if (this.fbr != null) {
            this.fbr.setCanVisible(true);
        }
        if (this.eMS != null) {
            this.eMS.iE(false);
            this.eMS.setVisible(0);
        }
        if (this.fbu != null) {
            this.fbu.setCanVisible(true);
        }
        if (this.fbq != null) {
            this.fbq.jO(true);
        }
        if (this.eNO != null) {
            this.eNO.uM().setNeedTopAlphaShade(false);
        }
    }

    private void bmc() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.fbu == null) {
            this.fbu = new AlaLiveStreamStatusView(bio().pageContext.getPageActivity());
        }
        this.fbu.setId(a.g.ala_live_room_stream_view);
        this.fbu.setVisibility(4);
        this.fbu.setLayoutParams(layoutParams);
        if (this.fbu.getParent() == null) {
            bio().eWs.addView(this.fbu, layoutParams);
        }
    }

    public void bmd() {
        if (this.fbl != null && this.fbl.getVisibility() != 8 && bio().eWS.getPreview() != null) {
            bio().eWS.stopRecord();
        }
    }

    public void bme() {
        if (bio().eWS.getPreview() != null) {
            bio().eWS.stopRecord();
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fcf != null) {
                this.fcf.ji(false);
            }
            this.fcf = new com.baidu.tieba.ala.liveroom.h.b(bio().rootView, bio(), bio().eWS);
            this.fcf.a(bio().eWS.getVideoConfig(), false);
            this.fcf.bjI();
            if (i3 == 2 || i3 == 1) {
            }
        }
        if (this.fbs != null) {
            this.fbs.boS();
        }
        this.mHandler.post(this.fcq);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fbk = z;
        if (z) {
            Rect rect = new Rect();
            bio().eWs.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            bio().eWs.getGlobalVisibleRect(rect2);
            if (this.eNO != null && this.eNO.uM() != null) {
                this.eNO.uM().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eNO.uM().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.eNO.uM().getView().setLayoutParams(layoutParams);
            }
            if (this.eNO != null && this.eNO.uN() != null) {
                int i = rect2.bottom - rect.bottom;
                this.eNO.uN().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eNO.uN().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.eNO.uN().getView().setLayoutParams(layoutParams2);
                this.eNO.uN().getView().setVisibility(0);
            }
            qh(8);
            qg(8);
        } else {
            if (this.eNO != null && this.eNO.uM() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eNO.uM().getView().getLayoutParams();
                layoutParams3.bottomMargin = bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.eNO.uM().getView().setLayoutParams(layoutParams3);
            }
            if (this.eNO != null && this.eNO.uN() != null) {
                this.eNO.uN().hide();
            }
            qh(0);
            qg(0);
        }
        if (this.fbl != null) {
            this.fbl.C(false, z);
        }
        if (this.eNP != null) {
            this.eNP.uU();
        }
        if (this.fbQ != null) {
            this.fbQ.onKeyboardVisibilityChanged(z);
        }
        if (this.eNO != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bio().pageContext.getPageActivity())) + bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (bio().eWs.indexOfChild(this.eNO.uM().getView()) != -1 && this.eNO.uM().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eNO.uM().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.eNO.uM().getView().setLayoutParams(layoutParams4);
            }
            this.eNO.uM().uL();
        }
        this.mHandler.post(this.fcq);
    }

    private void qg(int i) {
        if (this.eMM != null) {
            this.eMM.pT(i);
        }
        if (this.faN != null) {
            this.faN.setVisibility(i);
        }
        if (this.eNC != null) {
            this.eNC.getView().setVisibility(i);
        }
        if (this.fbp != null) {
            this.fbp.setVisible(i);
        }
        if (this.fbo != null) {
            this.fbo.setVisibility(i);
        }
        if (this.eMS != null) {
            this.eMS.setVisible(i);
        }
        if (this.eOl != null) {
            this.eOl.setCanVisible(i == 0);
        }
        if (this.eOb != null) {
            this.eOb.setVisible(i);
        }
        if (this.eOj != null) {
            this.eOj.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bio().eWV.errCode = 1;
            bmz();
        } else if (i == -5) {
            bmA();
        } else if (i == -2) {
            yM(bio().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bio().eWS.stopRecord();
        } else if (i == -3 && this.fbl != null) {
            this.fbl.jj(false);
        }
        if (i == -4) {
            if (this.fbl == null || this.fbl.getView().getParent() == null) {
                bio().d((short) 1);
                return;
            }
            this.fbl.bjQ();
            this.fbF.setVisibility(0);
            if (this.fbq != null) {
                this.fbq.jP(true);
            }
            bio().eWs.setBackgroundColor(bio().pageContext.getResources().getColor(17170445));
            bmM();
        } else if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bhC();
        if (i == 12001) {
            if (i2 == -1) {
                yN(ac(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                ad(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aFL();
        }
    }

    public void onResume() {
        if (this.fbl != null) {
            this.fbl.onResume();
        }
        if (this.fbS && this.fbR != null) {
            this.fbS = false;
            c(this.fbR);
        }
        if (this.eNS != null) {
            this.eNS.onResume();
        }
    }

    public void e(short s) {
        if (this.eNN != null) {
            this.eNN.tz();
        }
        if (this.eNO != null) {
            this.eNO.a(null);
            this.eNO.us();
        }
        if (this.eNP != null) {
            this.eNP.us();
        }
        if (this.fci != null) {
            this.fci.bis();
        }
    }

    public boolean bmf() {
        l ww = bio().eWr.ww();
        if (this.eNC != null) {
            this.eNC.a(bio().eWr.ww());
        }
        if (this.eNO != null) {
            this.eNO.uM().a(String.valueOf(ww.mLiveInfo.group_id), String.valueOf(ww.mLiveInfo.live_id), true, String.valueOf(ww.Wf.userId));
        }
        if (this.eNP != null) {
            this.eNP.a(ww);
        }
        if (this.eMM != null) {
            this.eMM.p(ww);
        }
        if (ww != null) {
            if (this.fbn != null) {
                this.fbn.l(ww);
            }
            if (this.fci != null) {
                this.fci.a(ww);
            }
            if (this.eNR != null && ww.mLiveInfo != null) {
                this.eNR.a(ww.mLiveInfo);
            }
            if (this.eMS != null) {
                this.eMS.g(ww);
            }
            if (this.eOl != null) {
                this.eOl.h(ww);
            }
            if (this.eOj != null) {
                this.eOj.a(ww);
            }
            if (ww.mLiveInfo.live_status != 1) {
                bmK();
                bio().pageContext.getPageActivity().finish();
                if (bio().eWr != null && bio().eWr.ww() != null) {
                    String str = null;
                    if (bio().eWr.boa() != 1) {
                        str = bio().pageContext.getString(a.i.ala_live_end_authen_msg);
                    }
                    a(ww.mLiveInfo, 1, str);
                }
                return true;
            } else if (this.fcj) {
                this.fbI.setVisibility(0);
                if (this.fch || ww.mLiveInfo == null) {
                    return false;
                }
                this.fch = true;
                o.g(ww.mLiveInfo.feed_id, ww.mLiveInfo.live_id);
                return false;
            } else {
                this.fbI.setVisibility(8);
                return false;
            }
        }
        return false;
    }

    public void bmg() {
        blW();
    }

    public void bmh() {
        if (this.fcf != null) {
            this.fcf.bjJ();
        }
    }

    public void bmi() {
        if (this.fbl != null && this.fbl.getVisibility() != 8) {
            if (bio().bjW() == 2) {
                bmM();
            } else {
                bmL();
            }
        }
        if (this.fbl != null && this.fbl.getVisibility() != 8) {
            if (bio().bjW() == 1) {
                this.fbl.onResume();
            }
            this.fbl.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.eOr && this.fbN != null) {
            if (this.fbv != null && this.fbv.getView() != null && this.fbv.getView().getParent() != null) {
                bio().rootView.removeView(this.fbv.getView());
                if (this.eNO != null) {
                    this.eNO.uM().getView().setVisibility(0);
                }
            }
            if (this.eNO != null) {
                this.eNO.uN().show();
                this.eNO.uN().setEditText(" @" + this.fbN.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            qh(8);
            this.eOr = false;
        }
        if (this.eOa != null) {
            this.eOa.resume();
        }
        if (this.fcl != null) {
            this.fcl.resume();
        }
        if (this.fcm != null) {
            this.fcm.resume();
        }
    }

    public void onPause() {
        if (this.eOa != null) {
            this.eOa.pause();
        }
        if (this.fcl != null) {
            this.fcl.pause();
        }
        if (this.eNS != null) {
            this.eNS.onPause();
        }
        if (this.fcm != null) {
            this.fcm.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmj() {
        bio().eWs.scrollOrigin();
    }

    private void bmk() {
        this.fbw = (RelativeLayout) bio().rootView.findViewById(a.g.ala_live_unremovable_host_top);
        this.faN = (RelativeLayout) bio().rootView.findViewById(a.g.ala_live_removeable_top_container);
        this.fbx = (RelativeLayout) bio().rootView.findViewById(a.g.under_live_view_panel);
        this.fby = (RelativeLayout) bio().rootView.findViewById(a.g.over_live_view_panel);
        this.eQi.eWs.setOnLiveViewScrollListener(this.fcF);
        if (this.eMQ == null) {
            this.eMQ = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.eQi.pageContext.getPageActivity(), false);
        }
        this.eMQ.a(this.eNr);
        this.eMQ.a(this.faN, a.g.ala_live_room_host_header_stub, 1L);
        this.eMQ.setVisible(0);
        this.fbA = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_close);
        this.fbA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.bmI();
            }
        });
        this.fbL = (FrameLayout) bio().rootView.findViewById(a.g.ala_liveroom_host_pure_back_btn_layout);
        this.fbM = (FrameLayout) bio().rootView.findViewById(a.g.ala_liveroom_host_close_btn_layout);
        this.fbB = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_pure_mode_back);
        this.fbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.bmj();
            }
        });
        this.fbF = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.fbF.setOnClickListener(this.fcw);
        this.fbH = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.fbH.setOnClickListener(this.fcw);
        if (com.baidu.live.s.a.wR().atk != null && com.baidu.live.s.a.wR().atk.aaS != null && com.baidu.live.s.a.wR().atk.aaS.pX()) {
            this.fbH.setVisibility(0);
        } else {
            this.fbH.setVisibility(8);
        }
        if (am.c(com.baidu.live.s.a.wR().atk)) {
            this.fbF.setVisibility(0);
            if (am.c(com.baidu.live.s.a.wR().atk)) {
                this.fbF.setAlpha(0.2f);
            }
        } else if (bio().eWS.hasBeauty() < 0) {
            this.fbF.setVisibility(8);
        } else {
            if (am.c(com.baidu.live.s.a.wR().atk)) {
                this.fbF.setAlpha(0.2f);
            }
            this.fbv = new com.baidu.tieba.ala.liveroom.views.b(bio().pageContext.getPageActivity(), com.baidu.live.c.oJ().getInt("live_beauty_level", 3));
            this.fbv.a(this.fcz);
        }
        this.fbE = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.fbE.setOnClickListener(this.fcw);
        this.fbC = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.fbC.setOnClickListener(this.fcw);
        this.eQq = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.eQq.setOnClickListener(this.fcw);
        this.fbD = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.fbD.setOnClickListener(this.fcw);
        this.fbG = (ImageView) bio().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.fbG.setOnClickListener(this.fcw);
        this.fbI = bio().rootView.findViewById(a.g.host_goods_layout);
        this.fbJ = (ImageView) bio().rootView.findViewById(a.g.host_goods_imageView);
        this.fbK = (TextView) bio().rootView.findViewById(a.g.host_goods_num_textView);
        this.fbJ.setOnClickListener(this.fcw);
        bmo();
        bmn();
        this.fcf = new com.baidu.tieba.ala.liveroom.h.b(bio().rootView, bio(), bio().eWS);
        this.eNN = new m();
        bml();
        bmm();
        if (this.eNQ != null && this.eNQ.rj() != null) {
            this.eNQ.rj().bringToFront();
        }
    }

    private void bml() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, bio().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eNO = (i) runTask.getData();
            this.eNO.setFromMaster(true);
            this.eNO.uM().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bio().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(bio().pageContext.getPageActivity()) * 0.27f)) + bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            bio().eWs.addView(this.eNO.uM().getView(), layoutParams);
            this.eNO.uN().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bio().eWs.addView(this.eNO.uN().getView(), layoutParams2);
            this.eNO.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
                @Override // com.baidu.live.im.i.a
                public boolean uO() {
                    return true;
                }

                @Override // com.baidu.live.im.i.a
                public void uP() {
                }

                @Override // com.baidu.live.im.i.a
                public void dB(String str) {
                }

                @Override // com.baidu.live.im.i.a
                public void uQ() {
                }

                @Override // com.baidu.live.im.i.a
                public void uR() {
                }

                @Override // com.baidu.live.im.i.a
                public boolean uS() {
                    return false;
                }
            });
        }
    }

    private void bmm() {
        this.eNP = new com.baidu.tieba.ala.liveroom.e.a(bio().pageContext);
        View uT = this.eNP.uT();
        if (uT != null && this.eQi.eWs.indexOfChild(uT) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.eQi.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bio().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bio().eWs.addView(uT, layoutParams);
        }
    }

    private void bmn() {
        CustomResponsedMessage runTask;
        if (this.fbO == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.u.a.class, bio().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fbO = (com.baidu.live.u.a) runTask.getData();
        }
    }

    private void bmo() {
        View rj;
        s.b(bio().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.adF = true;
        fVar.context = bio().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, t.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.eNQ = (t) runTask.getData();
            if (this.eNQ != null && (rj = this.eNQ.rj()) != null && bio().eWs.indexOfChild(rj) < 0) {
                if (rj.getParent() instanceof ViewGroup) {
                    ((ViewGroup) rj.getParent()).removeView(rj);
                }
                bio().eWs.addView(rj, bio().eWs.getLayoutParams());
            }
        }
    }

    protected void bhk() {
        View rB;
        if (this.eNR == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.adF = true;
            aVar.context = bio().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, r.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eNR = (r) runTask.getData();
            }
        }
        if (this.eNR != null && (rB = this.eNR.rB()) != null) {
            if (bio().eWs.indexOfChild(rB) < 0) {
                if (rB.getParent() instanceof ViewGroup) {
                    ((ViewGroup) rB.getParent()).removeView(rB);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bio().eWs.addView(rB, layoutParams);
            }
            rB.bringToFront();
        }
    }

    protected void bhj() {
        View rD;
        if (this.eNS == null) {
            v vVar = new v();
            vVar.adF = true;
            vVar.pageContext = bio().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913154, u.class, vVar);
            if (runTask != null && runTask.getData() != null) {
                this.eNS = (u) runTask.getData();
            }
        }
        if (this.eNS != null && (rD = this.eNS.rD()) != null && bio().eWs.indexOfChild(rD) < 0) {
            if (rD.getParent() instanceof ViewGroup) {
                ((ViewGroup) rD.getParent()).removeView(rD);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bio().eWs.addView(rD, layoutParams);
        }
    }

    private void bmp() {
        bmt();
        bgk();
        bms();
        bio().eWs.setVisibility(0);
        qh(0);
    }

    private void bmq() {
        if (this.fbp == null) {
            this.fbp = new com.baidu.tieba.ala.liveroom.u.a(bio().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.fbp.a(bio().bjW(), j, TbadkCoreApplication.getCurrentAccountName(), true, bio().eWr.ww().Wf.portrait, this.otherParams, "", -1L);
        this.fbp.ad(bio().eWs);
    }

    private void bmr() {
        if (this.fbQ == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.t.a.class, bio().pageContext.getPageActivity());
            if (runTask != null) {
                this.fbQ = (com.baidu.live.t.a) runTask.getData();
            }
            if (this.fbQ != null) {
                this.fbQ.g(this.fbx);
                this.fbQ.h(this.fby);
                this.fbQ.bS((bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.eNG != null) {
                    this.fbQ.bR(this.eNG.bpL());
                }
                this.fbQ.i(bio().eWs);
                this.fbQ.a(this.eLU);
                this.fbQ.i(bio().eWr.ww());
                this.fbQ.a(this.eMS);
                this.fbQ.a(new a.InterfaceC0087a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                });
            }
        }
    }

    private void bms() {
        if (this.fbr == null) {
            this.fbr = new b(bio().pageContext, bio().eWs);
        }
    }

    private void bmt() {
        if (this.eMM == null) {
            this.eMM = new com.baidu.tieba.ala.liveroom.n.a(bio().pageContext, true, this.fcB);
            this.eMM.d(this.fbw, null);
            this.eMM.a(this.eNr);
        }
        if (this.fbm == null) {
            this.fbm = new com.baidu.tieba.ala.liveroom.n.a(bio().pageContext, true, null);
            this.fbm.a(this.faN, null, a.g.ala_live_room_host_header_stub);
            this.fbm.blo();
        }
    }

    protected void bgT() {
        CustomResponsedMessage runTask;
        boolean z = false;
        h bnQ = bio().eWr.bnQ();
        boolean z2 = com.baidu.live.s.a.wR().asq.Za;
        if (bnQ == null || bnQ.WC) {
            z = z2;
        }
        if (z && this.eNC == null && (runTask = MessageManager.getInstance().runTask(2913147, com.baidu.live.h.a.class, bio().pageContext)) != null) {
            this.eNC = (com.baidu.live.h.a) runTask.getData();
            if (this.eNC != null) {
                this.eNC.setIsHost(true);
                this.eNC.bJ(1);
                View view = this.eNC.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bio().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bio().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.faN.addView(view, layoutParams);
                }
            }
        }
    }

    private void e(l lVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.eMS == null) {
            this.eMS = new com.baidu.tieba.ala.liveroom.activeview.b(bio().pageContext);
        }
        this.eMS.setOtherParams(this.otherParams);
        this.eMS.b(lVar, false);
        this.eMS.setHost(true);
        this.eMS.a(1, bio().eWs, pI(1));
        this.eMS.a(2, bio().eWs, pI(2));
        this.eMS.setVisible(this.fbk ? 8 : 0);
        this.eMS.a(this.eLU);
        if (this.eLU != null) {
            if (this.eMS != null) {
                alaActiveRootView2 = this.eMS.pD(1);
                alaActiveRootView = this.eMS.pD(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.eLU.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.eLU.a(alaActiveRootView);
            }
        }
    }

    private void q(l lVar) {
        CustomResponsedMessage runTask;
        if (this.eOl == null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bio().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.n.a)) {
            this.eOl = (com.baidu.live.n.a) runTask.getData();
            if (this.eOl != null) {
                this.eOl.a(bio().eWs, jy(false));
            }
        }
        if (this.eOl != null) {
            this.eOl.h(lVar);
            this.eOl.setCanVisible(!this.fbk);
        }
    }

    protected void bmu() {
        CustomResponsedMessage runTask;
        if (bio() != null && (runTask = MessageManager.getInstance().runTask(2913144, com.baidu.live.i.a.class, bio().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eOj = (com.baidu.live.i.a) runTask.getData();
            this.eOj.a(bio().eWs, bmv());
            if (bio().eWr != null) {
                this.eOj.a(bio().eWr.ww());
            }
            this.eOj.setCanVisible(true);
            this.eOj.aM(false);
            this.eOj.a(bio().eWr.bbH());
        }
    }

    private void bhc() {
        this.fcm = new com.baidu.tieba.ala.liveroom.p.c(bio().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bmv() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bio().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.fbu != null) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams pI(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bio().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.fbu != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bio().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup.LayoutParams jy(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bio().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.fci != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.fci.ar(true) + bio().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fbu != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void bgk() {
        if (this.fbo == null) {
            this.fbo = new com.baidu.tieba.ala.liveroom.b.a(bio().pageContext, true);
        }
    }

    private void bmw() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bio().pageContext.getPageActivity();
            this.ePs = new ImageView(pageActivity);
            this.ePs.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.ePs.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.ePs.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bio().rootView.addView(this.ePs, layoutParams);
            this.ePs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bmI();
                }
            });
            this.ePs.setVisibility(8);
        }
    }

    private void bha() {
        this.eOa = new com.baidu.tieba.ala.liveroom.g.a(bio().pageContext);
    }

    private void bho() {
        if (this.eOb == null) {
            this.eOb = new com.baidu.tieba.ala.liveroom.l.a(bio().pageContext, true, this.otherParams);
        }
        if (bio().eWr.ww() != null && bio().eWr.ww().Wf != null && bio().eWr.ww().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.eOb.a(bio().eWs, layoutParams, bio().eWr.ww());
        }
    }

    private void bmx() {
        CustomResponsedMessage runTask;
        if (this.fck == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bio().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.fck = (com.baidu.live.b.a) runTask.getData();
            if (this.fck != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bio().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fck.a(bio().eWs, layoutParams);
            }
        }
        if (this.fck != null) {
            this.fck.a(bio().eWr.ww());
        }
    }

    private void bmy() {
        CustomResponsedMessage runTask;
        if (this.fcl == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bio().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.fcl = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fci != null) {
            this.fci.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bio().pageContext.registerListener(this.eOF);
        bio().pageContext.registerListener(this.fcr);
        bio().pageContext.registerListener(this.eOH);
        bio().pageContext.registerListener(this.eOI);
        bio().pageContext.registerListener(this.fcx);
        bio().pageContext.registerListener(this.faF);
        bio().pageContext.registerListener(this.eKK);
        bio().pageContext.registerListener(this.fcy);
        bio().pageContext.registerListener(this.eOG);
        bio().pageContext.registerListener(this.ePf);
        bio().pageContext.registerListener(this.fcH);
        bio().pageContext.registerListener(this.fcI);
        bio().pageContext.registerListener(this.fcJ);
        bio().pageContext.registerListener(this.eON);
        bio().pageContext.registerListener(this.fcv);
        bio().pageContext.registerListener(this.fcs);
        bio().pageContext.registerListener(this.eOP);
        bio().pageContext.registerListener(this.eOO);
        bio().pageContext.registerListener(this.eOQ);
        bio().pageContext.registerListener(this.fcu);
        bio().pageContext.registerListener(this.fct);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jz(boolean z) {
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (am.c(com.baidu.live.s.a.wR().atk)) {
                bio().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
                return;
            } else if (bio().eWU.oP() == null || ListUtils.isEmpty(bio().eWU.oP().TZ) || bio().eWU.oP().Ua == null || bio().eWU.oP().Ua.isEmpty()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    bio().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
                    return;
                } else if (!this.fcn) {
                    this.fco = BdUniqueId.gen();
                    bio().eWU.a(this.fco);
                    this.fcn = true;
                    return;
                } else {
                    return;
                }
            }
        }
        BdUtilHelper.hideSoftKeyPad(bio().pageContext.getPageActivity(), bio().rootView);
        if (bio().eWs != null && this.fbv != null && this.fbv.getView() != null && this.fbv.getView().getParent() == null) {
            qh(8);
            if (bio().eWS.hasAdvancedBeauty()) {
                if (this.fcf != null) {
                    if (!this.fcp || this.fbl.getVisibility() == 0) {
                        this.fcf.a(bio().eWS.getVideoConfig());
                    }
                    this.fcf.a(bio().eWS.getVideoConfig(), this.fcg);
                    if (!this.fcg) {
                        this.fcg = true;
                    }
                }
            } else {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                bio().rootView.addView(this.fbv.getView(), layoutParams);
            }
            if (z && this.eNO != null) {
                this.eNO.uM().getView().setVisibility(8);
            }
        }
    }

    private String currentAppType(Activity activity) {
        if (activity != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                return activity.getResources().getString(a.i.sdk_permission_app_type_hk_text);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                return activity.getResources().getString(a.i.sdk_permission_app_type_qm_text);
            }
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                return activity.getResources().getString(a.i.sdk_permission_app_type_bd_text);
            }
            return activity.getResources().getString(a.i.sdk_permission_app_type_tb_text);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmz() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bio().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bio().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bio().d((short) 1);
            }
        });
        bdAlertDialog.create(bio().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmA() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bio().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bio().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bio().d((short) 1);
            }
        });
        bdAlertDialog.create(bio().pageContext).show();
    }

    private void yM(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bio().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bio().d((short) 1);
            }
        });
        bdAlertDialog.create(bio().pageContext).show();
    }

    public void bmB() {
        bgT();
        com.baidu.live.data.g bbH = bio().eWr.bbH();
        int i = 5;
        if (bbH != null) {
            i = (int) bbH.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null && AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bio().eWr.cU(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bbH != null) {
            if (this.eML == null) {
                this.eML = new c(bio().pageContext, this.fcB, true);
            }
            if (this.fce) {
                this.fce = false;
                this.eML.a(String.valueOf(bio().eWr.ww().mLiveInfo.group_id), String.valueOf(bio().eWr.ww().mLiveInfo.live_id), String.valueOf(bio().eWr.ww().Wf.userId), bio().eWr.ww());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.eNC != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.eML.c(this.faN, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.eML.f(bbH);
            this.eMQ.setVisible(0);
            this.eMQ.cA(bbH.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmC() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFL() {
        if (bio().eWr != null) {
            if (this.eND == null) {
                this.eND = new com.baidu.tieba.ala.liveroom.share.c(bio().pageContext);
            }
            this.eND.c(bio().eWr.ww(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bio().eWr != null && bio().eWr.ww() != null && bio().eWr.ww().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bio().eWr.ww().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bio().eWr.ww().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bio().eWr.ww().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bio().eWr != null && bio().eWr.ww() != null && bio().eWr.ww().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bio().eWr.ww().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bio().eWr.ww().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bio().eWr.ww().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bmD() {
        return this.fbj;
    }

    private void jA(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(fbi, z);
        this.fbj = z;
    }

    private void bmE() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bio().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.o.a(AlaMasterLiveRoomOpearator.this.bio().pageContext).bnA();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bio().pageContext).show();
    }

    private void bmF() {
        if (this.faS && bio().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bio().eWW.xH();
        }
        bio().eWV.prepareTime = System.currentTimeMillis() - bio().eWV.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bio().eWr != null && bio().eWr.ww() != null && bio().eWr.ww().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bio().eWr.ww().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bio().eWr.ww().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bio().eWV.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fbl != null && this.fbl.getView().getParent() != null) {
            this.fbl.setVisibility(8);
            bio().rootView.removeView(this.fbl.getView());
            this.fbl.release();
        }
        if (this.fcf != null) {
            this.fcf.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bio().eWs.indexOfChild(this.fbt) < 0) {
            bio().eWs.addView(this.fbt, layoutParams);
        }
        this.fbt.qx(1000);
    }

    private void bhC() {
        if (bio().bjW() == 1) {
            bio().eWS.startRecord();
        }
    }

    private void yN(String str) {
        yO(str);
    }

    private void yO(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bio().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String ac(Intent intent) {
        if (intent == null) {
            return null;
        }
        String stringExtra = intent.getStringExtra("album_result");
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        if (stringExtra != null) {
            writeImagesInfo.parseJson(stringExtra);
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            if (ListUtils.isEmpty(chosedFiles) || chosedFiles.get(0) == null) {
                return null;
            }
            return chosedFiles.get(0).getFilePath();
        }
        return null;
    }

    private void ad(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.fbl != null) {
            this.fbl.yA(fromJson.getSmallurl());
        }
    }

    private boolean bmG() {
        return com.baidu.live.c.oJ().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmH() {
        com.baidu.live.c.oJ().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.eQi.eWS.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmI() {
        int i = a.i.live_close_confirm;
        if (this.fci != null && this.fci.biu()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.fci != null && this.fci.bit()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bio().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(i);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                }
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomOpearator.this.bio().eWr.ww() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo, 0, AlaMasterLiveRoomOpearator.this.bio().eWr.boa() != 1 ? AlaMasterLiveRoomOpearator.this.bio().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                } else {
                    AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bio().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaLiveInfoData alaLiveInfoData, int i, String str) {
        if (alaLiveInfoData != null) {
            String str2 = alaLiveInfoData.close_reason;
            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            bio().eWr.cL(Long.toString(alaLiveInfoData.live_id), str2);
        }
        if (!this.fcc) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bio().eWV;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bio().eWS.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.fbY;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.fbZ;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.fbU;
            if (this.fbV != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.fbW - this.fbX) / this.fbV) * 100.0f;
            }
            Intent intent = new Intent(bio().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (bio().eWr != null && bio().eWr.ww() != null && bio().eWr.ww().Wf != null) {
                String str3 = bio().eWr.ww().Wf.nickName;
                String str4 = bio().eWr.ww().Wf.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            l ww = bio().eWr.ww();
            if (ww != null && ww.Wf != null && !TextUtils.isEmpty(ww.Wf.portrait)) {
                intent.putExtra("host_portrait", ww.Wf.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.fca = intent;
                this.fcb = s;
                bio().pageContext.showToast(a.i.ala_live_background_close_tip);
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.live.im.a aVar = new com.baidu.live.im.a();
                    aVar.setMsgType(13);
                    aVar.setContent(str);
                }
            } else {
                a(intent, s);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_TIME);
                if (alaLiveInfoData != null) {
                    alaStaticItem.addParams("live_id", alaLiveInfoData.live_id + "");
                    alaStaticItem.addParams("room_id", alaLiveInfoData.room_id + "");
                    alaStaticItem.addParams("time", alaLiveInfoData.getLiveDuration() + "");
                }
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmJ() {
        if (this.fca != null) {
            a(this.fca, this.fcb);
            this.fca = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.fcc = true;
        if (this.fci != null) {
            this.fci.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.eKA);
            bio().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913163));
        bio().d(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmK() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fci != null && this.fci.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bio().eWT.bnn()) {
                bmI();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.fbu.setVisibility(4);
            return;
        }
        this.fbu.a(i, z, i2, z2);
        if (this.eQi != null && this.eQi.eWr != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.bQZ != i3) {
                this.bQZ = i3;
                if (this.fbs == null) {
                    this.fbs = new com.baidu.tieba.ala.liveroom.tippop.a(this.eQi.pageContext, null);
                }
                switch (this.bQZ) {
                    case 0:
                        this.fbs.a(this.eQi.rootView, this.eQi.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.fbs.a(this.eQi.rootView, this.eQi.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.fbs.a(this.eQi.rootView, this.eQi.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.eQi.eWr.j(this.eQi.eWr.ww().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0421, code lost:
        yp(r25);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        final String str;
        String str2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String optString;
        String optString2;
        JSONObject jSONObject5;
        long j;
        long j2;
        long j3;
        if (aVar.getMsgType() == 125) {
            if (this.fbq != null) {
                this.fbq.u(aVar);
            }
        } else if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject4 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject4 = new JSONObject(aVar.getContent());
                }
                try {
                    optString = jSONObject4.optString("content_type");
                    try {
                        optString2 = jSONObject4.optString("text");
                    } catch (JSONException e) {
                        jSONObject = jSONObject4;
                        str = null;
                        str2 = optString;
                    }
                } catch (JSONException e2) {
                    jSONObject = jSONObject4;
                    str = null;
                    str2 = null;
                }
            } catch (JSONException e3) {
                jSONObject = null;
                str = null;
                str2 = null;
            }
            try {
                String optString3 = jSONObject4.optString("ext");
                if (!TextUtils.isEmpty(optString3)) {
                    new JSONObject(new String(Base64.decode(optString3.getBytes(), 0)));
                }
                jSONObject3 = jSONObject4.optJSONObject("ext_data");
                jSONObject2 = jSONObject4;
                str = optString2;
                str2 = optString;
            } catch (JSONException e4) {
                jSONObject = jSONObject4;
                str = optString2;
                str2 = optString;
                jSONObject2 = jSONObject;
                jSONObject3 = null;
                if (this.fci != null) {
                }
                if (!"close_live".equals(str2)) {
                }
            }
            if (this.fci != null) {
                this.fci.cL(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bmK();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bio().eWr.ww().mLiveInfo, 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bio().eWr.ww() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bio().eWr.ww().Wt.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bio().eWr.ww().Wt.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bio().eWr.ww().Wt.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.fbO != null) {
                    this.fbO.v(jSONObject2);
                }
            } else if (!"live_achievement".equals(str2)) {
                if ("enter_live".equals(str2)) {
                    if (jSONObject2 != null) {
                        String optString4 = jSONObject2.optString("share_enter_msg");
                        int optInt2 = jSONObject2.optInt("share_enter_interval");
                        if (!TextUtils.isEmpty(optString4)) {
                            this.fbr.av(optString4, optInt2);
                        }
                        if (this.eMQ.getCount() > 20) {
                            this.eMQ.cA(this.eMQ.getCount() + 1);
                        } else if (this.eML != null) {
                            com.baidu.live.data.a vq = aVar.vq();
                            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                            fVar.Wg = new AlaLocationData();
                            fVar.Wh = new AlaRelationData();
                            fVar.Wf = new AlaLiveUserInfoData();
                            fVar.Wf.userId = JavaTypesHelper.toLong(vq.userId, 0L);
                            fVar.Wf.userName = vq.userName;
                            fVar.Wf.portrait = vq.portrait;
                            if (this.eML.c(fVar)) {
                                this.eMQ.cA(this.eMQ.getCount() + 1);
                            }
                        }
                    }
                } else if ("ui_event".equals(str2)) {
                    if (jSONObject2 != null && jSONObject2.optInt("event_type") == 1001 && bio().eWr.ww() != null && bio().eWr.ww().mLiveInfo != null) {
                        String str3 = bio().eWr.ww().mLiveInfo.feed_id;
                        long j4 = bio().eWr.ww().mLiveInfo.live_id;
                        long optLong2 = jSONObject2.optLong("id");
                        if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                            o.g(str3, j4);
                            com.baidu.live.utils.m.h(j4, optLong2);
                        }
                    }
                } else if ("need_update_live_mark_info".equals(str2)) {
                    if (jSONObject2 != null && bio() != null && bio().eWr != null && bio().eWr.ww() != null && bio().eWr.ww().Wt != null && bio().eWr.ww().Wt.userId == jSONObject2.optLong("user_id")) {
                        bio().eWr.bnP();
                    }
                } else if ("official_notice".equals(str2) && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str4 = optLong3 + "";
                        TbadkCoreApplication.getInst();
                        if (str4.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913155, officialNoticeData));
                        }
                    }
                }
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a vq2 = aVar.vq();
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject5 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject5 = new JSONObject(aVar.getContent());
                }
                String optString5 = jSONObject5.optString(LogConfig.LOG_GIFT_ID);
                String optString6 = jSONObject5.optString("gift_count");
                String optString7 = jSONObject5.optString("gift_name");
                String optString8 = jSONObject5.optString("gift_url");
                String optString9 = jSONObject5.optString("attach");
                String optString10 = jSONObject5.optString("attach_new");
                String optString11 = jSONObject5.optString("gift_mul");
                String str5 = null;
                if (bio().eWr == null || bio().eWr.ww() == null || bio().eWr.ww().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                } else {
                    long j5 = bio().eWr.ww().mLiveInfo.live_id;
                    long j6 = bio().eWr.ww().mLiveInfo.group_id;
                    long j7 = bio().eWr.ww().Wf.userId;
                    str5 = bio().eWr.ww().mLiveInfo.appId;
                    j = j7;
                    j2 = j5;
                    j3 = j6;
                }
                if (!this.isBackground || bio().bjW() != 2) {
                    if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                        if (jSONObject5.optInt("flag_show") == 1) {
                            s.b(optString11, vq2.userId, vq2.portrait, vq2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str5, optString10);
                            try {
                                JSONArray jSONArray = new JSONArray(optString11);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.s.d.wY().dJ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                            break;
                                        }
                                        i++;
                                    }
                                }
                            } catch (JSONException e5) {
                                e5.printStackTrace();
                            }
                        }
                    } else {
                        s.b(optString5, Integer.parseInt(optString6), optString7, optString8, vq2.userId, vq2.portrait, vq2.getNameShow(), String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str5, optString9);
                    }
                }
                yp(optString5);
            } catch (JSONException e6) {
            }
        }
    }

    private void yp(String str) {
        if (this.eMS != null) {
            this.eMS.yp(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qh(int i) {
        View findViewById = bio().rootView.findViewById(a.g.ala_live_host_bottom);
        View findViewById2 = bio().rootView.findViewById(a.g.ala_live_unremovable_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(i);
        }
        if (this.eMS != null) {
            this.eMS.bj(2, i);
        }
    }

    private void bmL() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bio().eWS != null && AlaMasterLiveRoomOpearator.this.bio().eWS.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bio().eWS.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bio().eWS.startRecord();
                }
            }
        });
    }

    private void bmM() {
        if (bio().eWS != null && bio().eWS.getPreview() != null) {
            bio().eWS.getPreview().setVisibility(8);
            bio().eWS.stopRecord();
        }
    }

    public void bmN() {
        this.eWP = bio().eWr.bob();
        if (this.fbl != null) {
            this.fbl.jk(this.eWP);
        }
    }

    public void bjU() {
        if (this.fbl != null) {
            this.fbl.bjU();
        }
    }

    public void onDestroy() {
        if (this.fbT != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.fbT);
        }
        this.fbT = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fcf != null) {
            this.fcf.ji(true);
        }
        this.fcf = null;
        if (this.fbl != null) {
            this.fbl.destroy();
            bio().rootView.removeView(this.fbl.getView());
            this.fbl.release();
            this.fbl = null;
        }
        if (this.fci != null) {
            this.fci.onDestroy();
        }
        if (this.eND != null) {
            this.eND.onDestroy();
        }
        if (this.eNF != null) {
            this.eNF.onDestroy();
        }
        if (this.eMM != null) {
            this.eMM.onDestroy();
            this.eMM = null;
        }
        if (this.fbm != null) {
            this.fbm.onDestroy();
        }
        if (this.eNS != null) {
            this.eNS.onDestroy();
            this.eNS = null;
        }
        if (this.fbt != null) {
            this.fbt.stopCountDown();
        }
        if (this.fbp != null) {
            this.fbp.onDestroy();
        }
        if (this.fbr != null) {
            this.fbr.onDestroy();
        }
        if (this.fbO != null) {
            this.fbO.onDestroy();
            this.fbO = null;
        }
        if (this.eNQ != null) {
            this.eNQ.onDestroy();
            this.eNQ = null;
        }
        s.rC();
        if (this.eNR != null) {
            this.eNR.onDestroy();
            this.eNR = null;
        }
        if (this.fbs != null) {
            this.fbs.onDestroy();
        }
        if (this.fbq != null) {
            this.fbq.bpQ();
            this.fbq.release();
        }
        if (this.eMQ != null) {
            this.eMQ = null;
        }
        if (this.eMS != null) {
            this.eMS.release();
        }
        if (this.fbn != null) {
            this.fbn.onDestroy();
        }
        if (this.fbq != null) {
            this.fbq.onDestroy();
        }
        if (this.eNP != null) {
            this.eNP.release();
        }
        if (this.eOa != null) {
            this.eOa.release();
        }
        if (this.eOb != null) {
            this.eOb.onDestroy();
        }
        if (this.fbQ != null) {
            this.fbQ.onDestroy();
        }
        if (this.eOl != null) {
            this.eOl.release();
        }
        if (this.fck != null) {
            this.fck.onDestory();
        }
        if (this.fcl != null) {
            this.fcl.release();
        }
        if (this.eOj != null) {
            this.eOj.onDestroy();
        }
        if (this.fcm != null) {
            this.fcm.release();
        }
        MessageManager.getInstance().unRegisterListener(this.ePf);
        MessageManager.getInstance().unRegisterListener(this.fcH);
        MessageManager.getInstance().unRegisterListener(this.fcI);
        MessageManager.getInstance().unRegisterListener(this.fcJ);
        MessageManager.getInstance().unRegisterListener(this.eON);
        MessageManager.getInstance().unRegisterListener(this.fcv);
        MessageManager.getInstance().unRegisterListener(this.fcs);
        MessageManager.getInstance().unRegisterListener(this.eOP);
        MessageManager.getInstance().unRegisterListener(this.eOO);
        MessageManager.getInstance().unRegisterListener(this.eOQ);
        MessageManager.getInstance().unRegisterListener(this.fcu);
        MessageManager.getInstance().unRegisterListener(this.fct);
        com.baidu.live.utils.m.yJ();
    }
}
