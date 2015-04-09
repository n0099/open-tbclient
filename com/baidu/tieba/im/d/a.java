package com.baidu.tieba.im.d;

import android.content.Context;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.data.g;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.i;
import java.util.HashSet;
/* loaded from: classes.dex */
public class a {
    private static a bny = new a();
    private HashSet<Integer> bnz = new HashSet<>();

    private a() {
    }

    public static a TF() {
        return bny;
    }

    public void TG() {
        if (this.bnz != null) {
            this.bnz.clear();
        }
    }

    public void a(ChatMessage chatMessage, int i, Context context) {
        g gX;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (gX = i.gX(chatMessage.getContent())) != null && this.bnz.add(Integer.valueOf(i))) {
            TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", gX.bcu, "task_id", gX.bcv);
        }
    }
}
