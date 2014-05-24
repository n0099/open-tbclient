package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.LocalPicModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc extends com.baidu.adp.base.e {
    final /* synthetic */ TalkableActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(TalkableActivity talkableActivity) {
        this.a = talkableActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            if (this.a.e != null) {
                this.a.e.a(responseData.getSPathGen(), responseData.getBitmap(), this.a.k);
                return;
            }
            return;
        }
        this.a.showToast(com.baidu.tieba.y.pic_parser_error);
    }
}
