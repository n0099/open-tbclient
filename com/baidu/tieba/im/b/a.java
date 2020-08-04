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
    private static a jkj = new a();
    private HashSet<String> jkk = new HashSet<>();
    private StringBuilder jkl = new StringBuilder();

    private a() {
    }

    public static a cxv() {
        return jkj;
    }

    public void cxw() {
        String str;
        String str2 = null;
        if (this.jkk != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.jkk.iterator();
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
                    if (this.jkl != null && this.jkl.length() > 0) {
                        this.jkl.deleteCharAt(this.jkl.length() - 1);
                        str2 = this.jkl.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.jkl != null) {
            this.jkl.deleteCharAt(this.jkl.length() - 1);
            str2 = this.jkl.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cxx() {
        if (this.jkl != null && this.jkl.length() > 0) {
            this.jkl.delete(0, this.jkl.length());
        }
        if (this.jkk != null) {
            this.jkk.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d In;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (In = e.In(chatMessage.getContent())) != null && !TextUtils.isEmpty(In.taskId) && this.jkk.add(In.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", In.iWU, "task_id", In.taskId);
            }
        }
    }

    public void Ii(String str) {
        if (str != null && str.length() > 0) {
            this.jkl.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
