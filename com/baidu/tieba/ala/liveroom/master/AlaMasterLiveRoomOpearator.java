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
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.g.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.share.c;
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
    private static final String feH;
    private List<ag> awO;
    private String eOM;
    private com.baidu.live.g.a eQl;
    private com.baidu.live.h.a eRS;
    private c eRT;
    private com.baidu.tieba.ala.liveroom.o.b eRU;
    private com.baidu.tieba.ala.liveroom.guide.c eRV;
    private com.baidu.tieba.ala.liveroom.watermark.a eRW;
    private com.baidu.tieba.ala.liveroom.audiencelist.c eRc;
    private com.baidu.tieba.ala.liveroom.l.a eRd;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eRh;
    private com.baidu.tieba.ala.liveroom.activeview.b eRj;
    private com.baidu.live.q.a eSB;
    private boolean eSM;
    private m eSd;
    private i eSe;
    private j eSf;
    private u eSg;
    private s eSh;
    protected com.baidu.tieba.ala.liveroom.f.a eSo;
    protected h eSp;
    protected w eSr;
    protected com.baidu.live.i.a eSz;
    private ImageView eTI;
    private f eUn;
    private ImageView eUv;
    private g eUw;
    private boolean feI;
    private d feK;
    private com.baidu.tieba.ala.liveroom.l.a feL;
    private com.baidu.tieba.ala.liveroom.e.c feM;
    private com.baidu.tieba.ala.liveroom.b.a feN;
    private com.baidu.tieba.ala.liveroom.r.a feO;
    private com.baidu.tieba.ala.liveroom.u.a feP;
    private b feQ;
    private com.baidu.tieba.ala.liveroom.tippop.a feR;
    private AlaLiveCountDownView feS;
    private AlaLiveStreamStatusView feT;
    private RelativeLayout feU;
    private RelativeLayout feV;
    private RelativeLayout feW;
    private RelativeLayout feX;
    private View feY;
    private AlaLiveFaceVerifyView feZ;
    private boolean fer;
    private com.baidu.tieba.ala.liveroom.g.b ffB;
    private boolean ffC;
    private boolean ffD;
    private com.baidu.tieba.ala.liveroom.challenge.f ffE;
    private com.baidu.live.b.a ffG;
    private com.baidu.live.b.b ffH;
    private com.baidu.tieba.ala.liveroom.n.a ffI;
    private boolean ffJ;
    private BdUniqueId ffK;
    private boolean ffL;
    private ImageView ffa;
    private ImageView ffb;
    private ImageView ffc;
    private ImageView ffd;
    private ImageView ffe;
    private ImageView fff;
    private View ffg;
    private ImageView ffh;
    private TextView ffi;
    private x ffj;
    private com.baidu.live.x.a ffk;
    private com.baidu.tieba.ala.liveroom.master.panel.b ffl;
    private com.baidu.live.w.a ffm;
    private e ffn;
    private short ffx;
    private boolean feJ = false;
    private boolean eSH = false;
    private Handler mHandler = new Handler();
    private boolean ffo = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver ffp = null;
    private boolean ffq = false;
    private int ffr = 0;
    private int ffs = 0;
    private int fft = 0;
    private long ffu = 0;
    private long ffv = 0;
    private volatile boolean isBackground = false;
    private Intent ffw = null;
    private int mOrientation = 1;
    private boolean faS = false;
    private boolean ffy = false;
    private boolean ffz = true;
    private boolean eUt = false;
    private boolean ffA = true;
    private int bVg = 0;
    public boolean ffF = false;
    private String otherParams = "";
    private Runnable ffM = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        @Override // java.lang.Runnable
        public void run() {
            if (AlaMasterLiveRoomOpearator.this.eQl != null) {
                AlaMasterLiveRoomOpearator.this.eQl.qQ();
            }
        }
    };
    private CustomMessageListener awk = new CustomMessageListener(2913146) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eUn.fbb != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eUn.fbb.f(list, false);
                }
                for (com.baidu.live.im.data.a aVar : list) {
                    if (aVar != null) {
                        AlaMasterLiveRoomOpearator.this.t(aVar);
                    }
                }
            }
        }
    };
    private CustomMessageListener awl = new CustomMessageListener(2913167) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                List<com.baidu.live.im.data.a> list = (List) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eUn.fbb != null && !ListUtils.isEmpty(list)) {
                    AlaMasterLiveRoomOpearator.this.eUn.fbb.f(list, true);
                }
            }
        }
    };
    private CustomMessageListener eSY = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.eRU == null) {
                AlaMasterLiveRoomOpearator.this.eRU = new com.baidu.tieba.ala.liveroom.o.b(AlaMasterLiveRoomOpearator.this.bkh().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.eRU.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener eTf = new CustomMessageListener(2913154) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.eSz != null) {
                AlaMasterLiveRoomOpearator.this.eSz.vO();
            }
        }
    };
    private CustomMessageListener ffN = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.52
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a) && !TbadkCoreApplication.getInst().isOther()) {
                AlaMasterLiveRoomOpearator.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eSV = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.53
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.eUn.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.yO(str);
            }
        }
    };
    private CustomMessageListener eSW = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.54
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aId();
        }
    };
    private CustomMessageListener eTv = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.55
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaMasterLiveRoomOpearator.this.eSh.a((AlaBroadcastGiftToastData) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eTd = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener ffO = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.ffH != null) {
                com.baidu.live.data.m yO = AlaMasterLiveRoomOpearator.this.bkh().fav.yO();
                long j = yO.mLiveInfo.live_id;
                long j2 = yO.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.ffH.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener ffP = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkh().faw);
            if (AlaMasterLiveRoomOpearator.this.feK == null || AlaMasterLiveRoomOpearator.this.feK.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qp(0);
            }
            if (AlaMasterLiveRoomOpearator.this.eSe != null) {
                AlaMasterLiveRoomOpearator.this.eSe.wq().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.eSe.wr().hide();
            }
        }
    };
    private CustomMessageListener eTe = new CustomMessageListener(2913153) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.p(AlaMasterLiveRoomOpearator.this.bkh().fav.yO());
        }
    };
    private CustomMessageListener eTg = new CustomMessageListener(2913171) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof OfficialNoticeData) {
                OfficialNoticeData officialNoticeData = (OfficialNoticeData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eSr != null) {
                    ((com.baidu.tieba.ala.liveroom.n.b) AlaMasterLiveRoomOpearator.this.eSr).a(officialNoticeData);
                }
            }
        }
    };
    private CustomMessageListener ffQ = new CustomMessageListener(2913172) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.ffI != null) {
                    AlaMasterLiveRoomOpearator.this.ffI.yS(str);
                }
            }
        }
    };
    private CustomMessageListener ffR = new CustomMessageListener(2913150) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof AlaFilterBeautyDataMessage)) {
                AlaFilterAndBeautyData data = ((AlaFilterBeautyDataMessage) customResponsedMessage).getData();
                if (data == null) {
                    if (AlaMasterLiveRoomOpearator.this.ffJ) {
                        AlaMasterLiveRoomOpearator.this.bkh().pageContext.showToast(a.i.sdk_filter_beauty_no_data);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.bkh().faV != null) {
                        AlaMasterLiveRoomOpearator.this.bkh().faV.setDefBeautyParams(data.VK);
                    }
                    if (AlaMasterLiveRoomOpearator.this.ffB != null) {
                        if (AlaMasterLiveRoomOpearator.this.ffK != null && AlaMasterLiveRoomOpearator.this.ffK == data.VM) {
                            if (!AlaMasterLiveRoomOpearator.this.ffL || AlaMasterLiveRoomOpearator.this.feK.getVisibility() == 0) {
                                AlaMasterLiveRoomOpearator.this.ffB.a(AlaMasterLiveRoomOpearator.this.bkh().faV.getVideoConfig());
                            }
                            AlaMasterLiveRoomOpearator.this.ffK = null;
                            AlaMasterLiveRoomOpearator.this.ffB.a(AlaMasterLiveRoomOpearator.this.bkh().faV.getVideoConfig(), AlaMasterLiveRoomOpearator.this.ffC);
                            if (!AlaMasterLiveRoomOpearator.this.ffC) {
                                AlaMasterLiveRoomOpearator.this.ffC = true;
                            }
                        }
                        AlaMasterLiveRoomOpearator.this.ffB.blz();
                    }
                }
                AlaMasterLiveRoomOpearator.this.ffJ = false;
            }
        }
    };
    private View.OnClickListener ffS = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.ffb) {
                    AlaMasterLiveRoomOpearator.this.bnH();
                    AlaMasterLiveRoomOpearator.this.ffl.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.ffa) {
                    if (AlaMasterLiveRoomOpearator.this.eSe != null) {
                        AlaMasterLiveRoomOpearator.this.eSe.wr().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.ffc) {
                    AlaMasterLiveRoomOpearator.this.aId();
                } else if (view != AlaMasterLiveRoomOpearator.this.ffd) {
                    if (view == AlaMasterLiveRoomOpearator.this.fff) {
                        if (AlaMasterLiveRoomOpearator.this.ffm != null) {
                            AlaMasterLiveRoomOpearator.this.ffm.showDialog();
                            AlaMasterLiveRoomOpearator.this.ffm.bi(AlaMasterLiveRoomOpearator.this.bnL());
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eUv) {
                        if (AlaMasterLiveRoomOpearator.this.ffE != null) {
                            AlaMasterLiveRoomOpearator.this.ffE.bkj();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.ffe) {
                        if (AlaMasterLiveRoomOpearator.this.feP != null) {
                            com.baidu.tieba.ala.liveroom.data.h bpF = AlaMasterLiveRoomOpearator.this.bkh().fav.bpF();
                            if (bpF == null || bpF.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(bpF.mLiveSdkInfo.mRoomId);
                                if (bpF.mLiveSdkInfo.mCastIds != null) {
                                    str2 = bpF.mLiveSdkInfo.mCastIds.XX;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.feP.ad("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.ffh) {
                        com.baidu.live.data.m yO = AlaMasterLiveRoomOpearator.this.bkh().fav.yO();
                        if (AlaMasterLiveRoomOpearator.this.eSo != null && yO != null && yO.mLiveInfo != null) {
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
                            AlaMasterLiveRoomOpearator.this.eSo.yS(o.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.ffL = false;
                    AlaMasterLiveRoomOpearator.this.jB(true);
                }
            }
        }
    };
    private CustomMessageListener eSX = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof x) {
                    AlaMasterLiveRoomOpearator.this.eSH = true;
                    AlaMasterLiveRoomOpearator.this.ffj = (x) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.eSe != null) {
                        AlaMasterLiveRoomOpearator.this.eSe.wq().getView().setVisibility(0);
                    }
                    if (AlaMasterLiveRoomOpearator.this.eSe != null) {
                        AlaMasterLiveRoomOpearator.this.eSe.wr().show();
                        AlaMasterLiveRoomOpearator.this.eSe.wr().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.qp(8);
                }
            }
        }
    };
    private CustomMessageListener ffT = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bkh() != null && AlaMasterLiveRoomOpearator.this.bkh().faZ != null) {
                AlaMasterLiveRoomOpearator.this.bkh().faZ.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener fef = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.bou();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bkh().fav.qw(i);
                if (AlaMasterLiveRoomOpearator.this.eSz != null) {
                    AlaMasterLiveRoomOpearator.this.eSz.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener eOX = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.bon();
        }
    };
    public final HttpMessageListener ffU = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.yR()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.ffl != null) {
                            AlaMasterLiveRoomOpearator.this.ffl.jH(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.ffl.boS();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bkh().faV.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.feR != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.feR.a(AlaMasterLiveRoomOpearator.this.bkh().rootView, AlaMasterLiveRoomOpearator.this.bkh().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bkh().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.feR.qD(2);
                        AlaMasterLiveRoomOpearator.this.feR.a(AlaMasterLiveRoomOpearator.this.bkh().rootView, string, 3);
                    }
                }
            }
        }
    };
    private e.a ffV = new e.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boB() {
            AlaMasterLiveRoomOpearator.this.bok();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.a
        public void boC() {
            AlaMasterLiveRoomOpearator.this.bol();
        }
    };
    com.baidu.live.liveroom.a.a ffW = new com.baidu.live.liveroom.a.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
        @Override // com.baidu.live.liveroom.a.a
        public boolean cc(int i) {
            return false;
        }

        @Override // com.baidu.live.liveroom.a.a
        public void cd(int i) {
        }

        @Override // com.baidu.live.liveroom.a.a
        public void ce(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bkh().blN() == 1) {
                AlaMasterLiveRoomOpearator.this.bkh().faV.stopRecord();
            }
        }
    };
    private IShareCallback ffX = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.ffo && AlaMasterLiveRoomOpearator.this.ffn != null) {
                AlaMasterLiveRoomOpearator.this.ffo = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.ffn);
            }
        }
    };
    private View.OnTouchListener ffY = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bkh().faZ.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkh().faw);
            AlaMasterLiveRoomOpearator.this.qp(0);
            if (AlaMasterLiveRoomOpearator.this.eSe != null) {
                AlaMasterLiveRoomOpearator.this.eSe.wq().getView().setVisibility(0);
            }
            return false;
        }
    };
    private e.b ffZ = new e.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boD() {
            AlaMasterLiveRoomOpearator.this.bnG();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boE() {
            AlaMasterLiveRoomOpearator.this.fer = AlaMasterLiveRoomOpearator.this.feK.blF();
            AlaMasterLiveRoomOpearator.this.bkh().faZ.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bkh().faZ.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bkh().faZ.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.faP = false;
            eVar.forumId = null;
            eVar.forumName = null;
            eVar.liveType = AlaMasterLiveRoomOpearator.this.bkh().blN();
            eVar.title = AlaMasterLiveRoomOpearator.this.feK.getLiveTitle();
            eVar.clarity = 0;
            eVar.gameId = null;
            eVar.gameName = null;
            eVar.faQ = AlaMasterLiveRoomOpearator.this.feK.blG();
            eVar.faT = AlaMasterLiveRoomOpearator.this.fer;
            eVar.faS = AlaMasterLiveRoomOpearator.this.feK.blD();
            eVar.faR = AlaMasterLiveRoomOpearator.this.feK.blI();
            eVar.faU = AlaMasterLiveRoomOpearator.this.feK.blE();
            if (eVar.faU) {
                if (AlaMasterLiveRoomOpearator.this.feK.blJ()) {
                    AlaMasterLiveRoomOpearator.this.ffo = true;
                    AlaMasterLiveRoomOpearator.this.ffn = eVar;
                    AlaMasterLiveRoomOpearator.this.feK.blK();
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
            AlaMasterLiveRoomOpearator.this.bkh().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bkh().f((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boF() {
            AlaMasterLiveRoomOpearator.this.ffL = true;
            AlaMasterLiveRoomOpearator.this.jB(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public boolean boG() {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boH() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.e.b
        public void boI() {
            o.k(AlaMasterLiveRoomOpearator.this.eUn.pageContext.getPageActivity(), "", "");
        }
    };
    private com.baidu.live.liveroom.g.c fga = new com.baidu.live.liveroom.g.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
        boolean isShow = true;

        @Override // com.baidu.live.liveroom.g.c
        public void yM() {
            if (AlaMasterLiveRoomOpearator.this.feP != null) {
                AlaMasterLiveRoomOpearator.this.feP.jR(false);
            }
        }

        @Override // com.baidu.live.liveroom.g.c
        public void bg(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.ffE != null) {
                        AlaMasterLiveRoomOpearator.this.ffE.d(AlaMasterLiveRoomOpearator.this.eUv);
                    }
                    if (AlaMasterLiveRoomOpearator.this.ffm != null) {
                        AlaMasterLiveRoomOpearator.this.ffm.bh(true);
                    }
                } else {
                    if (AlaMasterLiveRoomOpearator.this.ffE != null) {
                        AlaMasterLiveRoomOpearator.this.ffE.bkk();
                    }
                    if (AlaMasterLiveRoomOpearator.this.ffm != null) {
                        AlaMasterLiveRoomOpearator.this.ffm.bh(false);
                    }
                }
                if (AlaMasterLiveRoomOpearator.this.feP != null) {
                    AlaMasterLiveRoomOpearator.this.feP.jR(z);
                }
                this.isShow = z;
                if (AlaMasterLiveRoomOpearator.this.eSr != null) {
                    AlaMasterLiveRoomOpearator.this.eSr.aB(z);
                }
            }
        }
    };
    private AlaLiveFaceVerifyView.a fgb = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.feZ != null && AlaMasterLiveRoomOpearator.this.bkh().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.feZ) >= 0) {
                AlaMasterLiveRoomOpearator.this.bkh().rootView.removeView(AlaMasterLiveRoomOpearator.this.feZ);
                AlaMasterLiveRoomOpearator.this.feZ.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.feZ = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eRI = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            com.baidu.live.data.m yO;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.bot();
            } else if (i == 14 && (yO = AlaMasterLiveRoomOpearator.this.bkh().fav.yO()) != null && yO.XQ != null && yO.mLiveInfo != null && yO.Ye != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity(), yO.XQ.userName, Long.toString(yO.XQ.userId), Long.toString(yO.XQ.charmCount), String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), true, String.valueOf(yO.XQ.userId), Long.toString(yO.Ye.userId), yO.Ye.userName, yO.Ye.portrait, AlaMasterLiveRoomOpearator.this.eRh.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(yO.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.eRh.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener fgc = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.ffF = ((HasGoodsAuthResponseMessage) httpResponsedMessage).fhe;
            }
        }
    };
    private HttpMessageListener fgd = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.ffi.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.ffi.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.ffi.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.ffi.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.awO = getVideoGoodsListHttpResponseMessage.awO;
            }
        }
    };
    private HttpMessageListener fge = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.awJ != null && !eventPollingHttpResponseMessage.awJ.isEmpty() && AlaMasterLiveRoomOpearator.this.bkh().fav != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.currentTime;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.awJ.size()) {
                            break;
                        }
                        af afVar = eventPollingHttpResponseMessage.awJ.get(i2);
                        if (j == afVar.liveId && j2 - afVar.createTime <= 60 && !com.baidu.live.utils.m.g(afVar.liveId, afVar.id)) {
                            com.baidu.live.utils.m.a(afVar, AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo);
                            com.baidu.live.utils.m.h(afVar.liveId, afVar.id);
                        }
                        i = i2 + 1;
                    }
                    af afVar2 = eventPollingHttpResponseMessage.awJ.get(eventPollingHttpResponseMessage.awJ.size() - 1);
                    if (j == afVar2.liveId) {
                        com.baidu.live.utils.m.f(afVar2.liveId, afVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.awI;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bkh().fav != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null && AlaMasterLiveRoomOpearator.this.bkh().fav != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                com.baidu.live.utils.m.i(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };
    private com.baidu.live.liveroom.middleware.b.a fgf = new com.baidu.live.liveroom.middleware.b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.50
    };
    private com.baidu.live.liveroom.middleware.g fgg = new com.baidu.live.liveroom.middleware.g() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.51
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.Vi);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        feH = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(com.baidu.live.data.m mVar) {
        if (mVar != null && mVar.mLiveInfo != null && com.baidu.live.v.a.zl().awC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bkh().pageContext.getPageActivity(), String.valueOf(mVar.mLiveInfo.live_id), String.valueOf(mVar.mLiveInfo.user_id), com.baidu.live.v.a.zl().awC.aaT, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yO(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkh().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bkh().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.v.a.zl().awC.aar;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bkh().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bkh().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bkh().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.ffE != null) {
            this.ffE.onPKPlayerFirstFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnG() {
        if (bkh() != null && bkh().fav != null) {
            if (TbadkCoreApplication.getInst().isQuanmin()) {
                bkh().fav.bpx();
            } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isOther()) {
                bkh().fav.bpy();
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
                    AlaMasterLiveRoomOpearator.this.ffq = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.ffq = false;
                }
                if (AlaMasterLiveRoomOpearator.this.ffr == 0) {
                    AlaMasterLiveRoomOpearator.this.ffr = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.ffs == 0) {
                    AlaMasterLiveRoomOpearator.this.ffs = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.fft = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (bkh() != null && bkh().faX != null) {
            bkh().faX.c(eVar);
        }
    }

    public AlaMasterLiveRoomOpearator(f fVar, String str) {
        this.eUn = fVar;
        this.eOM = str;
    }

    protected f bkh() {
        return this.eUn;
    }

    public int a(g gVar) {
        this.eUw = gVar;
        this.ffp = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.ffp, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.feR == null) {
            this.feR = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUn.pageContext, null);
        }
        registerListener();
        this.eQl = new com.baidu.live.g.a();
        bnV();
        Long[] lArr = new Long[1];
        this.ffu = lArr[0] == null ? 0L : lArr[0].longValue();
        this.ffv = lArr[0] != null ? lArr[0].longValue() : 0L;
        bkh().faw.setOnTouchListener(this.ffY);
        this.feI = SharedPrefHelper.getInstance().getBoolean(feH, false);
        this.feS = new AlaLiveCountDownView(bkh().pageContext.getPageActivity());
        this.feS.setCount(3);
        this.feS.setTextColor(bkh().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.feS.setTextSize(bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.feS.setTypeface(Typeface.DEFAULT_BOLD);
        this.feS.setIncludeFontPadding(false);
        this.feS.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void boJ() {
                if (AlaMasterLiveRoomOpearator.this.bkh().faw != null) {
                    AlaMasterLiveRoomOpearator.this.bkh().faw.removeView(AlaMasterLiveRoomOpearator.this.feS);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnH() {
        if (this.ffl == null) {
            this.ffl = new com.baidu.tieba.ala.liveroom.master.panel.b(bkh().pageContext.getPageActivity(), bkh().blN() == 2);
            this.ffl.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkh().faV.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jD(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkh().faV.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jE(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bkh().faV.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.bos();
                    if (AlaMasterLiveRoomOpearator.this.feR != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.feR.a(AlaMasterLiveRoomOpearator.this.bkh().rootView, AlaMasterLiveRoomOpearator.this.bkh().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.feR.a(AlaMasterLiveRoomOpearator.this.bkh().rootView, AlaMasterLiveRoomOpearator.this.bkh().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jF(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boK() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bkh().fav != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boL() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bkh().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boM() {
                    if (AlaMasterLiveRoomOpearator.this.bkh() != null && AlaMasterLiveRoomOpearator.this.bkh().fav != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaMasterLiveRoomOpearator.this.bkh().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.ffl != null) {
                            AlaMasterLiveRoomOpearator.this.ffl.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void boN() {
                    long j = (AlaMasterLiveRoomOpearator.this.bkh() == null || AlaMasterLiveRoomOpearator.this.bkh().fav == null || AlaMasterLiveRoomOpearator.this.bkh().fav.yO() == null || AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bkh() != null && AlaMasterLiveRoomOpearator.this.bkh().fav != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eUn.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.ffl != null) {
                                        AlaMasterLiveRoomOpearator.this.ffl.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new l(AlaMasterLiveRoomOpearator.this.eUn.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.ffl != null) {
                        AlaMasterLiveRoomOpearator.this.ffl.dismiss();
                    }
                }
            });
        }
        bnI();
    }

    private void bnI() {
        if (this.ffl != null) {
            boolean isBackCamera = bkh().faV.isBackCamera();
            this.ffl.jG(bkh().faV.isBackCamera());
            this.ffl.F(bkh().faV.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bkh().faV.isPushMirror();
            if (this.ffz) {
                isPushMirror = bor() || isPushMirror;
                this.ffz = false;
            }
            this.ffl.G(isPushMirror, isBackCamera ? false : true);
            this.ffl.jH(bkh().faV.isMute());
            this.ffl.boS();
        }
    }

    public void bnJ() {
        if (this.eUw != null) {
            if (this.eUw.fbc == null || this.eUw.fbc.mLiveInfo == null) {
                if (TbadkCoreApplication.getInst().isOther()) {
                    if (this.feY == null) {
                        this.feY = this.eUn.fbb.yw();
                        this.eUn.rootView.addView(this.feY, new FrameLayout.LayoutParams(-1, -1));
                        return;
                    }
                    return;
                }
                if (this.feK == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bkh().fav != null && bkh().fav.yO() != null && bkh().fav.yO().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bkh().fav.yO().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bkh().fav.yO().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.feK = new d(bkh().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bkh().faZ.prepareTime = System.currentTimeMillis();
                    bkh().rootView.addView(this.feK.getView(), layoutParams);
                    this.feK.a(this.ffX);
                }
                this.feK.jn(this.faS);
                this.feK.a(this.ffZ);
                this.feK.a(this.ffV);
                this.feK.a(bkh().faV, bkh().blN());
                return;
            }
            this.fer = this.eUw.fbc.mLiveInfo.screen_direction == 2;
            if (this.eUw.fbc.mLiveInfo.isAudioOnPrivate == 1) {
                bkh().faV.setMute(true);
                if (this.feR == null) {
                    this.feR = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUn.pageContext, null);
                }
                if (!this.feR.qC(2)) {
                    this.feR.a(bkh().rootView, bkh().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.e eVar = new com.baidu.tieba.ala.liveroom.data.e();
            eVar.faP = true;
            eVar.forumId = String.valueOf(this.eUw.fbc.mLiveInfo.forum_id);
            eVar.forumName = this.eUw.fbc.mLiveInfo.forum_name;
            eVar.liveType = this.eUw.fbc.mLiveInfo.live_type;
            eVar.title = this.eUw.fbc.mLiveInfo.getLiveTitle();
            eVar.clarity = this.eUw.fbc.mLiveInfo.clarity;
            eVar.gameId = this.eUw.fbc.mLiveInfo.game_id;
            eVar.gameName = this.eUw.fbc.mLiveInfo.game_label;
            eVar.faT = this.eUw.fbc.mLiveInfo.screen_direction == 2;
            c(eVar);
        }
    }

    public void bnK() {
        if (this.ffB != null) {
            this.ffB.a(bkh().faV.getVideoConfig(), false);
            this.ffB.blz();
        }
        if (this.feK != null) {
            this.feK.jm(true);
        }
        if (bkh().faV.hasBeauty() >= 0) {
            bkh().faV.setBeauty(com.baidu.live.c.pr().getInt("live_beauty_level", 3));
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            bkh().fbb.C(this.eUn.faV);
        } else if (this.feK != null) {
            this.feK.jm(true);
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.e eVar) {
        if (TbadkCoreApplication.getInst().isOther()) {
            if (this.feY != null && this.feY.getParent() != null) {
                ((ViewGroup) this.feY.getParent()).removeView(this.feY);
                this.feY = null;
            }
            bkh().faw.setVisibility(0);
            this.eUn.fbb.a(bkh().faw);
        } else {
            boa();
            boq();
            this.feP = new com.baidu.tieba.ala.liveroom.u.a(bkh().pageContext, this.ffW);
            this.feP.d(bkh().faw, true);
            this.feP.jR(true);
            if (this.eSe != null && this.eSe.wq() != null) {
                this.eSe.wq().setNeedTopAlphaShade(true);
            }
        }
        bkh().faV.setPushMirror(bor());
    }

    public void b(com.baidu.tieba.ala.liveroom.data.h hVar) {
        boolean z;
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUn.fbb.j(bkh().fav.yO());
        }
        if (!bkh().faV.isBackground() && bkh().fav.yO() != null && bkh().fav.yO().mLiveInfo != null) {
            int startPush = bkh().faV.startPush(bkh().fav.yO().mLiveInfo.getPushUrl());
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eUn.fbb.yx();
            }
            if (startPush != 0 && bkh().faZ != null) {
                bkh().faZ.errCode = 4;
                bkh().faZ.errSubReason = startPush;
            }
        }
        if (!TbadkCoreApplication.getInst().isOther()) {
            if (hVar != null && !hVar.blS() && !boo()) {
                jC(true);
                bop();
            }
            if (this.feM != null) {
                this.feM.q(bkh().fav.yO());
            }
            if (this.eRd != null) {
                this.eRd.u(bkh().fav.yO());
            }
            if (this.eRS != null) {
                this.eRS.a(bkh().fav.yO());
            }
            if (this.feN != null && bkh() != null && bkh().fav != null) {
                if (this.feN.ag(bkh().faw)) {
                    this.feN.o(bkh().fav.yO());
                } else {
                    this.feN.b(bkh().faw, bkh().fav.yO());
                }
            }
            if (this.feL != null) {
                this.feL.u(bkh().fav.yO());
            }
            if (hVar == null || hVar.XQ == null) {
                z = com.baidu.live.c.pr().getBoolean("ala_master_can_use_challenge", false);
            } else {
                z = hVar.XQ.canUseChallenge;
                com.baidu.live.c.pr().putBoolean("ala_master_can_use_challenge", z);
            }
            bob();
            bnO();
            jz(z);
            boc();
            boh();
            bji();
            bjw();
            v(bkh().fav.yO());
            f(bkh().fav.yO());
            boi();
            boj();
            bof();
            bjk();
            bjr();
            bjs();
            if (this.eSd != null) {
                this.eSd.g(bkh().fav.yO());
            }
            if (this.eSe != null) {
                this.eSe.e(String.valueOf(bkh().fav.yO().mLiveInfo.group_id), String.valueOf(bkh().fav.yO().mLiveInfo.last_msg_id), String.valueOf(bkh().fav.yO().XQ.userId), String.valueOf(bkh().fav.yO().mLiveInfo.live_id), bkh().fav.yO().XQ.appId);
            }
            if (this.eSf != null) {
                this.eSf.a(bkh().fav.yO(), true);
            }
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                com.baidu.live.utils.m.i(bkh().fav.yO().mLiveInfo.user_id, bkh().fav.yO().mLiveInfo.live_id);
            }
            this.mHandler.post(this.ffM);
        }
    }

    private void jz(boolean z) {
        if (this.ffE == null) {
            this.ffE = new com.baidu.tieba.ala.liveroom.challenge.f(bkh());
        }
        this.ffE.a(this.eUv, this.eUw);
        this.ffE.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(ad adVar, ae aeVar, ae aeVar2) {
                if (AlaMasterLiveRoomOpearator.this.eRW != null) {
                    AlaMasterLiveRoomOpearator.this.eRW.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bkh().faw.fnp = false;
                AlaMasterLiveRoomOpearator.this.bnM();
                if (AlaMasterLiveRoomOpearator.this.eSB != null) {
                    AlaMasterLiveRoomOpearator.this.eSB.b(AlaMasterLiveRoomOpearator.this.jA(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void pR() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.ffM);
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bkf() {
                if (AlaMasterLiveRoomOpearator.this.eRW != null) {
                    AlaMasterLiveRoomOpearator.this.eRW.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bkh().faw.fnp = true;
                AlaMasterLiveRoomOpearator.this.bnN();
                if (AlaMasterLiveRoomOpearator.this.eSB != null) {
                    AlaMasterLiveRoomOpearator.this.eSB.b(AlaMasterLiveRoomOpearator.this.jA(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bkg() {
                AlaMasterLiveRoomOpearator.this.mHandler.post(AlaMasterLiveRoomOpearator.this.ffM);
            }
        });
        this.ffE.D(this.fer, z);
        this.ffE.h(this.fer, z, (this.eUw == null || this.eUw.fbc == null || this.eUw.fbc.mChallengeData == null) ? false : true);
    }

    public boolean bnL() {
        return this.ffE != null && this.ffE.bkm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnM() {
        if (this.feQ != null) {
            this.feQ.setVisible(8);
            this.feQ.setCanVisible(false);
        }
        if (this.eRj != null) {
            this.eRj.iM(true);
            jf(true);
        }
        if (this.feT != null) {
            this.feT.setCanVisible(false);
            this.feT.setVisibility(4);
        }
        if (this.feP != null) {
            this.feP.jQ(false);
        }
        if (this.eSe != null) {
            this.eSe.wq().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnN() {
        if (this.feQ != null) {
            this.feQ.setCanVisible(true);
        }
        if (this.eRj != null) {
            this.eRj.iM(false);
            jf(false);
        }
        if (this.feT != null) {
            this.feT.setCanVisible(true);
        }
        if (this.feP != null) {
            this.feP.jQ(true);
        }
        if (this.eSe != null) {
            this.eSe.wq().setNeedTopAlphaShade(false);
        }
    }

    private void jf(boolean z) {
        ViewGroup.LayoutParams pQ;
        if (this.eRj != null) {
            com.baidu.tieba.ala.liveroom.activeview.b bVar = this.eRj;
            AlaLiveView alaLiveView = bkh().faw;
            if (z) {
                pQ = boA();
            } else {
                pQ = pQ(1);
            }
            bVar.a(1, alaLiveView, pQ, 21);
            this.eRj.updateView();
        }
    }

    private void bnO() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.feT == null) {
            this.feT = new AlaLiveStreamStatusView(bkh().pageContext.getPageActivity());
        }
        this.feT.setId(a.g.ala_live_room_stream_view);
        this.feT.setVisibility(4);
        this.feT.setLayoutParams(layoutParams);
        if (this.feT.getParent() == null) {
            bkh().faw.addView(this.feT, layoutParams);
        }
    }

    public void bnP() {
        if (this.feK != null && this.feK.getVisibility() != 8 && bkh().faV.getPreview() != null) {
            bkh().faV.stopRecord();
        }
    }

    public void bnQ() {
        if (bkh().faV.getPreview() != null) {
            bkh().faV.stopRecord();
        }
    }

    public void j(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.ffB != null) {
                this.ffB.jl(false);
            }
            this.ffB = new com.baidu.tieba.ala.liveroom.g.b(bkh().rootView, bkh(), bkh().faV);
            this.ffB.a(bkh().faV.getVideoConfig(), false);
            this.ffB.blz();
        }
        if (this.feR != null) {
            this.feR.bqB();
        }
        this.mHandler.post(this.ffM);
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.feJ = z;
        if (z) {
            Rect rect = new Rect();
            bkh().faw.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            bkh().faw.getGlobalVisibleRect(rect2);
            if (this.eSe != null && this.eSe.wq() != null) {
                this.eSe.wq().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eSe.wq().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.eSe.wq().getView().setLayoutParams(layoutParams);
            }
            if (this.eSe != null && this.eSe.wr() != null) {
                int i = rect2.bottom - rect.bottom;
                this.eSe.wr().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eSe.wr().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.eSe.wr().getView().setLayoutParams(layoutParams2);
                this.eSe.wr().getView().setVisibility(0);
            }
            qp(8);
            qo(8);
        } else {
            if (this.eSe != null && this.eSe.wq() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eSe.wq().getView().getLayoutParams();
                layoutParams3.bottomMargin = bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.eSe.wq().getView().setLayoutParams(layoutParams3);
            }
            if (this.eSe != null && this.eSe.wr() != null) {
                this.eSe.wr().hide();
            }
            qp(0);
            qo(0);
        }
        if (this.feK != null) {
            this.feK.e(false, z);
        }
        if (this.eSf != null) {
            this.eSf.wy();
        }
        if (this.ffm != null) {
            this.ffm.onKeyboardVisibilityChanged(z);
        }
        if (this.eSe != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bkh().pageContext.getPageActivity())) + bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (bkh().faw.indexOfChild(this.eSe.wq().getView()) != -1 && this.eSe.wq().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eSe.wq().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.eSe.wq().getView().setLayoutParams(layoutParams4);
            }
            this.eSe.wq().wp();
        }
        this.mHandler.post(this.ffM);
    }

    private void qo(int i) {
        if (this.eRd != null) {
            this.eRd.qb(i);
        }
        if (this.feV != null) {
            this.feV.setVisibility(i);
        }
        if (this.eRS != null) {
            this.eRS.getView().setVisibility(i);
        }
        if (this.feO != null) {
            this.feO.setVisible(i);
        }
        if (this.feN != null) {
            this.feN.setVisibility(i);
        }
        if (this.eRj != null) {
            this.eRj.setVisible(i);
        }
        if (this.eSB != null) {
            this.eSB.setCanVisible(i == 0);
        }
        if (this.eSp != null) {
            this.eSp.setVisible(i);
        }
        if (this.eSz != null) {
            this.eSz.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bkh().faZ.errCode = 1;
            bok();
        } else if (i == -5) {
            bol();
        } else if (i == -2) {
            zf(bkh().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bkh().faV.stopRecord();
        } else if (i == -3 && this.feK != null) {
            this.feK.jm(false);
        }
        if (i == -4) {
            if (this.feK == null || this.feK.getView().getParent() == null) {
                bkh().f((short) 1);
                return;
            }
            this.feK.blH();
            this.ffd.setVisibility(0);
            if (this.feP != null) {
                this.feP.jR(true);
            }
            bkh().faw.setBackgroundColor(bkh().pageContext.getResources().getColor(17170445));
            box();
            return;
        }
        AlaStatManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bjH();
        if (i == 12001) {
            if (i2 == -1) {
                zg(ac(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                ad(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aId();
        }
    }

    public void onResume() {
        if (this.feK != null) {
            this.feK.onResume();
        }
        if (this.ffo && this.ffn != null) {
            this.ffo = false;
            c(this.ffn);
        }
        if (this.eSr != null) {
            this.eSr.onResume();
        }
    }

    public void g(short s) {
        if (this.eSd != null) {
            this.eSd.sL();
        }
        if (this.eSe != null) {
            this.eSe.a(null);
            this.eSe.vW();
        }
        if (this.eSf != null) {
            this.eSf.vW();
        }
        if (this.ffE != null) {
            this.ffE.bkl();
        }
    }

    public boolean bnR() {
        com.baidu.live.data.m yO = bkh().fav.yO();
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUn.fbb.i(yO);
            if (yO != null && yO.mLiveInfo.live_status != 1) {
                bov();
                bkh().pageContext.getPageActivity().finish();
                if (bkh().fav != null && bkh().fav.yO() != null) {
                    a(yO, 1, bkh().fav.bpP() != 1 ? bkh().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                }
                return true;
            }
        } else {
            if (this.eSe != null) {
                this.eSe.wq().a(String.valueOf(yO.mLiveInfo.group_id), String.valueOf(yO.mLiveInfo.live_id), true, String.valueOf(yO.XQ.userId));
            }
            if (this.eSf != null) {
                this.eSf.a(yO);
            }
            if (this.eRS != null) {
                this.eRS.a(bkh().fav.yO());
            }
            if (this.eRd != null) {
                this.eRd.u(yO);
            }
            if (yO != null) {
                if (this.feM != null) {
                    this.feM.q(yO);
                }
                if (this.ffE != null) {
                    this.ffE.a(yO);
                }
                if (this.eSh != null && yO.mLiveInfo != null) {
                    this.eSh.a(yO.mLiveInfo);
                }
                if (this.eSB != null) {
                    this.eSM = this.eSB.m(yO);
                }
                if (this.eRj != null) {
                    this.eRj.iN(this.eSM);
                    this.eRj.h(yO);
                    this.eRj.updateView();
                }
                if (this.eSz != null) {
                    this.eSz.a(yO);
                }
                if (yO.mLiveInfo.live_status != 1) {
                    bov();
                    bkh().pageContext.getPageActivity().finish();
                    if (bkh().fav != null && bkh().fav.yO() != null) {
                        a(yO, 1, bkh().fav.bpP() != 1 ? bkh().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                    }
                    return true;
                } else if (this.ffF) {
                    this.ffg.setVisibility(0);
                    if (!this.ffD && yO.mLiveInfo != null) {
                        this.ffD = true;
                        o.g(yO.mLiveInfo.feed_id, yO.mLiveInfo.live_id);
                    }
                } else {
                    this.ffg.setVisibility(8);
                }
            }
        }
        return false;
    }

    public void bnS() {
        bnI();
    }

    public void bnT() {
        if (this.ffB != null) {
            this.ffB.blA();
        }
    }

    public void bnU() {
        if (this.feK != null && this.feK.getVisibility() != 8) {
            if (bkh().blN() == 2) {
                box();
            } else {
                bow();
            }
        }
        if (this.feK != null && this.feK.getVisibility() != 8) {
            if (bkh().blN() == 1) {
                this.feK.onResume();
            }
            this.feK.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.eSH && this.ffj != null) {
            if (this.eSe != null) {
                this.eSe.wq().getView().setVisibility(0);
            }
            if (this.eSe != null) {
                this.eSe.wr().show();
                this.eSe.wr().setEditText(" @" + this.ffj.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            qp(8);
            this.eSH = false;
        }
        if (this.eSo != null) {
            this.eSo.resume();
        }
        if (this.ffH != null) {
            this.ffH.resume();
        }
        if (this.ffI != null) {
            this.ffI.resume();
        }
    }

    public void onPause() {
        if (this.eSo != null) {
            this.eSo.pause();
        }
        if (this.ffH != null) {
            this.ffH.pause();
        }
        if (this.eSr != null) {
            this.eSr.onPause();
        }
        if (this.ffI != null) {
            this.ffI.pause();
        }
    }

    private void bnV() {
        this.feU = (RelativeLayout) bkh().rootView.findViewById(a.g.ala_live_unremovable_container);
        this.feW = (RelativeLayout) bkh().rootView.findViewById(a.g.under_live_view_panel);
        this.feX = (RelativeLayout) bkh().rootView.findViewById(a.g.over_live_view_panel);
        this.eUn.faw.setOnLiveViewScrollListener(this.fga);
        if (TbadkCoreApplication.getInst().isOther()) {
            this.feW.setVisibility(8);
            this.feX.setVisibility(8);
            bkh().faw.removeAllViews();
        } else {
            this.feV = (RelativeLayout) bkh().rootView.findViewById(a.g.ala_live_removeable_top_container);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.feV.getLayoutParams();
            layoutParams.topMargin = this.eUn.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin = this.eUn.pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds56);
            }
            this.feV.setLayoutParams(layoutParams);
            if (this.eRh == null) {
                this.eRh = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.eUn.pageContext.getPageActivity(), false);
            }
            this.eRh.a(this.eRI);
            this.eRh.a(this.feV, a.g.ala_live_room_host_header_stub, 1L);
            this.eRh.setVisible(0);
            this.ffd = (ImageView) bkh().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
            this.ffd.setOnClickListener(this.ffS);
            this.fff = (ImageView) bkh().rootView.findViewById(a.g.ala_liveroom_host_paster);
            this.fff.setOnClickListener(this.ffS);
            if (com.baidu.live.v.a.zl().axD != null && com.baidu.live.v.a.zl().axD.acQ != null && com.baidu.live.v.a.zl().axD.acQ.qI() && an.b(com.baidu.live.v.a.zl().axD)) {
                this.fff.setVisibility(0);
            } else {
                this.fff.setVisibility(8);
            }
            if (an.c(com.baidu.live.v.a.zl().axD)) {
                this.ffd.setVisibility(0);
                if (an.c(com.baidu.live.v.a.zl().axD)) {
                    this.ffd.setAlpha(0.2f);
                }
            } else if (bkh().faV.hasBeauty() < 0) {
                this.ffd.setVisibility(8);
            } else {
                if (an.c(com.baidu.live.v.a.zl().axD)) {
                    this.ffd.setAlpha(0.2f);
                }
                com.baidu.live.c.pr().getInt("live_beauty_level", 3);
            }
            this.ffc = (ImageView) bkh().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
            this.ffc.setOnClickListener(this.ffS);
            this.ffa = (ImageView) bkh().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
            this.ffa.setOnClickListener(this.ffS);
            this.eUv = (ImageView) bkh().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
            this.eUv.setOnClickListener(this.ffS);
            this.ffb = (ImageView) bkh().rootView.findViewById(a.g.ala_liveroom_host_more);
            this.ffb.setOnClickListener(this.ffS);
            this.ffe = (ImageView) bkh().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
            this.ffe.setOnClickListener(this.ffS);
            this.ffg = bkh().rootView.findViewById(a.g.host_goods_layout);
            this.ffh = (ImageView) bkh().rootView.findViewById(a.g.host_goods_imageView);
            this.ffi = (TextView) bkh().rootView.findViewById(a.g.host_goods_num_textView);
            this.ffh.setOnClickListener(this.ffS);
            bnZ();
            bnY();
            this.ffB = new com.baidu.tieba.ala.liveroom.g.b(bkh().rootView, bkh(), bkh().faV);
            this.eSd = new m();
            bnW();
            bnX();
            if (this.eSg != null && this.eSg.sk() != null) {
                this.eSg.sk().bringToFront();
            }
        }
        this.ffB = new com.baidu.tieba.ala.liveroom.g.b(bkh().rootView, bkh(), bkh().faV);
    }

    private void bnW() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, bkh().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eSe = (i) runTask.getData();
            this.eSe.setFromMaster(true);
            this.eSe.wq().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bkh().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(bkh().pageContext.getPageActivity()) * 0.27f)) + bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            bkh().faw.addView(this.eSe.wq().getView(), layoutParams);
            this.eSe.wr().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bkh().faw.addView(this.eSe.wr().getView(), layoutParams2);
            this.eSe.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
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

    private void bnX() {
        View wx;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913099, j.class, bkh().pageContext);
        if (runTask != null) {
            this.eSf = (j) runTask.getData();
        }
        if (this.eSf != null && (wx = this.eSf.wx()) != null && this.eUn.faw.indexOfChild(wx) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.eUn.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bkh().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bkh().faw.addView(wx, layoutParams);
        }
    }

    private void bnY() {
        CustomResponsedMessage runTask;
        if (this.ffk == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.x.a.class, bkh().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.ffk = (com.baidu.live.x.a) runTask.getData();
        }
    }

    private void bnZ() {
        View sk;
        t.b(bkh().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.afH = true;
        fVar.context = bkh().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, u.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.eSg = (u) runTask.getData();
            if (this.eSg != null && (sk = this.eSg.sk()) != null && bkh().faw.indexOfChild(sk) < 0) {
                if (sk.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sk.getParent()).removeView(sk);
                }
                bkh().faw.addView(sk, bkh().faw.getLayoutParams());
            }
        }
    }

    protected void bjs() {
        View sC;
        if (this.eSh == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.afH = true;
            aVar.context = bkh().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, s.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSh = (s) runTask.getData();
            }
        }
        if (this.eSh != null && (sC = this.eSh.sC()) != null) {
            if (bkh().faw.indexOfChild(sC) < 0) {
                if (sC.getParent() instanceof ViewGroup) {
                    ((ViewGroup) sC.getParent()).removeView(sC);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bkh().faw.addView(sC, layoutParams);
            }
            sC.bringToFront();
        }
    }

    protected void bjr() {
        View sM;
        if (this.eSr == null) {
            z zVar = new z();
            zVar.afH = true;
            zVar.pageContext = bkh().pageContext;
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913170, w.class, zVar);
            if (runTask != null && runTask.getData() != null) {
                this.eSr = (w) runTask.getData();
            }
        }
        if (this.eSr != null && (sM = this.eSr.sM()) != null && bkh().faw.indexOfChild(sM) < 0) {
            if (sM.getParent() instanceof ViewGroup) {
                ((ViewGroup) sM.getParent()).removeView(sM);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds110);
            layoutParams.addRule(12);
            layoutParams.addRule(2, a.g.ala_live_footer_view);
            bkh().faw.addView(sM, layoutParams);
        }
    }

    private void boa() {
        boe();
        biw();
        bod();
        bkh().faw.setVisibility(0);
        qp(0);
    }

    private void bob() {
        if (this.feO == null) {
            this.feO = new com.baidu.tieba.ala.liveroom.r.a(bkh().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.feO.a(bkh().blN(), j, TbadkCoreApplication.getCurrentAccountName(), true, bkh().fav.yO().XQ.portrait, this.otherParams, "", -1L);
        this.feO.af(bkh().faw);
    }

    private void boc() {
        if (this.ffm == null) {
            com.baidu.live.w.a eG = eG(bkh().pageContext.getPageActivity());
            if (eG != null) {
                this.ffm = eG;
            } else {
                CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913125, com.baidu.live.w.a.class, bkh().pageContext.getPageActivity());
                if (runTask != null) {
                    this.ffm = (com.baidu.live.w.a) runTask.getData();
                }
            }
            if (this.ffm != null) {
                this.ffm.h(this.feW);
                this.ffm.i(this.feX);
                this.ffm.ci((bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds330) + bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds96)) - bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds300));
                if (this.eRW != null) {
                    this.ffm.ch(this.eRW.brv());
                }
                this.ffm.j(bkh().faw);
                this.ffm.a(this.eQl);
                this.ffm.n(bkh().fav.yO());
                this.ffm.a(this.eRj);
                this.ffm.a(new a.InterfaceC0105a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
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

    private void bod() {
        if (this.feQ == null) {
            this.feQ = new b(bkh().pageContext, bkh().faw);
        }
    }

    private void boe() {
        if (this.eRd == null) {
            this.eRd = new com.baidu.tieba.ala.liveroom.l.a(bkh().pageContext, true, this.ffW);
            this.eRd.c(this.feU, (com.baidu.live.data.m) null);
            this.eRd.a(this.eRI);
        }
        if (this.feL == null) {
            this.feL = new com.baidu.tieba.ala.liveroom.l.a(bkh().pageContext, true, null);
            this.feL.a(this.feV, null, a.g.ala_live_room_host_header_stub);
            this.feL.bmZ();
        }
    }

    protected void bjb() {
        CustomResponsedMessage runTask;
        boolean z = false;
        com.baidu.tieba.ala.liveroom.data.h bpF = bkh().fav.bpF();
        boolean z2 = com.baidu.live.v.a.zl().awC.aaS;
        if (bpF == null || bpF.Yo) {
            z = z2;
        }
        if (z && this.eRS == null && (runTask = MessageManager.getInstance().runTask(2913152, com.baidu.live.h.a.class, bkh().pageContext)) != null) {
            this.eRS = (com.baidu.live.h.a) runTask.getData();
            if (this.eRS != null) {
                this.eRS.setIsHost(true);
                this.eRS.bV(1);
                View view = this.eRS.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bkh().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bkh().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.feV.addView(view, layoutParams);
                }
            }
        }
    }

    private void f(com.baidu.live.data.m mVar) {
        AlaActiveRootView alaActiveRootView;
        AlaActiveRootView alaActiveRootView2 = null;
        if (this.eRj == null) {
            this.eRj = new com.baidu.tieba.ala.liveroom.activeview.b(bkh().pageContext);
        }
        this.eRj.setOtherParams(this.otherParams);
        this.eRj.b(mVar, false);
        this.eRj.setHost(true);
        this.eRj.a(1, bkh().faw, pQ(1));
        this.eRj.a(2, bkh().faw, pQ(2));
        this.eRj.iN(this.eSM);
        this.eRj.setVisible(this.feJ ? 8 : 0);
        this.eRj.a(this.eQl);
        if (this.eQl != null) {
            if (this.eRj != null) {
                alaActiveRootView2 = this.eRj.pL(1);
                alaActiveRootView = this.eRj.pL(2);
            } else {
                alaActiveRootView = null;
            }
            if (alaActiveRootView2 != null && alaActiveRootView2.getVisibility() == 0 && alaActiveRootView2.getChildCount() > 0) {
                this.eQl.a(alaActiveRootView2);
            }
            if (alaActiveRootView != null && alaActiveRootView.getVisibility() == 0 && alaActiveRootView.getChildCount() > 0) {
                this.eQl.a(alaActiveRootView);
            }
        }
    }

    private void v(com.baidu.live.data.m mVar) {
        CustomResponsedMessage runTask;
        if (this.eSB == null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bkh().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.q.a)) {
            this.eSB = (com.baidu.live.q.a) runTask.getData();
            if (this.eSB != null) {
                this.eSB.a(bkh().faw, jA(false));
            }
        }
        if (this.eSB != null) {
            this.eSM = this.eSB.m(mVar);
            this.eSB.setCanVisible(!this.feJ);
        }
    }

    protected void bof() {
        CustomResponsedMessage runTask;
        if (bkh() != null && (runTask = MessageManager.getInstance().runTask(2913149, com.baidu.live.i.a.class, bkh().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eSz = (com.baidu.live.i.a) runTask.getData();
            this.eSz.a(bkh().faw, bog());
            if (bkh().fav != null) {
                this.eSz.a(bkh().fav.yO());
            }
            this.eSz.setCanVisible(true);
            this.eSz.aP(false);
            this.eSz.a(bkh().fav.bdZ());
        }
    }

    private void bjk() {
        this.ffI = new com.baidu.tieba.ala.liveroom.n.c(bkh().pageContext.getPageActivity());
    }

    private ViewGroup.LayoutParams bog() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bkh().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.eSp != null && this.eSp.isShowing()) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.feO != null && this.feO.isShowing()) {
            layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
            layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams pQ(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bkh().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.feT != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bkh().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
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
        layoutParams.rightMargin = bkh().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.ffE != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.ffE.au(true) + bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.feT != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void biw() {
        if (this.feN == null) {
            this.feN = new com.baidu.tieba.ala.liveroom.b.a(bkh().pageContext, true);
        }
    }

    private void boh() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bkh().pageContext.getPageActivity();
            this.eTI = new ImageView(pageActivity);
            this.eTI.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.eTI.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eTI.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bkh().rootView.addView(this.eTI, layoutParams);
            this.eTI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.bot();
                }
            });
            this.eTI.setVisibility(8);
        }
    }

    private void bji() {
        this.eSo = new com.baidu.tieba.ala.liveroom.f.a(bkh().pageContext);
    }

    private void bjw() {
        if (this.eSp == null) {
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913159, h.class, bkh().pageContext.getPageActivity());
            if (runTask != null && runTask.getData() != null) {
                this.eSp = (h) runTask.getData();
            } else {
                return;
            }
        }
        this.eSp.setHost(true);
        this.eSp.setOtherParams(this.otherParams);
        if (bkh().fav.yO() != null && bkh().fav.yO().XQ != null && bkh().fav.yO().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.eSp.a(bkh().faw, layoutParams, bkh().fav.yO());
        }
    }

    private void boi() {
        CustomResponsedMessage runTask;
        if (this.ffG == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bkh().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.ffG = (com.baidu.live.b.a) runTask.getData();
            if (this.ffG != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bkh().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.ffG.a(bkh().faw, layoutParams);
            }
        }
        if (this.ffG != null) {
            this.ffG.a(bkh().fav.yO());
        }
    }

    private void boj() {
        CustomResponsedMessage runTask;
        if (this.ffH == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bkh().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.ffH = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.ffE != null) {
            this.ffE.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bkh().pageContext.registerListener(this.eSV);
        bkh().pageContext.registerListener(this.ffN);
        bkh().pageContext.registerListener(this.eSX);
        bkh().pageContext.registerListener(this.eSY);
        bkh().pageContext.registerListener(this.ffT);
        bkh().pageContext.registerListener(this.fef);
        bkh().pageContext.registerListener(this.eOX);
        bkh().pageContext.registerListener(this.ffU);
        bkh().pageContext.registerListener(this.eSW);
        bkh().pageContext.registerListener(this.eTv);
        bkh().pageContext.registerListener(this.fgc);
        bkh().pageContext.registerListener(this.fgd);
        bkh().pageContext.registerListener(this.fge);
        bkh().pageContext.registerListener(this.eTd);
        bkh().pageContext.registerListener(this.ffR);
        bkh().pageContext.registerListener(this.ffO);
        bkh().pageContext.registerListener(this.awk);
        bkh().pageContext.registerListener(this.awl);
        bkh().pageContext.registerListener(this.ffP);
        bkh().pageContext.registerListener(this.eTf);
        bkh().pageContext.registerListener(this.eTe);
        bkh().pageContext.registerListener(this.eTg);
        bkh().pageContext.registerListener(this.ffQ);
        bkh().pageContext.registerListener(this.ffP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jB(boolean z) {
        if (!TbadkCoreApplication.getInst().isTieba()) {
            if (an.c(com.baidu.live.v.a.zl().axD)) {
                bkh().pageContext.showToast(a.i.sdk_filter_beauty_grey_tip);
                return;
            } else if (bkh().faY.pA() == null || ListUtils.isEmpty(bkh().faY.pA().VJ) || bkh().faY.pA().VK == null || bkh().faY.pA().VK.isEmpty()) {
                if (!BdNetTypeUtil.isNetWorkAvailable()) {
                    bkh().pageContext.showToast(a.i.sdk_filter_beauty_no_net);
                    return;
                } else if (!this.ffJ) {
                    this.ffK = BdUniqueId.gen();
                    bkh().faY.a(this.ffK);
                    this.ffJ = true;
                    return;
                } else {
                    return;
                }
            }
        }
        BdUtilHelper.hideSoftKeyPad(bkh().pageContext.getPageActivity(), bkh().rootView);
        qp(8);
        if (bkh().faV.hasAdvancedBeauty() && this.ffB != null) {
            if (!this.ffL || this.feK.getVisibility() == 0) {
                this.ffB.a(bkh().faV.getVideoConfig());
            }
            this.ffB.a(bkh().faV.getVideoConfig(), this.ffC);
            if (!this.ffC) {
                this.ffC = true;
            }
        }
        if (z && this.eSe != null) {
            this.eSe.wq().getView().setVisibility(8);
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
    public void bok() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkh().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bkh().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkh().f((short) 1);
            }
        });
        bdAlertDialog.create(bkh().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bol() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkh().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bkh().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkh().f((short) 1);
            }
        });
        bdAlertDialog.create(bkh().pageContext).show();
    }

    private void zf(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkh().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bkh().f((short) 1);
            }
        });
        bdAlertDialog.create(bkh().pageContext).show();
    }

    public void bom() {
        bjb();
        com.baidu.live.data.h bdZ = bkh().fav.bdZ();
        int i = 5;
        if (bdZ != null) {
            i = (int) bdZ.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null && AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bkh().fav.cX(AlaMasterLiveRoomOpearator.this.bkh().fav.yO().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bdZ != null) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.eUn.fbb.b(bdZ);
                return;
            }
            if (this.eRc == null) {
                this.eRc = new com.baidu.tieba.ala.liveroom.audiencelist.c(bkh().pageContext, this.ffW, true);
            }
            if (this.ffA) {
                this.ffA = false;
                this.eRc.a(String.valueOf(bkh().fav.yO().mLiveInfo.group_id), String.valueOf(bkh().fav.yO().mLiveInfo.live_id), String.valueOf(bkh().fav.yO().XQ.userId), bkh().fav.yO());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.eRS != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.eRc.c(this.feV, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.eRc.f(bdZ);
            this.eRh.setVisible(0);
            this.eRh.cD(bdZ.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bon() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aId() {
        if (bkh().fav != null) {
            if (this.eRT == null) {
                this.eRT = new c(bkh().pageContext);
            }
            this.eRT.c(bkh().fav.yO(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bkh().fav != null && bkh().fav.yO() != null && bkh().fav.yO().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bkh().fav.yO().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bkh().fav.yO().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bkh().fav.yO().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bkh().fav != null && bkh().fav.yO() != null && bkh().fav.yO().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bkh().fav.yO().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bkh().fav.yO().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bkh().fav.yO().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean boo() {
        return this.feI;
    }

    private void jC(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(feH, z);
        this.feI = z;
    }

    private void bop() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkh().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.bkh().pageContext).bpn();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bkh().pageContext).show();
    }

    private void boq() {
        if (this.fer && bkh().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bkh().fba.Aa();
        }
        bkh().faZ.prepareTime = System.currentTimeMillis() - bkh().faZ.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bkh().fav != null && bkh().fav.yO() != null && bkh().fav.yO().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bkh().fav.yO().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bkh().fav.yO().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bkh().faZ.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.feK != null && this.feK.getView().getParent() != null) {
            this.feK.setVisibility(8);
            bkh().rootView.removeView(this.feK.getView());
            this.feK.release();
        }
        if (this.ffB != null) {
            this.ffB.setVisible(8);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bkh().faw.indexOfChild(this.feS) < 0) {
            bkh().faw.addView(this.feS, layoutParams);
        }
        this.feS.qE(1000);
    }

    private void bjH() {
        if (bkh().blN() == 1) {
            bkh().faV.startRecord();
        }
    }

    private void zg(String str) {
        zh(str);
    }

    private void zh(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bkh().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.feK != null) {
            this.feK.yV(fromJson.getSmallurl());
        }
    }

    private boolean bor() {
        return com.baidu.live.c.pr().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bos() {
        com.baidu.live.c.pr().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.eUn.faV.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bot() {
        int i = a.i.live_close_confirm;
        if (this.ffE != null && this.ffE.bkn()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.ffE != null && this.ffE.bkm()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bkh().pageContext.getPageActivity());
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
                if (AlaMasterLiveRoomOpearator.this.bkh().fav.yO() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkh().fav.yO(), 0, AlaMasterLiveRoomOpearator.this.bkh().fav.bpP() != 1 ? AlaMasterLiveRoomOpearator.this.bkh().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(bkh().pageContext).show();
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
                bkh().fav.cV(Long.toString(alaLiveInfoData2.live_id), str2);
            }
            alaLiveUserInfoData = alaLiveUserInfoData2;
            alaLiveInfoData = alaLiveInfoData2;
        } else {
            alaLiveInfoData = null;
        }
        if (!this.ffy) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bkh().faZ;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bkh().faV.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.ffu;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.ffv;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.ffq;
            if (this.ffr != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.ffs - this.fft) / this.ffr) * 100.0f;
            }
            Intent intent = new Intent(bkh().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (alaLiveUserInfoData != null) {
                intent.putExtra("liveUserData", alaLiveUserInfoData.getJsonString());
            }
            if (bkh().fav != null && bkh().fav.yO() != null && bkh().fav.yO().XQ != null) {
                String str3 = bkh().fav.yO().XQ.nickName;
                String str4 = bkh().fav.yO().XQ.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.m yO = bkh().fav.yO();
            if (yO != null && yO.XQ != null && !TextUtils.isEmpty(yO.XQ.portrait)) {
                intent.putExtra("host_portrait", yO.XQ.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.ffw = intent;
                this.ffx = s;
                bkh().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void bou() {
        if (this.ffw != null) {
            a(this.ffw, this.ffx);
            this.ffw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.ffy = true;
        if (this.ffE != null) {
            this.ffE.onDestroy();
        }
        if (intent != null) {
            intent.putExtra("live_back_scheme", this.eOM);
            bkh().pageContext.getPageActivity().startActivity(intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913178));
        bkh().f(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bov() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eUn.fbb != null && this.eUn.fbb.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (this.ffE != null && this.ffE.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bkh().faX.bpa()) {
                bot();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.feT.setVisibility(4);
            return;
        }
        this.feT.a(i, z, i2, z2);
        if (this.eUn != null && this.eUn.fav != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.bVg != i3) {
                this.bVg = i3;
                if (this.feR == null) {
                    this.feR = new com.baidu.tieba.ala.liveroom.tippop.a(this.eUn.pageContext, null);
                }
                switch (this.bVg) {
                    case 0:
                        this.feR.a(this.eUn.rootView, this.eUn.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.feR.a(this.eUn.rootView, this.eUn.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.feR.a(this.eUn.rootView, this.eUn.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.eUn.fav.j(this.eUn.fav.yO().mLiveInfo.live_id, i3);
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
                        AlaMasterLiveRoomOpearator.this.bov();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkh().fav.yO(), 1, str3);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0468, code lost:
        yL(r6);
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
            if (this.feP != null) {
                this.feP.v(aVar);
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
                if (this.ffE != null) {
                }
                if (!"close_live".equals(str2)) {
                }
            }
            if (this.ffE != null) {
                this.ffE.cU(str2);
            }
            if (!"close_live".equals(str2)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.bov();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bkh().fav.yO(), 1, str);
                    }
                });
            } else if ("live_admin".equals(str2)) {
                if (bkh().fav.yO() != null && jSONObject2 != null) {
                    long optLong = jSONObject2.optLong("user_id");
                    int optInt = jSONObject2.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bkh().fav.yO().Ye.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bkh().fav.yO().Ye.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bkh().fav.yO().Ye.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str2)) {
                if (this.ffk != null) {
                    this.ffk.v(jSONObject2);
                }
            } else if ("enter_live".equals(str2)) {
                if (jSONObject2 != null) {
                    String optString4 = jSONObject2.optString("share_enter_msg");
                    int optInt2 = jSONObject2.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString4)) {
                        this.feQ.at(optString4, optInt2);
                    }
                    if (this.eRh.getCount() > 20) {
                        this.eRh.cD(this.eRh.getCount() + 1);
                    } else if (this.eRc != null) {
                        com.baidu.live.data.a xo = aVar.xo();
                        com.baidu.live.data.g gVar = new com.baidu.live.data.g();
                        gVar.XR = new AlaLocationData();
                        gVar.XS = new AlaRelationData();
                        gVar.XQ = new AlaLiveUserInfoData();
                        gVar.XQ.userId = JavaTypesHelper.toLong(xo.userId, 0L);
                        gVar.XQ.userName = xo.userName;
                        gVar.XQ.portrait = xo.portrait;
                        if (this.eRc.c(gVar)) {
                            this.eRh.cD(this.eRh.getCount() + 1);
                        }
                    }
                }
            } else if ("ui_event".equals(str2)) {
                if (jSONObject2 != null && jSONObject2.optInt("event_type") == 1001 && bkh().fav.yO() != null && bkh().fav.yO().mLiveInfo != null) {
                    String str5 = bkh().fav.yO().mLiveInfo.feed_id;
                    long j4 = bkh().fav.yO().mLiveInfo.live_id;
                    long optLong2 = jSONObject2.optLong("id");
                    if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                        o.g(str5, j4);
                        com.baidu.live.utils.m.h(j4, optLong2);
                    }
                }
            } else if ("need_update_live_mark_info".equals(str2)) {
                if (jSONObject2 != null && bkh() != null && bkh().fav != null && bkh().fav.yO() != null && bkh().fav.yO().Ye != null && bkh().fav.yO().Ye.userId == jSONObject2.optLong("user_id")) {
                    bkh().fav.bpE();
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
                if (bkh().fav != null && bkh().fav.yO() != null && bkh().fav.yO().mLiveInfo != null) {
                    j5 = bkh().fav.yO().mLiveInfo.live_id;
                    j6 = bkh().fav.yO().mLiveInfo.group_id;
                    j7 = bkh().fav.yO().XQ.userId;
                    str7 = bkh().fav.yO().mLiveInfo.appId;
                    if (bkh().fav.yO().mLiveSdkInfo.mCastIds != null) {
                        String str8 = bkh().fav.yO().mLiveSdkInfo.mCastIds.XX;
                        j = j7;
                        j2 = j6;
                        j3 = j5;
                        str3 = bkh().fav.yO().mLiveSdkInfo.mCastIds.XY;
                        str4 = str8;
                        LogManager.getLiveIMLogger().doGiftIMLog(LogConfig.GIFT_IM_RECEIVE, str4, str3, optString5, "");
                        if (this.isBackground || bkh().blN() != 2) {
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
                        yL(optString5);
                        com.baidu.tieba.ala.liveroom.e.d dVar = new com.baidu.tieba.ala.liveroom.e.d();
                        dVar.eZO = optLong4;
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
                yL(optString5);
                com.baidu.tieba.ala.liveroom.e.d dVar2 = new com.baidu.tieba.ala.liveroom.e.d();
                dVar2.eZO = optLong4;
                dVar2.liveId = j3;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913094, dVar2));
            } catch (JSONException e6) {
            }
        }
    }

    private void yL(String str) {
        if (this.eRj != null) {
            this.eRj.yL(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp(int i) {
        View findViewById = bkh().rootView.findViewById(a.g.ala_live_host_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (this.eRj != null) {
            this.eRj.bj(2, i);
        }
    }

    private void bow() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bkh().faV != null && AlaMasterLiveRoomOpearator.this.bkh().faV.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bkh().faV.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bkh().faV.startRecord();
                }
            }
        });
    }

    private void box() {
        if (bkh().faV != null && bkh().faV.getPreview() != null) {
            bkh().faV.getPreview().setVisibility(8);
            bkh().faV.stopRecord();
        }
    }

    public void boy() {
        this.faS = bkh().fav.bpQ();
        if (this.feK != null) {
            this.feK.jn(this.faS);
        }
    }

    public void blL() {
        if (TbadkCoreApplication.getInst().isOther()) {
            boz();
        } else if (this.feK != null) {
            this.feK.blL();
        }
    }

    public void onDestroy() {
        if (this.ffp != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.ffp);
        }
        this.ffp = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ffB != null) {
            this.ffB.jl(true);
        }
        this.ffB = null;
        if (this.feK != null) {
            this.feK.destroy();
            bkh().rootView.removeView(this.feK.getView());
            this.feK.release();
            this.feK = null;
        }
        if (this.ffE != null) {
            this.ffE.onDestroy();
        }
        if (this.eRT != null) {
            this.eRT.onDestroy();
        }
        if (this.eRV != null) {
            this.eRV.onDestroy();
        }
        if (this.eRd != null) {
            this.eRd.onDestroy();
            this.eRd = null;
        }
        if (this.feL != null) {
            this.feL.onDestroy();
        }
        if (this.eSr != null) {
            this.eSr.onDestroy();
            this.eSr = null;
        }
        if (this.feS != null) {
            this.feS.stopCountDown();
        }
        if (this.feO != null) {
            this.feO.onDestroy();
        }
        if (this.feQ != null) {
            this.feQ.onDestroy();
        }
        if (this.ffk != null) {
            this.ffk.onDestroy();
            this.ffk = null;
        }
        if (this.eSg != null) {
            this.eSg.onDestroy();
            this.eSg = null;
        }
        t.sH();
        com.baidu.live.entereffect.a.qR().release();
        if (this.eSh != null) {
            this.eSh.onDestroy();
            this.eSh = null;
        }
        if (this.feR != null) {
            this.feR.onDestroy();
        }
        if (this.feP != null) {
            this.feP.brx();
            this.feP.release();
        }
        if (this.eRh != null) {
            this.eRh = null;
        }
        if (this.eRj != null) {
            this.eRj.release();
        }
        if (this.feM != null) {
            this.feM.onDestroy();
        }
        if (this.feP != null) {
            this.feP.onDestroy();
        }
        if (this.eSf != null) {
            this.eSf.release();
        }
        if (this.eSo != null) {
            this.eSo.release();
        }
        if (this.eSp != null) {
            this.eSp.onDestroy();
        }
        if (this.ffm != null) {
            this.ffm.onDestroy();
        }
        if (this.eSB != null) {
            this.eSB.release();
        }
        if (this.ffG != null) {
            this.ffG.onDestory();
        }
        if (this.ffH != null) {
            this.ffH.release();
        }
        if (this.eSz != null) {
            this.eSz.onDestroy();
        }
        if (this.ffI != null) {
            this.ffI.release();
        }
        MessageManager.getInstance().unRegisterListener(this.eTv);
        MessageManager.getInstance().unRegisterListener(this.fgc);
        MessageManager.getInstance().unRegisterListener(this.fgd);
        MessageManager.getInstance().unRegisterListener(this.fge);
        MessageManager.getInstance().unRegisterListener(this.eTd);
        MessageManager.getInstance().unRegisterListener(this.ffR);
        MessageManager.getInstance().unRegisterListener(this.ffO);
        MessageManager.getInstance().unRegisterListener(this.awk);
        MessageManager.getInstance().unRegisterListener(this.awl);
        MessageManager.getInstance().unRegisterListener(this.ffP);
        MessageManager.getInstance().unRegisterListener(this.eTf);
        MessageManager.getInstance().unRegisterListener(this.eTe);
        MessageManager.getInstance().unRegisterListener(this.eTg);
        MessageManager.getInstance().unRegisterListener(this.ffQ);
        MessageManager.getInstance().unRegisterListener(this.ffP);
        com.baidu.live.utils.m.Bc();
    }

    public void g(AlaLivePersonData alaLivePersonData) {
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eUn.fbb.a(this.fgg, this.eUn.faW, this.feU, alaLivePersonData);
        }
    }

    private void boz() {
        if (this.ffn != null) {
            this.eUn.faZ.startTime = System.currentTimeMillis();
            this.eUn.faZ.liveTotalTime = System.currentTimeMillis();
            this.eUn.faZ.sampleMemAndCPU();
            this.eUn.faX.a((short) 4, this.ffn);
        }
    }

    private ViewGroup.LayoutParams boA() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
        layoutParams.bottomMargin = bkh().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds140);
        return layoutParams;
    }
}
