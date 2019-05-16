package com.baidu.tieba.godSquare;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GodSquareActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.godRecommends.b;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
/* loaded from: classes6.dex */
public class GodSquareActivityStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.b(2016446, com.baidu.tieba.godSquare.model.req.a.class);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigHttp.CMD_GET_HOT_GOD, 309315, TbConfig.GET_HOT_GOD, GodSquareHttpResponsedMsg.class, GodSquareSocketResponsedMsg.class);
        TbadkCoreApplication.getInst().RegisterIntent(GodSquareActivityConfig.class, GodSquareActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2016469, new CustomMessageTask.CustomRunnable<TbPageContext<?>>() { // from class: com.baidu.tieba.godSquare.GodSquareActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext<?>> customMessage) {
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2016469, new b(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
