package com.baidu.tieba.im.live.room;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.message.NetWorkChangeMessage;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
/* loaded from: classes.dex */
class q extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        LiveRoomChatView x;
        LiveRoomChatView x2;
        if (customResponsedMessage.getCmd() == 2001121 && (customResponsedMessage instanceof NetWorkChangeMessage)) {
            NetWorkChangeMessage netWorkChangeMessage = (NetWorkChangeMessage) customResponsedMessage;
            if (netWorkChangeMessage.mState == 1 || netWorkChangeMessage.mState == 2) {
                z = this.a.r;
                if (z) {
                    x = this.a.x();
                    if (x.U() != 1 || this.a.v().r) {
                        return;
                    }
                    this.a.B();
                    return;
                }
                this.a.B();
            } else if (netWorkChangeMessage.mState == 0 || netWorkChangeMessage.mState == -1) {
                x2 = this.a.x();
                x2.d(1);
                LivePlayingStatusMgr.a().a(0, LivePlayingStatusMgr.LivePlayingStatus.IDEL);
            }
        }
    }
}
