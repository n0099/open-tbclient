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
    private static a eZj = new a();
    private HashSet<String> eZk = new HashSet<>();
    private StringBuilder eZl = new StringBuilder();

    private a() {
    }

    public static a aUm() {
        return eZj;
    }

    public void aUn() {
        String str;
        String str2 = null;
        if (this.eZk != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eZk.iterator();
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
                    if (this.eZl != null && this.eZl.length() > 0) {
                        this.eZl.deleteCharAt(this.eZl.length() - 1);
                        str2 = this.eZl.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eZl != null) {
            this.eZl.deleteCharAt(this.eZl.length() - 1);
            str2 = this.eZl.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aUo() {
        if (this.eZl != null && this.eZl.length() > 0) {
            this.eZl.delete(0, this.eZl.length());
        }
        if (this.eZk != null) {
            this.eZk.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d qC;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (qC = e.qC(chatMessage.getContent())) != null && !TextUtils.isEmpty(qC.taskId) && this.eZk.add(qC.taskId)) {
                TiebaStatic.eventStat(context, "message_open", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qC.eNq, "task_id", qC.taskId);
            }
        }
    }

    public void qx(String str) {
        if (str != null && str.length() > 0) {
            this.eZl.append(str).append(",");
        }
    }
}
