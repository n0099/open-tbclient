package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.android.imsdk.account.LoginManager;
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
import com.baidu.live.b.n;
import com.baidu.live.b.r;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.al;
import com.baidu.live.data.am;
import com.baidu.live.data.au;
import com.baidu.live.data.av;
import com.baidu.live.data.ay;
import com.baidu.live.data.bh;
import com.baidu.live.data.u;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.gift.x;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.h;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.p.c;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
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
import com.baidu.live.tbadk.core.util.StringHelper;
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
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
import com.baidu.live.y.a;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.h.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView;
import com.baidu.tieba.ala.liveroom.views.e;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String gFW;
    private boolean bgd;
    private PendantParentView bkG;
    private boolean gFG;
    private boolean gFX;
    private d gFZ;
    private am gGA;
    private com.baidu.live.z.a gGC;
    private com.baidu.tieba.ala.liveroom.master.panel.b gGD;
    private com.baidu.live.y.a gGE;
    private ImageView gGF;
    private e gGG;
    private short gGQ;
    private com.baidu.tieba.ala.liveroom.h.b gGV;
    private boolean gGW;
    private com.baidu.tieba.ala.liveroom.challenge.e gGX;
    private com.baidu.live.a.a gGY;
    private com.baidu.live.a.b gGZ;
    private com.baidu.tieba.ala.liveroom.p.a gGa;
    private com.baidu.tieba.ala.liveroom.b.a gGb;
    private com.baidu.tieba.ala.liveroom.v.a gGc;
    private com.baidu.tieba.ala.liveroom.x.a gGd;
    private b gGe;
    private com.baidu.tieba.ala.liveroom.tippop.a gGf;
    private com.baidu.live.p.d gGg;
    private c gGh;
    protected com.baidu.live.j.a gGi;
    private AlaLiveCountDownView gGj;
    private AlaLiveStreamStatusView gGk;
    private RelativeLayout gGl;
    private RelativeLayout gGm;
    private RelativeLayout gGn;
    private RelativeLayout gGo;
    private FrameLayout gGp;
    private View gGq;
    private boolean gGr;
    private AlaLiveFaceVerifyView gGs;
    private ImageView gGt;
    private ImageView gGu;
    private ImageView gGv;
    private ImageView gGw;
    private ImageView gGx;
    private ImageView gGy;
    private TextView gGz;
    private com.baidu.tieba.ala.liveroom.r.a gHa;
    private boolean gHb;
    private BdUniqueId gHc;
    private boolean gHd;
    private View gHe;
    private FrameLayout gHf;
    private String gnC;
    private com.baidu.live.g.a goY;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gpB;
    private com.baidu.tieba.ala.liveroom.activeview.b gpD;
    private com.baidu.tieba.ala.liveroom.audiencelist.c gpx;
    private com.baidu.tieba.ala.liveroom.p.a gpy;
    private m gqA;
    private k gqB;
    private com.baidu.live.im.b.a gqC;
    private x gqD;
    private v gqE;
    protected h gqM;
    protected z gqO;
    protected com.baidu.live.i.a gqV;
    protected com.baidu.live.p.a gqW;
    protected com.baidu.live.p.b gqX;
    private com.baidu.live.h.a gqn;
    private com.baidu.tieba.ala.liveroom.share.c gqo;
    private com.baidu.tieba.ala.liveroom.s.b gqp;
    private com.baidu.live.u.a grb;
    private com.baidu.live.ae.a grd;
    private boolean gro;
    private boolean gsg;
    private ImageView gtC;
    private g gtD;
    private f gtv;
    private boolean gFY = false;
    private boolean grj = false;
    private Handler mHandler = new Handler();
    private Handler gGB = new Handler();
    private boolean gGH = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver gGI = null;
    private boolean gGJ = false;
    private int gGK = 0;
    private int gGL = 0;
    private int gGM = 0;
    private long gGN = 0;
    private long gGO = 0;
    private volatile boolean isBackground = false;
    private Intent gGP = null;
    private int mOrientation = 1;
    private boolean gAQ = false;
    private boolean gGR = false;
    private boolean gGS = true;
    private boolean gtA = false;
    private boolean gGT = true;
    private boolean gGU = true;
    private int cZx = 0;
    private String otherParams = "";
    private int bgg = 0;
    private Runnable gHg = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.goY != null) {
                AlaMasterLiveRoomOpearator.this.goY.Dv();
            }
        }
    };
    private CustomMessageListener bhf = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gtv.gBa != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gtv.gBa.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.A(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener bhg = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gtv.gBa != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gtv.gBa.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener grI = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gqp == null) {
                        AlaMasterLiveRoomOpearator.this.gqp = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gqp.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener grP = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gqV != null) {
                AlaMasterLiveRoomOpearator.this.gqV.IW();
            }
        }
    };
    private CustomMessageListener gHh = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.r((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener grF = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Go(str);
            }
        }
    };
    private CustomMessageListener grG = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.blQ();
        }
    };
    private CustomMessageListener gpZ = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gqE.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener grM = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener gHi = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gGZ != null) {
                u Fq = AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq();
                long j = Fq.mLiveInfo.live_id;
                long j2 = Fq.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.gGZ.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener gHj = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bQB().gAv);
            if (AlaMasterLiveRoomOpearator.this.gFZ == null || AlaMasterLiveRoomOpearator.this.gFZ.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.uL(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gqB != null) {
                AlaMasterLiveRoomOpearator.this.gqB.JJ().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gqB.JK().hide();
            }
        }
    };
    private CustomMessageListener grO = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.t(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq());
        }
    };
    private CustomMessageListener grQ = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gqO != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) AlaMasterLiveRoomOpearator.this.gqO).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gHk = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gHa != null) {
                    AlaMasterLiveRoomOpearator.this.gHa.hn(str);
                }
            }
        }
    };
    private CustomMessageListener gHl = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.gGV != null) {
                        if (!data.aAp || AlaMasterLiveRoomOpearator.this.gHc == null || !AlaMasterLiveRoomOpearator.this.gHd) {
                            if (AlaMasterLiveRoomOpearator.this.gHc != null && AlaMasterLiveRoomOpearator.this.gHc == data.aAo) {
                                if (data.aAi != null && data.aAi.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.gHd || AlaMasterLiveRoomOpearator.this.gFZ.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.gGV.a(AlaMasterLiveRoomOpearator.this.bQB().gAT.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.gGW = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bQB().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.gHc = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bQB().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.gGV.a(AlaMasterLiveRoomOpearator.this.bQB().gAT.getVideoConfig(), AlaMasterLiveRoomOpearator.this.gGW);
                        if (!AlaMasterLiveRoomOpearator.this.gGW) {
                            AlaMasterLiveRoomOpearator.this.gGW = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gHb) {
                    AlaMasterLiveRoomOpearator.this.bQB().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.gHb = false;
            }
        }
    };
    private CustomMessageListener gHm = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bQB().gAT != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bQB().gAT.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.c.AR().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bgl = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bgg == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bgg == 6) {
                            AlaMasterLiveRoomOpearator.this.bVh();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bgg = 0;
            }
        }
    };
    private View.OnClickListener gHn = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.gGu) {
                    AlaMasterLiveRoomOpearator.this.bVl();
                    AlaMasterLiveRoomOpearator.this.gGD.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.gGt) {
                    if (view == AlaMasterLiveRoomOpearator.this.gGv) {
                        AlaMasterLiveRoomOpearator.this.blQ();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.gGw) {
                        if (view != AlaMasterLiveRoomOpearator.this.gGy) {
                            if (view != AlaMasterLiveRoomOpearator.this.gtC) {
                                if (view == AlaMasterLiveRoomOpearator.this.gGx && AlaMasterLiveRoomOpearator.this.gGd != null) {
                                    al bXm = AlaMasterLiveRoomOpearator.this.bQB().gAu.bXm();
                                    if (bXm == null || bXm.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(bXm.mLiveSdkInfo.mRoomId);
                                        if (bXm.mLiveSdkInfo.mCastIds != null) {
                                            str2 = bXm.mLiveSdkInfo.mCastIds.aEU;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.gGd.ai("", str, str2);
                                    return;
                                }
                                return;
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.gGX != null) {
                                if ((AlaMasterLiveRoomOpearator.this.gqW != null) && AlaMasterLiveRoomOpearator.this.gqW.BP()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity().getResources().getString(a.i.sdk_pking_repeated_initiation_tips));
                                    return;
                                }
                                if (AlaMasterLiveRoomOpearator.this.gqW.MK() & (AlaMasterLiveRoomOpearator.this.gqW != null)) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity().getResources().getString(a.i.sdk_matching_repeated_initiation_tips));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.gGX.bQD()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity().getResources().getString(a.i.sdk_challenge_pking_repeated_initiation_tips));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.gGX.bQE()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity().getResources().getString(a.i.sdk_challenge_pking_repeated_initiation_tips));
                                    return;
                                } else {
                                    AlaMasterLiveRoomOpearator.this.gGX.bQF();
                                    return;
                                }
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.gGE != null) {
                            AlaMasterLiveRoomOpearator.this.gGE.NY();
                            AlaMasterLiveRoomOpearator.this.gGE.cp(AlaMasterLiveRoomOpearator.this.bVp());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.gHd = false;
                        AlaMasterLiveRoomOpearator.this.mw(true);
                        AlaMasterLiveRoomOpearator.this.gGz.setVisibility(4);
                        com.baidu.live.c.AR().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.x.a.NN().bhy.aIG == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.NN().bhy.aIF == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bgd) {
                        AlaMasterLiveRoomOpearator.this.bVh();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bgg = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bVh();
                }
            }
        }
    };
    private CustomMessageListener grH = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof am) {
                    AlaMasterLiveRoomOpearator.this.grj = true;
                    AlaMasterLiveRoomOpearator.this.gGA = (am) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gqB != null) {
                        AlaMasterLiveRoomOpearator.this.gqB.JJ().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gqB != null) {
                        AlaMasterLiveRoomOpearator.this.gqB.JK().show();
                        AlaMasterLiveRoomOpearator.this.gqB.JK().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.uL(8);
                }
            }
        }
    };
    private CustomMessageListener gHo = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bQB() != null && AlaMasterLiveRoomOpearator.this.bQB().gAY != null) {
                AlaMasterLiveRoomOpearator.this.bQB().gAY.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener buw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bVX();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bQB().gAu.uS(i);
            }
        }
    };
    private CustomMessageListener gnN = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bVQ();
        }
    };
    private CustomMessageListener grS = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ae.c)) {
                if (AlaMasterLiveRoomOpearator.this.grd == null) {
                    AlaMasterLiveRoomOpearator.this.grd = new com.baidu.live.ae.a(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.grd.a((com.baidu.live.ae.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener gHp = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Mh()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.gGD != null) {
                            AlaMasterLiveRoomOpearator.this.gGD.mD(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.gGD.bWv();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bQB().gAT.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.gGf != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.gGf.a(AlaMasterLiveRoomOpearator.this.bQB().gAV, AlaMasterLiveRoomOpearator.this.bQB().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bQB().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.gGf.uZ(2);
                        AlaMasterLiveRoomOpearator.this.gGf.a(AlaMasterLiveRoomOpearator.this.bQB().gAV, string, 3);
                    }
                }
            }
        }
    };
    private e.a gHq = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bWd() {
            AlaMasterLiveRoomOpearator.this.uK(a.i.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bWe() {
            AlaMasterLiveRoomOpearator.this.uK(a.i.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a gHr = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.liveroom.a.a
        public boolean eC(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void eD(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bQB().bSx() == 1) {
                AlaMasterLiveRoomOpearator.this.bQB().gAT.stopRecord();
            }
        }
    };
    private IShareCallback gHs = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.gGH && AlaMasterLiveRoomOpearator.this.gGG != null) {
                AlaMasterLiveRoomOpearator.this.gGH = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.gGG);
            }
        }
    };
    private View.OnTouchListener gHt = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bQB().gAY.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bQB().gAv);
            AlaMasterLiveRoomOpearator.this.uL(0);
            if (AlaMasterLiveRoomOpearator.this.gqB != null) {
                AlaMasterLiveRoomOpearator.this.gqB.JJ().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.gqB.JK().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b gHu = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bWf() {
            AlaMasterLiveRoomOpearator.this.bVi();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bWg() {
            AlaMasterLiveRoomOpearator.this.gFG = AlaMasterLiveRoomOpearator.this.gFZ.bSp();
            AlaMasterLiveRoomOpearator.this.bQB().gAY.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bQB().gAY.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bQB().gAY.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gAN = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bQB().bSx();
            eVar.title = AlaMasterLiveRoomOpearator.this.gFZ.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.gAO = AlaMasterLiveRoomOpearator.this.gFZ.bSq();
            eVar.gAR = AlaMasterLiveRoomOpearator.this.gFG;
            eVar.gAQ = AlaMasterLiveRoomOpearator.this.gFZ.bSn();
            eVar.gAP = AlaMasterLiveRoomOpearator.this.gFZ.bSs();
            eVar.gAS = AlaMasterLiveRoomOpearator.this.gFZ.bSo();
            if (eVar.gAS) {
                if (AlaMasterLiveRoomOpearator.this.gFZ.bSt()) {
                    AlaMasterLiveRoomOpearator.this.gGH = true;
                    AlaMasterLiveRoomOpearator.this.gGG = eVar;
                    AlaMasterLiveRoomOpearator.this.gFZ.bSu();
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
            AlaMasterLiveRoomOpearator.this.bQB().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bQB().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bWh() {
            AlaMasterLiveRoomOpearator.this.gHd = true;
            AlaMasterLiveRoomOpearator.this.mw(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bWi() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bWj() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener bcQ = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bOL();
            }
        }
    };
    private com.baidu.live.liveroom.g.c gHv = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Mc() {
            if (AlaMasterLiveRoomOpearator.this.gGd != null) {
                AlaMasterLiveRoomOpearator.this.gGd.mO(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.gGE != null) {
                        AlaMasterLiveRoomOpearator.this.gGE.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gGE != null) {
                    AlaMasterLiveRoomOpearator.this.gGE.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.gGd != null) {
                    AlaMasterLiveRoomOpearator.this.gGd.mO(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gqO != null) {
                    AlaMasterLiveRoomOpearator.this.gqO.bm(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a gHw = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void Yu() {
            if (AlaMasterLiveRoomOpearator.this.gGs != null && AlaMasterLiveRoomOpearator.this.bQB().gAV.indexOfChild(AlaMasterLiveRoomOpearator.this.gGs) >= 0) {
                AlaMasterLiveRoomOpearator.this.bQB().gAV.removeView(AlaMasterLiveRoomOpearator.this.gGs);
                AlaMasterLiveRoomOpearator.this.gGs.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.gGs = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gqe = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void n(View view, int i) {
            u Fq;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bVW();
            } else if (i == 14 && (Fq = AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq()) != null && Fq.aEz != null && Fq.mLiveInfo != null && Fq.aFb != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity(), Fq.aEz.userName, Long.toString(Fq.aEz.userId), Long.toString(Fq.aEz.charmCount), String.valueOf(Fq.mLiveInfo.group_id), String.valueOf(Fq.mLiveInfo.live_id), true, String.valueOf(Fq.aEz.userId), Long.toString(Fq.aFb.userId), Fq.aFb.userName, Fq.aFb.portrait, AlaMasterLiveRoomOpearator.this.gpB.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Fq.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gpB.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a gHx = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
    };
    private com.baidu.live.liveroom.middleware.g gHy = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.ayZ);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        gFW = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && com.baidu.live.x.a.NN().bhy != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bQB().pageContext.getPageActivity(), String.valueOf(uVar.mLiveInfo.live_id), String.valueOf(uVar.mLiveInfo.user_id), com.baidu.live.x.a.NN().bhy.aIB, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Go(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bQB().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bQB().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.x.a.NN().bhy.aHZ;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bQB().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bQB().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bQB().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOL() {
        int i = bQB().gAu.Fq().aEz.isUegBlock;
        int i2 = bQB().gAu.Fq().aEz.isBlock;
        String str = bQB().gAu.Fq().aEz.userName;
        if (i > 0 || i2 > 0) {
            this.bgd = true;
            this.gqB.a(true, i, i2, str);
            return;
        }
        this.bgd = false;
        this.gqB.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gtv.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bfk == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bfl);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gtv.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.gtv.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
        if (this.gqB != null) {
            this.gqB.JK().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.gGX != null) {
            this.gGX.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVi() {
        if (bQB() != null && bQB().gAu != null) {
            bQB().gAu.bXf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bJe() != null && aVar.bJf() != null) {
            bQB().gAu.ei(aVar.bJe().getId(), aVar.bJf().getId());
        }
    }

    /* loaded from: classes4.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.gGJ = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.gGJ = false;
                }
                if (AlaMasterLiveRoomOpearator.this.gGK == 0) {
                    AlaMasterLiveRoomOpearator.this.gGK = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.gGL == 0) {
                    AlaMasterLiveRoomOpearator.this.gGL = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.gGM = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bQB() != null && bQB().gAW != null) {
            bQB().gAW.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.gtv = fVar;
        this.gnC = str;
    }

    protected f bQB() {
        return this.gtv;
    }

    public int a(g gVar) {
        this.gtD = gVar;
        this.gGI = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.gGI, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.gGf == null) {
            this.gGf = new com.baidu.tieba.ala.liveroom.tippop.a(this.gtv.pageContext, null);
        }
        registerListener();
        this.goY = new com.baidu.live.g.a();
        bVA();
        bVj();
        bVk();
        Long[] lArr = new Long[1];
        this.gGN = lArr[0] == null ? 0L : lArr[0].longValue();
        this.gGO = lArr[0] != null ? lArr[0].longValue() : 0L;
        bQB().gAv.setOnTouchListener(this.gHt);
        this.gFX = SharedPrefHelper.getInstance().getBoolean(gFW, false);
        this.gGj = new AlaLiveCountDownView(bQB().pageContext.getPageActivity());
        this.gGj.setCount(3);
        this.gGj.setTextColor(bQB().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.gGj.setTextSize(bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.gGj.setTypeface(Typeface.DEFAULT_BOLD);
        this.gGj.setIncludeFontPadding(false);
        this.gGj.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bWk() {
                if (AlaMasterLiveRoomOpearator.this.bQB().gAv != null) {
                    AlaMasterLiveRoomOpearator.this.bQB().gAv.removeView(AlaMasterLiveRoomOpearator.this.gGj);
                }
            }
        });
        return 1;
    }

    private void bVj() {
        CustomResponsedMessage runTask;
        if (this.gGi == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.j.a.class, bQB().pageContext)) != null && runTask.getData() != null) {
            this.gGi = (com.baidu.live.j.a) runTask.getData();
            this.gGi.c(bQB().pageContext);
        }
    }

    private void bVk() {
        View rootLayout;
        if (this.gGi != null && this.gGp != null && (rootLayout = this.gGi.bX(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gGp.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVl() {
        if (this.gGD == null) {
            this.gGD = new com.baidu.tieba.ala.liveroom.master.panel.b(bQB().pageContext.getPageActivity(), bQB().bSx() == 2);
            this.gGD.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void my(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bQB().gAT.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mz(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bQB().gAT.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mA(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bQB().gAT.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bVV();
                    if (AlaMasterLiveRoomOpearator.this.gGf != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.gGf.a(AlaMasterLiveRoomOpearator.this.bQB().gAV, AlaMasterLiveRoomOpearator.this.bQB().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.gGf.a(AlaMasterLiveRoomOpearator.this.bQB().gAV, AlaMasterLiveRoomOpearator.this.bQB().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mB(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bWl() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bQB().gAu != null && AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq() != null && AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.gGD != null) {
                        AlaMasterLiveRoomOpearator.this.gGD.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.a(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bWm() {
                    if (AlaMasterLiveRoomOpearator.this.gGD != null) {
                        AlaMasterLiveRoomOpearator.this.gGD.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.h(AlaMasterLiveRoomOpearator.this.bQB().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bWn() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bQB() != null && AlaMasterLiveRoomOpearator.this.bQB().gAu != null && AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq() != null && AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(AlaMasterLiveRoomOpearator.this.bQB().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.gGD != null) {
                            AlaMasterLiveRoomOpearator.this.gGD.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bWo() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bQB() == null || AlaMasterLiveRoomOpearator.this.bQB().gAu == null || AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq() == null || AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bQB() != null && AlaMasterLiveRoomOpearator.this.bQB().gAu != null && AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq() != null && AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.gGD != null) {
                                        AlaMasterLiveRoomOpearator.this.gGD.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gtv.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.gGD != null) {
                        AlaMasterLiveRoomOpearator.this.gGD.dismiss();
                    }
                }
            });
        }
        bVm();
    }

    private void bVm() {
        if (this.gGD != null) {
            boolean isBackCamera = bQB().gAT.isBackCamera();
            this.gGD.mC(bQB().gAT.isBackCamera());
            this.gGD.N(bQB().gAT.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bQB().gAT.isPushMirror();
            if (this.gGS) {
                isPushMirror = bVU() || isPushMirror;
                this.gGS = false;
            }
            this.gGD.O(isPushMirror, isBackCamera ? false : true);
            this.gGD.mD(bQB().gAT.isMute());
            this.gGD.bWv();
        }
    }

    public void bVn() {
        if (this.gtD != null) {
            if (this.gtD.gBb == null || this.gtD.gBb.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.gGq == null) {
                        this.gGq = this.gtv.gBa.LF();
                        this.gtv.gAV.addView(this.gGq, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.gFZ == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bQB().gAu != null && bQB().gAu.Fq() != null && bQB().gAu.Fq().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bQB().gAu.Fq().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bQB().gAu.Fq().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.gFZ = new d(bQB().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bQB().gAY.prepareTime = System.currentTimeMillis();
                    bQB().gAV.addView(this.gFZ.getView(), layoutParams);
                    this.gFZ.a(this.gHs);
                }
                this.gFZ.me(this.gAQ);
                this.gFZ.a(this.gHu);
                this.gFZ.a(this.gHq);
                this.gFZ.a(bQB().gAT, bQB().bSx());
                this.gFZ.a(this.gGi);
                return;
            }
            this.gFG = this.gtD.gBb.mLiveInfo.screen_direction == 2;
            if (this.gtD.gBb.mLiveInfo.isAudioOnPrivate == 1) {
                bQB().gAT.setMute(true);
                if (this.gGf == null) {
                    this.gGf = new com.baidu.tieba.ala.liveroom.tippop.a(this.gtv.pageContext, null);
                }
                if (!this.gGf.uY(2)) {
                    this.gGf.a(bQB().gAV, bQB().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gAN = true;
            eVar.forumId = String.valueOf(this.gtD.gBb.mLiveInfo.forum_id);
            eVar.forumName = this.gtD.gBb.mLiveInfo.forum_name;
            eVar.liveType = this.gtD.gBb.mLiveInfo.live_type;
            eVar.title = this.gtD.gBb.mLiveInfo.getLiveTitle();
            eVar.clarity = this.gtD.gBb.mLiveInfo.clarity;
            eVar.gameId = this.gtD.gBb.mLiveInfo.game_id;
            eVar.gameName = this.gtD.gBb.mLiveInfo.game_label;
            eVar.gAR = this.gtD.gBb.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bVo() {
        if (this.gGV != null) {
            this.gGV.a(bQB().gAT.getVideoConfig(), false);
        }
        if (this.gFZ != null) {
            this.gFZ.md(true);
        }
        if (bQB().gAT.hasBeauty() >= 0) {
            bQB().gAT.setBeauty(com.baidu.live.c.AR().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bQB().gBa.H(this.gtv.gAT);
        } else if (this.gFZ != null) {
            this.gFZ.md(true);
        }
        bVz();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.gGq != null && this.gGq.getParent() != null) {
                ((ViewGroup) this.gGq.getParent()).removeView(this.gGq);
                this.gGq = null;
            }
            bQB().gAv.setVisibility(0);
            this.gtv.gBa.a(bQB().gAv);
        } else {
            bVG();
            bVT();
            if (this.gHf != null) {
                this.gHf.setVisibility(0);
            }
            this.gGd = new com.baidu.tieba.ala.liveroom.x.a(bQB().pageContext, this.gHr);
            this.gGd.d(bQB().gAv, true);
            this.gGd.mO(true);
            if (this.gqB != null && this.gqB.JJ() != null) {
                this.gqB.JJ().setNeedTopAlphaShade(true);
            }
        }
        bQB().gAT.setPushMirror(bVU());
    }

    public void b(al alVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gtv.gBa.m(bQB().gAu.Fq());
        }
        if (!bQB().gAT.isBackground() && bQB().gAu.Fq() != null && bQB().gAu.Fq().mLiveInfo != null) {
            int startPush = bQB().gAT.startPush(bQB().gAu.Fq().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gtv.gBa.LG();
            }
            if (startPush != 0 && bQB().gAY != null) {
                bQB().gAY.errCode = 4;
                bQB().gAY.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (alVar != null && !alVar.Di() && !bVR()) {
                mx(true);
                bVS();
            }
            if (this.gpy != null) {
                this.gpy.y(bQB().gAu.Fq());
            }
            if (this.gqn != null) {
                this.gqn.a(bQB().gAu.Fq());
            }
            if (this.gGi != null) {
                this.gGi.i(bQB().gAu.Fq());
                this.gGi.hi(this.otherParams);
            }
            if (this.gGb != null && bQB() != null && bQB().gAu != null) {
                if (this.gGb.au(bQB().gAV)) {
                    this.gGb.s(bQB().gAu.Fq());
                } else {
                    this.gGb.c(bQB().gAV, bQB().gAu.Fq());
                }
            }
            if (this.gpy != null) {
                this.gpy.mr(true);
            }
            if (this.gGa != null) {
                this.gGa.y(bQB().gAu.Fq());
            }
            if (alVar == null || alVar.aEz == null) {
                z = com.baidu.live.c.AR().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = alVar.aEz.canUseChallenge;
                com.baidu.live.c.AR().putBoolean("ala_master_can_use_challenge", z);
            }
            bPD();
            bVH();
            bVs();
            mv(z);
            bOv();
            bVI();
            bVM();
            z(bQB().gAu.Fq());
            g(bQB().gAu.Fq());
            bVN();
            bVO();
            bVL();
            bPC();
            bPq();
            bPy();
            bPz();
            bVF();
            A(bQB().gAu.Fq());
            bPr();
            if (this.gqA != null) {
                this.gqA.h(bQB().gAu.Fq());
            }
            if (this.gqB != null) {
                if (bQB().gAu.Fq() != null && bQB().gAu.Fq().aFp != null && bQB().gAu.Fq().aFp.CD()) {
                    z2 = true;
                }
                this.gqB.a(String.valueOf(bQB().gAu.Fq().mLiveInfo.group_id), String.valueOf(bQB().gAu.Fq().mLiveInfo.last_msg_id), String.valueOf(bQB().gAu.Fq().aEz.userId), String.valueOf(bQB().gAu.Fq().mLiveInfo.live_id), bQB().gAu.Fq().aEz.appId, z2);
            }
            if (this.gqC != null) {
                this.gqC.a(bQB().gAu.Fq(), true);
            }
            this.mHandler.post(this.gHg);
        }
    }

    private void bOv() {
        if (this.bkG == null) {
            this.bkG = new PendantParentView(bQB().pageContext.getPageActivity(), this.gsg ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bQB().gAv.addView(this.bkG, layoutParams);
            this.bkG.setDefaultItemMargin(bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bkG.setPadding(bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bQf();
        }
    }

    private void bQf() {
        if (this.bkG != null) {
            int dimensionPixelSize = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278);
            int dimensionPixelSize2 = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bkG.getLayoutParams();
            if (this.gsg) {
                this.bkG.setPosition(0, 0, this.gGX.bQl(), dimensionPixelSize2);
            } else {
                this.bkG.setPosition(dimensionPixelSize, 0, bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278), dimensionPixelSize2);
            }
            this.bkG.setLayoutParams(layoutParams);
            this.bkG.setModel(this.gsg ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bQg() {
        if (this.gqB != null && this.gqB.JJ() != null && this.gqB.JJ().getView() != null) {
            if (this.gsg && !this.gFY && bQB().gAv != null && bQB().gAv.getHeight() > 0) {
                int be = this.gGX != null ? this.gGX.be(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.gqB.JJ().getView().getLayoutParams();
                int height = bQB().gAv.getHeight() - be;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.gqB.JJ().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ac.b.i(false, this.gFY);
            if (bQB().gAv.indexOfChild(this.gqB.JJ().getView()) != -1 && this.gqB.JJ().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gqB.JJ().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.gqB.JJ().getView().setLayoutParams(layoutParams2);
            }
            this.gqB.JJ().JI();
        }
    }

    private void bQh() {
        if (this.gqD != null) {
            if (this.gsg && !this.gFY && bQB().gAv != null && bQB().gAv.getHeight() > 0) {
                this.gqD.dP((bQB().gAv.getHeight() - (this.gGX != null ? com.baidu.live.utils.h.j(bQB().pageContext.getPageActivity(), true) : 0)) + bQB().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height));
            } else {
                this.gqD.dP(com.baidu.live.ac.a.a(bQB().pageContext.getPageActivity(), true, false, this.gFY));
            }
        }
    }

    private void bQi() {
        int i;
        if (this.gqD != null) {
            int h = com.baidu.live.ac.a.h(true, false);
            if (!this.gsg || bQB().gAv == null || bQB().gAv.getHeight() <= 0) {
                i = h;
            } else {
                i = (bQB().gAv.getHeight() - (this.gGX != null ? this.gGX.be(false) : 0)) + bQB().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
            }
            this.gqD.dQ(i);
        }
    }

    private void bQj() {
        if (this.gqC != null && this.gqC.Bo() != null) {
            ViewGroup.LayoutParams layoutParams = this.gqC.Bo().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bQB().pageContext.getResources().getDimensionPixelOffset(this.gsg ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gqC.Bo().setLayoutParams(layoutParams);
            }
        }
    }

    private void mv(boolean z) {
        if (this.gGX == null) {
            this.gGX = new com.baidu.tieba.ala.liveroom.challenge.e(bQB());
        }
        this.gGX.a(this.gtC, this.gtD, z);
        this.gGX.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(au auVar, ay ayVar, ay ayVar2) {
                AlaMasterLiveRoomOpearator.this.gsg = true;
                AlaMasterLiveRoomOpearator.this.bQB().gAv.gPq = false;
                if (AlaMasterLiveRoomOpearator.this.gGE != null) {
                    AlaMasterLiveRoomOpearator.this.gGE.eU(4);
                    AlaMasterLiveRoomOpearator.this.gGE.cp(true);
                }
                AlaMasterLiveRoomOpearator.this.bVq();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void BV() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gHg);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bQz() {
                AlaMasterLiveRoomOpearator.this.gsg = false;
                AlaMasterLiveRoomOpearator.this.bQB().gAv.gPq = false;
                if (AlaMasterLiveRoomOpearator.this.gGE != null) {
                    AlaMasterLiveRoomOpearator.this.gGE.eU(0);
                    AlaMasterLiveRoomOpearator.this.gGE.cp(false);
                }
                AlaMasterLiveRoomOpearator.this.bVr();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bQA() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gHg);
            }
        });
        this.gGX.K(this.gFG, z);
        this.gGX.j(this.gFG, z, (this.gtD == null || this.gtD.gBb == null || this.gtD.gBb.mChallengeData == null) ? false : true);
    }

    public boolean bVp() {
        return this.gGX != null && this.gGX.bQH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVq() {
        if (this.gGe != null) {
            this.gGe.setVisible(8);
            this.gGe.setCanVisible(false);
        }
        if (this.gpD != null) {
            this.gpD.lD(true);
        }
        if (this.gGk != null) {
            this.gGk.setCanVisible(false);
            this.gGk.setVisibility(4);
        }
        if (this.gGd != null) {
            this.gGr = this.gGd.bZs();
            this.gGd.mN(false);
        }
        if (this.gqW != null) {
            this.gqW.setCanVisible(false);
        }
        bQf();
        bQg();
        bQh();
        bQi();
        bQj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVr() {
        if (this.gGe != null) {
            this.gGe.setCanVisible(true);
        }
        if (this.gpD != null) {
            this.gpD.lD(false);
        }
        if (this.gGk != null) {
            this.gGk.setCanVisible(true);
        }
        if (this.gGd != null) {
            this.gGd.mN(this.gGr);
        }
        if (this.gqW != null) {
            this.gqW.setCanVisible(true);
        }
        bQf();
        bQg();
        bQh();
        bQi();
        bQj();
    }

    private void bVs() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
        layoutParams.leftMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (this.gGk == null) {
            this.gGk = new AlaLiveStreamStatusView(bQB().pageContext.getPageActivity());
        }
        this.gGk.setId(a.g.ala_live_room_stream_view);
        this.gGk.setVisibility(4);
        this.gGk.setLayoutParams(layoutParams);
        if (this.gGk.getParent() == null) {
            bQB().gAv.addView(this.gGk, layoutParams);
        }
    }

    public void bVt() {
        if (this.gFZ != null && this.gFZ.getVisibility() != 8 && bQB().gAT.getPreview() != null) {
            bQB().gAT.stopRecord();
        }
    }

    public void bVu() {
        if (bQB().gAT.getPreview() != null) {
            bQB().gAT.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gGV != null) {
                this.gGV.mc(false);
            }
            this.gGV = new com.baidu.tieba.ala.liveroom.h.b(bQB().gAV, bQB(), bQB().gAT);
            this.gGV.a(bQB().gAT.getVideoConfig(), false);
        }
        if (this.gGf != null) {
            this.gGf.bYl();
        }
        this.mHandler.post(this.gHg);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gFY = z;
        if (z) {
            if (this.gGU) {
                this.gGU = false;
                if (this.gqB != null && this.gqB.JJ() != null) {
                    this.gqB.JJ().getView().setBottom(0);
                }
                if (this.gqB != null && this.gqB.JK() != null) {
                    this.gqB.JK().getView().setBottom(0);
                }
            }
            if (this.gqD != null && this.gqD.EV() != null) {
                this.gqD.EV().setVisibility(8);
            }
            if (this.gqB != null && this.gqB.JJ() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gqB.JJ().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.gqB.JJ().getView().setLayoutParams(layoutParams);
            }
            if (this.gqB != null && this.gqB.JK() != null && this.gqB.JK().getView() != null && this.gqB.JK().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gqB.JK().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gqB.JK().getView().setLayoutParams(layoutParams2);
                this.gqB.JK().getView().setVisibility(0);
                this.gqB.JK().Lm();
            }
            uL(8);
            uJ(8);
        } else {
            if (this.gqD != null && this.gqD.EV() != null) {
                this.gqD.EV().setVisibility(0);
            }
            if (this.gqB != null && this.gqB.JJ() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gqB.JJ().getView().getLayoutParams();
                layoutParams3.bottomMargin = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gqB.JJ().getView().setLayoutParams(layoutParams3);
            }
            if (this.gqB != null && this.gqB.JK() != null) {
                this.gqB.JK().hide();
            }
            uL(0);
            uJ(0);
        }
        if (this.gFZ != null) {
            this.gFZ.M(false, z);
        }
        if (this.gqC != null) {
            this.gqC.Bp();
        }
        if (this.gGE != null) {
            this.gGE.onKeyboardVisibilityChanged(z);
        }
        bQg();
        this.mHandler.post(this.gHg);
    }

    private void uJ(int i) {
        if (this.gpy != null) {
            this.gpy.ux(i);
        }
        if (this.gGm != null) {
            this.gGm.setVisibility(i);
        }
        if (this.gqn != null) {
            this.gqn.getView().setVisibility(i);
        }
        if (this.gGc != null) {
            this.gGc.setVisible(i);
        }
        if (this.gGb != null) {
            this.gGb.setVisibility(i);
        }
        if (this.gpD != null) {
            this.gpD.setVisible(i);
        }
        if (this.grb != null) {
            this.grb.setCanVisible(i == 0);
        }
        if (this.gqM != null) {
            this.gqM.setVisible(i);
        }
        if (this.gqX != null) {
            this.gqX.setVisible(i);
        }
        if (this.gqV != null) {
            this.gqV.setCanVisible(i == 0);
        }
        if (this.gqW != null) {
            this.gqW.setCanVisible(i == 0 && !this.gsg);
        }
        if (this.gGY != null) {
            this.gGY.setCanVisible(i == 0);
            this.gGY.refreshUI();
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bQB().gAY.errCode = 1;
            uK(a.i.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            uK(a.i.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            uK(a.i.stream_upload_exception);
        } else if (i == -2) {
            GG(bQB().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bQB().gAT.stopRecord();
        } else if (i == -3 && this.gFZ != null) {
            this.gFZ.md(false);
        }
        if (i == -4) {
            if (this.gFZ == null || this.gFZ.getView().getParent() == null) {
                bQB().f((short) 1);
                return;
            }
            this.gFZ.bSr();
            this.gGw.setVisibility(0);
            if (this.gGd != null) {
                this.gGd.mO(true);
            }
            bQB().gAv.setBackgroundColor(bQB().pageContext.getResources().getColor(17170445));
            bWa();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aoL();
        if (i == 12001) {
            if (i2 == -1) {
                GH(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            blQ();
        }
    }

    public void onResume() {
        if (this.gFZ != null) {
            this.gFZ.onResume();
        }
        if (this.gGH && this.gGG != null) {
            this.gGH = false;
            c(this.gGG);
        }
        if (this.gqO != null) {
            this.gqO.onResume();
        }
    }

    public void g(short s) {
        if (this.gqA != null) {
            this.gqA.FB();
        }
        if (this.gqB != null) {
            this.gqB.a(null);
            this.gqB.Bq();
        }
        if (this.gqC != null) {
            this.gqC.Bq();
        }
        if (this.gGX != null) {
            this.gGX.bQG();
        }
    }

    public boolean bVv() {
        u Fq = bQB().gAu.Fq();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gtv.gBa.l(Fq);
            if (Fq != null && Fq.mLiveInfo.live_status != 1) {
                bVY();
                bQB().pageContext.getPageActivity().finish();
                if (bQB().gAu != null && bQB().gAu.Fq() != null) {
                    a(Fq, 1, bQB().gAu.bXv() != 1 ? bQB().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gqB != null) {
                this.gqB.JJ().b(String.valueOf(Fq.mLiveInfo.group_id), String.valueOf(Fq.mLiveInfo.live_id), true, String.valueOf(Fq.aEz.userId));
            }
            if (this.gqC != null) {
                this.gqC.a(Fq);
            }
            if (this.gqn != null) {
                this.gqn.a(bQB().gAu.Fq());
            }
            if (this.gpy != null) {
                this.gpy.y(Fq);
            }
            if (Fq != null) {
                if (this.gGX != null) {
                    this.gGX.a(Fq);
                }
                if (this.gqE != null && Fq.mLiveInfo != null) {
                    this.gqE.a(Fq.mLiveInfo, Fq.aEz);
                }
                if (this.grb != null) {
                    this.gro = this.grb.q(Fq);
                }
                if (this.gpD != null) {
                    this.gpD.lE(this.gro);
                    this.gpD.k(Fq);
                    this.gpD.updateView();
                }
                if (this.gqV != null) {
                    this.gqV.a(Fq);
                }
                if (this.gqW != null) {
                    this.gqW.a(Fq);
                }
                if (this.gqX != null) {
                    this.gqX.a(Fq);
                }
                if (Fq.mLiveInfo.live_status != 1) {
                    bVY();
                    bQB().pageContext.getPageActivity().finish();
                    if (bQB().gAu != null && bQB().gAu.Fq() != null) {
                        a(Fq, 1, bQB().gAu.bXv() != 1 ? bQB().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.gGi != null) {
                    this.gGi.j(Fq);
                }
            }
        }
        return false;
    }

    public void bVw() {
        bVm();
    }

    public void bVx() {
        if (this.gGV != null) {
            this.gGV.bSl();
        }
    }

    public void bVy() {
        if (this.gFZ != null && this.gFZ.getVisibility() != 8) {
            if (bQB().bSx() == 2) {
                bWa();
            } else {
                bVZ();
            }
        }
        if (this.gFZ != null && this.gFZ.getVisibility() != 8) {
            if (bQB().bSx() == 1) {
                this.gFZ.onResume();
            }
            this.gFZ.onRefresh();
        }
        if (this.gGi != null) {
            this.gGi.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.grj && this.gGA != null) {
            if (this.gqB != null) {
                this.gqB.JJ().getView().setVisibility(0);
            }
            if (this.gqB != null) {
                this.gqB.JK().show();
                this.gqB.JK().setEditText(" @" + this.gGA.getNameShow() + " ");
            }
            uL(8);
            this.grj = false;
        }
        if (this.gGZ != null) {
            this.gGZ.resume();
        }
        if (this.gHa != null) {
            this.gHa.resume();
        }
        if (this.grd != null) {
            this.grd.resume();
        }
    }

    public void onPause() {
        if (this.gGi != null) {
            this.gGi.onPause();
        }
        if (this.gGZ != null) {
            this.gGZ.pause();
        }
        if (this.gqO != null) {
            this.gqO.onPause();
        }
        if (this.gHa != null) {
            this.gHa.pause();
        }
        if (this.grd != null) {
            this.grd.pause();
        }
    }

    private void bVz() {
        if (bh.c(com.baidu.live.x.a.NN().bmW)) {
            this.gGw.setVisibility(0);
            this.gGw.setAlpha(0.2f);
        } else if (bQB().gAT.hasBeauty() < 0) {
            this.gGw.setVisibility(8);
        } else {
            this.gGw.setVisibility(0);
        }
    }

    private void bVA() {
        this.gGl = (RelativeLayout) bQB().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.gGn = (RelativeLayout) bQB().rootView.findViewById(a.g.under_live_view_panel);
        this.gGo = (RelativeLayout) bQB().rootView.findViewById(a.g.over_live_view_panel);
        this.gGp = (FrameLayout) bQB().rootView.findViewById(a.g.goods_parent);
        this.gtv.gAv.setOnLiveViewScrollListener(this.gHv);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gGn.setVisibility(8);
            this.gGo.setVisibility(8);
            bQB().gAv.removeAllViews();
            return;
        }
        this.gGm = (RelativeLayout) bQB().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gGm.getLayoutParams();
        layoutParams.topMargin = this.gtv.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.gGm.setLayoutParams(layoutParams);
        if (this.gpB == null) {
            this.gpB = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gtv.pageContext.getPageActivity(), false);
        }
        this.gpB.a(this.gqe);
        this.gpB.a(this.gGm, a.g.ala_live_room_host_header_stub, 1L);
        this.gpB.setVisible(0);
        bVB();
        this.gGw = (ImageView) bQB().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.gGz = (TextView) bQB().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn_num);
        this.gGw.setOnClickListener(this.gHn);
        this.gGy = (ImageView) bQB().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.gGy.setOnClickListener(this.gHn);
        if (com.baidu.live.x.a.NN().bmW != null && com.baidu.live.x.a.NN().bmW.aKO != null && com.baidu.live.x.a.NN().bmW.aKO.Dm() && bh.b(com.baidu.live.x.a.NN().bmW)) {
            this.gGy.setVisibility(0);
        } else {
            this.gGy.setVisibility(8);
        }
        bVz();
        this.gGv = (ImageView) bQB().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.gGv.setOnClickListener(this.gHn);
        this.gGt = (ImageView) bQB().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.gGt.setOnClickListener(this.gHn);
        this.gtC = (ImageView) bQB().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.gtC.setOnClickListener(this.gHn);
        this.gGu = (ImageView) bQB().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.gGu.setOnClickListener(this.gHn);
        this.gGx = (ImageView) bQB().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.gGx.setOnClickListener(this.gHn);
        bVE();
        if (bh.b(com.baidu.live.x.a.NN().bmW)) {
            this.gGV = new com.baidu.tieba.ala.liveroom.h.b(bQB().gAV, bQB(), bQB().gAT);
        }
        this.gqA = new m();
        bVC();
        bVD();
        if (com.baidu.live.c.AR().getInt("beauty_new_bubble", 1) == 1) {
            this.gGz.setVisibility(0);
        }
    }

    private void bVB() {
        this.gHf = (FrameLayout) View.inflate(bQB().pageContext.getPageActivity(), a.h.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gHf != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.gHf.setVisibility(8);
            if (this.gHf.getParent() != null && (this.gHf.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gHf.getParent()).removeView(this.gHf);
            }
            this.gGl.addView(this.gHf, layoutParams);
            if (this.gHf != null) {
                this.gHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.gqe.n(AlaMasterLiveRoomOpearator.this.gHf, 8);
                    }
                });
            }
        }
    }

    private void bVC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bQB().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gqB = (k) runTask.getData();
            this.gqB.setFromMaster(true);
            this.gqB.JJ().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bQB().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ac.b.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ac.b.cE(true);
            bQB().gAv.addView(this.gqB.JJ().getView(), layoutParams);
            this.gqB.JK().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bQB().gAv.addView(this.gqB.JK().getView(), layoutParams2);
            this.gqB.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                @Override // com.baidu.live.im.k.a
                public boolean JM() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void JN() {
                }

                @Override // com.baidu.live.im.k.a
                public void hd(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void JO() {
                }

                @Override // com.baidu.live.im.k.a
                public void JP() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean JQ() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int JR() {
                    return 0;
                }
            });
        }
    }

    private void bVD() {
        View Bo;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bQB().pageContext);
        if (runTask != null) {
            this.gqC = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gqC != null && (Bo = this.gqC.Bo()) != null && this.gtv.gAv.indexOfChild(Bo) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gtv.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bQB().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bQB().gAv.addView(Bo, layoutParams);
        }
    }

    private void bVE() {
        CustomResponsedMessage runTask;
        if (this.gGC == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.z.a.class, bQB().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gGC = (com.baidu.live.z.a) runTask.getData();
        }
    }

    private void bVF() {
        View EU;
        w.e(bQB().gAu.Fq());
        w.b(bQB().pageContext, true);
        w.Fx();
        if (this.gqD == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aOB = true;
            fVar.context = bQB().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, x.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gqD = (x) runTask.getData();
                if (this.gqD != null && (EU = this.gqD.EU()) != null && bQB().gAv.indexOfChild(EU) < 0) {
                    if (EU.getParent() instanceof ViewGroup) {
                        ((ViewGroup) EU.getParent()).removeView(EU);
                    }
                    bQB().gAv.addView(EU, bQB().gAv.getLayoutParams());
                }
            }
        }
    }

    protected void bPz() {
        View Fp;
        if (this.gqE == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aOB = true;
            aVar.context = bQB().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, v.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gqE = (v) runTask.getData();
            }
        }
        if (this.gqE != null && (Fp = this.gqE.Fp()) != null) {
            if (bQB().gAv.indexOfChild(Fp) < 0) {
                if (Fp.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Fp.getParent()).removeView(Fp);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.gqM != null && this.gqM.isShowing()) {
                    layoutParams.addRule(3, a.g.guard_club_entry_id);
                    layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else if (this.gGc != null && this.gGc.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
                    layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else if (this.gqX != null && this.gqX.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_rank_level_entry);
                    layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else {
                    layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                    layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds66);
                }
                bQB().gAv.addView(Fp, layoutParams);
            }
            Fp.bringToFront();
        }
    }

    protected void bPy() {
        View FC;
        if (this.gqO == null) {
            ac acVar = new ac();
            acVar.aOB = true;
            acVar.pageContext = bQB().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, z.class, acVar);
            if (runTask != null && runTask.getData() != null) {
                this.gqO = (z) runTask.getData();
            }
        }
        if (this.gqO != null && (FC = this.gqO.FC()) != null && bQB().gAv.indexOfChild(FC) < 0) {
            if (FC.getParent() instanceof ViewGroup) {
                ((ViewGroup) FC.getParent()).removeView(FC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bQB().gAv.addView(FC, layoutParams);
        }
    }

    private void bVG() {
        bVK();
        bOy();
        bVJ();
        bQB().gAv.setVisibility(0);
        uL(0);
    }

    private void bVH() {
        if (this.gGc == null) {
            this.gGc = new com.baidu.tieba.ala.liveroom.v.a(bQB().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gGc.a(bQB().bSx(), j, TbadkCoreApplication.getCurrentAccountName(), true, bQB().gAu.Fq().aEz.portrait, this.otherParams, "", -1L);
        this.gGc.at(bQB().gAv);
    }

    private void bVI() {
        if (this.gGE == null) {
            bQB().gAv.gPq = false;
            com.baidu.live.y.a eU = eU(bQB().pageContext.getPageActivity());
            if (eU != null) {
                this.gGE = eU;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.y.a.class, bQB().pageContext.getPageActivity());
                if (runTask != null) {
                    this.gGE = (com.baidu.live.y.a) runTask.getData();
                }
            }
            if (this.gGE != null) {
                this.gGE.t(this.gGn);
                this.gGE.u(this.gGo);
                this.gGE.eT((bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bQB().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                this.gGE.v(bQB().gAv);
                this.gGE.a(this.goY);
                this.gGE.setLiveShowInfo(bQB().gAu.Fq());
                this.gGE.a(this.gpD);
                this.gGE.NZ();
                this.gGE.a(new a.InterfaceC0202a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // com.baidu.live.y.a.InterfaceC0202a
                    public void Oa() {
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0202a
                    public void Ob() {
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0202a
                    public void I(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bQB().gAT != null) {
                            AlaMasterLiveRoomOpearator.this.bQB().gAT.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0202a
                    public int Oc() {
                        return AlaMasterLiveRoomOpearator.this.gGm.getBottom();
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0202a
                    public int Od() {
                        return AlaMasterLiveRoomOpearator.this.gtv.gAv.getHeight() - (AlaMasterLiveRoomOpearator.this.gqB.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gqB.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0202a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gqB.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0202a
                    public int Oe() {
                        return AlaMasterLiveRoomOpearator.this.gqB.JL();
                    }
                });
            }
        }
    }

    private com.baidu.live.y.a eU(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).at(context);
        }
        return null;
    }

    private void bVJ() {
        if (this.gGe == null) {
            this.gGe = new b(bQB().pageContext, bQB().gAv);
        }
    }

    private void bVK() {
        if (this.gpy == null) {
            this.gpy = new com.baidu.tieba.ala.liveroom.p.a(bQB().pageContext, true, this.gHr);
            this.gpy.d(this.gGm, null);
            this.gpy.a(this.gqe);
            this.gpy.mr(false);
        }
        if (this.gGa == null) {
            this.gGa = new com.baidu.tieba.ala.liveroom.p.a(bQB().pageContext, true, null);
            this.gGa.a(this.gGm, null, a.g.ala_live_room_host_header_stub);
            this.gGa.bUj();
        }
    }

    protected void bPh() {
        CustomResponsedMessage runTask;
        boolean z = false;
        al bXm = bQB().gAu.bXm();
        boolean z2 = com.baidu.live.x.a.NN().bhy.aIA;
        if (bXm == null || bXm.aFn) {
            z = z2;
        }
        if (z && this.gqn == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bQB().pageContext)) != null) {
            this.gqn = (com.baidu.live.h.a) runTask.getData();
            if (this.gqn != null) {
                this.gqn.setIsHost(true);
                this.gqn.ez(1);
                View view = this.gqn.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bQB().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bQB().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.gGm.addView(view, layoutParams);
                }
            }
        }
    }

    private void g(u uVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gpD == null) {
            this.gpD = new com.baidu.tieba.ala.liveroom.activeview.b(bQB().pageContext);
        }
        this.gpD.setOtherParams(this.otherParams);
        this.gpD.b(uVar, false);
        this.gpD.setHost(true);
        this.gpD.a(1, this.bkG);
        this.gpD.a(2, this.bkG);
        this.gpD.lE(this.gro);
        this.gpD.setVisible(this.gFY ? 8 : 0);
        this.gpD.a(this.goY);
        if (this.goY != null) {
            if (this.gpD != null) {
                alaActiveRootView2 = this.gpD.ue(1);
                alaActiveRootView = this.gpD.ue(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.goY.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.goY.a(alaActiveRootView);
            }
        }
    }

    private void z(u uVar) {
        CustomResponsedMessage runTask;
        if (this.grb == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bQB().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.u.a)) {
            this.grb = (com.baidu.live.u.a) runTask.getData();
            if (this.grb != null) {
                this.grb.s(this.bkG);
            }
        }
        if (this.grb != null) {
            this.gro = this.grb.q(uVar);
            this.grb.setCanVisible(!this.gFY);
        }
    }

    protected void bVL() {
        CustomResponsedMessage runTask;
        if (bQB() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bQB().pageContext.getPageActivity())) != null && runTask.getData() != null && this.gqV == null) {
            this.gqV = (com.baidu.live.i.a) runTask.getData();
            this.gqV.b(bQB().gAv, bPL());
            if (bQB().gAu != null) {
                this.gqV.a(bQB().gAu.Fq());
            }
            this.gqV.setCanVisible(true);
            this.gqV.bM(false);
            this.gqV.a(bQB().gAu.bJE());
        }
    }

    protected void bPC() {
        CustomResponsedMessage runTask;
        if (bQB() != null && this.gqW == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.p.a.class, bQB().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gqW = (com.baidu.live.p.a) runTask.getData();
            this.gqW.setIsHost(true);
            this.gqW.b(this.bkG, bQB().gAu.Fq());
        }
    }

    private void A(u uVar) {
        CustomResponsedMessage runTask;
        if (bQB() != null) {
            if (this.gGg == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.p.d.class)) != null) {
                this.gGg = (com.baidu.live.p.d) runTask.getData();
            }
            if (this.gGg != null) {
                this.gGg.ML();
            }
            if (this.gGh == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, c.class);
                if (runTask2 != null) {
                    this.gGh = (c) runTask2.getData();
                }
                if (this.gGh != null) {
                    this.gGh.setParentView(this.gtv.gAv);
                    if (uVar != null && uVar.aEz != null) {
                        this.gGh.aq(uVar.aEz.userId);
                    }
                }
            }
        }
    }

    private void bPq() {
        this.gHa = new com.baidu.tieba.ala.liveroom.r.c(bQB().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bPL() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bQB().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.gqX != null && this.gqX.isShowing()) {
            layoutParams.addRule(3, a.g.ala_rank_level_entry);
            layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else if (this.gGc != null && this.gGc.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else if (this.gqM != null && this.gqM.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        }
        return layoutParams;
    }

    private void bOy() {
        if (this.gGb == null) {
            this.gGb = new com.baidu.tieba.ala.liveroom.b.a(bQB().pageContext, true);
        }
    }

    private void bVM() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bQB().pageContext.getPageActivity();
            if (this.gGF == null) {
                this.gGF = new ImageView(pageActivity);
                this.gGF.setId(a.g.master_close_btn);
                this.gGF.setTag("master_close_btn");
                this.gGF.setImageResource(a.f.sdk_icon_bar_live_close_n);
                this.gGF.setBackgroundResource(a.f.sdk_round_btn_close_bg);
                this.gGF.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            }
            if (this.gGF.getParent() != null) {
                ((ViewGroup) this.gGF.getParent()).removeView(this.gGF);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bQB().gAV.addView(this.gGF, layoutParams);
            this.gGF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bVW();
                }
            });
            this.gGF.setVisibility(8);
        }
    }

    protected void bPD() {
        if (this.gqX == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.p.b.class, bQB().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gqX = (com.baidu.live.p.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bQB().gAu.Fq() != null && bQB().gAu.Fq().aEz != null && bQB().gAu.Fq().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.height = BdUtilHelper.getDimens(bQB().pageContext.getPageActivity(), a.e.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(bQB().pageContext.getPageActivity(), a.e.sdk_ds16);
            layoutParams.leftMargin = BdUtilHelper.getDimens(bQB().pageContext.getPageActivity(), a.e.sdk_ds20);
            this.gqX.a(bQB().gAv, layoutParams, bQB().gAu.Fq());
        }
    }

    private void bVN() {
        CustomResponsedMessage runTask;
        if (this.gGY == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.a.a.class, bQB().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.a)) {
            this.gGY = (com.baidu.live.a.a) runTask.getData();
            if (this.gGY != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bQB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gGY.b(bQB().gAv, layoutParams);
            }
        }
        if (this.gGY != null) {
            this.gGY.a(bQB().gAu.Fq());
        }
    }

    private void bVO() {
        CustomResponsedMessage runTask;
        if (this.gGZ == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.a.b.class, bQB().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.b)) {
            this.gGZ = (com.baidu.live.a.b) runTask.getData();
        }
    }

    private void bPr() {
        if (this.grd == null) {
            this.grd = new com.baidu.live.ae.a(bQB().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.gGX != null) {
            this.gGX.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bQB().pageContext.registerListener(this.grF);
        bQB().pageContext.registerListener(this.gHh);
        bQB().pageContext.registerListener(this.grH);
        bQB().pageContext.registerListener(this.grI);
        bQB().pageContext.registerListener(this.gHo);
        bQB().pageContext.registerListener(this.buw);
        bQB().pageContext.registerListener(this.gnN);
        bQB().pageContext.registerListener(this.gHp);
        bQB().pageContext.registerListener(this.grG);
        bQB().pageContext.registerListener(this.gpZ);
        bQB().pageContext.registerListener(this.grM);
        bQB().pageContext.registerListener(this.gHl);
        bQB().pageContext.registerListener(this.gHm);
        bQB().pageContext.registerListener(this.gHi);
        bQB().pageContext.registerListener(this.bhf);
        bQB().pageContext.registerListener(this.bhg);
        bQB().pageContext.registerListener(this.gHj);
        bQB().pageContext.registerListener(this.grP);
        bQB().pageContext.registerListener(this.grO);
        bQB().pageContext.registerListener(this.grQ);
        bQB().pageContext.registerListener(this.gHk);
        bQB().pageContext.registerListener(this.gHj);
        bQB().pageContext.registerListener(this.bgl);
        bQB().pageContext.registerListener(this.bcQ);
        bQB().pageContext.registerListener(this.grS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mw(boolean z) {
        if (bh.c(com.baidu.live.x.a.NN().bmW)) {
            bQB().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bQB().gAX.Bi() == null || ListUtils.isEmpty(bQB().gAX.Bi().aAi)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bQB().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.gHb) {
                this.gHc = BdUniqueId.gen();
                bQB().gAX.a(this.gHc);
                this.gHb = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bQB().pageContext.getPageActivity(), bQB().rootView);
            uL(8);
            if (bQB().gAT.hasAdvancedBeauty() && this.gGV != null) {
                if (!this.gHd || this.gFZ.getVisibility() == 0) {
                    this.gGV.a(bQB().gAT.getVideoConfig());
                }
                this.gGV.a(bQB().gAT.getVideoConfig(), this.gGW);
                if (!this.gGW) {
                    this.gGW = true;
                }
            }
            if (z && this.gqB != null) {
                this.gqB.JJ().getView().setVisibility(4);
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
    public void uK(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bQB().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bQB().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bQB().f((short) 1);
            }
        });
        bdAlertDialog.create(bQB().pageContext).show();
    }

    private void GG(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bQB().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bQB().f((short) 1);
            }
        });
        bdAlertDialog.create(bQB().pageContext).show();
    }

    public void bVP() {
        bPh();
        com.baidu.live.data.n bJE = bQB().gAu.bJE();
        int i = 5;
        if (bJE != null) {
            i = (int) bJE.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq() != null && AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bQB().gAu.g(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bJE != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gtv.gBa.b(bJE);
                return;
            }
            if (this.gpx == null) {
                this.gpx = new com.baidu.tieba.ala.liveroom.audiencelist.c(bQB().pageContext, this.gHr, true);
            }
            if (this.gGT) {
                this.gGT = false;
                this.gpx.a(String.valueOf(bQB().gAu.Fq().mLiveInfo.group_id), String.valueOf(bQB().gAu.Fq().mLiveInfo.live_id), String.valueOf(bQB().gAu.Fq().aEz.userId), bQB().gAu.Fq());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.gqn != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.gpx.c(this.gGm, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.gpx.e(bJE);
            this.gpB.setVisible(0);
            this.gpB.dP(bJE.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVQ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blQ() {
        if (bQB().gAu != null) {
            if (this.gqo == null) {
                this.gqo = new com.baidu.tieba.ala.liveroom.share.c(bQB().pageContext);
            }
            this.gqo.c(bQB().gAu.Fq(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bQB().gAu != null && bQB().gAu.Fq() != null && bQB().gAu.Fq().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bQB().gAu.Fq().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bQB().gAu.Fq().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bQB().gAu.Fq().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bQB().gAu != null && bQB().gAu.Fq() != null && bQB().gAu.Fq().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bQB().gAu.Fq().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bQB().gAu.Fq().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bQB().gAu.Fq().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bVR() {
        return this.gFX;
    }

    private void mx(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(gFW, z);
        this.gFX = z;
    }

    private void bVS() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bQB().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.q.b(AlaMasterLiveRoomOpearator.this.bQB().pageContext).bWU();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bQB().pageContext).show();
    }

    private void bVT() {
        if (this.gFG && bQB().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bQB().gAZ.OK();
        }
        bQB().gAY.prepareTime = System.currentTimeMillis() - bQB().gAY.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bQB().gAu != null && bQB().gAu.Fq() != null && bQB().gAu.Fq().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bQB().gAu.Fq().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bQB().gAu.Fq().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bQB().gAY.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gFZ != null && this.gFZ.getView().getParent() != null) {
            this.gFZ.setVisibility(8);
            bQB().gAV.removeView(this.gFZ.getView());
            this.gFZ.release();
        }
        if (this.gGV != null) {
            this.gGV.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bQB().gAv.indexOfChild(this.gGj) < 0) {
            bQB().gAv.addView(this.gGj, layoutParams);
        }
        this.gGj.va(1000);
    }

    private void aoL() {
        if (bQB().bSx() == 1) {
            bQB().gAT.startRecord();
        }
    }

    private void GH(String str) {
        GI(str);
    }

    private void GI(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bQB().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.gFZ != null) {
            this.gFZ.Gu(fromJson.getSmallurl());
        }
    }

    private boolean bVU() {
        return com.baidu.live.c.AR().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVV() {
        com.baidu.live.c.AR().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.gtv.gAT.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVW() {
        int i = a.i.live_close_confirm;
        if (this.gGX != null && this.gGX.bQI()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.gGX != null && this.gGX.bQH()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bQB().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq(), 0, AlaMasterLiveRoomOpearator.this.bQB().gAu.bXv() != 1 ? AlaMasterLiveRoomOpearator.this.bQB().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bQB().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (uVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = uVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = uVar.aEz;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bQB().gAu.ek(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.gGR) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bQB().gAY;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bQB().gAT.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.gGN;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.gGO;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.gGJ;
            if (this.gGK != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.gGL - this.gGM) / this.gGK) * 100.0f;
            }
            Intent intent = new Intent(bQB().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bQB().gAu != null && bQB().gAu.Fq() != null && bQB().gAu.Fq().aEz != null) {
                String str3 = bQB().gAu.Fq().aEz.nickName;
                String str4 = bQB().gAu.Fq().aEz.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            u Fq = bQB().gAu.Fq();
            if (Fq != null && Fq.aEz != null && !TextUtils.isEmpty(Fq.aEz.portrait)) {
                intent.putExtra("host_portrait", Fq.aEz.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.gGP = intent;
                this.gGQ = s;
                bQB().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bVX() {
        if (this.gGP != null) {
            a(this.gGP, this.gGQ);
            this.gGP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.gGR = true;
        if (this.gGX != null) {
            this.gGX.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.gnC);
            bQB().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bQB().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVY() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gtv.gBa != null && this.gtv.gBa.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.gGX != null && this.gGX.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bQB().gAW.bWD()) {
                bVW();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.gGk != null) {
                this.gGk.setVisibility(4);
                return;
            }
            return;
        }
        if (this.gGk != null) {
            this.gGk.a(i, z, i2, z2);
        }
        if (this.gtv != null && this.gtv.gAu != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cZx != i3) {
                this.cZx = i3;
                if (this.gGf == null) {
                    this.gGf = new com.baidu.tieba.ala.liveroom.tippop.a(this.gtv.pageContext, null);
                }
                switch (this.cZx) {
                    case 0:
                        this.gGf.a(this.gtv.gAV, this.gtv.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.gGf.a(this.gtv.gAV, this.gtv.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.gGf.a(this.gtv.gAV, this.gtv.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gtv.gAu.o(this.gtv.gAu.Fq().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(com.baidu.live.im.data.a aVar) {
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
                        AlaMasterLiveRoomOpearator.this.bVY();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:31|32|33|(1:35)(1:86)|36|(2:42|(9:44|45|(2:60|(1:84)(2:64|(4:66|67|68|(2:72|(2:73|(2:75|(1:78)(1:77))(1:81)))(0))(0)))(0)|49|50|51|(1:53)|54|55))|85|45|(1:47)|60|(1:62)|84|49|50|51|(0)|54|55) */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x05f8, code lost:
        Gl(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x06c0, code lost:
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x06c1, code lost:
        r2.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[Catch: JSONException -> 0x06d0, TRY_LEAVE, TryCatch #8 {JSONException -> 0x06d0, blocks: (B:8:0x0018, B:10:0x0020, B:209:0x06c5), top: B:237:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:196:0x063f A[Catch: JSONException -> 0x06c0, TryCatch #7 {JSONException -> 0x06c0, blocks: (B:194:0x0623, B:196:0x063f, B:197:0x0649), top: B:235:0x0623, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x06c5 A[Catch: JSONException -> 0x06d0, TRY_ENTER, TRY_LEAVE, TryCatch #8 {JSONException -> 0x06d0, blocks: (B:8:0x0018, B:10:0x0020, B:209:0x06c5), top: B:237:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(com.baidu.live.im.data.a aVar) {
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
        com.baidu.live.gift.g gy;
        JSONObject jSONObject6;
        if (aVar.getMsgType() == 125) {
            if (this.gGd != null) {
                this.gGd.C(aVar);
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
                            if (this.gGX != null) {
                            }
                            if (!"close_live".equals(str2)) {
                            }
                            if (!(aVar.getObjContent() instanceof JSONObject)) {
                            }
                            try {
                                jSONObject6.put("log_id", aVar.getMsgId());
                            } catch (JSONException e2) {
                            }
                            if (this.gqW != null) {
                            }
                            return;
                        }
                    } catch (JSONException e3) {
                        jSONObject = jSONObject4;
                        str = null;
                        str2 = optString;
                    }
                } catch (JSONException e4) {
                    jSONObject = jSONObject4;
                    str = null;
                    str2 = null;
                }
            } catch (JSONException e5) {
                jSONObject = null;
                str = null;
                str2 = null;
            }
            if (this.gGX != null) {
                this.gGX.fN(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bVY();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bQB().gAu.Fq(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bQB().gAu.Fq() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bQB().gAu.Fq().aFb.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bQB().gAu.Fq().aFb.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bQB().gAu.Fq().aFb.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bQB().gAu.Fq() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bQB().gAu.Fq() != null && bQB().gAu.Fq().aEz != null && bQB().gAu.Fq().aEz.userId == optLong2) {
                        bQB().gAu.Fq().aEz.isUegBlock = 1;
                        bOL();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bQB().gAu.Fq() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bQB().gAu.Fq() != null && bQB().gAu.Fq().aEz != null && bQB().gAu.Fq().aEz.userId == optLong3) {
                        bQB().gAu.Fq().aEz.isUegBlock = 0;
                        bOL();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.gGC != null) {
                    this.gGC.Q(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.gGe.aF(optString4, optInt2);
                    }
                    if (this.gpB.getCount() > 20) {
                        this.gpB.dP(this.gpB.getCount() + 1);
                    } else if (this.gpx != null) {
                        com.baidu.live.data.a Ko = aVar.Ko();
                        com.baidu.live.data.m mVar = new com.baidu.live.data.m();
                        mVar.aEA = new AlaLocationData();
                        mVar.aEB = new AlaRelationData();
                        mVar.aEz = new AlaLiveUserInfoData();
                        mVar.aEz.userId = JavaTypesHelper.toLong(Ko.userId, 0L);
                        mVar.aEz.userName = Ko.userName;
                        mVar.aEz.portrait = Ko.portrait;
                        if (this.gpx.c(mVar)) {
                            this.gpB.dP(this.gpB.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bQB() != null && bQB().gAu != null && bQB().gAu.Fq() != null && bQB().gAu.Fq().aFb != null && bQB().gAu.Fq().aFb.userId == jSONObject2.optLong("user_id")) {
                    bQB().gAu.bXl();
                }
            } else if ("official_notice".equals(str2)) {
                if (jSONObject2 != null) {
                    long optLong4 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str5 = optLong4 + "";
                        TbadkCoreApplication.getInst();
                        if (str5.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                }
            } else if ("privilege_award_royal_success".equals(str2)) {
                if (jSONObject2 != null) {
                    String str6 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a Ko2 = aVar.Ko();
                    if (Ko2 != null && w.gC(str6)) {
                        w.d(str6, 1L, "", "", Ko2.userId, Ko2.portrait, Ko2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject2 != null) {
                    av avVar = new av();
                    avVar.parseJson(jSONObject2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, avVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString5 = jSONObject2.optString("challenge_im_type");
                    if (TextUtils.equals(optString5, "start")) {
                        GJ(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bQB().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(bQB().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a Ko3 = aVar.Ko();
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject5 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject5 = new JSONObject(aVar.getContent());
                }
                String optString6 = jSONObject5.optString("order_id");
                String optString7 = jSONObject5.optString(LogConfig.LOG_GIFT_ID);
                String optString8 = jSONObject5.optString("gift_count");
                String optString9 = jSONObject5.optString("gift_name");
                String optString10 = jSONObject5.optString("gift_url");
                String optString11 = jSONObject5.optString("is_pk_gift");
                long optLong5 = jSONObject5.optLong("charm_total");
                String optString12 = jSONObject5.optString("attach");
                String optString13 = jSONObject5.optString("attach_new");
                String optString14 = jSONObject5.optString("gift_mul");
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                String str7 = null;
                if (bQB().gAu != null && bQB().gAu.Fq() != null && bQB().gAu.Fq().mLiveInfo != null) {
                    j4 = bQB().gAu.Fq().mLiveInfo.live_id;
                    j5 = bQB().gAu.Fq().mLiveInfo.group_id;
                    j6 = bQB().gAu.Fq().aEz.userId;
                    str7 = bQB().gAu.Fq().mLiveInfo.appId;
                    if (bQB().gAu.Fq().mLiveSdkInfo.mCastIds != null) {
                        String str8 = bQB().gAu.Fq().mLiveSdkInfo.mCastIds.aEU;
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = bQB().gAu.Fq().mLiveSdkInfo.mCastIds.aEV;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString7, "");
                        if (this.isBackground || bQB().bSx() != 2) {
                            if (TextUtils.isEmpty(optString13) && !TextUtils.isEmpty(optString14)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    w.b(optString14, Ko3.userId, Ko3.portrait, Ko3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString13, "", "", aVar.getMsgId());
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString14);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.x.d.NU().ht(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                                    break;
                                                }
                                                i++;
                                            }
                                        }
                                    } catch (JSONException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            } else {
                                w.a(optString7, Integer.parseInt(optString8), optString9, optString10, Ko3.userId, Ko3.portrait, Ko3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString12, str4, str3, aVar.getMsgId(), optString11);
                            }
                        }
                        Gl(optString7);
                        com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar.gzZ = optLong5;
                        cVar.liveId = j3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                        JSONObject jSONObject7 = new JSONObject();
                        jSONObject7.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                        jSONObject7.putOpt("gift_name", optString9);
                        jSONObject7.putOpt("order_id", optString6);
                        gy = w.gy(optString7);
                        if (gy != null) {
                            jSONObject7.putOpt(LogConfig.LOG_GIFT_VALUE, gy.getPrice());
                        }
                        jSONObject7.putOpt("gift_num", optString8);
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "giftsend_succ").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject7));
                    }
                }
                j = j6;
                j2 = j5;
                j3 = j4;
                str3 = "";
                str4 = "";
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString7, "");
                if (this.isBackground) {
                }
                if (TextUtils.isEmpty(optString13)) {
                }
                w.a(optString7, Integer.parseInt(optString8), optString9, optString10, Ko3.userId, Ko3.portrait, Ko3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString12, str4, str3, aVar.getMsgId(), optString11);
                Gl(optString7);
                com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                cVar2.gzZ = optLong5;
                cVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                JSONObject jSONObject72 = new JSONObject();
                jSONObject72.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                jSONObject72.putOpt("gift_name", optString9);
                jSONObject72.putOpt("order_id", optString6);
                gy = w.gy(optString7);
                if (gy != null) {
                }
                jSONObject72.putOpt("gift_num", optString8);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "giftsend_succ").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject72));
            } catch (JSONException e7) {
            }
        }
        try {
            if (!(aVar.getObjContent() instanceof JSONObject)) {
                jSONObject6 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject6 = new JSONObject(aVar.getContent());
            }
            jSONObject6.put("log_id", aVar.getMsgId());
        } catch (JSONException e8) {
            jSONObject6 = null;
        }
        if (this.gqW != null || this.gqW.N(jSONObject6)) {
        }
    }

    private void Gl(String str) {
        if (this.gpD != null) {
            this.gpD.Gl(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uL(int i) {
        View findViewById = bQB().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gpD != null) {
            this.gpD.bI(2, i);
        }
    }

    private void bVZ() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bQB().gAT != null && AlaMasterLiveRoomOpearator.this.bQB().gAT.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bQB().gAT.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bQB().gAT.startRecord();
                }
            }
        });
    }

    private void bWa() {
        if (bQB().gAT != null && bQB().gAT.getPreview() != null) {
            bQB().gAT.getPreview().setVisibility(8);
            bQB().gAT.stopRecord();
        }
    }

    public void bWb() {
        this.gAQ = bQB().gAu.bXw();
        if (this.gFZ != null) {
            this.gFZ.me(this.gAQ);
        }
    }

    public void bSv() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bWc();
        } else if (this.gFZ != null) {
            this.gFZ.bSv();
        }
    }

    public void mf(boolean z) {
        if (this.gFZ != null) {
            this.gFZ.mf(z);
        }
    }

    public void onDestroy() {
        if (this.gGI != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.gGI);
        }
        this.gGI = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.gGB.removeCallbacksAndMessages(null);
        if (this.gGV != null) {
            this.gGV.mc(true);
        }
        this.gGV = null;
        if (this.gFZ != null) {
            this.gFZ.destroy();
            bQB().gAV.removeView(this.gFZ.getView());
            this.gFZ.release();
            this.gFZ = null;
        }
        if (this.gGX != null) {
            this.gGX.onDestroy();
        }
        if (this.gqo != null) {
            this.gqo.onDestroy();
        }
        if (this.gpy != null) {
            this.gpy.onDestroy();
            this.gpy = null;
        }
        if (this.gGa != null) {
            this.gGa.onDestroy();
        }
        if (this.gqO != null) {
            this.gqO.onDestroy();
            this.gqO = null;
        }
        if (this.gGj != null) {
            this.gGj.stopCountDown();
        }
        if (this.gGc != null) {
            this.gGc.onDestroy();
        }
        if (this.gGe != null) {
            this.gGe.onDestroy();
        }
        if (this.gGC != null) {
            this.gGC.onDestroy();
            this.gGC = null;
        }
        if (this.gqD != null) {
            this.gqD.onDestroy();
            this.gqD = null;
        }
        if (this.gGg != null) {
            this.gGg.release();
        }
        w.Fy();
        com.baidu.live.entereffect.a.Dw().release();
        if (this.gqE != null) {
            this.gqE.onDestroy();
            this.gqE = null;
        }
        if (this.gGf != null) {
            this.gGf.onDestroy();
        }
        if (this.gGd != null) {
            this.gGd.bZr();
            this.gGd.release();
        }
        if (this.gpB != null) {
            this.gpB = null;
        }
        if (this.gpD != null) {
            this.gpD.release();
        }
        if (this.gGd != null) {
            this.gGd.onDestroy();
        }
        if (this.gqC != null) {
            this.gqC.release();
        }
        if (this.gGi != null) {
            this.gGi.release();
        }
        if (this.gqM != null) {
            this.gqM.onDestroy();
        }
        if (this.gGE != null) {
            this.gGE.onDestroy();
        }
        if (this.grb != null) {
            this.grb.release();
        }
        if (this.gGY != null) {
            this.gGY.onDestory();
        }
        if (this.gGZ != null) {
            this.gGZ.release();
        }
        if (this.gqV != null) {
            this.gqV.onDestroy();
        }
        if (this.gqW != null) {
            this.gqW.onDestroy();
        }
        if (this.gGh != null) {
            this.gGh.release();
            this.gGh = null;
        }
        if (this.gHa != null) {
            this.gHa.release();
        }
        if (this.grd != null) {
            this.grd.release();
        }
        if (this.gqX != null) {
            this.gqX.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.grF);
        MessageManager.getInstance().unRegisterListener(this.gHh);
        MessageManager.getInstance().unRegisterListener(this.grH);
        MessageManager.getInstance().unRegisterListener(this.grI);
        MessageManager.getInstance().unRegisterListener(this.gHo);
        MessageManager.getInstance().unRegisterListener(this.buw);
        MessageManager.getInstance().unRegisterListener(this.gnN);
        MessageManager.getInstance().unRegisterListener(this.gHp);
        MessageManager.getInstance().unRegisterListener(this.grG);
        MessageManager.getInstance().unRegisterListener(this.gpZ);
        MessageManager.getInstance().unRegisterListener(this.grM);
        MessageManager.getInstance().unRegisterListener(this.gHl);
        MessageManager.getInstance().unRegisterListener(this.gHm);
        MessageManager.getInstance().unRegisterListener(this.gHi);
        MessageManager.getInstance().unRegisterListener(this.bhf);
        MessageManager.getInstance().unRegisterListener(this.bhg);
        MessageManager.getInstance().unRegisterListener(this.gHj);
        MessageManager.getInstance().unRegisterListener(this.grP);
        MessageManager.getInstance().unRegisterListener(this.grO);
        MessageManager.getInstance().unRegisterListener(this.grQ);
        MessageManager.getInstance().unRegisterListener(this.gHk);
        MessageManager.getInstance().unRegisterListener(this.gHj);
        MessageManager.getInstance().unRegisterListener(this.bgl);
        MessageManager.getInstance().unRegisterListener(this.bcQ);
        MessageManager.getInstance().unRegisterListener(this.grS);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gtv.gBa.a(this.gHy, this.gtv.gAU, this.gGl, alaLivePersonData);
        }
    }

    private void bWc() {
        if (this.gGG != null) {
            this.gtv.gAY.startTime = System.currentTimeMillis();
            this.gtv.gAY.liveTotalTime = System.currentTimeMillis();
            this.gtv.gAY.sampleMemAndCPU();
            this.gtv.gAW.a((short) 4, this.gGG);
        }
    }

    private void GJ(String str) {
        String str2;
        int i;
        if (bQB() != null && bQB().pageContext != null) {
            this.gGB.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bQB().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.gHe == null) {
                    this.gHe = layoutInflater.inflate(a.h.layout_challenge_entry_toast, (ViewGroup) null);
                    this.gHe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaMasterLiveRoomOpearator.this.gGB.removeCallbacksAndMessages(null);
                            if (AlaMasterLiveRoomOpearator.this.gHe != null) {
                                AlaMasterLiveRoomOpearator.this.bQB().gAv.removeView(AlaMasterLiveRoomOpearator.this.gHe);
                            }
                            if (AlaMasterLiveRoomOpearator.this.gGX != null) {
                                AlaMasterLiveRoomOpearator.this.gGX.bQF();
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.gHe.findViewById(a.g.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.i.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.gGB.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bQB().gAv != null && AlaMasterLiveRoomOpearator.this.gtC != null && AlaMasterLiveRoomOpearator.this.gHe != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.gHe.findViewById(a.g.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.gHe.findViewById(a.g.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.u((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.gHe.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gtC.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gtC.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gtC.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gtC.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.gHe.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.gHe.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.gHe != null) {
                                AlaMasterLiveRoomOpearator.this.bQB().gAv.removeView(AlaMasterLiveRoomOpearator.this.gHe);
                            }
                            AlaMasterLiveRoomOpearator.this.bQB().gAv.addView(AlaMasterLiveRoomOpearator.this.gHe, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.x.a.NN().bhy != null) {
                    i = com.baidu.live.x.a.NN().bhy.aHL;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.gGB.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bQB().gAv != null && AlaMasterLiveRoomOpearator.this.gHe != null) {
                            AlaMasterLiveRoomOpearator.this.bQB().gAv.removeView(AlaMasterLiveRoomOpearator.this.gHe);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
