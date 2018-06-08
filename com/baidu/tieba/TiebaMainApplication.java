package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.k.n;
/* loaded from: classes.dex */
public class TiebaMainApplication extends TbadkApplication {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.TbadkCoreApplication, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        super.attachBaseContext(context);
        n.Kx().aa(currentTimeMillis);
    }

    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        setPageStayOpen(true);
        super.onCreate();
        if (getSplash() != null) {
            getSplash().hide();
        }
        n.Kx().ab(System.currentTimeMillis());
    }
}
