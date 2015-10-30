package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tbadk.img.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.c {
    final /* synthetic */ a bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.bHf = aVar;
    }

    @Override // com.baidu.tbadk.img.a.c
    public synchronized void a(String str, ImageUploadResult imageUploadResult) {
        HashMap hashMap;
        com.baidu.tbadk.img.a aVar;
        ChatMessage chatMessage;
        int i;
        String str2;
        ae aeVar;
        ae aeVar2;
        int i2 = 0;
        synchronized (this) {
            synchronized (a.class) {
                hashMap = this.bHf.bHa;
                aVar = (com.baidu.tbadk.img.a) hashMap.remove(str);
            }
            if (aVar != null && (chatMessage = (ChatMessage) aVar.Cf()) != null) {
                if (imageUploadResult == null || imageUploadResult.error_code != 0 || imageUploadResult.picInfo == null) {
                    if (imageUploadResult != null) {
                        com.baidu.tbadk.core.log.b.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", imageUploadResult.error_code, imageUploadResult.error_msg, new Object[0]);
                    } else {
                        com.baidu.tbadk.core.log.b.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", -1, "result is null", new Object[0]);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_UPLOAD_FAIL, chatMessage));
                    if (chatMessage instanceof CommonGroupChatMessage) {
                        CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) chatMessage;
                        com.baidu.tbadk.util.m.b(new p(this, commonGroupChatMessage), new q(this, commonGroupChatMessage));
                    } else if (chatMessage instanceof PersonalChatMessage) {
                        PersonalChatMessage personalChatMessage = (PersonalChatMessage) chatMessage;
                        com.baidu.tbadk.util.m.b(new r(this, personalChatMessage), new s(this, personalChatMessage));
                    } else if (chatMessage instanceof OfficialChatMessage) {
                        OfficialChatMessage officialChatMessage = (OfficialChatMessage) chatMessage;
                        com.baidu.tbadk.util.m.b(new t(this, officialChatMessage), new u(this, officialChatMessage));
                    }
                } else {
                    com.baidu.tbadk.core.log.b.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "up_pic_ret", 0, null, new Object[0]);
                    String str3 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                    if (imageUploadResult.picInfo.smallPic != null) {
                        str2 = imageUploadResult.picInfo.smallPic.picUrl;
                        i2 = imageUploadResult.picInfo.smallPic.width;
                        i = imageUploadResult.picInfo.smallPic.height;
                        this.bHf.aJ(str, str2);
                    } else {
                        i = 0;
                        str2 = null;
                    }
                    chatMessage.setContent(a.b(str3, str2, i2, i));
                    a.WZ().n(chatMessage);
                    aeVar = this.bHf.mSendCallback;
                    if (aeVar != null) {
                        aeVar2 = this.bHf.mSendCallback;
                        aeVar2.hz(1);
                    }
                }
            }
        }
    }
}
