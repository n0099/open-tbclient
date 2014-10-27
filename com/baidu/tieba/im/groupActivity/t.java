package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s aZx;
    private final /* synthetic */ GroupActivityActivity aZy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, GroupActivityActivity groupActivityActivity) {
        this.aZx = sVar;
        this.aZy = groupActivityActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Context context;
        this.aZx.On();
        dialog = this.aZx.aZu;
        context = this.aZx.mContext;
        com.baidu.adp.lib.g.j.a(dialog, (Activity) context);
        TiebaStatic.eventStat(this.aZy, "group_activity_edit", "groupclick", 1, new Object[0]);
    }
}
