package com.baidu.tieba.im.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.im.data.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.util.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class a {
    private static a kpj = new a();
    private HashSet<String> kpk = new HashSet<>();
    private StringBuilder kpl = new StringBuilder();

    private a() {
    }

    public static a cVj() {
        return kpj;
    }

    public void cVk() {
        String str;
        String str2 = null;
        if (this.kpk != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kpk.iterator();
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
                    if (this.kpl != null && this.kpl.length() > 0) {
                        this.kpl.deleteCharAt(this.kpl.length() - 1);
                        str2 = this.kpl.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kpl != null) {
            this.kpl.deleteCharAt(this.kpl.length() - 1);
            str2 = this.kpl.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cVl() {
        if (this.kpl != null && this.kpl.length() > 0) {
            this.kpl.delete(0, this.kpl.length());
        }
        if (this.kpk != null) {
            this.kpk.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Nm;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Nm = e.Nm(chatMessage.getContent())) != null && !TextUtils.isEmpty(Nm.taskId) && this.kpk.add(Nm.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Nm.kbW, "task_id", Nm.taskId);
            }
        }
    }

    public void b(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            aq aqVar = new aq("c13989");
            aqVar.w(com.baidu.android.imsdk.internal.Constants.EXTRA_SERVICE, chatMessage.getStatisticsServiceId());
            aqVar.w("task_id", chatMessage.getStatTaskId());
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    public void Nh(String str) {
        if (str != null && str.length() > 0) {
            this.kpl.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
