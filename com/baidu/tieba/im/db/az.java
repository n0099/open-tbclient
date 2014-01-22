package com.baidu.tieba.im.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
class az extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ au c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(au auVar, String str, String str2) {
        this.c = auVar;
        this.a = str;
        this.b = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        boolean z;
        try {
            if (TextUtils.isEmpty(this.a)) {
                z = false;
            } else {
                SQLiteDatabase a = s.a();
                String str = "tb_private_msg_" + this.a;
                if (a != null) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("is_delete", (Integer) 1);
                    a.update(str, contentValues, "mid=?", new String[]{this.b});
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            by.a(e, "PersonalMsgDao.markDeleteMsgByMid", new Object[0]);
            return false;
        }
    }
}
