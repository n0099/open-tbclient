package com.baidu.tieba.im.groupInfo;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ApplyJoinGroupActivity f1685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ApplyJoinGroupActivity applyJoinGroupActivity) {
        this.f1685a = applyJoinGroupActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != null) {
            if (view.equals(this.f1685a.f)) {
                if (!UtilHelper.b()) {
                    this.f1685a.showToast(R.string.neterror);
                    return;
                }
                RequestJoinGroupMessage requestJoinGroupMessage = new RequestJoinGroupMessage();
                requestJoinGroupMessage.setGroupId(this.f1685a.k);
                requestJoinGroupMessage.setUserMsg(this.f1685a.b.getText().toString());
                com.baidu.adp.lib.h.d.d("groupId:" + this.f1685a.k + "userMsg:" + this.f1685a.b.getContext().toString());
                this.f1685a.f.setEnabled(false);
                com.baidu.tieba.im.messageCenter.f.a().a(requestJoinGroupMessage);
            } else if (view.equals(this.f1685a.e)) {
                this.f1685a.finish();
            }
        }
    }
}
