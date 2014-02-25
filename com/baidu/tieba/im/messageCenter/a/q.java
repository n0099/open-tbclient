package com.baidu.tieba.im.messageCenter.a;

import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.cc;
import com.baidu.tieba.im.message.da;
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.messageCenter.d {
    @Override // com.baidu.tieba.im.messageCenter.d
    public da a(com.baidu.tieba.im.message.s sVar) {
        cc ccVar;
        if (sVar == null || !(sVar instanceof com.baidu.tieba.im.message.l)) {
            return null;
        }
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        byte[] a = com.baidu.tieba.c.a.a().s().a("p_group_info" + str);
        cc ccVar2 = new cc();
        if (a != null) {
            try {
                ccVar = (cc) n.a(103003, a);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ccVar.e(SapiErrorCode.SAVE_CERT_FAIL);
            return ccVar;
        }
        ccVar = ccVar2;
        ccVar.e(SapiErrorCode.SAVE_CERT_FAIL);
        return ccVar;
    }
}
