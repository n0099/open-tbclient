package com.baidu.tieba.frs;

import android.view.View;
import com.baidu.tieba.data.bn;
import com.baidu.tieba.pb.ImagePbActivity;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsImageActivity f1066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(FrsImageActivity frsImageActivity) {
        this.f1066a = frsImageActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        if (view.getTag() != null && (view.getTag() instanceof bn)) {
            bn bnVar = (bn) view.getTag();
            FrsImageActivity frsImageActivity = this.f1066a;
            String d = bnVar.d();
            str = this.f1066a.b;
            ImagePbActivity.a(frsImageActivity, d, str, bnVar.c());
        }
    }
}
