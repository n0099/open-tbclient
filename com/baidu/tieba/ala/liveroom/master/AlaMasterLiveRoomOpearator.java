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
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.helper.AlaLiveDebugInfo;
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
import com.baidu.live.c.n;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ag;
import com.baidu.live.data.ah;
import com.baidu.live.data.ap;
import com.baidu.live.data.aq;
import com.baidu.live.data.at;
import com.baidu.live.data.au;
import com.baidu.live.data.bc;
import com.baidu.live.data.j;
import com.baidu.live.data.r;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.gift.w;
import com.baidu.live.gift.y;
import com.baidu.live.guardclub.h;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.message.EventPollingHttpResponseMessage;
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
import com.baidu.live.x.a;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.audiencelist.c;
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
/* loaded from: classes7.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String gCx;
    private boolean bdo;
    private PendantParentView bhK;
    private d gCA;
    private com.baidu.tieba.ala.liveroom.o.a gCB;
    private com.baidu.tieba.ala.liveroom.b.a gCC;
    private com.baidu.tieba.ala.liveroom.u.a gCD;
    private com.baidu.tieba.ala.liveroom.x.a gCE;
    private b gCF;
    private com.baidu.tieba.ala.liveroom.tippop.a gCG;
    protected com.baidu.live.j.a gCH;
    private AlaLiveCountDownView gCI;
    private AlaLiveStreamStatusView gCJ;
    private RelativeLayout gCK;
    private RelativeLayout gCL;
    private RelativeLayout gCM;
    private RelativeLayout gCN;
    private FrameLayout gCO;
    private View gCP;
    private boolean gCQ;
    private AlaLiveFaceVerifyView gCR;
    private ImageView gCS;
    private ImageView gCT;
    private ImageView gCU;
    private ImageView gCV;
    private ImageView gCW;
    private ImageView gCX;
    private TextView gCY;
    private ah gCZ;
    private boolean gCh;
    private boolean gCy;
    private boolean gDA;
    private BdUniqueId gDB;
    private boolean gDC;
    private View gDF;
    private FrameLayout gDG;
    private com.baidu.live.y.a gDb;
    private com.baidu.tieba.ala.liveroom.master.panel.b gDc;
    private com.baidu.live.x.a gDd;
    private ImageView gDe;
    private e gDf;
    private short gDp;
    private com.baidu.tieba.ala.liveroom.h.b gDu;
    private boolean gDv;
    private com.baidu.tieba.ala.liveroom.challenge.e gDw;
    private com.baidu.live.b.a gDx;
    private com.baidu.live.b.b gDy;
    private com.baidu.tieba.ala.liveroom.q.a gDz;
    private String gkv;
    private com.baidu.live.g.a glR;
    private c gmq;
    private com.baidu.tieba.ala.liveroom.o.a gmr;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gmu;
    private com.baidu.tieba.ala.liveroom.activeview.b gmw;
    protected h gnF;
    protected y gnH;
    protected com.baidu.live.i.a gnP;
    private com.baidu.live.s.a gnT;
    private com.baidu.live.h.a gng;
    private com.baidu.tieba.ala.liveroom.share.c gnh;
    private com.baidu.tieba.ala.liveroom.r.b gni;
    private m gnt;
    private k gnu;
    private com.baidu.live.im.b.a gnv;
    private w gnw;
    private u gnx;
    private boolean goS;
    private boolean gof;
    private f gqf;
    private ImageView gqm;
    private g gqn;
    private boolean gCz = false;
    private boolean goa = false;
    private Handler mHandler = new Handler();
    private Handler gDa = new Handler();
    private boolean gDg = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver gDh = null;
    private boolean gDi = false;
    private int gDj = 0;
    private int gDk = 0;
    private int gDl = 0;
    private long gDm = 0;
    private long gDn = 0;
    private volatile boolean isBackground = false;
    private Intent gDo = null;
    private int mOrientation = 1;
    private boolean gxF = false;
    private boolean gDq = false;
    private boolean gDr = true;
    private boolean gqk = false;
    private boolean gDs = true;
    private boolean gDt = true;
    private int cXx = 0;
    private String otherParams = "";
    private int bdr = 0;
    private int gDD = 5000;
    private boolean gDE = false;
    private Runnable gDH = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.glR != null) {
                AlaMasterLiveRoomOpearator.this.glR.Df();
            }
        }
    };
    private CustomMessageListener beo = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gqf.gxP != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gqf.gxP.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.A(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener bep = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gqf.gxP != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gqf.gxP.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener gox = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gni == null) {
                        AlaMasterLiveRoomOpearator.this.gni = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gni.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener goD = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gnP != null) {
                AlaMasterLiveRoomOpearator.this.gnP.It();
            }
        }
    };
    private CustomMessageListener gDI = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.r((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gou = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.FR(str);
            }
        }
    };
    private CustomMessageListener gov = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bkV();
        }
    };
    private CustomMessageListener gmR = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gnx.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener goB = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener gDJ = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gDy != null) {
                r LC = AlaMasterLiveRoomOpearator.this.bPo().gxi.LC();
                long j = LC.mLiveInfo.live_id;
                long j2 = LC.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.gDy.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener gDK = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bPo().gxj);
            if (AlaMasterLiveRoomOpearator.this.gCA == null || AlaMasterLiveRoomOpearator.this.gCA.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.us(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gnu != null) {
                AlaMasterLiveRoomOpearator.this.gnu.Jf().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gnu.Jg().hide();
            }
        }
    };
    private CustomMessageListener goC = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.r(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC());
        }
    };
    private CustomMessageListener goE = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gnH != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) AlaMasterLiveRoomOpearator.this.gnH).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gDL = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gDz != null) {
                    AlaMasterLiveRoomOpearator.this.gDz.Go(str);
                }
            }
        }
    };
    private CustomMessageListener gDM = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.gDu != null) {
                        if (!data.azJ || AlaMasterLiveRoomOpearator.this.gDB == null || !AlaMasterLiveRoomOpearator.this.gDC) {
                            if (AlaMasterLiveRoomOpearator.this.gDB != null && AlaMasterLiveRoomOpearator.this.gDB == data.azI) {
                                if (data.azC != null && data.azC.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.gDC || AlaMasterLiveRoomOpearator.this.gCA.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.gDu.a(AlaMasterLiveRoomOpearator.this.bPo().gxI.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.gDv = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bPo().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.gDB = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bPo().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.gDu.a(AlaMasterLiveRoomOpearator.this.bPo().gxI.getVideoConfig(), AlaMasterLiveRoomOpearator.this.gDv);
                        if (!AlaMasterLiveRoomOpearator.this.gDv) {
                            AlaMasterLiveRoomOpearator.this.gDv = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gDA) {
                    AlaMasterLiveRoomOpearator.this.bPo().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.gDA = false;
            }
        }
    };
    private CustomMessageListener gDN = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bPo().gxI != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bPo().gxI.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.c.AD().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bdw = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bdr == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bdr == 6) {
                            AlaMasterLiveRoomOpearator.this.bTw();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bdr = 0;
            }
        }
    };
    private View.OnClickListener gDO = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.gCT) {
                    AlaMasterLiveRoomOpearator.this.bTA();
                    AlaMasterLiveRoomOpearator.this.gDc.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.gCS) {
                    if (view == AlaMasterLiveRoomOpearator.this.gCU) {
                        AlaMasterLiveRoomOpearator.this.bkV();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.gCV) {
                        if (view != AlaMasterLiveRoomOpearator.this.gCX) {
                            if (view != AlaMasterLiveRoomOpearator.this.gqm) {
                                if (view == AlaMasterLiveRoomOpearator.this.gCW && AlaMasterLiveRoomOpearator.this.gCE != null) {
                                    ag bVC = AlaMasterLiveRoomOpearator.this.bPo().gxi.bVC();
                                    if (bVC == null || bVC.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(bVC.mLiveSdkInfo.mRoomId);
                                        if (bVC.mLiveSdkInfo.mCastIds != null) {
                                            str2 = bVC.mLiveSdkInfo.mCastIds.aDY;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.gCE.ai("", str, str2);
                                    return;
                                }
                                return;
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.gDw != null) {
                                AlaMasterLiveRoomOpearator.this.gDw.bPq();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.gDd != null) {
                            AlaMasterLiveRoomOpearator.this.gDd.Nv();
                            AlaMasterLiveRoomOpearator.this.gDd.co(AlaMasterLiveRoomOpearator.this.bTE());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.gDC = false;
                        AlaMasterLiveRoomOpearator.this.ms(true);
                        AlaMasterLiveRoomOpearator.this.gCY.setVisibility(4);
                        com.baidu.live.c.AD().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.w.a.Nk().beJ.aHp == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beJ.aHo == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bdo) {
                        AlaMasterLiveRoomOpearator.this.bTw();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bdr = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bTw();
                }
            }
        }
    };
    private CustomMessageListener gow = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ah) {
                    AlaMasterLiveRoomOpearator.this.goa = true;
                    AlaMasterLiveRoomOpearator.this.gCZ = (ah) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gnu != null) {
                        AlaMasterLiveRoomOpearator.this.gnu.Jf().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gnu != null) {
                        AlaMasterLiveRoomOpearator.this.gnu.Jg().show();
                        AlaMasterLiveRoomOpearator.this.gnu.Jg().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.us(8);
                }
            }
        }
    };
    private CustomMessageListener gDP = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bPo() != null && AlaMasterLiveRoomOpearator.this.bPo().gxN != null) {
                AlaMasterLiveRoomOpearator.this.bPo().gxN.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener brh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bUn();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bPo().gxi.uz(i);
                if (AlaMasterLiveRoomOpearator.this.gnP != null) {
                    AlaMasterLiveRoomOpearator.this.gnP.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener gkG = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bUg();
        }
    };
    public final HttpMessageListener gDQ = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.LG()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.gDc != null) {
                            AlaMasterLiveRoomOpearator.this.gDc.mz(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.gDc.bUL();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bPo().gxI.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.gCG != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.gCG.a(AlaMasterLiveRoomOpearator.this.bPo().gxK, AlaMasterLiveRoomOpearator.this.bPo().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bPo().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.gCG.uG(2);
                        AlaMasterLiveRoomOpearator.this.gCG.a(AlaMasterLiveRoomOpearator.this.bPo().gxK, string, 3);
                    }
                }
            }
        }
    };
    private e.a gDR = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bUt() {
            AlaMasterLiveRoomOpearator.this.ur(a.i.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bUu() {
            AlaMasterLiveRoomOpearator.this.ur(a.i.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a gDS = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean ey(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ez(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bPo().bRb() == 1) {
                AlaMasterLiveRoomOpearator.this.bPo().gxI.stopRecord();
            }
        }
    };
    private IShareCallback gDT = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.gDg && AlaMasterLiveRoomOpearator.this.gDf != null) {
                AlaMasterLiveRoomOpearator.this.gDg = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.gDf);
            }
        }
    };
    private View.OnTouchListener gDU = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bPo().gxN.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bPo().gxj);
            AlaMasterLiveRoomOpearator.this.us(0);
            if (AlaMasterLiveRoomOpearator.this.gnu != null) {
                AlaMasterLiveRoomOpearator.this.gnu.Jf().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.gnu.Jg().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b gDV = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUv() {
            AlaMasterLiveRoomOpearator.this.bTx();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUw() {
            AlaMasterLiveRoomOpearator.this.gCh = AlaMasterLiveRoomOpearator.this.gCA.bQT();
            AlaMasterLiveRoomOpearator.this.bPo().gxN.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bPo().gxN.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bPo().gxN.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gxC = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bPo().bRb();
            eVar.title = AlaMasterLiveRoomOpearator.this.gCA.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.gxD = AlaMasterLiveRoomOpearator.this.gCA.bQU();
            eVar.gxG = AlaMasterLiveRoomOpearator.this.gCh;
            eVar.gxF = AlaMasterLiveRoomOpearator.this.gCA.bQR();
            eVar.gxE = AlaMasterLiveRoomOpearator.this.gCA.bQW();
            eVar.gxH = AlaMasterLiveRoomOpearator.this.gCA.bQS();
            if (eVar.gxH) {
                if (AlaMasterLiveRoomOpearator.this.gCA.bQX()) {
                    AlaMasterLiveRoomOpearator.this.gDg = true;
                    AlaMasterLiveRoomOpearator.this.gDf = eVar;
                    AlaMasterLiveRoomOpearator.this.gCA.bQY();
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
            AlaMasterLiveRoomOpearator.this.bPo().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bPo().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUx() {
            AlaMasterLiveRoomOpearator.this.gDC = true;
            AlaMasterLiveRoomOpearator.this.ms(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bUy() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUz() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private Runnable gDW = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.bPo().gxi != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo != null) {
                    com.baidu.live.utils.m.k(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.gDW, AlaMasterLiveRoomOpearator.this.gDD);
                }
            }
        }
    };
    private CustomMessageListener bat = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bNB();
            }
        }
    };
    private com.baidu.live.liveroom.g.c gDX = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void LA() {
            if (AlaMasterLiveRoomOpearator.this.gCE != null) {
                AlaMasterLiveRoomOpearator.this.gCE.mK(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.gDd != null) {
                        AlaMasterLiveRoomOpearator.this.gDd.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gDd != null) {
                    AlaMasterLiveRoomOpearator.this.gDd.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.gCE != null) {
                    AlaMasterLiveRoomOpearator.this.gCE.mK(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gnH != null) {
                    AlaMasterLiveRoomOpearator.this.gnH.bl(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a gDY = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void XL() {
            if (AlaMasterLiveRoomOpearator.this.gCR != null && AlaMasterLiveRoomOpearator.this.bPo().gxK.indexOfChild(AlaMasterLiveRoomOpearator.this.gCR) >= 0) {
                AlaMasterLiveRoomOpearator.this.bPo().gxK.removeView(AlaMasterLiveRoomOpearator.this.gCR);
                AlaMasterLiveRoomOpearator.this.gCR.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.gCR = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gmW = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            r LC;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bUm();
            } else if (i == 14 && (LC = AlaMasterLiveRoomOpearator.this.bPo().gxi.LC()) != null && LC.aDG != null && LC.mLiveInfo != null && LC.aEf != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity(), LC.aDG.userName, Long.toString(LC.aDG.userId), Long.toString(LC.aDG.charmCount), String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), true, String.valueOf(LC.aDG.userId), Long.toString(LC.aEf.userId), LC.aEf.userName, LC.aEf.portrait, AlaMasterLiveRoomOpearator.this.gmu.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(LC.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gmu.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener gDZ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.bPo().gxi != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.beQ != null && !eventPollingHttpResponseMessage.beQ.isEmpty()) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.beQ.size()) {
                                break;
                            }
                            au auVar = eventPollingHttpResponseMessage.beQ.get(i2);
                            if (j == auVar.liveId && j2 - auVar.createTime <= 60 && !com.baidu.live.utils.m.i(auVar.liveId, auVar.id)) {
                                com.baidu.live.utils.m.a(auVar, AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo, true);
                                AlaMasterLiveRoomOpearator.this.a(auVar);
                                com.baidu.live.utils.m.j(auVar.liveId, auVar.id);
                            }
                            i = i2 + 1;
                        }
                        au auVar2 = eventPollingHttpResponseMessage.beQ.get(eventPollingHttpResponseMessage.beQ.size() - 1);
                        if (j == auVar2.liveId) {
                            com.baidu.live.utils.m.h(auVar2.liveId, auVar2.id);
                        }
                    }
                }
                int i3 = eventPollingHttpResponseMessage.beP;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.gDD = i3 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a gEa = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private com.baidu.live.liveroom.middleware.g gEb = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.ayx);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        gCx = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && com.baidu.live.w.a.Nk().beJ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bPo().pageContext.getPageActivity(), String.valueOf(rVar.mLiveInfo.live_id), String.valueOf(rVar.mLiveInfo.user_id), com.baidu.live.w.a.Nk().beJ.aHk, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FR(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPo().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bPo().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.w.a.Nk().beJ.aGK;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bPo().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bPo().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bPo().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNB() {
        int i = bPo().gxi.LC().aDG.isUegBlock;
        int i2 = bPo().gxi.LC().aDG.isBlock;
        String str = bPo().gxi.LC().aDG.userName;
        if (i > 0 || i2 > 0) {
            this.bdo = true;
            this.gnu.a(true, i, i2, str);
            return;
        }
        this.bdo = false;
        this.gnu.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gqf.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcy == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcz);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gqf.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.gqf.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTw() {
        if (this.gnu != null) {
            this.gnu.Jg().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.gDw != null) {
            this.gDw.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTx() {
        if (bPo() != null && bPo().gxi != null) {
            bPo().gxi.bVv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bHW() != null && aVar.bHX() != null) {
            bPo().gxi.ee(aVar.bHW().getId(), aVar.bHX().getId());
        }
    }

    /* loaded from: classes7.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.gDi = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.gDi = false;
                }
                if (AlaMasterLiveRoomOpearator.this.gDj == 0) {
                    AlaMasterLiveRoomOpearator.this.gDj = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.gDk == 0) {
                    AlaMasterLiveRoomOpearator.this.gDk = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.gDl = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bPo() != null && bPo().gxL != null) {
            bPo().gxL.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.gqf = fVar;
        this.gkv = str;
    }

    protected f bPo() {
        return this.gqf;
    }

    public int a(g gVar) {
        this.gqn = gVar;
        this.gDh = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.gDh, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.gCG == null) {
            this.gCG = new com.baidu.tieba.ala.liveroom.tippop.a(this.gqf.pageContext, null);
        }
        registerListener();
        this.glR = new com.baidu.live.g.a();
        bTP();
        bTy();
        bTz();
        Long[] lArr = new Long[1];
        this.gDm = lArr[0] == null ? 0L : lArr[0].longValue();
        this.gDn = lArr[0] != null ? lArr[0].longValue() : 0L;
        bPo().gxj.setOnTouchListener(this.gDU);
        this.gCy = SharedPrefHelper.getInstance().getBoolean(gCx, false);
        this.gCI = new AlaLiveCountDownView(bPo().pageContext.getPageActivity());
        this.gCI.setCount(3);
        this.gCI.setTextColor(bPo().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.gCI.setTextSize(bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.gCI.setTypeface(Typeface.DEFAULT_BOLD);
        this.gCI.setIncludeFontPadding(false);
        this.gCI.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bUA() {
                if (AlaMasterLiveRoomOpearator.this.bPo().gxj != null) {
                    AlaMasterLiveRoomOpearator.this.bPo().gxj.removeView(AlaMasterLiveRoomOpearator.this.gCI);
                }
            }
        });
        return 1;
    }

    private void bTy() {
        CustomResponsedMessage runTask;
        if (this.gCH == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.j.a.class, bPo().pageContext)) != null && runTask.getData() != null) {
            this.gCH = (com.baidu.live.j.a) runTask.getData();
            this.gCH.c(bPo().pageContext);
        }
    }

    private void bTz() {
        View rootLayout;
        if (this.gCH != null && this.gCO != null && (rootLayout = this.gCH.bV(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gCO.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTA() {
        if (this.gDc == null) {
            this.gDc = new com.baidu.tieba.ala.liveroom.master.panel.b(bPo().pageContext.getPageActivity(), bPo().bRb() == 2);
            this.gDc.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mu(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bPo().gxI.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mv(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bPo().gxI.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mw(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bPo().gxI.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bUl();
                    if (AlaMasterLiveRoomOpearator.this.gCG != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.gCG.a(AlaMasterLiveRoomOpearator.this.bPo().gxK, AlaMasterLiveRoomOpearator.this.bPo().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.gCG.a(AlaMasterLiveRoomOpearator.this.bPo().gxK, AlaMasterLiveRoomOpearator.this.bPo().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mx(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUB() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bPo().gxi != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.gDc != null) {
                        AlaMasterLiveRoomOpearator.this.gDc.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUC() {
                    if (AlaMasterLiveRoomOpearator.this.gDc != null) {
                        AlaMasterLiveRoomOpearator.this.gDc.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.h(AlaMasterLiveRoomOpearator.this.bPo().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUD() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bPo() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.r(AlaMasterLiveRoomOpearator.this.bPo().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.gDc != null) {
                            AlaMasterLiveRoomOpearator.this.gDc.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUE() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bPo() == null || AlaMasterLiveRoomOpearator.this.bPo().gxi == null || AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() == null || AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bPo() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.gDc != null) {
                                        AlaMasterLiveRoomOpearator.this.gDc.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gqf.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.gDc != null) {
                        AlaMasterLiveRoomOpearator.this.gDc.dismiss();
                    }
                }
            });
        }
        bTB();
    }

    private void bTB() {
        if (this.gDc != null) {
            boolean isBackCamera = bPo().gxI.isBackCamera();
            this.gDc.my(bPo().gxI.isBackCamera());
            this.gDc.N(bPo().gxI.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bPo().gxI.isPushMirror();
            if (this.gDr) {
                isPushMirror = bUk() || isPushMirror;
                this.gDr = false;
            }
            this.gDc.O(isPushMirror, isBackCamera ? false : true);
            this.gDc.mz(bPo().gxI.isMute());
            this.gDc.bUL();
        }
    }

    public void bTC() {
        if (this.gqn != null) {
            if (this.gqn.gxQ == null || this.gqn.gxQ.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.gCP == null) {
                        this.gCP = this.gqf.gxP.Lc();
                        this.gqf.gxK.addView(this.gCP, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.gCA == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bPo().gxi != null && bPo().gxi.LC() != null && bPo().gxi.LC().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bPo().gxi.LC().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bPo().gxi.LC().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.gCA = new d(bPo().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bPo().gxN.prepareTime = System.currentTimeMillis();
                    bPo().gxK.addView(this.gCA.getView(), layoutParams);
                    this.gCA.a(this.gDT);
                }
                this.gCA.mb(this.gxF);
                this.gCA.a(this.gDV);
                this.gCA.a(this.gDR);
                this.gCA.a(bPo().gxI, bPo().bRb());
                this.gCA.a(this.gCH);
                return;
            }
            this.gCh = this.gqn.gxQ.mLiveInfo.screen_direction == 2;
            if (this.gqn.gxQ.mLiveInfo.isAudioOnPrivate == 1) {
                bPo().gxI.setMute(true);
                if (this.gCG == null) {
                    this.gCG = new com.baidu.tieba.ala.liveroom.tippop.a(this.gqf.pageContext, null);
                }
                if (!this.gCG.uF(2)) {
                    this.gCG.a(bPo().gxK, bPo().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gxC = true;
            eVar.forumId = String.valueOf(this.gqn.gxQ.mLiveInfo.forum_id);
            eVar.forumName = this.gqn.gxQ.mLiveInfo.forum_name;
            eVar.liveType = this.gqn.gxQ.mLiveInfo.live_type;
            eVar.title = this.gqn.gxQ.mLiveInfo.getLiveTitle();
            eVar.clarity = this.gqn.gxQ.mLiveInfo.clarity;
            eVar.gameId = this.gqn.gxQ.mLiveInfo.game_id;
            eVar.gameName = this.gqn.gxQ.mLiveInfo.game_label;
            eVar.gxG = this.gqn.gxQ.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bTD() {
        if (this.gDu != null) {
            this.gDu.a(bPo().gxI.getVideoConfig(), false);
        }
        if (this.gCA != null) {
            this.gCA.ma(true);
        }
        if (bPo().gxI.hasBeauty() >= 0) {
            bPo().gxI.setBeauty(com.baidu.live.c.AD().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bPo().gxP.G(this.gqf.gxI);
        } else if (this.gCA != null) {
            this.gCA.ma(true);
        }
        bTO();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.gCP != null && this.gCP.getParent() != null) {
                ((ViewGroup) this.gCP.getParent()).removeView(this.gCP);
                this.gCP = null;
            }
            bPo().gxj.setVisibility(0);
            this.gqf.gxP.a(bPo().gxj);
        } else {
            bTV();
            bUj();
            if (this.gDG != null) {
                this.gDG.setVisibility(0);
            }
            this.gCE = new com.baidu.tieba.ala.liveroom.x.a(bPo().pageContext, this.gDS);
            this.gCE.d(bPo().gxj, true);
            this.gCE.mK(true);
            if (this.gnu != null && this.gnu.Jf() != null) {
                this.gnu.Jf().setNeedTopAlphaShade(true);
            }
        }
        bPo().gxI.setPushMirror(bUk());
    }

    public void b(ag agVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gqf.gxP.l(bPo().gxi.LC());
        }
        if (!bPo().gxI.isBackground() && bPo().gxi.LC() != null && bPo().gxi.LC().mLiveInfo != null) {
            int startPush = bPo().gxI.startPush(bPo().gxi.LC().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gqf.gxP.Ld();
            }
            if (startPush != 0 && bPo().gxN != null) {
                bPo().gxN.errCode = 4;
                bPo().gxN.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (agVar != null && !agVar.CS() && !bUh()) {
                mt(true);
                bUi();
            }
            if (this.gmr != null) {
                this.gmr.w(bPo().gxi.LC());
            }
            if (this.gng != null) {
                this.gng.a(bPo().gxi.LC());
            }
            if (this.gCH != null) {
                this.gCH.h(bPo().gxi.LC());
                this.gCH.gV(this.otherParams);
            }
            if (this.gCC != null && bPo() != null && bPo().gxi != null) {
                if (this.gCC.at(bPo().gxK)) {
                    this.gCC.q(bPo().gxi.LC());
                } else {
                    this.gCC.b(bPo().gxK, bPo().gxi.LC());
                }
            }
            if (this.gCB != null) {
                this.gCB.w(bPo().gxi.LC());
            }
            if (agVar == null || agVar.aDG == null) {
                z = com.baidu.live.c.AD().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = agVar.aDG.canUseChallenge;
                com.baidu.live.c.AD().putBoolean("ala_master_can_use_challenge", z);
            }
            bTW();
            bTH();
            mr(z);
            bNl();
            bTX();
            bUc();
            bOr();
            x(bPo().gxi.LC());
            f(bPo().gxi.LC());
            bUd();
            bUe();
            bUa();
            bOg();
            bOn();
            bOo();
            bTU();
            if (this.gnt != null) {
                this.gnt.g(bPo().gxi.LC());
            }
            if (this.gnu != null) {
                if (bPo().gxi.LC() != null && bPo().gxi.LC().aEs != null && bPo().gxi.LC().aEs.Co()) {
                    z2 = true;
                }
                this.gnu.a(String.valueOf(bPo().gxi.LC().mLiveInfo.group_id), String.valueOf(bPo().gxi.LC().mLiveInfo.last_msg_id), String.valueOf(bPo().gxi.LC().aDG.userId), String.valueOf(bPo().gxi.LC().mLiveInfo.live_id), bPo().gxi.LC().aDG.appId, z2);
            }
            if (this.gnv != null) {
                this.gnv.a(bPo().gxi.LC(), true);
            }
            if (!this.gDE && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.gDE = true;
                this.mHandler.post(this.gDW);
            }
            this.mHandler.post(this.gDH);
        }
    }

    private void bNl() {
        if (this.bhK == null) {
            this.bhK = new PendantParentView(bPo().pageContext.getPageActivity(), this.goS ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bPo().gxj.addView(this.bhK, layoutParams);
            this.bhK.setDefaultItemMargin(bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bhK.setPadding(bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bOT();
        }
    }

    private void bOT() {
        if (this.bhK != null) {
            int dimensionPixelSize = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278);
            int dimensionPixelSize2 = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhK.getLayoutParams();
            if (this.goS) {
                this.bhK.setPosition(0, 0, this.gDw.bOZ(), dimensionPixelSize2);
            } else {
                this.bhK.setPosition(dimensionPixelSize, 0, bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278), dimensionPixelSize2);
            }
            this.bhK.setLayoutParams(layoutParams);
            this.bhK.setModel(this.goS ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bOU() {
        if (this.gnu != null && this.gnu.Jf() != null && this.gnu.Jf().getView() != null) {
            if (this.goS && !this.gCz && bPo().gxj != null && bPo().gxj.getHeight() > 0) {
                int be = this.gDw != null ? this.gDw.be(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.gnu.Jf().getView().getLayoutParams();
                int height = bPo().gxj.getHeight() - be;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.gnu.Jf().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ab.b.i(false, this.gCz);
            if (bPo().gxj.indexOfChild(this.gnu.Jf().getView()) != -1 && this.gnu.Jf().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnu.Jf().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.gnu.Jf().getView().setLayoutParams(layoutParams2);
            }
            this.gnu.Jf().Je();
        }
    }

    private void bOV() {
        if (this.gnw != null) {
            if (this.goS && !this.gCz && bPo().gxj != null && bPo().gxj.getHeight() > 0) {
                this.gnw.dL((bPo().gxj.getHeight() - (this.gDw != null ? com.baidu.live.utils.g.j(bPo().pageContext.getPageActivity(), true) : 0)) + bPo().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height));
            } else {
                this.gnw.dL(com.baidu.live.ab.a.a(bPo().pageContext.getPageActivity(), true, false, this.gCz));
            }
        }
    }

    private void bOW() {
        int i;
        if (this.gnw != null) {
            int h = com.baidu.live.ab.a.h(true, false);
            if (!this.goS || bPo().gxj == null || bPo().gxj.getHeight() <= 0) {
                i = h;
            } else {
                i = (bPo().gxj.getHeight() - (this.gDw != null ? this.gDw.be(false) : 0)) + bPo().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
            }
            this.gnw.dM(i);
        }
    }

    private void bOX() {
        if (this.gnv != null && this.gnv.AZ() != null) {
            ViewGroup.LayoutParams layoutParams = this.gnv.AZ().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bPo().pageContext.getResources().getDimensionPixelOffset(this.goS ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gnv.AZ().setLayoutParams(layoutParams);
            }
        }
    }

    private void mr(boolean z) {
        if (this.gDw == null) {
            this.gDw = new com.baidu.tieba.ala.liveroom.challenge.e(bPo());
        }
        this.gDw.a(this.gqm, this.gqn);
        this.gDw.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(ap apVar, at atVar, at atVar2) {
                AlaMasterLiveRoomOpearator.this.goS = true;
                AlaMasterLiveRoomOpearator.this.bPo().gxj.gMa = false;
                if (AlaMasterLiveRoomOpearator.this.gDd != null) {
                    AlaMasterLiveRoomOpearator.this.gDd.eJ(4);
                    AlaMasterLiveRoomOpearator.this.gDd.co(true);
                }
                AlaMasterLiveRoomOpearator.this.bTF();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void BG() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gDH);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bPm() {
                AlaMasterLiveRoomOpearator.this.goS = false;
                AlaMasterLiveRoomOpearator.this.bPo().gxj.gMa = false;
                if (AlaMasterLiveRoomOpearator.this.gDd != null) {
                    AlaMasterLiveRoomOpearator.this.gDd.eJ(0);
                    AlaMasterLiveRoomOpearator.this.gDd.co(false);
                }
                AlaMasterLiveRoomOpearator.this.bTG();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bPn() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gDH);
            }
        });
        this.gDw.K(this.gCh, z);
        this.gDw.i(this.gCh, z, (this.gqn == null || this.gqn.gxQ == null || this.gqn.gxQ.mChallengeData == null) ? false : true);
    }

    public boolean bTE() {
        return this.gDw != null && this.gDw.bPs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTF() {
        if (this.gCF != null) {
            this.gCF.setVisible(8);
            this.gCF.setCanVisible(false);
        }
        if (this.gmw != null) {
            this.gmw.lB(true);
        }
        if (this.gCJ != null) {
            this.gCJ.setCanVisible(false);
            this.gCJ.setVisibility(4);
        }
        if (this.gCE != null) {
            this.gCQ = this.gCE.bXL();
            this.gCE.mJ(false);
        }
        bOT();
        bOU();
        bOV();
        bOW();
        bOX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTG() {
        if (this.gCF != null) {
            this.gCF.setCanVisible(true);
        }
        if (this.gmw != null) {
            this.gmw.lB(false);
        }
        if (this.gCJ != null) {
            this.gCJ.setCanVisible(true);
        }
        if (this.gCE != null) {
            this.gCE.mJ(this.gCQ);
        }
        bOT();
        bOU();
        bOV();
        bOW();
        bOX();
    }

    private void bTH() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.gCJ == null) {
            this.gCJ = new AlaLiveStreamStatusView(bPo().pageContext.getPageActivity());
        }
        this.gCJ.setId(a.g.ala_live_room_stream_view);
        this.gCJ.setVisibility(4);
        this.gCJ.setLayoutParams(layoutParams);
        if (this.gCJ.getParent() == null) {
            bPo().gxj.addView(this.gCJ, layoutParams);
        }
    }

    public void bTI() {
        if (this.gCA != null && this.gCA.getVisibility() != 8 && bPo().gxI.getPreview() != null) {
            bPo().gxI.stopRecord();
        }
    }

    public void bTJ() {
        if (bPo().gxI.getPreview() != null) {
            bPo().gxI.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gDu != null) {
                this.gDu.lZ(false);
            }
            this.gDu = new com.baidu.tieba.ala.liveroom.h.b(bPo().gxK, bPo(), bPo().gxI);
            this.gDu.a(bPo().gxI.getVideoConfig(), false);
        }
        if (this.gCG != null) {
            this.gCG.bWE();
        }
        this.mHandler.post(this.gDH);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gCz = z;
        if (z) {
            if (this.gDt) {
                this.gDt = false;
                if (this.gnu != null && this.gnu.Jf() != null) {
                    this.gnu.Jf().getView().setBottom(0);
                }
                if (this.gnu != null && this.gnu.Jg() != null) {
                    this.gnu.Jg().getView().setBottom(0);
                }
            }
            if (this.gnu != null && this.gnu.Jf() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnu.Jf().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.gnu.Jf().getView().setLayoutParams(layoutParams);
            }
            if (this.gnu != null && this.gnu.Jg() != null && this.gnu.Jg().getView() != null && this.gnu.Jg().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnu.Jg().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gnu.Jg().getView().setLayoutParams(layoutParams2);
                this.gnu.Jg().getView().setVisibility(0);
                this.gnu.Jg().KF();
            }
            us(8);
            uq(8);
        } else {
            if (this.gnu != null && this.gnu.Jf() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gnu.Jf().getView().getLayoutParams();
                layoutParams3.bottomMargin = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gnu.Jf().getView().setLayoutParams(layoutParams3);
            }
            if (this.gnu != null && this.gnu.Jg() != null) {
                this.gnu.Jg().hide();
            }
            us(0);
            uq(0);
        }
        if (this.gCA != null) {
            this.gCA.M(false, z);
        }
        if (this.gnv != null) {
            this.gnv.Ba();
        }
        if (this.gDd != null) {
            this.gDd.onKeyboardVisibilityChanged(z);
        }
        bOU();
        this.mHandler.post(this.gDH);
    }

    private void uq(int i) {
        if (this.gmr != null) {
            this.gmr.ue(i);
        }
        if (this.gCL != null) {
            this.gCL.setVisibility(i);
        }
        if (this.gng != null) {
            this.gng.getView().setVisibility(i);
        }
        if (this.gCD != null) {
            this.gCD.setVisible(i);
        }
        if (this.gCC != null) {
            this.gCC.setVisibility(i);
        }
        if (this.gmw != null) {
            this.gmw.setVisible(i);
        }
        if (this.gnT != null) {
            this.gnT.setCanVisible(i == 0);
        }
        if (this.gnF != null) {
            this.gnF.setVisible(i);
        }
        if (this.gnP != null) {
            this.gnP.setCanVisible(i == 0);
        }
        if (this.gDx != null) {
            this.gDx.setCanVisible(i == 0);
            this.gDx.refreshUI();
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bPo().gxN.errCode = 1;
            ur(a.i.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            ur(a.i.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            ur(a.i.stream_upload_exception);
        } else if (i == -2) {
            Gi(bPo().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bPo().gxI.stopRecord();
        } else if (i == -3 && this.gCA != null) {
            this.gCA.ma(false);
        }
        if (i == -4) {
            if (this.gCA == null || this.gCA.getView().getParent() == null) {
                bPo().f((short) 1);
                return;
            }
            this.gCA.bQV();
            this.gCV.setVisibility(0);
            if (this.gCE != null) {
                this.gCE.mK(true);
            }
            bPo().gxj.setBackgroundColor(bPo().pageContext.getResources().getColor(17170445));
            bUq();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aob();
        if (i == 12001) {
            if (i2 == -1) {
                Gj(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            bkV();
        }
    }

    public void onResume() {
        if (this.gCA != null) {
            this.gCA.onResume();
        }
        if (this.gDg && this.gDf != null) {
            this.gDg = false;
            c(this.gDf);
        }
        if (this.gnH != null) {
            this.gnH.onResume();
        }
    }

    public void g(short s) {
        if (this.gnt != null) {
            this.gnt.Fb();
        }
        if (this.gnu != null) {
            this.gnu.a(null);
            this.gnu.Bb();
        }
        if (this.gnv != null) {
            this.gnv.Bb();
        }
        if (this.gDw != null) {
            this.gDw.bPr();
        }
    }

    public boolean bTK() {
        r LC = bPo().gxi.LC();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gqf.gxP.k(LC);
            if (LC != null && LC.mLiveInfo.live_status != 1) {
                bUo();
                bPo().pageContext.getPageActivity().finish();
                if (bPo().gxi != null && bPo().gxi.LC() != null) {
                    a(LC, 1, bPo().gxi.bVL() != 1 ? bPo().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gnu != null) {
                this.gnu.Jf().b(String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), true, String.valueOf(LC.aDG.userId));
            }
            if (this.gnv != null) {
                this.gnv.a(LC);
            }
            if (this.gng != null) {
                this.gng.a(bPo().gxi.LC());
            }
            if (this.gmr != null) {
                this.gmr.w(LC);
            }
            if (LC != null) {
                if (this.gDw != null) {
                    this.gDw.a(LC);
                }
                if (this.gnx != null && LC.mLiveInfo != null) {
                    this.gnx.a(LC.mLiveInfo, LC.aDG);
                }
                if (this.gnT != null) {
                    this.gof = this.gnT.p(LC);
                }
                if (this.gmw != null) {
                    this.gmw.lC(this.gof);
                    this.gmw.j(LC);
                    this.gmw.updateView();
                }
                if (this.gnP != null) {
                    this.gnP.a(LC);
                }
                if (LC.mLiveInfo.live_status != 1) {
                    bUo();
                    bPo().pageContext.getPageActivity().finish();
                    if (bPo().gxi != null && bPo().gxi.LC() != null) {
                        a(LC, 1, bPo().gxi.bVL() != 1 ? bPo().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.gCH != null) {
                    this.gCH.i(LC);
                }
            }
        }
        return false;
    }

    public void bTL() {
        bTB();
    }

    public void bTM() {
        if (this.gDu != null) {
            this.gDu.bQP();
        }
    }

    public void bTN() {
        if (this.gCA != null && this.gCA.getVisibility() != 8) {
            if (bPo().bRb() == 2) {
                bUq();
            } else {
                bUp();
            }
        }
        if (this.gCA != null && this.gCA.getVisibility() != 8) {
            if (bPo().bRb() == 1) {
                this.gCA.onResume();
            }
            this.gCA.onRefresh();
        }
        if (this.gCH != null) {
            this.gCH.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.goa && this.gCZ != null) {
            if (this.gnu != null) {
                this.gnu.Jf().getView().setVisibility(0);
            }
            if (this.gnu != null) {
                this.gnu.Jg().show();
                this.gnu.Jg().setEditText(" @" + this.gCZ.getNameShow() + " ");
            }
            us(8);
            this.goa = false;
        }
        if (this.gDy != null) {
            this.gDy.resume();
        }
        if (this.gDz != null) {
            this.gDz.resume();
        }
    }

    public void onPause() {
        if (this.gCH != null) {
            this.gCH.onPause();
        }
        if (this.gDy != null) {
            this.gDy.pause();
        }
        if (this.gnH != null) {
            this.gnH.onPause();
        }
        if (this.gDz != null) {
            this.gDz.pause();
        }
    }

    private void bTO() {
        if (bc.c(com.baidu.live.w.a.Nk().bkd)) {
            this.gCV.setVisibility(0);
            this.gCV.setAlpha(0.2f);
        } else if (bPo().gxI.hasBeauty() < 0) {
            this.gCV.setVisibility(8);
        } else {
            this.gCV.setVisibility(0);
        }
    }

    private void bTP() {
        this.gCK = (RelativeLayout) bPo().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.gCM = (RelativeLayout) bPo().rootView.findViewById(a.g.under_live_view_panel);
        this.gCN = (RelativeLayout) bPo().rootView.findViewById(a.g.over_live_view_panel);
        this.gCO = (FrameLayout) bPo().rootView.findViewById(a.g.goods_parent);
        this.gqf.gxj.setOnLiveViewScrollListener(this.gDX);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gCM.setVisibility(8);
            this.gCN.setVisibility(8);
            bPo().gxj.removeAllViews();
            return;
        }
        this.gCL = (RelativeLayout) bPo().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCL.getLayoutParams();
        layoutParams.topMargin = this.gqf.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.gCL.setLayoutParams(layoutParams);
        if (this.gmu == null) {
            this.gmu = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gqf.pageContext.getPageActivity(), false);
        }
        this.gmu.a(this.gmW);
        this.gmu.a(this.gCL, a.g.ala_live_room_host_header_stub, 1L);
        this.gmu.setVisible(0);
        bTQ();
        this.gCV = (ImageView) bPo().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.gCY = (TextView) bPo().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn_num);
        this.gCV.setOnClickListener(this.gDO);
        this.gCX = (ImageView) bPo().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.gCX.setOnClickListener(this.gDO);
        if (com.baidu.live.w.a.Nk().bkd != null && com.baidu.live.w.a.Nk().bkd.aJy != null && com.baidu.live.w.a.Nk().bkd.aJy.CW() && bc.b(com.baidu.live.w.a.Nk().bkd)) {
            this.gCX.setVisibility(0);
        } else {
            this.gCX.setVisibility(8);
        }
        bTO();
        this.gCU = (ImageView) bPo().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.gCU.setOnClickListener(this.gDO);
        this.gCS = (ImageView) bPo().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.gCS.setOnClickListener(this.gDO);
        this.gqm = (ImageView) bPo().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.gqm.setOnClickListener(this.gDO);
        this.gCT = (ImageView) bPo().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.gCT.setOnClickListener(this.gDO);
        this.gCW = (ImageView) bPo().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.gCW.setOnClickListener(this.gDO);
        bTT();
        if (bc.b(com.baidu.live.w.a.Nk().bkd)) {
            this.gDu = new com.baidu.tieba.ala.liveroom.h.b(bPo().gxK, bPo(), bPo().gxI);
        }
        this.gnt = new m();
        bTR();
        bTS();
        if (com.baidu.live.c.AD().getInt("beauty_new_bubble", 1) == 1) {
            this.gCY.setVisibility(0);
        }
    }

    private void bTQ() {
        this.gDG = (FrameLayout) View.inflate(bPo().pageContext.getPageActivity(), a.h.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gDG != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.gDG.setVisibility(8);
            if (this.gDG.getParent() != null && (this.gDG.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gDG.getParent()).removeView(this.gDG);
            }
            this.gCK.addView(this.gDG, layoutParams);
            if (this.gDG != null) {
                this.gDG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.gmW.m(AlaMasterLiveRoomOpearator.this.gDG, 8);
                    }
                });
            }
        }
    }

    private void bTR() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bPo().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gnu = (k) runTask.getData();
            this.gnu.setFromMaster(true);
            this.gnu.Jf().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bPo().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ab.b.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ab.b.cD(true);
            bPo().gxj.addView(this.gnu.Jf().getView(), layoutParams);
            this.gnu.Jg().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bPo().gxj.addView(this.gnu.Jg().getView(), layoutParams2);
            this.gnu.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                @Override // com.baidu.live.im.k.a
                public boolean Ji() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Jj() {
                }

                @Override // com.baidu.live.im.k.a
                public void gR(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Jk() {
                }

                @Override // com.baidu.live.im.k.a
                public void Jl() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Jm() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int Jn() {
                    return 0;
                }
            });
        }
    }

    private void bTS() {
        View AZ;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bPo().pageContext);
        if (runTask != null) {
            this.gnv = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gnv != null && (AZ = this.gnv.AZ()) != null && this.gqf.gxj.indexOfChild(AZ) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gqf.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bPo().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bPo().gxj.addView(AZ, layoutParams);
        }
    }

    private void bTT() {
        CustomResponsedMessage runTask;
        if (this.gDb == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.y.a.class, bPo().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gDb = (com.baidu.live.y.a) runTask.getData();
        }
    }

    private void bTU() {
        View ED;
        v.b(bPo().pageContext, true);
        if (this.gnw == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aMJ = true;
            fVar.context = bPo().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnw = (w) runTask.getData();
                if (this.gnw != null && (ED = this.gnw.ED()) != null && bPo().gxj.indexOfChild(ED) < 0) {
                    if (ED.getParent() instanceof ViewGroup) {
                        ((ViewGroup) ED.getParent()).removeView(ED);
                    }
                    bPo().gxj.addView(ED, bPo().gxj.getLayoutParams());
                }
            }
        }
    }

    protected void bOo() {
        View EV;
        if (this.gnx == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aMJ = true;
            aVar.context = bPo().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnx = (u) runTask.getData();
            }
        }
        if (this.gnx != null && (EV = this.gnx.EV()) != null) {
            if (bPo().gxj.indexOfChild(EV) < 0) {
                if (EV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) EV.getParent()).removeView(EV);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.gnF != null && this.gnF.isShowing()) {
                    layoutParams.addRule(3, a.g.guard_club_entry_id);
                    layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else if (this.gCD != null && this.gCD.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
                    layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else {
                    layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                    layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds66);
                }
                bPo().gxj.addView(EV, layoutParams);
            }
            EV.bringToFront();
        }
    }

    protected void bOn() {
        View Fc;
        if (this.gnH == null) {
            ab abVar = new ab();
            abVar.aMJ = true;
            abVar.pageContext = bPo().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnH = (y) runTask.getData();
            }
        }
        if (this.gnH != null && (Fc = this.gnH.Fc()) != null && bPo().gxj.indexOfChild(Fc) < 0) {
            if (Fc.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fc.getParent()).removeView(Fc);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bPo().gxj.addView(Fc, layoutParams);
        }
    }

    private void bTV() {
        bTZ();
        bNo();
        bTY();
        bPo().gxj.setVisibility(0);
        us(0);
    }

    private void bTW() {
        if (this.gCD == null) {
            this.gCD = new com.baidu.tieba.ala.liveroom.u.a(bPo().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gCD.a(bPo().bRb(), j, TbadkCoreApplication.getCurrentAccountName(), true, bPo().gxi.LC().aDG.portrait, this.otherParams, "", -1L);
        this.gCD.as(bPo().gxj);
    }

    private void bTX() {
        if (this.gDd == null) {
            bPo().gxj.gMa = false;
            com.baidu.live.x.a eO = eO(bPo().pageContext.getPageActivity());
            if (eO != null) {
                this.gDd = eO;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.x.a.class, bPo().pageContext.getPageActivity());
                if (runTask != null) {
                    this.gDd = (com.baidu.live.x.a) runTask.getData();
                }
            }
            if (this.gDd != null) {
                this.gDd.q(this.gCM);
                this.gDd.r(this.gCN);
                this.gDd.eI((bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bPo().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                this.gDd.s(bPo().gxj);
                this.gDd.a(this.glR);
                this.gDd.setLiveShowInfo(bPo().gxi.LC());
                this.gDd.a(this.gmw);
                this.gDd.Nw();
                this.gDd.a(new a.InterfaceC0202a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public void Nx() {
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public void Ny() {
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public void H(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bPo().gxI != null) {
                            AlaMasterLiveRoomOpearator.this.bPo().gxI.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int Nz() {
                        return AlaMasterLiveRoomOpearator.this.gCL.getBottom();
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int NA() {
                        return AlaMasterLiveRoomOpearator.this.gqf.gxj.getHeight() - (AlaMasterLiveRoomOpearator.this.gnu.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gnu.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gnu.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int NB() {
                        return AlaMasterLiveRoomOpearator.this.gnu.Jh();
                    }
                });
            }
        }
    }

    private com.baidu.live.x.a eO(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).at(context);
        }
        return null;
    }

    private void bTY() {
        if (this.gCF == null) {
            this.gCF = new b(bPo().pageContext, bPo().gxj);
        }
    }

    private void bTZ() {
        if (this.gmr == null) {
            this.gmr = new com.baidu.tieba.ala.liveroom.o.a(bPo().pageContext, true, this.gDS);
            this.gmr.c(this.gCL, (r) null);
            this.gmr.a(this.gmW);
        }
        if (this.gCB == null) {
            this.gCB = new com.baidu.tieba.ala.liveroom.o.a(bPo().pageContext, true, null);
            this.gCB.a(this.gCL, null, a.g.ala_live_room_host_header_stub);
            this.gCB.bSM();
        }
    }

    protected void bNX() {
        CustomResponsedMessage runTask;
        boolean z = false;
        ag bVC = bPo().gxi.bVC();
        boolean z2 = com.baidu.live.w.a.Nk().beJ.aHj;
        if (bVC == null || bVC.aEq) {
            z = z2;
        }
        if (z && this.gng == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bPo().pageContext)) != null) {
            this.gng = (com.baidu.live.h.a) runTask.getData();
            if (this.gng != null) {
                this.gng.setIsHost(true);
                this.gng.ev(1);
                View view = this.gng.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bPo().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bPo().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.gCL.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(r rVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gmw == null) {
            this.gmw = new com.baidu.tieba.ala.liveroom.activeview.b(bPo().pageContext);
        }
        this.gmw.setOtherParams(this.otherParams);
        this.gmw.b(rVar, false);
        this.gmw.setHost(true);
        this.gmw.a(1, this.bhK);
        this.gmw.a(2, this.bhK);
        this.gmw.lC(this.gof);
        this.gmw.setVisible(this.gCz ? 8 : 0);
        this.gmw.a(this.glR);
        if (this.glR != null) {
            if (this.gmw != null) {
                alaActiveRootView2 = this.gmw.tL(1);
                alaActiveRootView = this.gmw.tL(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.glR.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.glR.a(alaActiveRootView);
            }
        }
    }

    private void x(r rVar) {
        CustomResponsedMessage runTask;
        if (this.gnT == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bPo().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.s.a)) {
            this.gnT = (com.baidu.live.s.a) runTask.getData();
            if (this.gnT != null) {
                this.gnT.p(this.bhK);
            }
        }
        if (this.gnT != null) {
            this.gof = this.gnT.p(rVar);
            this.gnT.setCanVisible(!this.gCz);
        }
    }

    protected void bUa() {
        CustomResponsedMessage runTask;
        if (bPo() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bPo().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gnP = (com.baidu.live.i.a) runTask.getData();
            this.gnP.a(bPo().gxj, bUb());
            if (bPo().gxi != null) {
                this.gnP.a(bPo().gxi.LC());
            }
            this.gnP.setCanVisible(true);
            this.gnP.bK(false);
            this.gnP.a(bPo().gxi.bIw());
        }
    }

    private void bOg() {
        this.gDz = new com.baidu.tieba.ala.liveroom.q.c(bPo().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bUb() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bPo().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.gnF != null && this.gnF.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else if (this.gCD != null && this.gCD.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        }
        return layoutParams;
    }

    private void bNo() {
        if (this.gCC == null) {
            this.gCC = new com.baidu.tieba.ala.liveroom.b.a(bPo().pageContext, true);
        }
    }

    private void bUc() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bPo().pageContext.getPageActivity();
            if (this.gDe == null) {
                this.gDe = new ImageView(pageActivity);
                this.gDe.setId(a.g.master_close_btn);
                this.gDe.setTag("master_close_btn");
                this.gDe.setImageResource(a.f.sdk_icon_bar_live_close_n);
                this.gDe.setBackgroundResource(a.f.sdk_round_btn_close_bg);
                this.gDe.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            }
            if (this.gDe.getParent() != null) {
                ((ViewGroup) this.gDe.getParent()).removeView(this.gDe);
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
            bPo().gxK.addView(this.gDe, layoutParams);
            this.gDe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bUm();
                }
            });
            this.gDe.setVisibility(8);
        }
    }

    private void bOr() {
        if (this.gnF == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bPo().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gnF = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.gnF.setHost(true);
        this.gnF.setOtherParams(this.otherParams);
        if (bPo().gxi.LC() != null && bPo().gxi.LC().aDG != null && bPo().gxi.LC().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            layoutParams.leftMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.gnF.a(bPo().gxj, layoutParams, bPo().gxi.LC());
        }
    }

    private void bUd() {
        CustomResponsedMessage runTask;
        if (this.gDx == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bPo().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.gDx = (com.baidu.live.b.a) runTask.getData();
            if (this.gDx != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bPo().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gDx.a(bPo().gxj, layoutParams);
            }
        }
        if (this.gDx != null) {
            this.gDx.a(bPo().gxi.LC());
        }
    }

    private void bUe() {
        CustomResponsedMessage runTask;
        if (this.gDy == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bPo().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.gDy = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gDw != null) {
            this.gDw.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bPo().pageContext.registerListener(this.gou);
        bPo().pageContext.registerListener(this.gDI);
        bPo().pageContext.registerListener(this.gow);
        bPo().pageContext.registerListener(this.gox);
        bPo().pageContext.registerListener(this.gDP);
        bPo().pageContext.registerListener(this.brh);
        bPo().pageContext.registerListener(this.gkG);
        bPo().pageContext.registerListener(this.gDQ);
        bPo().pageContext.registerListener(this.gov);
        bPo().pageContext.registerListener(this.gmR);
        bPo().pageContext.registerListener(this.gDZ);
        bPo().pageContext.registerListener(this.goB);
        bPo().pageContext.registerListener(this.gDM);
        bPo().pageContext.registerListener(this.gDN);
        bPo().pageContext.registerListener(this.gDJ);
        bPo().pageContext.registerListener(this.beo);
        bPo().pageContext.registerListener(this.bep);
        bPo().pageContext.registerListener(this.gDK);
        bPo().pageContext.registerListener(this.goD);
        bPo().pageContext.registerListener(this.goC);
        bPo().pageContext.registerListener(this.goE);
        bPo().pageContext.registerListener(this.gDL);
        bPo().pageContext.registerListener(this.gDK);
        bPo().pageContext.registerListener(this.bdw);
        bPo().pageContext.registerListener(this.bat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(boolean z) {
        if (bc.c(com.baidu.live.w.a.Nk().bkd)) {
            bPo().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bPo().gxM.AT() == null || ListUtils.isEmpty(bPo().gxM.AT().azC)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bPo().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.gDA) {
                this.gDB = BdUniqueId.gen();
                bPo().gxM.a(this.gDB);
                this.gDA = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bPo().pageContext.getPageActivity(), bPo().rootView);
            us(8);
            if (bPo().gxI.hasAdvancedBeauty() && this.gDu != null) {
                if (!this.gDC || this.gCA.getVisibility() == 0) {
                    this.gDu.a(bPo().gxI.getVideoConfig());
                }
                this.gDu.a(bPo().gxI.getVideoConfig(), this.gDv);
                if (!this.gDv) {
                    this.gDv = true;
                }
            }
            if (z && this.gnu != null) {
                this.gnu.Jf().getView().setVisibility(4);
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
    public void ur(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPo().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bPo().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bPo().f((short) 1);
            }
        });
        bdAlertDialog.create(bPo().pageContext).show();
    }

    private void Gi(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPo().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bPo().f((short) 1);
            }
        });
        bdAlertDialog.create(bPo().pageContext).show();
    }

    public void bUf() {
        bNX();
        com.baidu.live.data.k bIw = bPo().gxi.bIw();
        int i = 5;
        if (bIw != null) {
            i = (int) bIw.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() != null && AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bPo().gxi.f(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bIw != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gqf.gxP.b(bIw);
                return;
            }
            if (this.gmq == null) {
                this.gmq = new c(bPo().pageContext, this.gDS, true);
            }
            if (this.gDs) {
                this.gDs = false;
                this.gmq.a(String.valueOf(bPo().gxi.LC().mLiveInfo.group_id), String.valueOf(bPo().gxi.LC().mLiveInfo.live_id), String.valueOf(bPo().gxi.LC().aDG.userId), bPo().gxi.LC());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.gng != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.gmq.c(this.gCL, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.gmq.e(bIw);
            this.gmu.setVisible(0);
            this.gmu.dO(bIw.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUg() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkV() {
        if (bPo().gxi != null) {
            if (this.gnh == null) {
                this.gnh = new com.baidu.tieba.ala.liveroom.share.c(bPo().pageContext);
            }
            this.gnh.c(bPo().gxi.LC(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bPo().gxi != null && bPo().gxi.LC() != null && bPo().gxi.LC().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bPo().gxi.LC().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bPo().gxi.LC().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bPo().gxi.LC().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bPo().gxi != null && bPo().gxi.LC() != null && bPo().gxi.LC().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bPo().gxi.LC().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bPo().gxi.LC().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bPo().gxi.LC().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bUh() {
        return this.gCy;
    }

    private void mt(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(gCx, z);
        this.gCy = z;
    }

    private void bUi() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPo().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.p.b(AlaMasterLiveRoomOpearator.this.bPo().pageContext).bVk();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bPo().pageContext).show();
    }

    private void bUj() {
        if (this.gCh && bPo().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bPo().gxO.Oh();
        }
        bPo().gxN.prepareTime = System.currentTimeMillis() - bPo().gxN.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bPo().gxi != null && bPo().gxi.LC() != null && bPo().gxi.LC().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bPo().gxi.LC().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bPo().gxi.LC().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bPo().gxN.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gCA != null && this.gCA.getView().getParent() != null) {
            this.gCA.setVisibility(8);
            bPo().gxK.removeView(this.gCA.getView());
            this.gCA.release();
        }
        if (this.gDu != null) {
            this.gDu.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bPo().gxj.indexOfChild(this.gCI) < 0) {
            bPo().gxj.addView(this.gCI, layoutParams);
        }
        this.gCI.uH(1000);
    }

    private void aob() {
        if (bPo().bRb() == 1) {
            bPo().gxI.startRecord();
        }
    }

    private void Gj(String str) {
        Gk(str);
    }

    private void Gk(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bPo().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.gCA != null) {
            this.gCA.FW(fromJson.getSmallurl());
        }
    }

    private boolean bUk() {
        return com.baidu.live.c.AD().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUl() {
        com.baidu.live.c.AD().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.gqf.gxI.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUm() {
        int i = a.i.live_close_confirm;
        if (this.gDw != null && this.gDw.bPt()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.gDw != null && this.gDw.bPs()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPo().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bPo().gxi.LC() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC(), 0, AlaMasterLiveRoomOpearator.this.bPo().gxi.bVL() != 1 ? AlaMasterLiveRoomOpearator.this.bPo().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bPo().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (rVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = rVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = rVar.aDG;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bPo().gxi.eg(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.gDq) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bPo().gxN;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bPo().gxI.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.gDm;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.gDn;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.gDi;
            if (this.gDj != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.gDk - this.gDl) / this.gDj) * 100.0f;
            }
            Intent intent = new Intent(bPo().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bPo().gxi != null && bPo().gxi.LC() != null && bPo().gxi.LC().aDG != null) {
                String str3 = bPo().gxi.LC().aDG.nickName;
                String str4 = bPo().gxi.LC().aDG.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            r LC = bPo().gxi.LC();
            if (LC != null && LC.aDG != null && !TextUtils.isEmpty(LC.aDG.portrait)) {
                intent.putExtra("host_portrait", LC.aDG.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.gDo = intent;
                this.gDp = s;
                bPo().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bUn() {
        if (this.gDo != null) {
            a(this.gDo, this.gDp);
            this.gDo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.gDq = true;
        if (this.gDw != null) {
            this.gDw.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.gkv);
            bPo().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bPo().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUo() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gqf.gxP != null && this.gqf.gxP.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.gDw != null && this.gDw.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bPo().gxL.bUT()) {
                bUm();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.gCJ != null) {
                this.gCJ.setVisibility(4);
                return;
            }
            return;
        }
        if (this.gCJ != null) {
            this.gCJ.a(i, z, i2, z2);
        }
        if (this.gqf != null && this.gqf.gxi != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cXx != i3) {
                this.cXx = i3;
                if (this.gCG == null) {
                    this.gCG = new com.baidu.tieba.ala.liveroom.tippop.a(this.gqf.pageContext, null);
                }
                switch (this.cXx) {
                    case 0:
                        this.gCG.a(this.gqf.gxK, this.gqf.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.gCG.a(this.gqf.gxK, this.gqf.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.gCG.a(this.gqf.gxK, this.gqf.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gqf.gxi.k(this.gqf.gxi.LC().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.bUo();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x061d, code lost:
        FO(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
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
        String optString;
        JSONObject jSONObject5;
        long j;
        long j2;
        long j3;
        String str3;
        String str4;
        if (aVar.getMsgType() == 125) {
            if (this.gCE != null) {
                this.gCE.C(aVar);
            }
        } else if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject4 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject4 = new JSONObject(aVar.getContent());
                }
                try {
                    String optString2 = jSONObject4.optString("content_type");
                    try {
                        optString = jSONObject4.optString("text");
                    } catch (JSONException e) {
                        jSONObject = jSONObject4;
                        str = null;
                        str2 = optString2;
                    }
                    try {
                        String optString3 = jSONObject4.optString("ext");
                        if (!TextUtils.isEmpty(optString3)) {
                            new JSONObject(new String(Base64.decode(optString3.getBytes(), 0)));
                        }
                        jSONObject3 = jSONObject4.optJSONObject("ext_data");
                        jSONObject2 = jSONObject4;
                        str = optString;
                        str2 = optString2;
                    } catch (JSONException e2) {
                        jSONObject = jSONObject4;
                        str = optString;
                        str2 = optString2;
                        jSONObject2 = jSONObject;
                        jSONObject3 = null;
                        if (this.gDw != null) {
                        }
                        if (!"close_live".equals(str2)) {
                        }
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
            if (this.gDw != null) {
                this.gDw.fJ(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bUo();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bPo().gxi.LC(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bPo().gxi.LC() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bPo().gxi.LC().aEf.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bPo().gxi.LC().aEf.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bPo().gxi.LC().aEf.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bPo().gxi.LC() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bPo().gxi.LC() != null && bPo().gxi.LC().aDG != null && bPo().gxi.LC().aDG.userId == optLong2) {
                        bPo().gxi.LC().aDG.isUegBlock = 1;
                        bNB();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bPo().gxi.LC() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bPo().gxi.LC() != null && bPo().gxi.LC().aDG != null && bPo().gxi.LC().aDG.userId == optLong3) {
                        bPo().gxi.LC().aDG.isUegBlock = 0;
                        bNB();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.gDb != null) {
                    this.gDb.N(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.gCF.aF(optString4, optInt2);
                    }
                    if (this.gmu.getCount() > 20) {
                        this.gmu.dO(this.gmu.getCount() + 1);
                    } else if (this.gmq != null) {
                        com.baidu.live.data.a JK = aVar.JK();
                        j jVar = new j();
                        jVar.aDH = new AlaLocationData();
                        jVar.aDI = new AlaRelationData();
                        jVar.aDG = new AlaLiveUserInfoData();
                        jVar.aDG.userId = JavaTypesHelper.toLong(JK.userId, 0L);
                        jVar.aDG.userName = JK.userName;
                        jVar.aDG.portrait = JK.portrait;
                        if (this.gmq.c(jVar)) {
                            this.gmu.dO(this.gmu.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bPo().gxi.LC() != null && bPo().gxi.LC().mLiveInfo != null) {
                    long j4 = bPo().gxi.LC().mLiveInfo.live_id;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!com.baidu.live.utils.m.i(j4, optLong4)) {
                        if (this.gCH != null) {
                            this.gCH.KN();
                        }
                        com.baidu.live.utils.m.j(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bPo() != null && bPo().gxi != null && bPo().gxi.LC() != null && bPo().gxi.LC().aEf != null && bPo().gxi.LC().aEf.userId == jSONObject2.optLong("user_id")) {
                    bPo().gxi.bVB();
                }
            } else if ("official_notice".equals(str2)) {
                if (jSONObject2 != null) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str5 = optLong5 + "";
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
                    com.baidu.live.data.a JK2 = aVar.JK();
                    if (JK2 != null && v.gr(str6)) {
                        v.d(str6, 1L, "", "", JK2.userId, JK2.portrait, JK2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject2 != null) {
                    aq aqVar = new aq();
                    aqVar.parseJson(jSONObject2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, aqVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString5 = jSONObject2.optString("challenge_im_type");
                    if (TextUtils.equals(optString5, "start")) {
                        Gl(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bPo().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(bPo().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a JK3 = aVar.JK();
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject5 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject5 = new JSONObject(aVar.getContent());
                }
                String optString6 = jSONObject5.optString(LogConfig.LOG_GIFT_ID);
                String optString7 = jSONObject5.optString("gift_count");
                String optString8 = jSONObject5.optString("gift_name");
                String optString9 = jSONObject5.optString("gift_url");
                long optLong6 = jSONObject5.optLong("charm_total");
                String optString10 = jSONObject5.optString("attach");
                String optString11 = jSONObject5.optString("attach_new");
                String optString12 = jSONObject5.optString("gift_mul");
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                String str7 = null;
                if (bPo().gxi != null && bPo().gxi.LC() != null && bPo().gxi.LC().mLiveInfo != null) {
                    j5 = bPo().gxi.LC().mLiveInfo.live_id;
                    j6 = bPo().gxi.LC().mLiveInfo.group_id;
                    j7 = bPo().gxi.LC().aDG.userId;
                    str7 = bPo().gxi.LC().mLiveInfo.appId;
                    if (bPo().gxi.LC().mLiveSdkInfo.mCastIds != null) {
                        String str8 = bPo().gxi.LC().mLiveSdkInfo.mCastIds.aDY;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bPo().gxi.LC().mLiveSdkInfo.mCastIds.aDZ;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString6, "");
                        if (this.isBackground || bPo().bRb() != 2) {
                            if (TextUtils.isEmpty(optString11) && !TextUtils.isEmpty(optString12)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    v.b(optString12, JK3.userId, JK3.portrait, JK3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString11, "", "", aVar.getMsgId());
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString12);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.w.d.Nr().hd(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                v.b(optString6, Integer.parseInt(optString7), optString8, optString9, JK3.userId, JK3.portrait, JK3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString10, str4, str3, aVar.getMsgId());
                            }
                        }
                        FO(optString6);
                        com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar.gwN = optLong6;
                        cVar.liveId = j3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                    }
                }
                j = j7;
                j2 = j6;
                j3 = j5;
                str3 = "";
                str4 = "";
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString6, "");
                if (this.isBackground) {
                }
                if (TextUtils.isEmpty(optString11)) {
                }
                v.b(optString6, Integer.parseInt(optString7), optString8, optString9, JK3.userId, JK3.portrait, JK3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString10, str4, str3, aVar.getMsgId());
                FO(optString6);
                com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                cVar2.gwN = optLong6;
                cVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void FO(String str) {
        if (this.gmw != null) {
            this.gmw.FO(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        View findViewById = bPo().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gmw != null) {
            this.gmw.bI(2, i);
        }
    }

    private void bUp() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bPo().gxI != null && AlaMasterLiveRoomOpearator.this.bPo().gxI.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bPo().gxI.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bPo().gxI.startRecord();
                }
            }
        });
    }

    private void bUq() {
        if (bPo().gxI != null && bPo().gxI.getPreview() != null) {
            bPo().gxI.getPreview().setVisibility(8);
            bPo().gxI.stopRecord();
        }
    }

    public void bUr() {
        this.gxF = bPo().gxi.bVM();
        if (this.gCA != null) {
            this.gCA.mb(this.gxF);
        }
    }

    public void bQZ() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bUs();
        } else if (this.gCA != null) {
            this.gCA.bQZ();
        }
    }

    public void mc(boolean z) {
        if (this.gCA != null) {
            this.gCA.mc(z);
        }
    }

    public void onDestroy() {
        if (this.gDh != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.gDh);
        }
        this.gDh = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.gDa.removeCallbacksAndMessages(null);
        if (this.gDu != null) {
            this.gDu.lZ(true);
        }
        this.gDu = null;
        if (this.gCA != null) {
            this.gCA.destroy();
            bPo().gxK.removeView(this.gCA.getView());
            this.gCA.release();
            this.gCA = null;
        }
        if (this.gDw != null) {
            this.gDw.onDestroy();
        }
        if (this.gnh != null) {
            this.gnh.onDestroy();
        }
        if (this.gmr != null) {
            this.gmr.onDestroy();
            this.gmr = null;
        }
        if (this.gCB != null) {
            this.gCB.onDestroy();
        }
        if (this.gnH != null) {
            this.gnH.onDestroy();
            this.gnH = null;
        }
        if (this.gCI != null) {
            this.gCI.stopCountDown();
        }
        if (this.gCD != null) {
            this.gCD.onDestroy();
        }
        if (this.gCF != null) {
            this.gCF.onDestroy();
        }
        if (this.gDb != null) {
            this.gDb.onDestroy();
            this.gDb = null;
        }
        if (this.gnw != null) {
            this.gnw.onDestroy();
            this.gnw = null;
        }
        v.EY();
        com.baidu.live.entereffect.a.Dg().release();
        if (this.gnx != null) {
            this.gnx.onDestroy();
            this.gnx = null;
        }
        if (this.gCG != null) {
            this.gCG.onDestroy();
        }
        if (this.gCE != null) {
            this.gCE.bXK();
            this.gCE.release();
        }
        if (this.gmu != null) {
            this.gmu = null;
        }
        if (this.gmw != null) {
            this.gmw.release();
        }
        if (this.gCE != null) {
            this.gCE.onDestroy();
        }
        if (this.gnv != null) {
            this.gnv.release();
        }
        if (this.gCH != null) {
            this.gCH.release();
        }
        if (this.gnF != null) {
            this.gnF.onDestroy();
        }
        if (this.gDd != null) {
            this.gDd.onDestroy();
        }
        if (this.gnT != null) {
            this.gnT.release();
        }
        if (this.gDx != null) {
            this.gDx.onDestory();
        }
        if (this.gDy != null) {
            this.gDy.release();
        }
        if (this.gnP != null) {
            this.gnP.onDestroy();
        }
        if (this.gDz != null) {
            this.gDz.release();
        }
        MessageManager.getInstance().unRegisterListener(this.gmR);
        MessageManager.getInstance().unRegisterListener(this.gDZ);
        MessageManager.getInstance().unRegisterListener(this.goB);
        MessageManager.getInstance().unRegisterListener(this.gDM);
        MessageManager.getInstance().unRegisterListener(this.gDN);
        MessageManager.getInstance().unRegisterListener(this.gDJ);
        MessageManager.getInstance().unRegisterListener(this.beo);
        MessageManager.getInstance().unRegisterListener(this.bep);
        MessageManager.getInstance().unRegisterListener(this.gDK);
        MessageManager.getInstance().unRegisterListener(this.goD);
        MessageManager.getInstance().unRegisterListener(this.goC);
        MessageManager.getInstance().unRegisterListener(this.goE);
        MessageManager.getInstance().unRegisterListener(this.gDL);
        MessageManager.getInstance().unRegisterListener(this.gDK);
        MessageManager.getInstance().unRegisterListener(this.bdw);
        MessageManager.getInstance().unRegisterListener(this.bat);
        com.baidu.live.utils.m.Pl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(au auVar) {
        if (auVar != null && auVar.eventType == 1001 && this.gCH != null) {
            this.gCH.KN();
        }
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gqf.gxP.a(this.gEb, this.gqf.gxJ, this.gCK, alaLivePersonData);
        }
    }

    private void bUs() {
        if (this.gDf != null) {
            this.gqf.gxN.startTime = System.currentTimeMillis();
            this.gqf.gxN.liveTotalTime = System.currentTimeMillis();
            this.gqf.gxN.sampleMemAndCPU();
            this.gqf.gxL.a((short) 4, this.gDf);
        }
    }

    private void Gl(String str) {
        String str2;
        int i;
        if (bPo() != null && bPo().pageContext != null) {
            this.gDa.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bPo().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.gDF == null) {
                    this.gDF = layoutInflater.inflate(a.h.layout_challenge_entry_toast, (ViewGroup) null);
                    this.gDF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaMasterLiveRoomOpearator.this.gDa.removeCallbacksAndMessages(null);
                            if (AlaMasterLiveRoomOpearator.this.gDF != null) {
                                AlaMasterLiveRoomOpearator.this.bPo().gxj.removeView(AlaMasterLiveRoomOpearator.this.gDF);
                            }
                            if (AlaMasterLiveRoomOpearator.this.gDw != null) {
                                AlaMasterLiveRoomOpearator.this.gDw.bPq();
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.gDF.findViewById(a.g.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.i.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.gDa.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bPo().gxj != null && AlaMasterLiveRoomOpearator.this.gqm != null && AlaMasterLiveRoomOpearator.this.gDF != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.gDF.findViewById(a.g.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.gDF.findViewById(a.g.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.u((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.gDF.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gqm.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gqm.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gqm.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gqm.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.gDF.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.gDF.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.gDF != null) {
                                AlaMasterLiveRoomOpearator.this.bPo().gxj.removeView(AlaMasterLiveRoomOpearator.this.gDF);
                            }
                            AlaMasterLiveRoomOpearator.this.bPo().gxj.addView(AlaMasterLiveRoomOpearator.this.gDF, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.w.a.Nk().beJ != null) {
                    i = com.baidu.live.w.a.Nk().beJ.aGw;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.gDa.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bPo().gxj != null && AlaMasterLiveRoomOpearator.this.gDF != null) {
                            AlaMasterLiveRoomOpearator.this.bPo().gxj.removeView(AlaMasterLiveRoomOpearator.this.gDF);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
