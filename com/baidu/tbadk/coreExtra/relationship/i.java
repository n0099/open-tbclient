package com.baidu.tbadk.coreExtra.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i Ms;

    private i() {
    }

    public static i pC() {
        if (Ms == null) {
            Ms = new i();
        }
        return Ms;
    }

    private ContentValues a(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bVar.getUserName());
        contentValues.put("id", Long.valueOf(bVar.getUserId()));
        contentValues.put(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, bVar.getUserPortrait());
        contentValues.put("quanpin", bVar.getQuanpin());
        contentValues.put("first_letter", bVar.pA());
        contentValues.put("location_hide", Integer.valueOf(bVar.getLbsInfo().pB()));
        contentValues.put("location_distance", bVar.getLbsInfo().getDistance());
        contentValues.put("location_time", Long.valueOf(bVar.getLbsInfo().getTime()));
        return contentValues;
    }

    public boolean b(b bVar) {
        SQLiteDatabase pE = k.pE();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (pE == null || bVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues a = a(bVar);
            if (pE.update("table_" + currentAccount, a, "name = ?", new String[]{bVar.getUserName()}) == 0) {
                pE.insert("table_" + currentAccount, null, a);
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
        SQLiteDatabase pE = k.pE();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (pE == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            pE.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            pE.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + com.baidu.tbadk.core.frameworkData.a.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG);");
            pE.beginTransaction();
            try {
                for (h hVar : aVar.getAddressList()) {
                    for (b bVar : hVar.getContacts()) {
                        pE.insert("table_" + currentAccount, null, a(bVar));
                    }
                }
                pE.setTransactionSuccessful();
                pE.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                pE.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean m(long j) {
        SQLiteDatabase pE = k.pE();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (pE == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            pE.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<b> pD() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase pE = k.pE();
        String currentAccount = TbadkApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (pE != null && !TextUtils.isEmpty(currentAccount)) {
            pE.beginTransaction();
            try {
                for (String str : o.Mu) {
                    ArrayList arrayList2 = new ArrayList();
                    b bVar = new b();
                    bVar.cE(str);
                    arrayList2.add(bVar);
                    cursor = pE.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            b bVar2 = new b();
                            bVar2.cE(str);
                            bVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            bVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            bVar2.cD(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)));
                            bVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            bVar2.setLbsInfo(new f(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(bVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    com.baidu.adp.lib.util.p.a(cursor);
                }
                pE.setTransactionSuccessful();
                com.baidu.adp.lib.util.p.a(cursor);
                pE.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                com.baidu.adp.lib.util.p.a(cursor);
                pE.endTransaction();
            }
        }
        return arrayList;
    }
}
