package com.baidu.tieba.im.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.by;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends SingleRunnable<Void> {
    final /* synthetic */ LinkedList a;
    final /* synthetic */ au b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(au auVar, LinkedList linkedList) {
        this.b = auVar;
        this.a = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
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
            try {
                if (a != null) {
                    try {
                        cursor = a.rawQuery("select * from sqlite_master where type='table'", null);
                        if (cursor != null) {
                            try {
                                cursor.moveToFirst();
                                while (cursor.moveToNext()) {
                                    linkedList.add(cursor.getString(cursor.getColumnIndex(SocialConstants.PARAM_MEDIA_UNAME)));
                                }
                            } catch (Exception e) {
                                e = e;
                                by.a(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                                e.printStackTrace();
                                com.baidu.tieba.util.p.a(cursor);
                                it = this.a.iterator();
                                while (it.hasNext()) {
                                }
                                return null;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        cursor = null;
                        by.a(e, "PersonalMsgDao.createMsgTable", new Object[0]);
                        e.printStackTrace();
                        com.baidu.tieba.util.p.a(cursor);
                        it = this.a.iterator();
                        while (it.hasNext()) {
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        com.baidu.tieba.util.p.a((Cursor) null);
                        throw th;
                    }
                } else {
                    cursor = null;
                }
                com.baidu.adp.lib.g.e.d("haveTables:" + linkedList);
                com.baidu.tieba.util.p.a(cursor);
                it = this.a.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (TextUtils.isEmpty(str)) {
                        com.baidu.adp.lib.g.e.a("gid is null");
                    } else if (!linkedList.contains(str)) {
                        this.b.d(str);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }
}
