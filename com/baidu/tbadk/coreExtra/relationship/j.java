package com.baidu.tbadk.coreExtra.relationship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class j extends SQLiteOpenHelper {
    public j(Context context) {
        super(context, "relationship.db", (SQLiteDatabase.CursorFactory) null, 2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        l(sQLiteDatabase);
    }

    private void l(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + com.baidu.tbadk.core.frameworkData.a.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT, location_time LONG);");
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDbHelper.createTables", new Object[0]);
            BdLog.e("create table wrong " + e.toString());
        }
    }

    private void m(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDbHelper.dropTables", new Object[0]);
            BdLog.e("drop table wrong " + e.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m(sQLiteDatabase);
        l(sQLiteDatabase);
        try {
            MessageManager.getInstance().sendMessageFromBackground(new RequestGetAddressListMessage(304001));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
