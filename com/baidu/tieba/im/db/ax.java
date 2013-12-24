package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ ar c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(ar arVar, String str, String str2) {
        this.c = arVar;
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
        String str = "tb_private_msg_" + this.a;
        if (a != null) {
            a.delete(str, "mid=?", new String[]{this.b});
            return true;
        }
        return false;
    }
}
