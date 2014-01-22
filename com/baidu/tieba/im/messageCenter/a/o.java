package com.baidu.tieba.im.messageCenter.a;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.bt;
import com.baidu.tieba.im.message.cr;
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public cr a(com.baidu.tieba.im.message.q qVar) {
        bt btVar;
        if (qVar == null || !(qVar instanceof com.baidu.tieba.im.message.k)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        byte[] a = com.baidu.tieba.b.a.a().r().a("p_group_info" + str);
        bt btVar2 = new bt();
        if (a != null) {
            try {
                btVar = (bt) l.a(103003, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            btVar.e(SapiErrorCode.SAVE_CERT_FAIL);
            return btVar;
        }
        btVar = btVar2;
        btVar.e(SapiErrorCode.SAVE_CERT_FAIL);
        return btVar;
    }
}
