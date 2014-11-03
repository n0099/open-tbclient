package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.model.VoiceSendModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements VoiceSendModel.UploadVoiceCallback {
    final /* synthetic */ w aOa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.aOa = wVar;
    }

    @Override // com.baidu.tieba.im.model.VoiceSendModel.UploadVoiceCallback
    public void callback(String str, ChatMessage chatMessage) {
        MsglistModel.SendCallback sendCallback;
        MsglistModel.SendCallback sendCallback2;
        try {
            w.Js().d(chatMessage);
            if (chatMessage != null) {
                if (str != null && str.length() > 0) {
                    VoiceMsgData v = com.baidu.tieba.im.util.i.v(chatMessage);
                    if (v != null) {
                        v.setVoice_md5(str);
                        chatMessage.setContent("[" + com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(v) + "]");
                    }
                    TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload voice http suc vid = " + str, 0, "upload voice http success ", System.currentTimeMillis() - chatMessage.getLogTime());
                    w.Js().f(chatMessage);
                    sendCallback = this.aOa.mSendCallback;
                    if (sendCallback != null) {
                        sendCallback2 = this.aOa.mSendCallback;
                        sendCallback2.onSend(2);
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
