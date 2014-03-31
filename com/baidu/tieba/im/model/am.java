package com.baidu.tieba.im.model;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class am implements com.baidu.tbadk.img.d {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.tbadk.img.d
    public final synchronized void a(String str, ImageUploadResult imageUploadResult) {
        HashMap hashMap;
        com.baidu.tbadk.img.a aVar;
        com.baidu.tieba.im.message.a.a aVar2;
        String str2;
        int i;
        String str3;
        aw awVar;
        aw awVar2;
        int i2 = 0;
        synchronized (this) {
            synchronized (MsglistModel.class) {
                hashMap = this.a.h;
                aVar = (com.baidu.tbadk.img.a) hashMap.remove(str);
            }
            if (aVar != null && (aVar2 = (com.baidu.tieba.im.message.a.a) aVar.a) != null) {
                if (imageUploadResult == null || imageUploadResult.error_code != 0 || imageUploadResult.picInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis() - aVar2.E();
                    if (imageUploadResult != null) {
                        TiebaStatic.a(aVar2.e(), 0, "", "", "upload pic http fail", imageUploadResult.error_code, imageUploadResult.error_msg, currentTimeMillis);
                    } else {
                        TiebaStatic.a(aVar2.e(), 0, "", "", "upload pic http fail", -1, "resutl is null", currentTimeMillis);
                    }
                    this.a.d(aVar2);
                    if (aVar2 instanceof com.baidu.tieba.im.message.a.b) {
                        com.baidu.tieba.im.s.a(new an(this, (com.baidu.tieba.im.message.a.b) aVar2), null);
                    } else if (aVar2 instanceof com.baidu.tieba.im.message.a.f) {
                        com.baidu.tieba.im.s.a(new ao(this, (com.baidu.tieba.im.message.a.f) aVar2), null);
                    } else if (aVar2 instanceof com.baidu.tieba.im.message.a.e) {
                        com.baidu.tieba.im.s.a(new ap(this, (com.baidu.tieba.im.message.a.e) aVar2), null);
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - aVar2.E();
                    if (imageUploadResult.picInfo.bigPic == null) {
                        str2 = "";
                    } else {
                        str2 = imageUploadResult.picInfo.bigPic.picUrl;
                    }
                    TiebaStatic.a(aVar2.e(), 0, "", "", "upload pic http suc bigUrl: " + str2, imageUploadResult.error_code, imageUploadResult.error_msg, currentTimeMillis2);
                    String str4 = imageUploadResult.picInfo.bigPic == null ? null : imageUploadResult.picInfo.bigPic.picUrl;
                    if (imageUploadResult.picInfo.smallPic != null) {
                        str3 = imageUploadResult.picInfo.smallPic.picUrl;
                        i2 = imageUploadResult.picInfo.smallPic.width;
                        int i3 = imageUploadResult.picInfo.smallPic.height;
                        com.baidu.tbadk.core.util.av.a().a(str3, str, true, true, true);
                        i = i3;
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    MsglistModel msglistModel = this.a;
                    aVar2.d(MsglistModel.a(str4, str3, i2, i));
                    com.baidu.tieba.im.chat.x.b().a(aVar2);
                    awVar = this.a.k;
                    if (awVar != null) {
                        com.baidu.adp.lib.util.f.e("simon", "send callback", "picture");
                        awVar2 = this.a.k;
                        awVar2.t();
                    }
                }
            }
        }
    }
}
