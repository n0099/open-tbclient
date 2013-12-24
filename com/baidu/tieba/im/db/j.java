package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
/* loaded from: classes.dex */
class j extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ d c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar, String str, String str2) {
        this.c = dVar;
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        if (TextUtils.isEmpty(this.a)) {
            return false;
        }
        SQLiteDatabase a = s.a();
        String str = "tb_group_msg_" + this.a;
        if (a != null) {
            a.delete(str, "mid=?", new String[]{this.b});
            return true;
        }
        return false;
    }
}
