package com.baidu.tieba.flist;
/* loaded from: classes.dex */
class g implements e {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.e
    public void a(boolean z, int i, com.baidu.tieba.square.w wVar, String str, boolean z2) {
        if (!z || i != 0) {
            if (!z2) {
                this.a.c.d();
                return;
            }
            return;
        }
        wVar.e.add(0, wVar);
        if (this.a.c.y != null) {
            this.a.c.y.a(wVar);
            this.a.a(String.valueOf(this.a.c.h.getText()));
            this.a.c.y.notifyDataSetChanged();
        }
        this.a.c.z.setClickable(true);
        this.a.c.z.setOnClickListener(this.a);
    }
}
