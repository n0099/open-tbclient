package com.baidu.tieba.im.mygroup;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
/* loaded from: classes.dex */
class d extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(MyGroupFragment myGroupFragment, int i) {
        super(i);
        this.a = myGroupFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        switch (socketResponsedMessage.getCmd()) {
            case MessageTypes.CMD_ADD_GROUP /* 103101 */:
            case MessageTypes.CMD_UPDATE_GROUP /* 103102 */:
            case MessageTypes.CMD_DISSMISS_GROUP /* 103104 */:
            case MessageTypes.CMD_UPGRADE_MEMBER_GROUP /* 103105 */:
            case MessageTypes.CMD_REMOVE_MEMBERS /* 103112 */:
            case MessageTypes.CMD_GROUP_MEMBER_CHANGE /* 2003109 */:
                if (!(socketResponsedMessage instanceof ResponsedMessage) || socketResponsedMessage.getError() == 0 || ((socketResponsedMessage instanceof ResponseUpgradeMemberGroupMessage) && socketResponsedMessage.getError() == 2230110)) {
                    this.a.c = true;
                    return;
                }
                return;
            default:
                return;
        }
    }
}
