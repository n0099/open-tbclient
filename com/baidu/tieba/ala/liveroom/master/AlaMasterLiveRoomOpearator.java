package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
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
import com.baidu.ala.recorder.video.gles.Sticker;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.ar.pose.PoseAR;
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
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.c.p;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.am;
import com.baidu.live.data.an;
import com.baidu.live.data.av;
import com.baidu.live.data.j;
import com.baidu.live.data.q;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.gift.y;
import com.baidu.live.guardclub.h;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.k;
import com.baidu.live.im.l;
import com.baidu.live.im.o;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
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
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.m;
import com.baidu.live.w.a;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.g.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.share.c;
import com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.baidu.tieba.ala.liveroom.views.e;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.PushMessageHelper;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String fXC;
    private boolean aTs;
    private List<an> aWS;
    private String fHR;
    private com.baidu.live.g.a fJq;
    private com.baidu.live.h.a fKY;
    private c fKZ;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fKh;
    private com.baidu.tieba.ala.liveroom.l.a fKi;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fKl;
    private com.baidu.tieba.ala.liveroom.activeview.b fKn;
    protected com.baidu.live.i.a fLF;
    private com.baidu.live.q.a fLI;
    private boolean fLT;
    private com.baidu.tieba.ala.liveroom.o.b fLa;
    private com.baidu.tieba.ala.liveroom.guide.c fLb;
    private com.baidu.tieba.ala.liveroom.watermark.a fLc;
    private o fLj;
    private k fLk;
    private l fLl;
    private w fLm;
    private u fLn;
    protected com.baidu.tieba.ala.liveroom.f.a fLu;
    protected h fLv;
    protected y fLx;
    private ImageView fMR;
    private ImageView fNE;
    private g fNF;
    private f fNw;
    private boolean fXD;
    private d fXF;
    private com.baidu.tieba.ala.liveroom.l.a fXG;
    private com.baidu.tieba.ala.liveroom.e.c fXH;
    private com.baidu.tieba.ala.liveroom.b.a fXI;
    private com.baidu.tieba.ala.liveroom.r.a fXJ;
    private com.baidu.tieba.ala.liveroom.v.a fXK;
    private b fXL;
    private com.baidu.tieba.ala.liveroom.tippop.a fXM;
    private AlaLiveCountDownView fXN;
    private AlaLiveStreamStatusView fXO;
    private RelativeLayout fXP;
    private RelativeLayout fXQ;
    private RelativeLayout fXR;
    private RelativeLayout fXS;
    private View fXT;
    private AlaLiveFaceVerifyView fXU;
    private ImageView fXV;
    private ImageView fXW;
    private ImageView fXX;
    private ImageView fXY;
    private ImageView fXZ;
    private boolean fXm;
    private com.baidu.tieba.ala.liveroom.challenge.f fYA;
    private com.baidu.live.b.a fYC;
    private com.baidu.live.b.b fYD;
    private com.baidu.tieba.ala.liveroom.n.a fYE;
    private boolean fYF;
    private BdUniqueId fYG;
    private boolean fYH;
    private ImageView fYa;
    private View fYb;
    private ImageView fYc;
    private TextView fYd;
    private ad fYe;
    private com.baidu.live.x.a fYf;
    private com.baidu.tieba.ala.liveroom.master.panel.b fYg;
    private com.baidu.live.w.a fYh;
    private e fYi;
    private short fYs;
    private com.baidu.tieba.ala.liveroom.g.b fYx;
    private boolean fYy;
    private boolean fYz;
    private boolean fXE = false;
    private boolean fLO = false;
    private Handler mHandler = new Handler();
    private boolean fYj = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver fYk = null;
    private boolean fYl = false;
    private int fYm = 0;
    private int fYn = 0;
    private int fYo = 0;
    private long fYp = 0;
    private long fYq = 0;
    private volatile boolean isBackground = false;
    private Intent fYr = null;
    private int mOrientation = 1;
    private boolean fTJ = false;
    private boolean fYt = false;
    private boolean fYu = true;
    private boolean fNC = false;
    private boolean fYv = true;
    private boolean fYw = true;
    private int cGo = 0;
    public boolean fYB = false;
    private String otherParams = "";
    private int aTu = 0;
    private int fYI = 5000;
    private boolean fYJ = false;
    private Runnable fYK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.fJq != null) {
                AlaMasterLiveRoomOpearator.this.fJq.wB();
            }
        }
    };
    private CustomMessageListener aWm = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fNw.fTS != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fNw.fTS.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.x(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener aWn = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fNw.fTS != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fNw.fTS.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener fMh = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.fLa == null) {
                        AlaMasterLiveRoomOpearator.this.fLa = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    AlaMasterLiveRoomOpearator.this.fLa.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener fMo = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fLF != null) {
                AlaMasterLiveRoomOpearator.this.fLF.BO();
            }
        }
    };
    private CustomMessageListener fYL = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fMe = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Ci(str);
            }
        }
    };
    private CustomMessageListener fMf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aWJ();
        }
    };
    private CustomMessageListener fKI = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.fLn.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fMm = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener fYM = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fYD != null) {
                q Fk = AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk();
                long j = Fk.mLiveInfo.live_id;
                long j2 = Fk.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.fYD.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener fYN = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bzF().fTn);
            if (AlaMasterLiveRoomOpearator.this.fXF == null || AlaMasterLiveRoomOpearator.this.fXF.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.rn(0);
            }
            if (AlaMasterLiveRoomOpearator.this.fLk != null) {
                AlaMasterLiveRoomOpearator.this.fLk.CA().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.fLk.CB().hide();
            }
        }
    };
    private CustomMessageListener fMn = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.o(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk());
        }
    };
    private CustomMessageListener fMp = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fLx != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.fLx).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fYO = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fYE != null) {
                    AlaMasterLiveRoomOpearator.this.fYE.Cm(str);
                }
            }
        }
    };
    private CustomMessageListener fYP = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.fYx != null) {
                        if (!data.asP || AlaMasterLiveRoomOpearator.this.fYG == null || !AlaMasterLiveRoomOpearator.this.fYH) {
                            if (AlaMasterLiveRoomOpearator.this.fYG != null && AlaMasterLiveRoomOpearator.this.fYG == data.asO) {
                                if (data.asJ != null && data.asJ.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.fYH || AlaMasterLiveRoomOpearator.this.fXF.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.fYx.a(AlaMasterLiveRoomOpearator.this.bzF().fTM.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.fYy = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bzF().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.fYG = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bzF().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.fYx.a(AlaMasterLiveRoomOpearator.this.bzF().fTM.getVideoConfig(), AlaMasterLiveRoomOpearator.this.fYy);
                        if (!AlaMasterLiveRoomOpearator.this.fYy) {
                            AlaMasterLiveRoomOpearator.this.fYy = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.fYF) {
                    AlaMasterLiveRoomOpearator.this.bzF().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.fYF = false;
            }
        }
    };
    private CustomMessageListener fYQ = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bzF().fTM != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bzF().fTM.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                }
            }
        }
    };
    public CustomMessageListener aTv = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.aTu == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.aTu == 6) {
                            AlaMasterLiveRoomOpearator.this.bDf();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.aTu = 0;
            }
        }
    };
    private View.OnClickListener fYR = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.fXW) {
                    AlaMasterLiveRoomOpearator.this.bDh();
                    AlaMasterLiveRoomOpearator.this.fYg.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.fXV) {
                    if (view == AlaMasterLiveRoomOpearator.this.fXX) {
                        AlaMasterLiveRoomOpearator.this.aWJ();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.fXY) {
                        if (view != AlaMasterLiveRoomOpearator.this.fYa) {
                            if (view != AlaMasterLiveRoomOpearator.this.fNE) {
                                if (view == AlaMasterLiveRoomOpearator.this.fXZ) {
                                    if (AlaMasterLiveRoomOpearator.this.fXK != null) {
                                        String str = null;
                                        String str2 = null;
                                        com.baidu.tieba.ala.liveroom.data.h bFl = AlaMasterLiveRoomOpearator.this.bzF().fTm.bFl();
                                        if (bFl != null && bFl.mLiveSdkInfo != null) {
                                            str = String.valueOf(bFl.mLiveSdkInfo.mRoomId);
                                            if (bFl.mLiveSdkInfo.mCastIds != null) {
                                                str2 = bFl.mLiveSdkInfo.mCastIds.avv;
                                            }
                                        }
                                        AlaMasterLiveRoomOpearator.this.fXK.ag("", str, str2);
                                        return;
                                    }
                                    return;
                                } else if (view == AlaMasterLiveRoomOpearator.this.fYc) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
                                    q Fk = AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk();
                                    if (AlaMasterLiveRoomOpearator.this.fLu != null && Fk != null && Fk.mLiveInfo != null) {
                                        String valueOf = String.valueOf(Fk.mLiveInfo.live_id);
                                        String valueOf2 = String.valueOf(Fk.mLiveInfo.feed_id);
                                        long j = Fk.mLiveInfo.room_id;
                                        String str3 = Fk.mLiveInfo.cover;
                                        String str4 = "";
                                        String str5 = "";
                                        String str6 = "";
                                        String str7 = "";
                                        if (Fk.mLiveInfo.session_info != null) {
                                            str4 = Fk.mLiveInfo.session_info.flvUrl;
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
                                        long j2 = Fk.mLiveInfo.user_id;
                                        long j3 = Fk.mLiveInfo.group_id;
                                        AlaMasterLiveRoomOpearator.this.fLu.Cm(com.baidu.live.utils.o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7, String.valueOf(j2), Fk.mLiveInfo.user_name, String.valueOf(j3), String.valueOf(Fk.avj.userId)));
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.fYA != null) {
                                AlaMasterLiveRoomOpearator.this.fYA.bzH();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.fYh != null) {
                            AlaMasterLiveRoomOpearator.this.fYh.showDialog();
                            AlaMasterLiveRoomOpearator.this.fYh.bX(AlaMasterLiveRoomOpearator.this.bDl());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.fYH = false;
                        AlaMasterLiveRoomOpearator.this.kZ(true);
                    }
                } else if (com.baidu.live.v.a.Ge().aWF.ayB == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Ge().aWF.ayA == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.aTs) {
                        AlaMasterLiveRoomOpearator.this.bDf();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.aTu = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bDf();
                }
            }
        }
    };
    private CustomMessageListener fMg = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ad) {
                    AlaMasterLiveRoomOpearator.this.fLO = true;
                    AlaMasterLiveRoomOpearator.this.fYe = (ad) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.fLk != null) {
                        AlaMasterLiveRoomOpearator.this.fLk.CA().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fLk != null) {
                        AlaMasterLiveRoomOpearator.this.fLk.CB().show();
                        AlaMasterLiveRoomOpearator.this.fLk.CB().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.rn(8);
                }
            }
        }
    };
    private CustomMessageListener fYS = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bzF() != null && AlaMasterLiveRoomOpearator.this.bzF().fTQ != null) {
                AlaMasterLiveRoomOpearator.this.bzF().fTQ.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bfX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bDU();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bzF().fTm.ru(i);
                if (AlaMasterLiveRoomOpearator.this.fLF != null) {
                    AlaMasterLiveRoomOpearator.this.fLF.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener fIc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bDN();
        }
    };
    public final HttpMessageListener fYT = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Fn()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.fYg != null) {
                            AlaMasterLiveRoomOpearator.this.fYg.lg(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.fYg.bEu();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bzF().fTM.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.fXM != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.fXM.a(AlaMasterLiveRoomOpearator.this.bzF().rootView, AlaMasterLiveRoomOpearator.this.bzF().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bzF().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.fXM.rC(2);
                        AlaMasterLiveRoomOpearator.this.fXM.a(AlaMasterLiveRoomOpearator.this.bzF().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a fYU = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bEb() {
            AlaMasterLiveRoomOpearator.this.bDK();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bEc() {
            AlaMasterLiveRoomOpearator.this.bDL();
        }
    };
    com.baidu.live.liveroom.a.a fYV = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean cA(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cB(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cC(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bzF().bBi() == 1) {
                AlaMasterLiveRoomOpearator.this.bzF().fTM.stopRecord();
            }
        }
    };
    private IShareCallback fYW = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.fYj && AlaMasterLiveRoomOpearator.this.fYi != null) {
                AlaMasterLiveRoomOpearator.this.fYj = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.fYi);
            }
        }
    };
    private View.OnTouchListener fYX = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bzF().fTQ.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bzF().fTn);
            AlaMasterLiveRoomOpearator.this.rn(0);
            if (AlaMasterLiveRoomOpearator.this.fLk != null) {
                AlaMasterLiveRoomOpearator.this.fLk.CA().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.fLk.CB().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b fYY = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEd() {
            AlaMasterLiveRoomOpearator.this.bDg();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEe() {
            AlaMasterLiveRoomOpearator.this.fXm = AlaMasterLiveRoomOpearator.this.fXF.bBa();
            AlaMasterLiveRoomOpearator.this.bzF().fTQ.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bzF().fTQ.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bzF().fTQ.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fTG = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bzF().bBi();
            eVar.title = AlaMasterLiveRoomOpearator.this.fXF.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.fTH = AlaMasterLiveRoomOpearator.this.fXF.bBb();
            eVar.fTK = AlaMasterLiveRoomOpearator.this.fXm;
            eVar.fTJ = AlaMasterLiveRoomOpearator.this.fXF.bAY();
            eVar.fTI = AlaMasterLiveRoomOpearator.this.fXF.bBd();
            eVar.fTL = AlaMasterLiveRoomOpearator.this.fXF.bAZ();
            if (eVar.fTL) {
                if (AlaMasterLiveRoomOpearator.this.fXF.bBe()) {
                    AlaMasterLiveRoomOpearator.this.fYj = true;
                    AlaMasterLiveRoomOpearator.this.fYi = eVar;
                    AlaMasterLiveRoomOpearator.this.fXF.bBf();
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
            AlaMasterLiveRoomOpearator.this.bzF().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bzF().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEf() {
            AlaMasterLiveRoomOpearator.this.fYH = true;
            AlaMasterLiveRoomOpearator.this.kZ(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bEg() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEh() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEi() {
            com.baidu.live.utils.o.m(AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity(), "", "");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private Runnable fYZ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.bzF().fTm != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo != null) {
                    m.k(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.fYZ, AlaMasterLiveRoomOpearator.this.fYI);
                }
            }
        }
    };
    private CustomMessageListener aRd = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.byb();
            }
        }
    };
    private com.baidu.live.liveroom.g.c fZa = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Fi() {
            if (AlaMasterLiveRoomOpearator.this.fXK != null) {
                AlaMasterLiveRoomOpearator.this.fXK.lu(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bT(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.fYA != null) {
                        AlaMasterLiveRoomOpearator.this.fYA.d(AlaMasterLiveRoomOpearator.this.fNE);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fYh != null) {
                        AlaMasterLiveRoomOpearator.this.fYh.setStickerCanOperate(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.fYA != null) {
                        AlaMasterLiveRoomOpearator.this.fYA.Ji();
                    }
                    if (AlaMasterLiveRoomOpearator.this.fYh != null) {
                        AlaMasterLiveRoomOpearator.this.fYh.setStickerCanOperate(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.fXK != null) {
                    AlaMasterLiveRoomOpearator.this.fXK.lu(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.fLx != null) {
                    AlaMasterLiveRoomOpearator.this.fLx.be(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a fZb = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void Qv() {
            if (AlaMasterLiveRoomOpearator.this.fXU != null && AlaMasterLiveRoomOpearator.this.bzF().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.fXU) >= 0) {
                AlaMasterLiveRoomOpearator.this.bzF().rootView.removeView(AlaMasterLiveRoomOpearator.this.fXU);
                AlaMasterLiveRoomOpearator.this.fXU.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.fXU = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fKN = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            q Fk;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bDT();
            } else if (i == 14 && (Fk = AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk()) != null && Fk.avj != null && Fk.mLiveInfo != null && Fk.avC != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity(), Fk.avj.userName, Long.toString(Fk.avj.userId), Long.toString(Fk.avj.charmCount), String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), true, String.valueOf(Fk.avj.userId), Long.toString(Fk.avC.userId), Fk.avC.userName, Fk.avC.portrait, AlaMasterLiveRoomOpearator.this.fKl.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Fk.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.fKl.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener fZc = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.fYB = ((HasGoodsAuthResponseMessage) httpResponsedMessage).gaf;
            }
        }
    };
    private HttpMessageListener fZd = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || !(httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.a(httpResponsedMessage, "data_error", UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
            } else if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                AlaMasterLiveRoomOpearator.this.a(httpResponsedMessage, ETAG.KEY_NET_ERROR, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST);
            } else {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.fYd.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.fYd.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.fYd.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.fYd.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.aWS = getVideoGoodsListHttpResponseMessage.aWS;
                AlaMasterLiveRoomOpearator.this.a(httpResponsedMessage, (String) null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST_SUCC);
            }
        }
    };
    private HttpMessageListener fZe = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.bzF().fTm != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aWM != null && !eventPollingHttpResponseMessage.aWM.isEmpty()) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.aWM.size()) {
                                break;
                            }
                            am amVar = eventPollingHttpResponseMessage.aWM.get(i2);
                            if (j == amVar.liveId && j2 - amVar.createTime <= 60 && !m.i(amVar.liveId, amVar.id)) {
                                m.a(amVar, AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo, true);
                                m.j(amVar.liveId, amVar.id);
                            }
                            i = i2 + 1;
                        }
                        am amVar2 = eventPollingHttpResponseMessage.aWM.get(eventPollingHttpResponseMessage.aWM.size() - 1);
                        if (j == amVar2.liveId) {
                            m.h(amVar2.liveId, amVar2.id);
                        }
                    }
                }
                int i3 = eventPollingHttpResponseMessage.aWL;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.fYI = i3 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a fZf = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private com.baidu.live.liveroom.middleware.g fZg = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.ase);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        fXC = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Ge().aWF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bzF().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Ge().aWF.ayw, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bzF().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Ge().aWF.axW;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bzF().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bzF().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bzF().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byb() {
        int i = bzF().fTm.Fk().avj.isUegBlock;
        int i2 = bzF().fTm.Fk().avj.isBlock;
        String str = bzF().fTm.Fk().avj.userName;
        if (i > 0 || i2 > 0) {
            this.aTs = true;
            this.fLk.a(true, i, i2, str);
            return;
        }
        this.aTs = false;
        this.fLk.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.fNw.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aTF == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aTG);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.fNw.pageContext.getPageActivity());
            bdAlertDialog.setMessage(format);
            bdAlertDialog.setPositiveButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                        BrowserHelper.startInternalWebActivity(pageActivity, "https%3A%2F%2Fufosdk.baidu.com%2F%3Fm%3DClient%26a%3DpostViewNew%26appid%3D238780%26needFbtype%3Dtrue%26hasRt%3Dfalse%26hasTitleBar%3Dfalse%26fbtnPlace%3Dbr%26channelId%3D90953");
                    } else {
                        BrowserHelper.startInternalWebActivity(pageActivity, "https://ufosdk.baidu.com/?m=Client&a=postViewNew&appid=238780&needFbtype=true&hasRt=false&hasTitleBar=false&fbtnPlace=br&channelId=90953");
                    }
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.setNegativeButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(pageActivity.getResources().getColorStateList(a.f.sdk_dialog_blue_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(pageActivity.getResources().getColorStateList(a.f.sdk_dialog_gray_button_txt_selector));
            } else {
                bdAlertDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                bdAlertDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bdAlertDialog.create(this.fNw.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDf() {
        if (this.fLk != null) {
            this.fLk.CB().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.fYA != null) {
            this.fYA.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDg() {
        if (bzF() != null && bzF().fTm != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bzF().fTm.bFc();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bzF().fTm.bFd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bsN() != null && aVar.bsO() != null) {
            bzF().fTm.dH(aVar.bsN().getId(), aVar.bsO().getId());
        }
    }

    /* loaded from: classes3.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.fYl = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.fYl = false;
                }
                if (AlaMasterLiveRoomOpearator.this.fYm == 0) {
                    AlaMasterLiveRoomOpearator.this.fYm = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.fYn == 0) {
                    AlaMasterLiveRoomOpearator.this.fYn = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.fYo = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bzF() != null && bzF().fTO != null) {
            bzF().fTO.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.fNw = fVar;
        this.fHR = str;
    }

    protected f bzF() {
        return this.fNw;
    }

    public int a(g gVar) {
        this.fNF = gVar;
        this.fYk = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.fYk, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.fXM == null) {
            this.fXM = new com.baidu.tieba.ala.liveroom.tippop.a(this.fNw.pageContext, null);
        }
        registerListener();
        this.fJq = new com.baidu.live.g.a();
        bDv();
        Long[] lArr = new Long[1];
        this.fYp = lArr[0] == null ? 0L : lArr[0].longValue();
        this.fYq = lArr[0] != null ? lArr[0].longValue() : 0L;
        bzF().fTn.setOnTouchListener(this.fYX);
        this.fXD = SharedPrefHelper.getInstance().getBoolean(fXC, false);
        this.fXN = new AlaLiveCountDownView(bzF().pageContext.getPageActivity());
        this.fXN.setCount(3);
        this.fXN.setTextColor(bzF().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.fXN.setTextSize(bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.fXN.setTypeface(Typeface.DEFAULT_BOLD);
        this.fXN.setIncludeFontPadding(false);
        this.fXN.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bEj() {
                if (AlaMasterLiveRoomOpearator.this.bzF().fTn != null) {
                    AlaMasterLiveRoomOpearator.this.bzF().fTn.removeView(AlaMasterLiveRoomOpearator.this.fXN);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDh() {
        if (this.fYg == null) {
            this.fYg = new com.baidu.tieba.ala.liveroom.master.panel.b(bzF().pageContext.getPageActivity(), bzF().bBi() == 2);
            this.fYg.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lb(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bzF().fTM.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lc(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bzF().fTM.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ld(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bzF().fTM.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bDS();
                    if (AlaMasterLiveRoomOpearator.this.fXM != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.fXM.a(AlaMasterLiveRoomOpearator.this.bzF().rootView, AlaMasterLiveRoomOpearator.this.bzF().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.fXM.a(AlaMasterLiveRoomOpearator.this.bzF().rootView, AlaMasterLiveRoomOpearator.this.bzF().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void le(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEk() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bzF().fTm != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEl() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bzF().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEm() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bzF() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.bzF().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.fYg != null) {
                            AlaMasterLiveRoomOpearator.this.fYg.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEn() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bzF() == null || AlaMasterLiveRoomOpearator.this.bzF().fTm == null || AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() == null || AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bzF() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.fYg != null) {
                                        AlaMasterLiveRoomOpearator.this.fYg.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fNw.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.fYg != null) {
                        AlaMasterLiveRoomOpearator.this.fYg.dismiss();
                    }
                }
            });
        }
        bDi();
    }

    private void bDi() {
        if (this.fYg != null) {
            boolean isBackCamera = bzF().fTM.isBackCamera();
            this.fYg.lf(bzF().fTM.isBackCamera());
            this.fYg.I(bzF().fTM.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bzF().fTM.isPushMirror();
            if (this.fYu) {
                isPushMirror = bDR() || isPushMirror;
                this.fYu = false;
            }
            this.fYg.J(isPushMirror, isBackCamera ? false : true);
            this.fYg.lg(bzF().fTM.isMute());
            this.fYg.bEu();
        }
    }

    public void bDj() {
        if (this.fNF != null) {
            if (this.fNF.fTT == null || this.fNF.fTT.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.fXT == null) {
                        this.fXT = this.fNw.fTS.ES();
                        this.fNw.rootView.addView(this.fXT, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.fXF == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bzF().fTm != null && bzF().fTm.Fk() != null && bzF().fTm.Fk().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bzF().fTm.Fk().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bzF().fTm.Fk().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.fXF = new d(bzF().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bzF().fTQ.prepareTime = System.currentTimeMillis();
                    bzF().rootView.addView(this.fXF.getView(), layoutParams);
                    this.fXF.a(this.fYW);
                }
                this.fXF.kK(this.fTJ);
                this.fXF.a(this.fYY);
                this.fXF.a(this.fYU);
                this.fXF.a(bzF().fTM, bzF().bBi());
                return;
            }
            this.fXm = this.fNF.fTT.mLiveInfo.screen_direction == 2;
            if (this.fNF.fTT.mLiveInfo.isAudioOnPrivate == 1) {
                bzF().fTM.setMute(true);
                if (this.fXM == null) {
                    this.fXM = new com.baidu.tieba.ala.liveroom.tippop.a(this.fNw.pageContext, null);
                }
                if (!this.fXM.rB(2)) {
                    this.fXM.a(bzF().rootView, bzF().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fTG = true;
            eVar.forumId = String.valueOf(this.fNF.fTT.mLiveInfo.forum_id);
            eVar.forumName = this.fNF.fTT.mLiveInfo.forum_name;
            eVar.liveType = this.fNF.fTT.mLiveInfo.live_type;
            eVar.title = this.fNF.fTT.mLiveInfo.getLiveTitle();
            eVar.clarity = this.fNF.fTT.mLiveInfo.clarity;
            eVar.gameId = this.fNF.fTT.mLiveInfo.game_id;
            eVar.gameName = this.fNF.fTT.mLiveInfo.game_label;
            eVar.fTK = this.fNF.fTT.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bDk() {
        if (this.fYx != null) {
            this.fYx.a(bzF().fTM.getVideoConfig(), false);
        }
        if (this.fXF != null) {
            this.fXF.kJ(true);
        }
        if (bzF().fTM.hasBeauty() >= 0) {
            bzF().fTM.setBeauty(com.baidu.live.c.uN().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bzF().fTS.F(this.fNw.fTM);
        } else if (this.fXF != null) {
            this.fXF.kJ(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.fXT != null && this.fXT.getParent() != null) {
                ((ViewGroup) this.fXT.getParent()).removeView(this.fXT);
                this.fXT = null;
            }
            bzF().fTn.setVisibility(0);
            this.fNw.fTS.a(bzF().fTn);
        } else {
            bDA();
            bDQ();
            this.fXK = new com.baidu.tieba.ala.liveroom.v.a(bzF().pageContext, this.fYV);
            this.fXK.d(bzF().fTn, true);
            this.fXK.lu(true);
            if (this.fLk != null && this.fLk.CA() != null) {
                this.fLk.CA().setNeedTopAlphaShade(true);
            }
        }
        bzF().fTM.setPushMirror(bDR());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fNw.fTS.j(bzF().fTm.Fk());
        }
        if (!bzF().fTM.isBackground() && bzF().fTm.Fk() != null && bzF().fTm.Fk().mLiveInfo != null) {
            int startPush = bzF().fTM.startPush(bzF().fTm.Fk().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fNw.fTS.ET();
            }
            if (startPush != 0 && bzF().fTQ != null) {
                bzF().fTQ.errCode = 4;
                bzF().fTQ.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.bBm() && !bDO()) {
                la(true);
                bDP();
            }
            if (this.fXH != null) {
                this.fXH.p(bzF().fTm.Fk());
            }
            if (this.fKi != null) {
                this.fKi.t(bzF().fTm.Fk());
            }
            if (this.fKY != null) {
                this.fKY.a(bzF().fTm.Fk());
            }
            if (this.fXI != null && bzF() != null && bzF().fTm != null) {
                if (this.fXI.ap(bzF().fTn)) {
                    this.fXI.n(bzF().fTm.Fk());
                } else {
                    this.fXI.b(bzF().fTn, bzF().fTm.Fk());
                }
            }
            if (this.fXG != null) {
                this.fXG.t(bzF().fTm.Fk());
            }
            if (hVar == null || hVar.avj == null) {
                z = com.baidu.live.c.uN().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.avj.canUseChallenge;
                com.baidu.live.c.uN().putBoolean("ala_master_can_use_challenge", z);
            }
            bDB();
            bDo();
            kX(z);
            bDC();
            bDH();
            byD();
            byR();
            u(bzF().fTm.Fk());
            f(bzF().fTm.Fk());
            bDI();
            bDJ();
            bDF();
            byF();
            byM();
            byN();
            bDz();
            if (this.fLj != null) {
                this.fLj.g(bzF().fTm.Fk());
            }
            if (this.fLk != null) {
                if (bzF().fTm.Fk() != null && bzF().fTm.Fk().avP != null && bzF().fTm.Fk().avP.vQ()) {
                    z2 = true;
                }
                this.fLk.a(String.valueOf(bzF().fTm.Fk().mLiveInfo.group_id), String.valueOf(bzF().fTm.Fk().mLiveInfo.last_msg_id), String.valueOf(bzF().fTm.Fk().avj.userId), String.valueOf(bzF().fTm.Fk().mLiveInfo.live_id), bzF().fTm.Fk().avj.appId, z2);
            }
            if (this.fLl != null) {
                this.fLl.a(bzF().fTm.Fk(), true);
            }
            if (!this.fYJ && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.fYJ = true;
                this.mHandler.post(this.fYZ);
            }
            this.mHandler.post(this.fYK);
        }
    }

    private void kX(boolean z) {
        if (this.fYA == null) {
            this.fYA = new com.baidu.tieba.ala.liveroom.challenge.f(bzF());
        }
        this.fYA.a(this.fNE, this.fNF);
        this.fYA.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ak akVar, al alVar, al alVar2) {
                if (AlaMasterLiveRoomOpearator.this.fLc != null) {
                    AlaMasterLiveRoomOpearator.this.fLc.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bzF().fTn.ghf = false;
                AlaMasterLiveRoomOpearator.this.bDm();
                if (AlaMasterLiveRoomOpearator.this.fLI != null) {
                    AlaMasterLiveRoomOpearator.this.fLI.b(AlaMasterLiveRoomOpearator.this.kY(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void vt() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fYK);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bzD() {
                if (AlaMasterLiveRoomOpearator.this.fLc != null) {
                    AlaMasterLiveRoomOpearator.this.fLc.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bzF().fTn.ghf = true;
                AlaMasterLiveRoomOpearator.this.bDn();
                if (AlaMasterLiveRoomOpearator.this.fLI != null) {
                    AlaMasterLiveRoomOpearator.this.fLI.b(AlaMasterLiveRoomOpearator.this.kY(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bzE() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fYK);
            }
        });
        this.fYA.F(this.fXm, z);
        this.fYA.h(this.fXm, z, (this.fNF == null || this.fNF.fTT == null || this.fNF.fTT.mChallengeData == null) ? false : true);
    }

    public boolean bDl() {
        return this.fYA != null && this.fYA.bzJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDm() {
        if (this.fXL != null) {
            this.fXL.setVisible(8);
            this.fXL.setCanVisible(false);
        }
        if (this.fKn != null) {
            this.fKn.ki(true);
            kC(true);
        }
        if (this.fXO != null) {
            this.fXO.setCanVisible(false);
            this.fXO.setVisibility(4);
        }
        if (this.fXK != null) {
            this.fXK.lt(false);
        }
        if (this.fLk != null) {
            this.fLk.CA().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDn() {
        if (this.fXL != null) {
            this.fXL.setCanVisible(true);
        }
        if (this.fKn != null) {
            this.fKn.ki(false);
            kC(false);
        }
        if (this.fXO != null) {
            this.fXO.setCanVisible(true);
        }
        if (this.fXK != null) {
            this.fXK.lt(true);
        }
        if (this.fLk != null) {
            this.fLk.CA().setNeedTopAlphaShade(false);
        }
    }

    private void kC(boolean z) {
        ViewGroup.LayoutParams qP;
        if (this.fKn != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.fKn;
            AlaLiveView alaLiveView = bzF().fTn;
            if (z) {
                qP = bEa();
            } else {
                qP = qP(1);
            }
            bVar.a(1, alaLiveView, qP, 21);
            this.fKn.updateView();
        }
    }

    private void bDo() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.fXO == null) {
            this.fXO = new AlaLiveStreamStatusView(bzF().pageContext.getPageActivity());
        }
        this.fXO.setId(a.g.ala_live_room_stream_view);
        this.fXO.setVisibility(4);
        this.fXO.setLayoutParams(layoutParams);
        if (this.fXO.getParent() == null) {
            bzF().fTn.addView(this.fXO, layoutParams);
        }
    }

    public void bDp() {
        if (this.fXF != null && this.fXF.getVisibility() != 8 && bzF().fTM.getPreview() != null) {
            bzF().fTM.stopRecord();
        }
    }

    public void bDq() {
        if (bzF().fTM.getPreview() != null) {
            bzF().fTM.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fYx != null) {
                this.fYx.kI(false);
            }
            this.fYx = new com.baidu.tieba.ala.liveroom.g.b(bzF().rootView, bzF(), bzF().fTM);
            this.fYx.a(bzF().fTM.getVideoConfig(), false);
        }
        if (this.fXM != null) {
            this.fXM.bGs();
        }
        this.mHandler.post(this.fYK);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fXE = z;
        if (z) {
            if (this.fYw) {
                this.fYw = false;
                if (this.fLk != null && this.fLk.CA() != null) {
                    this.fLk.CA().getView().setBottom(0);
                }
                if (this.fLk != null && this.fLk.CB() != null) {
                    this.fLk.CB().getView().setBottom(0);
                }
            }
            if (this.fLk != null && this.fLk.CA() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fLk.CA().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.fLk.CA().getView().setLayoutParams(layoutParams);
            }
            if (this.fLk != null && this.fLk.CB() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fLk.CB().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.fLk.CB().getView().setLayoutParams(layoutParams2);
                this.fLk.CB().getView().setVisibility(0);
                this.fLk.CB().Eo();
            }
            rn(8);
            rm(8);
        } else {
            if (this.fLk != null && this.fLk.CA() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fLk.CA().getView().getLayoutParams();
                layoutParams3.bottomMargin = bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fLk.CA().getView().setLayoutParams(layoutParams3);
            }
            if (this.fLk != null && this.fLk.CB() != null) {
                this.fLk.CB().hide();
            }
            rn(0);
            rm(0);
        }
        if (this.fXF != null) {
            this.fXF.H(false, z);
        }
        if (this.fLl != null) {
            this.fLl.CJ();
        }
        if (this.fYh != null) {
            this.fYh.onKeyboardVisibilityChanged(z);
        }
        if (this.fLk != null) {
            int cm = com.baidu.live.aa.a.cm(z);
            if (bzF().fTn.indexOfChild(this.fLk.CA().getView()) != -1 && this.fLk.CA().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fLk.CA().getView().getLayoutParams();
                layoutParams4.height = cm;
                this.fLk.CA().getView().setLayoutParams(layoutParams4);
            }
            this.fLk.CA().Cz();
        }
        this.mHandler.post(this.fYK);
    }

    private void rm(int i) {
        if (this.fKi != null) {
            this.fKi.qZ(i);
        }
        if (this.fXQ != null) {
            this.fXQ.setVisibility(i);
        }
        if (this.fKY != null) {
            this.fKY.getView().setVisibility(i);
        }
        if (this.fXJ != null) {
            this.fXJ.setVisible(i);
        }
        if (this.fXI != null) {
            this.fXI.setVisibility(i);
        }
        if (this.fKn != null) {
            this.fKn.setVisible(i);
        }
        if (this.fLI != null) {
            this.fLI.setCanVisible(i == 0);
        }
        if (this.fLv != null) {
            this.fLv.setVisible(i);
        }
        if (this.fLF != null) {
            this.fLF.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bzF().fTQ.errCode = 1;
            bDK();
        } else if (i == -5) {
            bDL();
        } else if (i == -2) {
            Cy(bzF().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bzF().fTM.stopRecord();
        } else if (i == -3 && this.fXF != null) {
            this.fXF.kJ(false);
        }
        if (i == -4) {
            if (this.fXF == null || this.fXF.getView().getParent() == null) {
                bzF().f((short) 1);
                return;
            }
            this.fXF.bBc();
            this.fXY.setVisibility(0);
            if (this.fXK != null) {
                this.fXK.lu(true);
            }
            bzF().fTn.setBackgroundColor(bzF().pageContext.getResources().getColor(17170445));
            bDX();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bzf();
        if (i == 12001) {
            if (i2 == -1) {
                Cz(L(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                M(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aWJ();
        }
    }

    public void onResume() {
        if (this.fXF != null) {
            this.fXF.onResume();
        }
        if (this.fYj && this.fYi != null) {
            this.fYj = false;
            c(this.fYi);
        }
        if (this.fLx != null) {
            this.fLx.onResume();
        }
    }

    public void g(short s) {
        if (this.fLj != null) {
            this.fLj.yw();
        }
        if (this.fLk != null) {
            this.fLk.a(null);
            this.fLk.BZ();
        }
        if (this.fLl != null) {
            this.fLl.BZ();
        }
        if (this.fYA != null) {
            this.fYA.bzI();
        }
    }

    public boolean bDr() {
        q Fk = bzF().fTm.Fk();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fNw.fTS.i(Fk);
            if (Fk != null && Fk.mLiveInfo.live_status != 1) {
                bDV();
                bzF().pageContext.getPageActivity().finish();
                if (bzF().fTm != null && bzF().fTm.Fk() != null) {
                    a(Fk, 1, bzF().fTm.bFv() != 1 ? bzF().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.fLk != null) {
                this.fLk.CA().a(String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), true, String.valueOf(Fk.avj.userId));
            }
            if (this.fLl != null) {
                this.fLl.a(Fk);
            }
            if (this.fKY != null) {
                this.fKY.a(bzF().fTm.Fk());
            }
            if (this.fKi != null) {
                this.fKi.t(Fk);
            }
            if (Fk != null) {
                if (this.fXH != null) {
                    this.fXH.p(Fk);
                }
                if (this.fYA != null) {
                    this.fYA.a(Fk);
                }
                if (this.fLn != null && Fk.mLiveInfo != null) {
                    this.fLn.a(Fk.mLiveInfo);
                }
                if (this.fLI != null) {
                    this.fLT = this.fLI.m(Fk);
                }
                if (this.fKn != null) {
                    this.fKn.kj(this.fLT);
                    this.fKn.h(Fk);
                    this.fKn.updateView();
                }
                if (this.fLF != null) {
                    this.fLF.a(Fk);
                }
                if (Fk.mLiveInfo.live_status != 1) {
                    bDV();
                    bzF().pageContext.getPageActivity().finish();
                    if (bzF().fTm != null && bzF().fTm.Fk() != null) {
                        a(Fk, 1, bzF().fTm.bFv() != 1 ? bzF().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.fYB) {
                    if (this.fYb.getVisibility() == 8) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
                    }
                    this.fYb.setVisibility(0);
                    if (!this.fYz && Fk.mLiveInfo != null) {
                        this.fYz = true;
                        com.baidu.live.utils.o.a(Fk.mLiveInfo.feed_id, Fk.mLiveInfo.live_id, true, false);
                    }
                } else {
                    this.fYb.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bDs() {
        bDi();
    }

    public void bDt() {
        if (this.fYx != null) {
            this.fYx.bAW();
        }
    }

    public void bDu() {
        if (this.fXF != null && this.fXF.getVisibility() != 8) {
            if (bzF().bBi() == 2) {
                bDX();
            } else {
                bDW();
            }
        }
        if (this.fXF != null && this.fXF.getVisibility() != 8) {
            if (bzF().bBi() == 1) {
                this.fXF.onResume();
            }
            this.fXF.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.fLO && this.fYe != null) {
            if (this.fLk != null) {
                this.fLk.CA().getView().setVisibility(0);
            }
            if (this.fLk != null) {
                this.fLk.CB().show();
                this.fLk.CB().setEditText(" @" + this.fYe.getNameShow() + " ");
            }
            rn(8);
            this.fLO = false;
        }
        if (this.fLu != null) {
            this.fLu.resume();
        }
        if (this.fYD != null) {
            this.fYD.resume();
        }
        if (this.fYE != null) {
            this.fYE.resume();
        }
    }

    public void onPause() {
        if (this.fLu != null) {
            this.fLu.pause();
        }
        if (this.fYD != null) {
            this.fYD.pause();
        }
        if (this.fLx != null) {
            this.fLx.onPause();
        }
        if (this.fYE != null) {
            this.fYE.pause();
        }
    }

    private void bDv() {
        this.fXP = (RelativeLayout) bzF().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.fXR = (RelativeLayout) bzF().rootView.findViewById(a.g.under_live_view_panel);
        this.fXS = (RelativeLayout) bzF().rootView.findViewById(a.g.over_live_view_panel);
        this.fNw.fTn.setOnLiveViewScrollListener(this.fZa);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fXR.setVisibility(8);
            this.fXS.setVisibility(8);
            bzF().fTn.removeAllViews();
            return;
        }
        this.fXQ = (RelativeLayout) bzF().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXQ.getLayoutParams();
        layoutParams.topMargin = this.fNw.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fNw.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fXQ.setLayoutParams(layoutParams);
        if (this.fKl == null) {
            this.fKl = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.fNw.pageContext.getPageActivity(), false);
        }
        this.fKl.a(this.fKN);
        this.fKl.a(this.fXQ, a.g.ala_live_room_host_header_stub, 1L);
        this.fKl.setVisible(0);
        this.fXY = (ImageView) bzF().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.fXY.setOnClickListener(this.fYR);
        this.fYa = (ImageView) bzF().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.fYa.setOnClickListener(this.fYR);
        if (com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAG != null && com.baidu.live.v.a.Ge().aYP.aAG.ws() && av.b(com.baidu.live.v.a.Ge().aYP)) {
            this.fYa.setVisibility(0);
        } else {
            this.fYa.setVisibility(8);
        }
        if (av.c(com.baidu.live.v.a.Ge().aYP)) {
            this.fXY.setVisibility(0);
            if (av.c(com.baidu.live.v.a.Ge().aYP)) {
                this.fXY.setAlpha(0.2f);
            }
        } else if (bzF().fTM.hasBeauty() < 0) {
            this.fXY.setVisibility(8);
        } else {
            if (av.c(com.baidu.live.v.a.Ge().aYP)) {
                this.fXY.setAlpha(0.2f);
            }
            com.baidu.live.c.uN().getInt("live_beauty_level", 3);
        }
        this.fXX = (ImageView) bzF().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.fXX.setOnClickListener(this.fYR);
        this.fXV = (ImageView) bzF().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.fXV.setOnClickListener(this.fYR);
        this.fNE = (ImageView) bzF().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.fNE.setOnClickListener(this.fYR);
        this.fXW = (ImageView) bzF().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.fXW.setOnClickListener(this.fYR);
        this.fXZ = (ImageView) bzF().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.fXZ.setOnClickListener(this.fYR);
        this.fYb = bzF().rootView.findViewById(a.g.host_goods_layout);
        this.fYc = (ImageView) bzF().rootView.findViewById(a.g.host_goods_imageView);
        this.fYd = (TextView) bzF().rootView.findViewById(a.g.host_goods_num_textView);
        this.fYc.setOnClickListener(this.fYR);
        bDy();
        if (av.b(com.baidu.live.v.a.Ge().aYP)) {
            this.fYx = new com.baidu.tieba.ala.liveroom.g.b(bzF().rootView, bzF(), bzF().fTM);
        }
        this.fLj = new o();
        bDw();
        bDx();
    }

    private void bDw() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bzF().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fLk = (k) runTask.getData();
            this.fLk.setFromMaster(true);
            this.fLk.CA().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bzF().pageContext.getPageActivity()) * 0.75f), com.baidu.live.aa.a.cm(false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.aa.a.cn(true);
            bzF().fTn.addView(this.fLk.CA().getView(), layoutParams);
            this.fLk.CB().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bzF().fTn.addView(this.fLk.CB().getView(), layoutParams2);
            this.fLk.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                @Override // com.baidu.live.im.k.a
                public boolean CC() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void CD() {
                }

                @Override // com.baidu.live.im.k.a
                public void fq(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void CE() {
                }

                @Override // com.baidu.live.im.k.a
                public void CF() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean CG() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int CH() {
                    return 0;
                }
            });
        }
    }

    private void bDx() {
        View CI;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, l.class, bzF().pageContext);
        if (runTask != null) {
            this.fLl = (l) runTask.getData();
        }
        if (this.fLl != null && (CI = this.fLl.CI()) != null && this.fNw.fTn.indexOfChild(CI) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.fNw.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bzF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bzF().fTn.addView(CI, layoutParams);
        }
    }

    private void bDy() {
        CustomResponsedMessage runTask;
        if (this.fYf == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bzF().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fYf = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bDz() {
        View xY;
        v.b(bzF().pageContext, true);
        if (this.fLm == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aDG = true;
            fVar.context = bzF().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLm = (w) runTask.getData();
                if (this.fLm != null && (xY = this.fLm.xY()) != null && bzF().fTn.indexOfChild(xY) < 0) {
                    if (xY.getParent() instanceof ViewGroup) {
                        ((ViewGroup) xY.getParent()).removeView(xY);
                    }
                    bzF().fTn.addView(xY, bzF().fTn.getLayoutParams());
                }
            }
        }
    }

    protected void byN() {
        View yq;
        if (this.fLn == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aDG = true;
            aVar.context = bzF().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLn = (u) runTask.getData();
            }
        }
        if (this.fLn != null && (yq = this.fLn.yq()) != null) {
            if (bzF().fTn.indexOfChild(yq) < 0) {
                if (yq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) yq.getParent()).removeView(yq);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bzF().fTn.addView(yq, layoutParams);
            }
            yq.bringToFront();
        }
    }

    protected void byM() {
        View yx;
        if (this.fLx == null) {
            ab abVar = new ab();
            abVar.aDG = true;
            abVar.pageContext = bzF().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLx = (y) runTask.getData();
            }
        }
        if (this.fLx != null && (yx = this.fLx.yx()) != null && bzF().fTn.indexOfChild(yx) < 0) {
            if (yx.getParent() instanceof ViewGroup) {
                ((ViewGroup) yx.getParent()).removeView(yx);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bzF().fTn.addView(yx, layoutParams);
        }
    }

    private void bDA() {
        bDE();
        bxO();
        bDD();
        bzF().fTn.setVisibility(0);
        rn(0);
    }

    private void bDB() {
        if (this.fXJ == null) {
            this.fXJ = new com.baidu.tieba.ala.liveroom.r.a(bzF().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.fXJ.a(bzF().bBi(), j, TbadkCoreApplication.getCurrentAccountName(), true, bzF().fTm.Fk().avj.portrait, this.otherParams, "", -1L);
        this.fXJ.ao(bzF().fTn);
    }

    private void bDC() {
        if (this.fYh == null) {
            com.baidu.live.w.a ey = ey(bzF().pageContext.getPageActivity());
            if (ey != null) {
                this.fYh = ey;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bzF().pageContext.getPageActivity());
                if (runTask != null) {
                    this.fYh = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.fYh != null) {
                this.fYh.m(this.fXR);
                this.fYh.n(this.fXS);
                this.fYh.cG((bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.fLc != null) {
                    this.fYh.cF(this.fLc.bHx());
                }
                this.fYh.o(bzF().fTn);
                this.fYh.a(this.fJq);
                this.fYh.setLiveShowInfo(bzF().fTm.Fk());
                this.fYh.a(this.fKn);
                this.fYh.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void Gp() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void Gq() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void a(com.baidu.live.w.b bVar) {
                        if (AlaMasterLiveRoomOpearator.this.bzF().fTM != null && bVar != null) {
                            if (bVar.bitmap == null) {
                                AlaMasterLiveRoomOpearator.this.bzF().fTM.onStickerItemSelected(null);
                                return;
                            }
                            Sticker sticker = new Sticker();
                            sticker.setBitmap(bVar.bitmap);
                            AlaMasterLiveRoomOpearator.this.bzF().fTM.onStickerItemSelected(sticker);
                        }
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void G(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bzF().fTM != null) {
                            AlaMasterLiveRoomOpearator.this.bzF().fTM.onStickerItemSelected(obj);
                        }
                    }
                });
            }
        }
    }

    private com.baidu.live.w.a ey(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).ap(context);
        }
        return null;
    }

    private void bDD() {
        if (this.fXL == null) {
            this.fXL = new b(bzF().pageContext, bzF().fTn);
        }
    }

    private void bDE() {
        if (this.fKi == null) {
            this.fKi = new com.baidu.tieba.ala.liveroom.l.a(bzF().pageContext, true, this.fYV);
            this.fKi.c(this.fXP, (q) null);
            this.fKi.a(this.fKN);
        }
        if (this.fXG == null) {
            this.fXG = new com.baidu.tieba.ala.liveroom.l.a(bzF().pageContext, true, null);
            this.fXG.a(this.fXQ, null, a.g.ala_live_room_host_header_stub);
            this.fXG.bCv();
        }
    }

    protected void byv() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bFl = bzF().fTm.bFl();
        boolean z2 = com.baidu.live.v.a.Ge().aWF.ayv;
        if (bFl == null || bFl.avN) {
            z = z2;
        }
        if (z && this.fKY == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bzF().pageContext)) != null) {
            this.fKY = (com.baidu.live.h.a) runTask.getData();
            if (this.fKY != null) {
                this.fKY.setIsHost(true);
                this.fKY.ct(1);
                View view = this.fKY.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bzF().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bzF().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.fXQ.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(q qVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.fKn == null) {
            this.fKn = new com.baidu.tieba.ala.liveroom.activeview.b(bzF().pageContext);
        }
        this.fKn.setOtherParams(this.otherParams);
        this.fKn.b(qVar, false);
        this.fKn.setHost(true);
        this.fKn.a(1, bzF().fTn, qP(1));
        this.fKn.a(2, bzF().fTn, qP(2));
        this.fKn.kj(this.fLT);
        this.fKn.setVisible(this.fXE ? 8 : 0);
        this.fKn.a(this.fJq);
        if (this.fJq != null) {
            if (this.fKn != null) {
                alaActiveRootView2 = this.fKn.qK(1);
                alaActiveRootView = this.fKn.qK(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.fJq.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.fJq.a(alaActiveRootView);
            }
        }
    }

    private void u(q qVar) {
        CustomResponsedMessage runTask;
        if (this.fLI == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bzF().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fLI = (com.baidu.live.q.a) runTask.getData();
            if (this.fLI != null) {
                this.fLI.a(bzF().fTn, kY(false));
            }
        }
        if (this.fLI != null) {
            this.fLT = this.fLI.m(qVar);
            this.fLI.setCanVisible(!this.fXE);
        }
    }

    protected void bDF() {
        CustomResponsedMessage runTask;
        if (bzF() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bzF().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fLF = (com.baidu.live.i.a) runTask.getData();
            this.fLF.a(bzF().fTn, bDG());
            if (bzF().fTm != null) {
                this.fLF.a(bzF().fTm.Fk());
            }
            this.fLF.setCanVisible(true);
            this.fLF.bC(false);
            this.fLF.a(bzF().fTm.btj());
        }
    }

    private void byF() {
        this.fYE = new com.baidu.tieba.ala.liveroom.n.c(bzF().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bDG() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bzF().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.fLv != null && this.fLv.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fXJ != null && this.fXJ.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams qP(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bzF().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.fXO != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bzF().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup.LayoutParams kY(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bzF().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.fYA != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.fYA.aW(true) + bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fXO != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void bxO() {
        if (this.fXI == null) {
            this.fXI = new com.baidu.tieba.ala.liveroom.b.a(bzF().pageContext, true);
        }
    }

    private void bDH() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bzF().pageContext.getPageActivity();
            this.fMR = new ImageView(pageActivity);
            this.fMR.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.fMR.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fMR.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bzF().rootView.addView(this.fMR, layoutParams);
            this.fMR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bDT();
                }
            });
            this.fMR.setVisibility(8);
        }
    }

    private void byD() {
        this.fLu = new com.baidu.tieba.ala.liveroom.f.a(bzF().pageContext);
    }

    private void byR() {
        if (this.fLv == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bzF().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fLv = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.fLv.setHost(true);
        this.fLv.setOtherParams(this.otherParams);
        if (bzF().fTm.Fk() != null && bzF().fTm.Fk().avj != null && bzF().fTm.Fk().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fLv.a(bzF().fTn, layoutParams, bzF().fTm.Fk());
        }
    }

    private void bDI() {
        CustomResponsedMessage runTask;
        if (this.fYC == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bzF().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.fYC = (com.baidu.live.b.a) runTask.getData();
            if (this.fYC != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bzF().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fYC.a(bzF().fTn, layoutParams);
            }
        }
        if (this.fYC != null) {
            this.fYC.a(bzF().fTm.Fk());
        }
    }

    private void bDJ() {
        CustomResponsedMessage runTask;
        if (this.fYD == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bzF().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.fYD = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fYA != null) {
            this.fYA.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bzF().pageContext.registerListener(this.fMe);
        bzF().pageContext.registerListener(this.fYL);
        bzF().pageContext.registerListener(this.fMg);
        bzF().pageContext.registerListener(this.fMh);
        bzF().pageContext.registerListener(this.fYS);
        bzF().pageContext.registerListener(this.bfX);
        bzF().pageContext.registerListener(this.fIc);
        bzF().pageContext.registerListener(this.fYT);
        bzF().pageContext.registerListener(this.fMf);
        bzF().pageContext.registerListener(this.fKI);
        bzF().pageContext.registerListener(this.fZc);
        bzF().pageContext.registerListener(this.fZd);
        bzF().pageContext.registerListener(this.fZe);
        bzF().pageContext.registerListener(this.fMm);
        bzF().pageContext.registerListener(this.fYP);
        bzF().pageContext.registerListener(this.fYQ);
        bzF().pageContext.registerListener(this.fYM);
        bzF().pageContext.registerListener(this.aWm);
        bzF().pageContext.registerListener(this.aWn);
        bzF().pageContext.registerListener(this.fYN);
        bzF().pageContext.registerListener(this.fMo);
        bzF().pageContext.registerListener(this.fMn);
        bzF().pageContext.registerListener(this.fMp);
        bzF().pageContext.registerListener(this.fYO);
        bzF().pageContext.registerListener(this.fYN);
        bzF().pageContext.registerListener(this.aTv);
        bzF().pageContext.registerListener(this.aRd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (av.c(com.baidu.live.v.a.Ge().aYP)) {
            bzF().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bzF().fTP.va() == null || ListUtils.isEmpty(bzF().fTP.va().asJ)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bzF().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.fYF) {
                this.fYG = BdUniqueId.gen();
                bzF().fTP.a(this.fYG);
                this.fYF = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bzF().pageContext.getPageActivity(), bzF().rootView);
            rn(8);
            if (bzF().fTM.hasAdvancedBeauty() && this.fYx != null) {
                if (!this.fYH || this.fXF.getVisibility() == 0) {
                    this.fYx.a(bzF().fTM.getVideoConfig());
                }
                this.fYx.a(bzF().fTM.getVideoConfig(), this.fYy);
                if (!this.fYy) {
                    this.fYy = true;
                }
            }
            if (z && this.fLk != null) {
                this.fLk.CA().getView().setVisibility(4);
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
            if (TbadkCoreApplication.getInst().isOther() && !TextUtils.isEmpty(TbConfig.getSubappName())) {
                return TbConfig.getSubappName();
            }
            return activity.getResources().getString(a.i.sdk_permission_app_type_tb_text);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDK() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bzF().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bzF().f((short) 1);
            }
        });
        bdAlertDialog.create(bzF().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDL() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bzF().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bzF().f((short) 1);
            }
        });
        bdAlertDialog.create(bzF().pageContext).show();
    }

    private void Cy(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bzF().f((short) 1);
            }
        });
        bdAlertDialog.create(bzF().pageContext).show();
    }

    public void bDM() {
        byv();
        com.baidu.live.data.k btj = bzF().fTm.btj();
        int i = 5;
        if (btj != null) {
            i = (int) btj.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() != null && AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bzF().fTm.f(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (btj != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fNw.fTS.b(btj);
                return;
            }
            if (this.fKh == null) {
                this.fKh = new com.baidu.tieba.ala.liveroom.audiencelist.c(bzF().pageContext, this.fYV, true);
            }
            if (this.fYv) {
                this.fYv = false;
                this.fKh.a(String.valueOf(bzF().fTm.Fk().mLiveInfo.group_id), String.valueOf(bzF().fTm.Fk().mLiveInfo.live_id), String.valueOf(bzF().fTm.Fk().avj.userId), bzF().fTm.Fk());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.fKY != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.fKh.c(this.fXQ, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.fKh.e(btj);
            this.fKl.setVisible(0);
            this.fKl.dm(btj.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWJ() {
        if (bzF().fTm != null) {
            if (this.fKZ == null) {
                this.fKZ = new c(bzF().pageContext);
            }
            this.fKZ.c(bzF().fTm.Fk(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bzF().fTm != null && bzF().fTm.Fk() != null && bzF().fTm.Fk().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bzF().fTm.Fk().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bzF().fTm.Fk().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bzF().fTm.Fk().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bzF().fTm != null && bzF().fTm.Fk() != null && bzF().fTm.Fk().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bzF().fTm.Fk().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bzF().fTm.Fk().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bzF().fTm.Fk().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bDO() {
        return this.fXD;
    }

    private void la(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(fXC, z);
        this.fXD = z;
    }

    private void bDP() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.bzF().pageContext).bER();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bzF().pageContext).show();
    }

    private void bDQ() {
        if (this.fXm && bzF().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bzF().fTR.GV();
        }
        bzF().fTQ.prepareTime = System.currentTimeMillis() - bzF().fTQ.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bzF().fTm != null && bzF().fTm.Fk() != null && bzF().fTm.Fk().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bzF().fTm.Fk().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bzF().fTm.Fk().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bzF().fTQ.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fXF != null && this.fXF.getView().getParent() != null) {
            this.fXF.setVisibility(8);
            bzF().rootView.removeView(this.fXF.getView());
            this.fXF.release();
        }
        if (this.fYx != null) {
            this.fYx.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bzF().fTn.indexOfChild(this.fXN) < 0) {
            bzF().fTn.addView(this.fXN, layoutParams);
        }
        this.fXN.rD(1000);
    }

    private void bzf() {
        if (bzF().bBi() == 1) {
            bzF().fTM.startRecord();
        }
    }

    private void Cz(String str) {
        CA(str);
    }

    private void CA(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bzF().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String L(Intent intent) {
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

    private void M(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.fXF != null) {
            this.fXF.Co(fromJson.getSmallurl());
        }
    }

    private boolean bDR() {
        return com.baidu.live.c.uN().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        com.baidu.live.c.uN().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.fNw.fTM.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDT() {
        int i = a.i.live_close_confirm;
        if (this.fYA != null && this.fYA.bzK()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.fYA != null && this.fYA.bzJ()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzF().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(i);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                }
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk(), 0, AlaMasterLiveRoomOpearator.this.bzF().fTm.bFv() != 1 ? AlaMasterLiveRoomOpearator.this.bzF().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                } else {
                    AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bzF().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (qVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = qVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = qVar.avj;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bzF().fTm.dI(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.fYt) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bzF().fTQ;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bzF().fTM.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.fYp;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.fYq;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.fYl;
            if (this.fYm != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.fYn - this.fYo) / this.fYm) * 100.0f;
            }
            Intent intent = new Intent(bzF().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bzF().fTm != null && bzF().fTm.Fk() != null && bzF().fTm.Fk().avj != null) {
                String str3 = bzF().fTm.Fk().avj.nickName;
                String str4 = bzF().fTm.Fk().avj.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            q Fk = bzF().fTm.Fk();
            if (Fk != null && Fk.avj != null && !TextUtils.isEmpty(Fk.avj.portrait)) {
                intent.putExtra("host_portrait", Fk.avj.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.fYr = intent;
                this.fYs = s;
                bzF().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bDU() {
        if (this.fYr != null) {
            a(this.fYr, this.fYs);
            this.fYr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.fYt = true;
        if (this.fYA != null) {
            this.fYA.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.fHR);
            bzF().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bzF().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDV() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fNw.fTS != null && this.fNw.fTS.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.fYA != null && this.fYA.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bzF().fTO.bEC()) {
                bDT();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.fXO != null) {
                this.fXO.setVisibility(4);
                return;
            }
            return;
        }
        if (this.fXO != null) {
            this.fXO.a(i, z, i2, z2);
        }
        if (this.fNw != null && this.fNw.fTm != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cGo != i3) {
                this.cGo = i3;
                if (this.fXM == null) {
                    this.fXM = new com.baidu.tieba.ala.liveroom.tippop.a(this.fNw.pageContext, null);
                }
                switch (this.cGo) {
                    case 0:
                        this.fXM.a(this.fNw.rootView, this.fNw.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.fXM.a(this.fNw.rootView, this.fNw.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.fXM.a(this.fNw.rootView, this.fNw.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.fNw.fTm.j(this.fNw.fTm.Fk().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x(com.baidu.live.im.data.a aVar) {
        String str;
        String str2;
        final String str3;
        JSONObject jSONObject;
        if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                String optString = jSONObject.optString("content_type");
                try {
                    str3 = jSONObject.optString("text");
                    str2 = optString;
                } catch (JSONException e) {
                    str = optString;
                    str2 = str;
                    str3 = null;
                    if (!"close_live".equals(str2)) {
                    }
                }
            } catch (JSONException e2) {
                str = null;
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bDV();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0586, code lost:
        Cf(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        final String str;
        String str2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        long j;
        long j2;
        long j3;
        String str3;
        String str4;
        if (aVar.getMsgType() == 125) {
            if (this.fXK != null) {
                this.fXK.z(aVar);
            }
        } else if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject4 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject4 = new JSONObject(aVar.getContent());
                }
                try {
                    String optString = jSONObject4.optString("content_type");
                    try {
                        String optString2 = jSONObject4.optString("text");
                        try {
                            String optString3 = jSONObject4.optString("ext");
                            if (!TextUtils.isEmpty(optString3)) {
                                new JSONObject(new String(Base64.decode(optString3.getBytes(), 0)));
                            }
                            jSONObject3 = jSONObject4.optJSONObject("ext_data");
                            jSONObject2 = jSONObject4;
                            str = optString2;
                            str2 = optString;
                        } catch (JSONException e) {
                            jSONObject = jSONObject4;
                            str = optString2;
                            str2 = optString;
                            jSONObject2 = jSONObject;
                            jSONObject3 = null;
                            if (this.fYA != null) {
                            }
                            if (!"close_live".equals(str2)) {
                            }
                        }
                    } catch (JSONException e2) {
                        jSONObject = jSONObject4;
                        str = null;
                        str2 = optString;
                    }
                } catch (JSONException e3) {
                    jSONObject = jSONObject4;
                    str = null;
                    str2 = null;
                }
            } catch (JSONException e4) {
                jSONObject = null;
                str = null;
                str2 = null;
            }
            if (this.fYA != null) {
                this.fYA.en(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bDV();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bzF().fTm.Fk(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bzF().fTm.Fk() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzF().fTm.Fk().avC.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzF().fTm.Fk().avC.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bzF().fTm.Fk().avC.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bzF().fTm.Fk() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bzF().fTm.Fk() != null && bzF().fTm.Fk().avj != null && bzF().fTm.Fk().avj.userId == optLong2) {
                        bzF().fTm.Fk().avj.isUegBlock = 1;
                        byb();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bzF().fTm.Fk() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bzF().fTm.Fk() != null && bzF().fTm.Fk().avj != null && bzF().fTm.Fk().avj.userId == optLong3) {
                        bzF().fTm.Fk().avj.isUegBlock = 0;
                        byb();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.fYf != null) {
                    this.fYf.G(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.fXL.aE(optString4, optInt2);
                    }
                    if (this.fKl.getCount() > 20) {
                        this.fKl.dm(this.fKl.getCount() + 1);
                    } else if (this.fKh != null) {
                        com.baidu.live.data.a DB = aVar.DB();
                        j jVar = new j();
                        jVar.avk = new AlaLocationData();
                        jVar.avl = new AlaRelationData();
                        jVar.avj = new AlaLiveUserInfoData();
                        jVar.avj.userId = JavaTypesHelper.toLong(DB.userId, 0L);
                        jVar.avj.userName = DB.userName;
                        jVar.avj.portrait = DB.portrait;
                        if (this.fKh.c(jVar)) {
                            this.fKl.dm(this.fKl.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bzF().fTm.Fk() != null && bzF().fTm.Fk().mLiveInfo != null) {
                    String str5 = bzF().fTm.Fk().mLiveInfo.feed_id;
                    long j4 = bzF().fTm.Fk().mLiveInfo.live_id;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!m.i(j4, optLong4)) {
                        com.baidu.live.utils.o.a(str5, j4, true, false);
                        m.j(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bzF() != null && bzF().fTm != null && bzF().fTm.Fk() != null && bzF().fTm.Fk().avC != null && bzF().fTm.Fk().avC.userId == jSONObject2.optLong("user_id")) {
                    bzF().fTm.bFk();
                }
            } else if ("official_notice".equals(str2)) {
                if (jSONObject2 != null) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str6 = optLong5 + "";
                        TbadkCoreApplication.getInst();
                        if (str6.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                }
            } else if ("privilege_award_royal_success".equals(str2) && jSONObject2 != null) {
                String str7 = jSONObject2.optInt("effect_id") + "";
                com.baidu.live.data.a DB2 = aVar.DB();
                if (DB2 != null && v.eR(str7)) {
                    v.d(str7, 1L, "", "", DB2.userId, DB2.portrait, DB2.userName, "", "", false, "", "", "", false, false, true, -1L);
                }
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a DB3 = aVar.DB();
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
                long optLong6 = jSONObject5.optLong("charm_total");
                String optString9 = jSONObject5.optString("attach");
                String optString10 = jSONObject5.optString("attach_new");
                String optString11 = jSONObject5.optString("gift_mul");
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                String str8 = null;
                if (bzF().fTm != null && bzF().fTm.Fk() != null && bzF().fTm.Fk().mLiveInfo != null) {
                    j5 = bzF().fTm.Fk().mLiveInfo.live_id;
                    j6 = bzF().fTm.Fk().mLiveInfo.group_id;
                    j7 = bzF().fTm.Fk().avj.userId;
                    str8 = bzF().fTm.Fk().mLiveInfo.appId;
                    if (bzF().fTm.Fk().mLiveSdkInfo.mCastIds != null) {
                        String str9 = bzF().fTm.Fk().mLiveSdkInfo.mCastIds.avv;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bzF().fTm.Fk().mLiveSdkInfo.mCastIds.avw;
                        str4 = str9;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || bzF().bBi() != 2) {
                            if (TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    v.b(optString11, DB3.userId, DB3.portrait, DB3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str8, optString10, "", "", aVar.getMsgId());
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString11);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.v.d.Gl().fC(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                v.b(optString5, Integer.parseInt(optString6), optString7, optString8, DB3.userId, DB3.portrait, DB3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str8, optString9, str4, str3, aVar.getMsgId());
                            }
                        }
                        Cf(optString5);
                        com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
                        dVar.fSK = optLong6;
                        dVar.liveId = j3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
                    }
                }
                j = j7;
                j2 = j6;
                j3 = j5;
                str3 = "";
                str4 = "";
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                if (this.isBackground) {
                }
                if (TextUtils.isEmpty(optString10)) {
                }
                v.b(optString5, Integer.parseInt(optString6), optString7, optString8, DB3.userId, DB3.portrait, DB3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str8, optString9, str4, str3, aVar.getMsgId());
                Cf(optString5);
                com.baidu.tieba.ala.liveroom.e.d dVar2 = new com.baidu.tieba.ala.liveroom.e.d();
                dVar2.fSK = optLong6;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void Cf(String str) {
        if (this.fKn != null) {
            this.fKn.Cf(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(int i) {
        View findViewById = bzF().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.fKn != null) {
            this.fKn.bt(2, i);
        }
    }

    private void bDW() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bzF().fTM != null && AlaMasterLiveRoomOpearator.this.bzF().fTM.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bzF().fTM.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bzF().fTM.startRecord();
                }
            }
        });
    }

    private void bDX() {
        if (bzF().fTM != null && bzF().fTM.getPreview() != null) {
            bzF().fTM.getPreview().setVisibility(8);
            bzF().fTM.stopRecord();
        }
    }

    public void bDY() {
        this.fTJ = bzF().fTm.bFw();
        if (this.fXF != null) {
            this.fXF.kK(this.fTJ);
        }
    }

    public void bBg() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bDZ();
        } else if (this.fXF != null) {
            this.fXF.bBg();
        }
    }

    public void kL(boolean z) {
        if (this.fXF != null) {
            this.fXF.kL(z);
        }
    }

    public void onDestroy() {
        if (this.fYk != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.fYk);
        }
        this.fYk = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fYx != null) {
            this.fYx.kI(true);
        }
        this.fYx = null;
        if (this.fXF != null) {
            this.fXF.destroy();
            bzF().rootView.removeView(this.fXF.getView());
            this.fXF.release();
            this.fXF = null;
        }
        if (this.fYA != null) {
            this.fYA.onDestroy();
        }
        if (this.fKZ != null) {
            this.fKZ.onDestroy();
        }
        if (this.fLb != null) {
            this.fLb.onDestroy();
        }
        if (this.fKi != null) {
            this.fKi.onDestroy();
            this.fKi = null;
        }
        if (this.fXG != null) {
            this.fXG.onDestroy();
        }
        if (this.fLx != null) {
            this.fLx.onDestroy();
            this.fLx = null;
        }
        if (this.fXN != null) {
            this.fXN.stopCountDown();
        }
        if (this.fXJ != null) {
            this.fXJ.onDestroy();
        }
        if (this.fXL != null) {
            this.fXL.onDestroy();
        }
        if (this.fYf != null) {
            this.fYf.onDestroy();
            this.fYf = null;
        }
        if (this.fLm != null) {
            this.fLm.onDestroy();
            this.fLm = null;
        }
        v.yt();
        com.baidu.live.entereffect.a.wD().release();
        if (this.fLn != null) {
            this.fLn.onDestroy();
            this.fLn = null;
        }
        if (this.fXM != null) {
            this.fXM.onDestroy();
        }
        if (this.fXK != null) {
            this.fXK.bHz();
            this.fXK.release();
        }
        if (this.fKl != null) {
            this.fKl = null;
        }
        if (this.fKn != null) {
            this.fKn.release();
        }
        if (this.fXH != null) {
            this.fXH.onDestroy();
        }
        if (this.fXK != null) {
            this.fXK.onDestroy();
        }
        if (this.fLl != null) {
            this.fLl.release();
        }
        if (this.fLu != null) {
            this.fLu.release();
        }
        if (this.fLv != null) {
            this.fLv.onDestroy();
        }
        if (this.fYh != null) {
            this.fYh.onDestroy();
        }
        if (this.fLI != null) {
            this.fLI.release();
        }
        if (this.fYC != null) {
            this.fYC.onDestory();
        }
        if (this.fYD != null) {
            this.fYD.release();
        }
        if (this.fLF != null) {
            this.fLF.onDestroy();
        }
        if (this.fYE != null) {
            this.fYE.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fKI);
        MessageManager.getInstance().unRegisterListener(this.fZc);
        MessageManager.getInstance().unRegisterListener(this.fZd);
        MessageManager.getInstance().unRegisterListener(this.fZe);
        MessageManager.getInstance().unRegisterListener(this.fMm);
        MessageManager.getInstance().unRegisterListener(this.fYP);
        MessageManager.getInstance().unRegisterListener(this.fYQ);
        MessageManager.getInstance().unRegisterListener(this.fYM);
        MessageManager.getInstance().unRegisterListener(this.aWm);
        MessageManager.getInstance().unRegisterListener(this.aWn);
        MessageManager.getInstance().unRegisterListener(this.fYN);
        MessageManager.getInstance().unRegisterListener(this.fMo);
        MessageManager.getInstance().unRegisterListener(this.fMn);
        MessageManager.getInstance().unRegisterListener(this.fMp);
        MessageManager.getInstance().unRegisterListener(this.fYO);
        MessageManager.getInstance().unRegisterListener(this.fYN);
        MessageManager.getInstance().unRegisterListener(this.aTv);
        MessageManager.getInstance().unRegisterListener(this.aRd);
        m.HZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpResponsedMessage httpResponsedMessage, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject2.put(PushMessageHelper.ERROR_TYPE, str);
                jSONObject.put("result", jSONObject2);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        UbcStatisticManager.getInstance().logSendResponse(new UbcStatisticItem("1541", str2, UbcStatConstant.Page.AUTHOR_LIVE_ROOM, null).setContentExt(jSONObject), httpResponsedMessage, true);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fNw.fTS.a(this.fZg, this.fNw.fTN, this.fXP, alaLivePersonData);
        }
    }

    private void bDZ() {
        if (this.fYi != null) {
            this.fNw.fTQ.startTime = System.currentTimeMillis();
            this.fNw.fTQ.liveTotalTime = System.currentTimeMillis();
            this.fNw.fTQ.sampleMemAndCPU();
            this.fNw.fTO.a((short) 4, this.fYi);
        }
    }

    private ViewGroup.LayoutParams bEa() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bzF().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
