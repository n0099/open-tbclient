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
/* loaded from: classes20.dex */
public class a {
    private static a jzi = new a();
    private HashSet<String> jzj = new HashSet<>();
    private StringBuilder jzk = new StringBuilder();

    private a() {
    }

    public static a cIm() {
        return jzi;
    }

    public void cIn() {
        String str;
        String str2 = null;
        if (this.jzj != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.jzj.iterator();
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
                    if (this.jzk != null && this.jzk.length() > 0) {
                        this.jzk.deleteCharAt(this.jzk.length() - 1);
                        str2 = this.jzk.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.jzk != null) {
            this.jzk.deleteCharAt(this.jzk.length() - 1);
            str2 = this.jzk.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cIo() {
        if (this.jzk != null && this.jzk.length() > 0) {
            this.jzk.delete(0, this.jzk.length());
        }
        if (this.jzj != null) {
            this.jzj.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Lf;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Lf = e.Lf(chatMessage.getContent())) != null && !TextUtils.isEmpty(Lf.taskId) && this.jzj.add(Lf.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Lf.jlT, "task_id", Lf.taskId);
            }
        }
    }

    public void La(String str) {
        if (str != null && str.length() > 0) {
            this.jzk.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
