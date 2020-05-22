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
    private static a iJY = new a();
    private HashSet<String> iJZ = new HashSet<>();
    private StringBuilder iKa = new StringBuilder();

    private a() {
    }

    public static a cpu() {
        return iJY;
    }

    public void cpv() {
        String str;
        String str2 = null;
        if (this.iJZ != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.iJZ.iterator();
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
                    if (this.iKa != null && this.iKa.length() > 0) {
                        this.iKa.deleteCharAt(this.iKa.length() - 1);
                        str2 = this.iKa.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.iKa != null) {
            this.iKa.deleteCharAt(this.iKa.length() - 1);
            str2 = this.iKa.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cpw() {
        if (this.iKa != null && this.iKa.length() > 0) {
            this.iKa.delete(0, this.iKa.length());
        }
        if (this.iJZ != null) {
            this.iJZ.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d GW;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (GW = e.GW(chatMessage.getContent())) != null && !TextUtils.isEmpty(GW.taskId) && this.iJZ.add(GW.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", GW.ixX, "task_id", GW.taskId);
            }
        }
    }

    public void GR(String str) {
        if (str != null && str.length() > 0) {
            this.iKa.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
