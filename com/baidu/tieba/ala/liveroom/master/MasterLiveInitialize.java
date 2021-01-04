package com.baidu.tieba.ala.liveroom.master;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaMasterLiveRoomActivityConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.liveroom.messages.GuardClubInfoRenameResponseMessage;
/* loaded from: classes11.dex */
public class MasterLiveInitialize {
    static {
        clt();
        clu();
    }

    private static void clt() {
        TbadkCoreApplication.getInst().RegisterIntent(AlaMasterLiveRoomActivityConfig.class, AlaMasterLiveRoomActivity.class);
    }

    private static void clu() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021231, TbConfig.SERVER_HOST + "liveserver/guardClub/updateClubName");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuardClubInfoRenameResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
