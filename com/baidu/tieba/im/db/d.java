package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1521a;
    final /* synthetic */ LinkedList b;
    final /* synthetic */ boolean c;
    final /* synthetic */ a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str, LinkedList linkedList, boolean z) {
        this.e = aVar;
        this.f1521a = str;
        this.b = linkedList;
        this.c = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [495=4] */
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        Cursor cursor;
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        if (TextUtils.isEmpty(this.f1521a) || this.b == null || this.b.size() == 0) {
            return false;
        }
        String str = a.f1510a + this.f1521a;
        SQLiteDatabase a2 = m.a();
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
                        com.baidu.tieba.util.g.a(cursor);
                        if (string != null) {
                            a2.delete(str, "mid<?", new String[]{string});
                        }
                        atomicInteger2 = this.e.c;
                        atomicInteger2.set(0);
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        Boolean.valueOf(false);
                        com.baidu.tieba.util.g.a(cursor);
                        a2.endTransaction();
                        return true;
                    }
                } catch (Throwable th) {
                    th = th;
                    com.baidu.tieba.util.g.a(cursor);
                    a2.endTransaction();
                    throw th;
                }
            } else {
                cursor = null;
            }
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
                contentValues.put("read_flag", (Integer) 0);
                if (a2.update(str, contentValues, "mid=?", new String[]{String.valueOf(groupMsgPojo.getMid())}) == 0) {
                    a2.insert(str, null, contentValues);
                }
            }
            a2.setTransactionSuccessful();
            com.baidu.tieba.util.g.a(cursor);
            a2.endTransaction();
        } catch (Exception e2) {
            e = e2;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            com.baidu.tieba.util.g.a(cursor);
            a2.endTransaction();
            throw th;
        }
        return true;
    }
}
