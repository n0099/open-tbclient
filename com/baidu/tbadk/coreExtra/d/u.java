package com.baidu.tbadk.coreExtra.d;

import com.baidu.tbadk.core.util.WebSocketStateHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements k {
    final /* synthetic */ q a;
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, String str, String str2, int i) {
        this.a = qVar;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    @Override // com.baidu.tbadk.coreExtra.d.k
    public void a(boolean z) {
        int i;
        int i2;
        e.a().a(z ? 1 : 0, this.b);
        if (z) {
            this.a.b = 0;
            WebSocketStateHelper.a(WebSocketStateHelper.WebSocketStateInfo.ONLINE);
            this.a.h = false;
            com.baidu.adp.framework.c.c.a().c("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.c.c.a().a(this.b);
            com.baidu.adp.framework.c.c.a().a(true, this.c);
            this.a.e = true;
            q qVar = this.a;
            i2 = qVar.d;
            qVar.d = i2 + 1;
            return;
        }
        q qVar2 = this.a;
        i = qVar2.d;
        qVar2.d = i + 1;
        this.a.a(this.c, this.d);
    }
}
