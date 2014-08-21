package com.baidu.tieba.im.mygroup;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.base.e {
    public int a;
    public int b;
    private boolean c;

    public k(Context context) {
        super(context);
        this.c = false;
        this.a = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        this.b = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
    }

    public void a() {
        if (this.c) {
            super.sendMessage(new GroupsByUidMessage(this.a, this.b));
            return;
        }
        this.c = true;
        super.sendMessage(new GroupsByUidLocalMessage());
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
