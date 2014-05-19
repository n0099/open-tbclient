package com.baidu.tieba.im.live.livenotify;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.b<LinkedList<GroupNewsPojo>> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public LinkedList<GroupNewsPojo> a() {
        return com.baidu.tieba.im.db.d.a().a(0L, Integer.MAX_VALUE, 0, "live_notify");
    }
}
