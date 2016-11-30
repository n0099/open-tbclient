package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.c.af;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements af.b {
    final /* synthetic */ a drH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.drH = aVar;
    }

    @Override // com.baidu.tieba.im.c.af.b
    public void a(String str, ChatMessage chatMessage) {
        ae aeVar;
        ae aeVar2;
        try {
            a.ayA().m(chatMessage);
            if (chatMessage != null) {
                if (str != null && str.length() > 0) {
                    VoiceMsgData w = com.baidu.tieba.im.util.h.w(chatMessage);
                    if (w != null) {
                        w.setVoice_md5(str);
                        chatMessage.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(w) + "]");
                    }
                    com.baidu.tbadk.core.log.b.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", 0, null, new Object[0]);
                    a.ayA().o(chatMessage);
                    aeVar = this.drH.mSendCallback;
                    if (aeVar != null) {
                        aeVar2 = this.drH.mSendCallback;
                        aeVar2.mh(2);
                        return;
                    }
                    return;
                }
                com.baidu.tbadk.core.log.b.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_voice_ret", -1, "voice http fail", new Object[0]);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPLOAD_FAIL, chatMessage));
                if (chatMessage instanceof CommonGroupChatMessage) {
                    CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                    com.baidu.tbadk.util.t.b(new c(this, commonGroupChatMessage), new d(this, commonGroupChatMessage));
                } else if (chatMessage instanceof PersonalChatMessage) {
                    PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                    com.baidu.tbadk.util.t.b(new e(this, personalChatMessage), new f(this, personalChatMessage));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                    com.baidu.tbadk.util.t.b(new g(this, officialChatMessage), new h(this, officialChatMessage));
                }
            }
        } catch (Exception e) {
        }
    }
}
