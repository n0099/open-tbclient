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
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class a {
    private static a eCb = new a();
    private HashSet<String> eCc = new HashSet<>();
    private StringBuilder eCd = new StringBuilder();

    private a() {
    }

    public static a aNv() {
        return eCb;
    }

    public void aNw() {
        String str;
        String str2 = null;
        if (this.eCc != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eCc.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && next.length() > 0) {
                    sb.append(next).append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                if (sb.length() > 0) {
                    str = sb.toString();
                    if (this.eCd != null && this.eCd.length() > 0) {
                        this.eCd.deleteCharAt(this.eCd.length() - 1);
                        str2 = this.eCd.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eCd != null) {
            this.eCd.deleteCharAt(this.eCd.length() - 1);
            str2 = this.eCd.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aNx() {
        if (this.eCd != null && this.eCd.length() > 0) {
            this.eCd.delete(0, this.eCd.length());
        }
        if (this.eCc != null) {
            this.eCc.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d oS;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (oS = e.oS(chatMessage.getContent())) != null && !TextUtils.isEmpty(oS.taskId) && this.eCc.add(oS.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", oS.eqa, "task_id", oS.taskId);
            }
        }
    }

    public void oN(String str) {
        if (str != null && str.length() > 0) {
            this.eCd.append(str).append(",");
        }
    }
}
