package com.baidu.tieba.im.live.room;

import android.app.NotificationManager;
import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.view.LivePlayingStatusMgr;
import com.baidu.tieba.im.chat.bv;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseJoinLiveGroupMessage;
/* loaded from: classes.dex */
class af extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        LiveRoomChatView z;
        LiveRoomChatView z2;
        LiveRoomChatView z3;
        LiveRoomChatView z4;
        LiveRoomChatView z5;
        LiveRoomChatView z6;
        LiveRoomChatView z7;
        LiveRoomChatView z8;
        LiveRoomChatView z9;
        LiveRoomChatView z10;
        boolean z11;
        LiveRoomChatView z12;
        LiveRoomChatView z13;
        LiveRoomChatView z14;
        this.a.hideProgressBar();
        if (socketResponsedMessage == null) {
            this.a.showToast(com.baidu.tieba.y.neterror);
        } else if (socketResponsedMessage.getCmd() == 107103 && (socketResponsedMessage instanceof ResponseJoinLiveGroupMessage)) {
            ResponseJoinLiveGroupMessage responseJoinLiveGroupMessage = (ResponseJoinLiveGroupMessage) socketResponsedMessage;
            if (responseJoinLiveGroupMessage.hasError()) {
                if (TextUtils.isEmpty(responseJoinLiveGroupMessage.getErrorString())) {
                    this.a.showToast(com.baidu.tieba.y.neterror, false);
                } else {
                    this.a.showToast(responseJoinLiveGroupMessage.getErrorString(), false);
                }
                this.a.finish();
                return;
            }
            this.a.x().a(responseJoinLiveGroupMessage);
            this.a.s = true;
            this.a.m = this.a.x().o;
            this.a.x().g_();
            if (this.a.x().b == null) {
                this.a.showToast(com.baidu.tieba.y.neterror);
                return;
            }
            if (!com.baidu.tbadk.coreExtra.messageCenter.e.a().b(this.a.x().b().getGroupId())) {
                ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                imMessageCenterPojo.setGid(String.valueOf(this.a.x().b().getGroupId()));
                imMessageCenterPojo.setPulled_msgId(bv.b(this.a.x().b.lastMsgId.longValue()));
                imMessageCenterPojo.setCustomGroupType(3);
                imMessageCenterPojo.setGroup_name(this.a.x().j);
                imMessageCenterPojo.setIs_delete(0);
                imMessageCenterPojo.setIs_hidden(1);
                com.baidu.tieba.im.e.i.a(imMessageCenterPojo);
            }
            z = this.a.z();
            z.d(this.a.x().j);
            z2 = this.a.z();
            z2.d(this.a.x().r);
            z3 = this.a.z();
            z3.c(this.a.x().p);
            z4 = this.a.z();
            z4.f(this.a.x().b.background);
            this.a.n = this.a.x().c.canForenoticeMsg.intValue() == 1;
            z5 = this.a.z();
            z5.e(this.a.x().l);
            if (this.a.x().d != null) {
                z14 = this.a.z();
                z14.R().setUserCount(this.a.x().b.listeners.intValue());
            }
            if (this.a.x().b != null) {
                z13 = this.a.z();
                z13.R().setNoteText(this.a.x().b.intro);
            }
            z6 = this.a.z();
            z6.a(this.a.x().d, this.a.x().i, this.a.x().g);
            switch (this.a.x().n) {
                case 0:
                case 1:
                case 2:
                    z7 = this.a.z();
                    z7.d(1);
                    LivePlayingStatusMgr.a().a(this.a.x().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.JOINED);
                    break;
                case 3:
                case 4:
                    z10 = this.a.z();
                    z10.d(3);
                    String i = com.baidu.tieba.im.live.b.b().i();
                    boolean isNull = StringUtils.isNull(i);
                    if (com.baidu.tieba.im.live.b.b().g() == 0 || isNull || !i.equals(String.valueOf(this.a.x().b().getGroupId()))) {
                        this.a.b(this.a.x().b.streamId, String.valueOf(this.a.x().b.groupId), String.valueOf(this.a.x().b.deviceId), this.a.x().b.playUrl, false);
                        break;
                    }
                case 5:
                    z8 = this.a.z();
                    z8.d(5);
                    this.a.y();
                    LivePlayingStatusMgr.a().a(this.a.x().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.PAUSE);
                    break;
                case 6:
                    z9 = this.a.z();
                    z9.d(6);
                    BdLog.d("case LiveMsglistModel.LiveType.END");
                    com.baidu.tieba.im.live.b.b().s();
                    LivePlayingStatusMgr.a().a(this.a.x().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.NO_PUBLISHER);
                    break;
                default:
                    LivePlayingStatusMgr.a().a(this.a.x().b.groupId.intValue(), LivePlayingStatusMgr.LivePlayingStatus.JOINED);
                    break;
            }
            if (this.a.x().q) {
                z12 = this.a.z();
                z12.V();
            }
            try {
                z11 = this.a.s;
                if (z11) {
                    ((NotificationManager) this.a.getSystemService("notification")).cancel(20);
                }
            } catch (Exception e) {
            }
        }
    }
}
