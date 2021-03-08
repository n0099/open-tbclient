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
import com.baidu.live.af.a;
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
import com.baidu.live.data.aw;
import com.baidu.live.data.ax;
import com.baidu.live.data.bg;
import com.baidu.live.data.bh;
import com.baidu.live.data.bk;
import com.baidu.live.data.bt;
import com.baidu.live.data.v;
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
import com.baidu.live.t.e;
import com.baidu.live.t.f;
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
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
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
import com.baidu.live.v.c;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.g.d;
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
/* loaded from: classes10.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String hIG;
    private PendantParentView bAa;
    private BdUniqueId bFX;
    private boolean bFY;
    private boolean bFZ;
    private com.baidu.live.an.a bif;
    private com.baidu.live.guardclub.a bky;
    private boolean bsd;
    private boolean gSo;
    private String gZR;
    private boolean hIH;
    private d hIJ;
    private com.baidu.tieba.ala.liveroom.m.a hIK;
    private com.baidu.tieba.ala.liveroom.a.a hIL;
    private com.baidu.tieba.ala.liveroom.t.a hIM;
    private com.baidu.tieba.ala.liveroom.v.a hIN;
    private b hIO;
    private com.baidu.tieba.ala.liveroom.tippop.a hIP;
    private e hIQ;
    private com.baidu.live.t.b hIR;
    private com.baidu.live.t.b hIS;
    private f hIT;
    private com.baidu.live.t.d hIU;
    private c hIV;
    private com.baidu.live.v.b hIW;
    protected com.baidu.live.m.a hIX;
    protected com.baidu.live.guess.d hIY;
    protected com.baidu.live.am.b hIZ;
    private boolean hIq;
    private ImageView hJA;
    private BdAlertDialog hJB;
    private BdAlertDialog hJC;
    private com.baidu.tieba.ala.liveroom.data.d hJD;
    private short hJN;
    private com.baidu.tieba.ala.liveroom.g.b hJS;
    private com.baidu.tieba.ala.liveroom.challenge.e hJT;
    private com.baidu.live.al.a hJU;
    private com.baidu.live.b.a hJV;
    private com.baidu.live.guess.b hJW;
    private boolean hJX;
    private boolean hJZ;
    private AlaLiveCountDownView hJa;
    private AlaLiveStreamStatusView hJb;
    private RelativeLayout hJc;
    private RelativeLayout hJd;
    private RelativeLayout hJe;
    private RelativeLayout hJf;
    private RelativeLayout hJg;
    private FrameLayout hJh;
    private FrameLayout hJi;
    private View hJj;
    private boolean hJk;
    private AlaLiveFaceVerifyView hJl;
    private ImageView hJm;
    private ImageView hJn;
    private ImageView hJo;
    private ImageView hJp;
    private ImageView hJq;
    private ImageView hJr;
    private ImageView hJs;
    private TextView hJt;
    private ax hJu;
    private com.baidu.live.n.b hJw;
    private com.baidu.live.ag.a hJx;
    private com.baidu.tieba.ala.liveroom.master.panel.b hJy;
    private com.baidu.live.af.a hJz;
    private View hKa;
    private FrameLayout hKb;
    private boolean hKc;
    private com.baidu.tieba.ala.liveroom.o.a hKd;
    private Dialog hav;
    private String hqz;
    private com.baidu.live.i.a hrA;
    private com.baidu.live.j.b hsZ;
    private com.baidu.tieba.ala.liveroom.audiencelist.c hsc;
    private com.baidu.tieba.ala.liveroom.m.a hsd;
    private com.baidu.tieba.ala.liveroom.audiencelist.b hsg;
    private com.baidu.tieba.ala.liveroom.activeview.b hsi;
    protected com.baidu.live.ad.a hsp;
    protected ag htC;
    protected com.baidu.live.l.a htG;
    protected com.baidu.live.v.a htH;
    protected com.baidu.live.t.a htI;
    protected com.baidu.live.a.a htJ;
    protected com.baidu.live.k.a htK;
    protected com.baidu.live.t.c htL;
    private com.baidu.live.aa.a htQ;
    protected com.baidu.live.s.a htU;
    private com.baidu.tieba.ala.liveroom.share.c htb;
    private com.baidu.tieba.ala.liveroom.q.b htc;
    private m htn;
    private k hto;
    private com.baidu.live.im.b.a htp;
    private ad htq;
    private ab htr;
    private boolean huh;
    private ImageView hwF;
    private com.baidu.tieba.ala.liveroom.data.f hwG;
    private com.baidu.tieba.ala.liveroom.data.e hwy;
    private boolean hII = false;
    private boolean huc = false;
    private Handler mHandler = new Handler();
    private Handler hJv = new Handler();
    private boolean hJE = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver hJF = null;
    private boolean hJG = false;
    private int hJH = 0;
    private int hJI = 0;
    private int hJJ = 0;
    private long hJK = 0;
    private long hJL = 0;
    private volatile boolean isBackground = false;
    private Intent hJM = null;
    private int mOrientation = 1;
    private boolean hDE = false;
    private boolean hJO = false;
    private boolean hJP = true;
    private boolean hwD = false;
    private boolean hJQ = true;
    private boolean hJR = true;
    private int dMQ = 0;
    private String otherParams = "";
    private Handler hJY = new Handler();
    private BdUniqueId gQz = BdUniqueId.gen();
    private boolean mIsKeyboardOpen = false;
    private int bsh = 0;
    private Runnable hKe = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.hrA != null) {
                AlaMasterLiveRoomOpearator.this.hrA.CX();
            }
        }
    };
    private com.baidu.live.al.b bPD = new com.baidu.live.al.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        @Override // com.baidu.live.al.b
        public boolean VG() {
            if (AlaMasterLiveRoomOpearator.this.hJT != null) {
                if (AlaMasterLiveRoomOpearator.this.htI != null) {
                    if (!AlaMasterLiveRoomOpearator.this.hJT.ccT() && !AlaMasterLiveRoomOpearator.this.hJT.ccU() && !AlaMasterLiveRoomOpearator.this.htI.Pl() && !AlaMasterLiveRoomOpearator.this.htI.At()) {
                        return true;
                    }
                } else if (!AlaMasterLiveRoomOpearator.this.hJT.ccT() && !AlaMasterLiveRoomOpearator.this.hJT.ccU()) {
                    return true;
                }
            } else if (AlaMasterLiveRoomOpearator.this.htI == null || AlaMasterLiveRoomOpearator.this.htI.Pl() || AlaMasterLiveRoomOpearator.this.htI.At()) {
                return true;
            }
            return false;
        }

        @Override // com.baidu.live.al.b
        public void VH() {
            if (AlaMasterLiveRoomOpearator.this.hJT != null) {
                AlaMasterLiveRoomOpearator.this.hJT.ccW();
            }
        }

        @Override // com.baidu.live.al.b
        public void VI() {
            AlaMasterLiveRoomOpearator.this.hJZ = true;
            AlaMasterLiveRoomOpearator.this.ccR().hDr.hTf = false;
            if (AlaMasterLiveRoomOpearator.this.htJ != null) {
                AlaMasterLiveRoomOpearator.this.htJ.aW(true);
                AlaMasterLiveRoomOpearator.this.htJ.aX(true);
            }
            AlaMasterLiveRoomOpearator.this.ccm();
        }

        @Override // com.baidu.live.al.b
        public void VJ() {
            AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12.1
                @Override // java.lang.Runnable
                public void run() {
                    AlaMasterLiveRoomOpearator.this.hJZ = false;
                    AlaMasterLiveRoomOpearator.this.ccR().hDr.hTf = false;
                    if (AlaMasterLiveRoomOpearator.this.htJ != null) {
                        AlaMasterLiveRoomOpearator.this.htJ.aW(false);
                        AlaMasterLiveRoomOpearator.this.htJ.aX(false);
                    }
                    AlaMasterLiveRoomOpearator.this.ccm();
                }
            }, 1500L);
        }
    };
    private CustomMessageListener btq = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hwy.hDP != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hwy.hDP.f(list, false);
                }
                for (com.baidu.live.im.data.b bVar : list) {
                    if (bVar != null) {
                        AlaMasterLiveRoomOpearator.this.P(bVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener btr = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.b> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.hwy.hDP != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.hwy.hDP.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener huB = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            try {
                Object[] objArr = (Object[]) customResponsedMessage.getData();
                if (objArr != null && objArr.length >= 2) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) objArr[0];
                    Object obj = objArr[1];
                    String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.group_id);
                    String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.live_id);
                    String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.user_id);
                    if (AlaMasterLiveRoomOpearator.this.htc == null) {
                        AlaMasterLiveRoomOpearator.this.htc = new com.baidu.tieba.ala.liveroom.q.b();
                    }
                    AlaMasterLiveRoomOpearator.this.htc.a(baseFragmentActivity.getPageContext(), valueOf, valueOf2, valueOf3, true, obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private CustomMessageListener huH = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.htG != null) {
                AlaMasterLiveRoomOpearator.this.htG.Jr();
            }
        }
    };
    private CustomMessageListener hKf = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.b) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.t((com.baidu.live.im.data.b) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener huz = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.68
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.HI(str);
            }
        }
    };
    private CustomMessageListener gPc = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.69
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.buI();
        }
    };
    private CustomMessageListener hsK = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.htr.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener huF = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), a.h.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener hKg = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bif != null) {
                com.baidu.live.data.ab Fp = AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp();
                com.baidu.live.an.c cVar = new com.baidu.live.an.c();
                cVar.url = ((String) customResponsedMessage.getData()) + "?anchor_id=" + ExtraParamsManager.getEncryptionUserId(String.valueOf(Fp.mLiveInfo.user_id)) + "&live_id=" + Fp.mLiveInfo.live_id + "&subapp_type=" + TbConfig.getSubappType();
                cVar.bXS = 0.64f;
                AlaMasterLiveRoomOpearator.this.bif.a(cVar);
            }
        }
    };
    private CustomMessageListener hKh = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccR().hDr);
            if (AlaMasterLiveRoomOpearator.this.hIJ == null || AlaMasterLiveRoomOpearator.this.hIJ.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.vS(0);
            }
            if (AlaMasterLiveRoomOpearator.this.hto != null) {
                AlaMasterLiveRoomOpearator.this.hto.Kg().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.hto.Kh().hide();
            }
        }
    };
    private CustomMessageListener huG = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.H(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp());
        }
    };
    private CustomMessageListener huL = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.htC != null) {
                    ((com.baidu.tieba.ala.liveroom.p.a) AlaMasterLiveRoomOpearator.this.htC).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener bGa = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data != null) {
                    if (AlaMasterLiveRoomOpearator.this.hJS != null) {
                        if (!data.aDK || AlaMasterLiveRoomOpearator.this.bFX == null || !AlaMasterLiveRoomOpearator.this.hJX) {
                            if (AlaMasterLiveRoomOpearator.this.bFX != null && AlaMasterLiveRoomOpearator.this.bFX == data.aDJ) {
                                if (data.aDD != null && data.aDD.size() > 0) {
                                    if (!AlaMasterLiveRoomOpearator.this.hJX || AlaMasterLiveRoomOpearator.this.hIJ.getVisibility() == 0) {
                                        AlaMasterLiveRoomOpearator.this.hJS.c(AlaMasterLiveRoomOpearator.this.ccR().hDH.getVideoConfig());
                                        AlaMasterLiveRoomOpearator.this.bFZ = false;
                                    }
                                } else {
                                    Log.d("ArUpdate", "网络数据 滤镜为空");
                                    AlaMasterLiveRoomOpearator.this.ccR().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                                }
                                AlaMasterLiveRoomOpearator.this.bFX = null;
                            }
                        } else {
                            Log.d("ArUpdate", "点击请求——>返回本地数据 不弹面板");
                            AlaMasterLiveRoomOpearator.this.ccR().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                        }
                        AlaMasterLiveRoomOpearator.this.hJS.a(AlaMasterLiveRoomOpearator.this.ccR().hDH.getVideoConfig(), AlaMasterLiveRoomOpearator.this.bFZ);
                        if (!AlaMasterLiveRoomOpearator.this.bFZ) {
                            AlaMasterLiveRoomOpearator.this.bFZ = true;
                        }
                    }
                } else if (AlaMasterLiveRoomOpearator.this.bFY) {
                    AlaMasterLiveRoomOpearator.this.ccR().pageContext.showToast(a.h.sdk_filter_beauty_no_data);
                }
                AlaMasterLiveRoomOpearator.this.bFY = false;
            }
        }
    };
    private CustomMessageListener bGb = new CustomMessageListener(2913196) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2913196 && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.ccR().hDH != null && !TextUtils.isEmpty(str)) {
                    AlaMasterLiveRoomOpearator.this.ccR().hDH.setBeautyJsonPath(str);
                    Log.d("ArUpdate", "mUpdateFaceFileListener filePath:" + str);
                    com.baidu.live.d.xf().putString("beauty_face_feature", str);
                }
            }
        }
    };
    public CustomMessageListener bqe = new CustomMessageListener(2913193) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && AlaMasterLiveRoomOpearator.this.bsh == 6) {
                if (customResponsedMessage.getData() instanceof ImForbiddenStateData) {
                    ImForbiddenStateData imForbiddenStateData = (ImForbiddenStateData) customResponsedMessage.getData();
                    if (imForbiddenStateData.errno != 0) {
                        BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.ala_im_ban_no_net_tips));
                        return;
                    } else if (imForbiddenStateData.banState == 0) {
                        if (AlaMasterLiveRoomOpearator.this.bsh == 6) {
                            AlaMasterLiveRoomOpearator.this.chr();
                        }
                    } else {
                        AlaMasterLiveRoomOpearator.this.a(imForbiddenStateData);
                    }
                }
                AlaMasterLiveRoomOpearator.this.bsh = 0;
            }
        }
    };
    private View.OnClickListener hKi = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.hJn) {
                    AlaMasterLiveRoomOpearator.this.chx();
                    AlaMasterLiveRoomOpearator.this.hJy.show();
                } else if (view != AlaMasterLiveRoomOpearator.this.hJm) {
                    if (view == AlaMasterLiveRoomOpearator.this.hJo) {
                        AlaMasterLiveRoomOpearator.this.buI();
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "share_clk"));
                    } else if (view != AlaMasterLiveRoomOpearator.this.hJp) {
                        if (view != AlaMasterLiveRoomOpearator.this.hJr) {
                            if (view == AlaMasterLiveRoomOpearator.this.hwF) {
                                if (AlaMasterLiveRoomOpearator.this.chq()) {
                                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "pk_clk"));
                                    if (AlaMasterLiveRoomOpearator.this.hJT != null) {
                                        if ((AlaMasterLiveRoomOpearator.this.htI != null) && AlaMasterLiveRoomOpearator.this.htI.At()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                                            return;
                                        }
                                        if (AlaMasterLiveRoomOpearator.this.htI.Pl() & (AlaMasterLiveRoomOpearator.this.htI != null)) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hJT.ccT()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else if (AlaMasterLiveRoomOpearator.this.hJT.ccU()) {
                                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                                            return;
                                        } else {
                                            AlaMasterLiveRoomOpearator.this.hJT.ccV();
                                            return;
                                        }
                                    }
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hJq) {
                                if (AlaMasterLiveRoomOpearator.this.hIN != null) {
                                    aw cjB = AlaMasterLiveRoomOpearator.this.ccR().hDq.cjB();
                                    if (cjB == null || cjB.mLiveSdkInfo == null) {
                                        str = null;
                                        str2 = null;
                                    } else {
                                        str2 = String.valueOf(cjB.mLiveSdkInfo.mRoomId);
                                        str = cjB.mLiveSdkInfo.mCastIds != null ? cjB.mLiveSdkInfo.mCastIds.chatMCastId : null;
                                    }
                                    AlaMasterLiveRoomOpearator.this.hIN.ax("", str2, str);
                                    return;
                                }
                                return;
                            } else if (view == AlaMasterLiveRoomOpearator.this.hJs) {
                                UbcStatisticManager.getInstance().logSendRequest(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", UbcStatConstant.Value.VALUE_CHAT_LINK_CLICK));
                                if (AlaMasterLiveRoomOpearator.this.hJT.ccT() || AlaMasterLiveRoomOpearator.this.hJT.ccU() || AlaMasterLiveRoomOpearator.this.htI.Pl() || AlaMasterLiveRoomOpearator.this.htI.At()) {
                                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_chat_tip));
                                    return;
                                } else if (AlaMasterLiveRoomOpearator.this.hJU != null) {
                                    AlaMasterLiveRoomOpearator.this.hJU.VA();
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "sticker"));
                        if (AlaMasterLiveRoomOpearator.this.hJz != null) {
                            AlaMasterLiveRoomOpearator.this.hJz.QH();
                            AlaMasterLiveRoomOpearator.this.hJz.cV(AlaMasterLiveRoomOpearator.this.chF());
                        }
                    } else {
                        TiebaInitialize.log(new StatisticItem("c11984"));
                        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "beauty"));
                        AlaMasterLiveRoomOpearator.this.hJX = false;
                        AlaMasterLiveRoomOpearator.this.oz(true);
                        AlaMasterLiveRoomOpearator.this.hJt.setVisibility(4);
                        com.baidu.live.d.xf().putInt("beauty_new_bubble", 0);
                    }
                } else if (com.baidu.live.ae.a.Qm().bwx.aOF == 1 && !LoginManager.getInstance(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity()).isIMLogined()) {
                    BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.ala_forbidden_words_im_link_disconnect));
                } else if (com.baidu.live.ae.a.Qm().bwx.aOE == 1) {
                    if (!AlaMasterLiveRoomOpearator.this.bsd) {
                        AlaMasterLiveRoomOpearator.this.chr();
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913192));
                    AlaMasterLiveRoomOpearator.this.bsh = 6;
                } else {
                    AlaMasterLiveRoomOpearator.this.chr();
                }
            }
        }
    };
    private CustomMessageListener huA = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            String str;
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof ax) {
                    AlaMasterLiveRoomOpearator.this.huc = true;
                    AlaMasterLiveRoomOpearator.this.hJu = (ax) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.hto != null) {
                        AlaMasterLiveRoomOpearator.this.hto.Kg().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.hto != null) {
                        AlaMasterLiveRoomOpearator.this.hto.Kh().show();
                        String nameShow = aVar.getNameShow();
                        if (aVar.extInfoJson != null) {
                            if (aVar.extInfoJson.optInt("is_mysterious_man") == 1) {
                                str = aVar.extInfoJson.optString("mysterious_man_nickname");
                                if (TextUtils.isEmpty(str)) {
                                    str = "神秘人";
                                }
                                AlaMasterLiveRoomOpearator.this.hto.Kh().setEditText(" @" + str + " ");
                            }
                        }
                        str = nameShow;
                        AlaMasterLiveRoomOpearator.this.hto.Kh().setEditText(" @" + str + " ");
                    }
                    AlaMasterLiveRoomOpearator.this.vS(8);
                }
            }
        }
    };
    private CustomMessageListener hKj = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.ccR() != null && AlaMasterLiveRoomOpearator.this.ccR().hDN != null) {
                AlaMasterLiveRoomOpearator.this.ccR().hDN.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener bDB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.cin();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.ccR().hDq.vZ(i);
            }
        }
    };
    private CustomMessageListener hqK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.cig();
        }
    };
    private CustomMessageListener hfH = new CustomMessageListener(2913232) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.live.an.c)) {
                if (AlaMasterLiveRoomOpearator.this.bif == null) {
                    AlaMasterLiveRoomOpearator.this.bif = new com.baidu.live.an.a(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity());
                }
                AlaMasterLiveRoomOpearator.this.bif.a((com.baidu.live.an.c) customResponsedMessage.getData());
                return;
            }
            Log.e("commonWebPopListener", "@@ scheduler displayStandardWebPopListener data is error");
        }
    };
    public final HttpMessageListener hKk = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.Ov()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.hJy != null) {
                            AlaMasterLiveRoomOpearator.this.hJy.oF(!alaSetPrivateResponseMessage.isSwitchOpen());
                            AlaMasterLiveRoomOpearator.this.hJy.ciO();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.ccR().hDH.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.hJU != null) {
                        AlaMasterLiveRoomOpearator.this.hJU.setMute(AlaMasterLiveRoomOpearator.this.ccR().hDH.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hIZ != null) {
                        AlaMasterLiveRoomOpearator.this.hIZ.setMute(AlaMasterLiveRoomOpearator.this.ccR().hDH.isMute());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hIP != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.hIP.a(AlaMasterLiveRoomOpearator.this.ccR().hDK, AlaMasterLiveRoomOpearator.this.ccR().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.ccR().pageContext.getString(a.h.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.hIP.wi(2);
                        AlaMasterLiveRoomOpearator.this.hIP.a(AlaMasterLiveRoomOpearator.this.ccR().hDK, string, 3);
                    }
                }
            }
        }
    };
    private e.a hKl = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void ciu() {
            AlaMasterLiveRoomOpearator.this.vR(a.h.camera_open_failed_dialog_msg);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void civ() {
            AlaMasterLiveRoomOpearator.this.vR(a.h.audio_open_failed_dialog_msg);
        }
    };
    com.baidu.live.liveroom.a.a hKm = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
        @Override // com.baidu.live.liveroom.a.a
        public boolean dG(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void dH(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.ccR().bRl() == 1) {
                AlaMasterLiveRoomOpearator.this.ccR().hDH.stopRecord();
            }
        }
    };
    private IShareCallback hKn = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.hJE && AlaMasterLiveRoomOpearator.this.hJD != null) {
                AlaMasterLiveRoomOpearator.this.hJE = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.hJD);
            }
        }
    };
    private View.OnTouchListener hKo = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.ccR().hDN.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccR().hDr);
            AlaMasterLiveRoomOpearator.this.vS(0);
            if (AlaMasterLiveRoomOpearator.this.hto != null) {
                AlaMasterLiveRoomOpearator.this.hto.Kg().getView().setVisibility(0);
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaMasterLiveRoomOpearator.this.hto.Kh().getView().setVisibility(8);
                }
            }
            return false;
        }
    };
    private e.b hKp = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciw() {
            AlaMasterLiveRoomOpearator.this.chs();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void cix() {
            AlaMasterLiveRoomOpearator.this.hIq = AlaMasterLiveRoomOpearator.this.hIJ.ceF();
            AlaMasterLiveRoomOpearator.this.ccR().hDN.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccR().hDN.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.ccR().hDN.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hDB = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.ccR().bRl();
            dVar.title = AlaMasterLiveRoomOpearator.this.hIJ.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.hDC = AlaMasterLiveRoomOpearator.this.hIJ.ceG();
            dVar.hDF = AlaMasterLiveRoomOpearator.this.hIq;
            dVar.hDE = AlaMasterLiveRoomOpearator.this.hIJ.ceD();
            dVar.hDD = AlaMasterLiveRoomOpearator.this.hIJ.ceI();
            dVar.hDG = AlaMasterLiveRoomOpearator.this.hIJ.ceE();
            if (dVar.hDG) {
                if (AlaMasterLiveRoomOpearator.this.hIJ.ceJ()) {
                    AlaMasterLiveRoomOpearator.this.hJE = true;
                    AlaMasterLiveRoomOpearator.this.hJD = dVar;
                    AlaMasterLiveRoomOpearator.this.hIJ.ceK();
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
            AlaMasterLiveRoomOpearator.this.ccR().pageContext.showToast(a.h.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.ccR().g((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciy() {
            AlaMasterLiveRoomOpearator.this.hJX = true;
            AlaMasterLiveRoomOpearator.this.oz(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean ciz() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void ciA() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void d(com.baidu.tieba.ala.category.b.a aVar) {
            AlaMasterLiveRoomOpearator.this.c(aVar);
        }
    };
    private CustomMessageListener bnz = new CustomMessageListener(2913081) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!customResponsedMessage.hasError() && customResponsedMessage.getError() == 0) {
                AlaMasterLiveRoomOpearator.this.caH();
            }
        }
    };
    private com.baidu.live.liveroom.g.c hKq = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void Ng() {
            if (AlaMasterLiveRoomOpearator.this.hIN != null) {
                AlaMasterLiveRoomOpearator.this.hIN.oS(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void cI(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.hJz != null) {
                        AlaMasterLiveRoomOpearator.this.hJz.setStickerCanOperate(true);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.hJz != null) {
                    AlaMasterLiveRoomOpearator.this.hJz.setStickerCanOperate(false);
                }
                if (AlaMasterLiveRoomOpearator.this.hIN != null) {
                    AlaMasterLiveRoomOpearator.this.hIN.oS(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.htC != null) {
                    AlaMasterLiveRoomOpearator.this.htC.bD(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a hKr = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void ciG() {
            if (AlaMasterLiveRoomOpearator.this.hJl != null && AlaMasterLiveRoomOpearator.this.ccR().hDK.indexOfChild(AlaMasterLiveRoomOpearator.this.hJl) >= 0) {
                AlaMasterLiveRoomOpearator.this.ccR().hDK.removeView(AlaMasterLiveRoomOpearator.this.hJl);
                AlaMasterLiveRoomOpearator.this.hJl.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.hJl = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b hsO = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void v(View view, int i) {
            com.baidu.live.data.ab Fp;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.cim();
            } else if (i == 14 && (Fp = AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp()) != null && Fp.aJD != null && Fp.mLiveInfo != null && Fp.aJZ != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), Fp.aJD.userName, Long.toString(Fp.aJD.userId), Long.toString(Fp.aJD.charmCount), String.valueOf(Fp.mLiveInfo.group_id), String.valueOf(Fp.mLiveInfo.live_id), true, String.valueOf(Fp.aJD.userId), Long.toString(Fp.aJZ.userId), Fp.aJZ.userName, Fp.aJZ.portrait, AlaMasterLiveRoomOpearator.this.hsg.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(Fp.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.hsg.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a hKs = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
    };
    private g hKt = new g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.56
    };
    private Runnable hKu = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.60
        @Override // java.lang.Runnable
        public void run() {
            AlaMasterLiveRoomOpearator.this.cit();
        }
    };
    private HttpMessageListener gZt = new HttpMessageListener(1021137) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            GuardClubInfoHttpResponseMessage guardClubInfoHttpResponseMessage;
            if (httpResponsedMessage != null && !httpResponsedMessage.hasError() && (httpResponsedMessage instanceof GuardClubInfoHttpResponseMessage) && (guardClubInfoHttpResponseMessage = (GuardClubInfoHttpResponseMessage) httpResponsedMessage) != null && guardClubInfoHttpResponseMessage.getOrginalMessage().getTag() == AlaMasterLiveRoomOpearator.this.gQz && guardClubInfoHttpResponseMessage != null && guardClubInfoHttpResponseMessage.bky != null) {
                AlaMasterLiveRoomOpearator.this.bky = guardClubInfoHttpResponseMessage.bky;
            }
        }
    };
    HttpMessageListener gZL = new HttpMessageListener(1021231) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.62
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
                com.baidu.live.guardclub.a aVar = ((GuardClubInfoRenameResponseMessage) httpResponsedMessage).bky;
                if (aVar == null || AlaMasterLiveRoomOpearator.this.bky == null || AlaMasterLiveRoomOpearator.this.bky.id != aVar.id) {
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
    private ViewTreeObserver.OnGlobalLayoutListener globalListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.67
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Rect rect = new Rect();
            AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity().getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity());
            int[] screenFullSize = ViewCommonUtil.getScreenFullSize(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity());
            if (screenFullSize[1] - rect.bottom > screenFullSize[1] / 4 && !AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = true;
                TbadkCoreApplication.getInst().setKeyboardHeight(screenFullSize[1] - rect.bottom);
                Window window = AlaMasterLiveRoomOpearator.this.hav.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.gravity = 80;
                attributes.x = 0;
                attributes.y = 50;
                window.setAttributes(attributes);
            } else if (screenFullSize[1] - rect.height() <= statusBarHeight && AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen) {
                AlaMasterLiveRoomOpearator.this.mIsKeyboardOpen = false;
                Window window2 = AlaMasterLiveRoomOpearator.this.hav.getWindow();
                WindowManager.LayoutParams attributes2 = window2.getAttributes();
                attributes2.gravity = 17;
                attributes2.x = 0;
                attributes2.y = 0;
                window2.setAttributes(attributes2);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.b.axs);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        hIG = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    private void Ib(String str) {
        if (!TextUtils.isEmpty(str) && this.hJw != null) {
            View Lb = this.hJw.Lb();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            Lb.setLayoutParams(layoutParams);
            if (ccR().hDr.indexOfChild(Lb) >= 0) {
                ccR().hDr.removeView(Lb);
            }
            ccR().hDr.addView(Lb);
            this.hJw.hm(str);
            Lb.bringToFront();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(com.baidu.live.data.ab abVar) {
        if (abVar != null && abVar.mLiveInfo != null && com.baidu.live.ae.a.Qm().bwx != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(ccR().pageContext.getPageActivity(), String.valueOf(abVar.mLiveInfo.live_id), String.valueOf(abVar.mLiveInfo.user_id), com.baidu.live.ae.a.Qm().bwx.aOA, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HI(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccR().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(ccR().pageContext.getString(a.h.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.ae.a.Qm().bwx.aNS;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? ccR().pageContext.getPageActivity().getString(a.h.ala_go_feedback_txt) : ccR().pageContext.getPageActivity().getString(a.h.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(ccR().pageContext);
        bdAlertDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caH() {
        int i = ccR().hDq.Fp().aJD.isUegBlock;
        int i2 = ccR().hDq.Fp().aJD.isBlock;
        String str = ccR().hDq.Fp().aJD.userName;
        if (i > 0 || i2 > 0) {
            this.bsd = true;
            this.hto.a(true, i, i2, str);
            return;
        }
        this.bsd = false;
        this.hto.a(false, i, i2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImForbiddenStateData imForbiddenStateData) {
        String format;
        final Activity pageActivity = this.hwy.pageContext.getPageActivity();
        if (imForbiddenStateData.globalBan == 1) {
            if (imForbiddenStateData.foreverInfo != null && imForbiddenStateData.foreverInfo.bqT == 1) {
                format = pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_block);
            } else {
                format = String.format(pageActivity.getResources().getString(a.h.ala_forbidden_words_ueg_forever), imForbiddenStateData.foreverInfo.bqU);
            }
            BdAlertDialog bdAlertDialog = new BdAlertDialog(this.hwy.pageContext.getPageActivity());
            bdAlertDialog.setMessage(format);
            bdAlertDialog.setPositiveButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
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
            bdAlertDialog.setNegativeButton(pageActivity.getResources().getString(a.h.ala_forbidden_words_btn_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
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
            bdAlertDialog.create(this.hwy.pageContext);
            bdAlertDialog.setCanceledOnTouchOutside(false);
            bdAlertDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean chq() {
        if (this.hJU != null && this.hJU.VB()) {
            BdUtilHelper.showToast(this.hwy.pageContext.getPageActivity(), this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else if (this.hIZ != null && this.hIZ.Rp()) {
            BdUtilHelper.showToast(this.hwy.pageContext.getPageActivity(), this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_video_chat_no_pk_tip));
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chr() {
        if (this.hto != null) {
            this.hto.Kh().show();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "msg_clk"));
    }

    public void onPKPlayerFirstFrame() {
        if (this.hJT != null) {
            this.hJT.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chs() {
        if (ccR() != null && ccR().hDq != null) {
            ccR().hDq.cju();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.category.b.a aVar) {
        if (aVar != null && aVar.bTy() != null && aVar.bTz() != null) {
            ccR().hDq.ey(aVar.bTy().getId(), aVar.bTz().getId());
        }
    }

    public void b(short s) {
        if (this.hJS != null) {
            this.hJS.b(s);
        }
    }

    /* loaded from: classes10.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.hJG = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.hJG = false;
                }
                if (AlaMasterLiveRoomOpearator.this.hJH == 0) {
                    AlaMasterLiveRoomOpearator.this.hJH = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.hJI == 0) {
                    AlaMasterLiveRoomOpearator.this.hJI = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.hJJ = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (ccR() != null && ccR().hDL != null) {
            ccR().hDL.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(com.baidu.tieba.ala.liveroom.data.e eVar, String str) {
        this.hwy = eVar;
        this.hqz = str;
        this.hKd = new com.baidu.tieba.ala.liveroom.o.a(eVar.pageContext.getPageActivity());
    }

    protected com.baidu.tieba.ala.liveroom.data.e ccR() {
        return this.hwy;
    }

    public int a(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.hwG = fVar;
        this.hJF = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.hJF, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.hIP == null) {
            this.hIP = new com.baidu.tieba.ala.liveroom.tippop.a(this.hwy.pageContext, null);
        }
        registerListener();
        this.hrA = new com.baidu.live.i.a();
        chO();
        cht();
        chw();
        Long[] lArr = new Long[1];
        this.hJK = lArr[0] == null ? 0L : lArr[0].longValue();
        this.hJL = lArr[0] != null ? lArr[0].longValue() : 0L;
        ccR().hDr.setOnTouchListener(this.hKo);
        this.hIH = SharedPrefHelper.getInstance().getBoolean(hIG, false);
        this.hJa = new AlaLiveCountDownView(ccR().pageContext.getPageActivity());
        this.hJa.setCount(3);
        this.hJa.setTextColor(ccR().pageContext.getPageActivity().getResources().getColor(a.c.sdk_white_alpha60));
        this.hJa.setTextSize(ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds128));
        this.hJa.setTypeface(Typeface.DEFAULT_BOLD);
        this.hJa.setIncludeFontPadding(false);
        this.hJa.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void ciB() {
                if (AlaMasterLiveRoomOpearator.this.ccR().hDr != null) {
                    AlaMasterLiveRoomOpearator.this.ccR().hDr.removeView(AlaMasterLiveRoomOpearator.this.hJa);
                }
            }
        });
        return 1;
    }

    private void cht() {
        CustomResponsedMessage runTask;
        if (this.hIX == null && (runTask = MessageManager.getInstance().runTask(2913207, com.baidu.live.m.a.class, ccR().pageContext)) != null && runTask.getData() != null) {
            this.hIX = (com.baidu.live.m.a) runTask.getData();
            this.hIX.c(ccR().pageContext);
        }
    }

    private void chu() {
        CustomResponsedMessage runTask;
        if (this.hIY == null && (runTask = MessageManager.getInstance().runTask(2913298, com.baidu.live.guess.d.class, ccR().pageContext)) != null && runTask.getData() != null) {
            this.hIY = (com.baidu.live.guess.d) runTask.getData();
            this.hIY.register();
        }
    }

    private void chv() {
        CustomResponsedMessage runTask;
        if (chC() && this.hIZ == null && (runTask = MessageManager.getInstance().runTask(2913254, com.baidu.live.am.b.class, ccR().pageContext)) != null && runTask.getData() != null) {
            this.hIZ = (com.baidu.live.am.b) runTask.getData();
            if (ccR() != null && ccR().hDq != null && ccR().hDq.Fp() != null) {
                this.hIZ.setLiveShowData(ccR().hDq.Fp());
            }
            if (ccR() != null && ccR().hDH != null) {
                this.hIZ.J(ccR().hDH);
                this.hIZ.setMute(ccR().hDH.isMute());
            }
            if (this.hIZ != null && this.hJi != null) {
                this.hIZ.a(new com.baidu.live.am.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
                    @Override // com.baidu.live.am.a
                    public boolean Rr() {
                        if ((AlaMasterLiveRoomOpearator.this.htI != null) && AlaMasterLiveRoomOpearator.this.htI.At()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_pking_repeated_initiation_tips));
                            return false;
                        }
                        if ((AlaMasterLiveRoomOpearator.this.htI != null) & AlaMasterLiveRoomOpearator.this.htI.Pl()) {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_matching_repeated_initiation_tips));
                            return false;
                        } else if (AlaMasterLiveRoomOpearator.this.hJT == null || !AlaMasterLiveRoomOpearator.this.hJT.ccT()) {
                            if (AlaMasterLiveRoomOpearator.this.hJT == null || !AlaMasterLiveRoomOpearator.this.hJT.ccU()) {
                                return true;
                            }
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        } else {
                            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity().getResources().getString(a.h.sdk_challenge_pking_repeated_initiation_tips));
                            return false;
                        }
                    }
                });
                View enterView = this.hIZ.getEnterView();
                if (enterView != null) {
                    if (enterView.getParent() != null) {
                        ((ViewGroup) enterView.getParent()).removeView(enterView);
                    }
                    this.hJi.setVisibility(0);
                    this.hJi.addView(enterView);
                }
            }
            if (this.hIZ != null) {
                this.hIZ.Y(ccR().hDI);
            }
            if (this.hIZ != null && ccR().hDJ != null) {
                this.hIZ.a(ccR().hDJ);
            }
        }
    }

    private void chw() {
        View rootLayout;
        if (this.hIX != null && this.hJh != null && (rootLayout = this.hIX.cB(false).getRootLayout()) != null) {
            if (rootLayout.getParent() != null) {
                ((ViewGroup) rootLayout.getParent()).removeView(rootLayout);
            }
            this.hJh.addView(rootLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chx() {
        if (this.hJy == null) {
            this.hJy = new com.baidu.tieba.ala.liveroom.master.panel.b(ccR().pageContext.getPageActivity(), ccR().bRl() == 2);
            this.hJy.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oB(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccR().hDH.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oC(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccR().hDH.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oD(boolean z) {
                    AlaMasterLiveRoomOpearator.this.ccR().hDH.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.cil();
                    if (AlaMasterLiveRoomOpearator.this.hIP != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.hIP.a(AlaMasterLiveRoomOpearator.this.ccR().hDK, AlaMasterLiveRoomOpearator.this.ccR().pageContext.getString(a.h.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.hIP.a(AlaMasterLiveRoomOpearator.this.ccR().hDK, AlaMasterLiveRoomOpearator.this.ccR().pageContext.getString(a.h.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void oE(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.g(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciC() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.ccR().hDq != null && AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp() != null && AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.getLiveID());
                    }
                    if (AlaMasterLiveRoomOpearator.this.hJy != null) {
                        AlaMasterLiveRoomOpearator.this.hJy.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.d.a(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciD() {
                    if (AlaMasterLiveRoomOpearator.this.hJy != null) {
                        AlaMasterLiveRoomOpearator.this.hJy.dismiss();
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new i(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciE() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "redenvelope"));
                    if (AlaMasterLiveRoomOpearator.this.ccR() != null && AlaMasterLiveRoomOpearator.this.ccR().hDq != null && AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp() != null && AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new u(AlaMasterLiveRoomOpearator.this.ccR().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.hJy != null) {
                            AlaMasterLiveRoomOpearator.this.hJy.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ciF() {
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "wishlist"));
                    long j = (AlaMasterLiveRoomOpearator.this.ccR() == null || AlaMasterLiveRoomOpearator.this.ccR().hDq == null || AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp() == null || AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.ccR() != null && AlaMasterLiveRoomOpearator.this.ccR().hDq != null && AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp() != null && AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.hJy != null) {
                                        AlaMasterLiveRoomOpearator.this.hJy.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.hwy.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.hJy != null) {
                        AlaMasterLiveRoomOpearator.this.hJy.dismiss();
                    }
                }
            });
        }
        chy();
    }

    private void chy() {
        if (this.hJy != null) {
            boolean isBackCamera = ccR().hDH.isBackCamera();
            this.hJy.setIsBackCamera(ccR().hDH.isBackCamera());
            this.hJy.S(ccR().hDH.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = ccR().hDH.isPushMirror();
            if (this.hJP) {
                isPushMirror = cik() || isPushMirror;
                this.hJP = false;
            }
            this.hJy.T(isPushMirror, isBackCamera ? false : true);
            this.hJy.oF(ccR().hDH.isMute());
            this.hJy.ciO();
        }
    }

    public void chz() {
        if (this.hwG != null) {
            if (this.hwG.hDQ == null || this.hwG.hDQ.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.hJj == null) {
                        this.hJj = this.hwy.hDP.MG();
                        this.hwy.hDK.addView(this.hJj, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.hIJ == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (ccR().hDq != null && ccR().hDq.Fp() != null && ccR().hDq.Fp().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", ccR().hDq.Fp().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", ccR().hDq.Fp().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.hIJ = new d(ccR().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    ccR().hDN.prepareTime = System.currentTimeMillis();
                    ccR().hDK.addView(this.hIJ.getView(), layoutParams);
                    this.hIJ.a(this.hKn);
                }
                this.hIJ.oi(this.hDE);
                this.hIJ.a(this.hKp);
                this.hIJ.a(this.hKl);
                this.hIJ.a(ccR().hDH, ccR().bRl());
                this.hIJ.a(this.hIX);
                return;
            }
            this.hIq = this.hwG.hDQ.mLiveInfo.screen_direction == 2;
            if (this.hwG.hDQ.mLiveInfo.isAudioOnPrivate == 1) {
                ccR().hDH.setMute(true);
                if (this.hJU != null) {
                    this.hJU.setMute(ccR().hDH.isMute());
                }
                if (this.hIZ != null) {
                    this.hIZ.setMute(ccR().hDH.isMute());
                }
                if (this.hIP == null) {
                    this.hIP = new com.baidu.tieba.ala.liveroom.tippop.a(this.hwy.pageContext, null);
                }
                if (!this.hIP.wh(2)) {
                    this.hIP.a(ccR().hDK, ccR().pageContext.getString(a.h.ala_master_live_mute_open_tip), 2, 5000);
                }
            }
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.hDB = true;
            dVar.forumId = String.valueOf(this.hwG.hDQ.mLiveInfo.forum_id);
            dVar.forumName = this.hwG.hDQ.mLiveInfo.forum_name;
            dVar.liveType = this.hwG.hDQ.mLiveInfo.live_type;
            dVar.title = this.hwG.hDQ.mLiveInfo.getLiveTitle();
            dVar.clarity = this.hwG.hDQ.mLiveInfo.clarity;
            dVar.gameId = this.hwG.hDQ.mLiveInfo.game_id;
            dVar.gameName = this.hwG.hDQ.mLiveInfo.game_label;
            dVar.hDF = this.hwG.hDQ.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void chA() {
        if (this.hJS != null) {
            this.hJS.a(ccR().hDH.getVideoConfig(), false);
        }
        if (this.hIJ != null) {
            this.hIJ.oh(true);
        }
        if (ccR().hDH.hasBeauty() >= 0) {
            ccR().hDH.setBeauty(com.baidu.live.d.xf().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            ccR().hDP.G(this.hwy.hDH);
        } else if (this.hIJ != null) {
            this.hIJ.oh(true);
        }
        chN();
    }

    public void d(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.hJj != null && this.hJj.getParent() != null) {
                ((ViewGroup) this.hJj.getParent()).removeView(this.hJj);
                this.hJj = null;
            }
            ccR().hDr.setVisibility(0);
            this.hwy.hDP.a(ccR().hDr);
        } else {
            chV();
            cij();
            if (this.hKb != null) {
                this.hKb.setVisibility(0);
            }
            this.hIN = new com.baidu.tieba.ala.liveroom.v.a(ccR().pageContext, this.hKm);
            this.hIN.c(ccR().hDr, true);
            this.hIN.oS(true);
            if (this.hto != null && this.hto.Kg() != null) {
                this.hto.Kg().setNeedTopAlphaShade(true);
            }
        }
        ccR().hDH.setPushMirror(cik());
    }

    public void b(aw awVar) {
        boolean z;
        boolean z2 = false;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hwy.hDP.l(ccR().hDq.Fp());
        }
        if (!ccR().hDH.isBackground() && ccR().hDq.Fp() != null && ccR().hDq.Fp().mLiveInfo != null) {
            int startPush = ccR().hDH.startPush(ccR().hDq.Fp().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hwy.hDP.MH();
            }
            if (startPush != 0 && ccR().hDN != null) {
                ccR().hDN.errCode = 4;
                ccR().hDN.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (awVar != null && !awVar.Cx() && !cih()) {
                oA(true);
                cii();
            }
            if (this.hsd != null) {
                this.hsd.N(ccR().hDq.Fp());
            }
            if (this.hsZ != null) {
                this.hsZ.a(ccR().hDq.Fp());
            }
            if (this.hIX != null) {
                this.hIX.h(ccR().hDq.Fp());
                this.hIX.hp(this.otherParams);
            }
            if (this.hsd != null) {
                this.hsd.ou(true);
            }
            if (this.hIK != null) {
                this.hIK.N(ccR().hDq.Fp());
            }
            if (awVar == null || awVar.aJD == null) {
                z = com.baidu.live.d.xf().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = awVar.aJD.canUseChallenge;
                com.baidu.live.d.xf().putBoolean("ala_master_can_use_challenge", z);
            }
            cbE();
            chW();
            chG();
            oy(z);
            car();
            chX();
            cid();
            O(ccR().hDq.Fp());
            f(ccR().hDq.Fp());
            cie();
            chB();
            cia();
            cbz();
            caq();
            cbB();
            cap();
            cib();
            cbu();
            cbv();
            chT();
            chU();
            P(ccR().hDq.Fp());
            cic();
            cby();
            cbl();
            Q(ccR().hDq.Fp());
            chu();
            MessageManager.getInstance().registerListener(this.gZt);
            MessageManager.getInstance().registerListener(this.gZL);
            aw cjB = ccR().hDq.cjB();
            if (cjB != null && cjB.aPK == 1) {
                bVG();
                this.hJY.postDelayed(this.hKu, IMConnection.RETRY_DELAY_TIMES);
            }
            if (this.htn != null) {
                this.htn.g(ccR().hDq.Fp());
            }
            if (this.hto != null) {
                if (ccR().hDq.Fp() != null && ccR().hDq.Fp().aKr != null && ccR().hDq.Fp().aKr.Bi()) {
                    z2 = true;
                }
                this.hto.a(String.valueOf(ccR().hDq.Fp().mLiveInfo.group_id), String.valueOf(ccR().hDq.Fp().mLiveInfo.last_msg_id), String.valueOf(ccR().hDq.Fp().aJD.userId), String.valueOf(ccR().hDq.Fp().mLiveInfo.live_id), ccR().hDq.Fp().aJD.appId, z2, ccR().hDq.Fp().getGuardName());
            }
            if (this.htp != null) {
                this.htp.a(ccR().hDq.Fp(), true);
            }
            chD();
            chv();
            cbI();
            this.mHandler.post(this.hKe);
            if (this.hKd != null && !this.hKd.hMI) {
                this.hKd.cjS();
            }
        }
    }

    protected void cbI() {
        if (this.htU == null && ccR() != null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913256, com.baidu.live.s.a.class, ccR().pageContext.getPageActivity());
            if (runTask.getData() != null) {
                this.htU = (com.baidu.live.s.a) runTask.getData();
                this.htU.p(ccR().hDr);
            }
        }
    }

    private void chB() {
        if (this.hIL != null && ccR() != null && ccR().hDq != null) {
            if (this.hIL.aG(this.hJe)) {
                this.hIL.C(ccR().hDq.Fp());
            } else {
                this.hIL.d(this.hJe, ccR().hDq.Fp());
            }
        }
    }

    private void car() {
        if (this.bAa == null) {
            this.bAa = new PendantParentView(ccR().pageContext.getPageActivity(), ccn());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(12);
            ccR().hDr.addView(this.bAa, layoutParams);
            this.bAa.setDefaultItemMargin(ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20));
            this.bAa.setPadding(ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds20), 0, ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds6), 0);
            ccm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccm() {
        if (this.bAa != null) {
            int dimensionPixelSize = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds278);
            int dimensionPixelSize2 = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds102);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bAa.getLayoutParams();
            if (this.gSo) {
                this.bAa.setPosition(0, 0, this.hJT.ccy(), dimensionPixelSize2);
            } else {
                this.bAa.setPosition(dimensionPixelSize, 0, ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds380), dimensionPixelSize2);
            }
            this.bAa.setLayoutParams(layoutParams);
            this.bAa.setModel(ccn());
        }
    }

    private PendantParentView.Model ccn() {
        if (this.gSo) {
            return PendantParentView.Model.VERTICAL_PK;
        }
        if (this.hJZ) {
            return PendantParentView.Model.VERTICAL_BB_CHATING;
        }
        return PendantParentView.Model.VERTICAL;
    }

    private void cco() {
        if (this.hto != null && this.hto.Kg() != null && this.hto.Kg().getView() != null) {
            if (this.gSo && !this.hII && ccR().hDr != null && ccR().hDr.getHeight() > 0) {
                int bp = this.hJT != null ? this.hJT.bp(true) : 0;
                ViewGroup.LayoutParams layoutParams = this.hto.Kg().getView().getLayoutParams();
                int height = ccR().hDr.getHeight() - bp;
                int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? height - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
                if (layoutParams != null) {
                    layoutParams.height = i;
                    this.hto.Kg().getView().setLayoutParams(layoutParams);
                    return;
                }
                return;
            }
            int j = com.baidu.live.aj.c.j(false, this.hII);
            if (ccR().hDr.indexOfChild(this.hto.Kg().getView()) != -1 && this.hto.Kg().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hto.Kg().getView().getLayoutParams();
                layoutParams2.height = j;
                this.hto.Kg().getView().setLayoutParams(layoutParams2);
            }
            this.hto.Kg().Kf();
        }
    }

    private void ccp() {
        if (this.htq != null) {
            if (this.gSo && !this.hII && ccR().hDr != null && ccR().hDr.getHeight() > 0) {
                this.htq.cI((ccR().hDr.getHeight() - (this.hJT != null ? h.p(ccR().pageContext.getPageActivity(), true) : 0)) + ccR().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height));
            } else {
                this.htq.cI(com.baidu.live.aj.a.a(ccR().pageContext.getPageActivity(), true, false, this.hII));
            }
        }
    }

    private void ccq() {
        int i;
        if (this.htq != null) {
            int i2 = com.baidu.live.aj.a.i(true, false);
            if (!this.gSo || ccR().hDr == null || ccR().hDr.getHeight() <= 0) {
                i = i2;
            } else {
                i = (ccR().hDr.getHeight() - (this.hJT != null ? this.hJT.bp(false) : 0)) + ccR().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_im_entereffect_height);
            }
            this.htq.cJ(i);
        }
    }

    private void ccr() {
        if (this.htp != null && this.htp.zS() != null) {
            ViewGroup.LayoutParams layoutParams = this.htp.zS().getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = ccR().pageContext.getResources().getDimensionPixelOffset(this.gSo ? a.d.sdk_ds100 : a.d.sdk_ds20);
                this.htp.zS().setLayoutParams(layoutParams);
            }
        }
    }

    private boolean chC() {
        AlaVideoBCChatData alaVideoBCChatData;
        AlaLiveInfoData alaLiveInfoData = ccR().hDq.Fp().mLiveInfo;
        if (alaLiveInfoData == null || (alaVideoBCChatData = alaLiveInfoData.videoBCEnterData) == null) {
            return false;
        }
        return alaVideoBCChatData.isShowEnter();
    }

    private void chD() {
        if (this.hIZ == null && !chC()) {
            boolean z = (ccR().hDq == null || ccR().hDq.cjB() == null || ccR().hDq.cjB().mLiveInfo.videoBBChatData == null || !ccR().hDq.cjB().mLiveInfo.videoBBChatData.videoBBChatSwitch) ? false : true;
            if (!z && ccR().hDq != null && ccR().hDq.Fp() != null && ccR().hDq.Fp().mLiveInfo != null && ccR().hDq.Fp().mLiveInfo.videoBBChatData != null && ccR().hDq.Fp().aKn) {
                z = ccR().hDq.Fp().mLiveInfo.videoBBChatData.videoBBChatSwitch;
            }
            if (this.hJs != null) {
                this.hJs.setVisibility(z ? 0 : 8);
            }
            chE();
        }
    }

    private void chE() {
        CustomResponsedMessage runTask;
        if (this.hJU == null && (runTask = MessageManager.getInstance().runTask(2913249, com.baidu.live.al.a.class, ccR().pageContext)) != null && runTask.getData() != null) {
            this.hJU = (com.baidu.live.al.a) runTask.getData();
        }
        if (this.hJU != null) {
            this.hJU.w((ViewGroup) ccR().rootView.findViewById(a.f.ala_live_video_chat_pendant));
            this.hJU.v(ccR().hDK);
            this.hJU.t(ccR().hDq.Fp());
            this.hJU.J(ccR().hDH);
            this.hJU.a(ccR().hDJ);
            this.hJU.a(this.bPD);
            if (ccR().hDH != null) {
                this.hJU.setMute(ccR().hDH.isMute());
            }
        }
    }

    private void oy(boolean z) {
        if (this.hJT == null) {
            this.hJT = new com.baidu.tieba.ala.liveroom.challenge.e(ccR());
        }
        this.hJT.a(this.hwF, this.hwG, z);
        this.hJT.a(new com.baidu.tieba.ala.liveroom.challenge.d() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void a(bg bgVar, bk bkVar, bk bkVar2) {
                AlaMasterLiveRoomOpearator.this.gSo = true;
                AlaMasterLiveRoomOpearator.this.ccR().hDr.hTf = false;
                if (AlaMasterLiveRoomOpearator.this.hJz != null) {
                    AlaMasterLiveRoomOpearator.this.hJz.dZ(4);
                    AlaMasterLiveRoomOpearator.this.hJz.cV(true);
                }
                AlaMasterLiveRoomOpearator.this.Xh();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void Az() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hKe);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccP() {
                AlaMasterLiveRoomOpearator.this.gSo = false;
                AlaMasterLiveRoomOpearator.this.ccR().hDr.hTf = false;
                if (AlaMasterLiveRoomOpearator.this.hJz != null) {
                    AlaMasterLiveRoomOpearator.this.hJz.dZ(0);
                    AlaMasterLiveRoomOpearator.this.hJz.cV(false);
                }
                AlaMasterLiveRoomOpearator.this.ccx();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.d
            public void ccQ() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.hKe);
            }
        });
        this.hJT.P(this.hIq, z);
        this.hJT.k(this.hIq, z, (this.hwG == null || this.hwG.hDQ == null || this.hwG.hDQ.mChallengeData == null) ? false : true);
    }

    public boolean chF() {
        return this.hJT != null && this.hJT.ccY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xh() {
        if (this.hIO != null) {
            this.hIO.setVisible(8);
            this.hIO.setCanVisible(false);
        }
        if (this.hJV != null) {
            this.hJV.setCanVisible(false);
            this.hJV.refreshUI();
        }
        if (this.hIL != null) {
            this.hIL.setVisibility(8);
        }
        if (this.hsi != null) {
            this.hsi.aW(true);
        }
        if (this.hJb != null) {
            this.hJb.setCanVisible(false);
            this.hJb.setVisibility(8);
        }
        if (this.hIN != null) {
            this.hJk = this.hIN.clY();
            this.hIN.oR(false);
        }
        if (this.htI != null) {
            this.htI.setCanVisible(false);
        }
        if (this.htJ != null) {
            this.htJ.aW(true);
            this.htJ.aX(true);
        }
        ccm();
        cco();
        ccp();
        ccq();
        ccr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccx() {
        if (this.hIO != null) {
            this.hIO.setCanVisible(true);
        }
        if (this.hJV != null) {
            this.hJV.setCanVisible(true);
            this.hJV.refreshUI();
        }
        if (this.hIL != null) {
            this.hIL.setVisibility(0);
        }
        if (this.hsi != null) {
            this.hsi.aW(false);
        }
        if (this.hJb != null) {
            this.hJb.setCanVisible(true);
            if (this.hJb.clv()) {
                this.hJb.setVisibility(0);
            }
        }
        if (this.hIN != null) {
            this.hIN.oR(this.hJk);
        }
        if (this.htI != null) {
            this.htI.setCanVisible(true);
        }
        if (this.htJ != null) {
            this.htJ.aW(false);
            this.htJ.aX(false);
        }
        ccm();
        cco();
        ccp();
        ccq();
        ccr();
    }

    private void chG() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.leftMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        if (this.hJb == null) {
            this.hJb = new AlaLiveStreamStatusView(ccR().pageContext.getPageActivity());
            this.hJb.setVisibility(8);
        }
        this.hJb.setId(a.f.ala_live_room_stream_view);
        this.hJb.setLayoutParams(layoutParams);
        if (this.hJb.getParent() == null && this.hJe != null) {
            this.hJe.addView(this.hJb, layoutParams);
        }
    }

    public void chH() {
        if (this.hIJ != null && this.hIJ.getVisibility() != 8 && ccR().hDH.getPreview() != null) {
            ccR().hDH.stopRecord();
        }
    }

    public void chI() {
        if (ccR().hDH.getPreview() != null) {
            ccR().hDH.stopRecord();
        }
    }

    public void l(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.hJS != null) {
                this.hJS.og(false);
            }
            this.hJS = new com.baidu.tieba.ala.liveroom.g.b(ccR().hDK, ccR(), ccR().hDH);
            this.hJS.a(ccR().hDH.getVideoConfig(), false);
        }
        if (this.hIP != null) {
            this.hIP.ckS();
        }
        this.mHandler.post(this.hKe);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.hII = z;
        if (z) {
            if (this.hJR) {
                this.hJR = false;
                if (this.hto != null && this.hto.Kg() != null) {
                    this.hto.Kg().getView().setBottom(0);
                }
                if (this.hto != null && this.hto.Kh() != null) {
                    this.hto.Kh().getView().setBottom(0);
                }
            }
            if (this.htq != null && this.htq.EM() != null) {
                this.htq.EM().setVisibility(8);
            }
            if (this.hto != null && this.hto.Kg() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hto.Kg().getView().getLayoutParams();
                layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight() + ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132);
                this.hto.Kg().getView().setLayoutParams(layoutParams);
            }
            if (this.hto != null && this.hto.Kh() != null && this.hto.Kh().getView() != null && this.hto.Kh().getView().getVisibility() == 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.hto.Kh().getView().getLayoutParams();
                layoutParams2.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                this.hto.Kh().getView().setLayoutParams(layoutParams2);
                this.hto.Kh().getView().setVisibility(0);
                this.hto.Kh().Mj();
            }
            vS(8);
            vQ(8);
            if (this.htr != null && this.htr.Fo() != null) {
                this.htr.Fo().setVisibility(8);
            }
            if (this.htJ != null) {
                this.htJ.setCanVisible(false);
            }
        } else {
            if (this.htq != null && this.htq.EM() != null) {
                this.htq.EM().setVisibility(0);
            }
            if (this.hto != null && this.hto.Kg() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.hto.Kg().getView().getLayoutParams();
                layoutParams3.bottomMargin = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds132) - ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16);
                this.hto.Kg().getView().setLayoutParams(layoutParams3);
            }
            if (this.hto != null && this.hto.Kh() != null) {
                this.hto.Kh().hide();
            }
            vS(0);
            vQ(0);
            if (this.htr != null && this.htr.Fo() != null) {
                this.htr.Fo().setVisibility(0);
            }
            if (this.hJw != null && this.hJw.Lb() != null) {
                this.hJw.Lb().setVisibility(0);
            }
            if (this.htJ != null) {
                this.htJ.setCanVisible(true);
            }
        }
        if (this.hIJ != null) {
            this.hIJ.R(false, z);
        }
        if (this.htp != null) {
            this.htp.zT();
        }
        if (this.hJz != null) {
            this.hJz.onKeyboardVisibilityChanged(z);
        }
        if (this.htU != null) {
            this.htU.onKeyboardVisibilityChanged(z);
        }
        if (this.hJU != null) {
            this.hJU.onKeyboardVisibilityChanged(z);
        }
        cco();
        this.mHandler.post(this.hKe);
    }

    private void vQ(int i) {
        if (this.hsd != null) {
            this.hsd.vE(i);
        }
        if (this.hJd != null) {
            this.hJd.setVisibility(i);
        }
        if (this.hsZ != null) {
            this.hsZ.getView().setVisibility(i);
        }
        if (this.hIM != null) {
            this.hIM.setVisible(i);
        }
        if (this.hIL != null) {
            this.hIL.setVisibility(i);
        }
        if (this.hsi != null) {
            this.hsi.setVisible(i);
        }
        if (this.htQ != null) {
            this.htQ.setCanVisible(i == 0);
        }
        if (this.htL != null) {
            this.htL.setVisible(i);
        }
        if (this.htG != null) {
            this.htG.setCanVisible(i == 0);
        }
        if (this.htI != null) {
            this.htI.setCanVisible(i == 0 && !this.gSo);
        }
        if (this.hsp != null) {
            this.hsp.cT(i == 0);
        }
        if (this.hJV != null) {
            this.hJV.setCanVisible(i == 0);
            this.hJV.refreshUI();
        }
        if (this.hJe != null) {
            this.hJe.setVisibility(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            ccR().hDN.errCode = 1;
            vR(a.h.camera_open_failed_dialog_msg);
        } else if (i == -5) {
            vR(a.h.camera_open_failed_dialog_msg);
        } else if (i == -6) {
            vR(a.h.stream_upload_exception);
        } else if (i == -2) {
            Ic(ccR().pageContext.getResources().getString(a.h.preview_init_failed_dialog_msg));
            ccR().hDH.stopRecord();
        } else if (i == -3 && this.hIJ != null) {
            this.hIJ.oh(false);
        }
        if (i == -4) {
            if (this.hIJ == null || this.hIJ.getView().getParent() == null) {
                ccR().g((short) 1);
                return;
            }
            this.hIJ.ceH();
            this.hJp.setVisibility(0);
            if (this.hIN != null) {
                this.hIN.oS(true);
            }
            ccR().hDr.setBackgroundColor(ccR().pageContext.getResources().getColor(17170445));
            ciq();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        awr();
        if (i == 12001) {
            if (i2 == -1) {
                Id(P(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                Q(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            buI();
        }
    }

    public void onResume() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.hIJ == null || this.hIJ.getView().getParent() == null || this.hIJ.getVisibility() != 0 ? "live" : "action");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1429, "access", UbcStatConstant.Page.LIVE_ACTION, "").setContentExt(jSONObject));
        if (this.hIJ != null) {
            this.hIJ.onResume();
        }
        if (this.hJE && this.hJD != null) {
            this.hJE = false;
            c(this.hJD);
        }
        if (this.htC != null) {
            this.htC.onResume();
        }
    }

    public void h(short s) {
        if (this.htn != null) {
            this.htn.FB();
        }
        if (this.hto != null) {
            this.hto.a(null);
            this.hto.zU();
        }
        if (this.htp != null) {
            this.htp.zU();
        }
        if (this.hJT != null) {
            this.hJT.ccX();
        }
        if (this.hJW != null) {
            this.hJW.Jc();
        }
        if (this.hIY != null) {
            this.hIY.unRegister();
        }
    }

    public boolean chJ() {
        com.baidu.live.data.ab Fp = ccR().hDq.Fp();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hwy.hDP.k(Fp);
            if (Fp != null && Fp.mLiveInfo.live_status != 1) {
                cio();
                ccR().pageContext.getPageActivity().finish();
                if (ccR().hDq == null || ccR().hDq.Fp() == null) {
                    return true;
                }
                a(Fp, 1, ccR().hDq.cjK() != 1 ? ccR().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                return true;
            }
        } else {
            if (this.hto != null) {
                this.hto.Kg().a(String.valueOf(Fp.mLiveInfo.group_id), String.valueOf(Fp.mLiveInfo.live_id), true, String.valueOf(Fp.aJD.userId), Fp.getGuardName());
            }
            if (this.htp != null) {
                this.htp.a(Fp);
            }
            if (this.hsZ != null) {
                this.hsZ.a(ccR().hDq.Fp());
            }
            if (this.hsd != null) {
                this.hsd.N(Fp);
            }
            if (Fp != null) {
                if (this.hJT != null) {
                    this.hJT.a(Fp);
                }
                if (this.htr != null && Fp.mLiveInfo != null) {
                    this.htr.a(Fp.mLiveInfo, Fp.aJD);
                }
                if (this.htQ != null) {
                    this.huh = this.htQ.p(Fp);
                }
                if (this.hsi != null) {
                    this.hsi.nI(this.huh);
                    this.hsi.j(Fp);
                    this.hsi.updateView();
                }
                if (this.htG != null) {
                    this.htG.a(Fp);
                }
                if (this.htI != null) {
                    this.htI.a(Fp);
                }
                if (this.htH != null) {
                    this.htH.a(Fp);
                }
                if (this.hIW != null) {
                    this.hIW.a(Fp);
                }
                if (this.htJ != null) {
                    this.htJ.a(Fp);
                }
                if (this.htK != null) {
                    this.htK.a(Fp);
                }
                if (this.htL != null) {
                    this.htL.a(Fp);
                }
                if (Fp.mLiveInfo.live_status != 1) {
                    cio();
                    ccR().pageContext.getPageActivity().finish();
                    if (ccR().hDq == null || ccR().hDq.Fp() == null) {
                        return true;
                    }
                    a(Fp, 1, ccR().hDq.cjK() != 1 ? ccR().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                    return true;
                } else if (this.hIX != null) {
                    this.hIX.i(Fp);
                }
            }
        }
        return false;
    }

    public void chK() {
        chy();
    }

    public void chL() {
        if (this.hJS != null) {
            this.hJS.ceB();
        }
        if (this.hJU != null) {
            this.hJU.VD();
        }
    }

    public void chM() {
        if (this.hIJ != null && this.hIJ.getVisibility() != 8) {
            if (ccR().bRl() == 2) {
                ciq();
            } else {
                cip();
            }
        }
        if (this.hIJ != null && this.hIJ.getVisibility() != 8) {
            if (ccR().bRl() == 1) {
                this.hIJ.onResume();
            }
            this.hIJ.onRefresh();
        }
        if (this.hIX != null) {
            this.hIX.onResume();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.huc && this.hJu != null) {
            if (this.hto != null) {
                this.hto.Kg().getView().setVisibility(0);
            }
            if (this.hto != null) {
                this.hto.Kh().show();
                String nameShow = this.hJu.getNameShow();
                if (this.hJu.extInfoJson != null) {
                    if (this.hJu.extInfoJson.optInt("is_mysterious_man") == 1) {
                        nameShow = this.hJu.extInfoJson.optString("mysterious_man_nickname");
                        if (TextUtils.isEmpty(nameShow)) {
                            nameShow = "神秘人";
                        }
                    }
                }
                this.hto.Kh().setEditText(" @" + nameShow + " ");
            }
            vS(8);
            this.huc = false;
        }
        if (this.bif != null) {
            this.bif.resume();
        }
        if (this.hJU != null) {
            this.hJU.VE();
        }
    }

    public void onPause() {
        if (this.hIX != null) {
            this.hIX.onPause();
        }
        if (this.htC != null) {
            this.htC.onPause();
        }
        if (this.bif != null) {
            this.bif.pause();
        }
    }

    private void chN() {
        if (bt.c(com.baidu.live.ae.a.Qm().bCs)) {
            this.hJp.setVisibility(0);
            this.hJp.setAlpha(0.2f);
        } else if (ccR().hDH.hasBeauty() < 0) {
            this.hJp.setVisibility(8);
        } else {
            this.hJp.setVisibility(0);
        }
    }

    private void chO() {
        this.hJc = (RelativeLayout) ccR().rootView.findViewById(a.f.ala_live_unremovable_container);
        this.hJf = (RelativeLayout) ccR().rootView.findViewById(a.f.under_live_view_panel);
        this.hJg = (RelativeLayout) ccR().rootView.findViewById(a.f.over_live_view_panel);
        this.hJh = (FrameLayout) ccR().rootView.findViewById(a.f.goods_parent);
        this.hJi = (FrameLayout) ccR().rootView.findViewById(a.f.ala_live_bc_chat_container);
        this.hwy.hDr.setOnLiveViewScrollListener(this.hKq);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hJf.setVisibility(8);
            this.hJg.setVisibility(8);
            ccR().hDr.removeAllViews();
            return;
        }
        this.hJd = (RelativeLayout) ccR().rootView.findViewById(a.f.ala_live_removeable_top_container);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hJd.getLayoutParams();
        layoutParams.topMargin = this.hwy.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds12);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            layoutParams.topMargin = UtilHelper.getStatusBarHeight();
        }
        this.hJd.setLayoutParams(layoutParams);
        this.hJe = (RelativeLayout) ccR().rootView.findViewById(a.f.ala_live_top_pendant_container);
        if (this.hsg == null) {
            this.hsg = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.hwy.pageContext.getPageActivity(), true);
        }
        this.hsg.a(this.hsO);
        this.hsg.a(this.hJd, a.f.ala_live_room_host_header_stub, 1L);
        this.hsg.setVisible(0);
        chP();
        this.hJp = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn);
        this.hJt = (TextView) ccR().rootView.findViewById(a.f.ala_liveroom_host_beauty_btn_num);
        this.hJp.setOnClickListener(this.hKi);
        this.hJr = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_paster);
        this.hJr.setOnClickListener(this.hKi);
        if (com.baidu.live.ae.a.Qm().bCs != null && com.baidu.live.ae.a.Qm().bCs.aRk != null && com.baidu.live.ae.a.Qm().bCs.aRk.CC() && bt.b(com.baidu.live.ae.a.Qm().bCs)) {
            this.hJr.setVisibility(0);
        } else {
            this.hJr.setVisibility(8);
        }
        chN();
        this.hJo = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_share_btn);
        this.hJo.setOnClickListener(this.hKi);
        this.hJm = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_message_btn);
        this.hJm.setOnClickListener(this.hKi);
        this.hwF = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_pk_btn);
        this.hwF.setOnClickListener(this.hKi);
        this.hJs = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_vedio_chat);
        this.hJs.setOnClickListener(this.hKi);
        this.hJn = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_more);
        this.hJn.setOnClickListener(this.hKi);
        this.hJq = (ImageView) ccR().rootView.findViewById(a.f.ala_liveroom_host_zan_btn);
        this.hJq.setOnClickListener(this.hKi);
        chS();
        if (bt.b(com.baidu.live.ae.a.Qm().bCs)) {
            this.hJS = new com.baidu.tieba.ala.liveroom.g.b(ccR().hDK, ccR(), ccR().hDH);
        }
        this.htn = new m();
        chQ();
        chR();
        if (com.baidu.live.d.xf().getInt("beauty_new_bubble", 1) == 1) {
            this.hJt.setVisibility(0);
        }
    }

    private void chP() {
        this.hKb = (FrameLayout) View.inflate(ccR().pageContext.getPageActivity(), a.g.ala_live_room_top_pure_layout_hk, null);
        if ((TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo() || TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isMobileBaidu()) && this.hKb != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds12) + UtilHelper.getStatusBarHeight();
            } else {
                layoutParams.topMargin = ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds25);
            }
            layoutParams.addRule(11);
            this.hKb.setVisibility(8);
            if (this.hKb.getParent() != null && (this.hKb.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.hKb.getParent()).removeView(this.hKb);
            }
            this.hJc.addView(this.hKb, layoutParams);
            if (this.hKb != null) {
                this.hKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        AlaMasterLiveRoomOpearator.this.hsO.v(AlaMasterLiveRoomOpearator.this.hKb, 8);
                    }
                });
            }
        }
    }

    private void chQ() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, k.class, ccR().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.hto = (k) runTask.getData();
            this.hto.setFromMaster(true);
            this.hto.Kg().getView().setId(a.f.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(ccR().pageContext.getPageActivity()) * 0.75f), com.baidu.live.aj.c.j(false, false));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = com.baidu.live.aj.c.dr(true);
            ccR().hDr.addView(this.hto.Kg().getView(), layoutParams);
            this.hto.Kh().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            ccR().hDr.addView(this.hto.Kh().getView(), layoutParams2);
            this.hto.a(new k.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                @Override // com.baidu.live.im.k.a
                public boolean Kk() {
                    return true;
                }

                @Override // com.baidu.live.im.k.a
                public void Kl() {
                }

                @Override // com.baidu.live.im.k.a
                public void hh(String str) {
                }

                @Override // com.baidu.live.im.k.a
                public void Km() {
                }

                @Override // com.baidu.live.im.k.a
                public void Kn() {
                }

                @Override // com.baidu.live.im.k.a
                public void Ko() {
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kp() {
                    return false;
                }

                @Override // com.baidu.live.im.k.a
                public int Kq() {
                    return 0;
                }

                @Override // com.baidu.live.im.k.a
                public boolean Kr() {
                    return false;
                }
            });
        }
    }

    private void chR() {
        View zS;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, com.baidu.live.im.b.a.class, ccR().pageContext);
        if (runTask != null) {
            this.htp = (com.baidu.live.im.b.a) runTask.getData();
        }
        if (this.htp != null && (zS = this.htp.zS()) != null && this.hwy.hDr.indexOfChild(zS) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.hwy.pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds98));
            layoutParams.addRule(2, a.f.ala_liveroom_msg_list);
            layoutParams.bottomMargin = ccR().pageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds20);
            ccR().hDr.addView(zS, layoutParams);
        }
    }

    private void chS() {
        CustomResponsedMessage runTask;
        if (this.hJx == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.ag.a.class, ccR().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hJx = (com.baidu.live.ag.a) runTask.getData();
        }
    }

    private void chT() {
        View EL;
        ac.e(ccR().hDq.Fp());
        ac.b(ccR().pageContext, true, false);
        ac.Fw();
        if (this.htq == null) {
            com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
            fVar.aWN = true;
            fVar.context = ccR().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, ad.class, fVar);
            if (runTask != null && runTask.getData() != null) {
                this.htq = (ad) runTask.getData();
                if (this.htq != null && (EL = this.htq.EL()) != null && ccR().hDr.indexOfChild(EL) < 0) {
                    if (EL.getParent() instanceof ViewGroup) {
                        ((ViewGroup) EL.getParent()).removeView(EL);
                    }
                    ccR().hDr.addView(EL, ccR().hDr.getLayoutParams());
                }
            }
        }
    }

    private void chU() {
        if (!this.hKc) {
            this.hKc = true;
            com.baidu.live.entereffect.a.CY().by(true);
        }
    }

    protected void cbv() {
        View Fo;
        if (this.htr == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.aWN = true;
            aVar.context = ccR().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, ab.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.htr = (ab) runTask.getData();
            }
        }
        if (this.htr != null && (Fo = this.htr.Fo()) != null && this.hJe != null) {
            if (this.hJe.indexOfChild(Fo) < 0) {
                if (Fo.getParent() instanceof ViewGroup) {
                    ((ViewGroup) Fo.getParent()).removeView(Fo);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                if (this.hIM != null && this.hIM.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
                    layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.htL != null && this.htL.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else if (this.htK != null && this.htK.isShowing()) {
                    layoutParams.addRule(3, a.f.ala_rank_level_entry);
                    layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
                } else {
                    layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds66);
                }
                this.hJe.addView(Fo, layoutParams);
            }
            Fo.bringToFront();
        }
    }

    protected void cbu() {
        View FC;
        if (this.htC == null) {
            ak akVar = new ak();
            akVar.aWN = true;
            akVar.pageContext = ccR().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, ag.class, akVar);
            if (runTask != null && runTask.getData() != null) {
                this.htC = (ag) runTask.getData();
            }
        }
        if (this.htC != null && (FC = this.htC.FC()) != null && ccR().hDr.indexOfChild(FC) < 0) {
            if (FC.getParent() instanceof ViewGroup) {
                ((ViewGroup) FC.getParent()).removeView(FC);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.f.ala_live_footer_view);
            ccR().hDr.addView(FC, layoutParams);
        }
    }

    private void chV() {
        chZ();
        cbA();
        chY();
        ccR().hDr.setVisibility(0);
        vS(0);
    }

    private void chW() {
        if (this.hIM == null) {
            this.hIM = new com.baidu.tieba.ala.liveroom.t.a(ccR().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.hIM.a(ccR().bRl(), j, TbadkCoreApplication.getCurrentAccountName(), true, ccR().hDq.Fp().aJD.portrait, this.otherParams, "", -1L);
        this.hIM.aF(this.hJe);
    }

    private void chX() {
        if (this.hJz == null) {
            ccR().hDr.hTf = false;
            com.baidu.live.af.a fZ = fZ(ccR().pageContext.getPageActivity());
            if (fZ != null) {
                this.hJz = fZ;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.af.a.class, ccR().pageContext.getPageActivity());
                if (runTask != null) {
                    this.hJz = (com.baidu.live.af.a) runTask.getData();
                }
            }
            if (this.hJz != null) {
                this.hJz.r(this.hJf);
                this.hJz.s(this.hJg);
                this.hJz.dY((ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds330) + ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds96)) - ccR().pageContext.getResources().getDimensionPixelSize(a.d.sdk_ds300));
                this.hJz.t(ccR().hDr);
                this.hJz.a(this.hrA);
                this.hJz.setLiveShowInfo(ccR().hDq.Fp());
                this.hJz.a(this.hsi);
                this.hJz.QI();
                this.hJz.a(new a.InterfaceC0162a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
                    @Override // com.baidu.live.af.a.InterfaceC0162a
                    public void QJ() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0162a
                    public void QK() {
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0162a
                    public void H(Object obj) {
                        if (AlaMasterLiveRoomOpearator.this.ccR().hDH != null) {
                            AlaMasterLiveRoomOpearator.this.ccR().hDH.onStickerItemSelected(obj);
                        }
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0162a
                    public int QL() {
                        return AlaMasterLiveRoomOpearator.this.hJd.getBottom();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0162a
                    public int QM() {
                        return AlaMasterLiveRoomOpearator.this.hwy.hDr.getHeight() - (AlaMasterLiveRoomOpearator.this.hto.getImMsgListViewTop() + AlaMasterLiveRoomOpearator.this.hto.getImMsgListViewHeight());
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0162a
                    public int getImMsgListViewHeight() {
                        return AlaMasterLiveRoomOpearator.this.hto.getImMsgListViewHeight();
                    }

                    @Override // com.baidu.live.af.a.InterfaceC0162a
                    public int QN() {
                        return AlaMasterLiveRoomOpearator.this.hto.Kj();
                    }
                });
            }
        }
    }

    private com.baidu.live.af.a fZ(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aX(context);
        }
        return null;
    }

    private void chY() {
        if (this.hIO == null) {
            this.hIO = new b(ccR().pageContext, ccR().hDr);
        }
    }

    private void chZ() {
        if (this.hsd == null) {
            this.hsd = new com.baidu.tieba.ala.liveroom.m.a(ccR().pageContext, true, this.hKm);
            this.hsd.e(this.hJd, null);
            this.hsd.a(this.hsO);
            this.hsd.ou(false);
        }
        if (this.hIK == null) {
            this.hIK = new com.baidu.tieba.ala.liveroom.m.a(ccR().pageContext, true, null);
            this.hIK.a(this.hJd, null, a.f.ala_live_room_host_header_stub);
            this.hIK.cgr();
        }
    }

    protected void cbd() {
        CustomResponsedMessage runTask;
        boolean z = false;
        aw cjB = ccR().hDq.cjB();
        boolean z2 = com.baidu.live.ae.a.Qm().bwx.aOz;
        if (cjB == null || cjB.aKp) {
            z = z2;
        }
        if (z && this.hsZ == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.j.b.class, ccR().pageContext)) != null) {
            this.hsZ = (com.baidu.live.j.b) runTask.getData();
            if (this.hsZ != null) {
                this.hsZ.setIsHost(true);
                this.hsZ.dv(1);
                View view = this.hsZ.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.f.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(ccR().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(ccR().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.f.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.f.ala_live_room_host_header_stub);
                    this.hJd.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(com.baidu.live.data.ab abVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2;
        if (this.hsi == null) {
            this.hsi = new com.baidu.tieba.ala.liveroom.activeview.b(ccR().pageContext);
        }
        this.hsi.setOtherParams(this.otherParams);
        this.hsi.c(abVar, false);
        this.hsi.setHost(true);
        this.hsi.a(1, this.bAa);
        this.hsi.a(2, this.bAa);
        this.hsi.nI(this.huh);
        this.hsi.setVisible(this.hII ? 8 : 0);
        this.hsi.a(this.hrA);
        if (this.hrA != null) {
            if (this.hsi != null) {
                AlaActiveRootView vk = this.hsi.vk(1);
                alaActiveRootView = this.hsi.vk(2);
                alaActiveRootView2 = vk;
            } else {
                alaActiveRootView = null;
                alaActiveRootView2 = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.hrA.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.hrA.a(alaActiveRootView);
            }
        }
    }

    private void O(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        if (this.htQ == null && (runTask = MessageManager.getInstance().runTask(2913130, k.class, ccR().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.aa.a)) {
            this.htQ = (com.baidu.live.aa.a) runTask.getData();
            if (this.htQ != null) {
                this.htQ.q(this.bAa);
            }
        }
        if (this.htQ != null) {
            this.huh = this.htQ.p(abVar);
            this.htQ.setCanVisible(!this.hII);
        }
    }

    protected void cia() {
        CustomResponsedMessage runTask;
        if (ccR() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.l.a.class, ccR().pageContext.getPageActivity())) != null && runTask.getData() != null && this.htG == null) {
            this.htG = (com.baidu.live.l.a) runTask.getData();
            this.htG.d(this.hJe, cbO());
            if (ccR().hDq != null) {
                this.htG.a(ccR().hDq.Fp());
            }
            this.htG.setCanVisible(true);
            this.htG.ch(false);
            this.htG.a(ccR().hDq.bTX());
        }
    }

    protected void cbz() {
        CustomResponsedMessage runTask;
        if (ccR() != null && this.htI == null && (runTask = MessageManager.getInstance().runTask(2913225, com.baidu.live.t.a.class, ccR().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.htI = (com.baidu.live.t.a) runTask.getData();
            this.htI.setIsHost(true);
            this.htI.a(this.hwy.hDr, ccR().hDq.Fp());
        }
    }

    protected void caq() {
        if (ccR() != null) {
            if (this.htJ == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913271, com.baidu.live.a.a.class, ccR().pageContext);
                if (runTask != null && runTask.getData() != null) {
                    this.htJ = (com.baidu.live.a.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.htJ.aW(this.gSo);
            this.htJ.setIsHorizontal(false);
            this.htJ.setIsHost(true);
            this.htJ.a(this.bAa, ccR().hDq.Fp());
        }
    }

    protected void cby() {
        if (ccR() != null) {
            if (this.htH == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913262, com.baidu.live.v.a.class, ccR().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.htH = (com.baidu.live.v.a) runTask.getData();
                } else {
                    return;
                }
            }
            if (ccR().hDq != null) {
                this.htH.b(ccR().hDq.Fp(), this.otherParams);
            }
        }
    }

    protected void cap() {
        if (ccR() != null) {
            if (this.hsp == null) {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913239, com.baidu.live.ad.a.class, ccR().pageContext.getPageActivity());
                if (runTask != null && runTask.getData() != null) {
                    this.hsp = (com.baidu.live.ad.a) runTask.getData();
                } else {
                    return;
                }
            }
            this.hsp.setIsHost(true);
            this.hsp.a(this.bAa, ccR().hDq.Fp().aKC);
        }
    }

    protected void cib() {
        CustomResponsedMessage runTask;
        if (ccR() != null && this.hJw == null && (runTask = MessageManager.getInstance().runTask(2913269, com.baidu.live.n.b.class, ccR().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.hJw = (com.baidu.live.n.b) runTask.getData();
        }
    }

    protected void cbB() {
        CustomResponsedMessage runTask;
        if (ccR() != null && this.htK == null && (runTask = MessageManager.getInstance().runTask(2913240, com.baidu.live.k.a.class, ccR().pageContext)) != null && runTask.getData() != null) {
            this.htK = (com.baidu.live.k.a) runTask.getData();
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(11);
            this.htK.a(this.hJe, ccR().hDq.Fp(), layoutParams, this.otherParams);
        }
    }

    private void P(com.baidu.live.data.ab abVar) {
        CustomResponsedMessage runTask;
        CustomResponsedMessage runTask2;
        CustomResponsedMessage runTask3;
        CustomResponsedMessage runTask4;
        if (ccR() != null) {
            if (this.hIQ == null && (runTask4 = MessageManager.getInstance().runTask(2913229, com.baidu.live.t.e.class)) != null) {
                this.hIQ = (com.baidu.live.t.e) runTask4.getData();
            }
            if (this.hIQ != null) {
                this.hIQ.Pm();
            }
            if (this.hIR == null && (runTask3 = MessageManager.getInstance().runTask(2913292, com.baidu.live.t.b.class)) != null) {
                this.hIR = (com.baidu.live.t.b) runTask3.getData();
            }
            if (this.hIR != null) {
                this.hIR.Pm();
            }
            if (this.hIS == null && (runTask2 = MessageManager.getInstance().runTask(2913296, com.baidu.live.t.b.class)) != null) {
                this.hIS = (com.baidu.live.t.b) runTask2.getData();
            }
            if (this.hIS != null) {
                this.hIS.Pm();
            }
            if (this.hIT == null && (runTask = MessageManager.getInstance().runTask(2913293, f.class)) != null) {
                this.hIT = (f) runTask.getData();
            }
            if (this.hIT != null) {
                this.hIT.Pm();
            }
            if (this.hIU == null) {
                CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(2913230, com.baidu.live.t.d.class);
                if (runTask5 != null) {
                    this.hIU = (com.baidu.live.t.d) runTask5.getData();
                }
                if (this.hIU != null) {
                    this.hIU.setParentView(this.hwy.hDr);
                    if (abVar != null && abVar.aJD != null) {
                        this.hIU.bh(abVar.aJD.userId);
                    }
                }
            }
        }
    }

    private void cic() {
        CustomResponsedMessage runTask;
        if (ccR() != null) {
            if (this.hIV == null && (runTask = MessageManager.getInstance().runTask(2913265, c.class)) != null) {
                this.hIV = (c) runTask.getData();
            }
            if (this.hIV != null) {
                this.hIV.Pm();
            }
            if (this.hIW == null) {
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2913266, com.baidu.live.v.b.class);
                if (runTask2 != null) {
                    this.hIW = (com.baidu.live.v.b) runTask2.getData();
                }
                if (this.hIW != null) {
                    this.hIW.setParentView(this.hwy.hDr);
                    this.hIW.b(ccR().hDq.Fp(), this.otherParams);
                }
            }
        }
    }

    private ViewGroup.LayoutParams cbO() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(ccR().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(1, a.f.ala_live_room_stream_view);
            layoutParams.leftMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds20);
        } else {
            layoutParams.addRule(5, a.f.ala_liveroom_charmview);
        }
        if (this.htL != null && this.htL.isShowing()) {
            layoutParams.addRule(3, a.f.ala_rank_level_entry);
            layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        } else if (this.hIM != null && this.hIM.isShowing()) {
            layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
            layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds16);
        }
        return layoutParams;
    }

    private void cbA() {
        if (this.hIL == null) {
            this.hIL = new com.baidu.tieba.ala.liveroom.a.a(ccR().pageContext, true);
        }
    }

    private void cid() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = ccR().pageContext.getPageActivity();
            if (this.hJA == null) {
                this.hJA = new ImageView(pageActivity);
                this.hJA.setId(a.f.master_close_btn);
                this.hJA.setTag("master_close_btn");
                this.hJA.setImageResource(a.e.sdk_icon_bar_live_close_n);
                this.hJA.setBackgroundResource(a.e.sdk_round_btn_close_bg);
                this.hJA.setPadding(pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds4), 0);
            }
            if (this.hJA.getParent() != null) {
                ((ViewGroup) this.hJA.getParent()).removeView(this.hJA);
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
            ccR().hDK.addView(this.hJA, layoutParams);
            this.hJA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.cim();
                }
            });
            this.hJA.setVisibility(8);
        }
    }

    protected void cbE() {
        if (this.htL == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913226, com.baidu.live.t.c.class, ccR().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.htL = (com.baidu.live.t.c) runTask.getData();
            } else {
                return;
            }
        }
        if (ccR().hDq.Fp() != null && ccR().hDq.Fp().aJD != null && ccR().hDq.Fp().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.height = BdUtilHelper.getDimens(ccR().pageContext.getPageActivity(), a.d.sdk_ds44);
            layoutParams.leftMargin = BdUtilHelper.getDimens(ccR().pageContext.getPageActivity(), a.d.sdk_ds20);
            this.htL.b(this.hJe, layoutParams, ccR().hDq.Fp());
        }
    }

    private void cie() {
        CustomResponsedMessage runTask;
        if (this.hJV == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, ccR().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.hJV = (com.baidu.live.b.a) runTask.getData();
            if (this.hJV != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.f.ala_head_line_entry_id);
                layoutParams.addRule(11);
                layoutParams.topMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds14);
                layoutParams.rightMargin = ccR().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.d.sdk_ds22);
                aw cjB = ccR().hDq.cjB();
                if (cjB != null) {
                    this.hJV.a(this.hJe, layoutParams, ccR().pageContext.getPageActivity(), cjB.aPJ);
                } else {
                    return;
                }
            }
        }
        if (this.hJV != null) {
            this.hJV.a(ccR().hDq.Fp());
        }
    }

    private void cbl() {
        if (this.bif == null) {
            this.bif = new com.baidu.live.an.a(ccR().pageContext.getPageActivity());
        }
    }

    private void Q(com.baidu.live.data.ab abVar) {
        if (this.hJW == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913299, com.baidu.live.guess.b.class);
            if (runTask.getData() != null) {
                this.hJW = (com.baidu.live.guess.b) runTask.getData();
                if (this.hJW != null && this.bAa != null) {
                    this.hJW.init(ccR().pageContext.getPageActivity(), true);
                    this.hJW.a(abVar, this.bAa);
                }
            }
        }
    }

    public void onRtcConnected(int i) {
        if (this.hJT != null) {
            this.hJT.onRtcConnected(i);
        }
    }

    private void registerListener() {
        ccR().pageContext.registerListener(this.huz);
        ccR().pageContext.registerListener(this.hKf);
        ccR().pageContext.registerListener(this.huA);
        ccR().pageContext.registerListener(this.huB);
        ccR().pageContext.registerListener(this.hKj);
        ccR().pageContext.registerListener(this.bDB);
        ccR().pageContext.registerListener(this.hqK);
        ccR().pageContext.registerListener(this.hKk);
        ccR().pageContext.registerListener(this.gPc);
        ccR().pageContext.registerListener(this.hsK);
        ccR().pageContext.registerListener(this.huF);
        ccR().pageContext.registerListener(this.bGa);
        ccR().pageContext.registerListener(this.bGb);
        ccR().pageContext.registerListener(this.hKg);
        ccR().pageContext.registerListener(this.btq);
        ccR().pageContext.registerListener(this.btr);
        ccR().pageContext.registerListener(this.hKh);
        ccR().pageContext.registerListener(this.huH);
        ccR().pageContext.registerListener(this.huG);
        ccR().pageContext.registerListener(this.huL);
        ccR().pageContext.registerListener(this.hKh);
        ccR().pageContext.registerListener(this.bqe);
        ccR().pageContext.registerListener(this.bnz);
        ccR().pageContext.registerListener(this.hfH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oz(boolean z) {
        if (bt.c(com.baidu.live.ae.a.Qm().bCs)) {
            ccR().pageContext.showToast(a.h.sdk_filter_beauty_grey_tip);
        } else if (ccR().hDM.zE() == null || ListUtils.isEmpty(ccR().hDM.zE().aDD)) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                ccR().pageContext.showToast(a.h.sdk_filter_beauty_no_net);
            } else if (!this.bFY) {
                this.bFX = BdUniqueId.gen();
                ccR().hDM.a(this.bFX);
                this.bFY = true;
            }
        } else {
            BdUtilHelper.hideSoftKeyPad(ccR().pageContext.getPageActivity(), ccR().rootView);
            vS(8);
            if (ccR().hDH.hasAdvancedBeauty() && this.hJS != null) {
                if (!this.hJX || this.hIJ.getVisibility() == 0) {
                    this.hJS.c(ccR().hDH.getVideoConfig());
                }
                this.hJS.a(ccR().hDH.getVideoConfig(), this.bFZ);
                if (!this.bFZ) {
                    this.bFZ = true;
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
    public void vR(int i) {
        if (this.hJB == null || !this.hJB.isShowing()) {
            this.hJB = new BdAlertDialog(ccR().pageContext.getPageActivity());
            this.hJB.setAutoNight(false);
            this.hJB.setTitle(a.h.sdk_prompt);
            this.hJB.setMessageId(i, currentAppType(ccR().pageContext.getPageActivity()));
            this.hJB.setTitleShowCenter(true);
            this.hJB.setMessageShowCenter(true);
            this.hJB.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.ccR().g((short) 1);
                }
            });
            this.hJB.create(ccR().pageContext).show();
        }
    }

    private void Ic(String str) {
        if (this.hJC == null || !this.hJC.isShowing()) {
            this.hJC = new BdAlertDialog(ccR().pageContext.getPageActivity());
            this.hJC.setAutoNight(false);
            this.hJC.setTitle(a.h.sdk_prompt);
            this.hJC.setMessage(str);
            this.hJC.setTitleShowCenter(true);
            this.hJC.setMessageShowCenter(true);
            this.hJC.setPositiveButton(a.h.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    AlaMasterLiveRoomOpearator.this.ccR().g((short) 1);
                }
            });
            this.hJC.create(ccR().pageContext).show();
        }
    }

    public void cif() {
        cbd();
        v bTX = ccR().hDq.bTX();
        int i = 5;
        if (bTX != null) {
            i = (int) bTX.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp() != null && AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.ccR().hDq.j(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp().mLiveInfo.live_id, false);
                }
            }
        }, i);
        if (bTX != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hwy.hDP.b(bTX);
                return;
            }
            if (this.hsc == null) {
                this.hsc = new com.baidu.tieba.ala.liveroom.audiencelist.c(ccR().pageContext, this.hKm, true);
            }
            if (this.hJQ) {
                this.hJQ = false;
                this.hsc.a(String.valueOf(ccR().hDq.Fp().mLiveInfo.group_id), String.valueOf(ccR().hDq.Fp().mLiveInfo.live_id), String.valueOf(ccR().hDq.Fp().aJD.userId), ccR().hDq.Fp());
                int i2 = a.f.ala_live_room_host_header_stub;
                if (this.hsZ != null) {
                    i2 = a.f.ala_liveroom_guardthrone;
                }
                this.hsc.c(this.hJd, i2, a.f.ala_liveroom_audience_count_layout);
            }
            this.hsc.e(bTX);
            this.hsg.setVisible(0);
            this.hsg.ff(bTX.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cig() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buI() {
        if (ccR().hDq != null) {
            if (this.htb == null) {
                this.htb = new com.baidu.tieba.ala.liveroom.share.c(ccR().pageContext);
            }
            this.htb.d(ccR().hDq.Fp(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (ccR().hDq != null && ccR().hDq.Fp() != null && ccR().hDq.Fp().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", ccR().hDq.Fp().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", ccR().hDq.Fp().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", ccR().hDq.Fp().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (ccR().hDq != null && ccR().hDq.Fp() != null && ccR().hDq.Fp().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", ccR().hDq.Fp().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", ccR().hDq.Fp().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", ccR().hDq.Fp().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean cih() {
        return this.hIH;
    }

    private void oA(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(hIG, z);
        this.hIH = z;
    }

    private void cii() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(ccR().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.h.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.h.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.n.b(AlaMasterLiveRoomOpearator.this.ccR().pageContext).cjj();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.h.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(ccR().pageContext).show();
    }

    private void cij() {
        if (this.hIq && ccR().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            ccR().hDO.Uc();
        }
        ccR().hDN.prepareTime = System.currentTimeMillis() - ccR().hDN.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (ccR().hDq != null && ccR().hDq.Fp() != null && ccR().hDq.Fp().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", ccR().hDq.Fp().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", ccR().hDq.Fp().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", ccR().hDN.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hIJ != null && this.hIJ.getView().getParent() != null) {
            this.hIJ.setVisibility(8);
            ccR().hDK.removeView(this.hIJ.getView());
            this.hIJ.release();
        }
        if (this.hJS != null) {
            this.hJS.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (ccR().hDr.indexOfChild(this.hJa) < 0) {
            ccR().hDr.addView(this.hJa, layoutParams);
        }
        this.hJa.wj(1000);
    }

    private void awr() {
        if (ccR().bRl() == 1) {
            ccR().hDH.startRecord();
        }
    }

    private void Id(String str) {
        Ie(str);
    }

    private void Ie(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) ccR().pageContext.getPageActivity(), 12002, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.hIJ != null) {
            this.hIJ.HR(fromJson.getSmallurl());
        }
    }

    private boolean cik() {
        return com.baidu.live.d.xf().getBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cil() {
        com.baidu.live.d.xf().putBoolean(com.baidu.live.d.getSharedPrefKeyWithAccount("key_mirror_status"), this.hwy.hDH.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cim() {
        if (this.hJU == null || !this.hJU.Rq()) {
            if (this.hIZ == null || !this.hIZ.Rq()) {
                int i = a.h.live_close_confirm;
                if (this.hJT != null && this.hJT.ccZ()) {
                    i = a.h.ala_pk_pking_close_live_roon_tip;
                } else if (this.hJT != null && this.hJT.ccY()) {
                    i = a.h.ala_challenge_challenging_close_live_room_tip;
                }
                BdAlertDialog bdAlertDialog = new BdAlertDialog(ccR().pageContext.getPageActivity());
                bdAlertDialog.setAutoNight(false);
                bdAlertDialog.setTitle((String) null);
                bdAlertDialog.setMessageId(i);
                bdAlertDialog.setPositiveButton(a.h.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                            AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                        }
                        bdAlertDialog2.dismiss();
                        if (AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp() != null) {
                            AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp(), 0, AlaMasterLiveRoomOpearator.this.ccR().hDq.cjK() != 1 ? AlaMasterLiveRoomOpearator.this.ccR().pageContext.getString(a.h.ala_live_end_authen_msg) : null);
                        } else {
                            AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                        }
                    }
                });
                bdAlertDialog.setNegativeButton(a.h.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
                    @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                    public void onClick(BdAlertDialog bdAlertDialog2) {
                        bdAlertDialog2.dismiss();
                    }
                });
                bdAlertDialog.create(ccR().pageContext).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.ab abVar, int i, String str) {
        AlaLiveUserInfoData alaLiveUserInfoData;
        AlaLiveInfoData alaLiveInfoData;
        if (abVar != null) {
            alaLiveInfoData = abVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = abVar.aJD;
            if (alaLiveInfoData != null) {
                String str2 = alaLiveInfoData.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                ccR().hDq.eA(Long.toString(alaLiveInfoData.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
        } else {
            alaLiveUserInfoData = null;
            alaLiveInfoData = null;
        }
        if (!this.hJO) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = ccR().hDN;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = ccR().hDH.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.hJK;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.hJL;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.hJG;
            if (this.hJH != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.hJI - this.hJJ) / this.hJH) * 100.0f;
            }
            Intent intent = new Intent(ccR().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (ccR().hDq != null && ccR().hDq.Fp() != null && ccR().hDq.Fp().aJD != null) {
                String str3 = ccR().hDq.Fp().aJD.nickName;
                String str4 = ccR().hDq.Fp().aJD.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.ab Fp = ccR().hDq.Fp();
            if (Fp != null && Fp.aJD != null && !TextUtils.isEmpty(Fp.aJD.portrait)) {
                intent.putExtra("host_portrait", Fp.aJD.portrait);
            }
            if (this.hJU != null) {
                this.hJU.VC();
            }
            if (this.hIZ != null) {
                this.hIZ.Ro();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.hJM = intent;
                this.hJN = s;
                ccR().pageContext.showToast(a.h.ala_live_background_close_tip);
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
            if (this.hKd != null) {
                this.hKd.aCY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cin() {
        if (this.hJM != null) {
            a(this.hJM, this.hJN);
            this.hJM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.hJO = true;
        if (this.hJT != null) {
            this.hJT.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.hqz);
            ccR().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        ccR().g(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cio() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.hwy.hDP != null && this.hwy.hDP.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hJT != null && this.hJT.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hJU != null && this.hJU.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hJS != null && this.hJS.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.hIZ != null && this.hIZ.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (ccR().hDL.ciS()) {
                cim();
                return true;
            }
        }
        return false;
    }

    public void VF() {
        if (this.hJU != null) {
            this.hJU.VF();
        }
    }

    public void sendBufferChanged(int i) {
        if (this.hJb != null) {
            this.hJb.ek(i);
        }
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (this.hwy != null && this.hwy.hDq != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.dMQ != i3) {
                this.dMQ = i3;
                if (this.hIP == null) {
                    this.hIP = new com.baidu.tieba.ala.liveroom.tippop.a(this.hwy.pageContext, null);
                }
                switch (this.dMQ) {
                    case 0:
                        this.hIP.a(this.hwy.hDK, this.hwy.pageContext.getString(a.h.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.hIP.a(this.hwy.hDK, this.hwy.pageContext.getString(a.h.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.hIP.a(this.hwy.hDK, this.hwy.pageContext.getString(a.h.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.hwy.hDq.x(this.hwy.hDq.Fp().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P(com.baidu.live.im.data.b bVar) {
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
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cio();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp(), 1, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0738, code lost:
        HE(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0051 A[Catch: JSONException -> 0x082d, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082d, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0822), top: B:292:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0822 A[Catch: JSONException -> 0x082d, TRY_ENTER, TRY_LEAVE, TryCatch #6 {JSONException -> 0x082d, blocks: (B:14:0x0049, B:16:0x0051, B:263:0x0822), top: B:292:0x0049 }] */
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
        if (this.hsi != null) {
            this.hsi.N(bVar);
        }
        if (bVar.getMsgType() == 125) {
            if (this.hIN != null) {
                this.hIN.R(bVar);
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
            if (this.hJT != null) {
                this.hJT.fu(str2);
            }
            if ("close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.cio();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.ccR().hDq.Fp(), 1, str3);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (ccR().hDq.Fp() != null && jSONObject5 != null) {
                    long optLong = jSONObject5.optLong("user_id");
                    int optInt = jSONObject5.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccR().hDq.Fp().aJZ.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            ccR().hDq.Fp().aJZ.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        ccR().hDq.Fp().aJZ.isAdmin = 0;
                    }
                }
            } else if ("live_talk_admin_ban".equals(str2)) {
                if (ccR().hDq.Fp() != null && jSONObject5 != null) {
                    long optLong2 = jSONObject5.optLong("user_id");
                    if (ccR().hDq.Fp() != null && ccR().hDq.Fp().aJD != null && ccR().hDq.Fp().aJD.userId == optLong2) {
                        ccR().hDq.Fp().aJD.isUegBlock = 1;
                        caH();
                    }
                }
            } else if ("live_talk_admin_remove_ban".equals(str2)) {
                if (ccR().hDq.Fp() != null && jSONObject5 != null) {
                    long optLong3 = jSONObject5.optLong("user_id");
                    if (ccR().hDq.Fp() != null && ccR().hDq.Fp().aJD != null && ccR().hDq.Fp().aJD.userId == optLong3) {
                        ccR().hDq.Fp().aJD.isUegBlock = 0;
                        caH();
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.hJx != null) {
                    this.hJx.ad(jSONObject5);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString2 = jSONObject5.optString("share_enter_msg");
                    int optInt2 = jSONObject5.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString2)) {
                        this.hIO.aM(optString2, optInt2);
                    }
                    if (this.hsg.getCount() > 20) {
                        this.hsg.ff(this.hsg.getCount() + 1);
                    } else if (this.hsc != null) {
                        com.baidu.live.data.a Lc = bVar.Lc();
                        com.baidu.live.data.u uVar = new com.baidu.live.data.u();
                        uVar.aJE = new AlaLocationData();
                        uVar.aJF = new AlaRelationData();
                        uVar.aJD = new AlaLiveUserInfoData();
                        uVar.aJD.userId = JavaTypesHelper.toLong(Lc.userId, 0L);
                        uVar.aJD.userName = Lc.userName;
                        uVar.aJD.portrait = Lc.portrait;
                        if (this.hsc.c(uVar)) {
                            this.hsg.ff(this.hsg.getCount() + 1);
                        }
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject5 != null && ccR() != null && ccR().hDq != null && ccR().hDq.Fp() != null && ccR().hDq.Fp().aJZ != null && ccR().hDq.Fp().aJZ.userId == jSONObject5.optLong("user_id")) {
                    ccR().hDq.cjA();
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
                    com.baidu.live.data.a Lc2 = bVar.Lc();
                    if (Lc2 != null && ac.gx(str5)) {
                        ac.d(str5, 1L, "", "", Lc2.userId, Lc2.portrait, Lc2.userName, "", "", false, "", "", "", false, false, true, -1L);
                    }
                }
            } else if ("challenge_mvp".equals(str2)) {
                if (jSONObject5 != null) {
                    bh bhVar = new bh();
                    bhVar.parseJson(jSONObject5);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913205, bhVar));
                }
            } else if (TextUtils.equals(str2, "challenge_mvp_punish")) {
                if (jSONObject5 != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913213, jSONObject5));
                }
            } else if ("challenge_direct_new".equals(str2)) {
                if (jSONObject5 != null) {
                    String optString3 = jSONObject5.optString("challenge_im_type");
                    if (TextUtils.equals(optString3, "start")) {
                        If(jSONObject5.optString("challenge_user_name"));
                    } else if (TextUtils.equals(optString3, "cancel")) {
                        BdUtilHelper.showToast(ccR().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
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
                            if (this.htK != null) {
                            }
                            if (this.htI != null) {
                            }
                        }
                    } catch (JSONException e4) {
                        e = e4;
                        jSONObject2 = null;
                    }
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_direct_new").setContentExt(null, null, jSONObject2));
            } else if ("challenge_random_cancel".equals(str2)) {
                BdUtilHelper.showToast(ccR().pageContext.getPageActivity(), a.h.ala_challenge_cancel_tip);
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem("2678", UbcStatConstant.ContentType.UBC_TYPE_CHALLENGE_IM, "author_liveroom", "challenge_random_cancel").setContentExt(null, null, null));
            } else if ("connect_apply_show_pub".equals(str2)) {
                if (this.hIZ != null) {
                    this.hIZ.ac(jSONObject5);
                }
            } else if ("remove_video".equals(str2)) {
                String optString5 = jSONObject5.optString("text");
                if (jSONObject5.optString("poke_msg").isEmpty()) {
                    Ib(optString5);
                }
            }
        } else if (bVar.getMsgType() == 24) {
            com.baidu.live.data.a Lc3 = bVar.Lc();
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
                if (ccR().hDq == null || ccR().hDq.Fp() == null || ccR().hDq.Fp().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    z = false;
                } else {
                    long j4 = ccR().hDq.Fp().mLiveInfo.live_id;
                    j3 = ccR().hDq.Fp().mLiveInfo.group_id;
                    long j5 = ccR().hDq.Fp().aJD.userId;
                    str8 = ccR().hDq.Fp().mLiveInfo.appId;
                    boolean z5 = ccR().hDq.Fp().mLiveInfo.isPubShow;
                    if (ccR().hDq.Fp().mLiveSdkInfo.mCastIds != null) {
                        str6 = ccR().hDq.Fp().mLiveSdkInfo.mCastIds.chatMCastId;
                        str7 = ccR().hDq.Fp().mLiveSdkInfo.mCastIds.ensureMCastId;
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
                    if (!this.isBackground || ccR().bRl() != 2) {
                        if (!TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                            if (jSONObject3.optInt("flag_show") == 1) {
                                ac.b(cVar, Lc3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, "", "", bVar.getMsgId());
                                try {
                                    JSONArray jSONArray = new JSONArray(optString11);
                                    if (jSONArray != null && jSONArray.length() > 0) {
                                        int i = 0;
                                        while (true) {
                                            if (i >= jSONArray.length()) {
                                                break;
                                            }
                                            if (com.baidu.live.ae.f.QE().hB(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                            ac.b(cVar, Lc3, String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str8, (z4 || z3) ? false : true, true, str6, str7, bVar.getMsgId());
                        }
                    }
                    HE(optString7);
                    if (!jSONObject3.optString("content_type").equals(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT)) {
                        com.baidu.tieba.ala.liveroom.f.c cVar2 = new com.baidu.tieba.ala.liveroom.f.c();
                        cVar2.bqN = optLong5;
                        cVar2.liveId = j2;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, cVar2));
                    }
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.putOpt(LogConfig.LOG_GIFT_ID, optString7);
                        jSONObject6.putOpt("gift_name", optString9);
                        jSONObject6.putOpt("order_id", optString6);
                        com.baidu.live.gift.g gt = ac.gt(optString7);
                        if (gt != null) {
                            jSONObject6.putOpt(LogConfig.LOG_GIFT_VALUE, gt.getPrice());
                        }
                        jSONObject6.putOpt("gift_num", optString8);
                    } catch (JSONException e6) {
                        e6.printStackTrace();
                    }
                    UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "author_liveroom", "giftsend_succ").setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject6));
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
        if (this.htK != null) {
            this.htK.l(bVar);
        }
        if ((this.htI != null || !this.htI.J(bVar)) && this.hsp != null && this.hsp.ab(jSONObject4)) {
        }
    }

    private void HE(String str) {
        if (this.hsi != null) {
            this.hsi.HE(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        View findViewById = ccR().rootView.findViewById(a.f.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.hsi != null) {
            this.hsi.bN(2, i);
        }
    }

    private void cip() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.ccR().hDH != null && AlaMasterLiveRoomOpearator.this.ccR().hDH.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.ccR().hDH.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.ccR().hDH.startRecord();
                }
            }
        });
    }

    private void ciq() {
        if (ccR().hDH != null && ccR().hDH.getPreview() != null) {
            ccR().hDH.getPreview().setVisibility(8);
            ccR().hDH.stopRecord();
        }
    }

    public void cir() {
        this.hDE = ccR().hDq.cjL();
        if (this.hIJ != null) {
            this.hIJ.oi(this.hDE);
        }
    }

    public void ceL() {
        if (TbadkCoreApplication.getInst().isOther()) {
            cis();
        } else if (this.hIJ != null) {
            this.hIJ.ceL();
        }
    }

    public void oj(boolean z) {
        if (this.hIJ != null) {
            this.hIJ.oj(z);
        }
    }

    public void onDestroy() {
        if (this.hJF != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.hJF);
        }
        this.hJF = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.hJv.removeCallbacksAndMessages(null);
        if (this.hJS != null) {
            this.hJS.og(true);
        }
        this.hJS = null;
        if (this.hIJ != null) {
            this.hIJ.destroy();
            ccR().hDK.removeView(this.hIJ.getView());
            this.hIJ.release();
            this.hIJ = null;
        }
        if (this.hJT != null) {
            this.hJT.onDestroy();
        }
        if (this.htb != null) {
            this.htb.onDestroy();
        }
        if (this.hsd != null) {
            this.hsd.onDestroy();
            this.hsd = null;
        }
        if (this.hIK != null) {
            this.hIK.onDestroy();
        }
        if (this.htC != null) {
            this.htC.onDestroy();
            this.htC = null;
        }
        if (this.hJa != null) {
            this.hJa.stopCountDown();
        }
        if (this.hIM != null) {
            this.hIM.onDestroy();
        }
        if (this.hIO != null) {
            this.hIO.onDestroy();
        }
        if (this.hJx != null) {
            this.hJx.onDestroy();
            this.hJx = null;
        }
        if (this.htq != null) {
            this.htq.onDestroy();
            this.htq = null;
        }
        if (this.hIQ != null) {
            this.hIQ.release();
        }
        if (this.hIR != null) {
            this.hIR.release();
        }
        if (this.hIS != null) {
            this.hIS.release();
        }
        if (this.hIT != null) {
            this.hIT.release();
        }
        if (this.hIV != null) {
            this.hIV.release();
        }
        com.baidu.live.storage.opt.b.Rj().release();
        ac.Fx();
        com.baidu.live.entereffect.a.CY().release();
        this.hKc = false;
        if (this.htr != null) {
            this.htr.onDestroy();
            this.htr = null;
        }
        if (this.hIP != null) {
            this.hIP.onDestroy();
        }
        if (this.hIN != null) {
            this.hIN.clX();
            this.hIN.release();
        }
        if (this.hsg != null) {
            this.hsg = null;
        }
        if (this.hsi != null) {
            this.hsi.release();
        }
        if (this.hIN != null) {
            this.hIN.onDestroy();
        }
        if (this.htp != null) {
            this.htp.release();
        }
        if (this.hIX != null) {
            this.hIX.release();
        }
        if (this.hJz != null) {
            this.hJz.onDestroy();
        }
        if (this.htQ != null) {
            this.htQ.release();
        }
        if (this.hJV != null) {
            this.hJV.onDestory();
        }
        if (this.htG != null) {
            this.htG.onDestroy();
        }
        if (this.htI != null) {
            this.htI.onDestroy();
        }
        if (this.htH != null) {
            this.htH.onDestroy();
        }
        if (this.hsp != null) {
            this.hsp.onDestroy();
        }
        if (this.hIU != null) {
            this.hIU.release();
            this.hIU = null;
        }
        if (this.hIW != null) {
            this.hIW.release();
            this.hIW = null;
        }
        if (this.bif != null) {
            this.bif.release();
        }
        if (this.htL != null) {
            this.htL.onDestroy();
        }
        if (this.hJU != null) {
            this.hJU.onDestroy();
        }
        if (this.hIZ != null) {
            this.hIZ.onDestroy();
        }
        if (this.htU != null) {
            this.htU.onDestory();
        }
        if (this.hJB != null) {
            this.hJB.dismiss();
            this.hJB = null;
        }
        if (this.hJC != null) {
            this.hJC.dismiss();
            this.hJC = null;
        }
        this.hJY.removeCallbacksAndMessages(this.hKu);
        MessageManager.getInstance().unRegisterListener(this.huz);
        MessageManager.getInstance().unRegisterListener(this.hKf);
        MessageManager.getInstance().unRegisterListener(this.huA);
        MessageManager.getInstance().unRegisterListener(this.huB);
        MessageManager.getInstance().unRegisterListener(this.hKj);
        MessageManager.getInstance().unRegisterListener(this.bDB);
        MessageManager.getInstance().unRegisterListener(this.hqK);
        MessageManager.getInstance().unRegisterListener(this.hKk);
        MessageManager.getInstance().unRegisterListener(this.gPc);
        MessageManager.getInstance().unRegisterListener(this.hsK);
        MessageManager.getInstance().unRegisterListener(this.huF);
        MessageManager.getInstance().unRegisterListener(this.bGa);
        MessageManager.getInstance().unRegisterListener(this.bGb);
        MessageManager.getInstance().unRegisterListener(this.hKg);
        MessageManager.getInstance().unRegisterListener(this.btq);
        MessageManager.getInstance().unRegisterListener(this.btr);
        MessageManager.getInstance().unRegisterListener(this.hKh);
        MessageManager.getInstance().unRegisterListener(this.huH);
        MessageManager.getInstance().unRegisterListener(this.huG);
        MessageManager.getInstance().unRegisterListener(this.huL);
        MessageManager.getInstance().unRegisterListener(this.hKh);
        MessageManager.getInstance().unRegisterListener(this.bqe);
        MessageManager.getInstance().unRegisterListener(this.bnz);
        MessageManager.getInstance().unRegisterListener(this.hfH);
        MessageManager.getInstance().unRegisterListener(this.gZt);
        MessageManager.getInstance().unRegisterListener(this.gZL);
        ccR().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.globalListener);
        if (this.hKd != null) {
            this.hKd.aCY();
        }
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.hwy.hDP.a(this.hKt, this.hwy.hDJ, this.hJc, alaLivePersonData);
        }
    }

    private void cis() {
        if (this.hJD != null) {
            this.hwy.hDN.startTime = System.currentTimeMillis();
            this.hwy.hDN.liveTotalTime = System.currentTimeMillis();
            this.hwy.hDN.sampleMemAndCPU();
            this.hwy.hDL.a((short) 4, this.hJD);
        }
    }

    private void If(String str) {
        String str2;
        int i;
        if (ccR() != null && ccR().pageContext != null) {
            this.hJv.removeCallbacksAndMessages(null);
            try {
                final Activity pageActivity = ccR().pageContext.getPageActivity();
                LayoutInflater layoutInflater = pageActivity.getLayoutInflater();
                if (this.hKa == null) {
                    this.hKa = layoutInflater.inflate(a.g.layout_challenge_entry_toast, (ViewGroup) null);
                    this.hKa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.57
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (AlaMasterLiveRoomOpearator.this.chq()) {
                                AlaMasterLiveRoomOpearator.this.hJv.removeCallbacksAndMessages(null);
                                if (AlaMasterLiveRoomOpearator.this.hKa != null) {
                                    AlaMasterLiveRoomOpearator.this.ccR().hDr.removeView(AlaMasterLiveRoomOpearator.this.hKa);
                                }
                                if (AlaMasterLiveRoomOpearator.this.hJT != null) {
                                    AlaMasterLiveRoomOpearator.this.hJT.ccV();
                                }
                            }
                        }
                    });
                }
                TextView textView = (TextView) this.hKa.findViewById(a.f.challengerName_textView);
                if (TextUtils.isEmpty(str)) {
                    str2 = pageActivity.getResources().getString(a.h.txt_has_anchor);
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_white_alpha100));
                } else {
                    str2 = TextHelper.getTextLengthWithEmoji(str) > 20 ? TextHelper.subStringWithEmoji(str, 20) + StringHelper.STRING_MORE : str;
                    textView.setTextColor(pageActivity.getResources().getColor(a.c.sdk_color_ffeaaa));
                }
                textView.setText(str2);
                this.hJv.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.58
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccR().hDr != null && AlaMasterLiveRoomOpearator.this.hwF != null && AlaMasterLiveRoomOpearator.this.hKa != null && !pageActivity.isFinishing()) {
                            BubbleLayout bubbleLayout = (BubbleLayout) AlaMasterLiveRoomOpearator.this.hKa.findViewById(a.f.challenger_layout);
                            LinearLayout linearLayout = (LinearLayout) AlaMasterLiveRoomOpearator.this.hKa.findViewById(a.f.content_layout);
                            linearLayout.measure(0, 0);
                            int measuredWidth = linearLayout.getMeasuredWidth();
                            bubbleLayout.getLayoutParams().width = measuredWidth;
                            bubbleLayout.D((measuredWidth / 2.0f) - (pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds20) / 2.0f));
                            AlaMasterLiveRoomOpearator.this.hKa.measure(0, 0);
                            int[] iArr = new int[2];
                            AlaMasterLiveRoomOpearator.this.hwF.getLocationOnScreen(iArr);
                            int width = AlaMasterLiveRoomOpearator.this.hwF.getWidth();
                            if (width <= 0) {
                                AlaMasterLiveRoomOpearator.this.hwF.measure(0, 0);
                                width = AlaMasterLiveRoomOpearator.this.hwF.getMeasuredWidth();
                            }
                            int measuredWidth2 = ((width / 2) + iArr[0]) - (AlaMasterLiveRoomOpearator.this.hKa.getMeasuredWidth() / 2);
                            int measuredHeight = iArr[1] - AlaMasterLiveRoomOpearator.this.hKa.getMeasuredHeight();
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                            layoutParams.addRule(10);
                            layoutParams.addRule(9);
                            layoutParams.leftMargin = measuredWidth2;
                            layoutParams.topMargin = measuredHeight - pageActivity.getResources().getDimensionPixelSize(a.d.sdk_ds14);
                            if (AlaMasterLiveRoomOpearator.this.hKa != null) {
                                AlaMasterLiveRoomOpearator.this.ccR().hDr.removeView(AlaMasterLiveRoomOpearator.this.hKa);
                            }
                            AlaMasterLiveRoomOpearator.this.ccR().hDr.addView(AlaMasterLiveRoomOpearator.this.hKa, layoutParams);
                        }
                    }
                });
                if (com.baidu.live.ae.a.Qm().bwx != null) {
                    i = com.baidu.live.ae.a.Qm().bwx.aNC;
                    if (i <= 0) {
                        i = 5;
                    }
                } else {
                    i = 5;
                }
                this.hJv.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.59
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.ccR().hDr != null && AlaMasterLiveRoomOpearator.this.hKa != null) {
                            AlaMasterLiveRoomOpearator.this.ccR().hDr.removeView(AlaMasterLiveRoomOpearator.this.hKa);
                        }
                    }
                }, i * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void bVG() {
        if (BdNetTypeUtil.isNetWorkAvailable()) {
            com.baidu.live.guardclub.b bVar = new com.baidu.live.guardclub.b();
            com.baidu.live.data.ab Fp = ccR().hDq.Fp();
            if (Fp != null) {
                bVar.setAnchorId(Fp.mLiveInfo.user_id);
                bVar.setParams();
                bVar.setTag(this.gQz);
                MessageManager.getInstance().sendMessage(bVar);
            }
        }
    }

    public void cit() {
        if (ccR().pageContext.getPageActivity() instanceof Activity) {
            Activity pageActivity = ccR().pageContext.getPageActivity();
            if (Build.VERSION.SDK_INT >= 17) {
                if (pageActivity.isDestroyed() || pageActivity.isFinishing()) {
                    return;
                }
            } else if (pageActivity.isFinishing()) {
                return;
            }
        }
        boolean z = com.baidu.live.d.xf().getBoolean("new_anchor_club_rename", true);
        aw cjB = ccR().hDq.cjB();
        if (cjB != null && this.bky != null && cjB.aPK == 1 && z) {
            ccR().pageContext.getPageActivity().getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.globalListener);
            com.baidu.live.d.xf().putBoolean("new_anchor_club_rename", false);
            View inflate = View.inflate(ccR().pageContext.getPageActivity(), a.g.dialog_help_guard_club_rename, null);
            this.hav = new Dialog(ccR().pageContext.getPageActivity(), a.i.RegimentRenameDiolog);
            final Button button = (Button) inflate.findViewById(a.f.rename_confirm);
            button.setEnabled(false);
            button.setTextColor(ccR().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
            final EditText editText = (EditText) inflate.findViewById(a.f.guard_club_rename_edittext);
            final TextView textView = (TextView) inflate.findViewById(a.f.hint_num);
            ((Button) inflate.findViewById(a.f.rename_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.63
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.gZR = null;
                    AlaMasterLiveRoomOpearator.this.hav.dismiss();
                }
            });
            button.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.64
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (editText.getText().toString() != null) {
                        AlaMasterLiveRoomOpearator.this.gZR = editText.getText().toString();
                        if (AlaMasterLiveRoomOpearator.this.bky != null && AlaMasterLiveRoomOpearator.this.gZR != null) {
                            if (BdNetTypeUtil.isNetWorkAvailable()) {
                                AlaMasterLiveRoomOpearator.this.k(AlaMasterLiveRoomOpearator.this.bky.id, AlaMasterLiveRoomOpearator.this.gZR, "");
                            } else {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), "网络故障，请刷新重试");
                            }
                        } else {
                            return;
                        }
                    }
                    AlaMasterLiveRoomOpearator.this.hav.dismiss();
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.65
                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    String obj = editText.getText().toString();
                    if (obj.length() == 0) {
                        textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        textView.setText("0");
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setTextColor(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                    }
                    if (obj.length() > 0) {
                        int i4 = 0;
                        int i5 = 0;
                        for (int i6 = 0; i6 < obj.length(); i6++) {
                            String substring = obj.substring(i6, i6 + 1);
                            if (!Pattern.compile("[0-9]*").matcher(substring).matches() && !Pattern.compile("[a-zA-Z]").matcher(substring).matches() && !Pattern.compile("[一-龥]").matcher(substring).matches()) {
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), "仅支持中英文及数字");
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
                                BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity(), "不能超过3个字符");
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
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity().getResources().getColor(a.c.rename_hint_color));
                            } else {
                                textView.setTextColor(AlaMasterLiveRoomOpearator.this.ccR().pageContext.getPageActivity().getResources().getColor(a.c.sdk_black_alpha40));
                            }
                        }
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }
            });
            this.hav.setContentView(inflate);
            this.hav.setCanceledOnTouchOutside(true);
            inflate.setMinimumHeight((int) (com.baidu.tieba.ala.liveroom.g.f.getScreenHeight(ccR().pageContext.getPageActivity()) * 0.22f));
            Window window = this.hav.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (int) (com.baidu.tieba.ala.liveroom.g.f.getScreenWidth(ccR().pageContext.getPageActivity()) * 0.74f);
            attributes.height = -2;
            attributes.gravity = 17;
            window.setAttributes(attributes);
            this.hav.show();
        }
    }

    public void k(int i, String str, String str2) {
        com.baidu.tieba.ala.liveroom.messages.e eVar = new com.baidu.tieba.ala.liveroom.messages.e();
        eVar.fq(i);
        eVar.Hb(str);
        eVar.Hc(str2);
        eVar.setParams();
        MessageManager.getInstance().sendMessage(eVar);
    }
}
