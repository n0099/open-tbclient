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
    final /* synthetic */ e cys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.cys = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.cys.mContext;
        if (context != null) {
            context2 = this.cys.mContext;
            TiebaStatic.eventStat(context2, "notlogin_3", "click", 1, new Object[0]);
            TiebaStatic.log(new as("c10517").aa(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "forum"));
            context3 = this.cys.mContext;
            bg.aI(context3);
        }
    }
}
