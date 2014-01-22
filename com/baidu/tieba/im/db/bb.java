package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.util.by;
/* loaded from: classes.dex */
class bb extends SingleRunnable<Boolean> {
    final /* synthetic */ String a;
    final /* synthetic */ au b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar, String str) {
        this.b = auVar;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        try {
            this.b.a(Long.parseLong(this.a), true);
            return true;
        } catch (Exception e) {
            by.a(e, "PersonalMsgDao.markDeleteMsgTable", new Object[0]);
            com.baidu.adp.lib.g.e.a(e.toString());
            return false;
        }
    }
}
