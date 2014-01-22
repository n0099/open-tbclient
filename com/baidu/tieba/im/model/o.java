package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.UploadPicData2;
import com.baidu.tieba.im.db.au;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.util.by;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements aj {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.tieba.im.model.aj
    public synchronized void a(String str, UploadPicData2 uploadPicData2) {
        HashMap hashMap;
        ag agVar;
        com.baidu.tieba.im.message.b bVar;
        String str2;
        int i;
        String str3;
        ae aeVar;
        ae aeVar2;
        int i2 = 0;
        synchronized (this) {
            synchronized (MsglistModel.class) {
                hashMap = this.a.l;
                agVar = (ag) hashMap.remove(str);
            }
            if (agVar != null && (bVar = agVar.e) != null) {
                if (uploadPicData2 == null || uploadPicData2.error_code != 0 || uploadPicData2.picInfo == null) {
                    long currentTimeMillis = System.currentTimeMillis() - bVar.t();
                    if (uploadPicData2 != null) {
                        by.a(bVar.w(), 0, "", "", "upload pic http fail", uploadPicData2.error_code, uploadPicData2.error_msg, currentTimeMillis);
                    } else {
                        by.a(bVar.w(), 0, "", "", "upload pic http fail", -1, "resutl is null", currentTimeMillis);
                    }
                    this.a.c(bVar);
                    if (bVar instanceof com.baidu.tieba.im.message.g) {
                        com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) bVar;
                        com.baidu.tieba.im.db.d.a().a(gVar.u(), String.valueOf(gVar.j()), String.valueOf(gVar.l()), 2, new p(this));
                    } else if (bVar instanceof com.baidu.tieba.im.message.u) {
                        com.baidu.tieba.im.message.u uVar = (com.baidu.tieba.im.message.u) bVar;
                        au.a().a(uVar.m(), uVar.c(), String.valueOf(uVar.j()), String.valueOf(uVar.l()), 2, new q(this));
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis() - bVar.t();
                    if (uploadPicData2.picInfo.bigPic == null) {
                        str2 = "";
                    } else {
                        str2 = uploadPicData2.picInfo.bigPic.picUrl;
                    }
                    by.a(bVar.w(), 0, "", "", "upload pic http suc bigUrl: " + str2, uploadPicData2.error_code, uploadPicData2.error_msg, currentTimeMillis2);
                    String str4 = uploadPicData2.picInfo.bigPic == null ? null : uploadPicData2.picInfo.bigPic.picUrl;
                    if (uploadPicData2.picInfo.smallPic != null) {
                        str3 = uploadPicData2.picInfo.smallPic.picUrl;
                        i2 = uploadPicData2.picInfo.smallPic.width;
                        int i3 = uploadPicData2.picInfo.smallPic.height;
                        bo.a().a(str3, str, true, true, true);
                        i = i3;
                    } else {
                        i = 0;
                        str3 = null;
                    }
                    bVar.a(this.a.a(str4, str3, i2, i));
                    com.baidu.tieba.im.chat.q.b().a(bVar);
                    aeVar = this.a.q;
                    if (aeVar != null) {
                        com.baidu.adp.lib.g.e.e("simon", "send callback", "picture");
                        aeVar2 = this.a.q;
                        aeVar2.a(1);
                    }
                }
            }
        }
    }
}
