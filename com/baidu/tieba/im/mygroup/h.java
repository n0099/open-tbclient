package com.baidu.tieba.im.mygroup;

import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.l;
import com.baidu.tieba.im.message.m;
/* loaded from: classes.dex */
public final class h {
    private boolean c = false;
    public int a = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);
    public int b = BdUtilHelper.a(TiebaApplication.g().c(), 70.0f);

    public final void a() {
        if (this.c) {
            com.baidu.tieba.im.messageCenter.d.a().a(new m(this.a, this.b));
            return;
        }
        this.c = true;
        com.baidu.tieba.im.messageCenter.d.a().a(new l());
    }
}
