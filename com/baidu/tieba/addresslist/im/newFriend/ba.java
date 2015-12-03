package com.baidu.tieba.addresslist.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class ba extends com.baidu.tbadk.util.m<Void> {
    final /* synthetic */ az aJi;
    private final /* synthetic */ List aJj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar, List list) {
        this.aJi = azVar;
        this.aJj = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        if (this.aJj != null && this.aJj.size() > 0) {
            aw.Hr().z(this.aJj);
            return null;
        }
        return null;
    }
}
