package com.baidu.tieba.frs;

import android.content.Context;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ae f1116a;
    private final /* synthetic */ com.baidu.tieba.data.ai b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ae aeVar, com.baidu.tieba.data.ai aiVar) {
        this.f1116a = aeVar;
        this.b = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.f1116a.f1115a;
        StatService.onEvent(context, "frs_video", "frsclick", 1);
        context2 = this.f1116a.f1115a;
        UtilHelper.c(context2, this.b.c());
    }
}
