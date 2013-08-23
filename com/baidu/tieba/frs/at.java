package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.data.bi;
import com.baidu.tieba.pb.ImagePbActivity;
/* loaded from: classes.dex */
class at implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1082a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(FrsImageActivity frsImageActivity) {
        this.f1082a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof bi)) {
            bi biVar = (bi) view.getTag();
            FrsImageActivity frsImageActivity = this.f1082a;
            String d = biVar.d();
            str = this.f1082a.b;
            ImagePbActivity.a(frsImageActivity, d, str, biVar.c());
        }
    }
}
