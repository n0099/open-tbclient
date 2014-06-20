package com.baidu.tieba.forumdetail;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ar;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ ItemHotThreadView a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ItemHotThreadView itemHotThreadView, String str) {
        this.a = itemHotThreadView;
        this.b = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        context = this.a.a;
        TiebaStatic.eventStat(context, "detail_hot_thread", "click", 1, new Object[0]);
        MessageManager messageManager = MessageManager.getInstance();
        context2 = this.a.a;
        messageManager.sendMessage(new CustomMessage(2006001, new ar(context2).a(this.b, "", "")));
    }
}
