package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic) {
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        c.Sd().a(3, imMessageCenterPojo.getPulled_msgId(), imMessageCenterPojo.getGid());
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        if (list != null && list.size() != 0) {
            for (CommonMsgPojo commonMsgPojo : list) {
                if (commonMsgPojo.getMsg_type() == 11) {
                    String content = commonMsgPojo.getContent();
                    try {
                        String optString = new JSONObject(content).optString("eventId");
                        if ("201".equals(optString) || "202".equals(optString) || "203".equals(optString) || "205".equals(optString)) {
                            MessageManager.getInstance().dispatchResponsedMessageToUI(new ChatRoomEventResponseMessage(content));
                        }
                    } catch (JSONException e) {
                        BdLog.detailException(e);
                    }
                }
            }
        }
    }
}
