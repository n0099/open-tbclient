package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1242a;
    final /* synthetic */ Context b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, i iVar, Context context) {
        this.c = nVar;
        this.f1242a = iVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity.a(this.b, 2);
    }
}
