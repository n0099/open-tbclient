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
import com.baidu.live.p.d;
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
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
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
    private static final String gUu;
    private boolean bjT;
    private PendantParentView bot;
    private String gBV;
    private c gDQ;
    private com.baidu.tieba.ala.liveroom.p.a gDR;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gDU;
    private com.baidu.tieba.ala.liveroom.activeview.b gDW;
    private com.baidu.live.g.a gDr;
    private com.baidu.live.h.a gEG;
    private com.baidu.tieba.ala.liveroom.share.c gEH;
    private com.baidu.tieba.ala.liveroom.s.b gEI;
    private m gET;
    private k gEU;
    private com.baidu.live.im.b.a gEV;
    private x gEW;
    private v gEX;
    private boolean gFJ;
    protected h gFf;
    protected z gFh;
    protected com.baidu.live.i.a gFo;
    protected com.baidu.live.p.a gFp;
    protected com.baidu.live.p.b gFq;
    private com.baidu.live.u.a gFu;
    private com.baidu.live.af.a gFw;
    private boolean gGB;
    private f gHQ;
    private ImageView gHX;
    private g gHY;
    private com.baidu.tieba.ala.liveroom.v.a gUA;
    private com.baidu.tieba.ala.liveroom.x.a gUB;
    private b gUC;
    private com.baidu.tieba.ala.liveroom.tippop.a gUD;
    private d gUE;
    private com.baidu.live.p.c gUF;
    protected com.baidu.live.j.a gUG;
    private AlaLiveCountDownView gUH;
    private AlaLiveStreamStatusView gUI;
    private RelativeLayout gUJ;
    private RelativeLayout gUK;
    private RelativeLayout gUL;
    private RelativeLayout gUM;
    private FrameLayout gUN;
    private View gUO;
    private boolean gUP;
    private AlaLiveFaceVerifyView gUQ;
    private ImageView gUR;
    private ImageView gUS;
    private ImageView gUT;
    private ImageView gUU;
    private ImageView gUV;
    private ImageView gUW;
    private ImageView gUX;
    private TextView gUY;
    private am gUZ;
    private boolean gUe;
    private boolean gUv;
    private com.baidu.tieba.ala.liveroom.h.d gUx;
    private com.baidu.tieba.ala.liveroom.p.a gUy;
    private com.baidu.tieba.ala.liveroom.b.a gUz;
    private com.baidu.tieba.ala.liveroom.r.a gVA;
    private boolean gVB;
    private BdUniqueId gVC;
    private boolean gVD;
    private View gVE;
    private FrameLayout gVF;
    private com.baidu.live.z.a gVb;
    private com.baidu.tieba.ala.liveroom.master.panel.b gVc;
    private com.baidu.live.y.a gVd;
    private ImageView gVe;
    private e gVf;
    private short gVp;
    private com.baidu.tieba.ala.liveroom.h.b gVu;
    private boolean gVv;
    private com.baidu.tieba.ala.liveroom.challenge.e gVw;
    private com.baidu.live.ae.a gVx;
    private com.baidu.live.a.a gVy;
    private com.baidu.live.a.b gVz;
    private boolean gUw = false;
    private boolean gFE = false;
    private Handler mHandler = new Handler();
    private Handler gVa = new Handler();
    private boolean gVg = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver gVh = null;
    private boolean gVi = false;
    private int gVj = 0;
    private int gVk = 0;
    private int gVl = 0;
    private long gVm = 0;
    private long gVn = 0;
    private volatile boolean isBackground = false;
    private Intent gVo = null;
    private int mOrientation = 1;
    private boolean gPj = false;
    private boolean gVq = false;
    private boolean gVr = true;
    private boolean gHV = false;
    private boolean gVs = true;
    private boolean gVt = true;
    private int dlH = 0;
    private String otherParams = "";
    private int bjW = 0;
    private Runnable gVG = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.gDr != null) {
                AlaMasterLiveRoomOpearator.this.gDr.Es();
            }
        }
    };
    private com.baidu.live.ae.b bxN = new com.baidu.live.ae.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.ae.b
        public boolean Ri() {
            if (AlaMasterLiveRoomOpearator.this.gVw != null) {
                if (AlaMasterLiveRoomOpearator.this.gFp != null) {
                    if (!AlaMasterLiveRoomOpearator.this.gVw.bTW() && !AlaMasterLiveRoomOpearator.this.gVw.bTX() && !AlaMasterLiveRoomOpearator.this.gFp.NP() && !AlaMasterLiveRoomOpearator.this.gFp.CM()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.gVw.bTW() && !AlaMasterLiveRoomOpearator.this.gVw.bTX()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.gFp == null || AlaMasterLiveRoomOpearator.this.gFp.NP() || AlaMasterLiveRoomOpearator.this.gFp.CM()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.ae.b
        public void Rj() {
            if (AlaMasterLiveRoomOpearator.this.gVw != null) {
                AlaMasterLiveRoomOpearator.this.gVw.bTZ();
            }
        }
    };
    private CustomMessageListener bkV = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gHQ.gPt != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gHQ.gPt.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.A(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener bkW = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gHQ.gPt != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gHQ.gPt.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener gGd = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gEI == null) {
                        AlaMasterLiveRoomOpearator.this.gEI = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gEI.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener gGk = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gFo != null) {
                AlaMasterLiveRoomOpearator.this.gFo.Kd();
            }
        }
    };
    private CustomMessageListener gVH = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.r((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gGa = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Ha(str);
            }
        }
    };
    private CustomMessageListener gGb = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.boA();
        }
    };
    private CustomMessageListener gEs = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gEX.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gGh = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener gVI = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gVz != null) {
                u Gm = AlaMasterLiveRoomOpearator.this.bTU().gON.Gm();
                long j = Gm.mLiveInfo.live_id;
                long j2 = Gm.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.gVz.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener gVJ = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bTU().gOO);
            if (AlaMasterLiveRoomOpearator.this.gUx == null || AlaMasterLiveRoomOpearator.this.gUx.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.vq(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gEU != null) {
                AlaMasterLiveRoomOpearator.this.gEU.KP().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gEU.KQ().hide();
            }
        }
    };
    private CustomMessageListener gGj = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.u(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm());
        }
    };
    private CustomMessageListener gGl = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gFh != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) AlaMasterLiveRoomOpearator.this.gFh).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener gVK = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gVA != null) {
                    AlaMasterLiveRoomOpearator.this.gVA.hE(str);
                }
            }
        }
    };
    private CustomMessageListener gVL = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.gVu != null) {
                        if (!data.aDu || AlaMasterLiveRoomOpearator.this.gVC == null || !AlaMasterLiveRoomOpearator.this.gVD) {
                            if (AlaMasterLiveRoomOpearator.this.gVC != null && AlaMasterLiveRoomOpearator.this.gVC == data.aDt) {
                                if (data.aDn != null && data.aDn.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.gVD || AlaMasterLiveRoomOpearator.this.gUx.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.gVu.a(AlaMasterLiveRoomOpearator.this.bTU().gPm.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.gVv = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bTU().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.gVC = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bTU().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.gVu.a(AlaMasterLiveRoomOpearator.this.bTU().gPm.getVideoConfig(), AlaMasterLiveRoomOpearator.this.gVv);
                        if (!AlaMasterLiveRoomOpearator.this.gVv) {
                            AlaMasterLiveRoomOpearator.this.gVv = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gVB) {
                    AlaMasterLiveRoomOpearator.this.bTU().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.gVB = false;
            }
        }
    };
    private CustomMessageListener gVM = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bTU().gPm != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bTU().gPm.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.c.AZ().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bkb = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bjW == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bjW == 6) {
                            AlaMasterLiveRoomOpearator.this.bYB();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bjW = 0;
            }
        }
    };
    private View.OnClickListener gVN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.gUS) {
                    AlaMasterLiveRoomOpearator.this.bYF();
                    AlaMasterLiveRoomOpearator.this.gVc.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.gUR) {
                    if (view == AlaMasterLiveRoomOpearator.this.gUT) {
                        AlaMasterLiveRoomOpearator.this.boA();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.gUU) {
                        if (view != AlaMasterLiveRoomOpearator.this.gUW) {
                            if (view == AlaMasterLiveRoomOpearator.this.gHX) {
                                if (AlaMasterLiveRoomOpearator.this.bYA()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.gVw != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.gFp != null) && AlaMasterLiveRoomOpearator.this.gFp.CM()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.gFp.NP() & (AlaMasterLiveRoomOpearator.this.gFp != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.gVw.bTW()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.gVw.bTX()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.gVw.bTY();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.gUV) {
                                if (AlaMasterLiveRoomOpearator.this.gUB != null) {
                                    al caH = AlaMasterLiveRoomOpearator.this.bTU().gON.caH();
                                    if (caH == null || caH.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(caH.mLiveSdkInfo.mRoomId);
                                        if (caH.mLiveSdkInfo.mCastIds != null) {
                                            str2 = caH.mLiveSdkInfo.mCastIds.aHY;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.gUB.ak("", str, str2);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.gUX) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.gVw.bTW() || AlaMasterLiveRoomOpearator.this.gVw.bTX() || AlaMasterLiveRoomOpearator.this.gFp.NP() || AlaMasterLiveRoomOpearator.this.gFp.CM()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.gVx != null) {
                                    AlaMasterLiveRoomOpearator.this.gVx.Re();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.gVd != null) {
                            AlaMasterLiveRoomOpearator.this.gVd.Pd();
                            AlaMasterLiveRoomOpearator.this.gVd.cs(AlaMasterLiveRoomOpearator.this.bYL());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.gVD = false;
                        AlaMasterLiveRoomOpearator.this.mY(true);
                        AlaMasterLiveRoomOpearator.this.gUY.setVisibility(4);
                        com.baidu.live.c.AZ().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.x.a.OS().blo.aLK == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.x.a.OS().blo.aLJ == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bjT) {
                        AlaMasterLiveRoomOpearator.this.bYB();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bjW = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.bYB();
                }
            }
        }
    };
    private CustomMessageListener gGc = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof am) {
                    AlaMasterLiveRoomOpearator.this.gFE = true;
                    AlaMasterLiveRoomOpearator.this.gUZ = (am) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gEU != null) {
                        AlaMasterLiveRoomOpearator.this.gEU.KP().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gEU != null) {
                        AlaMasterLiveRoomOpearator.this.gEU.KQ().show();
                        AlaMasterLiveRoomOpearator.this.gEU.KQ().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.vq(8);
                }
            }
        }
    };
    private CustomMessageListener gVO = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bTU() != null && AlaMasterLiveRoomOpearator.this.bTU().gPr != null) {
                AlaMasterLiveRoomOpearator.this.bTU().gPr.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener byz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bZs();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bTU().gON.vx(i);
            }
        }
    };
    private CustomMessageListener gCg = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bZl();
        }
    };
    private CustomMessageListener gGn = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.af.c)) {
                if (AlaMasterLiveRoomOpearator.this.gFw == null) {
                    AlaMasterLiveRoomOpearator.this.gFw = new com.baidu.live.af.a(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.gFw.a((com.baidu.live.af.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener gVP = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Nm()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.gVc != null) {
                            AlaMasterLiveRoomOpearator.this.gVc.nf(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.gVc.bZQ();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bTU().gPm.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.gVx != null) {
                        AlaMasterLiveRoomOpearator.this.gVx.setMute(AlaMasterLiveRoomOpearator.this.bTU().gPm.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.gUD != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.gUD.a(AlaMasterLiveRoomOpearator.this.bTU().gPo, AlaMasterLiveRoomOpearator.this.bTU().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bTU().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.gUD.vF(2);
                        AlaMasterLiveRoomOpearator.this.gUD.a(AlaMasterLiveRoomOpearator.this.bTU().gPo, string, 3);
                    }
                }
            }
        }
    };
    private e.a gVQ = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bZy() {
            AlaMasterLiveRoomOpearator.this.vp(a.i.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void bZz() {
            AlaMasterLiveRoomOpearator.this.vp(a.i.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a gVR = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean eL(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void eM(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bTU().bVQ() == 1) {
                AlaMasterLiveRoomOpearator.this.bTU().gPm.stopRecord();
            }
        }
    };
    private IShareCallback gVS = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.gVg && AlaMasterLiveRoomOpearator.this.gVf != null) {
                AlaMasterLiveRoomOpearator.this.gVg = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.gVf);
            }
        }
    };
    private View.OnTouchListener gVT = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bTU().gPr.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bTU().gOO);
            AlaMasterLiveRoomOpearator.this.vq(0);
            if (AlaMasterLiveRoomOpearator.this.gEU != null) {
                AlaMasterLiveRoomOpearator.this.gEU.KP().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.gEU.KQ().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b gVU = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bZA() {
            AlaMasterLiveRoomOpearator.this.bYC();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bZB() {
            AlaMasterLiveRoomOpearator.this.gUe = AlaMasterLiveRoomOpearator.this.gUx.bVI();
            AlaMasterLiveRoomOpearator.this.bTU().gPr.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bTU().gPr.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bTU().gPr.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gPg = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bTU().bVQ();
            eVar.title = AlaMasterLiveRoomOpearator.this.gUx.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.gPh = AlaMasterLiveRoomOpearator.this.gUx.bVJ();
            eVar.gPk = AlaMasterLiveRoomOpearator.this.gUe;
            eVar.gPj = AlaMasterLiveRoomOpearator.this.gUx.bVG();
            eVar.gPi = AlaMasterLiveRoomOpearator.this.gUx.bVL();
            eVar.gPl = AlaMasterLiveRoomOpearator.this.gUx.bVH();
            if (eVar.gPl) {
                if (AlaMasterLiveRoomOpearator.this.gUx.bVM()) {
                    AlaMasterLiveRoomOpearator.this.gVg = true;
                    AlaMasterLiveRoomOpearator.this.gVf = eVar;
                    AlaMasterLiveRoomOpearator.this.gUx.bVN();
                } else {
                    AlaMasterLiveRoomOpearator.this.c(eVar);
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
            AlaMasterLiveRoomOpearator.this.bTU().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bTU().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bZC() {
            AlaMasterLiveRoomOpearator.this.gVD = true;
            AlaMasterLiveRoomOpearator.this.mY(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean bZD() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void bZE() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener bgD = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bSc();
            }
        }
    };
    private com.baidu.live.liveroom.g.c gVV = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Nh() {
            if (AlaMasterLiveRoomOpearator.this.gUB != null) {
                AlaMasterLiveRoomOpearator.this.gUB.nr(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ch(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.gVd != null) {
                        AlaMasterLiveRoomOpearator.this.gVd.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.gVd != null) {
                    AlaMasterLiveRoomOpearator.this.gVd.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.gUB != null) {
                    AlaMasterLiveRoomOpearator.this.gUB.nr(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gFh != null) {
                    AlaMasterLiveRoomOpearator.this.gFh.bq(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a gVW = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void abg() {
            if (AlaMasterLiveRoomOpearator.this.gUQ != null && AlaMasterLiveRoomOpearator.this.bTU().gPo.indexOfChild(AlaMasterLiveRoomOpearator.this.gUQ) >= 0) {
                AlaMasterLiveRoomOpearator.this.bTU().gPo.removeView(AlaMasterLiveRoomOpearator.this.gUQ);
                AlaMasterLiveRoomOpearator.this.gUQ.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.gUQ = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gEx = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void o(View view, int i) {
            u Gm;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bZr();
            } else if (i == 14 && (Gm = AlaMasterLiveRoomOpearator.this.bTU().gON.Gm()) != null && Gm.aHD != null && Gm.mLiveInfo != null && Gm.aIf != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity(), Gm.aHD.userName, Long.toString(Gm.aHD.userId), Long.toString(Gm.aHD.charmCount), String.valueOf(Gm.mLiveInfo.group_id), String.valueOf(Gm.mLiveInfo.live_id), true, String.valueOf(Gm.aHD.userId), Long.toString(Gm.aIf.userId), Gm.aIf.userName, Gm.aIf.portrait, AlaMasterLiveRoomOpearator.this.gDU.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Gm.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gDU.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a gVX = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private com.baidu.live.liveroom.middleware.g gVY = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.azI);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        gUu = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(u uVar) {
        if (uVar != null && uVar.mLiveInfo != null && com.baidu.live.x.a.OS().blo != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bTU().pageContext.getPageActivity(), String.valueOf(uVar.mLiveInfo.live_id), String.valueOf(uVar.mLiveInfo.user_id), com.baidu.live.x.a.OS().blo.aLF, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bTU().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bTU().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.x.a.OS().blo.aLd;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bTU().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bTU().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bTU().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSc() {
        int i = bTU().gON.Gm().aHD.isUegBlock;
        int i2 = bTU().gON.Gm().aHD.isBlock;
        String str = bTU().gON.Gm().aHD.userName;
        if (i > 0 || i2 > 0) {
            this.bjT = true;
            this.gEU.a(true, i, i2, str);
            return;
        }
        this.bjT = false;
        this.gEU.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gHQ.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.biW == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.biX);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gHQ.pageContext.getPageActivity());
            bdAlertDialog.setMessage(format);
            bdAlertDialog.setPositiveButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
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
            bdAlertDialog.setNegativeButton(pageActivity.getResources().getString(a.i.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
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
            bdAlertDialog.create(this.gHQ.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bYA() {
        if (this.gVx == null || !this.gVx.Rf()) {
            return true;
        }
        BdUtilHelper.showToast(this.gHQ.pageContext.getPageActivity(), this.gHQ.pageContext.getPageActivity().getResources().getString(a.i.sdk_video_chat_no_pk_tip));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYB() {
        if (this.gEU != null) {
            this.gEU.KQ().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.gVw != null) {
            this.gVw.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYC() {
        if (bTU() != null && bTU().gON != null) {
            bTU().gON.caA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bLO() != null && aVar.bLP() != null) {
            bTU().gON.ep(aVar.bLO().getId(), aVar.bLP().getId());
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
                    AlaMasterLiveRoomOpearator.this.gVi = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.gVi = false;
                }
                if (AlaMasterLiveRoomOpearator.this.gVj == 0) {
                    AlaMasterLiveRoomOpearator.this.gVj = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.gVk == 0) {
                    AlaMasterLiveRoomOpearator.this.gVk = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.gVl = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bTU() != null && bTU().gPp != null) {
            bTU().gPp.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.gHQ = fVar;
        this.gBV = str;
    }

    protected f bTU() {
        return this.gHQ;
    }

    public int a(g gVar) {
        this.gHY = gVar;
        this.gVh = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.gVh, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.gUD == null) {
            this.gUD = new com.baidu.tieba.ala.liveroom.tippop.a(this.gHQ.pageContext, null);
        }
        registerListener();
        this.gDr = new com.baidu.live.g.a();
        bYV();
        bYD();
        bYE();
        Long[] lArr = new Long[1];
        this.gVm = lArr[0] == null ? 0L : lArr[0].longValue();
        this.gVn = lArr[0] != null ? lArr[0].longValue() : 0L;
        bTU().gOO.setOnTouchListener(this.gVT);
        this.gUv = SharedPrefHelper.getInstance().getBoolean(gUu, false);
        this.gUH = new AlaLiveCountDownView(bTU().pageContext.getPageActivity());
        this.gUH.setCount(3);
        this.gUH.setTextColor(bTU().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.gUH.setTextSize(bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.gUH.setTypeface(Typeface.DEFAULT_BOLD);
        this.gUH.setIncludeFontPadding(false);
        this.gUH.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void bZF() {
                if (AlaMasterLiveRoomOpearator.this.bTU().gOO != null) {
                    AlaMasterLiveRoomOpearator.this.bTU().gOO.removeView(AlaMasterLiveRoomOpearator.this.gUH);
                }
            }
        });
        return 1;
    }

    private void bYD() {
        CustomResponsedMessage runTask;
        if (this.gUG == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.j.a.class, bTU().pageContext)) != null && runTask.getData() != null) {
            this.gUG = (com.baidu.live.j.a) runTask.getData();
            this.gUG.c(bTU().pageContext);
        }
    }

    private void bYE() {
        View rootLayout;
        if (this.gUG != null && this.gUN != null && (rootLayout = this.gUG.ca(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.gUN.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYF() {
        if (this.gVc == null) {
            this.gVc = new com.baidu.tieba.ala.liveroom.master.panel.b(bTU().pageContext.getPageActivity(), bTU().bVQ() == 2);
            this.gVc.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void na(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bTU().gPm.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nb(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bTU().gPm.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nc(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bTU().gPm.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bZq();
                    if (AlaMasterLiveRoomOpearator.this.gUD != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.gUD.a(AlaMasterLiveRoomOpearator.this.bTU().gPo, AlaMasterLiveRoomOpearator.this.bTU().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.gUD.a(AlaMasterLiveRoomOpearator.this.bTU().gPo, AlaMasterLiveRoomOpearator.this.bTU().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nd(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bZG() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bTU().gON != null && AlaMasterLiveRoomOpearator.this.bTU().gON.Gm() != null && AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.gVc != null) {
                        AlaMasterLiveRoomOpearator.this.gVc.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.a(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bZH() {
                    if (AlaMasterLiveRoomOpearator.this.gVc != null) {
                        AlaMasterLiveRoomOpearator.this.gVc.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.h(AlaMasterLiveRoomOpearator.this.bTU().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bZI() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bTU() != null && AlaMasterLiveRoomOpearator.this.bTU().gON != null && AlaMasterLiveRoomOpearator.this.bTU().gON.Gm() != null && AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(AlaMasterLiveRoomOpearator.this.bTU().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.gVc != null) {
                            AlaMasterLiveRoomOpearator.this.gVc.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bZJ() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bTU() == null || AlaMasterLiveRoomOpearator.this.bTU().gON == null || AlaMasterLiveRoomOpearator.this.bTU().gON.Gm() == null || AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bTU() != null && AlaMasterLiveRoomOpearator.this.bTU().gON != null && AlaMasterLiveRoomOpearator.this.bTU().gON.Gm() != null && AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.gVc != null) {
                                        AlaMasterLiveRoomOpearator.this.gVc.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(AlaMasterLiveRoomOpearator.this.gHQ.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.gVc != null) {
                        AlaMasterLiveRoomOpearator.this.gVc.dismiss();
                    }
                }
            });
        }
        bYG();
    }

    private void bYG() {
        if (this.gVc != null) {
            boolean isBackCamera = bTU().gPm.isBackCamera();
            this.gVc.ne(bTU().gPm.isBackCamera());
            this.gVc.N(bTU().gPm.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bTU().gPm.isPushMirror();
            if (this.gVr) {
                isPushMirror = bZp() || isPushMirror;
                this.gVr = false;
            }
            this.gVc.O(isPushMirror, isBackCamera ? false : true);
            this.gVc.nf(bTU().gPm.isMute());
            this.gVc.bZQ();
        }
    }

    public void bYH() {
        if (this.gHY != null) {
            if (this.gHY.gPu == null || this.gHY.gPu.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.gUO == null) {
                        this.gUO = this.gHQ.gPt.MJ();
                        this.gHQ.gPo.addView(this.gUO, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.gUx == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bTU().gON != null && bTU().gON.Gm() != null && bTU().gON.Gm().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bTU().gON.Gm().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bTU().gON.Gm().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.gUx = new com.baidu.tieba.ala.liveroom.h.d(bTU().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bTU().gPr.prepareTime = System.currentTimeMillis();
                    bTU().gPo.addView(this.gUx.getView(), layoutParams);
                    this.gUx.a(this.gVS);
                }
                this.gUx.mG(this.gPj);
                this.gUx.a(this.gVU);
                this.gUx.a(this.gVQ);
                this.gUx.a(bTU().gPm, bTU().bVQ());
                this.gUx.a(this.gUG);
                return;
            }
            this.gUe = this.gHY.gPu.mLiveInfo.screen_direction == 2;
            if (this.gHY.gPu.mLiveInfo.isAudioOnPrivate == 1) {
                bTU().gPm.setMute(true);
                if (this.gVx != null) {
                    this.gVx.setMute(bTU().gPm.isMute());
                }
                if (this.gUD == null) {
                    this.gUD = new com.baidu.tieba.ala.liveroom.tippop.a(this.gHQ.pageContext, null);
                }
                if (!this.gUD.vE(2)) {
                    this.gUD.a(bTU().gPo, bTU().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.gPg = true;
            eVar.forumId = String.valueOf(this.gHY.gPu.mLiveInfo.forum_id);
            eVar.forumName = this.gHY.gPu.mLiveInfo.forum_name;
            eVar.liveType = this.gHY.gPu.mLiveInfo.live_type;
            eVar.title = this.gHY.gPu.mLiveInfo.getLiveTitle();
            eVar.clarity = this.gHY.gPu.mLiveInfo.clarity;
            eVar.gameId = this.gHY.gPu.mLiveInfo.game_id;
            eVar.gameName = this.gHY.gPu.mLiveInfo.game_label;
            eVar.gPk = this.gHY.gPu.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bYI() {
        if (this.gVu != null) {
            this.gVu.a(bTU().gPm.getVideoConfig(), false);
        }
        if (this.gUx != null) {
            this.gUx.mF(true);
        }
        if (bTU().gPm.hasBeauty() >= 0) {
            bTU().gPm.setBeauty(com.baidu.live.c.AZ().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bTU().gPt.J(this.gHQ.gPm);
        } else if (this.gUx != null) {
            this.gUx.mF(true);
        }
        bYU();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.gUO != null && this.gUO.getParent() != null) {
                ((ViewGroup) this.gUO.getParent()).removeView(this.gUO);
                this.gUO = null;
            }
            bTU().gOO.setVisibility(0);
            this.gHQ.gPt.a(bTU().gOO);
        } else {
            bZb();
            bZo();
            if (this.gVF != null) {
                this.gVF.setVisibility(0);
            }
            this.gUB = new com.baidu.tieba.ala.liveroom.x.a(bTU().pageContext, this.gVR);
            this.gUB.d(bTU().gOO, true);
            this.gUB.nr(true);
            if (this.gEU != null && this.gEU.KP() != null) {
                this.gEU.KP().setNeedTopAlphaShade(true);
            }
        }
        bTU().gPm.setPushMirror(bZp());
    }

    public void b(al alVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gHQ.gPt.m(bTU().gON.Gm());
        }
        if (!bTU().gPm.isBackground() && bTU().gON.Gm() != null && bTU().gON.Gm().mLiveInfo != null) {
            int startPush = bTU().gPm.startPush(bTU().gON.Gm().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gHQ.gPt.MK();
            }
            if (startPush != 0 && bTU().gPr != null) {
                bTU().gPr.errCode = 4;
                bTU().gPr.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (alVar != null && !alVar.Ef() && !bZm()) {
                mZ(true);
                bZn();
            }
            if (this.gDR != null) {
                this.gDR.z(bTU().gON.Gm());
            }
            if (this.gEG != null) {
                this.gEG.a(bTU().gON.Gm());
            }
            if (this.gUG != null) {
                this.gUG.f(bTU().gON.Gm());
                this.gUG.hz(this.otherParams);
            }
            if (this.gUz != null && bTU() != null && bTU().gON != null) {
                if (this.gUz.aw(bTU().gPo)) {
                    this.gUz.t(bTU().gON.Gm());
                } else {
                    this.gUz.c(bTU().gPo, bTU().gON.Gm());
                }
            }
            if (this.gDR != null) {
                this.gDR.mT(true);
            }
            if (this.gUy != null) {
                this.gUy.z(bTU().gON.Gm());
            }
            if (alVar == null || alVar.aHD == null) {
                z = com.baidu.live.c.AZ().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = alVar.aHD.canUseChallenge;
                com.baidu.live.c.AZ().putBoolean("ala_master_can_use_challenge", z);
            }
            bSV();
            bZc();
            bYN();
            mX(z);
            bRM();
            bZd();
            bZh();
            A(bTU().gON.Gm());
            h(bTU().gON.Gm());
            bZi();
            bZj();
            bZg();
            bSU();
            bSI();
            bSQ();
            bSR();
            bZa();
            B(bTU().gON.Gm());
            bSJ();
            if (this.gET != null) {
                this.gET.i(bTU().gON.Gm());
            }
            if (this.gEU != null) {
                if (bTU().gON.Gm() != null && bTU().gON.Gm().aIt != null && bTU().gON.Gm().aIt.DA()) {
                    z2 = true;
                }
                this.gEU.b(String.valueOf(bTU().gON.Gm().mLiveInfo.group_id), String.valueOf(bTU().gON.Gm().mLiveInfo.last_msg_id), String.valueOf(bTU().gON.Gm().aHD.userId), String.valueOf(bTU().gON.Gm().mLiveInfo.live_id), bTU().gON.Gm().aHD.appId, z2);
            }
            if (this.gEV != null) {
                this.gEV.a(bTU().gON.Gm(), true);
            }
            bYJ();
            this.mHandler.post(this.gVG);
        }
    }

    private void bRM() {
        if (this.bot == null) {
            this.bot = new PendantParentView(bTU().pageContext.getPageActivity(), this.gGB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bTU().gOO.addView(this.bot, layoutParams);
            this.bot.setDefaultItemMargin(bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bot.setPadding(bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bTy();
        }
    }

    private void bTy() {
        if (this.bot != null) {
            int dimensionPixelSize = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278);
            int dimensionPixelSize2 = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bot.getLayoutParams();
            if (this.gGB) {
                this.bot.setPosition(0, 0, this.gVw.bTE(), dimensionPixelSize2);
            } else {
                this.bot.setPosition(dimensionPixelSize, 0, bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278), dimensionPixelSize2);
            }
            this.bot.setLayoutParams(layoutParams);
            this.bot.setModel(this.gGB ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bTz() {
        if (this.gEU != null && this.gEU.KP() != null && this.gEU.KP().getView() != null) {
            if (this.gGB && !this.gUw && bTU().gOO != null && bTU().gOO.getHeight() > 0) {
                int bi = this.gVw != null ? this.gVw.bi(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.gEU.KP().getView().getLayoutParams();
                int height = bTU().gOO.getHeight() - bi;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.gEU.KP().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ac.b.i(false, this.gUw);
            if (bTU().gOO.indexOfChild(this.gEU.KP().getView()) != -1 && this.gEU.KP().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gEU.KP().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.gEU.KP().getView().setLayoutParams(layoutParams2);
            }
            this.gEU.KP().KO();
        }
    }

    private void bTA() {
        if (this.gEW != null) {
            if (this.gGB && !this.gUw && bTU().gOO != null && bTU().gOO.getHeight() > 0) {
                this.gEW.dU((bTU().gOO.getHeight() - (this.gVw != null ? com.baidu.live.utils.h.j(bTU().pageContext.getPageActivity(), true) : 0)) + bTU().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height));
            } else {
                this.gEW.dU(com.baidu.live.ac.a.a(bTU().pageContext.getPageActivity(), true, false, this.gUw));
            }
        }
    }

    private void bTB() {
        int i;
        if (this.gEW != null) {
            int h = com.baidu.live.ac.a.h(true, false);
            if (!this.gGB || bTU().gOO == null || bTU().gOO.getHeight() <= 0) {
                i = h;
            } else {
                i = (bTU().gOO.getHeight() - (this.gVw != null ? this.gVw.bi(false) : 0)) + bTU().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
            }
            this.gEW.dV(i);
        }
    }

    private void bTC() {
        if (this.gEV != null && this.gEV.Cl() != null) {
            ViewGroup.LayoutParams layoutParams = this.gEV.Cl().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bTU().pageContext.getResources().getDimensionPixelOffset(this.gGB ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gEV.Cl().setLayoutParams(layoutParams);
            }
        }
    }

    private void bYJ() {
        boolean z = (bTU().gON == null || bTU().gON.caH() == null || bTU().gON.caH().mLiveInfo.videoBBChatData == null || !bTU().gON.caH().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
        if (!z && bTU().gON != null && bTU().gON.Gm() != null && bTU().gON.Gm().mLiveInfo != null && bTU().gON.Gm().mLiveInfo.videoBBChatData != null && bTU().gON.Gm().aIp) {
            z = bTU().gON.Gm().mLiveInfo.videoBBChatData.videoBBChatSwitch;
        }
        if (this.gUX != null) {
            this.gUX.setVisibility(z ? 0 : 8);
        }
        bYK();
    }

    private void bYK() {
        CustomResponsedMessage runTask;
        if (this.gVx == null && (runTask = MessageManager.getInstance().runTask(2913241, com.baidu.live.ae.a.class, bTU().pageContext)) != null && runTask.getData() != null) {
            this.gVx = (com.baidu.live.ae.a) runTask.getData();
        }
        if (this.gVx != null) {
            this.gVx.x((ViewGroup) bTU().rootView.findViewById(a.g.ala_live_video_chat_pendant));
            this.gVx.w(bTU().gPo);
            this.gVx.s(bTU().gON.Gm());
            this.gVx.L(bTU().gPm);
            this.gVx.a(bTU().gPn);
            this.gVx.a(this.bxN);
            if (bTU().gPm != null) {
                this.gVx.setMute(bTU().gPm.isMute());
            }
        }
    }

    private void mX(boolean z) {
        if (this.gVw == null) {
            this.gVw = new com.baidu.tieba.ala.liveroom.challenge.e(bTU());
        }
        this.gVw.a(this.gHX, this.gHY, z);
        this.gVw.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(au auVar, ay ayVar, ay ayVar2) {
                AlaMasterLiveRoomOpearator.this.gGB = true;
                AlaMasterLiveRoomOpearator.this.bTU().gOO.hen = false;
                if (AlaMasterLiveRoomOpearator.this.gVd != null) {
                    AlaMasterLiveRoomOpearator.this.gVd.fd(4);
                    AlaMasterLiveRoomOpearator.this.gVd.cs(true);
                }
                AlaMasterLiveRoomOpearator.this.SQ();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void CS() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gVG);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bTS() {
                AlaMasterLiveRoomOpearator.this.gGB = false;
                AlaMasterLiveRoomOpearator.this.bTU().gOO.hen = false;
                if (AlaMasterLiveRoomOpearator.this.gVd != null) {
                    AlaMasterLiveRoomOpearator.this.gVd.fd(0);
                    AlaMasterLiveRoomOpearator.this.gVd.cs(false);
                }
                AlaMasterLiveRoomOpearator.this.bYM();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bTT() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.gVG);
            }
        });
        this.gVw.K(this.gUe, z);
        this.gVw.j(this.gUe, z, (this.gHY == null || this.gHY.gPu == null || this.gHY.gPu.mChallengeData == null) ? false : true);
    }

    public boolean bYL() {
        return this.gVw != null && this.gVw.bUb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SQ() {
        if (this.gUC != null) {
            this.gUC.setVisible(8);
            this.gUC.setCanVisible(false);
        }
        if (this.gDW != null) {
            this.gDW.mf(true);
        }
        if (this.gUI != null) {
            this.gUI.setCanVisible(false);
            this.gUI.setVisibility(4);
        }
        if (this.gUB != null) {
            this.gUP = this.gUB.ccQ();
            this.gUB.nq(false);
        }
        if (this.gFp != null) {
            this.gFp.setCanVisible(false);
        }
        bTy();
        bTz();
        bTA();
        bTB();
        bTC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYM() {
        if (this.gUC != null) {
            this.gUC.setCanVisible(true);
        }
        if (this.gDW != null) {
            this.gDW.mf(false);
        }
        if (this.gUI != null) {
            this.gUI.setCanVisible(true);
        }
        if (this.gUB != null) {
            this.gUB.nq(this.gUP);
        }
        if (this.gFp != null) {
            this.gFp.setCanVisible(true);
        }
        bTy();
        bTz();
        bTA();
        bTB();
        bTC();
    }

    private void bYN() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
        layoutParams.leftMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (this.gUI == null) {
            this.gUI = new AlaLiveStreamStatusView(bTU().pageContext.getPageActivity());
        }
        this.gUI.setId(a.g.ala_live_room_stream_view);
        this.gUI.setVisibility(4);
        this.gUI.setLayoutParams(layoutParams);
        if (this.gUI.getParent() == null) {
            bTU().gOO.addView(this.gUI, layoutParams);
        }
    }

    public void bYO() {
        if (this.gUx != null && this.gUx.getVisibility() != 8 && bTU().gPm.getPreview() != null) {
            bTU().gPm.stopRecord();
        }
    }

    public void bYP() {
        if (bTU().gPm.getPreview() != null) {
            bTU().gPm.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.gVu != null) {
                this.gVu.mE(false);
            }
            this.gVu = new com.baidu.tieba.ala.liveroom.h.b(bTU().gPo, bTU(), bTU().gPm);
            this.gVu.a(bTU().gPm.getVideoConfig(), false);
        }
        if (this.gUD != null) {
            this.gUD.cbL();
        }
        this.mHandler.post(this.gVG);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.gUw = z;
        if (z) {
            if (this.gVt) {
                this.gVt = false;
                if (this.gEU != null && this.gEU.KP() != null) {
                    this.gEU.KP().getView().setBottom(0);
                }
                if (this.gEU != null && this.gEU.KQ() != null) {
                    this.gEU.KQ().getView().setBottom(0);
                }
            }
            if (this.gEW != null && this.gEW.FR() != null) {
                this.gEW.FR().setVisibility(8);
            }
            if (this.gEU != null && this.gEU.KP() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gEU.KP().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.gEU.KP().getView().setLayoutParams(layoutParams);
            }
            if (this.gEU != null && this.gEU.KQ() != null && this.gEU.KQ().getView() != null && this.gEU.KQ().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gEU.KQ().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gEU.KQ().getView().setLayoutParams(layoutParams2);
                this.gEU.KQ().getView().setVisibility(0);
                this.gEU.KQ().Mr();
            }
            vq(8);
            vo(8);
            if (this.gEX != null && this.gEX.Gl() != null) {
                this.gEX.Gl().setVisibility(8);
            }
        } else {
            if (this.gEW != null && this.gEW.FR() != null) {
                this.gEW.FR().setVisibility(0);
            }
            if (this.gEU != null && this.gEU.KP() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gEU.KP().getView().getLayoutParams();
                layoutParams3.bottomMargin = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gEU.KP().getView().setLayoutParams(layoutParams3);
            }
            if (this.gEU != null && this.gEU.KQ() != null) {
                this.gEU.KQ().hide();
            }
            vq(0);
            vo(0);
            if (this.gEX != null && this.gEX.Gl() != null) {
                this.gEX.Gl().setVisibility(0);
            }
        }
        if (this.gUx != null) {
            this.gUx.M(false, z);
        }
        if (this.gEV != null) {
            this.gEV.Cm();
        }
        if (this.gVd != null) {
            this.gVd.onKeyboardVisibilityChanged(z);
        }
        bTz();
        this.mHandler.post(this.gVG);
    }

    private void vo(int i) {
        if (this.gDR != null) {
            this.gDR.vc(i);
        }
        if (this.gUK != null) {
            this.gUK.setVisibility(i);
        }
        if (this.gEG != null) {
            this.gEG.getView().setVisibility(i);
        }
        if (this.gUA != null) {
            this.gUA.setVisible(i);
        }
        if (this.gUz != null) {
            this.gUz.setVisibility(i);
        }
        if (this.gDW != null) {
            this.gDW.setVisible(i);
        }
        if (this.gFu != null) {
            this.gFu.setCanVisible(i == 0);
        }
        if (this.gFf != null) {
            this.gFf.setVisible(i);
        }
        if (this.gFq != null) {
            this.gFq.setVisible(i);
        }
        if (this.gFo != null) {
            this.gFo.setCanVisible(i == 0);
        }
        if (this.gFp != null) {
            this.gFp.setCanVisible(i == 0 && !this.gGB);
        }
        if (this.gVy != null) {
            this.gVy.setCanVisible(i == 0);
            this.gVy.refreshUI();
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bTU().gPr.errCode = 1;
            vp(a.i.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            vp(a.i.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            vp(a.i.stream_upload_exception);
        } else if (i == -2) {
            Hs(bTU().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bTU().gPm.stopRecord();
        } else if (i == -3 && this.gUx != null) {
            this.gUx.mF(false);
        }
        if (i == -4) {
            if (this.gUx == null || this.gUx.getView().getParent() == null) {
                bTU().f((short) 1);
                return;
            }
            this.gUx.bVK();
            this.gUU.setVisibility(0);
            if (this.gUB != null) {
                this.gUB.nr(true);
            }
            bTU().gOO.setBackgroundColor(bTU().pageContext.getResources().getColor(17170445));
            bZv();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        arx();
        if (i == 12001) {
            if (i2 == -1) {
                Ht(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            boA();
        }
    }

    public void onResume() {
        if (this.gUx != null) {
            this.gUx.onResume();
        }
        if (this.gVg && this.gVf != null) {
            this.gVg = false;
            c(this.gVf);
        }
        if (this.gFh != null) {
            this.gFh.onResume();
        }
    }

    public void g(short s) {
        if (this.gET != null) {
            this.gET.Gx();
        }
        if (this.gEU != null) {
            this.gEU.a(null);
            this.gEU.Cn();
        }
        if (this.gEV != null) {
            this.gEV.Cn();
        }
        if (this.gVw != null) {
            this.gVw.bUa();
        }
    }

    public boolean bYQ() {
        u Gm = bTU().gON.Gm();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gHQ.gPt.l(Gm);
            if (Gm != null && Gm.mLiveInfo.live_status != 1) {
                bZt();
                bTU().pageContext.getPageActivity().finish();
                if (bTU().gON != null && bTU().gON.Gm() != null) {
                    a(Gm, 1, bTU().gON.caQ() != 1 ? bTU().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gEU != null) {
                this.gEU.KP().b(String.valueOf(Gm.mLiveInfo.group_id), String.valueOf(Gm.mLiveInfo.live_id), true, String.valueOf(Gm.aHD.userId));
            }
            if (this.gEV != null) {
                this.gEV.a(Gm);
            }
            if (this.gEG != null) {
                this.gEG.a(bTU().gON.Gm());
            }
            if (this.gDR != null) {
                this.gDR.z(Gm);
            }
            if (Gm != null) {
                if (this.gVw != null) {
                    this.gVw.a(Gm);
                }
                if (this.gEX != null && Gm.mLiveInfo != null) {
                    this.gEX.a(Gm.mLiveInfo, Gm.aHD);
                }
                if (this.gFu != null) {
                    this.gFJ = this.gFu.q(Gm);
                }
                if (this.gDW != null) {
                    this.gDW.mg(this.gFJ);
                    this.gDW.k(Gm);
                    this.gDW.updateView();
                }
                if (this.gFo != null) {
                    this.gFo.a(Gm);
                }
                if (this.gFp != null) {
                    this.gFp.a(Gm);
                }
                if (this.gFq != null) {
                    this.gFq.a(Gm);
                }
                if (Gm.mLiveInfo.live_status != 1) {
                    bZt();
                    bTU().pageContext.getPageActivity().finish();
                    if (bTU().gON != null && bTU().gON.Gm() != null) {
                        a(Gm, 1, bTU().gON.caQ() != 1 ? bTU().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.gUG != null) {
                    this.gUG.j(Gm);
                }
            }
        }
        return false;
    }

    public void bYR() {
        bYG();
    }

    public void bYS() {
        if (this.gVu != null) {
            this.gVu.bVE();
        }
    }

    public void bYT() {
        if (this.gUx != null && this.gUx.getVisibility() != 8) {
            if (bTU().bVQ() == 2) {
                bZv();
            } else {
                bZu();
            }
        }
        if (this.gUx != null && this.gUx.getVisibility() != 8) {
            if (bTU().bVQ() == 1) {
                this.gUx.onResume();
            }
            this.gUx.onRefresh();
        }
        if (this.gUG != null) {
            this.gUG.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.gFE && this.gUZ != null) {
            if (this.gEU != null) {
                this.gEU.KP().getView().setVisibility(0);
            }
            if (this.gEU != null) {
                this.gEU.KQ().show();
                this.gEU.KQ().setEditText(" @" + this.gUZ.getNameShow() + " ");
            }
            vq(8);
            this.gFE = false;
        }
        if (this.gVz != null) {
            this.gVz.resume();
        }
        if (this.gVA != null) {
            this.gVA.resume();
        }
        if (this.gFw != null) {
            this.gFw.resume();
        }
    }

    public void onPause() {
        if (this.gUG != null) {
            this.gUG.onPause();
        }
        if (this.gVz != null) {
            this.gVz.pause();
        }
        if (this.gFh != null) {
            this.gFh.onPause();
        }
        if (this.gVA != null) {
            this.gVA.pause();
        }
        if (this.gFw != null) {
            this.gFw.pause();
        }
    }

    private void bYU() {
        if (bh.c(com.baidu.live.x.a.OS().bqJ)) {
            this.gUU.setVisibility(0);
            this.gUU.setAlpha(0.2f);
        } else if (bTU().gPm.hasBeauty() < 0) {
            this.gUU.setVisibility(8);
        } else {
            this.gUU.setVisibility(0);
        }
    }

    private void bYV() {
        this.gUJ = (RelativeLayout) bTU().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.gUL = (RelativeLayout) bTU().rootView.findViewById(a.g.under_live_view_panel);
        this.gUM = (RelativeLayout) bTU().rootView.findViewById(a.g.over_live_view_panel);
        this.gUN = (FrameLayout) bTU().rootView.findViewById(a.g.goods_parent);
        this.gHQ.gOO.setOnLiveViewScrollListener(this.gVV);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gUL.setVisibility(8);
            this.gUM.setVisibility(8);
            bTU().gOO.removeAllViews();
            return;
        }
        this.gUK = (RelativeLayout) bTU().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gUK.getLayoutParams();
        layoutParams.topMargin = this.gHQ.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.gUK.setLayoutParams(layoutParams);
        if (this.gDU == null) {
            this.gDU = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gHQ.pageContext.getPageActivity(), false);
        }
        this.gDU.a(this.gEx);
        this.gDU.a(this.gUK, a.g.ala_live_room_host_header_stub, 1L);
        this.gDU.setVisible(0);
        bYW();
        this.gUU = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.gUY = (TextView) bTU().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn_num);
        this.gUU.setOnClickListener(this.gVN);
        this.gUW = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.gUW.setOnClickListener(this.gVN);
        if (com.baidu.live.x.a.OS().bqJ != null && com.baidu.live.x.a.OS().bqJ.aNT != null && com.baidu.live.x.a.OS().bqJ.aNT.Ej() && bh.b(com.baidu.live.x.a.OS().bqJ)) {
            this.gUW.setVisibility(0);
        } else {
            this.gUW.setVisibility(8);
        }
        bYU();
        this.gUT = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.gUT.setOnClickListener(this.gVN);
        this.gUR = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.gUR.setOnClickListener(this.gVN);
        this.gHX = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.gHX.setOnClickListener(this.gVN);
        this.gUX = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_vedio_chat);
        this.gUX.setOnClickListener(this.gVN);
        this.gUS = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.gUS.setOnClickListener(this.gVN);
        this.gUV = (ImageView) bTU().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.gUV.setOnClickListener(this.gVN);
        bYZ();
        if (bh.b(com.baidu.live.x.a.OS().bqJ)) {
            this.gVu = new com.baidu.tieba.ala.liveroom.h.b(bTU().gPo, bTU(), bTU().gPm);
        }
        this.gET = new m();
        bYX();
        bYY();
        if (com.baidu.live.c.AZ().getInt("beauty_new_bubble", 1) == 1) {
            this.gUY.setVisibility(0);
        }
    }

    private void bYW() {
        this.gVF = (FrameLayout) View.inflate(bTU().pageContext.getPageActivity(), a.h.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.gVF != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.gVF.setVisibility(8);
            if (this.gVF.getParent() != null && (this.gVF.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.gVF.getParent()).removeView(this.gVF);
            }
            this.gUJ.addView(this.gVF, layoutParams);
            if (this.gVF != null) {
                this.gVF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.gEx.o(AlaMasterLiveRoomOpearator.this.gVF, 8);
                    }
                });
            }
        }
    }

    private void bYX() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bTU().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gEU = (k) runTask.getData();
            this.gEU.setFromMaster(true);
            this.gEU.KP().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bTU().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ac.b.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ac.b.cH(true);
            bTU().gOO.addView(this.gEU.KP().getView(), layoutParams);
            this.gEU.KQ().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bTU().gOO.addView(this.gEU.KQ().getView(), layoutParams2);
            this.gEU.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // com.baidu.live.im.k.a
                public boolean KS() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void KT() {
                }

                @Override // com.baidu.live.im.k.a
                public void hu(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void KU() {
                }

                @Override // com.baidu.live.im.k.a
                public void KV() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean KW() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int KX() {
                    return 0;
                }
            });
        }
    }

    private void bYY() {
        View Cl;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bTU().pageContext);
        if (runTask != null) {
            this.gEV = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gEV != null && (Cl = this.gEV.Cl()) != null && this.gHQ.gOO.indexOfChild(Cl) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gHQ.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bTU().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bTU().gOO.addView(Cl, layoutParams);
        }
    }

    private void bYZ() {
        CustomResponsedMessage runTask;
        if (this.gVb == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.z.a.class, bTU().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gVb = (com.baidu.live.z.a) runTask.getData();
        }
    }

    private void bZa() {
        View FQ;
        w.e(bTU().gON.Gm());
        w.b(bTU().pageContext, true);
        w.Gt();
        if (this.gEW == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aRM = true;
            fVar.context = bTU().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, x.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gEW = (x) runTask.getData();
                if (this.gEW != null && (FQ = this.gEW.FQ()) != null && bTU().gOO.indexOfChild(FQ) < 0) {
                    if (FQ.getParent() instanceof ViewGroup) {
                        ((ViewGroup) FQ.getParent()).removeView(FQ);
                    }
                    bTU().gOO.addView(FQ, bTU().gOO.getLayoutParams());
                }
            }
        }
    }

    protected void bSR() {
        View Gl;
        if (this.gEX == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aRM = true;
            aVar.context = bTU().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, v.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gEX = (v) runTask.getData();
            }
        }
        if (this.gEX != null && (Gl = this.gEX.Gl()) != null) {
            if (bTU().gOO.indexOfChild(Gl) < 0) {
                if (Gl.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Gl.getParent()).removeView(Gl);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.gFf != null && this.gFf.isShowing()) {
                    layoutParams.addRule(3, a.g.guard_club_entry_id);
                    layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else if (this.gUA != null && this.gUA.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
                    layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else if (this.gFq != null && this.gFq.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_rank_level_entry);
                    layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds8);
                } else {
                    layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                    layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds66);
                }
                bTU().gOO.addView(Gl, layoutParams);
            }
            Gl.bringToFront();
        }
    }

    protected void bSQ() {
        View Gy;
        if (this.gFh == null) {
            ac acVar = new ac();
            acVar.aRM = true;
            acVar.pageContext = bTU().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, z.class, acVar);
            if (runTask != null && runTask.getData() != null) {
                this.gFh = (z) runTask.getData();
            }
        }
        if (this.gFh != null && (Gy = this.gFh.Gy()) != null && bTU().gOO.indexOfChild(Gy) < 0) {
            if (Gy.getParent() instanceof ViewGroup) {
                ((ViewGroup) Gy.getParent()).removeView(Gy);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bTU().gOO.addView(Gy, layoutParams);
        }
    }

    private void bZb() {
        bZf();
        bRP();
        bZe();
        bTU().gOO.setVisibility(0);
        vq(0);
    }

    private void bZc() {
        if (this.gUA == null) {
            this.gUA = new com.baidu.tieba.ala.liveroom.v.a(bTU().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.gUA.a(bTU().bVQ(), j, TbadkCoreApplication.getCurrentAccountName(), true, bTU().gON.Gm().aHD.portrait, this.otherParams, "", -1L);
        this.gUA.av(bTU().gOO);
    }

    private void bZd() {
        if (this.gVd == null) {
            bTU().gOO.hen = false;
            com.baidu.live.y.a fb = fb(bTU().pageContext.getPageActivity());
            if (fb != null) {
                this.gVd = fb;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.y.a.class, bTU().pageContext.getPageActivity());
                if (runTask != null) {
                    this.gVd = (com.baidu.live.y.a) runTask.getData();
                }
            }
            if (this.gVd != null) {
                this.gVd.t(this.gUL);
                this.gVd.u(this.gUM);
                this.gVd.fc((bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bTU().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                this.gVd.v(bTU().gOO);
                this.gVd.a(this.gDr);
                this.gVd.setLiveShowInfo(bTU().gON.Gm());
                this.gVd.a(this.gDW);
                this.gVd.Pe();
                this.gVd.a(new a.InterfaceC0217a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                    @Override // com.baidu.live.y.a.InterfaceC0217a
                    public void Pf() {
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0217a
                    public void Pg() {
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0217a
                    public void K(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bTU().gPm != null) {
                            AlaMasterLiveRoomOpearator.this.bTU().gPm.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0217a
                    public int Ph() {
                        return AlaMasterLiveRoomOpearator.this.gUK.getBottom();
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0217a
                    public int Pi() {
                        return AlaMasterLiveRoomOpearator.this.gHQ.gOO.getHeight() - (AlaMasterLiveRoomOpearator.this.gEU.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gEU.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0217a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gEU.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.y.a.InterfaceC0217a
                    public int Pj() {
                        return AlaMasterLiveRoomOpearator.this.gEU.KR();
                    }
                });
            }
        }
    }

    private com.baidu.live.y.a fb(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aw(context);
        }
        return null;
    }

    private void bZe() {
        if (this.gUC == null) {
            this.gUC = new b(bTU().pageContext, bTU().gOO);
        }
    }

    private void bZf() {
        if (this.gDR == null) {
            this.gDR = new com.baidu.tieba.ala.liveroom.p.a(bTU().pageContext, true, this.gVR);
            this.gDR.d(this.gUK, null);
            this.gDR.a(this.gEx);
            this.gDR.mT(false);
        }
        if (this.gUy == null) {
            this.gUy = new com.baidu.tieba.ala.liveroom.p.a(bTU().pageContext, true, null);
            this.gUy.a(this.gUK, null, a.g.ala_live_room_host_header_stub);
            this.gUy.bXC();
        }
    }

    protected void bSy() {
        CustomResponsedMessage runTask;
        boolean z = false;
        al caH = bTU().gON.caH();
        boolean z2 = com.baidu.live.x.a.OS().blo.aLE;
        if (caH == null || caH.aIr) {
            z = z2;
        }
        if (z && this.gEG == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bTU().pageContext)) != null) {
            this.gEG = (com.baidu.live.h.a) runTask.getData();
            if (this.gEG != null) {
                this.gEG.setIsHost(true);
                this.gEG.eE(1);
                View view = this.gEG.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bTU().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bTU().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.gUK.addView(view, layoutParams);
                }
            }
        }
    }

    private void h(u uVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gDW == null) {
            this.gDW = new com.baidu.tieba.ala.liveroom.activeview.b(bTU().pageContext);
        }
        this.gDW.setOtherParams(this.otherParams);
        this.gDW.b(uVar, false);
        this.gDW.setHost(true);
        this.gDW.a(1, this.bot);
        this.gDW.a(2, this.bot);
        this.gDW.mg(this.gFJ);
        this.gDW.setVisible(this.gUw ? 8 : 0);
        this.gDW.a(this.gDr);
        if (this.gDr != null) {
            if (this.gDW != null) {
                alaActiveRootView2 = this.gDW.uJ(1);
                alaActiveRootView = this.gDW.uJ(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.gDr.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.gDr.a(alaActiveRootView);
            }
        }
    }

    private void A(u uVar) {
        CustomResponsedMessage runTask;
        if (this.gFu == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bTU().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.u.a)) {
            this.gFu = (com.baidu.live.u.a) runTask.getData();
            if (this.gFu != null) {
                this.gFu.s(this.bot);
            }
        }
        if (this.gFu != null) {
            this.gFJ = this.gFu.q(uVar);
            this.gFu.setCanVisible(!this.gUw);
        }
    }

    protected void bZg() {
        CustomResponsedMessage runTask;
        if (bTU() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bTU().pageContext.getPageActivity())) != null && runTask.getData() != null && this.gFo == null) {
            this.gFo = (com.baidu.live.i.a) runTask.getData();
            this.gFo.b(bTU().gOO, bTe());
            if (bTU().gON != null) {
                this.gFo.a(bTU().gON.Gm());
            }
            this.gFo.setCanVisible(true);
            this.gFo.bP(false);
            this.gFo.a(bTU().gON.bMo());
        }
    }

    protected void bSU() {
        CustomResponsedMessage runTask;
        if (bTU() != null && this.gFp == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.p.a.class, bTU().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gFp = (com.baidu.live.p.a) runTask.getData();
            this.gFp.setIsHost(true);
            this.gFp.b(this.bot, bTU().gON.Gm());
        }
    }

    private void B(u uVar) {
        CustomResponsedMessage runTask;
        if (bTU() != null) {
            if (this.gUE == null && (runTask = MessageManager.getInstance().runTask(2913229, d.class)) != null) {
                this.gUE = (d) runTask.getData();
            }
            if (this.gUE != null) {
                this.gUE.NQ();
            }
            if (this.gUF == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, com.baidu.live.p.c.class);
                if (runTask2 != null) {
                    this.gUF = (com.baidu.live.p.c) runTask2.getData();
                }
                if (this.gUF != null) {
                    this.gUF.setParentView(this.gHQ.gOO);
                    if (uVar != null && uVar.aHD != null) {
                        this.gUF.ar(uVar.aHD.userId);
                    }
                }
            }
        }
    }

    private void bSI() {
        if (this.gVA == null) {
            this.gVA = new com.baidu.tieba.ala.liveroom.r.c(bTU().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams bTe() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bTU().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.gFq != null && this.gFq.isShowing()) {
            layoutParams.addRule(3, a.g.ala_rank_level_entry);
            layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else if (this.gUA != null && this.gUA.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else if (this.gFf != null && this.gFf.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        }
        return layoutParams;
    }

    private void bRP() {
        if (this.gUz == null) {
            this.gUz = new com.baidu.tieba.ala.liveroom.b.a(bTU().pageContext, true);
        }
    }

    private void bZh() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bTU().pageContext.getPageActivity();
            if (this.gVe == null) {
                this.gVe = new ImageView(pageActivity);
                this.gVe.setId(a.g.master_close_btn);
                this.gVe.setTag("master_close_btn");
                this.gVe.setImageResource(a.f.sdk_icon_bar_live_close_n);
                this.gVe.setBackgroundResource(a.f.sdk_round_btn_close_bg);
                this.gVe.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            }
            if (this.gVe.getParent() != null) {
                ((ViewGroup) this.gVe.getParent()).removeView(this.gVe);
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
            bTU().gPo.addView(this.gVe, layoutParams);
            this.gVe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bZr();
                }
            });
            this.gVe.setVisibility(8);
        }
    }

    protected void bSV() {
        if (this.gFq == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.p.b.class, bTU().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gFq = (com.baidu.live.p.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bTU().gON.Gm() != null && bTU().gON.Gm().aHD != null && bTU().gON.Gm().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.height = BdUtilHelper.getDimens(bTU().pageContext.getPageActivity(), a.e.sdk_ds44);
            layoutParams.topMargin = BdUtilHelper.getDimens(bTU().pageContext.getPageActivity(), a.e.sdk_ds16);
            layoutParams.leftMargin = BdUtilHelper.getDimens(bTU().pageContext.getPageActivity(), a.e.sdk_ds20);
            this.gFq.b(bTU().gOO, layoutParams, bTU().gON.Gm());
        }
    }

    private void bZi() {
        CustomResponsedMessage runTask;
        if (this.gVy == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.a.a.class, bTU().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.a)) {
            this.gVy = (com.baidu.live.a.a) runTask.getData();
            if (this.gVy != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bTU().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gVy.b(bTU().gOO, layoutParams);
            }
        }
        if (this.gVy != null) {
            this.gVy.a(bTU().gON.Gm());
        }
    }

    private void bZj() {
        CustomResponsedMessage runTask;
        if (this.gVz == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.a.b.class, bTU().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.b)) {
            this.gVz = (com.baidu.live.a.b) runTask.getData();
        }
    }

    private void bSJ() {
        if (this.gFw == null) {
            this.gFw = new com.baidu.live.af.a(bTU().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.gVw != null) {
            this.gVw.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bTU().pageContext.registerListener(this.gGa);
        bTU().pageContext.registerListener(this.gVH);
        bTU().pageContext.registerListener(this.gGc);
        bTU().pageContext.registerListener(this.gGd);
        bTU().pageContext.registerListener(this.gVO);
        bTU().pageContext.registerListener(this.byz);
        bTU().pageContext.registerListener(this.gCg);
        bTU().pageContext.registerListener(this.gVP);
        bTU().pageContext.registerListener(this.gGb);
        bTU().pageContext.registerListener(this.gEs);
        bTU().pageContext.registerListener(this.gGh);
        bTU().pageContext.registerListener(this.gVL);
        bTU().pageContext.registerListener(this.gVM);
        bTU().pageContext.registerListener(this.gVI);
        bTU().pageContext.registerListener(this.bkV);
        bTU().pageContext.registerListener(this.bkW);
        bTU().pageContext.registerListener(this.gVJ);
        bTU().pageContext.registerListener(this.gGk);
        bTU().pageContext.registerListener(this.gGj);
        bTU().pageContext.registerListener(this.gGl);
        bTU().pageContext.registerListener(this.gVK);
        bTU().pageContext.registerListener(this.gVJ);
        bTU().pageContext.registerListener(this.bkb);
        bTU().pageContext.registerListener(this.bgD);
        bTU().pageContext.registerListener(this.gGn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mY(boolean z) {
        if (bh.c(com.baidu.live.x.a.OS().bqJ)) {
            bTU().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bTU().gPq.Cf() == null || ListUtils.isEmpty(bTU().gPq.Cf().aDn)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bTU().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.gVB) {
                this.gVC = BdUniqueId.gen();
                bTU().gPq.a(this.gVC);
                this.gVB = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bTU().pageContext.getPageActivity(), bTU().rootView);
            vq(8);
            if (bTU().gPm.hasAdvancedBeauty() && this.gVu != null) {
                if (!this.gVD || this.gUx.getVisibility() == 0) {
                    this.gVu.a(bTU().gPm.getVideoConfig());
                }
                this.gVu.a(bTU().gPm.getVideoConfig(), this.gVv);
                if (!this.gVv) {
                    this.gVv = true;
                }
            }
            if (z && this.gEU != null) {
                this.gEU.KP().getView().setVisibility(4);
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
            if (TbadkCoreApplication.getInst().isYinbo()) {
                return activity.getResources().getString(a.i.sdk_permission_app_type_yb_text);
            }
            if (TbadkCoreApplication.getInst().isOther() && !TextUtils.isEmpty(TbConfig.getSubappName())) {
                return TbConfig.getSubappName();
            }
            return activity.getResources().getString(a.i.sdk_permission_app_type_tb_text);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vp(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bTU().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bTU().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bTU().f((short) 1);
            }
        });
        bdAlertDialog.create(bTU().pageContext).show();
    }

    private void Hs(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bTU().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bTU().f((short) 1);
            }
        });
        bdAlertDialog.create(bTU().pageContext).show();
    }

    public void bZk() {
        bSy();
        com.baidu.live.data.n bMo = bTU().gON.bMo();
        int i = 5;
        if (bMo != null) {
            i = (int) bMo.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bTU().gON.Gm() != null && AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bTU().gON.g(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bMo != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gHQ.gPt.b(bMo);
                return;
            }
            if (this.gDQ == null) {
                this.gDQ = new c(bTU().pageContext, this.gVR, true);
            }
            if (this.gVs) {
                this.gVs = false;
                this.gDQ.a(String.valueOf(bTU().gON.Gm().mLiveInfo.group_id), String.valueOf(bTU().gON.Gm().mLiveInfo.live_id), String.valueOf(bTU().gON.Gm().aHD.userId), bTU().gON.Gm());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.gEG != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.gDQ.c(this.gUK, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.gDQ.e(bMo);
            this.gDU.setVisible(0);
            this.gDU.dY(bMo.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZl() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boA() {
        if (bTU().gON != null) {
            if (this.gEH == null) {
                this.gEH = new com.baidu.tieba.ala.liveroom.share.c(bTU().pageContext);
            }
            this.gEH.c(bTU().gON.Gm(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bTU().gON != null && bTU().gON.Gm() != null && bTU().gON.Gm().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bTU().gON.Gm().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bTU().gON.Gm().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bTU().gON.Gm().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bTU().gON != null && bTU().gON.Gm() != null && bTU().gON.Gm().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bTU().gON.Gm().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bTU().gON.Gm().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bTU().gON.Gm().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bZm() {
        return this.gUv;
    }

    private void mZ(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(gUu, z);
        this.gUv = z;
    }

    private void bZn() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bTU().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.q.b(AlaMasterLiveRoomOpearator.this.bTU().pageContext).cap();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bTU().pageContext).show();
    }

    private void bZo() {
        if (this.gUe && bTU().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bTU().gPs.PP();
        }
        bTU().gPr.prepareTime = System.currentTimeMillis() - bTU().gPr.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bTU().gON != null && bTU().gON.Gm() != null && bTU().gON.Gm().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bTU().gON.Gm().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bTU().gON.Gm().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bTU().gPr.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gUx != null && this.gUx.getView().getParent() != null) {
            this.gUx.setVisibility(8);
            bTU().gPo.removeView(this.gUx.getView());
            this.gUx.release();
        }
        if (this.gVu != null) {
            this.gVu.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bTU().gOO.indexOfChild(this.gUH) < 0) {
            bTU().gOO.addView(this.gUH, layoutParams);
        }
        this.gUH.vG(1000);
    }

    private void arx() {
        if (bTU().bVQ() == 1) {
            bTU().gPm.startRecord();
        }
    }

    private void Ht(String str) {
        Hu(str);
    }

    private void Hu(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bTU().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.gUx != null) {
            this.gUx.Hg(fromJson.getSmallurl());
        }
    }

    private boolean bZp() {
        return com.baidu.live.c.AZ().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZq() {
        com.baidu.live.c.AZ().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.gHQ.gPm.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZr() {
        if (this.gVx == null || !this.gVx.Rg()) {
            int i = a.i.live_close_confirm;
            if (this.gVw != null && this.gVw.bUc()) {
                i = a.i.ala_pk_pking_close_live_roon_tip;
            } else if (this.gVw != null && this.gVw.bUb()) {
                i = a.i.ala_challenge_challenging_close_live_room_tip;
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(bTU().pageContext.getPageActivity());
            bdAlertDialog.setAutoNight(false);
            bdAlertDialog.setTitle((String) null);
            bdAlertDialog.setMessageId(i);
            bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                    }
                    bdAlertDialog2.dismiss();
                    if (AlaMasterLiveRoomOpearator.this.bTU().gON.Gm() != null) {
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm(), 0, AlaMasterLiveRoomOpearator.this.bTU().gON.caQ() != 1 ? AlaMasterLiveRoomOpearator.this.bTU().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    } else {
                        AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                    }
                }
            });
            bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog2) {
                    bdAlertDialog2.dismiss();
                }
            });
            bdAlertDialog.create(bTU().pageContext).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u uVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (uVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = uVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = uVar.aHD;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bTU().gON.er(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.gVq) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bTU().gPr;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bTU().gPm.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.gVm;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.gVn;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.gVi;
            if (this.gVj != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.gVk - this.gVl) / this.gVj) * 100.0f;
            }
            Intent intent = new Intent(bTU().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bTU().gON != null && bTU().gON.Gm() != null && bTU().gON.Gm().aHD != null) {
                String str3 = bTU().gON.Gm().aHD.nickName;
                String str4 = bTU().gON.Gm().aHD.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            u Gm = bTU().gON.Gm();
            if (Gm != null && Gm.aHD != null && !TextUtils.isEmpty(Gm.aHD.portrait)) {
                intent.putExtra("host_portrait", Gm.aHD.portrait);
            }
            if (this.gVx != null) {
                this.gVx.Rh();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.gVo = intent;
                this.gVp = s;
                bTU().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bZs() {
        if (this.gVo != null) {
            a(this.gVo, this.gVp);
            this.gVo = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.gVq = true;
        if (this.gVw != null) {
            this.gVw.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.gBV);
            bTU().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bTU().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZt() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gHQ.gPt != null && this.gHQ.gPt.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.gVw != null && this.gVw.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.gVx != null && this.gVx.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bTU().gPp.bZY()) {
                bZr();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.gUI != null) {
                this.gUI.setVisibility(4);
                return;
            }
            return;
        }
        if (this.gUI != null) {
            this.gUI.a(i, z, i2, z2);
        }
        if (this.gHQ != null && this.gHQ.gON != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dlH != i3) {
                this.dlH = i3;
                if (this.gUD == null) {
                    this.gUD = new com.baidu.tieba.ala.liveroom.tippop.a(this.gHQ.pageContext, null);
                }
                switch (this.dlH) {
                    case 0:
                        this.gUD.a(this.gHQ.gPo, this.gHQ.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.gUD.a(this.gHQ.gPo, this.gHQ.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.gUD.a(this.gHQ.gPo, this.gHQ.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gHQ.gON.r(this.gHQ.gON.Gm().mLiveInfo.live_id, i3);
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
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bZt();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0631, code lost:
        GX(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[Catch: JSONException -> 0x0726, TRY_LEAVE, TryCatch #3 {JSONException -> 0x0726, blocks: (B:8:0x0018, B:10:0x0020, B:221:0x071b), top: B:241:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x071b A[Catch: JSONException -> 0x0726, TRY_ENTER, TRY_LEAVE, TryCatch #3 {JSONException -> 0x0726, blocks: (B:8:0x0018, B:10:0x0020, B:221:0x071b), top: B:241:0x0018 }] */
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
        String optString;
        JSONObject jSONObject5;
        long j;
        long j2;
        long j3;
        String str3;
        String str4;
        boolean z;
        JSONObject jSONObject6;
        if (aVar.getMsgType() == 125) {
            if (this.gUB != null) {
                this.gUB.C(aVar);
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
                        if (this.gVw != null) {
                        }
                        if (!"close_live".equals(str2)) {
                        }
                        if (!(aVar.getObjContent() instanceof JSONObject)) {
                        }
                        jSONObject6.put("log_id", aVar.getMsgId());
                        if (this.gFp != null) {
                        }
                        return;
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
            if (this.gVw != null) {
                this.gVw.gb(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bZt();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bTU().gON.Gm(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bTU().gON.Gm() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bTU().gON.Gm().aIf.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bTU().gON.Gm().aIf.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bTU().gON.Gm().aIf.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bTU().gON.Gm() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bTU().gON.Gm() != null && bTU().gON.Gm().aHD != null && bTU().gON.Gm().aHD.userId == optLong2) {
                        bTU().gON.Gm().aHD.isUegBlock = 1;
                        bSc();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bTU().gON.Gm() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bTU().gON.Gm() != null && bTU().gON.Gm().aHD != null && bTU().gON.Gm().aHD.userId == optLong3) {
                        bTU().gON.Gm().aHD.isUegBlock = 0;
                        bSc();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.gVb != null) {
                    this.gVb.P(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.gUC.aG(optString4, optInt2);
                    }
                    if (this.gDU.getCount() > 20) {
                        this.gDU.dY(this.gDU.getCount() + 1);
                    } else if (this.gDQ != null) {
                        com.baidu.live.data.a Lt = aVar.Lt();
                        com.baidu.live.data.m mVar = new com.baidu.live.data.m();
                        mVar.aHE = new AlaLocationData();
                        mVar.aHF = new AlaRelationData();
                        mVar.aHD = new AlaLiveUserInfoData();
                        mVar.aHD.userId = JavaTypesHelper.toLong(Lt.userId, 0L);
                        mVar.aHD.userName = Lt.userName;
                        mVar.aHD.portrait = Lt.portrait;
                        if (this.gDQ.c(mVar)) {
                            this.gDU.dY(this.gDU.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bTU() != null && bTU().gON != null && bTU().gON.Gm() != null && bTU().gON.Gm().aIf != null && bTU().gON.Gm().aIf.userId == jSONObject2.optLong("user_id")) {
                    bTU().gON.caG();
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
                    com.baidu.live.data.a Lt2 = aVar.Lt();
                    if (Lt2 != null && w.gQ(str6)) {
                        w.d(str6, 1L, "", "", Lt2.userId, Lt2.portrait, Lt2.userName, "", "", false, "", "", "", false, false, true, -1L);
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
                        Hv(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bTU().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(bTU().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a Lt3 = aVar.Lt();
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
                boolean z2 = jSONObject5.optInt("from_gongyanfang_page") == 1;
                String str7 = null;
                if (bTU().gON == null || bTU().gON.Gm() == null || bTU().gON.Gm().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    str3 = "";
                    str4 = "";
                    z = false;
                } else {
                    long j4 = bTU().gON.Gm().mLiveInfo.live_id;
                    long j5 = bTU().gON.Gm().mLiveInfo.group_id;
                    long j6 = bTU().gON.Gm().aHD.userId;
                    str7 = bTU().gON.Gm().mLiveInfo.appId;
                    boolean z3 = bTU().gON.Gm().mLiveInfo.isPubShow;
                    if (bTU().gON.Gm().mLiveSdkInfo.mCastIds == null) {
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = "";
                        str4 = "";
                        z = z3;
                    } else {
                        String str8 = bTU().gON.Gm().mLiveSdkInfo.mCastIds.aHY;
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = bTU().gON.Gm().mLiveSdkInfo.mCastIds.aHZ;
                        str4 = str8;
                        z = z3;
                    }
                }
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString7, "");
                if (!this.isBackground || bTU().bVQ() != 2) {
                    if (!TextUtils.isEmpty(optString13) && !TextUtils.isEmpty(optString14)) {
                        if (jSONObject5.optInt("flag_show") == 1) {
                            w.b(optString14, Lt3.userId, Lt3.portrait, Lt3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString13, "", "", aVar.getMsgId());
                            try {
                                JSONArray jSONArray = new JSONArray(optString14);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.x.d.OZ().hK(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                        aVar.setHost(z && z2);
                        w.a(optString7, Integer.parseInt(optString8), optString9, optString10, Lt3.userId, Lt3.portrait, Lt3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString12, str4, str3, aVar.getMsgId(), !z2, optString11);
                    }
                }
                GX(optString7);
                com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                cVar.gOs = optLong5;
                cVar.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                JSONObject jSONObject7 = new JSONObject();
                try {
                    jSONObject7.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                    jSONObject7.putOpt("gift_name", optString9);
                    jSONObject7.putOpt("order_id", optString6);
                    com.baidu.live.gift.g gM = w.gM(optString7);
                    if (gM != null) {
                        jSONObject7.putOpt(LogConfig.LOG_GIFT_VALUE, gM.getPrice());
                    }
                    jSONObject7.putOpt("gift_num", optString8);
                } catch (JSONException e6) {
                    e6.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "giftsend_succ").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject7));
            } catch (JSONException e7) {
            }
        }
        try {
            if (!(aVar.getObjContent() instanceof JSONObject)) {
                jSONObject6 = (JSONObject) aVar.getObjContent();
            } else {
                jSONObject6 = new JSONObject(aVar.getContent());
            }
            try {
                jSONObject6.put("log_id", aVar.getMsgId());
            } catch (JSONException e8) {
            }
        } catch (JSONException e9) {
            jSONObject6 = null;
        }
        if (this.gFp != null || this.gFp.M(jSONObject6)) {
        }
    }

    private void GX(String str) {
        if (this.gDW != null) {
            this.gDW.GX(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vq(int i) {
        View findViewById = bTU().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gDW != null) {
            this.gDW.bI(2, i);
        }
    }

    private void bZu() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bTU().gPm != null && AlaMasterLiveRoomOpearator.this.bTU().gPm.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bTU().gPm.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bTU().gPm.startRecord();
                }
            }
        });
    }

    private void bZv() {
        if (bTU().gPm != null && bTU().gPm.getPreview() != null) {
            bTU().gPm.getPreview().setVisibility(8);
            bTU().gPm.stopRecord();
        }
    }

    public void bZw() {
        this.gPj = bTU().gON.caR();
        if (this.gUx != null) {
            this.gUx.mG(this.gPj);
        }
    }

    public void bVO() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bZx();
        } else if (this.gUx != null) {
            this.gUx.bVO();
        }
    }

    public void mH(boolean z) {
        if (this.gUx != null) {
            this.gUx.mH(z);
        }
    }

    public void onDestroy() {
        if (this.gVh != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.gVh);
        }
        this.gVh = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.gVa.removeCallbacksAndMessages(null);
        if (this.gVu != null) {
            this.gVu.mE(true);
        }
        this.gVu = null;
        if (this.gUx != null) {
            this.gUx.destroy();
            bTU().gPo.removeView(this.gUx.getView());
            this.gUx.release();
            this.gUx = null;
        }
        if (this.gVw != null) {
            this.gVw.onDestroy();
        }
        if (this.gEH != null) {
            this.gEH.onDestroy();
        }
        if (this.gDR != null) {
            this.gDR.onDestroy();
            this.gDR = null;
        }
        if (this.gUy != null) {
            this.gUy.onDestroy();
        }
        if (this.gFh != null) {
            this.gFh.onDestroy();
            this.gFh = null;
        }
        if (this.gUH != null) {
            this.gUH.stopCountDown();
        }
        if (this.gUA != null) {
            this.gUA.onDestroy();
        }
        if (this.gUC != null) {
            this.gUC.onDestroy();
        }
        if (this.gVb != null) {
            this.gVb.onDestroy();
            this.gVb = null;
        }
        if (this.gEW != null) {
            this.gEW.onDestroy();
            this.gEW = null;
        }
        if (this.gUE != null) {
            this.gUE.release();
        }
        w.Gu();
        com.baidu.live.entereffect.a.Et().release();
        if (this.gEX != null) {
            this.gEX.onDestroy();
            this.gEX = null;
        }
        if (this.gUD != null) {
            this.gUD.onDestroy();
        }
        if (this.gUB != null) {
            this.gUB.ccP();
            this.gUB.release();
        }
        if (this.gDU != null) {
            this.gDU = null;
        }
        if (this.gDW != null) {
            this.gDW.release();
        }
        if (this.gUB != null) {
            this.gUB.onDestroy();
        }
        if (this.gEV != null) {
            this.gEV.release();
        }
        if (this.gUG != null) {
            this.gUG.release();
        }
        if (this.gFf != null) {
            this.gFf.onDestroy();
        }
        if (this.gVd != null) {
            this.gVd.onDestroy();
        }
        if (this.gFu != null) {
            this.gFu.release();
        }
        if (this.gVy != null) {
            this.gVy.onDestory();
        }
        if (this.gVz != null) {
            this.gVz.release();
        }
        if (this.gFo != null) {
            this.gFo.onDestroy();
        }
        if (this.gFp != null) {
            this.gFp.onDestroy();
        }
        if (this.gUF != null) {
            this.gUF.release();
            this.gUF = null;
        }
        if (this.gVA != null) {
            this.gVA.release();
        }
        if (this.gFw != null) {
            this.gFw.release();
        }
        if (this.gFq != null) {
            this.gFq.onDestroy();
        }
        if (this.gVx != null) {
            this.gVx.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gGa);
        MessageManager.getInstance().unRegisterListener(this.gVH);
        MessageManager.getInstance().unRegisterListener(this.gGc);
        MessageManager.getInstance().unRegisterListener(this.gGd);
        MessageManager.getInstance().unRegisterListener(this.gVO);
        MessageManager.getInstance().unRegisterListener(this.byz);
        MessageManager.getInstance().unRegisterListener(this.gCg);
        MessageManager.getInstance().unRegisterListener(this.gVP);
        MessageManager.getInstance().unRegisterListener(this.gGb);
        MessageManager.getInstance().unRegisterListener(this.gEs);
        MessageManager.getInstance().unRegisterListener(this.gGh);
        MessageManager.getInstance().unRegisterListener(this.gVL);
        MessageManager.getInstance().unRegisterListener(this.gVM);
        MessageManager.getInstance().unRegisterListener(this.gVI);
        MessageManager.getInstance().unRegisterListener(this.bkV);
        MessageManager.getInstance().unRegisterListener(this.bkW);
        MessageManager.getInstance().unRegisterListener(this.gVJ);
        MessageManager.getInstance().unRegisterListener(this.gGk);
        MessageManager.getInstance().unRegisterListener(this.gGj);
        MessageManager.getInstance().unRegisterListener(this.gGl);
        MessageManager.getInstance().unRegisterListener(this.gVK);
        MessageManager.getInstance().unRegisterListener(this.gVJ);
        MessageManager.getInstance().unRegisterListener(this.bkb);
        MessageManager.getInstance().unRegisterListener(this.bgD);
        MessageManager.getInstance().unRegisterListener(this.gGn);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gHQ.gPt.a(this.gVY, this.gHQ.gPn, this.gUJ, alaLivePersonData);
        }
    }

    private void bZx() {
        if (this.gVf != null) {
            this.gHQ.gPr.startTime = System.currentTimeMillis();
            this.gHQ.gPr.liveTotalTime = System.currentTimeMillis();
            this.gHQ.gPr.sampleMemAndCPU();
            this.gHQ.gPp.a((short) 4, this.gVf);
        }
    }

    private void Hv(String str) {
        String str2;
        int i;
        if (bTU() != null && bTU().pageContext != null) {
            this.gVa.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bTU().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.gVE == null) {
                    this.gVE = layoutInflater.inflate(a.h.layout_challenge_entry_toast, (ViewGroup) null);
                    this.gVE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.bYA()) {
                                AlaMasterLiveRoomOpearator.this.gVa.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.gVE != null) {
                                    AlaMasterLiveRoomOpearator.this.bTU().gOO.removeView(AlaMasterLiveRoomOpearator.this.gVE);
                                }
                                if (AlaMasterLiveRoomOpearator.this.gVw != null) {
                                    AlaMasterLiveRoomOpearator.this.gVw.bTY();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.gVE.findViewById(a.g.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.i.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.gVa.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bTU().gOO != null && AlaMasterLiveRoomOpearator.this.gHX != null && AlaMasterLiveRoomOpearator.this.gVE != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.gVE.findViewById(a.g.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.gVE.findViewById(a.g.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.A((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.gVE.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gHX.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gHX.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gHX.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gHX.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.gVE.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.gVE.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.gVE != null) {
                                AlaMasterLiveRoomOpearator.this.bTU().gOO.removeView(AlaMasterLiveRoomOpearator.this.gVE);
                            }
                            AlaMasterLiveRoomOpearator.this.bTU().gOO.addView(AlaMasterLiveRoomOpearator.this.gVE, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.x.a.OS().blo != null) {
                    i = com.baidu.live.x.a.OS().blo.aKP;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.gVa.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bTU().gOO != null && AlaMasterLiveRoomOpearator.this.gVE != null) {
                            AlaMasterLiveRoomOpearator.this.bTU().gOO.removeView(AlaMasterLiveRoomOpearator.this.gVE);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
