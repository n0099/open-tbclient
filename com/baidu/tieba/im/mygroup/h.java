package com.baidu.tieba.im.mygroup;

import android.content.Context;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.j;
/* loaded from: classes.dex */
public class h {
    private boolean c = false;
    public int a = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f);
    public int b = com.baidu.adp.lib.h.g.a((Context) TiebaApplication.a(), 70.0f);

    public void a() {
        if (this.c) {
            com.baidu.tieba.im.messageCenter.e.a().a(new j(this.a, this.b));
            return;
        }
        this.c = true;
        com.baidu.tieba.im.messageCenter.e.a().a(new com.baidu.tieba.im.message.i());
    }
}
