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
    private static a gJU = new a();
    private HashSet<String> gJV = new HashSet<>();
    private StringBuilder gJW = new StringBuilder();

    private a() {
    }

    public static a bDK() {
        return gJU;
    }

    public void bDL() {
        String str;
        String str2 = null;
        if (this.gJV != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gJV.iterator();
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
                    if (this.gJW != null && this.gJW.length() > 0) {
                        this.gJW.deleteCharAt(this.gJW.length() - 1);
                        str2 = this.gJW.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gJW != null) {
            this.gJW.deleteCharAt(this.gJW.length() - 1);
            str2 = this.gJW.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bDM() {
        if (this.gJW != null && this.gJW.length() > 0) {
            this.gJW.delete(0, this.gJW.length());
        }
        if (this.gJV != null) {
            this.gJV.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d yN;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (yN = e.yN(chatMessage.getContent())) != null && !TextUtils.isEmpty(yN.taskId) && this.gJV.add(yN.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", yN.gxX, "task_id", yN.taskId);
            }
        }
    }

    public void yI(String str) {
        if (str != null && str.length() > 0) {
            this.gJW.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
