package com.baidu.tieba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.codec.net.RFC1522Codec;
/* loaded from: classes5.dex */
public class b26 {
    public static /* synthetic */ Interceptable $ic;
    public static b26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public b26() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static b26 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (b26.class) {
                if (a == null) {
                    a = new b26();
                }
            }
            return a;
        }
        return (b26) invokeV.objValue;
    }

    public boolean a(y95 y95Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, y95Var)) == null) {
            SQLiteDatabase b = d26.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && y95Var != null && !TextUtils.isEmpty(currentAccount)) {
                try {
                    ContentValues c = c(y95Var);
                    if (b.update("table_" + currentAccount, c, "id = ?", new String[]{String.valueOf(y95Var.d())}) == 0) {
                        b.insert("table_" + currentAccount, null, c);
                    }
                    return true;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final ContentValues c(y95 y95Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, y95Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", y95Var.e());
            contentValues.put("id", Long.valueOf(y95Var.d()));
            contentValues.put("user_type", Integer.valueOf(y95Var.h()));
            contentValues.put("portrait", y95Var.g());
            contentValues.put("quanpin", y95Var.c());
            contentValues.put("first_letter", y95Var.a());
            contentValues.put("name_show", y95Var.f());
            if (y95Var.b() != null) {
                contentValues.put("location_hide", Integer.valueOf(y95Var.b().b()));
                contentValues.put("location_distance", y95Var.b().a());
                contentValues.put("location_time", Long.valueOf(y95Var.b().c()));
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public synchronized boolean b(w16 w16Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w16Var)) == null) {
            synchronized (this) {
                SQLiteDatabase b = d26.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (b != null && w16Var != null && !TextUtils.isEmpty(currentAccount)) {
                    b.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
                    b.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
                    b.beginTransaction();
                    try {
                        for (a26 a26Var : w16Var.a()) {
                            for (y95 y95Var : a26Var.a()) {
                                ContentValues c = c(y95Var);
                                b.insert("table_" + currentAccount, null, c);
                            }
                        }
                        b.setTransactionSuccessful();
                        b.endTransaction();
                        return true;
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.addContactItems", new Object[0]);
                        b.endTransaction();
                        return false;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j)) == null) {
            SQLiteDatabase b = d26.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && j >= 0 && !TextUtils.isEmpty(currentAccount)) {
                try {
                    b.delete("table_" + currentAccount, "id = ?", new String[]{String.valueOf(j)});
                    return true;
                } catch (Exception e) {
                    TiebaStatic.printDBExceptionLog(e, "RelationshipDao.deleteContactItem", new Object[0]);
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public synchronized List<y95> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = d26.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList arrayList = new ArrayList();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = aa5.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            y95 y95Var = new y95();
                            y95Var.j(str);
                            arrayList2.add(y95Var);
                            String[] strArr2 = new String[1];
                            strArr2[c] = str;
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter" + RFC1522Codec.PREFIX, strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    y95 y95Var2 = new y95();
                                    y95Var2.j(str);
                                    y95Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    y95Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    y95Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    y95Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    y95Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    y95Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    y95Var2.k(new z95(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(y95Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            bd.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        bd.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                        bd.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized ArrayList<y95> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = d26.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList<y95> arrayList = new ArrayList<>();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = aa5.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            y95 y95Var = new y95();
                            y95Var.j(str);
                            arrayList2.add(y95Var);
                            String[] strArr2 = new String[2];
                            strArr2[c] = str;
                            strArr2[1] = "1";
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    y95 y95Var2 = new y95();
                                    y95Var2.j(str);
                                    y95Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    y95Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    y95Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    y95Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    y95Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    y95Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    y95Var2.k(new z95(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(y95Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            bd.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        bd.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                        bd.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (ArrayList) invokeV.objValue;
    }
}
