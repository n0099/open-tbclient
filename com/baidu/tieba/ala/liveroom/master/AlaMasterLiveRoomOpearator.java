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
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.data.ai;
import com.baidu.live.data.aj;
import com.baidu.live.data.aq;
import com.baidu.live.data.n;
import com.baidu.live.data.z;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.gift.x;
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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.m;
import com.baidu.live.w.a;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.challenge.f;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.e.c;
import com.baidu.tieba.ala.liveroom.g.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.baidu.tieba.ala.liveroom.views.e;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String fJt;
    private boolean aNm;
    private List<aj> aQH;
    private com.baidu.tieba.ala.liveroom.r.a fJA;
    private com.baidu.tieba.ala.liveroom.v.a fJB;
    private b fJC;
    private com.baidu.tieba.ala.liveroom.tippop.a fJD;
    private AlaLiveCountDownView fJE;
    private AlaLiveStreamStatusView fJF;
    private RelativeLayout fJG;
    private RelativeLayout fJH;
    private RelativeLayout fJI;
    private RelativeLayout fJJ;
    private View fJK;
    private AlaLiveFaceVerifyView fJL;
    private ImageView fJM;
    private ImageView fJN;
    private ImageView fJO;
    private ImageView fJP;
    private ImageView fJQ;
    private ImageView fJR;
    private View fJS;
    private ImageView fJT;
    private TextView fJU;
    private z fJV;
    private com.baidu.live.x.a fJW;
    private com.baidu.tieba.ala.liveroom.master.panel.b fJX;
    private com.baidu.live.w.a fJY;
    private e fJZ;
    private boolean fJd;
    private boolean fJu;
    private d fJw;
    private com.baidu.tieba.ala.liveroom.l.a fJx;
    private c fJy;
    private com.baidu.tieba.ala.liveroom.b.a fJz;
    private short fKj;
    private com.baidu.tieba.ala.liveroom.g.b fKo;
    private boolean fKp;
    private boolean fKq;
    private f fKr;
    private com.baidu.live.b.a fKt;
    private com.baidu.live.b.b fKu;
    private com.baidu.tieba.ala.liveroom.n.a fKv;
    private boolean fKw;
    private BdUniqueId fKx;
    private boolean fKy;
    private String ftK;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fvZ;
    private com.baidu.live.g.a fvi;
    private com.baidu.live.h.a fwP;
    private com.baidu.tieba.ala.liveroom.share.c fwQ;
    private com.baidu.tieba.ala.liveroom.o.b fwR;
    private com.baidu.tieba.ala.liveroom.guide.c fwS;
    private com.baidu.tieba.ala.liveroom.watermark.a fwT;
    private com.baidu.tieba.ala.liveroom.l.a fwa;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fwe;
    private com.baidu.tieba.ala.liveroom.activeview.b fwg;
    private boolean fxJ;
    private o fxa;
    private k fxb;
    private l fxc;
    private v fxd;
    private t fxe;
    protected com.baidu.tieba.ala.liveroom.f.a fxl;
    protected h fxm;
    protected x fxo;
    protected com.baidu.live.i.a fxw;
    private com.baidu.live.q.a fxy;
    private ImageView fyF;
    private com.baidu.tieba.ala.liveroom.data.f fzj;
    private ImageView fzr;
    private g fzs;
    private boolean fJv = false;
    private boolean fxE = false;
    private Handler mHandler = new Handler();
    private boolean fKa = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver fKb = null;
    private boolean fKc = false;
    private int fKd = 0;
    private int fKe = 0;
    private int fKf = 0;
    private long fKg = 0;
    private long fKh = 0;
    private volatile boolean isBackground = false;
    private Intent fKi = null;
    private int mOrientation = 1;
    private boolean fFE = false;
    private boolean fKk = false;
    private boolean fKl = true;
    private boolean fzp = false;
    private boolean fKm = true;
    private boolean fKn = true;
    private int cun = 0;
    public boolean fKs = false;
    private String otherParams = "";
    private int aNo = 0;
    private int fKz = 5000;
    private boolean fKA = false;
    private Runnable fKB = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.fvi != null) {
                AlaMasterLiveRoomOpearator.this.fvi.vl();
            }
        }
    };
    private CustomMessageListener aQd = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fzj.fFN != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fzj.fFN.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.x(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener aQe = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fzj.fFN != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fzj.fFN.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener fxV = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.fwR == null) {
                        AlaMasterLiveRoomOpearator.this.fwR = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    AlaMasterLiveRoomOpearator.this.fwR.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener fyc = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fxw != null) {
                AlaMasterLiveRoomOpearator.this.fxw.Ay();
            }
        }
    };
    private CustomMessageListener fKC = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fxS = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.AA(str);
            }
        }
    };
    private CustomMessageListener fxT = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aQA();
        }
    };
    private CustomMessageListener fys = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.fxe.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fya = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener fKD = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fKu != null) {
                n DM = AlaMasterLiveRoomOpearator.this.btE().fFh.DM();
                long j = DM.mLiveInfo.live_id;
                long j2 = DM.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.fKu.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener fKE = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.btE().fFi);
            if (AlaMasterLiveRoomOpearator.this.fJw == null || AlaMasterLiveRoomOpearator.this.fJw.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qK(0);
            }
            if (AlaMasterLiveRoomOpearator.this.fxb != null) {
                AlaMasterLiveRoomOpearator.this.fxb.Be().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.fxb.Bf().hide();
            }
        }
    };
    private CustomMessageListener fyb = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.o(AlaMasterLiveRoomOpearator.this.btE().fFh.DM());
        }
    };
    private CustomMessageListener fyd = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fxo != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.fxo).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fKF = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fKv != null) {
                    AlaMasterLiveRoomOpearator.this.fKv.AE(str);
                }
            }
        }
    };
    private CustomMessageListener fKG = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.fKo != null) {
                        if (!data.anV || AlaMasterLiveRoomOpearator.this.fKx == null || !AlaMasterLiveRoomOpearator.this.fKy) {
                            if (AlaMasterLiveRoomOpearator.this.fKx != null && AlaMasterLiveRoomOpearator.this.fKx == data.anU) {
                                if (data.anP != null && data.anP.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.fKy || AlaMasterLiveRoomOpearator.this.fJw.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.fKo.a(AlaMasterLiveRoomOpearator.this.btE().fFH.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.fKp = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.btE().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.fKx = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.btE().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.fKo.a(AlaMasterLiveRoomOpearator.this.btE().fFH.getVideoConfig(), AlaMasterLiveRoomOpearator.this.fKp);
                        if (!AlaMasterLiveRoomOpearator.this.fKp) {
                            AlaMasterLiveRoomOpearator.this.fKp = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.fKw) {
                    AlaMasterLiveRoomOpearator.this.btE().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.fKw = false;
            }
        }
    };
    private CustomMessageListener fKH = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.btE().fFH != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.btE().fFH.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                }
            }
        }
    };
    public CustomMessageListener aNp = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.aNo == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.aNo == 6) {
                            AlaMasterLiveRoomOpearator.this.bxa();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.aNo = 0;
            }
        }
    };
    private View.OnClickListener fKI = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.fJN) {
                    AlaMasterLiveRoomOpearator.this.bxc();
                    AlaMasterLiveRoomOpearator.this.fJX.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.fJM) {
                    if (view == AlaMasterLiveRoomOpearator.this.fJO) {
                        AlaMasterLiveRoomOpearator.this.aQA();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.fJP) {
                        if (view != AlaMasterLiveRoomOpearator.this.fJR) {
                            if (view != AlaMasterLiveRoomOpearator.this.fzr) {
                                if (view == AlaMasterLiveRoomOpearator.this.fJQ) {
                                    if (AlaMasterLiveRoomOpearator.this.fJB != null) {
                                        String str = null;
                                        String str2 = null;
                                        com.baidu.tieba.ala.liveroom.data.h bzd = AlaMasterLiveRoomOpearator.this.btE().fFh.bzd();
                                        if (bzd != null && bzd.mLiveSdkInfo != null) {
                                            str = String.valueOf(bzd.mLiveSdkInfo.mRoomId);
                                            if (bzd.mLiveSdkInfo.mCastIds != null) {
                                                str2 = bzd.mLiveSdkInfo.mCastIds.aqw;
                                            }
                                        }
                                        AlaMasterLiveRoomOpearator.this.fJB.ac("", str, str2);
                                        return;
                                    }
                                    return;
                                } else if (view == AlaMasterLiveRoomOpearator.this.fJT) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
                                    n DM = AlaMasterLiveRoomOpearator.this.btE().fFh.DM();
                                    if (AlaMasterLiveRoomOpearator.this.fxl != null && DM != null && DM.mLiveInfo != null) {
                                        String valueOf = String.valueOf(DM.mLiveInfo.live_id);
                                        String valueOf2 = String.valueOf(DM.mLiveInfo.feed_id);
                                        long j = DM.mLiveInfo.room_id;
                                        String str3 = DM.mLiveInfo.cover;
                                        String str4 = "";
                                        String str5 = "";
                                        String str6 = "";
                                        String str7 = "";
                                        if (DM.mLiveInfo.session_info != null) {
                                            str4 = DM.mLiveInfo.session_info.flvUrl;
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
                                        long j2 = DM.mLiveInfo.user_id;
                                        long j3 = DM.mLiveInfo.group_id;
                                        AlaMasterLiveRoomOpearator.this.fxl.AE(com.baidu.live.utils.o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7, String.valueOf(j2), DM.mLiveInfo.user_name, String.valueOf(j3), String.valueOf(DM.aqk.userId)));
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.fKr != null) {
                                AlaMasterLiveRoomOpearator.this.fKr.btG();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.fJY != null) {
                            AlaMasterLiveRoomOpearator.this.fJY.showDialog();
                            AlaMasterLiveRoomOpearator.this.fJY.bN(AlaMasterLiveRoomOpearator.this.bxg());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.fKy = false;
                        AlaMasterLiveRoomOpearator.this.kE(true);
                    }
                } else if (com.baidu.live.v.a.En().aQu.atD == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.En().aQu.atC == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.aNm) {
                        AlaMasterLiveRoomOpearator.this.bxa();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.aNo = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bxa();
                }
            }
        }
    };
    private CustomMessageListener fxU = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof z) {
                    AlaMasterLiveRoomOpearator.this.fxE = true;
                    AlaMasterLiveRoomOpearator.this.fJV = (z) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.fxb != null) {
                        AlaMasterLiveRoomOpearator.this.fxb.Be().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fxb != null) {
                        AlaMasterLiveRoomOpearator.this.fxb.Bf().show();
                        AlaMasterLiveRoomOpearator.this.fxb.Bf().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.qK(8);
                }
            }
        }
    };
    private CustomMessageListener fKJ = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.btE() != null && AlaMasterLiveRoomOpearator.this.btE().fFL != null) {
                AlaMasterLiveRoomOpearator.this.btE().fFL.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener aYB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bxP();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.btE().fFh.qR(i);
                if (AlaMasterLiveRoomOpearator.this.fxw != null) {
                    AlaMasterLiveRoomOpearator.this.fxw.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener ftV = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bxI();
        }
    };
    public final HttpMessageListener fKK = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.DP()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.fJX != null) {
                            AlaMasterLiveRoomOpearator.this.fJX.kL(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.fJX.byp();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.btE().fFH.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.fJD != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.fJD.a(AlaMasterLiveRoomOpearator.this.btE().rootView, AlaMasterLiveRoomOpearator.this.btE().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.btE().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.fJD.qY(2);
                        AlaMasterLiveRoomOpearator.this.fJD.a(AlaMasterLiveRoomOpearator.this.btE().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a fKL = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bxW() {
            AlaMasterLiveRoomOpearator.this.bxF();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bxX() {
            AlaMasterLiveRoomOpearator.this.bxG();
        }
    };
    com.baidu.live.liveroom.a.a fKM = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean cr(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cs(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ct(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.btE().bvh() == 1) {
                AlaMasterLiveRoomOpearator.this.btE().fFH.stopRecord();
            }
        }
    };
    private IShareCallback fKN = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.fKa && AlaMasterLiveRoomOpearator.this.fJZ != null) {
                AlaMasterLiveRoomOpearator.this.fKa = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.fJZ);
            }
        }
    };
    private View.OnTouchListener fKO = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.btE().fFL.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.btE().fFi);
            AlaMasterLiveRoomOpearator.this.qK(0);
            if (AlaMasterLiveRoomOpearator.this.fxb != null) {
                AlaMasterLiveRoomOpearator.this.fxb.Be().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.fxb.Bf().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b fKP = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bxY() {
            AlaMasterLiveRoomOpearator.this.bxb();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bxZ() {
            AlaMasterLiveRoomOpearator.this.fJd = AlaMasterLiveRoomOpearator.this.fJw.buZ();
            AlaMasterLiveRoomOpearator.this.btE().fFL.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.btE().fFL.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.btE().fFL.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fFB = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.btE().bvh();
            eVar.title = AlaMasterLiveRoomOpearator.this.fJw.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.fFC = AlaMasterLiveRoomOpearator.this.fJw.bva();
            eVar.fFF = AlaMasterLiveRoomOpearator.this.fJd;
            eVar.fFE = AlaMasterLiveRoomOpearator.this.fJw.buX();
            eVar.fFD = AlaMasterLiveRoomOpearator.this.fJw.bvc();
            eVar.fFG = AlaMasterLiveRoomOpearator.this.fJw.buY();
            if (eVar.fFG) {
                if (AlaMasterLiveRoomOpearator.this.fJw.bvd()) {
                    AlaMasterLiveRoomOpearator.this.fKa = true;
                    AlaMasterLiveRoomOpearator.this.fJZ = eVar;
                    AlaMasterLiveRoomOpearator.this.fJw.bve();
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
            AlaMasterLiveRoomOpearator.this.btE().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.btE().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bya() {
            AlaMasterLiveRoomOpearator.this.fKy = true;
            AlaMasterLiveRoomOpearator.this.kE(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean byb() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void byc() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void byd() {
            com.baidu.live.utils.o.m(AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity(), "", "");
        }
    };
    private Runnable fKQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.btE().fFh != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM() != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo != null) {
                    m.j(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.fKQ, AlaMasterLiveRoomOpearator.this.fKz);
                }
            }
        }
    };
    private CustomMessageListener aLh = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bse();
            }
        }
    };
    private com.baidu.live.liveroom.g.c fKR = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void DK() {
            if (AlaMasterLiveRoomOpearator.this.fJB != null) {
                AlaMasterLiveRoomOpearator.this.fJB.kX(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bK(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.fKr != null) {
                        AlaMasterLiveRoomOpearator.this.fKr.d(AlaMasterLiveRoomOpearator.this.fzr);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fJY != null) {
                        AlaMasterLiveRoomOpearator.this.fJY.setStickerCanOperate(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.fKr != null) {
                        AlaMasterLiveRoomOpearator.this.fKr.Hp();
                    }
                    if (AlaMasterLiveRoomOpearator.this.fJY != null) {
                        AlaMasterLiveRoomOpearator.this.fJY.setStickerCanOperate(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.fJB != null) {
                    AlaMasterLiveRoomOpearator.this.fJB.kX(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.fxo != null) {
                    AlaMasterLiveRoomOpearator.this.fxo.aZ(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a fKS = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.fJL != null && AlaMasterLiveRoomOpearator.this.btE().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.fJL) >= 0) {
                AlaMasterLiveRoomOpearator.this.btE().rootView.removeView(AlaMasterLiveRoomOpearator.this.fJL);
                AlaMasterLiveRoomOpearator.this.fJL.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.fJL = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fwF = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            n DM;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bxO();
            } else if (i == 14 && (DM = AlaMasterLiveRoomOpearator.this.btE().fFh.DM()) != null && DM.aqk != null && DM.mLiveInfo != null && DM.aqD != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity(), DM.aqk.userName, Long.toString(DM.aqk.userId), Long.toString(DM.aqk.charmCount), String.valueOf(DM.mLiveInfo.group_id), String.valueOf(DM.mLiveInfo.live_id), true, String.valueOf(DM.aqk.userId), Long.toString(DM.aqD.userId), DM.aqD.userName, DM.aqD.portrait, AlaMasterLiveRoomOpearator.this.fwe.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(DM.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.fwe.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener fKT = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.fKs = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fLU;
            }
        }
    };
    private HttpMessageListener fKU = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.fJU.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.fJU.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.fJU.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.fJU.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.aQH = getVideoGoodsListHttpResponseMessage.aQH;
            }
        }
    };
    private HttpMessageListener fKV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.btE().fFh != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM() != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aQB != null && !eventPollingHttpResponseMessage.aQB.isEmpty()) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.aQB.size()) {
                                break;
                            }
                            ai aiVar = eventPollingHttpResponseMessage.aQB.get(i2);
                            if (j == aiVar.liveId && j2 - aiVar.createTime <= 60 && !m.h(aiVar.liveId, aiVar.id)) {
                                m.a(aiVar, AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo);
                                m.i(aiVar.liveId, aiVar.id);
                            }
                            i = i2 + 1;
                        }
                        ai aiVar2 = eventPollingHttpResponseMessage.aQB.get(eventPollingHttpResponseMessage.aQB.size() - 1);
                        if (j == aiVar2.liveId) {
                            m.g(aiVar2.liveId, aiVar2.id);
                        }
                    }
                }
                int i3 = eventPollingHttpResponseMessage.aQA;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.fKz = i3 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a fKW = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private com.baidu.live.liveroom.middleware.g fKX = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.anl);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        fJt = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null && com.baidu.live.v.a.En().aQu != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(btE().pageContext.getPageActivity(), String.valueOf(nVar.mLiveInfo.live_id), String.valueOf(nVar.mLiveInfo.user_id), com.baidu.live.v.a.En().aQu.aty, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(btE().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.En().aQu.asW;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? btE().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : btE().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(btE().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bse() {
        int i = btE().fFh.DM().aqk.isUegBlock;
        int i2 = btE().fFh.DM().aqk.isBlock;
        String str = btE().fFh.DM().aqk.userName;
        if (i > 0 || i2 > 0) {
            this.aNm = true;
            this.fxb.a(true, i, i2, str);
            return;
        }
        this.aNm = false;
        this.fxb.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.fzj.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aNz == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aNA);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.fzj.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.fzj.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxa() {
        if (this.fxb != null) {
            this.fxb.Bf().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.fKr != null) {
            this.fKr.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxb() {
        if (btE() != null && btE().fFh != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                btE().fFh.byV();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                btE().fFh.byW();
            }
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
                    AlaMasterLiveRoomOpearator.this.fKc = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.fKc = false;
                }
                if (AlaMasterLiveRoomOpearator.this.fKd == 0) {
                    AlaMasterLiveRoomOpearator.this.fKd = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.fKe == 0) {
                    AlaMasterLiveRoomOpearator.this.fKe = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.fKf = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (btE() != null && btE().fFJ != null) {
            btE().fFJ.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.f fVar, String str) {
        this.fzj = fVar;
        this.ftK = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.f btE() {
        return this.fzj;
    }

    public int a(g gVar) {
        this.fzs = gVar;
        this.fKb = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.fKb, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.fJD == null) {
            this.fJD = new com.baidu.tieba.ala.liveroom.tippop.a(this.fzj.pageContext, null);
        }
        registerListener();
        this.fvi = new com.baidu.live.g.a();
        bxq();
        Long[] lArr = new Long[1];
        this.fKg = lArr[0] == null ? 0L : lArr[0].longValue();
        this.fKh = lArr[0] != null ? lArr[0].longValue() : 0L;
        btE().fFi.setOnTouchListener(this.fKO);
        this.fJu = SharedPrefHelper.getInstance().getBoolean(fJt, false);
        this.fJE = new AlaLiveCountDownView(btE().pageContext.getPageActivity());
        this.fJE.setCount(3);
        this.fJE.setTextColor(btE().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.fJE.setTextSize(btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.fJE.setTypeface(Typeface.DEFAULT_BOLD);
        this.fJE.setIncludeFontPadding(false);
        this.fJE.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bye() {
                if (AlaMasterLiveRoomOpearator.this.btE().fFi != null) {
                    AlaMasterLiveRoomOpearator.this.btE().fFi.removeView(AlaMasterLiveRoomOpearator.this.fJE);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (this.fJX == null) {
            this.fJX = new com.baidu.tieba.ala.liveroom.master.panel.b(btE().pageContext.getPageActivity(), btE().bvh() == 2);
            this.fJX.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kG(boolean z) {
                    AlaMasterLiveRoomOpearator.this.btE().fFH.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kH(boolean z) {
                    AlaMasterLiveRoomOpearator.this.btE().fFH.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kI(boolean z) {
                    AlaMasterLiveRoomOpearator.this.btE().fFH.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bxN();
                    if (AlaMasterLiveRoomOpearator.this.fJD != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.fJD.a(AlaMasterLiveRoomOpearator.this.btE().rootView, AlaMasterLiveRoomOpearator.this.btE().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.fJD.a(AlaMasterLiveRoomOpearator.this.btE().rootView, AlaMasterLiveRoomOpearator.this.btE().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kJ(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byf() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.btE().fFh != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM() != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byg() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.btE().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byh() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.btE() != null && AlaMasterLiveRoomOpearator.this.btE().fFh != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM() != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.btE().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.fJX != null) {
                            AlaMasterLiveRoomOpearator.this.fJX.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byi() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.btE() == null || AlaMasterLiveRoomOpearator.this.btE().fFh == null || AlaMasterLiveRoomOpearator.this.btE().fFh.DM() == null || AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.btE() != null && AlaMasterLiveRoomOpearator.this.btE().fFh != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM() != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.fJX != null) {
                                        AlaMasterLiveRoomOpearator.this.fJX.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fzj.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.fJX != null) {
                        AlaMasterLiveRoomOpearator.this.fJX.dismiss();
                    }
                }
            });
        }
        bxd();
    }

    private void bxd() {
        if (this.fJX != null) {
            boolean isBackCamera = btE().fFH.isBackCamera();
            this.fJX.kK(btE().fFH.isBackCamera());
            this.fJX.F(btE().fFH.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = btE().fFH.isPushMirror();
            if (this.fKl) {
                isPushMirror = bxM() || isPushMirror;
                this.fKl = false;
            }
            this.fJX.G(isPushMirror, isBackCamera ? false : true);
            this.fJX.kL(btE().fFH.isMute());
            this.fJX.byp();
        }
    }

    public void bxe() {
        if (this.fzs != null) {
            if (this.fzs.fFO == null || this.fzs.fFO.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.fJK == null) {
                        this.fJK = this.fzj.fFN.Du();
                        this.fzj.rootView.addView(this.fJK, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.fJw == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (btE().fFh != null && btE().fFh.DM() != null && btE().fFh.DM().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", btE().fFh.DM().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", btE().fFh.DM().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.fJw = new d(btE().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    btE().fFL.prepareTime = System.currentTimeMillis();
                    btE().rootView.addView(this.fJw.getView(), layoutParams);
                    this.fJw.a(this.fKN);
                }
                this.fJw.kq(this.fFE);
                this.fJw.a(this.fKP);
                this.fJw.a(this.fKL);
                this.fJw.a(btE().fFH, btE().bvh());
                return;
            }
            this.fJd = this.fzs.fFO.mLiveInfo.screen_direction == 2;
            if (this.fzs.fFO.mLiveInfo.isAudioOnPrivate == 1) {
                btE().fFH.setMute(true);
                if (this.fJD == null) {
                    this.fJD = new com.baidu.tieba.ala.liveroom.tippop.a(this.fzj.pageContext, null);
                }
                if (!this.fJD.qX(2)) {
                    this.fJD.a(btE().rootView, btE().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fFB = true;
            eVar.forumId = String.valueOf(this.fzs.fFO.mLiveInfo.forum_id);
            eVar.forumName = this.fzs.fFO.mLiveInfo.forum_name;
            eVar.liveType = this.fzs.fFO.mLiveInfo.live_type;
            eVar.title = this.fzs.fFO.mLiveInfo.getLiveTitle();
            eVar.clarity = this.fzs.fFO.mLiveInfo.clarity;
            eVar.gameId = this.fzs.fFO.mLiveInfo.game_id;
            eVar.gameName = this.fzs.fFO.mLiveInfo.game_label;
            eVar.fFF = this.fzs.fFO.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bxf() {
        if (this.fKo != null) {
            this.fKo.a(btE().fFH.getVideoConfig(), false);
        }
        if (this.fJw != null) {
            this.fJw.kp(true);
        }
        if (btE().fFH.hasBeauty() >= 0) {
            btE().fFH.setBeauty(com.baidu.live.c.tG().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            btE().fFN.D(this.fzj.fFH);
        } else if (this.fJw != null) {
            this.fJw.kp(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.fJK != null && this.fJK.getParent() != null) {
                ((ViewGroup) this.fJK.getParent()).removeView(this.fJK);
                this.fJK = null;
            }
            btE().fFi.setVisibility(0);
            this.fzj.fFN.a(btE().fFi);
        } else {
            bxv();
            bxL();
            this.fJB = new com.baidu.tieba.ala.liveroom.v.a(btE().pageContext, this.fKM);
            this.fJB.d(btE().fFi, true);
            this.fJB.kX(true);
            if (this.fxb != null && this.fxb.Be() != null) {
                this.fxb.Be().setNeedTopAlphaShade(true);
            }
        }
        btE().fFH.setPushMirror(bxM());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fzj.fFN.j(btE().fFh.DM());
        }
        if (!btE().fFH.isBackground() && btE().fFh.DM() != null && btE().fFh.DM().mLiveInfo != null) {
            int startPush = btE().fFH.startPush(btE().fFh.DM().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fzj.fFN.Dv();
            }
            if (startPush != 0 && btE().fFL != null) {
                btE().fFL.errCode = 4;
                btE().fFL.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.bvl() && !bxJ()) {
                kF(true);
                bxK();
            }
            if (this.fJy != null) {
                this.fJy.p(btE().fFh.DM());
            }
            if (this.fwa != null) {
                this.fwa.t(btE().fFh.DM());
            }
            if (this.fwP != null) {
                this.fwP.a(btE().fFh.DM());
            }
            if (this.fJz != null && btE() != null && btE().fFh != null) {
                if (this.fJz.ai(btE().fFi)) {
                    this.fJz.n(btE().fFh.DM());
                } else {
                    this.fJz.b(btE().fFi, btE().fFh.DM());
                }
            }
            if (this.fJx != null) {
                this.fJx.t(btE().fFh.DM());
            }
            if (hVar == null || hVar.aqk == null) {
                z = com.baidu.live.c.tG().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.aqk.canUseChallenge;
                com.baidu.live.c.tG().putBoolean("ala_master_can_use_challenge", z);
            }
            bxw();
            bxj();
            kC(z);
            bxx();
            bxC();
            bsF();
            bsT();
            u(btE().fFh.DM());
            f(btE().fFh.DM());
            bxD();
            bxE();
            bxA();
            bsH();
            bsO();
            bsP();
            bxu();
            if (this.fxa != null) {
                this.fxa.g(btE().fFh.DM());
            }
            if (this.fxb != null) {
                this.fxb.e(String.valueOf(btE().fFh.DM().mLiveInfo.group_id), String.valueOf(btE().fFh.DM().mLiveInfo.last_msg_id), String.valueOf(btE().fFh.DM().aqk.userId), String.valueOf(btE().fFh.DM().mLiveInfo.live_id), btE().fFh.DM().aqk.appId);
            }
            if (this.fxc != null) {
                this.fxc.a(btE().fFh.DM(), true);
            }
            if (!this.fKA && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.fKA = true;
                this.mHandler.post(this.fKQ);
            }
            this.mHandler.post(this.fKB);
        }
    }

    private void kC(boolean z) {
        if (this.fKr == null) {
            this.fKr = new f(btE());
        }
        this.fKr.a(this.fzr, this.fzs);
        this.fKr.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ag agVar, ah ahVar, ah ahVar2) {
                if (AlaMasterLiveRoomOpearator.this.fwT != null) {
                    AlaMasterLiveRoomOpearator.this.fwT.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.btE().fFi.fSj = false;
                AlaMasterLiveRoomOpearator.this.bxh();
                if (AlaMasterLiveRoomOpearator.this.fxy != null) {
                    AlaMasterLiveRoomOpearator.this.fxy.b(AlaMasterLiveRoomOpearator.this.kD(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void um() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fKB);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void btC() {
                if (AlaMasterLiveRoomOpearator.this.fwT != null) {
                    AlaMasterLiveRoomOpearator.this.fwT.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.btE().fFi.fSj = true;
                AlaMasterLiveRoomOpearator.this.bxi();
                if (AlaMasterLiveRoomOpearator.this.fxy != null) {
                    AlaMasterLiveRoomOpearator.this.fxy.b(AlaMasterLiveRoomOpearator.this.kD(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void btD() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fKB);
            }
        });
        this.fKr.C(this.fJd, z);
        this.fKr.h(this.fJd, z, (this.fzs == null || this.fzs.fFO == null || this.fzs.fFO.mChallengeData == null) ? false : true);
    }

    public boolean bxg() {
        return this.fKr != null && this.fKr.btI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxh() {
        if (this.fJC != null) {
            this.fJC.setVisible(8);
            this.fJC.setCanVisible(false);
        }
        if (this.fwg != null) {
            this.fwg.jP(true);
            ki(true);
        }
        if (this.fJF != null) {
            this.fJF.setCanVisible(false);
            this.fJF.setVisibility(4);
        }
        if (this.fJB != null) {
            this.fJB.kW(false);
        }
        if (this.fxb != null) {
            this.fxb.Be().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxi() {
        if (this.fJC != null) {
            this.fJC.setCanVisible(true);
        }
        if (this.fwg != null) {
            this.fwg.jP(false);
            ki(false);
        }
        if (this.fJF != null) {
            this.fJF.setCanVisible(true);
        }
        if (this.fJB != null) {
            this.fJB.kW(true);
        }
        if (this.fxb != null) {
            this.fxb.Be().setNeedTopAlphaShade(false);
        }
    }

    private void ki(boolean z) {
        ViewGroup.LayoutParams qm;
        if (this.fwg != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.fwg;
            AlaLiveView alaLiveView = btE().fFi;
            if (z) {
                qm = bxV();
            } else {
                qm = qm(1);
            }
            bVar.a(1, alaLiveView, qm, 21);
            this.fwg.updateView();
        }
    }

    private void bxj() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.fJF == null) {
            this.fJF = new AlaLiveStreamStatusView(btE().pageContext.getPageActivity());
        }
        this.fJF.setId(a.g.ala_live_room_stream_view);
        this.fJF.setVisibility(4);
        this.fJF.setLayoutParams(layoutParams);
        if (this.fJF.getParent() == null) {
            btE().fFi.addView(this.fJF, layoutParams);
        }
    }

    public void bxk() {
        if (this.fJw != null && this.fJw.getVisibility() != 8 && btE().fFH.getPreview() != null) {
            btE().fFH.stopRecord();
        }
    }

    public void bxl() {
        if (btE().fFH.getPreview() != null) {
            btE().fFH.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fKo != null) {
                this.fKo.ko(false);
            }
            this.fKo = new com.baidu.tieba.ala.liveroom.g.b(btE().rootView, btE(), btE().fFH);
            this.fKo.a(btE().fFH.getVideoConfig(), false);
        }
        if (this.fJD != null) {
            this.fJD.bAd();
        }
        this.mHandler.post(this.fKB);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fJv = z;
        if (z) {
            if (this.fKn) {
                this.fKn = false;
                if (this.fxb != null && this.fxb.Be() != null) {
                    this.fxb.Be().getView().setBottom(0);
                }
                if (this.fxb != null && this.fxb.Bf() != null) {
                    this.fxb.Bf().getView().setBottom(0);
                }
            }
            if (this.fxb != null && this.fxb.Be() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fxb.Be().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.fxb.Be().getView().setLayoutParams(layoutParams);
            }
            if (this.fxb != null && this.fxb.Bf() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fxb.Bf().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.fxb.Bf().getView().setLayoutParams(layoutParams2);
                this.fxb.Bf().getView().setVisibility(0);
                this.fxb.Bf().CR();
            }
            qK(8);
            qJ(8);
        } else {
            if (this.fxb != null && this.fxb.Be() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fxb.Be().getView().getLayoutParams();
                layoutParams3.bottomMargin = btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fxb.Be().getView().setLayoutParams(layoutParams3);
            }
            if (this.fxb != null && this.fxb.Bf() != null) {
                this.fxb.Bf().hide();
            }
            qK(0);
            qJ(0);
        }
        if (this.fJw != null) {
            this.fJw.E(false, z);
        }
        if (this.fxc != null) {
            this.fxc.Bm();
        }
        if (this.fJY != null) {
            this.fJY.onKeyboardVisibilityChanged(z);
        }
        if (this.fxb != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(btE().pageContext.getPageActivity())) + btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (btE().fFi.indexOfChild(this.fxb.Be().getView()) != -1 && this.fxb.Be().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fxb.Be().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.fxb.Be().getView().setLayoutParams(layoutParams4);
            }
            this.fxb.Be().Bd();
        }
        this.mHandler.post(this.fKB);
    }

    private void qJ(int i) {
        if (this.fwa != null) {
            this.fwa.qw(i);
        }
        if (this.fJH != null) {
            this.fJH.setVisibility(i);
        }
        if (this.fwP != null) {
            this.fwP.getView().setVisibility(i);
        }
        if (this.fJA != null) {
            this.fJA.setVisible(i);
        }
        if (this.fJz != null) {
            this.fJz.setVisibility(i);
        }
        if (this.fwg != null) {
            this.fwg.setVisible(i);
        }
        if (this.fxy != null) {
            this.fxy.setCanVisible(i == 0);
        }
        if (this.fxm != null) {
            this.fxm.setVisible(i);
        }
        if (this.fxw != null) {
            this.fxw.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            btE().fFL.errCode = 1;
            bxF();
        } else if (i == -5) {
            bxG();
        } else if (i == -2) {
            AQ(btE().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            btE().fFH.stopRecord();
        } else if (i == -3 && this.fJw != null) {
            this.fJw.kp(false);
        }
        if (i == -4) {
            if (this.fJw == null || this.fJw.getView().getParent() == null) {
                btE().f((short) 1);
                return;
            }
            this.fJw.bvb();
            this.fJP.setVisibility(0);
            if (this.fJB != null) {
                this.fJB.kX(true);
            }
            btE().fFi.setBackgroundColor(btE().pageContext.getResources().getColor(17170445));
            bxS();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bte();
        if (i == 12001) {
            if (i2 == -1) {
                AR(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aQA();
        }
    }

    public void onResume() {
        if (this.fJw != null) {
            this.fJw.onResume();
        }
        if (this.fKa && this.fJZ != null) {
            this.fKa = false;
            c(this.fJZ);
        }
        if (this.fxo != null) {
            this.fxo.onResume();
        }
    }

    public void g(short s) {
        if (this.fxa != null) {
            this.fxa.xi();
        }
        if (this.fxb != null) {
            this.fxb.a(null);
            this.fxb.AJ();
        }
        if (this.fxc != null) {
            this.fxc.AJ();
        }
        if (this.fKr != null) {
            this.fKr.btH();
        }
    }

    public boolean bxm() {
        n DM = btE().fFh.DM();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fzj.fFN.i(DM);
            if (DM != null && DM.mLiveInfo.live_status != 1) {
                bxQ();
                btE().pageContext.getPageActivity().finish();
                if (btE().fFh != null && btE().fFh.DM() != null) {
                    a(DM, 1, btE().fFh.bzn() != 1 ? btE().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.fxb != null) {
                this.fxb.Be().a(String.valueOf(DM.mLiveInfo.group_id), String.valueOf(DM.mLiveInfo.live_id), true, String.valueOf(DM.aqk.userId));
            }
            if (this.fxc != null) {
                this.fxc.a(DM);
            }
            if (this.fwP != null) {
                this.fwP.a(btE().fFh.DM());
            }
            if (this.fwa != null) {
                this.fwa.t(DM);
            }
            if (DM != null) {
                if (this.fJy != null) {
                    this.fJy.p(DM);
                }
                if (this.fKr != null) {
                    this.fKr.a(DM);
                }
                if (this.fxe != null && DM.mLiveInfo != null) {
                    this.fxe.a(DM.mLiveInfo);
                }
                if (this.fxy != null) {
                    this.fxJ = this.fxy.m(DM);
                }
                if (this.fwg != null) {
                    this.fwg.jQ(this.fxJ);
                    this.fwg.h(DM);
                    this.fwg.updateView();
                }
                if (this.fxw != null) {
                    this.fxw.a(DM);
                }
                if (DM.mLiveInfo.live_status != 1) {
                    bxQ();
                    btE().pageContext.getPageActivity().finish();
                    if (btE().fFh != null && btE().fFh.DM() != null) {
                        a(DM, 1, btE().fFh.bzn() != 1 ? btE().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.fKs) {
                    this.fJS.setVisibility(0);
                    if (!this.fKq && DM.mLiveInfo != null) {
                        this.fKq = true;
                        com.baidu.live.utils.o.g(DM.mLiveInfo.feed_id, DM.mLiveInfo.live_id);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
                } else {
                    this.fJS.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bxn() {
        bxd();
    }

    public void bxo() {
        if (this.fKo != null) {
            this.fKo.buV();
        }
    }

    public void bxp() {
        if (this.fJw != null && this.fJw.getVisibility() != 8) {
            if (btE().bvh() == 2) {
                bxS();
            } else {
                bxR();
            }
        }
        if (this.fJw != null && this.fJw.getVisibility() != 8) {
            if (btE().bvh() == 1) {
                this.fJw.onResume();
            }
            this.fJw.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.fxE && this.fJV != null) {
            if (this.fxb != null) {
                this.fxb.Be().getView().setVisibility(0);
            }
            if (this.fxb != null) {
                this.fxb.Bf().show();
                this.fxb.Bf().setEditText(" @" + this.fJV.getNameShow() + " ");
            }
            qK(8);
            this.fxE = false;
        }
        if (this.fxl != null) {
            this.fxl.resume();
        }
        if (this.fKu != null) {
            this.fKu.resume();
        }
        if (this.fKv != null) {
            this.fKv.resume();
        }
    }

    public void onPause() {
        if (this.fxl != null) {
            this.fxl.pause();
        }
        if (this.fKu != null) {
            this.fKu.pause();
        }
        if (this.fxo != null) {
            this.fxo.onPause();
        }
        if (this.fKv != null) {
            this.fKv.pause();
        }
    }

    private void bxq() {
        this.fJG = (RelativeLayout) btE().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.fJI = (RelativeLayout) btE().rootView.findViewById(a.g.under_live_view_panel);
        this.fJJ = (RelativeLayout) btE().rootView.findViewById(a.g.over_live_view_panel);
        this.fzj.fFi.setOnLiveViewScrollListener(this.fKR);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fJI.setVisibility(8);
            this.fJJ.setVisibility(8);
            btE().fFi.removeAllViews();
            return;
        }
        this.fJH = (RelativeLayout) btE().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fJH.getLayoutParams();
        layoutParams.topMargin = this.fzj.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fzj.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fJH.setLayoutParams(layoutParams);
        if (this.fwe == null) {
            this.fwe = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.fzj.pageContext.getPageActivity(), false);
        }
        this.fwe.a(this.fwF);
        this.fwe.a(this.fJH, a.g.ala_live_room_host_header_stub, 1L);
        this.fwe.setVisible(0);
        this.fJP = (ImageView) btE().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.fJP.setOnClickListener(this.fKI);
        this.fJR = (ImageView) btE().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.fJR.setOnClickListener(this.fKI);
        if (com.baidu.live.v.a.En().aRB != null && com.baidu.live.v.a.En().aRB.avy != null && com.baidu.live.v.a.En().aRB.avy.vd() && aq.b(com.baidu.live.v.a.En().aRB)) {
            this.fJR.setVisibility(0);
        } else {
            this.fJR.setVisibility(8);
        }
        if (aq.c(com.baidu.live.v.a.En().aRB)) {
            this.fJP.setVisibility(0);
            if (aq.c(com.baidu.live.v.a.En().aRB)) {
                this.fJP.setAlpha(0.2f);
            }
        } else if (btE().fFH.hasBeauty() < 0) {
            this.fJP.setVisibility(8);
        } else {
            if (aq.c(com.baidu.live.v.a.En().aRB)) {
                this.fJP.setAlpha(0.2f);
            }
            com.baidu.live.c.tG().getInt("live_beauty_level", 3);
        }
        this.fJO = (ImageView) btE().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.fJO.setOnClickListener(this.fKI);
        this.fJM = (ImageView) btE().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.fJM.setOnClickListener(this.fKI);
        this.fzr = (ImageView) btE().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.fzr.setOnClickListener(this.fKI);
        this.fJN = (ImageView) btE().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.fJN.setOnClickListener(this.fKI);
        this.fJQ = (ImageView) btE().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.fJQ.setOnClickListener(this.fKI);
        this.fJS = btE().rootView.findViewById(a.g.host_goods_layout);
        this.fJT = (ImageView) btE().rootView.findViewById(a.g.host_goods_imageView);
        this.fJU = (TextView) btE().rootView.findViewById(a.g.host_goods_num_textView);
        this.fJT.setOnClickListener(this.fKI);
        bxt();
        if (aq.b(com.baidu.live.v.a.En().aRB)) {
            this.fKo = new com.baidu.tieba.ala.liveroom.g.b(btE().rootView, btE(), btE().fFH);
        }
        this.fxa = new o();
        bxr();
        bxs();
    }

    private void bxr() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, btE().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fxb = (k) runTask.getData();
            this.fxb.setFromMaster(true);
            this.fxb.Be().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(btE().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(btE().pageContext.getPageActivity()) * 0.27f)) + btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            btE().fFi.addView(this.fxb.Be().getView(), layoutParams);
            this.fxb.Bf().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            btE().fFi.addView(this.fxb.Bf().getView(), layoutParams2);
            this.fxb.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                @Override // com.baidu.live.im.k.a
                public boolean Bg() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Bh() {
                }

                @Override // com.baidu.live.im.k.a
                public void eE(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Bi() {
                }

                @Override // com.baidu.live.im.k.a
                public void Bj() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Bk() {
                    return false;
                }
            });
        }
    }

    private void bxs() {
        View Bl;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, l.class, btE().pageContext);
        if (runTask != null) {
            this.fxc = (l) runTask.getData();
        }
        if (this.fxc != null && (Bl = this.fxc.Bl()) != null && this.fzj.fFi.indexOfChild(Bl) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.fzj.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = btE().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            btE().fFi.addView(Bl, layoutParams);
        }
    }

    private void bxt() {
        CustomResponsedMessage runTask;
        if (this.fJW == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, btE().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fJW = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bxu() {
        View wH;
        u.b(btE().pageContext);
        if (this.fxd == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.ayo = true;
            fVar.context = btE().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, v.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxd = (v) runTask.getData();
                if (this.fxd != null && (wH = this.fxd.wH()) != null && btE().fFi.indexOfChild(wH) < 0) {
                    if (wH.getParent() instanceof ViewGroup) {
                        ((ViewGroup) wH.getParent()).removeView(wH);
                    }
                    btE().fFi.addView(wH, btE().fFi.getLayoutParams());
                }
            }
        }
    }

    protected void bsP() {
        View wZ;
        if (this.fxe == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.ayo = true;
            aVar.context = btE().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, t.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxe = (t) runTask.getData();
            }
        }
        if (this.fxe != null && (wZ = this.fxe.wZ()) != null) {
            if (btE().fFi.indexOfChild(wZ) < 0) {
                if (wZ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) wZ.getParent()).removeView(wZ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                btE().fFi.addView(wZ, layoutParams);
            }
            wZ.bringToFront();
        }
    }

    protected void bsO() {
        View xj;
        if (this.fxo == null) {
            aa aaVar = new aa();
            aaVar.ayo = true;
            aaVar.pageContext = btE().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, x.class, aaVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxo = (x) runTask.getData();
            }
        }
        if (this.fxo != null && (xj = this.fxo.xj()) != null && btE().fFi.indexOfChild(xj) < 0) {
            if (xj.getParent() instanceof ViewGroup) {
                ((ViewGroup) xj.getParent()).removeView(xj);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            btE().fFi.addView(xj, layoutParams);
        }
    }

    private void bxv() {
        bxz();
        brR();
        bxy();
        btE().fFi.setVisibility(0);
        qK(0);
    }

    private void bxw() {
        if (this.fJA == null) {
            this.fJA = new com.baidu.tieba.ala.liveroom.r.a(btE().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.fJA.a(btE().bvh(), j, TbadkCoreApplication.getCurrentAccountName(), true, btE().fFh.DM().aqk.portrait, this.otherParams, "", -1L);
        this.fJA.ah(btE().fFi);
    }

    private void bxx() {
        if (this.fJY == null) {
            com.baidu.live.w.a ej = ej(btE().pageContext.getPageActivity());
            if (ej != null) {
                this.fJY = ej;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, btE().pageContext.getPageActivity());
                if (runTask != null) {
                    this.fJY = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.fJY != null) {
                this.fJY.i(this.fJI);
                this.fJY.j(this.fJJ);
                this.fJY.cx((btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.fwT != null) {
                    this.fJY.cw(this.fwT.bBb());
                }
                this.fJY.k(btE().fFi);
                this.fJY.a(this.fvi);
                this.fJY.setLiveShowInfo(btE().fFh.DM());
                this.fJY.a(this.fwg);
                this.fJY.a(new a.InterfaceC0153a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // com.baidu.live.w.a.InterfaceC0153a
                    public void Ey() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0153a
                    public void Ez() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0153a
                    public void a(com.baidu.live.w.b bVar) {
                        if (AlaMasterLiveRoomOpearator.this.btE().fFH != null && bVar != null) {
                            if (bVar.bitmap == null) {
                                AlaMasterLiveRoomOpearator.this.btE().fFH.onStickerItemSelected(null);
                                return;
                            }
                            Sticker sticker = new Sticker();
                            sticker.setBitmap(bVar.bitmap);
                            AlaMasterLiveRoomOpearator.this.btE().fFH.onStickerItemSelected(sticker);
                        }
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0153a
                    public void E(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.btE().fFH != null) {
                            AlaMasterLiveRoomOpearator.this.btE().fFH.onStickerItemSelected(obj);
                        }
                    }
                });
            }
        }
    }

    private com.baidu.live.w.a ej(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).af(context);
        }
        return null;
    }

    private void bxy() {
        if (this.fJC == null) {
            this.fJC = new b(btE().pageContext, btE().fFi);
        }
    }

    private void bxz() {
        if (this.fwa == null) {
            this.fwa = new com.baidu.tieba.ala.liveroom.l.a(btE().pageContext, true, this.fKM);
            this.fwa.c(this.fJG, (n) null);
            this.fwa.a(this.fwF);
        }
        if (this.fJx == null) {
            this.fJx = new com.baidu.tieba.ala.liveroom.l.a(btE().pageContext, true, null);
            this.fJx.a(this.fJH, null, a.g.ala_live_room_host_header_stub);
            this.fJx.bwt();
        }
    }

    protected void bsy() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bzd = btE().fFh.bzd();
        boolean z2 = com.baidu.live.v.a.En().aQu.atx;
        if (bzd == null || bzd.aqO) {
            z = z2;
        }
        if (z && this.fwP == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, btE().pageContext)) != null) {
            this.fwP = (com.baidu.live.h.a) runTask.getData();
            if (this.fwP != null) {
                this.fwP.setIsHost(true);
                this.fwP.ck(1);
                View view = this.fwP.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(btE().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(btE().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.fJH.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(n nVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.fwg == null) {
            this.fwg = new com.baidu.tieba.ala.liveroom.activeview.b(btE().pageContext);
        }
        this.fwg.setOtherParams(this.otherParams);
        this.fwg.b(nVar, false);
        this.fwg.setHost(true);
        this.fwg.a(1, btE().fFi, qm(1));
        this.fwg.a(2, btE().fFi, qm(2));
        this.fwg.jQ(this.fxJ);
        this.fwg.setVisible(this.fJv ? 8 : 0);
        this.fwg.a(this.fvi);
        if (this.fvi != null) {
            if (this.fwg != null) {
                alaActiveRootView2 = this.fwg.qh(1);
                alaActiveRootView = this.fwg.qh(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.fvi.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.fvi.a(alaActiveRootView);
            }
        }
    }

    private void u(n nVar) {
        CustomResponsedMessage runTask;
        if (this.fxy == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, btE().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fxy = (com.baidu.live.q.a) runTask.getData();
            if (this.fxy != null) {
                this.fxy.a(btE().fFi, kD(false));
            }
        }
        if (this.fxy != null) {
            this.fxJ = this.fxy.m(nVar);
            this.fxy.setCanVisible(!this.fJv);
        }
    }

    protected void bxA() {
        CustomResponsedMessage runTask;
        if (btE() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, btE().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fxw = (com.baidu.live.i.a) runTask.getData();
            this.fxw.a(btE().fFi, bxB());
            if (btE().fFh != null) {
                this.fxw.a(btE().fFh.DM());
            }
            this.fxw.setCanVisible(true);
            this.fxw.bs(false);
            this.fxw.a(btE().fFh.bnp());
        }
    }

    private void bsH() {
        this.fKv = new com.baidu.tieba.ala.liveroom.n.c(btE().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bxB() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(btE().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.fxm != null && this.fxm.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fJA != null && this.fJA.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams qm(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(btE().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.fJF != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(btE().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup.LayoutParams kD(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = btE().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.fKr != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.fKr.aS(true) + btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fJF != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void brR() {
        if (this.fJz == null) {
            this.fJz = new com.baidu.tieba.ala.liveroom.b.a(btE().pageContext, true);
        }
    }

    private void bxC() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = btE().pageContext.getPageActivity();
            this.fyF = new ImageView(pageActivity);
            this.fyF.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.fyF.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fyF.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            btE().rootView.addView(this.fyF, layoutParams);
            this.fyF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bxO();
                }
            });
            this.fyF.setVisibility(8);
        }
    }

    private void bsF() {
        this.fxl = new com.baidu.tieba.ala.liveroom.f.a(btE().pageContext);
    }

    private void bsT() {
        if (this.fxm == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, btE().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fxm = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.fxm.setHost(true);
        this.fxm.setOtherParams(this.otherParams);
        if (btE().fFh.DM() != null && btE().fFh.DM().aqk != null && btE().fFh.DM().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fxm.a(btE().fFi, layoutParams, btE().fFh.DM());
        }
    }

    private void bxD() {
        CustomResponsedMessage runTask;
        if (this.fKt == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, btE().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.fKt = (com.baidu.live.b.a) runTask.getData();
            if (this.fKt != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = btE().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fKt.a(btE().fFi, layoutParams);
            }
        }
        if (this.fKt != null) {
            this.fKt.a(btE().fFh.DM());
        }
    }

    private void bxE() {
        CustomResponsedMessage runTask;
        if (this.fKu == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, btE().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.fKu = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fKr != null) {
            this.fKr.onRtcConnected(i);
        }
    }

    private void registerListener() {
        btE().pageContext.registerListener(this.fxS);
        btE().pageContext.registerListener(this.fKC);
        btE().pageContext.registerListener(this.fxU);
        btE().pageContext.registerListener(this.fxV);
        btE().pageContext.registerListener(this.fKJ);
        btE().pageContext.registerListener(this.aYB);
        btE().pageContext.registerListener(this.ftV);
        btE().pageContext.registerListener(this.fKK);
        btE().pageContext.registerListener(this.fxT);
        btE().pageContext.registerListener(this.fys);
        btE().pageContext.registerListener(this.fKT);
        btE().pageContext.registerListener(this.fKU);
        btE().pageContext.registerListener(this.fKV);
        btE().pageContext.registerListener(this.fya);
        btE().pageContext.registerListener(this.fKG);
        btE().pageContext.registerListener(this.fKH);
        btE().pageContext.registerListener(this.fKD);
        btE().pageContext.registerListener(this.aQd);
        btE().pageContext.registerListener(this.aQe);
        btE().pageContext.registerListener(this.fKE);
        btE().pageContext.registerListener(this.fyc);
        btE().pageContext.registerListener(this.fyb);
        btE().pageContext.registerListener(this.fyd);
        btE().pageContext.registerListener(this.fKF);
        btE().pageContext.registerListener(this.fKE);
        btE().pageContext.registerListener(this.aNp);
        btE().pageContext.registerListener(this.aLh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        if (aq.c(com.baidu.live.v.a.En().aRB)) {
            btE().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (btE().fFK.tT() == null || ListUtils.isEmpty(btE().fFK.tT().anP)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                btE().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.fKw) {
                this.fKx = BdUniqueId.gen();
                btE().fFK.a(this.fKx);
                this.fKw = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(btE().pageContext.getPageActivity(), btE().rootView);
            qK(8);
            if (btE().fFH.hasAdvancedBeauty() && this.fKo != null) {
                if (!this.fKy || this.fJw.getVisibility() == 0) {
                    this.fKo.a(btE().fFH.getVideoConfig());
                }
                this.fKo.a(btE().fFH.getVideoConfig(), this.fKp);
                if (!this.fKp) {
                    this.fKp = true;
                }
            }
            if (z && this.fxb != null) {
                this.fxb.Be().getView().setVisibility(4);
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
    public void bxF() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(btE().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.btE().f((short) 1);
            }
        });
        bdAlertDialog.create(btE().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxG() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(btE().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.btE().f((short) 1);
            }
        });
        bdAlertDialog.create(btE().pageContext).show();
    }

    private void AQ(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.btE().f((short) 1);
            }
        });
        bdAlertDialog.create(btE().pageContext).show();
    }

    public void bxH() {
        bsy();
        com.baidu.live.data.h bnp = btE().fFh.bnp();
        int i = 5;
        if (bnp != null) {
            i = (int) bnp.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.btE().fFh.DM() != null && AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.btE().fFh.dF(AlaMasterLiveRoomOpearator.this.btE().fFh.DM().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bnp != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fzj.fFN.b(bnp);
                return;
            }
            if (this.fvZ == null) {
                this.fvZ = new com.baidu.tieba.ala.liveroom.audiencelist.c(btE().pageContext, this.fKM, true);
            }
            if (this.fKm) {
                this.fKm = false;
                this.fvZ.a(String.valueOf(btE().fFh.DM().mLiveInfo.group_id), String.valueOf(btE().fFh.DM().mLiveInfo.live_id), String.valueOf(btE().fFh.DM().aqk.userId), btE().fFh.DM());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.fwP != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.fvZ.c(this.fJH, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.fvZ.e(bnp);
            this.fwe.setVisible(0);
            this.fwe.dk(bnp.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxI() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQA() {
        if (btE().fFh != null) {
            if (this.fwQ == null) {
                this.fwQ = new com.baidu.tieba.ala.liveroom.share.c(btE().pageContext);
            }
            this.fwQ.c(btE().fFh.DM(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (btE().fFh != null && btE().fFh.DM() != null && btE().fFh.DM().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", btE().fFh.DM().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", btE().fFh.DM().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", btE().fFh.DM().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (btE().fFh != null && btE().fFh.DM() != null && btE().fFh.DM().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", btE().fFh.DM().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", btE().fFh.DM().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", btE().fFh.DM().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bxJ() {
        return this.fJu;
    }

    private void kF(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(fJt, z);
        this.fJu = z;
    }

    private void bxK() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btE().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.btE().pageContext).byL();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(btE().pageContext).show();
    }

    private void bxL() {
        if (this.fJd && btE().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            btE().fFM.Fe();
        }
        btE().fFL.prepareTime = System.currentTimeMillis() - btE().fFL.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (btE().fFh != null && btE().fFh.DM() != null && btE().fFh.DM().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", btE().fFh.DM().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", btE().fFh.DM().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", btE().fFL.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fJw != null && this.fJw.getView().getParent() != null) {
            this.fJw.setVisibility(8);
            btE().rootView.removeView(this.fJw.getView());
            this.fJw.release();
        }
        if (this.fKo != null) {
            this.fKo.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (btE().fFi.indexOfChild(this.fJE) < 0) {
            btE().fFi.addView(this.fJE, layoutParams);
        }
        this.fJE.qZ(1000);
    }

    private void bte() {
        if (btE().bvh() == 1) {
            btE().fFH.startRecord();
        }
    }

    private void AR(String str) {
        AS(str);
    }

    private void AS(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) btE().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String O(Intent intent) {
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

    private void P(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.fJw != null) {
            this.fJw.AG(fromJson.getSmallurl());
        }
    }

    private boolean bxM() {
        return com.baidu.live.c.tG().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxN() {
        com.baidu.live.c.tG().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.fzj.fFH.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxO() {
        int i = a.i.live_close_confirm;
        if (this.fKr != null && this.fKr.btJ()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.fKr != null && this.fKr.btI()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btE().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.btE().fFh.DM() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.btE().fFh.DM(), 0, AlaMasterLiveRoomOpearator.this.btE().fFh.bzn() != 1 ? AlaMasterLiveRoomOpearator.this.btE().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(btE().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (nVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = nVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = nVar.aqk;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                btE().fFh.di(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.fKk) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = btE().fFL;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = btE().fFH.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.fKg;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.fKh;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.fKc;
            if (this.fKd != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.fKe - this.fKf) / this.fKd) * 100.0f;
            }
            Intent intent = new Intent(btE().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (btE().fFh != null && btE().fFh.DM() != null && btE().fFh.DM().aqk != null) {
                String str3 = btE().fFh.DM().aqk.nickName;
                String str4 = btE().fFh.DM().aqk.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            n DM = btE().fFh.DM();
            if (DM != null && DM.aqk != null && !TextUtils.isEmpty(DM.aqk.portrait)) {
                intent.putExtra("host_portrait", DM.aqk.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.fKi = intent;
                this.fKj = s;
                btE().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bxP() {
        if (this.fKi != null) {
            a(this.fKi, this.fKj);
            this.fKi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.fKk = true;
        if (this.fKr != null) {
            this.fKr.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.ftK);
            btE().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        btE().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxQ() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fzj.fFN != null && this.fzj.fFN.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.fKr != null && this.fKr.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (btE().fFJ.byx()) {
                bxO();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.fJF != null) {
                this.fJF.setVisibility(4);
                return;
            }
            return;
        }
        if (this.fJF != null) {
            this.fJF.a(i, z, i2, z2);
        }
        if (this.fzj != null && this.fzj.fFh != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cun != i3) {
                this.cun = i3;
                if (this.fJD == null) {
                    this.fJD = new com.baidu.tieba.ala.liveroom.tippop.a(this.fzj.pageContext, null);
                }
                switch (this.cun) {
                    case 0:
                        this.fJD.a(this.fzj.rootView, this.fzj.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.fJD.a(this.fzj.rootView, this.fzj.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.fJD.a(this.fzj.rootView, this.fzj.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.fzj.fFh.j(this.fzj.fFh.DM().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.bxQ();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.btE().fFh.DM(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0527, code lost:
        Ax(r6);
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
            if (this.fJB != null) {
                this.fJB.z(aVar);
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
                            if (this.fKr != null) {
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
            if (this.fKr != null) {
                this.fKr.dJ(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bxQ();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.btE().fFh.DM(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (btE().fFh.DM() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            btE().fFh.DM().aqD.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            btE().fFh.DM().aqD.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        btE().fFh.DM().aqD.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (btE().fFh.DM() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (btE().fFh.DM() != null && btE().fFh.DM().aqk != null && btE().fFh.DM().aqk.userId == optLong2) {
                        btE().fFh.DM().aqk.isUegBlock = 1;
                        bse();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (btE().fFh.DM() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (btE().fFh.DM() != null && btE().fFh.DM().aqk != null && btE().fFh.DM().aqk.userId == optLong3) {
                        btE().fFh.DM().aqk.isUegBlock = 0;
                        bse();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.fJW != null) {
                    this.fJW.B(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.fJC.aD(optString4, optInt2);
                    }
                    if (this.fwe.getCount() > 20) {
                        this.fwe.dk(this.fwe.getCount() + 1);
                    } else if (this.fvZ != null) {
                        com.baidu.live.data.a Ce = aVar.Ce();
                        com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                        gVar.aql = new AlaLocationData();
                        gVar.aqm = new AlaRelationData();
                        gVar.aqk = new AlaLiveUserInfoData();
                        gVar.aqk.userId = JavaTypesHelper.toLong(Ce.userId, 0L);
                        gVar.aqk.userName = Ce.userName;
                        gVar.aqk.portrait = Ce.portrait;
                        if (this.fvZ.c(gVar)) {
                            this.fwe.dk(this.fwe.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && btE().fFh.DM() != null && btE().fFh.DM().mLiveInfo != null) {
                    String str5 = btE().fFh.DM().mLiveInfo.feed_id;
                    long j4 = btE().fFh.DM().mLiveInfo.live_id;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!m.h(j4, optLong4)) {
                        com.baidu.live.utils.o.g(str5, j4);
                        m.i(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && btE() != null && btE().fFh != null && btE().fFh.DM() != null && btE().fFh.DM().aqD != null && btE().fFh.DM().aqD.userId == jSONObject2.optLong("user_id")) {
                    btE().fFh.bzc();
                }
            } else if ("official_notice".equals(str2) && jSONObject2 != null) {
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
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a Ce2 = aVar.Ce();
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
                String str7 = null;
                if (btE().fFh != null && btE().fFh.DM() != null && btE().fFh.DM().mLiveInfo != null) {
                    j5 = btE().fFh.DM().mLiveInfo.live_id;
                    j6 = btE().fFh.DM().mLiveInfo.group_id;
                    j7 = btE().fFh.DM().aqk.userId;
                    str7 = btE().fFh.DM().mLiveInfo.appId;
                    if (btE().fFh.DM().mLiveSdkInfo.mCastIds != null) {
                        String str8 = btE().fFh.DM().mLiveSdkInfo.mCastIds.aqw;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = btE().fFh.DM().mLiveSdkInfo.mCastIds.aqx;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || btE().bvh() != 2) {
                            if (TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    u.b(optString11, Ce2.userId, Ce2.portrait, Ce2.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString10, "", "", aVar.getMsgId());
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString11);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.v.d.Eu().eQ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                u.b(optString5, Integer.parseInt(optString6), optString7, optString8, Ce2.userId, Ce2.portrait, Ce2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3, aVar.getMsgId());
                            }
                        }
                        Ax(optString5);
                        com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
                        dVar.fEF = optLong6;
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
                u.b(optString5, Integer.parseInt(optString6), optString7, optString8, Ce2.userId, Ce2.portrait, Ce2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3, aVar.getMsgId());
                Ax(optString5);
                com.baidu.tieba.ala.liveroom.e.d dVar2 = new com.baidu.tieba.ala.liveroom.e.d();
                dVar2.fEF = optLong6;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void Ax(String str) {
        if (this.fwg != null) {
            this.fwg.Ax(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(int i) {
        View findViewById = btE().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.fwg != null) {
            this.fwg.bp(2, i);
        }
    }

    private void bxR() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.btE().fFH != null && AlaMasterLiveRoomOpearator.this.btE().fFH.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.btE().fFH.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.btE().fFH.startRecord();
                }
            }
        });
    }

    private void bxS() {
        if (btE().fFH != null && btE().fFH.getPreview() != null) {
            btE().fFH.getPreview().setVisibility(8);
            btE().fFH.stopRecord();
        }
    }

    public void bxT() {
        this.fFE = btE().fFh.bzo();
        if (this.fJw != null) {
            this.fJw.kq(this.fFE);
        }
    }

    public void bvf() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bxU();
        } else if (this.fJw != null) {
            this.fJw.bvf();
        }
    }

    public void onDestroy() {
        if (this.fKb != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.fKb);
        }
        this.fKb = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fKo != null) {
            this.fKo.ko(true);
        }
        this.fKo = null;
        if (this.fJw != null) {
            this.fJw.destroy();
            btE().rootView.removeView(this.fJw.getView());
            this.fJw.release();
            this.fJw = null;
        }
        if (this.fKr != null) {
            this.fKr.onDestroy();
        }
        if (this.fwQ != null) {
            this.fwQ.onDestroy();
        }
        if (this.fwS != null) {
            this.fwS.onDestroy();
        }
        if (this.fwa != null) {
            this.fwa.onDestroy();
            this.fwa = null;
        }
        if (this.fJx != null) {
            this.fJx.onDestroy();
        }
        if (this.fxo != null) {
            this.fxo.onDestroy();
            this.fxo = null;
        }
        if (this.fJE != null) {
            this.fJE.stopCountDown();
        }
        if (this.fJA != null) {
            this.fJA.onDestroy();
        }
        if (this.fJC != null) {
            this.fJC.onDestroy();
        }
        if (this.fJW != null) {
            this.fJW.onDestroy();
            this.fJW = null;
        }
        if (this.fxd != null) {
            this.fxd.onDestroy();
            this.fxd = null;
        }
        u.xe();
        com.baidu.live.entereffect.a.vn().release();
        if (this.fxe != null) {
            this.fxe.onDestroy();
            this.fxe = null;
        }
        if (this.fJD != null) {
            this.fJD.onDestroy();
        }
        if (this.fJB != null) {
            this.fJB.bBd();
            this.fJB.release();
        }
        if (this.fwe != null) {
            this.fwe = null;
        }
        if (this.fwg != null) {
            this.fwg.release();
        }
        if (this.fJy != null) {
            this.fJy.onDestroy();
        }
        if (this.fJB != null) {
            this.fJB.onDestroy();
        }
        if (this.fxc != null) {
            this.fxc.release();
        }
        if (this.fxl != null) {
            this.fxl.release();
        }
        if (this.fxm != null) {
            this.fxm.onDestroy();
        }
        if (this.fJY != null) {
            this.fJY.onDestroy();
        }
        if (this.fxy != null) {
            this.fxy.release();
        }
        if (this.fKt != null) {
            this.fKt.onDestory();
        }
        if (this.fKu != null) {
            this.fKu.release();
        }
        if (this.fxw != null) {
            this.fxw.onDestroy();
        }
        if (this.fKv != null) {
            this.fKv.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fys);
        MessageManager.getInstance().unRegisterListener(this.fKT);
        MessageManager.getInstance().unRegisterListener(this.fKU);
        MessageManager.getInstance().unRegisterListener(this.fKV);
        MessageManager.getInstance().unRegisterListener(this.fya);
        MessageManager.getInstance().unRegisterListener(this.fKG);
        MessageManager.getInstance().unRegisterListener(this.fKH);
        MessageManager.getInstance().unRegisterListener(this.fKD);
        MessageManager.getInstance().unRegisterListener(this.aQd);
        MessageManager.getInstance().unRegisterListener(this.aQe);
        MessageManager.getInstance().unRegisterListener(this.fKE);
        MessageManager.getInstance().unRegisterListener(this.fyc);
        MessageManager.getInstance().unRegisterListener(this.fyb);
        MessageManager.getInstance().unRegisterListener(this.fyd);
        MessageManager.getInstance().unRegisterListener(this.fKF);
        MessageManager.getInstance().unRegisterListener(this.fKE);
        MessageManager.getInstance().unRegisterListener(this.aNp);
        MessageManager.getInstance().unRegisterListener(this.aLh);
        m.Gg();
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fzj.fFN.a(this.fKX, this.fzj.fFI, this.fJG, alaLivePersonData);
        }
    }

    private void bxU() {
        if (this.fJZ != null) {
            this.fzj.fFL.startTime = System.currentTimeMillis();
            this.fzj.fFL.liveTotalTime = System.currentTimeMillis();
            this.fzj.fFL.sampleMemAndCPU();
            this.fzj.fFJ.a((short) 4, this.fJZ);
        }
    }

    private ViewGroup.LayoutParams bxV() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = btE().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
