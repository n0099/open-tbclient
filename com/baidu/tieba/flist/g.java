package com.baidu.tieba.flist;

import com.baidu.tieba.util.aq;
/* loaded from: classes.dex */
class g implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1042a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.f1042a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.e
    public void a(boolean z, int i, com.baidu.tieba.square.s sVar, String str, boolean z2) {
        aq.e("ForumListActivity", "callback", "start");
        if (!z || i != 0) {
            aq.e("ForumListActivity", "callback", "dir menu not ok");
            if (!z2) {
                this.f1042a.c.d();
                return;
            }
            return;
        }
        aq.e("ForumListActivity", "callback", "dir menu ok");
        sVar.e.add(0, sVar);
        if (this.f1042a.c.x != null) {
            this.f1042a.c.x.a(sVar);
            this.f1042a.c.x.notifyDataSetChanged();
        }
    }
}
