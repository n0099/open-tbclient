package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class df extends com.baidu.adp.base.g {
    final /* synthetic */ dd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(dd ddVar) {
        this.a = ddVar;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.a.e != null) {
                this.a.e.a(responseData.getSPathGen(), responseData.getBitmap(), this.a.k);
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.u.pic_parser_error);
    }
}
