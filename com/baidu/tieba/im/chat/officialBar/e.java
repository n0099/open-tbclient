package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c a;
    private final /* synthetic */ t b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, t tVar) {
        this.a = cVar;
        this.b = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Context context2;
        Context context3;
        bq a = bq.a();
        context = this.a.a;
        a.a(context, new String[]{this.b.d});
        context2 = this.a.a;
        if (context2 instanceof OfficialBarChatActivity) {
            context3 = this.a.a;
            TiebaStatic.eventStat(context3, "official_msg_ck", "click", 1, "fid", this.b.e);
        }
    }
}
