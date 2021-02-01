package com.baidu.tieba.im.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.im.data.d;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.AddMsgRecordModel;
import com.baidu.tieba.im.util.c;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class a {
    private static a kMm = new a();
    private HashSet<String> kMn = new HashSet<>();
    private StringBuilder kMo = new StringBuilder();

    private a() {
    }

    public static a cXW() {
        return kMm;
    }

    public void cXX() {
        String str;
        String str2 = null;
        if (this.kMn != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kMn.iterator();
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
                    if (this.kMo != null && this.kMo.length() > 0) {
                        this.kMo.deleteCharAt(this.kMo.length() - 1);
                        str2 = this.kMo.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kMo != null) {
            this.kMo.deleteCharAt(this.kMo.length() - 1);
            str2 = this.kMo.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cXY() {
        if (this.kMo != null && this.kMo.length() > 0) {
            this.kMo.delete(0, this.kMo.length());
        }
        if (this.kMn != null) {
            this.kMn.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Ni;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Ni = c.Ni(chatMessage.getContent())) != null && !TextUtils.isEmpty(Ni.taskId) && this.kMn.add(Ni.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Ni.kEC, "task_id", Ni.taskId);
            }
        }
    }

    public void b(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            ar arVar = new ar("c13989");
            arVar.v(Constants.EXTRA_SERVICE, chatMessage.getStatisticsServiceId());
            arVar.v("task_id", chatMessage.getStatTaskId());
            arVar.v("uid", TbadkApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    public void Ne(String str) {
        if (str != null && str.length() > 0) {
            this.kMo.append(str).append(",");
        }
    }
}
