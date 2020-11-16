package com.baidu.tieba.im.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.im.data.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.util.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes25.dex */
public class a {
    private static a kpT = new a();
    private HashSet<String> kpU = new HashSet<>();
    private StringBuilder kpV = new StringBuilder();

    private a() {
    }

    public static a cUP() {
        return kpT;
    }

    public void cUQ() {
        String str;
        String str2 = null;
        if (this.kpU != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kpU.iterator();
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
                    if (this.kpV != null && this.kpV.length() > 0) {
                        this.kpV.deleteCharAt(this.kpV.length() - 1);
                        str2 = this.kpV.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kpV != null) {
            this.kpV.deleteCharAt(this.kpV.length() - 1);
            str2 = this.kpV.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cUR() {
        if (this.kpV != null && this.kpV.length() > 0) {
            this.kpV.delete(0, this.kpV.length());
        }
        if (this.kpU != null) {
            this.kpU.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d MN;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (MN = e.MN(chatMessage.getContent())) != null && !TextUtils.isEmpty(MN.taskId) && this.kpU.add(MN.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", MN.kcG, "task_id", MN.taskId);
            }
        }
    }

    public void b(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            ar arVar = new ar("c13989");
            arVar.w(com.baidu.android.imsdk.internal.Constants.EXTRA_SERVICE, chatMessage.getStatisticsServiceId());
            arVar.w("task_id", chatMessage.getStatTaskId());
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    public void MI(String str) {
        if (str != null && str.length() > 0) {
            this.kpV.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
