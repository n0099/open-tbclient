package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1678a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, String str) {
        this.b = lVar;
        this.f1678a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z;
        Boolean.valueOf(false);
        try {
            SQLiteDatabase a2 = s.a();
            if (a2 != null) {
                a2.delete("tb_group_news", "notice_id = ?", new String[]{this.f1678a});
                z = true;
            } else {
                z = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        com.baidu.adp.lib.h.e.d("noticeid: " + this.f1678a + " success:" + z);
        return z;
    }
}
