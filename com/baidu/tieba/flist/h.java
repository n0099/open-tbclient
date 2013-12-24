package com.baidu.tieba.flist;

import android.os.Handler;
import com.baidu.tieba.util.be;
/* loaded from: classes.dex */
class h implements f {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.f
    public void a(boolean z, int i, com.baidu.tieba.square.z zVar, String str, boolean z2) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        be.e("ForumListActivity", "callback", "start");
        if (!z || i != 0) {
            be.e("ForumListActivity", "callback", "dir menu not ok");
            if (!z2) {
                this.a.c.d();
                return;
            }
            return;
        }
        be.e("ForumListActivity", "callback", "dir menu ok");
        zVar.e.add(0, zVar);
        if (this.a.c.x != null) {
            this.a.c.x.a(zVar);
            this.a.a(String.valueOf(this.a.c.g.getText()));
            this.a.c.x.notifyDataSetChanged();
        }
        handler = this.a.e;
        runnable = this.a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.a.e;
        runnable2 = this.a.P;
        handler2.post(runnable2);
        this.a.c.y.setClickable(true);
        this.a.c.y.setOnClickListener(this.a);
    }
}
