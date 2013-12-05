package com.baidu.tieba.flist;

import android.os.Handler;
import com.baidu.tieba.util.bd;
/* loaded from: classes.dex */
class h implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1302a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.f1302a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.f
    public void a(boolean z, int i, com.baidu.tieba.square.z zVar, String str, boolean z2) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bd.e("ForumListActivity", "callback", "start");
        if (!z || i != 0) {
            bd.e("ForumListActivity", "callback", "dir menu not ok");
            if (!z2) {
                this.f1302a.c.d();
                return;
            }
            return;
        }
        bd.e("ForumListActivity", "callback", "dir menu ok");
        zVar.e.add(0, zVar);
        if (this.f1302a.c.x != null) {
            this.f1302a.c.x.a(zVar);
            this.f1302a.a(String.valueOf(this.f1302a.c.g.getText()));
            this.f1302a.c.x.notifyDataSetChanged();
        }
        handler = this.f1302a.e;
        runnable = this.f1302a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.f1302a.e;
        runnable2 = this.f1302a.P;
        handler2.post(runnable2);
        this.f1302a.c.y.setClickable(true);
        this.f1302a.c.y.setOnClickListener(this.f1302a);
    }
}
