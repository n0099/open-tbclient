package com.baidu.tieba.im.live.mylive;

import android.widget.ProgressBar;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ProgressBar progressBar;
        int i;
        MyLiveListAdapter myLiveListAdapter;
        LiveCardData liveCardData;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103104 && (socketResponsedMessage instanceof ResponseDismissGroupMessage)) {
            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
            if (responseDismissGroupMessage.getError() > 0) {
                this.a.b(responseDismissGroupMessage.getErrorString());
            } else if (responseDismissGroupMessage.getError() >= 0) {
                i = this.a.i;
                if (i == 1) {
                    this.a.a(u.live_mylive_dismiss_success);
                    myLiveListAdapter = this.a.h;
                    liveCardData = this.a.j;
                    myLiveListAdapter.a(liveCardData);
                }
            } else {
                this.a.a(u.neterror);
            }
        }
    }
}
