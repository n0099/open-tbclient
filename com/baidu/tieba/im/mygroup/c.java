package com.baidu.tieba.im.mygroup;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.pushNotify.k;
/* loaded from: classes.dex */
class c implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MyGroupFragment f1835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(MyGroupFragment myGroupFragment) {
        this.f1835a = myGroupFragment;
    }

    @Override // com.baidu.tieba.im.pushNotify.k
    public void a(GroupNewsPojo groupNewsPojo) {
        this.f1835a.b = true;
    }
}
