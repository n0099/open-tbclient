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
import com.baidu.live.c.r;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ae;
import com.baidu.live.data.af;
import com.baidu.live.data.an;
import com.baidu.live.data.ao;
import com.baidu.live.data.ar;
import com.baidu.live.data.as;
import com.baidu.live.data.ba;
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
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tieba.view.bubbleview.BubbleLayout;
import com.baidu.live.w.a;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
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
/* loaded from: classes4.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String gpC;
    private boolean aXW;
    private PendantParentView bcj;
    private String fYt;
    private com.baidu.live.g.a fZL;
    private c gaj;
    private com.baidu.tieba.ala.liveroom.n.a gak;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gan;
    private com.baidu.tieba.ala.liveroom.activeview.b gaq;
    protected y gbB;
    protected com.baidu.live.i.a gbJ;
    private com.baidu.live.r.a gbM;
    private boolean gbY;
    private com.baidu.live.h.a gba;
    private com.baidu.tieba.ala.liveroom.share.c gbb;
    private com.baidu.tieba.ala.liveroom.q.b gbc;
    private m gbn;
    private k gbo;
    private com.baidu.live.im.b.a gbp;
    private w gbq;
    private u gbr;
    protected h gbz;
    private boolean gcG;
    private ImageView gcX;
    private f gdS;
    private ImageView gdZ;
    private g gea;
    private boolean gpD;
    private d gpF;
    private com.baidu.tieba.ala.liveroom.n.a gpG;
    private com.baidu.tieba.ala.liveroom.b.a gpH;
    private com.baidu.tieba.ala.liveroom.t.a gpI;
    private com.baidu.tieba.ala.liveroom.w.a gpJ;
    private b gpK;
    private com.baidu.tieba.ala.liveroom.tippop.a gpL;
    protected com.baidu.live.j.a gpM;
    private AlaLiveCountDownView gpN;
    private AlaLiveStreamStatusView gpO;
    private RelativeLayout gpP;
    private RelativeLayout gpQ;
    private RelativeLayout gpR;
    private RelativeLayout gpS;
    private FrameLayout gpT;
    private View gpU;
    private AlaLiveFaceVerifyView gpV;
    private ImageView gpW;
    private ImageView gpX;
    private ImageView gpY;
    private ImageView gpZ;
    private boolean gpm;
    private com.baidu.live.b.a gqA;
    private com.baidu.live.b.b gqB;
    private com.baidu.tieba.ala.liveroom.p.a gqC;
    private boolean gqD;
    private BdUniqueId gqE;
    private boolean gqF;
    private View gqI;
    private ImageView gqa;
    private ImageView gqb;
    private TextView gqc;
    private af gqd;
    private com.baidu.live.x.a gqf;
    private com.baidu.tieba.ala.liveroom.master.panel.b gqg;
    private com.baidu.live.w.a gqh;
    private e gqi;
    private short gqs;
    private com.baidu.tieba.ala.liveroom.h.b gqx;
    private boolean gqy;
    private com.baidu.tieba.ala.liveroom.challenge.e gqz;
    private boolean gpE = false;
    private boolean gbT = false;
    private Handler mHandler = new Handler();
    private Handler gqe = new Handler();
    private boolean gqj = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver gqk = null;
    private boolean gql = false;
    private int gqm = 0;
    private int gqn = 0;
    private int gqo = 0;
    private long gqp = 0;
    private long gqq = 0;
    private volatile boolean isBackground = false;
    private Intent gqr = null;
    private int mOrientation = 1;
    private boolean glx = false;
    private boolean gqt = false;
    private boolean gqu = true;
    private boolean gdX = false;
    private boolean gqv = true;
    private boolean gqw = true;
    private int cOt = 0;
    private String otherParams = "";
    private int aXZ = 0;
    private int gqG = 5000;
    private boolean gqH = false;
    private Runnable gqJ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.fZL != null) {
                AlaMasterLiveRoomOpearator.this.fZL.xC();
            }
        }
    };
    private CustomMessageListener aYT = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gdS.glH != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gdS.glH.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.y(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener aYU = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gdS.glH != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gdS.glH.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener gco = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gbc == null) {
                        AlaMasterLiveRoomOpearator.this.gbc = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gbc.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener gcu = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gbJ != null) {
                AlaMasterLiveRoomOpearator.this.gbJ.CQ();
            }
        }
    };
    private CustomMessageListener gqK = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.r((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gcl = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Dt(str);
            }
        }
    };
    private CustomMessageListener gcm = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bcy();
        }
    };
    private CustomMessageListener gaL = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gbr.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gcs = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener gqL = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gqB != null) {
                q FO = AlaMasterLiveRoomOpearator.this.bFI().gla.FO();
                long j = FO.mLiveInfo.live_id;
                long j2 = FO.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.gqB.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener gqM = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bFI().glb);
            if (AlaMasterLiveRoomOpearator.this.gpF == null || AlaMasterLiveRoomOpearator.this.gpF.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.sc(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gbo != null) {
                AlaMasterLiveRoomOpearator.this.gbo.DC().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gbo.DD().hide();
            }
        }
    };
    private CustomMessageListener gct = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.q(AlaMasterLiveRoomOpearator.this.bFI().gla.FO());
        }
    };
    private CustomMessageListener gcv = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gbB != null) {
                    ((com.baidu.tieba.ala.liveroom.p.b) AlaMasterLiveRoomOpearator.this.gbB).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gqN = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gqC != null) {
                    AlaMasterLiveRoomOpearator.this.gqC.DO(str);
                }
            }
        }
    };
    private CustomMessageListener gqO = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.gqx != null) {
                        if (!data.auF || AlaMasterLiveRoomOpearator.this.gqE == null || !AlaMasterLiveRoomOpearator.this.gqF) {
                            if (AlaMasterLiveRoomOpearator.this.gqE != null && AlaMasterLiveRoomOpearator.this.gqE == data.auE) {
                                if (data.auy != null && data.auy.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.gqF || AlaMasterLiveRoomOpearator.this.gpF.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.gqx.a(AlaMasterLiveRoomOpearator.this.bFI().glA.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.gqy = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bFI().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.gqE = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bFI().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.gqx.a(AlaMasterLiveRoomOpearator.this.bFI().glA.getVideoConfig(), AlaMasterLiveRoomOpearator.this.gqy);
                        if (!AlaMasterLiveRoomOpearator.this.gqy) {
                            AlaMasterLiveRoomOpearator.this.gqy = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gqD) {
                    AlaMasterLiveRoomOpearator.this.bFI().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.gqD = false;
            }
        }
    };
    private CustomMessageListener gqP = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bFI().glA != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bFI().glA.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.c.vf().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener aYd = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.aXZ == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.aXZ == 6) {
                            AlaMasterLiveRoomOpearator.this.bJu();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.aXZ = 0;
            }
        }
    };
    private View.OnClickListener gqQ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.gpX) {
                    AlaMasterLiveRoomOpearator.this.bJy();
                    AlaMasterLiveRoomOpearator.this.gqg.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.gpW) {
                    if (view == AlaMasterLiveRoomOpearator.this.gpY) {
                        AlaMasterLiveRoomOpearator.this.bcy();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.gpZ) {
                        if (view != AlaMasterLiveRoomOpearator.this.gqb) {
                            if (view != AlaMasterLiveRoomOpearator.this.gdZ) {
                                if (view == AlaMasterLiveRoomOpearator.this.gqa && AlaMasterLiveRoomOpearator.this.gpJ != null) {
                                    ae bLx = AlaMasterLiveRoomOpearator.this.bFI().gla.bLx();
                                    if (bLx == null || bLx.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(bLx.mLiveSdkInfo.mRoomId);
                                        if (bLx.mLiveSdkInfo.mCastIds != null) {
                                            str2 = bLx.mLiveSdkInfo.mCastIds.ayO;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.gpJ.ai("", str, str2);
                                    return;
                                }
                                return;
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.gqz != null) {
                                AlaMasterLiveRoomOpearator.this.gqz.bFK();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.gqh != null) {
                            AlaMasterLiveRoomOpearator.this.gqh.showDialog();
                            AlaMasterLiveRoomOpearator.this.gqh.ce(AlaMasterLiveRoomOpearator.this.bJC());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.gqF = false;
                        AlaMasterLiveRoomOpearator.this.lM(true);
                        AlaMasterLiveRoomOpearator.this.gqc.setVisibility(4);
                        com.baidu.live.c.vf().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.v.a.Hs().aZn.aCd == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Hs().aZn.aCc == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.aXW) {
                        AlaMasterLiveRoomOpearator.this.bJu();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.aXZ = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bJu();
                }
            }
        }
    };
    private CustomMessageListener gcn = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof af) {
                    AlaMasterLiveRoomOpearator.this.gbT = true;
                    AlaMasterLiveRoomOpearator.this.gqd = (af) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gbo != null) {
                        AlaMasterLiveRoomOpearator.this.gbo.DC().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gbo != null) {
                        AlaMasterLiveRoomOpearator.this.gbo.DD().show();
                        AlaMasterLiveRoomOpearator.this.gbo.DD().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.sc(8);
                }
            }
        }
    };
    private CustomMessageListener gqR = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bFI() != null && AlaMasterLiveRoomOpearator.this.bFI().glF != null) {
                AlaMasterLiveRoomOpearator.this.bFI().glF.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bly = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bKj();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bFI().gla.sj(i);
                if (AlaMasterLiveRoomOpearator.this.gbJ != null) {
                    AlaMasterLiveRoomOpearator.this.gbJ.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener fYE = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bKc();
        }
    };
    public final HttpMessageListener gqS = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.FS()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.gqg != null) {
                            AlaMasterLiveRoomOpearator.this.gqg.lT(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.gqg.bKH();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bFI().glA.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.gpL != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.gpL.a(AlaMasterLiveRoomOpearator.this.bFI().glC, AlaMasterLiveRoomOpearator.this.bFI().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bFI().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.gpL.ss(2);
                        AlaMasterLiveRoomOpearator.this.gpL.a(AlaMasterLiveRoomOpearator.this.bFI().glC, string, 3);
                    }
                }
            }
        }
    };
    private e.a gqT = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bKp() {
            AlaMasterLiveRoomOpearator.this.sb(a.i.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bKq() {
            AlaMasterLiveRoomOpearator.this.sb(a.i.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a gqU = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean cI(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cJ(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bFI().bHw() == 1) {
                AlaMasterLiveRoomOpearator.this.bFI().glA.stopRecord();
            }
        }
    };
    private IShareCallback gqV = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.gqj && AlaMasterLiveRoomOpearator.this.gqi != null) {
                AlaMasterLiveRoomOpearator.this.gqj = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.gqi);
            }
        }
    };
    private View.OnTouchListener gqW = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bFI().glF.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bFI().glb);
            AlaMasterLiveRoomOpearator.this.sc(0);
            if (AlaMasterLiveRoomOpearator.this.gbo != null) {
                AlaMasterLiveRoomOpearator.this.gbo.DC().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.gbo.DD().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b gqX = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bKr() {
            AlaMasterLiveRoomOpearator.this.bJv();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bKs() {
            AlaMasterLiveRoomOpearator.this.gpm = AlaMasterLiveRoomOpearator.this.gpF.bHo();
            AlaMasterLiveRoomOpearator.this.bFI().glF.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bFI().glF.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bFI().glF.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.glu = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bFI().bHw();
            eVar.title = AlaMasterLiveRoomOpearator.this.gpF.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.glv = AlaMasterLiveRoomOpearator.this.gpF.bHp();
            eVar.gly = AlaMasterLiveRoomOpearator.this.gpm;
            eVar.glx = AlaMasterLiveRoomOpearator.this.gpF.bHm();
            eVar.glw = AlaMasterLiveRoomOpearator.this.gpF.bHr();
            eVar.glz = AlaMasterLiveRoomOpearator.this.gpF.bHn();
            if (eVar.glz) {
                if (AlaMasterLiveRoomOpearator.this.gpF.bHs()) {
                    AlaMasterLiveRoomOpearator.this.gqj = true;
                    AlaMasterLiveRoomOpearator.this.gqi = eVar;
                    AlaMasterLiveRoomOpearator.this.gpF.bHt();
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
            AlaMasterLiveRoomOpearator.this.bFI().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bFI().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bKt() {
            AlaMasterLiveRoomOpearator.this.gqF = true;
            AlaMasterLiveRoomOpearator.this.lM(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bKu() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bKv() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private Runnable gqY = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.bFI().gla != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO() != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo != null) {
                    com.baidu.live.utils.m.k(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.gqY, AlaMasterLiveRoomOpearator.this.gqG);
                }
            }
        }
    };
    private CustomMessageListener aVc = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bDY();
            }
        }
    };
    private com.baidu.live.liveroom.g.c gqZ = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void FM() {
            if (AlaMasterLiveRoomOpearator.this.gpJ != null) {
                AlaMasterLiveRoomOpearator.this.gpJ.mg(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bW(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.gqh != null) {
                        AlaMasterLiveRoomOpearator.this.gqh.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gqh != null) {
                    AlaMasterLiveRoomOpearator.this.gqh.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.gpJ != null) {
                    AlaMasterLiveRoomOpearator.this.gpJ.mg(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gbB != null) {
                    AlaMasterLiveRoomOpearator.this.gbB.bh(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a gra = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void RQ() {
            if (AlaMasterLiveRoomOpearator.this.gpV != null && AlaMasterLiveRoomOpearator.this.bFI().glC.indexOfChild(AlaMasterLiveRoomOpearator.this.gpV) >= 0) {
                AlaMasterLiveRoomOpearator.this.bFI().glC.removeView(AlaMasterLiveRoomOpearator.this.gpV);
                AlaMasterLiveRoomOpearator.this.gpV.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.gpV = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gaQ = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            q FO;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bKi();
            } else if (i == 14 && (FO = AlaMasterLiveRoomOpearator.this.bFI().gla.FO()) != null && FO.ayC != null && FO.mLiveInfo != null && FO.ayV != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity(), FO.ayC.userName, Long.toString(FO.ayC.userId), Long.toString(FO.ayC.charmCount), String.valueOf(FO.mLiveInfo.group_id), String.valueOf(FO.mLiveInfo.live_id), true, String.valueOf(FO.ayC.userId), Long.toString(FO.ayV.userId), FO.ayV.userName, FO.ayV.portrait, AlaMasterLiveRoomOpearator.this.gan.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(FO.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gan.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener grb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.bFI().gla != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO() != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aZu != null && !eventPollingHttpResponseMessage.aZu.isEmpty()) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.aZu.size(); i++) {
                            as asVar = eventPollingHttpResponseMessage.aZu.get(i);
                            if (j == asVar.liveId && j2 - asVar.createTime <= 60 && !com.baidu.live.utils.m.i(asVar.liveId, asVar.id)) {
                                com.baidu.live.utils.m.a(asVar, AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo, true);
                                AlaLiveInfoData alaLiveInfoData = AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo;
                                AlaMasterLiveRoomOpearator.this.a(asVar, alaLiveInfoData.feed_id, alaLiveInfoData.live_id, alaLiveInfoData.user_id);
                                com.baidu.live.utils.m.j(asVar.liveId, asVar.id);
                            }
                        }
                        as asVar2 = eventPollingHttpResponseMessage.aZu.get(eventPollingHttpResponseMessage.aZu.size() - 1);
                        if (j == asVar2.liveId) {
                            com.baidu.live.utils.m.h(asVar2.liveId, asVar2.id);
                        }
                    }
                }
                int i2 = eventPollingHttpResponseMessage.aZt;
                if (i2 <= 0) {
                    i2 = 5;
                }
                AlaMasterLiveRoomOpearator.this.gqG = i2 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a grc = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
    };
    private com.baidu.live.liveroom.middleware.g grd = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.att);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        gpC = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Hs().aZn != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bFI().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Hs().aZn.aBY, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dt(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bFI().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bFI().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Hs().aZn.aBy;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bFI().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bFI().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bFI().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDY() {
        int i = bFI().gla.FO().ayC.isUegBlock;
        int i2 = bFI().gla.FO().ayC.isBlock;
        String str = bFI().gla.FO().ayC.userName;
        if (i > 0 || i2 > 0) {
            this.aXW = true;
            this.gbo.a(true, i, i2, str);
            return;
        }
        this.aXW = false;
        this.gbo.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gdS.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aXg == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aXh);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gdS.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.gdS.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJu() {
        if (this.gbo != null) {
            this.gbo.DD().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.gqz != null) {
            this.gqz.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJv() {
        if (bFI() != null && bFI().gla != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bFI().gla.bLp();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bFI().gla.bLq();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.byS() != null && aVar.byT() != null) {
            bFI().gla.dM(aVar.byS().getId(), aVar.byT().getId());
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
                    AlaMasterLiveRoomOpearator.this.gql = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.gql = false;
                }
                if (AlaMasterLiveRoomOpearator.this.gqm == 0) {
                    AlaMasterLiveRoomOpearator.this.gqm = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.gqn == 0) {
                    AlaMasterLiveRoomOpearator.this.gqn = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.gqo = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bFI() != null && bFI().glD != null) {
            bFI().glD.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.gdS = fVar;
        this.fYt = str;
    }

    protected f bFI() {
        return this.gdS;
    }

    public int a(g gVar) {
        this.gea = gVar;
        this.gqk = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.gqk, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.gpL == null) {
            this.gpL = new com.baidu.tieba.ala.liveroom.tippop.a(this.gdS.pageContext, null);
        }
        registerListener();
        this.fZL = new com.baidu.live.g.a();
        bJM();
        bJw();
        bJx();
        Long[] lArr = new Long[1];
        this.gqp = lArr[0] == null ? 0L : lArr[0].longValue();
        this.gqq = lArr[0] != null ? lArr[0].longValue() : 0L;
        bFI().glb.setOnTouchListener(this.gqW);
        this.gpD = SharedPrefHelper.getInstance().getBoolean(gpC, false);
        this.gpN = new AlaLiveCountDownView(bFI().pageContext.getPageActivity());
        this.gpN.setCount(3);
        this.gpN.setTextColor(bFI().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.gpN.setTextSize(bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.gpN.setTypeface(Typeface.DEFAULT_BOLD);
        this.gpN.setIncludeFontPadding(false);
        this.gpN.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bKw() {
                if (AlaMasterLiveRoomOpearator.this.bFI().glb != null) {
                    AlaMasterLiveRoomOpearator.this.bFI().glb.removeView(AlaMasterLiveRoomOpearator.this.gpN);
                }
            }
        });
        return 1;
    }

    private void bJw() {
        CustomResponsedMessage runTask;
        if (this.gpM == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.j.a.class, bFI().pageContext)) != null && runTask.getData() != null) {
            this.gpM = (com.baidu.live.j.a) runTask.getData();
            this.gpM.c(bFI().pageContext);
        }
    }

    private void bJx() {
        View rootLayout;
        if (this.gpM != null && this.gpT != null && (rootLayout = this.gpM.bP(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gpT.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJy() {
        if (this.gqg == null) {
            this.gqg = new com.baidu.tieba.ala.liveroom.master.panel.b(bFI().pageContext.getPageActivity(), bFI().bHw() == 2);
            this.gqg.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lO(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bFI().glA.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lP(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bFI().glA.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lQ(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bFI().glA.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bKh();
                    if (AlaMasterLiveRoomOpearator.this.gpL != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.gpL.a(AlaMasterLiveRoomOpearator.this.bFI().glC, AlaMasterLiveRoomOpearator.this.bFI().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.gpL.a(AlaMasterLiveRoomOpearator.this.bFI().glC, AlaMasterLiveRoomOpearator.this.bFI().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lR(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bKx() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bFI().gla != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO() != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.gqg != null) {
                        AlaMasterLiveRoomOpearator.this.gqg.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bKy() {
                    if (AlaMasterLiveRoomOpearator.this.gqg != null) {
                        AlaMasterLiveRoomOpearator.this.gqg.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.h(AlaMasterLiveRoomOpearator.this.bFI().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bKz() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bFI() != null && AlaMasterLiveRoomOpearator.this.bFI().gla != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO() != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(AlaMasterLiveRoomOpearator.this.bFI().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.gqg != null) {
                            AlaMasterLiveRoomOpearator.this.gqg.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bKA() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bFI() == null || AlaMasterLiveRoomOpearator.this.bFI().gla == null || AlaMasterLiveRoomOpearator.this.bFI().gla.FO() == null || AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bFI() != null && AlaMasterLiveRoomOpearator.this.bFI().gla != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO() != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.gqg != null) {
                                        AlaMasterLiveRoomOpearator.this.gqg.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gdS.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.gqg != null) {
                        AlaMasterLiveRoomOpearator.this.gqg.dismiss();
                    }
                }
            });
        }
        bJz();
    }

    private void bJz() {
        if (this.gqg != null) {
            boolean isBackCamera = bFI().glA.isBackCamera();
            this.gqg.lS(bFI().glA.isBackCamera());
            this.gqg.K(bFI().glA.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bFI().glA.isPushMirror();
            if (this.gqu) {
                isPushMirror = bKg() || isPushMirror;
                this.gqu = false;
            }
            this.gqg.L(isPushMirror, isBackCamera ? false : true);
            this.gqg.lT(bFI().glA.isMute());
            this.gqg.bKH();
        }
    }

    public void bJA() {
        if (this.gea != null) {
            if (this.gea.glI == null || this.gea.glI.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.gpU == null) {
                        this.gpU = this.gdS.glH.Fv();
                        this.gdS.glC.addView(this.gpU, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.gpF == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bFI().gla != null && bFI().gla.FO() != null && bFI().gla.FO().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bFI().gla.FO().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bFI().gla.FO().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.gpF = new d(bFI().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bFI().glF.prepareTime = System.currentTimeMillis();
                    bFI().glC.addView(this.gpF.getView(), layoutParams);
                    this.gpF.a(this.gqV);
                }
                this.gpF.ly(this.glx);
                this.gpF.a(this.gqX);
                this.gpF.a(this.gqT);
                this.gpF.a(bFI().glA, bFI().bHw());
                this.gpF.a(this.gpM);
                return;
            }
            this.gpm = this.gea.glI.mLiveInfo.screen_direction == 2;
            if (this.gea.glI.mLiveInfo.isAudioOnPrivate == 1) {
                bFI().glA.setMute(true);
                if (this.gpL == null) {
                    this.gpL = new com.baidu.tieba.ala.liveroom.tippop.a(this.gdS.pageContext, null);
                }
                if (!this.gpL.sr(2)) {
                    this.gpL.a(bFI().glC, bFI().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.glu = true;
            eVar.forumId = String.valueOf(this.gea.glI.mLiveInfo.forum_id);
            eVar.forumName = this.gea.glI.mLiveInfo.forum_name;
            eVar.liveType = this.gea.glI.mLiveInfo.live_type;
            eVar.title = this.gea.glI.mLiveInfo.getLiveTitle();
            eVar.clarity = this.gea.glI.mLiveInfo.clarity;
            eVar.gameId = this.gea.glI.mLiveInfo.game_id;
            eVar.gameName = this.gea.glI.mLiveInfo.game_label;
            eVar.gly = this.gea.glI.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bJB() {
        if (this.gqx != null) {
            this.gqx.a(bFI().glA.getVideoConfig(), false);
        }
        if (this.gpF != null) {
            this.gpF.lx(true);
        }
        if (bFI().glA.hasBeauty() >= 0) {
            bFI().glA.setBeauty(com.baidu.live.c.vf().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bFI().glH.F(this.gdS.glA);
        } else if (this.gpF != null) {
            this.gpF.lx(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.gpU != null && this.gpU.getParent() != null) {
                ((ViewGroup) this.gpU.getParent()).removeView(this.gpU);
                this.gpU = null;
            }
            bFI().glb.setVisibility(0);
            this.gdS.glH.a(bFI().glb);
        } else {
            bJR();
            bKf();
            this.gpJ = new com.baidu.tieba.ala.liveroom.w.a(bFI().pageContext, this.gqU);
            this.gpJ.d(bFI().glb, true);
            this.gpJ.mg(true);
            if (this.gbo != null && this.gbo.DC() != null) {
                this.gbo.DC().setNeedTopAlphaShade(true);
            }
        }
        bFI().glA.setPushMirror(bKg());
    }

    public void b(ae aeVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gdS.glH.l(bFI().gla.FO());
        }
        if (!bFI().glA.isBackground() && bFI().gla.FO() != null && bFI().gla.FO().mLiveInfo != null) {
            int startPush = bFI().glA.startPush(bFI().gla.FO().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gdS.glH.Fw();
            }
            if (startPush != 0 && bFI().glF != null) {
                bFI().glF.errCode = 4;
                bFI().glF.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (aeVar != null && !aeVar.xp() && !bKd()) {
                lN(true);
                bKe();
            }
            if (this.gak != null) {
                this.gak.v(bFI().gla.FO());
            }
            if (this.gba != null) {
                this.gba.a(bFI().gla.FO());
            }
            if (this.gpM != null) {
                this.gpM.h(bFI().gla.FO());
                this.gpM.fz(this.otherParams);
            }
            if (this.gpH != null && bFI() != null && bFI().gla != null) {
                if (this.gpH.as(bFI().glb)) {
                    this.gpH.p(bFI().gla.FO());
                } else {
                    this.gpH.b(bFI().glb, bFI().gla.FO());
                }
            }
            if (this.gpG != null) {
                this.gpG.v(bFI().gla.FO());
            }
            if (aeVar == null || aeVar.ayC == null) {
                z = com.baidu.live.c.vf().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = aeVar.ayC.canUseChallenge;
                com.baidu.live.c.vf().putBoolean("ala_master_can_use_challenge", z);
            }
            bJS();
            bJF();
            lL(z);
            bDI();
            bJT();
            bJY();
            bEO();
            w(bFI().gla.FO());
            f(bFI().gla.FO());
            bJZ();
            bKa();
            bJW();
            bED();
            bEK();
            bEL();
            bJQ();
            if (this.gbn != null) {
                this.gbn.g(bFI().gla.FO());
            }
            if (this.gbo != null) {
                if (bFI().gla.FO() != null && bFI().gla.FO().azi != null && bFI().gla.FO().azi.wQ()) {
                    z2 = true;
                }
                this.gbo.a(String.valueOf(bFI().gla.FO().mLiveInfo.group_id), String.valueOf(bFI().gla.FO().mLiveInfo.last_msg_id), String.valueOf(bFI().gla.FO().ayC.userId), String.valueOf(bFI().gla.FO().mLiveInfo.live_id), bFI().gla.FO().ayC.appId, z2);
            }
            if (this.gbp != null) {
                this.gbp.a(bFI().gla.FO(), true);
            }
            if (!this.gqH && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.gqH = true;
                this.mHandler.post(this.gqY);
            }
            this.mHandler.post(this.gqJ);
        }
    }

    private void bDI() {
        if (this.bcj == null) {
            this.bcj = new PendantParentView(bFI().pageContext.getPageActivity(), this.gcG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bFI().glb.addView(this.bcj, layoutParams);
            this.bcj.setDefaultItemMargin(bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bcj.setPadding(bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bFq();
        }
    }

    private void bFq() {
        if (this.bcj != null) {
            int dimensionPixelSize = bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278);
            int dimensionPixelSize2 = bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bcj.getLayoutParams();
            if (this.gcG) {
                this.bcj.setPosition(0, 0, this.gqz.bFt(), dimensionPixelSize2);
            } else {
                this.bcj.setPosition(dimensionPixelSize, 0, bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278), dimensionPixelSize2);
            }
            this.bcj.setLayoutParams(layoutParams);
            this.bcj.setModel(this.gcG ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bFr() {
        if (this.gbo != null && this.gbo.DC() != null && this.gbo.DC().getView() != null) {
            if (this.gcG) {
                int screenHeight = (ScreenHelper.getScreenHeight(bFI().pageContext.getPageActivity()) - (this.gqz != null ? this.gqz.aZ(false) : 0)) - bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                ViewGroup.LayoutParams layoutParams = this.gbo.DC().getView().getLayoutParams();
                if (layoutParams != null && layoutParams.height > 0 && layoutParams.height >= screenHeight) {
                    layoutParams.height = screenHeight;
                    this.gbo.DC().getView().setLayoutParams(layoutParams);
                    return;
                }
            }
            int ct = com.baidu.live.aa.a.ct(this.gpE);
            if (bFI().glb.indexOfChild(this.gbo.DC().getView()) != -1 && this.gbo.DC().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gbo.DC().getView().getLayoutParams();
                layoutParams2.height = ct;
                this.gbo.DC().getView().setLayoutParams(layoutParams2);
            }
            this.gbo.DC().DB();
        }
    }

    private void lL(boolean z) {
        if (this.gqz == null) {
            this.gqz = new com.baidu.tieba.ala.liveroom.challenge.e(bFI());
        }
        this.gqz.a(this.gdZ, this.gea);
        this.gqz.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(an anVar, ar arVar, ar arVar2) {
                AlaMasterLiveRoomOpearator.this.gcG = true;
                AlaMasterLiveRoomOpearator.this.bFI().glb.gzz = false;
                if (AlaMasterLiveRoomOpearator.this.gqh != null) {
                    AlaMasterLiveRoomOpearator.this.gqh.cQ(4);
                    AlaMasterLiveRoomOpearator.this.gqh.ce(true);
                }
                AlaMasterLiveRoomOpearator.this.bJD();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void wi() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gqJ);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bFG() {
                AlaMasterLiveRoomOpearator.this.gcG = false;
                AlaMasterLiveRoomOpearator.this.bFI().glb.gzz = false;
                if (AlaMasterLiveRoomOpearator.this.gqh != null) {
                    AlaMasterLiveRoomOpearator.this.gqh.cQ(0);
                    AlaMasterLiveRoomOpearator.this.gqh.ce(false);
                }
                AlaMasterLiveRoomOpearator.this.bJE();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bFH() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gqJ);
            }
        });
        this.gqz.H(this.gpm, z);
        this.gqz.h(this.gpm, z, (this.gea == null || this.gea.glI == null || this.gea.glI.mChallengeData == null) ? false : true);
    }

    public boolean bJC() {
        return this.gqz != null && this.gqz.bFM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJD() {
        if (this.gpK != null) {
            this.gpK.setVisible(8);
            this.gpK.setCanVisible(false);
        }
        if (this.gaq != null) {
            this.gaq.la(true);
        }
        if (this.gpO != null) {
            this.gpO.setCanVisible(false);
            this.gpO.setVisibility(4);
        }
        if (this.gpJ != null) {
            this.gpJ.mf(false);
        }
        if (this.gbo != null) {
            this.gbo.DC().setNeedTopAlphaShade(false);
        }
        bFq();
        bFr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJE() {
        if (this.gpK != null) {
            this.gpK.setCanVisible(true);
        }
        if (this.gaq != null) {
            this.gaq.la(false);
        }
        if (this.gpO != null) {
            this.gpO.setCanVisible(true);
        }
        if (this.gpJ != null) {
            this.gpJ.mf(true);
        }
        if (this.gbo != null) {
            this.gbo.DC().setNeedTopAlphaShade(false);
        }
        bFq();
        bFr();
    }

    private void bJF() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.gpO == null) {
            this.gpO = new AlaLiveStreamStatusView(bFI().pageContext.getPageActivity());
        }
        this.gpO.setId(a.g.ala_live_room_stream_view);
        this.gpO.setVisibility(4);
        this.gpO.setLayoutParams(layoutParams);
        if (this.gpO.getParent() == null) {
            bFI().glb.addView(this.gpO, layoutParams);
        }
    }

    public void bJG() {
        if (this.gpF != null && this.gpF.getVisibility() != 8 && bFI().glA.getPreview() != null) {
            bFI().glA.stopRecord();
        }
    }

    public void bJH() {
        if (bFI().glA.getPreview() != null) {
            bFI().glA.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gqx != null) {
                this.gqx.lw(false);
            }
            this.gqx = new com.baidu.tieba.ala.liveroom.h.b(bFI().glC, bFI(), bFI().glA);
            this.gqx.a(bFI().glA.getVideoConfig(), false);
        }
        if (this.gpL != null) {
            this.gpL.bMG();
        }
        this.mHandler.post(this.gqJ);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gpE = z;
        if (z) {
            if (this.gqw) {
                this.gqw = false;
                if (this.gbo != null && this.gbo.DC() != null) {
                    this.gbo.DC().getView().setBottom(0);
                }
                if (this.gbo != null && this.gbo.DD() != null) {
                    this.gbo.DD().getView().setBottom(0);
                }
            }
            if (this.gbo != null && this.gbo.DC() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gbo.DC().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.gbo.DC().getView().setLayoutParams(layoutParams);
            }
            if (this.gbo != null && this.gbo.DD() != null && this.gbo.DD().getView() != null && this.gbo.DD().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gbo.DD().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gbo.DD().getView().setLayoutParams(layoutParams2);
                this.gbo.DD().getView().setVisibility(0);
                this.gbo.DD().Fa();
            }
            sc(8);
            sa(8);
        } else {
            if (this.gbo != null && this.gbo.DC() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gbo.DC().getView().getLayoutParams();
                layoutParams3.bottomMargin = bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gbo.DC().getView().setLayoutParams(layoutParams3);
            }
            if (this.gbo != null && this.gbo.DD() != null) {
                this.gbo.DD().hide();
            }
            sc(0);
            sa(0);
        }
        if (this.gpF != null) {
            this.gpF.J(false, z);
        }
        if (this.gbp != null) {
            this.gbp.vC();
        }
        if (this.gqh != null) {
            this.gqh.onKeyboardVisibilityChanged(z);
        }
        bFr();
        this.mHandler.post(this.gqJ);
    }

    private void sa(int i) {
        if (this.gak != null) {
            this.gak.rO(i);
        }
        if (this.gpQ != null) {
            this.gpQ.setVisibility(i);
        }
        if (this.gba != null) {
            this.gba.getView().setVisibility(i);
        }
        if (this.gpI != null) {
            this.gpI.setVisible(i);
        }
        if (this.gpH != null) {
            this.gpH.setVisibility(i);
        }
        if (this.gaq != null) {
            this.gaq.setVisible(i);
        }
        if (this.gbM != null) {
            this.gbM.setCanVisible(i == 0);
        }
        if (this.gbz != null) {
            this.gbz.setVisible(i);
        }
        if (this.gbJ != null) {
            this.gbJ.setCanVisible(i == 0);
        }
        if (this.gqA != null) {
            this.gqA.setCanVisible(i == 0);
            this.gqA.refreshUI();
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bFI().glF.errCode = 1;
            sb(a.i.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            sb(a.i.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            sb(a.i.stream_upload_exception);
        } else if (i == -2) {
            DJ(bFI().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bFI().glA.stopRecord();
        } else if (i == -3 && this.gpF != null) {
            this.gpF.lx(false);
        }
        if (i == -4) {
            if (this.gpF == null || this.gpF.getView().getParent() == null) {
                bFI().f((short) 1);
                return;
            }
            this.gpF.bHq();
            this.gpZ.setVisibility(0);
            if (this.gpJ != null) {
                this.gpJ.mg(true);
            }
            bFI().glb.setBackgroundColor(bFI().pageContext.getResources().getColor(17170445));
            bKm();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bFc();
        if (i == 12001) {
            if (i2 == -1) {
                DK(M(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                N(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            bcy();
        }
    }

    public void onResume() {
        if (this.gpF != null) {
            this.gpF.onResume();
        }
        if (this.gqj && this.gqi != null) {
            this.gqj = false;
            c(this.gqi);
        }
        if (this.gbB != null) {
            this.gbB.onResume();
        }
    }

    public void g(short s) {
        if (this.gbn != null) {
            this.gbn.zy();
        }
        if (this.gbo != null) {
            this.gbo.a(null);
            this.gbo.vD();
        }
        if (this.gbp != null) {
            this.gbp.vD();
        }
        if (this.gqz != null) {
            this.gqz.bFL();
        }
    }

    public boolean bJI() {
        q FO = bFI().gla.FO();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gdS.glH.k(FO);
            if (FO != null && FO.mLiveInfo.live_status != 1) {
                bKk();
                bFI().pageContext.getPageActivity().finish();
                if (bFI().gla != null && bFI().gla.FO() != null) {
                    a(FO, 1, bFI().gla.bLH() != 1 ? bFI().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gbo != null) {
                this.gbo.DC().a(String.valueOf(FO.mLiveInfo.group_id), String.valueOf(FO.mLiveInfo.live_id), true, String.valueOf(FO.ayC.userId));
            }
            if (this.gbp != null) {
                this.gbp.a(FO);
            }
            if (this.gba != null) {
                this.gba.a(bFI().gla.FO());
            }
            if (this.gak != null) {
                this.gak.v(FO);
            }
            if (FO != null) {
                if (this.gqz != null) {
                    this.gqz.a(FO);
                }
                if (this.gbr != null && FO.mLiveInfo != null) {
                    this.gbr.a(FO.mLiveInfo, FO.ayC);
                }
                if (this.gbM != null) {
                    this.gbY = this.gbM.o(FO);
                }
                if (this.gaq != null) {
                    this.gaq.lb(this.gbY);
                    this.gaq.j(FO);
                    this.gaq.updateView();
                }
                if (this.gbJ != null) {
                    this.gbJ.a(FO);
                }
                if (FO.mLiveInfo.live_status != 1) {
                    bKk();
                    bFI().pageContext.getPageActivity().finish();
                    if (bFI().gla != null && bFI().gla.FO() != null) {
                        a(FO, 1, bFI().gla.bLH() != 1 ? bFI().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.gpM != null) {
                    this.gpM.i(FO);
                }
            }
        }
        return false;
    }

    public void bJJ() {
        bJz();
    }

    public void bJK() {
        if (this.gqx != null) {
            this.gqx.bHk();
        }
    }

    public void bJL() {
        if (this.gpF != null && this.gpF.getVisibility() != 8) {
            if (bFI().bHw() == 2) {
                bKm();
            } else {
                bKl();
            }
        }
        if (this.gpF != null && this.gpF.getVisibility() != 8) {
            if (bFI().bHw() == 1) {
                this.gpF.onResume();
            }
            this.gpF.onRefresh();
        }
        if (this.gpM != null) {
            this.gpM.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.gbT && this.gqd != null) {
            if (this.gbo != null) {
                this.gbo.DC().getView().setVisibility(0);
            }
            if (this.gbo != null) {
                this.gbo.DD().show();
                this.gbo.DD().setEditText(" @" + this.gqd.getNameShow() + " ");
            }
            sc(8);
            this.gbT = false;
        }
        if (this.gqB != null) {
            this.gqB.resume();
        }
        if (this.gqC != null) {
            this.gqC.resume();
        }
    }

    public void onPause() {
        if (this.gpM != null) {
            this.gpM.onPause();
        }
        if (this.gqB != null) {
            this.gqB.pause();
        }
        if (this.gbB != null) {
            this.gbB.onPause();
        }
        if (this.gqC != null) {
            this.gqC.pause();
        }
    }

    private void bJM() {
        this.gpP = (RelativeLayout) bFI().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.gpR = (RelativeLayout) bFI().rootView.findViewById(a.g.under_live_view_panel);
        this.gpS = (RelativeLayout) bFI().rootView.findViewById(a.g.over_live_view_panel);
        this.gpT = (FrameLayout) bFI().rootView.findViewById(a.g.goods_parent);
        this.gdS.glb.setOnLiveViewScrollListener(this.gqZ);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gpR.setVisibility(8);
            this.gpS.setVisibility(8);
            bFI().glb.removeAllViews();
            return;
        }
        this.gpQ = (RelativeLayout) bFI().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gpQ.getLayoutParams();
        layoutParams.topMargin = this.gdS.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.gdS.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.gpQ.setLayoutParams(layoutParams);
        if (this.gan == null) {
            this.gan = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gdS.pageContext.getPageActivity(), false);
        }
        this.gan.a(this.gaQ);
        this.gan.a(this.gpQ, a.g.ala_live_room_host_header_stub, 1L);
        this.gan.setVisible(0);
        this.gpZ = (ImageView) bFI().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.gqc = (TextView) bFI().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn_num);
        this.gpZ.setOnClickListener(this.gqQ);
        this.gqb = (ImageView) bFI().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.gqb.setOnClickListener(this.gqQ);
        if (com.baidu.live.v.a.Hs().beo != null && com.baidu.live.v.a.Hs().beo.aEm != null && com.baidu.live.v.a.Hs().beo.aEm.xt() && ba.b(com.baidu.live.v.a.Hs().beo)) {
            this.gqb.setVisibility(0);
        } else {
            this.gqb.setVisibility(8);
        }
        if (ba.c(com.baidu.live.v.a.Hs().beo)) {
            this.gpZ.setVisibility(0);
            if (ba.c(com.baidu.live.v.a.Hs().beo)) {
                this.gpZ.setAlpha(0.2f);
            }
        } else if (bFI().glA.hasBeauty() < 0) {
            this.gpZ.setVisibility(8);
        } else {
            if (ba.c(com.baidu.live.v.a.Hs().beo)) {
                this.gpZ.setAlpha(0.2f);
            }
            com.baidu.live.c.vf().getInt("live_beauty_level", 3);
        }
        this.gpY = (ImageView) bFI().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.gpY.setOnClickListener(this.gqQ);
        this.gpW = (ImageView) bFI().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.gpW.setOnClickListener(this.gqQ);
        this.gdZ = (ImageView) bFI().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.gdZ.setOnClickListener(this.gqQ);
        this.gpX = (ImageView) bFI().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.gpX.setOnClickListener(this.gqQ);
        this.gqa = (ImageView) bFI().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.gqa.setOnClickListener(this.gqQ);
        bJP();
        if (ba.b(com.baidu.live.v.a.Hs().beo)) {
            this.gqx = new com.baidu.tieba.ala.liveroom.h.b(bFI().glC, bFI(), bFI().glA);
        }
        this.gbn = new m();
        bJN();
        bJO();
        if (com.baidu.live.c.vf().getInt("beauty_new_bubble", 1) == 1) {
            this.gqc.setVisibility(0);
        }
    }

    private void bJN() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bFI().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gbo = (k) runTask.getData();
            this.gbo.setFromMaster(true);
            this.gbo.DC().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bFI().pageContext.getPageActivity()) * 0.75f), com.baidu.live.aa.a.ct(false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.aa.a.cu(true);
            bFI().glb.addView(this.gbo.DC().getView(), layoutParams);
            this.gbo.DD().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bFI().glb.addView(this.gbo.DD().getView(), layoutParams2);
            this.gbo.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                @Override // com.baidu.live.im.k.a
                public boolean DF() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void DG() {
                }

                @Override // com.baidu.live.im.k.a
                public void fv(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void DH() {
                }

                @Override // com.baidu.live.im.k.a
                public void DI() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean DJ() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int DK() {
                    return 0;
                }
            });
        }
    }

    private void bJO() {
        View vB;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bFI().pageContext);
        if (runTask != null) {
            this.gbp = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gbp != null && (vB = this.gbp.vB()) != null && this.gdS.glb.indexOfChild(vB) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gdS.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bFI().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bFI().glb.addView(vB, layoutParams);
        }
    }

    private void bJP() {
        CustomResponsedMessage runTask;
        if (this.gqf == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bFI().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gqf = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bJQ() {
        View za;
        v.b(bFI().pageContext, true);
        if (this.gbq == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aHx = true;
            fVar.context = bFI().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gbq = (w) runTask.getData();
                if (this.gbq != null && (za = this.gbq.za()) != null && bFI().glb.indexOfChild(za) < 0) {
                    if (za.getParent() instanceof ViewGroup) {
                        ((ViewGroup) za.getParent()).removeView(za);
                    }
                    bFI().glb.addView(za, bFI().glb.getLayoutParams());
                }
            }
        }
    }

    protected void bEL() {
        View zs;
        if (this.gbr == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aHx = true;
            aVar.context = bFI().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gbr = (u) runTask.getData();
            }
        }
        if (this.gbr != null && (zs = this.gbr.zs()) != null) {
            if (bFI().glb.indexOfChild(zs) < 0) {
                if (zs.getParent() instanceof ViewGroup) {
                    ((ViewGroup) zs.getParent()).removeView(zs);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bFI().glb.addView(zs, layoutParams);
            }
            zs.bringToFront();
        }
    }

    protected void bEK() {
        View zz;
        if (this.gbB == null) {
            ab abVar = new ab();
            abVar.aHx = true;
            abVar.pageContext = bFI().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.gbB = (y) runTask.getData();
            }
        }
        if (this.gbB != null && (zz = this.gbB.zz()) != null && bFI().glb.indexOfChild(zz) < 0) {
            if (zz.getParent() instanceof ViewGroup) {
                ((ViewGroup) zz.getParent()).removeView(zz);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bFI().glb.addView(zz, layoutParams);
        }
    }

    private void bJR() {
        bJV();
        bDL();
        bJU();
        bFI().glb.setVisibility(0);
        sc(0);
    }

    private void bJS() {
        if (this.gpI == null) {
            this.gpI = new com.baidu.tieba.ala.liveroom.t.a(bFI().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gpI.a(bFI().bHw(), j, TbadkCoreApplication.getCurrentAccountName(), true, bFI().gla.FO().ayC.portrait, this.otherParams, "", -1L);
        this.gpI.ar(bFI().glb);
    }

    private void bJT() {
        if (this.gqh == null) {
            bFI().glb.gzz = false;
            com.baidu.live.w.a eE = eE(bFI().pageContext.getPageActivity());
            if (eE != null) {
                this.gqh = eE;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bFI().pageContext.getPageActivity());
                if (runTask != null) {
                    this.gqh = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.gqh != null) {
                this.gqh.p(this.gpR);
                this.gqh.q(this.gpS);
                this.gqh.cP((bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bFI().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                this.gqh.r(bFI().glb);
                this.gqh.a(this.fZL);
                this.gqh.setLiveShowInfo(bFI().gla.FO());
                this.gqh.a(this.gaq);
                this.gqh.HD();
                this.gqh.a(new a.InterfaceC0194a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // com.baidu.live.w.a.InterfaceC0194a
                    public void HE() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0194a
                    public void HF() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0194a
                    public void G(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bFI().glA != null) {
                            AlaMasterLiveRoomOpearator.this.bFI().glA.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0194a
                    public int HG() {
                        return AlaMasterLiveRoomOpearator.this.gpQ.getBottom();
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0194a
                    public int HH() {
                        return AlaMasterLiveRoomOpearator.this.gdS.glb.getHeight() - (AlaMasterLiveRoomOpearator.this.gbo.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gbo.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0194a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gbo.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0194a
                    public int HI() {
                        return AlaMasterLiveRoomOpearator.this.gbo.DE();
                    }
                });
            }
        }
    }

    private com.baidu.live.w.a eE(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aq(context);
        }
        return null;
    }

    private void bJU() {
        if (this.gpK == null) {
            this.gpK = new b(bFI().pageContext, bFI().glb);
        }
    }

    private void bJV() {
        if (this.gak == null) {
            this.gak = new com.baidu.tieba.ala.liveroom.n.a(bFI().pageContext, true, this.gqU);
            this.gak.c(this.gpP, (q) null);
            this.gak.a(this.gaQ);
        }
        if (this.gpG == null) {
            this.gpG = new com.baidu.tieba.ala.liveroom.n.a(bFI().pageContext, true, null);
            this.gpG.a(this.gpQ, null, a.g.ala_live_room_host_header_stub);
            this.gpG.bIK();
        }
    }

    protected void bEu() {
        CustomResponsedMessage runTask;
        boolean z = false;
        ae bLx = bFI().gla.bLx();
        boolean z2 = com.baidu.live.v.a.Hs().aZn.aBX;
        if (bLx == null || bLx.azg) {
            z = z2;
        }
        if (z && this.gba == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bFI().pageContext)) != null) {
            this.gba = (com.baidu.live.h.a) runTask.getData();
            if (this.gba != null) {
                this.gba.setIsHost(true);
                this.gba.cF(1);
                View view = this.gba.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bFI().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bFI().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.gpQ.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(q qVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gaq == null) {
            this.gaq = new com.baidu.tieba.ala.liveroom.activeview.b(bFI().pageContext);
        }
        this.gaq.setOtherParams(this.otherParams);
        this.gaq.b(qVar, false);
        this.gaq.setHost(true);
        this.gaq.a(1, this.bcj);
        this.gaq.a(2, this.bcj);
        this.gaq.lb(this.gbY);
        this.gaq.setVisible(this.gpE ? 8 : 0);
        this.gaq.a(this.fZL);
        if (this.fZL != null) {
            if (this.gaq != null) {
                alaActiveRootView2 = this.gaq.rz(1);
                alaActiveRootView = this.gaq.rz(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.fZL.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.fZL.a(alaActiveRootView);
            }
        }
    }

    private void w(q qVar) {
        CustomResponsedMessage runTask;
        if (this.gbM == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bFI().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.r.a)) {
            this.gbM = (com.baidu.live.r.a) runTask.getData();
            if (this.gbM != null) {
                this.gbM.o(this.bcj);
            }
        }
        if (this.gbM != null) {
            this.gbY = this.gbM.o(qVar);
            this.gbM.setCanVisible(!this.gpE);
        }
    }

    protected void bJW() {
        CustomResponsedMessage runTask;
        if (bFI() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bFI().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gbJ = (com.baidu.live.i.a) runTask.getData();
            this.gbJ.a(bFI().glb, bJX());
            if (bFI().gla != null) {
                this.gbJ.a(bFI().gla.FO());
            }
            this.gbJ.setCanVisible(true);
            this.gbJ.bF(false);
            this.gbJ.a(bFI().gla.bzs());
        }
    }

    private void bED() {
        this.gqC = new com.baidu.tieba.ala.liveroom.p.c(bFI().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bJX() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bFI().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.gbz != null && this.gbz.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.gpI != null && this.gpI.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void bDL() {
        if (this.gpH == null) {
            this.gpH = new com.baidu.tieba.ala.liveroom.b.a(bFI().pageContext, true);
        }
    }

    private void bJY() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bFI().pageContext.getPageActivity();
            if (this.gcX == null) {
                this.gcX = new ImageView(pageActivity);
                this.gcX.setId(a.g.master_close_btn);
                this.gcX.setTag("master_close_btn");
                this.gcX.setImageResource(a.f.sdk_icon_bar_live_close_n);
                this.gcX.setBackgroundResource(a.f.sdk_round_btn_close_bg);
                this.gcX.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            }
            if (this.gcX.getParent() != null) {
                ((ViewGroup) this.gcX.getParent()).removeView(this.gcX);
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
            bFI().glC.addView(this.gcX, layoutParams);
            this.gcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bKi();
                }
            });
            this.gcX.setVisibility(8);
        }
    }

    private void bEO() {
        if (this.gbz == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bFI().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gbz = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.gbz.setHost(true);
        this.gbz.setOtherParams(this.otherParams);
        if (bFI().gla.FO() != null && bFI().gla.FO().ayC != null && bFI().gla.FO().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.gbz.a(bFI().glb, layoutParams, bFI().gla.FO());
        }
    }

    private void bJZ() {
        CustomResponsedMessage runTask;
        if (this.gqA == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bFI().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.gqA = (com.baidu.live.b.a) runTask.getData();
            if (this.gqA != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bFI().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gqA.a(bFI().glb, layoutParams);
            }
        }
        if (this.gqA != null) {
            this.gqA.a(bFI().gla.FO());
        }
    }

    private void bKa() {
        CustomResponsedMessage runTask;
        if (this.gqB == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bFI().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.gqB = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gqz != null) {
            this.gqz.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bFI().pageContext.registerListener(this.gcl);
        bFI().pageContext.registerListener(this.gqK);
        bFI().pageContext.registerListener(this.gcn);
        bFI().pageContext.registerListener(this.gco);
        bFI().pageContext.registerListener(this.gqR);
        bFI().pageContext.registerListener(this.bly);
        bFI().pageContext.registerListener(this.fYE);
        bFI().pageContext.registerListener(this.gqS);
        bFI().pageContext.registerListener(this.gcm);
        bFI().pageContext.registerListener(this.gaL);
        bFI().pageContext.registerListener(this.grb);
        bFI().pageContext.registerListener(this.gcs);
        bFI().pageContext.registerListener(this.gqO);
        bFI().pageContext.registerListener(this.gqP);
        bFI().pageContext.registerListener(this.gqL);
        bFI().pageContext.registerListener(this.aYT);
        bFI().pageContext.registerListener(this.aYU);
        bFI().pageContext.registerListener(this.gqM);
        bFI().pageContext.registerListener(this.gcu);
        bFI().pageContext.registerListener(this.gct);
        bFI().pageContext.registerListener(this.gcv);
        bFI().pageContext.registerListener(this.gqN);
        bFI().pageContext.registerListener(this.gqM);
        bFI().pageContext.registerListener(this.aYd);
        bFI().pageContext.registerListener(this.aVc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lM(boolean z) {
        if (ba.c(com.baidu.live.v.a.Hs().beo)) {
            bFI().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bFI().glE.vv() == null || ListUtils.isEmpty(bFI().glE.vv().auy)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bFI().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.gqD) {
                this.gqE = BdUniqueId.gen();
                bFI().glE.a(this.gqE);
                this.gqD = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bFI().pageContext.getPageActivity(), bFI().rootView);
            sc(8);
            if (bFI().glA.hasAdvancedBeauty() && this.gqx != null) {
                if (!this.gqF || this.gpF.getVisibility() == 0) {
                    this.gqx.a(bFI().glA.getVideoConfig());
                }
                this.gqx.a(bFI().glA.getVideoConfig(), this.gqy);
                if (!this.gqy) {
                    this.gqy = true;
                }
            }
            if (z && this.gbo != null) {
                this.gbo.DC().getView().setVisibility(4);
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
    public void sb(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bFI().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bFI().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bFI().f((short) 1);
            }
        });
        bdAlertDialog.create(bFI().pageContext).show();
    }

    private void DJ(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bFI().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bFI().f((short) 1);
            }
        });
        bdAlertDialog.create(bFI().pageContext).show();
    }

    public void bKb() {
        bEu();
        com.baidu.live.data.k bzs = bFI().gla.bzs();
        int i = 5;
        if (bzs != null) {
            i = (int) bzs.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bFI().gla.FO() != null && AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bFI().gla.f(AlaMasterLiveRoomOpearator.this.bFI().gla.FO().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bzs != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gdS.glH.b(bzs);
                return;
            }
            if (this.gaj == null) {
                this.gaj = new c(bFI().pageContext, this.gqU, true);
            }
            if (this.gqv) {
                this.gqv = false;
                this.gaj.a(String.valueOf(bFI().gla.FO().mLiveInfo.group_id), String.valueOf(bFI().gla.FO().mLiveInfo.live_id), String.valueOf(bFI().gla.FO().ayC.userId), bFI().gla.FO());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.gba != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.gaj.c(this.gpQ, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.gaj.e(bzs);
            this.gan.setVisible(0);
            this.gan.dD(bzs.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKc() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcy() {
        if (bFI().gla != null) {
            if (this.gbb == null) {
                this.gbb = new com.baidu.tieba.ala.liveroom.share.c(bFI().pageContext);
            }
            this.gbb.c(bFI().gla.FO(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bFI().gla != null && bFI().gla.FO() != null && bFI().gla.FO().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bFI().gla.FO().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bFI().gla.FO().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bFI().gla.FO().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bFI().gla != null && bFI().gla.FO() != null && bFI().gla.FO().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bFI().gla.FO().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bFI().gla.FO().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bFI().gla.FO().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bKd() {
        return this.gpD;
    }

    private void lN(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(gpC, z);
        this.gpD = z;
    }

    private void bKe() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bFI().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.o.a(AlaMasterLiveRoomOpearator.this.bFI().pageContext).bLe();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bFI().pageContext).show();
    }

    private void bKf() {
        if (this.gpm && bFI().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bFI().glG.Io();
        }
        bFI().glF.prepareTime = System.currentTimeMillis() - bFI().glF.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bFI().gla != null && bFI().gla.FO() != null && bFI().gla.FO().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bFI().gla.FO().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bFI().gla.FO().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bFI().glF.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gpF != null && this.gpF.getView().getParent() != null) {
            this.gpF.setVisibility(8);
            bFI().glC.removeView(this.gpF.getView());
            this.gpF.release();
        }
        if (this.gqx != null) {
            this.gqx.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bFI().glb.indexOfChild(this.gpN) < 0) {
            bFI().glb.addView(this.gpN, layoutParams);
        }
        this.gpN.st(1000);
    }

    private void bFc() {
        if (bFI().bHw() == 1) {
            bFI().glA.startRecord();
        }
    }

    private void DK(String str) {
        DL(str);
    }

    private void DL(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bFI().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String M(Intent intent) {
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

    private void N(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.gpF != null) {
            this.gpF.Dy(fromJson.getSmallurl());
        }
    }

    private boolean bKg() {
        return com.baidu.live.c.vf().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKh() {
        com.baidu.live.c.vf().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.gdS.glA.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKi() {
        int i = a.i.live_close_confirm;
        if (this.gqz != null && this.gqz.bFN()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.gqz != null && this.gqz.bFM()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bFI().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(i);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                }
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomOpearator.this.bFI().gla.FO() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bFI().gla.FO(), 0, AlaMasterLiveRoomOpearator.this.bFI().gla.bLH() != 1 ? AlaMasterLiveRoomOpearator.this.bFI().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                } else {
                    AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bFI().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (qVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = qVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = qVar.ayC;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bFI().gla.dO(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.gqt) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bFI().glF;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bFI().glA.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.gqp;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.gqq;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.gql;
            if (this.gqm != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.gqn - this.gqo) / this.gqm) * 100.0f;
            }
            Intent intent = new Intent(bFI().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bFI().gla != null && bFI().gla.FO() != null && bFI().gla.FO().ayC != null) {
                String str3 = bFI().gla.FO().ayC.nickName;
                String str4 = bFI().gla.FO().ayC.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            q FO = bFI().gla.FO();
            if (FO != null && FO.ayC != null && !TextUtils.isEmpty(FO.ayC.portrait)) {
                intent.putExtra("host_portrait", FO.ayC.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.gqr = intent;
                this.gqs = s;
                bFI().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bKj() {
        if (this.gqr != null) {
            a(this.gqr, this.gqs);
            this.gqr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.gqt = true;
        if (this.gqz != null) {
            this.gqz.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.fYt);
            bFI().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bFI().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKk() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gdS.glH != null && this.gdS.glH.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.gqz != null && this.gqz.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bFI().glD.bKP()) {
                bKi();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.gpO != null) {
                this.gpO.setVisibility(4);
                return;
            }
            return;
        }
        if (this.gpO != null) {
            this.gpO.a(i, z, i2, z2);
        }
        if (this.gdS != null && this.gdS.gla != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cOt != i3) {
                this.cOt = i3;
                if (this.gpL == null) {
                    this.gpL = new com.baidu.tieba.ala.liveroom.tippop.a(this.gdS.pageContext, null);
                }
                switch (this.cOt) {
                    case 0:
                        this.gpL.a(this.gdS.glC, this.gdS.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.gpL.a(this.gdS.glC, this.gdS.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.gpL.a(this.gdS.glC, this.gdS.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gdS.gla.k(this.gdS.gla.FO().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void y(com.baidu.live.im.data.a aVar) {
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
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bKk();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bFI().gla.FO(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0638, code lost:
        Dq(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        String str;
        String str2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        final String str3;
        String str4;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        long j;
        long j2;
        long j3;
        String str5;
        String str6;
        if (aVar.getMsgType() == 125) {
            if (this.gpJ != null) {
                this.gpJ.A(aVar);
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
                            str3 = optString2;
                            str4 = optString;
                        } catch (JSONException e) {
                            jSONObject = jSONObject4;
                            str = optString2;
                            str2 = optString;
                            jSONObject2 = jSONObject;
                            jSONObject3 = null;
                            str3 = str;
                            str4 = str2;
                            if (this.gqz != null) {
                            }
                            if (!"close_live".equals(str4)) {
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
            if (this.gqz != null) {
                this.gqz.eq(str4);
            }
            if (!"close_live".equals(str4)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bKk();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bFI().gla.FO(), 1, str3);
                    }
                });
            } else if ("live_admin".equals(str4)) {
                if (bFI().gla.FO() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bFI().gla.FO().ayV.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bFI().gla.FO().ayV.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bFI().gla.FO().ayV.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str4)) {
                if (bFI().gla.FO() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bFI().gla.FO() != null && bFI().gla.FO().ayC != null && bFI().gla.FO().ayC.userId == optLong2) {
                        bFI().gla.FO().ayC.isUegBlock = 1;
                        bDY();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str4)) {
                if (bFI().gla.FO() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bFI().gla.FO() != null && bFI().gla.FO().ayC != null && bFI().gla.FO().ayC.userId == optLong3) {
                        bFI().gla.FO().ayC.isUegBlock = 0;
                        bDY();
                    }
                }
            } else if ("task".equals(str4)) {
                if (this.gqf != null) {
                    this.gqf.L(jSONObject2);
                }
            } else if ("enter_live".equals(str4)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.gpK.aC(optString4, optInt2);
                    }
                    if (this.gan.getCount() > 20) {
                        this.gan.dD(this.gan.getCount() + 1);
                    } else if (this.gaj != null) {
                        com.baidu.live.data.a Eh = aVar.Eh();
                        j jVar = new j();
                        jVar.ayD = new AlaLocationData();
                        jVar.ayE = new AlaRelationData();
                        jVar.ayC = new AlaLiveUserInfoData();
                        jVar.ayC.userId = JavaTypesHelper.toLong(Eh.userId, 0L);
                        jVar.ayC.userName = Eh.userName;
                        jVar.ayC.portrait = Eh.portrait;
                        if (this.gaj.c(jVar)) {
                            this.gan.dD(this.gan.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str4)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bFI().gla.FO() != null && bFI().gla.FO().mLiveInfo != null) {
                    String str7 = bFI().gla.FO().mLiveInfo.feed_id;
                    long j4 = bFI().gla.FO().mLiveInfo.live_id;
                    long j5 = bFI().gla.FO().ayC.userId;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!com.baidu.live.utils.m.i(j4, optLong4)) {
                        if (this.gpM != null) {
                            this.gpM.d(str7, j4, j5);
                        }
                        com.baidu.live.utils.m.j(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str4)) {
                if (jSONObject2 != null && bFI() != null && bFI().gla != null && bFI().gla.FO() != null && bFI().gla.FO().ayV != null && bFI().gla.FO().ayV.userId == jSONObject2.optLong("user_id")) {
                    bFI().gla.bLw();
                }
            } else if ("official_notice".equals(str4)) {
                if (jSONObject2 != null) {
                    long optLong5 = jSONObject2.optLong("user_id");
                    if (jSONObject3 != null) {
                        String str8 = optLong5 + "";
                        TbadkCoreApplication.getInst();
                        if (str8.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject3);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                }
            } else if ("privilege_award_royal_success".equals(str4)) {
                if (jSONObject2 != null) {
                    String str9 = jSONObject2.optInt("effect_id") + "";
                    com.baidu.live.data.a Eh2 = aVar.Eh();
                    if (Eh2 != null && v.eW(str9)) {
                        v.d(str9, 1L, "", "", Eh2.userId, Eh2.portrait, Eh2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str4)) {
                if (jSONObject2 != null) {
                    ao aoVar = new ao();
                    aoVar.parseJson(jSONObject2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, aoVar));
                }
            } else if (TextUtils.equals(str4, "challenge_mvp_punish")) {
                if (jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            } else if ("challenge_direct_new".equals(str4)) {
                if (jSONObject2 != null) {
                    String optString5 = jSONObject2.optString("challenge_im_type");
                    if (TextUtils.equals(optString5, "start")) {
                        DM(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bFI().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str4)) {
                BdUtilHelper.showToast(bFI().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a Eh3 = aVar.Eh();
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
                long j6 = 0;
                long j7 = 0;
                long j8 = 0;
                String str10 = null;
                if (bFI().gla != null && bFI().gla.FO() != null && bFI().gla.FO().mLiveInfo != null) {
                    j6 = bFI().gla.FO().mLiveInfo.live_id;
                    j7 = bFI().gla.FO().mLiveInfo.group_id;
                    j8 = bFI().gla.FO().ayC.userId;
                    str10 = bFI().gla.FO().mLiveInfo.appId;
                    if (bFI().gla.FO().mLiveSdkInfo.mCastIds != null) {
                        String str11 = bFI().gla.FO().mLiveSdkInfo.mCastIds.ayO;
                        j = j8;
                        j2 = j7;
                        j3 = j6;
                        str5 = bFI().gla.FO().mLiveSdkInfo.mCastIds.ayP;
                        str6 = str11;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str6, str5, optString6, "");
                        if (this.isBackground || bFI().bHw() != 2) {
                            if (TextUtils.isEmpty(optString11) && !TextUtils.isEmpty(optString12)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    v.b(optString12, Eh3.userId, Eh3.portrait, Eh3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str10, optString11, "", "", aVar.getMsgId());
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString12);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.v.d.Hz().fI(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                v.b(optString6, Integer.parseInt(optString7), optString8, optString9, Eh3.userId, Eh3.portrait, Eh3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str10, optString10, str6, str5, aVar.getMsgId());
                            }
                        }
                        Dq(optString6);
                        com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar.gkF = optLong6;
                        cVar.liveId = j3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                    }
                }
                j = j8;
                j2 = j7;
                j3 = j6;
                str5 = "";
                str6 = "";
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str6, str5, optString6, "");
                if (this.isBackground) {
                }
                if (TextUtils.isEmpty(optString11)) {
                }
                v.b(optString6, Integer.parseInt(optString7), optString8, optString9, Eh3.userId, Eh3.portrait, Eh3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str10, optString10, str6, str5, aVar.getMsgId());
                Dq(optString6);
                com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                cVar2.gkF = optLong6;
                cVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void Dq(String str) {
        if (this.gaq != null) {
            this.gaq.Dq(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sc(int i) {
        View findViewById = bFI().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gaq != null) {
            this.gaq.bA(2, i);
        }
    }

    private void bKl() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bFI().glA != null && AlaMasterLiveRoomOpearator.this.bFI().glA.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bFI().glA.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bFI().glA.startRecord();
                }
            }
        });
    }

    private void bKm() {
        if (bFI().glA != null && bFI().glA.getPreview() != null) {
            bFI().glA.getPreview().setVisibility(8);
            bFI().glA.stopRecord();
        }
    }

    public void bKn() {
        this.glx = bFI().gla.bLI();
        if (this.gpF != null) {
            this.gpF.ly(this.glx);
        }
    }

    public void bHu() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bKo();
        } else if (this.gpF != null) {
            this.gpF.bHu();
        }
    }

    public void lz(boolean z) {
        if (this.gpF != null) {
            this.gpF.lz(z);
        }
    }

    public void onDestroy() {
        if (this.gqk != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.gqk);
        }
        this.gqk = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.gqe.removeCallbacksAndMessages(null);
        if (this.gqx != null) {
            this.gqx.lw(true);
        }
        this.gqx = null;
        if (this.gpF != null) {
            this.gpF.destroy();
            bFI().glC.removeView(this.gpF.getView());
            this.gpF.release();
            this.gpF = null;
        }
        if (this.gqz != null) {
            this.gqz.onDestroy();
        }
        if (this.gbb != null) {
            this.gbb.onDestroy();
        }
        if (this.gak != null) {
            this.gak.onDestroy();
            this.gak = null;
        }
        if (this.gpG != null) {
            this.gpG.onDestroy();
        }
        if (this.gbB != null) {
            this.gbB.onDestroy();
            this.gbB = null;
        }
        if (this.gpN != null) {
            this.gpN.stopCountDown();
        }
        if (this.gpI != null) {
            this.gpI.onDestroy();
        }
        if (this.gpK != null) {
            this.gpK.onDestroy();
        }
        if (this.gqf != null) {
            this.gqf.onDestroy();
            this.gqf = null;
        }
        if (this.gbq != null) {
            this.gbq.onDestroy();
            this.gbq = null;
        }
        v.zv();
        com.baidu.live.entereffect.a.xD().release();
        if (this.gbr != null) {
            this.gbr.onDestroy();
            this.gbr = null;
        }
        if (this.gpL != null) {
            this.gpL.onDestroy();
        }
        if (this.gpJ != null) {
            this.gpJ.bNJ();
            this.gpJ.release();
        }
        if (this.gan != null) {
            this.gan = null;
        }
        if (this.gaq != null) {
            this.gaq.release();
        }
        if (this.gpJ != null) {
            this.gpJ.onDestroy();
        }
        if (this.gbp != null) {
            this.gbp.release();
        }
        if (this.gpM != null) {
            this.gpM.release();
        }
        if (this.gbz != null) {
            this.gbz.onDestroy();
        }
        if (this.gqh != null) {
            this.gqh.onDestroy();
        }
        if (this.gbM != null) {
            this.gbM.release();
        }
        if (this.gqA != null) {
            this.gqA.onDestory();
        }
        if (this.gqB != null) {
            this.gqB.release();
        }
        if (this.gbJ != null) {
            this.gbJ.onDestroy();
        }
        if (this.gqC != null) {
            this.gqC.release();
        }
        MessageManager.getInstance().unRegisterListener(this.gaL);
        MessageManager.getInstance().unRegisterListener(this.grb);
        MessageManager.getInstance().unRegisterListener(this.gcs);
        MessageManager.getInstance().unRegisterListener(this.gqO);
        MessageManager.getInstance().unRegisterListener(this.gqP);
        MessageManager.getInstance().unRegisterListener(this.gqL);
        MessageManager.getInstance().unRegisterListener(this.aYT);
        MessageManager.getInstance().unRegisterListener(this.aYU);
        MessageManager.getInstance().unRegisterListener(this.gqM);
        MessageManager.getInstance().unRegisterListener(this.gcu);
        MessageManager.getInstance().unRegisterListener(this.gct);
        MessageManager.getInstance().unRegisterListener(this.gcv);
        MessageManager.getInstance().unRegisterListener(this.gqN);
        MessageManager.getInstance().unRegisterListener(this.gqM);
        MessageManager.getInstance().unRegisterListener(this.aYd);
        MessageManager.getInstance().unRegisterListener(this.aVc);
        com.baidu.live.utils.m.Jt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(as asVar, String str, long j, long j2) {
        if (asVar != null && asVar.eventType == 1001 && this.gpM != null) {
            this.gpM.d(str, j, j2);
        }
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gdS.glH.a(this.grd, this.gdS.glB, this.gpP, alaLivePersonData);
        }
    }

    private void bKo() {
        if (this.gqi != null) {
            this.gdS.glF.startTime = System.currentTimeMillis();
            this.gdS.glF.liveTotalTime = System.currentTimeMillis();
            this.gdS.glF.sampleMemAndCPU();
            this.gdS.glD.a((short) 4, this.gqi);
        }
    }

    private void DM(String str) {
        String str2;
        int i;
        if (bFI() != null && bFI().pageContext != null) {
            this.gqe.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bFI().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.gqI == null) {
                    this.gqI = layoutInflater.inflate(a.h.layout_challenge_entry_toast, (ViewGroup) null);
                    this.gqI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaMasterLiveRoomOpearator.this.gqe.removeCallbacksAndMessages(null);
                            if (AlaMasterLiveRoomOpearator.this.gqI != null) {
                                AlaMasterLiveRoomOpearator.this.bFI().glb.removeView(AlaMasterLiveRoomOpearator.this.gqI);
                            }
                            if (AlaMasterLiveRoomOpearator.this.gqz != null) {
                                AlaMasterLiveRoomOpearator.this.gqz.bFK();
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.gqI.findViewById(a.g.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.i.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.gqe.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bFI().glb != null && AlaMasterLiveRoomOpearator.this.gdZ != null && AlaMasterLiveRoomOpearator.this.gqI != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.gqI.findViewById(a.g.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.gqI.findViewById(a.g.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.u((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.gqI.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gdZ.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gdZ.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gdZ.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gdZ.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.gqI.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.gqI.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.gqI != null) {
                                AlaMasterLiveRoomOpearator.this.bFI().glb.removeView(AlaMasterLiveRoomOpearator.this.gqI);
                            }
                            AlaMasterLiveRoomOpearator.this.bFI().glb.addView(AlaMasterLiveRoomOpearator.this.gqI, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.v.a.Hs().aZn != null) {
                    i = com.baidu.live.v.a.Hs().aZn.aBk;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.gqe.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bFI().glb != null && AlaMasterLiveRoomOpearator.this.gqI != null) {
                            AlaMasterLiveRoomOpearator.this.bFI().glb.removeView(AlaMasterLiveRoomOpearator.this.gqI);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
