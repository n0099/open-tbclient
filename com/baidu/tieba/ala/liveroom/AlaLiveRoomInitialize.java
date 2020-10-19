package com.baidu.tieba.ala.liveroom;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.activity.TransparentActivity;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.base.BdActivityStack;
import com.baidu.live.adp.base.BdPageContextSupport;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.listener.NetMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.message.ResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.w;
import com.baidu.live.c;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.gift.ac;
import com.baidu.live.gift.z;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaGetUserInfoHttpResponseMessage;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.message.GetSuperCustomerInfoHttpResponseMessage;
import com.baidu.live.message.GetUserInfoHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
import com.baidu.live.message.NotifyOfficialMsgHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UrlManager;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.tieba.a.b;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaPreLoadMarkImgResponseMessage;
import com.baidu.tieba.ala.liveroom.messages.ClosePageRecHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.share.AlaShareMsgCallHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.task.ActivityTaskWatchHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class AlaLiveRoomInitialize {
    private static com.baidu.live.k.a gCd;
    private static CustomMessageListener gCe;
    private static CustomMessageListener gCf;
    private static CustomMessageListener gCg;
    private static HttpMessageListener gCh;
    private static CustomMessageListener gCi;
    private static NetMessageListener gCj;
    private static CustomMessageListener gCk;
    private static HttpMessageListener gyS;
    private static boolean gCa = false;
    private static boolean gCb = false;
    private static BdAlertDialog gCc = null;
    private static BdUniqueId ggI = BdUniqueId.gen();

    static {
        bQE();
        bQF();
        bQG();
        bQH();
        initTasks();
        bQI();
        bQY();
        bQZ();
        TbadkCoreApplication.getInst().RegisterIntent(w.class, TransparentActivity.class);
        gCe = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean unused = AlaLiveRoomInitialize.gCb = true;
                AlaLiveRoomInitialize.bQW();
            }
        };
        gCf = new CustomMessageListener(2913020) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        gCg = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!BdNetTypeUtil.isNetWorkAvailable() || !AlaLiveRoomInitialize.gCb || !AlaLiveRoomInitialize.gCa || MessageManager.getInstance().findTask(2913060) == null) {
                }
            }
        };
        gCh = new HttpMessageListener(1021117) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaPreLoadMarkImgResponseMessage) {
                    AlaLiveRoomInitialize.cb(((AlaPreLoadMarkImgResponseMessage) httpResponsedMessage).cag());
                }
            }
        };
        gCi = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getOrginalMessage() instanceof com.baidu.live.tieba.a.a)) {
                    com.baidu.live.tieba.a.a aVar = (com.baidu.live.tieba.a.a) customResponsedMessage.getOrginalMessage();
                    List<Object> originData = aVar.getOriginData();
                    List<Long> ids = aVar.getIds();
                    if (!ListUtils.isEmpty(originData) && !ListUtils.isEmpty(ids)) {
                        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isLiveSwitchUnabled()) {
                            com.baidu.live.liveroom.messages.a aVar2 = new com.baidu.live.liveroom.messages.a();
                            aVar2.setOriginData(originData);
                            aVar2.setListIds(ids);
                            aVar2.setTag(AlaLiveRoomInitialize.ggI);
                            aVar2.setParams();
                            MessageManager.getInstance().sendMessageFromBackground(aVar);
                        }
                    }
                }
            }
        };
        gCj = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.11
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == AlaLiveRoomInitialize.ggI) {
                    List<Long> list = null;
                    if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                        list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                    }
                    if (!ListUtils.isEmpty(list)) {
                        MessageManager.getInstance().sendMessageFromBackground(new b(list));
                    }
                }
            }
        };
        gyS = new HttpMessageListener(1021039) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.12
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    final AlaLivePersonData Nj = httpResponsedMessage instanceof AlaGetUserInfoHttpResponseMessage ? ((AlaGetUserInfoHttpResponseMessage) httpResponsedMessage).Nj() : null;
                    if (Nj != null && Nj.mLiveInfo != null) {
                        if (Nj.mLiveInfo.live_id != c.AZ().getLong("last_live_room_id", 0L) || Nj.mLiveInfo.live_status != 1) {
                            if (AlaLiveRoomInitialize.gCd == null) {
                                if (AlaLiveRoomInitialize.gCc != null) {
                                    AlaLiveRoomInitialize.gCc.dismiss();
                                }
                                BdAlertDialog unused = AlaLiveRoomInitialize.gCc = null;
                            } else {
                                com.baidu.live.k.a unused2 = AlaLiveRoomInitialize.gCd = null;
                            }
                            AlaLiveRoomInitialize.bQV();
                            return;
                        }
                        if (AlaLiveRoomInitialize.gCd == null) {
                            if (AlaLiveRoomInitialize.gCc == null || !AlaLiveRoomInitialize.gCc.isShowing()) {
                                SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.12.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AlaLiveRoomInitialize.c(Nj);
                                    }
                                }, 100L);
                            }
                        } else {
                            AlaLiveRoomInitialize.gCd.a(Nj);
                            com.baidu.live.k.a unused3 = AlaLiveRoomInitialize.gCd = null;
                        }
                        AlaLiveRoomInitialize.bQV();
                    }
                }
            }
        };
        gCk = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_STICKY) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean unused = AlaLiveRoomInitialize.gCa = true;
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().unRegisterListener(AlaLiveRoomInitialize.gCk);
                    }
                });
            }
        };
    }

    private static void bQE() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SYNC, TbConfig.SERVER_ADDRESS + "ala/sys/sync");
        tbHttpMessageTask.setResponsedClass(AlaSyncHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQF() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021132, TbConfig.SERVER_HOST + "liveserver/sys/sync");
        tbHttpMessageTask.setResponsedClass(LiveSyncHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021122, TbConfig.SERVER_ADDRESS + "ala/web/demo/getLiveActivity");
        tbHttpMessageTask.setResponsedClass(GetLiveActivityHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setRetry(1);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQH() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021126, TbConfig.SERVER_ADDRESS + "ala/web/activityRank/getActivityPendantRank");
        tbHttpMessageTask.setResponsedClass(GetLiveActivityDynamicHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void initTasks() {
        bQJ();
        bQK();
        bQL();
        bQM();
        bQN();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            bQc();
            bQO();
        }
        bQP();
        bQQ();
        bQR();
        bQS();
        bQT();
        bQU();
        bRa();
        bRb();
        bRc();
    }

    private static void bQI() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(gCe);
            MessageManager.getInstance().registerListener(gCf);
            MessageManager.getInstance().registerListener(gCg);
            MessageManager.getInstance().registerListener(gCh);
            MessageManager.getInstance().registerListener(gCj);
            MessageManager.getInstance().registerListener(gCi);
            MessageManager.getInstance().registerListener(gCk);
        }
    }

    private static void bQJ() {
        com.baidu.live.tieba.f.a.a.a(1021007, "ala/live/getLiveInfo", AlaGetLiveInfoHttpResponseMessage.class, false, true, true, true).setRetry(1);
    }

    private static void bQK() {
        com.baidu.live.tieba.f.a.a.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, com.baidu.tbadk.TbConfig.URL_ALA_LIVE_ROOM_CLOSED, AlaMGetLiveStatusHttpResponseMessage.class, false, true, true, true).setRetry(1);
    }

    private static void bQL() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021036, TbConfig.SERVER_ADDRESS + "ala/live/closeLive");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCloseLiveHttpResonpnseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerStickyMode(1021036);
    }

    private static void bQM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003303, TbConfig.SERVER_ADDRESS + "ala/sys/strategy");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetVerifyStrategyResponseHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerStickyMode(1003303);
    }

    private static void bQN() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021117, TbConfig.SERVER_ADDRESS + "ala/sys/getAllMarkPictList");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaPreLoadMarkImgResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021039, TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoSDK");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQO() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021040, TbConfig.SERVER_ADDRESS + "ala/sys/reliveLog");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021127, TbConfig.SERVER_ADDRESS + "ala/live/activityTaskWatch");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(ActivityTaskWatchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021128, TbConfig.SERVER_ADDRESS + "ala/live/sendNoticeIm");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.live.n.a.init();
    }

    private static void bQR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021045, TbConfig.SERVER_ADDRESS + "ala/share/shareMsg");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaShareMsgCallHttpResonpnseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQS() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/pay/barrage");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(ImBarragePayResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQT() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021157, TbConfig.SERVER_HOST + "liveserver/rotaryTable/getLuckyMomentsInfoForMobile");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setRetry(1);
        tbHttpMessageTask.setResponsedClass(TurnTableLuckyMomentsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bQU() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021125, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getUserInfo");
        tbHttpMessageTask.setResponsedClass(GetUserInfoHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bQV() {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.13
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().unRegisterListener(AlaLiveRoomInitialize.gyS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bQW() {
        if (System.currentTimeMillis() - c.AZ().getLong("ala_last_pre_load_marg_img_time", 0L) >= 21600000) {
            MessageManager.getInstance().sendMessage(new HttpMessage(1021117));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cb(List<String> list) {
        if (!ListUtils.isEmpty(list)) {
            c.AZ().putLong("ala_last_pre_load_marg_img_time", System.currentTimeMillis());
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    BdResourceLoader.getInstance().loadResource(str, 10, null, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void es(long j) {
        HttpMessage httpMessage = new HttpMessage(1021040);
        httpMessage.addParam("live_id", j);
        httpMessage.addParam("is_cancel", 1);
        MessageManager.getInstance().sendMessage(httpMessage);
        HttpMessage httpMessage2 = new HttpMessage(1021036);
        httpMessage2.addParam("live_id", j);
        httpMessage2.addParam("close_reason", "4");
        httpMessage2.setTag(BdUniqueId.gen());
        MessageManager.getInstance().sendMessage(httpMessage2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final AlaLivePersonData alaLivePersonData) {
        final Activity currentActivity = BdActivityStack.getInst().currentActivity();
        if (currentActivity instanceof BdPageContextSupport) {
            if (gCc != null) {
                gCc.dismiss();
            }
            gCc = new BdAlertDialog(currentActivity);
            TbadkCoreApplication.getInst().getContext();
            gCc.setMessageId(a.i.sdk_crash_reopen_tips);
            gCc.setOnCalcelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.14
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AlaLiveRoomInitialize.es(AlaLivePersonData.this.mLiveInfo.live_id);
                    BdAlertDialog unused = AlaLiveRoomInitialize.gCc = null;
                }
            });
            gCc.setPositiveButton(a.i.sdk_reconnect, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(currentActivity, alaLivePersonData)));
                    AlaLiveRoomInitialize.bQX();
                    BdAlertDialog unused = AlaLiveRoomInitialize.gCc = null;
                }
            });
            gCc.setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.3
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaLiveRoomInitialize.bQX();
                    bdAlertDialog.dismiss();
                    AlaLiveRoomInitialize.es(AlaLivePersonData.this.mLiveInfo.live_id);
                    BdAlertDialog unused = AlaLiveRoomInitialize.gCc = null;
                }
            });
            gCc.isShowTitleAndMessage();
            gCc.create(((BdPageContextSupport) currentActivity).getPageContext());
            gCc.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bQX() {
        c.AZ().putLong("last_live_room_id", 0L);
        c.AZ().putString("last_live_room_from", "");
    }

    private static void bQY() {
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.5
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlDealListener
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> paramPair;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str)) {
                    return 3;
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT_ZM)) {
                    long j = c.AZ().getLong("zm_cert_id", 0L);
                    if (j != 0) {
                        com.baidu.live.l.b bVar = new com.baidu.live.l.b();
                        bVar.hC(Long.toString(j));
                        bVar.release();
                    }
                    c.AZ().putLong("zm_cert_id", 0L);
                    return 0;
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT)) {
                    if (tbPageContext != null && (paramPair = UrlManager.getParamPair(UrlManager.getParamStrBehindScheme(str))) != null) {
                        String str2 = paramPair.get(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID);
                        String str3 = paramPair.get(BdStatsConstant.StatsKey.UNAME);
                        String str4 = paramPair.get("rtmpurl");
                        if (StringUtils.isNull(str2)) {
                            if (!StringUtils.isNull(str3)) {
                                try {
                                    String decode = URLDecoder.decode(str3, "UTF-8");
                                    if (StringUtils.isNull(str4)) {
                                        str4 = "";
                                    }
                                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                                    alaLiveRoomActivityConfig.addExtraByUrl(str4, decode, "safari_play");
                                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                                    return 0;
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                    return 0;
                                }
                            }
                            tbPageContext.showToast(tbPageContext.getResources().getString(a.i.ala_entry_live_failed));
                            return 0;
                        }
                        Long valueOf = Long.valueOf(Long.parseLong(str2));
                        if (valueOf.longValue() <= 0) {
                            tbPageContext.showToast(tbPageContext.getResources().getString(a.i.live_over_name));
                            return 0;
                        }
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = valueOf.longValue();
                        try {
                            if (!StringUtils.isNull(str4)) {
                                alaLiveInfoCoreData.rtmpUrl = URLDecoder.decode(str4, "UTF-8");
                            }
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                        if (!StringUtils.isNull(str3)) {
                            alaLiveInfoCoreData.userName = str3;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig2 = new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                        alaLiveRoomActivityConfig2.addExtraByScheme(alaLiveInfoCoreData, "safari_play", "", false, "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig2));
                        return 0;
                    }
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_LIVE_SHARE)) {
                    if (TbadkCoreApplication.isLogin()) {
                        TiebaInitialize.log("c12744");
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913062));
                    return 1;
                } else if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_JUMP_LIVE_ROOM)) {
                    long j2 = JavaTypesHelper.toLong(WebviewHelper.getMatchStringFromURL(str, "liveId="), 0L);
                    String matchStringFromURL = WebviewHelper.getMatchStringFromURL(str, "uname=");
                    if (j2 == 0) {
                        if (StringUtils.isNull(matchStringFromURL)) {
                            return 3;
                        }
                        AlaLiveRoomActivityConfig alaLiveRoomActivityConfig3 = new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                        alaLiveRoomActivityConfig3.addExtraByUrl("", matchStringFromURL, "active_view_jump_live_room");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig3));
                        return 1;
                    }
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig4 = new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig4.addExtraByLiveId(j2, "", "active_view_jump_live_room");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig4));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void bQZ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913170, new CustomMessageTask.CustomRunnable<ac>() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.6
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<z> run(CustomMessage<ac> customMessage) {
                return new CustomResponsedMessage<>(2913170, new com.baidu.tieba.ala.liveroom.r.b(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bRa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021184, TbConfig.SERVER_ADDRESS + "ala/notify/msgNotify");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(NotifyOfficialMsgHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bRb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021186, TbConfig.SERVER_HOST + "liveserver/liveactivity/getsupercustomerinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetSuperCustomerInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bRc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021207, TbConfig.SERVER_ADDRESS + "ala/live/closePageRec");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(ClosePageRecHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
