package com.baidu.tieba.im.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.util.e;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private static a eux = new a();
    private HashSet<String> euy = new HashSet<>();
    private StringBuilder euz = new StringBuilder();

    private a() {
    }

    public static a aLS() {
        return eux;
    }

    public void aLT() {
        String str;
        String str2 = null;
        if (this.euy != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.euy.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.length() > 0) {
                    sb.append(next).append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                if (sb.length() > 0) {
                    str = sb.toString();
                    if (this.euz != null && this.euz.length() > 0) {
                        this.euz.deleteCharAt(this.euz.length() - 1);
                        str2 = this.euz.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.euz != null) {
            this.euz.deleteCharAt(this.euz.length() - 1);
            str2 = this.euz.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aLU() {
        if (this.euz != null && this.euz.length() > 0) {
            this.euz.delete(0, this.euz.length());
        }
        if (this.euy != null) {
            this.euy.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d oN;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (oN = e.oN(chatMessage.getContent())) != null && !TextUtils.isEmpty(oN.taskId) && this.euy.add(oN.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", oN.eis, "task_id", oN.taskId);
            }
        }
    }

    public void oI(String str) {
        if (str != null && str.length() > 0) {
            this.euz.append(str).append(",");
        }
    }
}
