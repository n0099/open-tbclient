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
/* loaded from: classes3.dex */
public class a {
    private static a gST = new a();
    private HashSet<String> gSU = new HashSet<>();
    private StringBuilder gSV = new StringBuilder();

    private a() {
    }

    public static a bHx() {
        return gST;
    }

    public void bHy() {
        String str;
        String str2 = null;
        if (this.gSU != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gSU.iterator();
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
                    if (this.gSV != null && this.gSV.length() > 0) {
                        this.gSV.deleteCharAt(this.gSV.length() - 1);
                        str2 = this.gSV.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gSV != null) {
            this.gSV.deleteCharAt(this.gSV.length() - 1);
            str2 = this.gSV.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bHz() {
        if (this.gSV != null && this.gSV.length() > 0) {
            this.gSV.delete(0, this.gSV.length());
        }
        if (this.gSU != null) {
            this.gSU.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Aa;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Aa = e.Aa(chatMessage.getContent())) != null && !TextUtils.isEmpty(Aa.taskId) && this.gSU.add(Aa.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Aa.gGV, "task_id", Aa.taskId);
            }
        }
    }

    public void zV(String str) {
        if (str != null && str.length() > 0) {
            this.gSV.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
