package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.n.n;
/* loaded from: classes.dex */
public class TiebaMainApplication extends TbadkApplication {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.TbadkCoreApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        super.attachBaseContext(context);
        n.bCz().dI(currentTimeMillis);
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        setPageStayOpen(true);
        super.onCreate();
        if (getSplash() != null) {
            getSplash().hide();
        }
        if (com.baidu.tbadk.p.a.cR(getContext())) {
            TiebaStatic.log(new aq("c13616").al("obj_type", 1));
        } else {
            TiebaStatic.log(new aq("c13616").al("obj_type", 2));
        }
        n.bCz().dJ(System.currentTimeMillis());
    }
}
