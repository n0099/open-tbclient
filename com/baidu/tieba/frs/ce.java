package com.baidu.tieba.frs;

import android.content.Intent;
import android.view.View;
/* loaded from: classes.dex */
final class ce implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.ar)) {
            com.baidu.tieba.data.ar arVar = (com.baidu.tieba.data.ar) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            com.baidu.tbadk.core.b.s sVar = new com.baidu.tbadk.core.b.s(this.a);
            String d = arVar.d();
            str = this.a.b;
            String c = arVar.c();
            Intent d2 = sVar.d();
            d2.putExtra("thread_id", d);
            d2.putExtra("forum", str);
            d2.putExtra("title", c);
            frsImageActivity.sendMessage(new com.baidu.adp.framework.message.a(2004002, sVar));
        }
    }
}
