package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tieba.im.message.ResponseJoinLiveGroupMessage;
/* loaded from: classes.dex */
class ai extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LiveRoomChatView x;
        LiveRoomChatView x2;
        LiveRoomChatView x3;
        LiveRoomChatView x4;
        LiveRoomChatView x5;
        LiveRoomChatView x6;
        LiveRoomChatView x7;
        LiveRoomChatView x8;
        LiveRoomChatView x9;
        LiveRoomChatView x10;
        boolean z;
        LiveRoomChatView x11;
        LiveRoomChatView x12;
        LiveRoomChatView x13;
        this.a.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.x.neterror);
        } else if (socketResponsedMessage.getCmd() == 107103 && (socketResponsedMessage instanceof ResponseJoinLiveGroupMessage)) {
            ResponseJoinLiveGroupMessage responseJoinLiveGroupMessage = (ResponseJoinLiveGroupMessage) socketResponsedMessage;
            if (responseJoinLiveGroupMessage.hasError()) {
                if (TextUtils.isEmpty(responseJoinLiveGroupMessage.getErrorString())) {
                    this.a.showToast(com.baidu.tieba.x.neterror, false);
                } else {
                    this.a.showToast(responseJoinLiveGroupMessage.getErrorString(), false);
                }
                this.a.finish();
                return;
            }
            this.a.v().a(responseJoinLiveGroupMessage);
            this.a.r = true;
            this.a.a = this.a.v().o;
            this.a.v().a(this.a);
            if (this.a.v().b != null) {
                x = this.a.x();
                x.d(this.a.v().j);
                x2 = this.a.x();
                x2.d(this.a.v().r);
                x3 = this.a.x();
                x3.c(this.a.v().p);
                x4 = this.a.x();
                x4.g(this.a.v().b.background);
                this.a.n = this.a.v().c.canForenoticeMsg.intValue() == 1;
                x5 = this.a.x();
                x5.f(this.a.v().l);
                if (this.a.v().d != null) {
                    x13 = this.a.x();
                    x13.S().setUserCount(this.a.v().b.listeners.intValue());
                }
                if (this.a.v().b != null) {
                    x12 = this.a.x();
                    x12.S().setNoteText(this.a.v().b.intro);
                }
                x6 = this.a.x();
                x6.a(this.a.v().d, this.a.v().i, this.a.v().g);
                switch (this.a.v().n) {
                    case 0:
                    case 1:
                    case 2:
                        x7 = this.a.x();
                        x7.d(1);
                        LivePlayingStatusMgr.a().a(this.a.v().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.JOINED);
                        break;
                    case 3:
                    case 4:
                        x10 = this.a.x();
                        x10.d(3);
                        String i = com.baidu.tieba.im.live.d.b().i();
                        boolean isNull = StringUtils.isNull(i);
                        if (com.baidu.tieba.im.live.d.b().g() == 0 || isNull || !i.equals(String.valueOf(this.a.v().c().getGroupId()))) {
                            this.a.b(this.a.v().b.streamId, String.valueOf(this.a.v().b.groupId), String.valueOf(this.a.v().b.deviceId), this.a.v().b.playUrl, false);
                            break;
                        }
                    case 5:
                        x8 = this.a.x();
                        x8.d(5);
                        this.a.w();
                        LivePlayingStatusMgr.a().a(this.a.v().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.PAUSE);
                        break;
                    case 6:
                        x9 = this.a.x();
                        x9.d(6);
                        com.baidu.tieba.im.live.d.b().s();
                        LivePlayingStatusMgr.a().a(this.a.v().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER);
                        break;
                    default:
                        LivePlayingStatusMgr.a().a(this.a.v().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.JOINED);
                        break;
                }
                if (this.a.v().q) {
                    x11 = this.a.x();
                    x11.W();
                }
                z = this.a.r;
                if (z) {
                    com.baidu.tbadk.core.util.ap.a(this.a, 20);
                    return;
                }
                return;
            }
            this.a.showToast(com.baidu.tieba.x.neterror);
        }
    }
}
