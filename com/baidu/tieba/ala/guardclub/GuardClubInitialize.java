package com.baidu.tieba.ala.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atom.GuardClubRankActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubJoinListActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubMemberListActivityConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoHttpResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoRenameResponseMessage;
import com.baidu.tieba.ala.guardclub.model.GuardClubJoinHttpResponseMessage;
/* loaded from: classes2.dex */
public class GuardClubInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubInfoActivityConfig.class, GuardClubInfoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubMemberListActivityConfig.class, GuardClubMemberListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubJoinListActivityConfig.class, GuardClubJoinListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubRankActivityConfig.class, GuardClubRankActivity.class);
        bcP();
        bcQ();
        bcR();
    }

    private static void bcP() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021137, TbConfig.SERVER_HOST + "liveserver/guardClub/info");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bcQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS, TbConfig.SERVER_HOST + "liveserver/guardClub/join");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bcR() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021142, TbConfig.SERVER_HOST + "liveserver/guardClub/updateClubName");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuardClubInfoRenameResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
