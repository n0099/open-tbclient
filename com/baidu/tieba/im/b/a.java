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
/* loaded from: classes13.dex */
public class a {
    private static a jbN = new a();
    private HashSet<String> jbO = new HashSet<>();
    private StringBuilder jbP = new StringBuilder();

    private a() {
    }

    public static a cts() {
        return jbN;
    }

    public void ctt() {
        String str;
        String str2 = null;
        if (this.jbO != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.jbO.iterator();
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
                    if (this.jbP != null && this.jbP.length() > 0) {
                        this.jbP.deleteCharAt(this.jbP.length() - 1);
                        str2 = this.jbP.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.jbP != null) {
            this.jbP.deleteCharAt(this.jbP.length() - 1);
            str2 = this.jbP.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void ctu() {
        if (this.jbP != null && this.jbP.length() > 0) {
            this.jbP.delete(0, this.jbP.length());
        }
        if (this.jbO != null) {
            this.jbO.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Hy;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Hy = e.Hy(chatMessage.getContent())) != null && !TextUtils.isEmpty(Hy.taskId) && this.jbO.add(Hy.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Hy.iPP, "task_id", Hy.taskId);
            }
        }
    }

    public void Ht(String str) {
        if (str != null && str.length() > 0) {
            this.jbP.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
