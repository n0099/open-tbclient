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
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.tbadk.img.d
    public synchronized void a(String str, ImageUploadResult imageUploadResult) {
        HashMap hashMap;
        com.baidu.tbadk.img.a aVar;
        ChatMessage chatMessage;
        String str2;
        int i;
        String str3;
        com.baidu.tieba.im.model.al alVar;
        com.baidu.tieba.im.model.al alVar2;
        int i2 = 0;
        synchronized (this) {
            synchronized (MsglistModel.class) {
                hashMap = this.a.e;
                aVar = (com.baidu.tbadk.img.a) hashMap.remove(str);
            }
            if (aVar != null && (chatMessage = (ChatMessage) aVar.b()) != null) {
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
                        this.a.a(str, str3);
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    chatMessage.setContent(w.a(str4, str3, i2, i));
                    w.a().d(chatMessage);
                    alVar = this.a.g;
                    if (alVar != null) {
                        alVar2 = this.a.g;
                        alVar2.a(1);
                    }
                }
            }
        }
    }
}
