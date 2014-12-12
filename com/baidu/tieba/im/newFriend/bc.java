package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class bc extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ bb bko;
    private final /* synthetic */ List bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, List list) {
        this.bko = bbVar;
        this.bkp = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        if (this.bkp != null && this.bkp.size() > 0) {
            com.baidu.tieba.im.db.m.MI().ap(this.bkp);
            return null;
        }
        return null;
    }
}
