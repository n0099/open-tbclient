package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ LiveBroadcastCard a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LiveBroadcastCard liveBroadcastCard) {
        this.a = liveBroadcastCard;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        String str;
        Context context;
        String str2;
        adVar = this.a.a;
        if (adVar != null) {
            adVar2 = this.a.a;
            adVar2.onClick(this.a);
            return;
        }
        str = this.a.D;
        if (!TextUtils.isEmpty(str)) {
            context = this.a.c;
            str2 = this.a.D;
            com.baidu.tbadk.core.f.a(context, str2);
        }
        this.a.h();
    }
}
