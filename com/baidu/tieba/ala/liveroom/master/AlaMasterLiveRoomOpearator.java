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
    private static final String ffg;
    private List<ag> awY;
    private String ePk;
    private com.baidu.live.g.a eQJ;
    private c eRA;
    private com.baidu.tieba.ala.liveroom.l.a eRB;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eRF;
    private com.baidu.tieba.ala.liveroom.activeview.b eRH;
    private m eSB;
    private i eSC;
    private j eSD;
    private u eSE;
    private s eSF;
    protected com.baidu.tieba.ala.liveroom.f.a eSM;
    protected h eSN;
    protected w eSP;
    protected com.baidu.live.i.a eSX;
    private com.baidu.live.q.a eSZ;
    private com.baidu.live.h.a eSq;
    private com.baidu.tieba.ala.liveroom.share.c eSr;
    private com.baidu.tieba.ala.liveroom.o.b eSs;
    private com.baidu.tieba.ala.liveroom.guide.c eSt;
    private com.baidu.tieba.ala.liveroom.watermark.a eSu;
    private boolean eTk;
    private f eUL;
    private ImageView eUT;
    private g eUU;
    private ImageView eUg;
    private boolean feQ;
    private ImageView ffA;
    private ImageView ffB;
    private ImageView ffC;
    private ImageView ffD;
    private ImageView ffE;
    private View ffF;
    private ImageView ffG;
    private TextView ffH;
    private x ffI;
    private com.baidu.live.x.a ffJ;
    private com.baidu.tieba.ala.liveroom.master.panel.b ffK;
    private com.baidu.live.w.a ffL;
    private e ffM;
    private short ffW;
    private boolean ffh;
    private d ffj;
    private com.baidu.tieba.ala.liveroom.l.a ffk;
    private com.baidu.tieba.ala.liveroom.e.c ffl;
    private com.baidu.tieba.ala.liveroom.b.a ffm;
    private com.baidu.tieba.ala.liveroom.r.a ffn;
    private com.baidu.tieba.ala.liveroom.u.a ffo;
    private b ffp;
    private com.baidu.tieba.ala.liveroom.tippop.a ffq;
    private AlaLiveCountDownView ffr;
    private AlaLiveStreamStatusView ffs;
    private RelativeLayout fft;
    private RelativeLayout ffu;
    private RelativeLayout ffv;
    private RelativeLayout ffw;
    private View ffx;
    private AlaLiveFaceVerifyView ffy;
    private ImageView ffz;
    private com.baidu.tieba.ala.liveroom.g.b fga;
    private boolean fgb;
    private boolean fgc;
    private com.baidu.tieba.ala.liveroom.challenge.f fgd;
    private com.baidu.live.b.a fgf;
    private com.baidu.live.b.b fgg;
    private com.baidu.tieba.ala.liveroom.n.a fgh;
    private boolean fgi;
    private BdUniqueId fgj;
    private boolean fgk;
    private boolean ffi = false;
    private boolean eTf = false;
    private Handler mHandler = new Handler();
    private boolean ffN = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver ffO = null;
    private boolean ffP = false;
    private int ffQ = 0;
    private int ffR = 0;
    private int ffS = 0;
    private long ffT = 0;
    private long ffU = 0;
    private volatile boolean isBackground = false;
    private Intent ffV = null;
    private int mOrientation = 1;
    private boolean fbq = false;
    private boolean ffX = false;
    private boolean ffY = true;
    private boolean eUR = false;
    private boolean ffZ = true;
    private int bVr = 0;
    public boolean fge = false;
    private String otherParams = "";
    private Runnable fgl = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.eQJ != null) {
                AlaMasterLiveRoomOpearator.this.eQJ.qV();
            }
        }
    };
    private CustomMessageListener awu = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eUL.fbz != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eUL.fbz.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.t(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener awv = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eUL.fbz != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eUL.fbz.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener eTw = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.eSs == null) {
                AlaMasterLiveRoomOpearator.this.eSs = new com.baidu.tieba.ala.liveroom.o.b(AlaMasterLiveRoomOpearator.this.bkm().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.eSs.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener eTD = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.eSX != null) {
                AlaMasterLiveRoomOpearator.this.eSX.vT();
            }
        }
    };
    private CustomMessageListener fgm = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eTt = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.eUL.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.yP(str);
            }
        }
    };
    private CustomMessageListener eTu = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aIh();
        }
    };
    private CustomMessageListener eTT = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.eSF.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eTB = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener fgn = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.fgg != null) {
                com.baidu.live.data.m yT = AlaMasterLiveRoomOpearator.this.bkm().faT.yT();
                long j = yT.mLiveInfo.live_id;
                long j2 = yT.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.fgg.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener fgo = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkm().faU);
            if (AlaMasterLiveRoomOpearator.this.ffj == null || AlaMasterLiveRoomOpearator.this.ffj.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qr(0);
            }
            if (AlaMasterLiveRoomOpearator.this.eSC != null) {
                AlaMasterLiveRoomOpearator.this.eSC.wv().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.eSC.ww().hide();
            }
        }
    };
    private CustomMessageListener eTC = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.p(AlaMasterLiveRoomOpearator.this.bkm().faT.yT());
        }
    };
    private CustomMessageListener eTE = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eSP != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.eSP).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener fgp = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.fgh != null) {
                    AlaMasterLiveRoomOpearator.this.fgh.yT(str);
                }
            }
        }
    };
    private CustomMessageListener fgq = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (AlaMasterLiveRoomOpearator.this.fgi) {
                        AlaMasterLiveRoomOpearator.this.bkm().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.bkm().fbt != null) {
                        AlaMasterLiveRoomOpearator.this.bkm().fbt.setDefBeautyParams(data.VU);
                    }
                    if (AlaMasterLiveRoomOpearator.this.fga != null) {
                        if (AlaMasterLiveRoomOpearator.this.fgj != null && AlaMasterLiveRoomOpearator.this.fgj == data.VW) {
                            if (!AlaMasterLiveRoomOpearator.this.fgk || AlaMasterLiveRoomOpearator.this.ffj.getVisibility() == 0) {
                                AlaMasterLiveRoomOpearator.this.fga.a(AlaMasterLiveRoomOpearator.this.bkm().fbt.getVideoConfig());
                            }
                            AlaMasterLiveRoomOpearator.this.fgj = null;
                            AlaMasterLiveRoomOpearator.this.fga.a(AlaMasterLiveRoomOpearator.this.bkm().fbt.getVideoConfig(), AlaMasterLiveRoomOpearator.this.fgb);
                            if (!AlaMasterLiveRoomOpearator.this.fgb) {
                                AlaMasterLiveRoomOpearator.this.fgb = true;
                            }
                        }
                        AlaMasterLiveRoomOpearator.this.fga.blE();
                    }
                }
                AlaMasterLiveRoomOpearator.this.fgi = false;
            }
        }
    };
    private View.OnClickListener fgr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.ffA) {
                    AlaMasterLiveRoomOpearator.this.bnM();
                    AlaMasterLiveRoomOpearator.this.ffK.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.ffz) {
                    if (AlaMasterLiveRoomOpearator.this.eSC != null) {
                        AlaMasterLiveRoomOpearator.this.eSC.ww().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.ffB) {
                    AlaMasterLiveRoomOpearator.this.aIh();
                } else if (view != AlaMasterLiveRoomOpearator.this.ffC) {
                    if (view == AlaMasterLiveRoomOpearator.this.ffE) {
                        if (AlaMasterLiveRoomOpearator.this.ffL != null) {
                            AlaMasterLiveRoomOpearator.this.ffL.showDialog();
                            AlaMasterLiveRoomOpearator.this.ffL.bj(AlaMasterLiveRoomOpearator.this.bnQ());
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eUT) {
                        if (AlaMasterLiveRoomOpearator.this.fgd != null) {
                            AlaMasterLiveRoomOpearator.this.fgd.bko();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.ffD) {
                        if (AlaMasterLiveRoomOpearator.this.ffo != null) {
                            com.baidu.tieba.ala.liveroom.data.h bpK = AlaMasterLiveRoomOpearator.this.bkm().faT.bpK();
                            if (bpK == null || bpK.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(bpK.mLiveSdkInfo.mRoomId);
                                if (bpK.mLiveSdkInfo.mCastIds != null) {
                                    str2 = bpK.mLiveSdkInfo.mCastIds.Yh;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.ffo.ad("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.ffG) {
                        com.baidu.live.data.m yT = AlaMasterLiveRoomOpearator.this.bkm().faT.yT();
                        if (AlaMasterLiveRoomOpearator.this.eSM != null && yT != null && yT.mLiveInfo != null) {
                            String valueOf = String.valueOf(yT.mLiveInfo.live_id);
                            String valueOf2 = String.valueOf(yT.mLiveInfo.feed_id);
                            long j = yT.mLiveInfo.room_id;
                            String str3 = yT.mLiveInfo.cover;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (yT.mLiveInfo.session_info != null) {
                                str4 = yT.mLiveInfo.session_info.flvUrl;
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
                            AlaMasterLiveRoomOpearator.this.eSM.yT(o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.fgk = false;
                    AlaMasterLiveRoomOpearator.this.jD(true);
                }
            }
        }
    };
    private CustomMessageListener eTv = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    AlaMasterLiveRoomOpearator.this.eTf = true;
                    AlaMasterLiveRoomOpearator.this.ffI = (x) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.eSC != null) {
                        AlaMasterLiveRoomOpearator.this.eSC.wv().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.eSC != null) {
                        AlaMasterLiveRoomOpearator.this.eSC.ww().show();
                        AlaMasterLiveRoomOpearator.this.eSC.ww().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.qr(8);
                }
            }
        }
    };
    private CustomMessageListener fgs = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bkm() != null && AlaMasterLiveRoomOpearator.this.bkm().fbx != null) {
                AlaMasterLiveRoomOpearator.this.bkm().fbx.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener feE = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.boz();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bkm().faT.qy(i);
                if (AlaMasterLiveRoomOpearator.this.eSX != null) {
                    AlaMasterLiveRoomOpearator.this.eSX.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener ePv = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bos();
        }
    };
    public final HttpMessageListener fgt = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.yW()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.ffK != null) {
                            AlaMasterLiveRoomOpearator.this.ffK.jJ(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.ffK.boX();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bkm().fbt.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.ffq != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.ffq.a(AlaMasterLiveRoomOpearator.this.bkm().rootView, AlaMasterLiveRoomOpearator.this.bkm().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bkm().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.ffq.qF(2);
                        AlaMasterLiveRoomOpearator.this.ffq.a(AlaMasterLiveRoomOpearator.this.bkm().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a fgu = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boG() {
            AlaMasterLiveRoomOpearator.this.bop();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boH() {
            AlaMasterLiveRoomOpearator.this.boq();
        }
    };
    com.baidu.live.liveroom.a.a fgv = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        @Override // com.baidu.live.liveroom.a.a
        public boolean cc(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cd(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ce(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bkm().blS() == 1) {
                AlaMasterLiveRoomOpearator.this.bkm().fbt.stopRecord();
            }
        }
    };
    private IShareCallback fgw = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.ffN && AlaMasterLiveRoomOpearator.this.ffM != null) {
                AlaMasterLiveRoomOpearator.this.ffN = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.ffM);
            }
        }
    };
    private View.OnTouchListener fgx = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bkm().fbx.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkm().faU);
            AlaMasterLiveRoomOpearator.this.qr(0);
            if (AlaMasterLiveRoomOpearator.this.eSC != null) {
                AlaMasterLiveRoomOpearator.this.eSC.wv().getView().setVisibility(0);
            }
            return false;
        }
    };
    private e.b fgy = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boI() {
            AlaMasterLiveRoomOpearator.this.bnL();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boJ() {
            AlaMasterLiveRoomOpearator.this.feQ = AlaMasterLiveRoomOpearator.this.ffj.blK();
            AlaMasterLiveRoomOpearator.this.bkm().fbx.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bkm().fbx.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bkm().fbx.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fbn = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bkm().blS();
            eVar.title = AlaMasterLiveRoomOpearator.this.ffj.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.fbo = AlaMasterLiveRoomOpearator.this.ffj.blL();
            eVar.fbr = AlaMasterLiveRoomOpearator.this.feQ;
            eVar.fbq = AlaMasterLiveRoomOpearator.this.ffj.blI();
            eVar.fbp = AlaMasterLiveRoomOpearator.this.ffj.blN();
            eVar.fbs = AlaMasterLiveRoomOpearator.this.ffj.blJ();
            if (eVar.fbs) {
                if (AlaMasterLiveRoomOpearator.this.ffj.blO()) {
                    AlaMasterLiveRoomOpearator.this.ffN = true;
                    AlaMasterLiveRoomOpearator.this.ffM = eVar;
                    AlaMasterLiveRoomOpearator.this.ffj.blP();
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
            AlaMasterLiveRoomOpearator.this.bkm().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bkm().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boK() {
            AlaMasterLiveRoomOpearator.this.fgk = true;
            AlaMasterLiveRoomOpearator.this.jD(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean boL() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boM() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boN() {
            o.k(AlaMasterLiveRoomOpearator.this.eUL.pageContext.getPageActivity(), "", "");
        }
    };
    private com.baidu.live.liveroom.g.c fgz = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void yR() {
            if (AlaMasterLiveRoomOpearator.this.ffo != null) {
                AlaMasterLiveRoomOpearator.this.ffo.jT(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.fgd != null) {
                        AlaMasterLiveRoomOpearator.this.fgd.d(AlaMasterLiveRoomOpearator.this.eUT);
                    }
                    if (AlaMasterLiveRoomOpearator.this.ffL != null) {
                        AlaMasterLiveRoomOpearator.this.ffL.bi(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.fgd != null) {
                        AlaMasterLiveRoomOpearator.this.fgd.bkp();
                    }
                    if (AlaMasterLiveRoomOpearator.this.ffL != null) {
                        AlaMasterLiveRoomOpearator.this.ffL.bi(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.ffo != null) {
                    AlaMasterLiveRoomOpearator.this.ffo.jT(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.eSP != null) {
                    AlaMasterLiveRoomOpearator.this.eSP.aB(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a fgA = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.ffy != null && AlaMasterLiveRoomOpearator.this.bkm().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.ffy) >= 0) {
                AlaMasterLiveRoomOpearator.this.bkm().rootView.removeView(AlaMasterLiveRoomOpearator.this.ffy);
                AlaMasterLiveRoomOpearator.this.ffy.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.ffy = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eSg = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            com.baidu.live.data.m yT;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.boy();
            } else if (i == 14 && (yT = AlaMasterLiveRoomOpearator.this.bkm().faT.yT()) != null && yT.Ya != null && yT.mLiveInfo != null && yT.Yo != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity(), yT.Ya.userName, Long.toString(yT.Ya.userId), Long.toString(yT.Ya.charmCount), String.valueOf(yT.mLiveInfo.group_id), String.valueOf(yT.mLiveInfo.live_id), true, String.valueOf(yT.Ya.userId), Long.toString(yT.Yo.userId), yT.Yo.userName, yT.Yo.portrait, AlaMasterLiveRoomOpearator.this.eRF.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(yT.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.eRF.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener fgB = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.fge = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fhD;
            }
        }
    };
    private HttpMessageListener fgC = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.ffH.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.ffH.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.ffH.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.ffH.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.awY = getVideoGoodsListHttpResponseMessage.awY;
            }
        }
    };
    private HttpMessageListener fgD = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awT != null && !eventPollingHttpResponseMessage.awT.isEmpty() && AlaMasterLiveRoomOpearator.this.bkm().faT != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.currentTime;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.awT.size()) {
                            break;
                        }
                        af afVar = eventPollingHttpResponseMessage.awT.get(i2);
                        if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                            com.baidu.live.utils.m.a(afVar, AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo);
                            com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                        }
                        i = i2 + 1;
                    }
                    af afVar2 = eventPollingHttpResponseMessage.awT.get(eventPollingHttpResponseMessage.awT.size() - 1);
                    if (j == afVar2.liveId) {
                        com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.awS;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bkm().faT != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null && AlaMasterLiveRoomOpearator.this.bkm().faT != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                com.baidu.live.utils.m.i(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a fgE = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
    };
    private com.baidu.live.liveroom.middleware.g fgF = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.Vs);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        ffg = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zs().awM != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bkm().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zs().awM.abe, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkm().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bkm().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zs().awM.aaB;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bkm().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bkm().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bkm().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.fgd != null) {
            this.fgd.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnL() {
        if (bkm() != null && bkm().faT != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bkm().faT.bpC();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bkm().faT.bpD();
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
                    AlaMasterLiveRoomOpearator.this.ffP = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.ffP = false;
                }
                if (AlaMasterLiveRoomOpearator.this.ffQ == 0) {
                    AlaMasterLiveRoomOpearator.this.ffQ = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.ffR == 0) {
                    AlaMasterLiveRoomOpearator.this.ffR = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.ffS = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bkm() != null && bkm().fbv != null) {
            bkm().fbv.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.eUL = fVar;
        this.ePk = str;
    }

    protected f bkm() {
        return this.eUL;
    }

    public int a(g gVar) {
        this.eUU = gVar;
        this.ffO = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.ffO, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.ffq == null) {
            this.ffq = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUL.pageContext, null);
        }
        registerListener();
        this.eQJ = new com.baidu.live.g.a();
        boa();
        Long[] lArr = new Long[1];
        this.ffT = lArr[0] == null ? 0L : lArr[0].longValue();
        this.ffU = lArr[0] != null ? lArr[0].longValue() : 0L;
        bkm().faU.setOnTouchListener(this.fgx);
        this.ffh = SharedPrefHelper.getInstance().getBoolean(ffg, false);
        this.ffr = new AlaLiveCountDownView(bkm().pageContext.getPageActivity());
        this.ffr.setCount(3);
        this.ffr.setTextColor(bkm().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.ffr.setTextSize(bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.ffr.setTypeface(Typeface.DEFAULT_BOLD);
        this.ffr.setIncludeFontPadding(false);
        this.ffr.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void boO() {
                if (AlaMasterLiveRoomOpearator.this.bkm().faU != null) {
                    AlaMasterLiveRoomOpearator.this.bkm().faU.removeView(AlaMasterLiveRoomOpearator.this.ffr);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnM() {
        if (this.ffK == null) {
            this.ffK = new com.baidu.tieba.ala.liveroom.master.panel.b(bkm().pageContext.getPageActivity(), bkm().blS() == 2);
            this.ffK.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkm().fbt.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jF(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkm().fbt.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jG(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkm().fbt.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.box();
                    if (AlaMasterLiveRoomOpearator.this.ffq != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.ffq.a(AlaMasterLiveRoomOpearator.this.bkm().rootView, AlaMasterLiveRoomOpearator.this.bkm().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.ffq.a(AlaMasterLiveRoomOpearator.this.bkm().rootView, AlaMasterLiveRoomOpearator.this.bkm().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jH(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boP() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bkm().faT != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boQ() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bkm().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boR() {
                    if (AlaMasterLiveRoomOpearator.this.bkm() != null && AlaMasterLiveRoomOpearator.this.bkm().faT != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.bkm().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.ffK != null) {
                            AlaMasterLiveRoomOpearator.this.ffK.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boS() {
                    long j = (AlaMasterLiveRoomOpearator.this.bkm() == null || AlaMasterLiveRoomOpearator.this.bkm().faT == null || AlaMasterLiveRoomOpearator.this.bkm().faT.yT() == null || AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bkm() != null && AlaMasterLiveRoomOpearator.this.bkm().faT != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eUL.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.ffK != null) {
                                        AlaMasterLiveRoomOpearator.this.ffK.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eUL.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.ffK != null) {
                        AlaMasterLiveRoomOpearator.this.ffK.dismiss();
                    }
                }
            });
        }
        bnN();
    }

    private void bnN() {
        if (this.ffK != null) {
            boolean isBackCamera = bkm().fbt.isBackCamera();
            this.ffK.jI(bkm().fbt.isBackCamera());
            this.ffK.F(bkm().fbt.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bkm().fbt.isPushMirror();
            if (this.ffY) {
                isPushMirror = bow() || isPushMirror;
                this.ffY = false;
            }
            this.ffK.G(isPushMirror, isBackCamera ? false : true);
            this.ffK.jJ(bkm().fbt.isMute());
            this.ffK.boX();
        }
    }

    public void bnO() {
        if (this.eUU != null) {
            if (this.eUU.fbA == null || this.eUU.fbA.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.ffx == null) {
                        this.ffx = this.eUL.fbz.yB();
                        this.eUL.rootView.addView(this.ffx, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.ffj == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bkm().faT != null && bkm().faT.yT() != null && bkm().faT.yT().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bkm().faT.yT().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bkm().faT.yT().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.ffj = new d(bkm().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bkm().fbx.prepareTime = System.currentTimeMillis();
                    bkm().rootView.addView(this.ffj.getView(), layoutParams);
                    this.ffj.a(this.fgw);
                }
                this.ffj.jp(this.fbq);
                this.ffj.a(this.fgy);
                this.ffj.a(this.fgu);
                this.ffj.a(bkm().fbt, bkm().blS());
                return;
            }
            this.feQ = this.eUU.fbA.mLiveInfo.screen_direction == 2;
            if (this.eUU.fbA.mLiveInfo.isAudioOnPrivate == 1) {
                bkm().fbt.setMute(true);
                if (this.ffq == null) {
                    this.ffq = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUL.pageContext, null);
                }
                if (!this.ffq.qE(2)) {
                    this.ffq.a(bkm().rootView, bkm().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.fbn = true;
            eVar.forumId = String.valueOf(this.eUU.fbA.mLiveInfo.forum_id);
            eVar.forumName = this.eUU.fbA.mLiveInfo.forum_name;
            eVar.liveType = this.eUU.fbA.mLiveInfo.live_type;
            eVar.title = this.eUU.fbA.mLiveInfo.getLiveTitle();
            eVar.clarity = this.eUU.fbA.mLiveInfo.clarity;
            eVar.gameId = this.eUU.fbA.mLiveInfo.game_id;
            eVar.gameName = this.eUU.fbA.mLiveInfo.game_label;
            eVar.fbr = this.eUU.fbA.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bnP() {
        if (this.fga != null) {
            this.fga.a(bkm().fbt.getVideoConfig(), false);
            this.fga.blE();
        }
        if (this.ffj != null) {
            this.ffj.jo(true);
        }
        if (bkm().fbt.hasBeauty() >= 0) {
            bkm().fbt.setBeauty(com.baidu.live.c.pw().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bkm().fbz.C(this.eUL.fbt);
        } else if (this.ffj != null) {
            this.ffj.jo(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.ffx != null && this.ffx.getParent() != null) {
                ((ViewGroup) this.ffx.getParent()).removeView(this.ffx);
                this.ffx = null;
            }
            bkm().faU.setVisibility(0);
            this.eUL.fbz.a(bkm().faU);
        } else {
            bof();
            bov();
            this.ffo = new com.baidu.tieba.ala.liveroom.u.a(bkm().pageContext, this.fgv);
            this.ffo.d(bkm().faU, true);
            this.ffo.jT(true);
            if (this.eSC != null && this.eSC.wv() != null) {
                this.eSC.wv().setNeedTopAlphaShade(true);
            }
        }
        bkm().fbt.setPushMirror(bow());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUL.fbz.j(bkm().faT.yT());
        }
        if (!bkm().fbt.isBackground() && bkm().faT.yT() != null && bkm().faT.yT().mLiveInfo != null) {
            int startPush = bkm().fbt.startPush(bkm().faT.yT().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eUL.fbz.yC();
            }
            if (startPush != 0 && bkm().fbx != null) {
                bkm().fbx.errCode = 4;
                bkm().fbx.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.blX() && !bot()) {
                jE(true);
                bou();
            }
            if (this.ffl != null) {
                this.ffl.q(bkm().faT.yT());
            }
            if (this.eRB != null) {
                this.eRB.u(bkm().faT.yT());
            }
            if (this.eSq != null) {
                this.eSq.a(bkm().faT.yT());
            }
            if (this.ffm != null && bkm() != null && bkm().faT != null) {
                if (this.ffm.ah(bkm().faU)) {
                    this.ffm.o(bkm().faT.yT());
                } else {
                    this.ffm.b(bkm().faU, bkm().faT.yT());
                }
            }
            if (this.ffk != null) {
                this.ffk.u(bkm().faT.yT());
            }
            if (hVar == null || hVar.Ya == null) {
                z = com.baidu.live.c.pw().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.Ya.canUseChallenge;
                com.baidu.live.c.pw().putBoolean("ala_master_can_use_challenge", z);
            }
            bog();
            bnT();
            jB(z);
            boh();
            bom();
            bjn();
            bjB();
            v(bkm().faT.yT());
            f(bkm().faT.yT());
            bon();
            boo();
            bok();
            bjp();
            bjw();
            bjx();
            if (this.eSB != null) {
                this.eSB.g(bkm().faT.yT());
            }
            if (this.eSC != null) {
                this.eSC.e(String.valueOf(bkm().faT.yT().mLiveInfo.group_id), String.valueOf(bkm().faT.yT().mLiveInfo.last_msg_id), String.valueOf(bkm().faT.yT().Ya.userId), String.valueOf(bkm().faT.yT().mLiveInfo.live_id), bkm().faT.yT().Ya.appId);
            }
            if (this.eSD != null) {
                this.eSD.a(bkm().faT.yT(), true);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                com.baidu.live.utils.m.i(bkm().faT.yT().mLiveInfo.user_id, bkm().faT.yT().mLiveInfo.live_id);
            }
            this.mHandler.post(this.fgl);
        }
    }

    private void jB(boolean z) {
        if (this.fgd == null) {
            this.fgd = new com.baidu.tieba.ala.liveroom.challenge.f(bkm());
        }
        this.fgd.a(this.eUT, this.eUU);
        this.fgd.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ad adVar, ae aeVar, ae aeVar2) {
                if (AlaMasterLiveRoomOpearator.this.eSu != null) {
                    AlaMasterLiveRoomOpearator.this.eSu.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bkm().faU.fnO = false;
                AlaMasterLiveRoomOpearator.this.bnR();
                if (AlaMasterLiveRoomOpearator.this.eSZ != null) {
                    AlaMasterLiveRoomOpearator.this.eSZ.b(AlaMasterLiveRoomOpearator.this.jC(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void pW() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fgl);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bkk() {
                if (AlaMasterLiveRoomOpearator.this.eSu != null) {
                    AlaMasterLiveRoomOpearator.this.eSu.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bkm().faU.fnO = true;
                AlaMasterLiveRoomOpearator.this.bnS();
                if (AlaMasterLiveRoomOpearator.this.eSZ != null) {
                    AlaMasterLiveRoomOpearator.this.eSZ.b(AlaMasterLiveRoomOpearator.this.jC(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bkl() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.fgl);
            }
        });
        this.fgd.D(this.feQ, z);
        this.fgd.h(this.feQ, z, (this.eUU == null || this.eUU.fbA == null || this.eUU.fbA.mChallengeData == null) ? false : true);
    }

    public boolean bnQ() {
        return this.fgd != null && this.fgd.bkr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnR() {
        if (this.ffp != null) {
            this.ffp.setVisible(8);
            this.ffp.setCanVisible(false);
        }
        if (this.eRH != null) {
            this.eRH.iO(true);
            jh(true);
        }
        if (this.ffs != null) {
            this.ffs.setCanVisible(false);
            this.ffs.setVisibility(4);
        }
        if (this.ffo != null) {
            this.ffo.jS(false);
        }
        if (this.eSC != null) {
            this.eSC.wv().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnS() {
        if (this.ffp != null) {
            this.ffp.setCanVisible(true);
        }
        if (this.eRH != null) {
            this.eRH.iO(false);
            jh(false);
        }
        if (this.ffs != null) {
            this.ffs.setCanVisible(true);
        }
        if (this.ffo != null) {
            this.ffo.jS(true);
        }
        if (this.eSC != null) {
            this.eSC.wv().setNeedTopAlphaShade(false);
        }
    }

    private void jh(boolean z) {
        ViewGroup.LayoutParams pS;
        if (this.eRH != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.eRH;
            AlaLiveView alaLiveView = bkm().faU;
            if (z) {
                pS = boF();
            } else {
                pS = pS(1);
            }
            bVar.a(1, alaLiveView, pS, 21);
            this.eRH.updateView();
        }
    }

    private void bnT() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.ffs == null) {
            this.ffs = new AlaLiveStreamStatusView(bkm().pageContext.getPageActivity());
        }
        this.ffs.setId(a.g.ala_live_room_stream_view);
        this.ffs.setVisibility(4);
        this.ffs.setLayoutParams(layoutParams);
        if (this.ffs.getParent() == null) {
            bkm().faU.addView(this.ffs, layoutParams);
        }
    }

    public void bnU() {
        if (this.ffj != null && this.ffj.getVisibility() != 8 && bkm().fbt.getPreview() != null) {
            bkm().fbt.stopRecord();
        }
    }

    public void bnV() {
        if (bkm().fbt.getPreview() != null) {
            bkm().fbt.stopRecord();
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.fga != null) {
                this.fga.jn(false);
            }
            this.fga = new com.baidu.tieba.ala.liveroom.g.b(bkm().rootView, bkm(), bkm().fbt);
            this.fga.a(bkm().fbt.getVideoConfig(), false);
            this.fga.blE();
        }
        if (this.ffq != null) {
            this.ffq.bqG();
        }
        this.mHandler.post(this.fgl);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.ffi = z;
        if (z) {
            Rect rect = new Rect();
            bkm().faU.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            bkm().faU.getGlobalVisibleRect(rect2);
            if (this.eSC != null && this.eSC.wv() != null) {
                this.eSC.wv().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSC.wv().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.eSC.wv().getView().setLayoutParams(layoutParams);
            }
            if (this.eSC != null && this.eSC.ww() != null) {
                int i = rect2.bottom - rect.bottom;
                this.eSC.ww().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eSC.ww().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.eSC.ww().getView().setLayoutParams(layoutParams2);
                this.eSC.ww().getView().setVisibility(0);
            }
            qr(8);
            qq(8);
        } else {
            if (this.eSC != null && this.eSC.wv() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eSC.wv().getView().getLayoutParams();
                layoutParams3.bottomMargin = bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.eSC.wv().getView().setLayoutParams(layoutParams3);
            }
            if (this.eSC != null && this.eSC.ww() != null) {
                this.eSC.ww().hide();
            }
            qr(0);
            qq(0);
        }
        if (this.ffj != null) {
            this.ffj.e(false, z);
        }
        if (this.eSD != null) {
            this.eSD.wD();
        }
        if (this.ffL != null) {
            this.ffL.onKeyboardVisibilityChanged(z);
        }
        if (this.eSC != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bkm().pageContext.getPageActivity())) + bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (bkm().faU.indexOfChild(this.eSC.wv().getView()) != -1 && this.eSC.wv().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eSC.wv().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.eSC.wv().getView().setLayoutParams(layoutParams4);
            }
            this.eSC.wv().wu();
        }
        this.mHandler.post(this.fgl);
    }

    private void qq(int i) {
        if (this.eRB != null) {
            this.eRB.qd(i);
        }
        if (this.ffu != null) {
            this.ffu.setVisibility(i);
        }
        if (this.eSq != null) {
            this.eSq.getView().setVisibility(i);
        }
        if (this.ffn != null) {
            this.ffn.setVisible(i);
        }
        if (this.ffm != null) {
            this.ffm.setVisibility(i);
        }
        if (this.eRH != null) {
            this.eRH.setVisible(i);
        }
        if (this.eSZ != null) {
            this.eSZ.setCanVisible(i == 0);
        }
        if (this.eSN != null) {
            this.eSN.setVisible(i);
        }
        if (this.eSX != null) {
            this.eSX.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bkm().fbx.errCode = 1;
            bop();
        } else if (i == -5) {
            boq();
        } else if (i == -2) {
            zg(bkm().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bkm().fbt.stopRecord();
        } else if (i == -3 && this.ffj != null) {
            this.ffj.jo(false);
        }
        if (i == -4) {
            if (this.ffj == null || this.ffj.getView().getParent() == null) {
                bkm().f((short) 1);
                return;
            }
            this.ffj.blM();
            this.ffC.setVisibility(0);
            if (this.ffo != null) {
                this.ffo.jT(true);
            }
            bkm().faU.setBackgroundColor(bkm().pageContext.getResources().getColor(17170445));
            boC();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bjM();
        if (i == 12001) {
            if (i2 == -1) {
                zh(ac(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                ad(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aIh();
        }
    }

    public void onResume() {
        if (this.ffj != null) {
            this.ffj.onResume();
        }
        if (this.ffN && this.ffM != null) {
            this.ffN = false;
            c(this.ffM);
        }
        if (this.eSP != null) {
            this.eSP.onResume();
        }
    }

    public void g(short s) {
        if (this.eSB != null) {
            this.eSB.sQ();
        }
        if (this.eSC != null) {
            this.eSC.a(null);
            this.eSC.wb();
        }
        if (this.eSD != null) {
            this.eSD.wb();
        }
        if (this.fgd != null) {
            this.fgd.bkq();
        }
    }

    public boolean bnW() {
        com.baidu.live.data.m yT = bkm().faT.yT();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUL.fbz.i(yT);
            if (yT != null && yT.mLiveInfo.live_status != 1) {
                boA();
                bkm().pageContext.getPageActivity().finish();
                if (bkm().faT != null && bkm().faT.yT() != null) {
                    a(yT, 1, bkm().faT.bpU() != 1 ? bkm().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.eSC != null) {
                this.eSC.wv().a(String.valueOf(yT.mLiveInfo.group_id), String.valueOf(yT.mLiveInfo.live_id), true, String.valueOf(yT.Ya.userId));
            }
            if (this.eSD != null) {
                this.eSD.a(yT);
            }
            if (this.eSq != null) {
                this.eSq.a(bkm().faT.yT());
            }
            if (this.eRB != null) {
                this.eRB.u(yT);
            }
            if (yT != null) {
                if (this.ffl != null) {
                    this.ffl.q(yT);
                }
                if (this.fgd != null) {
                    this.fgd.a(yT);
                }
                if (this.eSF != null && yT.mLiveInfo != null) {
                    this.eSF.a(yT.mLiveInfo);
                }
                if (this.eSZ != null) {
                    this.eTk = this.eSZ.m(yT);
                }
                if (this.eRH != null) {
                    this.eRH.iP(this.eTk);
                    this.eRH.h(yT);
                    this.eRH.updateView();
                }
                if (this.eSX != null) {
                    this.eSX.a(yT);
                }
                if (yT.mLiveInfo.live_status != 1) {
                    boA();
                    bkm().pageContext.getPageActivity().finish();
                    if (bkm().faT != null && bkm().faT.yT() != null) {
                        a(yT, 1, bkm().faT.bpU() != 1 ? bkm().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.fge) {
                    this.ffF.setVisibility(0);
                    if (!this.fgc && yT.mLiveInfo != null) {
                        this.fgc = true;
                        o.g(yT.mLiveInfo.feed_id, yT.mLiveInfo.live_id);
                    }
                } else {
                    this.ffF.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bnX() {
        bnN();
    }

    public void bnY() {
        if (this.fga != null) {
            this.fga.blF();
        }
    }

    public void bnZ() {
        if (this.ffj != null && this.ffj.getVisibility() != 8) {
            if (bkm().blS() == 2) {
                boC();
            } else {
                boB();
            }
        }
        if (this.ffj != null && this.ffj.getVisibility() != 8) {
            if (bkm().blS() == 1) {
                this.ffj.onResume();
            }
            this.ffj.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.eTf && this.ffI != null) {
            if (this.eSC != null) {
                this.eSC.wv().getView().setVisibility(0);
            }
            if (this.eSC != null) {
                this.eSC.ww().show();
                this.eSC.ww().setEditText(" @" + this.ffI.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            qr(8);
            this.eTf = false;
        }
        if (this.eSM != null) {
            this.eSM.resume();
        }
        if (this.fgg != null) {
            this.fgg.resume();
        }
        if (this.fgh != null) {
            this.fgh.resume();
        }
    }

    public void onPause() {
        if (this.eSM != null) {
            this.eSM.pause();
        }
        if (this.fgg != null) {
            this.fgg.pause();
        }
        if (this.eSP != null) {
            this.eSP.onPause();
        }
        if (this.fgh != null) {
            this.fgh.pause();
        }
    }

    private void boa() {
        this.fft = (RelativeLayout) bkm().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.ffv = (RelativeLayout) bkm().rootView.findViewById(a.g.under_live_view_panel);
        this.ffw = (RelativeLayout) bkm().rootView.findViewById(a.g.over_live_view_panel);
        this.eUL.faU.setOnLiveViewScrollListener(this.fgz);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.ffv.setVisibility(8);
            this.ffw.setVisibility(8);
            bkm().faU.removeAllViews();
        } else {
            this.ffu = (RelativeLayout) bkm().rootView.findViewById(a.g.ala_live_removeable_top_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ffu.getLayoutParams();
            layoutParams.topMargin = this.eUL.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.eUL.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
            }
            this.ffu.setLayoutParams(layoutParams);
            if (this.eRF == null) {
                this.eRF = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.eUL.pageContext.getPageActivity(), false);
            }
            this.eRF.a(this.eSg);
            this.eRF.a(this.ffu, a.g.ala_live_room_host_header_stub, 1L);
            this.eRF.setVisible(0);
            this.ffC = (ImageView) bkm().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
            this.ffC.setOnClickListener(this.fgr);
            this.ffE = (ImageView) bkm().rootView.findViewById(a.g.ala_liveroom_host_paster);
            this.ffE.setOnClickListener(this.fgr);
            if (com.baidu.live.v.a.zs().axR != null && com.baidu.live.v.a.zs().axR.ada != null && com.baidu.live.v.a.zs().axR.ada.qN() && an.b(com.baidu.live.v.a.zs().axR)) {
                this.ffE.setVisibility(0);
            } else {
                this.ffE.setVisibility(8);
            }
            if (an.c(com.baidu.live.v.a.zs().axR)) {
                this.ffC.setVisibility(0);
                if (an.c(com.baidu.live.v.a.zs().axR)) {
                    this.ffC.setAlpha(0.2f);
                }
            } else if (bkm().fbt.hasBeauty() < 0) {
                this.ffC.setVisibility(8);
            } else {
                if (an.c(com.baidu.live.v.a.zs().axR)) {
                    this.ffC.setAlpha(0.2f);
                }
                com.baidu.live.c.pw().getInt("live_beauty_level", 3);
            }
            this.ffB = (ImageView) bkm().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
            this.ffB.setOnClickListener(this.fgr);
            this.ffz = (ImageView) bkm().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
            this.ffz.setOnClickListener(this.fgr);
            this.eUT = (ImageView) bkm().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
            this.eUT.setOnClickListener(this.fgr);
            this.ffA = (ImageView) bkm().rootView.findViewById(a.g.ala_liveroom_host_more);
            this.ffA.setOnClickListener(this.fgr);
            this.ffD = (ImageView) bkm().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
            this.ffD.setOnClickListener(this.fgr);
            this.ffF = bkm().rootView.findViewById(a.g.host_goods_layout);
            this.ffG = (ImageView) bkm().rootView.findViewById(a.g.host_goods_imageView);
            this.ffH = (TextView) bkm().rootView.findViewById(a.g.host_goods_num_textView);
            this.ffG.setOnClickListener(this.fgr);
            boe();
            bod();
            this.fga = new com.baidu.tieba.ala.liveroom.g.b(bkm().rootView, bkm(), bkm().fbt);
            this.eSB = new m();
            bob();
            boc();
            if (this.eSE != null && this.eSE.sp() != null) {
                this.eSE.sp().bringToFront();
            }
        }
        this.fga = new com.baidu.tieba.ala.liveroom.g.b(bkm().rootView, bkm(), bkm().fbt);
    }

    private void bob() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, bkm().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eSC = (i) runTask.getData();
            this.eSC.setFromMaster(true);
            this.eSC.wv().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bkm().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(bkm().pageContext.getPageActivity()) * 0.27f)) + bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            bkm().faU.addView(this.eSC.wv().getView(), layoutParams);
            this.eSC.ww().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bkm().faU.addView(this.eSC.ww().getView(), layoutParams2);
            this.eSC.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
                @Override // com.baidu.live.im.i.a
                public boolean wx() {
                    return true;
                }

                @Override // com.baidu.live.im.i.a
                public void wy() {
                }

                @Override // com.baidu.live.im.i.a
                public void dL(String str) {
                }

                @Override // com.baidu.live.im.i.a
                public void wz() {
                }

                @Override // com.baidu.live.im.i.a
                public void wA() {
                }

                @Override // com.baidu.live.im.i.a
                public boolean wB() {
                    return false;
                }
            });
        }
    }

    private void boc() {
        View wC;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, j.class, bkm().pageContext);
        if (runTask != null) {
            this.eSD = (j) runTask.getData();
        }
        if (this.eSD != null && (wC = this.eSD.wC()) != null && this.eUL.faU.indexOfChild(wC) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.eUL.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bkm().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bkm().faU.addView(wC, layoutParams);
        }
    }

    private void bod() {
        CustomResponsedMessage runTask;
        if (this.ffJ == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bkm().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.ffJ = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void boe() {
        View sp;
        t.b(bkm().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.afR = true;
        fVar.context = bkm().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.eSE = (u) runTask.getData();
            if (this.eSE != null && (sp = this.eSE.sp()) != null && bkm().faU.indexOfChild(sp) < 0) {
                if (sp.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sp.getParent()).removeView(sp);
                }
                bkm().faU.addView(sp, bkm().faU.getLayoutParams());
            }
        }
    }

    protected void bjx() {
        View sH;
        if (this.eSF == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afR = true;
            aVar.context = bkm().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSF = (s) runTask.getData();
            }
        }
        if (this.eSF != null && (sH = this.eSF.sH()) != null) {
            if (bkm().faU.indexOfChild(sH) < 0) {
                if (sH.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sH.getParent()).removeView(sH);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bkm().faU.addView(sH, layoutParams);
            }
            sH.bringToFront();
        }
    }

    protected void bjw() {
        View sR;
        if (this.eSP == null) {
            z zVar = new z();
            zVar.afR = true;
            zVar.pageContext = bkm().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSP = (w) runTask.getData();
            }
        }
        if (this.eSP != null && (sR = this.eSP.sR()) != null && bkm().faU.indexOfChild(sR) < 0) {
            if (sR.getParent() instanceof ViewGroup) {
                ((ViewGroup) sR.getParent()).removeView(sR);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bkm().faU.addView(sR, layoutParams);
        }
    }

    private void bof() {
        boj();
        biB();
        boi();
        bkm().faU.setVisibility(0);
        qr(0);
    }

    private void bog() {
        if (this.ffn == null) {
            this.ffn = new com.baidu.tieba.ala.liveroom.r.a(bkm().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.ffn.a(bkm().blS(), j, TbadkCoreApplication.getCurrentAccountName(), true, bkm().faT.yT().Ya.portrait, this.otherParams, "", -1L);
        this.ffn.ag(bkm().faU);
    }

    private void boh() {
        if (this.ffL == null) {
            com.baidu.live.w.a eF = eF(bkm().pageContext.getPageActivity());
            if (eF != null) {
                this.ffL = eF;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bkm().pageContext.getPageActivity());
                if (runTask != null) {
                    this.ffL = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.ffL != null) {
                this.ffL.h(this.ffv);
                this.ffL.i(this.ffw);
                this.ffL.ci((bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.eSu != null) {
                    this.ffL.ch(this.eSu.brA());
                }
                this.ffL.j(bkm().faU);
                this.ffL.a(this.eQJ);
                this.ffL.n(bkm().faT.yT());
                this.ffL.a(this.eRH);
                this.ffL.a(new a.InterfaceC0105a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
                });
            }
        }
    }

    private com.baidu.live.w.a eF(Context context) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913157, com.baidu.live.liveroom.middleware.ar.a.class, null);
        if (runTask != null) {
            return ((com.baidu.live.liveroom.middleware.ar.a) runTask.getData()).aE(context);
        }
        return null;
    }

    private void boi() {
        if (this.ffp == null) {
            this.ffp = new b(bkm().pageContext, bkm().faU);
        }
    }

    private void boj() {
        if (this.eRB == null) {
            this.eRB = new com.baidu.tieba.ala.liveroom.l.a(bkm().pageContext, true, this.fgv);
            this.eRB.c(this.fft, (com.baidu.live.data.m) null);
            this.eRB.a(this.eSg);
        }
        if (this.ffk == null) {
            this.ffk = new com.baidu.tieba.ala.liveroom.l.a(bkm().pageContext, true, null);
            this.ffk.a(this.ffu, null, a.g.ala_live_room_host_header_stub);
            this.ffk.bne();
        }
    }

    protected void bjg() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bpK = bkm().faT.bpK();
        boolean z2 = com.baidu.live.v.a.zs().awM.abd;
        if (bpK == null || bpK.Yy) {
            z = z2;
        }
        if (z && this.eSq == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bkm().pageContext)) != null) {
            this.eSq = (com.baidu.live.h.a) runTask.getData();
            if (this.eSq != null) {
                this.eSq.setIsHost(true);
                this.eSq.bV(1);
                View view = this.eSq.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bkm().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bkm().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.ffu.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(com.baidu.live.data.m mVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.eRH == null) {
            this.eRH = new com.baidu.tieba.ala.liveroom.activeview.b(bkm().pageContext);
        }
        this.eRH.setOtherParams(this.otherParams);
        this.eRH.b(mVar, false);
        this.eRH.setHost(true);
        this.eRH.a(1, bkm().faU, pS(1));
        this.eRH.a(2, bkm().faU, pS(2));
        this.eRH.iP(this.eTk);
        this.eRH.setVisible(this.ffi ? 8 : 0);
        this.eRH.a(this.eQJ);
        if (this.eQJ != null) {
            if (this.eRH != null) {
                alaActiveRootView2 = this.eRH.pN(1);
                alaActiveRootView = this.eRH.pN(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.eQJ.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.eQJ.a(alaActiveRootView);
            }
        }
    }

    private void v(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        if (this.eSZ == null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bkm().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSZ = (com.baidu.live.q.a) runTask.getData();
            if (this.eSZ != null) {
                this.eSZ.a(bkm().faU, jC(false));
            }
        }
        if (this.eSZ != null) {
            this.eTk = this.eSZ.m(mVar);
            this.eSZ.setCanVisible(!this.ffi);
        }
    }

    protected void bok() {
        CustomResponsedMessage runTask;
        if (bkm() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bkm().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSX = (com.baidu.live.i.a) runTask.getData();
            this.eSX.a(bkm().faU, bol());
            if (bkm().faT != null) {
                this.eSX.a(bkm().faT.yT());
            }
            this.eSX.setCanVisible(true);
            this.eSX.aP(false);
            this.eSX.a(bkm().faT.bee());
        }
    }

    private void bjp() {
        this.fgh = new com.baidu.tieba.ala.liveroom.n.c(bkm().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bol() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bkm().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.eSN != null && this.eSN.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.ffn != null && this.ffn.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams pS(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bkm().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.ffs != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bkm().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup.LayoutParams jC(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bkm().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.fgd != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.fgd.au(true) + bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.ffs != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void biB() {
        if (this.ffm == null) {
            this.ffm = new com.baidu.tieba.ala.liveroom.b.a(bkm().pageContext, true);
        }
    }

    private void bom() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bkm().pageContext.getPageActivity();
            this.eUg = new ImageView(pageActivity);
            this.eUg.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.eUg.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eUg.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bkm().rootView.addView(this.eUg, layoutParams);
            this.eUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.boy();
                }
            });
            this.eUg.setVisibility(8);
        }
    }

    private void bjn() {
        this.eSM = new com.baidu.tieba.ala.liveroom.f.a(bkm().pageContext);
    }

    private void bjB() {
        if (this.eSN == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bkm().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSN = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.eSN.setHost(true);
        this.eSN.setOtherParams(this.otherParams);
        if (bkm().faT.yT() != null && bkm().faT.yT().Ya != null && bkm().faT.yT().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.eSN.a(bkm().faU, layoutParams, bkm().faT.yT());
        }
    }

    private void bon() {
        CustomResponsedMessage runTask;
        if (this.fgf == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bkm().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.fgf = (com.baidu.live.b.a) runTask.getData();
            if (this.fgf != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bkm().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.fgf.a(bkm().faU, layoutParams);
            }
        }
        if (this.fgf != null) {
            this.fgf.a(bkm().faT.yT());
        }
    }

    private void boo() {
        CustomResponsedMessage runTask;
        if (this.fgg == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bkm().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.fgg = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.fgd != null) {
            this.fgd.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bkm().pageContext.registerListener(this.eTt);
        bkm().pageContext.registerListener(this.fgm);
        bkm().pageContext.registerListener(this.eTv);
        bkm().pageContext.registerListener(this.eTw);
        bkm().pageContext.registerListener(this.fgs);
        bkm().pageContext.registerListener(this.feE);
        bkm().pageContext.registerListener(this.ePv);
        bkm().pageContext.registerListener(this.fgt);
        bkm().pageContext.registerListener(this.eTu);
        bkm().pageContext.registerListener(this.eTT);
        bkm().pageContext.registerListener(this.fgB);
        bkm().pageContext.registerListener(this.fgC);
        bkm().pageContext.registerListener(this.fgD);
        bkm().pageContext.registerListener(this.eTB);
        bkm().pageContext.registerListener(this.fgq);
        bkm().pageContext.registerListener(this.fgn);
        bkm().pageContext.registerListener(this.awu);
        bkm().pageContext.registerListener(this.awv);
        bkm().pageContext.registerListener(this.fgo);
        bkm().pageContext.registerListener(this.eTD);
        bkm().pageContext.registerListener(this.eTC);
        bkm().pageContext.registerListener(this.eTE);
        bkm().pageContext.registerListener(this.fgp);
        bkm().pageContext.registerListener(this.fgo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jD(boolean z) {
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (an.c(com.baidu.live.v.a.zs().axR)) {
                bkm().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
                return;
            } else if (bkm().fbw.pF() == null || ListUtils.isEmpty(bkm().fbw.pF().VT) || bkm().fbw.pF().VU == null || bkm().fbw.pF().VU.isEmpty()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    bkm().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
                    return;
                } else if (!this.fgi) {
                    this.fgj = BdUniqueId.gen();
                    bkm().fbw.a(this.fgj);
                    this.fgi = true;
                    return;
                } else {
                    return;
                }
            }
        }
        BdUtilHelper.hideSoftKeyPad(bkm().pageContext.getPageActivity(), bkm().rootView);
        qr(8);
        if (bkm().fbt.hasAdvancedBeauty() && this.fga != null) {
            if (!this.fgk || this.ffj.getVisibility() == 0) {
                this.fga.a(bkm().fbt.getVideoConfig());
            }
            this.fga.a(bkm().fbt.getVideoConfig(), this.fgb);
            if (!this.fgb) {
                this.fgb = true;
            }
        }
        if (z && this.eSC != null) {
            this.eSC.wv().getView().setVisibility(8);
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
    public void bop() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkm().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bkm().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkm().f((short) 1);
            }
        });
        bdAlertDialog.create(bkm().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boq() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkm().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bkm().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkm().f((short) 1);
            }
        });
        bdAlertDialog.create(bkm().pageContext).show();
    }

    private void zg(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkm().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkm().f((short) 1);
            }
        });
        bdAlertDialog.create(bkm().pageContext).show();
    }

    public void bor() {
        bjg();
        com.baidu.live.data.h bee = bkm().faT.bee();
        int i = 5;
        if (bee != null) {
            i = (int) bee.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null && AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bkm().faT.cX(AlaMasterLiveRoomOpearator.this.bkm().faT.yT().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bee != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eUL.fbz.b(bee);
                return;
            }
            if (this.eRA == null) {
                this.eRA = new c(bkm().pageContext, this.fgv, true);
            }
            if (this.ffZ) {
                this.ffZ = false;
                this.eRA.a(String.valueOf(bkm().faT.yT().mLiveInfo.group_id), String.valueOf(bkm().faT.yT().mLiveInfo.live_id), String.valueOf(bkm().faT.yT().Ya.userId), bkm().faT.yT());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.eSq != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.eRA.c(this.ffu, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.eRA.f(bee);
            this.eRF.setVisible(0);
            this.eRF.cD(bee.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIh() {
        if (bkm().faT != null) {
            if (this.eSr == null) {
                this.eSr = new com.baidu.tieba.ala.liveroom.share.c(bkm().pageContext);
            }
            this.eSr.c(bkm().faT.yT(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bkm().faT != null && bkm().faT.yT() != null && bkm().faT.yT().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bkm().faT.yT().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bkm().faT.yT().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bkm().faT.yT().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bkm().faT != null && bkm().faT.yT() != null && bkm().faT.yT().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bkm().faT.yT().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bkm().faT.yT().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bkm().faT.yT().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean bot() {
        return this.ffh;
    }

    private void jE(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(ffg, z);
        this.ffh = z;
    }

    private void bou() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkm().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.bkm().pageContext).bps();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bkm().pageContext).show();
    }

    private void bov() {
        if (this.feQ && bkm().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bkm().fby.Ah();
        }
        bkm().fbx.prepareTime = System.currentTimeMillis() - bkm().fbx.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bkm().faT != null && bkm().faT.yT() != null && bkm().faT.yT().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bkm().faT.yT().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bkm().faT.yT().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bkm().fbx.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.ffj != null && this.ffj.getView().getParent() != null) {
            this.ffj.setVisibility(8);
            bkm().rootView.removeView(this.ffj.getView());
            this.ffj.release();
        }
        if (this.fga != null) {
            this.fga.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bkm().faU.indexOfChild(this.ffr) < 0) {
            bkm().faU.addView(this.ffr, layoutParams);
        }
        this.ffr.qG(1000);
    }

    private void bjM() {
        if (bkm().blS() == 1) {
            bkm().fbt.startRecord();
        }
    }

    private void zh(String str) {
        zi(str);
    }

    private void zi(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bkm().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.ffj != null) {
            this.ffj.yW(fromJson.getSmallurl());
        }
    }

    private boolean bow() {
        return com.baidu.live.c.pw().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void box() {
        com.baidu.live.c.pw().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.eUL.fbt.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boy() {
        int i = a.i.live_close_confirm;
        if (this.fgd != null && this.fgd.bks()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.fgd != null && this.fgd.bkr()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkm().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bkm().faT.yT() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkm().faT.yT(), 0, AlaMasterLiveRoomOpearator.this.bkm().faT.bpU() != 1 ? AlaMasterLiveRoomOpearator.this.bkm().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bkm().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.m mVar, int i, String str) {
        AlaLiveInfoData alaLiveInfoData;
        AlaLiveUserInfoData alaLiveUserInfoData = null;
        if (mVar != null) {
            AlaLiveInfoData alaLiveInfoData2 = mVar.mLiveInfo;
            AlaLiveUserInfoData alaLiveUserInfoData2 = mVar.Ya;
            if (alaLiveInfoData2 != null) {
                String str2 = alaLiveInfoData2.close_reason;
                if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    str2 = str;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = "0";
                }
                bkm().faT.cU(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.ffX) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bkm().fbx;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bkm().fbt.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.ffT;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.ffU;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.ffP;
            if (this.ffQ != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.ffR - this.ffS) / this.ffQ) * 100.0f;
            }
            Intent intent = new Intent(bkm().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bkm().faT != null && bkm().faT.yT() != null && bkm().faT.yT().Ya != null) {
                String str3 = bkm().faT.yT().Ya.nickName;
                String str4 = bkm().faT.yT().Ya.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.m yT = bkm().faT.yT();
            if (yT != null && yT.Ya != null && !TextUtils.isEmpty(yT.Ya.portrait)) {
                intent.putExtra("host_portrait", yT.Ya.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.ffV = intent;
                this.ffW = s;
                bkm().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void boz() {
        if (this.ffV != null) {
            a(this.ffV, this.ffW);
            this.ffV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.ffX = true;
        if (this.fgd != null) {
            this.fgd.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.ePk);
            bkm().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bkm().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boA() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eUL.fbz != null && this.eUL.fbz.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.fgd != null && this.fgd.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bkm().fbv.bpf()) {
                boy();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.ffs.setVisibility(4);
            return;
        }
        this.ffs.a(i, z, i2, z2);
        if (this.eUL != null && this.eUL.faT != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.bVr != i3) {
                this.bVr = i3;
                if (this.ffq == null) {
                    this.ffq = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUL.pageContext, null);
                }
                switch (this.bVr) {
                    case 0:
                        this.ffq.a(this.eUL.rootView, this.eUL.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.ffq.a(this.eUL.rootView, this.eUL.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.ffq.a(this.eUL.rootView, this.eUL.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.eUL.faT.j(this.eUL.faT.yT().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.boA();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkm().faT.yT(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0468, code lost:
        yM(r6);
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
            if (this.ffo != null) {
                this.ffo.v(aVar);
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
                if (this.fgd != null) {
                }
                if (!"close_live".equals(str2)) {
                }
            }
            if (this.fgd != null) {
                this.fgd.cT(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.boA();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkm().faT.yT(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bkm().faT.yT() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bkm().faT.yT().Yo.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bkm().faT.yT().Yo.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bkm().faT.yT().Yo.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.ffJ != null) {
                    this.ffJ.v(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.ffp.at(optString4, optInt2);
                    }
                    if (this.eRF.getCount() > 20) {
                        this.eRF.cD(this.eRF.getCount() + 1);
                    } else if (this.eRA != null) {
                        com.baidu.live.data.a xt = aVar.xt();
                        com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                        gVar.Yb = new AlaLocationData();
                        gVar.Yc = new AlaRelationData();
                        gVar.Ya = new AlaLiveUserInfoData();
                        gVar.Ya.userId = JavaTypesHelper.toLong(xt.userId, 0L);
                        gVar.Ya.userName = xt.userName;
                        gVar.Ya.portrait = xt.portrait;
                        if (this.eRA.c(gVar)) {
                            this.eRF.cD(this.eRF.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt("event_type") == 1001 && bkm().faT.yT() != null && bkm().faT.yT().mLiveInfo != null) {
                    String str5 = bkm().faT.yT().mLiveInfo.feed_id;
                    long j4 = bkm().faT.yT().mLiveInfo.live_id;
                    long optLong2 = jSONObject2.optLong("id");
                    if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                        o.g(str5, j4);
                        com.baidu.live.utils.m.h(j4, optLong2);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bkm() != null && bkm().faT != null && bkm().faT.yT() != null && bkm().faT.yT().Yo != null && bkm().faT.yT().Yo.userId == jSONObject2.optLong("user_id")) {
                    bkm().faT.bpJ();
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
            com.baidu.live.data.a xt2 = aVar.xt();
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
                if (bkm().faT != null && bkm().faT.yT() != null && bkm().faT.yT().mLiveInfo != null) {
                    j5 = bkm().faT.yT().mLiveInfo.live_id;
                    j6 = bkm().faT.yT().mLiveInfo.group_id;
                    j7 = bkm().faT.yT().Ya.userId;
                    str7 = bkm().faT.yT().mLiveInfo.appId;
                    if (bkm().faT.yT().mLiveSdkInfo.mCastIds != null) {
                        String str8 = bkm().faT.yT().mLiveSdkInfo.mCastIds.Yh;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bkm().faT.yT().mLiveSdkInfo.mCastIds.Yi;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || bkm().blS() != 2) {
                            if (TextUtils.isEmpty(optString10) && !TextUtils.isEmpty(optString11)) {
                                if (jSONObject5.optInt("flag_show") == 1) {
                                    t.b(optString11, xt2.userId, xt2.portrait, xt2.getNameShow(), String.valueOf(j3), String.valueOf(j2), false, String.valueOf(j), str7, optString10, "", "");
                                    try {
                                        JSONArray jSONArray = new JSONArray(optString11);
                                        if (jSONArray != null && jSONArray.length() > 0) {
                                            int i = 0;
                                            while (true) {
                                                if (i >= jSONArray.length()) {
                                                    break;
                                                }
                                                if (com.baidu.live.v.d.zz().dX(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
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
                                t.b(optString5, Integer.parseInt(optString6), optString7, optString8, xt2.userId, xt2.portrait, xt2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3);
                            }
                        }
                        yM(optString5);
                        com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
                        dVar.fam = optLong4;
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
                t.b(optString5, Integer.parseInt(optString6), optString7, optString8, xt2.userId, xt2.portrait, xt2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str7, optString9, str4, str3);
                yM(optString5);
                com.baidu.tieba.ala.liveroom.e.d dVar2 = new com.baidu.tieba.ala.liveroom.e.d();
                dVar2.fam = optLong4;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void yM(String str) {
        if (this.eRH != null) {
            this.eRH.yM(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr(int i) {
        View findViewById = bkm().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.eRH != null) {
            this.eRH.bk(2, i);
        }
    }

    private void boB() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bkm().fbt != null && AlaMasterLiveRoomOpearator.this.bkm().fbt.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bkm().fbt.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bkm().fbt.startRecord();
                }
            }
        });
    }

    private void boC() {
        if (bkm().fbt != null && bkm().fbt.getPreview() != null) {
            bkm().fbt.getPreview().setVisibility(8);
            bkm().fbt.stopRecord();
        }
    }

    public void boD() {
        this.fbq = bkm().faT.bpV();
        if (this.ffj != null) {
            this.ffj.jp(this.fbq);
        }
    }

    public void blQ() {
        if (TbadkCoreApplication.getInst().isOther()) {
            boE();
        } else if (this.ffj != null) {
            this.ffj.blQ();
        }
    }

    public void onDestroy() {
        if (this.ffO != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.ffO);
        }
        this.ffO = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.fga != null) {
            this.fga.jn(true);
        }
        this.fga = null;
        if (this.ffj != null) {
            this.ffj.destroy();
            bkm().rootView.removeView(this.ffj.getView());
            this.ffj.release();
            this.ffj = null;
        }
        if (this.fgd != null) {
            this.fgd.onDestroy();
        }
        if (this.eSr != null) {
            this.eSr.onDestroy();
        }
        if (this.eSt != null) {
            this.eSt.onDestroy();
        }
        if (this.eRB != null) {
            this.eRB.onDestroy();
            this.eRB = null;
        }
        if (this.ffk != null) {
            this.ffk.onDestroy();
        }
        if (this.eSP != null) {
            this.eSP.onDestroy();
            this.eSP = null;
        }
        if (this.ffr != null) {
            this.ffr.stopCountDown();
        }
        if (this.ffn != null) {
            this.ffn.onDestroy();
        }
        if (this.ffp != null) {
            this.ffp.onDestroy();
        }
        if (this.ffJ != null) {
            this.ffJ.onDestroy();
            this.ffJ = null;
        }
        if (this.eSE != null) {
            this.eSE.onDestroy();
            this.eSE = null;
        }
        t.sM();
        com.baidu.live.entereffect.a.qW().release();
        if (this.eSF != null) {
            this.eSF.onDestroy();
            this.eSF = null;
        }
        if (this.ffq != null) {
            this.ffq.onDestroy();
        }
        if (this.ffo != null) {
            this.ffo.brC();
            this.ffo.release();
        }
        if (this.eRF != null) {
            this.eRF = null;
        }
        if (this.eRH != null) {
            this.eRH.release();
        }
        if (this.ffl != null) {
            this.ffl.onDestroy();
        }
        if (this.ffo != null) {
            this.ffo.onDestroy();
        }
        if (this.eSD != null) {
            this.eSD.release();
        }
        if (this.eSM != null) {
            this.eSM.release();
        }
        if (this.eSN != null) {
            this.eSN.onDestroy();
        }
        if (this.ffL != null) {
            this.ffL.onDestroy();
        }
        if (this.eSZ != null) {
            this.eSZ.release();
        }
        if (this.fgf != null) {
            this.fgf.onDestory();
        }
        if (this.fgg != null) {
            this.fgg.release();
        }
        if (this.eSX != null) {
            this.eSX.onDestroy();
        }
        if (this.fgh != null) {
            this.fgh.release();
        }
        MessageManager.getInstance().unRegisterListener(this.eTT);
        MessageManager.getInstance().unRegisterListener(this.fgB);
        MessageManager.getInstance().unRegisterListener(this.fgC);
        MessageManager.getInstance().unRegisterListener(this.fgD);
        MessageManager.getInstance().unRegisterListener(this.eTB);
        MessageManager.getInstance().unRegisterListener(this.fgq);
        MessageManager.getInstance().unRegisterListener(this.fgn);
        MessageManager.getInstance().unRegisterListener(this.awu);
        MessageManager.getInstance().unRegisterListener(this.awv);
        MessageManager.getInstance().unRegisterListener(this.fgo);
        MessageManager.getInstance().unRegisterListener(this.eTD);
        MessageManager.getInstance().unRegisterListener(this.eTC);
        MessageManager.getInstance().unRegisterListener(this.eTE);
        MessageManager.getInstance().unRegisterListener(this.fgp);
        MessageManager.getInstance().unRegisterListener(this.fgo);
        com.baidu.live.utils.m.Bj();
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUL.fbz.a(this.fgF, this.eUL.fbu, this.fft, alaLivePersonData);
        }
    }

    private void boE() {
        if (this.ffM != null) {
            this.eUL.fbx.startTime = System.currentTimeMillis();
            this.eUL.fbx.liveTotalTime = System.currentTimeMillis();
            this.eUL.fbx.sampleMemAndCPU();
            this.eUL.fbv.a((short) 4, this.ffM);
        }
    }

    private ViewGroup.LayoutParams boF() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bkm().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
