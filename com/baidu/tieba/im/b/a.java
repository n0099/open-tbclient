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
    private static a eNg = new a();
    private HashSet<String> eNh = new HashSet<>();
    private StringBuilder eNi = new StringBuilder();

    private a() {
    }

    public static a aLY() {
        return eNg;
    }

    public void aLZ() {
        String str;
        String str2 = null;
        if (this.eNh != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eNh.iterator();
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
                    if (this.eNi != null && this.eNi.length() > 0) {
                        this.eNi.deleteCharAt(this.eNi.length() - 1);
                        str2 = this.eNi.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eNi != null) {
            this.eNi.deleteCharAt(this.eNi.length() - 1);
            str2 = this.eNi.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aMa() {
        if (this.eNi != null && this.eNi.length() > 0) {
            this.eNi.delete(0, this.eNi.length());
        }
        if (this.eNh != null) {
            this.eNh.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d nS;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (nS = e.nS(chatMessage.getContent())) != null && !TextUtils.isEmpty(nS.taskId) && this.eNh.add(nS.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", nS.eBh, "task_id", nS.taskId);
            }
        }
    }

    public void nN(String str) {
        if (str != null && str.length() > 0) {
            this.eNi.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
