package com.baidu.tieba.VideoCacheClient;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.play.i;
/* loaded from: classes2.dex */
public class VCacheClientStatic {
    private static CustomMessageListener blx = new CustomMessageListener(2007015) { // from class: com.baidu.tieba.VideoCacheClient.VCacheClientStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                new Thread(new Runnable() { // from class: com.baidu.tieba.VideoCacheClient.VCacheClientStatic.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.Qn().bi(TbadkCoreApplication.getInst().getContext());
                    }
                }).start();
            }
        }
    };

    static {
        Qs();
        MessageManager.getInstance().registerListener(blx);
    }

    private static void Qs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016479, new CustomMessageTask.CustomRunnable<i>() { // from class: com.baidu.tieba.VideoCacheClient.VCacheClientStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<i> run(CustomMessage<i> customMessage) {
                return new CustomResponsedMessage<>(2016479, b.Qn());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
