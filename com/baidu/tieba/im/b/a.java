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
    private static a ivm = new a();
    private HashSet<String> ivn = new HashSet<>();
    private StringBuilder ivo = new StringBuilder();

    private a() {
    }

    public static a ciY() {
        return ivm;
    }

    public void ciZ() {
        String str;
        String str2 = null;
        if (this.ivn != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.ivn.iterator();
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
                    if (this.ivo != null && this.ivo.length() > 0) {
                        this.ivo.deleteCharAt(this.ivo.length() - 1);
                        str2 = this.ivo.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.ivo != null) {
            this.ivo.deleteCharAt(this.ivo.length() - 1);
            str2 = this.ivo.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cja() {
        if (this.ivo != null && this.ivo.length() > 0) {
            this.ivo.delete(0, this.ivo.length());
        }
        if (this.ivn != null) {
            this.ivn.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Fk;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Fk = e.Fk(chatMessage.getContent())) != null && !TextUtils.isEmpty(Fk.taskId) && this.ivn.add(Fk.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Fk.iji, "task_id", Fk.taskId);
            }
        }
    }

    public void Ff(String str) {
        if (str != null && str.length() > 0) {
            this.ivo.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
