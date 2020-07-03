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
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ae;
import com.baidu.live.data.am;
import com.baidu.live.data.an;
import com.baidu.live.data.aq;
import com.baidu.live.data.ar;
import com.baidu.live.data.az;
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
import com.baidu.live.utils.m;
import com.baidu.live.w.a;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.challenge.e;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.g.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.share.c;
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
/* loaded from: classes3.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String gkD;
    private boolean aVY;
    private PendantParentView bbS;
    private String fTa;
    private com.baidu.live.g.a fUt;
    private com.baidu.live.h.a fVW;
    private c fVX;
    private com.baidu.tieba.ala.liveroom.p.b fVY;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fVf;
    private com.baidu.tieba.ala.liveroom.m.a fVg;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fVj;
    private com.baidu.tieba.ala.liveroom.activeview.b fVl;
    protected com.baidu.live.i.a fWE;
    private com.baidu.live.r.a fWH;
    private boolean fWT;
    @Deprecated
    private com.baidu.tieba.ala.liveroom.watermark.a fWa;
    private o fWi;
    private k fWj;
    private l fWk;
    private w fWl;
    private u fWm;
    protected h fWu;
    protected y fWw;
    private boolean fXB;
    private ImageView fXQ;
    private f fYL;
    private ImageView fYS;
    private g fYT;
    private boolean gkE;
    private d gkG;
    private com.baidu.tieba.ala.liveroom.m.a gkH;
    @Deprecated
    private com.baidu.tieba.ala.liveroom.f.c gkI;
    private com.baidu.tieba.ala.liveroom.b.a gkJ;
    private com.baidu.tieba.ala.liveroom.s.a gkK;
    private com.baidu.tieba.ala.liveroom.w.a gkL;
    private b gkM;
    private com.baidu.tieba.ala.liveroom.tippop.a gkN;
    protected com.baidu.live.j.a gkO;
    private AlaLiveCountDownView gkP;
    private AlaLiveStreamStatusView gkQ;
    private RelativeLayout gkR;
    private RelativeLayout gkS;
    private RelativeLayout gkT;
    private RelativeLayout gkU;
    private FrameLayout gkV;
    private View gkW;
    private AlaLiveFaceVerifyView gkX;
    private ImageView gkY;
    private ImageView gkZ;
    private boolean gkn;
    private boolean glA;
    private e glB;
    private com.baidu.live.b.a glC;
    private com.baidu.live.b.b glD;
    private com.baidu.tieba.ala.liveroom.o.a glE;
    private boolean glF;
    private BdUniqueId glG;
    private boolean glH;
    private View glK;
    private ImageView gla;
    private ImageView glb;
    private ImageView glc;
    private ImageView gld;
    private TextView gle;
    private ae glf;
    private com.baidu.live.x.a glh;
    private com.baidu.tieba.ala.liveroom.master.panel.b gli;
    private com.baidu.live.w.a glj;
    private com.baidu.tieba.ala.liveroom.data.e glk;
    private short glu;
    private com.baidu.tieba.ala.liveroom.g.b glz;
    private boolean gkF = false;
    private boolean fWO = false;
    private Handler mHandler = new Handler();
    private Handler glg = new Handler();
    private boolean gll = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver glm = null;
    private boolean gln = false;
    private int glo = 0;
    private int glp = 0;
    private int glq = 0;
    private long glr = 0;
    private long gls = 0;
    private volatile boolean isBackground = false;
    private Intent glt = null;
    private int mOrientation = 1;
    private boolean ggp = false;
    private boolean glv = false;
    private boolean glw = true;
    private boolean fYQ = false;
    private boolean glx = true;
    private boolean gly = true;
    private int cKY = 0;
    private String otherParams = "";
    private int aWa = 0;
    private int glI = 5000;
    private boolean glJ = false;
    private Runnable glL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.fUt != null) {
                AlaMasterLiveRoomOpearator.this.fUt.wZ();
            }
        }
    };
    private CustomMessageListener aYV = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fYL.ggz != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fYL.ggz.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.y(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener aYW = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fYL.ggz != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fYL.ggz.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener fXh = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.fVY == null) {
                        AlaMasterLiveRoomOpearator.this.fVY = new com.baidu.tieba.ala.liveroom.p.b();
                    }
                    AlaMasterLiveRoomOpearator.this.fVY.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener fXo = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fWE != null) {
                AlaMasterLiveRoomOpearator.this.fWE.Co();
            }
        }
    };
    private CustomMessageListener glM = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fXe = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.CH(str);
            }
        }
    };
    private CustomMessageListener fXf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aYB();
        }
    };
    private CustomMessageListener fVG = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.fWm.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fXm = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener glN = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.glD != null) {
                q FU = AlaMasterLiveRoomOpearator.this.bCw().gfS.FU();
                long j = FU.mLiveInfo.live_id;
                long j2 = FU.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.glD.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener glO = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bCw().gfT);
            if (AlaMasterLiveRoomOpearator.this.gkG == null || AlaMasterLiveRoomOpearator.this.gkG.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.rL(0);
            }
            if (AlaMasterLiveRoomOpearator.this.fWj != null) {
                AlaMasterLiveRoomOpearator.this.fWj.Da().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.fWj.Db().hide();
            }
        }
    };
    private CustomMessageListener fXn = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.q(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU());
        }
    };
    private CustomMessageListener fXp = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fWw != null) {
                    ((com.baidu.tieba.ala.liveroom.o.b) AlaMasterLiveRoomOpearator.this.fWw).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener glP = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.glE != null) {
                    AlaMasterLiveRoomOpearator.this.glE.Dc(str);
                }
            }
        }
    };
    private CustomMessageListener glQ = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.glz != null) {
                        if (!data.auJ || AlaMasterLiveRoomOpearator.this.glG == null || !AlaMasterLiveRoomOpearator.this.glH) {
                            if (AlaMasterLiveRoomOpearator.this.glG != null && AlaMasterLiveRoomOpearator.this.glG == data.auI) {
                                if (data.auC != null && data.auC.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.glH || AlaMasterLiveRoomOpearator.this.gkG.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.glz.a(AlaMasterLiveRoomOpearator.this.bCw().ggs.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.glA = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bCw().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.glG = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bCw().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.glz.a(AlaMasterLiveRoomOpearator.this.bCw().ggs.getVideoConfig(), AlaMasterLiveRoomOpearator.this.glA);
                        if (!AlaMasterLiveRoomOpearator.this.glA) {
                            AlaMasterLiveRoomOpearator.this.glA = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.glF) {
                    AlaMasterLiveRoomOpearator.this.bCw().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.glF = false;
            }
        }
    };
    private CustomMessageListener glR = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bCw().ggs != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bCw().ggs.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.c.vf().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener aWc = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.aWa == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.aWa == 6) {
                            AlaMasterLiveRoomOpearator.this.bGl();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.aWa = 0;
            }
        }
    };
    private View.OnClickListener glS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.gkZ) {
                    AlaMasterLiveRoomOpearator.this.bGp();
                    AlaMasterLiveRoomOpearator.this.gli.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.gkY) {
                    if (view == AlaMasterLiveRoomOpearator.this.gla) {
                        AlaMasterLiveRoomOpearator.this.aYB();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.glb) {
                        if (view != AlaMasterLiveRoomOpearator.this.gld) {
                            if (view != AlaMasterLiveRoomOpearator.this.fYS) {
                                if (view == AlaMasterLiveRoomOpearator.this.glc && AlaMasterLiveRoomOpearator.this.gkL != null) {
                                    com.baidu.tieba.ala.liveroom.data.h bIr = AlaMasterLiveRoomOpearator.this.bCw().gfS.bIr();
                                    if (bIr == null || bIr.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(bIr.mLiveSdkInfo.mRoomId);
                                        if (bIr.mLiveSdkInfo.mCastIds != null) {
                                            str2 = bIr.mLiveSdkInfo.mCastIds.axB;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.gkL.ah("", str, str2);
                                    return;
                                }
                                return;
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.glB != null) {
                                AlaMasterLiveRoomOpearator.this.glB.bCy();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.glj != null) {
                            AlaMasterLiveRoomOpearator.this.glj.showDialog();
                            AlaMasterLiveRoomOpearator.this.glj.cc(AlaMasterLiveRoomOpearator.this.bGt());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.glH = false;
                        AlaMasterLiveRoomOpearator.this.lj(true);
                        AlaMasterLiveRoomOpearator.this.gle.setVisibility(4);
                        com.baidu.live.c.vf().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.v.a.Hm().aZp.aAQ == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Hm().aZp.aAP == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.aVY) {
                        AlaMasterLiveRoomOpearator.this.bGl();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.aWa = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bGl();
                }
            }
        }
    };
    private CustomMessageListener fXg = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ae) {
                    AlaMasterLiveRoomOpearator.this.fWO = true;
                    AlaMasterLiveRoomOpearator.this.glf = (ae) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.fWj != null) {
                        AlaMasterLiveRoomOpearator.this.fWj.Da().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fWj != null) {
                        AlaMasterLiveRoomOpearator.this.fWj.Db().show();
                        AlaMasterLiveRoomOpearator.this.fWj.Db().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.rL(8);
                }
            }
        }
    };
    private CustomMessageListener glT = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bCw() != null && AlaMasterLiveRoomOpearator.this.bCw().ggx != null) {
                AlaMasterLiveRoomOpearator.this.bCw().ggx.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener ble = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bHc();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bCw().gfS.rS(i);
                if (AlaMasterLiveRoomOpearator.this.fWE != null) {
                    AlaMasterLiveRoomOpearator.this.fWE.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener fTl = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bGV();
        }
    };
    public final HttpMessageListener glU = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.FY()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.gli != null) {
                            AlaMasterLiveRoomOpearator.this.gli.lq(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.gli.bHA();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bCw().ggs.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.gkN != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.gkN.a(AlaMasterLiveRoomOpearator.this.bCw().ggu, AlaMasterLiveRoomOpearator.this.bCw().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bCw().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.gkN.sa(2);
                        AlaMasterLiveRoomOpearator.this.gkN.a(AlaMasterLiveRoomOpearator.this.bCw().ggu, string, 3);
                    }
                }
            }
        }
    };
    private e.a glV = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bHi() {
            AlaMasterLiveRoomOpearator.this.bGS();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bHj() {
            AlaMasterLiveRoomOpearator.this.bGT();
        }
    };
    com.baidu.live.liveroom.a.a glW = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean cG(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cH(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cI(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bCw().bEk() == 1) {
                AlaMasterLiveRoomOpearator.this.bCw().ggs.stopRecord();
            }
        }
    };
    private IShareCallback glX = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.gll && AlaMasterLiveRoomOpearator.this.glk != null) {
                AlaMasterLiveRoomOpearator.this.gll = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.glk);
            }
        }
    };
    private View.OnTouchListener glY = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bCw().ggx.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bCw().gfT);
            AlaMasterLiveRoomOpearator.this.rL(0);
            if (AlaMasterLiveRoomOpearator.this.fWj != null) {
                AlaMasterLiveRoomOpearator.this.fWj.Da().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.fWj.Db().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b glZ = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bHk() {
            AlaMasterLiveRoomOpearator.this.bGm();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bHl() {
            AlaMasterLiveRoomOpearator.this.gkn = AlaMasterLiveRoomOpearator.this.gkG.bEc();
            AlaMasterLiveRoomOpearator.this.bCw().ggx.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bCw().ggx.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bCw().ggx.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.ggm = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bCw().bEk();
            eVar.title = AlaMasterLiveRoomOpearator.this.gkG.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.ggn = AlaMasterLiveRoomOpearator.this.gkG.bEd();
            eVar.ggq = AlaMasterLiveRoomOpearator.this.gkn;
            eVar.ggp = AlaMasterLiveRoomOpearator.this.gkG.bEa();
            eVar.ggo = AlaMasterLiveRoomOpearator.this.gkG.bEf();
            eVar.ggr = AlaMasterLiveRoomOpearator.this.gkG.bEb();
            if (eVar.ggr) {
                if (AlaMasterLiveRoomOpearator.this.gkG.bEg()) {
                    AlaMasterLiveRoomOpearator.this.gll = true;
                    AlaMasterLiveRoomOpearator.this.glk = eVar;
                    AlaMasterLiveRoomOpearator.this.gkG.bEh();
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
            AlaMasterLiveRoomOpearator.this.bCw().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bCw().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bHm() {
            AlaMasterLiveRoomOpearator.this.glH = true;
            AlaMasterLiveRoomOpearator.this.lj(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bHn() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bHo() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private Runnable gma = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.bCw().gfS != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo != null) {
                    m.k(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.gma, AlaMasterLiveRoomOpearator.this.glI);
                }
            }
        }
    };
    private CustomMessageListener aTJ = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bAM();
            }
        }
    };
    private com.baidu.live.liveroom.g.c gmb = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void FS() {
            if (AlaMasterLiveRoomOpearator.this.gkL != null) {
                AlaMasterLiveRoomOpearator.this.gkL.lC(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bV(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.glj != null) {
                        AlaMasterLiveRoomOpearator.this.glj.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.glj != null) {
                    AlaMasterLiveRoomOpearator.this.glj.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.gkL != null) {
                    AlaMasterLiveRoomOpearator.this.gkL.lC(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.fWw != null) {
                    AlaMasterLiveRoomOpearator.this.fWw.be(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a gmc = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void RB() {
            if (AlaMasterLiveRoomOpearator.this.gkX != null && AlaMasterLiveRoomOpearator.this.bCw().ggu.indexOfChild(AlaMasterLiveRoomOpearator.this.gkX) >= 0) {
                AlaMasterLiveRoomOpearator.this.bCw().ggu.removeView(AlaMasterLiveRoomOpearator.this.gkX);
                AlaMasterLiveRoomOpearator.this.gkX.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.gkX = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fVL = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            q FU;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bHb();
            } else if (i == 14 && (FU = AlaMasterLiveRoomOpearator.this.bCw().gfS.FU()) != null && FU.axp != null && FU.mLiveInfo != null && FU.axI != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity(), FU.axp.userName, Long.toString(FU.axp.userId), Long.toString(FU.axp.charmCount), String.valueOf(FU.mLiveInfo.group_id), String.valueOf(FU.mLiveInfo.live_id), true, String.valueOf(FU.axp.userId), Long.toString(FU.axI.userId), FU.axI.userName, FU.axI.portrait, AlaMasterLiveRoomOpearator.this.fVj.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(FU.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.fVj.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener gmd = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.bCw().gfS != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aZw != null && !eventPollingHttpResponseMessage.aZw.isEmpty()) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        for (int i = 0; i < eventPollingHttpResponseMessage.aZw.size(); i++) {
                            ar arVar = eventPollingHttpResponseMessage.aZw.get(i);
                            if (j == arVar.liveId && j2 - arVar.createTime <= 60 && !m.i(arVar.liveId, arVar.id)) {
                                m.a(arVar, AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo, true);
                                AlaLiveInfoData alaLiveInfoData = AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo;
                                AlaMasterLiveRoomOpearator.this.a(arVar, alaLiveInfoData.feed_id, alaLiveInfoData.live_id, alaLiveInfoData.user_id);
                                m.j(arVar.liveId, arVar.id);
                            }
                        }
                        ar arVar2 = eventPollingHttpResponseMessage.aZw.get(eventPollingHttpResponseMessage.aZw.size() - 1);
                        if (j == arVar2.liveId) {
                            m.h(arVar2.liveId, arVar2.id);
                        }
                    }
                }
                int i2 = eventPollingHttpResponseMessage.aZv;
                if (i2 <= 0) {
                    i2 = 5;
                }
                AlaMasterLiveRoomOpearator.this.glI = i2 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a gme = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private com.baidu.live.liveroom.middleware.g gmf = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.atx);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        gkD = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(q qVar) {
        if (qVar != null && qVar.mLiveInfo != null && com.baidu.live.v.a.Hm().aZp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bCw().pageContext.getPageActivity(), String.valueOf(qVar.mLiveInfo.live_id), String.valueOf(qVar.mLiveInfo.user_id), com.baidu.live.v.a.Hm().aZp.aAL, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CH(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bCw().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bCw().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Hm().aZp.aAl;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bCw().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bCw().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bCw().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAM() {
        int i = bCw().gfS.FU().axp.isUegBlock;
        int i2 = bCw().gfS.FU().axp.isBlock;
        String str = bCw().gfS.FU().axp.userName;
        if (i > 0 || i2 > 0) {
            this.aVY = true;
            this.fWj.a(true, i, i2, str);
            return;
        }
        this.aVY = false;
        this.fWj.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.fYL.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aWm == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aWn);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.fYL.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.fYL.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGl() {
        if (this.fWj != null) {
            this.fWj.Db().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.glB != null) {
            this.glB.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGm() {
        if (bCw() != null && bCw().gfS != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bCw().gfS.bIi();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bCw().gfS.bIj();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bvI() != null && aVar.bvJ() != null) {
            bCw().gfS.dM(aVar.bvI().getId(), aVar.bvJ().getId());
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
                    AlaMasterLiveRoomOpearator.this.gln = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.gln = false;
                }
                if (AlaMasterLiveRoomOpearator.this.glo == 0) {
                    AlaMasterLiveRoomOpearator.this.glo = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.glp == 0) {
                    AlaMasterLiveRoomOpearator.this.glp = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.glq = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bCw() != null && bCw().ggv != null) {
            bCw().ggv.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.fYL = fVar;
        this.fTa = str;
    }

    protected f bCw() {
        return this.fYL;
    }

    public int a(g gVar) {
        this.fYT = gVar;
        this.glm = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.glm, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.gkN == null) {
            this.gkN = new com.baidu.tieba.ala.liveroom.tippop.a(this.fYL.pageContext, null);
        }
        registerListener();
        this.fUt = new com.baidu.live.g.a();
        bGD();
        bGn();
        bGo();
        Long[] lArr = new Long[1];
        this.glr = lArr[0] == null ? 0L : lArr[0].longValue();
        this.gls = lArr[0] != null ? lArr[0].longValue() : 0L;
        bCw().gfT.setOnTouchListener(this.glY);
        this.gkE = SharedPrefHelper.getInstance().getBoolean(gkD, false);
        this.gkP = new AlaLiveCountDownView(bCw().pageContext.getPageActivity());
        this.gkP.setCount(3);
        this.gkP.setTextColor(bCw().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.gkP.setTextSize(bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.gkP.setTypeface(Typeface.DEFAULT_BOLD);
        this.gkP.setIncludeFontPadding(false);
        this.gkP.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bHp() {
                if (AlaMasterLiveRoomOpearator.this.bCw().gfT != null) {
                    AlaMasterLiveRoomOpearator.this.bCw().gfT.removeView(AlaMasterLiveRoomOpearator.this.gkP);
                }
            }
        });
        return 1;
    }

    private void bGn() {
        CustomResponsedMessage runTask;
        if (this.gkO == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.j.a.class, bCw().pageContext)) != null && runTask.getData() != null) {
            this.gkO = (com.baidu.live.j.a) runTask.getData();
            this.gkO.d(bCw().pageContext);
        }
    }

    private void bGo() {
        View rootLayout;
        if (this.gkO != null && this.gkV != null && (rootLayout = this.gkO.bO(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gkV.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGp() {
        if (this.gli == null) {
            this.gli = new com.baidu.tieba.ala.liveroom.master.panel.b(bCw().pageContext.getPageActivity(), bCw().bEk() == 2);
            this.gli.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ll(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bCw().ggs.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lm(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bCw().ggs.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ln(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bCw().ggs.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bHa();
                    if (AlaMasterLiveRoomOpearator.this.gkN != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.gkN.a(AlaMasterLiveRoomOpearator.this.bCw().ggu, AlaMasterLiveRoomOpearator.this.bCw().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.gkN.a(AlaMasterLiveRoomOpearator.this.bCw().ggu, AlaMasterLiveRoomOpearator.this.bCw().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void lo(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bHq() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bCw().gfS != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.gli != null) {
                        AlaMasterLiveRoomOpearator.this.gli.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bHr() {
                    if (AlaMasterLiveRoomOpearator.this.gli != null) {
                        AlaMasterLiveRoomOpearator.this.gli.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.f(AlaMasterLiveRoomOpearator.this.bCw().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bHs() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bCw() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.q(AlaMasterLiveRoomOpearator.this.bCw().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.gli != null) {
                            AlaMasterLiveRoomOpearator.this.gli.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bHt() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bCw() == null || AlaMasterLiveRoomOpearator.this.bCw().gfS == null || AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() == null || AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bCw() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.m(AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.gli != null) {
                                        AlaMasterLiveRoomOpearator.this.gli.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.m(AlaMasterLiveRoomOpearator.this.fYL.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.gli != null) {
                        AlaMasterLiveRoomOpearator.this.gli.dismiss();
                    }
                }
            });
        }
        bGq();
    }

    private void bGq() {
        if (this.gli != null) {
            boolean isBackCamera = bCw().ggs.isBackCamera();
            this.gli.lp(bCw().ggs.isBackCamera());
            this.gli.J(bCw().ggs.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bCw().ggs.isPushMirror();
            if (this.glw) {
                isPushMirror = bGZ() || isPushMirror;
                this.glw = false;
            }
            this.gli.K(isPushMirror, isBackCamera ? false : true);
            this.gli.lq(bCw().ggs.isMute());
            this.gli.bHA();
        }
    }

    public void bGr() {
        if (this.fYT != null) {
            if (this.fYT.ggA == null || this.fYT.ggA.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.gkW == null) {
                        this.gkW = this.fYL.ggz.FB();
                        this.fYL.ggu.addView(this.gkW, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.gkG == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bCw().gfS != null && bCw().gfS.FU() != null && bCw().gfS.FU().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bCw().gfS.FU().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bCw().gfS.FU().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.gkG = new d(bCw().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bCw().ggx.prepareTime = System.currentTimeMillis();
                    bCw().ggu.addView(this.gkG.getView(), layoutParams);
                    this.gkG.a(this.glX);
                }
                this.gkG.kV(this.ggp);
                this.gkG.a(this.glZ);
                this.gkG.a(this.glV);
                this.gkG.a(bCw().ggs, bCw().bEk());
                this.gkG.a(this.gkO);
                return;
            }
            this.gkn = this.fYT.ggA.mLiveInfo.screen_direction == 2;
            if (this.fYT.ggA.mLiveInfo.isAudioOnPrivate == 1) {
                bCw().ggs.setMute(true);
                if (this.gkN == null) {
                    this.gkN = new com.baidu.tieba.ala.liveroom.tippop.a(this.fYL.pageContext, null);
                }
                if (!this.gkN.rZ(2)) {
                    this.gkN.a(bCw().ggu, bCw().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.ggm = true;
            eVar.forumId = String.valueOf(this.fYT.ggA.mLiveInfo.forum_id);
            eVar.forumName = this.fYT.ggA.mLiveInfo.forum_name;
            eVar.liveType = this.fYT.ggA.mLiveInfo.live_type;
            eVar.title = this.fYT.ggA.mLiveInfo.getLiveTitle();
            eVar.clarity = this.fYT.ggA.mLiveInfo.clarity;
            eVar.gameId = this.fYT.ggA.mLiveInfo.game_id;
            eVar.gameName = this.fYT.ggA.mLiveInfo.game_label;
            eVar.ggq = this.fYT.ggA.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bGs() {
        if (this.glz != null) {
            this.glz.a(bCw().ggs.getVideoConfig(), false);
        }
        if (this.gkG != null) {
            this.gkG.kU(true);
        }
        if (bCw().ggs.hasBeauty() >= 0) {
            bCw().ggs.setBeauty(com.baidu.live.c.vf().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bCw().ggz.F(this.fYL.ggs);
        } else if (this.gkG != null) {
            this.gkG.kU(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.gkW != null && this.gkW.getParent() != null) {
                ((ViewGroup) this.gkW.getParent()).removeView(this.gkW);
                this.gkW = null;
            }
            bCw().gfT.setVisibility(0);
            this.fYL.ggz.a(bCw().gfT);
        } else {
            bGI();
            bGY();
            this.gkL = new com.baidu.tieba.ala.liveroom.w.a(bCw().pageContext, this.glW);
            this.gkL.d(bCw().gfT, true);
            this.gkL.lC(true);
            if (this.fWj != null && this.fWj.Da() != null) {
                this.fWj.Da().setNeedTopAlphaShade(true);
            }
        }
        bCw().ggs.setPushMirror(bGZ());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fYL.ggz.l(bCw().gfS.FU());
        }
        if (!bCw().ggs.isBackground() && bCw().gfS.FU() != null && bCw().gfS.FU().mLiveInfo != null) {
            int startPush = bCw().ggs.startPush(bCw().gfS.FU().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fYL.ggz.FC();
            }
            if (startPush != 0 && bCw().ggx != null) {
                bCw().ggx.errCode = 4;
                bCw().ggx.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.bEo() && !bGW()) {
                lk(true);
                bGX();
            }
            if (this.gkI != null) {
                this.gkI.r(bCw().gfS.FU());
            }
            if (this.fVg != null) {
                this.fVg.v(bCw().gfS.FU());
            }
            if (this.fVW != null) {
                this.fVW.a(bCw().gfS.FU());
            }
            if (this.gkO != null) {
                this.gkO.h(bCw().gfS.FU());
                this.gkO.fB(this.otherParams);
            }
            if (this.gkJ != null && bCw() != null && bCw().gfS != null) {
                if (this.gkJ.ar(bCw().gfT)) {
                    this.gkJ.p(bCw().gfS.FU());
                } else {
                    this.gkJ.b(bCw().gfT, bCw().gfS.FU());
                }
            }
            if (this.gkH != null) {
                this.gkH.v(bCw().gfS.FU());
            }
            if (hVar == null || hVar.axp == null) {
                z = com.baidu.live.c.vf().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.axp.canUseChallenge;
                com.baidu.live.c.vf().putBoolean("ala_master_can_use_challenge", z);
            }
            bGJ();
            bGw();
            li(z);
            bAw();
            bGK();
            bGP();
            bBC();
            w(bCw().gfS.FU());
            f(bCw().gfS.FU());
            bGQ();
            bGR();
            bGN();
            bBq();
            bBx();
            bBy();
            bGH();
            if (this.fWi != null) {
                this.fWi.g(bCw().gfS.FU());
            }
            if (this.fWj != null) {
                if (bCw().gfS.FU() != null && bCw().gfS.FU().axV != null && bCw().gfS.FU().axV.wo()) {
                    z2 = true;
                }
                this.fWj.a(String.valueOf(bCw().gfS.FU().mLiveInfo.group_id), String.valueOf(bCw().gfS.FU().mLiveInfo.last_msg_id), String.valueOf(bCw().gfS.FU().axp.userId), String.valueOf(bCw().gfS.FU().mLiveInfo.live_id), bCw().gfS.FU().axp.appId, z2);
            }
            if (this.fWk != null) {
                this.fWk.a(bCw().gfS.FU(), true);
            }
            if (!this.glJ && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.glJ = true;
                this.mHandler.post(this.gma);
            }
            this.mHandler.post(this.glL);
        }
    }

    private void bAw() {
        if (this.bbS == null) {
            this.bbS = new PendantParentView(bCw().pageContext.getPageActivity(), this.fXB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bCw().gfT.addView(this.bbS, layoutParams);
            this.bbS.setDefaultItemMargin(bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bbS.setPadding(bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bCe();
        }
    }

    private void bCe() {
        if (this.bbS != null) {
            int dimensionPixelSize = bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278);
            int dimensionPixelSize2 = bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bbS.getLayoutParams();
            if (this.fXB) {
                this.bbS.setPosition(0, 0, this.glB.bCh(), dimensionPixelSize2);
            } else {
                this.bbS.setPosition(dimensionPixelSize, 0, bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278), dimensionPixelSize2);
            }
            this.bbS.setLayoutParams(layoutParams);
            this.bbS.setModel(this.fXB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bCf() {
        if (this.fWj != null && this.fWj.Da() != null && this.fWj.Da().getView() != null) {
            if (this.fXB) {
                int screenHeight = (ScreenHelper.getScreenHeight(bCw().pageContext.getPageActivity()) - (this.glB != null ? this.glB.aW(false) : 0)) - bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
                ViewGroup.LayoutParams layoutParams = this.fWj.Da().getView().getLayoutParams();
                if (layoutParams != null && layoutParams.height > 0 && layoutParams.height >= screenHeight) {
                    layoutParams.height = screenHeight;
                    this.fWj.Da().getView().setLayoutParams(layoutParams);
                    return;
                }
            }
            int cr = com.baidu.live.aa.a.cr(this.gkF);
            if (bCw().gfT.indexOfChild(this.fWj.Da().getView()) != -1 && this.fWj.Da().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fWj.Da().getView().getLayoutParams();
                layoutParams2.height = cr;
                this.fWj.Da().getView().setLayoutParams(layoutParams2);
            }
            this.fWj.Da().CZ();
        }
    }

    private void li(boolean z) {
        if (this.glB == null) {
            this.glB = new com.baidu.tieba.ala.liveroom.challenge.e(bCw());
        }
        this.glB.a(this.fYS, this.fYT);
        this.glB.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(am amVar, aq aqVar, aq aqVar2) {
                if (AlaMasterLiveRoomOpearator.this.fWa != null) {
                    AlaMasterLiveRoomOpearator.this.fWa.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.fXB = true;
                AlaMasterLiveRoomOpearator.this.bCw().gfT.guc = false;
                if (AlaMasterLiveRoomOpearator.this.glj != null) {
                    AlaMasterLiveRoomOpearator.this.glj.cQ(4);
                    AlaMasterLiveRoomOpearator.this.glj.cc(true);
                }
                AlaMasterLiveRoomOpearator.this.bGu();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void vM() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.glL);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bCu() {
                AlaMasterLiveRoomOpearator.this.fXB = false;
                AlaMasterLiveRoomOpearator.this.bCw().gfT.guc = false;
                if (AlaMasterLiveRoomOpearator.this.glj != null) {
                    AlaMasterLiveRoomOpearator.this.glj.cQ(0);
                    AlaMasterLiveRoomOpearator.this.glj.cc(false);
                }
                AlaMasterLiveRoomOpearator.this.bGv();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bCv() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.glL);
            }
        });
        this.glB.G(this.gkn, z);
        this.glB.h(this.gkn, z, (this.fYT == null || this.fYT.ggA == null || this.fYT.ggA.mChallengeData == null) ? false : true);
    }

    public boolean bGt() {
        return this.glB != null && this.glB.bCA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGu() {
        if (this.gkM != null) {
            this.gkM.setVisible(8);
            this.gkM.setCanVisible(false);
        }
        if (this.fVl != null) {
            this.fVl.kw(true);
        }
        if (this.gkQ != null) {
            this.gkQ.setCanVisible(false);
            this.gkQ.setVisibility(4);
        }
        if (this.gkL != null) {
            this.gkL.lB(false);
        }
        if (this.fWj != null) {
            this.fWj.Da().setNeedTopAlphaShade(false);
        }
        bCe();
        bCf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGv() {
        if (this.gkM != null) {
            this.gkM.setCanVisible(true);
        }
        if (this.fVl != null) {
            this.fVl.kw(false);
        }
        if (this.gkQ != null) {
            this.gkQ.setCanVisible(true);
        }
        if (this.gkL != null) {
            this.gkL.lB(true);
        }
        if (this.fWj != null) {
            this.fWj.Da().setNeedTopAlphaShade(false);
        }
        bCe();
        bCf();
    }

    private void bGw() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.gkQ == null) {
            this.gkQ = new AlaLiveStreamStatusView(bCw().pageContext.getPageActivity());
        }
        this.gkQ.setId(a.g.ala_live_room_stream_view);
        this.gkQ.setVisibility(4);
        this.gkQ.setLayoutParams(layoutParams);
        if (this.gkQ.getParent() == null) {
            bCw().gfT.addView(this.gkQ, layoutParams);
        }
    }

    public void bGx() {
        if (this.gkG != null && this.gkG.getVisibility() != 8 && bCw().ggs.getPreview() != null) {
            bCw().ggs.stopRecord();
        }
    }

    public void bGy() {
        if (bCw().ggs.getPreview() != null) {
            bCw().ggs.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.glz != null) {
                this.glz.kT(false);
            }
            this.glz = new com.baidu.tieba.ala.liveroom.g.b(bCw().ggu, bCw(), bCw().ggs);
            this.glz.a(bCw().ggs.getVideoConfig(), false);
        }
        if (this.gkN != null) {
            this.gkN.bJz();
        }
        this.mHandler.post(this.glL);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gkF = z;
        if (z) {
            if (this.gly) {
                this.gly = false;
                if (this.fWj != null && this.fWj.Da() != null) {
                    this.fWj.Da().getView().setBottom(0);
                }
                if (this.fWj != null && this.fWj.Db() != null) {
                    this.fWj.Db().getView().setBottom(0);
                }
            }
            if (this.fWj != null && this.fWj.Da() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fWj.Da().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.fWj.Da().getView().setLayoutParams(layoutParams);
            }
            if (this.fWj != null && this.fWj.Db() != null && this.fWj.Db().getView() != null && this.fWj.Db().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fWj.Db().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.fWj.Db().getView().setLayoutParams(layoutParams2);
                this.fWj.Db().getView().setVisibility(0);
                this.fWj.Db().ES();
            }
            rL(8);
            rK(8);
        } else {
            if (this.fWj != null && this.fWj.Da() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fWj.Da().getView().getLayoutParams();
                layoutParams3.bottomMargin = bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fWj.Da().getView().setLayoutParams(layoutParams3);
            }
            if (this.fWj != null && this.fWj.Db() != null) {
                this.fWj.Db().hide();
            }
            rL(0);
            rK(0);
        }
        if (this.gkG != null) {
            this.gkG.I(false, z);
        }
        if (this.fWk != null) {
            this.fWk.Dk();
        }
        if (this.glj != null) {
            this.glj.onKeyboardVisibilityChanged(z);
        }
        bCf();
        this.mHandler.post(this.glL);
    }

    private void rK(int i) {
        if (this.fVg != null) {
            this.fVg.ry(i);
        }
        if (this.gkS != null) {
            this.gkS.setVisibility(i);
        }
        if (this.fVW != null) {
            this.fVW.getView().setVisibility(i);
        }
        if (this.gkK != null) {
            this.gkK.setVisible(i);
        }
        if (this.gkJ != null) {
            this.gkJ.setVisibility(i);
        }
        if (this.fVl != null) {
            this.fVl.setVisible(i);
        }
        if (this.fWH != null) {
            this.fWH.setCanVisible(i == 0);
        }
        if (this.fWu != null) {
            this.fWu.setVisible(i);
        }
        if (this.fWE != null) {
            this.fWE.setCanVisible(i == 0);
        }
        if (this.glC != null) {
            this.glC.setCanVisible(i == 0);
            this.glC.refreshUI();
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bCw().ggx.errCode = 1;
            bGS();
        } else if (i == -5) {
            bGT();
        } else if (i == -2) {
            CX(bCw().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bCw().ggs.stopRecord();
        } else if (i == -3 && this.gkG != null) {
            this.gkG.kU(false);
        }
        if (i == -4) {
            if (this.gkG == null || this.gkG.getView().getParent() == null) {
                bCw().f((short) 1);
                return;
            }
            this.gkG.bEe();
            this.glb.setVisibility(0);
            if (this.gkL != null) {
                this.gkL.lC(true);
            }
            bCw().gfT.setBackgroundColor(bCw().pageContext.getResources().getColor(17170445));
            bHf();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bBQ();
        if (i == 12001) {
            if (i2 == -1) {
                CY(L(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                M(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aYB();
        }
    }

    public void onResume() {
        if (this.gkG != null) {
            this.gkG.onResume();
        }
        if (this.gll && this.glk != null) {
            this.gll = false;
            c(this.glk);
        }
        if (this.fWw != null) {
            this.fWw.onResume();
        }
    }

    public void g(short s) {
        if (this.fWi != null) {
            this.fWi.yW();
        }
        if (this.fWj != null) {
            this.fWj.a(null);
            this.fWj.Cz();
        }
        if (this.fWk != null) {
            this.fWk.Cz();
        }
        if (this.glB != null) {
            this.glB.bCz();
        }
    }

    public boolean bGz() {
        q FU = bCw().gfS.FU();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fYL.ggz.k(FU);
            if (FU != null && FU.mLiveInfo.live_status != 1) {
                bHd();
                bCw().pageContext.getPageActivity().finish();
                if (bCw().gfS != null && bCw().gfS.FU() != null) {
                    a(FU, 1, bCw().gfS.bIB() != 1 ? bCw().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.fWj != null) {
                this.fWj.Da().a(String.valueOf(FU.mLiveInfo.group_id), String.valueOf(FU.mLiveInfo.live_id), true, String.valueOf(FU.axp.userId));
            }
            if (this.fWk != null) {
                this.fWk.a(FU);
            }
            if (this.fVW != null) {
                this.fVW.a(bCw().gfS.FU());
            }
            if (this.fVg != null) {
                this.fVg.v(FU);
            }
            if (FU != null) {
                if (this.gkI != null) {
                    this.gkI.r(FU);
                }
                if (this.glB != null) {
                    this.glB.a(FU);
                }
                if (this.fWm != null && FU.mLiveInfo != null) {
                    this.fWm.a(FU.mLiveInfo, FU.axp);
                }
                if (this.fWH != null) {
                    this.fWT = this.fWH.o(FU);
                }
                if (this.fVl != null) {
                    this.fVl.kx(this.fWT);
                    this.fVl.j(FU);
                    this.fVl.updateView();
                }
                if (this.fWE != null) {
                    this.fWE.a(FU);
                }
                if (FU.mLiveInfo.live_status != 1) {
                    bHd();
                    bCw().pageContext.getPageActivity().finish();
                    if (bCw().gfS != null && bCw().gfS.FU() != null) {
                        a(FU, 1, bCw().gfS.bIB() != 1 ? bCw().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.gkO != null) {
                    this.gkO.i(FU);
                }
            }
        }
        return false;
    }

    public void bGA() {
        bGq();
    }

    public void bGB() {
        if (this.glz != null) {
            this.glz.bDY();
        }
    }

    public void bGC() {
        if (this.gkG != null && this.gkG.getVisibility() != 8) {
            if (bCw().bEk() == 2) {
                bHf();
            } else {
                bHe();
            }
        }
        if (this.gkG != null && this.gkG.getVisibility() != 8) {
            if (bCw().bEk() == 1) {
                this.gkG.onResume();
            }
            this.gkG.onRefresh();
        }
        if (this.gkO != null) {
            this.gkO.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.fWO && this.glf != null) {
            if (this.fWj != null) {
                this.fWj.Da().getView().setVisibility(0);
            }
            if (this.fWj != null) {
                this.fWj.Db().show();
                this.fWj.Db().setEditText(" @" + this.glf.getNameShow() + " ");
            }
            rL(8);
            this.fWO = false;
        }
        if (this.glD != null) {
            this.glD.resume();
        }
        if (this.glE != null) {
            this.glE.resume();
        }
    }

    public void onPause() {
        if (this.gkO != null) {
            this.gkO.onPause();
        }
        if (this.glD != null) {
            this.glD.pause();
        }
        if (this.fWw != null) {
            this.fWw.onPause();
        }
        if (this.glE != null) {
            this.glE.pause();
        }
    }

    private void bGD() {
        this.gkR = (RelativeLayout) bCw().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.gkT = (RelativeLayout) bCw().rootView.findViewById(a.g.under_live_view_panel);
        this.gkU = (RelativeLayout) bCw().rootView.findViewById(a.g.over_live_view_panel);
        this.gkV = (FrameLayout) bCw().rootView.findViewById(a.g.goods_parent);
        this.fYL.gfT.setOnLiveViewScrollListener(this.gmb);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gkT.setVisibility(8);
            this.gkU.setVisibility(8);
            bCw().gfT.removeAllViews();
            return;
        }
        this.gkS = (RelativeLayout) bCw().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkS.getLayoutParams();
        layoutParams.topMargin = this.fYL.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fYL.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.gkS.setLayoutParams(layoutParams);
        if (this.fVj == null) {
            this.fVj = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.fYL.pageContext.getPageActivity(), false);
        }
        this.fVj.a(this.fVL);
        this.fVj.a(this.gkS, a.g.ala_live_room_host_header_stub, 1L);
        this.fVj.setVisible(0);
        this.glb = (ImageView) bCw().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.gle = (TextView) bCw().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn_num);
        this.glb.setOnClickListener(this.glS);
        this.gld = (ImageView) bCw().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.gld.setOnClickListener(this.glS);
        if (com.baidu.live.v.a.Hm().bdV != null && com.baidu.live.v.a.Hm().bdV.aCR != null && com.baidu.live.v.a.Hm().bdV.aCR.wQ() && az.b(com.baidu.live.v.a.Hm().bdV)) {
            this.gld.setVisibility(0);
        } else {
            this.gld.setVisibility(8);
        }
        if (az.c(com.baidu.live.v.a.Hm().bdV)) {
            this.glb.setVisibility(0);
            if (az.c(com.baidu.live.v.a.Hm().bdV)) {
                this.glb.setAlpha(0.2f);
            }
        } else if (bCw().ggs.hasBeauty() < 0) {
            this.glb.setVisibility(8);
        } else {
            if (az.c(com.baidu.live.v.a.Hm().bdV)) {
                this.glb.setAlpha(0.2f);
            }
            com.baidu.live.c.vf().getInt("live_beauty_level", 3);
        }
        this.gla = (ImageView) bCw().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.gla.setOnClickListener(this.glS);
        this.gkY = (ImageView) bCw().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.gkY.setOnClickListener(this.glS);
        this.fYS = (ImageView) bCw().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.fYS.setOnClickListener(this.glS);
        this.gkZ = (ImageView) bCw().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.gkZ.setOnClickListener(this.glS);
        this.glc = (ImageView) bCw().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.glc.setOnClickListener(this.glS);
        bGG();
        if (az.b(com.baidu.live.v.a.Hm().bdV)) {
            this.glz = new com.baidu.tieba.ala.liveroom.g.b(bCw().ggu, bCw(), bCw().ggs);
        }
        this.fWi = new o();
        bGE();
        bGF();
        if (com.baidu.live.c.vf().getInt("beauty_new_bubble", 1) == 1) {
            this.gle.setVisibility(0);
        }
    }

    private void bGE() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bCw().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fWj = (k) runTask.getData();
            this.fWj.setFromMaster(true);
            this.fWj.Da().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bCw().pageContext.getPageActivity()) * 0.75f), com.baidu.live.aa.a.cr(false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.aa.a.cs(true);
            bCw().gfT.addView(this.fWj.Da().getView(), layoutParams);
            this.fWj.Db().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bCw().gfT.addView(this.fWj.Db().getView(), layoutParams2);
            this.fWj.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                @Override // com.baidu.live.im.k.a
                public boolean Dd() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void De() {
                }

                @Override // com.baidu.live.im.k.a
                public void fw(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Df() {
                }

                @Override // com.baidu.live.im.k.a
                public void Dg() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Dh() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int Di() {
                    return 0;
                }
            });
        }
    }

    private void bGF() {
        View Dj;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, l.class, bCw().pageContext);
        if (runTask != null) {
            this.fWk = (l) runTask.getData();
        }
        if (this.fWk != null && (Dj = this.fWk.Dj()) != null && this.fYL.gfT.indexOfChild(Dj) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.fYL.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bCw().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bCw().gfT.addView(Dj, layoutParams);
        }
    }

    private void bGG() {
        CustomResponsedMessage runTask;
        if (this.glh == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bCw().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.glh = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bGH() {
        View yy;
        v.b(bCw().pageContext, true);
        if (this.fWl == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aGc = true;
            fVar.context = bCw().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, w.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fWl = (w) runTask.getData();
                if (this.fWl != null && (yy = this.fWl.yy()) != null && bCw().gfT.indexOfChild(yy) < 0) {
                    if (yy.getParent() instanceof ViewGroup) {
                        ((ViewGroup) yy.getParent()).removeView(yy);
                    }
                    bCw().gfT.addView(yy, bCw().gfT.getLayoutParams());
                }
            }
        }
    }

    protected void bBy() {
        View yQ;
        if (this.fWm == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aGc = true;
            aVar.context = bCw().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, u.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fWm = (u) runTask.getData();
            }
        }
        if (this.fWm != null && (yQ = this.fWm.yQ()) != null) {
            if (bCw().gfT.indexOfChild(yQ) < 0) {
                if (yQ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) yQ.getParent()).removeView(yQ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bCw().gfT.addView(yQ, layoutParams);
            }
            yQ.bringToFront();
        }
    }

    protected void bBx() {
        View yX;
        if (this.fWw == null) {
            ab abVar = new ab();
            abVar.aGc = true;
            abVar.pageContext = bCw().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, y.class, abVar);
            if (runTask != null && runTask.getData() != null) {
                this.fWw = (y) runTask.getData();
            }
        }
        if (this.fWw != null && (yX = this.fWw.yX()) != null && bCw().gfT.indexOfChild(yX) < 0) {
            if (yX.getParent() instanceof ViewGroup) {
                ((ViewGroup) yX.getParent()).removeView(yX);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bCw().gfT.addView(yX, layoutParams);
        }
    }

    private void bGI() {
        bGM();
        bAz();
        bGL();
        bCw().gfT.setVisibility(0);
        rL(0);
    }

    private void bGJ() {
        if (this.gkK == null) {
            this.gkK = new com.baidu.tieba.ala.liveroom.s.a(bCw().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gkK.a(bCw().bEk(), j, TbadkCoreApplication.getCurrentAccountName(), true, bCw().gfS.FU().axp.portrait, this.otherParams, "", -1L);
        this.gkK.aq(bCw().gfT);
    }

    private void bGK() {
        if (this.glj == null) {
            bCw().gfT.guc = false;
            com.baidu.live.w.a ez = ez(bCw().pageContext.getPageActivity());
            if (ez != null) {
                this.glj = ez;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bCw().pageContext.getPageActivity());
                if (runTask != null) {
                    this.glj = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.glj != null) {
                this.glj.o(this.gkT);
                this.glj.p(this.gkU);
                this.glj.cP((bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bCw().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.fWa != null) {
                    this.glj.cO(this.fWa.bKB());
                }
                this.glj.q(bCw().gfT);
                this.glj.a(this.fUt);
                this.glj.setLiveShowInfo(bCw().gfS.FU());
                this.glj.a(this.fVl);
                this.glj.Hx();
                this.glj.a(new a.InterfaceC0192a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // com.baidu.live.w.a.InterfaceC0192a
                    public void Hy() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0192a
                    public void Hz() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0192a
                    public void G(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bCw().ggs != null) {
                            AlaMasterLiveRoomOpearator.this.bCw().ggs.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0192a
                    public int HA() {
                        return AlaMasterLiveRoomOpearator.this.gkS.getBottom();
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0192a
                    public int HB() {
                        return AlaMasterLiveRoomOpearator.this.fYL.gfT.getHeight() - (AlaMasterLiveRoomOpearator.this.fWj.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.fWj.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0192a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.fWj.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0192a
                    public int HC() {
                        return AlaMasterLiveRoomOpearator.this.fWj.Dc();
                    }
                });
            }
        }
    }

    private com.baidu.live.w.a ez(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aq(context);
        }
        return null;
    }

    private void bGL() {
        if (this.gkM == null) {
            this.gkM = new b(bCw().pageContext, bCw().gfT);
        }
    }

    private void bGM() {
        if (this.fVg == null) {
            this.fVg = new com.baidu.tieba.ala.liveroom.m.a(bCw().pageContext, true, this.glW);
            this.fVg.c(this.gkR, (q) null);
            this.fVg.a(this.fVL);
        }
        if (this.gkH == null) {
            this.gkH = new com.baidu.tieba.ala.liveroom.m.a(bCw().pageContext, true, null);
            this.gkH.a(this.gkS, null, a.g.ala_live_room_host_header_stub);
            this.gkH.bFB();
        }
    }

    protected void bBh() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bIr = bCw().gfS.bIr();
        boolean z2 = com.baidu.live.v.a.Hm().aZp.aAK;
        if (bIr == null || bIr.axT) {
            z = z2;
        }
        if (z && this.fVW == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bCw().pageContext)) != null) {
            this.fVW = (com.baidu.live.h.a) runTask.getData();
            if (this.fVW != null) {
                this.fVW.setIsHost(true);
                this.fVW.cz(1);
                View view = this.fVW.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bCw().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bCw().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.gkS.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(q qVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.fVl == null) {
            this.fVl = new com.baidu.tieba.ala.liveroom.activeview.b(bCw().pageContext);
        }
        this.fVl.setOtherParams(this.otherParams);
        this.fVl.b(qVar, false);
        this.fVl.setHost(true);
        this.fVl.a(1, this.bbS);
        this.fVl.a(2, this.bbS);
        this.fVl.kx(this.fWT);
        this.fVl.setVisible(this.gkF ? 8 : 0);
        this.fVl.a(this.fUt);
        if (this.fUt != null) {
            if (this.fVl != null) {
                alaActiveRootView2 = this.fVl.rj(1);
                alaActiveRootView = this.fVl.rj(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.fUt.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.fUt.a(alaActiveRootView);
            }
        }
    }

    private void w(q qVar) {
        CustomResponsedMessage runTask;
        if (this.fWH == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bCw().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.r.a)) {
            this.fWH = (com.baidu.live.r.a) runTask.getData();
            if (this.fWH != null) {
                this.fWH.n(this.bbS);
            }
        }
        if (this.fWH != null) {
            this.fWT = this.fWH.o(qVar);
            this.fWH.setCanVisible(!this.gkF);
        }
    }

    protected void bGN() {
        CustomResponsedMessage runTask;
        if (bCw() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bCw().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fWE = (com.baidu.live.i.a) runTask.getData();
            this.fWE.a(bCw().gfT, bGO());
            if (bCw().gfS != null) {
                this.fWE.a(bCw().gfS.FU());
            }
            this.fWE.setCanVisible(true);
            this.fWE.bC(false);
            this.fWE.a(bCw().gfS.bwd());
        }
    }

    private void bBq() {
        this.glE = new com.baidu.tieba.ala.liveroom.o.c(bCw().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bGO() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bCw().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.fWu != null && this.fWu.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.gkK != null && this.gkK.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void bAz() {
        if (this.gkJ == null) {
            this.gkJ = new com.baidu.tieba.ala.liveroom.b.a(bCw().pageContext, true);
        }
    }

    private void bGP() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bCw().pageContext.getPageActivity();
            if (this.fXQ == null) {
                this.fXQ = new ImageView(pageActivity);
                this.fXQ.setId(a.g.master_close_btn);
                this.fXQ.setTag("master_close_btn");
                this.fXQ.setImageResource(a.f.sdk_icon_bar_live_close_n);
                this.fXQ.setBackgroundResource(a.f.sdk_round_btn_close_bg);
                this.fXQ.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            }
            if (this.fXQ.getParent() != null) {
                ((ViewGroup) this.fXQ.getParent()).removeView(this.fXQ);
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
            bCw().ggu.addView(this.fXQ, layoutParams);
            this.fXQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bHb();
                }
            });
            this.fXQ.setVisibility(8);
        }
    }

    private void bBC() {
        if (this.fWu == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bCw().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fWu = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.fWu.setHost(true);
        this.fWu.setOtherParams(this.otherParams);
        if (bCw().gfS.FU() != null && bCw().gfS.FU().axp != null && bCw().gfS.FU().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fWu.a(bCw().gfT, layoutParams, bCw().gfS.FU());
        }
    }

    private void bGQ() {
        CustomResponsedMessage runTask;
        if (this.glC == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bCw().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.glC = (com.baidu.live.b.a) runTask.getData();
            if (this.glC != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bCw().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.glC.a(bCw().gfT, layoutParams);
            }
        }
        if (this.glC != null) {
            this.glC.a(bCw().gfS.FU());
        }
    }

    private void bGR() {
        CustomResponsedMessage runTask;
        if (this.glD == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bCw().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.glD = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.glB != null) {
            this.glB.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bCw().pageContext.registerListener(this.fXe);
        bCw().pageContext.registerListener(this.glM);
        bCw().pageContext.registerListener(this.fXg);
        bCw().pageContext.registerListener(this.fXh);
        bCw().pageContext.registerListener(this.glT);
        bCw().pageContext.registerListener(this.ble);
        bCw().pageContext.registerListener(this.fTl);
        bCw().pageContext.registerListener(this.glU);
        bCw().pageContext.registerListener(this.fXf);
        bCw().pageContext.registerListener(this.fVG);
        bCw().pageContext.registerListener(this.gmd);
        bCw().pageContext.registerListener(this.fXm);
        bCw().pageContext.registerListener(this.glQ);
        bCw().pageContext.registerListener(this.glR);
        bCw().pageContext.registerListener(this.glN);
        bCw().pageContext.registerListener(this.aYV);
        bCw().pageContext.registerListener(this.aYW);
        bCw().pageContext.registerListener(this.glO);
        bCw().pageContext.registerListener(this.fXo);
        bCw().pageContext.registerListener(this.fXn);
        bCw().pageContext.registerListener(this.fXp);
        bCw().pageContext.registerListener(this.glP);
        bCw().pageContext.registerListener(this.glO);
        bCw().pageContext.registerListener(this.aWc);
        bCw().pageContext.registerListener(this.aTJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lj(boolean z) {
        if (az.c(com.baidu.live.v.a.Hm().bdV)) {
            bCw().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bCw().ggw.vv() == null || ListUtils.isEmpty(bCw().ggw.vv().auC)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bCw().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.glF) {
                this.glG = BdUniqueId.gen();
                bCw().ggw.a(this.glG);
                this.glF = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bCw().pageContext.getPageActivity(), bCw().rootView);
            rL(8);
            if (bCw().ggs.hasAdvancedBeauty() && this.glz != null) {
                if (!this.glH || this.gkG.getVisibility() == 0) {
                    this.glz.a(bCw().ggs.getVideoConfig());
                }
                this.glz.a(bCw().ggs.getVideoConfig(), this.glA);
                if (!this.glA) {
                    this.glA = true;
                }
            }
            if (z && this.fWj != null) {
                this.fWj.Da().getView().setVisibility(4);
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
    public void bGS() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bCw().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bCw().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bCw().f((short) 1);
            }
        });
        bdAlertDialog.create(bCw().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGT() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bCw().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bCw().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bCw().f((short) 1);
            }
        });
        bdAlertDialog.create(bCw().pageContext).show();
    }

    private void CX(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bCw().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bCw().f((short) 1);
            }
        });
        bdAlertDialog.create(bCw().pageContext).show();
    }

    public void bGU() {
        bBh();
        com.baidu.live.data.k bwd = bCw().gfS.bwd();
        int i = 5;
        if (bwd != null) {
            i = (int) bwd.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() != null && AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bCw().gfS.f(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bwd != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fYL.ggz.b(bwd);
                return;
            }
            if (this.fVf == null) {
                this.fVf = new com.baidu.tieba.ala.liveroom.audiencelist.c(bCw().pageContext, this.glW, true);
            }
            if (this.glx) {
                this.glx = false;
                this.fVf.a(String.valueOf(bCw().gfS.FU().mLiveInfo.group_id), String.valueOf(bCw().gfS.FU().mLiveInfo.live_id), String.valueOf(bCw().gfS.FU().axp.userId), bCw().gfS.FU());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.fVW != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.fVf.c(this.gkS, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.fVf.e(bwd);
            this.fVj.setVisible(0);
            this.fVj.dp(bwd.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bGV() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYB() {
        if (bCw().gfS != null) {
            if (this.fVX == null) {
                this.fVX = new c(bCw().pageContext);
            }
            this.fVX.c(bCw().gfS.FU(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bCw().gfS != null && bCw().gfS.FU() != null && bCw().gfS.FU().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bCw().gfS.FU().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bCw().gfS.FU().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bCw().gfS.FU().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bCw().gfS != null && bCw().gfS.FU() != null && bCw().gfS.FU().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bCw().gfS.FU().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bCw().gfS.FU().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bCw().gfS.FU().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bGW() {
        return this.gkE;
    }

    private void lk(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(gkD, z);
        this.gkE = z;
    }

    private void bGX() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bCw().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.n.a(AlaMasterLiveRoomOpearator.this.bCw().pageContext).bHX();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bCw().pageContext).show();
    }

    private void bGY() {
        if (this.gkn && bCw().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bCw().ggy.Ii();
        }
        bCw().ggx.prepareTime = System.currentTimeMillis() - bCw().ggx.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bCw().gfS != null && bCw().gfS.FU() != null && bCw().gfS.FU().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bCw().gfS.FU().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bCw().gfS.FU().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bCw().ggx.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gkG != null && this.gkG.getView().getParent() != null) {
            this.gkG.setVisibility(8);
            bCw().ggu.removeView(this.gkG.getView());
            this.gkG.release();
        }
        if (this.glz != null) {
            this.glz.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bCw().gfT.indexOfChild(this.gkP) < 0) {
            bCw().gfT.addView(this.gkP, layoutParams);
        }
        this.gkP.sb(1000);
    }

    private void bBQ() {
        if (bCw().bEk() == 1) {
            bCw().ggs.startRecord();
        }
    }

    private void CY(String str) {
        CZ(str);
    }

    private void CZ(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bCw().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.gkG != null) {
            this.gkG.CM(fromJson.getSmallurl());
        }
    }

    private boolean bGZ() {
        return com.baidu.live.c.vf().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHa() {
        com.baidu.live.c.vf().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.fYL.ggs.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHb() {
        int i = a.i.live_close_confirm;
        if (this.glB != null && this.glB.bCB()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.glB != null && this.glB.bCA()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bCw().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bCw().gfS.FU() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU(), 0, AlaMasterLiveRoomOpearator.this.bCw().gfS.bIB() != 1 ? AlaMasterLiveRoomOpearator.this.bCw().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bCw().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(q qVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (qVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = qVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = qVar.axp;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bCw().gfS.dN(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.glv) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bCw().ggx;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bCw().ggs.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.glr;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.gls;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.gln;
            if (this.glo != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.glp - this.glq) / this.glo) * 100.0f;
            }
            Intent intent = new Intent(bCw().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bCw().gfS != null && bCw().gfS.FU() != null && bCw().gfS.FU().axp != null) {
                String str3 = bCw().gfS.FU().axp.nickName;
                String str4 = bCw().gfS.FU().axp.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            q FU = bCw().gfS.FU();
            if (FU != null && FU.axp != null && !TextUtils.isEmpty(FU.axp.portrait)) {
                intent.putExtra("host_portrait", FU.axp.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.glt = intent;
                this.glu = s;
                bCw().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bHc() {
        if (this.glt != null) {
            a(this.glt, this.glu);
            this.glt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.glv = true;
        if (this.glB != null) {
            this.glB.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.fTa);
            bCw().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bCw().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHd() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fYL.ggz != null && this.fYL.ggz.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.glB != null && this.glB.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bCw().ggv.bHI()) {
                bHb();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.gkQ != null) {
                this.gkQ.setVisibility(4);
                return;
            }
            return;
        }
        if (this.gkQ != null) {
            this.gkQ.a(i, z, i2, z2);
        }
        if (this.fYL != null && this.fYL.gfS != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cKY != i3) {
                this.cKY = i3;
                if (this.gkN == null) {
                    this.gkN = new com.baidu.tieba.ala.liveroom.tippop.a(this.fYL.pageContext, null);
                }
                switch (this.cKY) {
                    case 0:
                        this.gkN.a(this.fYL.ggu, this.fYL.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.gkN.a(this.fYL.ggu, this.fYL.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.gkN.a(this.fYL.ggu, this.fYL.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.fYL.gfS.j(this.fYL.gfS.FU().mLiveInfo.live_id, i3);
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
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bHd();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0638, code lost:
        CE(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(com.baidu.live.im.data.a aVar) {
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
            if (this.gkL != null) {
                this.gkL.A(aVar);
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
                            if (this.glB != null) {
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
            if (this.glB != null) {
                this.glB.eq(str4);
            }
            if (!"close_live".equals(str4)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bHd();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bCw().gfS.FU(), 1, str3);
                    }
                });
            } else if ("live_admin".equals(str4)) {
                if (bCw().gfS.FU() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bCw().gfS.FU().axI.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bCw().gfS.FU().axI.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bCw().gfS.FU().axI.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str4)) {
                if (bCw().gfS.FU() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bCw().gfS.FU() != null && bCw().gfS.FU().axp != null && bCw().gfS.FU().axp.userId == optLong2) {
                        bCw().gfS.FU().axp.isUegBlock = 1;
                        bAM();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str4)) {
                if (bCw().gfS.FU() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bCw().gfS.FU() != null && bCw().gfS.FU().axp != null && bCw().gfS.FU().axp.userId == optLong3) {
                        bCw().gfS.FU().axp.isUegBlock = 0;
                        bAM();
                    }
                }
            } else if ("task".equals(str4)) {
                if (this.glh != null) {
                    this.glh.L(jSONObject2);
                }
            } else if ("enter_live".equals(str4)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.gkM.aD(optString4, optInt2);
                    }
                    if (this.fVj.getCount() > 20) {
                        this.fVj.dp(this.fVj.getCount() + 1);
                    } else if (this.fVf != null) {
                        com.baidu.live.data.a Ed = aVar.Ed();
                        j jVar = new j();
                        jVar.axq = new AlaLocationData();
                        jVar.axr = new AlaRelationData();
                        jVar.axp = new AlaLiveUserInfoData();
                        jVar.axp.userId = JavaTypesHelper.toLong(Ed.userId, 0L);
                        jVar.axp.userName = Ed.userName;
                        jVar.axp.portrait = Ed.portrait;
                        if (this.fVf.c(jVar)) {
                            this.fVj.dp(this.fVj.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str4)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && bCw().gfS.FU() != null && bCw().gfS.FU().mLiveInfo != null) {
                    String str7 = bCw().gfS.FU().mLiveInfo.feed_id;
                    long j4 = bCw().gfS.FU().mLiveInfo.live_id;
                    long j5 = bCw().gfS.FU().axp.userId;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!m.i(j4, optLong4)) {
                        if (this.gkO != null) {
                            this.gkO.d(str7, j4, j5);
                        }
                        m.j(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str4)) {
                if (jSONObject2 != null && bCw() != null && bCw().gfS != null && bCw().gfS.FU() != null && bCw().gfS.FU().axI != null && bCw().gfS.FU().axI.userId == jSONObject2.optLong("user_id")) {
                    bCw().gfS.bIq();
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
                    com.baidu.live.data.a Ed2 = aVar.Ed();
                    if (Ed2 != null && v.eX(str9)) {
                        v.d(str9, 1L, "", "", Ed2.userId, Ed2.portrait, Ed2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str4)) {
                if (jSONObject2 != null) {
                    an anVar = new an();
                    anVar.parseJson(jSONObject2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, anVar));
                }
            } else if (TextUtils.equals(str4, "challenge_mvp_punish")) {
                if (jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            } else if ("challenge_direct_new".equals(str4)) {
                if (jSONObject2 != null) {
                    String optString5 = jSONObject2.optString("challenge_im_type");
                    if (TextUtils.equals(optString5, "start")) {
                        Da(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bCw().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str4)) {
                BdUtilHelper.showToast(bCw().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a Ed3 = aVar.Ed();
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
                if (bCw().gfS != null && bCw().gfS.FU() != null && bCw().gfS.FU().mLiveInfo != null) {
                    j6 = bCw().gfS.FU().mLiveInfo.live_id;
                    j7 = bCw().gfS.FU().mLiveInfo.group_id;
                    j8 = bCw().gfS.FU().axp.userId;
                    str10 = bCw().gfS.FU().mLiveInfo.appId;
                    if (bCw().gfS.FU().mLiveSdkInfo.mCastIds != null) {
                        String str11 = bCw().gfS.FU().mLiveSdkInfo.mCastIds.axB;
                        j = j8;
                        j2 = j7;
                        j3 = j6;
                        str5 = bCw().gfS.FU().mLiveSdkInfo.mCastIds.axC;
                        str6 = str11;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str6, str5, optString6, "");
                        if (this.isBackground || bCw().bEk() != 2) {
                            if (TextUtils.isEmpty(optString11) && !TextUtils.isEmpty(optString12)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    v.b(optString12, Ed3.userId, Ed3.portrait, Ed3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str10, optString11, "", "", aVar.getMsgId());
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString12);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.v.d.Ht().fK(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                v.b(optString6, Integer.parseInt(optString7), optString8, optString9, Ed3.userId, Ed3.portrait, Ed3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str10, optString10, str6, str5, aVar.getMsgId());
                            }
                        }
                        CE(optString6);
                        com.baidu.tieba.ala.liveroom.f.d dVar = new com.baidu.tieba.ala.liveroom.f.d();
                        dVar.gfx = optLong6;
                        dVar.liveId = j3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar));
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
                v.b(optString6, Integer.parseInt(optString7), optString8, optString9, Ed3.userId, Ed3.portrait, Ed3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str10, optString10, str6, str5, aVar.getMsgId());
                CE(optString6);
                com.baidu.tieba.ala.liveroom.f.d dVar2 = new com.baidu.tieba.ala.liveroom.f.d();
                dVar2.gfx = optLong6;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void CE(String str) {
        if (this.fVl != null) {
            this.fVl.CE(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rL(int i) {
        View findViewById = bCw().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.fVl != null) {
            this.fVl.bx(2, i);
        }
    }

    private void bHe() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bCw().ggs != null && AlaMasterLiveRoomOpearator.this.bCw().ggs.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bCw().ggs.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bCw().ggs.startRecord();
                }
            }
        });
    }

    private void bHf() {
        if (bCw().ggs != null && bCw().ggs.getPreview() != null) {
            bCw().ggs.getPreview().setVisibility(8);
            bCw().ggs.stopRecord();
        }
    }

    public void bHg() {
        this.ggp = bCw().gfS.bIC();
        if (this.gkG != null) {
            this.gkG.kV(this.ggp);
        }
    }

    public void bEi() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bHh();
        } else if (this.gkG != null) {
            this.gkG.bEi();
        }
    }

    public void kW(boolean z) {
        if (this.gkG != null) {
            this.gkG.kW(z);
        }
    }

    public void onDestroy() {
        if (this.glm != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.glm);
        }
        this.glm = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.glg.removeCallbacksAndMessages(null);
        if (this.glz != null) {
            this.glz.kT(true);
        }
        this.glz = null;
        if (this.gkG != null) {
            this.gkG.destroy();
            bCw().ggu.removeView(this.gkG.getView());
            this.gkG.release();
            this.gkG = null;
        }
        if (this.glB != null) {
            this.glB.onDestroy();
        }
        if (this.fVX != null) {
            this.fVX.onDestroy();
        }
        if (this.fVg != null) {
            this.fVg.onDestroy();
            this.fVg = null;
        }
        if (this.gkH != null) {
            this.gkH.onDestroy();
        }
        if (this.fWw != null) {
            this.fWw.onDestroy();
            this.fWw = null;
        }
        if (this.gkP != null) {
            this.gkP.stopCountDown();
        }
        if (this.gkK != null) {
            this.gkK.onDestroy();
        }
        if (this.gkM != null) {
            this.gkM.onDestroy();
        }
        if (this.glh != null) {
            this.glh.onDestroy();
            this.glh = null;
        }
        if (this.fWl != null) {
            this.fWl.onDestroy();
            this.fWl = null;
        }
        v.yT();
        com.baidu.live.entereffect.a.xa().release();
        if (this.fWm != null) {
            this.fWm.onDestroy();
            this.fWm = null;
        }
        if (this.gkN != null) {
            this.gkN.onDestroy();
        }
        if (this.gkL != null) {
            this.gkL.bKD();
            this.gkL.release();
        }
        if (this.fVj != null) {
            this.fVj = null;
        }
        if (this.fVl != null) {
            this.fVl.release();
        }
        if (this.gkI != null) {
            this.gkI.onDestroy();
        }
        if (this.gkL != null) {
            this.gkL.onDestroy();
        }
        if (this.fWk != null) {
            this.fWk.release();
        }
        if (this.gkO != null) {
            this.gkO.release();
        }
        if (this.fWu != null) {
            this.fWu.onDestroy();
        }
        if (this.glj != null) {
            this.glj.onDestroy();
        }
        if (this.fWH != null) {
            this.fWH.release();
        }
        if (this.glC != null) {
            this.glC.onDestory();
        }
        if (this.glD != null) {
            this.glD.release();
        }
        if (this.fWE != null) {
            this.fWE.onDestroy();
        }
        if (this.glE != null) {
            this.glE.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fVG);
        MessageManager.getInstance().unRegisterListener(this.gmd);
        MessageManager.getInstance().unRegisterListener(this.fXm);
        MessageManager.getInstance().unRegisterListener(this.glQ);
        MessageManager.getInstance().unRegisterListener(this.glR);
        MessageManager.getInstance().unRegisterListener(this.glN);
        MessageManager.getInstance().unRegisterListener(this.aYV);
        MessageManager.getInstance().unRegisterListener(this.aYW);
        MessageManager.getInstance().unRegisterListener(this.glO);
        MessageManager.getInstance().unRegisterListener(this.fXo);
        MessageManager.getInstance().unRegisterListener(this.fXn);
        MessageManager.getInstance().unRegisterListener(this.fXp);
        MessageManager.getInstance().unRegisterListener(this.glP);
        MessageManager.getInstance().unRegisterListener(this.glO);
        MessageManager.getInstance().unRegisterListener(this.aWc);
        MessageManager.getInstance().unRegisterListener(this.aTJ);
        m.Jm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ar arVar, String str, long j, long j2) {
        if (arVar != null && arVar.eventType == 1001 && this.gkO != null) {
            this.gkO.d(str, j, j2);
        }
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fYL.ggz.a(this.gmf, this.fYL.ggt, this.gkR, alaLivePersonData);
        }
    }

    private void bHh() {
        if (this.glk != null) {
            this.fYL.ggx.startTime = System.currentTimeMillis();
            this.fYL.ggx.liveTotalTime = System.currentTimeMillis();
            this.fYL.ggx.sampleMemAndCPU();
            this.fYL.ggv.a((short) 4, this.glk);
        }
    }

    private void Da(String str) {
        String str2;
        int i;
        if (bCw() != null && bCw().pageContext != null) {
            this.glg.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bCw().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.glK == null) {
                    this.glK = layoutInflater.inflate(a.h.layout_challenge_entry_toast, (ViewGroup) null);
                    this.glK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            AlaMasterLiveRoomOpearator.this.glg.removeCallbacksAndMessages(null);
                            if (AlaMasterLiveRoomOpearator.this.glK != null) {
                                AlaMasterLiveRoomOpearator.this.bCw().gfT.removeView(AlaMasterLiveRoomOpearator.this.glK);
                            }
                            if (AlaMasterLiveRoomOpearator.this.glB != null) {
                                AlaMasterLiveRoomOpearator.this.glB.bCy();
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.glK.findViewById(a.g.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.i.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.glg.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bCw().gfT != null && AlaMasterLiveRoomOpearator.this.fYS != null && AlaMasterLiveRoomOpearator.this.glK != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.glK.findViewById(a.g.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.glK.findViewById(a.g.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.u((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.glK.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.fYS.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.fYS.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.fYS.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.fYS.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.glK.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.glK.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.glK != null) {
                                AlaMasterLiveRoomOpearator.this.bCw().gfT.removeView(AlaMasterLiveRoomOpearator.this.glK);
                            }
                            AlaMasterLiveRoomOpearator.this.bCw().gfT.addView(AlaMasterLiveRoomOpearator.this.glK, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.v.a.Hm().aZp != null) {
                    i = com.baidu.live.v.a.Hm().aZp.azX;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.glg.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bCw().gfT != null && AlaMasterLiveRoomOpearator.this.glK != null) {
                            AlaMasterLiveRoomOpearator.this.bCw().gfT.removeView(AlaMasterLiveRoomOpearator.this.glK);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
