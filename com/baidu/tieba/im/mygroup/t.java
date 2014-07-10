package com.baidu.tieba.im.mygroup;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.e {
    public int a;
    public int b;
    public long c;
    private RequestUserPermissionMessage d;
    private boolean e;

    public t() {
        this.e = false;
        this.a = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        this.b = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        this.c = 0L;
    }

    public t(long j) {
        this.e = false;
        this.a = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        this.b = com.baidu.adp.lib.util.j.a(TbadkApplication.m252getInst().getContext(), 70.0f);
        this.c = j;
    }

    public void a() {
        if (this.c == 0) {
            if (this.e) {
                super.sendMessage(new GroupsByUidMessage(this.a, this.b));
                return;
            }
            this.e = true;
            super.sendMessage(new GroupsByUidLocalMessage());
            return;
        }
        super.sendMessage(new GroupsByUidMessage(this.c, this.a, this.b));
    }

    public void a(long j) {
        this.d = b(j);
        super.sendMessage(this.d);
    }

    private RequestUserPermissionMessage b(long j) {
        RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
        requestUserPermissionMessage.setForumId(j);
        return requestUserPermissionMessage;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        super.cancelMessage();
        this.d = null;
    }
}
