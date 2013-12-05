package com.baidu.tieba.im.chat;

import android.graphics.Bitmap;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(MsglistActivity msglistActivity) {
        this.f1561a = msglistActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        com.baidu.tieba.im.model.x xVar;
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            msglistModel = this.f1561a.g;
            if (msglistModel != null) {
                msglistModel2 = this.f1561a.g;
                String sPathGen = responseData.getSPathGen();
                Bitmap bitmap = responseData.getBitmap();
                xVar = this.f1561a.m;
                msglistModel2.a(sPathGen, bitmap, xVar);
                return;
            }
            return;
        }
        this.f1561a.showToast(R.string.pic_parser_error);
    }
}
