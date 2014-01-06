package com.baidu.tieba.im.chat;

import android.graphics.Bitmap;
import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bg extends com.baidu.adp.a.g {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(ba baVar) {
        this.a = baVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        com.baidu.tieba.im.model.ai aiVar;
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            msglistModel = this.a.h;
            if (msglistModel != null) {
                msglistModel2 = this.a.h;
                String sPathGen = responseData.getSPathGen();
                Bitmap bitmap = responseData.getBitmap();
                aiVar = this.a.n;
                msglistModel2.a(sPathGen, bitmap, aiVar);
                return;
            }
            return;
        }
        this.a.showToast(R.string.pic_parser_error);
    }
}
