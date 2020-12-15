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
import com.baidu.tieba.im.util.e;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes26.dex */
public class a {
    private static a kDr = new a();
    private HashSet<String> kDs = new HashSet<>();
    private StringBuilder kDt = new StringBuilder();

    private a() {
    }

    public static a dac() {
        return kDr;
    }

    public void dad() {
        String str;
        String str2 = null;
        if (this.kDs != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.kDs.iterator();
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
                    if (this.kDt != null && this.kDt.length() > 0) {
                        this.kDt.deleteCharAt(this.kDt.length() - 1);
                        str2 = this.kDt.toString();
                    }
                    new AddMsgRecordModel().reqViewAndClick(str, str2);
                }
            }
        }
        str = null;
        if (this.kDt != null) {
            this.kDt.deleteCharAt(this.kDt.length() - 1);
            str2 = this.kDt.toString();
        }
        new AddMsgRecordModel().reqViewAndClick(str, str2);
    }

    public void dae() {
        if (this.kDt != null && this.kDt.length() > 0) {
            this.kDt.delete(0, this.kDt.length());
        }
        if (this.kDs != null) {
            this.kDs.clear();
        }
    }

    public void a(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        d NV;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null) {
            if ((userInfo.getUserType() == 1 || userInfo.getUserType() == 3) && (NV = e.NV(chatMessage.getContent())) != null && !TextUtils.isEmpty(NV.taskId) && this.kDs.add(NV.taskId)) {
                TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", NV.kqm, "task_id", NV.taskId);
            }
        }
    }

    public void b(ChatMessage chatMessage, Context context) {
        UserData userInfo;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (userInfo = chatMessage.getUserInfo()) != null && userInfo.getUserType() == 4) {
            ar arVar = new ar("c13989");
            arVar.w(Constants.EXTRA_SERVICE, chatMessage.getStatisticsServiceId());
            arVar.w("task_id", chatMessage.getStatTaskId());
            arVar.w("uid", TbadkApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }

    public void NQ(String str) {
        if (str != null && str.length() > 0) {
            this.kDt.append(str).append(",");
        }
    }
}
