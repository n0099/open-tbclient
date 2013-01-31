package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.a.aw;
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
        if (view.getTag() != null && (view.getTag() instanceof aw)) {
            aw awVar = (aw) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            String d = awVar.d();
            str = this.a.e;
            ImagePbActivity.a(frsImageActivity, d, str, awVar.c());
        }
    }
}
