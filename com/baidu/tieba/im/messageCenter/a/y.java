package com.baidu.tieba.im.messageCenter.a;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.im.message.dc;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public final com.baidu.tieba.im.message.s a(com.baidu.tieba.im.message.s sVar, com.baidu.tieba.im.coder.d dVar) {
        if (sVar instanceof dc) {
            dc dcVar = (dc) sVar;
            AccountData y = TiebaApplication.y();
            if (y != null && !TextUtils.isEmpty(dcVar.a())) {
                DatabaseService.a(y.getAccount(), dcVar.a());
                y.setPortrait(dcVar.a());
            }
        }
        return null;
    }
}
