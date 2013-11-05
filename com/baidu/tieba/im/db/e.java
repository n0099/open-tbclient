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
public class e extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LinkedList f1522a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, LinkedList linkedList) {
        this.b = aVar;
        this.f1522a = linkedList;
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
        if (this.f1522a != null && this.f1522a.size() != 0) {
            SQLiteDatabase a2 = m.a();
            LinkedList linkedList = new LinkedList();
            if (a2 != null) {
                try {
                    cursor = a2.rawQuery("select * from sqlite_master where type='table'", null);
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
                                com.baidu.tieba.util.g.a(cursor);
                                it = this.f1522a.iterator();
                                while (it.hasNext()) {
                                }
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            com.baidu.tieba.util.g.a(cursor);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = null;
                    e.printStackTrace();
                    com.baidu.tieba.util.g.a(cursor);
                    it = this.f1522a.iterator();
                    while (it.hasNext()) {
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                    com.baidu.tieba.util.g.a(cursor);
                    throw th;
                }
            } else {
                cursor = null;
            }
            com.baidu.adp.lib.h.d.d("haveTables:" + linkedList);
            com.baidu.tieba.util.g.a(cursor);
            it = this.f1522a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (TextUtils.isEmpty(str)) {
                    com.baidu.adp.lib.h.d.a("gid is null");
                } else if (!linkedList.contains(str)) {
                    this.b.d(str);
                }
            }
        }
        return null;
    }
}
