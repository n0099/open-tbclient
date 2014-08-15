package com.baidu.tieba.im.live.mylive;

import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.message.RequestDismissGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements DialogInterface.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        ProgressBar progressBar;
        LiveCardData liveCardData;
        dialogInterface.dismiss();
        progressBar = this.a.e;
        progressBar.setVisibility(0);
        liveCardData = this.a.k;
        int groupId = liveCardData.getGroupId();
        if (com.baidu.adp.lib.e.b.a(com.baidu.tieba.im.live.d.b().i(), 0) == groupId) {
            this.a.j = true;
        } else {
            this.a.j = false;
        }
        RequestDismissGroupMessage requestDismissGroupMessage = new RequestDismissGroupMessage();
        requestDismissGroupMessage.setGroupId(groupId);
        MessageManager.getInstance().sendMessage(requestDismissGroupMessage);
    }
}
