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
/* loaded from: classes3.dex */
public class a {
    private static a ejg = new a();
    private HashSet<String> ejh = new HashSet<>();
    private StringBuilder eji = new StringBuilder();

    private a() {
    }

    public static a aGX() {
        return ejg;
    }

    public void aGY() {
        String str;
        String str2 = null;
        if (this.ejh != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.ejh.iterator();
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
                    if (this.eji != null && this.eji.length() > 0) {
                        this.eji.deleteCharAt(this.eji.length() - 1);
                        str2 = this.eji.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.eji != null) {
            this.eji.deleteCharAt(this.eji.length() - 1);
            str2 = this.eji.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void aGZ() {
        if (this.eji != null && this.eji.length() > 0) {
            this.eji.delete(0, this.eji.length());
        }
        if (this.ejh != null) {
            this.ejh.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d nZ;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (nZ = e.nZ(chatMessage.getContent())) != null && !TextUtils.isEmpty(nZ.taskId) && this.ejh.add(nZ.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", nZ.dXf, "task_id", nZ.taskId);
            }
        }
    }

    public void nU(String str) {
        if (str != null && str.length() > 0) {
            this.eji.append(str).append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
    }
}
