package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
/* loaded from: classes.dex */
public final class l {
    public static synchronized boolean a(CommonMsgPojo commonMsgPojo) {
        boolean z = false;
        synchronized (l.class) {
            if (commonMsgPojo != null) {
                boolean z2 = true;
                com.baidu.tieba.im.message.a.a chatMessage = commonMsgPojo.toChatMessage();
                if (chatMessage != null) {
                    SystemMsgData i = com.baidu.tieba.im.f.q.i(chatMessage);
                    if (i != null && !i.getIsSelf()) {
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
                if (!TbadkApplication.j().ae() && commonMsgPojo.isPrivate()) {
                    z2 = false;
                }
                String gid = commonMsgPojo.getGid();
                if (!TextUtils.isEmpty(gid) && PersonalChatActivity.a && gid.equals(PersonalChatActivity.b)) {
                    z2 = false;
                }
                boolean d = com.baidu.tieba.im.chat.personaltalk.a.a().d(TbadkApplication.E(), commonMsgPojo.getGid());
                if (!z2 || d) {
                    z = z2;
                }
            }
        }
        return z;
    }
}
