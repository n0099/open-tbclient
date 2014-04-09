package com.baidu.tieba.im.model;

import com.baidu.gson.Gson;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.VoiceMsgData;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa extends com.baidu.adp.a.h {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        BasicNameValuePair basicNameValuePair;
        String str;
        ax axVar;
        ax axVar2;
        if (obj != null && (obj instanceof BasicNameValuePair) && (basicNameValuePair = (BasicNameValuePair) obj) != null && basicNameValuePair.getName() != null && basicNameValuePair.getName().length() > 0) {
            String name = basicNameValuePair.getName();
            String value = basicNameValuePair.getValue();
            com.baidu.adp.lib.util.f.d("----send voice suc, vid : " + value);
            try {
                com.baidu.tieba.im.message.a.a a = MsglistModel.a(this.a, Long.parseLong(name));
                if (a != null) {
                    if (value != null && value.length() > 0) {
                        VoiceMsgData f = com.baidu.tieba.im.f.q.f(a);
                        if (f != null) {
                            f.setVoice_md5(value);
                            a.d("[" + new Gson().toJson(f) + "]");
                        }
                        TiebaStatic.a(a.e(), 0, "", "", "upload voice http suc vid = " + value, 0, "upload voice http success ", System.currentTimeMillis() - a.E());
                        com.baidu.tieba.im.chat.x.b().a(a);
                        axVar = this.a.k;
                        if (axVar != null) {
                            com.baidu.adp.lib.util.f.e("simon", "send callback", "send voice");
                            axVar2 = this.a.k;
                            axVar2.t();
                            return;
                        }
                        return;
                    }
                    TiebaStatic.a(a.e(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - a.E());
                    this.a.d(a);
                    if (a instanceof com.baidu.tieba.im.message.a.b) {
                        com.baidu.tieba.im.r.a(new ab(this, (com.baidu.tieba.im.message.a.b) a), null);
                    } else if (a instanceof com.baidu.tieba.im.message.a.f) {
                        com.baidu.tieba.im.r.a(new ac(this, (com.baidu.tieba.im.message.a.f) a), null);
                    } else if (a instanceof com.baidu.tieba.im.message.a.e) {
                        com.baidu.tieba.im.r.a(new ad(this, (com.baidu.tieba.im.message.a.e) a), null);
                    }
                }
            } catch (Exception e) {
                str = MsglistModel.a;
                com.baidu.adp.lib.util.f.b(str, "BdLoadDataCallBack", e.getMessage());
            }
        }
    }
}
