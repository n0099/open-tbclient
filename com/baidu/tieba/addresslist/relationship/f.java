package com.baidu.tieba.addresslist.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private static f aKc;

    private f() {
    }

    public static f HK() {
        if (aKc == null) {
            aKc = new f();
        }
        return aKc;
    }

    private ContentValues b(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.getUserName());
        contentValues.put("id", Long.valueOf(aVar.getUserId()));
        contentValues.put(OfficalBarChatActivityConfig.USER_TYPE, Integer.valueOf(aVar.getUserType()));
        contentValues.put(IntentConfig.PORTRAIT, aVar.getUserPortrait());
        contentValues.put("quanpin", aVar.getQuanpin());
        contentValues.put("first_letter", aVar.zv());
        if (aVar.getLbsInfo() != null) {
            contentValues.put("location_hide", Integer.valueOf(aVar.getLbsInfo().zw()));
            contentValues.put("location_distance", aVar.getLbsInfo().getDistance());
            contentValues.put("location_time", Long.valueOf(aVar.getLbsInfo().getTime()));
        }
        return contentValues;
    }

    public boolean c(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        SQLiteDatabase HO = h.HO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (HO == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues b = b(aVar);
            if (HO.update("table_" + currentAccount, b, "name = ?", new String[]{aVar.getUserName()}) == 0) {
                HO.insert("table_" + currentAccount, null, b);
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
        SQLiteDatabase HO = h.HO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (HO == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            HO.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            HO.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + IntentConfig.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, " + OfficalBarChatActivityConfig.USER_TYPE + " INT);");
            HO.beginTransaction();
            try {
                for (e eVar : aVar.getAddressList()) {
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : eVar.getContacts()) {
                        HO.insert("table_" + currentAccount, null, b(aVar2));
                    }
                }
                HO.setTransactionSuccessful();
                HO.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                HO.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean al(long j) {
        SQLiteDatabase HO = h.HO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (HO == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            HO.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<com.baidu.tbadk.coreExtra.relationship.a> HL() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase HO = h.HO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (HO != null && !TextUtils.isEmpty(currentAccount)) {
            HO.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.akn) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.ew(str);
                    arrayList2.add(aVar);
                    cursor = HO.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.ew(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            aVar2.ev(cursor.getString(cursor.getColumnIndex(IntentConfig.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    o.b(cursor);
                }
                HO.setTransactionSuccessful();
                o.b(cursor);
                HO.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                o.b(cursor);
                HO.endTransaction();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<com.baidu.tbadk.coreExtra.relationship.a> HM() {
        ArrayList<com.baidu.tbadk.coreExtra.relationship.a> arrayList;
        String[] strArr;
        SQLiteDatabase HO = h.HO();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList<>();
        if (HO != null && !TextUtils.isEmpty(currentAccount)) {
            HO.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.akn) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.ew(str);
                    arrayList2.add(aVar);
                    cursor = HO.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND " + OfficalBarChatActivityConfig.USER_TYPE + " = ? ", new String[]{str, "1"});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.ew(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            aVar2.ev(cursor.getString(cursor.getColumnIndex(IntentConfig.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    o.b(cursor);
                }
                HO.setTransactionSuccessful();
                o.b(cursor);
                HO.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                o.b(cursor);
                HO.endTransaction();
            }
        }
        return arrayList;
    }
}
