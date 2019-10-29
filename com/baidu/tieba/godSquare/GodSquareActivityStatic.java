package com.baidu.tieba.godSquare;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tieba.godRecommends.b;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
/* loaded from: classes6.dex */
public class GodSquareActivityStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_GET_HOT_GOD_CACHE, com.baidu.tieba.godSquare.model.req.a.class);
        com.baidu.tieba.tbadkCore.a.a.b(1003099, CmdConfigSocket.CMD_GET_HOT_GOD, TbConfig.GET_HOT_GOD, GodSquareHttpResponsedMsg.class, GodSquareSocketResponsedMsg.class);
        TbadkCoreApplication.getInst().RegisterIntent(GodSquareActivityConfig.class, GodSquareActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, new CustomMessageTask.CustomRunnable<TbPageContext<?>>() { // from class: com.baidu.tieba.godSquare.GodSquareActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext<?>> customMessage) {
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GOD_RECOMMEND_CONTROLLER, new b(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
