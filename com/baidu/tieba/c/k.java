package com.baidu.tieba.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import com.baidu.tieba.TiebaApplication;
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
                    c = new h(TiebaApplication.a()).getWritableDatabase();
                } catch (Exception e) {
                    ae.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
                }
            }
        }
    }

    public k(m mVar) {
        synchronized (k.class) {
            this.e = mVar;
            if (this.e == m.SDCARD && d != null && d.isOpen()) {
                return;
            }
            if (this.e == m.INNER && c != null && c.isOpen()) {
                return;
            }
            try {
                if (this.e == m.SDCARD) {
                    i iVar = new i();
                    iVar.a(new l(this));
                    d = iVar.a();
                } else {
                    c = new h(TiebaApplication.a()).getWritableDatabase();
                }
            } catch (Exception e) {
                ae.b("DatabaseService", "DatabaseService", "error = " + e.getMessage());
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
    public static com.baidu.tieba.b.u a(int i, String str, String str2, String str3) {
        Throwable th;
        Cursor cursor;
        com.baidu.tieba.b.u uVar = null;
        ?? r2 = 1;
        if (TiebaApplication.u() != null) {
            k kVar = new k();
            try {
                try {
                    cursor = i == 0 ? kVar.a("select * from draft_box where account=? and type=? and forum_id=?", new String[]{TiebaApplication.u(), String.valueOf(i), str}) : i == 1 ? kVar.a("select * from draft_box where account=? and type=? and thread_id=?", new String[]{TiebaApplication.u(), String.valueOf(i), str2}) : kVar.a("select * from draft_box where account=? and type=? and thread_id=? and floor_id=?", new String[]{TiebaApplication.u(), String.valueOf(i), str2, str3});
                    if (cursor != null) {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tieba.b.u uVar2 = new com.baidu.tieba.b.u();
                                try {
                                    uVar2.a(i);
                                    uVar2.e(str);
                                    uVar2.f(cursor.getString(3));
                                    uVar2.c(str2);
                                    uVar2.d(str3);
                                    uVar2.a(cursor.getString(6));
                                    uVar2.b(cursor.getString(7));
                                    uVar = uVar2;
                                } catch (Exception e) {
                                    uVar = uVar2;
                                    e = e;
                                    ae.b("DatabaseService", "getDraftBox", "error = " + e.getMessage());
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                        }
                                    }
                                    return uVar;
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
        return uVar;
    }

    public static String a(int i) {
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

    public static void a() {
        b(0);
    }

    private static void a(int i, String str) {
        k kVar;
        if (TiebaApplication.u() == null || (kVar = new k()) == null) {
            return;
        }
        try {
            kVar.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.u()});
            kVar.a("Insert into cash_data(account,type,data) values(?,?,?)", new Object[]{TiebaApplication.u(), Integer.valueOf(i), str});
        } catch (Exception e) {
            ae.b("DatabaseService", "cachData", "error = " + e.getMessage());
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

    public static void a(com.baidu.tieba.a.a aVar) {
        if (aVar == null || aVar.b() == null) {
            return;
        }
        if (aVar.e() == 1) {
            i();
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

    public static void a(com.baidu.tieba.b.u uVar) {
        if (TiebaApplication.u() == null) {
            return;
        }
        k kVar = new k();
        try {
            if (uVar.a() == 0) {
                kVar.a("delete from draft_box where account=? and type=? and forum_id=?", new Object[]{TiebaApplication.u(), 0, uVar.f()});
            } else if (uVar.a() == 1) {
                kVar.a("delete from draft_box where account=? and type=? and thread_id=?", new Object[]{TiebaApplication.u(), 1, uVar.d()});
            } else {
                kVar.a("delete from draft_box where account=? and type=? and thread_id=? and floor_id=?", new Object[]{TiebaApplication.u(), 2, uVar.d(), uVar.e()});
            }
        } catch (Exception e) {
            ae.b("DatabaseService", "deleteDraftBox", "error = " + e.getMessage());
        }
    }

    public static void a(Boolean bool) {
        a = bool;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.c.m */
    /* JADX WARN: Multi-variable type inference failed */
    private static void a(String str, int i, String str2, Bitmap bitmap) {
        Cursor cursor;
        Cursor a2;
        Cursor cursor2 = null;
        if (str2 == null) {
            return;
        }
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
                    kVar.a("Insert into " + str + "(key,image,date) values(?,?,?)", new Object[]{str2, e.c(bitmap, 80), Long.valueOf(new Date().getTime())});
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

    public static void a(String str, Bitmap bitmap) {
        a("pb_photo", 5000, str, bitmap);
    }

    public static void a(String str, String str2) {
        a(0, str, str2);
    }

    public static boolean a(com.baidu.tieba.a.ae aeVar) {
        if (TiebaApplication.u() == null) {
            return false;
        }
        Boolean bool = false;
        k kVar = new k();
        if (kVar != null && aeVar != null) {
            try {
                kVar.a("delete from mark_data where id=? and account=?", (Object[]) new String[]{aeVar.d(), TiebaApplication.u()});
                Object[] objArr = new Object[14];
                objArr[0] = aeVar.d();
                objArr[1] = Integer.valueOf(aeVar.e());
                objArr[2] = Long.valueOf(aeVar.f());
                objArr[3] = aeVar.g();
                objArr[4] = Integer.valueOf(aeVar.h().booleanValue() ? 1 : 0);
                objArr[5] = Integer.valueOf(aeVar.i() ? 1 : 0);
                objArr[6] = aeVar.j();
                objArr[7] = TiebaApplication.u();
                objArr[8] = aeVar.a();
                objArr[9] = Integer.valueOf(aeVar.b());
                objArr[10] = Integer.valueOf(aeVar.c());
                objArr[11] = aeVar.l();
                objArr[12] = aeVar.k();
                objArr[13] = aeVar.m();
                bool = kVar.a("Insert into mark_data(id,floor,time,title,sequence,hostmode,postid,account,authorname,replynum,subPost,forumName,forumId,threadId) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)", objArr);
                if (bool.booleanValue()) {
                    b((Boolean) true);
                    a((Boolean) true);
                }
            } catch (Exception e) {
                ae.b("DatabaseService", "saveMarkData", "error = " + e.getMessage());
                bool = false;
            }
        }
        return bool.booleanValue();
    }

    public static boolean a(com.baidu.tieba.a.e eVar) {
        if (TiebaApplication.u() == null) {
            return false;
        }
        k kVar = new k();
        Date date = new Date();
        if (eVar == null || kVar == null) {
            return false;
        }
        try {
            kVar.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{eVar.a(), TiebaApplication.u()});
            return kVar.a("Insert into chunk_upload_data(md5,total_length,chunk_no,account,time) values(?,?,?,?,?)", new Object[]{eVar.a(), Long.valueOf(eVar.b()), Integer.valueOf(eVar.c()), TiebaApplication.u(), Long.valueOf(date.getTime() / 1000)}).booleanValue();
        } catch (Exception e) {
            ae.b("DatabaseService", "saveChunkUploadData", "error = " + e.getMessage());
            return false;
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

    public static Bitmap b(String str) {
        return c("pb_photo", str);
    }

    public static String b() {
        return c(0);
    }

    private static void b(int i) {
        k kVar;
        if (TiebaApplication.u() == null || (kVar = new k()) == null) {
            return;
        }
        try {
            kVar.a("delete from cash_data where type=? and account=?", (Object[]) new String[]{String.valueOf(i), TiebaApplication.u()});
        } catch (Exception e) {
            ae.b("DatabaseService", "cachData", "error = " + e.getMessage());
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

    public static void b(com.baidu.tieba.b.u uVar) {
        if (TiebaApplication.u() == null) {
            return;
        }
        a(uVar);
        try {
            new k().a("Insert into draft_box(account,type,forum_id,forum_name,thread_id,floor_id,title,content,time) values(?,?,?,?,?,?,?,?,?)", new Object[]{TiebaApplication.u(), Integer.valueOf(uVar.a()), uVar.f(), uVar.g(), uVar.d(), uVar.e(), uVar.b(), uVar.c(), Long.valueOf(new Date().getTime())});
        } catch (Exception e) {
            ae.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
        }
    }

    public static void b(Boolean bool) {
        b = bool;
    }

    public static void b(String str, Bitmap bitmap) {
        a("friend_photo", 500, str, bitmap);
    }

    public static void b(String str, String str2) {
        k kVar;
        if (str == null || str2 == null || (kVar = new k()) == null) {
            return;
        }
        try {
            kVar.a("update account_data set bduss=? where account=?", (Object[]) new String[]{str2, str});
        } catch (Exception e) {
            ae.b("DatabaseService", "updateAccountToken", "error = " + e.getMessage());
        }
    }

    public static Bitmap c(String str) {
        return c("friend_photo", str);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:32:0x0074 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.c.m] */
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
                                    bitmap = e.a(cursor.getBlob(1));
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

    public static String c() {
        return c(2);
    }

    private static String c(int i) {
        Cursor cursor;
        String str;
        Exception e;
        Cursor cursor2;
        Cursor cursor3 = null;
        if (TiebaApplication.u() == null) {
            return null;
        }
        k kVar = new k();
        try {
            if (kVar != null) {
                try {
                    cursor = kVar.a("select * from cash_data where type = ? and account=?", new String[]{String.valueOf(i), TiebaApplication.u()});
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

    public static void d() {
        b(2);
    }

    public static void d(String str) {
        a(0, str);
    }

    public static void e() {
        b(3);
    }

    public static void e(String str) {
        b(0, str);
    }

    public static String f() {
        return c(3);
    }

    public static String f(String str) {
        return c(0, str);
    }

    public static void g() {
        b(4);
    }

    public static void g(String str) {
        a(2, str);
    }

    public static String h() {
        return c(4);
    }

    public static void h(String str) {
        a(3, str);
    }

    public static void i() {
        k kVar = new k();
        if (kVar != null) {
            try {
                kVar.a("update account_data set isactive=0 where isactive=1");
            } catch (Exception e) {
                ae.b("DatabaseService", "clearActiveAccount", "error = " + e.getMessage());
            }
        }
    }

    public static void i(String str) {
        a(4, str);
    }

    public static ArrayList j() {
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

    public static void j(String str) {
        k kVar = new k();
        if (kVar == null || str == null) {
            return;
        }
        try {
            Date date = new Date();
            kVar.a("delete from search_data where key=?", (Object[]) new String[]{str});
            kVar.a("Insert into search_data(key,account,time) values(?,?,?)", new Object[]{str, TiebaApplication.u(), Long.valueOf(date.getTime())});
        } catch (Exception e) {
            ae.b("DatabaseService", "saveSearchData", "error = " + e.getMessage());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static int k() {
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

    /* JADX WARN: Removed duplicated region for block: B:57:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.a.ae k(String str) {
        Cursor cursor;
        Cursor cursor2;
        Exception e;
        com.baidu.tieba.a.ae aeVar;
        Cursor cursor3;
        if (TiebaApplication.u() == null) {
            return null;
        }
        k kVar = new k();
        if (kVar != null) {
            try {
                cursor = kVar.a("select * from mark_data where id=? and account=?", new String[]{str, TiebaApplication.u()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tieba.a.ae aeVar2 = new com.baidu.tieba.a.ae();
                                try {
                                    aeVar2.b(cursor.getString(0));
                                    aeVar2.c(cursor.getInt(1));
                                    aeVar2.a(cursor.getInt(2));
                                    aeVar2.c(cursor.getString(3));
                                    aeVar2.a(Boolean.valueOf(cursor.getInt(4) == 1));
                                    aeVar2.a(cursor.getInt(5) == 1);
                                    aeVar2.d(cursor.getString(6));
                                    aeVar2.a(cursor.getString(8));
                                    aeVar2.a(cursor.getInt(9));
                                    aeVar2.b(cursor.getInt(10));
                                    aeVar2.g(cursor.getString(11));
                                    aeVar2.f(cursor.getString(12));
                                    aeVar2.h(cursor.getString(13));
                                    aeVar = aeVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    aeVar = aeVar2;
                                    cursor2 = cursor;
                                    try {
                                        ae.b("DatabaseService", "getMarkDataById", "error = " + e.getMessage());
                                        if (cursor2 != null) {
                                        }
                                        return aeVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                aeVar = null;
                            }
                            try {
                                cursor.close();
                            } catch (Exception e3) {
                                e = e3;
                                cursor2 = cursor;
                                ae.b("DatabaseService", "getMarkDataById", "error = " + e.getMessage());
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                return aeVar;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Exception e5) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e6) {
                        cursor2 = cursor;
                        e = e6;
                        aeVar = null;
                    }
                } else {
                    aeVar = null;
                }
                cursor3 = null;
            } catch (Exception e7) {
                cursor2 = null;
                e = e7;
                aeVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            aeVar = null;
            cursor3 = null;
        }
        if (0 != 0) {
            try {
                cursor3.close();
            } catch (Exception e8) {
            }
        }
        return aeVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.a.a l() {
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

    public static boolean l(String str) {
        k kVar;
        boolean z = false;
        if (TiebaApplication.u() != null && (kVar = new k()) != null) {
            try {
                z = kVar.a("delete from mark_data where id=? and account=?", (Object[]) new String[]{str, TiebaApplication.u()}).booleanValue();
                if (z) {
                    a((Boolean) true);
                    b((Boolean) true);
                }
            } catch (Exception e) {
                ae.b("DatabaseService", "deleteMarkData", "error = " + e.getMessage());
            }
        }
        return z;
    }

    public static ArrayList m() {
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        k kVar = new k();
        ArrayList arrayList = new ArrayList();
        try {
            if (kVar != null) {
                try {
                    cursor = kVar.a("select * from search_data order by time desc limit 10", (String[]) null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                String string = cursor.getString(0);
                                if (string != null && string.length() > 0) {
                                    arrayList.add(string);
                                }
                            } catch (Exception e) {
                                e = e;
                                ae.b("DatabaseService", "getAllSearchData", "error = " + e.getMessage());
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

    public static void m(String str) {
        if (TiebaApplication.u() == null) {
            return;
        }
        k kVar = new k();
        if (str == null || kVar == null) {
            return;
        }
        try {
            kVar.a("delete from chunk_upload_data where md5=? and account=?", (Object[]) new String[]{str, TiebaApplication.u()});
        } catch (Exception e) {
            ae.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.baidu.tieba.a.e n(String str) {
        Cursor cursor;
        Cursor cursor2;
        Exception e;
        com.baidu.tieba.a.e eVar;
        Cursor cursor3;
        if (TiebaApplication.u() == null) {
            return null;
        }
        k kVar = new k();
        if (kVar != null) {
            try {
                cursor = kVar.a("select * from chunk_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TiebaApplication.u()});
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToFirst()) {
                                com.baidu.tieba.a.e eVar2 = new com.baidu.tieba.a.e();
                                try {
                                    eVar2.a(str);
                                    eVar2.a(cursor.getInt(3));
                                    eVar2.a(cursor.getLong(2));
                                    eVar = eVar2;
                                } catch (Exception e2) {
                                    e = e2;
                                    eVar = eVar2;
                                    cursor2 = cursor;
                                    try {
                                        ae.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                                        if (cursor2 != null) {
                                            try {
                                                cursor2.close();
                                            } catch (Exception e3) {
                                            }
                                        }
                                        return eVar;
                                    } catch (Throwable th) {
                                        th = th;
                                        cursor = cursor2;
                                        if (cursor != null) {
                                        }
                                        throw th;
                                    }
                                }
                            } else {
                                eVar = null;
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
                        eVar = null;
                    }
                    try {
                        cursor.close();
                    } catch (Exception e6) {
                        e = e6;
                        cursor2 = cursor;
                        ae.b("DatabaseService", "getChunkUploadDataByMd5", "error = " + e.getMessage());
                        if (cursor2 != null) {
                        }
                        return eVar;
                    }
                } else {
                    eVar = null;
                }
                cursor3 = null;
            } catch (Exception e7) {
                cursor2 = null;
                e = e7;
                eVar = null;
            } catch (Throwable th3) {
                th = th3;
                cursor = null;
            }
        } else {
            eVar = null;
            cursor3 = null;
        }
        if (0 != 0) {
            try {
                cursor3.close();
            } catch (Exception e8) {
            }
        }
        return eVar;
    }

    public static void n() {
        k kVar = new k();
        if (kVar != null) {
            try {
                kVar.a("delete from search_data");
            } catch (Exception e) {
                ae.b("DatabaseService", "delAllSearchData", "error = " + e.getMessage());
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:44:0x0122 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.tieba.c.k] */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public static ArrayList o() {
        Cursor cursor;
        Exception e;
        Cursor cursor2;
        if (TiebaApplication.u() == null) {
            return null;
        }
        ?? kVar = new k();
        ArrayList arrayList = new ArrayList();
        try {
            if (kVar != 0) {
                try {
                    cursor = kVar.a("select * from mark_data where account=? order by time desc", new String[]{TiebaApplication.u()});
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            try {
                                com.baidu.tieba.a.ae aeVar = new com.baidu.tieba.a.ae();
                                aeVar.b(cursor.getString(0));
                                aeVar.c(cursor.getInt(1));
                                aeVar.a(cursor.getInt(2));
                                aeVar.c(cursor.getString(3));
                                aeVar.a(Boolean.valueOf(cursor.getInt(4) == 1));
                                aeVar.a(cursor.getInt(5) == 1);
                                aeVar.d(cursor.getString(6));
                                aeVar.e(cursor.getString(7));
                                aeVar.a(cursor.getString(8));
                                aeVar.a(cursor.getInt(9));
                                aeVar.b(cursor.getInt(10));
                                aeVar.g(cursor.getString(11));
                                aeVar.f(cursor.getString(12));
                                aeVar.h(cursor.getString(13));
                                arrayList.add(aeVar);
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

    public static void o(String str) {
        k kVar;
        if (str == null || (kVar = new k()) == null) {
            return;
        }
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

    public static Boolean p() {
        return a;
    }

    public static void p(String str) {
        k kVar = new k();
        if (kVar == null || str == null) {
            return;
        }
        try {
            kVar.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
            kVar.a("Insert into frs_image_forums(forum_name) values(?)", new Object[]{str});
        } catch (Exception e) {
            ae.b("DatabaseService", "insertFrsImageForum", e.getMessage());
        }
    }

    public static Boolean q() {
        return b;
    }

    public static void q(String str) {
        k kVar = new k();
        if (kVar == null || str == null) {
            return;
        }
        try {
            kVar.a("delete from frs_image_forums where forum_name=?", (Object[]) new String[]{str});
        } catch (Exception e) {
            ae.b("DatabaseService", "delFrsImageForum", e.getMessage());
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    public static int r() {
        int i = 0;
        if (TiebaApplication.u() != null) {
            k kVar = new k();
            Cursor cursor = null;
            try {
                if (kVar != null) {
                    try {
                        cursor = kVar.a("select count(*) from mark_data where account=?", new String[]{TiebaApplication.u()});
                        if (cursor != null && cursor.moveToFirst()) {
                            int i2 = cursor.getInt(0);
                            try {
                                b((Boolean) false);
                                i = i2;
                            } catch (Exception e) {
                                i = i2;
                                e = e;
                                ae.b("DatabaseService", "getMarkDatanum", e.getMessage());
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception e2) {
                                    }
                                }
                                return i;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                }
            } finally {
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e4) {
                    }
                }
            }
        }
        return i;
    }

    public static void s() {
        long time = new Date().getTime() - 604800000;
        try {
            new k().a("delete from draft_box where time<?", new Object[]{Long.valueOf(time)});
        } catch (Exception e) {
            ae.b("DatabaseService", "delMouthAgoDraft", "error = " + e.getMessage());
        }
    }

    public static void t() {
        if (TiebaApplication.u() == null) {
            return;
        }
        k kVar = new k();
        try {
            kVar.a("delete from setting where account=?", new Object[]{TiebaApplication.u()});
            Object[] objArr = new Object[6];
            objArr[0] = TiebaApplication.u();
            objArr[1] = Integer.valueOf(TiebaApplication.a().G());
            objArr[2] = Integer.valueOf(TiebaApplication.a().M() ? 1 : 0);
            objArr[3] = Integer.valueOf(TiebaApplication.a().O() ? 1 : 0);
            objArr[4] = Integer.valueOf(TiebaApplication.a().N() ? 1 : 0);
            objArr[5] = Integer.valueOf(TiebaApplication.a().L());
            kVar.a("Insert into setting(account,frequency,fans_switch,reply_me_switch,at_me_switch,remind_tone) values(?,?,?,?,?,?)", objArr);
        } catch (Exception e) {
            ae.b("DatabaseService", "saveDraftBox", "error = " + e.getMessage());
        }
    }

    public static void u() {
        ae.a("databaseService", "getSetting", TiebaApplication.x());
        if (TiebaApplication.u() == null || TiebaApplication.u().length() <= 0 || TiebaApplication.x() == null) {
            TiebaApplication.a().d(0);
            return;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor a2 = new k().a("select * from setting where account=?", new String[]{TiebaApplication.u()});
                if (a2 == null || !a2.moveToFirst()) {
                    TiebaApplication.a().d(300);
                    TiebaApplication.a().j(true);
                    TiebaApplication.a().l(true);
                    TiebaApplication.a().k(true);
                    TiebaApplication.a().h(true);
                    TiebaApplication.a().i(false);
                } else {
                    TiebaApplication.a().d(a2.getInt(1));
                    if (a2.getInt(2) == 0) {
                        TiebaApplication.a().j(false);
                    } else {
                        TiebaApplication.a().j(true);
                    }
                    if (a2.getInt(3) == 0) {
                        TiebaApplication.a().l(false);
                    } else {
                        TiebaApplication.a().l(true);
                    }
                    if (a2.getInt(4) == 0) {
                        TiebaApplication.a().k(false);
                    } else {
                        TiebaApplication.a().k(true);
                    }
                    TiebaApplication.a().c(a2.getInt(5));
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

    public static void v() {
        k kVar;
        if (TiebaApplication.u() == null || (kVar = new k()) == null) {
            return;
        }
        try {
            kVar.a("delete from chunk_upload_data where strftime('%s','now') - time > 48 * 3600 and account=?", (Object[]) new String[]{TiebaApplication.u()});
        } catch (Exception e) {
            ae.b("DatabaseService", "delChunkUploadData", "error = " + e.getMessage());
        }
    }

    public static void w() {
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

    /* JADX WARN: Removed duplicated region for block: B:45:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList x() {
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
}
