package com.baidu.tieba;

import android.app.Activity;
import android.app.Application;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.publisher.base.PublisherConfig;
import com.baidu.searchbox.ugc.model.AtUserInfoItem;
import com.baidu.searchbox.ugc.service.AtService;
import com.baidu.searchbox.ugc.upload.CompressImageUtil;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.data.h;
import com.baidu.tieba.publisher.a.p;
/* loaded from: classes12.dex */
public class PublisherInitStatic {
    static {
        aUe();
        aUa();
        aUd();
        aUb();
        aUc();
    }

    private static void aUa() {
        com.baidu.pyramid.runtime.service.e.a(AtService.SERVICE_REFERENCE, new com.baidu.tieba.publisher.service.c());
        UgcServerApiUtils.setHostAddress(UgcServerApiUtils.ONLINE_HOST_ADRESS);
        UgcServerApiUtils.setPublisherUserAgent(UgcServerApiUtils.DEFAULT_PUBLISHER_USER_AGENT);
        UgcServerApiUtils.setTagFilterHostAddress(UgcServerApiUtils.ONLINE_HOST_ADRESS);
        PublisherConfig.setIsCloseUnlegoFunc(true);
        PublisherConfig.setIsCloseVideoDraft(true);
        PublisherConfig.setIsCloseCaptureSelectPic(true);
        PublisherConfig.setIsShowCamera(true);
        PublisherConfig.setIsShowEmojiTips(false);
        CompressImageUtil.setCompressValue(80);
        e.aUy().n(TbadkCoreApplication.getInst(), false);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.PublisherInitStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                    e.aUy().n(TbadkCoreApplication.getInst(), false);
                }
            }
        });
    }

    private static void aUb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921427, new CustomMessageTask.CustomRunnable<com.baidu.tbadk.data.b>() { // from class: com.baidu.tieba.PublisherInitStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.data.b> customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof com.baidu.tbadk.data.b)) {
                    com.baidu.tbadk.data.b data = customMessage.getData();
                    new com.baidu.tieba.publisher.a.a().postAtSelectEvent(new AtUserInfoItem("@" + data.aLk(), data.getUk()));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aUc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921430, new CustomMessageTask.CustomRunnable<com.baidu.tbadk.data.g>() { // from class: com.baidu.tieba.PublisherInitStatic.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.data.g> customMessage) {
                if (customMessage == null || customMessage.getData() == null || !(customMessage.getData() instanceof com.baidu.tbadk.data.g)) {
                    return null;
                }
                com.baidu.tbadk.data.g data = customMessage.getData();
                if (data.type == 0) {
                    return new CustomResponsedMessage<>(2921430, Boolean.valueOf(e.aUy().isLogin()));
                }
                if (data.type == 1) {
                    e.aUy().n(TbadkApplication.getInst(), true);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aUd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921426, new CustomMessageTask.CustomRunnable<h>() { // from class: com.baidu.tieba.PublisherInitStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<h> customMessage) {
                if (customMessage != null && customMessage.getData() != null && (customMessage.getData() instanceof h) && bc.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                    h data = customMessage.getData();
                    Activity activity = data.activity;
                    if ((activity == null || activity.isFinishing()) && (activity = com.baidu.adp.base.a.eG().currentActivity()) == null) {
                        activity = TbadkCoreApplication.getInst().getCurrentActivity();
                    }
                    if (activity != null && !activity.isFinishing()) {
                        switch (data.drf) {
                            case 1:
                                e.b(activity, data);
                                break;
                            case 2:
                                e.a(activity, data);
                                break;
                            case 4:
                                e.c(activity, data);
                                break;
                        }
                    }
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aUe() {
        new com.baidu.tieba.publisher.b.a(TbadkCoreApplication.getInst());
        com.baidu.b.a.a.nh().setAppName("tieba");
        a.f(TbadkCoreApplication.getInst());
        PublisherConfig.setPublisherVersion(2);
        p.fk(TbadkCoreApplication.getInst());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        public static void f(Application application) {
        }
    }
}
