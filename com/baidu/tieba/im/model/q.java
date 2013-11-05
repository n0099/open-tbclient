package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.tieba.im.messageCenter.h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistModel f1672a;

    private q(MsglistModel msglistModel) {
        this.f1672a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(MsglistModel msglistModel, i iVar) {
        this(msglistModel);
    }

    @Override // com.baidu.tieba.im.messageCenter.h
    public void a(Message message) {
        if (message == null) {
            com.baidu.adp.lib.h.d.a("msg == null");
        } else if (message.getCmd() == 103112) {
            this.f1672a.a(message);
        } else if (message.getCmd() == 103102) {
            this.f1672a.c(message);
        } else if (message.getCmd() == 202003) {
            this.f1672a.b(message);
        }
    }
}
