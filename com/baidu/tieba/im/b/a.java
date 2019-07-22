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
    private static a gQh = new a();
    private HashSet<String> gQi = new HashSet<>();
    private StringBuilder gQj = new StringBuilder();

    private a() {
    }

    public static a bGv() {
        return gQh;
    }

    public void bGw() {
        String str;
        String str2 = null;
        if (this.gQi != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gQi.iterator();
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
                    if (this.gQj != null && this.gQj.length() > 0) {
                        this.gQj.deleteCharAt(this.gQj.length() - 1);
                        str2 = this.gQj.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gQj != null) {
            this.gQj.deleteCharAt(this.gQj.length() - 1);
            str2 = this.gQj.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bGx() {
        if (this.gQj != null && this.gQj.length() > 0) {
            this.gQj.delete(0, this.gQj.length());
        }
        if (this.gQi != null) {
            this.gQi.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d zA;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (zA = e.zA(chatMessage.getContent())) != null && !TextUtils.isEmpty(zA.taskId) && this.gQi.add(zA.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", zA.gEl, "task_id", zA.taskId);
            }
        }
    }

    public void zv(String str) {
        if (str != null && str.length() > 0) {
            this.gQj.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
