package com.baidu.tieba.im.model;

import com.baidu.gson.Gson;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.util.cb;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends com.baidu.adp.a.g {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.adp.a.g
    public final void a(Object obj) {
        BasicNameValuePair basicNameValuePair;
        String str;
        aj ajVar;
        aj ajVar2;
        if (obj != null && (obj instanceof BasicNameValuePair) && (basicNameValuePair = (BasicNameValuePair) obj) != null && basicNameValuePair.getName() != null && basicNameValuePair.getName().length() > 0) {
            String name = basicNameValuePair.getName();
            String value = basicNameValuePair.getValue();
            com.baidu.adp.lib.util.e.d("----send voice suc, vid : " + value);
            try {
                com.baidu.tieba.im.message.b a = MsglistModel.a(this.a, Long.parseLong(name));
                if (a != null) {
                    if (value != null && value.length() > 0) {
                        VoiceMsgData f = com.baidu.tieba.im.util.l.f(a);
                        if (f != null) {
                            f.setVoice_md5(value);
                            a.a("[" + new Gson().toJson(f) + "]");
                        }
                        cb.a(a.v(), 0, "", "", "upload voice http suc vid = " + value, 0, "upload voice http success ", System.currentTimeMillis() - a.t());
                        com.baidu.tieba.im.chat.q.b().a(a);
                        ajVar = this.a.q;
                        if (ajVar != null) {
                            com.baidu.adp.lib.util.e.e("simon", "send callback", "send voice");
                            ajVar2 = this.a.q;
                            ajVar2.o();
                            return;
                        }
                        return;
                    }
                    cb.a(a.v(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - a.t());
                    this.a.b(a);
                    if (a instanceof com.baidu.tieba.im.message.g) {
                        com.baidu.tieba.im.i.a(new n(this, (com.baidu.tieba.im.message.g) a), null);
                    } else if (a instanceof com.baidu.tieba.im.message.w) {
                        com.baidu.tieba.im.i.a(new o(this, (com.baidu.tieba.im.message.w) a), null);
                    }
                }
            } catch (Exception e) {
                str = MsglistModel.b;
                com.baidu.adp.lib.util.e.b(str, "BdLoadDataCallBack", e.getMessage());
            }
        }
    }
}
