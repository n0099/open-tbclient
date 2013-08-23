package com.baidu.tieba.home;

import android.content.Context;
import android.view.View;
import com.baidu.tieba.MainTabActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ x f1199a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, Context context) {
        this.f1199a = xVar;
        this.b = context;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MainTabActivity.a(this.b, 2);
    }
}
