package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ e csG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.csG = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.csG.mContext;
        if (context != null) {
            context2 = this.csG.mContext;
            TiebaStatic.eventStat(context2, "notlogin_4", "click", 1, new Object[0]);
            context3 = this.csG.mContext;
            bn.aa(context3);
        }
    }
}
