package com.baidu.tieba.im.live.mylive;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ab;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ MyLiveNoDataView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MyLiveNoDataView myLiveNoDataView) {
        this.a = myLiveNoDataView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ab(this.a.getContext())));
    }
}
