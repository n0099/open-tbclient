package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.model.AddMsgRecordHttpProtoResponse;
import com.baidu.tieba.im.model.AddMsgRecordSocketResponse;
/* loaded from: classes.dex */
public class AddMsgRecordStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.c(309265, AddMsgRecordSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_MSG_RECORD, com.baidu.tieba.tbadkCore.a.a.aB(TbConfig.ADD_MSG_RECORD, 309265));
        tbHttpMessageTask.setResponsedClass(AddMsgRecordHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(new a(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265));
    }
}
