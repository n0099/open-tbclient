package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b {
    public static void a(GroupMsgData groupMsgData, boolean z) {
        int i;
        String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i2 = 0;
            for (ChatMessage chatMessage : listMessage) {
                chatMessage.setLocalData(new MsgLocalData());
                chatMessage.getLocalData().setStatus((short) 3);
                if (chatMessage instanceof CommonGroupChatMessage) {
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
            int i3 = (GroupChatActivity.a && valueOf.equals(GroupChatActivity.b)) ? 0 : i2;
            CommonMsgPojo commonMsgPojo2 = (CommonMsgPojo) linkedList.getLast();
            commonMsgPojo2.checkRidAndSelf();
            com.baidu.tieba.im.i.a(new c(valueOf, linkedList), new d(groupMsgData, valueOf, commonMsgPojo2, i3, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo, int i, boolean z) {
        com.baidu.tieba.im.b.a.a().a(str, i, commonMsgPojo, false);
        if (z) {
            a(commonMsgPojo);
        }
        com.baidu.tieba.im.chat.w.b().a(groupMsgData);
    }

    private static void a(CommonMsgPojo commonMsgPojo) {
        boolean z;
        boolean z2 = true;
        if (commonMsgPojo != null) {
            ChatMessage chatMessage = commonMsgPojo.toChatMessage();
            if (chatMessage != null) {
                SystemMsgData j = com.baidu.tieba.im.e.r.j(chatMessage);
                z = j == null || j.getIsSelf();
                if (TbadkApplication.isLogin()) {
                    if (chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount()) && chatMessage.getMsgType() != 11) {
                        z = false;
                    }
                }
            } else {
                z = true;
            }
            if (commonMsgPojo.getRead_flag() == 0) {
                z2 = false;
                z = false;
            }
            if (!TbadkApplication.m252getInst().isGroupMsgOn() && !commonMsgPojo.isPrivate()) {
                z = false;
            }
            if (!TbadkApplication.m252getInst().isMsgChatOn() && commonMsgPojo.isPrivate()) {
                z = false;
            }
            String gid = commonMsgPojo.getGid();
            if (!TextUtils.isEmpty(gid) && GroupChatActivity.a && gid.equals(GroupChatActivity.b)) {
                z = false;
            }
            boolean d = com.baidu.tieba.im.groupInfo.y.a().d(TbadkApplication.getCurrentAccount(), gid);
            if (z && !d) {
                z = false;
            }
            com.baidu.tieba.im.pushNotify.a.i().a(z, z2, new e());
        }
    }
}
