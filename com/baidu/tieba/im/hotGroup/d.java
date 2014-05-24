package com.baidu.tieba.im.hotGroup;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.RequestHotGroupsByLocalMessage;
import com.baidu.tieba.im.message.RequestHotGroupsMessage;
/* loaded from: classes.dex */
public class d {
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private final int h = 30;
    private int b = k.a(TbadkApplication.m252getInst().getContext(), 70.0f);
    private int a = k.a(TbadkApplication.m252getInst().getContext(), 70.0f);
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
                MessageManager.getInstance().sendMessage(new RequestHotGroupsByLocalMessage(this.b, this.a, this.c, this.d));
                return;
            }
            MessageManager.getInstance().sendMessage(new RequestHotGroupsMessage(this.b, this.a, this.c, this.d));
        }
    }
}
