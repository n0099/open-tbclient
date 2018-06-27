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
    private static a eyo = new a();
    private HashSet<String> eyp = new HashSet<>();
    private StringBuilder eyq = new StringBuilder();

    private a() {
    }

    public static a aMy() {
        return eyo;
    }

    public void aMz() {
        String str;
        String str2 = null;
        if (this.eyp != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eyp.iterator();
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
                    if (this.eyq != null && this.eyq.length() > 0) {
                        this.eyq.deleteCharAt(this.eyq.length() - 1);
                        str2 = this.eyq.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eyq != null) {
            this.eyq.deleteCharAt(this.eyq.length() - 1);
            str2 = this.eyq.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aMA() {
        if (this.eyq != null && this.eyq.length() > 0) {
            this.eyq.delete(0, this.eyq.length());
        }
        if (this.eyp != null) {
            this.eyp.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d oO;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (oO = e.oO(chatMessage.getContent())) != null && !TextUtils.isEmpty(oO.taskId) && this.eyp.add(oO.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", oO.eml, "task_id", oO.taskId);
            }
        }
    }

    public void oJ(String str) {
        if (str != null && str.length() > 0) {
            this.eyq.append(str).append(",");
        }
    }
}
