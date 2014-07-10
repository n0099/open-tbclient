package com.baidu.tieba.addresslist;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends CustomMessageListener {
    final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(d dVar) {
        super(2001178);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.addresslist.c.a aVar;
        com.baidu.tieba.addresslist.c.a aVar2;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001178 && (customResponsedMessage instanceof ResponseNewFriendUpdateUiMsg)) {
            if (customResponsedMessage.getError() != 0) {
                this.a.b(customResponsedMessage.getErrorString());
                return;
            }
            ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = (ResponseNewFriendUpdateUiMsg) customResponsedMessage;
            if (responseNewFriendUpdateUiMsg.getAction() == 0) {
                com.baidu.tbadk.coreExtra.relationship.b bVar = new com.baidu.tbadk.coreExtra.relationship.b();
                bVar.d(responseNewFriendUpdateUiMsg.getKey());
                bVar.c(responseNewFriendUpdateUiMsg.getQuanping());
                bVar.a(responseNewFriendUpdateUiMsg.getFriendId());
                bVar.a(responseNewFriendUpdateUiMsg.getName());
                bVar.b(responseNewFriendUpdateUiMsg.getPortrait());
                aVar2 = this.a.b;
                aVar2.a(bVar);
            } else if (responseNewFriendUpdateUiMsg.getAction() == 1) {
                aVar = this.a.b;
                aVar.a(responseNewFriendUpdateUiMsg.getFriendId());
            }
        }
    }
}
