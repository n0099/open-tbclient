package com.baidu.tieba.im.live.mylive;

import android.widget.ProgressBar;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.live.p;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.y;
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
        boolean z;
        MyLiveActivity myLiveActivity;
        MyLiveActivity myLiveActivity2;
        MyLiveActivity myLiveActivity3;
        MyLiveActivity myLiveActivity4;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103104 && (socketResponsedMessage instanceof ResponseDismissGroupMessage)) {
            ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage;
            if (responseDismissGroupMessage.getError() > 0) {
                this.a.b(responseDismissGroupMessage.getErrorString());
            } else if (responseDismissGroupMessage.getError() >= 0) {
                i = this.a.i;
                if (i == 1) {
                    this.a.a(y.live_mylive_dismiss_success);
                    myLiveListAdapter = this.a.h;
                    liveCardData = this.a.k;
                    myLiveListAdapter.a(liveCardData);
                    z = this.a.j;
                    if (z) {
                        p a = p.a();
                        myLiveActivity4 = this.a.b;
                        a.a(myLiveActivity4);
                        this.a.j = false;
                    }
                    if (!this.a.i()) {
                        this.a.l();
                        return;
                    }
                    this.a.m();
                    myLiveActivity = this.a.b;
                    if (myLiveActivity != null) {
                        myLiveActivity2 = this.a.b;
                        if (myLiveActivity2.g() != null) {
                            myLiveActivity3 = this.a.b;
                            myLiveActivity3.g().a(false);
                        }
                    }
                }
            } else {
                this.a.a(y.neterror);
            }
        }
    }
}
