package com.baidu.tieba.ala.liveroom.master;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.messages.GuardClubInfoRenameResponseMessage;
/* loaded from: classes10.dex */
public class MasterLiveInitialize {
    static {
        chC();
        chD();
    }

    private static void chC() {
        TbadkCoreApplication.getInst().RegisterIntent(AlaMasterLiveRoomActivityConfig.class, AlaMasterLiveRoomActivity.class);
    }

    private static void chD() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021231, TbConfig.SERVER_HOST + "liveserver/guardClub/updateClubName");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuardClubInfoRenameResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
