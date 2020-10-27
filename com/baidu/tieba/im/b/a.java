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
    private static a kjn = new a();
    private HashSet<String> kjo = new HashSet<>();
    private StringBuilder kjp = new StringBuilder();

    private a() {
    }

    public static a cSI() {
        return kjn;
    }

    public void cSJ() {
        String str;
        String str2 = null;
        if (this.kjo != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kjo.iterator();
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
                    if (this.kjp != null && this.kjp.length() > 0) {
                        this.kjp.deleteCharAt(this.kjp.length() - 1);
                        str2 = this.kjp.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kjp != null) {
            this.kjp.deleteCharAt(this.kjp.length() - 1);
            str2 = this.kjp.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cSK() {
        if (this.kjp != null && this.kjp.length() > 0) {
            this.kjp.delete(0, this.kjp.length());
        }
        if (this.kjo != null) {
            this.kjo.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d MV;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (MV = e.MV(chatMessage.getContent())) != null && !TextUtils.isEmpty(MV.taskId) && this.kjo.add(MV.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", MV.jVZ, "task_id", MV.taskId);
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

    public void MQ(String str) {
        if (str != null && str.length() > 0) {
            this.kjp.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
