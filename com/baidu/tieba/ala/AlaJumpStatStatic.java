package com.baidu.tieba.ala;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.sapi2.SapiAccount;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import d.a.i0.m0.l;
/* loaded from: classes4.dex */
public class AlaJumpStatStatic {

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.c.f.b {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // d.a.c.c.f.f
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            Object data;
            if (customMessage != null && customMessageTask == null && (data = customMessage.getData()) != null) {
                AlaJumpStatStatic.b(data, data.getClass().getSimpleName());
            }
            return customMessage;
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends d.a.c.c.f.b {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // d.a.c.c.f.f
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            Object data;
            if (customMessage != null && (data = customMessage.getData()) != null) {
                String simpleName = data.getClass().getSimpleName();
                if (("AlaLiveRoomActivityConfig".equals(simpleName) || "AlaMasterLiveRoomActivityConfig".equals(simpleName) || "AlaWriteShareInBarActivityConfig".equals(simpleName) || "AlaLiveFloatWindowActivityConfig".equals(simpleName) || "AlaPersonCenterActivityConfig".equals(simpleName)) && TbadkCoreApplication.getInst().getIntentClass(data.getClass()) == null) {
                    AlaJumpStatStatic.b(data, simpleName);
                }
            }
            return customMessage;
        }
    }

    static {
        MessageManager.getInstance().addMessageRule(new a(2911003));
        MessageManager.getInstance().addMessageRule(new b(2002001));
    }

    public static final void b(Object obj, String str) {
        d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
        statsItem.b("workflow", "ala_jump_fail");
        statsItem.b("config", str);
        statsItem.c("startTime", Long.valueOf(System.currentTimeMillis() - l.b().c()));
        if (obj instanceof AlaLiveRoomActivityConfig) {
            AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = (AlaLiveRoomActivityConfig) obj;
            statsItem.b(SapiAccount.SAPI_ACCOUNT_FROMTYPE, alaLiveRoomActivityConfig.getIntent().getStringExtra(AlaLiveRoomActivityConfig.LIVE_FROM_TYPE));
            statsItem.b("liveUname", alaLiveRoomActivityConfig.getIntent().getStringExtra("user_name"));
            try {
                AlaLiveInfoCoreData alaLiveInfoCoreData = (AlaLiveInfoCoreData) alaLiveRoomActivityConfig.getIntent().getSerializableExtra("live_info_core");
                if (alaLiveInfoCoreData != null) {
                    statsItem.c("hostUid", Long.valueOf(alaLiveInfoCoreData.userID));
                    statsItem.b("hostUname", alaLiveInfoCoreData.userName);
                    statsItem.c(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, Long.valueOf(alaLiveInfoCoreData.liveID));
                }
            } catch (Throwable th) {
                BdLog.e(th);
            }
        }
        BdStatisticsManager.getInstance().debug("tiebalive", statsItem);
    }
}
