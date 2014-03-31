package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ ApplyJoinGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.a = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view != null) {
            if (view.equals(this.a.f)) {
                if (!UtilHelper.a()) {
                    this.a.showToast(com.baidu.tieba.im.j.neterror);
                    return;
                }
                am amVar = new am();
                amVar.e(com.baidu.adp.lib.f.b.a(this.a.k, 0));
                amVar.a(this.a.b.getText().toString());
                amVar.d(this.a.p);
                amVar.b(this.a.n);
                com.baidu.adp.lib.util.f.e("groupId:" + this.a.k + "userMsg:" + this.a.b.getContext().toString());
                this.a.f.setEnabled(false);
                this.a.sendMessage(amVar);
            } else if (view.equals(this.a.e)) {
                this.a.finish();
            }
        }
    }
}
