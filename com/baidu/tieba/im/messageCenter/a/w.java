package com.baidu.tieba.im.messageCenter.a;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.message.ct;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.q a(com.baidu.tieba.im.message.q qVar, com.baidu.tieba.im.coder.d dVar) {
        if (qVar instanceof ct) {
            ct ctVar = (ct) qVar;
            AccountData E = TiebaApplication.E();
            if (E != null && !TextUtils.isEmpty(ctVar.a())) {
                DatabaseService.c(E.getAccount(), ctVar.a());
                E.setPortrait(ctVar.a());
            }
        }
        return null;
    }
}
