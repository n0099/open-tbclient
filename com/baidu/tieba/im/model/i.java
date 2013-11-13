package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.im.message.ChatMessage;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements u {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistModel f1751a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MsglistModel msglistModel) {
        this.f1751a = msglistModel;
    }

    @Override // com.baidu.tieba.im.model.u
    public synchronized void a(String str, UploadPicData2 uploadPicData2) {
        HashMap hashMap;
        ChatMessage chatMessage;
        String str2;
        int i;
        String str3;
        int i2 = 0;
        synchronized (this) {
            hashMap = this.f1751a.k;
            r rVar = (r) hashMap.remove(str);
            if (rVar != null && (chatMessage = rVar.f1760a) != null) {
                if (uploadPicData2 == null || uploadPicData2.error_code != 0 || uploadPicData2.picInfo == null) {
                    com.baidu.tieba.util.y.a(chatMessage.getCmd(), 0, "", "", "upload pic http fail", uploadPicData2.error_code, uploadPicData2.error_msg, System.currentTimeMillis() - chatMessage.getLogTime());
                    this.f1751a.c(chatMessage);
                    com.baidu.tieba.im.db.a.a().a(chatMessage.getGroupId(), String.valueOf(chatMessage.getRecordId()), String.valueOf(chatMessage.getMsgId()), 2, new j(this));
                } else {
                    long currentTimeMillis = System.currentTimeMillis() - chatMessage.getLogTime();
                    if (uploadPicData2.picInfo.bigPic == null) {
                        str2 = "";
                    } else {
                        str2 = uploadPicData2.picInfo.bigPic.picUrl;
                    }
                    com.baidu.tieba.util.y.a(chatMessage.getCmd(), 0, "", "", "upload pic http suc bigUrl: " + str2, uploadPicData2.error_code, uploadPicData2.error_msg, currentTimeMillis);
                    String str4 = uploadPicData2.picInfo.bigPic == null ? null : uploadPicData2.picInfo.bigPic.picUrl;
                    if (uploadPicData2.picInfo.smallPic != null) {
                        str3 = uploadPicData2.picInfo.smallPic.picUrl;
                        i2 = uploadPicData2.picInfo.smallPic.width;
                        i = uploadPicData2.picInfo.smallPic.height;
                        com.baidu.tieba.util.a.c.a(str3, str, true, true, true);
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    chatMessage.setContent(this.f1751a.a(str4, str3, i2, i));
                    com.baidu.tieba.im.chat.a.b().a(chatMessage);
                }
            }
        }
    }
}
