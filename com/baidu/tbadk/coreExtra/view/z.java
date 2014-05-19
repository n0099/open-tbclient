package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LiveBroadcastCard liveBroadcastCard) {
        this.a = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab abVar;
        ab abVar2;
        String str;
        Context context;
        String str2;
        abVar = this.a.a;
        if (abVar != null) {
            abVar2 = this.a.a;
            abVar2.onClick(this.a);
            return;
        }
        str = this.a.D;
        if (!TextUtils.isEmpty(str)) {
            context = this.a.c;
            str2 = this.a.D;
            com.baidu.tbadk.core.g.a(context, str2);
        }
        this.a.h();
    }
}
