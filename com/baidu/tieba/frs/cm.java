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
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.ay)) {
            com.baidu.tieba.data.ay ayVar = (com.baidu.tieba.data.ay) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            com.baidu.tbadk.core.atomData.ad adVar = new com.baidu.tbadk.core.atomData.ad(this.a);
            String d = ayVar.d();
            str = this.a.f;
            frsImageActivity.sendMessage(new CustomMessage(2004002, adVar.a(d, str, ayVar.c())));
        }
    }
}
