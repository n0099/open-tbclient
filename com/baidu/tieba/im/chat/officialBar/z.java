package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ y aZn;
    private final /* synthetic */ LinkedList aZo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, LinkedList linkedList) {
        this.aZn = yVar;
        this.aZo = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.m.Ql().j(this.aZo);
    }
}
