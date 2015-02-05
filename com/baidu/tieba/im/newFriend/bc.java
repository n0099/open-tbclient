package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class bc extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ bb blK;
    private final /* synthetic */ List blL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, List list) {
        this.blK = bbVar;
        this.blL = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        if (this.blL != null && this.blL.size() > 0) {
            com.baidu.tieba.im.db.m.MZ().ar(this.blL);
            return null;
        }
        return null;
    }
}
