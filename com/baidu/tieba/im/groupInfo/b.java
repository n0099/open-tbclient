package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ApplyJoinGroupActivity f1676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.f1676a = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.f1676a.f)) {
                if (!UtilHelper.b()) {
                    this.f1676a.showToast(R.string.neterror);
                    return;
                }
                RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                requestJoinGroupMessage.setGroupId(this.f1676a.k);
                requestJoinGroupMessage.setUserMsg(this.f1676a.b.getText().toString());
                com.baidu.adp.lib.h.d.d("groupId:" + this.f1676a.k + "userMsg:" + this.f1676a.b.getContext().toString());
                this.f1676a.f.setEnabled(false);
                com.baidu.tieba.im.messageCenter.f.a().a(requestJoinGroupMessage);
            } else if (view.equals(this.f1676a.e)) {
                this.f1676a.finish();
            }
        }
    }
}
