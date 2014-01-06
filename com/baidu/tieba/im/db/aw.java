package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.SingleRunnable;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw extends SingleRunnable<Void> {
    final /* synthetic */ LinkedList a;
    final /* synthetic */ as b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(as asVar, LinkedList linkedList) {
        this.b = asVar;
        this.a = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Void b() {
        Cursor cursor;
        Iterator it;
        if (this.a != null && this.a.size() != 0) {
            SQLiteDatabase a = s.a();
            LinkedList linkedList = new LinkedList();
            if (a != null) {
                try {
                    cursor = a.rawQuery("select * from sqlite_master where type='table'", null);
                    if (cursor != null) {
                        try {
                            try {
                                cursor.moveToFirst();
                                while (cursor.moveToNext()) {
                                    linkedList.add(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                com.baidu.tieba.util.o.a(cursor);
                                it = this.a.iterator();
                                while (it.hasNext()) {
                                }
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.tieba.util.o.a(cursor);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                    e.printStackTrace();
                    com.baidu.tieba.util.o.a(cursor);
                    it = this.a.iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    com.baidu.tieba.util.o.a(cursor);
                    throw th;
                }
            } else {
                cursor = null;
            }
            com.baidu.adp.lib.h.e.d("haveTables:" + linkedList);
            com.baidu.tieba.util.o.a(cursor);
            it = this.a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (TextUtils.isEmpty(str)) {
                    com.baidu.adp.lib.h.e.a("gid is null");
                } else if (!linkedList.contains(str)) {
                    this.b.d(str);
                }
            }
        }
        return null;
    }
}
