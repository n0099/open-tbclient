package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.SendForeNoticeRequestMessage;
/* loaded from: classes.dex */
class bt implements View.OnClickListener {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bp bpVar) {
        this.a = bpVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int groupId = this.a.b.x().c().getGroupId();
        String trim = this.a.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            this.a.b.showToast(com.baidu.tieba.y.remind_notice_not_null);
            return;
        }
        this.a.d.setEnabled(false);
        this.a.c.setEnabled(false);
        com.baidu.adp.lib.util.j.a(this.a.b, this.a.e);
        this.a.b.showProgressBar(true, 0, 0);
        MessageManager.getInstance().sendMessage(new SendForeNoticeRequestMessage(groupId, trim));
    }
}
