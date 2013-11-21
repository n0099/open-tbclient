package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.pb.ImagePbActivity;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsImageActivity frsImageActivity) {
        this.f1327a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.ba)) {
            com.baidu.tieba.data.ba baVar = (com.baidu.tieba.data.ba) view.getTag();
            FrsImageActivity frsImageActivity = this.f1327a;
            String d = baVar.d();
            str = this.f1327a.b;
            ImagePbActivity.a(frsImageActivity, d, str, baVar.c());
        }
    }
}
