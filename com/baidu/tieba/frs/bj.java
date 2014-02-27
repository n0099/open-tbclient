package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.pb.ImagePbActivity;
/* loaded from: classes.dex */
final class bj implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.ba)) {
            com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            String d = baVar.d();
            str = this.a.b;
            ImagePbActivity.a(frsImageActivity, d, str, baVar.c());
        }
    }
}
