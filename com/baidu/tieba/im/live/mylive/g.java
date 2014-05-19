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
        RequestDismissGroupMessage requestDismissGroupMessage = new RequestDismissGroupMessage();
        liveCardData = this.a.j;
        requestDismissGroupMessage.setGroupId(liveCardData.getGroupId());
        MessageManager.getInstance().sendMessage(requestDismissGroupMessage);
    }
}
