package com.baidu.tieba.im.model;

import java.util.Comparator;
/* loaded from: classes.dex */
final class aw implements Comparator<com.baidu.tieba.im.message.a.a> {
    final /* synthetic */ MsglistModel a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(com.baidu.tieba.im.message.a.a aVar, com.baidu.tieba.im.message.a.a aVar2) {
        com.baidu.tieba.im.message.a.a aVar3 = aVar;
        com.baidu.tieba.im.message.a.a aVar4 = aVar2;
        if (aVar3 == null || aVar4 == null) {
            return 0;
        }
        if (aVar3.u() > aVar4.u()) {
            return 1;
        }
        return aVar3.u() < aVar4.u() ? -1 : 0;
    }

    private aw(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aw(MsglistModel msglistModel, byte b) {
        this(msglistModel);
    }
}
