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
public class d66 {
    public static /* synthetic */ Interceptable $ic;
    public static d66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public d66() {
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

    public static d66 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (d66.class) {
                if (a == null) {
                    a = new d66();
                }
            }
            return a;
        }
        return (d66) invokeV.objValue;
    }

    public boolean a(we5 we5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, we5Var)) == null) {
            SQLiteDatabase b = f66.b();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (b != null && we5Var != null && !TextUtils.isEmpty(currentAccount)) {
                try {
                    ContentValues c = c(we5Var);
                    if (b.update("table_" + currentAccount, c, "id = ?", new String[]{String.valueOf(we5Var.d())}) == 0) {
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

    public final ContentValues c(we5 we5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, we5Var)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", we5Var.e());
            contentValues.put("id", Long.valueOf(we5Var.d()));
            contentValues.put("user_type", Integer.valueOf(we5Var.h()));
            contentValues.put("portrait", we5Var.g());
            contentValues.put("quanpin", we5Var.c());
            contentValues.put("first_letter", we5Var.a());
            contentValues.put("name_show", we5Var.f());
            if (we5Var.b() != null) {
                contentValues.put("location_hide", Integer.valueOf(we5Var.b().b()));
                contentValues.put("location_distance", we5Var.b().a());
                contentValues.put("location_time", Long.valueOf(we5Var.b().c()));
            }
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public synchronized boolean b(y56 y56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, y56Var)) == null) {
            synchronized (this) {
                SQLiteDatabase b = f66.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                if (b != null && y56Var != null && !TextUtils.isEmpty(currentAccount)) {
                    b.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
                    b.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT ,location_time LONG, user_type INT);");
                    b.beginTransaction();
                    try {
                        for (c66 c66Var : y56Var.a()) {
                            for (we5 we5Var : c66Var.a()) {
                                ContentValues c = c(we5Var);
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
            SQLiteDatabase b = f66.b();
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

    public synchronized List<we5> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = f66.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList arrayList = new ArrayList();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = ye5.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            we5 we5Var = new we5();
                            we5Var.j(str);
                            arrayList2.add(we5Var);
                            String[] strArr2 = new String[1];
                            strArr2[c] = str;
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter" + RFC1522Codec.PREFIX, strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    we5 we5Var2 = new we5();
                                    we5Var2.j(str);
                                    we5Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    we5Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    we5Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    we5Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    we5Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    we5Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    we5Var2.k(new xe5(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(we5Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            ci.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        ci.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getContactList", new Object[0]);
                        ci.a(cursor);
                    }
                    b.endTransaction();
                    return arrayList;
                }
                return arrayList;
            }
        }
        return (List) invokeV.objValue;
    }

    public synchronized ArrayList<we5> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            synchronized (this) {
                SQLiteDatabase b = f66.b();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                Cursor cursor = null;
                ArrayList<we5> arrayList = new ArrayList<>();
                if (b != null && !TextUtils.isEmpty(currentAccount)) {
                    b.beginTransaction();
                    char c = 0;
                    try {
                        String[] strArr = ye5.a;
                        int length = strArr.length;
                        int i = 0;
                        while (i < length) {
                            String str = strArr[i];
                            ArrayList arrayList2 = new ArrayList();
                            we5 we5Var = new we5();
                            we5Var.j(str);
                            arrayList2.add(we5Var);
                            String[] strArr2 = new String[2];
                            strArr2[c] = str;
                            strArr2[1] = "1";
                            cursor = b.rawQuery("SELECT * FROM table_" + currentAccount + " WHERE first_letter = ? AND user_type = ? ", strArr2);
                            if (cursor != null) {
                                while (cursor.moveToNext()) {
                                    we5 we5Var2 = new we5();
                                    we5Var2.j(str);
                                    we5Var2.n(cursor.getString(cursor.getColumnIndex("name")));
                                    we5Var2.o(cursor.getString(cursor.getColumnIndex("name_show")));
                                    we5Var2.m(cursor.getLong(cursor.getColumnIndex("id")));
                                    we5Var2.q(cursor.getInt(cursor.getColumnIndex("user_type")));
                                    we5Var2.p(cursor.getString(cursor.getColumnIndex("portrait")));
                                    we5Var2.l(cursor.getString(cursor.getColumnIndex("quanpin")));
                                    we5Var2.k(new xe5(cursor.getString(cursor.getColumnIndex("location_distance")), cursor.getLong(cursor.getColumnIndex("location_time")), cursor.getInt(cursor.getColumnIndex("location_hide"))));
                                    arrayList2.add(we5Var2);
                                }
                            }
                            if (arrayList2.size() > 1) {
                                arrayList.addAll(arrayList2);
                            }
                            ci.a(cursor);
                            i++;
                            c = 0;
                        }
                        b.setTransactionSuccessful();
                        ci.a(cursor);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                        TiebaStatic.printDBExceptionLog(e, "RelationshipDao.getOfficialAccountList", new Object[0]);
                        ci.a(cursor);
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
