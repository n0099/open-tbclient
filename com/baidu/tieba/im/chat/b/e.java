package com.baidu.tieba.im.chat.b;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.b.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class e {
    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.b.e.1
            @Override // com.baidu.tieba.im.chat.b.a.c
            public boolean mX(String str) {
                return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(0) && str.equals(ChatStatusManager.getInst().getCurId(0));
            }
        }, ChatStatusManager.getInst().getIsOpen(5), new a.InterfaceC0150a() { // from class: com.baidu.tieba.im.chat.b.e.2
            @Override // com.baidu.tieba.im.chat.b.a.InterfaceC0150a
            public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo2) {
                if (chatMessage != null && chatMessage.getMsgType() == 22) {
                    if (com.baidu.tieba.im.util.e.w(chatMessage)) {
                        return true;
                    }
                    long k = e.k(chatMessage);
                    if (k > imMessageCenterPojo2.getRead_msgId()) {
                        imMessageCenterPojo2.setRead_msgId(k);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public static long k(ChatMessage chatMessage) {
        JSONObject optJSONObject;
        if (chatMessage == null || chatMessage.getMsgType() != 22) {
            return -1L;
        }
        try {
            String content = chatMessage.getContent();
            if (TextUtils.isEmpty(content)) {
                return -1L;
            }
            JSONObject jSONObject = new JSONObject(content);
            String optString = jSONObject.optString("eventId");
            if (TextUtils.isEmpty(optString) || !optString.equals("22001") || (optJSONObject = jSONObject.optJSONObject("eventParam")) == null || optJSONObject.optLong("groupId") != com.baidu.tieba.im.sendmessage.a.eir.longValue()) {
                return -1L;
            }
            return com.baidu.tieba.im.util.d.ci(optJSONObject.optLong("readMsgId"));
        } catch (Exception e) {
            return -1L;
        }
    }
}
