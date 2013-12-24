package com.baidu.tieba.im.model;

import java.util.Comparator;
/* loaded from: classes.dex */
class aa implements Comparator<com.baidu.tieba.im.message.b> {
    final /* synthetic */ MsglistModel a;

    private aa(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aa(MsglistModel msglistModel, n nVar) {
        this(msglistModel);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.baidu.tieba.im.message.b bVar, com.baidu.tieba.im.message.b bVar2) {
        if (bVar == null || bVar2 == null) {
            return 0;
        }
        if (bVar.i() > bVar2.i()) {
            return 1;
        }
        return bVar.i() < bVar2.i() ? -1 : 0;
    }
}
