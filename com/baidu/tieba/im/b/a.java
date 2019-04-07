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
    private static a gsG = new a();
    private HashSet<String> gsH = new HashSet<>();
    private StringBuilder gsI = new StringBuilder();

    private a() {
    }

    public static a bwc() {
        return gsG;
    }

    public void bwd() {
        String str;
        String str2 = null;
        if (this.gsH != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gsH.iterator();
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
                    if (this.gsI != null && this.gsI.length() > 0) {
                        this.gsI.deleteCharAt(this.gsI.length() - 1);
                        str2 = this.gsI.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gsI != null) {
            this.gsI.deleteCharAt(this.gsI.length() - 1);
            str2 = this.gsI.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bwe() {
        if (this.gsI != null && this.gsI.length() > 0) {
            this.gsI.delete(0, this.gsI.length());
        }
        if (this.gsH != null) {
            this.gsH.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d xy;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (xy = e.xy(chatMessage.getContent())) != null && !TextUtils.isEmpty(xy.taskId) && this.gsH.add(xy.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", xy.ggL, "task_id", xy.taskId);
            }
        }
    }

    public void xt(String str) {
        if (str != null && str.length() > 0) {
            this.gsI.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
