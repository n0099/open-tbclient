package com.baidu.tieba.im.groupUpdates;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ p bcj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.bcj = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        List<UpdatesItemData> list;
        com.baidu.tieba.im.db.d Mx = com.baidu.tieba.im.db.d.Mx();
        list = this.bcj.bch;
        return Boolean.valueOf(Mx.T(list));
    }
}
