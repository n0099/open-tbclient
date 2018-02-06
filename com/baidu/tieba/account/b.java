package com.baidu.tieba.account;

import com.baidu.tbadk.TiebaDatabase;
/* loaded from: classes.dex */
public class b {
    public static void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.f("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.f("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.f("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.f("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.f("delete from setting where account=?", new Object[]{str});
        }
    }
}
