package com.baidu.tieba.ala.liveroom.master;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.net.Uri;
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
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.AlaLocationData;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.s;
import com.baidu.live.data.v;
import com.baidu.live.data.w;
import com.baidu.live.data.x;
import com.baidu.live.data.y;
import com.baidu.live.gift.p;
import com.baidu.live.gift.q;
import com.baidu.live.gift.r;
import com.baidu.live.im.i;
import com.baidu.live.im.j;
import com.baidu.live.im.m;
import com.baidu.live.k.a;
import com.baidu.live.message.AlaSetPrivateResponseMessage;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaCharmCardActivityConfig;
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
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.liveroom.AlaLiveEndActivity;
import com.baidu.tieba.ala.liveroom.audiencelist.c;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.data.d;
import com.baidu.tieba.ala.liveroom.data.e;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.data.g;
import com.baidu.tieba.ala.liveroom.g.b;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String ejm;
    private List<y> akk;
    private c dWI;
    private com.baidu.tieba.ala.liveroom.l.a dWJ;
    private com.baidu.tieba.ala.liveroom.audiencelist.b dWO;
    private com.baidu.tieba.ala.liveroom.activeview.b dWQ;
    private m dXG;
    private i dXH;
    private j dXI;
    private r dXJ;
    private p dXK;
    protected com.baidu.tieba.ala.liveroom.f.a dXQ;
    protected com.baidu.tieba.ala.liveroom.j.a dXR;
    private com.baidu.tieba.ala.liveroom.share.c dXw;
    private com.baidu.tieba.ala.liveroom.n.b dXx;
    private com.baidu.tieba.ala.liveroom.guide.a dXy;
    private com.baidu.tieba.ala.liveroom.watermark.a dXz;
    private ImageView dYN;
    private e dZB;
    private ImageView dZJ;
    private f dZK;
    private RelativeLayout eiQ;
    private boolean eiW;
    private RelativeLayout ejA;
    private AlaLiveFaceVerifyView ejB;
    private ImageView ejC;
    private ImageView ejD;
    private ImageView ejE;
    private ImageView ejF;
    private ImageView ejG;
    private ImageView ejH;
    private ImageView ejI;
    private View ejJ;
    private ImageView ejK;
    private TextView ejL;
    private FrameLayout ejM;
    private FrameLayout ejN;
    private s ejO;
    private com.baidu.live.m.a ejP;
    private com.baidu.tieba.ala.liveroom.master.panel.b ejQ;
    private d ejR;
    private boolean ejn;
    private com.baidu.tieba.ala.liveroom.g.d ejp;
    private com.baidu.tieba.ala.liveroom.l.a ejq;
    private com.baidu.tieba.ala.liveroom.e.c ejr;
    private com.baidu.tieba.ala.liveroom.b.a ejs;
    private com.baidu.tieba.ala.liveroom.p.a ejt;
    private com.baidu.tieba.ala.liveroom.s.a eju;
    private b ejv;
    private com.baidu.tieba.ala.liveroom.tippop.a ejw;
    private AlaLiveCountDownView ejx;
    private AlaLiveStreamStatusView ejy;
    private com.baidu.tieba.ala.liveroom.views.b ejz;
    private short ekb;
    private com.baidu.tieba.ala.liveroom.g.b ekg;
    private boolean ekh;
    private com.baidu.tieba.ala.liveroom.challenge.f eki;
    private boolean ejo = false;
    private boolean dYc = false;
    private Handler mHandler = new Handler();
    private boolean ejS = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver ejT = null;
    private boolean ejU = false;
    private int ejV = 0;
    private int ejW = 0;
    private int ejX = 0;
    private long ejY = 0;
    private long ejZ = 0;
    private volatile boolean isBackground = false;
    private Intent eka = null;
    private int mOrientation = 1;
    private boolean efS = false;
    private boolean ekc = false;
    private boolean ekd = true;
    private boolean dZH = false;
    private boolean eke = true;
    private int ekf = 0;
    public boolean ekj = false;
    private String otherParams = "";
    private CustomMessageListener dYp = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.dXx == null) {
                AlaMasterLiveRoomOpearator.this.dXx = new com.baidu.tieba.ala.liveroom.n.b(AlaMasterLiveRoomOpearator.this.aQb().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.dXx.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener ekk = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                AlaMasterLiveRoomOpearator.this.f((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dYm = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.dZB.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.tx(str);
            }
        }
    };
    private CustomMessageListener dYn = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.aoa();
        }
    };
    private CustomMessageListener dYD = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.dXK instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) AlaMasterLiveRoomOpearator.this.dXK).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    private View.OnClickListener ekl = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.ejF) {
                    AlaMasterLiveRoomOpearator.this.aTn();
                    AlaMasterLiveRoomOpearator.this.ejQ.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.ejE) {
                    if (AlaMasterLiveRoomOpearator.this.dXH != null) {
                        AlaMasterLiveRoomOpearator.this.dXH.sE().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.ejG) {
                    AlaMasterLiveRoomOpearator.this.aoa();
                } else if (view != AlaMasterLiveRoomOpearator.this.ejH) {
                    if (view == AlaMasterLiveRoomOpearator.this.dZJ) {
                        if (AlaMasterLiveRoomOpearator.this.eki != null) {
                            AlaMasterLiveRoomOpearator.this.eki.aQd();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.ejI) {
                        if (AlaMasterLiveRoomOpearator.this.eju != null) {
                            g aVb = AlaMasterLiveRoomOpearator.this.aQb().efC.aVb();
                            if (aVb == null || aVb.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(aVb.mLiveSdkInfo.mRoomId);
                                if (aVb.mLiveSdkInfo.mCastIds != null) {
                                    str2 = aVb.mLiveSdkInfo.mCastIds.PG;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.eju.R("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.ejK) {
                        com.baidu.live.data.i uj = AlaMasterLiveRoomOpearator.this.aQb().efC.uj();
                        if (AlaMasterLiveRoomOpearator.this.dXQ != null && uj != null && uj.mLiveInfo != null) {
                            String valueOf = String.valueOf(uj.mLiveInfo.live_id);
                            String valueOf2 = String.valueOf(uj.mLiveInfo.feed_id);
                            long j = uj.mLiveInfo.room_id;
                            String str3 = uj.mLiveInfo.cover;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (uj.mLiveInfo.session_info != null) {
                                str4 = uj.mLiveInfo.session_info.flvUrl;
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
                            AlaMasterLiveRoomOpearator.this.dXQ.tB(com.baidu.live.utils.m.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.hX(true);
                }
            }
        }
    };
    private CustomMessageListener dYo = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof s) {
                    AlaMasterLiveRoomOpearator.this.dYc = true;
                    AlaMasterLiveRoomOpearator.this.ejO = (s) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.ejz != null && AlaMasterLiveRoomOpearator.this.ejz.getView() != null && AlaMasterLiveRoomOpearator.this.ejz.getView().getParent() != null) {
                        AlaMasterLiveRoomOpearator.this.aQb().Bg.removeView(AlaMasterLiveRoomOpearator.this.ejz.getView());
                        if (AlaMasterLiveRoomOpearator.this.dXH != null) {
                            AlaMasterLiveRoomOpearator.this.dXH.sD().getView().setVisibility(0);
                        }
                    }
                    if (AlaMasterLiveRoomOpearator.this.dXH != null) {
                        AlaMasterLiveRoomOpearator.this.dXH.sE().show();
                        AlaMasterLiveRoomOpearator.this.dXH.sE().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.nM(8);
                }
            }
        }
    };
    private CustomMessageListener ekm = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.aQb() != null && AlaMasterLiveRoomOpearator.this.aQb().efX != null) {
                AlaMasterLiveRoomOpearator.this.aQb().efX.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener eiL = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.aTW();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.aQb().efC.nU(i);
            }
        }
    };
    private CustomMessageListener dUL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.aTP();
        }
    };
    public final HttpMessageListener ekn = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.um()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.ejQ != null) {
                            AlaMasterLiveRoomOpearator.this.ejQ.id(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.ejQ.aUs();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.aQb().efV.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.ejw != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.ejw.a(AlaMasterLiveRoomOpearator.this.aQb().Bg, AlaMasterLiveRoomOpearator.this.aQb().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.aQb().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.ejw.ob(2);
                        AlaMasterLiveRoomOpearator.this.ejw.a(AlaMasterLiveRoomOpearator.this.aQb().Bg, string, 3);
                    }
                }
            }
        }
    };
    private b.a eko = new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        @Override // com.baidu.tieba.ala.liveroom.views.b.a
        public void nN(int i) {
            com.baidu.live.c.np().putInt("live_beauty_level", i);
            AlaMasterLiveRoomOpearator.this.aQb().efV.setBeauty(i);
        }
    };
    private f.a ekp = new f.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void aUb() {
            AlaMasterLiveRoomOpearator.this.aTM();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void aUc() {
            AlaMasterLiveRoomOpearator.this.aTN();
        }
    };
    com.baidu.tieba.ala.liveroom.b ekq = new com.baidu.tieba.ala.liveroom.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        @Override // com.baidu.tieba.ala.liveroom.b
        public boolean na(int i) {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void nb(int i) {
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void nc(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.aQb().aRL() == 1) {
                AlaMasterLiveRoomOpearator.this.aQb().efV.stopRecord();
            }
        }
    };
    private IShareCallback ekr = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.ejS && AlaMasterLiveRoomOpearator.this.ejR != null) {
                AlaMasterLiveRoomOpearator.this.ejS = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.ejR);
            }
        }
    };
    private View.OnTouchListener eks = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.aQb().efX.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.aQb().efD);
            if (AlaMasterLiveRoomOpearator.this.ejz != null && AlaMasterLiveRoomOpearator.this.ejz.getView() != null && AlaMasterLiveRoomOpearator.this.ejz.getView().getParent() != null) {
                AlaMasterLiveRoomOpearator.this.aQb().Bg.removeView(AlaMasterLiveRoomOpearator.this.ejz.getView());
                AlaMasterLiveRoomOpearator.this.nM(0);
                if (AlaMasterLiveRoomOpearator.this.dXH != null) {
                    AlaMasterLiveRoomOpearator.this.dXH.sD().getView().setVisibility(0);
                }
            }
            return false;
        }
    };
    private f.b ekt = new f.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUd() {
            if (AlaMasterLiveRoomOpearator.this.aQb() != null && AlaMasterLiveRoomOpearator.this.aQb().efC != null) {
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.aQb().efC.aUU();
                } else if (TbadkCoreApplication.getInst().isTieba()) {
                    AlaMasterLiveRoomOpearator.this.aQb().efC.aUV();
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUe() {
            AlaMasterLiveRoomOpearator.this.eiW = AlaMasterLiveRoomOpearator.this.ejp.aRD();
            AlaMasterLiveRoomOpearator.this.aQb().efX.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.aQb().efX.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.aQb().efX.sampleMemAndCPU();
            d dVar = new d();
            dVar.efP = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.aQb().aRL();
            dVar.title = AlaMasterLiveRoomOpearator.this.ejp.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.efQ = AlaMasterLiveRoomOpearator.this.ejp.aRE();
            dVar.efT = AlaMasterLiveRoomOpearator.this.eiW;
            dVar.efS = AlaMasterLiveRoomOpearator.this.ejp.aRB();
            dVar.efR = AlaMasterLiveRoomOpearator.this.ejp.aRG();
            dVar.efU = AlaMasterLiveRoomOpearator.this.ejp.aRC();
            if (dVar.efU) {
                if (AlaMasterLiveRoomOpearator.this.ejp.aRH()) {
                    AlaMasterLiveRoomOpearator.this.ejS = true;
                    AlaMasterLiveRoomOpearator.this.ejR = dVar;
                    AlaMasterLiveRoomOpearator.this.ejp.aRI();
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
            AlaMasterLiveRoomOpearator.this.aQb().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.aQb().d((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUf() {
            AlaMasterLiveRoomOpearator.this.hX(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public boolean aUg() {
            if (AlaMasterLiveRoomOpearator.this.ejz == null || AlaMasterLiveRoomOpearator.this.ejz.getView() == null || AlaMasterLiveRoomOpearator.this.ejz.getView().getParent() == null) {
                return false;
            }
            AlaMasterLiveRoomOpearator.this.aQb().Bg.removeView(AlaMasterLiveRoomOpearator.this.ejz.getView());
            return true;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUh() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUi() {
            com.baidu.live.utils.m.k(AlaMasterLiveRoomOpearator.this.dZB.pageContext.getPageActivity(), "", "");
        }
    };
    private b.a eku = new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aRy() {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.aQb().efD);
            if (AlaMasterLiveRoomOpearator.this.ejp == null || AlaMasterLiveRoomOpearator.this.ejp.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.nM(0);
            }
            if (AlaMasterLiveRoomOpearator.this.ejz != null && AlaMasterLiveRoomOpearator.this.ejz.getView() != null && AlaMasterLiveRoomOpearator.this.ejz.getView().getParent() != null) {
                AlaMasterLiveRoomOpearator.this.aQb().Bg.removeView(AlaMasterLiveRoomOpearator.this.ejz.getView());
            }
            if (AlaMasterLiveRoomOpearator.this.dXH != null) {
                AlaMasterLiveRoomOpearator.this.dXH.sD().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.dXH.sE().hide();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void onBlurLevelSelected(int i) {
            if (AlaMasterLiveRoomOpearator.this.aQb().efV != null) {
                AlaMasterLiveRoomOpearator.this.aQb().efV.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void onFilterSelected(String str) {
            if (AlaMasterLiveRoomOpearator.this.aQb().efV != null) {
                AlaMasterLiveRoomOpearator.this.aQb().efV.onFilterSelected(str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aY(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aQb().efV != null) {
                AlaMasterLiveRoomOpearator.this.aQb().efV.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aZ(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aQb().efV != null) {
                AlaMasterLiveRoomOpearator.this.aQb().efV.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void ba(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aQb().efV != null) {
                AlaMasterLiveRoomOpearator.this.aQb().efV.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void bb(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aQb().efV != null) {
                AlaMasterLiveRoomOpearator.this.aQb().efV.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private AlaLiveView.c ekv = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        boolean cGJ = true;

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void aOQ() {
            if (AlaMasterLiveRoomOpearator.this.eju != null) {
                AlaMasterLiveRoomOpearator.this.eju.in(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void hs(boolean z) {
            if (this.cGJ != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.eki != null) {
                        AlaMasterLiveRoomOpearator.this.eki.a(AlaMasterLiveRoomOpearator.this.dZJ);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.eki != null) {
                    AlaMasterLiveRoomOpearator.this.eki.aQe();
                }
                if (AlaMasterLiveRoomOpearator.this.eju != null) {
                    AlaMasterLiveRoomOpearator.this.eju.in(z);
                }
                this.cGJ = z;
            }
        }
    };
    private AlaLiveFaceVerifyView.a ekw = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.ejB != null && AlaMasterLiveRoomOpearator.this.aQb().Bg.indexOfChild(AlaMasterLiveRoomOpearator.this.ejB) >= 0) {
                AlaMasterLiveRoomOpearator.this.aQb().Bg.removeView(AlaMasterLiveRoomOpearator.this.ejB);
                AlaMasterLiveRoomOpearator.this.ejB.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.ejB = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b dXm = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void n(View view, int i) {
            com.baidu.live.data.i uj;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.aTV();
            } else if (i == 14 && (uj = AlaMasterLiveRoomOpearator.this.aQb().efC.uj()) != null && uj.Ps != null && uj.mLiveInfo != null && uj.PN != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity(), uj.Ps.userName, Long.toString(uj.Ps.userId), Long.toString(uj.Ps.charmCount), String.valueOf(uj.mLiveInfo.group_id), String.valueOf(uj.mLiveInfo.live_id), true, String.valueOf(uj.Ps.userId), Long.toString(uj.PN.userId), uj.PN.userName, uj.PN.portrait, AlaMasterLiveRoomOpearator.this.dWO.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(uj.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.dWO.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener ekx = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.ekj = ((HasGoodsAuthResponseMessage) httpResponsedMessage).els;
            }
        }
    };
    private HttpMessageListener eky = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.ejL.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.ejL.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.ejL.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.ejL.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.akk = getVideoGoodsListHttpResponseMessage.akk;
            }
        }
    };
    private HttpMessageListener ekz = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.akf != null && !eventPollingHttpResponseMessage.akf.isEmpty() && AlaMasterLiveRoomOpearator.this.aQb().efC != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj() != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.Pp;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.akf.size()) {
                            break;
                        }
                        x xVar = eventPollingHttpResponseMessage.akf.get(i2);
                        if (j == xVar.liveId && j2 - xVar.createTime <= 60 && !l.g(xVar.liveId, xVar.id)) {
                            l.a(xVar, AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo);
                            l.h(xVar.liveId, xVar.id);
                        }
                        i = i2 + 1;
                    }
                    x xVar2 = eventPollingHttpResponseMessage.akf.get(eventPollingHttpResponseMessage.akf.size() - 1);
                    if (j == xVar2.liveId) {
                        l.f(xVar2.liveId, xVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.ake;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.aQb().efC != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj() != null && AlaMasterLiveRoomOpearator.this.aQb().efC != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj() != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                l.i(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.Ne);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        ejm = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aQb().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(aQb().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.l.a.uA().ajX.Sc;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? aQb().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : aQb().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(aQb().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.eki != null) {
            this.eki.onPKPlayerFirstFrame();
        }
    }

    /* loaded from: classes6.dex */
    private class PerfBroadcastReceiver extends BroadcastReceiver implements Serializable {
        private PerfBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                int intExtra = intent.getIntExtra("status", 1);
                if (intExtra == 2 || intExtra == 5) {
                    AlaMasterLiveRoomOpearator.this.ejU = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.ejU = false;
                }
                if (AlaMasterLiveRoomOpearator.this.ejV == 0) {
                    AlaMasterLiveRoomOpearator.this.ejV = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.ejW == 0) {
                    AlaMasterLiveRoomOpearator.this.ejW = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.ejX = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        if (aQb() != null && aQb().efW != null) {
            aQb().efW.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(e eVar) {
        this.dZB = eVar;
    }

    protected e aQb() {
        return this.dZB;
    }

    public int a(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.dZK = fVar;
        this.ejT = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.ejT, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.ejw == null) {
            this.ejw = new com.baidu.tieba.ala.liveroom.tippop.a(this.dZB.pageContext, null);
        }
        registerListener();
        aTB();
        Long[] lArr = new Long[1];
        this.ejY = lArr[0] == null ? 0L : lArr[0].longValue();
        this.ejZ = lArr[0] != null ? lArr[0].longValue() : 0L;
        aQb().efD.setOnTouchListener(this.eks);
        this.ejn = SharedPrefHelper.getInstance().getBoolean(ejm, false);
        this.ejx = new AlaLiveCountDownView(aQb().pageContext.getPageActivity());
        this.ejx.setCount(3);
        this.ejx.setTextColor(aQb().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.ejx.setTextSize(aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.ejx.setTypeface(Typeface.DEFAULT_BOLD);
        this.ejx.setIncludeFontPadding(false);
        this.ejx.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void aUj() {
                if (AlaMasterLiveRoomOpearator.this.aQb().efD != null) {
                    AlaMasterLiveRoomOpearator.this.aQb().efD.removeView(AlaMasterLiveRoomOpearator.this.ejx);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTn() {
        if (this.ejQ == null) {
            this.ejQ = new com.baidu.tieba.ala.liveroom.master.panel.b(aQb().pageContext.getPageActivity(), aQb().aRL() == 2);
            this.ejQ.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.aQb().efV.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void hZ(boolean z) {
                    AlaMasterLiveRoomOpearator.this.aQb().efV.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ia(boolean z) {
                    AlaMasterLiveRoomOpearator.this.aQb().efV.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.aTU();
                    if (AlaMasterLiveRoomOpearator.this.ejw != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.ejw.a(AlaMasterLiveRoomOpearator.this.aQb().Bg, AlaMasterLiveRoomOpearator.this.aQb().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.ejw.a(AlaMasterLiveRoomOpearator.this.aQb().Bg, AlaMasterLiveRoomOpearator.this.aQb().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ib(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.d(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void aUk() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.aQb().efC != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj() != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.a(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void aUl() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.c(AlaMasterLiveRoomOpearator.this.aQb().pageContext.getPageActivity())));
                }
            });
        }
        aTo();
    }

    private void aTo() {
        if (this.ejQ != null) {
            boolean isBackCamera = aQb().efV.isBackCamera();
            this.ejQ.ic(aQb().efV.isBackCamera());
            this.ejQ.D(aQb().efV.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = aQb().efV.isPushMirror();
            if (this.ekd) {
                isPushMirror = aTT() || isPushMirror;
                this.ekd = false;
            }
            this.ejQ.E(isPushMirror, isBackCamera ? false : true);
            this.ejQ.id(aQb().efV.isMute());
            this.ejQ.aUs();
        }
    }

    public void aTp() {
        if (this.dZK != null) {
            if (this.dZK.efZ == null || this.dZK.efZ.mLiveInfo == null) {
                if (this.ejp == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (aQb().efC != null && aQb().efC.uj() != null && aQb().efC.uj().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", aQb().efC.uj().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", aQb().efC.uj().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.ejp = new com.baidu.tieba.ala.liveroom.g.d(aQb().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    aQb().efX.prepareTime = System.currentTimeMillis();
                    aQb().Bg.addView(this.ejp.getView(), layoutParams);
                    this.ejp.a(this.ekr);
                }
                this.ejp.hM(this.efS);
                this.ejp.a(this.ekt);
                this.ejp.a(this.ekp);
                this.ejp.a(aQb().efV, aQb().aRL());
                return;
            }
            this.eiW = this.dZK.efZ.mLiveInfo.screen_direction == 2;
            if (this.dZK.efZ.mLiveInfo.isAudioOnPrivate == 1) {
                aQb().efV.setMute(true);
                if (this.ejw == null) {
                    this.ejw = new com.baidu.tieba.ala.liveroom.tippop.a(this.dZB.pageContext, null);
                }
                if (!this.ejw.oa(2)) {
                    this.ejw.a(aQb().Bg, aQb().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            d dVar = new d();
            dVar.efP = true;
            dVar.forumId = String.valueOf(this.dZK.efZ.mLiveInfo.forum_id);
            dVar.forumName = this.dZK.efZ.mLiveInfo.forum_name;
            dVar.liveType = this.dZK.efZ.mLiveInfo.live_type;
            dVar.title = this.dZK.efZ.mLiveInfo.getLiveTitle();
            dVar.clarity = this.dZK.efZ.mLiveInfo.clarity;
            dVar.gameId = this.dZK.efZ.mLiveInfo.game_id;
            dVar.gameName = this.dZK.efZ.mLiveInfo.game_label;
            dVar.efT = this.dZK.efZ.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void aTq() {
        if (this.ekg != null) {
            this.ekg.a(aQb().efV.getVideoConfig());
            aTE();
        }
        if (this.ejp != null) {
            this.ejp.hL(true);
        }
        if (aQb().efV.hasBeauty() >= 0) {
            aQb().efV.setBeauty(com.baidu.live.c.np().getInt("live_beauty_level", 3));
        }
    }

    public void d(d dVar) {
        aTH();
        aTS();
        if (aQb().aRL() == 2) {
            this.ejH.setVisibility(8);
            if (this.eju != null) {
                this.eju.in(false);
            }
            if (this.dXH != null && this.dXH.sD() != null) {
                this.dXH.sD().setNeedTopAlphaShade(false);
                return;
            }
            return;
        }
        this.eju = new com.baidu.tieba.ala.liveroom.s.a(aQb().pageContext, this.ekq);
        this.eju.d(aQb().efD, true);
        this.eju.in(true);
        aQb().efV.setPushMirror(aTT());
        if (this.dXH != null && this.dXH.sD() != null) {
            this.dXH.sD().setNeedTopAlphaShade(true);
        }
    }

    public void b(g gVar) {
        boolean z;
        int startPush;
        if (!aQb().efV.isBackground() && aQb().efC.uj() != null && aQb().efC.uj().mLiveInfo != null && (startPush = aQb().efV.startPush(aQb().efC.uj().mLiveInfo.getPushUrl())) != 0 && aQb().efX != null) {
            aQb().efX.errCode = 4;
            aQb().efX.errSubReason = startPush;
        }
        if (gVar != null && !gVar.aRR() && !aTQ()) {
            hY(true);
            aTR();
        }
        if (this.ejr != null) {
            this.ejr.h(aQb().efC.uj());
        }
        if (this.dWJ != null) {
            this.dWJ.l(aQb().efC.uj());
        }
        if (this.ejs != null && aQb() != null && aQb().efC != null) {
            this.ejs.b(aQb().efD, aQb().efC.uj());
        }
        if (this.ejq != null) {
            this.ejq.l(aQb().efC.uj());
        }
        if (gVar == null || gVar.Ps == null) {
            z = com.baidu.live.c.np().getBoolean("ala_master_can_use_challenge", false);
        } else {
            z = gVar.Ps.canUseChallenge;
            com.baidu.live.c.np().putBoolean("ala_master_can_use_challenge", z);
        }
        aTI();
        aTt();
        hW(z);
        e(aQb().efC.uj());
        aTL();
        aOX();
        aPj();
        if (this.dXG != null) {
            this.dXG.f(aQb().efC.uj());
        }
        if (this.dXH != null) {
            this.dXH.e(String.valueOf(aQb().efC.uj().mLiveInfo.group_id), String.valueOf(aQb().efC.uj().mLiveInfo.last_msg_id), String.valueOf(aQb().efC.uj().Ps.userId), String.valueOf(aQb().efC.uj().mLiveInfo.live_id), aQb().efC.uj().Ps.appId);
        }
        if (this.dXI != null) {
            this.dXI.a(aQb().efC.uj(), true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
            l.i(aQb().efC.uj().mLiveInfo.user_id, aQb().efC.uj().mLiveInfo.live_id);
        }
    }

    private void hW(boolean z) {
        if (this.eki == null) {
            this.eki = new com.baidu.tieba.ala.liveroom.challenge.f(aQb());
        }
        this.eki.a(this.dZJ, this.dZK);
        this.eki.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(v vVar, w wVar, w wVar2) {
                if (AlaMasterLiveRoomOpearator.this.dXz != null) {
                    AlaMasterLiveRoomOpearator.this.dXz.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.aQb().efD.ert = false;
                AlaMasterLiveRoomOpearator.this.aTr();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void nH() {
                if (AlaMasterLiveRoomOpearator.this.dWQ != null) {
                    AlaMasterLiveRoomOpearator.this.dWQ.hk(true);
                    AlaMasterLiveRoomOpearator.this.dWQ.setVisible(8);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void aPZ() {
                if (AlaMasterLiveRoomOpearator.this.dXz != null) {
                    AlaMasterLiveRoomOpearator.this.dXz.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.aQb().efD.ert = true;
                AlaMasterLiveRoomOpearator.this.aTs();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void aQa() {
            }
        });
        this.eki.B(this.eiW, z);
        this.eki.h(this.eiW, z, (this.dZK == null || this.dZK.efZ == null || this.dZK.efZ.mChallengeData == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTr() {
        if (this.ejv != null) {
            this.ejv.setVisible(8);
            this.ejv.setCanVisible(false);
        }
        if (this.dWQ != null) {
            this.dWQ.hk(true);
            this.dWQ.setVisible(8);
        }
        if (this.ejy != null) {
            this.ejy.setCanVisible(false);
            this.ejy.setVisibility(4);
        }
        if (this.eju != null) {
            this.eju.im(false);
        }
        if (this.dXH != null) {
            this.dXH.sD().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTs() {
        if (this.ejv != null) {
            this.ejv.setCanVisible(true);
        }
        if (this.dWQ != null) {
            this.dWQ.hk(false);
            this.dWQ.setVisible(0);
        }
        if (this.ejy != null) {
            this.ejy.setCanVisible(true);
        }
        if (this.eju != null) {
            this.eju.im(true);
        }
        if (this.dXH != null) {
            this.dXH.sD().setNeedTopAlphaShade(false);
        }
    }

    private void aTt() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.ejy == null) {
            this.ejy = new AlaLiveStreamStatusView(aQb().pageContext.getPageActivity());
        }
        this.ejy.setId(a.g.ala_live_room_stream_view);
        this.ejy.setVisibility(4);
        this.ejy.setLayoutParams(layoutParams);
        if (this.ejy.getParent() == null) {
            aQb().efD.addView(this.ejy, layoutParams);
        }
    }

    public void aTu() {
        if (this.ejp != null && this.ejp.getVisibility() != 8 && aQb().efV.getPreview() != null) {
            aQb().efV.stopRecord();
        }
    }

    public void aTv() {
        if (aQb().efV.getPreview() != null) {
            aQb().efV.stopRecord();
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.ekg != null) {
                this.ekg.hK(false);
            }
            this.ekg = new com.baidu.tieba.ala.liveroom.g.b(aQb().Bg, aQb().pageContext.getPageActivity());
            this.ekg.setOnEffectSelectedListener(this.eku);
            this.ekg.a(aQb().efV.getVideoConfig());
            aTE();
            if (i3 == 2 || i3 == 1) {
            }
        }
        if (this.ejw != null) {
            this.ejw.aWf();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.ejo = z;
        if (z) {
            Rect rect = new Rect();
            aQb().efD.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            aQb().efD.getGlobalVisibleRect(rect2);
            if (this.dXH != null && this.dXH.sD() != null) {
                this.dXH.sD().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dXH.sD().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.dXH.sD().getView().setLayoutParams(layoutParams);
            }
            if (this.dXH != null && this.dXH.sE() != null) {
                int i = rect2.bottom - rect.bottom;
                this.dXH.sE().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dXH.sE().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.dXH.sE().getView().setLayoutParams(layoutParams2);
                this.dXH.sE().getView().setVisibility(0);
            }
            nM(8);
            nL(8);
        } else {
            if (this.dXH != null && this.dXH.sD() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dXH.sD().getView().getLayoutParams();
                layoutParams3.bottomMargin = aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.dXH.sD().getView().setLayoutParams(layoutParams3);
            }
            if (this.dXH != null && this.dXH.sE() != null) {
                this.dXH.sE().hide();
            }
            nM(0);
            nL(0);
        }
        if (this.ejp != null) {
            this.ejp.C(false, z);
        }
        if (this.dXI != null) {
            this.dXI.sK();
        }
        if (this.dXH != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(aQb().pageContext.getPageActivity())) + aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (aQb().efD.indexOfChild(this.dXH.sD().getView()) != -1 && this.dXH.sD().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.dXH.sD().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.dXH.sD().getView().setLayoutParams(layoutParams4);
            }
            this.dXH.sD().sC();
        }
    }

    private void nL(int i) {
        if (this.dWJ != null) {
            this.dWJ.ny(i);
        }
        if (this.eiQ != null) {
            this.eiQ.setVisibility(i);
        }
        if (this.ejt != null) {
            this.ejt.setVisible(i);
        }
        if (this.ejs != null) {
            this.ejs.setVisibility(i);
        }
        if (this.dWQ != null) {
            this.dWQ.setVisible(i);
        }
        if (this.dXR != null) {
            this.dXR.setVisible(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            aQb().efX.errCode = 1;
            aTM();
        } else if (i == -5) {
            aTN();
        } else if (i == -2) {
            tO(aQb().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            aQb().efV.stopRecord();
        } else if (i == -3 && this.ejp != null) {
            this.ejp.hL(false);
        }
        if (i == -4) {
            if (this.ejp == null || this.ejp.getView().getParent() == null) {
                aQb().d((short) 1);
                return;
            }
            this.ejp.aRF();
            this.ejH.setVisibility(0);
            if (this.eju != null) {
                this.eju.in(true);
            }
            aQb().efD.setBackgroundColor(aQb().pageContext.getResources().getColor(17170445));
            aTZ();
        } else if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aPu();
        if (i == 12001) {
            if (i2 == -1) {
                tP(ak(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                al(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            aoa();
        }
    }

    public void onResume() {
        if (this.ejp != null) {
            this.ejp.onResume();
        }
        if (this.ejS && this.ejR != null) {
            this.ejS = false;
            c(this.ejR);
        }
    }

    public void e(short s) {
        if (this.dXG != null) {
            this.dXG.rs();
        }
        if (this.dXH != null) {
            this.dXH.a(null);
            this.dXH.sj();
        }
        if (this.dXI != null) {
            this.dXI.sj();
        }
        if (this.eki != null) {
            this.eki.aQf();
        }
    }

    public boolean aTw() {
        com.baidu.live.data.i uj = aQb().efC.uj();
        if (this.dXH != null) {
            this.dXH.sD().a(String.valueOf(uj.mLiveInfo.group_id), String.valueOf(uj.mLiveInfo.live_id), true, String.valueOf(uj.Ps.userId));
        }
        if (this.dXI != null) {
            this.dXI.b(uj);
        }
        if (this.dWJ != null) {
            this.dWJ.l(uj);
        }
        if (uj != null) {
            if (this.ejr != null) {
                this.ejr.h(uj);
            }
            if (this.eki != null) {
                this.eki.b(uj);
            }
            if (this.dXK != null && uj.mLiveInfo != null) {
                this.dXK.a(uj.mLiveInfo);
            }
            if (this.dWQ != null) {
                this.dWQ.g(uj);
            }
            if (uj.mLiveInfo.live_status != 1) {
                aTX();
                aQb().pageContext.getPageActivity().finish();
                if (aQb().efC != null && aQb().efC.uj() != null) {
                    String str = null;
                    if (aQb().efC.aVl() != 1) {
                        str = aQb().pageContext.getString(a.i.ala_live_end_authen_msg);
                    }
                    a(uj.mLiveInfo, 1, str);
                }
                return true;
            } else if (this.ekj) {
                this.ejJ.setVisibility(0);
                if (this.ekh || uj.mLiveInfo == null) {
                    return false;
                }
                this.ekh = true;
                com.baidu.live.utils.m.i(uj.mLiveInfo.feed_id, uj.mLiveInfo.live_id);
                return false;
            } else {
                this.ejJ.setVisibility(8);
                return false;
            }
        }
        return false;
    }

    public void aTx() {
        aTo();
    }

    public void aTy() {
        if (this.ekg != null) {
            this.ekg.aRx();
        }
    }

    public void aTz() {
        if (this.ejp != null && this.ejp.getVisibility() != 8) {
            if (aQb().aRL() == 2) {
                aTZ();
            } else {
                aTY();
            }
        }
        if (this.ejp != null && this.ejp.getVisibility() != 8) {
            if (aQb().aRL() == 1) {
                this.ejp.onResume();
            }
            this.ejp.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.dYc && this.ejO != null) {
            if (this.ejz != null && this.ejz.getView() != null && this.ejz.getView().getParent() != null) {
                aQb().Bg.removeView(this.ejz.getView());
                if (this.dXH != null) {
                    this.dXH.sD().getView().setVisibility(0);
                }
            }
            if (this.dXH != null) {
                this.dXH.sE().show();
                this.dXH.sE().setEditText(" @" + this.ejO.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            nM(8);
            this.dYc = false;
        }
        if (this.dXQ != null) {
            this.dXQ.resume();
        }
    }

    public void onPause() {
        if (this.dXQ != null) {
            this.dXQ.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTA() {
        aQb().efD.scrollOrigin();
    }

    private void aTB() {
        this.ejA = (RelativeLayout) aQb().Bg.findViewById(a.g.ala_live_unremovable_host_top);
        this.eiQ = (RelativeLayout) aQb().Bg.findViewById(a.g.ala_live_removeable_top_container);
        this.dZB.efD.setOnLiveViewScrollListener(this.ekv);
        if (this.dWO == null) {
            this.dWO = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.dZB.pageContext.getPageActivity(), false);
        }
        this.dWO.a(this.dXm);
        this.dWO.a(this.eiQ, a.g.ala_live_room_host_header_stub, 1L);
        this.dWO.setVisible(0);
        this.ejC = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_host_close);
        this.ejC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.aTV();
            }
        });
        this.ejM = (FrameLayout) aQb().Bg.findViewById(a.g.ala_liveroom_host_pure_back_btn_layout);
        this.ejN = (FrameLayout) aQb().Bg.findViewById(a.g.ala_liveroom_host_close_btn_layout);
        this.ejD = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_pure_mode_back);
        this.ejD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.aTA();
            }
        });
        this.ejH = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.ejH.setOnClickListener(this.ekl);
        if (aQb().efV.hasBeauty() < 0) {
            this.ejH.setVisibility(8);
        } else {
            this.ejz = new com.baidu.tieba.ala.liveroom.views.b(aQb().pageContext.getPageActivity(), com.baidu.live.c.np().getInt("live_beauty_level", 3));
            this.ejz.a(this.eko);
        }
        this.ejG = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_host_share_btn);
        this.ejG.setOnClickListener(this.ekl);
        this.ejE = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_host_message_btn);
        this.ejE.setOnClickListener(this.ekl);
        this.dZJ = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.dZJ.setOnClickListener(this.ekl);
        this.ejF = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_host_more);
        this.ejF.setOnClickListener(this.ekl);
        this.ejI = (ImageView) aQb().Bg.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.ejI.setOnClickListener(this.ekl);
        this.ejJ = aQb().Bg.findViewById(a.g.host_goods_layout);
        this.ejK = (ImageView) aQb().Bg.findViewById(a.g.host_goods_imageView);
        this.ejL = (TextView) aQb().Bg.findViewById(a.g.host_goods_num_textView);
        this.ejK.setOnClickListener(this.ekl);
        aTG();
        aPf();
        aTF();
        this.ekg = new com.baidu.tieba.ala.liveroom.g.b(aQb().Bg, aQb().pageContext.getPageActivity());
        this.ekg.setOnEffectSelectedListener(this.eku);
        this.dXG = new m();
        aTC();
        aTD();
        if (this.dXJ != null && this.dXJ.pA() != null) {
            this.dXJ.pA().bringToFront();
        }
    }

    private void aTC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, aQb().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.dXH = (i) runTask.getData();
            this.dXH.setFromMaster(true);
            this.dXH.sD().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(aQb().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(aQb().pageContext.getPageActivity()) * 0.27f)) + aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            aQb().efD.addView(this.dXH.sD().getView(), layoutParams);
            this.dXH.sE().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            aQb().efD.addView(this.dXH.sE().getView(), layoutParams2);
            this.dXH.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
                @Override // com.baidu.live.im.i.a
                public boolean sF() {
                    return true;
                }

                @Override // com.baidu.live.im.i.a
                public void sG() {
                }

                @Override // com.baidu.live.im.i.a
                public void cH(String str) {
                }

                @Override // com.baidu.live.im.i.a
                public void sH() {
                }

                @Override // com.baidu.live.im.i.a
                public void sI() {
                }
            });
        }
    }

    private void aTD() {
        this.dXI = new com.baidu.tieba.ala.liveroom.d.a(aQb().pageContext);
        View sJ = this.dXI.sJ();
        if (sJ != null && this.dZB.efD.indexOfChild(sJ) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dZB.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = aQb().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            aQb().efD.addView(sJ, layoutParams);
        }
    }

    private void aTE() {
        if (aQb().efV != null) {
            com.baidu.tieba.ala.liveroom.data.c cVar = new com.baidu.tieba.ala.liveroom.data.c();
            cVar.tI(com.baidu.live.c.np().getString("ala_beauty_5.4_config_str", ""));
            aQb().efV.onBlurLevelSelected(cVar.efM);
            aQb().efV.onFilterSelected(cVar.mFilterName);
            aQb().efV.onColorLevelSelected((cVar.efK * 1.0f) / 100.0f);
            aQb().efV.onCheekThinSelected((cVar.efO * 1.0f) / 100.0f);
            aQb().efV.onEnlargeEyeSelected((cVar.efN * 1.0f) / 100.0f);
            aQb().efV.onRedLevelSelected((cVar.efL * 1.0f) / 100.0f);
        }
    }

    private void aTF() {
        CustomResponsedMessage runTask;
        if (this.ejP == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.m.a.class, aQb().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.ejP = (com.baidu.live.m.a) runTask.getData();
        }
    }

    private void aTG() {
        View pA;
        q.b(aQb().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.Wi = true;
        fVar.context = aQb().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, r.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.dXJ = (r) runTask.getData();
            if (this.dXJ != null && (pA = this.dXJ.pA()) != null && aQb().efD.indexOfChild(pA) < 0) {
                if (pA.getParent() instanceof ViewGroup) {
                    ((ViewGroup) pA.getParent()).removeView(pA);
                }
                aQb().efD.addView(pA, aQb().efD.getLayoutParams());
            }
        }
    }

    protected void aPf() {
        View pN;
        if (this.dXK == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.Wi = true;
            aVar.context = aQb().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, p.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.dXK = (p) runTask.getData();
            }
        }
        if (this.dXK != null && (pN = this.dXK.pN()) != null) {
            if (aQb().efD.indexOfChild(pN) < 0) {
                if (pN.getParent() instanceof ViewGroup) {
                    ((ViewGroup) pN.getParent()).removeView(pN);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds220);
                aQb().efD.addView(pN, layoutParams);
            }
            pN.bringToFront();
        }
    }

    private void aTH() {
        aTK();
        aOp();
        aTJ();
        aQb().efD.setVisibility(0);
        nM(0);
    }

    private void aTI() {
        if (this.ejt == null) {
            this.ejt = new com.baidu.tieba.ala.liveroom.p.a(aQb().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.ejt.a(aQb().aRL(), j, TbadkCoreApplication.getCurrentAccountName(), true, aQb().efC.uj().Ps.portrait, this.otherParams, "", -1L);
        this.ejt.Z(aQb().efD);
    }

    private void aTJ() {
        if (this.ejv == null) {
            this.ejv = new b(aQb().pageContext, aQb().efD);
        }
    }

    private void aTK() {
        if (this.dWJ == null) {
            this.dWJ = new com.baidu.tieba.ala.liveroom.l.a(aQb().pageContext, true, this.ekq);
            this.dWJ.d(this.ejA, null);
            this.dWJ.a(this.dXm);
        }
        if (this.ejq == null) {
            this.ejq = new com.baidu.tieba.ala.liveroom.l.a(aQb().pageContext, true, null);
            this.ejq.a(this.eiQ, null, a.g.ala_live_room_host_header_stub);
            this.ejq.aSH();
        }
    }

    private void e(com.baidu.live.data.i iVar) {
        if (this.dWQ == null) {
            this.dWQ = new com.baidu.tieba.ala.liveroom.activeview.b(aQb().pageContext);
        }
        this.dWQ.setOtherParams(this.otherParams);
        this.dWQ.b(iVar, false);
        this.dWQ.setHost(true);
        this.dWQ.a(1, aQb().efD, nr(1));
        this.dWQ.a(2, aQb().efD, nr(2));
        this.dWQ.setVisible(this.ejo ? 8 : 0);
    }

    private ViewGroup.LayoutParams nr(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(aQb().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.ejy != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = aQb().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(aQb().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    private void aOp() {
        if (this.ejs == null) {
            this.ejs = new com.baidu.tieba.ala.liveroom.b.a(aQb().pageContext, true);
        }
    }

    private void aTL() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            Activity pageActivity = aQb().pageContext.getPageActivity();
            this.dYN = new ImageView(pageActivity);
            this.dYN.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.dYN.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.dYN.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            aQb().Bg.addView(this.dYN, layoutParams);
            this.dYN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.aTV();
                }
            });
            this.dYN.setVisibility(8);
        }
    }

    private void aOX() {
        this.dXQ = new com.baidu.tieba.ala.liveroom.f.a(aQb().pageContext);
    }

    private void aPj() {
        if (this.dXR == null) {
            this.dXR = new com.baidu.tieba.ala.liveroom.j.a(aQb().pageContext, true, this.otherParams);
        }
        if (aQb().efC.uj() != null && aQb().efC.uj().Ps != null && aQb().efC.uj().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = aQb().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.dXR.a(aQb().efD, layoutParams, aQb().efC.uj());
        }
    }

    public void onRtcConnected(int i) {
        if (this.eki != null) {
            this.eki.onRtcConnected(i);
        }
    }

    private void registerListener() {
        aQb().pageContext.registerListener(this.dYm);
        aQb().pageContext.registerListener(this.ekk);
        aQb().pageContext.registerListener(this.dYo);
        aQb().pageContext.registerListener(this.dYp);
        aQb().pageContext.registerListener(this.ekm);
        aQb().pageContext.registerListener(this.eiL);
        aQb().pageContext.registerListener(this.dUL);
        aQb().pageContext.registerListener(this.ekn);
        aQb().pageContext.registerListener(this.dYn);
        aQb().pageContext.registerListener(this.dYD);
        aQb().pageContext.registerListener(this.ekx);
        aQb().pageContext.registerListener(this.eky);
        aQb().pageContext.registerListener(this.ekz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(boolean z) {
        BdUtilHelper.hideSoftKeyPad(aQb().pageContext.getPageActivity(), aQb().Bg);
        if (aQb().efD != null && this.ejz != null && this.ejz.getView() != null && this.ejz.getView().getParent() == null) {
            nM(8);
            if (aQb().efV.hasAdvancedBeauty()) {
                if (this.ekg != null) {
                    this.ekg.b(aQb().efV.getVideoConfig());
                }
            } else {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                aQb().Bg.addView(this.ejz.getView(), layoutParams);
            }
            if (z && this.dXH != null) {
                this.dXH.sD().getView().setVisibility(8);
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
    public void aTM() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aQb().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(aQb().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.aQb().d((short) 1);
            }
        });
        bdAlertDialog.create(aQb().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTN() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aQb().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(aQb().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.aQb().d((short) 1);
            }
        });
        bdAlertDialog.create(aQb().pageContext).show();
    }

    private void tO(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aQb().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.aQb().d((short) 1);
            }
        });
        bdAlertDialog.create(aQb().pageContext).show();
    }

    public void aTO() {
        com.baidu.live.data.e aKy = aQb().efC.aKy();
        int i = 5;
        if (aKy != null) {
            i = (int) aKy.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.aQb().efC.uj() != null && AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.aQb().efC.ck(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo.live_id);
                }
            }
        }, i);
        if (aKy != null) {
            if (this.dWI == null) {
                this.dWI = new c(aQb().pageContext, this.ekq, true);
            }
            if (this.eke) {
                this.eke = false;
                this.dWI.a(String.valueOf(aQb().efC.uj().mLiveInfo.group_id), String.valueOf(aQb().efC.uj().mLiveInfo.live_id), String.valueOf(aQb().efC.uj().Ps.userId), aQb().efC.uj());
                this.dWI.c(this.eiQ, a.g.ala_live_room_host_header_stub, a.g.ala_liveroom_audience_count_layout);
            }
            this.dWI.e(aKy);
            this.dWO.setVisible(0);
            this.dWO.bV(aKy.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTP() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoa() {
        if (aQb().efC != null) {
            if (this.dXw == null) {
                this.dXw = new com.baidu.tieba.ala.liveroom.share.c(aQb().pageContext);
            }
            this.dXw.c(aQb().efC.uj(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (aQb().efC != null && aQb().efC.uj() != null && aQb().efC.uj().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", aQb().efC.uj().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", aQb().efC.uj().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", aQb().efC.uj().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (aQb().efC != null && aQb().efC.uj() != null && aQb().efC.uj().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", aQb().efC.uj().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", aQb().efC.uj().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", aQb().efC.uj().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean aTQ() {
        return this.ejn;
    }

    private void hY(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(ejm, z);
        this.ejn = z;
    }

    private void aTR() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aQb().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.aQb().pageContext).aUM();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(aQb().pageContext).show();
    }

    private void aTS() {
        if (this.eiW && aQb().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            aQb().efY.vs();
        }
        aQb().efX.prepareTime = System.currentTimeMillis() - aQb().efX.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (aQb().efC != null && aQb().efC.uj() != null && aQb().efC.uj().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", aQb().efC.uj().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", aQb().efC.uj().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", aQb().efX.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.ejp != null && this.ejp.getView().getParent() != null) {
            this.ejp.setVisibility(8);
            aQb().Bg.removeView(this.ejp.getView());
            this.ejp.release();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (aQb().efD.indexOfChild(this.ejx) < 0) {
            aQb().efD.addView(this.ejx, layoutParams);
        }
        this.ejx.oc(1000);
    }

    private void aPu() {
        if (aQb().aRL() == 1) {
            aQb().efV.startRecord();
        }
    }

    private void tP(String str) {
        tQ(str);
    }

    private void tQ(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) aQb().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
            editHeadActivityConfig.setPreviewImageHeightScale(1.0f);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, editHeadActivityConfig));
        }
    }

    private String ak(Intent intent) {
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

    private void al(Intent intent) {
        PhotoUrlData fromJson;
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.ejp != null) {
            this.ejp.tH(fromJson.getSmallurl());
        }
    }

    private boolean aTT() {
        return com.baidu.live.c.np().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTU() {
        com.baidu.live.c.np().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.dZB.efV.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTV() {
        int i = a.i.live_close_confirm;
        if (this.eki != null && this.eki.aQh()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.eki != null && this.eki.aQg()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aQb().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(i);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomOpearator.this.aQb().efC.uj() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo, 0, AlaMasterLiveRoomOpearator.this.aQb().efC.aVl() != 1 ? AlaMasterLiveRoomOpearator.this.aQb().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
                } else {
                    AlaMasterLiveRoomOpearator.this.a((Intent) null, (short) 1);
                }
            }
        });
        bdAlertDialog.setNegativeButton(a.i.sdk_dialog_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.32
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(aQb().pageContext).show();
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
            aQb().efC.cq(Long.toString(alaLiveInfoData.live_id), str2);
        }
        if (!this.ekc) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = aQb().efX;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = aQb().efV.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.ejY;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.ejZ;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.ejU;
            if (this.ejV != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.ejW - this.ejX) / this.ejV) * 100.0f;
            }
            Intent intent = new Intent(aQb().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            if (aQb().efC != null && aQb().efC.uj() != null && aQb().efC.uj().Ps != null) {
                String str3 = aQb().efC.uj().Ps.nickName;
                String str4 = aQb().efC.uj().Ps.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.i uj = aQb().efC.uj();
            if (uj != null && uj.Ps != null && !TextUtils.isEmpty(uj.Ps.portrait)) {
                intent.putExtra("host_portrait", uj.Ps.portrait);
            }
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.eka = intent;
                this.ekb = s;
                aQb().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void aTW() {
        if (this.eka != null) {
            a(this.eka, this.ekb);
            this.eka = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.ekc = true;
        if (this.eki != null) {
            this.eki.onDestroy();
        }
        if (intent != null) {
            aQb().pageContext.getPageActivity().startActivity(intent);
        }
        aQb().d(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTX() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.eki != null && this.eki.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (aQb().efW.aUA()) {
                aTV();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.ejy.setVisibility(4);
            return;
        }
        this.ejy.a(i, z, i2, z2);
        if (this.dZB != null && this.dZB.efC != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.ekf != i3) {
                this.ekf = i3;
                if (this.ejw == null) {
                    this.ejw = new com.baidu.tieba.ala.liveroom.tippop.a(this.dZB.pageContext, null);
                }
                switch (this.ekf) {
                    case 0:
                        this.ejw.a(this.dZB.Bg, this.dZB.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.ejw.a(this.dZB.Bg, this.dZB.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.ejw.a(this.dZB.Bg, this.dZB.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.dZB.efC.j(this.dZB.efC.uj().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2;
        long j;
        long j2;
        long j3;
        if (aVar.getMsgType() == 125) {
            if (this.eju != null) {
                this.eju.t(aVar);
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
            if (this.eki != null) {
                this.eki.bT(str);
            }
            if ("close_live".equals(str)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.aTX();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.aQb().efC.uj().mLiveInfo, 1, str2);
                    }
                });
            } else if ("live_admin".equals(str)) {
                if (aQb().efC.uj() != null) {
                    long optLong = jSONObject.optLong("user_id");
                    int optInt = jSONObject.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aQb().efC.uj().PN.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aQb().efC.uj().PN.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        aQb().efC.uj().PN.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str)) {
                if (this.ejP != null) {
                    this.ejP.y(jSONObject);
                }
            } else if (!"live_achievement".equals(str)) {
                if ("enter_live".equals(str)) {
                    String optString = jSONObject.optString("share_enter_msg");
                    int optInt2 = jSONObject.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString)) {
                        this.ejv.al(optString, optInt2);
                    }
                    if (this.dWO.getCount() > 20) {
                        this.dWO.bV(this.dWO.getCount() + 1);
                    } else if (this.dWI != null) {
                        com.baidu.live.data.a te = aVar.te();
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                        dVar.Pt = new AlaLocationData();
                        dVar.Pu = new AlaRelationData();
                        dVar.Ps = new AlaLiveUserInfoData();
                        dVar.Ps.userId = JavaTypesHelper.toLong(te.userId, 0L);
                        dVar.Ps.userName = te.userName;
                        dVar.Ps.portrait = te.portrait;
                        if (this.dWI.c(dVar)) {
                            this.dWO.bV(this.dWO.getCount() + 1);
                        }
                    }
                } else if ("ui_event".equals(str)) {
                    if (jSONObject.optInt("event_type") == 1001 && aQb().efC.uj() != null && aQb().efC.uj().mLiveInfo != null) {
                        String str3 = aQb().efC.uj().mLiveInfo.feed_id;
                        long j4 = aQb().efC.uj().mLiveInfo.live_id;
                        long optLong2 = jSONObject.optLong("id");
                        if (!l.g(j4, optLong2)) {
                            com.baidu.live.utils.m.i(str3, j4);
                            l.h(j4, optLong2);
                        }
                    }
                } else if ("need_update_live_mark_info".equals(str) && jSONObject != null && aQb() != null && aQb().efC != null && aQb().efC.uj() != null && aQb().efC.uj().PN != null && aQb().efC.uj().PN.userId == jSONObject.optLong("user_id")) {
                    aQb().efC.aVa();
                }
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a te2 = aVar.te();
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
                String str4 = null;
                if (aQb().efC == null || aQb().efC.uj() == null || aQb().efC.uj().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                } else {
                    long j5 = aQb().efC.uj().mLiveInfo.live_id;
                    long j6 = aQb().efC.uj().mLiveInfo.group_id;
                    long j7 = aQb().efC.uj().Ps.userId;
                    str4 = aQb().efC.uj().mLiveInfo.appId;
                    j = j7;
                    j2 = j6;
                    j3 = j5;
                }
                if (!this.isBackground || aQb().aRL() != 2) {
                    q.b(optString2, Integer.parseInt(optString3), optString4, optString5, te2.userId, te2.portrait, te2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str4, optString6);
                }
                tv(optString2);
            } catch (JSONException e4) {
            }
        }
    }

    private void tv(String str) {
        if (this.dWQ != null) {
            this.dWQ.tv(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nM(int i) {
        View findViewById = aQb().Bg.findViewById(a.g.ala_live_host_bottom);
        View findViewById2 = aQb().Bg.findViewById(a.g.ala_live_unremovable_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(i);
        }
        if (this.dWQ != null) {
            this.dWQ.aR(2, i);
        }
    }

    private void aTY() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.aQb().efV != null && AlaMasterLiveRoomOpearator.this.aQb().efV.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.aQb().efV.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.aQb().efV.startRecord();
                }
            }
        });
    }

    private void aTZ() {
        if (aQb().efV != null && aQb().efV.getPreview() != null) {
            aQb().efV.getPreview().setVisibility(8);
            aQb().efV.stopRecord();
        }
    }

    public void aUa() {
        this.efS = aQb().efC.aVm();
        if (this.ejp != null) {
            this.ejp.hM(this.efS);
        }
    }

    public void aRJ() {
        if (this.ejp != null) {
            this.ejp.aRJ();
        }
    }

    public void onDestroy() {
        if (this.ejT != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.ejT);
        }
        this.ejT = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ekg != null) {
            this.ekg.hK(true);
        }
        this.ekg = null;
        if (this.ejp != null) {
            this.ejp.destroy();
            aQb().Bg.removeView(this.ejp.getView());
            this.ejp.release();
            this.ejp = null;
        }
        if (this.eki != null) {
            this.eki.onDestroy();
        }
        if (this.dXw != null) {
            this.dXw.onDestroy();
        }
        if (this.dXy != null) {
            this.dXy.onDestroy();
        }
        if (this.dWJ != null) {
            this.dWJ.onDestroy();
            this.dWJ = null;
        }
        if (this.ejq != null) {
            this.ejq.onDestroy();
        }
        if (this.ejx != null) {
            this.ejx.stopCountDown();
        }
        if (this.ejt != null) {
            this.ejt.onDestroy();
        }
        if (this.ejv != null) {
            this.ejv.onDestroy();
        }
        if (this.ejP != null) {
            this.ejP.onDestroy();
            this.ejP = null;
        }
        if (this.dXJ != null) {
            this.dXJ.onDestroy();
            this.dXJ = null;
        }
        q.pO();
        if (this.dXK != null) {
            this.dXK.onDestroy();
            this.dXK = null;
        }
        if (this.ejw != null) {
            this.ejw.onDestroy();
        }
        if (this.eju != null) {
            this.eju.aXd();
            this.eju.release();
        }
        if (this.dWO != null) {
            this.dWO = null;
        }
        if (this.dWQ != null) {
            this.dWQ.release();
        }
        if (this.ejr != null) {
            this.ejr.onDestroy();
        }
        if (this.eju != null) {
            this.eju.onDestroy();
        }
        if (this.dXI != null) {
            this.dXI.release();
        }
        if (this.dXQ != null) {
            this.dXQ.release();
        }
        if (this.dXR != null) {
            this.dXR.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.dYD);
        MessageManager.getInstance().unRegisterListener(this.ekx);
        MessageManager.getInstance().unRegisterListener(this.eky);
        MessageManager.getInstance().unRegisterListener(this.ekz);
        l.ws();
    }
}
