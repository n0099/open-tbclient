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
/* loaded from: classes25.dex */
public class a {
    private static a jHQ = new a();
    private HashSet<String> jHR = new HashSet<>();
    private StringBuilder jHS = new StringBuilder();

    private a() {
    }

    public static a cLT() {
        return jHQ;
    }

    public void cLU() {
        String str;
        String str2 = null;
        if (this.jHR != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.jHR.iterator();
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
                    if (this.jHS != null && this.jHS.length() > 0) {
                        this.jHS.deleteCharAt(this.jHS.length() - 1);
                        str2 = this.jHS.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.jHS != null) {
            this.jHS.deleteCharAt(this.jHS.length() - 1);
            str2 = this.jHS.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cLV() {
        if (this.jHS != null && this.jHS.length() > 0) {
            this.jHS.delete(0, this.jHS.length());
        }
        if (this.jHR != null) {
            this.jHR.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d LI;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (LI = e.LI(chatMessage.getContent())) != null && !TextUtils.isEmpty(LI.taskId) && this.jHR.add(LI.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", LI.juD, "task_id", LI.taskId);
            }
        }
    }

    public void b(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            aq aqVar = new aq("c13989");
            aqVar.u(com.baidu.android.imsdk.internal.Constants.EXTRA_SERVICE, chatMessage.getStatisticsServiceId());
            aqVar.u("task_id", chatMessage.getStatTaskId());
            aqVar.u("uid", TbadkApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }

    public void LD(String str) {
        if (str != null && str.length() > 0) {
            this.jHS.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
