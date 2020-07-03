package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.n.n;
/* loaded from: classes.dex */
public class TiebaMainApplication extends TbadkApplication {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.TbadkCoreApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        super.attachBaseContext(context);
        n.bhU().cw(currentTimeMillis);
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        setPageStayOpen(true);
        super.onCreate();
        if (getSplash() != null) {
            getSplash().hide();
        }
        if (com.baidu.tbadk.p.a.cB(getContext())) {
            TiebaStatic.log(new ao("c13616").ag("obj_type", 1));
        } else {
            TiebaStatic.log(new ao("c13616").ag("obj_type", 2));
        }
        n.bhU().cx(System.currentTimeMillis());
    }
}
