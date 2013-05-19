package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ ad a;
    private final /* synthetic */ com.baidu.tieba.a.ag b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, com.baidu.tieba.a.ag agVar) {
        this.a = adVar;
        this.b = agVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.a.a;
        StatService.onEvent(context, "frs_video", "frsclick", 1);
        context2 = this.a.a;
        com.baidu.tieba.d.ag.c(context2, this.b.c());
    }
}
