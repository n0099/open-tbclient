package com.baidu.tieba.frs.view;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.b.ai;
import com.baidu.tbadk.core.data.PraiseData;
/* loaded from: classes.dex */
final class k implements View.OnClickListener {
    final /* synthetic */ FrsPraiseView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsPraiseView frsPraiseView) {
        this.a = frsPraiseView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PraiseData praiseData;
        Context context;
        String str;
        String str2;
        boolean z;
        PraiseData praiseData2;
        String str3 = "";
        praiseData = this.a.e;
        if (praiseData != null) {
            praiseData2 = this.a.e;
            str3 = praiseData2.getTitle();
        }
        com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
        context = this.a.a;
        str = this.a.g;
        str2 = this.a.h;
        z = this.a.i;
        a.a(new com.baidu.adp.framework.message.a(2001007, new ai(context, str, str2, str3, z)));
    }
}
