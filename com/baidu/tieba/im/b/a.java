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
    private static a eNs = new a();
    private HashSet<String> eNt = new HashSet<>();
    private StringBuilder eNu = new StringBuilder();

    private a() {
    }

    public static a aLZ() {
        return eNs;
    }

    public void aMa() {
        String str;
        String str2 = null;
        if (this.eNt != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eNt.iterator();
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
                    if (this.eNu != null && this.eNu.length() > 0) {
                        this.eNu.deleteCharAt(this.eNu.length() - 1);
                        str2 = this.eNu.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eNu != null) {
            this.eNu.deleteCharAt(this.eNu.length() - 1);
            str2 = this.eNu.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aMb() {
        if (this.eNu != null && this.eNu.length() > 0) {
            this.eNu.delete(0, this.eNu.length());
        }
        if (this.eNt != null) {
            this.eNt.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d nS;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (nS = e.nS(chatMessage.getContent())) != null && !TextUtils.isEmpty(nS.taskId) && this.eNt.add(nS.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", nS.eBt, "task_id", nS.taskId);
            }
        }
    }

    public void nN(String str) {
        if (str != null && str.length() > 0) {
            this.eNu.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
