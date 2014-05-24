package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class cm implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.at)) {
            com.baidu.tieba.data.at atVar = (com.baidu.tieba.data.at) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            com.baidu.tbadk.core.atomData.v vVar = new com.baidu.tbadk.core.atomData.v(this.a);
            String d = atVar.d();
            str = this.a.e;
            frsImageActivity.sendMessage(new CustomMessage(2006002, vVar.a(d, str, atVar.c())));
        }
    }
}
