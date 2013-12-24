package com.baidu.tieba.im.model;

import com.baidu.gson.Gson;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.ar;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.adp.a.g {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        BasicNameValuePair basicNameValuePair;
        String str;
        com.baidu.tieba.im.message.b a;
        if (obj != null && (obj instanceof BasicNameValuePair) && (basicNameValuePair = (BasicNameValuePair) obj) != null && basicNameValuePair.getName() != null && basicNameValuePair.getName().length() > 0) {
            String name = basicNameValuePair.getName();
            String value = basicNameValuePair.getValue();
            com.baidu.adp.lib.h.e.c("----send voice suc, vid : " + value);
            try {
                a = this.a.a(Long.parseLong(name));
                if (a != null) {
                    if (value != null && value.length() > 0) {
                        VoiceMsgData e = com.baidu.tieba.im.d.d.e(a);
                        if (e != null) {
                            e.setVoice_md5(value);
                            a.a("[" + new Gson().toJson(e) + "]");
                        }
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(a.t(), 0, "", "", "upload voice http suc vid = " + value, 0, "upload voice http success ", System.currentTimeMillis() - a.r()));
                        com.baidu.tieba.im.chat.a.b().a(a);
                        return;
                    }
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(a.t(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - a.r()));
                    this.a.c(a);
                    if (a instanceof com.baidu.tieba.im.message.d) {
                        com.baidu.tieba.im.message.d dVar = (com.baidu.tieba.im.message.d) a;
                        com.baidu.tieba.im.db.d.a().a(dVar.s(), String.valueOf(dVar.i()), String.valueOf(dVar.k()), 2, new r(this));
                    } else if (a instanceof com.baidu.tieba.im.message.p) {
                        com.baidu.tieba.im.message.p pVar = (com.baidu.tieba.im.message.p) a;
                        ar.a().a(pVar.l(), pVar.b(), String.valueOf(pVar.i()), String.valueOf(pVar.k()), 2, new s(this));
                    }
                }
            } catch (Exception e2) {
                str = MsglistModel.b;
                com.baidu.adp.lib.h.e.b(str, "BdLoadDataCallBack", e2.getMessage());
            }
        }
    }
}
