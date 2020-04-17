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
    private static final String fJo;
    private boolean aNg;
    private List<aj> aQC;
    private boolean fIY;
    private AlaLiveStreamStatusView fJA;
    private RelativeLayout fJB;
    private RelativeLayout fJC;
    private RelativeLayout fJD;
    private RelativeLayout fJE;
    private View fJF;
    private AlaLiveFaceVerifyView fJG;
    private ImageView fJH;
    private ImageView fJI;
    private ImageView fJJ;
    private ImageView fJK;
    private ImageView fJL;
    private ImageView fJM;
    private View fJN;
    private ImageView fJO;
    private TextView fJP;
    private z fJQ;
    private com.baidu.live.x.a fJR;
    private com.baidu.tieba.ala.liveroom.master.panel.b fJS;
    private com.baidu.live.w.a fJT;
    private e fJU;
    private boolean fJp;
    private d fJr;
    private com.baidu.tieba.ala.liveroom.l.a fJs;
    private c fJt;
    private com.baidu.tieba.ala.liveroom.b.a fJu;
    private com.baidu.tieba.ala.liveroom.r.a fJv;
    private com.baidu.tieba.ala.liveroom.v.a fJw;
    private b fJx;
    private com.baidu.tieba.ala.liveroom.tippop.a fJy;
    private AlaLiveCountDownView fJz;
    private short fKe;
    private com.baidu.tieba.ala.liveroom.g.b fKj;
    private boolean fKk;
    private boolean fKl;
    private f fKm;
    private com.baidu.live.b.a fKo;
    private com.baidu.live.b.b fKp;
    private com.baidu.tieba.ala.liveroom.n.a fKq;
    private boolean fKr;
    private BdUniqueId fKs;
    private boolean fKt;
    private String ftF;
    private com.baidu.tieba.ala.liveroom.audiencelist.c fvU;
    private com.baidu.tieba.ala.liveroom.l.a fvV;
    private com.baidu.tieba.ala.liveroom.audiencelist.b fvZ;
    private com.baidu.live.g.a fvd;
    private com.baidu.live.h.a fwK;
    private com.baidu.tieba.ala.liveroom.share.c fwL;
    private com.baidu.tieba.ala.liveroom.o.b fwM;
    private com.baidu.tieba.ala.liveroom.guide.c fwN;
    private com.baidu.tieba.ala.liveroom.watermark.a fwO;
    private o fwV;
    private k fwW;
    private l fwX;
    private v fwY;
    private t fwZ;
    private com.baidu.tieba.ala.liveroom.activeview.b fwb;
    private boolean fxE;
    protected com.baidu.tieba.ala.liveroom.f.a fxg;
    protected h fxh;
    protected x fxj;
    protected com.baidu.live.i.a fxr;
    private com.baidu.live.q.a fxt;
    private ImageView fyA;
    private com.baidu.tieba.ala.liveroom.data.f fze;
    private ImageView fzm;
    private g fzn;
    private boolean fJq = false;
    private boolean fxz = false;
    private Handler mHandler = new Handler();
    private boolean fJV = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver fJW = null;
    private boolean fJX = false;
    private int fJY = 0;
    private int fJZ = 0;
    private int fKa = 0;
    private long fKb = 0;
    private long fKc = 0;
    private volatile boolean isBackground = false;
    private Intent fKd = null;
    private int mOrientation = 1;
    private boolean fFz = false;
    private boolean fKf = false;
    private boolean fKg = true;
    private boolean fzk = false;
    private boolean fKh = true;
    private boolean fKi = true;
    private int cuh = 0;
    public boolean fKn = false;
    private String otherParams = "";
    private int aNi = 0;
    private int fKu = 5000;
    private boolean fKv = false;
    private Runnable fKw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.fvd != null) {
                AlaMasterLiveRoomOpearator.this.fvd.vm();
            }
        }
    };
    private CustomMessageListener aPX = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fze.fFI != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fze.fFI.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.x(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener aPY = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fze.fFI != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.fze.fFI.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener fxQ = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.fwM == null) {
                        AlaMasterLiveRoomOpearator.this.fwM = new com.baidu.tieba.ala.liveroom.o.b();
                    }
                    AlaMasterLiveRoomOpearator.this.fwM.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener fxX = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fxr != null) {
                AlaMasterLiveRoomOpearator.this.fxr.Az();
            }
        }
    };
    private CustomMessageListener fKx = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.k((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fxN = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Ax(str);
            }
        }
    };
    private CustomMessageListener fxO = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aQD();
        }
    };
    private CustomMessageListener fyn = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.fwZ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener fxV = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener fKy = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fKp != null) {
                n DN = AlaMasterLiveRoomOpearator.this.btG().fFc.DN();
                long j = DN.mLiveInfo.live_id;
                long j2 = DN.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.fKp.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener fKz = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.btG().fFd);
            if (AlaMasterLiveRoomOpearator.this.fJr == null || AlaMasterLiveRoomOpearator.this.fJr.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qK(0);
            }
            if (AlaMasterLiveRoomOpearator.this.fwW != null) {
                AlaMasterLiveRoomOpearator.this.fwW.Bf().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.fwW.Bg().hide();
            }
        }
    };
    private CustomMessageListener fxW = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.o(AlaMasterLiveRoomOpearator.this.btG().fFc.DN());
        }
    };
    private CustomMessageListener fxY = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fxj != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.fxj).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fKA = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fKq != null) {
                    AlaMasterLiveRoomOpearator.this.fKq.AB(str);
                }
            }
        }
    };
    private CustomMessageListener fKB = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.fKj != null) {
                        if (!data.anP || AlaMasterLiveRoomOpearator.this.fKs == null || !AlaMasterLiveRoomOpearator.this.fKt) {
                            if (AlaMasterLiveRoomOpearator.this.fKs != null && AlaMasterLiveRoomOpearator.this.fKs == data.anO) {
                                if (data.anJ != null && data.anJ.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.fKt || AlaMasterLiveRoomOpearator.this.fJr.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.fKj.a(AlaMasterLiveRoomOpearator.this.btG().fFC.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.fKk = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.btG().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.fKs = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.btG().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.fKj.a(AlaMasterLiveRoomOpearator.this.btG().fFC.getVideoConfig(), AlaMasterLiveRoomOpearator.this.fKk);
                        if (!AlaMasterLiveRoomOpearator.this.fKk) {
                            AlaMasterLiveRoomOpearator.this.fKk = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.fKr) {
                    AlaMasterLiveRoomOpearator.this.btG().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.fKr = false;
            }
        }
    };
    private CustomMessageListener fKC = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.btG().fFC != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.btG().fFC.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                }
            }
        }
    };
    public CustomMessageListener aNj = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.aNi == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.aNi == 6) {
                            AlaMasterLiveRoomOpearator.this.bxc();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.aNi = 0;
            }
        }
    };
    private View.OnClickListener fKD = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.fJI) {
                    AlaMasterLiveRoomOpearator.this.bxe();
                    AlaMasterLiveRoomOpearator.this.fJS.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.fJH) {
                    if (view == AlaMasterLiveRoomOpearator.this.fJJ) {
                        AlaMasterLiveRoomOpearator.this.aQD();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.fJK) {
                        if (view != AlaMasterLiveRoomOpearator.this.fJM) {
                            if (view != AlaMasterLiveRoomOpearator.this.fzm) {
                                if (view == AlaMasterLiveRoomOpearator.this.fJL) {
                                    if (AlaMasterLiveRoomOpearator.this.fJw != null) {
                                        String str = null;
                                        String str2 = null;
                                        com.baidu.tieba.ala.liveroom.data.h bzf = AlaMasterLiveRoomOpearator.this.btG().fFc.bzf();
                                        if (bzf != null && bzf.mLiveSdkInfo != null) {
                                            str = String.valueOf(bzf.mLiveSdkInfo.mRoomId);
                                            if (bzf.mLiveSdkInfo.mCastIds != null) {
                                                str2 = bzf.mLiveSdkInfo.mCastIds.aqq;
                                            }
                                        }
                                        AlaMasterLiveRoomOpearator.this.fJw.ac("", str, str2);
                                        return;
                                    }
                                    return;
                                } else if (view == AlaMasterLiveRoomOpearator.this.fJO) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopmall"));
                                    n DN = AlaMasterLiveRoomOpearator.this.btG().fFc.DN();
                                    if (AlaMasterLiveRoomOpearator.this.fxg != null && DN != null && DN.mLiveInfo != null) {
                                        String valueOf = String.valueOf(DN.mLiveInfo.live_id);
                                        String valueOf2 = String.valueOf(DN.mLiveInfo.feed_id);
                                        long j = DN.mLiveInfo.room_id;
                                        String str3 = DN.mLiveInfo.cover;
                                        String str4 = "";
                                        String str5 = "";
                                        String str6 = "";
                                        String str7 = "";
                                        if (DN.mLiveInfo.session_info != null) {
                                            str4 = DN.mLiveInfo.session_info.flvUrl;
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
                                        long j2 = DN.mLiveInfo.user_id;
                                        long j3 = DN.mLiveInfo.group_id;
                                        AlaMasterLiveRoomOpearator.this.fxg.AB(com.baidu.live.utils.o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7, String.valueOf(j2), DN.mLiveInfo.user_name, String.valueOf(j3), String.valueOf(DN.aqe.userId)));
                                        return;
                                    }
                                    return;
                                } else {
                                    return;
                                }
                            }
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                            if (AlaMasterLiveRoomOpearator.this.fKm != null) {
                                AlaMasterLiveRoomOpearator.this.fKm.btI();
                                return;
                            }
                            return;
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.fJT != null) {
                            AlaMasterLiveRoomOpearator.this.fJT.showDialog();
                            AlaMasterLiveRoomOpearator.this.fJT.bN(AlaMasterLiveRoomOpearator.this.bxi());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.fKt = false;
                        AlaMasterLiveRoomOpearator.this.kE(true);
                    }
                } else if (com.baidu.live.v.a.Eo().aQp.atx == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.v.a.Eo().aQp.atw == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.aNg) {
                        AlaMasterLiveRoomOpearator.this.bxc();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.aNi = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bxc();
                }
            }
        }
    };
    private CustomMessageListener fxP = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof z) {
                    AlaMasterLiveRoomOpearator.this.fxz = true;
                    AlaMasterLiveRoomOpearator.this.fJQ = (z) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.fwW != null) {
                        AlaMasterLiveRoomOpearator.this.fwW.Bf().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fwW != null) {
                        AlaMasterLiveRoomOpearator.this.fwW.Bg().show();
                        AlaMasterLiveRoomOpearator.this.fwW.Bg().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.qK(8);
                }
            }
        }
    };
    private CustomMessageListener fKE = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.btG() != null && AlaMasterLiveRoomOpearator.this.btG().fFG != null) {
                AlaMasterLiveRoomOpearator.this.btG().fFG.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener aYw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bxR();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.btG().fFc.qR(i);
                if (AlaMasterLiveRoomOpearator.this.fxr != null) {
                    AlaMasterLiveRoomOpearator.this.fxr.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener ftQ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bxK();
        }
    };
    public final HttpMessageListener fKF = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.DQ()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.fJS != null) {
                            AlaMasterLiveRoomOpearator.this.fJS.kL(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.fJS.byr();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.btG().fFC.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.fJy != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.fJy.a(AlaMasterLiveRoomOpearator.this.btG().rootView, AlaMasterLiveRoomOpearator.this.btG().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.btG().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.fJy.qY(2);
                        AlaMasterLiveRoomOpearator.this.fJy.a(AlaMasterLiveRoomOpearator.this.btG().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a fKG = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bxY() {
            AlaMasterLiveRoomOpearator.this.bxH();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bxZ() {
            AlaMasterLiveRoomOpearator.this.bxI();
        }
    };
    com.baidu.live.liveroom.a.a fKH = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.live.liveroom.a.a
        public boolean cr(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cs(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ct(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.btG().bvj() == 1) {
                AlaMasterLiveRoomOpearator.this.btG().fFC.stopRecord();
            }
        }
    };
    private IShareCallback fKI = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.fJV && AlaMasterLiveRoomOpearator.this.fJU != null) {
                AlaMasterLiveRoomOpearator.this.fJV = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.fJU);
            }
        }
    };
    private View.OnTouchListener fKJ = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.btG().fFG.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.btG().fFd);
            AlaMasterLiveRoomOpearator.this.qK(0);
            if (AlaMasterLiveRoomOpearator.this.fwW != null) {
                AlaMasterLiveRoomOpearator.this.fwW.Bf().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.fwW.Bg().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b fKK = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bya() {
            AlaMasterLiveRoomOpearator.this.bxd();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void byb() {
            AlaMasterLiveRoomOpearator.this.fIY = AlaMasterLiveRoomOpearator.this.fJr.bvb();
            AlaMasterLiveRoomOpearator.this.btG().fFG.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.btG().fFG.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.btG().fFG.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fFw = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.btG().bvj();
            eVar.title = AlaMasterLiveRoomOpearator.this.fJr.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.fFx = AlaMasterLiveRoomOpearator.this.fJr.bvc();
            eVar.fFA = AlaMasterLiveRoomOpearator.this.fIY;
            eVar.fFz = AlaMasterLiveRoomOpearator.this.fJr.buZ();
            eVar.fFy = AlaMasterLiveRoomOpearator.this.fJr.bve();
            eVar.fFB = AlaMasterLiveRoomOpearator.this.fJr.bva();
            if (eVar.fFB) {
                if (AlaMasterLiveRoomOpearator.this.fJr.bvf()) {
                    AlaMasterLiveRoomOpearator.this.fJV = true;
                    AlaMasterLiveRoomOpearator.this.fJU = eVar;
                    AlaMasterLiveRoomOpearator.this.fJr.bvg();
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
            AlaMasterLiveRoomOpearator.this.btG().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.btG().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void byc() {
            AlaMasterLiveRoomOpearator.this.fKt = true;
            AlaMasterLiveRoomOpearator.this.kE(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean byd() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bye() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void byf() {
            com.baidu.live.utils.o.k(AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity(), "", "");
        }
    };
    private Runnable fKL = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // java.lang.Runnable
        public void run() {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()) {
                if (AlaMasterLiveRoomOpearator.this.btG().fFc != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN() != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo != null) {
                    m.j(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.live_id);
                }
                if (AlaMasterLiveRoomOpearator.this.mHandler != null) {
                    AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(AlaMasterLiveRoomOpearator.this.fKL, AlaMasterLiveRoomOpearator.this.fKu);
                }
            }
        }
    };
    private CustomMessageListener aLb = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bsg();
            }
        }
    };
    private com.baidu.live.liveroom.g.c fKM = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void DL() {
            if (AlaMasterLiveRoomOpearator.this.fJw != null) {
                AlaMasterLiveRoomOpearator.this.fJw.kX(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bK(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.fKm != null) {
                        AlaMasterLiveRoomOpearator.this.fKm.d(AlaMasterLiveRoomOpearator.this.fzm);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fJT != null) {
                        AlaMasterLiveRoomOpearator.this.fJT.setStickerCanOperate(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.fKm != null) {
                        AlaMasterLiveRoomOpearator.this.fKm.Hq();
                    }
                    if (AlaMasterLiveRoomOpearator.this.fJT != null) {
                        AlaMasterLiveRoomOpearator.this.fJT.setStickerCanOperate(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.fJw != null) {
                    AlaMasterLiveRoomOpearator.this.fJw.kX(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.fxj != null) {
                    AlaMasterLiveRoomOpearator.this.fxj.aZ(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a fKN = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.fJG != null && AlaMasterLiveRoomOpearator.this.btG().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.fJG) >= 0) {
                AlaMasterLiveRoomOpearator.this.btG().rootView.removeView(AlaMasterLiveRoomOpearator.this.fJG);
                AlaMasterLiveRoomOpearator.this.fJG.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.fJG = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b fwA = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void l(View view, int i) {
            n DN;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bxQ();
            } else if (i == 14 && (DN = AlaMasterLiveRoomOpearator.this.btG().fFc.DN()) != null && DN.aqe != null && DN.mLiveInfo != null && DN.aqx != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity(), DN.aqe.userName, Long.toString(DN.aqe.userId), Long.toString(DN.aqe.charmCount), String.valueOf(DN.mLiveInfo.group_id), String.valueOf(DN.mLiveInfo.live_id), true, String.valueOf(DN.aqe.userId), Long.toString(DN.aqx.userId), DN.aqx.userName, DN.aqx.portrait, AlaMasterLiveRoomOpearator.this.fvZ.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(DN.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.fvZ.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener fKO = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.fKn = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fLP;
            }
        }
    };
    private HttpMessageListener fKP = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.fJP.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.fJP.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.fJP.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.fJP.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.aQC = getVideoGoodsListHttpResponseMessage.aQC;
            }
        }
    };
    private HttpMessageListener fKQ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                if (AlaMasterLiveRoomOpearator.this.btG().fFc != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN() != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo != null) {
                    long j = AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.live_id;
                    if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.aQw != null && !eventPollingHttpResponseMessage.aQw.isEmpty()) {
                        long j2 = eventPollingHttpResponseMessage.currentTime;
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= eventPollingHttpResponseMessage.aQw.size()) {
                                break;
                            }
                            ai aiVar = eventPollingHttpResponseMessage.aQw.get(i2);
                            if (j == aiVar.liveId && j2 - aiVar.createTime <= 60 && !m.h(aiVar.liveId, aiVar.id)) {
                                m.a(aiVar, AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo);
                                m.i(aiVar.liveId, aiVar.id);
                            }
                            i = i2 + 1;
                        }
                        ai aiVar2 = eventPollingHttpResponseMessage.aQw.get(eventPollingHttpResponseMessage.aQw.size() - 1);
                        if (j == aiVar2.liveId) {
                            m.g(aiVar2.liveId, aiVar2.id);
                        }
                    }
                }
                int i3 = eventPollingHttpResponseMessage.aQv;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.fKu = i3 * 1000;
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a fKR = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private com.baidu.live.liveroom.middleware.g fKS = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.anf);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        fJo = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(n nVar) {
        if (nVar != null && nVar.mLiveInfo != null && com.baidu.live.v.a.Eo().aQp != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(btG().pageContext.getPageActivity(), String.valueOf(nVar.mLiveInfo.live_id), String.valueOf(nVar.mLiveInfo.user_id), com.baidu.live.v.a.Eo().aQp.ats, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ax(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(btG().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.Eo().aQp.asQ;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? btG().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : btG().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(btG().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsg() {
        int i = btG().fFc.DN().aqe.isUegBlock;
        int i2 = btG().fFc.DN().aqe.isBlock;
        String str = btG().fFc.DN().aqe.userName;
        if (i > 0 || i2 > 0) {
            this.aNg = true;
            this.fwW.a(true, i, i2, str);
            return;
        }
        this.aNg = false;
        this.fwW.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.fze.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.aNt == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.aNu);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.fze.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.fze.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (this.fwW != null) {
            this.fwW.Bg().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.fKm != null) {
            this.fKm.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxd() {
        if (btG() != null && btG().fFc != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                btG().fFc.byX();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                btG().fFc.byY();
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
                    AlaMasterLiveRoomOpearator.this.fJX = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.fJX = false;
                }
                if (AlaMasterLiveRoomOpearator.this.fJY == 0) {
                    AlaMasterLiveRoomOpearator.this.fJY = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.fJZ == 0) {
                    AlaMasterLiveRoomOpearator.this.fJZ = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.fKa = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (btG() != null && btG().fFE != null) {
            btG().fFE.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.f fVar, String str) {
        this.fze = fVar;
        this.ftF = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.f btG() {
        return this.fze;
    }

    public int a(g gVar) {
        this.fzn = gVar;
        this.fJW = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.fJW, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.fJy == null) {
            this.fJy = new com.baidu.tieba.ala.liveroom.tippop.a(this.fze.pageContext, null);
        }
        registerListener();
        this.fvd = new com.baidu.live.g.a();
        bxs();
        Long[] lArr = new Long[1];
        this.fKb = lArr[0] == null ? 0L : lArr[0].longValue();
        this.fKc = lArr[0] != null ? lArr[0].longValue() : 0L;
        btG().fFd.setOnTouchListener(this.fKJ);
        this.fJp = SharedPrefHelper.getInstance().getBoolean(fJo, false);
        this.fJz = new AlaLiveCountDownView(btG().pageContext.getPageActivity());
        this.fJz.setCount(3);
        this.fJz.setTextColor(btG().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.fJz.setTextSize(btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.fJz.setTypeface(Typeface.DEFAULT_BOLD);
        this.fJz.setIncludeFontPadding(false);
        this.fJz.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void byg() {
                if (AlaMasterLiveRoomOpearator.this.btG().fFd != null) {
                    AlaMasterLiveRoomOpearator.this.btG().fFd.removeView(AlaMasterLiveRoomOpearator.this.fJz);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxe() {
        if (this.fJS == null) {
            this.fJS = new com.baidu.tieba.ala.liveroom.master.panel.b(btG().pageContext.getPageActivity(), btG().bvj() == 2);
            this.fJS.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kG(boolean z) {
                    AlaMasterLiveRoomOpearator.this.btG().fFC.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kH(boolean z) {
                    AlaMasterLiveRoomOpearator.this.btG().fFC.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kI(boolean z) {
                    AlaMasterLiveRoomOpearator.this.btG().fFC.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bxP();
                    if (AlaMasterLiveRoomOpearator.this.fJy != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.fJy.a(AlaMasterLiveRoomOpearator.this.btG().rootView, AlaMasterLiveRoomOpearator.this.btG().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.fJy.a(AlaMasterLiveRoomOpearator.this.btG().rootView, AlaMasterLiveRoomOpearator.this.btG().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void kJ(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byh() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.btG().fFc != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN() != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byi() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.btG().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byj() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.btG() != null && AlaMasterLiveRoomOpearator.this.btG().fFc != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN() != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.btG().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.fJS != null) {
                            AlaMasterLiveRoomOpearator.this.fJS.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void byk() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1396", "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.btG() == null || AlaMasterLiveRoomOpearator.this.btG().fFc == null || AlaMasterLiveRoomOpearator.this.btG().fFc.DN() == null || AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.btG() != null && AlaMasterLiveRoomOpearator.this.btG().fFc != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN() != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.fJS != null) {
                                        AlaMasterLiveRoomOpearator.this.fJS.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.l(AlaMasterLiveRoomOpearator.this.fze.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.fJS != null) {
                        AlaMasterLiveRoomOpearator.this.fJS.dismiss();
                    }
                }
            });
        }
        bxf();
    }

    private void bxf() {
        if (this.fJS != null) {
            boolean isBackCamera = btG().fFC.isBackCamera();
            this.fJS.kK(btG().fFC.isBackCamera());
            this.fJS.F(btG().fFC.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = btG().fFC.isPushMirror();
            if (this.fKg) {
                isPushMirror = bxO() || isPushMirror;
                this.fKg = false;
            }
            this.fJS.G(isPushMirror, isBackCamera ? false : true);
            this.fJS.kL(btG().fFC.isMute());
            this.fJS.byr();
        }
    }

    public void bxg() {
        if (this.fzn != null) {
            if (this.fzn.fFJ == null || this.fzn.fFJ.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.fJF == null) {
                        this.fJF = this.fze.fFI.Dv();
                        this.fze.rootView.addView(this.fJF, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.fJr == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (btG().fFc != null && btG().fFc.DN() != null && btG().fFc.DN().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", btG().fFc.DN().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", btG().fFc.DN().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.fJr = new d(btG().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    btG().fFG.prepareTime = System.currentTimeMillis();
                    btG().rootView.addView(this.fJr.getView(), layoutParams);
                    this.fJr.a(this.fKI);
                }
                this.fJr.kq(this.fFz);
                this.fJr.a(this.fKK);
                this.fJr.a(this.fKG);
                this.fJr.a(btG().fFC, btG().bvj());
                return;
            }
            this.fIY = this.fzn.fFJ.mLiveInfo.screen_direction == 2;
            if (this.fzn.fFJ.mLiveInfo.isAudioOnPrivate == 1) {
                btG().fFC.setMute(true);
                if (this.fJy == null) {
                    this.fJy = new com.baidu.tieba.ala.liveroom.tippop.a(this.fze.pageContext, null);
                }
                if (!this.fJy.qX(2)) {
                    this.fJy.a(btG().rootView, btG().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fFw = true;
            eVar.forumId = String.valueOf(this.fzn.fFJ.mLiveInfo.forum_id);
            eVar.forumName = this.fzn.fFJ.mLiveInfo.forum_name;
            eVar.liveType = this.fzn.fFJ.mLiveInfo.live_type;
            eVar.title = this.fzn.fFJ.mLiveInfo.getLiveTitle();
            eVar.clarity = this.fzn.fFJ.mLiveInfo.clarity;
            eVar.gameId = this.fzn.fFJ.mLiveInfo.game_id;
            eVar.gameName = this.fzn.fFJ.mLiveInfo.game_label;
            eVar.fFA = this.fzn.fFJ.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bxh() {
        if (this.fKj != null) {
            this.fKj.a(btG().fFC.getVideoConfig(), false);
        }
        if (this.fJr != null) {
            this.fJr.kp(true);
        }
        if (btG().fFC.hasBeauty() >= 0) {
            btG().fFC.setBeauty(com.baidu.live.c.tH().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            btG().fFI.C(this.fze.fFC);
        } else if (this.fJr != null) {
            this.fJr.kp(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.fJF != null && this.fJF.getParent() != null) {
                ((ViewGroup) this.fJF.getParent()).removeView(this.fJF);
                this.fJF = null;
            }
            btG().fFd.setVisibility(0);
            this.fze.fFI.a(btG().fFd);
        } else {
            bxx();
            bxN();
            this.fJw = new com.baidu.tieba.ala.liveroom.v.a(btG().pageContext, this.fKH);
            this.fJw.d(btG().fFd, true);
            this.fJw.kX(true);
            if (this.fwW != null && this.fwW.Bf() != null) {
                this.fwW.Bf().setNeedTopAlphaShade(true);
            }
        }
        btG().fFC.setPushMirror(bxO());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fze.fFI.j(btG().fFc.DN());
        }
        if (!btG().fFC.isBackground() && btG().fFc.DN() != null && btG().fFc.DN().mLiveInfo != null) {
            int startPush = btG().fFC.startPush(btG().fFc.DN().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fze.fFI.Dw();
            }
            if (startPush != 0 && btG().fFG != null) {
                btG().fFG.errCode = 4;
                btG().fFG.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.bvn() && !bxL()) {
                kF(true);
                bxM();
            }
            if (this.fJt != null) {
                this.fJt.p(btG().fFc.DN());
            }
            if (this.fvV != null) {
                this.fvV.t(btG().fFc.DN());
            }
            if (this.fwK != null) {
                this.fwK.a(btG().fFc.DN());
            }
            if (this.fJu != null && btG() != null && btG().fFc != null) {
                if (this.fJu.ai(btG().fFd)) {
                    this.fJu.n(btG().fFc.DN());
                } else {
                    this.fJu.b(btG().fFd, btG().fFc.DN());
                }
            }
            if (this.fJs != null) {
                this.fJs.t(btG().fFc.DN());
            }
            if (hVar == null || hVar.aqe == null) {
                z = com.baidu.live.c.tH().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.aqe.canUseChallenge;
                com.baidu.live.c.tH().putBoolean("ala_master_can_use_challenge", z);
            }
            bxy();
            bxl();
            kC(z);
            bxz();
            bxE();
            bsH();
            bsV();
            u(btG().fFc.DN());
            f(btG().fFc.DN());
            bxF();
            bxG();
            bxC();
            bsJ();
            bsQ();
            bsR();
            bxw();
            if (this.fwV != null) {
                this.fwV.g(btG().fFc.DN());
            }
            if (this.fwW != null) {
                this.fwW.e(String.valueOf(btG().fFc.DN().mLiveInfo.group_id), String.valueOf(btG().fFc.DN().mLiveInfo.last_msg_id), String.valueOf(btG().fFc.DN().aqe.userId), String.valueOf(btG().fFc.DN().mLiveInfo.live_id), btG().fFc.DN().aqe.appId);
            }
            if (this.fwX != null) {
                this.fwX.a(btG().fFc.DN(), true);
            }
            if (!this.fKv && (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled()))) {
                this.fKv = true;
                this.mHandler.post(this.fKL);
            }
            this.mHandler.post(this.fKw);
        }
    }

    private void kC(boolean z) {
        if (this.fKm == null) {
            this.fKm = new f(btG());
        }
        this.fKm.a(this.fzm, this.fzn);
        this.fKm.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ag agVar, ah ahVar, ah ahVar2) {
                if (AlaMasterLiveRoomOpearator.this.fwO != null) {
                    AlaMasterLiveRoomOpearator.this.fwO.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.btG().fFd.fSe = false;
                AlaMasterLiveRoomOpearator.this.bxj();
                if (AlaMasterLiveRoomOpearator.this.fxt != null) {
                    AlaMasterLiveRoomOpearator.this.fxt.b(AlaMasterLiveRoomOpearator.this.kD(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void un() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fKw);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void btE() {
                if (AlaMasterLiveRoomOpearator.this.fwO != null) {
                    AlaMasterLiveRoomOpearator.this.fwO.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.btG().fFd.fSe = true;
                AlaMasterLiveRoomOpearator.this.bxk();
                if (AlaMasterLiveRoomOpearator.this.fxt != null) {
                    AlaMasterLiveRoomOpearator.this.fxt.b(AlaMasterLiveRoomOpearator.this.kD(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void btF() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fKw);
            }
        });
        this.fKm.C(this.fIY, z);
        this.fKm.h(this.fIY, z, (this.fzn == null || this.fzn.fFJ == null || this.fzn.fFJ.mChallengeData == null) ? false : true);
    }

    public boolean bxi() {
        return this.fKm != null && this.fKm.btK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxj() {
        if (this.fJx != null) {
            this.fJx.setVisible(8);
            this.fJx.setCanVisible(false);
        }
        if (this.fwb != null) {
            this.fwb.jP(true);
            ki(true);
        }
        if (this.fJA != null) {
            this.fJA.setCanVisible(false);
            this.fJA.setVisibility(4);
        }
        if (this.fJw != null) {
            this.fJw.kW(false);
        }
        if (this.fwW != null) {
            this.fwW.Bf().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxk() {
        if (this.fJx != null) {
            this.fJx.setCanVisible(true);
        }
        if (this.fwb != null) {
            this.fwb.jP(false);
            ki(false);
        }
        if (this.fJA != null) {
            this.fJA.setCanVisible(true);
        }
        if (this.fJw != null) {
            this.fJw.kW(true);
        }
        if (this.fwW != null) {
            this.fwW.Bf().setNeedTopAlphaShade(false);
        }
    }

    private void ki(boolean z) {
        ViewGroup.LayoutParams qm;
        if (this.fwb != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.fwb;
            AlaLiveView alaLiveView = btG().fFd;
            if (z) {
                qm = bxX();
            } else {
                qm = qm(1);
            }
            bVar.a(1, alaLiveView, qm, 21);
            this.fwb.updateView();
        }
    }

    private void bxl() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.fJA == null) {
            this.fJA = new AlaLiveStreamStatusView(btG().pageContext.getPageActivity());
        }
        this.fJA.setId(a.g.ala_live_room_stream_view);
        this.fJA.setVisibility(4);
        this.fJA.setLayoutParams(layoutParams);
        if (this.fJA.getParent() == null) {
            btG().fFd.addView(this.fJA, layoutParams);
        }
    }

    public void bxm() {
        if (this.fJr != null && this.fJr.getVisibility() != 8 && btG().fFC.getPreview() != null) {
            btG().fFC.stopRecord();
        }
    }

    public void bxn() {
        if (btG().fFC.getPreview() != null) {
            btG().fFC.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fKj != null) {
                this.fKj.ko(false);
            }
            this.fKj = new com.baidu.tieba.ala.liveroom.g.b(btG().rootView, btG(), btG().fFC);
            this.fKj.a(btG().fFC.getVideoConfig(), false);
        }
        if (this.fJy != null) {
            this.fJy.bAf();
        }
        this.mHandler.post(this.fKw);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fJq = z;
        if (z) {
            if (this.fKi) {
                this.fKi = false;
                if (this.fwW != null && this.fwW.Bf() != null) {
                    this.fwW.Bf().getView().setBottom(0);
                }
                if (this.fwW != null && this.fwW.Bg() != null) {
                    this.fwW.Bg().getView().setBottom(0);
                }
            }
            if (this.fwW != null && this.fwW.Bf() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fwW.Bf().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.fwW.Bf().getView().setLayoutParams(layoutParams);
            }
            if (this.fwW != null && this.fwW.Bg() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fwW.Bg().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.fwW.Bg().getView().setLayoutParams(layoutParams2);
                this.fwW.Bg().getView().setVisibility(0);
                this.fwW.Bg().CS();
            }
            qK(8);
            qJ(8);
        } else {
            if (this.fwW != null && this.fwW.Bf() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fwW.Bf().getView().getLayoutParams();
                layoutParams3.bottomMargin = btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fwW.Bf().getView().setLayoutParams(layoutParams3);
            }
            if (this.fwW != null && this.fwW.Bg() != null) {
                this.fwW.Bg().hide();
            }
            qK(0);
            qJ(0);
        }
        if (this.fJr != null) {
            this.fJr.E(false, z);
        }
        if (this.fwX != null) {
            this.fwX.Bn();
        }
        if (this.fJT != null) {
            this.fJT.onKeyboardVisibilityChanged(z);
        }
        if (this.fwW != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(btG().pageContext.getPageActivity())) + btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (btG().fFd.indexOfChild(this.fwW.Bf().getView()) != -1 && this.fwW.Bf().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fwW.Bf().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.fwW.Bf().getView().setLayoutParams(layoutParams4);
            }
            this.fwW.Bf().Be();
        }
        this.mHandler.post(this.fKw);
    }

    private void qJ(int i) {
        if (this.fvV != null) {
            this.fvV.qw(i);
        }
        if (this.fJC != null) {
            this.fJC.setVisibility(i);
        }
        if (this.fwK != null) {
            this.fwK.getView().setVisibility(i);
        }
        if (this.fJv != null) {
            this.fJv.setVisible(i);
        }
        if (this.fJu != null) {
            this.fJu.setVisibility(i);
        }
        if (this.fwb != null) {
            this.fwb.setVisible(i);
        }
        if (this.fxt != null) {
            this.fxt.setCanVisible(i == 0);
        }
        if (this.fxh != null) {
            this.fxh.setVisible(i);
        }
        if (this.fxr != null) {
            this.fxr.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            btG().fFG.errCode = 1;
            bxH();
        } else if (i == -5) {
            bxI();
        } else if (i == -2) {
            AN(btG().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            btG().fFC.stopRecord();
        } else if (i == -3 && this.fJr != null) {
            this.fJr.kp(false);
        }
        if (i == -4) {
            if (this.fJr == null || this.fJr.getView().getParent() == null) {
                btG().f((short) 1);
                return;
            }
            this.fJr.bvd();
            this.fJK.setVisibility(0);
            if (this.fJw != null) {
                this.fJw.kX(true);
            }
            btG().fFd.setBackgroundColor(btG().pageContext.getResources().getColor(17170445));
            bxU();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        btg();
        if (i == 12001) {
            if (i2 == -1) {
                AO(ab(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                ac(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aQD();
        }
    }

    public void onResume() {
        if (this.fJr != null) {
            this.fJr.onResume();
        }
        if (this.fJV && this.fJU != null) {
            this.fJV = false;
            c(this.fJU);
        }
        if (this.fxj != null) {
            this.fxj.onResume();
        }
    }

    public void g(short s) {
        if (this.fwV != null) {
            this.fwV.xj();
        }
        if (this.fwW != null) {
            this.fwW.a(null);
            this.fwW.AK();
        }
        if (this.fwX != null) {
            this.fwX.AK();
        }
        if (this.fKm != null) {
            this.fKm.btJ();
        }
    }

    public boolean bxo() {
        n DN = btG().fFc.DN();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fze.fFI.i(DN);
            if (DN != null && DN.mLiveInfo.live_status != 1) {
                bxS();
                btG().pageContext.getPageActivity().finish();
                if (btG().fFc != null && btG().fFc.DN() != null) {
                    a(DN, 1, btG().fFc.bzp() != 1 ? btG().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.fwW != null) {
                this.fwW.Bf().a(String.valueOf(DN.mLiveInfo.group_id), String.valueOf(DN.mLiveInfo.live_id), true, String.valueOf(DN.aqe.userId));
            }
            if (this.fwX != null) {
                this.fwX.a(DN);
            }
            if (this.fwK != null) {
                this.fwK.a(btG().fFc.DN());
            }
            if (this.fvV != null) {
                this.fvV.t(DN);
            }
            if (DN != null) {
                if (this.fJt != null) {
                    this.fJt.p(DN);
                }
                if (this.fKm != null) {
                    this.fKm.a(DN);
                }
                if (this.fwZ != null && DN.mLiveInfo != null) {
                    this.fwZ.a(DN.mLiveInfo);
                }
                if (this.fxt != null) {
                    this.fxE = this.fxt.m(DN);
                }
                if (this.fwb != null) {
                    this.fwb.jQ(this.fxE);
                    this.fwb.h(DN);
                    this.fwb.updateView();
                }
                if (this.fxr != null) {
                    this.fxr.a(DN);
                }
                if (DN.mLiveInfo.live_status != 1) {
                    bxS();
                    btG().pageContext.getPageActivity().finish();
                    if (btG().fFc != null && btG().fFc.DN() != null) {
                        a(DN, 1, btG().fFc.bzp() != 1 ? btG().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.fKn) {
                    this.fJN.setVisibility(0);
                    if (!this.fKl && DN.mLiveInfo != null) {
                        this.fKl = true;
                        com.baidu.live.utils.o.g(DN.mLiveInfo.feed_id, DN.mLiveInfo.live_id);
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("1394", "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "shopcart_show"));
                } else {
                    this.fJN.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bxp() {
        bxf();
    }

    public void bxq() {
        if (this.fKj != null) {
            this.fKj.buX();
        }
    }

    public void bxr() {
        if (this.fJr != null && this.fJr.getVisibility() != 8) {
            if (btG().bvj() == 2) {
                bxU();
            } else {
                bxT();
            }
        }
        if (this.fJr != null && this.fJr.getVisibility() != 8) {
            if (btG().bvj() == 1) {
                this.fJr.onResume();
            }
            this.fJr.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.fxz && this.fJQ != null) {
            if (this.fwW != null) {
                this.fwW.Bf().getView().setVisibility(0);
            }
            if (this.fwW != null) {
                this.fwW.Bg().show();
                this.fwW.Bg().setEditText(" @" + this.fJQ.getNameShow() + " ");
            }
            qK(8);
            this.fxz = false;
        }
        if (this.fxg != null) {
            this.fxg.resume();
        }
        if (this.fKp != null) {
            this.fKp.resume();
        }
        if (this.fKq != null) {
            this.fKq.resume();
        }
    }

    public void onPause() {
        if (this.fxg != null) {
            this.fxg.pause();
        }
        if (this.fKp != null) {
            this.fKp.pause();
        }
        if (this.fxj != null) {
            this.fxj.onPause();
        }
        if (this.fKq != null) {
            this.fKq.pause();
        }
    }

    private void bxs() {
        this.fJB = (RelativeLayout) btG().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.fJD = (RelativeLayout) btG().rootView.findViewById(a.g.under_live_view_panel);
        this.fJE = (RelativeLayout) btG().rootView.findViewById(a.g.over_live_view_panel);
        this.fze.fFd.setOnLiveViewScrollListener(this.fKM);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fJD.setVisibility(8);
            this.fJE.setVisibility(8);
            btG().fFd.removeAllViews();
            return;
        }
        this.fJC = (RelativeLayout) btG().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fJC.getLayoutParams();
        layoutParams.topMargin = this.fze.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = this.fze.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
        }
        this.fJC.setLayoutParams(layoutParams);
        if (this.fvZ == null) {
            this.fvZ = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.fze.pageContext.getPageActivity(), false);
        }
        this.fvZ.a(this.fwA);
        this.fvZ.a(this.fJC, a.g.ala_live_room_host_header_stub, 1L);
        this.fvZ.setVisible(0);
        this.fJK = (ImageView) btG().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.fJK.setOnClickListener(this.fKD);
        this.fJM = (ImageView) btG().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.fJM.setOnClickListener(this.fKD);
        if (com.baidu.live.v.a.Eo().aRw != null && com.baidu.live.v.a.Eo().aRw.avs != null && com.baidu.live.v.a.Eo().aRw.avs.ve() && aq.b(com.baidu.live.v.a.Eo().aRw)) {
            this.fJM.setVisibility(0);
        } else {
            this.fJM.setVisibility(8);
        }
        if (aq.c(com.baidu.live.v.a.Eo().aRw)) {
            this.fJK.setVisibility(0);
            if (aq.c(com.baidu.live.v.a.Eo().aRw)) {
                this.fJK.setAlpha(0.2f);
            }
        } else if (btG().fFC.hasBeauty() < 0) {
            this.fJK.setVisibility(8);
        } else {
            if (aq.c(com.baidu.live.v.a.Eo().aRw)) {
                this.fJK.setAlpha(0.2f);
            }
            com.baidu.live.c.tH().getInt("live_beauty_level", 3);
        }
        this.fJJ = (ImageView) btG().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.fJJ.setOnClickListener(this.fKD);
        this.fJH = (ImageView) btG().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.fJH.setOnClickListener(this.fKD);
        this.fzm = (ImageView) btG().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.fzm.setOnClickListener(this.fKD);
        this.fJI = (ImageView) btG().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.fJI.setOnClickListener(this.fKD);
        this.fJL = (ImageView) btG().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.fJL.setOnClickListener(this.fKD);
        this.fJN = btG().rootView.findViewById(a.g.host_goods_layout);
        this.fJO = (ImageView) btG().rootView.findViewById(a.g.host_goods_imageView);
        this.fJP = (TextView) btG().rootView.findViewById(a.g.host_goods_num_textView);
        this.fJO.setOnClickListener(this.fKD);
        bxv();
        if (aq.b(com.baidu.live.v.a.Eo().aRw)) {
            this.fKj = new com.baidu.tieba.ala.liveroom.g.b(btG().rootView, btG(), btG().fFC);
        }
        this.fwV = new o();
        bxt();
        bxu();
    }

    private void bxt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, btG().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.fwW = (k) runTask.getData();
            this.fwW.setFromMaster(true);
            this.fwW.Bf().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(btG().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(btG().pageContext.getPageActivity()) * 0.27f)) + btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            btG().fFd.addView(this.fwW.Bf().getView(), layoutParams);
            this.fwW.Bg().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            btG().fFd.addView(this.fwW.Bg().getView(), layoutParams2);
            this.fwW.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
                @Override // com.baidu.live.im.k.a
                public boolean Bh() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Bi() {
                }

                @Override // com.baidu.live.im.k.a
                public void eE(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Bj() {
                }

                @Override // com.baidu.live.im.k.a
                public void Bk() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Bl() {
                    return false;
                }
            });
        }
    }

    private void bxu() {
        View Bm;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, l.class, btG().pageContext);
        if (runTask != null) {
            this.fwX = (l) runTask.getData();
        }
        if (this.fwX != null && (Bm = this.fwX.Bm()) != null && this.fze.fFd.indexOfChild(Bm) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.fze.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = btG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            btG().fFd.addView(Bm, layoutParams);
        }
    }

    private void bxv() {
        CustomResponsedMessage runTask;
        if (this.fJR == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, btG().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fJR = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bxw() {
        View wI;
        u.b(btG().pageContext);
        if (this.fwY == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.ayi = true;
            fVar.context = btG().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, v.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.fwY = (v) runTask.getData();
                if (this.fwY != null && (wI = this.fwY.wI()) != null && btG().fFd.indexOfChild(wI) < 0) {
                    if (wI.getParent() instanceof ViewGroup) {
                        ((ViewGroup) wI.getParent()).removeView(wI);
                    }
                    btG().fFd.addView(wI, btG().fFd.getLayoutParams());
                }
            }
        }
    }

    protected void bsR() {
        View xa;
        if (this.fwZ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.ayi = true;
            aVar.context = btG().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, t.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.fwZ = (t) runTask.getData();
            }
        }
        if (this.fwZ != null && (xa = this.fwZ.xa()) != null) {
            if (btG().fFd.indexOfChild(xa) < 0) {
                if (xa.getParent() instanceof ViewGroup) {
                    ((ViewGroup) xa.getParent()).removeView(xa);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                btG().fFd.addView(xa, layoutParams);
            }
            xa.bringToFront();
        }
    }

    protected void bsQ() {
        View xk;
        if (this.fxj == null) {
            aa aaVar = new aa();
            aaVar.ayi = true;
            aaVar.pageContext = btG().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, x.class, aaVar);
            if (runTask != null && runTask.getData() != null) {
                this.fxj = (x) runTask.getData();
            }
        }
        if (this.fxj != null && (xk = this.fxj.xk()) != null && btG().fFd.indexOfChild(xk) < 0) {
            if (xk.getParent() instanceof ViewGroup) {
                ((ViewGroup) xk.getParent()).removeView(xk);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            btG().fFd.addView(xk, layoutParams);
        }
    }

    private void bxx() {
        bxB();
        brT();
        bxA();
        btG().fFd.setVisibility(0);
        qK(0);
    }

    private void bxy() {
        if (this.fJv == null) {
            this.fJv = new com.baidu.tieba.ala.liveroom.r.a(btG().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.fJv.a(btG().bvj(), j, TbadkCoreApplication.getCurrentAccountName(), true, btG().fFc.DN().aqe.portrait, this.otherParams, "", -1L);
        this.fJv.ah(btG().fFd);
    }

    private void bxz() {
        if (this.fJT == null) {
            com.baidu.live.w.a ev = ev(btG().pageContext.getPageActivity());
            if (ev != null) {
                this.fJT = ev;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, btG().pageContext.getPageActivity());
                if (runTask != null) {
                    this.fJT = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.fJT != null) {
                this.fJT.i(this.fJD);
                this.fJT.j(this.fJE);
                this.fJT.cx((btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.fwO != null) {
                    this.fJT.cw(this.fwO.bBd());
                }
                this.fJT.k(btG().fFd);
                this.fJT.a(this.fvd);
                this.fJT.setLiveShowInfo(btG().fFc.DN());
                this.fJT.a(this.fwb);
                this.fJT.a(new a.InterfaceC0132a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // com.baidu.live.w.a.InterfaceC0132a
                    public void Ez() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0132a
                    public void EA() {
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0132a
                    public void a(com.baidu.live.w.b bVar) {
                        if (AlaMasterLiveRoomOpearator.this.btG().fFC != null && bVar != null) {
                            if (bVar.bitmap == null) {
                                AlaMasterLiveRoomOpearator.this.btG().fFC.onStickerItemSelected(null);
                                return;
                            }
                            Sticker sticker = new Sticker();
                            sticker.setBitmap(bVar.bitmap);
                            AlaMasterLiveRoomOpearator.this.btG().fFC.onStickerItemSelected(sticker);
                        }
                    }

                    @Override // com.baidu.live.w.a.InterfaceC0132a
                    public void D(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.btG().fFC != null) {
                            AlaMasterLiveRoomOpearator.this.btG().fFC.onStickerItemSelected(obj);
                        }
                    }
                });
            }
        }
    }

    private com.baidu.live.w.a ev(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).ar(context);
        }
        return null;
    }

    private void bxA() {
        if (this.fJx == null) {
            this.fJx = new b(btG().pageContext, btG().fFd);
        }
    }

    private void bxB() {
        if (this.fvV == null) {
            this.fvV = new com.baidu.tieba.ala.liveroom.l.a(btG().pageContext, true, this.fKH);
            this.fvV.c(this.fJB, (n) null);
            this.fvV.a(this.fwA);
        }
        if (this.fJs == null) {
            this.fJs = new com.baidu.tieba.ala.liveroom.l.a(btG().pageContext, true, null);
            this.fJs.a(this.fJC, null, a.g.ala_live_room_host_header_stub);
            this.fJs.bwv();
        }
    }

    protected void bsA() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bzf = btG().fFc.bzf();
        boolean z2 = com.baidu.live.v.a.Eo().aQp.atr;
        if (bzf == null || bzf.aqI) {
            z = z2;
        }
        if (z && this.fwK == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, btG().pageContext)) != null) {
            this.fwK = (com.baidu.live.h.a) runTask.getData();
            if (this.fwK != null) {
                this.fwK.setIsHost(true);
                this.fwK.ck(1);
                View view = this.fwK.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(btG().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(btG().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.fJC.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(n nVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.fwb == null) {
            this.fwb = new com.baidu.tieba.ala.liveroom.activeview.b(btG().pageContext);
        }
        this.fwb.setOtherParams(this.otherParams);
        this.fwb.b(nVar, false);
        this.fwb.setHost(true);
        this.fwb.a(1, btG().fFd, qm(1));
        this.fwb.a(2, btG().fFd, qm(2));
        this.fwb.jQ(this.fxE);
        this.fwb.setVisible(this.fJq ? 8 : 0);
        this.fwb.a(this.fvd);
        if (this.fvd != null) {
            if (this.fwb != null) {
                alaActiveRootView2 = this.fwb.qh(1);
                alaActiveRootView = this.fwb.qh(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.fvd.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.fvd.a(alaActiveRootView);
            }
        }
    }

    private void u(n nVar) {
        CustomResponsedMessage runTask;
        if (this.fxt == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, btG().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.fxt = (com.baidu.live.q.a) runTask.getData();
            if (this.fxt != null) {
                this.fxt.a(btG().fFd, kD(false));
            }
        }
        if (this.fxt != null) {
            this.fxE = this.fxt.m(nVar);
            this.fxt.setCanVisible(!this.fJq);
        }
    }

    protected void bxC() {
        CustomResponsedMessage runTask;
        if (btG() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, btG().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.fxr = (com.baidu.live.i.a) runTask.getData();
            this.fxr.a(btG().fFd, bxD());
            if (btG().fFc != null) {
                this.fxr.a(btG().fFc.DN());
            }
            this.fxr.setCanVisible(true);
            this.fxr.bs(false);
            this.fxr.a(btG().fFc.bnr());
        }
    }

    private void bsJ() {
        this.fKq = new com.baidu.tieba.ala.liveroom.n.c(btG().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bxD() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(btG().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.fxh != null && this.fxh.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fJv != null && this.fJv.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams qm(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(btG().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.fJA != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(btG().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
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
        layoutParams.rightMargin = btG().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.fKm != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.fKm.aS(true) + btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.fJA != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void brT() {
        if (this.fJu == null) {
            this.fJu = new com.baidu.tieba.ala.liveroom.b.a(btG().pageContext, true);
        }
    }

    private void bxE() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = btG().pageContext.getPageActivity();
            this.fyA = new ImageView(pageActivity);
            this.fyA.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.fyA.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.fyA.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            btG().rootView.addView(this.fyA, layoutParams);
            this.fyA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bxQ();
                }
            });
            this.fyA.setVisibility(8);
        }
    }

    private void bsH() {
        this.fxg = new com.baidu.tieba.ala.liveroom.f.a(btG().pageContext);
    }

    private void bsV() {
        if (this.fxh == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, btG().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.fxh = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.fxh.setHost(true);
        this.fxh.setOtherParams(this.otherParams);
        if (btG().fFc.DN() != null && btG().fFc.DN().aqe != null && btG().fFc.DN().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.fxh.a(btG().fFd, layoutParams, btG().fFc.DN());
        }
    }

    private void bxF() {
        CustomResponsedMessage runTask;
        if (this.fKo == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, btG().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.fKo = (com.baidu.live.b.a) runTask.getData();
            if (this.fKo != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = btG().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fKo.a(btG().fFd, layoutParams);
            }
        }
        if (this.fKo != null) {
            this.fKo.a(btG().fFc.DN());
        }
    }

    private void bxG() {
        CustomResponsedMessage runTask;
        if (this.fKp == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, btG().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.fKp = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fKm != null) {
            this.fKm.onRtcConnected(i);
        }
    }

    private void registerListener() {
        btG().pageContext.registerListener(this.fxN);
        btG().pageContext.registerListener(this.fKx);
        btG().pageContext.registerListener(this.fxP);
        btG().pageContext.registerListener(this.fxQ);
        btG().pageContext.registerListener(this.fKE);
        btG().pageContext.registerListener(this.aYw);
        btG().pageContext.registerListener(this.ftQ);
        btG().pageContext.registerListener(this.fKF);
        btG().pageContext.registerListener(this.fxO);
        btG().pageContext.registerListener(this.fyn);
        btG().pageContext.registerListener(this.fKO);
        btG().pageContext.registerListener(this.fKP);
        btG().pageContext.registerListener(this.fKQ);
        btG().pageContext.registerListener(this.fxV);
        btG().pageContext.registerListener(this.fKB);
        btG().pageContext.registerListener(this.fKC);
        btG().pageContext.registerListener(this.fKy);
        btG().pageContext.registerListener(this.aPX);
        btG().pageContext.registerListener(this.aPY);
        btG().pageContext.registerListener(this.fKz);
        btG().pageContext.registerListener(this.fxX);
        btG().pageContext.registerListener(this.fxW);
        btG().pageContext.registerListener(this.fxY);
        btG().pageContext.registerListener(this.fKA);
        btG().pageContext.registerListener(this.fKz);
        btG().pageContext.registerListener(this.aNj);
        btG().pageContext.registerListener(this.aLb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kE(boolean z) {
        if (aq.c(com.baidu.live.v.a.Eo().aRw)) {
            btG().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (btG().fFF.tU() == null || ListUtils.isEmpty(btG().fFF.tU().anJ)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                btG().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.fKr) {
                this.fKs = BdUniqueId.gen();
                btG().fFF.a(this.fKs);
                this.fKr = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(btG().pageContext.getPageActivity(), btG().rootView);
            qK(8);
            if (btG().fFC.hasAdvancedBeauty() && this.fKj != null) {
                if (!this.fKt || this.fJr.getVisibility() == 0) {
                    this.fKj.a(btG().fFC.getVideoConfig());
                }
                this.fKj.a(btG().fFC.getVideoConfig(), this.fKk);
                if (!this.fKk) {
                    this.fKk = true;
                }
            }
            if (z && this.fwW != null) {
                this.fwW.Bf().getView().setVisibility(4);
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
    public void bxH() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(btG().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.btG().f((short) 1);
            }
        });
        bdAlertDialog.create(btG().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxI() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(btG().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.btG().f((short) 1);
            }
        });
        bdAlertDialog.create(btG().pageContext).show();
    }

    private void AN(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.btG().f((short) 1);
            }
        });
        bdAlertDialog.create(btG().pageContext).show();
    }

    public void bxJ() {
        bsA();
        com.baidu.live.data.h bnr = btG().fFc.bnr();
        int i = 5;
        if (bnr != null) {
            i = (int) bnr.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.btG().fFc.DN() != null && AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.btG().fFc.dF(AlaMasterLiveRoomOpearator.this.btG().fFc.DN().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bnr != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fze.fFI.b(bnr);
                return;
            }
            if (this.fvU == null) {
                this.fvU = new com.baidu.tieba.ala.liveroom.audiencelist.c(btG().pageContext, this.fKH, true);
            }
            if (this.fKh) {
                this.fKh = false;
                this.fvU.a(String.valueOf(btG().fFc.DN().mLiveInfo.group_id), String.valueOf(btG().fFc.DN().mLiveInfo.live_id), String.valueOf(btG().fFc.DN().aqe.userId), btG().fFc.DN());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.fwK != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.fvU.c(this.fJC, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.fvU.e(bnr);
            this.fvZ.setVisible(0);
            this.fvZ.dk(bnr.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQD() {
        if (btG().fFc != null) {
            if (this.fwL == null) {
                this.fwL = new com.baidu.tieba.ala.liveroom.share.c(btG().pageContext);
            }
            this.fwL.c(btG().fFc.DN(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (btG().fFc != null && btG().fFc.DN() != null && btG().fFc.DN().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", btG().fFc.DN().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", btG().fFc.DN().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", btG().fFc.DN().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (btG().fFc != null && btG().fFc.DN() != null && btG().fFc.DN().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", btG().fFc.DN().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", btG().fFc.DN().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", btG().fFc.DN().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bxL() {
        return this.fJp;
    }

    private void kF(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(fJo, z);
        this.fJp = z;
    }

    private void bxM() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btG().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.btG().pageContext).byN();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(btG().pageContext).show();
    }

    private void bxN() {
        if (this.fIY && btG().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            btG().fFH.Ff();
        }
        btG().fFG.prepareTime = System.currentTimeMillis() - btG().fFG.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (btG().fFc != null && btG().fFc.DN() != null && btG().fFc.DN().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", btG().fFc.DN().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", btG().fFc.DN().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", btG().fFG.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fJr != null && this.fJr.getView().getParent() != null) {
            this.fJr.setVisibility(8);
            btG().rootView.removeView(this.fJr.getView());
            this.fJr.release();
        }
        if (this.fKj != null) {
            this.fKj.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (btG().fFd.indexOfChild(this.fJz) < 0) {
            btG().fFd.addView(this.fJz, layoutParams);
        }
        this.fJz.qZ(1000);
    }

    private void btg() {
        if (btG().bvj() == 1) {
            btG().fFC.startRecord();
        }
    }

    private void AO(String str) {
        AP(str);
    }

    private void AP(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) btG().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String ab(Intent intent) {
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

    private void ac(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.fJr != null) {
            this.fJr.AD(fromJson.getSmallurl());
        }
    }

    private boolean bxO() {
        return com.baidu.live.c.tH().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxP() {
        com.baidu.live.c.tH().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.fze.fFC.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxQ() {
        int i = a.i.live_close_confirm;
        if (this.fKm != null && this.fKm.btL()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.fKm != null && this.fKm.btK()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(btG().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.btG().fFc.DN() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.btG().fFc.DN(), 0, AlaMasterLiveRoomOpearator.this.btG().fFc.bzp() != 1 ? AlaMasterLiveRoomOpearator.this.btG().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(btG().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(n nVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (nVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = nVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = nVar.aqe;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                btG().fFc.di(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.fKf) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = btG().fFG;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = btG().fFC.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.fKb;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.fKc;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.fJX;
            if (this.fJY != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.fJZ - this.fKa) / this.fJY) * 100.0f;
            }
            Intent intent = new Intent(btG().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (btG().fFc != null && btG().fFc.DN() != null && btG().fFc.DN().aqe != null) {
                String str3 = btG().fFc.DN().aqe.nickName;
                String str4 = btG().fFc.DN().aqe.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            n DN = btG().fFc.DN();
            if (DN != null && DN.aqe != null && !TextUtils.isEmpty(DN.aqe.portrait)) {
                intent.putExtra("host_portrait", DN.aqe.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.fKd = intent;
                this.fKe = s;
                btG().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bxR() {
        if (this.fKd != null) {
            a(this.fKd, this.fKe);
            this.fKd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.fKf = true;
        if (this.fKm != null) {
            this.fKm.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.ftF);
            btG().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        btG().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxS() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fze.fFI != null && this.fze.fFI.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.fKm != null && this.fKm.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (btG().fFE.byz()) {
                bxQ();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.fJA != null) {
                this.fJA.setVisibility(4);
                return;
            }
            return;
        }
        if (this.fJA != null) {
            this.fJA.a(i, z, i2, z2);
        }
        if (this.fze != null && this.fze.fFc != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.cuh != i3) {
                this.cuh = i3;
                if (this.fJy == null) {
                    this.fJy = new com.baidu.tieba.ala.liveroom.tippop.a(this.fze.pageContext, null);
                }
                switch (this.cuh) {
                    case 0:
                        this.fJy.a(this.fze.rootView, this.fze.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.fJy.a(this.fze.rootView, this.fze.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.fJy.a(this.fze.rootView, this.fze.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.fze.fFc.j(this.fze.fFc.DN().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.bxS();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.btG().fFc.DN(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x0527, code lost:
        Au(r6);
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
            if (this.fJw != null) {
                this.fJw.z(aVar);
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
                            if (this.fKm != null) {
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
            if (this.fKm != null) {
                this.fKm.dJ(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bxS();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.btG().fFc.DN(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (btG().fFc.DN() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            btG().fFc.DN().aqx.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            btG().fFc.DN().aqx.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        btG().fFc.DN().aqx.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (btG().fFc.DN() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (btG().fFc.DN() != null && btG().fFc.DN().aqe != null && btG().fFc.DN().aqe.userId == optLong2) {
                        btG().fFc.DN().aqe.isUegBlock = 1;
                        bsg();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (btG().fFc.DN() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (btG().fFc.DN() != null && btG().fFc.DN().aqe != null && btG().fFc.DN().aqe.userId == optLong3) {
                        btG().fFc.DN().aqe.isUegBlock = 0;
                        bsg();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.fJR != null) {
                    this.fJR.B(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.fJx.aD(optString4, optInt2);
                    }
                    if (this.fvZ.getCount() > 20) {
                        this.fvZ.dk(this.fvZ.getCount() + 1);
                    } else if (this.fvU != null) {
                        com.baidu.live.data.a Cf = aVar.Cf();
                        com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                        gVar.aqf = new AlaLocationData();
                        gVar.aqg = new AlaRelationData();
                        gVar.aqe = new AlaLiveUserInfoData();
                        gVar.aqe.userId = JavaTypesHelper.toLong(Cf.userId, 0L);
                        gVar.aqe.userName = Cf.userName;
                        gVar.aqe.portrait = Cf.portrait;
                        if (this.fvU.c(gVar)) {
                            this.fvZ.dk(this.fvZ.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY) == 1001 && btG().fFc.DN() != null && btG().fFc.DN().mLiveInfo != null) {
                    String str5 = btG().fFc.DN().mLiveInfo.feed_id;
                    long j4 = btG().fFc.DN().mLiveInfo.live_id;
                    long optLong4 = jSONObject2.optLong("id");
                    if (!m.h(j4, optLong4)) {
                        com.baidu.live.utils.o.g(str5, j4);
                        m.i(j4, optLong4);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && btG() != null && btG().fFc != null && btG().fFc.DN() != null && btG().fFc.DN().aqx != null && btG().fFc.DN().aqx.userId == jSONObject2.optLong("user_id")) {
                    btG().fFc.bze();
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
            com.baidu.live.data.a Cf2 = aVar.Cf();
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
                if (btG().fFc != null && btG().fFc.DN() != null && btG().fFc.DN().mLiveInfo != null) {
                    j5 = btG().fFc.DN().mLiveInfo.live_id;
                    j6 = btG().fFc.DN().mLiveInfo.group_id;
                    j7 = btG().fFc.DN().aqe.userId;
                    str7 = btG().fFc.DN().mLiveInfo.appId;
                    if (btG().fFc.DN().mLiveSdkInfo.mCastIds != null) {
                        String str8 = btG().fFc.DN().mLiveSdkInfo.mCastIds.aqq;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = btG().fFc.DN().mLiveSdkInfo.mCastIds.aqr;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || btG().bvj() != 2) {
                            if (TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    u.b(optString11, Cf2.userId, Cf2.portrait, Cf2.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString10, "", "", aVar.getMsgId());
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString11);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.v.d.Ev().eQ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                u.b(optString5, Integer.parseInt(optString6), optString7, optString8, Cf2.userId, Cf2.portrait, Cf2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3, aVar.getMsgId());
                            }
                        }
                        Au(optString5);
                        com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
                        dVar.fEA = optLong6;
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
                u.b(optString5, Integer.parseInt(optString6), optString7, optString8, Cf2.userId, Cf2.portrait, Cf2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3, aVar.getMsgId());
                Au(optString5);
                com.baidu.tieba.ala.liveroom.e.d dVar2 = new com.baidu.tieba.ala.liveroom.e.d();
                dVar2.fEA = optLong6;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void Au(String str) {
        if (this.fwb != null) {
            this.fwb.Au(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK(int i) {
        View findViewById = btG().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.fwb != null) {
            this.fwb.bp(2, i);
        }
    }

    private void bxT() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.btG().fFC != null && AlaMasterLiveRoomOpearator.this.btG().fFC.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.btG().fFC.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.btG().fFC.startRecord();
                }
            }
        });
    }

    private void bxU() {
        if (btG().fFC != null && btG().fFC.getPreview() != null) {
            btG().fFC.getPreview().setVisibility(8);
            btG().fFC.stopRecord();
        }
    }

    public void bxV() {
        this.fFz = btG().fFc.bzq();
        if (this.fJr != null) {
            this.fJr.kq(this.fFz);
        }
    }

    public void bvh() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bxW();
        } else if (this.fJr != null) {
            this.fJr.bvh();
        }
    }

    public void onDestroy() {
        if (this.fJW != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.fJW);
        }
        this.fJW = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fKj != null) {
            this.fKj.ko(true);
        }
        this.fKj = null;
        if (this.fJr != null) {
            this.fJr.destroy();
            btG().rootView.removeView(this.fJr.getView());
            this.fJr.release();
            this.fJr = null;
        }
        if (this.fKm != null) {
            this.fKm.onDestroy();
        }
        if (this.fwL != null) {
            this.fwL.onDestroy();
        }
        if (this.fwN != null) {
            this.fwN.onDestroy();
        }
        if (this.fvV != null) {
            this.fvV.onDestroy();
            this.fvV = null;
        }
        if (this.fJs != null) {
            this.fJs.onDestroy();
        }
        if (this.fxj != null) {
            this.fxj.onDestroy();
            this.fxj = null;
        }
        if (this.fJz != null) {
            this.fJz.stopCountDown();
        }
        if (this.fJv != null) {
            this.fJv.onDestroy();
        }
        if (this.fJx != null) {
            this.fJx.onDestroy();
        }
        if (this.fJR != null) {
            this.fJR.onDestroy();
            this.fJR = null;
        }
        if (this.fwY != null) {
            this.fwY.onDestroy();
            this.fwY = null;
        }
        u.xf();
        com.baidu.live.entereffect.a.vo().release();
        if (this.fwZ != null) {
            this.fwZ.onDestroy();
            this.fwZ = null;
        }
        if (this.fJy != null) {
            this.fJy.onDestroy();
        }
        if (this.fJw != null) {
            this.fJw.bBf();
            this.fJw.release();
        }
        if (this.fvZ != null) {
            this.fvZ = null;
        }
        if (this.fwb != null) {
            this.fwb.release();
        }
        if (this.fJt != null) {
            this.fJt.onDestroy();
        }
        if (this.fJw != null) {
            this.fJw.onDestroy();
        }
        if (this.fwX != null) {
            this.fwX.release();
        }
        if (this.fxg != null) {
            this.fxg.release();
        }
        if (this.fxh != null) {
            this.fxh.onDestroy();
        }
        if (this.fJT != null) {
            this.fJT.onDestroy();
        }
        if (this.fxt != null) {
            this.fxt.release();
        }
        if (this.fKo != null) {
            this.fKo.onDestory();
        }
        if (this.fKp != null) {
            this.fKp.release();
        }
        if (this.fxr != null) {
            this.fxr.onDestroy();
        }
        if (this.fKq != null) {
            this.fKq.release();
        }
        MessageManager.getInstance().unRegisterListener(this.fyn);
        MessageManager.getInstance().unRegisterListener(this.fKO);
        MessageManager.getInstance().unRegisterListener(this.fKP);
        MessageManager.getInstance().unRegisterListener(this.fKQ);
        MessageManager.getInstance().unRegisterListener(this.fxV);
        MessageManager.getInstance().unRegisterListener(this.fKB);
        MessageManager.getInstance().unRegisterListener(this.fKC);
        MessageManager.getInstance().unRegisterListener(this.fKy);
        MessageManager.getInstance().unRegisterListener(this.aPX);
        MessageManager.getInstance().unRegisterListener(this.aPY);
        MessageManager.getInstance().unRegisterListener(this.fKz);
        MessageManager.getInstance().unRegisterListener(this.fxX);
        MessageManager.getInstance().unRegisterListener(this.fxW);
        MessageManager.getInstance().unRegisterListener(this.fxY);
        MessageManager.getInstance().unRegisterListener(this.fKA);
        MessageManager.getInstance().unRegisterListener(this.fKz);
        MessageManager.getInstance().unRegisterListener(this.aNj);
        MessageManager.getInstance().unRegisterListener(this.aLb);
        m.Gh();
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.fze.fFI.a(this.fKS, this.fze.fFD, this.fJB, alaLivePersonData);
        }
    }

    private void bxW() {
        if (this.fJU != null) {
            this.fze.fFG.startTime = System.currentTimeMillis();
            this.fze.fFG.liveTotalTime = System.currentTimeMillis();
            this.fze.fFG.sampleMemAndCPU();
            this.fze.fFE.a((short) 4, this.fJU);
        }
    }

    private ViewGroup.LayoutParams bxX() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = btG().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
