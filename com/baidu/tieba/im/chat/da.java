package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.LocalPicModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class da extends com.baidu.adp.a.g {
    final /* synthetic */ cy a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(cy cyVar) {
        this.a = cyVar;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.a.e != null) {
                this.a.e.a(responseData.getSPathGen(), responseData.getBitmap(), this.a.j);
                return;
            }
            return;
        }
        this.a.showToast(R.string.pic_parser_error);
    }
}
