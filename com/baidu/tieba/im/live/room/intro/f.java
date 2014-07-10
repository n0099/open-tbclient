package com.baidu.tieba.im.live.room.intro;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        Context context;
        String str3;
        String str4;
        str = this.a.p;
        if (!TextUtils.isEmpty(str)) {
            str2 = this.a.q;
            if (!TextUtils.isEmpty(str2)) {
                MessageManager messageManager = MessageManager.getInstance();
                context = this.a.mContext;
                str3 = this.a.q;
                str4 = this.a.p;
                messageManager.sendMessage(new CustomMessage(2002003, new bb(context, str3, str4)));
            }
        }
    }
}
