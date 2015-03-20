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
    private static a bni = new a();
    private HashSet<Integer> bnj = new HashSet<>();

    private a() {
    }

    public static a Ts() {
        return bni;
    }

    public void Tt() {
        if (this.bnj != null) {
            this.bnj.clear();
        }
    }

    public void a(ChatMessage chatMessage, int i, Context context) {
        g gU;
        if (chatMessage != null && !StringUtils.isNull(chatMessage.getContent()) && (gU = i.gU(chatMessage.getContent())) != null && this.bnj.add(Integer.valueOf(i))) {
            TiebaStatic.eventStat(context, "message_open", "click", 1, "task_type", gU.bce, "task_id", gU.bcf);
        }
    }
}
