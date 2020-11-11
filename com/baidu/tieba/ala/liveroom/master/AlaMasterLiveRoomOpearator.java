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
import com.baidu.tieba.ala.liveroom.data.d;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
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
    private static final String hmc;
    private boolean bmI;
    private PendantParentView brz;
    private BdUniqueId bxr;
    private boolean bxs;
    private boolean bxt;
    private com.baidu.live.ak.a gKY;
    private String gUi;
    private c gVI;
    private com.baidu.tieba.ala.liveroom.p.a gVJ;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gVM;
    private com.baidu.tieba.ala.liveroom.activeview.b gVO;
    protected com.baidu.live.z.a gVV;
    private com.baidu.live.g.a gVo;
    private com.baidu.tieba.ala.liveroom.share.c gWA;
    private com.baidu.tieba.ala.liveroom.s.b gWB;
    private m gWM;
    private k gWN;
    private com.baidu.live.im.b.a gWO;
    private ab gWP;
    private z gWQ;
    private com.baidu.live.h.a gWz;
    private boolean gXE;
    protected ae gXa;
    protected com.baidu.live.j.a gXh;
    protected com.baidu.live.r.a gXi;
    protected com.baidu.live.i.a gXj;
    protected com.baidu.live.r.b gXk;
    private com.baidu.live.w.a gXo;
    protected com.baidu.live.q.a gXs;
    private boolean gYv;
    private e gZK;
    private ImageView gZR;
    private f gZS;
    private boolean hlM;
    private boolean hmA;
    private AlaLiveFaceVerifyView hmB;
    private ImageView hmC;
    private ImageView hmD;
    private ImageView hmE;
    private ImageView hmF;
    private ImageView hmG;
    private ImageView hmH;
    private ImageView hmI;
    private TextView hmJ;
    private aq hmK;
    private com.baidu.live.ad.a hmM;
    private com.baidu.tieba.ala.liveroom.master.panel.b hmN;
    private com.baidu.live.ab.a hmO;
    private ImageView hmP;
    private d hmQ;
    private boolean hmd;
    private com.baidu.tieba.ala.liveroom.h.d hmf;
    private com.baidu.tieba.ala.liveroom.p.a hmg;
    private com.baidu.tieba.ala.liveroom.b.a hmh;
    private com.baidu.tieba.ala.liveroom.v.a hmi;
    private com.baidu.tieba.ala.liveroom.x.a hmj;
    private b hmk;
    private com.baidu.tieba.ala.liveroom.tippop.a hml;
    private com.baidu.live.r.d hmm;
    private com.baidu.live.r.c hmn;
    protected com.baidu.live.k.a hmo;
    protected com.baidu.live.aj.b hmp;
    private AlaLiveCountDownView hmq;
    private AlaLiveStreamStatusView hmr;
    private RelativeLayout hms;
    private RelativeLayout hmt;
    private RelativeLayout hmu;
    private RelativeLayout hmv;
    private RelativeLayout hmw;
    private FrameLayout hmx;
    private FrameLayout hmy;
    private View hmz;
    private short hna;
    private com.baidu.tieba.ala.liveroom.h.b hnf;
    private com.baidu.tieba.ala.liveroom.challenge.e hng;
    private com.baidu.live.ai.a hnh;
    private com.baidu.live.a.a hni;
    private com.baidu.live.a.b hnj;
    private com.baidu.tieba.ala.liveroom.r.a hnk;
    private boolean hnl;
    private View hnm;
    private FrameLayout hnn;
    private boolean hno;
    private boolean hme = false;
    private boolean gXz = false;
    private Handler mHandler = new Handler();
    private Handler hmL = new Handler();
    private boolean hmR = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hmS = null;
    private boolean hmT = false;
    private int hmU = 0;
    private int hmV = 0;
    private int hmW = 0;
    private long hmX = 0;
    private long hmY = 0;
    private volatile boolean isBackground = false;
    private Intent hmZ = null;
    private int mOrientation = 1;
    private boolean hgR = false;
    private boolean hnb = false;
    private boolean hnc = true;
    private boolean gZP = false;
    private boolean hnd = true;
    private boolean hne = true;
    private int dAb = 0;
    private String otherParams = "";
    private int bmL = 0;
    private Runnable hnp = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.gVo != null) {
                AlaMasterLiveRoomOpearator.this.gVo.Ff();
            }
        }
    };
    private com.baidu.live.ai.b bGU = new com.baidu.live.ai.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.ai.b
        public boolean UP() {
            if (AlaMasterLiveRoomOpearator.this.hng != null) {
                if (AlaMasterLiveRoomOpearator.this.gXi != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hng.bZx() && !AlaMasterLiveRoomOpearator.this.hng.bZy() && !AlaMasterLiveRoomOpearator.this.gXi.ON() && !AlaMasterLiveRoomOpearator.this.gXi.Dl()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hng.bZx() && !AlaMasterLiveRoomOpearator.this.hng.bZy()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.gXi == null || AlaMasterLiveRoomOpearator.this.gXi.ON() || AlaMasterLiveRoomOpearator.this.gXi.Dl()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.ai.b
        public void UQ() {
            if (AlaMasterLiveRoomOpearator.this.hng != null) {
                AlaMasterLiveRoomOpearator.this.hng.bZA();
            }
        }
    };
    private CustomMessageListener bnK = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gZK.hhc != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gZK.hhc.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.H(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener bnL = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gZK.hhc != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gZK.hhc.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener gXY = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gWB == null) {
                        AlaMasterLiveRoomOpearator.this.gWB = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gWB.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener gYf = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gXh != null) {
                AlaMasterLiveRoomOpearator.this.gXh.KX();
            }
        }
    };
    private CustomMessageListener hnq = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gXW = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.HQ(str);
            }
        }
    };
    private CustomMessageListener gvb = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bsT();
        }
    };
    private CustomMessageListener gWl = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gWQ.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gYc = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hnr = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hnj != null) {
                w Hi = AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi();
                long j = Hi.mLiveInfo.live_id;
                long j2 = Hi.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.hnj.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener hns = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bZv().hgE);
            if (AlaMasterLiveRoomOpearator.this.hmf == null || AlaMasterLiveRoomOpearator.this.hmf.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.vX(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gWN != null) {
                AlaMasterLiveRoomOpearator.this.gWN.LJ().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gWN.LK().hide();
            }
        }
    };
    private CustomMessageListener gYe = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.C(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi());
        }
    };
    private CustomMessageListener gYg = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gXa != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) AlaMasterLiveRoomOpearator.this.gXa).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hnt = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hnk != null) {
                    AlaMasterLiveRoomOpearator.this.hnk.hT(str);
                }
            }
        }
    };
    private CustomMessageListener bxu = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hnf != null) {
                        if (!data.aEf || AlaMasterLiveRoomOpearator.this.bxr == null || !AlaMasterLiveRoomOpearator.this.hnl) {
                            if (AlaMasterLiveRoomOpearator.this.bxr != null && AlaMasterLiveRoomOpearator.this.bxr == data.aEe) {
                                if (data.aDY != null && data.aDY.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hnl || AlaMasterLiveRoomOpearator.this.hmf.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hnf.a(AlaMasterLiveRoomOpearator.this.bZv().hgU.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bxt = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bZv().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bxr = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bZv().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hnf.a(AlaMasterLiveRoomOpearator.this.bZv().hgU.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bxt);
                        if (!AlaMasterLiveRoomOpearator.this.bxt) {
                            AlaMasterLiveRoomOpearator.this.bxt = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bxs) {
                    AlaMasterLiveRoomOpearator.this.bZv().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.bxs = false;
            }
        }
    };
    private CustomMessageListener bxv = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bZv().hgU != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bZv().hgU.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.AZ().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bmQ = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bmL == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bmL == 6) {
                            AlaMasterLiveRoomOpearator.this.cec();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bmL = 0;
            }
        }
    };
    private View.OnClickListener hnu = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hmD) {
                    AlaMasterLiveRoomOpearator.this.ceh();
                    AlaMasterLiveRoomOpearator.this.hmN.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hmC) {
                    if (view == AlaMasterLiveRoomOpearator.this.hmE) {
                        AlaMasterLiveRoomOpearator.this.bsT();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hmF) {
                        if (view != AlaMasterLiveRoomOpearator.this.hmH) {
                            if (view == AlaMasterLiveRoomOpearator.this.gZR) {
                                if (AlaMasterLiveRoomOpearator.this.ceb()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hng != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.gXi != null) && AlaMasterLiveRoomOpearator.this.gXi.Dl()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.gXi.ON() & (AlaMasterLiveRoomOpearator.this.gXi != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hng.bZx()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hng.bZy()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hng.bZz();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hmG) {
                                if (AlaMasterLiveRoomOpearator.this.hmj != null) {
                                    ap cgm = AlaMasterLiveRoomOpearator.this.bZv().hgD.cgm();
                                    if (cgm == null || cgm.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(cgm.mLiveSdkInfo.mRoomId);
                                        if (cgm.mLiveSdkInfo.mCastIds != null) {
                                            str2 = cgm.mLiveSdkInfo.mCastIds.chatMCastId;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.hmj.as("", str, str2);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hmI) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hng.bZx() || AlaMasterLiveRoomOpearator.this.hng.bZy() || AlaMasterLiveRoomOpearator.this.gXi.ON() || AlaMasterLiveRoomOpearator.this.gXi.Dl()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hnh != null) {
                                    AlaMasterLiveRoomOpearator.this.hnh.UM();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hmO != null) {
                            AlaMasterLiveRoomOpearator.this.hmO.Qj();
                            AlaMasterLiveRoomOpearator.this.hmO.cx(AlaMasterLiveRoomOpearator.this.cep());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.hnl = false;
                        AlaMasterLiveRoomOpearator.this.nx(true);
                        AlaMasterLiveRoomOpearator.this.hmJ.setVisibility(4);
                        com.baidu.live.d.AZ().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.aa.a.PQ().bod.aNo == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.aa.a.PQ().bod.aNn == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bmI) {
                        AlaMasterLiveRoomOpearator.this.cec();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bmL = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.cec();
                }
            }
        }
    };
    private CustomMessageListener gXX = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof aq) {
                    AlaMasterLiveRoomOpearator.this.gXz = true;
                    AlaMasterLiveRoomOpearator.this.hmK = (aq) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gWN != null) {
                        AlaMasterLiveRoomOpearator.this.gWN.LJ().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gWN != null) {
                        AlaMasterLiveRoomOpearator.this.gWN.LK().show();
                        AlaMasterLiveRoomOpearator.this.gWN.LK().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.vX(8);
                }
            }
        }
    };
    private CustomMessageListener hnv = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bZv() != null && AlaMasterLiveRoomOpearator.this.bZv().hha != null) {
                AlaMasterLiveRoomOpearator.this.bZv().hha.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bHB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.ceX();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bZv().hgD.we(i);
            }
        }
    };
    private CustomMessageListener gUt = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.ceQ();
        }
    };
    private CustomMessageListener gKZ = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ak.c)) {
                if (AlaMasterLiveRoomOpearator.this.gKY == null) {
                    AlaMasterLiveRoomOpearator.this.gKY = new com.baidu.live.ak.a(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.gKY.a((com.baidu.live.ak.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hnw = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Og()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                            AlaMasterLiveRoomOpearator.this.hmN.nE(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.hmN.cfv();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bZv().hgU.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hnh != null) {
                        AlaMasterLiveRoomOpearator.this.hnh.setMute(AlaMasterLiveRoomOpearator.this.bZv().hgU.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hmp != null) {
                        AlaMasterLiveRoomOpearator.this.hmp.setMute(AlaMasterLiveRoomOpearator.this.bZv().hgU.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hml != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hml.a(AlaMasterLiveRoomOpearator.this.bZv().hgX, AlaMasterLiveRoomOpearator.this.bZv().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bZv().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hml.wm(2);
                        AlaMasterLiveRoomOpearator.this.hml.a(AlaMasterLiveRoomOpearator.this.bZv().hgX, string, 3);
                    }
                }
            }
        }
    };
    private e.a hnx = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cfd() {
            AlaMasterLiveRoomOpearator.this.vW(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void cfe() {
            AlaMasterLiveRoomOpearator.this.vW(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hny = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean eO(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void eP(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bZv().cbr() == 1) {
                AlaMasterLiveRoomOpearator.this.bZv().hgU.stopRecord();
            }
        }
    };
    private IShareCallback hnz = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hmR && AlaMasterLiveRoomOpearator.this.hmQ != null) {
                AlaMasterLiveRoomOpearator.this.hmR = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hmQ);
            }
        }
    };
    private View.OnTouchListener hnA = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bZv().hha.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bZv().hgE);
            AlaMasterLiveRoomOpearator.this.vX(0);
            if (AlaMasterLiveRoomOpearator.this.gWN != null) {
                AlaMasterLiveRoomOpearator.this.gWN.LJ().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.gWN.LK().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hnB = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cff() {
            AlaMasterLiveRoomOpearator.this.ced();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cfg() {
            AlaMasterLiveRoomOpearator.this.hlM = AlaMasterLiveRoomOpearator.this.hmf.cbj();
            AlaMasterLiveRoomOpearator.this.bZv().hha.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bZv().hha.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bZv().hha.sampleMemAndCPU();
            d dVar = new d();
            dVar.hgO = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.bZv().cbr();
            dVar.title = AlaMasterLiveRoomOpearator.this.hmf.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hgP = AlaMasterLiveRoomOpearator.this.hmf.cbk();
            dVar.hgS = AlaMasterLiveRoomOpearator.this.hlM;
            dVar.hgR = AlaMasterLiveRoomOpearator.this.hmf.cbh();
            dVar.hgQ = AlaMasterLiveRoomOpearator.this.hmf.cbm();
            dVar.hgT = AlaMasterLiveRoomOpearator.this.hmf.cbi();
            if (dVar.hgT) {
                if (AlaMasterLiveRoomOpearator.this.hmf.cbn()) {
                    AlaMasterLiveRoomOpearator.this.hmR = true;
                    AlaMasterLiveRoomOpearator.this.hmQ = dVar;
                    AlaMasterLiveRoomOpearator.this.hmf.cbo();
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
            AlaMasterLiveRoomOpearator.this.bZv().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bZv().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cfh() {
            AlaMasterLiveRoomOpearator.this.hnl = true;
            AlaMasterLiveRoomOpearator.this.nx(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean cfi() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cfj() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener bjn = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bXz();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hnC = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Ob() {
            if (AlaMasterLiveRoomOpearator.this.hmj != null) {
                AlaMasterLiveRoomOpearator.this.hmj.nR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void ck(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hmO != null) {
                        AlaMasterLiveRoomOpearator.this.hmO.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hmO != null) {
                    AlaMasterLiveRoomOpearator.this.hmO.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hmj != null) {
                    AlaMasterLiveRoomOpearator.this.hmj.nR(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gXa != null) {
                    AlaMasterLiveRoomOpearator.this.gXa.bt(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hnD = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void afA() {
            if (AlaMasterLiveRoomOpearator.this.hmB != null && AlaMasterLiveRoomOpearator.this.bZv().hgX.indexOfChild(AlaMasterLiveRoomOpearator.this.hmB) >= 0) {
                AlaMasterLiveRoomOpearator.this.bZv().hgX.removeView(AlaMasterLiveRoomOpearator.this.hmB);
                AlaMasterLiveRoomOpearator.this.hmB.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hmB = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gWq = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void p(View view, int i) {
            w Hi;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.ceW();
            } else if (i == 14 && (Hi = AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi()) != null && Hi.aIV != null && Hi.mLiveInfo != null && Hi.aJr != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity(), Hi.aIV.userName, Long.toString(Hi.aIV.userId), Long.toString(Hi.aIV.charmCount), String.valueOf(Hi.mLiveInfo.group_id), String.valueOf(Hi.mLiveInfo.live_id), true, String.valueOf(Hi.aIV.userId), Long.toString(Hi.aJr.userId), Hi.aJr.userName, Hi.aJr.portrait, AlaMasterLiveRoomOpearator.this.gVM.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Hi.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gVM.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hnE = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private g hnF = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.azP);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hmc = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.aa.a.PQ().bod != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bZv().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.aa.a.PQ().bod.aNj, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HQ(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bZv().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bZv().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.aa.a.PQ().bod.aMH;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bZv().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : bZv().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bZv().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXz() {
        int i = bZv().hgD.Hi().aIV.isUegBlock;
        int i2 = bZv().hgD.Hi().aIV.isBlock;
        String str = bZv().hgD.Hi().aIV.userName;
        if (i > 0 || i2 > 0) {
            this.bmI = true;
            this.gWN.a(true, i, i2, str);
            return;
        }
        this.bmI = false;
        this.gWN.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gZK.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.blL == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.blM);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gZK.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.gZK.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ceb() {
        if (this.hnh != null && this.hnh.UN()) {
            BdUtilHelper.showToast(this.gZK.pageContext.getPageActivity(), this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hmp != null && this.hmp.QE()) {
            BdUtilHelper.showToast(this.gZK.pageContext.getPageActivity(), this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cec() {
        if (this.gWN != null) {
            this.gWN.LK().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hng != null) {
            this.hng.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ced() {
        if (bZv() != null && bZv().hgD != null) {
            bZv().hgD.cgf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bQQ() != null && aVar.bQR() != null) {
            bZv().hgD.ew(aVar.bQQ().getId(), aVar.bQR().getId());
        }
    }

    public void b(short s) {
        if (this.hnf != null) {
            this.hnf.b(s);
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
                    AlaMasterLiveRoomOpearator.this.hmT = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hmT = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hmU == 0) {
                    AlaMasterLiveRoomOpearator.this.hmU = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hmV == 0) {
                    AlaMasterLiveRoomOpearator.this.hmV = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hmW = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        if (bZv() != null && bZv().hgY != null) {
            bZv().hgY.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.gZK = eVar;
        this.gUi = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.e bZv() {
        return this.gZK;
    }

    public int a(f fVar) {
        this.gZS = fVar;
        this.hmS = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hmS, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hml == null) {
            this.hml = new com.baidu.tieba.ala.liveroom.tippop.a(this.gZK.pageContext, null);
        }
        registerListener();
        this.gVo = new com.baidu.live.g.a();
        cez();
        cee();
        ceg();
        Long[] lArr = new Long[1];
        this.hmX = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hmY = lArr[0] != null ? lArr[0].longValue() : 0L;
        bZv().hgE.setOnTouchListener(this.hnA);
        this.hmd = SharedPrefHelper.getInstance().getBoolean(hmc, false);
        this.hmq = new AlaLiveCountDownView(bZv().pageContext.getPageActivity());
        this.hmq.setCount(3);
        this.hmq.setTextColor(bZv().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hmq.setTextSize(bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hmq.setTypeface(Typeface.DEFAULT_BOLD);
        this.hmq.setIncludeFontPadding(false);
        this.hmq.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void cfk() {
                if (AlaMasterLiveRoomOpearator.this.bZv().hgE != null) {
                    AlaMasterLiveRoomOpearator.this.bZv().hgE.removeView(AlaMasterLiveRoomOpearator.this.hmq);
                }
            }
        });
        return 1;
    }

    private void cee() {
        CustomResponsedMessage runTask;
        if (this.hmo == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.k.a.class, bZv().pageContext)) != null && runTask.getData() != null) {
            this.hmo = (com.baidu.live.k.a) runTask.getData();
            this.hmo.c(bZv().pageContext);
        }
    }

    private void cef() {
        CustomResponsedMessage runTask;
        if (cem() && this.hmp == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.aj.b.class, bZv().pageContext)) != null && runTask.getData() != null) {
            this.hmp = (com.baidu.live.aj.b) runTask.getData();
            if (bZv() != null && bZv().hgD != null && bZv().hgD.Hi() != null) {
                this.hmp.setLiveShowData(bZv().hgD.Hi());
            }
            if (bZv() != null && bZv().hgU != null) {
                this.hmp.L(bZv().hgU);
                this.hmp.setMute(bZv().hgU.isMute());
            }
            if (this.hmp != null && this.hmy != null) {
                this.hmp.a(new com.baidu.live.aj.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                    @Override // com.baidu.live.aj.a
                    public boolean QG() {
                        if ((AlaMasterLiveRoomOpearator.this.gXi != null) && AlaMasterLiveRoomOpearator.this.gXi.Dl()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.gXi != null) & AlaMasterLiveRoomOpearator.this.gXi.ON()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hng == null || !AlaMasterLiveRoomOpearator.this.hng.bZx()) {
                            if (AlaMasterLiveRoomOpearator.this.hng == null || !AlaMasterLiveRoomOpearator.this.hng.bZy()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hmp.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hmy.setVisibility(0);
                    this.hmy.addView(enterView);
                }
            }
            if (this.hmp != null) {
                this.hmp.Y(bZv().hgV);
            }
            if (this.hmp != null && bZv().hgW != null) {
                this.hmp.a(bZv().hgW);
            }
        }
    }

    private void ceg() {
        View rootLayout;
        if (this.hmo != null && this.hmx != null && (rootLayout = this.hmo.cd(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hmx.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceh() {
        if (this.hmN == null) {
            this.hmN = new com.baidu.tieba.ala.liveroom.master.panel.b(bZv().pageContext.getPageActivity(), bZv().cbr() == 2);
            this.hmN.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nz(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bZv().hgU.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nA(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bZv().hgU.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nB(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bZv().hgU.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.ceV();
                    if (AlaMasterLiveRoomOpearator.this.hml != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hml.a(AlaMasterLiveRoomOpearator.this.bZv().hgX, AlaMasterLiveRoomOpearator.this.bZv().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hml.a(AlaMasterLiveRoomOpearator.this.bZv().hgX, AlaMasterLiveRoomOpearator.this.bZv().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nC(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cfl() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bZv().hgD != null && AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi() != null && AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                        AlaMasterLiveRoomOpearator.this.hmN.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.a(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cfm() {
                    if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                        AlaMasterLiveRoomOpearator.this.hmN.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.bZv().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cfn() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bZv() != null && AlaMasterLiveRoomOpearator.this.bZv().hgD != null && AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi() != null && AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(AlaMasterLiveRoomOpearator.this.bZv().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                            AlaMasterLiveRoomOpearator.this.hmN.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void cfo() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bZv() == null || AlaMasterLiveRoomOpearator.this.bZv().hgD == null || AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi() == null || AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bZv() != null && AlaMasterLiveRoomOpearator.this.bZv().hgD != null && AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi() != null && AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                                        AlaMasterLiveRoomOpearator.this.hmN.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.gZK.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hmN != null) {
                        AlaMasterLiveRoomOpearator.this.hmN.dismiss();
                    }
                }
            });
        }
        cei();
    }

    private void cei() {
        if (this.hmN != null) {
            boolean isBackCamera = bZv().hgU.isBackCamera();
            this.hmN.nD(bZv().hgU.isBackCamera());
            this.hmN.Q(bZv().hgU.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bZv().hgU.isPushMirror();
            if (this.hnc) {
                isPushMirror = ceU() || isPushMirror;
                this.hnc = false;
            }
            this.hmN.R(isPushMirror, isBackCamera ? false : true);
            this.hmN.nE(bZv().hgU.isMute());
            this.hmN.cfv();
        }
    }

    public void cej() {
        if (this.gZS != null) {
            if (this.gZS.hhd == null || this.gZS.hhd.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hmz == null) {
                        this.hmz = this.gZK.hhc.ND();
                        this.gZK.hgX.addView(this.hmz, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hmf == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bZv().hgD != null && bZv().hgD.Hi() != null && bZv().hgD.Hi().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bZv().hgD.Hi().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bZv().hgD.Hi().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hmf = new com.baidu.tieba.ala.liveroom.h.d(bZv().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bZv().hha.prepareTime = System.currentTimeMillis();
                    bZv().hgX.addView(this.hmf.getView(), layoutParams);
                    this.hmf.a(this.hnz);
                }
                this.hmf.nf(this.hgR);
                this.hmf.a(this.hnB);
                this.hmf.a(this.hnx);
                this.hmf.a(bZv().hgU, bZv().cbr());
                this.hmf.a(this.hmo);
                return;
            }
            this.hlM = this.gZS.hhd.mLiveInfo.screen_direction == 2;
            if (this.gZS.hhd.mLiveInfo.isAudioOnPrivate == 1) {
                bZv().hgU.setMute(true);
                if (this.hnh != null) {
                    this.hnh.setMute(bZv().hgU.isMute());
                }
                if (this.hmp != null) {
                    this.hmp.setMute(bZv().hgU.isMute());
                }
                if (this.hml == null) {
                    this.hml = new com.baidu.tieba.ala.liveroom.tippop.a(this.gZK.pageContext, null);
                }
                if (!this.hml.wl(2)) {
                    this.hml.a(bZv().hgX, bZv().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, true);
                }
            }
            d dVar = new d();
            dVar.hgO = true;
            dVar.forumId = String.valueOf(this.gZS.hhd.mLiveInfo.forum_id);
            dVar.forumName = this.gZS.hhd.mLiveInfo.forum_name;
            dVar.liveType = this.gZS.hhd.mLiveInfo.live_type;
            dVar.title = this.gZS.hhd.mLiveInfo.getLiveTitle();
            dVar.clarity = this.gZS.hhd.mLiveInfo.clarity;
            dVar.gameId = this.gZS.hhd.mLiveInfo.game_id;
            dVar.gameName = this.gZS.hhd.mLiveInfo.game_label;
            dVar.hgS = this.gZS.hhd.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void cek() {
        if (this.hnf != null) {
            this.hnf.a(bZv().hgU.getVideoConfig(), false);
        }
        if (this.hmf != null) {
            this.hmf.ne(true);
        }
        if (bZv().hgU.hasBeauty() >= 0) {
            bZv().hgU.setBeauty(com.baidu.live.d.AZ().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bZv().hhc.I(this.gZK.hgU);
        } else if (this.hmf != null) {
            this.hmf.ne(true);
        }
        cey();
    }

    public void d(d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hmz != null && this.hmz.getParent() != null) {
                ((ViewGroup) this.hmz.getParent()).removeView(this.hmz);
                this.hmz = null;
            }
            bZv().hgE.setVisibility(0);
            this.gZK.hhc.a(bZv().hgE);
        } else {
            ceG();
            ceT();
            if (this.hnn != null) {
                this.hnn.setVisibility(0);
            }
            this.hmj = new com.baidu.tieba.ala.liveroom.x.a(bZv().pageContext, this.hny);
            this.hmj.d(bZv().hgE, true);
            this.hmj.nR(true);
            if (this.gWN != null && this.gWN.LJ() != null) {
                this.gWN.LJ().setNeedTopAlphaShade(true);
            }
        }
        bZv().hgU.setPushMirror(ceU());
    }

    public void b(ap apVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gZK.hhc.k(bZv().hgD.Hi());
        }
        if (!bZv().hgU.isBackground() && bZv().hgD.Hi() != null && bZv().hgD.Hi().mLiveInfo != null) {
            int startPush = bZv().hgU.startPush(bZv().hgD.Hi().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gZK.hhc.NE();
            }
            if (startPush != 0 && bZv().hha != null) {
                bZv().hha.errCode = 4;
                bZv().hha.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (apVar != null && !apVar.EK() && !ceR()) {
                ny(true);
                ceS();
            }
            if (this.gVJ != null) {
                this.gVJ.H(bZv().hgD.Hi());
            }
            if (this.gWz != null) {
                this.gWz.a(bZv().hgD.Hi());
            }
            if (this.hmo != null) {
                this.hmo.e(bZv().hgD.Hi());
                this.hmo.hN(this.otherParams);
            }
            if (this.gVJ != null) {
                this.gVJ.ns(true);
            }
            if (this.hmg != null) {
                this.hmg.H(bZv().hgD.Hi());
            }
            if (apVar == null || apVar.aIV == null) {
                z = com.baidu.live.d.AZ().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = apVar.aIV.canUseChallenge;
                com.baidu.live.d.AZ().putBoolean("ala_master_can_use_challenge", z);
            }
            bYt();
            ceH();
            cer();
            nw(z);
            bXk();
            ceI();
            ceM();
            I(bZv().hgD.Hi());
            f(bZv().hgD.Hi());
            ceN();
            ceO();
            cel();
            ceL();
            bYq();
            bYs();
            bXj();
            bYe();
            bYm();
            bYn();
            ceE();
            ceF();
            J(bZv().hgD.Hi());
            bYf();
            if (this.gWM != null) {
                this.gWM.g(bZv().hgD.Hi());
            }
            if (this.gWN != null) {
                if (bZv().hgD.Hi() != null && bZv().hgD.Hi().aJH != null && bZv().hgD.Hi().aJH.Ea()) {
                    z2 = true;
                }
                this.gWN.a(String.valueOf(bZv().hgD.Hi().mLiveInfo.group_id), String.valueOf(bZv().hgD.Hi().mLiveInfo.last_msg_id), String.valueOf(bZv().hgD.Hi().aIV.userId), String.valueOf(bZv().hgD.Hi().mLiveInfo.live_id), bZv().hgD.Hi().aIV.appId, z2);
            }
            if (this.gWO != null) {
                this.gWO.a(bZv().hgD.Hi(), true);
            }
            cen();
            cef();
            bYx();
            this.mHandler.post(this.hnp);
        }
    }

    protected void bYx() {
        if (this.gXs == null && bZv() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.q.a.class, bZv().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.gXs = (com.baidu.live.q.a) runTask.getData();
                this.gXs.q(bZv().hgE);
            }
        }
    }

    private void cel() {
        if (this.hmh != null && bZv() != null && bZv().hgD != null) {
            if (this.hmh.ay(this.hmu)) {
                this.hmh.B(bZv().hgD.Hi());
            } else {
                this.hmh.c(this.hmu, bZv().hgD.Hi());
            }
        }
    }

    private void bXk() {
        if (this.brz == null) {
            this.brz = new PendantParentView(bZv().pageContext.getPageActivity(), this.gYv ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bZv().hgE.addView(this.brz, layoutParams);
            this.brz.setDefaultItemMargin(bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.brz.setPadding(bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            bYY();
        }
    }

    private void bYY() {
        if (this.brz != null) {
            int dimensionPixelSize = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.brz.getLayoutParams();
            if (this.gYv) {
                this.brz.setPosition(0, 0, this.hng.bZe(), dimensionPixelSize2);
            } else {
                this.brz.setPosition(dimensionPixelSize, 0, bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278), dimensionPixelSize2);
            }
            this.brz.setLayoutParams(layoutParams);
            this.brz.setModel(this.gYv ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bYZ() {
        if (this.gWN != null && this.gWN.LJ() != null && this.gWN.LJ().getView() != null) {
            if (this.gYv && !this.hme && bZv().hgE != null && bZv().hgE.getHeight() > 0) {
                int bk = this.hng != null ? this.hng.bk(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.gWN.LJ().getView().getLayoutParams();
                int height = bZv().hgE.getHeight() - bk;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.gWN.LJ().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.ag.b.i(false, this.hme);
            if (bZv().hgE.indexOfChild(this.gWN.LJ().getView()) != -1 && this.gWN.LJ().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWN.LJ().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.gWN.LJ().getView().setLayoutParams(layoutParams2);
            }
            this.gWN.LJ().LI();
        }
    }

    private void bZa() {
        if (this.gWP != null) {
            if (this.gYv && !this.hme && bZv().hgE != null && bZv().hgE.getHeight() > 0) {
                this.gWP.dU((bZv().hgE.getHeight() - (this.hng != null ? h.k(bZv().pageContext.getPageActivity(), true) : 0)) + bZv().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.gWP.dU(com.baidu.live.ag.a.a(bZv().pageContext.getPageActivity(), true, false, this.hme));
            }
        }
    }

    private void bZb() {
        int i;
        if (this.gWP != null) {
            int h = com.baidu.live.ag.a.h(true, false);
            if (!this.gYv || bZv().hgE == null || bZv().hgE.getHeight() <= 0) {
                i = h;
            } else {
                i = (bZv().hgE.getHeight() - (this.hng != null ? this.hng.bk(false) : 0)) + bZv().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.gWP.dV(i);
        }
    }

    private void bZc() {
        if (this.gWO != null && this.gWO.CK() != null) {
            ViewGroup.LayoutParams layoutParams = this.gWO.CK().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bZv().pageContext.getResources().getDimensionPixelOffset(this.gYv ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.gWO.CK().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean cem() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = bZv().hgD.Hi().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void cen() {
        if (this.hmp == null && !cem()) {
            boolean z = (bZv().hgD == null || bZv().hgD.cgm() == null || bZv().hgD.cgm().mLiveInfo.videoBBChatData == null || !bZv().hgD.cgm().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && bZv().hgD != null && bZv().hgD.Hi() != null && bZv().hgD.Hi().mLiveInfo != null && bZv().hgD.Hi().mLiveInfo.videoBBChatData != null && bZv().hgD.Hi().aJD) {
                z = bZv().hgD.Hi().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hmI != null) {
                this.hmI.setVisibility(z ? 0 : 8);
            }
            ceo();
        }
    }

    private void ceo() {
        CustomResponsedMessage runTask;
        if (this.hnh == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.ai.a.class, bZv().pageContext)) != null && runTask.getData() != null) {
            this.hnh = (com.baidu.live.ai.a) runTask.getData();
        }
        if (this.hnh != null) {
            this.hnh.z((ViewGroup) bZv().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hnh.y(bZv().hgX);
            this.hnh.s(bZv().hgD.Hi());
            this.hnh.L(bZv().hgU);
            this.hnh.a(bZv().hgW);
            this.hnh.a(this.bGU);
            if (bZv().hgU != null) {
                this.hnh.setMute(bZv().hgU.isMute());
            }
        }
    }

    private void nw(boolean z) {
        if (this.hng == null) {
            this.hng = new com.baidu.tieba.ala.liveroom.challenge.e(bZv());
        }
        this.hng.a(this.gZR, this.gZS, z);
        this.hng.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(az azVar, bd bdVar, bd bdVar2) {
                AlaMasterLiveRoomOpearator.this.gYv = true;
                AlaMasterLiveRoomOpearator.this.bZv().hgE.hwh = false;
                if (AlaMasterLiveRoomOpearator.this.hmO != null) {
                    AlaMasterLiveRoomOpearator.this.hmO.ff(4);
                    AlaMasterLiveRoomOpearator.this.hmO.cx(true);
                }
                AlaMasterLiveRoomOpearator.this.Wp();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void Dr() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hnp);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bZt() {
                AlaMasterLiveRoomOpearator.this.gYv = false;
                AlaMasterLiveRoomOpearator.this.bZv().hgE.hwh = false;
                if (AlaMasterLiveRoomOpearator.this.hmO != null) {
                    AlaMasterLiveRoomOpearator.this.hmO.ff(0);
                    AlaMasterLiveRoomOpearator.this.hmO.cx(false);
                }
                AlaMasterLiveRoomOpearator.this.ceq();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bZu() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hnp);
            }
        });
        this.hng.N(this.hlM, z);
        this.hng.j(this.hlM, z, (this.gZS == null || this.gZS.hhd == null || this.gZS.hhd.mChallengeData == null) ? false : true);
    }

    public boolean cep() {
        return this.hng != null && this.hng.bZC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wp() {
        if (this.hmk != null) {
            this.hmk.setVisible(8);
            this.hmk.setCanVisible(false);
        }
        if (this.gVO != null) {
            this.gVO.mG(true);
        }
        if (this.hmr != null) {
            this.hmr.setCanVisible(false);
            this.hmr.setVisibility(4);
        }
        if (this.hmj != null) {
            this.hmA = this.hmj.ciy();
            this.hmj.nQ(false);
        }
        if (this.gXi != null) {
            this.gXi.setCanVisible(false);
        }
        if (this.gVV != null) {
            this.gVV.setCanVisible(false);
        }
        bYY();
        bYZ();
        bZa();
        bZb();
        bZc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceq() {
        if (this.hmk != null) {
            this.hmk.setCanVisible(true);
        }
        if (this.gVO != null) {
            this.gVO.mG(false);
        }
        if (this.hmr != null) {
            this.hmr.setCanVisible(true);
        }
        if (this.hmj != null) {
            this.hmj.nQ(this.hmA);
        }
        if (this.gXi != null) {
            this.gXi.setCanVisible(true);
        }
        if (this.gVV != null) {
            this.gVV.cv(true);
        }
        bYY();
        bYZ();
        bZa();
        bZb();
        bZc();
    }

    private void cer() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hmr == null) {
            this.hmr = new AlaLiveStreamStatusView(bZv().pageContext.getPageActivity());
        }
        this.hmr.setId(a.f.ala_live_room_stream_view);
        this.hmr.setVisibility(4);
        this.hmr.setLayoutParams(layoutParams);
        if (this.hmr.getParent() == null && this.hmu != null) {
            this.hmu.addView(this.hmr, layoutParams);
        }
    }

    public void ces() {
        if (this.hmf != null && this.hmf.getVisibility() != 8 && bZv().hgU.getPreview() != null) {
            bZv().hgU.stopRecord();
        }
    }

    public void cet() {
        if (bZv().hgU.getPreview() != null) {
            bZv().hgU.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hnf != null) {
                this.hnf.nd(false);
            }
            this.hnf = new com.baidu.tieba.ala.liveroom.h.b(bZv().hgX, bZv(), bZv().hgU);
            this.hnf.a(bZv().hgU.getVideoConfig(), false);
        }
        if (this.hml != null) {
            this.hml.chs();
        }
        this.mHandler.post(this.hnp);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hme = z;
        if (z) {
            if (this.hne) {
                this.hne = false;
                if (this.gWN != null && this.gWN.LJ() != null) {
                    this.gWN.LJ().getView().setBottom(0);
                }
                if (this.gWN != null && this.gWN.LK() != null) {
                    this.gWN.LK().getView().setBottom(0);
                }
            }
            if (this.gWP != null && this.gWP.GH() != null) {
                this.gWP.GH().setVisibility(8);
            }
            if (this.gWN != null && this.gWN.LJ() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gWN.LJ().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.gWN.LJ().getView().setLayoutParams(layoutParams);
            }
            if (this.gWN != null && this.gWN.LK() != null && this.gWN.LK().getView() != null && this.gWN.LK().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gWN.LK().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gWN.LK().getView().setLayoutParams(layoutParams2);
                this.gWN.LK().getView().setVisibility(0);
                this.gWN.LK().Nl();
            }
            vX(8);
            vV(8);
            if (this.gWQ != null && this.gWQ.Hh() != null) {
                this.gWQ.Hh().setVisibility(8);
            }
        } else {
            if (this.gWP != null && this.gWP.GH() != null) {
                this.gWP.GH().setVisibility(0);
            }
            if (this.gWN != null && this.gWN.LJ() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gWN.LJ().getView().getLayoutParams();
                layoutParams3.bottomMargin = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.gWN.LJ().getView().setLayoutParams(layoutParams3);
            }
            if (this.gWN != null && this.gWN.LK() != null) {
                this.gWN.LK().hide();
            }
            vX(0);
            vV(0);
            if (this.gWQ != null && this.gWQ.Hh() != null) {
                this.gWQ.Hh().setVisibility(0);
            }
        }
        if (this.hmf != null) {
            this.hmf.P(false, z);
        }
        if (this.gWO != null) {
            this.gWO.CL();
        }
        if (this.hmO != null) {
            this.hmO.onKeyboardVisibilityChanged(z);
        }
        if (this.gXs != null) {
            this.gXs.onKeyboardVisibilityChanged(z);
        }
        bYZ();
        this.mHandler.post(this.hnp);
    }

    private void vV(int i) {
        if (this.gVJ != null) {
            this.gVJ.vJ(i);
        }
        if (this.hmt != null) {
            this.hmt.setVisibility(i);
        }
        if (this.gWz != null) {
            this.gWz.getView().setVisibility(i);
        }
        if (this.hmi != null) {
            this.hmi.setVisible(i);
        }
        if (this.hmh != null) {
            this.hmh.setVisibility(i);
        }
        if (this.gVO != null) {
            this.gVO.setVisible(i);
        }
        if (this.gXo != null) {
            this.gXo.setCanVisible(i == 0);
        }
        if (this.gXk != null) {
            this.gXk.setVisible(i);
        }
        if (this.gXh != null) {
            this.gXh.setCanVisible(i == 0);
        }
        if (this.gXi != null) {
            this.gXi.setCanVisible(i == 0 && !this.gYv);
        }
        if (this.gVV != null) {
            this.gVV.cv(i == 0);
        }
        if (this.hni != null) {
            this.hni.setCanVisible(i == 0);
            this.hni.refreshUI();
        }
        if (this.hmu != null) {
            this.hmu.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bZv().hha.errCode = 1;
            vW(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            vW(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            vW(a.h.stream_upload_exception);
        } else if (i == -2) {
            Ii(bZv().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            bZv().hgU.stopRecord();
        } else if (i == -3 && this.hmf != null) {
            this.hmf.ne(false);
        }
        if (i == -4) {
            if (this.hmf == null || this.hmf.getView().getParent() == null) {
                bZv().g((short) 1);
                return;
            }
            this.hmf.cbl();
            this.hmF.setVisibility(0);
            if (this.hmj != null) {
                this.hmj.nR(true);
            }
            bZv().hgE.setBackgroundColor(bZv().pageContext.getResources().getColor(17170445));
            cfa();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        avS();
        if (i == 12001) {
            if (i2 == -1) {
                Ij(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            bsT();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hmf == null || this.hmf.getView().getParent() == null || this.hmf.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hmf != null) {
            this.hmf.onResume();
        }
        if (this.hmR && this.hmQ != null) {
            this.hmR = false;
            c(this.hmQ);
        }
        if (this.gXa != null) {
            this.gXa.onResume();
        }
    }

    public void h(short s) {
        if (this.gWM != null) {
            this.gWM.Ht();
        }
        if (this.gWN != null) {
            this.gWN.a(null);
            this.gWN.CM();
        }
        if (this.gWO != null) {
            this.gWO.CM();
        }
        if (this.hng != null) {
            this.hng.bZB();
        }
    }

    public boolean ceu() {
        w Hi = bZv().hgD.Hi();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gZK.hhc.j(Hi);
            if (Hi != null && Hi.mLiveInfo.live_status != 1) {
                ceY();
                bZv().pageContext.getPageActivity().finish();
                if (bZv().hgD != null && bZv().hgD.Hi() != null) {
                    a(Hi, 1, bZv().hgD.cgv() != 1 ? bZv().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gWN != null) {
                this.gWN.LJ().b(String.valueOf(Hi.mLiveInfo.group_id), String.valueOf(Hi.mLiveInfo.live_id), true, String.valueOf(Hi.aIV.userId));
            }
            if (this.gWO != null) {
                this.gWO.a(Hi);
            }
            if (this.gWz != null) {
                this.gWz.a(bZv().hgD.Hi());
            }
            if (this.gVJ != null) {
                this.gVJ.H(Hi);
            }
            if (Hi != null) {
                if (this.hng != null) {
                    this.hng.a(Hi);
                }
                if (this.gWQ != null && Hi.mLiveInfo != null) {
                    this.gWQ.a(Hi.mLiveInfo, Hi.aIV);
                }
                if (this.gXo != null) {
                    this.gXE = this.gXo.o(Hi);
                }
                if (this.gVO != null) {
                    this.gVO.mH(this.gXE);
                    this.gVO.i(Hi);
                    this.gVO.updateView();
                }
                if (this.gXh != null) {
                    this.gXh.a(Hi);
                }
                if (this.gXi != null) {
                    this.gXi.a(Hi);
                }
                if (this.gXj != null) {
                    this.gXj.a(Hi);
                }
                if (this.gXk != null) {
                    this.gXk.a(Hi);
                }
                if (Hi.mLiveInfo.live_status != 1) {
                    ceY();
                    bZv().pageContext.getPageActivity().finish();
                    if (bZv().hgD != null && bZv().hgD.Hi() != null) {
                        a(Hi, 1, bZv().hgD.cgv() != 1 ? bZv().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.hmo != null) {
                    this.hmo.h(Hi);
                }
            }
        }
        return false;
    }

    public void cev() {
        cei();
    }

    public void cew() {
        if (this.hnf != null) {
            this.hnf.cbf();
        }
    }

    public void cex() {
        if (this.hmf != null && this.hmf.getVisibility() != 8) {
            if (bZv().cbr() == 2) {
                cfa();
            } else {
                ceZ();
            }
        }
        if (this.hmf != null && this.hmf.getVisibility() != 8) {
            if (bZv().cbr() == 1) {
                this.hmf.onResume();
            }
            this.hmf.onRefresh();
        }
        if (this.hmo != null) {
            this.hmo.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.gXz && this.hmK != null) {
            if (this.gWN != null) {
                this.gWN.LJ().getView().setVisibility(0);
            }
            if (this.gWN != null) {
                this.gWN.LK().show();
                this.gWN.LK().setEditText(" @" + this.hmK.getNameShow() + " ");
            }
            vX(8);
            this.gXz = false;
        }
        if (this.hnj != null) {
            this.hnj.resume();
        }
        if (this.hnk != null) {
            this.hnk.resume();
        }
        if (this.gKY != null) {
            this.gKY.resume();
        }
    }

    public void onPause() {
        if (this.hmo != null) {
            this.hmo.onPause();
        }
        if (this.hnj != null) {
            this.hnj.pause();
        }
        if (this.gXa != null) {
            this.gXa.onPause();
        }
        if (this.hnk != null) {
            this.hnk.pause();
        }
        if (this.gKY != null) {
            this.gKY.pause();
        }
    }

    private void cey() {
        if (bl.c(com.baidu.live.aa.a.PQ().btT)) {
            this.hmF.setVisibility(0);
            this.hmF.setAlpha(0.2f);
        } else if (bZv().hgU.hasBeauty() < 0) {
            this.hmF.setVisibility(8);
        } else {
            this.hmF.setVisibility(0);
        }
    }

    private void cez() {
        this.hms = (RelativeLayout) bZv().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hmv = (RelativeLayout) bZv().rootView.findViewById(a.f.under_live_view_panel);
        this.hmw = (RelativeLayout) bZv().rootView.findViewById(a.f.over_live_view_panel);
        this.hmx = (FrameLayout) bZv().rootView.findViewById(a.f.goods_parent);
        this.hmy = (FrameLayout) bZv().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.gZK.hgE.setOnLiveViewScrollListener(this.hnC);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hmv.setVisibility(8);
            this.hmw.setVisibility(8);
            bZv().hgE.removeAllViews();
            return;
        }
        this.hmt = (RelativeLayout) bZv().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hmt.getLayoutParams();
        layoutParams.topMargin = this.gZK.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hmt.setLayoutParams(layoutParams);
        this.hmu = (RelativeLayout) bZv().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.gVM == null) {
            this.gVM = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gZK.pageContext.getPageActivity(), false);
        }
        this.gVM.a(this.gWq);
        this.gVM.a(this.hmt, a.f.ala_live_room_host_header_stub, 1L);
        this.gVM.setVisible(0);
        ceA();
        this.hmF = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hmJ = (TextView) bZv().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hmF.setOnClickListener(this.hnu);
        this.hmH = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hmH.setOnClickListener(this.hnu);
        if (com.baidu.live.aa.a.PQ().btT != null && com.baidu.live.aa.a.PQ().btT.aPv != null && com.baidu.live.aa.a.PQ().btT.aPv.EP() && bl.b(com.baidu.live.aa.a.PQ().btT)) {
            this.hmH.setVisibility(0);
        } else {
            this.hmH.setVisibility(8);
        }
        cey();
        this.hmE = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hmE.setOnClickListener(this.hnu);
        this.hmC = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hmC.setOnClickListener(this.hnu);
        this.gZR = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.gZR.setOnClickListener(this.hnu);
        this.hmI = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hmI.setOnClickListener(this.hnu);
        this.hmD = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hmD.setOnClickListener(this.hnu);
        this.hmG = (ImageView) bZv().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hmG.setOnClickListener(this.hnu);
        ceD();
        if (bl.b(com.baidu.live.aa.a.PQ().btT)) {
            this.hnf = new com.baidu.tieba.ala.liveroom.h.b(bZv().hgX, bZv(), bZv().hgU);
        }
        this.gWM = new m();
        ceB();
        ceC();
        if (com.baidu.live.d.AZ().getInt("beauty_new_bubble", 1) == 1) {
            this.hmJ.setVisibility(0);
        }
    }

    private void ceA() {
        this.hnn = (FrameLayout) View.inflate(bZv().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hnn != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hnn.setVisibility(8);
            if (this.hnn.getParent() != null && (this.hnn.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hnn.getParent()).removeView(this.hnn);
            }
            this.hms.addView(this.hnn, layoutParams);
            if (this.hnn != null) {
                this.hnn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.gWq.p(AlaMasterLiveRoomOpearator.this.hnn, 8);
                    }
                });
            }
        }
    }

    private void ceB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bZv().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gWN = (k) runTask.getData();
            this.gWN.setFromMaster(true);
            this.gWN.LJ().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bZv().pageContext.getPageActivity()) * 0.75f), com.baidu.live.ag.b.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.ag.b.cU(true);
            bZv().hgE.addView(this.gWN.LJ().getView(), layoutParams);
            this.gWN.LK().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bZv().hgE.addView(this.gWN.LK().getView(), layoutParams2);
            this.gWN.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // com.baidu.live.im.k.a
                public boolean LM() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void LN() {
                }

                @Override // com.baidu.live.im.k.a
                public void hJ(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void LO() {
                }

                @Override // com.baidu.live.im.k.a
                public void LP() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean LQ() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int LR() {
                    return 0;
                }
            });
        }
    }

    private void ceC() {
        View CK;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bZv().pageContext);
        if (runTask != null) {
            this.gWO = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gWO != null && (CK = this.gWO.CK()) != null && this.gZK.hgE.indexOfChild(CK) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gZK.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bZv().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            bZv().hgE.addView(CK, layoutParams);
        }
    }

    private void ceD() {
        CustomResponsedMessage runTask;
        if (this.hmM == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ad.a.class, bZv().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hmM = (com.baidu.live.ad.a) runTask.getData();
        }
    }

    private void ceE() {
        View GG;
        aa.d(bZv().hgD.Hi());
        aa.b(bZv().pageContext, true);
        aa.Hp();
        if (this.gWP == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aUa = true;
            fVar.context = bZv().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ab.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWP = (ab) runTask.getData();
                if (this.gWP != null && (GG = this.gWP.GG()) != null && bZv().hgE.indexOfChild(GG) < 0) {
                    if (GG.getParent() instanceof ViewGroup) {
                        ((ViewGroup) GG.getParent()).removeView(GG);
                    }
                    bZv().hgE.addView(GG, bZv().hgE.getLayoutParams());
                }
            }
        }
    }

    private void ceF() {
        if (!this.hno) {
            this.hno = true;
            com.baidu.live.entereffect.a.Fg().requestData(true);
        }
    }

    protected void bYn() {
        View Hh;
        if (this.gWQ == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aUa = true;
            aVar.context = bZv().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, z.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gWQ = (z) runTask.getData();
            }
        }
        if (this.gWQ != null && (Hh = this.gWQ.Hh()) != null && this.hmu != null) {
            if (this.hmu.indexOfChild(Hh) < 0) {
                if (Hh.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Hh.getParent()).removeView(Hh);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hmi != null && this.hmi.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.gXk != null && this.gXk.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.gXj != null && this.gXj.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hmu.addView(Hh, layoutParams);
            }
            Hh.bringToFront();
        }
    }

    protected void bYm() {
        View Hu;
        if (this.gXa == null) {
            ai aiVar = new ai();
            aiVar.aUa = true;
            aiVar.pageContext = bZv().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ae.class, aiVar);
            if (runTask != null && runTask.getData() != null) {
                this.gXa = (ae) runTask.getData();
            }
        }
        if (this.gXa != null && (Hu = this.gXa.Hu()) != null && bZv().hgE.indexOfChild(Hu) < 0) {
            if (Hu.getParent() instanceof ViewGroup) {
                ((ViewGroup) Hu.getParent()).removeView(Hu);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            bZv().hgE.addView(Hu, layoutParams);
        }
    }

    private void ceG() {
        ceK();
        bYr();
        ceJ();
        bZv().hgE.setVisibility(0);
        vX(0);
    }

    private void ceH() {
        if (this.hmi == null) {
            this.hmi = new com.baidu.tieba.ala.liveroom.v.a(bZv().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hmi.a(bZv().cbr(), j, TbadkCoreApplication.getCurrentAccountName(), true, bZv().hgD.Hi().aIV.portrait, this.otherParams, "", -1L);
        this.hmi.ax(this.hmu);
    }

    private void ceI() {
        if (this.hmO == null) {
            bZv().hgE.hwh = false;
            com.baidu.live.ab.a fc = fc(bZv().pageContext.getPageActivity());
            if (fc != null) {
                this.hmO = fc;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.ab.a.class, bZv().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hmO = (com.baidu.live.ab.a) runTask.getData();
                }
            }
            if (this.hmO != null) {
                this.hmO.u(this.hmv);
                this.hmO.v(this.hmw);
                this.hmO.fe((bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - bZv().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hmO.w(bZv().hgE);
                this.hmO.a(this.gVo);
                this.hmO.setLiveShowInfo(bZv().hgD.Hi());
                this.hmO.a(this.gVO);
                this.hmO.Qk();
                this.hmO.a(new a.InterfaceC0168a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                    @Override // com.baidu.live.ab.a.InterfaceC0168a
                    public void Ql() {
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0168a
                    public void Qm() {
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0168a
                    public void J(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bZv().hgU != null) {
                            AlaMasterLiveRoomOpearator.this.bZv().hgU.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0168a
                    public int Qn() {
                        return AlaMasterLiveRoomOpearator.this.hmt.getBottom();
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0168a
                    public int Qo() {
                        return AlaMasterLiveRoomOpearator.this.gZK.hgE.getHeight() - (AlaMasterLiveRoomOpearator.this.gWN.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gWN.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0168a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gWN.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.ab.a.InterfaceC0168a
                    public int Qp() {
                        return AlaMasterLiveRoomOpearator.this.gWN.LL();
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

    private void ceJ() {
        if (this.hmk == null) {
            this.hmk = new b(bZv().pageContext, bZv().hgE);
        }
    }

    private void ceK() {
        if (this.gVJ == null) {
            this.gVJ = new com.baidu.tieba.ala.liveroom.p.a(bZv().pageContext, true, this.hny);
            this.gVJ.d(this.hmt, null);
            this.gVJ.a(this.gWq);
            this.gVJ.ns(false);
        }
        if (this.hmg == null) {
            this.hmg = new com.baidu.tieba.ala.liveroom.p.a(bZv().pageContext, true, null);
            this.hmg.a(this.hmt, null, a.f.ala_live_room_host_header_stub);
            this.hmg.cdc();
        }
    }

    protected void bXU() {
        CustomResponsedMessage runTask;
        boolean z = false;
        ap cgm = bZv().hgD.cgm();
        boolean z2 = com.baidu.live.aa.a.PQ().bod.aNi;
        if (cgm == null || cgm.aJF) {
            z = z2;
        }
        if (z && this.gWz == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bZv().pageContext)) != null) {
            this.gWz = (com.baidu.live.h.a) runTask.getData();
            if (this.gWz != null) {
                this.gWz.setIsHost(true);
                this.gWz.eF(1);
                View view = this.gWz.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bZv().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bZv().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hmt.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(w wVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gVO == null) {
            this.gVO = new com.baidu.tieba.ala.liveroom.activeview.b(bZv().pageContext);
        }
        this.gVO.setOtherParams(this.otherParams);
        this.gVO.b(wVar, false);
        this.gVO.setHost(true);
        this.gVO.a(1, this.brz);
        this.gVO.a(2, this.brz);
        this.gVO.mH(this.gXE);
        this.gVO.setVisible(this.hme ? 8 : 0);
        this.gVO.a(this.gVo);
        if (this.gVo != null) {
            if (this.gVO != null) {
                alaActiveRootView2 = this.gVO.vp(1);
                alaActiveRootView = this.gVO.vp(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.gVo.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.gVo.a(alaActiveRootView);
            }
        }
    }

    private void I(w wVar) {
        CustomResponsedMessage runTask;
        if (this.gXo == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bZv().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.w.a)) {
            this.gXo = (com.baidu.live.w.a) runTask.getData();
            if (this.gXo != null) {
                this.gXo.t(this.brz);
            }
        }
        if (this.gXo != null) {
            this.gXE = this.gXo.o(wVar);
            this.gXo.setCanVisible(!this.hme);
        }
    }

    protected void ceL() {
        CustomResponsedMessage runTask;
        if (bZv() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.j.a.class, bZv().pageContext.getPageActivity())) != null && runTask.getData() != null && this.gXh == null) {
            this.gXh = (com.baidu.live.j.a) runTask.getData();
            this.gXh.b(this.hmu, bYD());
            if (bZv().hgD != null) {
                this.gXh.a(bZv().hgD.Hi());
            }
            this.gXh.setCanVisible(true);
            this.gXh.bS(false);
            this.gXh.a(bZv().hgD.bRq());
        }
    }

    protected void bYq() {
        CustomResponsedMessage runTask;
        if (bZv() != null && this.gXi == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.r.a.class, bZv().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gXi = (com.baidu.live.r.a) runTask.getData();
            this.gXi.setIsHost(true);
            this.gXi.b(this.brz, bZv().hgD.Hi());
        }
    }

    protected void bXj() {
        if (bZv() != null) {
            if (this.gVV == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.z.a.class, bZv().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gVV = (com.baidu.live.z.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gVV.setIsHost(true);
            this.gVV.a(this.brz, bZv().hgD.Hi().aJT);
        }
    }

    protected void bYs() {
        CustomResponsedMessage runTask;
        if (bZv() != null && this.gXj == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.i.a.class, bZv().pageContext)) != null && runTask.getData() != null) {
            this.gXj = (com.baidu.live.i.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.gXj.a(this.hmu, bZv().hgD.Hi(), layoutParams, this.otherParams);
        }
    }

    private void J(w wVar) {
        CustomResponsedMessage runTask;
        if (bZv() != null) {
            if (this.hmm == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.r.d.class)) != null) {
                this.hmm = (com.baidu.live.r.d) runTask.getData();
            }
            if (this.hmm != null) {
                this.hmm.OO();
            }
            if (this.hmn == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, com.baidu.live.r.c.class);
                if (runTask2 != null) {
                    this.hmn = (com.baidu.live.r.c) runTask2.getData();
                }
                if (this.hmn != null) {
                    this.hmn.setParentView(this.gZK.hgE);
                    if (wVar != null && wVar.aIV != null) {
                        this.hmn.aF(wVar.aIV.userId);
                    }
                }
            }
        }
    }

    private void bYe() {
        if (this.hnk == null) {
            this.hnk = new com.baidu.tieba.ala.liveroom.r.c(bZv().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams bYD() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bZv().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.gXk != null && this.gXk.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hmi != null && this.hmi.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void bYr() {
        if (this.hmh == null) {
            this.hmh = new com.baidu.tieba.ala.liveroom.b.a(bZv().pageContext, true);
        }
    }

    private void ceM() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bZv().pageContext.getPageActivity();
            if (this.hmP == null) {
                this.hmP = new ImageView(pageActivity);
                this.hmP.setId(a.f.master_close_btn);
                this.hmP.setTag("master_close_btn");
                this.hmP.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hmP.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hmP.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hmP.getParent() != null) {
                ((ViewGroup) this.hmP.getParent()).removeView(this.hmP);
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
            bZv().hgX.addView(this.hmP, layoutParams);
            this.hmP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.ceW();
                }
            });
            this.hmP.setVisibility(8);
        }
    }

    protected void bYt() {
        if (this.gXk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.r.b.class, bZv().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gXk = (com.baidu.live.r.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bZv().hgD.Hi() != null && bZv().hgD.Hi().aIV != null && bZv().hgD.Hi().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(bZv().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(bZv().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.gXk.b(this.hmu, layoutParams, bZv().hgD.Hi());
        }
    }

    private void ceN() {
        CustomResponsedMessage runTask;
        if (this.hni == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.a.a.class, bZv().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.a)) {
            this.hni = (com.baidu.live.a.a) runTask.getData();
            if (this.hni != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = bZv().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hni.b(this.hmu, layoutParams);
            }
        }
        if (this.hni != null) {
            this.hni.a(bZv().hgD.Hi());
        }
    }

    private void ceO() {
        CustomResponsedMessage runTask;
        if (this.hnj == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.a.b.class, bZv().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.b)) {
            this.hnj = (com.baidu.live.a.b) runTask.getData();
        }
    }

    private void bYf() {
        if (this.gKY == null) {
            this.gKY = new com.baidu.live.ak.a(bZv().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.hng != null) {
            this.hng.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bZv().pageContext.registerListener(this.gXW);
        bZv().pageContext.registerListener(this.hnq);
        bZv().pageContext.registerListener(this.gXX);
        bZv().pageContext.registerListener(this.gXY);
        bZv().pageContext.registerListener(this.hnv);
        bZv().pageContext.registerListener(this.bHB);
        bZv().pageContext.registerListener(this.gUt);
        bZv().pageContext.registerListener(this.hnw);
        bZv().pageContext.registerListener(this.gvb);
        bZv().pageContext.registerListener(this.gWl);
        bZv().pageContext.registerListener(this.gYc);
        bZv().pageContext.registerListener(this.bxu);
        bZv().pageContext.registerListener(this.bxv);
        bZv().pageContext.registerListener(this.hnr);
        bZv().pageContext.registerListener(this.bnK);
        bZv().pageContext.registerListener(this.bnL);
        bZv().pageContext.registerListener(this.hns);
        bZv().pageContext.registerListener(this.gYf);
        bZv().pageContext.registerListener(this.gYe);
        bZv().pageContext.registerListener(this.gYg);
        bZv().pageContext.registerListener(this.hnt);
        bZv().pageContext.registerListener(this.hns);
        bZv().pageContext.registerListener(this.bmQ);
        bZv().pageContext.registerListener(this.bjn);
        bZv().pageContext.registerListener(this.gKZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nx(boolean z) {
        if (bl.c(com.baidu.live.aa.a.PQ().btT)) {
            bZv().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (bZv().hgZ.Cy() == null || ListUtils.isEmpty(bZv().hgZ.Cy().aDY)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bZv().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bxs) {
                this.bxr = BdUniqueId.gen();
                bZv().hgZ.a(this.bxr);
                this.bxs = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bZv().pageContext.getPageActivity(), bZv().rootView);
            vX(8);
            if (bZv().hgU.hasAdvancedBeauty() && this.hnf != null) {
                if (!this.hnl || this.hmf.getVisibility() == 0) {
                    this.hnf.a(bZv().hgU.getVideoConfig());
                }
                this.hnf.a(bZv().hgU.getVideoConfig(), this.bxt);
                if (!this.bxt) {
                    this.bxt = true;
                }
            }
            if (z && this.gWN != null) {
                this.gWN.LJ().getView().setVisibility(4);
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
    public void vW(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bZv().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bZv().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bZv().g((short) 1);
            }
        });
        bdAlertDialog.create(bZv().pageContext).show();
    }

    private void Ii(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bZv().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.h.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bZv().g((short) 1);
            }
        });
        bdAlertDialog.create(bZv().pageContext).show();
    }

    public void ceP() {
        bXU();
        q bRq = bZv().hgD.bRq();
        int i = 5;
        if (bRq != null) {
            i = (int) bRq.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi() != null && AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bZv().hgD.h(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bRq != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gZK.hhc.b(bRq);
                return;
            }
            if (this.gVI == null) {
                this.gVI = new c(bZv().pageContext, this.hny, true);
            }
            if (this.hnd) {
                this.hnd = false;
                this.gVI.a(String.valueOf(bZv().hgD.Hi().mLiveInfo.group_id), String.valueOf(bZv().hgD.Hi().mLiveInfo.live_id), String.valueOf(bZv().hgD.Hi().aIV.userId), bZv().hgD.Hi());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.gWz != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.gVI.c(this.hmt, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.gVI.e(bRq);
            this.gVM.setVisible(0);
            this.gVM.ew(bRq.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceQ() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsT() {
        if (bZv().hgD != null) {
            if (this.gWA == null) {
                this.gWA = new com.baidu.tieba.ala.liveroom.share.c(bZv().pageContext);
            }
            this.gWA.c(bZv().hgD.Hi(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bZv().hgD != null && bZv().hgD.Hi() != null && bZv().hgD.Hi().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bZv().hgD.Hi().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bZv().hgD.Hi().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bZv().hgD.Hi().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bZv().hgD != null && bZv().hgD.Hi() != null && bZv().hgD.Hi().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bZv().hgD.Hi().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bZv().hgD.Hi().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bZv().hgD.Hi().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean ceR() {
        return this.hmd;
    }

    private void ny(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hmc, z);
        this.hmd = z;
    }

    private void ceS() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bZv().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.q.b(AlaMasterLiveRoomOpearator.this.bZv().pageContext).cfU();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bZv().pageContext).show();
    }

    private void ceT() {
        if (this.hlM && bZv().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bZv().hhb.Tq();
        }
        bZv().hha.prepareTime = System.currentTimeMillis() - bZv().hha.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bZv().hgD != null && bZv().hgD.Hi() != null && bZv().hgD.Hi().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bZv().hgD.Hi().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bZv().hgD.Hi().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bZv().hha.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hmf != null && this.hmf.getView().getParent() != null) {
            this.hmf.setVisibility(8);
            bZv().hgX.removeView(this.hmf.getView());
            this.hmf.release();
        }
        if (this.hnf != null) {
            this.hnf.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bZv().hgE.indexOfChild(this.hmq) < 0) {
            bZv().hgE.addView(this.hmq, layoutParams);
        }
        this.hmq.wn(1000);
    }

    private void avS() {
        if (bZv().cbr() == 1) {
            bZv().hgU.startRecord();
        }
    }

    private void Ij(String str) {
        Ik(str);
    }

    private void Ik(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bZv().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hmf != null) {
            this.hmf.HX(fromJson.getSmallurl());
        }
    }

    private boolean ceU() {
        return com.baidu.live.d.AZ().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceV() {
        com.baidu.live.d.AZ().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.gZK.hgU.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceW() {
        if (this.hnh == null || !this.hnh.QF()) {
            if (this.hmp == null || !this.hmp.QF()) {
                int i = a.h.live_close_confirm;
                if (this.hng != null && this.hng.bZD()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hng != null && this.hng.bZC()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(bZv().pageContext.getPageActivity());
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
                        if (AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi(), 0, AlaMasterLiveRoomOpearator.this.bZv().hgD.cgv() != 1 ? AlaMasterLiveRoomOpearator.this.bZv().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
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
                bdAlertDialog.create(bZv().pageContext).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (wVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = wVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = wVar.aIV;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bZv().hgD.ey(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.hnb) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bZv().hha;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bZv().hgU.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hmX;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hmY;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hmT;
            if (this.hmU != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hmV - this.hmW) / this.hmU) * 100.0f;
            }
            Intent intent = new Intent(bZv().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bZv().hgD != null && bZv().hgD.Hi() != null && bZv().hgD.Hi().aIV != null) {
                String str3 = bZv().hgD.Hi().aIV.nickName;
                String str4 = bZv().hgD.Hi().aIV.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            w Hi = bZv().hgD.Hi();
            if (Hi != null && Hi.aIV != null && !TextUtils.isEmpty(Hi.aIV.portrait)) {
                intent.putExtra("host_portrait", Hi.aIV.portrait);
            }
            if (this.hnh != null) {
                this.hnh.UO();
            }
            if (this.hmp != null) {
                this.hmp.QD();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hmZ = intent;
                this.hna = s;
                bZv().pageContext.showToast(a.h.ala_live_background_close_tip);
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
    public void ceX() {
        if (this.hmZ != null) {
            a(this.hmZ, this.hna);
            this.hmZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hnb = true;
        if (this.hng != null) {
            this.hng.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.gUi);
            bZv().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bZv().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceY() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gZK.hhc != null && this.gZK.hhc.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hng != null && this.hng.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hnh != null && this.hnh.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hnf != null && this.hnf.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hmp != null && this.hmp.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bZv().hgY.cfD()) {
                ceW();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.hmr != null) {
                this.hmr.setVisibility(4);
                return;
            }
            return;
        }
        if (this.hmr != null) {
            this.hmr.a(i, z, i2, z2);
        }
        if (this.gZK != null && this.gZK.hgD != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dAb != i3) {
                this.dAb = i3;
                if (this.hml == null) {
                    this.hml = new com.baidu.tieba.ala.liveroom.tippop.a(this.gZK.pageContext, null);
                }
                switch (this.dAb) {
                    case 0:
                        this.hml.a(this.gZK.hgX, this.gZK.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hml.a(this.gZK.hgX, this.gZK.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hml.a(this.gZK.hgX, this.gZK.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gZK.hgD.v(this.gZK.hgD.Hi().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.ceY();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x06bd, code lost:
        HN(r6);
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
            if (this.hmj != null) {
                this.hmj.J(aVar);
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
                            if (this.hng != null) {
                            }
                            if (!"close_live".equals(str2)) {
                            }
                            if (!(aVar.getObjContent() instanceof JSONObject)) {
                            }
                            try {
                                jSONObject6.put("log_id", aVar.getMsgId());
                            } catch (JSONException e2) {
                            }
                            if (this.gXj != null) {
                            }
                            if (this.gXi != null) {
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
            if (this.hng != null) {
                this.hng.gh(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.ceY();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bZv().hgD.Hi(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bZv().hgD.Hi() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bZv().hgD.Hi().aJr.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bZv().hgD.Hi().aJr.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bZv().hgD.Hi().aJr.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bZv().hgD.Hi() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bZv().hgD.Hi() != null && bZv().hgD.Hi().aIV != null && bZv().hgD.Hi().aIV.userId == optLong2) {
                        bZv().hgD.Hi().aIV.isUegBlock = 1;
                        bXz();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bZv().hgD.Hi() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bZv().hgD.Hi() != null && bZv().hgD.Hi().aIV != null && bZv().hgD.Hi().aIV.userId == optLong3) {
                        bZv().hgD.Hi().aIV.isUegBlock = 0;
                        bXz();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hmM != null) {
                    this.hmM.V(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.hmk.aJ(optString4, optInt2);
                    }
                    if (this.gVM.getCount() > 20) {
                        this.gVM.ew(this.gVM.getCount() + 1);
                    } else if (this.gVI != null) {
                        com.baidu.live.data.a Mo = aVar.Mo();
                        com.baidu.live.data.p pVar = new com.baidu.live.data.p();
                        pVar.aIW = new AlaLocationData();
                        pVar.aIX = new AlaRelationData();
                        pVar.aIV = new AlaLiveUserInfoData();
                        pVar.aIV.userId = JavaTypesHelper.toLong(Mo.userId, 0L);
                        pVar.aIV.userName = Mo.userName;
                        pVar.aIV.portrait = Mo.portrait;
                        if (this.gVI.c(pVar)) {
                            this.gVM.ew(this.gVM.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bZv() != null && bZv().hgD != null && bZv().hgD.Hi() != null && bZv().hgD.Hi().aJr != null && bZv().hgD.Hi().aJr.userId == jSONObject2.optLong("user_id")) {
                    bZv().hgD.cgl();
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
                    com.baidu.live.data.a Mo2 = aVar.Mo();
                    if (Mo2 != null && aa.hg(str6)) {
                        aa.d(str6, 1L, "", "", Mo2.userId, Mo2.portrait, Mo2.userName, "", "", false, "", "", "", false, false, true, -1L);
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
                        Il(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bZv().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(bZv().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
            } else if ("connect_apply_show_pub".equals(str2) && this.hmp != null) {
                this.hmp.U(jSONObject2);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a Mo3 = aVar.Mo();
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
                if (bZv().hgD == null || bZv().hgD.Hi() == null || bZv().hgD.Hi().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    str3 = "";
                    str4 = "";
                    z = false;
                } else {
                    long j4 = bZv().hgD.Hi().mLiveInfo.live_id;
                    long j5 = bZv().hgD.Hi().mLiveInfo.group_id;
                    long j6 = bZv().hgD.Hi().aIV.userId;
                    str7 = bZv().hgD.Hi().mLiveInfo.appId;
                    boolean z5 = bZv().hgD.Hi().mLiveInfo.isPubShow;
                    if (bZv().hgD.Hi().mLiveSdkInfo.mCastIds == null) {
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = "";
                        str4 = "";
                        z = z5;
                    } else {
                        String str8 = bZv().hgD.Hi().mLiveSdkInfo.mCastIds.chatMCastId;
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = bZv().hgD.Hi().mLiveSdkInfo.mCastIds.ensureMCastId;
                        str4 = str8;
                        z = z5;
                    }
                }
                if (!z3 || z2) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString7, "");
                    if (!this.isBackground || bZv().cbr() != 2) {
                        if (!TextUtils.isEmpty(optString13) && !TextUtils.isEmpty(optString14)) {
                            if (jSONObject5.optInt("flag_show") == 1) {
                                aa.b(optString14, Mo3.userId, Mo3.portrait, Mo3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString13, "", "", aVar.getMsgId());
                                try {
                                    JSONArray jSONArray = new JSONArray(optString14);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i >= jSONArray.length()) {
                                                break;
                                            }
                                            if (com.baidu.live.aa.f.Qg().hZ(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                            aa.a(optString7, Integer.parseInt(optString8), optString9, optString10, Mo3.userId, Mo3.portrait, Mo3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString12, str4, str3, (z4 || z3) ? false : true, aVar.getMsgId(), z2, jSONObject5, optString11);
                        }
                    }
                    HN(optString7);
                    if (!jSONObject5.optString("content_type").equals("tying_gift")) {
                        com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar.hgk = optLong5;
                        cVar.liveId = j3;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                    }
                    JSONObject jSONObject7 = new JSONObject();
                    try {
                        jSONObject7.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                        jSONObject7.putOpt("gift_name", optString9);
                        jSONObject7.putOpt("order_id", optString6);
                        com.baidu.live.gift.g hc = aa.hc(optString7);
                        if (hc != null) {
                            jSONObject7.putOpt(LogConfig.LOG_GIFT_VALUE, hc.getPrice());
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
        if (this.gXj != null) {
            this.gXj.l(aVar);
        }
        if ((this.gXi != null || !this.gXi.R(jSONObject6)) && this.gVV != null && this.gVV.R(jSONObject6)) {
        }
    }

    private void HN(String str) {
        if (this.gVO != null) {
            this.gVO.HN(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vX(int i) {
        View findViewById = bZv().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gVO != null) {
            this.gVO.bM(2, i);
        }
    }

    private void ceZ() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bZv().hgU != null && AlaMasterLiveRoomOpearator.this.bZv().hgU.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bZv().hgU.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bZv().hgU.startRecord();
                }
            }
        });
    }

    private void cfa() {
        if (bZv().hgU != null && bZv().hgU.getPreview() != null) {
            bZv().hgU.getPreview().setVisibility(8);
            bZv().hgU.stopRecord();
        }
    }

    public void cfb() {
        this.hgR = bZv().hgD.cgw();
        if (this.hmf != null) {
            this.hmf.nf(this.hgR);
        }
    }

    public void cbp() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cfc();
        } else if (this.hmf != null) {
            this.hmf.cbp();
        }
    }

    public void ng(boolean z) {
        if (this.hmf != null) {
            this.hmf.ng(z);
        }
    }

    public void onDestroy() {
        if (this.hmS != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hmS);
        }
        this.hmS = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hmL.removeCallbacksAndMessages(null);
        if (this.hnf != null) {
            this.hnf.nd(true);
        }
        this.hnf = null;
        if (this.hmf != null) {
            this.hmf.destroy();
            bZv().hgX.removeView(this.hmf.getView());
            this.hmf.release();
            this.hmf = null;
        }
        if (this.hng != null) {
            this.hng.onDestroy();
        }
        if (this.gWA != null) {
            this.gWA.onDestroy();
        }
        if (this.gVJ != null) {
            this.gVJ.onDestroy();
            this.gVJ = null;
        }
        if (this.hmg != null) {
            this.hmg.onDestroy();
        }
        if (this.gXa != null) {
            this.gXa.onDestroy();
            this.gXa = null;
        }
        if (this.hmq != null) {
            this.hmq.stopCountDown();
        }
        if (this.hmi != null) {
            this.hmi.onDestroy();
        }
        if (this.hmk != null) {
            this.hmk.onDestroy();
        }
        if (this.hmM != null) {
            this.hmM.onDestroy();
            this.hmM = null;
        }
        if (this.gWP != null) {
            this.gWP.onDestroy();
            this.gWP = null;
        }
        if (this.hmm != null) {
            this.hmm.release();
        }
        com.baidu.live.ac.a.b.Qx().release();
        aa.Hq();
        com.baidu.live.entereffect.a.Fg().release();
        this.hno = false;
        if (this.gWQ != null) {
            this.gWQ.onDestroy();
            this.gWQ = null;
        }
        if (this.hml != null) {
            this.hml.onDestroy();
        }
        if (this.hmj != null) {
            this.hmj.cix();
            this.hmj.release();
        }
        if (this.gVM != null) {
            this.gVM = null;
        }
        if (this.gVO != null) {
            this.gVO.release();
        }
        if (this.hmj != null) {
            this.hmj.onDestroy();
        }
        if (this.gWO != null) {
            this.gWO.release();
        }
        if (this.hmo != null) {
            this.hmo.release();
        }
        if (this.hmO != null) {
            this.hmO.onDestroy();
        }
        if (this.gXo != null) {
            this.gXo.release();
        }
        if (this.hni != null) {
            this.hni.onDestory();
        }
        if (this.hnj != null) {
            this.hnj.release();
        }
        if (this.gXh != null) {
            this.gXh.onDestroy();
        }
        if (this.gXi != null) {
            this.gXi.onDestroy();
        }
        if (this.gVV != null) {
            this.gVV.onDestroy();
        }
        if (this.hmn != null) {
            this.hmn.release();
            this.hmn = null;
        }
        if (this.hnk != null) {
            this.hnk.release();
        }
        if (this.gKY != null) {
            this.gKY.release();
        }
        if (this.gXk != null) {
            this.gXk.onDestroy();
        }
        if (this.hnh != null) {
            this.hnh.onDestroy();
        }
        if (this.hmp != null) {
            this.hmp.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gXW);
        MessageManager.getInstance().unRegisterListener(this.hnq);
        MessageManager.getInstance().unRegisterListener(this.gXX);
        MessageManager.getInstance().unRegisterListener(this.gXY);
        MessageManager.getInstance().unRegisterListener(this.hnv);
        MessageManager.getInstance().unRegisterListener(this.bHB);
        MessageManager.getInstance().unRegisterListener(this.gUt);
        MessageManager.getInstance().unRegisterListener(this.hnw);
        MessageManager.getInstance().unRegisterListener(this.gvb);
        MessageManager.getInstance().unRegisterListener(this.gWl);
        MessageManager.getInstance().unRegisterListener(this.gYc);
        MessageManager.getInstance().unRegisterListener(this.bxu);
        MessageManager.getInstance().unRegisterListener(this.bxv);
        MessageManager.getInstance().unRegisterListener(this.hnr);
        MessageManager.getInstance().unRegisterListener(this.bnK);
        MessageManager.getInstance().unRegisterListener(this.bnL);
        MessageManager.getInstance().unRegisterListener(this.hns);
        MessageManager.getInstance().unRegisterListener(this.gYf);
        MessageManager.getInstance().unRegisterListener(this.gYe);
        MessageManager.getInstance().unRegisterListener(this.gYg);
        MessageManager.getInstance().unRegisterListener(this.hnt);
        MessageManager.getInstance().unRegisterListener(this.hns);
        MessageManager.getInstance().unRegisterListener(this.bmQ);
        MessageManager.getInstance().unRegisterListener(this.bjn);
        MessageManager.getInstance().unRegisterListener(this.gKZ);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gZK.hhc.a(this.hnF, this.gZK.hgW, this.hms, alaLivePersonData);
        }
    }

    private void cfc() {
        if (this.hmQ != null) {
            this.gZK.hha.startTime = System.currentTimeMillis();
            this.gZK.hha.liveTotalTime = System.currentTimeMillis();
            this.gZK.hha.sampleMemAndCPU();
            this.gZK.hgY.a((short) 4, this.hmQ);
        }
    }

    private void Il(String str) {
        String str2;
        int i;
        if (bZv() != null && bZv().pageContext != null) {
            this.hmL.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bZv().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hnm == null) {
                    this.hnm = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hnm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.ceb()) {
                                AlaMasterLiveRoomOpearator.this.hmL.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hnm != null) {
                                    AlaMasterLiveRoomOpearator.this.bZv().hgE.removeView(AlaMasterLiveRoomOpearator.this.hnm);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hng != null) {
                                    AlaMasterLiveRoomOpearator.this.hng.bZz();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hnm.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hmL.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bZv().hgE != null && AlaMasterLiveRoomOpearator.this.gZR != null && AlaMasterLiveRoomOpearator.this.hnm != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hnm.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hnm.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.B((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hnm.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gZR.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gZR.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gZR.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gZR.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hnm.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hnm.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hnm != null) {
                                AlaMasterLiveRoomOpearator.this.bZv().hgE.removeView(AlaMasterLiveRoomOpearator.this.hnm);
                            }
                            AlaMasterLiveRoomOpearator.this.bZv().hgE.addView(AlaMasterLiveRoomOpearator.this.hnm, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.aa.a.PQ().bod != null) {
                    i = com.baidu.live.aa.a.PQ().bod.aMr;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hmL.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bZv().hgE != null && AlaMasterLiveRoomOpearator.this.hnm != null) {
                            AlaMasterLiveRoomOpearator.this.bZv().hgE.removeView(AlaMasterLiveRoomOpearator.this.hnm);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
