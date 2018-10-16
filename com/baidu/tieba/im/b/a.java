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
    private static a eRb = new a();
    private HashSet<String> eRc = new HashSet<>();
    private StringBuilder eRd = new StringBuilder();

    private a() {
    }

    public static a aSY() {
        return eRb;
    }

    public void aSZ() {
        String str;
        String str2 = null;
        if (this.eRc != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.eRc.iterator();
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
                    if (this.eRd != null && this.eRd.length() > 0) {
                        this.eRd.deleteCharAt(this.eRd.length() - 1);
                        str2 = this.eRd.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eRd != null) {
            this.eRd.deleteCharAt(this.eRd.length() - 1);
            str2 = this.eRd.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aTa() {
        if (this.eRd != null && this.eRd.length() > 0) {
            this.eRd.delete(0, this.eRd.length());
        }
        if (this.eRc != null) {
            this.eRc.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d pZ;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (pZ = e.pZ(chatMessage.getContent())) != null && !TextUtils.isEmpty(pZ.taskId) && this.eRc.add(pZ.taskId)) {
                TiebaStatic.eventStat(context, "message_open", AiAppsUBCStatistic.TYPE_CLICK, 1, "task_type", pZ.eFh, "task_id", pZ.taskId);
            }
        }
    }

    public void pU(String str) {
        if (str != null && str.length() > 0) {
            this.eRd.append(str).append(",");
        }
    }
}
