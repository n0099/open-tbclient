package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import d.a.m0.m0.l;
import d.a.m0.q0.a;
/* loaded from: classes4.dex */
public class TiebaMainApplication extends TbadkApplication {
    @Override // com.baidu.tbadk.core.TbadkCoreApplication, com.baidu.adp.base.BdBaseApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        super.attachBaseContext(context);
        l.b().t(currentTimeMillis);
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        setPageStayOpen(true);
        super.onCreate();
        if (getSplash() != null) {
            getSplash().g();
        }
        if (a.a(getContext())) {
            TiebaStatic.log(new StatisticItem("c13616").param("obj_type", 1));
        } else {
            TiebaStatic.log(new StatisticItem("c13616").param("obj_type", 2));
        }
        l.b().J(System.currentTimeMillis());
    }
}
