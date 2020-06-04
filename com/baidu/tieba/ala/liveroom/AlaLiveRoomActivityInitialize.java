package com.baidu.tieba.ala.liveroom;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.c.k;
import com.baidu.live.f.c;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UrlManager;
import java.util.Map;
/* loaded from: classes3.dex */
public class AlaLiveRoomActivityInitialize {
    static {
        bws();
        bwt();
        bww();
        bwv();
        bwx();
        bwu();
    }

    private static void bws() {
    }

    public static void bwt() {
        UrlManager.getInstance().addListener(new UrlManager.UrlDealListener() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomActivityInitialize.1
            /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
                if (com.baidu.live.adp.lib.util.StringUtils.isNull(r0) == false) goto L21;
             */
            @Override // com.baidu.live.tbadk.core.util.UrlManager.UrlDealListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                String str;
                Map<String, String> paramPair;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.startsWith("http://tieba.baidu.com/ala/share?") || lowerCase.startsWith("https://tieba.baidu.com/ala/share?") || lowerCase.startsWith("http://tieba.baidu.com/ala/share/live") || lowerCase.startsWith("https://tieba.baidu.com/ala/share/live")) {
                    String paramStr = UrlManager.getParamStr(lowerCase);
                    if (!StringUtils.isNull(paramStr) && (paramPair = UrlManager.getParamPair(paramStr)) != null) {
                        str = paramPair.get("from_type");
                    }
                    str = "share_play";
                    AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(tbPageContext.getPageActivity());
                    alaLiveRoomActivityConfig.addExtraByUrl(lowerCase, null, str);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                    return 1;
                }
                return 3;
            }
        });
    }

    private static void bwu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913078, new CustomMessageTask.CustomRunnable<c>() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomActivityInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<c> customMessage) {
                return new CustomResponsedMessage<>(2913078, customMessage.getData());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bwv() {
    }

    private static void bww() {
        TbadkCoreApplication.getInst().RegisterIntent(k.class, AlaLiveFloatWindowActivity.class);
    }

    private static void bwx() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_PERSON_ALA_ENTRANCE_LIVE_ID) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveRoomActivityInitialize.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                    long longValue = ((Long) customResponsedMessage.getData()).longValue();
                    long j = com.baidu.live.c.uN().getLong("ala_live_room_last_live_id", -1L);
                    if (j > 0 && longValue > 0 && j == longValue) {
                        com.baidu.live.c.uN().putBoolean("ala_person_ala_entrance_same_live_room", true);
                    } else {
                        com.baidu.live.c.uN().putBoolean("ala_person_ala_entrance_same_live_room", false);
                    }
                    com.baidu.live.c.uN().remove("ala_live_room_last_live_id");
                }
            }
        });
    }
}
