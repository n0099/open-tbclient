package com.baidu.tieba.im.model;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tbadk.img.d {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.tbadk.img.d
    public synchronized void a(String str, ImageUploadResult imageUploadResult) {
        HashMap hashMap;
        com.baidu.tbadk.img.a aVar;
        ChatMessage chatMessage;
        String str2;
        int i;
        String str3;
        bb bbVar;
        bb bbVar2;
        int i2 = 0;
        synchronized (this) {
            synchronized (MsglistModel.class) {
                hashMap = this.a.e;
                aVar = (com.baidu.tbadk.img.a) hashMap.remove(str);
            }
            if (aVar != null && (chatMessage = (ChatMessage) aVar.c()) != null) {
                if (imageUploadResult == null || imageUploadResult.error_code != 0 || imageUploadResult.picInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis() - chatMessage.getLogTime();
                    if (imageUploadResult != null) {
                        TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload pic http fail", imageUploadResult.error_code, imageUploadResult.error_msg, currentTimeMillis);
                    } else {
                        TiebaStatic.imLog(chatMessage.getCmd(), 0, "", "", "upload pic http fail", -1, "resutl is null", currentTimeMillis);
                    }
                    this.a.e(chatMessage);
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        com.baidu.tieba.im.i.a(new as(this, (CommonGroupChatMessage) chatMessage), null);
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        com.baidu.tieba.im.i.a(new at(this, (PersonalChatMessage) chatMessage), null);
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        com.baidu.tieba.im.i.a(new au(this, (OfficialChatMessage) chatMessage), null);
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
                        int i3 = imageUploadResult.picInfo.smallPic.height;
                        com.baidu.tbadk.core.util.aw.a().a(str3, str, true, true, true);
                        i = i3;
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    chatMessage.setContent(this.a.a(str4, str3, i2, i));
                    com.baidu.tieba.im.chat.x.b().a(chatMessage);
                    bbVar = this.a.h;
                    if (bbVar != null) {
                        BdLog.d("simon", "send callback", "picture");
                        bbVar2 = this.a.h;
                        bbVar2.a(1);
                    }
                }
            }
        }
    }
}
