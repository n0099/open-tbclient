package com.baidu.tieba.im.live.livenotify;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ LiveNotifyCardView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LiveNotifyCardView liveNotifyCardView) {
        this.a = liveNotifyCardView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        Context context;
        String str2;
        str = this.a.q;
        if (!TextUtils.isEmpty(str)) {
            context = this.a.a;
            str2 = this.a.q;
            com.baidu.tbadk.core.g.a(context, str2);
        }
        this.a.g();
    }
}
