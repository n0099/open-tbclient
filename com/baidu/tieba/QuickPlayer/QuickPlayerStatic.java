package com.baidu.tieba.QuickPlayer;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class QuickPlayerStatic {
    private static CustomMessageListener cSf = new CustomMessageListener(2007015) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.aAh();
                    }
                }).start();
            }
        }
    };
    private static final CustomMessageListener cSg = new CustomMessageListener(2001011) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                QuickPlayerStatic.aAt();
            }
        }
    };
    private static final CustomMessageListener cSh = new CustomMessageListener(2921340) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.4
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
                QuickPlayerStatic.s(strArr);
            }
        }
    };

    static {
        new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.5
            @Override // java.lang.Runnable
            public void run() {
                d.aAh();
            }
        }).start();
        aAs();
        MessageManager.getInstance().registerListener(cSg);
        MessageManager.getInstance().registerListener(cSf);
        MessageManager.getInstance().registerListener(cSh);
    }

    private static void aAs() {
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
    public static void aAt() {
        Intent intent = new Intent(TbadkCoreApplication.getInst(), QuickMediaPlayerService.class);
        intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_ALL_PLAYERS, true);
        TbadkCoreApplication.getInst().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            Intent intent = new Intent(TbadkCoreApplication.getInst(), QuickMediaPlayerService.class);
            intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_SOME_PLAYERS, true);
            intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_PLAYERS_IDS, strArr);
            TbadkCoreApplication.getInst().startService(intent);
        }
    }
}
