package com.baidu.tieba.im.model;

import com.baidu.tieba.img.ImageUploadResult;
import com.baidu.tieba.util.bm;
import com.baidu.tieba.util.cb;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w implements com.baidu.tieba.img.d {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.tieba.img.d
    public final synchronized void a(String str, ImageUploadResult imageUploadResult) {
        HashMap hashMap;
        com.baidu.tieba.img.a aVar;
        com.baidu.tieba.im.message.b bVar;
        String str2;
        int i;
        String str3;
        aj ajVar;
        aj ajVar2;
        int i2 = 0;
        synchronized (this) {
            synchronized (MsglistModel.class) {
                hashMap = this.a.l;
                aVar = (com.baidu.tieba.img.a) hashMap.remove(str);
            }
            if (aVar != null && (bVar = (com.baidu.tieba.im.message.b) aVar.a) != null) {
                if (imageUploadResult == null || imageUploadResult.error_code != 0 || imageUploadResult.picInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis() - bVar.t();
                    if (imageUploadResult != null) {
                        cb.a(bVar.v(), 0, "", "", "upload pic http fail", imageUploadResult.error_code, imageUploadResult.error_msg, currentTimeMillis);
                    } else {
                        cb.a(bVar.v(), 0, "", "", "upload pic http fail", -1, "resutl is null", currentTimeMillis);
                    }
                    this.a.b(bVar);
                    if (bVar instanceof com.baidu.tieba.im.message.g) {
                        com.baidu.tieba.im.i.a(new x(this, (com.baidu.tieba.im.message.g) bVar), null);
                    } else if (bVar instanceof com.baidu.tieba.im.message.w) {
                        com.baidu.tieba.im.i.a(new y(this, (com.baidu.tieba.im.message.w) bVar), null);
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - bVar.t();
                    if (imageUploadResult.picInfo.bigPic == null) {
                        str2 = "";
                    } else {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    cb.a(bVar.v(), 0, "", "", "upload pic http suc bigUrl: " + str2, imageUploadResult.error_code, imageUploadResult.error_msg, currentTimeMillis2);
                    String str4 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                    if (imageUploadResult.picInfo.smallPic != null) {
                        str3 = imageUploadResult.picInfo.smallPic.picUrl;
                        i2 = imageUploadResult.picInfo.smallPic.width;
                        int i3 = imageUploadResult.picInfo.smallPic.height;
                        bm.a().a(str3, str, true, true, true);
                        i = i3;
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    MsglistModel msglistModel = this.a;
                    bVar.a(MsglistModel.a(str4, str3, i2, i));
                    com.baidu.tieba.im.chat.q.b().a(bVar);
                    ajVar = this.a.q;
                    if (ajVar != null) {
                        com.baidu.adp.lib.util.e.e("simon", "send callback", "picture");
                        ajVar2 = this.a.q;
                        ajVar2.o();
                    }
                }
            }
        }
    }
}
