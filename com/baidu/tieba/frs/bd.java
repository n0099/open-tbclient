package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.frs.FrsImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1330a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(FrsImageActivity frsImageActivity) {
        this.f1330a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsImageActivity.FooterType footerType;
        int i;
        footerType = this.f1330a.g;
        if (footerType == FrsImageActivity.FooterType.NEXT) {
            FrsImageActivity frsImageActivity = this.f1330a;
            i = this.f1330a.i;
            frsImageActivity.c(i + 240);
        }
    }
}
