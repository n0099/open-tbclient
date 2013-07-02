package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.pb.ImagePbActivity;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.bb)) {
            com.baidu.tieba.data.bb bbVar = (com.baidu.tieba.data.bb) view.getTag();
            FrsImageActivity frsImageActivity = this.a;
            String d = bbVar.d();
            str = this.a.b;
            ImagePbActivity.a(frsImageActivity, d, str, bbVar.c());
        }
    }
}
