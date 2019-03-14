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
    private static a gsT = new a();
    private HashSet<String> gsU = new HashSet<>();
    private StringBuilder gsV = new StringBuilder();

    private a() {
    }

    public static a bwf() {
        return gsT;
    }

    public void bwg() {
        String str;
        String str2 = null;
        if (this.gsU != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.gsU.iterator();
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
                    if (this.gsV != null && this.gsV.length() > 0) {
                        this.gsV.deleteCharAt(this.gsV.length() - 1);
                        str2 = this.gsV.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.gsV != null) {
            this.gsV.deleteCharAt(this.gsV.length() - 1);
            str2 = this.gsV.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bwh() {
        if (this.gsV != null && this.gsV.length() > 0) {
            this.gsV.delete(0, this.gsV.length());
        }
        if (this.gsU != null) {
            this.gsU.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d xz;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (xz = e.xz(chatMessage.getContent())) != null && !TextUtils.isEmpty(xz.taskId) && this.gsU.add(xz.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", xz.ggX, "task_id", xz.taskId);
            }
        }
    }

    public void xu(String str) {
        if (str != null && str.length() > 0) {
            this.gsV.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
