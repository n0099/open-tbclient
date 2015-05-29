package com.baidu.tieba.addresslist.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.w;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g aBx;

    private g() {
    }

    public static g Gn() {
        if (aBx == null) {
            aBx = new g();
        }
        return aBx;
    }

    private ContentValues b(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.getUserName());
        contentValues.put("id", Long.valueOf(aVar.getUserId()));
        contentValues.put(OfficalBarChatActivityConfig.USER_TYPE, Integer.valueOf(aVar.getUserType()));
        contentValues.put(com.baidu.tbadk.core.frameworkData.c.PORTRAIT, aVar.getUserPortrait());
        contentValues.put("quanpin", aVar.getQuanpin());
        contentValues.put("first_letter", aVar.xw());
        contentValues.put("location_hide", Integer.valueOf(aVar.getLbsInfo().xx()));
        contentValues.put("location_distance", aVar.getLbsInfo().getDistance());
        contentValues.put("location_time", Long.valueOf(aVar.getLbsInfo().getTime()));
        return contentValues;
    }

    public boolean c(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        SQLiteDatabase Gr = i.Gr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (Gr == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues b = b(aVar);
            if (Gr.update("table_" + currentAccount, b, "name = ?", new String[]{aVar.getUserName()}) == 0) {
                Gr.insert("table_" + currentAccount, null, b);
                return true;
            }
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized boolean a(a aVar) {
        boolean z;
        SQLiteDatabase Gr = i.Gr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (Gr == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            Gr.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            Gr.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + com.baidu.tbadk.core.frameworkData.c.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, " + OfficalBarChatActivityConfig.USER_TYPE + " INT);");
            Gr.beginTransaction();
            try {
                for (f fVar : aVar.getAddressList()) {
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : fVar.getContacts()) {
                        Gr.insert("table_" + currentAccount, null, b(aVar2));
                    }
                }
                Gr.setTransactionSuccessful();
                Gr.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                Gr.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean K(long j) {
        SQLiteDatabase Gr = i.Gr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (Gr == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            Gr.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<com.baidu.tbadk.coreExtra.relationship.a> Go() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase Gr = i.Gr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (Gr != null && !TextUtils.isEmpty(currentAccount)) {
            Gr.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.aeh) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.ea(str);
                    arrayList2.add(aVar);
                    cursor = Gr.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.ea(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            aVar2.dZ(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.c.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    w.b(cursor);
                }
                Gr.setTransactionSuccessful();
                w.b(cursor);
                Gr.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                w.b(cursor);
                Gr.endTransaction();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<com.baidu.tbadk.coreExtra.relationship.a> Gp() {
        ArrayList<com.baidu.tbadk.coreExtra.relationship.a> arrayList;
        String[] strArr;
        SQLiteDatabase Gr = i.Gr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList<>();
        if (Gr != null && !TextUtils.isEmpty(currentAccount)) {
            Gr.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.aeh) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.ea(str);
                    arrayList2.add(aVar);
                    cursor = Gr.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND " + OfficalBarChatActivityConfig.USER_TYPE + " = ? ", new String[]{str, "1"});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.ea(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            aVar2.dZ(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.c.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    w.b(cursor);
                }
                Gr.setTransactionSuccessful();
                w.b(cursor);
                Gr.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                w.b(cursor);
                Gr.endTransaction();
            }
        }
        return arrayList;
    }
}
