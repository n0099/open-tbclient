package com.baidu.tieba.im.c;

import android.os.Handler;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.r;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements com.baidu.tieba.im.a<com.baidu.tieba.im.db.e> {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(com.baidu.tieba.im.db.e eVar) {
        int i;
        long j;
        long j2;
        int i2;
        int i3;
        int i4;
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        if (r.a() > 10) {
            com.baidu.adp.lib.util.f.d("----pull message, but TiebaIMSingleExecutor.QueueSize too big");
            handler3 = this.a.l;
            handler4 = this.a.l;
            handler3.sendMessageDelayed(handler4.obtainMessage(2), 2000L);
        } else if (com.baidu.tieba.im.b.e.c()) {
            this.a.e = false;
            com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
            i = this.a.k;
            LinkedList<? extends com.baidu.adp.framework.message.d> a2 = a.a(202003, i);
            if (a2 != null && a2.size() > 0) {
                this.a.e = true;
                return;
            }
            if (TbadkApplication.j().q()) {
                long currentTimeMillis = System.currentTimeMillis();
                j = this.a.h;
                if (currentTimeMillis - j > 60000) {
                    j2 = this.a.f;
                    if (currentTimeMillis - j2 < 180000) {
                        i2 = this.a.g;
                        if (i2 < 20) {
                            b bVar = this.a;
                            i3 = bVar.g;
                            bVar.g = i3 + 1;
                            StringBuilder sb = new StringBuilder("----background pull skip. no pull count ");
                            i4 = this.a.g;
                            com.baidu.adp.lib.util.f.d(sb.append(i4).toString());
                            return;
                        }
                    }
                }
            }
            com.baidu.adp.lib.util.f.d("----real pull msg.");
            this.a.g = 0;
            com.baidu.adp.framework.c.a().a(b.f(this.a));
        } else {
            com.baidu.adp.lib.util.f.d("----pull message, but cache is initing... ");
            handler = this.a.l;
            handler2 = this.a.l;
            handler.sendMessageDelayed(handler2.obtainMessage(2), 2000L);
        }
    }
}
