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
    private static a eCf = new a();
    private HashSet<String> eCg = new HashSet<>();
    private StringBuilder eCh = new StringBuilder();

    private a() {
    }

    public static a aNy() {
        return eCf;
    }

    public void aNz() {
        String str;
        String str2 = null;
        if (this.eCg != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eCg.iterator();
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
                    if (this.eCh != null && this.eCh.length() > 0) {
                        this.eCh.deleteCharAt(this.eCh.length() - 1);
                        str2 = this.eCh.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eCh != null) {
            this.eCh.deleteCharAt(this.eCh.length() - 1);
            str2 = this.eCh.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aNA() {
        if (this.eCh != null && this.eCh.length() > 0) {
            this.eCh.delete(0, this.eCh.length());
        }
        if (this.eCg != null) {
            this.eCg.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d oQ;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (oQ = e.oQ(chatMessage.getContent())) != null && !TextUtils.isEmpty(oQ.taskId) && this.eCg.add(oQ.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", oQ.eqe, "task_id", oQ.taskId);
            }
        }
    }

    public void oL(String str) {
        if (str != null && str.length() > 0) {
            this.eCh.append(str).append(",");
        }
    }
}
