package com.baidu.tieba.addresslist.relationship;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g azE;

    private g() {
    }

    public static g Fo() {
        if (azE == null) {
            azE = new g();
        }
        return azE;
    }

    private ContentValues b(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", aVar.getUserName());
        contentValues.put("id", Long.valueOf(aVar.getUserId()));
        contentValues.put(OfficalBarChatActivityConfig.USER_TYPE, Integer.valueOf(aVar.getUserType()));
        contentValues.put(com.baidu.tbadk.core.frameworkData.a.PORTRAIT, aVar.getUserPortrait());
        contentValues.put("quanpin", aVar.getQuanpin());
        contentValues.put("first_letter", aVar.wD());
        contentValues.put("location_hide", Integer.valueOf(aVar.getLbsInfo().wE()));
        contentValues.put("location_distance", aVar.getLbsInfo().getDistance());
        contentValues.put("location_time", Long.valueOf(aVar.getLbsInfo().getTime()));
        return contentValues;
    }

    public boolean c(com.baidu.tbadk.coreExtra.relationship.a aVar) {
        SQLiteDatabase Fr = i.Fr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (Fr == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            ContentValues b = b(aVar);
            if (Fr.update("table_" + currentAccount, b, "name = ?", new String[]{aVar.getUserName()}) == 0) {
                Fr.insert("table_" + currentAccount, null, b);
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
        SQLiteDatabase Fr = i.Fr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (Fr == null || aVar == null || TextUtils.isEmpty(currentAccount)) {
            z = false;
        } else {
            Fr.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
            Fr.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, " + com.baidu.tbadk.core.frameworkData.a.PORTRAIT + " TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, " + OfficalBarChatActivityConfig.USER_TYPE + " INT);");
            Fr.beginTransaction();
            try {
                for (f fVar : aVar.getAddressList()) {
                    for (com.baidu.tbadk.coreExtra.relationship.a aVar2 : fVar.getContacts()) {
                        Fr.insert("table_" + currentAccount, null, b(aVar2));
                    }
                }
                Fr.setTransactionSuccessful();
                Fr.endTransaction();
                z = true;
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                Fr.endTransaction();
                z = false;
            }
        }
        return z;
    }

    public boolean L(long j) {
        SQLiteDatabase Fr = i.Fr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (Fr == null || j < 0 || TextUtils.isEmpty(currentAccount)) {
            return false;
        }
        try {
            Fr.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
            return true;
        } catch (Exception e) {
            TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
            return false;
        }
    }

    public synchronized List<com.baidu.tbadk.coreExtra.relationship.a> Fp() {
        ArrayList arrayList;
        String[] strArr;
        SQLiteDatabase Fr = i.Fr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList();
        if (Fr != null && !TextUtils.isEmpty(currentAccount)) {
            Fr.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.acR) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.dG(str);
                    arrayList2.add(aVar);
                    cursor = Fr.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter=?", new String[]{str});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.dG(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            aVar2.dF(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    v.b(cursor);
                }
                Fr.setTransactionSuccessful();
                v.b(cursor);
                Fr.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                v.b(cursor);
                Fr.endTransaction();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<com.baidu.tbadk.coreExtra.relationship.a> Fq() {
        ArrayList<com.baidu.tbadk.coreExtra.relationship.a> arrayList;
        String[] strArr;
        SQLiteDatabase Fr = i.Fr();
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        Cursor cursor = null;
        arrayList = new ArrayList<>();
        if (Fr != null && !TextUtils.isEmpty(currentAccount)) {
            Fr.beginTransaction();
            try {
                for (String str : com.baidu.tbadk.coreExtra.relationship.c.acR) {
                    ArrayList arrayList2 = new ArrayList();
                    com.baidu.tbadk.coreExtra.relationship.a aVar = new com.baidu.tbadk.coreExtra.relationship.a();
                    aVar.dG(str);
                    arrayList2.add(aVar);
                    cursor = Fr.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND " + OfficalBarChatActivityConfig.USER_TYPE + " = ? ", new String[]{str, "1"});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            com.baidu.tbadk.coreExtra.relationship.a aVar2 = new com.baidu.tbadk.coreExtra.relationship.a();
                            aVar2.dG(str);
                            aVar2.setUserName(cursor.getString(cursor.getColumnIndex("name")));
                            aVar2.setUserId(cursor.getLong(cursor.getColumnIndex("id")));
                            aVar2.setUserType(cursor.getInt(cursor.getColumnIndex(OfficalBarChatActivityConfig.USER_TYPE)));
                            aVar2.dF(cursor.getString(cursor.getColumnIndex(com.baidu.tbadk.core.frameworkData.a.PORTRAIT)));
                            aVar2.setQuanpin(cursor.getString(cursor.getColumnIndex("quanpin")));
                            aVar2.setLbsInfo(new com.baidu.tbadk.coreExtra.relationship.b(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                            arrayList2.add(aVar2);
                        }
                    }
                    if (arrayList2.size() > 1) {
                        arrayList.addAll(arrayList2);
                    }
                    v.b(cursor);
                }
                Fr.setTransactionSuccessful();
                v.b(cursor);
                Fr.endTransaction();
            } catch (Exception e) {
                BdLog.e(e.toString());
                TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                v.b(cursor);
                Fr.endTransaction();
            }
        }
        return arrayList;
    }
}
