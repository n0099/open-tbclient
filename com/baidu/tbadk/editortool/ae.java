package com.baidu.tbadk.editortool;

import com.baidu.tbadk.core.message.EmptyMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae implements Runnable {
    final /* synthetic */ ab a;
    private final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ab abVar, ArrayList arrayList) {
        this.a = abVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b = this.b;
        com.baidu.adp.framework.c.a().b(new EmptyMessage(2001120));
    }
}
