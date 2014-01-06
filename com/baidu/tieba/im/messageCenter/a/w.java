package com.baidu.tieba.im.messageCenter.a;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.message.ce;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class w extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public com.baidu.tieba.im.message.o a(com.baidu.tieba.im.message.o oVar, com.baidu.tieba.im.coder.d dVar) {
        if (oVar instanceof ce) {
            ce ceVar = (ce) oVar;
            AccountData F = TiebaApplication.F();
            if (F != null && !TextUtils.isEmpty(ceVar.a())) {
                DatabaseService.c(F.getAccount(), ceVar.a());
                F.setPortrait(ceVar.a());
            }
        }
        return null;
    }
}
