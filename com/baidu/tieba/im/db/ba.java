package com.baidu.tieba.im.db;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
class ba extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ au c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(au auVar, String str, String str2) {
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
                    a.delete(str, "mid=?", new String[]{this.b});
                    z = true;
                } else {
                    z = false;
                }
            }
            return z;
        } catch (Exception e) {
            by.a(e, "PersonalMsgDao.deleteMsgByMid", new Object[0]);
            return false;
        }
    }
}
