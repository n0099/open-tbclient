package com.baidu.tieba.im.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.im.data.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.util.c;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a {
    private static a kMA = new a();
    private HashSet<String> kMB = new HashSet<>();
    private StringBuilder kMC = new StringBuilder();

    private a() {
    }

    public static a cYd() {
        return kMA;
    }

    public void cYe() {
        String str;
        String str2 = null;
        if (this.kMB != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kMB.iterator();
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
                    if (this.kMC != null && this.kMC.length() > 0) {
                        this.kMC.deleteCharAt(this.kMC.length() - 1);
                        str2 = this.kMC.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kMC != null) {
            this.kMC.deleteCharAt(this.kMC.length() - 1);
            str2 = this.kMC.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cYf() {
        if (this.kMC != null && this.kMC.length() > 0) {
            this.kMC.delete(0, this.kMC.length());
        }
        if (this.kMB != null) {
            this.kMB.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Nj;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Nj = c.Nj(chatMessage.getContent())) != null && !TextUtils.isEmpty(Nj.taskId) && this.kMB.add(Nj.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Nj.kEQ, "task_id", Nj.taskId);
            }
        }
    }

    public void b(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            ar arVar = new ar("c13989");
            arVar.v(Constants.EXTRA_SERVICE, chatMessage.getStatisticsServiceId());
            arVar.v("task_id", chatMessage.getStatTaskId());
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    public void Nf(String str) {
        if (str != null && str.length() > 0) {
            this.kMC.append(str).append(",");
        }
    }
}
