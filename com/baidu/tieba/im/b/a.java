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
    private static a iKL = new a();
    private HashSet<String> iKM = new HashSet<>();
    private StringBuilder iKN = new StringBuilder();

    private a() {
    }

    public static a cpD() {
        return iKL;
    }

    public void cpE() {
        String str;
        String str2 = null;
        if (this.iKM != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.iKM.iterator();
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
                    if (this.iKN != null && this.iKN.length() > 0) {
                        this.iKN.deleteCharAt(this.iKN.length() - 1);
                        str2 = this.iKN.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.iKN != null) {
            this.iKN.deleteCharAt(this.iKN.length() - 1);
            str2 = this.iKN.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cpF() {
        if (this.iKN != null && this.iKN.length() > 0) {
            this.iKN.delete(0, this.iKN.length());
        }
        if (this.iKM != null) {
            this.iKM.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d GW;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (GW = e.GW(chatMessage.getContent())) != null && !TextUtils.isEmpty(GW.taskId) && this.iKM.add(GW.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", GW.iyK, "task_id", GW.taskId);
            }
        }
    }

    public void GR(String str) {
        if (str != null && str.length() > 0) {
            this.iKN.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
