package com.baidu.tieba.im.model;

import com.baidu.gson.Gson;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.adp.base.h {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        BasicNameValuePair basicNameValuePair;
        ChatMessage a;
        bb bbVar;
        bb bbVar2;
        if (obj != null && (obj instanceof BasicNameValuePair) && (basicNameValuePair = (BasicNameValuePair) obj) != null && basicNameValuePair.getName() != null && basicNameValuePair.getName().length() > 0) {
            String name = basicNameValuePair.getName();
            String value = basicNameValuePair.getValue();
            try {
                a = this.a.a(Long.parseLong(name));
                if (a != null) {
                    if (value != null && value.length() > 0) {
                        VoiceMsgData g = com.baidu.tieba.im.e.r.g(a);
                        if (g != null) {
                            g.setVoice_md5(value);
                            a.setContent("[" + new Gson().toJson(g) + "]");
                        }
                        TiebaStatic.imLog(a.getCmd(), 0, "", "", "upload voice http suc vid = " + value, 0, "upload voice http success ", System.currentTimeMillis() - a.getLogTime());
                        com.baidu.tieba.im.chat.w.b().a(a);
                        bbVar = this.a.g;
                        if (bbVar != null) {
                            bbVar2 = this.a.g;
                            bbVar2.a(2);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.imLog(a.getCmd(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - a.getLogTime());
                    this.a.e(a);
                    if (a instanceof CommonGroupChatMessage) {
                        com.baidu.tieba.im.i.a(new ae(this, (CommonGroupChatMessage) a), null);
                    } else if (a instanceof PersonalChatMessage) {
                        com.baidu.tieba.im.i.a(new af(this, (PersonalChatMessage) a), null);
                    } else if (a instanceof OfficialChatMessage) {
                        com.baidu.tieba.im.i.a(new ag(this, (OfficialChatMessage) a), null);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
