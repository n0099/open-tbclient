package com.baidu.tieba.emotion.editortool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import com.baidu.tbadk.editortools.i;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionIntefaceStatic {
    static {
        com.baidu.adp.lib.f.c.nl().a(20, new com.baidu.tieba.emotion.a.a());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        TbadkCoreApplication.getInst().registerReceiver(new BroadcastReceiver() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                g.aoh().aoi();
            }
        }, intentFilter);
        CustomMessageListener customMessageListener = new CustomMessageListener(CmdConfigCustom.EDITOR_COLLECT_TOOL) { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof i)) {
                    i iVar = (i) customResponsedMessage.getData();
                    int indexOf = iVar.getCollectTools().indexOf(5);
                    if (indexOf != -1) {
                        if (iVar.KL()) {
                            iVar.b(new c(iVar.getContext(), indexOf + 1, false));
                        } else {
                            iVar.b(new c(iVar.getContext(), indexOf + 1));
                        }
                    }
                }
            }
        };
        CustomMessageListener customMessageListener2 = new CustomMessageListener(CmdConfigCustom.EMOTION_COLLECT_GROUPS) { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    for (com.baidu.tbadk.editortools.emotiontool.a aVar : (List) customResponsedMessage.getData()) {
                        g.aoh().b(aVar);
                    }
                    g.aoh().aoi();
                    MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
                }
            }
        };
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                g.aoh().aoi();
                return null;
            }
        });
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.EMOTION_LOAD_STATIC_EMOTION, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (customMessage == null || !(customMessage instanceof RequestStaticEmotionMessage)) {
                    return null;
                }
                RequestStaticEmotionMessage requestStaticEmotionMessage = (RequestStaticEmotionMessage) customMessage;
                return new CustomResponsedMessage<>(customMessage.getCmd(), g.aoh().aO(requestStaticEmotionMessage.getGroupID(), requestStaticEmotionMessage.getSharpText()));
            }
        });
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.EMOTION_IS_VALID, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.EMOTION_IS_VALID, Boolean.valueOf(g.aoh().fV(customMessage.getData())));
            }
        });
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.EMOTION_IS_LOCAL, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.valueOf(g.aoh().kr(customMessage.getData())));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerTask(customMessageTask3);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask4);
        MessageManager.getInstance().registerListener(customMessageListener);
        customMessageListener2.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(customMessageListener2);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.EMOTION_COLLECT_GROUPS) { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    ((List) customResponsedMessage.getData()).add(f.aog());
                }
            }
        });
    }
}
