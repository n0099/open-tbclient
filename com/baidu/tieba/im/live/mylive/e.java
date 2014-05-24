package com.baidu.tieba.im.live.mylive;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.message.ResponseSubscribeLiveGroupMessage;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
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
        if (socketResponsedMessage.getCmd() == 107105) {
            if (!(socketResponsedMessage instanceof ResponseSubscribeLiveGroupMessage)) {
                this.a.a(y.neterror);
                return;
            }
            ResponseSubscribeLiveGroupMessage responseSubscribeLiveGroupMessage = (ResponseSubscribeLiveGroupMessage) socketResponsedMessage;
            if (responseSubscribeLiveGroupMessage.getError() == 0) {
                i = this.a.i;
                if (i == 2) {
                    this.a.a(y.live_mylive_canclmark_success);
                    myLiveListAdapter = this.a.h;
                    liveCardData = this.a.j;
                    myLiveListAdapter.a(liveCardData);
                }
            } else if (responseSubscribeLiveGroupMessage.getError() > 0) {
                if (!TextUtils.isEmpty(responseSubscribeLiveGroupMessage.getErrorString())) {
                    this.a.b(responseSubscribeLiveGroupMessage.getErrorString());
                }
            } else {
                this.a.a(y.neterror);
            }
        }
    }
}
