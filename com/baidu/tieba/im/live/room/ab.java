package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.live.LiveStatusChangeMessage;
/* loaded from: classes.dex */
class ab extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(LiveRoomChatActivity liveRoomChatActivity, int i) {
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
        LiveRoomChatView x;
        LiveRoomChatView x2;
        LiveRoomChatView x3;
        if (customResponsedMessage.getCmd() == 2001161 && (customResponsedMessage instanceof LiveStatusChangeMessage)) {
            LiveStatusChangeMessage.LiveStatusData data = ((LiveStatusChangeMessage) customResponsedMessage).getData();
            z = this.a.r;
            if (z && this.a.v().b != null) {
                String valueOf = String.valueOf(this.a.v().b.groupId);
                if (data.status == 19 && valueOf.equals(data.groupId) && !this.a.v().r) {
                    x2 = this.a.x();
                    if (x2.U() != 3) {
                        x3 = this.a.x();
                        x3.d(3);
                    }
                }
                if (data.status == 4 && valueOf.equals(data.groupId) && this.a.v().r) {
                    x = this.a.x();
                    x.d(5);
                }
                if (data.status == 0) {
                    str = this.a.t;
                    if (str != null) {
                        str2 = this.a.t;
                        if (str2.equals(String.valueOf(this.a.v().b.groupId))) {
                            com.baidu.tieba.im.live.d.b().a(this.a.v().r ? this.a.v().b.streamId : null, String.valueOf(this.a.v().b.groupId), String.valueOf(this.a.v().b.deviceId), this.a.v().b.playUrl, false);
                        }
                        this.a.t = null;
                    }
                }
            }
        }
    }
}
