package com.baidu.tbadk.coreExtra.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h a;

    private h() {
    }

    public static h a() {
        if (a == null) {
            a = new h();
        }
        return a;
    }

    private ContentValues b(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bVar.b());
        contentValues.put("id", Long.valueOf(bVar.c()));
        contentValues.put(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, bVar.d());
        contentValues.put("quanpin", bVar.e());
        contentValues.put("first_letter", bVar.f());
        return contentValues;
    }

    public boolean a(b bVar) {
        SQLiteDatabase a2 = j.a();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (a2 == null || bVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues b = b(bVar);
            if (a2.update("table_" + currentAccount, b, "name = ?", new String[]{bVar.b()}) == 0) {
                a2.insert("table_" + currentAccount, null, b);
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
        SQLiteDatabase a2 = j.a();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (a2 == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            a2.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            a2.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id long, " + com.baidu.tbadk.core.frameworkData.a.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT);");
            a2.beginTransaction();
            try {
                for (g gVar : aVar.a()) {
                    for (b bVar : gVar.b()) {
                        a2.insert("table_" + currentAccount, null, b(bVar));
                    }
                }
                a2.setTransactionSuccessful();
                a2.endTransaction();
                z = true;
            } catch (Exception e) {
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                a2.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean a(long j) {
        SQLiteDatabase a2 = j.a();
        String currentAccount = TbadkApplication.getCurrentAccount();
        if (a2 == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            a2.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<b> b() {
        ArrayList arrayList;
        String[] strArr;
        synchronized (this) {
            SQLiteDatabase a2 = j.a();
            String currentAccount = TbadkApplication.getCurrentAccount();
            Cursor cursor = null;
            arrayList = new ArrayList();
            if (a2 != null && !TextUtils.isEmpty(currentAccount)) {
                a2.beginTransaction();
                try {
                    for (String str : n.a) {
                        ArrayList arrayList2 = new ArrayList();
                        b bVar = new b();
                        bVar.d(str);
                        arrayList2.add(bVar);
                        cursor = a2.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                        if (cursor != null) {
                            while (cursor.moveToNext()) {
                                b bVar2 = new b();
                                bVar2.d(str);
                                bVar2.a(cursor.getString(cursor.getColumnIndex("name")));
                                bVar2.a(cursor.getLong(cursor.getColumnIndex("id")));
                                bVar2.b(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)));
                                bVar2.c(cursor.getString(cursor.getColumnIndex("quanpin")));
                                arrayList2.add(bVar2);
                            }
                        }
                        if (arrayList2.size() > 1) {
                            arrayList.addAll(arrayList2);
                        }
                        com.baidu.adp.lib.util.m.a(cursor);
                    }
                    a2.setTransactionSuccessful();
                    com.baidu.adp.lib.util.m.a(cursor);
                    a2.endTransaction();
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                    com.baidu.adp.lib.util.m.a(cursor);
                    a2.endTransaction();
                }
            }
        }
        return arrayList;
    }
}
