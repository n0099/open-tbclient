package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ e cwc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.cwc = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.cwc.mContext;
        if (context != null) {
            context2 = this.cwc.mContext;
            TiebaStatic.eventStat(context2, "notlogin_3", "click", 1, new Object[0]);
            TiebaStatic.log(new ar("c10517").ab(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, "forum"));
            context3 = this.cwc.mContext;
            bf.ai(context3);
        }
    }
}
