package com.baidu.tieba.im.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
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
    private static a eSu = new a();
    private HashSet<String> eSv = new HashSet<>();
    private StringBuilder eSw = new StringBuilder();

    private a() {
    }

    public static a aSv() {
        return eSu;
    }

    public void aSw() {
        String str;
        String str2 = null;
        if (this.eSv != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eSv.iterator();
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
                    if (this.eSw != null && this.eSw.length() > 0) {
                        this.eSw.deleteCharAt(this.eSw.length() - 1);
                        str2 = this.eSw.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eSw != null) {
            this.eSw.deleteCharAt(this.eSw.length() - 1);
            str2 = this.eSw.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aSx() {
        if (this.eSw != null && this.eSw.length() > 0) {
            this.eSw.delete(0, this.eSw.length());
        }
        if (this.eSv != null) {
            this.eSv.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d qa;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (qa = e.qa(chatMessage.getContent())) != null && !TextUtils.isEmpty(qa.taskId) && this.eSv.add(qa.taskId)) {
                TiebaStatic.eventStat(context, "message_open", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qa.eGB, "task_id", qa.taskId);
            }
        }
    }

    public void pV(String str) {
        if (str != null && str.length() > 0) {
            this.eSw.append(str).append(",");
        }
    }
}
