package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1669a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ boolean c;
    final /* synthetic */ d e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, String str, LinkedList linkedList, boolean z) {
        this.e = dVar;
        this.f1669a = str;
        this.b = linkedList;
        this.c = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [597=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        Cursor cursor;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        SQLiteStatement sQLiteStatement = null;
        if (TextUtils.isEmpty(this.f1669a) || this.b == null || this.b.size() == 0) {
            return false;
        }
        String str = d.f1666a + this.f1669a;
        SQLiteDatabase a2 = s.a();
        if (a2 == null) {
            return false;
        }
        try {
            a2.beginTransaction();
            atomicInteger = this.e.c;
            if (atomicInteger.get() >= 20) {
                cursor = a2.rawQuery("select * from " + str + " ORDER BY mid desc limit 1000, 1", null);
                try {
                    try {
                        String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                        com.baidu.tieba.util.o.a(cursor);
                        if (string != null) {
                            a2.delete(str, "mid<?", new String[]{string});
                        }
                        atomicInteger2 = this.e.c;
                        atomicInteger2.set(0);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        Boolean.valueOf(false);
                        com.baidu.tieba.util.o.a(cursor);
                        com.baidu.tieba.util.o.a(sQLiteStatement);
                        a2.endTransaction();
                        return true;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.tieba.util.o.a(cursor);
                    com.baidu.tieba.util.o.a(sQLiteStatement);
                    a2.endTransaction();
                    throw th;
                }
            } else {
                cursor = null;
            }
            sQLiteStatement = a2.compileStatement(" INSERT INTO " + str + "(content,create_time,ext,mid,msg_status,msg_type,uid,user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                GroupMsgPojo groupMsgPojo = (GroupMsgPojo) it.next();
                if (this.c && groupMsgPojo.isSelf() && groupMsgPojo.getRid() != 0) {
                    a2.delete(str, "mid=?", new String[]{String.valueOf(groupMsgPojo.getRid())});
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("content", groupMsgPojo.getContent());
                contentValues.put("create_time", Long.valueOf(groupMsgPojo.getCreate_time()));
                contentValues.put("ext", groupMsgPojo.getExt());
                contentValues.put("mid", Long.valueOf(groupMsgPojo.getMid()));
                contentValues.put("msg_status", Integer.valueOf(groupMsgPojo.getMsg_status()));
                contentValues.put("msg_type", Integer.valueOf(groupMsgPojo.getMsg_type()));
                contentValues.put("uid", groupMsgPojo.getUid());
                contentValues.put("user_info", groupMsgPojo.getUser_info());
                contentValues.put("rid", Long.valueOf(groupMsgPojo.getRid()));
                contentValues.put("read_flag", Integer.valueOf(groupMsgPojo.getRead_flag()));
                contentValues.put("is_delete", Integer.valueOf(groupMsgPojo.getIs_delete()));
                if (a2.update(str, contentValues, "mid=?", new String[]{String.valueOf(groupMsgPojo.getMid())}) == 0) {
                    sQLiteStatement.clearBindings();
                    sQLiteStatement.bindString(1, groupMsgPojo.getContent());
                    sQLiteStatement.bindLong(2, groupMsgPojo.getCreate_time());
                    sQLiteStatement.bindString(3, groupMsgPojo.getExt());
                    sQLiteStatement.bindLong(4, groupMsgPojo.getMid());
                    sQLiteStatement.bindLong(5, groupMsgPojo.getMsg_status());
                    sQLiteStatement.bindLong(6, groupMsgPojo.getMsg_type());
                    sQLiteStatement.bindString(7, groupMsgPojo.getUid());
                    sQLiteStatement.bindString(8, groupMsgPojo.getUser_info());
                    sQLiteStatement.bindLong(9, groupMsgPojo.getRid());
                    sQLiteStatement.bindLong(10, groupMsgPojo.getRead_flag());
                    sQLiteStatement.bindLong(11, groupMsgPojo.getIs_delete());
                    sQLiteStatement.executeInsert();
                }
            }
            a2.setTransactionSuccessful();
            com.baidu.tieba.util.o.a(cursor);
            com.baidu.tieba.util.o.a(sQLiteStatement);
            a2.endTransaction();
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.tieba.util.o.a(cursor);
            com.baidu.tieba.util.o.a(sQLiteStatement);
            a2.endTransaction();
            throw th;
        }
        return true;
    }
}
