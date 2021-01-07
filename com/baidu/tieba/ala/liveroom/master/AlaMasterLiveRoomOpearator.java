package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.android.imsdk.account.LoginManager;
import com.baidu.android.imsdk.internal.IMConnection;
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
import com.baidu.live.ag.a;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.AlaFilterBeautyDataMessage;
import com.baidu.live.d.i;
import com.baidu.live.d.p;
import com.baidu.live.d.u;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.as;
import com.baidu.live.data.at;
import com.baidu.live.data.bc;
import com.baidu.live.data.bd;
import com.baidu.live.data.bg;
import com.baidu.live.data.bo;
import com.baidu.live.data.q;
import com.baidu.live.data.r;
import com.baidu.live.data.x;
import com.baidu.live.gift.ab;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.ad;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.ak;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
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
import com.baidu.live.tbadk.core.util.ViewCommonUtil;
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
import com.baidu.live.u.c;
import com.baidu.live.utils.h;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.challenge.e;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.d;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.GuardClubInfoRenameResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView;
import com.baidu.tieba.ala.liveroom.views.e;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String hHg;
    private BdUniqueId bFD;
    private boolean bFE;
    private boolean bFF;
    private com.baidu.live.guardclub.a bkF;
    private boolean brO;
    private PendantParentView bzK;
    private boolean gSr;
    private String gZQ;
    private boolean hGQ;
    private RelativeLayout hHA;
    private RelativeLayout hHB;
    private RelativeLayout hHC;
    private FrameLayout hHD;
    private FrameLayout hHE;
    private View hHF;
    private boolean hHG;
    private AlaLiveFaceVerifyView hHH;
    private ImageView hHI;
    private ImageView hHJ;
    private ImageView hHK;
    private ImageView hHL;
    private ImageView hHM;
    private ImageView hHN;
    private ImageView hHO;
    private TextView hHP;
    private at hHQ;
    private com.baidu.live.o.b hHS;
    private com.baidu.live.ai.a hHT;
    private com.baidu.tieba.ala.liveroom.master.panel.b hHU;
    private com.baidu.live.ag.a hHV;
    private ImageView hHW;
    private BdAlertDialog hHX;
    private BdAlertDialog hHY;
    private d hHZ;
    private boolean hHh;
    private com.baidu.tieba.ala.liveroom.h.d hHj;
    private com.baidu.tieba.ala.liveroom.o.a hHk;
    private com.baidu.tieba.ala.liveroom.b.a hHl;
    private com.baidu.tieba.ala.liveroom.u.a hHm;
    private com.baidu.tieba.ala.liveroom.w.a hHn;
    private b hHo;
    private com.baidu.tieba.ala.liveroom.tippop.a hHp;
    private com.baidu.live.u.d hHq;
    private c hHr;
    private com.baidu.live.w.c hHs;
    private com.baidu.live.w.b hHt;
    protected com.baidu.live.n.a hHu;
    protected com.baidu.live.ao.b hHv;
    private AlaLiveCountDownView hHw;
    private AlaLiveStreamStatusView hHx;
    private RelativeLayout hHy;
    private RelativeLayout hHz;
    private short hIj;
    private com.baidu.tieba.ala.liveroom.h.b hIo;
    private e hIp;
    private com.baidu.live.an.a hIq;
    private com.baidu.live.b.a hIr;
    private com.baidu.live.b.b hIs;
    private com.baidu.tieba.ala.liveroom.q.a hIt;
    private boolean hIu;
    private boolean hIw;
    private View hIx;
    private FrameLayout hIy;
    private boolean hIz;
    private Dialog hau;
    private com.baidu.live.ap.a hfG;
    private String hoR;
    private com.baidu.live.j.a hpW;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hqC;
    private com.baidu.tieba.ala.liveroom.activeview.b hqE;
    protected com.baidu.live.ae.a hqL;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hqy;
    private com.baidu.tieba.ala.liveroom.o.a hqz;
    private m hrK;
    private k hrL;
    private com.baidu.live.im.b.a hrM;
    private ad hrN;
    private ab hrO;
    protected ag hrZ;
    private com.baidu.live.k.b hrw;
    private com.baidu.tieba.ala.liveroom.share.c hry;
    private com.baidu.tieba.ala.liveroom.r.b hrz;
    private boolean hsG;
    protected com.baidu.live.m.a hsf;
    protected com.baidu.live.w.a hsg;
    protected com.baidu.live.u.a hsh;
    protected com.baidu.live.a.a hsi;
    protected com.baidu.live.l.a hsj;
    protected com.baidu.live.u.b hsk;
    private com.baidu.live.ab.a hsp;
    protected com.baidu.live.t.a hst;
    private com.baidu.tieba.ala.liveroom.data.e huX;
    private ImageView hve;
    private f hvf;
    private boolean hHi = false;
    private boolean hsB = false;
    private Handler mHandler = new Handler();
    private Handler hHR = new Handler();
    private boolean hIa = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hIb = null;
    private boolean hIc = false;
    private int hId = 0;
    private int hIe = 0;
    private int hIf = 0;
    private long hIg = 0;
    private long hIh = 0;
    private volatile boolean isBackground = false;
    private Intent hIi = null;
    private int mOrientation = 1;
    private boolean hCd = false;
    private boolean hIk = false;
    private boolean hIl = true;
    private boolean hvc = false;
    private boolean hIm = true;
    private boolean hIn = true;
    private int dNX = 0;
    private String otherParams = "";
    private Handler hIv = new Handler();
    private BdUniqueId gQC = BdUniqueId.gen();
    private boolean mIsKeyboardOpen = false;
    private int brS = 0;
    private Runnable hIA = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.hpW != null) {
                AlaMasterLiveRoomOpearator.this.hpW.FA();
            }
        }
    };
    private com.baidu.live.an.b bPf = new com.baidu.live.an.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.an.b
        public boolean XN() {
            if (AlaMasterLiveRoomOpearator.this.hIp != null) {
                if (AlaMasterLiveRoomOpearator.this.hsh != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hIp.cfD() && !AlaMasterLiveRoomOpearator.this.hIp.cfE() && !AlaMasterLiveRoomOpearator.this.hsh.RB() && !AlaMasterLiveRoomOpearator.this.hsh.DB()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hIp.cfD() && !AlaMasterLiveRoomOpearator.this.hIp.cfE()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.hsh == null || AlaMasterLiveRoomOpearator.this.hsh.RB() || AlaMasterLiveRoomOpearator.this.hsh.DB()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.an.b
        public void XO() {
            if (AlaMasterLiveRoomOpearator.this.hIp != null) {
                AlaMasterLiveRoomOpearator.this.hIp.cfG();
            }
        }

        @Override // com.baidu.live.an.b
        public void XP() {
            AlaMasterLiveRoomOpearator.this.hIw = true;
            AlaMasterLiveRoomOpearator.this.cfB().hBQ.hRu = false;
            if (AlaMasterLiveRoomOpearator.this.hsi != null) {
                AlaMasterLiveRoomOpearator.this.hsi.ba(true);
                AlaMasterLiveRoomOpearator.this.hsi.bb(true);
            }
            AlaMasterLiveRoomOpearator.this.ceX();
        }

        @Override // com.baidu.live.an.b
        public void XQ() {
            AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12.1
                @Override // java.lang.Runnable
                public void run() {
                    AlaMasterLiveRoomOpearator.this.hIw = false;
                    AlaMasterLiveRoomOpearator.this.cfB().hBQ.hRu = false;
                    if (AlaMasterLiveRoomOpearator.this.hsi != null) {
                        AlaMasterLiveRoomOpearator.this.hsi.ba(false);
                        AlaMasterLiveRoomOpearator.this.hsi.bb(false);
                    }
                    AlaMasterLiveRoomOpearator.this.ceX();
                }
            }, 1500L);
        }
    };
    private CustomMessageListener bta = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.huX.hCo != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.huX.hCo.f(list, false);
                }
                for (com.baidu.live.im.data.b bVar : list) {
                    if (bVar != null) {
                        AlaMasterLiveRoomOpearator.this.K(bVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener btb = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.huX.hCo != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.huX.hCo.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener hta = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.hrz == null) {
                        AlaMasterLiveRoomOpearator.this.hrz = new com.baidu.tieba.ala.liveroom.r.b();
                    }
                    AlaMasterLiveRoomOpearator.this.hrz.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener htg = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hsf != null) {
                AlaMasterLiveRoomOpearator.this.hsf.LN();
            }
        }
    };
    private CustomMessageListener hIB = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hsY = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.69
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.If(str);
            }
        }
    };
    private CustomMessageListener gPf = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.70
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.byf();
        }
    };
    private CustomMessageListener hrg = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.hrO.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener hte = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hIC = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.hIs != null) {
                x HR = AlaMasterLiveRoomOpearator.this.cfB().hBP.HR();
                long j = HR.mLiveInfo.live_id;
                long j2 = HR.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.hIs.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener hID = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.cfB().hBQ);
            if (AlaMasterLiveRoomOpearator.this.hHj == null || AlaMasterLiveRoomOpearator.this.hHj.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.xl(0);
            }
            if (AlaMasterLiveRoomOpearator.this.hrL != null) {
                AlaMasterLiveRoomOpearator.this.hrL.MA().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.hrL.MB().hide();
            }
        }
    };
    private CustomMessageListener htf = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.H(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR());
        }
    };
    private CustomMessageListener htk = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hrZ != null) {
                    ((com.baidu.tieba.ala.liveroom.q.b) AlaMasterLiveRoomOpearator.this.hrZ).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener hIE = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hIt != null) {
                    AlaMasterLiveRoomOpearator.this.hIt.ie(str);
                }
            }
        }
    };
    private CustomMessageListener bFG = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hIo != null) {
                        if (!data.aFs || AlaMasterLiveRoomOpearator.this.bFD == null || !AlaMasterLiveRoomOpearator.this.hIu) {
                            if (AlaMasterLiveRoomOpearator.this.bFD != null && AlaMasterLiveRoomOpearator.this.bFD == data.aFr) {
                                if (data.aFl != null && data.aFl.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hIu || AlaMasterLiveRoomOpearator.this.hHj.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hIo.c(AlaMasterLiveRoomOpearator.this.cfB().hCg.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bFF = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.cfB().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bFD = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.cfB().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hIo.a(AlaMasterLiveRoomOpearator.this.cfB().hCg.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bFF);
                        if (!AlaMasterLiveRoomOpearator.this.bFF) {
                            AlaMasterLiveRoomOpearator.this.bFF = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bFE) {
                    AlaMasterLiveRoomOpearator.this.cfB().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.bFE = false;
            }
        }
    };
    private CustomMessageListener bFH = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.cfB().hCg != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.cfB().hCg.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.Ba().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bpW = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.brS == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.brS == 6) {
                            AlaMasterLiveRoomOpearator.this.ckd();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.brS = 0;
            }
        }
    };
    private View.OnClickListener hIF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hHJ) {
                    AlaMasterLiveRoomOpearator.this.cki();
                    AlaMasterLiveRoomOpearator.this.hHU.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hHI) {
                    if (view == AlaMasterLiveRoomOpearator.this.hHK) {
                        AlaMasterLiveRoomOpearator.this.byf();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hHL) {
                        if (view != AlaMasterLiveRoomOpearator.this.hHN) {
                            if (view == AlaMasterLiveRoomOpearator.this.hve) {
                                if (AlaMasterLiveRoomOpearator.this.ckc()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hIp != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.hsh != null) && AlaMasterLiveRoomOpearator.this.hsh.DB()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.hsh.RB() & (AlaMasterLiveRoomOpearator.this.hsh != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hIp.cfD()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hIp.cfE()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hIp.cfF();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hHM) {
                                if (AlaMasterLiveRoomOpearator.this.hHn != null) {
                                    as cmn = AlaMasterLiveRoomOpearator.this.cfB().hBP.cmn();
                                    if (cmn == null || cmn.mLiveSdkInfo == null) {
                                        str = null;
                                        str2 = null;
                                    } else {
                                        str2 = String.valueOf(cmn.mLiveSdkInfo.mRoomId);
                                        str = cmn.mLiveSdkInfo.mCastIds != null ? cmn.mLiveSdkInfo.mCastIds.chatMCastId : null;
                                    }
                                    AlaMasterLiveRoomOpearator.this.hHn.ax("", str2, str);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hHO) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hIp.cfD() || AlaMasterLiveRoomOpearator.this.hIp.cfE() || AlaMasterLiveRoomOpearator.this.hsh.RB() || AlaMasterLiveRoomOpearator.this.hsh.DB()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hIq != null) {
                                    AlaMasterLiveRoomOpearator.this.hIq.XI();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hHV != null) {
                            AlaMasterLiveRoomOpearator.this.hHV.SY();
                            AlaMasterLiveRoomOpearator.this.hHV.cQ(AlaMasterLiveRoomOpearator.this.ckq());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "beauty"));
                        AlaMasterLiveRoomOpearator.this.hIu = false;
                        AlaMasterLiveRoomOpearator.this.ot(true);
                        AlaMasterLiveRoomOpearator.this.hHP.setVisibility(4);
                        com.baidu.live.d.Ba().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.af.a.SE().bwi.aPf == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.af.a.SE().bwi.aPe == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.brO) {
                        AlaMasterLiveRoomOpearator.this.ckd();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.brS = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.ckd();
                }
            }
        }
    };
    private CustomMessageListener hsZ = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof at) {
                    AlaMasterLiveRoomOpearator.this.hsB = true;
                    AlaMasterLiveRoomOpearator.this.hHQ = (at) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.hrL != null) {
                        AlaMasterLiveRoomOpearator.this.hrL.MA().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.hrL != null) {
                        AlaMasterLiveRoomOpearator.this.hrL.MB().show();
                        String nameShow = aVar.getNameShow();
                        if (aVar.extInfoJson != null) {
                            if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                                str = aVar.extInfoJson.optString("mysterious_man_nickname");
                                if (TextUtils.isEmpty(str)) {
                                    str = "神秘人";
                                }
                                AlaMasterLiveRoomOpearator.this.hrL.MB().setEditText(" @" + str + " ");
                            }
                        }
                        str = nameShow;
                        AlaMasterLiveRoomOpearator.this.hrL.MB().setEditText(" @" + str + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.xl(8);
                }
            }
        }
    };
    private CustomMessageListener hIG = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.cfB() != null && AlaMasterLiveRoomOpearator.this.cfB().hCm != null) {
                AlaMasterLiveRoomOpearator.this.cfB().hCm.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bDh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.ckZ();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.cfB().hBP.xs(i);
            }
        }
    };
    private CustomMessageListener hpc = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.ckS();
        }
    };
    private CustomMessageListener hfH = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.ap.c)) {
                if (AlaMasterLiveRoomOpearator.this.hfG == null) {
                    AlaMasterLiveRoomOpearator.this.hfG = new com.baidu.live.ap.a(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.hfG.a((com.baidu.live.ap.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hIH = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.QP()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hHU != null) {
                            AlaMasterLiveRoomOpearator.this.hHU.oz(!alaSetPrivateResponseMessage.isSwitchOpen());
                            AlaMasterLiveRoomOpearator.this.hHU.clA();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.cfB().hCg.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hIq != null) {
                        AlaMasterLiveRoomOpearator.this.hIq.setMute(AlaMasterLiveRoomOpearator.this.cfB().hCg.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHv != null) {
                        AlaMasterLiveRoomOpearator.this.hHv.setMute(AlaMasterLiveRoomOpearator.this.cfB().hCg.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHp != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hHp.a(AlaMasterLiveRoomOpearator.this.cfB().hCj, AlaMasterLiveRoomOpearator.this.cfB().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.cfB().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hHp.xB(2);
                        AlaMasterLiveRoomOpearator.this.hHp.c(AlaMasterLiveRoomOpearator.this.cfB().hCj, string, 3);
                    }
                }
            }
        }
    };
    private e.a hII = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void clg() {
            AlaMasterLiveRoomOpearator.this.xk(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void clh() {
            AlaMasterLiveRoomOpearator.this.xk(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hIJ = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.liveroom.a.a
        public boolean ff(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void fg(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.cfB().bUm() == 1) {
                AlaMasterLiveRoomOpearator.this.cfB().hCg.stopRecord();
            }
        }
    };
    private IShareCallback hIK = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hIa && AlaMasterLiveRoomOpearator.this.hHZ != null) {
                AlaMasterLiveRoomOpearator.this.hIa = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hHZ);
            }
        }
    };
    private View.OnTouchListener hIL = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.cfB().hCm.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.cfB().hBQ);
            AlaMasterLiveRoomOpearator.this.xl(0);
            if (AlaMasterLiveRoomOpearator.this.hrL != null) {
                AlaMasterLiveRoomOpearator.this.hrL.MA().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.hrL.MB().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hIM = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cli() {
            AlaMasterLiveRoomOpearator.this.cke();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void clj() {
            AlaMasterLiveRoomOpearator.this.hGQ = AlaMasterLiveRoomOpearator.this.hHj.chp();
            AlaMasterLiveRoomOpearator.this.cfB().hCm.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.cfB().hCm.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.cfB().hCm.sampleMemAndCPU();
            d dVar = new d();
            dVar.hCa = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.cfB().bUm();
            dVar.title = AlaMasterLiveRoomOpearator.this.hHj.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hCb = AlaMasterLiveRoomOpearator.this.hHj.chq();
            dVar.hCe = AlaMasterLiveRoomOpearator.this.hGQ;
            dVar.hCd = AlaMasterLiveRoomOpearator.this.hHj.chn();
            dVar.hCc = AlaMasterLiveRoomOpearator.this.hHj.chs();
            dVar.hCf = AlaMasterLiveRoomOpearator.this.hHj.cho();
            if (dVar.hCf) {
                if (AlaMasterLiveRoomOpearator.this.hHj.cht()) {
                    AlaMasterLiveRoomOpearator.this.hIa = true;
                    AlaMasterLiveRoomOpearator.this.hHZ = dVar;
                    AlaMasterLiveRoomOpearator.this.hHj.chu();
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
            AlaMasterLiveRoomOpearator.this.cfB().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.cfB().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void clk() {
            AlaMasterLiveRoomOpearator.this.hIu = true;
            AlaMasterLiveRoomOpearator.this.ot(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean cll() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void clm() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener bnt = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.cdq();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hIN = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void PA() {
            if (AlaMasterLiveRoomOpearator.this.hHn != null) {
                AlaMasterLiveRoomOpearator.this.hHn.oM(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cD(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hHV != null) {
                        AlaMasterLiveRoomOpearator.this.hHV.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hHV != null) {
                    AlaMasterLiveRoomOpearator.this.hHV.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hHn != null) {
                    AlaMasterLiveRoomOpearator.this.hHn.oM(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.hrZ != null) {
                    AlaMasterLiveRoomOpearator.this.hrZ.bC(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hIO = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void cls() {
            if (AlaMasterLiveRoomOpearator.this.hHH != null && AlaMasterLiveRoomOpearator.this.cfB().hCj.indexOfChild(AlaMasterLiveRoomOpearator.this.hHH) >= 0) {
                AlaMasterLiveRoomOpearator.this.cfB().hCj.removeView(AlaMasterLiveRoomOpearator.this.hHH);
                AlaMasterLiveRoomOpearator.this.hHH.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hHH = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hrl = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            x HR;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.ckY();
            } else if (i == 14 && (HR = AlaMasterLiveRoomOpearator.this.cfB().hBP.HR()) != null && HR.aKu != null && HR.mLiveInfo != null && HR.aKQ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), HR.aKu.userName, Long.toString(HR.aKu.userId), Long.toString(HR.aKu.charmCount), String.valueOf(HR.mLiveInfo.group_id), String.valueOf(HR.mLiveInfo.live_id), true, String.valueOf(HR.aKu.userId), Long.toString(HR.aKQ.userId), HR.aKQ.userName, HR.aKQ.portrait, AlaMasterLiveRoomOpearator.this.hqC.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(HR.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.hqC.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hIP = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private g hIQ = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
    };
    private Runnable hIR = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        @Override // java.lang.Runnable
        public void run() {
            AlaMasterLiveRoomOpearator.this.clf();
        }
    };
    private HttpMessageListener gZs = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == AlaMasterLiveRoomOpearator.this.gQC && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bkF != null) {
                AlaMasterLiveRoomOpearator.this.bkF = guardClubInfoHttpResponseMessage.bkF;
            }
        }
    };
    HttpMessageListener gZK = new HttpMessageListener(1021231) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021231) {
                if (!(httpResponsedMessage instanceof GuardClubInfoRenameResponseMessage) || httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = "修改真爱团名称失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString, 0);
                    return;
                }
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bkF;
                if (aVar == null || AlaMasterLiveRoomOpearator.this.bkF == null || AlaMasterLiveRoomOpearator.this.bkF.id != aVar.id) {
                    String errorString2 = httpResponsedMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString2)) {
                        errorString2 = "修改真爱团名称失败";
                    }
                    BdUtilHelper.getCustomToast().showToast(errorString2, 0);
                    return;
                }
                BdUtilHelper.getCustomToast().showToast("修改成功", 0);
            }
        }
    };
    private ViewTreeObserver.OnGlobalLayoutListener globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.68
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity());
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                Window window = AlaMasterLiveRoomOpearator.this.hau.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.x = 0;
                attributes.y = 50;
                window.setAttributes(attributes);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = false;
                Window window2 = AlaMasterLiveRoomOpearator.this.hau.getWindow();
                WindowManager.LayoutParams attributes2 = window2.getAttributes();
                attributes2.gravity = 17;
                attributes2.x = 0;
                attributes2.y = 0;
                window2.setAttributes(attributes2);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.aAQ);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hHg = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    private void Iy(String str) {
        if (!TextUtils.isEmpty(str) && this.hHS != null) {
            View Nv = this.hHS.Nv();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            Nv.setLayoutParams(layoutParams);
            if (cfB().hBQ.indexOfChild(Nv) >= 0) {
                cfB().hBQ.removeView(Nv);
            }
            cfB().hBQ.addView(Nv);
            this.hHS.hS(str);
            Nv.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(x xVar) {
        if (xVar != null && xVar.mLiveInfo != null && com.baidu.live.af.a.SE().bwi != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(cfB().pageContext.getPageActivity(), String.valueOf(xVar.mLiveInfo.live_id), String.valueOf(xVar.mLiveInfo.user_id), com.baidu.live.af.a.SE().bwi.aPa, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void If(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cfB().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(cfB().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.af.a.SE().bwi.aOv;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? cfB().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : cfB().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(cfB().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdq() {
        int i = cfB().hBP.HR().aKu.isUegBlock;
        int i2 = cfB().hBP.HR().aKu.isBlock;
        String str = cfB().hBP.HR().aKu.userName;
        if (i > 0 || i2 > 0) {
            this.brO = true;
            this.hrL.a(true, i, i2, str);
            return;
        }
        this.brO = false;
        this.hrL.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.huX.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqL == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqM);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.huX.pageContext.getPageActivity());
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
            bdAlertDialog.create(this.huX.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ckc() {
        if (this.hIq != null && this.hIq.XJ()) {
            BdUtilHelper.showToast(this.huX.pageContext.getPageActivity(), this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hHv != null && this.hHv.Tx()) {
            BdUtilHelper.showToast(this.huX.pageContext.getPageActivity(), this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckd() {
        if (this.hrL != null) {
            this.hrL.MB().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hIp != null) {
            this.hIp.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cke() {
        if (cfB() != null && cfB().hBP != null) {
            cfB().hBP.cmg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bWA() != null && aVar.bWB() != null) {
            cfB().hBP.eA(aVar.bWA().getId(), aVar.bWB().getId());
        }
    }

    public void b(short s) {
        if (this.hIo != null) {
            this.hIo.b(s);
        }
    }

    /* loaded from: classes11.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.hIc = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hIc = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hId == 0) {
                    AlaMasterLiveRoomOpearator.this.hId = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hIe == 0) {
                    AlaMasterLiveRoomOpearator.this.hIe = intent.getIntExtra(MapBundleKey.MapObjKey.OBJ_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.hIf = intent.getIntExtra(MapBundleKey.MapObjKey.OBJ_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        if (cfB() != null && cfB().hCk != null) {
            cfB().hCk.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.huX = eVar;
        this.hoR = str;
    }

    protected com.baidu.tieba.ala.liveroom.data.e cfB() {
        return this.huX;
    }

    public int a(f fVar) {
        this.hvf = fVar;
        this.hIb = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hIb, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hHp == null) {
            this.hHp = new com.baidu.tieba.ala.liveroom.tippop.a(this.huX.pageContext, null);
        }
        registerListener();
        this.hpW = new com.baidu.live.j.a();
        ckz();
        ckf();
        ckh();
        Long[] lArr = new Long[1];
        this.hIg = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hIh = lArr[0] != null ? lArr[0].longValue() : 0L;
        cfB().hBQ.setOnTouchListener(this.hIL);
        this.hHh = SharedPrefHelper.getInstance().getBoolean(hHg, false);
        this.hHw = new AlaLiveCountDownView(cfB().pageContext.getPageActivity());
        this.hHw.setCount(3);
        this.hHw.setTextColor(cfB().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hHw.setTextSize(cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hHw.setTypeface(Typeface.DEFAULT_BOLD);
        this.hHw.setIncludeFontPadding(false);
        this.hHw.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void cln() {
                if (AlaMasterLiveRoomOpearator.this.cfB().hBQ != null) {
                    AlaMasterLiveRoomOpearator.this.cfB().hBQ.removeView(AlaMasterLiveRoomOpearator.this.hHw);
                }
            }
        });
        return 1;
    }

    private void ckf() {
        CustomResponsedMessage runTask;
        if (this.hHu == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.n.a.class, cfB().pageContext)) != null && runTask.getData() != null) {
            this.hHu = (com.baidu.live.n.a) runTask.getData();
            this.hHu.c(cfB().pageContext);
        }
    }

    private void ckg() {
        CustomResponsedMessage runTask;
        if (ckn() && this.hHv == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.ao.b.class, cfB().pageContext)) != null && runTask.getData() != null) {
            this.hHv = (com.baidu.live.ao.b) runTask.getData();
            if (cfB() != null && cfB().hBP != null && cfB().hBP.HR() != null) {
                this.hHv.setLiveShowData(cfB().hBP.HR());
            }
            if (cfB() != null && cfB().hCg != null) {
                this.hHv.H(cfB().hCg);
                this.hHv.setMute(cfB().hCg.isMute());
            }
            if (this.hHv != null && this.hHE != null) {
                this.hHv.a(new com.baidu.live.ao.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                    @Override // com.baidu.live.ao.a
                    public boolean Tz() {
                        if ((AlaMasterLiveRoomOpearator.this.hsh != null) && AlaMasterLiveRoomOpearator.this.hsh.DB()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.hsh != null) & AlaMasterLiveRoomOpearator.this.hsh.RB()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hIp == null || !AlaMasterLiveRoomOpearator.this.hIp.cfD()) {
                            if (AlaMasterLiveRoomOpearator.this.hIp == null || !AlaMasterLiveRoomOpearator.this.hIp.cfE()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hHv.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hHE.setVisibility(0);
                    this.hHE.addView(enterView);
                }
            }
            if (this.hHv != null) {
                this.hHv.Y(cfB().hCh);
            }
            if (this.hHv != null && cfB().hCi != null) {
                this.hHv.a(cfB().hCi);
            }
        }
    }

    private void ckh() {
        View rootLayout;
        if (this.hHu != null && this.hHD != null && (rootLayout = this.hHu.cw(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hHD.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cki() {
        if (this.hHU == null) {
            this.hHU = new com.baidu.tieba.ala.liveroom.master.panel.b(cfB().pageContext.getPageActivity(), cfB().bUm() == 2);
            this.hHU.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ov(boolean z) {
                    AlaMasterLiveRoomOpearator.this.cfB().hCg.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ow(boolean z) {
                    AlaMasterLiveRoomOpearator.this.cfB().hCg.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ox(boolean z) {
                    AlaMasterLiveRoomOpearator.this.cfB().hCg.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.ckX();
                    if (AlaMasterLiveRoomOpearator.this.hHp != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hHp.c(AlaMasterLiveRoomOpearator.this.cfB().hCj, AlaMasterLiveRoomOpearator.this.cfB().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hHp.c(AlaMasterLiveRoomOpearator.this.cfB().hCj, AlaMasterLiveRoomOpearator.this.cfB().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oy(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void clo() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.cfB().hBP != null && AlaMasterLiveRoomOpearator.this.cfB().hBP.HR() != null && AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hHU != null) {
                        AlaMasterLiveRoomOpearator.this.hHU.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void clp() {
                    if (AlaMasterLiveRoomOpearator.this.hHU != null) {
                        AlaMasterLiveRoomOpearator.this.hHU.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void clq() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.cfB() != null && AlaMasterLiveRoomOpearator.this.cfB().hBP != null && AlaMasterLiveRoomOpearator.this.cfB().hBP.HR() != null && AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaMasterLiveRoomOpearator.this.cfB().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hHU != null) {
                            AlaMasterLiveRoomOpearator.this.hHU.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void clr() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.cfB() == null || AlaMasterLiveRoomOpearator.this.cfB().hBP == null || AlaMasterLiveRoomOpearator.this.cfB().hBP.HR() == null || AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.cfB() != null && AlaMasterLiveRoomOpearator.this.cfB().hBP != null && AlaMasterLiveRoomOpearator.this.cfB().hBP.HR() != null && AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hHU != null) {
                                        AlaMasterLiveRoomOpearator.this.hHU.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.huX.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hHU != null) {
                        AlaMasterLiveRoomOpearator.this.hHU.dismiss();
                    }
                }
            });
        }
        ckj();
    }

    private void ckj() {
        if (this.hHU != null) {
            boolean isBackCamera = cfB().hCg.isBackCamera();
            this.hHU.setIsBackCamera(cfB().hCg.isBackCamera());
            this.hHU.S(cfB().hCg.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = cfB().hCg.isPushMirror();
            if (this.hIl) {
                isPushMirror = ckW() || isPushMirror;
                this.hIl = false;
            }
            this.hHU.T(isPushMirror, isBackCamera ? false : true);
            this.hHU.oz(cfB().hCg.isMute());
            this.hHU.clA();
        }
    }

    public void ckk() {
        if (this.hvf != null) {
            if (this.hvf.hCp == null || this.hvf.hCp.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hHF == null) {
                        this.hHF = this.huX.hCo.Pa();
                        this.huX.hCj.addView(this.hHF, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hHj == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (cfB().hBP != null && cfB().hBP.HR() != null && cfB().hBP.HR().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", cfB().hBP.HR().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", cfB().hBP.HR().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hHj = new com.baidu.tieba.ala.liveroom.h.d(cfB().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    cfB().hCm.prepareTime = System.currentTimeMillis();
                    cfB().hCj.addView(this.hHj.getView(), layoutParams);
                    this.hHj.a(this.hIK);
                }
                this.hHj.ob(this.hCd);
                this.hHj.a(this.hIM);
                this.hHj.a(this.hII);
                this.hHj.a(cfB().hCg, cfB().bUm());
                this.hHj.a(this.hHu);
                return;
            }
            this.hGQ = this.hvf.hCp.mLiveInfo.screen_direction == 2;
            if (this.hvf.hCp.mLiveInfo.isAudioOnPrivate == 1) {
                cfB().hCg.setMute(true);
                if (this.hIq != null) {
                    this.hIq.setMute(cfB().hCg.isMute());
                }
                if (this.hHv != null) {
                    this.hHv.setMute(cfB().hCg.isMute());
                }
                if (this.hHp == null) {
                    this.hHp = new com.baidu.tieba.ala.liveroom.tippop.a(this.huX.pageContext, null);
                }
                if (!this.hHp.xA(2)) {
                    this.hHp.a(cfB().hCj, cfB().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                }
            }
            d dVar = new d();
            dVar.hCa = true;
            dVar.forumId = String.valueOf(this.hvf.hCp.mLiveInfo.forum_id);
            dVar.forumName = this.hvf.hCp.mLiveInfo.forum_name;
            dVar.liveType = this.hvf.hCp.mLiveInfo.live_type;
            dVar.title = this.hvf.hCp.mLiveInfo.getLiveTitle();
            dVar.clarity = this.hvf.hCp.mLiveInfo.clarity;
            dVar.gameId = this.hvf.hCp.mLiveInfo.game_id;
            dVar.gameName = this.hvf.hCp.mLiveInfo.game_label;
            dVar.hCe = this.hvf.hCp.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void ckl() {
        if (this.hIo != null) {
            this.hIo.a(cfB().hCg.getVideoConfig(), false);
        }
        if (this.hHj != null) {
            this.hHj.oa(true);
        }
        if (cfB().hCg.hasBeauty() >= 0) {
            cfB().hCg.setBeauty(com.baidu.live.d.Ba().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            cfB().hCo.E(this.huX.hCg);
        } else if (this.hHj != null) {
            this.hHj.oa(true);
        }
        cky();
    }

    public void d(d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hHF != null && this.hHF.getParent() != null) {
                ((ViewGroup) this.hHF.getParent()).removeView(this.hHF);
                this.hHF = null;
            }
            cfB().hBQ.setVisibility(0);
            this.huX.hCo.a(cfB().hBQ);
        } else {
            ckG();
            ckV();
            if (this.hIy != null) {
                this.hIy.setVisibility(0);
            }
            this.hHn = new com.baidu.tieba.ala.liveroom.w.a(cfB().pageContext, this.hIJ);
            this.hHn.c(cfB().hBQ, true);
            this.hHn.oM(true);
            if (this.hrL != null && this.hrL.MA() != null) {
                this.hrL.MA().setNeedTopAlphaShade(true);
            }
        }
        cfB().hCg.setPushMirror(ckW());
    }

    public void b(as asVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huX.hCo.l(cfB().hBP.HR());
        }
        if (!cfB().hCg.isBackground() && cfB().hBP.HR() != null && cfB().hBP.HR().mLiveInfo != null) {
            int startPush = cfB().hCg.startPush(cfB().hBP.HR().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.huX.hCo.Pb();
            }
            if (startPush != 0 && cfB().hCm != null) {
                cfB().hCm.errCode = 4;
                cfB().hCm.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (asVar != null && !asVar.Fc() && !ckT()) {
                ou(true);
                ckU();
            }
            if (this.hqz != null) {
                this.hqz.M(cfB().hBP.HR());
            }
            if (this.hrw != null) {
                this.hrw.a(cfB().hBP.HR());
            }
            if (this.hHu != null) {
                this.hHu.f(cfB().hBP.HR());
                this.hHu.hV(this.otherParams);
            }
            if (this.hqz != null) {
                this.hqz.oo(true);
            }
            if (this.hHk != null) {
                this.hHk.M(cfB().hBP.HR());
            }
            if (asVar == null || asVar.aKu == null) {
                z = com.baidu.live.d.Ba().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = asVar.aKu.canUseChallenge;
                com.baidu.live.d.Ba().putBoolean("ala_master_can_use_challenge", z);
            }
            cep();
            ckH();
            ckr();
            os(z);
            cda();
            ckI();
            ckO();
            N(cfB().hBP.HR());
            g(cfB().hBP.HR());
            ckP();
            ckQ();
            ckm();
            ckL();
            cek();
            ccZ();
            cem();
            ccY();
            ckM();
            cdV();
            cef();
            ceg();
            ckE();
            ckF();
            O(cfB().hBP.HR());
            ckN();
            cej();
            cdW();
            MessageManager.getInstance().registerListener(this.gZs);
            MessageManager.getInstance().registerListener(this.gZK);
            as cmn = cfB().hBP.cmn();
            if (cmn != null && cmn.aQb == 1) {
                bYG();
                this.hIv.postDelayed(this.hIR, IMConnection.RETRY_DELAY_TIMES);
            }
            if (this.hrK != null) {
                this.hrK.h(cfB().hBP.HR());
            }
            if (this.hrL != null) {
                if (cfB().hBP.HR() != null && cfB().hBP.HR().aLi != null && cfB().hBP.HR().aLi.Eq()) {
                    z2 = true;
                }
                this.hrL.a(String.valueOf(cfB().hBP.HR().mLiveInfo.group_id), String.valueOf(cfB().hBP.HR().mLiveInfo.last_msg_id), String.valueOf(cfB().hBP.HR().aKu.userId), String.valueOf(cfB().hBP.HR().mLiveInfo.live_id), cfB().hBP.HR().aKu.appId, z2, cfB().hBP.HR().getGuardName());
            }
            if (this.hrM != null) {
                this.hrM.a(cfB().hBP.HR(), true);
            }
            cko();
            ckg();
            cet();
            this.mHandler.post(this.hIA);
        }
    }

    protected void cet() {
        if (this.hst == null && cfB() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.t.a.class, cfB().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.hst = (com.baidu.live.t.a) runTask.getData();
                this.hst.p(cfB().hBQ);
            }
        }
    }

    private void ckm() {
        if (this.hHl != null && cfB() != null && cfB().hBP != null) {
            if (this.hHl.aG(this.hHA)) {
                this.hHl.C(cfB().hBP.HR());
            } else {
                this.hHl.d(this.hHA, cfB().hBP.HR());
            }
        }
    }

    private void cda() {
        if (this.bzK == null) {
            this.bzK = new PendantParentView(cfB().pageContext.getPageActivity(), ceY());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            cfB().hBQ.addView(this.bzK, layoutParams);
            this.bzK.setDefaultItemMargin(cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.bzK.setPadding(cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ceX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceX() {
        if (this.bzK != null) {
            int dimensionPixelSize = cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bzK.getLayoutParams();
            if (this.gSr) {
                this.bzK.setPosition(0, 0, this.hIp.cfi(), dimensionPixelSize2);
            } else {
                this.bzK.setPosition(dimensionPixelSize, 0, cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds380), dimensionPixelSize2);
            }
            this.bzK.setLayoutParams(layoutParams);
            this.bzK.setModel(ceY());
        }
    }

    private PendantParentView.Model ceY() {
        if (this.gSr) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.hIw) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void ceZ() {
        if (this.hrL != null && this.hrL.MA() != null && this.hrL.MA().getView() != null) {
            if (this.gSr && !this.hHi && cfB().hBQ != null && cfB().hBQ.getHeight() > 0) {
                int br = this.hIp != null ? this.hIp.br(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.hrL.MA().getView().getLayoutParams();
                int height = cfB().hBQ.getHeight() - br;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.hrL.MA().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int i2 = com.baidu.live.al.c.i(false, this.hHi);
            if (cfB().hBQ.indexOfChild(this.hrL.MA().getView()) != -1 && this.hrL.MA().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrL.MA().getView().getLayoutParams();
                layoutParams2.height = i2;
                this.hrL.MA().getView().setLayoutParams(layoutParams2);
            }
            this.hrL.MA().Mz();
        }
    }

    private void cfa() {
        if (this.hrN != null) {
            if (this.gSr && !this.hHi && cfB().hBQ != null && cfB().hBQ.getHeight() > 0) {
                this.hrN.ei((cfB().hBQ.getHeight() - (this.hIp != null ? h.o(cfB().pageContext.getPageActivity(), true) : 0)) + cfB().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.hrN.ei(com.baidu.live.al.a.b(cfB().pageContext.getPageActivity(), true, false, this.hHi));
            }
        }
    }

    private void cfb() {
        int i;
        if (this.hrN != null) {
            int h = com.baidu.live.al.a.h(true, false);
            if (!this.gSr || cfB().hBQ == null || cfB().hBQ.getHeight() <= 0) {
                i = h;
            } else {
                i = (cfB().hBQ.getHeight() - (this.hIp != null ? this.hIp.br(false) : 0)) + cfB().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.hrN.ej(i);
        }
    }

    private void cfc() {
        if (this.hrM != null && this.hrM.Da() != null) {
            ViewGroup.LayoutParams layoutParams = this.hrM.Da().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = cfB().pageContext.getResources().getDimensionPixelOffset(this.gSr ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.hrM.Da().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean ckn() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = cfB().hBP.HR().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void cko() {
        if (this.hHv == null && !ckn()) {
            boolean z = (cfB().hBP == null || cfB().hBP.cmn() == null || cfB().hBP.cmn().mLiveInfo.videoBBChatData == null || !cfB().hBP.cmn().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && cfB().hBP != null && cfB().hBP.HR() != null && cfB().hBP.HR().mLiveInfo != null && cfB().hBP.HR().mLiveInfo.videoBBChatData != null && cfB().hBP.HR().aLe) {
                z = cfB().hBP.HR().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hHO != null) {
                this.hHO.setVisibility(z ? 0 : 8);
            }
            ckp();
        }
    }

    private void ckp() {
        CustomResponsedMessage runTask;
        if (this.hIq == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.an.a.class, cfB().pageContext)) != null && runTask.getData() != null) {
            this.hIq = (com.baidu.live.an.a) runTask.getData();
        }
        if (this.hIq != null) {
            this.hIq.y((ViewGroup) cfB().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hIq.x(cfB().hCj);
            this.hIq.t(cfB().hBP.HR());
            this.hIq.H(cfB().hCg);
            this.hIq.a(cfB().hCi);
            this.hIq.a(this.bPf);
            if (cfB().hCg != null) {
                this.hIq.setMute(cfB().hCg.isMute());
            }
        }
    }

    private void os(boolean z) {
        if (this.hIp == null) {
            this.hIp = new com.baidu.tieba.ala.liveroom.challenge.e(cfB());
        }
        this.hIp.a(this.hve, this.hvf, z);
        this.hIp.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(bc bcVar, bg bgVar, bg bgVar2) {
                AlaMasterLiveRoomOpearator.this.gSr = true;
                AlaMasterLiveRoomOpearator.this.cfB().hBQ.hRu = false;
                if (AlaMasterLiveRoomOpearator.this.hHV != null) {
                    AlaMasterLiveRoomOpearator.this.hHV.fA(4);
                    AlaMasterLiveRoomOpearator.this.hHV.cQ(true);
                }
                AlaMasterLiveRoomOpearator.this.Zo();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void DH() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hIA);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void cfz() {
                AlaMasterLiveRoomOpearator.this.gSr = false;
                AlaMasterLiveRoomOpearator.this.cfB().hBQ.hRu = false;
                if (AlaMasterLiveRoomOpearator.this.hHV != null) {
                    AlaMasterLiveRoomOpearator.this.hHV.fA(0);
                    AlaMasterLiveRoomOpearator.this.hHV.cQ(false);
                }
                AlaMasterLiveRoomOpearator.this.cfh();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void cfA() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hIA);
            }
        });
        this.hIp.P(this.hGQ, z);
        this.hIp.k(this.hGQ, z, (this.hvf == null || this.hvf.hCp == null || this.hvf.hCp.mChallengeData == null) ? false : true);
    }

    public boolean ckq() {
        return this.hIp != null && this.hIp.cfI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zo() {
        if (this.hHo != null) {
            this.hHo.setVisible(8);
            this.hHo.setCanVisible(false);
        }
        if (this.hqE != null) {
            this.hqE.ba(true);
        }
        if (this.hHx != null) {
            this.hHx.setCanVisible(false);
            this.hHx.setVisibility(4);
        }
        if (this.hHn != null) {
            this.hHG = this.hHn.coF();
            this.hHn.oL(false);
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(false);
        }
        if (this.hqL != null) {
            this.hqL.setCanVisible(false);
        }
        if (this.hsi != null) {
            this.hsi.ba(true);
            this.hsi.bb(true);
        }
        ceX();
        ceZ();
        cfa();
        cfb();
        cfc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfh() {
        if (this.hHo != null) {
            this.hHo.setCanVisible(true);
        }
        if (this.hqE != null) {
            this.hqE.ba(false);
        }
        if (this.hHx != null) {
            this.hHx.setCanVisible(true);
            if (this.hHx.coc()) {
                this.hHx.setVisibility(0);
            }
        }
        if (this.hHn != null) {
            this.hHn.oL(this.hHG);
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(true);
        }
        if (this.hqL != null) {
            this.hqL.cO(true);
        }
        if (this.hsi != null) {
            this.hsi.ba(false);
            this.hsi.bb(false);
        }
        ceX();
        ceZ();
        cfa();
        cfb();
        cfc();
    }

    private void ckr() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hHx == null) {
            this.hHx = new AlaLiveStreamStatusView(cfB().pageContext.getPageActivity());
            this.hHx.setVisibility(4);
        }
        this.hHx.setId(a.f.ala_live_room_stream_view);
        this.hHx.setLayoutParams(layoutParams);
        if (this.hHx.getParent() == null && this.hHA != null) {
            this.hHA.addView(this.hHx, layoutParams);
        }
    }

    public void cks() {
        if (this.hHj != null && this.hHj.getVisibility() != 8 && cfB().hCg.getPreview() != null) {
            cfB().hCg.stopRecord();
        }
    }

    public void ckt() {
        if (cfB().hCg.getPreview() != null) {
            cfB().hCg.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hIo != null) {
                this.hIo.nZ(false);
            }
            this.hIo = new com.baidu.tieba.ala.liveroom.h.b(cfB().hCj, cfB(), cfB().hCg);
            this.hIo.a(cfB().hCg.getVideoConfig(), false);
        }
        if (this.hHp != null) {
            this.hHp.cny();
        }
        this.mHandler.post(this.hIA);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hHi = z;
        if (z) {
            if (this.hIn) {
                this.hIn = false;
                if (this.hrL != null && this.hrL.MA() != null) {
                    this.hrL.MA().getView().setBottom(0);
                }
                if (this.hrL != null && this.hrL.MB() != null) {
                    this.hrL.MB().getView().setBottom(0);
                }
            }
            if (this.hrN != null && this.hrN.Ho() != null) {
                this.hrN.Ho().setVisibility(8);
            }
            if (this.hrL != null && this.hrL.MA() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrL.MA().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.hrL.MA().getView().setLayoutParams(layoutParams);
            }
            if (this.hrL != null && this.hrL.MB() != null && this.hrL.MB().getView() != null && this.hrL.MB().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hrL.MB().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.hrL.MB().getView().setLayoutParams(layoutParams2);
                this.hrL.MB().getView().setVisibility(0);
                this.hrL.MB().OD();
            }
            xl(8);
            xj(8);
            if (this.hrO != null && this.hrO.HQ() != null) {
                this.hrO.HQ().setVisibility(8);
            }
            if (this.hsi != null) {
                this.hsi.setCanVisible(false);
            }
        } else {
            if (this.hrN != null && this.hrN.Ho() != null) {
                this.hrN.Ho().setVisibility(0);
            }
            if (this.hrL != null && this.hrL.MA() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hrL.MA().getView().getLayoutParams();
                layoutParams3.bottomMargin = cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hrL.MA().getView().setLayoutParams(layoutParams3);
            }
            if (this.hrL != null && this.hrL.MB() != null) {
                this.hrL.MB().hide();
            }
            xl(0);
            xj(0);
            if (this.hrO != null && this.hrO.HQ() != null) {
                this.hrO.HQ().setVisibility(0);
            }
            if (this.hHS != null && this.hHS.Nv() != null) {
                this.hHS.Nv().setVisibility(0);
            }
            if (this.hsi != null) {
                this.hsi.setCanVisible(true);
            }
        }
        if (this.hHj != null) {
            this.hHj.R(false, z);
        }
        if (this.hrM != null) {
            this.hrM.Db();
        }
        if (this.hHV != null) {
            this.hHV.onKeyboardVisibilityChanged(z);
        }
        if (this.hst != null) {
            this.hst.onKeyboardVisibilityChanged(z);
        }
        if (this.hIq != null) {
            this.hIq.onKeyboardVisibilityChanged(z);
        }
        ceZ();
        this.mHandler.post(this.hIA);
    }

    private void xj(int i) {
        if (this.hqz != null) {
            this.hqz.wX(i);
        }
        if (this.hHz != null) {
            this.hHz.setVisibility(i);
        }
        if (this.hrw != null) {
            this.hrw.getView().setVisibility(i);
        }
        if (this.hHm != null) {
            this.hHm.setVisible(i);
        }
        if (this.hHl != null) {
            this.hHl.setVisibility(i);
        }
        if (this.hqE != null) {
            this.hqE.setVisible(i);
        }
        if (this.hsp != null) {
            this.hsp.setCanVisible(i == 0);
        }
        if (this.hsk != null) {
            this.hsk.setVisible(i);
        }
        if (this.hsf != null) {
            this.hsf.setCanVisible(i == 0);
        }
        if (this.hsh != null) {
            this.hsh.setCanVisible(i == 0 && !this.gSr);
        }
        if (this.hqL != null) {
            this.hqL.cO(i == 0);
        }
        if (this.hIr != null) {
            this.hIr.setCanVisible(i == 0);
            this.hIr.refreshUI();
        }
        if (this.hHA != null) {
            this.hHA.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            cfB().hCm.errCode = 1;
            xk(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            xk(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            xk(a.h.stream_upload_exception);
        } else if (i == -2) {
            Iz(cfB().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            cfB().hCg.stopRecord();
        } else if (i == -3 && this.hHj != null) {
            this.hHj.oa(false);
        }
        if (i == -4) {
            if (this.hHj == null || this.hHj.getView().getParent() == null) {
                cfB().g((short) 1);
                return;
            }
            this.hHj.chr();
            this.hHL.setVisibility(0);
            if (this.hHn != null) {
                this.hHn.oM(true);
            }
            cfB().hBQ.setBackgroundColor(cfB().pageContext.getResources().getColor(17170445));
            clc();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        azK();
        if (i == 12001) {
            if (i2 == -1) {
                IA(P(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            byf();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hHj == null || this.hHj.getView().getParent() == null || this.hHj.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hHj != null) {
            this.hHj.onResume();
        }
        if (this.hIa && this.hHZ != null) {
            this.hIa = false;
            c(this.hHZ);
        }
        if (this.hrZ != null) {
            this.hrZ.onResume();
        }
    }

    public void h(short s) {
        if (this.hrK != null) {
            this.hrK.Id();
        }
        if (this.hrL != null) {
            this.hrL.a(null);
            this.hrL.Dc();
        }
        if (this.hrM != null) {
            this.hrM.Dc();
        }
        if (this.hIp != null) {
            this.hIp.cfH();
        }
    }

    public boolean cku() {
        x HR = cfB().hBP.HR();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huX.hCo.k(HR);
            if (HR != null && HR.mLiveInfo.live_status != 1) {
                cla();
                cfB().pageContext.getPageActivity().finish();
                if (cfB().hBP == null || cfB().hBP.HR() == null) {
                    return true;
                }
                a(HR, 1, cfB().hBP.cmw() != 1 ? cfB().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                return true;
            }
        } else {
            if (this.hrL != null) {
                this.hrL.MA().a(String.valueOf(HR.mLiveInfo.group_id), String.valueOf(HR.mLiveInfo.live_id), true, String.valueOf(HR.aKu.userId), HR.getGuardName());
            }
            if (this.hrM != null) {
                this.hrM.a(HR);
            }
            if (this.hrw != null) {
                this.hrw.a(cfB().hBP.HR());
            }
            if (this.hqz != null) {
                this.hqz.M(HR);
            }
            if (HR != null) {
                if (this.hIp != null) {
                    this.hIp.a(HR);
                }
                if (this.hrO != null && HR.mLiveInfo != null) {
                    this.hrO.a(HR.mLiveInfo, HR.aKu);
                }
                if (this.hsp != null) {
                    this.hsG = this.hsp.p(HR);
                }
                if (this.hqE != null) {
                    this.hqE.nB(this.hsG);
                    this.hqE.j(HR);
                    this.hqE.updateView();
                }
                if (this.hsf != null) {
                    this.hsf.a(HR);
                }
                if (this.hsh != null) {
                    this.hsh.a(HR);
                }
                if (this.hsg != null) {
                    this.hsg.a(HR);
                }
                if (this.hHt != null) {
                    this.hHt.a(HR);
                }
                if (this.hsi != null) {
                    this.hsi.a(HR);
                }
                if (this.hsj != null) {
                    this.hsj.a(HR);
                }
                if (this.hsk != null) {
                    this.hsk.a(HR);
                }
                if (HR.mLiveInfo.live_status != 1) {
                    cla();
                    cfB().pageContext.getPageActivity().finish();
                    if (cfB().hBP == null || cfB().hBP.HR() == null) {
                        return true;
                    }
                    a(HR, 1, cfB().hBP.cmw() != 1 ? cfB().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    return true;
                } else if (this.hHu != null) {
                    this.hHu.i(HR);
                }
            }
        }
        return false;
    }

    public void ckv() {
        ckj();
    }

    public void ckw() {
        if (this.hIo != null) {
            this.hIo.chl();
        }
        if (this.hIq != null) {
            this.hIq.XL();
        }
    }

    public void ckx() {
        if (this.hHj != null && this.hHj.getVisibility() != 8) {
            if (cfB().bUm() == 2) {
                clc();
            } else {
                clb();
            }
        }
        if (this.hHj != null && this.hHj.getVisibility() != 8) {
            if (cfB().bUm() == 1) {
                this.hHj.onResume();
            }
            this.hHj.onRefresh();
        }
        if (this.hHu != null) {
            this.hHu.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.hsB && this.hHQ != null) {
            if (this.hrL != null) {
                this.hrL.MA().getView().setVisibility(0);
            }
            if (this.hrL != null) {
                this.hrL.MB().show();
                String nameShow = this.hHQ.getNameShow();
                if (this.hHQ.extInfoJson != null) {
                    if (this.hHQ.extInfoJson.optInt("is_mysterious_man") == 1) {
                        nameShow = this.hHQ.extInfoJson.optString("mysterious_man_nickname");
                        if (TextUtils.isEmpty(nameShow)) {
                            nameShow = "神秘人";
                        }
                    }
                }
                this.hrL.MB().setEditText(" @" + nameShow + " ");
            }
            xl(8);
            this.hsB = false;
        }
        if (this.hIs != null) {
            this.hIs.resume();
        }
        if (this.hIt != null) {
            this.hIt.resume();
        }
        if (this.hfG != null) {
            this.hfG.resume();
        }
        if (this.hIq != null) {
            this.hIq.XM();
        }
    }

    public void onPause() {
        if (this.hHu != null) {
            this.hHu.onPause();
        }
        if (this.hIs != null) {
            this.hIs.pause();
        }
        if (this.hrZ != null) {
            this.hrZ.onPause();
        }
        if (this.hIt != null) {
            this.hIt.pause();
        }
        if (this.hfG != null) {
            this.hfG.pause();
        }
    }

    private void cky() {
        if (bo.c(com.baidu.live.af.a.SE().bCb)) {
            this.hHL.setVisibility(0);
            this.hHL.setAlpha(0.2f);
        } else if (cfB().hCg.hasBeauty() < 0) {
            this.hHL.setVisibility(8);
        } else {
            this.hHL.setVisibility(0);
        }
    }

    private void ckz() {
        this.hHy = (RelativeLayout) cfB().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hHB = (RelativeLayout) cfB().rootView.findViewById(a.f.under_live_view_panel);
        this.hHC = (RelativeLayout) cfB().rootView.findViewById(a.f.over_live_view_panel);
        this.hHD = (FrameLayout) cfB().rootView.findViewById(a.f.goods_parent);
        this.hHE = (FrameLayout) cfB().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.huX.hBQ.setOnLiveViewScrollListener(this.hIN);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hHB.setVisibility(8);
            this.hHC.setVisibility(8);
            cfB().hBQ.removeAllViews();
            return;
        }
        this.hHz = (RelativeLayout) cfB().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hHz.getLayoutParams();
        layoutParams.topMargin = this.huX.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hHz.setLayoutParams(layoutParams);
        this.hHA = (RelativeLayout) cfB().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.hqC == null) {
            this.hqC = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.huX.pageContext.getPageActivity(), true);
        }
        this.hqC.a(this.hrl);
        this.hqC.a(this.hHz, a.f.ala_live_room_host_header_stub, 1L);
        this.hqC.setVisible(0);
        ckA();
        this.hHL = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hHP = (TextView) cfB().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hHL.setOnClickListener(this.hIF);
        this.hHN = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hHN.setOnClickListener(this.hIF);
        if (com.baidu.live.af.a.SE().bCb != null && com.baidu.live.af.a.SE().bCb.aRz != null && com.baidu.live.af.a.SE().bCb.aRz.Fh() && bo.b(com.baidu.live.af.a.SE().bCb)) {
            this.hHN.setVisibility(0);
        } else {
            this.hHN.setVisibility(8);
        }
        cky();
        this.hHK = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hHK.setOnClickListener(this.hIF);
        this.hHI = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hHI.setOnClickListener(this.hIF);
        this.hve = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.hve.setOnClickListener(this.hIF);
        this.hHO = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hHO.setOnClickListener(this.hIF);
        this.hHJ = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hHJ.setOnClickListener(this.hIF);
        this.hHM = (ImageView) cfB().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hHM.setOnClickListener(this.hIF);
        ckD();
        if (bo.b(com.baidu.live.af.a.SE().bCb)) {
            this.hIo = new com.baidu.tieba.ala.liveroom.h.b(cfB().hCj, cfB(), cfB().hCg);
        }
        this.hrK = new m();
        ckB();
        ckC();
        if (com.baidu.live.d.Ba().getInt("beauty_new_bubble", 1) == 1) {
            this.hHP.setVisibility(0);
        }
    }

    private void ckA() {
        this.hIy = (FrameLayout) View.inflate(cfB().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hIy != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hIy.setVisibility(8);
            if (this.hIy.getParent() != null && (this.hIy.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hIy.getParent()).removeView(this.hIy);
            }
            this.hHy.addView(this.hIy, layoutParams);
            if (this.hIy != null) {
                this.hIy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.hrl.v(AlaMasterLiveRoomOpearator.this.hIy, 8);
                    }
                });
            }
        }
    }

    private void ckB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, cfB().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hrL = (k) runTask.getData();
            this.hrL.setFromMaster(true);
            this.hrL.MA().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(cfB().pageContext.getPageActivity()) * 0.75f), com.baidu.live.al.c.i(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.al.c.dn(true);
            cfB().hBQ.addView(this.hrL.MA().getView(), layoutParams);
            this.hrL.MB().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            cfB().hBQ.addView(this.hrL.MB().getView(), layoutParams2);
            this.hrL.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                @Override // com.baidu.live.im.k.a
                public boolean ME() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void MF() {
                }

                @Override // com.baidu.live.im.k.a
                public void hO(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void MG() {
                }

                @Override // com.baidu.live.im.k.a
                public void MH() {
                }

                @Override // com.baidu.live.im.k.a
                public void MI() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean MJ() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int MK() {
                    return 0;
                }

                @Override // com.baidu.live.im.k.a
                public boolean ML() {
                    return false;
                }
            });
        }
    }

    private void ckC() {
        View Da;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, cfB().pageContext);
        if (runTask != null) {
            this.hrM = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.hrM != null && (Da = this.hrM.Da()) != null && this.huX.hBQ.indexOfChild(Da) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.huX.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = cfB().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            cfB().hBQ.addView(Da, layoutParams);
        }
    }

    private void ckD() {
        CustomResponsedMessage runTask;
        if (this.hHT == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ai.a.class, cfB().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hHT = (com.baidu.live.ai.a) runTask.getData();
        }
    }

    private void ckE() {
        View Hn;
        ac.e(cfB().hBP.HR());
        ac.b(cfB().pageContext, true, false);
        ac.HY();
        if (this.hrN == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aWW = true;
            fVar.context = cfB().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrN = (ad) runTask.getData();
                if (this.hrN != null && (Hn = this.hrN.Hn()) != null && cfB().hBQ.indexOfChild(Hn) < 0) {
                    if (Hn.getParent() instanceof ViewGroup) {
                        ((ViewGroup) Hn.getParent()).removeView(Hn);
                    }
                    cfB().hBQ.addView(Hn, cfB().hBQ.getLayoutParams());
                }
            }
        }
    }

    private void ckF() {
        if (!this.hIz) {
            this.hIz = true;
            com.baidu.live.entereffect.a.FB().bx(true);
        }
    }

    protected void ceg() {
        View HQ;
        if (this.hrO == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aWW = true;
            aVar.context = cfB().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrO = (ab) runTask.getData();
            }
        }
        if (this.hrO != null && (HQ = this.hrO.HQ()) != null && this.hHA != null) {
            if (this.hHA.indexOfChild(HQ) < 0) {
                if (HQ.getParent() instanceof ViewGroup) {
                    ((ViewGroup) HQ.getParent()).removeView(HQ);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hHm != null && this.hHm.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hsk != null && this.hsk.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.hsj != null && this.hsj.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hHA.addView(HQ, layoutParams);
            }
            HQ.bringToFront();
        }
    }

    protected void cef() {
        View Ie;
        if (this.hrZ == null) {
            ak akVar = new ak();
            akVar.aWW = true;
            akVar.pageContext = cfB().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.hrZ = (ag) runTask.getData();
            }
        }
        if (this.hrZ != null && (Ie = this.hrZ.Ie()) != null && cfB().hBQ.indexOfChild(Ie) < 0) {
            if (Ie.getParent() instanceof ViewGroup) {
                ((ViewGroup) Ie.getParent()).removeView(Ie);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            cfB().hBQ.addView(Ie, layoutParams);
        }
    }

    private void ckG() {
        ckK();
        cel();
        ckJ();
        cfB().hBQ.setVisibility(0);
        xl(0);
    }

    private void ckH() {
        if (this.hHm == null) {
            this.hHm = new com.baidu.tieba.ala.liveroom.u.a(cfB().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hHm.a(cfB().bUm(), j, TbadkCoreApplication.getCurrentAccountName(), true, cfB().hBP.HR().aKu.portrait, this.otherParams, "", -1L);
        this.hHm.aF(this.hHA);
    }

    private void ckI() {
        if (this.hHV == null) {
            cfB().hBQ.hRu = false;
            com.baidu.live.ag.a gb = gb(cfB().pageContext.getPageActivity());
            if (gb != null) {
                this.hHV = gb;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.ag.a.class, cfB().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hHV = (com.baidu.live.ag.a) runTask.getData();
                }
            }
            if (this.hHV != null) {
                this.hHV.t(this.hHB);
                this.hHV.u(this.hHC);
                this.hHV.fz((cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - cfB().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hHV.v(cfB().hBQ);
                this.hHV.a(this.hpW);
                this.hHV.setLiveShowInfo(cfB().hBP.HR());
                this.hHV.a(this.hqE);
                this.hHV.SZ();
                this.hHV.a(new a.InterfaceC0165a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                    @Override // com.baidu.live.ag.a.InterfaceC0165a
                    public void Ta() {
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0165a
                    public void Tb() {
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0165a
                    public void F(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.cfB().hCg != null) {
                            AlaMasterLiveRoomOpearator.this.cfB().hCg.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0165a
                    public int Tc() {
                        return AlaMasterLiveRoomOpearator.this.hHz.getBottom();
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0165a
                    public int Td() {
                        return AlaMasterLiveRoomOpearator.this.huX.hBQ.getHeight() - (AlaMasterLiveRoomOpearator.this.hrL.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.hrL.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0165a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.hrL.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.ag.a.InterfaceC0165a
                    public int Te() {
                        return AlaMasterLiveRoomOpearator.this.hrL.MD();
                    }
                });
            }
        }
    }

    private com.baidu.live.ag.a gb(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aZ(context);
        }
        return null;
    }

    private void ckJ() {
        if (this.hHo == null) {
            this.hHo = new b(cfB().pageContext, cfB().hBQ);
        }
    }

    private void ckK() {
        if (this.hqz == null) {
            this.hqz = new com.baidu.tieba.ala.liveroom.o.a(cfB().pageContext, true, this.hIJ);
            this.hqz.e(this.hHz, null);
            this.hqz.a(this.hrl);
            this.hqz.oo(false);
        }
        if (this.hHk == null) {
            this.hHk = new com.baidu.tieba.ala.liveroom.o.a(cfB().pageContext, true, null);
            this.hHk.a(this.hHz, null, a.f.ala_live_room_host_header_stub);
            this.hHk.cjd();
        }
    }

    protected void cdM() {
        CustomResponsedMessage runTask;
        boolean z = false;
        as cmn = cfB().hBP.cmn();
        boolean z2 = com.baidu.live.af.a.SE().bwi.aOZ;
        if (cmn == null || cmn.aLg) {
            z = z2;
        }
        if (z && this.hrw == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.k.b.class, cfB().pageContext)) != null) {
            this.hrw = (com.baidu.live.k.b) runTask.getData();
            if (this.hrw != null) {
                this.hrw.setIsHost(true);
                this.hrw.eV(1);
                View view = this.hrw.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(cfB().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(cfB().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hHz.addView(view, layoutParams);
                }
            }
        }
    }

    private void g(x xVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2;
        if (this.hqE == null) {
            this.hqE = new com.baidu.tieba.ala.liveroom.activeview.b(cfB().pageContext);
        }
        this.hqE.setOtherParams(this.otherParams);
        this.hqE.c(xVar, false);
        this.hqE.setHost(true);
        this.hqE.a(1, this.bzK);
        this.hqE.a(2, this.bzK);
        this.hqE.nB(this.hsG);
        this.hqE.setVisible(this.hHi ? 8 : 0);
        this.hqE.a(this.hpW);
        if (this.hpW != null) {
            if (this.hqE != null) {
                AlaActiveRootView wD = this.hqE.wD(1);
                alaActiveRootView = this.hqE.wD(2);
                alaActiveRootView2 = wD;
            } else {
                alaActiveRootView = null;
                alaActiveRootView2 = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.hpW.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.hpW.a(alaActiveRootView);
            }
        }
    }

    private void N(x xVar) {
        CustomResponsedMessage runTask;
        if (this.hsp == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, cfB().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.ab.a)) {
            this.hsp = (com.baidu.live.ab.a) runTask.getData();
            if (this.hsp != null) {
                this.hsp.s(this.bzK);
            }
        }
        if (this.hsp != null) {
            this.hsG = this.hsp.p(xVar);
            this.hsp.setCanVisible(!this.hHi);
        }
    }

    protected void ckL() {
        CustomResponsedMessage runTask;
        if (cfB() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.m.a.class, cfB().pageContext.getPageActivity())) != null && runTask.getData() != null && this.hsf == null) {
            this.hsf = (com.baidu.live.m.a) runTask.getData();
            this.hsf.d(this.hHA, cez());
            if (cfB().hBP != null) {
                this.hsf.a(cfB().hBP.HR());
            }
            this.hsf.setCanVisible(true);
            this.hsf.cd(false);
            this.hsf.a(cfB().hBP.bWZ());
        }
    }

    protected void cek() {
        CustomResponsedMessage runTask;
        if (cfB() != null && this.hsh == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.u.a.class, cfB().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hsh = (com.baidu.live.u.a) runTask.getData();
            this.hsh.setIsHost(true);
            this.hsh.a(this.bzK, cfB().hBP.HR());
        }
    }

    protected void ccZ() {
        if (cfB() != null) {
            if (this.hsi == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, cfB().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.hsi = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsi.ba(this.gSr);
            this.hsi.bc(false);
            this.hsi.setIsHost(true);
            this.hsi.a(this.bzK, cfB().hBP.HR());
        }
    }

    protected void cej() {
        if (cfB() != null) {
            if (this.hsg == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.w.a.class, cfB().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsg = (com.baidu.live.w.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (cfB().hBP != null) {
                this.hsg.b(cfB().hBP.HR(), this.otherParams);
            }
        }
    }

    protected void ccY() {
        if (cfB() != null) {
            if (this.hqL == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ae.a.class, cfB().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hqL = (com.baidu.live.ae.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hqL.setIsHost(true);
            this.hqL.a(this.bzK, cfB().hBP.HR().aLu);
        }
    }

    protected void ckM() {
        CustomResponsedMessage runTask;
        if (cfB() != null && this.hHS == null && (runTask = MessageManager.getInstance().runTask(2913269, com.baidu.live.o.b.class, cfB().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hHS = (com.baidu.live.o.b) runTask.getData();
        }
    }

    protected void cem() {
        CustomResponsedMessage runTask;
        if (cfB() != null && this.hsj == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.l.a.class, cfB().pageContext)) != null && runTask.getData() != null) {
            this.hsj = (com.baidu.live.l.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.hsj.a(this.hHA, cfB().hBP.HR(), layoutParams, this.otherParams);
        }
    }

    private void O(x xVar) {
        CustomResponsedMessage runTask;
        if (cfB() != null) {
            if (this.hHq == null && (runTask = MessageManager.getInstance().runTask(2913229, com.baidu.live.u.d.class)) != null) {
                this.hHq = (com.baidu.live.u.d) runTask.getData();
            }
            if (this.hHq != null) {
                this.hHq.RC();
            }
            if (this.hHr == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913230, c.class);
                if (runTask2 != null) {
                    this.hHr = (c) runTask2.getData();
                }
                if (this.hHr != null) {
                    this.hHr.setParentView(this.huX.hBQ);
                    if (xVar != null && xVar.aKu != null) {
                        this.hHr.bd(xVar.aKu.userId);
                    }
                }
            }
        }
    }

    private void ckN() {
        CustomResponsedMessage runTask;
        if (cfB() != null) {
            if (this.hHs == null && (runTask = MessageManager.getInstance().runTask(2913265, com.baidu.live.w.c.class)) != null) {
                this.hHs = (com.baidu.live.w.c) runTask.getData();
            }
            if (this.hHs != null) {
                this.hHs.RC();
            }
            if (this.hHt == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913266, com.baidu.live.w.b.class);
                if (runTask2 != null) {
                    this.hHt = (com.baidu.live.w.b) runTask2.getData();
                }
                if (this.hHt != null) {
                    this.hHt.setParentView(this.huX.hBQ);
                    this.hHt.b(cfB().hBP.HR(), this.otherParams);
                }
            }
        }
    }

    private void cdV() {
        if (this.hIt == null) {
            this.hIt = new com.baidu.tieba.ala.liveroom.q.c(cfB().pageContext.getPageActivity());
        }
    }

    private ViewGroup.LayoutParams cez() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(cfB().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.hsk != null && this.hsk.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hHm != null && this.hHm.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void cel() {
        if (this.hHl == null) {
            this.hHl = new com.baidu.tieba.ala.liveroom.b.a(cfB().pageContext, true);
        }
    }

    private void ckO() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = cfB().pageContext.getPageActivity();
            if (this.hHW == null) {
                this.hHW = new ImageView(pageActivity);
                this.hHW.setId(a.f.master_close_btn);
                this.hHW.setTag("master_close_btn");
                this.hHW.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hHW.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hHW.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hHW.getParent() != null) {
                ((ViewGroup) this.hHW.getParent()).removeView(this.hHW);
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
            cfB().hCj.addView(this.hHW, layoutParams);
            this.hHW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.ckY();
                }
            });
            this.hHW.setVisibility(8);
        }
    }

    protected void cep() {
        if (this.hsk == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.u.b.class, cfB().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.hsk = (com.baidu.live.u.b) runTask.getData();
            } else {
                return;
            }
        }
        if (cfB().hBP.HR() != null && cfB().hBP.HR().aKu != null && cfB().hBP.HR().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(cfB().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(cfB().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.hsk.b(this.hHA, layoutParams, cfB().hBP.HR());
        }
    }

    private void ckP() {
        CustomResponsedMessage runTask;
        if (this.hIr == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, cfB().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.hIr = (com.baidu.live.b.a) runTask.getData();
            if (this.hIr != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = cfB().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                as cmn = cfB().hBP.cmn();
                if (cmn != null) {
                    this.hIr.a(this.hHA, layoutParams, cfB().pageContext.getPageActivity(), cmn.aQa);
                } else {
                    return;
                }
            }
        }
        if (this.hIr != null) {
            this.hIr.a(cfB().hBP.HR());
        }
    }

    private void ckQ() {
        CustomResponsedMessage runTask;
        if (this.hIs == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, cfB().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.hIs = (com.baidu.live.b.b) runTask.getData();
        }
    }

    private void cdW() {
        if (this.hfG == null) {
            this.hfG = new com.baidu.live.ap.a(cfB().pageContext.getPageActivity());
        }
    }

    public void onRtcConnected(int i) {
        if (this.hIp != null) {
            this.hIp.onRtcConnected(i);
        }
    }

    private void registerListener() {
        cfB().pageContext.registerListener(this.hsY);
        cfB().pageContext.registerListener(this.hIB);
        cfB().pageContext.registerListener(this.hsZ);
        cfB().pageContext.registerListener(this.hta);
        cfB().pageContext.registerListener(this.hIG);
        cfB().pageContext.registerListener(this.bDh);
        cfB().pageContext.registerListener(this.hpc);
        cfB().pageContext.registerListener(this.hIH);
        cfB().pageContext.registerListener(this.gPf);
        cfB().pageContext.registerListener(this.hrg);
        cfB().pageContext.registerListener(this.hte);
        cfB().pageContext.registerListener(this.bFG);
        cfB().pageContext.registerListener(this.bFH);
        cfB().pageContext.registerListener(this.hIC);
        cfB().pageContext.registerListener(this.bta);
        cfB().pageContext.registerListener(this.btb);
        cfB().pageContext.registerListener(this.hID);
        cfB().pageContext.registerListener(this.htg);
        cfB().pageContext.registerListener(this.htf);
        cfB().pageContext.registerListener(this.htk);
        cfB().pageContext.registerListener(this.hIE);
        cfB().pageContext.registerListener(this.hID);
        cfB().pageContext.registerListener(this.bpW);
        cfB().pageContext.registerListener(this.bnt);
        cfB().pageContext.registerListener(this.hfH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ot(boolean z) {
        if (bo.c(com.baidu.live.af.a.SE().bCb)) {
            cfB().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (cfB().hCl.CP() == null || ListUtils.isEmpty(cfB().hCl.CP().aFl)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                cfB().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bFE) {
                this.bFD = BdUniqueId.gen();
                cfB().hCl.a(this.bFD);
                this.bFE = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(cfB().pageContext.getPageActivity(), cfB().rootView);
            xl(8);
            if (cfB().hCg.hasAdvancedBeauty() && this.hIo != null) {
                if (!this.hIu || this.hHj.getVisibility() == 0) {
                    this.hIo.c(cfB().hCg.getVideoConfig());
                }
                this.hIo.a(cfB().hCg.getVideoConfig(), this.bFF);
                if (!this.bFF) {
                    this.bFF = true;
                }
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
    public void xk(int i) {
        if (this.hHX == null || !this.hHX.isShowing()) {
            this.hHX = new BdAlertDialog(cfB().pageContext.getPageActivity());
            this.hHX.setAutoNight(false);
            this.hHX.setTitle(a.h.sdk_prompt);
            this.hHX.setMessageId(i, currentAppType(cfB().pageContext.getPageActivity()));
            this.hHX.setTitleShowCenter(true);
            this.hHX.setMessageShowCenter(true);
            this.hHX.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.cfB().g((short) 1);
                }
            });
            this.hHX.create(cfB().pageContext).show();
        }
    }

    private void Iz(String str) {
        if (this.hHY == null || !this.hHY.isShowing()) {
            this.hHY = new BdAlertDialog(cfB().pageContext.getPageActivity());
            this.hHY.setAutoNight(false);
            this.hHY.setTitle(a.h.sdk_prompt);
            this.hHY.setMessage(str);
            this.hHY.setTitleShowCenter(true);
            this.hHY.setMessageShowCenter(true);
            this.hHY.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.cfB().g((short) 1);
                }
            });
            this.hHY.create(cfB().pageContext).show();
        }
    }

    public void ckR() {
        cdM();
        r bWZ = cfB().hBP.bWZ();
        int i = 5;
        if (bWZ != null) {
            i = (int) bWZ.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.cfB().hBP.HR() != null && AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.cfB().hBP.i(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bWZ != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.huX.hCo.b(bWZ);
                return;
            }
            if (this.hqy == null) {
                this.hqy = new com.baidu.tieba.ala.liveroom.audiencelist.c(cfB().pageContext, this.hIJ, true);
            }
            if (this.hIm) {
                this.hIm = false;
                this.hqy.a(String.valueOf(cfB().hBP.HR().mLiveInfo.group_id), String.valueOf(cfB().hBP.HR().mLiveInfo.live_id), String.valueOf(cfB().hBP.HR().aKu.userId), cfB().hBP.HR());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.hrw != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.hqy.c(this.hHz, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.hqy.e(bWZ);
            this.hqC.setVisible(0);
            this.hqC.eZ(bWZ.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckS() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byf() {
        if (cfB().hBP != null) {
            if (this.hry == null) {
                this.hry = new com.baidu.tieba.ala.liveroom.share.c(cfB().pageContext);
            }
            this.hry.d(cfB().hBP.HR(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (cfB().hBP != null && cfB().hBP.HR() != null && cfB().hBP.HR().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", cfB().hBP.HR().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", cfB().hBP.HR().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", cfB().hBP.HR().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (cfB().hBP != null && cfB().hBP.HR() != null && cfB().hBP.HR().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", cfB().hBP.HR().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", cfB().hBP.HR().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", cfB().hBP.HR().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean ckT() {
        return this.hHh;
    }

    private void ou(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hHg, z);
        this.hHh = z;
    }

    private void ckU() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(cfB().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.p.b(AlaMasterLiveRoomOpearator.this.cfB().pageContext).clV();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(cfB().pageContext).show();
    }

    private void ckV() {
        if (this.hGQ && cfB().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            cfB().hCn.Wl();
        }
        cfB().hCm.prepareTime = System.currentTimeMillis() - cfB().hCm.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (cfB().hBP != null && cfB().hBP.HR() != null && cfB().hBP.HR().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", cfB().hBP.HR().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", cfB().hBP.HR().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", cfB().hCm.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hHj != null && this.hHj.getView().getParent() != null) {
            this.hHj.setVisibility(8);
            cfB().hCj.removeView(this.hHj.getView());
            this.hHj.release();
        }
        if (this.hIo != null) {
            this.hIo.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (cfB().hBQ.indexOfChild(this.hHw) < 0) {
            cfB().hBQ.addView(this.hHw, layoutParams);
        }
        this.hHw.xC(1000);
    }

    private void azK() {
        if (cfB().bUm() == 1) {
            cfB().hCg.startRecord();
        }
    }

    private void IA(String str) {
        IB(str);
    }

    private void IB(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) cfB().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String P(Intent intent) {
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

    private void Q(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hHj != null) {
            this.hHj.Io(fromJson.getSmallurl());
        }
    }

    private boolean ckW() {
        return com.baidu.live.d.Ba().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckX() {
        com.baidu.live.d.Ba().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.huX.hCg.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckY() {
        if (this.hIq == null || !this.hIq.Ty()) {
            if (this.hHv == null || !this.hHv.Ty()) {
                int i = a.h.live_close_confirm;
                if (this.hIp != null && this.hIp.cfJ()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hIp != null && this.hIp.cfI()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(cfB().pageContext.getPageActivity());
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
                        if (AlaMasterLiveRoomOpearator.this.cfB().hBP.HR() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR(), 0, AlaMasterLiveRoomOpearator.this.cfB().hBP.cmw() != 1 ? AlaMasterLiveRoomOpearator.this.cfB().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
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
                bdAlertDialog.create(cfB().pageContext).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(x xVar, int i, String str) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        AlaLiveInfoData alaLiveInfoData;
        if (xVar != null) {
            alaLiveInfoData = xVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = xVar.aKu;
            if (alaLiveInfoData != null) {
                String str2 = alaLiveInfoData.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                cfB().hBP.eC(Long.toString(alaLiveInfoData.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
        } else {
            alaLiveUserInfoData = null;
            alaLiveInfoData = null;
        }
        if (!this.hIk) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = cfB().hCm;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = cfB().hCg.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hIg;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hIh;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hIc;
            if (this.hId != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hIe - this.hIf) / this.hId) * 100.0f;
            }
            Intent intent = new Intent(cfB().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (cfB().hBP != null && cfB().hBP.HR() != null && cfB().hBP.HR().aKu != null) {
                String str3 = cfB().hBP.HR().aKu.nickName;
                String str4 = cfB().hBP.HR().aKu.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            x HR = cfB().hBP.HR();
            if (HR != null && HR.aKu != null && !TextUtils.isEmpty(HR.aKu.portrait)) {
                intent.putExtra("host_portrait", HR.aKu.portrait);
            }
            if (this.hIq != null) {
                this.hIq.XK();
            }
            if (this.hHv != null) {
                this.hHv.Tw();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hIi = intent;
                this.hIj = s;
                cfB().pageContext.showToast(a.h.ala_live_background_close_tip);
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
    public void ckZ() {
        if (this.hIi != null) {
            a(this.hIi, this.hIj);
            this.hIi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hIk = true;
        if (this.hIp != null) {
            this.hIp.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.hoR);
            cfB().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        cfB().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cla() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.huX.hCo != null && this.huX.hCo.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hIp != null && this.hIp.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hIq != null && this.hIq.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hIo != null && this.hIo.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hHv != null && this.hHv.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (cfB().hCk.clE()) {
                ckY();
                return true;
            }
        }
        return false;
    }

    public void sendBufferChanged(int i) {
        if (this.hHx != null) {
            this.hHx.fL(i);
        }
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (this.huX != null && this.huX.hBP != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dNX != i3) {
                this.dNX = i3;
                if (this.hHp == null) {
                    this.hHp = new com.baidu.tieba.ala.liveroom.tippop.a(this.huX.pageContext, null);
                }
                switch (this.dNX) {
                    case 0:
                        this.hHp.c(this.huX.hCj, this.huX.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hHp.c(this.huX.hCj, this.huX.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hHp.c(this.huX.hCj, this.huX.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.huX.hBP.z(this.huX.hBP.HR().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void K(com.baidu.live.im.data.b bVar) {
        String str;
        final String str2;
        JSONObject jSONObject;
        if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                str = jSONObject.optString("content_type");
            } catch (JSONException e) {
                str = null;
            }
            try {
                str2 = jSONObject.optString("text");
            } catch (JSONException e2) {
                str2 = null;
                if (!"close_live".equals(str)) {
                }
            }
            if (!"close_live".equals(str)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cla();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR(), 1, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0736, code lost:
        Ib(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: JSONException -> 0x082b, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082b, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0820), top: B:292:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0820 A[Catch: JSONException -> 0x082b, TRY_ENTER, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082b, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0820), top: B:292:0x0049 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        JSONObject jSONObject3;
        long j;
        long j2;
        boolean z;
        JSONObject jSONObject4;
        if (TbConfig.IM_LOG) {
            Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 msgType " + bVar.getMsgType());
        }
        if (this.hqE != null) {
            this.hqE.I(bVar);
        }
        if (bVar.getMsgType() == 125) {
            if (this.hHn != null) {
                this.hHn.M(bVar);
            }
        } else if (bVar.getMsgType() == 13 || bVar.getMsgType() == 12) {
            String str2 = null;
            final String str3 = null;
            JSONObject jSONObject5 = null;
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject5 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject5 = new JSONObject(bVar.getContent());
                }
                str2 = jSONObject5.optString("content_type");
                if (TbConfig.IM_LOG) {
                    Log.i("imlog", "@.@ IM消息 接收: liveSingleMessageReceived 消息分发 contentType: " + str2);
                }
                str3 = jSONObject5.optString("text");
                String optString = jSONObject5.optString("ext");
                if (!TextUtils.isEmpty(optString)) {
                    new JSONObject(new String(Base64.decode(optString.getBytes(), 0)));
                }
                jSONObject = jSONObject5.optJSONObject("ext_data");
            } catch (JSONException e) {
                jSONObject = null;
            }
            if (this.hIp != null) {
                this.hIp.gg(str2);
            }
            if ("close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cla();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.cfB().hBP.HR(), 1, str3);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (cfB().hBP.HR() != null && jSONObject5 != null) {
                    long optLong = jSONObject5.optLong("user_id");
                    int optInt = jSONObject5.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cfB().hBP.HR().aKQ.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            cfB().hBP.HR().aKQ.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        cfB().hBP.HR().aKQ.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (cfB().hBP.HR() != null && jSONObject5 != null) {
                    long optLong2 = jSONObject5.optLong("user_id");
                    if (cfB().hBP.HR() != null && cfB().hBP.HR().aKu != null && cfB().hBP.HR().aKu.userId == optLong2) {
                        cfB().hBP.HR().aKu.isUegBlock = 1;
                        cdq();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (cfB().hBP.HR() != null && jSONObject5 != null) {
                    long optLong3 = jSONObject5.optLong("user_id");
                    if (cfB().hBP.HR() != null && cfB().hBP.HR().aKu != null && cfB().hBP.HR().aKu.userId == optLong3) {
                        cfB().hBP.HR().aKu.isUegBlock = 0;
                        cdq();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hHT != null) {
                    this.hHT.Z(jSONObject5);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString2 = jSONObject5.optString("share_enter_msg");
                    int optInt2 = jSONObject5.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.hHo.aL(optString2, optInt2);
                    }
                    if (this.hqC.getCount() > 20) {
                        this.hqC.eZ(this.hqC.getCount() + 1);
                    } else if (this.hqy != null) {
                        com.baidu.live.data.a Nw = bVar.Nw();
                        q qVar = new q();
                        qVar.aKv = new AlaLocationData();
                        qVar.aKw = new AlaRelationData();
                        qVar.aKu = new AlaLiveUserInfoData();
                        qVar.aKu.userId = JavaTypesHelper.toLong(Nw.userId, 0L);
                        qVar.aKu.userName = Nw.userName;
                        qVar.aKu.portrait = Nw.portrait;
                        if (this.hqy.c(qVar)) {
                            this.hqC.eZ(this.hqC.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject5 != null && cfB() != null && cfB().hBP != null && cfB().hBP.HR() != null && cfB().hBP.HR().aKQ != null && cfB().hBP.HR().aKQ.userId == jSONObject5.optLong("user_id")) {
                    cfB().hBP.cmm();
                }
            } else if ("official_notice".equals(str2)) {
                if (jSONObject5 != null) {
                    long optLong4 = jSONObject5.optLong("user_id");
                    if (jSONObject != null) {
                        String str4 = optLong4 + "";
                        TbadkCoreApplication.getInst();
                        if (str4.equals(TbadkCoreApplication.getCurrentAccount())) {
                            OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                            officialNoticeData.parserJson(jSONObject);
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                        }
                    }
                }
            } else if ("privilege_award_royal_success".equals(str2)) {
                if (jSONObject5 != null) {
                    String str5 = jSONObject5.optInt("effect_id") + "";
                    com.baidu.live.data.a Nw2 = bVar.Nw();
                    if (Nw2 != null && ac.hg(str5)) {
                        ac.d(str5, 1L, "", "", Nw2.userId, Nw2.portrait, Nw2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject5 != null) {
                    bd bdVar = new bd();
                    bdVar.parseJson(jSONObject5);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bdVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject5 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject5));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString3 = jSONObject5.optString("challenge_im_type");
                    if (TextUtils.equals(optString3, "start")) {
                        IC(jSONObject5.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString3, "cancel")) {
                        BdUtilHelper.showToast(cfB().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                    }
                }
                if (jSONObject5 == null) {
                    jSONObject2 = null;
                } else {
                    String optString4 = jSONObject5.optString("challenge_im_type");
                    if (!TextUtils.equals(optString4, "start")) {
                        str = "";
                    } else {
                        str = jSONObject5.optString("challenge_user_name");
                    }
                    try {
                        jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("challenge_im_type", optString4);
                            jSONObject2.put("challenge_user_name", str);
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_direct_new").setContentExt(null, null, jSONObject2));
                            if (!(bVar.getObjContent() instanceof JSONObject)) {
                            }
                            try {
                                jSONObject4.put("log_id", bVar.getMsgId());
                            } catch (JSONException e3) {
                            }
                            if (this.hsj != null) {
                            }
                            if (this.hsh != null) {
                            }
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        jSONObject2 = null;
                    }
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_direct_new").setContentExt(null, null, jSONObject2));
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(cfB().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_random_cancel").setContentExt(null, null, null));
            } else if ("connect_apply_show_pub".equals(str2)) {
                if (this.hHv != null) {
                    this.hHv.Y(jSONObject5);
                }
            } else if ("remove_video".equals(str2)) {
                String optString5 = jSONObject5.optString("text");
                if (jSONObject5.optString("poke_msg").isEmpty()) {
                    Iy(optString5);
                }
            }
        } else if (bVar.getMsgType() == 24) {
            com.baidu.live.data.a Nw3 = bVar.Nw();
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject3 = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject3 = new JSONObject(bVar.getContent());
                }
                com.baidu.live.im.data.c cVar = new com.baidu.live.im.data.c(jSONObject3);
                String optString6 = jSONObject3.optString("order_id");
                String optString7 = jSONObject3.optString(LogConfig.LOG_GIFT_ID);
                String optString8 = jSONObject3.optString("gift_count");
                String optString9 = jSONObject3.optString("gift_name");
                long optLong5 = jSONObject3.optLong("charm_total");
                String optString10 = jSONObject3.optString("attach_new");
                String optString11 = jSONObject3.optString("gift_mul");
                boolean z2 = jSONObject3.optInt("is_dynamic_gift") == 1;
                boolean z3 = jSONObject3.optInt("from_gongyanfang_2") == 1;
                boolean z4 = jSONObject3.optInt("from_gongyanfang_page") == 1;
                String str6 = "";
                String str7 = "";
                long j3 = 0;
                String str8 = null;
                if (cfB().hBP == null || cfB().hBP.HR() == null || cfB().hBP.HR().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    z = false;
                } else {
                    long j4 = cfB().hBP.HR().mLiveInfo.live_id;
                    j3 = cfB().hBP.HR().mLiveInfo.group_id;
                    long j5 = cfB().hBP.HR().aKu.userId;
                    str8 = cfB().hBP.HR().mLiveInfo.appId;
                    boolean z5 = cfB().hBP.HR().mLiveInfo.isPubShow;
                    if (cfB().hBP.HR().mLiveSdkInfo.mCastIds != null) {
                        str6 = cfB().hBP.HR().mLiveSdkInfo.mCastIds.chatMCastId;
                        str7 = cfB().hBP.HR().mLiveSdkInfo.mCastIds.ensureMCastId;
                        j = j5;
                        j2 = j4;
                        z = z5;
                    } else {
                        j = j5;
                        j2 = j4;
                        z = z5;
                    }
                }
                if (!z3 || z2) {
                    LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str6, str7, optString7, "");
                    if (!this.isBackground || cfB().bUm() != 2) {
                        if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                            if (jSONObject3.optInt("flag_show") == 1) {
                                ac.b(cVar, Nw3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, "", "", bVar.getMsgId());
                                try {
                                    JSONArray jSONArray = new JSONArray(optString11);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i >= jSONArray.length()) {
                                                break;
                                            }
                                            if (com.baidu.live.af.f.SV().ik(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                            bVar.setHost(z && z4);
                            ac.b(cVar, Nw3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, (z4 || z3) ? false : true, true, str6, str7, bVar.getMsgId());
                        }
                    }
                    Ib(optString7);
                    if (!jSONObject3.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
                        com.baidu.tieba.ala.liveroom.g.c cVar2 = new com.baidu.tieba.ala.liveroom.g.c();
                        cVar2.bqF = optLong5;
                        cVar2.liveId = j2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                        jSONObject6.putOpt("gift_name", optString9);
                        jSONObject6.putOpt("order_id", optString6);
                        com.baidu.live.gift.g hc = ac.hc(optString7);
                        if (hc != null) {
                            jSONObject6.putOpt(LogConfig.LOG_GIFT_VALUE, hc.getPrice());
                        }
                        jSONObject6.putOpt("gift_num", optString8);
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "giftsend_succ").setContentExt(null, "popup", jSONObject6));
                } else {
                    return;
                }
            } catch (JSONException e7) {
            }
        }
        try {
            if (!(bVar.getObjContent() instanceof JSONObject)) {
                jSONObject4 = (JSONObject) bVar.getObjContent();
            } else {
                jSONObject4 = new JSONObject(bVar.getContent());
            }
            jSONObject4.put("log_id", bVar.getMsgId());
        } catch (JSONException e8) {
            jSONObject4 = null;
        }
        if (this.hsj != null) {
            this.hsj.l(bVar);
        }
        if ((this.hsh != null || !this.hsh.V(jSONObject4)) && this.hqL != null && this.hqL.V(jSONObject4)) {
        }
    }

    private void Ib(String str) {
        if (this.hqE != null) {
            this.hqE.Ib(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xl(int i) {
        View findViewById = cfB().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.hqE != null) {
            this.hqE.bP(2, i);
        }
    }

    private void clb() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.cfB().hCg != null && AlaMasterLiveRoomOpearator.this.cfB().hCg.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.cfB().hCg.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.cfB().hCg.startRecord();
                }
            }
        });
    }

    private void clc() {
        if (cfB().hCg != null && cfB().hCg.getPreview() != null) {
            cfB().hCg.getPreview().setVisibility(8);
            cfB().hCg.stopRecord();
        }
    }

    public void cld() {
        this.hCd = cfB().hBP.cmx();
        if (this.hHj != null) {
            this.hHj.ob(this.hCd);
        }
    }

    public void chv() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cle();
        } else if (this.hHj != null) {
            this.hHj.chv();
        }
    }

    public void oc(boolean z) {
        if (this.hHj != null) {
            this.hHj.oc(z);
        }
    }

    public void onDestroy() {
        if (this.hIb != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hIb);
        }
        this.hIb = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hHR.removeCallbacksAndMessages(null);
        if (this.hIo != null) {
            this.hIo.nZ(true);
        }
        this.hIo = null;
        if (this.hHj != null) {
            this.hHj.destroy();
            cfB().hCj.removeView(this.hHj.getView());
            this.hHj.release();
            this.hHj = null;
        }
        if (this.hIp != null) {
            this.hIp.onDestroy();
        }
        if (this.hry != null) {
            this.hry.onDestroy();
        }
        if (this.hqz != null) {
            this.hqz.onDestroy();
            this.hqz = null;
        }
        if (this.hHk != null) {
            this.hHk.onDestroy();
        }
        if (this.hrZ != null) {
            this.hrZ.onDestroy();
            this.hrZ = null;
        }
        if (this.hHw != null) {
            this.hHw.stopCountDown();
        }
        if (this.hHm != null) {
            this.hHm.onDestroy();
        }
        if (this.hHo != null) {
            this.hHo.onDestroy();
        }
        if (this.hHT != null) {
            this.hHT.onDestroy();
            this.hHT = null;
        }
        if (this.hrN != null) {
            this.hrN.onDestroy();
            this.hrN = null;
        }
        if (this.hHq != null) {
            this.hHq.release();
        }
        if (this.hHs != null) {
            this.hHs.release();
        }
        com.baidu.live.ah.a.b.Tq().release();
        ac.HZ();
        com.baidu.live.entereffect.a.FB().release();
        this.hIz = false;
        if (this.hrO != null) {
            this.hrO.onDestroy();
            this.hrO = null;
        }
        if (this.hHp != null) {
            this.hHp.onDestroy();
        }
        if (this.hHn != null) {
            this.hHn.coE();
            this.hHn.release();
        }
        if (this.hqC != null) {
            this.hqC = null;
        }
        if (this.hqE != null) {
            this.hqE.release();
        }
        if (this.hHn != null) {
            this.hHn.onDestroy();
        }
        if (this.hrM != null) {
            this.hrM.release();
        }
        if (this.hHu != null) {
            this.hHu.release();
        }
        if (this.hHV != null) {
            this.hHV.onDestroy();
        }
        if (this.hsp != null) {
            this.hsp.release();
        }
        if (this.hIr != null) {
            this.hIr.onDestory();
        }
        if (this.hIs != null) {
            this.hIs.release();
        }
        if (this.hsf != null) {
            this.hsf.onDestroy();
        }
        if (this.hsh != null) {
            this.hsh.onDestroy();
        }
        if (this.hsg != null) {
            this.hsg.onDestroy();
        }
        if (this.hqL != null) {
            this.hqL.onDestroy();
        }
        if (this.hHr != null) {
            this.hHr.release();
            this.hHr = null;
        }
        if (this.hHt != null) {
            this.hHt.release();
            this.hHt = null;
        }
        if (this.hIt != null) {
            this.hIt.release();
        }
        if (this.hfG != null) {
            this.hfG.release();
        }
        if (this.hsk != null) {
            this.hsk.onDestroy();
        }
        if (this.hIq != null) {
            this.hIq.onDestroy();
        }
        if (this.hHv != null) {
            this.hHv.onDestroy();
        }
        if (this.hst != null) {
            this.hst.onDestory();
        }
        if (this.hHX != null) {
            this.hHX.dismiss();
            this.hHX = null;
        }
        if (this.hHY != null) {
            this.hHY.dismiss();
            this.hHY = null;
        }
        this.hIv.removeCallbacksAndMessages(this.hIR);
        MessageManager.getInstance().unRegisterListener(this.hsY);
        MessageManager.getInstance().unRegisterListener(this.hIB);
        MessageManager.getInstance().unRegisterListener(this.hsZ);
        MessageManager.getInstance().unRegisterListener(this.hta);
        MessageManager.getInstance().unRegisterListener(this.hIG);
        MessageManager.getInstance().unRegisterListener(this.bDh);
        MessageManager.getInstance().unRegisterListener(this.hpc);
        MessageManager.getInstance().unRegisterListener(this.hIH);
        MessageManager.getInstance().unRegisterListener(this.gPf);
        MessageManager.getInstance().unRegisterListener(this.hrg);
        MessageManager.getInstance().unRegisterListener(this.hte);
        MessageManager.getInstance().unRegisterListener(this.bFG);
        MessageManager.getInstance().unRegisterListener(this.bFH);
        MessageManager.getInstance().unRegisterListener(this.hIC);
        MessageManager.getInstance().unRegisterListener(this.bta);
        MessageManager.getInstance().unRegisterListener(this.btb);
        MessageManager.getInstance().unRegisterListener(this.hID);
        MessageManager.getInstance().unRegisterListener(this.htg);
        MessageManager.getInstance().unRegisterListener(this.htf);
        MessageManager.getInstance().unRegisterListener(this.htk);
        MessageManager.getInstance().unRegisterListener(this.hIE);
        MessageManager.getInstance().unRegisterListener(this.hID);
        MessageManager.getInstance().unRegisterListener(this.bpW);
        MessageManager.getInstance().unRegisterListener(this.bnt);
        MessageManager.getInstance().unRegisterListener(this.hfH);
        MessageManager.getInstance().unRegisterListener(this.gZs);
        MessageManager.getInstance().unRegisterListener(this.gZK);
        cfB().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.huX.hCo.a(this.hIQ, this.huX.hCi, this.hHy, alaLivePersonData);
        }
    }

    private void cle() {
        if (this.hHZ != null) {
            this.huX.hCm.startTime = System.currentTimeMillis();
            this.huX.hCm.liveTotalTime = System.currentTimeMillis();
            this.huX.hCm.sampleMemAndCPU();
            this.huX.hCk.a((short) 4, this.hHZ);
        }
    }

    private void IC(String str) {
        String str2;
        int i;
        if (cfB() != null && cfB().pageContext != null) {
            this.hHR.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = cfB().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hIx == null) {
                    this.hIx = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hIx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.ckc()) {
                                AlaMasterLiveRoomOpearator.this.hHR.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hIx != null) {
                                    AlaMasterLiveRoomOpearator.this.cfB().hBQ.removeView(AlaMasterLiveRoomOpearator.this.hIx);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hIp != null) {
                                    AlaMasterLiveRoomOpearator.this.hIp.cfF();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hIx.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hHR.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.cfB().hBQ != null && AlaMasterLiveRoomOpearator.this.hve != null && AlaMasterLiveRoomOpearator.this.hIx != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hIx.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hIx.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.v((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hIx.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.hve.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.hve.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.hve.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.hve.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hIx.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hIx.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hIx != null) {
                                AlaMasterLiveRoomOpearator.this.cfB().hBQ.removeView(AlaMasterLiveRoomOpearator.this.hIx);
                            }
                            AlaMasterLiveRoomOpearator.this.cfB().hBQ.addView(AlaMasterLiveRoomOpearator.this.hIx, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.af.a.SE().bwi != null) {
                    i = com.baidu.live.af.a.SE().bwi.aOf;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hHR.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.cfB().hBQ != null && AlaMasterLiveRoomOpearator.this.hIx != null) {
                            AlaMasterLiveRoomOpearator.this.cfB().hBQ.removeView(AlaMasterLiveRoomOpearator.this.hIx);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bYG() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            x HR = cfB().hBP.HR();
            if (HR != null) {
                bVar.setAnchorId(HR.mLiveInfo.user_id);
                bVar.setParams();
                bVar.setTag(this.gQC);
                MessageManager.getInstance().sendMessage(bVar);
            }
        }
    }

    public void clf() {
        if (cfB().pageContext.getPageActivity() instanceof Activity) {
            Activity pageActivity = cfB().pageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity.isDestroyed() || pageActivity.isFinishing()) {
                    return;
                }
            } else if (pageActivity.isFinishing()) {
                return;
            }
        }
        boolean z = com.baidu.live.d.Ba().getBoolean("new_anchor_club_rename", true);
        as cmn = cfB().hBP.cmn();
        if (cmn != null && this.bkF != null && cmn.aQb == 1 && z) {
            cfB().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            com.baidu.live.d.Ba().putBoolean("new_anchor_club_rename", false);
            View inflate = View.inflate(cfB().pageContext.getPageActivity(), a.g.dialog_help_guard_club_rename, null);
            this.hau = new Dialog(cfB().pageContext.getPageActivity(), a.i.RegimentRenameDiolog);
            final Button button = (Button) inflate.findViewById(a.f.rename_confirm);
            button.setEnabled(false);
            button.setTextColor(cfB().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
            final EditText editText = (EditText) inflate.findViewById(a.f.guard_club_rename_edittext);
            final TextView textView = (TextView) inflate.findViewById(a.f.hint_num);
            ((Button) inflate.findViewById(a.f.rename_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.64
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.gZQ = null;
                    AlaMasterLiveRoomOpearator.this.hau.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.65
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (editText.getText().toString() != null) {
                        AlaMasterLiveRoomOpearator.this.gZQ = editText.getText().toString();
                        if (AlaMasterLiveRoomOpearator.this.bkF != null && AlaMasterLiveRoomOpearator.this.gZQ != null) {
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.bkF.id, AlaMasterLiveRoomOpearator.this.gZQ, "");
                            } else {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), "网络故障，请刷新重试");
                            }
                        } else {
                            return;
                        }
                    }
                    AlaMasterLiveRoomOpearator.this.hau.dismiss();
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.67
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    String obj = editText.getText().toString();
                    if (obj.length() == 0) {
                        textView.setTextColor(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        textView.setText("0");
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                    }
                    if (obj.length() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < obj.length(); i6++) {
                            String substring = obj.substring(i6, i6 + 1);
                            if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), "仅支持中英文及数字");
                                editText.setText(editText.getText().subSequence(0, i6));
                                editText.setSelection(editText.getText().length());
                                textView.setText((i4 + i5) + "");
                                return;
                            }
                            if (Pattern.compile("[0-9]*").matcher(substring).matches()) {
                                i5++;
                            }
                            if (Pattern.compile("[a-zA-Z]").matcher(substring).matches()) {
                                i5++;
                            }
                            if (Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                i4++;
                            }
                            if (i5 + i4 > 3) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity(), "不能超过3个字符");
                                editText.setText(editText.getText().subSequence(0, (i4 + i5) - 1));
                                editText.setSelection(editText.getText().length());
                                if (Pattern.compile("[0-9]*").matcher(substring).matches()) {
                                    i5--;
                                }
                                if (Pattern.compile("[a-zA-Z]").matcher(substring).matches()) {
                                    i5--;
                                }
                                if (Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                    i4--;
                                }
                                textView.setText((i4 + i5) + "");
                                return;
                            }
                            int i7 = i4 + i5;
                            textView.setText(i7 + "");
                            if (i7 == 3) {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                            } else {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.cfB().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.hau.setContentView(inflate);
            this.hau.setCanceledOnTouchOutside(true);
            inflate.setMinimumHeight((int) (com.baidu.tieba.ala.liveroom.h.f.getScreenHeight(cfB().pageContext.getPageActivity()) * 0.22f));
            Window window = this.hau.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (com.baidu.tieba.ala.liveroom.h.f.getScreenWidth(cfB().pageContext.getPageActivity()) * 0.74f);
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            this.hau.show();
        }
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.liveroom.messages.e eVar = new com.baidu.tieba.ala.liveroom.messages.e();
        eVar.fk(i);
        eVar.HD(str);
        eVar.HE(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
