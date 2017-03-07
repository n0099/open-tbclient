package com.baidu.tieba.emotion.editortool;

import android.content.IntentFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class EmotionIntefaceStatic {
    static {
        com.baidu.adp.lib.f.c.fG().a(20, new com.baidu.tieba.emotion.a.a());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_EJECT");
        TbadkCoreApplication.m9getInst().registerReceiver(new a(), intentFilter);
        b bVar = new b(CmdConfigCustom.EDITOR_COLLECT_TOOL);
        c cVar = new c(CmdConfigCustom.EMOTION_COLLECT_GROUPS);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.EMOTION_RELOAD_EMOTION_GROUPS, new d());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.EMOTION_LOAD_STATIC_EMOTION, new e());
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.EMOTION_IS_VALID, new f());
        CustomMessageTask customMessageTask4 = new CustomMessageTask(CmdConfigCustom.EMOTION_IS_LOCAL, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        MessageManager.getInstance().registerTask(customMessageTask3);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerTask(customMessageTask4);
        MessageManager.getInstance().registerListener(bVar);
        cVar.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(cVar);
    }
}
