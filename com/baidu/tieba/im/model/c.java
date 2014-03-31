package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends com.baidu.adp.framework.c.g {
    final /* synthetic */ CommonGroupMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(CommonGroupMsglistModel commonGroupMsglistModel, int i) {
        super(0);
        this.a = commonGroupMsglistModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null) {
            com.baidu.adp.lib.util.f.b("msg == null");
        } else if (socketResponsedMessage2.g() == 103112) {
            CommonGroupMsglistModel.a(this.a, socketResponsedMessage2);
        } else if (socketResponsedMessage2.g() == 103102) {
            CommonGroupMsglistModel.b(this.a, socketResponsedMessage2);
        }
    }
}
