package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.RequestReportGroupMessage;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.a.d {

    /* renamed from: a  reason: collision with root package name */
    private int f1762a;
    private int b;
    private RequestReportGroupMessage c;

    public void a(int i) {
        this.f1762a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    private RequestReportGroupMessage c() {
        RequestReportGroupMessage requestReportGroupMessage = new RequestReportGroupMessage();
        requestReportGroupMessage.setGroupId(this.f1762a);
        requestReportGroupMessage.setReportType(this.b);
        return requestReportGroupMessage;
    }

    public void a() {
        this.c = c();
        com.baidu.tieba.im.messageCenter.f.a().a(this.c);
    }

    public void b() {
        if (this.c != null) {
            com.baidu.tieba.im.messageCenter.f.a().b(this.c);
            this.c = null;
        }
    }
}
