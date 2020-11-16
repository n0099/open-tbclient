package com.baidu.tieba.ala.guardclub;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.guardclub.GuardClubInfoHttpResponseMessage;
import com.baidu.live.guardclub.GuardClubJoinHttpResponseMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atom.GuardClubRankActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubJoinListActivityConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubMemberListActivityConfig;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.guardclub.model.GuardClubInfoRenameResponseMessage;
/* loaded from: classes4.dex */
public class GuardClubInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubInfoActivityConfig.class, GuardClubInfoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubMemberListActivityConfig.class, GuardClubMemberListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubJoinListActivityConfig.class, GuardClubJoinListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(GuardClubRankActivityConfig.class, GuardClubRankActivity.class);
        bPz();
        bSu();
        bSv();
        bSw();
        bSx();
    }

    private static void bPz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913159, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.guardclub.GuardClubInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.guardclub.h> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913159, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913160, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.guardclub.GuardClubInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.guardclub.j> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913160, new c(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2913161, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.ala.guardclub.GuardClubInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.guardclub.k> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2913161, new h(customMessage.getData()));
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2913162, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.guardclub.GuardClubInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<View> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913162, LayoutInflater.from(customMessage.getData()).inflate(a.g.toast_guard_club_guide, (ViewGroup) null));
            }
        });
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
    }

    private static void bSu() {
        com.baidu.live.guardclub.e.a(b.bSq());
    }

    private static void bSv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021137, TbConfig.SERVER_HOST + "liveserver/guardClub/info");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.GET);
        tbHttpMessageTask.setResponsedClass(GuardClubInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bSw() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS, TbConfig.SERVER_HOST + "liveserver/guardClub/join");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuardClubJoinHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bSx() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021142, TbConfig.SERVER_HOST + "liveserver/guardClub/updateClubName");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(GuardClubInfoRenameResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
