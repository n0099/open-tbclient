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
/* loaded from: classes4.dex */
public class AddMsgRecordStatic {

    /* loaded from: classes4.dex */
    public static class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0029  */
        @Override // d.a.c.c.g.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            boolean z2 = responsedMessage instanceof AddMsgRecordHttpProtoResponse;
            if (z2 || (responsedMessage instanceof AddMsgRecordSocketResponse)) {
                if (z2) {
                    AddMsgRecordHttpProtoResponse addMsgRecordHttpProtoResponse = (AddMsgRecordHttpProtoResponse) responsedMessage;
                    if (addMsgRecordHttpProtoResponse.getData() != null && addMsgRecordHttpProtoResponse.getData().status.intValue() == 1) {
                        z = true;
                        if (responsedMessage instanceof AddMsgRecordSocketResponse) {
                            AddMsgRecordSocketResponse addMsgRecordSocketResponse = (AddMsgRecordSocketResponse) responsedMessage;
                            if (addMsgRecordSocketResponse.getData() != null) {
                                z = addMsgRecordSocketResponse.getData().status.intValue() == 1;
                            }
                        }
                        BdLog.e("success " + z);
                        if (responsedMessage.getOrginalMessage() == null && (responsedMessage.getOrginalMessage().getExtra() instanceof RequestAddMsgRecordMessage) && ((RequestAddMsgRecordMessage) responsedMessage.getOrginalMessage().getExtra()).isList()) {
                            BdLog.e("isList");
                            if (z) {
                                MessageManager.getInstance().dispatchResponsedMessage(new ResponseClearTaskIdMessage());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z = false;
                if (responsedMessage instanceof AddMsgRecordSocketResponse) {
                }
                BdLog.e("success " + z);
                if (responsedMessage.getOrginalMessage() == null) {
                }
            }
        }
    }

    static {
        d.a.o0.e3.d0.a.f(309265, AddMsgRecordSocketResponse.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_ADD_MSG_RECORD, d.a.o0.e3.d0.a.a(TbConfig.ADD_MSG_RECORD, 309265));
        tbHttpMessageTask.setResponsedClass(AddMsgRecordHttpProtoResponse.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(new a(CmdConfigHttp.CMD_ADD_MSG_RECORD, 309265));
    }
}
