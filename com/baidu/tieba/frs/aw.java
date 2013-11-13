package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.pb.ImagePbActivity;
/* loaded from: classes.dex */
class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1322a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(FrsImageActivity frsImageActivity) {
        this.f1322a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof com.baidu.tieba.data.bb)) {
            com.baidu.tieba.data.bb bbVar = (com.baidu.tieba.data.bb) view.getTag();
            FrsImageActivity frsImageActivity = this.f1322a;
            String d = bbVar.d();
            str = this.f1322a.b;
            ImagePbActivity.a(frsImageActivity, d, str, bbVar.c());
        }
    }
}
