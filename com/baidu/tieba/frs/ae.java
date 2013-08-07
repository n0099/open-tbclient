package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ad f1053a;
    private final /* synthetic */ com.baidu.tieba.data.am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, com.baidu.tieba.data.am amVar) {
        this.f1053a = adVar;
        this.b = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.f1053a.f1052a;
        StatService.onEvent(context, "frs_video", "frsclick", 1);
        context2 = this.f1053a.f1052a;
        com.baidu.tieba.util.am.c(context2, this.b.c());
    }
}
