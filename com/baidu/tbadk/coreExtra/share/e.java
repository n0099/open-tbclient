package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import com.baidu.adp.lib.util.h;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void a() {
        Context context;
        context = this.a.b;
        h.a(context, u.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void b() {
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void c() {
        Context context;
        context = this.a.b;
        h.a(context, u.share_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public void d() {
    }
}
