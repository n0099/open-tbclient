package com.baidu.tbadk.coreExtra.share;

import android.content.Context;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements a {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public final void a() {
        Context context;
        context = this.a.b;
        i.a(context, l.auth_account_success);
    }

    @Override // com.baidu.tbadk.coreExtra.share.a
    public final void b() {
        Context context;
        context = this.a.b;
        i.a(context, l.share_success);
    }
}
