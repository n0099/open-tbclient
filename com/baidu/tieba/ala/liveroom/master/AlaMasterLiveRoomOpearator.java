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
    private static final String gCt;
    private boolean bdm;
    private PendantParentView bhH;
    private com.baidu.tieba.ala.liveroom.x.a gCA;
    private b gCB;
    private com.baidu.tieba.ala.liveroom.tippop.a gCC;
    protected com.baidu.live.j.a gCD;
    private AlaLiveCountDownView gCE;
    private AlaLiveStreamStatusView gCF;
    private RelativeLayout gCG;
    private RelativeLayout gCH;
    private RelativeLayout gCI;
    private RelativeLayout gCJ;
    private FrameLayout gCK;
    private View gCL;
    private boolean gCM;
    private AlaLiveFaceVerifyView gCN;
    private ImageView gCO;
    private ImageView gCP;
    private ImageView gCQ;
    private ImageView gCR;
    private ImageView gCS;
    private ImageView gCT;
    private TextView gCU;
    private ah gCV;
    private com.baidu.live.y.a gCX;
    private com.baidu.tieba.ala.liveroom.master.panel.b gCY;
    private com.baidu.live.x.a gCZ;
    private boolean gCd;
    private boolean gCu;
    private d gCw;
    private com.baidu.tieba.ala.liveroom.o.a gCx;
    private com.baidu.tieba.ala.liveroom.b.a gCy;
    private com.baidu.tieba.ala.liveroom.u.a gCz;
    private View gDB;
    private FrameLayout gDC;
    private ImageView gDa;
    private e gDb;
    private short gDl;
    private com.baidu.tieba.ala.liveroom.h.b gDq;
    private boolean gDr;
    private com.baidu.tieba.ala.liveroom.challenge.e gDs;
    private com.baidu.live.b.a gDt;
    private com.baidu.live.b.b gDu;
    private com.baidu.tieba.ala.liveroom.q.a gDv;
    private boolean gDw;
    private BdUniqueId gDx;
    private boolean gDy;
    private String gkr;
    private com.baidu.live.g.a glN;
    private c gmm;
    private com.baidu.tieba.ala.liveroom.o.a gmn;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gmq;
    private com.baidu.tieba.ala.liveroom.activeview.b gms;
    protected h gnB;
    protected y gnD;
    protected com.baidu.live.i.a gnL;
    private com.baidu.live.s.a gnP;
    private com.baidu.live.h.a gnc;
    private com.baidu.tieba.ala.liveroom.share.c gnd;
    private com.baidu.tieba.ala.liveroom.r.b gne;
    private m gnp;
    private k gnq;
    private com.baidu.live.im.b.a gnr;
    private w gns;
    private u gnt;
    private boolean goO;
    private boolean gob;
    private f gqb;
    private ImageView gqi;
    private g gqj;
    private boolean gCv = false;
    private boolean gnW = false;
    private Handler mHandler = new Handler();
    private Handler gCW = new Handler();
    private boolean gDc = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver gDd = null;
    private boolean gDe = false;
    private int gDf = 0;
    private int gDg = 0;
    private int gDh = 0;
    private long gDi = 0;
    private long gDj = 0;
    private volatile boolean isBackground = false;
    private Intent gDk = null;
    private int mOrientation = 1;
    private boolean gxB = false;
    private boolean gDm = false;
    private boolean gDn = true;
    private boolean gqg = false;
    private boolean gDo = true;
    private boolean gDp = true;
    private int cXt = 0;
    private String otherParams = "";
    private int bdp = 0;
    private int gDz = 5000;
    private boolean gDA = false;
    private Runnable gDD = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.glN != null) {
                AlaMasterLiveRoomOpearator.this.glN.Df();
            }
        }
    };
    private CustomMessageListener bem = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gqb.gxL != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gqb.gxL.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.A(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener ben = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gqb.gxL != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gqb.gxL.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener got = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gne == null) {
                        AlaMasterLiveRoomOpearator.this.gne = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gne.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener goz = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gnL != null) {
                AlaMasterLiveRoomOpearator.this.gnL.It();
            }
        }
    };
    private CustomMessageListener gDE = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.r((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener goq = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.FQ(str);
            }
        }
    };
    private CustomMessageListener gor = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bkV();
        }
    };
    private CustomMessageListener gmN = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gnt.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gox = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener gDF = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gDu != null) {
                r LC = AlaMasterLiveRoomOpearator.this.bPn().gxe.LC();
                long j = LC.mLiveInfo.live_id;
                long j2 = LC.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.gDu.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener gDG = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bPn().gxf);
            if (AlaMasterLiveRoomOpearator.this.gCw == null || AlaMasterLiveRoomOpearator.this.gCw.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.us(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gnq != null) {
                AlaMasterLiveRoomOpearator.this.gnq.Jf().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gnq.Jg().hide();
            }
        }
    };
    private CustomMessageListener goy = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.r(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC());
        }
    };
    private CustomMessageListener goA = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gnD != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) AlaMasterLiveRoomOpearator.this.gnD).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gDH = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gDv != null) {
                    AlaMasterLiveRoomOpearator.this.gDv.Gn(str);
                }
            }
        }
    };
    private CustomMessageListener gDI = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.gDq != null) {
                        if (!data.azH || AlaMasterLiveRoomOpearator.this.gDx == null || !AlaMasterLiveRoomOpearator.this.gDy) {
                            if (AlaMasterLiveRoomOpearator.this.gDx != null && AlaMasterLiveRoomOpearator.this.gDx == data.azG) {
                                if (data.azA != null && data.azA.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.gDy || AlaMasterLiveRoomOpearator.this.gCw.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.gDq.a(AlaMasterLiveRoomOpearator.this.bPn().gxE.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.gDr = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bPn().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.gDx = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bPn().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.gDq.a(AlaMasterLiveRoomOpearator.this.bPn().gxE.getVideoConfig(), AlaMasterLiveRoomOpearator.this.gDr);
                        if (!AlaMasterLiveRoomOpearator.this.gDr) {
                            AlaMasterLiveRoomOpearator.this.gDr = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gDw) {
                    AlaMasterLiveRoomOpearator.this.bPn().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.gDw = false;
            }
        }
    };
    private CustomMessageListener gDJ = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bPn().gxE != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bPn().gxE.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.c.AD().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bdu = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bdp == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bdp == 6) {
                            AlaMasterLiveRoomOpearator.this.bTv();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bdp = 0;
            }
        }
    };
    private View.OnClickListener gDK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.gCP) {
                    AlaMasterLiveRoomOpearator.this.bTz();
                    AlaMasterLiveRoomOpearator.this.gCY.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.gCO) {
                    if (view == AlaMasterLiveRoomOpearator.this.gCQ) {
                        AlaMasterLiveRoomOpearator.this.bkV();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.gCR) {
                        if (view != AlaMasterLiveRoomOpearator.this.gCT) {
                            if (view != AlaMasterLiveRoomOpearator.this.gqi) {
                                if (view == AlaMasterLiveRoomOpearator.this.gCS && AlaMasterLiveRoomOpearator.this.gCA != null) {
                                    ag bVB = AlaMasterLiveRoomOpearator.this.bPn().gxe.bVB();
                                    if (bVB == null || bVB.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(bVB.mLiveSdkInfo.mRoomId);
                                        if (bVB.mLiveSdkInfo.mCastIds != null) {
                                            str2 = bVB.mLiveSdkInfo.mCastIds.aDW;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.gCA.ai("", str, str2);
                                    return;
                                }
                                return;
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.gDs != null) {
                                AlaMasterLiveRoomOpearator.this.gDs.bPp();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.gCZ != null) {
                            AlaMasterLiveRoomOpearator.this.gCZ.Nv();
                            AlaMasterLiveRoomOpearator.this.gCZ.cn(AlaMasterLiveRoomOpearator.this.bTD());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.gDy = false;
                        AlaMasterLiveRoomOpearator.this.mq(true);
                        AlaMasterLiveRoomOpearator.this.gCU.setVisibility(4);
                        com.baidu.live.c.AD().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.w.a.Nk().beH.aHn == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.w.a.Nk().beH.aHm == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bdm) {
                        AlaMasterLiveRoomOpearator.this.bTv();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bdp = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bTv();
                }
            }
        }
    };
    private CustomMessageListener gos = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ah) {
                    AlaMasterLiveRoomOpearator.this.gnW = true;
                    AlaMasterLiveRoomOpearator.this.gCV = (ah) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gnq != null) {
                        AlaMasterLiveRoomOpearator.this.gnq.Jf().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gnq != null) {
                        AlaMasterLiveRoomOpearator.this.gnq.Jg().show();
                        AlaMasterLiveRoomOpearator.this.gnq.Jg().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.us(8);
                }
            }
        }
    };
    private CustomMessageListener gDL = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bPn() != null && AlaMasterLiveRoomOpearator.this.bPn().gxJ != null) {
                AlaMasterLiveRoomOpearator.this.bPn().gxJ.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bre = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bUm();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bPn().gxe.uz(i);
                if (AlaMasterLiveRoomOpearator.this.gnL != null) {
                    AlaMasterLiveRoomOpearator.this.gnL.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener gkC = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bUf();
        }
    };
    public final HttpMessageListener gDM = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.LG()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.gCY != null) {
                            AlaMasterLiveRoomOpearator.this.gCY.mx(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.gCY.bUK();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bPn().gxE.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.gCC != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.gCC.a(AlaMasterLiveRoomOpearator.this.bPn().gxG, AlaMasterLiveRoomOpearator.this.bPn().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bPn().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.gCC.uG(2);
                        AlaMasterLiveRoomOpearator.this.gCC.a(AlaMasterLiveRoomOpearator.this.bPn().gxG, string, 3);
                    }
                }
            }
        }
    };
    private e.a gDN = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bUs() {
            AlaMasterLiveRoomOpearator.this.ur(a.i.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bUt() {
            AlaMasterLiveRoomOpearator.this.ur(a.i.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a gDO = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean ey(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ez(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bPn().bRa() == 1) {
                AlaMasterLiveRoomOpearator.this.bPn().gxE.stopRecord();
            }
        }
    };
    private IShareCallback gDP = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.gDc && AlaMasterLiveRoomOpearator.this.gDb != null) {
                AlaMasterLiveRoomOpearator.this.gDc = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.gDb);
            }
        }
    };
    private View.OnTouchListener gDQ = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bPn().gxJ.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bPn().gxf);
            AlaMasterLiveRoomOpearator.this.us(0);
            if (AlaMasterLiveRoomOpearator.this.gnq != null) {
                AlaMasterLiveRoomOpearator.this.gnq.Jf().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.gnq.Jg().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b gDR = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUu() {
            AlaMasterLiveRoomOpearator.this.bTw();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUv() {
            AlaMasterLiveRoomOpearator.this.gCd = AlaMasterLiveRoomOpearator.this.gCw.bQS();
            AlaMasterLiveRoomOpearator.this.bPn().gxJ.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bPn().gxJ.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bPn().gxJ.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gxy = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bPn().bRa();
            eVar.title = AlaMasterLiveRoomOpearator.this.gCw.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.gxz = AlaMasterLiveRoomOpearator.this.gCw.bQT();
            eVar.gxC = AlaMasterLiveRoomOpearator.this.gCd;
            eVar.gxB = AlaMasterLiveRoomOpearator.this.gCw.bQQ();
            eVar.gxA = AlaMasterLiveRoomOpearator.this.gCw.bQV();
            eVar.gxD = AlaMasterLiveRoomOpearator.this.gCw.bQR();
            if (eVar.gxD) {
                if (AlaMasterLiveRoomOpearator.this.gCw.bQW()) {
                    AlaMasterLiveRoomOpearator.this.gDc = true;
                    AlaMasterLiveRoomOpearator.this.gDb = eVar;
                    AlaMasterLiveRoomOpearator.this.gCw.bQX();
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
            AlaMasterLiveRoomOpearator.this.bPn().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bPn().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUw() {
            AlaMasterLiveRoomOpearator.this.gDy = true;
            AlaMasterLiveRoomOpearator.this.mq(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bUx() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bUy() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private Runnable gDS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.bPn().gxe != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo != null) {
                    com.baidu.live.utils.m.k(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.gDS, AlaMasterLiveRoomOpearator.this.gDz);
                }
            }
        }
    };
    private CustomMessageListener baq = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bNA();
            }
        }
    };
    private com.baidu.live.liveroom.g.c gDT = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void LA() {
            if (AlaMasterLiveRoomOpearator.this.gCA != null) {
                AlaMasterLiveRoomOpearator.this.gCA.mI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ce(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.gCZ != null) {
                        AlaMasterLiveRoomOpearator.this.gCZ.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gCZ != null) {
                    AlaMasterLiveRoomOpearator.this.gCZ.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.gCA != null) {
                    AlaMasterLiveRoomOpearator.this.gCA.mI(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gnD != null) {
                    AlaMasterLiveRoomOpearator.this.gnD.bl(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a gDU = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void XL() {
            if (AlaMasterLiveRoomOpearator.this.gCN != null && AlaMasterLiveRoomOpearator.this.bPn().gxG.indexOfChild(AlaMasterLiveRoomOpearator.this.gCN) >= 0) {
                AlaMasterLiveRoomOpearator.this.bPn().gxG.removeView(AlaMasterLiveRoomOpearator.this.gCN);
                AlaMasterLiveRoomOpearator.this.gCN.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.gCN = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gmS = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            r LC;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bUl();
            } else if (i == 14 && (LC = AlaMasterLiveRoomOpearator.this.bPn().gxe.LC()) != null && LC.aDE != null && LC.mLiveInfo != null && LC.aEd != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity(), LC.aDE.userName, Long.toString(LC.aDE.userId), Long.toString(LC.aDE.charmCount), String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), true, String.valueOf(LC.aDE.userId), Long.toString(LC.aEd.userId), LC.aEd.userName, LC.aEd.portrait, AlaMasterLiveRoomOpearator.this.gmq.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(LC.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gmq.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener gDV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.bPn().gxe != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.beO != null && !eventPollingHttpResponseMessage.beO.isEmpty()) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.beO.size()) {
                                break;
                            }
                            au auVar = eventPollingHttpResponseMessage.beO.get(i2);
                            if (j == auVar.liveId && j2 - auVar.createTime <= 60 && !com.baidu.live.utils.m.i(auVar.liveId, auVar.id)) {
                                com.baidu.live.utils.m.a(auVar, AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo, true);
                                AlaMasterLiveRoomOpearator.this.a(auVar);
                                com.baidu.live.utils.m.j(auVar.liveId, auVar.id);
                            }
                            i = i2 + 1;
                        }
                        au auVar2 = eventPollingHttpResponseMessage.beO.get(eventPollingHttpResponseMessage.beO.size() - 1);
                        if (j == auVar2.liveId) {
                            com.baidu.live.utils.m.h(auVar2.liveId, auVar2.id);
                        }
                    }
                }
                int i3 = eventPollingHttpResponseMessage.beN;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.gDz = i3 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a gDW = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private com.baidu.live.liveroom.middleware.g gDX = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.ayv);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        gCt = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(r rVar) {
        if (rVar != null && rVar.mLiveInfo != null && com.baidu.live.w.a.Nk().beH != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bPn().pageContext.getPageActivity(), String.valueOf(rVar.mLiveInfo.live_id), String.valueOf(rVar.mLiveInfo.user_id), com.baidu.live.w.a.Nk().beH.aHi, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FQ(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPn().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bPn().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.w.a.Nk().beH.aGI;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bPn().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bPn().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bPn().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNA() {
        int i = bPn().gxe.LC().aDE.isUegBlock;
        int i2 = bPn().gxe.LC().aDE.isBlock;
        String str = bPn().gxe.LC().aDE.userName;
        if (i > 0 || i2 > 0) {
            this.bdm = true;
            this.gnq.a(true, i, i2, str);
            return;
        }
        this.bdm = false;
        this.gnq.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gqb.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bcw == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bcx);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gqb.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.gqb.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTv() {
        if (this.gnq != null) {
            this.gnq.Jg().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.gDs != null) {
            this.gDs.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTw() {
        if (bPn() != null && bPn().gxe != null) {
            bPn().gxe.bVu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bHV() != null && aVar.bHW() != null) {
            bPn().gxe.ed(aVar.bHV().getId(), aVar.bHW().getId());
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
                    AlaMasterLiveRoomOpearator.this.gDe = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.gDe = false;
                }
                if (AlaMasterLiveRoomOpearator.this.gDf == 0) {
                    AlaMasterLiveRoomOpearator.this.gDf = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.gDg == 0) {
                    AlaMasterLiveRoomOpearator.this.gDg = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.gDh = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bPn() != null && bPn().gxH != null) {
            bPn().gxH.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.gqb = fVar;
        this.gkr = str;
    }

    protected f bPn() {
        return this.gqb;
    }

    public int a(g gVar) {
        this.gqj = gVar;
        this.gDd = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.gDd, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.gCC == null) {
            this.gCC = new com.baidu.tieba.ala.liveroom.tippop.a(this.gqb.pageContext, null);
        }
        registerListener();
        this.glN = new com.baidu.live.g.a();
        bTO();
        bTx();
        bTy();
        Long[] lArr = new Long[1];
        this.gDi = lArr[0] == null ? 0L : lArr[0].longValue();
        this.gDj = lArr[0] != null ? lArr[0].longValue() : 0L;
        bPn().gxf.setOnTouchListener(this.gDQ);
        this.gCu = SharedPrefHelper.getInstance().getBoolean(gCt, false);
        this.gCE = new AlaLiveCountDownView(bPn().pageContext.getPageActivity());
        this.gCE.setCount(3);
        this.gCE.setTextColor(bPn().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.gCE.setTextSize(bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.gCE.setTypeface(Typeface.DEFAULT_BOLD);
        this.gCE.setIncludeFontPadding(false);
        this.gCE.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bUz() {
                if (AlaMasterLiveRoomOpearator.this.bPn().gxf != null) {
                    AlaMasterLiveRoomOpearator.this.bPn().gxf.removeView(AlaMasterLiveRoomOpearator.this.gCE);
                }
            }
        });
        return 1;
    }

    private void bTx() {
        CustomResponsedMessage runTask;
        if (this.gCD == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.j.a.class, bPn().pageContext)) != null && runTask.getData() != null) {
            this.gCD = (com.baidu.live.j.a) runTask.getData();
            this.gCD.c(bPn().pageContext);
        }
    }

    private void bTy() {
        View rootLayout;
        if (this.gCD != null && this.gCK != null && (rootLayout = this.gCD.bV(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gCK.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTz() {
        if (this.gCY == null) {
            this.gCY = new com.baidu.tieba.ala.liveroom.master.panel.b(bPn().pageContext.getPageActivity(), bPn().bRa() == 2);
            this.gCY.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ms(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bPn().gxE.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mt(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bPn().gxE.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mu(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bPn().gxE.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bUk();
                    if (AlaMasterLiveRoomOpearator.this.gCC != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.gCC.a(AlaMasterLiveRoomOpearator.this.bPn().gxG, AlaMasterLiveRoomOpearator.this.bPn().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.gCC.a(AlaMasterLiveRoomOpearator.this.bPn().gxG, AlaMasterLiveRoomOpearator.this.bPn().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void mv(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUA() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bPn().gxe != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.gCY != null) {
                        AlaMasterLiveRoomOpearator.this.gCY.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUB() {
                    if (AlaMasterLiveRoomOpearator.this.gCY != null) {
                        AlaMasterLiveRoomOpearator.this.gCY.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.h(AlaMasterLiveRoomOpearator.this.bPn().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUC() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bPn() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.r(AlaMasterLiveRoomOpearator.this.bPn().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.gCY != null) {
                            AlaMasterLiveRoomOpearator.this.gCY.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bUD() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bPn() == null || AlaMasterLiveRoomOpearator.this.bPn().gxe == null || AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() == null || AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bPn() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.gCY != null) {
                                        AlaMasterLiveRoomOpearator.this.gCY.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gqb.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.gCY != null) {
                        AlaMasterLiveRoomOpearator.this.gCY.dismiss();
                    }
                }
            });
        }
        bTA();
    }

    private void bTA() {
        if (this.gCY != null) {
            boolean isBackCamera = bPn().gxE.isBackCamera();
            this.gCY.mw(bPn().gxE.isBackCamera());
            this.gCY.N(bPn().gxE.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bPn().gxE.isPushMirror();
            if (this.gDn) {
                isPushMirror = bUj() || isPushMirror;
                this.gDn = false;
            }
            this.gCY.O(isPushMirror, isBackCamera ? false : true);
            this.gCY.mx(bPn().gxE.isMute());
            this.gCY.bUK();
        }
    }

    public void bTB() {
        if (this.gqj != null) {
            if (this.gqj.gxM == null || this.gqj.gxM.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.gCL == null) {
                        this.gCL = this.gqb.gxL.Lc();
                        this.gqb.gxG.addView(this.gCL, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.gCw == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bPn().gxe != null && bPn().gxe.LC() != null && bPn().gxe.LC().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bPn().gxe.LC().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bPn().gxe.LC().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.gCw = new d(bPn().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bPn().gxJ.prepareTime = System.currentTimeMillis();
                    bPn().gxG.addView(this.gCw.getView(), layoutParams);
                    this.gCw.a(this.gDP);
                }
                this.gCw.lZ(this.gxB);
                this.gCw.a(this.gDR);
                this.gCw.a(this.gDN);
                this.gCw.a(bPn().gxE, bPn().bRa());
                this.gCw.a(this.gCD);
                return;
            }
            this.gCd = this.gqj.gxM.mLiveInfo.screen_direction == 2;
            if (this.gqj.gxM.mLiveInfo.isAudioOnPrivate == 1) {
                bPn().gxE.setMute(true);
                if (this.gCC == null) {
                    this.gCC = new com.baidu.tieba.ala.liveroom.tippop.a(this.gqb.pageContext, null);
                }
                if (!this.gCC.uF(2)) {
                    this.gCC.a(bPn().gxG, bPn().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gxy = true;
            eVar.forumId = String.valueOf(this.gqj.gxM.mLiveInfo.forum_id);
            eVar.forumName = this.gqj.gxM.mLiveInfo.forum_name;
            eVar.liveType = this.gqj.gxM.mLiveInfo.live_type;
            eVar.title = this.gqj.gxM.mLiveInfo.getLiveTitle();
            eVar.clarity = this.gqj.gxM.mLiveInfo.clarity;
            eVar.gameId = this.gqj.gxM.mLiveInfo.game_id;
            eVar.gameName = this.gqj.gxM.mLiveInfo.game_label;
            eVar.gxC = this.gqj.gxM.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bTC() {
        if (this.gDq != null) {
            this.gDq.a(bPn().gxE.getVideoConfig(), false);
        }
        if (this.gCw != null) {
            this.gCw.lY(true);
        }
        if (bPn().gxE.hasBeauty() >= 0) {
            bPn().gxE.setBeauty(com.baidu.live.c.AD().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bPn().gxL.G(this.gqb.gxE);
        } else if (this.gCw != null) {
            this.gCw.lY(true);
        }
        bTN();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.gCL != null && this.gCL.getParent() != null) {
                ((ViewGroup) this.gCL.getParent()).removeView(this.gCL);
                this.gCL = null;
            }
            bPn().gxf.setVisibility(0);
            this.gqb.gxL.a(bPn().gxf);
        } else {
            bTU();
            bUi();
            if (this.gDC != null) {
                this.gDC.setVisibility(0);
            }
            this.gCA = new com.baidu.tieba.ala.liveroom.x.a(bPn().pageContext, this.gDO);
            this.gCA.d(bPn().gxf, true);
            this.gCA.mI(true);
            if (this.gnq != null && this.gnq.Jf() != null) {
                this.gnq.Jf().setNeedTopAlphaShade(true);
            }
        }
        bPn().gxE.setPushMirror(bUj());
    }

    public void b(ag agVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gqb.gxL.l(bPn().gxe.LC());
        }
        if (!bPn().gxE.isBackground() && bPn().gxe.LC() != null && bPn().gxe.LC().mLiveInfo != null) {
            int startPush = bPn().gxE.startPush(bPn().gxe.LC().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gqb.gxL.Ld();
            }
            if (startPush != 0 && bPn().gxJ != null) {
                bPn().gxJ.errCode = 4;
                bPn().gxJ.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (agVar != null && !agVar.CS() && !bUg()) {
                mr(true);
                bUh();
            }
            if (this.gmn != null) {
                this.gmn.w(bPn().gxe.LC());
            }
            if (this.gnc != null) {
                this.gnc.a(bPn().gxe.LC());
            }
            if (this.gCD != null) {
                this.gCD.h(bPn().gxe.LC());
                this.gCD.gU(this.otherParams);
            }
            if (this.gCy != null && bPn() != null && bPn().gxe != null) {
                if (this.gCy.at(bPn().gxG)) {
                    this.gCy.q(bPn().gxe.LC());
                } else {
                    this.gCy.b(bPn().gxG, bPn().gxe.LC());
                }
            }
            if (this.gCx != null) {
                this.gCx.w(bPn().gxe.LC());
            }
            if (agVar == null || agVar.aDE == null) {
                z = com.baidu.live.c.AD().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = agVar.aDE.canUseChallenge;
                com.baidu.live.c.AD().putBoolean("ala_master_can_use_challenge", z);
            }
            bTV();
            bTG();
            mp(z);
            bNk();
            bTW();
            bUb();
            bOq();
            x(bPn().gxe.LC());
            f(bPn().gxe.LC());
            bUc();
            bUd();
            bTZ();
            bOf();
            bOm();
            bOn();
            bTT();
            if (this.gnp != null) {
                this.gnp.g(bPn().gxe.LC());
            }
            if (this.gnq != null) {
                if (bPn().gxe.LC() != null && bPn().gxe.LC().aEq != null && bPn().gxe.LC().aEq.Co()) {
                    z2 = true;
                }
                this.gnq.a(String.valueOf(bPn().gxe.LC().mLiveInfo.group_id), String.valueOf(bPn().gxe.LC().mLiveInfo.last_msg_id), String.valueOf(bPn().gxe.LC().aDE.userId), String.valueOf(bPn().gxe.LC().mLiveInfo.live_id), bPn().gxe.LC().aDE.appId, z2);
            }
            if (this.gnr != null) {
                this.gnr.a(bPn().gxe.LC(), true);
            }
            if (!this.gDA && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.gDA = true;
                this.mHandler.post(this.gDS);
            }
            this.mHandler.post(this.gDD);
        }
    }

    private void bNk() {
        if (this.bhH == null) {
            this.bhH = new PendantParentView(bPn().pageContext.getPageActivity(), this.goO ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bPn().gxf.addView(this.bhH, layoutParams);
            this.bhH.setDefaultItemMargin(bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bhH.setPadding(bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bOS();
        }
    }

    private void bOS() {
        if (this.bhH != null) {
            int dimensionPixelSize = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278);
            int dimensionPixelSize2 = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bhH.getLayoutParams();
            if (this.goO) {
                this.bhH.setPosition(0, 0, this.gDs.bOY(), dimensionPixelSize2);
            } else {
                this.bhH.setPosition(dimensionPixelSize, 0, bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278), dimensionPixelSize2);
            }
            this.bhH.setLayoutParams(layoutParams);
            this.bhH.setModel(this.goO ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bOT() {
        if (this.gnq != null && this.gnq.Jf() != null && this.gnq.Jf().getView() != null) {
            if (this.goO && !this.gCv && bPn().gxf != null && bPn().gxf.getHeight() > 0) {
                int be = this.gDs != null ? this.gDs.be(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.gnq.Jf().getView().getLayoutParams();
                int height = bPn().gxf.getHeight() - be;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.gnq.Jf().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ab.b.i(false, this.gCv);
            if (bPn().gxf.indexOfChild(this.gnq.Jf().getView()) != -1 && this.gnq.Jf().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnq.Jf().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.gnq.Jf().getView().setLayoutParams(layoutParams2);
            }
            this.gnq.Jf().Je();
        }
    }

    private void bOU() {
        if (this.gns != null) {
            if (this.goO && !this.gCv && bPn().gxf != null && bPn().gxf.getHeight() > 0) {
                this.gns.dL((bPn().gxf.getHeight() - (this.gDs != null ? com.baidu.live.utils.g.j(bPn().pageContext.getPageActivity(), true) : 0)) + bPn().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height));
            } else {
                this.gns.dL(com.baidu.live.ab.a.a(bPn().pageContext.getPageActivity(), true, false, this.gCv));
            }
        }
    }

    private void bOV() {
        int i;
        if (this.gns != null) {
            int h = com.baidu.live.ab.a.h(true, false);
            if (!this.goO || bPn().gxf == null || bPn().gxf.getHeight() <= 0) {
                i = h;
            } else {
                i = (bPn().gxf.getHeight() - (this.gDs != null ? this.gDs.be(false) : 0)) + bPn().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
            }
            this.gns.dM(i);
        }
    }

    private void bOW() {
        if (this.gnr != null && this.gnr.AZ() != null) {
            ViewGroup.LayoutParams layoutParams = this.gnr.AZ().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bPn().pageContext.getResources().getDimensionPixelOffset(this.goO ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gnr.AZ().setLayoutParams(layoutParams);
            }
        }
    }

    private void mp(boolean z) {
        if (this.gDs == null) {
            this.gDs = new com.baidu.tieba.ala.liveroom.challenge.e(bPn());
        }
        this.gDs.a(this.gqi, this.gqj);
        this.gDs.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(ap apVar, at atVar, at atVar2) {
                AlaMasterLiveRoomOpearator.this.goO = true;
                AlaMasterLiveRoomOpearator.this.bPn().gxf.gLW = false;
                if (AlaMasterLiveRoomOpearator.this.gCZ != null) {
                    AlaMasterLiveRoomOpearator.this.gCZ.eJ(4);
                    AlaMasterLiveRoomOpearator.this.gCZ.cn(true);
                }
                AlaMasterLiveRoomOpearator.this.bTE();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void BG() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gDD);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bPl() {
                AlaMasterLiveRoomOpearator.this.goO = false;
                AlaMasterLiveRoomOpearator.this.bPn().gxf.gLW = false;
                if (AlaMasterLiveRoomOpearator.this.gCZ != null) {
                    AlaMasterLiveRoomOpearator.this.gCZ.eJ(0);
                    AlaMasterLiveRoomOpearator.this.gCZ.cn(false);
                }
                AlaMasterLiveRoomOpearator.this.bTF();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bPm() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gDD);
            }
        });
        this.gDs.K(this.gCd, z);
        this.gDs.i(this.gCd, z, (this.gqj == null || this.gqj.gxM == null || this.gqj.gxM.mChallengeData == null) ? false : true);
    }

    public boolean bTD() {
        return this.gDs != null && this.gDs.bPr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTE() {
        if (this.gCB != null) {
            this.gCB.setVisible(8);
            this.gCB.setCanVisible(false);
        }
        if (this.gms != null) {
            this.gms.lz(true);
        }
        if (this.gCF != null) {
            this.gCF.setCanVisible(false);
            this.gCF.setVisibility(4);
        }
        if (this.gCA != null) {
            this.gCM = this.gCA.bXK();
            this.gCA.mH(false);
        }
        bOS();
        bOT();
        bOU();
        bOV();
        bOW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTF() {
        if (this.gCB != null) {
            this.gCB.setCanVisible(true);
        }
        if (this.gms != null) {
            this.gms.lz(false);
        }
        if (this.gCF != null) {
            this.gCF.setCanVisible(true);
        }
        if (this.gCA != null) {
            this.gCA.mH(this.gCM);
        }
        bOS();
        bOT();
        bOU();
        bOV();
        bOW();
    }

    private void bTG() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.gCF == null) {
            this.gCF = new AlaLiveStreamStatusView(bPn().pageContext.getPageActivity());
        }
        this.gCF.setId(a.g.ala_live_room_stream_view);
        this.gCF.setVisibility(4);
        this.gCF.setLayoutParams(layoutParams);
        if (this.gCF.getParent() == null) {
            bPn().gxf.addView(this.gCF, layoutParams);
        }
    }

    public void bTH() {
        if (this.gCw != null && this.gCw.getVisibility() != 8 && bPn().gxE.getPreview() != null) {
            bPn().gxE.stopRecord();
        }
    }

    public void bTI() {
        if (bPn().gxE.getPreview() != null) {
            bPn().gxE.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gDq != null) {
                this.gDq.lX(false);
            }
            this.gDq = new com.baidu.tieba.ala.liveroom.h.b(bPn().gxG, bPn(), bPn().gxE);
            this.gDq.a(bPn().gxE.getVideoConfig(), false);
        }
        if (this.gCC != null) {
            this.gCC.bWD();
        }
        this.mHandler.post(this.gDD);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gCv = z;
        if (z) {
            if (this.gDp) {
                this.gDp = false;
                if (this.gnq != null && this.gnq.Jf() != null) {
                    this.gnq.Jf().getView().setBottom(0);
                }
                if (this.gnq != null && this.gnq.Jg() != null) {
                    this.gnq.Jg().getView().setBottom(0);
                }
            }
            if (this.gnq != null && this.gnq.Jf() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gnq.Jf().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.gnq.Jf().getView().setLayoutParams(layoutParams);
            }
            if (this.gnq != null && this.gnq.Jg() != null && this.gnq.Jg().getView() != null && this.gnq.Jg().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gnq.Jg().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gnq.Jg().getView().setLayoutParams(layoutParams2);
                this.gnq.Jg().getView().setVisibility(0);
                this.gnq.Jg().KF();
            }
            us(8);
            uq(8);
        } else {
            if (this.gnq != null && this.gnq.Jf() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gnq.Jf().getView().getLayoutParams();
                layoutParams3.bottomMargin = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gnq.Jf().getView().setLayoutParams(layoutParams3);
            }
            if (this.gnq != null && this.gnq.Jg() != null) {
                this.gnq.Jg().hide();
            }
            us(0);
            uq(0);
        }
        if (this.gCw != null) {
            this.gCw.M(false, z);
        }
        if (this.gnr != null) {
            this.gnr.Ba();
        }
        if (this.gCZ != null) {
            this.gCZ.onKeyboardVisibilityChanged(z);
        }
        bOT();
        this.mHandler.post(this.gDD);
    }

    private void uq(int i) {
        if (this.gmn != null) {
            this.gmn.ue(i);
        }
        if (this.gCH != null) {
            this.gCH.setVisibility(i);
        }
        if (this.gnc != null) {
            this.gnc.getView().setVisibility(i);
        }
        if (this.gCz != null) {
            this.gCz.setVisible(i);
        }
        if (this.gCy != null) {
            this.gCy.setVisibility(i);
        }
        if (this.gms != null) {
            this.gms.setVisible(i);
        }
        if (this.gnP != null) {
            this.gnP.setCanVisible(i == 0);
        }
        if (this.gnB != null) {
            this.gnB.setVisible(i);
        }
        if (this.gnL != null) {
            this.gnL.setCanVisible(i == 0);
        }
        if (this.gDt != null) {
            this.gDt.setCanVisible(i == 0);
            this.gDt.refreshUI();
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bPn().gxJ.errCode = 1;
            ur(a.i.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            ur(a.i.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            ur(a.i.stream_upload_exception);
        } else if (i == -2) {
            Gh(bPn().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bPn().gxE.stopRecord();
        } else if (i == -3 && this.gCw != null) {
            this.gCw.lY(false);
        }
        if (i == -4) {
            if (this.gCw == null || this.gCw.getView().getParent() == null) {
                bPn().f((short) 1);
                return;
            }
            this.gCw.bQU();
            this.gCR.setVisibility(0);
            if (this.gCA != null) {
                this.gCA.mI(true);
            }
            bPn().gxf.setBackgroundColor(bPn().pageContext.getResources().getColor(17170445));
            bUp();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aob();
        if (i == 12001) {
            if (i2 == -1) {
                Gi(O(intent));
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
        if (this.gCw != null) {
            this.gCw.onResume();
        }
        if (this.gDc && this.gDb != null) {
            this.gDc = false;
            c(this.gDb);
        }
        if (this.gnD != null) {
            this.gnD.onResume();
        }
    }

    public void g(short s) {
        if (this.gnp != null) {
            this.gnp.Fb();
        }
        if (this.gnq != null) {
            this.gnq.a(null);
            this.gnq.Bb();
        }
        if (this.gnr != null) {
            this.gnr.Bb();
        }
        if (this.gDs != null) {
            this.gDs.bPq();
        }
    }

    public boolean bTJ() {
        r LC = bPn().gxe.LC();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gqb.gxL.k(LC);
            if (LC != null && LC.mLiveInfo.live_status != 1) {
                bUn();
                bPn().pageContext.getPageActivity().finish();
                if (bPn().gxe != null && bPn().gxe.LC() != null) {
                    a(LC, 1, bPn().gxe.bVK() != 1 ? bPn().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gnq != null) {
                this.gnq.Jf().b(String.valueOf(LC.mLiveInfo.group_id), String.valueOf(LC.mLiveInfo.live_id), true, String.valueOf(LC.aDE.userId));
            }
            if (this.gnr != null) {
                this.gnr.a(LC);
            }
            if (this.gnc != null) {
                this.gnc.a(bPn().gxe.LC());
            }
            if (this.gmn != null) {
                this.gmn.w(LC);
            }
            if (LC != null) {
                if (this.gDs != null) {
                    this.gDs.a(LC);
                }
                if (this.gnt != null && LC.mLiveInfo != null) {
                    this.gnt.a(LC.mLiveInfo, LC.aDE);
                }
                if (this.gnP != null) {
                    this.gob = this.gnP.p(LC);
                }
                if (this.gms != null) {
                    this.gms.lA(this.gob);
                    this.gms.j(LC);
                    this.gms.updateView();
                }
                if (this.gnL != null) {
                    this.gnL.a(LC);
                }
                if (LC.mLiveInfo.live_status != 1) {
                    bUn();
                    bPn().pageContext.getPageActivity().finish();
                    if (bPn().gxe != null && bPn().gxe.LC() != null) {
                        a(LC, 1, bPn().gxe.bVK() != 1 ? bPn().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.gCD != null) {
                    this.gCD.i(LC);
                }
            }
        }
        return false;
    }

    public void bTK() {
        bTA();
    }

    public void bTL() {
        if (this.gDq != null) {
            this.gDq.bQO();
        }
    }

    public void bTM() {
        if (this.gCw != null && this.gCw.getVisibility() != 8) {
            if (bPn().bRa() == 2) {
                bUp();
            } else {
                bUo();
            }
        }
        if (this.gCw != null && this.gCw.getVisibility() != 8) {
            if (bPn().bRa() == 1) {
                this.gCw.onResume();
            }
            this.gCw.onRefresh();
        }
        if (this.gCD != null) {
            this.gCD.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.gnW && this.gCV != null) {
            if (this.gnq != null) {
                this.gnq.Jf().getView().setVisibility(0);
            }
            if (this.gnq != null) {
                this.gnq.Jg().show();
                this.gnq.Jg().setEditText(" @" + this.gCV.getNameShow() + " ");
            }
            us(8);
            this.gnW = false;
        }
        if (this.gDu != null) {
            this.gDu.resume();
        }
        if (this.gDv != null) {
            this.gDv.resume();
        }
    }

    public void onPause() {
        if (this.gCD != null) {
            this.gCD.onPause();
        }
        if (this.gDu != null) {
            this.gDu.pause();
        }
        if (this.gnD != null) {
            this.gnD.onPause();
        }
        if (this.gDv != null) {
            this.gDv.pause();
        }
    }

    private void bTN() {
        if (bc.c(com.baidu.live.w.a.Nk().bka)) {
            this.gCR.setVisibility(0);
            this.gCR.setAlpha(0.2f);
        } else if (bPn().gxE.hasBeauty() < 0) {
            this.gCR.setVisibility(8);
        } else {
            this.gCR.setVisibility(0);
        }
    }

    private void bTO() {
        this.gCG = (RelativeLayout) bPn().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.gCI = (RelativeLayout) bPn().rootView.findViewById(a.g.under_live_view_panel);
        this.gCJ = (RelativeLayout) bPn().rootView.findViewById(a.g.over_live_view_panel);
        this.gCK = (FrameLayout) bPn().rootView.findViewById(a.g.goods_parent);
        this.gqb.gxf.setOnLiveViewScrollListener(this.gDT);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gCI.setVisibility(8);
            this.gCJ.setVisibility(8);
            bPn().gxf.removeAllViews();
            return;
        }
        this.gCH = (RelativeLayout) bPn().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gCH.getLayoutParams();
        layoutParams.topMargin = this.gqb.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.gCH.setLayoutParams(layoutParams);
        if (this.gmq == null) {
            this.gmq = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gqb.pageContext.getPageActivity(), false);
        }
        this.gmq.a(this.gmS);
        this.gmq.a(this.gCH, a.g.ala_live_room_host_header_stub, 1L);
        this.gmq.setVisible(0);
        bTP();
        this.gCR = (ImageView) bPn().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.gCU = (TextView) bPn().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn_num);
        this.gCR.setOnClickListener(this.gDK);
        this.gCT = (ImageView) bPn().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.gCT.setOnClickListener(this.gDK);
        if (com.baidu.live.w.a.Nk().bka != null && com.baidu.live.w.a.Nk().bka.aJw != null && com.baidu.live.w.a.Nk().bka.aJw.CW() && bc.b(com.baidu.live.w.a.Nk().bka)) {
            this.gCT.setVisibility(0);
        } else {
            this.gCT.setVisibility(8);
        }
        bTN();
        this.gCQ = (ImageView) bPn().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.gCQ.setOnClickListener(this.gDK);
        this.gCO = (ImageView) bPn().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.gCO.setOnClickListener(this.gDK);
        this.gqi = (ImageView) bPn().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.gqi.setOnClickListener(this.gDK);
        this.gCP = (ImageView) bPn().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.gCP.setOnClickListener(this.gDK);
        this.gCS = (ImageView) bPn().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.gCS.setOnClickListener(this.gDK);
        bTS();
        if (bc.b(com.baidu.live.w.a.Nk().bka)) {
            this.gDq = new com.baidu.tieba.ala.liveroom.h.b(bPn().gxG, bPn(), bPn().gxE);
        }
        this.gnp = new m();
        bTQ();
        bTR();
        if (com.baidu.live.c.AD().getInt("beauty_new_bubble", 1) == 1) {
            this.gCU.setVisibility(0);
        }
    }

    private void bTP() {
        this.gDC = (FrameLayout) View.inflate(bPn().pageContext.getPageActivity(), a.h.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gDC != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.gDC.setVisibility(8);
            if (this.gDC.getParent() != null && (this.gDC.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gDC.getParent()).removeView(this.gDC);
            }
            this.gCG.addView(this.gDC, layoutParams);
            if (this.gDC != null) {
                this.gDC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.gmS.m(AlaMasterLiveRoomOpearator.this.gDC, 8);
                    }
                });
            }
        }
    }

    private void bTQ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bPn().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gnq = (k) runTask.getData();
            this.gnq.setFromMaster(true);
            this.gnq.Jf().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bPn().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ab.b.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ab.b.cC(true);
            bPn().gxf.addView(this.gnq.Jf().getView(), layoutParams);
            this.gnq.Jg().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bPn().gxf.addView(this.gnq.Jg().getView(), layoutParams2);
            this.gnq.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                @Override // com.baidu.live.im.k.a
                public boolean Ji() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Jj() {
                }

                @Override // com.baidu.live.im.k.a
                public void gQ(String str) {
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

    private void bTR() {
        View AZ;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bPn().pageContext);
        if (runTask != null) {
            this.gnr = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gnr != null && (AZ = this.gnr.AZ()) != null && this.gqb.gxf.indexOfChild(AZ) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gqb.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bPn().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bPn().gxf.addView(AZ, layoutParams);
        }
    }

    private void bTS() {
        CustomResponsedMessage runTask;
        if (this.gCX == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.y.a.class, bPn().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gCX = (com.baidu.live.y.a) runTask.getData();
        }
    }

    private void bTT() {
        View ED;
        v.b(bPn().pageContext, true);
        if (this.gns == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aMH = true;
            fVar.context = bPn().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gns = (w) runTask.getData();
                if (this.gns != null && (ED = this.gns.ED()) != null && bPn().gxf.indexOfChild(ED) < 0) {
                    if (ED.getParent() instanceof ViewGroup) {
                        ((ViewGroup) ED.getParent()).removeView(ED);
                    }
                    bPn().gxf.addView(ED, bPn().gxf.getLayoutParams());
                }
            }
        }
    }

    protected void bOn() {
        View EV;
        if (this.gnt == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aMH = true;
            aVar.context = bPn().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnt = (u) runTask.getData();
            }
        }
        if (this.gnt != null && (EV = this.gnt.EV()) != null) {
            if (bPn().gxf.indexOfChild(EV) < 0) {
                if (EV.getParent() instanceof ViewGroup) {
                    ((ViewGroup) EV.getParent()).removeView(EV);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.gnB != null && this.gnB.isShowing()) {
                    layoutParams.addRule(3, a.g.guard_club_entry_id);
                    layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else if (this.gCz != null && this.gCz.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
                    layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else {
                    layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                    layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds66);
                }
                bPn().gxf.addView(EV, layoutParams);
            }
            EV.bringToFront();
        }
    }

    protected void bOm() {
        View Fc;
        if (this.gnD == null) {
            ab abVar = new ab();
            abVar.aMH = true;
            abVar.pageContext = bPn().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.gnD = (y) runTask.getData();
            }
        }
        if (this.gnD != null && (Fc = this.gnD.Fc()) != null && bPn().gxf.indexOfChild(Fc) < 0) {
            if (Fc.getParent() instanceof ViewGroup) {
                ((ViewGroup) Fc.getParent()).removeView(Fc);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bPn().gxf.addView(Fc, layoutParams);
        }
    }

    private void bTU() {
        bTY();
        bNn();
        bTX();
        bPn().gxf.setVisibility(0);
        us(0);
    }

    private void bTV() {
        if (this.gCz == null) {
            this.gCz = new com.baidu.tieba.ala.liveroom.u.a(bPn().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gCz.a(bPn().bRa(), j, TbadkCoreApplication.getCurrentAccountName(), true, bPn().gxe.LC().aDE.portrait, this.otherParams, "", -1L);
        this.gCz.as(bPn().gxf);
    }

    private void bTW() {
        if (this.gCZ == null) {
            bPn().gxf.gLW = false;
            com.baidu.live.x.a eO = eO(bPn().pageContext.getPageActivity());
            if (eO != null) {
                this.gCZ = eO;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.x.a.class, bPn().pageContext.getPageActivity());
                if (runTask != null) {
                    this.gCZ = (com.baidu.live.x.a) runTask.getData();
                }
            }
            if (this.gCZ != null) {
                this.gCZ.q(this.gCI);
                this.gCZ.r(this.gCJ);
                this.gCZ.eI((bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bPn().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                this.gCZ.s(bPn().gxf);
                this.gCZ.a(this.glN);
                this.gCZ.setLiveShowInfo(bPn().gxe.LC());
                this.gCZ.a(this.gms);
                this.gCZ.Nw();
                this.gCZ.a(new a.InterfaceC0202a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public void Nx() {
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public void Ny() {
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public void H(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bPn().gxE != null) {
                            AlaMasterLiveRoomOpearator.this.bPn().gxE.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int Nz() {
                        return AlaMasterLiveRoomOpearator.this.gCH.getBottom();
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int NA() {
                        return AlaMasterLiveRoomOpearator.this.gqb.gxf.getHeight() - (AlaMasterLiveRoomOpearator.this.gnq.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gnq.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gnq.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.x.a.InterfaceC0202a
                    public int NB() {
                        return AlaMasterLiveRoomOpearator.this.gnq.Jh();
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

    private void bTX() {
        if (this.gCB == null) {
            this.gCB = new b(bPn().pageContext, bPn().gxf);
        }
    }

    private void bTY() {
        if (this.gmn == null) {
            this.gmn = new com.baidu.tieba.ala.liveroom.o.a(bPn().pageContext, true, this.gDO);
            this.gmn.c(this.gCH, (r) null);
            this.gmn.a(this.gmS);
        }
        if (this.gCx == null) {
            this.gCx = new com.baidu.tieba.ala.liveroom.o.a(bPn().pageContext, true, null);
            this.gCx.a(this.gCH, null, a.g.ala_live_room_host_header_stub);
            this.gCx.bSL();
        }
    }

    protected void bNW() {
        CustomResponsedMessage runTask;
        boolean z = false;
        ag bVB = bPn().gxe.bVB();
        boolean z2 = com.baidu.live.w.a.Nk().beH.aHh;
        if (bVB == null || bVB.aEo) {
            z = z2;
        }
        if (z && this.gnc == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bPn().pageContext)) != null) {
            this.gnc = (com.baidu.live.h.a) runTask.getData();
            if (this.gnc != null) {
                this.gnc.setIsHost(true);
                this.gnc.ev(1);
                View view = this.gnc.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bPn().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bPn().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.gCH.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(r rVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gms == null) {
            this.gms = new com.baidu.tieba.ala.liveroom.activeview.b(bPn().pageContext);
        }
        this.gms.setOtherParams(this.otherParams);
        this.gms.b(rVar, false);
        this.gms.setHost(true);
        this.gms.a(1, this.bhH);
        this.gms.a(2, this.bhH);
        this.gms.lA(this.gob);
        this.gms.setVisible(this.gCv ? 8 : 0);
        this.gms.a(this.glN);
        if (this.glN != null) {
            if (this.gms != null) {
                alaActiveRootView2 = this.gms.tL(1);
                alaActiveRootView = this.gms.tL(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.glN.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.glN.a(alaActiveRootView);
            }
        }
    }

    private void x(r rVar) {
        CustomResponsedMessage runTask;
        if (this.gnP == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bPn().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.s.a)) {
            this.gnP = (com.baidu.live.s.a) runTask.getData();
            if (this.gnP != null) {
                this.gnP.p(this.bhH);
            }
        }
        if (this.gnP != null) {
            this.gob = this.gnP.p(rVar);
            this.gnP.setCanVisible(!this.gCv);
        }
    }

    protected void bTZ() {
        CustomResponsedMessage runTask;
        if (bPn() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bPn().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gnL = (com.baidu.live.i.a) runTask.getData();
            this.gnL.a(bPn().gxf, bUa());
            if (bPn().gxe != null) {
                this.gnL.a(bPn().gxe.LC());
            }
            this.gnL.setCanVisible(true);
            this.gnL.bK(false);
            this.gnL.a(bPn().gxe.bIv());
        }
    }

    private void bOf() {
        this.gDv = new com.baidu.tieba.ala.liveroom.q.c(bPn().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bUa() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bPn().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.gnB != null && this.gnB.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else if (this.gCz != null && this.gCz.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        }
        return layoutParams;
    }

    private void bNn() {
        if (this.gCy == null) {
            this.gCy = new com.baidu.tieba.ala.liveroom.b.a(bPn().pageContext, true);
        }
    }

    private void bUb() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bPn().pageContext.getPageActivity();
            if (this.gDa == null) {
                this.gDa = new ImageView(pageActivity);
                this.gDa.setId(a.g.master_close_btn);
                this.gDa.setTag("master_close_btn");
                this.gDa.setImageResource(a.f.sdk_icon_bar_live_close_n);
                this.gDa.setBackgroundResource(a.f.sdk_round_btn_close_bg);
                this.gDa.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            }
            if (this.gDa.getParent() != null) {
                ((ViewGroup) this.gDa.getParent()).removeView(this.gDa);
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
            bPn().gxG.addView(this.gDa, layoutParams);
            this.gDa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bUl();
                }
            });
            this.gDa.setVisibility(8);
        }
    }

    private void bOq() {
        if (this.gnB == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bPn().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gnB = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.gnB.setHost(true);
        this.gnB.setOtherParams(this.otherParams);
        if (bPn().gxe.LC() != null && bPn().gxe.LC().aDE != null && bPn().gxe.LC().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
            layoutParams.leftMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.gnB.a(bPn().gxf, layoutParams, bPn().gxe.LC());
        }
    }

    private void bUc() {
        CustomResponsedMessage runTask;
        if (this.gDt == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bPn().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.gDt = (com.baidu.live.b.a) runTask.getData();
            if (this.gDt != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bPn().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gDt.a(bPn().gxf, layoutParams);
            }
        }
        if (this.gDt != null) {
            this.gDt.a(bPn().gxe.LC());
        }
    }

    private void bUd() {
        CustomResponsedMessage runTask;
        if (this.gDu == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bPn().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.gDu = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.gDs != null) {
            this.gDs.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bPn().pageContext.registerListener(this.goq);
        bPn().pageContext.registerListener(this.gDE);
        bPn().pageContext.registerListener(this.gos);
        bPn().pageContext.registerListener(this.got);
        bPn().pageContext.registerListener(this.gDL);
        bPn().pageContext.registerListener(this.bre);
        bPn().pageContext.registerListener(this.gkC);
        bPn().pageContext.registerListener(this.gDM);
        bPn().pageContext.registerListener(this.gor);
        bPn().pageContext.registerListener(this.gmN);
        bPn().pageContext.registerListener(this.gDV);
        bPn().pageContext.registerListener(this.gox);
        bPn().pageContext.registerListener(this.gDI);
        bPn().pageContext.registerListener(this.gDJ);
        bPn().pageContext.registerListener(this.gDF);
        bPn().pageContext.registerListener(this.bem);
        bPn().pageContext.registerListener(this.ben);
        bPn().pageContext.registerListener(this.gDG);
        bPn().pageContext.registerListener(this.goz);
        bPn().pageContext.registerListener(this.goy);
        bPn().pageContext.registerListener(this.goA);
        bPn().pageContext.registerListener(this.gDH);
        bPn().pageContext.registerListener(this.gDG);
        bPn().pageContext.registerListener(this.bdu);
        bPn().pageContext.registerListener(this.baq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mq(boolean z) {
        if (bc.c(com.baidu.live.w.a.Nk().bka)) {
            bPn().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bPn().gxI.AT() == null || ListUtils.isEmpty(bPn().gxI.AT().azA)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bPn().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.gDw) {
                this.gDx = BdUniqueId.gen();
                bPn().gxI.a(this.gDx);
                this.gDw = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bPn().pageContext.getPageActivity(), bPn().rootView);
            us(8);
            if (bPn().gxE.hasAdvancedBeauty() && this.gDq != null) {
                if (!this.gDy || this.gCw.getVisibility() == 0) {
                    this.gDq.a(bPn().gxE.getVideoConfig());
                }
                this.gDq.a(bPn().gxE.getVideoConfig(), this.gDr);
                if (!this.gDr) {
                    this.gDr = true;
                }
            }
            if (z && this.gnq != null) {
                this.gnq.Jf().getView().setVisibility(4);
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
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPn().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bPn().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bPn().f((short) 1);
            }
        });
        bdAlertDialog.create(bPn().pageContext).show();
    }

    private void Gh(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPn().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bPn().f((short) 1);
            }
        });
        bdAlertDialog.create(bPn().pageContext).show();
    }

    public void bUe() {
        bNW();
        com.baidu.live.data.k bIv = bPn().gxe.bIv();
        int i = 5;
        if (bIv != null) {
            i = (int) bIv.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() != null && AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bPn().gxe.f(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bIv != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gqb.gxL.b(bIv);
                return;
            }
            if (this.gmm == null) {
                this.gmm = new c(bPn().pageContext, this.gDO, true);
            }
            if (this.gDo) {
                this.gDo = false;
                this.gmm.a(String.valueOf(bPn().gxe.LC().mLiveInfo.group_id), String.valueOf(bPn().gxe.LC().mLiveInfo.live_id), String.valueOf(bPn().gxe.LC().aDE.userId), bPn().gxe.LC());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.gnc != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.gmm.c(this.gCH, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.gmm.e(bIv);
            this.gmq.setVisible(0);
            this.gmq.dO(bIv.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUf() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkV() {
        if (bPn().gxe != null) {
            if (this.gnd == null) {
                this.gnd = new com.baidu.tieba.ala.liveroom.share.c(bPn().pageContext);
            }
            this.gnd.c(bPn().gxe.LC(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bPn().gxe != null && bPn().gxe.LC() != null && bPn().gxe.LC().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bPn().gxe.LC().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bPn().gxe.LC().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bPn().gxe.LC().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bPn().gxe != null && bPn().gxe.LC() != null && bPn().gxe.LC().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bPn().gxe.LC().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bPn().gxe.LC().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bPn().gxe.LC().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bUg() {
        return this.gCu;
    }

    private void mr(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(gCt, z);
        this.gCu = z;
    }

    private void bUh() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPn().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.p.b(AlaMasterLiveRoomOpearator.this.bPn().pageContext).bVj();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bPn().pageContext).show();
    }

    private void bUi() {
        if (this.gCd && bPn().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bPn().gxK.Oh();
        }
        bPn().gxJ.prepareTime = System.currentTimeMillis() - bPn().gxJ.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bPn().gxe != null && bPn().gxe.LC() != null && bPn().gxe.LC().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bPn().gxe.LC().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bPn().gxe.LC().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bPn().gxJ.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gCw != null && this.gCw.getView().getParent() != null) {
            this.gCw.setVisibility(8);
            bPn().gxG.removeView(this.gCw.getView());
            this.gCw.release();
        }
        if (this.gDq != null) {
            this.gDq.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bPn().gxf.indexOfChild(this.gCE) < 0) {
            bPn().gxf.addView(this.gCE, layoutParams);
        }
        this.gCE.uH(1000);
    }

    private void aob() {
        if (bPn().bRa() == 1) {
            bPn().gxE.startRecord();
        }
    }

    private void Gi(String str) {
        Gj(str);
    }

    private void Gj(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bPn().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.gCw != null) {
            this.gCw.FV(fromJson.getSmallurl());
        }
    }

    private boolean bUj() {
        return com.baidu.live.c.AD().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUk() {
        com.baidu.live.c.AD().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.gqb.gxE.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUl() {
        int i = a.i.live_close_confirm;
        if (this.gDs != null && this.gDs.bPs()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.gDs != null && this.gDs.bPr()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bPn().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bPn().gxe.LC() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC(), 0, AlaMasterLiveRoomOpearator.this.bPn().gxe.bVK() != 1 ? AlaMasterLiveRoomOpearator.this.bPn().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bPn().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(r rVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (rVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = rVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = rVar.aDE;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bPn().gxe.ef(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.gDm) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bPn().gxJ;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bPn().gxE.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.gDi;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.gDj;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.gDe;
            if (this.gDf != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.gDg - this.gDh) / this.gDf) * 100.0f;
            }
            Intent intent = new Intent(bPn().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bPn().gxe != null && bPn().gxe.LC() != null && bPn().gxe.LC().aDE != null) {
                String str3 = bPn().gxe.LC().aDE.nickName;
                String str4 = bPn().gxe.LC().aDE.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            r LC = bPn().gxe.LC();
            if (LC != null && LC.aDE != null && !TextUtils.isEmpty(LC.aDE.portrait)) {
                intent.putExtra("host_portrait", LC.aDE.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.gDk = intent;
                this.gDl = s;
                bPn().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bUm() {
        if (this.gDk != null) {
            a(this.gDk, this.gDl);
            this.gDk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.gDm = true;
        if (this.gDs != null) {
            this.gDs.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.gkr);
            bPn().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bPn().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUn() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gqb.gxL != null && this.gqb.gxL.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.gDs != null && this.gDs.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bPn().gxH.bUS()) {
                bUl();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.gCF != null) {
                this.gCF.setVisibility(4);
                return;
            }
            return;
        }
        if (this.gCF != null) {
            this.gCF.a(i, z, i2, z2);
        }
        if (this.gqb != null && this.gqb.gxe != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cXt != i3) {
                this.cXt = i3;
                if (this.gCC == null) {
                    this.gCC = new com.baidu.tieba.ala.liveroom.tippop.a(this.gqb.pageContext, null);
                }
                switch (this.cXt) {
                    case 0:
                        this.gCC.a(this.gqb.gxG, this.gqb.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.gCC.a(this.gqb.gxG, this.gqb.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.gCC.a(this.gqb.gxG, this.gqb.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gqb.gxe.k(this.gqb.gxe.LC().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.bUn();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x061d, code lost:
        FN(r6);
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
            if (this.gCA != null) {
                this.gCA.C(aVar);
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
                        if (this.gDs != null) {
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
            if (this.gDs != null) {
                this.gDs.fI(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bUn();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bPn().gxe.LC(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bPn().gxe.LC() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bPn().gxe.LC().aEd.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bPn().gxe.LC().aEd.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bPn().gxe.LC().aEd.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bPn().gxe.LC() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bPn().gxe.LC() != null && bPn().gxe.LC().aDE != null && bPn().gxe.LC().aDE.userId == optLong2) {
                        bPn().gxe.LC().aDE.isUegBlock = 1;
                        bNA();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bPn().gxe.LC() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bPn().gxe.LC() != null && bPn().gxe.LC().aDE != null && bPn().gxe.LC().aDE.userId == optLong3) {
                        bPn().gxe.LC().aDE.isUegBlock = 0;
                        bNA();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.gCX != null) {
                    this.gCX.N(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.gCB.aF(optString4, optInt2);
                    }
                    if (this.gmq.getCount() > 20) {
                        this.gmq.dO(this.gmq.getCount() + 1);
                    } else if (this.gmm != null) {
                        com.baidu.live.data.a JK = aVar.JK();
                        j jVar = new j();
                        jVar.aDF = new AlaLocationData();
                        jVar.aDG = new AlaRelationData();
                        jVar.aDE = new AlaLiveUserInfoData();
                        jVar.aDE.userId = JavaTypesHelper.toLong(JK.userId, 0L);
                        jVar.aDE.userName = JK.userName;
                        jVar.aDE.portrait = JK.portrait;
                        if (this.gmm.c(jVar)) {
                            this.gmq.dO(this.gmq.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bPn().gxe.LC() != null && bPn().gxe.LC().mLiveInfo != null) {
                    long j4 = bPn().gxe.LC().mLiveInfo.live_id;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!com.baidu.live.utils.m.i(j4, optLong4)) {
                        if (this.gCD != null) {
                            this.gCD.KN();
                        }
                        com.baidu.live.utils.m.j(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bPn() != null && bPn().gxe != null && bPn().gxe.LC() != null && bPn().gxe.LC().aEd != null && bPn().gxe.LC().aEd.userId == jSONObject2.optLong("user_id")) {
                    bPn().gxe.bVA();
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
                    if (JK2 != null && v.gq(str6)) {
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
                        Gk(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bPn().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(bPn().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
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
                if (bPn().gxe != null && bPn().gxe.LC() != null && bPn().gxe.LC().mLiveInfo != null) {
                    j5 = bPn().gxe.LC().mLiveInfo.live_id;
                    j6 = bPn().gxe.LC().mLiveInfo.group_id;
                    j7 = bPn().gxe.LC().aDE.userId;
                    str7 = bPn().gxe.LC().mLiveInfo.appId;
                    if (bPn().gxe.LC().mLiveSdkInfo.mCastIds != null) {
                        String str8 = bPn().gxe.LC().mLiveSdkInfo.mCastIds.aDW;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bPn().gxe.LC().mLiveSdkInfo.mCastIds.aDX;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString6, "");
                        if (this.isBackground || bPn().bRa() != 2) {
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
                                                if (com.baidu.live.w.d.Nr().hc(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                        FN(optString6);
                        com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar.gwJ = optLong6;
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
                FN(optString6);
                com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                cVar2.gwJ = optLong6;
                cVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void FN(String str) {
        if (this.gms != null) {
            this.gms.FN(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void us(int i) {
        View findViewById = bPn().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gms != null) {
            this.gms.bI(2, i);
        }
    }

    private void bUo() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bPn().gxE != null && AlaMasterLiveRoomOpearator.this.bPn().gxE.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bPn().gxE.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bPn().gxE.startRecord();
                }
            }
        });
    }

    private void bUp() {
        if (bPn().gxE != null && bPn().gxE.getPreview() != null) {
            bPn().gxE.getPreview().setVisibility(8);
            bPn().gxE.stopRecord();
        }
    }

    public void bUq() {
        this.gxB = bPn().gxe.bVL();
        if (this.gCw != null) {
            this.gCw.lZ(this.gxB);
        }
    }

    public void bQY() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bUr();
        } else if (this.gCw != null) {
            this.gCw.bQY();
        }
    }

    public void ma(boolean z) {
        if (this.gCw != null) {
            this.gCw.ma(z);
        }
    }

    public void onDestroy() {
        if (this.gDd != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.gDd);
        }
        this.gDd = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.gCW.removeCallbacksAndMessages(null);
        if (this.gDq != null) {
            this.gDq.lX(true);
        }
        this.gDq = null;
        if (this.gCw != null) {
            this.gCw.destroy();
            bPn().gxG.removeView(this.gCw.getView());
            this.gCw.release();
            this.gCw = null;
        }
        if (this.gDs != null) {
            this.gDs.onDestroy();
        }
        if (this.gnd != null) {
            this.gnd.onDestroy();
        }
        if (this.gmn != null) {
            this.gmn.onDestroy();
            this.gmn = null;
        }
        if (this.gCx != null) {
            this.gCx.onDestroy();
        }
        if (this.gnD != null) {
            this.gnD.onDestroy();
            this.gnD = null;
        }
        if (this.gCE != null) {
            this.gCE.stopCountDown();
        }
        if (this.gCz != null) {
            this.gCz.onDestroy();
        }
        if (this.gCB != null) {
            this.gCB.onDestroy();
        }
        if (this.gCX != null) {
            this.gCX.onDestroy();
            this.gCX = null;
        }
        if (this.gns != null) {
            this.gns.onDestroy();
            this.gns = null;
        }
        v.EY();
        com.baidu.live.entereffect.a.Dg().release();
        if (this.gnt != null) {
            this.gnt.onDestroy();
            this.gnt = null;
        }
        if (this.gCC != null) {
            this.gCC.onDestroy();
        }
        if (this.gCA != null) {
            this.gCA.bXJ();
            this.gCA.release();
        }
        if (this.gmq != null) {
            this.gmq = null;
        }
        if (this.gms != null) {
            this.gms.release();
        }
        if (this.gCA != null) {
            this.gCA.onDestroy();
        }
        if (this.gnr != null) {
            this.gnr.release();
        }
        if (this.gCD != null) {
            this.gCD.release();
        }
        if (this.gnB != null) {
            this.gnB.onDestroy();
        }
        if (this.gCZ != null) {
            this.gCZ.onDestroy();
        }
        if (this.gnP != null) {
            this.gnP.release();
        }
        if (this.gDt != null) {
            this.gDt.onDestory();
        }
        if (this.gDu != null) {
            this.gDu.release();
        }
        if (this.gnL != null) {
            this.gnL.onDestroy();
        }
        if (this.gDv != null) {
            this.gDv.release();
        }
        MessageManager.getInstance().unRegisterListener(this.gmN);
        MessageManager.getInstance().unRegisterListener(this.gDV);
        MessageManager.getInstance().unRegisterListener(this.gox);
        MessageManager.getInstance().unRegisterListener(this.gDI);
        MessageManager.getInstance().unRegisterListener(this.gDJ);
        MessageManager.getInstance().unRegisterListener(this.gDF);
        MessageManager.getInstance().unRegisterListener(this.bem);
        MessageManager.getInstance().unRegisterListener(this.ben);
        MessageManager.getInstance().unRegisterListener(this.gDG);
        MessageManager.getInstance().unRegisterListener(this.goz);
        MessageManager.getInstance().unRegisterListener(this.goy);
        MessageManager.getInstance().unRegisterListener(this.goA);
        MessageManager.getInstance().unRegisterListener(this.gDH);
        MessageManager.getInstance().unRegisterListener(this.gDG);
        MessageManager.getInstance().unRegisterListener(this.bdu);
        MessageManager.getInstance().unRegisterListener(this.baq);
        com.baidu.live.utils.m.Pl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(au auVar) {
        if (auVar != null && auVar.eventType == 1001 && this.gCD != null) {
            this.gCD.KN();
        }
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gqb.gxL.a(this.gDX, this.gqb.gxF, this.gCG, alaLivePersonData);
        }
    }

    private void bUr() {
        if (this.gDb != null) {
            this.gqb.gxJ.startTime = System.currentTimeMillis();
            this.gqb.gxJ.liveTotalTime = System.currentTimeMillis();
            this.gqb.gxJ.sampleMemAndCPU();
            this.gqb.gxH.a((short) 4, this.gDb);
        }
    }

    private void Gk(String str) {
        String str2;
        int i;
        if (bPn() != null && bPn().pageContext != null) {
            this.gCW.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bPn().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.gDB == null) {
                    this.gDB = layoutInflater.inflate(a.h.layout_challenge_entry_toast, (ViewGroup) null);
                    this.gDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaMasterLiveRoomOpearator.this.gCW.removeCallbacksAndMessages(null);
                            if (AlaMasterLiveRoomOpearator.this.gDB != null) {
                                AlaMasterLiveRoomOpearator.this.bPn().gxf.removeView(AlaMasterLiveRoomOpearator.this.gDB);
                            }
                            if (AlaMasterLiveRoomOpearator.this.gDs != null) {
                                AlaMasterLiveRoomOpearator.this.gDs.bPp();
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.gDB.findViewById(a.g.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.i.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.gCW.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bPn().gxf != null && AlaMasterLiveRoomOpearator.this.gqi != null && AlaMasterLiveRoomOpearator.this.gDB != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.gDB.findViewById(a.g.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.gDB.findViewById(a.g.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.u((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.gDB.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gqi.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gqi.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gqi.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gqi.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.gDB.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.gDB.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.gDB != null) {
                                AlaMasterLiveRoomOpearator.this.bPn().gxf.removeView(AlaMasterLiveRoomOpearator.this.gDB);
                            }
                            AlaMasterLiveRoomOpearator.this.bPn().gxf.addView(AlaMasterLiveRoomOpearator.this.gDB, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.w.a.Nk().beH != null) {
                    i = com.baidu.live.w.a.Nk().beH.aGu;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.gCW.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bPn().gxf != null && AlaMasterLiveRoomOpearator.this.gDB != null) {
                            AlaMasterLiveRoomOpearator.this.bPn().gxf.removeView(AlaMasterLiveRoomOpearator.this.gDB);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
