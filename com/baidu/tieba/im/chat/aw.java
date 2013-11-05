package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.model.LocalPicModel;
import com.baidu.tieba.im.model.MsglistModel;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(MsglistActivity msglistActivity) {
        this.f1423a = msglistActivity;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        if (obj != null && (obj instanceof LocalPicModel.ResponseData)) {
            LocalPicModel.ResponseData responseData = (LocalPicModel.ResponseData) obj;
            msglistModel = this.f1423a.g;
            if (msglistModel != null) {
                msglistModel2 = this.f1423a.g;
                msglistModel2.a(responseData.getSPathGen(), responseData.getBitmap());
                return;
            }
            return;
        }
        this.f1423a.b(R.string.pic_parser_error);
    }
}
