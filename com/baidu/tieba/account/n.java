package com.baidu.tieba.account;

import com.baidu.tbadk.TiebaDatabase;
/* loaded from: classes.dex */
public class n {
    public static void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.c mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.a("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.a("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.a("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.a("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.a("delete from setting where account=?", new Object[]{str});
        }
    }
}
