package com.baidu.tieba.flist;

import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class h implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1192a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.f1192a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.f
    public void a(boolean z, int i, com.baidu.tieba.square.s sVar, String str, boolean z2) {
        be.e("ForumListActivity", "callback", "start");
        if (!z || i != 0) {
            be.e("ForumListActivity", "callback", "dir menu not ok");
            if (!z2) {
                this.f1192a.c.d();
                return;
            }
            return;
        }
        be.e("ForumListActivity", "callback", "dir menu ok");
        sVar.e.add(0, sVar);
        if (this.f1192a.c.x != null) {
            this.f1192a.c.x.a(sVar);
            this.f1192a.c(String.valueOf(this.f1192a.c.g.getText()));
            this.f1192a.c.x.notifyDataSetChanged();
        }
    }
}
