package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.im.db.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ah {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.tieba.im.model.ah
    public synchronized void a(String str, UploadPicData2 uploadPicData2) {
        ae aeVar;
        com.baidu.tieba.im.message.b bVar;
        String str2;
        int i;
        String str3;
        int i2 = 0;
        synchronized (this) {
            synchronized (MsglistModel.class) {
                aeVar = (ae) this.a.l.remove(str);
            }
            if (aeVar != null && (bVar = aeVar.a) != null) {
                if (uploadPicData2 == null || uploadPicData2.error_code != 0 || uploadPicData2.picInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis() - bVar.s();
                    if (uploadPicData2 != null) {
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bVar.u(), 0, "", "", "upload pic http fail", uploadPicData2.error_code, uploadPicData2.error_msg, currentTimeMillis));
                    } else {
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bVar.u(), 0, "", "", "upload pic http fail", -1, "resutl is null", currentTimeMillis));
                    }
                    this.a.c(bVar);
                    if (bVar instanceof com.baidu.tieba.im.message.e) {
                        com.baidu.tieba.im.message.e eVar = (com.baidu.tieba.im.message.e) bVar;
                        com.baidu.tieba.im.db.d.a().a(eVar.t(), String.valueOf(eVar.i()), String.valueOf(eVar.k()), 2, new o(this));
                    } else if (bVar instanceof com.baidu.tieba.im.message.s) {
                        com.baidu.tieba.im.message.s sVar = (com.baidu.tieba.im.message.s) bVar;
                        as.a().a(sVar.l(), sVar.b(), String.valueOf(sVar.i()), String.valueOf(sVar.k()), 2, new p(this));
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - bVar.s();
                    if (uploadPicData2.picInfo.bigPic == null) {
                        str2 = "";
                    } else {
                        str2 = uploadPicData2.picInfo.bigPic.picUrl;
                    }
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bVar.u(), 0, "", "", "upload pic http suc bigUrl: " + str2, uploadPicData2.error_code, uploadPicData2.error_msg, currentTimeMillis2));
                    String str4 = uploadPicData2.picInfo.bigPic == null ? null : uploadPicData2.picInfo.bigPic.picUrl;
                    if (uploadPicData2.picInfo.smallPic != null) {
                        str3 = uploadPicData2.picInfo.smallPic.picUrl;
                        i2 = uploadPicData2.picInfo.smallPic.width;
                        i = uploadPicData2.picInfo.smallPic.height;
                        com.baidu.tieba.util.a.d.a(str3, str, true, true, true);
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    bVar.a(this.a.a(str4, str3, i2, i));
                    com.baidu.tieba.im.chat.a.b().a(bVar);
                }
            }
        }
    }
}
