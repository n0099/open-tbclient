package com.baidu.tieba.im.model;

import com.baidu.gson.Gson;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.ChatMessage;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.a.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistModel f1819a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MsglistModel msglistModel) {
        this.f1819a = msglistModel;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        BasicNameValuePair basicNameValuePair;
        String str;
        ChatMessage a2;
        if (obj != null && (obj instanceof BasicNameValuePair) && (basicNameValuePair = (BasicNameValuePair) obj) != null && basicNameValuePair.getName() != null && basicNameValuePair.getName().length() > 0) {
            String name = basicNameValuePair.getName();
            String value = basicNameValuePair.getValue();
            com.baidu.adp.lib.h.e.c("----send voice suc, vid : " + value);
            try {
                a2 = this.f1819a.a(Long.parseLong(name));
                if (a2 != null) {
                    if (value != null && value.length() > 0) {
                        VoiceMsgData e = com.baidu.tieba.im.e.d.e(a2);
                        if (e != null) {
                            e.setVoice_md5(value);
                            a2.setContent("[" + new Gson().toJson(e) + "]");
                        }
                        com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(a2.getCmd(), 0, "", "", "upload voice http suc vid = " + value, 0, "upload voice http success ", System.currentTimeMillis() - a2.getLogTime()));
                        com.baidu.tieba.im.chat.a.b().a(a2);
                        return;
                    }
                    com.baidu.tieba.log.a.b(com.baidu.tieba.log.i.a(a2.getCmd(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - a2.getLogTime()));
                    this.f1819a.c(a2);
                    com.baidu.tieba.im.db.d.a().a(a2.getGroupId(), String.valueOf(a2.getRecordId()), String.valueOf(a2.getMsgId()), 2, new l(this));
                }
            } catch (Exception e2) {
                str = MsglistModel.b;
                com.baidu.adp.lib.h.e.b(str, "BdLoadDataCallBack", e2.getMessage());
            }
        }
    }
}
