package com.baidu.tieba.im.live.livenotify;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ LiveNotifyActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LiveNotifyActivity liveNotifyActivity) {
        this.a = liveNotifyActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        s sVar;
        s sVar2;
        sVar = this.a.b;
        sVar.a(o.a(linkedList));
        sVar2 = this.a.b;
        sVar2.a(false);
        this.a.d();
    }
}
