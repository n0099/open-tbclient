package com.baidu.tieba.emotion.editortool;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.widget.ActivityChooserView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.emotiontool.RequestStaticEmotionMessage;
import java.util.List;
/* loaded from: classes5.dex */
public class EmotionIntefaceStatic {
    static {
        com.baidu.adp.lib.f.c.jC().a(20, new com.baidu.tieba.emotion.a.a());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        TbadkCoreApplication.getInst().registerReceiver(new BroadcastReceiver() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                e.atw().atx();
            }
        }, intentFilter);
        CustomMessageListener customMessageListener = new CustomMessageListener(2010044) { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof EditorTools)) {
                    EditorTools editorTools = (EditorTools) customResponsedMessage.getData();
                    int indexOf = editorTools.getCollectTools().indexOf(5);
                    if (indexOf != -1) {
                        if (editorTools.KN()) {
                            editorTools.b(new a(editorTools.getContext(), indexOf + 1, false));
                        } else {
                            editorTools.b(new a(editorTools.getContext(), indexOf + 1));
                        }
                    }
                }
            }
        };
        CustomMessageListener customMessageListener2 = new CustomMessageListener(2004602) { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    for (com.baidu.tbadk.editortools.emotiontool.a aVar : (List) customResponsedMessage.getData()) {
                        e.atw().b(aVar);
                    }
                    e.atw().atx();
                    MessageManager.getInstance().abortResponsedMessage(customResponsedMessage);
                }
            }
        };
        CustomMessageTask customMessageTask = new CustomMessageTask(2004603, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                e.atw().atx();
                return null;
            }
        });
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2004604, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                if (customMessage == null || !(customMessage instanceof RequestStaticEmotionMessage)) {
                    return null;
                }
                RequestStaticEmotionMessage requestStaticEmotionMessage = (RequestStaticEmotionMessage) customMessage;
                return new CustomResponsedMessage<>(customMessage.getCmd(), e.atw().bo(requestStaticEmotionMessage.getGroupID(), requestStaticEmotionMessage.getSharpText()));
            }
        });
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2004608, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2004608, Boolean.valueOf(e.atw().hn(customMessage.getData())));
            }
        });
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2004609, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.7
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<String> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2004609, Boolean.valueOf(e.atw().mB(customMessage.getData())));
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
        customMessageListener2.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        MessageManager.getInstance().registerListener(customMessageListener2);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2004602) { // from class: com.baidu.tieba.emotion.editortool.EmotionIntefaceStatic.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    ((List) customResponsedMessage.getData()).add(d.atv());
                }
            }
        });
    }
}
