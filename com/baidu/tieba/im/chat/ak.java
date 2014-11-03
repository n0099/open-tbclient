package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.img.d {
    final /* synthetic */ w aOa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(w wVar) {
        this.aOa = wVar;
    }

    @Override // com.baidu.tbadk.img.d
    public synchronized void a(String str, ImageUploadResult imageUploadResult) {
        HashMap hashMap;
        com.baidu.tbadk.img.a aVar;
        ChatMessage chatMessage;
        String str2;
        int i;
        String str3;
        MsglistModel.SendCallback sendCallback;
        MsglistModel.SendCallback sendCallback2;
        int i2 = 0;
        synchronized (this) {
            synchronized (MsglistModel.class) {
                hashMap = this.aOa.aNV;
                aVar = (com.baidu.tbadk.img.a) hashMap.remove(str);
            }
            if (aVar != null && (chatMessage = (ChatMessage) aVar.sm()) != null) {
                if (imageUploadResult == null || imageUploadResult.error_code != 0 || imageUploadResult.picInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis() - chatMessage.getLogTime();
                    if (imageUploadResult != null) {
                        TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload pic http fail", imageUploadResult.error_code, imageUploadResult.error_msg, currentTimeMillis);
                    } else {
                        TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload pic http fail", -1, "resutl is null", currentTimeMillis);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001221, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        com.baidu.tieba.im.e.a(new al(this, commonGroupChatMessage), new am(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        com.baidu.tieba.im.e.a(new an(this, personalChatMessage), new ao(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        com.baidu.tieba.im.e.a(new ap(this, officialChatMessage), new aq(this, officialChatMessage));
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - chatMessage.getLogTime();
                    if (imageUploadResult.picInfo.bigPic == null) {
                        str2 = "";
                    } else {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload pic http suc bigUrl: " + str2, imageUploadResult.error_code, imageUploadResult.error_msg, currentTimeMillis2);
                    String str4 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                    if (imageUploadResult.picInfo.smallPic != null) {
                        str3 = imageUploadResult.picInfo.smallPic.picUrl;
                        i2 = imageUploadResult.picInfo.smallPic.width;
                        i = imageUploadResult.picInfo.smallPic.height;
                        this.aOa.aj(str, str3);
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    chatMessage.setContent(w.b(str4, str3, i2, i));
                    w.Js().f(chatMessage);
                    sendCallback = this.aOa.mSendCallback;
                    if (sendCallback != null) {
                        sendCallback2 = this.aOa.mSendCallback;
                        sendCallback2.onSend(1);
                    }
                }
            }
        }
    }
}
