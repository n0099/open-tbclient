package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatMessage f1747a;
    final /* synthetic */ String b;
    final /* synthetic */ MsglistModel c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(MsglistModel msglistModel, ChatMessage chatMessage, String str) {
        this.c = msglistModel;
        this.f1747a = chatMessage;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.c.a(this.f1747a, this.b);
    }
}
