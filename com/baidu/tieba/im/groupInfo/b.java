package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ ApplyJoinGroupActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.a = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.a.f)) {
                if (!UtilHelper.b()) {
                    this.a.showToast(R.string.neterror);
                    return;
                }
                ag agVar = new ag();
                agVar.b(com.baidu.adp.lib.f.b.a(this.a.k, 0));
                agVar.a(this.a.b.getText().toString());
                agVar.a(this.a.r);
                agVar.a(this.a.n);
                com.baidu.adp.lib.g.e.d("groupId:" + this.a.k + "userMsg:" + this.a.b.getContext().toString());
                this.a.f.setEnabled(false);
                com.baidu.tieba.im.messageCenter.e.a().a(agVar);
            } else if (view.equals(this.a.e)) {
                this.a.finish();
            }
        }
    }
}
