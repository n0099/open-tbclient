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
    private static a fcO = new a();
    private HashSet<String> fcP = new HashSet<>();
    private StringBuilder fcQ = new StringBuilder();

    private a() {
    }

    public static a aVA() {
        return fcO;
    }

    public void aVB() {
        String str;
        String str2 = null;
        if (this.fcP != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.fcP.iterator();
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
                    if (this.fcQ != null && this.fcQ.length() > 0) {
                        this.fcQ.deleteCharAt(this.fcQ.length() - 1);
                        str2 = this.fcQ.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.fcQ != null) {
            this.fcQ.deleteCharAt(this.fcQ.length() - 1);
            str2 = this.fcQ.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aVC() {
        if (this.fcQ != null && this.fcQ.length() > 0) {
            this.fcQ.delete(0, this.fcQ.length());
        }
        if (this.fcP != null) {
            this.fcP.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d qV;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (qV = e.qV(chatMessage.getContent())) != null && !TextUtils.isEmpty(qV.taskId) && this.fcP.add(qV.taskId)) {
                TiebaStatic.eventStat(context, "message_open", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qV.eQU, "task_id", qV.taskId);
            }
        }
    }

    public void qQ(String str) {
        if (str != null && str.length() > 0) {
            this.fcQ.append(str).append(",");
        }
    }
}
