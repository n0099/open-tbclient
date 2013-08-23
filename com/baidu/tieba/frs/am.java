package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.frs.FrsImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1075a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(FrsImageActivity frsImageActivity) {
        this.f1075a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsImageActivity.FooterType footerType;
        int i;
        footerType = this.f1075a.f;
        if (footerType == FrsImageActivity.FooterType.NEXT) {
            FrsImageActivity frsImageActivity = this.f1075a;
            i = this.f1075a.j;
            frsImageActivity.f(i + 240);
        }
    }
}
