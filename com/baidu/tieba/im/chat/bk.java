package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bk implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bc bcVar) {
        this.a = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bu buVar;
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        MsglistModel msglistModel3;
        bu buVar2;
        bu buVar3;
        if (bool != null) {
            if (bool.booleanValue()) {
                buVar3 = this.a.g;
                buVar3.G();
            } else {
                buVar = this.a.g;
                buVar.H();
            }
            msglistModel = this.a.h;
            if (msglistModel != null) {
                msglistModel2 = this.a.h;
                if (msglistModel2.a() != null) {
                    msglistModel3 = this.a.h;
                    String name = msglistModel3.a().getName();
                    if (!TextUtils.isEmpty(name)) {
                        buVar2 = this.a.g;
                        buVar2.a(name, true);
                    }
                }
            }
        }
    }
}
