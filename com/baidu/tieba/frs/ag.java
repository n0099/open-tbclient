package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.a.au;
import com.baidu.tieba.pb.ImagePbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof au)) {
            au auVar = (au) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            String d = auVar.d();
            str = this.a.e;
            ImagePbActivity.a(frsImageActivity, d, str, auVar.c());
        }
    }
}
