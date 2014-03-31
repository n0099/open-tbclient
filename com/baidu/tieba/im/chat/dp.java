package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class dp extends com.baidu.adp.a.h {
    final /* synthetic */ dn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(dn dnVar) {
        this.a = dnVar;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.a.e != null) {
                this.a.e.a(responseData.getSPathGen(), responseData.getBitmap(), this.a.j);
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.im.j.pic_parser_error);
    }
}
