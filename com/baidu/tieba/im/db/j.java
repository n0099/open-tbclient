package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f1618a;
    final /* synthetic */ g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar, String str) {
        this.b = gVar;
        this.f1618a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z;
        Boolean.valueOf(false);
        try {
            SQLiteDatabase a2 = m.a();
            if (a2 != null) {
                a2.delete("tb_group_news", "notice_id = ?", new String[]{this.f1618a});
                z = true;
            } else {
                z = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            z = false;
        }
        com.baidu.adp.lib.h.d.d("noticeid: " + this.f1618a + " success:" + z);
        return z;
    }
}
