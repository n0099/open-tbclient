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
/* loaded from: classes13.dex */
public class QuickPlayerStatic {
    private static CustomMessageListener evW = new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.beH();
                    }
                }).start();
            }
        }
    };
    private static final CustomMessageListener evX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2001011 && (customResponsedMessage instanceof BackgroundSwitchMessage) && (customResponsedMessage.getData() instanceof Boolean) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                QuickPlayerStatic.beU();
            }
        }
    };
    private static final CustomMessageListener evY = new CustomMessageListener(CmdConfigCustom.CMD_RELEASE_SOME_PLAYER) { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.4
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
                QuickPlayerStatic.E(strArr);
            }
        }
    };

    static {
        new Thread(new Runnable() { // from class: com.baidu.tieba.QuickPlayer.QuickPlayerStatic.5
            @Override // java.lang.Runnable
            public void run() {
                d.beH();
            }
        }).start();
        beT();
        MessageManager.getInstance().registerListener(evX);
        MessageManager.getInstance().registerListener(evW);
        MessageManager.getInstance().registerListener(evY);
    }

    private static void beT() {
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
    public static void beU() {
        Intent intent = new Intent(TbadkCoreApplication.getInst(), QuickMediaPlayerService.class);
        intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_ALL_PLAYERS, true);
        TbadkCoreApplication.getInst().startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void E(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            Intent intent = new Intent(TbadkCoreApplication.getInst(), QuickMediaPlayerService.class);
            intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_SOME_PLAYERS, true);
            intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_PLAYERS_IDS, strArr);
            TbadkCoreApplication.getInst().startService(intent);
        }
    }
}
