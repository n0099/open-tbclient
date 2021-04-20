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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaFrsStoryLiveGatherActivityConfig;
import com.baidu.tbadk.core.atomData.AlaGameFrsLiveListActivityConfig;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.frsgamelive.message.AlaFrsStoryLiveGatherRespMessage;
import com.baidu.tieba.ala.frsgamelive.message.AlaGameFrsLiveThreadsRespMessage;
import com.baidu.tieba.ala.frsgamelive.mvc.AlaFrsStoryLiveGatherActivity;
import com.baidu.tieba.ala.gamefrslivelist.AlaGameFrsLiveListActivity;
import com.baidu.tieba.ala.gamelist.mvc.AlaAllGameLiveEntryActivity;
import d.b.i0.q0.j0;
import d.b.i0.q0.k0;
/* loaded from: classes4.dex */
public class AlaFrsLiveStatic {

    /* loaded from: classes4.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof k0) {
                k0 k0Var = (k0) data;
                d.b.i0.t.e.c.a aVar = new d.b.i0.t.e.c.a(true);
                aVar.getFragmentTabStructure().f50552e = 2;
                aVar.b(k0Var.c());
                aVar.c(k0Var.d());
                aVar.a(k0Var.b());
                aVar.d(1);
                aVar.e(false);
                k0Var.a(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof j0) {
                j0 j0Var = (j0) data;
                d.b.i0.t.e.c.a aVar = new d.b.i0.t.e.c.a(true);
                aVar.getFragmentTabStructure().f50552e = 9;
                aVar.b(j0Var.d());
                aVar.c(j0Var.e());
                aVar.a(j0Var.c());
                aVar.d(1);
                aVar.e(true);
                if (j0Var.i(9)) {
                    j0Var.a(aVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof k0) {
                k0 k0Var = (k0) data;
                d.b.i0.t.e.c.a aVar = new d.b.i0.t.e.c.a(false);
                aVar.getFragmentTabStructure().f50552e = 1;
                aVar.b(k0Var.c());
                aVar.c(k0Var.d());
                aVar.a(k0Var.b());
                aVar.d(2);
                aVar.e(false);
                k0Var.a(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d extends CustomMessageListener {
        public d(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof k0) {
                k0 k0Var = (k0) data;
                d.b.i0.t.g.a.a aVar = new d.b.i0.t.g.a.a();
                aVar.getFragmentTabStructure().f50552e = 3;
                aVar.a(k0Var.c());
                aVar.b(k0Var.d());
                aVar.c(false);
                k0Var.a(aVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e extends CustomMessageListener {
        public e(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof j0) {
                j0 j0Var = (j0) data;
                d.b.i0.t.g.a.a aVar = new d.b.i0.t.g.a.a();
                aVar.getFragmentTabStructure().f50552e = 8;
                aVar.getFragmentTabStructure().f50549b = R.string.ala_video;
                aVar.a(j0Var.d());
                aVar.b(j0Var.e());
                aVar.c(true);
                if (j0Var.i(8)) {
                    j0Var.a(aVar);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class f extends CustomMessageListener {
        public f(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof j0) {
                j0 j0Var = (j0) data;
                d.b.i0.t.f.a aVar = new d.b.i0.t.f.a();
                aVar.c(j0Var.d());
                aVar.d(j0Var.e());
                aVar.b(j0Var.c());
                aVar.a(j0Var);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class g implements CustomMessageTask.CustomRunnable<AlaAllGameLiveEntryActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<AlaAllGameLiveEntryActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(AlaAllGameLiveEntryActivity.class);
            }
            return null;
        }
    }

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
        MessageManager.getInstance().registerListener(new a(2001619));
        MessageManager.getInstance().registerListener(new b(2001616));
        MessageManager.getInstance().registerListener(new c(2001620));
        MessageManager.getInstance().registerListener(new d(2001619));
        MessageManager.getInstance().registerListener(new e(2001616));
        MessageManager.getInstance().registerListener(new f(2001616));
        CustomMessageTask customMessageTask = new CustomMessageTask(AlaCmdConfigCustom.CMD_ALA_ALL_GAME_LIVE_ENTRY, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
