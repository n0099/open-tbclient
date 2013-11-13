package com.baidu.tieba.flist;

import android.os.Handler;
import com.baidu.tieba.util.bg;
/* loaded from: classes.dex */
class h implements f {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ForumListActivity forumListActivity) {
        this.f1250a = forumListActivity;
    }

    @Override // com.baidu.tieba.flist.f
    public void a(boolean z, int i, com.baidu.tieba.square.z zVar, String str, boolean z2) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        bg.e("ForumListActivity", "callback", "start");
        if (!z || i != 0) {
            bg.e("ForumListActivity", "callback", "dir menu not ok");
            if (!z2) {
                this.f1250a.c.d();
                return;
            }
            return;
        }
        bg.e("ForumListActivity", "callback", "dir menu ok");
        zVar.e.add(0, zVar);
        if (this.f1250a.c.w != null) {
            this.f1250a.c.w.a(zVar);
            this.f1250a.a(String.valueOf(this.f1250a.c.f.getText()));
            this.f1250a.c.w.notifyDataSetChanged();
        }
        handler = this.f1250a.e;
        runnable = this.f1250a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.f1250a.e;
        runnable2 = this.f1250a.P;
        handler2.post(runnable2);
    }
}
