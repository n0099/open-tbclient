package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.SnapChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class SnapChatMsgHelper extends b {
    public static void a(GroupMsgData groupMsgData) {
        int i;
        String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i2 = 0;
            for (ChatMessage chatMessage : listMessage) {
                chatMessage.setLocalData(new MsgLocalData());
                chatMessage.getLocalData().setStatus((short) 3);
                if (chatMessage instanceof SnapChatMessage) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo(chatMessage);
                    a.a(valueOf, chatMessage);
                    if (a.a(chatMessage)) {
                        commonMsgPojo.setRead_flag(0);
                        i = i2;
                    } else {
                        i = i2 + 1;
                        commonMsgPojo.setRead_flag(1);
                    }
                    linkedList.add(commonMsgPojo);
                    i2 = i;
                } else {
                    return;
                }
            }
            if (SnapGroupChatActivity.a && valueOf.equals(SnapGroupChatActivity.b)) {
                i2 = 0;
            }
            CommonMsgPojo commonMsgPojo2 = (CommonMsgPojo) linkedList.getLast();
            commonMsgPojo2.checkRidAndSelf();
            com.baidu.tieba.im.i.a(new u(valueOf, linkedList), new v(groupMsgData, valueOf, commonMsgPojo2, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo, int i) {
        com.baidu.tieba.im.b.a.a().a(str, i, commonMsgPojo, false);
        if (!TextUtils.isEmpty(str)) {
            a(commonMsgPojo);
        }
        com.baidu.tieba.im.chat.w.b().a(groupMsgData);
    }

    public static void a(CommonMsgPojo commonMsgPojo) {
        boolean z = true;
        if (commonMsgPojo != null) {
            ChatMessage chatMessage = commonMsgPojo.toChatMessage();
            if (chatMessage != null) {
                SystemMsgData j = com.baidu.tieba.im.f.r.j(chatMessage);
                if (j != null && !j.getIsSelf()) {
                    z = false;
                }
                if (TbadkApplication.isLogin()) {
                    if (chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount()) && chatMessage.getMsgType() != 11) {
                        z = false;
                    }
                }
            }
            if (commonMsgPojo.getRead_flag() == 0) {
                z = false;
            }
            if (!TbadkApplication.m252getInst().isGroupMsgOn() && !commonMsgPojo.isPrivate()) {
                z = false;
            }
            String gid = commonMsgPojo.getGid();
            if (!TextUtils.isEmpty(gid) && SnapGroupChatActivity.a && gid.equals(SnapGroupChatActivity.b)) {
                z = false;
            }
            com.baidu.tieba.im.pushNotify.a.f().a(z, false, (com.baidu.tieba.im.a<Void>) new w());
        }
    }
}
