package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.a.at;
import com.baidu.tieba.pb.ImagePbActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() == null || !(view.getTag() instanceof at)) {
            return;
        }
        at atVar = (at) view.getTag();
        FrsImageActivity frsImageActivity = this.a;
        String d = atVar.d();
        str = this.a.d;
        ImagePbActivity.a(frsImageActivity, d, str, atVar.c());
    }
}
