package com.baidu.tieba.addresslist.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class f {
    private static f gmp;

    private f() {
    }

    public static f bPD() {
        synchronized (f.class) {
            if (gmp == null) {
                gmp = new f();
            }
        }
        return gmp;
    }

    private ContentValues b(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.getUserName());
        contentValues.put("id", Long.valueOf(aVar.getUserId()));
        contentValues.put("user_type", Integer.valueOf(aVar.getUserType()));
        contentValues.put("portrait", aVar.getUserPortrait());
        contentValues.put("quanpin", aVar.getQuanpin());
        contentValues.put("first_letter", aVar.bCA());
        contentValues.put("name_show", aVar.bCB());
        if (aVar.getLbsInfo() != null) {
            contentValues.put("location_hide", Integer.valueOf(aVar.getLbsInfo().bCC()));
            contentValues.put("location_distance", aVar.getLbsInfo().getDistance());
            contentValues.put("location_time", Long.valueOf(aVar.getLbsInfo().getTime()));
        }
        return contentValues;
    }

    public boolean c(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        SQLiteDatabase bPH = h.bPH();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (bPH == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues b2 = b(aVar);
            if (bPH.update("table_" + currentAccount, b2, "id = ?", new String[]{String.valueOf(aVar.getUserId())}) == 0) {
                bPH.insert("table_" + currentAccount, null, b2);
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
        SQLiteDatabase bPH = h.bPH();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (bPH == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            bPH.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            bPH.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
            bPH.beginTransaction();
            try {
                for (e eVar : aVar.getAddressList()) {
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : eVar.getContacts()) {
                        bPH.insert("table_" + currentAccount, null, b(aVar2));
                    }
                }
                bPH.setTransactionSuccessful();
                bPH.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                bPH.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean eR(long j) {
        SQLiteDatabase bPH = h.bPH();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (bPH == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            bPH.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<com.baidu.tbadk.coreExtra.relationship.a> bPE() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase bPH = h.bPH();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (bPH != null && !TextUtils.isEmpty(currentAccount)) {
            bPH.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.fwQ) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.Dd(str);
                    arrayList2.add(aVar);
                    cursor = bPH.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.Dd(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.De(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.setUserPortrait(cursor.getString(cursor.getColumnIndex("portrait")));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    n.close(cursor);
                }
                bPH.setTransactionSuccessful();
                n.close(cursor);
                bPH.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                n.close(cursor);
                bPH.endTransaction();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<com.baidu.tbadk.coreExtra.relationship.a> bPF() {
        ArrayList<com.baidu.tbadk.coreExtra.relationship.a> arrayList;
        String[] strArr;
        SQLiteDatabase bPH = h.bPH();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList<>();
        if (bPH != null && !TextUtils.isEmpty(currentAccount)) {
            bPH.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.fwQ) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.Dd(str);
                    arrayList2.add(aVar);
                    cursor = bPH.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", new String[]{str, "1"});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.Dd(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.De(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.setUserPortrait(cursor.getString(cursor.getColumnIndex("portrait")));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    n.close(cursor);
                }
                bPH.setTransactionSuccessful();
                n.close(cursor);
                bPH.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                n.close(cursor);
                bPH.endTransaction();
            }
        }
        return arrayList;
    }
}
