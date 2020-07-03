package com.baidu.tieba.ala.frsgamelive;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.ala.atomdata.AlaAllGameLiveEntryActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaFrsStoryLiveGatherActivityConfig;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity;
import com.baidu.tieba.ala.frsgamelive.mvc.a;
import com.baidu.tieba.ala.gamefrslivelist.AlaGameFrsLiveListActivity;
import com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.al;
/* loaded from: classes3.dex */
public class AlaFrsLiveStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaFrsStoryLiveGatherActivityConfig.class, AlaFrsStoryLiveGatherActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlaGameFrsLiveListActivityConfig.class, AlaGameFrsLiveListActivity.class);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER, TbConfig.SERVER_ADDRESS + AlaConfig.ALA_GET_FRS_STORY_LIVE_LIST);
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaFrsStoryLiveGatherRespMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_FRS_STORY_LIVE_GATHER);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
        tbHttpMessageTask2.setIsNeedLogin(true);
        tbHttpMessageTask2.setIsNeedTbs(true);
        tbHttpMessageTask2.setIsNeedAddCommenParam(true);
        tbHttpMessageTask2.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask2.setResponsedClass(AlaGameFrsLiveThreadsRespMessage.class);
        MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.CMD_ALA_LIVE_FRS_GAME);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof al) {
                        al alVar = (al) data;
                        a aVar = new a(true);
                        aVar.getFragmentTabStructure().type = 2;
                        aVar.setForumId(alVar.getForumId());
                        aVar.setForumName(alVar.getForumName());
                        aVar.setForumGameLabel(alVar.getForumGameLabel());
                        aVar.setFromType(1);
                        aVar.ki(false);
                        alVar.b(aVar);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ak) {
                        ak akVar = (ak) data;
                        a aVar = new a(true);
                        aVar.getFragmentTabStructure().type = 9;
                        aVar.setForumId(akVar.getForumId());
                        aVar.setForumName(akVar.getForumName());
                        aVar.setForumGameLabel(akVar.getForumGameLabel());
                        aVar.setFromType(1);
                        aVar.ki(true);
                        if (akVar.uO(9)) {
                            akVar.b(aVar);
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_ADD_TAB) { // from class: com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof al) {
                        al alVar = (al) data;
                        a aVar = new a(false);
                        aVar.getFragmentTabStructure().type = 1;
                        aVar.setForumId(alVar.getForumId());
                        aVar.setForumName(alVar.getForumName());
                        aVar.setForumGameLabel(alVar.getForumGameLabel());
                        aVar.setFromType(2);
                        aVar.ki(false);
                        alVar.b(aVar);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_LIVE_TAB_ADD_TAB) { // from class: com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof al) {
                        al alVar = (al) data;
                        com.baidu.tieba.ala.gamefrslivetab.video.a aVar = new com.baidu.tieba.ala.gamefrslivetab.video.a();
                        aVar.getFragmentTabStructure().type = 3;
                        aVar.setForumId(alVar.getForumId());
                        aVar.setForumName(alVar.getForumName());
                        aVar.kj(false);
                        alVar.b(aVar);
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ak) {
                        ak akVar = (ak) data;
                        com.baidu.tieba.ala.gamefrslivetab.video.a aVar = new com.baidu.tieba.ala.gamefrslivetab.video.a();
                        aVar.getFragmentTabStructure().type = 8;
                        aVar.getFragmentTabStructure().textResId = R.string.ala_video;
                        aVar.setForumId(akVar.getForumId());
                        aVar.setForumName(akVar.getForumName());
                        aVar.kj(true);
                        if (akVar.uO(8)) {
                            akVar.b(aVar);
                        }
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_GAME_FRS_ADD_TAB) { // from class: com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    Object data = customResponsedMessage.getData();
                    if (data instanceof ak) {
                        ak akVar = (ak) data;
                        com.baidu.tieba.ala.gamebar.a aVar = new com.baidu.tieba.ala.gamebar.a();
                        aVar.setForumId(akVar.getForumId());
                        aVar.setForumName(akVar.getForumName());
                        aVar.setForumGameLabel(akVar.getForumGameLabel());
                        aVar.a(akVar);
                    }
                }
            }
        });
        CustomMessageTask customMessageTask = new CustomMessageTask(AlaCmdConfigCustom.CMD_ALA_ALL_GAME_LIVE_ENTRY, new CustomMessageTask.CustomRunnable<AlaAllGameLiveEntryActivityConfig>() { // from class: com.baidu.tieba.ala.frsgamelive.AlaFrsLiveStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<AlaAllGameLiveEntryActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(AlaAllGameLiveEntryActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
