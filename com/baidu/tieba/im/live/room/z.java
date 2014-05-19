package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
/* loaded from: classes.dex */
class z extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        LiveRoomChatView z2;
        LiveRoomChatView z3;
        if (customResponsedMessage.getCmd() == 2003161 && (customResponsedMessage instanceof LiveStatusChangeMessage)) {
            LiveStatusChangeMessage.LiveStatusData data = ((LiveStatusChangeMessage) customResponsedMessage).getData();
            z = this.a.s;
            if (z && this.a.x().b != null && String.valueOf(this.a.x().b.groupId).equals(data.groupId)) {
                if (data.status == 0) {
                    z3 = this.a.z();
                    z3.d(6);
                } else if (data.status == 4 && this.a.x().r) {
                    z2 = this.a.z();
                    z2.d(5);
                }
            }
        }
    }
}
