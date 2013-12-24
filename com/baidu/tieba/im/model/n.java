package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.im.db.ar;
/* loaded from: classes.dex */
class n implements ah {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.tieba.im.model.ah
    public synchronized void a(String str, UploadPicData2 uploadPicData2) {
        com.baidu.tieba.im.message.b bVar;
        String str2;
        int i;
        String str3;
        int i2 = 0;
        synchronized (this) {
            ae aeVar = (ae) this.a.l.remove(str);
            if (aeVar != null && (bVar = aeVar.a) != null) {
                if (uploadPicData2 == null || uploadPicData2.error_code != 0 || uploadPicData2.picInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis() - bVar.r();
                    if (uploadPicData2 != null) {
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bVar.t(), 0, "", "", "upload pic http fail", uploadPicData2.error_code, uploadPicData2.error_msg, currentTimeMillis));
                    } else {
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bVar.t(), 0, "", "", "upload pic http fail", -1, "resutl is null", currentTimeMillis));
                    }
                    this.a.c(bVar);
                    if (bVar instanceof com.baidu.tieba.im.message.d) {
                        com.baidu.tieba.im.message.d dVar = (com.baidu.tieba.im.message.d) bVar;
                        com.baidu.tieba.im.db.d.a().a(dVar.s(), String.valueOf(dVar.i()), String.valueOf(dVar.k()), 2, new o(this));
                    } else if (bVar instanceof com.baidu.tieba.im.message.p) {
                        com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) bVar;
                        ar.a().a(pVar.l(), pVar.b(), String.valueOf(pVar.i()), String.valueOf(pVar.k()), 2, new p(this));
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - bVar.r();
                    if (uploadPicData2.picInfo.bigPic == null) {
                        str2 = "";
                    } else {
                        str2 = uploadPicData2.picInfo.bigPic.picUrl;
                    }
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(bVar.t(), 0, "", "", "upload pic http suc bigUrl: " + str2, uploadPicData2.error_code, uploadPicData2.error_msg, currentTimeMillis2));
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
                    bVar.a(this.a.a(str4, str3, i2, i));
                    com.baidu.tieba.im.chat.a.b().a(bVar);
                }
            }
        }
    }
}
