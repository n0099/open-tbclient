package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ e cwb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.cwb = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.cwb.mContext;
        if (context != null) {
            context2 = this.cwb.mContext;
            TiebaStatic.eventStat(context2, "notlogin_4", "click", 1, new Object[0]);
            context3 = this.cwb.mContext;
            bg.aJ(context3);
        }
    }
}
