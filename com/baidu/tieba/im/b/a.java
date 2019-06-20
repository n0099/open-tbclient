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
    private static a gJX = new a();
    private HashSet<String> gJY = new HashSet<>();
    private StringBuilder gJZ = new StringBuilder();

    private a() {
    }

    public static a bDO() {
        return gJX;
    }

    public void bDP() {
        String str;
        String str2 = null;
        if (this.gJY != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gJY.iterator();
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
                    if (this.gJZ != null && this.gJZ.length() > 0) {
                        this.gJZ.deleteCharAt(this.gJZ.length() - 1);
                        str2 = this.gJZ.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gJZ != null) {
            this.gJZ.deleteCharAt(this.gJZ.length() - 1);
            str2 = this.gJZ.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bDQ() {
        if (this.gJZ != null && this.gJZ.length() > 0) {
            this.gJZ.delete(0, this.gJZ.length());
        }
        if (this.gJY != null) {
            this.gJY.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d yP;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (yP = e.yP(chatMessage.getContent())) != null && !TextUtils.isEmpty(yP.taskId) && this.gJY.add(yP.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", yP.gya, "task_id", yP.taskId);
            }
        }
    }

    public void yK(String str) {
        if (str != null && str.length() > 0) {
            this.gJZ.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
