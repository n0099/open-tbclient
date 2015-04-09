package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.tbadk.img.d {
    final /* synthetic */ a bmS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.bmS = aVar;
    }

    @Override // com.baidu.tbadk.img.d
    public synchronized void a(String str, ImageUploadResult imageUploadResult) {
        HashMap hashMap;
        com.baidu.tbadk.img.a aVar;
        ChatMessage chatMessage;
        String str2;
        int i;
        String str3;
        ae aeVar;
        ae aeVar2;
        int i2 = 0;
        synchronized (this) {
            synchronized (a.class) {
                hashMap = this.bmS.bmN;
                aVar = (com.baidu.tbadk.img.a) hashMap.remove(str);
            }
            if (aVar != null && (chatMessage = (ChatMessage) aVar.zC()) != null) {
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
                        com.baidu.tieba.im.l.a(new p(this, commonGroupChatMessage), new q(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        com.baidu.tieba.im.l.a(new r(this, personalChatMessage), new s(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        com.baidu.tieba.im.l.a(new t(this, officialChatMessage), new u(this, officialChatMessage));
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
                        this.bmS.aD(str, str3);
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    chatMessage.setContent(a.b(str4, str3, i2, i));
                    a.Tx().n(chatMessage);
                    aeVar = this.bmS.mSendCallback;
                    if (aeVar != null) {
                        aeVar2 = this.bmS.mSendCallback;
                        aeVar2.go(1);
                    }
                }
            }
        }
    }
}
