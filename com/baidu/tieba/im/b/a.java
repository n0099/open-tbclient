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
    private static a ivs = new a();
    private HashSet<String> ivt = new HashSet<>();
    private StringBuilder ivu = new StringBuilder();

    private a() {
    }

    public static a ciW() {
        return ivs;
    }

    public void ciX() {
        String str;
        String str2 = null;
        if (this.ivt != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.ivt.iterator();
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
                    if (this.ivu != null && this.ivu.length() > 0) {
                        this.ivu.deleteCharAt(this.ivu.length() - 1);
                        str2 = this.ivu.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.ivu != null) {
            this.ivu.deleteCharAt(this.ivu.length() - 1);
            str2 = this.ivu.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void ciY() {
        if (this.ivu != null && this.ivu.length() > 0) {
            this.ivu.delete(0, this.ivu.length());
        }
        if (this.ivt != null) {
            this.ivt.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Fn;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Fn = e.Fn(chatMessage.getContent())) != null && !TextUtils.isEmpty(Fn.taskId) && this.ivt.add(Fn.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Fn.ijp, "task_id", Fn.taskId);
            }
        }
    }

    public void Fi(String str) {
        if (str != null && str.length() > 0) {
            this.ivu.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
