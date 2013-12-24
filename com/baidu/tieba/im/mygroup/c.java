package com.baidu.tieba.im.mygroup;

import com.baidu.tieba.im.c.l;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
/* loaded from: classes.dex */
class c implements l {
    final /* synthetic */ MyGroupFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.c.l
    public void a(GroupNewsPojo groupNewsPojo) {
        this.a.b = true;
    }
}
