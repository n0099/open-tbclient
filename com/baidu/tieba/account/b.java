package com.baidu.tieba.account;

import com.baidu.tbadk.TiebaDatabase;
/* loaded from: classes9.dex */
public class b {
    public static void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.execSQLNoException("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.execSQLNoException("delete from setting where account=?", new Object[]{str});
        }
    }
}
