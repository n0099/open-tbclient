package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistModel f1826a;

    private r(MsglistModel msglistModel) {
        this.f1826a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ r(MsglistModel msglistModel, i iVar) {
        this(msglistModel);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        if (message == null) {
            com.baidu.adp.lib.h.e.a("msg == null");
        } else if (message.getCmd() == 103112) {
            this.f1826a.a(message);
        } else if (message.getCmd() == 103102) {
            this.f1826a.c(message);
        } else if (message.getCmd() == 202003) {
            this.f1826a.b(message);
        } else if (message.getCmd() == -113) {
            this.f1826a.l();
        }
    }
}
