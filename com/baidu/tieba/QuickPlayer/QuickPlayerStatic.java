package com.baidu.tieba.QuickPlayer;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class QuickPlayerStatic {
    private static CustomMessageListener aRl = new t(CmdConfigCustom.MAINTAB_ONCREATE_END);
    private static final CustomMessageListener aRm = new v(CmdConfigCustom.CMD_BACKGROUND_SWTICH);

    static {
        Jv();
        MessageManager.getInstance().registerListener(aRm);
        MessageManager.getInstance().registerListener(aRl);
    }

    private static void Jv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_QUICK_PLAYER_FACTORY, new w());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Jw() {
        Intent intent = new Intent(TbadkCoreApplication.m9getInst(), QuickMediaPlayerService.class);
        intent.putExtra(QuickMediaPlayerService.KEY_RELEASE_ALL_PLAYERS, true);
        TbadkCoreApplication.m9getInst().startService(intent);
    }
}
