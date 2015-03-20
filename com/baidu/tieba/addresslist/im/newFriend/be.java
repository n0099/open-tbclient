package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class be extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ bd ayK;
    private final /* synthetic */ List ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, List list) {
        this.ayK = bdVar;
        this.ayL = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: ER */
    public Void doInBackground() {
        if (this.ayL != null && this.ayL.size() > 0) {
            ba.EX().y(this.ayL);
            return null;
        }
        return null;
    }
}
