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
/* loaded from: classes8.dex */
public class a {
    private static a kIM = new a();
    private HashSet<String> kIN = new HashSet<>();
    private StringBuilder kIO = new StringBuilder();

    private a() {
    }

    public static a cZP() {
        return kIM;
    }

    public void cZQ() {
        String str;
        String str2 = null;
        if (this.kIN != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kIN.iterator();
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
                    if (this.kIO != null && this.kIO.length() > 0) {
                        this.kIO.deleteCharAt(this.kIO.length() - 1);
                        str2 = this.kIO.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kIO != null) {
            this.kIO.deleteCharAt(this.kIO.length() - 1);
            str2 = this.kIO.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cZR() {
        if (this.kIO != null && this.kIO.length() > 0) {
            this.kIO.delete(0, this.kIO.length());
        }
        if (this.kIN != null) {
            this.kIN.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d NC;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (NC = c.NC(chatMessage.getContent())) != null && !TextUtils.isEmpty(NC.taskId) && this.kIN.add(NC.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", NC.kBb, "task_id", NC.taskId);
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

    public void Ny(String str) {
        if (str != null && str.length() > 0) {
            this.kIO.append(str).append(",");
        }
    }
}
