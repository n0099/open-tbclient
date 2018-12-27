package com.baidu.tieba.im;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.im.message.RequestAddMsgRecordMessage;
import com.baidu.tieba.im.message.ResponseClearTaskIdMessage;
import com.baidu.tieba.im.model.AddMsgRecordHttpProtoResponse;
import com.baidu.tieba.im.model.AddMsgRecordSocketResponse;
/* loaded from: classes.dex */
public class AddMsgRecordStatic {
    static {
        com.baidu.tieba.tbadkCore.a.a.c(309265, AddMsgRecordSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_MSG_RECORD, com.baidu.tieba.tbadkCore.a.a.aV(TbConfig.ADD_MSG_RECORD, 309265));
        tbHttpMessageTask.setResponsedClass(AddMsgRecordHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265) { // from class: com.baidu.tieba.im.AddMsgRecordStatic.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                boolean z;
                if ((responsedMessage instanceof AddMsgRecordHttpProtoResponse) || (responsedMessage instanceof AddMsgRecordSocketResponse)) {
                    if (!(responsedMessage instanceof AddMsgRecordHttpProtoResponse) || ((AddMsgRecordHttpProtoResponse) responsedMessage).getData() == null) {
                        z = false;
                    } else {
                        z = ((AddMsgRecordHttpProtoResponse) responsedMessage).getData().status.intValue() == 1;
                    }
                    if ((responsedMessage instanceof AddMsgRecordSocketResponse) && ((AddMsgRecordSocketResponse) responsedMessage).getData() != null) {
                        z = ((AddMsgRecordSocketResponse) responsedMessage).getData().status.intValue() == 1;
                    }
                    BdLog.e("success " + z);
                    if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestAddMsgRecordMessage) && ((RequestAddMsgRecordMessage) responsedMessage.getOrginalMessage().getExtra()).isList()) {
                        BdLog.e("isList");
                        if (z) {
                            MessageManager.getInstance().dispatchResponsedMessage(new ResponseClearTaskIdMessage());
                        }
                    }
                }
            }
        });
    }
}
