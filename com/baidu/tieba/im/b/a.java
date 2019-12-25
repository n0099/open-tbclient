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
/* loaded from: classes10.dex */
public class a {
    private static a hEg = new a();
    private HashSet<String> hEh = new HashSet<>();
    private StringBuilder hEi = new StringBuilder();

    private a() {
    }

    public static a bVs() {
        return hEg;
    }

    public void bVt() {
        String str;
        String str2 = null;
        if (this.hEh != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.hEh.iterator();
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
                    if (this.hEi != null && this.hEi.length() > 0) {
                        this.hEi.deleteCharAt(this.hEi.length() - 1);
                        str2 = this.hEi.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.hEi != null) {
            this.hEi.deleteCharAt(this.hEi.length() - 1);
            str2 = this.hEi.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bVu() {
        if (this.hEi != null && this.hEi.length() > 0) {
            this.hEi.delete(0, this.hEi.length());
        }
        if (this.hEh != null) {
            this.hEh.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Db;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Db = e.Db(chatMessage.getContent())) != null && !TextUtils.isEmpty(Db.taskId) && this.hEh.add(Db.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Db.hsf, "task_id", Db.taskId);
            }
        }
    }

    public void CW(String str) {
        if (str != null && str.length() > 0) {
            this.hEi.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
