package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.LocalPicModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class db extends com.baidu.adp.a.g {
    final /* synthetic */ cz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public db(cz czVar) {
        this.a = czVar;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
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
