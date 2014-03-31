package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.groupInfo.aa;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class b {
    public static void a(GroupMsgData groupMsgData, boolean z) {
        int i;
        String valueOf = String.valueOf(groupMsgData.b().getGroupId());
        LinkedList<com.baidu.tieba.im.message.a.a> c = groupMsgData.c();
        if (c != null && c.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i2 = 0;
            for (com.baidu.tieba.im.message.a.a aVar : c) {
                aVar.a(new MsgLocalData());
                aVar.y().setStatus((short) 3);
                if (aVar instanceof com.baidu.tieba.im.message.a.b) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo(aVar);
                    a.a(valueOf, aVar);
                    if (a.a(aVar)) {
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
            com.baidu.tieba.im.s.a(new c(valueOf, linkedList), new d(groupMsgData, valueOf, commonMsgPojo2, i3, z));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo, int i, boolean z) {
        com.baidu.tieba.im.b.a.a().a(str, i, commonMsgPojo);
        if (z) {
            boolean z2 = true;
            if (commonMsgPojo != null) {
                com.baidu.tieba.im.message.a.a chatMessage = commonMsgPojo.toChatMessage();
                if (chatMessage != null) {
                    SystemMsgData i2 = com.baidu.tieba.im.f.q.i(chatMessage);
                    if (i2 != null && !i2.getIsSelf()) {
                        z2 = false;
                    }
                    if (TbadkApplication.F()) {
                        if (chatMessage.r().getUserId().equals(TbadkApplication.E()) && chatMessage.t() != 11) {
                            z2 = false;
                        }
                    }
                }
                if (commonMsgPojo.getRead_flag() == 0) {
                    z2 = false;
                }
                TbadkApplication.j();
                if (!TbadkApplication.ad() && !commonMsgPojo.isPrivate()) {
                    z2 = false;
                }
                if (!TbadkApplication.j().ae() && commonMsgPojo.isPrivate()) {
                    z2 = false;
                }
                String gid = commonMsgPojo.getGid();
                if (!TextUtils.isEmpty(gid) && GroupChatActivity.a && gid.equals(GroupChatActivity.b)) {
                    z2 = false;
                }
                boolean d = aa.a().d(commonMsgPojo.getUid(), gid);
                if (z2 && !d) {
                    z2 = false;
                }
                com.baidu.tieba.im.pushNotify.a.d().b(z2, new e());
            }
        }
        com.baidu.tieba.im.chat.x.b().a(groupMsgData);
    }
}
