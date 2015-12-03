package com.baidu.tieba.addresslist.relationship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class g extends SQLiteOpenHelper {
    public g(Context context) {
        super(context, "relationship.db", (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        n(sQLiteDatabase);
    }

    private void n(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + IntentConfig.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT, location_time LONG, " + OfficalBarChatActivityConfig.USER_TYPE + " INT);");
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDbHelper.createTables", new Object[0]);
            BdLog.e("create table wrong " + e.toString());
        }
    }

    private void q(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
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
        q(sQLiteDatabase);
        n(sQLiteDatabase);
        try {
            MessageManager.getInstance().sendMessageFromBackground(new RequestGetAddressListMessage(304001));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
