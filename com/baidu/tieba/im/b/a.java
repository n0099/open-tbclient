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
/* loaded from: classes11.dex */
public class a {
    private static a hHJ = new a();
    private HashSet<String> hHK = new HashSet<>();
    private StringBuilder hHL = new StringBuilder();

    private a() {
    }

    public static a bWB() {
        return hHJ;
    }

    public void bWC() {
        String str;
        String str2 = null;
        if (this.hHK != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.hHK.iterator();
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
                    if (this.hHL != null && this.hHL.length() > 0) {
                        this.hHL.deleteCharAt(this.hHL.length() - 1);
                        str2 = this.hHL.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.hHL != null) {
            this.hHL.deleteCharAt(this.hHL.length() - 1);
            str2 = this.hHL.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void bWD() {
        if (this.hHL != null && this.hHL.length() > 0) {
            this.hHL.delete(0, this.hHL.length());
        }
        if (this.hHK != null) {
            this.hHK.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Dl;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Dl = e.Dl(chatMessage.getContent())) != null && !TextUtils.isEmpty(Dl.taskId) && this.hHK.add(Dl.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Dl.hvI, "task_id", Dl.taskId);
            }
        }
    }

    public void Dg(String str) {
        if (str != null && str.length() > 0) {
            this.hHL.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
