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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class AlaMasterLiveRoomOpearator {
    private static final String eiv;
    private List<y> ajS;
    private c dVR;
    private com.baidu.tieba.ala.liveroom.l.a dVS;
    private com.baidu.tieba.ala.liveroom.audiencelist.b dVX;
    private com.baidu.tieba.ala.liveroom.activeview.b dVZ;
    private com.baidu.tieba.ala.liveroom.share.c dWF;
    private com.baidu.tieba.ala.liveroom.n.b dWG;
    private com.baidu.tieba.ala.liveroom.guide.a dWH;
    private com.baidu.tieba.ala.liveroom.watermark.a dWI;
    private m dWP;
    private i dWQ;
    private j dWR;
    private r dWS;
    private p dWT;
    protected com.baidu.tieba.ala.liveroom.f.a dWZ;
    private ImageView dXW;
    protected com.baidu.tieba.ala.liveroom.j.a dXa;
    private e dYK;
    private ImageView dYS;
    private f dYT;
    private RelativeLayout ehZ;
    private com.baidu.tieba.ala.liveroom.e.c eiA;
    private com.baidu.tieba.ala.liveroom.b.a eiB;
    private com.baidu.tieba.ala.liveroom.p.a eiC;
    private com.baidu.tieba.ala.liveroom.s.a eiD;
    private b eiE;
    private com.baidu.tieba.ala.liveroom.tippop.a eiF;
    private AlaLiveCountDownView eiG;
    private AlaLiveStreamStatusView eiH;
    private com.baidu.tieba.ala.liveroom.views.b eiI;
    private RelativeLayout eiJ;
    private AlaLiveFaceVerifyView eiK;
    private ImageView eiL;
    private ImageView eiM;
    private ImageView eiN;
    private ImageView eiO;
    private ImageView eiP;
    private ImageView eiQ;
    private ImageView eiR;
    private View eiS;
    private ImageView eiT;
    private TextView eiU;
    private FrameLayout eiV;
    private FrameLayout eiW;
    private s eiX;
    private com.baidu.live.m.a eiY;
    private com.baidu.tieba.ala.liveroom.master.panel.b eiZ;
    private boolean eif;
    private boolean eiw;
    private d eiy;
    private com.baidu.tieba.ala.liveroom.l.a eiz;
    private com.baidu.tieba.ala.liveroom.data.d eja;
    private short ejk;
    private com.baidu.tieba.ala.liveroom.g.b ejp;
    private boolean ejq;
    private com.baidu.tieba.ala.liveroom.challenge.f ejr;
    private boolean eix = false;
    private boolean dXl = false;
    private Handler mHandler = new Handler();
    private boolean ejb = false;
    private long lastClickTime = 0;
    private PerfBroadcastReceiver ejc = null;
    private boolean ejd = false;
    private int eje = 0;
    private int ejf = 0;
    private int ejg = 0;
    private long ejh = 0;
    private long eji = 0;
    private volatile boolean isBackground = false;
    private Intent ejj = null;
    private int mOrientation = 1;
    private boolean efb = false;
    private boolean ejl = false;
    private boolean ejm = true;
    private boolean dYQ = false;
    private boolean ejn = true;
    private int ejo = 0;
    public boolean ejs = false;
    private String otherParams = "";
    private CustomMessageListener dXy = new CustomMessageListener(2913025) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            String valueOf = String.valueOf(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.group_id);
            String valueOf2 = String.valueOf(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.live_id);
            String valueOf3 = String.valueOf(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.user_id);
            if (AlaMasterLiveRoomOpearator.this.dWG == null) {
                AlaMasterLiveRoomOpearator.this.dWG = new com.baidu.tieba.ala.liveroom.n.b(AlaMasterLiveRoomOpearator.this.aPZ().pageContext);
            }
            AlaMasterLiveRoomOpearator.this.dWG.a(valueOf, valueOf2, valueOf3, true, data);
        }
    };
    private CustomMessageListener ejt = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.im.data.a)) {
                AlaMasterLiveRoomOpearator.this.g((com.baidu.live.im.data.a) customResponsedMessage.getData());
            }
        }
    };
    private CustomMessageListener dXv = new CustomMessageListener(2913070) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.22
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (TextUtils.isEmpty(str)) {
                    str = AlaMasterLiveRoomOpearator.this.dYK.pageContext.getPageActivity().getResources().getString(a.i.ala_forbid_send_msg_txt);
                }
                AlaMasterLiveRoomOpearator.this.tx(str);
            }
        }
    };
    private CustomMessageListener dXw = new CustomMessageListener(2913062) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.33
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity());
            }
            AlaMasterLiveRoomOpearator.this.anY();
        }
    };
    private CustomMessageListener dXM = new CustomMessageListener(2913103) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.40
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof AlaBroadcastGiftToastData)) {
                AlaBroadcastGiftToastData alaBroadcastGiftToastData = (AlaBroadcastGiftToastData) customResponsedMessage.getData();
                if (AlaMasterLiveRoomOpearator.this.dWT instanceof com.baidu.live.gift.broadcastgift.a) {
                    ((com.baidu.live.gift.broadcastgift.a) AlaMasterLiveRoomOpearator.this.dWT).b(alaBroadcastGiftToastData);
                }
            }
        }
    };
    private View.OnClickListener eju = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.43
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            String str2 = null;
            if (System.currentTimeMillis() - AlaMasterLiveRoomOpearator.this.lastClickTime >= 300) {
                AlaMasterLiveRoomOpearator.this.lastClickTime = System.currentTimeMillis();
                if (view == AlaMasterLiveRoomOpearator.this.eiO) {
                    AlaMasterLiveRoomOpearator.this.aTl();
                    AlaMasterLiveRoomOpearator.this.eiZ.show();
                } else if (view == AlaMasterLiveRoomOpearator.this.eiN) {
                    if (AlaMasterLiveRoomOpearator.this.dWQ != null) {
                        AlaMasterLiveRoomOpearator.this.dWQ.sF().show();
                    }
                } else if (view == AlaMasterLiveRoomOpearator.this.eiP) {
                    AlaMasterLiveRoomOpearator.this.anY();
                } else if (view != AlaMasterLiveRoomOpearator.this.eiQ) {
                    if (view == AlaMasterLiveRoomOpearator.this.dYS) {
                        if (AlaMasterLiveRoomOpearator.this.ejr != null) {
                            AlaMasterLiveRoomOpearator.this.ejr.aQb();
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eiR) {
                        if (AlaMasterLiveRoomOpearator.this.eiD != null) {
                            g aUZ = AlaMasterLiveRoomOpearator.this.aPZ().eeL.aUZ();
                            if (aUZ == null || aUZ.mLiveSdkInfo == null) {
                                str = null;
                            } else {
                                str = String.valueOf(aUZ.mLiveSdkInfo.mRoomId);
                                if (aUZ.mLiveSdkInfo.mCastIds != null) {
                                    str2 = aUZ.mLiveSdkInfo.mCastIds.Pd;
                                }
                            }
                            AlaMasterLiveRoomOpearator.this.eiD.R("", str, str2);
                        }
                    } else if (view == AlaMasterLiveRoomOpearator.this.eiT) {
                        com.baidu.live.data.i uk = AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk();
                        if (AlaMasterLiveRoomOpearator.this.dWZ != null && uk != null && uk.mLiveInfo != null) {
                            String valueOf = String.valueOf(uk.mLiveInfo.live_id);
                            String valueOf2 = String.valueOf(uk.mLiveInfo.feed_id);
                            long j = uk.mLiveInfo.room_id;
                            String str3 = uk.mLiveInfo.cover;
                            String str4 = "";
                            String str5 = "";
                            String str6 = "";
                            String str7 = "";
                            if (uk.mLiveInfo.session_info != null) {
                                str4 = uk.mLiveInfo.session_info.flvUrl;
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
                            AlaMasterLiveRoomOpearator.this.dWZ.tB(com.baidu.live.utils.m.a(valueOf2, valueOf, j, true, 1, str3, str4, str5, str6, str7));
                        }
                    }
                } else {
                    TiebaInitialize.log(new StatisticItem("c11984"));
                    AlaMasterLiveRoomOpearator.this.hX(true);
                }
            }
        }
    };
    private CustomMessageListener dXx = new CustomMessageListener(2913012) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.44
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data != null) {
                if (data instanceof s) {
                    AlaMasterLiveRoomOpearator.this.dXl = true;
                    AlaMasterLiveRoomOpearator.this.eiX = (s) data;
                } else if (data instanceof com.baidu.live.data.a) {
                    com.baidu.live.data.a aVar = (com.baidu.live.data.a) data;
                    if (AlaMasterLiveRoomOpearator.this.eiI != null && AlaMasterLiveRoomOpearator.this.eiI.getView() != null && AlaMasterLiveRoomOpearator.this.eiI.getView().getParent() != null) {
                        AlaMasterLiveRoomOpearator.this.aPZ().AE.removeView(AlaMasterLiveRoomOpearator.this.eiI.getView());
                        if (AlaMasterLiveRoomOpearator.this.dWQ != null) {
                            AlaMasterLiveRoomOpearator.this.dWQ.sE().getView().setVisibility(0);
                        }
                    }
                    if (AlaMasterLiveRoomOpearator.this.dWQ != null) {
                        AlaMasterLiveRoomOpearator.this.dWQ.sF().show();
                        AlaMasterLiveRoomOpearator.this.dWQ.sF().setEditText(" @" + aVar.userName + HanziToPinyin.Token.SEPARATOR);
                    }
                    AlaMasterLiveRoomOpearator.this.nL(8);
                }
            }
        }
    };
    private CustomMessageListener ejv = new CustomMessageListener(2913019) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (AlaMasterLiveRoomOpearator.this.aPZ() != null && AlaMasterLiveRoomOpearator.this.aPZ().efg != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().efg.sampleMemAndCPU();
            }
        }
    };
    private CustomMessageListener ehU = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                AlaMasterLiveRoomOpearator.this.isBackground = ((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue();
                if (!AlaMasterLiveRoomOpearator.this.isBackground) {
                    AlaMasterLiveRoomOpearator.this.aTU();
                }
                int i = 0;
                if (AlaMasterLiveRoomOpearator.this.isBackground) {
                    i = 1;
                }
                AlaMasterLiveRoomOpearator.this.aPZ().eeL.nT(i);
            }
        }
    };
    private CustomMessageListener dTU = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaMasterLiveRoomOpearator.this.aTN();
        }
    };
    public final HttpMessageListener ejw = new HttpMessageListener(1021047) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaSetPrivateResponseMessage)) {
                AlaSetPrivateResponseMessage alaSetPrivateResponseMessage = (AlaSetPrivateResponseMessage) httpResponsedMessage;
                if (alaSetPrivateResponseMessage.un()) {
                    if (alaSetPrivateResponseMessage.hasError()) {
                        if (AlaMasterLiveRoomOpearator.this.eiZ != null) {
                            AlaMasterLiveRoomOpearator.this.eiZ.id(alaSetPrivateResponseMessage.isSwitchOpen() ? false : true);
                            AlaMasterLiveRoomOpearator.this.eiZ.aUq();
                            return;
                        }
                        return;
                    }
                    AlaMasterLiveRoomOpearator.this.aPZ().efe.setMute(alaSetPrivateResponseMessage.isSwitchOpen());
                    if (AlaMasterLiveRoomOpearator.this.eiF != null) {
                        if (alaSetPrivateResponseMessage.isSwitchOpen()) {
                            AlaMasterLiveRoomOpearator.this.eiF.a(AlaMasterLiveRoomOpearator.this.aPZ().AE, AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                            return;
                        }
                        String string = AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getString(a.i.ala_master_live_mute_close_tip);
                        AlaMasterLiveRoomOpearator.this.eiF.oa(2);
                        AlaMasterLiveRoomOpearator.this.eiF.a(AlaMasterLiveRoomOpearator.this.aPZ().AE, string, 3);
                    }
                }
            }
        }
    };
    private b.a ejx = new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.6
        @Override // com.baidu.tieba.ala.liveroom.views.b.a
        public void nM(int i) {
            com.baidu.live.c.np().putInt("live_beauty_level", i);
            AlaMasterLiveRoomOpearator.this.aPZ().efe.setBeauty(i);
        }
    };
    private f.a ejy = new f.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.7
        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void aTZ() {
            AlaMasterLiveRoomOpearator.this.aTK();
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.a
        public void aUa() {
            AlaMasterLiveRoomOpearator.this.aTL();
        }
    };
    com.baidu.tieba.ala.liveroom.b ejz = new com.baidu.tieba.ala.liveroom.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.8
        @Override // com.baidu.tieba.ala.liveroom.b
        public boolean mZ(int i) {
            return false;
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void na(int i) {
        }

        @Override // com.baidu.tieba.ala.liveroom.b
        public void nb(int i) {
            if (1 == i && AlaMasterLiveRoomOpearator.this.aPZ().aRJ() == 1) {
                AlaMasterLiveRoomOpearator.this.aPZ().efe.stopRecord();
            }
        }
    };
    private IShareCallback ejA = new IShareCallback() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.9
        @Override // com.baidu.live.tbadk.share.single.interfaces.IShareCallback
        public void onShare(int i, int i2, String str) {
            if (AlaMasterLiveRoomOpearator.this.ejb && AlaMasterLiveRoomOpearator.this.eja != null) {
                AlaMasterLiveRoomOpearator.this.ejb = false;
                AlaMasterLiveRoomOpearator.this.c(AlaMasterLiveRoomOpearator.this.eja);
            }
        }
    };
    private View.OnTouchListener ejB = new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.10
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            AlaMasterLiveRoomOpearator.this.aPZ().efg.sampleMemAndCPU();
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.aPZ().eeM);
            if (AlaMasterLiveRoomOpearator.this.eiI != null && AlaMasterLiveRoomOpearator.this.eiI.getView() != null && AlaMasterLiveRoomOpearator.this.eiI.getView().getParent() != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().AE.removeView(AlaMasterLiveRoomOpearator.this.eiI.getView());
                AlaMasterLiveRoomOpearator.this.nL(0);
                if (AlaMasterLiveRoomOpearator.this.dWQ != null) {
                    AlaMasterLiveRoomOpearator.this.dWQ.sE().getView().setVisibility(0);
                }
            }
            return false;
        }
    };
    private f.b ejC = new f.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.11
        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUb() {
            if (AlaMasterLiveRoomOpearator.this.aPZ() != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL != null) {
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaMasterLiveRoomOpearator.this.aPZ().eeL.aUS();
                } else if (TbadkCoreApplication.getInst().isTieba()) {
                    AlaMasterLiveRoomOpearator.this.aPZ().eeL.aUT();
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUc() {
            AlaMasterLiveRoomOpearator.this.eif = AlaMasterLiveRoomOpearator.this.eiy.aRB();
            AlaMasterLiveRoomOpearator.this.aPZ().efg.startTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.aPZ().efg.liveTotalTime = System.currentTimeMillis();
            AlaMasterLiveRoomOpearator.this.aPZ().efg.sampleMemAndCPU();
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.eeY = false;
            dVar.forumId = null;
            dVar.forumName = null;
            dVar.liveType = AlaMasterLiveRoomOpearator.this.aPZ().aRJ();
            dVar.title = AlaMasterLiveRoomOpearator.this.eiy.getLiveTitle();
            dVar.clarity = 0;
            dVar.gameId = null;
            dVar.gameName = null;
            dVar.eeZ = AlaMasterLiveRoomOpearator.this.eiy.aRC();
            dVar.efc = AlaMasterLiveRoomOpearator.this.eif;
            dVar.efb = AlaMasterLiveRoomOpearator.this.eiy.aRz();
            dVar.efa = AlaMasterLiveRoomOpearator.this.eiy.aRE();
            dVar.efd = AlaMasterLiveRoomOpearator.this.eiy.aRA();
            if (dVar.efd) {
                if (AlaMasterLiveRoomOpearator.this.eiy.aRF()) {
                    AlaMasterLiveRoomOpearator.this.ejb = true;
                    AlaMasterLiveRoomOpearator.this.eja = dVar;
                    AlaMasterLiveRoomOpearator.this.eiy.aRG();
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
            AlaMasterLiveRoomOpearator.this.aPZ().pageContext.showToast(a.i.ala_live_not_agree_licence_toast);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void onCloseClicked() {
            AlaMasterLiveRoomOpearator.this.aPZ().c((short) 2);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUd() {
            AlaMasterLiveRoomOpearator.this.hX(false);
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public boolean aUe() {
            if (AlaMasterLiveRoomOpearator.this.eiI == null || AlaMasterLiveRoomOpearator.this.eiI.getView() == null || AlaMasterLiveRoomOpearator.this.eiI.getView().getParent() == null) {
                return false;
            }
            AlaMasterLiveRoomOpearator.this.aPZ().AE.removeView(AlaMasterLiveRoomOpearator.this.eiI.getView());
            return true;
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUf() {
            BrowserHelper.startWebActivity(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity(), "https://sv.baidu.com/cashliveui/statictHtml.html#/protocol");
        }

        @Override // com.baidu.tieba.ala.liveroom.views.f.b
        public void aUg() {
            com.baidu.live.utils.m.k(AlaMasterLiveRoomOpearator.this.dYK.pageContext.getPageActivity(), "", "");
        }
    };
    private b.a ejD = new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.13
        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aRw() {
            BdUtilHelper.hideSoftKeyPad(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity(), AlaMasterLiveRoomOpearator.this.aPZ().eeM);
            if (AlaMasterLiveRoomOpearator.this.eiy == null || AlaMasterLiveRoomOpearator.this.eiy.getView().getParent() == null) {
                AlaMasterLiveRoomOpearator.this.nL(0);
            }
            if (AlaMasterLiveRoomOpearator.this.eiI != null && AlaMasterLiveRoomOpearator.this.eiI.getView() != null && AlaMasterLiveRoomOpearator.this.eiI.getView().getParent() != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().AE.removeView(AlaMasterLiveRoomOpearator.this.eiI.getView());
            }
            if (AlaMasterLiveRoomOpearator.this.dWQ != null) {
                AlaMasterLiveRoomOpearator.this.dWQ.sE().getView().setVisibility(0);
                AlaMasterLiveRoomOpearator.this.dWQ.sF().hide();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void onBlurLevelSelected(int i) {
            if (AlaMasterLiveRoomOpearator.this.aPZ().efe != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().efe.onBlurLevelSelected(i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void onFilterSelected(String str) {
            if (AlaMasterLiveRoomOpearator.this.aPZ().efe != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().efe.onFilterSelected(str);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aW(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aPZ().efe != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().efe.onColorLevelSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aX(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aPZ().efe != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().efe.onCheekThinSelected((1.0f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aY(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aPZ().efe != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().efe.onEnlargeEyeSelected((0.8f * i) / i2);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.g.b.a
        public void aZ(int i, int i2) {
            if (AlaMasterLiveRoomOpearator.this.aPZ().efe != null) {
                AlaMasterLiveRoomOpearator.this.aPZ().efe.onRedLevelSelected((1.0f * i) / i2);
            }
        }
    };
    private AlaLiveView.c ejE = new AlaLiveView.c() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.18
        boolean cFS = true;

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void aOO() {
            if (AlaMasterLiveRoomOpearator.this.eiD != null) {
                AlaMasterLiveRoomOpearator.this.eiD.in(false);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveView.c
        public void hs(boolean z) {
            if (this.cFS != z) {
                if (z) {
                    if (AlaMasterLiveRoomOpearator.this.ejr != null) {
                        AlaMasterLiveRoomOpearator.this.ejr.a(AlaMasterLiveRoomOpearator.this.dYS);
                    }
                } else if (AlaMasterLiveRoomOpearator.this.ejr != null) {
                    AlaMasterLiveRoomOpearator.this.ejr.aQc();
                }
                if (AlaMasterLiveRoomOpearator.this.eiD != null) {
                    AlaMasterLiveRoomOpearator.this.eiD.in(z);
                }
                this.cFS = z;
            }
        }
    };
    private AlaLiveFaceVerifyView.a ejF = new AlaLiveFaceVerifyView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.30
        @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveFaceVerifyView.a
        public void onFinished() {
            if (AlaMasterLiveRoomOpearator.this.eiK != null && AlaMasterLiveRoomOpearator.this.aPZ().AE.indexOfChild(AlaMasterLiveRoomOpearator.this.eiK) >= 0) {
                AlaMasterLiveRoomOpearator.this.aPZ().AE.removeView(AlaMasterLiveRoomOpearator.this.eiK);
                AlaMasterLiveRoomOpearator.this.eiK.setVisibility(8);
                AlaMasterLiveRoomOpearator.this.eiK = null;
            }
        }
    };
    private com.baidu.tieba.ala.liveroom.operation.b dWv = new com.baidu.tieba.ala.liveroom.operation.b() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.36
        @Override // com.baidu.tieba.ala.liveroom.operation.b
        public void n(View view, int i) {
            com.baidu.live.data.i uk;
            if (i == 8) {
                AlaMasterLiveRoomOpearator.this.aTT();
            } else if (i == 14 && (uk = AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk()) != null && uk.OR != null && uk.mLiveInfo != null && uk.Pj != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaCharmCardActivityConfig(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity(), uk.OR.userName, Long.toString(uk.OR.userId), Long.toString(uk.OR.charmCount), String.valueOf(uk.mLiveInfo.group_id), String.valueOf(uk.mLiveInfo.live_id), true, String.valueOf(uk.OR.userId), Long.toString(uk.Pj.userId), uk.Pj.userName, uk.Pj.portrait, AlaMasterLiveRoomOpearator.this.dVX.getCount(), AlaMasterLiveRoomOpearator.this.otherParams)));
                LogManager.getCommonLogger().doClickGusetNumLog(uk.mLiveInfo.feed_id, AlaMasterLiveRoomOpearator.this.dVX.getCount() + "", AlaMasterLiveRoomOpearator.this.otherParams);
            }
        }
    };
    private HttpMessageListener ejG = new HttpMessageListener(1021143) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.37
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof HasGoodsAuthResponseMessage)) {
                AlaMasterLiveRoomOpearator.this.ejs = ((HasGoodsAuthResponseMessage) httpResponsedMessage).ekB;
            }
        }
    };
    private HttpMessageListener ejH = new HttpMessageListener(1021144) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.38
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetVideoGoodsListHttpResponseMessage)) {
                GetVideoGoodsListHttpResponseMessage getVideoGoodsListHttpResponseMessage = (GetVideoGoodsListHttpResponseMessage) httpResponsedMessage;
                int i = getVideoGoodsListHttpResponseMessage.count;
                if (i <= 0) {
                    AlaMasterLiveRoomOpearator.this.eiU.setVisibility(8);
                    AlaMasterLiveRoomOpearator.this.eiU.setText("");
                } else {
                    AlaMasterLiveRoomOpearator.this.eiU.setText(i + "");
                    AlaMasterLiveRoomOpearator.this.eiU.setVisibility(0);
                }
                AlaMasterLiveRoomOpearator.this.ajS = getVideoGoodsListHttpResponseMessage.ajS;
            }
        }
    };
    private HttpMessageListener ejI = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof EventPollingHttpResponseMessage)) {
                EventPollingHttpResponseMessage eventPollingHttpResponseMessage = (EventPollingHttpResponseMessage) httpResponsedMessage;
                long j = AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.live_id;
                if (j == eventPollingHttpResponseMessage.liveId && eventPollingHttpResponseMessage.ajN != null && !eventPollingHttpResponseMessage.ajN.isEmpty() && AlaMasterLiveRoomOpearator.this.aPZ().eeL != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk() != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo != null) {
                    long j2 = eventPollingHttpResponseMessage.OO;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= eventPollingHttpResponseMessage.ajN.size()) {
                            break;
                        }
                        x xVar = eventPollingHttpResponseMessage.ajN.get(i2);
                        if (j == xVar.liveId && j2 - xVar.createTime <= 60 && !l.g(xVar.liveId, xVar.id)) {
                            l.a(xVar, AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo);
                            l.h(xVar.liveId, xVar.id);
                        }
                        i = i2 + 1;
                    }
                    x xVar2 = eventPollingHttpResponseMessage.ajN.get(eventPollingHttpResponseMessage.ajN.size() - 1);
                    if (j == xVar2.liveId) {
                        l.f(xVar2.liveId, xVar2.id);
                    }
                }
                int i3 = eventPollingHttpResponseMessage.ajM;
                if (i3 <= 0) {
                    i3 = 5;
                }
                AlaMasterLiveRoomOpearator.this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.39.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaMasterLiveRoomOpearator.this.aPZ().eeL != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk() != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk() != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo != null) {
                            if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
                                l.i(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.user_id, AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.live_id);
                            }
                        }
                    }
                }, i3 * 1000);
            }
        }
    };

    static {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021047, com.baidu.live.a.MD);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaSetPrivateResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        eiv = SharedPrefHelper.getSharedPrefKeyWithAccount("PrefKeyIsShowedAllowFollowDialogAttention");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPZ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setNegativeButton(aPZ().pageContext.getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.41
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        final String str2 = com.baidu.live.l.a.uB().ajF.Rz;
        final boolean z = !TextUtils.isEmpty(str2);
        bdAlertDialog.setPositiveButton(z ? aPZ().pageContext.getPageActivity().getString(a.i.ala_go_feedback_txt) : aPZ().pageContext.getPageActivity().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.42
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                if (z) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) IScrollableHelper.getBbPageContext(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity()), new String[]{str2}, true);
                }
            }
        });
        bdAlertDialog.setCancelable(false);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.isShowTitleAndMessage();
        bdAlertDialog.create(aPZ().pageContext);
        bdAlertDialog.show();
    }

    public void onPKPlayerFirstFrame() {
        if (this.ejr != null) {
            this.ejr.onPKPlayerFirstFrame();
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
                    AlaMasterLiveRoomOpearator.this.ejd = true;
                } else {
                    AlaMasterLiveRoomOpearator.this.ejd = false;
                }
                if (AlaMasterLiveRoomOpearator.this.eje == 0) {
                    AlaMasterLiveRoomOpearator.this.eje = intent.getIntExtra("scale", 100);
                }
                if (AlaMasterLiveRoomOpearator.this.ejf == 0) {
                    AlaMasterLiveRoomOpearator.this.ejf = intent.getIntExtra("level", 0);
                }
                AlaMasterLiveRoomOpearator.this.ejg = intent.getIntExtra("level", 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        if (aPZ() != null && aPZ().eff != null) {
            aPZ().eff.c(dVar);
        }
    }

    public AlaMasterLiveRoomOpearator(e eVar) {
        this.dYK = eVar;
    }

    protected e aPZ() {
        return this.dYK;
    }

    public int a(com.baidu.tieba.ala.liveroom.data.f fVar) {
        this.dYT = fVar;
        this.ejc = new PerfBroadcastReceiver();
        BdBaseApplication.getInst().registerReceiver(this.ejc, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (this.eiF == null) {
            this.eiF = new com.baidu.tieba.ala.liveroom.tippop.a(this.dYK.pageContext, null);
        }
        registerListener();
        aTz();
        Long[] lArr = new Long[1];
        this.ejh = lArr[0] == null ? 0L : lArr[0].longValue();
        this.eji = lArr[0] != null ? lArr[0].longValue() : 0L;
        aPZ().eeM.setOnTouchListener(this.ejB);
        this.eiw = SharedPrefHelper.getInstance().getBoolean(eiv, false);
        this.eiG = new AlaLiveCountDownView(aPZ().pageContext.getPageActivity());
        this.eiG.setCount(3);
        this.eiG.setTextColor(aPZ().pageContext.getPageActivity().getResources().getColor(a.d.sdk_white_alpha60));
        this.eiG.setTextSize(aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds128));
        this.eiG.setTypeface(Typeface.DEFAULT_BOLD);
        this.eiG.setIncludeFontPadding(false);
        this.eiG.setOnCountDownListener(new AlaLiveCountDownView.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.14
            @Override // com.baidu.tieba.ala.liveroom.views.AlaLiveCountDownView.a
            public void aUh() {
                if (AlaMasterLiveRoomOpearator.this.aPZ().eeM != null) {
                    AlaMasterLiveRoomOpearator.this.aPZ().eeM.removeView(AlaMasterLiveRoomOpearator.this.eiG);
                }
            }
        });
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTl() {
        if (this.eiZ == null) {
            this.eiZ = new com.baidu.tieba.ala.liveroom.master.panel.b(aPZ().pageContext.getPageActivity(), aPZ().aRJ() == 2);
            this.eiZ.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.15
                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void switchCamera(boolean z) {
                    AlaMasterLiveRoomOpearator.this.aPZ().efe.switchCamera();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void hZ(boolean z) {
                    AlaMasterLiveRoomOpearator.this.aPZ().efe.switchFlashingLight();
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ia(boolean z) {
                    AlaMasterLiveRoomOpearator.this.aPZ().efe.setPushMirror(z);
                    AlaMasterLiveRoomOpearator.this.aTS();
                    if (AlaMasterLiveRoomOpearator.this.eiF != null) {
                        if (z) {
                            AlaMasterLiveRoomOpearator.this.eiF.a(AlaMasterLiveRoomOpearator.this.aPZ().AE, AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getString(a.i.ala_master_live_mirror_open_tip), 4);
                            return;
                        }
                        AlaMasterLiveRoomOpearator.this.eiF.a(AlaMasterLiveRoomOpearator.this.aPZ().AE, AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getString(a.i.ala_master_live_mirror_close_tip), 4);
                    }
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void ib(boolean z) {
                    MessageManager.getInstance().sendMessage(new com.baidu.live.message.d(1, z ? 1 : 2));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void aUi() {
                    String str = "";
                    if (AlaMasterLiveRoomOpearator.this.aPZ().eeL != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk() != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo != null) {
                        str = String.valueOf(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.getLiveID());
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.a(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity(), str)));
                }

                @Override // com.baidu.tieba.ala.liveroom.master.panel.b.a
                public void aUj() {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.b.c(AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getPageActivity())));
                }
            });
        }
        aTm();
    }

    private void aTm() {
        if (this.eiZ != null) {
            boolean isBackCamera = aPZ().efe.isBackCamera();
            this.eiZ.ic(aPZ().efe.isBackCamera());
            this.eiZ.D(aPZ().efe.isFlashingLightOpen(), isBackCamera);
            boolean isPushMirror = aPZ().efe.isPushMirror();
            if (this.ejm) {
                isPushMirror = aTR() || isPushMirror;
                this.ejm = false;
            }
            this.eiZ.E(isPushMirror, isBackCamera ? false : true);
            this.eiZ.id(aPZ().efe.isMute());
            this.eiZ.aUq();
        }
    }

    public void aTn() {
        if (this.dYT != null) {
            if (this.dYT.efi == null || this.dYT.efi.mLiveInfo == null) {
                if (this.eiy == null) {
                    TiebaInitialize.log("c11856");
                    if (TbadkCoreApplication.getInst().isQuanmin()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_ACCESS);
                        if (aPZ().eeL != null && aPZ().eeL.uk() != null && aPZ().eeL.uk().mLiveInfo != null) {
                            alaStaticItem.addParams("live_id", aPZ().eeL.uk().mLiveInfo.live_id + "");
                            alaStaticItem.addParams("room_id", aPZ().eeL.uk().mLiveInfo.room_id + "");
                        }
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                    this.eiy = new d(aPZ().pageContext);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    aPZ().efg.prepareTime = System.currentTimeMillis();
                    aPZ().AE.addView(this.eiy.getView(), layoutParams);
                    this.eiy.a(this.ejA);
                }
                this.eiy.hM(this.efb);
                this.eiy.a(this.ejC);
                this.eiy.a(this.ejy);
                this.eiy.a(aPZ().efe, aPZ().aRJ());
                return;
            }
            this.eif = this.dYT.efi.mLiveInfo.screen_direction == 2;
            if (this.dYT.efi.mLiveInfo.isAudioOnPrivate == 1) {
                aPZ().efe.setMute(true);
                if (this.eiF == null) {
                    this.eiF = new com.baidu.tieba.ala.liveroom.tippop.a(this.dYK.pageContext, null);
                }
                if (!this.eiF.nZ(2)) {
                    this.eiF.a(aPZ().AE, aPZ().pageContext.getString(a.i.ala_master_live_mute_open_tip), 2, true);
                }
            }
            com.baidu.tieba.ala.liveroom.data.d dVar = new com.baidu.tieba.ala.liveroom.data.d();
            dVar.eeY = true;
            dVar.forumId = String.valueOf(this.dYT.efi.mLiveInfo.forum_id);
            dVar.forumName = this.dYT.efi.mLiveInfo.forum_name;
            dVar.liveType = this.dYT.efi.mLiveInfo.live_type;
            dVar.title = this.dYT.efi.mLiveInfo.getLiveTitle();
            dVar.clarity = this.dYT.efi.mLiveInfo.clarity;
            dVar.gameId = this.dYT.efi.mLiveInfo.game_id;
            dVar.gameName = this.dYT.efi.mLiveInfo.game_label;
            dVar.efc = this.dYT.efi.mLiveInfo.screen_direction == 2;
            c(dVar);
        }
    }

    public void aTo() {
        if (this.ejp != null) {
            this.ejp.a(aPZ().efe.getVideoConfig());
            aTC();
        }
        if (this.eiy != null) {
            this.eiy.hL(true);
        }
        if (aPZ().efe.hasBeauty() >= 0) {
            aPZ().efe.setBeauty(com.baidu.live.c.np().getInt("live_beauty_level", 3));
        }
    }

    public void d(com.baidu.tieba.ala.liveroom.data.d dVar) {
        aTF();
        aTQ();
        if (aPZ().aRJ() == 2) {
            this.eiQ.setVisibility(8);
            if (this.eiD != null) {
                this.eiD.in(false);
            }
            if (this.dWQ != null && this.dWQ.sE() != null) {
                this.dWQ.sE().setNeedTopAlphaShade(false);
                return;
            }
            return;
        }
        this.eiD = new com.baidu.tieba.ala.liveroom.s.a(aPZ().pageContext, this.ejz);
        this.eiD.d(aPZ().eeM, true);
        this.eiD.in(true);
        aPZ().efe.setPushMirror(aTR());
        if (this.dWQ != null && this.dWQ.sE() != null) {
            this.dWQ.sE().setNeedTopAlphaShade(true);
        }
    }

    public void b(g gVar) {
        boolean z;
        int startPush;
        if (!aPZ().efe.isBackground() && aPZ().eeL.uk() != null && aPZ().eeL.uk().mLiveInfo != null && (startPush = aPZ().efe.startPush(aPZ().eeL.uk().mLiveInfo.getPushUrl())) != 0 && aPZ().efg != null) {
            aPZ().efg.errCode = 4;
            aPZ().efg.errSubReason = startPush;
        }
        if (gVar != null && !gVar.aRP() && !aTO()) {
            hY(true);
            aTP();
        }
        if (this.eiA != null) {
            this.eiA.h(aPZ().eeL.uk());
        }
        if (this.dVS != null) {
            this.dVS.l(aPZ().eeL.uk());
        }
        if (this.eiB != null && aPZ() != null && aPZ().eeL != null) {
            this.eiB.b(aPZ().eeM, aPZ().eeL.uk());
        }
        if (this.eiz != null) {
            this.eiz.l(aPZ().eeL.uk());
        }
        if (gVar == null || gVar.OR == null) {
            z = com.baidu.live.c.np().getBoolean("ala_master_can_use_challenge", false);
        } else {
            z = gVar.OR.canUseChallenge;
            com.baidu.live.c.np().putBoolean("ala_master_can_use_challenge", z);
        }
        aTG();
        aTr();
        hW(z);
        e(aPZ().eeL.uk());
        aTJ();
        aOV();
        aPh();
        if (this.dWP != null) {
            this.dWP.f(aPZ().eeL.uk());
        }
        if (this.dWQ != null) {
            this.dWQ.e(String.valueOf(aPZ().eeL.uk().mLiveInfo.group_id), String.valueOf(aPZ().eeL.uk().mLiveInfo.last_msg_id), String.valueOf(aPZ().eeL.uk().OR.userId), String.valueOf(aPZ().eeL.uk().mLiveInfo.live_id), aPZ().eeL.uk().OR.appId);
        }
        if (this.dWR != null) {
            this.dWR.a(aPZ().eeL.uk(), true);
        }
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || (TbadkCoreApplication.sAlaLiveSwitchData != null && !TbadkCoreApplication.sAlaLiveSwitchData.isEventPollingUnabled())) {
            l.i(aPZ().eeL.uk().mLiveInfo.user_id, aPZ().eeL.uk().mLiveInfo.live_id);
        }
    }

    private void hW(boolean z) {
        if (this.ejr == null) {
            this.ejr = new com.baidu.tieba.ala.liveroom.challenge.f(aPZ());
        }
        this.ejr.a(this.dYS, this.dYT);
        this.ejr.a(new com.baidu.tieba.ala.liveroom.challenge.e() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.16
            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void a(v vVar, w wVar, w wVar2) {
                if (AlaMasterLiveRoomOpearator.this.dWI != null) {
                    AlaMasterLiveRoomOpearator.this.dWI.setTimeTextMode(true);
                }
                AlaMasterLiveRoomOpearator.this.aPZ().eeM.eqB = false;
                AlaMasterLiveRoomOpearator.this.aTp();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void nH() {
                if (AlaMasterLiveRoomOpearator.this.dVZ != null) {
                    AlaMasterLiveRoomOpearator.this.dVZ.hk(true);
                    AlaMasterLiveRoomOpearator.this.dVZ.setVisible(8);
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void aPX() {
                if (AlaMasterLiveRoomOpearator.this.dWI != null) {
                    AlaMasterLiveRoomOpearator.this.dWI.setTimeTextMode(false);
                }
                AlaMasterLiveRoomOpearator.this.aPZ().eeM.eqB = true;
                AlaMasterLiveRoomOpearator.this.aTq();
            }

            @Override // com.baidu.tieba.ala.liveroom.challenge.e
            public void aPY() {
            }
        });
        this.ejr.B(this.eif, z);
        this.ejr.h(this.eif, z, (this.dYT == null || this.dYT.efi == null || this.dYT.efi.mChallengeData == null) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTp() {
        if (this.eiE != null) {
            this.eiE.setVisible(8);
            this.eiE.setCanVisible(false);
        }
        if (this.dVZ != null) {
            this.dVZ.hk(true);
            this.dVZ.setVisible(8);
        }
        if (this.eiH != null) {
            this.eiH.setCanVisible(false);
            this.eiH.setVisibility(4);
        }
        if (this.eiD != null) {
            this.eiD.im(false);
        }
        if (this.dWQ != null) {
            this.dWQ.sE().setNeedTopAlphaShade(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTq() {
        if (this.eiE != null) {
            this.eiE.setCanVisible(true);
        }
        if (this.dVZ != null) {
            this.dVZ.hk(false);
            this.dVZ.setVisible(0);
        }
        if (this.eiH != null) {
            this.eiH.setCanVisible(true);
        }
        if (this.eiD != null) {
            this.eiD.im(true);
        }
        if (this.dWQ != null) {
            this.dWQ.sE().setNeedTopAlphaShade(false);
        }
    }

    private void aTr() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.addRule(5, a.g.guard_club_entry_id);
        if (this.eiH == null) {
            this.eiH = new AlaLiveStreamStatusView(aPZ().pageContext.getPageActivity());
        }
        this.eiH.setId(a.g.ala_live_room_stream_view);
        this.eiH.setVisibility(4);
        this.eiH.setLayoutParams(layoutParams);
        if (this.eiH.getParent() == null) {
            aPZ().eeM.addView(this.eiH, layoutParams);
        }
    }

    public void aTs() {
        if (this.eiy != null && this.eiy.getVisibility() != 8 && aPZ().efe.getPreview() != null) {
            aPZ().efe.stopRecord();
        }
    }

    public void aTt() {
        if (aPZ().efe.getPreview() != null) {
            aPZ().efe.stopRecord();
        }
    }

    public void E(int i, int i2, int i3) {
        if (this.mOrientation != i3) {
            if (this.ejp != null) {
                this.ejp.hK(false);
            }
            this.ejp = new com.baidu.tieba.ala.liveroom.g.b(aPZ().AE, aPZ().pageContext.getPageActivity());
            this.ejp.setOnEffectSelectedListener(this.ejD);
            this.ejp.a(aPZ().efe.getVideoConfig());
            aTC();
            if (i3 == 2 || i3 == 1) {
            }
        }
        if (this.eiF != null) {
            this.eiF.aWd();
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.eix = z;
        if (z) {
            Rect rect = new Rect();
            aPZ().eeM.getWindowVisibleDisplayFrame(rect);
            Rect rect2 = new Rect();
            aPZ().eeM.getGlobalVisibleRect(rect2);
            if (this.dWQ != null && this.dWQ.sE() != null) {
                this.dWQ.sE().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dWQ.sE().getView().getLayoutParams();
                layoutParams.bottomMargin = (rect2.bottom - rect.bottom) + aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132);
                this.dWQ.sE().getView().setLayoutParams(layoutParams);
            }
            if (this.dWQ != null && this.dWQ.sF() != null) {
                int i = rect2.bottom - rect.bottom;
                this.dWQ.sF().getView().setBottom(0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dWQ.sF().getView().getLayoutParams();
                layoutParams2.bottomMargin = i;
                this.dWQ.sF().getView().setLayoutParams(layoutParams2);
                this.dWQ.sF().getView().setVisibility(0);
            }
            nL(8);
            nK(8);
        } else {
            if (this.dWQ != null && this.dWQ.sE() != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.dWQ.sE().getView().getLayoutParams();
                layoutParams3.bottomMargin = aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
                this.dWQ.sE().getView().setLayoutParams(layoutParams3);
            }
            if (this.dWQ != null && this.dWQ.sF() != null) {
                this.dWQ.sF().hide();
            }
            nL(0);
            nK(0);
        }
        if (this.eiy != null) {
            this.eiy.C(false, z);
        }
        if (this.dWR != null) {
            this.dWR.sL();
        }
        if (this.dWQ != null) {
            int equipmentHeight = (int) (((z ? 0.2f : 0.27f) * BdUtilHelper.getEquipmentHeight(aPZ().pageContext.getPageActivity())) + aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            if (aPZ().eeM.indexOfChild(this.dWQ.sE().getView()) != -1 && this.dWQ.sE().getView().getLayoutParams() != null) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.dWQ.sE().getView().getLayoutParams();
                layoutParams4.height = equipmentHeight;
                this.dWQ.sE().getView().setLayoutParams(layoutParams4);
            }
            this.dWQ.sE().sD();
        }
    }

    private void nK(int i) {
        if (this.dVS != null) {
            this.dVS.nx(i);
        }
        if (this.ehZ != null) {
            this.ehZ.setVisibility(i);
        }
        if (this.eiC != null) {
            this.eiC.setVisible(i);
        }
        if (this.eiB != null) {
            this.eiB.setVisibility(i);
        }
        if (this.dVZ != null) {
            this.dVZ.setVisible(i);
        }
        if (this.dXa != null) {
            this.dXa.setVisible(i);
        }
    }

    public void onError(int i, String str) {
        if (i == -1) {
            aPZ().efg.errCode = 1;
            aTK();
        } else if (i == -5) {
            aTL();
        } else if (i == -2) {
            tO(aPZ().pageContext.getResources().getString(a.i.preview_init_failed_dialog_msg));
            aPZ().efe.stopRecord();
        } else if (i == -3 && this.eiy != null) {
            this.eiy.hL(false);
        }
        if (i == -4) {
            if (this.eiy == null || this.eiy.getView().getParent() == null) {
                aPZ().c((short) 1);
                return;
            }
            this.eiy.aRD();
            this.eiQ.setVisibility(0);
            if (this.eiD != null) {
                this.eiD.in(true);
            }
            aPZ().eeM.setBackgroundColor(aPZ().pageContext.getResources().getColor(17170445));
            aTX();
        } else if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            BdStatisticsManager.getInstance().newDebug("liverecorder", 0L, null, "msg", "code " + i + " --- " + str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        aPs();
        if (i == 12001) {
            if (i2 == -1) {
                tP(ak(intent));
            }
        } else if (i == 12009) {
            if (i2 == -1) {
                al(intent);
            }
        } else if (i == 24009 && i2 == -1) {
            anY();
        }
    }

    public void onResume() {
        if (this.eiy != null) {
            this.eiy.onResume();
        }
        if (this.ejb && this.eja != null) {
            this.ejb = false;
            c(this.eja);
        }
    }

    public void d(short s) {
        if (this.dWP != null) {
            this.dWP.rt();
        }
        if (this.dWQ != null) {
            this.dWQ.a(null);
            this.dWQ.sk();
        }
        if (this.dWR != null) {
            this.dWR.sk();
        }
        if (this.ejr != null) {
            this.ejr.aQd();
        }
    }

    public boolean aTu() {
        com.baidu.live.data.i uk = aPZ().eeL.uk();
        if (this.dWQ != null) {
            this.dWQ.sE().a(String.valueOf(uk.mLiveInfo.group_id), String.valueOf(uk.mLiveInfo.live_id), true, String.valueOf(uk.OR.userId));
        }
        if (this.dWR != null) {
            this.dWR.b(uk);
        }
        if (this.dVS != null) {
            this.dVS.l(uk);
        }
        if (uk != null) {
            if (this.eiA != null) {
                this.eiA.h(uk);
            }
            if (this.ejr != null) {
                this.ejr.b(uk);
            }
            if (this.dWT != null && uk.mLiveInfo != null) {
                this.dWT.a(uk.mLiveInfo);
            }
            if (this.dVZ != null) {
                this.dVZ.g(uk);
            }
            if (uk.mLiveInfo.live_status != 1) {
                aTV();
                aPZ().pageContext.getPageActivity().finish();
                if (aPZ().eeL != null && aPZ().eeL.uk() != null) {
                    String str = null;
                    if (aPZ().eeL.aVj() != 1) {
                        str = aPZ().pageContext.getString(a.i.ala_live_end_authen_msg);
                    }
                    a(uk.mLiveInfo, 1, str);
                }
                return true;
            } else if (this.ejs) {
                this.eiS.setVisibility(0);
                if (this.ejq || uk.mLiveInfo == null) {
                    return false;
                }
                this.ejq = true;
                com.baidu.live.utils.m.i(uk.mLiveInfo.feed_id, uk.mLiveInfo.live_id);
                return false;
            } else {
                this.eiS.setVisibility(8);
                return false;
            }
        }
        return false;
    }

    public void aTv() {
        aTm();
    }

    public void aTw() {
        if (this.ejp != null) {
            this.ejp.aRv();
        }
    }

    public void aTx() {
        if (this.eiy != null && this.eiy.getVisibility() != 8) {
            if (aPZ().aRJ() == 2) {
                aTX();
            } else {
                aTW();
            }
        }
        if (this.eiy != null && this.eiy.getVisibility() != 8) {
            if (aPZ().aRJ() == 1) {
                this.eiy.onResume();
            }
            this.eiy.onRefresh();
        }
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.17
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        if (this.dXl && this.eiX != null) {
            if (this.eiI != null && this.eiI.getView() != null && this.eiI.getView().getParent() != null) {
                aPZ().AE.removeView(this.eiI.getView());
                if (this.dWQ != null) {
                    this.dWQ.sE().getView().setVisibility(0);
                }
            }
            if (this.dWQ != null) {
                this.dWQ.sF().show();
                this.dWQ.sF().setEditText(" @" + this.eiX.getNameShow() + HanziToPinyin.Token.SEPARATOR);
            }
            nL(8);
            this.dXl = false;
        }
        if (this.dWZ != null) {
            this.dWZ.resume();
        }
    }

    public void onPause() {
        if (this.dWZ != null) {
            this.dWZ.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTy() {
        aPZ().eeM.scrollOrigin();
    }

    private void aTz() {
        this.eiJ = (RelativeLayout) aPZ().AE.findViewById(a.g.ala_live_unremovable_host_top);
        this.ehZ = (RelativeLayout) aPZ().AE.findViewById(a.g.ala_live_removeable_top_container);
        this.dYK.eeM.setOnLiveViewScrollListener(this.ejE);
        if (this.dVX == null) {
            this.dVX = new com.baidu.tieba.ala.liveroom.audiencelist.b(this.dYK.pageContext.getPageActivity(), false);
        }
        this.dVX.a(this.dWv);
        this.dVX.a(this.ehZ, a.g.ala_live_room_host_header_stub, 1L);
        this.dVX.setVisible(0);
        this.eiL = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_host_close);
        this.eiL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.19
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.aTT();
            }
        });
        this.eiV = (FrameLayout) aPZ().AE.findViewById(a.g.ala_liveroom_host_pure_back_btn_layout);
        this.eiW = (FrameLayout) aPZ().AE.findViewById(a.g.ala_liveroom_host_close_btn_layout);
        this.eiM = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_pure_mode_back);
        this.eiM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaMasterLiveRoomOpearator.this.aTy();
            }
        });
        this.eiQ = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_host_beauty_btn);
        this.eiQ.setOnClickListener(this.eju);
        if (aPZ().efe.hasBeauty() < 0) {
            this.eiQ.setVisibility(8);
        } else {
            this.eiI = new com.baidu.tieba.ala.liveroom.views.b(aPZ().pageContext.getPageActivity(), com.baidu.live.c.np().getInt("live_beauty_level", 3));
            this.eiI.a(this.ejx);
        }
        this.eiP = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_host_share_btn);
        this.eiP.setOnClickListener(this.eju);
        this.eiN = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_host_message_btn);
        this.eiN.setOnClickListener(this.eju);
        this.dYS = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_host_pk_btn);
        this.dYS.setOnClickListener(this.eju);
        this.eiO = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_host_more);
        this.eiO.setOnClickListener(this.eju);
        this.eiR = (ImageView) aPZ().AE.findViewById(a.g.ala_liveroom_host_zan_btn);
        this.eiR.setOnClickListener(this.eju);
        this.eiS = aPZ().AE.findViewById(a.g.host_goods_layout);
        this.eiT = (ImageView) aPZ().AE.findViewById(a.g.host_goods_imageView);
        this.eiU = (TextView) aPZ().AE.findViewById(a.g.host_goods_num_textView);
        this.eiT.setOnClickListener(this.eju);
        aTE();
        aPd();
        aTD();
        this.ejp = new com.baidu.tieba.ala.liveroom.g.b(aPZ().AE, aPZ().pageContext.getPageActivity());
        this.ejp.setOnEffectSelectedListener(this.ejD);
        this.dWP = new m();
        aTA();
        aTB();
        if (this.dWS != null && this.dWS.pA() != null) {
            this.dWS.pA().bringToFront();
        }
    }

    private void aTA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913039, i.class, aPZ().pageContext);
        if (runTask != null && runTask.getData() != null) {
            this.dWQ = (i) runTask.getData();
            this.dWQ.setFromMaster(true);
            this.dWQ.sE().getView().setId(a.g.ala_liveroom_msg_list);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (BdUtilHelper.getEquipmentWidth(aPZ().pageContext.getPageActivity()) * 0.75f), ((int) (BdUtilHelper.getEquipmentHeight(aPZ().pageContext.getPageActivity()) * 0.27f)) + aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_tbds64));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds132) - aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16);
            aPZ().eeM.addView(this.dWQ.sE().getView(), layoutParams);
            this.dWQ.sF().hide();
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams2.addRule(12);
            aPZ().eeM.addView(this.dWQ.sF().getView(), layoutParams2);
            this.dWQ.a(new i.a() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.21
                @Override // com.baidu.live.im.i.a
                public boolean sG() {
                    return true;
                }

                @Override // com.baidu.live.im.i.a
                public void sH() {
                }

                @Override // com.baidu.live.im.i.a
                public void cH(String str) {
                }

                @Override // com.baidu.live.im.i.a
                public void sI() {
                }

                @Override // com.baidu.live.im.i.a
                public void sJ() {
                }
            });
        }
    }

    private void aTB() {
        this.dWR = new com.baidu.tieba.ala.liveroom.d.a(aPZ().pageContext);
        View sK = this.dWR.sK();
        if (sK != null && this.dYK.eeM.indexOfChild(sK) < 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.dYK.pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds80));
            layoutParams.addRule(2, a.g.ala_liveroom_msg_list);
            layoutParams.bottomMargin = aPZ().pageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds20);
            aPZ().eeM.addView(sK, layoutParams);
        }
    }

    private void aTC() {
        if (aPZ().efe != null) {
            com.baidu.tieba.ala.liveroom.data.c cVar = new com.baidu.tieba.ala.liveroom.data.c();
            cVar.tI(com.baidu.live.c.np().getString("ala_beauty_5.4_config_str", ""));
            aPZ().efe.onBlurLevelSelected(cVar.eeV);
            aPZ().efe.onFilterSelected(cVar.mFilterName);
            aPZ().efe.onColorLevelSelected((cVar.eeT * 1.0f) / 100.0f);
            aPZ().efe.onCheekThinSelected((cVar.eeX * 1.0f) / 100.0f);
            aPZ().efe.onEnlargeEyeSelected((cVar.eeW * 1.0f) / 100.0f);
            aPZ().efe.onRedLevelSelected((cVar.eeU * 1.0f) / 100.0f);
        }
    }

    private void aTD() {
        CustomResponsedMessage runTask;
        if (this.eiY == null && (runTask = MessageManager.getInstance().runTask(2913045, com.baidu.live.m.a.class, aPZ().pageContext.getPageActivity())) != null && runTask.getData() != null) {
            this.eiY = (com.baidu.live.m.a) runTask.getData();
        }
    }

    private void aTE() {
        View pA;
        q.b(aPZ().pageContext);
        com.baidu.live.gift.f fVar = new com.baidu.live.gift.f();
        fVar.VP = true;
        fVar.context = aPZ().pageContext.getPageActivity();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913028, r.class, fVar);
        if (runTask != null && runTask.getData() != null) {
            this.dWS = (r) runTask.getData();
            if (this.dWS != null && (pA = this.dWS.pA()) != null && aPZ().eeM.indexOfChild(pA) < 0) {
                if (pA.getParent() instanceof ViewGroup) {
                    ((ViewGroup) pA.getParent()).removeView(pA);
                }
                aPZ().eeM.addView(pA, aPZ().eeM.getLayoutParams());
            }
        }
    }

    protected void aPd() {
        View pN;
        if (this.dWT == null) {
            com.baidu.live.gift.a aVar = new com.baidu.live.gift.a();
            aVar.VP = true;
            aVar.context = aPZ().pageContext.getPageActivity();
            CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2913071, p.class, aVar);
            if (runTask != null && runTask.getData() != null) {
                this.dWT = (p) runTask.getData();
            }
        }
        if (this.dWT != null && (pN = this.dWT.pN()) != null) {
            if (aPZ().eeM.indexOfChild(pN) < 0) {
                if (pN.getParent() instanceof ViewGroup) {
                    ((ViewGroup) pN.getParent()).removeView(pN);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.topMargin = aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds220);
                aPZ().eeM.addView(pN, layoutParams);
            }
            pN.bringToFront();
        }
    }

    private void aTF() {
        aTI();
        aOn();
        aTH();
        aPZ().eeM.setVisibility(0);
        nL(0);
    }

    private void aTG() {
        if (this.eiC == null) {
            this.eiC = new com.baidu.tieba.ala.liveroom.p.a(aPZ().pageContext);
        }
        long j = JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
        this.eiC.a(aPZ().aRJ(), j, TbadkCoreApplication.getCurrentAccountName(), true, aPZ().eeL.uk().OR.portrait, this.otherParams, "", -1L);
        this.eiC.Z(aPZ().eeM);
    }

    private void aTH() {
        if (this.eiE == null) {
            this.eiE = new b(aPZ().pageContext, aPZ().eeM);
        }
    }

    private void aTI() {
        if (this.dVS == null) {
            this.dVS = new com.baidu.tieba.ala.liveroom.l.a(aPZ().pageContext, true, this.ejz);
            this.dVS.d(this.eiJ, null);
            this.dVS.a(this.dWv);
        }
        if (this.eiz == null) {
            this.eiz = new com.baidu.tieba.ala.liveroom.l.a(aPZ().pageContext, true, null);
            this.eiz.a(this.ehZ, null, a.g.ala_live_room_host_header_stub);
            this.eiz.aSF();
        }
    }

    private void e(com.baidu.live.data.i iVar) {
        if (this.dVZ == null) {
            this.dVZ = new com.baidu.tieba.ala.liveroom.activeview.b(aPZ().pageContext);
        }
        this.dVZ.setOtherParams(this.otherParams);
        this.dVZ.b(iVar, false);
        this.dVZ.setHost(true);
        this.dVZ.a(1, aPZ().eeM, nq(1));
        this.dVZ.a(2, aPZ().eeM, nq(2));
        this.dVZ.setVisible(this.eix ? 8 : 0);
    }

    private ViewGroup.LayoutParams nq(int i) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        switch (i) {
            case 1:
                if (UtilHelper.getRealScreenOrientation(aPZ().pageContext.getPageActivity()) == 1) {
                    layoutParams.addRule(9);
                    layoutParams.leftMargin = aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds24);
                } else {
                    layoutParams.addRule(5, a.g.ala_liveroom_charmview);
                }
                if (this.eiH != null) {
                    layoutParams.addRule(3, a.g.ala_live_room_stream_view);
                    layoutParams.topMargin = aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                } else {
                    layoutParams.addRule(3, a.g.ala_liveroom_charmview);
                    layoutParams.topMargin = aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
                    break;
                }
            case 2:
                int dimensionPixelSize = aPZ().pageContext.getResources().getDimensionPixelSize(a.e.sdk_ds6);
                layoutParams.width = ((int) (BdUtilHelper.getEquipmentWidth(aPZ().pageContext.getPageActivity()) * 0.25f)) - (dimensionPixelSize * 2);
                layoutParams.addRule(8, a.g.ala_liveroom_msg_list);
                layoutParams.addRule(11);
                layoutParams.rightMargin = dimensionPixelSize;
                break;
        }
        return layoutParams;
    }

    private void aOn() {
        if (this.eiB == null) {
            this.eiB = new com.baidu.tieba.ala.liveroom.b.a(aPZ().pageContext, true);
        }
    }

    private void aTJ() {
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isTieba()) {
            Activity pageActivity = aPZ().pageContext.getPageActivity();
            this.dXW = new ImageView(pageActivity);
            this.dXW.setImageResource(a.f.sdk_icon_bar_live_close_n);
            this.dXW.setBackgroundResource(a.f.sdk_round_btn_close_bg);
            this.dXW.setPadding(pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0, pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds4), 0);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            layoutParams.rightMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            layoutParams.topMargin = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            layoutParams.width = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            layoutParams.height = pageActivity.getResources().getDimensionPixelSize(a.e.sdk_ds56);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                layoutParams.topMargin += UtilHelper.getStatusBarHeight();
            }
            aPZ().AE.addView(this.dXW, layoutParams);
            this.dXW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.23
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaMasterLiveRoomOpearator.this.aTT();
                }
            });
            this.dXW.setVisibility(8);
        }
    }

    private void aOV() {
        this.dWZ = new com.baidu.tieba.ala.liveroom.f.a(aPZ().pageContext);
    }

    private void aPh() {
        if (this.dXa == null) {
            this.dXa = new com.baidu.tieba.ala.liveroom.j.a(aPZ().pageContext, true, this.otherParams);
        }
        if (aPZ().eeL.uk() != null && aPZ().eeL.uk().OR != null && aPZ().eeL.uk().mLiveInfo != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, a.g.ala_live_removeable_top_container);
            layoutParams.topMargin = aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds14);
            layoutParams.leftMargin = aPZ().pageContext.getPageActivity().getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.dXa.a(aPZ().eeM, layoutParams, aPZ().eeL.uk());
        }
    }

    public void onRtcConnected(int i) {
        if (this.ejr != null) {
            this.ejr.onRtcConnected(i);
        }
    }

    private void registerListener() {
        aPZ().pageContext.registerListener(this.dXv);
        aPZ().pageContext.registerListener(this.ejt);
        aPZ().pageContext.registerListener(this.dXx);
        aPZ().pageContext.registerListener(this.dXy);
        aPZ().pageContext.registerListener(this.ejv);
        aPZ().pageContext.registerListener(this.ehU);
        aPZ().pageContext.registerListener(this.dTU);
        aPZ().pageContext.registerListener(this.ejw);
        aPZ().pageContext.registerListener(this.dXw);
        aPZ().pageContext.registerListener(this.dXM);
        aPZ().pageContext.registerListener(this.ejG);
        aPZ().pageContext.registerListener(this.ejH);
        aPZ().pageContext.registerListener(this.ejI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hX(boolean z) {
        BdUtilHelper.hideSoftKeyPad(aPZ().pageContext.getPageActivity(), aPZ().AE);
        if (aPZ().eeM != null && this.eiI != null && this.eiI.getView() != null && this.eiI.getView().getParent() == null) {
            nL(8);
            if (aPZ().efe.hasAdvancedBeauty()) {
                if (this.ejp != null) {
                    this.ejp.b(aPZ().efe.getVideoConfig());
                }
            } else {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                aPZ().AE.addView(this.eiI.getView(), layoutParams);
            }
            if (z && this.dWQ != null) {
                this.dWQ.sE().getView().setVisibility(8);
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
    public void aTK() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPZ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.camera_open_failed_dialog_msg, currentAppType(aPZ().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.24
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.aPZ().c((short) 1);
            }
        });
        bdAlertDialog.create(aPZ().pageContext).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTL() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPZ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessageId(a.i.audio_open_failed_dialog_msg, currentAppType(aPZ().pageContext.getPageActivity()));
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.25
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.aPZ().c((short) 1);
            }
        });
        bdAlertDialog.create(aPZ().pageContext).show();
    }

    private void tO(String str) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPZ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle(a.i.sdk_prompt);
        bdAlertDialog.setMessage(str);
        bdAlertDialog.setTitleShowCenter(true);
        bdAlertDialog.setMessageShowCenter(true);
        bdAlertDialog.setPositiveButton(a.i.sdk_know, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.26
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                AlaMasterLiveRoomOpearator.this.aPZ().c((short) 1);
            }
        });
        bdAlertDialog.create(aPZ().pageContext).show();
    }

    public void aTM() {
        com.baidu.live.data.e aKw = aPZ().eeL.aKw();
        int i = 5;
        if (aKw != null) {
            i = (int) aKw.getInterval();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.27
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk() != null && AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo != null) {
                    AlaMasterLiveRoomOpearator.this.aPZ().eeL.cj(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo.live_id);
                }
            }
        }, i);
        if (aKw != null) {
            if (this.dVR == null) {
                this.dVR = new c(aPZ().pageContext, this.ejz, true);
            }
            if (this.ejn) {
                this.ejn = false;
                this.dVR.a(String.valueOf(aPZ().eeL.uk().mLiveInfo.group_id), String.valueOf(aPZ().eeL.uk().mLiveInfo.live_id), String.valueOf(aPZ().eeL.uk().OR.userId), aPZ().eeL.uk());
                this.dVR.c(this.ehZ, a.g.ala_live_room_host_header_stub, a.g.ala_liveroom_audience_count_layout);
            }
            this.dVR.e(aKw);
            this.dVX.setVisible(0);
            this.dVX.bU(aKw.getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTN() {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anY() {
        if (aPZ().eeL != null) {
            if (this.dWF == null) {
                this.dWF = new com.baidu.tieba.ala.liveroom.share.c(aPZ().pageContext);
            }
            this.dWF.c(aPZ().eeL.uk(), true);
            if (TbadkCoreApplication.getInst().isHaokan()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_SHARE_CLICK);
                if (aPZ().eeL != null && aPZ().eeL.uk() != null && aPZ().eeL.uk().mLiveInfo != null) {
                    alaStaticItem.addParams("live_id", aPZ().eeL.uk().mLiveInfo.live_id + "");
                    alaStaticItem.addParams("room_id", aPZ().eeL.uk().mLiveInfo.room_id + "");
                    alaStaticItem.addParams("feed_id", aPZ().eeL.uk().mLiveInfo.feed_id + "");
                }
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem2 = new AlaStaticItem(QMStaticKeys.QM_STATIC_SHARE_CLICK);
                if (aPZ().eeL != null && aPZ().eeL.uk() != null && aPZ().eeL.uk().mLiveInfo != null) {
                    alaStaticItem2.addParams("live_id", aPZ().eeL.uk().mLiveInfo.live_id + "");
                    alaStaticItem2.addParams("room_id", aPZ().eeL.uk().mLiveInfo.room_id + "");
                    alaStaticItem2.addParams("feed_id", aPZ().eeL.uk().mLiveInfo.feed_id + "");
                }
                alaStaticItem2.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem2);
            }
        }
    }

    private boolean aTO() {
        return this.eiw;
    }

    private void hY(boolean z) {
        SharedPrefHelper.getInstance().putBoolean(eiv, z);
        this.eiw = z;
    }

    private void aTP() {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPZ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(a.i.is_allow_follow_confirm);
        bdAlertDialog.setPositiveButton(a.i.is_allow_follow_confirm_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.28
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                new com.baidu.tieba.ala.liveroom.m.a(AlaMasterLiveRoomOpearator.this.aPZ().pageContext).aUK();
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.setNegativeButton(a.i.is_allow_follow_confirm_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.29
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
            }
        });
        bdAlertDialog.create(aPZ().pageContext).show();
    }

    private void aTQ() {
        if (this.eif && aPZ().pageContext.getPageActivity().getRequestedOrientation() != 0) {
            aPZ().efh.vt();
        }
        aPZ().efg.prepareTime = System.currentTimeMillis() - aPZ().efg.prepareTime;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_RECORD_STAYTIME);
            if (aPZ().eeL != null && aPZ().eeL.uk() != null && aPZ().eeL.uk().mLiveInfo != null) {
                alaStaticItem.addParams("live_id", aPZ().eeL.uk().mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", aPZ().eeL.uk().mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", aPZ().efg.prepareTime / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.eiy != null && this.eiy.getView().getParent() != null) {
            this.eiy.setVisibility(8);
            aPZ().AE.removeView(this.eiy.getView());
            this.eiy.release();
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        if (aPZ().eeM.indexOfChild(this.eiG) < 0) {
            aPZ().eeM.addView(this.eiG, layoutParams);
        }
        this.eiG.ob(1000);
    }

    private void aPs() {
        if (aPZ().aRJ() == 1) {
            aPZ().efe.startRecord();
        }
    }

    private void tP(String str) {
        tQ(str);
    }

    private void tQ(String str) {
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            EditHeadActivityConfig editHeadActivityConfig = new EditHeadActivityConfig((Context) aPZ().pageContext.getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, (int) RequestResponseCode.REQUEST_ALBUM_IMAGE_VIEW, (Uri) null, 3, str, 1.0f, false);
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
        if (intent != null && (fromJson = PhotoUrlData.fromJson(intent.getStringExtra(EditHeadActivityConfig.PIC_INFO))) != null && this.eiy != null) {
            this.eiy.tH(fromJson.getSmallurl());
        }
    }

    private boolean aTR() {
        return com.baidu.live.c.np().getBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTS() {
        com.baidu.live.c.np().putBoolean(com.baidu.live.c.getSharedPrefKeyWithAccount("key_mirror_status"), this.dYK.efe.isPushMirror());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTT() {
        int i = a.i.live_close_confirm;
        if (this.ejr != null && this.ejr.aQf()) {
            i = a.i.ala_pk_pking_close_live_roon_tip;
        } else if (this.ejr != null && this.ejr.aQe()) {
            i = a.i.ala_challenge_challenging_close_live_room_tip;
        }
        BdAlertDialog bdAlertDialog = new BdAlertDialog(aPZ().pageContext.getPageActivity());
        bdAlertDialog.setAutoNight(false);
        bdAlertDialog.setTitle((String) null);
        bdAlertDialog.setMessageId(i);
        bdAlertDialog.setPositiveButton(a.i.sdk_dialog_ok, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.31
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                AlaStaticsManager.getInst().onStatic(new AlaStaticItem(SdkStaticKeys.CLICK_MASTERLIVE_CLOSEBTN));
                bdAlertDialog2.dismiss();
                if (AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk() != null) {
                    AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo, 0, AlaMasterLiveRoomOpearator.this.aPZ().eeL.aVj() != 1 ? AlaMasterLiveRoomOpearator.this.aPZ().pageContext.getString(a.i.ala_live_end_authen_msg) : null);
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
        bdAlertDialog.create(aPZ().pageContext).show();
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
            aPZ().eeL.cq(Long.toString(alaLiveInfoData.live_id), str2);
        }
        if (!this.ejl) {
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = aPZ().efg;
            alaLiveRecorderPerfData.liveTotalTime = System.currentTimeMillis() - alaLiveRecorderPerfData.liveTotalTime;
            AlaLiveDebugInfo recorderDebugInfo = aPZ().efe.getRecorderDebugInfo();
            if (recorderDebugInfo != null) {
                alaLiveRecorderPerfData.dropACount = recorderDebugInfo.totalDropA;
                alaLiveRecorderPerfData.dropCount = recorderDebugInfo.totalDropCount;
                alaLiveRecorderPerfData.dropICount = recorderDebugInfo.totalDropI;
                alaLiveRecorderPerfData.dropPCount = recorderDebugInfo.totalDropP;
            }
            alaLiveRecorderPerfData.showTime = System.currentTimeMillis() - alaLiveRecorderPerfData.startLiveTime;
            alaLiveRecorderPerfData.waitTime = alaLiveRecorderPerfData.linkTime + alaLiveRecorderPerfData.prepareTime + alaLiveRecorderPerfData.updateTime;
            Long[] lArr = new Long[1];
            alaLiveRecorderPerfData.prictureFlow = (lArr[0] == null ? 0L : lArr[0].longValue()) - this.ejh;
            alaLiveRecorderPerfData.IMFlow = (lArr[0] != null ? lArr[0].longValue() : 0L) - this.eji;
            alaLiveRecorderPerfData.dataFlow = alaLiveRecorderPerfData.prictureFlow + alaLiveRecorderPerfData.IMFlow;
            alaLiveRecorderPerfData.isCharging = this.ejd;
            if (this.eje != 0) {
                alaLiveRecorderPerfData.energyUsage = ((this.ejf - this.ejg) / this.eje) * 100.0f;
            }
            Intent intent = new Intent(aPZ().pageContext.getPageActivity(), AlaLiveEndActivity.class);
            intent.putExtra("liveInfoData", alaLiveInfoData.getJsonString());
            if (aPZ().eeL != null && aPZ().eeL.uk() != null && aPZ().eeL.uk().OR != null) {
                String str3 = aPZ().eeL.uk().OR.nickName;
                String str4 = aPZ().eeL.uk().OR.userName;
                if (!TextUtils.isEmpty(str3)) {
                    str4 = str3;
                }
                intent.putExtra("user_nickname", str4);
            }
            intent.putExtra("fromType", i);
            intent.putExtra("authen_msg", str);
            intent.putExtra("live_perf_data", alaLiveRecorderPerfData.getJsonString());
            com.baidu.live.data.i uk = aPZ().eeL.uk();
            if (uk != null && uk.OR != null && !TextUtils.isEmpty(uk.OR.portrait)) {
                intent.putExtra("host_portrait", uk.OR.portrait);
            }
            short s = i == 1 ? (short) 3 : (short) 2;
            if (this.isBackground) {
                this.ejj = intent;
                this.ejk = s;
                aPZ().pageContext.showToast(a.i.ala_live_background_close_tip);
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
    public void aTU() {
        if (this.ejj != null) {
            a(this.ejj, this.ejk);
            this.ejj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Intent intent, short s) {
        this.ejl = true;
        if (this.ejr != null) {
            this.ejr.onDestroy();
        }
        if (intent != null) {
            aPZ().pageContext.getPageActivity().startActivity(intent);
        }
        aPZ().c(s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTV() {
        MessageManager.getInstance().sendMessage(new CustomMessage(CmdConfigCustom.CMD_SHARE_DIALOG_DISMISS));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913004));
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ejr != null && this.ejr.onKeyDown(i, keyEvent)) {
                return true;
            }
            if (aPZ().eff.aUy()) {
                aTT();
                return true;
            }
        }
        return false;
    }

    public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        int i3 = 0;
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            this.eiH.setVisibility(4);
            return;
        }
        this.eiH.a(i, z, i2, z2);
        if (this.dYK != null && this.dYK.eeL != null) {
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    i3 = 1;
                } else if (i2 == 4 || i2 == 5) {
                    i3 = 2;
                }
            }
            if (this.ejo != i3) {
                this.ejo = i3;
                if (this.eiF == null) {
                    this.eiF = new com.baidu.tieba.ala.liveroom.tippop.a(this.dYK.pageContext, null);
                }
                switch (this.ejo) {
                    case 0:
                        this.eiF.a(this.dYK.AE, this.dYK.pageContext.getString(a.i.ala_master_live_net_tip_1), 1);
                        break;
                    case 1:
                        this.eiF.a(this.dYK.AE, this.dYK.pageContext.getString(a.i.ala_master_live_net_tip_2), 1);
                        break;
                    case 2:
                        this.eiF.a(this.dYK.AE, this.dYK.pageContext.getString(a.i.ala_master_live_net_tip_3), 1);
                        break;
                }
                this.dYK.eeL.j(this.dYK.eeL.uk().mLiveInfo.live_id, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        String str;
        JSONObject jSONObject2;
        long j;
        long j2;
        long j3;
        if (aVar.getMsgType() == 125) {
            if (this.eiD != null) {
                this.eiD.u(aVar);
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
            if (this.ejr != null) {
                this.ejr.bT(str);
            }
            if ("close_live".equals(str)) {
                this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.34
                    @Override // java.lang.Runnable
                    public void run() {
                        AlaMasterLiveRoomOpearator.this.aTV();
                        AlaMasterLiveRoomOpearator.this.a(AlaMasterLiveRoomOpearator.this.aPZ().eeL.uk().mLiveInfo, 1, str2);
                    }
                });
            } else if ("live_admin".equals(str)) {
                if (aPZ().eeL.uk() != null) {
                    long optLong = jSONObject.optLong("user_id");
                    int optInt = jSONObject.optInt("opt_type");
                    if (optInt == 1) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aPZ().eeL.uk().Pj.isAdmin = 1;
                        }
                    } else if (optInt == 2) {
                        if (optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                            aPZ().eeL.uk().Pj.isAdmin = 0;
                        }
                    } else if (optInt == 3 && optLong == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L)) {
                        aPZ().eeL.uk().Pj.isAdmin = 0;
                    }
                }
            } else if ("task".equals(str)) {
                if (this.eiY != null) {
                    this.eiY.z(jSONObject);
                }
            } else if (!"live_achievement".equals(str)) {
                if ("enter_live".equals(str)) {
                    String optString = jSONObject.optString("share_enter_msg");
                    int optInt2 = jSONObject.optInt("share_enter_interval");
                    if (!TextUtils.isEmpty(optString)) {
                        this.eiE.al(optString, optInt2);
                    }
                    if (this.dVX.getCount() > 20) {
                        this.dVX.bU(this.dVX.getCount() + 1);
                    } else if (this.dVR != null) {
                        com.baidu.live.data.a tf = aVar.tf();
                        com.baidu.live.data.d dVar = new com.baidu.live.data.d();
                        dVar.OT = new AlaLocationData();
                        dVar.OU = new AlaRelationData();
                        dVar.OR = new AlaLiveUserInfoData();
                        dVar.OR.userId = JavaTypesHelper.toLong(tf.userId, 0L);
                        dVar.OR.userName = tf.userName;
                        dVar.OR.portrait = tf.portrait;
                        if (this.dVR.c(dVar)) {
                            this.dVX.bU(this.dVX.getCount() + 1);
                        }
                    }
                } else if ("ui_event".equals(str)) {
                    if (jSONObject.optInt("event_type") == 1001 && aPZ().eeL.uk() != null && aPZ().eeL.uk().mLiveInfo != null) {
                        String str3 = aPZ().eeL.uk().mLiveInfo.feed_id;
                        long j4 = aPZ().eeL.uk().mLiveInfo.live_id;
                        long optLong2 = jSONObject.optLong("id");
                        if (!l.g(j4, optLong2)) {
                            com.baidu.live.utils.m.i(str3, j4);
                            l.h(j4, optLong2);
                        }
                    }
                } else if ("need_update_live_mark_info".equals(str) && jSONObject != null && aPZ() != null && aPZ().eeL != null && aPZ().eeL.uk() != null && aPZ().eeL.uk().Pj != null && aPZ().eeL.uk().Pj.userId == jSONObject.optLong("user_id")) {
                    aPZ().eeL.aUY();
                }
            }
        } else if (aVar.getMsgType() == 24) {
            com.baidu.live.data.a tf2 = aVar.tf();
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
                if (aPZ().eeL == null || aPZ().eeL.uk() == null || aPZ().eeL.uk().mLiveInfo == null) {
                    j = 0;
                    j2 = 0;
                    j3 = 0;
                } else {
                    long j5 = aPZ().eeL.uk().mLiveInfo.live_id;
                    long j6 = aPZ().eeL.uk().mLiveInfo.group_id;
                    long j7 = aPZ().eeL.uk().OR.userId;
                    str4 = aPZ().eeL.uk().mLiveInfo.appId;
                    j = j7;
                    j2 = j6;
                    j3 = j5;
                }
                if (!this.isBackground || aPZ().aRJ() != 2) {
                    q.b(optString2, Integer.parseInt(optString3), optString4, optString5, tf2.userId, tf2.portrait, tf2.getNameShow(), String.valueOf(j3), String.valueOf(j2), true, String.valueOf(j), str4, optString6);
                }
                tv(optString2);
            } catch (JSONException e4) {
            }
        }
    }

    private void tv(String str) {
        if (this.dVZ != null) {
            this.dVZ.tv(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nL(int i) {
        View findViewById = aPZ().AE.findViewById(a.g.ala_live_host_bottom);
        View findViewById2 = aPZ().AE.findViewById(a.g.ala_live_unremovable_bottom);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
        if (findViewById2 != null) {
            findViewById2.setVisibility(i);
        }
        if (this.dVZ != null) {
            this.dVZ.aP(2, i);
        }
    }

    private void aTW() {
        this.mHandler.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator.35
            @Override // java.lang.Runnable
            public void run() {
                if (AlaMasterLiveRoomOpearator.this.aPZ().efe != null && AlaMasterLiveRoomOpearator.this.aPZ().efe.getPreview() != null) {
                    AlaMasterLiveRoomOpearator.this.aPZ().efe.getPreview().setVisibility(0);
                    AlaMasterLiveRoomOpearator.this.aPZ().efe.startRecord();
                }
            }
        });
    }

    private void aTX() {
        if (aPZ().efe != null && aPZ().efe.getPreview() != null) {
            aPZ().efe.getPreview().setVisibility(8);
            aPZ().efe.stopRecord();
        }
    }

    public void aTY() {
        this.efb = aPZ().eeL.aVk();
        if (this.eiy != null) {
            this.eiy.hM(this.efb);
        }
    }

    public void aRH() {
        if (this.eiy != null) {
            this.eiy.aRH();
        }
    }

    public void onDestroy() {
        if (this.ejc != null) {
            BdBaseApplication.getInst().unregisterReceiver(this.ejc);
        }
        this.ejc = null;
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.ejp != null) {
            this.ejp.hK(true);
        }
        this.ejp = null;
        if (this.eiy != null) {
            this.eiy.destroy();
            aPZ().AE.removeView(this.eiy.getView());
            this.eiy.release();
            this.eiy = null;
        }
        if (this.ejr != null) {
            this.ejr.onDestroy();
        }
        if (this.dWF != null) {
            this.dWF.onDestroy();
        }
        if (this.dWH != null) {
            this.dWH.onDestroy();
        }
        if (this.dVS != null) {
            this.dVS.onDestroy();
            this.dVS = null;
        }
        if (this.eiz != null) {
            this.eiz.onDestroy();
        }
        if (this.eiG != null) {
            this.eiG.stopCountDown();
        }
        if (this.eiC != null) {
            this.eiC.onDestroy();
        }
        if (this.eiE != null) {
            this.eiE.onDestroy();
        }
        if (this.eiY != null) {
            this.eiY.onDestroy();
            this.eiY = null;
        }
        if (this.dWS != null) {
            this.dWS.onDestroy();
            this.dWS = null;
        }
        q.pO();
        if (this.dWT != null) {
            this.dWT.onDestroy();
            this.dWT = null;
        }
        if (this.eiF != null) {
            this.eiF.onDestroy();
        }
        if (this.eiD != null) {
            this.eiD.aXb();
            this.eiD.release();
        }
        if (this.dVX != null) {
            this.dVX = null;
        }
        if (this.dVZ != null) {
            this.dVZ.release();
        }
        if (this.eiA != null) {
            this.eiA.onDestroy();
        }
        if (this.eiD != null) {
            this.eiD.onDestroy();
        }
        if (this.dWR != null) {
            this.dWR.release();
        }
        if (this.dWZ != null) {
            this.dWZ.release();
        }
        if (this.dXa != null) {
            this.dXa.onDestroy();
        }
        MessageManager.getInstance().unRegisterListener(this.dXM);
        MessageManager.getInstance().unRegisterListener(this.ejG);
        MessageManager.getInstance().unRegisterListener(this.ejH);
        MessageManager.getInstance().unRegisterListener(this.ejI);
        l.wt();
    }
}
