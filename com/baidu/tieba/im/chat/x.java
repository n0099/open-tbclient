package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.im.model.be {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.tieba.im.model.be
    public void a(String str, ChatMessage chatMessage) {
        com.baidu.tieba.im.model.al alVar;
        com.baidu.tieba.im.model.al alVar2;
        try {
            w.a().f(chatMessage);
            if (chatMessage != null) {
                if (str != null && str.length() > 0) {
                    VoiceMsgData h = com.baidu.tieba.im.d.j.h(chatMessage);
                    if (h != null) {
                        h.setVoice_md5(str);
                        chatMessage.setContent("[" + new Gson().toJson(h) + "]");
                    }
                    TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload voice http suc vid = " + str, 0, "upload voice http success ", System.currentTimeMillis() - chatMessage.getLogTime());
                    w.a().d(chatMessage);
                    alVar = this.a.g;
                    if (alVar != null) {
                        alVar2 = this.a.g;
                        alVar2.a(2);
                        return;
                    }
                    return;
                }
                TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - chatMessage.getLogTime());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001221, chatMessage));
                if (chatMessage instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                    com.baidu.tieba.im.e.a(new y(this, commonGroupChatMessage), new z(this, commonGroupChatMessage));
                } else if (chatMessage instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                    com.baidu.tieba.im.e.a(new aa(this, personalChatMessage), new ab(this, personalChatMessage));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                    com.baidu.tieba.im.e.a(new ac(this, officialChatMessage), new ad(this, officialChatMessage));
                }
            }
        } catch (Exception e) {
        }
    }
}
