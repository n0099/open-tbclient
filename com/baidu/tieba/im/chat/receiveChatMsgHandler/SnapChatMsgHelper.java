package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class SnapChatMsgHelper extends b {
    public static void a(GroupMsgData groupMsgData) {
        int i;
        String valueOf = String.valueOf(groupMsgData.b().getGroupId());
        LinkedList<com.baidu.tieba.im.message.a.a> c = groupMsgData.c();
        if (c != null && c.size() > 0) {
            LinkedList linkedList = new LinkedList();
            int i2 = 0;
            for (com.baidu.tieba.im.message.a.a aVar : c) {
                aVar.a(new MsgLocalData());
                aVar.y().setStatus((short) 3);
                if (aVar instanceof com.baidu.tieba.im.message.a.g) {
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
            if (SnapGroupChatActivity.a && valueOf.equals(SnapGroupChatActivity.b)) {
                i2 = 0;
            }
            CommonMsgPojo commonMsgPojo2 = (CommonMsgPojo) linkedList.getLast();
            commonMsgPojo2.checkRidAndSelf();
            com.baidu.tieba.im.s.a(new p(valueOf, linkedList), new q(groupMsgData, valueOf, commonMsgPojo2, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo, int i) {
        com.baidu.tieba.im.b.a.a().a(str, i, commonMsgPojo);
        if (!TextUtils.isEmpty(str)) {
            boolean z = true;
            if (commonMsgPojo != null) {
                com.baidu.tieba.im.message.a.a chatMessage = commonMsgPojo.toChatMessage();
                if (chatMessage != null) {
                    SystemMsgData i2 = com.baidu.tieba.im.f.q.i(chatMessage);
                    if (i2 != null && !i2.getIsSelf()) {
                        z = false;
                    }
                    if (TbadkApplication.F()) {
                        if (chatMessage.r().getUserId().equals(TbadkApplication.E()) && chatMessage.t() != 11) {
                            z = false;
                        }
                    }
                }
                if (commonMsgPojo.getRead_flag() == 0) {
                    z = false;
                }
                TbadkApplication.j();
                if (!TbadkApplication.ad() && !commonMsgPojo.isPrivate()) {
                    z = false;
                }
                String gid = commonMsgPojo.getGid();
                if (!TextUtils.isEmpty(gid) && SnapGroupChatActivity.a && gid.equals(SnapGroupChatActivity.b)) {
                    z = false;
                }
                com.baidu.tieba.im.pushNotify.a.d().b(z, new r());
            }
        }
        com.baidu.tieba.im.chat.x.b().a(groupMsgData);
    }
}
