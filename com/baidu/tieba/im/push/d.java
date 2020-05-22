package com.baidu.tieba.im.push;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.b.j;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import java.util.List;
/* loaded from: classes.dex */
public class d extends j {
    public d() {
        super(CmdConfigSocket.CMD_PUSH_MESSAGE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.g
    /* renamed from: e */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof PushResponseMessage) {
            if (socketResponsedMessage.getError() == 110000) {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
            }
            PushResponseMessage pushResponseMessage = (PushResponseMessage) socketResponsedMessage;
            if (((PushResponseMessage) socketResponsedMessage).getNotificationData() != null && TbadkCoreApplication.getInst().isInBackground()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.DEAL_YY_NOTIFICATION);
                customMessage.setData(pushResponseMessage.getNotificationData());
                MessageManager.getInstance().sendMessage(customMessage);
                return null;
            }
            List<GroupMsgData> groupMsg = pushResponseMessage.getGroupMsg();
            if (groupMsg != null && groupMsg.size() > 0) {
                for (GroupMsgData groupMsgData : groupMsg) {
                    if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(groupMsgData);
                    }
                }
                return socketResponsedMessage;
            }
            return socketResponsedMessage;
        }
        return null;
    }
}
