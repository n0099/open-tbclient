package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.SapiFastRegActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ o a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.a = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.a.a;
        SapiFastRegActivity.a(activity, 22002);
    }
}
