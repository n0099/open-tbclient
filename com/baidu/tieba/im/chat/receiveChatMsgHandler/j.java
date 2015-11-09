package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class j {
    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new k(), ChatStatusManager.getInst().getIsOpen(5), new l());
    }

    public static long g(ChatMessage chatMessage) {
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
            if (TextUtils.isEmpty(optString) || !optString.equals("22001") || (optJSONObject = jSONObject.optJSONObject("eventParam")) == null || optJSONObject.optLong("groupId") != com.baidu.tieba.im.c.a.bHs) {
                return -1L;
            }
            return com.baidu.tieba.im.util.g.aJ(optJSONObject.optLong("readMsgId"));
        } catch (Exception e) {
            return -1L;
        }
    }
}
