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
import com.baidu.live.aa.a;
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
import com.baidu.live.data.ao;
import com.baidu.live.data.ap;
import com.baidu.live.data.ax;
import com.baidu.live.data.ay;
import com.baidu.live.data.bb;
import com.baidu.live.data.bk;
import com.baidu.live.data.q;
import com.baidu.live.data.w;
import com.baidu.live.gift.aa;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.af;
import com.baidu.live.gift.aj;
import com.baidu.live.im.data.ImForbiddenStateData;
import com.baidu.live.im.k;
import com.baidu.live.im.m;
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
import com.baidu.platform.comapi.map.MapController;
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
    private static final String hgh;
    private boolean blo;
    private PendantParentView bqg;
    private com.baidu.live.ai.a gFm;
    private String gNJ;
    private c gPE;
    private com.baidu.tieba.ala.liveroom.p.a gPF;
    private com.baidu.tieba.ala.liveroom.audiencelist.b gPI;
    private com.baidu.tieba.ala.liveroom.activeview.b gPK;
    protected com.baidu.live.y.a gPR;
    private com.baidu.live.g.a gPf;
    private m gQI;
    private k gQJ;
    private com.baidu.live.im.b.a gQK;
    private ac gQL;
    private aa gQM;
    protected af gQW;
    private com.baidu.live.h.a gQv;
    private com.baidu.tieba.ala.liveroom.share.c gQw;
    private com.baidu.tieba.ala.liveroom.s.b gQx;
    protected com.baidu.live.j.a gRd;
    protected com.baidu.live.q.a gRe;
    protected com.baidu.live.i.a gRf;
    protected com.baidu.live.q.b gRg;
    private com.baidu.live.v.a gRk;
    private boolean gRy;
    private boolean gSq;
    private f gTF;
    private ImageView gTM;
    private g gTN;
    private boolean hfR;
    private RelativeLayout hgA;
    private FrameLayout hgB;
    private View hgC;
    private boolean hgD;
    private AlaLiveFaceVerifyView hgE;
    private ImageView hgF;
    private ImageView hgG;
    private ImageView hgH;
    private ImageView hgI;
    private ImageView hgJ;
    private ImageView hgK;
    private ImageView hgL;
    private TextView hgM;
    private ap hgN;
    private com.baidu.live.ac.a hgP;
    private com.baidu.tieba.ala.liveroom.master.panel.b hgQ;
    private com.baidu.live.aa.a hgR;
    private ImageView hgS;
    private e hgT;
    private boolean hgi;
    private d hgk;
    private com.baidu.tieba.ala.liveroom.p.a hgl;
    private com.baidu.tieba.ala.liveroom.b.a hgm;
    private com.baidu.tieba.ala.liveroom.v.a hgn;
    private com.baidu.tieba.ala.liveroom.x.a hgo;
    private b hgp;
    private com.baidu.tieba.ala.liveroom.tippop.a hgq;
    private com.baidu.live.q.d hgr;
    private com.baidu.live.q.c hgs;
    protected com.baidu.live.k.a hgt;
    private AlaLiveCountDownView hgu;
    private AlaLiveStreamStatusView hgv;
    private RelativeLayout hgw;
    private RelativeLayout hgx;
    private RelativeLayout hgy;
    private RelativeLayout hgz;
    private short hhd;
    private com.baidu.tieba.ala.liveroom.h.b hhi;
    private boolean hhj;
    private com.baidu.tieba.ala.liveroom.challenge.e hhk;
    private com.baidu.live.ah.a hhl;
    private com.baidu.live.a.a hhm;
    private com.baidu.live.a.b hhn;
    private com.baidu.tieba.ala.liveroom.r.a hho;
    private boolean hhp;
    private BdUniqueId hhq;
    private boolean hhr;
    private View hhs;
    private FrameLayout hht;
    private boolean hhu;
    private boolean hgj = false;
    private boolean gRt = false;
    private Handler mHandler = new Handler();
    private Handler hgO = new Handler();
    private boolean hgU = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hgV = null;
    private boolean hgW = false;
    private int hgX = 0;
    private int hgY = 0;
    private int hgZ = 0;
    private long hha = 0;
    private long hhb = 0;
    private volatile boolean isBackground = false;
    private Intent hhc = null;
    private int mOrientation = 1;
    private boolean haX = false;
    private boolean hhe = false;
    private boolean hhf = true;
    private boolean gTK = false;
    private boolean hhg = true;
    private boolean hhh = true;
    private int duj = 0;
    private String otherParams = "";
    private int blr = 0;
    private Runnable hhv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.gPf != null) {
                AlaMasterLiveRoomOpearator.this.gPf.EE();
            }
        }
    };
    private com.baidu.live.ah.b bAJ = new com.baidu.live.ah.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.ah.b
        public boolean Si() {
            if (AlaMasterLiveRoomOpearator.this.hhk != null) {
                if (AlaMasterLiveRoomOpearator.this.gRe != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hhk.bWV() && !AlaMasterLiveRoomOpearator.this.hhk.bWW() && !AlaMasterLiveRoomOpearator.this.gRe.On() && !AlaMasterLiveRoomOpearator.this.gRe.CS()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hhk.bWV() && !AlaMasterLiveRoomOpearator.this.hhk.bWW()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.gRe == null || AlaMasterLiveRoomOpearator.this.gRe.On() || AlaMasterLiveRoomOpearator.this.gRe.CS()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.ah.b
        public void Sj() {
            if (AlaMasterLiveRoomOpearator.this.hhk != null) {
                AlaMasterLiveRoomOpearator.this.hhk.bWY();
            }
        }
    };
    private CustomMessageListener bmq = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gTF.hbh != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gTF.hbh.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.E(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener bmr = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gTF.hbh != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.gTF.hbh.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener gRT = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.gQx == null) {
                        AlaMasterLiveRoomOpearator.this.gQx = new com.baidu.tieba.ala.liveroom.s.b();
                    }
                    AlaMasterLiveRoomOpearator.this.gQx.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener gSa = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.gRd != null) {
                AlaMasterLiveRoomOpearator.this.gRd.Kx();
            }
        }
    };
    private CustomMessageListener hhw = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.s((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gRQ = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.Hy(str);
            }
        }
    };
    private CustomMessageListener gRR = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.bqt();
        }
    };
    private CustomMessageListener gQh = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.gQM.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener gRX = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hhx = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hhn != null) {
                w GH = AlaMasterLiveRoomOpearator.this.bWT().haB.GH();
                long j = GH.mLiveInfo.live_id;
                long j2 = GH.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.hhn.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener hhy = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bWT().haC);
            if (AlaMasterLiveRoomOpearator.this.hgk == null || AlaMasterLiveRoomOpearator.this.hgk.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.vK(0);
            }
            if (AlaMasterLiveRoomOpearator.this.gQJ != null) {
                AlaMasterLiveRoomOpearator.this.gQJ.Lj().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.gQJ.Lk().hide();
            }
        }
    };
    private CustomMessageListener gRZ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.x(AlaMasterLiveRoomOpearator.this.bWT().haB.GH());
        }
    };
    private CustomMessageListener gSb = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.gQW != null) {
                    ((com.baidu.tieba.ala.liveroom.r.b) AlaMasterLiveRoomOpearator.this.gQW).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hhz = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hho != null) {
                    AlaMasterLiveRoomOpearator.this.hho.hM(str);
                }
            }
        }
    };
    private CustomMessageListener hhA = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hhi != null) {
                        if (!data.aDy || AlaMasterLiveRoomOpearator.this.hhq == null || !AlaMasterLiveRoomOpearator.this.hhr) {
                            if (AlaMasterLiveRoomOpearator.this.hhq != null && AlaMasterLiveRoomOpearator.this.hhq == data.aDx) {
                                if (data.aDr != null && data.aDr.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hhr || AlaMasterLiveRoomOpearator.this.hgk.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hhi.a(AlaMasterLiveRoomOpearator.this.bWT().hba.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.hhj = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.bWT().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.hhq = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.bWT().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hhi.a(AlaMasterLiveRoomOpearator.this.bWT().hba.getVideoConfig(), AlaMasterLiveRoomOpearator.this.hhj);
                        if (!AlaMasterLiveRoomOpearator.this.hhj) {
                            AlaMasterLiveRoomOpearator.this.hhj = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hhp) {
                    AlaMasterLiveRoomOpearator.this.bWT().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.hhp = false;
            }
        }
    };
    private CustomMessageListener hhB = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.bWT().hba != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.bWT().hba.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.AZ().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener blw = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.blr == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.blr == 6) {
                            AlaMasterLiveRoomOpearator.this.cbD();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.blr = 0;
            }
        }
    };
    private View.OnClickListener hhC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hgG) {
                    AlaMasterLiveRoomOpearator.this.cbH();
                    AlaMasterLiveRoomOpearator.this.hgQ.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hgF) {
                    if (view == AlaMasterLiveRoomOpearator.this.hgH) {
                        AlaMasterLiveRoomOpearator.this.bqt();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hgI) {
                        if (view != AlaMasterLiveRoomOpearator.this.hgK) {
                            if (view == AlaMasterLiveRoomOpearator.this.gTM) {
                                if (AlaMasterLiveRoomOpearator.this.cbC()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hhk != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.gRe != null) && AlaMasterLiveRoomOpearator.this.gRe.CS()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.gRe.On() & (AlaMasterLiveRoomOpearator.this.gRe != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hhk.bWV()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hhk.bWW()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hhk.bWX();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hgJ) {
                                if (AlaMasterLiveRoomOpearator.this.hgo != null) {
                                    ao cdL = AlaMasterLiveRoomOpearator.this.bWT().haB.cdL();
                                    if (cdL == null || cdL.mLiveSdkInfo == null) {
                                        str = null;
                                    } else {
                                        str = String.valueOf(cdL.mLiveSdkInfo.mRoomId);
                                        if (cdL.mLiveSdkInfo.mCastIds != null) {
                                            str2 = cdL.mLiveSdkInfo.mCastIds.chatMCastId;
                                        }
                                    }
                                    AlaMasterLiveRoomOpearator.this.hgo.ar("", str, str2);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hgL) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hhk.bWV() || AlaMasterLiveRoomOpearator.this.hhk.bWW() || AlaMasterLiveRoomOpearator.this.gRe.On() || AlaMasterLiveRoomOpearator.this.gRe.CS()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hhl != null) {
                                    AlaMasterLiveRoomOpearator.this.hhl.Se();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hgR != null) {
                            AlaMasterLiveRoomOpearator.this.hgR.PJ();
                            AlaMasterLiveRoomOpearator.this.hgR.cw(AlaMasterLiveRoomOpearator.this.cbO());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "beauty"));
                        AlaMasterLiveRoomOpearator.this.hhr = false;
                        AlaMasterLiveRoomOpearator.this.no(true);
                        AlaMasterLiveRoomOpearator.this.hgM.setVisibility(4);
                        com.baidu.live.d.AZ().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.z.a.Pq().bmJ.aMo == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity().getResources().getString(a.i.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.z.a.Pq().bmJ.aMn == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.blo) {
                        AlaMasterLiveRoomOpearator.this.cbD();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.blr = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.cbD();
                }
            }
        }
    };
    private CustomMessageListener gRS = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ap) {
                    AlaMasterLiveRoomOpearator.this.gRt = true;
                    AlaMasterLiveRoomOpearator.this.hgN = (ap) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.gQJ != null) {
                        AlaMasterLiveRoomOpearator.this.gQJ.Lj().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.gQJ != null) {
                        AlaMasterLiveRoomOpearator.this.gQJ.Lk().show();
                        AlaMasterLiveRoomOpearator.this.gQJ.Lk().setEditText(" @" + aVar.userName + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.vK(8);
                }
            }
        }
    };
    private CustomMessageListener hhD = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bWT() != null && AlaMasterLiveRoomOpearator.this.bWT().hbf != null) {
                AlaMasterLiveRoomOpearator.this.bWT().hbf.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bBv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.ccw();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bWT().haB.vR(i);
            }
        }
    };
    private CustomMessageListener gNU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.ccp();
        }
    };
    private CustomMessageListener gFn = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ai.c)) {
                if (AlaMasterLiveRoomOpearator.this.gFm == null) {
                    AlaMasterLiveRoomOpearator.this.gFm = new com.baidu.live.ai.a(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.gFm.a((com.baidu.live.ai.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hhE = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.NG()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hgQ != null) {
                            AlaMasterLiveRoomOpearator.this.hgQ.nv(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.hgQ.ccU();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bWT().hba.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hhl != null) {
                        AlaMasterLiveRoomOpearator.this.hhl.setMute(AlaMasterLiveRoomOpearator.this.bWT().hba.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hgq != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hgq.a(AlaMasterLiveRoomOpearator.this.bWT().hbc, AlaMasterLiveRoomOpearator.this.bWT().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bWT().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hgq.vZ(2);
                        AlaMasterLiveRoomOpearator.this.hgq.a(AlaMasterLiveRoomOpearator.this.bWT().hbc, string, 3);
                    }
                }
            }
        }
    };
    private e.a hhF = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void ccC() {
            AlaMasterLiveRoomOpearator.this.vJ(a.i.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void ccD() {
            AlaMasterLiveRoomOpearator.this.vJ(a.i.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hhG = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean eO(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void eP(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bWT().bYP() == 1) {
                AlaMasterLiveRoomOpearator.this.bWT().hba.stopRecord();
            }
        }
    };
    private IShareCallback hhH = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hgU && AlaMasterLiveRoomOpearator.this.hgT != null) {
                AlaMasterLiveRoomOpearator.this.hgU = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hgT);
            }
        }
    };
    private View.OnTouchListener hhI = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bWT().hbf.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bWT().haC);
            AlaMasterLiveRoomOpearator.this.vK(0);
            if (AlaMasterLiveRoomOpearator.this.gQJ != null) {
                AlaMasterLiveRoomOpearator.this.gQJ.Lj().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.gQJ.Lk().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hhJ = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ccE() {
            AlaMasterLiveRoomOpearator.this.cbE();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ccF() {
            AlaMasterLiveRoomOpearator.this.hfR = AlaMasterLiveRoomOpearator.this.hgk.bYH();
            AlaMasterLiveRoomOpearator.this.bWT().hbf.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bWT().hbf.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bWT().hbf.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.haU = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bWT().bYP();
            eVar.title = AlaMasterLiveRoomOpearator.this.hgk.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.haV = AlaMasterLiveRoomOpearator.this.hgk.bYI();
            eVar.haY = AlaMasterLiveRoomOpearator.this.hfR;
            eVar.haX = AlaMasterLiveRoomOpearator.this.hgk.bYF();
            eVar.haW = AlaMasterLiveRoomOpearator.this.hgk.bYK();
            eVar.haZ = AlaMasterLiveRoomOpearator.this.hgk.bYG();
            if (eVar.haZ) {
                if (AlaMasterLiveRoomOpearator.this.hgk.bYL()) {
                    AlaMasterLiveRoomOpearator.this.hgU = true;
                    AlaMasterLiveRoomOpearator.this.hgT = eVar;
                    AlaMasterLiveRoomOpearator.this.hgk.bYM();
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
            AlaMasterLiveRoomOpearator.this.bWT().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bWT().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ccG() {
            AlaMasterLiveRoomOpearator.this.hhr = true;
            AlaMasterLiveRoomOpearator.this.no(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean ccH() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ccI() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener bhR = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.bUZ();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hhK = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void NB() {
            if (AlaMasterLiveRoomOpearator.this.hgo != null) {
                AlaMasterLiveRoomOpearator.this.hgo.nI(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cj(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hgR != null) {
                        AlaMasterLiveRoomOpearator.this.hgR.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hgR != null) {
                    AlaMasterLiveRoomOpearator.this.hgR.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hgo != null) {
                    AlaMasterLiveRoomOpearator.this.hgo.nI(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.gQW != null) {
                    AlaMasterLiveRoomOpearator.this.gQW.bs(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hhL = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void ada() {
            if (AlaMasterLiveRoomOpearator.this.hgE != null && AlaMasterLiveRoomOpearator.this.bWT().hbc.indexOfChild(AlaMasterLiveRoomOpearator.this.hgE) >= 0) {
                AlaMasterLiveRoomOpearator.this.bWT().hbc.removeView(AlaMasterLiveRoomOpearator.this.hgE);
                AlaMasterLiveRoomOpearator.this.hgE.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hgE = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b gQm = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void p(View view, int i) {
            w GH;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.ccv();
            } else if (i == 14 && (GH = AlaMasterLiveRoomOpearator.this.bWT().haB.GH()) != null && GH.aIe != null && GH.mLiveInfo != null && GH.aIA != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity(), GH.aIe.userName, Long.toString(GH.aIe.userId), Long.toString(GH.aIe.charmCount), String.valueOf(GH.mLiveInfo.group_id), String.valueOf(GH.mLiveInfo.live_id), true, String.valueOf(GH.aIe.userId), Long.toString(GH.aIA.userId), GH.aIA.userName, GH.aIA.portrait, AlaMasterLiveRoomOpearator.this.gPI.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(GH.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.gPI.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hhM = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private com.baidu.live.liveroom.middleware.g hhN = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.azP);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hgh = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(w wVar) {
        if (wVar != null && wVar.mLiveInfo != null && com.baidu.live.z.a.Pq().bmJ != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bWT().pageContext.getPageActivity(), String.valueOf(wVar.mLiveInfo.live_id), String.valueOf(wVar.mLiveInfo.user_id), com.baidu.live.z.a.Pq().bmJ.aMj, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bWT().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bWT().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.z.a.Pq().bmJ.aLH;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bWT().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bWT().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bWT().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUZ() {
        int i = bWT().haB.GH().aIe.isUegBlock;
        int i2 = bWT().haB.GH().aIe.isBlock;
        String str = bWT().haB.GH().aIe.userName;
        if (i > 0 || i2 > 0) {
            this.blo = true;
            this.gQJ.a(true, i, i2, str);
            return;
        }
        this.blo = false;
        this.gQJ.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.gTF.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bkr == 1) {
                format = pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.i.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bks);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.gTF.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.gTF.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cbC() {
        if (this.hhl == null || !this.hhl.Sf()) {
            return true;
        }
        BdUtilHelper.showToast(this.gTF.pageContext.getPageActivity(), this.gTF.pageContext.getPageActivity().getResources().getString(a.i.sdk_video_chat_no_pk_tip));
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbD() {
        if (this.gQJ != null) {
            this.gQJ.Lk().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hhk != null) {
            this.hhk.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbE() {
        if (bWT() != null && bWT().haB != null) {
            bWT().haB.cdE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bOq() != null && aVar.bOr() != null) {
            bWT().haB.ew(aVar.bOq().getId(), aVar.bOr().getId());
        }
    }

    public void b(short s) {
        if (this.hhi != null) {
            this.hhi.b(s);
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
                    AlaMasterLiveRoomOpearator.this.hgW = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hgW = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hgX == 0) {
                    AlaMasterLiveRoomOpearator.this.hgX = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hgY == 0) {
                    AlaMasterLiveRoomOpearator.this.hgY = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hgZ = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bWT() != null && bWT().hbd != null) {
            bWT().hbd.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.gTF = fVar;
        this.gNJ = str;
    }

    protected f bWT() {
        return this.gTF;
    }

    public int a(g gVar) {
        this.gTN = gVar;
        this.hgV = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hgV, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hgq == null) {
            this.hgq = new com.baidu.tieba.ala.liveroom.tippop.a(this.gTF.pageContext, null);
        }
        registerListener();
        this.gPf = new com.baidu.live.g.a();
        cbY();
        cbF();
        cbG();
        Long[] lArr = new Long[1];
        this.hha = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hhb = lArr[0] != null ? lArr[0].longValue() : 0L;
        bWT().haC.setOnTouchListener(this.hhI);
        this.hgi = SharedPrefHelper.getInstance().getBoolean(hgh, false);
        this.hgu = new AlaLiveCountDownView(bWT().pageContext.getPageActivity());
        this.hgu.setCount(3);
        this.hgu.setTextColor(bWT().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.hgu.setTextSize(bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.hgu.setTypeface(Typeface.DEFAULT_BOLD);
        this.hgu.setIncludeFontPadding(false);
        this.hgu.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void ccJ() {
                if (AlaMasterLiveRoomOpearator.this.bWT().haC != null) {
                    AlaMasterLiveRoomOpearator.this.bWT().haC.removeView(AlaMasterLiveRoomOpearator.this.hgu);
                }
            }
        });
        return 1;
    }

    private void cbF() {
        CustomResponsedMessage runTask;
        if (this.hgt == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.k.a.class, bWT().pageContext)) != null && runTask.getData() != null) {
            this.hgt = (com.baidu.live.k.a) runTask.getData();
            this.hgt.c(bWT().pageContext);
        }
    }

    private void cbG() {
        View rootLayout;
        if (this.hgt != null && this.hgB != null && (rootLayout = this.hgt.cc(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hgB.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbH() {
        if (this.hgQ == null) {
            this.hgQ = new com.baidu.tieba.ala.liveroom.master.panel.b(bWT().pageContext.getPageActivity(), bWT().bYP() == 2);
            this.hgQ.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nq(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bWT().hba.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nr(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bWT().hba.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ns(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bWT().hba.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.ccu();
                    if (AlaMasterLiveRoomOpearator.this.hgq != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hgq.a(AlaMasterLiveRoomOpearator.this.bWT().hbc, AlaMasterLiveRoomOpearator.this.bWT().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hgq.a(AlaMasterLiveRoomOpearator.this.bWT().hbc, AlaMasterLiveRoomOpearator.this.bWT().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void nt(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ccK() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bWT().haB != null && AlaMasterLiveRoomOpearator.this.bWT().haB.GH() != null && AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hgQ != null) {
                        AlaMasterLiveRoomOpearator.this.hgQ.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.a(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ccL() {
                    if (AlaMasterLiveRoomOpearator.this.hgQ != null) {
                        AlaMasterLiveRoomOpearator.this.hgQ.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.bWT().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ccM() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.bWT() != null && AlaMasterLiveRoomOpearator.this.bWT().haB != null && AlaMasterLiveRoomOpearator.this.bWT().haB.GH() != null && AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(AlaMasterLiveRoomOpearator.this.bWT().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hgQ != null) {
                            AlaMasterLiveRoomOpearator.this.hgQ.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ccN() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.bWT() == null || AlaMasterLiveRoomOpearator.this.bWT().haB == null || AlaMasterLiveRoomOpearator.this.bWT().haB.GH() == null || AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bWT() != null && AlaMasterLiveRoomOpearator.this.bWT().haB != null && AlaMasterLiveRoomOpearator.this.bWT().haB.GH() != null && AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hgQ != null) {
                                        AlaMasterLiveRoomOpearator.this.hgQ.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.gTF.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hgQ != null) {
                        AlaMasterLiveRoomOpearator.this.hgQ.dismiss();
                    }
                }
            });
        }
        cbI();
    }

    private void cbI() {
        if (this.hgQ != null) {
            boolean isBackCamera = bWT().hba.isBackCamera();
            this.hgQ.nu(bWT().hba.isBackCamera());
            this.hgQ.Q(bWT().hba.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bWT().hba.isPushMirror();
            if (this.hhf) {
                isPushMirror = cct() || isPushMirror;
                this.hhf = false;
            }
            this.hgQ.R(isPushMirror, isBackCamera ? false : true);
            this.hgQ.nv(bWT().hba.isMute());
            this.hgQ.ccU();
        }
    }

    public void cbJ() {
        if (this.gTN != null) {
            if (this.gTN.hbi == null || this.gTN.hbi.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hgC == null) {
                        this.hgC = this.gTF.hbh.Nd();
                        this.gTF.hbc.addView(this.hgC, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hgk == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bWT().haB != null && bWT().haB.GH() != null && bWT().haB.GH().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bWT().haB.GH().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bWT().haB.GH().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hgk = new d(bWT().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bWT().hbf.prepareTime = System.currentTimeMillis();
                    bWT().hbc.addView(this.hgk.getView(), layoutParams);
                    this.hgk.a(this.hhH);
                }
                this.hgk.mW(this.haX);
                this.hgk.a(this.hhJ);
                this.hgk.a(this.hhF);
                this.hgk.a(bWT().hba, bWT().bYP());
                this.hgk.a(this.hgt);
                return;
            }
            this.hfR = this.gTN.hbi.mLiveInfo.screen_direction == 2;
            if (this.gTN.hbi.mLiveInfo.isAudioOnPrivate == 1) {
                bWT().hba.setMute(true);
                if (this.hhl != null) {
                    this.hhl.setMute(bWT().hba.isMute());
                }
                if (this.hgq == null) {
                    this.hgq = new com.baidu.tieba.ala.liveroom.tippop.a(this.gTF.pageContext, null);
                }
                if (!this.hgq.vY(2)) {
                    this.hgq.a(bWT().hbc, bWT().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.haU = true;
            eVar.forumId = String.valueOf(this.gTN.hbi.mLiveInfo.forum_id);
            eVar.forumName = this.gTN.hbi.mLiveInfo.forum_name;
            eVar.liveType = this.gTN.hbi.mLiveInfo.live_type;
            eVar.title = this.gTN.hbi.mLiveInfo.getLiveTitle();
            eVar.clarity = this.gTN.hbi.mLiveInfo.clarity;
            eVar.gameId = this.gTN.hbi.mLiveInfo.game_id;
            eVar.gameName = this.gTN.hbi.mLiveInfo.game_label;
            eVar.haY = this.gTN.hbi.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void cbK() {
        if (this.hhi != null) {
            this.hhi.a(bWT().hba.getVideoConfig(), false);
        }
        if (this.hgk != null) {
            this.hgk.mV(true);
        }
        if (bWT().hba.hasBeauty() >= 0) {
            bWT().hba.setBeauty(com.baidu.live.d.AZ().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bWT().hbh.J(this.gTF.hba);
        } else if (this.hgk != null) {
            this.hgk.mV(true);
        }
        cbX();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hgC != null && this.hgC.getParent() != null) {
                ((ViewGroup) this.hgC.getParent()).removeView(this.hgC);
                this.hgC = null;
            }
            bWT().haC.setVisibility(0);
            this.gTF.hbh.a(bWT().haC);
        } else {
            ccf();
            ccs();
            if (this.hht != null) {
                this.hht.setVisibility(0);
            }
            this.hgo = new com.baidu.tieba.ala.liveroom.x.a(bWT().pageContext, this.hhG);
            this.hgo.d(bWT().haC, true);
            this.hgo.nI(true);
            if (this.gQJ != null && this.gQJ.Lj() != null) {
                this.gQJ.Lj().setNeedTopAlphaShade(true);
            }
        }
        bWT().hba.setPushMirror(cct());
    }

    public void b(ao aoVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gTF.hbh.l(bWT().haB.GH());
        }
        if (!bWT().hba.isBackground() && bWT().haB.GH() != null && bWT().haB.GH().mLiveInfo != null) {
            int startPush = bWT().hba.startPush(bWT().haB.GH().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gTF.hbh.Ne();
            }
            if (startPush != 0 && bWT().hbf != null) {
                bWT().hbf.errCode = 4;
                bWT().hbf.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (aoVar != null && !aoVar.Eo() && !ccq()) {
                np(true);
                ccr();
            }
            if (this.gPF != null) {
                this.gPF.C(bWT().haB.GH());
            }
            if (this.gQv != null) {
                this.gQv.a(bWT().haB.GH());
            }
            if (this.hgt != null) {
                this.hgt.f(bWT().haB.GH());
                this.hgt.hG(this.otherParams);
            }
            if (this.gPF != null) {
                this.gPF.nj(true);
            }
            if (this.hgl != null) {
                this.hgl.C(bWT().haB.GH());
            }
            if (aoVar == null || aoVar.aIe == null) {
                z = com.baidu.live.d.AZ().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = aoVar.aIe.canUseChallenge;
                com.baidu.live.d.AZ().putBoolean("ala_master_can_use_challenge", z);
            }
            bVT();
            ccg();
            cbQ();
            nn(z);
            bUK();
            cch();
            ccl();
            D(bWT().haB.GH());
            g(bWT().haB.GH());
            ccm();
            ccn();
            cbL();
            cck();
            bVQ();
            bVS();
            bUJ();
            bVE();
            bVM();
            bVN();
            ccd();
            cce();
            E(bWT().haB.GH());
            bVF();
            if (this.gQI != null) {
                this.gQI.h(bWT().haB.GH());
            }
            if (this.gQJ != null) {
                if (bWT().haB.GH() != null && bWT().haB.GH().aIQ != null && bWT().haB.GH().aIQ.DH()) {
                    z2 = true;
                }
                this.gQJ.a(String.valueOf(bWT().haB.GH().mLiveInfo.group_id), String.valueOf(bWT().haB.GH().mLiveInfo.last_msg_id), String.valueOf(bWT().haB.GH().aIe.userId), String.valueOf(bWT().haB.GH().mLiveInfo.live_id), bWT().haB.GH().aIe.appId, z2);
            }
            if (this.gQK != null) {
                this.gQK.a(bWT().haB.GH(), true);
            }
            cbM();
            this.mHandler.post(this.hhv);
        }
    }

    private void cbL() {
        if (this.hgm != null && bWT() != null && bWT().haB != null) {
            if (this.hgm.aw(this.hgy)) {
                this.hgm.w(bWT().haB.GH());
            } else {
                this.hgm.c(this.hgy, bWT().haB.GH());
            }
        }
    }

    private void bUK() {
        if (this.bqg == null) {
            this.bqg = new PendantParentView(bWT().pageContext.getPageActivity(), this.gSq ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            bWT().haC.addView(this.bqg, layoutParams);
            this.bqg.setDefaultItemMargin(bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.bqg.setPadding(bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20), 0, bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6), 0);
            bWw();
        }
    }

    private void bWw() {
        if (this.bqg != null) {
            int dimensionPixelSize = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278);
            int dimensionPixelSize2 = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bqg.getLayoutParams();
            if (this.gSq) {
                this.bqg.setPosition(0, 0, this.hhk.bWC(), dimensionPixelSize2);
            } else {
                this.bqg.setPosition(dimensionPixelSize, 0, bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds278), dimensionPixelSize2);
            }
            this.bqg.setLayoutParams(layoutParams);
            this.bqg.setModel(this.gSq ? PendantParentView.Model.VERTICAL_PK : PendantParentView.Model.VERTICAL);
        }
    }

    private void bWx() {
        if (this.gQJ != null && this.gQJ.Lj() != null && this.gQJ.Lj().getView() != null) {
            if (this.gSq && !this.hgj && bWT().haC != null && bWT().haC.getHeight() > 0) {
                int bj = this.hhk != null ? this.hhk.bj(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.gQJ.Lj().getView().getLayoutParams();
                int height = bWT().haC.getHeight() - bj;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.gQJ.Lj().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.af.b.i(false, this.hgj);
            if (bWT().haC.indexOfChild(this.gQJ.Lj().getView()) != -1 && this.gQJ.Lj().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gQJ.Lj().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.gQJ.Lj().getView().setLayoutParams(layoutParams2);
            }
            this.gQJ.Lj().Li();
        }
    }

    private void bWy() {
        if (this.gQL != null) {
            if (this.gSq && !this.hgj && bWT().haC != null && bWT().haC.getHeight() > 0) {
                this.gQL.dU((bWT().haC.getHeight() - (this.hhk != null ? h.j(bWT().pageContext.getPageActivity(), true) : 0)) + bWT().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height));
            } else {
                this.gQL.dU(com.baidu.live.af.a.a(bWT().pageContext.getPageActivity(), true, false, this.hgj));
            }
        }
    }

    private void bWz() {
        int i;
        if (this.gQL != null) {
            int h = com.baidu.live.af.a.h(true, false);
            if (!this.gSq || bWT().haC == null || bWT().haC.getHeight() <= 0) {
                i = h;
            } else {
                i = (bWT().haC.getHeight() - (this.hhk != null ? this.hhk.bj(false) : 0)) + bWT().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_im_entereffect_height);
            }
            this.gQL.dV(i);
        }
    }

    private void bWA() {
        if (this.gQK != null && this.gQK.Cr() != null) {
            ViewGroup.LayoutParams layoutParams = this.gQK.Cr().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bWT().pageContext.getResources().getDimensionPixelOffset(this.gSq ? a.e.sdk_ds100 : a.e.sdk_ds20);
                this.gQK.Cr().setLayoutParams(layoutParams);
            }
        }
    }

    private void cbM() {
        boolean z = (bWT().haB == null || bWT().haB.cdL() == null || bWT().haB.cdL().mLiveInfo.videoBBChatData == null || !bWT().haB.cdL().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
        if (!z && bWT().haB != null && bWT().haB.GH() != null && bWT().haB.GH().mLiveInfo != null && bWT().haB.GH().mLiveInfo.videoBBChatData != null && bWT().haB.GH().aIM) {
            z = bWT().haB.GH().mLiveInfo.videoBBChatData.videoBBChatSwitch;
        }
        if (this.hgL != null) {
            this.hgL.setVisibility(z ? 0 : 8);
        }
        cbN();
    }

    private void cbN() {
        CustomResponsedMessage runTask;
        if (this.hhl == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.ah.a.class, bWT().pageContext)) != null && runTask.getData() != null) {
            this.hhl = (com.baidu.live.ah.a) runTask.getData();
        }
        if (this.hhl != null) {
            this.hhl.x((ViewGroup) bWT().rootView.findViewById(a.g.ala_live_video_chat_pendant));
            this.hhl.w(bWT().hbc);
            this.hhl.r(bWT().haB.GH());
            this.hhl.L(bWT().hba);
            this.hhl.a(bWT().hbb);
            this.hhl.a(this.bAJ);
            if (bWT().hba != null) {
                this.hhl.setMute(bWT().hba.isMute());
            }
        }
    }

    private void nn(boolean z) {
        if (this.hhk == null) {
            this.hhk = new com.baidu.tieba.ala.liveroom.challenge.e(bWT());
        }
        this.hhk.a(this.gTM, this.gTN, z);
        this.hhk.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(ax axVar, bb bbVar, bb bbVar2) {
                AlaMasterLiveRoomOpearator.this.gSq = true;
                AlaMasterLiveRoomOpearator.this.bWT().haC.hqj = false;
                if (AlaMasterLiveRoomOpearator.this.hgR != null) {
                    AlaMasterLiveRoomOpearator.this.hgR.ff(4);
                    AlaMasterLiveRoomOpearator.this.hgR.cw(true);
                }
                AlaMasterLiveRoomOpearator.this.TP();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void CY() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hhv);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bWR() {
                AlaMasterLiveRoomOpearator.this.gSq = false;
                AlaMasterLiveRoomOpearator.this.bWT().haC.hqj = false;
                if (AlaMasterLiveRoomOpearator.this.hgR != null) {
                    AlaMasterLiveRoomOpearator.this.hgR.ff(0);
                    AlaMasterLiveRoomOpearator.this.hgR.cw(false);
                }
                AlaMasterLiveRoomOpearator.this.cbP();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void bWS() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hhv);
            }
        });
        this.hhk.N(this.hfR, z);
        this.hhk.j(this.hfR, z, (this.gTN == null || this.gTN.hbi == null || this.gTN.hbi.mChallengeData == null) ? false : true);
    }

    public boolean cbO() {
        return this.hhk != null && this.hhk.bXa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TP() {
        if (this.hgp != null) {
            this.hgp.setVisible(8);
            this.hgp.setCanVisible(false);
        }
        if (this.gPK != null) {
            this.gPK.mw(true);
        }
        if (this.hgv != null) {
            this.hgv.setCanVisible(false);
            this.hgv.setVisibility(4);
        }
        if (this.hgo != null) {
            this.hgD = this.hgo.cfW();
            this.hgo.nH(false);
        }
        if (this.gRe != null) {
            this.gRe.setCanVisible(false);
        }
        if (this.gPR != null) {
            this.gPR.setCanVisible(false);
        }
        bWw();
        bWx();
        bWy();
        bWz();
        bWA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbP() {
        if (this.hgp != null) {
            this.hgp.setCanVisible(true);
        }
        if (this.gPK != null) {
            this.gPK.mw(false);
        }
        if (this.hgv != null) {
            this.hgv.setCanVisible(true);
        }
        if (this.hgo != null) {
            this.hgo.nH(this.hgD);
        }
        if (this.gRe != null) {
            this.gRe.setCanVisible(true);
        }
        if (this.gPR != null) {
            this.gPR.cu(true);
        }
        bWw();
        bWx();
        bWy();
        bWz();
        bWA();
    }

    private void cbQ() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
        layoutParams.leftMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        if (this.hgv == null) {
            this.hgv = new AlaLiveStreamStatusView(bWT().pageContext.getPageActivity());
        }
        this.hgv.setId(a.g.ala_live_room_stream_view);
        this.hgv.setVisibility(4);
        this.hgv.setLayoutParams(layoutParams);
        if (this.hgv.getParent() == null && this.hgy != null) {
            this.hgy.addView(this.hgv, layoutParams);
        }
    }

    public void cbR() {
        if (this.hgk != null && this.hgk.getVisibility() != 8 && bWT().hba.getPreview() != null) {
            bWT().hba.stopRecord();
        }
    }

    public void cbS() {
        if (bWT().hba.getPreview() != null) {
            bWT().hba.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hhi != null) {
                this.hhi.mU(false);
            }
            this.hhi = new com.baidu.tieba.ala.liveroom.h.b(bWT().hbc, bWT(), bWT().hba);
            this.hhi.a(bWT().hba.getVideoConfig(), false);
        }
        if (this.hgq != null) {
            this.hgq.ceP();
        }
        this.mHandler.post(this.hhv);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hgj = z;
        if (z) {
            if (this.hhh) {
                this.hhh = false;
                if (this.gQJ != null && this.gQJ.Lj() != null) {
                    this.gQJ.Lj().getView().setBottom(0);
                }
                if (this.gQJ != null && this.gQJ.Lk() != null) {
                    this.gQJ.Lk().getView().setBottom(0);
                }
            }
            if (this.gQL != null && this.gQL.Gg() != null) {
                this.gQL.Gg().setVisibility(8);
            }
            if (this.gQJ != null && this.gQJ.Lj() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gQJ.Lj().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.gQJ.Lj().getView().setLayoutParams(layoutParams);
            }
            if (this.gQJ != null && this.gQJ.Lk() != null && this.gQJ.Lk().getView() != null && this.gQJ.Lk().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gQJ.Lk().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.gQJ.Lk().getView().setLayoutParams(layoutParams2);
                this.gQJ.Lk().getView().setVisibility(0);
                this.gQJ.Lk().ML();
            }
            vK(8);
            vI(8);
            if (this.gQM != null && this.gQM.GG() != null) {
                this.gQM.GG().setVisibility(8);
            }
        } else {
            if (this.gQL != null && this.gQL.Gg() != null) {
                this.gQL.Gg().setVisibility(0);
            }
            if (this.gQJ != null && this.gQJ.Lj() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gQJ.Lj().getView().getLayoutParams();
                layoutParams3.bottomMargin = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.gQJ.Lj().getView().setLayoutParams(layoutParams3);
            }
            if (this.gQJ != null && this.gQJ.Lk() != null) {
                this.gQJ.Lk().hide();
            }
            vK(0);
            vI(0);
            if (this.gQM != null && this.gQM.GG() != null) {
                this.gQM.GG().setVisibility(0);
            }
        }
        if (this.hgk != null) {
            this.hgk.P(false, z);
        }
        if (this.gQK != null) {
            this.gQK.Cs();
        }
        if (this.hgR != null) {
            this.hgR.onKeyboardVisibilityChanged(z);
        }
        bWx();
        this.mHandler.post(this.hhv);
    }

    private void vI(int i) {
        if (this.gPF != null) {
            this.gPF.vw(i);
        }
        if (this.hgx != null) {
            this.hgx.setVisibility(i);
        }
        if (this.gQv != null) {
            this.gQv.getView().setVisibility(i);
        }
        if (this.hgn != null) {
            this.hgn.setVisible(i);
        }
        if (this.hgm != null) {
            this.hgm.setVisibility(i);
        }
        if (this.gPK != null) {
            this.gPK.setVisible(i);
        }
        if (this.gRk != null) {
            this.gRk.setCanVisible(i == 0);
        }
        if (this.gRg != null) {
            this.gRg.setVisible(i);
        }
        if (this.gRd != null) {
            this.gRd.setCanVisible(i == 0);
        }
        if (this.gRe != null) {
            this.gRe.setCanVisible(i == 0 && !this.gSq);
        }
        if (this.gPR != null) {
            this.gPR.cu(i == 0);
        }
        if (this.hhm != null) {
            this.hhm.setCanVisible(i == 0);
            this.hhm.refreshUI();
        }
        if (this.hgy != null) {
            this.hgy.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bWT().hbf.errCode = 1;
            vJ(a.i.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            vJ(a.i.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            vJ(a.i.stream_upload_exception);
        } else if (i == -2) {
            HR(bWT().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bWT().hba.stopRecord();
        } else if (i == -3 && this.hgk != null) {
            this.hgk.mV(false);
        }
        if (i == -4) {
            if (this.hgk == null || this.hgk.getView().getParent() == null) {
                bWT().g((short) 1);
                return;
            }
            this.hgk.bYJ();
            this.hgI.setVisibility(0);
            if (this.hgo != null) {
                this.hgo.nI(true);
            }
            bWT().haC.setBackgroundColor(bWT().pageContext.getResources().getColor(17170445));
            ccz();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        ats();
        if (i == 12001) {
            if (i2 == -1) {
                HS(O(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                P(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            bqt();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hgk == null || this.hgk.getView().getParent() == null || this.hgk.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hgk != null) {
            this.hgk.onResume();
        }
        if (this.hgU && this.hgT != null) {
            this.hgU = false;
            c(this.hgT);
        }
        if (this.gQW != null) {
            this.gQW.onResume();
        }
    }

    public void h(short s) {
        if (this.gQI != null) {
            this.gQI.GS();
        }
        if (this.gQJ != null) {
            this.gQJ.a(null);
            this.gQJ.Ct();
        }
        if (this.gQK != null) {
            this.gQK.Ct();
        }
        if (this.hhk != null) {
            this.hhk.bWZ();
        }
    }

    public boolean cbT() {
        w GH = bWT().haB.GH();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gTF.hbh.k(GH);
            if (GH != null && GH.mLiveInfo.live_status != 1) {
                ccx();
                bWT().pageContext.getPageActivity().finish();
                if (bWT().haB != null && bWT().haB.GH() != null) {
                    a(GH, 1, bWT().haB.cdU() != 1 ? bWT().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.gQJ != null) {
                this.gQJ.Lj().b(String.valueOf(GH.mLiveInfo.group_id), String.valueOf(GH.mLiveInfo.live_id), true, String.valueOf(GH.aIe.userId));
            }
            if (this.gQK != null) {
                this.gQK.a(GH);
            }
            if (this.gQv != null) {
                this.gQv.a(bWT().haB.GH());
            }
            if (this.gPF != null) {
                this.gPF.C(GH);
            }
            if (GH != null) {
                if (this.hhk != null) {
                    this.hhk.a(GH);
                }
                if (this.gQM != null && GH.mLiveInfo != null) {
                    this.gQM.a(GH.mLiveInfo, GH.aIe);
                }
                if (this.gRk != null) {
                    this.gRy = this.gRk.p(GH);
                }
                if (this.gPK != null) {
                    this.gPK.mx(this.gRy);
                    this.gPK.j(GH);
                    this.gPK.updateView();
                }
                if (this.gRd != null) {
                    this.gRd.a(GH);
                }
                if (this.gRe != null) {
                    this.gRe.a(GH);
                }
                if (this.gRf != null) {
                    this.gRf.a(GH);
                }
                if (this.gRg != null) {
                    this.gRg.a(GH);
                }
                if (GH.mLiveInfo.live_status != 1) {
                    ccx();
                    bWT().pageContext.getPageActivity().finish();
                    if (bWT().haB != null && bWT().haB.GH() != null) {
                        a(GH, 1, bWT().haB.cdU() != 1 ? bWT().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.hgt != null) {
                    this.hgt.i(GH);
                }
            }
        }
        return false;
    }

    public void cbU() {
        cbI();
    }

    public void cbV() {
        if (this.hhi != null) {
            this.hhi.bYD();
        }
    }

    public void cbW() {
        if (this.hgk != null && this.hgk.getVisibility() != 8) {
            if (bWT().bYP() == 2) {
                ccz();
            } else {
                ccy();
            }
        }
        if (this.hgk != null && this.hgk.getVisibility() != 8) {
            if (bWT().bYP() == 1) {
                this.hgk.onResume();
            }
            this.hgk.onRefresh();
        }
        if (this.hgt != null) {
            this.hgt.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.gRt && this.hgN != null) {
            if (this.gQJ != null) {
                this.gQJ.Lj().getView().setVisibility(0);
            }
            if (this.gQJ != null) {
                this.gQJ.Lk().show();
                this.gQJ.Lk().setEditText(" @" + this.hgN.getNameShow() + " ");
            }
            vK(8);
            this.gRt = false;
        }
        if (this.hhn != null) {
            this.hhn.resume();
        }
        if (this.hho != null) {
            this.hho.resume();
        }
        if (this.gFm != null) {
            this.gFm.resume();
        }
    }

    public void onPause() {
        if (this.hgt != null) {
            this.hgt.onPause();
        }
        if (this.hhn != null) {
            this.hhn.pause();
        }
        if (this.gQW != null) {
            this.gQW.onPause();
        }
        if (this.hho != null) {
            this.hho.pause();
        }
        if (this.gFm != null) {
            this.gFm.pause();
        }
    }

    private void cbX() {
        if (bk.c(com.baidu.live.z.a.Pq().bsy)) {
            this.hgI.setVisibility(0);
            this.hgI.setAlpha(0.2f);
        } else if (bWT().hba.hasBeauty() < 0) {
            this.hgI.setVisibility(8);
        } else {
            this.hgI.setVisibility(0);
        }
    }

    private void cbY() {
        this.hgw = (RelativeLayout) bWT().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.hgz = (RelativeLayout) bWT().rootView.findViewById(a.g.under_live_view_panel);
        this.hgA = (RelativeLayout) bWT().rootView.findViewById(a.g.over_live_view_panel);
        this.hgB = (FrameLayout) bWT().rootView.findViewById(a.g.goods_parent);
        this.gTF.haC.setOnLiveViewScrollListener(this.hhK);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hgz.setVisibility(8);
            this.hgA.setVisibility(8);
            bWT().haC.removeAllViews();
            return;
        }
        this.hgx = (RelativeLayout) bWT().rootView.findViewById(a.g.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgx.getLayoutParams();
        layoutParams.topMargin = this.gTF.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hgx.setLayoutParams(layoutParams);
        this.hgy = (RelativeLayout) bWT().rootView.findViewById(a.g.ala_live_top_pendant_container);
        if (this.gPI == null) {
            this.gPI = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.gTF.pageContext.getPageActivity(), false);
        }
        this.gPI.a(this.gQm);
        this.gPI.a(this.hgx, a.g.ala_live_room_host_header_stub, 1L);
        this.gPI.setVisible(0);
        cbZ();
        this.hgI = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.hgM = (TextView) bWT().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn_num);
        this.hgI.setOnClickListener(this.hhC);
        this.hgK = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_paster);
        this.hgK.setOnClickListener(this.hhC);
        if (com.baidu.live.z.a.Pq().bsy != null && com.baidu.live.z.a.Pq().bsy.aOy != null && com.baidu.live.z.a.Pq().bsy.aOy.Es() && bk.b(com.baidu.live.z.a.Pq().bsy)) {
            this.hgK.setVisibility(0);
        } else {
            this.hgK.setVisibility(8);
        }
        cbX();
        this.hgH = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.hgH.setOnClickListener(this.hhC);
        this.hgF = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.hgF.setOnClickListener(this.hhC);
        this.gTM = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.gTM.setOnClickListener(this.hhC);
        this.hgL = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_vedio_chat);
        this.hgL.setOnClickListener(this.hhC);
        this.hgG = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.hgG.setOnClickListener(this.hhC);
        this.hgJ = (ImageView) bWT().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.hgJ.setOnClickListener(this.hhC);
        ccc();
        if (bk.b(com.baidu.live.z.a.Pq().bsy)) {
            this.hhi = new com.baidu.tieba.ala.liveroom.h.b(bWT().hbc, bWT(), bWT().hba);
        }
        this.gQI = new m();
        cca();
        ccb();
        if (com.baidu.live.d.AZ().getInt("beauty_new_bubble", 1) == 1) {
            this.hgM.setVisibility(0);
        }
    }

    private void cbZ() {
        this.hht = (FrameLayout) View.inflate(bWT().pageContext.getPageActivity(), a.h.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hht != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hht.setVisibility(8);
            if (this.hht.getParent() != null && (this.hht.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hht.getParent()).removeView(this.hht);
            }
            this.hgw.addView(this.hht, layoutParams);
            if (this.hht != null) {
                this.hht.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.gQm.p(AlaMasterLiveRoomOpearator.this.hht, 8);
                    }
                });
            }
        }
    }

    private void cca() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, bWT().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.gQJ = (k) runTask.getData();
            this.gQJ.setFromMaster(true);
            this.gQJ.Lj().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bWT().pageContext.getPageActivity()) * 0.75f), com.baidu.live.af.b.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.af.b.cN(true);
            bWT().haC.addView(this.gQJ.Lj().getView(), layoutParams);
            this.gQJ.Lk().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bWT().haC.addView(this.gQJ.Lk().getView(), layoutParams2);
            this.gQJ.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // com.baidu.live.im.k.a
                public boolean Lm() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Ln() {
                }

                @Override // com.baidu.live.im.k.a
                public void hC(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Lo() {
                }

                @Override // com.baidu.live.im.k.a
                public void Lp() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Lq() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int Lr() {
                    return 0;
                }
            });
        }
    }

    private void ccb() {
        View Cr;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, bWT().pageContext);
        if (runTask != null) {
            this.gQK = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.gQK != null && (Cr = this.gQK.Cr()) != null && this.gTF.haC.indexOfChild(Cr) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gTF.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds98));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bWT().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bWT().haC.addView(Cr, layoutParams);
        }
    }

    private void ccc() {
        CustomResponsedMessage runTask;
        if (this.hgP == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ac.a.class, bWT().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hgP = (com.baidu.live.ac.a) runTask.getData();
        }
    }

    private void ccd() {
        View Gf;
        ab.e(bWT().haB.GH());
        ab.b(bWT().pageContext, true);
        ab.GO();
        if (this.gQL == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aSH = true;
            fVar.context = bWT().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ac.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQL = (ac) runTask.getData();
                if (this.gQL != null && (Gf = this.gQL.Gf()) != null && bWT().haC.indexOfChild(Gf) < 0) {
                    if (Gf.getParent() instanceof ViewGroup) {
                        ((ViewGroup) Gf.getParent()).removeView(Gf);
                    }
                    bWT().haC.addView(Gf, bWT().haC.getLayoutParams());
                }
            }
        }
    }

    private void cce() {
        if (!this.hhu) {
            this.hhu = true;
            com.baidu.live.entereffect.a.EF().requestData(true);
        }
    }

    protected void bVN() {
        View GG;
        if (this.gQM == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aSH = true;
            aVar.context = bWT().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, aa.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQM = (aa) runTask.getData();
            }
        }
        if (this.gQM != null && (GG = this.gQM.GG()) != null && this.hgy != null) {
            if (this.hgy.indexOfChild(GG) < 0) {
                if (GG.getParent() instanceof ViewGroup) {
                    ((ViewGroup) GG.getParent()).removeView(GG);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hgn != null && this.hgn.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
                    layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                } else if (this.gRg != null && this.gRg.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_rank_level_entry);
                    layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                } else if (this.gRf != null && this.gRf.isShowing()) {
                    layoutParams.addRule(3, a.g.ala_rank_level_entry);
                    layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                } else {
                    layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds66);
                }
                this.hgy.addView(GG, layoutParams);
            }
            GG.bringToFront();
        }
    }

    protected void bVM() {
        View GT;
        if (this.gQW == null) {
            aj ajVar = new aj();
            ajVar.aSH = true;
            ajVar.pageContext = bWT().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, af.class, ajVar);
            if (runTask != null && runTask.getData() != null) {
                this.gQW = (af) runTask.getData();
            }
        }
        if (this.gQW != null && (GT = this.gQW.GT()) != null && bWT().haC.indexOfChild(GT) < 0) {
            if (GT.getParent() instanceof ViewGroup) {
                ((ViewGroup) GT.getParent()).removeView(GT);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bWT().haC.addView(GT, layoutParams);
        }
    }

    private void ccf() {
        ccj();
        bVR();
        cci();
        bWT().haC.setVisibility(0);
        vK(0);
    }

    private void ccg() {
        if (this.hgn == null) {
            this.hgn = new com.baidu.tieba.ala.liveroom.v.a(bWT().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hgn.a(bWT().bYP(), j, TbadkCoreApplication.getCurrentAccountName(), true, bWT().haB.GH().aIe.portrait, this.otherParams, "", -1L);
        this.hgn.av(this.hgy);
    }

    private void cch() {
        if (this.hgR == null) {
            bWT().haC.hqj = false;
            com.baidu.live.aa.a fc = fc(bWT().pageContext.getPageActivity());
            if (fc != null) {
                this.hgR = fc;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.aa.a.class, bWT().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hgR = (com.baidu.live.aa.a) runTask.getData();
                }
            }
            if (this.hgR != null) {
                this.hgR.t(this.hgz);
                this.hgR.u(this.hgA);
                this.hgR.fe((bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bWT().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                this.hgR.v(bWT().haC);
                this.hgR.a(this.gPf);
                this.hgR.setLiveShowInfo(bWT().haB.GH());
                this.hgR.a(this.gPK);
                this.hgR.PK();
                this.hgR.a(new a.InterfaceC0168a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                    @Override // com.baidu.live.aa.a.InterfaceC0168a
                    public void PL() {
                    }

                    @Override // com.baidu.live.aa.a.InterfaceC0168a
                    public void PM() {
                    }

                    @Override // com.baidu.live.aa.a.InterfaceC0168a
                    public void K(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.bWT().hba != null) {
                            AlaMasterLiveRoomOpearator.this.bWT().hba.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.aa.a.InterfaceC0168a
                    public int PN() {
                        return AlaMasterLiveRoomOpearator.this.hgx.getBottom();
                    }

                    @Override // com.baidu.live.aa.a.InterfaceC0168a
                    public int PO() {
                        return AlaMasterLiveRoomOpearator.this.gTF.haC.getHeight() - (AlaMasterLiveRoomOpearator.this.gQJ.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.gQJ.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.aa.a.InterfaceC0168a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.gQJ.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.aa.a.InterfaceC0168a
                    public int PP() {
                        return AlaMasterLiveRoomOpearator.this.gQJ.Ll();
                    }
                });
            }
        }
    }

    private com.baidu.live.aa.a fc(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aw(context);
        }
        return null;
    }

    private void cci() {
        if (this.hgp == null) {
            this.hgp = new b(bWT().pageContext, bWT().haC);
        }
    }

    private void ccj() {
        if (this.gPF == null) {
            this.gPF = new com.baidu.tieba.ala.liveroom.p.a(bWT().pageContext, true, this.hhG);
            this.gPF.d(this.hgx, null);
            this.gPF.a(this.gQm);
            this.gPF.nj(false);
        }
        if (this.hgl == null) {
            this.hgl = new com.baidu.tieba.ala.liveroom.p.a(bWT().pageContext, true, null);
            this.hgl.a(this.hgx, null, a.g.ala_live_room_host_header_stub);
            this.hgl.caB();
        }
    }

    protected void bVu() {
        CustomResponsedMessage runTask;
        boolean z = false;
        ao cdL = bWT().haB.cdL();
        boolean z2 = com.baidu.live.z.a.Pq().bmJ.aMi;
        if (cdL == null || cdL.aIO) {
            z = z2;
        }
        if (z && this.gQv == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bWT().pageContext)) != null) {
            this.gQv = (com.baidu.live.h.a) runTask.getData();
            if (this.gQv != null) {
                this.gQv.setIsHost(true);
                this.gQv.eF(1);
                View view = this.gQv.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bWT().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bWT().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.hgx.addView(view, layoutParams);
                }
            }
        }
    }

    private void g(w wVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.gPK == null) {
            this.gPK = new com.baidu.tieba.ala.liveroom.activeview.b(bWT().pageContext);
        }
        this.gPK.setOtherParams(this.otherParams);
        this.gPK.b(wVar, false);
        this.gPK.setHost(true);
        this.gPK.a(1, this.bqg);
        this.gPK.a(2, this.bqg);
        this.gPK.mx(this.gRy);
        this.gPK.setVisible(this.hgj ? 8 : 0);
        this.gPK.a(this.gPf);
        if (this.gPf != null) {
            if (this.gPK != null) {
                alaActiveRootView2 = this.gPK.vc(1);
                alaActiveRootView = this.gPK.vc(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.gPf.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.gPf.a(alaActiveRootView);
            }
        }
    }

    private void D(w wVar) {
        CustomResponsedMessage runTask;
        if (this.gRk == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, bWT().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.v.a)) {
            this.gRk = (com.baidu.live.v.a) runTask.getData();
            if (this.gRk != null) {
                this.gRk.s(this.bqg);
            }
        }
        if (this.gRk != null) {
            this.gRy = this.gRk.p(wVar);
            this.gRk.setCanVisible(!this.hgj);
        }
    }

    protected void cck() {
        CustomResponsedMessage runTask;
        if (bWT() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.j.a.class, bWT().pageContext.getPageActivity())) != null && runTask.getData() != null && this.gRd == null) {
            this.gRd = (com.baidu.live.j.a) runTask.getData();
            this.gRd.b(this.hgy, bWc());
            if (bWT().haB != null) {
                this.gRd.a(bWT().haB.GH());
            }
            this.gRd.setCanVisible(true);
            this.gRd.bR(false);
            this.gRd.a(bWT().haB.bOQ());
        }
    }

    protected void bVQ() {
        CustomResponsedMessage runTask;
        if (bWT() != null && this.gRe == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.q.a.class, bWT().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.gRe = (com.baidu.live.q.a) runTask.getData();
            this.gRe.setIsHost(true);
            this.gRe.b(this.bqg, bWT().haB.GH());
        }
    }

    protected void bUJ() {
        if (bWT() != null) {
            if (this.gPR == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.y.a.class, bWT().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.gPR = (com.baidu.live.y.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.gPR.setIsHost(true);
            this.gPR.a(this.bqg, bWT().haB.GH().aJa);
        }
    }

    protected void bVS() {
        CustomResponsedMessage runTask;
        if (bWT() != null && this.gRf == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.i.a.class, bWT().pageContext)) != null && runTask.getData() != null) {
            this.gRf = (com.baidu.live.i.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.gRf.a(this.hgy, bWT().haB.GH(), layoutParams, this.otherParams);
        }
    }

    private void E(w wVar) {
        CustomResponsedMessage runTask;
        if (bWT() != null) {
            if (this.hgr == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.q.d.class)) != null) {
                this.hgr = (com.baidu.live.q.d) runTask.getData();
            }
            if (this.hgr != null) {
                this.hgr.Oo();
            }
            if (this.hgs == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, com.baidu.live.q.c.class);
                if (runTask2 != null) {
                    this.hgs = (com.baidu.live.q.c) runTask2.getData();
                }
                if (this.hgs != null) {
                    this.hgs.setParentView(this.gTF.haC);
                    if (wVar != null && wVar.aIe != null) {
                        this.hgs.at(wVar.aIe.userId);
                    }
                }
            }
        }
    }

    private void bVE() {
        if (this.hho == null) {
            this.hho = new com.baidu.tieba.ala.liveroom.r.c(bWT().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams bWc() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bWT().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.gRg != null && this.gRg.isShowing()) {
            layoutParams.addRule(3, a.g.ala_rank_level_entry);
            layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        } else if (this.hgn != null && this.hgn.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
        }
        return layoutParams;
    }

    private void bVR() {
        if (this.hgm == null) {
            this.hgm = new com.baidu.tieba.ala.liveroom.b.a(bWT().pageContext, true);
        }
    }

    private void ccl() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bWT().pageContext.getPageActivity();
            if (this.hgS == null) {
                this.hgS = new ImageView(pageActivity);
                this.hgS.setId(a.g.master_close_btn);
                this.hgS.setTag("master_close_btn");
                this.hgS.setImageResource(a.f.sdk_icon_bar_live_close_n);
                this.hgS.setBackgroundResource(a.f.sdk_round_btn_close_bg);
                this.hgS.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            }
            if (this.hgS.getParent() != null) {
                ((ViewGroup) this.hgS.getParent()).removeView(this.hgS);
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
            bWT().hbc.addView(this.hgS, layoutParams);
            this.hgS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.ccv();
                }
            });
            this.hgS.setVisibility(8);
        }
    }

    protected void bVT() {
        if (this.gRg == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.q.b.class, bWT().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.gRg = (com.baidu.live.q.b) runTask.getData();
            } else {
                return;
            }
        }
        if (bWT().haB.GH() != null && bWT().haB.GH().aIe != null && bWT().haB.GH().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(bWT().pageContext.getPageActivity(), a.e.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(bWT().pageContext.getPageActivity(), a.e.sdk_ds20);
            this.gRg.b(this.hgy, layoutParams, bWT().haB.GH());
        }
    }

    private void ccm() {
        CustomResponsedMessage runTask;
        if (this.hhm == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.a.a.class, bWT().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.a)) {
            this.hhm = (com.baidu.live.a.a) runTask.getData();
            if (this.hhm != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bWT().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.hhm.b(this.hgy, layoutParams);
            }
        }
        if (this.hhm != null) {
            this.hhm.a(bWT().haB.GH());
        }
    }

    private void ccn() {
        CustomResponsedMessage runTask;
        if (this.hhn == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.a.b.class, bWT().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.a.b)) {
            this.hhn = (com.baidu.live.a.b) runTask.getData();
        }
    }

    private void bVF() {
        if (this.gFm == null) {
            this.gFm = new com.baidu.live.ai.a(bWT().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.hhk != null) {
            this.hhk.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bWT().pageContext.registerListener(this.gRQ);
        bWT().pageContext.registerListener(this.hhw);
        bWT().pageContext.registerListener(this.gRS);
        bWT().pageContext.registerListener(this.gRT);
        bWT().pageContext.registerListener(this.hhD);
        bWT().pageContext.registerListener(this.bBv);
        bWT().pageContext.registerListener(this.gNU);
        bWT().pageContext.registerListener(this.hhE);
        bWT().pageContext.registerListener(this.gRR);
        bWT().pageContext.registerListener(this.gQh);
        bWT().pageContext.registerListener(this.gRX);
        bWT().pageContext.registerListener(this.hhA);
        bWT().pageContext.registerListener(this.hhB);
        bWT().pageContext.registerListener(this.hhx);
        bWT().pageContext.registerListener(this.bmq);
        bWT().pageContext.registerListener(this.bmr);
        bWT().pageContext.registerListener(this.hhy);
        bWT().pageContext.registerListener(this.gSa);
        bWT().pageContext.registerListener(this.gRZ);
        bWT().pageContext.registerListener(this.gSb);
        bWT().pageContext.registerListener(this.hhz);
        bWT().pageContext.registerListener(this.hhy);
        bWT().pageContext.registerListener(this.blw);
        bWT().pageContext.registerListener(this.bhR);
        bWT().pageContext.registerListener(this.gFn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void no(boolean z) {
        if (bk.c(com.baidu.live.z.a.Pq().bsy)) {
            bWT().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
        } else if (bWT().hbe.Cg() == null || ListUtils.isEmpty(bWT().hbe.Cg().aDr)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                bWT().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
            } else if (!this.hhp) {
                this.hhq = BdUniqueId.gen();
                bWT().hbe.a(this.hhq);
                this.hhp = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(bWT().pageContext.getPageActivity(), bWT().rootView);
            vK(8);
            if (bWT().hba.hasAdvancedBeauty() && this.hhi != null) {
                if (!this.hhr || this.hgk.getVisibility() == 0) {
                    this.hhi.a(bWT().hba.getVideoConfig());
                }
                this.hhi.a(bWT().hba.getVideoConfig(), this.hhj);
                if (!this.hhj) {
                    this.hhj = true;
                }
            }
            if (z && this.gQJ != null) {
                this.gQJ.Lj().getView().setVisibility(4);
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
    public void vJ(int i) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bWT().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(i, currentAppType(bWT().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bWT().g((short) 1);
            }
        });
        bdAlertDialog.create(bWT().pageContext).show();
    }

    private void HR(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bWT().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bWT().g((short) 1);
            }
        });
        bdAlertDialog.create(bWT().pageContext).show();
    }

    public void cco() {
        bVu();
        q bOQ = bWT().haB.bOQ();
        int i = 5;
        if (bOQ != null) {
            i = (int) bOQ.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bWT().haB.GH() != null && AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bWT().haB.h(AlaMasterLiveRoomOpearator.this.bWT().haB.GH().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bOQ != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.gTF.hbh.b(bOQ);
                return;
            }
            if (this.gPE == null) {
                this.gPE = new c(bWT().pageContext, this.hhG, true);
            }
            if (this.hhg) {
                this.hhg = false;
                this.gPE.a(String.valueOf(bWT().haB.GH().mLiveInfo.group_id), String.valueOf(bWT().haB.GH().mLiveInfo.live_id), String.valueOf(bWT().haB.GH().aIe.userId), bWT().haB.GH());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.gQv != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.gPE.c(this.hgx, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.gPE.e(bOQ);
            this.gPI.setVisible(0);
            this.gPI.ea(bOQ.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccp() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqt() {
        if (bWT().haB != null) {
            if (this.gQw == null) {
                this.gQw = new com.baidu.tieba.ala.liveroom.share.c(bWT().pageContext);
            }
            this.gQw.c(bWT().haB.GH(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bWT().haB != null && bWT().haB.GH() != null && bWT().haB.GH().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bWT().haB.GH().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bWT().haB.GH().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bWT().haB.GH().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bWT().haB != null && bWT().haB.GH() != null && bWT().haB.GH().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bWT().haB.GH().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bWT().haB.GH().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bWT().haB.GH().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean ccq() {
        return this.hgi;
    }

    private void np(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hgh, z);
        this.hgi = z;
    }

    private void ccr() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bWT().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.q.b(AlaMasterLiveRoomOpearator.this.bWT().pageContext).cdt();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bWT().pageContext).show();
    }

    private void ccs() {
        if (this.hfR && bWT().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bWT().hbg.QI();
        }
        bWT().hbf.prepareTime = System.currentTimeMillis() - bWT().hbf.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bWT().haB != null && bWT().haB.GH() != null && bWT().haB.GH().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bWT().haB.GH().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bWT().haB.GH().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bWT().hbf.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hgk != null && this.hgk.getView().getParent() != null) {
            this.hgk.setVisibility(8);
            bWT().hbc.removeView(this.hgk.getView());
            this.hgk.release();
        }
        if (this.hhi != null) {
            this.hhi.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bWT().haC.indexOfChild(this.hgu) < 0) {
            bWT().haC.addView(this.hgu, layoutParams);
        }
        this.hgu.wa(1000);
    }

    private void ats() {
        if (bWT().bYP() == 1) {
            bWT().hba.startRecord();
        }
    }

    private void HS(String str) {
        HT(str);
    }

    private void HT(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bWT().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hgk != null) {
            this.hgk.HF(fromJson.getSmallurl());
        }
    }

    private boolean cct() {
        return com.baidu.live.d.AZ().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccu() {
        com.baidu.live.d.AZ().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.gTF.hba.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccv() {
        if (this.hhl == null || !this.hhl.Sg()) {
            int i = a.i.live_close_confirm;
            if (this.hhk != null && this.hhk.bXb()) {
                i = a.i.ala_pk_pking_close_live_roon_tip;
            } else if (this.hhk != null && this.hhk.bXa()) {
                i = a.i.ala_challenge_challenging_close_live_room_tip;
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(bWT().pageContext.getPageActivity());
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
                    if (AlaMasterLiveRoomOpearator.this.bWT().haB.GH() != null) {
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bWT().haB.GH(), 0, AlaMasterLiveRoomOpearator.this.bWT().haB.cdU() != 1 ? AlaMasterLiveRoomOpearator.this.bWT().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
            bdAlertDialog.create(bWT().pageContext).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(w wVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (wVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = wVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = wVar.aIe;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bWT().haB.ey(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.hhe) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bWT().hbf;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bWT().hba.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hha;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hhb;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hgW;
            if (this.hgX != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hgY - this.hgZ) / this.hgX) * 100.0f;
            }
            Intent intent = new Intent(bWT().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bWT().haB != null && bWT().haB.GH() != null && bWT().haB.GH().aIe != null) {
                String str3 = bWT().haB.GH().aIe.nickName;
                String str4 = bWT().haB.GH().aIe.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            w GH = bWT().haB.GH();
            if (GH != null && GH.aIe != null && !TextUtils.isEmpty(GH.aIe.portrait)) {
                intent.putExtra("host_portrait", GH.aIe.portrait);
            }
            if (this.hhl != null) {
                this.hhl.Sh();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hhc = intent;
                this.hhd = s;
                bWT().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void ccw() {
        if (this.hhc != null) {
            a(this.hhc, this.hhd);
            this.hhc = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hhe = true;
        if (this.hhk != null) {
            this.hhk.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.gNJ);
            bWT().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bWT().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccx() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.gTF.hbh != null && this.gTF.hbh.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hhk != null && this.hhk.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hhl != null && this.hhl.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bWT().hbd.cdc()) {
                ccv();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            if (this.hgv != null) {
                this.hgv.setVisibility(4);
                return;
            }
            return;
        }
        if (this.hgv != null) {
            this.hgv.a(i, z, i2, z2);
        }
        if (this.gTF != null && this.gTF.haB != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.duj != i3) {
                this.duj = i3;
                if (this.hgq == null) {
                    this.hgq = new com.baidu.tieba.ala.liveroom.tippop.a(this.gTF.pageContext, null);
                }
                switch (this.duj) {
                    case 0:
                        this.hgq.a(this.gTF.hbc, this.gTF.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hgq.a(this.gTF.hbc, this.gTF.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hgq.a(this.gTF.hbc, this.gTF.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.gTF.haB.r(this.gTF.haB.GH().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void E(com.baidu.live.im.data.a aVar) {
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
                        AlaMasterLiveRoomOpearator.this.ccx();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bWT().haB.GH(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x0651, code lost:
        Hv(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020 A[Catch: JSONException -> 0x075c, TRY_LEAVE, TryCatch #7 {JSONException -> 0x075c, blocks: (B:8:0x0018, B:10:0x0020, B:231:0x0751), top: B:263:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0751 A[Catch: JSONException -> 0x075c, TRY_ENTER, TRY_LEAVE, TryCatch #7 {JSONException -> 0x075c, blocks: (B:8:0x0018, B:10:0x0020, B:231:0x0751), top: B:263:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(com.baidu.live.im.data.a aVar) {
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
        if (aVar.getMsgType() == 125) {
            if (this.hgo != null) {
                this.hgo.G(aVar);
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
                            if (this.hhk != null) {
                            }
                            if (!"close_live".equals(str2)) {
                            }
                            if (!(aVar.getObjContent() instanceof JSONObject)) {
                            }
                            try {
                                jSONObject6.put("log_id", aVar.getMsgId());
                            } catch (JSONException e2) {
                            }
                            if (this.gRf != null) {
                            }
                            if (this.gRe != null) {
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
            if (this.hhk != null) {
                this.hhk.gc(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.ccx();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bWT().haB.GH(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bWT().haB.GH() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bWT().haB.GH().aIA.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bWT().haB.GH().aIA.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bWT().haB.GH().aIA.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (bWT().haB.GH() != null && jSONObject2 != null) {
                    long optLong2 = jSONObject2.optLong("user_id");
                    if (bWT().haB.GH() != null && bWT().haB.GH().aIe != null && bWT().haB.GH().aIe.userId == optLong2) {
                        bWT().haB.GH().aIe.isUegBlock = 1;
                        bUZ();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (bWT().haB.GH() != null && jSONObject2 != null) {
                    long optLong3 = jSONObject2.optLong("user_id");
                    if (bWT().haB.GH() != null && bWT().haB.GH().aIe != null && bWT().haB.GH().aIe.userId == optLong3) {
                        bWT().haB.GH().aIe.isUegBlock = 0;
                        bUZ();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hgP != null) {
                    this.hgP.R(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.hgp.aH(optString4, optInt2);
                    }
                    if (this.gPI.getCount() > 20) {
                        this.gPI.ea(this.gPI.getCount() + 1);
                    } else if (this.gPE != null) {
                        com.baidu.live.data.a LO = aVar.LO();
                        com.baidu.live.data.p pVar = new com.baidu.live.data.p();
                        pVar.aIf = new AlaLocationData();
                        pVar.aIg = new AlaRelationData();
                        pVar.aIe = new AlaLiveUserInfoData();
                        pVar.aIe.userId = JavaTypesHelper.toLong(LO.userId, 0L);
                        pVar.aIe.userName = LO.userName;
                        pVar.aIe.portrait = LO.portrait;
                        if (this.gPE.c(pVar)) {
                            this.gPI.ea(this.gPI.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bWT() != null && bWT().haB != null && bWT().haB.GH() != null && bWT().haB.GH().aIA != null && bWT().haB.GH().aIA.userId == jSONObject2.optLong("user_id")) {
                    bWT().haB.cdK();
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
                    com.baidu.live.data.a LO2 = aVar.LO();
                    if (LO2 != null && ab.ha(str6)) {
                        ab.d(str6, 1L, "", "", LO2.userId, LO2.portrait, LO2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject2 != null) {
                    ay ayVar = new ay();
                    ayVar.parseJson(jSONObject2);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, ayVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject2 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject2));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString5 = jSONObject2.optString("challenge_im_type");
                    if (TextUtils.equals(optString5, "start")) {
                        HU(jSONObject2.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString5, "cancel")) {
                        BdUtilHelper.showToast(bWT().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
                    }
                }
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(bWT().pageContext.getPageActivity(), a.i.ala_challenge_cancel_tip);
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a LO3 = aVar.LO();
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
                boolean z3 = jSONObject5.optInt("from_gongyanfang_page") == 1;
                String str7 = null;
                if (bWT().haB == null || bWT().haB.GH() == null || bWT().haB.GH().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                    str3 = "";
                    str4 = "";
                    z = false;
                } else {
                    long j4 = bWT().haB.GH().mLiveInfo.live_id;
                    long j5 = bWT().haB.GH().mLiveInfo.group_id;
                    long j6 = bWT().haB.GH().aIe.userId;
                    str7 = bWT().haB.GH().mLiveInfo.appId;
                    boolean z4 = bWT().haB.GH().mLiveInfo.isPubShow;
                    if (bWT().haB.GH().mLiveSdkInfo.mCastIds == null) {
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = "";
                        str4 = "";
                        z = z4;
                    } else {
                        String str8 = bWT().haB.GH().mLiveSdkInfo.mCastIds.chatMCastId;
                        j = j6;
                        j2 = j5;
                        j3 = j4;
                        str3 = bWT().haB.GH().mLiveSdkInfo.mCastIds.ensureMCastId;
                        str4 = str8;
                        z = z4;
                    }
                }
                LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString7, "");
                if (!this.isBackground || bWT().bYP() != 2) {
                    if (!TextUtils.isEmpty(optString13) && !TextUtils.isEmpty(optString14)) {
                        if (jSONObject5.optInt("flag_show") == 1) {
                            ab.b(optString14, LO3.userId, LO3.portrait, LO3.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString13, "", "", aVar.getMsgId());
                            try {
                                JSONArray jSONArray = new JSONArray(optString14);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.z.f.PF().hS(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                        aVar.setHost(z && z3);
                        ab.a(optString7, Integer.parseInt(optString8), optString9, optString10, LO3.userId, LO3.portrait, LO3.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString12, str4, str3, !z3, aVar.getMsgId(), z2, jSONObject5, optString11);
                    }
                }
                Hv(optString7);
                if (!jSONObject5.optString("content_type").equals("tying_gift")) {
                    com.baidu.tieba.ala.liveroom.g.c cVar = new com.baidu.tieba.ala.liveroom.g.c();
                    cVar.hag = optLong5;
                    cVar.liveId = j3;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar));
                }
                JSONObject jSONObject7 = new JSONObject();
                try {
                    jSONObject7.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                    jSONObject7.putOpt("gift_name", optString9);
                    jSONObject7.putOpt("order_id", optString6);
                    com.baidu.live.gift.g gW = ab.gW(optString7);
                    if (gW != null) {
                        jSONObject7.putOpt(LogConfig.LOG_GIFT_VALUE, gW.getPrice());
                    }
                    jSONObject7.putOpt("gift_num", optString8);
                } catch (JSONException e7) {
                    e7.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "display", UbcStatConstant.Page.AUTHOR_LIVE_ROOM, "giftsend_succ").setContentExt(null, MapController.POPUP_LAYER_TAG, jSONObject7));
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
        if (this.gRf != null) {
            this.gRf.l(aVar);
        }
        if ((this.gRe != null || !this.gRe.O(jSONObject6)) && this.gPR != null && this.gPR.O(jSONObject6)) {
        }
    }

    private void Hv(String str) {
        if (this.gPK != null) {
            this.gPK.Hv(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vK(int i) {
        View findViewById = bWT().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.gPK != null) {
            this.gPK.bK(2, i);
        }
    }

    private void ccy() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bWT().hba != null && AlaMasterLiveRoomOpearator.this.bWT().hba.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bWT().hba.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bWT().hba.startRecord();
                }
            }
        });
    }

    private void ccz() {
        if (bWT().hba != null && bWT().hba.getPreview() != null) {
            bWT().hba.getPreview().setVisibility(8);
            bWT().hba.stopRecord();
        }
    }

    public void ccA() {
        this.haX = bWT().haB.cdV();
        if (this.hgk != null) {
            this.hgk.mW(this.haX);
        }
    }

    public void bYN() {
        if (TbadkCoreApplication.getInst().isOther()) {
            ccB();
        } else if (this.hgk != null) {
            this.hgk.bYN();
        }
    }

    public void mX(boolean z) {
        if (this.hgk != null) {
            this.hgk.mX(z);
        }
    }

    public void onDestroy() {
        if (this.hgV != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hgV);
        }
        this.hgV = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hgO.removeCallbacksAndMessages(null);
        if (this.hhi != null) {
            this.hhi.mU(true);
        }
        this.hhi = null;
        if (this.hgk != null) {
            this.hgk.destroy();
            bWT().hbc.removeView(this.hgk.getView());
            this.hgk.release();
            this.hgk = null;
        }
        if (this.hhk != null) {
            this.hhk.onDestroy();
        }
        if (this.gQw != null) {
            this.gQw.onDestroy();
        }
        if (this.gPF != null) {
            this.gPF.onDestroy();
            this.gPF = null;
        }
        if (this.hgl != null) {
            this.hgl.onDestroy();
        }
        if (this.gQW != null) {
            this.gQW.onDestroy();
            this.gQW = null;
        }
        if (this.hgu != null) {
            this.hgu.stopCountDown();
        }
        if (this.hgn != null) {
            this.hgn.onDestroy();
        }
        if (this.hgp != null) {
            this.hgp.onDestroy();
        }
        if (this.hgP != null) {
            this.hgP.onDestroy();
            this.hgP = null;
        }
        if (this.gQL != null) {
            this.gQL.onDestroy();
            this.gQL = null;
        }
        if (this.hgr != null) {
            this.hgr.release();
        }
        com.baidu.live.ab.c.PX().release();
        ab.GP();
        com.baidu.live.entereffect.a.EF().release();
        this.hhu = false;
        if (this.gQM != null) {
            this.gQM.onDestroy();
            this.gQM = null;
        }
        if (this.hgq != null) {
            this.hgq.onDestroy();
        }
        if (this.hgo != null) {
            this.hgo.cfV();
            this.hgo.release();
        }
        if (this.gPI != null) {
            this.gPI = null;
        }
        if (this.gPK != null) {
            this.gPK.release();
        }
        if (this.hgo != null) {
            this.hgo.onDestroy();
        }
        if (this.gQK != null) {
            this.gQK.release();
        }
        if (this.hgt != null) {
            this.hgt.release();
        }
        if (this.hgR != null) {
            this.hgR.onDestroy();
        }
        if (this.gRk != null) {
            this.gRk.release();
        }
        if (this.hhm != null) {
            this.hhm.onDestory();
        }
        if (this.hhn != null) {
            this.hhn.release();
        }
        if (this.gRd != null) {
            this.gRd.onDestroy();
        }
        if (this.gRe != null) {
            this.gRe.onDestroy();
        }
        if (this.gPR != null) {
            this.gPR.onDestroy();
        }
        if (this.hgs != null) {
            this.hgs.release();
            this.hgs = null;
        }
        if (this.hho != null) {
            this.hho.release();
        }
        if (this.gFm != null) {
            this.gFm.release();
        }
        if (this.gRg != null) {
            this.gRg.onDestroy();
        }
        if (this.hhl != null) {
            this.hhl.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.gRQ);
        MessageManager.getInstance().unRegisterListener(this.hhw);
        MessageManager.getInstance().unRegisterListener(this.gRS);
        MessageManager.getInstance().unRegisterListener(this.gRT);
        MessageManager.getInstance().unRegisterListener(this.hhD);
        MessageManager.getInstance().unRegisterListener(this.bBv);
        MessageManager.getInstance().unRegisterListener(this.gNU);
        MessageManager.getInstance().unRegisterListener(this.hhE);
        MessageManager.getInstance().unRegisterListener(this.gRR);
        MessageManager.getInstance().unRegisterListener(this.gQh);
        MessageManager.getInstance().unRegisterListener(this.gRX);
        MessageManager.getInstance().unRegisterListener(this.hhA);
        MessageManager.getInstance().unRegisterListener(this.hhB);
        MessageManager.getInstance().unRegisterListener(this.hhx);
        MessageManager.getInstance().unRegisterListener(this.bmq);
        MessageManager.getInstance().unRegisterListener(this.bmr);
        MessageManager.getInstance().unRegisterListener(this.hhy);
        MessageManager.getInstance().unRegisterListener(this.gSa);
        MessageManager.getInstance().unRegisterListener(this.gRZ);
        MessageManager.getInstance().unRegisterListener(this.gSb);
        MessageManager.getInstance().unRegisterListener(this.hhz);
        MessageManager.getInstance().unRegisterListener(this.hhy);
        MessageManager.getInstance().unRegisterListener(this.blw);
        MessageManager.getInstance().unRegisterListener(this.bhR);
        MessageManager.getInstance().unRegisterListener(this.gFn);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.gTF.hbh.a(this.hhN, this.gTF.hbb, this.hgw, alaLivePersonData);
        }
    }

    private void ccB() {
        if (this.hgT != null) {
            this.gTF.hbf.startTime = System.currentTimeMillis();
            this.gTF.hbf.liveTotalTime = System.currentTimeMillis();
            this.gTF.hbf.sampleMemAndCPU();
            this.gTF.hbd.a((short) 4, this.hgT);
        }
    }

    private void HU(String str) {
        String str2;
        int i;
        if (bWT() != null && bWT().pageContext != null) {
            this.hgO.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = bWT().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hhs == null) {
                    this.hhs = layoutInflater.inflate(a.h.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hhs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.cbC()) {
                                AlaMasterLiveRoomOpearator.this.hgO.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hhs != null) {
                                    AlaMasterLiveRoomOpearator.this.bWT().haC.removeView(AlaMasterLiveRoomOpearator.this.hhs);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hhk != null) {
                                    AlaMasterLiveRoomOpearator.this.hhk.bWX();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hhs.findViewById(a.g.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.i.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.d.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hgO.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bWT().haC != null && AlaMasterLiveRoomOpearator.this.gTM != null && AlaMasterLiveRoomOpearator.this.hhs != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hhs.findViewById(a.g.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hhs.findViewById(a.g.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.A((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hhs.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.gTM.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.gTM.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.gTM.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.gTM.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hhs.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hhs.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hhs != null) {
                                AlaMasterLiveRoomOpearator.this.bWT().haC.removeView(AlaMasterLiveRoomOpearator.this.hhs);
                            }
                            AlaMasterLiveRoomOpearator.this.bWT().haC.addView(AlaMasterLiveRoomOpearator.this.hhs, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.z.a.Pq().bmJ != null) {
                    i = com.baidu.live.z.a.Pq().bmJ.aLr;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hgO.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bWT().haC != null && AlaMasterLiveRoomOpearator.this.hhs != null) {
                            AlaMasterLiveRoomOpearator.this.bWT().haC.removeView(AlaMasterLiveRoomOpearator.this.hhs);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
