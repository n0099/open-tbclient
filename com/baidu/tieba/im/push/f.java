package com.baidu.tieba.im.push;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.a.j;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import java.util.List;
/* loaded from: classes.dex */
public class f extends j {
    public f() {
        super(202009);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (!(socketResponsedMessage instanceof PushResponseMessage)) {
            return null;
        }
        if (socketResponsedMessage.getError() == 110000) {
            MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
        }
        List<GroupMsgData> groupMsg = ((PushResponseMessage) socketResponsedMessage).getGroupMsg();
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
}
