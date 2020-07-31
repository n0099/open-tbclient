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
    private static a jkh = new a();
    private HashSet<String> jki = new HashSet<>();
    private StringBuilder jkj = new StringBuilder();

    private a() {
    }

    public static a cxv() {
        return jkh;
    }

    public void cxw() {
        String str;
        String str2 = null;
        if (this.jki != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.jki.iterator();
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
                    if (this.jkj != null && this.jkj.length() > 0) {
                        this.jkj.deleteCharAt(this.jkj.length() - 1);
                        str2 = this.jkj.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.jkj != null) {
            this.jkj.deleteCharAt(this.jkj.length() - 1);
            str2 = this.jkj.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cxx() {
        if (this.jkj != null && this.jkj.length() > 0) {
            this.jkj.delete(0, this.jkj.length());
        }
        if (this.jki != null) {
            this.jki.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d In;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (In = e.In(chatMessage.getContent())) != null && !TextUtils.isEmpty(In.taskId) && this.jki.add(In.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", In.iWS, "task_id", In.taskId);
            }
        }
    }

    public void Ii(String str) {
        if (str != null && str.length() > 0) {
            this.jkj.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
