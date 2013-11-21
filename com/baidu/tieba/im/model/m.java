package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatMessage f1746a;
    final /* synthetic */ MsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MsglistModel msglistModel, ChatMessage chatMessage) {
        this.b = msglistModel;
        this.f1746a = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.a(this.f1746a);
    }
}
