package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class be extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ bd aAE;
    private final /* synthetic */ List aAF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, List list) {
        this.aAE = bdVar;
        this.aAF = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: FR */
    public Void doInBackground() {
        if (this.aAF != null && this.aAF.size() > 0) {
            ba.FX().z(this.aAF);
            return null;
        }
        return null;
    }
}
