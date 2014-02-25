package com.baidu.tieba.im.model;

import java.util.Comparator;
/* loaded from: classes.dex */
class ag implements Comparator<com.baidu.tieba.im.message.b> {
    final /* synthetic */ MsglistModel a;

    private ag(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(MsglistModel msglistModel, ag agVar) {
        this(msglistModel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.tieba.im.message.b bVar, com.baidu.tieba.im.message.b bVar2) {
        if (bVar == null || bVar2 == null) {
            return 0;
        }
        if (bVar.j() > bVar2.j()) {
            return 1;
        }
        return bVar.j() < bVar2.j() ? -1 : 0;
    }
}
