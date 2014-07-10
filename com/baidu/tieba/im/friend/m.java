package com.baidu.tieba.im.friend;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.relationship.GetContactListResponsedMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
class m extends CustomMessageListener {
    final /* synthetic */ InviteFriendListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(InviteFriendListActivity inviteFriendListActivity, int i) {
        super(i);
        this.a = inviteFriendListActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        AtomicBoolean atomicBoolean;
        x xVar;
        x xVar2;
        if (customResponsedMessage instanceof GetContactListResponsedMessage) {
            atomicBoolean = this.a.d;
            atomicBoolean.set(false);
            xVar = this.a.b;
            xVar.i();
            this.a.closeLoadingDialog();
            List<com.baidu.tbadk.coreExtra.relationship.b> contacts = ((GetContactListResponsedMessage) customResponsedMessage).getContacts();
            if (contacts == null) {
                contacts = new LinkedList<>();
            }
            this.a.a = contacts;
            xVar2 = this.a.b;
            if (xVar2 != null) {
                this.a.e();
            }
        }
    }
}
