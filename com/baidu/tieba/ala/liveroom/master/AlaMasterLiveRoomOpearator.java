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
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.g.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
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
    private static final String fXr;
    private boolean aTs;
    private List<an> aWS;
    private String fHG;
    private c fJW;
    private com.baidu.tieba.ala.liveroom.l.a fJX;
    private com.baidu.live.g.a fJf;
    private com.baidu.live.h.a fKN;
    private com.baidu.tieba.ala.liveroom.share.c fKO;
    private com.baidu.tieba.ala.liveroom.o.b fKP;
    private com.baidu.tieba.ala.liveroom.guide.c fKQ;
    private com.baidu.tieba.ala.liveroom.watermark.a fKR;
    private o fKY;
    private k fKZ;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fKa;
    private com.baidu.tieba.ala.liveroom.activeview.b fKc;
    private boolean fLI;
    private l fLa;
    private w fLb;
    private u fLc;
    protected com.baidu.tieba.ala.liveroom.f.a fLj;
    protected h fLk;
    protected y fLm;
    protected com.baidu.live.i.a fLu;
    private com.baidu.live.q.a fLx;
    private ImageView fMG;
    private f fNl;
    private ImageView fNt;
    private g fNu;
    private b fXA;
    private com.baidu.tieba.ala.liveroom.tippop.a fXB;
    private AlaLiveCountDownView fXC;
    private AlaLiveStreamStatusView fXD;
    private RelativeLayout fXE;
    private RelativeLayout fXF;
    private RelativeLayout fXG;
    private RelativeLayout fXH;
    private View fXI;
    private AlaLiveFaceVerifyView fXJ;
    private ImageView fXK;
    private ImageView fXL;
    private ImageView fXM;
    private ImageView fXN;
    private ImageView fXO;
    private ImageView fXP;
    private View fXQ;
    private ImageView fXR;
    private TextView fXS;
    private ad fXT;
    private com.baidu.live.x.a fXU;
    private com.baidu.tieba.ala.liveroom.master.panel.b fXV;
    private com.baidu.live.w.a fXW;
    private e fXX;
    private boolean fXb;
    private boolean fXs;
    private d fXu;
    private com.baidu.tieba.ala.liveroom.l.a fXv;
    private com.baidu.tieba.ala.liveroom.e.c fXw;
    private com.baidu.tieba.ala.liveroom.b.a fXx;
    private com.baidu.tieba.ala.liveroom.r.a fXy;
    private com.baidu.tieba.ala.liveroom.v.a fXz;
    private short fYh;
    private com.baidu.tieba.ala.liveroom.g.b fYm;
    private boolean fYn;
    private boolean fYo;
    private com.baidu.tieba.ala.liveroom.challenge.f fYp;
    private com.baidu.live.b.a fYr;
    private com.baidu.live.b.b fYs;
    private com.baidu.tieba.ala.liveroom.n.a fYt;
    private boolean fYu;
    private BdUniqueId fYv;
    private boolean fYw;
    private boolean fXt = false;
    private boolean fLD = false;
    private Handler mHandler = new Handler();
    private boolean fXY = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver fXZ = null;
    private boolean fYa = false;
    private int fYb = 0;
    private int fYc = 0;
    private int fYd = 0;
    private long fYe = 0;
    private long fYf = 0;
    private volatile boolean isBackground = false;
    private Intent fYg = null;
    private int mOrientation = 1;
    private boolean fTy = false;
    private boolean fYi = false;
    private boolean fYj = true;
    private boolean fNr = false;
    private boolean fYk = true;
    private boolean fYl = true;
    private int cGo = 0;
    public boolean fYq = false;
    private String otherParams = "";
    private int aTu = 0;
    private int fYx = 5000;
    private boolean fYy = false;
    private Runnable fYz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.fJf != null) {
                AlaMasterLiveRoomOpearator.this.fJf.wB();
            }
        }
    };
    private CustomMessageListener aWm = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fNl.fTH != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fNl.fTH.f(list, false);
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
                if (AlaMasterLiveRoomOpearator.this.fNl.fTH != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fNl.fTH.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener fLW = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.fKP == null) {
                        AlaMasterLiveRoomOpearator.this.fKP = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    AlaMasterLiveRoomOpearator.this.fKP.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener fMd = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fLu != null) {
                AlaMasterLiveRoomOpearator.this.fLu.BO();
            }
        }
    };
    private CustomMessageListener fYA = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fLT = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Ci(str);
            }
        }
    };
    private CustomMessageListener fLU = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aWI();
        }
    };
    private CustomMessageListener fKx = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.fLc.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fMb = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener fYB = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fYs != null) {
                q Fk = AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk();
                long j = Fk.mLiveInfo.live_id;
                long j2 = Fk.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.fYs.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener fYC = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bzD().fTc);
            if (AlaMasterLiveRoomOpearator.this.fXu == null || AlaMasterLiveRoomOpearator.this.fXu.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.rl(0);
            }
            if (AlaMasterLiveRoomOpearator.this.fKZ != null) {
                AlaMasterLiveRoomOpearator.this.fKZ.CA().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.fKZ.CB().hide();
            }
        }
    };
    private CustomMessageListener fMc = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.o(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk());
        }
    };
    private CustomMessageListener fMe = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fLm != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.fLm).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fYD = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fYt != null) {
                    AlaMasterLiveRoomOpearator.this.fYt.Cm(str);
                }
            }
        }
    };
    private CustomMessageListener fYE = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.fYm != null) {
                        if (!data.asP || AlaMasterLiveRoomOpearator.this.fYv == null || !AlaMasterLiveRoomOpearator.this.fYw) {
                            if (AlaMasterLiveRoomOpearator.this.fYv != null && AlaMasterLiveRoomOpearator.this.fYv == data.asO) {
                                if (data.asJ != null && data.asJ.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.fYw || AlaMasterLiveRoomOpearator.this.fXu.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.fYm.a(AlaMasterLiveRoomOpearator.this.bzD().fTB.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.fYn = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bzD().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.fYv = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bzD().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.fYm.a(AlaMasterLiveRoomOpearator.this.bzD().fTB.getVideoConfig(), AlaMasterLiveRoomOpearator.this.fYn);
                        if (!AlaMasterLiveRoomOpearator.this.fYn) {
                            AlaMasterLiveRoomOpearator.this.fYn = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.fYu) {
                    AlaMasterLiveRoomOpearator.this.bzD().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.fYu = false;
            }
        }
    };
    private CustomMessageListener fYF = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bzD().fTB != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bzD().fTB.setBeautyJsonPath(str);
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
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.aTu == 6) {
                            AlaMasterLiveRoomOpearator.this.bDd();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.aTu = 0;
            }
        }
    };
    private View.OnClickListener fYG = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.fXL) {
                    AlaMasterLiveRoomOpearator.this.bDf();
                    AlaMasterLiveRoomOpearator.this.fXV.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.fXK) {
                    if (view == AlaMasterLiveRoomOpearator.this.fXM) {
                        AlaMasterLiveRoomOpearator.this.aWI();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.fXN) {
                        if (view != AlaMasterLiveRoomOpearator.this.fXP) {
                            if (view != AlaMasterLiveRoomOpearator.this.fNt) {
                                if (view == AlaMasterLiveRoomOpearator.this.fXO) {
                                    if (AlaMasterLiveRoomOpearator.this.fXz != null) {
                                        String str = null;
                                        String str2 = null;
                                        com.baidu.tieba.ala.liveroom.data.h bFj = AlaMasterLiveRoomOpearator.this.bzD().fTb.bFj();
                                        if (bFj != null && bFj.mLiveSdkInfo != null) {
                                            str = String.valueOf(bFj.mLiveSdkInfo.mRoomId);
                                            if (bFj.mLiveSdkInfo.mCastIds != null) {
                                                str2 = bFj.mLiveSdkInfo.mCastIds.avv;
                                            }
                                        }
                                        AlaMasterLiveRoomOpearator.this.fXz.ag("", str, str2);
                                        return;
                                    }
                                    return;
                                } else if (view == AlaMasterLiveRoomOpearator.this.fXR) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
                                    q Fk = AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk();
                                    if (AlaMasterLiveRoomOpearator.this.fLj != null && Fk != null && Fk.mLiveInfo != null) {
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
                                        AlaMasterLiveRoomOpearator.this.fLj.Cm(com.baidu.live.utils.o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7, String.valueOf(j2), Fk.mLiveInfo.user_name, String.valueOf(j3), String.valueOf(Fk.avj.userId)));
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.fYp != null) {
                                AlaMasterLiveRoomOpearator.this.fYp.bzF();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.fXW != null) {
                            AlaMasterLiveRoomOpearator.this.fXW.showDialog();
                            AlaMasterLiveRoomOpearator.this.fXW.bX(AlaMasterLiveRoomOpearator.this.bDj());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.fYw = false;
                        AlaMasterLiveRoomOpearator.this.kZ(true);
                    }
                } else if (com.baidu.live.v.a.Ge().aWF.ayB == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Ge().aWF.ayA == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.aTs) {
                        AlaMasterLiveRoomOpearator.this.bDd();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.aTu = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bDd();
                }
            }
        }
    };
    private CustomMessageListener fLV = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ad) {
                    AlaMasterLiveRoomOpearator.this.fLD = true;
                    AlaMasterLiveRoomOpearator.this.fXT = (ad) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.fKZ != null) {
                        AlaMasterLiveRoomOpearator.this.fKZ.CA().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fKZ != null) {
                        AlaMasterLiveRoomOpearator.this.fKZ.CB().show();
                        AlaMasterLiveRoomOpearator.this.fKZ.CB().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.rl(8);
                }
            }
        }
    };
    private CustomMessageListener fYH = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bzD() != null && AlaMasterLiveRoomOpearator.this.bzD().fTF != null) {
                AlaMasterLiveRoomOpearator.this.bzD().fTF.sampleMemAndCPU();
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
                    AlaMasterLiveRoomOpearator.this.bDS();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bzD().fTb.rs(i);
                if (AlaMasterLiveRoomOpearator.this.fLu != null) {
                    AlaMasterLiveRoomOpearator.this.fLu.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener fHR = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bDL();
        }
    };
    public final HttpMessageListener fYI = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Fn()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.fXV != null) {
                            AlaMasterLiveRoomOpearator.this.fXV.lg(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.fXV.bEs();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bzD().fTB.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.fXB != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.fXB.a(AlaMasterLiveRoomOpearator.this.bzD().rootView, AlaMasterLiveRoomOpearator.this.bzD().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bzD().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.fXB.rA(2);
                        AlaMasterLiveRoomOpearator.this.fXB.a(AlaMasterLiveRoomOpearator.this.bzD().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a fYJ = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bDZ() {
            AlaMasterLiveRoomOpearator.this.bDI();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bEa() {
            AlaMasterLiveRoomOpearator.this.bDJ();
        }
    };
    com.baidu.live.liveroom.a.a fYK = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean cy(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cz(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cA(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bzD().bBg() == 1) {
                AlaMasterLiveRoomOpearator.this.bzD().fTB.stopRecord();
            }
        }
    };
    private IShareCallback fYL = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.fXY && AlaMasterLiveRoomOpearator.this.fXX != null) {
                AlaMasterLiveRoomOpearator.this.fXY = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.fXX);
            }
        }
    };
    private View.OnTouchListener fYM = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bzD().fTF.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bzD().fTc);
            AlaMasterLiveRoomOpearator.this.rl(0);
            if (AlaMasterLiveRoomOpearator.this.fKZ != null) {
                AlaMasterLiveRoomOpearator.this.fKZ.CA().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.fKZ.CB().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b fYN = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEb() {
            AlaMasterLiveRoomOpearator.this.bDe();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEc() {
            AlaMasterLiveRoomOpearator.this.fXb = AlaMasterLiveRoomOpearator.this.fXu.bAY();
            AlaMasterLiveRoomOpearator.this.bzD().fTF.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bzD().fTF.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bzD().fTF.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fTv = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bzD().bBg();
            eVar.title = AlaMasterLiveRoomOpearator.this.fXu.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.fTw = AlaMasterLiveRoomOpearator.this.fXu.bAZ();
            eVar.fTz = AlaMasterLiveRoomOpearator.this.fXb;
            eVar.fTy = AlaMasterLiveRoomOpearator.this.fXu.bAW();
            eVar.fTx = AlaMasterLiveRoomOpearator.this.fXu.bBb();
            eVar.fTA = AlaMasterLiveRoomOpearator.this.fXu.bAX();
            if (eVar.fTA) {
                if (AlaMasterLiveRoomOpearator.this.fXu.bBc()) {
                    AlaMasterLiveRoomOpearator.this.fXY = true;
                    AlaMasterLiveRoomOpearator.this.fXX = eVar;
                    AlaMasterLiveRoomOpearator.this.fXu.bBd();
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
            AlaMasterLiveRoomOpearator.this.bzD().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bzD().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEd() {
            AlaMasterLiveRoomOpearator.this.fYw = true;
            AlaMasterLiveRoomOpearator.this.kZ(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bEe() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEf() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bEg() {
            com.baidu.live.utils.o.m(AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity(), "", "");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private Runnable fYO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.bzD().fTb != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo != null) {
                    m.k(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.fYO, AlaMasterLiveRoomOpearator.this.fYx);
                }
            }
        }
    };
    private CustomMessageListener aRd = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bxZ();
            }
        }
    };
    private com.baidu.live.liveroom.g.c fYP = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Fi() {
            if (AlaMasterLiveRoomOpearator.this.fXz != null) {
                AlaMasterLiveRoomOpearator.this.fXz.lu(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bT(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.fYp != null) {
                        AlaMasterLiveRoomOpearator.this.fYp.d(AlaMasterLiveRoomOpearator.this.fNt);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fXW != null) {
                        AlaMasterLiveRoomOpearator.this.fXW.setStickerCanOperate(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.fYp != null) {
                        AlaMasterLiveRoomOpearator.this.fYp.Ji();
                    }
                    if (AlaMasterLiveRoomOpearator.this.fXW != null) {
                        AlaMasterLiveRoomOpearator.this.fXW.setStickerCanOperate(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.fXz != null) {
                    AlaMasterLiveRoomOpearator.this.fXz.lu(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.fLm != null) {
                    AlaMasterLiveRoomOpearator.this.fLm.be(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a fYQ = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void Qv() {
            if (AlaMasterLiveRoomOpearator.this.fXJ != null && AlaMasterLiveRoomOpearator.this.bzD().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.fXJ) >= 0) {
                AlaMasterLiveRoomOpearator.this.bzD().rootView.removeView(AlaMasterLiveRoomOpearator.this.fXJ);
                AlaMasterLiveRoomOpearator.this.fXJ.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.fXJ = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fKC = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            q Fk;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bDR();
            } else if (i == 14 && (Fk = AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk()) != null && Fk.avj != null && Fk.mLiveInfo != null && Fk.avC != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity(), Fk.avj.userName, Long.toString(Fk.avj.userId), Long.toString(Fk.avj.charmCount), String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), true, String.valueOf(Fk.avj.userId), Long.toString(Fk.avC.userId), Fk.avC.userName, Fk.avC.portrait, AlaMasterLiveRoomOpearator.this.fKa.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Fk.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.fKa.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener fYR = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.fYq = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fZU;
            }
        }
    };
    private HttpMessageListener fYS = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
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
                    AlaMasterLiveRoomOpearator.this.fXS.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.fXS.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.fXS.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.fXS.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.aWS = getVideoGoodsListHttpResponseMessage.aWS;
                AlaMasterLiveRoomOpearator.this.a(httpResponsedMessage, (String) null, UbcStatConstant.ContentType.UBC_TYPE_GOODS_LIST_SUCC);
            }
        }
    };
    private HttpMessageListener fYT = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.bzD().fTb != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.live_id;
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
                                m.a(amVar, AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo, true);
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
                AlaMasterLiveRoomOpearator.this.fYx = i3 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a fYU = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private com.baidu.live.liveroom.middleware.g fYV = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.ase);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        fXr = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Ge().aWF != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bzD().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Ge().aWF.ayw, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzD().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bzD().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Ge().aWF.axW;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bzD().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bzD().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bzD().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxZ() {
        int i = bzD().fTb.Fk().avj.isUegBlock;
        int i2 = bzD().fTb.Fk().avj.isBlock;
        String str = bzD().fTb.Fk().avj.userName;
        if (i > 0 || i2 > 0) {
            this.aTs = true;
            this.fKZ.a(true, i, i2, str);
            return;
        }
        this.aTs = false;
        this.fKZ.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.fNl.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aTF == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aTG);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.fNl.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.fNl.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDd() {
        if (this.fKZ != null) {
            this.fKZ.CB().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.fYp != null) {
            this.fYp.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDe() {
        if (bzD() != null && bzD().fTb != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bzD().fTb.bFa();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bzD().fTb.bFb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bsL() != null && aVar.bsM() != null) {
            bzD().fTb.dH(aVar.bsL().getId(), aVar.bsM().getId());
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
                    AlaMasterLiveRoomOpearator.this.fYa = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.fYa = false;
                }
                if (AlaMasterLiveRoomOpearator.this.fYb == 0) {
                    AlaMasterLiveRoomOpearator.this.fYb = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.fYc == 0) {
                    AlaMasterLiveRoomOpearator.this.fYc = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.fYd = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bzD() != null && bzD().fTD != null) {
            bzD().fTD.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.fNl = fVar;
        this.fHG = str;
    }

    protected f bzD() {
        return this.fNl;
    }

    public int a(g gVar) {
        this.fNu = gVar;
        this.fXZ = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.fXZ, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.fXB == null) {
            this.fXB = new com.baidu.tieba.ala.liveroom.tippop.a(this.fNl.pageContext, null);
        }
        registerListener();
        this.fJf = new com.baidu.live.g.a();
        bDt();
        Long[] lArr = new Long[1];
        this.fYe = lArr[0] == null ? 0L : lArr[0].longValue();
        this.fYf = lArr[0] != null ? lArr[0].longValue() : 0L;
        bzD().fTc.setOnTouchListener(this.fYM);
        this.fXs = SharedPrefHelper.getInstance().getBoolean(fXr, false);
        this.fXC = new AlaLiveCountDownView(bzD().pageContext.getPageActivity());
        this.fXC.setCount(3);
        this.fXC.setTextColor(bzD().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.fXC.setTextSize(bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.fXC.setTypeface(Typeface.DEFAULT_BOLD);
        this.fXC.setIncludeFontPadding(false);
        this.fXC.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bEh() {
                if (AlaMasterLiveRoomOpearator.this.bzD().fTc != null) {
                    AlaMasterLiveRoomOpearator.this.bzD().fTc.removeView(AlaMasterLiveRoomOpearator.this.fXC);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDf() {
        if (this.fXV == null) {
            this.fXV = new com.baidu.tieba.ala.liveroom.master.panel.b(bzD().pageContext.getPageActivity(), bzD().bBg() == 2);
            this.fXV.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lb(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bzD().fTB.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lc(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bzD().fTB.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ld(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bzD().fTB.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bDQ();
                    if (AlaMasterLiveRoomOpearator.this.fXB != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.fXB.a(AlaMasterLiveRoomOpearator.this.bzD().rootView, AlaMasterLiveRoomOpearator.this.bzD().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.fXB.a(AlaMasterLiveRoomOpearator.this.bzD().rootView, AlaMasterLiveRoomOpearator.this.bzD().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void le(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEi() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bzD().fTb != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEj() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bzD().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEk() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bzD() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.bzD().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.fXV != null) {
                            AlaMasterLiveRoomOpearator.this.fXV.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bEl() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bzD() == null || AlaMasterLiveRoomOpearator.this.bzD().fTb == null || AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() == null || AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bzD() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.fXV != null) {
                                        AlaMasterLiveRoomOpearator.this.fXV.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fNl.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.fXV != null) {
                        AlaMasterLiveRoomOpearator.this.fXV.dismiss();
                    }
                }
            });
        }
        bDg();
    }

    private void bDg() {
        if (this.fXV != null) {
            boolean isBackCamera = bzD().fTB.isBackCamera();
            this.fXV.lf(bzD().fTB.isBackCamera());
            this.fXV.I(bzD().fTB.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bzD().fTB.isPushMirror();
            if (this.fYj) {
                isPushMirror = bDP() || isPushMirror;
                this.fYj = false;
            }
            this.fXV.J(isPushMirror, isBackCamera ? false : true);
            this.fXV.lg(bzD().fTB.isMute());
            this.fXV.bEs();
        }
    }

    public void bDh() {
        if (this.fNu != null) {
            if (this.fNu.fTI == null || this.fNu.fTI.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.fXI == null) {
                        this.fXI = this.fNl.fTH.ES();
                        this.fNl.rootView.addView(this.fXI, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.fXu == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bzD().fTb != null && bzD().fTb.Fk() != null && bzD().fTb.Fk().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bzD().fTb.Fk().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bzD().fTb.Fk().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.fXu = new d(bzD().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bzD().fTF.prepareTime = System.currentTimeMillis();
                    bzD().rootView.addView(this.fXu.getView(), layoutParams);
                    this.fXu.a(this.fYL);
                }
                this.fXu.kK(this.fTy);
                this.fXu.a(this.fYN);
                this.fXu.a(this.fYJ);
                this.fXu.a(bzD().fTB, bzD().bBg());
                return;
            }
            this.fXb = this.fNu.fTI.mLiveInfo.screen_direction == 2;
            if (this.fNu.fTI.mLiveInfo.isAudioOnPrivate == 1) {
                bzD().fTB.setMute(true);
                if (this.fXB == null) {
                    this.fXB = new com.baidu.tieba.ala.liveroom.tippop.a(this.fNl.pageContext, null);
                }
                if (!this.fXB.rz(2)) {
                    this.fXB.a(bzD().rootView, bzD().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fTv = true;
            eVar.forumId = String.valueOf(this.fNu.fTI.mLiveInfo.forum_id);
            eVar.forumName = this.fNu.fTI.mLiveInfo.forum_name;
            eVar.liveType = this.fNu.fTI.mLiveInfo.live_type;
            eVar.title = this.fNu.fTI.mLiveInfo.getLiveTitle();
            eVar.clarity = this.fNu.fTI.mLiveInfo.clarity;
            eVar.gameId = this.fNu.fTI.mLiveInfo.game_id;
            eVar.gameName = this.fNu.fTI.mLiveInfo.game_label;
            eVar.fTz = this.fNu.fTI.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bDi() {
        if (this.fYm != null) {
            this.fYm.a(bzD().fTB.getVideoConfig(), false);
        }
        if (this.fXu != null) {
            this.fXu.kJ(true);
        }
        if (bzD().fTB.hasBeauty() >= 0) {
            bzD().fTB.setBeauty(com.baidu.live.c.uN().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bzD().fTH.F(this.fNl.fTB);
        } else if (this.fXu != null) {
            this.fXu.kJ(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.fXI != null && this.fXI.getParent() != null) {
                ((ViewGroup) this.fXI.getParent()).removeView(this.fXI);
                this.fXI = null;
            }
            bzD().fTc.setVisibility(0);
            this.fNl.fTH.a(bzD().fTc);
        } else {
            bDy();
            bDO();
            this.fXz = new com.baidu.tieba.ala.liveroom.v.a(bzD().pageContext, this.fYK);
            this.fXz.d(bzD().fTc, true);
            this.fXz.lu(true);
            if (this.fKZ != null && this.fKZ.CA() != null) {
                this.fKZ.CA().setNeedTopAlphaShade(true);
            }
        }
        bzD().fTB.setPushMirror(bDP());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fNl.fTH.j(bzD().fTb.Fk());
        }
        if (!bzD().fTB.isBackground() && bzD().fTb.Fk() != null && bzD().fTb.Fk().mLiveInfo != null) {
            int startPush = bzD().fTB.startPush(bzD().fTb.Fk().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fNl.fTH.ET();
            }
            if (startPush != 0 && bzD().fTF != null) {
                bzD().fTF.errCode = 4;
                bzD().fTF.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.bBk() && !bDM()) {
                la(true);
                bDN();
            }
            if (this.fXw != null) {
                this.fXw.p(bzD().fTb.Fk());
            }
            if (this.fJX != null) {
                this.fJX.t(bzD().fTb.Fk());
            }
            if (this.fKN != null) {
                this.fKN.a(bzD().fTb.Fk());
            }
            if (this.fXx != null && bzD() != null && bzD().fTb != null) {
                if (this.fXx.ap(bzD().fTc)) {
                    this.fXx.n(bzD().fTb.Fk());
                } else {
                    this.fXx.b(bzD().fTc, bzD().fTb.Fk());
                }
            }
            if (this.fXv != null) {
                this.fXv.t(bzD().fTb.Fk());
            }
            if (hVar == null || hVar.avj == null) {
                z = com.baidu.live.c.uN().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.avj.canUseChallenge;
                com.baidu.live.c.uN().putBoolean("ala_master_can_use_challenge", z);
            }
            bDz();
            bDm();
            kX(z);
            bDA();
            bDF();
            byB();
            byP();
            u(bzD().fTb.Fk());
            f(bzD().fTb.Fk());
            bDG();
            bDH();
            bDD();
            byD();
            byK();
            byL();
            bDx();
            if (this.fKY != null) {
                this.fKY.g(bzD().fTb.Fk());
            }
            if (this.fKZ != null) {
                if (bzD().fTb.Fk() != null && bzD().fTb.Fk().avP != null && bzD().fTb.Fk().avP.vQ()) {
                    z2 = true;
                }
                this.fKZ.a(String.valueOf(bzD().fTb.Fk().mLiveInfo.group_id), String.valueOf(bzD().fTb.Fk().mLiveInfo.last_msg_id), String.valueOf(bzD().fTb.Fk().avj.userId), String.valueOf(bzD().fTb.Fk().mLiveInfo.live_id), bzD().fTb.Fk().avj.appId, z2);
            }
            if (this.fLa != null) {
                this.fLa.a(bzD().fTb.Fk(), true);
            }
            if (!this.fYy && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.fYy = true;
                this.mHandler.post(this.fYO);
            }
            this.mHandler.post(this.fYz);
        }
    }

    private void kX(boolean z) {
        if (this.fYp == null) {
            this.fYp = new com.baidu.tieba.ala.liveroom.challenge.f(bzD());
        }
        this.fYp.a(this.fNt, this.fNu);
        this.fYp.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ak akVar, al alVar, al alVar2) {
                if (AlaMasterLiveRoomOpearator.this.fKR != null) {
                    AlaMasterLiveRoomOpearator.this.fKR.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bzD().fTc.ggU = false;
                AlaMasterLiveRoomOpearator.this.bDk();
                if (AlaMasterLiveRoomOpearator.this.fLx != null) {
                    AlaMasterLiveRoomOpearator.this.fLx.b(AlaMasterLiveRoomOpearator.this.kY(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void vt() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fYz);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bzB() {
                if (AlaMasterLiveRoomOpearator.this.fKR != null) {
                    AlaMasterLiveRoomOpearator.this.fKR.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bzD().fTc.ggU = true;
                AlaMasterLiveRoomOpearator.this.bDl();
                if (AlaMasterLiveRoomOpearator.this.fLx != null) {
                    AlaMasterLiveRoomOpearator.this.fLx.b(AlaMasterLiveRoomOpearator.this.kY(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bzC() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fYz);
            }
        });
        this.fYp.F(this.fXb, z);
        this.fYp.h(this.fXb, z, (this.fNu == null || this.fNu.fTI == null || this.fNu.fTI.mChallengeData == null) ? false : true);
    }

    public boolean bDj() {
        return this.fYp != null && this.fYp.bzH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDk() {
        if (this.fXA != null) {
            this.fXA.setVisible(8);
            this.fXA.setCanVisible(false);
        }
        if (this.fKc != null) {
            this.fKc.ki(true);
            kC(true);
        }
        if (this.fXD != null) {
            this.fXD.setCanVisible(false);
            this.fXD.setVisibility(4);
        }
        if (this.fXz != null) {
            this.fXz.lt(false);
        }
        if (this.fKZ != null) {
            this.fKZ.CA().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDl() {
        if (this.fXA != null) {
            this.fXA.setCanVisible(true);
        }
        if (this.fKc != null) {
            this.fKc.ki(false);
            kC(false);
        }
        if (this.fXD != null) {
            this.fXD.setCanVisible(true);
        }
        if (this.fXz != null) {
            this.fXz.lt(true);
        }
        if (this.fKZ != null) {
            this.fKZ.CA().setNeedTopAlphaShade(false);
        }
    }

    private void kC(boolean z) {
        ViewGroup.LayoutParams qN;
        if (this.fKc != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.fKc;
            AlaLiveView alaLiveView = bzD().fTc;
            if (z) {
                qN = bDY();
            } else {
                qN = qN(1);
            }
            bVar.a(1, alaLiveView, qN, 21);
            this.fKc.updateView();
        }
    }

    private void bDm() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.fXD == null) {
            this.fXD = new AlaLiveStreamStatusView(bzD().pageContext.getPageActivity());
        }
        this.fXD.setId(a.g.ala_live_room_stream_view);
        this.fXD.setVisibility(4);
        this.fXD.setLayoutParams(layoutParams);
        if (this.fXD.getParent() == null) {
            bzD().fTc.addView(this.fXD, layoutParams);
        }
    }

    public void bDn() {
        if (this.fXu != null && this.fXu.getVisibility() != 8 && bzD().fTB.getPreview() != null) {
            bzD().fTB.stopRecord();
        }
    }

    public void bDo() {
        if (bzD().fTB.getPreview() != null) {
            bzD().fTB.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fYm != null) {
                this.fYm.kI(false);
            }
            this.fYm = new com.baidu.tieba.ala.liveroom.g.b(bzD().rootView, bzD(), bzD().fTB);
            this.fYm.a(bzD().fTB.getVideoConfig(), false);
        }
        if (this.fXB != null) {
            this.fXB.bGq();
        }
        this.mHandler.post(this.fYz);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fXt = z;
        if (z) {
            if (this.fYl) {
                this.fYl = false;
                if (this.fKZ != null && this.fKZ.CA() != null) {
                    this.fKZ.CA().getView().setBottom(0);
                }
                if (this.fKZ != null && this.fKZ.CB() != null) {
                    this.fKZ.CB().getView().setBottom(0);
                }
            }
            if (this.fKZ != null && this.fKZ.CA() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fKZ.CA().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.fKZ.CA().getView().setLayoutParams(layoutParams);
            }
            if (this.fKZ != null && this.fKZ.CB() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fKZ.CB().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.fKZ.CB().getView().setLayoutParams(layoutParams2);
                this.fKZ.CB().getView().setVisibility(0);
                this.fKZ.CB().Eo();
            }
            rl(8);
            rk(8);
        } else {
            if (this.fKZ != null && this.fKZ.CA() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fKZ.CA().getView().getLayoutParams();
                layoutParams3.bottomMargin = bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fKZ.CA().getView().setLayoutParams(layoutParams3);
            }
            if (this.fKZ != null && this.fKZ.CB() != null) {
                this.fKZ.CB().hide();
            }
            rl(0);
            rk(0);
        }
        if (this.fXu != null) {
            this.fXu.H(false, z);
        }
        if (this.fLa != null) {
            this.fLa.CJ();
        }
        if (this.fXW != null) {
            this.fXW.onKeyboardVisibilityChanged(z);
        }
        if (this.fKZ != null) {
            int cm = com.baidu.live.aa.a.cm(z);
            if (bzD().fTc.indexOfChild(this.fKZ.CA().getView()) != -1 && this.fKZ.CA().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fKZ.CA().getView().getLayoutParams();
                layoutParams4.height = cm;
                this.fKZ.CA().getView().setLayoutParams(layoutParams4);
            }
            this.fKZ.CA().Cz();
        }
        this.mHandler.post(this.fYz);
    }

    private void rk(int i) {
        if (this.fJX != null) {
            this.fJX.qX(i);
        }
        if (this.fXF != null) {
            this.fXF.setVisibility(i);
        }
        if (this.fKN != null) {
            this.fKN.getView().setVisibility(i);
        }
        if (this.fXy != null) {
            this.fXy.setVisible(i);
        }
        if (this.fXx != null) {
            this.fXx.setVisibility(i);
        }
        if (this.fKc != null) {
            this.fKc.setVisible(i);
        }
        if (this.fLx != null) {
            this.fLx.setCanVisible(i == 0);
        }
        if (this.fLk != null) {
            this.fLk.setVisible(i);
        }
        if (this.fLu != null) {
            this.fLu.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bzD().fTF.errCode = 1;
            bDI();
        } else if (i == -5) {
            bDJ();
        } else if (i == -2) {
            Cy(bzD().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bzD().fTB.stopRecord();
        } else if (i == -3 && this.fXu != null) {
            this.fXu.kJ(false);
        }
        if (i == -4) {
            if (this.fXu == null || this.fXu.getView().getParent() == null) {
                bzD().f((short) 1);
                return;
            }
            this.fXu.bBa();
            this.fXN.setVisibility(0);
            if (this.fXz != null) {
                this.fXz.lu(true);
            }
            bzD().fTc.setBackgroundColor(bzD().pageContext.getResources().getColor(17170445));
            bDV();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bzd();
        if (i == 12001) {
            if (i2 == -1) {
                Cz(L(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                M(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aWI();
        }
    }

    public void onResume() {
        if (this.fXu != null) {
            this.fXu.onResume();
        }
        if (this.fXY && this.fXX != null) {
            this.fXY = false;
            c(this.fXX);
        }
        if (this.fLm != null) {
            this.fLm.onResume();
        }
    }

    public void g(short s) {
        if (this.fKY != null) {
            this.fKY.yw();
        }
        if (this.fKZ != null) {
            this.fKZ.a(null);
            this.fKZ.BZ();
        }
        if (this.fLa != null) {
            this.fLa.BZ();
        }
        if (this.fYp != null) {
            this.fYp.bzG();
        }
    }

    public boolean bDp() {
        q Fk = bzD().fTb.Fk();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fNl.fTH.i(Fk);
            if (Fk != null && Fk.mLiveInfo.live_status != 1) {
                bDT();
                bzD().pageContext.getPageActivity().finish();
                if (bzD().fTb != null && bzD().fTb.Fk() != null) {
                    a(Fk, 1, bzD().fTb.bFt() != 1 ? bzD().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.fKZ != null) {
                this.fKZ.CA().a(String.valueOf(Fk.mLiveInfo.group_id), String.valueOf(Fk.mLiveInfo.live_id), true, String.valueOf(Fk.avj.userId));
            }
            if (this.fLa != null) {
                this.fLa.a(Fk);
            }
            if (this.fKN != null) {
                this.fKN.a(bzD().fTb.Fk());
            }
            if (this.fJX != null) {
                this.fJX.t(Fk);
            }
            if (Fk != null) {
                if (this.fXw != null) {
                    this.fXw.p(Fk);
                }
                if (this.fYp != null) {
                    this.fYp.a(Fk);
                }
                if (this.fLc != null && Fk.mLiveInfo != null) {
                    this.fLc.a(Fk.mLiveInfo);
                }
                if (this.fLx != null) {
                    this.fLI = this.fLx.m(Fk);
                }
                if (this.fKc != null) {
                    this.fKc.kj(this.fLI);
                    this.fKc.h(Fk);
                    this.fKc.updateView();
                }
                if (this.fLu != null) {
                    this.fLu.a(Fk);
                }
                if (Fk.mLiveInfo.live_status != 1) {
                    bDT();
                    bzD().pageContext.getPageActivity().finish();
                    if (bzD().fTb != null && bzD().fTb.Fk() != null) {
                        a(Fk, 1, bzD().fTb.bFt() != 1 ? bzD().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.fYq) {
                    if (this.fXQ.getVisibility() == 8) {
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
                    }
                    this.fXQ.setVisibility(0);
                    if (!this.fYo && Fk.mLiveInfo != null) {
                        this.fYo = true;
                        com.baidu.live.utils.o.a(Fk.mLiveInfo.feed_id, Fk.mLiveInfo.live_id, true, false);
                    }
                } else {
                    this.fXQ.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bDq() {
        bDg();
    }

    public void bDr() {
        if (this.fYm != null) {
            this.fYm.bAU();
        }
    }

    public void bDs() {
        if (this.fXu != null && this.fXu.getVisibility() != 8) {
            if (bzD().bBg() == 2) {
                bDV();
            } else {
                bDU();
            }
        }
        if (this.fXu != null && this.fXu.getVisibility() != 8) {
            if (bzD().bBg() == 1) {
                this.fXu.onResume();
            }
            this.fXu.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.fLD && this.fXT != null) {
            if (this.fKZ != null) {
                this.fKZ.CA().getView().setVisibility(0);
            }
            if (this.fKZ != null) {
                this.fKZ.CB().show();
                this.fKZ.CB().setEditText(" @" + this.fXT.getNameShow() + " ");
            }
            rl(8);
            this.fLD = false;
        }
        if (this.fLj != null) {
            this.fLj.resume();
        }
        if (this.fYs != null) {
            this.fYs.resume();
        }
        if (this.fYt != null) {
            this.fYt.resume();
        }
    }

    public void onPause() {
        if (this.fLj != null) {
            this.fLj.pause();
        }
        if (this.fYs != null) {
            this.fYs.pause();
        }
        if (this.fLm != null) {
            this.fLm.onPause();
        }
        if (this.fYt != null) {
            this.fYt.pause();
        }
    }

    private void bDt() {
        this.fXE = (RelativeLayout) bzD().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.fXG = (RelativeLayout) bzD().rootView.findViewById(a.g.under_live_view_panel);
        this.fXH = (RelativeLayout) bzD().rootView.findViewById(a.g.over_live_view_panel);
        this.fNl.fTc.setOnLiveViewScrollListener(this.fYP);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fXG.setVisibility(8);
            this.fXH.setVisibility(8);
            bzD().fTc.removeAllViews();
            return;
        }
        this.fXF = (RelativeLayout) bzD().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXF.getLayoutParams();
        layoutParams.topMargin = this.fNl.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fNl.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fXF.setLayoutParams(layoutParams);
        if (this.fKa == null) {
            this.fKa = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.fNl.pageContext.getPageActivity(), false);
        }
        this.fKa.a(this.fKC);
        this.fKa.a(this.fXF, a.g.ala_live_room_host_header_stub, 1L);
        this.fKa.setVisible(0);
        this.fXN = (ImageView) bzD().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.fXN.setOnClickListener(this.fYG);
        this.fXP = (ImageView) bzD().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.fXP.setOnClickListener(this.fYG);
        if (com.baidu.live.v.a.Ge().aYP != null && com.baidu.live.v.a.Ge().aYP.aAG != null && com.baidu.live.v.a.Ge().aYP.aAG.ws() && av.b(com.baidu.live.v.a.Ge().aYP)) {
            this.fXP.setVisibility(0);
        } else {
            this.fXP.setVisibility(8);
        }
        if (av.c(com.baidu.live.v.a.Ge().aYP)) {
            this.fXN.setVisibility(0);
            if (av.c(com.baidu.live.v.a.Ge().aYP)) {
                this.fXN.setAlpha(0.2f);
            }
        } else if (bzD().fTB.hasBeauty() < 0) {
            this.fXN.setVisibility(8);
        } else {
            if (av.c(com.baidu.live.v.a.Ge().aYP)) {
                this.fXN.setAlpha(0.2f);
            }
            com.baidu.live.c.uN().getInt("live_beauty_level", 3);
        }
        this.fXM = (ImageView) bzD().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.fXM.setOnClickListener(this.fYG);
        this.fXK = (ImageView) bzD().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.fXK.setOnClickListener(this.fYG);
        this.fNt = (ImageView) bzD().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.fNt.setOnClickListener(this.fYG);
        this.fXL = (ImageView) bzD().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.fXL.setOnClickListener(this.fYG);
        this.fXO = (ImageView) bzD().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.fXO.setOnClickListener(this.fYG);
        this.fXQ = bzD().rootView.findViewById(a.g.host_goods_layout);
        this.fXR = (ImageView) bzD().rootView.findViewById(a.g.host_goods_imageView);
        this.fXS = (TextView) bzD().rootView.findViewById(a.g.host_goods_num_textView);
        this.fXR.setOnClickListener(this.fYG);
        bDw();
        if (av.b(com.baidu.live.v.a.Ge().aYP)) {
            this.fYm = new com.baidu.tieba.ala.liveroom.g.b(bzD().rootView, bzD(), bzD().fTB);
        }
        this.fKY = new o();
        bDu();
        bDv();
    }

    private void bDu() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bzD().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fKZ = (k) runTask.getData();
            this.fKZ.setFromMaster(true);
            this.fKZ.CA().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bzD().pageContext.getPageActivity()) * 0.75f), com.baidu.live.aa.a.cm(false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.aa.a.cn(true);
            bzD().fTc.addView(this.fKZ.CA().getView(), layoutParams);
            this.fKZ.CB().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bzD().fTc.addView(this.fKZ.CB().getView(), layoutParams2);
            this.fKZ.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
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

    private void bDv() {
        View CI;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, l.class, bzD().pageContext);
        if (runTask != null) {
            this.fLa = (l) runTask.getData();
        }
        if (this.fLa != null && (CI = this.fLa.CI()) != null && this.fNl.fTc.indexOfChild(CI) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.fNl.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bzD().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bzD().fTc.addView(CI, layoutParams);
        }
    }

    private void bDw() {
        CustomResponsedMessage runTask;
        if (this.fXU == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bzD().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fXU = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bDx() {
        View xY;
        v.b(bzD().pageContext, true);
        if (this.fLb == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aDG = true;
            fVar.context = bzD().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLb = (w) runTask.getData();
                if (this.fLb != null && (xY = this.fLb.xY()) != null && bzD().fTc.indexOfChild(xY) < 0) {
                    if (xY.getParent() instanceof ViewGroup) {
                        ((ViewGroup) xY.getParent()).removeView(xY);
                    }
                    bzD().fTc.addView(xY, bzD().fTc.getLayoutParams());
                }
            }
        }
    }

    protected void byL() {
        View yq;
        if (this.fLc == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aDG = true;
            aVar.context = bzD().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLc = (u) runTask.getData();
            }
        }
        if (this.fLc != null && (yq = this.fLc.yq()) != null) {
            if (bzD().fTc.indexOfChild(yq) < 0) {
                if (yq.getParent() instanceof ViewGroup) {
                    ((ViewGroup) yq.getParent()).removeView(yq);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bzD().fTc.addView(yq, layoutParams);
            }
            yq.bringToFront();
        }
    }

    protected void byK() {
        View yx;
        if (this.fLm == null) {
            ab abVar = new ab();
            abVar.aDG = true;
            abVar.pageContext = bzD().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.fLm = (y) runTask.getData();
            }
        }
        if (this.fLm != null && (yx = this.fLm.yx()) != null && bzD().fTc.indexOfChild(yx) < 0) {
            if (yx.getParent() instanceof ViewGroup) {
                ((ViewGroup) yx.getParent()).removeView(yx);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bzD().fTc.addView(yx, layoutParams);
        }
    }

    private void bDy() {
        bDC();
        bxM();
        bDB();
        bzD().fTc.setVisibility(0);
        rl(0);
    }

    private void bDz() {
        if (this.fXy == null) {
            this.fXy = new com.baidu.tieba.ala.liveroom.r.a(bzD().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.fXy.a(bzD().bBg(), j, TbadkCoreApplication.getCurrentAccountName(), true, bzD().fTb.Fk().avj.portrait, this.otherParams, "", -1L);
        this.fXy.ao(bzD().fTc);
    }

    private void bDA() {
        if (this.fXW == null) {
            com.baidu.live.w.a ey = ey(bzD().pageContext.getPageActivity());
            if (ey != null) {
                this.fXW = ey;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bzD().pageContext.getPageActivity());
                if (runTask != null) {
                    this.fXW = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.fXW != null) {
                this.fXW.m(this.fXG);
                this.fXW.n(this.fXH);
                this.fXW.cE((bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.fKR != null) {
                    this.fXW.cD(this.fKR.bHv());
                }
                this.fXW.o(bzD().fTc);
                this.fXW.a(this.fJf);
                this.fXW.setLiveShowInfo(bzD().fTb.Fk());
                this.fXW.a(this.fKc);
                this.fXW.a(new a.InterfaceC0186a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void Gp() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void Gq() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void a(com.baidu.live.w.b bVar) {
                        if (AlaMasterLiveRoomOpearator.this.bzD().fTB != null && bVar != null) {
                            if (bVar.bitmap == null) {
                                AlaMasterLiveRoomOpearator.this.bzD().fTB.onStickerItemSelected(null);
                                return;
                            }
                            Sticker sticker = new Sticker();
                            sticker.setBitmap(bVar.bitmap);
                            AlaMasterLiveRoomOpearator.this.bzD().fTB.onStickerItemSelected(sticker);
                        }
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0186a
                    public void G(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bzD().fTB != null) {
                            AlaMasterLiveRoomOpearator.this.bzD().fTB.onStickerItemSelected(obj);
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

    private void bDB() {
        if (this.fXA == null) {
            this.fXA = new b(bzD().pageContext, bzD().fTc);
        }
    }

    private void bDC() {
        if (this.fJX == null) {
            this.fJX = new com.baidu.tieba.ala.liveroom.l.a(bzD().pageContext, true, this.fYK);
            this.fJX.c(this.fXE, (q) null);
            this.fJX.a(this.fKC);
        }
        if (this.fXv == null) {
            this.fXv = new com.baidu.tieba.ala.liveroom.l.a(bzD().pageContext, true, null);
            this.fXv.a(this.fXF, null, a.g.ala_live_room_host_header_stub);
            this.fXv.bCt();
        }
    }

    protected void byt() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bFj = bzD().fTb.bFj();
        boolean z2 = com.baidu.live.v.a.Ge().aWF.ayv;
        if (bFj == null || bFj.avN) {
            z = z2;
        }
        if (z && this.fKN == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bzD().pageContext)) != null) {
            this.fKN = (com.baidu.live.h.a) runTask.getData();
            if (this.fKN != null) {
                this.fKN.setIsHost(true);
                this.fKN.cr(1);
                View view = this.fKN.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bzD().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bzD().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.fXF.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(q qVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.fKc == null) {
            this.fKc = new com.baidu.tieba.ala.liveroom.activeview.b(bzD().pageContext);
        }
        this.fKc.setOtherParams(this.otherParams);
        this.fKc.b(qVar, false);
        this.fKc.setHost(true);
        this.fKc.a(1, bzD().fTc, qN(1));
        this.fKc.a(2, bzD().fTc, qN(2));
        this.fKc.kj(this.fLI);
        this.fKc.setVisible(this.fXt ? 8 : 0);
        this.fKc.a(this.fJf);
        if (this.fJf != null) {
            if (this.fKc != null) {
                alaActiveRootView2 = this.fKc.qI(1);
                alaActiveRootView = this.fKc.qI(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.fJf.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.fJf.a(alaActiveRootView);
            }
        }
    }

    private void u(q qVar) {
        CustomResponsedMessage runTask;
        if (this.fLx == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bzD().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fLx = (com.baidu.live.q.a) runTask.getData();
            if (this.fLx != null) {
                this.fLx.a(bzD().fTc, kY(false));
            }
        }
        if (this.fLx != null) {
            this.fLI = this.fLx.m(qVar);
            this.fLx.setCanVisible(!this.fXt);
        }
    }

    protected void bDD() {
        CustomResponsedMessage runTask;
        if (bzD() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bzD().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fLu = (com.baidu.live.i.a) runTask.getData();
            this.fLu.a(bzD().fTc, bDE());
            if (bzD().fTb != null) {
                this.fLu.a(bzD().fTb.Fk());
            }
            this.fLu.setCanVisible(true);
            this.fLu.bC(false);
            this.fLu.a(bzD().fTb.bth());
        }
    }

    private void byD() {
        this.fYt = new com.baidu.tieba.ala.liveroom.n.c(bzD().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bDE() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bzD().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.fLk != null && this.fLk.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fXy != null && this.fXy.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams qN(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bzD().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.fXD != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bzD().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
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
        layoutParams.rightMargin = bzD().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.fYp != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.fYp.aW(true) + bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fXD != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void bxM() {
        if (this.fXx == null) {
            this.fXx = new com.baidu.tieba.ala.liveroom.b.a(bzD().pageContext, true);
        }
    }

    private void bDF() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bzD().pageContext.getPageActivity();
            this.fMG = new ImageView(pageActivity);
            this.fMG.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.fMG.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fMG.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bzD().rootView.addView(this.fMG, layoutParams);
            this.fMG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bDR();
                }
            });
            this.fMG.setVisibility(8);
        }
    }

    private void byB() {
        this.fLj = new com.baidu.tieba.ala.liveroom.f.a(bzD().pageContext);
    }

    private void byP() {
        if (this.fLk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bzD().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fLk = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.fLk.setHost(true);
        this.fLk.setOtherParams(this.otherParams);
        if (bzD().fTb.Fk() != null && bzD().fTb.Fk().avj != null && bzD().fTb.Fk().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fLk.a(bzD().fTc, layoutParams, bzD().fTb.Fk());
        }
    }

    private void bDG() {
        CustomResponsedMessage runTask;
        if (this.fYr == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bzD().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.fYr = (com.baidu.live.b.a) runTask.getData();
            if (this.fYr != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bzD().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fYr.a(bzD().fTc, layoutParams);
            }
        }
        if (this.fYr != null) {
            this.fYr.a(bzD().fTb.Fk());
        }
    }

    private void bDH() {
        CustomResponsedMessage runTask;
        if (this.fYs == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bzD().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.fYs = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fYp != null) {
            this.fYp.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bzD().pageContext.registerListener(this.fLT);
        bzD().pageContext.registerListener(this.fYA);
        bzD().pageContext.registerListener(this.fLV);
        bzD().pageContext.registerListener(this.fLW);
        bzD().pageContext.registerListener(this.fYH);
        bzD().pageContext.registerListener(this.bfX);
        bzD().pageContext.registerListener(this.fHR);
        bzD().pageContext.registerListener(this.fYI);
        bzD().pageContext.registerListener(this.fLU);
        bzD().pageContext.registerListener(this.fKx);
        bzD().pageContext.registerListener(this.fYR);
        bzD().pageContext.registerListener(this.fYS);
        bzD().pageContext.registerListener(this.fYT);
        bzD().pageContext.registerListener(this.fMb);
        bzD().pageContext.registerListener(this.fYE);
        bzD().pageContext.registerListener(this.fYF);
        bzD().pageContext.registerListener(this.fYB);
        bzD().pageContext.registerListener(this.aWm);
        bzD().pageContext.registerListener(this.aWn);
        bzD().pageContext.registerListener(this.fYC);
        bzD().pageContext.registerListener(this.fMd);
        bzD().pageContext.registerListener(this.fMc);
        bzD().pageContext.registerListener(this.fMe);
        bzD().pageContext.registerListener(this.fYD);
        bzD().pageContext.registerListener(this.fYC);
        bzD().pageContext.registerListener(this.aTv);
        bzD().pageContext.registerListener(this.aRd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kZ(boolean z) {
        if (av.c(com.baidu.live.v.a.Ge().aYP)) {
            bzD().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bzD().fTE.va() == null || ListUtils.isEmpty(bzD().fTE.va().asJ)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bzD().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.fYu) {
                this.fYv = BdUniqueId.gen();
                bzD().fTE.a(this.fYv);
                this.fYu = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bzD().pageContext.getPageActivity(), bzD().rootView);
            rl(8);
            if (bzD().fTB.hasAdvancedBeauty() && this.fYm != null) {
                if (!this.fYw || this.fXu.getVisibility() == 0) {
                    this.fYm.a(bzD().fTB.getVideoConfig());
                }
                this.fYm.a(bzD().fTB.getVideoConfig(), this.fYn);
                if (!this.fYn) {
                    this.fYn = true;
                }
            }
            if (z && this.fKZ != null) {
                this.fKZ.CA().getView().setVisibility(4);
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
    public void bDI() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzD().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bzD().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bzD().f((short) 1);
            }
        });
        bdAlertDialog.create(bzD().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDJ() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzD().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bzD().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bzD().f((short) 1);
            }
        });
        bdAlertDialog.create(bzD().pageContext).show();
    }

    private void Cy(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzD().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bzD().f((short) 1);
            }
        });
        bdAlertDialog.create(bzD().pageContext).show();
    }

    public void bDK() {
        byt();
        com.baidu.live.data.k bth = bzD().fTb.bth();
        int i = 5;
        if (bth != null) {
            i = (int) bth.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() != null && AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bzD().fTb.f(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bth != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fNl.fTH.b(bth);
                return;
            }
            if (this.fJW == null) {
                this.fJW = new c(bzD().pageContext, this.fYK, true);
            }
            if (this.fYk) {
                this.fYk = false;
                this.fJW.a(String.valueOf(bzD().fTb.Fk().mLiveInfo.group_id), String.valueOf(bzD().fTb.Fk().mLiveInfo.live_id), String.valueOf(bzD().fTb.Fk().avj.userId), bzD().fTb.Fk());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.fKN != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.fJW.c(this.fXF, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.fJW.e(bth);
            this.fKa.setVisible(0);
            this.fKa.dm(bth.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDL() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWI() {
        if (bzD().fTb != null) {
            if (this.fKO == null) {
                this.fKO = new com.baidu.tieba.ala.liveroom.share.c(bzD().pageContext);
            }
            this.fKO.c(bzD().fTb.Fk(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bzD().fTb != null && bzD().fTb.Fk() != null && bzD().fTb.Fk().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bzD().fTb.Fk().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bzD().fTb.Fk().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bzD().fTb.Fk().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bzD().fTb != null && bzD().fTb.Fk() != null && bzD().fTb.Fk().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bzD().fTb.Fk().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bzD().fTb.Fk().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bzD().fTb.Fk().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bDM() {
        return this.fXs;
    }

    private void la(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(fXr, z);
        this.fXs = z;
    }

    private void bDN() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzD().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.bzD().pageContext).bEP();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bzD().pageContext).show();
    }

    private void bDO() {
        if (this.fXb && bzD().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bzD().fTG.GV();
        }
        bzD().fTF.prepareTime = System.currentTimeMillis() - bzD().fTF.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bzD().fTb != null && bzD().fTb.Fk() != null && bzD().fTb.Fk().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bzD().fTb.Fk().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bzD().fTb.Fk().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bzD().fTF.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fXu != null && this.fXu.getView().getParent() != null) {
            this.fXu.setVisibility(8);
            bzD().rootView.removeView(this.fXu.getView());
            this.fXu.release();
        }
        if (this.fYm != null) {
            this.fYm.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bzD().fTc.indexOfChild(this.fXC) < 0) {
            bzD().fTc.addView(this.fXC, layoutParams);
        }
        this.fXC.rB(1000);
    }

    private void bzd() {
        if (bzD().bBg() == 1) {
            bzD().fTB.startRecord();
        }
    }

    private void Cz(String str) {
        CA(str);
    }

    private void CA(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bzD().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.fXu != null) {
            this.fXu.Co(fromJson.getSmallurl());
        }
    }

    private boolean bDP() {
        return com.baidu.live.c.uN().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDQ() {
        com.baidu.live.c.uN().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.fNl.fTB.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        int i = a.i.live_close_confirm;
        if (this.fYp != null && this.fYp.bzI()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.fYp != null && this.fYp.bzH()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bzD().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk(), 0, AlaMasterLiveRoomOpearator.this.bzD().fTb.bFt() != 1 ? AlaMasterLiveRoomOpearator.this.bzD().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bzD().pageContext).show();
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
                bzD().fTb.dI(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.fYi) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bzD().fTF;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bzD().fTB.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.fYe;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.fYf;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.fYa;
            if (this.fYb != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.fYc - this.fYd) / this.fYb) * 100.0f;
            }
            Intent intent = new Intent(bzD().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bzD().fTb != null && bzD().fTb.Fk() != null && bzD().fTb.Fk().avj != null) {
                String str3 = bzD().fTb.Fk().avj.nickName;
                String str4 = bzD().fTb.Fk().avj.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            q Fk = bzD().fTb.Fk();
            if (Fk != null && Fk.avj != null && !TextUtils.isEmpty(Fk.avj.portrait)) {
                intent.putExtra("host_portrait", Fk.avj.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.fYg = intent;
                this.fYh = s;
                bzD().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bDS() {
        if (this.fYg != null) {
            a(this.fYg, this.fYh);
            this.fYg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.fYi = true;
        if (this.fYp != null) {
            this.fYp.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.fHG);
            bzD().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bzD().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDT() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fNl.fTH != null && this.fNl.fTH.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.fYp != null && this.fYp.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bzD().fTD.bEA()) {
                bDR();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.fXD != null) {
                this.fXD.setVisibility(4);
                return;
            }
            return;
        }
        if (this.fXD != null) {
            this.fXD.a(i, z, i2, z2);
        }
        if (this.fNl != null && this.fNl.fTb != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cGo != i3) {
                this.cGo = i3;
                if (this.fXB == null) {
                    this.fXB = new com.baidu.tieba.ala.liveroom.tippop.a(this.fNl.pageContext, null);
                }
                switch (this.cGo) {
                    case 0:
                        this.fXB.a(this.fNl.rootView, this.fNl.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.fXB.a(this.fNl.rootView, this.fNl.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.fXB.a(this.fNl.rootView, this.fNl.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.fNl.fTb.j(this.fNl.fTb.Fk().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.bDT();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk(), 1, str3);
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
            if (this.fXz != null) {
                this.fXz.z(aVar);
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
                            if (this.fYp != null) {
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
            if (this.fYp != null) {
                this.fYp.en(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bDT();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bzD().fTb.Fk(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bzD().fTb.Fk() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzD().fTb.Fk().avC.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bzD().fTb.Fk().avC.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bzD().fTb.Fk().avC.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bzD().fTb.Fk() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bzD().fTb.Fk() != null && bzD().fTb.Fk().avj != null && bzD().fTb.Fk().avj.userId == optLong2) {
                        bzD().fTb.Fk().avj.isUegBlock = 1;
                        bxZ();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bzD().fTb.Fk() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bzD().fTb.Fk() != null && bzD().fTb.Fk().avj != null && bzD().fTb.Fk().avj.userId == optLong3) {
                        bzD().fTb.Fk().avj.isUegBlock = 0;
                        bxZ();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.fXU != null) {
                    this.fXU.G(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.fXA.aE(optString4, optInt2);
                    }
                    if (this.fKa.getCount() > 20) {
                        this.fKa.dm(this.fKa.getCount() + 1);
                    } else if (this.fJW != null) {
                        com.baidu.live.data.a DB = aVar.DB();
                        j jVar = new j();
                        jVar.avk = new AlaLocationData();
                        jVar.avl = new AlaRelationData();
                        jVar.avj = new AlaLiveUserInfoData();
                        jVar.avj.userId = JavaTypesHelper.toLong(DB.userId, 0L);
                        jVar.avj.userName = DB.userName;
                        jVar.avj.portrait = DB.portrait;
                        if (this.fJW.c(jVar)) {
                            this.fKa.dm(this.fKa.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bzD().fTb.Fk() != null && bzD().fTb.Fk().mLiveInfo != null) {
                    String str5 = bzD().fTb.Fk().mLiveInfo.feed_id;
                    long j4 = bzD().fTb.Fk().mLiveInfo.live_id;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!m.i(j4, optLong4)) {
                        com.baidu.live.utils.o.a(str5, j4, true, false);
                        m.j(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bzD() != null && bzD().fTb != null && bzD().fTb.Fk() != null && bzD().fTb.Fk().avC != null && bzD().fTb.Fk().avC.userId == jSONObject2.optLong("user_id")) {
                    bzD().fTb.bFi();
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
                if (bzD().fTb != null && bzD().fTb.Fk() != null && bzD().fTb.Fk().mLiveInfo != null) {
                    j5 = bzD().fTb.Fk().mLiveInfo.live_id;
                    j6 = bzD().fTb.Fk().mLiveInfo.group_id;
                    j7 = bzD().fTb.Fk().avj.userId;
                    str8 = bzD().fTb.Fk().mLiveInfo.appId;
                    if (bzD().fTb.Fk().mLiveSdkInfo.mCastIds != null) {
                        String str9 = bzD().fTb.Fk().mLiveSdkInfo.mCastIds.avv;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bzD().fTb.Fk().mLiveSdkInfo.mCastIds.avw;
                        str4 = str9;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || bzD().bBg() != 2) {
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
                        dVar.fSz = optLong6;
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
                dVar2.fSz = optLong6;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void Cf(String str) {
        if (this.fKc != null) {
            this.fKc.Cf(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl(int i) {
        View findViewById = bzD().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.fKc != null) {
            this.fKc.bt(2, i);
        }
    }

    private void bDU() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bzD().fTB != null && AlaMasterLiveRoomOpearator.this.bzD().fTB.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bzD().fTB.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bzD().fTB.startRecord();
                }
            }
        });
    }

    private void bDV() {
        if (bzD().fTB != null && bzD().fTB.getPreview() != null) {
            bzD().fTB.getPreview().setVisibility(8);
            bzD().fTB.stopRecord();
        }
    }

    public void bDW() {
        this.fTy = bzD().fTb.bFu();
        if (this.fXu != null) {
            this.fXu.kK(this.fTy);
        }
    }

    public void bBe() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bDX();
        } else if (this.fXu != null) {
            this.fXu.bBe();
        }
    }

    public void kL(boolean z) {
        if (this.fXu != null) {
            this.fXu.kL(z);
        }
    }

    public void onDestroy() {
        if (this.fXZ != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.fXZ);
        }
        this.fXZ = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fYm != null) {
            this.fYm.kI(true);
        }
        this.fYm = null;
        if (this.fXu != null) {
            this.fXu.destroy();
            bzD().rootView.removeView(this.fXu.getView());
            this.fXu.release();
            this.fXu = null;
        }
        if (this.fYp != null) {
            this.fYp.onDestroy();
        }
        if (this.fKO != null) {
            this.fKO.onDestroy();
        }
        if (this.fKQ != null) {
            this.fKQ.onDestroy();
        }
        if (this.fJX != null) {
            this.fJX.onDestroy();
            this.fJX = null;
        }
        if (this.fXv != null) {
            this.fXv.onDestroy();
        }
        if (this.fLm != null) {
            this.fLm.onDestroy();
            this.fLm = null;
        }
        if (this.fXC != null) {
            this.fXC.stopCountDown();
        }
        if (this.fXy != null) {
            this.fXy.onDestroy();
        }
        if (this.fXA != null) {
            this.fXA.onDestroy();
        }
        if (this.fXU != null) {
            this.fXU.onDestroy();
            this.fXU = null;
        }
        if (this.fLb != null) {
            this.fLb.onDestroy();
            this.fLb = null;
        }
        v.yt();
        com.baidu.live.entereffect.a.wD().release();
        if (this.fLc != null) {
            this.fLc.onDestroy();
            this.fLc = null;
        }
        if (this.fXB != null) {
            this.fXB.onDestroy();
        }
        if (this.fXz != null) {
            this.fXz.bHx();
            this.fXz.release();
        }
        if (this.fKa != null) {
            this.fKa = null;
        }
        if (this.fKc != null) {
            this.fKc.release();
        }
        if (this.fXw != null) {
            this.fXw.onDestroy();
        }
        if (this.fXz != null) {
            this.fXz.onDestroy();
        }
        if (this.fLa != null) {
            this.fLa.release();
        }
        if (this.fLj != null) {
            this.fLj.release();
        }
        if (this.fLk != null) {
            this.fLk.onDestroy();
        }
        if (this.fXW != null) {
            this.fXW.onDestroy();
        }
        if (this.fLx != null) {
            this.fLx.release();
        }
        if (this.fYr != null) {
            this.fYr.onDestory();
        }
        if (this.fYs != null) {
            this.fYs.release();
        }
        if (this.fLu != null) {
            this.fLu.onDestroy();
        }
        if (this.fYt != null) {
            this.fYt.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fKx);
        MessageManager.getInstance().unRegisterListener(this.fYR);
        MessageManager.getInstance().unRegisterListener(this.fYS);
        MessageManager.getInstance().unRegisterListener(this.fYT);
        MessageManager.getInstance().unRegisterListener(this.fMb);
        MessageManager.getInstance().unRegisterListener(this.fYE);
        MessageManager.getInstance().unRegisterListener(this.fYF);
        MessageManager.getInstance().unRegisterListener(this.fYB);
        MessageManager.getInstance().unRegisterListener(this.aWm);
        MessageManager.getInstance().unRegisterListener(this.aWn);
        MessageManager.getInstance().unRegisterListener(this.fYC);
        MessageManager.getInstance().unRegisterListener(this.fMd);
        MessageManager.getInstance().unRegisterListener(this.fMc);
        MessageManager.getInstance().unRegisterListener(this.fMe);
        MessageManager.getInstance().unRegisterListener(this.fYD);
        MessageManager.getInstance().unRegisterListener(this.fYC);
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
            this.fNl.fTH.a(this.fYV, this.fNl.fTC, this.fXE, alaLivePersonData);
        }
    }

    private void bDX() {
        if (this.fXX != null) {
            this.fNl.fTF.startTime = System.currentTimeMillis();
            this.fNl.fTF.liveTotalTime = System.currentTimeMillis();
            this.fNl.fTF.sampleMemAndCPU();
            this.fNl.fTD.a((short) 4, this.fXX);
        }
    }

    private ViewGroup.LayoutParams bDY() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bzD().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
