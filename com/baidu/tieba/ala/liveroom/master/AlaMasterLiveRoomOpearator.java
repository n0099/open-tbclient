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
import com.baidu.live.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c.o;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.aa;
import com.baidu.live.data.ab;
import com.baidu.live.data.k;
import com.baidu.live.data.u;
import com.baidu.live.data.y;
import com.baidu.live.data.z;
import com.baidu.live.gift.r;
import com.baidu.live.gift.s;
import com.baidu.live.gift.t;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.live.tbadk.core.atomdata.EditHeadActivityConfig;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
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
import com.baidu.live.utils.n;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.g.b;
import com.baidu.tieba.ala.liveroom.g.d;
import com.baidu.tieba.ala.liveroom.master.panel.b;
import com.baidu.tieba.ala.liveroom.messages.HasGoodsAuthResponseMessage;
import com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveStreamStatusView;
import com.baidu.tieba.ala.liveroom.views.AlaLiveView;
import com.baidu.tieba.ala.liveroom.views.b;
import com.baidu.tieba.ala.liveroom.views.f;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String eYG;
    private List<ab> arQ;
    private com.baidu.tieba.ala.liveroom.l.a eLA;
    private com.baidu.tieba.ala.liveroom.audiencelist.b eLE;
    private com.baidu.tieba.ala.liveroom.activeview.b eLG;
    private c eLz;
    private t eMA;
    private r eMB;
    protected com.baidu.tieba.ala.liveroom.f.a eMI;
    protected com.baidu.tieba.ala.liveroom.j.a eMJ;
    protected com.baidu.live.h.a eMQ;
    private com.baidu.live.m.a eMS;
    private com.baidu.live.g.a eMm;
    private com.baidu.tieba.ala.liveroom.share.c eMn;
    private com.baidu.tieba.ala.liveroom.n.b eMo;
    private com.baidu.tieba.ala.liveroom.guide.c eMp;
    private com.baidu.tieba.ala.liveroom.watermark.a eMq;
    private m eMx;
    private i eMy;
    private j eMz;
    private ImageView eNU;
    private e eOH;
    private ImageView eOP;
    private f eOQ;
    private boolean eYH;
    private d eYJ;
    private com.baidu.tieba.ala.liveroom.l.a eYK;
    private com.baidu.tieba.ala.liveroom.e.c eYL;
    private com.baidu.tieba.ala.liveroom.b.a eYM;
    private com.baidu.tieba.ala.liveroom.r.a eYN;
    private com.baidu.tieba.ala.liveroom.u.a eYO;
    private b eYP;
    private com.baidu.tieba.ala.liveroom.tippop.a eYQ;
    private AlaLiveCountDownView eYR;
    private AlaLiveStreamStatusView eYS;
    private com.baidu.tieba.ala.liveroom.views.b eYT;
    private RelativeLayout eYU;
    private AlaLiveFaceVerifyView eYV;
    private ImageView eYW;
    private ImageView eYX;
    private ImageView eYY;
    private ImageView eYZ;
    private RelativeLayout eYk;
    private boolean eYq;
    private boolean eZA;
    private com.baidu.tieba.ala.liveroom.challenge.f eZB;
    private com.baidu.live.b.a eZD;
    private com.baidu.live.b.b eZE;
    private ImageView eZa;
    private ImageView eZb;
    private ImageView eZc;
    private View eZd;
    private ImageView eZe;
    private TextView eZf;
    private FrameLayout eZg;
    private FrameLayout eZh;
    private u eZi;
    private com.baidu.live.s.a eZj;
    private com.baidu.tieba.ala.liveroom.master.panel.b eZk;
    private com.baidu.tieba.ala.liveroom.data.d eZl;
    private short eZv;
    private com.baidu.tieba.ala.liveroom.g.b eZz;
    private boolean eYI = false;
    private boolean eMY = false;
    private Handler mHandler = new Handler();
    private boolean eZm = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver eZn = null;
    private boolean eZo = false;
    private int eZp = 0;
    private int eZq = 0;
    private int eZr = 0;
    private long eZs = 0;
    private long eZt = 0;
    private volatile boolean isBackground = false;
    private Intent eZu = null;
    private int mOrientation = 1;
    private boolean eUV = false;
    private boolean eZw = false;
    private boolean eZx = true;
    private boolean eON = false;
    private boolean eZy = true;
    private int bQp = 0;
    public boolean eZC = false;
    private String otherParams = "";
    private CustomMessageListener eNq = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.eMo == null) {
                AlaMasterLiveRoomOpearator.this.eMo = new com.baidu.tieba.ala.liveroom.n.b(AlaMasterLiveRoomOpearator.this.bhC().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.eMo.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener eNx = new CustomMessageListener(2913148) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.eMQ != null) {
                AlaMasterLiveRoomOpearator.this.eMQ.tS();
            }
        }
    };
    private CustomMessageListener eZF = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                AlaMasterLiveRoomOpearator.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener eNn = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.eOH.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.yn(str);
            }
        }
    };
    private CustomMessageListener eNo = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aFs();
        }
    };
    private CustomMessageListener eNI = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.eMB instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) AlaMasterLiveRoomOpearator.this.eMB).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(2913134) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.46
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUtilHelper.showToast(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity(), a.i.sdk_redpacket_snatch_host_alert);
        }
    };
    private CustomMessageListener eZG = new CustomMessageListener(2913141) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.47
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.eZE != null) {
                k wf = AlaMasterLiveRoomOpearator.this.bhC().eUF.wf();
                long j = wf.mLiveInfo.live_id;
                long j2 = wf.mLiveInfo.user_id;
                AlaMasterLiveRoomOpearator.this.eZE.c((String) customResponsedMessage.getData(), j, j2);
            }
        }
    };
    private CustomMessageListener eNw = new CustomMessageListener(2913147) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.48
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.i(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf());
        }
    };
    private View.OnClickListener eZH = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.eYZ) {
                    AlaMasterLiveRoomOpearator.this.bkY();
                    AlaMasterLiveRoomOpearator.this.eZk.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.eYY) {
                    if (AlaMasterLiveRoomOpearator.this.eMy != null) {
                        AlaMasterLiveRoomOpearator.this.eMy.uw().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.eZa) {
                    AlaMasterLiveRoomOpearator.this.aFs();
                } else if (view != AlaMasterLiveRoomOpearator.this.eZb) {
                    if (view == AlaMasterLiveRoomOpearator.this.eOP) {
                        if (AlaMasterLiveRoomOpearator.this.eZB != null) {
                            AlaMasterLiveRoomOpearator.this.eZB.bhE();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eZc) {
                        if (AlaMasterLiveRoomOpearator.this.eYO != null) {
                            g bmR = AlaMasterLiveRoomOpearator.this.bhC().eUF.bmR();
                            if (bmR == null || bmR.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(bmR.mLiveSdkInfo.mRoomId);
                                if (bmR.mLiveSdkInfo.mCastIds != null) {
                                    str2 = bmR.mLiveSdkInfo.mCastIds.VW;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.eYO.ac("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eZe) {
                        k wf = AlaMasterLiveRoomOpearator.this.bhC().eUF.wf();
                        if (AlaMasterLiveRoomOpearator.this.eMI != null && wf != null && wf.mLiveInfo != null) {
                            String valueOf = String.valueOf(wf.mLiveInfo.live_id);
                            String valueOf2 = String.valueOf(wf.mLiveInfo.feed_id);
                            long j = wf.mLiveInfo.room_id;
                            String str3 = wf.mLiveInfo.cover;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (wf.mLiveInfo.session_info != null) {
                                str4 = wf.mLiveInfo.session_info.flvUrl;
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
                            AlaMasterLiveRoomOpearator.this.eMI.ys(n.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.jo(true);
                }
            }
        }
    };
    private CustomMessageListener eNp = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof u) {
                    AlaMasterLiveRoomOpearator.this.eMY = true;
                    AlaMasterLiveRoomOpearator.this.eZi = (u) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.eYT != null && AlaMasterLiveRoomOpearator.this.eYT.getView() != null && AlaMasterLiveRoomOpearator.this.eYT.getView().getParent() != null) {
                        AlaMasterLiveRoomOpearator.this.bhC().rootView.removeView(AlaMasterLiveRoomOpearator.this.eYT.getView());
                        if (AlaMasterLiveRoomOpearator.this.eMy != null) {
                            AlaMasterLiveRoomOpearator.this.eMy.uv().getView().setVisibility(0);
                        }
                    }
                    if (AlaMasterLiveRoomOpearator.this.eMy != null) {
                        AlaMasterLiveRoomOpearator.this.eMy.uw().show();
                        AlaMasterLiveRoomOpearator.this.eMy.uw().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.qc(8);
                }
            }
        }
    };
    private CustomMessageListener eZI = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.bhC() != null && AlaMasterLiveRoomOpearator.this.bhC().eVa != null) {
                AlaMasterLiveRoomOpearator.this.bhC().eVa.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener eYf = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.blL();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.bhC().eUF.qk(i);
                if (AlaMasterLiveRoomOpearator.this.eMQ != null) {
                    AlaMasterLiveRoomOpearator.this.eMQ.onDestroy();
                }
            }
        }
    };
    private CustomMessageListener eJz = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.blE();
        }
    };
    public final HttpMessageListener eZJ = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.wi()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.eZk != null) {
                            AlaMasterLiveRoomOpearator.this.eZk.ju(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.eZk.bmh();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.bhC().eUY.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.eYQ != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.eYQ.a(AlaMasterLiveRoomOpearator.this.bhC().rootView, AlaMasterLiveRoomOpearator.this.bhC().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.bhC().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.eYQ.qr(2);
                        AlaMasterLiveRoomOpearator.this.eYQ.a(AlaMasterLiveRoomOpearator.this.bhC().rootView, string, 3);
                    }
                }
            }
        }
    };
    private b.a eZK = new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        @Override // com.baidu.tieba.ala.liveroom.views.b.a
        public void qd(int i) {
            com.baidu.live.c.oI().putInt("live_beauty_level", i);
            AlaMasterLiveRoomOpearator.this.bhC().eUY.setBeauty(i);
        }
    };
    private f.a eZL = new f.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void blQ() {
            AlaMasterLiveRoomOpearator.this.blB();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void blR() {
            AlaMasterLiveRoomOpearator.this.blC();
        }
    };
    com.baidu.tieba.ala.liveroom.b eZM = new com.baidu.tieba.ala.liveroom.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        @Override // com.baidu.tieba.ala.liveroom.b
        public boolean pq(int i) {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void pr(int i) {
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void ps(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.bhC().bjk() == 1) {
                AlaMasterLiveRoomOpearator.this.bhC().eUY.stopRecord();
            }
        }
    };
    private IShareCallback eZN = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.eZm && AlaMasterLiveRoomOpearator.this.eZl != null) {
                AlaMasterLiveRoomOpearator.this.eZm = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.eZl);
            }
        }
    };
    private View.OnTouchListener eZO = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.bhC().eVa.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bhC().eUG);
            if (AlaMasterLiveRoomOpearator.this.eYT != null && AlaMasterLiveRoomOpearator.this.eYT.getView() != null && AlaMasterLiveRoomOpearator.this.eYT.getView().getParent() != null) {
                AlaMasterLiveRoomOpearator.this.bhC().rootView.removeView(AlaMasterLiveRoomOpearator.this.eYT.getView());
                AlaMasterLiveRoomOpearator.this.qc(0);
                if (AlaMasterLiveRoomOpearator.this.eMy != null) {
                    AlaMasterLiveRoomOpearator.this.eMy.uv().getView().setVisibility(0);
                }
            }
            return false;
        }
    };
    private f.b eZP = new f.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void blS() {
            if (AlaMasterLiveRoomOpearator.this.bhC() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF != null) {
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUF.bmJ();
                } else if (TbadkCoreApplication.getInst().isTieba() || TbadkCoreApplication.getInst().isHaokan()) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUF.bmK();
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void blT() {
            AlaMasterLiveRoomOpearator.this.eYq = AlaMasterLiveRoomOpearator.this.eYJ.bjc();
            AlaMasterLiveRoomOpearator.this.bhC().eVa.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bhC().eVa.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.bhC().eVa.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.eUS = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.bhC().bjk();
            dVar.title = AlaMasterLiveRoomOpearator.this.eYJ.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.eUT = AlaMasterLiveRoomOpearator.this.eYJ.bjd();
            dVar.eUW = AlaMasterLiveRoomOpearator.this.eYq;
            dVar.eUV = AlaMasterLiveRoomOpearator.this.eYJ.bja();
            dVar.eUU = AlaMasterLiveRoomOpearator.this.eYJ.bjf();
            dVar.eUX = AlaMasterLiveRoomOpearator.this.eYJ.bjb();
            if (dVar.eUX) {
                if (AlaMasterLiveRoomOpearator.this.eYJ.bjg()) {
                    AlaMasterLiveRoomOpearator.this.eZm = true;
                    AlaMasterLiveRoomOpearator.this.eZl = dVar;
                    AlaMasterLiveRoomOpearator.this.eYJ.bjh();
                } else {
                    AlaMasterLiveRoomOpearator.this.c(dVar);
                }
                if (FinishLiveManager.getInstance().getFinishListener() != null) {
                    FinishLiveManager.getInstance().getFinishListener().onStartLive();
                }
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_OPENSTARTLIVE_PAGE_END);
                alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
                return;
            }
            AlaMasterLiveRoomOpearator.this.bhC().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.bhC().d((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void blU() {
            AlaMasterLiveRoomOpearator.this.jo(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public boolean blV() {
            if (AlaMasterLiveRoomOpearator.this.eYT == null || AlaMasterLiveRoomOpearator.this.eYT.getView() == null || AlaMasterLiveRoomOpearator.this.eYT.getView().getParent() == null) {
                return false;
            }
            AlaMasterLiveRoomOpearator.this.bhC().rootView.removeView(AlaMasterLiveRoomOpearator.this.eYT.getView());
            return true;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void blW() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void blX() {
            n.k(AlaMasterLiveRoomOpearator.this.eOH.pageContext.getPageActivity(), "", "");
        }
    };
    private b.a eZQ = new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void biX() {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bhC().eUG);
            if (AlaMasterLiveRoomOpearator.this.eYJ == null || AlaMasterLiveRoomOpearator.this.eYJ.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.qc(0);
            }
            if (AlaMasterLiveRoomOpearator.this.eYT != null && AlaMasterLiveRoomOpearator.this.eYT.getView() != null && AlaMasterLiveRoomOpearator.this.eYT.getView().getParent() != null) {
                AlaMasterLiveRoomOpearator.this.bhC().rootView.removeView(AlaMasterLiveRoomOpearator.this.eYT.getView());
            }
            if (AlaMasterLiveRoomOpearator.this.eMy != null) {
                AlaMasterLiveRoomOpearator.this.eMy.uv().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.eMy.uw().hide();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void onBlurLevelSelected(int i) {
            if (AlaMasterLiveRoomOpearator.this.bhC().eUY != null) {
                AlaMasterLiveRoomOpearator.this.bhC().eUY.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void onFilterSelected(String str) {
            if (AlaMasterLiveRoomOpearator.this.bhC().eUY != null) {
                AlaMasterLiveRoomOpearator.this.bhC().eUY.onFilterSelected(str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void bm(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.bhC().eUY != null) {
                AlaMasterLiveRoomOpearator.this.bhC().eUY.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void bn(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.bhC().eUY != null) {
                AlaMasterLiveRoomOpearator.this.bhC().eUY.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void bo(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.bhC().eUY != null) {
                AlaMasterLiveRoomOpearator.this.bhC().eUY.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void bp(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.bhC().eUY != null) {
                AlaMasterLiveRoomOpearator.this.bhC().eUY.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private AlaLiveView.c eZR = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
        boolean isShow = true;

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void bgm() {
            if (AlaMasterLiveRoomOpearator.this.eYO != null) {
                AlaMasterLiveRoomOpearator.this.eYO.jE(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void iD(boolean z) {
            if (this.isShow != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.eZB != null) {
                        AlaMasterLiveRoomOpearator.this.eZB.d(AlaMasterLiveRoomOpearator.this.eOP);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.eZB != null) {
                    AlaMasterLiveRoomOpearator.this.eZB.bhF();
                }
                if (AlaMasterLiveRoomOpearator.this.eYO != null) {
                    AlaMasterLiveRoomOpearator.this.eYO.jE(z);
                }
                this.isShow = z;
            }
        }
    };
    private AlaLiveFaceVerifyView.a eZS = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.eYV != null && AlaMasterLiveRoomOpearator.this.bhC().rootView.indexOfChild(AlaMasterLiveRoomOpearator.this.eYV) >= 0) {
                AlaMasterLiveRoomOpearator.this.bhC().rootView.removeView(AlaMasterLiveRoomOpearator.this.eYV);
                AlaMasterLiveRoomOpearator.this.eYV.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.eYV = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b eMc = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void m(View view, int i) {
            k wf;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.blK();
            } else if (i == 14 && (wf = AlaMasterLiveRoomOpearator.this.bhC().eUF.wf()) != null && wf.VP != null && wf.mLiveInfo != null && wf.Wc != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity(), wf.VP.userName, Long.toString(wf.VP.userId), Long.toString(wf.VP.charmCount), String.valueOf(wf.mLiveInfo.group_id), String.valueOf(wf.mLiveInfo.live_id), true, String.valueOf(wf.VP.userId), Long.toString(wf.Wc.userId), wf.Wc.userName, wf.Wc.portrait, AlaMasterLiveRoomOpearator.this.eLE.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(wf.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.eLE.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener eZT = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.eZC = ((HasGoodsAuthResponseMessage) httpResponsedMessage).faS;
            }
        }
    };
    private HttpMessageListener eZU = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.eZf.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.eZf.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.eZf.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.eZf.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.arQ = getVideoGoodsListHttpResponseMessage.arQ;
            }
        }
    };
    private HttpMessageListener eZV = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.arL != null && !eventPollingHttpResponseMessage.arL.isEmpty() && AlaMasterLiveRoomOpearator.this.bhC().eUF != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.VM;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.arL.size()) {
                            break;
                        }
                        aa aaVar = eventPollingHttpResponseMessage.arL.get(i2);
                        if (j == aaVar.liveId && j2 - aaVar.createTime <= 60 && !com.baidu.live.utils.m.g(aaVar.liveId, aaVar.id)) {
                            com.baidu.live.utils.m.a(aaVar, AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo);
                            com.baidu.live.utils.m.h(aaVar.liveId, aaVar.id);
                        }
                        i = i2 + 1;
                    }
                    aa aaVar2 = eventPollingHttpResponseMessage.arL.get(eventPollingHttpResponseMessage.arL.size() - 1);
                    if (j == aaVar2.liveId) {
                        com.baidu.live.utils.m.f(aaVar2.liveId, aaVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.arK;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.bhC().eUF != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                com.baidu.live.utils.m.i(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.Ty);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        eYG = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(k kVar) {
        if (kVar != null && kVar.mLiveInfo != null && com.baidu.live.r.a.wA().arE != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaGuardThroneActivityConfig(bhC().pageContext.getPageActivity(), String.valueOf(kVar.mLiveInfo.live_id), String.valueOf(kVar.mLiveInfo.user_id), com.baidu.live.r.a.wA().arE.YP, 1, true)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yn(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bhC().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(bhC().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.r.a.wA().arE.Yn;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? bhC().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : bhC().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(bhC().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.eZB != null) {
            this.eZB.onPKPlayerFirstFrame();
        }
    }

    /* loaded from: classes2.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.eZo = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.eZo = false;
                }
                if (AlaMasterLiveRoomOpearator.this.eZp == 0) {
                    AlaMasterLiveRoomOpearator.this.eZp = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.eZq == 0) {
                    AlaMasterLiveRoomOpearator.this.eZq = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
                }
                AlaMasterLiveRoomOpearator.this.eZr = intent.getIntExtra(ComboPraiseProvider.RES_KEY_PREFIX_PRAISE_LEVEL, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (bhC() != null && bhC().eUZ != null) {
            bhC().eUZ.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(e eVar) {
        this.eOH = eVar;
    }

    protected e bhC() {
        return this.eOH;
    }

    public int a(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.eOQ = fVar;
        this.eZn = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.eZn, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.eYQ == null) {
            this.eYQ = new com.baidu.tieba.ala.liveroom.tippop.a(this.eOH.pageContext, null);
        }
        registerListener();
        blm();
        Long[] lArr = new Long[1];
        this.eZs = lArr[0] == null ? 0L : lArr[0].longValue();
        this.eZt = lArr[0] != null ? lArr[0].longValue() : 0L;
        bhC().eUG.setOnTouchListener(this.eZO);
        this.eYH = SharedPrefHelper.getInstance().getBoolean(eYG, false);
        this.eYR = new AlaLiveCountDownView(bhC().pageContext.getPageActivity());
        this.eYR.setCount(3);
        this.eYR.setTextColor(bhC().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.eYR.setTextSize(bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.eYR.setTypeface(Typeface.DEFAULT_BOLD);
        this.eYR.setIncludeFontPadding(false);
        this.eYR.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void blY() {
                if (AlaMasterLiveRoomOpearator.this.bhC().eUG != null) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUG.removeView(AlaMasterLiveRoomOpearator.this.eYR);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkY() {
        if (this.eZk == null) {
            this.eZk = new com.baidu.tieba.ala.liveroom.master.panel.b(bhC().pageContext.getPageActivity(), bhC().bjk() == 2);
            this.eZk.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUY.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jq(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUY.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void jr(boolean z) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUY.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.blJ();
                    if (AlaMasterLiveRoomOpearator.this.eYQ != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.eYQ.a(AlaMasterLiveRoomOpearator.this.bhC().rootView, AlaMasterLiveRoomOpearator.this.bhC().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.eYQ.a(AlaMasterLiveRoomOpearator.this.bhC().rootView, AlaMasterLiveRoomOpearator.this.bhC().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void js(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.f(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void blZ() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.bhC().eUF != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.a(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bma() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.e(AlaMasterLiveRoomOpearator.this.bhC().pageContext.getPageActivity())));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bmb() {
                    if (AlaMasterLiveRoomOpearator.this.bhC() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaMasterLiveRoomOpearator.this.bhC().pageContext, String.valueOf(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.live_id), String.valueOf(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.room_id))));
                        if (AlaMasterLiveRoomOpearator.this.eZk != null) {
                            AlaMasterLiveRoomOpearator.this.eZk.dismiss();
                        }
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void bmc() {
                    long j = (AlaMasterLiveRoomOpearator.this.bhC() == null || AlaMasterLiveRoomOpearator.this.bhC().eUF == null || AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() == null || AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo == null) ? 0L : AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.live_id;
                    if (j == 0) {
                        AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AlaMasterLiveRoomOpearator.this.bhC() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo != null) {
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.k(AlaMasterLiveRoomOpearator.this.eOH.pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.live_id)));
                                    if (AlaMasterLiveRoomOpearator.this.eZk != null) {
                                        AlaMasterLiveRoomOpearator.this.eZk.dismiss();
                                    }
                                }
                            }
                        }, 2000L);
                        return;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.k(AlaMasterLiveRoomOpearator.this.eOH.pageContext.getPageActivity(), j)));
                    if (AlaMasterLiveRoomOpearator.this.eZk != null) {
                        AlaMasterLiveRoomOpearator.this.eZk.dismiss();
                    }
                }
            });
        }
        bkZ();
    }

    private void bkZ() {
        if (this.eZk != null) {
            boolean isBackCamera = bhC().eUY.isBackCamera();
            this.eZk.jt(bhC().eUY.isBackCamera());
            this.eZk.D(bhC().eUY.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = bhC().eUY.isPushMirror();
            if (this.eZx) {
                isPushMirror = blI() || isPushMirror;
                this.eZx = false;
            }
            this.eZk.E(isPushMirror, isBackCamera ? false : true);
            this.eZk.ju(bhC().eUY.isMute());
            this.eZk.bmh();
        }
    }

    public void bla() {
        if (this.eOQ != null) {
            if (this.eOQ.eVc == null || this.eOQ.eVc.mLiveInfo == null) {
                if (this.eYJ == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (bhC().eUF != null && bhC().eUF.wf() != null && bhC().eUF.wf().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", bhC().eUF.wf().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", bhC().eUF.wf().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.eYJ = new d(bhC().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    bhC().eVa.prepareTime = System.currentTimeMillis();
                    bhC().rootView.addView(this.eYJ.getView(), layoutParams);
                    this.eYJ.a(this.eZN);
                }
                this.eYJ.jb(this.eUV);
                this.eYJ.a(this.eZP);
                this.eYJ.a(this.eZL);
                this.eYJ.a(bhC().eUY, bhC().bjk());
                return;
            }
            this.eYq = this.eOQ.eVc.mLiveInfo.screen_direction == 2;
            if (this.eOQ.eVc.mLiveInfo.isAudioOnPrivate == 1) {
                bhC().eUY.setMute(true);
                if (this.eYQ == null) {
                    this.eYQ = new com.baidu.tieba.ala.liveroom.tippop.a(this.eOH.pageContext, null);
                }
                if (!this.eYQ.qq(2)) {
                    this.eYQ.a(bhC().rootView, bhC().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.eUS = true;
            dVar.forumId = String.valueOf(this.eOQ.eVc.mLiveInfo.forum_id);
            dVar.forumName = this.eOQ.eVc.mLiveInfo.forum_name;
            dVar.liveType = this.eOQ.eVc.mLiveInfo.live_type;
            dVar.title = this.eOQ.eVc.mLiveInfo.getLiveTitle();
            dVar.clarity = this.eOQ.eVc.mLiveInfo.clarity;
            dVar.gameId = this.eOQ.eVc.mLiveInfo.game_id;
            dVar.gameName = this.eOQ.eVc.mLiveInfo.game_label;
            dVar.eUW = this.eOQ.eVc.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void blb() {
        if (this.eZz != null) {
            this.eZz.a(bhC().eUY.getVideoConfig());
            blp();
        }
        if (this.eYJ != null) {
            this.eYJ.ja(true);
        }
        if (bhC().eUY.hasBeauty() >= 0) {
            bhC().eUY.setBeauty(com.baidu.live.c.oI().getInt("live_beauty_level", 3));
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.d dVar) {
        bls();
        blH();
        if (bhC().bjk() == 2) {
            this.eZb.setVisibility(8);
            if (this.eYO != null) {
                this.eYO.jE(false);
            }
            if (this.eMy != null && this.eMy.uv() != null) {
                this.eMy.uv().setNeedTopAlphaShade(false);
                return;
            }
            return;
        }
        this.eYO = new com.baidu.tieba.ala.liveroom.u.a(bhC().pageContext, this.eZM);
        this.eYO.d(bhC().eUG, true);
        this.eYO.jE(true);
        bhC().eUY.setPushMirror(blI());
        if (this.eMy != null && this.eMy.uv() != null) {
            this.eMy.uv().setNeedTopAlphaShade(true);
        }
    }

    public void b(g gVar) {
        boolean z;
        int startPush;
        if (!bhC().eUY.isBackground() && bhC().eUF.wf() != null && bhC().eUF.wf().mLiveInfo != null && (startPush = bhC().eUY.startPush(bhC().eUF.wf().mLiveInfo.getPushUrl())) != 0 && bhC().eVa != null) {
            bhC().eVa.errCode = 4;
            bhC().eVa.errSubReason = startPush;
        }
        if (gVar != null && !gVar.bjp() && !blF()) {
            jp(true);
            blG();
        }
        if (this.eYL != null) {
            this.eYL.j(bhC().eUF.wf());
        }
        if (this.eLA != null) {
            this.eLA.n(bhC().eUF.wf());
        }
        if (this.eMm != null) {
            this.eMm.a(bhC().eUF.wf());
        }
        if (this.eYM != null && bhC() != null && bhC().eUF != null) {
            if (this.eYM.aa(bhC().eUG)) {
                this.eYM.h(bhC().eUF.wf());
            } else {
                this.eYM.b(bhC().eUG, bhC().eUF.wf());
            }
        }
        if (this.eYK != null) {
            this.eYK.n(bhC().eUF.wf());
        }
        if (gVar == null || gVar.VP == null) {
            z = com.baidu.live.c.oI().getBoolean("ala_master_can_use_challenge", false);
        } else {
            z = gVar.VP.canUseChallenge;
            com.baidu.live.c.oI().putBoolean("ala_master_can_use_challenge", z);
        }
        blt();
        ble();
        jm(z);
        e(bhC().eUF.wf());
        bly();
        bgv();
        bgH();
        o(bhC().eUF.wf());
        blz();
        blA();
        blw();
        bgD();
        if (this.eMx != null) {
            this.eMx.f(bhC().eUF.wf());
        }
        if (this.eMy != null) {
            this.eMy.e(String.valueOf(bhC().eUF.wf().mLiveInfo.group_id), String.valueOf(bhC().eUF.wf().mLiveInfo.last_msg_id), String.valueOf(bhC().eUF.wf().VP.userId), String.valueOf(bhC().eUF.wf().mLiveInfo.live_id), bhC().eUF.wf().VP.appId);
        }
        if (this.eMz != null) {
            this.eMz.a(bhC().eUF.wf(), true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
            com.baidu.live.utils.m.i(bhC().eUF.wf().mLiveInfo.user_id, bhC().eUF.wf().mLiveInfo.live_id);
        }
    }

    private void jm(boolean z) {
        if (this.eZB == null) {
            this.eZB = new com.baidu.tieba.ala.liveroom.challenge.f(bhC());
        }
        this.eZB.a(this.eOP, this.eOQ);
        this.eZB.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(y yVar, z zVar, z zVar2) {
                if (AlaMasterLiveRoomOpearator.this.eMq != null) {
                    AlaMasterLiveRoomOpearator.this.eMq.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.bhC().eUG.fgV = false;
                AlaMasterLiveRoomOpearator.this.blc();
                if (AlaMasterLiveRoomOpearator.this.eMS != null) {
                    AlaMasterLiveRoomOpearator.this.eMS.b(AlaMasterLiveRoomOpearator.this.jn(true));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void oZ() {
                if (AlaMasterLiveRoomOpearator.this.eLG != null) {
                    AlaMasterLiveRoomOpearator.this.eLG.iu(true);
                    AlaMasterLiveRoomOpearator.this.eLG.setVisible(8);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bhA() {
                if (AlaMasterLiveRoomOpearator.this.eMq != null) {
                    AlaMasterLiveRoomOpearator.this.eMq.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.bhC().eUG.fgV = true;
                AlaMasterLiveRoomOpearator.this.bld();
                if (AlaMasterLiveRoomOpearator.this.eMS != null) {
                    AlaMasterLiveRoomOpearator.this.eMS.b(AlaMasterLiveRoomOpearator.this.jn(false));
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void bhB() {
            }
        });
        this.eZB.B(this.eYq, z);
        this.eZB.h(this.eYq, z, (this.eOQ == null || this.eOQ.eVc == null || this.eOQ.eVc.mChallengeData == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blc() {
        if (this.eYP != null) {
            this.eYP.setVisible(8);
            this.eYP.setCanVisible(false);
        }
        if (this.eLG != null) {
            this.eLG.iu(true);
            this.eLG.setVisible(8);
        }
        if (this.eYS != null) {
            this.eYS.setCanVisible(false);
            this.eYS.setVisibility(4);
        }
        if (this.eYO != null) {
            this.eYO.jD(false);
        }
        if (this.eMy != null) {
            this.eMy.uv().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bld() {
        if (this.eYP != null) {
            this.eYP.setCanVisible(true);
        }
        if (this.eLG != null) {
            this.eLG.iu(false);
            this.eLG.setVisible(0);
        }
        if (this.eYS != null) {
            this.eYS.setCanVisible(true);
        }
        if (this.eYO != null) {
            this.eYO.jD(true);
        }
        if (this.eMy != null) {
            this.eMy.uv().setNeedTopAlphaShade(false);
        }
    }

    private void ble() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.eYS == null) {
            this.eYS = new AlaLiveStreamStatusView(bhC().pageContext.getPageActivity());
        }
        this.eYS.setId(a.g.ala_live_room_stream_view);
        this.eYS.setVisibility(4);
        this.eYS.setLayoutParams(layoutParams);
        if (this.eYS.getParent() == null) {
            bhC().eUG.addView(this.eYS, layoutParams);
        }
    }

    public void blf() {
        if (this.eYJ != null && this.eYJ.getVisibility() != 8 && bhC().eUY.getPreview() != null) {
            bhC().eUY.stopRecord();
        }
    }

    public void blg() {
        if (bhC().eUY.getPreview() != null) {
            bhC().eUY.stopRecord();
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.eZz != null) {
                this.eZz.iZ(false);
            }
            this.eZz = new com.baidu.tieba.ala.liveroom.g.b(bhC().rootView, bhC().pageContext.getPageActivity());
            this.eZz.setOnEffectSelectedListener(this.eZQ);
            this.eZz.a(bhC().eUY.getVideoConfig());
            blp();
            if (i3 == 2 || i3 == 1) {
            }
        }
        if (this.eYQ != null) {
            this.eYQ.bnS();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.eYI = z;
        if (z) {
            Rect rect = new Rect();
            bhC().eUG.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            bhC().eUG.getGlobalVisibleRect(rect2);
            if (this.eMy != null && this.eMy.uv() != null) {
                this.eMy.uv().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eMy.uv().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.eMy.uv().getView().setLayoutParams(layoutParams);
            }
            if (this.eMy != null && this.eMy.uw() != null) {
                int i = rect2.bottom - rect.bottom;
                this.eMy.uw().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eMy.uw().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.eMy.uw().getView().setLayoutParams(layoutParams2);
                this.eMy.uw().getView().setVisibility(0);
            }
            qc(8);
            qb(8);
        } else {
            if (this.eMy != null && this.eMy.uv() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.eMy.uv().getView().getLayoutParams();
                layoutParams3.bottomMargin = bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.eMy.uv().getView().setLayoutParams(layoutParams3);
            }
            if (this.eMy != null && this.eMy.uw() != null) {
                this.eMy.uw().hide();
            }
            qc(0);
            qb(0);
        }
        if (this.eYJ != null) {
            this.eYJ.C(false, z);
        }
        if (this.eMz != null) {
            this.eMz.uD();
        }
        if (this.eMy != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(bhC().pageContext.getPageActivity())) + bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (bhC().eUG.indexOfChild(this.eMy.uv().getView()) != -1 && this.eMy.uv().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.eMy.uv().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.eMy.uv().getView().setLayoutParams(layoutParams4);
            }
            this.eMy.uv().uu();
        }
    }

    private void qb(int i) {
        if (this.eLA != null) {
            this.eLA.pO(i);
        }
        if (this.eYk != null) {
            this.eYk.setVisibility(i);
        }
        if (this.eMm != null) {
            this.eMm.getView().setVisibility(i);
        }
        if (this.eYN != null) {
            this.eYN.setVisible(i);
        }
        if (this.eYM != null) {
            this.eYM.setVisibility(i);
        }
        if (this.eLG != null) {
            this.eLG.setVisible(i);
        }
        if (this.eMS != null) {
            this.eMS.setCanVisible(i == 0);
        }
        if (this.eMJ != null) {
            this.eMJ.setVisible(i);
        }
        if (this.eMQ != null) {
            this.eMQ.setCanVisible(i == 0);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            bhC().eVa.errCode = 1;
            blB();
        } else if (i == -5) {
            blC();
        } else if (i == -2) {
            yD(bhC().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            bhC().eUY.stopRecord();
        } else if (i == -3 && this.eYJ != null) {
            this.eYJ.ja(false);
        }
        if (i == -4) {
            if (this.eYJ == null || this.eYJ.getView().getParent() == null) {
                bhC().d((short) 1);
                return;
            }
            this.eYJ.bje();
            this.eZb.setVisibility(0);
            if (this.eYO != null) {
                this.eYO.jE(true);
            }
            bhC().eUG.setBackgroundColor(bhC().pageContext.getResources().getColor(17170445));
            blO();
        } else if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        bgV();
        if (i == 12001) {
            if (i2 == -1) {
                yE(ac(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                ad(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aFs();
        }
    }

    public void onResume() {
        if (this.eYJ != null) {
            this.eYJ.onResume();
        }
        if (this.eZm && this.eZl != null) {
            this.eZm = false;
            c(this.eZl);
        }
    }

    public void e(short s) {
        if (this.eMx != null) {
            this.eMx.th();
        }
        if (this.eMy != null) {
            this.eMy.a(null);
            this.eMy.ub();
        }
        if (this.eMz != null) {
            this.eMz.ub();
        }
        if (this.eZB != null) {
            this.eZB.bhG();
        }
    }

    public boolean blh() {
        k wf = bhC().eUF.wf();
        if (this.eMm != null) {
            this.eMm.a(bhC().eUF.wf());
        }
        if (this.eMy != null) {
            this.eMy.uv().a(String.valueOf(wf.mLiveInfo.group_id), String.valueOf(wf.mLiveInfo.live_id), true, String.valueOf(wf.VP.userId));
        }
        if (this.eMz != null) {
            this.eMz.a(wf);
        }
        if (this.eLA != null) {
            this.eLA.n(wf);
        }
        if (wf != null) {
            if (this.eYL != null) {
                this.eYL.j(wf);
            }
            if (this.eZB != null) {
                this.eZB.a(wf);
            }
            if (this.eMB != null && wf.mLiveInfo != null) {
                this.eMB.a(wf.mLiveInfo);
            }
            if (this.eLG != null) {
                this.eLG.g(wf);
            }
            if (this.eMS != null) {
                this.eMS.a(wf);
            }
            if (this.eMQ != null) {
                this.eMQ.a(wf);
            }
            if (wf.mLiveInfo.live_status != 1) {
                blM();
                bhC().pageContext.getPageActivity().finish();
                if (bhC().eUF != null && bhC().eUF.wf() != null) {
                    String str = null;
                    if (bhC().eUF.bnb() != 1) {
                        str = bhC().pageContext.getString(a.i.ala_live_end_authen_msg);
                    }
                    a(wf.mLiveInfo, 1, str);
                }
                return true;
            } else if (this.eZC) {
                this.eZd.setVisibility(0);
                if (this.eZA || wf.mLiveInfo == null) {
                    return false;
                }
                this.eZA = true;
                n.g(wf.mLiveInfo.feed_id, wf.mLiveInfo.live_id);
                return false;
            } else {
                this.eZd.setVisibility(8);
                return false;
            }
        }
        return false;
    }

    public void bli() {
        bkZ();
    }

    public void blj() {
        if (this.eZz != null) {
            this.eZz.biW();
        }
    }

    public void blk() {
        if (this.eYJ != null && this.eYJ.getVisibility() != 8) {
            if (bhC().bjk() == 2) {
                blO();
            } else {
                blN();
            }
        }
        if (this.eYJ != null && this.eYJ.getVisibility() != 8) {
            if (bhC().bjk() == 1) {
                this.eYJ.onResume();
            }
            this.eYJ.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.eMY && this.eZi != null) {
            if (this.eYT != null && this.eYT.getView() != null && this.eYT.getView().getParent() != null) {
                bhC().rootView.removeView(this.eYT.getView());
                if (this.eMy != null) {
                    this.eMy.uv().getView().setVisibility(0);
                }
            }
            if (this.eMy != null) {
                this.eMy.uw().show();
                this.eMy.uw().setEditText(" @" + this.eZi.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            qc(8);
            this.eMY = false;
        }
        if (this.eMI != null) {
            this.eMI.resume();
        }
        if (this.eZE != null) {
            this.eZE.resume();
        }
    }

    public void onPause() {
        if (this.eMI != null) {
            this.eMI.pause();
        }
        if (this.eZE != null) {
            this.eZE.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bll() {
        bhC().eUG.scrollOrigin();
    }

    private void blm() {
        this.eYU = (RelativeLayout) bhC().rootView.findViewById(a.g.ala_live_unremovable_host_top);
        this.eYk = (RelativeLayout) bhC().rootView.findViewById(a.g.ala_live_removeable_top_container);
        this.eOH.eUG.setOnLiveViewScrollListener(this.eZR);
        if (this.eLE == null) {
            this.eLE = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.eOH.pageContext.getPageActivity(), false);
        }
        this.eLE.a(this.eMc);
        this.eLE.a(this.eYk, a.g.ala_live_room_host_header_stub, 1L);
        this.eLE.setVisible(0);
        this.eYW = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_host_close);
        this.eYW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.blK();
            }
        });
        this.eZg = (FrameLayout) bhC().rootView.findViewById(a.g.ala_liveroom_host_pure_back_btn_layout);
        this.eZh = (FrameLayout) bhC().rootView.findViewById(a.g.ala_liveroom_host_close_btn_layout);
        this.eYX = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_pure_mode_back);
        this.eYX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.bll();
            }
        });
        this.eZb = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.eZb.setOnClickListener(this.eZH);
        if (bhC().eUY.hasBeauty() < 0) {
            this.eZb.setVisibility(8);
        } else {
            this.eYT = new com.baidu.tieba.ala.liveroom.views.b(bhC().pageContext.getPageActivity(), com.baidu.live.c.oI().getInt("live_beauty_level", 3));
            this.eYT.a(this.eZK);
        }
        this.eZa = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_host_share_btn);
        this.eZa.setOnClickListener(this.eZH);
        this.eYY = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_host_message_btn);
        this.eYY.setOnClickListener(this.eZH);
        this.eOP = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.eOP.setOnClickListener(this.eZH);
        this.eYZ = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_host_more);
        this.eYZ.setOnClickListener(this.eZH);
        this.eZc = (ImageView) bhC().rootView.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.eZc.setOnClickListener(this.eZH);
        this.eZd = bhC().rootView.findViewById(a.g.host_goods_layout);
        this.eZe = (ImageView) bhC().rootView.findViewById(a.g.host_goods_imageView);
        this.eZf = (TextView) bhC().rootView.findViewById(a.g.host_goods_num_textView);
        this.eZe.setOnClickListener(this.eZH);
        blr();
        blq();
        this.eZz = new com.baidu.tieba.ala.liveroom.g.b(bhC().rootView, bhC().pageContext.getPageActivity());
        this.eZz.setOnEffectSelectedListener(this.eZQ);
        this.eMx = new m();
        bln();
        blo();
        if (this.eMA != null && this.eMA.qX() != null) {
            this.eMA.qX().bringToFront();
        }
    }

    private void bln() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, bhC().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.eMy = (i) runTask.getData();
            this.eMy.setFromMaster(true);
            this.eMy.uv().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(bhC().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(bhC().pageContext.getPageActivity()) * 0.27f)) + bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            bhC().eUG.addView(this.eMy.uv().getView(), layoutParams);
            this.eMy.uw().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            bhC().eUG.addView(this.eMy.uw().getView(), layoutParams2);
            this.eMy.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
                @Override // com.baidu.live.im.i.a
                public boolean ux() {
                    return true;
                }

                @Override // com.baidu.live.im.i.a
                public void uy() {
                }

                @Override // com.baidu.live.im.i.a
                public void dz(String str) {
                }

                @Override // com.baidu.live.im.i.a
                public void uz() {
                }

                @Override // com.baidu.live.im.i.a
                public void uA() {
                }

                @Override // com.baidu.live.im.i.a
                public boolean uB() {
                    return false;
                }
            });
        }
    }

    private void blo() {
        this.eMz = new com.baidu.tieba.ala.liveroom.d.a(bhC().pageContext);
        View uC = this.eMz.uC();
        if (uC != null && this.eOH.eUG.indexOfChild(uC) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.eOH.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = bhC().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            bhC().eUG.addView(uC, layoutParams);
        }
    }

    private void blp() {
        if (bhC().eUY != null) {
            com.baidu.tieba.ala.liveroom.data.c cVar = new com.baidu.tieba.ala.liveroom.data.c();
            cVar.yx(com.baidu.live.c.oI().getString("ala_beauty_5.4_config_str", ""));
            bhC().eUY.onBlurLevelSelected(cVar.eUP);
            bhC().eUY.onFilterSelected(cVar.mFilterName);
            bhC().eUY.onColorLevelSelected((cVar.eUN * 1.0f) / 100.0f);
            bhC().eUY.onCheekThinSelected((cVar.eUR * 1.0f) / 100.0f);
            bhC().eUY.onEnlargeEyeSelected((cVar.eUQ * 1.0f) / 100.0f);
            bhC().eUY.onRedLevelSelected((cVar.eUO * 1.0f) / 100.0f);
        }
    }

    private void blq() {
        CustomResponsedMessage runTask;
        if (this.eZj == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.s.a.class, bhC().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eZj = (com.baidu.live.s.a) runTask.getData();
        }
    }

    private void blr() {
        View qX;
        s.b(bhC().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.adq = true;
        fVar.context = bhC().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, t.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.eMA = (t) runTask.getData();
            if (this.eMA != null && (qX = this.eMA.qX()) != null && bhC().eUG.indexOfChild(qX) < 0) {
                if (qX.getParent() instanceof ViewGroup) {
                    ((ViewGroup) qX.getParent()).removeView(qX);
                }
                bhC().eUG.addView(qX, bhC().eUG.getLayoutParams());
            }
        }
    }

    protected void bgD() {
        View rp;
        if (this.eMB == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.adq = true;
            aVar.context = bhC().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, r.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.eMB = (r) runTask.getData();
            }
        }
        if (this.eMB != null && (rp = this.eMB.rp()) != null) {
            if (bhC().eUG.indexOfChild(rp) < 0) {
                if (rp.getParent() instanceof ViewGroup) {
                    ((ViewGroup) rp.getParent()).removeView(rp);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds212);
                bhC().eUG.addView(rp, layoutParams);
            }
            rp.bringToFront();
        }
    }

    private void bls() {
        blv();
        bfJ();
        blu();
        bhC().eUG.setVisibility(0);
        qc(0);
    }

    private void blt() {
        if (this.eYN == null) {
            this.eYN = new com.baidu.tieba.ala.liveroom.r.a(bhC().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.eYN.a(bhC().bjk(), j, TbadkCoreApplication.getCurrentAccountName(), true, bhC().eUF.wf().VP.portrait, this.otherParams, "", -1L);
        this.eYN.Z(bhC().eUG);
    }

    private void blu() {
        if (this.eYP == null) {
            this.eYP = new b(bhC().pageContext, bhC().eUG);
        }
    }

    private void blv() {
        if (this.eLA == null) {
            this.eLA = new com.baidu.tieba.ala.liveroom.l.a(bhC().pageContext, true, this.eZM);
            this.eLA.d(this.eYU, null);
            this.eLA.a(this.eMc);
        }
        if (this.eYK == null) {
            this.eYK = new com.baidu.tieba.ala.liveroom.l.a(bhC().pageContext, true, null);
            this.eYK.a(this.eYk, null, a.g.ala_live_room_host_header_stub);
            this.eYK.bks();
        }
    }

    protected void bgp() {
        CustomResponsedMessage runTask;
        boolean z = false;
        g bmR = bhC().eUF.bmR();
        boolean z2 = com.baidu.live.r.a.wA().arE.YO;
        if (bmR == null || bmR.Wl) {
            z = z2;
        }
        if (z && this.eMm == null && (runTask = MessageManager.getInstance().runTask(2913146, com.baidu.live.g.a.class, bhC().pageContext)) != null) {
            this.eMm = (com.baidu.live.g.a) runTask.getData();
            if (this.eMm != null) {
                this.eMm.setIsHost(true);
                this.eMm.bJ(1);
                View view = this.eMm.getView();
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    view.setId(a.g.ala_liveroom_guardthrone);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.leftMargin = BdUtilHelper.dip2px(bhC().pageContext.getPageActivity(), 4.0f);
                    layoutParams.rightMargin = BdUtilHelper.dip2px(bhC().pageContext.getPageActivity(), -5.0f);
                    layoutParams.addRule(8, a.g.ala_live_room_host_header_stub);
                    layoutParams.addRule(1, a.g.ala_live_room_host_header_stub);
                    this.eYk.addView(view, layoutParams);
                }
            }
        }
    }

    private void e(k kVar) {
        if (this.eLG == null) {
            this.eLG = new com.baidu.tieba.ala.liveroom.activeview.b(bhC().pageContext);
        }
        this.eLG.setOtherParams(this.otherParams);
        this.eLG.b(kVar, false);
        this.eLG.setHost(true);
        this.eLG.a(1, bhC().eUG, pH(1));
        this.eLG.a(2, bhC().eUG, pH(2));
        this.eLG.setVisible(this.eYI ? 8 : 0);
    }

    private void o(k kVar) {
        CustomResponsedMessage runTask;
        if (this.eMS == null && (runTask = MessageManager.getInstance().runTask(2913130, i.class, bhC().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.m.a)) {
            this.eMS = (com.baidu.live.m.a) runTask.getData();
            if (this.eMS != null) {
                this.eMS.a(bhC().eUG, jn(false));
            }
        }
        if (this.eMS != null) {
            this.eMS.a(kVar);
            this.eMS.setCanVisible(!this.eYI);
        }
    }

    protected void blw() {
        CustomResponsedMessage runTask;
        if (bhC() != null && (runTask = MessageManager.getInstance().runTask(2913144, com.baidu.live.h.a.class, bhC().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eMQ = (com.baidu.live.h.a) runTask.getData();
            this.eMQ.a(bhC().eUG, blx());
            if (bhC().eUF != null) {
                this.eMQ.a(bhC().eUF.wf());
            }
            this.eMQ.setCanVisible(true);
            this.eMQ.aK(false);
            this.eMQ.a(bhC().eUF.bbm());
        }
    }

    private ViewGroup.LayoutParams blx() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (UtilHelper.getRealScreenOrientation(bhC().pageContext.getPageActivity()) == 1) {
            layoutParams.addRule(9);
            layoutParams.addRule(5, a.g.ala_live_room_stream_view);
            layoutParams.leftMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
        } else {
            layoutParams.addRule(5, a.g.ala_liveroom_charmview);
        }
        if (this.eYS != null) {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.guard_club_entry_id);
            layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private ViewGroup.LayoutParams pH(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(bhC().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.eYS != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(bhC().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ViewGroup.LayoutParams jn(boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.rightMargin = bhC().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds6);
        if (z && this.eZB != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(3);
            } else {
                layoutParams.addRule(3, 0);
            }
            layoutParams.topMargin = this.eZB.ar(true) + bhC().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else if (this.eYS != null) {
            layoutParams.addRule(3, a.g.ala_live_room_stream_view);
            layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        } else {
            layoutParams.addRule(3, a.g.ala_liveroom_charmview);
            layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        }
        return layoutParams;
    }

    private void bfJ() {
        if (this.eYM == null) {
            this.eYM = new com.baidu.tieba.ala.liveroom.b.a(bhC().pageContext, true);
        }
    }

    private void bly() {
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            Activity pageActivity = bhC().pageContext.getPageActivity();
            this.eNU = new ImageView(pageActivity);
            this.eNU.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.eNU.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.eNU.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            bhC().rootView.addView(this.eNU, layoutParams);
            this.eNU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.blK();
                }
            });
            this.eNU.setVisibility(8);
        }
    }

    private void bgv() {
        this.eMI = new com.baidu.tieba.ala.liveroom.f.a(bhC().pageContext);
    }

    private void bgH() {
        if (this.eMJ == null) {
            this.eMJ = new com.baidu.tieba.ala.liveroom.j.a(bhC().pageContext, true, this.otherParams);
        }
        if (bhC().eUF.wf() != null && bhC().eUF.wf().VP != null && bhC().eUF.wf().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.eMJ.a(bhC().eUG, layoutParams, bhC().eUF.wf());
        }
    }

    private void blz() {
        CustomResponsedMessage runTask;
        if (this.eZD == null && (runTask = MessageManager.getInstance().runTask(2913139, com.baidu.live.b.a.class, bhC().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.a)) {
            this.eZD = (com.baidu.live.b.a) runTask.getData();
            if (this.eZD != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
                layoutParams.addRule(11);
                layoutParams.topMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
                layoutParams.rightMargin = bhC().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.eZD.a(bhC().eUG, layoutParams);
            }
        }
        if (this.eZD != null) {
            this.eZD.a(bhC().eUF.wf());
        }
    }

    private void blA() {
        CustomResponsedMessage runTask;
        if (this.eZE == null && (runTask = MessageManager.getInstance().runTask(2913140, com.baidu.live.b.b.class, bhC().pageContext.getPageActivity())) != null && (runTask.getData() instanceof com.baidu.live.b.b)) {
            this.eZE = (com.baidu.live.b.b) runTask.getData();
        }
    }

    public void onRtcConnected(int i) {
        if (this.eZB != null) {
            this.eZB.onRtcConnected(i);
        }
    }

    private void registerListener() {
        bhC().pageContext.registerListener(this.eNn);
        bhC().pageContext.registerListener(this.eZF);
        bhC().pageContext.registerListener(this.eNp);
        bhC().pageContext.registerListener(this.eNq);
        bhC().pageContext.registerListener(this.eZI);
        bhC().pageContext.registerListener(this.eYf);
        bhC().pageContext.registerListener(this.eJz);
        bhC().pageContext.registerListener(this.eZJ);
        bhC().pageContext.registerListener(this.eNo);
        bhC().pageContext.registerListener(this.eNI);
        bhC().pageContext.registerListener(this.eZT);
        bhC().pageContext.registerListener(this.eZU);
        bhC().pageContext.registerListener(this.eZV);
        bhC().pageContext.registerListener(this.eNv);
        bhC().pageContext.registerListener(this.eZG);
        bhC().pageContext.registerListener(this.eNx);
        bhC().pageContext.registerListener(this.eNw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jo(boolean z) {
        BdUtilHelper.hideSoftKeyPad(bhC().pageContext.getPageActivity(), bhC().rootView);
        if (bhC().eUG != null && this.eYT != null && this.eYT.getView() != null && this.eYT.getView().getParent() == null) {
            qc(8);
            if (bhC().eUY.hasAdvancedBeauty()) {
                if (this.eZz != null) {
                    this.eZz.b(bhC().eUY.getVideoConfig());
                }
            } else {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                bhC().rootView.addView(this.eYT.getView(), layoutParams);
            }
            if (z && this.eMy != null) {
                this.eMy.uv().getView().setVisibility(8);
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
            return activity.getResources().getString(a.i.sdk_permission_app_type_tb_text);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blB() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bhC().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(bhC().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bhC().d((short) 1);
            }
        });
        bdAlertDialog.create(bhC().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blC() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bhC().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(bhC().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bhC().d((short) 1);
            }
        });
        bdAlertDialog.create(bhC().pageContext).show();
    }

    private void yD(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bhC().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.bhC().d((short) 1);
            }
        });
        bdAlertDialog.create(bhC().pageContext).show();
    }

    public void blD() {
        bgp();
        com.baidu.live.data.g bbm = bhC().eUF.bbm();
        int i = 5;
        if (bbm != null) {
            i = (int) bbm.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null && AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUF.cP(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo.live_id);
                }
            }
        }, i);
        if (bbm != null) {
            if (this.eLz == null) {
                this.eLz = new c(bhC().pageContext, this.eZM, true);
            }
            if (this.eZy) {
                this.eZy = false;
                this.eLz.a(String.valueOf(bhC().eUF.wf().mLiveInfo.group_id), String.valueOf(bhC().eUF.wf().mLiveInfo.live_id), String.valueOf(bhC().eUF.wf().VP.userId), bhC().eUF.wf());
                int i2 = a.g.ala_live_room_host_header_stub;
                if (this.eMm != null) {
                    i2 = a.g.ala_liveroom_guardthrone;
                }
                this.eLz.c(this.eYk, i2, a.g.ala_liveroom_audience_count_layout);
            }
            this.eLz.f(bbm);
            this.eLE.setVisible(0);
            this.eLE.cv(bbm.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blE() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFs() {
        if (bhC().eUF != null) {
            if (this.eMn == null) {
                this.eMn = new com.baidu.tieba.ala.liveroom.share.c(bhC().pageContext);
            }
            this.eMn.c(bhC().eUF.wf(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (bhC().eUF != null && bhC().eUF.wf() != null && bhC().eUF.wf().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", bhC().eUF.wf().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", bhC().eUF.wf().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", bhC().eUF.wf().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (bhC().eUF != null && bhC().eUF.wf() != null && bhC().eUF.wf().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", bhC().eUF.wf().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", bhC().eUF.wf().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", bhC().eUF.wf().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean blF() {
        return this.eYH;
    }

    private void jp(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(eYG, z);
        this.eYH = z;
    }

    private void blG() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bhC().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.bhC().pageContext).bmB();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bhC().pageContext).show();
    }

    private void blH() {
        if (this.eYq && bhC().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            bhC().eVb.xr();
        }
        bhC().eVa.prepareTime = System.currentTimeMillis() - bhC().eVa.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (bhC().eUF != null && bhC().eUF.wf() != null && bhC().eUF.wf().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", bhC().eUF.wf().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", bhC().eUF.wf().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", bhC().eVa.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.eYJ != null && this.eYJ.getView().getParent() != null) {
            this.eYJ.setVisibility(8);
            bhC().rootView.removeView(this.eYJ.getView());
            this.eYJ.release();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (bhC().eUG.indexOfChild(this.eYR) < 0) {
            bhC().eUG.addView(this.eYR, layoutParams);
        }
        this.eYR.qs(1000);
    }

    private void bgV() {
        if (bhC().bjk() == 1) {
            bhC().eUY.startRecord();
        }
    }

    private void yE(String str) {
        yF(str);
    }

    private void yF(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) bhC().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.eYJ != null) {
            this.eYJ.yw(fromJson.getSmallurl());
        }
    }

    private boolean blI() {
        return com.baidu.live.c.oI().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blJ() {
        com.baidu.live.c.oI().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.eOH.eUY.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blK() {
        int i = a.i.live_close_confirm;
        if (this.eZB != null && this.eZB.bhI()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.eZB != null && this.eZB.bhH()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(bhC().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(i);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomOpearator.this.bhC().eUF.wf() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo, 0, AlaMasterLiveRoomOpearator.this.bhC().eUF.bnb() != 1 ? AlaMasterLiveRoomOpearator.this.bhC().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                } else {
                    AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(bhC().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaLiveInfoData alaLiveInfoData, int i, String str) {
        if (alaLiveInfoData != null) {
            String str2 = alaLiveInfoData.close_reason;
            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                str2 = str;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = "0";
            }
            bhC().eUF.cK(Long.toString(alaLiveInfoData.live_id), str2);
        }
        if (!this.eZw) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = bhC().eVa;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = bhC().eUY.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.eZs;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.eZt;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.eZo;
            if (this.eZp != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.eZq - this.eZr) / this.eZp) * 100.0f;
            }
            Intent intent = new Intent(bhC().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            if (alaLiveInfoData != null) {
                intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            }
            if (bhC().eUF != null && bhC().eUF.wf() != null && bhC().eUF.wf().VP != null) {
                String str3 = bhC().eUF.wf().VP.nickName;
                String str4 = bhC().eUF.wf().VP.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            k wf = bhC().eUF.wf();
            if (wf != null && wf.VP != null && !TextUtils.isEmpty(wf.VP.portrait)) {
                intent.putExtra("host_portrait", wf.VP.portrait);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913129));
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.eZu = intent;
                this.eZv = s;
                bhC().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void blL() {
        if (this.eZu != null) {
            a(this.eZu, this.eZv);
            this.eZu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.eZw = true;
        if (this.eZB != null) {
            this.eZB.onDestroy();
        }
        if (intent != null) {
            bhC().pageContext.getPageActivity().startActivity(intent);
        }
        bhC().d(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void blM() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eZB != null && this.eZB.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (bhC().eUZ.bmp()) {
                blK();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.eYS.setVisibility(4);
            return;
        }
        this.eYS.a(i, z, i2, z2);
        if (this.eOH != null && this.eOH.eUF != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.bQp != i3) {
                this.bQp = i3;
                if (this.eYQ == null) {
                    this.eYQ = new com.baidu.tieba.ala.liveroom.tippop.a(this.eOH.pageContext, null);
                }
                switch (this.bQp) {
                    case 0:
                        this.eYQ.a(this.eOH.rootView, this.eOH.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.eYQ.a(this.eOH.rootView, this.eOH.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.eYQ.a(this.eOH.rootView, this.eOH.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.eOH.eUF.j(this.eOH.eUF.wf().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x03a0, code lost:
        yk(r25);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2;
        long j;
        long j2;
        long j3;
        if (aVar.getMsgType() == 125) {
            if (this.eYO != null) {
                this.eYO.u(aVar);
            }
        } else if (aVar.getMsgType() == 13 || aVar.getMsgType() == 12) {
            final String str2 = null;
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                try {
                    str = jSONObject.optString("content_type");
                    try {
                        str2 = jSONObject.optString("text");
                    } catch (JSONException e) {
                    }
                } catch (JSONException e2) {
                    str = null;
                }
            } catch (JSONException e3) {
                jSONObject = null;
                str = null;
            }
            if (this.eZB != null) {
                this.eZB.cK(str);
            }
            if ("close_live".equals(str)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.blM();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.bhC().eUF.wf().mLiveInfo, 1, str2);
                    }
                });
            } else if ("live_admin".equals(str)) {
                if (bhC().eUF.wf() != null && jSONObject != null) {
                    long optLong = jSONObject.optLong("user_id");
                    int optInt = jSONObject.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bhC().eUF.wf().Wc.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            bhC().eUF.wf().Wc.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        bhC().eUF.wf().Wc.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str)) {
                if (this.eZj != null) {
                    this.eZj.v(jSONObject);
                }
            } else if (!"live_achievement".equals(str)) {
                if ("enter_live".equals(str)) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("share_enter_msg");
                        int optInt2 = jSONObject.optInt("share_enter_interval");
                        if (!TextUtils.isEmpty(optString)) {
                            this.eYP.au(optString, optInt2);
                        }
                        if (this.eLE.getCount() > 20) {
                            this.eLE.cv(this.eLE.getCount() + 1);
                        } else if (this.eLz != null) {
                            com.baidu.live.data.a uZ = aVar.uZ();
                            com.baidu.live.data.f fVar = new com.baidu.live.data.f();
                            fVar.VQ = new AlaLocationData();
                            fVar.VR = new AlaRelationData();
                            fVar.VP = new AlaLiveUserInfoData();
                            fVar.VP.userId = JavaTypesHelper.toLong(uZ.userId, 0L);
                            fVar.VP.userName = uZ.userName;
                            fVar.VP.portrait = uZ.portrait;
                            if (this.eLz.c(fVar)) {
                                this.eLE.cv(this.eLE.getCount() + 1);
                            }
                        }
                    }
                } else if ("ui_event".equals(str)) {
                    if (jSONObject != null && jSONObject.optInt("event_type") == 1001 && bhC().eUF.wf() != null && bhC().eUF.wf().mLiveInfo != null) {
                        String str3 = bhC().eUF.wf().mLiveInfo.feed_id;
                        long j4 = bhC().eUF.wf().mLiveInfo.live_id;
                        long optLong2 = jSONObject.optLong("id");
                        if (!com.baidu.live.utils.m.g(j4, optLong2)) {
                            n.g(str3, j4);
                            com.baidu.live.utils.m.h(j4, optLong2);
                        }
                    }
                } else if ("need_update_live_mark_info".equals(str) && jSONObject != null && bhC() != null && bhC().eUF != null && bhC().eUF.wf() != null && bhC().eUF.wf().Wc != null && bhC().eUF.wf().Wc.userId == jSONObject.optLong("user_id")) {
                    bhC().eUF.bmQ();
                }
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a uZ2 = aVar.uZ();
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject2 = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject2 = new JSONObject(aVar.getContent());
                }
                String optString2 = jSONObject2.optString(LogConfig.LOG_GIFT_ID);
                String optString3 = jSONObject2.optString("gift_count");
                String optString4 = jSONObject2.optString("gift_name");
                String optString5 = jSONObject2.optString("gift_url");
                String optString6 = jSONObject2.optString("attach");
                String optString7 = jSONObject2.optString("attach_new");
                String optString8 = jSONObject2.optString("gift_mul");
                String str4 = null;
                if (bhC().eUF == null || bhC().eUF.wf() == null || bhC().eUF.wf().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                } else {
                    long j5 = bhC().eUF.wf().mLiveInfo.live_id;
                    long j6 = bhC().eUF.wf().mLiveInfo.group_id;
                    long j7 = bhC().eUF.wf().VP.userId;
                    str4 = bhC().eUF.wf().mLiveInfo.appId;
                    j = j7;
                    j2 = j5;
                    j3 = j6;
                }
                if (!this.isBackground || bhC().bjk() != 2) {
                    if (!TextUtils.isEmpty(optString7) && !TextUtils.isEmpty(optString8)) {
                        if (jSONObject2.optInt("flag_show") == 1) {
                            s.b(optString8, uZ2.userId, uZ2.portrait, uZ2.getNameShow(), String.valueOf(j2), String.valueOf(j3), false, String.valueOf(j), str4, optString7);
                            try {
                                JSONArray jSONArray = new JSONArray(optString8);
                                if (jSONArray != null && jSONArray.length() > 0) {
                                    int i = 0;
                                    while (true) {
                                        if (i >= jSONArray.length()) {
                                            break;
                                        }
                                        if (com.baidu.live.r.d.wH().dH(jSONArray.getJSONObject(i).optString(LogConfig.LOG_GIFT_ID))) {
                                            break;
                                        }
                                        i++;
                                    }
                                }
                            } catch (JSONException e4) {
                                e4.printStackTrace();
                            }
                        }
                    } else {
                        s.b(optString2, Integer.parseInt(optString3), optString4, optString5, uZ2.userId, uZ2.portrait, uZ2.getNameShow(), String.valueOf(j2), String.valueOf(j3), true, String.valueOf(j), str4, optString6);
                    }
                }
                yk(optString2);
            } catch (JSONException e5) {
            }
        }
    }

    private void yk(String str) {
        if (this.eLG != null) {
            this.eLG.yk(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qc(int i) {
        View findViewById = bhC().rootView.findViewById(a.g.ala_live_host_bottom);
        View findViewById2 = bhC().rootView.findViewById(a.g.ala_live_unremovable_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(i);
        }
        if (this.eLG != null) {
            this.eLG.bf(2, i);
        }
    }

    private void blN() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.bhC().eUY != null && AlaMasterLiveRoomOpearator.this.bhC().eUY.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.bhC().eUY.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.bhC().eUY.startRecord();
                }
            }
        });
    }

    private void blO() {
        if (bhC().eUY != null && bhC().eUY.getPreview() != null) {
            bhC().eUY.getPreview().setVisibility(8);
            bhC().eUY.stopRecord();
        }
    }

    public void blP() {
        this.eUV = bhC().eUF.bnc();
        if (this.eYJ != null) {
            this.eYJ.jb(this.eUV);
        }
    }

    public void bji() {
        if (this.eYJ != null) {
            this.eYJ.bji();
        }
    }

    public void onDestroy() {
        if (this.eZn != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.eZn);
        }
        this.eZn = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.eZz != null) {
            this.eZz.iZ(true);
        }
        this.eZz = null;
        if (this.eYJ != null) {
            this.eYJ.destroy();
            bhC().rootView.removeView(this.eYJ.getView());
            this.eYJ.release();
            this.eYJ = null;
        }
        if (this.eZB != null) {
            this.eZB.onDestroy();
        }
        if (this.eMn != null) {
            this.eMn.onDestroy();
        }
        if (this.eMp != null) {
            this.eMp.onDestroy();
        }
        if (this.eLA != null) {
            this.eLA.onDestroy();
            this.eLA = null;
        }
        if (this.eYK != null) {
            this.eYK.onDestroy();
        }
        if (this.eYR != null) {
            this.eYR.stopCountDown();
        }
        if (this.eYN != null) {
            this.eYN.onDestroy();
        }
        if (this.eYP != null) {
            this.eYP.onDestroy();
        }
        if (this.eZj != null) {
            this.eZj.onDestroy();
            this.eZj = null;
        }
        if (this.eMA != null) {
            this.eMA.onDestroy();
            this.eMA = null;
        }
        s.rq();
        if (this.eMB != null) {
            this.eMB.onDestroy();
            this.eMB = null;
        }
        if (this.eYQ != null) {
            this.eYQ.onDestroy();
        }
        if (this.eYO != null) {
            this.eYO.boP();
            this.eYO.release();
        }
        if (this.eLE != null) {
            this.eLE = null;
        }
        if (this.eLG != null) {
            this.eLG.release();
        }
        if (this.eYL != null) {
            this.eYL.onDestroy();
        }
        if (this.eYO != null) {
            this.eYO.onDestroy();
        }
        if (this.eMz != null) {
            this.eMz.release();
        }
        if (this.eMI != null) {
            this.eMI.release();
        }
        if (this.eMJ != null) {
            this.eMJ.onDestroy();
        }
        if (this.eMS != null) {
            this.eMS.release();
        }
        if (this.eZD != null) {
            this.eZD.onDestory();
        }
        if (this.eZE != null) {
            this.eZE.release();
        }
        if (this.eMQ != null) {
            this.eMQ.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.eNI);
        MessageManager.getInstance().unRegisterListener(this.eZT);
        MessageManager.getInstance().unRegisterListener(this.eZU);
        MessageManager.getInstance().unRegisterListener(this.eZV);
        MessageManager.getInstance().unRegisterListener(this.eNv);
        MessageManager.getInstance().unRegisterListener(this.eZG);
        MessageManager.getInstance().unRegisterListener(this.eNx);
        MessageManager.getInstance().unRegisterListener(this.eNw);
        com.baidu.live.utils.m.yt();
    }
}
