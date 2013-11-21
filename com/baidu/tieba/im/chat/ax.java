package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(MsglistActivity msglistActivity) {
        this.f1508a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bg bgVar;
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        MsglistModel msglistModel3;
        bg bgVar2;
        bg bgVar3;
        if (bool != null) {
            if (bool.booleanValue()) {
                bgVar3 = this.f1508a.f;
                bgVar3.H();
            } else {
                bgVar = this.f1508a.f;
                bgVar.I();
            }
            msglistModel = this.f1508a.g;
            if (msglistModel != null) {
                msglistModel2 = this.f1508a.g;
                if (msglistModel2.a() != null) {
                    msglistModel3 = this.f1508a.g;
                    String name = msglistModel3.a().getName();
                    if (!TextUtils.isEmpty(name)) {
                        bgVar2 = this.f1508a.f;
                        bgVar2.a(name, true);
                    }
                }
            }
        }
    }
}
