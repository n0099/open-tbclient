package com.baidu.tieba.im.model;

import com.baidu.tbadk.core.message.RequestGetMaskInfoMessage;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
/* loaded from: classes.dex */
public class b extends com.baidu.adp.base.e {
    private RequestGetMaskInfoMessage a;
    private RequestUpdateMaskInfoMessage b;
    private int c = 2;

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        super.cancelMessage();
        return false;
    }

    public void a() {
        this.a = new RequestGetMaskInfoMessage();
        this.a.setMaskType(10);
        super.sendMessage(this.a);
    }

    public void a(long j) {
        this.b = new RequestUpdateMaskInfoMessage();
        this.b.setIsMask(1);
        this.b.setMaskType(10);
        this.b.setList(String.valueOf(j));
        super.sendMessage(this.b);
    }

    public void b(long j) {
        this.b = new RequestUpdateMaskInfoMessage();
        this.b.setIsMask(0);
        this.b.setMaskType(10);
        this.b.setList(String.valueOf(j));
        super.sendMessage(this.b);
    }
}
