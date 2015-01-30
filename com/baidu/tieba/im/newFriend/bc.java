package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class bc extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ bb blL;
    private final /* synthetic */ List blM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, List list) {
        this.blL = bbVar;
        this.blM = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        if (this.blM != null && this.blM.size() > 0) {
            com.baidu.tieba.im.db.m.Ne().ar(this.blM);
            return null;
        }
        return null;
    }
}
