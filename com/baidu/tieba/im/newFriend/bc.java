package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class bc extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ bb bhf;
    private final /* synthetic */ List bhg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, List list) {
        this.bhf = bbVar;
        this.bhg = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        if (this.bhg != null && this.bhg.size() > 0) {
            com.baidu.tieba.im.db.m.MK().U(this.bhg);
            return null;
        }
        return null;
    }
}
