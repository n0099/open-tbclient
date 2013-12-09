package com.baidu.tieba.im.hotGroup;

import android.content.Context;
import com.baidu.adp.lib.h.g;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.RequestHotGroupsMessage;
import com.baidu.tieba.im.messageCenter.e;
/* loaded from: classes.dex */
public class c {
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final int h = 30;
    private int b = g.a((Context) TiebaApplication.a(), 70.0f);

    /* renamed from: a  reason: collision with root package name */
    private int f1784a = g.a((Context) TiebaApplication.a(), 70.0f);
    private int c = 30;

    public void a(int i) {
        this.d = i;
    }

    public boolean a() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean b() {
        return this.f;
    }

    public void b(boolean z) {
        this.f = z;
    }

    public boolean c() {
        return this.g;
    }

    public void c(boolean z) {
        this.g = z;
    }

    public void d(boolean z) {
        if (!c()) {
            c(true);
            if (z) {
                RequestHotGroupsMessage requestHotGroupsMessage = new RequestHotGroupsMessage(this.b, this.f1784a, this.c, this.d);
                requestHotGroupsMessage.setCmd(-116);
                e.a().a(requestHotGroupsMessage);
                return;
            }
            e.a().a(new RequestHotGroupsMessage(this.b, this.f1784a, this.c, this.d));
        }
    }
}
