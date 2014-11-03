package com.baidu.tieba.im.groupActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ s aZK;
    private final /* synthetic */ GroupActivityActivity aZL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, GroupActivityActivity groupActivityActivity) {
        this.aZK = sVar;
        this.aZL = groupActivityActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Dialog dialog;
        Context context;
        this.aZK.Oq();
        dialog = this.aZK.aZH;
        context = this.aZK.mContext;
        com.baidu.adp.lib.g.j.a(dialog, (Activity) context);
        TiebaStatic.eventStat(this.aZL, "group_activity_edit", "groupclick", 1, new Object[0]);
    }
}
