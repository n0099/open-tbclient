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
    private static a gQT = new a();
    private HashSet<String> gQU = new HashSet<>();
    private StringBuilder gQV = new StringBuilder();

    private a() {
    }

    public static a bEi() {
        return gQT;
    }

    public void bEj() {
        String str;
        String str2 = null;
        if (this.gQU != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gQU.iterator();
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
                    if (this.gQV != null && this.gQV.length() > 0) {
                        this.gQV.deleteCharAt(this.gQV.length() - 1);
                        str2 = this.gQV.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gQV != null) {
            this.gQV.deleteCharAt(this.gQV.length() - 1);
            str2 = this.gQV.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bEk() {
        if (this.gQV != null && this.gQV.length() > 0) {
            this.gQV.delete(0, this.gQV.length());
        }
        if (this.gQU != null) {
            this.gQU.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d ys;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (ys = e.ys(chatMessage.getContent())) != null && !TextUtils.isEmpty(ys.taskId) && this.gQU.add(ys.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", ys.gET, "task_id", ys.taskId);
            }
        }
    }

    public void yn(String str) {
        if (str != null && str.length() > 0) {
            this.gQV.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
