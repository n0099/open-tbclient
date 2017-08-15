package com.baidu.tieba.account;

import com.baidu.tbadk.TiebaDatabase;
/* loaded from: classes.dex */
public class b {
    public static void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.k("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.k("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.k("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.k("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.k("delete from setting where account=?", new Object[]{str});
        }
    }
}
