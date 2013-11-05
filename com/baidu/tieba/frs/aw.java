package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.pb.ImagePbActivity;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1266a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsImageActivity frsImageActivity) {
        this.f1266a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.bg)) {
            com.baidu.tieba.data.bg bgVar = (com.baidu.tieba.data.bg) view.getTag();
            FrsImageActivity frsImageActivity = this.f1266a;
            String d = bgVar.d();
            str = this.f1266a.b;
            ImagePbActivity.a(frsImageActivity, d, str, bgVar.c());
        }
    }
}
