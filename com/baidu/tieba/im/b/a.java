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
    private static a fcN = new a();
    private HashSet<String> fcO = new HashSet<>();
    private StringBuilder fcP = new StringBuilder();

    private a() {
    }

    public static a aVA() {
        return fcN;
    }

    public void aVB() {
        String str;
        String str2 = null;
        if (this.fcO != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.fcO.iterator();
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
                    if (this.fcP != null && this.fcP.length() > 0) {
                        this.fcP.deleteCharAt(this.fcP.length() - 1);
                        str2 = this.fcP.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.fcP != null) {
            this.fcP.deleteCharAt(this.fcP.length() - 1);
            str2 = this.fcP.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aVC() {
        if (this.fcP != null && this.fcP.length() > 0) {
            this.fcP.delete(0, this.fcP.length());
        }
        if (this.fcO != null) {
            this.fcO.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d qV;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (qV = e.qV(chatMessage.getContent())) != null && !TextUtils.isEmpty(qV.taskId) && this.fcO.add(qV.taskId)) {
                TiebaStatic.eventStat(context, "message_open", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", qV.eQT, "task_id", qV.taskId);
            }
        }
    }

    public void qQ(String str) {
        if (str != null && str.length() > 0) {
            this.fcP.append(str).append(",");
        }
    }
}
