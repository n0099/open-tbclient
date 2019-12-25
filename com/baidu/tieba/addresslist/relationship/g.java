package com.baidu.tieba.addresslist.relationship;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes5.dex */
public class g extends SQLiteOpenHelper {
    public g(Context context) {
        super(context, "relationship.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        y(sQLiteDatabase);
    }

    private void y(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!TextUtils.isEmpty(currentAccount)) {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT, location_time LONG, user_type INT);");
            }
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDbHelper.createTables", new Object[0]);
            BdLog.e("create table wrong " + e.toString());
        }
    }

    private void L(SQLiteDatabase sQLiteDatabase) {
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
        L(sQLiteDatabase);
        y(sQLiteDatabase);
        try {
            MessageManager.getInstance().sendMessageFromBackground(new RequestGetAddressListMessage(CmdConfigSocket.CMD_GET_ADDRESSLIST));
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
