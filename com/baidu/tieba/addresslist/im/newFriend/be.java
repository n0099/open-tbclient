package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class be extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ bd ayS;
    private final /* synthetic */ List ayT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, List list) {
        this.ayS = bdVar;
        this.ayT = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        if (this.ayT != null && this.ayT.size() > 0) {
            ba.Fd().y(this.ayT);
            return null;
        }
        return null;
    }
}
