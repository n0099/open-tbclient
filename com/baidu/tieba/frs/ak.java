package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.frs.FrsImageActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(FrsImageActivity frsImageActivity) {
        this.f1059a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FrsImageActivity.FooterType footerType;
        int i;
        footerType = this.f1059a.f;
        if (footerType == FrsImageActivity.FooterType.NEXT) {
            FrsImageActivity frsImageActivity = this.f1059a;
            i = this.f1059a.j;
            frsImageActivity.f(i + 240);
        }
    }
}
