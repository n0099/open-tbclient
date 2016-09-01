package com.baidu.tieba.homepage.framework.b;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ e cDO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.cDO = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        context = this.cDO.mContext;
        if (context != null) {
            context2 = this.cDO.mContext;
            TiebaStatic.eventStat(context2, "notlogin_3", "click", 1, new Object[0]);
            TiebaStatic.log(new ay("c10517").ab("obj_source", "forum"));
            context3 = this.cDO.mContext;
            bn.aj(context3);
        }
    }
}
