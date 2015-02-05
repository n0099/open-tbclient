package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity bbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bbN = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        s sVar;
        s sVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            atomicBoolean = this.bbN.bbL;
            atomicBoolean.set(false);
            sVar = this.bbN.bbG;
            sVar.OB();
            this.bbN.closeLoadingDialog();
            List<com.baidu.tbadk.coreExtra.relationship.b> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.bbN.bbI = contacts;
            sVar2 = this.bbN.bbG;
            if (sVar2 != null) {
                this.bbN.OH();
            }
        }
    }
}
