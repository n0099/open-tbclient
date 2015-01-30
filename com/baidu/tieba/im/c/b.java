package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ah {
    final /* synthetic */ a boF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.boF = aVar;
    }

    @Override // com.baidu.tieba.im.c.ah
    public void a(String str, ChatMessage chatMessage) {
        ae aeVar;
        ae aeVar2;
        try {
            a.To().k(chatMessage);
            if (chatMessage != null) {
                if (str != null && str.length() > 0) {
                    VoiceMsgData u = com.baidu.tieba.im.util.i.u(chatMessage);
                    if (u != null) {
                        u.setVoice_md5(str);
                        chatMessage.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(u) + "]");
                    }
                    TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload voice http suc vid = " + str, 0, "upload voice http success ", System.currentTimeMillis() - chatMessage.getLogTime());
                    a.To().m(chatMessage);
                    aeVar = this.boF.mSendCallback;
                    if (aeVar != null) {
                        aeVar2 = this.boF.mSendCallback;
                        aeVar2.gB(2);
                        return;
                    }
                    return;
                }
                TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - chatMessage.getLogTime());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001221, chatMessage));
                if (chatMessage instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                    com.baidu.tieba.im.i.a(new c(this, commonGroupChatMessage), new d(this, commonGroupChatMessage));
                } else if (chatMessage instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                    com.baidu.tieba.im.i.a(new e(this, personalChatMessage), new f(this, personalChatMessage));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                    com.baidu.tieba.im.i.a(new g(this, officialChatMessage), new h(this, officialChatMessage));
                }
            }
        } catch (Exception e) {
        }
    }
}
