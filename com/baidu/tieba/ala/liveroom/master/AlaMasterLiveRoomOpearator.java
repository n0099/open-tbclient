package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
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
import com.baidu.android.imsdk.utils.HanziToPinyin;
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
import com.baidu.live.c.l;
import com.baidu.live.c.p;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.ad;
import com.baidu.live.data.ae;
import com.baidu.live.data.af;
import com.baidu.live.data.ag;
import com.baidu.live.data.an;
import com.baidu.live.data.x;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.gift.u;
import com.baidu.live.gift.w;
import com.baidu.live.gift.z;
import com.baidu.live.guardclub.h;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.o;
import com.baidu.live.w.a;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveRootView;
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
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
    private static final String feu;
    private List<ag> awN;
    private String eOz;
    private com.baidu.live.g.a ePY;
    private c eQP;
    private com.baidu.tieba.ala.liveroom.l.a eQQ;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eQU;
    private com.baidu.tieba.ala.liveroom.activeview.b eQW;
    private com.baidu.live.h.a eRF;
    private com.baidu.tieba.ala.liveroom.share.c eRG;
    private com.baidu.tieba.ala.liveroom.o.b eRH;
    private com.baidu.tieba.ala.liveroom.guide.c eRI;
    private com.baidu.tieba.ala.liveroom.watermark.a eRJ;
    private m eRQ;
    private i eRR;
    private j eRS;
    private u eRT;
    private s eRU;
    protected com.baidu.tieba.ala.liveroom.f.a eSb;
    protected h eSc;
    protected w eSe;
    protected com.baidu.live.i.a eSm;
    private com.baidu.live.q.a eSo;
    private boolean eSz;
    private ImageView eTv;
    private f eUa;
    private ImageView eUi;
    private g eUj;
    private com.baidu.tieba.ala.liveroom.b.a feA;
    private com.baidu.tieba.ala.liveroom.r.a feB;
    private com.baidu.tieba.ala.liveroom.u.a feC;
    private b feD;
    private com.baidu.tieba.ala.liveroom.tippop.a feE;
    private AlaLiveCountDownView feF;
    private AlaLiveStreamStatusView feG;
    private RelativeLayout feH;
    private RelativeLayout feI;
    private RelativeLayout feJ;
    private RelativeLayout feK;
    private View feL;
    private AlaLiveFaceVerifyView feM;
    private ImageView feN;
    private ImageView feO;
    private ImageView feP;
    private ImageView feQ;
    private ImageView feR;
    private ImageView feS;
    private View feT;
    private ImageView feU;
    private TextView feV;
    private x feW;
    private com.baidu.live.x.a feX;
    private com.baidu.tieba.ala.liveroom.master.panel.b feY;
    private com.baidu.live.w.a feZ;
    private boolean fee;
    private boolean fev;
    private d fex;
    private com.baidu.tieba.ala.liveroom.l.a fey;
    private com.baidu.tieba.ala.liveroom.e.c fez;
    private e ffa;
    private short ffk;
    private com.baidu.tieba.ala.liveroom.g.b ffo;
    private boolean ffp;
    private boolean ffq;
    private com.baidu.tieba.ala.liveroom.challenge.f ffr;
    private com.baidu.live.b.a fft;
    private com.baidu.live.b.b ffu;
    private com.baidu.tieba.ala.liveroom.n.a ffv;
    private boolean ffw;
    private BdUniqueId ffx;
    private boolean ffy;
    private boolean few = false;
    private boolean eSu = false;
    private Handler mHandler = new Handler();
    private boolean ffb = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver ffc = null;
    private boolean ffd = false;
    private int ffe = 0;
    private int fff = 0;
    private int ffg = 0;
    private long ffh = 0;
    private long ffi = 0;
    private volatile boolean isBackground = false;
    private Intent ffj = null;
    private int mOrientation = 1;
    private boolean faF = false;
    private boolean ffl = false;
    private boolean ffm = true;
    private boolean eUg = false;
    private boolean ffn = true;
    private int bVf = 0;
    public boolean ffs = false;
    private String otherParams = "";
    private Runnable ffz = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.ePY != null) {
                AlaMasterLiveRoomOpearator.this.ePY.qQ();
            }
        }
    };
    private CustomMessageListener awj = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eUa.faO != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eUa.faO.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.t(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener awk = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eUa.faO != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eUa.faO.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener eSL = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.eRH == null) {
                AlaMasterLiveRoomOpearator.this.eRH = new com.baidu.tieba.ala.liveroom.o.b(AlaMasterLiveRoomOpearator.this.bkg().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.eRH.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener eSS = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.eSm != null) {
                AlaMasterLiveRoomOpearator.this.eSm.vO();
            }
        }
    };
    private CustomMessageListener ffA = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSI = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.eUa.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.yN(str);
            }
        }
    };
    private CustomMessageListener eSJ = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aIc();
        }
    };
    private CustomMessageListener eTi = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.eRU.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSQ = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener ffB = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.ffu != null) {
                com.baidu.live.data.m yO = AlaMasterLiveRoomOpearator.this.bkg().fai.yO();
                long j = yO.mLiveInfo.live_id;
                long j2 = yO.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.ffu.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener ffC = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkg().faj);
            if (AlaMasterLiveRoomOpearator.this.fex == null || AlaMasterLiveRoomOpearator.this.fex.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qp(0);
            }
            if (AlaMasterLiveRoomOpearator.this.eRR != null) {
                AlaMasterLiveRoomOpearator.this.eRR.wq().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.eRR.wr().hide();
            }
        }
    };
    private CustomMessageListener eSR = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.p(AlaMasterLiveRoomOpearator.this.bkg().fai.yO());
        }
    };
    private CustomMessageListener eST = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eSe != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.eSe).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener ffD = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.ffv != null) {
                    AlaMasterLiveRoomOpearator.this.ffv.yR(str);
                }
            }
        }
    };
    private CustomMessageListener ffE = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (AlaMasterLiveRoomOpearator.this.ffw) {
                        AlaMasterLiveRoomOpearator.this.bkg().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.bkg().faI != null) {
                        AlaMasterLiveRoomOpearator.this.bkg().faI.setDefBeautyParams(data.VK);
                    }
                    if (AlaMasterLiveRoomOpearator.this.ffo != null) {
                        if (AlaMasterLiveRoomOpearator.this.ffx != null && AlaMasterLiveRoomOpearator.this.ffx == data.VM) {
                            if (!AlaMasterLiveRoomOpearator.this.ffy || AlaMasterLiveRoomOpearator.this.fex.getVisibility() == 0) {
                                AlaMasterLiveRoomOpearator.this.ffo.a(AlaMasterLiveRoomOpearator.this.bkg().faI.getVideoConfig());
                            }
                            AlaMasterLiveRoomOpearator.this.ffx = null;
                            AlaMasterLiveRoomOpearator.this.ffo.a(AlaMasterLiveRoomOpearator.this.bkg().faI.getVideoConfig(), AlaMasterLiveRoomOpearator.this.ffp);
                            if (!AlaMasterLiveRoomOpearator.this.ffp) {
                                AlaMasterLiveRoomOpearator.this.ffp = true;
                            }
                        }
                        AlaMasterLiveRoomOpearator.this.ffo.bly();
                    }
                }
                AlaMasterLiveRoomOpearator.this.ffw = false;
            }
        }
    };
    private View.OnClickListener ffF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.feO) {
                    AlaMasterLiveRoomOpearator.this.bnG();
                    AlaMasterLiveRoomOpearator.this.feY.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.feN) {
                    if (AlaMasterLiveRoomOpearator.this.eRR != null) {
                        AlaMasterLiveRoomOpearator.this.eRR.wr().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.feP) {
                    AlaMasterLiveRoomOpearator.this.aIc();
                } else if (view != AlaMasterLiveRoomOpearator.this.feQ) {
                    if (view == AlaMasterLiveRoomOpearator.this.feS) {
                        if (AlaMasterLiveRoomOpearator.this.feZ != null) {
                            AlaMasterLiveRoomOpearator.this.feZ.showDialog();
                            AlaMasterLiveRoomOpearator.this.feZ.bi(AlaMasterLiveRoomOpearator.this.bnK());
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eUi) {
                        if (AlaMasterLiveRoomOpearator.this.ffr != null) {
                            AlaMasterLiveRoomOpearator.this.ffr.bki();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.feR) {
                        if (AlaMasterLiveRoomOpearator.this.feC != null) {
                            com.baidu.tieba.ala.liveroom.data.h bpE = AlaMasterLiveRoomOpearator.this.bkg().fai.bpE();
                            if (bpE == null || bpE.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(bpE.mLiveSdkInfo.mRoomId);
                                if (bpE.mLiveSdkInfo.mCastIds != null) {
                                    str2 = bpE.mLiveSdkInfo.mCastIds.XX;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.feC.ad("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.feU) {
                        com.baidu.live.data.m yO = AlaMasterLiveRoomOpearator.this.bkg().fai.yO();
                        if (AlaMasterLiveRoomOpearator.this.eSb != null && yO != null && yO.mLiveInfo != null) {
                            String valueOf = String.valueOf(yO.mLiveInfo.live_id);
                            String valueOf2 = String.valueOf(yO.mLiveInfo.feed_id);
                            long j = yO.mLiveInfo.room_id;
                            String str3 = yO.mLiveInfo.cover;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (yO.mLiveInfo.session_info != null) {
                                str4 = yO.mLiveInfo.session_info.flvUrl;
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
                            AlaMasterLiveRoomOpearator.this.eSb.yR(o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.ffy = false;
                    AlaMasterLiveRoomOpearator.this.jB(true);
                }
            }
        }
    };
    private CustomMessageListener eSK = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    AlaMasterLiveRoomOpearator.this.eSu = true;
                    AlaMasterLiveRoomOpearator.this.feW = (x) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.eRR != null) {
                        AlaMasterLiveRoomOpearator.this.eRR.wq().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.eRR != null) {
                        AlaMasterLiveRoomOpearator.this.eRR.wr().show();
                        AlaMasterLiveRoomOpearator.this.eRR.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.qp(8);
                }
            }
        }
    };
    private CustomMessageListener ffG = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bkg() != null && AlaMasterLiveRoomOpearator.this.bkg().faM != null) {
                AlaMasterLiveRoomOpearator.this.bkg().faM.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener fdS = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bot();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bkg().fai.qw(i);
                if (AlaMasterLiveRoomOpearator.this.eSm != null) {
                    AlaMasterLiveRoomOpearator.this.eSm.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener eOK = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bom();
        }
    };
    public final HttpMessageListener ffH = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.yR()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.feY != null) {
                            AlaMasterLiveRoomOpearator.this.feY.jH(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.feY.boR();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bkg().faI.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.feE != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.feE.a(AlaMasterLiveRoomOpearator.this.bkg().rootView, AlaMasterLiveRoomOpearator.this.bkg().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bkg().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.feE.qD(2);
                        AlaMasterLiveRoomOpearator.this.feE.a(AlaMasterLiveRoomOpearator.this.bkg().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a ffI = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boA() {
            AlaMasterLiveRoomOpearator.this.boj();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boB() {
            AlaMasterLiveRoomOpearator.this.bok();
        }
    };
    com.baidu.live.liveroom.a.a ffJ = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        @Override // com.baidu.live.liveroom.a.a
        public boolean cc(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cd(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ce(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bkg().blM() == 1) {
                AlaMasterLiveRoomOpearator.this.bkg().faI.stopRecord();
            }
        }
    };
    private IShareCallback ffK = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.ffb && AlaMasterLiveRoomOpearator.this.ffa != null) {
                AlaMasterLiveRoomOpearator.this.ffb = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.ffa);
            }
        }
    };
    private View.OnTouchListener ffL = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bkg().faM.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkg().faj);
            AlaMasterLiveRoomOpearator.this.qp(0);
            if (AlaMasterLiveRoomOpearator.this.eRR != null) {
                AlaMasterLiveRoomOpearator.this.eRR.wq().getView().setVisibility(0);
            }
            return false;
        }
    };
    private e.b ffM = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boC() {
            AlaMasterLiveRoomOpearator.this.bnF();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boD() {
            AlaMasterLiveRoomOpearator.this.fee = AlaMasterLiveRoomOpearator.this.fex.blE();
            AlaMasterLiveRoomOpearator.this.bkg().faM.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bkg().faM.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bkg().faM.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.faC = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bkg().blM();
            eVar.title = AlaMasterLiveRoomOpearator.this.fex.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.faD = AlaMasterLiveRoomOpearator.this.fex.blF();
            eVar.faG = AlaMasterLiveRoomOpearator.this.fee;
            eVar.faF = AlaMasterLiveRoomOpearator.this.fex.blC();
            eVar.faE = AlaMasterLiveRoomOpearator.this.fex.blH();
            eVar.faH = AlaMasterLiveRoomOpearator.this.fex.blD();
            if (eVar.faH) {
                if (AlaMasterLiveRoomOpearator.this.fex.blI()) {
                    AlaMasterLiveRoomOpearator.this.ffb = true;
                    AlaMasterLiveRoomOpearator.this.ffa = eVar;
                    AlaMasterLiveRoomOpearator.this.fex.blJ();
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
            AlaMasterLiveRoomOpearator.this.bkg().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bkg().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boE() {
            AlaMasterLiveRoomOpearator.this.ffy = true;
            AlaMasterLiveRoomOpearator.this.jB(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean boF() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boG() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boH() {
            o.k(AlaMasterLiveRoomOpearator.this.eUa.pageContext.getPageActivity(), "", "");
        }
    };
    private com.baidu.live.liveroom.g.c ffN = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void yM() {
            if (AlaMasterLiveRoomOpearator.this.feC != null) {
                AlaMasterLiveRoomOpearator.this.feC.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.ffr != null) {
                        AlaMasterLiveRoomOpearator.this.ffr.d(AlaMasterLiveRoomOpearator.this.eUi);
                    }
                    if (AlaMasterLiveRoomOpearator.this.feZ != null) {
                        AlaMasterLiveRoomOpearator.this.feZ.bh(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.ffr != null) {
                        AlaMasterLiveRoomOpearator.this.ffr.bkj();
                    }
                    if (AlaMasterLiveRoomOpearator.this.feZ != null) {
                        AlaMasterLiveRoomOpearator.this.feZ.bh(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.feC != null) {
                    AlaMasterLiveRoomOpearator.this.feC.jR(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.eSe != null) {
                    AlaMasterLiveRoomOpearator.this.eSe.aB(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a ffO = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.feM != null && AlaMasterLiveRoomOpearator.this.bkg().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.feM) >= 0) {
                AlaMasterLiveRoomOpearator.this.bkg().rootView.removeView(AlaMasterLiveRoomOpearator.this.feM);
                AlaMasterLiveRoomOpearator.this.feM.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.feM = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRv = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            com.baidu.live.data.m yO;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bos();
            } else if (i == 14 && (yO = AlaMasterLiveRoomOpearator.this.bkg().fai.yO()) != null && yO.XQ != null && yO.mLiveInfo != null && yO.Ye != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity(), yO.XQ.userName, Long.toString(yO.XQ.userId), Long.toString(yO.XQ.charmCount), String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), true, String.valueOf(yO.XQ.userId), Long.toString(yO.Ye.userId), yO.Ye.userName, yO.Ye.portrait, AlaMasterLiveRoomOpearator.this.eQU.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(yO.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.eQU.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener ffP = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.ffs = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fgR;
            }
        }
    };
    private HttpMessageListener ffQ = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.feV.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.feV.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.feV.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.feV.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.awN = getVideoGoodsListHttpResponseMessage.awN;
            }
        }
    };
    private HttpMessageListener ffR = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awI != null && !eventPollingHttpResponseMessage.awI.isEmpty() && AlaMasterLiveRoomOpearator.this.bkg().fai != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.currentTime;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.awI.size()) {
                            break;
                        }
                        af afVar = eventPollingHttpResponseMessage.awI.get(i2);
                        if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                            com.baidu.live.utils.m.a(afVar, AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo);
                            com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                        }
                        i = i2 + 1;
                    }
                    af afVar2 = eventPollingHttpResponseMessage.awI.get(eventPollingHttpResponseMessage.awI.size() - 1);
                    if (j == afVar2.liveId) {
                        com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.awH;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bkg().fai != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null && AlaMasterLiveRoomOpearator.this.bkg().fai != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                com.baidu.live.utils.m.i(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a ffS = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
    };
    private com.baidu.live.liveroom.middleware.g ffT = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.Vi);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        feu = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zl().awB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bkg().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zl().awB.aaT, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkg().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bkg().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zl().awB.aar;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bkg().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bkg().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bkg().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.ffr != null) {
            this.ffr.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnF() {
        if (bkg() != null && bkg().fai != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bkg().fai.bpw();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bkg().fai.bpx();
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
                    AlaMasterLiveRoomOpearator.this.ffd = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.ffd = false;
                }
                if (AlaMasterLiveRoomOpearator.this.ffe == 0) {
                    AlaMasterLiveRoomOpearator.this.ffe = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.fff == 0) {
                    AlaMasterLiveRoomOpearator.this.fff = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.ffg = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bkg() != null && bkg().faK != null) {
            bkg().faK.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.eUa = fVar;
        this.eOz = str;
    }

    protected f bkg() {
        return this.eUa;
    }

    public int a(g gVar) {
        this.eUj = gVar;
        this.ffc = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.ffc, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.feE == null) {
            this.feE = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUa.pageContext, null);
        }
        registerListener();
        this.ePY = new com.baidu.live.g.a();
        bnU();
        Long[] lArr = new Long[1];
        this.ffh = lArr[0] == null ? 0L : lArr[0].longValue();
        this.ffi = lArr[0] != null ? lArr[0].longValue() : 0L;
        bkg().faj.setOnTouchListener(this.ffL);
        this.fev = SharedPrefHelper.getInstance().getBoolean(feu, false);
        this.feF = new AlaLiveCountDownView(bkg().pageContext.getPageActivity());
        this.feF.setCount(3);
        this.feF.setTextColor(bkg().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.feF.setTextSize(bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.feF.setTypeface(Typeface.DEFAULT_BOLD);
        this.feF.setIncludeFontPadding(false);
        this.feF.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void boI() {
                if (AlaMasterLiveRoomOpearator.this.bkg().faj != null) {
                    AlaMasterLiveRoomOpearator.this.bkg().faj.removeView(AlaMasterLiveRoomOpearator.this.feF);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnG() {
        if (this.feY == null) {
            this.feY = new com.baidu.tieba.ala.liveroom.master.panel.b(bkg().pageContext.getPageActivity(), bkg().blM() == 2);
            this.feY.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkg().faI.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jD(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkg().faI.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jE(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkg().faI.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bor();
                    if (AlaMasterLiveRoomOpearator.this.feE != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.feE.a(AlaMasterLiveRoomOpearator.this.bkg().rootView, AlaMasterLiveRoomOpearator.this.bkg().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.feE.a(AlaMasterLiveRoomOpearator.this.bkg().rootView, AlaMasterLiveRoomOpearator.this.bkg().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jF(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boJ() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bkg().fai != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boK() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bkg().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boL() {
                    if (AlaMasterLiveRoomOpearator.this.bkg() != null && AlaMasterLiveRoomOpearator.this.bkg().fai != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.bkg().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.feY != null) {
                            AlaMasterLiveRoomOpearator.this.feY.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boM() {
                    long j = (AlaMasterLiveRoomOpearator.this.bkg() == null || AlaMasterLiveRoomOpearator.this.bkg().fai == null || AlaMasterLiveRoomOpearator.this.bkg().fai.yO() == null || AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bkg() != null && AlaMasterLiveRoomOpearator.this.bkg().fai != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eUa.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.feY != null) {
                                        AlaMasterLiveRoomOpearator.this.feY.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eUa.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.feY != null) {
                        AlaMasterLiveRoomOpearator.this.feY.dismiss();
                    }
                }
            });
        }
        bnH();
    }

    private void bnH() {
        if (this.feY != null) {
            boolean isBackCamera = bkg().faI.isBackCamera();
            this.feY.jG(bkg().faI.isBackCamera());
            this.feY.F(bkg().faI.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bkg().faI.isPushMirror();
            if (this.ffm) {
                isPushMirror = boq() || isPushMirror;
                this.ffm = false;
            }
            this.feY.G(isPushMirror, isBackCamera ? false : true);
            this.feY.jH(bkg().faI.isMute());
            this.feY.boR();
        }
    }

    public void bnI() {
        if (this.eUj != null) {
            if (this.eUj.faP == null || this.eUj.faP.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.feL == null) {
                        this.feL = this.eUa.faO.yw();
                        this.eUa.rootView.addView(this.feL, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.fex == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bkg().fai != null && bkg().fai.yO() != null && bkg().fai.yO().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bkg().fai.yO().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bkg().fai.yO().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.fex = new d(bkg().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bkg().faM.prepareTime = System.currentTimeMillis();
                    bkg().rootView.addView(this.fex.getView(), layoutParams);
                    this.fex.a(this.ffK);
                }
                this.fex.jn(this.faF);
                this.fex.a(this.ffM);
                this.fex.a(this.ffI);
                this.fex.a(bkg().faI, bkg().blM());
                return;
            }
            this.fee = this.eUj.faP.mLiveInfo.screen_direction == 2;
            if (this.eUj.faP.mLiveInfo.isAudioOnPrivate == 1) {
                bkg().faI.setMute(true);
                if (this.feE == null) {
                    this.feE = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUa.pageContext, null);
                }
                if (!this.feE.qC(2)) {
                    this.feE.a(bkg().rootView, bkg().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.faC = true;
            eVar.forumId = String.valueOf(this.eUj.faP.mLiveInfo.forum_id);
            eVar.forumName = this.eUj.faP.mLiveInfo.forum_name;
            eVar.liveType = this.eUj.faP.mLiveInfo.live_type;
            eVar.title = this.eUj.faP.mLiveInfo.getLiveTitle();
            eVar.clarity = this.eUj.faP.mLiveInfo.clarity;
            eVar.gameId = this.eUj.faP.mLiveInfo.game_id;
            eVar.gameName = this.eUj.faP.mLiveInfo.game_label;
            eVar.faG = this.eUj.faP.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bnJ() {
        if (this.ffo != null) {
            this.ffo.a(bkg().faI.getVideoConfig(), false);
            this.ffo.bly();
        }
        if (this.fex != null) {
            this.fex.jm(true);
        }
        if (bkg().faI.hasBeauty() >= 0) {
            bkg().faI.setBeauty(com.baidu.live.c.pr().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bkg().faO.C(this.eUa.faI);
        } else if (this.fex != null) {
            this.fex.jm(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.feL != null && this.feL.getParent() != null) {
                ((ViewGroup) this.feL.getParent()).removeView(this.feL);
                this.feL = null;
            }
            bkg().faj.setVisibility(0);
            this.eUa.faO.a(bkg().faj);
        } else {
            bnZ();
            bop();
            this.feC = new com.baidu.tieba.ala.liveroom.u.a(bkg().pageContext, this.ffJ);
            this.feC.d(bkg().faj, true);
            this.feC.jR(true);
            if (this.eRR != null && this.eRR.wq() != null) {
                this.eRR.wq().setNeedTopAlphaShade(true);
            }
        }
        bkg().faI.setPushMirror(boq());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUa.faO.j(bkg().fai.yO());
        }
        if (!bkg().faI.isBackground() && bkg().fai.yO() != null && bkg().fai.yO().mLiveInfo != null) {
            int startPush = bkg().faI.startPush(bkg().fai.yO().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eUa.faO.yx();
            }
            if (startPush != 0 && bkg().faM != null) {
                bkg().faM.errCode = 4;
                bkg().faM.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.blR() && !bon()) {
                jC(true);
                boo();
            }
            if (this.fez != null) {
                this.fez.q(bkg().fai.yO());
            }
            if (this.eQQ != null) {
                this.eQQ.u(bkg().fai.yO());
            }
            if (this.eRF != null) {
                this.eRF.a(bkg().fai.yO());
            }
            if (this.feA != null && bkg() != null && bkg().fai != null) {
                if (this.feA.ag(bkg().faj)) {
                    this.feA.o(bkg().fai.yO());
                } else {
                    this.feA.b(bkg().faj, bkg().fai.yO());
                }
            }
            if (this.fey != null) {
                this.fey.u(bkg().fai.yO());
            }
            if (hVar == null || hVar.XQ == null) {
                z = com.baidu.live.c.pr().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.XQ.canUseChallenge;
                com.baidu.live.c.pr().putBoolean("ala_master_can_use_challenge", z);
            }
            boa();
            bnN();
            jz(z);
            bob();
            bog();
            bjh();
            bjv();
            v(bkg().fai.yO());
            f(bkg().fai.yO());
            boh();
            boi();
            boe();
            bjj();
            bjq();
            bjr();
            if (this.eRQ != null) {
                this.eRQ.g(bkg().fai.yO());
            }
            if (this.eRR != null) {
                this.eRR.e(String.valueOf(bkg().fai.yO().mLiveInfo.group_id), String.valueOf(bkg().fai.yO().mLiveInfo.last_msg_id), String.valueOf(bkg().fai.yO().XQ.userId), String.valueOf(bkg().fai.yO().mLiveInfo.live_id), bkg().fai.yO().XQ.appId);
            }
            if (this.eRS != null) {
                this.eRS.a(bkg().fai.yO(), true);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                com.baidu.live.utils.m.i(bkg().fai.yO().mLiveInfo.user_id, bkg().fai.yO().mLiveInfo.live_id);
            }
            this.mHandler.post(this.ffz);
        }
    }

    private void jz(boolean z) {
        if (this.ffr == null) {
            this.ffr = new com.baidu.tieba.ala.liveroom.challenge.f(bkg());
        }
        this.ffr.a(this.eUi, this.eUj);
        this.ffr.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ad adVar, ae aeVar, ae aeVar2) {
                if (AlaMasterLiveRoomOpearator.this.eRJ != null) {
                    AlaMasterLiveRoomOpearator.this.eRJ.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bkg().faj.fnc = false;
                AlaMasterLiveRoomOpearator.this.bnL();
                if (AlaMasterLiveRoomOpearator.this.eSo != null) {
                    AlaMasterLiveRoomOpearator.this.eSo.b(AlaMasterLiveRoomOpearator.this.jA(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void pR() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.ffz);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bke() {
                if (AlaMasterLiveRoomOpearator.this.eRJ != null) {
                    AlaMasterLiveRoomOpearator.this.eRJ.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bkg().faj.fnc = true;
                AlaMasterLiveRoomOpearator.this.bnM();
                if (AlaMasterLiveRoomOpearator.this.eSo != null) {
                    AlaMasterLiveRoomOpearator.this.eSo.b(AlaMasterLiveRoomOpearator.this.jA(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bkf() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.ffz);
            }
        });
        this.ffr.C(this.fee, z);
        this.ffr.h(this.fee, z, (this.eUj == null || this.eUj.faP == null || this.eUj.faP.mChallengeData == null) ? false : true);
    }

    public boolean bnK() {
        return this.ffr != null && this.ffr.bkl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnL() {
        if (this.feD != null) {
            this.feD.setVisible(8);
            this.feD.setCanVisible(false);
        }
        if (this.eQW != null) {
            this.eQW.iM(true);
            jf(true);
        }
        if (this.feG != null) {
            this.feG.setCanVisible(false);
            this.feG.setVisibility(4);
        }
        if (this.feC != null) {
            this.feC.jQ(false);
        }
        if (this.eRR != null) {
            this.eRR.wq().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnM() {
        if (this.feD != null) {
            this.feD.setCanVisible(true);
        }
        if (this.eQW != null) {
            this.eQW.iM(false);
            jf(false);
        }
        if (this.feG != null) {
            this.feG.setCanVisible(true);
        }
        if (this.feC != null) {
            this.feC.jQ(true);
        }
        if (this.eRR != null) {
            this.eRR.wq().setNeedTopAlphaShade(false);
        }
    }

    private void jf(boolean z) {
        ViewGroup.LayoutParams pQ;
        if (this.eQW != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.eQW;
            AlaLiveView alaLiveView = bkg().faj;
            if (z) {
                pQ = boz();
            } else {
                pQ = pQ(1);
            }
            bVar.a(1, alaLiveView, pQ, 21);
            this.eQW.updateView();
        }
    }

    private void bnN() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.feG == null) {
            this.feG = new AlaLiveStreamStatusView(bkg().pageContext.getPageActivity());
        }
        this.feG.setId(a.g.ala_live_room_stream_view);
        this.feG.setVisibility(4);
        this.feG.setLayoutParams(layoutParams);
        if (this.feG.getParent() == null) {
            bkg().faj.addView(this.feG, layoutParams);
        }
    }

    public void bnO() {
        if (this.fex != null && this.fex.getVisibility() != 8 && bkg().faI.getPreview() != null) {
            bkg().faI.stopRecord();
        }
    }

    public void bnP() {
        if (bkg().faI.getPreview() != null) {
            bkg().faI.stopRecord();
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.ffo != null) {
                this.ffo.jl(false);
            }
            this.ffo = new com.baidu.tieba.ala.liveroom.g.b(bkg().rootView, bkg(), bkg().faI);
            this.ffo.a(bkg().faI.getVideoConfig(), false);
            this.ffo.bly();
        }
        if (this.feE != null) {
            this.feE.bqA();
        }
        this.mHandler.post(this.ffz);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.few = z;
        if (z) {
            Rect rect = new Rect();
            bkg().faj.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            bkg().faj.getGlobalVisibleRect(rect2);
            if (this.eRR != null && this.eRR.wq() != null) {
                this.eRR.wq().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRR.wq().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.eRR.wq().getView().setLayoutParams(layoutParams);
            }
            if (this.eRR != null && this.eRR.wr() != null) {
                int i = rect2.bottom - rect.bottom;
                this.eRR.wr().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRR.wr().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.eRR.wr().getView().setLayoutParams(layoutParams2);
                this.eRR.wr().getView().setVisibility(0);
            }
            qp(8);
            qo(8);
        } else {
            if (this.eRR != null && this.eRR.wq() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eRR.wq().getView().getLayoutParams();
                layoutParams3.bottomMargin = bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.eRR.wq().getView().setLayoutParams(layoutParams3);
            }
            if (this.eRR != null && this.eRR.wr() != null) {
                this.eRR.wr().hide();
            }
            qp(0);
            qo(0);
        }
        if (this.fex != null) {
            this.fex.E(false, z);
        }
        if (this.eRS != null) {
            this.eRS.wy();
        }
        if (this.feZ != null) {
            this.feZ.onKeyboardVisibilityChanged(z);
        }
        if (this.eRR != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bkg().pageContext.getPageActivity())) + bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (bkg().faj.indexOfChild(this.eRR.wq().getView()) != -1 && this.eRR.wq().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eRR.wq().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.eRR.wq().getView().setLayoutParams(layoutParams4);
            }
            this.eRR.wq().wp();
        }
        this.mHandler.post(this.ffz);
    }

    private void qo(int i) {
        if (this.eQQ != null) {
            this.eQQ.qb(i);
        }
        if (this.feI != null) {
            this.feI.setVisibility(i);
        }
        if (this.eRF != null) {
            this.eRF.getView().setVisibility(i);
        }
        if (this.feB != null) {
            this.feB.setVisible(i);
        }
        if (this.feA != null) {
            this.feA.setVisibility(i);
        }
        if (this.eQW != null) {
            this.eQW.setVisible(i);
        }
        if (this.eSo != null) {
            this.eSo.setCanVisible(i == 0);
        }
        if (this.eSc != null) {
            this.eSc.setVisible(i);
        }
        if (this.eSm != null) {
            this.eSm.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bkg().faM.errCode = 1;
            boj();
        } else if (i == -5) {
            bok();
        } else if (i == -2) {
            ze(bkg().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bkg().faI.stopRecord();
        } else if (i == -3 && this.fex != null) {
            this.fex.jm(false);
        }
        if (i == -4) {
            if (this.fex == null || this.fex.getView().getParent() == null) {
                bkg().f((short) 1);
                return;
            }
            this.fex.blG();
            this.feQ.setVisibility(0);
            if (this.feC != null) {
                this.feC.jR(true);
            }
            bkg().faj.setBackgroundColor(bkg().pageContext.getResources().getColor(17170445));
            bow();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bjG();
        if (i == 12001) {
            if (i2 == -1) {
                zf(ac(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                ad(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aIc();
        }
    }

    public void onResume() {
        if (this.fex != null) {
            this.fex.onResume();
        }
        if (this.ffb && this.ffa != null) {
            this.ffb = false;
            c(this.ffa);
        }
        if (this.eSe != null) {
            this.eSe.onResume();
        }
    }

    public void g(short s) {
        if (this.eRQ != null) {
            this.eRQ.sL();
        }
        if (this.eRR != null) {
            this.eRR.a(null);
            this.eRR.vW();
        }
        if (this.eRS != null) {
            this.eRS.vW();
        }
        if (this.ffr != null) {
            this.ffr.bkk();
        }
    }

    public boolean bnQ() {
        com.baidu.live.data.m yO = bkg().fai.yO();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUa.faO.i(yO);
            if (yO != null && yO.mLiveInfo.live_status != 1) {
                bou();
                bkg().pageContext.getPageActivity().finish();
                if (bkg().fai != null && bkg().fai.yO() != null) {
                    a(yO, 1, bkg().fai.bpO() != 1 ? bkg().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.eRR != null) {
                this.eRR.wq().a(String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), true, String.valueOf(yO.XQ.userId));
            }
            if (this.eRS != null) {
                this.eRS.a(yO);
            }
            if (this.eRF != null) {
                this.eRF.a(bkg().fai.yO());
            }
            if (this.eQQ != null) {
                this.eQQ.u(yO);
            }
            if (yO != null) {
                if (this.fez != null) {
                    this.fez.q(yO);
                }
                if (this.ffr != null) {
                    this.ffr.a(yO);
                }
                if (this.eRU != null && yO.mLiveInfo != null) {
                    this.eRU.a(yO.mLiveInfo);
                }
                if (this.eSo != null) {
                    this.eSz = this.eSo.m(yO);
                }
                if (this.eQW != null) {
                    this.eQW.iN(this.eSz);
                    this.eQW.h(yO);
                    this.eQW.updateView();
                }
                if (this.eSm != null) {
                    this.eSm.a(yO);
                }
                if (yO.mLiveInfo.live_status != 1) {
                    bou();
                    bkg().pageContext.getPageActivity().finish();
                    if (bkg().fai != null && bkg().fai.yO() != null) {
                        a(yO, 1, bkg().fai.bpO() != 1 ? bkg().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.ffs) {
                    this.feT.setVisibility(0);
                    if (!this.ffq && yO.mLiveInfo != null) {
                        this.ffq = true;
                        o.g(yO.mLiveInfo.feed_id, yO.mLiveInfo.live_id);
                    }
                } else {
                    this.feT.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bnR() {
        bnH();
    }

    public void bnS() {
        if (this.ffo != null) {
            this.ffo.blz();
        }
    }

    public void bnT() {
        if (this.fex != null && this.fex.getVisibility() != 8) {
            if (bkg().blM() == 2) {
                bow();
            } else {
                bov();
            }
        }
        if (this.fex != null && this.fex.getVisibility() != 8) {
            if (bkg().blM() == 1) {
                this.fex.onResume();
            }
            this.fex.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.eSu && this.feW != null) {
            if (this.eRR != null) {
                this.eRR.wq().getView().setVisibility(0);
            }
            if (this.eRR != null) {
                this.eRR.wr().show();
                this.eRR.wr().setEditText(" @" + this.feW.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            qp(8);
            this.eSu = false;
        }
        if (this.eSb != null) {
            this.eSb.resume();
        }
        if (this.ffu != null) {
            this.ffu.resume();
        }
        if (this.ffv != null) {
            this.ffv.resume();
        }
    }

    public void onPause() {
        if (this.eSb != null) {
            this.eSb.pause();
        }
        if (this.ffu != null) {
            this.ffu.pause();
        }
        if (this.eSe != null) {
            this.eSe.onPause();
        }
        if (this.ffv != null) {
            this.ffv.pause();
        }
    }

    private void bnU() {
        this.feH = (RelativeLayout) bkg().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.feJ = (RelativeLayout) bkg().rootView.findViewById(a.g.under_live_view_panel);
        this.feK = (RelativeLayout) bkg().rootView.findViewById(a.g.over_live_view_panel);
        this.eUa.faj.setOnLiveViewScrollListener(this.ffN);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.feJ.setVisibility(8);
            this.feK.setVisibility(8);
            bkg().faj.removeAllViews();
        } else {
            this.feI = (RelativeLayout) bkg().rootView.findViewById(a.g.ala_live_removeable_top_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.feI.getLayoutParams();
            layoutParams.topMargin = this.eUa.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.eUa.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
            }
            this.feI.setLayoutParams(layoutParams);
            if (this.eQU == null) {
                this.eQU = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.eUa.pageContext.getPageActivity(), false);
            }
            this.eQU.a(this.eRv);
            this.eQU.a(this.feI, a.g.ala_live_room_host_header_stub, 1L);
            this.eQU.setVisible(0);
            this.feQ = (ImageView) bkg().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
            this.feQ.setOnClickListener(this.ffF);
            this.feS = (ImageView) bkg().rootView.findViewById(a.g.ala_liveroom_host_paster);
            this.feS.setOnClickListener(this.ffF);
            if (com.baidu.live.v.a.zl().axC != null && com.baidu.live.v.a.zl().axC.acQ != null && com.baidu.live.v.a.zl().axC.acQ.qI() && an.b(com.baidu.live.v.a.zl().axC)) {
                this.feS.setVisibility(0);
            } else {
                this.feS.setVisibility(8);
            }
            if (an.c(com.baidu.live.v.a.zl().axC)) {
                this.feQ.setVisibility(0);
                if (an.c(com.baidu.live.v.a.zl().axC)) {
                    this.feQ.setAlpha(0.2f);
                }
            } else if (bkg().faI.hasBeauty() < 0) {
                this.feQ.setVisibility(8);
            } else {
                if (an.c(com.baidu.live.v.a.zl().axC)) {
                    this.feQ.setAlpha(0.2f);
                }
                com.baidu.live.c.pr().getInt("live_beauty_level", 3);
            }
            this.feP = (ImageView) bkg().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
            this.feP.setOnClickListener(this.ffF);
            this.feN = (ImageView) bkg().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
            this.feN.setOnClickListener(this.ffF);
            this.eUi = (ImageView) bkg().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
            this.eUi.setOnClickListener(this.ffF);
            this.feO = (ImageView) bkg().rootView.findViewById(a.g.ala_liveroom_host_more);
            this.feO.setOnClickListener(this.ffF);
            this.feR = (ImageView) bkg().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
            this.feR.setOnClickListener(this.ffF);
            this.feT = bkg().rootView.findViewById(a.g.host_goods_layout);
            this.feU = (ImageView) bkg().rootView.findViewById(a.g.host_goods_imageView);
            this.feV = (TextView) bkg().rootView.findViewById(a.g.host_goods_num_textView);
            this.feU.setOnClickListener(this.ffF);
            bnY();
            bnX();
            this.ffo = new com.baidu.tieba.ala.liveroom.g.b(bkg().rootView, bkg(), bkg().faI);
            this.eRQ = new m();
            bnV();
            bnW();
            if (this.eRT != null && this.eRT.sk() != null) {
                this.eRT.sk().bringToFront();
            }
        }
        this.ffo = new com.baidu.tieba.ala.liveroom.g.b(bkg().rootView, bkg(), bkg().faI);
    }

    private void bnV() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, bkg().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eRR = (i) runTask.getData();
            this.eRR.setFromMaster(true);
            this.eRR.wq().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bkg().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(bkg().pageContext.getPageActivity()) * 0.27f)) + bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            bkg().faj.addView(this.eRR.wq().getView(), layoutParams);
            this.eRR.wr().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bkg().faj.addView(this.eRR.wr().getView(), layoutParams2);
            this.eRR.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.live.im.i.a
                public boolean ws() {
                    return true;
                }

                @Override // com.baidu.live.im.i.a
                public void wt() {
                }

                @Override // com.baidu.live.im.i.a
                public void dM(String str) {
                }

                @Override // com.baidu.live.im.i.a
                public void wu() {
                }

                @Override // com.baidu.live.im.i.a
                public void wv() {
                }

                @Override // com.baidu.live.im.i.a
                public boolean ww() {
                    return false;
                }
            });
        }
    }

    private void bnW() {
        View wx;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, j.class, bkg().pageContext);
        if (runTask != null) {
            this.eRS = (j) runTask.getData();
        }
        if (this.eRS != null && (wx = this.eRS.wx()) != null && this.eUa.faj.indexOfChild(wx) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.eUa.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bkg().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bkg().faj.addView(wx, layoutParams);
        }
    }

    private void bnX() {
        CustomResponsedMessage runTask;
        if (this.feX == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bkg().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.feX = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bnY() {
        View sk;
        t.b(bkg().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.afH = true;
        fVar.context = bkg().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.eRT = (u) runTask.getData();
            if (this.eRT != null && (sk = this.eRT.sk()) != null && bkg().faj.indexOfChild(sk) < 0) {
                if (sk.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sk.getParent()).removeView(sk);
                }
                bkg().faj.addView(sk, bkg().faj.getLayoutParams());
            }
        }
    }

    protected void bjr() {
        View sC;
        if (this.eRU == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afH = true;
            aVar.context = bkg().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eRU = (s) runTask.getData();
            }
        }
        if (this.eRU != null && (sC = this.eRU.sC()) != null) {
            if (bkg().faj.indexOfChild(sC) < 0) {
                if (sC.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sC.getParent()).removeView(sC);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bkg().faj.addView(sC, layoutParams);
            }
            sC.bringToFront();
        }
    }

    protected void bjq() {
        View sM;
        if (this.eSe == null) {
            z zVar = new z();
            zVar.afH = true;
            zVar.pageContext = bkg().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSe = (w) runTask.getData();
            }
        }
        if (this.eSe != null && (sM = this.eSe.sM()) != null && bkg().faj.indexOfChild(sM) < 0) {
            if (sM.getParent() instanceof ViewGroup) {
                ((ViewGroup) sM.getParent()).removeView(sM);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bkg().faj.addView(sM, layoutParams);
        }
    }

    private void bnZ() {
        bod();
        biv();
        boc();
        bkg().faj.setVisibility(0);
        qp(0);
    }

    private void boa() {
        if (this.feB == null) {
            this.feB = new com.baidu.tieba.ala.liveroom.r.a(bkg().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.feB.a(bkg().blM(), j, TbadkCoreApplication.getCurrentAccountName(), true, bkg().fai.yO().XQ.portrait, this.otherParams, "", -1L);
        this.feB.af(bkg().faj);
    }

    private void bob() {
        if (this.feZ == null) {
            com.baidu.live.w.a eG = eG(bkg().pageContext.getPageActivity());
            if (eG != null) {
                this.feZ = eG;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bkg().pageContext.getPageActivity());
                if (runTask != null) {
                    this.feZ = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.feZ != null) {
                this.feZ.h(this.feJ);
                this.feZ.i(this.feK);
                this.feZ.ci((bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.eRJ != null) {
                    this.feZ.ch(this.eRJ.bru());
                }
                this.feZ.j(bkg().faj);
                this.feZ.a(this.ePY);
                this.feZ.n(bkg().fai.yO());
                this.feZ.a(this.eQW);
                this.feZ.a(new a.InterfaceC0105a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
                });
            }
        }
    }

    private com.baidu.live.w.a eG(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aF(context);
        }
        return null;
    }

    private void boc() {
        if (this.feD == null) {
            this.feD = new b(bkg().pageContext, bkg().faj);
        }
    }

    private void bod() {
        if (this.eQQ == null) {
            this.eQQ = new com.baidu.tieba.ala.liveroom.l.a(bkg().pageContext, true, this.ffJ);
            this.eQQ.c(this.feH, (com.baidu.live.data.m) null);
            this.eQQ.a(this.eRv);
        }
        if (this.fey == null) {
            this.fey = new com.baidu.tieba.ala.liveroom.l.a(bkg().pageContext, true, null);
            this.fey.a(this.feI, null, a.g.ala_live_room_host_header_stub);
            this.fey.bmY();
        }
    }

    protected void bja() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bpE = bkg().fai.bpE();
        boolean z2 = com.baidu.live.v.a.zl().awB.aaS;
        if (bpE == null || bpE.Yo) {
            z = z2;
        }
        if (z && this.eRF == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bkg().pageContext)) != null) {
            this.eRF = (com.baidu.live.h.a) runTask.getData();
            if (this.eRF != null) {
                this.eRF.setIsHost(true);
                this.eRF.bV(1);
                View view = this.eRF.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bkg().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bkg().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.feI.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(com.baidu.live.data.m mVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.eQW == null) {
            this.eQW = new com.baidu.tieba.ala.liveroom.activeview.b(bkg().pageContext);
        }
        this.eQW.setOtherParams(this.otherParams);
        this.eQW.b(mVar, false);
        this.eQW.setHost(true);
        this.eQW.a(1, bkg().faj, pQ(1));
        this.eQW.a(2, bkg().faj, pQ(2));
        this.eQW.iN(this.eSz);
        this.eQW.setVisible(this.few ? 8 : 0);
        this.eQW.a(this.ePY);
        if (this.ePY != null) {
            if (this.eQW != null) {
                alaActiveRootView2 = this.eQW.pL(1);
                alaActiveRootView = this.eQW.pL(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.ePY.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.ePY.a(alaActiveRootView);
            }
        }
    }

    private void v(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        if (this.eSo == null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bkg().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSo = (com.baidu.live.q.a) runTask.getData();
            if (this.eSo != null) {
                this.eSo.a(bkg().faj, jA(false));
            }
        }
        if (this.eSo != null) {
            this.eSz = this.eSo.m(mVar);
            this.eSo.setCanVisible(!this.few);
        }
    }

    protected void boe() {
        CustomResponsedMessage runTask;
        if (bkg() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bkg().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSm = (com.baidu.live.i.a) runTask.getData();
            this.eSm.a(bkg().faj, bof());
            if (bkg().fai != null) {
                this.eSm.a(bkg().fai.yO());
            }
            this.eSm.setCanVisible(true);
            this.eSm.aP(false);
            this.eSm.a(bkg().fai.bdY());
        }
    }

    private void bjj() {
        this.ffv = new com.baidu.tieba.ala.liveroom.n.c(bkg().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bof() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bkg().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.feG != null) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams pQ(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bkg().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.feG != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bkg().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup.LayoutParams jA(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bkg().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.ffr != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.ffr.au(true) + bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.feG != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void biv() {
        if (this.feA == null) {
            this.feA = new com.baidu.tieba.ala.liveroom.b.a(bkg().pageContext, true);
        }
    }

    private void bog() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bkg().pageContext.getPageActivity();
            this.eTv = new ImageView(pageActivity);
            this.eTv.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.eTv.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eTv.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bkg().rootView.addView(this.eTv, layoutParams);
            this.eTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bos();
                }
            });
            this.eTv.setVisibility(8);
        }
    }

    private void bjh() {
        this.eSb = new com.baidu.tieba.ala.liveroom.f.a(bkg().pageContext);
    }

    private void bjv() {
        if (this.eSc == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bkg().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSc = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.eSc.setHost(true);
        this.eSc.setOtherParams(this.otherParams);
        if (bkg().fai.yO() != null && bkg().fai.yO().XQ != null && bkg().fai.yO().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.eSc.a(bkg().faj, layoutParams, bkg().fai.yO());
        }
    }

    private void boh() {
        CustomResponsedMessage runTask;
        if (this.fft == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bkg().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.fft = (com.baidu.live.b.a) runTask.getData();
            if (this.fft != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bkg().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fft.a(bkg().faj, layoutParams);
            }
        }
        if (this.fft != null) {
            this.fft.a(bkg().fai.yO());
        }
    }

    private void boi() {
        CustomResponsedMessage runTask;
        if (this.ffu == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bkg().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.ffu = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.ffr != null) {
            this.ffr.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bkg().pageContext.registerListener(this.eSI);
        bkg().pageContext.registerListener(this.ffA);
        bkg().pageContext.registerListener(this.eSK);
        bkg().pageContext.registerListener(this.eSL);
        bkg().pageContext.registerListener(this.ffG);
        bkg().pageContext.registerListener(this.fdS);
        bkg().pageContext.registerListener(this.eOK);
        bkg().pageContext.registerListener(this.ffH);
        bkg().pageContext.registerListener(this.eSJ);
        bkg().pageContext.registerListener(this.eTi);
        bkg().pageContext.registerListener(this.ffP);
        bkg().pageContext.registerListener(this.ffQ);
        bkg().pageContext.registerListener(this.ffR);
        bkg().pageContext.registerListener(this.eSQ);
        bkg().pageContext.registerListener(this.ffE);
        bkg().pageContext.registerListener(this.ffB);
        bkg().pageContext.registerListener(this.awj);
        bkg().pageContext.registerListener(this.awk);
        bkg().pageContext.registerListener(this.ffC);
        bkg().pageContext.registerListener(this.eSS);
        bkg().pageContext.registerListener(this.eSR);
        bkg().pageContext.registerListener(this.eST);
        bkg().pageContext.registerListener(this.ffD);
        bkg().pageContext.registerListener(this.ffC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jB(boolean z) {
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (an.c(com.baidu.live.v.a.zl().axC)) {
                bkg().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
                return;
            } else if (bkg().faL.pA() == null || ListUtils.isEmpty(bkg().faL.pA().VJ) || bkg().faL.pA().VK == null || bkg().faL.pA().VK.isEmpty()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    bkg().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
                    return;
                } else if (!this.ffw) {
                    this.ffx = BdUniqueId.gen();
                    bkg().faL.a(this.ffx);
                    this.ffw = true;
                    return;
                } else {
                    return;
                }
            }
        }
        BdUtilHelper.hideSoftKeyPad(bkg().pageContext.getPageActivity(), bkg().rootView);
        qp(8);
        if (bkg().faI.hasAdvancedBeauty() && this.ffo != null) {
            if (!this.ffy || this.fex.getVisibility() == 0) {
                this.ffo.a(bkg().faI.getVideoConfig());
            }
            this.ffo.a(bkg().faI.getVideoConfig(), this.ffp);
            if (!this.ffp) {
                this.ffp = true;
            }
        }
        if (z && this.eRR != null) {
            this.eRR.wq().getView().setVisibility(8);
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
    public void boj() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkg().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bkg().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkg().f((short) 1);
            }
        });
        bdAlertDialog.create(bkg().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bok() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkg().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bkg().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkg().f((short) 1);
            }
        });
        bdAlertDialog.create(bkg().pageContext).show();
    }

    private void ze(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkg().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkg().f((short) 1);
            }
        });
        bdAlertDialog.create(bkg().pageContext).show();
    }

    public void bol() {
        bja();
        com.baidu.live.data.h bdY = bkg().fai.bdY();
        int i = 5;
        if (bdY != null) {
            i = (int) bdY.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null && AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bkg().fai.cX(AlaMasterLiveRoomOpearator.this.bkg().fai.yO().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bdY != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eUa.faO.b(bdY);
                return;
            }
            if (this.eQP == null) {
                this.eQP = new c(bkg().pageContext, this.ffJ, true);
            }
            if (this.ffn) {
                this.ffn = false;
                this.eQP.a(String.valueOf(bkg().fai.yO().mLiveInfo.group_id), String.valueOf(bkg().fai.yO().mLiveInfo.live_id), String.valueOf(bkg().fai.yO().XQ.userId), bkg().fai.yO());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.eRF != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.eQP.c(this.feI, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.eQP.f(bdY);
            this.eQU.setVisible(0);
            this.eQU.cD(bdY.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bom() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIc() {
        if (bkg().fai != null) {
            if (this.eRG == null) {
                this.eRG = new com.baidu.tieba.ala.liveroom.share.c(bkg().pageContext);
            }
            this.eRG.c(bkg().fai.yO(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bkg().fai != null && bkg().fai.yO() != null && bkg().fai.yO().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bkg().fai.yO().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bkg().fai.yO().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bkg().fai.yO().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bkg().fai != null && bkg().fai.yO() != null && bkg().fai.yO().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bkg().fai.yO().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bkg().fai.yO().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bkg().fai.yO().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bon() {
        return this.fev;
    }

    private void jC(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(feu, z);
        this.fev = z;
    }

    private void boo() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkg().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.bkg().pageContext).bpm();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bkg().pageContext).show();
    }

    private void bop() {
        if (this.fee && bkg().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bkg().faN.Aa();
        }
        bkg().faM.prepareTime = System.currentTimeMillis() - bkg().faM.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bkg().fai != null && bkg().fai.yO() != null && bkg().fai.yO().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bkg().fai.yO().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bkg().fai.yO().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bkg().faM.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fex != null && this.fex.getView().getParent() != null) {
            this.fex.setVisibility(8);
            bkg().rootView.removeView(this.fex.getView());
            this.fex.release();
        }
        if (this.ffo != null) {
            this.ffo.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bkg().faj.indexOfChild(this.feF) < 0) {
            bkg().faj.addView(this.feF, layoutParams);
        }
        this.feF.qE(1000);
    }

    private void bjG() {
        if (bkg().blM() == 1) {
            bkg().faI.startRecord();
        }
    }

    private void zf(String str) {
        zg(str);
    }

    private void zg(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bkg().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String ac(Intent intent) {
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

    private void ad(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.fex != null) {
            this.fex.yU(fromJson.getSmallurl());
        }
    }

    private boolean boq() {
        return com.baidu.live.c.pr().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bor() {
        com.baidu.live.c.pr().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.eUa.faI.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
        int i = a.i.live_close_confirm;
        if (this.ffr != null && this.ffr.bkm()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.ffr != null && this.ffr.bkl()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkg().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(i);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                }
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomOpearator.this.bkg().fai.yO() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkg().fai.yO(), 0, AlaMasterLiveRoomOpearator.this.bkg().fai.bpO() != 1 ? AlaMasterLiveRoomOpearator.this.bkg().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                } else {
                    AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bkg().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (mVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = mVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = mVar.XQ;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bkg().fai.cV(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.ffl) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bkg().faM;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bkg().faI.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.ffh;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.ffi;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.ffd;
            if (this.ffe != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.fff - this.ffg) / this.ffe) * 100.0f;
            }
            Intent intent = new Intent(bkg().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bkg().fai != null && bkg().fai.yO() != null && bkg().fai.yO().XQ != null) {
                String str3 = bkg().fai.yO().XQ.nickName;
                String str4 = bkg().fai.yO().XQ.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.m yO = bkg().fai.yO();
            if (yO != null && yO.XQ != null && !TextUtils.isEmpty(yO.XQ.portrait)) {
                intent.putExtra("host_portrait", yO.XQ.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.ffj = intent;
                this.ffk = s;
                bkg().pageContext.showToast(a.i.ala_live_background_close_tip);
                if (!TextUtils.isEmpty(str)) {
                    com.baidu.live.im.a aVar = new com.baidu.live.im.a();
                    aVar.setMsgType(13);
                    aVar.setContent(str);
                }
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
    public void bot() {
        if (this.ffj != null) {
            a(this.ffj, this.ffk);
            this.ffj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.ffl = true;
        if (this.ffr != null) {
            this.ffr.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.eOz);
            bkg().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bkg().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bou() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eUa.faO != null && this.eUa.faO.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.ffr != null && this.ffr.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bkg().faK.boZ()) {
                bos();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.feG.setVisibility(4);
            return;
        }
        this.feG.a(i, z, i2, z2);
        if (this.eUa != null && this.eUa.fai != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.bVf != i3) {
                this.bVf = i3;
                if (this.feE == null) {
                    this.feE = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUa.pageContext, null);
                }
                switch (this.bVf) {
                    case 0:
                        this.feE.a(this.eUa.rootView, this.eUa.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.feE.a(this.eUa.rootView, this.eUa.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.feE.a(this.eUa.rootView, this.eUa.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.eUa.fai.j(this.eUa.fai.yO().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void t(com.baidu.live.im.data.a aVar) {
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
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bou();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkg().fai.yO(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0468, code lost:
        yK(r6);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        final String str;
        String str2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        String optString;
        String optString2;
        JSONObject jSONObject5;
        long j;
        long j2;
        long j3;
        String str3;
        String str4;
        if (aVar.getMsgType() == 125) {
            if (this.feC != null) {
                this.feC.v(aVar);
            }
        } else if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject4 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject4 = new JSONObject(aVar.getContent());
                }
                try {
                    optString = jSONObject4.optString("content_type");
                    try {
                        optString2 = jSONObject4.optString("text");
                    } catch (JSONException e) {
                        jSONObject = jSONObject4;
                        str = null;
                        str2 = optString;
                    }
                } catch (JSONException e2) {
                    jSONObject = jSONObject4;
                    str = null;
                    str2 = null;
                }
            } catch (JSONException e3) {
                jSONObject = null;
                str = null;
                str2 = null;
            }
            try {
                String optString3 = jSONObject4.optString("ext");
                if (!TextUtils.isEmpty(optString3)) {
                    new JSONObject(new String(Base64.decode(optString3.getBytes(), 0)));
                }
                jSONObject3 = jSONObject4.optJSONObject("ext_data");
                jSONObject2 = jSONObject4;
                str = optString2;
                str2 = optString;
            } catch (JSONException e4) {
                jSONObject = jSONObject4;
                str = optString2;
                str2 = optString;
                jSONObject2 = jSONObject;
                jSONObject3 = null;
                if (this.ffr != null) {
                }
                if (!"close_live".equals(str2)) {
                }
            }
            if (this.ffr != null) {
                this.ffr.cU(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bou();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkg().fai.yO(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bkg().fai.yO() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bkg().fai.yO().Ye.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bkg().fai.yO().Ye.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bkg().fai.yO().Ye.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.feX != null) {
                    this.feX.v(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.feD.at(optString4, optInt2);
                    }
                    if (this.eQU.getCount() > 20) {
                        this.eQU.cD(this.eQU.getCount() + 1);
                    } else if (this.eQP != null) {
                        com.baidu.live.data.a xo = aVar.xo();
                        com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                        gVar.XR = new AlaLocationData();
                        gVar.XS = new AlaRelationData();
                        gVar.XQ = new AlaLiveUserInfoData();
                        gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                        gVar.XQ.userName = xo.userName;
                        gVar.XQ.portrait = xo.portrait;
                        if (this.eQP.c(gVar)) {
                            this.eQU.cD(this.eQU.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt("event_type") == 1001 && bkg().fai.yO() != null && bkg().fai.yO().mLiveInfo != null) {
                    String str5 = bkg().fai.yO().mLiveInfo.feed_id;
                    long j4 = bkg().fai.yO().mLiveInfo.live_id;
                    long optLong2 = jSONObject2.optLong("id");
                    if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                        o.g(str5, j4);
                        com.baidu.live.utils.m.h(j4, optLong2);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bkg() != null && bkg().fai != null && bkg().fai.yO() != null && bkg().fai.yO().Ye != null && bkg().fai.yO().Ye.userId == jSONObject2.optLong("user_id")) {
                    bkg().fai.bpD();
                }
            } else if ("official_notice".equals(str2) && jSONObject2 != null) {
                long optLong3 = jSONObject2.optLong("user_id");
                if (jSONObject3 != null) {
                    String str6 = optLong3 + "";
                    TbadkCoreApplication.getInst();
                    if (str6.equals(TbadkCoreApplication.getCurrentAccount())) {
                        OfficialNoticeData officialNoticeData = new OfficialNoticeData();
                        officialNoticeData.parserJson(jSONObject3);
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913171, officialNoticeData));
                    }
                }
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a xo2 = aVar.xo();
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
                long optLong4 = jSONObject5.optLong("charm_total");
                String optString9 = jSONObject5.optString("attach");
                String optString10 = jSONObject5.optString("attach_new");
                String optString11 = jSONObject5.optString("gift_mul");
                long j5 = 0;
                long j6 = 0;
                long j7 = 0;
                String str7 = null;
                if (bkg().fai != null && bkg().fai.yO() != null && bkg().fai.yO().mLiveInfo != null) {
                    j5 = bkg().fai.yO().mLiveInfo.live_id;
                    j6 = bkg().fai.yO().mLiveInfo.group_id;
                    j7 = bkg().fai.yO().XQ.userId;
                    str7 = bkg().fai.yO().mLiveInfo.appId;
                    if (bkg().fai.yO().mLiveSdkInfo.mCastIds != null) {
                        String str8 = bkg().fai.yO().mLiveSdkInfo.mCastIds.XX;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bkg().fai.yO().mLiveSdkInfo.mCastIds.XY;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || bkg().blM() != 2) {
                            if (TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    t.b(optString11, xo2.userId, xo2.portrait, xo2.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString10, "", "");
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString11);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.v.d.zs().dY(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                t.b(optString5, Integer.parseInt(optString6), optString7, optString8, xo2.userId, xo2.portrait, xo2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3);
                            }
                        }
                        yK(optString5);
                        com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
                        dVar.eZB = optLong4;
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
                t.b(optString5, Integer.parseInt(optString6), optString7, optString8, xo2.userId, xo2.portrait, xo2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3);
                yK(optString5);
                com.baidu.tieba.ala.liveroom.e.d dVar2 = new com.baidu.tieba.ala.liveroom.e.d();
                dVar2.eZB = optLong4;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void yK(String str) {
        if (this.eQW != null) {
            this.eQW.yK(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp(int i) {
        View findViewById = bkg().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.eQW != null) {
            this.eQW.bj(2, i);
        }
    }

    private void bov() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bkg().faI != null && AlaMasterLiveRoomOpearator.this.bkg().faI.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bkg().faI.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bkg().faI.startRecord();
                }
            }
        });
    }

    private void bow() {
        if (bkg().faI != null && bkg().faI.getPreview() != null) {
            bkg().faI.getPreview().setVisibility(8);
            bkg().faI.stopRecord();
        }
    }

    public void box() {
        this.faF = bkg().fai.bpP();
        if (this.fex != null) {
            this.fex.jn(this.faF);
        }
    }

    public void blK() {
        if (TbadkCoreApplication.getInst().isOther()) {
            boy();
        } else if (this.fex != null) {
            this.fex.blK();
        }
    }

    public void onDestroy() {
        if (this.ffc != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.ffc);
        }
        this.ffc = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ffo != null) {
            this.ffo.jl(true);
        }
        this.ffo = null;
        if (this.fex != null) {
            this.fex.destroy();
            bkg().rootView.removeView(this.fex.getView());
            this.fex.release();
            this.fex = null;
        }
        if (this.ffr != null) {
            this.ffr.onDestroy();
        }
        if (this.eRG != null) {
            this.eRG.onDestroy();
        }
        if (this.eRI != null) {
            this.eRI.onDestroy();
        }
        if (this.eQQ != null) {
            this.eQQ.onDestroy();
            this.eQQ = null;
        }
        if (this.fey != null) {
            this.fey.onDestroy();
        }
        if (this.eSe != null) {
            this.eSe.onDestroy();
            this.eSe = null;
        }
        if (this.feF != null) {
            this.feF.stopCountDown();
        }
        if (this.feB != null) {
            this.feB.onDestroy();
        }
        if (this.feD != null) {
            this.feD.onDestroy();
        }
        if (this.feX != null) {
            this.feX.onDestroy();
            this.feX = null;
        }
        if (this.eRT != null) {
            this.eRT.onDestroy();
            this.eRT = null;
        }
        t.sH();
        com.baidu.live.entereffect.a.qR().release();
        if (this.eRU != null) {
            this.eRU.onDestroy();
            this.eRU = null;
        }
        if (this.feE != null) {
            this.feE.onDestroy();
        }
        if (this.feC != null) {
            this.feC.brw();
            this.feC.release();
        }
        if (this.eQU != null) {
            this.eQU = null;
        }
        if (this.eQW != null) {
            this.eQW.release();
        }
        if (this.fez != null) {
            this.fez.onDestroy();
        }
        if (this.feC != null) {
            this.feC.onDestroy();
        }
        if (this.eRS != null) {
            this.eRS.release();
        }
        if (this.eSb != null) {
            this.eSb.release();
        }
        if (this.eSc != null) {
            this.eSc.onDestroy();
        }
        if (this.feZ != null) {
            this.feZ.onDestroy();
        }
        if (this.eSo != null) {
            this.eSo.release();
        }
        if (this.fft != null) {
            this.fft.onDestory();
        }
        if (this.ffu != null) {
            this.ffu.release();
        }
        if (this.eSm != null) {
            this.eSm.onDestroy();
        }
        if (this.ffv != null) {
            this.ffv.release();
        }
        MessageManager.getInstance().unRegisterListener(this.eTi);
        MessageManager.getInstance().unRegisterListener(this.ffP);
        MessageManager.getInstance().unRegisterListener(this.ffQ);
        MessageManager.getInstance().unRegisterListener(this.ffR);
        MessageManager.getInstance().unRegisterListener(this.eSQ);
        MessageManager.getInstance().unRegisterListener(this.ffE);
        MessageManager.getInstance().unRegisterListener(this.ffB);
        MessageManager.getInstance().unRegisterListener(this.awj);
        MessageManager.getInstance().unRegisterListener(this.awk);
        MessageManager.getInstance().unRegisterListener(this.ffC);
        MessageManager.getInstance().unRegisterListener(this.eSS);
        MessageManager.getInstance().unRegisterListener(this.eSR);
        MessageManager.getInstance().unRegisterListener(this.eST);
        MessageManager.getInstance().unRegisterListener(this.ffD);
        MessageManager.getInstance().unRegisterListener(this.ffC);
        com.baidu.live.utils.m.Bc();
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUa.faO.a(this.ffT, this.eUa.faJ, this.feH, alaLivePersonData);
        }
    }

    private void boy() {
        if (this.ffa != null) {
            this.eUa.faM.startTime = System.currentTimeMillis();
            this.eUa.faM.liveTotalTime = System.currentTimeMillis();
            this.eUa.faM.sampleMemAndCPU();
            this.eUa.faK.a((short) 4, this.ffa);
        }
    }

    private ViewGroup.LayoutParams boz() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bkg().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
