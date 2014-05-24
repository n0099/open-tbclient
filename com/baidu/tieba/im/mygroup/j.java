package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.b {
    private boolean c = false;
    public int a = com.baidu.adp.lib.util.k.a(TbadkApplication.m252getInst().getContext(), 70.0f);
    public int b = com.baidu.adp.lib.util.k.a(TbadkApplication.m252getInst().getContext(), 70.0f);

    public void a() {
        if (this.c) {
            super.sendMessage(new GroupsByUidMessage(this.a, this.b));
            return;
        }
        this.c = true;
        super.sendMessage(new GroupsByUidLocalMessage());
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }
}
