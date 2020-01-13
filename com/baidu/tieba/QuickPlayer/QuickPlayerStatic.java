package com.baidu.tieba.QuickPlayer;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.List;
/* loaded from: classes11.dex */
public class QuickPlayerStatic {
    private static CustomMessageListener dRj = new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.aUg();
                    }
                }).start();
            }
        }
    };
    private static final CustomMessageListener dRk = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                QuickPlayerStatic.aUt();
            }
        }
    };
    private static final CustomMessageListener dRl = new CustomMessageListener(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2921340 && (customResponsedMessage.getData() instanceof List)) {
                List list = (List) customResponsedMessage.getData();
                int size = list.size();
                String[] strArr = new String[size];
                for (int i = 0; i < size; i++) {
                    if (list.get(i) instanceof String) {
                        strArr[i] = (String) list.get(i);
                    }
                }
                QuickPlayerStatic.A(strArr);
            }
        }
    };

    static {
        new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.5
            @Override // java.lang.Runnable
            public void run() {
                d.aUg();
            }
        }).start();
        aUs();
        MessageManager.getInstance().registerListener(dRk);
        MessageManager.getInstance().registerListener(dRj);
        MessageManager.getInstance().registerListener(dRl);
    }

    private static void aUs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, new CustomMessageTask.CustomRunnable<com.baidu.tieba.play.h>() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.play.h> run(CustomMessage<com.baidu.tieba.play.h> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, new f());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aUt() {
        Intent intent = new Intent(TbadkCoreApplication.getInst(), QuickMediaPlayerService.class);
        intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_ALL_PLAYERS, true);
        TbadkCoreApplication.getInst().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            Intent intent = new Intent(TbadkCoreApplication.getInst(), QuickMediaPlayerService.class);
            intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_SOME_PLAYERS, true);
            intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_PLAYERS_IDS, strArr);
            TbadkCoreApplication.getInst().startService(intent);
        }
    }
}
