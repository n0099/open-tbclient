package com.baidu.tieba.im.b;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.ResponsePullMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import java.util.List;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.framework.a.j {
    private long bir;

    public k() {
        super(202003);
        this.bir = 0L;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (!(socketResponsedMessage instanceof ResponsePullMessage)) {
            return null;
        }
        if (socketResponsedMessage.getError() == 110000) {
            MessageManager.getInstance().dispatchResponsedMessage(new ResponseUnLoginMessage());
        }
        if (this.bir % 10 == 0) {
            TiebaStatic.imNet(socketResponsedMessage);
            this.bir++;
        }
        List<GroupMsgData> groupMsg = ((ResponsePullMessage) socketResponsedMessage).getGroupMsg();
        if (groupMsg != null && groupMsg.size() > 0) {
            for (GroupMsgData groupMsgData : groupMsg) {
                d(groupMsgData);
            }
        }
        b.QX().Rf();
        return socketResponsedMessage;
    }

    private void d(GroupMsgData groupMsgData) {
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null) {
            MessageManager.getInstance().dispatchResponsedMessage(groupMsgData);
        }
    }
}
