package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class bc extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ bb bht;
    private final /* synthetic */ List bhu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, List list) {
        this.bht = bbVar;
        this.bhu = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        if (this.bhu != null && this.bhu.size() > 0) {
            com.baidu.tieba.im.db.m.MO().U(this.bhu);
            return null;
        }
        return null;
    }
}
