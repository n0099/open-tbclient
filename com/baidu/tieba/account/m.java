package com.baidu.tieba.account;

import com.baidu.tbadk.TiebaDatabase;
/* loaded from: classes.dex */
public class m {
    public static void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.g("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.g("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.g("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.g("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.g("delete from setting where account=?", new Object[]{str});
        }
    }
}
