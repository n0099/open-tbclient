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
/* loaded from: classes3.dex */
public class f {
    private static f dkl;

    private f() {
    }

    public static f aEv() {
        synchronized (f.class) {
            if (dkl == null) {
                dkl = new f();
            }
        }
        return dkl;
    }

    private ContentValues b(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.getUserName());
        contentValues.put("id", Long.valueOf(aVar.getUserId()));
        contentValues.put("user_type", Integer.valueOf(aVar.getUserType()));
        contentValues.put("portrait", aVar.arY());
        contentValues.put("quanpin", aVar.getQuanpin());
        contentValues.put("first_letter", aVar.arZ());
        contentValues.put("name_show", aVar.asa());
        if (aVar.getLbsInfo() != null) {
            contentValues.put("location_hide", Integer.valueOf(aVar.getLbsInfo().asb()));
            contentValues.put("location_distance", aVar.getLbsInfo().getDistance());
            contentValues.put("location_time", Long.valueOf(aVar.getLbsInfo().getTime()));
        }
        return contentValues;
    }

    public boolean c(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        SQLiteDatabase aEz = h.aEz();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (aEz == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues b = b(aVar);
            if (aEz.update("table_" + currentAccount, b, "id = ?", new String[]{String.valueOf(aVar.getUserId())}) == 0) {
                aEz.insert("table_" + currentAccount, null, b);
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
        SQLiteDatabase aEz = h.aEz();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (aEz == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            aEz.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            aEz.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
            aEz.beginTransaction();
            try {
                for (e eVar : aVar.getAddressList()) {
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : eVar.getContacts()) {
                        aEz.insert("table_" + currentAccount, null, b(aVar2));
                    }
                }
                aEz.setTransactionSuccessful();
                aEz.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                aEz.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean bL(long j) {
        SQLiteDatabase aEz = h.aEz();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (aEz == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            aEz.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<com.baidu.tbadk.coreExtra.relationship.a> aEw() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase aEz = h.aEz();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (aEz != null && !TextUtils.isEmpty(currentAccount)) {
            aEz.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.cxx) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.oV(str);
                    arrayList2.add(aVar);
                    cursor = aEz.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.oV(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.oW(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.bU(cursor.getString(cursor.getColumnIndex("portrait")));
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
                aEz.setTransactionSuccessful();
                n.close(cursor);
                aEz.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                n.close(cursor);
                aEz.endTransaction();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<com.baidu.tbadk.coreExtra.relationship.a> aEx() {
        ArrayList<com.baidu.tbadk.coreExtra.relationship.a> arrayList;
        String[] strArr;
        SQLiteDatabase aEz = h.aEz();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList<>();
        if (aEz != null && !TextUtils.isEmpty(currentAccount)) {
            aEz.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.cxx) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.oV(str);
                    arrayList2.add(aVar);
                    cursor = aEz.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", new String[]{str, "1"});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.oV(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.oW(cursor.getString(cursor.getColumnIndex("name_show")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex("user_type")));
                            aVar2.bU(cursor.getString(cursor.getColumnIndex("portrait")));
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
                aEz.setTransactionSuccessful();
                n.close(cursor);
                aEz.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                n.close(cursor);
                aEz.endTransaction();
            }
        }
        return arrayList;
    }
}
