package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.message.LiveChatRoomEventResponseMessage;
import com.baidu.tieba.im.data.SystemMsgData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.ChatRoomEventResponseMessage;
import com.baidu.tieba.im.message.GroupMemberChangeResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {
    private static void b(ChatMessage chatMessage) {
        VoiceMsgData g = com.baidu.tieba.im.f.r.g(chatMessage);
        if (g != null) {
            if (com.baidu.tieba.im.f.r.d(chatMessage)) {
                g.setHas_read(1);
            } else {
                g.setHas_read(0);
            }
            chatMessage.setContent("[" + new Gson().toJson(g) + "]");
        }
    }

    public static boolean a(ChatMessage chatMessage) {
        if (chatMessage.getMsgType() != 11) {
            return (chatMessage.getUserInfo() == null || chatMessage.getUserInfo().getUserId() == null || !chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount())) ? false : true;
        }
        SystemMsgData j = com.baidu.tieba.im.f.r.j(chatMessage);
        return (j == null || j.getIsSelf()) ? false : true;
    }

    public static void a(String str, ChatMessage chatMessage) {
        if (chatMessage != null) {
            try {
                switch (chatMessage.getMsgType()) {
                    case 3:
                        b(chatMessage);
                        break;
                    case 10:
                        c(chatMessage);
                        break;
                    case 11:
                        b(str, chatMessage);
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void b(String str, ChatMessage chatMessage) {
        if (chatMessage.getMsgType() == 11) {
            String content = chatMessage.getContent();
            String optString = new JSONObject(content).optString("eventId");
            if ("105".equals(optString) || "106".equals(optString)) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new GroupMemberChangeResponsedMessage(str));
            } else if ("201".equals(optString) || "202".equals(optString) || "203".equals(optString) || "205".equals(optString)) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ChatRoomEventResponseMessage(content));
            } else if ("302".equals(optString) || "306".equals(optString) || "310".equals(optString) || "307".equals(optString) || "308".equals(optString) || "318".equals(optString) || "309".equals(optString) || "304".equals(optString)) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new LiveChatRoomEventResponseMessage(content));
            }
        }
    }

    private static void c(ChatMessage chatMessage) {
        if (chatMessage != null) {
            String content = chatMessage.getContent();
            if (!TextUtils.isEmpty(content)) {
                String currentAccount = TbadkApplication.getCurrentAccount();
                try {
                    JSONObject jSONObject = new JSONObject(content);
                    int optInt = jSONObject.optInt("replyme");
                    int optInt2 = jSONObject.optInt("zan");
                    if (optInt2 > 0) {
                        optInt += optInt2;
                    }
                    int optInt3 = jSONObject.optInt("fans");
                    int optInt4 = jSONObject.optInt("atme");
                    if (optInt >= 0 && optInt3 >= 0 && optInt4 >= 0) {
                        if (TbadkApplication.m252getInst().getMsgFrequency() <= 0) {
                            optInt4 = 0;
                            optInt3 = 0;
                            optInt = 0;
                        }
                        if (!TbadkApplication.m252getInst().isMsgZanOn()) {
                            optInt -= optInt2;
                        }
                        if (!TbadkApplication.m252getInst().isMsgReplymeOn()) {
                            optInt = 0;
                        }
                        if (!TbadkApplication.m252getInst().isMsgAtmeOn()) {
                            optInt4 = 0;
                        }
                        int i = TbadkApplication.m252getInst().isMsgFansOn() ? optInt3 : 0;
                        if (currentAccount != null && currentAccount.length() > 0) {
                            com.baidu.tbadk.coreExtra.messageCenter.a.a().a(optInt, optInt4, i, com.baidu.tbadk.coreExtra.messageCenter.a.a().n(), com.baidu.tbadk.coreExtra.messageCenter.a.a().p());
                        }
                    }
                } catch (Exception e) {
                    BdLog.e("ChatMsgHelper", "parseContent error ", e.getMessage());
                }
            }
        }
    }
}
