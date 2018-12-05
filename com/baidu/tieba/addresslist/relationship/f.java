package com.baidu.tieba.addresslist.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class f {
    private static f bEf;

    private f() {
    }

    public static f WM() {
        synchronized (f.class) {
            if (bEf == null) {
                bEf = new f();
            }
        }
        return bEf;
    }

    private ContentValues b(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.getUserName());
        contentValues.put("id", Long.valueOf(aVar.getUserId()));
        contentValues.put("user_type", Integer.valueOf(aVar.getUserType()));
        contentValues.put(IntentConfig.PORTRAIT, aVar.Kb());
        contentValues.put("quanpin", aVar.getQuanpin());
        contentValues.put("first_letter", aVar.Kc());
        contentValues.put("name_show", aVar.Kd());
        if (aVar.getLbsInfo() != null) {
            contentValues.put("location_hide", Integer.valueOf(aVar.getLbsInfo().Kf()));
            contentValues.put("location_distance", aVar.getLbsInfo().Ke());
            contentValues.put("location_time", Long.valueOf(aVar.getLbsInfo().getTime()));
        }
        return contentValues;
    }

    public boolean c(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        SQLiteDatabase WQ = h.WQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (WQ == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues b = b(aVar);
            if (WQ.update("table_" + currentAccount, b, "id = ?", new String[]{String.valueOf(aVar.getUserId())}) == 0) {
                WQ.insert("table_" + currentAccount, null, b);
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
        SQLiteDatabase WQ = h.WQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (WQ == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            WQ.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            WQ.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, " + IntentConfig.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
            WQ.beginTransaction();
            try {
                for (e eVar : aVar.getAddressList()) {
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : eVar.getContacts()) {
                        WQ.insert("table_" + currentAccount, null, b(aVar2));
                    }
                }
                WQ.setTransactionSuccessful();
                WQ.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                WQ.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean bb(long j) {
        SQLiteDatabase WQ = h.WQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (WQ == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            WQ.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<com.baidu.tbadk.coreExtra.relationship.a> WN() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase WQ = h.WQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (WQ != null && !TextUtils.isEmpty(currentAccount)) {
            WQ.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.aRU) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.gZ(str);
                    arrayList2.add(aVar);
                    cursor = WQ.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.gZ(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.ha(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.gY(cursor.getString(cursor.getColumnIndex(IntentConfig.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    n.e(cursor);
                }
                WQ.setTransactionSuccessful();
                n.e(cursor);
                WQ.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                n.e(cursor);
                WQ.endTransaction();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<com.baidu.tbadk.coreExtra.relationship.a> WO() {
        ArrayList<com.baidu.tbadk.coreExtra.relationship.a> arrayList;
        String[] strArr;
        SQLiteDatabase WQ = h.WQ();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList<>();
        if (WQ != null && !TextUtils.isEmpty(currentAccount)) {
            WQ.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.aRU) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.gZ(str);
                    arrayList2.add(aVar);
                    cursor = WQ.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", new String[]{str, "1"});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.gZ(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.ha(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.gY(cursor.getString(cursor.getColumnIndex(IntentConfig.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    n.e(cursor);
                }
                WQ.setTransactionSuccessful();
                n.e(cursor);
                WQ.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                n.e(cursor);
                WQ.endTransaction();
            }
        }
        return arrayList;
    }
}
