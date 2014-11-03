package com.baidu.tieba.im.groupUpdates;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ p bcx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.bcx = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        List<UpdatesItemData> list;
        com.baidu.tieba.im.db.d MB = com.baidu.tieba.im.db.d.MB();
        list = this.bcx.bcv;
        return Boolean.valueOf(MB.T(list));
    }
}
