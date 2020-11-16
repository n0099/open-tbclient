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
import com.baidu.live.ab.a;
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
import com.baidu.live.b.i;
import com.baidu.live.b.p;
import com.baidu.live.b.t;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.az;
import com.baidu.live.data.ba;
import com.baidu.live.data.bd;
import com.baidu.live.data.bl;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ae;
import com.baidu.live.gift.ai;
import com.baidu.live.gift.z;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.liveroom.middleware.g;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
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
import com.baidu.live.tbadk.coreextra.data.AlaVideoBCChatData;
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
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
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
    private static final String hlJ;
    private boolean bkX;
    private PendantParentView bpO;
    private BdUniqueId bvG;
    private boolean bvH;
    private boolean bvI;
    private com.baidu.live.ak.a gKF;
    private String gTP;
    private com.baidu.live.g.a gUV;
    protected com.baidu.live.z.a gVC;
    private c gVp;
    private com.baidu.tieba.ala.liveroom.p.a gVq;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gVt;
    private com.baidu.tieba.ala.liveroom.activeview.b gVv;
    protected ae gWH;
    protected com.baidu.live.j.a gWO;
    protected com.baidu.live.r.a gWP;
    protected com.baidu.live.i.a gWQ;
    protected com.baidu.live.r.b gWR;
    private com.baidu.live.w.a gWV;
    protected com.baidu.live.q.a gWZ;
    private com.baidu.live.h.a gWg;
    private com.baidu.tieba.ala.liveroom.share.c gWh;
    private com.baidu.tieba.ala.liveroom.s.b gWi;
    private m gWt;
    private k gWu;
    private com.baidu.live.im.b.a gWv;
    private ab gWw;
    private z gWx;
    private boolean gXl;
    private boolean gYc;
    private e gZr;
    private ImageView gZy;
    private f gZz;
    private boolean hlK;
    private d hlM;
    private com.baidu.tieba.ala.liveroom.p.a hlN;
    private com.baidu.tieba.ala.liveroom.b.a hlO;
    private com.baidu.tieba.ala.liveroom.v.a hlP;
    private com.baidu.tieba.ala.liveroom.x.a hlQ;
    private b hlR;
    private com.baidu.tieba.ala.liveroom.tippop.a hlS;
    private com.baidu.live.r.d hlT;
    private com.baidu.live.r.c hlU;
    protected com.baidu.live.k.a hlV;
    protected com.baidu.live.aj.b hlW;
    private AlaLiveCountDownView hlX;
    private AlaLiveStreamStatusView hlY;
    private RelativeLayout hlZ;
    private boolean hlt;
    private short hmH;
    private com.baidu.tieba.ala.liveroom.h.b hmM;
    private com.baidu.tieba.ala.liveroom.challenge.e hmN;
    private com.baidu.live.ai.a hmO;
    private com.baidu.live.a.a hmP;
    private com.baidu.live.a.b hmQ;
    private com.baidu.tieba.ala.liveroom.r.a hmR;
    private boolean hmS;
    private View hmT;
    private FrameLayout hmU;
    private boolean hmV;
    private RelativeLayout hma;
    private RelativeLayout hmb;
    private RelativeLayout hmc;
    private RelativeLayout hmd;
    private FrameLayout hme;
    private FrameLayout hmf;
    private View hmg;
    private boolean hmh;
    private AlaLiveFaceVerifyView hmi;
    private ImageView hmj;
    private ImageView hmk;
    private ImageView hml;
    private ImageView hmm;
    private ImageView hmn;
    private ImageView hmo;
    private ImageView hmp;
    private TextView hmq;
    private aq hmr;
    private com.baidu.live.ad.a hmt;
    private com.baidu.tieba.ala.liveroom.master.panel.b hmu;
    private com.baidu.live.ab.a hmv;
    private ImageView hmw;
    private com.baidu.tieba.ala.liveroom.data.d hmx;
    private boolean hlL = false;
    private boolean gXg = false;
    private Handler mHandler = new Handler();
    private Handler hms = new Handler();
    private boolean hmy = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hmz = null;
    private boolean hmA = false;
    private int hmB = 0;
    private int hmC = 0;
    private int hmD = 0;
    private long hmE = 0;
    private long hmF = 0;
    private volatile boolean isBackground = false;
    private Intent hmG = null;
    private int mOrientation = 1;
    private boolean hgy = false;
    private boolean hmI = false;
    private boolean hmJ = true;
    private boolean gZw = false;
    private boolean hmK = true;
    private boolean hmL = true;
    private int dyu = 0;
    private String otherParams = "";
    private int bla = 0;
    private Runnable hmW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.gUV != null) {
                AlaMasterLiveRoomOpearator.this.gUV.Ew();
            }
        }
    };
    private com.baidu.live.ai.b bFj = new com.baidu.live.ai.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.ai.b
        public boolean Ug() {
            if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                if (AlaMasterLiveRoomOpearator.this.gWP != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hmN.bYQ() && !AlaMasterLiveRoomOpearator.this.hmN.bYR() && !AlaMasterLiveRoomOpearator.this.gWP.Oe() && !AlaMasterLiveRoomOpearator.this.gWP.CC()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hmN.bYQ() && !AlaMasterLiveRoomOpearator.this.hmN.bYR()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.gWP == null || AlaMasterLiveRoomOpearator.this.gWP.Oe() || AlaMasterLiveRoomOpearator.this.gWP.CC()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.ai.b
        public void Uh() {
            if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                AlaMasterLiveRoomOpearator.this.hmN.bYT();
            }
        }
    };
    private CustomMessageListener blZ = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gZr.hgJ != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gZr.hgJ.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.H(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener bma = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gZr.hgJ != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gZr.hgJ.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener gXF = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gWi == null) {
                        AlaMasterLiveRoomOpearator.this.gWi = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gWi.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener gXM = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gWO != null) {
                AlaMasterLiveRoomOpearator.this.gWO.Ko();
            }
        }
    };
    private CustomMessageListener hmX = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gXD = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Hr(str);
            }
        }
    };
    private CustomMessageListener guI = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bsj();
        }
    };
    private CustomMessageListener gVS = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gWx.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gXJ = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hmY = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hmQ != null) {
                w Gz = AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz();
                long j = Gz.mLiveInfo.live_id;
                long j2 = Gz.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.hmQ.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener hmZ = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bYO().hgl);
            if (AlaMasterLiveRoomOpearator.this.hlM == null || AlaMasterLiveRoomOpearator.this.hlM.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.wv(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gWu != null) {
                AlaMasterLiveRoomOpearator.this.gWu.La().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gWu.Lb().hide();
            }
        }
    };
    private CustomMessageListener gXL = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.C(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz());
        }
    };
    private CustomMessageListener gXN = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gWH != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) AlaMasterLiveRoomOpearator.this.gWH).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hna = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hmR != null) {
                    AlaMasterLiveRoomOpearator.this.hmR.hN(str);
                }
            }
        }
    };
    private CustomMessageListener bvJ = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hmM != null) {
                        if (!data.aCu || AlaMasterLiveRoomOpearator.this.bvG == null || !AlaMasterLiveRoomOpearator.this.hmS) {
                            if (AlaMasterLiveRoomOpearator.this.bvG != null && AlaMasterLiveRoomOpearator.this.bvG == data.aCt) {
                                if (data.aCn != null && data.aCn.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hmS || AlaMasterLiveRoomOpearator.this.hlM.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hmM.a(AlaMasterLiveRoomOpearator.this.bYO().hgB.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bvI = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bYO().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bvG = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bYO().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hmM.a(AlaMasterLiveRoomOpearator.this.bYO().hgB.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bvI);
                        if (!AlaMasterLiveRoomOpearator.this.bvI) {
                            AlaMasterLiveRoomOpearator.this.bvI = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bvH) {
                    AlaMasterLiveRoomOpearator.this.bYO().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.bvH = false;
            }
        }
    };
    private CustomMessageListener bvK = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bYO().hgB != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bYO().hgB.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.Aq().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener blf = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bla == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bla == 6) {
                            AlaMasterLiveRoomOpearator.this.cdv();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bla = 0;
            }
        }
    };
    private View.OnClickListener hnb = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hmk) {
                    AlaMasterLiveRoomOpearator.this.cdA();
                    AlaMasterLiveRoomOpearator.this.hmu.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hmj) {
                    if (view == AlaMasterLiveRoomOpearator.this.hml) {
                        AlaMasterLiveRoomOpearator.this.bsj();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hmm) {
                        if (view != AlaMasterLiveRoomOpearator.this.hmo) {
                            if (view == AlaMasterLiveRoomOpearator.this.gZy) {
                                if (AlaMasterLiveRoomOpearator.this.cdu()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.gWP != null) && AlaMasterLiveRoomOpearator.this.gWP.CC()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.gWP.Oe() & (AlaMasterLiveRoomOpearator.this.gWP != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hmN.bYQ()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hmN.bYR()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hmN.bYS();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hmn) {
                                if (AlaMasterLiveRoomOpearator.this.hlQ != null) {
                                    ap cfF = AlaMasterLiveRoomOpearator.this.bYO().hgk.cfF();
                                    if (cfF == null || cfF.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(cfF.mLiveSdkInfo.mRoomId);
                                        if (cfF.mLiveSdkInfo.mCastIds != null) {
                                            str2 = cfF.mLiveSdkInfo.mCastIds.chatMCastId;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.hlQ.as("", str, str2);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hmp) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hmN.bYQ() || AlaMasterLiveRoomOpearator.this.hmN.bYR() || AlaMasterLiveRoomOpearator.this.gWP.Oe() || AlaMasterLiveRoomOpearator.this.gWP.CC()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hmO != null) {
                                    AlaMasterLiveRoomOpearator.this.hmO.Ud();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hmv != null) {
                            AlaMasterLiveRoomOpearator.this.hmv.PA();
                            AlaMasterLiveRoomOpearator.this.hmv.cz(AlaMasterLiveRoomOpearator.this.cdI());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.hmS = false;
                        AlaMasterLiveRoomOpearator.this.ny(true);
                        AlaMasterLiveRoomOpearator.this.hmq.setVisibility(4);
                        com.baidu.live.d.Aq().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.aa.a.Ph().bms.aLD == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.Ph().bms.aLC == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bkX) {
                        AlaMasterLiveRoomOpearator.this.cdv();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bla = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.cdv();
                }
            }
        }
    };
    private CustomMessageListener gXE = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof aq) {
                    AlaMasterLiveRoomOpearator.this.gXg = true;
                    AlaMasterLiveRoomOpearator.this.hmr = (aq) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gWu != null) {
                        AlaMasterLiveRoomOpearator.this.gWu.La().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gWu != null) {
                        AlaMasterLiveRoomOpearator.this.gWu.Lb().show();
                        AlaMasterLiveRoomOpearator.this.gWu.Lb().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.wv(8);
                }
            }
        }
    };
    private CustomMessageListener hnc = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bYO() != null && AlaMasterLiveRoomOpearator.this.bYO().hgH != null) {
                AlaMasterLiveRoomOpearator.this.bYO().hgH.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bFQ = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.ceq();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bYO().hgk.wC(i);
            }
        }
    };
    private CustomMessageListener gUa = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.cej();
        }
    };
    private CustomMessageListener gKG = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ak.c)) {
                if (AlaMasterLiveRoomOpearator.this.gKF == null) {
                    AlaMasterLiveRoomOpearator.this.gKF = new com.baidu.live.ak.a(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.gKF.a((com.baidu.live.ak.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hnd = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Nx()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hmu != null) {
                            AlaMasterLiveRoomOpearator.this.hmu.nF(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.hmu.ceO();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bYO().hgB.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hmO != null) {
                        AlaMasterLiveRoomOpearator.this.hmO.setMute(AlaMasterLiveRoomOpearator.this.bYO().hgB.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hlW != null) {
                        AlaMasterLiveRoomOpearator.this.hlW.setMute(AlaMasterLiveRoomOpearator.this.bYO().hgB.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hlS != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hlS.a(AlaMasterLiveRoomOpearator.this.bYO().hgE, AlaMasterLiveRoomOpearator.this.bYO().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bYO().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hlS.wK(2);
                        AlaMasterLiveRoomOpearator.this.hlS.a(AlaMasterLiveRoomOpearator.this.bYO().hgE, string, 3);
                    }
                }
            }
        }
    };
    private e.a hne = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cew() {
            AlaMasterLiveRoomOpearator.this.wu(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cex() {
            AlaMasterLiveRoomOpearator.this.wu(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hnf = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean eK(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void eL(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bYO().caK() == 1) {
                AlaMasterLiveRoomOpearator.this.bYO().hgB.stopRecord();
            }
        }
    };
    private IShareCallback hng = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hmy && AlaMasterLiveRoomOpearator.this.hmx != null) {
                AlaMasterLiveRoomOpearator.this.hmy = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hmx);
            }
        }
    };
    private View.OnTouchListener hnh = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bYO().hgH.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bYO().hgl);
            AlaMasterLiveRoomOpearator.this.wv(0);
            if (AlaMasterLiveRoomOpearator.this.gWu != null) {
                AlaMasterLiveRoomOpearator.this.gWu.La().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.gWu.Lb().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hni = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cey() {
            AlaMasterLiveRoomOpearator.this.cdw();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cez() {
            AlaMasterLiveRoomOpearator.this.hlt = AlaMasterLiveRoomOpearator.this.hlM.caC();
            AlaMasterLiveRoomOpearator.this.bYO().hgH.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bYO().hgH.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bYO().hgH.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hgv = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.bYO().caK();
            dVar.title = AlaMasterLiveRoomOpearator.this.hlM.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hgw = AlaMasterLiveRoomOpearator.this.hlM.caD();
            dVar.hgz = AlaMasterLiveRoomOpearator.this.hlt;
            dVar.hgy = AlaMasterLiveRoomOpearator.this.hlM.caA();
            dVar.hgx = AlaMasterLiveRoomOpearator.this.hlM.caF();
            dVar.hgA = AlaMasterLiveRoomOpearator.this.hlM.caB();
            if (dVar.hgA) {
                if (AlaMasterLiveRoomOpearator.this.hlM.caG()) {
                    AlaMasterLiveRoomOpearator.this.hmy = true;
                    AlaMasterLiveRoomOpearator.this.hmx = dVar;
                    AlaMasterLiveRoomOpearator.this.hlM.caH();
                } else {
                    AlaMasterLiveRoomOpearator.this.c(dVar);
                }
                if (FinishLiveManager.getInstance().getFinishListener() != null) {
                    FinishLiveManager.getInstance().getFinishListener().onStartLive();
                }
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_END);
                    alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    return;
                }
                return;
            }
            AlaMasterLiveRoomOpearator.this.bYO().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bYO().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ceA() {
            AlaMasterLiveRoomOpearator.this.hmS = true;
            AlaMasterLiveRoomOpearator.this.ny(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean ceB() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ceC() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener bhz = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bWS();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hnj = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Ns() {
            if (AlaMasterLiveRoomOpearator.this.hlQ != null) {
                AlaMasterLiveRoomOpearator.this.hlQ.nS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cm(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hmv != null) {
                        AlaMasterLiveRoomOpearator.this.hmv.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hmv != null) {
                    AlaMasterLiveRoomOpearator.this.hmv.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hlQ != null) {
                    AlaMasterLiveRoomOpearator.this.hlQ.nS(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gWH != null) {
                    AlaMasterLiveRoomOpearator.this.gWH.bv(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hnk = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void aeS() {
            if (AlaMasterLiveRoomOpearator.this.hmi != null && AlaMasterLiveRoomOpearator.this.bYO().hgE.indexOfChild(AlaMasterLiveRoomOpearator.this.hmi) >= 0) {
                AlaMasterLiveRoomOpearator.this.bYO().hgE.removeView(AlaMasterLiveRoomOpearator.this.hmi);
                AlaMasterLiveRoomOpearator.this.hmi.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hmi = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gVX = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void s(View view, int i) {
            w Gz;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.cep();
            } else if (i == 14 && (Gz = AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz()) != null && Gz.aHk != null && Gz.mLiveInfo != null && Gz.aHG != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity(), Gz.aHk.userName, Long.toString(Gz.aHk.userId), Long.toString(Gz.aHk.charmCount), String.valueOf(Gz.mLiveInfo.group_id), String.valueOf(Gz.mLiveInfo.live_id), true, String.valueOf(Gz.aHk.userId), Long.toString(Gz.aHG.userId), Gz.aHG.userName, Gz.aHG.portrait, AlaMasterLiveRoomOpearator.this.gVt.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Gz.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gVt.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hnl = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private g hnm = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.aye);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hlJ = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.aa.a.Ph().bms != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bYO().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.aa.a.Ph().bms.aLy, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hr(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bYO().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bYO().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.aa.a.Ph().bms.aKW;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bYO().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : bYO().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bYO().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWS() {
        int i = bYO().hgk.Gz().aHk.isUegBlock;
        int i2 = bYO().hgk.Gz().aHk.isBlock;
        String str = bYO().hgk.Gz().aHk.userName;
        if (i > 0 || i2 > 0) {
            this.bkX = true;
            this.gWu.a(true, i, i2, str);
            return;
        }
        this.bkX = false;
        this.gWu.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gZr.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bka == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bkb);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gZr.pageContext.getPageActivity());
            bdAlertDialog.setMessage(format);
            bdAlertDialog.setPositiveButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
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
            bdAlertDialog.setNegativeButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                bdAlertDialog.setPositiveButtonTextColor(pageActivity.getResources().getColorStateList(a.e.sdk_dialog_blue_button_txt_selector));
                bdAlertDialog.setNagetiveButtonTextColor(pageActivity.getResources().getColorStateList(a.e.sdk_dialog_gray_button_txt_selector));
            } else {
                bdAlertDialog.setPositiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
                bdAlertDialog.setNagetiveButtonTextColor(ViewCompat.MEASURED_STATE_MASK);
            }
            bdAlertDialog.create(this.gZr.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cdu() {
        if (this.hmO != null && this.hmO.Ue()) {
            BdUtilHelper.showToast(this.gZr.pageContext.getPageActivity(), this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hlW != null && this.hlW.PV()) {
            BdUtilHelper.showToast(this.gZr.pageContext.getPageActivity(), this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdv() {
        if (this.gWu != null) {
            this.gWu.Lb().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hmN != null) {
            this.hmN.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdw() {
        if (bYO() != null && bYO().hgk != null) {
            bYO().hgk.cfy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bQj() != null && aVar.bQk() != null) {
            bYO().hgk.ew(aVar.bQj().getId(), aVar.bQk().getId());
        }
    }

    public void b(short s) {
        if (this.hmM != null) {
            this.hmM.b(s);
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
                    AlaMasterLiveRoomOpearator.this.hmA = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hmA = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hmB == 0) {
                    AlaMasterLiveRoomOpearator.this.hmB = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hmC == 0) {
                    AlaMasterLiveRoomOpearator.this.hmC = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hmD = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (bYO() != null && bYO().hgF != null) {
            bYO().hgF.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.gZr = eVar;
        this.gTP = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.e bYO() {
        return this.gZr;
    }

    public int a(f fVar) {
        this.gZz = fVar;
        this.hmz = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hmz, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hlS == null) {
            this.hlS = new com.baidu.tieba.ala.liveroom.tippop.a(this.gZr.pageContext, null);
        }
        registerListener();
        this.gUV = new com.baidu.live.g.a();
        cdS();
        cdx();
        cdz();
        Long[] lArr = new Long[1];
        this.hmE = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hmF = lArr[0] != null ? lArr[0].longValue() : 0L;
        bYO().hgl.setOnTouchListener(this.hnh);
        this.hlK = SharedPrefHelper.getInstance().getBoolean(hlJ, false);
        this.hlX = new AlaLiveCountDownView(bYO().pageContext.getPageActivity());
        this.hlX.setCount(3);
        this.hlX.setTextColor(bYO().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hlX.setTextSize(bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hlX.setTypeface(Typeface.DEFAULT_BOLD);
        this.hlX.setIncludeFontPadding(false);
        this.hlX.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void ceD() {
                if (AlaMasterLiveRoomOpearator.this.bYO().hgl != null) {
                    AlaMasterLiveRoomOpearator.this.bYO().hgl.removeView(AlaMasterLiveRoomOpearator.this.hlX);
                }
            }
        });
        return 1;
    }

    private void cdx() {
        CustomResponsedMessage runTask;
        if (this.hlV == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.k.a.class, bYO().pageContext)) != null && runTask.getData() != null) {
            this.hlV = (com.baidu.live.k.a) runTask.getData();
            this.hlV.c(bYO().pageContext);
        }
    }

    private void cdy() {
        CustomResponsedMessage runTask;
        if (cdF() && this.hlW == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.aj.b.class, bYO().pageContext)) != null && runTask.getData() != null) {
            this.hlW = (com.baidu.live.aj.b) runTask.getData();
            if (bYO() != null && bYO().hgk != null && bYO().hgk.Gz() != null) {
                this.hlW.setLiveShowData(bYO().hgk.Gz());
            }
            if (bYO() != null && bYO().hgB != null) {
                this.hlW.L(bYO().hgB);
                this.hlW.setMute(bYO().hgB.isMute());
            }
            if (this.hlW != null && this.hmf != null) {
                this.hlW.a(new com.baidu.live.aj.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                    @Override // com.baidu.live.aj.a
                    public boolean PX() {
                        if ((AlaMasterLiveRoomOpearator.this.gWP != null) && AlaMasterLiveRoomOpearator.this.gWP.CC()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.gWP != null) & AlaMasterLiveRoomOpearator.this.gWP.Oe()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hmN == null || !AlaMasterLiveRoomOpearator.this.hmN.bYQ()) {
                            if (AlaMasterLiveRoomOpearator.this.hmN == null || !AlaMasterLiveRoomOpearator.this.hmN.bYR()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hlW.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hmf.setVisibility(0);
                    this.hmf.addView(enterView);
                }
            }
            if (this.hlW != null) {
                this.hlW.Y(bYO().hgC);
            }
            if (this.hlW != null && bYO().hgD != null) {
                this.hlW.a(bYO().hgD);
            }
        }
    }

    private void cdz() {
        View rootLayout;
        if (this.hlV != null && this.hme != null && (rootLayout = this.hlV.cf(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hme.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdA() {
        if (this.hmu == null) {
            this.hmu = new com.baidu.tieba.ala.liveroom.master.panel.b(bYO().pageContext.getPageActivity(), bYO().caK() == 2);
            this.hmu.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nA(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bYO().hgB.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nB(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bYO().hgB.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nC(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bYO().hgB.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.ceo();
                    if (AlaMasterLiveRoomOpearator.this.hlS != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hlS.a(AlaMasterLiveRoomOpearator.this.bYO().hgE, AlaMasterLiveRoomOpearator.this.bYO().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hlS.a(AlaMasterLiveRoomOpearator.this.bYO().hgE, AlaMasterLiveRoomOpearator.this.bYO().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nD(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ceE() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bYO().hgk != null && AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz() != null && AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hmu != null) {
                        AlaMasterLiveRoomOpearator.this.hmu.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.a(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ceF() {
                    if (AlaMasterLiveRoomOpearator.this.hmu != null) {
                        AlaMasterLiveRoomOpearator.this.hmu.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.bYO().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ceG() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bYO() != null && AlaMasterLiveRoomOpearator.this.bYO().hgk != null && AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz() != null && AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(AlaMasterLiveRoomOpearator.this.bYO().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hmu != null) {
                            AlaMasterLiveRoomOpearator.this.hmu.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ceH() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bYO() == null || AlaMasterLiveRoomOpearator.this.bYO().hgk == null || AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz() == null || AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bYO() != null && AlaMasterLiveRoomOpearator.this.bYO().hgk != null && AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz() != null && AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hmu != null) {
                                        AlaMasterLiveRoomOpearator.this.hmu.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.gZr.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hmu != null) {
                        AlaMasterLiveRoomOpearator.this.hmu.dismiss();
                    }
                }
            });
        }
        cdB();
    }

    private void cdB() {
        if (this.hmu != null) {
            boolean isBackCamera = bYO().hgB.isBackCamera();
            this.hmu.nE(bYO().hgB.isBackCamera());
            this.hmu.Q(bYO().hgB.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bYO().hgB.isPushMirror();
            if (this.hmJ) {
                isPushMirror = cen() || isPushMirror;
                this.hmJ = false;
            }
            this.hmu.R(isPushMirror, isBackCamera ? false : true);
            this.hmu.nF(bYO().hgB.isMute());
            this.hmu.ceO();
        }
    }

    public void cdC() {
        if (this.gZz != null) {
            if (this.gZz.hgK == null || this.gZz.hgK.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hmg == null) {
                        this.hmg = this.gZr.hgJ.MU();
                        this.gZr.hgE.addView(this.hmg, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hlM == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bYO().hgk != null && bYO().hgk.Gz() != null && bYO().hgk.Gz().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bYO().hgk.Gz().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bYO().hgk.Gz().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hlM = new d(bYO().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bYO().hgH.prepareTime = System.currentTimeMillis();
                    bYO().hgE.addView(this.hlM.getView(), layoutParams);
                    this.hlM.a(this.hng);
                }
                this.hlM.ng(this.hgy);
                this.hlM.a(this.hni);
                this.hlM.a(this.hne);
                this.hlM.a(bYO().hgB, bYO().caK());
                this.hlM.a(this.hlV);
                return;
            }
            this.hlt = this.gZz.hgK.mLiveInfo.screen_direction == 2;
            if (this.gZz.hgK.mLiveInfo.isAudioOnPrivate == 1) {
                bYO().hgB.setMute(true);
                if (this.hmO != null) {
                    this.hmO.setMute(bYO().hgB.isMute());
                }
                if (this.hlW != null) {
                    this.hlW.setMute(bYO().hgB.isMute());
                }
                if (this.hlS == null) {
                    this.hlS = new com.baidu.tieba.ala.liveroom.tippop.a(this.gZr.pageContext, null);
                }
                if (!this.hlS.wJ(2)) {
                    this.hlS.a(bYO().hgE, bYO().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hgv = true;
            dVar.forumId = String.valueOf(this.gZz.hgK.mLiveInfo.forum_id);
            dVar.forumName = this.gZz.hgK.mLiveInfo.forum_name;
            dVar.liveType = this.gZz.hgK.mLiveInfo.live_type;
            dVar.title = this.gZz.hgK.mLiveInfo.getLiveTitle();
            dVar.clarity = this.gZz.hgK.mLiveInfo.clarity;
            dVar.gameId = this.gZz.hgK.mLiveInfo.game_id;
            dVar.gameName = this.gZz.hgK.mLiveInfo.game_label;
            dVar.hgz = this.gZz.hgK.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void cdD() {
        if (this.hmM != null) {
            this.hmM.a(bYO().hgB.getVideoConfig(), false);
        }
        if (this.hlM != null) {
            this.hlM.nf(true);
        }
        if (bYO().hgB.hasBeauty() >= 0) {
            bYO().hgB.setBeauty(com.baidu.live.d.Aq().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bYO().hgJ.I(this.gZr.hgB);
        } else if (this.hlM != null) {
            this.hlM.nf(true);
        }
        cdR();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hmg != null && this.hmg.getParent() != null) {
                ((ViewGroup) this.hmg.getParent()).removeView(this.hmg);
                this.hmg = null;
            }
            bYO().hgl.setVisibility(0);
            this.gZr.hgJ.a(bYO().hgl);
        } else {
            cdZ();
            cem();
            if (this.hmU != null) {
                this.hmU.setVisibility(0);
            }
            this.hlQ = new com.baidu.tieba.ala.liveroom.x.a(bYO().pageContext, this.hnf);
            this.hlQ.d(bYO().hgl, true);
            this.hlQ.nS(true);
            if (this.gWu != null && this.gWu.La() != null) {
                this.gWu.La().setNeedTopAlphaShade(true);
            }
        }
        bYO().hgB.setPushMirror(cen());
    }

    public void b(ap apVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gZr.hgJ.k(bYO().hgk.Gz());
        }
        if (!bYO().hgB.isBackground() && bYO().hgk.Gz() != null && bYO().hgk.Gz().mLiveInfo != null) {
            int startPush = bYO().hgB.startPush(bYO().hgk.Gz().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gZr.hgJ.MV();
            }
            if (startPush != 0 && bYO().hgH != null) {
                bYO().hgH.errCode = 4;
                bYO().hgH.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (apVar != null && !apVar.Eb() && !cek()) {
                nz(true);
                cel();
            }
            if (this.gVq != null) {
                this.gVq.H(bYO().hgk.Gz());
            }
            if (this.gWg != null) {
                this.gWg.a(bYO().hgk.Gz());
            }
            if (this.hlV != null) {
                this.hlV.e(bYO().hgk.Gz());
                this.hlV.hH(this.otherParams);
            }
            if (this.gVq != null) {
                this.gVq.nt(true);
            }
            if (this.hlN != null) {
                this.hlN.H(bYO().hgk.Gz());
            }
            if (apVar == null || apVar.aHk == null) {
                z = com.baidu.live.d.Aq().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = apVar.aHk.canUseChallenge;
                com.baidu.live.d.Aq().putBoolean("ala_master_can_use_challenge", z);
            }
            bXM();
            cea();
            cdK();
            nx(z);
            bWD();
            ceb();
            cef();
            I(bYO().hgk.Gz());
            f(bYO().hgk.Gz());
            ceg();
            ceh();
            cdE();
            cee();
            bXJ();
            bXL();
            bWC();
            bXx();
            bXF();
            bXG();
            cdX();
            cdY();
            J(bYO().hgk.Gz());
            bXy();
            if (this.gWt != null) {
                this.gWt.g(bYO().hgk.Gz());
            }
            if (this.gWu != null) {
                if (bYO().hgk.Gz() != null && bYO().hgk.Gz().aHW != null && bYO().hgk.Gz().aHW.Dr()) {
                    z2 = true;
                }
                this.gWu.a(String.valueOf(bYO().hgk.Gz().mLiveInfo.group_id), String.valueOf(bYO().hgk.Gz().mLiveInfo.last_msg_id), String.valueOf(bYO().hgk.Gz().aHk.userId), String.valueOf(bYO().hgk.Gz().mLiveInfo.live_id), bYO().hgk.Gz().aHk.appId, z2);
            }
            if (this.gWv != null) {
                this.gWv.a(bYO().hgk.Gz(), true);
            }
            cdG();
            cdy();
            bXQ();
            this.mHandler.post(this.hmW);
        }
    }

    protected void bXQ() {
        if (this.gWZ == null && bYO() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.q.a.class, bYO().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.gWZ = (com.baidu.live.q.a) runTask.getData();
                this.gWZ.m(bYO().hgl);
            }
        }
    }

    private void cdE() {
        if (this.hlO != null && bYO() != null && bYO().hgk != null) {
            if (this.hlO.au(this.hmb)) {
                this.hlO.B(bYO().hgk.Gz());
            } else {
                this.hlO.c(this.hmb, bYO().hgk.Gz());
            }
        }
    }

    private void bWD() {
        if (this.bpO == null) {
            this.bpO = new PendantParentView(bYO().pageContext.getPageActivity(), this.gYc ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bYO().hgl.addView(this.bpO, layoutParams);
            this.bpO.setDefaultItemMargin(bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.bpO.setPadding(bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            bYr();
        }
    }

    private void bYr() {
        if (this.bpO != null) {
            int dimensionPixelSize = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bpO.getLayoutParams();
            if (this.gYc) {
                this.bpO.setPosition(0, 0, this.hmN.bYx(), dimensionPixelSize2);
            } else {
                this.bpO.setPosition(dimensionPixelSize, 0, bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278), dimensionPixelSize2);
            }
            this.bpO.setLayoutParams(layoutParams);
            this.bpO.setModel(this.gYc ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bYs() {
        if (this.gWu != null && this.gWu.La() != null && this.gWu.La().getView() != null) {
            if (this.gYc && !this.hlL && bYO().hgl != null && bYO().hgl.getHeight() > 0) {
                int bm = this.hmN != null ? this.hmN.bm(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.gWu.La().getView().getLayoutParams();
                int height = bYO().hgl.getHeight() - bm;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.gWu.La().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ag.b.i(false, this.hlL);
            if (bYO().hgl.indexOfChild(this.gWu.La().getView()) != -1 && this.gWu.La().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWu.La().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.gWu.La().getView().setLayoutParams(layoutParams2);
            }
            this.gWu.La().KZ();
        }
    }

    private void bYt() {
        if (this.gWw != null) {
            if (this.gYc && !this.hlL && bYO().hgl != null && bYO().hgl.getHeight() > 0) {
                this.gWw.dQ((bYO().hgl.getHeight() - (this.hmN != null ? h.j(bYO().pageContext.getPageActivity(), true) : 0)) + bYO().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.gWw.dQ(com.baidu.live.ag.a.a(bYO().pageContext.getPageActivity(), true, false, this.hlL));
            }
        }
    }

    private void bYu() {
        int i;
        if (this.gWw != null) {
            int h = com.baidu.live.ag.a.h(true, false);
            if (!this.gYc || bYO().hgl == null || bYO().hgl.getHeight() <= 0) {
                i = h;
            } else {
                i = (bYO().hgl.getHeight() - (this.hmN != null ? this.hmN.bm(false) : 0)) + bYO().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.gWw.dR(i);
        }
    }

    private void bYv() {
        if (this.gWv != null && this.gWv.Cb() != null) {
            ViewGroup.LayoutParams layoutParams = this.gWv.Cb().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bYO().pageContext.getResources().getDimensionPixelOffset(this.gYc ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.gWv.Cb().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean cdF() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = bYO().hgk.Gz().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void cdG() {
        if (this.hlW == null && !cdF()) {
            boolean z = (bYO().hgk == null || bYO().hgk.cfF() == null || bYO().hgk.cfF().mLiveInfo.videoBBChatData == null || !bYO().hgk.cfF().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && bYO().hgk != null && bYO().hgk.Gz() != null && bYO().hgk.Gz().mLiveInfo != null && bYO().hgk.Gz().mLiveInfo.videoBBChatData != null && bYO().hgk.Gz().aHS) {
                z = bYO().hgk.Gz().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hmp != null) {
                this.hmp.setVisibility(z ? 0 : 8);
            }
            cdH();
        }
    }

    private void cdH() {
        CustomResponsedMessage runTask;
        if (this.hmO == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.ai.a.class, bYO().pageContext)) != null && runTask.getData() != null) {
            this.hmO = (com.baidu.live.ai.a) runTask.getData();
        }
        if (this.hmO != null) {
            this.hmO.v((ViewGroup) bYO().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hmO.u(bYO().hgE);
            this.hmO.s(bYO().hgk.Gz());
            this.hmO.L(bYO().hgB);
            this.hmO.a(bYO().hgD);
            this.hmO.a(this.bFj);
            if (bYO().hgB != null) {
                this.hmO.setMute(bYO().hgB.isMute());
            }
        }
    }

    private void nx(boolean z) {
        if (this.hmN == null) {
            this.hmN = new com.baidu.tieba.ala.liveroom.challenge.e(bYO());
        }
        this.hmN.a(this.gZy, this.gZz, z);
        this.hmN.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(az azVar, bd bdVar, bd bdVar2) {
                AlaMasterLiveRoomOpearator.this.gYc = true;
                AlaMasterLiveRoomOpearator.this.bYO().hgl.hvO = false;
                if (AlaMasterLiveRoomOpearator.this.hmv != null) {
                    AlaMasterLiveRoomOpearator.this.hmv.fb(4);
                    AlaMasterLiveRoomOpearator.this.hmv.cz(true);
                }
                AlaMasterLiveRoomOpearator.this.VG();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void CI() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hmW);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bYM() {
                AlaMasterLiveRoomOpearator.this.gYc = false;
                AlaMasterLiveRoomOpearator.this.bYO().hgl.hvO = false;
                if (AlaMasterLiveRoomOpearator.this.hmv != null) {
                    AlaMasterLiveRoomOpearator.this.hmv.fb(0);
                    AlaMasterLiveRoomOpearator.this.hmv.cz(false);
                }
                AlaMasterLiveRoomOpearator.this.cdJ();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bYN() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hmW);
            }
        });
        this.hmN.N(this.hlt, z);
        this.hmN.j(this.hlt, z, (this.gZz == null || this.gZz.hgK == null || this.gZz.hgK.mChallengeData == null) ? false : true);
    }

    public boolean cdI() {
        return this.hmN != null && this.hmN.bYV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VG() {
        if (this.hlR != null) {
            this.hlR.setVisible(8);
            this.hlR.setCanVisible(false);
        }
        if (this.gVv != null) {
            this.gVv.mH(true);
        }
        if (this.hlY != null) {
            this.hlY.setCanVisible(false);
            this.hlY.setVisibility(4);
        }
        if (this.hlQ != null) {
            this.hmh = this.hlQ.chR();
            this.hlQ.nR(false);
        }
        if (this.gWP != null) {
            this.gWP.setCanVisible(false);
        }
        if (this.gVC != null) {
            this.gVC.setCanVisible(false);
        }
        bYr();
        bYs();
        bYt();
        bYu();
        bYv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdJ() {
        if (this.hlR != null) {
            this.hlR.setCanVisible(true);
        }
        if (this.gVv != null) {
            this.gVv.mH(false);
        }
        if (this.hlY != null) {
            this.hlY.setCanVisible(true);
        }
        if (this.hlQ != null) {
            this.hlQ.nR(this.hmh);
        }
        if (this.gWP != null) {
            this.gWP.setCanVisible(true);
        }
        if (this.gVC != null) {
            this.gVC.cx(true);
        }
        bYr();
        bYs();
        bYt();
        bYu();
        bYv();
    }

    private void cdK() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hlY == null) {
            this.hlY = new AlaLiveStreamStatusView(bYO().pageContext.getPageActivity());
        }
        this.hlY.setId(a.f.ala_live_room_stream_view);
        this.hlY.setVisibility(4);
        this.hlY.setLayoutParams(layoutParams);
        if (this.hlY.getParent() == null && this.hmb != null) {
            this.hmb.addView(this.hlY, layoutParams);
        }
    }

    public void cdL() {
        if (this.hlM != null && this.hlM.getVisibility() != 8 && bYO().hgB.getPreview() != null) {
            bYO().hgB.stopRecord();
        }
    }

    public void cdM() {
        if (bYO().hgB.getPreview() != null) {
            bYO().hgB.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hmM != null) {
                this.hmM.ne(false);
            }
            this.hmM = new com.baidu.tieba.ala.liveroom.h.b(bYO().hgE, bYO(), bYO().hgB);
            this.hmM.a(bYO().hgB.getVideoConfig(), false);
        }
        if (this.hlS != null) {
            this.hlS.cgL();
        }
        this.mHandler.post(this.hmW);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hlL = z;
        if (z) {
            if (this.hmL) {
                this.hmL = false;
                if (this.gWu != null && this.gWu.La() != null) {
                    this.gWu.La().getView().setBottom(0);
                }
                if (this.gWu != null && this.gWu.Lb() != null) {
                    this.gWu.Lb().getView().setBottom(0);
                }
            }
            if (this.gWw != null && this.gWw.FY() != null) {
                this.gWw.FY().setVisibility(8);
            }
            if (this.gWu != null && this.gWu.La() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gWu.La().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.gWu.La().getView().setLayoutParams(layoutParams);
            }
            if (this.gWu != null && this.gWu.Lb() != null && this.gWu.Lb().getView() != null && this.gWu.Lb().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWu.Lb().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gWu.Lb().getView().setLayoutParams(layoutParams2);
                this.gWu.Lb().getView().setVisibility(0);
                this.gWu.Lb().MC();
            }
            wv(8);
            wt(8);
            if (this.gWx != null && this.gWx.Gy() != null) {
                this.gWx.Gy().setVisibility(8);
            }
        } else {
            if (this.gWw != null && this.gWw.FY() != null) {
                this.gWw.FY().setVisibility(0);
            }
            if (this.gWu != null && this.gWu.La() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gWu.La().getView().getLayoutParams();
                layoutParams3.bottomMargin = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.gWu.La().getView().setLayoutParams(layoutParams3);
            }
            if (this.gWu != null && this.gWu.Lb() != null) {
                this.gWu.Lb().hide();
            }
            wv(0);
            wt(0);
            if (this.gWx != null && this.gWx.Gy() != null) {
                this.gWx.Gy().setVisibility(0);
            }
        }
        if (this.hlM != null) {
            this.hlM.P(false, z);
        }
        if (this.gWv != null) {
            this.gWv.Cc();
        }
        if (this.hmv != null) {
            this.hmv.onKeyboardVisibilityChanged(z);
        }
        if (this.gWZ != null) {
            this.gWZ.onKeyboardVisibilityChanged(z);
        }
        bYs();
        this.mHandler.post(this.hmW);
    }

    private void wt(int i) {
        if (this.gVq != null) {
            this.gVq.wh(i);
        }
        if (this.hma != null) {
            this.hma.setVisibility(i);
        }
        if (this.gWg != null) {
            this.gWg.getView().setVisibility(i);
        }
        if (this.hlP != null) {
            this.hlP.setVisible(i);
        }
        if (this.hlO != null) {
            this.hlO.setVisibility(i);
        }
        if (this.gVv != null) {
            this.gVv.setVisible(i);
        }
        if (this.gWV != null) {
            this.gWV.setCanVisible(i == 0);
        }
        if (this.gWR != null) {
            this.gWR.setVisible(i);
        }
        if (this.gWO != null) {
            this.gWO.setCanVisible(i == 0);
        }
        if (this.gWP != null) {
            this.gWP.setCanVisible(i == 0 && !this.gYc);
        }
        if (this.gVC != null) {
            this.gVC.cx(i == 0);
        }
        if (this.hmP != null) {
            this.hmP.setCanVisible(i == 0);
            this.hmP.refreshUI();
        }
        if (this.hmb != null) {
            this.hmb.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bYO().hgH.errCode = 1;
            wu(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            wu(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            wu(a.h.stream_upload_exception);
        } else if (i == -2) {
            HJ(bYO().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            bYO().hgB.stopRecord();
        } else if (i == -3 && this.hlM != null) {
            this.hlM.nf(false);
        }
        if (i == -4) {
            if (this.hlM == null || this.hlM.getView().getParent() == null) {
                bYO().g((short) 1);
                return;
            }
            this.hlM.caE();
            this.hmm.setVisibility(0);
            if (this.hlQ != null) {
                this.hlQ.nS(true);
            }
            bYO().hgl.setBackgroundColor(bYO().pageContext.getResources().getColor(17170445));
            cet();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        avk();
        if (i == 12001) {
            if (i2 == -1) {
                HK(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            bsj();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hlM == null || this.hlM.getView().getParent() == null || this.hlM.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hlM != null) {
            this.hlM.onResume();
        }
        if (this.hmy && this.hmx != null) {
            this.hmy = false;
            c(this.hmx);
        }
        if (this.gWH != null) {
            this.gWH.onResume();
        }
    }

    public void h(short s) {
        if (this.gWt != null) {
            this.gWt.GK();
        }
        if (this.gWu != null) {
            this.gWu.a(null);
            this.gWu.Cd();
        }
        if (this.gWv != null) {
            this.gWv.Cd();
        }
        if (this.hmN != null) {
            this.hmN.bYU();
        }
    }

    public boolean cdN() {
        w Gz = bYO().hgk.Gz();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gZr.hgJ.j(Gz);
            if (Gz != null && Gz.mLiveInfo.live_status != 1) {
                cer();
                bYO().pageContext.getPageActivity().finish();
                if (bYO().hgk != null && bYO().hgk.Gz() != null) {
                    a(Gz, 1, bYO().hgk.cfO() != 1 ? bYO().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gWu != null) {
                this.gWu.La().b(String.valueOf(Gz.mLiveInfo.group_id), String.valueOf(Gz.mLiveInfo.live_id), true, String.valueOf(Gz.aHk.userId));
            }
            if (this.gWv != null) {
                this.gWv.a(Gz);
            }
            if (this.gWg != null) {
                this.gWg.a(bYO().hgk.Gz());
            }
            if (this.gVq != null) {
                this.gVq.H(Gz);
            }
            if (Gz != null) {
                if (this.hmN != null) {
                    this.hmN.a(Gz);
                }
                if (this.gWx != null && Gz.mLiveInfo != null) {
                    this.gWx.a(Gz.mLiveInfo, Gz.aHk);
                }
                if (this.gWV != null) {
                    this.gXl = this.gWV.o(Gz);
                }
                if (this.gVv != null) {
                    this.gVv.mI(this.gXl);
                    this.gVv.i(Gz);
                    this.gVv.updateView();
                }
                if (this.gWO != null) {
                    this.gWO.a(Gz);
                }
                if (this.gWP != null) {
                    this.gWP.a(Gz);
                }
                if (this.gWQ != null) {
                    this.gWQ.a(Gz);
                }
                if (this.gWR != null) {
                    this.gWR.a(Gz);
                }
                if (Gz.mLiveInfo.live_status != 1) {
                    cer();
                    bYO().pageContext.getPageActivity().finish();
                    if (bYO().hgk != null && bYO().hgk.Gz() != null) {
                        a(Gz, 1, bYO().hgk.cfO() != 1 ? bYO().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.hlV != null) {
                    this.hlV.h(Gz);
                }
            }
        }
        return false;
    }

    public void cdO() {
        cdB();
    }

    public void cdP() {
        if (this.hmM != null) {
            this.hmM.cay();
        }
    }

    public void cdQ() {
        if (this.hlM != null && this.hlM.getVisibility() != 8) {
            if (bYO().caK() == 2) {
                cet();
            } else {
                ces();
            }
        }
        if (this.hlM != null && this.hlM.getVisibility() != 8) {
            if (bYO().caK() == 1) {
                this.hlM.onResume();
            }
            this.hlM.onRefresh();
        }
        if (this.hlV != null) {
            this.hlV.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.gXg && this.hmr != null) {
            if (this.gWu != null) {
                this.gWu.La().getView().setVisibility(0);
            }
            if (this.gWu != null) {
                this.gWu.Lb().show();
                this.gWu.Lb().setEditText(" @" + this.hmr.getNameShow() + " ");
            }
            wv(8);
            this.gXg = false;
        }
        if (this.hmQ != null) {
            this.hmQ.resume();
        }
        if (this.hmR != null) {
            this.hmR.resume();
        }
        if (this.gKF != null) {
            this.gKF.resume();
        }
    }

    public void onPause() {
        if (this.hlV != null) {
            this.hlV.onPause();
        }
        if (this.hmQ != null) {
            this.hmQ.pause();
        }
        if (this.gWH != null) {
            this.gWH.onPause();
        }
        if (this.hmR != null) {
            this.hmR.pause();
        }
        if (this.gKF != null) {
            this.gKF.pause();
        }
    }

    private void cdR() {
        if (bl.c(com.baidu.live.aa.a.Ph().bsh)) {
            this.hmm.setVisibility(0);
            this.hmm.setAlpha(0.2f);
        } else if (bYO().hgB.hasBeauty() < 0) {
            this.hmm.setVisibility(8);
        } else {
            this.hmm.setVisibility(0);
        }
    }

    private void cdS() {
        this.hlZ = (RelativeLayout) bYO().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hmc = (RelativeLayout) bYO().rootView.findViewById(a.f.under_live_view_panel);
        this.hmd = (RelativeLayout) bYO().rootView.findViewById(a.f.over_live_view_panel);
        this.hme = (FrameLayout) bYO().rootView.findViewById(a.f.goods_parent);
        this.hmf = (FrameLayout) bYO().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.gZr.hgl.setOnLiveViewScrollListener(this.hnj);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hmc.setVisibility(8);
            this.hmd.setVisibility(8);
            bYO().hgl.removeAllViews();
            return;
        }
        this.hma = (RelativeLayout) bYO().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hma.getLayoutParams();
        layoutParams.topMargin = this.gZr.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hma.setLayoutParams(layoutParams);
        this.hmb = (RelativeLayout) bYO().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.gVt == null) {
            this.gVt = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gZr.pageContext.getPageActivity(), false);
        }
        this.gVt.a(this.gVX);
        this.gVt.a(this.hma, a.f.ala_live_room_host_header_stub, 1L);
        this.gVt.setVisible(0);
        cdT();
        this.hmm = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hmq = (TextView) bYO().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hmm.setOnClickListener(this.hnb);
        this.hmo = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hmo.setOnClickListener(this.hnb);
        if (com.baidu.live.aa.a.Ph().bsh != null && com.baidu.live.aa.a.Ph().bsh.aNK != null && com.baidu.live.aa.a.Ph().bsh.aNK.Eg() && bl.b(com.baidu.live.aa.a.Ph().bsh)) {
            this.hmo.setVisibility(0);
        } else {
            this.hmo.setVisibility(8);
        }
        cdR();
        this.hml = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hml.setOnClickListener(this.hnb);
        this.hmj = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hmj.setOnClickListener(this.hnb);
        this.gZy = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.gZy.setOnClickListener(this.hnb);
        this.hmp = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hmp.setOnClickListener(this.hnb);
        this.hmk = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hmk.setOnClickListener(this.hnb);
        this.hmn = (ImageView) bYO().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hmn.setOnClickListener(this.hnb);
        cdW();
        if (bl.b(com.baidu.live.aa.a.Ph().bsh)) {
            this.hmM = new com.baidu.tieba.ala.liveroom.h.b(bYO().hgE, bYO(), bYO().hgB);
        }
        this.gWt = new m();
        cdU();
        cdV();
        if (com.baidu.live.d.Aq().getInt("beauty_new_bubble", 1) == 1) {
            this.hmq.setVisibility(0);
        }
    }

    private void cdT() {
        this.hmU = (FrameLayout) View.inflate(bYO().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hmU != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hmU.setVisibility(8);
            if (this.hmU.getParent() != null && (this.hmU.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hmU.getParent()).removeView(this.hmU);
            }
            this.hlZ.addView(this.hmU, layoutParams);
            if (this.hmU != null) {
                this.hmU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.gVX.s(AlaMasterLiveRoomOpearator.this.hmU, 8);
                    }
                });
            }
        }
    }

    private void cdU() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bYO().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gWu = (k) runTask.getData();
            this.gWu.setFromMaster(true);
            this.gWu.La().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bYO().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ag.b.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ag.b.cW(true);
            bYO().hgl.addView(this.gWu.La().getView(), layoutParams);
            this.gWu.Lb().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bYO().hgl.addView(this.gWu.Lb().getView(), layoutParams2);
            this.gWu.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // com.baidu.live.im.k.a
                public boolean Ld() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Le() {
                }

                @Override // com.baidu.live.im.k.a
                public void hD(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Lf() {
                }

                @Override // com.baidu.live.im.k.a
                public void Lg() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lh() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int Li() {
                    return 0;
                }
            });
        }
    }

    private void cdV() {
        View Cb;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bYO().pageContext);
        if (runTask != null) {
            this.gWv = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gWv != null && (Cb = this.gWv.Cb()) != null && this.gZr.hgl.indexOfChild(Cb) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gZr.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bYO().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            bYO().hgl.addView(Cb, layoutParams);
        }
    }

    private void cdW() {
        CustomResponsedMessage runTask;
        if (this.hmt == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ad.a.class, bYO().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hmt = (com.baidu.live.ad.a) runTask.getData();
        }
    }

    private void cdX() {
        View FX;
        aa.d(bYO().hgk.Gz());
        aa.b(bYO().pageContext, true);
        aa.GG();
        if (this.gWw == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSp = true;
            fVar.context = bYO().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ab.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWw = (ab) runTask.getData();
                if (this.gWw != null && (FX = this.gWw.FX()) != null && bYO().hgl.indexOfChild(FX) < 0) {
                    if (FX.getParent() instanceof ViewGroup) {
                        ((ViewGroup) FX.getParent()).removeView(FX);
                    }
                    bYO().hgl.addView(FX, bYO().hgl.getLayoutParams());
                }
            }
        }
    }

    private void cdY() {
        if (!this.hmV) {
            this.hmV = true;
            com.baidu.live.entereffect.a.Ex().requestData(true);
        }
    }

    protected void bXG() {
        View Gy;
        if (this.gWx == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSp = true;
            aVar.context = bYO().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, z.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWx = (z) runTask.getData();
            }
        }
        if (this.gWx != null && (Gy = this.gWx.Gy()) != null && this.hmb != null) {
            if (this.hmb.indexOfChild(Gy) < 0) {
                if (Gy.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Gy.getParent()).removeView(Gy);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hlP != null && this.hlP.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.gWR != null && this.gWR.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.gWQ != null && this.gWQ.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hmb.addView(Gy, layoutParams);
            }
            Gy.bringToFront();
        }
    }

    protected void bXF() {
        View GL;
        if (this.gWH == null) {
            ai aiVar = new ai();
            aiVar.aSp = true;
            aiVar.pageContext = bYO().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ae.class, aiVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWH = (ae) runTask.getData();
            }
        }
        if (this.gWH != null && (GL = this.gWH.GL()) != null && bYO().hgl.indexOfChild(GL) < 0) {
            if (GL.getParent() instanceof ViewGroup) {
                ((ViewGroup) GL.getParent()).removeView(GL);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            bYO().hgl.addView(GL, layoutParams);
        }
    }

    private void cdZ() {
        ced();
        bXK();
        cec();
        bYO().hgl.setVisibility(0);
        wv(0);
    }

    private void cea() {
        if (this.hlP == null) {
            this.hlP = new com.baidu.tieba.ala.liveroom.v.a(bYO().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hlP.a(bYO().caK(), j, TbadkCoreApplication.getCurrentAccountName(), true, bYO().hgk.Gz().aHk.portrait, this.otherParams, "", -1L);
        this.hlP.at(this.hmb);
    }

    private void ceb() {
        if (this.hmv == null) {
            bYO().hgl.hvO = false;
            com.baidu.live.ab.a fc = fc(bYO().pageContext.getPageActivity());
            if (fc != null) {
                this.hmv = fc;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.ab.a.class, bYO().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hmv = (com.baidu.live.ab.a) runTask.getData();
                }
            }
            if (this.hmv != null) {
                this.hmv.q(this.hmc);
                this.hmv.r(this.hmd);
                this.hmv.fa((bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - bYO().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hmv.s(bYO().hgl);
                this.hmv.a(this.gUV);
                this.hmv.setLiveShowInfo(bYO().hgk.Gz());
                this.hmv.a(this.gVv);
                this.hmv.PB();
                this.hmv.a(new a.InterfaceC0166a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                    @Override // com.baidu.live.ab.a.InterfaceC0166a
                    public void PC() {
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0166a
                    public void PD() {
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0166a
                    public void J(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bYO().hgB != null) {
                            AlaMasterLiveRoomOpearator.this.bYO().hgB.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0166a
                    public int PE() {
                        return AlaMasterLiveRoomOpearator.this.hma.getBottom();
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0166a
                    public int PF() {
                        return AlaMasterLiveRoomOpearator.this.gZr.hgl.getHeight() - (AlaMasterLiveRoomOpearator.this.gWu.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gWu.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0166a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gWu.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0166a
                    public int PG() {
                        return AlaMasterLiveRoomOpearator.this.gWu.Lc();
                    }
                });
            }
        }
    }

    private com.baidu.live.ab.a fc(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aw(context);
        }
        return null;
    }

    private void cec() {
        if (this.hlR == null) {
            this.hlR = new b(bYO().pageContext, bYO().hgl);
        }
    }

    private void ced() {
        if (this.gVq == null) {
            this.gVq = new com.baidu.tieba.ala.liveroom.p.a(bYO().pageContext, true, this.hnf);
            this.gVq.d(this.hma, null);
            this.gVq.a(this.gVX);
            this.gVq.nt(false);
        }
        if (this.hlN == null) {
            this.hlN = new com.baidu.tieba.ala.liveroom.p.a(bYO().pageContext, true, null);
            this.hlN.a(this.hma, null, a.f.ala_live_room_host_header_stub);
            this.hlN.ccv();
        }
    }

    protected void bXn() {
        CustomResponsedMessage runTask;
        boolean z = false;
        ap cfF = bYO().hgk.cfF();
        boolean z2 = com.baidu.live.aa.a.Ph().bms.aLx;
        if (cfF == null || cfF.aHU) {
            z = z2;
        }
        if (z && this.gWg == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bYO().pageContext)) != null) {
            this.gWg = (com.baidu.live.h.a) runTask.getData();
            if (this.gWg != null) {
                this.gWg.setIsHost(true);
                this.gWg.eB(1);
                View view = this.gWg.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bYO().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bYO().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hma.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(w wVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gVv == null) {
            this.gVv = new com.baidu.tieba.ala.liveroom.activeview.b(bYO().pageContext);
        }
        this.gVv.setOtherParams(this.otherParams);
        this.gVv.b(wVar, false);
        this.gVv.setHost(true);
        this.gVv.a(1, this.bpO);
        this.gVv.a(2, this.bpO);
        this.gVv.mI(this.gXl);
        this.gVv.setVisible(this.hlL ? 8 : 0);
        this.gVv.a(this.gUV);
        if (this.gUV != null) {
            if (this.gVv != null) {
                alaActiveRootView2 = this.gVv.vN(1);
                alaActiveRootView = this.gVv.vN(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.gUV.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.gUV.a(alaActiveRootView);
            }
        }
    }

    private void I(w wVar) {
        CustomResponsedMessage runTask;
        if (this.gWV == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bYO().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.w.a)) {
            this.gWV = (com.baidu.live.w.a) runTask.getData();
            if (this.gWV != null) {
                this.gWV.p(this.bpO);
            }
        }
        if (this.gWV != null) {
            this.gXl = this.gWV.o(wVar);
            this.gWV.setCanVisible(!this.hlL);
        }
    }

    protected void cee() {
        CustomResponsedMessage runTask;
        if (bYO() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.j.a.class, bYO().pageContext.getPageActivity())) != null && runTask.getData() != null && this.gWO == null) {
            this.gWO = (com.baidu.live.j.a) runTask.getData();
            this.gWO.b(this.hmb, bXW());
            if (bYO().hgk != null) {
                this.gWO.a(bYO().hgk.Gz());
            }
            this.gWO.setCanVisible(true);
            this.gWO.bU(false);
            this.gWO.a(bYO().hgk.bQJ());
        }
    }

    protected void bXJ() {
        CustomResponsedMessage runTask;
        if (bYO() != null && this.gWP == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.r.a.class, bYO().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gWP = (com.baidu.live.r.a) runTask.getData();
            this.gWP.setIsHost(true);
            this.gWP.b(this.bpO, bYO().hgk.Gz());
        }
    }

    protected void bWC() {
        if (bYO() != null) {
            if (this.gVC == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.z.a.class, bYO().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gVC = (com.baidu.live.z.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gVC.setIsHost(true);
            this.gVC.a(this.bpO, bYO().hgk.Gz().aIi);
        }
    }

    protected void bXL() {
        CustomResponsedMessage runTask;
        if (bYO() != null && this.gWQ == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.i.a.class, bYO().pageContext)) != null && runTask.getData() != null) {
            this.gWQ = (com.baidu.live.i.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.gWQ.a(this.hmb, bYO().hgk.Gz(), layoutParams, this.otherParams);
        }
    }

    private void J(w wVar) {
        CustomResponsedMessage runTask;
        if (bYO() != null) {
            if (this.hlT == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.r.d.class)) != null) {
                this.hlT = (com.baidu.live.r.d) runTask.getData();
            }
            if (this.hlT != null) {
                this.hlT.Of();
            }
            if (this.hlU == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, com.baidu.live.r.c.class);
                if (runTask2 != null) {
                    this.hlU = (com.baidu.live.r.c) runTask2.getData();
                }
                if (this.hlU != null) {
                    this.hlU.setParentView(this.gZr.hgl);
                    if (wVar != null && wVar.aHk != null) {
                        this.hlU.aF(wVar.aHk.userId);
                    }
                }
            }
        }
    }

    private void bXx() {
        if (this.hmR == null) {
            this.hmR = new com.baidu.tieba.ala.liveroom.r.c(bYO().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams bXW() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bYO().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.gWR != null && this.gWR.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hlP != null && this.hlP.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void bXK() {
        if (this.hlO == null) {
            this.hlO = new com.baidu.tieba.ala.liveroom.b.a(bYO().pageContext, true);
        }
    }

    private void cef() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bYO().pageContext.getPageActivity();
            if (this.hmw == null) {
                this.hmw = new ImageView(pageActivity);
                this.hmw.setId(a.f.master_close_btn);
                this.hmw.setTag("master_close_btn");
                this.hmw.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hmw.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hmw.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hmw.getParent() != null) {
                ((ViewGroup) this.hmw.getParent()).removeView(this.hmw);
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bYO().hgE.addView(this.hmw, layoutParams);
            this.hmw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.cep();
                }
            });
            this.hmw.setVisibility(8);
        }
    }

    protected void bXM() {
        if (this.gWR == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.r.b.class, bYO().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gWR = (com.baidu.live.r.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bYO().hgk.Gz() != null && bYO().hgk.Gz().aHk != null && bYO().hgk.Gz().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(bYO().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(bYO().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.gWR.b(this.hmb, layoutParams, bYO().hgk.Gz());
        }
    }

    private void ceg() {
        CustomResponsedMessage runTask;
        if (this.hmP == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.a.a.class, bYO().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.a)) {
            this.hmP = (com.baidu.live.a.a) runTask.getData();
            if (this.hmP != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = bYO().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hmP.b(this.hmb, layoutParams);
            }
        }
        if (this.hmP != null) {
            this.hmP.a(bYO().hgk.Gz());
        }
    }

    private void ceh() {
        CustomResponsedMessage runTask;
        if (this.hmQ == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.a.b.class, bYO().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.b)) {
            this.hmQ = (com.baidu.live.a.b) runTask.getData();
        }
    }

    private void bXy() {
        if (this.gKF == null) {
            this.gKF = new com.baidu.live.ak.a(bYO().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.hmN != null) {
            this.hmN.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bYO().pageContext.registerListener(this.gXD);
        bYO().pageContext.registerListener(this.hmX);
        bYO().pageContext.registerListener(this.gXE);
        bYO().pageContext.registerListener(this.gXF);
        bYO().pageContext.registerListener(this.hnc);
        bYO().pageContext.registerListener(this.bFQ);
        bYO().pageContext.registerListener(this.gUa);
        bYO().pageContext.registerListener(this.hnd);
        bYO().pageContext.registerListener(this.guI);
        bYO().pageContext.registerListener(this.gVS);
        bYO().pageContext.registerListener(this.gXJ);
        bYO().pageContext.registerListener(this.bvJ);
        bYO().pageContext.registerListener(this.bvK);
        bYO().pageContext.registerListener(this.hmY);
        bYO().pageContext.registerListener(this.blZ);
        bYO().pageContext.registerListener(this.bma);
        bYO().pageContext.registerListener(this.hmZ);
        bYO().pageContext.registerListener(this.gXM);
        bYO().pageContext.registerListener(this.gXL);
        bYO().pageContext.registerListener(this.gXN);
        bYO().pageContext.registerListener(this.hna);
        bYO().pageContext.registerListener(this.hmZ);
        bYO().pageContext.registerListener(this.blf);
        bYO().pageContext.registerListener(this.bhz);
        bYO().pageContext.registerListener(this.gKG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ny(boolean z) {
        if (bl.c(com.baidu.live.aa.a.Ph().bsh)) {
            bYO().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (bYO().hgG.BP() == null || ListUtils.isEmpty(bYO().hgG.BP().aCn)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bYO().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bvH) {
                this.bvG = BdUniqueId.gen();
                bYO().hgG.a(this.bvG);
                this.bvH = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bYO().pageContext.getPageActivity(), bYO().rootView);
            wv(8);
            if (bYO().hgB.hasAdvancedBeauty() && this.hmM != null) {
                if (!this.hmS || this.hlM.getVisibility() == 0) {
                    this.hmM.a(bYO().hgB.getVideoConfig());
                }
                this.hmM.a(bYO().hgB.getVideoConfig(), this.bvI);
                if (!this.bvI) {
                    this.bvI = true;
                }
            }
            if (z && this.gWu != null) {
                this.gWu.La().getView().setVisibility(4);
            }
        }
    }

    private String currentAppType(Activity activity) {
        if (activity != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_hk_text);
            }
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_qm_text);
            }
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_bd_text);
            }
            if (TbadkCoreApplication.getInst().isYinbo()) {
                return activity.getResources().getString(a.h.sdk_permission_app_type_yb_text);
            }
            if (TbadkCoreApplication.getInst().isOther() && !TextUtils.isEmpty(TbConfig.getSubappName())) {
                return TbConfig.getSubappName();
            }
            return activity.getResources().getString(a.h.sdk_permission_app_type_tb_text);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bYO().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bYO().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bYO().g((short) 1);
            }
        });
        bdAlertDialog.create(bYO().pageContext).show();
    }

    private void HJ(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bYO().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bYO().g((short) 1);
            }
        });
        bdAlertDialog.create(bYO().pageContext).show();
    }

    public void cei() {
        bXn();
        q bQJ = bYO().hgk.bQJ();
        int i = 5;
        if (bQJ != null) {
            i = (int) bQJ.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz() != null && AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bYO().hgk.h(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bQJ != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gZr.hgJ.b(bQJ);
                return;
            }
            if (this.gVp == null) {
                this.gVp = new c(bYO().pageContext, this.hnf, true);
            }
            if (this.hmK) {
                this.hmK = false;
                this.gVp.a(String.valueOf(bYO().hgk.Gz().mLiveInfo.group_id), String.valueOf(bYO().hgk.Gz().mLiveInfo.live_id), String.valueOf(bYO().hgk.Gz().aHk.userId), bYO().hgk.Gz());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.gWg != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.gVp.c(this.hma, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.gVp.e(bQJ);
            this.gVt.setVisible(0);
            this.gVt.ew(bQJ.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cej() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        if (bYO().hgk != null) {
            if (this.gWh == null) {
                this.gWh = new com.baidu.tieba.ala.liveroom.share.c(bYO().pageContext);
            }
            this.gWh.c(bYO().hgk.Gz(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bYO().hgk != null && bYO().hgk.Gz() != null && bYO().hgk.Gz().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bYO().hgk.Gz().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bYO().hgk.Gz().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bYO().hgk.Gz().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bYO().hgk != null && bYO().hgk.Gz() != null && bYO().hgk.Gz().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bYO().hgk.Gz().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bYO().hgk.Gz().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bYO().hgk.Gz().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean cek() {
        return this.hlK;
    }

    private void nz(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hlJ, z);
        this.hlK = z;
    }

    private void cel() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bYO().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.q.b(AlaMasterLiveRoomOpearator.this.bYO().pageContext).cfn();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bYO().pageContext).show();
    }

    private void cem() {
        if (this.hlt && bYO().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bYO().hgI.SH();
        }
        bYO().hgH.prepareTime = System.currentTimeMillis() - bYO().hgH.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bYO().hgk != null && bYO().hgk.Gz() != null && bYO().hgk.Gz().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bYO().hgk.Gz().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bYO().hgk.Gz().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bYO().hgH.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hlM != null && this.hlM.getView().getParent() != null) {
            this.hlM.setVisibility(8);
            bYO().hgE.removeView(this.hlM.getView());
            this.hlM.release();
        }
        if (this.hmM != null) {
            this.hmM.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bYO().hgl.indexOfChild(this.hlX) < 0) {
            bYO().hgl.addView(this.hlX, layoutParams);
        }
        this.hlX.wL(1000);
    }

    private void avk() {
        if (bYO().caK() == 1) {
            bYO().hgB.startRecord();
        }
    }

    private void HK(String str) {
        HL(str);
    }

    private void HL(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bYO().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hlM != null) {
            this.hlM.Hy(fromJson.getSmallurl());
        }
    }

    private boolean cen() {
        return com.baidu.live.d.Aq().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceo() {
        com.baidu.live.d.Aq().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.gZr.hgB.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cep() {
        if (this.hmO == null || !this.hmO.PW()) {
            if (this.hlW == null || !this.hlW.PW()) {
                int i = a.h.live_close_confirm;
                if (this.hmN != null && this.hmN.bYW()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hmN != null && this.hmN.bYV()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(bYO().pageContext.getPageActivity());
                bdAlertDialog.setAutoNight(false);
                bdAlertDialog.setTitle((String) null);
                bdAlertDialog.setMessageId(i);
                bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                        }
                        bdAlertDialog2.dismiss();
                        if (AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz(), 0, AlaMasterLiveRoomOpearator.this.bYO().hgk.cfO() != 1 ? AlaMasterLiveRoomOpearator.this.bYO().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                        } else {
                            AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                        }
                    }
                });
                bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.create(bYO().pageContext).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (wVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = wVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = wVar.aHk;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bYO().hgk.ey(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.hmI) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bYO().hgH;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bYO().hgB.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hmE;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hmF;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hmA;
            if (this.hmB != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hmC - this.hmD) / this.hmB) * 100.0f;
            }
            Intent intent = new Intent(bYO().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bYO().hgk != null && bYO().hgk.Gz() != null && bYO().hgk.Gz().aHk != null) {
                String str3 = bYO().hgk.Gz().aHk.nickName;
                String str4 = bYO().hgk.Gz().aHk.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            w Gz = bYO().hgk.Gz();
            if (Gz != null && Gz.aHk != null && !TextUtils.isEmpty(Gz.aHk.portrait)) {
                intent.putExtra("host_portrait", Gz.aHk.portrait);
            }
            if (this.hmO != null) {
                this.hmO.Uf();
            }
            if (this.hlW != null) {
                this.hlW.PU();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hmG = intent;
                this.hmH = s;
                bYO().pageContext.showToast(a.h.ala_live_background_close_tip);
            } else {
                a(intent, s);
            }
            if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
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
    public void ceq() {
        if (this.hmG != null) {
            a(this.hmG, this.hmH);
            this.hmG = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hmI = true;
        if (this.hmN != null) {
            this.hmN.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.gTP);
            bYO().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bYO().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cer() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gZr.hgJ != null && this.gZr.hgJ.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hmN != null && this.hmN.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hmO != null && this.hmO.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hmM != null && this.hmM.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hlW != null && this.hlW.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bYO().hgF.ceW()) {
                cep();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.hlY != null) {
                this.hlY.setVisibility(4);
                return;
            }
            return;
        }
        if (this.hlY != null) {
            this.hlY.a(i, z, i2, z2);
        }
        if (this.gZr != null && this.gZr.hgk != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dyu != i3) {
                this.dyu = i3;
                if (this.hlS == null) {
                    this.hlS = new com.baidu.tieba.ala.liveroom.tippop.a(this.gZr.pageContext, null);
                }
                switch (this.dyu) {
                    case 0:
                        this.hlS.a(this.gZr.hgE, this.gZr.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hlS.a(this.gZr.hgE, this.gZr.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hlS.a(this.gZr.hgE, this.gZr.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gZr.hgk.v(this.gZr.hgk.Gz().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void H(com.baidu.live.im.data.a aVar) {
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
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cer();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x06bd, code lost:
        Ho(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0042 A[Catch: JSONException -> 0x07cf, TRY_LEAVE, TryCatch #8 {JSONException -> 0x07cf, blocks: (B:11:0x003a, B:13:0x0042, B:249:0x07c4), top: B:283:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x07c4 A[Catch: JSONException -> 0x07cf, TRY_ENTER, TRY_LEAVE, TryCatch #8 {JSONException -> 0x07cf, blocks: (B:11:0x003a, B:13:0x0042, B:249:0x07c4), top: B:283:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.a aVar) {
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
        boolean z;
        JSONObject jSONObject6;
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 msgType " + aVar.getMsgType());
        }
        if (aVar.getMsgType() == 125) {
            if (this.hlQ != null) {
                this.hlQ.J(aVar);
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
                        if (TbConfig.IM_LOG) {
                            Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 contentType: " + optString);
                        }
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
                            if (this.hmN != null) {
                            }
                            if (!"close_live".equals(str2)) {
                            }
                            if (!(aVar.getObjContent() instanceof JSONObject)) {
                            }
                            try {
                                jSONObject6.put("log_id", aVar.getMsgId());
                            } catch (JSONException e2) {
                            }
                            if (this.gWQ != null) {
                            }
                            if (this.gWP != null) {
                            }
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
            if (this.hmN != null) {
                this.hmN.gb(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cer();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bYO().hgk.Gz(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bYO().hgk.Gz() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bYO().hgk.Gz().aHG.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bYO().hgk.Gz().aHG.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bYO().hgk.Gz().aHG.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bYO().hgk.Gz() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bYO().hgk.Gz() != null && bYO().hgk.Gz().aHk != null && bYO().hgk.Gz().aHk.userId == optLong2) {
                        bYO().hgk.Gz().aHk.isUegBlock = 1;
                        bWS();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bYO().hgk.Gz() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bYO().hgk.Gz() != null && bYO().hgk.Gz().aHk != null && bYO().hgk.Gz().aHk.userId == optLong3) {
                        bYO().hgk.Gz().aHk.isUegBlock = 0;
                        bWS();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hmt != null) {
                    this.hmt.P(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.hlR.aI(optString4, optInt2);
                    }
                    if (this.gVt.getCount() > 20) {
                        this.gVt.ew(this.gVt.getCount() + 1);
                    } else if (this.gVp != null) {
                        com.baidu.live.data.a LF = aVar.LF();
                        com.baidu.live.data.p pVar = new com.baidu.live.data.p();
                        pVar.aHl = new AlaLocationData();
                        pVar.aHm = new AlaRelationData();
                        pVar.aHk = new AlaLiveUserInfoData();
                        pVar.aHk.userId = JavaTypesHelper.toLong(LF.userId, 0L);
                        pVar.aHk.userName = LF.userName;
                        pVar.aHk.portrait = LF.portrait;
                        if (this.gVp.c(pVar)) {
                            this.gVt.ew(this.gVt.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bYO() != null && bYO().hgk != null && bYO().hgk.Gz() != null && bYO().hgk.Gz().aHG != null && bYO().hgk.Gz().aHG.userId == jSONObject2.optLong("user_id")) {
                    bYO().hgk.cfE();
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
                    com.baidu.live.data.a LF2 = aVar.LF();
                    if (LF2 != null && aa.ha(str6)) {
                        aa.d(str6, 1L, "", "", LF2.userId, LF2.portrait, LF2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject2 != null) {
                    ba baVar = new ba();
                    baVar.parseJson(jSONObject2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, baVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString5 = jSONObject2.optString("challenge_im_type");
                    if (TextUtils.equals(optString5, "start")) {
                        HM(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bYO().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(bYO().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
            } else if ("connect_apply_show_pub".equals(str2) && this.hlW != null) {
                this.hlW.O(jSONObject2);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a LF3 = aVar.LF();
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
                String optString11 = jSONObject5.optString("is_pk_gift", "0");
                long optLong5 = jSONObject5.optLong("charm_total");
                String optString12 = jSONObject5.optString("attach");
                String optString13 = jSONObject5.optString("attach_new");
                String optString14 = jSONObject5.optString("gift_mul");
                boolean z2 = jSONObject5.optInt("is_dynamic_gift") == 1;
                boolean z3 = jSONObject5.optInt("from_gongyanfang_2") == 1;
                boolean z4 = jSONObject5.optInt("from_gongyanfang_page") == 1;
                String str7 = null;
                if (bYO().hgk == null || bYO().hgk.Gz() == null || bYO().hgk.Gz().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    str3 = "";
                    str4 = "";
                    z = false;
                } else {
                    long j4 = bYO().hgk.Gz().mLiveInfo.live_id;
                    long j5 = bYO().hgk.Gz().mLiveInfo.group_id;
                    long j6 = bYO().hgk.Gz().aHk.userId;
                    str7 = bYO().hgk.Gz().mLiveInfo.appId;
                    boolean z5 = bYO().hgk.Gz().mLiveInfo.isPubShow;
                    if (bYO().hgk.Gz().mLiveSdkInfo.mCastIds == null) {
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = "";
                        str4 = "";
                        z = z5;
                    } else {
                        String str8 = bYO().hgk.Gz().mLiveSdkInfo.mCastIds.chatMCastId;
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = bYO().hgk.Gz().mLiveSdkInfo.mCastIds.ensureMCastId;
                        str4 = str8;
                        z = z5;
                    }
                }
                if (!z3 || z2) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString7, "");
                    if (!this.isBackground || bYO().caK() != 2) {
                        if (!TextUtils.isEmpty(optString13) && !TextUtils.isEmpty(optString14)) {
                            if (jSONObject5.optInt("flag_show") == 1) {
                                aa.b(optString14, LF3.userId, LF3.portrait, LF3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString13, "", "", aVar.getMsgId());
                                try {
                                    JSONArray jSONArray = new JSONArray(optString14);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i >= jSONArray.length()) {
                                                break;
                                            }
                                            if (com.baidu.live.aa.f.Px().hT(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                            aVar.setHost(z && z4);
                            aa.a(optString7, Integer.parseInt(optString8), optString9, optString10, LF3.userId, LF3.portrait, LF3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString12, str4, str3, (z4 || z3) ? false : true, aVar.getMsgId(), z2, jSONObject5, optString11);
                        }
                    }
                    Ho(optString7);
                    if (!jSONObject5.optString("content_type").equals("tying_gift")) {
                        com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar.hfR = optLong5;
                        cVar.liveId = j3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                    }
                    JSONObject jSONObject7 = new JSONObject();
                    try {
                        jSONObject7.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                        jSONObject7.putOpt("gift_name", optString9);
                        jSONObject7.putOpt("order_id", optString6);
                        com.baidu.live.gift.g gW = aa.gW(optString7);
                        if (gW != null) {
                            jSONObject7.putOpt(LogConfig.LOG_GIFT_VALUE, gW.getPrice());
                        }
                        jSONObject7.putOpt("gift_num", optString8);
                    } catch (JSONException e7) {
                        e7.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "giftsend_succ").setContentExt(null, "popup", jSONObject7));
                } else {
                    return;
                }
            } catch (JSONException e8) {
            }
        }
        try {
            if (!(aVar.getObjContent() instanceof JSONObject)) {
                jSONObject6 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject6 = new JSONObject(aVar.getContent());
            }
            jSONObject6.put("log_id", aVar.getMsgId());
        } catch (JSONException e9) {
            jSONObject6 = null;
        }
        if (this.gWQ != null) {
            this.gWQ.l(aVar);
        }
        if ((this.gWP != null || !this.gWP.L(jSONObject6)) && this.gVC != null && this.gVC.L(jSONObject6)) {
        }
    }

    private void Ho(String str) {
        if (this.gVv != null) {
            this.gVv.Ho(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wv(int i) {
        View findViewById = bYO().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gVv != null) {
            this.gVv.bM(2, i);
        }
    }

    private void ces() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bYO().hgB != null && AlaMasterLiveRoomOpearator.this.bYO().hgB.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bYO().hgB.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bYO().hgB.startRecord();
                }
            }
        });
    }

    private void cet() {
        if (bYO().hgB != null && bYO().hgB.getPreview() != null) {
            bYO().hgB.getPreview().setVisibility(8);
            bYO().hgB.stopRecord();
        }
    }

    public void ceu() {
        this.hgy = bYO().hgk.cfP();
        if (this.hlM != null) {
            this.hlM.ng(this.hgy);
        }
    }

    public void caI() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cev();
        } else if (this.hlM != null) {
            this.hlM.caI();
        }
    }

    public void nh(boolean z) {
        if (this.hlM != null) {
            this.hlM.nh(z);
        }
    }

    public void onDestroy() {
        if (this.hmz != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hmz);
        }
        this.hmz = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hms.removeCallbacksAndMessages(null);
        if (this.hmM != null) {
            this.hmM.ne(true);
        }
        this.hmM = null;
        if (this.hlM != null) {
            this.hlM.destroy();
            bYO().hgE.removeView(this.hlM.getView());
            this.hlM.release();
            this.hlM = null;
        }
        if (this.hmN != null) {
            this.hmN.onDestroy();
        }
        if (this.gWh != null) {
            this.gWh.onDestroy();
        }
        if (this.gVq != null) {
            this.gVq.onDestroy();
            this.gVq = null;
        }
        if (this.hlN != null) {
            this.hlN.onDestroy();
        }
        if (this.gWH != null) {
            this.gWH.onDestroy();
            this.gWH = null;
        }
        if (this.hlX != null) {
            this.hlX.stopCountDown();
        }
        if (this.hlP != null) {
            this.hlP.onDestroy();
        }
        if (this.hlR != null) {
            this.hlR.onDestroy();
        }
        if (this.hmt != null) {
            this.hmt.onDestroy();
            this.hmt = null;
        }
        if (this.gWw != null) {
            this.gWw.onDestroy();
            this.gWw = null;
        }
        if (this.hlT != null) {
            this.hlT.release();
        }
        com.baidu.live.ac.a.b.PO().release();
        aa.GH();
        com.baidu.live.entereffect.a.Ex().release();
        this.hmV = false;
        if (this.gWx != null) {
            this.gWx.onDestroy();
            this.gWx = null;
        }
        if (this.hlS != null) {
            this.hlS.onDestroy();
        }
        if (this.hlQ != null) {
            this.hlQ.chQ();
            this.hlQ.release();
        }
        if (this.gVt != null) {
            this.gVt = null;
        }
        if (this.gVv != null) {
            this.gVv.release();
        }
        if (this.hlQ != null) {
            this.hlQ.onDestroy();
        }
        if (this.gWv != null) {
            this.gWv.release();
        }
        if (this.hlV != null) {
            this.hlV.release();
        }
        if (this.hmv != null) {
            this.hmv.onDestroy();
        }
        if (this.gWV != null) {
            this.gWV.release();
        }
        if (this.hmP != null) {
            this.hmP.onDestory();
        }
        if (this.hmQ != null) {
            this.hmQ.release();
        }
        if (this.gWO != null) {
            this.gWO.onDestroy();
        }
        if (this.gWP != null) {
            this.gWP.onDestroy();
        }
        if (this.gVC != null) {
            this.gVC.onDestroy();
        }
        if (this.hlU != null) {
            this.hlU.release();
            this.hlU = null;
        }
        if (this.hmR != null) {
            this.hmR.release();
        }
        if (this.gKF != null) {
            this.gKF.release();
        }
        if (this.gWR != null) {
            this.gWR.onDestroy();
        }
        if (this.hmO != null) {
            this.hmO.onDestroy();
        }
        if (this.hlW != null) {
            this.hlW.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gXD);
        MessageManager.getInstance().unRegisterListener(this.hmX);
        MessageManager.getInstance().unRegisterListener(this.gXE);
        MessageManager.getInstance().unRegisterListener(this.gXF);
        MessageManager.getInstance().unRegisterListener(this.hnc);
        MessageManager.getInstance().unRegisterListener(this.bFQ);
        MessageManager.getInstance().unRegisterListener(this.gUa);
        MessageManager.getInstance().unRegisterListener(this.hnd);
        MessageManager.getInstance().unRegisterListener(this.guI);
        MessageManager.getInstance().unRegisterListener(this.gVS);
        MessageManager.getInstance().unRegisterListener(this.gXJ);
        MessageManager.getInstance().unRegisterListener(this.bvJ);
        MessageManager.getInstance().unRegisterListener(this.bvK);
        MessageManager.getInstance().unRegisterListener(this.hmY);
        MessageManager.getInstance().unRegisterListener(this.blZ);
        MessageManager.getInstance().unRegisterListener(this.bma);
        MessageManager.getInstance().unRegisterListener(this.hmZ);
        MessageManager.getInstance().unRegisterListener(this.gXM);
        MessageManager.getInstance().unRegisterListener(this.gXL);
        MessageManager.getInstance().unRegisterListener(this.gXN);
        MessageManager.getInstance().unRegisterListener(this.hna);
        MessageManager.getInstance().unRegisterListener(this.hmZ);
        MessageManager.getInstance().unRegisterListener(this.blf);
        MessageManager.getInstance().unRegisterListener(this.bhz);
        MessageManager.getInstance().unRegisterListener(this.gKG);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gZr.hgJ.a(this.hnm, this.gZr.hgD, this.hlZ, alaLivePersonData);
        }
    }

    private void cev() {
        if (this.hmx != null) {
            this.gZr.hgH.startTime = System.currentTimeMillis();
            this.gZr.hgH.liveTotalTime = System.currentTimeMillis();
            this.gZr.hgH.sampleMemAndCPU();
            this.gZr.hgF.a((short) 4, this.hmx);
        }
    }

    private void HM(String str) {
        String str2;
        int i;
        if (bYO() != null && bYO().pageContext != null) {
            this.hms.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bYO().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hmT == null) {
                    this.hmT = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hmT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.cdu()) {
                                AlaMasterLiveRoomOpearator.this.hms.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hmT != null) {
                                    AlaMasterLiveRoomOpearator.this.bYO().hgl.removeView(AlaMasterLiveRoomOpearator.this.hmT);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                                    AlaMasterLiveRoomOpearator.this.hmN.bYS();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hmT.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hms.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bYO().hgl != null && AlaMasterLiveRoomOpearator.this.gZy != null && AlaMasterLiveRoomOpearator.this.hmT != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hmT.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hmT.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.A((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hmT.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gZy.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gZy.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gZy.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gZy.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hmT.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hmT.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hmT != null) {
                                AlaMasterLiveRoomOpearator.this.bYO().hgl.removeView(AlaMasterLiveRoomOpearator.this.hmT);
                            }
                            AlaMasterLiveRoomOpearator.this.bYO().hgl.addView(AlaMasterLiveRoomOpearator.this.hmT, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.aa.a.Ph().bms != null) {
                    i = com.baidu.live.aa.a.Ph().bms.aKG;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hms.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bYO().hgl != null && AlaMasterLiveRoomOpearator.this.hmT != null) {
                            AlaMasterLiveRoomOpearator.this.bYO().hgl.removeView(AlaMasterLiveRoomOpearator.this.hmT);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
