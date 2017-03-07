package com.baidu.tieba.QuickPlayer;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class QuickPlayerStatic {
    private static final CustomMessageListener aQA = new t(CmdConfigCustom.CMD_BACKGROUND_SWTICH);

    private static void JH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, new u());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void JI() {
        Intent intent = new Intent(TbadkCoreApplication.m9getInst(), QuickMediaPlayerService.class);
        intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_ALL_PLAYERS, true);
        TbadkCoreApplication.m9getInst().startService(intent);
    }

    static {
        JH();
        MessageManager.getInstance().registerListener(aQA);
        m.JD();
    }
}
