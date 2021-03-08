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
/* loaded from: classes7.dex */
public class a {
    private static a kOC = new a();
    private HashSet<String> kOD = new HashSet<>();
    private StringBuilder kOE = new StringBuilder();

    private a() {
    }

    public static a cYk() {
        return kOC;
    }

    public void cYl() {
        String str;
        String str2 = null;
        if (this.kOD != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kOD.iterator();
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
                    if (this.kOE != null && this.kOE.length() > 0) {
                        this.kOE.deleteCharAt(this.kOE.length() - 1);
                        str2 = this.kOE.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kOE != null) {
            this.kOE.deleteCharAt(this.kOE.length() - 1);
            str2 = this.kOE.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void cYm() {
        if (this.kOE != null && this.kOE.length() > 0) {
            this.kOE.delete(0, this.kOE.length());
        }
        if (this.kOD != null) {
            this.kOD.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d Np;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (Np = c.Np(chatMessage.getContent())) != null && !TextUtils.isEmpty(Np.taskId) && this.kOD.add(Np.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", Np.kGS, "task_id", Np.taskId);
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

    public void Nl(String str) {
        if (str != null && str.length() > 0) {
            this.kOE.append(str).append(",");
        }
    }
}
