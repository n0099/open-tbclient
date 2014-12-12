package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class k extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.bas = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        s sVar;
        s sVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            atomicBoolean = this.bas.bap;
            atomicBoolean.set(false);
            sVar = this.bas.bak;
            sVar.Ok();
            this.bas.closeLoadingDialog();
            List<com.baidu.tbadk.coreExtra.relationship.b> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.bas.bam = contacts;
            sVar2 = this.bas.bak;
            if (sVar2 != null) {
                this.bas.Oq();
            }
        }
    }
}
