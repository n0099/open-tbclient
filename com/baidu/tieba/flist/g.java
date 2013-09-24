package com.baidu.tieba.flist;

import com.baidu.tieba.util.av;
/* loaded from: classes.dex */
class g implements e {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.f1059a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.e
    public void a(boolean z, int i, com.baidu.tieba.square.s sVar, String str, boolean z2) {
        av.e("ForumListActivity", "callback", "start");
        if (!z || i != 0) {
            av.e("ForumListActivity", "callback", "dir menu not ok");
            if (!z2) {
                this.f1059a.c.d();
                return;
            }
            return;
        }
        av.e("ForumListActivity", "callback", "dir menu ok");
        sVar.e.add(0, sVar);
        if (this.f1059a.c.x != null) {
            this.f1059a.c.x.a(sVar);
            this.f1059a.c(String.valueOf(this.f1059a.c.g.getText()));
            this.f1059a.c.x.notifyDataSetChanged();
        }
    }
}
