package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ boolean c;
    final /* synthetic */ d e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(d dVar, String str, LinkedList linkedList, boolean z) {
        this.e = dVar;
        this.a = str;
        this.b = linkedList;
        this.c = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [606=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:52:0x02c8 */
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        Cursor cursor;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        SQLiteStatement sQLiteStatement = null;
        if (TextUtils.isEmpty(this.a) || this.b == null || this.b.size() == 0) {
            return false;
        }
        if (!TextUtils.isEmpty(this.a) && this.a.equals(String.valueOf(com.baidu.tieba.im.chat.a.a))) {
            return false;
        }
        StringBuilder append = new StringBuilder().append("tb_group_msg_");
        ?? r1 = this.a;
        String sb = append.append((String) r1).toString();
        SQLiteDatabase a = s.a();
        try {
            if (a == null) {
                return false;
            }
            try {
                a.beginTransaction();
                atomicInteger = this.e.b;
                if (atomicInteger.get() >= 20) {
                    cursor = a.rawQuery("select * from " + sb + " ORDER BY mid desc limit 1000, 1", null);
                    try {
                        String string = cursor.moveToNext() ? cursor.getString(cursor.getColumnIndex("mid")) : null;
                        com.baidu.tieba.util.o.a(cursor);
                        if (string != null) {
                            a.delete(sb, "mid<?", new String[]{string});
                        }
                        atomicInteger2 = this.e.b;
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
                sQLiteStatement = a.compileStatement(" INSERT INTO " + sb + "(" + PushConstants.EXTRA_CONTENT + ",create_time,ext,mid,msg_status,msg_type,uid,user_info,rid,read_flag,is_delete) VALUES(?,?,?,?,?,?,?,?,?,?,?);");
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    CommonMsgPojo commonMsgPojo = (CommonMsgPojo) it.next();
                    if (this.c && commonMsgPojo.isSelf() && commonMsgPojo.getRid() != 0) {
                        a.delete(sb, "mid=?", new String[]{String.valueOf(commonMsgPojo.getRid())});
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(PushConstants.EXTRA_CONTENT, commonMsgPojo.getContent());
                    contentValues.put("create_time", Long.valueOf(commonMsgPojo.getCreate_time()));
                    contentValues.put("ext", commonMsgPojo.getExt());
                    contentValues.put("mid", Long.valueOf(commonMsgPojo.getMid()));
                    contentValues.put("msg_status", Integer.valueOf(commonMsgPojo.getMsg_status()));
                    contentValues.put("msg_type", Integer.valueOf(commonMsgPojo.getMsg_type()));
                    contentValues.put("uid", commonMsgPojo.getUid());
                    contentValues.put("user_info", commonMsgPojo.getUser_info());
                    contentValues.put("rid", Long.valueOf(commonMsgPojo.getRid()));
                    contentValues.put("read_flag", Integer.valueOf(commonMsgPojo.getRead_flag()));
                    contentValues.put("is_delete", Integer.valueOf(commonMsgPojo.getIs_delete()));
                    if (a.update(sb, contentValues, "mid=?", new String[]{String.valueOf(commonMsgPojo.getMid())}) == 0) {
                        sQLiteStatement.clearBindings();
                        sQLiteStatement.bindString(1, commonMsgPojo.getContent());
                        sQLiteStatement.bindLong(2, commonMsgPojo.getCreate_time());
                        sQLiteStatement.bindString(3, commonMsgPojo.getExt());
                        sQLiteStatement.bindLong(4, commonMsgPojo.getMid());
                        sQLiteStatement.bindLong(5, commonMsgPojo.getMsg_status());
                        sQLiteStatement.bindLong(6, commonMsgPojo.getMsg_type());
                        sQLiteStatement.bindString(7, commonMsgPojo.getUid());
                        sQLiteStatement.bindString(8, commonMsgPojo.getUser_info());
                        sQLiteStatement.bindLong(9, commonMsgPojo.getRid());
                        sQLiteStatement.bindLong(10, commonMsgPojo.getRead_flag());
                        sQLiteStatement.bindLong(11, commonMsgPojo.getIs_delete());
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
