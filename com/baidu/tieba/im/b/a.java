package com.baidu.tieba.im.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.im.data.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.util.c;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a {
    private static a kEh = new a();
    private HashSet<String> kEi = new HashSet<>();
    private StringBuilder kEj = new StringBuilder();

    private a() {
    }

    public static a cVY() {
        return kEh;
    }

    public void cVZ() {
        String str;
        String str2 = null;
        if (this.kEi != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kEi.iterator();
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
                    if (this.kEj != null && this.kEj.length() > 0) {
                        this.kEj.deleteCharAt(this.kEj.length() - 1);
                        str2 = this.kEj.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kEj != null) {
            this.kEj.deleteCharAt(this.kEj.length() - 1);
            str2 = this.kEj.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cWa() {
        if (this.kEj != null && this.kEj.length() > 0) {
            this.kEj.delete(0, this.kEj.length());
        }
        if (this.kEi != null) {
            this.kEi.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Mu;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Mu = c.Mu(chatMessage.getContent())) != null && !TextUtils.isEmpty(Mu.taskId) && this.kEi.add(Mu.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Mu.kww, "task_id", Mu.taskId);
            }
        }
    }

    public void b(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            aq aqVar = new aq("c13989");
            aqVar.w(Constants.EXTRA_SERVICE, chatMessage.getStatisticsServiceId());
            aqVar.w("task_id", chatMessage.getStatTaskId());
            aqVar.w("uid", TbadkApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    public void Mq(String str) {
        if (str != null && str.length() > 0) {
            this.kEj.append(str).append(",");
        }
    }
}
