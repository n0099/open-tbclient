package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1563a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(MsglistActivity msglistActivity) {
        this.f1563a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bm bmVar;
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        MsglistModel msglistModel3;
        bm bmVar2;
        bm bmVar3;
        if (bool != null) {
            if (bool.booleanValue()) {
                bmVar3 = this.f1563a.f;
                bmVar3.F();
            } else {
                bmVar = this.f1563a.f;
                bmVar.G();
            }
            msglistModel = this.f1563a.g;
            if (msglistModel != null) {
                msglistModel2 = this.f1563a.g;
                if (msglistModel2.a() != null) {
                    msglistModel3 = this.f1563a.g;
                    String name = msglistModel3.a().getName();
                    if (!TextUtils.isEmpty(name)) {
                        bmVar2 = this.f1563a.f;
                        bmVar2.a(name, true);
                    }
                }
            }
        }
    }
}
