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
    private static a hLw = new a();
    private HashSet<String> hLx = new HashSet<>();
    private StringBuilder hLy = new StringBuilder();

    private a() {
    }

    public static a bYx() {
        return hLw;
    }

    public void bYy() {
        String str;
        String str2 = null;
        if (this.hLx != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.hLx.iterator();
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
                    if (this.hLy != null && this.hLy.length() > 0) {
                        this.hLy.deleteCharAt(this.hLy.length() - 1);
                        str2 = this.hLy.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.hLy != null) {
            this.hLy.deleteCharAt(this.hLy.length() - 1);
            str2 = this.hLy.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bYz() {
        if (this.hLy != null && this.hLy.length() > 0) {
            this.hLy.delete(0, this.hLy.length());
        }
        if (this.hLx != null) {
            this.hLx.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d DC;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (DC = e.DC(chatMessage.getContent())) != null && !TextUtils.isEmpty(DC.taskId) && this.hLx.add(DC.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", DC.hzv, "task_id", DC.taskId);
            }
        }
    }

    public void Dx(String str) {
        if (str != null && str.length() > 0) {
            this.hLy.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
