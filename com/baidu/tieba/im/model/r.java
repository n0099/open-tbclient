package com.baidu.tieba.im.model;

import com.baidu.gson.Gson;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.au;
import com.baidu.tieba.util.by;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.adp.a.g {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        BasicNameValuePair basicNameValuePair;
        String str;
        com.baidu.tieba.im.message.b a;
        ae aeVar;
        ae aeVar2;
        if (obj != null && (obj instanceof BasicNameValuePair) && (basicNameValuePair = (BasicNameValuePair) obj) != null && basicNameValuePair.getName() != null && basicNameValuePair.getName().length() > 0) {
            String name = basicNameValuePair.getName();
            String value = basicNameValuePair.getValue();
            com.baidu.adp.lib.g.e.c("----send voice suc, vid : " + value);
            try {
                a = this.a.a(Long.parseLong(name));
                if (a != null) {
                    if (value != null && value.length() > 0) {
                        VoiceMsgData f = com.baidu.tieba.im.d.d.f(a);
                        if (f != null) {
                            f.setVoice_md5(value);
                            a.a("[" + new Gson().toJson(f) + "]");
                        }
                        by.a(a.w(), 0, "", "", "upload voice http suc vid = " + value, 0, "upload voice http success ", System.currentTimeMillis() - a.t());
                        com.baidu.tieba.im.chat.q.b().a(a);
                        aeVar = this.a.q;
                        if (aeVar != null) {
                            com.baidu.adp.lib.g.e.e("simon", "send callback", "send voice");
                            aeVar2 = this.a.q;
                            aeVar2.a(2);
                            return;
                        }
                        return;
                    }
                    by.a(a.w(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - a.t());
                    this.a.c(a);
                    if (a instanceof com.baidu.tieba.im.message.g) {
                        com.baidu.tieba.im.message.g gVar = (com.baidu.tieba.im.message.g) a;
                        com.baidu.tieba.im.db.d.a().a(gVar.u(), String.valueOf(gVar.j()), String.valueOf(gVar.l()), 2, new s(this));
                    } else if (a instanceof com.baidu.tieba.im.message.u) {
                        com.baidu.tieba.im.message.u uVar = (com.baidu.tieba.im.message.u) a;
                        au.a().a(uVar.m(), uVar.c(), String.valueOf(uVar.j()), String.valueOf(uVar.l()), 2, new t(this));
                    }
                }
            } catch (Exception e) {
                str = MsglistModel.b;
                com.baidu.adp.lib.g.e.b(str, "BdLoadDataCallBack", e.getMessage());
            }
        }
    }
}
