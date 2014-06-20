package com.baidu.tieba.frs;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dx implements View.OnClickListener {
    final /* synthetic */ WorldCupView a;
    private final /* synthetic */ com.baidu.tbadk.core.data.r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(WorldCupView worldCupView, com.baidu.tbadk.core.data.r rVar) {
        this.a = worldCupView;
        this.b = rVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.a.a;
        com.baidu.tbadk.core.f.a(context, "wcup_dqd");
        if (!TextUtils.isEmpty(this.b.d())) {
            com.baidu.tbadk.core.util.bk a = com.baidu.tbadk.core.util.bk.a();
            context2 = this.a.a;
            a.a(context2, new String[]{this.b.d()});
        }
    }
}
