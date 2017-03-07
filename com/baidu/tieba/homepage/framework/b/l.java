package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ e cxB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.cxB = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.cxB.mContext;
        if (context != null) {
            context2 = this.cxB.mContext;
            TiebaStatic.eventStat(context2, "notlogin_3", "click", 1, new Object[0]);
            TiebaStatic.log(new as("c10517").Z(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "forum"));
            context3 = this.cxB.mContext;
            bg.aG(context3);
        }
    }
}
