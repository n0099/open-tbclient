package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatMessage f1823a;
    final /* synthetic */ String b;
    final /* synthetic */ x c;
    final /* synthetic */ MsglistModel d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MsglistModel msglistModel, ChatMessage chatMessage, String str, x xVar) {
        this.d = msglistModel;
        this.f1823a = chatMessage;
        this.b = str;
        this.c = xVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.d.a(this.f1823a, this.b, this.c);
    }
}
