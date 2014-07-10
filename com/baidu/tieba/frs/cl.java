package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class cl implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.aw)) {
            com.baidu.tieba.data.aw awVar = (com.baidu.tieba.data.aw) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            com.baidu.tbadk.core.atomData.aa aaVar = new com.baidu.tbadk.core.atomData.aa(this.a);
            String d = awVar.d();
            str = this.a.e;
            frsImageActivity.sendMessage(new CustomMessage(2004002, aaVar.a(d, str, awVar.c())));
        }
    }
}
