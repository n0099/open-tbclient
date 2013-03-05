package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (TiebaApplication.b().k()) {
            StatService.onEvent(this.a, "frs_post_pic", "frsclick", 1);
        }
        this.a.d(1);
    }
}
