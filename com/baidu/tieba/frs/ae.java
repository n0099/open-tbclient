package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.tieba.data.ai f1249a;
    final /* synthetic */ ad b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, com.baidu.tieba.data.ai aiVar) {
        this.b = adVar;
        this.f1249a = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.b.f1248a;
        StatService.onEvent(context, "frs_video", "frsclick", 1);
        context2 = this.b.f1248a;
        UtilHelper.c(context2, this.f1249a.c());
    }
}
