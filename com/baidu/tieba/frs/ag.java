package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ af f1069a;
    private final /* synthetic */ com.baidu.tieba.data.ai b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar, com.baidu.tieba.data.ai aiVar) {
        this.f1069a = afVar;
        this.b = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.f1069a.f1068a;
        StatService.onEvent(context, "frs_video", "frsclick", 1);
        context2 = this.f1069a.f1068a;
        UtilHelper.c(context2, this.b.c());
    }
}
