package com.baidu.tieba.im.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1425a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(MsglistActivity msglistActivity) {
        this.f1425a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        bh bhVar;
        MsglistModel msglistModel;
        MsglistModel msglistModel2;
        MsglistModel msglistModel3;
        bh bhVar2;
        bh bhVar3;
        if (bool != null) {
            if (bool.booleanValue()) {
                bhVar3 = this.f1425a.f;
                bhVar3.H();
            } else {
                bhVar = this.f1425a.f;
                bhVar.I();
            }
            msglistModel = this.f1425a.g;
            if (msglistModel != null) {
                msglistModel2 = this.f1425a.g;
                if (msglistModel2.a() != null) {
                    msglistModel3 = this.f1425a.g;
                    String name = msglistModel3.a().getName();
                    if (!TextUtils.isEmpty(name)) {
                        bhVar2 = this.f1425a.f;
                        bhVar2.a(name, true);
                    }
                }
            }
        }
    }
}
