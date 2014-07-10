package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
/* loaded from: classes.dex */
class aa extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        String str;
        String str2;
        LiveRoomChatView z2;
        LiveRoomChatView z3;
        LiveRoomChatView z4;
        if (customResponsedMessage.getCmd() == 2001161 && (customResponsedMessage instanceof LiveStatusChangeMessage)) {
            LiveStatusChangeMessage.LiveStatusData data = ((LiveStatusChangeMessage) customResponsedMessage).getData();
            z = this.a.s;
            if (z && this.a.x().b != null) {
                String valueOf = String.valueOf(this.a.x().b.groupId);
                if (data.status == 19 && valueOf.equals(data.groupId) && !this.a.x().r) {
                    z3 = this.a.z();
                    if (z3.U() != 3) {
                        z4 = this.a.z();
                        z4.d(3);
                    }
                }
                if (data.status == 4 && valueOf.equals(data.groupId) && this.a.x().r) {
                    z2 = this.a.z();
                    z2.d(5);
                }
                if (data.status == 0) {
                    str = this.a.u;
                    if (str != null) {
                        str2 = this.a.u;
                        if (str2.equals(String.valueOf(this.a.x().b.groupId))) {
                            com.baidu.tieba.im.live.d.b().a(this.a.x().r ? this.a.x().b.streamId : null, String.valueOf(this.a.x().b.groupId), String.valueOf(this.a.x().b.deviceId), this.a.x().b.playUrl, false);
                        }
                        this.a.u = null;
                    }
                }
            }
        }
    }
}
