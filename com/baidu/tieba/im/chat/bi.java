package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(ba baVar) {
        this.a = baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bs bsVar;
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        MsglistModel msglistModel3;
        bs bsVar2;
        bs bsVar3;
        if (bool != null) {
            if (bool.booleanValue()) {
                bsVar3 = this.a.g;
                bsVar3.H();
            } else {
                bsVar = this.a.g;
                bsVar.I();
            }
            msglistModel = this.a.h;
            if (msglistModel != null) {
                msglistModel2 = this.a.h;
                if (msglistModel2.a() != null) {
                    msglistModel3 = this.a.h;
                    String name = msglistModel3.a().getName();
                    if (!TextUtils.isEmpty(name)) {
                        bsVar2 = this.a.g;
                        bsVar2.a(name, true);
                    }
                }
            }
        }
    }
}
