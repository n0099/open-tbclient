package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.a.e {
    private boolean c = false;
    public int a = com.baidu.adp.lib.util.i.a(TbadkApplication.j().c(), 70.0f);
    public int b = com.baidu.adp.lib.util.i.a(TbadkApplication.j().c(), 70.0f);

    public final void a() {
        if (this.c) {
            super.sendMessage(new com.baidu.tieba.im.message.f(this.a, this.b));
            return;
        }
        this.c = true;
        super.sendMessage(new com.baidu.tieba.im.message.e());
    }

    @Override // com.baidu.adp.a.e
    protected final boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.e
    public final boolean cancelLoadData() {
        return false;
    }
}
