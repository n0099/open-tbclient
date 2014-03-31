package com.baidu.tieba.im.groupActivity;

import android.app.Dialog;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements View.OnClickListener {
    final /* synthetic */ s a;
    private final /* synthetic */ GroupActivityActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, GroupActivityActivity groupActivityActivity) {
        this.a = sVar;
        this.b = groupActivityActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog;
        s.a(this.a);
        dialog = this.a.t;
        dialog.show();
        TiebaStatic.a(this.b, "group_activity_edit", "groupclick", 1, new Object[0]);
    }
}
