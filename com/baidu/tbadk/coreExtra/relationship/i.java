package com.baidu.tbadk.coreExtra.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.t;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i Sp;

    private i() {
    }

    public static i sY() {
        if (Sp == null) {
            Sp = new i();
        }
        return Sp;
    }

    private ContentValues a(b bVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bVar.getUserName());
        contentValues.put("id", Long.valueOf(bVar.getUserId()));
        contentValues.put(OfficalBarChatActivityConfig.USER_TYPE, Integer.valueOf(bVar.getUserType()));
        contentValues.put(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, bVar.getUserPortrait());
        contentValues.put("quanpin", bVar.getQuanpin());
        contentValues.put("first_letter", bVar.sW());
        contentValues.put("location_hide", Integer.valueOf(bVar.getLbsInfo().sX()));
        contentValues.put("location_distance", bVar.getLbsInfo().getDistance());
        contentValues.put("location_time", Long.valueOf(bVar.getLbsInfo().getTime()));
        return contentValues;
    }

    public boolean b(b bVar) {
        SQLiteDatabase tb = k.tb();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (tb == null || bVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues a = a(bVar);
            if (tb.update("table_" + currentAccount, a, "name = ?", new String[]{bVar.getUserName()}) == 0) {
                tb.insert("table_" + currentAccount, null, a);
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
        SQLiteDatabase tb = k.tb();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (tb == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            tb.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            tb.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + com.baidu.tbadk.core.frameworkData.a.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, " + OfficalBarChatActivityConfig.USER_TYPE + " INT);");
            tb.beginTransaction();
            try {
                for (h hVar : aVar.getAddressList()) {
                    for (b bVar : hVar.getContacts()) {
                        tb.insert("table_" + currentAccount, null, a(bVar));
                    }
                }
                tb.setTransactionSuccessful();
                tb.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                tb.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean s(long j) {
        SQLiteDatabase tb = k.tb();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (tb == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            tb.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<b> sZ() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase tb = k.tb();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (tb != null && !TextUtils.isEmpty(currentAccount)) {
            tb.beginTransaction();
            try {
                for (String str : o.Sq) {
                    ArrayList arrayList2 = new ArrayList();
                    b bVar = new b();
                    bVar.dC(str);
                    arrayList2.add(bVar);
                    cursor = tb.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            b bVar2 = new b();
                            bVar2.dC(str);
                            bVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            bVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            bVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            bVar2.dB(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)));
                            bVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            bVar2.setLbsInfo(new f(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(bVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    t.b(cursor);
                }
                tb.setTransactionSuccessful();
                t.b(cursor);
                tb.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                t.b(cursor);
                tb.endTransaction();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<b> ta() {
        ArrayList<b> arrayList;
        String[] strArr;
        SQLiteDatabase tb = k.tb();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList<>();
        if (tb != null && !TextUtils.isEmpty(currentAccount)) {
            tb.beginTransaction();
            try {
                for (String str : o.Sq) {
                    ArrayList arrayList2 = new ArrayList();
                    b bVar = new b();
                    bVar.dC(str);
                    arrayList2.add(bVar);
                    cursor = tb.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND " + OfficalBarChatActivityConfig.USER_TYPE + " = ? ", new String[]{str, "1"});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            b bVar2 = new b();
                            bVar2.dC(str);
                            bVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            bVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            bVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            bVar2.dB(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)));
                            bVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            bVar2.setLbsInfo(new f(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(bVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    t.b(cursor);
                }
                tb.setTransactionSuccessful();
                t.b(cursor);
                tb.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                t.b(cursor);
                tb.endTransaction();
            }
        }
        return arrayList;
    }
}
