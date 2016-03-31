package com.baidu.tieba;

import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class TiebaMainApplication extends TbadkApplication {
    @Override // com.baidu.tbadk.TbadkApplication, com.baidu.tbadk.core.TbadkCoreApplication, android.app.Application
    public void onCreate() {
        setPageStayOpen(true);
        super.onCreate();
    }
}
