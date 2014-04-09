package com.baidu.tieba.im.chat.notify;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.baidu.tbadk.core.b.ag;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements View.OnClickListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar) {
        this.a = bVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Activity activity;
        Activity activity2;
        if (view.getId() == com.baidu.tieba.im.h.chat_head) {
            HeadImageView headImageView = (HeadImageView) view;
            String userId = headImageView.getUserId();
            String userName = headImageView.getUserName();
            String userName2 = headImageView.getUserName();
            if (TextUtils.isEmpty(userName2)) {
                if (userId != null && userId.length() > 0) {
                    com.baidu.adp.framework.c a = com.baidu.adp.framework.c.a();
                    activity2 = this.a.d;
                    a.a(new com.baidu.adp.framework.message.a(2001003, new ag(activity2, userId, userName)));
                }
            } else if (!userName2.equals("1") && !userName2.equals("2") && !userName2.equals("3") && userId != null && userId.length() > 0) {
                com.baidu.adp.framework.c a2 = com.baidu.adp.framework.c.a();
                activity = this.a.d;
                a2.a(new com.baidu.adp.framework.message.a(2001003, new ag(activity, userId, userName)));
            }
        }
    }
}
