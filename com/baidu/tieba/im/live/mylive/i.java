package com.baidu.tieba.im.live.mylive;

import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.coreExtra.view.ab;
/* loaded from: classes.dex */
class i implements ab {
    final /* synthetic */ MyLiveListAdapter a;
    private final /* synthetic */ LiveCardData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MyLiveListAdapter myLiveListAdapter, LiveCardData liveCardData) {
        this.a = myLiveListAdapter;
        this.b = liveCardData;
    }

    @Override // com.baidu.tbadk.coreExtra.view.ab
    public void onClick(LiveBroadcastCard liveBroadcastCard) {
        MyLiveActivity myLiveActivity;
        myLiveActivity = this.a.a;
        myLiveActivity.a(this.b);
    }
}
