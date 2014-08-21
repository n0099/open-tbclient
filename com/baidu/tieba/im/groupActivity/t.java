package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s a;
    private final /* synthetic */ GroupActivityActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, GroupActivityActivity groupActivityActivity) {
        this.a = sVar;
        this.b = groupActivityActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Context context;
        this.a.f();
        dialog = this.a.r;
        context = this.a.mContext;
        com.baidu.adp.lib.e.e.a(dialog, (Activity) context);
        TiebaStatic.eventStat(this.b, "group_activity_edit", "groupclick", 1, new Object[0]);
    }
}
