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
    private static i Mv;

    private i() {
    }

    public static i pE() {
        if (Mv == null) {
            Mv = new i();
        }
        return Mv;
    }

    private ContentValues a(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bVar.getUserName());
        contentValues.put("id", Long.valueOf(bVar.getUserId()));
        contentValues.put(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, bVar.getUserPortrait());
        contentValues.put("quanpin", bVar.getQuanpin());
        contentValues.put("first_letter", bVar.pC());
        contentValues.put("location_hide", Integer.valueOf(bVar.getLbsInfo().pD()));
        contentValues.put("location_distance", bVar.getLbsInfo().getDistance());
        contentValues.put("location_time", Long.valueOf(bVar.getLbsInfo().getTime()));
        return contentValues;
    }

    public boolean b(b bVar) {
        SQLiteDatabase pG = k.pG();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (pG == null || bVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues a = a(bVar);
            if (pG.update("table_" + currentAccount, a, "name = ?", new String[]{bVar.getUserName()}) == 0) {
                pG.insert("table_" + currentAccount, null, a);
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
        SQLiteDatabase pG = k.pG();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (pG == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            pG.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            pG.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + com.baidu.tbadk.core.frameworkData.a.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG);");
            pG.beginTransaction();
            try {
                for (h hVar : aVar.getAddressList()) {
                    for (b bVar : hVar.getContacts()) {
                        pG.insert("table_" + currentAccount, null, a(bVar));
                    }
                }
                pG.setTransactionSuccessful();
                pG.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                pG.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean m(long j) {
        SQLiteDatabase pG = k.pG();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (pG == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            pG.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<b> pF() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase pG = k.pG();
        String currentAccount = TbadkApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (pG != null && !TextUtils.isEmpty(currentAccount)) {
            pG.beginTransaction();
            try {
                for (String str : o.Mx) {
                    ArrayList arrayList2 = new ArrayList();
                    b bVar = new b();
                    bVar.cF(str);
                    arrayList2.add(bVar);
                    cursor = pG.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            b bVar2 = new b();
                            bVar2.cF(str);
                            bVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            bVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            bVar2.cE(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)));
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
                pG.setTransactionSuccessful();
                com.baidu.adp.lib.util.p.a(cursor);
                pG.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                com.baidu.adp.lib.util.p.a(cursor);
                pG.endTransaction();
            }
        }
        return arrayList;
    }
}
