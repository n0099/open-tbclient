package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tieba.im.chat.bu;
import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.stranger.StrangerListActivity;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {
    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, c cVar) {
        a.a(groupMsgData, imMessageCenterPojo, cVar, new n(), StrangerListActivity.isOpen, new o());
    }

    public static long m(ChatMessage chatMessage) {
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
            if (TextUtils.isEmpty(optString) || !optString.equals("22001") || (optJSONObject = jSONObject.optJSONObject("eventParam")) == null || optJSONObject.optLong("groupId") != w.aNF) {
                return -1L;
            }
            return bu.F(optJSONObject.optLong("readMsgId"));
        } catch (Exception e) {
            return -1L;
        }
    }
}
