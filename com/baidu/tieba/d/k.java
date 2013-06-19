package com.baidu.tieba.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mapapi.MKEvent;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.bs;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes.dex */
public class k {
    private static Boolean a = true;
    private static Boolean b = true;
    private static volatile SQLiteDatabase c = null;
    private static volatile SQLiteDatabase d = null;
    private m e;

    public k() {
        synchronized (k.class) {
            this.e = m.INNER;
            if (c == null || !c.isOpen()) {
                try {
                    c = new h(TiebaApplication.e()).getWritableDatabase();
                } catch (Exception e) {
                    ae.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                }
            }
        }
    }

    public k(m mVar) {
        synchronized (k.class) {
            this.e = mVar;
            if (this.e != m.SDCARD || d == null || !d.isOpen()) {
                if (this.e != m.INNER || c == null || !c.isOpen()) {
                    try {
                        if (this.e == m.SDCARD) {
                            i iVar = new i();
                            iVar.a(new l(this));
                            d = iVar.a();
                        } else {
                            c = new h(TiebaApplication.e()).getWritableDatabase();
                        }
                    } catch (Exception e) {
                        ae.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                    }
                }
            }
        }
    }

    public void a(String str) {
        try {
            if (this.e == m.SDCARD && d != null) {
                d.execSQL(str);
            } else if (this.e == m.INNER && c != null) {
                c.execSQL(str);
            }
        } catch (Exception e) {
            ae.a(3, "DatabaseService", "ExecSQL", String.valueOf(str) + "   error = " + e.getMessage());
        }
    }

    public static SQLiteDatabase a() {
        new k();
        return c;
    }

