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
    private static final String fet;
    private List<ag> awM;
    private String eOy;
    private com.baidu.live.g.a ePX;
    private c eQO;
    private com.baidu.tieba.ala.liveroom.l.a eQP;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eQT;
    private com.baidu.tieba.ala.liveroom.activeview.b eQV;
    private com.baidu.live.h.a eRE;
    private com.baidu.tieba.ala.liveroom.share.c eRF;
    private com.baidu.tieba.ala.liveroom.o.b eRG;
    private com.baidu.tieba.ala.liveroom.guide.c eRH;
    private com.baidu.tieba.ala.liveroom.watermark.a eRI;
    private m eRP;
    private i eRQ;
    private j eRR;
    private u eRS;
    private s eRT;
    protected com.baidu.tieba.ala.liveroom.f.a eSa;
    protected h eSb;
    protected w eSd;
    protected com.baidu.live.i.a eSl;
    private com.baidu.live.q.a eSn;
    private boolean eSy;
    private f eTZ;
    private ImageView eTu;
    private ImageView eUh;
    private g eUi;
    private com.baidu.tieba.ala.liveroom.r.a feA;
    private com.baidu.tieba.ala.liveroom.u.a feB;
    private b feC;
    private com.baidu.tieba.ala.liveroom.tippop.a feD;
    private AlaLiveCountDownView feE;
    private AlaLiveStreamStatusView feF;
    private RelativeLayout feG;
    private RelativeLayout feH;
    private RelativeLayout feI;
    private RelativeLayout feJ;
    private View feK;
    private AlaLiveFaceVerifyView feL;
    private ImageView feM;
    private ImageView feN;
    private ImageView feO;
    private ImageView feP;
    private ImageView feQ;
    private ImageView feR;
    private View feS;
    private ImageView feT;
    private TextView feU;
    private x feV;
    private com.baidu.live.x.a feW;
    private com.baidu.tieba.ala.liveroom.master.panel.b feX;
    private com.baidu.live.w.a feY;
    private e feZ;
    private boolean fed;
    private boolean feu;
    private d few;
    private com.baidu.tieba.ala.liveroom.l.a fex;
    private com.baidu.tieba.ala.liveroom.e.c fey;
    private com.baidu.tieba.ala.liveroom.b.a fez;
    private short ffj;
    private com.baidu.tieba.ala.liveroom.g.b ffn;
    private boolean ffo;
    private boolean ffp;
    private com.baidu.tieba.ala.liveroom.challenge.f ffq;
    private com.baidu.live.b.a ffs;
    private com.baidu.live.b.b fft;
    private com.baidu.tieba.ala.liveroom.n.a ffu;
    private boolean ffv;
    private BdUniqueId ffw;
    private boolean ffx;
    private boolean fev = false;
    private boolean eSt = false;
    private Handler mHandler = new Handler();
    private boolean ffa = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver ffb = null;
    private boolean ffc = false;
    private int ffd = 0;
    private int ffe = 0;
    private int fff = 0;
    private long ffg = 0;
    private long ffh = 0;
    private volatile boolean isBackground = false;
    private Intent ffi = null;
    private int mOrientation = 1;
    private boolean faE = false;
    private boolean ffk = false;
    private boolean ffl = true;
    private boolean eUf = false;
    private boolean ffm = true;
    private int bVe = 0;
    public boolean ffr = false;
    private String otherParams = "";
    private Runnable ffy = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.ePX != null) {
                AlaMasterLiveRoomOpearator.this.ePX.qQ();
            }
        }
    };
    private CustomMessageListener awi = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eTZ.faN != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eTZ.faN.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.t(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener awj = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eTZ.faN != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eTZ.faN.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener eSK = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.eRG == null) {
                AlaMasterLiveRoomOpearator.this.eRG = new com.baidu.tieba.ala.liveroom.o.b(AlaMasterLiveRoomOpearator.this.bke().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.eRG.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener eSR = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.eSl != null) {
                AlaMasterLiveRoomOpearator.this.eSl.vO();
            }
        }
    };
    private CustomMessageListener ffz = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSH = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.eTZ.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.yN(str);
            }
        }
    };
    private CustomMessageListener eSI = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aIa();
        }
    };
    private CustomMessageListener eTh = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.eRT.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSP = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener ffA = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fft != null) {
                com.baidu.live.data.m yN = AlaMasterLiveRoomOpearator.this.bke().fah.yN();
                long j = yN.mLiveInfo.live_id;
                long j2 = yN.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.fft.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener ffB = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bke().fai);
            if (AlaMasterLiveRoomOpearator.this.few == null || AlaMasterLiveRoomOpearator.this.few.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qp(0);
            }
            if (AlaMasterLiveRoomOpearator.this.eRQ != null) {
                AlaMasterLiveRoomOpearator.this.eRQ.wq().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.eRQ.wr().hide();
            }
        }
    };
    private CustomMessageListener eSQ = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.p(AlaMasterLiveRoomOpearator.this.bke().fah.yN());
        }
    };
    private CustomMessageListener eSS = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eSd != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.eSd).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener ffC = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.ffu != null) {
                    AlaMasterLiveRoomOpearator.this.ffu.yR(str);
                }
            }
        }
    };
    private CustomMessageListener ffD = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (AlaMasterLiveRoomOpearator.this.ffv) {
                        AlaMasterLiveRoomOpearator.this.bke().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.bke().faH != null) {
                        AlaMasterLiveRoomOpearator.this.bke().faH.setDefBeautyParams(data.VK);
                    }
                    if (AlaMasterLiveRoomOpearator.this.ffn != null) {
                        if (AlaMasterLiveRoomOpearator.this.ffw != null && AlaMasterLiveRoomOpearator.this.ffw == data.VM) {
                            if (!AlaMasterLiveRoomOpearator.this.ffx || AlaMasterLiveRoomOpearator.this.few.getVisibility() == 0) {
                                AlaMasterLiveRoomOpearator.this.ffn.a(AlaMasterLiveRoomOpearator.this.bke().faH.getVideoConfig());
                            }
                            AlaMasterLiveRoomOpearator.this.ffw = null;
                            AlaMasterLiveRoomOpearator.this.ffn.a(AlaMasterLiveRoomOpearator.this.bke().faH.getVideoConfig(), AlaMasterLiveRoomOpearator.this.ffo);
                            if (!AlaMasterLiveRoomOpearator.this.ffo) {
                                AlaMasterLiveRoomOpearator.this.ffo = true;
                            }
                        }
                        AlaMasterLiveRoomOpearator.this.ffn.blw();
                    }
                }
                AlaMasterLiveRoomOpearator.this.ffv = false;
            }
        }
    };
    private View.OnClickListener ffE = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.feN) {
                    AlaMasterLiveRoomOpearator.this.bnE();
                    AlaMasterLiveRoomOpearator.this.feX.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.feM) {
                    if (AlaMasterLiveRoomOpearator.this.eRQ != null) {
                        AlaMasterLiveRoomOpearator.this.eRQ.wr().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.feO) {
                    AlaMasterLiveRoomOpearator.this.aIa();
                } else if (view != AlaMasterLiveRoomOpearator.this.feP) {
                    if (view == AlaMasterLiveRoomOpearator.this.feR) {
                        if (AlaMasterLiveRoomOpearator.this.feY != null) {
                            AlaMasterLiveRoomOpearator.this.feY.showDialog();
                            AlaMasterLiveRoomOpearator.this.feY.bi(AlaMasterLiveRoomOpearator.this.bnI());
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eUh) {
                        if (AlaMasterLiveRoomOpearator.this.ffq != null) {
                            AlaMasterLiveRoomOpearator.this.ffq.bkg();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.feQ) {
                        if (AlaMasterLiveRoomOpearator.this.feB != null) {
                            com.baidu.tieba.ala.liveroom.data.h bpC = AlaMasterLiveRoomOpearator.this.bke().fah.bpC();
                            if (bpC == null || bpC.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(bpC.mLiveSdkInfo.mRoomId);
                                if (bpC.mLiveSdkInfo.mCastIds != null) {
                                    str2 = bpC.mLiveSdkInfo.mCastIds.XX;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.feB.ad("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.feT) {
                        com.baidu.live.data.m yN = AlaMasterLiveRoomOpearator.this.bke().fah.yN();
                        if (AlaMasterLiveRoomOpearator.this.eSa != null && yN != null && yN.mLiveInfo != null) {
                            String valueOf = String.valueOf(yN.mLiveInfo.live_id);
                            String valueOf2 = String.valueOf(yN.mLiveInfo.feed_id);
                            long j = yN.mLiveInfo.room_id;
                            String str3 = yN.mLiveInfo.cover;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (yN.mLiveInfo.session_info != null) {
                                str4 = yN.mLiveInfo.session_info.flvUrl;
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
                            AlaMasterLiveRoomOpearator.this.eSa.yR(o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.ffx = false;
                    AlaMasterLiveRoomOpearator.this.jB(true);
                }
            }
        }
    };
    private CustomMessageListener eSJ = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    AlaMasterLiveRoomOpearator.this.eSt = true;
                    AlaMasterLiveRoomOpearator.this.feV = (x) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.eRQ != null) {
                        AlaMasterLiveRoomOpearator.this.eRQ.wq().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.eRQ != null) {
                        AlaMasterLiveRoomOpearator.this.eRQ.wr().show();
                        AlaMasterLiveRoomOpearator.this.eRQ.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.qp(8);
                }
            }
        }
    };
    private CustomMessageListener ffF = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bke() != null && AlaMasterLiveRoomOpearator.this.bke().faL != null) {
                AlaMasterLiveRoomOpearator.this.bke().faL.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener fdR = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bor();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bke().fah.qw(i);
                if (AlaMasterLiveRoomOpearator.this.eSl != null) {
                    AlaMasterLiveRoomOpearator.this.eSl.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener eOJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bok();
        }
    };
    public final HttpMessageListener ffG = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.yQ()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.feX != null) {
                            AlaMasterLiveRoomOpearator.this.feX.jH(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.feX.boP();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bke().faH.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.feD != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.feD.a(AlaMasterLiveRoomOpearator.this.bke().rootView, AlaMasterLiveRoomOpearator.this.bke().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bke().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.feD.qD(2);
                        AlaMasterLiveRoomOpearator.this.feD.a(AlaMasterLiveRoomOpearator.this.bke().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a ffH = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boy() {
            AlaMasterLiveRoomOpearator.this.boh();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boz() {
            AlaMasterLiveRoomOpearator.this.boi();
        }
    };
    com.baidu.live.liveroom.a.a ffI = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        @Override // com.baidu.live.liveroom.a.a
        public boolean cc(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cd(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ce(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bke().blK() == 1) {
                AlaMasterLiveRoomOpearator.this.bke().faH.stopRecord();
            }
        }
    };
    private IShareCallback ffJ = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.ffa && AlaMasterLiveRoomOpearator.this.feZ != null) {
                AlaMasterLiveRoomOpearator.this.ffa = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.feZ);
            }
        }
    };
    private View.OnTouchListener ffK = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bke().faL.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bke().fai);
            AlaMasterLiveRoomOpearator.this.qp(0);
            if (AlaMasterLiveRoomOpearator.this.eRQ != null) {
                AlaMasterLiveRoomOpearator.this.eRQ.wq().getView().setVisibility(0);
            }
            return false;
        }
    };
    private e.b ffL = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boA() {
            AlaMasterLiveRoomOpearator.this.bnD();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boB() {
            AlaMasterLiveRoomOpearator.this.fed = AlaMasterLiveRoomOpearator.this.few.blC();
            AlaMasterLiveRoomOpearator.this.bke().faL.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bke().faL.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bke().faL.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.faB = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bke().blK();
            eVar.title = AlaMasterLiveRoomOpearator.this.few.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.faC = AlaMasterLiveRoomOpearator.this.few.blD();
            eVar.faF = AlaMasterLiveRoomOpearator.this.fed;
            eVar.faE = AlaMasterLiveRoomOpearator.this.few.blA();
            eVar.faD = AlaMasterLiveRoomOpearator.this.few.blF();
            eVar.faG = AlaMasterLiveRoomOpearator.this.few.blB();
            if (eVar.faG) {
                if (AlaMasterLiveRoomOpearator.this.few.blG()) {
                    AlaMasterLiveRoomOpearator.this.ffa = true;
                    AlaMasterLiveRoomOpearator.this.feZ = eVar;
                    AlaMasterLiveRoomOpearator.this.few.blH();
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
            AlaMasterLiveRoomOpearator.this.bke().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bke().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boC() {
            AlaMasterLiveRoomOpearator.this.ffx = true;
            AlaMasterLiveRoomOpearator.this.jB(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean boD() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boE() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boF() {
            o.k(AlaMasterLiveRoomOpearator.this.eTZ.pageContext.getPageActivity(), "", "");
        }
    };
    private com.baidu.live.liveroom.g.c ffM = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void yL() {
            if (AlaMasterLiveRoomOpearator.this.feB != null) {
                AlaMasterLiveRoomOpearator.this.feB.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.ffq != null) {
                        AlaMasterLiveRoomOpearator.this.ffq.d(AlaMasterLiveRoomOpearator.this.eUh);
                    }
                    if (AlaMasterLiveRoomOpearator.this.feY != null) {
                        AlaMasterLiveRoomOpearator.this.feY.bh(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.ffq != null) {
                        AlaMasterLiveRoomOpearator.this.ffq.bkh();
                    }
                    if (AlaMasterLiveRoomOpearator.this.feY != null) {
                        AlaMasterLiveRoomOpearator.this.feY.bh(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.feB != null) {
                    AlaMasterLiveRoomOpearator.this.feB.jR(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.eSd != null) {
                    AlaMasterLiveRoomOpearator.this.eSd.aB(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a ffN = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.feL != null && AlaMasterLiveRoomOpearator.this.bke().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.feL) >= 0) {
                AlaMasterLiveRoomOpearator.this.bke().rootView.removeView(AlaMasterLiveRoomOpearator.this.feL);
                AlaMasterLiveRoomOpearator.this.feL.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.feL = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRu = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            com.baidu.live.data.m yN;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.boq();
            } else if (i == 14 && (yN = AlaMasterLiveRoomOpearator.this.bke().fah.yN()) != null && yN.XQ != null && yN.mLiveInfo != null && yN.Ye != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity(), yN.XQ.userName, Long.toString(yN.XQ.userId), Long.toString(yN.XQ.charmCount), String.valueOf(yN.mLiveInfo.group_id), String.valueOf(yN.mLiveInfo.live_id), true, String.valueOf(yN.XQ.userId), Long.toString(yN.Ye.userId), yN.Ye.userName, yN.Ye.portrait, AlaMasterLiveRoomOpearator.this.eQT.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(yN.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.eQT.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener ffO = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.ffr = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fgQ;
            }
        }
    };
    private HttpMessageListener ffP = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.feU.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.feU.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.feU.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.feU.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.awM = getVideoGoodsListHttpResponseMessage.awM;
            }
        }
    };
    private HttpMessageListener ffQ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awH != null && !eventPollingHttpResponseMessage.awH.isEmpty() && AlaMasterLiveRoomOpearator.this.bke().fah != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.currentTime;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.awH.size()) {
                            break;
                        }
                        af afVar = eventPollingHttpResponseMessage.awH.get(i2);
                        if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                            com.baidu.live.utils.m.a(afVar, AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo);
                            com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                        }
                        i = i2 + 1;
                    }
                    af afVar2 = eventPollingHttpResponseMessage.awH.get(eventPollingHttpResponseMessage.awH.size() - 1);
                    if (j == afVar2.liveId) {
                        com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.awG;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bke().fah != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null && AlaMasterLiveRoomOpearator.this.bke().fah != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                com.baidu.live.utils.m.i(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a ffR = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
    };
    private com.baidu.live.liveroom.middleware.g ffS = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.Vi);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        fet = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zj().awA != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bke().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zj().awA.aaT, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yN(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bke().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bke().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zj().awA.aar;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bke().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bke().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bke().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.ffq != null) {
            this.ffq.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnD() {
        if (bke() != null && bke().fah != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bke().fah.bpu();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bke().fah.bpv();
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
                    AlaMasterLiveRoomOpearator.this.ffc = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.ffc = false;
                }
                if (AlaMasterLiveRoomOpearator.this.ffd == 0) {
                    AlaMasterLiveRoomOpearator.this.ffd = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.ffe == 0) {
                    AlaMasterLiveRoomOpearator.this.ffe = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.fff = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bke() != null && bke().faJ != null) {
            bke().faJ.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.eTZ = fVar;
        this.eOy = str;
    }

    protected f bke() {
        return this.eTZ;
    }

    public int a(g gVar) {
        this.eUi = gVar;
        this.ffb = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.ffb, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.feD == null) {
            this.feD = new com.baidu.tieba.ala.liveroom.tippop.a(this.eTZ.pageContext, null);
        }
        registerListener();
        this.ePX = new com.baidu.live.g.a();
        bnS();
        Long[] lArr = new Long[1];
        this.ffg = lArr[0] == null ? 0L : lArr[0].longValue();
        this.ffh = lArr[0] != null ? lArr[0].longValue() : 0L;
        bke().fai.setOnTouchListener(this.ffK);
        this.feu = SharedPrefHelper.getInstance().getBoolean(fet, false);
        this.feE = new AlaLiveCountDownView(bke().pageContext.getPageActivity());
        this.feE.setCount(3);
        this.feE.setTextColor(bke().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.feE.setTextSize(bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.feE.setTypeface(Typeface.DEFAULT_BOLD);
        this.feE.setIncludeFontPadding(false);
        this.feE.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void boG() {
                if (AlaMasterLiveRoomOpearator.this.bke().fai != null) {
                    AlaMasterLiveRoomOpearator.this.bke().fai.removeView(AlaMasterLiveRoomOpearator.this.feE);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnE() {
        if (this.feX == null) {
            this.feX = new com.baidu.tieba.ala.liveroom.master.panel.b(bke().pageContext.getPageActivity(), bke().blK() == 2);
            this.feX.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bke().faH.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jD(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bke().faH.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jE(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bke().faH.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bop();
                    if (AlaMasterLiveRoomOpearator.this.feD != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.feD.a(AlaMasterLiveRoomOpearator.this.bke().rootView, AlaMasterLiveRoomOpearator.this.bke().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.feD.a(AlaMasterLiveRoomOpearator.this.bke().rootView, AlaMasterLiveRoomOpearator.this.bke().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jF(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boH() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bke().fah != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boI() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bke().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boJ() {
                    if (AlaMasterLiveRoomOpearator.this.bke() != null && AlaMasterLiveRoomOpearator.this.bke().fah != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.bke().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.feX != null) {
                            AlaMasterLiveRoomOpearator.this.feX.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boK() {
                    long j = (AlaMasterLiveRoomOpearator.this.bke() == null || AlaMasterLiveRoomOpearator.this.bke().fah == null || AlaMasterLiveRoomOpearator.this.bke().fah.yN() == null || AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bke() != null && AlaMasterLiveRoomOpearator.this.bke().fah != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eTZ.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.feX != null) {
                                        AlaMasterLiveRoomOpearator.this.feX.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eTZ.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.feX != null) {
                        AlaMasterLiveRoomOpearator.this.feX.dismiss();
                    }
                }
            });
        }
        bnF();
    }

    private void bnF() {
        if (this.feX != null) {
            boolean isBackCamera = bke().faH.isBackCamera();
            this.feX.jG(bke().faH.isBackCamera());
            this.feX.F(bke().faH.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bke().faH.isPushMirror();
            if (this.ffl) {
                isPushMirror = boo() || isPushMirror;
                this.ffl = false;
            }
            this.feX.G(isPushMirror, isBackCamera ? false : true);
            this.feX.jH(bke().faH.isMute());
            this.feX.boP();
        }
    }

    public void bnG() {
        if (this.eUi != null) {
            if (this.eUi.faO == null || this.eUi.faO.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.feK == null) {
                        this.feK = this.eTZ.faN.yw();
                        this.eTZ.rootView.addView(this.feK, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.few == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bke().fah != null && bke().fah.yN() != null && bke().fah.yN().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bke().fah.yN().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bke().fah.yN().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.few = new d(bke().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bke().faL.prepareTime = System.currentTimeMillis();
                    bke().rootView.addView(this.few.getView(), layoutParams);
                    this.few.a(this.ffJ);
                }
                this.few.jn(this.faE);
                this.few.a(this.ffL);
                this.few.a(this.ffH);
                this.few.a(bke().faH, bke().blK());
                return;
            }
            this.fed = this.eUi.faO.mLiveInfo.screen_direction == 2;
            if (this.eUi.faO.mLiveInfo.isAudioOnPrivate == 1) {
                bke().faH.setMute(true);
                if (this.feD == null) {
                    this.feD = new com.baidu.tieba.ala.liveroom.tippop.a(this.eTZ.pageContext, null);
                }
                if (!this.feD.qC(2)) {
                    this.feD.a(bke().rootView, bke().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.faB = true;
            eVar.forumId = String.valueOf(this.eUi.faO.mLiveInfo.forum_id);
            eVar.forumName = this.eUi.faO.mLiveInfo.forum_name;
            eVar.liveType = this.eUi.faO.mLiveInfo.live_type;
            eVar.title = this.eUi.faO.mLiveInfo.getLiveTitle();
            eVar.clarity = this.eUi.faO.mLiveInfo.clarity;
            eVar.gameId = this.eUi.faO.mLiveInfo.game_id;
            eVar.gameName = this.eUi.faO.mLiveInfo.game_label;
            eVar.faF = this.eUi.faO.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bnH() {
        if (this.ffn != null) {
            this.ffn.a(bke().faH.getVideoConfig(), false);
            this.ffn.blw();
        }
        if (this.few != null) {
            this.few.jm(true);
        }
        if (bke().faH.hasBeauty() >= 0) {
            bke().faH.setBeauty(com.baidu.live.c.pr().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bke().faN.C(this.eTZ.faH);
        } else if (this.few != null) {
            this.few.jm(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.feK != null && this.feK.getParent() != null) {
                ((ViewGroup) this.feK.getParent()).removeView(this.feK);
                this.feK = null;
            }
            bke().fai.setVisibility(0);
            this.eTZ.faN.a(bke().fai);
        } else {
            bnX();
            bon();
            this.feB = new com.baidu.tieba.ala.liveroom.u.a(bke().pageContext, this.ffI);
            this.feB.d(bke().fai, true);
            this.feB.jR(true);
            if (this.eRQ != null && this.eRQ.wq() != null) {
                this.eRQ.wq().setNeedTopAlphaShade(true);
            }
        }
        bke().faH.setPushMirror(boo());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eTZ.faN.j(bke().fah.yN());
        }
        if (!bke().faH.isBackground() && bke().fah.yN() != null && bke().fah.yN().mLiveInfo != null) {
            int startPush = bke().faH.startPush(bke().fah.yN().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eTZ.faN.yx();
            }
            if (startPush != 0 && bke().faL != null) {
                bke().faL.errCode = 4;
                bke().faL.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.blP() && !bol()) {
                jC(true);
                bom();
            }
            if (this.fey != null) {
                this.fey.q(bke().fah.yN());
            }
            if (this.eQP != null) {
                this.eQP.u(bke().fah.yN());
            }
            if (this.eRE != null) {
                this.eRE.a(bke().fah.yN());
            }
            if (this.fez != null && bke() != null && bke().fah != null) {
                if (this.fez.ag(bke().fai)) {
                    this.fez.o(bke().fah.yN());
                } else {
                    this.fez.b(bke().fai, bke().fah.yN());
                }
            }
            if (this.fex != null) {
                this.fex.u(bke().fah.yN());
            }
            if (hVar == null || hVar.XQ == null) {
                z = com.baidu.live.c.pr().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.XQ.canUseChallenge;
                com.baidu.live.c.pr().putBoolean("ala_master_can_use_challenge", z);
            }
            bnY();
            bnL();
            jz(z);
            bnZ();
            boe();
            bjf();
            bjt();
            v(bke().fah.yN());
            f(bke().fah.yN());
            bof();
            bog();
            boc();
            bjh();
            bjo();
            bjp();
            if (this.eRP != null) {
                this.eRP.g(bke().fah.yN());
            }
            if (this.eRQ != null) {
                this.eRQ.e(String.valueOf(bke().fah.yN().mLiveInfo.group_id), String.valueOf(bke().fah.yN().mLiveInfo.last_msg_id), String.valueOf(bke().fah.yN().XQ.userId), String.valueOf(bke().fah.yN().mLiveInfo.live_id), bke().fah.yN().XQ.appId);
            }
            if (this.eRR != null) {
                this.eRR.a(bke().fah.yN(), true);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                com.baidu.live.utils.m.i(bke().fah.yN().mLiveInfo.user_id, bke().fah.yN().mLiveInfo.live_id);
            }
            this.mHandler.post(this.ffy);
        }
    }

    private void jz(boolean z) {
        if (this.ffq == null) {
            this.ffq = new com.baidu.tieba.ala.liveroom.challenge.f(bke());
        }
        this.ffq.a(this.eUh, this.eUi);
        this.ffq.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ad adVar, ae aeVar, ae aeVar2) {
                if (AlaMasterLiveRoomOpearator.this.eRI != null) {
                    AlaMasterLiveRoomOpearator.this.eRI.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bke().fai.fnb = false;
                AlaMasterLiveRoomOpearator.this.bnJ();
                if (AlaMasterLiveRoomOpearator.this.eSn != null) {
                    AlaMasterLiveRoomOpearator.this.eSn.b(AlaMasterLiveRoomOpearator.this.jA(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void pR() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.ffy);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bkc() {
                if (AlaMasterLiveRoomOpearator.this.eRI != null) {
                    AlaMasterLiveRoomOpearator.this.eRI.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bke().fai.fnb = true;
                AlaMasterLiveRoomOpearator.this.bnK();
                if (AlaMasterLiveRoomOpearator.this.eSn != null) {
                    AlaMasterLiveRoomOpearator.this.eSn.b(AlaMasterLiveRoomOpearator.this.jA(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bkd() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.ffy);
            }
        });
        this.ffq.C(this.fed, z);
        this.ffq.h(this.fed, z, (this.eUi == null || this.eUi.faO == null || this.eUi.faO.mChallengeData == null) ? false : true);
    }

    public boolean bnI() {
        return this.ffq != null && this.ffq.bkj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnJ() {
        if (this.feC != null) {
            this.feC.setVisible(8);
            this.feC.setCanVisible(false);
        }
        if (this.eQV != null) {
            this.eQV.iM(true);
            jf(true);
        }
        if (this.feF != null) {
            this.feF.setCanVisible(false);
            this.feF.setVisibility(4);
        }
        if (this.feB != null) {
            this.feB.jQ(false);
        }
        if (this.eRQ != null) {
            this.eRQ.wq().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnK() {
        if (this.feC != null) {
            this.feC.setCanVisible(true);
        }
        if (this.eQV != null) {
            this.eQV.iM(false);
            jf(false);
        }
        if (this.feF != null) {
            this.feF.setCanVisible(true);
        }
        if (this.feB != null) {
            this.feB.jQ(true);
        }
        if (this.eRQ != null) {
            this.eRQ.wq().setNeedTopAlphaShade(false);
        }
    }

    private void jf(boolean z) {
        ViewGroup.LayoutParams pQ;
        if (this.eQV != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.eQV;
            AlaLiveView alaLiveView = bke().fai;
            if (z) {
                pQ = box();
            } else {
                pQ = pQ(1);
            }
            bVar.a(1, alaLiveView, pQ, 21);
            this.eQV.updateView();
        }
    }

    private void bnL() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.feF == null) {
            this.feF = new AlaLiveStreamStatusView(bke().pageContext.getPageActivity());
        }
        this.feF.setId(a.g.ala_live_room_stream_view);
        this.feF.setVisibility(4);
        this.feF.setLayoutParams(layoutParams);
        if (this.feF.getParent() == null) {
            bke().fai.addView(this.feF, layoutParams);
        }
    }

    public void bnM() {
        if (this.few != null && this.few.getVisibility() != 8 && bke().faH.getPreview() != null) {
            bke().faH.stopRecord();
        }
    }

    public void bnN() {
        if (bke().faH.getPreview() != null) {
            bke().faH.stopRecord();
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.ffn != null) {
                this.ffn.jl(false);
            }
            this.ffn = new com.baidu.tieba.ala.liveroom.g.b(bke().rootView, bke(), bke().faH);
            this.ffn.a(bke().faH.getVideoConfig(), false);
            this.ffn.blw();
        }
        if (this.feD != null) {
            this.feD.bqy();
        }
        this.mHandler.post(this.ffy);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.fev = z;
        if (z) {
            Rect rect = new Rect();
            bke().fai.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            bke().fai.getGlobalVisibleRect(rect2);
            if (this.eRQ != null && this.eRQ.wq() != null) {
                this.eRQ.wq().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eRQ.wq().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.eRQ.wq().getView().setLayoutParams(layoutParams);
            }
            if (this.eRQ != null && this.eRQ.wr() != null) {
                int i = rect2.bottom - rect.bottom;
                this.eRQ.wr().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eRQ.wr().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.eRQ.wr().getView().setLayoutParams(layoutParams2);
                this.eRQ.wr().getView().setVisibility(0);
            }
            qp(8);
            qo(8);
        } else {
            if (this.eRQ != null && this.eRQ.wq() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eRQ.wq().getView().getLayoutParams();
                layoutParams3.bottomMargin = bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.eRQ.wq().getView().setLayoutParams(layoutParams3);
            }
            if (this.eRQ != null && this.eRQ.wr() != null) {
                this.eRQ.wr().hide();
            }
            qp(0);
            qo(0);
        }
        if (this.few != null) {
            this.few.E(false, z);
        }
        if (this.eRR != null) {
            this.eRR.wy();
        }
        if (this.feY != null) {
            this.feY.onKeyboardVisibilityChanged(z);
        }
        if (this.eRQ != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bke().pageContext.getPageActivity())) + bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (bke().fai.indexOfChild(this.eRQ.wq().getView()) != -1 && this.eRQ.wq().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eRQ.wq().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.eRQ.wq().getView().setLayoutParams(layoutParams4);
            }
            this.eRQ.wq().wp();
        }
        this.mHandler.post(this.ffy);
    }

    private void qo(int i) {
        if (this.eQP != null) {
            this.eQP.qb(i);
        }
        if (this.feH != null) {
            this.feH.setVisibility(i);
        }
        if (this.eRE != null) {
            this.eRE.getView().setVisibility(i);
        }
        if (this.feA != null) {
            this.feA.setVisible(i);
        }
        if (this.fez != null) {
            this.fez.setVisibility(i);
        }
        if (this.eQV != null) {
            this.eQV.setVisible(i);
        }
        if (this.eSn != null) {
            this.eSn.setCanVisible(i == 0);
        }
        if (this.eSb != null) {
            this.eSb.setVisible(i);
        }
        if (this.eSl != null) {
            this.eSl.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bke().faL.errCode = 1;
            boh();
        } else if (i == -5) {
            boi();
        } else if (i == -2) {
            ze(bke().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bke().faH.stopRecord();
        } else if (i == -3 && this.few != null) {
            this.few.jm(false);
        }
        if (i == -4) {
            if (this.few == null || this.few.getView().getParent() == null) {
                bke().f((short) 1);
                return;
            }
            this.few.blE();
            this.feP.setVisibility(0);
            if (this.feB != null) {
                this.feB.jR(true);
            }
            bke().fai.setBackgroundColor(bke().pageContext.getResources().getColor(17170445));
            bou();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bjE();
        if (i == 12001) {
            if (i2 == -1) {
                zf(ac(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                ad(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aIa();
        }
    }

    public void onResume() {
        if (this.few != null) {
            this.few.onResume();
        }
        if (this.ffa && this.feZ != null) {
            this.ffa = false;
            c(this.feZ);
        }
        if (this.eSd != null) {
            this.eSd.onResume();
        }
    }

    public void g(short s) {
        if (this.eRP != null) {
            this.eRP.sL();
        }
        if (this.eRQ != null) {
            this.eRQ.a(null);
            this.eRQ.vW();
        }
        if (this.eRR != null) {
            this.eRR.vW();
        }
        if (this.ffq != null) {
            this.ffq.bki();
        }
    }

    public boolean bnO() {
        com.baidu.live.data.m yN = bke().fah.yN();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eTZ.faN.i(yN);
            if (yN != null && yN.mLiveInfo.live_status != 1) {
                bos();
                bke().pageContext.getPageActivity().finish();
                if (bke().fah != null && bke().fah.yN() != null) {
                    a(yN, 1, bke().fah.bpM() != 1 ? bke().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.eRQ != null) {
                this.eRQ.wq().a(String.valueOf(yN.mLiveInfo.group_id), String.valueOf(yN.mLiveInfo.live_id), true, String.valueOf(yN.XQ.userId));
            }
            if (this.eRR != null) {
                this.eRR.a(yN);
            }
            if (this.eRE != null) {
                this.eRE.a(bke().fah.yN());
            }
            if (this.eQP != null) {
                this.eQP.u(yN);
            }
            if (yN != null) {
                if (this.fey != null) {
                    this.fey.q(yN);
                }
                if (this.ffq != null) {
                    this.ffq.a(yN);
                }
                if (this.eRT != null && yN.mLiveInfo != null) {
                    this.eRT.a(yN.mLiveInfo);
                }
                if (this.eSn != null) {
                    this.eSy = this.eSn.m(yN);
                }
                if (this.eQV != null) {
                    this.eQV.iN(this.eSy);
                    this.eQV.h(yN);
                    this.eQV.updateView();
                }
                if (this.eSl != null) {
                    this.eSl.a(yN);
                }
                if (yN.mLiveInfo.live_status != 1) {
                    bos();
                    bke().pageContext.getPageActivity().finish();
                    if (bke().fah != null && bke().fah.yN() != null) {
                        a(yN, 1, bke().fah.bpM() != 1 ? bke().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.ffr) {
                    this.feS.setVisibility(0);
                    if (!this.ffp && yN.mLiveInfo != null) {
                        this.ffp = true;
                        o.g(yN.mLiveInfo.feed_id, yN.mLiveInfo.live_id);
                    }
                } else {
                    this.feS.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bnP() {
        bnF();
    }

    public void bnQ() {
        if (this.ffn != null) {
            this.ffn.blx();
        }
    }

    public void bnR() {
        if (this.few != null && this.few.getVisibility() != 8) {
            if (bke().blK() == 2) {
                bou();
            } else {
                bot();
            }
        }
        if (this.few != null && this.few.getVisibility() != 8) {
            if (bke().blK() == 1) {
                this.few.onResume();
            }
            this.few.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.eSt && this.feV != null) {
            if (this.eRQ != null) {
                this.eRQ.wq().getView().setVisibility(0);
            }
            if (this.eRQ != null) {
                this.eRQ.wr().show();
                this.eRQ.wr().setEditText(" @" + this.feV.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            qp(8);
            this.eSt = false;
        }
        if (this.eSa != null) {
            this.eSa.resume();
        }
        if (this.fft != null) {
            this.fft.resume();
        }
        if (this.ffu != null) {
            this.ffu.resume();
        }
    }

    public void onPause() {
        if (this.eSa != null) {
            this.eSa.pause();
        }
        if (this.fft != null) {
            this.fft.pause();
        }
        if (this.eSd != null) {
            this.eSd.onPause();
        }
        if (this.ffu != null) {
            this.ffu.pause();
        }
    }

    private void bnS() {
        this.feG = (RelativeLayout) bke().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.feI = (RelativeLayout) bke().rootView.findViewById(a.g.under_live_view_panel);
        this.feJ = (RelativeLayout) bke().rootView.findViewById(a.g.over_live_view_panel);
        this.eTZ.fai.setOnLiveViewScrollListener(this.ffM);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.feI.setVisibility(8);
            this.feJ.setVisibility(8);
            bke().fai.removeAllViews();
        } else {
            this.feH = (RelativeLayout) bke().rootView.findViewById(a.g.ala_live_removeable_top_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.feH.getLayoutParams();
            layoutParams.topMargin = this.eTZ.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.eTZ.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
            }
            this.feH.setLayoutParams(layoutParams);
            if (this.eQT == null) {
                this.eQT = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.eTZ.pageContext.getPageActivity(), false);
            }
            this.eQT.a(this.eRu);
            this.eQT.a(this.feH, a.g.ala_live_room_host_header_stub, 1L);
            this.eQT.setVisible(0);
            this.feP = (ImageView) bke().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
            this.feP.setOnClickListener(this.ffE);
            this.feR = (ImageView) bke().rootView.findViewById(a.g.ala_liveroom_host_paster);
            this.feR.setOnClickListener(this.ffE);
            if (com.baidu.live.v.a.zj().axB != null && com.baidu.live.v.a.zj().axB.acQ != null && com.baidu.live.v.a.zj().axB.acQ.qI() && an.b(com.baidu.live.v.a.zj().axB)) {
                this.feR.setVisibility(0);
            } else {
                this.feR.setVisibility(8);
            }
            if (an.c(com.baidu.live.v.a.zj().axB)) {
                this.feP.setVisibility(0);
                if (an.c(com.baidu.live.v.a.zj().axB)) {
                    this.feP.setAlpha(0.2f);
                }
            } else if (bke().faH.hasBeauty() < 0) {
                this.feP.setVisibility(8);
            } else {
                if (an.c(com.baidu.live.v.a.zj().axB)) {
                    this.feP.setAlpha(0.2f);
                }
                com.baidu.live.c.pr().getInt("live_beauty_level", 3);
            }
            this.feO = (ImageView) bke().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
            this.feO.setOnClickListener(this.ffE);
            this.feM = (ImageView) bke().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
            this.feM.setOnClickListener(this.ffE);
            this.eUh = (ImageView) bke().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
            this.eUh.setOnClickListener(this.ffE);
            this.feN = (ImageView) bke().rootView.findViewById(a.g.ala_liveroom_host_more);
            this.feN.setOnClickListener(this.ffE);
            this.feQ = (ImageView) bke().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
            this.feQ.setOnClickListener(this.ffE);
            this.feS = bke().rootView.findViewById(a.g.host_goods_layout);
            this.feT = (ImageView) bke().rootView.findViewById(a.g.host_goods_imageView);
            this.feU = (TextView) bke().rootView.findViewById(a.g.host_goods_num_textView);
            this.feT.setOnClickListener(this.ffE);
            bnW();
            bnV();
            this.ffn = new com.baidu.tieba.ala.liveroom.g.b(bke().rootView, bke(), bke().faH);
            this.eRP = new m();
            bnT();
            bnU();
            if (this.eRS != null && this.eRS.sk() != null) {
                this.eRS.sk().bringToFront();
            }
        }
        this.ffn = new com.baidu.tieba.ala.liveroom.g.b(bke().rootView, bke(), bke().faH);
    }

    private void bnT() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, bke().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eRQ = (i) runTask.getData();
            this.eRQ.setFromMaster(true);
            this.eRQ.wq().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bke().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(bke().pageContext.getPageActivity()) * 0.27f)) + bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            bke().fai.addView(this.eRQ.wq().getView(), layoutParams);
            this.eRQ.wr().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bke().fai.addView(this.eRQ.wr().getView(), layoutParams2);
            this.eRQ.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
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

    private void bnU() {
        View wx;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, j.class, bke().pageContext);
        if (runTask != null) {
            this.eRR = (j) runTask.getData();
        }
        if (this.eRR != null && (wx = this.eRR.wx()) != null && this.eTZ.fai.indexOfChild(wx) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.eTZ.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bke().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bke().fai.addView(wx, layoutParams);
        }
    }

    private void bnV() {
        CustomResponsedMessage runTask;
        if (this.feW == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bke().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.feW = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bnW() {
        View sk;
        t.b(bke().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.afH = true;
        fVar.context = bke().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.eRS = (u) runTask.getData();
            if (this.eRS != null && (sk = this.eRS.sk()) != null && bke().fai.indexOfChild(sk) < 0) {
                if (sk.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sk.getParent()).removeView(sk);
                }
                bke().fai.addView(sk, bke().fai.getLayoutParams());
            }
        }
    }

    protected void bjp() {
        View sC;
        if (this.eRT == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afH = true;
            aVar.context = bke().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eRT = (s) runTask.getData();
            }
        }
        if (this.eRT != null && (sC = this.eRT.sC()) != null) {
            if (bke().fai.indexOfChild(sC) < 0) {
                if (sC.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sC.getParent()).removeView(sC);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bke().fai.addView(sC, layoutParams);
            }
            sC.bringToFront();
        }
    }

    protected void bjo() {
        View sM;
        if (this.eSd == null) {
            z zVar = new z();
            zVar.afH = true;
            zVar.pageContext = bke().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSd = (w) runTask.getData();
            }
        }
        if (this.eSd != null && (sM = this.eSd.sM()) != null && bke().fai.indexOfChild(sM) < 0) {
            if (sM.getParent() instanceof ViewGroup) {
                ((ViewGroup) sM.getParent()).removeView(sM);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bke().fai.addView(sM, layoutParams);
        }
    }

    private void bnX() {
        bob();
        bit();
        boa();
        bke().fai.setVisibility(0);
        qp(0);
    }

    private void bnY() {
        if (this.feA == null) {
            this.feA = new com.baidu.tieba.ala.liveroom.r.a(bke().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.feA.a(bke().blK(), j, TbadkCoreApplication.getCurrentAccountName(), true, bke().fah.yN().XQ.portrait, this.otherParams, "", -1L);
        this.feA.af(bke().fai);
    }

    private void bnZ() {
        if (this.feY == null) {
            com.baidu.live.w.a eG = eG(bke().pageContext.getPageActivity());
            if (eG != null) {
                this.feY = eG;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bke().pageContext.getPageActivity());
                if (runTask != null) {
                    this.feY = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.feY != null) {
                this.feY.h(this.feI);
                this.feY.i(this.feJ);
                this.feY.ci((bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.eRI != null) {
                    this.feY.ch(this.eRI.brs());
                }
                this.feY.j(bke().fai);
                this.feY.a(this.ePX);
                this.feY.n(bke().fah.yN());
                this.feY.a(this.eQV);
                this.feY.a(new a.InterfaceC0105a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
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

    private void boa() {
        if (this.feC == null) {
            this.feC = new b(bke().pageContext, bke().fai);
        }
    }

    private void bob() {
        if (this.eQP == null) {
            this.eQP = new com.baidu.tieba.ala.liveroom.l.a(bke().pageContext, true, this.ffI);
            this.eQP.c(this.feG, (com.baidu.live.data.m) null);
            this.eQP.a(this.eRu);
        }
        if (this.fex == null) {
            this.fex = new com.baidu.tieba.ala.liveroom.l.a(bke().pageContext, true, null);
            this.fex.a(this.feH, null, a.g.ala_live_room_host_header_stub);
            this.fex.bmW();
        }
    }

    protected void biY() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bpC = bke().fah.bpC();
        boolean z2 = com.baidu.live.v.a.zj().awA.aaS;
        if (bpC == null || bpC.Yo) {
            z = z2;
        }
        if (z && this.eRE == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bke().pageContext)) != null) {
            this.eRE = (com.baidu.live.h.a) runTask.getData();
            if (this.eRE != null) {
                this.eRE.setIsHost(true);
                this.eRE.bV(1);
                View view = this.eRE.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bke().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bke().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.feH.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(com.baidu.live.data.m mVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.eQV == null) {
            this.eQV = new com.baidu.tieba.ala.liveroom.activeview.b(bke().pageContext);
        }
        this.eQV.setOtherParams(this.otherParams);
        this.eQV.b(mVar, false);
        this.eQV.setHost(true);
        this.eQV.a(1, bke().fai, pQ(1));
        this.eQV.a(2, bke().fai, pQ(2));
        this.eQV.iN(this.eSy);
        this.eQV.setVisible(this.fev ? 8 : 0);
        this.eQV.a(this.ePX);
        if (this.ePX != null) {
            if (this.eQV != null) {
                alaActiveRootView2 = this.eQV.pL(1);
                alaActiveRootView = this.eQV.pL(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.ePX.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.ePX.a(alaActiveRootView);
            }
        }
    }

    private void v(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        if (this.eSn == null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bke().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSn = (com.baidu.live.q.a) runTask.getData();
            if (this.eSn != null) {
                this.eSn.a(bke().fai, jA(false));
            }
        }
        if (this.eSn != null) {
            this.eSy = this.eSn.m(mVar);
            this.eSn.setCanVisible(!this.fev);
        }
    }

    protected void boc() {
        CustomResponsedMessage runTask;
        if (bke() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bke().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSl = (com.baidu.live.i.a) runTask.getData();
            this.eSl.a(bke().fai, bod());
            if (bke().fah != null) {
                this.eSl.a(bke().fah.yN());
            }
            this.eSl.setCanVisible(true);
            this.eSl.aP(false);
            this.eSl.a(bke().fah.bdW());
        }
    }

    private void bjh() {
        this.ffu = new com.baidu.tieba.ala.liveroom.n.c(bke().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bod() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bke().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.feF != null) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams pQ(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bke().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.feF != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bke().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
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
        layoutParams.rightMargin = bke().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.ffq != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.ffq.au(true) + bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.feF != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void bit() {
        if (this.fez == null) {
            this.fez = new com.baidu.tieba.ala.liveroom.b.a(bke().pageContext, true);
        }
    }

    private void boe() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bke().pageContext.getPageActivity();
            this.eTu = new ImageView(pageActivity);
            this.eTu.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.eTu.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eTu.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bke().rootView.addView(this.eTu, layoutParams);
            this.eTu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.boq();
                }
            });
            this.eTu.setVisibility(8);
        }
    }

    private void bjf() {
        this.eSa = new com.baidu.tieba.ala.liveroom.f.a(bke().pageContext);
    }

    private void bjt() {
        if (this.eSb == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bke().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSb = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.eSb.setHost(true);
        this.eSb.setOtherParams(this.otherParams);
        if (bke().fah.yN() != null && bke().fah.yN().XQ != null && bke().fah.yN().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.eSb.a(bke().fai, layoutParams, bke().fah.yN());
        }
    }

    private void bof() {
        CustomResponsedMessage runTask;
        if (this.ffs == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bke().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.ffs = (com.baidu.live.b.a) runTask.getData();
            if (this.ffs != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bke().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.ffs.a(bke().fai, layoutParams);
            }
        }
        if (this.ffs != null) {
            this.ffs.a(bke().fah.yN());
        }
    }

    private void bog() {
        CustomResponsedMessage runTask;
        if (this.fft == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bke().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.fft = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.ffq != null) {
            this.ffq.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bke().pageContext.registerListener(this.eSH);
        bke().pageContext.registerListener(this.ffz);
        bke().pageContext.registerListener(this.eSJ);
        bke().pageContext.registerListener(this.eSK);
        bke().pageContext.registerListener(this.ffF);
        bke().pageContext.registerListener(this.fdR);
        bke().pageContext.registerListener(this.eOJ);
        bke().pageContext.registerListener(this.ffG);
        bke().pageContext.registerListener(this.eSI);
        bke().pageContext.registerListener(this.eTh);
        bke().pageContext.registerListener(this.ffO);
        bke().pageContext.registerListener(this.ffP);
        bke().pageContext.registerListener(this.ffQ);
        bke().pageContext.registerListener(this.eSP);
        bke().pageContext.registerListener(this.ffD);
        bke().pageContext.registerListener(this.ffA);
        bke().pageContext.registerListener(this.awi);
        bke().pageContext.registerListener(this.awj);
        bke().pageContext.registerListener(this.ffB);
        bke().pageContext.registerListener(this.eSR);
        bke().pageContext.registerListener(this.eSQ);
        bke().pageContext.registerListener(this.eSS);
        bke().pageContext.registerListener(this.ffC);
        bke().pageContext.registerListener(this.ffB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jB(boolean z) {
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (an.c(com.baidu.live.v.a.zj().axB)) {
                bke().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
                return;
            } else if (bke().faK.pA() == null || ListUtils.isEmpty(bke().faK.pA().VJ) || bke().faK.pA().VK == null || bke().faK.pA().VK.isEmpty()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    bke().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
                    return;
                } else if (!this.ffv) {
                    this.ffw = BdUniqueId.gen();
                    bke().faK.a(this.ffw);
                    this.ffv = true;
                    return;
                } else {
                    return;
                }
            }
        }
        BdUtilHelper.hideSoftKeyPad(bke().pageContext.getPageActivity(), bke().rootView);
        qp(8);
        if (bke().faH.hasAdvancedBeauty() && this.ffn != null) {
            if (!this.ffx || this.few.getVisibility() == 0) {
                this.ffn.a(bke().faH.getVideoConfig());
            }
            this.ffn.a(bke().faH.getVideoConfig(), this.ffo);
            if (!this.ffo) {
                this.ffo = true;
            }
        }
        if (z && this.eRQ != null) {
            this.eRQ.wq().getView().setVisibility(8);
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
    public void boh() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bke().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bke().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bke().f((short) 1);
            }
        });
        bdAlertDialog.create(bke().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boi() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bke().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bke().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bke().f((short) 1);
            }
        });
        bdAlertDialog.create(bke().pageContext).show();
    }

    private void ze(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bke().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bke().f((short) 1);
            }
        });
        bdAlertDialog.create(bke().pageContext).show();
    }

    public void boj() {
        biY();
        com.baidu.live.data.h bdW = bke().fah.bdW();
        int i = 5;
        if (bdW != null) {
            i = (int) bdW.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null && AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bke().fah.cX(AlaMasterLiveRoomOpearator.this.bke().fah.yN().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bdW != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eTZ.faN.b(bdW);
                return;
            }
            if (this.eQO == null) {
                this.eQO = new c(bke().pageContext, this.ffI, true);
            }
            if (this.ffm) {
                this.ffm = false;
                this.eQO.a(String.valueOf(bke().fah.yN().mLiveInfo.group_id), String.valueOf(bke().fah.yN().mLiveInfo.live_id), String.valueOf(bke().fah.yN().XQ.userId), bke().fah.yN());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.eRE != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.eQO.c(this.feH, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.eQO.f(bdW);
            this.eQT.setVisible(0);
            this.eQT.cD(bdW.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bok() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIa() {
        if (bke().fah != null) {
            if (this.eRF == null) {
                this.eRF = new com.baidu.tieba.ala.liveroom.share.c(bke().pageContext);
            }
            this.eRF.c(bke().fah.yN(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bke().fah != null && bke().fah.yN() != null && bke().fah.yN().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bke().fah.yN().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bke().fah.yN().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bke().fah.yN().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bke().fah != null && bke().fah.yN() != null && bke().fah.yN().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bke().fah.yN().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bke().fah.yN().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bke().fah.yN().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bol() {
        return this.feu;
    }

    private void jC(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(fet, z);
        this.feu = z;
    }

    private void bom() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bke().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.bke().pageContext).bpk();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bke().pageContext).show();
    }

    private void bon() {
        if (this.fed && bke().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bke().faM.zY();
        }
        bke().faL.prepareTime = System.currentTimeMillis() - bke().faL.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bke().fah != null && bke().fah.yN() != null && bke().fah.yN().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bke().fah.yN().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bke().fah.yN().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bke().faL.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.few != null && this.few.getView().getParent() != null) {
            this.few.setVisibility(8);
            bke().rootView.removeView(this.few.getView());
            this.few.release();
        }
        if (this.ffn != null) {
            this.ffn.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bke().fai.indexOfChild(this.feE) < 0) {
            bke().fai.addView(this.feE, layoutParams);
        }
        this.feE.qE(1000);
    }

    private void bjE() {
        if (bke().blK() == 1) {
            bke().faH.startRecord();
        }
    }

    private void zf(String str) {
        zg(str);
    }

    private void zg(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bke().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.few != null) {
            this.few.yU(fromJson.getSmallurl());
        }
    }

    private boolean boo() {
        return com.baidu.live.c.pr().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bop() {
        com.baidu.live.c.pr().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.eTZ.faH.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        int i = a.i.live_close_confirm;
        if (this.ffq != null && this.ffq.bkk()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.ffq != null && this.ffq.bkj()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bke().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bke().fah.yN() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bke().fah.yN(), 0, AlaMasterLiveRoomOpearator.this.bke().fah.bpM() != 1 ? AlaMasterLiveRoomOpearator.this.bke().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bke().pageContext).show();
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
                bke().fah.cV(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.ffk) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bke().faL;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bke().faH.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.ffg;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.ffh;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.ffc;
            if (this.ffd != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.ffe - this.fff) / this.ffd) * 100.0f;
            }
            Intent intent = new Intent(bke().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bke().fah != null && bke().fah.yN() != null && bke().fah.yN().XQ != null) {
                String str3 = bke().fah.yN().XQ.nickName;
                String str4 = bke().fah.yN().XQ.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.m yN = bke().fah.yN();
            if (yN != null && yN.XQ != null && !TextUtils.isEmpty(yN.XQ.portrait)) {
                intent.putExtra("host_portrait", yN.XQ.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.ffi = intent;
                this.ffj = s;
                bke().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bor() {
        if (this.ffi != null) {
            a(this.ffi, this.ffj);
            this.ffi = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.ffk = true;
        if (this.ffq != null) {
            this.ffq.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.eOy);
            bke().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bke().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eTZ.faN != null && this.eTZ.faN.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.ffq != null && this.ffq.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bke().faJ.boX()) {
                boq();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.feF.setVisibility(4);
            return;
        }
        this.feF.a(i, z, i2, z2);
        if (this.eTZ != null && this.eTZ.fah != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.bVe != i3) {
                this.bVe = i3;
                if (this.feD == null) {
                    this.feD = new com.baidu.tieba.ala.liveroom.tippop.a(this.eTZ.pageContext, null);
                }
                switch (this.bVe) {
                    case 0:
                        this.feD.a(this.eTZ.rootView, this.eTZ.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.feD.a(this.eTZ.rootView, this.eTZ.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.feD.a(this.eTZ.rootView, this.eTZ.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.eTZ.fah.j(this.eTZ.fah.yN().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.bos();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bke().fah.yN(), 1, str3);
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
            if (this.feB != null) {
                this.feB.v(aVar);
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
                if (this.ffq != null) {
                }
                if (!"close_live".equals(str2)) {
                }
            }
            if (this.ffq != null) {
                this.ffq.cU(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bos();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bke().fah.yN(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bke().fah.yN() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bke().fah.yN().Ye.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bke().fah.yN().Ye.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bke().fah.yN().Ye.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.feW != null) {
                    this.feW.v(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.feC.at(optString4, optInt2);
                    }
                    if (this.eQT.getCount() > 20) {
                        this.eQT.cD(this.eQT.getCount() + 1);
                    } else if (this.eQO != null) {
                        com.baidu.live.data.a xo = aVar.xo();
                        com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                        gVar.XR = new AlaLocationData();
                        gVar.XS = new AlaRelationData();
                        gVar.XQ = new AlaLiveUserInfoData();
                        gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                        gVar.XQ.userName = xo.userName;
                        gVar.XQ.portrait = xo.portrait;
                        if (this.eQO.c(gVar)) {
                            this.eQT.cD(this.eQT.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt("event_type") == 1001 && bke().fah.yN() != null && bke().fah.yN().mLiveInfo != null) {
                    String str5 = bke().fah.yN().mLiveInfo.feed_id;
                    long j4 = bke().fah.yN().mLiveInfo.live_id;
                    long optLong2 = jSONObject2.optLong("id");
                    if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                        o.g(str5, j4);
                        com.baidu.live.utils.m.h(j4, optLong2);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bke() != null && bke().fah != null && bke().fah.yN() != null && bke().fah.yN().Ye != null && bke().fah.yN().Ye.userId == jSONObject2.optLong("user_id")) {
                    bke().fah.bpB();
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
                if (bke().fah != null && bke().fah.yN() != null && bke().fah.yN().mLiveInfo != null) {
                    j5 = bke().fah.yN().mLiveInfo.live_id;
                    j6 = bke().fah.yN().mLiveInfo.group_id;
                    j7 = bke().fah.yN().XQ.userId;
                    str7 = bke().fah.yN().mLiveInfo.appId;
                    if (bke().fah.yN().mLiveSdkInfo.mCastIds != null) {
                        String str8 = bke().fah.yN().mLiveSdkInfo.mCastIds.XX;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bke().fah.yN().mLiveSdkInfo.mCastIds.XY;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || bke().blK() != 2) {
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
                                                if (com.baidu.live.v.d.zq().dY(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                        dVar.eZA = optLong4;
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
                dVar2.eZA = optLong4;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void yK(String str) {
        if (this.eQV != null) {
            this.eQV.yK(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp(int i) {
        View findViewById = bke().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.eQV != null) {
            this.eQV.bj(2, i);
        }
    }

    private void bot() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bke().faH != null && AlaMasterLiveRoomOpearator.this.bke().faH.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bke().faH.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bke().faH.startRecord();
                }
            }
        });
    }

    private void bou() {
        if (bke().faH != null && bke().faH.getPreview() != null) {
            bke().faH.getPreview().setVisibility(8);
            bke().faH.stopRecord();
        }
    }

    public void bov() {
        this.faE = bke().fah.bpN();
        if (this.few != null) {
            this.few.jn(this.faE);
        }
    }

    public void blI() {
        if (TbadkCoreApplication.getInst().isOther()) {
            bow();
        } else if (this.few != null) {
            this.few.blI();
        }
    }

    public void onDestroy() {
        if (this.ffb != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.ffb);
        }
        this.ffb = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ffn != null) {
            this.ffn.jl(true);
        }
        this.ffn = null;
        if (this.few != null) {
            this.few.destroy();
            bke().rootView.removeView(this.few.getView());
            this.few.release();
            this.few = null;
        }
        if (this.ffq != null) {
            this.ffq.onDestroy();
        }
        if (this.eRF != null) {
            this.eRF.onDestroy();
        }
        if (this.eRH != null) {
            this.eRH.onDestroy();
        }
        if (this.eQP != null) {
            this.eQP.onDestroy();
            this.eQP = null;
        }
        if (this.fex != null) {
            this.fex.onDestroy();
        }
        if (this.eSd != null) {
            this.eSd.onDestroy();
            this.eSd = null;
        }
        if (this.feE != null) {
            this.feE.stopCountDown();
        }
        if (this.feA != null) {
            this.feA.onDestroy();
        }
        if (this.feC != null) {
            this.feC.onDestroy();
        }
        if (this.feW != null) {
            this.feW.onDestroy();
            this.feW = null;
        }
        if (this.eRS != null) {
            this.eRS.onDestroy();
            this.eRS = null;
        }
        t.sH();
        com.baidu.live.entereffect.a.qR().release();
        if (this.eRT != null) {
            this.eRT.onDestroy();
            this.eRT = null;
        }
        if (this.feD != null) {
            this.feD.onDestroy();
        }
        if (this.feB != null) {
            this.feB.bru();
            this.feB.release();
        }
        if (this.eQT != null) {
            this.eQT = null;
        }
        if (this.eQV != null) {
            this.eQV.release();
        }
        if (this.fey != null) {
            this.fey.onDestroy();
        }
        if (this.feB != null) {
            this.feB.onDestroy();
        }
        if (this.eRR != null) {
            this.eRR.release();
        }
        if (this.eSa != null) {
            this.eSa.release();
        }
        if (this.eSb != null) {
            this.eSb.onDestroy();
        }
        if (this.feY != null) {
            this.feY.onDestroy();
        }
        if (this.eSn != null) {
            this.eSn.release();
        }
        if (this.ffs != null) {
            this.ffs.onDestory();
        }
        if (this.fft != null) {
            this.fft.release();
        }
        if (this.eSl != null) {
            this.eSl.onDestroy();
        }
        if (this.ffu != null) {
            this.ffu.release();
        }
        MessageManager.getInstance().unRegisterListener(this.eTh);
        MessageManager.getInstance().unRegisterListener(this.ffO);
        MessageManager.getInstance().unRegisterListener(this.ffP);
        MessageManager.getInstance().unRegisterListener(this.ffQ);
        MessageManager.getInstance().unRegisterListener(this.eSP);
        MessageManager.getInstance().unRegisterListener(this.ffD);
        MessageManager.getInstance().unRegisterListener(this.ffA);
        MessageManager.getInstance().unRegisterListener(this.awi);
        MessageManager.getInstance().unRegisterListener(this.awj);
        MessageManager.getInstance().unRegisterListener(this.ffB);
        MessageManager.getInstance().unRegisterListener(this.eSR);
        MessageManager.getInstance().unRegisterListener(this.eSQ);
        MessageManager.getInstance().unRegisterListener(this.eSS);
        MessageManager.getInstance().unRegisterListener(this.ffC);
        MessageManager.getInstance().unRegisterListener(this.ffB);
        com.baidu.live.utils.m.Ba();
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eTZ.faN.a(this.ffS, this.eTZ.faI, this.feG, alaLivePersonData);
        }
    }

    private void bow() {
        if (this.feZ != null) {
            this.eTZ.faL.startTime = System.currentTimeMillis();
            this.eTZ.faL.liveTotalTime = System.currentTimeMillis();
            this.eTZ.faL.sampleMemAndCPU();
            this.eTZ.faJ.a((short) 4, this.feZ);
        }
    }

    private ViewGroup.LayoutParams box() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bke().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
