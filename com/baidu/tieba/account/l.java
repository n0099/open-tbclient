package com.baidu.tieba.account;

import com.baidu.tbadk.TiebaDatabase;
/* loaded from: classes.dex */
public class l {
    public static void deleteAccountAllInfo(String str) {
        if (str != null) {
            com.baidu.adp.base.a.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
            mainDBDatabaseManager.b("delete from cash_data where account=?", new String[]{str});
            mainDBDatabaseManager.b("delete from mark_data where account=?", new String[]{str});
            mainDBDatabaseManager.b("delete from draft_box where account=?", new Object[]{str});
            mainDBDatabaseManager.b("delete from account_data where id=?", new Object[]{str});
            mainDBDatabaseManager.b("delete from setting where account=?", new Object[]{str});
        }
    }
}