    public Boolean a(String str, Object[] objArr) {
        try {
            if (this.e == m.SDCARD && d != null) {
                d.execSQL(str, objArr);
            } else if (this.e == m.INNER && c != null) {
                c.execSQL(str, objArr);
            }
            return true;
        } catch (Exception e) {
            ae.b("DatabaseService", "ExecSQL", "error = " + e.getMessage());
            ae.b("DatabaseService", "ExecSQL", str);
            return false;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0047 -> B:7:0x0010). Please submit an issue!!! */
    public Cursor a(String str, String[] strArr) {
        try {
        } catch (Exception e) {
            ae.b("DatabaseService", "rawQuery", "error = " + e.getMessage() + " sql = " + str);
        }
        if (this.e == m.SDCARD && d != null) {
            return d.rawQuery(str, strArr);
        }
        if (this.e == m.INNER && c != null) {
            return c.rawQuery(str, strArr);
        }
        return null;
    }

    public static Bitmap b(String str) {
        return c("pb_photo", str);
    }

    public static Bitmap c(String str) {
        return c("friend_photo", str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0074 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.d.m] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private static Bitmap c(String str, String str2) {
        Cursor cursor;
        Bitmap bitmap = null;
        if (str2 != null) {
            ?? r2 = m.SDCARD;
            k kVar = new k(r2);
            try {
                if (kVar != null) {
                    try {
                        cursor = kVar.a("select * from " + str + " where key = ?", new String[]{str2});
                        if (cursor != null) {
                            try {
                                if (cursor.moveToFirst()) {
                                    bitmap = d.a(cursor.getBlob(1));
                                }
                            } catch (Exception e) {
                                e = e;
                                ae.b("DatabaseService", "getPhoto", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return bitmap;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th) {
                        r2 = 0;
                        th = th;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } else {
                    cursor = null;
                }
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return bitmap;
    }

    public static void a(String str, Bitmap bitmap) {
        a("pb_photo", 5000, str, bitmap);
    }

    public static void b(String str, Bitmap bitmap) {
        a("friend_photo", (int) BdWebErrorView.ERROR_CODE_500, str, bitmap);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.d.m */
    /* JADX WARN: Multi-variable type inference failed */
    private static void a(String str, int i, String str2, Bitmap bitmap) {
        Cursor cursor;
        Cursor a2;
        Cursor cursor2 = null;
        if (str2 != null) {
            m mVar = m.SDCARD;
            k kVar = new k(mVar);
            try {
                if (kVar != null) {
                    try {
                        Cursor a3 = kVar.a("select count(*) from " + str, (String[]) null);
                        if (a3 != null) {
                            try {
                                r0 = a3.moveToFirst() ? a3.getInt(0) : 0;
                                a3.close();
                            } catch (Exception e) {
                                e = e;
                                ae.b("DatabaseService", "cashPhoto", "error = " + e.getMessage());
                                if (0 != 0) {
                                    try {
                                        cursor2.close();
                                        return;
                                    } catch (Exception e2) {
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        if (r0 >= i && (a2 = kVar.a("select * from " + str + " order by date asc limit 1", (String[]) null)) != null) {
                            a2.moveToFirst();
                            kVar.a("delete from " + str + " where key=?", (Object[]) new String[]{a2.getString(0)});
                            a2.close();
                        }
                        Cursor a4 = kVar.a("select * from " + str + " where key = ?", new String[]{str2});
                        if (a4 != null) {
                            if (a4.moveToFirst()) {
                                kVar.a("delete from " + str + " where key=?", (Object[]) new String[]{str2});
                            }
                            a4.close();
                        }
                        kVar.a("Insert into " + str + "(key,image,date) values(?,?,?)", new Object[]{str2, d.c(bitmap, 80), Long.valueOf(new Date().getTime())});
                        cursor = null;
                    } catch (Exception e3) {
                        e = e3;
                    } catch (Throwable th) {
                        th = th;
                        if (cursor2 != null) {
                            try {
                                cursor2.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } else {
                    cursor = null;
                }
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = mVar;
            }
        }
    }

    public static void d(String str) {
        a(0, str);
    }

    public static void b() {
        c(0);
    }

    public static String c() {
        return d(0);
    }

    public static void a(String str, String str2) {
        a(0, str, str2);
    }

    public static void e(String str) {
        b(0, str);
    }

    public static String f(String str) {
        return c(0, str);
    }

    public static void g(String str) {
        a(2, str);
    }

    public static void h(String str) {
        a(5, str);
    }

    public static String d() {
        return d(5);
    }

    public static String e() {
        return d(2);
    }

    public static void f() {
        c(2);
    }

    public static void i(String str) {
        a(3, str);
    }

    public static void g() {
        c(3);
    }

    public static String h() {
        return d(3);
    }

    public static void j(String str) {
        a(4, str);
    }

    public static void i() {
        c(4);
    }

    public static String j() {
        return d(4);
    }

    private static void a(int i, String str) {
        k kVar;
        if (TiebaApplication.C() != null && (kVar = new k()) != null) {
            try {
                kVar.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.C()});
                kVar.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TiebaApplication.C(), Integer.valueOf(i), str});
            } catch (Exception e) {
                ae.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static void c(int i) {
        k kVar;
        if (TiebaApplication.C() != null && (kVar = new k()) != null) {
            try {
                kVar.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.C()});
            } catch (Exception e) {
                ae.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static String d(int i) {
        Cursor cursor;
        String str;
        Exception e;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (TiebaApplication.C() == null) {
            return null;
        }
        k kVar = new k();
        try {
            if (kVar != null) {
                try {
                    cursor = kVar.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TiebaApplication.C()});
                    if (cursor != null) {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                ae.b("DatabaseService", "getCachData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                return str;
                            }
                        } catch (Exception e4) {
                            str = null;
                            e = e4;
                        }
                    } else {
                        str = null;
                    }
                    cursor2 = null;
                } catch (Exception e5) {
                    cursor = null;
                    str = null;
                    e = e5;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } else {
                cursor2 = null;
                str = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e7) {
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void a(int i, String str, String str2) {
        str2 = (str2 == null || str2.length() == 0) ? "0" : "0";
        k kVar = new k();
        if (kVar != null) {
            try {
                kVar.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), str2});
                kVar.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{str2, Integer.valueOf(i), str});
            } catch (Exception e) {
                ae.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    private static void b(int i, String str) {
        str = (str == null || str.length() == 0) ? "0" : "0";
        k kVar = new k();
        if (kVar != null) {
            try {
                kVar.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), str});
            } catch (Exception e) {
                ae.b("DatabaseService", "cachData", "error = " + e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String c(int i, String str) {
        Cursor cursor;
        String str2;
        Exception e;
        Cursor cursor2;
        str = (str == null || str.length() == 0) ? "0" : "0";
        k kVar = new k();
        if (kVar != null) {
            try {
                cursor = kVar.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), str});
                if (cursor != null) {
                    try {
                        try {
                            str2 = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                ae.b("DatabaseService", "getCachData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                return str2;
                            }
                        } catch (Exception e4) {
                            str2 = null;
                            e = e4;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw th;
                    }
                } else {
                    str2 = null;
                }
                cursor2 = null;
            } catch (Exception e6) {
                cursor = null;
                str2 = null;
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            cursor2 = null;
            str2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
            }
        }
        return str2;
    }

    public static void a(com.baidu.tieba.a.a aVar) {
        if (aVar != null && aVar.b() != null) {
            if (aVar.e() == 1) {
                k();
            }
            k kVar = new k();
            try {
                Date date = new Date();
                if (kVar != null) {
                    kVar.a("delete from account_data where id=?", (Object[]) new String[]{aVar.a()});
                    kVar.a("Insert into account_data(id,account,password,bduss,isactive,tbs,time) values(?,?,?,?,?,?,?)", new Object[]{aVar.a(), aVar.b(), aVar.c(), aVar.d(), Integer.valueOf(aVar.e()), aVar.f(), Long.valueOf(date.getTime())});
                }
            } catch (Exception e) {
                ae.b("DatabaseService", "saveAccountData", "error = " + e.getMessage());
            }
        }
    }

    public static void k() {
        k kVar = new k();
        if (kVar != null) {
            try {
                kVar.a("update account_data set isactive=0 where isactive=1");
            } catch (Exception e) {
                ae.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            }
        }
    }

    public static void b(String str, String str2) {
        k kVar;
        if (str != null && str2 != null && (kVar = new k()) != null) {
            try {
                kVar.a("update account_data set bduss=? where account=?", (Object[]) new String[]{str2, str});
            } catch (Exception e) {
                ae.b("DatabaseService", "updateAccountToken", "error = " + e.getMessage());
            }
        }
    }

    public static ArrayList l() {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        k kVar = new k();
        ArrayList arrayList = new ArrayList();
        try {
            if (kVar != null) {
                try {
                    cursor = kVar.a("select * from account_data order by time desc", (String[]) null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
                                aVar.a(cursor.getString(0));
                                aVar.b(cursor.getString(1));
                                aVar.c(cursor.getString(2));
                                aVar.d(cursor.getString(3));
                                aVar.a(cursor.getInt(4));
                                aVar.e(cursor.getString(5));
                                aVar.a(cursor.getLong(6));
                                arrayList.add(aVar);
                            } catch (Exception e) {
                                e = e;
                                ae.b("DatabaseService", "getAllAccountData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return arrayList;
                            }
                        }
                        cursor.close();
                    }
                    cursor2 = null;
                } catch (Exception e3) {
                    e = e3;
                    cursor = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            } else {
                cursor2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e5) {
                }
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static int m() {
        Cursor cursor = null;
        int i = 0;
        k kVar = new k();
        try {
            if (kVar != null) {
                try {
                    cursor = kVar.a("select count(*) from account_data", (String[]) null);
                    if (cursor != null && cursor.moveToFirst()) {
                        i = cursor.getInt(0);
                    }
                } catch (Exception e) {
                    ae.b("DatabaseService", "getAccountNum", e.getMessage());
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                        }
                    }
                }
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
            return i;
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.a.a n() {
        Cursor cursor;
        com.baidu.tieba.a.a aVar;
        Exception e;
        Cursor cursor2;
        k kVar = new k();
        if (kVar != null) {
            try {
                cursor = kVar.a("select * from account_data where isactive=?", new String[]{String.valueOf(1)});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tieba.a.a aVar2 = new com.baidu.tieba.a.a();
                                try {
                                    aVar2.a(cursor.getString(0));
                                    aVar2.b(cursor.getString(1));
                                    aVar2.c(cursor.getString(2));
                                    aVar2.d(cursor.getString(3));
                                    aVar2.a(cursor.getInt(4));
                                    aVar2.e(cursor.getString(5));
                                    aVar2.a(cursor.getLong(6));
                                    aVar = aVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    aVar = aVar2;
                                    ae.b("DatabaseService", "getActiveAccountData", "error = " + e.getMessage());
                                    if (cursor != null) {
                                    }
                                    return aVar;
                                }
                            } else {
                                aVar = null;
                            }
                        } catch (Exception e3) {
                            aVar = null;
                            e = e3;
                        }
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                            e = e4;
                            ae.b("DatabaseService", "getActiveAccountData", "error = " + e.getMessage());
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e5) {
                                }
                            }
                            return aVar;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw th;
                    }
                } else {
                    aVar = null;
                }
                cursor2 = null;
            } catch (Exception e7) {
                cursor = null;
                aVar = null;
                e = e7;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            cursor2 = null;
            aVar = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e8) {
            }
        }
        return aVar;
    }

    public static ArrayList o() {
        return e(0);
    }

    public static ArrayList p() {
        return e(1);
    }

    private static ArrayList e(int i) {
        Cursor a2;
        Cursor cursor;
        Cursor cursor2 = null;
        k kVar = new k();
        ArrayList arrayList = new ArrayList();
        if (kVar != null) {
            try {
                try {
                    switch (i) {
                        case 0:
                            a2 = kVar.a("select * from search_data order by time desc limit 10", (String[]) null);
                            break;
                        case 1:
                            a2 = kVar.a("select * from search_post_data order by time desc limit 10", (String[]) null);
                            break;
                        default:
                            a2 = null;
                            break;
                    }
                    if (a2 != null) {
                        while (a2.moveToNext()) {
                            try {
                                String string = a2.getString(0);
                                if (string != null && string.length() > 0) {
                                    arrayList.add(string);
                                }
                            } catch (Exception e) {
                                e = e;
                                cursor2 = a2;
                                ae.b("DatabaseService", "getAllSearchData", "error = " + e.getMessage());
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = a2;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                throw th;
                            }
                        }
                        a2.close();
                    }
                    cursor = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } else {
            cursor = null;
        }
        if (0 != 0) {
            try {
                cursor.close();
            } catch (Exception e5) {
            }
        }
        return arrayList;
    }

    public static void k(String str) {
        d(0, str);
    }

    public static void l(String str) {
        d(1, str);
    }

    private static void d(int i, String str) {
        k kVar = new k();
        if (kVar != null && str != null) {
            try {
                Date date = new Date();
                switch (i) {
                    case 0:
                        kVar.a("delete from search_data where key=?", (Object[]) new String[]{str});
                        kVar.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.C(), Long.valueOf(date.getTime())});
                        break;
                    case 1:
                        kVar.a("delete from search_post_data where key=?", (Object[]) new String[]{str});
                        kVar.a("Insert into search_post_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.C(), Long.valueOf(date.getTime())});
                        break;
                }
            } catch (Exception e) {
                ae.b("DatabaseService", "saveSearchData", "error = " + e.getMessage());
            }
        }
    }

    public static void q() {
        a(0);
    }

    public static void r() {
        a(1);
    }

    public static void a(int i) {
        k kVar = new k();
        if (kVar != null) {
            try {
                switch (i) {
                    case 0:
                        kVar.a("delete from search_data");
                        break;
                    case 1:
                        kVar.a("delete from search_post_data");
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                ae.b("DatabaseService", "delAllSearchData", "error = " + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0122 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.d.k] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static ArrayList s() {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        if (TiebaApplication.C() == null) {
            return null;
        }
        ?? kVar = new k();
        ArrayList arrayList = new ArrayList();
        try {
            if (kVar != 0) {
                try {
                    cursor = kVar.a("select * from mark_data where account=? order by time desc", new String[]{TiebaApplication.C()});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.tieba.a.af afVar = new com.baidu.tieba.a.af();
                                afVar.b(cursor.getString(0));
                                afVar.c(cursor.getInt(1));
                                afVar.a(cursor.getInt(2));
                                afVar.c(cursor.getString(3));
                                afVar.a(Boolean.valueOf(cursor.getInt(4) == 1));
                                afVar.a(cursor.getInt(5) == 1);
                                afVar.d(cursor.getString(6));
                                afVar.e(cursor.getString(7));
                                afVar.a(cursor.getString(8));
                                afVar.a(cursor.getInt(9));
                                afVar.b(cursor.getInt(10));
                                afVar.g(cursor.getString(11));
                                afVar.f(cursor.getString(12));
                                afVar.h(cursor.getString(13));
                                arrayList.add(afVar);
                            } catch (Exception e2) {
                                e = e2;
                                ae.b("DatabaseService", "getAllMarkData", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                ae.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
                                return arrayList;
                            }
                        }
                        cursor.close();
                    }
                    a((Boolean) false);
                    cursor2 = null;
                } catch (Exception e4) {
                    cursor = null;
                    e = e4;
                } catch (Throwable th) {
                    kVar = 0;
                    th = th;
                    if (kVar != 0) {
                        try {
                            kVar.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } else {
                cursor2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e6) {
                }
            }
            ae.a("DatabaseService", "getAllMarkData", "success = " + String.valueOf(arrayList.size()));
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void a(Boolean bool) {
        a = bool;
    }

    public static void b(Boolean bool) {
        b = bool;
    }

    public static void a(bs bsVar) {
        if (TiebaApplication.C() != null) {
            k kVar = new k();
            try {
                if (bsVar.b() == 0) {
                    kVar.a("delete from draft_box where account=? and type=? and forum_id=?", new Object[]{TiebaApplication.C(), 0, bsVar.g()});
                } else if (bsVar.b() == 1) {
                    kVar.a("delete from draft_box where account=? and type=? and thread_id=?", new Object[]{TiebaApplication.C(), 1, bsVar.e()});
                } else {
                    kVar.a("delete from draft_box where account=? and type=? and thread_id=? and floor_id=?", new Object[]{TiebaApplication.C(), 2, bsVar.e(), bsVar.f()});
                }
            } catch (Exception e) {
                ae.b("DatabaseService", "deleteDraftBox", "error = " + e.getMessage());
            }
        }
    }

    public static void t() {
        long time = new Date().getTime() - 604800000;
        try {
            new k().a("delete from draft_box where time<?", new Object[]{Long.valueOf(time)});
        } catch (Exception e) {
            ae.b("DatabaseService", "delMouthAgoDraft", "error = " + e.getMessage());
        }
    }

    public static void b(bs bsVar) {
        if (TiebaApplication.C() != null) {
            a(bsVar);
            try {
                new k().a("Insert into draft_box(account,type,forum_id,forum_name,thread_id,floor_id,title,content,time) values(?,?,?,?,?,?,?,?,?)", new Object[]{TiebaApplication.C(), Integer.valueOf(bsVar.b()), bsVar.g(), bsVar.h(), bsVar.e(), bsVar.f(), bsVar.c(), bsVar.d(), Long.valueOf(new Date().getTime())});
            } catch (Exception e) {
                ae.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:38:0x00d0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static bs a(int i, String str, String str2, String str3) {
        Throwable th;
        Cursor cursor;
        bs bsVar = null;
        ?? r2 = 1;
        if (TiebaApplication.C() != null) {
            k kVar = new k();
            try {
                try {
                    if (i == 0) {
                        cursor = kVar.a("select * from draft_box where account=? and type=? and forum_id=?", new String[]{TiebaApplication.C(), String.valueOf(i), str});
                    } else if (i == 1) {
                        cursor = kVar.a("select * from draft_box where account=? and type=? and thread_id=?", new String[]{TiebaApplication.C(), String.valueOf(i), str2});
                    } else {
                        cursor = kVar.a("select * from draft_box where account=? and type=? and thread_id=? and floor_id=?", new String[]{TiebaApplication.C(), String.valueOf(i), str2, str3});
                    }
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                bs bsVar2 = new bs();
                                try {
                                    bsVar2.a(i);
                                    bsVar2.e(str);
                                    bsVar2.f(cursor.getString(3));
                                    bsVar2.c(str2);
                                    bsVar2.d(str3);
                                    bsVar2.a(cursor.getString(6));
                                    bsVar2.b(cursor.getString(7));
                                    bsVar = bsVar2;
                                } catch (Exception e) {
                                    bsVar = bsVar2;
                                    e = e;
                                    ae.b("DatabaseService", "getDraftBox", "error = " + e.getMessage());
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                    return bsVar;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (r2 != 0) {
                        try {
                            r2.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                cursor = null;
            } catch (Throwable th3) {
                r2 = 0;
                th = th3;
                if (r2 != 0) {
                }
                throw th;
            }
        }
        return bsVar;
    }

    public static void u() {
        if (TiebaApplication.C() != null) {
            k kVar = new k();
            try {
                kVar.a("delete from setting where account=?", new Object[]{TiebaApplication.C()});
                Object[] objArr = new Object[6];
                objArr[0] = TiebaApplication.C();
                objArr[1] = Integer.valueOf(TiebaApplication.e().Q());
                objArr[2] = Integer.valueOf(TiebaApplication.e().W() ? 1 : 0);
                objArr[3] = Integer.valueOf(TiebaApplication.e().Y() ? 1 : 0);
                objArr[4] = Integer.valueOf(TiebaApplication.e().X() ? 1 : 0);
                objArr[5] = Integer.valueOf(TiebaApplication.e().V());
                kVar.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone) values(?,?,?,?,?,?)", objArr);
            } catch (Exception e) {
                ae.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
            }
        }
    }

    public static void v() {
        ae.a("databaseService", "getSetting", TiebaApplication.G());
        if (TiebaApplication.C() == null || TiebaApplication.C().length() <= 0 || TiebaApplication.G() == null) {
            TiebaApplication.e().f(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new k().a("select * from setting where account=?", new String[]{TiebaApplication.C()});
                if (a2 != null && a2.moveToFirst()) {
                    TiebaApplication.e().f(a2.getInt(1));
                    if (a2.getInt(2) == 0) {
                        TiebaApplication.e().m(false);
                    } else {
                        TiebaApplication.e().m(true);
                    }
                    if (a2.getInt(3) == 0) {
                        TiebaApplication.e().o(false);
                    } else {
                        TiebaApplication.e().o(true);
                    }
                    if (a2.getInt(4) == 0) {
                        TiebaApplication.e().n(false);
                    } else {
                        TiebaApplication.e().n(true);
                    }
                    TiebaApplication.e().e(a2.getInt(5));
                } else {
                    TiebaApplication.e().f(MKEvent.ERROR_PERMISSION_DENIED);
                    TiebaApplication.e().m(true);
                    TiebaApplication.e().o(true);
                    TiebaApplication.e().n(true);
                    TiebaApplication.e().k(true);
                    TiebaApplication.e().l(false);
                }
                if (a2 != null) {
                    try {
                        a2.close();
                    } catch (Exception e) {
                    }
                }
            } catch (Exception e2) {
                ae.b("DatabaseService", "getDraftBox", "error = " + e2.getMessage());
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e3) {
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                }
            }
            throw th;
        }
    }

    public static void w() {
        k kVar;
        if (TiebaApplication.C() != null && (kVar = new k()) != null) {
            try {
                kVar.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TiebaApplication.C()});
            } catch (Exception e) {
                ae.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
            }
        }
    }

    public static void m(String str) {
        if (TiebaApplication.C() != null) {
            k kVar = new k();
            if (str != null && kVar != null) {
                try {
                    kVar.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TiebaApplication.C()});
                } catch (Exception e) {
                    ae.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
                }
            }
        }
    }

    public static boolean a(com.baidu.tieba.a.f fVar) {
        if (TiebaApplication.C() == null) {
            return false;
        }
        k kVar = new k();
        Date date = new Date();
        if (fVar == null || kVar == null) {
            return false;
        }
        try {
            kVar.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{fVar.a(), TiebaApplication.C()});
            return kVar.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{fVar.a(), Long.valueOf(fVar.b()), Integer.valueOf(fVar.c()), TiebaApplication.C(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
        } catch (Exception e) {
            ae.b("DatabaseService", "saveChunkUploadData", "error = " + e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.a.f n(String str) {
        Cursor cursor;
        Cursor cursor2;
        Exception e;
        com.baidu.tieba.a.f fVar;
        Cursor cursor3;
        if (TiebaApplication.C() == null) {
            return null;
        }
        k kVar = new k();
        if (kVar != null) {
            try {
                cursor = kVar.a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TiebaApplication.C()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tieba.a.f fVar2 = new com.baidu.tieba.a.f();
                                try {
                                    fVar2.a(str);
                                    fVar2.a(cursor.getInt(3));
                                    fVar2.a(cursor.getLong(2));
                                    fVar = fVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    fVar = fVar2;
                                    cursor2 = cursor;
                                    try {
                                        ae.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception e3) {
                                            }
                                        }
                                        return fVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                fVar = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e4) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        cursor2 = cursor;
                        e = e5;
                        fVar = null;
                    }
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        e = e6;
                        cursor2 = cursor;
                        ae.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                        if (cursor2 != null) {
                        }
                        return fVar;
                    }
                } else {
                    fVar = null;
                }
                cursor3 = null;
            } catch (Exception e7) {
                cursor2 = null;
                e = e7;
                fVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            fVar = null;
            cursor3 = null;
        }
        if (0 != 0) {
            try {
                cursor3.close();
            } catch (Exception e8) {
            }
        }
        return fVar;
    }

    public static void x() {
        synchronized (k.class) {
            try {
                d.close();
            } catch (Exception e) {
            }
            try {
                o.h("tieba_database.db");
            } catch (Exception e2) {
            }
            d = null;
        }
    }

    public static void o(String str) {
        k kVar;
        if (str != null && (kVar = new k()) != null) {
            try {
                kVar.a("delete from cash_data where account=?", (Object[]) new String[]{str});
                kVar.a("delete from mark_data where account=?", (Object[]) new String[]{str});
                kVar.a("delete from draft_box where account=?", new Object[]{str});
                kVar.a("delete from account_data where id=?", new Object[]{str});
                kVar.a("delete from setting where account=?", new Object[]{str});
            } catch (Exception e) {
                ae.b("DatabaseService", "deleteAccountAllInfo", e.getMessage());
            }
        }
    }

    public static boolean a(String str, int i) {
        k kVar = new k();
        if (kVar != null) {
            try {
                kVar.a("delete from cash_data where type=?", (Object[]) new String[]{String.valueOf(i)});
                return kVar.a("Insert into cash_data(type ,account ,data ) values(?,?,?)", (Object[]) new String[]{String.valueOf(i), "", str}).booleanValue();
            } catch (Exception e) {
                ae.b("DatabaseService", "cashHostspot", "error = " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    public static String b(int i) {
        Cursor cursor;
        Exception e;
        String str;
        Cursor cursor2;
        Cursor cursor3 = null;
        k kVar = new k();
        try {
            if (kVar != null) {
                try {
                    cursor = kVar.a("select * from cash_data where type=? ", new String[]{String.valueOf(i)});
                    if (cursor != null) {
                        try {
                            str = cursor.moveToFirst() ? cursor.getString(2) : null;
                            try {
                                cursor.close();
                            } catch (Exception e2) {
                                e = e2;
                                ae.b("DatabaseService", "getHotspot", "error = " + e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                return str;
                            }
                        } catch (Exception e4) {
                            str = null;
                            e = e4;
                        }
                    } else {
                        str = null;
                    }
                    cursor2 = null;
                } catch (Exception e5) {
                    cursor = null;
                    e = e5;
                    str = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            cursor3.close();
                        } catch (Exception e6) {
                        }
                    }
                    throw th;
                }
            } else {
                str = null;
                cursor2 = null;
            }
            if (0 != 0) {
                try {
                    cursor2.close();
                } catch (Exception e7) {
                }
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void p(String str) {
        k kVar = new k();
        if (kVar != null && str != null) {
            try {
                kVar.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
                kVar.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
            } catch (Exception e) {
                ae.b("DatabaseService", "insertFrsImageForum", e.getMessage());
            }
        }
    }

    public static void q(String str) {
        k kVar = new k();
        if (kVar != null && str != null) {
            try {
                kVar.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
            } catch (Exception e) {
                ae.b("DatabaseService", "delFrsImageForum", e.getMessage());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList y() {
        Cursor cursor;
        Exception e;
        ArrayList arrayList;
        Cursor cursor2;
        k kVar = new k();
        if (kVar != null) {
            try {
                cursor = kVar.a("select * from frs_image_forums", (String[]) null);
                if (cursor != null) {
                    try {
                        try {
                            arrayList = new ArrayList();
                            while (cursor.moveToNext()) {
                                try {
                                    arrayList.add(cursor.getString(0));
                                } catch (Exception e2) {
                                    e = e2;
                                    ae.b("DatabaseService", "getAllFrsImageForums", e.getMessage());
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    return arrayList;
                                }
                            }
                            cursor.close();
                        } catch (Exception e4) {
                            arrayList = null;
                            e = e4;
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } else {
                    arrayList = null;
                }
                cursor2 = null;
            } catch (Exception e6) {
                cursor = null;
                e = e6;
                arrayList = null;
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                if (cursor != null) {
                }
                throw th;
            }
        } else {
            arrayList = null;
            cursor2 = null;
        }
        if (0 != 0) {
            try {
                cursor2.close();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        return arrayList;
    }
}
