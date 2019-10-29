package com.baidu.tieba.ala.liveroom;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
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
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.adp.lib.resourceloader.BdResourceLoader;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.c;
import com.baidu.live.data.AlaLivePersonData;
import com.baidu.live.entereffect.http.EnterEffectDynamicListHttpResponsedMessage;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.k.a;
import com.baidu.live.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.live.message.AlaGetLiveInfoHttpResponseMessage;
import com.baidu.live.message.AlaGetUserInfoHttpResponseMessage;
import com.baidu.live.message.AlaSyncHttpResponseMessage;
import com.baidu.live.message.EventPollingHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.message.GetQuickGiftHttpResponseMessage;
import com.baidu.live.message.GetVideoGoodsListHttpResponseMessage;
import com.baidu.live.message.LiveSyncHttpResponseMessage;
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
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaGetVerifyStrategyResponseHttpMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaPreLoadMarkImgResponseMessage;
import com.baidu.tieba.ala.liveroom.share.AlaShareMsgCallHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.task.ActivityTaskWatchHttpResponseMessage;
import com.baidu.tieba.ala.liveroom.turntable.lucky.TurnTableLuckyMomentsResponseMessage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class AlaLiveRoomInitialize {
    private static CustomMessageListener dUJ;
    private static CustomMessageListener dUK;
    private static CustomMessageListener dUL;
    private static HttpMessageListener dUM;
    private static CustomMessageListener dUN;
    private static NetMessageListener dUO;
    private static HttpMessageListener dUP;
    private static CustomMessageListener dUQ;
    private static boolean dUG = false;
    private static boolean dUH = false;
    private static BdAlertDialog dUI = null;
    private static BdUniqueId dFZ = BdUniqueId.gen();

    static {
        aMY();
        aMZ();
        aNa();
        aNb();
        aNc();
        initTasks();
        aNd();
        aNw();
        dUJ = new CustomMessageListener(CmdConfigCustom.MAINTAB_ADD_FRAGMENT) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean unused = AlaLiveRoomInitialize.dUH = true;
                AlaLiveRoomInitialize.aNu();
            }
        };
        dUK = new CustomMessageListener(2913020) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            }
        };
        dUL = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (!BdNetTypeUtil.isNetWorkAvailable() || !AlaLiveRoomInitialize.dUH || !AlaLiveRoomInitialize.dUG || MessageManager.getInstance().findTask(2913060) == null) {
                }
            }
        };
        dUM = new HttpMessageListener(1021117) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage instanceof AlaPreLoadMarkImgResponseMessage) {
                    AlaLiveRoomInitialize.bA(((AlaPreLoadMarkImgResponseMessage) httpResponsedMessage).aUF());
                }
            }
        };
        dUN = new CustomMessageListener(CmdConfigCustom.CMD_LIVE_VIDEO_CLOSED_QUERY) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.9
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
                            aVar2.setTag(AlaLiveRoomInitialize.dFZ);
                            aVar2.setParams();
                            MessageManager.getInstance().sendMessageFromBackground(aVar);
                        }
                    }
                }
            }
        };
        dUO = new NetMessageListener(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.10
            @Override // com.baidu.live.adp.framework.listener.NetMessageListener
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == AlaLiveRoomInitialize.dFZ) {
                    List<Long> list = null;
                    if (responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage) {
                        list = ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds();
                    }
                    if (!ListUtils.isEmpty(list)) {
                        MessageManager.getInstance().sendMessageFromBackground(new com.baidu.live.tieba.a.b(list));
                    }
                }
            }
        };
        dUP = new HttpMessageListener(1021039) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.11
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    final AlaLivePersonData uk = httpResponsedMessage instanceof AlaGetUserInfoHttpResponseMessage ? ((AlaGetUserInfoHttpResponseMessage) httpResponsedMessage).uk() : null;
                    if (uk != null && uk.mLiveInfo != null) {
                        if (uk.mLiveInfo.live_id != c.np().getLong("last_live_room_id", 0L) || uk.mLiveInfo.live_status != 1) {
                            if (AlaLiveRoomInitialize.dUI != null) {
                                AlaLiveRoomInitialize.dUI.dismiss();
                            }
                            BdAlertDialog unused = AlaLiveRoomInitialize.dUI = null;
                            AlaLiveRoomInitialize.aNv();
                            AlaLiveRoomInitialize.aNt();
                            return;
                        }
                        if (AlaLiveRoomInitialize.dUI == null || !AlaLiveRoomInitialize.dUI.isShowing()) {
                            SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AlaLiveRoomInitialize.a(uk);
                                }
                            }, 100L);
                        }
                        AlaLiveRoomInitialize.aNt();
                    }
                }
            }
        };
        dUQ = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE_STICKY) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                boolean unused = AlaLiveRoomInitialize.dUG = true;
                if (AlaLiveRoomInitialize.dUH) {
                }
                SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MessageManager.getInstance().unRegisterListener(AlaLiveRoomInitialize.dUQ);
                    }
                });
            }
        };
    }

    private static void aMY() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_SYNC, TbConfig.SERVER_ADDRESS + "ala/sys/sync");
        tbHttpMessageTask.setResponsedClass(AlaSyncHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aMZ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021132, TbConfig.SERVER_HOST + "liveserver/sys/sync");
        tbHttpMessageTask.setResponsedClass(LiveSyncHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021122, TbConfig.SERVER_ADDRESS + "ala/web/demo/getLiveActivity");
        tbHttpMessageTask.setResponsedClass(GetLiveActivityHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        HashMap hashMap = new HashMap();
        hashMap.put("_client_version", TbConfig.getSubappVersionName());
        tbHttpMessageTask.setCommonParams(hashMap);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNb() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021126, TbConfig.SERVER_ADDRESS + "ala/web/activityRank/getActivityPendantRank");
        tbHttpMessageTask.setResponsedClass(GetLiveActivityDynamicHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021124, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getQuickGift");
        tbHttpMessageTask.setResponsedClass(GetQuickGiftHttpResponseMessage.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setRetry(10);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void initTasks() {
        aNe();
        aNf();
        aNg();
        aNh();
        aNi();
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            aNj();
            aNk();
        }
        aNl();
        aNm();
        aNn();
        aNo();
        aNp();
        aNq();
        aNr();
        aNs();
    }

    private static void aNd() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            MessageManager.getInstance().registerListener(dUJ);
            MessageManager.getInstance().registerListener(dUK);
            MessageManager.getInstance().registerListener(dUL);
            MessageManager.getInstance().registerListener(dUM);
            MessageManager.getInstance().registerListener(dUO);
            MessageManager.getInstance().registerListener(dUN);
            MessageManager.getInstance().registerListener(dUQ);
        }
    }

    private static void aNe() {
        com.baidu.live.tieba.f.a.a.a(1021007, "ala/live/getLiveInfo", AlaGetLiveInfoHttpResponseMessage.class, false, true, true, true);
    }

    private static void aNf() {
        com.baidu.live.tieba.f.a.a.a(AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, "ala/live/mgetLiveStatus", AlaMGetLiveStatusHttpResponseMessage.class, false, true, true, true);
    }

    private static void aNg() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021036, TbConfig.SERVER_ADDRESS + "ala/live/closeLive");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaCloseLiveHttpResonpnseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerStickyMode(1021036);
    }

    private static void aNh() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003303, TbConfig.SERVER_ADDRESS + "ala/sys/strategy");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetVerifyStrategyResponseHttpMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerStickyMode(1003303);
    }

    private static void aNi() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021117, TbConfig.SERVER_ADDRESS + "ala/sys/getAllMarkPictList");
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaPreLoadMarkImgResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNj() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021039, TbConfig.SERVER_ADDRESS + "ala/user/getUserInfoSDK");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaGetUserInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNk() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021040, TbConfig.SERVER_ADDRESS + "ala/sys/reliveLog");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNl() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021127, TbConfig.SERVER_ADDRESS + "ala/live/activityTaskWatch");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(ActivityTaskWatchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNm() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021128, TbConfig.SERVER_ADDRESS + "ala/live/sendNoticeIm");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        com.baidu.live.f.a.init();
    }

    private static void aNn() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021045, TbConfig.SERVER_ADDRESS + "ala/share/shareMsg");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaShareMsgCallHttpResonpnseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNo() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT, TbConfig.SERVER_HOST + "liveserver/pay/barrage");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(ImBarragePayResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNp() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_GET_TAB_LIVE_INFO, TbConfig.SERVER_ADDRESS + "ala/sdk/v1/open/getRmbLiveEnterEffectList");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(EnterEffectDynamicListHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNq() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021144, TbConfig.SERVER_HOST + "liveserver/livegoods/getvideogoodslist");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GetVideoGoodsListHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNr() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP, TbConfig.SERVER_HOST + "liveserver/sys/eventpolling");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(EventPollingHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void aNs() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021155, TbConfig.SERVER_HOST + "liveserver/rotaryTable/getLuckyMomentsInfoForMobile");
        tbHttpMessageTask.setIsNeedLogin(false);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(TurnTableLuckyMomentsResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aNt() {
        SafeHandler.getInst().post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.12
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().unRegisterListener(AlaLiveRoomInitialize.dUP);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aNu() {
        if (System.currentTimeMillis() - c.np().getLong("ala_last_pre_load_marg_img_time", 0L) >= 21600000) {
            MessageManager.getInstance().sendMessage(new HttpMessage(1021117));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bA(List<String> list) {
        if (!ListUtils.isEmpty(list)) {
            c.np().putLong("ala_last_pre_load_marg_img_time", System.currentTimeMillis());
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    BdResourceLoader.getInstance().loadResource(str, 10, null, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cd(long j) {
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
    public static void a(final AlaLivePersonData alaLivePersonData) {
        final Activity currentActivity = BdActivityStack.getInst().currentActivity();
        if (currentActivity instanceof BdPageContextSupport) {
            if (dUI != null) {
                dUI.dismiss();
            }
            dUI = new BdAlertDialog(currentActivity);
            TbadkCoreApplication.getInst().getContext();
            dUI.setMessageId(a.i.sdk_crash_reopen_tips);
            dUI.setOnCalcelListener(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.13
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    AlaLiveRoomInitialize.cd(AlaLivePersonData.this.mLiveInfo.live_id);
                    BdAlertDialog unused = AlaLiveRoomInitialize.dUI = null;
                }
            });
            dUI.setPositiveButton(a.i.sdk_reconnect, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.2
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    bdAlertDialog.dismiss();
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaMasterLiveRoomActivityConfig(currentActivity, alaLivePersonData)));
                    AlaLiveRoomInitialize.aNv();
                    BdAlertDialog unused = AlaLiveRoomInitialize.dUI = null;
                }
            });
            dUI.setNegativeButton(a.i.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomInitialize.3
                @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
                public void onClick(BdAlertDialog bdAlertDialog) {
                    AlaLiveRoomInitialize.aNv();
                    bdAlertDialog.dismiss();
                    AlaLiveRoomInitialize.cd(AlaLivePersonData.this.mLiveInfo.live_id);
                    BdAlertDialog unused = AlaLiveRoomInitialize.dUI = null;
                }
            });
            dUI.isShowTitleAndMessage();
            dUI.create(((BdPageContextSupport) currentActivity).getPageContext());
            dUI.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aNv() {
        c.np().putLong("last_live_room_id", 0L);
        c.np().putString("last_live_room_from", "");
    }

    private static void aNw() {
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
                    long j = c.np().getLong("zm_cert_id", 0L);
                    if (j != 0) {
                        com.baidu.live.e.a aVar = new com.baidu.live.e.a();
                        aVar.cN(Long.toString(j));
                        aVar.release();
                    }
                    c.np().putLong("zm_cert_id", 0L);
                    return 0;
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_TB_CLIENT)) {
                    if (tbPageContext != null && (paramPair = UrlManager.getParamPair(UrlManager.getParamStrBehindScheme(str))) != null) {
                        String str2 = paramPair.get("liveid");
                        String str3 = paramPair.get(BdStatsConstant.StatsKey.UNAME);
                        String str4 = paramPair.get("rtmpurl");
                        if (StringUtils.isNull(str2)) {
                            if (!StringUtils.isNull(str3)) {
                                try {
                                    String decode = URLDecoder.decode(str3, HTTP.UTF_8);
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
                                alaLiveInfoCoreData.rtmpUrl = URLDecoder.decode(str4, HTTP.UTF_8);
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
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaLiveRoomActivityConfig3));
                        return 1;
                    }
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig4 = new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig4.addExtraByLiveId(j2, "", "active_view_jump_live_room");
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaLiveRoomActivityConfig4));
                    return 1;
                }
                return 3;
            }
        });
    }
}
