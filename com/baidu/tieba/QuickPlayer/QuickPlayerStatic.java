package com.baidu.tieba.QuickPlayer;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
/* loaded from: classes2.dex */
public class QuickPlayerStatic {
    private static CustomMessageListener bPF = new CustomMessageListener(2007015) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.Te();
                    }
                }).start();
            }
        }
    };
    private static final CustomMessageListener bPG = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                QuickPlayerStatic.To();
            }
        }
    };

    static {
        new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.4
            @Override // java.lang.Runnable
            public void run() {
                d.Te();
            }
        }).start();
        Tn();
        MessageManager.getInstance().registerListener(bPG);
        MessageManager.getInstance().registerListener(bPF);
    }

    private static void Tn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016490, new CustomMessageTask.CustomRunnable<com.baidu.tieba.play.h>() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.play.h> run(CustomMessage<com.baidu.tieba.play.h> customMessage) {
                return new CustomResponsedMessage<>(2016490, new f());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void To() {
        Intent intent = new Intent(TbadkCoreApplication.getInst(), QuickMediaPlayerService.class);
        intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_ALL_PLAYERS, true);
        TbadkCoreApplication.getInst().startService(intent);
    }
}
