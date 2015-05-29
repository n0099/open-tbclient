package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class be extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ bd aAD;
    private final /* synthetic */ List aAE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, List list) {
        this.aAD = bdVar;
        this.aAE = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FQ */
    public Void doInBackground() {
        if (this.aAE != null && this.aAE.size() > 0) {
            ba.FW().z(this.aAE);
            return null;
        }
        return null;
    }
}
