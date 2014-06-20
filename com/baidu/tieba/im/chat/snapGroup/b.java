package com.baidu.tieba.im.chat.snapGroup;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.bv;
import com.baidu.tieba.im.data.RandChatRoomData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.e.s;
import com.baidu.tieba.im.message.ResponseChatRoomInfoMessage;
import com.baidu.tieba.im.message.ResponseEnterChatRoomMessage;
import com.baidu.tieba.im.message.ResponseQuitChatRoomMessage;
import com.baidu.tieba.im.randchat.WaittingActivity;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
class b extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ SnapGroupChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SnapGroupChatActivity snapGroupChatActivity, int i) {
        super(i);
        this.a = snapGroupChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        boolean z;
        int i;
        int i2;
        int i3;
        com.baidu.tieba.im.chat.g gVar;
        switch (socketResponsedMessage.getCmd()) {
            case MessageTypes.CMD_QUERY_CHAT_ROOM_INFO /* 106001 */:
                if (socketResponsedMessage instanceof ResponseChatRoomInfoMessage) {
                    ResponseChatRoomInfoMessage responseChatRoomInfoMessage = (ResponseChatRoomInfoMessage) socketResponsedMessage;
                    BdLog.d(responseChatRoomInfoMessage.toString());
                    this.a.a(s.a(responseChatRoomInfoMessage.getUserList()));
                    return;
                }
                return;
            case MessageTypes.CMD_REQUEST_ENTER_CHAT_ROOM /* 106101 */:
                this.a.closeLoadingDialog();
                if (!(socketResponsedMessage instanceof ResponseEnterChatRoomMessage)) {
                    this.a.showToast(y.neterror);
                    return;
                }
                ResponseEnterChatRoomMessage responseEnterChatRoomMessage = (ResponseEnterChatRoomMessage) socketResponsedMessage;
                if (responseEnterChatRoomMessage.getError() != 0) {
                    if (responseEnterChatRoomMessage.getError() > 0) {
                        if (!TextUtils.isEmpty(responseEnterChatRoomMessage.getErrorString())) {
                            this.a.showToast(responseEnterChatRoomMessage.getErrorString());
                            return;
                        }
                        return;
                    }
                    this.a.showToast(y.neterror);
                    return;
                }
                RandChatRoomData randChatRoomData = responseEnterChatRoomMessage.getRandChatRoomData();
                if (randChatRoomData != null && randChatRoomData.e() > 0) {
                    ImMessageCenterPojo imMessageCenterPojo = new ImMessageCenterPojo();
                    imMessageCenterPojo.setGid(String.valueOf(randChatRoomData.d()));
                    imMessageCenterPojo.setPulled_msgId(bv.b(randChatRoomData.k()));
                    imMessageCenterPojo.setCustomGroupType(3);
                    imMessageCenterPojo.setGroup_name("聊天室");
                    imMessageCenterPojo.setIs_delete(0);
                    imMessageCenterPojo.setIs_hidden(1);
                    com.baidu.tieba.im.e.i.a(imMessageCenterPojo);
                    z = this.a.u;
                    if (!z) {
                        SnapGroupChatActivity snapGroupChatActivity = this.a;
                        i3 = snapGroupChatActivity.s;
                        snapGroupChatActivity.s = i3 + 1;
                    }
                    StringBuilder sb = new StringBuilder("restart time = ");
                    i = this.a.s;
                    BdLog.d("simon", "onMessage", sb.append(i).toString());
                    SnapGroupChatActivity snapGroupChatActivity2 = this.a;
                    i2 = this.a.s;
                    WaittingActivity.a(snapGroupChatActivity2, randChatRoomData, i2);
                    this.a.finish();
                    return;
                }
                return;
            case MessageTypes.CMD_QUIT_CHAT_ROOM /* 106102 */:
                if (socketResponsedMessage instanceof ResponseQuitChatRoomMessage) {
                    gVar = this.a.d;
                    gVar.Q();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
