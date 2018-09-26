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
    private static a eJs = new a();
    private HashSet<String> eJt = new HashSet<>();
    private StringBuilder eJu = new StringBuilder();

    private a() {
    }

    public static a aPK() {
        return eJs;
    }

    public void aPL() {
        String str;
        String str2 = null;
        if (this.eJt != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eJt.iterator();
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
                    if (this.eJu != null && this.eJu.length() > 0) {
                        this.eJu.deleteCharAt(this.eJu.length() - 1);
                        str2 = this.eJu.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eJu != null) {
            this.eJu.deleteCharAt(this.eJu.length() - 1);
            str2 = this.eJu.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aPM() {
        if (this.eJu != null && this.eJu.length() > 0) {
            this.eJu.delete(0, this.eJu.length());
        }
        if (this.eJt != null) {
            this.eJt.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d px;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (px = e.px(chatMessage.getContent())) != null && !TextUtils.isEmpty(px.taskId) && this.eJt.add(px.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", px.exu, "task_id", px.taskId);
            }
        }
    }

    public void ps(String str) {
        if (str != null && str.length() > 0) {
            this.eJu.append(str).append(",");
        }
    }
}
