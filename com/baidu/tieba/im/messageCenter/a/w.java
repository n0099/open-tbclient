package com.baidu.tieba.im.messageCenter.a;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.message.cb;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.n a(com.baidu.tieba.im.message.n nVar, com.baidu.tieba.im.coder.d dVar) {
        if (nVar instanceof cb) {
            cb cbVar = (cb) nVar;
            AccountData F = TiebaApplication.F();
            if (F != null && !TextUtils.isEmpty(cbVar.a())) {
                DatabaseService.c(F.getAccount(), cbVar.a());
                F.setPortrait(cbVar.a());
            }
        }
        return null;
    }
}
