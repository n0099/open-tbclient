package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.frs.FrsImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {
    final /* synthetic */ FrsImageActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsImageActivity frsImageActivity) {
        this.a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsImageActivity.FooterType footerType;
        int i;
        footerType = this.a.f;
        if (footerType == FrsImageActivity.FooterType.NEXT) {
            FrsImageActivity frsImageActivity = this.a;
            i = this.a.j;
            frsImageActivity.e(i + 240);
        }
    }
}
