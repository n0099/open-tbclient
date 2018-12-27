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
    private static a fca = new a();
    private HashSet<String> fcb = new HashSet<>();
    private StringBuilder fcc = new StringBuilder();

    private a() {
    }

    public static a aVa() {
        return fca;
    }

    public void aVb() {
        String str;
        String str2 = null;
        if (this.fcb != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.fcb.iterator();
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
                    if (this.fcc != null && this.fcc.length() > 0) {
                        this.fcc.deleteCharAt(this.fcc.length() - 1);
                        str2 = this.fcc.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.fcc != null) {
            this.fcc.deleteCharAt(this.fcc.length() - 1);
            str2 = this.fcc.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aVc() {
        if (this.fcc != null && this.fcc.length() > 0) {
            this.fcc.delete(0, this.fcc.length());
        }
        if (this.fcb != null) {
            this.fcb.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d qF;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (qF = e.qF(chatMessage.getContent())) != null && !TextUtils.isEmpty(qF.taskId) && this.fcb.add(qF.taskId)) {
                TiebaStatic.eventStat(context, "message_open", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qF.eQh, "task_id", qF.taskId);
            }
        }
    }

    public void qA(String str) {
        if (str != null && str.length() > 0) {
            this.fcc.append(str).append(",");
        }
    }
}
