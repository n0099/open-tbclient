package com.baidu.tieba.im.model;

import android.content.Context;
import com.baidu.tieba.im.message.RequestReportGroupMessage;
/* loaded from: classes.dex */
public class ax extends com.baidu.adp.base.e {
    private int a;
    private int b;
    private RequestReportGroupMessage c;

    public ax(Context context) {
        super(context);
    }

    public void a(int i) {
        this.a = i;
    }

    public void b(int i) {
        this.b = i;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
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

    @Override // com.baidu.adp.base.e
    public void cancelMessage() {
        super.cancelMessage();
        this.c = null;
    }
}
