package com.baidu.tieba.im.live.livenotify;

import com.baidu.tieba.im.groupUpdates.UpdatesItemData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.a = oVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        List<UpdatesItemData> list;
        com.baidu.tieba.im.db.d a = com.baidu.tieba.im.db.d.a();
        list = this.a.a;
        return Boolean.valueOf(a.a(list));
    }
}
