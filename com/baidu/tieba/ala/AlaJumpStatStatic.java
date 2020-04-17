package com.baidu.tieba.ala;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.n.n;
/* loaded from: classes.dex */
public class AlaJumpStatStatic {
    static {
        MessageManager.getInstance().addMessageRule(new com.baidu.adp.framework.a.b(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) { // from class: com.baidu.tieba.ala.AlaJumpStatStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.f
            public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                Object data;
                if (customMessage != null && customMessageTask == null && (data = customMessage.getData()) != null) {
                    AlaJumpStatStatic.e(data, data.getClass().getSimpleName());
                }
                return customMessage;
            }
        });
        MessageManager.getInstance().addMessageRule(new com.baidu.adp.framework.a.b(CmdConfigCustom.START_GO_ACTION) { // from class: com.baidu.tieba.ala.AlaJumpStatStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.a.f
            public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                Object data;
                if (customMessage != null && (data = customMessage.getData()) != null) {
                    String simpleName = data.getClass().getSimpleName();
                    if (("AlaLiveRoomActivityConfig".equals(simpleName) || "AlaMasterLiveRoomActivityConfig".equals(simpleName) || "AlaWriteShareInBarActivityConfig".equals(simpleName) || "AlaLiveFloatWindowActivityConfig".equals(simpleName) || "AlaPersonCenterActivityConfig".equals(simpleName)) && TbadkCoreApplication.getInst().getIntentClass(data.getClass()) == null) {
                        AlaJumpStatStatic.e(data, simpleName);
                    }
                }
                return customMessage;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Object obj, String str) {
        com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
        statsItem.append("workflow", "ala_jump_fail");
        statsItem.append("config", str);
        statsItem.append("startTime", Long.valueOf(System.currentTimeMillis() - n.aZF().aZE()));
        if (obj instanceof AlaLiveRoomActivityConfig) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) obj;
            statsItem.append("fromType", alaLiveRoomActivityConfig.getIntent().getStringExtra("live_from_type"));
            statsItem.append("liveUname", alaLiveRoomActivityConfig.getIntent().getStringExtra("user_name"));
            try {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) alaLiveRoomActivityConfig.getIntent().getSerializableExtra("live_info_core");
                if (alaLiveInfoCoreData != null) {
                    statsItem.append("hostUid", Long.valueOf(alaLiveInfoCoreData.userID));
                    statsItem.append("hostUname", alaLiveInfoCoreData.userName);
                    statsItem.append(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(alaLiveInfoCoreData.liveID));
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        BdStatisticsManager.getInstance().debug("tiebalive", statsItem);
    }
}
