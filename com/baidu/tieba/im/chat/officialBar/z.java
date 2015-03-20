package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class z extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ y aYX;
    private final /* synthetic */ LinkedList aYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, LinkedList linkedList) {
        this.aYX = yVar;
        this.aYY = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        return com.baidu.tieba.im.db.m.PY().j(this.aYY);
    }
}
