package com.baidu.tieba.home;

import android.app.Activity;
import android.view.View;
import com.baidu.tieba.account.SapiFastRegActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ Activity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar, Activity activity) {
        this.a = rVar;
        this.b = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        activity = this.a.a;
        SapiFastRegActivity.a(activity, 22002);
    }
}
