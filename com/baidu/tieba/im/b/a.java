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
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private static a eic = new a();
    private HashSet<String> eid = new HashSet<>();
    private StringBuilder eie = new StringBuilder();

    private a() {
    }

    public static a aGZ() {
        return eic;
    }

    public void aHa() {
        String str;
        String str2 = null;
        if (this.eid != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eid.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.length() > 0) {
                    sb.append(next).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                if (sb.length() > 0) {
                    str = sb.toString();
                    if (this.eie != null && this.eie.length() > 0) {
                        this.eie.deleteCharAt(this.eie.length() - 1);
                        str2 = this.eie.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eie != null) {
            this.eie.deleteCharAt(this.eie.length() - 1);
            str2 = this.eie.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aHb() {
        if (this.eie != null && this.eie.length() > 0) {
            this.eie.delete(0, this.eie.length());
        }
        if (this.eid != null) {
            this.eid.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d nW;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (nW = e.nW(chatMessage.getContent())) != null && !TextUtils.isEmpty(nW.taskId) && this.eid.add(nW.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", nW.dWb, "task_id", nW.taskId);
            }
        }
    }

    public void nR(String str) {
        if (str != null && str.length() > 0) {
            this.eie.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
