package com.baidu.tieba.im.model;

import java.util.Comparator;
/* loaded from: classes.dex */
final class ag implements Comparator<com.baidu.tieba.im.message.b> {
    final /* synthetic */ MsglistModel a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(com.baidu.tieba.im.message.b bVar, com.baidu.tieba.im.message.b bVar2) {
        com.baidu.tieba.im.message.b bVar3 = bVar;
        com.baidu.tieba.im.message.b bVar4 = bVar2;
        if (bVar3 == null || bVar4 == null) {
            return 0;
        }
        if (bVar3.j() > bVar4.j()) {
            return 1;
        }
        return bVar3.j() < bVar4.j() ? -1 : 0;
    }

    private ag(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MsglistModel msglistModel, byte b) {
        this(msglistModel);
    }
}
