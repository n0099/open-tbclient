package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends SingleRunnable<Boolean> {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ LinkedList c;
    final /* synthetic */ boolean e;
    final /* synthetic */ ar f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(ar arVar, long j, long j2, LinkedList linkedList, boolean z) {
        this.f = arVar;
        this.a = j;
        this.b = j2;
        this.c = linkedList;
        this.e = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [739=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0321 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        Cursor cursor;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        SQLiteStatement sQLiteStatement = null;
        if (this.a == 0 || this.b == 0 || TiebaApplication.B() == null) {
            return false;
        }
        String valueOf = String.valueOf(this.a);
        if (TiebaApplication.B().equals(valueOf)) {
            valueOf = String.valueOf(this.b);
        }
        String str = "tb_private_msg_" + valueOf;
        if (this.f.a == null) {
            this.f.a = this.f.c();
        }
        boolean contains = this.f.a.contains(valueOf);
        ?? r1 = contains;
        if (!contains) {
            this.f.d(valueOf);
            List<String> list = this.f.a;
            list.add(valueOf);
            r1 = list;
        }
        SQLiteDatabase a = s.a();
        try {
            if (a == null) {
                return false;
            }
            try {
                a.beginTransaction();
                atomicInteger = this.f.c;
                if (atomicInteger.get() >= 20) {
                    cursor = a.rawQuery("select * from " + str + " ORDER BY mid desc limit 1000, 1", null);
                    try {
                        String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                        com.baidu.tieba.util.o.a(cursor);
                        if (string != null) {
                            a.delete(str, "mid<?", new String[]{string});
                        }
                        atomicInteger2 = this.f.c;
                        atomicInteger2.set(0);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        Boolean.valueOf(false);
                        com.baidu.tieba.util.o.a(cursor);
                        com.baidu.tieba.util.o.a(sQLiteStatement);
                        a.endTransaction();
                        return true;
                    }
                } else {
                    cursor = null;
                }
                sQLiteStatement = a.compileStatement(" INSERT INTO " + str + "(" + PushConstants.EXTRA_CONTENT + ",create_time,ext,mid,uid,user_info,to_uid,to_user_info,msg_status,msg_type,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?);");
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    CommonMsgPojo commonMsgPojo = (CommonMsgPojo) it.next();
                    if (this.e && commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                        a.delete(str, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(PushConstants.EXTRA_CONTENT, commonMsgPojo.getContent());
                    contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                    contentValues.put("ext", commonMsgPojo.getExt());
                    contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                    contentValues.put("uid", commonMsgPojo.getUid());
                    contentValues.put("user_info", commonMsgPojo.getUser_info());
                    contentValues.put("to_uid", commonMsgPojo.getToUid());
                    contentValues.put("to_user_info", commonMsgPojo.getToUser_info());
                    contentValues.put("msg_status", Integer.valueOf(commonMsgPojo.getMsg_status()));
                    contentValues.put("msg_type", Integer.valueOf(commonMsgPojo.getMsg_type()));
                    contentValues.put("rid", Long.valueOf(commonMsgPojo.getRid()));
                    contentValues.put("read_flag", Integer.valueOf(commonMsgPojo.getRead_flag()));
                    contentValues.put("is_delete", Integer.valueOf(commonMsgPojo.getIs_delete()));
                    if (a.update(str, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) == 0) {
                        sQLiteStatement.clearBindings();
                        sQLiteStatement.bindString(1, commonMsgPojo.getContent());
                        sQLiteStatement.bindLong(2, commonMsgPojo.getCreate_time());
                        sQLiteStatement.bindString(3, commonMsgPojo.getExt());
                        sQLiteStatement.bindLong(4, commonMsgPojo.getMid());
                        sQLiteStatement.bindString(5, commonMsgPojo.getUid());
                        sQLiteStatement.bindString(6, commonMsgPojo.getUser_info());
                        sQLiteStatement.bindString(7, commonMsgPojo.getToUid());
                        sQLiteStatement.bindString(8, commonMsgPojo.getToUser_info());
                        sQLiteStatement.bindLong(9, commonMsgPojo.getMsg_status());
                        sQLiteStatement.bindLong(10, commonMsgPojo.getMsg_type());
                        sQLiteStatement.bindLong(11, commonMsgPojo.getRid());
                        sQLiteStatement.bindLong(12, commonMsgPojo.getRead_flag());
                        sQLiteStatement.bindLong(13, commonMsgPojo.getIs_delete());
                        sQLiteStatement.executeInsert();
                    }
                }
                a.setTransactionSuccessful();
                com.baidu.tieba.util.o.a(cursor);
                com.baidu.tieba.util.o.a(sQLiteStatement);
                a.endTransaction();
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th) {
                th = th;
                r1 = 0;
                com.baidu.tieba.util.o.a((Cursor) r1);
                com.baidu.tieba.util.o.a((SQLiteStatement) null);
                a.endTransaction();
                throw th;
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
