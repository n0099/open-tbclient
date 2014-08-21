package com.baidu.tieba.im.chat;

import android.content.Context;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ca implements View.OnClickListener {
    final /* synthetic */ bz a;
    private final /* synthetic */ long b;
    private final /* synthetic */ String c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bz bzVar, long j, String str, String str2) {
        this.a = bzVar;
        this.b = j;
        this.c = str;
        this.d = str2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        MessageManager messageManager = MessageManager.getInstance();
        context = this.a.mContext;
        messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.a(context, String.valueOf(this.b), this.c, this.d, "", false, "new_frd")));
    }
}
