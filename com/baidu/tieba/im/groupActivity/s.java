package com.baidu.tieba.im.groupActivity;

import android.app.Dialog;
import android.view.View;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ r a;
    private final /* synthetic */ GroupActivityActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, GroupActivityActivity groupActivityActivity) {
        this.a = rVar;
        this.b = groupActivityActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        this.a.i();
        dialog = this.a.t;
        dialog.show();
        cb.a(this.b, "group_activity_edit", "groupclick", 1, new Object[0]);
    }
}
