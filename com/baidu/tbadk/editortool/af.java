package com.baidu.tbadk.editortool;

import com.baidu.tbadk.core.message.EmptyMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class af implements Runnable {
    final /* synthetic */ ac a;
    private final /* synthetic */ ArrayList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ac acVar, ArrayList arrayList) {
        this.a = acVar;
        this.b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b = this.b;
        com.baidu.adp.framework.c.a().b(new EmptyMessage(2001120));
    }
}
