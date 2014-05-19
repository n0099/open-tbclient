package com.baidu.tieba.im.model;

import com.baidu.adp.lib.util.BdLog;
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
public class ae extends com.baidu.adp.base.g {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        BasicNameValuePair basicNameValuePair;
        String str;
        ChatMessage a;
        bb bbVar;
        bb bbVar2;
        if (obj != null && (obj instanceof BasicNameValuePair) && (basicNameValuePair = (BasicNameValuePair) obj) != null && basicNameValuePair.getName() != null && basicNameValuePair.getName().length() > 0) {
            String name = basicNameValuePair.getName();
            String value = basicNameValuePair.getValue();
            BdLog.i("----send voice suc, vid : " + value);
            try {
                a = this.a.a(Long.parseLong(name));
                if (a != null) {
                    if (value != null && value.length() > 0) {
                        VoiceMsgData g = com.baidu.tieba.im.f.r.g(a);
                        if (g != null) {
                            g.setVoice_md5(value);
                            a.setContent("[" + new Gson().toJson(g) + "]");
                        }
                        TiebaStatic.imLog(a.getCmd(), 0, "", "", "upload voice http suc vid = " + value, 0, "upload voice http success ", System.currentTimeMillis() - a.getLogTime());
                        com.baidu.tieba.im.chat.x.b().a(a);
                        bbVar = this.a.h;
                        if (bbVar != null) {
                            BdLog.d("simon", "send callback", "send voice");
                            bbVar2 = this.a.h;
                            bbVar2.a(2);
                            return;
                        }
                        return;
                    }
                    TiebaStatic.imLog(a.getCmd(), 0, "", "", "", -1, "upload voice http fail", System.currentTimeMillis() - a.getLogTime());
                    this.a.e(a);
                    if (a instanceof CommonGroupChatMessage) {
                        com.baidu.tieba.im.i.a(new af(this, (CommonGroupChatMessage) a), null);
                    } else if (a instanceof PersonalChatMessage) {
                        com.baidu.tieba.im.i.a(new ag(this, (PersonalChatMessage) a), null);
                    } else if (a instanceof OfficialChatMessage) {
                        com.baidu.tieba.im.i.a(new ah(this, (OfficialChatMessage) a), null);
                    }
                }
            } catch (Exception e) {
                str = MsglistModel.a;
                BdLog.e(str, "BdLoadDataCallBack", e.getMessage());
            }
        }
    }
}
