package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(l lVar, String str) {
        this.b = lVar;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z;
        Boolean.valueOf(false);
        try {
            SQLiteDatabase a = s.a();
            if (a != null) {
                a.delete("tb_group_news", "notice_id = ?", new String[]{this.a});
                z = true;
            } else {
                z = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        com.baidu.adp.lib.h.e.d("noticeid: " + this.a + " success:" + z);
        return z;
    }
}
