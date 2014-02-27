package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class b implements View.OnClickListener {
    final /* synthetic */ ApplyJoinGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.a = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view != null) {
            if (view.equals(this.a.f)) {
                if (!UtilHelper.b()) {
                    this.a.showToast(R.string.neterror);
                    return;
                }
                ah ahVar = new ah();
                ahVar.b(com.baidu.adp.lib.f.b.a(this.a.k, 0));
                ahVar.a(this.a.b.getText().toString());
                ahVar.a(this.a.r);
                ahVar.a(this.a.n);
                com.baidu.adp.lib.util.e.e("groupId:" + this.a.k + "userMsg:" + this.a.b.getContext().toString());
                this.a.f.setEnabled(false);
                com.baidu.tieba.im.messageCenter.d.a().a(ahVar);
            } else if (view.equals(this.a.e)) {
                this.a.finish();
            }
        }
    }
}
