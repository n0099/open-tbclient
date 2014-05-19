package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestReportGroupMessage;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.base.d {
    private int a;
    private int b;
    private RequestReportGroupMessage c;

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.adp.base.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.d
    public boolean cancelLoadData() {
        return false;
    }

    private RequestReportGroupMessage b() {
        RequestReportGroupMessage requestReportGroupMessage = new RequestReportGroupMessage();
        requestReportGroupMessage.setGroupId(this.a);
        requestReportGroupMessage.setReportType(this.b);
        return requestReportGroupMessage;
    }

    public void a() {
        this.c = b();
        super.sendMessage(this.c);
    }

    @Override // com.baidu.adp.base.d
    public void cancelMessage() {
        super.cancelMessage();
        this.c = null;
    }
}
