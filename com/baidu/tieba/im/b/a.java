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
    private static a gJV = new a();
    private HashSet<String> gJW = new HashSet<>();
    private StringBuilder gJX = new StringBuilder();

    private a() {
    }

    public static a bDN() {
        return gJV;
    }

    public void bDO() {
        String str;
        String str2 = null;
        if (this.gJW != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gJW.iterator();
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
                    if (this.gJX != null && this.gJX.length() > 0) {
                        this.gJX.deleteCharAt(this.gJX.length() - 1);
                        str2 = this.gJX.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gJX != null) {
            this.gJX.deleteCharAt(this.gJX.length() - 1);
            str2 = this.gJX.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bDP() {
        if (this.gJX != null && this.gJX.length() > 0) {
            this.gJX.delete(0, this.gJX.length());
        }
        if (this.gJW != null) {
            this.gJW.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d yN;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (yN = e.yN(chatMessage.getContent())) != null && !TextUtils.isEmpty(yN.taskId) && this.gJW.add(yN.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", yN.gxY, "task_id", yN.taskId);
            }
        }
    }

    public void yI(String str) {
        if (str != null && str.length() > 0) {
            this.gJX.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
