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
    private static a hJI = new a();
    private HashSet<String> hJJ = new HashSet<>();
    private StringBuilder hJK = new StringBuilder();

    private a() {
    }

    public static a bYc() {
        return hJI;
    }

    public void bYd() {
        String str;
        String str2 = null;
        if (this.hJJ != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.hJJ.iterator();
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
                    if (this.hJK != null && this.hJK.length() > 0) {
                        this.hJK.deleteCharAt(this.hJK.length() - 1);
                        str2 = this.hJK.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.hJK != null) {
            this.hJK.deleteCharAt(this.hJK.length() - 1);
            str2 = this.hJK.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bYe() {
        if (this.hJK != null && this.hJK.length() > 0) {
            this.hJK.delete(0, this.hJK.length());
        }
        if (this.hJJ != null) {
            this.hJJ.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d DB;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (DB = e.DB(chatMessage.getContent())) != null && !TextUtils.isEmpty(DB.taskId) && this.hJJ.add(DB.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", DB.hxH, "task_id", DB.taskId);
            }
        }
    }

    public void Dw(String str) {
        if (str != null && str.length() > 0) {
            this.hJK.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
